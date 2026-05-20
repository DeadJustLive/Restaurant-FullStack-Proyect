# 2. Representación dinámica e implementación de operaciones

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 246)

## Contenido
# 2. Representación dinámica e implementación de operaciones

La representación dinámica de un dato de tipo cola puede realizarse, de forma análoga a la del tipo pila, encadenando
o enlazando mediante punteros los elementos de la cola. Para ello, una variable de tipo puntero apunta al dato, creado
dinámicamente, en que se almacena el primer elemento de la cola; junto a éste, a su vez, se almacena otro puntero que
guarda la dirección del segundo elemento de la cola, etcétera. De esta forma, las operaciones de eliminar y observar el
primero de la cola pueden ejecutarse en un tiempo en O(1). Para poder ejecutar en igual tiempo las operaciones de añadir a
la cola, es necesaria una variable puntero adicional que apunte siempre al último elemento de la cola (aquél añadido más
recientemente). Incluimos además en la representación de la cola, un campo para guardar su longitud y un puntero para
implementar el iterador.
tipos ptDato = ↑unDato;
unDato = registro
dato:elemento;
sig:ptDato
freg
cola = registro
pri,ult:ptDato;
long:natural;
iter:ptDato
freg
e1	e2	e3
c
e1 	e2 	e3 nil
c
En la implementación del TAD que sigue, se han añadido a las especificadas en la sección anterior, las operaciones de
duplicar colas, igualdad entre dos colas y liberación de memoria dinámica.
módulo genérico colasGenéricas
parámetro
tipo elemento
exporta
tipo cola {Los valores del TAD cola representan secuencias de elementos con
acceso FIFO (first in, first out), esto es, el primer elemento añadido
será el primero en ser borrado.}
•

-- 84 of 267 --

77
procedimiento crearVacía(sal c:cola)
{Devuelve en c la cola vacía, sin elementos}
procedimiento encolar(e/s c:cola; ent e:elemento)
{Devuelve en c la cola resultante de añadir e a c}
función esVacía(c:cola) devuelve booleano
{Devuelve verdad si y sólo si c no tiene elementos}
procedimiento primero(ent c:cola; sal e:elemento; sal error:booleano)
{Si c es no vacía, devuelve en e el primer elemento añadido a c y error=falso.
Si c es vacía, devuelve error=verdad y e queda indefinido}
procedimiento desencolar(e/s c:cola)
{Si c es no vacía, devuelve en c la cola resultante de eliminar de c el primer
elemento que fue añadido. Si c es vacía, la deja igual}
función longitud(c:cola) devuelve natural
{Devuelve el número de elementos de c}
procedimiento duplicar(sal colaSal:cola; ent colaEnt:cola)
{Devuelve en colaSal una cola igual a colaEnt, duplicando la representación
en memoria}
función iguales(cola1,cola2:cola) devuelve booleano
{Devuelve verdad si y sólo si cola1 y cola2 tienen los mismos elementos y en
las mismas posiciones}
procedimiento liberar(e/s c:cola)
{Devuelve en c la cola vacía y además libera la memoria utilizada previamente por c}
procedimiento iniciarIterador(e/s c:cola)
{Prepara el iterador para que el siguiente elemento a visitar sea un primer
elemento de c, si existe (situación de no haber visitado ningún elemento)}
función existeSiguiente(c:cola) devuelve booleano
{Devuelve falso si ya se han visitado todos los elementos de c; devuelve cierto en
caso contrario}
procedimiento siguiente(e/s c:cola; sal e:elemento; sal error:booleano)
{Si existe algún elemento de c pendiente de visitar, devuelve en e el siguiente
elemento a visitar y error=falso, y además avanza el iterador para que a
continuación se pueda visitar otro elemento de c. Si no quedan elementos pendientes
de visitar devuelve error=verdad y e queda indefinido}
implementación
tipos ptDato = ↑unDato;
unDato = registro
dato:elemento;
sig:ptDato
freg;
cola = registro
pri,ult:ptDato;
long:natural;
iter:ptDato {se utiliza para implementar el iterador}
freg
procedimiento crearVacía(sal c:cola)
{Devuelve en c la cola vacía, sin elementos}
principio
c.pri:=nil;
c.ult:=nil;
c.long:=0
fin
procedimiento encolar(e/s c:cola; ent e:elemento)
{Devuelve en c la cola resultante de añadir e a c}

-- 85 of 267 --

78
principio
si c.long=0 entonces
nuevoDato(c.ult);
c.pri:=c.ult
sino
nuevoDato(c.ult↑.sig);
c.ult:=c.ult↑.sig
fsi;
c.ult↑.dato:=e;
c.ult↑.sig:=nil;
c.long:=c.long+1
fin
función esVacía(c:cola) devuelve booleano
{Devuelve verdad si y sólo si c no tiene elementos}
principio
devuelve c.pri=nil
fin
procedimiento primero(ent c:cola; sal e:elemento; sal error:booleano)
{Si c es no vacía, devuelve en e el primer elemento añadido a c y error=falso.
Si c es vacía, devuelve error=verdad y e queda indefinido}
principio
si esVacía(c) entonces
error:=verdad
sino
error:=falso;
e:=c.pri↑.dato
fsi
fin
procedimiento desencolar(e/s c:cola)
{Si c es no vacía, devuelve en c la cola resultante de eliminar de c el primer
elemento que fue añadido. Si c es vacía, la deja igual}
variable aux:ptDato
principio
si not esVacía(c) entonces
aux:=c.pri;
c.pri:=c.pri↑.sig;
disponer(aux);
c.long:=c.long-1;
si c.long=0 entonces c.ult:=nil fsi
fsi
fin
función longitud(c:cola) devuelve natural
{Devuelve el número de elementos de c}
principio
devuelve c.long
fin
procedimiento duplicar(sal colaSal:cola; ent colaEnt:cola)
{Devuelve en colaSal una cola igual a colaEnt, 
