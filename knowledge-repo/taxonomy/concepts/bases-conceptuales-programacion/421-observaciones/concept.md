# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 421)

## Contenido
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
//-----------------------------------------------------
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
posici´on, porque el piso cambi´o ah´ı
*/
{
IrAPrimerCeldaNEConBolitas(Azul, 64)
// Son 64 por las 60 de la marca, y las 4 del borde
// y es la ´unica marcada de esta forma
DesmarcarElPiso()
Mover(Norte)
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 293 of 312 --

294
}
//-----------------------------------------------------
function esPiso()
/*
PROP´OSITO: informa si la celda actual es piso
no marcado
*/
{ return(nroBolitas(Azul)==8) }
//-----------------------------------------------------
function hayPisoAl(dir)
/*
PROP´OSITO: informa si la celda lindante al dir
es piso no marcado
