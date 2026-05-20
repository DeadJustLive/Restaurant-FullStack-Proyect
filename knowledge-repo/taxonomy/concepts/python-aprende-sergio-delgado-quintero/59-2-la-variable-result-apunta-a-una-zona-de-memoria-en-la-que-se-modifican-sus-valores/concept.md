# 2. La variable result apunta a una zona de memoria en la que se modifican sus valores.

## Fuente
Aprende Python (Cap. 59)

## Contenido
# 2. La variable result apunta a una zona de memoria en la que se modifican sus valores.

Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/sBNpVT2
A riesgo de perder el parámetro por defecto, una posible solución sería la siguiente:
>>> def works(arg):
... result = []
... result.append(arg)
... return result
...
>>> works( a )
[ a ]
>>> works( b )
[ b ]
La forma de arreglar el código anterior utilizando un parámetro con valor por defecto sería
utilizar un tipo de dato inmutable y tener en cuenta cuál es la primera llamada:
>>> def nonbuggy(arg, result=None):
... if result is None:
... result = []
... result.append(arg)
... print(result)
...
>>> nonbuggy( a )
[ a ]
>>> nonbuggy( b )
[ b ]
>>> nonbuggy( a , [ x , y , z ])
[ x , y , z , a ]
(continué en la próxima página)
220 Capítulo 6. Modularidad

-- 224 of 516 --

Aprende Python
(proviene de la página anterior)
>>> nonbuggy( b , [ x , y , z ])
[ x , y , z , b ]
Empaquetar/Desempaquetar argumentos
Nivel avanzado
Python nos ofrece la posibilidad de empaquetar y desempaquetar argumentos cuando estamos
invocando a una función, tanto para argumentos posicionales como para argumentos
nominales.
Y de este hecho se deriva que podamos utilizar un número variable de argumentos en
una función, algo que puede ser muy interesante según el caso de uso que tengamos.
Empaquetar/Desempaquetar argumentos posicionales
Si utilizamos el operador * delante del nombre de un parámetro posicional, estaremos
indicando que los argumentos pasados a la función se empaqueten en una tupla.
Veamos un ejemplo en el que vamos a implementar una función para sumar un número
variable de valores. La función que tenemos disponible en Python no cubre este caso:
>>> sum(4, 3, 2, 1)
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
TypeError: sum() takes at most 2 arguments (4 given)
Para resolver esto, hacemos uso del * para empaquetar los argumentos posicionales:
>>> def _sum(*values):
... result = 0
... for value in values: # values es una tupla
... result += arg
... return result
...
>>> _sum(4, 3, 2, 1)
10
Nota: En muchas ocasiones se utiliza args como nombre del parámetro (es una convención).
Existe la posibilidad de usar el asterisco * en la llamada a la función para desempaquetar
los argumentos posicionales:
6.1. Funciones 221

-- 225 of 516 --

Aprende Python
>>> def show_args(*args):
... for arg in args:
... print(f {arg=} )
...
>>> my_args = (1, 2, 3, 4)
>>> show_args(my_args) # sin desempaquetado
arg=(1, 2, 3, 4)
>>> show_args(*my_args) # con desempaquetado
arg=1
arg=2
arg=3
arg=4
Empaquetar/Desempaquetar argumentos nominales
Si utilizamos el operador ** delante del nombre de un parámetro nominal, estaremos
indicando que los argumentos pasados a la función se empaqueten en un diccionario.
Supongamos un ejemplo en el que queremos encontrar la persona con mayor calificación
de un examen. hacemos uso del ** para empaquetar los argumentos nominales:
>>> def best_student(**marks):
... max_mark = -1
... for student, mark in marks.items(): # marks es un diccionario
... if mark > max_mark:
... max_mark = mark
... best_student = student
... return best_student
...
>>> best_student(ana=8, antonio=6, inma=9, javier=7)
inma
Nota: En muchas ocasiones se utiliza kwargs como nombre del parámetro (es una
convención).
Al igual que veíamos previamente, existe la posibilidad de usar doble asterisco ** en la
llamada a la función, para desempaquetar los argumentos nominales:
222 Capítulo 6. Modularidad

-- 226 of 516 --

Aprende Python
>>> def show_kwargs(**kwargs):
... for item in kwargs.items():
... print(f {item=} )
...
>>> my_kwargs = { a : 1, b : 2, c : 3, d : 4}
>>> show_kwargs(**my_kwargs)
item=( a , 1)
item=( b , 2)
item=( c , 3)
item=( d , 4)
Forzando modo de paso de argumentos
Si bien Python nos da flexibilidad para pasar argumentos a nuestras funciones en modo
posicional o nominal, existen opciones para forzar a que dicho paso sea obligatorio en una
determinada modalidad.
Argumentos sólo posicionales
Nivel avanzado
A partir de Python 3.8 se ofrece la posibilidad de obligar a que determinados parámetros de
la función sean pasados sólo por posición.
Para ello, en la definición de los parámetros de la función, tendremos que incluir un parámetro
especial / que delimitará el tipo de parámetros. Así, todos los parámetros a la izquierda del
delimitador estarán obligados a ser posicionales:
Figura 3: Separador para especificar parámetros sólo posicionales
Ejemplo:
6.1. Funciones 223

-- 227 of 516 --

Aprende Python
>>> def sum_power(a, b, /, power=False):
... if power:
... a **= 2
... b **= 2
... return a + b
...
>>> sum_power(3, 4)
7
>>> sum_power(3, 4, True)
25
>>> sum_power(3, 4, power=True)
25
>>> sum_power(a=3, b=4)
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
TypeError: sum_power() got some positional-only arguments passed as keyword␣
˓→arguments: a, b
Argumentos sólo nominales
Nivel avanzado
A partir de Python 3 se ofrece la posibilid
