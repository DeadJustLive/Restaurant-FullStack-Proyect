# 2. Una función devuelve siempre un valor. Por tanto, en una función siempre debe

## Fuente
algoritmos-pseudocodigo-ordinogramas (Cap. 58)

## Contenido
# 2. Una función devuelve siempre un valor. Por tanto, en una función siempre debe

indicarse el <tipo_de_dato> del valor que devuelve la función, y el valor en sí,
mediante la instrucción volver <expresión>.
De modo que, si queremos realizar la multiplicación de dos números enteros por medio de una
función, podemos escribir, por ejemplo:
entero funcion Multiplicar(
E entero n1, n2 )
variables
entero resultado
inicio
resultado  n1 * n2
volver resultado
fin
O también:
entero funcion Multiplicar(
E entero n1, n2 )
inicio
volver n1 * n2
fin
Por otro lado, para declarar una función en un algoritmo se utiliza la sintaxis:
<tipo_de_dato> <nombre_de_la_función>( <lista_de_tipos_de_datos> )
Y, para hacer una llamada a una función, la sintaxis es:
<nombre_de_la_función>( [ <lista_de_parámetros_actuales> ] )
En consecuencia, usando la función Multiplicar, la solución algorítmica al problema del
ejemplo (Multiplicación de dos números enteros) del apartado “12.2.4. Parámetros”, puede
ser la siguiente:

-- 175 of 180 --

Libro de Algoritmos de “Abrirllave.com” 176 / 180
algoritmo Multiplicacion_de_dos_numeros_enteros
subalgoritmos
entero Multiplicar( E entero, entero )
variables
entero a, b
inicio
escribir( "Introduzca el primer número: " )
leer( a )
escribir( "Introduzca el segundo número: " )
leer( b )
escribir( "La multiplicación es: ", Multiplicar( a, b ) )
fin
12.2.6. Representación mediante diagramas
de flujo
En un ordinograma, para representar una llamada a un subprograma se utiliza el símbolo:
De forma que, por ejemplo, el algoritmo Multiplicacion_de_dos_numeros_
enteros propuesto en el apartado “11.2.4.2 Parámetros actuales”, se puede representar, de
manera gráfica, de la siguiente forma:

-- 176 of 180 --

Libro de Algoritmos de “Abrirllave.com” 177 / 180
Ahora bien, cuando se trata de una llamada a una función, en vez de a un procedimiento, se
puede prescindir del símbolo de llamada a un subprograma. En consecuencia, el algoritmo
Multiplicacion_de_dos_numeros_enteros visto en el apartado “12.2.5. Funciones”
se puede representar, gráficamente, como se muestra a continuación:
12.3. Recursividad
En programación, cuando desde un subprograma se realiza una llamada a sí mismo, se dice
que se está haciendo uso de la recursividad. Por tanto, un subprograma recursivo es aquel que
se llama a sí mismo. No obstante, hay que saber, que toda solución recursiva tiene su
correspondiente solución iterativa.
EJEMPLO Factorial de un número.
Se quiere diseñar el algoritmo de un programa que:
1º) Pida por teclado un número (dato entero).
2º) Si el número introducido no es mayor que cero, muestre por pantalla el mensaje:
 “ERROR: El número debe ser mayor que cero.”
En caso contrario, muestre el factorial del número introducido por el usuario.
Nota: El factorial de un número natural (n!) es el producto de todos los números que hay entre
el uno (1) y dicho número (n), ambos inclusive. Por ejemplo, el factorial de 4 es el resultado de
multiplicar 1 * 2 * 3 * 4, es decir, 4! = 24.

-- 177 of 180 --

Libro de Algoritmos de “Abrirllave.com” 178 / 180
En pantalla:
La solución al problema puede venir dada por el siguiente algoritmo:
algoritmo Factorial_de_un_numero
variables
entero n
inicio
escribir( "Introduzca un número: " )
leer( n )
si( n > 0 )
escribir( n, "! = ", Factorial( n ) )
sino
escribir( "ERROR: El número debe ser mayor que cero." )
fin_si
fin
Sin emplear recursividad, se puede escribir la función Factorial de la siguiente forma:
entero funcion Factorial(
E entero numero )
variable
entero contador, resultado
inicio
resultado  numero
mientras ( numero > 2 )
numero  numero - 1
resultado  resultado * numero
fin_mientras
volver resultado
fin
Y, recursivamente:

-- 178 of 180 --

Libro de Algoritmos de “Abrirllave.com” 179 / 180
entero funcion Factorial(
E entero numero )
variable
entero resultado
inicio
si ( numero <> 1 )
resultado  Factorial( numero - 1 ) * numero
sino
resultado  1
fin_si
volver resultado
fin
En ambas soluciones, el resultado devuelto en la llamada a Factorial realizada en el
algoritmo Factorial_de_un_numero es el mismo. Sin embargo, obsérvese que, en la
segunda solución de la función Factorial, se llamará de forma recursiva al subprograma.
En cuanto a qué solución es mejor, la iterativa o la recursiva, hay que decir que, la solución
iterativa suele utilizar menos memoria, no corre el riesgo de agotarla e, incluso, puede ser más
rápida algorítmicamente. Ahora bien, en algunas ocasiones, la solución recursiva es más
elegante y fácil de obtener, por lo que, dependiendo del problema, el programador debe
decidir qué solución implementar.

-- 179 of 180 --

Libro de Algoritmos de “Abrirllave.com” 180 / 180
