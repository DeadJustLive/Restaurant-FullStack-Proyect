# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 50)

## Contenido
# PRECONDICI´ON:

* La celda actual no tiene bolitas verdes
* La celda actual es parte de un camino simple
* Una de los dos sectores contiguos ya fue visitado
y tiene una flor
-}
{
-- Elegir la direcci´on para seguir y codificarla
foreach dir in [Norte..Oeste]
{
if (puedeMover(dir))
{
if (haySectorNoVisitadoAl(dir))
{ CodificarDireccion(dir) }
}
}
DecodificarDireccion()
}
La primera parte trabaja de manera similar al procedimiento de la secci ´on 4.2.1 denomina-
do CodificarDireccionDelEnemigo, codificando la direcci ´on en la que hay bolitas negras
pero no rojas, teniendo en cuenta qu ´e sucede en las celdas que no tienen 4 contiguas.
Y luego una segunda parte decodifica la direcci ´on, mirando el n ´umero de bolitas verdes
(usando, por ejemplo, una alternativa indexada), y con base en ese n ´umero, saca todas
las verdes y se mueve en la direcci ´on correspondiente. ¡Observar que debe hacerse en
dos partes, porque si no, no habr´ıa forma de saber si debemos parar de mirar las celdas
vecinas! Tambi ´en hay que observar que el procedimiento DecodificarDireccion debe
eliminar las bolitas verdes despu ´es de “leerlas”, as´ı no quedan en el tablero.
Una vez codificadas todas las partes, podemos definir el procedimiento como
procedure PonerFloresEnSenderoSimple()
