# 3.2 Números

En esta sección veremos los tipos de datos númericos que ofrece Python centrándonos en
booleanos, enteros y flotantes.1
3.2.1 Booleanos
George Boole es considerado como uno de los fundadores del campo de las ciencias de la
computación y fue el creador del Álgebra de Boole que da lugar, entre otras estructuras
algebraicas, a la Lógica binaria. En esta lógica las variables sólo pueden tomar dos valores
discretos: verdadero o falso.
El tipo de datos bool proviene de lo explicado anteriormente y admite dos posibles valores:
1 Foto original de portada por Brett Jordan en Unsplash.
58 Capítulo 3. Tipos de datos

-- 62 of 516 --

Aprende Python
• True que se corresponde con verdadero (y también con 1 en su representación
numérica).
• False que se corresponde con falso (y también con 0 en su representación numérica).
Veamos un ejemplo de su uso:
>>> is_opened = True
>>> is_opened
True
>>> has_sugar = False
>>> has_sugar
False
La primera variable is_opened está representando el hecho de que algo esté abierto, y al
tomar el valor True podemos concluir que sí. La segunda variable has_sugar nos indica si
una bebida tiene azúcar; dado que toma el valor False inferimos que no lleva azúcar.
Atención: Tal y como se explicó en este apartado, los nombres de variables son
«case-sensitive». De igual modo el tipo booleano toma valores True y False con la
primera letra en mayúsculas. De no ser así obtendríamos un error sintáctico.
>>> is_opened = true
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
NameError: name true is not defined
>>> has_sugar = false
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
NameError: name false is not defined
3.2. Números 59

-- 63 of 516 --

Aprende Python
3.2.2 Enteros
Los números enteros no tienen decimales pero sí pueden contener signo y estar expresados
en alguna base distinta de la usual (base 10).
Literales enteros
Veamos algunos ejemplos de números enteros:
>>> 8
8
>>> 0
0
>>> 08
File "<stdin>", line 1
08
^
SyntaxError: invalid token
>>> 99
99
>>> +99
99
>>> -99
-99
>>> 3000000
3000000
>>> 3_000_000
3000000
Dos detalles a tener en cuenta:
• No podemos comenzar un número entero por 0.
• Python permite dividir los números enteros con guiones bajos _ para clarificar su
lectura/escritura. A efectos prácticos es como si esos guiones bajos no existieran.
Operaciones con enteros
A continuación se muestra una tabla con las distintas operaciones sobre enteros que podemos
realizar en Python:
Tabla 4: Operaciones con enteros en Python
Operador Descripción Ejemplo Resultado
+ Suma 3 + 9 12
continué en la próxima página
60 Capítulo 3. Tipos de datos

-- 64 of 516 --

Aprende Python
Tabla 4 – proviene de la página anterior
Operador Descripción Ejemplo Resultado
- Resta 6 - 2 4
* Multiplicación 5 * 5 25
/ División flotante 9 / 2 4.5
// División entera 9 // 2 4
% Módulo 9 % 4 1
** Exponenciación 2 ** 4 16
Veamos algunas pruebas de estos operadores:
>>> 2 + 8 + 4
14
>>> 4 ** 4
256
>>> 7 / 3
2.3333333333333335
>>> 7 // 3
2
>>> 6 / 0
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
ZeroDivisionError: division by zero
Es de buen estilo de programación dejar un espacio entre cada operador. Además hay que
tener en cuenta que podemos obtener errores dependiendo de la operación (más bien de los
operandos) que estemos utilizando, como es el caso de la división por cero.
Igualmente es importante tener en cuenta la prioridad de los distintos operadores:
Prioridad Operador
1 (mayor) ()
2 **
3 -a +a
4 * / // %
5 (menor) + -
Ejemplos de prioridad de operadores:
>>> 2 ** 2 + 4 / 2
6.0
>>> 2 ** (2 + 4) / 2
32.0
(continué en la próxima página)
3.2. Números 61

-- 65 of 516 --

Aprende Python
(proviene de la página anterior)
>>> 2 ** (2 + 4 / 2)
16.0
Asignación aumentada
Python nos ofrece la posibilidad de escribir una asignación aumentada mezclando la
asignación y un operador.
Figura 6: Asignación aumentada en Python
Supongamos que disponemos de 100 vehículos en stock y que durante el pasado mes se han
vendido 20 de ellos. Veamos cómo sería el código con asignación tradicional vs. asignación
aumentada:
Lista 1: Asignación tradicional
>>> total_cars = 100
>>> sold_cars = 20
>>> total_cars = total_cars - sold_cars
>>> total_cars
80
Lista 2: Asignación aumentada
>>> total_cars = 100
>>> sold_cars = 20
>>> total_cars -= sold_cars
>>> total_cars
80
Estas dos formas son equivalentes a nivel de resultados y funcionalidad, pero obviamente
tienen diferencias de escritura y legibilidad. De este mismo modo, podemos aplicar un formato
compacto al resto de operaciones:
62 Capítulo 3. Tipos de datos

-- 66 of 516 --

Aprende Python
>>> random_number = 15
>>> random_number += 5
>>> random_number
20
>>> random_number *= 3
>>> random_number
60
>>> random_number //= 4
>>> random_number
15
>>> random_number **= 1
>>> random_number
15
Módulo
La operación módulo (también llamado resto), cuyo símbolo en Python es %, se define como
el resto de dividir dos números. Veamos un ejemplo para enteder bien su funcionamiento:
Figura 7: Operador «módulo» en Python
>>> dividendo = 17
>>> divisor = 5
>>> cociente = dividendo // divisor # división entera
>>> resto = dividendo % divisor
>>> cociente
3
>>> resto
2
3.2. Números 63

-- 67 of 516 --

Aprende Python
Exponenciación
Para elevar un número a otro en Python utilizamos el operador de exponenciación **:
>>> 4 ** 3
64
>>> 4 * 4 * 4
64
Se debe tener en cuenta que también podemos elevar un número entero a un número
decimal. En este caso es como si estuviéramos haciendo una raíz2. Por ejemplo:
41
2 = 40.5 = √4 = 2
Hecho en Python:
>>> 4 ** 0.5
2.0
Ejercicio
pycheck boot quadratic
Valor absoluto
Python ofrece la función abs() para obtener el valor absoluto de un número:
>>> abs(-1)
1
>>> abs(1)
1
>>> abs(-3.14)
3.14
>>> abs(3.14)
3.14
2 No siempre es una raíz cuadrada porque se invierten numerador y denominador.
64 Capítulo 3. Tipos de datos

-- 68 of 516 --

Aprende Python
Límite de un entero
Nivel avanzado
¿Cómo de grande puede ser un int en Python? La respuesta es de cualquier tamaño. Por
poner un ejemplo, supongamos que queremos representar un centillón. Este valor viene a ser
un «1» seguido por ¡600 ceros! ¿Será capaz Python de almacenarlo?
>>> centillion = 10 ** 600
>>> centillion
1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
Nota: En muchos lenguajes tratar con enteros tan largos causaría un «integer overflow».
No es el caso de Python que puede manejar estos valores sin problema.
3.2.3 Flotantes
Los números en punto flotante3 tienen parte decimal. Veamos algunos ejemplos de
flotantes en Python.
3 Punto o coma flotante es una notación científica usada por computadores.
3.2. Números 65

-- 69 of 516 --

Aprende Python
Lista 3: Distintas formas de escribir el flotante 4.0
>>> 4.0
4.0
>>> 4.
4.0
>>> 04.0
4.0
>>> 04.
4.0
>>> 4.000_000
4.0
>>> 4e0 # 4.0 * (10 ** 0)
4.0
Conversión de tipos
El hecho de que existan distintos tipos de datos en Python (y en el resto de lenguajes de
programación) es una ventaja a la hora de representar la información del mundo real de
la mejor manera posible. Pero también se hace necesario buscar mecanismos para convertir
unos tipos de datos en otros.
Conversión implícita
Cuando mezclamos enteros, booleanos y flotantes, Python realiza automáticamente una
conversión implícita (o promoción) de los valores al tipo de «mayor rango». Veamos algunos
ejemplos de esto:
>>> True + 25
26
>>> 7 * False
0
>>> True + False
1
>>> 21.8 + True
22.8
>>> 10 + 11.3
21.3
Podemos resumir la conversión implícita en la siguiente tabla:
66 Capítulo 3. Tipos de datos

-- 70 of 516 --

Aprende Python
Tipo 1 Tipo 2 Resultado
bool int int
bool float float
int float float
Se puede ver claramente que la conversión numérica de los valores booleanos es:
• True 1
• False 0
Conversión explícita
Aunque más adelante veremos el concepto de función, desde ahora podemos decir que
existen una serie de funciones para realizar conversiones explícitas de un tipo a otro:
bool() Convierte el tipo a booleano.
int() Convierte el tipo a entero.
float() Convierte el tipo a flotante.
Veamos algunos ejemplos de estas funciones:
>>> bool(1)
True
>>> bool(0)
False
>>> int(True)
1
>>> int(False)
0
>>> float(1)
1.0
>>> float(0)
0.0
>>> float(True)
1.0
>>> float(False)
0.0
En el caso de que usemos la función int() sobre un valor flotante, nos retorna su parte
baja:
𝑖𝑛𝑡(𝑥) =⌊︀ 𝑥⌋︀
Por ejemplo:
3.2. Números 67

-- 71 of 516 --

Aprende Python
>>> int(3.1)
3
>>> int(3.5)
3
>>> int(3.9)
3
Para obtener el tipo de una variable podemos hacer uso de la función type():
>>> is_raining = False
>>> type(is_raining)
bool
>>> sound_level = 35
>>> type(sound_level)
int
>>> temperature = 36.6
>>> type(temperature)
float
Igualmente existe la posibilidad de comprobar el tipo que tiene una variable mediante la
función isinstance():
>>> isinstance(is_raining, bool)
True
>>> isinstance(sound_level, int)
True
>>> isinstance(temperature, float)
True
Ejercicio
pycheck boot sin_approx
Errores de aproximación
Nivel intermedio
Supongamos el siguiente cálculo:
>>> (19 / 155) * (155 / 19)
0.9999999999999999
68 Capítulo 3. Tipos de datos

-- 72 of 516 --

Aprende Python
Debería dar 1.0, pero no es así puesto que la representación interna de los valores en coma
flotante sigue el estándar IEEE 754 y estamos trabajando con aritmética finita.
Aunque existen distintas formas de solventar esta limitación, de momento veremos una de las
más sencillas utilizando la función «built-in» round() que nos permite redondear un número
flotante a un número determinado de decimales:
>>> pi = 3.14159265359
>>> round(pi)
3
>>> round(pi, 1)
3.1
>>> round(pi, 2)
3.14
>>> round(pi, 3)
3.142
>>> round(pi, 4)
3.1416
>>> round(pi, 5)
3.14159
Para el caso del error de aproximación que nos ocupa:
>>> result = (19 / 155) * (155 / 19)
>>> round(result, 1)
1.0
Prudencia: round() aproxima al valor más cercano, mientras que int() obtiene siepre
el entero «por abajo».
Límite de un flotante
A diferencia de los enteros, los números flotantes sí que tienen un límite en Python. Para
descubrirlo podemos ejecutar el siguiente código:
>>> import sys
>>> sys.float_info.min
2.2250738585072014e-308
>>> sys.float_info.max
1.7976931348623157e+308
3.2. Números 69

-- 73 of 516 --

Aprende Python
3.2.4 Bases
Nivel intermedio
Los valores numéricos con los que estamos acostumbrados a trabajar están en base 10 (o
decimal). Esto indica que disponemos de 10 «símbolos» para representar las cantidades. En
este caso del 0 al 9.
Pero también es posible representar números en otras bases. Python nos ofrece una serie
de prefijos y funciones para este cometido.
Base binaria
Cuenta con 2 símbolos para representar los valores: 0 y 1.
Prefijo: 0b
>>> 0b1001
9
>>> 0b1100
12
Función: bin()
>>> bin(9)
0b1001
>>> bin(12)
0b1100
Base octal
Cuenta con 8 símbolos para representar los valores: 0, 1, 2, 3, 4, 5, 6 y 7.
Prefijo: 0o
>>> 0o6243
3235
>>> 0o1257
687
Función: oct()
>>> oct(3235)
0o6243
>>> oct(687)
0o1257
70 Capítulo 3. Tipos de datos

-- 74 of 516 --

Aprende Python
Base hexadecimal
Cuenta con 16 símbolos para representar los valores: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E
y F.
Prefijo: 0x
>>> 0x7F2A
32554
>>> 0x48FF
18687
Función: hex()
>>> hex(32554)
0x7f2a
>>> hex(18687)
0x48ff
Nota: Las letras para la representación hexadecimal no atienden a mayúsculas y minúsculas.