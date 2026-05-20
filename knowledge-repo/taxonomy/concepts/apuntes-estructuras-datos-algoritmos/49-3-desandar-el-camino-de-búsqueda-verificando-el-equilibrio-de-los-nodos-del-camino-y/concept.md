# 3. 	Desandar 	el 	camino 	de 	búsqueda, 	verificando 	el 	equilibrio 	de 	los 	nodos 	del 	camino, 	y

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 49)

## Contenido
# 3. 	Desandar 	el 	camino 	de 	búsqueda, 	verificando 	el 	equilibrio 	de 	los 	nodos 	del 	camino, 	y

reequilibrándolos si es necesario.
Evidentemente, la implementación más fácil de escribir es recursiva. Se añade un parámetro de salida de tipo booleano
que indica si el subárbol en que se ha insertado la nueva clave ha aumentado de altura (dato necesario para recalcular el
factor de equilibrio). Si no ha aumentado la altura del subárbol, no cambia el factor de equilibrio del nodo padre de ese
subárbol. Si, por el contrario, ha aumentado la altura del subárbol, aparecen varias posibilidades que resumimos en la
siguiente tabla:
Caso 	Se insertó en el izquierdo 	Se insertó en el derecho
Era pesadoDer 	Ahora es equilibrado 	Hay que reequilibrar
Era equilibrado 	Ahora es pesadoIzq 	Ahora es pesadoDer
Era pesadoIzq 	Hay que reequilibrar 	Ahora es equilibrado

-- 138 of 267 --

131
Pueden darse cuatro casos distintos de desequilibrio al realizar la inserción. Quedan reflejados en las figuras siguientes,
junto con su solución para re-equilibrar. Las soluciones etiquetadas como “rotación a izquierda”, “rotación a derecha”,
“rotación doble derecha-izquierda” y “rotación doble izquierda-derecha”, pueden implementarse muy fácilmente y
con coste en O(1). Se presentará alguna de ellas posteriormente como ejemplo.
Caso 1: Izquierda-izquierda
B
A
T1 	T2 	T3
B
A
T1 	T2 	T3
SOLUCION:“rotación a izquierda”
Caso 2: Derecha-derecha
B
A
T4 	T5 	T6
SOLUCION: “rotación a derecha”
A
B
T4 	T5 	T6

-- 139 of 267 --

132
B
C
T1 T2
T4
A
T3
SOLUCION: 	“rotación doble derecha-izquierda”
PASO 1: “rotación a derecha”
B
C
T1 	T2
T4
A
T3
Caso 3: Izquierda-derecha
PASO 2: “rotación a izquierda”
B
C
T1
T2
T4
A
T3

-- 140 of 267 --

133
B
C
T8
T7
T5
A
T6
Caso 4: Derecha-izquierda SOLUCION: “rotación doble izquierda-derecha”
PASO 1: “rotación a izquierda”
B
C
T7
T5
A
T6
T8
PASO 2: “rotación a derecha”
B
C
T7
T5
A
T6 T8

-- 141 of 267 --

134
Como ya se indicó, el nodo hoja insertado se establece como equilibrado. Una vez realizada la inserción, se regresa
por el camino de búsqueda recalculando el factor de equilibrio de los nodos, hasta alcanzar la raíz o hasta encontrar un nodo
que no verifique la condición de AVL (desequilibrado), y que requiera una re-estructuración de las cuatro descritas en las
figuras anteriores para re-equilibrarlo.
Una vez re-equilibrado el nodo, el árbol resultante queda con la misma altura que tenía el árbol antes de realizar la
inserción (ver las figuras de los cuatro casos). Por lo tanto, si inicialmente el árbol estaba equilibrado, el resultante tras la
inserción también estará equilibrado. Es decir, basta con un único reajuste u operación para re-equilibrar (una de las cuatro
descritas en las figuras anteriores), para dejar todo el árbol resultante equilibrado, y no hará falta tras ella seguir regresando
por el camino de búsqueda hasta la raíz.
Un código posible para la operación de inserción, aplicando las ideas anteriores, es el siguiente:
procedimiento añadirRec(e/s p:ptNodo; ent c:clave; ent v:valor;
e/s alturaModificada:booleano; sal nuevo:booleano)
principio
si p=nil entonces
nuevodato(p);
p↑.laClave:=c;
p↑.elValor:=v;
p↑.equilibrio:=equilibrado;
p↑.izq:=nil;
p↑.der:=nil;
alturaModificada:=verdad; {se ha modificado su altura}
nuevo:=verdad 	{se ha añadido una nueva clave y valor}
sino_si c<p↑.laClave entonces
añadirRec(p↑.izq,c,v,alturaModificada,nuevo);
si alturaModificada entonces
selección
p↑.equilibrio=pesadoIzq: 	si p↑.izq↑.equilibrio=pesadoIzq entonces
rotaciónIzq(p)
sino
rotaciónIzqDer(p)
fsi;
alturaModificada:=falso;
p↑.equilibrio=equilibrado: p↑.equilibrio:=pesadoIzq;
p↑.equilibrio=pesadoDer: 	p↑.equilibrio:=equilibrado;
alturaModificada:=falso
fselección
fsi
sino_si p↑.laClave<c entonces
...
{caso simétrico al anterior; ejercicio}
...
sino {la clave ya estaba, se actualiza el valor}
p↑.elValor:=v;
nuevo:=falso
fsi
fin
procedimiento añadir(e/s d:diccionario; ent c:clave; ent v:valor)
variables alturaModificada,nuevo:booleano
principio
alturaModificada:=falso;
añadirRec(d.raíz,c,v,alturaModificada,nuevo);
si nuevo entonces
d.tamaño:=d.tamaño+1
fsi
fin
El coste en tiempo en el caso peor está en O(log n), siendo n el número de claves del diccionario. En cuanto a las
operaciones de “rotación”, presentamos dos de ellas (las otras dos se implementan de forma simétrica).

-- 142 of 267 --

135
procedimiento rotaciónIzq(e/s p:ptNodo)
variable aux:ptNodo
principio
aux:=p↑.izq;
p↑.izq:=aux↑.der;
p↑.equilibrio:=equilibrado;
aux↑.der:=p;
p:=aux;
p↑.equilibrio:=equilibrado
fin
procedimiento rotacionIzqDer(e/s p:ptNodo)
variables aux1,aux2:ptNodo
principio
aux1:=p↑.izq;
aux2:=p↑.izq↑.der;
aux1↑.der:=aux2↑.izq;
aux2↑.izq:=aux1;
p↑.izq:=aux2;
si aux2↑.equilibrio=pesadoIzq entonces
aux1↑.equilibrio:=equilibrado;
p↑.equilibrio:=pesadoDer
sino_si aux2↑.equilibrio=equilibrado
entonces
aux1↑.equilibrio:=equilibrado;
p↑.equilibrio:=equilibrado
sino
aux1↑.equilibrio:=pesadoIzq;
p↑.equilibrio:=equilibrado
fsi;
p↑.izq:=a
