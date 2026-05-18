# 2. Reutilizar el código para distintas situaciones.

## Fuente
Aprende Python (Cap. 58)

## Contenido
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
(continué en la próxima pági
