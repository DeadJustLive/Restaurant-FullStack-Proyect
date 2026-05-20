# Capítulo 26:: Creación de una biblioteca

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 62)

## Contenido
# Capítulo 26:: Creación de una biblioteca

Node.js que admita tanto las promesas como
las devoluciones de llamada de error primero
Introducción
A muchas personas les gusta trabajar con promesas y / o sintaxis asincrónica / a la espera, pero
al escribir un módulo también sería útil para algunos programadores admitir métodos clásicos de
estilo de devolución de llamada. En lugar de crear dos módulos, o dos conjuntos de funciones, o
hacer que el programador prometa su módulo, su módulo puede admitir ambos métodos de
programación a la vez usando asCallback () de Bluebird o bien nodeify () de Q.
Examples
