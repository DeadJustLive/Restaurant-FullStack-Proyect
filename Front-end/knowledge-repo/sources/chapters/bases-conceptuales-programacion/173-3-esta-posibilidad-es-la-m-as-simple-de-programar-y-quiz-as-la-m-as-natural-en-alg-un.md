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
cipal, la zona de juego, donde se representar ´an las piezas que van cayendo, y dos zonas
especiales: la zona de semilla y la zona de datos. La zona de semilla se utiliza para al-
macenar la semilla de un generador de n ´umeros seudoaleatorios, y podr ´a ser utilizada en
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 179 of 312 --

180
(a). Las piezas de ZILFOST sobre el tablero
(b). Las piezas de ZILFOST desplegadas para formar el nombre
G.5.1. Las piezas de ZILFOST, donde puede apreciarse c ´omo el nombre es ins-
pirado por la forma de las piezas
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 180 of 312 --

181
G.5.2. Las diferentes zonas de un tablero de ZILFOST
el tablero inicial para variar la secuencia de piezas del juego y otras particularidades. La
zona de datos se utilizar ´a para representar el n ´umero de la pr ´oxima pieza a ser jugada y
la pieza seleccionada actualmente; por el momento adem ´as posee un espacio no utiliza-
do (que podr´ıa usarse, por ejemplo, para representar la pr ´oxima pieza que aparecer ´a, u
otros elementos). En el gr ´afico G.5.2 se pueden ver un tablero inicial de ZILFOST, con las
diferentes zonas indicadas espec´ıficamente.
Para codificar un juego de ZILFOST se utilizar ´an las siguientes convenciones.
La zona de juego est ´a delimitada en sus extremos inferior izquierdo e inferior de-
recho con dos celdas con exactamente 5 bolitas azules, de manera que la de la
izquierda es la primer celda en recorrido noreste que tiene exactamente esa canti-
Recordemos que un recorrido
noreste arranca en la esquina
suroeste y avanza por filas hacia
el este y el norte, seg ´un se viera
en la subsecci ´on 4.2.3.
dad de bolitas. Adem ´as desde esas dos celdas, hacia arriba, hay dos columnas de
bolitas azules con 6 bolitas en cada celda del cuerpo de la columna y 7 bolitas en
la celda de tope; este tope se encuentra en el borde Norte (ver gr ´afico G.5.2). La
primer celda vac´ıa a la derecha de la celda inferior izquierda de la zona de juego
(con 5 bolitas azules) es el origen de la zona de juego.
A la izquierda de la zona de juego se encuentra la zona de datos, que tiene la misma
altura que la zona de juego y el ancho necesario para abarcar hasta borde oeste
del tablero. La zona de datos contendr ´a en su parte inferior dos zonas de n ´umeros
(el c ´odigo de la pr ´oxima pieza a ingresar a la zona de juego y el c ´odigo de la pieza
seleccionada actualmente).
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 181 of 312 --

182
G.5.3. Codificaci ´on de una zona de n ´umeros de 2 d´ıgitos, representando al n ´ume-
ro 1 (1 bolita negra en el d´ıgito)
Abajo de las zonas de juego y de datos se encuentra la zona de semilla, abarcando
el mismo ancho que ambas zonas. Esta zona es una zona de n ´umeros.
Las zonas de n ´umeros tienen 1 fila de alto y est ´an delimitadas arriba y abajo por
filas de 4 bolitas azules en la mayor´ıa de las celdas (algunas de las celdas pueden
variar la cantidad en funci ´on de otras condiciones); adem ´as, los extremos izquierdo
y derecho de una fila de la zona de n ´umeros estar ´an delimitados por una celda con
6 bolitas azules (ver gr ´afico G.5.3).
Las zonas de n ´umeros utilizan numeraci ´on posicional decimal est ´andar, de derecha
a izquierda desde las unidades. Cada d´ıgito d en una zona de n ´umeros se codi-
fica con 1 bolita azul para indicar su presencia, y d bolitas negras para indicar de
qu ´e d´ıgito se trata (0 <= d <= 9). Una celda vac´ıa indica que no hay d´ıgito en ese
lugar.
Las piezas se codifican en 4 celdas contiguas utilizando bolitas verdes, rojas y ne-
gras.
El piso se codifica con exactamente 8 bolitas azules (y puede llevar marcas espe-
ciales con bolitas azules extra).
Debemos explicar tambi ´en c ´omo se codifican las piezas. Una pieza se codifica mediante
las siguientes convenciones.
Cada pieza tiene 4 secciones contiguas que ocupan celdas identificadas con la
misma cantidad de bolitas verdes (el c ´odigo de la pieza).
Una sola de las celdas de la pieza es el pivote, identificado con bolitas negras y
rojas; las negras indican el tipo de pieza y las rojas la rotaci ´on.
Las celdas de la pieza est ´an dispuestas seg ´un indican el tipo y la rotaci ´on
Un tipo v ´alido va entre 1 y 7, y la codificaci ´on sigue el orden mnemot ´ecnico dado por
el nombre del juego (1-Z, 2-I, 3-L, 4-F, 5-O, 6-S, 7-T). Cada tipo tiene una rotaci ´on
“natural” que corresponde con la mnemotecnia.
Una rotaci ´on v ´alida va entre 1 y 4 y la codificaci ´on sigue el sentido de las agujas
del reloj (1 - rotaci ´on natural, 2 - 1/4 de giro horario, 3 - 1/2 giro, 4 - 1/4 de giro
antihorario)
El pivote de una pieza puede adem ´as llevar una marca de exactamente 7 bolitas
rojas adicionales.
En el gr ´afico G.5.1a se observan las 7 piezas, numeradas del 1 al 7 (bolitas verdes), cada
una con su tipo (bolitas negras, que en este caso coinciden con las verdes por el orden en
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 182 of 312 --

183
que fueron ingresadas las piezas) y su rotaci ´on (bolitas rojas, en este caso todas con 1,
puesto que todas est ´an en su rotaci ´on natural).
Para considerar que el tablero codifica de manera v ´alida un juego de ZILFOST deben
cumplirse las siguientes condiciones.
El tablero est ´a dividido en zonas a trav ´es del uso de bolitas azules como fuera
explicado.
En la zona de juego solo puede haber piezas v ´alidas o piso, ambos sin marcar.
No hay dos piezas con el mismo c ´odigo en la zona de juego.
En las zonas de n ´umeros solo puede haber d´ıgitos v ´alidos o celdas vac´ıas.
La mayor´ıa de las operaciones de ZILFOST (procedimientos y funciones) tendr ´an como
precondici ´on la existencia de una codificaci ´on v ´alida de un juego de ZILFOST en el tablero
(algunos aceptar ´an como v ´alida la presencia de marcas de pieza o de piso).
Habiendo completado la manera de representar un juego de ZILFOST en el tablero,
estamos en condiciones de empezar a codificar algunas partes del juego.
5.2. C ´odigo GOBSTONES para las zonas
Para empezar a codificar el juego de GOBSTONES, empezaremos por las operaciones
concernientes a las diferentes zonas del juego. Trataremos primero las de la geometr´ıa de
la zona de juego, luego las de las zonas de n ´umeros y finalmente las espec´ıficas de la
geometr´ıa de las zonas de semilla y las de las zonas particulares de n ´umeros de la zona
de datos.
5.2.1. Zona de juego
Para la geometr´ıa de la zona de juego, empezaremos escribiendo los procedimientos y
funciones necesarios para ubicarse en la zona de juego y poder luego movernos dentro
de ella sin invadir otras zonas.
Recordemos que la zona de juego es una zona rectangular, delimitada en sus esquinas
inferiores por celdas con 5 bolitas azules, en sus esquinas superiores por celdas con 7
bolitas azules y rodeada por celdas con 6 bolitas azules a ambos lados.
Definiremos los siguientes procedimientos y funciones concernientes a la zona de
juego
// * Geometr´ıa de la zona de juego
// procedure IrAlOrigenDeZonaDeJuego()
// function desplazamientoXDeZonaDeJuego()
// function desplazamientoYDeZonaDeJuego()
// function anchoDeZonaDeJuego()
// function altoDeZonaDeJuego()
//
// * Movimiento dentro de la zona de juego
// function puedeMoverEnZonaDeJuego(dir)
// procedure IrACoordenadaDeZonaDeJuego(x,y)
// procedure IrAlBordeDeZonaDeJuego(dir)
// function esFinDelRecorridoNEDeZonaDeJuego()
// procedure AvanzarEnRecorridoNEDeZonaDeJuego()
El procedimiento IrAlOrigenDeZonaDeJuego mueve el cabezal hasta la celda denominada
origen de la zona de juego (ver gr ´afico G.5.2), la cual se ubica al este de la celda con 5
bolitas azules que se encuentra en la esquina inferior izquierda de esta zona. Puesto que
en una codificaci ´on v ´alida de ZILFOST dicha celda es la primera en un recorrido noreste
del tablero que cumple esa propiedad, podemos escribir este procedimiento como
procedure IrAlOrigenDeZonaDeJuego()
/*
PROP´OSITO: ir al origen de la zona de juego del Zilfost