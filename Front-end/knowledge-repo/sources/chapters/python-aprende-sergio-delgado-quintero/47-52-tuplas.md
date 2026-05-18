# 5.2 Tuplas

El concepto de tupla es muy similar al de lista. Aunque hay algunas diferencias menores, lo
fundamental es que, mientras una lista es mutable y se puede modificar, una tupla no admite
cambios y por lo tanto, es inmutable.1
1 Foto original de portada por engin akyurt en Unsplash.
5.2. Tuplas 167

-- 171 of 516 --

Aprende Python
5.2.1 Creando tuplas
Podemos pensar en crear tuplas tal y como lo hacíamos con listas, pero usando paréntesis
en lugar de corchetes:
>>> empty_tuple = ()
>>> tenerife_geoloc = (28.46824, -16.25462)
>>> three_wise_men = ( Melchor , Gaspar , Baltasar )
Truco: Al igual que con las listas, las tuplas admiten diferentes tipos de datos: ( a , 1,
True)
Tuplas de un elemento
Hay que prestar especial atención cuando vamos a crear una tupla de un único elemento.
La intención primera sería hacerlo de la siguiente manera:
>>> one_item_tuple = ( Papá Noel )
>>> one_item_tuple
Papá Noel
>>> type(one_item_tuple)
str
Realmente, hemos creado una variable de tipo str (cadena de texto). Para crear una tupla
de un elemento debemos añadir una coma al final:
>>> one_item_tuple = ( Papá Noel ,)
>>> one_item_tuple
( Papá Noel ,)
>>> type(one_item_tuple)
tuple
168 Capítulo 5. Estructuras de datos

-- 172 of 516 --

Aprende Python
Tuplas sin paréntesis
Según el caso, hay veces que nos podemos encontrar con tuplas que no llevan paréntesis.
Quizás no está tan extendido, pero a efectos prácticos tiene el mismo resultado. Veamos
algunos ejemplos de ello:
>>> one_item_tuple = Papá Noel ,
>>> three_wise_men = Melchor , Gaspar , Baltasar
>>> tenerife_geoloc = 28.46824, -16.25462
Advertencia: Aunque está permitido, NUNCA llames tuple a una variable porque
destruirías la función que nos permite crear tuplas. Y tampoco uses nombres derivados
como _tuple o tuple_ ya que no son nombres representativos que identifiquen el propósito
de la variable.
5.2.2 Modificar una tupla
Como ya hemos comentado previamente, las tuplas con estructuras de datos inmutables.
Una vez que las creamos con un valor, no podemos modificarlas. Veamos qué ocurre si lo
intentamos:
>>> three_wise_men = Melchor , Gaspar , Baltasar
>>> three_wise_men[0] = Tom Hanks
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
TypeError: tuple object does not support item assignment
5.2.3 Conversión
Para convertir otros tipos de datos en una tupla podemos usar la función tuple():
>>> shopping = [ Agua , Aceite , Arroz ]
>>> tuple(shopping)
( Agua , Aceite , Arroz )
Esta conversión es válida para aquellos tipos de datos que sean iterables: cadenas de
caracteres, listas, diccionarios, conjuntos, etc. Un ejemplo que no funciona es intentar
convertir un número en una tupla:
5.2. Tuplas 169

-- 173 of 516 --

Aprende Python
>>> tuple(5)
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
TypeError: int object is not iterable
El uso de la función tuple() sin argumentos equivale a crear una tupla vacía:
>>> tuple()
()
Truco: Para crear una tupla vacía, se suele recomendar el uso de () frente a tuple(), no
sólo por ser más pitónico sino por tener (en promedio) un mejor rendimiento en tiempos de
ejecución.
5.2.4 Operaciones con tuplas
Con las tuplas podemos realizar todas las operaciones que vimos con listas salvo las que
conlleven una modificación «in-situ» de la misma:
• reverse()
• append()
• extend()
• remove()
• clear()
• sort()
Truco: Sí es posible aplicar sorted() o reversed() sobre una tupla ya que no estamos
modificando su valor sino creando un nuevo objeto.
5.2.5 Desempaquetado de tuplas
El desempaquetado es una característica de las tuplas que nos permite asignar una tupla
a variables independientes:
Veamos un ejemplo con código:
170 Capítulo 5. Estructuras de datos

-- 174 of 516 --

Aprende Python
Figura 6: Desempaquetado de tuplas
>>> three_wise_men = ( Melchor , Gaspar , Baltasar )
>>> king1, king2, king3 = three_wise_men
>>> king1
Melchor
>>> king2
Gaspar
>>> king3
Baltasar
Python proporciona la función «built-in» divmod() que devuelve el cociente y el resto de
una división usando una única llamada. Lo interesante (para el caso que nos ocupa) es que
se suele utilizar el desempaquetado de tuplas para obtener los valores:
>>> quotient, remainder = divmod(7, 3)
>>> quotient
2
>>> remainder
1
5.2. Tuplas 171

-- 175 of 516 --

Aprende Python
Intercambio de valores
A través del desempaquetado de tuplas podemos llevar a cabo el intercambio de los valores
de dos variables de manera directa:
>>> value1 = 40
>>> value2 = 20
>>> value1, value2 = value2, value1
>>> value1
20
>>> value2
40
Nota: A priori puede parecer que esto es algo «natural», pero en la gran mayoría de lenguajes
de programación no es posible hacer este intercambio de forma «directa» ya que necesitamos
recurrir a una tercera variable «auxiliar» como almacén temporal en el paso intermedio de
traspaso de valores.
Desempaquetado extendido
No tenemos que ceñirnos a realizar desempaquetado uno a uno. También podemos extenderlo
e indicar ciertos «grupos» de elementos mediante el operador *.
Veamos un ejemplo:
>>> ranking = ( G , A , R , Y , W )
>>> head, *body, tail = ranking
>>> head
G
>>> body
[ A , R , Y ]
>>> tail
W
172 Capítulo 5. Estructuras de datos

-- 176 of 516 --

Aprende Python
Desempaquetado genérico
El desempaquetado de tuplas es extensible a cualquier tipo de datos que sea iterable. Veamos
algunos ejemplos de ello.
Sobre cadenas de texto:
>>> oxygen = O2
>>> first, last = oxygen
>>> first, last
( O , 2 )
>>> text = Hello, World!
>>> head, *body, tail = text
>>> head, body, tail
( H , [ e , l , l , o , , , , W , o , r , l , d ], ! )
Sobre listas:
>>> writer1, writer2, writer3 = [ Virginia Woolf , Jane Austen , Mary Shelley ]
>>> writer1, writer2, writer3
( Virginia Woolf , Jane Austen , Mary Shelley )
>>> text = Hello, World!
>>> word1, word2 = text.split()
>>> word1, word2
( Hello, , World! )
5.2.6 ¿Tuplas por comprensión?
Los tipos de datos mutables (listas, diccionarios y conjuntos) sí permiten comprensiones
pero no así los tipos de datos inmutables como cadenas de texto y tuplas.
Si intentamos crear una tupla por comprensión utilizando paréntesis alrededor de la
expresión, vemos que no obtenemos ningún error al ejecutarlo:
>>> myrange = (number for number in range(1, 6))
Sin embargo no hemos conseguido una tupla por comprensión sino un generador:
>>> myrange
<generator object <genexpr> at 0x10b3732e0>
5.2. Tuplas 173

-- 177 of 516 --

Aprende Python
5.2.7 Tuplas vs Listas
Aunque puedan parecer estructuras de datos muy similares, sabemos que las tuplas carecen de
ciertas operaciones, especialmente las que tienen que ver con la modificación de sus valores,
ya que no son inmutables. Si las listas son más flexibles y potentes, ¿por qué íbamos a
necesitar tuplas? Veamos 4 potenciales ventajas del uso de tuplas frente a las listas: