@echo off
setlocal enabledelayedexpansion

set "SCRIPT_DIR=%~dp0"
set "SCRIPT_DIR=%SCRIPT_DIR:~0,-1%"
set "PROJECT_ROOT=%SCRIPT_DIR%\.."
set "LOG_DIR=%SCRIPT_DIR%\logs"
set "SKIP_DOCKER=0"
set "SKIP_COMPILE=0"
set "SKIP_FRONTEND=0"
set "ONLY_MODE=0"

:PARSE_ARGS
if "%~1"=="" goto END_PARSE
if /i "%~1"=="--no-docker" (
    set "SKIP_DOCKER=1"
    shift
    goto PARSE_ARGS
)
if /i "%~1"=="--no-compile" (
    set "SKIP_COMPILE=1"
    shift
    goto PARSE_ARGS
)
if /i "%~1"=="--no-frontend" (
    set "SKIP_FRONTEND=1"
    shift
    goto PARSE_ARGS
)
if /i "%~1"=="--only" (
    set "ONLY_MODE=1"
    set "ONLY_SERVICES=%~2"
    shift
    shift
    goto PARSE_ARGS
)
if /i "%~1"=="-h" goto USAGE
if /i "%~1"=="--help" goto USAGE
echo Unknown option: %~1
goto USAGE

:END_PARSE

if not exist "%LOG_DIR%" mkdir "%LOG_DIR%"

echo.
echo   ============================================
echo   ^|  Restaurant Microservices Launcher       ^|
echo   ============================================
echo.

:DOCKER
if %SKIP_DOCKER%==1 (
    echo [WARN] Skipping Docker (--no-docker^)
    goto COMPILE
)
echo [INFO] Starting Docker infrastructure...
cd /d "%SCRIPT_DIR%"
docker-compose up -d
if errorlevel 1 (
    echo [ERROR] docker-compose failed. Use --no-docker to skip.
    pause
    exit /b 1
)
echo [INFO] Waiting for PostgreSQL...
set PG_READY=0
for /L %%i in (1,1,30) do (
    if !PG_READY!==0 (
        docker exec restaurant-postgres pg_isready -U postgres >nul 2>&1
        if !errorlevel!==0 (
            set PG_READY=1
            echo [OK] PostgreSQL is ready
        ) else (
            timeout /t 2 /nobreak >nul
        )
    )
)
if !PG_READY!==0 (
    echo [ERROR] PostgreSQL did not become ready in time
    pause
    exit /b 1
)
echo [INFO] Waiting for Kafka...
timeout /t 10 /nobreak >nul
echo [OK] Kafka should be ready

:COMPILE
if %SKIP_COMPILE%==1 (
    echo [WARN] Skipping compilation (--no-compile^)
    goto EUREKA
)
echo [INFO] Compiling project...
cd /d "%SCRIPT_DIR%"
call mvn clean install -DskipTests -q
if errorlevel 1 (
    echo [ERROR] Maven compilation failed.
    pause
    exit /b 1
)
echo [OK] Project compiled successfully

:EUREKA
call :SHOULD_START "eureka"
if "!START_THIS!"=="0" goto SERVICES

echo [INFO] Starting Eureka Server...
set "EUREKA_JAR="
for %%f in ("%SCRIPT_DIR%\eureka\target\*-SNAPSHOT.jar") do (
    echo %%~nxf | findstr /i "sources javadoc" >nul || set "EUREKA_JAR=%%f"
)
if "%EUREKA_JAR%"=="" (
    echo [ERROR] Eureka JAR not found. Did you compile?
    pause
    exit /b 1
)
start "EUREKA" /d "%SCRIPT_DIR%" cmd /c "java -jar "%EUREKA_JAR%" > "%LOG_DIR%\eureka.log" 2>&1"

echo [INFO] Waiting for Eureka on port 8761...
set EU_READY=0
for /L %%i in (1,1,90) do (
    if !EU_READY!==0 (
        curl -sf http://localhost:8761 >nul 2>&1
        if !errorlevel!==0 (
            set EU_READY=1
            echo [OK] Eureka is UP on port 8761
        ) else (
            timeout /t 1 /nobreak >nul
        )
    )
)
if !EU_READY!==0 (
    echo [ERROR] Eureka did not start in time
    pause
    exit /b 1
)

:SERVICES
call :SHOULD_START "ms-auth"
if "!START_THIS!"=="1" call :START_SERVICE "ms-auth" "9001"

call :SHOULD_START "ms-sucursales"
if "!START_THIS!"=="1" call :START_SERVICE "ms-sucursales" "9003"

call :SHOULD_START "ms-menu"
if "!START_THIS!"=="1" call :START_SERVICE "ms-menu" "9004"

call :SHOULD_START "ms-carrito"
if "!START_THIS!"=="1" call :START_SERVICE "ms-carrito" "9006"

call :SHOULD_START "ms-pedidos"
if "!START_THIS!"=="1" call :START_SERVICE "ms-pedidos" "9007"

call :SHOULD_START "ms-pagos"
if "!START_THIS!"=="1" call :START_SERVICE "ms-pagos" "9008"

call :SHOULD_START "ms-delivery"
if "!START_THIS!"=="1" call :START_SERVICE "ms-delivery" "9009"

call :SHOULD_START "ms-inventario"
if "!START_THIS!"=="1" call :START_SERVICE "ms-inventario" "9010"

call :SHOULD_START "ms-notificaciones"
if "!START_THIS!"=="1" call :START_SERVICE "ms-notificaciones" "9011"

call :SHOULD_START "ms-reportes"
if "!START_THIS!"=="1" call :START_SERVICE "ms-reportes" "9012"

:FRONTEND
if %SKIP_FRONTEND%==1 (
    echo [WARN] Skipping frontend (--no-frontend^)
    goto STATUS
)
call :SHOULD_START "frontend"
if "!START_THIS!"=="0" goto STATUS

if not exist "%PROJECT_ROOT%\Front-end\package.json" (
    echo [WARN] Front-end directory not found at %PROJECT_ROOT%\Front-end
    goto STATUS
)
echo [INFO] Starting Frontend...
cd /d "%PROJECT_ROOT%\Front-end"
call npm install > "%LOG_DIR%\frontend-npm.log" 2>&1
start "FRONTEND" cmd /c "cd /d "%PROJECT_ROOT%\Front-end" && npx vite --port 5173 > "%LOG_DIR%\frontend.log" 2>&1"
echo [OK] Frontend launched on port 5173

:STATUS
echo.
echo ============================================
echo   Restaurant Microservices Status
echo ============================================
echo.

call :DISPLAY_STATUS "Eureka"          "8761"
call :DISPLAY_STATUS "ms-auth"         "9001"
call :DISPLAY_STATUS "ms-sucursales"   "9003"
call :DISPLAY_STATUS "ms-menu"         "9004"
call :DISPLAY_STATUS "ms-carrito"      "9006"
call :DISPLAY_STATUS "ms-pedidos"      "9007"
call :DISPLAY_STATUS "ms-pagos"        "9008"
call :DISPLAY_STATUS "ms-delivery"     "9009"
call :DISPLAY_STATUS "ms-inventario"   "9010"
call :DISPLAY_STATUS "ms-notificaciones" "9011"
call :DISPLAY_STATUS "ms-reportes"     "9012"
if %SKIP_FRONTEND%==0 call :DISPLAY_STATUS "Frontend" "5173"

echo.
echo Logs directory: %LOG_DIR%\
echo Press any key to exit (services will keep running in their windows^)
pause >nul
goto :EOF

:START_SERVICE
set "SVC=%~1"
set "PORT=%~2"
echo [INFO] Starting %SVC% on port %PORT%...
set "SVC_JAR="
for %%f in ("%SCRIPT_DIR%\%SVC%\target\*-SNAPSHOT.jar") do (
    echo %%~nxf | findstr /i "sources javadoc" >nul || set "SVC_JAR=%%f"
)
if "%SVC_JAR%"=="" (
    echo [ERROR] %SVC% JAR not found. Did you compile?
    goto :EOF
)
start "%SVC%" /d "%SCRIPT_DIR%" cmd /c "java -jar "%SVC_JAR%" > "%LOG_DIR%\%SVC%.log" 2>&1"
echo [OK] %SVC% launched
goto :EOF

:DISPLAY_STATUS
set "SNAME=%~1"
set "SPORT=%~2"
curl -sf http://localhost:%SPORT% >nul 2>&1
if !errorlevel!==0 (
    echo   [OK]   %-22s port %SPORT% - UP
) else (
    echo   [FAIL] %-22s port %SPORT% - DOWN
)
goto :EOF

:SHOULD_START
set "SVC_NAME=%~1"
set "START_THIS=1"
if %ONLY_MODE%==0 goto :EOF
echo %ONLY_SERVICES% | findstr /i /c:"%SVC_NAME%" >nul
if errorlevel 1 (
    set "START_THIS=0"
) else (
    set "START_THIS=1"
)
goto :EOF

:USAGE
echo.
echo Usage: launch.bat [OPTIONS]
echo.
echo Options:
echo   --no-docker      Skip docker-compose step
echo   --no-compile     Skip Maven compilation step
echo   --no-frontend    Skip frontend startup
echo   --only svc1,svc2  Start only specified service(s)
echo                    Available: eureka, ms-auth, ms-sucursales,
echo                    ms-menu, ms-carrito, ms-pedidos, ms-pagos,
echo                    ms-delivery, ms-inventario, ms-notificaciones,
echo                    ms-reportes, frontend
echo   -h, --help       Show this help message
echo.
echo Examples:
echo   launch.bat                          Start everything
echo   launch.bat --no-docker              Skip Docker
echo   launch.bat --only eureka,ms-auth    Start only Eureka and ms-auth
echo.
endlocal
exit /b 0