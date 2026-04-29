@echo off
echo.
echo === COMPILANDO MICROSERVICIOS ===
echo.
call cd C:\Restaurant\ms-auth
call mvn clean install -U
call cd C:\Restaurant\ms-usuarios
call mvn clean install -U
call cd C:\Restaurant\ms-sucursales
call mvn clean install -U
call cd C:\Restaurant\ms-menu
call mvn clean install -U
call cd C:\Restaurant\ms-categorias
call mvn clean install -U
call cd C:\Restaurant\ms-carrito
call mvn clean install -U
call cd C:\Restaurant\ms-pedidos
call mvn clean install -U
call cd C:\Restaurant\ms-pagos
call mvn clean install -U
call cd C:\Restaurant\ms-delivery
call mvn clean install -U
call cd C:\Restaurant\ms-inventario
call mvn clean install -U
call cd C:\Restaurant\ms-notificaciones
call mvn clean install -U
call cd C:\Restaurant\ms-reportes
call mvn clean install -U
echo.
echo === COMPILACION COMPLETADA ===
pause
