# OBSERVACIONES:

* es libre si hay celda y no tiene pieza
*/
{
return (puedeMoverEnZonaDeJuego(dir)
&& esCeldaVaciaAl(dir))
}
//-----------------------------------------------------
function hayCeldaLibreAlY(dir1,dir2)
/*
PROP´OSITO: determinar si hay una celda libre en la
zona de juego, en la direcci´on indicada
por las direcciones dir1 y dir2