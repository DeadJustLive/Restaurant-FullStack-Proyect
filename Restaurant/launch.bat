@echo off
setlocal

:MENU
cls
echo.
echo ============================================
echo   Restaurant - MENU PRINCIPAL
echo ============================================
echo.
echo   [1] Iniciar todos los servicios (dev)
echo   [2] Iniciar todos los servicios (test)
echo   [3] Compilar microservicios
echo   [4] Reinstalar dependencias Maven
echo.
echo   --- Servicios individuales ---
echo   [5] Iniciar Eureka
echo   [6] Iniciar ms-auth
echo   [7] Iniciar ms-usuarios
echo   [8] Iniciar ms-sucursales
echo   [9] Iniciar ms-menu
echo   [10] Iniciar ms-categorias
echo   [11] Iniciar ms-carrito
echo   [12] Iniciar ms-pedidos
echo   [13] Iniciar ms-pagos
echo   [14] Iniciar ms-delivery
echo   [15] Iniciar ms-inventario
echo   [16] Iniciar ms-notificaciones
echo   [17] Iniciar ms-reportes
echo.
echo   [0] Salir
echo.
echo ============================================
set /p opcion="  Selecciona una opcion: "

if "%opcion%"=="1" goto RUN_ALL
if "%opcion%"=="2" goto RUN_TEST
if "%opcion%"=="3" goto COMPILE
if "%opcion%"=="4" goto INSTALL
if "%opcion%"=="5" goto RUN_EUREKA
if "%opcion%"=="6" goto RUN_AUTH
if "%opcion%"=="7" goto RUN_USUARIOS
if "%opcion%"=="8" goto RUN_SUCURSALES
if "%opcion%"=="9" goto RUN_MENU
if "%opcion%"=="10" goto RUN_CATEGORIAS
if "%opcion%"=="11" goto RUN_CARRITO
if "%opcion%"=="12" goto RUN_PEDIDOS
if "%opcion%"=="13" goto RUN_PAGOS
if "%opcion%"=="14" goto RUN_DELIVERY
if "%opcion%"=="15" goto RUN_INVENTARIO
if "%opcion%"=="16" goto RUN_NOTIFICACIONES
if "%opcion%"=="17" goto RUN_REPORTES
if "%opcion%"=="0" goto SALIR

echo.
echo   Opcion invalida. Intenta de nuevo.
timeout /t 2 /nobreak > nul
goto MENU

REM ============================================

:RUN_ALL
cls
echo.
echo ===== Iniciando Eureka Server =====
start "EUREKA" mvn -f eureka spring-boot:run
timeout /t 5 /nobreak > nul
echo ===== Iniciando Microservicios =====
start "MS-AUTH" mvn -f ms-auth spring-boot:run
start "MS-USUARIOS" mvn -f ms-usuarios spring-boot:run
start "MS-SUCURSALES" mvn -f ms-sucursales spring-boot:run
start "MS-MENU" mvn -f ms-menu spring-boot:run
start "MS-CATEGORIAS" mvn -f ms-categorias spring-boot:run
start "MS-CARRITO" mvn -f ms-carrito spring-boot:run
start "MS-PEDIDOS" mvn -f ms-pedidos spring-boot:run
start "MS-PAGOS" mvn -f ms-pagos spring-boot:run
start "MS-DELIVERY" mvn -f ms-delivery spring-boot:run
start "MS-INVENTARIO" mvn -f ms-inventario spring-boot:run
start "MS-NOTIFICACIONES" mvn -f ms-notificaciones spring-boot:run
start "MS-REPORTES" mvn -f ms-reportes spring-boot:run
echo Todos los servicios han sido lanzados.
pause
goto MENU

:RUN_TEST
cls
echo.
echo ===== Iniciando Eureka Server (test) =====
start "EUREKA" java -jar eureka\target\cl-triskeledu-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=test
timeout /t 5 /nobreak > nul
echo ===== Iniciando Microservicios (test) =====
start "MS-AUTH" java -jar ms-auth\\target\\cl-triskeledu-auth-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
start "MS-USUARIOS" java -jar ms-usuarios\\target\\cl-triskeledu-usuarios-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
start "MS-SUCURSALES" java -jar ms-sucursales\\target\\cl-triskeledu-sucursales-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
start "MS-MENU" java -jar ms-menu\\target\\cl-triskeledu-menu-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
start "MS-CATEGORIAS" java -jar ms-categorias\\target\\cl-triskeledu-categorias-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
start "MS-CARRITO" java -jar ms-carrito\\target\\cl-triskeledu-carrito-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
start "MS-PEDIDOS" java -jar ms-pedidos\\target\\cl-triskeledu-pedidos-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
start "MS-PAGOS" java -jar ms-pagos\\target\\cl-triskeledu-pagos-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
start "MS-DELIVERY" java -jar ms-delivery\\target\\cl-triskeledu-delivery-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
start "MS-INVENTARIO" java -jar ms-inventario\\target\\cl-triskeledu-inventario-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
start "MS-NOTIFICACIONES" java -jar ms-notificaciones\\target\\cl-triskeledu-notificaciones-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
start "MS-REPORTES" java -jar ms-reportes\\target\\cl-triskeledu-reportes-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
echo Todos los servicios han sido lanzados en modo test.
pause
goto MENU

:COMPILE
cls
echo.
echo ===== Compilando microservicios =====
cd /d C:\Restaurant\ms-auth
call mvn clean install -U
cd /d C:\Restaurant\ms-usuarios
call mvn clean install -U
cd /d C:\Restaurant\ms-sucursales
call mvn clean install -U
cd /d C:\Restaurant\ms-menu
call mvn clean install -U
cd /d C:\Restaurant\ms-categorias
call mvn clean install -U
cd /d C:\Restaurant\ms-carrito
call mvn clean install -U
cd /d C:\Restaurant\ms-pedidos
call mvn clean install -U
cd /d C:\Restaurant\ms-pagos
call mvn clean install -U
cd /d C:\Restaurant\ms-delivery
call mvn clean install -U
cd /d C:\Restaurant\ms-inventario
call mvn clean install -U
cd /d C:\Restaurant\ms-notificaciones
call mvn clean install -U
cd /d C:\Restaurant\ms-reportes
call mvn clean install -U
echo Compilacion completada.
pause
goto MENU

:INSTALL
cls
echo.
echo === REINSTALACION DE DEPENDENCIAS MAVEN ===
echo.
echo Eliminando carpeta .m2 ...
rmdir /s /q %USERPROFILE%\.m2
echo Eliminando carpetas target ...
rmdir /s /q C:\Restaurant\eureka\target
rmdir /s /q C:\Restaurant\ms-auth\target
rmdir /s /q C:\Restaurant\ms-usuarios\target
rmdir /s /q C:\Restaurant\ms-sucursales\target
rmdir /s /q C:\Restaurant\ms-menu\target
rmdir /s /q C:\Restaurant\ms-categorias\target
rmdir /s /q C:\Restaurant\ms-carrito\target
rmdir /s /q C:\Restaurant\ms-pedidos\target
rmdir /s /q C:\Restaurant\ms-pagos\target
rmdir /s /q C:\Restaurant\ms-delivery\target
rmdir /s /q C:\Restaurant\ms-inventario\target
rmdir /s /q C:\Restaurant\ms-notificaciones\target
rmdir /s /q C:\Restaurant\ms-reportes\target
echo Descargando dependencias nuevamente con Maven ...
mvn clean install -U -DskipTests
echo.
echo === PROCESO COMPLETADO ===
pause
goto MENU

:RUN_EUREKA
cls
echo.
echo ===== Iniciando Eureka =====
start "EUREKA" mvn -f eureka spring-boot:run
echo Eureka iniciado.
pause
goto MENU

:RUN_AUTH
cls
echo.
echo ===== Iniciando ms-auth =====
start "MS-AUTH" mvn -f ms-auth spring-boot:run
echo ms-auth iniciado.
pause
goto MENU

:RUN_USUARIOS
cls
echo.
echo ===== Iniciando ms-usuarios =====
start "MS-USUARIOS" mvn -f ms-usuarios spring-boot:run
echo ms-usuarios iniciado.
pause
goto MENU

:RUN_SUCURSALES
cls
echo.
echo ===== Iniciando ms-sucursales =====
start "MS-SUCURSALES" mvn -f ms-sucursales spring-boot:run
echo ms-sucursales iniciado.
pause
goto MENU

:RUN_MENU
cls
echo.
echo ===== Iniciando ms-menu =====
start "MS-MENU" mvn -f ms-menu spring-boot:run
echo ms-menu iniciado.
pause
goto MENU

:RUN_CATEGORIAS
cls
echo.
echo ===== Iniciando ms-categorias =====
start "MS-CATEGORIAS" mvn -f ms-categorias spring-boot:run
echo ms-categorias iniciado.
pause
goto MENU

:RUN_CARRITO
cls
echo.
echo ===== Iniciando ms-carrito =====
start "MS-CARRITO" mvn -f ms-carrito spring-boot:run
echo ms-carrito iniciado.
pause
goto MENU

:RUN_PEDIDOS
cls
echo.
echo ===== Iniciando ms-pedidos =====
start "MS-PEDIDOS" mvn -f ms-pedidos spring-boot:run
echo ms-pedidos iniciado.
pause
goto MENU

:RUN_PAGOS
cls
echo.
echo ===== Iniciando ms-pagos =====
start "MS-PAGOS" mvn -f ms-pagos spring-boot:run
echo ms-pagos iniciado.
pause
goto MENU

:RUN_DELIVERY
cls
echo.
echo ===== Iniciando ms-delivery =====
start "MS-DELIVERY" mvn -f ms-delivery spring-boot:run
echo ms-delivery iniciado.
pause
goto MENU

:RUN_INVENTARIO
cls
echo.
echo ===== Iniciando ms-inventario =====
start "MS-INVENTARIO" mvn -f ms-inventario spring-boot:run
echo ms-inventario iniciado.
pause
goto MENU

:RUN_NOTIFICACIONES
cls
echo.
echo ===== Iniciando ms-notificaciones =====
start "MS-NOTIFICACIONES" mvn -f ms-notificaciones spring-boot:run
echo ms-notificaciones iniciado.
pause
goto MENU

:RUN_REPORTES
cls
echo.
echo ===== Iniciando ms-reportes =====
start "MS-REPORTES" mvn -f ms-reportes spring-boot:run
echo ms-reportes iniciado.
pause
goto MENU

:SALIR
cls
echo.
echo   Hasta luego.
echo.
endlocal
exit /b
