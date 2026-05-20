# 2. 	Se regresa por el camino de búsqueda calculando los nuevos factores de equilibrio:

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 52)

## Contenido
# 2. 	Se regresa por el camino de búsqueda calculando los nuevos factores de equilibrio:

• 	Si en alguno de los nodos se pierde la condición de equilibrio, debe ser restaurada (re-equilibrado).
• 	Debe continuarse hasta la raíz, porque pueden ser necesarios más re-equilibrados.
Ejemplo: Borrar el nodo A del siguiente AVL. La nueva raíz será M (máximo de su subárbol izquierdo).
El árbol resultante es pesado a la derecha. Con una solución similar a la de la inserción, se re-equilibra con una rotación
a la derecha, quedando así:
En este caso, el árbol resultante ha perdido altura.
C
A
T1 T2
T4
L
T3
R
T5
M
C
M
T1 T2
T4
L
T3
R
T5
C
M
T1 T2
T4
L
T3
R
T5

-- 144 of 267 --

137
En un caso general, en el borrado, pueden ser necesarias varias operaciones de restauración del equilibrio, y hay que
seguir comprobando hasta llegar a la raíz.
El algoritmo puede escribirse de la forma siguiente (incompleto):
procedimiento quitarRec(e/s p:ptNodo; ent c:clave;
e/s alturaModificada:booleano; sal borrado:booleano)
variable aux:ptNodo
principio
si p=nil entonces
borrado:=falso
sino
si c<p↑.laClave entonces
quitarRec(p↑.izq,c,alturaModificada,borrado);
si alturaModificada entonces
equilIzq(p,alturaModificada)
fsi
sino_si p↑.laClave<c entonces
borrarRec(p↑.der,c,alturaModificada,borrado);
si alturaModificada entonces
equilDer(p,alturaModificada);
fsi
sino {clave encontrada}
si p↑.izq=nil entonces
aux:=p;
p:=p↑.der;
disponer(aux);
alturaModificada:=verdad
sino_si p↑.der=nil entonces
aux:=p;
p:=p↑.izq;
disponer(aux);
alturaModificada:=verdad
sino
borrarMaxClave(p↑.izq,p↑.laClave,p↑.elValor,alturaModificada);
si alturaModificada entonces
equilIzq(p,alturaModificada);
fsi
fsi;
borrado:=verdad
fsi
fsi
fin
procedimiento equilIzq(e/s p:ptNodo; e/s alturaModificada:booleano)
procedimiento equilDer(e/s p:ptNodo; e/s alturaModificada:booleano)
{contienen un estudio de casos similar al de la inserción}
procedimiento borrarMaxClave(e/s p:ptNodo; sal c:clave; sal v:valor;
e/s alturaModificada:boolean)
variable aux:ptNodo
principio
si p↑.der=nil entonces
c:=p↑.laClave;
v:=p↑.elValor;
aux:=p;
p:=p↑.izq;
disponer(aux);
alturaModificada:=verdad
sino
borrarMaxClave(p↑.der,c,v,alturaModificada);
si alturaModificada entonces
equilDer(p,alturaModificada)
fsi
fsi
fin

-- 145 of 267 --

138
procedimiento quitar(e/s d:diccionario; ent c:clave)
variable alturaModificada,borrado:booleano
principio
alturaModificada:=falso;
quitarRec(d.raíz,clave,alturaModificada,borrado);
si borrado entonces
d.tamaño:=d.tamaño-1
fsi
fin
El coste en tiempo en el caso peor está en O(log n), siendo n el número de claves del diccionario.
Resumimos en la siguiente tabla los costes en espacio y tiempo, en el caso peor, de las implementaciones de
diccionarios vistas hasta el momento.
Diccionario
(con n claves
comparables)
Vector tamaño MAX
(ordenado) (n ≤ MAX)
Lista enlazada
(ordenada)
Árbol binario de
búsqueda
sin equilibrar
Árbol 	binario 	de
búsqueda
equilibrado (AVL)
Coste en espacio 	O(MAX) 	O(n) 	O(n) 	O(n)
Costes en tiempo
(caso peor)
añadir 	O(n) 	O(n) 	O(n) 	O(log n)
buscar 	O(log n) 	O(n) 	O(n) 	O(log n)
borrar 	O(n) 	O(n) 	O(n) 	O(log n)

-- 146 of 267 --

139
