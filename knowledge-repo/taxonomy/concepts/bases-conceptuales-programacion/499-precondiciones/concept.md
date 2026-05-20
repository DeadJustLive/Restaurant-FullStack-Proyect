# PRECONDICIONES:

## Fuente
bases-conceptuales-programacion (Cap. 499)

## Contenido
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
par ´ametro en la definici ´on de Dibujar
