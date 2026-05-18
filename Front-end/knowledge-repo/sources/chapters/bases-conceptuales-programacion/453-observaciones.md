# OBSERVACIONES:

* para mover una pieza se la quita toda y se la
pone de nuevo en el nuevo lugar, si hay lugar
* la celda actual queda en el pivote de la pieza
ya sea que se movi´o o no
*/
{
codPieza := leerCodigoDePiezaActual()
tipoPieza := leerTipoDePiezaActual()
rotPieza := leerRotacionDePiezaActual()
if (puedeMoverEnZonaDeJuego(dir))
{
QuitarPiezaActual()
Mover(dir) // Puede, porque se verific´o
if (hayLugarParaPiezaTipo(tipoPieza,rotPieza))
{
// Coloca la pieza en la nueva posici´on
ColocarPieza(codPieza, tipoPieza, rotPieza)
}
else
{
// Coloca la pieza en la celda inicial
Mover(opuesto(dir))
ColocarPieza(codPieza, tipoPieza, rotPieza)
}
}
}
//-----------------------------------------------------
//-----------------------------------------------------
function puedeBajarPiezaActual()
/*
PROP´OSITO: determina si la pieza actual se puede bajar