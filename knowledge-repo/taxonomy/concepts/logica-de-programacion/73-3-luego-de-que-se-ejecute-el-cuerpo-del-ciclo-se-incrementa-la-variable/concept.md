# 3. Luego de que se ejecute el cuerpo del ciclo, se incrementa la variable

## Fuente
logica-de-programacion (Cap. 73)

## Contenido
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
•
