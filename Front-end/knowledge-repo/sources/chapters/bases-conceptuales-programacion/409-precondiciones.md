# PRECONDICIONES:

* est´a parado sobre el lugar en el que va el pivote
de la pieza
* las direcciones dadas codifican la pieza
correctamente
*/
{
return(esCeldaLibre()
&& hayCeldaLibreAl(dirA)
&& hayCeldaLibreAl(dirB)
&& hayCeldaLibreAlY(dirC1,dirC2))
}
//----------------------------------------------------
function hayLgPzClaseBEnDires(dirA,dirB,dirC)
/*
PROP´OSITO: completar el trabajo de hayLugarParaPiezaTipo
para las piezas de clase B