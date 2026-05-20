# 3. Implementación con listas enlazadas ordenadas

Para evitar la limitación en tiempo de compilación del cardinal máximo (max) del diccionario que imponen las
implementaciones estáticas, basadas en vectores, y para evitar que el coste espacial para almacenar un diccionario sea
O(max), independientemente del cardinal del diccionario, vamos a detallar una implementación dinámica (i.e., basada en
punteros) consistente en almacenar cada par del diccionario en un registro en memoria dinámica y enlazar esos registros en
una lista con punteros, de forma similar a como hicimos con pilas y colas.
Caben dos opciones para crear esa lista encadenada con punteros: mantener los pares del diccionario en algún orden
específico o dejarlos en cualquier orden. Desde el punto de vista del tiempo de ejecución de las operaciones en el caso peor,
esa decisión no afecta al orden de magnitud del coste. Sin embargo, desde el punto de vista más práctico, puede resultar útil
mantener los pares de la lista ordenados por valores crecientes de la clave. Evidentemente, para que esto sea posible, debe
exigirse que el TAD de las claves disponga de una relación de orden total, es decir, de una operación “_<_” de comparación
de claves como la que se ha exigido al parámetro de tipo “clave” en la especificación del principio de esta lección.
La que sigue es una implementación del TAD diccionario utilizando una lista enlazada con punteros, ordenada por
valores crecientes de las claves.

-- 97 of 267 --

90
módulo genérico diccionarios
parámetros
tipos clave,valor
con función “<”(c1,c2:clave) devuelve booleano
con función “=”(c1,c2:clave) devuelve booleano
{suponemos que el tipo clave tiene definidas una función de orden y otra de
igualdad}
exporta
tipo diccionario 	{Los valores del TAD diccionario representan conjuntos de pares
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

-- 98 of 267 --

91
implementación
tipos ptCelda = ↑unaCelda;
unaCelda = registro
laClave:clave;
elValor:valor;
sig:ptCelda
freg
diccionario = registro
primerPar:ptCelda; {lista enlazada, ordenada por clave (“<”)}
tamaño:natural;
iter:ptCelda {para implementar el iterador}
freg
procedimiento crear(sal d:diccionario)
{Devuelve en d un diccionario vacío, sin elementos}
principio
d.primerPar:=nil;
d.tamaño:=0
fin
procedimiento añadir(e/s d:diccionario; ent c:clave; ent v:valor)
{Si en d no hay ningún par con clave c, añade a d el par (c,v);
si en d hay un par (c,v’), entonces lo sustituye por el par (c,v)}
variables pAux,nuevo:ptCelda
principio
si d.primerPar=nil entonces {lista vacía}
nuevoDato(d.primerPar);
d.primerPar↑.laClave:=c;
d.primerPar↑.elValor:=v;
d.primerPar↑.sig:=nil;
d.tamaño:=1
sino
si c<d.primerPar↑.laClave entonces {inserción al principio}
pAux:=d.primerPar;
nuevoDato(d.primerPar);
d.primerPar↑.laClave:=c;
d.primerPar↑.elValor:=v;
d.primerPar↑.sig:=pAux;
d.tamaño:=d.tamaño+1
sino
si c=d.primerPar↑.laClave entonces {ya existe, cambiar valor}
d.primerPar↑.elValor:=v
sino {c>d.primerPar
↑.laClave => buscar punto de inserción}
pAux:= d.primerPar;
mq pAux↑.sig≠nil andthen pAux↑.sig↑.laClave<c hacer {andthen: evaluación
perezosa (o cortocircuitada) del producto lógico, como el operador && de C++}
pAux:=pAux↑.sig
fmq;
si pAux↑.sig≠nil andthen c=pAux↑.sig↑.laClave entonces {clave ya existe}
pAux↑.sig↑.elValor:=v
sino {inserción entre dos registros o al final}
nuevoDato(nuevo);
nuevo↑.laClave:=c;
nuevo↑.elValor:=v;
nuevo↑.sig:=pAux↑.sig;
pAux↑.sig:=nuevo;
d.tamaño:=d.tamaño+1
fsi
fsi
fsi
fsi
fin

-- 99 of 267 --

92
procedimiento buscar(ent d:diccionario; ent c:clave;
sal éxito:booleano; sal v:valor)
{Devuelve éxito=verdad si en d hay algún par con clave c, falso en caso contrario.
En caso de éxito, además, devuelve en v el valor asociado a la clave c en d}
variable pAux:ptCelda
principio
pAux:=d.primerPar;
mientrasQue pAux≠nil andthen pAux↑.laClave<c hacer
pAux:=pAux↑.sig
fmq;
si pAux=nil entonces
éxito:=falso
sino
si pAux↑.laClave=c entonces
v:=pAux↑.elValor;
éxito:=verdad
sino
éxito:=falso
fsi
fsi
fin
procedimiento quitar(ent c:clave; e/s d:diccionario)
{Si en d hay un par con clave c, lo borra. En caso contrario, d no se modifica}
variables pAux1,pAux2:ptCelda;
parar:booleano
principio
si d.primerPar≠nil entonces {caso contrario, no hacer nada}
si d.primerPar↑.laClave<=c entonces {caso contrario, no hacer nada}
si d.primerPar↑.laClave=c entonces {borrar el primer elemento}
pAux1:=d.primerPar;
d.primerPar:=d.primerPar↑.sig;
disponer(pAux1);
d.tamaño:=d.tamaño-1
sino {d.primera
↑.laClave<c => buscar la clave c a partir del 2º elemento}
parar:=falso;
pAux1:=d.primerPar↑.sig;
pAux2:=d.primerPar;
mientrasQue pAux1≠nil and not parar hacer
si c<pAux1↑.laClave entonces {la clave no está, no hacer nada}
parar:=verdad
sino_si c=pAux1↑.laClave entonces {borrar el registro}
pAux2↑.sig:=pAux1↑.sig;
disponer(pAux1);
parar:=verdad;
d.tamaño:=d.tamaño-1
sino {pAux1
↑.laClave<c => avanzar}
pAux2:=pAux1;
pAux1:=pAux1↑.sig
fsi
fmq
fsi
fsi
fsi
fin
función cardinal(d:diccionario) devuelve natural
{Devuelve el nº de pares del diccionario d}
principio
devuelve d.tamaño
fin

-- 100 of 267 --

93
función esVacío(d:diccionario) devuelve booleano
{Devuelve verdad si y sólo si d no tiene pares}
principio
devuelve d.tamaño=0
fin
procedimiento duplicar(sal dSal:diccionario; ent dEnt:diccionario)
{Duplica la representación del diccionario dEnt en el diccionario dSal}
variables pAuxEnt,pAuxSal:ptCelda
principio
si esVacío?(dEnt) entonces
crear(dSal)
sino {dEnt no vacío => tiene una primera celda}
nuevoDato(dSal.primerPar);
dSal.primerPar↑.laClave:=dEnt.primerPar↑.laClave;
dSal.primerPar↑.elValor:=dEnt.primerPar↑.elValor;
pAuxEnt:=dEnt.primerPar↑.sig;
pAuxSal:=dSal.primerPar;
mientrasQue pAuxEnt≠nil hacer
nuevoDato(pAuxSal↑.sig);
pAuxSal:=pAuxSal↑.sig;
pAuxSal↑.laClave:=pAuxEnt↑.laClave;
pAuxSal↑.elValor:=pAuxEnt↑.elValor;
pAuxEnt:=pAuxEnt↑.sig
fmq;
pAuxSal↑.sig:=nil;
dSal.tamaño:=dEnt.tamaño
fsi
fin
función iguales(d1,d2:diccionario) devuelve booleano
{Devuelve verdad si y sólo si los diccionarios d1 y d2 tienen los mismos pares de
claves y valores}
variables pAux1,pAux2:ptCelda;
igual:booleano
principio
si esVacío(d1) and esVacío(d2) entonces
devuelve verdad
sino_si cardinal(d1)≠cardinal(d2) entonces
devuelve falso
sino {ambos tienen el mismo número (no nulo) de pares}
igual:=verdad;
pAux1:=d1.primerPar;
pAux2:=d2.primerPar;
mientrasQue igual and pAux1≠nil hacer
igual:=(pAux1↑.laClave=pAux2↑.laClave) and (pAux1↑.elValor=pAux2↑.elValor);
pAux1:=pAux1↑.sig;
pAux2:=pAux2↑.sig
fmq;
devuelve igual
fsi
fin
procedimiento liberar(e/s d:diccionario)
{Devuelve en d el diccionario vacío y además libera la memoria utilizada
previamente por d}
variable pAux:ptCelda
principio
pAux:=d.primerPar;
mientrasQue pAux≠nil hacer
d.primerPar:=d.primerPar↑.sig;

-- 101 of 267 --

94
disponer(pAux);
pAux:=d.primerPar
fmq;
crear(d)
fin
procedimiento iniciarIterador(e/s d:diccionario)
{Inicializa el iterador para recorrer los pares del diccionario d, de forma que el
siguiente par a visitar sea el primero que visitamos (situación de no haber
visitado ningún par).}
principio
d.iter:=d.primerPar
fin
función existeSiguiente(d:diccionario) devuelve booleano
{Devuelve falso si ya se han visitado todos los pares de d; verdad en otro caso}
principio
devuelve d.iter≠nil
fin
procedimiento siguiente(e/s d:diccionario;
sal c:clave; sal v:valor; sal error:booleano)
{Si existe algún par de d pendiente de visitar, devuelve en c y v la clave y
el valor, respectivamente, del siguiente par a visitar y error=falso, y
además avanza el iterador para que a continuación se pueda visitar otro par
de d. Si no quedan pares pendientes de visitar devuelve error=verdad, c y v
quedan indefinidos y d queda como estaba}
principio
si existeSiguiente(d) entonces
error:=falso;
c:=d.iter↑.laClave; v:=d.iter↑.elValor;
d.iter:=d.iter↑.sig
sino
error:=verdad
fsi
fin
fin {del módulo diccionarios}
A continuación, para finalizar, se presenta un código alternativo del procedimiento de añadir que puede sugerir nuevas
ideas para insertar en una lista enlazada. Se recomienda una lectura reposada, comparándolo con la implementación escrita
más arriba.
procedimiento añadir(e/s d:diccionario; ent c:clave; ent v:valor)
{Si en d no hay ningún par con clave c, añade a d el par (c,v);
si en d hay un par (c,v’), entonces lo sustituye por el par (c,v)}
variables pAux,nuevo:ptCelda; celdaAux:unaCelda;
principio
si d.primerPar=nil entonces {lista vacía}
nuevoDato(d.primerPar);
d.primerPar↑.laClave:=c;
d.primerPar↑.elValor:=v;
d.primerPar↑.sig:=nil;
d.tamaño:=1;
sino
si c<d.primerPar↑.laClave entonces {inserción al principio}
pAux:= d.primerPar;
nuevoDato(d.primerPar);
d.primerPar↑.laClave:=c;
d.primerPar↑.elValor:=v;
d.primerPar↑.sig:=pAux;
d.tamaño:=d.tamaño+1

-- 102 of 267 --

95
sino {buscar punto de inserción}
pAux:= d.primerPar;
mientrasQue pAux↑.laClave<c and pAux↑.sig≠nil hacer
pAux:=pAux↑.sig
fmq;
si c<pAux↑.laClave entonces {inserción entre dos registros}
celdaAux.laClave:=c;
celdaAux.elValor:=v;
nuevoDato(nuevo);
nuevo↑:=pAux↑;
pAux↑:=celdaAux;
pAux↑.sig:=nuevo;
d.tamaño:=d.tamaño+1
sino
si c=pAux↑.laClave entonces {clave ya existe, cambiar valor}
pAux↑.elValor:=v
sino {inserción al final}
nuevoDato(pAux↑.sig);
pAux:=pAux↑.sig;
pAux↑.laClave:=c;
pAux↑.elValor:=v;
pAux↑.sig:=nil;
d.tamaño:=d.tamaño+1
fsi
fsi
fsi
fsi
fin
En cuanto al coste asintótico en tiempo para el caso peor, puede deducirse con facilidad que las operaciones “crear”,
“cardinal”, “esVacío”, “iniciarIterador”, “existeSiguiente” y “siguiente” tienen un coste en O(1), es decir, constante o
independiente del cardinal del diccionario, mientras que todas las demás operaciones tienen un coste O(n) en el caso peor,
siendo n el cardinal del diccionario.

-- 103 of 267 --

96

-- 104 of 267 --