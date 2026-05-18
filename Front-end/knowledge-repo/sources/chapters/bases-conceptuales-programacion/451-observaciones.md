# OBSERVACIONES:

* para saber si puede mover, se la quita y se
determina si hay lugar en la celda
correspondiente (si es que existe)
* si no hay pieza, no la puede mover...
*/
{
if (esSeccionPivoteDeAlgunaPieza()
&& puedeMoverEnZonaDeJuego(dir))
{
tipoPieza := leerTipoDePiezaActual()
rotPieza := leerRotacionDePiezaActual()
QuitarPiezaActual() // Se puede pues hay pieza
Mover(dir) // Se puede pues hay lugar
puedeM := hayLugarParaPiezaTipo(tipoPieza,rotPieza)
}
else
{ puedeM := False }
return (puedeM)
}
//-----------------------------------------------------
procedure MoverPiezaActual(dir)
/*
PROP´OSITO: mover la pieza actual en direcci´on dir,
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 286 of 312 --

287
si se puede o nada si no se puede