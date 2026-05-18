# 1. Conceptos y especificación

Como ya adelantamos en una lección anterior, un árbol n–ario (con n ≥ 1) es un conjunto no vacío de elementos o
nodos del mismo tipo tal que:
• 	existe un elemento destacado llamado raíz del árbol,
• 	el resto de los elementos se distribuyen en m (con 0 ≤ m ≤ n) subconjuntos disjuntos, llamados subárboles del árbol
original, cada uno de los cuales es a su vez un árbol n–ario.
Si en el conjunto de los subárboles de un árbol n–ario se supone definida una relación de orden total, el árbol se llama
ordenado.
Árbol n–ario ordenado,
cada nodo tiene un número de
subárboles no superior a n,
numerados desde el 1 en adelante:
A1 , …, A m
Para poder facilitar la especificación de árboles n–arios, se define además el concepto de bosque. Un bosque ordenado
de grado n (con n ≥ 1) es una secuencia A1 , …, A m, con 0 ≤ m ≤ n, de árboles n–arios ordenados. Si m = 0, el bosque se
llama vacío.
Un árbol n–ario ordenado se genera a partir de un elemento y un bosque ordenado de grado n, sin más que considerar
el elemento como raíz del árbol y el bosque como sus subárboles.
A continuación, vemos la especificación conjunta de los bosques ordenados y de los árboles ordenados. Los bosques
se generan como secuencias de árboles a partir de un bosque vacío y una operación de añadir por la derecha un árbol a un
bosque.
espec árbolesOrdenados
usa booleanos, naturales
parámetro formal
género elemento
fpf
géneros bosque, árbol {Los valores del género bosque representan secuencias de elementos del género árbol.
Los valores del género árbol se componen de una raíz de género elemento y un bosque de árboles hijos}

-- 147 of 267 --

140
operaciones
crearVacío: -> bosque
{Devuelve el bosque vacío, es decir, la secuencia vacía de árboles}
añadirÚltimo: bosque b, árbol a -> bosque
{Devuelve un bosque igual al resultante de añadir el árbol a como último elemento de b}
long: bosque b -> natural
{Devuelve el número de árboles del bosque b, es decir, la longitud de la secuencia de árboles}
parcial observar: bosque b, natural n -> árbol
{Devuelve el n-ésimo árbol de la secuencia de árboles b.
Parcial: sólo está definida si 1
≤ n
≤ long(b)}
parcial resto: bosque b -> bosque
{Devuelve un bosque igual al resultante de borrar el primer árbol de b.
Parcial: sólo está definida si long(b) > 0}
plantar: elemento e, bosque b -> árbol
{Devuelve un árbol cuya raíz es e y sus subárboles son un bosque igual que b}
raíz: árbol a -> elemento
{Devuelve la raíz del árbol a}
elBosque: árbol a -> bosque
{Devuelve un bosque igual al bosque de los subárboles del árbol a}
numHijos: árbol a -> natural
{Devuelve el número de subárboles de a, es decir long(elBosque(a))}
parcial subÁrbol: árbol a , natural n  árbol
{Devuelve un árbol igual al n-ésimo subárbol de a.
Parcial: sólo está definida si 1
≤ n
≤ numHijos(a)}
esHoja?: árbol a -> booleano
{Devuelve verdad si y sólo si a no tiene subárboles, es decir, numHijos(a) = 0}
alturaBosque: bosque b -> natural
{Si long(b) > 0, devuelve la altura del árbol más alto de b. Si long(b) = 0, devuelve 0}
alturaÁrbol: árbol a -> natural
{Devuelve la altura de a}
fespec