# 3.2 Números

## Fuente
Aprende Python (Cap. 17)

## Contenido
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
el resto de dividir dos números. 
