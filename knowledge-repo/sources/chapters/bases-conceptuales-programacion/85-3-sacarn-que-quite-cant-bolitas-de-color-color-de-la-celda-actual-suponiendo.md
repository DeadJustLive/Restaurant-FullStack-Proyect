# 3. SacarN que quite cant bolitas de color color de la celda actual, suponiendo

que cant es un n ´umero positivo. ¿Cu ´al es su precondici ´on?
Leer con Atenci ´on
Los procedimientos PonerN, MoverN y SacarN son excelentes candidatos
para ser colocados en la Biblioteca.
Actividad de Programaci ´on 6
Realice los ejercicios 3.1.4 y 3.1.5 y pru ´ebelos adecuadamente. No olvi-
de escribir el prop ´osito y las precondiciones de los procedimientos invo-
lucrados.
Ejercicio 3.1.4. Escribir un procedimiento DibujarLineaVerticalRoja que da-
da una cantidad cant, dibuje una l´ınea vertical de bolitas rojas desde la celda
actual hacia el norte, y retorne el cabezal a la posici ´on inicial.
Ayuda: es necesario utilizar una repetici ´on para dibujar y otra diferente para
volver a la posici ´on inicial.
Ejercicio 3.1.5. Escribir un procedimiento DibujarCuadradoSolido5 que dada
una cantidad cant, dibuje un cuadrado s ´olido rojo de cant bolitas de lado (o sea,
no solo el per´ımetro, sino toda la superficie del cuadrado) hacia el norte y el este,
y retorne el cabezal a la posici ´on inicial.
Ayuda: utilizar el procedimiento del ejercicio anterior para dibujar cada una
de las barras verticales del cuadrado mediante una repetici ´on, y otra repetici ´on
para volver.
Para Reflexionar
Al parametrizar direcciones o colores expresamos 4 procedimientos sim-
ples en uno parametrizado. Sin embargo, al parametrizar cantidades es-
tamos expresando una cantidad infinita de procedimientos simples con
uno solo. Reflexione sobre la necesidad de la repetici ´on para conseguir
esto, y sobre las limitaciones que impondr´ıa el lenguaje de programa-
ci ´on si no cont ´asemos con la misma. Cuando decimos que al aprender
a programar debemos concentrarnos en ideas importantes nos estamos
refiriendo exactamente a este tipo de imprescindibilidad.
Repetici ´on indexada
La repetici ´on, en combinaci ´on con los par ´ametros, es una forma poderosa de
aumentar la expresividad del lenguaje, y ser capaces de escribir pocas l´ıneas de
c ´odigo para lograr muchas variaciones. Sin embargo, hay variaciones que la for-
ma simple de la repetici ´on no permite. Por ejemplo, si en lugar de un rect ´angulo
s ´olido como en el ejercicio 3.1.5, quisi ´eramos dibujar un tri ´angulo s ´olido como el
del gr ´afico G.3.6, dibujando cada una de las barras verticales, no ser´ıa posible
hacerlo con repetici ´on simple, ¡pues la longitud de cada barra vertical es dife-
rente! Est ´a claro que precisamos alguna forma m ´as poderosa de la repetici ´on,
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 101 of 312 --

102
G.3.6. Tri ´angulo rect ´angulo a dibujar por barras verticales
que nos permita utilizar un valor diferente cada vez que se repite el comando
indicado.
La repetici ´on indexada es una forma de repetici ´on que considera una secuen-
cia de valores, y repite un cierto comando una vez por cada elemento de ella.
Esta secuencia puede determinarse a partir de un rango de valores (especifica-
do a trav ´es de dos valores, un valor inicial y un valor final) y comprende todos
los valores que se encuentren entre el inicial y el final del rango, inclu´ıdos ellos.
Por ejemplo, el rango [1..10] determina la secuencia que contiene los valores 1
2 3 4 5 6 7 8 9 10; en cambio el rango [12..17] determina la secuencia que
contiene los valores 12 13 14 15 16 17.
Definici ´on 3.1.6. Un rango de valores es una secuencia de valores crecientes
comprendidas entre un valor inicial y un valor final, incluyendo a estos dos. La
forma de escribir un rango es
[< inicioRango >..< finRango >],
donde < inicioRango > establece el valor inicial y < finRango > establece el valor
final.
Mediante el uso de rangos y utilizando el comando foreach, podemos hacer
ahora una repetici ´on indexada. Por ejemplo, para dibujar tri ´angulos s ´olidos como
el visto antes usar´ıamos el siguiente comando
foreach cant in [1..5]
{
DibujarLineaVerticalRoja(cant)
Mover(Este)
}
Observar que esta forma de repetici ´on indica un secuencia de valores mediante
un rango, y adem ´as un nombre (cant en el ejemplo), que en cada repetici ´on
tomar ´a el valor del elemento de la secuencia para el que se est ´a repitiendo en ese
momento. A este nombre se lo conoce con el nombre de ´ındice y de ah´ı la forma
de denominar a este comando. El ´ındice nombrar ´a cada uno de los valores de la
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 102 of 312 --

103
secuencia en cada repetici ´on; o sea, en la primera repetici ´on cant nombrar ´a al 1,
en la segunda repetici ´on cant nombrar ´a al 2, etc.; por eso el comando se llama
foreach. As´ı, el c ´odigo anterior ser´ıa equivalente a haber escrito
En ingl ´es, for each significa para
cada uno. El comando entonces
se podr´ıa leer como “para cada
uno de los cant que est ´an en el
rango [1..5], realizar el comando
indicado”.
DibujarLineaVerticalRoja(1)
Mover(Este)
DibujarLineaVerticalRoja(2)
Mover(Este)
DibujarLineaVerticalRoja(3)
Mover(Este)
DibujarLineaVerticalRoja(4)
Mover(Este)
DibujarLineaVerticalRoja(5)
Mover(Este)
puesto que la secuencia dada por el rango [1..5] est ´a compuesta por los valores
1 2 3 4 5.
Definici ´on 3.1.7. El comando de repetici ´on indexada permite repetir una acci ´on
un cierto n ´umero de veces, siendo esta cantidad indicada por un ´ındice que var´ıa
dentro de una cierta secuencia de valores. El comando foreach que permite la
repetici ´on indexada tiene la siguiente forma:
foreach < indexName > in < rango >
< bloque >
siendo < indexName > un identificador con min ´uscula que nombra al ´ındice de
la repetici ´on, < rango > el rango de valores que describe a la secuencia sobre la
que variar ´a dicho ´ındice, y < bloque > un bloque cualquiera que se repetir ´a.
El efecto de un comando de repetici ´on indexada es que la acci ´on descrita por el
bloque < bloque > se repetir ´a tantas veces como valores haya en la secuencia, y
de tal manera que en cada repetici ´on el ´ındice representar ´a a un valor diferente.
El nombre de un ´ındice puede utilizarse en cualquier lugar donde se habr´ıa utili-
zado el valor que el mismo describe; por esta raz ´on, el uso de un ´ındice es una
expresi ´on que sirve para describir un valor que var´ıa de una forma fija durante
las repeticiones.
El comando de repetici ´on simple puede obtenerse como una forma simplifi-
cada del comando de repetici ´on indexada, simplemente haciendo que el bloque
ignore el valor del ´ındice. As´ı, en lugar de escribir
repeat(10) { Poner(Rojo) }
podr´ıa haberse escrito
forach i in [1..10] { Poner(Rojo) }
ya que el bloque no utiliza para nada el ´ındice i. Tambi ´en podr´ıa haberse escrito
foreach i in [17..26] { Poner(Rojo) }
pues la secuencia dada por este otro rango, aunque tiene diferentes valores, tiene
la misma cantidad de elementos que el anterior.
Para Reflexionar
¿Por qu ´e entonces har ´a falta tener ambas formas de repetici ´on? La
cuesti ´on es la simplicidad conceptual, y asociado a esto, la gradualidad
did ´actica. El concepto de repetici ´on no tiene asociado necesariamente
un ´ındice, y existen muchas formas de poner 10 bolitas utilizando re-
petici ´on indexada. Reflexionar sobre la importancia de la claridad y la
simplicidad de los conceptos impartidos en un curso inicial.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 103 of 312 --

104
(a). Tablero a producir como resultado. (b). Tablero a producir como variante.
G.3.7. Tableros a producir en el ejercicio 3.1.6
Una caracter´ıstica particular de los rangos es que siempre determinan se-
cuencias crecientes; o sea, el valor inicial debe ser menor o igual que el valor
final para que la secuencia tenga elementos, y el incremento por el momento es
Veremos en el pr ´oximo cap´ıtu-
lo como permitir variaciones co-
mo incrementos diferentes de 1,
o rangos decrecientes.
siempre 1. Si el valor inicial es mayor que el final, la secuencia es vac´ıa y el
comando de repetici ´on no realiza ninguna acci ´on. Por ejemplo, el siguiente co-
mando no tiene ning ´un efecto:
foreach i in [10..1]
{ DibujarLineaVerticalRoja(i) }
puesto que el rango 10..1 describe a la secuencia vac´ıa (no tiene elementos),
ya que el valor inicial, 10, es mayor que el valor final, 1.
Actividad de Programaci ´on 7
Realizar el ejercicio 3.1.6. Utilizarlo para obtener en el tablero final la
configuraci ´on de bolitas del gr ´afico G.3.7a.
Ayuda: observe que cada fila del dibujo puede ser generada usando
una instancia particular del procedimiento Progresion, utilizando los ar-
gumentos adecuados.
Ejercicio 3.1.6. Escribir un procedimiento Progresion que dados un n ´umero n
y una direcci ´on dir, coloque 1 bolita roja en la celda actual, 2 bolitas rojas en la
celda lindante en la direcci ´on dir, 3 en la siguiente, etc. repitiendo esto n veces
y dejando el cabezal en la celda siguiente a la ´ultima ocupada.
Actividad de Programaci ´on 8
¿Qu ´e tendr´ıa que cambiarse en el procedimiento Progresion de la acti-
vidad anterior para obtener la configuraci ´on del gr ´afico G.3.7b sin cam-
biar el programa principal?
Los rangos de una repetici ´on indexada no se limitan a n ´umeros. Tambi ´en pueden
ser colores, direcciones o booleanos. El orden de las direcciones es en el senti-
do de las agujas del reloj, comenzando por el Norte, el orden de los colores es
alfab ´etico, y el de los booleanos es primero falso y luego verdadero. El orden en
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 104 of 312 --

105
cada caso es importante para saber qu ´e rango corresponde a cada par de valo-
res. Por ejemplo, el procedimiento para dibujar un cuadrado negro de 3 celdas de
lado puede escribirse de la siguiente manera:
procedure DibujarCuadradoNegro3()
{-