@echo off
echo ===== Iniciando Eureka Server =====
start "eureka" mvn -f eureka spring-boot:run

timeout /t 5 /nobreak > nul

echo ===== Iniciando Microservicios =====
start "ms-catalogo" mvn -f ms-catalogo spring-boot:run
start "ms-recursos" mvn -f ms-recursos spring-boot:run
start "ms-usuarios" mvn -f ms-usuarios spring-boot:run
rem agrega aquí los demás microservicios si necesitas

echo Todos los servicios han sido lanzados.
