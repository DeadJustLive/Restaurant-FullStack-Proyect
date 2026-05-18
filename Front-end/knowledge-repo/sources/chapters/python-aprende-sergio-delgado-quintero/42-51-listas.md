# 5.1 Listas

Las listas permiten almacenar objetos mediante un orden definido y con posibilidad
de duplicados. Las listas son estructuras de datos mutables, lo que significa que podemos
añadir, eliminar o modificar sus elementos.1
5.1.1 Creando listas
Una lista está compuesta por cero o más elementos. En Python debemos escribir estos
elementos separados por comas y dentro de corchetes. Veamos algunos ejemplos de listas:
>>> empty_list = []
>>> languages = [ Python , Ruby , Javascript ]
>>> fibonacci = [0, 1, 1, 2, 3, 5, 8, 13]
>>> data = [ Tenerife , { cielo : limpio , temp : 24}, 3718, (28.2933947, -16.
˓→5226597)]
Nota: Una lista puede contener tipos de datos heterogéneos, lo que la hace una estructura
1 Foto original de portada por Mike Arney en Unsplash.
138 Capítulo 5. Estructuras de datos

-- 142 of 516 --

Aprende Python
de datos muy versátil.
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/Ofiiare
Advertencia: Aunque está permitido, NUNCA llames list a una variable porque
destruirías la función que nos permite crear listas. Y tampoco uses nombres derivados
como _list o list_ ya que no son nombres representativos que identifiquen el propósito
de la variable.
Ejercicio
Cree una lista con las 5 ciudades que más le gusten.
5.1.2 Conversión
Para convertir otros tipos de datos en una lista podemos usar la función list():
>>> # conversión desde una cadena de texto
>>> list( Python )
[ P , y , t , h , o , n ]
Si nos fijamos en lo que ha pasado, al convertir la cadena de texto Python se ha creado
una lista con 6 elementos, donde cada uno de ellos representa un carácter de la cadena.
Podemos extender este comportamiento a cualquier otro tipo de datos que permita ser iterado
(iterables).
Otro ejemplo interesante de conversión puede ser la de los rangos. En este caso queremos
obtener una lista explícita con los valores que constituyen el rango [0, 9]:
>>> list(range(10))
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
5.1. Listas 139

-- 143 of 516 --

Aprende Python
Lista vacía
Existe una manera particular de usar list() y es no pasarle ningún argumento. En este
caso estaremos queriendo convertir el «vacío» en una lista, con lo que obtendremos una lista
vacía:
>>> list()
[]
Truco: Para crear una lista vacía, se suele recomendar el uso de [] frente a list(), no
sólo por ser más pitónico sino por tener (en promedio) un mejor rendimiento en tiempos de
ejecución.
5.1.3 Operaciones con listas
Obtener un elemento
Igual que en el caso de las cadenas de texto, podemos obtener un elemento de una lista a
través del índice (lugar) que ocupa. Veamos un ejemplo:
>>> shopping = [ Agua , Huevos , Aceite ]
>>> shopping[0]
Agua
>>> shopping[1]
Huevos
>>> shopping[2]
Aceite
>>> shopping[-1] # acceso con índice negativo
Aceite
El índice que usemos para acceder a los elementos de una lista tiene que estar comprendido
entre los límites de la misma. Si usamos un índice antes del comienzo o después del final
obtendremos un error (excepción):
>>> shopping = [ Agua , Huevos , Aceite ]
>>> shopping[3]
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
(continué en la próxima página)
140 Capítulo 5. Estructuras de datos

-- 144 of 516 --

Aprende Python
(proviene de la página anterior)
IndexError: list index out of range
>>> shopping[-5]
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
IndexError: list index out of range
Trocear una lista
El troceado de listas funciona de manera totalmente análoga al troceado de cadenas. Veamos
algunos ejemplos:
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> shopping[0:3]
[ Agua , Huevos , Aceite ]
>>> shopping[:3]
[ Agua , Huevos , Aceite ]
>>> shopping[2:4]
[ Aceite , Sal ]
>>> shopping[-1:-4:-1]
[ Limón , Sal , Aceite ]
>>> # Equivale a invertir la lista
>>> shopping[::-1]
[ Limón , Sal , Aceite , Huevos , Agua ]
En el troceado de listas, a diferencia de lo que ocurre al obtener elementos, no debemos
preocuparnos por acceder a índices inválidos (fuera de rango) ya que Python los restringirá
a los límites de la lista:
>>> shopping
[ Agua , Huevos , Aceite , Sal , Limón ]
>>> shopping[10:]
[]
>>> shopping[-100:2]
[ Agua , Huevos ]
(continué en la próxima página)
5.1. Listas 141

-- 145 of 516 --

Aprende Python
(proviene de la página anterior)
>>> shopping[2:100]
[ Aceite , Sal , Limón ]
Importante: Ninguna de las operaciones anteriores modifican la lista original, simplemente
devuelven una lista nueva.
Invertir una lista
Python nos ofrece, al menos, tres mecanismos para invertir los elementos de una lista:
Conservando la lista original: Opción 1: Mediante troceado de listas con step negativo:
>>> shopping
[ Agua , Huevos , Aceite , Sal , Limón ]
>>> shopping[::-1]
[ Limón , Sal , Aceite , Huevos , Agua ]
Opción 2: Mediante la función reversed():
>>> shopping
[ Agua , Huevos , Aceite , Sal , Limón ]
>>> list(reversed(shopping))
[ Limón , Sal , Aceite , Huevos , Agua ]
Modificando la lista original: Utilizando la función reverse() (nótese que es sin «d» al
final):
>>> shopping
[ Agua , Huevos , Aceite , Sal , Limón ]
>>> shopping.reverse()
>>> shopping
[ Limón , Sal , Aceite , Huevos , Agua ]
142 Capítulo 5. Estructuras de datos

-- 146 of 516 --

Aprende Python
Añadir al final de la lista
Una de las operaciones más utilizadas en listas es añadir elementos al final de las mismas.
Para ello Python nos ofrece la función append(). Se trata de un método destructivo que
modifica la lista original:
>>> shopping = [ Agua , Huevos , Aceite ]
>>> shopping.append( Atún )
>>> shopping
[ Agua , Huevos , Aceite , Atún ]
Creando desde vacío
Una forma muy habitual de trabajar con listas es empezar con una vacía e ir añadiendo
elementos poco a poco. Se podría hablar de un patrón creación.
Supongamos un ejemplo en el que queremos construir una lista con los números pares del
[0, 20):
>>> even_numbers = []
>>> for i in range(20):
... if i % 2 == 0:
... even_numbers.append(i)
...
>>> even_numbers
[0, 2, 4, 6, 8, 10, 12, 14, 16, 18]
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/2fiS9Ax
Añadir en cualquier posición de una lista
Ya hemos visto cómo añadir elementos al final de una lista. Sin embargo, Python ofrece
una función insert() que vendría a ser una generalización de la anterior, para incorporar
elementos en cualquier posición. Simplemente debemos especificar el índice de inserción y el
elemento en cuestión. También se trata de una función destructiva2:
2 Cuando hablamos de que una función/método es «destructiva/o» significa que modifica la lista (objeto)
original, no que la destruye.
5.1. Listas 143

-- 147 of 516 --

Aprende Python
>>> shopping = [ Agua , Huevos , Aceite ]
>>> shopping.insert(1, Jamón )
>>> shopping
[ Agua , Jamón , Huevos , Aceite ]
>>> shopping.insert(3, Queso )
>>> shopping
[ Agua , Jamón , Huevos , Queso , Aceite ]
Nota: El índice que especificamos en la función insert() lo podemos intepretar como la
posición delante (a la izquierda) de la cual vamos a colocar el nuevo valor en la lista.
Al igual que ocurría con el troceado de listas, en este tipo de inserciones no obtendremos un
error si especificamos índices fuera de los límites de la lista. Estos se ajustarán al principio
o al final en función del valor que indiquemos:
>>> shopping = [ Agua , Huevos , Aceite ]
>>> shopping.insert(100, Mermelada )
>>> shopping
[ Agua , Huevos , Aceite , Mermelada ]
>>> shopping.insert(-100, Arroz )
>>> shopping
[ Arroz , Agua , Huevos , Aceite , Mermelada ]
Consejo: Aunque es posible utilizar insert() para añadir elementos al final de una
lista, siempre se recomienda usar append() por su mayor legibilidad:
>>> values = [1, 2, 3]
>>> values.append(4)
>>> values
[1, 2, 3, 4]
>>> values = [1, 2, 3]
>>> values.insert(len(values), 4) # don t do it!
>>> values
[1, 2, 3, 4]
144 Capítulo 5. Estructuras de datos

-- 148 of 516 --

Aprende Python
Repetir elementos
Al igual que con las cadenas de texto, el operador * nos permite repetir los elementos de una
lista:
>>> shopping = [ Agua , Huevos , Aceite ]
>>> shopping * 3
[ Agua ,
Huevos ,
Aceite ,
Agua ,
Huevos ,
Aceite ,
Agua ,
Huevos ,
Aceite ]
Combinar listas
Python nos ofrece dos aproximaciones para combinar listas:
Conservando la lista original: Mediante el operador + o +=:
>>> shopping = [ Agua , Huevos , Aceite ]
>>> fruitshop = [ Naranja , Manzana , Piña ]
>>> shopping + fruitshop
[ Agua , Huevos , Aceite , Naranja , Manzana , Piña ]
Modificando la lista original: Mediante la función extend():
>>> shopping = [ Agua , Huevos , Aceite ]
>>> fruitshop = [ Naranja , Manzana , Piña ]
>>> shopping.extend(fruitshop)
>>> shopping
[ Agua , Huevos , Aceite , Naranja , Manzana , Piña ]
Hay que tener en cuenta que extend() funciona adecuadamente si pasamos una lista como
argumento. En otro caso, quizás los resultados no sean los esperados. Veamos un ejemplo:
>>> shopping = [ Agua , Huevos , Aceite ]
>>> shopping.extend( Limón )
(continué en la próxima página)
5.1. Listas 145

-- 149 of 516 --

Aprende Python
(proviene de la página anterior)
>>> shopping
[ Agua , Huevos , Aceite , L , i , m , ó , n ]
El motivo es que extend() «recorre» (o itera) sobre cada uno de los elementos del objeto
en cuestión. En el caso anterior, al ser una cadena de texto, está formada por caracteres. De
ahí el resultado que obtenemos.
Se podría pensar en el uso de append() para combinar listas. La realidad es que no funciona
exactamente como esperamos; la segunda lista se añadiría como una sublista de la principal:
>>> shopping = [ Agua , Huevos , Aceite ]
>>> fruitshop = [ Naranja , Manzana , Piña ]
>>> shopping.append(fruitshop)
>>> shopping
[ Agua , Huevos , Aceite , [ Naranja , Manzana , Piña ]]
Modificar una lista
Del mismo modo que se accede a un elemento utilizando su índice, también podemos
modificarlo:
>>> shopping = [ Agua , Huevos , Aceite ]
>>> shopping[0]
Agua
>>> shopping[0] = Jugo
>>> shopping
[ Jugo , Huevos , Aceite ]
En el caso de acceder a un índice no válido de la lista, incluso para modificar, obtendremos
un error:
>>> shopping[100] = Chocolate
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
IndexError: list assignment index out of range
146 Capítulo 5. Estructuras de datos

-- 150 of 516 --

Aprende Python
Modificar con troceado
No sólo es posible modificar un elemento de cada vez, sino que podemos asignar valores a
trozos de una lista:
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> shopping[1:4]
[ Huevos , Aceite , Sal ]
>>> shopping[1:4] = [ Atún , Pasta ]
>>> shopping
[ Agua , Atún , Pasta , Limón ]
Nota: La lista que asignamos no necesariamente debe tener la misma longitud que el trozo
que sustituimos.
Borrar elementos
Python nos ofrece, al menos, cuatro formas para borrar elementos en una lista:
Por su índice: Mediante la sentencia del:
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> del shopping[3]
>>> shopping
[ Agua , Huevos , Aceite , Limón ]
Por su valor: Mediante la función remove():
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> shopping.remove( Sal )
>>> shopping
[ Agua , Huevos , Aceite , Limón ]
Advertencia: Si existen valores duplicados, la función remove() sólo borrará la
primera ocurrencia.
5.1. Listas 147

-- 151 of 516 --

Aprende Python
Por su índice (con extracción): La sentencia del y la función remove() efectivamente
borran el elemento indicado de la lista, pero no «devuelven»3 nada. Sin embargo,
Python nos ofrece la función pop() que además de borrar, nos «recupera» el elemento;
algo así como una extracción. Lo podemos ver como una combinación de acceso +
borrado:
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> shopping.pop()
Limón
>>> shopping
[ Agua , Huevos , Aceite , Sal ]
>>> shopping.pop(2)
Aceite
>>> shopping
[ Agua , Huevos , Sal ]
Nota: Si usamos la función pop() sin pasarle ningún argumento, por defecto usará
el índice -1, es decir, el último elemento de la lista. Pero también podemos indicarle el
índice del elemento a extraer.
Por su rango: Mediante troceado de listas:
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> shopping[1:4] = []
>>> shopping
[ Agua , Limón ]
Borrado completo de la lista
Python nos ofrece, al menos, dos formas para borrar una lista por completo: