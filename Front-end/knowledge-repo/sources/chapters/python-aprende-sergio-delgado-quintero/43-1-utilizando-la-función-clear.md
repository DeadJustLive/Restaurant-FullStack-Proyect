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
ejecución en algún momento que nos interese.
Ejercicio
pycheck boot chars_list
Iterar usando enumeración
Hay veces que no sólo nos interesa «visitar» cada uno de los elementos de una lista, sino
que también queremos saber su índice dentro de la misma. Para ello Python nos ofrece la
función enumerate():
>>> shopping = [ Agua , Huevos , Aceite , Sal , Limón ]
(continué en la próxima página)
5.1. Listas 153

-- 157 of 516 --

Aprende Python
(proviene de la página anterior)
>>> for i, product in enumerate(shopping):
... print(i, product)
...
0 Agua
1 Huevos
2 Aceite
3 Sal
4 Limón
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/TfiuIZ0
Truco: Es posible utilizar el parámetro start con enumerate() para indicar el índice en el
que queremos comenzar. Por defecto es 0.
Iterar sobre múltiples listas
Python ofrece la posibilidad de iterar sobre múltiples listas en paralelo utilizando la
función zip():
>>> shopping = [ Agua , Aceite , Arroz ]
>>> details = [ mineral natural , de oliva virgen , basmati ]
>>> for product, detail in zip(shopping, details):
... print(product, detail)
...
Agua mineral natural
Aceite de oliva virgen
Arroz basmati
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/lfioilG
Nota: En el caso de que las listas no tengan la misma longitud, la función zip() realiza la
combinación hasta que se agota la lista más corta.
Dado que zip() produce un iterador, si queremos obtener una lista explícita con la
combinación en paralelo de las listas, debemos construir dicha lista de la siguiente manera:
154 Capítulo 5. Estructuras de datos

-- 158 of 516 --

Aprende Python
>>> shopping = [ Agua , Aceite , Arroz ]
>>> details = [ mineral natural , de oliva virgen , basmati ]
>>> list(zip(shopping, details))
[( Agua , mineral natural ),
( Aceite , de oliva virgen ),
( Arroz , basmati )]
Ejercicio
Dados dos vectores (listas) de la misma dimensión, utilice la función zip() para calcular su
producto escalar.
Ejemplo
• Entrada:
v1 = [4, 3, 8, 1]
v2 = [9, 2, 7, 3]
• Salida: 101
𝑣1 · 𝑣2 = [4 · 9 + 3 · 2 + 8 · 7 + 1 · 3] = 101
5.1.4 Cuidado con las copias
Nivel intermedio
Las listas son estructuras de datos mutables y esta característica nos obliga a tener cuidado
cuando realizamos copias de listas, ya que la modificación de una de ellas puede afectar a la
otra.
Veamos un ejemplo sencillo:
>>> original_list = [4, 3, 7, 1]
>>> copy_list = original_list
>>> original_list[0] = 15
>>> original_list
[15, 3, 7, 1]
>>> copy_list
[15, 3, 7, 1]
5.1. Listas 155

-- 159 of 516 --

Aprende Python
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/pfi5PC5
Nota: A través de Python Tutor se puede ver claramente el motivo de por qué ocurre esto.
Dado que las variables «apuntan» a la misma zona de memoria, al modificar una de ellas, el
cambio también se ve reflejado en la otra.
Una posible solución a este problema es hacer una «copia dura». Para ello Python
proporciona la función copy():
>>> original_list = [4, 3, 7, 1]
>>> copy_list = original_list.copy()
>>> original_list[0] = 15
>>> original_list
[15, 3, 7, 1]
>>> copy_list
[4, 3, 7, 1]
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/Dfi6oLk
Existe otra aproximación a este problema, y es utilizar un troceado completo de la lista,
lo que nos devuelve una «copia desvinculada» de manera implícita:
>>> original_list = [4, 3, 7, 1]
>>> copy_list = original_list[:]
>>> id(original_list) != id(copy_list)
True
Truco: En el caso de que estemos trabajando con listas que contienen elementos mutables,
debemos hacer uso de la función deepcopy() dentro del módulo copy de la librería estándar.
156 Capítulo 5. Estructuras de datos

-- 160 of 516 --

Aprende Python
5.1.5 Veracidad múltiple
Si bien podemos usar sentencias condicionales para comprobar la veracidad de determinadas
expresiones, Python nos ofrece dos funciones «built-in» con las que podemos evaluar si se
cumplen todas las condiciones all() o si se cumple alguna condición any(). Estas funciones
trabajan sobre iterables, y el caso más evidente es una lista.
Supongamos un ejemplo en el que queremos comprobar si una determinada palabra cumple
las siguientes condiciones:
• Su longitud total es mayor que 4.
• Empieza por «p».
• Contiene, al menos, una «y».
Veamos la versión clásica:
>>> word = python
>>> if len(word) > 4 and word.startswith( p ) and word.count( y ) >= 1:
... print( Cool word! )
... else:
... print( No thanks )
...
Cool word!
Veamos la versión con veracidad múltiple usando all(), donde se comprueba que se
cumplan todas las expresiones:
>>> word = python
>>> enough_length = len(word) > 4 # True
>>> right_beginning = word.startswith( p ) # True
>>> min_ys = word.count( y ) >= 1 # True
>>> is_cool_word = all([enough_length, right_beginning, min_ys])
>>> if is_cool_word:
... print( Cool word! )
... else:
... print( No thanks )
...
Cool word!
Veamos la versión con veracidad múltiple usando any(), donde se comprueba que se
cumpla alguna expresión:
5.1. Listas 157

-- 161 of 516 --

Aprende Python
>>> word = yeah
>>> enough_length = len(word) > 4 # False
>>> right_beginning = word.startswith( p ) # False
>>> min_ys = word.count( y ) >= 1 # True
>>> is_fine_word = any([enough_length, right_beginning, min_ys])
>>> if is_fine_word:
... print( Fine word! )
... else:
... print( No thanks )
...
Fine word!
Consejo: Este enfoque puede ser interesante cuando se manejan muchas condiciones o bien
cuando queremos separar las condiciones y agruparlas en una única lista.
5.1.6 Listas por comprensión
Nivel intermedio
Las listas por comprensión establecen una técnica para crear listas de forma más
compacta basándose en el concepto matemático de conjuntos definidos por comprensión.
Figura 2: Estructura de una lista por comprensión
En primer lugar veamos un ejemplo en el que convertimos una cadena de texto con valores
numéricos en una lista con los mismos valores pero convertidos a enteros. En su versión
158 Capítulo 5. Estructuras de datos

-- 162 of 516 --

Aprende Python
clásica haríamos algo tal que así:
>>> values = 32,45,11,87,20,48
>>> int_values = []
>>> for value in values.split( , ):
... int_value = int(value)
... int_values.append(int_value)
...
>>> int_values
[32, 45, 11, 87, 20, 48]
Ahora veamos el código utilizando una lista por comprensión:
>>> values = 32,45,11,87,20,48
>>> int_values = [int(value) for value in values.split( , )]
>>> int_values
[32, 45, 11, 87, 20, 48]
Figura 3: Transformación de estructura clásica en lista por comprensión
Condiciones en comprensiones
También existe la posibilidad de incluir condiciones en las listas por comprensión.
Continuando con el ejemplo anterior, supongamos que sólo queremos crear la lista con
aquellos valores que empiecen por el dígito 4:
>>> values = 32,45,11,87,20,48
>>> int_values = [int(v) for v in values.split( , ) if v.startswith( 4 )]
(continué en la próxima página)
5.1. Listas 159

-- 163 of 516 --

Aprende Python
(proviene de la página anterior)
>>> int_values
[45, 48]
Anidamiento en comprensiones
Nivel avanzado
En la iteración que usamos dentro de la lista por comprensión es posible usar bucles anidados.
Veamos un ejemplo en el que generamos todas las combinaciones de una serie de valores:
>>> values = 32,45,11,87,20,48
>>> svalues = values.split( , )
>>> combinations = [f {v1}x{v2} for v1 in svalues for v2 in svalues]
>>> combinations
[ 32x32 ,
32x45 ,
32x11 ,
32x87 ,
32x20 ,
32x48 ,
45x32 ,
45x45 ,
...
48x45 ,
48x11 ,
48x87 ,
48x20 ,
48x48 ]
Consejo: Las listas por comprensión son una herramienta muy potente y nos ayuda en
muchas ocasiones, pero hay que tener cuidado de no generar expresiones excesivamente
complejas. En estos casos es mejor una aproximación clásica.
Ejercicio
Utilizando listas por comprensión, cree una lista que contenga el resultado de aplicar la
función 𝑓 (𝑥) = 3𝑥 + 2 para 𝑥 ∈ [0, 20).
Salida esperada: [2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44, 47,
160 Capítulo 5. Estructuras de datos

-- 164 of 516 --

Aprende Python
50, 53, 56, 59]
5.1.7 sys.argv
Cuando queramos ejecutar un programa Python desde línea de comandos, tendremos la
posibilidad de acceder a los argumentos de dicho programa. Para ello se utiliza una lista que
la encontramos dentro del módulo sys y que se denomina argv:
Figura 4: Acceso a parámetros en línea de comandos
Veamos una aplicación de lo anterior en un programa que convierte un número decimal a
una determinada base, ambos argumentos pasados por línea de comandos:
dec2base.py
1 import sys
2
3 number = int(sys.argv[1])
4 tobase = int(sys.argv[2])
5
6 match tobase:
7 case 2:
8 result = f {number:b}
9 case 8:
10 result = f {number:o}
11 case 16:
12 result = f {number:x}
13 case _:
14 result = None
15
(continué en la próxima página)
5.1. Listas 161

-- 165 of 516 --

Aprende Python
(proviene de la página anterior)
16 if result is None:
17 print(f Base {tobase} not implemented! )
18 else:
19 print(result)
Si lo ejecutamos obtenemos lo siguiente:
$ python dec2base.py 65535 2
1111111111111111
5.1.8 Funciones matemáticas
Python nos ofrece, entre otras4, estas tres funciones matemáticas básicas que se pueden
aplicar sobre listas.
Suma de todos los valores: Mediante la función sum():
>>> data = [5, 3, 2, 8, 9, 1]
>>> sum(data)
28
Mínimo de todos los valores: Mediante la función min():
>>> data = [5, 3, 2, 8, 9, 1]
>>> min(data)
1
Máximo de todos los valores: Mediante la función max():
>>> data = [5, 3, 2, 8, 9, 1]
>>> max(data)
9
Ejercicio
Lea desde línea de comandos una serie de números y obtenga la media de dichos valores
(muestre el resultado con 2 decimales).
La llamada se haría de la siguiente manera:
$ python avg.py 32 56 21 99 12 17
4 Existen multitud de paquetes científicos en Python para trabajar con listas o vectores numéricos. Una
de las más famosas es la librería Numpy.
162 Capítulo 5. Estructuras de datos

-- 166 of 516 --

Aprende Python
Plantilla de código para el programa:
import sys