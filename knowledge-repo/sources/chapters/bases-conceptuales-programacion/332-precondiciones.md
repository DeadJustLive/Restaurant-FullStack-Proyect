# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* se encuentra dentro de una zona de n´umeros
* dir es Este u Oeste (no tiene sentido que sea
Norte o Sur, porque las zonas de n´umeros tienen
altura 1)
*/
{
while(puedeMoverEnZonaDeNumeroAl(dir))
{ Mover(dir) }
}
//----------------------------------------------------
//----------------------------------------------------
function leerZonaDeNumeros()
/*