# 1. Utilizando la función clear():

## Fuente
Aprende Python (Cap. 43)

## Contenido
# 1. Utilizando la función clear():

>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
(continué en la próxima página)
3 Más adelante veremos el comportamiento de las funciones. Devolver o retornar un valor es el resultado
de aplicar una función.
148 Capítulo 5. Estructuras de datos

-- 152 of 516 --

Aprende Python
(proviene de la página anterior)
>>> shopping.clear() # Borrado in-situ
>>> shopping
[]
2. «Reinicializando» la lista a vacío con []:
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> shopping = [] # Nueva zona de memoria
>>> shopping
[]
Nivel avanzado
La diferencia entre ambos métodos tiene que ver con cuestiones internas de gestión de
memoria y de rendimiento:
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> id(shopping)
4416018560
>>> shopping.clear()
>>> id(shopping) # se mantiene la misma "posición de memoria"
4416018560
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> id(shopping)
4458688576
>>> shopping = []
>>> id(shopping) # se crea una nueva "posición de memoria"
4458851520
Encontrar un elemento
Si queremos descubrir el índice que corresponde a un determinado valor dentro la lista
podemos usar la función index() para ello:
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> shopping.index( Huevos )
1
Tener en cuenta que si el elemento que buscamos no está en la lista, obtendremos un error:
5.1. Listas 149

-- 153 of 516 --

Aprende Python
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> shopping.index( Pollo )
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
ValueError: Pollo is not in list
Nota: Si buscamos un valor que existe más de una vez en una lista, la función index() sólo
nos devolverá el índice de la primera ocurrencia.
Pertenencia de un elemento
Si queremos comprobar la existencia de un determinado elemento en una lista, podríamos
buscar su índice, pero la forma pitónica de hacerlo es utilizar el operador in:
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> Aceite in shopping
True
>>> Pollo in shopping
False
Nota: El operador in siempre devuelve un valor booleano, es decir, verdadero o falso.
Ejercicio
Determine si una cadena de texto dada es un isograma, es decir, no se repite ninguna letra.
Ejemplos válidos de isogramas:
• lumberjacks
• background
• downstream
• six-year-old
150 Capítulo 5. Estructuras de datos

-- 154 of 516 --

Aprende Python
Número de ocurrencias
Para contar cuántas veces aparece un determinado valor dentro de una lista podemos usar
la función count():
>>> sheldon_greeting = [ Penny , Penny , Penny ]
>>> sheldon_greeting.count( Howard )
0
>>> sheldon_greeting.count( Penny )
3
Convertir lista a cadena de texto
Dada una lista, podemos convetirla a una cadena de texto, uniendo todos sus elementos
mediante algún separador. Para ello hacemos uso de la función join() con la siguiente
estructura:
Figura 1: Estructura de llamada a la función join()
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> , .join(shopping)
Agua,Huevos,Aceite,Sal,Limón
>>> .join(shopping)
Agua Huevos Aceite Sal Limón
>>> | .join(shopping)
Agua|Huevos|Aceite|Sal|Limón
Hay que tener en cuenta que join() sólo funciona si todos sus elementos son cadenas de
texto:
5.1. Listas 151

-- 155 of 516 --

Aprende Python
>>> , .join([1, 2, 3, 4, 5])
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
TypeError: sequence item 0: expected str instance, int found
Truco: Esta función join() es realmente la opuesta a la de split() para dividir una
cadena.
Ejercicio
Consiga la siguiente transformación:
12/31/20 31-12-2020
Ordenar una lista
Python proporciona, al menos, dos formas de ordenar los elementos de una lista:
Conservando lista original: Mediante la función sorted() que devuelve una nueva lista
ordenada:
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> sorted(shopping)
[ Aceite , Agua , Huevos , Limón , Sal ]
Modificando la lista original: Mediante la función sort():
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> shopping.sort()
>>> shopping
[ Aceite , Agua , Huevos , Limón , Sal ]
Ambos métodos admiten un parámetro «booleano» reverse para indicar si queremos que
la ordenación se haga en sentido inverso:
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> sorted(shopping, reverse=True)
[ Sal , Limón , Huevos , Agua , Aceite ]
152 Capítulo 5. Estructuras de datos

-- 156 of 516 --

Aprende Python
Longitud de una lista
Podemos conocer el número de elementos que tiene una lista con la función len():
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> len(shopping)
5
Iterar sobre una lista
Al igual que hemos visto con las cadenas de texto, también podemos iterar sobre los elementos
de una lista utilizando la sentencia for:
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
>>> for product in shopping:
... print(product)
...
Agua
Huevos
Aceite
Sal
Limón
Nota: También es posible usar la sentencia break en este tipo de bucles para abortar su
ej
