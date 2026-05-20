# OBSERVACIONES:

* es libre si hay celda y no tiene pieza
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 203 of 312 --

204
*/
{
if (puedeMoverEnZonaDeJuego(dir1))
{ Mover(dir1)
if (puedeMoverEnZonaDeJuego(dir2))
{ Mover(dir2)
celdaLibre := esCeldaLibre() }
else { celdaLibre := False }} -- No existe la celda2
else { celdaLibre := False } -- No existe la celda1
return (celdaLibre)
}
Podr´ıamos haber utilizado una expresi ´on compleja bas ´andonos en la caracter´ıstica del
circuito corto (short circuit) de la conjunci ´on booleana, pero habr´ıa sido innecesariamente
complicado.
5.4. C ´odigo para operaciones b ´asicas sobre piezas
Una vez definidas las funciones que expresan a las piezas, podemos empezar a ver cu ´ales
son las operaciones b ´asicas sobre piezas. Las vamos a dividir en tres partes: la operaci ´on
de localizar una pieza, las operaciones de colocar y quitar una pieza del tablero y las
operaciones de movimiento de piezas (bajar, desplazar y rotar). A cada una de estas
partes le dedicaremos una de las pr ´oximas subsecciones.
5.4.1. Localizar una pieza
La primera de las operaciones b ´asicas de piezas es la de localizar una pieza determinada
en la zona de juego. Esta operaci ´on se utiliza para que cuando el jugador digita el c ´odigo
de una pieza en la zona de selecci ´on, el programa pueda encontrarla y as´ı poder operar
sobre ella. Si la pieza no existe, se ubica en una esquina y no hace nada m ´as. Al pro-
cedimiento que la codifica lo denominamos IrAPiezaSiExiste, y se estructura como un
recorrido de b ´usqueda sobre las celdas de la zona de juego, terminando o bien cuando
encuentra la pieza buscada, o bien cuando se acaban las celdas.
procedure IrAPiezaSiExiste(codPieza)
/*
PROP´OSITO: va a la celda pivote de la pieza de
c´odigo codPieza, si existe