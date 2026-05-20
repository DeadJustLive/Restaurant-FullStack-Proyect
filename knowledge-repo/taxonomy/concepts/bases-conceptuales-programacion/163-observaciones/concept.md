# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 163)

## Contenido
# OBSERVACIONES:

* la celda actual ser´a el centro de la pieza
codPieza
* la pieza codPieza ser´a de tipo tipoPieza
* la rotaci´on estar´a dada por rotPieza
* la celda actual queda en el mismo lugar que
empez´o
*/
{
if (esClaseA(tipoPieza))
{
(dirA,dirB,dirC1,dirC2)
:= diresDePiezaClaseA(tipoPieza,rotPieza)
ColocarPzClaseA(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC1,dirC2)
}
else // Si no es clase A, es clase B
{
(dirA,dirB,dirC)
:= diresDePiezaClaseB(tipoPieza,rotPieza)
ColocarPzClaseB(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC)
}
}
Observar las precondiciones, y el uso de las operaciones que obtienen las direcciones de
las piezas de cada clase.
Las operaciones auxiliares simplemente colocan las secciones en los lugares corres-
pondientes utilizando m ´as operaciones auxiliares.
procedure ColocarPzClaseA(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC1,dirC2)
/*
PROP´OSITO: completar el trabajo de ColocarPieza
para las piezas de clase A
