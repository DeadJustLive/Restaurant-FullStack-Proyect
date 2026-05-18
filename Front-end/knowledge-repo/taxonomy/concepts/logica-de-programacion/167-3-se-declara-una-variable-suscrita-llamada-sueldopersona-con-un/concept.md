# 3. Se declara una variable suscrita llamada sueldoPersona con un

## Fuente
logica-de-programacion (Cap. 167)

## Contenido
# 3. Se declara una variable suscrita llamada sueldoPersona con un

tama˜no de 100 posiciones para datos de tipo Real. (Ver Figura 6.8).
Real sueldoPersona [ 100 ]
sueldoPersona -> . . .
1 2 3 . . . 99 100
Figura 6.8: Vector sueldoPersona

-- 357 of 450 --

356 Vectores y matrices
En los anteriores casos, se declar´o la variable suscrita y tambi´en se
especific´o su tama˜no. Realizar este tipo de declaraci´on y especificaci´on
de tama˜no es ´util cuando se tiene certeza del tama˜no requerido del vector.
Es de anotar que, en la mayor´ıa de los ejercicios que se analizan m´as
adelante, se utiliza la funci´on dimensionar() ya que, en ellos, ser´a el
usuario quien determinar´a el tama˜no que m´as le convenga en el momento
de la ejecuci´on del algoritmo.
Buena pr´actica:
Antes de intentar leer el contenido de un vector (o
arreglo en general), debe haber certeza de que ya se
ha almacenado previamente informaci´on en ´el.
Los vectores, una vez creados tienen disponibles un
cierto n´umero de casillas y cada una de ellas tiene un potencial dato
almacenado. En algunos lenguajes de programaci´on, por ejemplo
Java, el contenido inicial siempre se conoce por definici´on; sin
embargo, otros lenguajes como C y en especial en este libro, no se
da ninguna certeza del valor inicial, por tanto es una buena pr´actica
estar seguros del contenido de las casillas del vector antes de intentar
usar su contenido. La informaci´on almacenada en este ´ultimo caso
se denomina “Informaci´on basura”.
Para terminar, es importante decir que no es posible eliminar o insertar
celdas en un arreglo, tal y como sucede en lenguajes como C y Java. Existen
otras estructuras de almacenamiento que est´an por fuera del alcance del
libro que s´ı permiten este tipo de operaciones, como por ejemplo las listas.
6.1.2 Almacenamiento de datos en un vector
Al almacenar datos en un vector, se debe tener en cuenta que el
almacenamiento se debe hacer celda a celda de forma paulatina. Esto
quiere decir que cada dato debe irse ubicando en una celda espec´ıfica que
se identifica con su n´umero ´ındice. De esta manera y suponiendo que se
tiene ya un arreglo declarado de tipo Entero, denominado numero en
el que se van a almacenar 5 n´umeros, el almacenamiento se har´ıa de la
siguiente forma:
Entero numero[ 5 ]

-- 358 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 357
numero[ 1 ] = 4
numero[ 2 ] = 2
numero[ 3 ] = 15
numero[ 4 ] = 8
numero[ 5 ] = 3
Estas asignaciones hacen que en la primera posici´on del vector numero
se almacene un 4, en la segunda posici´on un 2, en la tercera un 15, en la
cuarta un 8 y en la quinta un 3. Gr´aficamente, el arreglo se ver´ıa como en
la Figura 6.9.
numero -> 4 2 15 8 3
1 2 3 4 5
Figura 6.9: Ejemplo almacenamiento en un vector
Tambi´en es posible almacenar en una posici´on espec´ıfica de un vector un
dato que ya est´e almacenado en una variable, siempre y cuando la variable
y el vector sean del mismo tipo de dato. Por ejemplo, suponga que se tiene
una variable entera denominada edad que tiene almacenado un 20. El
contenido de esta variable puede almacenarse en una posici´on cualquiera
del vector de la siguiente forma:
Entero numero[ 5 ], edad
edad = 20
numero[ 4 ] = edad
Esta instrucci´on har´a que el valor almacenado en la variable edad quede
tambi´en almacenado en la posici´on 4 del vector.
Tambi´en es posible, en el momento de la declaraci´on, almacenar varios
datos en un vector con una sola instrucci´on, de la siguiente manera:
Entero numero[ ] = {7, 21, 93, 48, 5}
De esta forma, el n´umero 7 se almacenar´a en la posici´on 1 de numero,
21 en la posici´on 2, 93 en la posici´on 3, 48 en la posici´on 4 y 5 en la posici´on
5 de este arreglo. (Ver Figura 6.10).
Ahora, es importante analizar c´omo puede el usuario realizar una lectura
de datos y almacenarlos en un vector. Aunque es posible hacer una lectura
manual para cada posici´on, lo ideal ser´ıa hacer uso de un ciclo. Suponga
que se desean leer, por ejemplo, 20 n´umeros enteros:

-- 359 of 450 --

358 Vectores y matrices
numero -> 7 21 93 48 5
1 2 3 4 5
Figura 6.10: Ejemplo de asignaci´on directa
Entero numero[ 20 ], i
Para i = 1 Hasta 20 Incremento 1
imprimir( "Ingrese el n´umero " , i, ": " )
leer( numero[ i ] )
FinPara
En esta porci´on de c´odigo, la variable i representa el ´ındice con el
cual se ir´a accediendo a cada posici´on del arreglo. El ciclo se ejecutar´a
20 veces desde 1 hasta 20, lo que coincide con todas las posiciones del
arreglo. La funci´on imprimir() solicitar´a al usuario el ingreso de un
n´umero cualquiera. La variable i que va al final de la funci´on imprimir()
dentro del par´entesis servir´a para que el usuario reconozca la secuencia
de los n´umeros que va ingresando. La funci´on leer() llevar´a el n´umero
ingresado por el usuario a la respectiva posici´on del vector numero
representada por el ´ındice.
6.1.3 Recuperaci´on de datos almacenados en un vector
Al recuperar un dato que se encuentre en una posici´on espec´ıfica de un
vector, es necesario
