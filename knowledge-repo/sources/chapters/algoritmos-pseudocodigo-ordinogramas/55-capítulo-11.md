# Capítulo 11

Instrucciones de control de salto
Las instrucciones de control de salto (en especial la instrucción ir_a) son un lastre de los
orígenes de la programación. De hecho, en programación estructurada, todos los programas se
pueden escribir utilizando tres tipos de estructuras de control:
 Secuencial.
 De selección (alternativas).
 De iteración (repetitivas).
Así pues, todos los programas que utilizan instrucciones de salto, pueden ser reescritos sin
hacer uso de ellas y, aunque muchos lenguajes de programación permiten codificar las
instrucciones de salto, el hacer uso de ellas se considera una práctica de programación pobre y
nefasta; tal es así, que, ni siquiera las vamos a representar mediante ordinogramas en este
tutorial.
Resumiendo, en este capítulo se van a estudiar las instrucciones de control de salto, las
ventajas de no hacer uso de ellas y cómo se pueden reescribir los algoritmos que las usan.
11.1. Instrucciones de salto
Las instrucciones de control de salto permiten realizar saltos en el flujo de control de un
programa, es decir, permiten transferir el control del programa, alterando bruscamente el flujo
de control del mismo. Existen cuatro tipos de instrucciones de salto:
 interrumpir (romper, salir, terminar...)
 continuar
 ir_a
 volver
Cuando en un programa se utiliza una instrucción de salto, la secuencia normal de su ejecución
se rompe, transfiriéndose el control del programa a otro lugar dentro del mismo.

-- 148 of 180 --

Libro de Algoritmos de “Abrirllave.com” 149 / 180
11.2. interrumpir
En pseudocódigo, para escribir una instrucción de salto interrumpir se utiliza la sintaxis:
interrumpir
En pseudocódigo, la instrucción de salto interrumpir siempre se usa para interrumpir
(romper) la ejecución normal de un bucle, es decir, la instrucción interrumpir finaliza
(termina) la ejecución de un bucle y, por tanto, el control del programa se transfiere (salta) a la
primera instrucción después del bucle.
EJEMPLO Estúdiese el siguiente algoritmo:
algoritmo Numeros_opuestos_del_menos_10_al_mas_10
variables
entero n, a
inicio
a  0
hacer
escribir( "Introduzca un número entero: " )
leer( n )
si ( n = 0 )
escribir( "ERROR: El cero no tiene opuesto." )
interrumpir
/* En el caso de que n sea un cero,
el bucle se interrumpe. */
fin_si
escribir( "El opuesto es: ", -n )
a  a + n
mientras ( n >= -10 y n <= 10 )
escribir( "Suma: ", a )
fin
El algoritmo puede ser la solución del problema siguiente:
EJEMPLO Números opuestos (del -10 al 10) (Versión 1).
Diseñe el algoritmo de un programa que:
1º) Pida por teclado un número (dato entero).
2º) Si el número introducido por el usuario es distinto de cero, muestre por pantalla el
mensaje:
 “El opuesto es: <-número>”.
3º) Repita los pasos 1º y 2º, mientras que, el usuario introduzca un número mayor o igual que
-10 y menor o igual que 10.

-- 149 of 180 --

Libro de Algoritmos de “Abrirllave.com” 150 / 180
Pero, si el usuario introduce un cero, el bucle también finaliza, mostrándose por pantalla el
mensaje:
 “ERROR: El cero no tiene opuesto.”.
4º) Muestre por pantalla la suma de los números introducidos por el usuario.
En pantalla:
En este caso, el bucle ha finalizado porque la condición ( n >= -10 y n <= 10 ) es falsa,
ya que, 15 no es mayor o igual que -10 y menor o igual que 10.
Sin embargo, el bucle también puede finalizar, no porque sea falsa la condición ( n >= -10
y n <= 10 ), sino, porque se ejecute la instrucción interrumpir. Esto ocurrirá cuando el
usuario introduzca un cero. Por ejemplo:
Normalmente, cuando en un bucle se utiliza una instrucción interrumpir, la ejecución de
esta se condiciona.
En el ejemplo, el bucle se interrumpe si la condición ( n = 0 ) es verdadera. Nótese que,
dicha condición no está contemplada en la condición de salida estándar del bucle, por lo que, a
la condición ( n = 0 ) se le considera condición de salida interna del bucle.

-- 150 of 180 --

Libro de Algoritmos de “Abrirllave.com” 151 / 180
EJEMPLO No obstante, el problema también se puede resolver sin hacer uso de la
instrucción interrumpir:
algoritmo Numeros_opuestos_del_menos_10_al_mas_10
variables
entero numero, acumulador
inicio
acumulador  0
hacer
escribir( "Introduzca un número entero: " )
leer( numero )
si ( numero = 0 )
escribir( "ERROR: El cero no tiene opuesto." )
sino
escribir( "El opuesto es: ", -numero )
acumulador  acumulador + numero
fin_si
mientras ( numero >= -10 y numero <= 10 y numero <> 0 )
escribir( "Suma: ", acumulador )
fin
Obsérvese que, en este algoritmo, sí se contempla en la condición de salida del bucle la
posibilidad de que el usuario teclee un cero, en cuyo caso, el bucle deja de iterar de forma
natural.
Los resultados por pantalla de este algoritmo son idénticos a los del algoritmo anterior.
11.3. continuar
En pseudocódigo, para escribir una instrucción de salto continuar se utiliza la sintaxis:
continuar
La instrucción de salto continuar siempre se usa para interrumpir (romper) la ejecución
normal de un bucle. Sin embargo, el control del programa no se transfiere a la primera
instrucción después del bucle (como sí hace la instrucción interrumpir), es decir, el bucle
no finaliza, sino que, finaliza la iteración en curso, transfiriéndose el control del programa a la
condición de salida del bucle, para decidir si se debe realizar una nueva iteración o no.
Por tanto, la instrucción continuar finaliza (termina) la ejecución de una iteración de un
bucle, pero, no la ejecución del bucle en sí. De forma que, la instrucción continuar salta (no
ejecuta) las instrucciones que existan después de ella, en la iteración de un bucle.
EJEMPLO En el algoritmo siguiente se muestra cómo se puede utilizar la instrucción
continuar:

-- 151 of 180 --

Libro de Algoritmos de “Abrirllave.com” 152 / 180
algoritmo Numeros_opuestos_del_menos_10_al_mas_10
variables
entero n, a
inicio
a  0
hacer
escribir( "Introduzca un número entero: " )
leer( n )
si ( n = 0 )
escribir( "ERROR: El cero no tiene opuesto." )
continuar
/* En el caso de que n sea un cero,
la iteración en curso del bucle
se interrumpe aquí. */
fin_si
escribir( "El opuesto es: ", -n )
a  a + n
mientras ( n >= -10 y n <= 10 )
escribir( "Suma: ", a )
fin
El código del algoritmo es el mismo que el del primer ejemplo visto en el apartado “11.2.
interrumpir”, excepto por la instrucción interrumpir, que ha sido sustituida por la
instrucción continuar. El algoritmo puede ser la solución para el problema siguiente, el cual
se diferencia del ejemplo del apartado anterior en que si el usuario introduce un cero, el bucle
no deja de iterar.
EJEMPLO Números opuestos (del -10 al 10) (Versión 2).
Diseñe el algoritmo de un programa que:
1º) Pida por teclado un número (dato entero).
2º) Si el número introducido por el usuario es distinto de cero, muestre por pantalla el
mensaje:
 “El opuesto es: <-número>”.
En caso contrario, muestre el mensaje:
 “ERROR: El cero no tiene opuesto.”.
3º) Repita los pasos 1º y 2º, mientras que, el usuario introduzca un número mayor o igual que
-10 y menor o igual que 10.
4º) Muestre por pantalla la suma de los números introducidos por el usuario.
En pantalla:

-- 152 of 180 --

Libro de Algoritmos de “Abrirllave.com” 153 / 180
La instrucción continuar se ejecuta cuando el usuario introduce un cero, interrumpiendo la
iteración en curso; pero, el bucle solamente finaliza cuando la condición ( n >= -10 y n
<= 10 ) sea falsa.
Normalmente, al igual que ocurre con la instrucción interrumpir, cuando en un bucle se
utiliza una instrucción continuar, la ejecución de ésta también se condiciona.
En este último ejemplo, la iteración en curso del bucle se interrumpe si es verdadera la
condición ( n = 0 ).
EJEMPLO Ahora bien, el problema también se puede resolver sin hacer uso de la instrucción
continuar:
algoritmo Numeros_opuestos_del_menos_10_al_mas_10
variables
entero numero, acumulador
inicio
acumulador  0
hacer
escribir( "Introduzca un número entero: " )
leer( numero )
si ( numero = 0 )
escribir( "ERROR: El cero no tiene opuesto." )
sino
escribir( "El opuesto es: ", -numero )
acumulador  acumulador + numero
fin_si
mientras ( numero >= -10 y numero <= 10 )
escribir( "Suma: ", acumulador )
fin
Los resultados por pantalla de este algoritmo son idénticos a los del algoritmo anterior.

-- 153 of 180 --

Libro de Algoritmos de “Abrirllave.com” 154 / 180
11.4. ir_a
En pseudocódigo, para escribir una instrucción de salto ir_a se utiliza la sintaxis:
ir_a <nombre_de_la_etiqueta>
La instrucción de salto ir_a se puede usar en cualquier parte del cuerpo de un algoritmo,
para transferir incondicionalmente el control del algoritmo (o programa) a la primera
instrucción después de una etiqueta, o dicho de otra forma, al ejecutar una instrucción ir_a,
el control del programa se transfiere (salta) a la primera instrucción después de una etiqueta.
Una etiqueta se define mediante su nombre (identificador) seguido del carácter dos puntos
(:).
EJEMPLO En el siguiente algoritmo se utiliza la instrucción ir_a para resolver el problema
planteado en el apartado “11.2. interrumpir”:
algoritmo Numeros_opuestos_del_menos_10_al_mas_10
variables
entero n, a
inicio
a  0
hacer
escribir( "Introduzca un número entero: " )
leer( n )
si ( n = 0 )
escribir( "ERROR: El cero no tiene opuesto." )
ir_a etiqueta_1
/* En el caso de que n sea un cero,
el control del programa salta a la primera
instrucción después de etiqueta_1. */
fin_si
escribir( "El opuesto es: ", -n )
a  a + n
mientras ( n >= -10 y n <= 10 )
etiqueta_1:
escribir( "Suma: ", a )
fin
Los resultados por pantalla de este algoritmo son idénticos a los de los algoritmos del apartado
“11.2. interrumpir”.
En pantalla:

-- 154 of 180 --

Libro de Algoritmos de “Abrirllave.com” 155 / 180
Normalmente, al igual que ocurre con las instrucciones interrumpir y continuar,
cuando en un algoritmo se utiliza una instrucción ir_a, la ejecución de ésta también se
condiciona.
11.5. volver
En pseudocódigo, para escribir una instrucción de salto volver se utiliza la sintaxis:
volver <expresión>
Haremos uso de la instrucción volver cuando definamos subprogramas de tipo función, que
estudiaremos en el apartado “12.2.5. Funciones”.
11.6. Ventajas de no usar las instrucciones de salto
Las ventajas de no usar las instrucciones de salto, especialmente la instrucción ir_a, se
pueden resumir en:
 La legibilidad del algoritmo es mayor.
 La probabilidad de cometer errores en el algoritmo es menor.
 Es más fácil realizar cambios o corregir errores en el algoritmo.
 Nunca se altera (rompe) la secuencia de ejecución normal del programa. Dicho de otro
modo, el programa siempre se ejecuta de un modo natural.

-- 155 of 180 --

Libro de Algoritmos de “Abrirllave.com” 156 / 180