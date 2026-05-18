# 5. El resto anterior (rn−1), es decir r2 o el divisor de la ´ultima

divisi´on realizada, cuyo valor es 28, es el MCD.
Analizando las operaciones realizadas, se observa que, en cada
repetici´on de la divisi´on, el divisor pasa a ser el nuevo dividendo
y cada nuevo resto pasa a ser el nuevo divisor.
Una vez obtenido el MCD de ambos n´umeros, se puede calcular el
mcm, aplicando la f´ormula dada en el enunciado.

-- 216 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 215
Se debe tener presente que el enunciado solicita que se puedan
realizar varios c´alculos, por lo tanto, el proceso iterativo del c´alculo
del MCD debe estar dentro de otra estructura repetitiva que permita
realizar los c´alculos hasta que el usuario determine que no desea
continuar.
Variables requeridas: para la soluci´on de este problema se
nombrar´an algunas de las variables de acuerdo al concepto
matem´atico y las otras siguiendo la recomendaci´on de establecer
nombres nemot´ecnicos.
• a y b: n´umeros a los cuales se les hallar´a el MCD y el mcm.
• dividendo y divisor: variables que se usar´an para copiar
el valor de a y b y realizar las operaciones correspondientes, de
esta manera no se perder´an los valores originales. La variable
divisor almacenar´a el MCD en la ´ultima ejecuci´on del ciclo.
• resto: ser´a utilizada para calcular el resto de la divisi´on entera.
Este resto se convertir´a en el divisor de la siguiente divisi´on
que se efect´ue. Adicionalmente controlar´a la repetici´on del ciclo
donde se calcular´a el MCD.
• mcm: en esta variable se calcular´a el m´ınimo com´un m´ultiplo de
los dos n´umeros ingresados al algoritmo.
• seguir: es una variable bandera o centinela que recibir´a una
respuesta del usuario, con relaci´on a si quiere o no realizar un
nuevo c´alculo. Controlar´a la iteraci´on del ciclo externo.
De acuerdo al an´alisis planteado, se propone el Algoritmo 4.8.
Algoritmo 4.8: Euclides
1 Algoritmo Euclides
2 /* Este algoritmo calcula el MCD de dos n´umeros, usando
3 el Algoritmo de Euclides. Adicionalmente informa el mcm
4 */
5
6 // Declaraci´on de variables
7 Entero a, b, dividendo, divisor, resto, mcm
8 Caracter seguir
9
10 // Se inicializa la variable centinela
11 seguir = ’S’
12
13 // Se condiciona el ciclo externo que controlar´a
14 // la cantidad de c´alculos que se quieran hacer

-- 217 of 450 --

216 Estructuras de repetici ´on
15 Mientras( seguir == ’S’ O seguir == ’s’ ) // Ciclo
externo
16 imprimir( "Ingrese el primer n´umero: " )
17 leer( a )
18 imprimir ( "Ingrese el segundo n´umero: " )
19 leer( b )
20
21 // Se debe garantizar que el valor de a sea mayor
22 // que el valor de b
23 Si( a > b ) Entonces
24 dividendo = a
25 divisor = b
26 SiNo
27 dividendo = b
28 divisor = a
29 FinSi
30
31 resto = dividendo % divisor
32
33 // Se realizan las diferentes divisiones
34 Mientras( resto != 0 ) // Ciclo interno
35 dividendo = divisor
36 divisor = resto
37 resto = dividendo % divisor
38 FinMientras
39
40 mcm = (a * b) / divisor
41
42 // Resultados esperados
43 imprimir( "El m´aximo com´un divisor de: ", a, " y ", b )
44 imprimir( " es: ", divisor )
45 imprimir( "El m´ınimo com´un m´ultiplo es: ", mcm )
46
47 // Se controla la ejecuci´on de nuevos c´alculos
48 imprimir( "Desea realizar nuevos c´alculos [S] o [N]?:" )
49 leer( seguir )
50 FinMientras
51 FinAlgoritmo
Al ejecutar el algoritmo:
Ingrese el primer n´umero: 532
Ingrese el segundo n´umero: 112
El m´aximo com´un divisor de: 532 y 112 es: 28
El m´ınimo com´un m´ultiplo es: 2128
Desea realizar nuevos c´alculos [S] o [N]?: N

-- 218 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 217
Explicaci´on del algoritmo:
Aclaraci´on:
Antes de entrar en detalle sobre las parti-
cularidades de este algoritmo, se explicar´a el
funcionamiento de los ciclos anidados.
Los ciclos anidados, son estructuras
repetitivas que se encuentran unas dentro de otras. El ciclo que est´a
contenido dentro de otro, generalmente se le denomina ciclo interno
y al ciclo contenedor se le da el nombre del ciclo externo. Se puede
anidar cualquier cantidad de ciclos (Ver Figura 4.13).
La forma de operar es muy sencilla. En la Figura 4.13 se aprecia
la Condici´on 1, que marca el inicio del ciclo externo. Mientras esta
condici´on sea verdadera, se ejecutar´a su cuerpo de ciclo que consta de
otras instrucciones, incluyendo al ciclo interno; que est´a controlado
por la Condici´on 2. Mientras esta Condici´on 2 sea verdadera, se
ejecutar´a completamente el cuerpo del ciclo interno. Cuando esta
condici´on se haga falsa, el control lo vuelve a tomar el ciclo externo
y contin´ua con el resto de sus instrucciones; al encontrar el fin de
su cuerpo de ciclo se regresa a Condici´on 1 para evaluar si a´un es
verdadera y volver a iterar completamente, eso incluye una nueva
ejecuci´on del ciclo interno, siempre y cuando la Condici´on 2 sea
verdadera.
Estas iteraciones se ejecutan mientras la condici´on del ciclo externo
sea verdadera.

-- 219 of 450 --

218 Estructuras de repetici ´on
Inicio
Instrucci´on de
inicalizaci´on ciclo externo
Condici´on 1
Instrucciones
Instrucci´on de
inicializaci´on ciclo interno
Condici´on 2
Instrucciones
Instrucci´on modificadora Condici´on 2
Instrucciones
Instrucci´on modificadora Condici´on 1
Instrucciones
Final
No
S´ı
S´ı
No
Figura 4.13: Ciclos Anidados

-- 220 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 219
Una vez hecha la aclaraci´on del funcionamiento de los ciclos anidados,
se continuar´a con la explicaci´on del Ejemplo 4.5.
En la soluci´on planteada en el Algoritmo 4.8, en pseudoc´odigo, se poseen
dos estructuras repetitivas Mientras - FinMientras anidadas.
El cuerpo del ciclo externo, est´a comprendido entre las l´ıneas 15 y 50, el
interno comprende desde la l´ınea 34 hasta la 38.
Primero se ejecuta parcialmente el ciclo externo (desde la l´ınea 16 a la
l´ınea 33), luego pasa el control al ciclo interno que se ejecuta mientras su
condici´on sea verdadera (l´ınea 34).
Cuando la condici´on del ciclo interno se haga falsa, el control lo vuelva
a asumir el ciclo externo (l´ıneas 39 a la 49). Al encontrar la instrucci´on
FinMientras (l´ınea 50) se regresa a evaluar su condici´on (l´ınea 15), si
el resultado es verdadero se ingresa nuevamente y se ejecuta una vez m´as
todos los pasos, incluyendo el ciclo interno. Este proceso se repite mientras
las dos condiciones de las estructuras Mientras sean verdaderas.
En este algoritmo la estructura externa controla si se repite o no todo
el proceso, para ello se utiliza la variable seguir que toma un valor
inicial de ’S’, con el prop´osito de que al evaluar por primera vez la
condici´on Mientras (l´ınea 15) se obtenga un resultado verdadero y se
pueda ejecutar el cuerpo de este ciclo.
Finalizando el cuerpo del ciclo externo, se encuentra la instrucci´on
modificadora de condici´on, compuesta por las l´ıneas 48 y 49.
Teniendo en cuenta que la respuesta puede darse en may´uscula o
min´uscula, la condici´on del Mientras contempla estas alternativas (l´ınea
15).
Mientras la respuesta sea afirmativa se solicitar´an dos nuevos valores
para a y b, repiti´endose todo el proceso del c´alculo del MCD y el mcm.
La ejecuci´on del algoritmo terminar´a cuando la respuesta a la anterior
pregunta sea negativa.
La segunda estructura Mientras - FinMientras (ciclo interno), tiene
como finalidad realizar las diferentes divisiones mientras la variable resto
tenga un valor diferente de 0. En las Figuras 4.14 y 4.15 se muestra la
soluci´on del Ejemplo 4.5 mediante un diagrama de flujo.

-- 221 of 450 --

220 Estructuras de repetici ´on
Inicio
seguir = ′S′	2
seguir == ′S′
O seguir == ′s′
a
b
a > b
dividendo = a
divisor = b
dividendo = b
divisor = a
resto = dividendo % 10
1
Final
S´ı
No
S´ı 	No
Figura 4.14: Diagrama del flujo del Algoritmo Euclides - Parte 1

-- 222 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 221
1
resto != 0
dividendo = divisor
divisor = resto
resto = dividendo % divisor
mcm = (a ∗ b) / divisor
a, b, divisor
mcm
seguir
2
No
S´ı
Figura 4.15: Diagrama del flujo del Algoritmo Euclides - Parte 2

-- 223 of 450 --

222 Estructuras de repetici ´on
Aclaraci´on:
En las estructuras repetitivas anidadas, hasta que la
ejecuci´on de la estructura interna no se termine, el
control no pasar´a a la estructura externa.
4.2.1 Prueba de escritorio
Tal como ese explic´o en el Cap´ıtulo 2, una prueba de escritorio o tabla de
verificaci´on es un seguimiento que se hace de forma manual a un algoritmo
para comprobar su funcionamiento.
Los siguientes 2 ejemplos son enunciados cl´asicos de programaci´on; en
este libro fueron dise˜nados utilizando el ciclo Mientras y ser´an utilizados
para mostrar la aplicaci´on de pruebas de escritorio.
.:Ejemplo 4.6. Dado el siguiente algoritmo, que multiplica dos n´umeros
enteros positivos mediante sumas sucesivas, realice una prueba de escritorio
o tabla de verificaci´on.
Algoritmo 4.9: Multiplicacion
1 Algoritmo Multiplicacion
2 /* Multiplica dos n´umeros enteros positivos mediante sumas
3 sucesivas
4 */
5 // Declaraci´on de variables
6 Entero multiplicando, multiplicador, producto, contador
7
8 // Datos disponibles
9 imprimir( "Ingrese el multiplicando: " )
10 leer( multiplicando)
11 imprimir( "Ingrese el multiplicador: " )
12 leer( multiplicador )
13
14 // Inicializaci´on de acumulador y contador
15 producto = 0
16 contador = 0
17
18 // Multiplicaci´on a trav´es de sumas sucesivas
19 Mientras( contador < multiplicador )
20 producto = producto + multiplicando
21 contador = contador + 1
22 FinMientras
23

-- 224 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 223
24 // Resultado esperado
25 imprimir( "El producto es: ", producto )
26 FinAlgoritmo
Al ejecutar el algoritmo:
Ingrese el multiplicando: 75
Ingrese el multiplicador: 6
El producto es: 450
Aplicaci´on de la prueba de escritorio:
El algoritmo solicita como datos de entrada el multiplicando y el
multiplicador. Para realizar la prueba, se van a tomar dos valores de
manera aleatoria. Generalmente se debe trabajar con datos que sean f´aciles
de procesar. En el presente ejemplo, los valores para las dos variables se
presentan en la Tabla 4.3.
multiplicando = 75
multiplicador = 6
producto contador contador< multiplicador
0 0 0 < 6 (V)
75 1 1 < 6 (V)
150 2 2 < 6 (V)
225 3 3 < 6 (V)
300 4 4 < 6 (V)
375 5 5 < 6 (V)
450 6 6 < 6 (F)
producto = 450
Tabla 4.3: Prueba de escritorio - Algoritmo 4.6
Explicaci´on de la prueba de escritorio:
Para el desarrollo de una prueba de escritorio de un algoritmo que
utiliza estructuras de repetici´on, es indispensable la creaci´on de una tabla,
llamada, “Tabla de verificaci´on”, donde se muestre la forma en que las
diferentemente variables que se encuentran dentro del ciclo cambian en
cada una de las iteraciones. Las dem´as variables son mostradas antes de la
tabla (valores iniciales), o despu´es de ella, cuando se trate por ejemplo de
valores de salida. La tabla de verificaci´on suele tener columnas asociadas
a las expresiones l´ogicas / relacionales que ayuden al seguimiento del
funcionamiento del algoritmo.

-- 225 of 450 --

224 Estructuras de repetici ´on
En este ejemplo, las variables multiplicando, multiplicador,
producto y contador, inician con los siguientes contenidos 75, 6, 0
y 0 respectivamente.
Se eval´ua la condici´on del Mientras (l´ınea 19), en este caso, 0 < 6,
obteniendo un resultado verdadero, lo cual indica que se debe ejecutar el
cuerpo del ciclo.
Al ejecutar el cuerpo del ciclo se procede a realizar la operaci´on
producto = producto + multiplicando, de esta forma se van
efectuando las sumas sucesivas del multiplicando. La variable producto
aumenta su valor en 75 en cada iteraci´on.
La siguiente instrucci´on incrementa la variable contador:
21 contador = contador + 1
Seguidamente se ejecuta el FinMientras, retornando la secuencia de
operaci´on del algoritmo al c´odigo Mientras, para que una vez m´as se
eval´ue la condici´on.
Este proceso se repite mientras contador tenga un valor menor al
de multiplicador. Cuando la expresi´on de la l´ınea 19 sea 6 < 6, el
resultado ser´a falso y se proceder´a a ejecutar la instrucci´on que hay despu´es
del FinMientras, es decir, imprime el resultado de la multiplicaci´on
(producto).
Buena pr´actica:
Cada uno de los resultados obtenidos de las
operaciones y de evaluaciones realizadas a las
condiciones, deben quedar registrados en la tabla de
verificaci´on.
Para realizar una prueba de escritorio, deben asignarse a las variables
valores f´aciles de procesar.
.:Ejemplo 4.7. El presente ejemplo muestra un diagrama de flujo (Figura
4.16) que calcula una potencia entera mediante sumas sucesivas.

-- 226 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 225
Inicio
base
exponente
contador1 = 0
potencia = base
contador1 <
(exponente - 1)
producto = potencia
potencia = 0
contador2 = 0
contador2 < base
potencia = potencia + producto
contador2 = contador2 + 1
contador1 = contador1 + 1
potencia
Final
No
S´ı
S´ı
No
Figura 4.16: Diagrama de flujo del Algoritmo PotenciaEntera

-- 227 of 450 --

226 Estructuras de repetici ´on
Para realizar la prueba de escritorio se calcular´a la siguiente potencia
5ˆ3 que es equivalente a 53.
Tenga presente el nombre de los t´erminos en una operaci´on de potencia:
potencia = baseexponente
base = 5
exponente = 3
contador1 potencia contador1 producto contador2 contador2
<= exponente-1 <= base
0 5 0 < 2 (V) 5
0 0 0 < 5 (V)
5 1 1 < 5 (V)
10 2 2 < 5 (V)
15 3 3 < 5 (V)
20 4 4 < 5 (V)
25 5 5 < 5 (F)
1 1 < 2 (V) 25
0 0 0 < 5 (V)
25 1 1 < 5 (V)
50 2 2 < 5 (V)
75 3 3 < 5 (V)
100 4 4 < 5 (V)
125 5 5 < 5 (F)
2 2 < 2 (F)
potencia = 125
Tabla 4.4: Prueba de escritorio - Algoritmo 4.7
Explicaci´on de la prueba de escritorio:
Las variables base y exponente se inicializan en 5 y 3,
respectivamente (53). La variable contador1 inicia en 0 y potencia
asume el valor de base.
Este diagrama de flujo trabaja con ciclos anidados. El ciclo externo est´a
controlado por la condici´on contador1<(exponente - 1) el ciclo
interno presenta la condici´on contador2<base. En la tabla se aprecian
ambas condiciones.
Se eval´ua la condici´on del ciclo externo:
contador1 < ( exponente - 1 )

-- 228 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 227
En la primera evaluaci´on contador1 vale 0 y exponente 3, por lo
tanto, la condici´on es verdadera (0 <2). Se ejecuta la primera parte del
cuerpo de este ciclo:
A la variable producto se le asigna el valor de potencia (5), potencia
y contador2 almacenan un 0 como valor. Estos datos deben quedar
registrados en la tabla de verificaci´on.
Seguidamente se encuentra el ciclo interno (Ver Figura 4.17).
contador2 < base
potencia = potencia + producto
contador2 = contador2 + 1
S´ı
No
Figura 4.17: Ciclo interno para el Ejemplo 4.7
Se eval´ua su condici´on contador2 < base, obteni´endose un resultado
verdadero en su primera evaluaci´on, (0 < 5). Este resultado se consigna
en la tabla.
A continuaci´on, como resultado de la evaluaci´on anterior, se ejecutan las
dos instrucciones de este ciclo; la primera aumenta el valor de potencia
en el valor que tenga almacenado producto, la segunda incrementa
contador2 en una unidad. Luego de ejecutar estas dos operaciones el
control regresa a la evaluaci´on de la condici´on, tal como se indica en la
anterior figura y en la tabla de verificaci´on.
Para este ejemplo, estas instrucciones iteran 5 veces (valor de la base).
En la columna que corresponde a la variable potencia, se registran los
valores que va almacenando a medida que se incrementa, en la primera
iteraci´on toma un valor de 5, para su quinta iteraci´on tendr´a un resultado
de 25. La variable contador2 va aumentando su valor, en la primera
vuelta toma el valor de 1, finalizando en 5.

-- 229 of 450 --

228 Estructuras de repetici ´on
Cuando contador2 almacena el n´umero 5, la condici´on del ciclo interno
se hace falsa; por consiguiente, se termina su ejecuci´on y el control pasa de
nuevo al ciclo externo. Una vez all´ı se aumenta a 1 el valor de la variable
contador1.
Despu´es del incremento, se valora por segunda vez la condici´on del ciclo
externo:
contador1< ( exponente - 1 )
De acuerdo a los valores almacenados en este momento, el resultado es
verdadero (1 < 2), tal como se evidencia en la tabla de verificaci´on.
El cuerpo del ciclo externo vuelve a ejecutarse; la variable producto
toma el valor de potencia (25), luego potencia y contador2 vuelven
a tomar el valor de 0. Por segunda vez el ciclo interno vuelve a iterar otras 5
veces. La variable potencia en la primera vuelta del ciclo, toma un valor
de 25 y en su quinta iteraci´on valdr´a 125; contador2 toma el valor de 1
y terminar´a en 5 al final de las iteraciones. Observe la tabla de verificaci´on
para ver el registro de estos valores.
Cuando la variable contador2 alcance el valor de 5, la condici´on del
ciclo interno pasar´a a ser falsa, terminando su ejecuci´on.
De nuevo en el ciclo externo contador1 incrementa su valor a 2. Al
evaluar por tercera vez la condici´on contador1<(exponente - 1),
se obtiene un resultado falso, dando as´ı por terminadas las iteraciones
del ciclo externo y por consiguiente las del interno. Ahora se procede a
imprimir el contenido de potencia (125), para luego finalizar la ejecuci´on
del diagrama de flujo.
4.3. Estructura Haga - MientrasQue
Esta estructura de repetici´on, permite que una instrucci´on o un conjunto
de ellas se ejecuten una o m´as veces.
El Haga-MientrasQue es un ciclo condicionado al final, lo cual
garantiza que sus instrucciones se ejecuten por lo menos una vez.
La forma general de esta estructura de repetici´on es presentada en el
segmento de Algoritmo 4.10.

-- 230 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 229
Algoritmo 4.10: Forma general - Haga-MientrasQue
1 Instrucci´on de inicializaci´on
2 Haga
3 Instrucci´on-1
4 Instrucci´on-2
5 ... /* Cuerpo del ciclo */
6 Instrucci´on-n
7 Instrucci´on modificadora de condici´on
8 MientrasQue( condici´on )
9 Instrucci´on externa
Esta forma general se interpreta as´ı:
La Instrucci´on de inicializaci´on se usa para dar un valor inicial a las
variables que har´an el papel de contadores o acumuladores dentro del
ciclo. En el caso de no tener este tipo de variables, no es necesario su
uso. Las variables que intervienen en la condici´on del MientrasQue no
necesariamente deben ser inicializadas antes de entrar al ciclo, ya que su
valor puede ser asignado dentro del cuerpo del mismo.
Al encontrar la instrucci´on Haga, se ejecutan las instrucciones
que conforman el cuerpo del ciclo hasta encontrar la instrucci´on
MientrasQue (condici´	on); si al evaluar la condici´on, esta es
verdadera se regresa hasta el c´odigo Haga y una vez m´as se repite la
ejecuci´on del cuerpo del ciclo. La condici´on estar´a representada por una
expresi´on relacional o l´ogica.
Las iteraciones terminar´an en el momento que la evaluaci´on de la
condici´on produzca un resultado falso, en cuyo caso el control del algoritmo
lo asume la Instrucci´on externa, es decir, la que est´e escrita debajo del
MientrasQue, la cual no hace parte del ciclo.
Al igual que en el Mientras-FinMientras, en esta forma general
tambi´en est´a presente la Instrucci´on modificadora de condici´on (l´ınea 7),
cuyo prop´osito es cambiar el estado de la condici´on. De omitir la instrucci´on
modificadora, se obtendr´a lo que se conoce como un ciclo infinito, debido
a que su ejecuci´on “nunca termina”. Aunque en la forma general est´a
representada de ´ultima en la secuencia de instrucciones que componen
el cuerpo del ciclo, no necesariamente debe ocupar ese lugar.
En la Figura 4.18 se muestra la estructura de repetici´on Haga -
MientrasQue mediante un diagrama de flujo.

-- 231 of 450 --

230 Estructuras de repetici ´on
Instrucci´on de Inicializaci´on
Instrucci´on 1
Instrucci´on 2
...
Instrucci´on N
Instrucci´on modificadora
de condici´on
Condici´on
Instrucci´on externa
S´ı
No
Figura 4.18: Estructura de repetici´on Haga - MientrasQue
Aclaraci´on:
Como lo expresa [Trejos, 2017] la forma general
del ciclo Haga-MientrasQue podr´ıa decirse
que es una inversi´on de la estructura del ciclo
Mientras-FinMientras.
Para explicar el funcionamiento del ciclo Haga - MientrasQue se
har´a uso del mismo ejemplo empleado con la estructura Mientras -
FinMientras; de esta forma usted podr´a observar su diferencia.

-- 232 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 231
.:Ejemplo 4.8. Crear un algoritmo que imprima los n´umeros del 1 al 10,
utilizando el ciclo Haga-MientrasQue.
Algoritmo 4.11: Algoritmo que imprime los n´umeros del 1 al 10 - Versi´on 1
1 numero = 1
2 Haga
3 imprimir( numero )
4 numero = numero + 1
5 MientrasQue( numero <= 10 )
Para una explicaci´on del segmento del Algoritmo 4.11, se identificar´an
sus partes de acuerdo a la forma general expresada en p´arrafos anteriores.
L´ınea Explicaci´on
1 Instrucci´on de inicializaci´on
2 Inicio del ciclo
3 Cuerpo del ciclo
4 Cuerpo del ciclo e instrucci´on modificadora de condici´on
5 Fin del ciclo y condici´on. Regresa el control a la l´ınea 2.
Tabla 4.5: Explicaci´on Algoritmos 4.8
En la primera l´ınea, la variable numero se inicializa en 1. Pasando a
la l´ınea 2 se encuentra la instrucci´on Haga, que indica el inicio de un
ciclo condicionado al final. El cuerpo del ciclo est´a conformado por dos
instrucciones (l´ıneas 3 y 4), que se ejecutan por lo menos la primera vez.
Al encontrar la condici´on MientrasQue (numero <= 10) se hace el
testeo, si el resultado es verdadero el control regresa a la instrucci´on Haga
(l´ınea 2) y se vuelve a ejecutar el cuerpo del ciclo. Las iteraciones del ciclo
terminan cuando la condici´on resulte falsa.
La instrucci´on imprimir se ejecuta 10 veces, imprimiendo uno a uno
los n´umeros del 1 al 10.
La operaci´on numero = numero + 1 adem´as de incrementar, en
cada iteraci´on, en 1 el valor de la variable numero, tambi´en hace el papel
de Instrucci´on modificadora de condici´on. Cuando la variable tome el valor
de 11, la condici´on (numero <= 10) entregar´a un resultado falso, con
lo cual se dar´a terminada la ejecuci´on del Haga-MientrasQue.

-- 233 of 450 --

232 Estructuras de repetici ´on
Tenga en cuenta que cada problema puede tener m´ultiples soluciones,
por ejemplo, el segmento del Algoritmo 4.12 tambi´en imprime los n´umeros
del 1 al 10 usando el ciclo Haga-MientrasQue:
Algoritmo 4.12: Algoritmo que imprime los n´umeros del 1 al 10 - Versi´on 2
1 numero = 0
2 Haga
3 numero = numero + 1
4 imprimir( numero )
5 MientrasQue( numero < 10 )
Comparando la versi´on 2 (Algoritmo 4.12) con la versi´on 1 (Algoritmo
4.11) se puede observar que:
L´ınea 1: la inicializaci´on es diferente, se hizo en 0.
L´ınea 2: en ambas versiones es igual, se indica el inicio del ciclo
condicionado al final.
L´ıneas 3 y 4: se codificaron las expresiones numero = numero + 1
e imprimir(numero), que son iguales a la planteadas en las l´ıneas 4 y
3 del Algoritmo versi´on 1, respectivamente. En esta soluci´on fue necesario
cambiar el orden de ejecuci´on de las instrucciones del cuerpo del ciclo, ya
que si se conservaban en el orden como hab´ıan sido escritas en la versi´on
1 del algoritmo, el resultado ser´ıa la impresi´on de los n´umeros del 0 al 9 y
no del 1 al 10 como se esperar´ıa.
L´ınea 5: en la nueva versi´on el ciclo se ejecuta mientras el valor de
numero sea menor a 10, en lugar de menor o igual a 10, como se plante´o
en la versi´on anterior. Esto obedece a que la inicializaci´on fue en 0 en
lugar de 1. Recuerde que en la versi´on 1 del algoritmo la variable numero
alcanza a tomar el valor de 11, en esta nueva versi´on el valor llega hasta
10.
Aclaraci´on:
El bloque de instrucciones o cuerpo del ciclo
Haga-MientrasQue, se ejecutar´a por lo menos
una vez.

-- 234 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 233
Estos dos segmentos de algoritmos se pueden representar gr´aficamente
con los diagramas de flujo de la Figura 4.19.
Inicio
numero = 1
numero
numero = numero + 1
numero <= 10
Final
S´ı
No
Inicio
numero = 0
numero = numero + 1
numero
numero < 10
Final
S´ı
No
Figura 4.19: Imprimen los n´umeros del 1 al 10 (Haga-MientrasQue)
A continuaci´on, se dar´an algunos enunciados como ejemplo para ser
resueltos mediante la estructura repetitiva Haga - MientrasQue.
.:Ejemplo 4.9. Dise˜ne un algoritmo que genere e imprima la siguiente
serie: 1, 3, 5, 7, 9, 11, . . . , n
An´alisis del problema:
El an´alisis completo a este problema lo encuentra en el Ejemplo 4.1,
all´ı fue solucionado usando la estructura Mientras-FinMientras.
En este momento se proceder´a a mostrar la soluci´on usando el ciclo
Haga-MientrasQue.
Algoritmo 4.13: Serie
1 Algoritmo Serie
2 // Declaraci´on de variables
3 Entero contadorNumeros, cantidadTerminos, termino
4
5 // Dato disponible
6 imprimir( "Ingrese la cantidad de t´erminos a generar: " )
7 leer( cantidadTerminos )

-- 235 of 450 --

234 Estructuras de repetici ´on
8
9 // Inicializaci´on de variables
10 contadorNumeros = 0
11 termino = 1
12
13 // Generaci´on de la serie
14 Haga
15 imprimir( termino, ", " )
16 termino = termino + 2
17 contadorNumeros = contadorNumeros + 1
18 MientrasQue( contadorNumeros < cantidadTerminos - 1 )
19
20 imprimir( termino )
21 FinAlgoritmo
Al ejecutar el algoritmo:
Ingrese la cantidad de t´erminos a generar: 15
1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29
Explicaci´on del algoritmo:
La ´unica diferencia entre esta soluci´on y la planteada en el Algoritmo
4.4 radica en el ciclo utilizado. En el Algoritmo 4.4 se us´o el ciclo
Mientras-FinMientras cuya condici´on se plante´o al inicio del ciclo,
en este algoritmo el ciclo utilizado es el Haga-MientrasQue, con la
condici´on al final; todas las dem´as instrucciones son exactamente iguales
y producen el mismo resultado.
Aclaraci´on:
Tanto el ciclo Mientras-FinMientras y el
Haga-MientrasQue se ejecutan mientras la
evaluaci´on de la condici´on arroje un resultado
verdadero.
El Mientras-FinMientras eval´ua la condici´on al comienzo, el
Haga-MientrasQue la eval´ua al final.

-- 236 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 235
En la Figura 4.20 se muestra la soluci´on del Ejemplo 4.8 mediante un
diagrama de flujo.
Inicio
cantidadTerminos
contadorNumeros = 0
termino = 1
termino ,“, ”
termino = termino + 2
cantidadNumeros =
contadorNumeros + 1
contadorN umeros <
cantidadT erminos −
1
termino
Final
S´ı
No
Figura 4.20: Diagrama de flujo del Algoritmo Serie

-- 237 of 450 --

236 Estructuras de repetici ´on
.:Ejemplo 4.10. El profesor de la materia de Programaci´on para
dispositivos m´oviles, desea hacer una encuesta con sus estudiantes
para determinar sobre cu´al de dos posibles plataformas desarrollar´a las
tem´aticas de este espacio acad´emico. Las plataformas disponibles son
Android e iOS, en caso de elegir una diferente se debe informar la situaci´on
y no ser´a tenida en cuenta en los resultados. El profesor elegir´a la
plataforma de mayor votaci´on; si se presenta un empate en la cantidad
de votos, se usar´a otro mecanismo de elecci´on.
Cada estudiante deber´a digitar su c´odigo y su elecci´on por una de las
dos plataformas.
An´alisis del problema:
Resultados esperados: informe sobre cu´al de las dos plataformas
obtuvo mayor votaci´on.
En el caso que el estudiante elija una opci´on diferente a estas
plataformas se debe informar mediante un mensaje.
Aunque en el enunciado no se pide, se informar´an los votos obtenidos
por cada una de las plataformas. Es una buena pr´actica informar
algunos resultados que sean relevantes en el problema.
Datos disponibles: de cada estudiante se conoce el c´odigo y la
elecci´on de la plataforma.
En vista a que el algoritmo debe ejecutarse un n´umero indeterminado
de veces, se formular´a una pregunta para saber si desea continuar o
terminar con la votaci´on. Consecuente a esto, un dato adicional que
estar´a disponible, es la respuesta a esta pregunta.
Proceso: dentro de un proceso repetitivo se debe solicitar el c´odigo
y la elecci´on de plataforma del estudiante. Luego se debe incrementar
el contador de votos de acuerdo a la plataforma elegida (Ver Figura
4.21).
Para repetir o terminar el proceso c´ıclico se plantear´a una pregunta,
que debe ser contestada por el usuario.
Una vez se termine la votaci´on, se debe proceder a informar la
cantidad de votos por cada una de las plataformas y tomar la decisi´on
de cu´al fue la de mayor votaci´on; hay que tener en cuenta que existe
la posibilidad de un empate en el n´umero de votos (Ver Figura 4.22).

-- 238 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 237
¿voto == Android?
Incrementar votosAndroid
s´ı
¿voto == iOS?
Incrementar votosiOS
s´ı
Informar que la opci´on no es v´alida
no
no
Figura 4.21: ´	Arbol de decisi´on del Ejemplo 4.10 - Parte 1
¿votosAndroid > votosiOS?
Informar Android gan´o
s´ı
¿votosAndroid < votosiOS?
Informar que iOS gan´o
s´ı
Informar que hay empate
no
no
Figura 4.22: ´	Arbol de decisi´on del Ejemplo 4.10 - Parte 2
Variables requeridas:
• codigo: almacenar´a el c´odigo del estudiante.
• voto: es la opci´on que el estudiante elija entre las dos
plataformas.
• votosAndroid: contador de los votos para esta plataforma.
• votosiOS: contador de votos para la plataforma iOS.
• seguir: variable para controlar si se desea ingresar un nuevo
voto.
En las Figuras 4.23 y 4.24 se muestra la soluci´on del Ejemplo 4.4
mediante un diagrama de flujo.

-- 239 of 450 --

238 Estructuras de repetici ´on
Inicio
votosAndroid = 0
votosiOS = 0
codigo
voto
voto
votosAndroid = votosAndroid + 1 ”La opci´on no es v´alida”
votosiOS = votosiOS + 1
seguir
Seguir == ’S’
1
’i’
’A’ 	en otro caso
S´ı
No
Figura 4.23: Diagrama de flujo del Algoritmo Plataformas - Parte 1

-- 240 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 239
1
votosAndroid
votosiOS
votosAndroid
> votosiOS
“Android gan´o”
votosAndroid
< votosiOS
“iOS gan´o” “Hay
empate”
Final
S´ı 	No
S´ı 	No
Figura 4.24: Diagrama de flujo del Algoritmo Plataformas - Parte 2
La soluci´on en pseudoc´odigo se presenta en el Algoritmo 4.14.
Algoritmo 4.14: Plataformas
1 Algoritmo Plataformas
2 // Declaraci´on de variables
3 Caracter seguir, voto
4 Cadena codigo
5 Entero votosAndroid, votosiOS
6
7 // Se inicializan los contadores en 0
8 votosAndroid = 0
9 votosiOS = 0
10

-- 241 of 450 --

240 Estructuras de repetici ´on
11 // Proceso de solicitud y conteo de votos
12 Haga
13 imprimir( "Ingrese el c´odigo del estudiante: " )
14 leer( codigo )
15
16 imprimir( "PLATAFORMAS DISPONIBLES" )
17 imprimir( "[A]Android" )
18 imprimir( "[i]OS" )
19 imprimir( "Elija su opci´on: " )
20 leer( voto )
21
22 Segun( voto )
23 Caso ’A’:
24 Caso ’a’: votosAndroid = votosAndroid + 1
25 FinCaso
26 Caso ’I’:
27 Caso ’i’: votosiOS = votosiOS + 1
28 FinCaso
29 EnOtroCaso: imprimir( "La opci´on no es v´alida" )
30 FinSegun
31
32 imprimir( "Desea realizar un nuevo voto [S] [N]?: " )
33 leer( seguir )
34 MientrasQue ( seguir == ’S’ O seguir == ’s’ )
35
36 // Se informa la cantidad de votos para cada plataforma
37 imprimir( "Votos por Android:", votosAndroid )
38 imprimir( "Votos por iOS: ", votosiOS )
39
40 // Se toma la decisi´on de cu´al fue la m´as votada
41 Si( votosAndroid > votosiOS ) Entonces
42 imprima( "Android gan´o" )
43 SiNo
44 Si(votosAndroid < votosiOS ) Entonces
45 imprimir( "iOS gan´o" )
46 SiNo
47 imprimir( "Hay empate" )
48 FinSi
49 FinSi
50 FinAlgoritmo
Explicaci´on del algoritmo:
Despu´es de la declaraci´on de las variables se inicializan en 0 los
contadores votosAndroid y votosiOS, estos contadores podr´an ser
modificados dentro del ciclo.
La instrucci´on Haga indica el inicio del proceso repetitivo, de acuerdo
a la operatividad de este ciclo se ejecuta su cuerpo por lo menos una vez.

-- 242 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 241
Dicho cuerpo contiene las instrucciones para leer el codigo del estudiante,
as´ı como su elecci´on de la plataforma.
El estudiante vota por Android ingresando una letra ’A’, o vota por iOS
ingresando una letra ’i’. Una vez hayan ingresado estos datos, se procede
a contabilizar el respectivo voto, para ello se emple´o una estructura de
decisi´on m´ultiple con tres opciones:
22 Segun( voto )
23 Caso ’A’:
24 Caso ’a’: votosAndroid = votosAndroid + 1
25 FinCaso
26 Caso ’I’:
27 Caso ’i’: votosiOS = votosiOS + 1
28 FinCaso
29 EnOtroCaso: imprimir( "La opci´on no es v´alida" )
30 FinSegun
Se tuvo la precauci´on de contemplar la elecci´on del estudiante tanto en
may´usculas como en min´usculas (l´ıneas 23-24 y 26-27).
En el caso de que el voto no sea por ninguna de las dos plataformas,
se mostrar´a el mensaje “La opci´on no es v´alida” y el voto no ser´a
contabilizado.
Luego de la decisi´on m´ultiple, se presenta la instrucci´on modificadora
de condici´on:
30 imprimir( "Desea realizar un nuevo voto [S] [N]?: " )
31 leer( seguir )
A diferencia de los algoritmos que se realizaron, en el apartado anterior,
con el ciclo Mientras-FinMientras, en esta soluci´on no fue necesaria
la inicializaci´on de la variable seguir antes de entrar al ciclo. El valor que
toma esta variable para poder evaluar la condici´on del MientrasQue, es
ingresado por el usuario (leer( seguir )).
Una vez se obtenga la respuesta a la anterior pregunta, se eval´ua la
condici´on:
32 MientrasQue( seguir == ’S’ O seguir == ’s’ )
Si la condici´on es verdadera, se regresa el control a la instrucci´on Haga
y una vez m´as se repite el proceso. Cuando la condici´on sea falsa, se
termina el ciclo y se contin´ua con la instrucci´on que est´a escrita debajo del
MientrasQue.

-- 243 of 450 --

242 Estructuras de repetici ´on
A continuaci´on, el algoritmo muestra la cantidad de votos por cada una
de las plataformas (l´ıneas 37 y 38) e informa cu´al es la elegida; esta tarea
se realiz´o usando uma estructura de decisi´on anidada (l´ıneas 41 a 49).
Finalmente, con la instrucci´on FinAlgoritmo se da por terminada la
ejecuci´on del algoritmo.
.:Ejemplo 4.11. El factorial de un n´umero, es el producto obtenido al
multiplicar un n´umero dado por todos los enteros positivos sucesivos
inferiores. Adem´as, se tiene establecido que los n´umeros negativos no
poseen factorial y que el factorial de 0 es 1. El factorial se representa
con un signo de exclamaci´on precedido de un n´umero (n!).
Por ejemplo:
7! = 7 ∗ 6 ∗ 5 ∗ 4 ∗ 3 ∗ 2 ∗ 1 = 5040
o se puede expresar como:
7! = 1 ∗ 2 ∗ 3 ∗ 4 ∗ 5 ∗ 6 ∗ 7 = 5040.
A 7! se le denomina 7 factorial, tambi´en es llamado el factorial de 7.
Teniendo en cuenta el anterior contexto, dise˜ne un algoritmo que calcule
el factorial de un n´umero entero.
An´alisis del problema:
Resultados esperados: factorial calculado o un mensaje que
informe que los n´umeros negativos no poseen factorial.
Datos disponibles: el n´umero al cu´al se le va a calcular el factorial.
Proceso: se debe leer el n´umero de entrada.
Seguidamente se debe tomar una decisi´on para determinar si se hace
el c´alculo del factorial o se informa que es un n´umero negativo y no
posee factorial.
¿numero < 0?
No se puede calcular el factorial
s´ı
Calcular e informar el factorial
no
Figura 4.25: ´	Arbol de decisi´on del Ejemplo 4.11
Para el c´alculo del factorial se debe hacer un proceso repetitivo. Con
el prop´osito de entender este procedimiento se analizar´a el c´alculo

-- 244 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 243
del factorial de 7 (7! = 1 ∗ 2 ∗ 3 ∗ 4 ∗ 5 ∗ 6 ∗ 7 = 5040), tal como se
muestra en la Tabla 4.6.
Inferiores C´alculo n!
1 1 1
2 1! x 2 2
3 2! x 3 6
4 3! x 4 24
5 4! x 5 120
6 5! x 6 720
7 6! x 7 5040
Tabla 4.6: C´alculo de 7!
La columna Inferiores muestra los valores de cada uno de los
n´umeros menores sucesivos hasta 7. En la columna C´	alculo se
observa el proceso acumulativo que se hace para el c´alculo del
factorial (n!), el factorial anterior es multiplicado por el n´umero
que est´a en la misma fila de la primera columna. La tercera columna
acumula los resultados en cada iteraci´on o c´alculo realizado; al final
se obtiene el resultado: 7! = 5040.
Para dise˜nar el proceso descrito en la Tabla 4.6 y en el p´arrafo
anterior, se requiere el uso de una estructura de repetici´on que se
ejecute mientras que un contador que inicie en 1 llegue hasta el valor
del n´umero al cual se le calcular´a el factorial.
Variables requeridas:
• numero: n´umero al cual se le calcular´a el factorial (n).
• factorial: resultado del c´alculo del factorial (n!).
• inferiores: variable que almacenar´a los valores desde 1 hasta
el n´umero al cual se le calcular´a el factorial. Har´a parte de la
condici´on que controlar´a el ciclo que realizar´a el c´alculo.

-- 245 of 450 --

244 Estructuras de repetici ´on
En la Figura 4.26 se muestra la soluci´on del Ejemplo 4.11 mediante un
diagrama de flujo.
Inicio
numero
numero < 0
“No se puede calcular el factorial” factorial = 1
inferiores = 1
factorial = factorial * inferiores
inferiores = inferiores + 1
inferiores
<= numero
factorial
Final
S´ı 	No
S´ı
No
Figura 4.26: Diagrama de flujo del Algoritmo FactorialNumero

-- 246 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 245
Para la soluci´on en pseudoc´odigo se propone el Algoritmo 4.15.
Algoritmo 4.15: FactorialNumero
1 Algoritmo FactorialNumero
2 // Declaraci´on de variables
3 Entero numero, factorial, inferiores
4
5 // Dato disponible
6 imprimir( "Ingrese el n´umero para el factorial: " )
7 leer( numero )
8
9 // Proceso y resultados esperados
10 Si( numero < 0 ) Entonces
11 imprimir( "No se puede calcular el factorial" )
12 SiNo
13 factorial = 1
14 inferiores = 1
15 Haga
16 factorial = factorial * inferiores
17 inferiores = inferiores + 1
18 MientrasQue( inferiores <= numero )
19
20 // Resultado esperado
21 imprimir( "Factorial de ", numero, " es: ", factorial )
22 FinSi
23 FinAlgoritmo
Al ejecutar el algoritmo:
Primera ejecuci´on:
Ingrese el n´umero para el factorial: 9
Factorial de 9 es: 362880
Segunda ejecuci´on:
Ingrese el n´umero para el factorial: 0
Factorial de 0 es: 1
Tercera ejecuci´on:
Ingrese el n´umero para el factorial: -12
No se puede calcular el factorial
Explicaci´on del algoritmo:
Despu´es de ingresar el n´umero para el c´alculo, se toma la decisi´on si
este es un valor negativo (l´ınea 10), en cuyo caso se informa que para
los n´umeros negativos el factorial no se puede calcular. En caso de que el

-- 247 of 450 --

246 Estructuras de repetici ´on
n´umero sea 0 o positivo, se procede a calcular el factorial haciendo uso de
un ciclo Haga-MientrasQue.
Dentro del cuerpo del ciclo, el acumulador factorial, se incrementa
mediante multiplicaciones sucesivas, raz´on por la cual se inicializ´o en 1
(l´ınea 13). Hay que tener especial cuidado en este valor inicial, si se
establece en 0, todos los c´alculos van a dar 0.
En cada iteraci´on del Haga, se va calculando el factorial mediante
la expresi´on factorial = factorial * inferiores (l´ınea 16).
En la variable inferiores se generan todos los n´umeros inferiores
que son multiplicados para obtener el factorial. Las iteraciones se
ejecutan mientras el contenido de inferiores sea menor o igual a numero
(MientrasQue(inferiores <= numero) (l´ınea 18)).
.:Ejemplo 4.12. Se requiere una soluci´on algor´ıtmica que resuelva la
siguiente expresi´on matem´atica:
expresion = 1 + x2
2! − x3
4! + x4
6! − x5
8! + · · · ± xn
(2(n − 1))!
Donde n es la cantidad de t´erminos a calcular.
An´alisis del problema:
Resultados esperados: resultado del c´alculo de la expresi´on.
Datos disponibles: el valor para la constante x y la cantidad de
t´erminos (n).
Proceso: inicialmente se debe obtener el valor para x y el valor para
n.
Para el c´alculo se requiere un proceso repetitivo que vaya generando
y acumulando el valor de los t´erminos. El primer t´ermino es el 1, los
siguientes est´an conformados por una divisi´on donde el numerador es
la constante x elevada a un exponente; dicho exponente inicia en 2 y
va incrementado su valor de 1 en 1 hasta llegar a n. El denominador
tiene la caracter´ıstica de ser el factorial de los valores pares en forma
creciente y consecutiva; inicia con un valor de 2 en el segundo t´ermino
de la expresi´on y va hasta 2(n − 1). Para el c´alculo del factorial
se requiere de otro proceso repetitivo, igual al que se explic´o en el

-- 248 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 247
Ejemplo 4.11. De acuerdo a lo anterior, en la soluci´on planteada para
resolver la expresi´on se deben trabajar dos ciclos anidados.
Otro aspecto importante que requiere an´alisis dentro de la expresi´on,
es el hecho de que est´a conformada por sumas y restas sucesivas de
manera alterna; a partir del segundo t´ermino, donde el exponente de
x sea un n´umero par se debe sumar y donde sea impar se debe restar.
Variables requeridas:
• x: representa la constante de la expresi´on. Cuando se le da la
denominaci´on de constante, no se refiere a la clasificaci´on de los
datos usados en los algoritmos, sino a que dentro de la expresi´on
de este problema va a tener un valor constante. Para la soluci´on
algor´ıtmica que se va a plantear, es una variable que toma un
valor diferente cada que se ejecute.
• n: almacena la cantidad de t´erminos que tendr´a la expresi´on.
• contadorTerminos: esta variable tendr´a tres papeles
fundamentales en la soluci´on. Primero servir´a para contar
la cantidad de t´erminos que se van generando dentro de la
expresi´on, segundo har´a parte de la condici´on que contralar´a la
cantidad de veces que se debe repetir el ciclo externo y tercero
se usar´a como el exponente al cual se elevar´a la constante x.
• inferiores: variable que almacenar´a los valores desde 1 hasta
el valor del denominador en cada uno de los t´erminos. Se usar´a
en la condici´on que controlar´a el ciclo con el cual se calcular´a el
factorial del denominador.
• denominador: en esta variable se almacenar´a el denominador
que se va generando para cada t´ermino de la expresi´on, tomar´a
valores pares consecutivos iniciando desde 2. Su prop´osito es
hacer parte de la condici´on del ciclo que calcular´a su factorial.
• factorial: acumula el factorial que se le calcule al
denominador de la expresi´on.
• expresion: en este acumulador se guardar´a el valor del c´alculo
de la expresi´on. Tiene la caracter´ıstica que sufre incrementos y
decrementos de acuerdo al valor del exponente de la constante
x.

-- 249 of 450 --

248 Estructuras de repetici ´on
De acuerdo al an´alisis planteado, se propone el Algoritmo 4.16.
Algoritmo 4.16: ExpresionMatematica
1 Algoritmo ExpresionMatematica
2 // Declaraci´on de variables
3 Entero x, n, contadorTerminos, inferiores,
4 denominador,factorial
5 Real expresion
6
7 // Datos disponibles
8 imprimir( "Ingrese el valor para x: " )
9 leer( x )
10 imprimir( "Ingrese la cantidad de t´erminos (n): " )
11 leer( n )
12
13 // Proceso
14 expresion = 1
15 contadorTerminos = 2
16 denominador = 2
17
18 // Ciclo externo
19 Haga
20 factorial = 1
21 inferiores = 1
22
23 // Ciclo interno
24 Haga
25 factorial = factorial * inferiores
26 inferiores = inferiores + 1
27
28 MientrasQue( inferiores <= denominador )
29
30 // Final del ciclo interno
31
32 denominador = denominador + 2
33
34 Si( (contadorTerminos % 2) == 0 ) Entonces
35 expresion = expresionˆ(x+contadorTerminos)/factorial
36 SiNo
37 expresion = expresionˆ(x-contadorTerminos)/factorial
38 FinSi
39
40 contadorTerminos = contadorTerminos + 1
41
42 MientrasQue( contadorTerminos <= n )
43 // Final del ciclo externo
44
45 imprimir( "El valor de la expresi´on es: ", expresion )
46 FinAlgoritmo

-- 250 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 249
Al ejecutar el algoritmo:
Primera ejecuci´on:
Ingrese el valor para x: 3
Ingrese la cantidad de t´erminos (n): 6
El valor de la expresi´on es: 4.4815
Segunda ejecuci´on:
Ingrese el valor para x: 5
Ingrese la cantidad de t´erminos (n): 7
El valor de la expresi´on es: 9.0863
Explicaci´on del algoritmo:
Para el c´alculo de la expresi´on fue necesario trabajar con dos estructuras
de repetici´on Haga-MientrasQue anidadas. El ciclo externo controla
que se vayan generando y calculando cada uno de los t´erminos de la
expresi´on, desde el segundo hasta el t´ermino n. El ciclo interno es el
responsable de calcular el factorial de los denominadores que se van
generando en cada uno de los t´erminos.
Los acumuladores y contadores tienen una inicializaci´on bien particular
con relaci´on a los ejemplos trabajados hasta el momento:
expresion = 1 (l´ınea 14): a pesar que es un acumulador que va a ser
modificado por sumas y restas sucesivas, no se inicializ´o en 0; en este caso
tom´o el valor de 1 que corresponde al primer t´ermino de la expresi´on.
Dado lo anterior, la generaci´on de los t´erminos y los c´alculos
inician a partir del segundo t´ermino, lo cual justifica las siguientes
inicializaciones que se encuentran en el algoritmo: contadorTerminos
= 2 y denominador = 2 (l´ıneas 15 y 16 respectivamente). Recuerde
que contadorTerminos, tambi´en se us´o como el exponente de x.
Despu´es de calcular el factorial dentro del ciclo interno7, se hace el
incremento o decremento del acumulador de la expresi´on; para ello se
plante´o la decisi´on de la l´ınea 34, en donde se determina si el exponente
de x (contadorTerminos) es par8. Para los valores pares se hace un
incremento (l´ınea 35), para los impares se aplica el decremento (l´ınea 37).
En las Figuras 4.27 y 4.28 se muestra la soluci´on del Ejemplo 4.12
mediante un diagrama de flujo.
7Este proceso se explic´o en el Ejemplo 4.11.
8Todo n´umero par da 0 como resultado del resto, en la divis´on entera entre 2.

-- 251 of 450 --

250 Estructuras de repetici ´on
Inicio
x
n
expresion = 1
contadorTerminos = 2
denominador = 2
2 factorial = 1
inferiores = 1
factorial = factorial * inferiores
inferiores = inferiores + 1
inferiores <=
denominador
1
S´ı
S´ı
No
Figura 4.27: Diagrama de flujo ExpresionMatematica - Parte 1

-- 252 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 251
1
denominador = denominador + 2
(contadorTerminos %
2) == 0
expresion = expresion +
(x ˆ contadorTerminos)/ factorial
expresion = expresion -
(x ˆ contadorTerminos)/ factorial
contadorTerminos =
contadorTerminos + 1
contadorTerminos
<= n
2
expresion
Final
S´ı 	No
S´ı
No
Figura 4.28: Diagrama de flujo ExpresionMatematica - Parte 2
Aclaraci´on:
El ciclo Haga-MientrasQue se suele usar en
procesos de validaci´on de datos de entrada, en donde
se condiciona a que el usuario ingrese datos de
acuerdo a los valores establecidos en los requisitos
del problema.

-- 253 of 450 --

252 Estructuras de repetici ´on
Validaci´on de datos de entrada
Hasta el momento se han trabajado algoritmos donde se asume que la
entrada de los datos es correcta o en su defecto se han colocado mensajes
que informen la situaci´on. Tal es el caso del Ejemplo 4.10 donde el usuario
debe elegir entre Android o iOS digitando una ’A’ o una ’i’; all´ı se mostr´o el
mensaje “La opci´on no es v´alida” para el caso que el usuario del algoritmo
digite un valor diferente a los establecidos. Lo ideal, aparte de informar la
situaci´on, es que el algoritmo est´e dise˜nado de tal forma que no se puedan
hacer entradas con datos errados.
De acuerdo al anterior contexto, se usar´a el ciclo Haga-MientrasQue
para validar que las entradas sean correctas. Esta estructura es la ideal
para hacer este proceso, debido a que primero ejecuta el cuerpo de ciclo y
luego revisa la condici´on.
Se plantea entonces que, para estas validaciones se sigan estos pasos: