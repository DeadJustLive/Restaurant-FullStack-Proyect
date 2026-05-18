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
La pregunta sobre si es llena antes de saber si puede mover optimiza levemente el c ´odigo.
La operaci ´on de conjunci ´on produce el resultado deseado de volver False el valor de la
variable en cu ´anto una celda no es piso.
El procedimiento para bajar las filas encima de la actual, borrando la actual, se estruc-
tura como un recorrido de las filas de la zona de juego que est ´an al norte de la actual.
Debe bajar todo el piso que se encuentre al norte de la fila actual. Puesto que el cabe-
zal debe permanecer en la misma fila en la que empez ´o (aunque no necesariamente en
la misma columna), y que para bajar otras filas debe moverse, entonces se guarda un
n ´umero de cu ´antas filas se desplaz ´o hacia el norte para poder volver al final. Adem ´as,
el procesamiento de la ´ultima fila debe hacerse diferente, pues ella no tiene filas arriba;
consiste simplemente en borrar todas las celdas del piso de dicha fila.
procedure BajarFilasSobreEsta()
/*