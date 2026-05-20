# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
*/
{ while (puedeMoverEnZonaDeJuego(dir)) { Mover(dir) } }
//----------------------------------------------------
procedure IrACoordenadaDeZonaDeJuego(x,y)
/*
PROP´OSITO: ir a la coordenada (x,y) en la zona
de juego del SeudoTetris