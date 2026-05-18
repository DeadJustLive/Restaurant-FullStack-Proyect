# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
codPieza := leerCodigoDePiezaActual()
tipoPieza := leerTipoDePiezaActual()
rotPieza := leerRotacionDePiezaActual()
if (esClaseA(tipoPieza))
{
(dirA,dirB,dirC1,dirC2)
:= diresDePiezaClaseA(tipoPieza,rotPieza)
TransfPzClaseA(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC1,dirC2,marca)
}
else // Si no es clase A, es clase B
{
(dirA,dirB,dirC)
:= diresDePiezaClaseB(tipoPieza,rotPieza)
TransfPzClaseB(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC,marca)
}
}
//----------------------------------------------------
procedure TransfPzClaseA(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC1,dirC2,marca)
/*
PROP´OSITO: completar el trabajo de
TransformarEnPisoPiezaActual
para las piezas de clase A