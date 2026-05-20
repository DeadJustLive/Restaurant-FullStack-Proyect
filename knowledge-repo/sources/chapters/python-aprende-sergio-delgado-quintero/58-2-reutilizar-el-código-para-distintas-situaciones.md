# 2. Reutilizar el código para distintas situaciones.

Una función viene definida por su nombre, sus parámetros y su valor de retorno. Esta
parametrización de las funciones las convierte en una poderosa herramienta ajustable a las
circunstancias que tengamos. Al invocarla estaremos solicitando su ejecución y obtendremos
unos resultados.1
6.1.1 Definir una función
Para definir una función utilizamos la palabra reservada def seguida del nombre6 de
la función. A continuación aparecerán 0 o más parámetros separados por comas (entre
paréntesis), finalizando la línea con dos puntos : En la siguiente línea empezaría el cuerpo
de la función que puede contener 1 o más sentencias, incluyendo (o no) una sentencia de
retorno con el resultado mediante return.
1 Foto original por Nathan Dumlao en Unsplash.
6 Las reglas aplicadas a nombres de variables también se aplican a nombres de funciones.
210 Capítulo 6. Modularidad

-- 214 of 516 --

Aprende Python
Figura 1: Definición de una función en Python
Advertencia: Prestar especial atención a los dos puntos : porque suelen olvidarse en
la definición de la función.
Hagamos una primera función sencilla que no recibe parámetros:
def say_hello():
print( Hello! )
• Nótese la indentación (sangrado) del cuerpo de la función.
• Los nombres de las funciones siguen las mismas reglas que las variables.
Invocar una función
Para invocar (o «llamar») a una función sólo tendremos que escribir su nombre seguido de
paréntesis. En el caso de la función sencilla (vista anteriormente) se haría así:
>>> def say_hello():
... print( Hello! )
...
>>> say_hello()
Hello!
Como era de esperar, al invocar a esta función obtenemos un mensaje por pantalla, fruto de
la ejecución del cuerpo de la función.
6.1. Funciones 211

-- 215 of 516 --

Aprende Python
Retornar un valor
Las funciones pueden retornar (o «devolver») un valor. Veamos un ejemplo muy sencillo:
>>> def one():
... return 1
...
>>> one()
1
Importante: No confundir return con print(). El valor de retorno de una función nos
permite usarlo fuera de su contexto. El hecho de añadir print() al cuerpo de una función
es algo «coyuntural» y no modifica el resultado de la lógica interna.
Nota: En la sentencia return podemos incluir variables y expresiones, no únicamente
literales.
Pero no sólo podemos invocar a la función directamente, también la podemos integrar en
otras expresiones. Por ejemplo en condicionales:
>>> if one() == 1:
... print( It works! )
... else:
... print( Something is broken )
...
It works!
Si una función no incluye un return de forma explícita, devolverá None de forma implícita:
>>> def empty():
... x = 0
...
>>> print(empty())
None
212 Capítulo 6. Modularidad

-- 216 of 516 --

Aprende Python
6.1.2 Veracidad
Nivel intermedio
Ya hemos hablado ligeramente sobre la comprobación de veracidad en Python.
Vamos a crear una función propia para comprobar la veracidad de distintos objetos del
lenguaje, y así hacernos una mejor idea de qué cosas son evaluadas a verdadero y cuáles a
falso:
>>> def truthiness(obj):
... if obj:
... print(f {obj} is True )
... else:
... print(f {obj} is False )
...
Evaluando a False
Veamos qué «cosas» son evaluadas a False en Python:
>>> truthiness(False)
False is False
>>> truthiness(None)
None is False
>>> truthiness(0)
0 is False
>>> truthiness(0.0)
0.0 is False
>>> truthiness( )
is False
>>> truthiness([])
[] is False
>>> truthiness(())
() is False
>>> truthiness({})
{} is False
(continué en la próxima página)
6.1. Funciones 213

-- 217 of 516 --

Aprende Python
(proviene de la página anterior)
>>> truthiness(set())
set() is False
Importante: El resto de objetos son evaluados a True en Python.
Evaluando a True
Veamos ciertos ejemplos que son evaluados a True en Python:
>>> truthiness(True)
True is True
>>> truthiness(1e-10)
1e-10 is True
>>> truthiness([0])
[0] is True
>>> truthiness(( ,))
( ,) is True
>>> truthiness( )
is True
>>> truthiness( )
is True
6.1.3 Parámetros y argumentos
Si una función no dispusiera de valores de entrada estaría muy limitada en su actuación. Es
por ello que los parámetros nos permiten variar los datos que consume una función para
obtener distintos resultados. Vamos a empezar a crear funciones que reciben parámetros.
En este caso escribiremos una función que recibe un valor numérico y devuelve su raíz
cuadrada:
>>> def sqrt(value):
... return value ** (1/2)
...
(continué en la próxima página)
214 Capítulo 6. Modularidad

-- 218 of 516 --

Aprende Python
(proviene de la página anterior)
>>> sqrt(4)
2.0
Nota: En este caso, el valor 4 es un argumento de la función.
Cuando llamamos a una función con argumentos, los valores de estos argumentos se copian
en los correspondientes parámetros dentro de la función:
Figura 2: Parámetros y argumentos de una función
Truco: La sentencia pass permite «no hacer nada». Es una especie de «placeholder».
Veamos otra función con dos parámetros y algo más de lógica de negocio:2
>>> def _min(a, b):
... if a < b:
... return a
(continué en la próxima página)
2 Término para identificar el «algoritmo» o secuencia de instrucciones derivadas del procesamiento que
corresponda.
6.1. Funciones 215

-- 219 of 516 --

Aprende Python
(proviene de la página anterior)
... else:
... return b
...
>>> _min(7, 9)
7
Ejercicio
Escriba una función en Python que reproduzca lo siguiente:
𝑓 (𝑥, 𝑦) = 𝑥2 + 𝑦2
Ejemplo
• Entrada: 3 y 4
• Salida: 25
Argumentos posicionales
Los argumentos posicionales son aquellos argumentos que se copian en sus
correspondientes parámetros en orden.
Vamos a mostrar un ejemplo definiendo una función que construye una «cpu» a partir de 3
parámetros:
>>> def build_cpu(vendor, num_cores, freq):
... return dict(
... vendor=vendor,
... num_cores=num_cores,
... freq=freq
... )
...
Una posible llamada a la función con argumentos posicionales sería la siguiente:
>>> build_cpu( AMD , 8, 2.7)
{ vendor : AMD , num_cores : 8, freq : 2.7}
Lo que ha sucedido es un mapeo directo entre argumentos y parámetros en el mismo orden
que estaban definidos:
216 Capítulo 6. Modularidad

-- 220 of 516 --

Aprende Python
Parámetro Argumento
vendor AMD
num_cores 8
freq 2.7
Pero es evidente que una clara desventaja del uso de argumentos posicionales es que se
necesita recordar el orden de los argumentos. Un error en la posición de los argumentos
puede causar resultados indeseados:
>>> build_cpu(8, 2.7, AMD )
{ vendor : 8, num_cores : 2.7, freq : AMD }
Argumentos nominales
En esta aproximación los argumentos no son copiados en un orden específico sino que se
asignan por nombre a cada parámetro. Ello nos permite salvar el problema de conocer
cuál es el orden de los parámetros en la definición de la función. Para utilizarlo, basta con
realizar una asignación de cada argumento en la propia llamada a la función.
Veamos la misma llamada que hemos hecho en el ejemplo de construcción de la «cpu» pero
ahora utilizando paso de argumentos nominales:
>>> build_cpu(vendor= AMD , num_cores=8, freq=2.7)
{ vendor : AMD , num_cores : 8, freq : 2.7}
Se puede ver claramente que el orden de los argumentos no influye en el resultado final:
>>> build_cpu(num_cores=8, freq=2.7, vendor= AMD )
{ vendor : AMD , num_cores : 8, freq : 2.7}
Argumentos posicionales y nominales
Python permite mezclar argumentos posicionales y nominales en la llamada a una función:
>>> build_cpu( INTEL , num_cores=4, freq=3.1)
{ vendor : INTEL , num_cores : 4, freq : 3.1}
Pero hay que tener en cuenta que, en este escenario, los argumentos posicionales siempre
deben ir antes que los argumentos nominales. Esto tiene mucho sentido ya que, de hacerlo
así, Python no tendría forma de discernir a qué parámetro corresponde cada argumento:
6.1. Funciones 217

-- 221 of 516 --

Aprende Python
>>> build_cpu(num_cores=4, INTEL , freq=3.1)
File "<stdin>", line 1
SyntaxError: positional argument follows keyword argument
Parámetros por defecto
Es posible especificar valores por defecto en los parámetros de una función. En el caso
de que no se proporcione un valor al argumento en la llamada a la función, el parámetro
correspondiente tomará el valor definido por defecto.
Siguiendo con el ejemplo de la «cpu», podemos asignar 2.0GHz como frecuencia por defecto.
La definición de la función cambiaría ligeramente:
>>> def build_cpu(vendor, num_cores, freq=2.0):
... return dict(
... vendor=vendor,
... num_cores=num_cores,
... freq=freq
... )
...
Llamada a la función sin especificar frecuencia de «cpu»:
>>> build_cpu( INTEL , 2)
{ vendor : INTEL , num_cores : 2, freq : 2.0}
Llamada a la función indicando una frecuencia concreta de «cpu»:
>>> build_cpu( INTEL , 2, 3.4)
{ vendor : INTEL , num_cores : 2, freq : 3.4}
Importante: Los valores por defecto en los parámetros se calculan cuando se define la
función, no cuando se ejecuta.
Ejercicio
Escriba una función factorial que reciba un único parámetro 𝑛 desde línea de comandos
(sys.argv) y devuelva su factorial.
El factorial de un número 𝑛 se define como:
𝑛! = 𝑛 · (𝑛 − 1) · (𝑛 − 2) · . . . · 1
→ Truco: El orden de los factores no altera el producto.
218 Capítulo 6. Modularidad

-- 222 of 516 --

Aprende Python
Ejemplo
• Entrada: 5
• Salida: 120
Modificando parámetros mutables
Nivel avanzado
Hay que tener cuidado a la hora de manejar los parámetros que pasamos a una función ya
que podemos obtener resultados indeseados, especialmente cuando trabajamos con tipos de
datos mutables.
Supongamos una función que añade elementos a una lista que pasamos por parámetro. La
idea es que si no pasamos la lista, ésta siempre empiece siendo vacía. Hagamos una serie de
pruebas pasando alguna lista como segundo argumento:
>>> def buggy(arg, result=[]):
... result.append(arg)
... print(result)
...
>>> buggy( a , [])
[ a ]
>>> buggy( b , [])
[ b ]
>>> buggy( a , [ x , y , z ])
[ x , y , z , a ]
>>> buggy( b , [ x , y , z ])
[ x , y , z , b ]
Aparentemente todo está funcionando de manera correcta, pero veamos qué ocurre en las
siguientes llamadas:
>>> def buggy(arg, result=[]):
... result.append(arg)
... print(result)
...
>>> buggy( a )
[ a ]
(continué en la próxima página)
6.1. Funciones 219

-- 223 of 516 --

Aprende Python
(proviene de la página anterior)
>>> buggy( b ) # Se esperaría [ b ]
[ a , b ]
Obviamente algo no ha funcionado correctamente. Se esperaría que result tuviera una lista
vacía en cada ejecución. Sin embargo esto no sucede por estas dos razones: