# PRECONDICIONES:

## Fuente
bases-conceptuales-programacion (Cap. 352)

## Contenido
# PRECONDICIONES:

* est´a parado sobre el lugar en el que va el pivote
de la pieza
* las direcciones dadas codifican la pieza
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 278 of 312 --

279
correctamente
*/
{
return(esCeldaLibre()
&& hayCeldaLibreAl(dirA)
&& hayCeldaLibreAl(dirB)
&& hayCeldaLibreAl(dirC))
}
//-----------------------------------------------------
function esCeldaLibre()
/*
PROP´OSITO: determinar si la celda actual es una
celda libre
