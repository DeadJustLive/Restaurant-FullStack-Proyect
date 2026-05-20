# 2. El uso de paréntesis, en función del caso, puede aclarar la expresión de comparación.

Ejercicio
Dada una variable year con un valor entero, compruebe si dicho año es bisiesto o no lo es.
Un año es bisiesto en el calendario Gregoriano, si es divisible entre 4 y no divisible entre
100, o bien si es divisible entre 400. Puedes hacer la comprobación en esta lista de años
bisiestos.
Ejemplo
• Entrada: 2008
• Salida: Es un año bisiesto
«Booleanos» en condiciones
Cuando queremos preguntar por la veracidad de una determinada variable «booleana» en
una condición, la primera aproximación que parece razonable es la siguiente:
>>> is_cold = True
>>> if is_cold == True:
... print( Coge chaqueta )
... else:
... print( Usa camiseta )
...
Coge chaqueta
Pero podemos simplificar esta condición tal que así:
>>> if is_cold:
... print( Coge chaqueta )
... else:
... print( Usa camiseta )
(continué en la próxima página)
4.1. Condicionales 107

-- 111 of 516 --

Aprende Python
(proviene de la página anterior)
...
Coge chaqueta
Hemos visto una comparación para un valor «booleano» verdadero (True). En el caso de que
la comparación fuera para un valor falso lo haríamos así:
>>> is_cold = False
>>> if not is_cold: # Equivalente a if is_cold == False
... print( Usa camiseta )
... else:
... print( Coge chaqueta )
...
Usa camiseta
De hecho, si lo pensamos, estamos reproduciendo bastante bien el lenguaje natural:
• Si hace frío, coge chaqueta.
• Si no hace frío, usa camiseta.
Ejercicio
Escriba un programa que permita adivinar un personaje de Marvel en base a las tres
preguntas siguientes:
1. ¿Puede volar?
2. ¿Es humano?
3. ¿Tiene máscara?
108 Capítulo 4. Control de flujo

-- 112 of 516 --

Aprende Python
Ejemplo
• Entrada: can_fly = True, is_human = True y has_mask = True
• Salida: Ironman
Es una especie de Akinator para personajes de Marvel…
4.1. Condicionales 109

-- 113 of 516 --

Aprende Python
Valor nulo
Nivel intermedio
None es un valor especial de Python que almacena el valor nulo4. Veamos cómo se comporta
al incorporarlo en condiciones de veracidad:
>>> value = None
>>> if value:
... print( Value has some useful value )
... else:
... # value podría contener None, False (u otro)
... print( Value seems to be void )
...
Value seems to be void
Para distinguir None de los valores propiamente booleanos, se recomienda el uso del operador
is. Veamos un ejemplo en el que tratamos de averiguar si un valor es nulo:
>>> value = None
>>> if value is None:
... print( Value is clearly None )
... else:
... # value podría contener True, False (u otro)
... print( Value has some useful value )
...
Value is clearly void
De igual forma, podemos usar esta construcción para el caso contrario. La forma «pitónica»
de preguntar si algo no es nulo es la siguiente:
>>> value = 99
>>> if value is not None:
... print(f {value=} )
...
value=99
4 Lo que en otros lenguajes se conoce como nil, null, nothing.
110 Capítulo 4. Control de flujo

-- 114 of 516 --

Aprende Python
4.1.8 Sentencia match-case
Una de las novedades más esperadas (y quizás controvertidas) de Python 3.10 fue el
llamado Structural Pattern Matching que introdujo en el lenguaje una nueva sentencia
condicional. Ésta se podría asemejar a la sentencia «switch» que ya existe en otros lenguajes
de programación.
Comparando valores
En su versión más simple, el «pattern matching» permite comparar un valor de entrada con
una serie de literales. Algo así como un conjunto de sentencias «if» encadenadas. Veamos
esta aproximación mediante un ejemplo:
>>> color = #FF0000
>>> match color:
... case #FF0000 :
... print( )
... case #00FF00 :
... print( )
... case #0000FF :
... print( )
...
¿Qué ocurre si el valor que comparamos no existe entre las opciones disponibles? Pues en
principio, nada, ya que este caso no está cubierto. Si lo queremos controlar, hay que añadir
una nueva regla utilizando el subguión _ como patrón:
>>> color = #AF549B
>>> match color:
... case #FF0000 :
... print( )
... case #00FF00 :
... print( )
... case #0000FF :
... print( )
... case _:
... print( Unknown color! )
...
Unknown color!
Ejercicio
4.1. Condicionales 111

-- 115 of 516 --

Aprende Python
Escriba un programa en Python que pida (por separado) dos valores numéricos y un operando
(suma, resta, multiplicación, división) y calcule el resultado de la operación, usando para ello
la sentencia match-case.
Controlar que la operación no sea una de las cuatro predefinidas. En este caso dar un mensaje
de error y no mostrar resultado final.
Ejemplo
• Entrada: 4, 3, +
• Salida: 4+3=7
Patrones avanzados
Nivel avanzado
La sentencia match-case va mucho más allá de una simple comparación de valores. Con ella
podremos deconstruir estructuras de datos, capturar elementos o mapear valores.
Para ejemplificar varias de sus funcionalidades, vamos a partir de una tupla que representará
un punto en el plano (2 coordenadas) o en el espacio (3 coordenadas). Lo primero que vamos
a hacer es detectar en qué dimensión se encuentra el punto:
>>> point = (2, 5)
>>> match point:
... case (x, y):
... print(f ({x},{y}) is in plane )
... case (x, y, z):
... print(f ({x},{y},{z}) is in space )
...
(2,5) is in plane
>>> point = (3, 1, 7)
>>> match point:
... case (x, y):
... print(f ({x},{y}) is in plane )
... case (x, y, z):
... print(f ({x},{y},{z}) is in space )
...
(3,1,7) is in space
En cualquier caso, esta aproximación permitiría un punto formado por «strings»:
112 Capítulo 4. Control de flujo

-- 116 of 516 --

Aprende Python
>>> point = ( 2 , 5 )
>>> match point:
... case (x, y):
... print(f ({x},{y}) is in plane )
... case (x, y, z):
... print(f ({x},{y},{z}) is in space )
...
(2,5) is in plane
Por lo tanto, en un siguiente paso, podemos restringir nuestros patrones a valores enteros:
>>> point = ( 2 , 5 )
>>> match point:
... case (int(), int()):
... print(f {point} is in plane )
... case (int(), int(), int()):
... print(f {point} is in space )
... case _:
... print( Unknown! )
...
Unknown!
>>> point = (3, 9, 1)
>>> match point:
... case (int(), int()):
... print(f {point} is in plane )
... case (int(), int(), int()):
... print(f {point} is in space )
... case _:
... print( Unknown! )
...
(3, 9, 1) is in space
Imaginemos ahora que nos piden calcular la distancia del punto al origen. Debemos tener en
cuenta que, a priori, desconocemos si el punto está en el plano o en el espacio:
>>> point = (8, 3, 5)
>>> match point:
... case (int(x), int(y)):
... dist_to_origin = (x ** 2 + y ** 2) ** (1 / 2)
... case (int(x), int(y), int(z)):
... dist_to_origin = (x ** 2 + y ** 2 + z ** 2) ** (1 / 2)
(continué en la próxima página)
4.1. Condicionales 113

-- 117 of 516 --

Aprende Python
(proviene de la página anterior)
... case _:
... print( Unknown! )
...
>>> dist_to_origin
9.899494936611665
Con este enfoque, nos aseguramos que los puntos de entrada deben tener todas sus
coordenadas como valores enteros:
>>> point = ( 8 , 3, 5) # Nótese el 8 como "string"
>>> match point:
... case (int(x), int(y)):
... dist_to_origin = (x ** 2 + y ** 2) ** (1 / 2)
... case (int(x), int(y), int(z)):
... dist_to_origin = (x ** 2 + y ** 2 + z ** 2) ** (1 / 2)
... case _:
... print( Unknown! )
...
Unknown!
Cambiando de ejemplo, veamos un fragmento de código en el que tenemos que comprobar
la estructura de un bloque de autenticación definido mediante un diccionario. Los
métodos válidos de autenticación son únicamente dos: bien usando nombre de usuario y
contraseña, o bien usando correo electrónico y «token» de acceso. Además, los valores deben
venir en formato cadena de texto:
1 >>> # Lista de diccionarios
2 >>> auths = [
3 ... { username : sdelquin , password : 1234 },
4 ... { email : sdelquin@gmail.com , token : 4321 },
5 ... { email : test@test.com , password : ABCD },
6 ... { username : sdelquin , password : 1234}
7 ... ]
8
9 >>> for auth in auths:
10 ... print(auth)
11 ... match auth:
12 ... case { username : str(username), password : str(password)}:
13 ... print( Authenticating with username and password )
14 ... print(f {username}: {password} )
15 ... case { email : str(email), token : str(token)}:
16 ... print( Authenticating with email and token )
17 ... print(f {email}: {token} )
(continué en la próxima página)
114 Capítulo 4. Control de flujo

-- 118 of 516 --

Aprende Python
(proviene de la página anterior)
18 ... case _:
19 ... print( Authenticating method not valid! )
20 ... print( --- )
21 ...
22 { username : sdelquin , password : 1234 }
23 Authenticating with username and password
24 sdelquin: 1234
25 ---
26 { email : sdelquin@gmail.com , token : 4321 }
27 Authenticating with email and token
28 sdelquin@gmail.com: 4321
29 ---
30 { email : test@test.com , password : ABCD }
31 Authenticating method not valid!
32 ---
33 { username : sdelquin , password : 1234}
34 Authenticating method not valid!
35 ---
Cambiando de ejemplo, a continuación veremos un código que nos indica si, dada la edad de
una persona, puede beber alcohol:
1 >>> age = 21
2
3 >>> match age:
4 ... case 0 | None:
5 ... print( Not a person )
6 ... case n if n < 17:
7 ... print( Nope )
8 ... case n if n < 22:
9 ... print( Not in the US )
10 ... case _:
11 ... print( Yes )
12 ...
13 Not in the US
• En la línea 4 podemos observar el uso del operador OR.
• En las líneas 6 y 8 podemos observar el uso de condiciones dando lugar a cláusulas
guarda.
4.1. Condicionales 115

-- 119 of 516 --

Aprende Python
4.1.9 Operador morsa
Nivel avanzado
A partir de Python 3.8 se incorpora el operador morsa5 que permite unificar sentencias de
asignación dentro de expresiones. Su nombre proviene de la forma que adquiere :=
Supongamos un ejemplo en el que computamos el perímetro de una circunferencia, indicando
al usuario que debe incrementarlo siempre y cuando no llegue a un mínimo establecido.
Versión tradicional
>>> radius = 4.25
... perimeter = 2 * 3.14 * radius
... if perimeter < 100:
... print( Increase radius to reach minimum perimeter )
... print( Actual perimeter: , perimeter)
...
Increase radius to reach minimum perimeter
Actual perimeter: 26.69
Versión con operador morsa
>>> radius = 4.25
... if (perimeter := 2 * 3.14 * radius) < 100:
... print( Increase radius to reach minimum perimeter )
... print( Actual perimeter: , perimeter)
...
Increase radius to reach minimum perimeter
Actual perimeter: 26.69
Consejo: Como hemos comprobado, el operador morsa permite realizar asignaciones dentro
de expresiones, lo que, en muchas ocasiones, permite obtener un código más compacto. Sería
conveniente encontrar un equilibrio entre la expresividad y la legibilidad.
5 Se denomina así porque el operador := tiene similitud con los colmillos de una morsa.
116 Capítulo 4. Control de flujo

-- 120 of 516 --

Aprende Python
EJERCICIOS DE REPASO