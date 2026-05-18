# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 425)

## Contenido
# OBSERVACIONES:

* si no hay pieza, entonces no hace nada
*/
{
if (esSeccionDeAlgunaPieza())
{
IrAPiezaSiExiste(leerCodigoDePiezaActual())
TransformarEnPisoPiezaActual(marca)
}
}
//-----------------------------------------------------
procedure TransformarEnPisoPiezaActual(marca)
/*
PROP´OSITO: transforma en piso la pieza actual
y agrega la marca si corresponde
