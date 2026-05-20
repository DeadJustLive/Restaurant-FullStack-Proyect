# OBSERVACIONES:

* el c´alculo se realiza de la siguiente forma
rotacion 1 2 3 4
. mod 4 1 2 3 0
. +1 2 3 4 1 // En sentido horario
rotacion 1 2 3 4
. + 2 3 4 5 6
. mod 4 3 0 1 2
. + 1 4 1 2 3 // En sentido antihorario
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 195 of 312 --

196
*/
{
// Recordar si tiene o no marca
if (rotacionBase>=1 && rotacionBase<=4)
{ marca := 0 }
else { if (rotacionBase>=8 && rotacionBase<=11)
{ marca := 7 }
else { }} -- La rotaci´on es inv´alida
// Ajusta la rotaci´on si tiene marcas
rotacion := rotacionBase - marca
// Calcula la nueva rotaci´on
if (sentidoHorario)
{ nuevaRotacion := (rotacion mod 4) + 1 }
else
{ nuevaRotacion := (rotacion+2) mod 4 + 1 }
// Retorna, restaurando la marca si corresponde
return (nuevaRotacion+marca)
}
La funci ´on asume que la rotaci ´on puede venir marcada (algo que se presentar ´a despu ´es,
durante la codificaci ´on de la mec ´anica del juego), por lo que la primer parte se encarga
de detectar si hay tal marca, y quitarla temporalmente. La rotaci ´on propiamente dicha se
realiza mediante una f ´ormula, cuyo sentido se explica en el comentario. Finalmente, al
retornar, se restaura la marca (si es que la misma exist´ıa). Una observaci ´on interesante
es c ´omo, en caso de que la rotaci ´on no sea v ´alida, la funci ´on falla por no haber inicializado
correctamente la variable marca.
Para las piezas, como dijimos, cada una consta de 4 secciones contiguas y tal que una
de ellas es el pivote de la pieza. El pivote ser ´a el eje de rotaci ´on de la pieza, y adem ´as lo
usaremos como el centro desde el cual se trabajar ´a sobre la pieza. Entonces es posible
codificar una pieza dando las direcciones desde el pivote en el que se encuentran las otras
3 secciones. Ahora bien, en 6 de las piezas (la Z, la I, la L, la F, la O y la S), dos de las tres
secciones restantes se encuentran inmediatamente al lado del pivote, y la otra a mayor
distancia. En cambio en la ´ultima de las piezas (la T), las tres secciones restantes est ´an
contiguas al pivote. Este hecho lo representaremos hablando de la clase de la pieza: una
pieza ser ´a de clase A cuando tenga dos secciones contiguas y una distante, y ser ´a de
clase B cuando tenga las tres secciones contiguas al pivote. Con esta definici ´on, es f ´acil
escribir el c ´odigo de las primeras dos funciones
function esClaseA(tipoPieza)
/*
PROP´OSITO: indica si la pieza del tipo dado
es de clase A
*/
{ return(tipoPieza >= 1 && tipoPieza <= 6) }
function esClaseB(tipoPieza)
/*
PROP´OSITO: indica si la pieza del tipo dado
es de clase B
*/
{ return(tipoPieza >= 7 && tipoPieza <= 7) }
Vemos que la primera funci ´on retorna un booleano que indica si el c ´odigo del tipo de pieza
es de una de las primeras 6 piezas (Z, I, L, F, O ´o S) y la segunda retorna un booleano que
indica si el c ´odigo del tipo de pieza de la ´ultima de las piezas (T). Es interesante utilizar las
funciones de esta manera, para abstraer la definici ´on espec´ıfica del concepto a expresar.
Estas funciones se usar ´an posteriormente para decidir cu ´al de las operaciones gen ´ericas
de piezas deben invocarse (si los de clase A o los de clase B).
Una vez definida la noci ´on de clase, vemos que las piezas de clase A pueden ser
representadas mediante 4 direcciones. Las dos primeras direcciones indican en qu ´e di-
recci ´on desde el pivote se encuentran las dos secciones contiguas. Las dos ´ultimas direc-
ciones indican hacia d ´onde se encuentra la tercer secci ´on (que siempre estar ´a a distancia
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 196 of 312 --

197
2 del pivote, por ser una pieza de clase A). Por otra parte, las piezas de clase B puede ser
representadas mediante 3 direcciones. Adem ´as, las direcciones en las que se encuen-
tran las secciones contiguas tambi ´en dependen de la rotaci ´on. Con estas ideas, estamos
en condiciones de definir las siguientes dos funciones, que se encargan de obtener las
direcciones necesarias de cada tipo de pieza, dado el tipo y la rotaci ´on.
function diresDePiezaClaseA(tipoPieza,rotPieza)
/*
PROP´OSITO: devolver las direcciones de una pieza
de clase A, ajustadas seg´un la rotaci´on