# 3.1 Modelo de Datos Inicial

## Fuente
react-aprendiz-maestro (Cap. 35)

## Contenido
# 3.1 Modelo de Datos Inicial

A menudo, una buena forma de comenzar con el desarrollo de una aplicación es
empezar con los datos. Podemos modelar una lista de notas tal y como sigue:
[
{
id: '4e81fc6e-bfb6-419b-93e5-0242fb6f3f6a',
task: 'Learn React'
},
{
id: '11bbffc8-5891-4b45-b9ea-5c99aadf870f',
task: 'Do laundry'
}
];
Cada nota es un objeto que contiene los datos que necesitamos, incluyendo un
identificador (id) y el nombre de la tarea (task) que queremos llevar a cabo. Más
adelante podremos extender esta definición para incluir cosas como el color de las
notas o su propietario.

-- 35 of 226 --

Implementando una Aplicación de Notas 18
Podríamos haber ignorado los identificadores en nuestra definición, pero esto puede
volverse un problema a medida que la aplicación crece si tratamos de referenciarlas.
Al fin y al cabo, cada columna de Kanban necesita ser capaz de referenciar algunas
notas. Adoptando los índices desde el principio ahorraremos algo de esfuerzo más
adelante.
Otra forma interesante de aproximarse a los datos puede ser normalizarlos.
En este caso podríamos acabar con una estructura del tipo [<id> -> {
id: '...', task: '...' }]. Incluso aunque quizá tenga algo de redun-
dante, es conveniente utilizar la estructura de esta forma ya que nos facilita
poder acceder mediante a los elementos mediante el índice. La estructura
se volverá más útil todavía una vez empecemos a tener referencias entre
entidades.
