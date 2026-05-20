# 21. Manejo seguro de errores y

## Fuente
2.3.6 Guia Desarrollo Software v2.0 (Cap. 26)

## Contenido
# 21. Manejo seguro de errores y

excepciones
Se debe desarrollar el sistema, de forma
tal, que aplique el principio de “fallar
seguro”, es decir:
● No exponer información sensible o
privada en los mensajes de error. En
particular, nunca olvidar desactivar
el modo debug al pasar a
producción.
● Asegurarse de que una excepción o
fallo no comprometa la seguridad
por un error de programación en el
sistema. 	Por ejemplo, causar
una denegación de servicio o
ejecución de código con privilegios
incorrectos.
● Registrar 	las 	excepciones
adecuadamente en los sistemas
que correspondan.
