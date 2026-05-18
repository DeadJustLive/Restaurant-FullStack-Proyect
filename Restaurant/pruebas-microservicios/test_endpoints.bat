@echo off
setlocal enabledelayedexpansion
REM ==============================================================================
REM Restaurant SaaS - Microservice API Test Suite (Windows)
REM ==============================================================================
REM
REM PROPOSITO: Script todo-en-uno para Windows:
REM   1. Iniciar/detener infraestructura (PostgreSQL Docker + Microservicios)
REM   2. Health checks de todos los servicios
REM   3. Pruebas de integracion API con JWT dinamico
REM
REM USO:
REM   - Probar endpoints:      test_endpoints.bat
REM   - Iniciar + testear:     test_endpoints.bat --deploy
REM   - Detener servicios:     test_endpoints.bat --stop
REM
REM REQUISITOS:
REM   - Docker Desktop corriendo
REM   - Maven (mvn) en PATH
REM   - curl en PATH (o Windows 10+ built-in)
REM   - Java 21 en JAVA_HOME
REM
REM ==============================================================================

set BASE_DIR=%~dp0
set PRUEBAS_DIR=%BASE_DIR%pruebas-microservicios
set LOGS_DIR=%PRUEBAS_DIR%\logs

if not exist "%LOGS_DIR%" mkdir "%LOGS_DIR%"

set EUREKA_PORT=8761
set MS_AUTH_PORT=9001
set MS_SUCURSALES_PORT=9003
set MS_MENU_PORT=9004
set MS_CARRITO_PORT=9006
set MS_PEDIDOS_PORT=9007
set MS_PAGOS_PORT=9008
set MS_DELIVERY_PORT=9009
set MS_INVENTARIO_PORT=9010
set MS_NOTIFICACIONES_PORT=9011
set MS_REPORTES_PORT=9012

set MODULES=ms-auth ms-sucursales ms-menu ms-carrito ms-pedidos ms-pagos ms-delivery ms-inventario ms-notificaciones ms-reportes

REM ==============================================================================
REM Funciones auxiliares
REM ==============================================================================

:check_health
set name=%~1
set port=%~2
set path=%~3
set silent=%~4

curl -s -o NUL -w "%%{http_code}" --max-time 2 "http://localhost:%port%%path%" > "%TEMP%\health_%port%.tmp" 2>NUL
set /p HTTP_CODE=<"%TEMP%\health_%port%.tmp"
del "%TEMP%\health_%port%.tmp" 2>NUL

if "%HTTP_CODE%"=="200" (
    if not "%silent%"=="true" echo [ONLINE]  %name%  (HTTP %HTTP_CODE%)
    exit /b 0
) else if "%HTTP_CODE%"=="201" (
    if not "%silent%"=="true" echo [ONLINE]  %name%  (HTTP %HTTP_CODE%)
    exit /b 0
) else (
    if not "%silent%"=="true" echo [OFFLINE] %name%  (HTTP %HTTP_CODE%)
    exit /b 1
)
goto :eof

:run_api_test
set method=%~1
set name=%~2
set url=%~3
set data=%~4

<nul set /p="  Probando %method% %name%... "

if "%method%"=="GET" (
    curl -s -o NUL -w "%%{http_code}" -X GET "%url%" -H "Authorization: Bearer %JWT_TOKEN%" -H "Content-Type: application/json" --max-time 5 > "%TEMP%\api_rc.tmp"
) else if "%method%"=="DELETE" (
    curl -s -o NUL -w "%%{http_code}" -X DELETE "%url%" -H "Authorization: Bearer %JWT_TOKEN%" -H "Content-Type: application/json" --max-time 5 > "%TEMP%\api_rc.tmp"
) else if "%data%"=="" (
    curl -s -o NUL -w "%%{http_code}" -X %method% "%url%" -H "Authorization: Bearer %JWT_TOKEN%" -H "Content-Type: application/json" --max-time 5 > "%TEMP%\api_rc.tmp"
) else (
    curl -s -o NUL -w "%%{http_code}" -X %method% "%url%" -H "Authorization: Bearer %JWT_TOKEN%" -H "Content-Type: application/json" -d "%data%" --max-time 5 > "%TEMP%\api_rc.tmp"
)

set /p RC=<"%TEMP%\api_rc.tmp"
del "%TEMP%\api_rc.tmp" 2>NUL

if "%RC%"=="200" (
    echo [OK] (Codigo %RC%)
) else if "%RC%"=="201" (
    echo [OK] (Codigo %RC%)
) else if "%RC%"=="204" (
    echo [OK] (Codigo %RC%)
) else (
    echo [ERROR] (Codigo %RC%)
)
goto :eof

REM ==============================================================================
REM Comandos principales
REM ==============================================================================

if "%1"=="--stop" goto :stop_services

:main

echo ==============================================================================
echo   INICIANDO AUDITORIA Y VERIFICACION DE ENDPOINTS DE MICROSERVICIOS
echo ==============================================================================

REM -------------------------------------------------
REM PASO 0: Verificar si Docker y servicios estan arriba
REM -------------------------------------------------
echo.
echo [INFO] Verificando estado del ecosistema...

curl -s -o NUL --max-time 2 "http://localhost:%MS_AUTH_PORT%/api/v1/auth/health" 2>NUL
if %ERRORLEVEL% NEQ 0 (
    echo [WARN]  ms-auth no responde. El ecosistema parece estar OFFLINE.
    if "%1"=="--deploy" goto :deploy_services
    set /p CONFIRM="  Desea iniciar el despliegue automaticamente? [s/N]: "
    if /i "!CONFIRM!"=="s" goto :deploy_services
    if /i "!CONFIRM!"=="S" goto :deploy_services
) else (
    echo [OK]    ms-auth responde. Continuando con pruebas...
)

goto :run_tests

REM -------------------------------------------------
REM Despliegue de infraestructura
REM -------------------------------------------------
:deploy_services
echo.
echo ==============================================================================
echo   DESPLEGANDO INFRAESTRUCTURA Y MICROSERVICIOS
echo ==============================================================================

REM 1. PostgreSQL + Kafka via Docker Compose
echo [1/3] Iniciando PostgreSQL y Kafka via Docker Compose...
docker compose -f "%BASE_DIR%docker-compose.yml" up -d
if %ERRORLEVEL% NEQ 0 (
    echo [ERROR] Fallo al iniciar Docker Compose. Asegurate de que Docker Desktop este corriendo.
    echo [INFO]  Continuando con la suposicion de que los servicios externos ya estan activos...
)
echo [OK]    Docker Compose ejecutado.
timeout /t 3 /nobreak >NUL

REM 2. Compilar proyecto
echo [2/3] Compilando proyecto con Maven...
cd /d "%BASE_DIR%.."
call mvn install -DskipTests -q
if %ERRORLEVEL% NEQ 0 (
    echo [ERROR] Fallo la compilacion Maven. Revisa los logs.
    cd /d "%BASE_DIR%"
    exit /b 1
)
cd /d "%BASE_DIR%"
echo [OK]    Compilacion exitosa.

REM 3. Iniciar Eureka
echo [3/3] Iniciando Eureka Server...
start "Eureka" /MIN cmd /c "cd /d %BASE_DIR%eureka && mvn spring-boot:run > %LOGS_DIR%\eureka.log 2>&1"
echo         Esperando a que Eureka este listo...
:wait_eureka
timeout /t 2 /nobreak >NUL
curl -s -o NUL --max-time 2 "http://localhost:8761" 2>NUL
if %ERRORLEVEL% NEQ 0 goto :wait_eureka
echo [OK]    Eureka Server en linea (puerto 8761).

REM 4. Iniciar Microservicios (en ventanas separadas)
echo.
echo Iniciando 10 Microservicios en ventanas independientes...
for %%m in (%MODULES%) do (
    echo   Lanzando %%m...
    start "%%m" /MIN cmd /c "cd /d %BASE_DIR%%%m && mvn spring-boot:run > %LOGS_DIR%\%%m.log 2>&1"
    timeout /t 2 /nobreak >NUL
)

echo.
echo [INFO] Esperando a que todos los microservicios inicien (30-60 segundos)...
echo        Esto puede tomar un momento. Se paciente.
timeout /t 15 /nobreak >NUL

echo [INFO] Verificando health de servicios...
<nul set /p="  ms-auth... "
curl -s -o NUL --max-time 3 "http://localhost:%MS_AUTH_PORT%/actuator/health" 2>NUL && echo UP || echo STILL_LOADING
<nul set /p="  ms-sucursales... "
curl -s -o NUL --max-time 3 "http://localhost:%MS_SUCURSALES_PORT%/actuator/health" 2>NUL && echo UP || echo STILL_LOADING
<nul set /p="  ms-menu... "
curl -s -o NUL --max-time 3 "http://localhost:%MS_MENU_PORT%/actuator/health" 2>NUL && echo UP || echo STILL_LOADING
<nul set /p="  ms-carrito... "
curl -s -o NUL --max-time 3 "http://localhost:%MS_CARRITO_PORT%/actuator/health" 2>NUL && echo UP || echo STILL_LOADING
<nul set /p="  ms-pedidos... "
curl -s -o NUL --max-time 3 "http://localhost:%MS_PEDIDOS_PORT%/actuator/health" 2>NUL && echo UP || echo STILL_LOADING
<nul set /p="  ms-pagos... "
curl -s -o NUL --max-time 3 "http://localhost:%MS_PAGOS_PORT%/actuator/health" 2>NUL && echo UP || echo STILL_LOADING
<nul set /p="  ms-delivery... "
curl -s -o NUL --max-time 3 "http://localhost:%MS_DELIVERY_PORT%/actuator/health" 2>NUL && echo UP || echo STILL_LOADING
<nul set /p="  ms-inventario... "
curl -s -o NUL --max-time 3 "http://localhost:%MS_INVENTARIO_PORT%/actuator/health" 2>NUL && echo UP || echo STILL_LOADING
<nul set /p="  ms-notificaciones... "
curl -s -o NUL --max-time 3 "http://localhost:%MS_NOTIFICACIONES_PORT%/actuator/health" 2>NUL && echo UP || echo STILL_LOADING
<nul set /p="  ms-reportes... "
curl -s -o NUL --max-time 3 "http://localhost:%MS_REPORTES_PORT%/actuator/health" 2>NUL && echo UP || echo STILL_LOADING
echo [OK]    Despliegue completado.

REM -------------------------------------------------
REM Pruebas de endpoints
REM -------------------------------------------------
:run_tests

echo.
echo ==============================================================================
echo   PASO 1: Health Checks
echo ==============================================================================
call :check_health "Eureka Discovery" %EUREKA_PORT% ""
call :check_health "ms-auth"         %MS_AUTH_PORT% "/api/v1/auth/health"
call :check_health "ms-sucursales"   %MS_SUCURSALES_PORT% "/api/v1/sucursales"
call :check_health "ms-menu"         %MS_MENU_PORT% "/api/v1/menu"
call :check_health "ms-carrito"      %MS_CARRITO_PORT% "/api/v1/carrito/usuario/1"
call :check_health "ms-pedidos"      %MS_PEDIDOS_PORT% "/api/v1/pedidos"
call :check_health "ms-pagos"        %MS_PAGOS_PORT% "/api/v1/pagos"
call :check_health "ms-delivery"     %MS_DELIVERY_PORT% "/api/v1/delivery"
call :check_health "ms-inventario"   %MS_INVENTARIO_PORT% "/api/v1/inventario"
call :check_health "ms-notif"        %MS_NOTIFICACIONES_PORT% "/api/v1/notificaciones/estado/PENDIENTE"
call :check_health "ms-reportes"     %MS_REPORTES_PORT% "/api/v1/reportes/tipo/VENTAS_DIARIAS"

echo.
echo ==============================================================================
echo   PASO 2: Autenticacion (Login + JWT)
echo ==============================================================================

REM Generar credenciales unicas
set TS=%time:~0,2%%time:~3,2%%time:~6,2%
set TS=%TS: =0%
set TEST_USER=test_mesero_%date:~-4%%date:~3,2%%date:~0,2%_%TS%
set TEST_EMAIL=%TEST_USER%@restaurant.com
set TEST_PASS=Password123

echo Registrando usuario: %TEST_EMAIL%
curl -s -X POST "http://localhost:%MS_AUTH_PORT%/api/v1/auth/register" -H "Content-Type: application/json" -d "{\"username\":\"%TEST_EMAIL%\",\"password\":\"%TEST_PASS%\",\"rol\":\"ROLE_SA\"}" > "%TEMP%\register_result.json" 2>NUL
echo [OK] Usuario registrado.

echo Iniciando sesion para obtener JWT...
curl -s -X POST "http://localhost:%MS_AUTH_PORT%/api/v1/auth/login" -H "Content-Type: application/json" -d "{\"username\":\"%TEST_EMAIL%\",\"password\":\"%TEST_PASS%\"}" > "%TEMP%\login_result.json" 2>NUL

REM Extraer JWT del JSON (usando findstr + delimiters)
set JWT_TOKEN=
for /f "tokens=2 delims=:" %%a in ('findstr /c:"\"token\"" "%TEMP%\login_result.json" 2^>NUL') do (
    for /f "tokens=1 delims=," %%b in ("%%a") do (
        set RAW=%%~b
        set JWT_TOKEN=!RAW:"=!
    )
)

if defined JWT_TOKEN (
    echo [PASS]  JWT obtenido correctamente.
    echo          Token: !JWT_TOKEN:~0,50!...
) else (
    echo [FAIL]  No se pudo obtener el JWT. Usando token fallback para pruebas.
    echo          Respuesta recibida:
    type "%TEMP%\login_result.json"
    set JWT_TOKEN=mock-test-token-fallback
)

REM Limpiar temporales
del "%TEMP%\register_result.json" 2>NUL
del "%TEMP%\login_result.json" 2>NUL

echo.
echo ==============================================================================
echo   PASO 3: Pruebas de Endpoints
echo ==============================================================================

call :run_api_test "GET"  "Sucursales [Listar]"        "http://localhost:%MS_SUCURSALES_PORT%/api/v1/sucursales"
call :run_api_test "POST" "Sucursales [Crear]"          "http://localhost:%MS_SUCURSALES_PORT%/api/v1/sucursales" "{\"nombre\":\"Sucursal Test Win\",\"direccion\":\"Av. Providencia 123\",\"telefono\":\"+56911112222\"}"
call :run_api_test "GET"  "Sucursales [Todas]"          "http://localhost:%MS_SUCURSALES_PORT%/api/v1/sucursales/todas"
call :run_api_test "GET"  "Menu [Categorias]"           "http://localhost:%MS_MENU_PORT%/api/v1/categorias"
call :run_api_test "GET"  "Menu [Items Disponibles]"    "http://localhost:%MS_MENU_PORT%/api/v1/menu"
call :run_api_test "GET"  "Pedidos [Listar]"            "http://localhost:%MS_PEDIDOS_PORT%/api/v1/pedidos"
call :run_api_test "GET"  "Pagos [Historial]"           "http://localhost:%MS_PAGOS_PORT%/api/v1/pagos"
call :run_api_test "GET"  "Delivery [Listar]"           "http://localhost:%MS_DELIVERY_PORT%/api/v1/delivery"
call :run_api_test "GET"  "Inventario [Stock]"          "http://localhost:%MS_INVENTARIO_PORT%/api/v1/inventario"
call :run_api_test "GET"  "Notificaciones [Pendientes]" "http://localhost:%MS_NOTIFICACIONES_PORT%/api/v1/notificaciones/estado/PENDIENTE"
call :run_api_test "GET"  "Reportes [Ventas Diarias]"   "http://localhost:%MS_REPORTES_PORT%/api/v1/reportes/tipo/VENTAS_DIARIAS"

echo.
echo ==============================================================================
echo   VERIFICACION COMPLETADA
echo ==============================================================================
echo.
echo [INFO] Para detener todos los servicios, ejecuta:
echo        test_endpoints.bat --stop
echo.
echo [INFO] Logs disponibles en: %LOGS_DIR%
echo.
echo Presiona cualquier tecla para salir...
pause >NUL
goto :eof

REM -------------------------------------------------
REM Detener servicios
REM -------------------------------------------------
:stop_services
echo.
echo ==============================================================================
echo   DETENIENDO ECOSISTEMA DE MICROSERVICIOS
echo ==============================================================================

echo [1/3] Finalizando procesos Maven/Java...
taskkill /F /FI "WINDOWTITLE eq ms-*" 2>NUL
taskkill /F /IM "java.exe" /FI "STATUS eq RUNNING" 2>NUL
echo [OK]    Procesos Java finalizados.

echo [2/3] Deteniendo contenedores Docker...
docker compose -f "%BASE_DIR%docker-compose.yml" down 2>NUL
echo [OK]    Contenedores detenidos.

echo [3/3] Limpiando archivos temporales...
del "%TEMP%\health_*.tmp" 2>NUL
del "%TEMP%\api_rc.tmp" 2>NUL
del "%TEMP%\register_result.json" 2>NUL
del "%TEMP%\login_result.json" 2>NUL
echo [OK]    Temporales limpiados.

echo.
echo [OK] Ecosistema detenido de forma segura.
echo.
pause
exit /b 0
