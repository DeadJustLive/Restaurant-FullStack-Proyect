# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 372)

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
ColocarSeccionDePieza(codPieza)
PonerN(Negro,tipoPieza)
PonerN(Rojo,rotPieza)
}
//-----------------------------------------------------
procedure ColocarSeccionDePiezaEn(codPieza,dir)
/*
PROP´OSITO: coloca una secci´on de la pieza codPieza
en la celda lindante al dir
