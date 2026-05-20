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
Truco: Se suelen utilizar nombres de variables i, j, k para lo que se denominan contadores.
Este tipo de variables toman valores numéricos enteros como en los ejemplos anteriores. No
conviene generalizar el uso de estas variables a situaciones en las que, claramente, tenemos la
posibilidad de asignar un nombre semánticamente más significativo. Esto viene de tiempos
antiguos en FORTRAN donde i era la primera letra que tenía valor entero por defecto.
Ejercicio
Determine si un número dado es un número primo.
No es necesario implementar ningún algoritmo en concreto. La idea es probar los números
menores al dado e ir viendo si las divisiones tienen resto cero o no.
¿Podría optimizar su código? ¿Realmente es necesario probar con tantos divisores?
Ejemplo
• Entrada: 11
• Salida: Es primo
Usando el guión bajo
Nivel avanzado
Hay situaciones en las que no necesitamos usar la variable que toma valores en el rango,
sino que únicamente queremos repetir una acción un número determinado de veces.
Para estos casos se suele recomendar usar el guión bajo _ como nombre de variable, que
da a entender que no estamos usando esta variable de forma explícita:
>>> for _ in range(10):
... print( Repeat me 10 times! )
(continué en la próxima página)
4.2. Bucles 127

-- 131 of 516 --

Aprende Python
(proviene de la página anterior)
...
Repeat me 10 times!
Repeat me 10 times!
Repeat me 10 times!
Repeat me 10 times!
Repeat me 10 times!
Repeat me 10 times!
Repeat me 10 times!
Repeat me 10 times!
Repeat me 10 times!
Repeat me 10 times!
Ejercicio
Imprima los 100 primeros números de la sucesión de Fibonacci:
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, . . .
4.2.3 Bucles anidados
Como ya vimos en las sentencias condicionales, el anidamiento es una técnica por la que
incluimos distintos niveles de encapsulamiento de sentencias, unas dentro de otras, con mayor
nivel de profundidad. En el caso de los bucles también es posible hacer anidamiento.
Veamos un ejemplo de 2 bucles anidados en el que generamos todas las tablas de multiplicar:
>>> for i in range(1, 10):
... for j in range(1, 10):
... result = i * j
... print(f {i} * {j} = {result} )
...
1 x 1 = 1
1 x 2 = 2
1 x 3 = 3
1 x 4 = 4
1 x 5 = 5
1 x 6 = 6
1 x 7 = 7
1 x 8 = 8
1 x 9 = 9
2 x 1 = 2
2 x 2 = 4
2 x 3 = 6
(continué en la próxima página)
128 Capítulo 4. Control de flujo

-- 132 of 516 --

Aprende Python
(proviene de la página anterior)
2 x 4 = 8
2 x 5 = 10
2 x 6 = 12
2 x 7 = 14
2 x 8 = 16
2 x 9 = 18
3 x 1 = 3
3 x 2 = 6
3 x 3 = 9
3 x 4 = 12
3 x 5 = 15
3 x 6 = 18
3 x 7 = 21
3 x 8 = 24
3 x 9 = 27
4 x 1 = 4
4 x 2 = 8
4 x 3 = 12
4 x 4 = 16
4 x 5 = 20
4 x 6 = 24
4 x 7 = 28
4 x 8 = 32
4 x 9 = 36
5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
5 x 4 = 20
5 x 5 = 25
5 x 6 = 30
5 x 7 = 35
5 x 8 = 40
5 x 9 = 45
6 x 1 = 6
6 x 2 = 12
6 x 3 = 18
6 x 4 = 24
6 x 5 = 30
6 x 6 = 36
6 x 7 = 42
6 x 8 = 48
6 x 9 = 54
7 x 1 = 7
7 x 2 = 14
7 x 3 = 21
(continué en la próxima página)
4.2. Bucles 129

-- 133 of 516 --

Aprende Python
(proviene de la página anterior)
7 x 4 = 28
7 x 5 = 35
7 x 6 = 42
7 x 7 = 49
7 x 8 = 56
7 x 9 = 63
8 x 1 = 8
8 x 2 = 16
8 x 3 = 24
8 x 4 = 32
8 x 5 = 40
8 x 6 = 48
8 x 7 = 56
8 x 8 = 64
8 x 9 = 72
9 x 1 = 9
9 x 2 = 18
9 x 3 = 27
9 x 4 = 36
9 x 5 = 45
9 x 6 = 54
9 x 7 = 63
9 x 8 = 72
9 x 9 = 81
Lo que está ocurriendo en este código es que, para cada valor que toma la variable i, la otra
variable j toma todos sus valores. Como resultado tenemos una combinación completa de
los valores en el rango especificado.
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/vfyeWvj
Nota:
• Podemos añadir todos los niveles de anidamiento que queramos. Eso sí, hay que tener
en cuenta que cada nuevo nivel de anidamiento supone un importante aumento de la
complejidad ciclomática de nuestro código, lo que se traduce en mayores tiempos de
ejecución.
• Los bucles anidados también se pueden aplicar en la sentencia while.
Ejercicio
Dado su tamaño, muestre por pantalla un mosaico donde la diagonal principal esté
130 Capítulo 4. Control de flujo

-- 134 of 516 --

Aprende Python
representada por X, la parte inferior por D y la parte superior por U.
Ejemplo
• Entrada: 5
• Salida: