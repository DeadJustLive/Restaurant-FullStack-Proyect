# parte c: entral del algoritmo o de otros procedimientos.

## Fuente
logica-de-programacion (Cap. 148)

## Contenido
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
El punto S t
