# 3. Implementación del TAD diccionario con ABB

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 36)

## Contenido
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
{Este proc
