# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 437)

## Contenido
# OBSERVACIONES:

* no cambia la celda actual
*/
{
Mover(dir)
TransformarCeldaEnPiso(marca)
Mover(opuesto(dir))
}
//-----------------------------------------------------
procedure TransformarCeldaEnPisoAlY(dir1,dir2, marca)
/*
PROP´OSITO: transforma en piso la celda lindante
al dir1 y dir2 si la misma es secci´on
de pieza
