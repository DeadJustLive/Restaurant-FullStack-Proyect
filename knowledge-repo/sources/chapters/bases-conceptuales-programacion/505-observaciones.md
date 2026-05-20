# OBSERVACIONES:

* se estructura como un recorrido sobre
las celdas de la fila actual
* solo baja las celdas de piso; las de piezas
no se bajan
* Si al bajar el piso puede romper una pieza,
entonces no baja (y puede resultar "aplastado"
por otros pisos sobre ´el)
*/
{
IrAlBordeDeZonaDeJuego(Oeste)
while (puedeMoverEnZonaDeJuego(Este))
{
BajarCeldaAlNorte()
Mover(Este)
}
BajarCeldaAlNorte()
}
//----------------------------------------------------
procedure BajarCeldaAlNorte()
/*