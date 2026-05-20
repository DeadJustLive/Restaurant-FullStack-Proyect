# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 327)

## Contenido
# OBSERVACIONES:

* realiza una selecci´on alternativa en base al
tipo de pieza
*/
{
switch (tipoPieza) to
7 -> { (dirA,dirB,dirC) := diresDePiezaT(rotPieza) }
_ -> { }
return (dirA,dirB,dirC)
}
//-----------------------------------------------------
function diresDePiezaZ(rotPieza)
/*
PROP´OSITO: devolver las direcciones de una Z
