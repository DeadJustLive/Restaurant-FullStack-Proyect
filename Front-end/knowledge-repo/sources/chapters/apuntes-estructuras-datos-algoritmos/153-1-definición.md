# 1. Definición

La definición de árbol de búsqueda dada para árboles binarios en una lección anterior, puede generalizarse al caso de
árboles n–arios ordenados, dando lugar a los árboles n–arios de búsqueda.
Los árboles n–arios de búsqueda son árboles de grado n definidos en la forma siguiente:
• 	si A es vacío entonces A es un árbol n–ario de búsqueda;
• 	si A es no vacío entonces A es un árbol n–ario de búsqueda si verifica:
- 	A tiene m subárboles n–arios de búsqueda A1 , …, Am, con 1 ≤ m ≤ n;
- 	la raíz de A contiene la siguiente información: (m,e1 ,e2 ,…,em–1 ), de forma que ei < ei+1 , para 1 ≤ i < m – 1;
- 	todo elemento e perteneciente al subárbol A i es tal que e < ei, para 1 ≤ i ≤ m – 1;
- 	todo elemento e perteneciente al subárbol A m es tal que e > em–1 .
Como ejemplo de árbol 3–ario de búsqueda, puede verse el de la siguiente figura.
20, 45
10, 15 	25, 30 	50, 55
35, 40
Si se trata de buscar un elemento e en este árbol, debe mirarse en primer lugar en el interior de la raíz. En el caso e =
e i, para algún i entre 1 y m – 1, la búsqueda termina con éxito. Si no, determinar si e < e1 , o e > em–1, o hallar el valor de i
(entre 1 y m – 2) para el que ei < e < ei+1 . En el caso e < e1 , debe buscarse en el subárbol A1. En el caso ei < e < e i+1 , para
algún i entre 1 y m – 2, debe buscarse en el subárbol A i+1 . Finalmente, en el caso en que e > em–1 , debe buscarse en Am.
Si el valor de m es grande, la búsqueda entre los elementos e1 ,e2 ,…,em–1 debe realizarse como una búsqueda
dicotómica. En cambio, para valores pequeños de m una búsqueda secuencial puede ser más apropiada.
En el ejemplo, si el dato buscado es e = 35, una búsqueda en el nodo raíz indica que el subárbol apropiado es A2 (el 2º
subárbol del nodo raíz). Una búsqueda en la raíz de A2 indica que el siguiente árbol a explorar es su tercer (y único) subárbol.
El elemento e se encuentra entonces y la búsqueda termina con éxito.
Los árboles n-arios de búsqueda se llaman también árboles de búsqueda múltiple o multicamino (aquéllos en los
que cada nodo puede tener más de dos hijos) cuyas ramas están ordenadas “a modo de” un árbol binario de búsqueda.
En un árbol multicamino de grado n, cada nodo interno puede tener como máximo n nodos descendientes, y puede
almacenar como máximo n – 1 claves ordenadas.
Los árboles n-arios de búsqueda son especialmente útiles cuando se utilizan en búsquedas externas (los datos
almacenados en disco, etc., no en memoria), permitiendo reducir así el número de accesos a disco (1 acceso por nodo
consultado o nivel del árbol).

-- 157 of 267 --

150