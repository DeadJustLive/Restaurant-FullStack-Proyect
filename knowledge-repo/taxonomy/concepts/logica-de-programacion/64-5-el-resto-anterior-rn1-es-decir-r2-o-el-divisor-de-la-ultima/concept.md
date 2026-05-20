# 5. El resto anterior (rn−1), es decir r2 o el divisor de la ´ultima

## Fuente
logica-de-programacion (Cap. 64)

## Contenido
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
In
