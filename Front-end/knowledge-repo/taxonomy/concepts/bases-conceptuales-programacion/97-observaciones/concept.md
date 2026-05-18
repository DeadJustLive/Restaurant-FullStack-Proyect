# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 97)

## Contenido
# OBSERVACIONES:

* optimiza la pregunta (no usan cuentas que deban
recorrer mucho el tablero)
* la verificaci´on usa el formato de codificaci´on
de un tablero Zilfost
*/
{
switch (dir) to
Norte ->
// Si dir es Norte, se puede mover dentro de la
// zona si hay lugar al norte
{ puede := puedeMover(Norte) }
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 185 of 312 --

186
Este, Oeste ->
// Si dir es Este u Oeste, se puede mover dentro
// de la zona si al moverse se topa con el borde
{
Mover(dir)
puede := not (nroBolitas(Azul)==5
|| nroBolitas(Azul)==6
|| nroBolitas(Azul)==7
)
}
_ -> // Solo hay 4 direcciones!!!
// Si dir es Sur, se puede mover dentro de la
// zona si al moverse al sur se topa con el borde
{
Mover(Sur)
puede := not (nroBolitas(Azul)==4)
}
return (puede)
}
Para detectar si se trata de un borde se utilizan las convenciones en la representaci ´on de
la zona. Al Sur el l´ımite contiene 4 bolitas azules; a Este y Oeste, contiene 5, 6 ´o 7 bolitas
azules; y al Norte el l´ımite de la zona es es l´ımite del tablero. Esto permite realizar una
consulta eficiente de la posibilidad de moverse en la zona de juego, lo que resulta crucial
para la eficiencia de las operaciones del juego.
El primer procedimiento se define como
procedure IrAlBordeDeZonaDeJuego(dir)
/*
PROP´OSITO: ir al borde en direcci´on dir
dentro de la zona de juego del Zilfost
