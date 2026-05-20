# PRECONDICIONES Y OBSERVACIONES:

* las mismas que para ColocarPieza
*/
{
Mover(dir1);Mover(dir2)
ColocarSeccionDePieza(codPieza)
Mover(opuesto(dir1));Mover(opuesto(dir2))
}
Para quitar una pieza del tablero se procede de manera similar que para colocarla, pero
cambiando los Poner por Sacar. Adicionalmente definiremos un procedimiento denomina-
do QuitarSeccionDePiezaActual para quitar una secci ´on independientemente de si se
trata del pivote o de otra de las secciones.
// procedure QuitarSeccionDePiezaActual()
// procedure QuitarPiezaActual()
// procedure QuitarPzClaseA(codPieza,tipoPieza,rotPieza
// ,dirA,dirB,dirC1,dirC2)
// procedure QuitarPzClaseB(codPieza,tipoPieza,rotPieza
// ,dirA,dirB,dirC)
// procedure QuitarSeccionDePieza(codPieza)
// procedure QuitarPivote(codPieza,tipoPieza,rotPieza)
// procedure QuitarSeccionDePiezaDe(codPieza,dir)
// procedure QuitarSeccionDePiezaDeY(codPieza,dir1,dir2)
La operaci ´on de QuitarPiezaActual y todas su auxilares se omiten porque son id ´enticas
en estructura a las operaciones explicadas para colocar una pieza, excepto dos diferen-
cias ´ınfimas. La primera es que todas estas operaciones asumen como precondici ´on que
la pieza no est ´a marcada. La segunda es que la operaci ´on de QuitarPiezaActual no re-
cibe par ´ametros, por lo que debe leerlos desde la celda actual (y para ello se utilizar ´an
las operaciones definidas en la secci ´on 5.3). Solo daremos el c ´odigo de la operaci ´on
QuitarSeccionDePiezaActual.
procedure QuitarSeccionDePiezaActual()
/*
PROP´OSITO: quita una secci´on de la pieza actual