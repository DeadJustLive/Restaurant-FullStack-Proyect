# 9. Uso de cookies para manejo

## Fuente
2.3.6 Guia Desarrollo Software v2.0 (Cap. 14)

## Contenido
# 9. Uso de cookies para manejo

de sesión
Para el uso de cookies se debe
considerar lo siguiente:
● Deben ser accesibles por el mínimo
de dominios requeridos para el
correcto 	funcionamiento 	del
sistema.
● Deben caducar al momento en que
expira la sesión, o luego de un corto
período.
● Deben tener el flag “secure”. Esto
fuerza su transferencia a través de
TLS.
● Deben tener el flag “HttpOnly”.
Esto previene su acceso a través de
JavaScript.
