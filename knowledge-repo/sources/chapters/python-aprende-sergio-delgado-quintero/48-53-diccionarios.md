# 5.3 Diccionarios

Podemos trasladar el concepto de diccionario de la vida real al de diccionario en Python.
Al fin y al cabo un diccionario es un objeto que contiene palabras, y cada palabra tiene
asociado un significado. Haciendo el paralelismo, diríamos que en Python un diccionario es
también un objeto indexado por claves (las palabras) que tienen asociados unos valores
(los significados).1
Los diccionarios en Python tienen las siguientes características:
1 Foto original de portada por Aaron Burden en Unsplash.
174 Capítulo 5. Estructuras de datos

-- 178 of 516 --

Aprende Python
Figura 7: Analogía de un diccionario en Python
5.3. Diccionarios 175

-- 179 of 516 --

Aprende Python
• Mantienen el orden en el que se insertan las claves.2
• Son mutables, con lo que admiten añadir, borrar y modificar sus elementos.
• Las claves deben ser únicas. A menudo se utilizan las cadenas de texto como claves,
pero en realidad podría ser cualquier tipo de datos inmutable: enteros, flotantes, tuplas
(entre otros).
• Tienen un acceso muy rápido a sus elementos, debido a la forma en la que están
implementados internamente.3
Nota: En otros lenguajes de programación, a los diccionarios se les conoce como arrays
asociativos, «hashes» o «hashmaps».
5.3.1 Creando diccionarios
Para crear un diccionario usamos llaves {} rodeando asignaciones clave: valor que están
separadas por comas. Veamos algunos ejemplos de diccionarios:
>>> empty_dict = {}
>>> rae = {
... bifronte : De dos frentes o dos caras ,
... anarcoide : Que tiende al desorden ,
... montuvio : Campesino de la costa
... }
>>> population_can = {
... 2015: 2_135_209,
... 2016: 2_154_924,
... 2017: 2_177_048,
... 2018: 2_206_901,
... 2019: 2_220_270
... }
En el código anterior podemos observar la creación de un diccionario vacío, otro donde sus
claves y sus valores son cadenas de texto y otro donde las claves y los valores son valores
enteros.
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/Sfav2Yw
2 Aunque históricamente Python no establecía que las claves de los diccionarios tuvieran que mantener su
orden de inserción, a partir de Python 3.7 este comportamiento cambió y se garantizó el orden de inserción
de las claves como parte oficial de la especificación del lenguaje.
3 Véase este análisis de complejidad y rendimiento de distintas estructuras de datos en CPython.
176 Capítulo 5. Estructuras de datos

-- 180 of 516 --

Aprende Python
Advertencia: Aunque está permitido, NUNCA llames dict a una variable porque
destruirías la función que nos permite crear diccionarios. Y tampoco uses nombres
derivados como _dict o dict_ ya que no son nombres representativos que identifiquen el
propósito de la variable.
Ejercicio
Cree un diccionario con los nombres de 5 personas de su familia y sus edades.
5.3.2 Conversión
Para convertir otros tipos de datos en un diccionario podemos usar la función dict():
>>> # Diccionario a partir de una lista de cadenas de texto
>>> dict([ a1 , b2 ])
{ a : 1 , b : 2 }
>>> # Diccionario a partir de una tupla de cadenas de texto
>>> dict(( a1 , b2 ))
{ a : 1 , b : 2 }
>>> # Diccionario a partir de una lista de listas
>>> dict([[ a , 1], [ b , 2]])
{ a : 1, b : 2}
Nota: Si nos fijamos bien, cualquier iterable que tenga una estructura interna de 2 elementos
es susceptible de convertirse en un diccionario a través de la función dict().
Diccionario vacío
Existe una manera particular de usar dict() y es no pasarle ningún argumento. En este
caso estaremos queriendo convertir el «vacío» en un diccionario, con lo que obtendremos un
diccionario vacío:
>>> dict()
{}
Truco: Para crear un diccionario vacío, se suele recomendar el uso de {} frente a dict(),
5.3. Diccionarios 177

-- 181 of 516 --

Aprende Python
no sólo por ser más pitónico sino por tener (en promedio) un mejor rendimiento en tiempos
de ejecución.
Creación con dict()
También es posible utilizar la función dict() para crear dicionarios y no tener que utilizar
llaves y comillas:
Supongamos que queremos transformar la siguiente tabla en un diccionario:
Atributo Valor
name Guido
surname Van Rossum
job Python creator
Utilizando la construcción mediante dict podemos pasar clave y valor como argumentos
de la función:
>>> person = dict(
... name= Guido ,
... surname= Van Rossum ,
... job= Python creator
... )
>>> person
{ name : Guido , surname : Van Rossum , job : Python creator }
El inconveniente que tiene esta aproximación es que las claves deben ser identificadores
válidos en Python. Por ejemplo, no se permiten espacios:
>>> person = dict(
... name= Guido van Rossum ,
... date of birth= 31/01/1956
File "<stdin>", line 3
date of birth= 31/01/1956
^
SyntaxError: invalid syntax
Nivel intermedio
Es posible crear un diccionario especificando sus claves y un único valor de «relleno»:
>>> dict.fromkeys( aeiou , 0)
{ a : 0, e : 0, i : 0, o : 0, u : 0}
178 Capítulo 5. Estructuras de datos

-- 182 of 516 --

Aprende Python
Nota: Es válido pasar cualquier «iterable» como referencia a las claves.
5.3.3 Operaciones con diccionarios
Obtener un elemento
Para obtener un elemento de un diccionario basta con escribir la clave entre corchetes.
Veamos un ejemplo:
>>> rae = {
... bifronte : De dos frentes o dos caras ,
... anarcoide : Que tiende al desorden ,
... montuvio : Campesino de la costa
... }
>>> rae[ anarcoide ]
Que tiende al desorden
Si intentamos acceder a una clave que no existe, obtendremos un error:
>>> rae[ acceso ]
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
KeyError: acceso
Usando get()
Existe una función muy útil para «superar» los posibles errores de acceso por claves
inexistentes. Se trata de get() y su comportamiento es el siguiente: