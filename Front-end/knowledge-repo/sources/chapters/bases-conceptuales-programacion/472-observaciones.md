# OBSERVACIONES:

* se estructura como un recorrido sobre las celdas
de la zona de juego
*/
{
IrAlOrigenDeZonaDeJuego()
while (not esFinDelRecorridoNEDeZonaDeJuego())
{
if (esPiso()) { MarcarElPiso() }
AvanzarEnRecorridoNEDeZonaDeJuego()
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 292 of 312 --

293
}
if (esPiso()) { MarcarElPiso() }
}
//-----------------------------------------------------
procedure ExtenderElPisoEnLaFilaBase()
/*
PROP´OSITO: analiza si hay piezas en la fila
base que puedan estar en el piso, y las
convierte en piso