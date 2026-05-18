# 2. Signos de un número (también son operadores).

## Fuente
algoritmos-pseudocodigo-ordinogramas (Cap. 40)

## Contenido
# 2. Signos de un número (también son operadores).

Los operadores de signo más (+) y menos (-) son operadores monarios, también llamados
unarios, ya que, actúan, solamente, sobre un operando.

-- 45 of 180 --

Libro de Algoritmos de “Abrirllave.com” 46 / 180
Los caracteres abrir paréntesis “(” y cerrar paréntesis “)” se utilizan para establecer la
prioridad de los operadores, es decir, para establecer el orden en el que los operadores actúan
sobre los operandos.
EJEMPLO Obsérvese la diferencia entre las siguientes operaciones:
-19 + 72 (dos operandos y dos operadores)
-( 19 + 72 ) (dos operandos y dos operadores)
Los resultados de evaluarlas son, respectivamente:
53 (primero actúa el operador signo (-) y después el operador suma (+))
-91 (primero actúa el operador suma (+) y después el operador signo (-))
EJEMPLO Percátese también de las diferencias entre las siguientes operaciones:
( ( 3 * 7 ) + 2 ) – 1
( 3 * ( 7 + 2 ) ) – 1
3 * ( ( 7 + 2 ) – 1 )
( 3 * 7 ) + ( 2 – 1 )
Al evaluarlas se obtienen los valores:
22 (actúan en orden los operadores: multiplicación (*), suma (+) y resta (-))
26 (actúan en orden los operadores: suma (+), multiplicación (*) y resta (-))
24 (actúan en orden los operadores: suma (+), resta (-) y multiplicación (*))
22 (actúan en orden los operadores: multiplicación (*), resta (-) y suma (+))
Un operador indica el tipo de operación a realizar sobre los operandos –datos– que actúa. Los
operandos pueden ser:
 Constantes, expresadas por su valor o con su nombre (identificador).
 Variables.
 Llamadas a funciones.
 Elementos de formaciones (arrays).
En este capítulo se van a tratar operaciones en donde únicamente aparecen constantes y
variables. Las funciones y las formaciones se estudiarán más adelante.
Cuando se combinan uno o más operadores con uno o más operandos se obtiene una
expresión. De modo que, una expresión es una secuencia de operandos y operadores escrita
bajo unas reglas de sintaxis. Por ejemplo, dadas las siguientes declaraciones de constantes y
variables en pseudocódigo:

-- 46 of 180 --

Libro de Algoritmos de “Abrirllave.com” 47 / 180
PI = 3.141592
entero numero = 2
real radio_circulo = 3.2
EJEMPLO Algunos ejemplos de expresiones son:
2 * PI * radio_circulo
( PI * PI )
numero * 5
De sus evaluaciones se obtienen los valores:
20.106189 (valor real) ( 2 * 3.141592 * 3.2 )
9.869600 (valor real) ( 3.141592 * 3.141592 )
10 (valor entero) ( 2 * 5 )
Un operador siempre forma parte de una expresión, en la cual, el operador siempre actúa
sobre al menos un operando. Por el contrario, un operando sí puede aparecer solo en una
expresión.
EJEMPLO Las siguientes expresiones están constituidas por un solo operando, es decir, no
están bajo la influencia de ningún operador:
PI
numero
5
Los resultados de evaluarlas son:
3.141592 (valor real)
2 (valor entero)
5 (valor entero)
De la evaluación de una expresión siempre se obtiene un valor. Dicho valor puede ser de tipo
entero, real, lógico, carácter o cadena. Por consiguiente, una expresión puede ser:
 Aritmética (devuelve un número entero o real).
 Lógica (devuelve un valor lógico: verdadero o falso).
 De carácter (devuelve un carácter representable por el ordenador).
 De cadena (devuelve una cadena).
Dependiendo del tipo de expresión, pueden participar unos operadores u otros.

-- 47 of 180 --

Libro de Algoritmos de “Abrirllave.com” 48 / 180
5.1. Expresiones aritméticas
De la evaluación de una expresión aritmética siempre se obtiene un valor de tipo entero o
real. En las expresiones aritméticas se pueden utilizar los siguientes operadores aritméticos:
Operadores aritméticos en pseudocódigo
Operador Descripción
+ Suma
- Resta
* Multiplicación
** Potencia (también se utiliza la flecha arriba  o el acento circunflejo ^)
/ División real
div División entera (también se utiliza el carácter barra invertida \)
mod Módulo (resto de la división entera)
+ Signo más
- Signo menos
EJEMPLO El operador suma (+) realiza la suma de dos operandos numéricos.
5 + 2
3.1 + 2.5
De la evaluación de las expresiones anteriores se obtienen los valores:
7 (valor entero)
5.6 (valor real)
EJEMPLO El operador resta (-) realiza la resta entre dos operandos numéricos.
5 – 2
3.1 - 2.5
Obteniéndose los valores:
3 (valor entero)
0.6 (valor real)
EJEMPLO El operador multiplicación (*) realiza la multiplicación de dos operandos
numéricos.

-- 48 of 180 --

Libro de Algoritmos de “Abrirllave.com” 49 / 180
5 * 2
3.1 * 2.5
Ahora los resultados son:
10 (valor entero)
7.75 (valor real)
EJEMPLO El operador potencia (**) eleva el operando de la izquierda (número base) al
operando de la derecha (potencia o exponente).
5 ** 2
3.1 ** 2.5
De estas expresiones, se obtienen los valores:
25 (valor entero)
16.920151 (valor real)
EJEMPLO El operador división real (/) realiza la división real entre dos operandos
numéricos.
5 / 2
3.1 / 2.5
Sus resultados son:
2.5 (valor real)
1.24 (valor real)
EJEMPLO El operador división entera (div) realiza la división entera entre dos operandos
numér
