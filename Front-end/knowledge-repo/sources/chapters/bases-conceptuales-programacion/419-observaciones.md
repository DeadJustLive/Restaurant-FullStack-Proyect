# OBSERVACIONES:

* se estructura como un recorrido NE sobre las
celdas de la zona de juego
* si la pieza no existe, queda en un extremo
de la zona de juego
*/
{
IrAlOrigenDeZonaDeJuego()
while (not esFinDelRecorridoNEDeZonaDeJuego()
&& not esSeccionPivoteDePieza(codPieza))
{ AvanzarEnRecorridoNEDeZonaDeJuego() }
}
B.4.2. Operaciones para colocar una pieza
/*=SECCI´ON 4.2.1===================================*
* Procesamiento de piezas (ColocarPieza) *
*=================================================*
// procedure ColocarPieza(codPieza, tipoPieza, rotPieza)
// procedure ColocarPzClaseA(codPieza,tipoPieza,rotPieza
// ,dirA,dirB,dirC1,dirC2)
// procedure ColocarPzClaseB(codPieza,tipoPieza,rotPieza
// ,dirA,dirB,dirC)
// procedure ColocarSeccionDePieza(codPieza)
// procedure ColocarPivote(codPieza,tipoPieza,rotPieza)
// procedure ColocarSeccionDePiezaEn(codPieza,dir)
// procedure ColocarSeccionDePiezaEnY(codPieza,dir1,dir2)
*=================================================*/
//-----------------------------------------------------
procedure ColocarPieza(codPieza, tipoPieza, rotPieza)
/*
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 280 of 312 --

281
PROP´OSITO: coloca la pieza codPieza en el tablero