# Parte II

## Fuente
problemas-y-algoritmos (Cap. 25)

## Contenido
# Parte II

Análisis de Complejidad
75

-- 75 of 315 --



-- 76 of 315 --

77
Durante la parte I se vieron muchas formas de aplicar la recursión en
la resolución de problemas y algunas consecuencias matemáticas útiles de la
recursión.
Sin embargo, los problemas mas interesantes en el diseño de algoritmos
surgen al tomar en cuenta el análisis de complejidad, a estas alturas resulta
muy difícil seguir avanzando sin contar con esta herramienta, y a diferencia
de la recursión, el análisis de complejidad si requiere conocimientos previos
para entenderse adecuadamente.
Durante un par de capítulos se hablará muy poco de programación, luego
la programación volverá, pero tendremos que esperar para regresar al diseño
de algoritmos ya que nos concentraremos en el análisis de algoritmos.
Quizá está curva de aprendizaje pudiera parecer desmotivante puesto que
el objetivo es dominar el diseño de algoritmos, pero no hay que olvidar que los
fundamentos no sólo sirven para entender el análisis de complejidad, también
pueden servir en el momento de resolver problemas.
Otra cosa que hay que tomar en cuenta, es que después de esta prolongada
ausencia del diseño de algoritmos, el diseño de algoritmos regresará con una
innidad de nuevos problemas planteados y será posible avanzar mucho mas
rápido.

-- 77 of 315 --

78

-- 78 of 315 --

Cap´ıtulo 6
Técnicas Básicas de Conteo
Como el nombre del capítulo lo indica, el tema a tratar son técnicas de
conteo, las cuales son estudiadas por la combinatoria enumerativa; dichas
técnicas, además de servir para resolver problemas que involucran el conteo,
sirven ampliamente para determinar cuantas veces se ejecutan algunos pasos
en los algoritmos.
A continuación veremos algunos ejemplos donde se aplican las reglas bási-
cas de conteo para posteriormente identicarlas de manera objetiva.
Problema Resuelto 6.0.2. Hay 2 caminos que conducen de la ciudad A
a la ciudad B, 3 caminos que conducen de la ciudad A a la ciudad C. Un
camino que conduce de la ciudad B a la ciudad D y un camino que conduce
de la ciudad C a la ciudad D ¾De cuántas formas se puede ir de la ciudad A
a la ciudad D? (vease la gura para tenerlo mas claro).
Solución Para llegar a la ciudad D solamente se puede llegar a través de
la ciudad C o de la ciudad B, por cada forma de llegar a la ciudad C hay
A
B
C
D
Figura 6.1: Problema resuelto 6.0.2
79

-- 79 of 315 --

80 CAPÍTULO 6. TÉCNICAS BÁSICAS DE CONTEO
A B C
Figura 6.2: Problema resuelto 6.0.3
una forma de llegar a la ciudad D y por cada forma de llegar a la ciudad B
hay una forma de llegar a la ciudad D. Por lo tanto, el número de formas
para llegar a la ciudad D iniciando en la ciudad A es la suma de las formas
para llegar a la ciudad B y a la ciudad D, es decir 2 + 3 = 5.

Problema Resuelto 6.0.3. Hay cuatro caminos que conducen de la ciudad
A a la ciudad B, y tres caminos que conducen de la ciudad B a la ciudad C.
¾Cuántos caminos que pasan por B conducen hasta C?
Solución Vamos a llamar v1, v2, v3 y v4 a los caminos que van desde A hasta
B y w1, w2, w3 a los caminos que van desde la ciudad B hasta la ciudad C.
Para ir desde A hasta C pasando por B es necesario llegar hasta B usando
alguno de los 6 caminos, y posteriormente elegir alguno de los tres caminos
para ir desde B hasta C.
Es decir, existen los siguientes 12 caminos:
v1, w1
v1, w2
v1, w3
v2, w1
v2, w2
v2, w3
v3, w1
v3, w2
v3, w3
v4, w1
v4, w2

-- 80 of 315 --

81
v4, w3
Aquí puede observarse que por cada camino que empieza con v1 hay algun
camino terminado en w1, alguno terminado en w2 y alguno terminado en w3,
por cada camino que empieza con v2 también hay 3 caminos terminados
en w1, w2 y w3 respectivamente; lo mismo para v3 y v4. Por lo tanto hay
(4)(3) = 12 caminos.

Problema Resuelto 6.0.4. Hay x caminos que conducen de la ciudad A
a la ciudad B, y y caminos que conducen de la ciudad B a la ciudad C.
¾Cuántos caminos que pasan por B conducen hasta C?
Solución Por cada una de las x formas para ir de la ciudad A hasta la
ciudad B existen y formas para ir de la ciudad B hasta la ciudad C. Por lo
tanto existen xy formas para ir desde A hasta C pasando por B.

Código 6.1: Función f
1 int f ( int A, int B) {
2 int i , k , r =0;
3 for ( i =0; i <A; i ++){
4 for ( k=0;k<B ; k++){
5 r++;
6 }
7 }
8 return r ;
9 }
Problema Resuelto 6.0.5. ¾Cuál es el valor de retorno de la función f en
el código anterior?
Solución Este problema se puede reducir en saber cuántas veces se ejecuta
la línea 5.
Hay que hacer notar que la línea 3 se ejecuta A veces y por cada vez que
se ejecuta la línea 3, la línea 5 se ejecuta B veces. Por lo tanto el número de
veces que se ejecuta la línea 5(y por ende el valor de retorno de la función)
es AB.

-- 81 of 315 --

82 CAPÍTULO 6. TÉCNICAS BÁSICAS DE CONTEO
6.1. Reglas Básicas de Conteo
A pesar de que los problemas de combinatoria enumerativa son bastante
variados, la mayoría pueden resolverse utilizando las llamadas regla de la
suma, regla del producto, biyeccion y recursión.
Ya dedicam
