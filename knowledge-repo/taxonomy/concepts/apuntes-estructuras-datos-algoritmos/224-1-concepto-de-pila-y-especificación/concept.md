# 1. Concepto de pila y especificación

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 224)

## Contenido
# 1. Concepto de pila y especificación

La pila, como el resto de tipos que veremos en este tema, es una secuencia de elementos de un cierto tipo (que se
concretará para cada aplicación) dispuestos en una dimensión. Se dice, por tanto, que es un tipo lineal de datos.
En el tipo pila hay un valor especial que denominamos pila vacía. Además, en una pila se pueden añadir y quitar
elementos. La operación de añadir se denomina apilar y la de quitar se denomina desapilar. Además, si la pila no es vacía,
podemos observar el último elemento apilado, que denominamos cima de la pila.
El comportamiento intuitivo de una pila es el siguiente:
• 	la cima de una pila no vacía es el último elemento apilado, y
• 	al desapilar de una pila no vacía desaparece el último elemento apilado.
Las pilas se denominan también estructuras LIFO (del inglés, Last In, First Out), nombre que hace referencia al modo
en que se añaden y quitan sus elementos.
La especificación del TAD pila (genérico), que ya fue introducida en una lección anterior, es la siguiente es la siguiente:
espec pilasGenéricas
usa booleanos, naturales
parámetro formal
género elemento
fpf
género pila
{Los valores del TAD pila representan secuencias de datos de tipo “elemento” con acceso LIFO (last in,
first out), esto es, el último elemento añadido (o apilado) será el primero en ser borrado (o desapilado)}
operaciones
pilaVacía: -> pila
{Devuelve una pila vacía, sin elementos}
apilar: pila p, elemento e -> pila
{Devuelve la pila resultante de añadir e a p}
desapilar: pila p -> pila
{Si p es no vacía, devuelve la pila resultante de eliminar de p el último elemento que fue apilado.
Si p es vacía, devuelve una pila igual a p}
parcial cima: pila p -> elemento
{Devuelve el último elemento apilado en p.
Parcial: la operación no está definida si p es vacía}
esVacía?: pila p -> bool
{Devuelve verdad si y sólo si p no tiene elementos}
altura: pila p -> natural
{Devuelve el nº de elementos de p}

-- 63 of 267 --

56
{A cualquiera de los contenedores o colecciones de datos que veamos, será conveniente añadirles un Iterador.
Las cuatro siguientes operaciones son un Iterador definido sobre las pilas}
iniciarIterador: pila p -> pila
{Prepara el iterador para que el siguiente elemento a visitar sea el último de la pila p, si existe
(situación de no haber visitado ningún elemento)}
existeSiguiente?: pila p -> booleano
{Devuelve falso si ya se han visitado todos los elementos de p, devuelve verdad en caso contrario}
parcial siguiente: pila p -> elemento
{Devuelve el siguiente elemento de p.
Parcial: la operación no está definida si no existeSiguiente?(p)}
parcial avanza: pila p -> pila
{Devuelve la pila resultante de avanzar el iterador en p.
Parcial: la operación no está definida si no existeSiguiente?(p)}
fespec
