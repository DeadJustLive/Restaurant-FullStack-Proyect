# PRECONDICIONES Y OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 169)

## Contenido
# PRECONDICIONES Y OBSERVACIONES:

* las mismas que para ColocarPieza
*/
{
Mover(dir)
ColocarSeccionDePieza(codPieza)
Mover(opuesto(dir))
}
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 206 of 312 --

207
//-----------------------------------------------------
procedure ColocarSeccionDePiezaEnY(codPieza,dir1,dir2)
/*
PROP´OSITO: coloca una secci´on de la pieza codPieza
en la celda lindante al dir1 y dir2
