# PROP´OSITO:

combinar las acciones necesarias para mover la
pieza indicada en la zona de selecci´on (si existe)
*/
{
IrAPiezaSiExiste(leerZonaDeSeleccion())
if (hayPiezaActual())
{ MoverPiezaActual(dir); ExtenderElPiso() }
BorrarZonaDeSeleccion()
}
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 302 of 312 --

303
//----------------------------------------------------
procedure OperacionRotarPieza(sentidoHorario)
/*