# ABCDEFGHIJKLMNOPQRSTUVWXYZ

## Fuente
Aprende Python (Cap. 75)

## Contenido
# ABCDEFGHIJKLMNOPQRSTUVWXYZ

>>> string.ascii_letters
abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
>>> string.digits
0123456789
(continué en la próxima página)
1 Foto original de portada por Steve Johnson en Unsplash.
296 Capítulo 7. Procesamiento de texto

-- 300 of 516 --

Aprende Python
(proviene de la página anterior)
>>> string.hexdigits
0123456789abcdefABCDEF
>>> string.octdigits
01234567
>>> string.punctuation
!"#$%&\ ()*+,-./:;<=>?@[\\]^_B{|}~
>>> string.printable
0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!"#$%&\ ()*+,-./:;<=>?
˓→@[\\]^_B{|}~ \t\n\r\x0b\x0c
>>> string.whitespace
\t\n\r\x0b\x0c
Ejercicio
Dada una cadena de texto, compruebe si todos sus caracteres son dígitos ASCII. Ignore los
espacios en blanco.
Ejemplo
• Entrada: This is it
• Salida: True
7.1.2 Plantillas
El módulo string también nos permite usar plantillas con interpolación de variables. Algo
similar a los f-strings pero con otro tipo de sintaxis.
Lo primero es definir la plantilla. Las variables que queramos interporlar deben ir precedidas
del signo dólar $:
from string import Template
tmpl = Template( $lang is the best programming language in the $place! )
Ahora podemos realizar la sustitución con los valores que nos interesen:
>>> tmpl.substitute(lang= Python , place= World )
Python is the best programming language in the World!
(continué en la próxima página)
7.1. string 297

-- 301 of 516 --

Aprende Python
(proviene de la página anterior)
>>> tmpl.substitute({ lang : Python , place : World })
Python is the best programming language in the World!
Hay que prestar atención cuando el identificador de variable está seguido por algún carácter
que, a su vez, puede formar parte del identificador. En este caso hay que utilizar llaves para
evitar la ambigüedad:
>>> tmpl = Template( You won several ${price}s )
>>> tmpl.substitute(price= phone )
You won several phones
Sustitución segura
En el caso de que alguna de las variables que estamos interpolando no exista o no tenga
ningún valor, obtendremos un error al sustituir:
>>> tmpl = Template( $lang is the best programming language in the $place! )
>>> tmpl.substitute(lang= Python )
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
KeyError: place
Para ello Python nos ofrece el método safe_substitute() que no emite error si alguna
variable no es especificada:
>>> tmpl.safe_substitute(lang= Python )
Python is the best programming language in the $place!
Casos de uso
A primera vista podría parecer que este sistema de plantillas no aporta gran ventaja sobre
los f-strings que ya hemos visto. Sin embargo hay ocasiones en los que puede resultar muy
útil.
La mayoría de estas situaciones tienen que ver con la oportunidad de definir el «string».
Si en el momento de crear la plantilla aún no están disponibles las variables de sustitución,
podría interesar utilizar la estrategia que nos proporciona este módulo.
Supongamos un ejemplo en el que tenemos una estructura de «url» y queremos únicamente
sustituir una parte de ella. Para no tener que repetir la cadena de texto completa en un
«f-string», podríamos seguir este enfoque:
298 Capítulo 7. Procesamiento de texto

-- 302 of 516 --

Aprende Python
>>> urlbase = Template( https://python.org/3/library/$module.html )
>>> for module in ( string , re , difflib ):
... url = urlbase.substitute(module=module)
... print(url)
...
https://python.org/3/library/string.html
https://python.org/3/library/re.html
https://python.org/3/library/difflib.html
7.1. string 299

-- 303 of 516 --

Aprende Python
300 Capítulo 7. Procesamiento de texto

-- 304 of 516 --
