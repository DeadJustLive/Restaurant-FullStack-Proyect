# 1. Concepto y especificación

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 34)

## Contenido
# 1. Concepto y especificación

Los árboles binarios de búsqueda (ABB) pueden definirse cuando el tipo de los elementos almacenados en los nodos
del árbol posee una relación de orden total (“≤”). Tienen la propiedad de que el elemento raíz es mayor o igual que todos
los elementos del subárbol izquierdo y menor que todos los elementos del subárbol derecho. Además, los subárboles
izquierdo y derecho son a su vez árboles binarios de búsqueda. Si no se permite que el árbol tenga elementos repetidos (la
relación de orden es estricta, “<”), entonces el elemento raíz es estrictamente mayor que todos los elementos del subárbol
izquierdo.
Ejemplo de árbol binario de búsqueda de naturales (sin elementos repetidos)
Las operaciones básicas con árboles de búsqueda son la inserción y la búsqueda de elementos. En la mayoría de
ocasiones se precisa además la operación de borrado de un elemento. Por tanto, si no se permiten elementos repetidos,
los ABB sirven para representar el TAD diccionario de elementos, visto en un tema anterior (sin más que almacenar en
cada nodo del árbol una clave y un valor en lugar de un elemento, y considerar el orden de las claves “<” como el criterio
de ordenación de los nodos del árbol) . Además, si el iterador se construye para obtener un recorrido en in-orden del árbol
(como se vio en la lección anterior), el iterador recorre los elementos en el orden que tienen definido (<).
Veamos la especificación de las operaciones básicas, suponiendo que puede haber elementos repetidos (comparables
mediante “≤”).
espec abbs
parámetro formal
género elemento
operación _≤_: elemento e1, elemento e2 -> booleano 	(… ídem con =,≠,≥,<,>)
fpf
género abb {Su dominio de valores son los árboles binarios de búsqueda de elementos, con la posibilidad de contener
elementos repetidos; sirven, por tanto, para almacenar multiconjuntos de elementos}
operaciones

-- 123 of 267 --

116
vacío: -> abb
{Devuelve el árbol binario de búsqueda vacío, sin elementos}
esVacío?: abb a -> booleano
{Devuelve verdad si y sólo si a es vacío}
añadir: abb a, elemento e -> abb
{Devuelve el abb resultante de añadir un ejemplar del elemento e al árbol a, manteniendo la propiedad de abb,
es decir, todo elemento almacenado en el árbol es mayor o igual que los elementos de su subárbol izquierdo y
menor que los elementos de su subárbol derecho}
está?: abb a, elemento e -> booleano
{Devuelve verdad si y sólo si hay algún ejemplar de e está en a}
borrar: abb a, elemento e -> abb
{Si e está en a, devuelve un árbol igual al resultante de borrar una de las apariciones de e en a.
Si e no está en a, devuelve un árbol igual que a}
fespec
