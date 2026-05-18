# 3. Ejemplo de implementación (árboles 2–3)

Presentamos, a modo de ejemplo, los detalles de implementación de una de las múltiples clases de árboles n–arios de
búsqueda equilibrados definidos en la literatura. Se trata de árboles B de grado 3, pero “al estilo de” los árboles B+. Es
decir, suponiendo que las claves se guardan únicamente en las hojas. En los nodos internos se guardan las copias de las
claves necesarias para hacer la búsqueda.
Ejemplo de árbol 2–3
Supongamos que en el árbol anterior se quiere insertar la clave 18. El resultado sería el siguiente.
Si a continuación se desea insertar la clave 1, resultaría lo siguiente.
Como puede verse, ha sido necesario partir el nodo “11:12” en dos (“8:–” y “12:–”), y repartir entre los dos nodos
resultantes los hijos del nodo anterior tras insertar la nueva clave. Y además modificar el nodo padre del “11:12”.
Si en el árbol resultante insertamos la clave 19, se necesita partir en dos el nodo “17:18”, pero en ese momento su nodo
padre resulta tener 4 hijos, lo que no está permitido.
11	8 	12 	16 17 	23	22 	31 	41 52 	59	58 	61
11:12 	17:— 	23:31 	52:— 	59:61
16:— 	41:58
22:—
11	8 	12 16 17 	23	22 	31 	41 	52 	59	58 	61
11:12 	17:18 	23:31 	52:— 	59:61
16:— 	41:58
22:—
18
11	8 	12 	16 17 	23	22 	31 	41 52 	59	58 	61
12:— 	17:18 	23:31 	52:— 	59:61
11:16 	41:58
22:—
18
8:—
1
11	8 	12 	16 17
12:— 	17:—
11:16
22:—
23	22 	31 	41 52 	59	58 	61
23:31 	52:— 	59:61
41:58
18
8:—
1 	19
19:—

-- 159 of 267 --

152
Por tanto, se hace necesario también partir el nodo “11:16” en dos (afectando a la raíz), resultando el árbol siguiente.
Si, para terminar, se precisa insertar la clave 28, se hace necesario partir en dos el nodo “23:31”, y también su padre,
el “41:58”, porque pasaría a tener 4 hijos.
Pero entonces el nodo raíz del árbol, “16:22”, quedaría con 4 hijos, y como no es posible, se hace necesario partir en
dos el nodo raíz y colocar como padre de ambos un nuevo nodo raíz, con el siguiente resultado.
Para implementarlo, declaramos la estructura de datos necesaria:
tipos
tipoElmto = registro
clave:tipoClave;
... {el resto de campos necesarios (valor asociado a la clave)}
freg;
tipoNodo = (hoja,interior);
diccionario = ↑nodoDosTres;
nodoDosTres =
registro
clase:tipoNodo;
{el siguiente campo sólo se usa si clase=hoja}
elmto:tipoElmto;
{los siguientes campos sólo se usan si clase=interior}
primerHijo,segundoHijo,tercerHijo:diccionario;
menorDeSegundo,menorDeTercero:tipoClave
freg
11	8 	12 	16 17
12:— 	17:—
11:—
16:22
23	22 	31 	41 	52 	59	58 	61
23:31 	52:— 	59:61
41:58
18
8:—
1 	19
19:—
18:—
11	8 	12 	16 17
12:— 	17:—
11:—
16:22
28:—
59	58 	61
59:61
41 52
52:—
23	22 	28
23:—
18
8:—
1 	19
19:—
18:—
31
31:—
58:—
11	8 	12 	16 17
12:— 	17:—
11:—
16:—
28:—
59	58 	61
59:61
41 	52
52:—
23	22 	28
23:—
18
8:—
1 	19
19:—
18:—
31
31:—
58:—
41:—
22:—

-- 160 of 267 --

153
El algoritmo de inserción (o modificación, si la clave ya estaba en el diccionario) sería el siguiente.
procedimiento insertar(ent x:tipoElmto; e/s d:diccionario)
variables
ptAtrás:diccionario; {puntero al nuevo nodo devuelto por insertaRec}
menorAtrás:tipoClave; {valor mínimo en el subárbol de ptAtrás}
guardaD:diccionario; {para almacenar una copia temporal de d}
ptNuevo:diccionario
principio
{mirar si d está vacío o si tiene un solo nodo y tratar esos casos especiales}
si d=nil entonces {d era vacío; se crea con una sola clave}
nuevoDato(d);
d↑.clase:=hoja;
d↑.elmto:=x;
sino_si d↑.clase=hoja entonces {d no era vacío pero era sólo una hoja}
si d↑elmto.clave=x.clave entonces {la clave es igual que la que había}
d↑elmto:=x 	{se actualiza el resto de la información asociada a la clave}
sino {hay que crear una nueva hoja para la nueva clave, usamos ptNuevo}
nuevoDato(ptNuevo);
ptNuevo↑.clase:=hoja;
ptNuevo↑.elmto:=x;
guardaD:=d; {copia de la antigua raíz, que era una hoja}
nuevoDato(d); {será la nueva raíz}
d↑.clase:=interior;
d↑.tercerHijo:=nil; {d sólo tendrá 2 hijos, ptNuevo y guardaD}
si x.clave<guardaD↑.elmto.clave entonces {la nueva es menor que la que había}
d↑.primerHijo:=ptNuevo;
d↑.segundoHijo:=guardaD;
d↑.menorDeSegundo:=guardaD↑elmto.clave
sino {la nueva es mayor que la que había}
d↑.primerHijo:=guardaD;
d↑.segundoHijo:=ptNuevo;
d↑.menorDeSegundo:=x.clave {es igual a ptNuevo↑.elmto.clave}
fsi
fsi
sino {d tenía al menos dos claves (inserción con un algoritmo recursivo)}
insertarRec(d,x,ptAtrás,menorAtrás);
si ptAtrás≠nil entonces
{crea la raíz nueva; sus hijos están ahora apuntados por d y ptAtrás}
guardaD:=d;
nuevoDato(d);
d↑.clase:=interior;
d↑.primerHijo:=guardaD;
d↑.segundoHijo:=ptAtrás;
d↑.menorDeSegundo:=menorAtrás;
d↑.tercerHijo:=nil
fsi
fsi
fin
Una primera descripción del algoritmo de inserción recursivo utilizado por el anterior es la siguiente.
procedimiento insertarRec(e/s nodo:diccionario;
ent x:tipoElmto; 	{x se insertará en el subárbol de nodo}
sal ptNuevo:diccionario;
{puntero al nodo recién creado a la derecha de nodo}
sal menor:tipoClave)
{elemento más pequeño del subárbol al que apunta ptNuevo}
principio
ptNuevo:=nil;
si nodo es una hoja entonces
si x no es el elemento que está en nodo entonces
crea un nodo nuevo apuntado por ptNuevo;
pone x en el nodo nuevo;
menor:=x.clave
fsi
sino {nodo es un nodo interno}

-- 161 of 267 --

154
sea w el hijo de nodo a cuyo subárbol pertenece x;
insertarRec(w,x,ptAtrás,menorAtrás);
si ptAtrás≠nil entonces
insertar el puntero ptAtrás entre los hijos de nodo justo a la derecha de w;
si nodo tiene cuatro hijos entonces
crear un nodo nuevo apuntado por ptNuevo;
dar al nuevo nodo los hijos 3º y 4º de nodo;
ajustar menorDeSegundo y menorDeTercero en nodo y el nodo nuevo;
colocar menor como la menor clave entre los hijos del nodo nuevo
fsi
fsi
fsi
fin
Y ya con todos los detalles, queda como sigue.
procedimiento insertarRec(e/s nodo:diccionario;
ent x:tipoElmto; {x se insertará en el subárbol de nodo}
sal ptNuevo:diccionario;
{puntero al nodo recién creado a la derecha de nodo}
sal menor:tipoClave)
{elemento más pequeño del subárbol al que apunta ptNuevo}
variables
ptAtrás:diccionario;
menorAtrás:tipoClave;
hijo:1..3; {indica qué hijo de nodo se sigue en la llamada recursiva (relacionado
con la variable w de la descripción anterior del algoritmo)}
w:diccionario {puntero al hijo}
principio
ptNuevo:=nil;
si nodo↑.clase=hoja entonces
si nodo↑.elmto.clave=x.clave entonces {la clave es igual que una que había}
nodo↑.elmto:=x 	{se actualiza el resto de la información asociada a la clave}
sino {crea una hoja nueva que contiene x.clave y "devuelve" este nodo}
nuevoDato(ptNuevo);
ptNuevo↑.clase:=hoja;
si nodo↑.elmto.clave<x.clave entonces
{pone x en el nuevo nodo a la derecha del nodo actual}
ptNuevo↑.elmto:=x;
menor:=x.clave
sino {x está a la izquierda del elemento en el nodo actual}
ptNuevo↑.elmto:=nodo↑.elmto;
nodo↑.elmto:=x;
menor:=ptNuevo↑.elmto.clave
fsi
fsi
sino {nodo es un nodo interno}
{selecciona el hijo de nodo que se debe seguir}
si x.clave<nodo↑.menorDeSegundo entonces
hijo:=1;
w:=nodo↑.primerHijo
sino
si (nodo↑.tercerHijo=nil) or (x.clave<nodo↑.menorDeTercero) entonces
{x está en el segundo subárbol}
hijo:=2;
w:=nodo↑.segundoHijo
sino {x está en el tercer subárbol}
hijo:=3;
w:=nodo↑.tercerHijo
fsi
fsi;
insertarRec(w,x,ptAtrás,menorAtrás);
si ptAtrás≠nil entonces 	{debe insertarse un nuevo hijo de nodo}
si nodo↑.tercerHijo=nil entonces {nodo tiene 2 hijos, así que se inserta el
nuevo en el lugar adecuado}
si hijo=2 entonces
nodo↑.tercerHijo:=ptAtrás;

-- 162 of 267 --

155
nodo↑.menorDeTercero:=menorAtrás
sino {hijo=1}
nodo↑.tercerHijo:=nodo↑.segundoHijo;
nodo↑.menorDeTercero:=nodo↑.menorDeSegundo;
nodo↑.segundoHijo:=ptAtrás;
nodo↑.menorDeSegundo:=menorAtrás
fsi
sino {nodo ya tiene tres hijos}
nuevoDato(ptNuevo);
ptNuevo↑.clase:=interior;
si hijo=3 entonces {ptAtrás y el 3er hijo se convierten en hijos del nuevo nodo}
ptNuevo↑.primerHijo:=nodo↑.tercerHijo;
ptNuevo↑.segundoHijo:=ptAtrás;
ptNuevo↑.tercerHijo:=nil;
ptNuevo↑.menorDeSegundo:=menorAtrás;
{menorDeTercero está indefinido para ptNuevo}
menor:=nodo↑.menorDeTercero;
nodo↑.tercerHijo:=nil
sino {hijo
≤2; pasa el tercer hijo de nodo a ptNuevo}
ptNuevo↑.segundoHijo:=nodo↑.tercerHijo;
ptNuevo↑.menorDeSegundo:=nodo↑.menorDeTercer;
ptNuevo↑.tercerHijo:=nil;
nodo↑.tercerHijo:=nil
si hijo=2 entonces 	{ptAtrás se convierte en el primer hijo de ptNuevo}
ptNuevo↑.primerHijo:=ptAtrás;
menor:=menorAtrás
else {hijo=1; el 2º hijo de nodo pasa a ptNuevo y
ptAtrás se convierte en el 2º hijo de nodo}
ptNuevo↑.primerHijo:=nodo↑.segundoHijo;
menor:=nodo↑.menorDeSegundo;
nodo↑.segundoHijo:=ptAtrás;
nodo↑.menorDeSegundo:=menorAtrás
fsi
fsi
fsi
fsi
fsi
fin
En cuanto al algoritmo de borrado, queda como sigue.
procedimiento borrar(e/s d:diccionario; ent c:tipoClave)
variables unHijo:booleano;
ptAux:diccionario;
menor:tipoClave
principio
si d≠nil entonces {caso contrario no hay nada que borrar}
si d↑.clase=hoja entonces {d sólo tenía un elemento}
si d↑.elmto.clave=c entonces {hay que borrarlo; en otro caso, no hacer nada}
disponer(d);
d:=nil
fsi
sino {el diccionario tiene más de un elemento}
borrarRec(d,c,unHijo,menor);
si unHijo entonces {la raíz (d) sólo tiene un hijo}
{hay que eliminar la raíz y hacer que d sea el que era su único hijo}
ptAux:=d;
d:=d↑.primerHijo;
disponer(ptAux)
fsi
fsi
fsi
fin
Una implementación del algoritmo recursivo de borrado es la siguiente. Resulta algo más largo por el elevado número
de casos.

-- 163 of 267 --

156
procedimiento borrarRec(e/s p:diccionario; ent c:tipoClave;
sal unHijo:booleano; sal menor:tipoClave)
{borra el elmto con clave c de p; si p se queda con un solo hijo devuelve verdad
en unHijo; si c es la menor de p entonces 'menor' devuelve
la siguiente clave más pequeña de p}
variables soloUno:booleano;
w:diccionario;
hijo:1..3
principio
unHijo:=falso;
si p↑.primerHijo↑.clase=hoja entonces {los hijos de p son hojas}
si p↑.primerHijo↑.elmnto.clave=c entonces {la clave a borrar es el 1er hijo de p}
disponer(p↑.primerHijo); {se borra}
p↑.primerHijo:=p↑.segundoHijo; {se desplaza el segundo hacia la izquierda}
menor:=p↑.primerHijo↑.elmto.clave; {se ha borrado la menor, se actualiza}
si p↑.tercerHijo=nil entonces {ahora p tiene un solo hijo}
unHijo:=verdad;
p↑.segundoHijo=nil
sino {se desplaza el tercero hacia su izquierda}
p↑.segundoHijo:=p↑.tercerHijo;
p↑.tercerHijo:=nil;
p↑.menorDeSegundo:=p↑.menorDeTercero
fsi
sino_si p↑.segundoHijo↑.elmnto.clave=c entonces {hay que borrar el 2º hijo de p}
disponer(p↑.segundoHijo); {se borra}
si p↑.tercerHijo=nil entonces {ahora p tiene un solo hijo}
unHijo:=verdad;
p↑.segundoHijo:=nil
sino {se desplaza el tercero hacia su izquierda}
p↑.segundoHijo:=p↑.tercerHijo;
p↑.tercerHijo:=nil;
p↑.menorDeSegundo:=p↑.menorDeTercero
fsi
sino_si p↑.tercerHijo≠nil andthen p↑.tercerHijo↑.elmnto.clave=c entonces
{la clave a borrar es el tercer hijo de p}
disponer(p↑.tercerHijo); {se borra}
p↑.tercerHijo:=nil
fsi
sino {los hijos de p no son hojas}
{se selecciona el hijo de p en que hay que borrar}
si c<p↑.menorDeSegundo entonces {si está, está en el 1er subárbol}
hijo:=1;
w:=p↑.primerHijo
sino_si p↑.tercerHijo=nil orelse c<p↑.menorDeTercero entonces
{si está, está en el 2º subárbol}
hijo:=2;
w:=p↑.segundoHijo
sino 	{si está, está en el tercer subárbol}
hijo:=3;
w:=p↑.tercerHijo
fsi;
borrarRec(w,c,soloUno,menor);
si soloUno entonces {arreglar hijos de p para que ninguno tenga menos de 2 hijos}
si hijo=1 entonces {el primer hijo de p sólo tiene un hijo}
si p↑.segundoHijo↑.tercerHijo≠nil entonces {el 2º hijo de p tiene 3 hijos}
{pasar el 1º hijo del 2º de p a 2º hijo del 1º de p}
p↑.primerHijo↑.segundoHijo:=p↑.segundoHijo↑.primerHijo;
p↑.primerHijo↑.menorDeSegundo:=p↑.menorDeSegundo;
p↑.menorDeSegundo:=p↑.segundoHijo↑.menorDeSegundo;
p↑.segundoHijo↑.primerHijo:=p↑.segundoHijo↑.segundoHijo;
p↑.segundoHijo↑.segundoHijo:=p↑.segundoHijo↑.tercerHijo;
p↑.segundoHijo↑.menorDeSegundo:=p↑.segundoHijo↑.menorDeTercero;
p↑.segundoHijo↑.tercerHijo:=nil
sino {el segundo hijo de p tiene dos hijos}
{pasar el hijo del primer hijo de p como primer hijo del segundo de p
y eliminar el primer hijo de p}

-- 164 of 267 --

157
w:=p↑.primerHijo {se hace una copia para eliminarlo luego}
p↑.primerHijo:=p↑.segundoHijo;
p↑.segundoHijo:=p↑.tercerHijo;
p↑.tercerHijo:=nil;
p↑.primerHijo↑.tercerHijo:=p↑.primerHijo↑.segundoHijo;
p↑.primerHijo↑.menorDeTercero:=p↑.primerHijo↑.menorDeSegundo;
p↑.primerHijo↑.segundoHijo:=p↑.primerHijo↑.primerHijo;
p↑.primerHijo↑.menorDeSegundo:=p↑.menorDeSegundo;
p↑.primerHijo↑.primerHijo:=w↑.primerHijo;
disponer(w);
p↑.menorDeSegundo:=p↑.menorDeTercero;
si p↑.segundoHijo=nil entonces {ahora p sólo tiene un hijo}
unHijo:=verdad
fsi
fsi
sino_si hijo=2 entonces {el 2º hijo de p sólo tiene un hijo}
si p↑.primerHijo↑.tercerHijo≠nil entonces {el primer hijo de p tiene tres hijos}
{pasar el tercer hijo del primer hijo de p como primer hijo del 2º de p}
p↑.segundoHijo↑.segundoHijo:=p↑.segundoHijo↑.primerHijo;
si p↑.menorDeSegundo=c entonces {se borró la clave menor del 2º hijo de p}
p↑.segundoHijo↑.menorDeSegundo:=menor
sino {no ha cambiado la clave menor de 2º hijo de p}
p↑.segundoHijo↑.menorDeSegundo:=p↑.menorDeSegundo
fsi;
p↑.segundoHijo↑.primerHijo:=p↑.primerHijo↑.tercerHijo;
p↑.menorDeSegundo:=p↑.primerHijo↑.menorDeTercero;
p↑.primerHijo↑.tercerHijo:=nil
sino {el primer hijo de p tiene dos hijos}
si p↑.tercerHijo≠nil andthen p↑.tercerHijo↑.tercerHijo≠nil entonces
{el 3º hijo de p existe y tiene tres hijos}
{se pasa el 1º hijo del 3º de p como 2º del 2º de p}
p↑.segundoHijo↑.segundoHijo:=p↑.tercerHijo↑.primerHijo;
p↑.segundoHijo↑.menorDeSegundo:=p↑.menorDeTercero;
p↑.menorDeTercero:=p↑.tercerHijo↑.menorDeSegundo;
si p↑.menorDeSegundo=c entonces
{se ha borrado la menor clave del 2º hijo de p}
p↑.menorDeSegundo:=menor
fsi;
p↑.tercerHijo↑.primerHijo:=p↑.tercerHijo↑.segundoHijo;
p↑.tercerHijo↑.segundoHijo:= p↑.tercerHijo↑.tercerHijo;
p↑.tercerHijo↑.tercerHijo:=nil;
p↑.tercerHijo↑.menorDeSegundo:=p↑.tercerHijo↑.menorDeTercero
sino {ningún otro hijo de p tiene tres hijos}
{el único hijo del 2º hijo de p pasa a ser el 3er hijo del 1er hijo de p}
p↑.primerHijo↑.tercerHijo:=p↑.segundoHijo↑.primerHijo;
si p↑.menorDeSegundo=c entonces {se ha borrado la menor clave del
2º hijo de p}
p↑.primerHijo↑.menorDeTercero:=menor
sino
p↑.primerHijo↑.menorDeTercero:=p↑.menorDeSegundo
fsi;
disponer(p↑.segundoHijo);
p↑.segundoHijo:=p↑.tercerHijo;
p↑.tercerHijo:=nil;
p↑.menorDeSegundo:=p↑.menorDeTercero
si p↑.segundoHijo=nil entonces {p se ha quedado con un solo hijo}
unHijo:=verdad
fsi
fsi
fsi
sino {hijo=3; el tercer hijo de p sólo tiene un hijo}
si p↑.segundoHijo↑.tercerHijo≠nil entonces {el 2º hijo de p tiene 3 hijos}
{pasar el 3er hijo del 2º hijo de p como 1er hijo del 3er hijo de p}
p↑.tercerHijo↑.segundoHijo:=p↑.tercerHijo↑.primerHijo;
si p↑.menorDeTercero=c entonces {borrada la menor clave del 3er hijo de p}
p↑.tercerHijo↑.menorDeSegundo:=menor

-- 165 of 267 --

158
sino
p↑.tercerHijo↑.menorDeSegundo:=p↑.menorDeTercero
fsi;
p↑.tercerHijo↑.primerHijo:=p↑.segundoHijo↑.tecerHijo;
p↑.menorDeTercero:=p↑.segundoHijo↑.menorDeTercero;
p↑.segundoHijo↑.tecerHijo:=nil
sino {el segundo hijo de p tiene dos hijos}
{el único hijo del 3er hijo de p pasa como 3er hijo del 2º hijo de p}
p↑.segundoHijo↑.tercerHijo:=p↑.tercerHijo↑.primerHijo;
si p↑.menorDeTercero=c entonces {borrada la menor clave del 3er hijo de p}
p↑.segundoHijo↑.menorDeTercero:=menor
sino
p↑.segundoHijo↑.menorDeTercero:=p↑.menorDeTercero
fsi;
disponer(p↑.tercerHijo);
p↑.tercerHijo:=nil
fsi
fsi
sino {soloUno=falso; todos los hijos de p tienen 2 ó 3 hijos}
{falta ver si hay que cambiar p↑.menorDeSegundo o p↑.menorDeTercero}
si hijo=2 entonces
si p↑.menorDeSegundo=c entonces
p↑.menorDeSegundo:=menor
fsi
sino_si hijo=3 entonces
si p↑.menorDeTercero=c entonces
p↑.menorDeTercero:=menor
fsi
fsi {si hijo=1 no cambian p↑.menorDeSegundo ni p↑.menorDeTercero}
fsi
fsi
fin
Para terminar, veamos el algoritmo de búsqueda.
procedimiento buscarRec(ent p:diccionario; ent c:tpClave;
sal exito:booleano; sal x:tipoElmto)
principio
si p↑.clase=hoja entonces
si c=p↑.elemto.clave entonces {clave encontrada}
exito:=verdad;
x:= p↑.elemto
sino {clave no encontrada}
exito:=falso
fsi
sino {p↑.clase=interior}
si c<p↑.menorDeSegundo entonces {buscar en el primer subárbol}
buscarRec(p↑.primerHijo,c,exito,x)
sino {buscar en el segundo o en el tercero}
si (p↑.tercerHijo=nil) or (p↑.tercerHijo≠nil andthen c<p↑.menorDeTercero) entonces
buscarRec(p↑.segundoHijo,c,exito,x)
sino {buscar en el tercer subárbol}
buscarRec(p↑.tercerHijo,c,exito,x)
fsi
fsi
fsi
fin
procedimiento buscar(ent d:diccionario; ent c:tpClave;
sal exito:booleano; sal x:tipoElmto)
principio
si d=nil entonces 	{diccionario vacío}
exito:=falso
sino 	{diccionario no vacío}
buscarRec(d,c,exito,x)
fsi
fin

-- 166 of 267 --

159