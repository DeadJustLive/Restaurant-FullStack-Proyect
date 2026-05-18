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
cadena telefono
entero numero
Las siguientes instrucciones son incorrectas:

-- 64 of 180 --

Libro de Algoritmos de “Abrirllave.com” 65 / 180
telefono  948347788
numero  "5"
Sin embargo, entre valores numéricos –enteros y reales– se puede realizar una conversión de
tipos.
EJEMPLO Habiendo declarado las variables:
real a = 6.4, b = 3.1, c, d
entero e = 5, f = 2, g, h, i
Después de las instrucciones:
c  e / f
d  a / f
g  e / f
h  a / f
i  b / a
Las variables c, d, g, h e i contendrán, respectivamente, los valores:
2.5 (se obtiene de 5 / 2)
3.2 (se obtiene de 6.4 / 2)
2 (se produce un truncamiento de la parte decimal del número 2.5)
3 (se produce un truncamiento de la parte decimal del número 3.2)
0 (se produce un truncamiento de la parte decimal del número 0.484375)
Una asignación permite cambiar el valor –dato– almacenado en una variable.
EJEMPLO Si se ha definido la variable:
entero numero = 6
Tras la instrucción:
numero  numero * -3
El valor –dato– almacenado en la variable numero ha pasado a ser el:

-- 65 of 180 --

Libro de Algoritmos de “Abrirllave.com” 66 / 180
-18 (se obtiene de 6 * -3)
Como se puede observar, en esta ocasión, a la variable numero se le asigna el resultado de
evaluar una expresión, en donde la propia variable también aparece.
Un error frecuente que suelen cometer programadores principiantes, es incluir en una
expresión, una variable que no tenga ningún valor –dato– almacenado, es decir, una variable a
la que previamente no se le haya asignado ningún valor.
EJEMPLO A partir de la declaración:
real n1, n2
En la siguiente instrucción:
n1  n2 * 72
La expresión n2 * 72 no se puede evaluar, ya que, ¿cuál es valor de n2? Tiene un valor
indeterminado y, en consecuencia, la instrucción se ejecutará mal.
EJEMPLO Dadas las declaraciones:
entero n1 = -7, n2 = 8, n3
logico negativo
Las siguientes asignaciones también son incorrectas:
n1 + 1  n2 (ERROR de sintaxis)
negativo  n3 < 0 (¿cuál es el valor de n3?)
Ha aparecido el símbolo reservado flecha izquierda ().
 Separadora de la variable y de la expresión asignada en una instrucción
de asignación.
6.2. Instrucción de salida
Una instrucción de salida –o simplemente salida– consiste en llevar hacia el exterior los
valores –datos– obtenidos de la evaluación de una lista de expresiones. Normalmente, los
datos son enviados a la salida estándar –la pantalla–, pero, también existen otros dispositivos
de salida (la impresora, el plotter...).

-- 66 of 180 --

Libro de Algoritmos de “Abrirllave.com” 67 / 180
En pseudocódigo, la sintaxis de una instrucción de salida es:
escribir( <expresión_1>, <expresión_2>, ..., <expresión_n> )
También se puede escribir como:
escribir( <lista_de_expresiones> )
EJEMPLO Partiendo de las variables:
cadena nombre = "Timoteo"
entero edad = 27, hijos = 2
Al escribir:
escribir( nombre, " tiene ", edad, " años." )
escribir( nombre, " tiene ", hijos, " hijos." )
Por pantalla aparecerá:
EJEMPLO Obsérvese la diferencia de escribir:
escribir( nombre, "tiene", edad, "años." )
escribir( "nombre tiene hijos hijos." )
En este caso, por pantalla se verá:
De modo que, se debe ser muy cuidadoso a la hora de escribir la lista de expresiones de una
salida.

-- 67 of 180 --

Libro de Algoritmos de “Abrirllave.com” 68 / 180
EJEMPLO Si se han definido:
real altura, area_triangulo, base
Al escribir:
base  1.1
altura  2.2
area_triangulo  base * altura / 2
escribir( "El área del triángulo es: ", area_triangulo )
Por pantalla se mostrará:
EJEMPLO El mismo resultado se puede obtener escribiendo:
base  1.1
altura  2.2
escribir( "El área del triángulo es: ", base * altura / 2 )
En este caso, se ha prescindido de la variable area_triangulo, reduciéndose así el número
de instrucciones.
6.3. Instrucción de entrada
Una instrucción de entrada –o simplemente entrada– consiste en asignar a una o más
variables, uno o más valores –datos– recibidos desde el exterior. Normalmente, los datos son
recogidos desde la entrada estándar –el teclado–, pero, también existen otros dispositivos de
entrada (el ratón, el escáner...).
En pseudocódigo, la sintaxis de una instrucción de entrada es:
leer( <nombre_de_la_variable_1>,
<nombre_de_la_variable_2>,
...,
<nombre_de_la_variable_n> )

-- 68 of 180 --

Libro de Algoritmos de “Abrirllave.com” 69 / 180
También se puede escribir como:
leer( <lista_de_variables> )
EJEMPLO Partiendo de las variables:
cadena nombre, apellidos
entero edad
Para cada una de ellas se puede recoger un valor –dato– desde el teclado, escribiendo:
leer( nombre )
leer( apellidos )
leer( edad )
Otra posibilidad es:
leer( nombre, apellidos, edad )
EJEMPLO Si se han declarado:
cadena nombre
real numero
Al escribir:
escribir( "Introduzca su nombre: " )
leer( nombre )
escribir( "Introduzca un número real: " )
leer( numero )
escribir( nombre, ", el doble de ", numero, " es: ", numero * 2 )
Por pantalla se verá algo parecido a:

-- 69 of 180 --

Libro de Algoritmos de “Abrirllave.com” 70 / 180
Juan y 31.4 son valores –datos– leídos desde el teclado, es decir, introducidos por el usuario, y
almacenados en las variables nombre y numero, respectivamente.
Han aparecido dos nuevas palabras reservadas: escribir y leer.
Además, han vuelto a aparecer los símbolos reservados abrir paréntesis “(” y cerrar paréntesis
“)”, con un significado distinto.
Símbolos reservados
Símbolo Descripción
() Albergan las expresiones de una instrucción de salida.
() Albergan las variables de una instrucción de entrada.
Y el símbolo coma (,).
, Separadora de las expresiones de una instrucción de salida.
, Separadora de las variables de una instrucción de entrada.
Ejercicios resueltos
 Valores almacenados en la memoria después de asignaciones
 Salida por pantalla
 Instrucciones necesarias

-- 70 of 180 --

Libro de Algoritmos de “Abrirllave.com” 71 / 180
Capítulo 7
Estructura de un algoritmo en
pseudocódigo
La estructura de un algoritmo sirve para organizar a los elementos que aparecen en él. En
pseudocódigo, todos los algoritmos tienen la misma estructura, la cual viene definida por tres
secciones:
 Cabecera.
 Declaraciones.
 Cuerpo.
7.1. Cabecera de un algoritmo
En la cabecera de un algoritmo se debe indicar el nombre –identificador– asignado al mismo.
La sintaxis es:
algoritmo <nombre_del_algoritmo>
EJEMPLO Si se quiere diseñar el algoritmo de un programa que:
1º) Pida por teclado el radio (dato real) de una circunferencia.
2º) Calcule el área de la circunferencia.
3º) Muestre por pantalla el resultado (dato real).
Nota: Área de una circunferencia =  * radio2
El algoritmo puede llamarse Area_de_una_circunferencia. Por tanto, en la cabecera
se puede escribir:
algoritmo Area_de_una_circunferencia

-- 71 of 180 --

Libro de Algoritmos de “Abrirllave.com” 72 / 180
Nota: A menos que se especifique lo contrario, en todos los problemas del libro se va a
suponer que el usuario introduce por teclado correctamente los datos que se le pidan, es
decir, si se le pide, por ejemplo, un dato de tipo real, no introducirá un dato de otro tipo.
7.2. Declaraciones de un algoritmo
En esta sección se declaran las constantes, los tipos de datos y las variables que se usan en el
algoritmo. La sintaxis es:
[ constantes
<declaraciones_de_constantes> ]
[ tipos_de_datos
<declaraciones_de_tipos_de_datos> ]
[ variables
<declaraciones_de_variables> ]
Para resolver el problema planteado en el ejemplo anterior, es necesario declarar una
constante y dos variables:
constantes
PI = 3.141592
variables
real area, radio
En este caso, no es necesario declarar ningún tipo de dato.
7.3. Cuerpo de un algoritmo
En el cuerpo se escriben todas las instrucciones del algoritmo. La sintaxis es:
inicio
<instrucción_1>
<instrucción_2>
...
<instrucción_n>
fin
inicio y fin son palabras reservadas que marcan el principio y final de la sección cuerpo,
que es donde está el bloque de instrucciones principal del algoritmo.

-- 72 of 180 --

Libro de Algoritmos de “Abrirllave.com” 73 / 180
El cuerpo del algoritmo Area_de_una_circunferencia es:
inicio
escribir( "Introduzca radio: " )
leer( radio )
area  PI * radio ** 2
escribir( "El área de la circunferencia es: ", area )
fin
Por pantalla se verá algo parecido a:
EJEMPLO El mismo resultado se puede obtener escribiendo:
inicio
escribir( "Introduzca radio: " )
leer( radio )
escribir( "El área de la circunferencia es: ",
PI * radio ** 2 )
fin
Véase que la variable area no es necesaria. Por tanto, dicha variable no se definiría.
EJEMPLO Todavía se puede reducir más el código del algoritmo, escribiendo:
inicio
escribir( "Introduzca radio: " )
leer( radio )
escribir( "El área de la circunferencia es: ",
3.141592 * radio ** 2 )
fin

-- 73 of 180 --

Libro de Algoritmos de “Abrirllave.com” 74 / 180
Así que, tampoco es necesario declarar la constante PI, reduciéndose todavía más el código.
En resumen, el algoritmo completo es:
algoritmo Area_de_una_circunferencia
variables
real radio
inicio
escribir( "Introduzca radio: " )
leer( radio )
escribir( "El área de la circunferencia es: ",
3.141592 * radio ** 2 )
fin
La sintaxis completa para escribir un algoritmo en pseudocódigo es:
algoritmo <nombre_del_algoritmo>
[ constantes
<declaraciones_de_constantes> ]
[ tipos_de_datos
<declaraciones_de_tipos_de_datos> ]
[ variables
<declaraciones_de_variables> ]
inicio
<bloque_de_instrucciones>
fin
Han aparecido seis nuevas palabras reservadas: algoritmo, constantes, fin, inicio,
tipos_de_datos y variables.
Las instrucciones de los algoritmos vistos hasta ahora se ejecutan secuencialmente, una detrás
de otra. Además, también el código de la sección de declaraciones se ejecuta en orden. Por
ejemplo, dados los siguientes algoritmos: