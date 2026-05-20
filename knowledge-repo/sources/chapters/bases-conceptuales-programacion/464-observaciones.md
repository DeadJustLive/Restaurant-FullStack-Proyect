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
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 289 of 312 --

290
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
BajarPiezaActual()
MarcarPiezaActual()
IrAPiezaBajableNoMarcadaSiExiste()
}
QuitarMarcasDePiezas()
}
//-----------------------------------------------------
procedure IrAPiezaBajableNoMarcadaSiExiste()
/*
PROP´OSITO: va a un pieza de la zona
de juego que puede ser bajada
y no tiene marca