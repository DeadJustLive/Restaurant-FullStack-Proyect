# 1. Utilizando la función clear():

>>> rae = {
... bifronte : De dos frentes o dos caras ,
... anarcoide : Que tiende al desorden ,
... montuvio : Campesino de la costa
... }
>>> rae.clear()
>>> rae
{}
2. «Reinicializando» el diccionario a vacío con {}:
>>> rae = {
... bifronte : De dos frentes o dos caras ,
... anarcoide : Que tiende al desorden ,
... montuvio : Campesino de la costa
... }
>>> rae = {}
>>> rae
{}
Nota: La diferencia entre ambos métodos tiene que ver con cuestiones internas de
gestión de memoria y de rendimiento.
5.3.4 Cuidado con las copias
Nivel intermedio
Al igual que ocurría con las listas, si hacemos un cambio en un diccionario, se verá reflejado
en todas las variables que hagan referencia al mismo. Esto se deriva de su propiedad de ser
mutable. Veamos un ejemplo concreto:
5.3. Diccionarios 187

-- 191 of 516 --

Aprende Python
>>> original_rae = {
... bifronte : De dos frentes o dos caras ,
... anarcoide : Que tiende al desorden ,
... montuvio : Campesino de la costa
... }
>>> copy_rae = original_rae
>>> original_rae[ bifronte ] = bla bla bla
>>> original_rae
{ bifronte : bla bla bla ,
anarcoide : Que tiende al desorden ,
montuvio : Campesino de la costa }
>>> copy_rae
{ bifronte : bla bla bla ,
anarcoide : Que tiende al desorden ,
montuvio : Campesino de la costa }
Una posible solución a este problema es hacer una «copia dura». Para ello Python
proporciona la función copy():
>>> original_rae = {
... bifronte : De dos frentes o dos caras ,
... anarcoide : Que tiende al desorden ,
... montuvio : Campesino de la costa
... }
>>> copy_rae = original_rae.copy()
>>> original_rae[ bifronte ] = bla bla bla
>>> original_rae
{ bifronte : bla bla bla ,
anarcoide : Que tiende al desorden ,
montuvio : Campesino de la costa }
>>> copy_rae
{ bifronte : De dos frentes o dos caras ,
anarcoide : Que tiende al desorden ,
montuvio : Campesino de la costa }
Truco: En el caso de que estemos trabajando con diccionarios que contienen elementos
mutables, debemos hacer uso de la función deepcopy() dentro del módulo copy de la librería
188 Capítulo 5. Estructuras de datos

-- 192 of 516 --

Aprende Python
estándar.
5.3.5 Diccionarios por comprensión
Nivel intermedio
De forma análoga a cómo se escriben las listas por comprensión, podemos aplicar este método
a los diccionarios usando llaves { }.
Veamos un ejemplo en el que creamos un diccionario por comprensión donde las claves
son palabras y los valores son sus longitudes:
>>> words = ( sun , space , rocket , earth )
>>> words_length = {word: len(word) for word in words}
>>> words_length
{ sun : 3, space : 5, rocket : 6, earth : 5}
También podemos aplicar condiciones a estas comprensiones. Continuando con el ejemplo
anterior, podemos incorporar la restricción de sólo incluir palabras que no empiecen por
vocal:
>>> words = ( sun , space , rocket , earth )
>>> words_length = {w: len(w) for w in words if w[0] not in aeiou }
>>> words_length
{ sun : 3, space : 5, rocket : 6}
Nota: Se puede consultar el PEP-274 para ver más ejemplos sobre diccionarios por
comprensión.
Ejercicio
pycheck boot split_marks
5.3. Diccionarios 189

-- 193 of 516 --

Aprende Python
5.3.6 Objetos «hashables»
Nivel avanzado
La única restricción que deben cumplir las claves de un diccionario es ser «hashables»7.
Un objeto es «hashable» si se le puede asignar un valor «hash» que no cambia en ejecución
durante toda su vida.
Para encontrar el «hash» de un objeto, Python usa la función hash(), que devuelve un
número entero y es utilizado para indexar la tabla «hash» que se mantiene internamente:
>>> hash(999)
999
>>> hash(3.14)
322818021289917443
>>> hash( hello )
-8103770210014465245
>>> hash(( a , b , c ))
-2157188727417140402
Para que un objeto sea «hashable», debe ser inmutable:
>>> hash([ a , b , c ])
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
TypeError: unhashable type: list
Nota: De lo anterior se deduce que las claves de los diccionarios, al tener que ser
«hasheables», sólo pueden ser objetos inmutables.
La función «built-in» hash() realmente hace una llamada al método mágico __hash__() del
objeto en cuestión:
>>> hash( spiderman )
-8105710090476541603
>>> spiderman .__hash__()
-8105710090476541603
7 Se recomienda esta ponencia de Víctor Terrón sobre objetos «hashables».
190 Capítulo 5. Estructuras de datos

-- 194 of 516 --

Aprende Python