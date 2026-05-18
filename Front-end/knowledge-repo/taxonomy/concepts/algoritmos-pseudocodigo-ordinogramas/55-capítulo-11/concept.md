# Capítulo 11

## Fuente
algoritmos-pseudocodigo-ordinogramas (Cap. 55)

## Contenido
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
normal de un bucle. Sin embargo
