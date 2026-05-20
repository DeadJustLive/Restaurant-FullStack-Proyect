# OBSERVACIONES:

* la zona de juego de Zilfost est´a desplazada
al Este por la parte de datos
*/
{
IrACoordenada(x + desplazamientoXDeZonaDeJuego()
, y + desplazamientoYDeZonaDeJuego())
}
//----------------------------------------------------
function esFinDelRecorridoNEDeZonaDeJuego()
/*
PROP´OSITO: determina si puede moverse a la celda
siguiente en un recorrido Noreste de
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 262 of 312 --

263
las celdas de la zona de juego
*/
{
return (not puedeMoverEnZonaDeJuego(Norte)
&& not puedeMoverEnZonaDeJuego(Este))
}
//----------------------------------------------------
procedure AvanzarEnRecorridoNEDeZonaDeJuego()
/*
PROP´OSITO: avanza a la celda siguiente en un
recorrido Noreste de las celdas de
la zona de juego
PRECONDICIONES: no est´a en el final del recorrido
*/
{
if (puedeMoverEnZonaDeJuego(Este))
{ Mover(Este) }
else
{ IrAlBordeDeZonaDeJuego(opuesto(Este)); Mover(Norte) }
}
B.2.2. Operaciones sobre zonas de n ´umeros
/*=SECCI´ON 2.2=====================================*
* Operaciones en zonas de n´umeros *
*=================================================*
// Operaciones de movimiento en la zona de n´umeros actual
// function puedeMoverEnZonaDeNumeroAl(dir)
// procedure IrAlBordeDeZonaDeNumeros(dir)
//
// Operaciones para leer y grabar un n´umero de una
// zona de n´umeros
// function leerZonaDeNumeros()
// function hayDigito()
// function leerDigito()
// procedure GrabarNumeroEnZonaDeNumeros(numero)
// procedure GrabarDigitoEnCelda(dig)
//
// Operaciones para modificar una zona de n´umeros
// procedure BorrarZonaDeNumeros()
// procedure AgregarDigitoAZonaDeNumerosPorIzq(dig)
// procedure IncrementarZonaDeNumeros()
// procedure IncrementarDigitoDeCelda()
*=================================================*/
//----------------------------------------------------
function puedeMoverEnZonaDeNumeroAl(dir)
/*