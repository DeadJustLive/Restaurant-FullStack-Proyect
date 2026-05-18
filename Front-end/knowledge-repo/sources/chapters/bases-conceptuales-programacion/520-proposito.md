# PROP´OSITO:

combinar las acciones necesarias para rotar la
pieza indicada en la zona de selecci´on (si existe)
*/
{
IrAPiezaSiExiste(leerZonaDeSeleccion())
if (hayPiezaActual())
{ RotarPiezaActual(sentidoHorario); ExtenderElPiso() }
BorrarZonaDeSeleccion()
}
//----------------------------------------------------
procedure OperacionAgregarDigitoASeleccion(dig)
/*