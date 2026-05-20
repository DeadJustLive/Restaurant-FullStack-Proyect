# OBSERVACIONES:

* los d´ıgitos entran a la zona de izquierda a
derecha
* recorre los d´ıgitos de izq a der para
encontrar d´onde poner el d´ıgito
* los espacios libres solo pueden estar
a la derecha y si no hay, borra el n´umero
completo y pone el d´ıgito como el primero
(alternativamente podr´ıa ignorar el d´ıgito)
*/
{
IrAlBordeDeZonaDeNumeros(Oeste)
while(hayDigito()) { Mover(Este) }
if (nroBolitas(Azul)==0)
{ GrabarDigitoEnCelda(dig) }
else
{
// Si no hay espacio, borra el n´umero anterior
Mover(Oeste)
BorrarZonaDeNumeros()
IrAlBordeDeZonaDeNumeros(Oeste)
GrabarDigitoEnCelda(dig)
}
}
//----------------------------------------------------
procedure IncrementarZonaDeNumeros()
/*
PROP´OSITO: incrementa el n´umero codificado en la
zona de n´umeros actual