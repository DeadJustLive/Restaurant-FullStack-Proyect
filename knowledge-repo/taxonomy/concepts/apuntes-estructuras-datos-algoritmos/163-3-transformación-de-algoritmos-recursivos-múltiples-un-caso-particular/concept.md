# 3. Transformación de algoritmos recursivos múltiples: un caso particular

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 163)

## Contenido
# 3. Transformación de algoritmos recursivos múltiples: un caso particular

En este apartado y el siguiente vamos a estudiar la transformación en iterativos de aquellos algoritmos, denominados
recursivos múltiples, que pueden generar más de una llamada recursiva en cada llamada. Por simplificar la exposición nos
centraremos en el caso de algoritmos que generan en cada llamada, a lo sumo, dos nuevas llamadas recursivas. La
consideración de más de dos llamadas recursivas puede hacerse de forma análoga, sin demasiadas complicaciones.
Veremos, en primer lugar, el caso particular en el que en cada llamada al algoritmo se realizan una secuencia de
operaciones (no recursivas), A(x), y después dos llamadas recursivas consecutivas y termina el algoritmo. El esquema de
tal algoritmo recursivo es el siguiente:
procedimiento r(ent x:tx)
principio
si C(x) entonces
A(x);
r(sig1(x));
r(sig2(x))
fsi
fin
En este caso, los diferentes valores del parámetro x en todas las llamadas recursivas generadas por una llamada inicial
al algoritmo r pueden representarse en un árbol binario de datos de tipo tx en la forma siguiente:
x0
x01 	x02
x011 	x012 	x021 	x022
Como puede verse, se ha denotado por xn1 el valor de sig1(xn) y por xn2 el valor de sig2(xn).
La ejecución del algoritmo r para un valor del parámetro x igual a x0 puede asociarse con un recorrido en pre-orden
del árbol anterior de forma que, al visitar el valor xn hay que ejecutar A(xn) y después hay que recorrer su subárbol
izquierdo y después su subárbol derecho.
x 0
x01 	x02
x011 	x012 	x 021 	x022
A(x0 )
A(x01 )
A(x011 ) A(x 012 ) 	A(x 021 ) 	A(x022 )
A(x02 )
La escritura de un algoritmo iterativo de recorrido en pre-orden de un árbol binario es muy sencilla utilizando, de
nuevo, una pila auxiliar de datos de tipo tx que almacenará los elementos raíz de aquellos subárboles que están todavía
por recorrer. Inicialmente se apila la raíz del árbol. Después, mientras la pila no sea vacía, se desapila un valor, v, y si se
verifica C(v) entonces se ejecutan las instrucciones asociadas a ese valor, A(v), y se apilan sucesivamente la raíz del
subárbol derecho, sig2(v), y la raíz del subárbol izquierdo, sig1(v).
procedimiento rIter(ent x:tx)
variables v:tx;

-- 251 of 267 --

238
p:pila_de_tx
principio
si C(x) entonces
creaVacía(p);
apilar(p,x);
mientrasQue not esVacía(p) hacer
v:=cima(p);
desapilar(p);
si C(v) entonces
A(v);
apilar(p,sig2(v));
apilar(p,sig1(v))
fsi
fmq
fsi
fin
Como ejemplo de aplicación, recordemos el algoritmo rápido de ordenación (quicksort) en su versión recursiva
(véase, por ejemplo, el libro de Aho et al):
constante maxN = 100 {dimensión del vector}
tipos índice = 1..maxN;
ítem = registro
clave:entero;
info:tpInfo
freg;
tpVector = vector[1..maxN] de ítem
procedimiento ordenar(e/s v:tpVector; ent n:índice)
{Ordena los elementos 1..n del vector v por valores crecientes de clave.}
procedimiento rápido(e/s v:tpVector; ent izq,der:índice)
{Ordena los elementos izq..der de v por valores crecientes de clave.}
variables i,d:índice;
unItem,aux:ítem
principio
si izq ≤ der entonces
unItem:=v[izq];
i:=izq+1;
d:=der;
mientrasQue i≠d+1 hacer
si v[i].clave ≤ unItem.clave entonces
i:=i+1
sino
si v[d].clave ≥ unItem.clave entonces
d:=d-1
sino {(v[i].clave>unItem.clave)
∧(v[d].clave<unItem.clave)}
aux:=v[i];
v[i]:=v[d];
v[d]:=aux;
i:=i+1;
d:=d-1
fsi
fsi
fmq;
v[izq]:=v[d];
v[d]:=unItem;
rápido(v,izq,d-1);
rápido(v,d+1,der)
fsi
fin
principio {de ordenar}
rápido(v,1,n)
fin
Aplicando el esquema de transformación visto anteriormente, se obtiene la siguiente versión iterativa del algoritmo:

-- 252 of 267 --

239
constante maxN = 100 {dimensión del vector}
tipos índice = 1..maxN;
ítem = registro
clave:entero;
info:tpInfo
freg
tpVector = vector[1..maxN] de ítem
par = registro
iz,de:índice
freg
procedimiento ordenar_iter(e/s v:tpVector; ent n:índice)
{Ordena los elementos 1..n de v por valores crecientes de clave.}
variables p:pila_de_par;
unP:par;
izq,der,i,d:índice;
unItem,aux:ítem
principio
creaVacía(p);
unP.iz:=1;
unP.de:=n;
apilar(p,unP);
mientrasQue not esVacía(p) hacer
unP:=cima(p);
izq:=unP.iz;
der:=unP.de;
desapilar(p);
si izq ≤ der entonces
unItem:=v[izq];
i:=izq+1;
d:=der;
mientrasQue i≠d+1 hacer
si v[i].clave ≤ unItem.clave entonces
i:=i+1
sino
si v[d].clave ≥ unItem.clave entonces
d:=d-1
sino {(v[i].clave>unItem.clave)
∧(v[d].clave<unItem.clave)}
aux:=v[i];
v[i]:=v[d];
v[d]:=aux;
i:=i+1;
d:=d-1
fsi
fsi
fmq;
v[izq]:=v[d];
v[d]:=unItem;
unP.iz:=d+1;
unP.de:=der;
apilar(p,unP);
unP.iz:=izq;
unP.de:=d-1;
apilar(p,unP)
fsi
fmq
fin
