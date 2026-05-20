# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 26)

## Contenido
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
Ejercicio 4.2.
