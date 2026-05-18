# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
*/
{
IrAlOrigenDeZonaDeJuego()
// Contar la distancia hasta el otro borde de la zona
anchoActual := 0
while (not nroBolitas(Azul)==5)
{
anchoActual := anchoActual + 1
Mover(Este)
}
return (anchoActual)
}
//-----------------------------------------------------
function altoDeZonaDeJuego()
/*
PROP´OSITO: retorna la cantidad de celdas de alto
de la zona de juego