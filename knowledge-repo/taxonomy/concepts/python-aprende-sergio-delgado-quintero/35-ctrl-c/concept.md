# CTRL-C

## Fuente
Aprende Python (Cap. 35)

## Contenido
# CTRL-C

KeyboardInterrupt
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
El problema que surje es que la variable num toma los valores 1, 3, 5, 7, 9, 11, ..
. por lo que nunca se cumple la condición de parada del bucle. Esto hace que repitamos
«eternamente» la instrucción de incremento.
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/AfrZroa
Una posible solución a este error es reescribir la condición de parada en el bucle:
>>> num = 1
>>> while num < 10:
... num += 2
...
Truco: Para abortar una situación de bucle infinito podemos pulsar en el teclado
la combinación CTRL-C. Se puede ver reflejado en el intérprete de Python por
KeyboardInterrupt.
Hay veces que un supuesto bucle «infinito» puede ayudarnos a resolver un problema.
Imaginemos que queremos escribir un programa que ayude al profesorado a introducir las
notas de un examen. Si la nota no está en el intervalo [0, 10] mostramos un mensaje de error,
en otro caso seguimos pidiendo valores:
>>> while True:
... mark = float(input( Introduzca nueva nota: ))
... if not(0 <= mark <= 10):
... print( Nota fuera de rango )
... break
... print(mark)
...
Introduzca nueva nota: 5
5.0
Introduzca nueva nota: 3
3.0
Introduzca nueva nota: 11
Nota fuera de rango
4.2. Bucles 123

-- 127 of 516 --

Aprende Python
Ejercicio
Escriba un programa que encuentre todos los múltiplos de 5 menores que un valor dado:
Ejemplo
• Entrada: 36
• Salida: 5 10 15 20 25 30 35
4.2.2 La sentencia for
Python permite recorrer aquellos tipos de datos que sean iterables, es decir, que admitan
iterar2 sobre ellos. Algunos ejemplos de tipos y estructuras de datos que permiten ser iteradas
(recorridas) son: cadenas de texto, listas, diccionarios, ficheros, etc. La sentencia for nos
permite realizar esta acción.
A continuación se plantea un ejemplo en el que vamos a recorrer (iterar) una cadena de
texto:
>>> word = Python
>>> for letter in word:
... print(letter)
...
P
y
t
h
o
n
La clave aquí está en darse cuenta que el bucle va tomando, en cada iteración, cada uno de
los elementos de la variable que especifiquemos. En este caso concreto letter va tomando
cada una de las letras que existen en word, porque una cadena de texto está formada por
elementos que son caracteres.
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/Pft6R2e
Importante: La variable que utilizamos en el bucle for para ir tomando los valores puede
tener cualquier nombre. Al fin y al cabo es una variable que definimos según nuestras
2 Realizar cierta acción varias veces. En este caso la acción es tomar cada elemento.
124 Capítulo 4. Control de flujo

-- 128 of 516 --

Aprende Python
necesidades. Tener en cuenta que se suele usar un nombre en singular.
Romper un bucle for
Una sentencia break dentro de un for rompe el bucle, igual que veíamos para los bucles
while. Veamos un ejemplo con el código anterior. En este caso vamos a recorrer una cadena
de texto y pararemos el bucle cuando encontremos una letra t minúscula:
>>> word = Python
>>> for letter in word:
... if letter == t :
... break
... print(letter)
...
P
y
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/zfyqkbJ
Truco: Tanto la comprobación de rotura de un bucle como la continuación a la siguiente
iteración se llevan a cabo del mismo modo que hemos visto con los bucles de tipo while.
Ejercicio
Dada una cadena de texto, indique el número de vocales que tiene.
Ejemplo
• Entrada: Supercalifragilisticoespialidoso
• Salida: 15
4.2. Bucles 125

-- 129 of 516 --

Aprende Python
Secuencias de números
Es muy habitual hacer uso de secuencias de números en bucles. Python no tiene una
instrucción específica para ello. Lo que sí aporta es una función range() que devuelve un
flujo de números en el rango especificado. Una de las grandes ventajas es que la «lista»
generada no se construye explícitamente, sino que cada valor se genera bajo demanda. Esta
técnica mejora el consumo de recursos, especialmente en términos de memoria.
La técnica para la generación de secuencias de números es muy similar a la utilizada en los
«slices» de cadenas de texto. En este caso disponemos de la función range(start, stop,
step):
• start: Es opcional y tiene valor por defecto 0.
• stop: es obligatorio (siempre se llega a 1 menos que este valor).
• step: es opcional y tiene valor por defecto 1.
range() devuelve un objeto iterable, así que iremos obteniendo los valores paso a paso con
una sentencia for ... in3. Veamos diferentes ejemplos de uso:
Rango: [0, 1, 2]
>>> for i in range(0, 3):
... print(i)
...
0
1
2
>>> for i in range(3): # No hace falta indicar el inicio si es 0
... print(i)
...
0
1
2
Rango: [1, 3, 5]
>>> for i in range(1, 6, 2):
... print(i)
...
1
3
5
Rango: [2, 1, 0]
3 O convertir el objeto a una secuencia como una lista.
126 Capítulo 4. Control de flujo

-- 130 of 516 --

Aprende Python
>>> for i in range(2, -1, -1):
... print(i)
...
2
1
0
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/vfywE45
Truco: Se suelen u
