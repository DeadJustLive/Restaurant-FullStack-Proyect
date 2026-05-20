# 1. Definición y teorema AVL

Un árbol binario se dice equilibrado si, y sólo si, para cada uno de sus nodos ocurre que las alturas de sus dos
subárboles (izquierdo y derecho) difieren como mucho en una unidad (definición dada en 1962 por G. M. Adelson-Velskii
y Y. M. Landis). Los árboles binarios de búsqueda equilibrados reciben el nombre abreviado de árboles AVL (ver el
ejemplo de la figura).
6
4
2
1
9
11
10	3
5 	8
7 	12
El interés fundamental de los árboles AVL es que las operaciones habituales sobre árboles binarios de búsqueda
(inserción, pertenencia y borrado) se pueden realizar en el peor de los casos con un coste en O(log n), si n es el número de
nodos del árbol. Se mejora, por tanto, el coste en el caso peor que vimos para árboles binarios de búsqueda cualesquiera,
que estaba en O(n).
Para demostrar esa afirmación, veamos cuál es la máxima altura h que puede tener un AVL de n nodos. O lo que
es lo mismo, veamos cómo calcular el mínimo número de nodos n que puede tener un AVL de altura h. Los árboles
con esa propiedad se denominan árboles de Fibonacci. Se definen de la siguiente forma: un árbol de Fibonacci de altura
h, denotado por F h, es un AVL con esa altura y que tiene un número mínimo de nodos (es decir, no existe otro árbol binario
de altura h y con menos nodos que Fh).
El árbol de Fibonacci de altura 0, F0, es el siguiente, y tiene 1 nodo:
Un árbol de Fibonacci de altura 1, F1 , es el siguiente, y tiene 2 nodos (evidentemente, también su simétrico lo es):
F0  h = 0; n = 1
F1  h = 1; n = 2

-- 135 of 267 --

128
Un árbol de Fibonacci de altura 2, F2 , se conseguirá poniendo una raíz de la que cuelguen como subárboles un
Fibonacci de altura 0 y otro de altura 1. Cualquier otro AVL de altura 2 tendrá los mismos o más nodos:
De igual forma, para crear un Fibonacci de altura 3, F3 , se coloca una raíz de la que cuelgan un F1 y un F2. Cualquier
otro AVL de altura 3 tendrá los mismos o más nodos:
En general, para obtener un árbol de Fibonacci de altura h, Fh, se coloca un Fh – 2 y un Fh – 1 colgando como subárboles
de un nodo raíz. Por tanto, si llamamos Gh al número de nodos de un AVL de altura h que tenga el mínimo número
de nodos posibles, se tiene que:
G h = Gh – 1 + Gh – 2 + 1
Los árboles de Fibonacci se llaman así por la semejanza de la recurrencia anterior de la función Gh con la sucesión de
Fibonacci:
F0 = 1; F1 = 1; F h = F h – 1 + F h – 2, h > 1
F2  h = 2; n = 4
F3  h = 3; n = 7
AVL de altura 2
(G2 = 4)
AVL de altura 3
(G3 = 7)
AVL de altura 4
(G4 = 4+7+1)
F4  h = 4; n = 12

-- 136 of 267 --

129
Como puede observarse en la tabla de la izquierda, se tiene que:
Gh = F h + 2 – 1
Y para la sucesión de Fibonacci se sabe que:
F h > (φh / √5) – 1, con φ = (1 + √5)/2 la razón áurea.
Por tanto:
Gh > (φh + 2 / √5) – 2
Es decir, el número de nodos n de cualquier árbol AVL de altura h verifica (recordar que Gh es número de nodos de un
AVL de altura h que tenga el mínimo número de nodos posibles, por tanto n ≥ G h):
n ≥ G h > (φh+2 / √5) – 2
Y de ahí, despejando la h, se deduce el Teorema de Adelson-Velskii y Landis (1962), que asegura que la altura h de
un AVL cualquiera está acotada por la siguiente función logarítmica del número de nodos n del árbol:
h < 1’4404 log 2 (n + 2) – 0’328
Por tanto, como la altura de un AVL está acotada por el logaritmo del número de nodos del árbol, se puede
garantizar que la búsqueda de un nodo será, en el peor de los casos, de coste en tiempo en O(log n), siendo n el número
de nodos del árbol. Si además se consigue una implementación de la inserción y del borrado que mantengan el árbol dentro
de la clase de los AVL, esas dos operaciones también tendrán garantizado un coste en O(log n) en el caso peor.