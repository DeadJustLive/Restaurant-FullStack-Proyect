# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 463)

## Contenido
# OBSERVACIONES:

* se estructura como un recorrido sobre
las celdas de la fila actual
*/
{
IrAlBordeDeZonaDeJuego(Oeste)
while (puedeMoverEnZonaDeJuego(Este))
{
if (esPiso()) { QuitarPiso() }
Mover(Este)
}
if (esPiso()) { QuitarPiso() }
}
//-----------------------------------------------------
procedure QuitarPiso()
/*
PROP´OSITO: quita el piso de la celda actual
