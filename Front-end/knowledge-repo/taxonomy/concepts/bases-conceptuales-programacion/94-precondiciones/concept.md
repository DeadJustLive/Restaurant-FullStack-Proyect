# PRECONDICIONES:

## Fuente
bases-conceptuales-programacion (Cap. 94)

## Contenido
# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
*/
{
IrAlOrigenDeZonaDeJuego()
return (medirDistanciaAlBorde(Oeste))
}
Podemos observar que reutilizamos la funci ´on medirDistanciaAlBorde que realizamos
en el ejercicio 4.3.6, que en este caso totaliza la cantidad de celdas que hay que mo-
verse desde el origen de la zona de juego hasta alcanzar el borde Oeste. La funci ´on
desplazamientoYDeZonaDeJuego es similar, pero se mueve hacia el borde Sur.
Leer con Atenci ´on
Es de destacar la forma en que se van reutilizando las operaciones que ya fue-
ron definidas con anterioridad. De esta manera la cantidad de c ´odigo que debe
realizarse disminuye, y consecuentemente la cantidad de trabajo necesario para
escribirlo y mantenerlo.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 184 of 312 --

185
Para Reflexionar
Reflexione sobre la importancia de que las operaciones que uno va definiendo
sean lo suficientemente generales (por ejemplo mediante el uso de par ´ametros)
como para que puedan aplicarse en diversos problemas con ning ´un o pocos
cambios. Reflexione sobre la importancia de contar con un mecanismo (como
la Biblioteca) que permita no replicar el c ´odigo de estas operaciones entre
diversas aplicaciones diferentes.
Un elemento de utilidad para movernos dentro de la zona de juego sin salirse de la misma
(y sin tener que controlar cada vez mediante la codificaci ´on de bolitas si estamos en el
borde) ser ´a conocer el ancho y alto de la zona de juego. Para eso definiremos funciones
anchoDeZonaDeJuego y altoDeZonaDeJuego, de la siguiente manera
function anchoDeZonaDeJuego()
/*
PROP´OSITO: retorna la cantidad de celdas de ancho
de la zona de juego
