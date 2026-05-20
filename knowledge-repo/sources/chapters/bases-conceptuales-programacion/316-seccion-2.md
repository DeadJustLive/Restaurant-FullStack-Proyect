# /*=SECCI´ON 2=======================================*

* Operaciones sobre zonas *
*=================================================*
// 2.1 Operaciones de la zona de juego del tablero
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 259 of 312 --

260
// 2.2 Operaciones en zonas de n´umeros
// 2.3 Operaciones de zonas espec´ıficas
*=================================================*/
B.2.1. Operaciones sobre la zona de juego
/*=SECCI´ON 2.1=====================================*
* *
* Auxiliares - Operaciones de *
* la zona de juego del tablero *
* *
* La zona de juego es una zona rectangular, *
* delimitada en sus esquinas inferiores por *
* celdas con 5 bolitas azules, en sus *
* esquinas superiores por celdas con 7 *
* bolitas azules y rodeada por celdas con *
* 6 bolitas azules a ambos lados. *
* *
*=================================================*
// * Geometr´ıa de la zona de juego
// procedure IrAlOrigenDeZonaDeJuego()
// function desplazamientoXDeZonaDeJuego()
// function desplazamientoYDeZonaDeJuego()
// function anchoDeZonaDeJuego()
// function altoDeZonaDeJuego()
//
// * Movimiento dentro de la zona de juego
// function puedeMoverEnZonaDeJuego(dir)
// procedure IrAlBordeDeZonaDeJuego(dir)
// procedure IrACoordenadaDeZonaDeJuego(x,y)
// function esFinDelRecorridoNEDeZonaDeJuego()
// procedure AvanzarEnRecorridoNEDeZonaDeJuego()
*=================================================*/
//-----------------------------------------------------
//----------------------------------------------------
procedure IrAlOrigenDeZonaDeJuego()
/*
PROP´OSITO: ir al origen de la zona de juego del Zilfost