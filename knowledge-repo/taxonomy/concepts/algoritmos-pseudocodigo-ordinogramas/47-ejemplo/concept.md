# EJEMPLO

## Fuente
algoritmos-pseudocodigo-ordinogramas (Cap. 47)

## Contenido
# EJEMPLO

/***************************************************/
/* Programa: Calcular_area_circunferencia */
/* */
/* Descripción: Recibe por teclado el radio de una */
/* circunferencia, mostrando su área por pantalla. */
/* */
/* Autor: Carlos Pes */
/* */
/* Fecha: 31/03/2005 */
/***************************************************/
/* Cabecera */
algoritmo Area_de_una_circunferencia
/* Declaraciones */
variables
real radio
/* Cuerpo */
inicio
escribir( "Introduzca radio: " )
leer( radio )
escribir( "El área de la circunferencia es: ",
3.141592 * radio ** 2 )
fin
Han aparecido nuevos símbolos reservados:
Símbolos reservados
Símbolos Descripción
/* Se escribe al principio de un comentario.
*/ Se escribe al final de un comentario.
7.5. Presentación escrita
A la hora de escribir un algoritmo, se debe intentar que su presentación escrita sea lo más
legible posible.
EJEMPLO ¿Cuál es la salida por pantalla del siguiente algoritmo?

-- 77 of 180 --

Libro de Algoritmos de “Abrirllave.com” 78 / 180
algoritmo Ejemplo_no_legible constantes c1 = 3, c2 = 2,
c3 = 4 variables entero v1 =5, v2
= 7 inicio v2 v2
+c1*c2 escribir ( "v2: "
, v2 )v2  v1
* c2 *
c3-v2 escribir( "v2: ", v2 )fin
El algoritmo está escrito correctamente. Sin embargo, es muy difícil entender qué hace. Para
ello, es mejor rescribirlo de una forma más legible.
EJEMPLO El algoritmo del ejemplo anterior se puede escribir así:
algoritmo Ejemplo_legible
constantes
c1 = 3, c2 = 2, c3 = 4
variables
entero v1 = 5, v2 = 7
inicio
v2  v2 + c1 * c2
escribir( "v2: ", v2 )
v2  v1 * c2 * c3 - v2
escribir( "v2: ", v2 )
fin
Obsérvese que, sangrar –tabular– el código de un algoritmo ayuda mucho a su lectura. Así, el
código de este algoritmo es mucho más fácil de comprender que el del anterior, siendo la
salida por pantalla la misma en ambos casos:
Ejercicios resueltos
 Ejercicios de estructura de un algoritmo en pseudocódigo

-- 78 of 180 --

Libro de Algoritmos de “Abrirllave.com” 79 / 180
Capítulo 8
Ordinogramas
En este capítulo se va a estudiar cómo es posible representar algoritmos, gráficamente, por
medio de diagramas de flujo, también llamados ordinogramas.
Un ordinograma representa, gráficamente, el orden de los “pasos” (acciones) de un algoritmo.
Para representar algoritmos mediante diagramas de flujo, se utilizan una serie de símbolos
gráficos que han sido estandarizados por ANSI (American National Standards Institute):

-- 79 of 180 --

Libro de Algoritmos de “Abrirllave.com” 80 / 180
8.1. Asignación
Para representar una instrucción de asignación en un ordinograma, se debe escribir la misma
sintaxis que en pseudocódigo, pero, dentro de un rectángulo:
EJEMPLO Una instrucción de asignación puede ser:
EJEMPLO Varias instrucciones de asignación se pueden agrupar dentro de un mismo
rectángulo:
8.2. Entrada y salida
En un ordinograma, tanto las instrucciones de entrada como las de salida, se escriben igual que
en pseudocódigo, pero, dentro de un romboide:
EJEMPLO Una instrucción de entrada que lea la variable radio, se escribe:

-- 80 of 180 --

Libro de Algoritmos de “Abrirllave.com” 81 / 180
EJEMPLO Varias instrucciones de entrada o de salida pueden dibujarse dentro del mismo
romboide:
8.3. Inicio y fin
En un ordinograma, el inicio y fin del cuerpo de un algoritmo se escriben dentro de un
óvalo de la siguiente manera:
Por medio de las flechas se indica el orden de las acciones –instrucciones– del algoritmo.
EJEMPLO Así pues, el siguiente ordinograma es equivalente al cuerpo de un algoritmo
escrito en pseudocódigo:

-- 81 of 180 --

Libro de Algoritmos de “Abrirllave.com” 82 / 180
8.4. Decisiones
Como veremos más adelante, las decisiones siempre forman parte de las instrucciones de
control, las cuales sirven para determinar el orden en el que se tienen que ejecutar las
instrucciones de un programa.
En un ordinograma, para representar –gráficamente– a una instrucción de control, se utiliza un
rombo y un círculo.
EJEMPLO Una alternativa doble es una instrucción de control que se representa de la
siguiente manera:
En el rombo se toma la decisión de ejecutar un bloque de instrucciones u otro. No obstante,
con independencia de cuál de ellos se ejecute, el círculo reagrupa el flujo de control, es decir,
la ejecución continuará con la siguiente instrucción que haya después del círculo.
Ejercicios resueltos
 Ejercicios de ordinogramas

-- 82 of 180 --

Libro de Algoritmos de “Abrirllave.com” 83 / 180
Capítulo 9
Instrucciones de control alternativas
Como ya se vio en el capítulo 6 “Instrucciones primitivas”, en programación, las instrucciones
que se utilizan para diseñar algoritmos se pueden clasificar en:
 Primitivas.
 De control.
 Llamadas a subalgoritmos (llamadas a subprogramas).
En este capítulo –y en los dos próximos– se van a explicar las instrucciones de control, las
cuales se clasifican en:
 Alternativas (selectivas).
 Repetitivas (iterativas).
 De salto (de transferencia).
Flujo de control
Se llama flujo de control al orden en el que se ejecutan las
