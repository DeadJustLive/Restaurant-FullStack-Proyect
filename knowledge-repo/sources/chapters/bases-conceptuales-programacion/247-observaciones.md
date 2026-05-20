# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
SacarTodasLasDeColor(Verde)
SacarTodasLasDeColor(Negro)
SacarTodasLasDeColor(Rojo)
}
Vemos que utiliza tres veces el procedimiento del ejercicio 3.2.12, y de esta manera no
tiene que preguntar si es o no una celda pivote.
5.4.3. Movimientos de una pieza
Las operaciones de movimiento de piezas se dividen en tres grupos: las que sirven para
mover la pieza, las que sirven para bajar la pieza y las que sirven para rotar la pieza.
En los dos primeros grupos tenemos una funci ´on que verifica si es posible llevar a cabo el
movimiento y un procedimiento que efectivamente lo realiza; en el tercero el procedimiento
realiza el movimiento si puede, y si no lo deja sin realizar.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 207 of 312 --

208
// function puedeMoverPiezaActual(dir)
// procedure MoverPiezaActual(dir)
//
// function puedeBajarPiezaActual()
// procedure BajarPiezaActual()
//
// procedure RotarPiezaActual(sentidoHorario)
Para codificar estas operaciones se utilizan muchas de las operaciones definidas en sec-
ciones anteriores, mostrando una vez m ´as la utilidad de pensar por subtareas y aprender
Es tan importante este concep-
to que no nos vamos a cansar de
repetirlo.
a usar de manera adecuada la abstracci ´on provista por procedimientos y funciones.
Veamos el c ´odigo de la funci ´on puedeMoverPiezaActual.
function puedeMoverPiezaActual(dir)
/*
PROP´OSITO: determina si la pieza actual se puede
mover en la direcci´on dir