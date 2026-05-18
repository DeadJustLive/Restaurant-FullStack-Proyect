# 17. Para los siguientes algoritmos, realice la respectiva prueba de

escritorio o tabla de verificaci´on:

-- 322 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 321
a) Algoritmo Prueba1
1 Algoritmo Prueba1
2 Entero numero, divisor
3
4 numero = 6 * 4
5 Para divisor = 1 Hasta numero / 2 Incremento 1
6 Si ( numero / divisor * divisor = numero )
Entonces
7 imprimir ( divisor )
8 FinSi
9 FinPara
10 FinAlgoritmo
b) Algoritmo Prueba2
1 Algoritmo Prueba2
2 Entero t, i, r, a
3
4 t = 0
5 Haga
6 i = 2
7 Haga
8 Para r = 4 Hasta 1 Decremento 2
9 a = i + r / 2.0
10 imprimir( a )
11 FinPara
12 i = i - 1
13 MientrasQue (i >= 1)
14 t = t + 1
15 MientrasQue (t <= 1)
16 FinAlgoritmo
c) Algoritmo Prueba3
1 Algoritmo Prueba3
2 Entero r, p, g
3
4 r = 4
5 Mientras (r >= 2)
6 Para p = 1 Hasta 2 Incremento 1
7 g = 2
8 Haga
9 imprimir( p, g )
10 g = g + p
11 MientrasQue (g <= 4)
12 FinPara
13 r = r - 2
14 FinMientras
15 FinAlgoritmo

-- 323 of 450 --



-- 324 of 450 --

Cap´ıtulo 5
Procedimientos y funciones
Cada cosa tiene su belleza, pero
no todos pueden verla.
Confucio
Objetivos del cap´ıtulo:
Construir algoritmos para la soluci´on de
problemas mediante el uso de funciones y
procedimientos.
Identificar los par´ametros de cada procedi-
miento / funci´on adecuadamente.
Diferenciar entre el paso de par´ametros por
valor y por referencia.

-- 325 of 450 --



-- 326 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 325
5.1. Procedimiento
Un procedimiento es un conjunto finito de instrucciones con un ´	unico
prop´osito bien definido (responsabilidad) y que puede ser invocado
(utilizado) por medio de un nombre que lo identifica de manera ´unica.
Lo ideal es que el nombre indique la acci´on o prop´osito del procedimiento
por medio de un verbo y alg´un complemento que da sentido al verbo, por
ejemplo, imprimirMensaje, calcularDefinitiva, validarNota;
y dicho nombre es utilizado para su invocaci´on en cualquier parte del
algoritmo, cuantas veces sea necesario. Lo que esta invocaci´on implica es
que cuando el algoritmo llegue a la l´ınea de invocaci´on, se entiende que
se ejecutan todas las instrucciones definidas dentro del procedimiento. La
invocaci´on de un procedimiento puede ser realizada incluso dentro de ´el
mismo.
Una de las razones para usar procedimientos es poder descomponer un
algoritmo en partes de menor tama˜no que sean, en principio, m´as f´aciles de
comprender que el todo; por tanto, para resolver un problema se emplean
uno o varios procedimientos que en conjunto realizan la tarea deseada.
Otra raz´on importante para usar procedimientos es la reutilizaci´on de
c´odigo que implica el poder utilizar las instrucciones de un procedimiento
tantas veces como sea necesario dentro del algoritmo. En otras palabras,
un procedimiento puede ser invocado tantas veces como sea necesario.
La forma general de esta estructura es presentada en el segmento del
Algoritmo 5.1.
Algoritmo 5.1: Forma general del Procedimiento
1 Procedimiento verboComplemento ( [lista de par´ametros] )
2 Instrucci´on1
3 Instrucci´on2
4 ...
5 Instrucci´onk
6 FinProcedimiento
La mayor´ıa de procedimientos, en un algoritmo, requiere de informaci´on
para poder realizar su prop´osito, en la estructura general (Algoritmo 5.1)
se puede observar [lista de par´	ametros] que representa el lugar en
donde se debe enumerar los tipos y las variables que reciben la informaci´on
enviada al procedimiento. Estas variables se conocen como par´ametros
y solo existen dentro del procedimiento, se dice entonces que el alcance
o ´ambito de los par´ametros es local al procedimiento. Se emplean los
corchetes ( [ ] ) para indicar que la lista puede estar vac´ıa.

-- 327 of 450 --

326 Procedimientos y funciones
Los procedimientos pueden tener cualquier cantidad de par´ametros
dependiendo de la funcionalidad a realizar. El orden en que son definidos
los par´ametros solo influye en el orden en que los argumentos (valores
enviados al procedimiento) se escriben, sin alterar la funcionalidad.
Buenas pr´acticas:
Tener una cantidad razonable de par´ametros
seg´un la funcionalidad
La longitud de un procedimiento en principio no
deber´ıa ser mayor a una p´agina para facilitar su
seguimiento, de ser mayor, seguramente podr´a
ser subdividido en m´as procedimientos.
Aclaraci´on:
En este libro todos los par´ametros de los
procedimientos, almacenan siempre una copia del
valor de los argumentos, esto implica que si dentro de
un procedimiento se modifica el valor de uno o varios
de los par´ametros, este cambio no se ve reflejado en la
variable usada como argumento. El ´unico procedimiento en este libro
que tiene un comportamiento diferente es el procedimiento leer el
cual asigna un valor a la variable que se usa como argumento. En este
´ultimo caso, se dice que hay paso por referencia, y en el primer
caso, se dice que hay paso por valor.
Al igual que los par´ametros, toda las variables declaradas dentro de
un procedimiento, tienen alcance local, es decir, una vez termina el
procedimiento, la variable deja de existir y ya no es posible recuperar
su valor.
Como todos los par´ametros son variables locales, sus nombres son
totalmente independientes de los nombres de las variables utilizadas
para enviar los valores a los argumentos al momento de invocar
el procedimiento y no existir´a conflicto entre ellas si los nombre
coinciden.

-- 328 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 327
.:Ejemplo 5.1. Dise˜ne un algoritmos con procedimientos que permita
mostrar el mensaje de saludo “Hola mundo”.
An´alisis del problema:
Resultados esperados: imprimir el mensaje “Hola mundo”.
Datos disponibles: Ninguno
Proceso: imprimir el mensaje solicitado
Variables requeridas: Ninguna
De acuerdo al an´alisis planteado, se propone el Algoritmo 5.2.
Algoritmo 5.2: Mensaje
1 Algoritmo Mensaje
2 imprimirSaludo( )
3 FinAlgoritmo
4
5 Procedimiento imprimirSaludo( )
6 imprimir( "Hola mundo" )
7 FinProcedimiento
Al ejecutar el algoritmo:
Hola mundo
Explicaci´on del algoritmo:
La ´unica l´ınea del algoritmo es precisamente al invocaci´on al m´etodo
imprimirSaludo( ) el cual indica que se deben ejecutar todas la l´ıneas
definidas con este nombre, para el caso, la l´ınea 6.
6 imprimir( "Hola mundo" )
En la Figura 5.1 se muestra la soluci´on del Ejemplo 5.1 mediante un
diagrama de flujo.
Observe el s´ımbolo empleado para indicar la invocaci´on de un
procedimiento (un rect´angulo con dos peque˜nos rect´angulos a los
extremos). En el momento de la invocaci´on siempre se deben usar los
par´entesis para dejar explicito la informaci´on que se desea enviar al
procedimiento (los argumentos), que para el caso est´a vac´ıo ya que el
procedimiento no los solicita; y que ser´an recibidos en las variables locales
del procedimiento llamados par´ametros.

-- 329 of 450 --

328 Procedimientos y funciones
Inicio
imprimirSaludo( )
Final
Procedimiento
imprimirSaludo( )
“Hola mundo”
FinProcedimiento
Figura 5.1: Diagrama de flujo del Algoritmo Mensaje
.:Ejemplo 5.2. Dise˜ne un algoritmos con procedimientos que permita
ingresar el nombre de dos personas y mostrar el mensaje de saludo “Hola”
seguido del nombre de cada una de ellas de forma independiente.
An´alisis del problema:
Resultados esperados: dos mensajes de saludo, uno por cada
nombre ingresado.
Datos disponibles: los dos nombres de las personas.
Proceso: solicitar al usuario los dos nombre de las personas, luego
invocar dos veces un procedimiento que imprima el saludo del nombre
que se enviar´a como argumento.
Variables requeridas:
• nombre1: nombre de la primera persona
• nombre2: nombre de la segunda persona
. Internos al procedimiento se requiere el par´ametro:
• n: nombre de la persona a saludar.
De acuerdo al an´alisis planteado, se propone el Algoritmo 5.3.
Algoritmo 5.3: Mensaje2
1 Algoritmo Mensaje2
2 // Declaraci´on de las variables
3 Cadena nombre1, nombre2
4
5 // Datos disponibles
6 imprimir( "Ingrese el primer nombre: " )
7 leer( nombre1 )

-- 330 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 329
8
9 imprimir( "Ingrese el segundo nombre: " )
10 leer( nombre2 )
11
12 // Resultados esperados
13 imprimirSaludo( nombre1 )
14 imprimirSaludo( nombre2 )
15 FinAlgoritmo
16
17 Procedimiento imprimirSaludo( Cadena n )
18 imprimir( "Hola ", n )
19 FinProcedimiento
Al ejecutar el algoritmo:
Ingrese el primer nombre: Diana
Ingrese el segundo nombre: Ana
Hola Diana
Hola Ana
Explicaci´on del algoritmo:
Lo primero es declarar y solicitar los datos disponibles (l´ıneas de la 3 a
la 10), posteriormente se invoca dos veces el m´etodo imprimirSaludo.
13 imprimirSaludo( nombre1 )
14 imprimirSaludo( nombre2 )
Es importante comprender el significado de estas invocaciones. Lo
primero, es que mediante el nombre imprimirSaludo se identifica el
procedimiento a invocar, luego en medio de los par´ametros se env´ıa al
procedimiento la informaci´on que ´el requiera, para el caso, el valor de
la variable nombre1 y nombre2 en sus respectivas l´ıneas. El valor de
la variable se almacena en el par´ametro n del procedimiento, el cual es
impreso posteriormente.
Observe que el tipo del par´ametro n (Cadena) coincide plenamente con
el tipo del argumento, en este caso el valor de la variable nombre1 y
nombre2, las cuales son de tipo (Cadena).
En la Figura 5.2 se muestra la soluci´on del Ejemplo 5.2 mediante un
diagrama de flujo.

-- 331 of 450 --

330 Procedimientos y funciones
Inicio
nombre1
nombre2
imprimirSaludo( nombre1 )
imprimirSaludo( nombre2 )
Final
Procedimiento
imprimirSaludo( Cadena n )
“Hola ”, n
FinProcedimiento
Figura 5.2: Diagrama de flujo del Algoritmo Mensaje2
Aclaraci´on:
Sin duda alguna, los diagramas de flujo son
una herramienta importante para la representaci´on
gr´afica de un algoritmo, pero como se ha
podido evidenciar, usar ambas representaciones es
redundante, por tal motivo, solo se usar´a una u otra
representaci´on seg´un sea la necesidad en el momento.
.:Ejemplo 5.3. Dise˜ne un algoritmos con procedimientos que permita
imprimir dos secuencias de n´umeros: “3 6 9 12 . . . 3 ∗ n” y
“5 10 15 20 . . . 5 ∗ m”, en donde n y m representan la cantidad de
t´erminos de la serie.
An´alisis del problema:
Resultados esperados: la impresi´on de las dos secuencias de
n´umeros.
Datos disponibles: el valor de n y el de m para poder generar las
dos secuencias de n´umeros.
Proceso: primero se le solicita al usuario los valores de n y m, luego
se invoca dos veces un procedimiento que imprima una secuencia
dado un valor base (3 ´o 5) y el valor final (n ´o m).

-- 332 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 331
En t´erminos generales el procedimiento requiere dos par´ametros, un
valor base (base) y la cantidad (cantidad) de t´erminos. Con esta
informaci´on se imprime la serie:
1 ∗ base 2 ∗ base 3 ∗ base . . . cantidad ∗ base
Ahora si:
base = 3 y cantidad = 4 base = 5 y cantidad = 6
1 ∗ 3 2 ∗ 3 3 ∗ 3 4 ∗ 3 1 ∗ 5 2 ∗ 5 3 ∗ 5 4 ∗ 5 5 ∗ 5 6 ∗ 5
3 6 9 12 5 10 15 20 25 30
Variables requeridas:
• n: cantidad de t´erminos de la primera serie
• m: cantidad de t´erminos de la segunda serie
Internos al procedimiento se necesitan:
• base: valor de la base para generar la serie (par´ametro 1).
• cantidad: n´umero de t´erminos de la serie (par´ametro 2).
• i: variable que controla el ciclo que va desde 1 hasta cantidad
se requiere.
• termino: variable que almacena el t´ermino actual de la serie
termino = i * base.
De acuerdo al an´alisis planteado, se propone el Algoritmo 5.4.
Algoritmo 5.4: Mensaje2
1 Algoritmo Mensaje2
2 // Declaraci´on de las variables
3 Entero n, m
4
5 // Datos disponibles
6 imprimir( "Cantidad de t´erminos de la primera serie: " )
7 leer( n )
8
9 imprimir( "Cantidad de t´erminos de la segunda serie: " )
10 leer( m )
11
12 // Resultados esperados
13 imprimirSerie( 3, n )
14 imprimirSerie( 5, m )
15 FinAlgoritmo
16

-- 333 of 450 --

332 Procedimientos y funciones
17 Procedimiento imprimirSerie( Entero base, Entero cantidad )
18 Entero termino
19
20 Para i = 1 Hasta cantidad Incremento 1
21 termino = i * base
22 imprimir( termino, " " )
23 FinPara
24 FinProcedimiento
Al ejecutar el algoritmo:
Ingrese la cantidad de t´erminos de la primera serie: 4
Ingrese la cantidad de t´erminos de la segunda serie: 6
3 6 9 12
5 10 15 20 25 30
Explicaci´on del algoritmo:
En las primeras l´ıneas del algoritmo (l´ıneas de la 3 a la 10) se declaran
las variables del algoritmo y se solicitan datos disponibles.
Luego se invoca dos veces el m´etodo imprimirSerie para generar las
respectivas series. La diferencia entre ellas es el valor de la base (3 y 5) y
la cantidad de t´erminos (n y m).
13 imprimirSerie( 3, n )
14 imprimirSerie( 5, m )
Lo interesante es que no es necesario dos procedimientos para imprimir
las dos series. El procedimiento generaliza la impresi´on de cualquier serie
en donde se conoce un valor de la base y una cantidad de t´erminos.
17 Procedimiento imprimirSerie( Entero base, Entero cantidad )
Para la primera invocaci´on:
el par´ametro base toma el valor de 3
el par´ametro cantidad toma el valor de la variable n.
Para la segunda invocaci´on:
el par´ametro base toma el valor de 5
el par´ametro cantidad toma el valor de la variable m.

-- 334 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 333
Una vez los par´ametros tiene sus valores, se ejecutan las instrucciones
para imprimir la respectiva serie.
18 Entero termino
19
20 Para i = 1 Hasta cantidad Incremento 1
21 termino = i * base
22 imprimir( termino, " " )
23 FinPara
En este caso la variable termino podr´ıa ser eliminada haciendo lo
siguiente:
Para i = 1 Hasta cantidad Incremento 1
imprimir( (i * base), " " )
FinPara
Aclaraci´on:
El uso apropiado de procedimientos facilita no solo
la reutilizaci´on de c´odigo, sino que se puede ganar
legibilidad al simplificar la cantidad de l´ıneas de la