# Lección 20:: Tablas multidimensionales............................................................................................... 189

Anexos: Material adicional............................................................................................................................ 191
Anexo 1: El TAD grafo y su representación en memoria .................................................................... 193
Anexo 2: Algoritmos de vuelta atrás y árboles de juego ..................................................................... 199
Anexo 3: Introducción a los algoritmos voraces.................................................................................. 209
Anexo 4: Especificación algebraica de TAD ....................................................................................... 217
Anexo 5: Transformación de algoritmos recursivos en iterativos ....................................................... 235
Anexo 6: Chuletas de sintaxis de especificación y pseudocódigo ....................................................... 245
Bibliografía .................................................................................................................................................... 253

-- 3 of 267 --

iv

-- 4 of 267 --

v
Prólogo de la primera edición
La abstracción de acciones es la base de la metodología de diseño descendente por refinamientos
sucesivos, útil para la resolución de pequeños problemas de tratamiento de información. Sin embargo, para
afrontar la construcción de programas en media y gran escala es necesaria una metodología de diseño modular,
que permita la partición del trabajo en unidades de programa que puedan ser desarrolladas independientemente
del resto. El propósito de estos apuntes es presentar los principios básicos de una metodología de diseño modular
basada en la abstracción de datos.
Este material ha sido elaborado para servir como soporte de la asignatura Estructuras de datos y algoritmos,
que se imparte en el tercer semestre de los estudios de Ingeniería Informática en el Centro Politécnico Superior1
de la Universidad de Zaragoza. Los alumnos que cursan dicha asignatura han seguido previamente dos semestres
de programación en los que han debido aprender a especificar formalmente y diseñar programas en pequeña
escala, utilizando tipos de datos sencillos (como los predefinidos en un lenguaje de programación de la familia
del Pascal); los alumnos conocen técnicas de diseño recursivo e iterativo, así como las herramientas básicas para
poder medir la eficiencia de los algoritmos (atendiendo a su tiempo de ejecución). No obstante, el material
presentado puede ser útil también para un segundo nivel en todos aquellos planes de estudios en los que se
incluyan dos cursos de programación de computadores.
Pueden encontrarse en las librerías varios trabajos (muchos de ellos ya clásicos) con títulos similares o
iguales a éste. Sin embargo, y ésta es la razón para la existencia de uno nuevo, la aproximación al tema que se
pretende desarrollar es bien diferente. De hecho, el título que el autor habría elegido, en caso de no haber optado
por mantener el nombre de la asignatura antes mencionada, hubiese sido más bien “Tipos abstractos de datos y
algoritmos” o mejor “Introducción a la programación con tipos abstractos de datos”. La diferencia estriba en el
énfasis que se pretende dar en las páginas que siguen a la especificación formal de los tipos (de ahí la expresión
“tipos abstractos de datos”) como herramienta fundamental para el diseño modular de programas, en lugar de
limitarse a presentar las estructuras de datos necesarias para representar los valores de los tipos definidos.
El comentario anterior no debe hacer pensar al lector que el material que sigue es original del autor. Nada
más lejos de la realidad. Únicamente nos hemos limitado a enlazar las excelentes aproximaciones existentes en
la literatura a la definición y conceptos relacionados con los tipos abstractos de datos y su especificación
algebraica (véanse, por ejemplo, los dos últimos capítulos de la obra de Ricardo Peña titulada Diseño de
Programas. Formalismo y Abstracción) con los trabajos más clásicos sobre estructuras de datos y algoritmos de
manipulación (como, por ejemplo, Estructuras de Datos y Algoritmos, de Aho, Hopcroft y Ullman).
Los apuntes están estructurados en lecciones, agrupadas en grandes temas. En el primero de ellos, titulado
“Tipos abstractos de datos”, se presentan los conceptos fundamentales sobre los tipos abstractos de datos, su
especificación formal (algebraica) y su utilización en el diseño modular de programas.
El segundo tema, “Tipos de datos lineales”, introduce tres de los tipos abstractos lineales más
representativos y útiles en programación: las pilas, las colas y las listas con acceso por posición. Para cada nuevo
tipo presentado se incluyen su especificación formal, una o varias soluciones para la representación de sus valores,
la implementación de las operaciones más importantes, su coste computacional y algunos ejemplos de aplicación.
El tercer tema, titulado “Árboles y esquemas algorítmicos”, incluye los detalles sobre algunos de los tipos
de árboles más frecuentemente utilizados, como los árboles binarios, árboles ordenados, árboles de búsqueda,
montículos… y ejemplos de aplicación. Además, se introducen los algoritmos de vuelta atrás y las heurísticas
voraces.
Los dos últimos temas, sobre “Tipos de datos funcionales” (o tablas) e “Introducción a los grafos”, no se
desarrollan con la misma extensión que los anteriores por razones diferentes. En el caso de las tablas, tras las
definiciones formales convenientes, se hace hincapié en la representación mediante tablas dispersas basadas en
la utilización de una función de localización (hashing, en inglés) y en las tablas multidimensionales representadas
1 Hoy Escuela de Ingeniería y Arquitectura.

-- 5 of 267 --

vi
mediante estructuras de listas múltiples, pues otras representaciones posibles basadas en listas lineales o árboles
de búsqueda no precisan mayor explicación tras el estudio de los temas previos.
En cuanto a los grafos, los alumnos de Ingeniería Informática (a quienes va dirigida preferentemente esta
obra) han cursado previamente una asignatura titulada “Matemática discreta”, en la que se les ha presentado el
concepto de grafo y una buena colección de algoritmos para su manipulación. Por ello, y atendiendo a razones
de completitud, se presentan sólo las especificaciones formales y varias alternativas de representación, junto a
algunas consideraciones sobre el efecto que la elección de la representación tiene en el coste de los algoritmos de
manipulación.
Por último, un comentario sobre las notaciones empleadas y los lenguajes de programación que pueden
servir como soporte de prácticas. Para la especificación algebraica de tipos abstractos, se utiliza una sintaxis
similar a la del lenguaje OBJ, pero en español. En cuanto a los módulos, estructuras de datos y algoritmos, se
emplea una notación algorítmica, también en español, que consiste en una extensión modular de la notación
utilizada en los apuntes sobre Introducción a la programación, elaborados por Javier Martínez y Javier Campos
como soporte a la asignatura de igual nombre existente en el currículum de Ingeniería Informática del CPS.
En cuanto al lenguaje de programación soporte de las prácticas, el autor desaconseja la utilización de las
extensiones modulares de Pascal (incluido el Modula 2), pues carecen de la posibilidad de definir tipos opacos y
tipos genéricos, siendo ambos mecanismos fundamentales en la metodología desarrollada. Así, un lenguaje
apropiado resulta ser el Ada, dotado de la posibilidad de definición de tipos opacos y tipos genéricos, con una
sintaxis y semántica bien pensadas y una dificultad de aprendizaje similar al Pascal, si se limita su presentación
a la parte secuencial. Otras alternativas pueden encontrarse en lenguajes de programación orientados a objetos
(como, por ejemplo, C++), dada la cercanía de los conceptos de “clase” y “tipo abstracto de dato”.
Javier Campos Laclaustra
Zaragoza, 30 de marzo de 1995

-- 6 of 267 --

vii
Prólogo de la segunda edición
Pasados ya más de veinte años desde la publicación de la primera edición de estos apuntes, gracias en
aquella ocasión a Prensas Universitarias de Zaragoza, se presenta aquí una reedición y actualización que venía
siendo necesaria desde hace ya varios años.
El cambio de plan de estudios de la anterior Ingeniería en Informática, de cinco años de duración, al actual
Grado de Ingeniería Informática, de cuatro años, ha conllevado la reducción de créditos de algunas asignaturas y
con ella la de horas de clase y, por tanto, de contenidos. Es el caso de la asignatura de Estructuras de Datos y
Algoritmos, de segundo curso, tercer cuatrimestre del Grado, en la Escuela de Ingeniería y Arquitectura de la
Universidad de Zaragoza.
En esta nueva edición, se han eliminado del temario las lecciones sobre especificación formal –algebraica–
de tipos abstractos de datos y, en su lugar, se ha optado por utilizar una especificación no formal, en lenguaje
natural. Así, las anteriores lecciones sobre especificación algebraica se han trasladado a un Anexo.
Además, se han introducido algunos pequeños cambios o correcciones en algunos aspectos de los
algoritmos presentados. Por ejemplo, cabe destacar la sustitución de los mecanismos utilizados para el paso de
parámetros en procedimientos y funciones. En la primera edición, inspirada por el lenguaje Pascal, se utilizaba
el paso por valor y por referencia. En ésta, más inspirada por el lenguaje Ada, se utilizan mecanismos de más alto
nivel de abstracción, es decir, más cercanos al razonamiento del diseñador de algoritmos y menos a los detalles
de implementación, como son los pasos de parámetros de entrada, salida o entrada/salida.
Por lo demás, algunas otras de las lecciones de la primera edición han sido desplazadas también a Anexos,
como las de transformación de algoritmos recursivos en iterativos, la especificación y representación en memoria
del TAD grafo, y las lecciones de introducción a esquemas algorítmicos sencillos, como los algoritmos de vuelta
atrás o los algoritmos voraces. Por el contrario, se ha introducido una nueva lección sobre árboles lexicográficos.
También se han eliminado los ejercicios propuestos en las últimas páginas de la primera edición. Los
estudiantes actuales de la asignatura en la Escuela de Ingeniería y Arquitectura de Zaragoza disponen de suficiente
material de trabajo, enunciados de ejercicios y de exámenes de convocatorias anteriores, en la página web de la
asignatura: http://webdiis.unizar.es/asignaturas/EDA/.
Aún con estos recortes y pequeños cambios, los objetivos fundamentales enumerados en el prólogo de la
primera edición se mantienen inalterados, y por eso se ha optado por incluir dicho prólogo en las páginas
anteriores.
Para terminar, debo agradecer a los profesores del Departamento de Informática e Ingeniería de Sistemas
de la Universidad de Zaragoza que en todos estos años me han acompañado en la impartición de la asignatura:
Elvira Mayordomo, Pedro Fernández, Miguel Ángel Villarroel, Elsa García, Maite Lozano, Pablo López, Javier
Martínez, Luis Carlos Gallego, Yolanda Villate, Jorge Júlvez, Ángel Luis Garrido, Miguel Flores, Fernando
Tricas y Jorge Bernad. Algunos de los materiales e ideas aquí presentados han sido inspirados por ellos.
Javier Campos Laclaustra
Zaragoza, 15 de noviembre de 2018

-- 7 of 267 --

viii

-- 8 of 267 --

1
TEMA I
Programación con
Tipos Abstractos de Datos

-- 9 of 267 --

2

-- 10 of 267 --

3
Lección 1
Tipos Abstractos de Datos (TAD)
Indice