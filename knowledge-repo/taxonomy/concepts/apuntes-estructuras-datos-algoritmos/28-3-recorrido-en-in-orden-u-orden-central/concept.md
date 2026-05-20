# 3. 	Recorrido en in-orden u orden central:

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 28)

## Contenido
# 3. 	Recorrido en in-orden u orden central:

1. 	se recorre en in-orden el subárbol izquierdo,
2. 	se visita la raíz, y
3. 	se recorre en in-orden el subárbol derecho.
• 	Recorrido en anchura:
1. 	primero se visita el elemento del nivel 0 (la raíz),

-- 116 of 267 --

109
2. 	luego los del nivel 1 (de izquierda a derecha),
3. 	luego los del nivel 2 (de izquierda a derecha),
… y así sucesivamente.
Se presentan a continuación las implementaciones recursivas de recorridos de árboles binarios. Se hace de forma que
el resultado del recorrido es la devolución de una lista genérica de elementos que contiene una secuencia con todos los
elementos del árbol. Para ello, se supone que previamente se ha especificado e implementado el TAD listasGenéricas con,
como mínimo las siguientes operaciones:
espec listasGenéricas
usa boleanos, naturales
parámetro formal
género elemento
fpf
género lista 	{Los valores del TAD lista representan secuencias de 0 o más elementos, con al menos una operación
de añadir un elemento al final de la secuencia.}
operaciones
crear: -> lista
{Devuelve una lista vacía, sin elementos}
añadir: lista l, elemento e -> lista
{Devuelve la lista resultante de añadir el elemento e al final de la lista l}
…
fespec
Así, una implementación de los tres recorridos en profundidad es la siguiente:
módulo recorridosArbin
importa árbolesBinarios, listasGenéricas
exporta
procedimiento preOrden(ent a:arbin; e/s L:lista)
{añade a la lista L la secuencia de elementos resultante de recorrer en pre-orden el
árbol a, es decir, 1º la raíz, luego el subárbol izquierdo y después el derecho,
ambos en pre-orden}
procedimiento inOrden(ent a:arbin; e/s L:lista)
{añade a la lista L la secuencia de elementos resultante de recorrer en in-orden el
árbol a, es decir, 1º el subárbol izquierdo en in-orden, luego la raíz y después el
subárbol derecho en in-orden}
procedimiento postOrden(ent a:arbin; e/s L:lista)
{añade a la lista L la secuencia de elementos resultante de recorrer en post-orden
el árbol a, es decir, 1º el subárbol izquierdo en post-orden, luego el derecho en
post-orden y finalmente la raíz}
implementación
procedimiento preOrden(ent a:arbin; e/s L:lista)
{añade a la lista L la secuencia de elementos resultante de recorrer en pre-orden el
árbol a, es decir, 1º la raíz, luego el subárbol izquierdo y después el derecho,
ambos en pre-orden}
variables ai,ad:arbin;
e:elemento;
error:booleano
principio
si not esVacío(a) entonces
raíz(a,error,e); {devuelve en el parámetro e el elemento raíz de a}
añadir(L,e); 	{añade el elemento e al final de la lista L}
subIzq(a,error,ai); {devuelve en ai el subárbol izquierdo de a}
preOrden(ai,L); 	{recorre en pre-orden ai, añadiendo sus elementos a L}

-- 117 of 267 --

110
subDer(a,error,ad); {devuelve en ad el subárbol derecho de a}
preOrden(ad,L) 	{recorre en pre-orden ad, añadiendo sus elementos a L}
fsi
fin
procedimiento inOrden(ent a:arbin; e/s L:lista)
{añade a la lista L la secuencia de elementos resultante de recorrer en in-orden el
árbol a, es decir, 1º el subárbol izquierdo en in-orden, luego la raíz y después el
subárbol derecho en in-orden}
variables ai,ad:arbin;
e:elemento;
error:booleano
principio
si not esVacío(a) entonces
subIzq(a,error,ai); {devuelve en ai el subárbol izquierdo de a}
inOrden(ai,L); 	{recorre en in-orden ai, añadiendo sus elementos a L}
raíz(a,error,e); 	{devuelve en el parámetro e el elemento raíz de a}
añadir(L,e); 	{añade el elemento e al final de la lista L}
subDer(a,error,ad); {devuelve en ad el subárbol derecho de a}
inOrden(ad,L) 	{recorre en in-orden ad, añadiendo sus elementos a L}
fsi
fin
procedimiento postOrden(ent a:arbin; e/s L:lista)
{añade a la lista L la secuencia de elementos resultante de recorrer en post-orden
el árbol a, es decir, 1º el subárbol izquierdo en post-orden, luego el derecho en
post-orden y finalmente la raíz}
variables ai,ad:arbin;
e:elemento;
error:booleano
principio
si not esVacío(a) entonces
subIzq(a,error,ai); {devuelve en ai el subárbol izquierdo de a}
postOrden(ai,L); 	{recorre en post-orden ai, añadiendo sus elementos a L}
subDer(a,error,ad); {devuelve en ad el subárbol derecho de a}
postOrden(ad,L); 	{recorre en post-orden ad, añadiendo sus elementos a L}
raíz(a,error,e); 	{devuelve en el parámetro e el elemento raíz de a}
añadir(L,e) 	{añade el elemento e al final de la lista L}
fsi
fin
fin
El coste en tiempo de los tres recorridos anteriores es lineal en el número de elementos del árbol (siempre que la
operación de añadir un elemento al final de la lista se pueda implementar con un coste en tiempo de orden constante, lo cual
no plantea ningún problema, tal como se hizo con las pilas o las colas).
Si los recorridos no se implementan en un módulo distinto, sino que se implementan dentro del módulo genérico
árbolesBinarios visto en la sección anterior, el código queda de la siguiente forma:
procedimiento preOrden(ent a:arbin; e/s L:lista)
{añade a la lista L la secuencia de elementos resultante de recorrer en pre-orden
