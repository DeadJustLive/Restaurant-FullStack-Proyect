# PRECONDICIONES:

## Fuente
bases-conceptuales-programacion (Cap. 152)

## Contenido
# PRECONDICIONES:

* est´a parado sobre el lugar en el que va el pivote
de la pieza
* las direcciones dadas codifican la pieza
correctamente
*/
{
return(esCeldaVacia()
&& hayCeldaLibreAl(dirA)
&& hayCeldaLibreAl(dirB)
&& hayCeldaLibreAl(dirC))
}
Se puede observar que en cada caso se verifica que las 4 celdas que alojar ´an a las seccio-
nes (indicadas por las direcciones obtenidas de los par ´ametros) est ´an libres. Para eso se
utilizan tres funciones auxiliares: esCeldaVacia, hayCeldaLibreAl y hayCeldaLibreAlY.
Consideraremos cada una de ellas por separado, puesto que requieren cierto cuidado.
La funci ´on esCeldaLibre simplemente verifica que la celda actual est ´e vac´ıa. Para ello
abstrae a la funci ´on esCeldaVacia que es una funci ´on de Biblioteca que verifica si en la
celda no hay bolitas de ning ´un color; esta funci ´on se defini ´o en el ejercicio 3.2.14.
function esCeldaLibre()
/*
PROP´OSITO: determinar si la celda actual es una
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 202 of 312 --

203
celda libre
