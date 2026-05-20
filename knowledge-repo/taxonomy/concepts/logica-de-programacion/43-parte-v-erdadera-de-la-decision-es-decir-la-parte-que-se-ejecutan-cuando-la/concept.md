# parte V: erdadera de la decisi´on, es decir la parte que se ejecutan cuando la

## Fuente
logica-de-programacion (Cap. 43)

## Contenido
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
Observe que la impresi´on del men
