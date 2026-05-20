# 1. Representación dinámica de una pila e implementación de operaciones

El tipo pila se representa mediante un puntero que apunta a un dato creado dinámicamente donde está el elemento
correspondiente a la cima de la pila. En dicho dato dinámico se almacena, además del elemento, un puntero que apunta a
otro dato dinámico donde está el elemento anterior a la cima, y así sucesivamente, hasta llegar al dato que almacena el
elemento más profundo de la pila, cuyo puntero correspondiente tendrá el valor nil. Esta representación se denomina
encadenamiento mediante punteros (o lista enlazada) de los elementos de la pila. Si la pila está vacía, el puntero inicial
tendrá directamente el valor nil.
A esta representación básica, puede añadirse fácilmente un campo adicional para almacenar la altura de la pila y otro
para implementar un iterador, tal como se hizo en la representación estática de pilas.
tipos ptDato = ↑unDato;
unDato = registro
dato:elemento;
sig:ptDato
freg
pila = registro
cim:ptDato;
alt:natural;
iter:ptDato
freg
e1
e2
e3
p
e3 	e2 	e1 nil
p
La implementación completa del TAD se incluye en el siguiente módulo:
módulo genérico pilas
parámetro
tipo elemento
exporta
tipo pila
{Los valores del TAD pila representan secuencias de elementos con acceso LIFO
(last in, first out), esto es, el último elemento añadido (o apilado) será el
primero en ser borrado (o desapilado)}
procedimiento crearVacía(sal p:pila)
{Devuelve una pila vacía, sin elementos}
procedimiento apilar(e/s p:pila; ent e:elemento)
{Devuelve la pila resultante de añadir e a p}
procedimiento desapilar(e/s p:pila)
{Si p es no vacía, devuelve la pila resultante de eliminar de p el último elemento
que fue apilado. Si p es vacía, la deja igual}
3 	•

-- 73 of 267 --

66
función cima(p:pila) devuelve elemento
{Pre: p es no vacía} {Devuelve el último elemento apilado en p}
función esVacía(p:pila) devuelve booleano
{Devuelve verdad si y sólo si p no tiene elementos}
función altura(p:pila) devuelve natural
{Devuelve el nº de elementos de p, 0 si no tiene elementos}
procedimiento duplicar(ent pilaEnt:pila; sal pilaSal:pila)
{Hace una copia en pilaSal de la pila almacenada en pilaEnt.}
función iguales(pila1,pila2:pila) devuelve booleano
{Devuelve verdad si y sólo si pila1 y pila2 almacenan la misma pila.}
procedimiento liberar(e/s p:pila)
{Devuelve la pila vacía, liberando previamente toda la memoria que ocupa la pila
de entrada p.}
procedimiento iniciarIterador(e/s p:pila)
{Prepara el puntero del iterador para que el siguiente elemento a visitar sea la
cima de la pila p, si existe (situación de no haber visitado ningún elemento)}
función existeSiguiente(p:pila) devuelve booleano
{Devuelve falso si ya se han visitado todos los elementos de p.
Devuelve verdad en caso contrario.}
procedimiento siguiente(e/s p:pila; sal e:elemento; sal error:booleano)
{Implementa las operaciones “siguiente” y “avanza” de la especificación, es decir:
Si existeSiguiente(p), error toma el valor falso, e toma el valor del siguiente
elemento de la pila, y se avanza el iterador al elemento siguiente de
la pila.
Si no existeSiguiente(p), error toma el valor verdad, e queda indefinido y p
queda como estaba.}
implementación
tipos ptDato = ↑unDato;
unDato = registro
dato:elemento;
sig:ptDato
freg
pila = registro
cim:ptDato;
alt:natural;
iter:ptDato
freg
procedimiento crearVacía(sal p:pila)
{Devuelve una pila vacía, sin elementos}
principio
p.cim:=nil:
p.alt:=0;
fin
procedimiento apilar(e/s p:pila; ent e:elemento)
{Devuelve la pila resultante de añadir e a p}
variable aux:ptDato
principio
aux:=p.cim;
nuevoDato(p.cim);
p.cim↑.dato:=e;
p.cim↑.sig:=aux;
p.alt:=p.alt+1
fin

-- 74 of 267 --

67
procedimiento desapilar(e/s p:pila)
{Si p es no vacía, devuelve la pila resultante de eliminar de p el último elemento
que fue apilado. Si p es vacía, la deja igual}
variable aux:ptDato
principio
si p.alt≠0 entonces
aux:=p.cim;
p.cim:=p.cim↑.sig;
disponer(aux);
p.alt:=p.alt-1
fsi
fin
función cima(p:pila) devuelve elemento
{Pre: p es no vacía} {Devuelve el último elemento apilado en p}
principio
devuelve p.cim↑.dato
fin
función esVacía(p:pila) devuelve booleano
{Devuelve verdad si y sólo si p no tiene elementos}
principio
devuelve (p.alt=0)
fin
función altura(p:pila) devuelve natural
{Devuelve el nº de elementos de p, 0 si no tiene elementos}
principio
devuelve p.alt
fin
procedimiento duplicar(ent pilaEnt:pila; sal pilaSal:pila)
{Hace una copia en pilaSal de la pila almacenada en pilaEnt.}
variables ptSal,ptEnt:ptDato
principio
si esVacía(pilaEnt) entonces
crearVacía(pilaSal);
sino
ptEnt:=pilaEnt.cim;
nuevoDato(pilaSal.cim);
pilaSal.cim↑.dato:=ptEnt↑.dato;
ptSal:=pilaSal.cim;
ptEnt:=ptEnt↑.sig;
mientrasQue ptEnt≠nil hacer
nuevoDato(ptSal↑.sig);
ptSal:=ptSal↑.sig;
ptSal↑.dato:=ptEnt↑.dato;
ptEnt:=ptEnt↑.sig
fmq;
ptSal↑.sig:=nil;
pilaSal.alt:=pilaEnt.alt
fsi
fin
función iguales(pila1,pila2:pila) devuelve booleano
{Devuelve verdad si y sólo si pila1 y pila2 almacenan la misma pila.}
variables pt1,pt2:ptDato; iguales:booleano:=verdad
principio
si pila1.alt≠pila2.alt entonces
devuelve falso;
sino
pt1:=pila1.cim;
pt2:=pila2.cim;
mientrasQue pt1≠nil and iguales hacer
iguales:=pt1↑.dato=pt2↑.dato;

-- 75 of 267 --

68
pt1:=pt1↑.sig;
pt2:=pt2↑.sig
fmq;
devuelve iguales
fsi
fin
procedimiento liberar(e/s p:pila)
{Devuelve la pila vacía, liberando previamente toda la memoria que ocupa la pila
de entrada p.}
variable aux:ptDato
principio
aux:=p.cim;
mientrasQue aux≠nil hacer
p.cim:=p.cim↑.sig;
disponer(aux);
aux:=p.cim
fmq;
p.alt:=0
fin
procedimiento iniciarIterador(e/s p:pila)
{Prepara el iterador para que el siguiente elemento a visitar sea la
cima de la pila p, si existe (situación de no haber visitado ningún elemento)}
principio
p.iter:=p.cima
fin
función existeSiguiente(p:pila) devuelve booleano
{Devuelve falso si ya se han visitado todos los elementos de p.
Devuelve verdad en caso contrario.}
principio
devuelve p.iter≠nil
fin
procedimiento siguiente(e/s p:pila; sal e:elemento; sal error:booleano)
{Implementa las operaciones “siguiente” y “avanza” de la especificación, es decir:
Si existeSiguiente(p), error toma el valor falso, e toma el valor del siguiente
elemento de la pila, y se avanza el iterador al elemento siguiente de
la pila.
Si no existeSiguiente(p), error toma el valor verdad, e queda indefinido y p
queda como estaba.}
principio
si existeSiguiente(p) entonces
error:=falso;
e:=p.iter↑.dato;
p.iter:=p.iter↑.sig
sino
error:=verdad
fsi
fin
fin
Alternativamente, la función parcial “cima” se puede implementar de forma robusta, con el siguiente procedimiento:
procedimiento cima(ent p:pila; sal e:elemento; sal error:booleano)
{Si p es vacía, error toma el valor verdad y se deja e indefinido.
Si p no es vacía, error toma el valor falso y e toma el valor de la cima de p.}
principio
si p.alt=0 entonces
error:=verdad
sino
error:=falso;
e:=p.cim↑.dato

-- 76 of 267 --

69
fsi
fin
Un problema adicional generado por la elección de una representación dinámica para los valores de un TAD es la
modificación de la semántica del operador de asignación, ‘:=’, de un valor a una variable del TAD. Si en un algoritmo
usuario de un TAD cuyos valores se representan dinámicamente se utiliza el operador de asignación, no se duplica la
representación dinámica del valor asignado, sino que simplemente se duplica la forma de acceder a ella (el puntero).
Para evitar los problemas que esa utilización del operador de asignación puede plantear, hemos incluido la operación de
“duplicar”, que hace el papel de la asignación (en algunos lenguajes de programación, en la definición de un TAD es posible
prohibir la asignación a variables del tipo utilizando el operador estándar ‘:=’).
Finalmente, puede ser de utilidad en toda representación dinámica de los valores de un TAD, y en particular en el caso
de las pilas, el disponer de una operación que libere toda la memoria dinámica utilizada para el almacenamiento de un valor,
dejando indefinido o con algún valor destacado (la pila vacía, en el caso del TAD pila) el valor de la correspondiente
variable del tipo. Por eso se ha incluido la operación “liberar”.
Al igual que con la representación estática en base a un vector que vimos en la lección anterior, todas las operaciones
tienen un tiempo de ejecución de O(1), salvo las de duplicar, liberar y la comparación de igualdad. En el caso de esta
representación dinámica, no hay límite a priori (en tiempo de compilación) para la altura de la pila. La limitación viene
dada, en tiempo de ejecución, por el tamaño destinado a la memoria dinámica. Hay un coste adicional en memoria con
respecto a la representación estática: el espacio ocupado por los punteros que sirven para encadenar los elementos.