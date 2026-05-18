# 1. Concepto de cola y especificación

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 245)

## Contenido
# 1. Concepto de cola y especificación

Una cola es, al igual que una pila, una secuencia de elementos de un cierto tipo, dispuestos en una dimensión (tipo
lineal de datos). En el tipo cola hay un valor especial que se denomina cola vacía. Además, a una cola se pueden añadir y
eliminar elementos, y puede observarse el primer elemento de la cola.
El comportamiento intuitivo de una cola es el siguiente (piénsese, por ejemplo, en la cola que se forma ante una
ventanilla de un determinado servicio de la Administración Pública): los nuevos elementos son añadidos siempre por un
mismo extremo de la cola (el final) mientras que las eliminaciones se realizan por el extremo opuesto (el principio de la
cola). Si se interpreta que el primer elemento de la cola está recibiendo un cierto servicio (está siendo atendido por el
funcionario a cargo de la ventanilla), el orden en que los elementos reciben el correspondiente servicio y salen del sistema
(son eliminados) debe coincidir con el orden de su llegada (operación de añadir) al sistema. Se dice, por tanto, que las colas
son estructuras FIFO (del inglés, First In, First Out).
La especificación del TAD (genérico) cola es la siguiente:
espec colasGenéricas
usa boleanos, naturales
parámetro formal
género elemento
fpf
género cola {Los valores del TAD cola representan secuencias de elementos con acceso FIFO (first in, first out),
esto es, el primer elemento añadido será el primero en ser borrado}
operaciones
crear: -> cola
{Devuelve una cola vacía, sin elementos}
encolar: cola c , elemento e -> cola
{Devuelve la cola resultante de añadir e a c}
esVacía?: cola c -> booleano
{Devuelve verdad si y sólo si c no tiene elementos}
parcial primero: cola c -> elemento
{Devuelve el primer elemento encolado de los que hay en c. Parcial: la operación no está definida si c es vacía}
desencolar: cola c -> cola
{Si c es no vacía, devuelve la cola resultante de eliminar de c el primer elemento que fue encolado.
Si c es vacía, devuelve una cola igual a c }
longitud: cola c -> natural

-- 83 of 267 --

76
{Devuelve el nº de elementos de c}
{Las cuatro siguientes operaciones de un Iterador definido sobre las colas}
iniciarIterador: cola c -> cola
{Prepara el iterador para que el siguiente elemento a visitar sea el primero de la cola c, si existe
(situación de no haber visitado ningún elemento)}
existeSiguiente?: cola c -> booleano
{Devuelve falso si ya se han visitado todos los elementos de c, devuelve verdad en caso contrario}
parcial siguiente: cola c -> elemento
{Devuelve el siguiente elemento de c.
Parcial: la operación no está definida si no existeSiguiente?(c)}
parcial avanza: cola c -> cola
{Devuelve la cola resultante de avanzar el iterador en c.
Parcial: la operación no está definida si no existeSiguiente?(c)}
fespec
