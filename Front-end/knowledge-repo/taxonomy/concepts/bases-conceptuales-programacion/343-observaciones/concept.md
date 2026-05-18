# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 343)

## Contenido
# OBSERVACIONES:

* en rotaci´on 1, T es
Oeste -> TXT <- Este
T <- Sur
donde la X representa al pivote y
las Ts a las dem´as secciones
* se usa una direcci´on dD como dummy
para reutilizar ajustarDires
*/
{
(dA,dB,dC,dD) := id(Oeste,Este,Sur,Sur)
--^--DUMMY!!
(dA,dB,dC,dD) := ajustarDires(dA,dB,dC,dD,rotPieza)
return (dA,dB,dC)
}
//----------------------------------------------------
function id(dA,dB,dC1,dC2)
/*
PROP´OSITO: retornar varios valores simult´aneamente
*/
{ return (dA,dB,dC1,dC2) }
//-----------------------------------------------------
function ajustarDires(dirA,dirB,dirC1,dirC2,rotPieza)
/*
PROP´OSITO: ajustar las direcciones en base a la
rotaci´on
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 275 of 312 --

276
