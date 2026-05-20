# 1. Definición y características principales

En lecciones anteriores hemos visto que un diccionario puede representarse con un árbol de búsqueda binaria
(equilibrado o no), o con un árbol n–ario de búsqueda (equilibrado o no). En todos ellos, cada clave se almacena completa
en un nodo del árbol, y la organización del árbol, y por tanto la búsqueda, se implementa basándose en comparaciones de
esa clave, completa, con otras claves, también completas, almacenadas en los otros nodos.
En cambio, un trie es un árbol que sirve para almacenar claves, pero se almacenan fragmentadas en los nodos internos,
para guiar la búsqueda. En un trie, cada clave (cadena o secuencia de símbolos) se reconstruye concatenando las partes de
la misma (símbolos de un alfabeto finito) que se encuentran en todos los nodos del camino que va desde la raíz a un nodo
hoja que se corresponde con la información asociada a esa clave.
Por ejemplo, si se considera que el dominio de símbolos son los caracteres, y por tanto el de las claves son las cadenas
de caracteres, en cada nodo intermedio se almacena (o representa) un carácter, y la concatenación de los caracteres de cada
camino desde la raíz de un árbol hasta una hoja, conforma una clave. Y en esa hoja se puede guardar el resto de la
información (si la hay) asociada a la clave.
En general, si el alfabeto de símbolos utilizado tiene definida una relación de orden (es decir, se puede decir si un
símbolo es “anterior” a otro, o no), como es el caso de los caracteres (ordenación fijada por el código ASCII, por ejemplo),
el trie se denomina árbol lexicográfico.
Véase el siguiente ejemplo de bosque, secuencia de árboles lexicográficos, que almacena una colección compuesta por
las cadenas de caracteres: “cris”, “cruz”, “javi”, “juan”, “rafa”, “rafael”, “raquel”.
Nótese que para poder almacenar una cadena que es prefijo de otra (en el ejemplo, “rafa” y “rafael”), se hace
necesario añadir a cada secuencia de nodos del camino que conforman una cadena, un nodo final con un símbolo
cris 	cruz javi juan rafa rafael raquel
c
r
i 	u
s
$
z
$
u
j
a
v
i 	n
$
a
$
r
a
f
a
$ 	e
l
$
q
u
e
l
$

-- 167 of 267 --

160
terminador. En el ejemplo, se ha utilizado el carácter ‘$’, de forma que se supone que ese símbolo no forma parte de
ninguna de las cadenas almacenadas, y sólo se usa para “terminarlas”.
Nótese además que si se desea almacenar un diccionario y se utiliza el dominio de las claves para organizar el trie,
como por ejemplo las cadenas de caracteres en la figura anterior, el valor asociado a cada clave se almacenaría en el nodo
terminador, representado en la figura con el carácter terminador, ‘$’. Por tanto, para implementar un diccionario con un
árbol lexicográfico, se precisa que existan dos tipos de nodos, los intermedios que almacenan los símbolos que,
concatenados, conforman cada clave y los nodos hojas, que hacen el papel del terminador de cada clave y guardan el valor
asociado a la clave.
El nombre de trie proviene de usar las letras centrales de la palabra “retrieval”, recuperación (de información), y se
pronuncia como “try” para distinguirlo del sonido de “tree”.
Un árbol lexicográfico o, en general, un trie, es un árbol de prefijos. Es decir, los prefijos comunes a un subconjunto
de claves se almacenan únicamente una vez. Dicho de otra forma, todas las hojas descendientes de un cierto nodo interno
n, representan claves que tienen un prefijo común, y ese prefijo sólo se almacena una vez: es la concatenación de los
símbolos almacenados en el camino que va desde la raíz hasta el nodo n. En el ejemplo anterior, el prefijo común de “cris”
y “cruz” es “cr”, y sólo se ha almacenado una vez. Lo mismo con “j”, el prefijo común de “javi” y “juan”. De igual forma,
“ra” es el prefijo común a “rafa”, “rafael” y “raquel”. Finalmente, “rafa” es el prefijo común a “rafa” y “rafael”.
Una consecuencia de almacenar una única vez cada prefijo común a un subconjunto de claves es que los tries requieren
menos espacio para almacenar un conjunto de claves que las otras soluciones vistas hasta ahora.
Por ejemplo, el diccionario de palabras inglesas de un sistema operativo (tipo aspell en Linux) puede tener unas 82.000
cadenas, entre palabras y sus inflexiones (incluyendo el inglés británico y el de EE.UU.). Y cada palabra tiene una media
de unos 8 caracteres. Si lo almacenamos en un árbol lexicográfico, podemos ahorrar el espacio de tener que repetir todos
los prefijos comunes en esas 82.000 palabras, que son muchos. Un ejemplo con 5 palabras (cuantas más palabras, el ahorro
es mayor): “bestial”, “bestir”, “bestowal”, “bestseller”, “bestselling”; contienen muchos prefijos comunes y se pueden
almacenar usando únicamente 21 caracteres, en lugar de la suma de los caracteres de las 5 (que es 42, el doble):
best
---- i
---- - al
---- - r
---- owal
---- sell
---- ---- er
---- ---- ing
Además del ahorro en espacio, el ahorro en tiempo es también considerable: la búsqueda en un trie de una
clave de longitud m es de orden O(m) en el peor caso, lineal en la longitud de la clave. A primera vista podría parecer
que esto es mejor que logarítmico en el número de claves, pero para almacenar N claves con un alfabeto de k símbolos se
precisan palabras de longitud log N, con base del logaritmo igual a k. Es decir, la longitud de las claves es logarítmica en el
número de palabras.
best
besti 	bestowal 	bestsell
bestial 	bestir 	bestseller 	bestselling
best
i 	owal 	sell
al 	r 	er 	ing

-- 168 of 267 --

161
Aplicaciones habituales de árboles lexicográficos son la manipulación de diccionarios (búsqueda, inserción, borrado,
etc., de claves y sus valores asociados), búsqueda de prefijos de palabras o, de forma más general, búsqueda y comparación
de subcadenas: procesamiento de textos, completado automático de comandos, etc.