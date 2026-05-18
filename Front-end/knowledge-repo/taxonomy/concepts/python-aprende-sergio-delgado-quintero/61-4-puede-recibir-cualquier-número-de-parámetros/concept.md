# 4. Puede recibir cualquier número de parámetros.

## Fuente
Aprende Python (Cap. 61)

## Contenido
# 4. Puede recibir cualquier número de parámetros.

Veamos un primer ejemplo de función «lambda» que nos permite contar el número de
palabras de una cadena de texto:
>>> num_words = lambda t: len(t.strip().split())
>>> type(num_words)
function
>>> num_words
<function __main__.<lambda>(t)>
>>> num_words( hola socio vamos a ver )
5
Veamos otro ejemplo en el que mostramos una tabla con el resultado de aplicar el «and»
lógico mediante una función «lambda» que ahora recibe dos parámetros:
>>> logic_and = lambda x, y: x & y
>>> for i in range(2):
... for j in range(2):
... print(f {i} & {j} = {logic_and(i, j)} )
...
0 & 0 = 0
0 & 1 = 0
1 & 0 = 0
1 & 1 = 1
Las funciones «lambda» son bastante utilizadas como argumentos a otras funciones. Un
ejemplo claro de ello es la función sorted que tiene un parámetro opcional key donde se
define la clave de ordenación.
Veamos cómo usar una función anónima «lambda» para ordenar una tupla de pares
longitud-latitud:
>>> geoloc = (
... (15.623037, 13.258358),
(continué en la próxima página)
6.1. Funciones 233

-- 237 of 516 --

Aprende Python
(proviene de la página anterior)
... (55.147488, -2.667338),
... (54.572062, -73.285171),
... (3.152857, 115.327724),
... (-40.454262, 172.318877)
)
>>> # Ordenación por longitud (primer elemento de la tupla)
>>> sorted(geoloc)
[(-40.454262, 172.318877),
(3.152857, 115.327724),
(15.623037, 13.258358),
(54.572062, -73.285171),
(55.147488, -2.667338)]
>>> # Ordenación por latitud (segundo elemento de la tupla)
>>> sorted(geoloc, key=lambda t: t[1])
[(54.572062, -73.285171),
(55.147488, -2.667338),
(15.623037, 13.258358),
(3.152857, 115.327724),
(-40.454262, 172.318877)]
Enfoque funcional
Como se comentó en la introducción, Python es un lenguaje de programación
multiparadigma. Uno de los paradigmas menos explotados en este lenguaje es la
programación funcional4.
Python nos ofrece 3 funciones que encajan verdaderamente bien en este enfoque: map(),
filter() y reduce().
map()
Esta función aplica otra función sobre cada elemento de un iterable. Supongamos que
queremos aplicar la siguiente función:
𝑓 (𝑥) = 𝑥2
2 ∀𝑥 ∈ [1, 10]
>>> def f(x):
... return x**2 / 2
(continué en la próxima página)
4 Definición de Programación funcional en Wikipedia.
234 Capítulo 6. Modularidad

-- 238 of 516 --

Aprende Python
Figura 5: Rutinas muy enfocadas a programación funcional
(proviene de la página anterior)
...
>>> data = range(1, 11)
>>> map_gen = map(f, data)
>>> type(map_gen)
map
>>> list(map_gen)
[0.5, 2.0, 4.5, 8.0, 12.5, 18.0, 24.5, 32.0, 40.5, 50.0]
Aplicando una función anónima «lambda»…
>>> list(map(lambda x: x**2 / 2, data))
[0.5, 2.0, 4.5, 8.0, 12.5, 18.0, 24.5, 32.0, 40.5, 50.0]
Importante: map() devuelve un generador, no directamente una lista.
filter()
Esta función selecciona aquellos elementos de un iterable que cumplan una determinada
condición. Supongamos que queremos seleccionar sólo aquellos números impares dentro de
un rango:
>>> def odd_number(x):
... return x % 2 == 1
(continué en la próxima página)
6.1. Funciones 235

-- 239 of 516 --

Aprende Python
(proviene de la página anterior)
...
>>> data = range(1, 21)
>>> filter_gen = filter(odd_number, data)
>>> type(filter_gen)
filter
>>> list(filter_gen)
[1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
Aplicando una función anónima «lambda»…
>>> list(filter(lambda x: x % 2 == 1, data))
[1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
Importante: filter() devuelve un generador, no directamente una lista.
reduce()
Para poder usar esta función debemos usar el módulo functools. Nos permite aplicar una
función dada sobre todos los elementos de un iterable de manera acumulativa. O dicho en
otras palabras, nos permite reducir una función sobre un conjunto de valores. Supongamos
que queremos realizar el producto de una serie de valores aplicando este enfoque:
>>> from functools import reduce
>>> def mult_values(a, b):
... return a * b
...
>>> data = range(1, 6)
>>> reduce(mult_values, data) # ((((1 * 2) * 3) * 4) * 5)
120
Aplicando una función anónima «lambda»…
>>> reduce(lambda x, y: x * y, data)
120
236 Capítulo 6. Modularidad

-- 240 of 516 --

Aprende Python
Consejo: Por cuestiones de legibilidad del código, se suelen preferir las listas por
comprensión a funciones como map() o filter(), aunque cada problema tiene sus propias
características y sus soluciones más adecuadas.
Generadores
Un generador es un objeto que nos permite iterar sobre una secuencia de valores con la
particularidad de no tener que crear explícitamente dicha secuencia. Esta propiedad los hace
idóneos para situaciones en las que el tamaño de las secuencias podría tener un impacto
negativo en el consumo de memoria.
De hecho ya hemos visto algunos generadores y los hemos usado de forma directa. Un ejemplo
es range() que ofrece la posibilidad de crear secuencias de números.
Básicamente existen dos implementaciones de generadores:
• Funciones generadoras.
• Expresiones generadoras.
Nota: A diferencia de las funciones ordinarias, los generadores tienen la capacid
