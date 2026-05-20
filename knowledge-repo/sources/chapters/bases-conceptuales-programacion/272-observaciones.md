# OBSERVACIONES:

* debe ir de abajo-arriba para no repetir trabajo
* se estructura como un recorrido sobre filas
*/
{
IrAlOrigenDeZonaDeJuego()
while(puedeMoverEnZonaDeJuego(Norte))
{
EliminarMientrasSigaLlena()
Mover(Norte)
}
// Procesa la fila m´as al Norte
EliminarMientrasSigaLlena()
}
El ´unico procedimiento nuevo es EliminarMientrasSigaLlena, que procesa la fila actual.
En este caso su c ´odigo es muy simple: baja las filas superiores hasta que la actual no
est ´e llena.
procedure EliminarMientrasSigaLlena()
/*