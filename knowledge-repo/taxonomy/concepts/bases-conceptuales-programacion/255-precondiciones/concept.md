# PRECONDICIONES:

## Fuente
bases-conceptuales-programacion (Cap. 255)

## Contenido
# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
*/
{
IrAlOrigenDeZonaDeJuego(); Mover(Oeste)
// Contar la altura hasta las 7 bolitas azules
altura := 0
while (nroBolitas(Azul)/=7)
{
altura := altura + 1
Mover(Norte)
}
return (altura+1) // Ajusta contando la ultima
}
//-----------------------------------------------------
//------------------------------------------------------
function puedeMoverEnZonaDeJuego(dir)
/*
PROP´OSITO: determina si puede moverse en la direcci´on
dada sin caerse de la parte de juego
