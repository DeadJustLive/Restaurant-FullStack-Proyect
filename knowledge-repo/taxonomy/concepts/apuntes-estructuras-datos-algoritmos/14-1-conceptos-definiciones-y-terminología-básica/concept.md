# 1. Conceptos, definiciones y terminología básica

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 14)

## Contenido
# 1. Conceptos, definiciones y terminología básica

Un árbol con raíz es una colección de elementos de un mismo tipo, llamados nodos o vértices, que pueden representarse
en un grafo no orientado, conexo y acíclico en el que existe un vértice destacado llamado raíz. Por tanto, en general un
árbol no define una estructura lineal sino jerárquica (define una relación paterno-filial entre los nodos). Damos a
continuación una definición recursiva.
Un árbol n–ario (con n≥1) es un conjunto no vacío de elementos o nodos del mismo tipo tal que:
• 	existe un elemento destacado llamado raíz del árbol,
• 	el resto de los elementos se distribuyen en m (con 0≤m≤n) subconjuntos disjuntos, llamados subárboles del árbol
original, cada uno de los cuales es a su vez un árbol n–ario.
Si en el conjunto de los subárboles de un árbol n–ario se supone definida una relación de orden total, el árbol se llama
ordenado.
Gráficamente, un árbol ordenado con raíz x y subárboles A1 , …, A m puede representarse como indica la figura 1. En la
figura 2 se muestra un ejemplo de árbol 3–ario de números enteros.
x
A1 	A m…
3
14 	15
9 	2 	6 	33
Figura 1 	Figura 2
Otro tipo de árboles diferentes son los árboles binarios. Un árbol binario es un conjunto de elementos o nodos del
mismo tipo tal que:
• 	o bien es el conjunto vacío, y entonces se llama árbol vacío,
• 	o bien es no vacío, en cuyo caso existe un elemento destacado llamado raíz y el resto de elementos se distribuyen
en dos subconjuntos disjuntos, llamados subárbol izquierdo y subárbol derecho, cada uno de los cuales es un
árbol binario.
Un árbol compuesto de un solo elemento se denomina hoja.
nodo
Leyenda:
subárbol
3
6 	9
51
13
7 	33
15 	55	Hoja 	Hoja
Hoja
Hoja
38	23
Hoja 	Hoja
Nodo
subárbol

-- 107 of 267 --

100
Un camino es una secuencia de nodos n1 , …, n s, s≥1, tal que n i+1 es hijo de n i, para todo 1≤i≤s-1. El número de nodos
de la secuencia menos uno se llama longitud del camino (es decir, es el número de aristas que conectan los nodos de ese
camino). Por convenio, diremos que existe un camino de longitud cero de todo nodo a sí mismo.
Si en un árbol A existe un camino desde el nodo n1 hasta el nodo n2 , se dice que n1 es antecesor de n2 y que n2 es
descendiente de n1 . Los antecesores o descendientes de un nodo distintos del mismo nodo se denominan propios.
El padre de un nodo es su primer antecesor propio, si existe. Los hijos de un nodo son sus primeros descendientes
propios, si existen. Dos nodos son hermanos si tienen el mismo padre.
3
6 	9
51
13
7 	33
15 	55 	38	23
Camino desde el nodo
3, hasta el nodo 55: su
longitud es 3
Camino desde el
nodo 9 hasta el 23:
longitud 2
3
6 	9
51
13
7 	33
15 	55 	38	23
Antecesores del nodo 7, son
los nodos 6 y 3, y sus
descendientes son los nodos
15 y 55.
Antecesor del nodo 6, es el
nodo 3.
Descendientes del nodo 6
son todos los nodos que
“cuelgan” de él.
3
6 	9
51
13
7 	33
15 	55 	38	23
Sus hijos son
Su padre es
Sus hermanos son

-- 108 of 267 --

101
La altura de un árbol es la longitud del camino más largo que puede encontrarse en el árbol desde la raíz a un nodo.
No está definida para árboles vacíos. La profundidad de un nodo en un árbol es la longitud del único camino existente
desde la raíz del árbol hasta ese nodo. Un nivel es un conjunto de nodos de un árbol con igual profundidad. En el nivel cero
sólo está la raíz; en el nivel uno, sus hijos, etc.
El grado de un árbol es el número máximo de hijos que pueden tener sus nodos (si el árbol es n–ario su grado es n; si
es binario, su grado es dos).
