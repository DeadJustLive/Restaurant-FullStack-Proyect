# 2. Implementaciones

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 78)

## Contenido
# 2. Implementaciones

Las variantes fundamentales en la implementación de los árboles lexicográficos vienen dadas por la forma elegida para
almacenar un árbol n–ario, concretamente, en cómo almacenar el acceso a todos los subárboles (que pueden ser hasta n) de
cada nodo interno.
Una posibilidad es que cada nodo guarde un vector de punteros a todos los posibles hijos, tantos como el cardinal
del alfabeto de símbolos. Esta representación se denomina nodo–vector. Permite el acceso directo (coste constante) a la
dirección de cada hijo de un nodo (acceso directo a cada componente del vector), con lo que es muy rápida. A cambio, el
coste en espacio es alto porque exige almacenar un vector de punteros en cada nodo interno, y muchos de esos punteros no
se utilizan (especialmente en los niveles inferiores del árbol).
La estructura de datos necesaria es la siguiente:
tipos
símbolo = predecesor('a')..'z'; {subrango de los caracteres,
suponiendo que queremos cadenas de letras minúsculas;
como símbolo de fin de palabra se usará el
predecesor de ‘a’ en lugar del carácter ‘$’}
trie = ↑nodo;
nodo = vector[símbolo] de trie
Nótese que con esta representación no se almacenan realmente los caracteres de una cadena, sino que esa información
se deduce de qué puntero del vector nodo es el que apunta al subárbol correspondiente. El terminador de cada cadena es un
nodo final que tiene todos los punteros iguales a nil excepto el primero, el de la componente predecesor('a'), que es
distinto de nil y apunta, por ejemplo, al mismo nodo (véase en la figura el nodo terminador, marcado en verde, de la
cadena “rafael”, por ejemplo).
Otra posibilidad es que cada nodo interno incluya una lista enlazada por punteros que contenga las raíces de los
subárboles. Se denomina representación nodo–lista y se corresponde con la representación primogénito–siguiente
hermano de un árbol n–ario. Esta representación permite un menor coste en espacio, puesto que sólo se almacenan los
caracteres o símbolos estrictamente necesarios (más un par de punteros por símbolo), pero un mayor tiempo para acceder a
los hijos de un nodo interno, pues obliga a recorrer la lista de nodos hijos.
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

-- 169 of 267 --

162
En la siguiente sección veremos una implementación completa utilizando esta representación de los datos.
Una tercera alternativa, intermedia entre las dos anteriores, consiste en que para almacenar los nodos hijos de un nodo
interno no se utiliza ni un vector ni una lista, sino un árbol de búsqueda binario. Se denomina, representación nodo–abb
de un árbol lexicográfico. Para poder implementarla, cada nodo del árbol requiere tres punteros, por eso también se conoce
esta representación de tries como árbol ternario de búsqueda:
• 	dos punteros, al hijo izquierdo y derecho, como en un árbol binario de búsqueda, y
• 	un puntero, denominado central, a la raíz del trie al que da acceso ese nodo.
El objetivo de esta representación es combinar la eficiencia de los tries con la de los ABB, al usar éstos en cada nodo
del trie. Una búsqueda de una cadena en un trie con representación nodo–abb:
• 	primero, compara el carácter actual de la cadena buscada (empezando por el primero) con el carácter del nodo;
• 	después, si el carácter buscado es menor que el almacenado en el nodo, la búsqueda de ese carácter sigue en el hijo
izquierdo;
• 	si el carácter buscado es mayor que el del nodo, se sigue buscando el mismo carácter en el hijo derecho;
• 	si, por último, el carácter buscado coincide con el carácter de ese nodo, se prosigue la búsqueda en el hijo central,
pero con el siguiente carácter de la cadena buscada.
Por ejemplo, si se quiere almacenar las palabras: “al”, “asa”, “de”, “doy”, “el”, “la”, “le”, “lo”, “mas”, “me”, “mi”,
“no”, si se guardan en un ABB (árbol binario de búsqueda) quedarían, por ejemplo (hay muchas formas distintas de
ordenarlas en un ABB), así (de hecho, éste sería un AVL):
En un trie quedarían así:
c 	j 	r
r
i
s
u
z
a
v
i
u
a
n
a
f
a
q
u
e
l
$ 	$ 	$ 	$ 	$
$
e
l
$
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
la
de
al
asa
doy
el
mas
le
lo
mi
me 	no

-- 170 of 267 --

163
Pero si dibujamos el trie teniendo en cuenta la representación en memoria, como árbol ternario de búsqueda (o trie con
representación nodo–abb), podría quedar de esta forma:
Se han añadido los caracteres terminadores al final de las cadenas (las 12 hojas con el símbolo ‘$’). Los trazos continuos
representan a los punteros izquierdo y derecho. Los trazos discontinuos representan a los punteros centrales.
Además de las variantes anteriores de representación de los tries, existe una variante muy interesante, más compacta,
denominada PATRICIA (Practical Algorithm To Retrieve Information Coded In Alphanumeric). Los PATRICIA vienen a
resolver un problema de los tries, tal y como los hemos presentado, que consiste en que si el número d
