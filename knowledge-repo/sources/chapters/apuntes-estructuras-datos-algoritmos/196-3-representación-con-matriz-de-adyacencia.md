# 3. Representación con matriz de adyacencia

Sea G = (V,A) un grafo dirigido y supóngase V = {1,2,…,n}. La matriz de adyacencia para G es una matriz A de
dimensiones n × n de elementos booleanos en la que A[i,j] es verdad si y sólo si existe una arista en G que va del vértice i
al vértice j.
constante n = ... {cardinal de V}
tipo grafo = vector[1..n,1..n] de booleano
En el caso de un grafo no dirigido, la matriz de adyacencia tiene la particularidad de ser simétrica y los elementos de
su diagonal son todos igual a falso.
La representación de la matriz de adyacencia es útil para aquellos algoritmos que precisan saber si existe o no una
arista entre dos vértices dados.
En el caso de grafos etiquetados con pesos, los elementos de la matriz pueden ser enteros o reales (en lugar de
booleanos) y representar el peso de la arista. Si no existe una arista de i a j, debe emplearse un valor que no pueda ser una
etiqueta válida para almacenarse en A[i,j].
Un inconveniente de la representación de la matriz de adyacencia es que requiere un espacio en O(n2) aunque el grafo
tenga muy pocas aristas.
Dado un grafo G = (V,A) representado mediante su matriz de adyacencia, la pregunta ¿(u,v) ∈ A? se puede contestar
en un tiempo en O(1). Sin embargo, la operación adyacentes(g,v) necesita un tiempo en O(n) (pues hay que recorrer una
fila completa de la matriz). Más aún, para saber, por ejemplo, si un grafo no dirigido representado mediante su matriz de
adyacencia es conexo, o simplemente para conocer el número de aristas, los algoritmos requieren un tiempo en O(n2), lo
cual es más de lo que cabría esperar.