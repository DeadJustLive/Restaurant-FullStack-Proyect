# OBSERVACIONES:

* se estructura como un recorrido sobre las
celdas de la zona de juego, quitando todas
las marcas de pieza
*/
{
IrAlOrigenDeZonaDeJuego()
while (not esFinDelRecorridoNEDeZonaDeJuego())
{
// Procesar es sacar la marca de pieza, si existe
DesmarcarPiezaActualSiHay()
AvanzarEnRecorridoNEDeZonaDeJuego()
}
// Procesar ´ultimo
DesmarcarPiezaActualSiHay()
}
La operaci ´on de procesar la celda actual debe simplemente verificar si hay una pieza
marcada y retirar la marca; no hace nada en caso que no haya marca.
procedure DesmarcarPiezaActualSiHay()
/*
PROP´OSITO: desmarcar la pieza actual, si existe
y est´a marcada; si no, no hacer nada