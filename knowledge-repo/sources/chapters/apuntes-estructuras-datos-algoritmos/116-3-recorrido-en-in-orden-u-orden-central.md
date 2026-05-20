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
{añade a la lista L la secuencia de elementos resultante de recorrer en pre-orden el
árbol a, es decir, 1º la raíz, luego el subárbol izquierdo y después el derecho,
ambos en pre-orden}
principio
si not esVacío(a) entonces
añadir(L,a↑.dato);
preOrden(a↑.izq,L);
preOrden(a↑.der,L)
fsi
fin
procedimiento inOrden(ent a:arbin; e/s L:lista)
{añade a la lista L la secuencia de elementos resultante de recorrer en in-orden el
árbol a, es decir, 1º el subárbol izquierdo en in-orden, luego la raíz y después el

-- 118 of 267 --

111
subárbol derecho en in-orden}
principio
si not esVacío(a) entonces
inOrden(a↑.izq,L);
añadir(L,a↑.dato);
inOrden(a↑.der,L)
fsi
fin
procedimiento postOrden(ent a:arbin; e/s L:lista)
{añade a la lista L la secuencia de elementos resultante de recorrer en post-orden
el árbol a, es decir, 1º el subárbol izquierdo en post-orden, luego el derecho en
post-orden y finalmente la raíz}
principio
si not esVacío(a) entonces
postOrden(a↑.izq,L);
postOrden(a↑.der,L);
añadir(L,a↑.dato)
fsi
fin
La implementación de un recorrido en anchura es sensiblemente más difícil y, desde luego, más ineficiente.
Implementamos previamente un procedimiento que añade, al final de una lista, todos los elementos de un cierto nivel del
árbol.
procedimiento nivel(ent a:arbin; ent i:0..maxEntero; e/s L:lista)
{Pre: a es no vacío}
{Post: añade a la lista L los elementos del nivel i de a (si existen) de izquierda a
derecha}
variables e:elemento;
error:boolean;
ai,ad:arbin;
hi,hd:natural
principio
si i=0 entonces 	{es el nivel de la raíz}
raíz(a,error,e); {devuelve en el parámetro e el elemento raíz de a}
añadir(L,e) 	{añade el elemento e al final de la lista L}
sino {i>0}
subIzq(a,error,ai);
subDer(a,error,ad); {se guarda en ai el subárbol izquierdo y en ad el derecho}
selección
esVacío(ai) and esVacío(ad): {no hacer nada};
esVacío(ai) and not esVacío(ad): nivel(ad,i-1,L); {sólo hay que añadir los
elementos del nivel i-1 del subárbol derecho}
not esVacío(ai) and esVacío(ad): nivel(ai,i-1,L); {caso simétrico}
not esVacío(ai) and not esVacío(ad): nivel(ai,i-1,L); nivel(ad,i-1,L)
fselección
fsi
fin
Y el procedimiento del recorrido en anchura queda como sigue.
procedimiento anchura(ent a:arbin; e/s L:lista)
{añade a la lista L los elementos de a recorridos en anchura, es decir, por niveles
desde el 0 hasta el último y, para cada nivel, de izquierda a derecha}
variables h,i:natural
principio
si not esVacío(a) entonces
altura(a,error,h);
para i:=0 hasta h hacer
nivel(a,i,L)
fpara
fsi
fin

-- 119 of 267 --

112
También es posible implementar los recorridos con algoritmos iterativos (más eficiente en el caso del recorrido en
anchura), pero utilizando estructuras de datos auxiliares: una pila o una cola de elementos particularizadas para el tipo de
dato arbin.
procedimiento preOrdenIterativo(ent a:arbin; e/s L:lista)
{añade a la lista L la secuencia de elementos resultante de recorrer en pre-orden el
árbol a, es decir, 1º la raíz, luego el subárbol izquierdo y después el derecho,
ambos en pre-orden}
variables p:pila; {pila de elementos de tipo arbin}
aux:arbin
principio
crearVacía(p);
apilar(p,a);
mientrasQue not esVacía(p) hacer
aux:=cima(p);
desapilar(p);
si aux≠nil entonces
añadir(L,aux↑.dato);
apilar(p,aux↑.der);
apilar(p,aux↑.izq)
fsi
fmq
fin
Para entender el algoritmo anterior y convencerse de que realiza un recorrido en pre-orden, se recomienda realizar
trazas del mismo usando varios árboles binarios como entrada.
A continuación, de manera similar, pero utilizando una cola de elementos particularizada para el tipo de dato arbin,
se presenta un algoritmo iterativo para el recorrido en anchura.
procedimiento anchuraIterativo(ent a:arbin; e/s L:lista)
{añade a la lista L los elementos de a recorridos en anchura, es decir, por niveles
desde el 0 hasta el último y, para cada nivel, de izquierda a derecha}
variables c:cola; {cola de elementos de tipo arbin}
aux:arbin;
error:booleano
principio
crearVacía(c);
encolar(c,a);
mientrasQue not esVacía(c) hacer
primero(c,aux,error);
desencolar(c);
si aux≠nil entonces
añadir(L,aux↑.dato);
encolar(c,aux↑.izq);
encolar(c,aux↑.der)
fsi
fmq
fin
Por último, es también posible implementar de forma iterativa el recorrido en in-orden, usando una pila de datos de
tipo arbin auxiliar.
procedimiento inorden(ent a:arbin; e/s L:lista)
{añade a la lista L la secuencia de elementos resultante de recorrer en in-orden el
árbol a, es decir, 1º el subárbol izquierdo en in-orden, luego la raíz y después el
subárbol derecho en in-orden}
variables p:pila; {pila de elementos de tipo arbin}
aux:arbin
principio
{equivale al inicio de un hipotético iterador}
crearVacía(p);
aux:=a;

-- 120 of 267 --

113
mientrasQue aux≠nil hacer
apilar(p,aux);
aux:=aux↑.izq
fmq;
{not(esVacía(p)) es equivalente a ‘existeSiguiente’ de un iterador}
mientrasQue not esVacía(p) hacer
{equivale al código de ‘siguiente’ de un iterador}
aux:=cima(p);
desapilar(p);
añadir(L,aux↑.dato);
aux:=aux↑.der;
mientrasQue aux≠nil hacer
apilar(p,aux);
aux:=aux↑.izq
fmq
fmq
fin
La idea del algoritmo anterior se puede utilizar para implementar un iterador para los elementos de un árbol binario,
recorriéndolos en in-orden. Para eso, es necesario modificar la representación del tipo arbin, añadiendo una pila auxiliar
que se usa exclusivamente para las operaciones del iterador. Llamamos árbol al nuevo tipo.
tipo árbol = registro {aumentamos la representación de arbin con una pila auxiliar
para implementar las operaciones del iterador}
raíz:arbin; {puntero a la raíz de un árbol binario}
iter:pila {pila de elementos de tipo arbin, es decir, de punteros a nodos
del árbol, para el iterador}
freg
procedimiento iniciarIterador(e/s a:árbol)
{Prepara el iterador para que el siguiente elemento a visitar sea un primer
elemento de a, si existe (situación de no haber visitado ningún elemento)}
variable aux:arbin
principio
crearVacía(a.iter); {crea pila vacía de punteros a nodos del árbol}
aux:=a.raíz; {raíz del árbol}
mientrasQue aux≠nil hacer
apilar(a.iter,aux); {apila el puntero aux (a un nodo del árbol) en la pila
del iterador}
aux:=aux↑.izq
fmq
fin
función existeSiguiente(a:árbol) devuelve booleano
{Devuelve falso si ya se han visitado todos los elementos de a; devuelve cierto en
caso contrario}
principio
devuelve not esVacía(a.iter) {hay siguiente si la pila del iterador es no vacía}
fin
procedimiento siguiente(e/s a:árbol; sal e:elemento; sal error:booleano)
{Si existe algún elemento de a pendiente de visitar, devuelve en e el siguiente
elemento a visitar y error=falso, y además avanza el iterador para que a
continuación se pueda visitar otro elemento de a. Si no quedan elementos pendientes
de visitar devuelve error=verdad y e queda indefinido}
variable aux:arbin
principio
si existeSiguiente(a) entonces
error:=falso;
aux:=cima(a.iter);
desapilar(a.iter);

-- 121 of 267 --

114
e:=aux↑.dato; {este es el siguiente elemento visitado}
aux:=aux↑.der;
mientrasQue aux≠nil hacer
apilar(a.iter,aux);
aux:=aux↑.izq
fmq
sino
error:=verdad
fsi
fin

-- 122 of 267 --

115