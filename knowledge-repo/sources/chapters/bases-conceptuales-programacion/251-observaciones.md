# OBSERVACIONES:

* para mover una pieza se la quita toda y se la
pone de nuevo en el nuevo lugar, si hay lugar
* la celda actual queda en el pivote de la pieza
ya sea que se movi´o o no
*/
{
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 208 of 312 --

209
codPieza := leerCodigoDePiezaActual()
tipoPieza := leerTipoDePiezaActual()
rotPieza := leerRotacionDePiezaActual()
if (puedeMoverEnZonaDeJuego(dir))
{
QuitarPiezaActual()
Mover(dir) // Puede, porque se verific´o
if (hayLugarParaPiezaTipo(tipoPieza,rotPieza))
{
// Coloca la pieza en la nueva posici´on
ColocarPieza(codPieza, tipoPieza, rotPieza)
}
else
{
// Coloca la pieza en la celda inicial
Mover(opuesto(dir))
ColocarPieza(codPieza, tipoPieza, rotPieza)
}
}
}
La ´unica diferencia apreciable es que si la pieza no se pod´ıa mover, entonces la vuelve a
colocar en el mismo lugar inicial. La celda actual queda siempre en el pivote de la pieza,
tanto si la pieza se pudo mover como si no.
Las operaciones de bajar pieza simplemente especializan las dos operaciones ante-
riores especificando que el par ´ametro no es cualquier direcci ´on si no simplemente el valor
Sur. El c ´odigo se omite por ser extremadamente simple.
Finalmente, el c ´odigo de rotar pieza es similar al de mover pieza, salvo que debe
calcularse y usarse la nueva rotaci ´on.
procedure RotarPiezaActual(sentidoHorario)
/*
PROP´OSITO: rotar la pieza actual, si se puede
o nada si no se puede