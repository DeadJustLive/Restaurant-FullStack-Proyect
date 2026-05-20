# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 323)

## Contenido
# OBSERVACIONES:

* el c´alculo se realiza de la siguiente forma
rotacion 1 2 3 4
. mod 4 1 2 3 0
. +1 2 3 4 1 // En sentido horario
rotacion 1 2 3 4
. + 2 3 4 5 6
. mod 4 3 0 1 2
. + 1 4 1 2 3 // En sentido antihorario
*/
{
// Recordar si tiene o no marca
if (rotacionBase>=1 && rotacionBase<=4)
{ marca := 0 }
else { if (rotacionBase>=8 && rotacionBase<=11)
{ marca := 7 }
else { }} -- La rotaci´on es inv´alida
// Ajusta la rotaci´on si tiene marcas
rotacion := rotacionBase - marca
// Calcula la nueva rotaci´on
if (sentidoHorario)
{ nuevaRotacion := (rotacion mod 4) + 1 }
else
{ nuevaRotacion := (rotacion+2) mod 4 + 1 }
// Retorna, restaurando la marca si corresponde
return (nuevaRotacion+marca)
}
//-----------------------------------------------------
//-----------------------------------------------------
function esClaseA(tipoPieza)
/*
PROP´OSITO: indica si la pieza del tipo dado
es de clase A
*/
{ return(tipoPieza >= 1 && tipoPieza <= 6) }
//-----------------------------------------------------
function esClaseB(tipoPieza)
/*
PROP´OSITO: indica si la pieza del tipo dado
es de clase B
*/
{ return(tipoPieza >= 7 && tipoPieza <= 7) }
//-----------------------------------------------------
function diresDePiezaClaseA(tipoPieza,rotPieza)
/*
PROP´OSITO: devolver las direcciones de una pieza
de clase A, ajustadas seg´un la rotaci´on
