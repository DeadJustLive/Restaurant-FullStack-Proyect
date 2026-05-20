# Parte I: se mostró un algoritmo llamado Busqueda Binaria el cual servía

## Fuente
problemas-y-algoritmos (Cap. 33)

## Contenido
# Parte I: se mostró un algoritmo llamado Busqueda Binaria el cual servía

para encontrar valores en secuencias ordenadas de manera no descendente y
parecía ser bastante rápido. Y en la Parte III se demostró que la complejidad
en tiempo de la Búsqueda Binaria es O(log2N ). Es decir, encontrar datos en
una secuencia ordenada de forma no descendente es mucho mas rápido que
encontrar datos en una secuencia cualquiera.
Por este y otros motivos los algoritmos de ordenamiento juegan un papel
escencial en las ciencias de la computación.

-- 133 of 315 --

134

-- 134 of 315 --

Cap´ıtulo 12
Ordenamiento
Antes de comenzar a tratar los algoritmos de ordenamiento es necesario
saber cuál es exactamente el objetivo de los algoritmos de ordenamiento y
qué reglas deben de seguir.
Podríamos pensar en los algoritmos de ordenamiento simplemente como
algoritmos para ordenar números, pero muchos algoritmos(por ejemplo la
búsqueda binaria) resultan útiles para trabajar con datos que pueden no ser
numéricos.
Por tanto lo primero que haremos será buscar una forma de denir lo qué
es un órden, de tal manera que sea consistente con el órden de los números
pero que también se pueda aplicar a otras cosas.
Si quisiéramos ordenar números, el sentido común nos dice que dada una
secuencia A de números, queremos encontrar una secuencia B = (b1, b2, b3, ..., bn)
tal que B es un reordenamiento de los elementos de A y además:
b1 ≤ b2 ≤ b3 ≤ ... ≤ bn
Teniendo esta secuencia ordenada, podemos hacer uso de la propiedad de
que si i < k entonces bi < bk. Esta propiedad a pesar de ser tan simple es
muy poderosa.
Por ejemplo, si se diera el caso que 1 < b1 < bn < 10 entonces ya po-
dríamos saber que todos los números de la secuencia son mayores que 1
y menores que 10 sin necesidad de recorrerla toda; otro ejemplo es que si
b1 ≤ x < bb n
2 c ≤ bn entonces x no se encuentra en la segunda mitad de la
secuencia(la búsqueda binaria usa esta estrategia repetidas veces para encon-
trar x).
Lo que se desea es denir una función llamada < tal que nos permi-
ta ordenar los elementos y conservar estas propiedades; examinaremos esta
135

-- 135 of 315 --

136 CAPÍTULO 12. ORDENAMIENTO
denición a continuación, y en seguida exploraremos los algoritmos de orde-
namiento usando unicamente funciones de comparación, de esta manera los
algoritmos de ordenamiento servirán para ordenar cualquier cosa con función
de comparación, no sólo números.
12.1. Función de comparación
Muy frecuentemente usamos expresiones tales como a < b, a > b ó a ≤ b.
Cuando se trata de números reales sabemos que a < b si y solo sí a − b /	∈ R+
0
o dicho de otra manera, nuestra función de comparación es:
f (a, b) = 1 si a − b /	∈ R+
0
0 en otro caso
Es decir, una función de comparación es una función que indica si un
elemento es menor que otro.
Muchos lenguajes de programación traen implementados previamente al-
goritmos de ordenamiento y permiten que el programador dena sus propias
funciones de comparación.
A continuación se dene de una manera formal lo que es una función de
comparación.
Denición 12.1.1 (Función de Comparación). Una función de comparación
es una función f : A × A → {0, 1} para algun conjunto A, tal que se cumplen
las siguientes propiedades:
f (a, a) = 0 (antisimetría)
Si f (a, b) = 1 y f (b, c) = 1 entonces f (a, c) = 1 (transitividad)
Si f (a, b) = 1 entonces f (b, a) = 0 (totalidad o completitud)
La denición anterior se puede interpretar como que f es una función que
hace comparaciones cumpliendo las siguientes reglas:
Todos los pares ordenadados (a, b) tales que a ∈ A y b ∈ A se pueden
comparar haciendo uso de f .
Ningún elemento es menor que si mismo.
Si a es menor que b y b es menor que c entonces a es menor que c.
Si a es menor que b entonces b no es menor que a.

-- 136 of 315 --

12.2. CONJUNTO CON UN ÓRDEN TOTAL 137
12.2. Conjunto con un Órden Total
Un conjunto con un órden total, como su nombre lo indica, es aquel que
se puede ordenar de manera no descendente con una función de comparación
dada.
Podrímos vernos tentados a decir que un conjunto A tiene un órden total
en base a la existencia de una permutación P de A tal que P = (p1, ..., pn) y
f (pi, pi−1) = 0 para todo 0 < i ≤ n. Pero eso no es necesario
Denición 12.2.1 (conjunto con un órden total). Un conjunto con un órden
total es un par ordenado (A, f ) donde A es un conjunto y f es una función
de comparación con dominio en A × A. Además se aceptan las siguientes
deniciones:
a < b si y sólo si f (a, b) = 1 y se lee a menor que b
a > b si y sólo si f (b, a) = 1 y se lee a mayor que b
a = b si y sólo si f (a, b) = 0 y f (b, a) = 0 y se lee a equivale a b
a ≤ b si y sólo si a < b ó a = b y se lee a menor o igual que b
a ≥ b si y sólo si a > b ó a = b y se lee a mayor o igual que b
Es un buen momento para hacer una aclaración, las matemáticas actuales
en lugar de denir una función de comparación, denen algo muy parecido
llamado relación de órden total. Así que la denición que vamos a manejar
de
