# 2. If distance less than a half, return floor.

Otherwise, return ceil.
File: ~/aprendepython/<ipython-input-75-5dc166360da1>
Type: function
Importante: Esto no sólo se aplica a funciones propias, sino a cualquier otra función
definida en el lenguaje.
Nota: Si queremos ver el docstring de una función en «crudo» (sin formatear), podemos
usar <function>.__doc__.
228 Capítulo 6. Modularidad

-- 232 of 516 --

Aprende Python
Explicación de parámetros
Como ya se ha visto, es posible documentar una función utilizando un docstring. Pero la
redacción y el formato de esta cadena de texto puede ser muy variada. Existen distintas
formas de documentar una función (u otros objetos)3:
Sphinx docstrings Formato nativo de documentación Sphinx.
Google docstrings Formato de documentación recomendado por Google.
NumPy-SciPy docstrings Combinación de formatos reStructured y Google (usados por
el proyecto NumPy).
Epytext Una adaptación a Python de Epydoc(Java).
Aunque cada uno tienes sus particularidades, todos comparten una misma estructura:
• Una primera línea de descripción de la función.
• A continuación especificamos las características de los parámetros (incluyendo sus
tipos).
• Por último, indicamos si la función retorna un valor y sus características.
Aunque todos los formatos son válidos, nos centraremos en Sphinx docstrings al ser
el que viene mejor integrado con la documentación Sphinx. Google docstrings y Numpy
docstrings también son ampliamente utilizados, lo único es que necesitan de un módulo
externo denominado Napoleon para que se puedan incluir en la documentación Sphinx.
Sphinx
Sphinx es una herramienta para generar documentación e incluye un módulo «built-in»
denominado autodoc el cual permite la autogeneración de documentación a partir de los
«docstrings» definidos en el código.
Veamos el uso de este formato en la documentación de la siguiente función «dummy»:
>>> def my_power(x, n):
... Calculate x raised to the power of n.
...
... :param x: number representing the base of the operation
... :type x: int
... :param n: number representing the exponent of the operation
... :type n: int
...
... :return: :math:Bx^nB
... :rtype: int
(continué en la próxima página)
3 Véase Docstring Formats.
6.1. Funciones 229

-- 233 of 516 --

Aprende Python
(proviene de la página anterior)
...
... result = 1
... for _ in range(n):
... result *= x
... return result
...
Dentro del «docstring» podemos escribir con sintaxis reStructured Text – véase por ejemplo
la expresión matemática en el tag :return: – lo que nos proporciona una gran flexibilidad.
Nota: La plataforma Read the Docs aloja la documentación de gran cantidad de proyectos.
En muchos de los casos se han usado «docstrings» con el formato Sphinx visto anteriormente.
Anotación de tipos
Nivel intermedio
Las anotaciones de tipos o type-hints5 se introdujeron en Python 3.5 y permiten indicar
tipos para los parámetros de una función así como su valor de retorno (aunque también
funcionan en creación de variables).
Veamos un ejemplo en el que creamos una función para dividir una cadena de texto por la
posición especificada en el parámetro:
>>> def ssplit(text: str, split_pos: int) -> tuple:
... return text[:split_pos], text[split_pos:]
...
>>> ssplit( Always remember us this way , 15)
( Always remember , us this way )
Como se puede observar, vamos añadiendo los tipos después de cada parámetro utilizando
: como separador. En el caso del valor de retorno usamos el símbolo ->
Quizás la siguiente ejecución pueda sorprender:
>>> ssplit([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 5)
([1, 2, 3, 4, 5], [6, 7, 8, 9, 10])
Efectivamente como habrás visto, no hemos obtenido ningún error, a pesar de que
estamos pasando como primer argumento una lista en vez de una cadena de texto. Esto
ocurre porque lo que hemos definido es una anotación de tipo, no una declaración de tipo.
Existen herramientas como mypy que sí se encargan de chequear estas situaciones.
5 Conocidos como «type hints» en terminología inglesa.
230 Capítulo 6. Modularidad

-- 234 of 516 --

Aprende Python
Valores por defecto
Al igual que ocurre en la definición ordinaria de funciones, cuando usamos anotaciones de
tipos también podemos indicar un valor por defecto para los parámetros.
Veamos la forma de hacerlo continuando con el ejemplo anterior:
>>> def ssplit(text: str, split_pos: int = -1) -> tuple:
... if split_pos == -1:
... split_pos = len(text) // 2
... return text[:split_pos], text[split_pos:]
...
>>> ssplit( Always remember us this way )
( Always rememb , er us this way )
Simplemente añadimos el valor por defecto después de indicar el tipo.
Nota: Las anotaciones de tipos son una herramienta muy potente y que, usada de
forma adecuada, permite complementar la documentación de nuestro código y aclarar ciertos
aspectos, que a priori, pudieran parecer confusos. Su aplicación estará en función de la
necesidad detectada por parte del equipo de desarrollo.
6.1.5 Tipos de funciones
Nivel avanzado
Funciones interiores
Está permitido definir una función dentro de otra función:
>>> def validation_test(text):
... def is_valid_char(char):
... return char in xyz
... checklist = []
... for char in text:
... checklist.append(is_valid_char(char))
... return sum(checklist) / len(text)
...
>>> validation_test( zxyzxxyz )
1.0
(continué en la próxima página)
6.1. Funciones 231

-- 235 of 516 --

Aprende Python
(proviene de la página anterior)
>>> validation_test( abzxyabcdz )
0.4
>>> validation_test( abc )
0.0
Clausuras
Una clausura (del término inglés «closure») establece el uso de una función interior que se
genera dinámicamente y recuerda los valores de los argumentos con los que fue creada:
>>> def make_multiplier_of(n):
... def multiplier(x):
... return x * n
... return multiplier
...
>>> m3 = make_multiplier_of(3)
>>> m5 = make_multiplier_of(5)
>>> type(m3)
function
>>> m3(7) # 7 * 3
21
>>> type(m5)
function
>>> m5(8) # 8 * 5
40
Importante: En una clausura retornamos una función, no una llamada a la función.
232 Capítulo 6. Modularidad

-- 236 of 516 --

Aprende Python
Funciones anónimas «lambda»
Una función lambda tiene las siguientes propiedades: