# 3. Esta posibilidad es la m ´as simple de programar (y quiz ´as la m ´as “natural” en alg ´un

## Fuente
bases-conceptuales-programacion (Cap. 91)

## Contenido
# 3. Esta posibilidad es la m ´as simple de programar (y quiz ´as la m ´as “natural” en alg ´un

sentido). La idea consiste en hacer una funci ´on traducci´on que dado un s´ımbolo
representado como un par ´ametro de tipo n ´umero que ser´ıa el c ´odigo del “jerogl´ıfi-
co” correspondiente, busque en el texto de referencia su traducci ´on, devolviendo el
c ´odigo de la “letra conocida” correspondiente.
Hecho esto, el problema se puede resolver haciendo un ´unico recorrido sobre el tex-
to a traducir, traduciendo s´ımbolo a s´ımbolo mediante la funci ´on reci ´en definida. La
ventaja es que no hay que preocuparse por dejar marcas para volver, aprovechando
que las funciones deshacen todos sus efectos.
La soluci ´on m ´as simple del problema de la Piedra Rosetta muestra el poder que tiene la
divisi ´on de un problema complejo en subtareas m ´as sencillas, siempre que la descompo-
sici ´on se haga pensando en simplificar el proceso completo. Este, m ´as que ning ´un otro
concepto, es el que deben llevarse de esta introducci ´on a la programaci ´on.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 177 of 312 --

178
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 178 of 312 --

179
Un ejemplo completo: ZILFOST
En este cap´ıtulo mostramos c ´omo los conceptos presentados en los cap´ıtulos anteriores
pueden utilizarse para programar un juego sencillo, para el que explicamos completamente
su dise ˜no y su codificaci ´on en GOBSTONES. El juego es una variante del cl ´asico juego de
TETRISTM, y se denomina ZILFOST como regla mnemot ´ecnica para recordar las formas
Tetris es un videojuego de ubica-
ci ´on de piezas dise ˜nado y pro-
gramado por Alexey Pajitnov en
la Uni ´on Sovi ´etica en 1984. El
nombre deriva del prefijo griego
tetra (pues todas las piezas se
componen de cuatro secciones)
y del deporte del tenis, deporte
favorito del autor.
https://en.wikipedia.org/
wiki/Tetris
Para probar el juego, puede
usarse el sitio oficial
http://www.tetris.com/
o el sitio de la versi ´on libre
http://www.freetetris.org/
de las diferentes piezas (ver gr ´afico G.5.1).
Adem ´as presentamos una peque ˜na extensi ´on a GOBSTONES que permite una forma
b ´asica de interacci ´on con el usuario, lo que habilita la posibilidad de usar la herramienta
que implementa GOBSTONES para probar el juego, y por supuesto, para permitir la codifi-
caci ´on de otros juegos similares (basados en turnos). Esta forma de interacci ´on est ´a pen-
sada solamente como recurso para mostrar el poder de las ideas presentadas en el libro,
y no como una herramienta real de programar interfaces de entrada/salida para aplica-
ciones reales. Sin embargo, este mecanismo rudimentario, cuando se combina con otro
par de detalles de presentaci ´on (como la posibilidad de aplicar “skins” o vestimentas a las
celdas del tablero), puede mostrar de manera certera las posibilidades de los conceptos
tratados en el libro.
5.1. Representaci ´on del ZILFOST
El juego de ZILFOST est ´a basado en el popular juego TETRISTM. En este juego hay un
grupo de piezas de varios formatos b ´asicos que “caen” en una zona de juego rectangular.
Decimos que las piezas “caen”, porque pensamos a la zona de juego como un espacio
vertical y a las piezas como objetos f´ısicos, sujetos a las leyes de la gravedad. De esta
manera, las piezas aparecen por arriba y van movi ´endose hacia la base a medida que
transcurre el tiempo.
La idea de c ´omo codificar este juego en GOBSTONES surgi ´o de un parcial de la materia
Introducci ´on a la Programaci ´on de la carrera Tecnicatura Universitaria en Programaci ´on
Inform ´atica de la Universidad Nacional de Quilmes, donde se utiliza GOBSTONES como
primer lenguaje de programaci ´on. En dicho parcial solo se consideraba un tipo ´unico de
piezas, y se generaba la mec ´anica b ´asica del juego. Posteriormente el autor extendi ´o esta
idea con las restantes piezas, y complet ´o la mec ´anica del juego y los restantes elementos
del mismo.
El nombre ZILFOST hace referencia a la regla mnemot ´ecnica utiliza para recordar los
formatos de las piezas b ´asicas. Las mismas son piezas compuestas de 4 secciones cua-
dradas, dispuestas de manera contigua de diferentes formas. As´ı, a las piezas las deno-
minamos Z, I, L, F, O, S y T, por la forma que rememora la disposici ´on de sus secciones
(ver gr ´afico G.5.1).
El tablero de GOBSTONES se utilizar ´a para representar las diferentes partes del juego. Las
piezas se representar ´an en 4 celdas contiguas utilizando bolitas verdes; la cantidad de
bolitas indicar ´a el n ´umero de pieza que se trate. Adem ´as las piezas tendr ´an una secci ´on
especial, denominada pivote, que contendr ´a informaci ´on adicional (codificada con bolitas
negras y rojas); adicionalmente, la rotaci ´on de las piezas ser ´a respecto del pivote.
El tablero codificar ´a las diferentes partes del juego de ZILFOST; habr ´a una zona prin-
cipal, la zona de juego, donde se representar ´an las piezas que van cayendo, y do
