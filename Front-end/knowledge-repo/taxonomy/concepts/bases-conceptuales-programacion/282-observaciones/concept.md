# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 282)

## Contenido
# OBSERVACIONES:

* se estructura como un recorrido en la zona
de n´umeros
*/
{
IrAlBordeDeZonaDeNumeros(Este)
while(puedeMoverEnZonaDeNumeroAl(Oeste))
{
VaciarCelda()
Mover(Oeste)
}
VaciarCelda()
}
//---------------------------------------------------
//----------------------------------------------------
procedure AgregarDigitoAZonaDeNumerosPorIzq(dig)
/*
