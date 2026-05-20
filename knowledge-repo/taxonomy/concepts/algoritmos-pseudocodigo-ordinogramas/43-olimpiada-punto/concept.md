# OLIMPIADA + PUNTO

## Fuente
algoritmos-pseudocodigo-ordinogramas (Cap. 43)

## Contenido
# OLIMPIADA + PUNTO

nombre + " " + apellido
"Buenos días" + PUNTO
rio
nombre + " fue a las Olimpiadas de " + OLIMPIADA + PUNTO
Los resultados de evaluarlas son:
"Atenas 2004."
"Pedro Cosín"
"Buenos días."
"Tajo"
"Pedro fue a las Olimpiadas de Atenas 2004."
5.5. Prioridad de los operadores aritméticos,
relacionales, lógicos y de cadena
En una expresión puede aparecer uno o más operadores aritméticos, relacionales, lógicos y/o
de cadena.
EJEMPLO Algunos ejemplos son:
5 * 4 > 5 + 4 o falso y "ab" < "aa"
( 5 * 4 > 5 + 4 o falso ) y 'f' < 'b'
no verdadero < falso
no ( verdadero < falso )

-- 60 of 180 --

Libro de Algoritmos de “Abrirllave.com” 61 / 180
Para poder evaluar correctamente las expresiones anteriores, es necesario seguir un criterio
de prioridad de operadores. En nuestro pseudocódigo CEE, la prioridad entre los operadores
aritméticos, relacionales, lógicos y de cadena es:
Prioridad de los operadores aritméticos, relacionales, lógicos y
de cadena (de mayor a menor) en pseudocódigo
Operadores Descripción
+ - no Signo más, signo menos y negación
** Potencia
* / div mod Multiplicación, división real, división entera y módulo
+ - Suma y resta
+ Concatenación
< <= > >= Menor que, menor o igual que, mayor que, mayor o igual que
= <> Igual que, distinto que
y Conjunción
o Disyunción
Por tanto, los valores que proporcionan las expresiones del ejemplo anterior son:
verdadero (actúan en orden los operadores: (*), suma (+), (>), (<), (y) y (o))
falso (actúan en orden los operadores: (*), suma (+), (>), (o), (<) e (y))
falso (actúan en orden los operadores: (no) y (<))
verdadero (actúan en orden los operadores: (<) y (no))
Obsérvese que, los paréntesis “()” son capaces de cambiar el orden de actuación de los
operadores de cualquier expresión. Además, los paréntesis se pueden anidar, es decir, se
pueden escribir unos dentro de otros, priorizándose del más interno al más externo y,
después, de izquierda a derecha.
EJEMPLO De la expresión:
42 mod ( ( 4 - 5 ) * ( 8 + 2 ) )
Se obtiene el valor:
2 (actúan en orden los operadores: (-), (+), (*) y (mod))
EJEMPLO Sin embargo, de la expresión:
42 mod ( 4 - 5 * 8 + 2 )

-- 61 of 180 --

Libro de Algoritmos de “Abrirllave.com” 62 / 180
Se obtiene el valor:
8 (actúan en orden los operadores: (*), (-), (+) y (mod))
Han aparecido nuevas palabras reservadas: div, mod, no, o e y.
También han aparecido nuevos símbolos reservados.
Símbolos reservados
Símbolo Descripción
() Modifican la prioridad de los operadores de una expresión.
* Operador multiplicación.
** Operador potencia.
/ Operador división real.
< Operador menor que.
<= Operador menor o igual que.
> Operador mayor que.
>= Operador mayor o igual que.
= Operador igual que.
<> Operador distinto que.
Además, algunos símbolos reservados han vuelto a aparecer con significados distintos.
+ Operador suma.
+ Operador concatenación.
- Operador resta.
Ejercicios resueltos
 Evaluación de expresiones aritméticas
 Evaluación de expresiones lógicas
 Evaluación de distintas expresiones

-- 62 of 180 --

Libro de Algoritmos de “Abrirllave.com” 63 / 180
Capítulo 6
Instrucciones primitivas
En programación, las instrucciones que se utilizan para diseñar algoritmos se pueden clasificar
en:
 Primitivas.
 De control.
 Llamadas a subalgoritmos (llamadas a subprogramas).
En este capítulo se van a explicar las instrucciones primitivas. El resto serán estudiadas más
adelante. Existen tres tipos de instrucciones primitivas:
 Asignación.
 Salida.
 Entrada.
6.1. Instrucción de asignación
Una instrucción de asignación –o simplemente asignación– consiste en asignar el resultado de
la evaluación de una expresión a una variable.
EJEMPLO A partir de la definición de las siguientes declaraciones de variables en
pseudocódigo:
cadena nombre
real nota_1, nota_2, nota_3, nota_media
Algunas instrucciones de asignación son:

-- 63 of 180 --

Libro de Algoritmos de “Abrirllave.com” 64 / 180
nota_1  6.5
nota_2  8.3
nota_3  7.1
nota_media  ( nota_1 + nota_2 + nota_3 ) / 3
nombre  "Jorge"
En pseudocódigo, la sintaxis para escribir una asignación es:
<nombre_de_la_variable>  <expresión>
El valor –dato– que se obtiene al evaluar la <expresión> es almacenado en la variable que
se indique. De manera que, las variables nota_1, nota_2, nota_3, nota_media y
nombre almacenarán los valores: 6.5, 8.3, 7.1, 7.3 y "Jorge", respectivamente.
Recuérdese que, en la declaración de una variable, también se puede asignar un valor inicial a
la misma, y que, en la declaración de una constante es obligatorio asignárselo.
EJEMPLO Dadas las declaraciones:
PI = 3.141592
real area, longitud, radio = 5.78
Algunas instrucciones de asignación son:
area  PI * radio ** 2
longitud  2 * PI * radio
Por consiguiente, las variables area y longitud almacenarán los valores:
57.046290 (se obtiene de 3.141592 * 5.78 ** 2)
36.316804 (se obtiene de 2 * 3.141592 * 5.78)
En una asignación, la variable debe ser del mismo tipo que la expresión asignada.
EJEMPLO Por tanto, partiendo de:
cadena te
