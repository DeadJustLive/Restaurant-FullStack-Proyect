# 1. Supón que quieres almacenar las notas en el localStorage. ¿Dónde imple-

## Fuente
react-aprendiz-maestro (Cap. 92)

## Contenido
# 1. Supón que quieres almacenar las notas en el localStorage. ¿Dónde imple-

mentarías esta funcionalidad?. Una aproximación puede ser el módulo setup
del Proveedor.
2. ¿Qué ocurre si tenemos varios componentes que quieran utilizar los datos?
Podemos consumirlos usando connect y mostrarlos.
2http://flowtype.org/

-- 115 of 226 --

Implementando NoteStore y NoteActions 98
3. ¿Qué ocurre si tenemos muchas listas de notas separadas para distintos tipos
de tareas?. Podemos crear otro almacén para hacer un seguimiento de esas
listas. Ese almacén podrá referenciar las notas por id. Haremos algo parecido
en el próximo capítulo.
Adoptar un gestor de estados puede ser útil en el momento en el que tu aplicación
React crezca. Esta abstracción tiene el coste de que tienes que escribir más código
pero, por otro lado, si lo haces bien, acabarás con algo que será más fácil de razonar
y de desarrollar más adelante. Cabe destacar que el flujo unidireccional utilizado por
estos sistemas ayudan mucho tanto a la depuración como al testing.
