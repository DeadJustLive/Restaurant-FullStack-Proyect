# 2. Recorridos

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 60)

## Contenido
# 2. Recorridos

De forma análoga a lo visto para árboles binarios, se pueden especificar varias operaciones de recorrido de árboles
ordenados. Todas ellas consisten en visitar todos los elementos del árbol una sola vez. En el recorrido pre-orden se visita
en primer lugar la raíz del árbol y después se recorren en pre-orden todos los subárboles de izquierda a derecha. En el
recorrido post-orden se recorren en post-orden los subárboles de izquierda a derecha y por último se visita la raíz. Por

-- 148 of 267 --

141
último, el recorrido en anchura de un árbol consiste en visitar todos los elementos del árbol una sola vez, de la siguiente
forma: primero se visita el elemento del nivel 0 (la raíz), luego los elementos del nivel 1, y así sucesivamente; en cada nivel,
sus elementos se visitan de izquierda a derecha.
Por ejemplo, para el árbol 3–ario de la figura siguiente,
3
14 	15
9 	2 	6 	33
el recorrido en pre-orden es la lista 3-14-9-2-6-15-33, el recorrido es post-orden es 9-2-6-14-33-15-3, y el recorrido en
anchura es 3-14-15-9-2-6-33.
