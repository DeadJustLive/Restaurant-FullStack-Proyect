# 2. Los árboles como estructura de datos para representar TAD contenedores

En programación, utilizaremos estructuras arborescentes (árboles) para almacenar colecciones de datos de un mismo
tipo (parámetro formal elemento). Podrán darse dos casos:
a) 	Colecciones de elementos entre los que existe alguna relación jerárquica que queremos quede patente en la
estructura. Por ejemplo, árboles genealógicos de personas (relación paterno-filial), organigramas de empresas
(relación de jefe y subalternos), árboles de ficheros y directorios en un sistema operativo (relación de directorio y
subdirectorio), expresiones aritméticas (operando y operadores a los que debe aplicarse), clasificaciones
(biológicas, geológicas, bibliográficas, etcétera).
b) 	Colecciones de elementos entre los que NO existe una relación jerárquica (o no interesa que quede patente).
Por ejemplo, conjuntos o multiconjuntos de elementos, diccionarios o tablas, u otros, que decidamos representar
en una estructura de árbol con objeto de mejorar la eficiencia en tiempo de las operaciones de manipulación
con respecto a la eficiencia conseguida con una representación lineal (estática o dinámica).
11
6 	9
51
13
7 	33
15 	55 	38	23
La altura del árbol (cuya
raíz es el nodo 11), es 3
Nivel 0
Nivel 1
La profundidad del nodo
51 (en el árbol de raíz 11),
es 2
Nivel 2
Nivel 3
11
6 	9
51
13
7 	33
15 	55 	38	23
Árbol de grado 3

-- 109 of 267 --

102

-- 110 of 267 --

103