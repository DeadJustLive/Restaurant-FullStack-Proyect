# OBSERVACIONES:

* Zilfost es un juego basado en el Tetris, pero donde
las reglas son levemente diferentes
* se basa en una idea de un parcial de
Introducci´on a la Programaci´on de la
carrera TPI de la UNQ, con agregados propios
* el nombre ZILFOST se inspira en la forma de las
piezas, que recuerdan levemente a distintas letras
* casi TODAS las operaciones asumen como
precondici´on global m´ınima que hay una
codificaci´on v´alida de Zilfost en el
tablero
* una codificaci´on v´alida de Zilfost cumple:
- se codifican 3 zonas en el tablero: la zona de semilla,
la zona de juego y la zona de datos
- sobre la zona de juego:
. la zona de juego est´a delimitada en sus extremos
inferior izquierdo e inferior derecho con
dos celdas con exactamente 5 bolitas azules,
de manera que la de la izquierda es la primer
celda en recorrido NE que tiene exactamente esa
cantidad de bolitas
. desde esas dos celdas, hacia arriba hay dos filas
de bolitas azules con 6 en el cuerpo
y 7 en el tope; este tope se encuentra en el
borde Norte
. estas dos filas delimitan la zona de
juego
. la primer celda a la derecha de la celda con 5
bolitas azules de la izquierda se denomina el
origen de la zona de juego
- sobre la zona de datos:
. a la izquierda de la zona de juego
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 257 of 312 --

258
se encuentra la zona de datos, que
tiene la misma altura que la zona de juego.
. la zona de datos contendr´a 2 zonas de n´umeros
en su parte inferior, la zona de c´odigo de la
pr´oxima pieza a ingresar a la zona de juego y
la zona del c´odigo de pieza seleccionada
- sobre la zona de semilla:
. abajo de las zonas de juego y de datos se
encuentra la zona de semilla, que tiene el mismo
ancho que ambas zonas juntas
. la zona de semilla es una zona de n´umeros
- sobre las zonas de n´umeros:
. las zonas de n´umeros tienen una fila de
alto y est´an delimitadas arriba y abajo
por filas cuyas celdas tienen casi todas 4
bolitas azules (algunas pueden variar esta
cantidad en funci´on de otras condiciones)
. los extremos izquierdo y derecho de la fila
de una zona de n´umeros estar´an delimitados por
celdas con 6 bolitas azules
. las zonas de n´umeros utilizan numeraci´on
posicional decimal est´andar, de derecha a
izquierda desde las unidades
. cada d´ıgito d en una zona de n´umeros
se codifica con 1 bolita
azul para indicar su presencia, y d
bolitas negras para indicar de qu´e d´ıgito se
trata (0<=d<=9)
. una celda vac´ıa indica que no hay d´ıgito en
ese lugar
- las piezas se codifican en 4 celdas contiguas
utilizando bolitas verdes, rojas y negras.
- el piso se codifica con exactamente 8 bolitas azules
(y puede llevar marcas especiales con bolitas azules
extra)
- una pieza es v´alida si (ver SECCI´ON 2):
. ocupa 4 celdas contiguas identificadas con
la misma cantidad de bolitas verdes
(el c´odigo de la pieza)
. una sola de las celdas es el pivote
(identificado con bolitas negras y
rojas -- las negras indican el
tipo de pieza y las rojas la rotaci´on)
. las celdas de la pieza est´an dispuestas
seg´un indican el tipo y la rotaci´on
. un tipo v´alido va entre 1 y 7