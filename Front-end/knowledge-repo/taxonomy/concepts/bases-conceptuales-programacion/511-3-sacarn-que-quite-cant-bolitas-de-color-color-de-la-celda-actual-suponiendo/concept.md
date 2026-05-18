# 3. SacarN que quite cant bolitas de color color de la celda actual, suponiendo

## Fuente
bases-conceptuales-programacion (Cap. 511)

## Contenido
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
DibujarL
