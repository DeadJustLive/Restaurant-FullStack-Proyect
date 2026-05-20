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
vector, es necesario saber cu´al es esa posici´on y luego acceder a ella a trav´es
de alguna instrucci´on. Por ejemplo, sup´ongase que se quiere conocer cu´al
es el dato almacenado en la posici´on 3 del vector numero. (Ver Figura
6.11).
numero -> 4 2 15 8 3
1 2 3 4 5
Figura 6.11: Ejemplo recuperaci´on de datos
Para ello, ser´a necesario escribir la siguiente instrucci´on:
imprimir( "El tercer elemento es " , numero[ 3 ] )
Luego de utilizar esta instrucci´on y, suponiendo que los datos
almacenados son los de la imagen anterior, el dato mostrado con la funci´on

-- 360 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 359
imprimir() es 15.
Ahora bien, si este n´umero se requiere para llevar a cabo alg´un c´alculo,
este puede llevarse a otra variable, siempre y cuando la variable que lo va
a almacenar temporalmente sea del mismo tipo de dato que el arreglo
de donde proviene el dato. Como ejemplo, suponga que el dato de la
posici´on 5 del arreglo se requiere para un c´alculo particular, con la siguiente
instrucci´on, el dato se copia en la variable n que se usar´a para ese fin:
Entero n, numero[ ] = {7, 21, 93, 48, 5}
n = numero[ 4 ]
Luego de ejecutar esta instrucci´on, una copia del valor 48 quedar´a
almacenado en la variable n. Tenga en cuenta que el 48 no se borrar´a
de la posici´on 4 de numero, solo se habr´a copiado.
Tambi´en es posible que en algunos problemas de l´ogica de programaci´on
se presente la necesidad de recuperar todos los datos almacenados en las
diferentes posiciones del vector. En estos casos, deber´a recorrerse con un
ciclo el vector, desde la primera hasta la ´ultima posici´on. Como ejemplo
de esta situaci´on, imagine que se desean sumar los valores almacenados en
numero e informarle al usuario el total de la suma. Para ello, se tiene la
siguiente porci´on de c´odigo:
Entero numero[ ] = {7, 21, 93, 48, 5}
Entero i, suma
suma = 0
Para i = 1 Hasta 5 Incremento 1
suma = suma + numero[ i ]
FinPara
imprimir( "La suma de los elementos es: ", suma )
En la anterior porci´on de c´odigo, se llevan a cabo varias tareas que se
explican a continuaci´on:
Se declara una variable suma de tipo Entero que almacenar´a la
suma de los datos almacenados en numero.
La variable suma se inicializa en 0, pues antes de empezar a sumar
no se tiene nada acumulado.
Se utiliza el ciclo Para con la variable i como contador e ´ındice, con
el fin de recorrer el vector desde la posici´on 1 hasta el tama˜no del
mismo (5).

-- 361 of 450 --

360 Vectores y matrices
Se utiliza la instrucci´on dentro del ciclo para ir sumando el valor de
la posici´on actual de numero con lo que se est´an acumulando los
datos del vector en la variable suma.
suma = suma + numero[ i ]
Al finalizar el ciclo se muestra el total de la suma mediante la funci´on
imprimir().
En las siguientes secciones se utilizan varios ejercicios para ejemplificar el
uso de los arreglos unidimensionales o vectores. Se describir´an inicialmente,
los primeros algoritmos escritos de manera secuencial; posteriormente,
los algoritmos que aparecer´an, se escribir´an haciendo uso de funciones y
procedimientos.
.:Ejemplo 6.1. Dise˜ne un algoritmo que permita almacenar en un vector
de 4 posiciones o celdas, n´umeros Enteros comprendidos entre 10 y 20 y
que, a continuaci´on, determine cu´antas veces se encuentra almacenado el
n´umero 14 en el arreglo.
An´alisis del problema:
Resultados esperados: mostrar la cantidad de veces que aparece
el n´umero 14 en las celdas de un arreglo de 4 posiciones.
Datos disponibles: los cuatro n´umeros que se almacenan en el
arreglo en el intervalo 10 al 20.
Proceso: se solicita al usuario el tama˜no del arreglo, posteriormente
se hace la lectura de todos lo datos, luego se lleva a cabo una
b´usqueda del n´umero 14 celda a celda, desde la primera posici´on
hasta la ´ultima; cada vez que se encuentre, se va incrementando un
contador. Al final del algoritmo, se mostrar´a la cantidad de veces que
se ha encontrado el n´umero 14.
Variables requeridas:
• numero: arreglo que almacena los n´umeros ingresados
• i: variable que controla el ciclo
• contador14: variable que almacena la cantidad de veces3 que
aparece el n´umero 14 en el arreglo.
3contador

-- 362 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 361
• repetir: bandera utilizada para determinar si es necesario
solicitar nuevamente un dato debido a que el valor previamente
ingresado no cumpla con la condici´on de estar entre 10 y 20.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.1.
Algoritmo 6.1: Numero14
1 Algoritmo Numero14
2 Constante Entero MAX = 4
3 Entero numero [ MAX ], contador14, i
4 Logico repetir
5
6 Para i = 1 Hasta MAX Incremento 1
7 Haga
8 imprimir( "Ingrese el n´umero " , i, ": " )
9 leer( numero[ i ] )
10
11 repetir = Falso
12 Si( numero[ i ] < 10 O
13 numero[ i ] > 20 ) Entonces
14 repetir = Verdadero
15 imprimir( "Este n´umero no es v´alido" )
16 FinSi
17 MientrasQue( repetir == Verdadero )
18 FinPara
19
20 contador14 = 0
21 Para i = 1 Hasta MAX Incremento 1
22 Si( numero[ i ] == 14 ) Entonces
23 contador14 = contador14 + 1
24 FinSi
25 FinPara
26
27 imprimir( "El n´umero 14 est´a ", contador14, " veces" )
28 FinAlgoritmo
Al ejecutar el algoritmo:
Ingrese el n´umero 1: 14
Ingrese el n´umero 2: 2
Este n´umero no es v´alido
Ingrese el n´umero 2: 18
Ingrese el n´umero 3: 20
Ingrese el n´umero 4: 14
El n´umero 14 est´a 2 veces

-- 363 of 450 --

362 Vectores y matrices
Explicaci´on del algoritmo:
Inicialmente, como en todos los algoritmos vistos, se declaran las
variables necesarias (l´ıneas 2 a 4), incluyendo el tama˜no del arreglo
mediante la constante MAX, la cual, para el ejemplo es de 4 elementos.
Esta constante permite no solo inicializar el vector, sino que ser´a el tope
hasta el que iterar´a el ciclo recorriendo el vector hasta su ´ultima posici´on.
2 Constante Entero MAX = 4
3 Entero numero [ MAX ], contador14, tamanio, i
4 Logico repetir
Con el primer ciclo Para, se recorre el vector desde la posici´on
1 representada por la variable i hasta la ´ultima posici´on del vector
(especificada por la constante MAX) y se solicitan los n´umeros que se van
a almacenar.
Dentro de este ciclo se encuentra otro ciclo Haga-MientrasQue, el
cual se utiliza para validar que los n´umeros ingresados y que van a ser
almacenados en las diversas posiciones del arreglo si se encuentren en el
intervalo 10 al 20.
7 Haga
8 imprimir( "Ingrese el n´umero " , i, ": " )
9 leer( numero[ i ] )
10
11 repetir = Falso
12 Si( numero[ i ] < 10 O
13 numero[ i ] > 20 ) Entonces
14 repetir = Verdadero
15 imprimir( "Este n´umero no es v´alido" )
16 FinSi
17 MientrasQue( repetir == Verdadero )
All´ı mismo se ubica una instrucci´on Si, que muestra un mensaje en el
caso de que el n´umero ingresado no haga parte del intervalo especificado,
y cambia el estado de la bandera repetir para que pase de Falso
a Verdadero. La bandera es importante para poder hacer que el ciclo
Haga-MientrasQue realice una nueva iteraci´on4 o no.
Luego de este primer ciclo Para, se inicializa el contador de n´umeros 14
en cero, ya que todav´ıa no se ha encontrado ninguno; a continuaci´on, se
utiliza un segundo ciclo Para que vuelve a recorrer el arreglo de n´umeros
y dentro de ´el, con una instrucci´on Si, se pregunta si el dato contenido en
cada celda es un 14, de ser as´ı, se cuenta.
4El dato ingresado es inv´alido

-- 364 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 363
20 contador14 = 0
21 Para i = 1 Hasta MAX Incremento 1
22 Si( numero[ i ] == 14 ) Entonces
23 contador14 = contador14 + 1
24 FinSi
25 FinPara
Al final, se muestra con la instrucci´on imprimir la cantidad de 14
encontrados en el arreglo.
27 imprimir( "El n´umero 14 est´a ", contador14, " veces" )
.:Ejemplo 6.2. Dise˜ne un algoritmo que permita almacenar los nombres de
un grupo de n personas en un arreglo unidimensional y que posteriormente,
busque la posici´on del arreglo en la que qued´o almacenado el nombre de una
persona que el usuario ingresa. Si ese nombre no aparece en el arreglo, se
debe mostrar el respectivo mensaje.
Aclaraci´on:
Este ejercicio, aunque parecido al anterior, contiene
varias diferencias fundamentales: se debe utilizar un
vector que guarde los nombres de personas, una vez
almacenadas, se debe buscar un nombre en particular
y verificar si est´a almacenado o no en el arreglo; si
est´a almacenado, deber´a decirse la posici´on en la que se encuentra.
En este ejercicio es necesario suponer que no se almacena un nombre
m´as de una vez, es decir, no existen dos o m´as personas con el mismo
nombre.
An´alisis del problema:
Resultados esperados: la posici´on del arreglo en la que se
encuentra el nombre a buscar ingresado por el usuario.
Datos disponibles: el tama˜no del arreglo y el nombre de la persona
que se desea buscar.
Proceso: solicitar la cantidad de nombres a ingresar (n), luego se
solicitan los nombres de las n personas y se almacenan en el arreglo,
posteriormente se hace una b´usqueda secuencial desde la primera
hasta la ´ultima posici´on del arreglo de nombres comparando si el
nombre que se est´a buscando es igual al nombre que hay en la posici´on
actual, Si esto ocurre, ya se encontr´o lo que se buscaba y se puede

-- 365 of 450 --

364 Vectores y matrices
terminar la b´usqueda all´ı mostrando la posici´on en la que el nombre
se encuentra; si no se ha encontrado, se pasa a la siguiente posici´on
y se vuelve a comparar hasta llegar al final del arreglo. Si se ha
llegado al final del arreglo y no se encontr´o nada, deber´a informarse
al usuario.
Variables requeridas:
• tamanio5: contiene el tama˜no del arreglo.
• arregloNombres: es el arreglo que almacena los nombres.
• i: variable de control del ciclo
• nombreBuscar: almacena el nombre que se desea buscar
• encontrado: variable que indica si se encontr´o o no el nombre
en el arreglo.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.2.	Algoritmo 6.2: NombrePersonas
1 Algoritmo NombrePersonas
2 Entero tamanio, i
3 Cadena arregloNombres[ ], nombreBuscar
4 Logico encontrado
5
6 imprimir( "Ingrese el tama˜no del arreglo: ")
7 leer( tamanio )
8
9 arregloNombres = dimensionar( tamanio )
10
11 Para i = 1 Hasta tamanio Incremento 1
12 imprimir( "Ingrese el nombre persona " , i, ": " )
13 leer( arregloNombres[ i ] )
14 FinPara
15
16 imprimir( "Ingrese el nombre de la persona a buscar: " )
17 leer( nombreBuscar )
18
19 encontrado = Falso
20 Para i = 1 Hasta tamanio Incremento 1
21 Si( nombreBuscar == arregloNombres[ i ] ) Entonces
22 imprimir( "El nombre est´a en la posici´on ", i )
23 encontrado = Verdadero
24 FinSi
25 FinPara
26
27 Si( encontrado == Falso ) Entonces
28 imprimir( "El nombre no est´a en el arreglo" )
5por norma, en los identificadores se evita el uso de caracteres como tildes y e˜nes.

-- 366 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 365
29 FinSi
30 FinAlgoritmo
Al ejecutar el algoritmo:
Primera ejecuci´on:
Ingrese el tama˜no del arreglo: 3
Ingrese el nombre persona 1: Jacobo
Ingrese el nombre persona 2: Gabriela
Ingrese el nombre persona 3: Adriana
Ingrese el nombre de la persona a buscar: Adriana
El nombre est´a en la posici´on 3
Segunda ejecuci´on:
Ingrese el tama˜no del arreglo: 3
Ingrese el nombre persona 1: Jacobo
Ingrese el nombre persona 2: Gabriela
Ingrese el nombre persona 3: Adriana
Ingrese el nombre de la persona a buscar: Nidia
El nombre no est´a en el arreglo
Explicaci´on del algoritmo:
En este algoritmo, como en todos los anteriores, lo primero es declarar
las variables necesarias (l´ıneas 2 a 4).
Observe que el arreglo de nombres es de tipo Cadena. Despu´es de la
declaraci´on de las variables, se solicita el tama˜no para, con este dato,
dimensionar al arreglo.
6 imprimir( "Ingrese el tama˜no del arreglo: ")
7 leer( tamanio )
8
9 arregloNombres = dimensionar( tamanio )
A continuaci´on, se solicitan los nombres de las personas y se almacenan
en cada posici´on del arreglo; esto se hace mediante el uso del primer ciclo
Para.
11 Para i = 1 Hasta tamanio Incremento 1
12 imprimir( "Ingrese el nombre persona " , i, ": " )
13 leer( arregloNombres[ i ] )
14 FinPara
Luego, se solicita el nombre que se va a buscar y se inicializa una
variable “centinela” (de tipo l´ogico) denominada encontrado en Falso.

-- 367 of 450 --

366 Vectores y matrices
Esta variable centinela permitir´a terminar el ciclo inmediatamente despu´es
de encontrar el nombre que se est´a buscando.
16 imprimir( "Ingrese el nombre de la persona a buscar: " )
17 leer( nombreBuscar )
Con objeto de hacer la b´usqueda, se utiliza un segundo ciclo Para y,
dentro de este segundo ciclo se usa la instrucci´on Si, que compara si el
nombre que se est´a buscando es igual al nombre almacenado en la celda
actual del arreglo, si esto ocurre, se muestra un mensaje indicando la
posici´on del arreglo donde est´a el nombre y se cambia el contenido de
la variable encontrado a Verdadero, lo que indica que ya se encontr´o el
nombre buscado.
19 encontrado = Falso
20 Para i = 1 Hasta tamanio Incremento 1
21 Si( nombreBuscar == arregloNombres[ i ] ) Entonces
22 imprimir( "El nombre est´a en la posici´on ", i )
23 encontrado = Verdadero
24 FinSi
25 FinPara
Finalmente, y luego del segundo ciclo, el algoritmo posee otra instrucci´on
Si, que eval´ua si la variable encontrado tiene almacenado un valor de
Falso, lo cual indicar´ıa que no se encontr´o el nombre buscado en el vector,
por lo que se muestra este mensaje con la instrucci´on imprimir. Luego
de esto, el algoritmo termina.
27 Si( encontrado == Falso ) Entonces
28 imprimir( "El nombre no est´a en el arreglo" )
29 FinSi
.:Ejemplo 6.3. Se almacenan en un arreglo unidimensional n n´umeros
enteros positivos. Dise˜ne un algoritmo que genere otro arreglo que almacene
de forma invertida los elementos guardados en el arreglo inicial, es decir,
el ´ultimo elemento almacenado en el arreglo inicial que ocupa la posici´on
n, ser´a el primero en el arreglo generado y, el primer elemento almacenado
en el arreglo inicial, ocupar´a la ´ultima posici´on en el arreglo generado.
An´alisis del problema:
Resultados esperados: un segundo arreglo de n´umeros enteros y
en este se almacenen los n´umeros que hay en el arreglo inicial de
forma invertida a como est´an almacenados en este arreglo inicial.

-- 368 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 367
Datos disponibles: el tama˜no del arreglo inicial y los n´umeros que
se almacenar´an en ´el.
Proceso: luego de solicitar el tama˜no del arreglo inicial y los n´umeros
que se van a almacenar en ´el, se hace un recorrido a este arreglo desde
la primera hasta la ´ultima posici´on y se van pasando los n´umeros al
segundo arreglo, que debe recorrerse paralelamente desde la ´ultima
hasta la primera posici´on.
Variables requeridas:
• n: n´umero de elementos del arreglo
• i: variable de control para moverse en el primer arreglo.
• j: variable de control para moverse en el segundo arreglo.
• arregloInicial: arreglo que contiene los n´umeros iniciales.
• arregloFinal: arreglo que contiene los n´umeros en orden
inverso.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.3.
Algoritmo 6.3: InversionArreglo
1 Algoritmo InversionArreglo
2 Entero arregloInicial[ ], arregloFinal[ ], n, i, j
3
4 imprimir( "Ingrese el tama˜no del Arreglo: " )
5 leer( n )
6
7 arregloInicial = dimensionar( n )
8 arregloFinal = dimensionar( n )
9
10 Para i = 1 Hasta n Incremento 1
11 Haga
12 imprimir( "Ingrese el n´umero " , i, ": " )
13 leer( arregloInicial[ i ] )
14
15 Si( numero[ i ] < 0 ) Entonces
16 imprimir( "Este n´umero no es v´alido" )
17 FinSi
18 MientrasQue( numero[ i ] < 0 )
19 FinPara
20
21 j = n
22 Para i = 1 Hasta n Incremento 1
23 arregloFinal[ j ] = arregloInicial[ i ]
24 j = j - 1
25 FinPara

-- 369 of 450 --

368 Vectores y matrices
26
27 Para i = 1 Hasta n Incremento 1
28 imprimir( arregloFinal[ i ], " " )
29 FinPara
30 FinAlgoritmo
Al ejecutar el algoritmo:
Ingrese el tama˜no del Arreglo: 4
Ingrese el n´umero 1: 3
Ingrese el n´umero 2: 9
Ingrese el n´umero 3: -8
Este n´umero no es v´alido
Ingrese el n´umero 3: 45
Ingrese el n´umero 4: 92
92 45 9 3
Explicaci´on del algoritmo:
Al principio de este algoritmo se hace la declaraci´on de todas las variables
necesarias (l´ınea 2). Acto seguido, se solicita mediante las instrucciones
imprimir y leer, el tama˜no del arreglo, que es almacenado en la variable
n y, con la cual se le da tama˜no al arreglo inicial y final.
4 imprimir( "Ingrese el tama˜no del Arreglo: " )
5 leer( n )
6
7 arregloInicial = dimensionar( n )
8 arregloFinal = dimensionar( n )
Luego, en las instrucciones que siguen a continuaci´on en el algoritmo, se
utiliza un ciclo Para con el prop´osito de almacenar en cada posici´on del
arreglo inicial los n´umeros enteros positivos que el usuario ingresa. N´otese
que dentro de este primer ciclo Para, se usa un ciclo Haga-MientrasQue
que valida y asegura el ingreso de n´umeros positivos, lo cual es un requisito
propuesto en el enunciado.
Dentro de este ciclo Haga-MientrasQue, se usa una instrucci´on
Si que muestra un mensaje solo si el n´umero ingresado es menor que
cero, haci´endole entender al usuario que este n´umero no es v´alido para
almacenarse en el arregloInicial, pues no corresponde a un n´umero
positivo.

-- 370 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 369
10 Para i = 1 Hasta n Incremento 1
11 Haga
12 imprimir( "Ingrese el n´umero " , i, ": " )
13 leer( arregloInicial[ i ] )
14
15 Si( numero[ i ] < 0 ) Entonces
16 imprimir( "Este n´umero no es v´alido" )
17 FinSi
18 MientrasQue( numero[ i ] < 0 )
19 FinPara
En la segunda parte del algoritmo, se inicializa la variable j con el
tama˜no de este arreglo, es decir, se busca ubicar la ´ultima posici´on de
este arreglo utilizando la variable j. Se utiliza un segundo ciclo Para que
recorre el arregloInicial desde la primera hasta la ´ultima posici´on
de este, pero que paralelamente va recorriendo el arregloFinal desde
la ´ultima posici´on marcada con la variable j hasta la posici´on 1, pues
esta se va reduciendo dentro del ciclo, de esta forma se va pasando el
elemento que hay en cada posici´on del arregloInicial a cada posici´on
del arregloFinal.
21 j = n
22 Para i = 1 Hasta n Incremento 1
23 arregloFinal[ j ] = arregloInicial[ i ]
24 j = j - 1
25 FinPara
Luego, con otro ciclo Para se imprimen todos los elementos del
arregloFinal.
27 Para i = 1 Hasta n Incremento 1
28 imprimir( arregloFinal[ i ], " " )
29 FinPara
Se asume que cada impresi´on se realiza en la misma l´ınea. Si cada vez
que se ejecuta la instrucci´on imprimir el mensaje se ubicase en una l´ınea
nueva, ser´ıa necesario usar una nueva variable tipo Cadena para almacenar
todos los datos y luego invocar una sola vez la instrucci´on imprimir (Ver
el siguiente ejemplo).
.:Ejemplo 6.4. Dise˜ne un algoritmo que permita almacenar en un vector
una cantidad n de n´umeros pares y en otro vector una cantidad m de
n´umeros impares ingresados por el usuario. Construya el algoritmo de tal
manera que almacene en un tercer vector todos los n´umeros contenidos en
los dos vectores iniciales y muestre al final el tercer vector.

-- 371 of 450 --

370 Vectores y matrices
An´alisis del problema:
Resultados esperados: un vector con los datos almacenados en los
dos arreglos iniciales.
Datos disponibles: el tama˜no de los dos vectores iniciales y los
n´umeros que se van a almacenar en ellos.
Proceso: solicitar al usuario el tama˜no de cada uno de los vectores,
luego, leer todos los n´umeros a almacenar en los dos vectores iniciales,
posteriormente se toman todos los datos del primer vector (uno a
uno) y se almacenan en el tercer vector, luego se toman los datos del
segundo vector y se ubican tambi´en en el tercer vector y, finalmente
se imprime el tercer vector.
Variables requeridas:
• arregloPares: vector que contiene todos los n´umeros pares
que el usuario ingres´o.
• arregloImpares: vector que contiene todos los n´umeros
impares que el usuario ingres´o.
• arregloTotal: vector que contiene todos los n´umeros que el
usuario ingres´o (pares e impares).
• tamanioPares: cantidad de elementos que contiene el vector
de pares.
• tamanioImpares: cantidad de elementos que contiene el
vector de impares.
• tamanioTotal:
• i: variable de control para los vectores.
• j: variable de control para los vectores
• salida: variable que almacena los datos del tercer vector para
su posterior impresi´on.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.4.
Algoritmo 6.4: ConcatenaArreglos
1 Algoritmo ConcatenaArreglos
2 Entero arregloPares[ ], arregloImpares[ ], arregloTotal[ ]
3 Entero tamanioPares, tamanioImpares, tamanioTotal, i, j
4 Cadena salida
5
6 imprimir( "Ingrese la cantidad de pares: " )
7 leer( tamanioPares )

-- 372 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 371
8
9 imprimir( "Ingrese la cantidad de impares: " )
10 leer( tamanioImpares )
11
12 tamanioTotal = tamanioPares + tamanioImpares
13
14 arregloPares = dimensionar( tamanioPares )
15 arregloImpares = dimensionar( tamanioImpares )
16 arregloTotal = dimensionar( tamanioTotal )
17
18 Para i = 1 Hasta tamanioPares Incremento 1
19 Haga
20 imprimir( "Ingrese el par " , i, ": " )
21 leer( arregloPares[ i ] )
22
23 Si( arregloPares[ i ] % 2 != 0 ) Entonces
24 imprimir( "Este n´umero no es par" )
25 FinSi
26 MientrasQue( arregloPares[ i ] % 2 != 0 )
27 FinPara
28
29 Para i = 1 Hasta tamanioImpares Incremento 1
30 Haga
31 imprimir( "Ingrese el impar " , i," : " )
32 leer( arregloImpares[ i ] )
33
34 Si( arregloImpares[ i ] % 2 != 1 ) Entonces
35 imprimir( "Este n´umero no es impar" )
36 FinSi
37 MientrasQue( arregloImpares[ i ] % 2 != 1 )
38 FinPara
39
40 j = 1
41 Para i = 1 Hasta tamanioPares Incremento 1
42 arregloTotal[ j ] = arregloPares [ i ]
43 j = j + 1
44 FinPara
45
46 Para i = 1 Hasta tamanioImpares Incremento 1
47 arregloTotal[ j ] = arregloImpares [ i ]
48 j = j + 1
49 FinPara
50
51 salida = ""
52 Para i = 1 Hasta arregloTotal Incremento 1
53 salida = salida + arregloTotal [ i ] + " "
54 FinPara
55 imprimir( "Arreglo concatenado: ", salida )
56 FinAlgoritmo

-- 373 of 450 --

372 Vectores y matrices
Al ejecutar el algoritmo:
Ingrese la cantidad de pares: 3
Ingrese la cantidad de impares: 2
Ingrese el par 1: 8
Ingrese el par 2: 9
Este n´umero no es par
Ingrese el par 2: 34
Ingrese el par 3: 86
Ingrese el impar 1: 73
Ingrese el impar 2: 8
Este n´umero no es impar
Ingrese el impar 2: 1
Arreglo concatenado 8 34 86 73 1
Explicaci´on del algoritmo:
En las primeras l´ıneas (2 a la 4) se declaran todas las variables que
se requieren. A continuaci´on, se solicita la cantidad de n´umeros pares e
impares y con esta informaci´on se determina la cantidad total de n´umeros
a ingresar.
6 imprimir( "Ingrese la cantidad de pares: " )
7 leer( tamanioPares )
8
9 imprimir( "Ingrese la cantidad de impares: " )
10 leer( tamanioImpares )
11
12 tamanioTotal = tamanioPares + tamanioImpares
Una vez hecho esto, se procede a dimensionar cada uno de los arreglos
del tama˜no ya definido.
14 arregloPares = dimensionar( tamanioPares )
15 arregloImpares = dimensionar( tamanioImpares )
16 arregloTotal = dimensionar( tamanioTotal )
Lo que sigue en el algoritmo, es realizar la lectura de los n´umeros pares:
18 Para i = 1 Hasta tamanioPares Incremento 1
19 Haga
20 imprimir( "Ingrese el par " , i, ": " )
21 leer( arregloPares[ i ] )
22
23 Si( arregloPares[ i ] % 2 != 0 ) Entonces
24 imprimir( "Este n´umero no es par" )
25 FinSi
26 MientrasQue( arregloPares[ i ] % 2 != 0 )
27 FinPara

-- 374 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 373
Observe que dentro de este ciclo Para se realiza la respectiva validaci´on
con el prop´osito de evitar que el usuario ingrese un n´umero impar. Para
realizar la validaci´on se hace uso de un Haga-MientrasQue y un Si
que informa al usuario, de ser necesario, el intento de ingresar un dato no
v´alido. Algo similar se realiza en las l´ıneas 29 a la 38 pero, esta vez con el
ingreso de los n´umeros impares.
Despu´es, se inicializa la variable de control j con el valor 1, y se
usar´a para “navegar” dentro del vector arregloTotal. Posteriormente
se recorre con un ciclo Para el vector arregloPares para copiar todos
sus datos al vector arregloTotal. De forma similar se recorre con otro
ciclo el vector arregloImpares y se copian los elementos en el vector
arregloTotal. Note que la variable j no fue inicializada nuevamente en
el momento de copiar los elementos del segundo arreglo, as´ı que contin´ua
en la siguiente posici´on en donde se ubic´o el ´ultimo n´umero par.
40 j = 1
41 Para i = 1 Hasta tamanioPares Incremento 1
42 arregloTotal[ j ] = arregloPares [ i ]
43 j = j + 1
44 FinPara
45
46 Para i = 1 Hasta tamanioImpares Incremento 1
47 arregloTotal[ j ] = arregloImpares [ i ]
48 j = j + 1
49 FinPara
Para finalizar, se inicializa una variable tipo Cadena, denominada
salida con una cadena vac´ıa (""), luego se recorre todo el
arregloTotal y en cada iteraci´on se concatena a la variable salida
el elemento del arregloTotal en la posici´on actual, m´as un espacio en
blanco. Una vez se ha recorrido todo este arreglo, se procede a imprimir la
variable salida.
51 salida = ""
52 Para i = 1 Hasta arregloTotal Incremento 1
53 salida = salida + arregloTotal [ i ] + " "
54 FinPara
55 imprimir( "Arreglo concatenado: ", salida )
.:Ejemplo 6.5. Dise˜ne un algoritmo que reciba como entrada un n´umero
entero entre cero y noveinta y nueve (0 y 99) y que, como salida muestre
ese mismo n´umero, pero expresado esta vez en palabras.

-- 375 of 450 --

374 Vectores y matrices
An´alisis del problema:
Resultados esperados: el n´umero ingresado (0 a 99) pero
expresado en palabras.
Datos disponibles: el n´umero que se desea convertir a palabras.
Proceso: se le solicita al usuario el n´umero a convertir a palabras,
luego se realiza un proceso para su conversi´on de este n´umero a
su equivalente en palabras realizando la b´usqueda de las palabras
adecuadas en varios vectores, y finalmente se imprime el mensaje.
El proceso de conversi´on, consiste en determinar si el n´umero es
menor a 11 para buscar la palabra que lo identifica en un primer
vector; sino, se verifica si el n´umero est´a entre 11 y 19, de ser as´ı,
se busca su respectiva palabra en otro vector; y si es mayor a 19, se
determinan las unidades y las decenas de este n´umero y se buscan
sus palabras equivalentes en los vectores respectivos.
Para la resoluci´on de este ejercicio se utilizan tres vectores que
poseen las palabras, correspondientes a ciertos n´umeros claves, ya
almacenadas desde su declaraci´on. en este sentido, el algoritmo no
le solicita al usuario datos que vayan a ser almacenados en alg´un
vector, ni mucho menos se requiere pedir el tama˜no del mismo, pues
como se acaba de mencionar, los vectores se llenan con los datos (las
palabras) desde el momento en que se declaran.
Variables requeridas:
• numero: que se desea convertir a palabras.
• numeroPalabras: que almacena el n´umero en palabras.
• arregloUnidades: vector que contiene los nombres de los
primeros once n´umeros (iniciando desde el cero).
• arregloEspecial: vector que contiene los de los siguientes
ocho n´umeros comenzando en once.
• arregloDecenas: vector que contiene los nombres de los
n´umeros del veinte al noventa, pero de diez en diez.
• decenas: cantidad de decenas que tiene el n´umero ingresado
por usuario.
• unidades: cantidad de unidades que tiene el n´umero
ingresado.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.5.

-- 376 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 375
Algoritmo 6.5: ConversionNumero
1 Algoritmo ConversionNumero
2
3 Entero numero, decenas, unidades
4 Cadena numeroPalabras
5 Cadena arregloUnidades[ ] = { "cero", "uno", "dos",
6 "tres", "cuatro", "cinco",
7 "seis", "siete", "ocho",
8 "nueve", "diez" }
9
10 Cadena arregloEspecial[ ] = {"once", "doce",
11 "trece", "catorce",
12 "quince", "dieciseis",
13 "diecisiete", "dieciocho",
14 "diecinueve" }
15
16 Cadena arregloDecenas [ ] = { "veinte", "treinta",
17 "cuarenta", "cincuenta",
18 "sesenta", "setenta",
19 "ochenta", "noventa" }
20
21 Haga
22 imprimir( "Ingrese el n´umero a convertir: " )
23 leer( numero )
24
25 Si ( numero < 0 O numero > 99 ) Entonces
26 imprimir( "Este n´umero no es v´alido" )
27 FinSi
28 MientrasQue( numero < 0 O numero > 99)
29
30 Si( numero <= 10 ) Entonces
31 numeroPalabras = arregloUnidades[ numero + 1 ]
32 SiNo
33 Si( numero <= 19 ) Entonces
34 numeroPalabras = arregloEspecial[ numero - 10 ]
35 SiNo
36 unidades = numero % 10
37 decenas = numero / 10
38
39 Si( unidades == 0 ) Entonces
40 numeroPalabras = arregloDecenas[ decenas - 1]
41 SiNo
42 numeroPalabras = arregloDecenas[ decenas - 1 ] +
43 " y " +
44 arregloUnidades[ unidades + 1 ]
45 FinSi
46 FinSi
47 FinSi
48

-- 377 of 450 --

376 Vectores y matrices
49 imprimir( "El n´umero es: ", numeroPalabras )
50 FinAlgoritmo
Al ejecutar el algoritmo:
Ingrese el n´umero a convertir: -4
Este n´umero no es v´alido
Ingrese el n´umero a convertir: 200
Este n´umero no es v´alido
Ingrese el n´umero a convertir: 87
El n´umero es: ochenta y siete
Explicaci´on del algoritmo:
Luego de declarar todas las variables necesarias, incluso de inicializar
los arreglos con las palabras correspondientes a los n´umeros (l´ıneas 3 a la
19); se procede a solicitar al usuario un n´umero entero 0 y 99, haciendo
la respectiva validaci´on. Observe que esta validaci´on no permitira ingresar
un n´umero que est´e por debajo de cero o por encima de noveinta y nueve.
20 Haga
21 imprimir( "Ingrese el n´umero a convertir: " )
22 leer( numero )
23
24 Si ( numero < 0 O numero > 99 ) Entonces
25 imprimir( "Este n´umero no es v´alido" )
26 FinSi
27 MientrasQue( numero < 0 O numero > 99)
A continuaci´on, se determina si el n´umero es menor o igual a 10 con la
primera instrucci´on Si. Si esto ocurre, se ubica la palabra correspondiente
al n´umero en el vector de unidades. En el caso de que el n´umero sea menor
o igual a 19, el algoritmo hace la b´usqueda en el vector de especiales. Si el
n´umero es mayor a 19, se determina cu´antas decenas y cu´antas unidades
tiene, para as´ı poder mostrar el respectivo nombre. En el caso de que
no tenga unidades (unidades == 0), solo se muestra el nombre de las
decenas, si no, se muestran tanto decenas como unidades.
29 Si( numero <= 10 ) Entonces
30 numeroPalabras = arregloUnidades[ numero + 1 ]
31 SiNo
32 Si( numero <= 19 ) Entonces
33 numeroPalabras = arregloEspecial[ numero - 10 ]
34 SiNo
35 unidades = numero % 10
36 decenas = numero / 10
37

-- 378 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 377
38 Si( unidades == 0 ) Entonces
39 numeroPalabras = arregloDecenas[ decenas - 1]
40 SiNo
41 numeroPalabras = arregloDecenas[ decenas - 1 ] +
42 " y " +
43 arregloUnidades[ unidades + 1 ]
44 FinSi
45 FinSi
46 FinSi
Note como es necesario sumar o restar ciertas cantidades a las ´ındices
para poder obtener el valor correcto. Por ejemplo, si el n´umero fuera 8,
ser´ıa necesario sumar un uno para llegar a la novena posici´on del vector de
unidades en donde est´a la palabra “ocho”; esto suecede, porque la palabra
“cero” ocupa la primera posici´on. Algo similar sucede en los otros dos
vectores, por ejemplo, si el n´umero a convertir es 17, el algoritmo ingresa
a la parte del SiNo del primer Si, all´ı encuentra el segundo Si que se
evaluar´ıa como Verdadero, por lo cual el algoritmo almacenar´ıa en la
variable numeroPalabras lo que hay en el vector arregloEspecial
en la posici´on numero - 10, lo que coresponde a 17 - 10 = 7 y, al buscar
en la posici´on 7 de este vector, se encuentra la palabra diecisiete.
Ahora, si el n´umero ingresado fuera 60, el algoritmo llegar´ıa a la
instrucci´on Si(numero<=19) que se evaluar´ıa como Falso, por lo
cual, el algoritmo determinar´ıa las unidades = 0 y las decenas =
6, por tanto determinar´ıa la posici´on 5 (decenas - 1) en el vector de
arregloDecenas, la cual corresponde a sesenta.
Finalmente, se imprime el n´umero pero en palabras, con lo que termina
el algoritmo.
49 imprimir( "El n´umero es: ", numeroPalabras )
Aclaraci´on:
En los ejercicios que aparecen a continuaci´on, se
utilizar´an funciones y procedimientos, ya que estas
estructuras facilitar´an escribir de forma m´as modular
y comprensible los procesos a realizar; Adem´as, el uso
de funciones y procedimientos facilitar´a la realizaci´on
de pruebas y la correcci´on de errores, elemento important´ısimo a
tener en cuenta en la correcci´on de los algoritmos.

-- 379 of 450 --

378 Vectores y matrices
.:Ejemplo 6.6. Dise˜ne un algoritmo que almacene un grupo de n
n´umeros enteros en un arreglo y luego determine mediante funciones y
procedimientos cu´antos de esos n´umeros ingresados son pares y cu´antos
son impares.
An´alisis del problema:
Resultados esperados: la cantidad de n´umeros pares y de impares
que est´an almacenados en el arreglo de n´umeros.
Datos disponibles: el tama˜no que se le va a dar al arreglo y los
n´umeros enteros que van a ser almacenados en el mismo.
Proceso: solicitar la cantidad de elementos (n), despu´es leer todos
los elementos para el arreglo, posteriormente recorrer el arreglo y
determinar si el elemento que se encuentra en cada posici´on es par;
y si es as´ı, contarlo como par; lo mismo que si es impar. Al final, el
algoritmo mostrar´a el valor con la cuenta final de los n´umeros pares
y con los impares.
Variables requeridas:
• En el algoritmo principal
◦ n: cantidad de elementos del arrreglo a procesar.
◦ numeros: vector que contiene los elementos que el usuario
ingresa.
◦ cantidadPares: cantidad de n´umeros pares que contiene
el vector original.
◦ cantidadImpares: cantidad de n´umeros impares que
contiene el vector original.
• En la funci´on leerDatos
◦ Par´ametros:
 n: cantidad de elementos a leer
◦ Variables locales:
 i: variable de control del ciclo
 arreglo: vector que almacena los datos que el usuario
ingresa.
• En la funci´on obtenerCantidadPares
◦ Par´ametros:
 arreglo: vector que almacena contiene los datos que
el usuario ingresa.

-- 380 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 379
 n: tama˜no del vector.
• En la funci´on obtenerCantidadImpares
◦ Par´ametros:
 arreglo: vector que almacena contiene los datos que
el usuario ingresa.
 n: tama˜no del vector.
En la funci´on contar
• Par´ametros:
◦ arreglo: vector que contiene los datos a ser analizados.
◦ resto: par´ametro que permite especificar si lo que se desea
contar son pares (resto=0) o impares (resto=1). resto
representa el resultado del resto de la divisi´on entera con 2
(arreglo[ i ] % 2 == resto).
◦ n: tama˜no del vector.
• Variables locales:
◦ i: variable de control del ciclo
◦ cantidad: variable que permite contar la cantidad de
pares o impares (dependiendo del valor resto) que hay
en el arreglo
En el procedimiento mostrarResultados
• Par´ametros:
◦ pares: cantidad de n´umeros pares que se encontraron en
el vector.
◦ impares: cantidad de n´umeros impares que se encontraron
en el vector.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.6.
Algoritmo 6.6: numero
1 Algoritmo numero
2 Entero n, numeros [ ], cantidadPares,
3 cantidadImpares
4
5 imprimir( "Ingrese el tama˜no del Arreglo: ")
6 leer( n )
7 numeros = leerDatos( n )
8

-- 381 of 450 --

380 Vectores y matrices
9 cantidadPares = obtenerCantidadPares( numeros, n )
10 cantidadImpares = obtenerCantidadImpares( numeros, n )
11
12 mostrarResultados( cantidadPares, cantidadImpares )
13 FinAlgoritmo
14
15 Funcion Entero[ ] leerDatos( Entero n )
16 Entero i, arreglo[ n ]
17
18 Para i = 1 Hasta n Incremento 1
19 imprimir( "Ingrese el n´umero " , i, ": " )
20 leer( arreglo[ i ] )
21 FinPara
22 Retornar arreglo
23 FinFuncion
24
25
26 Funcion Entero obtenerCantidadPares( Entero arreglo[ ],
27 Entero n )
28 Retornar contar ( arreglo, 0, n )
29 FinFuncion
30
31 Funcion Entero obtenerCantidadImpares( Entero arreglo[ ],
32 Entero n )
33 Retornar contar ( arreglo, 1, n )
34 FinFuncion
35
36 Funcion Entero contar( Entero arreglo[ ],
37 Entero resto,
38 Entero n )
39 Entero i, cantidad
40
41 cantidad = 0
42 Para i = 1 Hasta n Incremento 1
43 Si( arreglo[ i ] % 2 == resto ) Entonces
44 cantidad = cantidad + 1
45 FinSi
46 FinPara
47
48 Retornar cantidad
49 FinFuncion
50
51 Procedimiento mostrarResultados( Entero pares,
52 Entero impares )
53 imprimir( "Cantidad de pares : ", pares )
54 imprimir( "Cantidad de impares: ", impares )
55 FinProcedimiento

-- 382 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 381
Al ejecutar el algoritmo:
Ingrese el tama˜no del Arreglo: 5
Ingrese el n´umero 1: 4
Ingrese el n´umero 2: 71
Ingrese el n´umero 3: 22
Ingrese el n´umero 4: 15
Ingrese el n´umero 5: 78
Cantidad de pares : 3
Cantidad de impares: 2
Explicaci´on del algoritmo:
Este algoritmo se construy´o de la siguiente forma:
Se cre´o un algoritmo principal en el que se declararon las variables,
se solicit´o el tama˜no del vector y se hizo el llamado a: leerDatos(),
obtenerCantidadPares(), obtenerCantidadImpares(), (las
dos ´ultimas invocan a la funci´on contar()) y un procedimiento
denominado mostrarResultados(). Luego de solicitar el tama˜no del
vector, este dato se env´ıa como par´ametro a la funci´on leerDatos(n),
la cual se usa para crear un nuevo vector, llenarlo con la informaci´on
que el usuario ingresa y retornarlo, el valor de retorno es almacenado en
la variable numero. A continuaci´on, se explica una a una cada funci´on
utilizada y el procedimiento que muestra los resultados.
2 Entero n, numeros [ ], cantidadPares,
3 cantidadImpares
4
5 imprimir( "Ingrese el tama˜no del Arreglo: ")
6 leer( n )
7 numeros = leerDatos( n )
8
9 cantidadPares = obtenerCantidadPares( numeros, n )
10 cantidadImpares = obtenerCantidadImpares( numeros, n )
11
12 mostrarResultados( cantidadPares, cantidadImpares )
La funci´on leerDatos(), se utiliza para capturar los datos ingresados
y almacenarlos en cada una de las posiciones del vector; por esta raz´on,
en ella se usa un ciclo Para, que inicia la variable i en 1 y va hasta el
tama˜no del vector (n). Dentro del ciclo, con las instrucciones de imprimir
y leer se solicitan los datos y se almacenan en cada celda del vector.
Esta funci´on recibe como par´ametro el tama˜no del vector para inicializar
el vector interno, llenarlo y retornarlo al final de la funci´on.

-- 383 of 450 --

382 Vectores y matrices
15 Funcion Entero[ ] leerDatos( Entero n )
16 Entero i, arreglo[ n ]
17
18 Para i = 1 Hasta n Incremento 1
19 imprimir( "Ingrese el n´umero " , i, ": " )
20 leer( arreglo[ i ] )
21 FinPara
22 Retornar arreglo
23 FinFuncion
La funci´on que cuenta los pares obtenerCantidadPares() y la
funci´on que cuenta los impares obtenerCantidadImpares() son en
realidad casos especiales de una funci´on m´as general llamada contar().
La ´unica diferencia que existe entre ambas funciones es el valor del resto
de la divisi´on entera con dos. Para el caso de los pares el resto es cero,
mientras que para el caso de los impares el resto es 1.
La funci´on, obtenerCantidadPares( numeros, n ) tiene como
par´ametros la referencia al vector de n´umeros y el tama˜no del mismo. Esta
funci´on hace el llamado a la funci´on contar() pas´andole la referencia al
vector de n´umeros, el cero y el tama˜no del vector. El cero ser´a el par´ametro
que permite contar cuantos n´umeros pares hay en el vector.
Igual sucede con la funci´on obtenerCantidadImpares(numeros,
n) que tiene los mismos par´ametros, y que llama a la funci´on contar()
pero pasando esta vez un uno en lugar de un cero.
26 Funcion Entero obtenerCantidadPares( Entero arreglo[ ],
27 Entero n )
28 Retornar contar ( arreglo, 0, n )
29 FinFuncion
31 Funcion Entero obtenerCantidadImpares( Entero arreglo[ ],
32 Entero n )
33 Retornar contar ( arreglo, 1, n )
34 FinFuncion
La funci´on contar() recibe como par´ametro el vector, un valor resto
el cual se utiliza para determinar si el n´umero almacenado es par(0) o
impar(1) y, el tama˜no del vector. La funci´on inicializa un contador llamado
cantidad en cero, luego recorre todo el arreglo verificando si el n´umero
es par o impar, de ser Verdadera la condici´on del Si, se cuenta uno m´as.
Al final, simplemente se retorna el valor de la variable cantidad.

-- 384 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 383
36 Funcion Entero contar( Entero arreglo[ ],
37 Entero resto,
38 Entero n )
39 Entero i, cantidad
40
41 cantidad = 0
42 Para i = 1 Hasta n Incremento 1
43 Si( arreglo[ i ] % 2 == resto ) Entonces
44 cantidad = cantidad + 1
45 FinSi
46 FinPara
47
48 Retornar cantidad
49 FinFuncion
Por ´ultimo, el procedimiento mostrarResultados(), recibe como
par´ametros la cantidad de pares y de impares encontrados en el arreglo y
los muestra mediante las instrucciones imprimir que est´an dentro de la
funci´on.
.:Ejemplo 6.7. Escribir un algoritmo que almacene en un arreglo
unidimensional las notas finales obtenidas por un grupo de 20 estudiantes
en una materia cualquiera y, a trav´es de funciones, determine el promedio
del grupo, la nota m´as alta y m´as baja obtenida en la materia.
Aclaraci´on:
Este problema consiste en hacer varios recorridos por
el vector cuando este ya se encuentre lleno con las
notas de los estudiantes para determinar el promedio
y las notas m´as alta y baja del grupo. Por esta raz´on,
es recomendable resolver el ejercicio por medio de
funciones, ya que cada una de ellas resolver´a una tarea en particular.
El ejercicio se encuentra planteado para un grupo de 20 estudiantes,
pero perfectamente se puede adaptar a un grupo de n estudiantes
tal como se ha hecho en los ejercicios anteriores.
An´alisis del problema:
Resultados esperados: mostrar la nota promedio del grupo de
estudiantes, la mayor y menor nota obtenidas entre las 20 que
conforman el grupo.
Datos disponibles: las 20 notas de los estudiantes.

-- 385 of 450 --

384 Vectores y matrices
Proceso: lo primero que se hace en este algoritmo es solicitar las 20
notas al usuario y almacenarlas en el vector. Posteriormente, para
encontrar la nota promedio del grupo, se recorre el vector, se suman
todas las notas y se divide esta suma entre los 20 estudiantes; esto
implica utilizar un ciclo que facilite el recorrido por las distintas
posiciones del vector y el uso de una variable de tipo acumulador en
la que se van sumando las notas. Tambi´en se debe recorrer el vector
con el fin de identificar la nota m´as alta y la m´as baja que est´en
almacenadas en ´el; para determinar la nota m´as alta, se compara la
nota almacenada en la primera posici´on del arreglo con la segunda
para saber cu´al es mayor, luego la segunda con la tercera y as´ı
sucesivamente hasta llegar a la ´ultima nota, lo que implica el uso
de una estructura de decisi´on. De la misma forma se hace si se desea
conocer la nota m´as baja, en este caso la comparaci´on con el Si entre
las dos notas se lleva a cabo para conocer la menor nota. Tenga en
cuenta que, como el ejercicio se est´a desarrollando para un grupo de
20 estudiantes, se usa una constante que contenga este valor durante
todo el algoritmo.
Variables requeridas:
• En el algoritmo principal
◦ MAX: constante que almacena la cantidad de estudiantes,
para el ejemplo son 20.
◦ arrregloNotas: vector que contiene las notas de los
estudiantes.
◦ notaMayor: almacena la menor nota entre todas las
ingresadas.
◦ notaMenor: almacena la mayor nota de los estudiantes.
◦ notaPromedio: almacena la nota promedio del grupo de
estudiantes.
• En la funci´on leerDatos
◦ Par´ametros:
 tamanio: cantidad de elementos a leer
◦ Variables locales:
 i: variable de control del ciclo
 arreglo: vector que almacena las notas que el usuario
ingresa.
• En la funci´on calcularPromedio
◦ Par´ametros:

-- 386 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 385
 arregloNotas: vector que almacena las notas de los
estudiantes.
 n: tama˜no del vector.
◦ Variables locales:
 i: variable de control del ciclo.
 suma: variable para almacenar la suma de todas las
notas.
 promedio: variable para almacenar el promedio de las
notas.
• En la funci´on obtenerMayor
◦ Par´ametros:
 arregloNotas: vector que almacena las notas de los
estudiantes.
 n: tama˜no del vector.
◦ Variables locales:
 i: variable de control del ciclo.
 mayor: variable para almacenar el mayor valor del
arreglo de notas.
• En la funci´on obtenerMenor
◦ Par´ametros:
 arregloNotas: vector que almacena las notas de los
estudiantes.
 n: tama˜no del vector.
◦ Variables locales:
 i: variable de control del ciclo.
 menor: variable para almacenar el menor valor del
vector de notas.
En el procedimiento mostrarResultados
• Par´ametros:
◦ promedio: promedio de las notas de los estudiantes.
◦ mayor: mayor nota de los estudiantes.
◦ menor: menor nota de los estudiantes.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.7.

-- 387 of 450 --

386 Vectores y matrices
Algoritmo 6.7: NotasMateria
1 Algoritmo NotasMateria
2 Constante Entero MAX = 20
3 Real arregloNotas [ ], notaPromedio, notaMayor, notaMenor
4
5 arregloNotas = leerDatos( MAX )
6 notaPromedio = calcularPromedio( arregloNotas, MAX )
7 notaMayor = obtenerMayor( arregloNotas, MAX )
8 notaMenor = obtenerMenor( arregloNotas, MAX )
9
10 mostrarResultados( notaPromedio, notaMayor, notaMenor )
11 FinAlgoritmo
12
13 Funcion Real[ ] leerDatos( Entero tamanio )
14 Real arreglo[ tamanio ]
15 Entero i
16
17 Para i = 1 Hasta tamanio Incremento 1
18 imprimir( "Ingrese el nota del estudiante " , i, ": " )
19 leer( arreglo[ i ] )
20 FinPara
21 Retornar arreglo
22 FinFuncion
23
24 Funcion Real calcularPromedio( Real arregloNotas[ ],
25 Entero n )
26 Entero i
27 Real suma = 0
28 Real promedio
29
30 Para i = 1 Hasta n Incremento 1
31 suma = suma + arregloNotas[ i ]
32 FinPara
33
34 promedio = suma / n
35 Retornar promedio
36 FinFuncion
37
38 Funcion Real obtenerMayor( Real arregloNotas[ ], Entero n )
39 Entero i
40 Real mayor = arregloNotas[ 1 ]
41
42 Para i = 2 Hasta n Incremento 1
43 Si arregloNotas[ i ] > mayor Entonces
44 mayor = arregloNotas[ i ]
45 FinSi
46 FinPara
47 Retornar mayor
48 FinFuncion

-- 388 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 387
49
50 Funcion Real obtenerMenor( Real arregloNotas[ ], Entero n )
51 Entero i
52 Real menor = arregloNotas[ 1 ]
53
54 Para i = 2 Hasta n Incremento 1
55 Si arregloNotas[ i ] < menor Entonces
56 menor = arregloNotas[ i ]
57 FinSi
58 FinPara
59 Retornar menor
60 FinFuncion
61
62 Procedimiento mostrarResultados( Entero promedio,
63 Entero mayor,
64 Entero menor )
65 imprimir( "Promedio del grupo: ", promedio )
66 imprimir( "Nota m´as alta obtenida: ", mayor )
67 imprimir( "Nota m´as baja obtenida: ", menor )
68 FinProcedimiento
Explicaci´on del algoritmo:
Este algoritmo fue desarrollado mediante funciones y procedimientos
que son llamados desde el algoritmo principal. En este algoritmo principal,
primero se declaran las variables y posteriormente se hace el llamado a las
distintas funciones en el siguiente orden:
La primera funci´on, leerDatos(), permite obtener las notas del
usuario y almacenarlas en el arreglo de notas. Esta funci´on tiene un
par´ametro que permite asignarle el tama˜no al arreglo y funciona de
la misma forma en que se explic´o en el ejercicio anterior.
En seguida se hace el llamado a La funci´on calcularPromedio(),
la cual recibe como par´ametros el arreglo de notas y su tama˜no. El
arreglo se recorre desde la primera hasta la ´ultima posici´on por medio
de un ciclo Para y, mediante la variable suma va acumulando la
suma de las notas, es por eso que esta variable se inicializa en cero
antes de ingresar al ciclo Para. Al terminar el recorrido y debajo del
FinPara, se calcula el promedio de notas del grupo dividiendo la
suma entre el n´umero de estudiantes, o sea, 20, representado por la
variable n.

-- 389 of 450 --

388 Vectores y matrices
A continuaci´on se llama a la funci´on obtenerMayor() que recibe
como par´ametros el arreglo de notas y su tama˜no. Esta funci´on
almacena la primera posici´on del arreglo en la variable mayor y luego
recorre el arreglo desde la posici´on 2 hasta la ´ultima posici´on (20).
Este recorrido se hace mediante el ciclo Para. Dentro del ciclo, se va
comparando la posici´on actual del arreglo con la variable mayor. Si
lo que posee la posici´on actual del arreglo es mayor que la variable
mayor, esta posici´on se almacena en la variable mayor y el algoritmo
pasa a la pr´oxima iteraci´on. Si la posici´on actual del arreglo no
contiene una nota mayor que la que est´a almacenada en la variable
mayor, el ciclo pasa a la siguiente iteraci´on, donde se ubica en la
siguiente posici´on del vector y vuelve a comparar. Al terminar el
recorrido del vector, esta funci´on obtendr´a la mayor nota del arreglo
y la retornar´a al algoritmo principal.
Del mismo modo trabaja la funci´on obtenerMenor(), que es la
siguiente instrucci´on en el algoritmo principal, pero dentro de esta
funci´on se cambia la comparaci´on que se hace al interior del ciclo
Para, con el fin de saber si lo que posee la posici´on actual del
vector es menor que lo que tiene almacenado la variable menor.
Esta funci´on retornar´a la menor nota almacenada en el vector.
Por ´ultimo, el procedimiento mostrarResultados(), permite
mostrar la nota promedio del grupo, la mayor nota y la menor nota
almacenadas en el vector, siendo estos los par´ametros que recibi´o
la funci´on y que muestra mediante las instrucciones imprimir que
est´an en su interior.
.:Ejemplo 6.8. Dise˜ne un algoritmo que almacene en vectores el nombre y
el g´enero de un grupo de n personas y, que a trav´es de funciones permita
buscar la posici´on del vector en que se encuentra una persona cualquiera,
buscada por su nombre y el g´enero que esta persona tiene. Con objeto de
almacenar los g´eneros de manera ´optima, utilice una ’M’ para Masculino
y una ’F’ para femenino.
An´alisis del problema:
Resultados esperados: mostrar la posici´on en la que est´a en el
vector de nombres y su g´enero, una persona consultada por su
nombre.

-- 390 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 389
Datos disponibles: el tama˜no de los vectores, los nombres y g´eneros
de las n personas, as´ı como el nombre de la persona que se va a buscar,
una vez ya est´en cargados los vectores con los datos.
Proceso: luego de almacenar nombres y g´eneros, el algoritmo debe
buscar la posici´on que ocupa el nombre de una persona en el
vector de nombres, esto se lleva a cabo por medio de una b´usqueda
por todo el vector de nombres desde la primera hasta la ´ultima
posici´on utilizando un ciclo y una estructura de decisi´on. Si el
nombre de esta persona se encuentra almacenado, el algoritmo debe
mostrar la posici´on que ocupa ese nombre en el vector y su g´enero
correspondiente, que est´a almacenado en el vector de g´eneros. Para
este ejercicio, es necesario suponer que cada nombre se almacena una
sola vez. Si el nombre buscado est´a almacenado en varias posiciones
del arreglo, el algoritmo reporta la posici´on del ´ultimo de ellos.
Variables requeridas:
• En el algoritmo principal
◦ tamanio: cantidad de personas de las que se conoce la
informaci´on.
◦ posicion: posici´on que ocupa la persona buscada en el
vector de nombres.
◦ nombreBuscar: nombre de la persona que se desea buscar.
◦ arregloNombres: vector con los nombres de las personas.
◦ arregloGeneros: vector con los g´eneros de las personas.
• En la funci´on leerNombres
◦ Par´ametros:
 tamanio: cantidad de elementos a leer.
◦ Variables locales:
 i: variable de control del ciclo.
 arregloNom: vector que almacena los nombres
ingresados.
• En la funci´on leerGeneros
◦ Par´ametros:
 tamanio: cantidad de elementos a leer.
◦ Variables locales:
 i: variable de control del ciclo.
 arregloG: vector que almacena los g´eneros de las
personas ingresadas.

-- 391 of 450 --

390 Vectores y matrices
• En la funci´on obtenerPosicion
◦ Par´ametros:
 arregloNom: arreglo con los nombre de las personas.
 nombre: nombre de la persona que se desea buscar.
 tamanio: cantidad de elementos del vector.
◦ Variables locales:
 i: variable de control del ciclo.
 pos: variable que almacena la posici´on del vector en
donde se encuentra el nombre buscado o, -1 de no estar
presente.
• En el procedimiento mostrarResultados
◦ Par´ametros:
 pos: posici´on en donde se encuentra el nombre, o en su
defecto, -1 de no estar presente.
 arregloN: vector con los nombres de las personas.
 arregloG: vector con los gen´eros de las personas.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.8.
Algoritmo 6.8: ArregloPersonas
1 Algoritmo ArregloPersonas
2 Entero tamanio, posicion
3 Cadena nombreBuscar , arregloNombres [ ]
4 Caracter arregloGeneros [ ]
5
6 imprimir( "Ingrese la cantidad de personas " )
7 leer( tamanio )
8
9 arregloNombres = leerNombres( tamanio )
10 arregloGeneros = leerGeneros( tamanio )
11
12 imprimir( "Ingrese el nombre de la persona a buscar: " )
13 leer( nombreBuscar )
14
15 posicion = obtenerPosicion(arregloNombres, nombreBuscar,
tamanio )
16
17 mostrarResultados( posicion, arregloNombres,
arregloGeneros )
18 FinAlgoritmo
19

-- 392 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 391
20 Funcion Cadena[ ] leerNombres( Entero tamanio )
21 Entero i
22 Cadena arregloNom[ tamanio ]
23
24 Para i = 1 Hasta tamanio Incremento 1
25 imprimir( "Ingrese el nombre de la persona " , i, ": ")
26 leer( arregloNom[ i ] )
27 FinPara
28 Retornar arregloNom
29 FinFuncion
30
31 Funcion Caracter[ ] leerGeneros( Entero tamanio )
32 Entero i
33 Caracter arregloG[ tamanio ]
34
35 Para i = 1 Hasta tamanio Incremento 1
36 Haga
37 imprimir( "G´enero de la persona " , i," (M/F): " )
38 leer( arregloG[ i ] )
39
40 Si( arregloG[ i ] != ’F’ Y
41 arregloG[ i ] != ’M’ ) Entonces
42 imprimir( "Ha ingresado un g´enero equivocado" )
43 FinSi
44 MientrasQue(arregloG[ i ] != ’F’ Y arregloG[ i ]!= ’M’)
45 FinPara
46 Retornar arregloG
47 FinFuncion
48
49 Funcion Entero obtenerPosicion( Cadena arregloNom [ ],
50 Cadena nombre,
51 Entero tamanio )
52 Entero i, pos
53
54 pos = -1
55 Para i = 1 Hasta tamanio Incremento 1
56 Si arregloNom[ i ] == nombre Entonces
57 pos = i
58 FinSi
59 FinPara
60 Retornar pos
61 FinFuncion
62
63 Procedimiento mostrarResultados( Entero pos,
64 Cadena arregloN [ ],
65 Caracter arregloG [ ] )
66 Si( pos == -1 ) Entonces
67 imprimir( "El nombre no est´a en la lista ")
68 SiNo

-- 393 of 450 --

392 Vectores y matrices
69 imprimir( arregloN[ pos ] )
70 imprimir( "est´a en la posici´on ", pos )
71 imprimir( "y su gen´ero es ", arregloG[ pos ] )
72 FinSi
73 FinProcedimiento
Explicaci´on del algoritmo:
En el algoritmo principal:
Primero se declaran las variables necesarias para almacenar los datos
que se van a ingresar (l´ıneas 2 a la 4).
Luego, se solicita el tama˜no de los vectores, lo que equivale a solicitar
el n´umero de personas a procesar (l´ıneas 6 y 7).
A continuaci´on, se hace el llamado a las funciones, leerNombres()
y leerGeneros() (l´ıneas 9 y 10), que se utilizan para pedir los
datos de las personas y almacenarlos en los arreglos respectivos.
La funci´on leerGeneros() implementa una validaci´on haciendo
uso del ciclo Haga-MientrasQue, que obliga al usuario a ingresar
solo una ’F’ de g´enero Femenino o una ’M’ de g´enero Masculino.
Posteriormente, se solicita el nombre de la persona que se va a buscar
entre los datos ya almacenados en el vector de nombres.
Mediante la funci´on obtenerPosicion() se busca la posici´on en
la que se supone debe estar el nombre de la persona que se est´a
buscando y que se pasa como par´ametro. Esta funci´on trabaja de la
siguiente forma:
• La funci´on recorre el vector de nombres a trav´es de un ciclo
Para. Previo al ciclo se ha inicializado la variable pos en -1, lo
que indica que no se tiene una posici´on v´alida del arreglo para
retornar, pues todav´ıa no se ha llevado a cabo la b´usqueda y
no se ha encontrado ning´un nombre. Se utiliza la instrucci´on
Si dentro del ciclo Para con el fin de determinar si el nombre
buscado es igual al que est´a almacenado en la posici´on actual del
arreglo; si esto llegase a ocurrir, la variable pos ubicada dentro
de la estructura Si almacena la posici´on donde se encuentra el
nombre.
• En la parte final de la funci´on obtenerPosicion() se
retorna la posici´on (variable pos) donde est´a el nombre del
estudiante que se busc´o en el arreglo. Si la funci´on no encontr´o

-- 394 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 393
el nombre buscado, la variable pos retornar´a el -1 con que se
inicializ´o.
Por ´ultimo, en el algoritmo principal se hace el llamado al
procedimiento mostrarResultados(), el cual recibe como
par´ametros la posici´on encontrada por la funci´on anterior, el vector
de nombres y el vector de g´eneros. Con estos datos, el procedimiento
muestra el nombre, la posici´on y el g´enero de la persona que coincida
con el nombre buscado; si el contenido de la variable pos es igual a
-1, esto quiere decir que no se encontr´o el nombre, en cuyo caso se
imprime un mensaje informando este hecho.
.:Ejemplo 6.9. Construya un algoritmo utilizando funciones,
procedimientos y vectores para ingresar y almacenar las estaturas y los
g´eneros de un conjunto de n personas y despu´es determine el promedio de
estaturas de las mujeres y el porcentaje de hombres ingresados.
An´alisis del problema:
Resultados esperados: el promedio de las estaturas de las mujeres
y el porcentaje de hombres que se han ingresado y que est´an
almacenados en el arreglo.
Datos disponibles: se conocen previamente, la cantidad de
personas que se van a procesar, la estatura y el g´enero de las mismas.
Proceso: este algoritmo debe tener en primer lugar, una funci´on
que permita ingresar los datos de las n personas y almacenarlos en
los arreglos respectivos. En segundo lugar, debe implementar una
funci´on para obtener el promedio de las estaturas de las mujeres
sumando solo las estaturas de las personas con g´enero femenino
y dividiendo entre el total de estas. Otra funci´on que debe tener
el algoritmo, es la que determina el porcentaje de hombres que se
ingresaron; para ello, se debe contar el n´umero de personas con
g´enero masculino y dividirlo entre el total de personas ingresadas.
Por ´ultimo, el algoritmo deber´a mostrar los resultados que se han
obtenido.
Variables requeridas:
• En el algoritmo principal

-- 395 of 450 --

394 Vectores y matrices
◦ numeroPersonas: cantidad de personas de las que se
conoce la informaci´on
◦ arregloEstatura: arreglo que contiene todas las
estaturas
◦ arregloGenero: arreglo con los g´eneros de las personas.
◦ promEstMujeres: variable para almacenar el promedio
de las estaturas de todas las mujeres.
◦ porcHombres: variable para almacenar el porcentaje de
hombres en el vector.
• En la funci´on leerEstaturas
◦ Par´ametros:
 tamanio: cantidad de elementos a leer.
◦ Variables locales:
 i: variable de control del ciclo.
 arregloE: vector que almacena las estaturas.
• En la funci´on leerGeneros
◦ Par´ametros:
 tamanio: cantidad de elementos a leer.
◦ Variables locales:
 i: variable de control del ciclo.
 arregloG: vector que almacena los g´eneros de las
personas ingresadas.
• En la funci´on obtenerPromedio
◦ Par´ametros:
 arregloE: vector con las estaturas de las personas.
 arregloG: vector con los g´eneros de las personas.
 tamanio: cantidad de elementos de los vectores.
◦ Variables locales:
 i: variable de control del ciclo.
 suma: variable que almacena la suma de las estaturas
de las mujeres.
 promedio: variable que almacena el promedio de las
estaturas de las mujeres.
 contadorMujeres: variable para almacenar la
cantidad de mujeres en el arreglo.
• En la funci´on obtenerPorcentajeHombres
◦ Par´ametros:

-- 396 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 395
 arregloG: vector con los g´eneros de las personas.
 tamanio: cantidad de elementos de los vectores.
◦ Variables locales:
 i: variable de control del ciclo.
 hombres: cantidad de hombres en el arreglo.
 porcentaje: variable que almacena el porcentaje de
hombres que hay en el vector.
• En el procedimiento mostrarResultados
◦ Par´ametros:
 promEstatura: promedio de las estaturas de las
mujeres.
 porcHombres: porcentaje de hombres en el arreglo.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.9.
Algoritmo 6.9: ArregloPersonas
1 Algoritmo ArregloPersonas
2 Entero numeroPersonas
3 Real arregloEstatura [ ]
4 Caracter arregloGenero [ ]
5 Real promEstMujeres, porcHombres
6
7 imprimir( "Ingrese la cantidad de personas " )
8 leer( numeroPersonas )
9
10 arregloEstatura = leerEstaturas( numeroPersonas )
11 arregloGenero = leerGeneros( numeroPersonas )
12
13 promEstMujeres = obtenerPromedio ( arregloEstatura,
14 arregloGenero,
numeroPersonas )
15
16 porcHombres = obtenerPorcentajeHombres( arregloGenero,
17 numeroPersonas )
18
19 mostrarResultados( promEstMujeres, porcHombres )
20 FinAlgoritmo
21
22 Funcion Real[ ] leerEstaturas( Entero tamanio )
23 Entero i
24 Real arregloE [ tamanio ]
25
26 Para i = 1 Hasta tamanio Incremento 1
27 imprimir( "Ingrese estatura de la persona " , i )
28 leer( arregloE[ i ] )

-- 397 of 450 --

396 Vectores y matrices
29 FinPara
30 Retornar arregloE
31 FinFuncion
32
33 Funcion Caracter[ ] leerGeneros( Entero tamanio )
34 Entero i
35 Caracter arregloG [ tamanio ]
36
37 Para i = 1 Hasta tamanio Incremento 1
38 imprimir( "Ingrese el g´enero de la persona: F
Femenino, M Masculino " , i )
39 leer( arregloG[ i ] )
40 FinPara
41 Retornar arregloG
42 FinFuncion
43
44 Funcion Real obtenerPromedio( Real arregloE [ ],
45 Caracter arregloG [ ],
46 Entero tamanio )
47 Real suma
48 Real promedio
49 Entero contadorMujeres, i
50
51 suma = 0
52 contadorMujeres = 0
53 Para i = 1 Hasta tamanio Incremento 1
54 Si( arregloG[ i ] == ’F’ ) Entonces
55 suma = suma + arregloE[ i ]
56 contadorMujeres = contadorMujeres + 1
57 FinSi
58 FinPara
59
60 promedio = suma / contadorMujeres
61 Retornar promedio
62 FinFuncion
63
64 Funcion Real obtenerPorcentajeHombres( Caracter arregloG[ ],
65 Entero tamanio )
66 Entero hombres, i
67 Real porcentaje
68
69 hombres = 0
70 Para i = 1 Hasta tamanio Incremento 1
71 Si( arregloG[ i ] == ’M’ ) Entonces
72 hombres = hombres + 1
73 FinSi
74 FinPara
75
76 porcentaje = (hombres / tamanio) * 100

-- 398 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 397
77 Retornar porcentaje
78 FinFuncion
79
80 Procedimiento mostrarResultados( Real promEstatura,
81 Real porcHombres )
82 imprimir( "Estatura promedio (mujeres): ", promEstatura)
83 imprimir( "Porcentaje de hombres: ", porcHombres )
84 FinProcedimiento
Explicaci´on del algoritmo:
En el algoritmo principal, se solicita el ingreso del n´umero de
personas que se van a procesar y este dato se almacena en la variable
numeroPersonas, misma con la que se inicializan los vectores en los que
se guardar´an las estaturas y los g´eneros de las personas.
Posteriomente, se invocan las funciones leerEstaturas() y
leerGeneros() con las que se hace la lectura de los datos y se almacenan
en las diferentes posiciones de los vectores de estaturas y de g´eneros.
Luego, se hace el llamado a la funci´on obtenerPromedio(), la cual
calcula el promedio de estaturas de las mujeres recorriendo el vector de
estaturas a trav´es de un ciclo Para; dentro de este ciclo, se pregunta
mediante un Si si el g´enero que se encuentra en la posici´on i del vector
de g´eneros corresponde a un g´enero femenino; de ser as´ı, se acumula la
estatura correspondiente que est´a en el vector de estaturas en la variable
suma y se cuenta una mujer mas. Al finalizar este ciclo, se calcula
el promedio de estaturas dividendo la variable suma entre la variable
contadorMujeres y se retorna este resultado.
Acto seguido, se invoca la funci´on obtenerPorcentajeHombres(),
que tambi´en utiliza un ciclo Para con el prop´osito de recorrer el vector
de g´eneros e ir contando mediante un Si, la cantidad de hombres que hay
en el arreglo; una vez obtenida esta cantidad, se divide entre el n´umero
de personas que hay y se multiplica este valor por 100.00 para obtener el
respectivo porcentaje y poderlo retornar.
Al finalizar, con el procedimiento mostrarResultados(), se
muestran: promedio de estaturas de las mujeres y el porcentaje de hombres.
.:Ejemplo 6.10. Construya un algoritmo utilizando funciones y
procedimientos que almacene en un arreglo 4 n´umeros enteros y luego
ordene estos n´umeros de menor a mayor utilizando el m´etodo de
ordenamiento denominado “M´etodo de la burbuja”. El algoritmo debe

-- 399 of 450 --

398 Vectores y matrices
mostrar el arreglo con los datos ingresados inicialmente (en desorden) y el
arreglo con los datos ya ordenados.
An´alisis del problema:
Resultados esperados: se pretende que el algoritmo muestre un
arreglo de n´umeros enteros ordenados de menor a mayor, es decir, en
orden ascendente.
Datos disponibles: Los 4 n´umeros enteros que se van a almacenar
en el arreglo.
Proceso: primero se solicitan los 4 n´umeros al usuario y se
almacenan en el vector, luego se imprime el vector original con
los n´umeros en desorden, a continuaci´on, se aplica el m´etodo de la
“burbuja” al vector y finalmente se vuelve a imprimir este vector.
Este orden es importante porque el ordenamiento altera la posici´on
de los elementos dentro del vector, impidiendo imprimir el vector
original una vez se ordena. Por supuesto, es posible sacar una copia
del vector, ordenar la copia e imprimir los dos vectores; tambi´en
es posible modificar el algoritmo de ordenamiento para retornar un
nuevo vector con los ´ındices sin alterar los datos originales6 que
indique en que orden se deben mostrar los elementos del vector.
Antes de resolver el ejemplo, es necesario comprender tres conceptos:
Primero, un algoritmo de ordenamiento tiene como finalidad recibir
un conjunto de datos y entregarlos ordenados en forma ascendente o
descendente seg´un se especifique.
Segundo, existen diversas formas de realizar esta tarea de
ordenamiento, una de ellas es la denominada “Burbuja”.
Tercero, el algoritmo de ordenamiento “M´etodo de la burbuja” tiene
a su vez diversas formas de ser escrito. A continuaci´on se presenta
una de estas formas. Por medio de un ejemplo se ilustrar´a su
funcionamiento, el cual consiste en ordenar un arreglo con los datos
enteros: 7 2 8 1.
En esta versi´on del “M´etodo de la burbuja” se requieren dos ciclos7,
el primer ciclo se encarga de indicar la posici´on del primer elemento
6Un vector de indices es interesante porque permite construir diversos vectores
que sirvan para recorrer un mismo vector, as´ı es posible recorrer un vector de forma
ascendente, descendente, . . .
7normalmente se emplea el ciclo Para

-- 400 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 399
a ser comparado (c´ırculo de donde sale la flecha), el segundo ciclo
indica la posici´on del segundo elemento con el que hay que comparar
el primero (c´ırculo donde llega la flecha); en cada comparaci´on
se verifica si el primer n´umero es mayor al segundo, de serlo, se
intercambian de posici´on, en otro caso, se contin´ua con el siguiente
n´umero. Una vez se ha comparado el elemento que indica el primer
ciclo con todas las posiciones, se contin´ua con la siguiente en el primer
ciclo y as´ı hasta llegar a la pen´ultima posici´on8.
Ejemplo de ordenamiento
arreglo − > 7 2 8 1
Ciclo1 Ciclo2 Comparaci´on
1
2 7 2 8 1
3 2 7 8 1
4 2 7 8 1
2 3 1 7 8 2
4 1 7 8 2
3 4 1 2 8 7
arreglo − > 1 2 7 8
Variables requeridas:
• En el algoritmo principal
◦ Constante requerida:
 MAX: constante igual a 4
◦ Variable:
 numero: vector con los MAX n´umeros a ordenar.
8Es la ´ultima comparaci´on posible, la pen´ultima posici´on con la ´ultima.

-- 401 of 450 --

400 Vectores y matrices
• En la funci´on leerArreglo
◦ Par´ametros:
 tamanio: cantidad de elementos del vector.
◦ Variables locales:
 i: variable de control del ciclo.
 arregloE: vector que almacena los n´umeros enteros
que el usuario ingres´o.
• En la funci´on imprimirArreglo
◦ Par´ametros:
 titulo: texto que se muestra con los datos del vector.
 arreglo: vector que almacena los n´umeros enteros que
el usuario ingres´o.
 n: tama˜no del arreglo.
◦ Variables locales:
 i: variable de control del primer ciclo.
 cadena: variable que almacena todos los elementos de
un arreglo en una Cadena mediante concatenaci´on de
los elementos.
• En la funci´on ordenarBurbuja
◦ Par´ametros:
 arreglo: arreglo que almacena los n´umeros enteros
que el usuario ingres´o.
 n: tama˜no del vector.
◦ Variables locales:
 i: variable de control del primer ciclo.
 j: variable de control del segundo ciclo.
 auxiliar: variable necesaria para intercambiar dos
posiciones del vector.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.10.
Algoritmo 6.10: OrdenamientoBurbuja
1 Algoritmo OrdenamientoBurbuja
2 Constante Entero MAX = 4
3 Entero numero [ ]
4
5 numero = leerArreglo( MAX )
6
7 imprimirArreglo( "Arreglo original: ", numero, MAX )

-- 402 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 401
8
9 ordenarBurbuja( numero, MAX )
10
11 imprimirArreglo( "Arreglo ordenado: ", numero, MAX )
12 FinAlgoritmo
13
14 Funcion Entero [ ] leerArreglo( Entero tamanio )
15 Entero i
16 Entero arregloE[ tamanio ]
17
18 Para i = 1 Hasta tamanio Incremento 1
19 imprimir( "Ingrese el n´umero " , i, ": " )
20 leer( arregloE[ i ] )
21 FinPara
22 Retornar arregloE
23 FinFuncion
24
25 Procedimiento imprimirArreglo( Cadena titulo,
26 Entero arreglo [ ],
27 Entero n )
28 Entero i
29 Cadena cadena
30
31 Para i = 1 Hasta n Incremento 1
32 cadena = cadena + arreglo[ i ] + " "
33 FinPara
34
35 imprimir( titulo, cadena )
36 FinFuncion
37
38 Procedimiento ordenarBurbuja( Entero arreglo[ ], Entero n)
39 Entero i, j
40 Entero auxiliar
41
42 Para i = 1 Hasta n - 1 Incremento 1
43 Para j = i + 1 Hasta n Incremento 1
44 Si( arreglo[ i ] > arreglo[ j ] Entonces
45 auxiliar = arreglo[ i ]
46 arreglo[ i ] = arreglo[ j ]
47 arreglo[ j ] = auxiliar
48 FinSi
49 FinPara
50 FinPara
51 FinProcedimiento
Explicaci´on del algoritmo:
Inicialmente se declaran las variables necesarias para el algoritmo. Luego,
se llama a la funci´on leerArreglo(), que se utiliza para capturar los

-- 403 of 450 --

402 Vectores y matrices
MAX n´umeros enteros (4) y almacenarlos en el vector.
2 Constante Entero MAX = 4
3 Entero numero [ ]
4
5 numero = leerArreglo( MAX )
Posteriormente, se procede a imprimir el vector mediante el
procedimiento imprimirArreglo(), a coontinuaci´on, se invoca la
funci´on ordenarBurbuja(), que es la encargada de realizar el
ordenamiento de los elementos del vector, y finalmente se vuelve a imprimir
el vector ya ordenado.
7 imprimirArreglo( "Arreglo original: ", numero, MAX )
8
9 ordenarBurbuja( numero, MAX )
10
11 imprimirArreglo( "Arreglo ordenado: ", numero, MAX )
Se observa que la forma en que se implementa el algoritmo de
ordenamiento coincide con la explicaci´on hecha en el an´alisis.
38 Procedimiento ordenarBurbuja( Entero arreglo[ ], Entero n)
39 Entero i, j
40 Entero auxiliar
41
42 Para i = 1 Hasta n - 1 Incremento 1
43 Para j = i + 1 Hasta n Incremento 1
44 Si( arreglo[ i ] > arreglo[ j ] Entonces
45 auxiliar = arreglo[ i ]
46 arreglo[ i ] = arreglo[ j ]
47 arreglo[ j ] = auxiliar
48 FinSi
49 FinPara
50 FinPara
51 FinProcedimiento
Como se mencion´o antes, en la funci´on ordenarBurbuja(), se usan
dos ciclos; el primero recorre las posiciones del vector, desde la primera
hasta la pen´ultima y el segundo arranca en la segunda posici´on; lo que
permite comparar en un principio la primera con la segunda posici´on del
vector, luego la primera con la tercera y as´ı sucesivamente. al pasar el ciclo
externo a la segunda iteraci´on, el algoritmo compara la segunda posici´on
del arreglo con la tercera, cuarta, hasta n posici´on intercambiando los
elementos, de all´ı el nombre de burbuja.

-- 404 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 403
Hasta este punto no se hab´ıa explicado la forma de intercambiar el
contenido de dos posiciones en un arreglo (l´ıneas de la 45 a 47). Para
intercambiar el contenido de dos posiciones es necesario el uso de una
variable (auxiliar) que reciba el contenido de una posici´on (cualquiera
de la dos a intercambiar), en esa posici´on se almacena el contenido de la
segunda posici´on y en esta posici´on se almacena en contenido de la variable
auxiliar.
.:Ejemplo 6.11. Escriba un algoritmo que almacene un conjunto de n
n´umeros enteros en un vector, los ordene ascendentemente mediante el
m´etodo de la burbuja, que realice la b´usqueda de un n´umero cualquiera
mediante el m´etodo de “B´	usqueda binaria” indicando la posici´on que
ocupa en el vector. Utilice funciones para resolver el ejercicio.
Ejemplo de b´usqueda binaria para los siguientes n´umeros:
Ejemplo de b´	usqueda binaria
numero -> 1 3 5 9 14 21 45 63 73 87 89 90 97
elemento = 73
Ciclo Comparaci´	on
1 1 3 5 9 14 21 45 63 73 87 89 90 97
dado que 45 es menor que 73
2 1 3 5 9 14 21 45 63 73 87 89 90 97
dado que 87 es mayor que 73
3 1 3 5 9 14 21 45 63 73 87 89 90 97
Dato encontrado!!!
La “B´usqueda binaria” permite determinar de una manera muy eficiente
la posici´on de un elemento en un vector ordenado o concluir que el elemento
no est´a presente. Para conocer la posici´on del elemento, el algoritmo se
ubica en la posici´on del medio y, a trav´es de una comparaci´on, define si
debe realizar la busqueda en la mitad superior (mayores a ´el) o en los
elementos de la mitad inferior (menores a ´el); esto permite excluir de la
b´usqueda en cada iteraci´on la mitad de los elementos del vector; siguiendo
este procedimiento, al final se llega al elemento o se concluye su ausencia.

-- 405 of 450 --

404 Vectores y matrices
An´alisis del problema:
Resultados esperados: la posici´on que ocupa en el vector el
n´umero buscado.
Datos disponibles: los n´umeros que se van a ingresar en dicho
arreglo y el n´umero que se va a buscar posteriormente.
Proceso: luego de solicitar los datos que se van a almacenar en el
vector, el algoritmo debe ordenar este arreglo, por medio del m´etodo
de la burbuja como se explic´o en el ejercicio anterior. Posteriormente,
el algoritmo debe solicitar un n´umero que se va a buscar en el vector
y, mediante una funci´on que implemente el m´etodo de b´usqueda
binaria, realice la b´usqueda del n´umero e informe en qu´e posici´on
se encuentra. Este ejercicio se va a resolver con un vector de 13
posiciones.
• En el algoritmo principal
◦ Constante requerida:
 MAX: constante igual a 13.
◦ Variables requeridas:
 numero: vector con los MAX n´umeros a ordenar.
 numeroBuscar: valor que se desea buscar.
 posicion: posici´on del vector en donde se encuentra
el valor buscado o, -1 de no encontrarlo.
• En la funci´on leerArreglo
◦ Par´ametros:
 tamanio: tama˜no del vector.
◦ Variables locales:
 i: variable de control del ciclo.
 arregloE: arreglo que almacena los n´umeros enteros
que el usuario ingres´o.
• En la funci´on ordenarBurbuja
◦ Par´ametros:
 arreglo: vector que almacena los n´umeros enteros que
el usuario ingres´o.
 n: tama˜no del vector.

-- 406 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 405
◦ Variables locales:
 i: variable de control del primer ciclo.
 j: variable de control del segundo ciclo.
 auxiliar: variable necesaria para intercambiar dos
posiciones de un vector.
• En la funci´on buscarElemento
◦ Par´ametros:
 arreglo: vector que almacena los n´umeros enteros que
el usuario ingres´o.
 n: tama˜no del vector.
 numeroBuscar: valor que se desea buscar.
◦ Variables locales:
 primero: punto inicial del rango de b´usqueda.
 ultimo: punto final del rango de b´usqueda.
 centro: punto medio del rango de b´usqueda.
 posicion: posici´on en donde se encuentra el valor
buscado o, -1 de no encontrarlo.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.11.
Algoritmo 6.11: busquedaBinaria
1 Algoritmo busquedaBinaria
2 Constante Entero MAX = 13
3 Entero numero[ ]
4 Entero numeroBuscar, posicion
5
6 numero = leerArreglo( MAX )
7
8 imprimir( "N´umero a buscar: " )
9 leer( numeroBuscar )
10
11 ordenarBurbuja ( numero, MAX )
12
13 posicion = buscarElemento( numero, MAX, numeroBuscar )
14
15 Si( posicion > 0 ) Entonces
16 imprimir( "El n´umero buscado se encontr´o en :", posicion
)
17 SiNo
18 imprimir( "El n´umero no se encuentra en el arreglo" )
19 FinSi
20 FinAlgoritmo

-- 407 of 450 --

406 Vectores y matrices
21
22 Funcion Entero [ ] leerArreglo( Entero tamanio )
23 Entero i
24 Entero arregloE[ tamanio ]
25
26 Para i = 1 Hasta tamanio Incremento 1
27 imprimir( "Ingrese el n´umero " , i, ": " )
28 leer( arregloE[ i ] )
29 FinPara
30 Retornar arregloE
31 FinFuncion
32
33 Procedimiento ordenarBurbuja( Entero arreglo[ ], Entero n)
34 Entero i, j
35 Entero auxiliar
36
37 Para i = 1 Hasta n - 1 Incremento 1
38 Para j = i + 1 Hasta n Incremento 1
39 Si( arreglo[ i ] > arreglo[ j ] Entonces
40 auxiliar = arreglo[ i ]
41 arreglo[ i ] = arreglo[ j ]
42 arreglo[ j ] = auxiliar
43 FinSi
44 FinPara
45 FinPara
46 FinProcedimiento
47
48 Funcion Entero buscarElemento( Entero arreglo[ ],
49 Entero n,
50 Entero numeroBuscar )
51 Entero primero, ultimo, centro
52 Entero posici´on = -1
53
54 primero = 1
55 ultimo = n
56
57 Mientras( posicion == -1 Y primero <= ultimo )
58 centro = (primero + ultimo) / 2
59 Si( numero == arreglo[ centro ] )Entonces
60 posicion = centro
61 SiNo
62 Si numero < arreglo[ centro ] Entonces
63 ultimo = centro - 1
64 SiNo
65 primero = centro + 1
66 FinSi
67 FinSi
68 FinMientras
69

-- 408 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 407
70 Retornar posicion
71 FinFuncion
Explicaci´on del algoritmo:
En el algoritmo principal se leen los 13 elementos (constante MAX)
por medio de la funci´on leerArreglo() (l´ınea 6), que funciona como
ya se ha explicado en los anteriores ejercicios; luego, se solicita al
usuario el n´umero a buscar con las instrucciones imprimir y leer
(l´ıneas 8 y 9), posteriormente se ordenan los n´umeros usando la funci´on
ordenarBurbuja() (l´ınea 11) explicada en el ejemplo anterior, luego
se hace la b´usqueda usando la funci´on buscarElemento() (l´ınea 13),
dependiendo de la respuesta de la funci´on y usando una decisi´on, se
imprime la posici´on o se indica que el n´umero solicitado no se encuentra
en el arreglo (l´ıneas de la 15 a la 19).
La funci´on buscarElemento() implementa la b´usqueda binaria
explicada al inicio del ejercicio. Esta funci´on trabaja de la siguiente manera:
Utiliza una estructura c´ıclica Mientras-FinMientas que tiene como
condici´on que la variable posici´on sea -1 y que la variable primero sea
menor o igual a la variable ultimo; esto significa que se realiz´o la b´usqueda
en el arreglo y no se encontr´o el elemento.
Dentro del ciclo se encuentra la instrucci´on que calcula el centro para
cada iteraci´on y una instrucci´on Si que permite saber si el elemento se
encontr´o; esto se hace con la instrucci´on posicion=centro; si no se
encontr´o, se reubica la primera o ´ultima posici´on ya sea a la izquierda o
derecha del centro(dependiendo si el n´umero buscado es menor o mayor)
del vector para, con esto descartar la b´usqueda en alguno de los dos lados.
Por lo anterior, es que el vector debe estar ordenado.
Merece especial cuidado, dentro de esta funci´on, la siguiente l´ınea:
58 centro = (primero + ultimo) / 2
Esta instrucci´on permite reubicar el centro del vector para partirlo y
determinar si se realiza la b´usqueda del elemento del lado izquierdo o
derecho del mismo. En cada iteraci´on se vuelve a ubicar el centro entre
aquellos elementos cercanos al n´umero buscado.
En la l´ınea se observan tres variables de tipo Entero, as´ı que la divisi´on
que all´ı se presenta es una divisi´on entera, es decir, si la variable primero
igual a 1 y la variable ultimo igual a 6 el resultado es 3 y no 3.5.

-- 409 of 450 --

408 Vectores y matrices
(1 + 6) / 2
7 / 2
3
6.2. Matrices
Los arreglos de dos dimensiones se conocen tambi´en como matrices. Al
igual que los vectores, las matrices son conjuntos de celdas de memoria que
almacenan datos del mismo tipo, pero esta vez en forma de tablas, con filas
y columnas; de aqu´ı su nombre de arreglos bidimensionales. Las matrices
son variables a las que se les debe dar un nombre con un identificador v´alido
y debe especificarse tambi´en su tipo de datos al momento de declararlas.
Las matrices son bastante ´utiles en la soluci´on de aquellos ejercicios en
los que se requiera almacenar varios datos de varios objetos, por ejemplo,
sup´ongase que se deben almacenar las 10 notas parciales de cada uno de
los 4 estudiantes de un grupo; esto significa que en total se requieren 40
espacios de memoria. Este problema puede resolverse f´acilmente utilizando
una matriz o arreglo bidimensional.
1 <- ´ındice de la fila
2
3
4
´ındice de la columna -> 1 2 3 4 5 6 7 8 9 10
La forma de interpretarlo es que cada celda o posici´on requiere de dos
coordenadas (fila, columna) para ubicar una posici´on. En t´erminos
generales, suponga por ejemplo una matriz de m filas y n columnas, donde
el primer indice especifica la fila y el segundo la columna.
matriz =






a11 a12 a13 · · · a1n
a21 a22 a23 · · · a2n
... ... ... · · · ...
am1 am2 am3 · · · amn







-- 410 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 409
6.2.1 Declaraci´on de una matriz
Las matrices tambi´en requieren declarar una variable suscrita que
permita acceder a los datos. Una variable suscrita de una matriz se
diferencia de la de un vector por la cantidad de corchetes en su declaraci´on.
La cantidad de juegos de corchetes indica la dimensi´on del arreglo.
Entero matrizEdades [ ][ ]
Real matrizSalarios [ ][ ]
Cadena matrizNombres [ ][ ]
El doble juego de corchetes al final, se usa para indicar que se debe
separar espacio tanto para las filas y las columnas que va a tener la matriz.
Por supuesto, luego de declararse la variable suscrita, se deber´a especificar
el tama˜no, es decir, indicar el n´umero de filas y columnas que esta va
a tener. Esto se hace de la misma forma que se hizo con los arreglos
unidimensionales, es decir, utilizando la funci´on dimensionar, de la
siguiente forma:
Entero matrizEdades [ ][ ]
Real matrizSalarios [ ][ ]
Cadena matrizNombres [ ][ ]
matrizEdades = dimensionar( 4, 3 )
matrizSalarios = dimensionar( 10, 12 )
matrizNombres = dimensionar( 10, 10 )
O tambi´en, se puede dar tama˜no cuando se est´a declarando la matriz de
la siguiente forma:
Cadena matrizNombres [ 3 ][ 10 ]
Real matrizSalarios[ 15 ][ 5 ]
La forma de dimensionar las matrices, como los vectores, como ya se ha
dicho, depender´a del lenguaje de programaci´on y sus instrucciones propias
para este prop´osito.
En todos los casos, el n´umero dentro del primer juego de corchetes
especifica la cantidad de filas que tendr´a la matriz, mientras que el n´umero
en el segundo juego de corchetes indica la cantidad de columnas.
Entero matrizEdades [ 4 ][ 3 ]
Al declarar la matriz de edades anterior denominada matrizEdades,
gr´aficamente se ver´a de la siguiente manera:

-- 411 of 450 --

410 Vectores y matrices
1 <- 4 filas
2
3
4
1 2 3 <- 3 columnas
6.2.2 Almacenamiento de datos en una matriz
Cuando se va a almacenar los datos en una matriz, es necesario
especificar la celda en la que cada dato va a ir quedando; para ello, se
debe indicar, a trav´es de n´umeros ´ındice, la fila y la columna en la que se
encuentra la celda, de la siguiente manera:
matrizEdades [1][1] = 20
matrizEdades [1][2] = 18
matrizEdades [3][2] = 21
matrizEdades [4][3] = 73
Con estas instrucciones, se almacenar´ıa un 20 en la celda que se
encuentra en la fila 1 y columna 1, un 18 en la celda ubicada en la fila
1 y columna 2, un 21 en la celda que est´a en la fila 3 y columna 2 y un 73
en la celda que est´a en la fila 3 y columna 4. De tal forma que la matriz
de edades quedar´ıa de la siguiente forma:
20 18 1 <- ´ındice de la fila
2
21 3
73 4
1 2 3 <- ´ındice de la columna
Si se desea almacenar una serie de datos en una matriz de 3 filas por
3 columnas, tambi´en se podr´ıan almacenar directamente de la siguiente
forma:
Entero matrizNumeros[ ][ ] = { { 20, 12, 18},
{ 34, 37, 31},
{ 44, 49, 46} }
Donde cada conjunto de llaves interiores especifican cada fila de la
matriz.

-- 412 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 411
matrizNumeros -> 20 12 18 1
34 37 31 2
44 49 46 3
1 2 3
6.2.3 Recorrido de una matriz
Recorrer una matriz significa pasar por cada una de las celdas que la
componen, ya sea para ingresar datos o para leer los que se encuentran
almacenados en esta. Una matriz puede recorrerse de diferentes formas,
por ejemplo: la manera tradicional consiste en recorrer primero todas las
celdas de la primera fila y cuando se llegue a la ´ultima celda de esta fila,
pasar a la primera celda de la segunda fila y as´ı sucesivamente hasta llegar
a la ´ultima celda ubicada en la ´ultima fila y la ´ultima columna.
Una segunda forma de recorrer una matriz ser´ıa pasar inicialmente por
cada una de las celdas que conforman la primera columna arrancando en
la primera fila, luego ubicarse en la primera celda de la segunda columna
y recorrer toda la columna y as´ı hasta llegar a la ´ultima celda de la matriz
en la ´ultima fila y ´ultima columna. Sin embargo, podr´ıan llevarse a cabo
muchas otras formas de recorrer una matriz.
Para efectos pr´acticos, se llevar´a a cabo el recorrido tradicional a una
matriz, esto es, arrancando en la primera celda ubicada en la primera fila y
columna, recorriendo toda la fila y al terminar de recorrer esta, ubic´andose
en la primera celda de la segunda fila, para de esta forma hacer todo el
recorrido. Esta forma de recorrer la matriz se lleva a cabo mediante dos
ciclos anidados, el externo permite avanzar de una fila a otra mientras que
el interno lo hace a trav´es de las celdas de una columna a la siguiente. A
continuaci´on, la porci´on de c´odigo necesaria para recorrer una matriz y
llenarla con datos que el usuario ingresa:
Constante Entero NUMERO_FILAS = 4
Constante Entero NUMERO_COLUMNAS = 5
Entero matriz[ NUMERO_FILAS ][ NUMERO_COLUMNAS ]
Para i = 1 Hasta NUMERO_FILAS Incremento 1
Para j = 1 Hasta NUMERO_COLUMNAS Incremento 1
imprimir( "Ingrese la posici´on (", j, ", ", i, ") : " )
leer( matriz[ i ][ j ] )
FinPara
FinPara

-- 413 of 450 --

412 Vectores y matrices
En la anterior porci´on de c´odigo, es necesario tener en cuenta lo siguiente:
El ciclo externo har´ıa el recorrido de las filas, mientras que el ciclo
interno recorrer´ıa las columnas.
Se puede notar que el ciclo interno se ejecuta m´as r´apidamente.
Cuando el ciclo interno termine de ejecutarse, el algoritmo pasar´a
al ciclo externo que lo llevar´a a una fila siguiente.
La constante NUMERO FILAS almacena el n´umero de filas que tiene
la matr´ız. As´ı que con la condici´on del ciclo externo, el recorrido se
limita al n´umero de filas que tiene la matriz.
La constante NUMERO COLUMNAS almacena el n´umero de columnas,
con la condici´on del ciclo interno se recorren las columnas en cada
fila.
A continuaci´on, se exponen una serie de ejemplos con el fin de ilustrar
los conceptos que se acaban de explicar y el uso practico de las matrices.
Los primeros ejemplos se escribieron en forma secuencial y los siguientes,
utilizando funciones y procedimientos.
.:Ejemplo 6.12. Una matriz transpuesta es el resultado de tomar una
matriz inicial e invertir sus filas y columnas, es decir, que la matriz
transpuesta contiene como columnas las filas de la matriz original y,
las filas corresponden a las columnas de la matriz original. Dise˜ne un
algoritmo que, a partir de una matriz inicial, obtenga su transpuesta y
la muestre al usuario.
El ´	Algebra lineal estudia las matrices y sus propiedades; uno de los
aspectos que se estudia cuando se trabaja con matrices consiste en
encontrar la transpuesta de una matriz. En este ejercicio se codifica un
algoritmo que permita encontrar la transpuesta de una matriz dada.
A =






a11 a12 a13 · · · a1n
a21 a22 a23 · · · a2n
... ... ... · · · ...
am1 am2 am3 · · · amn







-- 414 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 413
La transpuesta de la matriz A, es simbolizada como AT .
AT =






a11 a21 a31 · · · an1
a12 a22 a32 · · · an2
... ... ... · · · ...
a1m a2m a4m · · · anm






An´alisis del problema:
Resultados esperados: la transpuesta de una matriz ingresada, al
igual que la original.
Datos disponibles: Se debe conocer la matriz original, incluyendo
su tama˜no y los elementos ubicados en sus diferentes posiciones.
Proceso: Luego de tener la matriz original ya cargada con datos,
el algoritmo debe recorrer esta matriz fila a fila e ir pasando los
elementos a cada columna de la matriz transpuesta. Una vez se haya
terminado el proceso, se muestran ambas matrices.
Variables requeridas:
• matrizInicial: matriz con los datos iniciales
• matrizTranspuesta: matriz con los datos iniciales pero con
las filas y columnas intercambiadas (transpuesta)
• filas: n´umero de filas de la matriz inicial.
• columnas: n´umero de columnas de la matriz inicial.
• i: variable de control del primer ciclo.
• j: variable de control del segundo ciclo.
• cadena1: cadena que almacenar´a todos los elementos de la
matriz inicial para su posterior impresi´on.
• cadena2: cadena que almacenar´a todos los elementos de la
matriz transpuesta para su posterior impresi´on.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.12.
Algoritmo 6.12: TranspuestaMatriz
1 Algoritmo TranspuestaMatriz
2 Entero matrizInicial [ ][ ], matrizTranspuesta [ ][ ]
3 Entero filas, columnas, i, j
4 Cadena cadena1, cadena2
5

-- 415 of 450 --

414 Vectores y matrices
6 imprimir( "N´umero de filas para la matriz: " )
7 leer( filas )
8
9 imprimir( "N´umero de columnas para la matriz: " )
10 leer( columnas )
11
12 matrizInicial = dimensionar( filas, columnas )
13 matrizTranspuesta = dimensionar( columnas, filas )
14
15 Para i = 1 Hasta filas Incremento 1
16 Para j = 1 Hasta columnas Incremento 1
17 imprimir( "N´umero para posici´on " , i, " ", j, ": " )
18 leer( matrizInicial[ i ][ j ] )
19 FinPara
20 FinPara
21
22 Para i = 1 Hasta filas Incremento 1
23 Para j = 1 Hasta columnas Incremento 1
24 matrizTranspuesta[ j ][ i ] = matrizInicial[ i ][ j ]
25 FinPara
26 FinPara
27
28 cadena1 = ""
29 Para i = 1 Hasta filas Incremento 1
30 Para j = 1 Hasta columnas Incremento 1
31 cadena1 = cadena1 + matrizInicial [ i ][ j ] + " "
32 FinPara
33 cadena1 = cadena1 + SALTO_LINEA
34 FinPara
35
36 cadena2 = ""
37 Para i = 1 Hasta columnas Incremento 1
38 Para j = 1 Hasta filas Incremento 1
39 cadena2 = cadena2 + matrizTranspuesta[ i ][ j ] + " "
40 FinPara
41 cadena2 = cadena2 + SALTO_LINEA
42 FinPara
43
44 imprimir( "Matriz inicial: ", cadena1 )
45 imprimir( "Matriz transpuesta: ", cadena2 )
46 FinAlgoritmo
Explicaci´on del algoritmo:
Inicialmente, se realiza la declaraci´on de todas las variables necesarias
(l´ıneas 2 a la 4). A continuaci´on, se solicita la cantidad de filas y de
columnas que tendr´a la matriz inicial, que corresponde al mismo n´umero
de columnas y de filas de la matriz transpuesta.

-- 416 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 415
6 imprimir( "N´umero de filas para la matriz: " )
7 leer( filas )
8
9 imprimir( "N´umero de columnas para la matriz: " )
10 leer( columnas )
11
12 matrizInicial = dimensionar( filas, columnas )
13 matrizTranspuesta = dimensionar( columnas, filas )
Luego, utilizando dos ciclos Para anidados, se solicitan los datos para
la matriz inicial.
15 Para i = 1 Hasta filas Incremento 1
16 Para j = 1 Hasta columnas Incremento 1
17 imprimir( "N´umero para posici´on " , i, " ", j, ": " )
18 leer( matrizInicial[ i ][ j ] )
19 FinPara
20 FinPara
Despu´es, usando nuevamente dos ciclos Para anidados, se pasan los
elementos de la matriz inicial a la transpuesta.
22 Para i = 1 Hasta filas Incremento 1
23 Para j = 1 Hasta columnas Incremento 1
24 matrizTranspuesta[ j ][ i ] = matrizInicial[ i ][ j ]
25 FinPara
26 FinPara
Note que, en esta parte, se usan los ´ındices i y j para recorrer filas y
columnas de la matriz inicial y columnas y filas en la matriz transpuesta.
Es por eso que estos ´ındices est´an cambiados en la instrucci´on:
24 matrizTranspuesta[ j ][ i ] = matrizInicial[ i ][ j ]
De tal forma que, a medida que se recorren las filas de la matriz inicial,
se recorren las columnas de la transpuesta y se van pasando los elementos
respectivos.
22 Para i = 1 Hasta filas Incremento 1
23 Para j = 1 Hasta columnas Incremento 1
24 matrizTranspuesta[ j ][ i ] = matrizInicial[ i ][ j ]
25 FinPara
26 FinPara
Luego de haber pasado los elementos a la matriz transpuesta, se recorre
la matriz inicial y se pasan los elementos a la variable cadena1 (l´ıneas de
la 28 a la 34):

-- 417 of 450 --

416 Vectores y matrices
28 cadena1 = ""
29 Para i = 1 Hasta filas Incremento 1
30 Para j = 1 Hasta columnas Incremento 1
31 cadena1 = cadena1 + matrizInicial [ i ][ j ] + " "
32 FinPara
33 cadena1 = cadena1 + SALTO_LINEA
34 FinPara
Con el prop´osito de mostrar todos los datos en una sola invocaci´on
de la instrucci´on imprimir (l´ınea 44). Igual se hace al pasar la matriz
transpuesta a la variable cadena2 (l´ıneas de la 36 a 42), lo que facilita su
impresi´on (l´ınea 45).
Al ejecutar el algoritmo, se visualizar´ıa:
Matriz Inicial: 20 12 18
34 37 31
44 49 46
Matriz trasnpuesta: 20 34 44
12 37 49
18 31 46
.:Ejemplo 6.13. Dise˜ne un algoritmo que permita almacenar n´umeros
enteros entre 50 y 100 en una matriz de n filas y m columnas y luego,
se pueda buscar un n´umero cualquiera dentro del rango ingresado y el
algoritmo determine en qu´e posici´on (fila y columna) se encuentra,
si es que est´a almacenado, de lo contrario, el algoritmo deber´a decir
que el n´umero buscado no est´a en la matriz. Si el n´umero se encuentra
almacenado varias veces, el algoritmo retorna la posici´on de la primera
ocurrencia.
Este segundo ejercicio de matrices considera almacenar n´umeros en el
rango entre 50 y 100 (lo cual requiere que se haga una validaci´on) en
una matriz en la que el n´umero de filas y columnas ser´a ingresado por el
usuario. Posteriormente, el algoritmo implica llevar a cabo una b´usqueda
recorriendo la matriz como se indic´o anteriormente. Este ejercicio se
resolver´a de forma secuencial, sin el uso de funciones.
An´alisis del problema:
Resultados esperados: la posici´on, diciendo en qu´e fila y columna
se encuentra almacenado el n´umero que se est´a buscando. Si el
n´umero no es encontrado, debe mostrarse un mensaje.

-- 418 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 417
Datos disponibles: la cantidad de filas y de columnas que tendr´a
la matriz y los n´umeros que se guardar´an en las diversas posiciones
de la matriz.
Proceso: luego de almacenar los datos en la matriz, el algoritmo
deber´a llevar a cabo una b´usqueda secuencial, recorriendo las celdas
de la primera fila y pasando luego a la siguiente fila para seguir
buscando, hasta encontrar el n´umero ingresado por el usuario. Si
se ha recorrido toda la matriz y no se ha encontrado el n´umero, se
debe informar al usuario. Si el n´umero se encuentra varias veces en
la matriz, se muestra la posici´on de la primer coincidencia.
Variables requeridas:
• matriz: matriz con los datos ingresados por el usuario.
• filas: n´umero de filas de la matriz.
• columnas: n´umero de columnas de la matriz.
• numero: valor que se desea buscar.
• encontrado: bandera que indica si el numero si se encuentra
o no en la matriz.
• i: variable de control del primer ciclo.
• j: variable de control del segundo ciclo.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.13.
Algoritmo 6.13: BusquedaElemento
1 Algoritmo BusquedaElemento
2 Entero filas, columnas, i, j, numero
3 Entero matriz [ ]
4 Logico encontrado
5
6 imprimir( "N´umero de filas para la matriz: " )
7 leer( filas )
8
9 imprimir( "N´umero de columnas para la matriz: " )
10 leer( columnas )
11
12 matriz = dimensionar( filas, columnas )
13
14 Para i = 1 Hasta filas Incremento 1
15 Para j = 1 Hasta columnas Incremento 1
16 Haga
17 imprimir( "Ingrese numero para posici´on " , i, j )
18 leer( matriz[ i ][ j ] )
19

-- 419 of 450 --

418 Vectores y matrices
20 Si( matriz[ i ][ j ] < 50 O
21 matriz[ i ][ j ] > 100 ) Entonces
22 imprimir( "Ha ingresado un n´umero equivocado" )
23 FinSi
24 MientrasQue( matriz[ i ][ j ] < 50 O
25 matriz[ i ][ j ] > 100 )
26 FinPara
27 FinPara
28
29 imprimir( "Ingrese el n´umero a buscar en la matriz ")
30 leer( numero )
31
32 encontrado = Falso
33 Para i = 1 Hasta filas Incremento 1
34 Para j = 1 Hasta columnas Incremento 1
35 Si( matriz[ i ][ j ] == numero Y encontrado == Falso )
Entonces
36 imprimir( "Encontrado en la posici´on" , i, " ", j )
37 encontrado = Verdadero
38 FinSi
39 FinPara
40 FinPara
41
42 Si( encontrado == Falso ) Entonces
43 imprimir( "El n´umero no est´a almacenado en la matriz " )
44 FinSi
45 FinAlgoritmo
Explicaci´on del algoritmo:
Despu´es de declarar las variables necesarias, el algoritmo solicita el
n´umero de filas y columnas que va a tener la matriz y captura estos
datos. Con la funci´on dimensionar(), se le da el tama˜no a la matriz.
6 imprimir( "N´umero de filas para la matriz: " )
7 leer( filas )
8
9 imprimir( "N´umero de columnas para la matriz: " )
10 leer( columnas )
11
12 matriz = dimensionar( filas, columnas )
Vienen luego dos ciclos Para, uno dentro del otro, con el f´ın de solicitar
los n´umeros que se van a almacenar en las celdas de la matr´ız. Note que
dentro del segundo ciclo, est´a una instrucci´on Haga-MientrasQue, que
tiene el prop´osito de validar los n´umeros que est´a ingresando el usuario y
que deben pertenecer al rango entre 50 y 100, seg´un lo requiere el algoritmo.

-- 420 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 419
14 Para i = 1 Hasta filas Incremento 1
15 Para j = 1 Hasta columnas Incremento 1
16 Haga
17 imprimir( "Ingrese numero para posici´on " , i, j )
18 leer( matriz[ i ][ j ] )
19
20 Si( matriz[ i ][ j ] < 50 O
21 matriz[ i ][ j ] > 100 ) Entonces
22 imprimir( "Ha ingresado un n´umero equivocado" )
23 FinSi
24 MientrasQue( matriz[ i ][ j ] < 50 O
25 matriz[ i ][ j ] > 100 )
26 FinPara
27 FinPara
Al terminar los dos ciclos Para anidados, se solicita al usuario que
ingrese el n´umero que se va a buscar en la matriz.
29 imprimir( "Ingrese el n´umero a buscar en la matriz ")
30 leer( numero )
Ahora se procede a realizar la b´usqueda, para ello se inicializa la variable
encontrado en Falso, pues todav´ıa no se ha encontrado dicho n´umero.
Nuevamente se recorre la matriz con dos ciclos Para anidados como se
explic´o al principio del tema de matrices o arreglos bidimensionales. Dentro
de estos ciclos se ubica una instrucci´on Si que compara si lo que hay
almacenado en la posici´on i, j de la matriz, es igual a lo que contiene la
variable numero; si es as´ı, se encontr´o el elemento y se muestra al usuario,
adem´as se cambia el valor de la variable encontrado a Verdadero,
para evitar imprimir nuevamente el mensaje si el n´umero est´a en varias
posiciones de la matriz.
32 encontrado = Falso
33 Para i = 1 Hasta filas Incremento 1
34 Para j = 1 Hasta columnas Incremento 1
35 Si( matriz[ i ][ j ] == numero Y encontrado == Falso )
Entonces
36 imprimir( "Encontrado en la posici´on" , i, " ", j )
37 encontrado = Verdadero
38 FinSi
39 FinPara
40 FinPara
Despu´es de estos dos ciclos Para anidados, se muestra un mensaje
dentro de una instrucci´on Si que solo se muestra si la variable
encontrado es Falso, es decir, si no se encontr´o el n´umero buscado
en toda la matriz.

-- 421 of 450 --

420 Vectores y matrices
42 Si( encontrado == Falso ) Entonces
43 imprimir( "El n´umero no est´a almacenado en la matriz " )
44 FinSi
Los ejercicios de matrices que siguen a continuaci´on, se resolver´an
haciendo uso de funciones y procedimientos, ya que, como se mencion´o
antes, los algoritmos se har´an m´as modulares y f´aciles de entender.
.:Ejemplo 6.14. Escriba un algoritmo que almacene en dos matrices de
tama˜no 3 x 3, es decir, 3 filas y 3 columnas, n´umeros enteros y que a
trav´es de una funci´on permita calcular y almacenar en una tercera matriz
la suma de los n´umeros almacenados en las celdas equivalentes de las dos
anteriores. Al final, el algoritmo debe mostrar las tres matrices.
En t´erminos generales:
A =






a11 a12 a13 · · · a1n
a21 a22 a23 · · · a2n
... ... ... · · · ...
am1 am2 am3 · · · amn






B =






b11 b12 b13 · · · b1n
b21 b22 b23 · · · b2n
... ... ... · · · ...
bm1 bm2 bm3 · · · bmn






C = A + B =






a11 + b11 a12 + b12 a13 + b13 · · · b1n + b1n
a21 + b21 a22 + b22 a23 + b23 · · · a2n + b2n
... ... ... · · · ...
am1 + bm1 am2 + bm2 am3 + bm3 · · · amn + bmn






An´alisis del problema:
Resultados esperados: una matriz donde los n´umeros almacenados
en cada celda son el resultado de la suma de los n´umeros ubicados
en las respectivas celdas de las matrices ingresadas.
Datos disponibles: se tienen los n´umeros enteros que van a ser
almacenados en las dos primeras matrices y que van a ser sumados.

-- 422 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 421
Proceso: este algoritmo tendr´a que calcular la suma posici´on por
posici´on, de los n´umeros en las celdas ubicadas en la misma posici´on
de dos matrices con esos n´umeros ya ingresados.
Variables requeridas:
• En el algoritmo principal
◦ Constante requerida:
 MAX: constante que da tama˜no a las matrices (para el
ejemplo 3).
◦ Variables:
 matrizA: la primera matriz a sumar.
 matrizB: la segunda matriz a sumar.
 matrizC: matriz resultante de sumar las dos primeras.
• En la funci´on leerDatos
◦ Par´ametros:
 tamanio: para dar la cantidad de filas y columnas a
la matriz.
◦ Variables locales:
 i: controla el ciclo externo de las filas.
 j: controla el ciclo interno de las columnas.
 matriz: matriz de datos que ser´a retornada.
• En la funci´on calcularSuma
◦ Par´ametros:
 m1: primera matriz a sumar.
 m2: segunda matriz a sumar.
 tamanio: Tama˜no de las matrices (igual n´umero de
filas y columnas)
◦ Variables locales:
 i: controla el ciclo externo.
 j: controla el ciclo interno.
 matriz: almacena la suma de las matrices.
• En la funci´on mostrarResultados
◦ Par´ametros:
 m1: primera matriz a imprimir.
 m2: segunda matriz a imprimir.
 m3: tercera matriz a imprimir.

-- 423 of 450 --

422 Vectores y matrices
 tamanio: Tama˜no de las matrices (igual n´umero de
filas y columnas)
◦ Variables locales:
 i: variable de control del ciclo externo.
 j: variable de control del ciclo interno.
 cadenaA: almacena los n´umeros de la matriz 1.
 cadenaB: almacena los n´umeros de la matriz 2.
 cadenaC: almacena los n´umeros de la matriz 3.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.14.
Algoritmo 6.14: SumaMatrices
1 Algoritmo SumaMatrices
2 Constante Entero MAX = 3
3 Entero matrizA [ ][ ]
4 Entero matrizB [ ][ ]
5 Entero matrizC [ ][ ]
6
7 matrizA = leerDatos( MAX )
8 matrizB = leerDatos( MAX )
9
10 matrizC = calcularSuma( matrizA, matrizB, MAX )
11
12 mostrarResultados( matrizA, matrizB, matrizC, MAX )
13 FinAlgoritmo
14
15 Funcion Entero[ ][ ] leerDatos(Entero tamanio)
16 Entero i, j
17 Entero matriz[ tamanio ] [ tamanio ]
18
19 Para i = 1 Hasta tamanio Incremento 1
20 Para j = 1 Hasta tamanio Incremento 1
21 imprimir( "N´umero para posici´on " , i," ", j, ":" )
22 leer( matriz[ i ][ j ] )
23 FinPara
24 FinPara
25
26 Retornar matriz
27 FinFuncion
28
29 Funcion Entero[ ][ ] calcularSuma( Entero m1[ ][ ],
30 Entero m2[ ][ ],
31 Entero tamanio )
32 Entero i, j
33 Entero matriz[ tamanio ] [ tamanio ]
34
35 Para i = 1 Hasta tamanio Incremento 1

-- 424 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 423
36 Para j = 1 Hasta tamanio Incremento 1
37 matriz[ i ][ j ] = m1[ i ][ j ] + m2[ i ][ j ]
38 FinPara
39 FinPara
40
41 Retornar matriz
42 FinFuncion
43
44 Procedimiento mostrarResultados( Entero [ ][ ] m1,
45 Entero [ ][ ] m2,
46 Entero [ ][ ] m3,
47 Entero tamanio )
48 Entero i, j
49 Cadena cadenaA, cadenaB, cadenaC
50
51 Para i = 1 Hasta tamanio Incremento 1
52 Para j = 1 Hasta tamanio Incremento 1
53 cadenaA = cadenaA, m1[ i ][ j ] + " "
54 cadenaB = cadenaB, m2[ i ][ j ] + " "
55 cadenaC = cadenaC, m3[ i ][ j ] + " "
56 FinPara
57 cadenaA = cadenaA + SALTO_LINEA
58 cadenaB = cadenaB + SALTO_LINEA
59 cadenaC = cadenaC + SALTO_LINEA
60 FinPara
61
62 imprimir( "Matriz A ", cadenaA )
63 imprimir( "Matriz B ", cadenaB )
64 imprimir( "Matriz Resultado ", cadenaC )
65 FinProcedimiento
Explicaci´on del algoritmo:
En este algoritmo, lo primero que se hace es declarar las variables
suscritas que necesarias para las tres matrices de tama˜no 3 x 3. El tama˜no
de estas matrices se da a partir de una constante MAX de tipo Entero que
almacena el n´umero 3 y que es el mismo para las filas y las columnas.
2 Constante Entero MAX = 3
3 Entero matrizA [ ][ ]
4 Entero matrizB [ ][ ]
5 Entero matrizC [ ][ ]
Se utiliza la funci´on leerDatos() para solicitar los n´umeros enteros
que se van a almacenar en las dos primeras matrices, y se env´ıa como
argumento el tama˜no de las mismas (n´umero de filas igual al n´umero de
columnas), para dimensionarlas internamente;
7 matrizA = leerDatos( MAX )

-- 425 of 450 --

424 Vectores y matrices
8 matrizB = leerDatos( MAX )
Esta funci´on consta de dos ciclos Para anidados que permiten recorrer
las filas y las columnas e ir ubic´andose en cada celda de la matriz y poder
almacenar all´ı cada n´umero que el usuario va ingresando.
Una vez ingresados los datos, se usa la funci´on calcularSuma() que
recibe como par´ametros las dos matrices ya con datos y el tama˜no de las
mismas, con el que se da tama˜no a una matriz que est´a dentro de esta
funci´on y que sirve para almacenar los resultados de la suma; esta matriz
ser´a retornada al algoritmo principal con los resultados de la suma de los
valores de las celdas ubicadas en la misma posici´on de las matrices que se
van a sumar. Inicialmente se hace el llamado con:
10 matrizC = calcularSuma( matrizA, matrizB, MAX )
Y posteriormente la funci´on ejecuta su c´odigo interno:
29 Funcion Entero[ ][ ] calcularSuma( Entero m1[ ][ ],
30 Entero m2[ ][ ],
31 Entero tamanio )
32 Entero i, j
33 Entero matriz[ tamanio ] [ tamanio ]
34
35 Para i = 1 Hasta tamanio Incremento 1
36 Para j = 1 Hasta tamanio Incremento 1
37 matriz[ i ][ j ] = m1[ i ][ j ] + m2[ i ][ j ]
38 FinPara
39 FinPara
40
41 Retornar matriz
42 FinFuncion
Esta funci´on utiliza dos ciclos Para con los que se recorren las celdas
de las dos matrices con datos y se hace la suma de los valores que est´an
all´ı, almacen´andolos en las celdas de la matriz de resultados.
35 Para i = 1 Hasta tamanio Incremento 1
36 Para j = 1 Hasta tamanio Incremento 1
37 matriz[ i ][ j ] = m1[ i ][ j ] + m2[ i ][ j ]
38 FinPara
39 FinPara
Por ´ultimo, las tres matrices y su tama˜no se pasan como argumento al
procedimiento mostrarResultados()
12 mostrarResultados( matrizA, matrizB, matrizC, MAX )

-- 426 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 425
Esta funci´on recorre mediante dos ciclos Para anidados las matrices y
va pasando los datos de estas matrices a tres variables de tipo Cadena que
ser´an las que se mostrar´an al usuario mediante la funci´on imprimir().
51 Para i = 1 Hasta tamanio Incremento 1
52 Para j = 1 Hasta tamanio Incremento 1
53 cadenaA = cadenaA, m1[ i ][ j ] + " "
54 cadenaB = cadenaB, m2[ i ][ j ] + " "
55 cadenaC = cadenaC, m3[ i ][ j ] + " "
56 FinPara
57 cadenaA = cadenaA + SALTO_LINEA
58 cadenaB = cadenaB + SALTO_LINEA
59 cadenaC = cadenaC + SALTO_LINEA
60 FinPara
61
62 imprimir( "Matriz A ", cadenaA )
63 imprimir( "Matriz B ", cadenaB )
64 imprimir( "Matriz Resultado ", cadenaC )
Para pasar los datos que est´an en las matrices a las variables de tipo
Cadena, se recorre con dos ciclos Para anidados cada matriz y se usa
la variable de tipo Cadena para ir almacenando de forma concatenada lo
que hay en las posiciones de cada matriz. Al terminar de pasar lo que hay
en cada fila, es decir, de recorrer el ciclo Para interno, se ingresa un salto
de l´ınea, lo que permite que, cuando se muestre esta variable cadena, se
vea cada fila de la matriz separada de la anterior fila, dando la sensaci´on
al usuario de estar viendo una tabla o matriz.
.:Ejemplo 6.15. Se desea construir un algoritmo que permita almacenar
en una matriz cada uno de los doce sueldos pagados durante un a˜no a un
conjunto de 10 empleados. El algoritmo debe determinar el valor total de la
n´omina pagado durante un mes cualquiera del a˜no y el total pagado durante
el a˜no a un empleado cualquiera. Dise˜ne el algoritmo utilizando funciones
y procedimientos.
matrizSueldos =






s11 s12 s13 · · · s1 12
s21 s22 s23 · · · s2 12
... ... ... · · · ...
s10 1 s10 2 s10 3 · · · s10 12






Se tienen 12 columnas, una por cada mes del a˜no y se tienen 10 filas, una
por cada empleado. As´ı, por ejemplo s23 representa el sueldo del segundo
empleado en el tercer mes (Marzo).

-- 427 of 450 --

426 Vectores y matrices
An´alisis del problema:
Resultados esperados: el total de la n´omina del mes ingresado por
el usuario, as´ı como el total pagado durante el a˜no al empleado que
se desee analizar.
Datos disponibles: se conocen, por cada empleado los 12 sueldos
ganados en los 12 meses del a˜no.
Proceso: el algoritmo debe calcular, a trav´es de una suma, cu´anto
se pag´o en total a todos los empleados durante el mes m (m representa
el mes que el usuario desee); esto implica que se recorra la columna
m de la matriz para sumar todos sus valores y retornar este total.
Igualmente, se deben sumar los valores que hay en las celdas de la
fila e (Que corresponde al empleado que el usuario desea) y retornar
el total de esta suma.
Variables requeridas:
• En el algoritmo principal
◦ Constantes requeridas:
 MAX EMPLEADOS: constante que posee la cantidad de
empleados.
 MAX MESES: constante que posee el n´umero de meses
del a˜no.
◦ Variables:
 matrizSueldos: matriz que almacenar´a los sueldos
de los 10 empleados durante los 12 meses.
 nominaMesM: almacenar´a el c´alculo de la n´omina del
mes m.
 nominaEmpleadoE: almacenar´a el c´alculo de la
n´omina del empleado (e).
 numeroMes: recibe el n´umero del mes (m) del que se
desea calcular la n´omina total.
 numeroEmpleado: recibe el n´umero del empleado (e)
del que se quiere saber su n´omina total.
• En la funci´on leerDatos
◦ Par´ametros:
 filas: la cantidad de filas que representa los
empleados.
 columnas: la cantidad de columnas que representa los
meses.

-- 428 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 427
◦ Variables locales:
 i: controla el ciclo externo de las filas.
 j: controla el ciclo interno de las columnas.
 matriz: matriz de datos que ser´a retornada.
• En la funci´on calcularNominaMesM
◦ Par´ametros:
 matriz: la matriz con los sueldos de los empleados.
 numeroMes: el n´umero del mes que se quiere calcular.
 maximoEmpleados: cantidad de empleados.
◦ Variables locales:
 i: controla el ciclo.
 nominaMesM: acumula la n´omina del mes (m).
• En la funci´on calcularNominaEmpleadoE
◦ Par´ametros:
 matriz: la matriz con los salarios de los empleados.
 numeroEmp: el n´umero del empleado que se quiere
calcular.
 maximoMeses: cantidad de meses.
◦ Variables locales:
 i: controla el ciclo.
 nominaEmpleadoE: acumula la n´omina del empleado
(e).
• En la funci´on mostrarResultados
◦ Par´ametros:
 nominaMesM: contiene el total de la n´omina del mes
analizado.
 nominaEmpleadoE: contiene la n´omina del empleado
analizado.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.15.
Algoritmo 6.15: SueldosEmpleados
1 Algoritmo SueldosEmpleados
2 Constante Entero MAX_EMPLEADOS = 10
3 Constante Entero MAX_MESES = 12
4 Real matrizSueldos [ ][ ], nominaMesM, nominaEmpleadoE
5 Entero numeroMes, numeroEmpleado

-- 429 of 450 --

428 Vectores y matrices
6
7 matrizSueldos = leerDatos( MAX_EMPLEADOS, MAX_MESES )
8
9 imprimir( "Numero del mes que desea totalizar: " )
10 leer( numeroMes )
11
12 imprimir( "N´umero del empleado que desea totalizar" )
13 leer( numeroEmpleado )
14
15 nominaMesN = calcularNominaMesM( matrizSueldos,
16 numeroMes,