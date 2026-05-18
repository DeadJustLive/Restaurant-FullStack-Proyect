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
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 297 of 312 --

298
}
// Procesa la fila m´as al Norte
EliminarMientrasSigaLlena()
}
//----------------------------------------------------
procedure EliminarMientrasSigaLlena()
/*