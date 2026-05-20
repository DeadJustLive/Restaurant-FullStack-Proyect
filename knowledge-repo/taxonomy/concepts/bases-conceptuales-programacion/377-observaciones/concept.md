# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 377)

## Contenido
# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
Mover(dir1);Mover(dir2)
ColocarSeccionDePieza(codPieza)
Mover(opuesto(dir1));Mover(opuesto(dir2))
}
B.4.3. Operaciones para quitar una pieza
/*=SECCI´ON 4.2.2===================================*
* Procesamiento de piezas (QuitarPiezaActual) *
*=================================================*
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
*=================================================*/
//----------------------------------------------------
//-----------------------------------------------------
procedure QuitarSeccionDePiezaActual()
/*
PROP´OSITO: quita una secci´on de la pieza actual
