# 2. El uso de paréntesis, en función del caso, puede aclarar la expresión de comparación.

## Fuente
Aprende Python (Cap. 33)

## Contenido
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
>>> point = (
