# 4. Ideas sobre implementación estática

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 62)

## Contenido
# 4. Ideas sobre implementación estática

En la representación calculada o estática de árboles n–arios ordenados existe una correspondencia biunívoca entre
cada elemento potencial del árbol y cada componente del vector soporte.
constante max = ... {máximo número de elementos almacenables}
tipo árbol = vector[0..max-1] de elemento
Si se considera un árbol de grado n, se puede asociar un índice a los elementos potenciales del árbol de la siguiente
forma:
• 	índice(a) = 0, si a es la raíz del árbol,
• 	índice(a)= n*índice(padre(a))+k, si a es el hijo k–ésimo de padre(a).
0
1
4 	5 	6
2
7 	8 	9
3
10 	11 	12
Como el número máximo de elementos en el nivel k es n k, el número de componentes necesarias para almacenar un
árbol n–ario arbitrario de altura h es ∑k=0
h 	n k = n h+1 -1
n-1 .

-- 154 of 267 --

147
Conocido el índice que le corresponde a un elemento e en el vector, es fácil calcular el índice que le corresponde a su
padre, hermanos o hijos:
elemento 	índice 	condición
e 	i
hijo k–ésimo de e 	n*i + k 	si n*i+k < max
padre de e 	(i-1) div n 	si i ≠ 0
hermano siguiente a e 	i+1 	si i mod n ≠ 0
nº de orden entre sus hermanos 	((i-1) mod n) + 1 	si i ≠ 0
Un árbol n–ario se dice homogéneo si todos sus subárboles excepto las hojas tienen n hijos. Un árbol homogéneo es
completo cuando todas sus hojas tienen la misma profundidad. Dicho de otra forma, un árbol n–ario de altura h es completo
si y sólo si tiene ∑k=0
h 	n k = n h+1 -1
n-1 elementos. Un árbol se dice casi-completo cuando se puede obtener a partir de un
árbol completo eliminando hojas consecutivas del último nivel, comenzando por la que está más a la derecha.
En el caso de un árbol completo, la representación calculada introducida anteriormente es elegante y sencilla, y
no se malgasta nada de memoria. Si el árbol es casi-completo, se desaprovechan algunas componentes del vector, pero
todas ellas situadas al final; por tanto, basta con almacenar en una variable entera auxiliar el índice de la última componente
que contiene un elemento del árbol.
En el caso general (para árboles que no sean completos ni casi-
completos), la representación calculada puede desaprovechar gran
