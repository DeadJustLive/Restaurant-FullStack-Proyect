# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 405)

## Contenido
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
B.5. Operaciones de la mec ´anica del juego
