# OBSERVACIONES:

* al bajar, se quita todo el piso de la fila
m´as al Norte
* el cabezal no se debe mover de la fila
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 298 of 312 --

299
actual (por lo que debe devolv´erselo a su
lugar al terminar)
* la variables desplazamiento guarda
cu´antos lugares debe volverse al Sur
* se estructura como un recorrido sobre
las filas arriba de la actual
*/
{
desplazamiento := 0
while (puedeMoverEnZonaDeJuego(Norte))
{
BajarFilaSuperior()
desplazamiento := desplazamiento + 1
Mover(Norte)
}
VaciarDePisoLaFilaActual()
MoverN(Sur, desplazamiento)
}
//----------------------------------------------------
procedure BajarFilaSuperior()
/*