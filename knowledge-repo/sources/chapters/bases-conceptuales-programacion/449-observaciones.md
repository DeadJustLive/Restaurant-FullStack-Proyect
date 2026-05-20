# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
Mover(dir1);Mover(dir2)
QuitarSeccionDePieza(codPieza)
Mover(opuesto(dir1));Mover(opuesto(dir2))
}
B.4.4. Operaciones de movimiento de piezas
/*=SECCI´ON 4.3=====================================*
* Operaciones de movimiento de piezas *
*=================================================*
// function puedeMoverPiezaActual(dir)
// procedure MoverPiezaActual(dir)
//
// function puedeBajarPiezaActual()
// procedure BajarPiezaActual()
//
// procedure RotarPiezaActual(rotacionSentidoHorario)
*=================================================*/
//-----------------------------------------------------
//-----------------------------------------------------
function puedeMoverPiezaActual(dir)
/*
PROP´OSITO: determina si la pieza actual se puede
mover en la direcci´on dir