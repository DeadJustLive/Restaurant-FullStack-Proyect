# 2. Se ejecuta el bloque de instrucciones y, a continuación, si la condición se evalúa a

verdadera, el bloque de instrucciones se vuelve a ejecutar. Y así sucesivamente, hasta
que la condición sea falsa.
El <bloque_de_instrucciones> de un bucle hacer...mientras puede ejecutarse
una o más veces (iteraciones). También hay que prevenir que el bucle no sea infinito.
En resumen, una instrucción repetitiva hacer...mientras permite ejecutar
repetidamente (una o más veces) un bloque de instrucciones, mientras que, una determinada
condición sea verdadera.
EJEMPLO Para mostrar por pantalla los primeros diez números naturales (del 1 al 10),
utilizando un bucle hacer...mientras se puede escribir el siguiente código:
algoritmo Numeros_del_1_al_10
variables
entero contador
inicio
contador  1 /* Inicialización del contador */
hacer
escribir( contador ) /* Salida */
contador  contador + 1 /* Incremento */
mientras( contador <= 10 ) /* Condición */
fin

-- 123 of 180 --

Libro de Algoritmos de “Abrirllave.com” 124 / 180
La traza de este algoritmo es:
Explicación de la traza:
 En primer lugar, se le asigna el valor 1 a contador (acción 1).
 A continuación, se ejecuta el bloque de instrucciones del bucle hacer...
mientras, mostrándose por pantalla el valor de contador (acción 2) y, después, se
incrementa en 1 el valor de la variable contador (acción 3).

-- 124 of 180 --

Libro de Algoritmos de “Abrirllave.com” 125 / 180
 Una vez ejecutado el bloque de instrucciones, se evalúa la condición de salida del
bucle ( contador <= 10 ) (acción 4) y, puesto que, es verdadera, se ejecuta –de
nuevo– el bloque de instrucciones.
 Y así sucesivamente, mientras que, la condición sea verdadera, o dicho de otro modo,
hasta que, la condición sea falsa.
 En este algoritmo, el bloque de instrucciones del bucle se ejecuta diez veces
(iteraciones).
EJEMPLO Primeros diez números naturales (del 10 al 1).
Utilizando un bucle hacer...mientras, se quiere diseñar el algoritmo de un programa
que muestre por pantalla los primeros diez números naturales, pero a la inversa, es decir, del
10 al 1:
Para ello, se propone el siguiente algoritmo, muy similar al anterior, pero con unos ligeros
cambios:
algoritmo Numeros_del_10_al_1
variables
entero contador
inicio
contador  10 /* Cambio 1 */
hacer
escribir( contador )
contador  contador - 1 /* Cambio 2 */
mientras( contador >= 1 ) /* Cambio 3 */
fin
Para que el algoritmo realice la nueva tarea, ha sido necesario realizar tres cambios en los
aspectos más críticos del bucle hacer...mientras:
 La inicialización de la variable contador (cambio 1): necesaria para que, en la
primera iteración, el bloque de instrucciones del bucle pueda ejecutarse
correctamente, tanto la instrucción de salida como la de asignación.
 La instrucción de asignación (cambio 2): hace variar el valor de la variable contador
dentro del bloque de instrucciones. De no hacerse correctamente, el bucle podría ser
infinito.
 La condición del bucle hacer...mientras (cambio 3): afecta al número de
iteraciones que va a efectuar el bucle. También se le conoce como condición de salida
del bucle.

-- 125 of 180 --

Libro de Algoritmos de “Abrirllave.com” 126 / 180
Al igual que ocurre con la instrucción repetitiva mientras, cualquier pequeño descuido o
error al escribir el código del algoritmo, puede dar lugar a que la instrucción repetitiva
hacer...mientras no funcione correctamente.
En un ordinograma, una instrucción repetitiva hacer...mientras se representa de la
siguiente manera:
Así, por ejemplo, el algoritmo Numeros_del_1_al_10 se puede representar, de manera
gráfica, como se muestra a continuación:

-- 126 of 180 --

Libro de Algoritmos de “Abrirllave.com” 127 / 180
Como ya se ha dicho, el bucle hacer...mientras puede iterar una o más veces. Por tanto,
cuando un bloque de instrucciones debe iterar al menos una vez, generalmente, es mejor
utilizar un bucle hacer...mientras que un bucle mientras, como por ejemplo, en el
siguiente problema.
EJEMPLO Suma de números introducidos por el usuario.
Se quiere diseñar el algoritmo de un programa que:
1º) Pida por teclado un número (dato entero).
2º) Pregunte al usuario si desea introducir otro o no.
3º) Repita los pasos 1º y 2º, mientras que, el usuario no responda 'n' de (no).
4º) Muestre por pantalla la suma de los números introducidos por el usuario.
En pantalla:
Solución:

-- 127 of 180 --

Libro de Algoritmos de “Abrirllave.com” 128 / 180
algoritmo Suma_de_numeros_introducidos_por_el_usuario
variables
caracter seguir
entero acumulador, numero
inicio
/* En acumulador se va a guardar la suma
de los números introducidos por el usuario. */
acumulador  0
hacer
escribir( "Introduzca un número entero: " )
leer( numero )
acumulador  acumulador + numero
escribir( "¿Desea introducir otro número (s/n)?: " )
leer( seguir )
mientras( seguir <> 'n' )
/* Mientras que el usuario desee introducir más números,
el bucle iterará. */
escribir( "La suma de los números introducidos es: ",
acumulador )
fin
En la solución propuesta, cuando el programa pregunta al usuario si desea introducir otro
número, el bucle iterará, mientras que, seguir sea distinto de 'n'. De manera que, cualquier
otro carácter que no sea 'n' provocará que el bucle itere de nuevo. En pantalla:
10.3.1. Variable acumulador
En el algoritmo anterior se ha utilizado un acumulador. En programación, se llama acumulador
a una variable cuyo valor se incrementa o decrementa en un valor que no tiene por qué ser fijo
(en cada iteración de un bucle).

-- 128 of 180 --

Libro de Algoritmos de “Abrirllave.com” 129 / 180
Un acumulador suele utilizarse para acumular resultados producidos en las iteraciones de un
bucle.
10.3.2. Diferencias entre un bucle mientras
y hacer...mientras
Para saber cuándo hacer uso de un bucle u otro, es muy importante conocer bien las
diferencias más significativas existentes entre ambos bucles.
Ha aparecido una nueva palabra reservada: hacer.
Han vuelto a aparecer los símbolos reservados abrir paréntesis “(” y cerrar paréntesis “)”, con
un significado distinto.
() Delimitan la condición en una instrucción repetitiva hacer...mientras.
Ejercicios resueltos
 Ejercicios de la instrucción repetitiva hacer...mientras
10.4. Repetitiva para
En pseudocódigo, para escribir una instrucción repetitiva para se utiliza la sintaxis:
para <variable>  <valor_inicial> hasta <valor_final>
[ incremento <valor_incremento> ] hacer
<bloque_de_instrucciones>
fin_para
/* A la <variable> se le asigna el <valor_inicial> y,
se le suma, sucesivamente, el <valor_incremento>,
hasta superar el <valor_final>. */
/* Por omisión, el <valor_incremento> es 1. */

-- 129 of 180 --

Libro de Algoritmos de “Abrirllave.com” 130 / 180
En una instrucción repetitiva para, siempre se utiliza una <variable> a la que se debe
asignar un <valor_inicial>. En cada iteración del bucle, al valor de la <variable> se
le suma el <valor_incremento> y, cuando la <variable> supera el <valor_
final>, el bucle finaliza.
En consecuencia, cuando el flujo de un algoritmo llega a un bucle para, en primer lugar, se
asigna el <valor_inicial> a la <variable> y, a partir de ese instante, existen dos
posibilidades: