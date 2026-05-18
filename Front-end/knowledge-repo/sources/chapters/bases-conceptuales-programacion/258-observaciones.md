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
En esta ´ultima operaci ´on se usa una funci ´on de detecci ´on del pivote de una pieza mar-
cada, que verifica tres condiciones: que haya una secci ´on de pivote, que est ´e marcada, y
que la pieza en esa posici ´on pueda bajar.
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
Observar como se usa el circuito corto de las operaciones booleanas para estar seguros
que la precondici ´on de la ´ultima condici ´on se cumple. La operaci ´on para verificar si una
celda tiene marca de piezas es simple
function esCeldaConMarcaDePieza()
/*