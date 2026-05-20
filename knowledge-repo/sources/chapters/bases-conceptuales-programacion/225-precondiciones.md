# PRECONDICIONES:

* la rotaci´on es v´alida (y puede llevar una
marca de 7 bolitas rojas)
*/
{
switch (rotPieza) to
1,8 -> -- La rotaci´on ‘‘natural’’
{
ndirA := dirA
ndirB := dirB
ndirC1 := dirC1
ndirC2 := dirC2
}
2,9 -> -- 1/4 de giro en sentido horario
{
ndirA := siguiente(dirA)
ndirB := siguiente(dirB)
ndirC1 := siguiente(dirC1)
ndirC2 := siguiente(dirC2)
}
3,10 -> -- 1/2 giro
{
ndirA := opuesto(dirA)
ndirB := opuesto(dirB)
ndirC1 := opuesto(dirC1)
ndirC2 := opuesto(dirC2)
}
4,11 -> -- 1/4 de giro en sentido antihorario
{
ndirA := previo(dirA)
ndirB := previo(dirB)
ndirC1 := previo(dirC1)
ndirC2 := previo(dirC2)
}
_ -> { }
return (ndirA,ndirB,ndirC1,ndirC2)
}
Observar el uso de la alternativa indexada para elegir el caso, y de las operaciones primi-
tivas siguiente, opuesto y previo para calcular las nuevas direcciones.
5.3.2. Detecci ´on de piezas
Para la detecci ´on de piezas (o su ausencia), definiremos varias funciones que permitir ´an
mirar desde la existencia de una secci ´on espec´ıfica, las de una pieza entera, e incluso si
hay lugar para una pieza (que verificar´ıa las mismas direcciones que se usan para verificar
la existencia de la pieza). Las funciones son
// function esSeccionDeAlgunaPieza()
// function esSeccionPivoteDeAlgunaPieza()
// function esSeccionPivoteDePieza(codPieza)
// function hayPiezaActual()
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 199 of 312 --

200
//
// function leerCodigoDePiezaActual()
// function leerTipoDePiezaActual()
// function leerRotacionDePiezaActual()
//
// function hayLugarParaPiezaTipo(tipoPieza, rotPieza)
// function hayLgPzClaseAEnDires(dirA,dirB,dirC1,dirC2)
// function hayLgPzClaseBEnDires(dirA,dirB,dirC)
// function hayCeldaLibreAl(dir)
// function hayCeldaLibreAlY(dir1,dir2)
Las cuatro finales son solamente auxiliares para hayLugarParaPiezaTipo.
El primer grupo de funciones permite detectar si el cabezal se encuentra sobre una
secci ´on de pieza, y en algunos casos, si se trata del pivote. La primera simplemente de-
tecta si hay una secci ´on en la celda actual, lo cual es extremadamente simple
function esSeccionDeAlgunaPieza()
/*
PROP´OSITO: determinar si la celda actual es
secci´on pivote de alguna pieza
*/
{ return (hayBolitas(Verde)) }
La siguiente funci ´on refina a la primera, agregando la condici ´on de que no sea cualquier
secci ´on, sino que debe ser el pivote de alguna pieza; dada la codificaci ´on propuesta,
tambi ´en es muy simple
function esSeccionPivoteDeAlgunaPieza()
/*
PROP´OSITO: determinar si la celda actual es la
secci´on pivote de una pieza
*/
{
return (esSeccionDeAlgunaPieza()
&& hayBolitas(Negro)
&& hayBolitas(Rojo))
}
La tercera refina a ´un m ´as a las anteriores, especificando que no debe tratarse de cualquier
pieza, sino de la indicada por el par ´ametro; para hacerla tambi ´en se sigue la codificaci ´on
propuesta
function esSeccionPivoteDePieza(codPieza)
/*
PROP´OSITO: determinar si la celda actual es la
secci´on pivote de la pieza codPieza
*/
{ return (esSeccionPivoteDeAlgunaPieza()
&& nroBolitas(Verde)==codPieza) }
Puesto que durante el juego usaremos la convenci ´on de que todo tratamiento para las
piezas (moverlas, rotarlas, etc.) se hace desde el pivote, estas dos funciones resultan
ser muy importantes para encontrar las piezas a tratar. Para facilitar la lectura del c ´odigo
posterior, se provee una peque ˜na abstracci ´on para decidir si hay una pieza en la celda
actual (en lugar de tener que preguntar por su pivote, preguntamos por toda la pieza)
function hayPiezaActual()
/*
PROP´OSITO: establecer si la celda actual determina una pieza
seleccionada, lo cual por convenci´on quiere decir
que est´a sobre la secci´on pivote de una pieza
*/
{ return (esSeccionPivoteDeAlgunaPieza()) }
Una vez que se ha establecido que existe una pieza, nos har ´a falta determinar de qu ´e pie-
za se trata y cu ´ales son sus caracter´ısticas (tipo y rotaci ´on). Para ello definimos funciones
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 200 of 312 --

201
de lectura con la precondici ´on de que para utilizarla ya se debe estar sobre el pivote de la
pieza, lo cual es f ´acilmente detectable con las funciones presentadas antes. Las funciones
de lectura de piezas se dejan como ejercicio.
Actividad de Programaci ´on 6
Realice el ejercicio 5.3.1 y constate que el c ´odigo que escribi ´o es correcto con-
trast ´andolo con el c ´odigo del anexo B.
Ejercicio 5.3.1. Escribir funciones para leer el c ´odigo, leerCodigoDePiezaActual, el tipo,
leerTipoDePiezaActual, y la rotaci ´on, leerRotacionDePiezaActual de la pieza actual.
Ayuda: en cada caso, es tan simple como retornar el n ´umero de ciertas bolitas.
Leer con Atenci ´on
¿Por qu ´e de definir funciones tan simples cuando podr´ıamos utilizar directa-
mente la expresi ´on retornada? La raz ´on es que de esta forma estamos abs-
trayendo la soluci ´on, separ ´andola de la manera espec´ıfica que elegimos para
codificar. Esto nos permitir ´a formular el problema en t ´erminos de lo que que-
remos expresar (por ejemplo, que hayPiezaActual()) en lugar de tener que
formularlo en t ´erminos de una codificaci ´on prefijada (hayBolitas(Verde) &&
hayBolitas(Negro) && hayBolitas(Rojo)), pues aunque sus ejecuciones son
equivalentes, la forma en que las personas lo imaginamos no lo es. O sea, es-
tamos elevando el nivel de abstracci ´on, alej ´andolo de la m ´aquina subyacente y
acerc ´andolo a nuestra forma de pensar.
Para Reflexionar
Resulta interesante volver a reflexionar sobre la naturaleza dual de los progra-
mas, que al mismo tiempo son descripciones de soluciones de alto nivel (legibles
y entendibles por los seres humanos) y establecen un mecanismo de ejecuci ´on
de bajo nivel (que permite que una m ´aquina pueda llevar adelante un c ´omputo
espec´ıfico). Tambi ´en se debe reflexionar sobre el impacto que conocer y enten-
der este hecho tiene sobre la calidad del c ´odigo producido.
La ´ultima de las funciones importantes de esta secci ´on es la que permite determinar si
la celda actual indica una posici ´on donde pueda colocarse una determinada pieza. Para
definirla se usan varias funciones auxiliares que describiremos. Esta funci ´on, que denomi-
namos hayLugarParaPiezaTipo, toma como par ´ametros el tipo y la rotaci ´on de una pieza,
y retorna un booleano que es verdadero cuando hay lugar para la pieza (hay celdas libres
en los lugares necesarios). Para esto utiliza las funciones que obtienen las direcciones de
una pieza, y dos funciones auxiliares para procesar las celdas de clase A y B.
function hayLugarParaPiezaTipo(tipoPieza, rotPieza)
/*
PROP´OSITO: informar si hay lugar en el tablero
para colocar una pieza de tipo tipoPieza
y rotaci´on rotPieza con pivote en la
celda actual