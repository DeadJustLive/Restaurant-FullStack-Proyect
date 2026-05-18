# 2. Si la clave que buscamos no existe, nos devuelve None4 salvo que le indiquemos otro

## Fuente
Aprende Python (Cap. 49)

## Contenido
# 2. Si la clave que buscamos no existe, nos devuelve None4 salvo que le indiquemos otro

valor por defecto, pero en ninguno de los dos casos obtendremos un error.
1 >>> rae
2 { bifronte : De dos frentes o dos caras ,
3 anarcoide : Que tiende al desorden ,
4 montuvio : Campesino de la costa }
5
(continué en la próxima página)
4 None es la palabra reservada en Python para la «nada». Más información en esta web.
5.3. Diccionarios 179

-- 183 of 516 --

Aprende Python
(proviene de la página anterior)
6 >>> rae.get( bifronte )
7 De dos frentes o dos caras
8
9 >>> rae.get( programación )
10
11 >>> rae.get( programación , No disponible )
12 No disponible
Línea 6: Equivalente a rae[ bifronte ].
Línea 9: La clave buscada no existe y obtenemos None.5
Línea 11: La clave buscada no existe y nos devuelve el valor que hemos aportado por
defecto.
Añadir o modificar un elemento
Para añadir un elemento a un diccionario sólo es necesario hacer referencia a la clave y
asignarle un valor:
• Si la clave ya existía en el diccionario, se reemplaza el valor existente por el nuevo.
• Si la clave es nueva, se añade al diccionario con su valor. No vamos a obtener un
error a diferencia de las listas.
Partimos del siguiente diccionario para ejemplificar estas acciones:
>>> rae = {
... bifronte : De dos frentes o dos caras ,
... anarcoide : Que tiende al desorden ,
... montuvio : Campesino de la costa
... }
Vamos a añadir la palabra enjuiciar a nuestro diccionario de la Real Academia de La
Lengua:
>>> rae[ enjuiciar ] = Someter una cuestión a examen, discusión y juicio
>>> rae
{ bifronte : De dos frentes o dos caras ,
anarcoide : Que tiende al desorden ,
montuvio : Campesino de la costa ,
enjuiciar : Someter una cuestión a examen, discusión y juicio }
5 Realmente no estamos viendo nada en la consola de Python porque la representación en cadena de texto
es vacía.
180 Capítulo 5. Estructuras de datos

-- 184 of 516 --

Aprende Python
Supongamos ahora que queremos modificar el significado de la palabra enjuiciar por otra
acepción:
>>> rae[ enjuiciar ] = Instruir, juzgar o sentenciar una causa
>>> rae
{ bifronte : De dos frentes o dos caras ,
anarcoide : Que tiende al desorden ,
montuvio : Campesino de la costa ,
enjuiciar : Instruir, juzgar o sentenciar una causa }
Creando desde vacío
Una forma muy habitual de trabajar con diccionarios es utilizar el patrón creación
partiendo de uno vacío e ir añadiendo elementos poco a poco.
Supongamos un ejemplo en el que queremos construir un diccionario donde las claves son
las letras vocales y los valores son sus posiciones:
>>> VOWELS = aeiou
>>> enum_vowels = {}
>>> for i, vowel in enumerate(VOWELS):
... enum_vowels[vowel] = i + 1
...
>>> enum_vowels
{ a : 1, e : 2, i : 3, o : 4, u : 5}
Nota: Hemos utilizando la función enumerate() que ya vimos para las listas en el apartado:
Iterar usando enumeración.
Ejercicio
pycheck boot cities
5.3. Diccionarios 181

-- 185 of 516 --

Aprende Python
Pertenencia de una clave
La forma pitónica de comprobar la existencia de una clave dentro de un diccionario, es
utilizar el operador in:
>>> bifronte in rae
True
>>> almohada in rae
False
>>> montuvio not in rae
False
Nota: El operador in siempre devuelve un valor booleano, es decir, verdadero o falso.
Ejercicio
pycheck boot count_letters
Obtener todos los elementos
Python ofrece mecanismos para obtener todos los elementos de un diccionario. Partimos del
siguiente diccionario:
>>> rae
{ bifronte : De dos frentes o dos caras ,
anarcoide : Que tiende al desorden ,
montuvio : Campesino de la costa ,
enjuiciar : Instruir, juzgar o sentenciar una causa }
Obtener todas las claves de un diccionario: Mediante la función keys():
>>> rae.keys()
dict_keys([ bifronte , anarcoide , montuvio , enjuiciar ])
Obtener todos los valores de un diccionario: Mediante la función values():
>>> rae.values()
dict_values([
De dos frentes o dos caras ,
Que tiende al desorden ,
(continué en la próxima página)
182 Capítulo 5. Estructuras de datos

-- 186 of 516 --

Aprende Python
(proviene de la página anterior)
Campesino de la costa ,
Instruir, juzgar o sentenciar una causa
])
Obtener todos los pares «clave-valor» de un diccionario: Mediante la función
items():
>>> rae.items()
dict_items([
( bifronte , De dos frentes o dos caras ),
( anarcoide , Que tiende al desorden ),
( montuvio , Campesino de la costa ),
( enjuiciar , Instruir, juzgar o sentenciar una causa )
])
Nota: Para este último caso cabe destacar que los «items» se devuelven como una lista
de tuplas, donde cada tupla tiene dos elementos: el primero representa la clave y el segundo
representa el valor.
Longitud de un diccionario
Podemos conocer el número de elementos («clave-valor») que tiene un diccionario con la
función len():
>>> rae
{ bifronte : De dos frentes o dos caras ,
anarcoide : Que tiende al desorden ,
montuvio : Campesino de la costa ,
enjuiciar : Instruir, juzgar o sentenciar una causa }
>>> len(rae)
4
Iterar sobre un diccionario
En base a los elementos que podemos obten
