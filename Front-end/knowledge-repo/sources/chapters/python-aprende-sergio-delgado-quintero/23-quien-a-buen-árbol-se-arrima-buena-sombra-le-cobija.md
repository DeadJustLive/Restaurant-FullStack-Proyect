# QUIEN A BUEN ÁRBOL SE ARRIMA BUENA SOMBRA LE COBIJA

>>> proverb.lower()
quien a buen árbol se arrima buena sombra le cobija
>>> proverb.swapcase()
QUIEN A BUEN ÁRBOL SE ARRIMA bUENA sOMBRA LE COBIJA
Identificando caracteres
Hay veces que recibimos información textual de distintas fuentes de las que necesitamos
identificar qué tipo de caracteres contienen. Para ello Python nos ofrece un grupo de
funciones.
Veamos algunas de estas funciones:
Lista 8: Detectar si todos los caracteres son letras o
números
>>> R2D2 .isalnum()
True
>>> C3-PO .isalnum()
False
Lista 9: Detectar si todos los caracteres son números
>>> 314 .isnumeric()
True
(continué en la próxima página)
3.3. Cadenas de texto 87

-- 91 of 516 --

Aprende Python
(proviene de la página anterior)
>>> 3.14 .isnumeric()
False
Lista 10: Detectar si todos los caracteres son letras
>>> abc .isalpha()
True
>>> a-b-c .isalpha()
False
Lista 11: Detectar mayúsculas/minúsculas
>>> BIG .isupper()
True
>>> small .islower()
True
>>> First Heading .istitle()
True
3.3.7 Interpolación de cadenas
En este apartado veremos cómo interpolar valores dentro de cadenas de texto utilizando
diferentes formatos. Interpolar (en este contexto) significa sustituir una variable por su valor
dentro de una cadena de texto.
Veamos los estilos que proporciona Python para este cometido:
Nombre Símbolo Soportado
Estilo antiguo % >= Python2
Estilo «nuevo» .format >= Python2.6
«f-strings» f >= Python3.6
Aunque aún podemos encontrar código con el estilo antiguo y el estilo nuevo en el formateo
de cadenas, vamos a centrarnos en el análisis de los «f-strings» que se están utilizando
bastante en la actualidad.
88 Capítulo 3. Tipos de datos

-- 92 of 516 --

Aprende Python
«f-strings»
Los f-strings aparecieron en Python 3.6 y se suelen usar en código de nueva creación. Es
la forma más potente – y en muchas ocasiones más eficiente – de formar cadenas de texto
incluyendo valores de otras variables.
La interpolación en cadenas de texto es un concepto que existe en la gran mayoría de
lenguajes de programación y hace referencia al hecho de sustituir los nombres de variables
por sus valores cuando se construye un «string».
Para indicar en Python que una cadena es un «f-string» basta con precederla de una f e
incluir las variables o expresiones a interpolar entre llaves {...}.
Supongamos que disponemos de los datos de una persona y queremos formar una frase de
bienvenida con ellos:
>>> name = Elon Musk
>>> age = 49
>>> fortune = 43_300
>>> f Me llamo {name}, tengo {age} años y una fortuna de {fortune} millones
Me llamo Elon Musk, tengo 49 años y una fortuna de 43300 millones
Advertencia: Si olvidamos poner la f delante del «string» no conseguiremos sustitución
de variables.
Podría surgir la duda de cómo incluir llaves dentro de la cadena de texto, teniendo en cuenta
que las llaves son símbolos especiales para la interpolación de variables. La respuesta es
duplicar las llaves:
>>> x = 10
>>> f The variable is {{ x = {x} }}
The variable is { x = 10 }
Formateando cadenas
Nivel intermedio
Los «f-strings» proporcionan una gran variedad de opciones de formateado: ancho del
texto, número de decimales, tamaño de la cifra, alineación, etc. Muchas de estas facilidades
se pueden consultar en el artículo Best of Python3.6 f-strings4
Dando formato a valores enteros:
4 Escrito por Nirant Kasliwal en Medium.
3.3. Cadenas de texto 89

-- 93 of 516 --

Aprende Python
>>> mount_height = 3718
>>> f {mount_height:10d}
3718
>>> f {mount_height:010d}
0000003718
Dando formato a otras bases:
>>> value = 0b10010011
>>> f {value}
147
>>> f {value:b}
10010011
>>> value = 0o47622
>>> f {value}
20370
>>> f {value:o}
47622
>>> value = 0xab217
>>> f {value}
700951
>>> f {value:x}
ab217
Dando formato a valores flotantes:
>>> pi = 3.14159265
>>> f {pi:f} # 6 decimales por defecto (se rellenan con ceros si procede)
3.141593
>>> f {pi:.3f}
3.142
>>> f {pi:12f}
3.141593
>>> f {pi:7.2f}
3.14
>>> f {pi:07.2f}
(continué en la próxima página)
90 Capítulo 3. Tipos de datos

-- 94 of 516 --

Aprende Python
(proviene de la página anterior)
0003.14
>>> f {pi:.010f}
3.1415926500
>>> f {pi:e}
3.141593e+00
Alineando valores:
>>> text1 = how
>>> text2 = are
>>> text3 = you
>>> f {text1:<7s}|{text2:^11s}|{text3:>7s}
how | are | you
>>> f {text1:-<7s}|{text2:·^11s}|{text3:->7s}
how----|····are····|----you
Modo «debug»
A partir de Python 3.8, los «f-strings» permiten imprimir el nombre de la variable y su valor,
como un atajo para depurar nuestro código. Para ello sólo tenemos que incluir un símbolo =
después del nombre de la variable:
>>> serie = The Simpsons
>>> imdb_rating = 8.7
>>> num_seasons = 30
>>> f {serie=}
"serie= The Simpsons "
>>> f {imdb_rating=}
imdb_rating=8.7
>>> f {serie[4:]=} # incluso podemos añadir expresiones!
"serie[4:]= Simpsons "
>>> f {imdb_rating / num_seasons=}
imdb_rating / num_seasons=0.29
Ejercicio
3.3. Cadenas de texto 91

-- 95 of 516 --

Aprende Python
Dada la variable:
e = 2.71828
, obtenga los siguientes resultados utilizando «f-strings»:
2.718
2.718280
2.72 # 4 espacios en blanco
2.718280e+00
00002.7183
2.71828 # 12 espacios en blanco
3.3.8 Caracteres Unicode
Python trabaja por defecto con caracteres Unicode. Eso significa que tenemos acceso a la
amplia carta de caracteres que nos ofrece este estándar de codificación.
Supongamos un ejemplo sobre el típico «emoji» de un cohete definido en este cuadro:
Figura 9: Representación Unicode del carácter ROCKET
La función chr() permite representar un carácter a partir de su código:
>>> rocket_code = 0x1F680
>>> rocket = chr(rocket_code)
>>> rocket
La función ord() permite obtener el código (decimal) de un carácter a partir de su
representación:
92 Capítulo 3. Tipos de datos

-- 96 of 516 --

Aprende Python
>>> rocket_code = hex(ord(rocket))
>>> rocket_code
0x1f680
El modificador \N permite representar un carácter a partir de su nombre:
>>> \N{ROCKET}
Ver también:
Tabla ASCII
3.3.9 Casos de uso
Nivel avanzado
Hemos estado usando muchas funciones de objetos tipo «string» (y de otros tipos
previamente). Pero quizás no sabemos aún como podemos descubrir todo lo que podemos
hacer con ellos y los casos de uso que nos ofrece.
Python proporciona una función «built-in» llamada dir() para inspeccionar un determinado
tipo de objeto:
>>> text = This is it!
>>> dir(text)
[ __add__ ,
__class__ ,
__contains__ ,
__delattr__ ,
__dir__ ,
__doc__ ,
__eq__ ,
__format__ ,
__ge__ ,
__getattribute__ ,
__getitem__ ,
__getnewargs__ ,
__gt__ ,
__hash__ ,
__init__ ,
__init_subclass__ ,
__iter__ ,
__le__ ,
__len__ ,
(continué en la próxima página)
3.3. Cadenas de texto 93

-- 97 of 516 --

Aprende Python
(proviene de la página anterior)
__lt__ ,
__mod__ ,
__mul__ ,
__ne__ ,
__new__ ,
__reduce__ ,
__reduce_ex__ ,
__repr__ ,
__rmod__ ,
__rmul__ ,
__setattr__ ,
__sizeof__ ,
__str__ ,
__subclasshook__ ,
capitalize ,
casefold ,
center ,
count ,
encode ,
endswith ,
expandtabs ,
find ,
format ,
format_map ,
index ,
isalnum ,
isalpha ,
isascii ,
isdecimal ,
isdigit ,
isidentifier ,
islower ,
isnumeric ,
isprintable ,
isspace ,
istitle ,
isupper ,
join ,
ljust ,
lower ,
lstrip ,
maketrans ,
partition ,
replace ,
rfind ,
(continué en la próxima página)
94 Capítulo 3. Tipos de datos

-- 98 of 516 --

Aprende Python
(proviene de la página anterior)
rindex ,
rjust ,
rpartition ,
rsplit ,
rstrip ,
split ,
splitlines ,
startswith ,
strip ,
swapcase ,
title ,
translate ,
upper ,
zfill ]
Esto es aplicable tanto a variables como a literales e incluso a tipos de datos (clases)
explícitos:
>>> dir(10)
[ __abs__ ,
__add__ ,
__and__ ,
__bool__ ,
...
imag ,
numerator ,
real ,
to_bytes ]
>>> dir(float)
[ __abs__ ,
__add__ ,
__bool__ ,
__class__ ,
...
hex ,
imag ,
is_integer ,
real ]
3.3. Cadenas de texto 95

-- 99 of 516 --

Aprende Python
EJERCICIOS DE REPASO