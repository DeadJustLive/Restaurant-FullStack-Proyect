# OBSERVACIONES:

* se estructura como un recorrido sobre los d´ıgitos
codificados en la zona de n´umeros
* total guarda el n´umero le´ıdo hasta el momento
* posDig guarda la pr´oxima unidad a leer
*/
{
total := 0
posDig := 1
while(hayDigito() && puedeMoverEnZonaDeNumeroAl(Oeste))
{
// cada digito contribuye seg´un su posici´on
total := leerDigito() * posDig + total
posDig := posDig * 10 // base 10
Mover(Oeste)
}
// si no pudo mover al Oeste y hay d´ıgito, no ley´o el
// ´ultimo d´ıgito
if (hayDigito() && not puedeMoverEnZonaDeNumeroAl(Oeste))
{
// cada digito contribuye seg´un su posici´on
total := leerDigito() * posDig + total
posDig := posDig * 10 // base 10
}
return(total)
}
//----------------------------------------------------
function hayDigito()
/*