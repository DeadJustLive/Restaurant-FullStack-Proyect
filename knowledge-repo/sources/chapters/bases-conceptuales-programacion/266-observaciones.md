# OBSERVACIONES:

* se estructura como un recorrido sobre las
celdas de la fila base
* las piezas se transforman a piso sin marcar
*/
{
IrAlOrigenDeZonaDeJuego()
while (puedeMoverEnZonaDeJuego(Este))
{
MarcarLaPosicionDeBase()
// Necesario para volver al mismo lugar
TransformarEnPisoSiEsPieza(False)
//-^- Piso sin marcar
// Esta operaci´on mueve el cabezal de lugar
IrAMarcaDePosicionDeBaseYDesmarcar()
// Vuelve al mismo lugar para continuar
// el recorrido
Mover(Este)
}
TransformarEnPisoSiEsPieza(False)
// Esta operaci´on mueve el cabezal de lugar
}
Los procedimientos MarcarPosicionDeLaBase para poner una marca a la que volver, y
IrAMarcaDePosicionDeBaseYDesmarcar para volver a ella son sencillos:
procedure MarcarLaPosicionDeBase()
/*
PROP´OSITO: marca el piso DEBAJO de la l´ınea de base
para poder volver.
OBSERVACI´ON: ¡no marca en la misma posici´on, porque
la misma va a cambiar!
*/
{
Mover(Sur)
MarcarElPiso()
Mover(Norte)
}
//-----------------------------------------------------
procedure IrAMarcaDePosicionDeBaseYDesmarcar()
/*
PROP´OSITO: ejecuta la acci´on de volver a una posici´on
de piso marcada en la fila base
OBSERVACI´ON: la marca est´a en la base y no en la misma
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 217 of 312 --

218
posici´on, porque el piso cambi´o ah´ı
*/
{
IrAPrimerCeldaNEConBolitas(Azul, 64)
DesmarcarElPiso()
Mover(Norte)
}
Simplemente tienen en cuenta moverse al sur para marcar (para no marcar en el mismo
lugar) y al norte al volver y por lo dem ´as utilizan las subtareas de marcado ya definidas.
El procedimiento TransformarEnPisoSiEsPieza recibe un booleano que indicar ´a si el
piso en el que se transforme la pieza debe marcarse o no; si recibe True quiere decir
que debe colocarse una marca. Este par ´ametro se ir ´a pasando hasta el momento de
transformar la pieza en piso.
procedure TransformarEnPisoSiEsPieza(marca)
/*
PROP´OSITO: transforma en piso a la pieza que
intersecciona con la celda actual,
si existe, y agrega la marca si
corresponde