# parte V: erdadera de la decisi´on, es decir la parte que se ejecutan cuando la

condici´on es Verdadera. Por otro lado, Instrucci´	on-F representa las
instrucciones en la parte Falsa de la decisi´on, es decir, las instrucciones
que se ejecutan cuando la condici´on es Falsa.
En algunos casos, es posible no se requiera ejecutar instrucciones cuando
la condici´on sea Falsa, as´ı que dicha zona se puede eliminar de la
estructura, quedando como la presentada en el segmento del Algoritmo 3.2,
a este tipo de funciones se le denomina “Decisi´on simple” y su respectivo
diagrama se puede observar en la p´agina 54.
Algoritmo 3.2: Forma general del Si sin el SiNo
1 Si( condici´on ) Entonces
2 Instrucci´onV-1
3 Instrucci´onV-2
4 ...
5 Instrucci´onV-n
6 FinSi

-- 123 of 450 --

122 Estructuras de decisi ´on
Para poner la definici´on en otros t´erminos, imagine que desea planear
las actividades para el d´ıa domingo, entonces usted reflexiona y piensa
que: “Si hace calor, me visto con ropa deportiva y voy al parque; sino, me
visto informalmente y voy al cine”. Una forma para representar este tipo
de decisiones es por medio de un ´arbol de decisi´on (Ver Figura 3.1).
¿hace calor?
Vestir ropa deportiva
Ir al parque
S´ı
Vestir informalmente
Ir al cine
No
Figura 3.1: ´	Arbol de decisi´on para planear el domingo
Un ´arbol de decisi´on es una representaci´on gr´afica de una o varias
decisiones relacionadas, as´ı como todas las acciones asociadas a cada una
de las alternativas de la decisi´on. Es decir, qu´e sucede cuando la respuesta a
la decisi´on es Verdadera (s´	ı) o Falsa (no). Los ´arboles de decisi´on son
una herramienta fundamental para analizar los problemas que requieran de
decisiones y pueden ser usados en contexto diferentes a la programaci´on.
Aclaraci´on:
En la Figura 3.1 se observa que: se viste
deportivamente y va parque o se viste informalmente
y va al cine; pero en ning´un caso, realiza las dos
actividades.
Otro tipo de representaci´on m´as algor´ıtmica es mediante un diagrama
de flujo (Ver Figura 3.2). La diferencia principal es que con un diagrama de
flujo es posible representar todo un algoritmo, mientras que con un ´arbol
de decisi´on, solo se representa la parte asociada a la estructura de decisi´on
del algoritmo, la cual en muchos casos es suficiente para realizar el an´alisis
de los problemas.
Es posible que una decisi´on posea solo la parte verdadera de la decisi´on,
tal y como es ilustrado mediante el Ejemplo 3.1.

-- 124 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 123
Inicio
Temperatura actual
¿hace calor?
Vestir informalmente
Ir al cine
Vestir ropa deportiva
Ir al parque
Final
No	S´ı
Figura 3.2: Planeando el domingo - Versi´on 1
.:Ejemplo 3.1. Dise˜ne un algoritmo que reciba una nota definitiva entre
0.0 y 5.0. El algoritmo debe imprimir el valor ingresado, y de ser una nota
mayor o igual a 4.0, deber´a imprimir un mensaje de felicitaciones.
An´alisis del problema:
Resultados esperados: la impresi´on de una nota definitiva y el
mensaje de “Felicitaciones” siempre y cuando la nota definitiva sea
igual o superior a 4.0.
Datos disponibles: solo es necesaria la nota definitiva.
Proceso: se le solicita al usuario ingresar la nota definitiva, luego
se imprime dicha nota, finalmente se verifica si la nota es mayor o
igual a 4.0 para determinar si es no necesario imprimir un mensaje
de “Felicitaciones”. (Ver el ´arbol de decisi´on, Figura 3.3).
¿notaDefinitiva >= 4.0?
“Felicitaciones”
S´ı
No realiza ninguna acci´on
No
Figura 3.3: ´	Arbol de decisi´on del Ejemplo 3.1

-- 125 of 450 --

124 Estructuras de decisi ´on
Variables requeridas:
• notaDefinitiva: almacena el valor de la nota definitiva del
estudiante.
.	De acuerdo al an´alisis planteado, se propone el Algoritmo 3.3.
Algoritmo 3.3: Felicitaciones
1 Algoritmo Felicitaciones
2 /* Este algoritmo imprime la nota ingresada y si la nota
3 es mayor o igual a 4.0 se imprime un mensaje de
4 "Felicitaciones"
5 */
6
7 // Declaraci´on de variables
8 Real notaDefinitiva
9
10 // Dato disponible
11 imprimir( "Ingrese la nota definitiva: " )
12 leer( notaDefinitiva )
13
14 // Resultados esperados
15 imprimir( "Su definitiva es: ", notaDefinitiva )
16
17 Si( notaDefinitiva >= 4.0 )
18 imprimir( " Felicitaciones" )
19 FinSi
20
21 FinAlgoritmo
Al ejecutar el algoritmo:
Primera ejecuci´on
Ingrese la nota definitiva: 2.5
Su definitiva es: 2.5
Segunda ejecuci´on
Ingrese la nota definitiva: 4.3
Su definitiva es: 4.3 Felicitaciones
Explicaci´on del algoritmo:
Lo primero es declarar la ´unica variable que el algoritmo requiere, en
este caso (notaDefinitiva) de tipo Real. Es necesario que sea de este
tipo porque las notas pueden llegar a tener una parte decimal; luego se
procede a realizar su respectiva lectura, es decir, solicitarle al usuario el
valor de la nota definitiva del estudiante.

-- 126 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 125
11 imprimir( "Ingrese la nota definitiva: " )
12 leer( notaDefinitiva )
Observe que la impresi´on del mensaje “Felicitaciones” se realiza solo
cuando la nota ingresada es mayor o igual 4.0; adem´as note que es
necesario dejar un espacio en blanco antes de la palabra para que ella
sea impresa separadamente de la nota definitiva. Esta estructura se conoce
como decisi´on simple.
17 Si( notaDefinitiva >= 4.0 )
18 imprimir( " Felicitaciones" )
19 FinSi
De ser una nota inferior a 4.0, el algoritmo continua su ejecuci´on, para
este caso continua a la l´ınea 20 para terminar posteriormente el algoritmo.
En la Figura 3.4 se muestra la soluci´on del Ejemplo 3.1 mediante un
diagrama de flujo.
Inicio
notaDefinitiva
“Su definitiva es: ”, notaDefinitiva
notaDefinitiva>=4.0
“ Felicitaciones”
Final
No
S´ı
Figura 3.4: Diagrama de flujo del Algoritmo Felicitaciones

-- 127 of 450 --

126 Estructuras de decisi ´on
.:Ejemplo 3.2. Dise˜ne un algoritmo que reciba una nota definitiva entre
0.0 y 5.0. El algoritmo debe imprimir el valor ingresado, y un mensaje
que indique si el estudiante “Gan´	o el curso” o “Perdi´	o el curso”.
Para el ejemplo, se gana el curso solo si la nota definitiva es mayor o igual
a 3.0.
An´alisis del problema:
Resultados esperados: la impresi´on de una nota definitiva con un
mensaje que indique si el estudiante gan´o o perdi´o el curso.
Datos disponibles: solo es necesaria la nota definitiva.
Proceso: se le solicita al usuario ingresar la nota definitiva, luego se
imprime dicha nota, finalmente se verifica si la nota es mayor o igual
a 3.0 para determinar si el estudiante gan´o o perdi´o el curso. (Ver el
´arbol de decisi´on, Figura 3.5).
¿notaDefinitiva >= 3.0?
“Gan´o el curso”
S´ı
“Perdi´o el curso”
No
Figura 3.5: ´	Arbol de decisi´on del Ejemplo 3.2
Variables requeridas:
• notaDefinitiva: almacena el valor de la nota definitiva del
estudiante.
.
De acuerdo al an´alisis planteado, se propone el Algoritmo 3.4.
Algoritmo 3.4: Definitiva
1 Algoritmo Definitiva
2 /* Este algoritmo imprime la nota ingresada y si la nota
3 es mayor o igual a 3.0 se imprime un mensaje de
4 "Gan´o el curso" o en otro caso "Perdi´o el curso"
5 */
6
7 // Declaraci´on de variables
8 Real notaDefinitiva
9

-- 128 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 127
10 // Dato disponible
11 imprimir( "Ingrese la nota definitiva: " )
12 leer( notaDefinitiva )
13
14 // Resultados esperados
15 imprimir( "Su definitiva es: ", notaDefinitiva )
16
17 Si( notaDefinitiva >= 3.0 ) Entonces
18 imprimir( " Gan´o el curso" )
19 SiNo
20 imprimir( " Perdi´o el curso" )
21 FinSi
22
23 FinAlgoritmo
Al ejecutar el algoritmo:
Primera ejecuci´on
Ingrese la nota definitiva: 2.5
Su definitiva es: 2.5 Perdi´o el curso
Segunda ejecuci´on
Ingrese la nota definitiva: 4.3
Su definitiva es: 4.3 Gan´o el curso
Explicaci´on del algoritmo:
La diferencia con el Ejemplo 3.1 se encuentra en la decisi´on. En este caso
se us´o una decisi´on compuesta.
17 Si( notaDefinitiva >= 3.0 )
18 imprimir( " Gan´o el curso" )
19 SiNo
20 imprimir( " Perdi´o el curso" )
21 FinSi
Una vez que se eval´ua la expresi´on notaDefinitiva >= 3.0, su valor
de verdad determinar´a si se imprime el mensaje “Gan´o el curso” o “Perdi´o
el curso”, observe que en ning´un caso aparecer´an ambos mensajes, es decir,
el algoritmo, una vez ejecuta la parte verdadera o falsa de la decisi´on, ignora
la otra parte de la decisi´on. Para ilustrar mejor esto, observe la Figura 3.6
que presenta el respectivo diagrama de flujo.

-- 129 of 450 --

128 Estructuras de decisi ´on
Inicio
notaDefinitiva
notaDefinitiva>=3.0
“Perdi´o el curso”	“Gan´o el curso”
Final
No	S´ı
Figura 3.6: Diagrama de flujo del Algoritmo Definitiva
.:Ejemplo 3.3. Dise˜ne un algoritmo que permita solicitar tanto el nombre
como la edad de una persona y posteriormente indicar si ella es “Mayor de
edad” o “Menor de edad” seg´un la informaci´on ingresada. Para el ejemplo,
una persona se considera mayor de edad si tiene 18 a˜nos o m´as.
An´alisis del problema:
Resultados esperados: Un mensaje seg´un la edad de usuario que
indique ‘Mayor de edad” o “Menor de edad” seg´un sea el caso.
Datos disponibles: El nombre de la persona y su edad.
Proceso: se le solicita al usuario que ingrese tanto el nombre como
la edad, luego se determina cu´al de los dos mensajes debe “Mayor de
edad” o “Menor de edad” dependiendo si la persona tiene una edad
mayor o igual a 18 a˜nos. (Ver el ´arbol de decisi´on, Figura 3.7).
¿edad >= 18?
“Mayor de edad”
S´ı
“Menor de edad”
No
Figura 3.7: ´	Arbol de decisi´on del Ejemplo 3.3

-- 130 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 129
Variables requeridas:
• nombre: nombre de la persona.
• edad: edad de la persona.
.
De acuerdo al an´alisis planteado, se propone el Algoritmo 3.5.
Algoritmo 3.5: MayoriaEdad
1 Algoritmo MayoriaEdad
2 // Este algoritmo determina si una persona es mayor o
menor de edad
3
4 // Declaraci´on de variables
5 Cadena nombre, mensajeEdad
6 Entero edad
7
8 // Datos disponibles
9 imprimir( "Ingrese su nombre: " )
10 leer( nombre )
11
12 imprimir( "Ingrese su edad: " )
13 leer ( edad )
14
15 // Resultados esperados
16 Si( edad >= 18 ) Entonces
17 mensajeEdad = "Mayor de edad"
18 SiNo
19 mensajeEdad = "Menor de edad"
20 FinSi
21
22 imprimir ( "Hola ", nombre )
23 imprimir (" usted es ", mensajeEdad )
24 FinAlgoritmo
Al ejecutar el algoritmo:
Primera ejecuci´on
Ingrese su nombre: Juan Pablo
Ingrese su edad: 13
Hola Juan Pablo usted es Menor de edad
Segunda ejecuci´on
Ingrese su nombre: Carmen Cilia
Ingrese su edad: 56
Hola Carmen Cilia usted es Mayor de edad

-- 131 of 450 --

130 Estructuras de decisi ´on
Explicaci´on del algoritmo:
El Algoritmo 3.5 presenta una forma de implementar la soluci´on a este
problema. En la primera parte se declaran las variables a utilizar:
5 Cadena nombre, mensajeEdad
6 Entero edad
Luego se le solicita al usuario los datos disponibles, es decir, tanto el
nombre como la edad.
9 imprimir( "Ingrese su nombre: " )
10 leer( nombre )
11
12 imprimir( "Ingrese su edad: " )
13 leer( edad )
Posteriormente y usando el valor de verdad de la expresi´on relacional
(edad >= 18), se determina el respectivo mensaje, usando una decisi´on
compuesta.
16 Si( edad >= 18 ) Entonces
17 mensajeEdad = "Mayor de edad"
18 SiNo
19 mensajeEdad = "Menor de edad"
20 FinSi
Finalmente se procede a imprimir el mensaje correspondiente
22 imprimir ( "Hola ", nombre )
23 imprimir (" usted es ", mensajeEdad )
Observe como en el algoritmo solo existe una ´unica instrucci´on para
imprimir el mensaje correspondiente, sin embargo, otra forma v´alida ser´ıa
eliminar la variable y hacer la impresi´on dentro de la decisi´on.
Si( edad >= 18 ) Entonces
imprimir( "Hola ", nombre, " usted es Mayor de edad" )
SiNo
imprimir( "Hola ", nombre, " usted es Menor de edad" )
FinSi
O hacer la primera parte de la impresi´on antes de la decisi´on (el
mensaje es com´un para la parte verdadera y falsa) y luego por medio de la
decisi´on se determina el mensaje complementario. En este caso, tampoco
es necesaria la variable. De nuevo se deja en evidencia que un problema no
necesariamente tiene una ´unica soluci´on.

-- 132 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 131
imprimir( "Hola ", nombre, " usted es ")
Si( edad >= 18 ) Entonces
imprimir( "Mayor de edad" )
SiNo
imprimir( "Menor de edad" )
FinSi
Otra forma de escribir la estructura de decisi´on ser´ıa invertir la
condici´on, es decir edad <18; esto implicar´ıa invertir los mensajes, pero
la estructura resolver´ıa de igual manera el problema.
imprimir( "Hola ", nombre, " usted es ")
Si( edad < 18 ) Entonces
imprimir( "Menor de edad" )
SiNo
imprimir( "Mayor de edad" )
FinSi
En la Figura 3.8 se muestra la soluci´on original del Ejemplo 3.3 mediante
un diagrama de flujo.
Inicio
nombre
edad
edad >= 18
mensajeEdad = “Menor de edad”	mensajeEdad = “Mayor de edad”
“Hola ”, nombre
“ usted es ”, mensajeEdad
Final
No	S´ı
Figura 3.8: Diagrama de flujo del Algoritmo MayoriaEdad

-- 133 of 450 --

132 Estructuras de decisi ´on
.:Ejemplo 3.4. Dise˜ne un algoritmo que permita determinar el mayor de
dos n´umeros enteros.
An´alisis del problema:
Resultados esperados: el mayor de dos n´umeros ingresados por el
usuario.
Datos disponibles: los dos n´umeros enteros
Proceso: primero se le solicita al usuario los dos n´umeros enteros,
luego por medio de una decisi´on se determina el mayor de ellos,
finalmente se imprime el mayor. (Ver el ´arbol de decisi´on, Figura
3.9).
¿n1 > n2?
mayor = n1
S´ı
mayor = n2
No
Figura 3.9: ´	Arbol de decisi´on del Ejemplo 3.4
Variables requeridas:
• n1: primero n´umero entero ingresado por el usuario.
• n2: segundo n´umero entero ingresado por el usuario.
• mayor: mayor de los dos n´umeros.
.	De acuerdo al an´alisis planteado, se propone el Algoritmo 3.6.
Algoritmo 3.6: MayorNumero
1 Algoritmo MayorNumero
2 // Este algoritmo determina el mayor de dos n´umeros
3
4 // Declaraci´on de variables
5 Entero n1, n2, mayor
6
7 // Datos disponibles
8 imprimir ( "Ingrese el primer n´umero: " )
9 leer ( n1 )
10
11 imprimir ( "Ingrese el segundo n´umero: " )
12 leer ( n2 )
13
14 // Resultados esperados

-- 134 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 133
15 Si n1 > n2 Entonces
16 mayor = n1
17 SiNo
18 mayor = n2
19 FinSi
20
21 imprimir( "El mayor entre ", n1, " y ", n2 )
22 imprimir( " es ", mayor )
23 FinAlgoritmo
Al ejecutar el algoritmo:
Primera ejecuci´on
Ingrese el primer n´umero: 4
Ingrese el segundo n´umero: 56
El mayor n´umero entre 4 y 56 es 56
Segunda ejecuci´on
Ingrese el primer n´umero: 78
Ingrese el segundo n´umero: 12
El mayor n´umero entre 78 y 12 es 78
Explicaci´on del algoritmo:
Primero se declaran las variables requeridas:
5 Entero n1, n2, mayor
Posteriormente se le solicita al usuario que ingrese ambos n´umeros:
8 imprimir ( "Ingrese el primer n´umero: " )
9 leer ( n1 )
10
11 imprimir ( "Ingrese el segundo n´umero: " )
12 leer ( n2 )
Despu´es por medio de una decisi´on se determina cu´al es el mayor entre
n1 y n2, el mayor de ellos se almacena en la variable mayor.
15 Si n1 > n2 Entonces
16 mayor = n1
17 SiNo
18 mayor = n2
19 FinSi
Observe que si el valor de ambas variables es igual, el algoritmo indicar´ıa
como mayor el valor de n2, no obstante, es un resultado tan v´alido como
decir que el mayor es el valor de la variable n1, debido a que ambas
variables tiene el mismo valor.

-- 135 of 450 --

134 Estructuras de decisi ´on
Finalmente se imprime la informaci´on solicitada, complementando el
resultado con los datos suministrados por el usuario.
21 imprimir( "El mayor entre ", n1, " y ", n2 )
22 imprimir( " es ", mayor )
En la Figura 3.10 se muestra la soluci´on del Ejemplo 3.4 mediante un
diagrama de flujo.
Inicio
n1
n2
n1 > n2
mayor = n2	mayor = n1
“El mayor entre ”, n1, “ y ”, n2
“ es ”, mayor
Final
No	S´ı
Figura 3.10: Diagrama de flujo del Algoritmo MayorNumero
.:Ejemplo 3.5. Dise˜ne un algoritmo que determina si un n´umero es par o
impar. Recuerde que un n´umero es par si el resto de una divisi´on entera
con el n´umero 2 es cero.
An´alisis del problema:
Resultados esperados: un mensaje que indica que un n´umero es
par o impar.
Datos disponibles: un n´umero entero ingresado por el usuario.

-- 136 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 135
Proceso: primero se le solicita al usuario el n´umero entero, luego por
medio de una decisi´on se determina si es par o no usando el resto de
la divisi´on entera con el n´umero 2. (Ver el ´arbol de decisi´on, Figura
3.11).
¿n % 2 == 0?
“Es par”
S´ı
“Es impar”
No
Figura 3.11: ´	Arbol de decisi´on del Ejemplo 3.5
Variables requeridas:
• n: n´umero entero que el usuario ingresa
.	De acuerdo al an´alisis planteado, se propone el Algoritmo 3.7.
Algoritmo 3.7: ParImpar
1 Algoritmo ParImpar
2 // Este algoritmo determina si un n´umero es par o impar
3
4 // Declaraci´on de la variable
5 Entero n
6
7 // Datos disponibles
8 imprimir ( "Ingrese un n´umero: " )
9 leer ( n )
10
11 // Resultados esperados
12 Si( n % 2 == 0 ) Entonces
13 imprimir( "Es par" )
14 SiNo
15 imprimir( "Es impar" )
16 FinSi
17 FinAlgoritmo
Al ejecutar el algoritmo:
Primera ejecuci´on
Ingrese un n´umero: 42
Es par
Segunda ejecuci´on
Ingrese un n´umero: 73
Es impar

-- 137 of 450 --

136 Estructuras de decisi ´on
Explicaci´on del algoritmo:
Lo primero es declarar la variable requerida (l´ınea 5), luego se procede
a solicitarle al usuario los datos disponibles, en este caso (n).
8 imprimir ( "Ingrese un n´umero: " )
9 leer ( n )
Posteriormente se procede a determinar si es par o impar usando una
decisi´on y la operaci´on para determinar el resto de la divisi´on entera con
2.
12 Si( n % 2 == 0 ) Entonces
13 imprimir( "Es par" )
14 SiNo
15 imprimir( "Es impar" )
16 FinSi
Observe que tambi´en es posible invertir la parte verdadera y la parte
falsa de la decisi´on al negar la comparaci´on del valor del resto con cero.
12 Si( n % 2 != 0 ) Entonces
13 imprimir( "Es impar" )
14 SiNo
15 imprimir( "Es par" )
16 FinSi
En la Figura 3.12 se muestra la soluci´on del Ejemplo 3.5 mediante un
diagrama de flujo.
Inicio
n
n % 2 == 0
“Es impar”	“Es par”
Final
No	S´ı
Figura 3.12: Diagrama de flujo del Algoritmo ParImpar

-- 138 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 137
.:Ejemplo 3.6. Dise˜ne un algoritmo que determine si un n´umero real (x)
se encuentra dentro del rango abierto-cerrado (3.5, 7.8].
Recuerde que se considera abierto o cerrado, si el valor de l´ımite en
cuesti´on se encuentra o no incluido respectivamente. Para el ejemplo, el
l´ımite 3.5 no hace parte del rango, por ser parte del intervalo abierto, y se
reconoce por tener par´entesis ’(’; mientras que por el contrario, el valor de
7.8 s´ı hace parte al ser el intervalo cerrado, y se reconoce por el corchete
’]’. Es bueno tener en cuenta que intervalo puede ser abierto o cerrado en
cualquiera de sus dos extremos.
An´alisis del problema:
Resultados esperados: indicar si un n´umero real (x) se encuentra
dentro del rango abierto-cerrado (3.5, 7.8].
Datos disponibles: un ´unico valor real.
Proceso: primero se le solicita al usuario el valor de x, luego se
determina si el valor se encuentra dentro del rango (Figura 3.13) o
de forma an´aloga, se determina si est´a por fuera (Figura 3.14).
Para el ejemplo se emplear´a la decisi´on ilustrada en el ´arbol de la
Figura 3.13, sin embargo, ser´ıa totalmente v´alido usar la decisi´on
ilustrada en la Figura 3.14.
¿x > 3.5 Y x <= 7.8?
“Est´a en el rango”
S´ı
“No est´a en el rango”
No
Figura 3.13: ´	Arbol de decisi´on del Ejemplo 3.6 - Soluci´on 1
¿x <= 3.5 O x > 7.8?
“No est´a en el rango”
S´ı
“Est´a en el rango”
No
Figura 3.14: ´	Arbol de decisi´on del Ejemplo 3.6 - Soluci´on 2

-- 139 of 450 --

138 Estructuras de decisi ´on
Aclaraci´on:
Existe una ley de operadores l´ogicosa que
b´asicamente determina que la negaci´on de una
expresi´on l´ogica con el operador l´ogico Y, es
equivalente a negar cada operador relacionalb y
cambiar el operador l´ogico por O. La ley tambi´en
se aplica en sentido contrario.
Por ejemplo:
No ( x > 3.5 Y x <= 7.8 ) equivale a ( x <= 3.5 O x > 7.8 )
No ( x <= 3.5 O x > 7.8 ) equivale a ( x > 3.5 Y x <= 7.8 )
aLey de De Morgan
bLo contrario de: > es <=, < es >=, = es ! = y ! = es ==
Variables requeridas:
• x: valor ingresado por el usuario.
.	De acuerdo al an´alisis planteado, se propone el Algoritmo 3.8.
Algoritmo 3.8: Rango
1 Algoritmo Rango
2 /* Este algoritmo determina si un n´umero real (x) est´a en
3 el rango abierto-cerrado (3.5, 7.8]
4 */
5
6 // Declaraci´on de la variable
7 Real x
8
9 // Datos disponibles
10 imprimir ( "Ingrese un n´umero: " )
11 leer ( x )
12
13 // Resultados esperados
14 Si( x > 3.5 Y x <= 7.8 ) Entonces
15 imprimir( "Est´a en el rango" )
16 SiNo
17 imprimir( "No est´a en el rango" )
18 FinSi
19 FinAlgoritmo

-- 140 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 139
Al ejecutar el algoritmo:
Primera ejecuci´on
Ingrese un n´umero: 9.3
No est´a en el rango
Segunda ejecuci´on
Ingrese un n´umero: 2.8
No est´a en el rango
Tercera ejecuci´on
Ingrese un n´umero: 4.1
Est´a en el rango
Explicaci´on del algoritmo:
Luego de declarar la variable x (l´ınea 7) y solicitar su valor al usuario
(l´ıneas 10 y 11), se procede a emplear la respectiva decisi´on para determinar
la instrucci´on de impresi´on a utilizar.
14 Si( x > 3.5 Y x <= 7.8 ) Entonces
15 imprimir( "Est´a en el rango" )
16 SiNo
17 imprimir( "No est´a en el rango" )
18 FinSi
Pero como ya fue mencionado, tambi´en es posible invertir los textos a
imprimir al negar la expresi´on l´ogica
14 Si( No ( x > 3.5 Y x <= 7.8 ) ) Entonces
15 imprimir( "No est´a en el rango" )
16 SiNo
17 imprimir( "Est´a en el rango" )
18 FinSi
Y al aplicar la ley de De Morgan, tambi´en se puede usar:
14 Si( x <= 3.5 O x > 7.8 ) ) Entonces
15 imprimir( "No est´a en el rango" )
16 SiNo
17 imprimir( "Est´a en el rango" )
18 FinSi
En la Figura 3.15 se muestra la soluci´on del Ejemplo 3.6 mediante un
diagrama de flujo.

-- 141 of 450 --

140 Estructuras de decisi ´on
Inicio
x
x > 3.5 Y x <= 7.8
“No est´a en el rango”	“Est´a en el rango”
Final
No	S´ı
Figura 3.15: Diagrama de flujo del Algoritmo Rango
.:Ejemplo 3.7. Dise˜ne un algoritmo que determine si un n´umero real (x)
se encuentra dentro de uno de los siguientes rangos: (3.5, 7.8], [9.3, 4.5)
y [23.4, 45.3].
An´alisis del problema:
Resultados esperados: indicar si un n´umero real (x) se encuentra
dentro de uno de los siguientes rangos: (3.5, 7.8], [9.3, 4.5) y [23.4,
45.3].
Datos disponibles: un ´unico valor real.
Proceso: primero se le solicita al usuario el valor de x, luego se
determina si el valor se encuentra dentro de uno de los rangos (Figura
3.16).
¿x > 3.5 Y x <= 7.8 O x >= 9.3 Y x < 4.5 O x >= 23.4 Y x <= 45.3?
“Est´a en el rango”
S´ı
“No est´a en el rango”
No
Figura 3.16: ´	Arbol de decisi´on del Ejemplo 3.7
Variables requeridas:
• x: valor ingresado por el usuario.

-- 142 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 141
De acuerdo al an´alisis planteado, se propone el Algoritmo 3.9.
Algoritmo 3.9: Rangos
1 Algoritmo Rangos
2 /* Este algoritmo determina si un n´umero real (x) est´a en
3 el rango abierto-cerrado (3.5, 7.8]
4 */
5
6 // Declaraci´on de la variable
7 Real x
8
9 // Datos disponibles
10 imprimir ( "Ingrese un n´umero: " )
11 leer ( x )
12
13 // Resultados esperados
14 Si( x > 3.5 Y x <= 7.8 O
15 x >= 9.3 Y x < 4.5 O
16 x >= 23.4 Y x <= 45.3 ) Entonces
17 imprimir( "Est´a en el rango" )
18 SiNo
19 imprimir( "No est´a en el rango" )
20 FinSi
21 FinAlgoritmo
Explicaci´on del algoritmo:
Observa que la expresi´on l´ogica de la decisi´on no requiere par´entesis para
agrupar las expresiones relacionales, debido a que el operador Y tiene mayor
precedencia que el operador O. No obstante por legibilidad1 es posible
adicionar los par´entesis.
14 Si( (x > 3.5 Y x <= 7.8) O
15 (x >= 9.3 Y x < 4.5) O
16 (x >= 23.4 Y x <= 45.3) ) Entonces
17 imprimir( "Est´a en el rango" )
18 SiNo
19 imprimir( "No est´a en el rango" )
20 FinSi
El diagrama de flujo del Ejemplo 3.7 es similar al de la Figura 3.15, solo
que, en este se aumenta la expresi´on l´ogica que hay en la condici´on, seg´un
lo expresado anteriormente.
1Facilitar la comprensi´on

-- 143 of 450 --

142 Estructuras de decisi ´on
3.2. Decisiones anidadas
Las estructuras de decisi´on se pueden usar cuantas veces sean necesarias
en un algoritmo, incluso dentro de otra estructura de decisi´on (ver
diagrama de flujo de la p´agina 56). Para ilustrar este caso y continuando
con el ejemplo introductorio de la secci´on “Decisiones compuesta” (p´agina
122), usted sigue pensando y concluye que:
Si ¿hace calor? Entonces
Vestir ropa deportiva
Ir al parque
Sino
Vestir informalmente
Ir al cine
Si ¿tengo compa˜	n´	ıa? Entonces
• Usar el carro
Sino
• Usar transporte p´	ublico
En el diagrama de flujo de la Figura 3.17 se puede evidenciar de una
manera m´as gr´afica que la decisi´on “¿tengo compa˜n´ıa?” depende si en el
d´ıa hace calor o no. En otras palabras, si decide ir al parque, no tiene que
considerar el hecho de tener o no compa˜n´ıa para determinar el tipo de
transporte a utilizar.
Pero y si se desea decidir el tipo de transporte independientemente del
lugar a visitar, es necesario que la segunda decisi´on, no dependa de la
primera, es decir, son dos decisiones simples y no una anidada, tal y como
se aprecia a continuaci´on y se visualiza en la Figura 3.18.
Si ¿hace calor? Entonces
Vestir ropa deportiva
Ir al parque
Sino
Vestir informalmente
Ir al cine
Si ¿tengo compa˜	n´	ıa? Entonces
Usar el carro
Sino
Usar transporte p´	ublico

-- 144 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 143
Inicio
Temperatura
actual
¿hace calor?
Vestir informalmente
Ir al cine
¿tengo compa˜n´ıa?
Usar transporte p´ublico	Usar el carro
Vestir ropa deportiva
Ir al parque
Final
No	S´ı
No	S´ı
Figura 3.17: Planeando el domingo - Versi´on 2
Aclaraci´on:
Las decisiones secuenciales y anidadas, en realidad
no son dos conceptos diferentes, sino, que son los
nombres que reciben dos formas de usar las decisiones
y que dependen directamente de la soluci´on que se
est´a construyendo.
Se dice entonces que hay una decisi´on anidada, cuando existe otra
decisi´on en la parte verdadera (S´ı) o en la parte falsa (No) de una
decisi´on; en otro caso son decisiones independientes o secuenciales.

-- 145 of 450 --

144 Estructuras de decisi ´on
Inicio
Temperatura actual
¿hace calor?
Vestir informalmente
Ir al cine
¿tengo compa˜n´ıa?
Usar transporte p´ublico	Usar el carro
Vestir ropa deportiva
Ir al parque
Final
No	S´ı
No	S´ı
Figura 3.18: Planeando el domingo - Versi´on 3
.:Ejemplo 3.8. Dise˜ne un algoritmo que permita imprimir un mensaje
seg´un un car´acter dado por el usuario, independiente que sea ingresado en
may´uscula o min´uscula, seg´un la Tabla 3.1.
Caracter Mensaje a imprimir
’a’ “Android”
’i’ “iOS”
otro “Opci´on inv´alida”
Tabla 3.1: Opciones para el Ejemplo 3.8
An´alisis del problema:
Resultados esperados: el mensaje acorde al car´acter dado por la
Tabla 3.1.
Datos disponibles: el car´acter ingresado por el usuario.

-- 146 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 145
Proceso: solicitar al usuario el car´acter, luego determinar el mensaje
seg´un el ´arbol de decisi´on de la Figura 3.19.
¿opcion == ’a’ O opcion == ’A’?
“Android”
S´ı
¿opcion == ’i’ O opcion == ’I’?
“iOS”
S´ı
“Opci´on inv´alida”
No
No
Figura 3.19: ´	Arbol de decisi´on del Ejemplo 3.8
Variables requeridas:
• opcion: car´acter que el usuario ingresa
.	De acuerdo al an´alisis planteado, se propone el Algoritmo 3.10.
Algoritmo 3.10: SistamaOperativo
1 Algoritmo SistamaOperativo
2 // Este algoritmo determina un mensaje seg´un un car´acter
3
4 // Declaraci´on de la variable
5 Caracter opcion
6
7 // Datos disponibles
8 imprimir( "Ingrese un car´acter: " )
9 leer( opcion )
10
11 // Resultados esperados
12 imprimir( "Su opci´on es " )
13 Si( opcion == ’a’ O opcion == ’A’ ) Entonces
14 imprimir( "Android" )
15 SiNo
16 Si( opcion == ’i’ O opcion == ’I’ ) Entonces
17 imprimir( "iOS" )
18 SiNo
19 imprimir( "inv´alida" )
20 FinSi
21 FinSi
22 FinAlgoritmo

-- 147 of 450 --

146 Estructuras de decisi ´on
Al ejecutar el algoritmo:
Primera ejecuci´on
Ingrese un car´acter: i
Su opci´on es iOS
Segunda ejecuci´on
Ingrese un car´acter: A
Su opci´on es Android
Tercera ejecuci´on
Ingrese un car´acter: x
Su opci´on es inv´alida
Explicaci´on del algoritmo:
Lo primero es declarar la variable necesaria (l´ınea 5), luego se solicita al
usuario un car´acter.
8 imprimir( "Ingrese un car´acter: " )
9 leer( opcion )
Luego por medio de una decisi´on se determina si el car´acter ingresado es
la letra (’a’ O ’A’) para imprimir “Android”; si por el contrario, el car´acter
ingresado es otro, es necesario determinar si corresponde a la letra (’i’ O ’I’)
para imprimir “iOS”; para cualquier otro car´acter se imprime “inv´alida”.
13 Si( opcion == ’a’ O opcion == ’A’ ) Entonces
14 imprimir( "Android" )
15 SiNo
16 Si( opcion == ’i’ O opcion == ’I’ ) Entonces
17 imprimir( "iOS" )
18 SiNo
19 imprimir( "inv´alida" )
20 FinSi
21 FinSi
En la Figura 3.20 se muestra la soluci´on del Ejemplo 3.8 mediante un
diagrama de flujo, simplificado al omitir el operador l´ogico O para aceptar
la opci´on en may´usculas.

-- 148 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 147
Inicio
opcion
“Su opci´on es ”
opcion == ’a’
opcion == ’i’
“Android”
“inv´alida”	“iOS”
Final
S´ı No
S´ı No
Figura 3.20: Diagrama de flujo del Algoritmo SistamaOperativo
.:Ejemplo 3.9. Dise˜ne un algoritmo que permita imprimir un mensaje
seg´un la nota definitiva de un estudiante entre 0.0 y 5.0, de acuerdo con
la Tabla 3.2.
nota Mensaje a imprimir
< 3.0 “Insuficiente”
<= 3.5 “Aceptable”
<= 4.0 “Sobresaliente”
<= 5.0 “Excelente”
Tabla 3.2: Opciones para el Ejemplo 3.9
An´alisis del problema:
Resultados esperados: el mensaje acorde a la nota definitiva seg´un
la Tabla 3.2.
Datos disponibles: la nota definitiva ingresada por el usuario.

-- 149 of 450 --

148 Estructuras de decisi ´on
Proceso: solicitar al usuario la nota definitiva, luego determinar el
mensaje seg´un el ´arbol de decisi´on de la Figura 3.21.
¿nota < 3.0?
“Insuficiente”
S´ı
¿nota <= 3.5?
“Aceptable”
S´ı
¿nota <= 4.0?
“Sobresaliente”
S´ı
“Excelente”
No
No
No
Figura 3.21: ´	Arbol de decisi´on del Ejemplo 3.8
Observe que en el ´arbol de decisi´on no es necesario preguntar si la
nota es menor o igual 5.0, debido a que con las otras condiciones,
todas las dem´as posibilidades ya est´an cubiertas, quedando solo por
fuera el rango de una nota excelente (seg´un el ejercicio), es decir, una
nota definitiva mayor a 4.0 y menor o igual a 5.0.
Variables requeridas:
• nota: definitiva del estudiante que el usuario ingresa
De acuerdo al an´alisis planteado, se propone el Algoritmo 3.11.
Algoritmo 3.11: MensajeNota
1 Algoritmo MensajeNota
2 // Este algoritmo determina un mensaje seg´un una nota
3
4 // Declaraci´on de la variable
5 Real nota
6
7 // Datos disponibles
8 imprimir( "Ingrese la nota definitiva: " )
9 leer( nota )
10
11 // Resultados esperados
12 imprimir( "Su nota es " )

-- 150 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 149
13 Si( nota < 3.0 ) Entonces
14 imprimir( "Insuficiente" )
15 SiNo
16 Si( nota <= 3.5 ) Entonces
17 imprimir( "Aceptable" )
18 SiNo
19 Si( nota <= 4.0 ) Entonces
20 imprimir( "Sobresaliente" )
21 SiNo
22 imprimir( "Excelente" )
23 FinSi
24 FinSi
25 FinSi
26 FinAlgoritmo
Al ejecutar el algoritmo:
Primera ejecuci´on
Ingrese la nota definitiva: 4.7
Su nota es Excelente
Segunda ejecuci´on
Ingrese la nota definitiva: 3.8
Su nota es Sobresaliente
Tercera ejecuci´on
Ingrese la nota definitiva: 3.2
Su nota es Aceptable
Cuarta ejecuci´on
Ingrese la nota definitiva: 1.3
Su nota es Insuficiente
Explicaci´on del algoritmo:
Lo primero que se realiza es la declaraci´on y lectura de la ´unica variable
requerida (l´ıneas de la 5 a la 9).
Luego implementa el ´arbol de decisi´on de la Figura 3.21 mediante las
decisiones:

-- 151 of 450 --

150 Estructuras de decisi ´on
13 Si( nota < 3.0 ) Entonces
14 imprimir( "Insuficiente" )
15 SiNo
16 Si( nota <= 3.5 ) Entonces
17 imprimir( "Aceptable" )
18 SiNo
19 Si( nota <= 4.0 ) Entonces
20 imprimir( "Sobresaliente" )
21 SiNo
22 imprimir( "Excelente" )
23 FinSi
24 FinSi
25 FinSi
Es importante resaltar que se asume que la nota es siempre
ingresada en el rango v´alido, pero de no hacerlo, el algoritmo imprimir´a
“Insuficiente” para una nota menor a cero y “Excelente” para
notas mayores a 4.0. En la Figura 3.22 se muestra la soluci´on del Ejemplo
3.9 mediante un diagrama de flujo.
Inicio
nota
“Su nota es ”
nota <3.0
nota <=3.5
“Insuficiente”
nota <=4.0
“Aceptable”
“Sobresaliente” “Excelente”
Final
S´ı No
S´ı No
S´ı No
Figura 3.22: Diagrama de flujo del Algoritmo MensajeNota

-- 152 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 151
.:Ejemplo 3.10. Dise˜ne un algoritmo que determine mayor n´umero entre
cuatro posibles n´umeros
An´alisis del problema:
Resultados esperados: el mayor de cuatro n´umeros ingresados por
el usuario.
Datos disponibles: los cuatro n´umeros (n1, n2, n3 y n4).
Proceso: solicitar al usuario los cuatro n´umeros, luego por medio de
decisiones (Ver ´arbol de decisi´on de las Figura 3.23 o 3.24) determinar
el mayor de ellos y finalmente imprimir el resultado. Los elementos
al final de cada rama del ´arbol (hojas) son los valores mayores de
cada uno de los cuatro valores.
• En una primera versi´on del ´arbol de decisi´on se puede construir
sin el uso de operadores l´ogicos, el resultado se aprecia en la
Figura 3.23.
¿n1 > n2?
¿n1 > n3?
¿n1 > n4?
n1
S´ı
n4
No
S´ı
¿n3 > n4?
n3
S´ı
n4
No
No
S´ı
¿n2 > n3?
¿n2 > n4?
n2
S´ı
n4
No
S´ı
¿n3 > n4?
n3
S´ı
n4
No
No
No
Figura 3.23: ´	Arbol de decisi´on del Ejemplo 3.10 - Versi´on 1
• En esta segunda versi´on se hace el uso del operador l´ogico Y.
Aunque a primera vista el ´arbol de la Figura 3.24 es m´as peque˜no
que el de la Figura 3.23, desde el punto de vista algor´ıtmico tiene un
problema, en algunas circunstancias realiza m´as comparaciones que
el primero2; por ejemplo con los valores: n1 = 4, n2 = 3, n3 = 2 y
n4 = 10, se realizan cuatro comparaciones, en el mejor de los casos,
lo cual lo hace para ciertos casos m´as ineficiente.
2Siempre realiza tres comparaciones para llegar a un resultado.

-- 153 of 450 --

152 Estructuras de decisi ´on
¿n1 > n2 Y n1 > n3 Y n1 > n4?
n1
S´ı
¿n2 > n1 Y n2 > n3 Y n2 > n4?
n2
S´ı
¿n3 > n1 Y n3 > n2 Y n3 > n4?
n3
S´ı
n4
No
No
No
Figura 3.24: ´	Arbol de decisi´on del Ejemplo 3.10 - Versi´on 2
Aclaraci´on:
Muchos lenguajes de programaci´on, al
momento de evaluar una expresi´on l´ogica hacen
optimizaciones para ganar velocidad, entre ellas
est´an:
• Si una expresi´on l´ogica tiene el operador Y y alguna
de las comparaciones da falso, entonces, se ignoran las
dem´as, ya que sin importar el resultado ellas, el valor
final siempre ser´a falso.
• Si una expresi´on l´ogica tiene el operador O y alguna de
las comparaciones da verdadero, entonces, se ignoran las
dem´as, ya que sin importar el resultado ellas, el valor
final siempre ser´a verdadero.
Variables requeridas:
• n1: primer n´umero ingresado.
• n2: segundo n´umero ingresado.
• n3: tercer n´umero ingresado.
• n4: cuarto n´umero ingresado.
• mayor: el mayor valor de los cuatro ingresados.
.

-- 154 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 153
De acuerdo al an´alisis planteado, se propone el Algoritmo 3.12.
Algoritmo 3.12: Mayor4 - Versi´on 1
1 Algoritmo Mayor4-V1
2 // Este algoritmo determina el mayor de cuatro n´umeros
3
4 // Declaraci´on de la variable
5 Real n1, n2, n3, n4, mayor
6
7 // Datos disponibles
8 imprimir( "Ingrese el primer n´umero: " )
9 leer( n1 )
10
11 imprimir( "Ingrese el segundo n´umero: " )
12 leer( n2 )
13
14 imprimir( "Ingrese el tercer n´umero: " )
15 leer( n3 )
16
17 imprimir( "Ingrese el cuarto n´umero: " )
18 leer( n4 )
19
20 // Determina el mayor de los cuatro n´umeros
21 Si( n1 > n2 ) Entonces
22 Si( n1 > n3 ) Entonces
23 Si( n1 > n4 ) Entonces
24 mayor = n1
25 SiNo
26 mayor = n4
27 FinSi
28 SiNo
29 Si( n3 > n4 ) Entonces
30 mayor = n3
31 SiNo
32 mayor = n4
33 FinSi
34 FinSi
35 SiNo
36 Si( n2 > n3 ) Entonces
37 Si( n2 > n4 ) Entonces
38 mayor = n2
39 SiNo
40 mayor = n4
41 FinSi
42 SiNo
43 Si( n3 > n4 ) Entonces
44 mayor = n3
45 SiNo
46 mayor = n4

-- 155 of 450 --

154 Estructuras de decisi ´on
47 FinSi
48 FinSi
49 FinSi
50
51 // Resultados esperados
52 imprimir( "La n´umero mayor es: ", mayor )
53 FinAlgoritmo
Al ejecutar el algoritmo:
Primera ejecuci´on
Ingrese el primer n´umero: 27
Ingrese el segundo n´umero: 11
Ingrese el tercer n´umero: 343
Ingrese el cuarto n´umero: 20
El mayor de todos es 343
Segunda ejecuci´on
Ingrese el primer n´umero: 31
Ingrese el segundo n´umero: 5
Ingrese el tercer n´umero: 73
Ingrese el cuarto n´umero: 19
El mayor de todos es 73
Explicaci´on del algoritmo:
En ambos casos, se declaran todas las variables y se solicitan todos los
datos conocidos.
5 Real n1, n2, n3, n4, mayor
6
7 // Datos disponibles
8 imprimir( "Ingrese el primer n´umero: " )
9 leer( n1 )
10
11 imprimir( "Ingrese el segundo n´umero: " )
12 leer( n2 )
13
14 imprimir( "Ingrese el tercer n´umero: " )
15 leer( n3 )
16
17 imprimir( "Ingrese el cuarto n´umero: " )
18 leer( n4 )
Luego usando las respectivas decisiones se determina el mayor n´umero
y finalmente se imprime.

-- 156 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 155
Otra posibilidad es reemplazar todas las l´ıneas de la decisi´on anidada
(l´ıneas de la 21 a la 49) por el siguiente c´odigo, obteniendo exactamente el
mismo resultado.
// Determina el mayor de los cuatro n´umeros
Si( n1 > n2 Y n1 > n3 Y n1 > n4 ) Entonces
mayor = n1
SiNo
Si( n2 > n1 Y n2 > n3 Y n2 > n4 ) Entonces
mayor = n2
SiNo
Si( n3 > n1 Y n3 > n2 Y n3 > n4 ) Entonces
mayor = n3
SiNo
mayor = n4
FinSi
FinSi
FinSi
Existen otras alternativas para resolver este problema. A continuaci´on se
presenta una tercera versi´on en la que se van descartando aquellos n´umeros
que no son mayores y que va reduciendo el n´umero de comparaciones a
realizar.
// Determina el mayor de los cuatro n´umeros
Si( n1 > n2 Y n1 > n3 Y n1 > n4 ) Entonces
mayor = n1
SiNo
Si( n2 > n3 Y n2 > n4 ) Entonces
mayor = n2
SiNo
Si( n3 > n4 ) Entonces
mayor = n3
SiNo
mayor = n4
FinSi
FinSi
FinSi

-- 157 of 450 --

156 Estructuras de decisi ´on
Aclaraci´on:
Este ejemplo de determinar el mayor de cuatro
n´umeros, le muestra nuevamente al lector que existen
diversas maneras de resolver un problema. Es una
habilidad a desarrollar en el dise˜nador del algoritmo,
la capacidad de discernir y seleccionar la “mejor”
opci´on entre las posibles soluciones.
Sin embargo, puede observar que en la medida que el n´umero de variables
aumenta, el n´umero de posibles alternativas tambi´en lo hace, as´ı como la
complejidad de los respectivos ´arboles de decisi´on.
Otra posibilidad ser´ıa resolver el problema mediante el uso de decisiones
simples, por tanto, si se reeescribe la parte de las decisiones de la siguiente
manera:
// Determina el mayor de los cuatro n´umeros
mayor = n1
Si( n2 > mayor ) Entonces
mayor = n2
FinSi
Si( n3 > mayor ) Entonces
mayor = n3
FinSi
Si( n4 > mayor ) Entonces
mayor = n4
FinSi
La soluci´on que se obtiene es f´acilmente ampliable a cualquier cantidad
de variables a comparar, sin hacer m´as complejo el algoritmo y mantiene
el n´umero de comparaciones en el ideal.
Este ejemplo ilustra la importancia que tiene realizar un buen an´alisis
del problema antes de comenzar a crear una soluci´on.
.:Ejemplo 3.11. La oficina de aguas de la ciudad requiere crear un
algoritmo que le permita liquidar las facturas de sus clientes durante cada
mes. El cobro de cada factura se realiza de la siguiente forma: se cobra el
cargo fijo, el consumo de agua en el periodo, es decir, la cantidad de metros
consumidos y el servicio de recolecci´on de basuras y alcantarillado. Todos
estos cobros se llevan a cabo dependiendo del estrato socioecon´omico al que
pertenezca el predio, de acuerdo con la siguiente tabla:

-- 158 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 157
Estrato Cargo Fijo Metro3 consumido Basuras y alcantarillado
1 $2500 $2200 $5500
2 $2800 $2350 $6200
3 $3000 $2600 $7400
4 $3300 $3400 $8600
5 $3700 $3900 $9700
6 $4400 $4800 $11000
Construya un algoritmo que, al ingresarle es estrato socioecon´omico del
predio y la cantidad de metros c´ubicos de agua consumidos, permita
determinar el valor de la factura a pagar.
An´alisis del problema:
Resultados esperados: los valores a pagar en la factura de aguas,
discriminando el valor del cargo fijo, el valor del consumo, el del
servicio de recolecci´on de basura y alcantarillado y que entregue el
valor total a pagar.
Datos disponibles: el estrato socioecon´omico y la cantidad de
metros consumidos.
Proceso: primero ser´a ingresar los datos disponibles, posterior-
mente, basado en el estrato, ser´a necesario utilizar una estructura
de decisi´on anidada que permita determinar el valor del cargo fijo, el
valor del consumo que se obtiene multiplicando la cantidad de metros
consumidos por el valor de cada metro dependiendo por supuesto, del
estrato y, adem´as, determinar tambi´en el valor de la recolecci´on de
basuras y alcantarillado. Luego de tener todos estos valores, se deben
sumar para encontrar el valor total a pagar. Al finalizar, se muestran
al usuario todos estos resultados encontrados.
Variables requeridas:
• estrato: almacena el estrato socioecon´omico del predio.
• cantidad: cantidad de metros consumidos por el cliente.
• cargoFijo: valor del cargo fijo.
• valorConsumo: valor del consumo.
• valorRecoleccion: valor de la recolecci´on de las basuras y
el alcantarillado.
• totalPago: valor total a pagar por el servicio.
.

-- 159 of 450 --

158 Estructuras de decisi ´on
De acuerdo al an´alisis planteado, se propone el Algoritmo 3.13.
Algoritmo 3.13: FacturaAgua
1 Algoritmo FacturaAgua
2 // Este algoritmo calcula el pago de una factura de agua
3 Caracter estrato
4 Real cantidad, cargoFijo, consumo, valorRecoleccion,
5 totalPago
6
7 imprimir( "Estrato socioecon´omico del predio: " )
8 leer( estrato )
9
10 imprimir( "Cantidad de metros consumidos: " )
11 leer( cantidad )
12
13 Si( estrato == ’1’ ) Entonces
14 cargoFijo = 2500.0
15 valorConsumo = cantidad * 2200.0
16 valorRecolecci´on = 5500.0
17 SiNo
18 Si( estrato == ’2’ ) Entonces
19 cargoFijo = 2800.0
20 valorConsumo = cantidad * 2350.0
21 valorRecolecci´on = 6200.0
22 SiNo
23 Si( estrato == ’3’ ) Entonces
24 cargoFijo = 3000.00
25 valorConsumo = cantidad * 2600.0
26 valorRecolecci´on = 7400.0
27 SiNo
28 Si( estrato == ’4’ ) Entonces
29 cargoFijo = 3300.00
30 valorConsumo = cantidad * 3400.0
31 valorRecolecci´on = 8600.0
32 SiNo
33 Si( estrato == ’5’ ) Entonces
34 cargoFijo = 3700.00
35 valorConsumo = cantidad * 3900.0
36 valorRecolecci´on = 9700.00
37 SiNo
38 cargoFijo = 2800.00
39 valorConsumo = cantidad * 2350.0
40 valorRecolecci´on = 6200.0
41 FinSi
42 FinSi
43 FinSi
44 FinSi
45 FinSi
46

-- 160 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 159
47 totalPago = cargoFijo + valorConsumo + valorRecoleccion
48
49 imprimir( "Valor del cargo fijo: ", cargoFijo )
50 imprimir( "Valor del consumo: ", cantidad )
51 imprimir( "Valor de la recolecci´on: ", valorRecoleccion )
52 imprimir( "Total a pagar: ", totalPago )
53 FinAlgoritmo
Explicaci´on del algoritmo: En este algoritmo, las primeras l´ıneas
(l´ıneas 2 a 5) se hace ˜na declaraci´on de las variables, luego (l´ıneas 7 a 11)
permiten solicitar los datos que se requieren, esto es estrato y cantidad
de metros consumidos; para ello se utilizaron las instrucciones imprimir y
leer.
2 Caracter estrato
3 Real cantidad, cargoFijo, consumo, valorRecoleccion,
4 totalPago
5
6 imprimir( "Estrato socioecon´omico del predio: " )
7 leer( estrato )
8
9 imprimir( "Cantidad de metros consumidos: " )
10 leer( cantidad )
A continuaci´on, el algoritmo utiliza una estructura Si anidada
(l´ıneas 13 a la 45) que va determinando paulatinamente cual es el
estrato socioecon´omico ingresado con el prop´osito de aplicar los valores
correspondientes a ese estrato. El primer Si, pregunta si el estrato
ingresado es ’1’, si esto ocurre, se hacen los c´alculos indicados para ese
estrato pero, si por el contrario, el estrato no es ’1’, dentro del SiNo
del primer, Si, se ubica una segunda estructura Si que pregunta si el
estrato es ’2’, si esto es verdadero, se realizan los c´alculos pertinentes
para este segundo estrato pero, si el estrato tampoco es ’2’, por el SiNo
del segundo Si, se utiliza un tercer Si para preguntar entonces, si el
estrato es ’3’. De la misma forma, el algoritmo contin´ua analizando los
estratos ’4’ y ’5’. Note que, al finalizar el ´ultimo Si, por la parte del SiNo,
se ubican los c´alculos correspondientes al estrato ’6’; esto se hace de esta
forma, ya que si el algoritmo no ingres´o a ninguna de las partes verdaderas
de los Si anteriores, esto indica que el estrato no es ni ’1’, ’2’, ’3’, ’4’, ’5’,
por lo cu´al solo queda por descarte, el estrato ’6’.

-- 161 of 450 --

160 Estructuras de decisi ´on
3.3. Decisiones m´	ultiples
Las decisiones m´ultiples, tambi´en conocida como “estructura selectiva”,
en realidad son una forma abreviada de reescribir un tipo especial de
decisi´on anidada, la utilizada para seleccionar un opci´on entre un conjunto
de valores; por lo anterior, toda decisi´on m´ultiple se puede reescribir como
una decisi´on anidada, pero no toda decisi´on anidada se puede reescribir
como una decisi´on m´ultiple.
La forma general de esta estructura es presentada en el segmento del
Algoritmo 3.14.
En esta forma general se puede observar que existen un conjunto k de
valores (valor1 hasta la valork).
Cada valor a su vez tiene un conjunto independiente de instrucciones
que est´a delimitado desde la instrucci´on (Caso valor:) hasta FinCaso,
todas estas instrucciones se ejecutan cuando el contenido de la variable
denominada selector coincide con el de la valor en cuesti´on.
Algoritmo 3.14: Forma general de las decisiones m´ultiples
1 Segun( selector )
2 Caso valor1: InstruccionA1-1
3 InstruccionA1-2
4 ...
5 InstruccionA1-n1
6 FinCaso
7
8 Caso valor2: InstruccionA2-1
9 InstruccionA2-2
10 ...
11 InstruccionA2-n2
12 FinCaso
13 ...
14
15 Caso valork: InstruccionAk-1
16 InstruccionAk-2
17 ...
18 InstruccionAk-nk
19 FinCaso
20
21 EnOtroCaso: InstruccionOtroCaso-1
22 InstruccionOtroCaso-2
23 ...
24 InstruccionOtroCaso-n
25 FinCaso
26 FinSegun

-- 162 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 161
Aclaraci´on:
Si se omite la instrucci´on FinCaso, el algoritmo
continua la ejecuci´on a las instrucciones del siguiente
valor y as´ı sucesivamente hasta encontrar un
FinCaso o un FinSegun. Esta caracter´ıstica
permite crear ciertos comportamientos deseables en
un algoritmo.
Si el contenido de la variable selector no incide con ninguna de los
valores, se ejecutan las instrucciones de la secci´on llamada EnOtroCaso,
la cual se suele escribir despu´es de todas los valores v´alidos.
El tipo de dato de la variable selector suele estar limitada a: Entero,
Caracter o Cadena. No se utilizan selectores tipo Real.
El equivalente de esta estructura mediante decisiones anidadas se
presenta en el Algoritmo 3.15.
Algoritmo 3.15: Forma general del Segun mediante Si
1 Si( selector == valor1 ) Entonces
2 InstruccionA1-1
3 InstruccionA1-2
4 ...
5 InstruccionA1-n1
6 SiNo
7 Si( selector == valor2 ) Entonces
8 InstruccionA2-1
9 InstruccionA2-2
10 ...
11 InstruccionA2-n2
12 SiNo
13 ...
14
15 Si( selector == valork ) Entonces
16 InstruccionAk-1
17 InstruccionAk-2
18 ...
19 InstruccionAk-nk
20 SiNo
21 InstruccionOtroCaso-1
22 InstruccionOtroCaso-2
23 ...
24 InstruccionOtroCaso-n
25 FinSi
26 FinSi
27 FinSi

-- 163 of 450 --

162 Estructuras de decisi ´on
La estructura general de una decisi´on m´ultiple en un diagrama de flujo
se puede observar en la Figura 3.25.
selector
InstruccionesA1 Instruciones
por defecto	InstruccionesA2 InstrucionesAk
valor1 [en otro caso]
valor2 valork
Figura 3.25: Decisiones m´ultiples - Estructura General
Observe que en el diagrama de flujo de la decisi´on m´ultiple (Figura
3.25) corresponde a un diagrama en donde todas las instrucciones Caso
tienen su respectivo FinCaso. Si una de estas instrucciones de finalizaci´on
(FinCaso) fuera omitida, por ejemplo la de la valor2, el diagrama
general sufre un cambio y quedar´ıa como el presentado en la Figura 3.26.
selector
InstruccionesA1 Instruciones
por defecto	InstruccionesA2 InstrucionesAk
valor1 [en otro caso]
valor2 valork
Figura 3.26: Decisiones m´ultiples - Sin el segundo FinCaso

-- 164 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 163
Las decisiones m´ultiples son solo una forma abreviada de reescribir
ciertas decisiones anidadas. Aqu´ı se presentan algunos ejemplos que
ilustran su uso.
.:Ejemplo 3.12. Reescribir el Ejemplo 3.8 pero con decisiones m´ultiples.
Considerando el an´alisis del Ejemplo 3.8, se propone entonces el
Algoritmo 3.16.
Algoritmo 3.16: SistamaOperativo
1 Algoritmo SistamaOperativo
2 // Este algoritmo determina un mensaje seg´un un car´acter
3
4 // Declaraci´on de la variable
5 Caracter opcion
6
7 // Datos disponibles
8 imprimir( "Ingrese un car´acter: " )
9 leer( opcion )
10
11 // Resultados esperados
12 imprimir( "Su opci´on es " )
13
14 Segun( opcion )
15 Caso ’a’:
16 Caso ’A’: imprimir( "Android" )
17 FinCaso
18
19 Caso ’i’:
20 Caso ’I’: imprimir( "iOS" )
21 FinCaso
22
23 EnOtroCaso:
24 imprimir( "inv´alida" )
25 FinCaso
26 FinSegun
27 FinAlgoritmo
Al ejecutar el algoritmo:
Se obtiene exactamente el mismo resultado del ejemplo original.
Primera ejecuci´on
Ingrese un car´acter: i
Su opci´on es iOS

-- 165 of 450 --

164 Estructuras de decisi ´on
Segunda ejecuci´on
Ingrese un car´acter: A
Su opci´on es Android
Tercera ejecuci´on
Ingrese un car´acter: x
Su opci´on es inv´alida
Explicaci´on del algoritmo:
Observe que para este ejemplo se omiti´o el FinCaso del primer y tercer
valor (l´ıneas 15 y 19), debido a que se necesita que se ejecute la misma
instrucci´on de impresi´on para los casos en donde el valor es una letra
may´uscula o min´uscula.
Como la variable selector es de tipo Caracter, el valor de todos
los valores se escribe entre comillas simples (’ ’). Si fuera de tipo Cadena
se escribir´ıa entre comillas dobles (“ ”) y si fuera Entero, solo se escribe
el n´umero.
Aclaraci´on:
No es posible usar decisiones m´ultiples con
operadores relacionales u operadores l´ogicos. Una
decisi´on m´ultiple es una decisi´on de selecci´on en
donde cierta variable llamada selector almacena
uno de los valores definidos y en cuyo caso se procede
a ejecutar el conjunto de instrucciones asociadas a dicho valor.
.:Ejemplo 3.13. Dise˜ne un algoritmo que permite conocer el valor del
descuento de un art´ıculo seg´un su tipo. Todos los tipos y sus respectivos
descuentos se pueden observar en la Tabla 3.3.
Tipo Descuento
1 12.5 %
2 8.3 %
3 3.2 %
Otro 0.0 %
Tabla 3.3: Opciones para el Ejemplo 3.13

-- 166 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 165
An´alisis del problema:
Resultados esperados: el valor del descuento en el precio de un
art´ıculo seg´un el tipo del mismo y definidos en la Tabla 3.3.
Datos disponibles: el valor del art´ıculo, as´ı como el tipo de art´ıculo.
Proceso: se le solicita el usuario del valor del art´ıculo y su respectivo
tipo, luego seg´un los porcentajes de descuento de la Tabla 3.3 para
cada uno de los tipos se define el porcentaje, posteriormente con el
porcentaje se calcula el valor del descuento y finalmente se imprime
su valor.
Variables requeridas:
• valor: representa el valor del art´ıculo
• descuento: representa el valor del descuento.
• porcentaje: valor que representa el porcentaje de descuento
asignado al art´ıculo seg´un el tipo
.	De acuerdo al an´alisis planteado, se propone el Algoritmo 3.17.
Algoritmo 3.17: DescuentoArticulo
1 Algoritmo DescuentoArticulo
2 // Este algoritmo determina el descuento de un art´ıculo
3
4 // Declaraci´on de la variable
5 Caracter tipo
6 Real valor, descuento, porcentaje
7
8 // Datos disponibles
9 imprimir( "Ingrese el valor del art´ıculo: " )
10 leer( valor )
11
12 imprimir( "Ingrese el tipo de art´ıculo: " )
13 leer( tipo )
14
15 // Se calculan los datos esperados
16 Segun( tipo )
17 Caso ’1’: porcentaje = 0.125 // 12.5 %
18 FinCaso
19
20 Caso ’2’: porcentaje = 0.083 // 8.3 %
21 FinCaso
22
23 Caso ’3’: porcentaje = 0.032 // 3.2 %
24 FinCaso

-- 167 of 450 --

166 Estructuras de decisi ´on
25
26 EnOtroCaso:
27 porcentaje = 0.0
28 FinCaso
29 FinSegun
30
31 descuento = valor * porcentaje
32
33 // Resultados esperados
34 imprimir( "El valor del descuento es: ", descuento )
35 FinAlgoritmo
Al ejecutar el algoritmo:
Primera ejecuci´on
Ingrese el valor del art´ıculo: 2500
Ingrese el tipo de art´ıculo: 2
El valor del descuento es: 207.5
Segunda ejecuci´on
Ingrese el valor del art´ıculo: 2500
Ingrese el tipo de art´ıculo: 3
El valor del descuento es: 80
Explicaci´on del algoritmo:
Despu´es de declarar todas las variables (l´ıneas 5 y 6) y solicitar los datos
disponibles (l´ıneas de la 9 a la 13), se procede a determinar el porcentaje
de descuento usando la decisi´on m´ultiple (l´ıneas de la 16 a la 29).
Una vez determinado el valor del porcentaje, se procede a calcular el
valor del descuento al multiplicar este porcentaje por el valor del art´ıculo
(l´ınea 31); finalmente se procede a imprimir el valor del descuento.
.:Ejemplo 3.14. Dise˜ne un algoritmo que permita imprimir la capital de
uno de los departamentos de la zona cafetera de Colombia o un mensaje
que indique que el departamento especificado no hace parte de dicha zona.
An´alisis del problema:
Resultados esperados: el nombre de la capital de uno de los
departamentos de la zona cafetera o un mensaje que indique que
el departamento indicado no hace parte de la zona cafetera de
Colombia.

-- 168 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 167
Datos disponibles: el nombre del departamento.
Proceso: solicitar al usuario el nombre de un departamento, luego
por medio de una decisi´on m´ultiple se procede a determinar el nombre
de la capital; finalmente se procede a imprimir la capital. Si el nombre
del departamento no corresponde a un de los departamentos de la
zona cafetera, se asigna (“ ”)3 en la capital para poder posteriormente
indicar que dicho departamento no hace parte de la zona cafetera.
Variables requeridas:
• departamento: nombre del departamento del que se desea
conocer la capital
• capital: nombre la capital del departamento indicado o (“”)
para indicar que el departamento indicado no pertenece a la
zona cafetera.
.
De acuerdo al an´alisis planteado, se propone el Algoritmo 3.18.
Algoritmo 3.18: Capitales
1 Algoritmo Capitales
2 // Este algoritmo determina la capital de los
3 // departamentos de la zona cafetera de Colombia
4
5 // Declaraci´on de la variable
6 Cadena departamento, capital
7
8 // Datos disponibles
9 imprimir( "Ingrese el nombre del departamento: " )
10 leer( departamento )
11
12 // Se calculan los datos esperados
13 Segun( departamento )
14 Caso "Quindio": capital = "Armenia"
15 FinCaso
16
17 Caso "Caldas": capital = "Manizales"
18 FinCaso
19
20 Caso "Risaralda": capital = "Pereira"
21 FinCaso
22 EnOtroCaso:
23 capital = ""
24 FinCaso
3Una cadena vacia

-- 169 of 450 --

168 Estructuras de decisi ´on
25 FinSegun
26
27 // Resultados esperados
28 Si( capital != "" ) Entonces
29 imprimir( "La capital del ", departamento )
30 imprimir( " es ", capital )
31 SiNo
32 imprimir ( "No es un departamento cafetero" )
33 FinSi
34 FinAlgoritmo
Al ejecutar el algoritmo:
Primera ejecuci´on
Ingrese el nombre del departamento: Quindio
La capital del Quindio es Armenia
Segunda ejecuci´on
Ingrese el nombre del departamento: Amazonas
No es un departamento cafetero
Explicaci´on del algoritmo:
Despu´es de declarar todas las variables (l´ınea 6) y solicitar los datos
disponibles (l´ıneas 9 y 10), los datos deben ser ingresados de forma id´entica.
Posteriormente se procede a determinar la capital del departamento
usando la decisi´on m´ultiple (l´ıneas de la 13 a la 25). Observe que el tipo
de la variable departamento es Cadena, por lo tanto en los valores
se escriben con comillas dobles, por ejemplo: Caso "Quindio":, Caso
"Caldas": . . .
Al finalizar esta estructura de decisi´on, el algoritmo ya habr´a
determinado el nombre de la capital del departamento ingresado; sin
embargo, si se ingres´o un departamento que no concuerda con uno del
Eje cafetero, el algoritmo asignar´a una “cadena vac´ıa” () a la variable
capital.
Al final del algoritmo (l´ıneas de la 28 a la 33), se muestra el nombre de
la capital o en su defecto se un mensaje informando que el departamento
ingresado no es uno del Eje cafetero.

-- 170 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 169
.:Ejemplo 3.15. La oficina de incorporaci´on del ej´ercito necesita un
algoritmo que le pueda permitir saber si un aspirante a ingresar a la
instituci´on como soldado es apto o no para poder vincularlo. Para que
una persona sea apta, debe cumplir los siguientes requisitos:
Si es mujer, su estatura debe ser superior a 1.60 mts y su edad debe
estar entre 20 y 25 a˜nos.
Si el aspirante es hombre, se estatura debe ser superior a 1.65 mts y
su edad debe estar entre los 18 y 24 a˜nos.
Tanto mujeres como hombres deben ser solteros. Dise˜ne el algoritmo de tal
forma que permita informar si un aspirante es apto o no para ingresar al
ej´ercito.
Aclaraci´on:
Antes que nada, es importante recordar que un
algoritmo puede implementarse de diferentes formas;
la que se va a utilizar aqu´ı es solo una de ellas.
An´alisis del problema:
Resultados esperados: informar si el aspirante al que se le han
ingresado sus datos es “Apto” o “No es apto” para ingresar al ej´ercito.
Datos disponibles: el estado civil del aspirante, su g´enero, su edad
y su estatura.
Proceso: lo primero ser´a ingresar los datos disponibles, posterior-
mente, se deben usar varias estructuras de decisi´on que vayan
permitiendo saber si el aspirante es apto o no lo es, dependiendo
de si cumple los requisitos de estado civil, estatura y edad que se
mencionan para cada g´enero.
Variables requeridas:
• genero: representa el g´enero o sexo del aspirante.
• estadoCivil: corresponde al estado civil del aspirante.
• estatura: es la estatura del aspirante.
• edad: indica la edad del aspirante.
• salida: variable que contendr´a el mensaje a mostrar, o sea, si
el aspirante es o no apto.

-- 171 of 450 --

170 Estructuras de decisi ´on
.	De acuerdo al an´alisis planteado, se propone el Algoritmo 3.19.
Algoritmo 3.19: AspiranteEjercito
1 Algoritmo AspiranteEjercito
2 Caracter genero, estadoCivil
3 Cadena salida
4 Real estatura
5 Entero edad
6
7 imprimir( "G´enero del aspirante (M/F): " )
8 leer( genero )
9
10 imprimir( "Estado civil del aspirante (S/C/V/D/U): " )
11 leer( estadoCivil )
12
13 imprimir( "Estatura del aspirante: " )
14 leer( estatura )
15
16 imprimir( "Edad del aspirante: " )
17 leer( edad )
18
19 Si (estadoCivil == ’S’ O estadoCivil == ’s’ ) Entonces
20 Segun( genero )
21 Caso ’F’:
22 Caso ’f’: Si( estatura > 1.60 Y
23 edad >= 20 Y edad <= 25 ) Entonces
24 salida = "Es Apto"
25 SiNo
26 salida = "No es Apto"
27 FinSi
28
29 Caso ’M’:
30 Caso ’m’: Si( estatura > 1.65 Y
31 edad>=18 Y edad<=24 ) Entonces
32 salida = "Es Apto"
33 SiNo
34 salida = "No es Apto"
35 FinSi
36 SiNo
37 salida = "No es Apto"
38 FinCaso
39
40 EnOtroCaso: salida = ""
41 FinCaso
42 FinSegun
43 SiNo
44 salida = "No es Apto"
45 FinSi
46

-- 172 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 171
47 Si( salida == "" ) Entonces
48 imprimir( "G´enero incorrecto" )
49 SiNo
50 imprimir( "El aspirante: ", salida )
51 FinSi
52 FinAlgoritmo
Explicaci´on del algoritmo:
El algoritmo inicia declarando las variables que se necesitan en las
primeras l´ıneas.
2 Caracter genero, estadoCivil
3 Cadena salida
4 Real estatura
5 Entero edad
A continuaci´on, se solicitan los datos con la instrucci´on imprimir y se
capturan con la instrucci´on leer.
7 imprimir( "G´enero del aspirante (M/F): " )
8 leer( genero )
9
10 imprimir( "Estado civil del aspirante (S/C/V/D/U): " )
11 leer( estadoCivil )
12
13 imprimir( "Estatura del aspirante: " )
14 leer( estatura )
15
16 imprimir( "Edad del aspirante: " )
17 leer( edad )
Acto seguido, se utiliza un decisi´on para determinar si el aspirante es
soltero(a). Si es cumple esta decisi´on, se emplea una decisi´on m´ultiple
para decidir sobre la edad y la estatura seg´un el sexo. Note que cada caso
considera la letra tanto en may´uscula, como en min´uscula.
19 Si (estadoCivil == ’S’ O estadoCivil == ’s’ ) Entonces
20 Segun( genero )
21 Caso ’F’:
22 Caso ’f’: Si( estatura > 1.60 Y
23 edad >= 20 Y edad <= 25 ) Entonces
24 salida = "Es Apto"
25 SiNo
26 salida = "No es Apto"
27 FinSi
28
29 Caso ’M’:
30 Caso ’m’: Si( estatura > 1.65 Y

-- 173 of 450 --

172 Estructuras de decisi ´on
31 edad>=18 Y edad<=24 ) Entonces
32 salida = "Es Apto"
33 SiNo
34 salida = "No es Apto"
35 FinSi
36 SiNo
37 salida = "No es Apto"
38 FinCaso
39
40 EnOtroCaso: salida = ""
41 FinCaso
42 FinSegun
43 SiNo
44 salida = "No es Apto"
45 FinSi
En caso que el usuario ingrese un genero incorrecto, el algoritmo
ejecutar´a la instrucci´on EnOtroCaso, all´ı, se almacenar´a en la variable
salida una cadena vac´ıa (“”). Esta cadena vac´ıa servir´a como bandera
para poder imprimir el mensaje adecuado en la parte final del algoritmo.
47 Si( salida == "" ) Entonces
48 imprimir( "G´enero incorrecto" )
49 SiNo
50 imprimir( "El aspirante: ", salida )
51 FinSi
Observe lo que pasar´ıa si en lugar de asignar a la variable salida una
cadena vac´ıa, se asignara el mensaje "G´	enero incorrecto"; en este
caso, al imprimir el mensaje al final se obtendr´ıa:
El aspirante: G´enero incorrecto
En lugar de:
G´enero incorrecto
.:Ejemplo 3.16. Reescribiendo el Ejemplo 3.11 pero con decisiones
m´ultiples y usando la variable estrato de tipo Entero, para ilustrar
su uso en decisiones m´ultiples.
De acuerdo al an´alisis planteado, se propone el Algoritmo 3.20.
Algoritmo 3.20: FacturaAgua
1 Algoritmo FacturaAgua
2 // Este algoritmo calcula el pago de una factura de agua
3 Entero estrato

-- 174 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 173
4 Real cantidad, cargoFijo, consumo, valorRecoleccion,
5 totalPago
6
7 imprimir( "Estrato socioecon´omico del predio: " )
8 leer( estrato )
9 imprimir( "Cantidad de metros consumidos: " )
10 leer( cantidad )
11
12 Segun( estrato )
13
14 Caso 1: cargoFijo = 2500.0
15 valorConsumo = cantidad * 2200.0
16 valorRecolecci´on = 5500.0
17 FinCaso
18
19 Caso 2: cargoFijo = 2800.0
20 valorConsumo = cantidad * 2350.0
21 valorRecolecci´on = 6200.0
22 FinCaso
23
24 Caso 3: cargoFijo = 3000.0
25 valorConsumo = cantidad * 2600.0
26 valorRecolecci´on = 7400.0
27 FinCaso
28
29 Caso 4: cargoFijo = 3300.00
30 valorConsumo = cantidad * 3400.00
31 valorRecolecci´on = 8600.0
32 FinCaso
33
34 Caso 5: cargoFijo = 3700.0
35 valorConsumo = cantidad * 3900.0
36 valorRecolecci´on = 9700.0
37 FinCaso
38
39 EnOtroCaso:
40 cargoFijo = 2800.00
41 valorConsumo = cantidad * 2350.00
42 valorRecolecci´on = 6200.00
43 FinCaso
44 FinSegun
45
46 totalPago = cargoFijo + valorConsumo + valorRecoleccion
47
48 imprimir( "Valor del cargo fijo: ", cargoFijo )
49 imprimir( "Valor del consumo: ", cantidad )
50 imprimir( "Valor de la recolecci´on: ", valorRecoleccion )
51 imprimir( "Total a pagar: ", totalPago )
52 FinAlgoritmo

-- 175 of 450 --

174 Estructuras de decisi ´on
Explicaci´on del algoritmo:
Complementando la explicaci´on del algoritmo original (p´agina 159),
se puede observar como se reemplaz´o toda la decisi´on anidada por una
decisi´on m´ultiple. Cada caso dentro de la decisi´on m´ultiple representa un
estrato socioecon´omico. Note que se asume (EnOtroCaso) que cualquier
valor diferente a los valores del 1 al 5 ser´a considerado el estrato 6.
3.4. Ejercicios propuestos