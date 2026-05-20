# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 183)

## Contenido
# OBSERVACIONES:

* luego de bajar una pieza, la misma se marca
para no volver a procesarla
* esto es necesario cuando hay varias piezas
bajables que se enciman y unas bloquean a
otras para bajar
Ej: (las piezas son 1,2,3 y 4, todas S)
11223344
11223344
Todas las piezas deber´ıan bajar, pero solo
la 4 lo hace en una primera vuelta; la
marca garantiza que solo bajar´a un lugar
* se estructura como un recorrido de piezas
sin marcar
* el proceso de pasar al siguiente puede
excederse si no hay m´as, terminando siempre
en el final de un recorrido de celdas (sin
pieza); de ah´ı que se llame
"IrAPiezaBajableNoMarcadaSiExiste"
*/
{
IrAPiezaBajableNoMarcadaSiExiste()
while (puedeBajarPiezaActual())
{
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 211 of 312 --

212
G.5.4. Grupo de piezas que impiden que para bajar se use un recorrido simple
sobre las piezas: solo la pieza verde puede bajar en una primera pasada
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 212 of 312 --

213
IrAPiezaBajableNoMarcadaSiExiste()
BajarPiezaActual()
MarcarPiezaActual()
}
QuitarMarcasDePiezas()
}
Al iniciar el recorrido, en lugar de preguntar si existe una pieza, se usa un procedimiento
que va a la primera que cumpla la condici ´on, si la misma existe. Esto se repite en el
procedimiento de avanzar al siguiente, lo cual hace que el recorrido siempre se “caiga”
m ´as all ´a de la ´ultima pieza que cumple. De esta forma se optimiza la pregunta, ahorrando
un recorrido para verificar que la pr ´oxima pieza exista.
Para ir a una pieza no marcada bajable, se recorre toda la zona de juego buscando el
pivote de una pieza que no tenga marca y que pueda ser bajada. Se estructura como un
recorrido de b ´usqueda sobre las celdas de la zona de juego; pero dado que puede terminar
sin que haya ninguna, debe preguntarse al terminar si efectivamente termin ´o sobre una
pieza como la buscada.
procedure IrAPiezaBajableNoMarcada()
/*
PROP´OSITO: va a un pieza de la zona
de juego que puede ser bajada
y no tiene marca
