# Capítulo 10

Instrucciones de control repetitivas
Como ya se estudió en el capítulo 6 “Instrucciones primitivas”, en programación, las
instrucciones que se utilizan para diseñar algoritmos se pueden clasificar en:
 Primitivas.
 De control.
 Llamadas a subalgoritmos (llamadas a subprogramas).
A su vez, las instrucciones de control se clasifican en:
 Alternativas (selectivas).
 Repetitivas (iterativas).
 De salto (de transferencia).
Seguidamente, se van a estudiar las instrucciones de control repetitivas.
10.1. Instrucciones repetitivas
Una instrucción de control repetitiva permite ejecutar una o más instrucciones varias veces.
Para comprender por qué son necesarias las instrucciones repetitivas, también llamadas
iterativas, estúdiese el problema del ejemplo siguiente.
EJEMPLO Primeros diez números naturales (del 1 al 10).
Se quiere diseñar el algoritmo de un programa que muestre por pantalla los primeros diez
números naturales:

-- 111 of 180 --

Libro de Algoritmos de “Abrirllave.com” 112 / 180
Para resolver el problema planteado, con lo estudiado hasta ahora en este tutorial, se puede
escribir el siguiente algoritmo:
algoritmo Numeros_del_1_al_10
inicio
escribir( 1 )
escribir( 2 )
escribir( 3 )
escribir( 4 )
escribir( 5 )
escribir( 6 )
escribir( 7 )
escribir( 8 )
escribir( 9 )
escribir( 10 )
fin
El algoritmo funciona bien, pero, ¿y si se quisiera mostrar por pantalla los primeros mil
números naturales, o los primeros diez mil? El número de líneas del algoritmo se
incrementaría considerablemente.
EJEMPLO Otra posibilidad es utilizar una variable:
algoritmo Numeros_del_1_al_10
variables
entero numero
inicio
numero  1
escribir( numero ) /* Escribe el 1 */
numero  numero + 1
escribir( numero ) /* Escribe el 2 */
numero  numero + 1
escribir( numero ) /* Escribe el 3 */
numero  numero + 1
escribir( numero ) /* Escribe el 4 */
numero  numero + 1
escribir( numero ) /* Escribe el 5 */
numero  numero + 1
escribir( numero ) /* Escribe el 6 */
numero  numero + 1
escribir( numero ) /* Escribe el 7 */
numero  numero + 1
escribir( numero ) /* Escribe el 8 */
numero  numero + 1
escribir( numero ) /* Escribe el 9 */
numero  numero + 1
escribir( numero ) /* Escribe el 10 */
fin

-- 112 of 180 --

Libro de Algoritmos de “Abrirllave.com” 113 / 180
El número de instrucciones de este algoritmo es todavía mayor que el del anterior. Los dos
algoritmos realizan, repetidamente, una determinada tarea. En el primer algoritmo se repite la
instrucción de salida:
escribir( <número> )
En el segundo algoritmo se repite una instrucción de asignación y una instrucción de salida:
numero  numero + 1
escribir( numero )
Vamos a ver que, las instrucciones repetitivas permiten ejecutar un bloque de instrucciones
repetidamente, escribiéndolas una sola vez en el algoritmo, reduciendo de este modo el
código del mismo. Existen tres tipos de instrucciones repetitivas:
 Mientras.
 Hacer...mientras.
 Para.
El problema planteado se puede resolver utilizando, indistintamente, cualquiera de las tres
instrucciones repetitivas. Sin embargo, como veremos en el apartado “10.5. Cuándo usar un
bucle u otro”, para algunas tareas puede ser más conveniente utilizar una determinada
instrucción que otra.
A las instrucciones repetitivas también se las conoce como bucles, ciclos o lazos.
10.2. Repetitiva mientras
En pseudocódigo, para escribir una instrucción repetitiva mientras, se utiliza la sintaxis:
mientras ( <expresión_lógica> )
<bloque_de_instrucciones>
fin_mientras
/* Mientras que la <expresión_lógica> sea verdadera,
se ejecuta el <bloque_de_instrucciones>. */
Igual que en las instrucciones alternativas doble y simple, a la <expresión_lógica> de
una instrucción repetitiva mientras, también se le llama condición.
Para que se ejecute el <bloque_de_instrucciones>, la condición tiene que ser
verdadera. Por el contrario, si la condición es falsa, el <bloque_de_instrucciones> no
se ejecuta.
Por tanto, cuando el flujo de un algoritmo llega a un bucle mientras, existen dos
posibilidades:

-- 113 of 180 --

Libro de Algoritmos de “Abrirllave.com” 114 / 180