# 8. React y Flux

## Fuente
react-aprendiz-maestro (Cap. 69)

## Contenido
# 8. React y Flux

Puedes llegar bastante lejos guardándolo todo en componentes, lo cual es una forma
completamente válida de comenzar. El problema comenzará cuando añadas estado
a tu aplicación y necesites compartirlo en distintos sitios. Por este motivo han sido
varios los gestores de estado que han aparecido. Cada uno de ellos trata de resolver
el problema a su manera.
La arquitectura Flux de aplicaciones1 fué la primera solución al problema. Te permite
modelar tu aplicación mediante el uso de Acciones, Almacenes y Vistas. También
tiene una parte conocida como Dispatcher con la que gestionar acciones y permitirte
modelar dependencias entre las distintas llamadas.
Esta forma de oganización es particulamente útil cuando estas trabajando en equipos
grandes. El flujo unidireccional hace fácil poder saber qué está pasando. Este es un
elemento común de varias soluciones de gestión de estados disponibles en React.
