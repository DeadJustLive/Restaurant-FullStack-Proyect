# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 424)

## Contenido
# OBSERVACIONES:

* si no hay celda con marca de piso, termina
en la ´ultima celda del recorrido NE de la
zona de juego
*/
{
IrAlOrigenDeZonaDeJuego()
while (not esFinDelRecorridoNEDeZonaDeJuego()
&& not esCeldaDePisoMarcada())
{ AvanzarEnRecorridoNEDeZonaDeJuego() }
}
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 294 of 312 --

295
//-----------------------------------------------------
procedure TransformarEnPisoSiEsPieza(marca)
/*
PROP´OSITO: transforma en piso a la pieza que
intersecciona con la celda actual,
si existe, y agrega la marca si
corresponde
