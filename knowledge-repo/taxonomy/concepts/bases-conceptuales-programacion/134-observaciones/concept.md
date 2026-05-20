# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 134)

## Contenido
# OBSERVACIONES:

* va a la zona de pr´oxima pieza y lee el
n´umero all´ı codificado
*/
{
IrAlOrigenDeZonaDeProximaPieza()
return(leerZonaDeNumeros())
}
Las operaciones para leer las zonas restante son pr ´acticamente id ´enticas y las omitimos.
Las operaciones de borrado y de modificaci ´on de estas zonas son pr ´acticamente
id ´enticas a las de lectura: se mueven al origen de la zona, y la modifican utilizando la
operaci ´on correspondiente de la secci ´on anterior. Debido a su simplicidad, omitimos tam-
bi ´en el c ´odigo.
Para Reflexionar
Quiz ´as resulte oportuno volver a reflexionar sobre la importancia de dividir en
subtareas. Puesto que las subtareas de operaciones sobre zonas de n ´umeros
fueron bien elegidas, las operaciones para las zonas espec´ıficas son extremada-
mente sencillas. ¡Es tan importante este concepto que en nuestra propuesta de
ense ˜nanza consideramos que debe ser de los primeros conceptos que aprenda
una persona que se inicia en programaci ´on!
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 194 of 312 --

195
5.3. C ´odigo para expresar piezas
Las piezas del ZILFOST se representan con bolitas verdes, rojas y negras en la zona de
juego. Se definen para las piezas una serie de operaciones con el objetivo de expresar su
geometr´ıa y detectarlas a ellas o su ausencia.
En primer lugar consideraremos las operaciones relativas a la geometr´ıa de las piezas,
luego las operaciones que permiten detectar piezas o lugar para ellas.
5.3.1. Geometr´ıa de las piezas
Cada una de las piezas tienen una forma espec´ıfica, y para dibujarla o borrarla, debemos
conocer esa forma. En lugar de proveer una operaci ´on de dibujo y una de borrado por
cada una de las piezas, lo cual har´ıa que codific ´asemos varias veces la forma de la pieza
en lugares diferentes, vamos a separar el problema de dibujarlas o borrarlas en, por un
lado, representar la forma de la pieza mediante datos, y por el otro en utilizar dichos datos
para el dibujo o borrado efectivo.
En esta subsecci ´on presentamos el c ´odigo necesario para representar la forma de las
distintas piezas mediante datos. Las funciones que definiremos para esta tarea son las
siguientes
// function rotar(rotacion,sentidoHorario)
//
// function esClaseA(tipoPieza)
// function esClaseB(tipoPieza)
//
// function diresDePiezaClaseA(tipoPieza,rotPieza)
// function diresDePiezaClaseB(tipoPieza,rotPieza)
// function diresDePiezaZ(rotPieza)
// function diresDePiezaI(rotPieza)
// function diresDePiezaL(rotPieza)
// function diresDePiezaF(rotPieza)
// function diresDePiezaO(rotPieza)
// function diresDePiezaS(rotPieza)
// function diresDePiezaT(rotPieza)
//
// function id(dA,dB,dC1,dC2)
// function ajustarDires(dA,dB,dC1,dC2,rotPieza)
Iremos viendo el significado y uso de cada una de ellas. Tener en cuenta que las funciones
que se usar ´an luego son solo las 5 primeras; las restantes son funciones auxiliares de
ellas.
La primera de las funciones no est ´a directamente relacionada con las piezas, sino
que concierne exclusivamente a la rotaci ´on. Dado que las rotaciones se representan con
n ´umeros de 1 a 4, cuando queremos rotar una pieza debemos calcular el c ´odigo de la
nueva rotaci ´on. Lo que hace la funci ´on rotar es justamente este c ´alculo.
function rotar(rotacionBase,sentidoHorario)
/*
PROP´OSITO: calcular la rotacion siguiente en
sentido horario o antihorario, seg´un
lo indique el booleano sentidoHorario
