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
numéricos enteros.
5 div 2
3.1 div 2.5
El operador división entera (div) no puede operar con operandos numéricos reales. Por tanto,
al evaluar las expresiones de este ejemplo se obtienen los valores:
2 (entero)
ERROR (no se puede evaluar; ambos operandos deben ser valores enteros)

-- 49 of 180 --

Libro de Algoritmos de “Abrirllave.com” 50 / 180
EJEMPLO El operador módulo (mod) realiza la división entera entre dos operandos
numéricos enteros, devolviendo el resto de la misma.
5 mod 2
3.1 mod 2.5
Al igual que el operador división entera (div), el operador módulo (mod) tampoco puede
operar con operandos numéricos reales. De modo que, en este caso, los resultados son:
1 (valor entero)
ERROR (no se puede evaluar; ambos operandos deben ser valores enteros)
EJEMPLO El operador signo menos (-) cambia el signo de un operando numérico. Así, de las
expresiones:
-11
-( 3.1 )
-( -2.5 )
Se obtienen los valores:
-11 (valor entero)
-3.1 (valor real)
2.5 (valor real)
EJEMPLO El operador signo más (+) mantiene el signo de un operando numérico. Así, de las
expresiones:
+11
+( 3.1 )
+( -2.5 )
Los valores que se obtienen son:
11 (valor entero)
3.1 (valor real)
-2.5 (valor real)
EJEMPLO En una expresión aritmética pueden aparecer operandos numéricos enteros y
reales al mismo tiempo.

-- 50 of 180 --

Libro de Algoritmos de “Abrirllave.com” 51 / 180
11 + 3.1
2.5 - 3
-3.1 * 10
11 ** 2.5
+3.1 / 2
De estas expresiones se obtienen los valores:
14.1 (valor real)
-0.5 (valor real)
-31.0 (valor real)
401.311600 (valor real)
1.55 (valor real)
Como se puede apreciar, al combinar operandos numéricos reales con operandos numéricos
enteros en una expresión aritmética, el resultado de su evaluación siempre es un valor
numérico real, excepto con el operador módulo (mod) o con el operador división entera (div),
en cuyos casos se obtendrá ERROR.
5.1.1. Prioridad de los operadores aritméticos
La prioridad de los operadores puede variar de unos lenguajes a otros, pero, en pseudocódigo,
en este tutorial, vamos a establecer una prioridad de operadores muy similar a la que se aplica
en lenguaje C. La prioridad no puede ser exactamente la misma, ya que, en C existen algunos
operadores que no existen en pseudocódigo, y al revés.
EJEMPLO En una expresión aritmética puede aparecer más de un operador aritmético.
11 + 3 div 3 (dos operadores)
-3 * 6 mod 4 (tres operadores)
-3.1 + 5 * 0.5 (tres operadores)
3 ** 3 - 1 (dos operadores)
+3 * -8 (tres operadores)
Para poder evaluar correctamente las expresiones aritméticas del ejemplo, es necesario seguir
un criterio de prioridad de operadores. En nuestro pseudocódigo CEE, la prioridad de los
operadores aritméticos es:

-- 51 of 180 --

Libro de Algoritmos de “Abrirllave.com” 52 / 180
Prioridad de los operadores aritméticos (de mayor a menor) en pseudocódigo
Operadores Descripción
+ - Signos más y menos
** Potencia
* / div mod Multiplicación, división real, división entera y módulo
+ - Suma y resta
A excepción de los operadores de signo, que se evalúan de derecha a izquierda en una
expresión, todos los demás operadores aritméticos con la misma prioridad, por ejemplo, el
operador multiplicación (*) y el operador módulo (mod), se evalúan de izquierda a derecha. En
consecuencia, los valores que proporcionan las expresiones del ejemplo anterior son:
12 (actúan en orden los operadores: (div) y suma (+))
-2 (actúan en orden los operadores: signo menos (-), (*) y (mod))
-0.6 (actúan en orden los operadores: signo menos (-), (*) y suma (+))
26 (actúan en orden los operadores: (**) y resta (-))
-24 (actúan en orden los operadores: signo menos (-), signo más (+) y (*))
Para modificar la prioridad de los operadores en las expresiones, se debe hacer uso de los
caracteres abrir paréntesis “(” y cerrar paréntesis “)”.
EJEMPLO Para cambiar la prioridad de los operadores de las expresiones del ejemplo
anterior, se puede escribir:
( 11 + 3 ) div 3
-3 * ( 6 mod 4 )
( -3.1 + 5 ) * 0.5
3 ** ( 3 - 1 )
( +3 ) * -8
De la evaluación de estas expresiones se obtienen los valores:
4 (actúan en orden los operadores: suma (+) y (div))
-6 (actúan en orden los operadores: (mod), signo menos (-) y (*))
0.95 (actúan en orden los operadores: signo menos (-), suma (+) y (*))
9 (actúan en orden los operadores: resta (-) y (**))

-- 52 of 180 --

Libro de Algoritmos de “Abrirllave.com” 53 / 180
-24 (actúan en orden los operadores: signo más (+), signo menos (-) y (*))
En las expresiones aritméticas hay que tener la precaución de no dividir entre cero (0).
EJEMPLO Por tanto, las siguientes expresiones son incorrectas:
11 / 0
5 div 0
-3 mod 0
De la evaluación de cada una de estas expresiones se obtiene:
ERROR (no se puede evaluar; no se puede dividir entre cero)
5.2. Expresiones lógicas
De la evaluación de una expresión lógica siempre se obtiene un valor de tipo lógico
(verdadero o falso). En las expresiones lógicas se pueden utilizar dos tipos de operadores:
 Relacionales.
 Lógicos.
Un operador relacional se utiliza para comparar los valores de dos expresiones. Estas deben
ser del mismo tipo (aritméticas, lógicas, de carácter o de cadena).
EJEMPLO Algunos ejemplos son:
22 > 13 (comparación de dos expresiones aritméticas)
22.5 < 3.44 (comparación de dos expresiones aritméticas)
verdadero = falso (comparación de dos expresiones lógicas)
'c' > 'f' (comparación de dos expresiones de carácter)
"coche" = "Coche" (comparación de dos expresiones de cadena)
Proporcionan los valores:
verdadero (22 es mayor que 13)
falso (22.5 no es menor que 3.44)
falso (verdadero no es igual que falso)
falso ('c' no es mayor que 'f')
falso ("coche" no es igual que "Coche")

-- 53 of 180 --

Libro de Algoritmos de “Abrirllave.com” 54 / 180
Las comparaciones entre los valores de tipo numérico son obvias. En cuanto a los valores de
tipo lógico (verdadero y falso) se considera que falso es menor que verdadero. En lo
que respecta a los valores de tipo carácter, su orden viene dado por el ASCII extendido
utilizado por el ordenador para representarlos. Y en el caso de los valores de tipo cadena,
también se tiene en cuenta dicho código.
Los operadores relacionales son:
Operadores relacionales en pseudocódigo
Operador Descripción
< Menor que
<= Menor o igual que
> Mayor que
>= Mayor o igual que
= Igual que
<> Distinto que
Para escribir una expresión relacional (lógica) se utiliza la sintaxis:
<expresión_1> <operador_de_relación> <expresión_2>
Siendo <expresión_1> y <expresión_2> del mismo tipo (aritmética, lógica, de carácter
o de cadena).
EJEMPLO La comparación entre valores de tipo cadena se realiza carácter a carácter.
"a" = "b" (se compara "a" con "b")
"bc" <> "kd" (se compara "b" con "k" y "c" con "d")
"126" < "9" (se compara "1" con "9")
"ab" <= "ab" (se compara "a" con "a" y "b" con "b")
"abb" >= "abc" (se compara "a" con "a", "b" con "b" y "b" con "c")
De estas expresiones se obtienen los valores:
falso ("a" no es igual que "b")
verdadero ("bc" es distinto que "kd")
verdadero ("1" es menor que "9")
verdadero ("ab" es menor o igual que "ab")

-- 54 of 180 --

Libro de Algoritmos de “Abrirllave.com” 55 / 180
falso ("abb" no es mayor o igual que "abc")
Un operador lógico actúa, exclusivamente, sobre valores de expresiones lógicas. Los
operadores lógicos son:
Operadores lógicos en pseudocódigo
Operador Descripción
y Conjunción
o Disyunción
no Negación
El operador conjunción (y) y el operador disyunción (o) siempre actúan sobre dos operandos,
mientras que, el operador negación (no) solamente actúa sobre un operando, o dicho de otra
forma, es un operador monario.
El modo en que actúan los operadores lógicos se resume en las llamadas tablas de verdad,
definidas por el matemático George Boole.
La tabla de verdad del operador conjunción (y) es:
Tabla de verdad del operador conjunción (y)
<expresión_1> <expresión_2> <expresión_1> y <expresión_2>
verdadero verdadero verdadero
verdadero falso falso
falso verdadero falso
falso falso falso
Se supone que <expresión_1> y <expresión_2> son expresiones lógicas. De la tabla de
verdad se deduce que <expresión_1> y <expresión_2> se evalúa a verdadero
solamente en el caso de que tanto <expresión_1> como <expresión_2> se evalúen
también como verdaderas, en cualquier otro caso el resultado será falso. Dicho de otro
modo, si al menos una de las dos expresiones es falsa, el resultado será falso.
EJEMPLO Algunos ejemplos son:
9 > 3 y 8 > 6
9 > 3 y 8 > 9
9 = 3 y 8 >= 6
9 = 3 y 8 >= 9

-- 55 of 180 --

Libro de Algoritmos de “Abrirllave.com” 56 / 180
Las expresiones anteriores se evalúan a:
verdadero (9 > 3 es verdadero y 8 > 6 es verdadero)
falso (9 > 3 es verdadero y 8 > 9 es falso)
falso (9 = 3 es falso y 8 >= 6 es verdadero)
falso (9 = 3 es falso y 8 >= 9 es falso)
La tabla de verdad del operador disyunción (o) es:
Tabla de verdad del operador disyunción (o)
<expresión_1> <expresión_2> <expresión_1> o <expresión_2>
verdadero verdadero verdadero
verdadero falso verdadero
falso verdadero verdadero
falso falso falso
Se supone que <expresión_1> y <expresión_2> son expresiones lógicas. De la tabla de
verdad se deduce que <expresión_1> o <expresión_2> se evalúa a falso
solamente en el caso de que tanto <expresión_1> como <expresión_2> se evalúen
también como falsas, en cualquier otro caso el resultado será verdadero. Dicho de otro
modo, si al menos una de las dos expresiones es verdadera, el resultado será verdadero.
EJEMPLO Algunos ejemplos son:
9 > 3 o 8 > 6
9 > 3 o 8 > 9
9 = 3 o 8 >= 6
9 = 3 o 8 >= 9
Las expresiones anteriores se evalúan:
verdadero (9 > 3 es verdadero y 8 > 6 es verdadero)
verdadero (9 > 3 es verdadero y 8 > 9 es falso)
verdadero (9 = 3 es falso y 8 >= 6 es verdadero)
falso (9 = 3 es falso y 8 >= 9 es falso)

-- 56 of 180 --

Libro de Algoritmos de “Abrirllave.com” 57 / 180
La tabla de verdad del operador negación (no) es:
Tabla de verdad del operador negación (no)
<expresión> no <expresión>
verdadero falso
falso verdadero
Se supone que <expresión> es una expresión lógica, al evaluarla se obtiene el valor
verdadero o el valor falso. Y como se puede apreciar en la tabla, el valor de no
<expresión> es el contrario al valor obtenido de <expresión>.
EJEMPLO De las expresiones:
no ( 9 > 3 )
no ( 8 > 9 )
Los resultados de evaluarlas son:
falso (9 > 3 es verdadero)
verdadero (8 > 9 es falso)
5.2.1. Prioridad de los operadores relacionales
y lógicos
En una expresión lógica puede aparecer uno o más operadores relacionales y/o lógicos.
EJEMPLO Algunos ejemplos son:
3 > 1 o 4 < 1 y 4 <= 2
no falso y falso
verdadero >= verdadero = falso
falso = verdadero <= verdadero
Para poder evaluar correctamente las expresiones lógicas del ejemplo, es necesario seguir un
criterio de prioridad de operadores. En nuestro pseudocódigo CEE, la prioridad entre los
operadores relacionales y lógicos es:

-- 57 of 180 --

Libro de Algoritmos de “Abrirllave.com” 58 / 180
Prioridad de los operadores relacionales y lógicos (de mayor a menor) en pseudocódigo
Operadores Descripción
no Negación
< <= > >= Menor que, menor o igual que, mayor que, mayor o igual que
= <> Igual que, distinto que
y Conjunción
o Disyunción
A excepción del operador negación (no), que se evalúa de derecha a izquierda en una
expresión, todos los demás operadores con la misma prioridad, por ejemplo, el operador
menor que (<) y el operador mayor que (>), se evalúan de izquierda a derecha. Así que, los
valores que proporcionan las expresiones del ejemplo anterior son:
verdadero (actúan en orden los operadores: (>), (<), (<=), (y) y (o))
falso (actúan en orden los operadores: (no) e (y))
falso (actúan en orden los operadores: (>=) y (=))
falso (actúan en orden los operadores: (<=) y (=))
De nuevo, podemos hacer uso de los caracteres abrir paréntesis “(” y cerrar paréntesis “)”
para modificar la prioridad de los operadores.
EJEMPLO Para cambiar la prioridad de los operadores de las expresiones del ejemplo
anterior, se puede escribir:
( 3 > 1 o 4 < 1 ) y 4 <= 2
no ( falso y falso )
verdadero >= ( verdadero = falso )
( falso = verdadero ) <= verdadero
De la evaluación de estas expresiones se obtienen los valores:
falso (actúan en orden los operadores: (>), (<), (o), (<=) e (y))
verdadero (actúan en orden los operadores: (y) y (no))
verdadero (actúan en orden los operadores: (=) y (>=))
verdadero (actúan en orden los operadores: (=) y (<=))

-- 58 of 180 --

Libro de Algoritmos de “Abrirllave.com” 59 / 180
5.3. Expresiones de carácter
Aunque no existe ningún operador de caracteres, sí que existen expresiones de carácter. De la
evaluación de una expresión de carácter siempre se obtiene un valor de tipo carácter.
EJEMPLO Dadas las siguientes declaraciones de constantes y variables en pseudocódigo: