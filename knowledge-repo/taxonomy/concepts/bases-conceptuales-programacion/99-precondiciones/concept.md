# PRECONDICIONES:

## Fuente
bases-conceptuales-programacion (Cap. 99)

## Contenido
# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
*/
{ while (puedeMoverEnZonaDeJuego(dir)) { Mover(dir) } }
Observamos que el mecanismo es simplemente un recorrido de b ´usqueda que busca el
borde (la celda donde no se puede mover dentro de la zona de juego). Para ir a una
coordenada espec´ıfica dentro de la zona de juego seguimos una estrategia diferente: se
utilizan las cantidades previamente obtenidas.
procedure IrACoordenadaDeZonaDeJuego(x,y)
/*
PROP´OSITO: ir a la coordenada (x,y) en la zona
de juego del SeudoTetris
