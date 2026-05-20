# 3. Ejemplo de implementación (árboles 2–3)

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 71)

## Contenido
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
{elemento más pequeño del subárbol al que apunta
