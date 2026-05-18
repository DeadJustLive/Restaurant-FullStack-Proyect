# 2. Representación estática e implementación de operaciones

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 225)

## Contenido
# 2. Representación estática e implementación de operaciones

La representación estática o contigua de una pila consiste en un vector con espacio para un máximo max de elementos
y un contador cima, 0 ≤ cima ≤ max, que indica el número de elementos válidos almacenados en el vector. Es decir:
constante max = ...
tipo pila = registro
dato: vector[1..max] de elemento;
indCima,iter: 0..max
freg
Donde elemento es un tipo previamente definido. Si la pila p es
no 	vacía, 	el 	elemento 	almacenado 	en 	p.dato[p.indCima]
corresponde a la cima de la pila, mientras que el elemento p.dato[1]
es el fondo de la pila (el elemento que fue apilado en primer lugar). La
pila vacía se representa con p.indCima=0. El campo iter se utilizará
para implementar las operaciones del iterador.
dato
indCima
e1
e2
en
•
•
n
1
2
n
max 	?
A continuación, presentamos una implementación del tipo:
módulo genérico pilas
parámetro
tipo elemento
exporta
constante max = 1001 {Es la altura máxima de cualquier pila representable en el
tipo pila, limitada por una decisión de implementación.}
tipo pila
{Los valores del TAD pila representan secuencias de longitud menor o igual que
el valor de la constante ‘max’ de elementos con acceso LIFO (last in, first
out), esto es, el último elemento añadido (o apilado) será el primero en ser
borrado (o desapilado)}
procedimiento crearVacía(sal p:pila)
{Devuelve una pila vacía, sin elementos}
procedimiento apilar(e/s p:pila; ent e:elemento; sal error:booleano)
{Si altura(p)<max), entonces devuelve en el mismo parámetro p la pila resultante
de añadir e a p, y error=falso. En caso contrario, devuelve error=verdad y no
modifica p.}
1 Es un valor arbitrario.

-- 64 of 267 --

57
procedimiento desapilar(e/s p:pila)
{Si p es no vacía, devuelve la pila resultante de eliminar de p el último elemento
que fue apilado. Si p es vacía, la deja igual}
función cima(p:pila) devuelve elemento
{Pre: p es no vacía} {Devuelve el último elemento apilado en p}
función esVacía(p:pila) devuelve booleano
{Devuelve verdad si y sólo si p no tiene elementos}
función altura(p:pila) devuelve natural
{Devuelve el nº de elementos de p, 0 si no tiene elementos}
procedimiento iniciarIterador(e/s p:pila)
{Prepara el cursor del iterador para que el siguiente elemento a visitar sea la
cima de la pila p, si existe (situación de no haber visitado ningún elemento)}
función existeSiguiente(p:pila) devuelve booleano
{Devuelve falso si ya se han visitado todos los elementos de p.
Devuelve verdad en caso contrario.}
procedimiento siguiente(e/s p:pila; sal e:elemento; sal error:booleano)
{Implementa las operaciones “siguiente” y “avanza” de la especificación, es decir:
Si existeSiguiente(p), error toma el valor falso, e toma el valor del siguiente
elemento de la pila, y se avanza el cursor del iterador al elemento siguiente
de la pila.
Si no existeSiguiente(p), error toma el valor verdad, e queda indefinido y p
queda como estaba.}
implementación
tipo pila = registro
dato: vector[1..max] de elemento;
indCima,iter: 0..max
freg
procedimiento crearVacía(sal p:pila)
{Devuelve una pila vacía, sin elementos}
principio
p.indCima:=0
fin
procedimiento apilar(e/s p:pila; ent e:elemento; sal error:booleano)
{Si altura(p)<max), entonces devuelve en el mismo parámetro p la pila resultante
de añadir e a p, y error=falso. En caso contrario, devuelve error=verdad y no
modifica p.}
principio
si p.indCima<max entonces
error:=falso;
p.indCima:=p.indCima+1;
p.dato[p.indCima]:=e
sino
error:=verdad
fsi
fin
procedimiento desapilar(e/s p:pila)
{Si p es no vacía, devuelve la pila resultante de eliminar de p el último elemento
que fue apilado. Si p es vacía, la deja igual}
principio
si p.indCima>0 entonces
p.indCima:=p.indCima-1
fsi
fin
función cima(p:pila) devuelve elemento
{Pre: p es no vacía} {Devuelve el último elemento apilado en p}

-- 65 of 267 --

58
principio2
devuelve(p.dato[p.indCima])
fin
función esVacía(p:pila) devuelve booleano
{Devuelve verdad si y sólo si p no tiene elementos}
principio
devuelve(p.indCima=0)
fin
función altura(p:pila) devuelve natural
{Devuelve el nº de elementos de p, 0 si no tiene elementos}
principio
devuelve p.indCima
fin
procedimiento iniciarIterador(e/s p:pila)
{Prepara el iterador para que el siguiente elemento a visitar sea la
cima de la pila p, si existe (situación de no haber visitado ningún elemento)}
principio
p.iter:=p.indCima
fin
función existeSiguiente(p:pila) devuelve booleano
{Devuelve falso si ya se han visitado todos los elementos de p.
Devuelve verdad en caso contrario.}
principio
devuelve (p.iter>0)
fin
procedimiento siguiente(e/s p:pila; sal e:elemento; sal error:booleano)
{Implementa las operaciones “siguiente” y “avanza” de la especificación, es decir:
Si existeSiguiente(p), error toma el valor falso, e toma el valor del siguiente
elemento de la pila, y se avanza el iterador al elemento siguiente de la pila.
Si no existeSiguiente(p), error toma el valor verdad, e queda indefinido y p
queda como estaba.}
principio
si existeSiguien
