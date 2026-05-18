# 0. Si el resultado es verdadero, significa que se est´a frente a un dato vac´ıo,

## Fuente
logica-de-programacion (Cap. 69)

## Contenido
# 0. Si el resultado es verdadero, significa que se est´a frente a un dato vac´ıo,

en consecuencia, el ciclo debe repetirse para leer nuevamente la variable
nombre. Esta condici´on tomar´a el valor de falso en el momento que ingresen
un nombre, m´ınimo de 1 car´acter.
Tambi´en es v´alido condicionar a que m´ınimo sea un determinado n´umero
de caracteres, por ejemplo, si se quisiera que el nombre tuviera m´ınimo 3
caracteres, la condici´on se plantear´ıa as´ı:
MientrasQue( longitud( nombre ) < 3 )
De forma similar, se puede establecer la cantidad m´ınima y m´axima
de caracteres en el nombre. La siguiente condici´on valida que no se vaya a
dejar el nombre como un dato en blanco y que m´aximo tenga 15 caracteres:
MientrasQue( longitud( nombre ) == 0 O
longitud( nombre ) > 15 )
Tambi´en es posible validar si el contenido de la cadena corresponde o no
a ciertos valores10 (Ver Algoritmo 4.24).
Algoritmo 4.24: Ejemplo de validaci´on del contenido de una Caracter
1 imprimir( "Ingrese una cadena: " )
2 Haga
3 leer( cadena )
4 MientrasQue( cadena != "texto1" Y cadena != "texto2" )
Ahora que ya conoce como validar la entrada de datos a un algoritmo, se
proceder´a a analizar algunos ejemplos haciendo uso de estas validaciones.
.:Ejemplo 4.13. El m´etodo de multiplicaci´on de los campesinos rusos,
consiste en tomar los dos factores de la operaci´on (multiplicando y
multiplicador) y disponerlos cada uno en una columna. El primer factor
10Existen ciertos lenguajes de programaci´on que requieren instrucciones especiales
para comparar cadenas, en este libro no ser´an necesarias tales instrucciones especiales

-- 257 of 450 --

256 Estructuras de repetici ´on
se va multiplicando sucesivamente por 2, simult´aneamente en la segunda
columna al segundo factor se le van aplicando divisiones enteras entre 2.
Estas operaciones se realizan hasta que el segundo factor llegue a 1. El
siguiente paso es sumar todos los n´umeros de la primera columna que est´en
al frente de un n´umero impar de la segunda columna. El resultado que se
obtenga es el producto de los dos n´umeros.
A continuaci´on, se ilustra el m´etodo descrito, con la multiplicaci´on de 3
por 19 donde el resultado esperado es 57.
Primer factor Segundo factor Impar Producto
3 19 S´ı 3
6 9 S´ı 6
12 4 No
24 2 No
48 1 S´ı 48
Total suma: 57
Tabla 4.7: Ejemplo ilustrativo - Ejemplo 4.13
Basados en el m´etodo descrito, se va a desarrollar un algoritmo que halle
el producto de dos n´umeros enteros entre 0 y 10000.
An´alisis del problema:
Resultados esperados: producto de dos n´umeros enteros.
Datos disponibles: multiplicando y multiplicador.
Proceso: se hace la lectura del multiplicando y del multiplicador,
teniendo en cuenta que sus valores deben estar entre 0 y 1000011.
Una vez se tengan los valores de entrada, se implementar´a un proceso
repetitivo en donde en cada iteraci´on se multiplique por 2 el primer
factor o multiplicando; de manera simult´anea se realizan divisiones
enteras, entre 2, del segundo factor o multiplicador. En cada vuelta
del ciclo se debe analizar si cada uno de los valores que va tomando
el segundo factor es impar y as´ı proceder a hacer la acumulaci´on del
primer factor. Este proceso iterativo terminar´a en el momento que
las divisiones del segundo factor lo lleven a un valor de 1.
11Tenga en cuenta que el tope para el valor del dato de entrada no afecta el proceso
que se va a realizar, puede establecer topes diferentes. Ac´a se estableci´o este valor a
manera de ejemplo.

-- 258 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 257
Variables requeridas:
• multiplicando y multiplicador: datos de entrada para
calcular el producto.
• factor1 y factor2: almacenar´an una copia del valor original
del multiplicando y del multiplicador.
• producto: resultado esperado que se obtendr´a de la
acumulaci´on sucesiva de los valores del primer factor.
De acuerdo al an´alisis planteado, se propone el Algoritmo 4.25.
Algoritmo 4.25: MultiplicacionRusa
1 Algoritmo MultiplicacionRusa
2 // Declaraci´on de variables
3 Entero multiplicando, multiplicador, producto,
4 factor1, factor2
5
6 // Datos disponibles
7 imprimir( "Ingrese el multiplicando: " )
8 Haga
9 leer( multiplicando )
10 MientrasQue( multiplicando < 0 || multiplicando > 10000 )
11
12 imprimir( "Ingrese el multiplicador: " )
13 Haga
14 leer( multiplicador )
15 MientrasQue( multiplicador < 0 || multiplicador > 10000 )
16
17 // Proceso
18 factor1 = multiplicando // Se hace copia del valor
19 factor2 = multiplicador // Se hace copia del valor
20 producto = 0
21
22 Haga
23 Si( factor2 % 2 != 0 ) Entonces
24 producto = producto + factor1
25 FinSi
26
27 factor1 = factor1 * 2
28 factor2 = factor2 / 2
29 MientrasQue( factor2 >= 1 )
30
31 // Resultados esperados
32 imprimir( "Producto de ", multiplicando,
33 " x ", multiplicador, " = ", producto )
34 FinAlgoritmo

-- 259 of 450 --

258 Estructuras de repetici ´on
Al ejecutar el algoritmo:
Ingrese el multiplicando: 5
Ingrese el multiplicador: 17
Producto de 5 x 17 = 
