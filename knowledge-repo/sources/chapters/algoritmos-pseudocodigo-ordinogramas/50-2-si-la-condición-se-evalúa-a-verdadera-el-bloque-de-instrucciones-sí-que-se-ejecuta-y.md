# 2. Si la condición se evalúa a verdadera, el bloque de instrucciones sí que se ejecuta y,

después, se vuelve a evaluar la condición, para decidir –de nuevo– si el bloque de
instrucciones se vuelve a ejecutar o no. Y así sucesivamente, hasta que, la condición
sea falsa.
Cuando el bloque de instrucciones de un bucle se ejecuta, se dice que se ha producido una
iteración.
El <bloque_de_instrucciones> de un bucle mientras puede ejecutarse cero o más
veces (iteraciones). Si el <bloque_de_instrucciones> se ejecuta al menos una vez,
seguirá ejecutándose repetidamente, mientras que, la condición sea verdadera. Pero, hay que
tener cuidado de que el bucle no sea infinito.
Cuando la condición de un bucle mientras se evalúa siempre a verdadera, se dice que se ha
producido un bucle infinito, ya que, el algoritmo nunca termina. Un bucle infinito es un error
lógico.
Es importante hacer hincapié en el hecho de que, en un bucle mientras, primero se evalúa
la condición y, en el caso de que ésta sea verdadera, entonces se ejecuta el bloque de
instrucciones. Veremos que, en el bucle hacer...mientras, el procedimiento es al revés.
En él, primero se ejecuta el bloque de instrucciones y, después, se evalúa la condición.
Para que un bucle mientras no sea infinito, en el bloque de instrucciones debe ocurrir algo
para que la condición deje de ser verdadera. En la mayoría de los casos, la condición se hace
falsa al cambiar el valor de una variable.
En resumen, una instrucción repetitiva mientras permite ejecutar, repetidamente, (cero o
más veces) un bloque de instrucciones, mientras que, una determinada condición sea
verdadera.
EJEMPLO Para mostrar por pantalla los primeros diez números naturales:
Utilizando un bucle mientras, se puede escribir el siguiente algoritmo:

-- 114 of 180 --

Libro de Algoritmos de “Abrirllave.com” 115 / 180
algoritmo Numeros_del_1_al_10
variables
entero contador
inicio
contador  1 /* Inicialización del contador */
mientras ( contador <= 10 ) /* Condición */
escribir( contador ) /* Salida */
contador  contador + 1 /* Incremento */
fin_mientras
fin
El código de este algoritmo es mucho más reducido –más óptimo– que los de los ejemplos del
apartado anterior “10.1. Instrucciones repetitivas”. Para comprender su funcionamiento, se va
a estudiar su traza.
La traza de un algoritmo indica la secuencia de acciones (instrucciones) de su ejecución, así
como, el valor de las variables del algoritmo después de cada acción (instrucción).
La traza de este algoritmo es:

-- 115 of 180 --

Libro de Algoritmos de “Abrirllave.com” 116 / 180
Explicación de la traza:
 Primeramente, se le asigna el valor 1 a contador (acción 1).
 En segundo lugar, se evalúa la condición ( contador <= 10 ) (acción 2) y, puesto
que es verdadera, se ejecuta el bloque de instrucciones del bucle mientras.
 Así que, por pantalla se muestra el valor de contador (acción 3) y, después, se
incrementa en 1 el valor de la variable contador (acción 4).
 Una vez terminada la ejecución del bloque de instrucciones, se vuelve a evaluar la
condición ( contador <= 10 ) (acción 5) y, puesto que es verdadera, se ejecuta de
nuevo el bloque de instrucciones.
 Y así sucesivamente, mientras que, la condición sea verdadera, o dicho de otro modo,
hasta que, la condición sea falsa.
 En este algoritmo, el bloque de instrucciones del bucle mientras se ejecuta diez
veces (iteraciones).
10.2.1. Variable contador
En el algoritmo anterior se ha utilizado un contador. En programación, se llama contador a una
variable cuyo valor se incrementa o decrementa en un valor fijo (en cada iteración de un
bucle).
Un contador suele utilizarse para contar el número de veces que itera un bucle. Pero, a veces,
se utiliza para contar, solamente, aquellas iteraciones de un bucle en las que se cumpla una
determinada condición.
Además, en este caso, el valor de la variable contador se ha visualizado en cada iteración.
EJEMPLO Primeros diez números naturales (del 10 al 1).
Se quiere diseñar el algoritmo de un programa que muestre por pantalla los primeros diez
números naturales, pero a la inversa, es decir, del 10 al 1:

-- 116 of 180 --

Libro de Algoritmos de “Abrirllave.com” 117 / 180
El algoritmo propuesto es muy similar al anterior, pero, con unos ligeros cambios:
algoritmo Numeros_del_10_al_1
variables
entero contador
inicio
contador  10 /* Cambio 1 */
mientras ( contador >= 1 ) /* Cambio 2 */
escribir( contador )
contador  contador – 1 /* Cambio 3 */
fin_mientras
fin
Para que el algoritmo realice la nueva tarea encomendada, ha sido necesario realizar tres
cambios en los aspectos más críticos del bucle mientras:
 La inicialización de la variable contador (cambio 1): necesaria para que la condición
pueda evaluarse correctamente cuando el flujo del algoritmo llega al bucle
mientras.
 La condición del bucle mientras (cambio 2): afecta al número de iteraciones que va
a efectuar el bucle. También se le conoce como condición de salida del bucle.
 La instrucción de asignación (cambio 3): hace variar el valor de la variable contador
dentro del bloque de instrucciones. De no hacerse correctamente, el bucle podría ser
infinito.
EJEMPLO Un pequeño descuido, como por ejemplo, no escribir de forma correcta la
condición del bucle, puede producir un bucle infinito:
algoritmo Numeros_del_10_al_1
variables
entero contador
inicio
contador  10 /* Cambio 1 */
mientras ( contador <= 10 ) /* Descuido */
escribir( contador )
contador  contador – 1 /* Cambio 3 */
fin_mientras
fin

-- 117 of 180 --

Libro de Algoritmos de “Abrirllave.com” 118 / 180
Por pantalla se mostrará:
El bucle es infinito. Para que el algoritmo funcionase correctamente, la condición debería ser
contador >= 1
EJEMPLO Otro error muy frecuente es inicializar mal la variable que participa en la condición
del bucle:
algoritmo Numeros_del_10_al_1
variables
entero contador
inicio
contador  1 /* Descuido */
mientras ( contador >= 1 ) /* Cambio 2 */
escribir( contador )
contador  contador – 1 /* Cambio 3 */
fin_mientras
fin
Por pantalla únicamente se mostrará el número 1:
En este caso, la variable contador ha sido mal inicializada, y el bucle solamente se ejecuta
una vez, ya que, contador debería haberse inicializado al valor 10.
EJEMPLO También es un error muy típico olvidarse de escribir alguna instrucción, como por
ejemplo, la instrucción de asignación ( contador  contador – 1 ) del bloque de
instrucciones del bucle:

-- 118 of 180 --

Libro de Algoritmos de “Abrirllave.com” 119 / 180
algoritmo Numeros_del_10_al_1
variables
entero contador
inicio
contador  10 /* Cambio 1 */
mientras ( contador >= 1 ) /* Cambio 2 */
escribir( contador )
/* Descuido */
fin_mientras
fin
De nuevo, por pantalla, se obtiene la salida de un bucle infinito. En este caso:
EJEMPLO Como ya se ha dicho, un bucle mientras puede iterar cero o más veces. Así, por
ejemplo, en el algoritmo siguiente existe un error lógico que provoca que el bucle no itere
ninguna vez:
algoritmo Numeros_del_10_al_1
variables
entero contador
inicio
contador  0 /* Descuido */
mientras ( contador >= 1 ) /* Cambio 2 */
escribir( contador )
contador  contador – 1 /* Cambio 3 */
fin_mientras
fin
Por pantalla no se mostrará nada:
En este caso, se ha producido un error lógico, ya que, para que el bucle iterase diez veces, se
debería haber asignado a la variable contador el valor 10, en vez del 0.

-- 119 of 180 --

Libro de Algoritmos de “Abrirllave.com” 120 / 180
No obstante, bajo determinadas circunstancias, sí puede tener sentido hacer uso de un bucle
mientras, el cual pueda no iterar ninguna vez. Por ejemplo, en el siguiente problema.
EJEMPLO Calificación según nota.
Se quiere diseñar el algoritmo de un programa que:
1º) Pida por teclado la nota (dato real) de una asignatura.
2º) En el caso de que la nota sea incorrecta, muestre por pantalla el mensaje:
 “ERROR: Nota incorrecta, debe ser >= 0 y <= 10”.
3º) Repita los pasos 1º y 2º, mientras que, la nota introducida sea incorrecta.
4º) Muestre por pantalla:
 “APROBADO”, en el caso de que la nota sea mayor o igual que 5.
 “SUSPENDIDO”, en el caso de que la nota sea menor que 5.
En pantalla:
El algoritmo propuesto es:

-- 120 of 180 --

Libro de Algoritmos de “Abrirllave.com” 121 / 180
algoritmo Calificacion_segun_nota
variables
real nota
inicio
escribir( "Introduzca nota (real): " )
leer( nota )
/* Si la primera nota introducida por el usuario
es correcta, el bucle no itera ninguna vez. */
mientras ( nota < 0 o nota > 10 )
escribir( "ERROR: Nota incorrecta, debe ser >= 0 y <= 10" )
escribir( "Introduzca nota (real): " )
leer( nota )
fin_mientras
/* Mientras que el usuario introduzca una nota
incorrecta, el bucle iterará. Y cuando introduzca
una nota correcta, el bucle finalizará. */
si ( nota >= 5 )
escribir( "APROBADO" )
sino
escribir( "SUSPENDIDO" )
fin_si
fin
En el algoritmo, el bucle mientras se ha usado para validar la nota introducida por el
usuario. En programación, es muy frecuente usar el bucle mientras para validar (filtrar)
datos. Al bucle que se utiliza para validar uno o más datos, también se le conoce como filtro.
Han aparecido dos nuevas palabras reservadas: mientras y fin_mientras. Además, han
vuelto a aparecer los símbolos reservados abrir paréntesis “(” y cerrar paréntesis “)”, con un
significado distinto.
() Delimitan la condición en una instrucción repetitiva mientras.
En un ordinograma, una instrucción repetitiva mientras se representa de la siguiente
manera:

-- 121 of 180 --

Libro de Algoritmos de “Abrirllave.com” 122 / 180
De forma que, por ejemplo, el algoritmo Numeros_del_1_al_10 se puede representar,
gráficamente, como se muestra a continuación:
Ejercicios resueltos
 Ejercicios de la instrucción repetitiva mientras

-- 122 of 180 --

Libro de Algoritmos de “Abrirllave.com” 123 / 180
10.3. Repetitiva hacer...mientras
En pseudocódigo, para escribir una instrucción repetitiva hacer...mientras se utiliza la
sintaxis:
hacer
<bloque_de_instrucciones>
mientras( <expresión_lógica> )
/* Ejecutar el <bloque_de_instrucciones> mientras que
la <expresión_lógica> sea verdadera. */
Como se puede apreciar, la instrucción repetitiva hacer...mientras, también hace uso
de una condición.
En un bucle hacer...mientras, primero se ejecuta el bloque de instrucciones y, después,
se evalúa la condición. En el caso de que esta sea verdadera, se vuelve a ejecutar el bloque de
instrucciones. Y así sucesivamente, hasta que, la condición sea falsa.
Por consiguiente, cuando el flujo de un algoritmo llega a un bucle hacer...mientras,
existen dos posibilidades: