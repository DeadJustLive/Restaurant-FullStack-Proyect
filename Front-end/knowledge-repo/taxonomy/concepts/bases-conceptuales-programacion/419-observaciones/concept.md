# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 419)

## Contenido
# OBSERVACIONES:

* no hace falta procesar el ´ultimo elemento pues
seguro est´a en la fila m´as al Norte y no puede
tener nada encima
* se estructura como un recorrido NE sobre celdas
* para cada celda de piso, se transforma la pieza
al Norte en piso (este nuevo piso puede producir
la transformaci´on de m´as celdas)
*/
{
ExtenderElPisoEnLaFilaBase()
MarcarTodasLasCeldasDelPiso()
IrACeldaDePisoMarcadaSiExiste()
while (esCeldaDePisoMarcada())
{
DesmarcarElPiso()
if (puedeMoverEnZonaDeJuego(Norte))
{
Mover(Norte)
TransformarEnPisoSiEsPieza(True)
//-^- Piso marcado
// La pieza se transforma en piso marcado!
// Esta operaci´on mueve el cabezal de lugar
}
IrACeldaDePisoMarcadaSiExiste()
}
EliminarFilasLlenas()
}
//-----------------------------------------------------
procedure MarcarTodasLasCeldasDelPiso()
/*
PROP´OSITO: marca todas las celdas del piso en
la zona de juego
