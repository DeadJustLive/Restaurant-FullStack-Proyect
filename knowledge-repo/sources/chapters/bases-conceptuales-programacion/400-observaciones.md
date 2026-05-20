# OBSERVACIONES:

* en rotaci´on 1, S es
Norte -> SS <- Norte,Este
Oeste -> SX
donde la X representa al pivote y
las Ss a las dem´as secciones
*/
{
(dA,dB,dC1,dC2) := id(Norte,Oeste,Norte,Este)
(dA,dB,dC1,dC2) := ajustarDires(dA,dB,dC1,dC2,rotPieza)
return (dA,dB,dC1,dC2)
}
//-----------------------------------------------------
function diresDePiezaT(rotPieza)
/*
PROP´OSITO: devolver las direcciones de una T