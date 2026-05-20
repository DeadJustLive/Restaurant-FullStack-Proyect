# 3. Implementación con listas enlazadas ordenadas

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 258)

## Contenido
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
si c=d.primerPar↑.laClave 
