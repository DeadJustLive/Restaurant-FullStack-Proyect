# OBSERVACIONES:

* se estructura como un recorrido de b´usqueda
sobre las celdas de la zona de juego
* si no hay pieza, no hay marca y no puede bajar
con lo cual sigue buscando
* si para, es porque encontr´o una pieza no
marcada que puede bajar o porque se terminaron
las celdas sin que haya ninguna
*/
{
IrAlOrigenDeZonaDeJuego()
while(not esFinDelRecorridoNEDeZonaDeJuego()
&& not esSeccionPivoteDePiezaNoMarcadaBajable())
{ AvanzarEnRecorridoNEDeZonaDeJuego() }
}
//-----------------------------------------------------
function esSeccionPivoteDePiezaNoMarcadaBajable()
/*
PROP´OSITO: informa si la celda actual es celda
pivote de una pieza no marcada que
puede bajar
*/
{
return (esSeccionPivoteDeAlgunaPieza()
&& not esCeldaConMarcaDePieza()
&& puedeBajarPiezaActual())
}
//-----------------------------------------------------
function esCeldaConMarcaDePieza()
/*