# 3. Tablas dispersas (o hash)

Con frecuencia, al intentar representar una tabla ocurre que no es posible encontrar una función inyectiva de
codificación de las claves en un subrango pequeño de enteros, 1..max, y por tanto no se puede utilizar la representación
de acceso directo descrita en la sección anterior.
Sin embargo, casi siempre es posible encontrar una función:
h : Dominio de las claves  1..max
si se permite que h pueda ser no inyectiva.
Además, podemos buscar tal función h que distribuya las claves esperadas del modo más uniforme posible en el
rango 1..max. De esta forma, la probabilidad de que, para dos claves distintas, c1 ≠ c2 , se cumpla h(c1 ) = h(c2 ), será lo más
baja posible.
No obstante, encontrar una función que distribuya bien no es fácil. Como ejemplo, la conocida paradoja del
cumpleaños afirma que, si en una habitación están presentes veintitrés personas o más, lo más probable es que haya al
menos dos de esas personas cuyo cumpleaños sea el mismo día (en otras palabras, si seleccionamos una función al azar que
aplica 23 claves en una tabla de tamaño 365, la probabilidad de que no haya dos claves en la misma posición es tan sólo
0.4927, es decir, menos que 1/2).
Se denomina tabla dispersa (en inglés, hash table o hash map) a una representación del TAD diccionario (o mapa, o
tabla) basada en la utilización de una función de codificación no inyectiva, como se ha expuesto previamente, para acceder
a la posición de un vector en la que almacenar cada par.
Para definir una tabla dispersa, el programador debe tomar dos decisiones independientes:

-- 187 of 267 --

180