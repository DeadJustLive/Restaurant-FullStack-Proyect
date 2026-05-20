# OBSERVACIONES:

* para rotar una pieza se la quita toda y se la
pone rotada,si hay lugar
* la celda actual queda en el mismo lugar que
empez´o
*/
{
codPieza := leerCodigoDePiezaActual()
tipoPieza := leerTipoDePiezaActual()
rotPieza := leerRotacionDePiezaActual()
nuevaRot := rotar(rotPieza, sentidoHorario)
QuitarPiezaActual()
if (hayLugarParaPiezaTipo(tipoPieza,nuevaRot))
{ ColocarPieza(codPieza, tipoPieza, nuevaRot) }
else
{ ColocarPieza(codPieza, tipoPieza, rotPieza) }
}
Con esto culmina la presentaci ´on de las partes b ´asicas del juego. Ahora estamos en
condiciones de empezar a establecer la mec ´anica del mismo.
5.5. C ´odigo para la mec ´anica del juego
La mec ´anica del juego consta de cuatro partes principales: la operaci ´on de agregar una
nueva pieza en la zona de juego, la operaci ´on que hace que todas las piezas de la zona
de juego bajen un lugar (si pueden hacerlo), la operaci ´on que calcula cu ´ales de las piezas
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 209 of 312 --

210
deben volverse parte del piso (porque no pueden bajar m ´as) y la operaci ´on que elimina
aquellas filas del piso que est ´an llenas. Para cada una de estas operaciones dedicaremos
una subsecci ´on. Adem ´as brindaremos una subsecci ´on final con un ejemplo del uso de
estas operaciones.
5.5.1. Colocar nueva pieza
La operaci ´on para colocar una nueva pieza en el tablero es la m ´as simples de las opera-
ciones de mec ´anica del juego. Simplemente recibe como par ´ametros el c ´odigo y tipo de la
pieza a poner y un n ´umero que indica en qu ´e columna de la zona de juego debe colocar la
pieza, e intenta colocar la pieza all´ı. Por simplicidad, se asume que las piezas se colocan
en la zona de juego en rotaci ´on “natural” (o sea, c ´odigo de rotaci ´on 1). El c ´odigo es el
siguiente
procedure ColocarNuevaPieza(codPieza,tipoPieza,ubicacion)
/*
PROP´OSITO: coloca una nueva pieza de c´odigo
codPieza y tipo tipoPieza en la zona de
juego, en la columna indicada por
ubicacion