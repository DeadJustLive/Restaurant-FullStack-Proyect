# OBSERVACIONES:

* como los d´ıgitos se ingresan de izquierda a derecha
pero se leen de derecha a izquierda, determinar si
se complet´o el ingreso de un c´odigo v´alido se puede
realizar leyendo el n´umero y viendo que es distinto
de cero
*/
{
AgregarDigitoASeleccion(dig)
if (leerZonaDeSeleccion()/=0) // Al terminar de seleccionar
// una pieza, baja todas
{ BajarPiezasDeZonaDeJuego() }
}
//----------------------------------------------------
procedure OperacionBajarPiezas()
/*