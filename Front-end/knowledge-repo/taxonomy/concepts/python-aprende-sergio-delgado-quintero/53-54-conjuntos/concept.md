# 5.4 Conjuntos

## Fuente
Aprende Python (Cap. 53)

## Contenido
# 5.4 Conjuntos

Un conjunto en Python representa una serie de valores únicos y sin orden establecido,
con la única restricción de que sus elementos deben ser «hashables». Mantiene muchas
similitudes con el concepto matemático de conjunto1
5.4.1 Creando conjuntos
Para crear un conjunto basta con separar sus valores por comas y rodearlos de llaves {}:
>>> lottery = {21, 10, 46, 29, 31, 94}
>>> lottery
{10, 21, 29, 31, 46, 94}
La excepción la tenemos a la hora de crear un conjunto vacío, ya que, siguiendo la lógica
de apartados anteriores, deberíamos hacerlo a través de llaves:
>>> wrong_empty_set = {}
>>> type(wrong_empty_set)
dict
1 Foto original de portada por Duy Pham en Unsplash.
192 Capítulo 5. Estructuras de datos

-- 196 of 516 --

Aprende Python
Advertencia: Si hacemos esto, lo que obtenemos es un diccionario vacío.
La única opción que tenemos es utilizar la función set():
>>> empty_set = set()
>>> empty_set
set()
>>> type(empty_set)
set
Advertencia: Aunque está permitido, NUNCA llames set a una variable porque
destruirías la función que nos permite crear conjuntos. Y tampoco uses nombres derivados
como _set o set_ ya que no son nombres representativos que identifiquen el propósito de
la variable.
5.4.2 Conversión
Para convertir otros tipos de datos en un conjunto podemos usar la función set() sobre
cualquier iterable:
>>> set( aplatanada )
{ a , d , l , n , p , t }
>>> set([1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5])
{1, 2, 3, 4, 5}
>>> set(( ADENINA , TIMINA , TIMINA , GUANINA , ADENINA , CITOSINA ))
{ ADENINA , CITOSINA , GUANINA , TIMINA }
>>> set({ manzana : rojo , plátano : amarillo , kiwi : verde })
{ kiwi , manzana , plátano }
Importante: Como se ha visto en los ejemplos anteriores, set() se suele utilizar en muchas
ocasiones como una forma de extraer los valores únicos de otros tipos de datos. En el
caso de los diccionarios se extraen las claves, que, por definición, son únicas.
Nota: El hecho de que en los ejemplos anteriores los elementos de los conjuntos estén
5.4. Conjuntos 193

-- 197 of 516 --

Aprende Python
ordenados es únicamente un «detalle de implementación» en el que no se puede confiar.
5.4.3 Operaciones con conjuntos
Obtener un elemento
En un conjunto no existe un orden establecido para sus elementos, por lo tanto no podemos
acceder a un elemento en concreto.
De este hecho se deriva igualmente que no podemos modificar un elemento existente,
ya que ni siquiera tenemos acceso al mismo. Python sí nos permite añadir o borrar elementos
de un conjunto.
Añadir un elemento
Para añadir un elemento a un conjunto debemos utilizar la función add(). Como ya hemos
indicado, al no importar el orden dentro del conjunto, la inserción no establece a priori la
posición donde se realizará.
A modo de ejemplo, vamos a partir de un conjunto que representa a los cuatro integrantes
originales de The Beatles. Luego añadiremos a un nuevo componente:
>>> # John Lennon, Paul McCartney, George Harrison y Ringo Starr
>>> beatles = set([ Lennon , McCartney , Harrison , Starr ])
>>> beatles.add( Best ) # Pete Best
>>> beatles
{ Best , Harrison , Lennon , McCartney , Starr }
Ejecución paso a paso a través de Python Tutor:
https://tinyurl.com/9folv2v
Ejercicio
Dada una tupla de duplas (2 valores), cree dos conjuntos:
• Uno de ellos con los primeros valores de cada dupla.
• El otro con los segundos valores de cada dupla.
Ejemplo
• Entrada: ((4, 3), (8, 2), (7, 5), (8, 2), (9, 1))
194 Capítulo 5. Estructuras de datos

-- 198 of 516 --

Aprende Python
• Salida:
{8, 9, 4, 7}
{1, 2, 3, 5}
Borrar elementos
Para borrar un elemento de un conjunto podemos utilizar la función remove(). Siguiendo
con el ejemplo anterior, vamos a borrar al último «beatle» añadido:
>>> beatles
{ Best , Harrison , Lennon , McCartney , Starr }
>>> beatles.remove( Best )
>>> beatles
{ Harrison , Lennon , McCartney , Starr }
Longitud de un conjunto
Podemos conocer el número de elementos (cardinalidad) que tiene un conjunto con la función
len():
>>> beatles
{ Harrison , Lennon , McCartney , Starr }
>>> len(beatles)
4
Iterar sobre un conjunto
Tal y como hemos visto para otros tipos de datos iterables, la forma de recorrer los elementos
de un conjunto es utilizar la sentencia for:
>>> for beatle in beatles:
... print(beatle)
...
Harrison
McCartney
Starr
Lennon
5.4. Conjuntos 195

-- 199 of 516 --

Aprende Python
Consejo: Como en el ejemplo anterior, es muy común utilizar una variable en singular para
recorrer un iterable (en plural). No es una regla fija ni sirve para todos los casos, pero sí
suele ser una buena práctica.
Pertenencia de elemento
Al igual que con otros tipos de datos, Python nos ofrece el operador in para determinar si
un elemento pertenece a un conjunto:
>>> beatles
{ Harrison , Lennon , McCartney , Starr }
>>> Lennon in beatles
True
>>> Fari in beatles
False
5.4.4 Teoría de conjuntos
Vamos a partir de dos conjuntos 𝐴 = {1, 2} y 𝐵 = {2, 3} para ejemplificar las distintas
operaciones que se pueden hacer entre ellos basadas en lo
