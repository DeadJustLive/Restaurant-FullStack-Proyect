# OBSERVACIONES:

* es libre si hay celda y no tiene pieza
*/
{
return (puedeMoverEnZonaDeJuego(dir)
&& esCeldaVaciaAl(dir))
}
Vale recordar que estamos usando la caracter´ıstica de circuito corto (short circuit) de
la conjunci ´on booleana (ver subsecci ´on 4.1.1) para evitar la parcialidad de la funci ´on
esCeldaVaciaAl. Adem ´as, la precondici ´on de la funci ´on establece que al comenzar la
celda actual se encuentra en la zona de juego, para garantizar que estamos por colocar la
pieza en un lugar v ´alido.
La ´ultima de estas funciones auxiliares es hayCeldaLibreAlY, que en principio pare-
cer´ıa similar a las anteriores. Sin embargo, esta funci ´on tiene una peque ˜na complicaci ´on.
La funci ´on recibe dos direcciones, dir1 y dir2, y verfica que la celda que se encuentra
a dos posiciones de distancia de la actual est ´a libre. La complicaci ´on es que dicha cel-
da puede no existir por dos razones: no existe la celda en direcci ´on dir1, o bien dicha
celda existe pero la celda en direcci ´on dir2 desde esta nueva celda no existe. Por esta
raz ´on debemos pedir como precondici ´on que las direcciones no se cancelen mutuamente
(o sea, que no sean una Norte y la otra Sur, o una Este y la otra Oeste)), y debemos
controlar la existencia de la segunda celda despu ´es de habernos movido a la primera, si
existe. El c ´odigo queda entonces como sigue
function hayCeldaLibreAlY(dir1,dir2)
/*
PROP´OSITO: determinar si hay una celda libre en la
zona de juego, en la direcci´on indicada
por las direcciones dir1 y dir2