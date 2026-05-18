# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 174)

## Contenido
# OBSERVACIONES:

* para saber si puede mover, se la quita y se
determina si hay lugar en la celda
correspondiente (si es que existe)
* si no hay pieza, no la puede mover...
*/
{
if (esSeccionPivoteDeAlgunaPieza()
&& puedeMoverEnZonaDeJuego(dir))
{
tipoPieza := leerTipoDePiezaActual()
rotPieza := leerRotacionDePiezaActual()
QuitarPiezaActual() // Se puede pues hay pieza
Mover(dir) // Se puede pues hay lugar
puedeM := hayLugarParaPiezaTipo(tipoPieza,rotPieza)
}
else
{ puedeM := False }
return (puedeM)
}
Primero se verifica si la pieza actual existe y si hay celda destino para moverla; si eso no
sucede, entonces informa que no puede moverla. Si existe, procede a leerla y a verificar
Observar como las precondicio-
nes de las operaciones de lectu-
ra, quitar pieza, etc. quedan sa-
tisfechas por la condici ´on ya es-
tablecida.
que hay lugar para ella en el destino. Para esta verificaci ´on quita la pieza para poder
invocar la funci ´on que determina si hay lugar para una pieza. El hecho de quitar la pieza es
necesario porque al moverse, la misma no estar ´a m ´as en la posici ´on anterior, y entonces
la funci ´on de detecci ´on de lugar debe encontrar esas celdas libres.
El procedimiento de MoverPiezaActual procede de manera muy similar a la de la
funci ´on reci ´en explicada.
procedure MoverPiezaActual(dir)
/*
PROP´OSITO: mover la pieza actual en direcci´on dir,
si se puede o nada si no se puede
