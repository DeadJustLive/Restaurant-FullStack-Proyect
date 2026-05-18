# PROP´OSITO:

combinar las acciones necesarias para la aparici´on
de una nueva pieza en la zona de juego (si entra)
*/
{
semilla := leerSemilla()
(codPz,tipoPz,ubicPz,semilla) := determinarNuevaPieza(semilla)
GrabarSemilla(semilla)
ColocarNuevaPieza(codPz,tipoPz,ubicPz)
// Al exceder el m´aximo, vuelve a 1
IncrementarZonaDeProximaPieza()
BorrarZonaDeSeleccion()
}
//----------------------------------------------------
procedure OperacionMoverPiezaAl(dir)
/*