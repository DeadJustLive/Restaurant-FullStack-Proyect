# 10. Dise˜ne un algoritmos con funciones y procedimientos que indique

## Fuente
logica-de-programacion (Cap. 159)

## Contenido
# 10. Dise˜ne un algoritmos con funciones y procedimientos que indique

si un n´umero entero x se encuentra por dentro o por fuera de tres
intervalos abierto-abierto cuyo rangos no se interceptan entre s´ı y sus
l´ımites son ingresados por el usuario.

-- 350 of 450 --

Cap´ıtulo 6
Vectores y matrices
La mejor forma de predecir el
futuro es implementarlo
David Heinemeier Hansson
Objetivos del cap´ıtulo:
Aprender a declarar e inicializar vectores y
matrices.
Conocer la forma de leer e imprimir los
elementos almacenados en vectores y matrices.
Construir algoritmos para buscar elementos en
vectores y matrices.
Realizar operaciones b´asicas con varios
vectores y matrices.

-- 351 of 450 --



-- 352 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 351
En los cap´ıtulos anteriores se ha trabajado con variables que almacenan
solamente un dato a la vez. Esto quiere decir que, si se asigna un valor a
la variable y, posteriormente se asigna otro valor, el primer valor se pierde.
Este tipo de variables reciben el nombre de Variables escalares.
Sin embargo, en muchos problemas de l´ogica de programaci´on existe la
necesidad de almacenar muchos datos del mismo tipo como, por ejemplo,
las estaturas de 50 personas, las edades de los 30 estudiantes de un
grupo o el peso de 40 pacientes de una cl´ınica. Una soluci´on para estos
problemas ser´ıa declarar 50 variables para almacenar las estaturas, 30
variables para las edades y 40 para los pesos, sin embargo, esto es poco
pr´actico. Para este tipo de problemas, existen unas variables denominadas
Variables suscritas que almacenan el lugar (referencia) en donde se
crearon m´ultiples espacios o celdas de memoria que pueden ser usados
para guardar y recuperar datos (llamado Arreglo).
Un arreglo es entonces, un conjunto de espacios o celdas de memoria
donde se pueden almacenar temporalmente muchos datos siempre y cuando
sean del mismo tipo. De esta forma y, regresando al caso de tener la
necesidad de guardar en un algoritmo 50 estaturas del mismo n´umero de
personas, se podr´ıan declarar 50 variables distintas o, sencillamente, una
variable suscrita que referencia a un arreglo de 50 posiciones.
Existen varios tipos de arreglos, a saber: arreglos unidimensionales
tambi´en conocidos como Vectores, los arreglos bidimensionales o
Matrices y los arreglos multidimensionales. Todo arreglo requiere de una
variable suscrita para poder acceder a sus datos y todos ellos son del mismo
tipo, el cual debe coincidir con el tipo de dato de la variable suscrita. El
vector funciona como una fila en la cual se ubican los datos desde la primera
celda hasta la ´ultima. Las matrices son similares, pero con la diferencia de
que trabajan como una tabla de celdas con varias filas y columnas, es decir,
que ocupa dos dimensiones; los arreglos multidimensionales, por su parte,
funcionan con celdas que ocupan espacios en m´as de dos dimensiones.
6.1. Vectores
Los vectores son conjuntos finitos de celdas que permiten almacenar
datos del mismo tipo, de acuerdo a como se haya declarado. Para facilitar
su comprensi´on, gr´aficamente un arreglo unidimensional se observa como
una fila donde cada celda corresponde a un espacio de memoria en el que
se puede ubicar un dato. Cada celda o espacio de memoria es identificado

-- 353 of 450 --

352 Vectores y matrices
con un n´umero llamado ´ındice. En la Figura 6.1 se puede ver un vector de
10 posiciones:
celdas del arreglo
1 2 3 4 5 6 7 8 9 10 ´ındice de cada posici´on
Figura 6.1: Diagrama de un Vector
Los ´ındices empiezan en uno1, aunque existen lenguajes de programaci´on
en que empiezan en cero, y son n´umeros enteros. El ´ultimo n´umero ´ındice
representa no solo a la ´ultima celda, sino tambi´en el tama˜no del arreglo2, es
decir, el n´umero de celdas que posee. Aunque normalmente los ´ındices son
n´umeros positivos, existen lenguajes como Python que soportan n´umeros
negativos, los cuales se interpretan como moverse en sentido contrario, es
decir, el ´ındice -1 representa la ´ultima posici´on. Este tipo de ´ındices no
ser´a utilizado en este libro.
6.1.1 Declaraci´on de un vector
Con el fin de poder utilizar un vector (o arreglo en general) de cualquier
tipo dentro de un algoritmo, se requiere el uso de una variable suscrita que
lo referencie. Una variable suscrita se diferencia de las dem´as por tener en
su declaraci´on los s´ımbolos corchetes [ ].
Entero edadEstudiante [ ]
Real estaturaPersona[ ]
Cadena nombreEmpleado [ ]
Caracter letrasDocumento[ ]
Es importante aclarar que, luego de declarar la variable suscrita, se debe
especificar el tama˜no del vector; esto permitir´a determinar la cantidad de
celdas, casillas o espacios de memoria que tendr´a el vector. Lo anterior se
puede hacer de dos maneras: usando la funci´on llamada dimensionar()
(esta funci´on es propia del libro, cada lenguaje tiene su forma particular
de crear los arreglos), o en el momento de declarar la variable suscrita.
1En algunos lenguajes de programaci´on como por ejemplo C y Java, 
