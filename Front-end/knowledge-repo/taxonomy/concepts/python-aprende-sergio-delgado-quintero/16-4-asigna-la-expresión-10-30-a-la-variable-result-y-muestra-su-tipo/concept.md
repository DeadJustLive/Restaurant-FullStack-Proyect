# 4. Asigna la expresión 10 * 3.0 a la variable result y muestra su tipo.

## Fuente
Aprende Python (Cap. 16)

## Contenido
# 4. Asigna la expresión 10 * 3.0 a la variable result y muestra su tipo.

3.1.4 Mutabilidad
Nivel avanzado
Las variables son nombres, no lugares. Detrás de esta frase se esconde la reflexión de que
cuando asignamos un valor a una variable, lo que realmente está ocurriendo es que se hace
apuntar el nombre de la variable a una zona de memoria en el que se representa el objeto
(con su valor).
Si realizamos la asignación de una variable a un valor lo que está ocurriendo es que el nombre
de la variable es una referencia al valor, no el valor en sí mismo:
>>> a = 5
Figura 4: Representación de la asignación de valor a variable
54 Capítulo 3. Tipos de datos

-- 58 of 516 --

Aprende Python
Si ahora «copiamos» el valor de a en otra variable b se podría esperar que hubiera otro
espacio en memoria para dicho valor, pero como ya hemos dicho, son referencias a memoria:
>>> b = a
Figura 5: Representación de la asignación de una variable a otra variable
La función id() nos permite conocer la dirección de memoria6 de un objeto en Python. A
través de ella podemos comprobar que los dos objetos que hemos creado «apuntan» a la
misma zona de memoria:
>>> id(a)
4445989712
>>> id(b)
4445989712
¿Y esto qué tiene que ver con la mutabilidad? Pues se dice, por ejemplo, que un entero es
inmutable ya que a la hora de modificar su valor obtenemos una nueva zona de memoria,
o lo que es lo mismo, un nuevo objeto:
>>> a = 5
>>> id(a)
(continué en la próxima página)
6 Esto es un detalle de implementación de CPython.
3.1. Datos 55

-- 59 of 516 --

Aprende Python
(proviene de la página anterior)
4310690224
>>> a = 7
>>> id(a)
4310690288
Sin embargo, si tratamos con listas, podemos ver que la modificación de alguno de sus
valores no implica un cambio en la posición de memoria de la variable, por lo que se habla
de objetos mutables.
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/lvCyXeL
La característica de que los nombres de variables sean referencias a objetos en memoria es
la que hace posible diferenciar entre objetos mutables e inmutables:
Inmutable Mutable
bool list
int set
float dict
str
tuple
Importante: El hecho de que un tipo de datos sea inmutable significa que no podemos
modificar su valor «in-situ», pero siempre podremos asignarle un nuevo valor (hacerlo apuntar
a otra zona de memoria).
3.1.5 Funciones «built-in»
Nivel intermedio
Hemos ido usando una serie de funciones sin ser especialmente conscientes de ello. Esto se
debe a que son funciones «built-in» o incorporadas por defecto en el propio lenguaje Python.
Tabla 3: Funciones «built-in»
abs() delattr() hash() memoryview() set()
all() dict() help() min() setattr()
any() any() hex() next() slice()
ascii() divmod() id() object() sorted()
bin() enumerate() input() oct() staticmethod()
continué en la próxima página
56 Capítulo 3. Tipos de datos

-- 60 of 516 --

Aprende Python
Tabla 3 – proviene de la página anterior
bool() eval() int() open() str()
breakpoint() exec() isinstance() ord() sum()
bytearray() filter() issubclass() pow() super()
bytes() float() iter() print() tuple()
callable() format() len() property() type()
chr() frozenset() list() range() vars()
classmethod() getattr() locals() repr() zip()
compile() globals() map() reversed() __import__()
complex() hasattr() max() round()
Los detalles de estas funciones se puede consultar en la documentación oficial de Python.
3.1.6 Pidiendo ayuda
En Python podemos pedir ayuda con la función help().
Supongamos que queremos obtener información sobre id. Desde el intérprete de Python
ejecutamos lo siguiente:
>>> help(id)
Help on built-in function id in module builtins:
id(obj, /)
Return the identity of an object.
This is guaranteed to be unique among simultaneously existing objects.
(CPython uses the object s memory address.)
Existe una forma alternativa de obtener ayuda: añadiendo el signo de interrogación ? al
término de búsqueda:
>>> id?
Signature: id(obj, /)
Docstring:
Return the identity of an object.
This is guaranteed to be unique among simultaneously existing objects.
(CPython uses the object s memory address.)
Type: builtin_function_or_method
3.1. Datos 57

-- 61 of 516 --

Aprende Python
