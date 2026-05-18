# Parte VI

## Fuente
problemas-y-algoritmos (Cap. 45)

## Contenido
# Parte VI

Optimización Combinatoria
239

-- 239 of 315 --



-- 240 of 315 --

Cap´ıtulo 19
Estructura de la Solución y Espacio de
Búsqueda
Gran parte de los problemas tratados en la algoritmia son de optimización
combinatoria; es decir, dentro de un conjunto nito, elegir el mejor elemento
o encontrar aquellos elementos que cumplan con una característica especial.
Esto suena como si fuera algo realmente sencillo, pues todo lo que hay
que hacer es evaluar uno por uno y quedarse con el mejor. Lo interesante de
estos problemas radica en encontrar el mejor mas rapidamente o en reducir
el número de posibles soluciones.
Al procedimiento de evaluar candidato que pudiera ser una solución le
llamamos búsqueda(reriéndonos a que se está buscando una solución), y al
conjunto dentro del cual tenemos que encontrar la solución le llamaremos
espacio de búsqueda.
Aquí hay que aclarar que no se está abusando de la palabra búsqueda, la
cual es usada para referirse a los recorridos en grafos, ya que un grafo es en
escencia un espacio de búsqueda.
Por lo general la denición de espacio de búsqueda es simplemente el con-
junto de todos los posibles candidatos a ser una solución de un problema de
optimización. Sin embargo, para nuestros propósitos usaremos una denición
algo diferente, la cual requiere de un poco mas de texto para entender tanto
su signicado como su motivación.
Por el momento nos quedaremos con la siguiente denición provicional:
Denición 19.0.1 (Espacio de Búsqueda(denición temporal)). Un conjun-
to que contiene a todos los candidatos para ser una solución de un problema
de optimización.
Es decir es un conjunto al cual pertenece la solución del problema, pudi-
endo tener otros elementos que no sean la solución.
241

-- 241 of 315 --

242CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA
Lo primero que se necesita para hacer uso ecaz de una búsqueda es denir
un espacio de búsqueda, este paso es obvio, antes de buscar, requerimos saber
en donde buscar. Pero aún cuando parezca obvio, es el paso más difícil de
todos y el que menos programadores son capaces de tomar.
Como buen programador es indispensable que puedas denir un espacio de
búsqueda para cualquier problema que se te presente, de otra forma tendrás
serios problemas para poder encontrar soluciones a problemas que no sean
triviales.
Para poder denir el espacio de búsqueda, es necesario conocer la es-
tructura de la solución, es decir, ¾Qué es la solución que me piden? ¾Qué
estructura tiene? ¾Cómo se puede representar?
19.1. Estructura de la Solución
Normalmente la estructura de la solución de un problema de optimización
combinatoria se puede simplicar a una sucesión de decisiones, cada decición
representada mediante un número.
Por ejemplo en el siguiente problema:
Problema Resuelto 19.1.1. En una tienda venden paquetes de crayones,
el paquete de 11 crayones cuesta $15, el paquete de 20 cuesta $25, el paquete
de 2 cuesta $5.
Se cuenta con exactamente $30, ¾cuál es la mayor cantidad de crayones
que se pueden comprar?
Solución Este problema se puede reducir a tomar estas 3 deciciones:
¾Cuántos paquetes de 11 crayones comprar?
¾Cuántos paquetes de 15 crayones comprar?
¾Cuántos paquetes de 2 crayones comprar?
Se pueden comprar a lo mas 2 paquetes de 11, a lo más un paquete de 15
y a lo más 6 paquetes de 2. Nuestra estructura de la solución puede ser una
terna ordenada de enteros indicando cuántos paquetes se van a comprar de
cada tipo.
Por lo tanto nuestro espacio de búsqueda es el siguiente:

-- 242 of 315 --

19.1. ESTRUCTURA DE LA SOLUCIÓN 243
(0)
(0, 0)
(0, 0, 0) (0, 0, 1) ...
(0, 1)
(1)
(1, 0) (1, 1)
... (1, 1, 0) (1, 1, 1)
Figura 19.1: Árbol de Decisiones
{(0, 0, 0), (0, 0, 1), (0, 0, 2), (0, 0, 3), (0, 0, 4), (0, 0, 5), (0, 0, 6)
(0, 1, 0), (0, 1, 1), (0, 1, 2), (0, 1, 3), (0, 1, 4), (0, 1, 5), (0, 1, 6)
(1, 0, 0), (1, 0, 1), (1, 0, 2), (1, 0, 3), (1, 0, 4), (1, 0, 5), (1, 0, 6)
(1, 1, 0), (1, 1, 1), (1, 1, 2), (1, 1, 3), (1, 1, 4), (1, 1, 5), (1, 1, 6)
(2, 0, 0), (2, 0, 1), (2, 0, 2), (2, 0, 3), (2, 0, 4), (2, 0, 5), (2, 0, 6)
(2, 1, 0), (2, 1, 1), (2, 1, 2), (2, 1, 3), (2, 1, 4), (2, 1, 5), (2, 1, 6)}
Muchas veces resulta conveniente visualizar esta sucesión de decisiones
como árboles enraizados(con raíz), donde cada nodo representa un prejo
de uno o mas candidatos a soluciones, como te podrás imaginar un nodo
padre es prejo de toda su descendencia y las hojas representan los elementos
del espacio de búsqueda. Estos árboles a menudo son llamados árboles de
decisiones.
Denición 19.1.1 (Árbol de Decisiones). Si un espacio de búsqueda S posee
como elementos solamente sucesiones nitas, entonces S posee un árbol de
decisiones.
El árbol de decisiones de S es un árbol enraizado T = (V, A) con raíz r
en el cual se cumplen las siguientes condiciones:
Para todo nodo v ∈ V existe p(v) tal que p(v) es prejo de algun
elemento de S. Llamaremos p(v) la subsolución asociada a v.

-- 243 of 315 --

244CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ES
