# OBSERVACIONES:

* al bajar las filas sobre la actual, se borra
la que estaba, y la condici´on puede cambiar
* al terminar, la fila actual no est´a llena
*/
{
while (esFilaLlena())
{ BajarFilasSobreEsta() }
}
Es importante observar que puesto que la cantidad de filas es finita, y la fila superior
desaparece cuando est ´a llena, entonces este procedimiento debe terminar.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 219 of 312 --

220
La funci ´on esFilaLlena es un recorrido de totalizaci ´on donde se utiliza un booleano
como acumulador, el cual cambia a False apenas detecta que hay una celda que no es
piso en la fila actual (deteniendo la b ´usqueda). Cuando termina, si el booleano sigue en
True significa que la fila no contiene celdas diferentes del piso (est ´a llena).
function esFilaLlena()
/*