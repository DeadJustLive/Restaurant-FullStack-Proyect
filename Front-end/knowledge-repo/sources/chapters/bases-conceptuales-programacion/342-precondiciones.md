# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* est´a en la zona de n´umeros donde debe grabarse
*/
{
BorrarZonaDeNumeros()
IrAlBordeDeZonaDeNumeros(Este)
aGuardar := numero
while (aGuardar > 0)
{
GrabarDigitoEnCelda(aGuardar mod 10)
aGuardar := aGuardar div 10
Mover(Oeste)
}
}
//----------------------------------------------------
procedure GrabarDigitoEnCelda(dig)
/*