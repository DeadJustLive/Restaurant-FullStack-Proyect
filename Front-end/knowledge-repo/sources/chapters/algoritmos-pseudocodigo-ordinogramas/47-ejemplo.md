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
Se llama flujo de control al orden en el que se ejecutan las instrucciones de un programa,
siendo las propias instrucciones las que determinan o controlan dicho flujo.
En un programa, a menos que el flujo de control se vea modificado por una instrucción de
control, las instrucciones siempre se ejecutan secuencialmente, una detrás de otra, en orden
de aparición, de izquierda a derecha y de arriba abajo, que es el flujo natural de un programa.
En programación estructurada, se considera una mala práctica hacer uso de las instrucciones
de salto, ya que, entre otras cosas, restan legibilidad al algoritmo.
Si bien, se debe evitar el uso de las instrucciones de salto, muchos lenguajes de programación,
entre ellos C, permiten codificarlas. Por esta razón, las estudiaremos más adelante en este
tutorial.

-- 83 of 180 --

Libro de Algoritmos de “Abrirllave.com” 84 / 180
9.1. Instrucciones alternativas
Una instrucción de control alternativa permite seleccionar, en el flujo de control de un
programa, la o las siguientes instrucciones a ejecutar, de entre varias posibilidades.
Para comprender el porqué son necesarias las instrucciones alternativas, estúdiese el siguiente
problema.
EJEMPLO Calificación según nota (Versión 1).
Se quiere diseñar el algoritmo de un programa que:
1º) Pida por teclado la nota (dato real) de una asignatura.
2º) Muestre por pantalla:
 “APROBADO”, en el caso de que la nota sea mayor o igual que 5.
 “SUSPENDIDO”, en el caso de que la nota sea menor que 5.
De modo que, por pantalla se verá, por ejemplo:
Otra posibilidad es:
Con lo estudiado hasta ahora, para resolver el problema planteado se puede escribir el
siguiente algoritmo erróneo:
algoritmo Calificacion_segun_nota
variables
real nota
inicio
escribir( "Introduzca nota (real): " )
leer( nota )
escribir( "APROBADO" )
escribir( "SUSPENDIDO" )
fin

-- 84 of 180 --

Libro de Algoritmos de “Abrirllave.com” 85 / 180
Pero, ¿qué sucede? Tal y como se ha escrito, ¡no funciona bien! Se ha cometido un error
lógico. Por pantalla se mostrará, por ejemplo:
O también:
Después de leer la nota por teclado, se necesita poder seleccionar la siguiente instrucción a
ejecutar. Una de entre:
escribir( "APROBADO" )
escribir( "SUSPENDIDO" )
No deben ejecutarse las dos instrucciones anteriores, sino solamente una de ellas. Una
instrucción alternativa va a permitir seleccionar cuál de ellas debe ejecutarse. Existen tres tipos
de instrucciones alternativas: doble, simple y múltiple.
Como vamos a ver seguidamente, el problema planteado se puede resolver utilizando una
instrucción alternativa doble.
9.1.1. Alternativa doble
En pseudocódigo, para escribir una instrucción alternativa doble se utiliza la sintaxis:
si ( <expresión_lógica> )
<bloque_de_instrucciones_1>
sino
<bloque_de_instrucciones_2>
fin_si
/* Si la <expresión_lógica> es verdadera,
se ejecuta el <bloque_de_instrucciones_1>, sino
se ejecuta el <bloque_de_instrucciones_2>. */

-- 85 of 180 --

Libro de Algoritmos de “Abrirllave.com” 86 / 180
A la <expresión_lógica> de una instrucción alternativa doble también se le denomina
condición.
Para que se ejecute el <bloque_de_instrucciones_1>, la condición tiene que ser
verdadera. Por el contrario, si la condición es falsa, se ejecutará el <bloque_de_
instrucciones_2>.
En resumen, una instrucción alternativa doble (o simplemente alternativa doble) permite
seleccionar, por medio de una condición, el siguiente bloque de instrucciones a ejecutar, de
entre dos posibles.
EJEMPLO Así pues, el error lógico del ejemplo anterior, se puede resolver con el código:
algoritmo Calificacion_segun_nota
variables
real nota
inicio
escribir( "Introduzca nota (real): " )
leer( nota )
si ( nota >= 5 )
escribir( "APROBADO" )
sino
escribir( "SUSPENDIDO" )
fin_si
fin
Este algoritmo sí cumple con las especificaciones del problema, o dicho de otro modo, sí hace
lo que se espera de él. Del resultado de evaluar la expresión lógica:
nota >= 5
Depende que se ejecute la instrucción:
escribir( "APROBADO" )
O, por el contrario, la instrucción:
escribir( "SUSPENDIDO" )
Cuando en un algoritmo existe una condición de la cual depende que a continuación se
ejecuten unas instrucciones u otras, se dice que existe una bifurcación.
Han aparecido tres nuevas palabras reservadas: si, sino y fin_si.
Además, han vuelto a aparecer los símbolos reservados abrir paréntesis “(” y cerrar paréntesis
“)”, con un significado distinto.
() Delimitan la condición en una instrucción alternativa doble.

-- 86 of 180 --

Libro de Algoritmos de “Abrirllave.com” 87 / 180
En un ordinograma, una instrucción alternativa doble se representa de la siguiente manera:
En consecuencia, el algoritmo del ejemplo anterior se puede representar, gráficamente, de la
siguiente forma:
Ejercicios resueltos
 Ejercicios de la instrucción alternativa doble
9.1.2. Alternativa simple
Una instrucción alternativa simple (o simplemente alternativa simple) es una variante (más
sencilla) de una instrucción alternativa doble. En pseudocódigo, para escribir una alternativa
simple se utiliza la sintaxis:
si ( <expresión_lógica> )
<bloque_de_instrucciones>
fin_si
/* Si la <expresión_lógica> es verdadera,
se ejecuta el <bloque_de_instrucciones>, sino
no se ejecuta nada. */

-- 87 of 180 --

Libro de Algoritmos de “Abrirllave.com” 88 / 180
EJEMPLO Calificación según nota (Versión 2).
Se quiere diseñar el algoritmo de un programa que:
1º) Pida por teclado la nota (dato real) de una asignatura.
2º) Muestre por pantalla:
 “APROBADO”, en el caso de que la nota sea mayor o igual que 5.
Obsérvese que, en este problema, no se va a mostrar por pantalla “SUSPENDIDO” en el caso de
que la nota sea menor que 5, como sí se hacía en el problema del ejemplo anterior.
El algoritmo puede ser:
algoritmo Calificacion_segun_nota
variables
real nota
inicio
escribir( "Introduzca nota (real): " )
leer( nota )
si ( nota >= 5 )
escribir( "APROBADO" )
fin_si
fin
En el caso de que la condición ( nota >= 5 ) sea falsa, el programa terminará, no se
ejecutará ninguna instrucción más.
En un ordinograma, una instrucción alternativa simple se representa de la siguiente manera:

-- 88 of 180 --

Libro de Algoritmos de “Abrirllave.com” 89 / 180
Por tanto, el algoritmo del ejemplo “Calificación según nota (Versión 2)” se puede representar,
de manera gráfica, como se muestra a continuación:
9.1.3. Alternativa múltiple
Una instrucción alternativa múltiple (o simplemente alternativa múltiple) permite
seleccionar, por medio de una expresión, el siguiente bloque de instrucciones a ejecutar de
entre varios posibles. En pseudocódigo, para escribir una alternativa múltiple se utiliza la
sintaxis:

-- 89 of 180 --

Libro de Algoritmos de “Abrirllave.com” 90 / 180
segun_sea ( <expresión> )
<lista_de_valores_1> : <bloque_de_instrucciones_1>
<lista_de_valores_2> : <bloque_de_instrucciones_2>
...
<lista_de_valores_n> : <bloque_de_instrucciones_n>
[ sino : <bloque_de_instrucciones_n+1> ]
fin_segun_sea
/* Según sea el valor de evaluar la <expresión>,
se ejecuta un <bloque_de_instrucciones> u otro. */
El resultado de evaluar la <expresión> debe ser un valor perteneciente a un tipo de dato
finito y ordenado, es decir, entero, lógico, carácter, enumerado o subrango.
Dependiendo del valor obtenido al evaluar la <expresión>, se ejecutará un bloque de
instrucciones u otro. En las listas de valores se deben escribir los valores que determinan el
bloque de instrucciones a ejecutar, teniendo en cuenta que, un valor solamente puede
aparecer en una lista de valores.
Opcionalmente, se puede escribir un <bloque_de_instrucciones_n+1> después de
sino :. Este bloque de instrucciones se ejecutará en el caso de que el valor obtenido al
evaluar la <expresión>, no se encuentre en ninguna de las listas de valores especificadas.
EJEMPLO Día de la semana.
Se quiere diseñar el algoritmo de un programa que:
1º) Pida por teclado el número (dato entero) de un día de la semana.
2º) Muestre por pantalla el nombre (dato cadena) correspondiente a dicho día.
Nota: Si el número de día introducido es menor que 1 ó mayor que 7, se mostrará el mensaje:
“ERROR: Día incorrecto.”.
En pantalla:

-- 90 of 180 --

Libro de Algoritmos de “Abrirllave.com” 91 / 180
Algoritmo propuesto:
algoritmo Dia_de_la_semana
variables
entero dia
inicio
escribir( "Introduzca día de la semana: " )
leer( dia )
segun_sea ( dia )
1 : escribir( "Lunes" )
2 : escribir( "Martes" )
3 : escribir( "Miércoles" )
4 : escribir( "Jueves" )
5 : escribir( "Viernes" )
6 : escribir( "Sábado" )
7 : escribir( "Domingo" )
sino : escribir( "ERROR: Día incorrecto." )
fin_segun_sea
fin
En un ordinograma, una instrucción alternativa múltiple se representa del siguiente modo:
Por tanto, el algoritmo del ejemplo “Día de la semana” se puede representar, de manera
gráfica, de la siguiente forma:

-- 91 of 180 --

Libro de Algoritmos de “Abrirllave.com” 92 / 180
Cuando en una lista de valores de una alternativa múltiple aparece más de un valor, estos se
escriben separados por el carácter coma (,). Estúdiese el siguiente ejemplo.
EJEMPLO Signo del zodíaco.
En la siguiente tabla se muestran las categorías a las que pertenecen los signos del zodíaco:

-- 92 of 180 --

Libro de Algoritmos de “Abrirllave.com” 93 / 180
Se quiere diseñar el algoritmo de un programa que:
1º) Muestre el listado de los signos del zodíaco, con sus números asociados.
2º) Pida por teclado un número (dato entero) asociado a un signo del zodíaco.
3º) Muestre la categoría a la que pertenece el signo del zodíaco seleccionado.
Nota: Si el número introducido por el usuario, no está asociado a ningún signo del zodíaco, se
mostrará el mensaje: “ERROR: <número> no está asociado a ningún signo.”.
En pantalla:

-- 93 of 180 --

Libro de Algoritmos de “Abrirllave.com” 94 / 180
Una posible solución es:
algoritmo Signo_del_zodiaco
variables
entero numero
inicio
escribir( "Listado de signos del zodíaco:" )
escribir( "1. Aries" )
escribir( "2. Tauro" )
escribir( "3. Géminis" )
escribir( "4. Cáncer" )
escribir( "5. Leo" )
escribir( "6. Virgo" )
escribir( "7. Libra" )
escribir( "8. Escorpio" )
escribir( "9. Sagitario" )
escribir( "10. Capricornio" )
escribir( "11. Acuario" )
escribir( "12. Piscis" )
escribir( "Introduzca número de signo: " )
leer( numero )
segun_sea ( numero )
1, 5, 9 : escribir( "Es un signo de Fuego." )
2, 6, 10 : escribir( "Es un signo de Tierra." )
3, 7, 11 : escribir( "Es un signo de Aire." )
4, 8, 12 : escribir( "Es un signo de Agua." )
sino : escribir( "ERROR: ", numero,
" no está asociado a ningún signo." )
fin_segun_sea
fin
Otra solución es:

-- 94 of 180 --

Libro de Algoritmos de “Abrirllave.com” 95 / 180
algoritmo Signo_del_zodiaco
variables
entero numero
cadena categoria
inicio
escribir( "Listado de signos del zodíaco:" )
escribir( "1. Aries" )
escribir( "2. Tauro" )
escribir( "3. Géminis" )
escribir( "4. Cáncer" )
escribir( "5. Leo" )
escribir( "6. Virgo" )
escribir( "7. Libra" )
escribir( "8. Escorpio" )
escribir( "9. Sagitario" )
escribir( "10. Capricornio" )
escribir( "11. Acuario" )
escribir( "12. Piscis" )
escribir( "Introduzca número de signo: " )
leer( numero )
segun_sea ( numero mod 4 )
1 : categoria  "Fuego"
2 : categoria  "Tierra"
3 : categoria  "Aire"
0 : categoria  "Agua"
fin_segun_sea
si ( numero >= 1 y numero <= 12 )
escribir( "Es un signo de ", categoria, "." )
sino
escribir( "ERROR: ", numero,
" no está asociado a ningún signo." )
fin_si
fin
En esta segunda solución existen las siguientes diferencias importantes con respecto a la
solución anterior:
 En el algoritmo se utiliza una alternativa doble, además de una alternativa múltiple.
 En la alternativa múltiple no se escribe el <bloque_de_instrucciones _n+1>.
 La expresión de la alternativa múltiple es diferente.
 La expresión "Es un signo de " solamente se escribe una vez.
 Se ha utilizado una variable más: categoria
Han vuelto a aparecer los símbolos reservados abrir paréntesis "(" y cerrar paréntesis ")", con
un significado distinto:
() Delimitan la expresión en una instrucción alternativa múltiple.

-- 95 of 180 --

Libro de Algoritmos de “Abrirllave.com” 96 / 180
Y los símbolos coma (,) y dos puntos (:):
, Separadora de los valores de una lista de valores de una instrucción
alternativa múltiple.
: Separador de una lista de valores y de un bloque de instrucciones, en una
instrucción alternativa múltiple.
También han aparecido dos nuevas palabras reservadas: segun_sea y fin_segun_sea.
Además de usarse de nuevo la palabra reservada sino.
Ejercicios resueltos
 Ejercicios de la instrucción alternativa múltiple
9.2. Anidamiento de alternativas
Las instrucciones alternativas y repetitivas pueden escribirse una dentro de otra. A este hecho
se le conoce como anidamiento.
En este apartado del tutorial se estudia el anidamiento de instrucciones alternativas, mientras
que, el anidamiento de instrucciones repetitivas se va a tratar en el apartado siguiente.
Las instrucciones alternativas permiten realizar las siguientes combinaciones de anidamiento:
 Doble en doble.
 Doble en simple.
 Doble en múltiple.
 Simple en simple.
 Simple en doble.
 Simple en múltiple.
 Múltiple en múltiple.
 Múltiple en doble.
 Múltiple en simple.
De ellas, vamos a estudiar, como ejemplo, las siguientes combinaciones:
 Doble en doble.
 Múltiple en doble.

-- 96 of 180 --

Libro de Algoritmos de “Abrirllave.com” 97 / 180
9.2.1. Alternativa doble en doble
En pseudocódigo, para anidar una alternativa doble en otra, se utiliza la sintaxis:
si ( <expresión_lógica_1> )
/* Inicio del anidamiento */
si ( <expresión_lógica_2> )
<bloque_de_instrucciones_1>
sino
<bloque_de_instrucciones_2>
fin_si
/* Fin del anidamiento */
sino
<bloque_de_instrucciones_3>
fin_si
O también:
si ( <expresión_lógica_1> )
<bloque_de_instrucciones_1>
sino
/* Inicio del anidamiento */
si ( <expresión_lógica_2> )
<bloque_de_instrucciones_2>
sino
<bloque_de_instrucciones_3>
fin_si
/* Fin del anidamiento */
fin_si
EJEMPLO Calificación según nota (Versión 3).
Se quiere diseñar el algoritmo de un programa que:
1º) Pida por teclado la nota (dato real) de una asignatura.
2º) Muestre por pantalla:
 “APTO”, en el caso de que la nota sea mayor o igual que 5 y menor o igual que 10.
 “NO APTO”, en el caso de que la nota sea mayor o igual que 0 y menor que 5.
 “ERROR: Nota incorrecta.”, en el caso de que la nota sea menor que 0 o mayor que 10.
En pantalla:

-- 97 of 180 --

Libro de Algoritmos de “Abrirllave.com” 98 / 180
Una solución al problema es:
algoritmo Calificacion_segun_nota
variables
real nota
inicio
escribir( "Introduzca nota (real): " )
leer( nota )
si ( nota >= 5 y nota <= 10 )
escribir( "APTO" )
sino
/* Inicio del anidamiento */
si ( nota >= 0 y nota < 5 )
escribir( "NO APTO" )
sino
escribir( "ERROR: Nota incorrecta." )
fin_si
/* Fin del anidamiento */
fin_si
fin
En ordinograma:

-- 98 of 180 --

Libro de Algoritmos de “Abrirllave.com” 99 / 180
Una segunda solución es:
algoritmo Calificacion_segun_nota
variables
real nota
inicio
escribir( "Introduzca nota (real): " )
leer( nota )
si ( nota < 0 o nota > 10 )
escribir( "ERROR: Nota incorrecta." )
sino
/* Inicio del anidamiento */
si ( nota < 5 )
escribir( "NO APTO" )
sino
escribir( "APTO" )
fin_si
/* Fin del anidamiento */
fin_si
fin

-- 99 of 180 --

Libro de Algoritmos de “Abrirllave.com” 100 / 180
Una tercera solución es:
algoritmo Calificacion_segun_nota
variables
real nota
inicio
escribir( "Introduzca nota (real): " )
leer( nota )
si ( nota >= 0 y nota <= 10 )
/* Inicio del anidamiento */
si ( nota >= 5 )
escribir( "APTO" )
sino
escribir( "NO APTO" )
fin_si
/* Fin del anidamiento */
sino
escribir( "ERROR: Nota incorrecta." )
fin_si
fin
Como se puede observar, el anidamiento de instrucciones alternativas permite ir descartando
valores hasta llegar al bloque de instrucciones que se debe ejecutar. Estúdiese ahora el
siguiente problema, el cual es un poco más complejo.
EJEMPLO Calificación según nota (Versión 4).
Se quiere diseñar el algoritmo de un programa que:
1º) Pida por teclado la nota (dato real) de una asignatura.
2º) Muestre por pantalla:
 “SOBRESALIENTE”, en el caso de que la nota sea mayor o igual que 9 y menor o igual
que 10.
 “NOTABLE”, en el caso de que la nota sea mayor o igual que 7 y menor que 9.
 “BIEN”, en el caso de que la nota sea mayor o igual que 6 y menor que 7.
 “SUFICIENTE”, en el caso de que la nota sea mayor o igual que 5 y menor que 6.
 “INSUFICIENTE”, en el caso de que la nota sea mayor o igual que 3 y menor que 5.
 “MUY DEFICIENTE”, en el caso de que la nota sea mayor o igual que 0 y menor que 3.
 “ERROR: Nota incorrecta.”, en el caso de que la nota sea menor que 0 o mayor que 10.
En pantalla:

-- 100 of 180 --

Libro de Algoritmos de “Abrirllave.com” 101 / 180
La solución propuesta tiene más de un nivel de anidamiento:
algoritmo Calificacion_segun_nota
variables
real nota
inicio
escribir( "Introduzca nota (real): " )
leer( nota )
si ( nota < 0 o nota > 10 )
escribir( "ERROR: Nota incorrecta." )
sino
si ( nota >= 9 )
escribir( "SOBRESALIENTE" )
sino
si ( nota >= 7 )
escribir( "NOTABLE" )
sino
si ( nota >= 6 )
escribir( "BIEN" )
sino
si ( nota >= 5 )
escribir( "SUFICIENTE" )
sino
si ( nota >= 3 )
escribir( "INSUFICIENTE" )
sino
escribir( "MUY DEFICIENTE" )
fin_si
fin_si
fin_si
fin_si
fin_si
fin_si
fin

-- 101 of 180 --

Libro de Algoritmos de “Abrirllave.com” 102 / 180
9.2.2. Alternativa múltiple en doble
En pseudocódigo, para anidar una alternativa múltiple en una alternativa doble, se utiliza la
sintaxis:
si ( <expresión_lógica> )
/* Inicio del anidamiento */
segun_sea ( <expresión> )
<lista_de_valores_1> : <bloque_de_instrucciones_1>
<lista_de_valores_2> : <bloque_de_instrucciones_2>
...
<lista_de_valores_n> : <bloque_de_instrucciones_n>
[ sino : <bloque_de_instrucciones_n+1> ]
fin_segun_sea
/* Fin del anidamiento */
sino
<bloque_de_instrucciones_n+2>
fin_si
Así por ejemplo, el problema del “Día de la semana” visto anteriormente, también se puede
resolver anidando una alternativa múltiple en una alternativa doble.
EJEMPLO Día de la semana.
Se quiere diseñar el algoritmo de un programa que:
1º) Pida por teclado el número (dato entero) de un día de la semana.
2º) Muestre por pantalla el nombre (dato cadena) correspondiente a dicho día.
Nota: Si el número de día introducido es menor que 1 ó mayor que 7, se mostrará el mensaje:
“ERROR: Día incorrecto.”.
En pantalla:

-- 102 of 180 --

Libro de Algoritmos de “Abrirllave.com” 103 / 180
La solución algorítmica podría ser:
algoritmo Dia_de_la_semana
variables
entero dia
inicio
escribir( "Introduzca día de la semana: " )
leer( dia )
si ( dia >= 1 y dia <= 7 )
/* Solamente si el día es válido, se ejecuta la
instrucción alternativa múltiple. */
/* Inicio del anidamiento */
segun_sea ( dia )
1 : escribir( "Lunes" )
2 : escribir( "Martes" )
3 : escribir( "Miércoles" )
4 : escribir( "Jueves" )
5 : escribir( "Viernes" )
6 : escribir( "Sábado" )
7 : escribir( "Domingo" )
fin_segun_sea
/* Fin del anidamiento */
sino
escribir ( "ERROR: Día incorrecto." )
fin_si
fin
En este algoritmo, se ha comprobado –en primer lugar– el valor del día y, solamente se
ejecutará la alternativa múltiple, si el valor introducido es mayor o igual que 1 y menor o igual
que 7.
9.3. Distintas soluciones para un problema
En programación, para solucionar un problema, se pueden diseñar algoritmos distintos, o
dicho de otro modo, no existe una única solución para resolver un problema dado. Pero, a
veces, unas soluciones son mejores –más óptimas– que otras.
Cuando se dice que un algoritmo es mejor –más óptimo– que otro, teniendo ambos la misma
funcionalidad, esto puede ser debido a distintas razones. Entre ellas, de momento, vamos a
destacar dos:
 El código es más reducido (se ejecutan menos instrucciones).
 Utiliza menos variables (menos memoria).

-- 103 of 180 --

Libro de Algoritmos de “Abrirllave.com” 104 / 180
EJEMPLO Calificación según nota (Versión 5).
Se quiere diseñar el algoritmo de un programa que:
1º) Pida por teclado la nota (dato entero) de una asignatura.
2º) Muestre por pantalla:
 “SOBRESALIENTE”, en el caso de que la nota sea un 9 ó un 10.
 “NOTABLE”, en el caso de que la nota sea un 7 ó un 8.
 “BIEN”, en el caso de que la nota sea un 6.
 “SUFICIENTE”, en el caso de que la nota sea un 5.
 “INSUFICIENTE”, en el caso de que la nota sea un 3 ó un 4.
 “MUY DEFICIENTE”, en el caso de que la nota sea un 0, un 1, ó un 2.
 “ERROR: Nota incorrecta.”, en el caso de que la nota sea menor que 0 o mayor que 10.
En pantalla:
Para resolver este problema, se puede recurrir al anidamiento de alternativas dobles:

-- 104 of 180 --

Libro de Algoritmos de “Abrirllave.com” 105 / 180
algoritmo Calificacion_segun_nota
variables
real nota
inicio
escribir( "Introduzca nota (entera): " )
leer( nota )
si ( nota >= 0 y nota <= 10 )
si ( nota >= 9 )
escribir( "SOBRESALIENTE" )
sino
si ( nota >= 7 )
escribir( "NOTABLE" )
sino
si ( nota = 6 )
escribir( "BIEN" )
sino
si ( nota = 5 )
escribir( "SUFICIENTE" )
sino
si ( nota >= 3 )
escribir( "INSUFICIENTE" )
sino
escribir( "MUY DEFICIENTE" )
fin_si
fin_si
fin_si
fin_si
fin_si
sino
escribir( "ERROR: Nota incorrecta." )
fin_si
fin
Otra posibilidad, para resolver este problema, es utilizar una alternativa múltiple anidada en
una alternativa doble:

-- 105 of 180 --

Libro de Algoritmos de “Abrirllave.com” 106 / 180
algoritmo Calificacion_segun_nota
variables
real nota
inicio
escribir( "Introduzca nota (entera): " )
leer( nota )
si ( nota >= 0 y nota <= 10 )
segun_sea ( nota )
10, 9 : escribir( "SOBRESALIENTE" )
8, 7 : escribir( "NOTABLE" )
6 : escribir( "BIEN" )
5 : escribir( "SUFICIENTE" )
4, 3 : escribir( "INSUFICIENTE" )
2, 1, 0 : escribir( "MUY DEFICIENTE" )
fin_segun_sea
sino
escribir( "ERROR: Nota incorrecta." )
fin_si
fin
Obsérvese que, a primera vista, el algoritmo de la segunda solución es más fácil de leer que el
de la primera solución.
Podría pensarse, erróneamente, que el problema del ejemplo “Calificación según nota (Versión
4)” visto en el apartado “9.2. Anidamiento de alternativas” también se puede resolver con una
alternativa múltiple, pero no es así, ya que, la nota que se pide por teclado en ese problema,
es un dato de tipo real y, como ya se ha estudiado, en una alternativa múltiple, el valor de la
expresión que se evalúe debe pertenecer a un tipo de dato finito y ordenado.
9.4. Variable interruptor
Una variable interruptor es un tipo de variable que se utiliza con frecuencia en programación.
Un interruptor es una variable que solamente puede tomar por valor dos valores opuestos.
Por norma general, estos valores son: verdadero y falso. También es frecuente utilizar los
valores: 0 y 1.
Normalmente, una variable interruptor tomará un valor u otro dependiendo de ciertas
circunstancias ocurridas en el algoritmo y, después, según sea su valor, se ejecutarán unas
instrucciones u otras.

-- 106 of 180 --

Libro de Algoritmos de “Abrirllave.com” 107 / 180
EJEMPLO Validar fecha.
Se quiere diseñar el algoritmo de un programa que:
1º) Pida por teclado una fecha en tres variables: día, mes y año (datos enteros).
2º) Muestre por pantalla:
 “FECHA CORRECTA”, en el caso de que la fecha sea válida.
 “FECHA INCORRECTA”, en el caso de que la fecha no sea válida.
Nota1: Para que una fecha sea válida, se tiene que cumplir que:
 El mes debe ser mayor o igual que 1 y menor o igual que 12.
 El día debe ser mayor o igual que 1 y menor o igual que un número, el cual dependerá
del mes y año introducidos por el usuario.
Nota2: Hay que tener en cuenta que:
 Tienen 31 días: enero, marzo, mayo, julio, agosto, octubre y diciembre.
 Tienen 30 días: abril, junio, septiembre y noviembre.
 Tiene 29 días: febrero (si el año es bisiesto).
 Tiene 28 días: febrero (si el año no es bisiesto).
Nota3: Son bisiestos todos los años múltiplos de 4, excepto aquellos que son múltiplos de 100
pero no de 400.
En pantalla:

-- 107 of 180 --

Libro de Algoritmos de “Abrirllave.com” 108 / 180
Una posible solución es:
algoritmo Validar_fecha
variables
entero dia, mes, anio
inicio
escribir( "Introduzca dia: " )
leer( dia )
escribir( "Introduzca mes: " )
leer( mes )
escribir( "Introduzca año: " )
leer( anio )
si ( mes >= 1 y mes <= 12 )
segun_sea ( mes )
1, 3, 5, 7,
8, 10, 12 : si ( dia >= 1 y dia <= 31 )
escribir( "FECHA CORRECTA" )
sino
escribir( "FECHA INCORRECTA" )
fin_si
4, 6, 9, 11 : si ( dia >= 1 y dia <= 30 )
escribir( "FECHA CORRECTA" )
sino
escribir( "FECHA INCORRECTA" )
fin_si
2 : si ( anio mod 4 = 0 y
anio mod 100 <> 0 o
anio mod 400 = 0 )
si ( dia >= 1 y dia <= 29 )
escribir( "FECHA CORRECTA" )
sino
escribir( "FECHA INCORRECTA" )
fin_si
sino
si( dia >= 1 y dia <= 28 )
escribir( "FECHA CORRECTA" )
sino
escribir( "FECHA INCORRECTA" )
fin_si
fin_si
fin_segun_sea
sino
escribir( "FECHA INCORRECTA" )
fin_si
fin
A continuación, se muestra una segunda solución, en la cual, se hace uso de una variable
interruptor:

-- 108 of 180 --

Libro de Algoritmos de “Abrirllave.com” 109 / 180
algoritmo Validar_fecha
variables
entero dia, mes, anio
logico fecha_correcta /* Interruptor */
inicio
escribir( "Introduzca dia: " )
leer( dia )
escribir( "Introduzca mes: " )
leer( mes )
escribir( "Introduzca año: " )
leer( anio )
fecha_correcta  falso
si ( mes >= 1 y mes <= 12 )
segun_sea ( mes )
1, 3, 5, 7,
8, 10, 12 : si ( dia >= 1 y dia <= 31 )
fecha_correcta  verdadero
fin_si
4, 6, 9, 11 : si ( dia >= 1 y dia <= 30 )
fecha_correcta  verdadero
fin_si
2 : si ( anio mod 4 = 0 y
anio mod 100 <> 0 o
anio mod 400 = 0 )
si ( dia >= 1 y dia <= 29 )
fecha_correcta  verdadero
fin_si
sino
si ( dia >= 1 y dia <= 28 )
fecha_correcta  verdadero
fin_si
fin_si
fin_segun_sea
fin_si
/* Llegados a este punto, según el valor de fecha_correcta,
por pantalla se mostrará un mensaje u otro. */
si ( fecha_correcta )
escribir( "FECHA CORRECTA" )
sino
escribir( "FECHA INCORRECTA" )
fin_si
fin
En el algoritmo, la variable interruptor fecha_correcta toma el valor verdadero o
falso, dependiendo de que la fecha sea válida o no. Y después, según sea su valor, se
ejecutará la instrucción:

-- 109 of 180 --

Libro de Algoritmos de “Abrirllave.com” 110 / 180
escribir( "FECHA CORRECTA" )
O la instrucción:
escribir( "FECHA INCORRECTA" )
A los interruptores también se les denomina: banderas, centinelas o conmutadores.
Por último, se propone una tercera solución:
algoritmo Validar_fecha
variables
entero dia_maximo, dia, mes, anio
logico fecha_correcta /* Interruptor */
inicio
escribir( "Introduzca dia: " )
leer( dia )
escribir( "Introduzca mes: " )
leer( mes )
escribir( "Introduzca año: " )
leer( anio )
fecha_correcta  falso
si ( mes >= 1 y mes <= 12 )
segun_sea ( mes )
1, 3, 5, 7, 8, 10, 12 : dia_maximo  31
4, 6, 9, 11 : dia_maximo  30
2 : si ( anio mod 4 = 0 y
anio mod 100 <> 0 o
anio mod 400 = 0 )
dia_maximo  29
sino
dia_maximo  28
fin_si
fin_segun_sea
si ( dia >= 1 y dia <= dia_maximo )
fecha_correcta  verdadero
fin_si
fin_si
si ( fecha_correcta )
escribir( "FECHA CORRECTA" )
sino
escribir( "FECHA INCORRECTA" )
fin_si
fin
Ejercicios resueltos
 Ejercicios de instrucciones alternativas

-- 110 of 180 --

Libro de Algoritmos de “Abrirllave.com” 111 / 180