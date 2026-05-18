# 3. Luego de que se ejecute el cuerpo del ciclo, se incrementa la variable

numero en 1 unidad.
La segunda l´ınea, es el cuerpo del ciclo, el cual imprime el valor de numero.
La ´ultima l´ınea indica el final del ciclo y retorno a la l´ınea 1, donde
se produce el incremento de la variable numero y la evaluaci´on de la
condici´on impl´ıcita.
Las iteraciones terminan en el momento que numero tome el valor de
11, donde la evaluaci´on de la condici´on resulta falsa.
En la Figura 4.32 se muestra el diagrama de flujo del Algoritmo 4.31.

-- 276 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 275
Inicio
10
numero=1
+1
numero
Final
S´ı
No
Figura 4.32: Diagrama de flujo para el Ejemplo 4.31
Aclaraci´on:
El bloque de instrucciones o cuerpo del ciclo
Para-FinPara, se ejecutar´a solamente si la
evaluaci´on de la condici´on impl´ıcita es verdadera.
El valor inicial (valor1) y el valor final (valor2)
de la variable (var) que controla el ciclo, pueden establecerse
mediante una variable o una constante.
.:Ejemplo 4.18. Dise˜ne un algoritmo que genere e imprima la siguiente
serie:
1, 3, 5, 7, 9, 11, . . . , n
An´alisis del problema:
Este problema ya fue solucionado anteriormente, usando las dos
estructuras de ciclo previamente estudiadas. El an´alisis completo a este
problema lo encuentra en el Ejemplo 4.1. El Algoritmo 4.4 muestra la
soluci´on usando el ciclo Mientras - FinMientras y el Ejemplo 4.9 usa
el ciclo Haga-MientrasQue, ver Algoritmo 4.13.

-- 277 of 450 --

276 Estructuras de repetici ´on
De acuerdo al an´alisis planteado, se propone el Algoritmo 4.32, mediante
el ciclo Para-FinPara.
Algoritmo 4.32: Serie
1 Algoritmo Serie
2 /* Este algoritmo imprime la siguiente serie, de acuerdo
3 al n´umero de t´erminos que se le especifique:
4 1, 3, 5, 7, 9, 11, ..., n
5 */
6
7 // Declaraci´on de variables
8 Entero cantidadTerminos, contadorNumeros, termino
9
10 // Dato disponible
11 imprimir( "Ingrese la cantidad de t´erminos a generar: " )
12 leer( cantidadTerminos )
13
14 // Inicializaci´on de variable
15 termino = 1
16
17 // Generaci´on de la serie
18 Para contadorNumeros = 1 Hasta cantidadTerminos - 1
19 Incremento 1
20 imprimir( termino, ", " )
21 termino = termino + 2
22 FinPara
23
24 imprimir( termino )
25 FinAlgoritmo
Explicaci´on del algoritmo:
La parte inicial del algoritmo es la misma que la de los Ejemplos 4.1 y
4.9. Los cambios se aprecian desde la inicializaci´on de las variables, ac´a
solo es necesario inicializar la variable termino.
La instrucci´on:
18 Para contadorNumeros = 1 Hasta cantidadTerminos - 1
19 Incremento 1
En la l´ınea 18 empieza un proceso repetitivo condicionado al comienzo.
Se inicializa en 1 a contadorNumeros. El c´odigo Hasta se˜nala que
las iteraciones del ciclo deben hacerse mientras se cumpla la condici´on
impl´ıcita contadorNumeros <= cantidadTerminos - 1. En cada
ejecuci´on del ciclo, el c´odigo Incremento adiciona 1 unidad a
contadorNumeros.

-- 278 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 277
Si cada que se eval´ue la condici´on, da un resultado verdadero, se imprime
el acumulado de termino y luego se incrementa en dos unidades. Al
arrojar un resultado falso, se termina el ciclo y seguidamente se ejecuta
la instrucci´on de la l´ınea 24 la cual imprime el ´ultimo t´ermino se la serie
sin imprimir la respectiva coma de separaci´on, posteriormente termina la
ejecuci´on del algoritmo.
En la Figura 4.33 se muestra la soluci´on del Ejemplo 4.18 mediante un
diagrama de flujo.
Inicio
cantidadTerminos
termino = 1
cantidadTerminos - 1
contadorNumero=1
+1
termino, “, ”
termino = termino +2
termino
Final
S´ı
No
Figura 4.33: Diagrama de flujo del Algoritmo Serie

-- 279 of 450 --

278 Estructuras de repetici ´on
.:Ejemplo 4.19. Construya un algoritmo que imprima tres columnas
de n´umeros, conforme a la Tabla 4.11, en donde el valor de n ser´a
proporcionado por el usuario.
1 1 2
2 4 6
3 9 12
4 16 20
5 25 30
. . . . . . . . .
n . . . . . .
Tabla 4.10: Tabla de datos del Ejemplo 4.19
An´alisis del problema:
Resultados esperados: se espera que el algoritmo genere la tabla
mostrada en el enunciado.
Datos disponibles: con la cantidad de n´umeros o cantidad de filas
de la tabla, se podr´a hacer el proceso, dato que ser´a suministrado
por el usuario del algoritmo.
Proceso: luego de la lectura de la cantidad de n´umeros, se procede
a realizar la generaci´on de ellos y los c´alculos correspondientes.
La primera columna de la tabla est´a conformada por los n´umeros
desde el 1 hasta n, en forma consecutiva. En la segunda columna se
presentan los cuadrados de cada uno de los n´umeros de la primera; en
la ´ultima se muestra la suma de cada n´umero de la primera columna,
con su respectivo cuadrado.
Para la generaci´on de esta tabla se requiere de un proceso iterativo
que inicia un contador en 1 y termina en n; en cada una de sus
vueltas, se debe generar el cuadrado de dicho contador y la suma
correspondiente, as´ı mismo se hace la impresi´on de los resultados.
Variables requeridas:
• cantidadNumeros: indicar´a el total de filas o n´umeros que
tendr´a la tabla (n).
• numero: esta variable tendr´a la funci´on de ir almacenando los
n´umeros desde 1 hasta la cantidad que se especifique; con ella
se calcular´a el cuadrado y la suma que se requiere para generar
los n´umeros de la tabla del enunciado.

-- 280 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 279
De acuerdo al an´alisis planteado, se propone el Algoritmo 4.33.
Algoritmo 4.33: Tabla
1 Algoritmo Tabla
2 // Declaraci´on de variables
3 Entero cantidadNumeros, numero
4
5 // Dato disponible
6 imprimir( "Ingrese la cantidad de n´umeros: " )
7 Haga
8 leer( cantidadNumeros )
9 MientrasQue( cantidadNumeros < 0 )
10 // Se valida para que no reciba valores negativos
11
12 // Generaci´on de los valores
13 Para numero = 1 Hasta cantidadNumeros Incremento 1
14 imprimir( numero, " ",
15 numero * numero, " ",
16 numero + numero * numero )
17 FinPara
18 FinAlgoritmo
Explicaci´on del algoritmo:
Lo primero que se hizo fue declarar las variables necesarias y obtener
la cantidad de n´umeros que tendr´a la tabla, validando que no se ingresen
n´umeros negativos.
3 Entero cantidadNumeros, numero
4
5 // Dato disponible
6 imprimir( "Ingrese la cantidad de n´umeros: " )
7 Haga
8 leer( cantidadNumeros )
9 MientrasQue( cantidadNumeros < 0 )
Posteriormente se procede a crearla; para ello se usa un ciclo Para,
el cual inicializa la variable numero con el valor de 1 e itera mientras
que el contenido de esta variable sea menor o igual al valor de la variable
cantidadTerminos.
13 Para numero = 1 Hasta cantidadNumeros Incremento 1
14 imprimir( numero, " ",
15 numero * numero, " ",
16 numero + numero * numero )
17 FinPara
En cada iteraci´on del ciclo Para, se imprime el valor de la variable

-- 281 of 450 --

280 Estructuras de repetici ´on
numero, su cuadrado y la suma de estos dos valores. Luego de la impresi´on
se encuentra el FinPara, se regresa al Para y la instrucci´on Incremento
1 incrementa a la variable numero en 1 unidad. Una vez m´as se eval´ua
la condici´on, mientras el valor de numero sea menor o igual al de
cantidadNumeros, se ejecuta el cuerpo del ciclo.
El cuerpo del ciclo est´a conformado solamente por la instrucci´on
imprimir. Observe que los c´alculos se hacen directamente dentro de ella:
14 imprimir( numero, " ",
15 numero * numero, " ",
16 numero + numero * numero )
Es una forma correcta de hacerlo, aunque tambi´en lo es incluir nuevas
variables para almacenar los c´alculos, tal como se muestra a continuaci´on:
Para numero = 1 Hasta cantidadNumeros Incremento 1
cuadrado = numero * numero
suma = numero + cuadrado
imprimir( numero, " ", cuadrado, " ", suma )
FinPara
A nivel del usuario, ambas soluciones son equivalentes, sin embargo,
a nivel interno existen diferencias, por ejemplo: en la primera soluci´on
es necesario hacer dos veces la misma operaci´on numero * numero,
mientras que en la segunda soluci´on solo es necesario realizar una vez esta
operaci´on. Para un algoritmo como el presente, esto no tiene un mayor
impacto, pero en soluciones que realicen un gran n´umero de iteraciones la
implicaciones en tiempo pueden ser notorias.
.:Ejemplo 4.20. Dise˜ne un algoritmo que permita calcular la siguiente
funci´on:
f (x) = x3 + x2 − 5
Para x con valores desde 0 hasta n, con incrementos de a 2.
An´alisis del problema:
Resultados esperados: cada uno de los valores que va tomando x,
con el respectivo resultado del c´alculo de la funci´on.
Datos disponibles: n (el valor m´aximo que tomar´a x).
Proceso: en primer lugar, se solicita el valor n (m´aximo que tendr´a
x). Seguidamente se debe hacer el c´alculo de la funci´on y la impresi´on

-- 282 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 281
de los resultados esperados, todo esto en un proceso repetitivo donde
x debe iniciar en 0 y llegar hasta el valor m´aximo (n) que indique el
usuario del algoritmo; en cada iteraci´on x debe incrementarse en 2
unidades.
Variables requeridas:
• valorX: almacena el valor m´aximo que tomar´a x, este dato
ser´a suministrado por el usuario del algoritmo. Esta variable
representa la n.
• funcion: variable que almacenar´a el c´alculo de la funci´on.
• x: actuar´a como la variable de control del ciclo, tomar´a valores
entre 0 y n.
De acuerdo al an´alisis planteado, se propone el Algoritmo 4.34.
Algoritmo 4.34: FuncionX
1 Algoritmo FuncionX
2 // Declaraci´on de variables
3 Entero valorX, x, funcion
4
5 // Dato disponible
6 imprimir( "Ingrese el m´aximo valor para x: " )
7 Haga
8 leer( valorX )
9 MientrasQue( valorX < 0 )
10 // Se valida para que no reciba valores negativos
11
12 // C´alculo de la funci´on
13 Para x = 0 Hasta valorX Incremento 2
14 funcion = xˆ3 + xˆ2 - 5
15 imprimir( "Para x = ", x, " f(x) = ", funcion )
16 FinPara
17 FinAlgoritmo
Al ejecutar el algoritmo:
Ingrese el m´aximo valor para x: 10
Para x = 0 fx(x) = -5
Para x = 2 fx(x) = 7
Para x = 4 fx(x) = 75
Para x = 6 fx(x) = 247
Para x = 8 fx(x) = 571
Para x = 10 fx(x) = 1095

-- 283 of 450 --

282 Estructuras de repetici ´on
Explicaci´on del algoritmo:
Despu´es de declarar las respectivas variables, el algoritmo solicita el
ingreso del m´aximo valor que tendr´a x, para el caso es llamado valorX y
se hace la validaci´on de tal forma que no acepte n´umeros negativos.
3 Entero valorX, x, funcion
4
5 // Dato disponible
6 imprimir( "Ingrese el m´aximo valor para x: " )
7 Haga
8 leer( valorX )
9 MientrasQue( valorX < 0 )
La instrucci´on Para x = 0 Hasta valorX Incremento 2, inicializa
a la variable x en 0 y la incrementa mientras sea menor o igual a valorX;
en esta soluci´on algor´ıtmica los incrementos se hacen en 2 unidades, a
diferencia de los ejemplos anteriores que se hac´ıan en 1 unidad.
En cada iteraci´on del ciclo, se calcula la funci´on y se imprime el
resultado.
13 Para x = 0 Hasta valorX Incremento 2
14 funcion = xˆ3 + xˆ2 - 5
15 imprimir( "Para x = ", x, " f(x) = ", funcion )
16 FinPara
.:Ejemplo 4.21. El C´odigo Americano Est´andar para el Intercambio de
Informaci´on o mejor conocido como c´odigo ASCII, por su nombre en
ingl´es, American Standard Code for Information Interchange, permite
unificar la representaci´on de los caracteres alfanum´ericos y c´odigos de
control en los computadores. Antes del surgimiento de este c´odigo,
cada familia de computadores utilizaba una regla diferente para la
representaci´on.
Son 256 c´odigos ASCII12 los que integran este conjunto; van desde el 0 al
255, en su representaci´on num´erica decimal. En la Tabla 4.11 se muestran
25 de ellos.
Los primeros 32 c´odigos (del 0 al 31) se conocen como c´odigos de control,
est´an reservados para controlar algunos dispositivos, por ejemplo, entre
ellos est´a el salto de l´ınea, la tecla escape, entre otros. Estos c´odigos no
son imprimibles.
12En esta direcci´on de internet, puede consultar todos los c´odigos ASCII: http:
//www.asciitable.com/. De igual forma, como dato curioso, a trav´es de esta otra
http://www.asciiarte.com/, encontrar´a dibujos realizados con estos caracteres.

-- 284 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 283
ASCII Car´acter ASCII Car´acter ASCII Car´acter ASCII Car´acter
48 ’0’ 49 ’1’ 50 ’2’ 51 ’3’
52 ’4’ 53 ’5’ 54 ’6’ 55 ’7’
56 ’8’ 57 ’9’ 58 ’:’ 59 ’;’
60 ’<’ 61 ’=’ 62 ’>’ 63 ’?’
64 ’@’ . . . . . . . . .
. . . . . . . . . . . .
91 ’[’ 92 ’\’ 93 ’]’ 94 ’ˆ’
. . . . . . . . . . . .
123 ’{’ 124 ’|’ 125 ’}’ 126 ’˜’
Tabla 4.11: Tabla de datos del Ejemplo 4.19
De acuerdo al anterior contexto dise˜ne un algoritmo que genere e
imprima los c´odigos ASCII desde el 32 al 255, en su representaci´on
num´erica decimal y su car´acter equivalente. Deben imprimirse en orden
inverso.
An´alisis del problema:
Resultados esperados: listado de los c´odigos ASCII, desde el 255
hasta el 32.
Datos disponibles: para este algoritmo no se requiere ning´un dato
proveniente del usuario.
Proceso: se requiere de un ciclo, que sea controlado a trav´es de una
variable inicializada en 255; debe disminuir de 1 en 1 y mientras llega
a 32, debe generar e imprimir los c´odigos ASCII.
Variables requeridas:
• decimal: tendr´a la funci´on de ser la variable de control del
ciclo. Tomar´a el valor inicial de 255 e ir´a decrementando en 1
unidad. Estos valores son la representaci´on num´erica en decimal
de cada uno de los c´odigos.
• ascii: almacenar´a el car´acter correspondiente a cada uno de
los c´odigos num´ericos decimales.
De acuerdo al an´alisis planteado, se propone el Algoritmo 4.35.

-- 285 of 450 --

284 Estructuras de repetici ´on
Algoritmo 4.35: Codigos
1 Algoritmo Codigos
2 // Declaraci´on de variables
3 Entero decimal
4 Caracter ascii
5
6 // Generaci´on e impresi´on de los c´odigos ASCII
7 Para decimal = 255 Hasta 32 Decremento 1
8 ascii = decimal
9 imprimir( decimal, " = ", ascii )
10 FinPara
11 FinAlgoritmo
Explicaci´on del algoritmo:
Este es un ejemplo no hay entrada de datos, por lo tanto, este algoritmo
tiene una funci´on espec´ıfica y ´unica, siempre que se ejecute mostrar´a el
mismo resultado.
La instrucci´on Para decimal = 255 Hasta 32 Decremento 1,
inicializa la variable decimal en 255, con decremento de 1 unidad en cada
iteraci´on; esto ocurre mientras decimal tenga un valor mayor o igual a
32.
En el cuerpo del ciclo se encuentra esta asignaci´on: ascii = decimal.
La variable ascii es de tipo Caracter y la variable decimal es de tipo
Entero; algunos lenguajes soportan este tipo de operaci´on de asignaci´on
solamente utilizando el signo igual (’=’), en cambio otros requieren el
uso de alguna funci´on especial para tal fin. Al hacer esta asignaci´on,
internamente la computadora realiza la conversi´on entre los tipos de datos;
para este caso convierte el valor num´erico decimal, en su correspondiente
dato de tipo Caracter.
La siguiente l´ınea en el cuerpo del ciclo, imprime el valor decimal y su
correspondiente car´acter.
9 imprimir( decimal, " = ", ascii )
Luego de la impresi´on, el c´odigo FinPara indica el final del ciclo, el
control regresa al c´odigo Para (l´ınea 7) y la variable decimal decrementa
su valor en 1 unidad y una vez m´as se vuelve a evaluar la condici´on
impl´ıcita, si el valor de decimal es mayor o igual a 32, el ciclo vuelve a
iterar. Cuando esta condici´on no se cumpla, finaliza el ciclo y se ejecuta la
instrucci´on que hay debajo del FinPara, por lo tanto, finaliza el algoritmo.

-- 286 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 285
.:Ejemplo 4.22. Elabore un algoritmo, que genere e imprima las letras del
abecedario de la siguiente forma:
Z
Z Y
Z Y X
Z Y X W
Z Y X W V