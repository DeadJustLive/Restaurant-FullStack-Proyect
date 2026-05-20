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
operaciones que se pueden hacer entre ellos basadas en los Diagramas de Venn y la Teoría
de Conjuntos:
>>> A = {1, 2}
>>> B = {2, 3}
Figura 8: Diagramas de Venn
196 Capítulo 5. Estructuras de datos

-- 200 of 516 --

Aprende Python
Intersección
𝐴 ∩ 𝐵 – Elementos que están a la vez en 𝐴 y en 𝐵:
>>> A & B
{2}
>>> A.intersection(B)
{2}
Unión
𝐴 ∪ 𝐵 – Elementos que están tanto en 𝐴 como en 𝐵:
>>> A | B
{1, 2, 3}
>>> A.union(B)
{1, 2, 3}
Diferencia
𝐴 − 𝐵 – Elementos que están en 𝐴 y no están en 𝐵:
>>> A - B
{1}
>>> A.difference(B)
{1}
Diferencia simétrica
𝐴 ∩ 𝐵 – Elementos que están en 𝐴 o en 𝐵 pero no en ambos conjuntos:
>>> A ^ B
{1, 3}
>>> A.symmetric_difference(B)
{1, 3}
5.4. Conjuntos 197

-- 201 of 516 --

Aprende Python
Inclusión
• Un conjunto 𝐵 es un subconjunto de otro conjunto 𝐴 si todos los elementos de 𝐵
están incluidos en 𝐴.
• Un conjunto 𝐴 es un superconjunto de otro conjunto 𝐵 si todos los elementos de 𝐵
están incluidos en 𝐴.
Veamos un ejemplo con los siguientes conjuntos:
>>> A = {2, 4, 6, 8, 10}
>>> B = {4, 6, 8}
Figura 9: Subconjuntos y Superconjuntos
En Python podemos realizar comprobaciones de inclusión (subconjuntos y superconjuntos)
utilizando operadores clásicos de comparación:
𝐵 ⊂ 𝐴
>>> B < A # subconjunto
True
𝐵 ⊆ 𝐴
198 Capítulo 5. Estructuras de datos

-- 202 of 516 --

Aprende Python
>>> B <= A
True
𝐴 ⊃ 𝐵
>>> A > B # superconjunto
True
𝐴 ⊇ 𝐵
>>> B >= A
True
5.4.5 Conjuntos por comprensión
Los conjuntos, al igual que las listas y los diccionarios, también se pueden crear por
comprensión.
Veamos un ejemplo en el que construimos un conjunto por comprensión con los aquellos
números enteros múltiplos de 3 en el rango [0, 20):
>>> m3 = {number for number in range(0, 20) if number % 3 == 0}
>>> m3
{0, 3, 6, 9, 12, 15, 18}
Ejercicio
Dadas dos cadenas de texto, obtenga una nueva cadena de texto con las letras consonantes
que se repiten en ambas frases. Ignore los espacios en blanco y muestre la cadena de salida
con sus letras ordenadas.
Resuelva el ejercicio mediante dos aproximaciones: Una de ellas usando conjuntos por
comprensión y otra sin usar comprensiones.
Ejemplo
• Entrada: Flat is better than nested y Readability counts
• Salida: bdlnst
5.4. Conjuntos 199

-- 203 of 516 --

Aprende Python
5.4.6 Conjuntos inmutables
Python ofrece la posibilidad de crear conjuntos inmutables haciendo uso de la función
frozenset() que recibe cualquier iterable como argumento.
Supongamos que recibimos una serie de calificaciones de exámenes y queremos crear un
conjunto inmutable con los posibles niveles (categorías) de calificaciones:
>>> marks = [1, 3, 2, 3, 1, 4, 2, 4, 5, 2, 5, 5, 3, 1, 4]
>>> marks_levels = frozenset(marks)
>>> marks_levels
frozenset({1, 2, 3, 4, 5})
Veamos qué ocurre si intentamos modificar este conjunto:
>>> marks_levels.add(50)
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
AttributeError: frozenset object has no attribute add
Nota: Los frozenset son a los sets lo que las tuplas a las listas: una forma de «congelar»
los valores para que no se puedan modificar.