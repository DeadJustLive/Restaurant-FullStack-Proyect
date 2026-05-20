# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 288)

## Contenido
# OBSERVACIONES:

Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 266 of 312 --

267
* usa el algoritmo usual de incremento con carry
("llevarme uno"), o sea un recorrido sobre los
d´ıgitos a incrementar
* puede fallar si excede el m´aximo representable
*/
{
IrAlBordeDeZonaDeNumeros(Este)
IncrementarDigitoDeCelda()
carry := (leerDigito() == 0)
while (carry && puedeMoverEnZonaDeNumeroAl(Oeste))
{
Mover(Oeste)
IncrementarDigitoDeCelda()
carry := (leerDigito() == 0)
}
if (carry) // Se excedi´o del m´aximo permitido de piezas!
{
BorrarZonaDeNumeros()
IncrementarDigitoDeCelda()
}
}
//----------------------------------------------------
procedure IncrementarDigitoDeCelda()
/*
PROP´OSITO: incrementa el d´ıgito actual
