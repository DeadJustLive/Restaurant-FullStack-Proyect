# 5.1 Listas

## Fuente
Aprende Python (Cap. 42)

## Contenido
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
Modificando la lista original: Utilizando la función reverse() (nótese que es sin
