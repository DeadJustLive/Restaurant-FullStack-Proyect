# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 467)

## Contenido
# OBSERVACIONES:

* se estructura como un recorrido sobre las
celdas de la zona de juego, quitando todas
las piezas
*/
{
// Iniciar recorrido NE en la zona de juego
IrAlOrigenDeZonaDeJuego()
while (not esFinDelRecorridoNEDeZonaDeJuego())
{
VaciarCelda()
AvanzarEnRecorridoNEDeZonaDeJuego()
}
VaciarCelda()
}
B.6. Operaciones de interfaz
