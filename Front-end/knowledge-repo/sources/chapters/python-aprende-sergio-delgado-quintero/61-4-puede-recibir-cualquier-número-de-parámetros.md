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
Nota: A diferencia de las funciones ordinarias, los generadores tienen la capacidad de
«recordar» su estado para recuperarlo en la siguiente iteración y continuar devolviendo
nuevos valores.
Funciones generadoras
Las funciones generadoras se escriben como funciones ordinarias con el matiz de incorporar
la sentencia yield que sustituye, de alguna manera, a return. Esta sentencia devuelve el
valor indicado y, a la vez, «congela» el estado de la función para subsiguientes ejecuciones.
Veamos un ejemplo en el que escribimos una función generadora de números pares:
>>> def evens(lim):
... for i in range(0, lim + 1, 2):
... yield i
...
>>> type(evens)
function
>>> evens_gen = evens(20) # returns generator
(continué en la próxima página)
6.1. Funciones 237

-- 241 of 516 --

Aprende Python
(proviene de la página anterior)
>>> type(evens_gen)
generator
Una vez creado el generador, ya podemos iterar sobre él:
>>> for even in evens_gen:
... print(even, end= )
...
0 2 4 6 8 10 12 14 16 18 20
De forma más «directa», podemos iterar sobre la propia llamada a la función generadora:
>>> for even in evens(20):
... print(even, end= )
...
0 2 4 6 8 10 12 14 16 18 20
Si queremos «explicitar» la lista de valores que contiene un generador, podemos hacerlo de
la siguiente manera:
>>> list(evens(20))
[0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
Importante: Un detalle muy importante sobre los generadores es que «se agotan». Es decir,
una vez que ya hemos consumido todos sus elementos ya no obtendremos nuevos valores.
Expresiones generadoras
Una expresión generadora es sintácticamente muy similar a una lista por comprensión,
pero utilizamos paréntesis en vez de corchetes. Se podría ver como una versión acortada
de una función generadora.
Podemos tratar de reproducir el ejemplo visto en funciones generadoras en el que creamos
números pares hasta el 20:
>>> evens_gen = (i for i in range(0, 20, 2))
>>> type(evens_gen)
generator
>>> for i in evens_gen:
... print(i, end= )
(continué en la próxima página)
238 Capítulo 6. Modularidad

-- 242 of 516 --

Aprende Python
(proviene de la página anterior)
...
0 2 4 6 8 10 12 14 16 18
Nota: Las expresiones generadoras admiten condiciones y anidamiento de bucles, tal y
como se vio con las listas por comprensión.
Ejercicio
Escriba una función generadora que devuelva los 100 primeros números enteros elevados
al cuadrado.
Decoradores
Hay situaciones en las que necesitamos modificar el comportamiento de funciones existentes
pero sin alterar su código. Para estos casos es muy útil usar decoradores.
Un decorador es una función que recibe como parámetro una función y devuelve otra
función. Se podría ver como un caso particular de clausura.
El esqueleto básico de un decorador es el siguiente:
>>> def my_decorator(func):
... def wrapper(*args, **kwargs):
... # some code before calling func
... return func(*args, **kwargs)
... # some code after calling func
... return wrapper
...
Elemento Descripción
my_decorator Nombre del decorador
wrapper Función interior (convención de nombre)
func Función a decorar (convención de nombre)
*args Argumentos posicionales (convención de nombre)
**kwargs Argumentos nominales (convención de nombre)
Veamos un ejemplo de decorador que convierte el resultado de la función a binario:
>>> def res2bin(func):
... def wrapper(*args, **kwargs):
(continué en la próxima página)
6.1. Funciones 239

-- 243 of 516 --

Aprende Python
(proviene de la página anterior)
... result = func(*args, **kwargs)
... return bin(result)
... return wrapper
...
Ahora definimos una función ordinaria (que usaremos más adelante) y que computa 𝑥𝑛:
>>> def power(x: int, n: int) -> int:
... return x ** n
...
>>> power(2, 3)
8
>>> power(4, 5)
1024
Ahora aplicaremos el decorador definido previamente res2bin() sobre la función ordinaria
power(). Se dice que que res2bin() es la función decoradora y que power() es la función
decorada:
>>> decorated_power = res2bin(power)
>>> decorated_power(2, 3)
0b1000
>>> decorated_power(4, 5)
0b10000000000
Usando @ para decorar
Python nos ofrece un «syntactic sugar» para simplificar la aplicación de los decoradores a
través del operador @ justo antes de la definición de la función que queremos decorar:
>>> @res2bin
... def power(x: int, n: int):
... return x ** n
...
>>> power(2, 3)
0b1000
>>> power(4, 5)
0b10000000000
240 Capítulo 6. Modularidad

-- 244 of 516 --

Aprende Python
Múltiples decoradores
Podemos aplicar más de un decorador a cada función. Para ejemplificarlo vamos a crear dos
decoradores muy sencillos:
>>> def plus5(func):
... def wrapper(*args, **kwargs):
... result = func(*args, **kwargs)
... return result + 5
... return wrapper
...
>>> def div2(func):
... def wrapper(*args, **kwargs):
... result = func(*args, **kwargs)
... return result // 2
... return wrapper
...
Ahora aplicaremos ambos decoradores sobre una función que realiza el producto de dos
números:
>>> @plus5
... @div2
... def prod(a, b):
... return a * b
...
>>> prod(4, 3)
11
>>> ((4 * 3) // 2) + 5
11
Cuando tenemos varios decoradores, se aplican desde afuera hacia adentro (modelo
capa de cebolla). Eso sí, hay que tener en cuenta que la ejecución de un decorador puede
depender de otro decorador.
Si anotamos los decoradores podemos ver exactamente cuál es el orden de ejecución:
>>> def plus5(func):
... def wrapper(*args, **kwargs):
... print( plus5-A )
... result = func(*args, **kwargs) # ——————┐
... print( plus5-B ) # |
... return result + 5 # |
... return wrapper # |
(continué en la próxima página)
6.1. Funciones 241

-- 245 of 516 --

Aprende Python
(proviene de la página anterior)
... # |
... # |
... def div2(func): # |
... def wrapper(*args, **kwargs): # |
... print( div2-A ) # ┐—————┐
... result = func(*args, **kwargs)
... print( div2-B )
... return result // 2
... return wrapper
Ahora ejecutamos la función decorada:
>>> prod(4, 3)
plus5-A # decorador plus5
div2-A # decorador div2
div2-B # decorador div2
plus5-B # decorador plus5
11
Ejercicio
Escriba un decorador llamado fabs() que convierta a su valor absoluto los dos primeros
parámetros de la función que decora y devuelva el resultado de aplicar dicha función a sus
dos argumentos. El valor absoluto de un número se obtiene con la función abs().
A continuación probar el decorador con una función fprod() que devuelva el producto de
dos valores, jugando con números negativos y positivos.
¿Podrías extender el decorador para que tuviera en cuenta un número indeterminado de
argumentos posicionales?
Ejemplo
• Entrada: -3 y 7
• Salida: 21
242 Capítulo 6. Modularidad

-- 246 of 516 --

Aprende Python
Funciones recursivas
La recursividad es el mecanismo por el cual una función se llama a sí misma:
>>> def call_me():
... return call_me()
...
>>> call_me()
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
File "<stdin>", line 2, in call_me
File "<stdin>", line 2, in call_me
File "<stdin>", line 2, in call_me
[Previous line repeated 996 more times]
RecursionError: maximum recursion depth exceeded
Advertencia: Podemos observar que existe un número máximo de llamadas recursivas.
Python controla esta situación por nosotros, ya que, de no ser así, podríamos llegar a
consumir los recursos del sistema.
Veamos ahora un ejemplo más real en el que computar el enésimo término de la Sucesión de
Fibonacci utilizando una función recursiva:
>>> def fibonacci(n):
... if n == 0:
... return 0
... if n == 1:
... return 1
... return fibonacci(n - 1) + fibonacci(n - 2)
...
>>> fibonacci(10)
55
>>> fibonacci(20)
6765
6.1. Funciones 243

-- 247 of 516 --

Aprende Python
Función generadora recursiva
Si tratamos de extender el ejemplo anterior de Fibonacci para obtener todos los términos de
la sucesión hasta un límite, pero con la filosofía recursiva, podríamos plantear el uso de una
función generadora:
>>> def fibonacci():
... def _fibonacci(n):
... if n == 0:
... return 0
... if n == 1:
... return 1
... return _fibonacci(n - 1) + _fibonacci(n - 2)
...
... n = 0
... while True:
... yield _fibonacci(n)
... n += 1
...
>>> fib = fibonacci()
>>> type(fib)
generator
>>> for _ in range(10):
... print(next(fib))
...
0
1
1
2
3
5
8
13
21
34
Ejercicio
Escriba una función recursiva que calcule el factorial de un número:
𝑛! = 𝑛 · (𝑛 − 1) · (𝑛 − 2) · . . . · 1
Ejemplo
244 Capítulo 6. Modularidad

-- 248 of 516 --

Aprende Python
• Entrada: 5
• Salida: 120
6.1.6 Espacios de nombres
Como bien indica el Zen de Python:
Namespaces are one honking great idea – let’s do more of those!
Que vendría a traducirse como: «Los espacios de nombres son una gran idea – hagamos
más de eso». Los espacios de nombres permiten definir ámbitos o contextos en los que
agrupar nombres de objetos.
Los espacios de nombres proporcionan un mecanismo de empaquetamiento, de tal forma que
podamos tener incluso nombres iguales que no hacen referencia al mismo objeto (siempre y
cuando estén en ámbitos distintos).
Cada función define su propio espacio de nombres y es diferente del espacio de nombres
global aplicable a todo nuestro programa.
Figura 6: Espacio de nombres global vs espacios de nombres de funciones
6.1. Funciones 245

-- 249 of 516 --

Aprende Python
Acceso a variables globales
Cuando una variable se define en el espacio de nombres global podemos hacer uso de ella con
total transparencia dentro del ámbito de las funciones del programa:
>>> language = castellano
>>> def catalonia():
... print(f {language=} )
...
>>> language
castellano
>>> catalonia()
language= castellano
Creando variables locales
En el caso de que asignemos un valor a una variable global dentro de una función, no
estaremos modificando ese valor. Por el contrario, estaremos creando una variable en el
espacio de nombres local:
>>> language = castellano
>>> def catalonia():
... language = catalan
... print(f {language=} )
...
>>> language
castellano
>>> catalonia()
language= catalan
>>> language
castellano
246 Capítulo 6. Modularidad

-- 250 of 516 --

Aprende Python
Forzando modificación global
Python nos permite modificar una variable definida en un espacio de nombres global dentro
de una función. Para ello debemos usar el modificador global:
>>> language = castellano
>>> def catalonia():
... global language
... language = catalan
... print(f {language=} )
...
>>> language
castellano
>>> catalonia()
language= catalan
>>> language
catalan
Advertencia: El uso de global no se considera una buena práctica ya que puede inducir
a confusión y tener efectos colaterales indeseados.
Contenido de los espacios de nombres
Python proporciona dos funciones para acceder al contenido de los espacios de nombres:
locals() Devuelve un diccionario con los contenidos del espacio de nombres local.
globals() Devuelve un diccionario con los contenidos del espacio de nombres global.
>>> language = castellano
>>> def catalonia():
... language = catalan
... print(f {locals()=} )
...
>>> language
castellano
>>> catalonia()
(continué en la próxima página)
6.1. Funciones 247

-- 251 of 516 --

Aprende Python
(proviene de la página anterior)
locals()={ language : catalan }
>>> globals()
{ __name__ : __main__ ,
__doc__ : Automatically created module for IPython interactive environment ,
__package__ : None,
__loader__ : None,
__spec__ : None,
__builtin__ : <module builtins (built-in)>,
__builtins__ : <module builtins (built-in)>,
_ih : [ ,
"language = castellano ",
"def catalonia():\n language = catalan \n print(f {locals()=} )\n ",
language ,
catalonia() ,
globals() ],
_oh : {3: castellano },
_dh : [ /Users/sdelquin ],
In : [ ,
"language = castellano ",
"def catalonia():\n language = catalan \n print(f {locals()=} )\n ",
language ,
catalonia() ,
globals() ],
Out : {3: castellano },
get_ipython : <bound method InteractiveShell.get_ipython of <IPython.terminal.
˓→interactiveshell.TerminalInteractiveShell object at 0x10e70c2e0>>,
exit : <IPython.core.autocall.ExitAutocall at 0x10e761070>,
quit : <IPython.core.autocall.ExitAutocall at 0x10e761070>,
_ : castellano ,
__ : ,
___ : ,
Prompts : IPython.terminal.prompts.Prompts,
Token : Token,
MyPrompt : __main__.MyPrompt,
ip : <IPython.terminal.interactiveshell.TerminalInteractiveShell at 0x10e70c2e0>,
_i : catalonia() ,
_ii : language ,
_iii : "def catalonia():\n language = catalan \n print(f {locals()=} )\n ␣
˓→ ",
_i1 : "language = castellano ",
language : castellano ,
_i2 : "def catalonia():\n language = catalan \n print(f {locals()=} )\n
˓→",
catalonia : <function __main__.catalonia()>,
(continué en la próxima página)
248 Capítulo 6. Modularidad

-- 252 of 516 --

Aprende Python
(proviene de la página anterior)
_i3 : language ,
_3 : castellano ,
_i4 : catalonia() ,
_i5 : globals() }
EJERCICIOS DE REPASO