# PRECONDICI´ON:

* no hay bolitas verdes en la celda actual
* solo una de las celdas contiguas tiene enemigos
-}
{
foreach dir in [Norte, Este, Sur, Oeste]
{
if (puedeMover(dir))
{
if (hayEnemigosAl(dir))
{ CodificarDireccion(dir) }
}
}
}
Se puede observar que hay una repetici ´on sobre las 4 direcciones, para verificar
por turnos en las 4 celdas contiguas. ¿Pero qu ´e sucede si la celda actual no tiene
4 celdas contiguas? En ese caso, en esa direcci ´on no se debe verificar, porque
eso producir´ıa la autodestrucci ´on del cabezal; para eso se utiliza la alternativa
condicional que pregunta si se puede mover en la direcci ´on que se est ´a proce-
sando. La funci ´on hayEnemigosAl es la que se defini ´o en el ejercicio 3.3.3, y el
procedimiento CodificarDireccion se present ´o en la secci ´on de alternativa in-
dexada. Observar que la precondici ´on de hayEnemigosAl es que pueda moverse
en la direcci ´on suministrada como par ´ametro, y por lo tanto, no debe preguntarse
si hay enemigos hasta no saber que puede moverse en dicha direcci ´on.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 139 of 312 --

140
G.4.1. Guarda de bolitas verdes en cantidades pares
Actividad de Programaci ´on 5
Pruebe la funci ´on CodificarDireccionDelEnemigo en un programa, lue-
go de colocar convenientemente todos los procedimientos y funciones
necesarias y armar correctamente un procedimiento principal.
Otra detalle a observar en la repetici ´on indexada es que la forma b ´asica de la
misma utiliza todos rangos que inclu´ıan todos los n ´umeros entre 2 dados (por
ejemplo, de 1 a 10) de forma creciente, y como m ´axima complicaci ´on, hacer que
el rango dependiese de un par ´ametro, para poder modificar la cantidad (como
en el ejercicio 3.1.3). Sin embargo, a veces es necesario realizar repeticiones
que requieren secuencias de n ´umeros no consecutivos, e incluso secuencias
descendentes o arbitrarias.
Por ejemplo, uno puede querer realizar una guarda de bolitas que solo incluya
bolitas pares, como en el gr ´afico G.4.1. Observar que la guarda tiene 2 partes cla-
ramente diferenciadas: una parte creciente, con bolitas en cantidad par (2,4,6,8
y 10), y otra parte decreciente, tambi ´en con bolitas en cantidad par (10,8,6,4 y
2). ¿C ´omo podemos lograr esto mediante una repetici ´on indexada? GOBSTONES
provee una forma de variar el incremento al especificar un rango; para ello deben
escribirse los dos primeros elementos en lugar de solo el primero. Por ejemplo,
la parte creciente puede escribirse como sigue
foreach i in [2,4..10]
{ PonerN(i, Verde); Mover(Este) }
Observar que como la diferencia entre 4 y 2 es de 2, la secuencia especificada
ser ´a 2 4 6 8 10, como se deseaba. Para la segunda parte el n ´umero debe decre-
cer. Para lograr que una secuencia decrezca, el segundo valor debe ser menor
que el primero (y por supuesto, el valor final debe ser menor que el inicial). En-
tonces, la segunda parte quedar´ıa
foreach i in [10,8..2]
{ PonerN(i, Verde); Mover(Este) }
Una alternativa m ´as complicada, pero que muestra el poder de la matem ´atica al
programar, ser´ıa conservar los ´ındices creciendo de a uno, pero utilizar alguna
relaci ´on entre los n ´umeros 1,2,3,4 y 5, y los n ´umeros 2,4,6,8 y 10, primero, y los
n ´umeros 10,8,6,4 y 2, luego. En el primer caso, la relaci ´on es sencilla: al 1 le
corresponde el 2, al 2 le corresponde el 4, al 3, el 6. . . claramente al n ´umero i le
debe corresponder el n ´umero 2*i. Esto se expresa como:
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 140 of 312 --

141
foreach i in [1..5]
{ PonerN(2*i, Verde); Mover(Este) }
donde podemos observar que la cantidad de bolitas a poner responde a la f ´ormu-
la deducida. Para clarificar la forma en que la f ´ormula establece la corresponden-
cia, podemos usar la siguiente tabla:
i 1 2 3 4 5
2*i 2*1 2*2 2*3 2*4 2*5
= 2 4 6 8 10
Para la segunda relaci ´on, vemos que la relaci ´on es inversa, porque el n ´umero
debe decrecer. Para lograr que una secuencia decrezca, podemos restar una
secuencia creciente a partir de un n ´umero fijo. Si pensamos en la secuencia
de pares calculada primero, y queremos darla vuelta, deber´ıamos pensar una
f ´ormula que permita obtener un 10 a partir de un 2, un 8 a partir de un 4, un 6 a
partir de un 6, etc ´etera. Esto se puede obtener restando 12-(2*i). Nuevamen-
te, una tabla puede ayudar a clarificar la forma en que la f ´ormula establece la
correspondencia:
i 1 2 3 4 5
2*i 2 4 6 8 10
12-(2*i) 12-2 12-4 12-6 12-8 12-10
= 10 8 6 4 2
Estas formas no es necesario aprenderlas en un lenguaje donde los rangos pue-
den variar distinto que de a uno, pero resulta imprescindible para otros lenguajes
donde esta facilidad no existe.
Actividad de Programaci ´on 6
Realice el ejercicio 4.2.1, usando las ideas explicadas hasta aqu´ı y ob-
tenga una guarda como la del gr ´afico G.4.1. H ´agalo con la variante de
rango con variaci ´on distinta de uno y con la variante que usa f ´ormulas.
Ejercicio 4.2.1. Escribir un procedimiento GuardaDePares, que permita realizar
una guarda de bolitas verdes similar a la del gr ´afico G.4.1. Utilizar dos repeticio-
nes indexadas, una creciente y otra decreciente.
Resumiendo lo analizado hasta aqu´ı, podemos obtener secuencias regulares que
no sean crecientes o de a uno a trav ´es de dos maneras: rangos especiales o
f ´ormulas aplicadas a los ´ındices. En el caso de las f ´ormulas, para secuencias
con incrementos mayores a uno se utilizan multiplicaciones; para secuencias de-
crecientes, se resta una secuencia creciente a un tope dado.
Para Reflexionar
Si en alg ´un lenguaje las repeticiones indexadas son siempre de uno en
uno, pueden obtenerse otras secuencias a partir del uso de f ´ormulas.
Aunque este curso no hace uso de una matem ´atica intensiva, reflexione
sobre la importancia de tener un buen manejo matem ´atico y num ´erico
para realizar programas m ´as complejos. Piense en las facilidades que
podr´ıan proveer los lenguajes para simplificar la matem ´atica necesaria.
Mediante estas repeticiones indexadas con diferentes secuencias podemos revi-
sar algunos de los ejercicios vistos en el cap´ıtulo 2.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 141 of 312 --

142
G.4.2. Resultado de invocar DibujarTrianguloBase(8) (sin cumplir la precondi-
ci ´on): observar que no es exactamente un tri ´angulo
Actividad de Programaci ´on 7
Realice los ejercicios 4.2.2 y 4.2.3, y verifique que obtienen los mismos
resultados que los originales que mejoran.
Ejercicio 4.2.2. Rehacer el ejercicio 2.4.12 para generalizar el tama ˜no de la ba-
se del tri ´angulo. Observar que se requiere como precondici ´on que el tama ˜no de la
base sea un n ´umero impar. Completar la precondici ´on con la cantidad de celdas
que debe haber disponibles para el dibujo.
Leer con Atenci ´on
Hasta el momento hab´ıamos visto ejemplos donde la precondici ´on indi-
caba los requisitos necesarios para que el programa no se autodestruye-
se. Sin embargo, las precondiciones se usan en general para establecer
los requisitos necesarios para que el programa funcione como se espe-
ra. De esta manera, no es siempre necesario que si la precondici ´on no
se cumple, el programa debe autodestruirse; muchas veces el progra-
ma parece funcionar, pero hace cosas que no son lo que se esperaba
del mismo (como dibujar de forma incompleta una figura). Esta forma
de utilizar precondiciones ofrece gran flexibilidad a la hora de dise ˜nar
procedimientos y ayuda a evitar controles innecesarios de condiciones.
En el caso del tri ´angulo, seg ´un la soluci ´on que uno adopte, al invocar el proce-
dimiento con un n ´umero par (o sea, no cumpliendo la precondici ´on), el dibujo no
resultar ´a en un tri ´angulo. Por ejemplo, en la soluci ´on que pensamos nosotros, al
invocar DibujarTrianguloBase(8) queda un dibujo como el que mostramos en
el gr ´afico G.4.2, que no es exactamente un tri ´angulo de base 8, sino uno de base
7 con una “pata”.
Ejercicio 4.2.3. Rehacer el ejercicio 2.4.13 utilizando una repetici ´on de 1 a 3.
Hacerlo utilizando un rango con incremento distinto de uno y tambi ´en con una
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 142 of 312 --

143
f ´ormula. Observar que los n ´umeros impares obedecen, en este caso, a la f ´ormula
(2 ∗ i + 3), siendo i el ´ındice de la repetici ´on, y que si uno los quiere en orden
inverso, debe restarlos del tope de 14.
Leer con Atenci ´on
Se pueden conseguir f ´ormulas mucho m ´as complejas que permitan ob-
tener secuencias no regulares a trav ´es del uso de funciones que calcu-
len los resultados esperados, por ejemplo, una secuencia de n ´umeros
primos, o secuencias con pasos variables en distintas partes, etc ´etera.
Para el caso en que la secuencia de elementos no sea regular, donde no es
simple expresarlas mediante f ´ormulas lo suficientemente generales, GOBSTO-
NES provee una forma de especificar la secuencia enumerando cada uno de los
elementos. Para hacer esto, sencillamente escribimos los elementos entre lla-
ves y separados por comas. Por ejemplo, la secuencia 4 8 15 16 23 42 puede
especificarse como [4, 8, 15, 16, 23, 42].
4.2.2. Repetici ´on condicional
Sabemos que la repetici ´on indexada repite un bloque de c ´odigo un n ´umero fijo
de veces, cantidad que es controlada por una secuencia de valores. Ahora bien,
¿qu ´e debemos hacer si no conocemos de antemano la cantidad de veces que
debemos repetir un comando? Por ejemplo, imaginemos que queremos mover-
nos hasta el borde del tablero. ¡Puesto que no tenemos en GOBSTONES forma
de conocer las dimensiones del mismo, no hay manera de saber cu ´antas veces
debemos movernos! Situaciones similares a esta se presentan numerosas ve-
ces. Considerar por ejemplo que cuando uno busca sus llaves repite la acci ´on de
buscar en lugares, pero no sabe de antemano en cu ´antos lugares debe buscar.
Actividad 8
Considere realizar un procedimiento que lleve el cabezal hasta el borde
del tablero, pero sin utilizar el comando IrAlBorde. La soluci ´on deber´ıa
involucrar una repetici ´on del comando Mover, pero, como la posici ´on ini-
cial del cabezal es arbitraria, ¡no sabemos cu ´antas celdas debemos mo-
vernos! Piense de qu ´e otras maneras podr´ıa realizar esto en GOBSTO-
NES con los elementos presentados hasta el momento. (Atenci ´on: no
hay forma de hacerlo con esos elementos. La idea de la actividad es
pensar alternativas hasta convencerse de que efectivamente ninguno de
los elementos vistos hasta ahora (salvo el comando primitivo que lo hace
de manera predefinida) sirve para esa tarea.)
Claramente no se trata de adivinar una cantidad, sino de proveer alguna herra-
mienta que permita realizar una repetici ´on controlada de otra forma, y no me-
diante un ´ındice. Esta forma se denomina repetici ´on condicional, pues la misma
permite repetir un comando un n ´umero arbitrario de veces, dependiendo de que
una condici ´on se cumpla o no. El comando para describir una repetici ´on condi-
cional es llamado while, que en ingl ´es significa “mientras”, para marcar que el
bloque a repetir ser ´a iterado mientras se cumpla cierta condici ´on. La forma de
este comando se establece en la siguiente definici ´on:
Definici ´on 4.2.1. La repetici ´on condicional es una forma de repetici ´on que de-
pende de una condici ´on booleana para indicar cu ´ando debe cesar de iterarse. La
forma del comando que describe esta repetici ´on es
while (< condicion >)
< bloque >
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 143 of 312 --

144
donde < condicion > es una expresi ´on booleana y < bloque > un bloque cualquie-
ra al que se denomina cuerpo de la repetici ´on.
El efecto del comando while es la repetici ´on del comando descrito por < bloque >
mientras la < condicion > sea verdadera. Para obtener este efecto, la ejecuci ´on
del comando comienza evaluando la < condici ´on > en el estado actual. Si esta
evaluaci ´on resulta verdadera (o sea, la expresi ´on < condicion > eval ´ua a True), se
realiza una iteraci ´on del comando descrito por el < bloque >, y a continuaci ´on se
vuelve a evaluar la condici ´on. Esto ´ultimo se repite hasta tanto la condici ´on resulte
falsa, en cuyo caso termina la ejecuci ´on del comando. Observar que es necesario
que el bloque del cuerpo altere el estado de tal manera que la condici ´on llegue a
resultar falsa en alg ´un momento.
Leer con Atenci ´on
En la repetici ´on indexada, la cantidad de repeticiones se conoce de an-
temano, por lo que no hace falta controlar el final en cada iteraci ´on. En
cambio, en la repetici ´on condicional, la condici ´on puede volverse falsa
luego de cualquiera de las iteraciones, pero no se sabe anticipadamen-
te de cu ´al de ellas. Por eso en esta forma de repetici ´on la condici ´on se
eval ´ua cada vez.
La repetici ´on condicional es ´util cuando se trata de realizar una tarea repetitiva
de la que no se sabe a priori cu ´antas veces debe repetirse (o sea, no se puede
generar una secuencia sobre la cual realizar la iteraci ´on). El ejemplo m ´as sencillo
de uso de repetici ´on condicional es llevar el cabezal hasta un borde del tablero,
como se propuso pensar en la actividad del inicio de esta secci ´on. El siguiente
c ´odigo lleva el cabezal hasta el borde superior:
procedure CabezalAlTopeDeLaColumna()