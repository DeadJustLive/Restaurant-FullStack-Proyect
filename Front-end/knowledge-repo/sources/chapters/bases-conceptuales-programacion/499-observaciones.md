# OBSERVACIONES:

* la variable esLlena indica si hasta el momento
se encontr´o evidencia que la fila no est´a
llena
* se estructura como un recorrido de b´usqueda
sobre las celdas de la fila actual
*/
{
IrAlBordeDeZonaDeJuego(Oeste)
esLlena := True
while(esLlena && puedeMoverEnZonaDeJuego(Este))
{
esLlena := esLlena && esPiso()
Mover(Este)
}
esLlena := esLlena && esPiso()
return(esLlena)
}
//----------------------------------------------------
procedure BajarFilasSobreEsta()
/*