# PRECONDICIONES:

* hay 2 celdas al Norte y 2 celdas al Este de la actual
*/
{
Poner(colorDelCuadrado); Mover(Norte)
Poner(colorDelCuadrado); Mover(Norte)
Poner(colorDelCuadrado); Mover(Este)
Poner(colorDelCuadrado); Mover(Este)
Poner(colorDelCuadrado); Mover(Sur)
Poner(colorDelCuadrado); Mover(Sur)
Poner(colorDelCuadrado); Mover(Oeste)
Poner(colorDelCuadrado); Mover(Oeste)
}
Observar que en cada lugar donde aparec´ıa el agujero en el gr ´afico G.3.3 ahora
aparece el nombre colorDelCuadrado. Adem ´as, el nombre colorDelCuadrado
tambi ´en aparece mencionado en el encabezado del procedimiento; esto indica
que este procedimiento tiene un agujero con ese nombre, y provee la forma me-
diante la cual luego el agujero puede ser rellenado con un valor.
El agujero que nombramos mediante un par ´ametro debe ser siempre relle-
nado con un valor. As´ı, un par ´ametro es un nombre que denota un valor (el que
rellena el agujero), el cual cambia en cada llamado al procedimiento (pues el
valor usado puede cambiar en cada llamado). La forma de indicar que el proce-
dimiento tiene un par ´ametro es utilizar un identificador entre par ´entesis luego del
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 92 of 312 --

93
G.3.4. Relaci ´on entre los procedimientos de dibujar cuadrados y un esquema de
procedimiento (o “procedimiento con agujero”)
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 93 of 312 --

94
nombre del procedimiento. Ese identificador puede luego ser utilizado dentro del
bloque que define el procedimiento como si de un valor fijo se tratase; al utilizar-
lo es como si hubi ´esemos llenado el agujero nombrado por el par ´ametro con el
valor espec´ıfico. En un procedimiento puede incluirse m ´as de un agujero, o sea,
puede haber m ´as de un par ´ametro.
Definici ´on 3.1.1. Un par ´ametro es un identificador que denota a un valor que
puede ser diferente en cada invocaci ´on de un procedimiento. La forma de definir
procedimientos con par ´ametros es
procedure < procName >(< params >)
< bloque >
donde < params > es una lista de identificadores separados por comas. Los iden-
tificadores usados como par ´ametros deben comenzar con min ´uscula.
Los nombres de los par ´ametros pueden ser usados en los mismos lugares que
las expresiones que reemplazan. Por esta raz ´on, la utilizaci ´on de un par ´ametro
es una forma de expresi ´on que sirve para describir un valor que no se conoce.
Al igual que con la definici ´on de un procedimiento simple, al definir un proce-
dimiento con par ´ametros estamos agregando un nuevo comando al lenguaje. En
este caso, el nuevo comando ser ´a DibujarCuadradoDeLado3DeColor(< color >);
o sea, al invocarlo debemos suministrar un color espec´ıfico para dibujar. Enton-
ces, podremos escribir el programa que dibuja un cuadrado negro y uno rojo
como
program
{
VaciarTablero(); IrAlOrigen()
DibujarCuadradoDeLado3DeColor(Negro)
IrAlBorde(Este); Mover(Oeste); Mover(Oeste)
DibujarCuadradoDeLado3DeColor(Rojo)
}
Observar como se usan los comandos DibujarCuadradoDeLado3DeColor(Negro)
y DibujarCuadradoDeLado3DeColor(Rojo). Tener en cuenta que en el archivo
del programa tambi ´en debe colocarse la definici ´on del procedimiento procedure
DibujarCuadradoDeLado3DeColor(colorDelCuadrado).
Al utilizar un procedimiento como un nuevo comando debemos suministrar un
valor para el par ´ametro, ya que el par ´ametro por s´ı solo no tiene sentido (pues
representa a un “agujero”). Este valor concreto usado en la invocaci ´on recibe el
nombre de argumento.
Definici ´on 3.1.2. Un argumento es el valor espec´ıfico usado en la invocaci ´on de
un procedimiento con par ´ametros.
Definici ´on 3.1.3. Un procedimiento definido por el programador puede ser utili-
zado como comando, de la siguiente forma
< procName >(< args >)
donde < args > es una lista de valores espec´ıficos (los argumentos) para los
par ´ametros.
Llamaremos invocaci ´on de un procedimiento al uso del mismo como un comando
nuevo. El argumento aparece entre par ´entesis al invocar un procedimiento con
par ´ametros como comando. Esta es la forma de indicar que el valor del argu-
mento debe ser utilizado en el lugar donde se coloc ´o el agujero nombrado por el
par ´ametro. Este proceso se ilustra en el gr ´afico G.3.5.
Puede verse que es m ´as conveniente escribir un solo procedimiento para di-
bujar el cuadrado que reciba el color como par ´ametro, ya que entonces en el
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 94 of 312 --

95
G.3.5. Programa que dibuja un cuadrado negro y uno rojo con un ´unico procedi-
miento parametrizado para dibujar el cuadrado
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 95 of 312 --

96
programa principal podemos utilizar el mismo comando para dibujar cuadrados
de dos colores diferentes, evitando la repetici ´on del c ´odigo de dibujar cuadra-
dos solo para tener diferentes colores. Observar que colorDelCuadrado es el
par ´ametro en la definici ´on de DibujarCuadradoDeLado3DeColor y se lo utiliza
en el comando Poner(colorDelCuadrado); el nombre utilizado no es importan-
te, pero debe indicar de alguna manera (por cuestiones de estilo) la intenci ´on
de para qu ´e se utilizar ´a el par ´ametro. Al invocar el procedimiento param ´etrico
DibujarCuadradoDeLado3DeColor se utiliza un valor espec´ıfico de color como
argumento en cada caso. ¡El c ´odigo final es equivalente al c ´odigo original, pero
que define solo un procedimiento, en lugar de cuatro!
El mecanismo utilizado para esta definici ´on, llamado abstracci ´on, consiste en
concentrarse en las similaridades entre diferentes elementos, reconoci ´endolos
como casos particulares de una misma idea. El uso de par ´ametros permite iden-
tificar en qu ´e partes son diferentes los elementos, y el proceso de invocaci ´on
de un procedimiento con argumentos (valores espec´ıficos para los par ´ametros)
permite obtener los elementos particulares a partir de la definici ´on general. Este
caso particular de abstracci ´on se conoce con el nombre de parametrizaci ´on, por
el uso de par ´ametros para representar las variaciones de una misma idea. Al uso
de parametrizaci ´on para expresar varios procedimientos simples mediante uno
parametrizado se lo denomina tambi ´en generalizaci ´on, pues el procediminento
parametrizado es m ´as general que los casos individuales.
¿Qu ´e otras nociones son generalizables en el caso de dibujar un cuadrado?
Otra noci ´on generalizable en este caso es el tama ˜no del cuadrado. Sin embar-
go, para poder generalizarla son necesarios comandos m ´as complejos, por lo
cual esta idea se tratar ´a luego de presentar dichos comandos, en la subsecci ´on
siguiente.
Hay una noci ´on m ´as que resulta generalizable, y tiene que ver con los visto
en la secci ´on 2.2.9: es mejor dibujar el cuadrado con procedimientos que dibujen
l´ıneas. Para ver como aprovechar esta idea, volveremos moment ´aneamente al
ejemplo de dibujar un cuadrado exclusivamente negro (sin parametrizar el color).
En ese ejemplo utilizamos procedimientos
DibujarLineaNegra2HaciaElNorte,
DibujarLineaNegra2HaciaElEste,
DibujarLineaNegra2HaciaElSur y
DibujarLineaNegra2HaciaElOeste.
para dibujar l´ıneas. Podemos observar en estos procedimientos el mismo patr ´on
de repetici ´on que vimos en el caso del cuadrado: ¡los procedimientos solo difieren
en la direcci ´on en la que deben moverse! Ac ´a tenemos un candidato para utilizar
parametrizaci ´on.
Actividad de Programaci ´on 2
Realice el ejercicio 3.1.1 y utilice dicho procedimiento para dibujar dos
cuadrados negros de lado 3.
Ejercicio 3.1.1. Escribir un procedimiento DibujarCuadradoNegro3 similar al rea-
lizado en el ejercicio 2.2.8, pero utilizando un ´unico procedimiento parametrizado
para dibujar l´ıneas. Observar que en este caso lo que debe parametrizarse es la
direcci ´on.
El resultado deber´ıa contener un programa principal, un procedimiento para di-
bujar el cuadrado, y un ´unico procedimiento parametrizado para dibujar l´ıneas. El
procedimiento para dibujar el cuadrado deber´ıa realizar 4 invocaciones al proce-
dimiento de dibujar l´ıneas con diferentes argumentos (de direcci ´on en este caso).
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 96 of 312 --

97
Para Reflexionar
¿Qu ´e nombre utiliz ´o para el procedimiento de dibujar l´ıneas? ¿Y para el
par ´ametro de direcci ´on?
Si utiliz ´o un nombre como DibujarLineaNegra2HaciaEl para el proce-
dimiento y direccionDeLinea o dirDeLinea para el par ´ametro significa
que viene entendiendo las nociones impartidas hasta el momento. Si en
cambio utiliz ´o un nombre poco significativo, deber´ıa volver a revisar la
subsecci ´on 2.3.2 que explica la importancia de un buen estilo al elegir
nombres y reflexionar sobre lo que all´ı explica.
En el caso de las l´ıneas, adem ´as de parametrizar la direcci ´on, podr´ıamos tambi ´en
parametrizar el color. Ello es posible porque un procedimiento puede tener m ´as
de un par ´ametro. En este caso, el procedimiento para dibujar l´ıneas quedar´ıa as´ı
procedure DibujarLinea2Hacia(colorDeLinea, dirDeLinea)
/*