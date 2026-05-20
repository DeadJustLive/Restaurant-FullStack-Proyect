# OBSERVACIONES:

* se coloca la pieza en la 2da fila desde arriba
en rotaci´on 1 (posici´on original)
(ATENCION: para colocarla en otra rotaci´on hay
que analizar d´onde quedar´ıa el pivote, para
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 288 of 312 --

289
bajar acorde. En rotaci´on 1 todos los pivotes
van en fila 2 desde arriba)
* si no hay lugar, no hace nada
*/
{
IrACoordenadaDeZonaDeJuego(ubicacion
,altoDeZonaDeJuego()-1)
if (tipoPieza /= 7)
{ Mover(Sur) }
// Ajuste para estar 1 m´as abajo
// pues los pivotes van ac´a siempre en
// rotaci´on 1, excepto en la pieza 7 (T)
if (hayLugarParaPiezaTipo(tipoPieza,1))
{ ColocarPieza(codPieza,tipoPieza,1) }
}
B.5.2. Operaciones para bajar piezas
/*=SECCI´ON 5.2=====================================*
* Procesamiento del juego (BajarPiezas...) *
*=================================================*
// procedure BajarPiezasDeZonaDeJuego()
// procedure UnicamenteBajarPiezas()
// procedure IrAPiezaBajableNoMarcadaSiExiste()
// function esSeccionPivoteDePiezaNoMarcadaBajable()
// function esCeldaConMarcaDePieza()
// procedure MarcarPiezaActual()
// procedure QuitarMarcasDePiezas()
// procedure DesmarcarPiezaActualSiHay()
*=================================================*/
//-----------------------------------------------------
procedure BajarPiezasDeZonaDeJuego()
/*
PROP´OSITO: bajar un lugar todas las piezas que
pueden bajar