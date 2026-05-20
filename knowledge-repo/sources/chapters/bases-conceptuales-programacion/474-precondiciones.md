# PRECONDICIONES:

* hay una celda lindante al dir en la zona de
juego
*/
{
Mover(dir)
return(esPiso())
}
//-----------------------------------------------------
function esCeldaDePisoMarcada()
/*
PROP´OSITO: informa si la celda actual es piso con
marca de piso (simple)
*/
{ return(nroBolitas(Azul)>60) }
//-----------------------------------------------------
procedure MarcarElPiso()
/*
PROP´OSITO: marcar el piso
*/
{ PonerN(Azul,60) }
//-----------------------------------------------------
procedure DesmarcarElPiso()
/*
PROP´OSITO: desmarca el piso