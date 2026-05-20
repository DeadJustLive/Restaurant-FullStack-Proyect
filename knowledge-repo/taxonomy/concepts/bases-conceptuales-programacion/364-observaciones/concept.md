# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 364)

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
//----------------------------------------------------
procedure ColocarPzClaseA(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC1,dirC2)
/*
PROP´OSITO: completar el trabajo de ColocarPieza
para las piezas de clase A
