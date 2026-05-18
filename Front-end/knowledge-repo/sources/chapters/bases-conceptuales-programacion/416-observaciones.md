# OBSERVACIONES:

* es libre si hay celda y no tiene pieza
*/
{
if (puedeMoverEnZonaDeJuego(dir1))
{ Mover(dir1)
if (puedeMoverEnZonaDeJuego(dir2))
{ Mover(dir2)
celdaLibre := esCeldaLibre() }
else { celdaLibre := False }} -- No existe la celda2
else { celdaLibre := False } -- No existe la celda1
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 279 of 312 --

280
return (celdaLibre)
}
B.4. Operaciones de procesamiento de piezas