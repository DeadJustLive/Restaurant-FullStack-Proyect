# OBSERVACIONES:

* solo baja las celdas de piso; las de piezas
no se bajan
* Si al bajar el piso puede romper una pieza,
entonces es absorvido (no rompe la pieza)
*/
{
if (not esSeccionDeAlgunaPieza())
// Con este if, las piezas no resultan destruidas
// por el piso
{
if (hayPisoAl(Norte))
// con este if, las piezas arriba de este
// piso no bajan
{ if (not esPiso()) { PonerPiso() } }
else
// si arriba no hay piso (est´a vac´ıo o hay
// pieza), debe vaciarse porque las celdas
// de pieza no bajan
{ VaciarCelda() }
}
}
Como est ´a establecido en las observaciones del contrato del procedimiento, al bajar la
celda al norte, debemos verificar varias condiciones. Primero que nada, si la celda actual
contiene una secci ´on de pieza, entonces no debe alterarse (o sea, si hay piso sobre ella, el
piso ser ´a absorvido). En caso que la celda no tenga una secci ´on de pieza, debe verificarse
la celda inmediatamente al norte (que sabemos que existe, por la precondici ´on), y si hay
piso al norte, entonces la celda actual debe terminar siendo piso, ya sea que ya hab´ıa uno,
o porque agregamos uno si no hab´ıa; si en cambio la celda al norte est ´a vac´ıa o hay pieza
(o sea, no hay piso), entonces la celda actual debe vaciarse.
Para completar las operaciones de eliminar filas de piso llenas, vemos el procedimiento
VaciarDePisoLaFilaActual. El mismo se estructura como un recorrido de las celdas de
la fila actual, quitando el piso de aquellas celdas que lo contengan. Dado que tanto este
c ´odigo como el de la operaci ´on auxiliar QuitarPiso son extremadamente simples, los
mismos ser ´an omitidos.
5.5.5. Generaci ´on del logo de ZILFOST
Todas las operaciones definidas hasta el momento nos permitir ´an controlar la mec ´anica
de las piezas en la zona de juego. Antes de continuar con las operaciones de interfaz que
permitir ´an que un usuario juegue (o simular el juego de un usuario ficticio), mostraremos el
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 221 of 312 --

222
procedimiento utilizado para generar el gr ´afico G.5.1. Este procedimiento es muy sencillo,
pues simplemente combina operaciones anteriormente definidas de manera secuencial.
procedure GenerarLogoZILFOST()
/*
PROP´OSITO: Dibuja ZILFOST con piezas