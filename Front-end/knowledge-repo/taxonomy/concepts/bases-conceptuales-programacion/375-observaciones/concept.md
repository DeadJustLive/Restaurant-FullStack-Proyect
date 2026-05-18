# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 375)

## Contenido
# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 282 of 312 --

283
*/
{
Mover(dir)
ColocarSeccionDePieza(codPieza)
Mover(opuesto(dir))
}
//-----------------------------------------------------
procedure ColocarSeccionDePiezaEnY(codPieza,dir1,dir2)
/*
PROP´OSITO: coloca una secci´on de la pieza codPieza
en la celda lindante al dir1 y dir2
