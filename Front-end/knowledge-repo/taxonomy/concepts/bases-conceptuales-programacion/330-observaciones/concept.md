# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 330)

## Contenido
# OBSERVACIONES:

* en rotaci´on 1, Z es
Norte,Oeste -> ZZ <- Norte
XZ <- Este
donde la X representa al pivote y
las Zs a las dem´as secciones
*/
{
(dA,dB,dC1,dC2) := id(Este,Norte,Norte,Oeste)
(dA,dB,dC1,dC2) := ajustarDires(dA,dB,dC1,dC2,rotPieza)
return (dA,dB,dC1,dC2)
}
//-----------------------------------------------------
function diresDePiezaI(rotPieza)
/*
PROP´OSITO: devolver las direcciones de una I
