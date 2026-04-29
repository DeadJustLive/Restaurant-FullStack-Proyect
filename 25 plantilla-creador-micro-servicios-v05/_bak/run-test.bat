@echo off
echo ===== Iniciando Eureka Server =====
start "EUREKA" java -jar eureka\target\eureka.jar --spring.profiles.active=test

timeout /t 5 /nobreak > nul

echo ===== Iniciando Microservicios =====
start "MS-CATALOGO"  java -jar ms-catalogo\target\ms-catalogo.jar --spring.profiles.active=test
start "MS-RECURSOS"  java -jar ms-recursos\target\ms-recursos.jar --spring.profiles.active=test
start "MS-USUARIOS"  java -jar ms-usuarios\target\ms-usuarios.jar --spring.profiles.active=test
rem agrega aquí los demás microservicios si necesitas

echo Todos los servicios han sido lanzados.
