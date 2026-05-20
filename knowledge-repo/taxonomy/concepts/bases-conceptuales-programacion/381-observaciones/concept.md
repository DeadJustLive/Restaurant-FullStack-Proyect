# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 381)

## Contenido
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
QuitarPzClaseA(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC1,dirC2)
}
else // Si no es clase A, es clase B
{
(dirA,dirB,dirC)
:= diresDePiezaClaseB(tipoPieza,rotPieza)
QuitarPzClaseB(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC)
}
}
//----------------------------------------------------
procedure QuitarPzClaseA(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC1,dirC2)
/*
PROP´OSITO: completar el trabajo de QuitarPieza
para las piezas de clase A
