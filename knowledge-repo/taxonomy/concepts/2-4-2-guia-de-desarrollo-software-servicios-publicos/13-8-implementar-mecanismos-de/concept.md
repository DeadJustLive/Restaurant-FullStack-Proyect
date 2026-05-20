# 8. Implementar mecanismos de

## Fuente
2.4.2 Guia de Desarrollo Software Servicios Publicos (Cap. 13)

## Contenido
# 8. Implementar mecanismos de

manejo de sesión
Para el manejo de las sesiones, se debe
considerar al menos lo siguiente:
● El identificador de sesión debe ser
único, suficientemente largo y
aleatorio.
● Se deben generar (o rotar) los
identificadores de sesión durante la
autenticación y re-autenticación.
● Se debe implementar un timeout
por inactividad que fuerce la re-
autenticación al usuario. La
duración de este timeout debe ser
inversamente proporcional a la
sensibilidad de los datos a proteger,
vale decir, mientras más sensible,
menor duración.
