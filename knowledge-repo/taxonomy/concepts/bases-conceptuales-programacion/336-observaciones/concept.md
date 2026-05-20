# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 336)

## Contenido
# OBSERVACIONES:

* en rotaci´on 1, F es
Norte -> FF <- Norte,Este
X
F <- Sur
donde la X representa al pivote y
las Fs a las dem´as secciones
*/
{
(dA,dB,dC1,dC2) := id(Norte,Sur,Norte,Este)
(dA,dB,dC1,dC2) := ajustarDires(dA,dB,dC1,dC2,rotPieza)
return (dA,dB,dC1,dC2)
}
//-----------------------------------------------------
function diresDePiezaO(rotPieza)
/*
PROP´OSITO: devolver las direcciones de una O
