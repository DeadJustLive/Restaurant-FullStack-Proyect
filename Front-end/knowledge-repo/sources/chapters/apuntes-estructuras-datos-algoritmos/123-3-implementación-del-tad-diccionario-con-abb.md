# 3. Implementación del TAD diccionario con ABB

Si en lugar de almacenar un dato de tipo elemento en cada nodo del ABB, almacenamos una clave y un valor
asociado a la clave y no permitimos almacenar claves repetidas, disponemos de una estructura de datos alternativa a la
que vimos en el tema de TAD lineales (que estaba basada en una lista enlazada mediante punteros) para almacenar un valor
del TAD diccionario. Cada nodo del árbol contendrá una clave estrictamente mayor que todas las claves almacenadas en
su subárbol izquierdo y estrictamente menor que todas las claves almacenadas en su subárbol derecho. De esta forma, se
podrá realizar una búsqueda de clave utilizando el orden “<” definido en el dominio del tipo clave.
1
2
3
4

-- 126 of 267 --

119
Nótese que la interfaz del módulo es idéntica a la vista en la lección 10. Sólo cambiaremos la parte privada
(implementación) del módulo.
módulo genérico diccionariosEnABB {implementa un diccionario usando un ABB}
parámetros
tipos clave,valor
con función “<”(c1,c2:clave) devuelve booleano
con función “=”(c1,c2:clave) devuelve booleano
{suponemos que el tipo clave tiene definidas una función de orden y otra de
igualdad}
exporta
tipo diccionario {Los valores del TAD diccionario representan conjuntos de pares
(clave,valor) en los que no se permiten claves repetidas}
procedimiento crear(sal d:diccionario)
{Devuelve en d un diccionario vacío, sin elementos}
procedimiento añadir(e/s d:diccionario; ent c:clave; ent v:valor)
{Si en d no hay ningún par con clave c, añade a d el par (c,v);
si en d hay un par (c,v’), entonces lo sustituye por el par (c,v)}
procedimiento buscar(ent d:diccionario; ent c:clave;
sal éxito:booleano; sal v:valor)
{Devuelve éxito=verdad si en d hay algún par con clave c, falso en caso contrario.
En caso de éxito, además, devuelve en v el valor asociado a la clave c en d}
procedimiento quitar(ent c:clave; e/s d:diccionario)
{Si en d hay un par con clave c, lo borra. En caso contrario, d no se modifica}
función cardinal(d:diccionario) devuelve natural
{Devuelve el nº de pares del diccionario d}
función esVacío(d:diccionario) devuelve booleano
{Devuelve verdad si y sólo si d no tiene pares}
procedimiento duplicar(sal dSal:diccionario; ent dEnt diccionario)
{Duplica la representación del diccionario dEnt en el diccionario dSal}
función iguales(d1,d2:diccionario) devuelve booleano
{Devuelve verdad si y sólo si los diccionarios d1 y d2 tienen los mismos pares de
claves y valores}
procedimiento liberar(e/s d:diccionario)
{Devuelve en d el diccionario vacío y además libera la memoria utilizada
previamente por d}
procedimiento iniciarIterador(e/s d:diccionario)
{Inicializa el iterador para recorrer los pares del diccionario d, de forma que el
siguiente par a visitar sea el primero que visitamos (situación de no haber
visitado ningún par).}
función existeSiguiente(d:diccionario) devuelve booleano
{Devuelve falso si ya se han visitado todos los pares de d; verdad en otro caso}
procedimiento siguiente(e/s d:diccionario;
sal c:clave; sal v:valor; sal error:booleano)
{Si existe algún par de d pendiente de visitar, devuelve en c y v la clave
y el valor, respectivamente, del siguiente par a visitar y error=falso, y
además avanza el iterador para que a continuación se pueda visitar otro par
de d. Si no quedan pares pendientes de visitar devuelve error=verdad, c y v
quedan indefinidos y d queda como estaba}

-- 127 of 267 --

120
implementación
tipos ptNodo = ↑nodo {almacenamos el diccionario en un ABB ordenado por claves}
nodo = registro
laClave:clave; {no podrá haber 2 nodos en el árbol con la misma clave}
elValor:valor;
izq,der:ptNodo
freg
diccionario = registro
raíz:ptNodo; 	{puntero a la raíz del árbol}
tamaño:natural; {número de pares (clave,valor) almacenados}
iter:pila 	{pila de datos de tipo ptNodo, para implementar
freg 	el iterador}
procedimiento crear(sal d:diccionario)
{Devuelve en d un diccionario vacío, sin elementos}
principio
d.raíz:=nil;
d.tamaño:=0
fin
{Este procedimiento es auxiliar para el de añadir}
procedimiento añadirRec(e/s p:ptNodo; ent c:clave; ent v:valor; sal nuevo:booleano}
{Si en el árbol de raíz apuntada por p no hay ningún par con clave c, añade a ese
árbol el par (c,v) y nuevo=verdad.
Si en el árbol de raíz apuntada por p hay un par (c,v’), entonces lo sustituye
por el par (c,v) y nuevo=falso}
principio
si p=nil entonces
nuevoDato(p);
p↑.laClave:=c;
p↑.elValor:=v;
p↑.izq:=nil;
p↑.der:=nil;
nuevo:=verdad
sino
si c<p↑.laClave entonces
añadirRec(p↑.izq,c,v,nuevo)
sino_si c>p↑.laClave entonces
añadirRec(p↑.der,c,v,nuevo)
sino {c=p↑.laClave, es decir, ya existía un par con esa clave}
p↑.elValor:=v;
nuevo:=falso
fsi
fsi
fin
procedimiento añadir(e/s d:diccionario; ent c:clave; ent v:valor)
{Si en d no hay ningún par con clave c, añade a d el par (c,v);
si en d hay un par (c,v’), entonces lo sustituye por el par (c,v)}
variable nuevo:booleano
principio
añadirRec(d.raíz,c,v,nuevo);
si nuevo entonces
d.tamaño:=d.tamaño+1
fsi
fin
{Este procedimiento es auxiliar para el de buscar}
procedimiento buscarRec(ent p:ptNodo; ent c:clave; sal éxito:booleano; sal v:valor)
{Devuelve éxito=verdad si en el árbol de raíz apuntada por p hay algún par con
clave c, falso en caso contrario.
En caso de éxito, además, devuelve en v el valor asociado a la clave c}
principio
si p=nil entonces

-- 128 of 267 --

121
éxito:=falso
sino
selección
c<p↑.laClave: buscarRec(p↑.izq,c,éxito,v);
c=p↑.laClave: éxito:=verdad;
v:=p↑.elValor;
c>p↑.laClave: buscarRec(a↑.der,c,éxito,v)
fselección
fsi
fin
procedimiento buscar(ent d:diccionario; ent c:clave;
sal éxito:booleano; sal v:valor)
{Devuelve éxito=verdad si en d hay algún par con clave c, falso en caso contrario.
En caso de éxito, además, devuelve en v el valor asociado a la clave c en d}
principio
buscarRec(d.raíz,c,éxito,v)
fin
{Este procedimiento es auxiliar para el procedimiento de quitarRec, ver abajo}
procedimiento borrarMáximo(e/s p:ptNodo; sal c:clave; sal v:valor)
{Precondición: p es no vacío. Devuelve el par (c,v) cuya clave c es la máxima del
subárbol de raíz p y borra ese par del subárbol de raíz p}
variable aux:ptNodo
principio
si p↑.der=nil entonces
c:=p↑.laClave;
v:=p↑.elValor;
aux:=p;
p:=p↑.izq;
disponer(aux)
sino
borrarMáximo(p↑.der,c,v)
fsi
fin
{Este procedimiento es auxiliar para el de quitar}
procedimiento quitarRec(ent c:clave; e/s p:ptNodo; sal borrado:booleano)
{Si en el árbol de raíz apuntada por p hay un par con clave c, lo borra y
borrado=verdad. En caso contrario, p no se modifica y borrado=falso}
variable aux:ptNodo
principio
si p=nil entonces
borrado:=falso
sino
selección
c<p↑.laClave: quitarRec(c,p↑.izq,borrado);
c>p↑.laClave: quitarRec(c,p↑.der,borrado);
c=p↑.laClave: si p↑.izq=nil entonces
aux:=p;
p:=p↑.der;
disponer(aux)
sino
borrarMáximo(p↑.izq,p↑.laClave,p↑.elValor)
fsi;
borrado:=verdad
fselección
fsi
fin
procedimiento quitar(ent c:clave; e/s d:diccionario)
{Si en d hay un par con clave c, lo borra. En caso contrario, d no se modifica}
variable borrado:booleano
principio
quitarRec(c,d.raíz,borrado)
si borrado entonces

-- 129 of 267 --

122
d.tamaño:=d.tamaño-1
fsi
fin
función cardinal(d:diccionario) devuelve natural
{Devuelve el nº de pares del diccionario d}
principio
devuelve d.tamaño
fin
función esVacío(d:diccionario) devuelve booleano
{Devuelve verdad si y sólo si d no tiene pares}
principio
devuelve d.raíz=nil
fin
{Este procedimiento es auxiliar para el de duplicar}
procedimiento duplicarRec(sal pSal:ptNodo; ent pEnt:ptNodo)
{Duplica el árbol apuntado por pEnt en el árbol apuntado por pSal}
principio
si pEnt=nil entonces
pSal:=nil
sino
nuevoDato(pSal);
pSal↑.laClave:=pEnt↑.laClave;
pSal↑.elValor:=pEnt↑.elValor;
duplicarRec(pSal↑.izq,pEnt↑.izq);
duplicarRec(pSal↑.der,pEnt↑.der)
fsi
fin
procedimiento duplicar(sal dSal:diccionario; ent dEnt diccionario)
{Duplica la representación del diccionario dEnt en el diccionario dSal}
principio
duplicarRec(dSal.raíz,dEnt.raíz);
dSal.tamaño:=dEnt.tamaño
fin
{Este procedimiento es auxiliar para el de liberar}
procedimiento liberarRec(e/s p:ptNodo)
{Libera toda la memoria utilizada por el árbol apuntado por p}
principio
si p≠nil entonces
liberarRec(p↑.izq);
liberarRec(p↑.der);
disponer(p)
fsi
fin
procedimiento liberar(e/s d:diccionario)
{Devuelve en d el diccionario vacío y además libera la memoria utilizada
previamente por d}
principio
liberarRec(d.raíz);
d.tamaño:=0;
d.raíz:=nil
fin
procedimiento iniciarIterador(e/s d:diccionario)
{Inicializa el iterador para recorrer los pares del diccionario d, de forma que el
siguiente par a visitar sea el primero que visitamos (situación de no haber
visitado ningún par).}
variable aux:ptNodo
principio
crearVacía(d.iter); {crea pila vacía de punteros a nodos del árbol}

-- 130 of 267 --

123
aux:=d.raíz; {raíz del árbol}
mientrasQue aux≠nil hacer
apilar(d.iter,aux); {apila el puntero aux (a un nodo del árbol) en la pila
del iterador}
aux:=aux↑.izq
fmq
fin
función existeSiguiente(d:diccionario) devuelve booleano
{Devuelve falso si ya se han visitado todos los pares de d; verdad en otro caso}
principio
devuelve not esVacía(d.iter) {existe siguiente si la pila del iterador es no vacía}
fin
procedimiento siguiente(e/s d:diccionario;
sal c:clave; sal v:valor; sal error:booleano)
{Si existe algún par de d pendiente de visitar, devuelve en c y v la clave
y el valor, respectivamente, del siguiente par a visitar y error=falso, y
además avanza el iterador para que a continuación se pueda visitar otro par
de d. Si no quedan pares pendientes de visitar devuelve error=verdad, c y v
quedan indefinidos y d queda como estaba}
variable aux:ptNodo
principio
si existeSiguiente(d) entonces
error:=falso;
aux:=cima(d.iter);
desapilar(d.iter);
c:=aux↑.laClave; {esta es la clave del siguiente elemento visitado}
v:=aux↑.elValor; {y el valor asociado a la clave}
aux:=aux↑.der;
mientrasQue aux≠nil hacer
apilar(d.iter,aux);
aux:=aux↑.izq
fmq
sino
error:=verdad
fsi
fin
{Para la función iguales veamos dos implementaciones alternativas}
{La primera, basada en recorrer el árbol del primer diccionario en pre-orden y para
Cada uno de sus pares <clave,valor> comprobar si está en el otro diccionar.}
función iguales(d1,d2:diccionario) devuelve booleano
{Devuelve verdad si y sólo si los diccionarios d1 y d2 tienen los mismos pares de
claves y valores}
principio
si esVacío(d1) and esVacío(d2) entonces
devuelve verdad
sino_si cardinal(d1)≠cardinal(d2) entonces
devuelve falso
sino {ambos tienen el mismo número (no nulo) de pares}
devuelve igualesRec(d1.raíz,d2.raíz)
fsi
fin
{Esta función es auxiliar para la función iguales anterior}
función igualesRec(p1,p2:ptNodo) devuelve booleano
{Devuelve verdad si y sólo si todas las parejas <clave,valor> de p1 están en p2.}
variable éxito:booleano;
v:valor
principio
si p1=nil entonces
devuelve verdad {trivialmente}

-- 131 of 267 --

124
sino
buscarRec(p2,p1↑.laClave,éxito,v); {busca en p2 la raíz de p1}
si éxito andthen v=p1↑.elValor entonces {la raíz de p1 está en p2}
devuelve igualesRec(p1↑.izq,p2) andthen igualesRec(p1↑.der,p2)
sino
devuelve falso
fsi
fsi
fin
{La segunda alternativa para la función iguales se basa en usar recorridos in-orden
(como el usado en el iterador) simultáneos de ambos árboles.}
función iguales(d1,d2:diccionario) devuelve booleano
{Devuelve verdad si y sólo si los diccionarios d1 y d2 tienen los mismos pares de
claves y valores}
variables igual:booleano;
aux1,aux2:ptNodo;
pila1,pila2:pila {pilas de datos de tipo ptNodo}
principio
si esVacío(d1) and esVacío(d2) entonces
devuelve verdad
sino_si cardinal(d1)≠cardinal(d2) entonces
devuelve falso
sino {ambos tienen el mismo número (no nulo) de claves:
los recorremos simultáneamente en orden por clave (in-orden)}
igual:=verdad;
{inicializar recorrido en diccionario d1: llegar hasta el primero en in-orden
dejando la pila preparada con los nodos del camino desde la raíz}
crear(pila1);
aux1:=d1.raíz;
mientrasQue aux1≠nil hacer
apilar(pila1,aux1);
aux1:=aux1↑.izq
fmq;
{lo mismo con diccionario d2}
crear(pila2);
aux2:=d2.raíz;
mientrasQue aux2≠nil hacer
apilar(pila2,aux2);
aux2:=aux2↑.izq
fmq;
{mientras sean iguales y no se hayan tratado todos}
mientrasQue igual and not esVacía(pila1) hacer {pila2 se vacía al mismo tiempo}
{obtener el siguiente par <clave,valor> de cada diccionario}
aux1:=cima(pila1);
aux2:=cima(pila2);
{compararlos}
igual:=(aux1↑.laClave=aux2↑.laClave) and (aux1↑.elValor=aux2↑.elValor);
{avanzar, para preparar el siguiente dato a tratar en diccionario d1}
desapilar(pila1);
aux1:=aux1↑.der;
mientrasQue pAux1≠nil hacer
apilar(pila1,aux1);
aux1:=aux1↑.izq
fmq
{lo mismo con diccionario d2}
desapilar(pila2);
aux2:=aux2↑.der;
mientrasQue aux2≠nil hacer
apilar(pila2,aux2);
aux2:=aux2↑.izq
fmq

-- 132 of 267 --

125
fmq;
devuelve igual
fsi
fin
fin {del módulo}
En cuanto al coste en tiempo de las operaciones en el caso peor, las operaciones fundamentales del diccionario,
buscar, añadir y quitar, tienen un coste en el caso peor en O(n), es decir, lineal en n, siendo n el número de claves
del diccionario. Esto es así porque el árbol podría ser degenerado, como ya se explicó en la sección anterior.
Tal y como se dijo en la sección anterior, si no es necesario garantizar un coste bajo en el caso peor y nos conformamos
con el caso promedio, un ABB es una buena solución para almacenar un diccionario porque puede demostrarse que, en
media, la altura de un ABB generado aleatoriamente es logarítmica en el número de claves.

-- 133 of 267 --

126

-- 134 of 267 --

127