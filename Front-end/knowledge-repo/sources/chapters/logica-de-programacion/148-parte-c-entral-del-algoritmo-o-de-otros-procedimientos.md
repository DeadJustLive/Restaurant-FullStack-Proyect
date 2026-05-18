# parte c: entral del algoritmo o de otros procedimientos.

Usar procedimientos permite “ocultar” o encapsular
funcionalidades y por medio de las invocaciones se tiene acceso
a ellas. Cada procedimiento se puede estudiar y comprender
aisladamente y luego se crea un algoritmo y otros procedimientos
que haciendo las respectivas invocaciones resuelven un problema
mayor. Para el caso, el procedimiento imprime una serie, pero su
doble invocaci´on resolvi´o el problema inicial.
.:Ejemplo 5.4. Se desea crear un procedimiento gen´erico que permita
imprimir la coordenadas (x, y) de un punto cualquiera en un plano
cartesiano, con su respectivo nombre del punto. (Ver Figura 5.3).
6
-
t
xk
yk K(xk, yk)
Figura 5.3: Coordenada de un punto K

-- 335 of 450 --

334 Procedimientos y funciones
An´alisis del problema:
Resultados esperados: la impresi´on del nombre del punto (“K”)
con sus respectivas coordenadas x, y.
Datos disponibles: el valor de las coordenadas x, y.
Proceso: solicitar al usuario las coordenadas del punto “K” y luego
se invoca el procedimiento para imprimirlo.
Variables requeridas:
• xk: valor de la coordenada x del punto “K”.
• yk: valor de la coordenada y del punto “K”.
. Internos al procedimiento se necesitan:
• nombre: nombre del punto arbitrario.
• x: valor de la coordenada x del punto arbitrario.
• y: valor de la coordenada y del punto arbitrario.
.	De acuerdo al an´alisis planteado, se propone el Algoritmo 5.5.
Algoritmo 5.5: Punto
1 Algoritmo Punto
2 // Declaraci´on de las variables
3 Real xk, yk
4
5 // Datos disponibles
6 imprimir( "Ingrese el valor de x del punto K: " )
7 leer( xk )
8
9 imprimir( "Ingrese el valor de y del punto K: " )
10 leer( yk )
11
12 // Resultados esperados
13 imprimirPunto ( "K", xk, yk )
14 FinAlgoritmo
15
16 Procedimiento imprimirPunto( Cadena nombre, Real x, Real y )
17 imprimir( "El punto ", nombre )
18 imprimir( "tiene coordenadas (", x, ", ", y ")" )
19 FinProcedimiento

-- 336 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 335
Al ejecutar el algoritmo:
Ingrese el valor de x del punto K: 5
Ingrese el valor de y del punto K: 73
El punto K tiene coordenadas ( 5, 73 )
Ingrese el valor de x del punto K: 31
Ingrese el valor de y del punto K: 5
El punto K tiene coordenadas ( 31, 5 )
Explicaci´on del algoritmo:
En las primeras l´ıneas de la tercera a la d´ecima, se declaran las variables
del algoritmo y posteriormente se leer los datos disponibles. Luego le
invoca el m´etodo para imprimir el punto (imprimirPunto), enviando
la informaci´on que ´el requiere (nombre del punto, las coordenadas x, y).
Observe que los par´ametros (nombre, x, y) toman los valores “K”, el
valor de la coordenada x del punto k (xk) y el valor de la coordenada y
del punto k (yx).
.:Ejemplo 5.5. Usando el procedimiento del punto anterior, dise˜ne un
algoritmo que permita imprimir los datos de dos puntos “T” y “S” (Ver
Figura 5.4).
6
-
t
t
xt xs
ys
yt
S(xs, ys)
T (xt, yt)
Figura 5.4: Puntos S, T en el plano cartesiano
An´alisis del problema:
Resultados esperados: la impresi´on del nombre del punto (“T” y
“S”) con sus respectivas coordenadas x, y.

-- 337 of 450 --

336 Procedimientos y funciones
Datos disponibles: el valor de las coordenadas x, y de ambos
puntos.
Proceso: solicitar al usuario las coordenadas de los puntos “T” y
“S” y luego se invoca dos veces el procedimiento para imprimir la
informaci´on.
Variables requeridas:
• xt: valor de la coordenada x del punto “T”.
• yt: valor de la coordenada y del punto “T”.
• xs: valor de la coordenada x del punto “S”.
• ys: valor de la coordenada y del punto “S”.
. Internos al procedimiento se necesitan:
• nombre: nombre del punto arbitrario.
• x: valor de la coordenada x del punto arbitrario.
• y: valor de la coordenada y del punto arbitrario.
.
De acuerdo al an´alisis planteado, se propone el Algoritmo 5.6.
Algoritmo 5.6: Puntos
1 Algoritmo Puntos
2 // Declaraci´on de las variables
3 Real xt, yt, xs, ys
4
5 // Datos disponibles
6 imprimir( "Ingrese el valor de x del punto T: " )
7 leer( xt )
8
9 imprimir( "Ingrese el valor de y del punto T: " )
10 leer( yt )
11
12 imprimir( "Ingrese el valor de x del punto S: " )
13 leer( xs )
14
15 imprimir( "Ingrese el valor de y del punto S: " )
16 leer( ys )
17
18 // Resultados esperados
19 imprimirPunto ( "T", xt, yt )
20 imprimirPunto ( "S", xs, ys )
21 FinAlgoritmo

-- 338 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 337
22
23 Procedimiento imprimirPunto( Cadena nombre, Real x, Real y )
24 imprimir( "El punto ", nombre )
25 imprimir( "tiene co
Al ejecutar el algoritmo:
Ingrese el valor de x del punto T: 31
Ingrese el valor de y del punto T: 5
Ingrese el valor de x del punto S: 19
Ingrese el valor de y del punto S: 73
El punto T tiene coordenadas ( 31, 5 )
El punto S tiene coordenadas ( 19, 73 )
Ingrese el valor de x del punto T: 10
Ingrese el valor de y del punto T: 27
Ingrese el valor de x del punto S: 1
Ingrese el valor de y del punto S: 31
El punto T tiene coordenadas ( 10, 27 )
El punto S tiene coordenadas ( 1, 31 )
Explicaci´on del algoritmo:
Observe que adicional a la declaraci´on y lectura de los datos disponibles,
se hace la invocaci´on al mismo procedimiento pero enviando la informaci´on
correspondiente en cada caso. Note que el procedimiento imprimirPunto
no sufri´o modificaci´on alguna, esta es una de las fortalezas del uso de
procedimientos en los algoritmos, el poder reutilizar c´odigo.
En la Figura 5.5 se muestra la soluci´on del Ejemplo 5.5 mediante un
diagrama de flujo.

-- 339 of 450 --

338 Procedimientos y funciones
Inicio
tx
ty
sx
sy
imprimirPunto ( “T”, tx, ty )
imprimirPunto ( “S”, sx, sy )
Final
Procedimiento
imprimirPunto( nombre, x, y )
“El punto ”, nombre
“tiene coordenadas (”, x, “, ”, y “)”
FinProcedimiento
Figura 5.5: Diagrama de flujo del Algoritmo Puntos
5.2. Funciones
Un tipo especial de procedimiento es aquel que tiene la capacidad de
entregar un valor como respuesta. A este tipo de procedimiento se le conoce
con el nombre de Funci´on. Algunos autores definen los procedimientos
como funciones que no retornan ning´un tipo de valor, aunque esta
aproximaci´on en principio es correcta, es en realidad imprecisa desde el
punto de vista del concepto matem´atico de funci´on el cual se desea emplear
en programaci´on.

-- 340 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 339
As´ı como se defini´o la palabra reservada Procedimiento, ahora se
define Funcion (sin acento), para declarar una funci´on en un algoritmo.
Adicional a esta palabra, se declaran FinFuncion y Retornar; la
primera se utiliza para indicar donde termina la nueva funci´on y la ´ultima
es necesaria para indicar cual es el valor que la funci´on entrega como
resultado. Este valor debe coincidir con el tipo de dato que se indic´o en la
funci´on, justo antes de su nombre.
La forma general de esta estructura es presentada en el segmento del
Algoritmo 5.7.
Algoritmo 5.7: Forma general de una Funcion
1 Funcion tipoDato verboComplemento ( [lista de par´ametros]
)
2 Instrucci´on1
3 Instrucci´on2
4 ...
5 Instrucci´onn
6
7 Retornar valor
8 FinFuncion
Aclaraci´on:
En los lenguajes que no tienen paso de par´ametros
por referencia, como es el caso del lenguaje
algor´ıtmico utilizado en este libro, las funciones solo
retornan un ´unico valor.
Cuando el lenguaje dispone de paso de par´ametros por referencia,
es posible usar m´as de un par´ametro para “Retornar” valores, sin
embargo, al final, esta no es una buena pr´actica. Lo ideal en cualquier
caso, es declarar perfectamente la funcionalidad y retornar un ´unico
valor.
En este libro, as´ı como en los lenguajes de programaci´on, existe
un conjunto de procedimientos y funciones disponibles que pueden ser
utilizados directa o indirectamente para resolver problemas. Ejemplos
para el libro: leer, imprimir, longitud, sin, cos, tan, abs,
raizCuadrada, entre otros.

-- 341 of 450 --

340 Procedimientos y funciones
.:Ejemplo 5.6. Dise˜ne un algoritmo que permita determinar la distancia
entre dos puntos “T” y “S” (Ver Figura 5.6).
6
-
t
t
xt xs
ys
yt
S(xs, ys)
T (xt, yt)
@
@@
@
@@
@
@@
@
@@
@
@@
@@
@
@
@
@@
@
@
@@
@
@@
@
d
Figura 5.6: Distancia entre dos puntos T y S
An´alisis del problema:
Resultados esperados: la distancia entre los puntos “T” y “S”.
Datos disponibles: las coordenadas x, y de ambos puntos.
Proceso: solicitar al usuario que ingrese las coordenadas x, y de
ambos puntos. Posteriormente se procede a calcular la distancia entre
los puntos usando la ecuaci´on: d =
√
(xs − xt)2 + (ys − yt)2
Variables requeridas:
• xt: valor de la coordenada x del punto “T”.
• yt: valor de la coordenada y del punto “T”.
• xs: valor de la coordenada x del punto “S”.
• ys: valor de la coordenada y del punto “S”.
• distancia: valor de la distancia entre los puntos “T” y “S”.
. Internos al procedimiento calcularDistancia se necesitan:
• Par´ametros:
◦ x1: valor de la coordenada x del primer punto.
◦ y1: valor de la coordenada y del primer punto. arbitrario.
◦ x2: valor de la coordenada x del segundo punto.

-- 342 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 341
◦ y2: valor de la coordenada y del segundo punto.
.
• d: distancia entre dos puntos.
.
De acuerdo al an´alisis planteado, se propone el Algoritmo 5.8.
Algoritmo 5.8: DistanciaPuntos
1 Algoritmo DistanciaPuntos
2 // Declaraci´on de las variables
3 Real xt, yt, xs, ys, distancia
4
5 // Datos disponibles
6 imprimir( "Ingrese el valor de x del punto T: " )
7 leer( xt )
8
9 imprimir( "Ingrese el valor de y del punto T: " )
10 leer( yt )
11
12 imprimir( "Ingrese el valor de x del punto S: " )
13 leer( xs )
14
15 imprimir( "Ingrese el valor de y del punto S: " )
16 leer( ys )
17
18 // Calculo de los datos esperados
19 distancia = calcularDistancia ( xt, yt, xs, ys )
20
21 // Resultados esperados
22 imprimir ( "La distancia entre T y S es de ", distancia )
23 FinAlgoritmo
24
25 Funcion Real calcularDistancia( Real x1, Real y1,
Real x2, Real y2 )
26 Real d
27 d = raizCuadrada( (x2 - x1)ˆ2 + (y2 - y1)ˆ2 )
28 Retornar d
29 FinFuncion
Al ejecutar el algoritmo:
Primera ejecuci´on
Ingrese el valor de x del punto T: 10
Ingrese el valor de y del punto T: 4
Ingrese el valor de x del punto S: 6
Ingrese el valor de y del punto S: 7
La distancia entre T y S es de 5.0

-- 343 of 450 --

342 Procedimientos y funciones
Segunda ejecuci´on
Ingrese el valor de x del punto T: 10
Ingrese el valor de y del punto T: 27
Ingrese el valor de x del punto S: 1
Ingrese el valor de y del punto S: 31
La distancia entre T y S es de 9,848857802
Explicaci´on del algoritmo:
En primeras l´ıneas (de la 6 a la 16) se declaran las variables y se leer los
datos disponibles, luego se invoca el procedimiento calcularDistancia
enviando la informaci´on disponibles, es decir, se invoca con las coordenadas
del punto “T” y el punto “S”. El procedimiento recibe esta informaci´on en
sus respectivos par´ametros x1, y1, x2, y2 paa luego aplicar la formula
de distancia y retornar el valor calculado mediante la variable local d. El
procedimiento puede ser usado para calcular la distancia entre cualquier
par de puntos (ver el siguiente ejemplo).
.:Ejemplo 5.7. Dise˜ne un algoritmo que calcule e imprima el per´ımetro1
de un triangulo dadas las coordenadas de cada uno de sus v´ertices. (Ver
Figura 5.7).
P (xp, yp)
R(xr , yr )
Q(xq , yq )
Figura 5.7: Tri´angulo de v´ertices P , Q y R
An´alisis del problema:
Resultados esperados: el per´ımetro de un tri´angulo dados los tres
v´ertices del mismo, denominados arbitrariamente “P”, “Q”, y “R”.
1El per´ımetro de una figura, se calcula como la suma de las longitudes de los lados
de la figura. La longitud se puede determinar calculando la distancia entre los puntos
extremos de cada lado (vertices).

-- 344 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 343
Datos disponibles: las coordenadas x, y de cada uno de los tres
v´ertices.
Proceso: se le solicita al usuario que ingrese las coordenadas x, y
de cada uno de los tres v´ertices, luego se determina la distancia entre
ellos:
d1 = calcularDistancia( x1, y1, x2, y2 )
d2 = calcularDistancia( x1, y1, x3, y3 )
d3 = calcularDistancia( x2, y2, x3, y3 )
Posteriormente se realiza la suma de las distancias para encontrar el
valor del per´ımetro:
perimetro = d1 + d2 + d3
Variables requeridas:
• xt: valor de la coordenada x del punto “P”.
• yt: valor de la coordenada y del punto “P”.
• xs: valor de la coordenada x del punto “Q”.
• ys: valor de la coordenada y del punto “Q”.
• xs: valor de la coordenada x del punto “R”.
• ys: valor de la coordenada y del punto “R”.
• perimetro: valor del triangulo con v´ertices “P”, “Q” y “R”.
. Internos al procedimiento calcularPerimetro se necesitan:
• Par´ametros:
◦ x1: valor de la coordenada x del primer punto.
◦ y1: valor de la coordenada y del primer punto.
◦ x2: valor de la coordenada x del segundo punto.
◦ y2: valor de la coordenada y del segundo punto.
◦ x3: valor de la coordenada x del tercer punto.
◦ y3: valor de la coordenada y del tercer punto.
• d1: valor de distancia entre el primer y segundo punto.
• d2: valor de distancia entre el primero y tercer punto.
• d3: valor de distancia entre el segundo y tercer punto.
• perimetro: valor del per´ımetro calculado como la suma de las
distancias entre los puntos.
. Internos al procedimiento calcularDistancia se necesitan:
• Par´ametros:

-- 345 of 450 --

344 Procedimientos y funciones
◦ x1: valor de la coordenada x del primer punto.
◦ y1: valor de la coordenada y del primer punto. arbitrario.
◦ x2: valor de la coordenada x del segundo punto.
◦ y2: valor de la coordenada y del segundo punto.
.
• d: distancia entre dos puntos.
.	De acuerdo al an´alisis planteado, se propone el Algoritmo 5.9.
Algoritmo 5.9: DistanciaPuntos
1 Algoritmo DistanciaPuntos
2 // Declaraci´on de las variables
3 Real xp, yp, xq, yq, xr, yr, perimetro
4
5 // Datos disponibles
6 imprimir( "Ingrese el valor de x del punto P: " )
7 leer( xp )
8
9 imprimir( "Ingrese el valor de y del punto P: " )
10 leer( yp )
11
12 imprimir( "Ingrese el valor de x del punto Q: " )
13 leer( xq )
14
15 imprimir( "Ingrese el valor de y del punto Q: " )
16 leer( yq )
17
18 imprimir( "Ingrese el valor de x del punto R: " )
19 leer( xr )
20
21 imprimir( "Ingrese el valor de y del punto R: " )
22 leer( yr )
23
24 // Calculo de los datos esperados
25 perimetro = calcularPerimetro ( xp, yp, xq, yq, xr, yr )
26
27 // Resultados esperados
28 imprimir ( "El per´ımetro del triangulo es ", perimetro )
29 FinAlgoritmo
30
31 Funcion Real calcularPerimetro( Real x1, Real y1,
32 Real x2, Real y2,
33 Real x3, Real y3 )
34 Real perimetro, d1, d2, d3
35
36 d1 = calcularDistancia ( x1, y1, x2, y2 )
37 d2 = calcularDistancia ( x1, y1, x3, y3 )

-- 346 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 345
38 d3 = calcularDistancia ( x2, y2, x3, y3 )
39
40 perimetro = d1 + d2 + d3
41
42 Retornar perimetro
43 FinFuncion
44
45 Funcion Real calcularDistancia( Real x1, Real Y1,
46 Real X2, Real Y2 )
47 Real d
48 d = raizCuadrada( (x2 - x1)ˆ2 + (y2 - y1)ˆ2 )
49 Retornar d
50 FinFuncion
Al ejecutar el algoritmo:
Primera ejecuci´on
Ingrese el valor de x del punto P: 0
Ingrese el valor de y del punto P: 4
Ingrese el valor de x del punto Q: 5
Ingrese el valor de y del punto Q: 3
Ingrese el valor de x del punto R: 3
Ingrese el valor de y del punto R: 0
El per´ımetro del triangulo es 13,70457079
Segunda ejecuci´on
Ingrese el valor de x del punto P: 5
Ingrese el valor de y del punto P: 3
Ingrese el valor de x del punto Q: 5
Ingrese el valor de y del punto Q: 7
Ingrese el valor de x del punto R: 8
Ingrese el valor de y del punto R: 7
El per´ımetro del triangulo es 12
Explicaci´on del algoritmo:
Lo primero es observar que en este ejemplo se emplearon dos
procedimientos m´as la parte central del algoritmo. En la parte central
se declaran y se solicitan todos los datos disponibles (l´ıneas de la 3 a la
22), luego se invoca la funci´on que calcula el per´ımetro del tri´angulo y
finalmente se imprime el resultado obtenido.
Hasta este punto no es necesario conocer el c´omo se calcula el per´ımetro,
debido a que todo est´a “oculto” dentro el procedimiento (encapsulado).
Por tanto, la parte central se limita a solicitar la informaci´on, calcular los
resultados esperados e imprimirlos.

-- 347 of 450 --

346 Procedimientos y funciones
Por otro lado, la funci´on calcularPerimetro recibe la informaci´on
de las coordenadas de los tres v´ertices y procede a calcular el per´ımetro
mediante la suma de las distancias entre los v´ertices. Pero esta distan es
calculada mediante la funci´on calcularDistancia.
31 Funcion Real calcularPerimetro( Real x1, Real y1,
32 Real x2, Real y2,
33 Real x3, Real y3 )
34 Real perimetro, d1, d2, d3
35
36 d1 = calcularDistancia ( x1, y1, x2, y2 )
37 d2 = calcularDistancia ( x1, y1, x3, y3 )
38 d3 = calcularDistancia ( x2, y2, x3, y3 )
39
40 perimetro = d1 + d2 + d3
41
42 Retornar perimetro
43 FinFuncion
La funci´on calcularDistancia recibe la informaci´on de los dos
vertices arbitrarios y calcula la distancia entre ellos, as´ı, al invocar tres
veces la funci´on con la informaci´on apropiada (l´ıneas de la 36 a la 38) es
posible calcular todas las distancias necesarias.
45 Funcion Real calcularDistancia( Real x1, Real Y1,
46 Real X2, Real Y2 )
47 Real d
48 d = raizCuadrada( (x2 - x1)ˆ2 + (y2 - y1)ˆ2 )
49 Retornar d
50 FinFuncion
Aclaraci´on:
Aunque en apariencia los algoritmos se vuelven m´as
largos, el hacer uso de procedimientos / funciones
permite la soluci´on de problemas cada vez m´as
complejos, al permitir atacar la complejidad del
problema al dividi´endolos en componentes m´as
peque˜nos y f´aciles de manejar.

-- 348 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 347
Buenas pr´acticas:
Dejar lo m´as claro posible cada elemento del
algoritmo:
Documente cuando sea conveniente y sin abusar
de este recurso.
Definida cual es la responsabilidad de cada
funci´on / procedimiento. Evite que ellas tengan
m´as de una responsabilidad.
Use nombre para las funciones / procedimiento
acordes con la responsabilidad asociada.
Evite exagerar en la cantidad de par´ametros de
un funci´on / procedimiento necesita.
Controle la longitud de todas y cada una de
las funciones / procedimiento para evitar que
superen una p´agina, de ser el caso, delegue