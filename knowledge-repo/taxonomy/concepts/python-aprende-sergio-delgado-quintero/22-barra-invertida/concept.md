# Barra invertida

## Fuente
Aprende Python (Cap. 22)

## Contenido
# Barra invertida

>>> msg = Capítulo \\ Sección \\ Encabezado
>>> print(msg)
Capítulo \ Sección \ Encabezado
Nota: Al utilizar la función print() es cuando vemos realmente el resultado de utilizar los
caracteres escapados.
Expresiones literales
Nivel intermedio
Hay situaciones en las que nos interesa que los caracteres especiales pierdan ese significado y
poder usarlos de otra manera. Existe un modificar de cadena que proporciona Python para
tratar el texto en bruto. Es el llamado «raw data» y se aplica anteponiendo una r a la cadena
de texto.
Veamos algunos ejemplos:
>>> text = abc\ndef
>>> print(text)
abc
def
>>> text = r abc\ndef
>>> print(text)
abc\ndef
>>> text = a\tb\tc
>>> print(text)
a b c
(continué en la próxima página)
76 Capítulo 3. Tipos de datos

-- 80 of 516 --

Aprende Python
(proviene de la página anterior)
>>> text = r a\tb\tc
>>> print(text)
a\tb\tc
Consejo: El modificador r es muy utilizado para la escritura de expresiones regulares.
3.3.4 Más sobre print()
Hemos estado utilizando la función print() de forma sencilla, pero admite algunos
parámetros interesantes:
1 >>> msg1 = ¿Sabes por qué estoy acá?
2 >>> msg2 = Porque me apasiona
3
4 >>> print(msg1, msg2)
5 ¿Sabes por qué estoy acá? Porque me apasiona
6
7 >>> print(msg1, msg2, sep= | )
8 ¿Sabes por qué estoy acá?|Porque me apasiona
9
10 >>> print(msg2, end= !! )
11 Porque me apasiona!!
Línea 4: Podemos imprimir todas las variables que queramos separándolas por comas.
Línea 7: El separador por defecto entre las variables es un espacio, podemos cambiar el
carácter que se utiliza como separador entre cadenas.
Línea 10: El carácter de final de texto es un salto de línea, podemos cambiar el carácter
que se utiliza como final de texto.
3.3.5 Leer datos desde teclado
Los programas se hacen para tener interacción con el usuario. Una de las formas de
interacción es solicitar la entrada de datos por teclado. Como muchos otros lenguajes de
programación, Python también nos ofrece la posibilidad de leer la información introducida
por teclado. Para ello se utiliza la función input():
>>> name = input( Introduzca su nombre: )
Introduzca su nombre: Sergio
(continué en la próxima página)
3.3. Cadenas de texto 77

-- 81 of 516 --

Aprende Python
(proviene de la página anterior)
>>> name
Sergio
>>> type(name)
str
>>> age = input( Introduzca su edad: )
Introduzca su edad: 41
>>> age
41
>>> type(age)
str
Nota: La función input() siempre nos devuelve un objeto de tipo cadena de texto o str.
Tenerlo muy en cuenta a la hora de trabajar con números, ya que debemos realizar una
conversión explícita.
Ejercicio
Escriba un programa en Python que lea por teclado dos números enteros y muestre por
pantalla el resultado de realizar las operaciones básicas entre ellos.
Ejemplo
• Valores de entrada 7 y 4.
• Salida esperada:
7+4=11
7-4=3
7*4=28
7/4=1.75
Consejo: Aproveche todo el potencial que ofrece print() para conseguir la salida esperada.
Advertencia: Aunque está permitido, NUNCA llames input a una variable porque
destruirías la función que nos permite leer datos desde teclado. Y tampoco uses nombres
derivados como _input o input_ ya que no son nombres representativos que identifiquen
el propósito de la variable.
78 Capítulo 3. Tipos de datos

-- 82 of 516 --

Aprende Python
3.3.6 Operaciones con «strings»
Combinar cadenas
Podemos combinar dos o más cadenas de texto utilizando el operador +:
>>> proverb1 = Cuando el río suena
>>> proverb2 = agua lleva
>>> proverb1 + proverb2
Cuando el río suenaagua lleva
>>> proverb1 + , + proverb2 # incluimos una coma
Cuando el río suena, agua lleva
Repetir cadenas
Podemos repetir dos o más cadenas de texto utilizando el operador *:
>>> reaction = Wow
>>> reaction * 4
WowWowWowWow
Obtener un carácter
Los «strings» están indexados y cada carácter tiene su propia posición. Para obtener un
único carácter dentro de una cadena de texto es necesario especificar su índice dentro de
corchetes [...].
Figura 8: Indexado de una cadena de texto
Veamos algunos ejemplos de acceso a caracteres:
3.3. Cadenas de texto 79

-- 83 of 516 --

Aprende Python
>>> sentence = Hola, Mundo
>>> sentence[0]
H
>>> sentence[-1]
o
>>> sentence[4]
,
>>> sentence[-5]
M
Truco: Nótese que existen tanto índices positivos como índices negativos para acceder
a cada carácter de la cadena de texto. A priori puede parecer redundante, pero es muy útil
en determinados casos.
En caso de que intentemos acceder a un índice que no existe, obtendremos un error por fuera
de rango:
>>> sentence[50]
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
IndexError: string index out of range
Advertencia: Téngase en cuenta que el indexado de una cadena de texto siempre
empieza en 0 y termina en una unidad menos de la longitud de la cadena.
Las cadenas de texto son tipos de datos inmutables. Es por ello que no podemos modificar
un carácter directamente:
>>> song = Hey Jude
>>> song[4] = D
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
TypeError: s
