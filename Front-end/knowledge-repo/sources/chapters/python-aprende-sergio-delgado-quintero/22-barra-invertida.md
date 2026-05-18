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
TypeError: str object does not support item assignment
Truco: Existen formas de modificar una cadena de texto que veremos más adelante,
aunque realmente no estemos transformando el original sino creando un nuevo objeto con
las modificaciones.
80 Capítulo 3. Tipos de datos

-- 84 of 516 --

Aprende Python
Advertencia: No hay que confundir las constantes con los tipos de datos inmutables.
Es por ello que las variables que almacenan cadenas de texto, a pesar de ser inmutables,
no se escriben en mayúsculas.
Trocear una cadena
Es posible extraer «trozos» («rebanadas») de una cadena de texto2. Tenemos varias
aproximaciones para ello:
[:] Extrae la secuencia entera desde el comienzo hasta el final. Es una especia de copia de
toda la cadena de texto.
[start:] Extrae desde start hasta el final de la cadena.
[:end] Extrae desde el comienzo de la cadena hasta end menos 1.
[start:end] Extrae desde start hasta end menos 1.
[start:end:step] Extrae desde start hasta end menos 1 haciendo saltos de tamaño step.
Veamos la aplicación de cada uno de estos accesos a través de un ejemplo:
>>> proverb = Agua pasada no mueve molino
>>> proverb[:]
Agua pasada no mueve molino
>>> proverb[12:]
no mueve molino
>>> proverb[:11]
Agua pasada
>>> proverb[5:11]
pasada
>>> proverb[5:11:2]
psd
Importante: El troceado siempre llega a una unidad menos del índice final que hayamos
especificado. Sin embargo el comienzo sí coincide con el que hemos puesto.
2 El término usado en inglés es slice.
3.3. Cadenas de texto 81

-- 85 of 516 --

Aprende Python
Longitud de una cadena
Para obtener la longitud de una cadena podemos hacer uso de len(), una función común a
prácticamente todos los tipos y estructuras de datos en Python:
>>> proberb = Lo cortés no quita lo valiente
>>> len(proverb)
27
>>> empty =
>>> len(empty)
0
Pertenencia de un elemento
Si queremos comprobar que una determinada subcadena se encuentra en una cadena de texto
utilizamos el operador in para ello. Se trata de una expresión que tiene como resultado un
valor «booleano» verdadero o falso:
>>> proverb = Más vale malo conocido que bueno por conocer
>>> malo in proverb
True
>>> bueno in proverb
True
>>> regular in proverb
False
Habría que prestar atención al caso en el que intentamos descubrir si una subcadena no está
en la cadena de texto:
>>> dna_sequence = ATGAAATTGAAATGGGA
>>> not( C in dna_sequence) # Primera aproximación
True
>>> C not in dna_sequence # Forma pitónica
True
82 Capítulo 3. Tipos de datos

-- 86 of 516 --

Aprende Python
Dividir una cadena
Una tarea muy común al trabajar con cadenas de texto es dividirlas por algún tipo
de separador. En este sentido, Python nos ofrece la función split(), que debemos usar
anteponiendo el «string» que queramos dividir:
>>> proverb = No hay mal que por bien no venga
>>> proverb.split()
[ No , hay , mal , que , por , bien , no , venga ]
>>> tools = Martillo,Sierra,Destornillador
>>> tools.split( , )
[ Martillo , Sierra , Destornillador ]
Nota: Si no se especifica un separador, split() usa por defecto cualquier secuencia de
espacios en blanco, tabuladores y saltos de línea.
Aunque aún no lo hemos visto, lo que devuelve split() es una lista (otro tipo de datos en
Python) donde cada elemento es una parte de la cadena de texto original:
>>> game = piedra-papel-tijera
>>> type(game.split( - ))
list
Ejercicio
Sabiendo que la longitud de una lista se calcula igual que la longitud de una cadena de texto,
obtenga el número de palabras que contiene la siguiente cadena de texto:
quote = Before software can be reusable, it first has to be usable
Existe una forma algo más avanzada de dividir una cadena a través del particionado. Para
ello podemos valernos de la función partition() que proporciona Python.
Esta función toma un argumento como separador, y divide la cadena de texto en 3 partes: lo
que queda a la izquiera del separador, el separador en sí mismo y lo que queda a la derecha
del separador:
>>> text = 3 + 4
>>> text.partition( + )
( 3 , + , 4 )
3.3. Cadenas de texto 83

-- 87 of 516 --

Aprende Python
Limpiar cadenas
Cuando leemos datos del usuario o de cualquier fuente externa de información, es bastante
probable que se incluyan en esas cadenas de texto, caracteres de relleno3 al comienzo y
al final. Python nos ofrece la posibilidad de eliminar estos caracteres u otros que no nos
interesen.
La función strip() se utiliza para eliminar caracteres del principio y del final de un
«string». También existen variantes de esta función para aplicarla únicamente al comienzo
o únicamente al final de la cadena de texto.
Supongamos que debemos procesar un fichero con números de serie de un determinado
artículo. Cada línea contiene el valor que nos interesa pero se han «colado» ciertos caracteres
de relleno que debemos limpiar:
>>> serial_number = \n\t \n 48374983274832 \n\n\t \t \n
>>> serial_number.strip()
48374983274832
Nota: Si no se especifican los caracteres a eliminar, strip() usa por defecto cualquier
combinación de espacios en blanco, saltos de línea \n y tabuladores \t.
A continuación vamos a hacer «limpieza» por la izquierda (comienzo) y por la derecha (final)
utilizando la función lstrip() y rstrip() respectivamente:
Lista 6: «Left strip»
>>> serial_number.lstrip()
48374983274832 \n\n\t \t \n
Lista 7: «Right strip»
>>> serial_number.rstrip()
\n\t \n 48374983274832
Como habíamos comentado, también existe la posibilidad de especificar los caracteres que
queremos borrar:
>>> serial_number.strip( \n )
\t \n 48374983274832 \n\n\t \t
Importante: La función strip() no modifica la cadena que estamos usando (algo obvio
3 Se suele utilizar el término inglés «padding» para referirse a estos caracteres.
84 Capítulo 3. Tipos de datos

-- 88 of 516 --

Aprende Python
porque los «strings» son inmutables) sino que devuelve una nueva cadena de texto con las
modificaciones pertinentes.
Realizar búsquedas
Aunque hemos visto que la forma pitónica de saber si una subcadena se encuentra dentro
de otra es a través del operador in, Python nos ofrece distintas alternativas para realizar
búsquedas en cadenas de texto.
Vamos a partir de una variable que contiene un trozo de la canción Mediterráneo de Joan
Manuel Serrat para ejemplificar las distintas opciones que tenemos:
>>> lyrics = Quizás porque mi niñez
... Sigue jugando en tu playa
... Y escondido tras las cañas
... Duerme mi primer amor
... Llevo tu luz y tu olor
... Por dondequiera que vaya
Comprobar si una cadena de texto empieza o termina por alguna subcadena:
>>> lyrics.startswith( Quizás )
True
>>> lyrics.endswith( Final )
False
Encontrar la primera ocurrencia de alguna subcadena:
>>> lyrics.find( amor )
93
>>> lyrics.index( amor ) # Same behaviour?
93
Tanto find() como index() devuelven el índice de la primera ocurrencia de la subcadena
que estemos buscando, pero se diferencian en su comportamiento cuando la subcadena
buscada no existe:
>>> lyrics.find( universo )
-1
>>> lyrics.index( universo )
Traceback (most recent call last):
(continué en la próxima página)
3.3. Cadenas de texto 85

-- 89 of 516 --

Aprende Python
(proviene de la página anterior)
File "<stdin>", line 1, in <module>
ValueError: substring not found
Contabilizar el número de veces que aparece una subcadena:
>>> lyrics.count( mi )
2
>>> lyrics.count( tu )
3
>>> lyrics.count( él )
0
Ejercicio
Dada la siguiente letra5, obtenga la misma pero sustituyendo la palabra voices por sounds:
>>> song = You look so beautiful in this light
... Your silhouette over me
... The way it brings out the blue in your eyes
... Is the Tenerife sea
... And all of the voices surrounding us here
... They just fade out when you take a breath
... Just say the word and I will disappear
... Into the wilderness
Utilice para ello únicamente búsqueda, concatenación y troceado de cadenas de texto.
Reemplazar elementos
Podemos usar la función replace() indicando la subcadena a reemplazar, la subcadena
de reemplazo y cuántas instancias se deben reemplazar. Si no se especifica este último
argumento, la sustitución se hará en todas las instancias encontradas:
>>> proverb = Quien mal anda mal acaba
>>> proverb.replace( mal , bien )
Quien bien anda bien acaba
>>> proverb.replace( mal , bien , 1) # sólo 1 reemplazo
Quien bien anda mal acaba
5 «Tenerife Sea» por Ed Sheeran.
86 Capítulo 3. Tipos de datos

-- 90 of 516 --

Aprende Python
Mayúsculas y minúsculas
Python nos permite realizar variaciones en los caracteres de una cadena de texto para pasarlos
a mayúsculas y/o minúsculas. Veamos las distintas opciones disponibles:
>>> proverb = quien a buen árbol se arrima Buena Sombra le cobija
>>> proverb
quien a buen árbol se arrima Buena Sombra le cobija
>>> proverb.capitalize()
Quien a buen árbol se arrima buena sombra le cobija
>>> proverb.title()
Quien A Buen Árbol Se Arrima Buena Sombra Le Cobija
>>> proverb.upper()