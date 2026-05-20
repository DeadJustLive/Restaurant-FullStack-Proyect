# OBSERVACIONES:

* optimiza la pregunta (no usa cuentas que deban
recorrer mucho el tablero)
*/
{
switch (dir) to
Norte ->
// Si dir es Norte, se puede mover dentro de la
// zona si hay lugar al norte
{ puede := puedeMover(Norte) }
Este, Oeste ->
// Si dir es Este u Oeste, se puede mover dentro
// de la zona si al moverse se topa con el borde
{
Mover(dir)
puede := not (nroBolitas(Azul)==5
|| nroBolitas(Azul)==6
|| nroBolitas(Azul)==7
)
}
_ -> // Solo hay 4 direcciones!!!
// Si dir es Sur, se puede mover dentro de la
// zona si al moverse al sur se topa con el borde
{
Mover(Sur)
puede := not (nroBolitas(Azul)==4)
}
return (puede)
}
//----------------------------------------------------
procedure IrAlBordeDeZonaDeJuego(dir)
/*
PROP´OSITO: ir al borde en direcci´on dir
dentro de la zona de juego del Zilfost