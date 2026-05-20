# 1. Conceptos básicos

Un grafo es una relación arbitraria entre objetos de un mismo tipo. Puede definirse formalmente como un par G =
(V,A), donde V es un conjunto de objetos llamados vértices (o nodos) y A es un conjunto de aristas (o arcos). Una arista es
un par (u,v) de vértices de V.
El grafo se llama dirigido (o “digrafo”) si sus aristas son pares ordenados. En este caso, dada una arista (u,v) (también
representada como u → v), su primer vértice u se llama origen (o cabeza) y su segundo vértice v, destino (o cola). Además,
se dice que v es adyacente a u.
Si las aristas son pares no ordenados, el grafo se llama no dirigido. En este caso, si (u,v) ∈ A, entonces (v,u) ∈ A y
(v,u) = (u,v). Se dice que u y v son adyacentes entre sí. En un grafo no dirigido no suelen permitirse aristas de la forma
(u,u) con u ∈ V.
En muchas ocasiones es útil asociar información a cada arista de un grafo. En ese caso el grafo se dice etiquetado y se
llama etiqueta de una arista a su información asociada. En ocasiones las etiquetas son valores numéricos que representan
valores o costes asociados a las aristas, y se denominan pesos.
Por ejemplo, los vértices de un grafo no dirigido pueden representar ciudades con aeropuerto, las aristas servicios de
vuelo de ida y vuelta entre ciudades, y el peso asociado a cada arista la duración del vuelo entre las dos ciudades
correspondientes.
Un camino en un grafo G = (V,A) es una secuencia de vértices v1,…,v n ∈ V, n ≥ 1, tal que (v i,v i+1) ∈ A para i = 1, …,
n – 1. La longitud de un camino es su número de vértices menos uno.
Un camino es simple si todos sus vértices, excepto tal vez el primero y el último, son distintos. Un ciclo es un camino
simple de longitud no nula que empieza y termina en el mismo vértice. Un grafo es acíclico si no tiene ningún ciclo. Un
subgrafo de un grafo G = (V,A) es otro grafo G’ = (V’,A’) tal que V’ ⊆ V y A’ ⊆ A. Si A’ consta de todas las aristas (u,v) de
A tales que u,v ∈ V’, entonces el subgrafo se dice inducido (o generado por V’).
Un grafo no dirigido se dice conexo si existe un camino entre cada par de vértices. Una componente conexa de un
grafo no dirigido es un subgrafo conexo, inducido y maximal.
Sea G = (V,A) un grafo dirigido. V se puede dividir en clases de equivalencia Vi, 1 ≤ i ≤ r, tales que los vértices u y v
son equivalentes si y sólo si existe un camino de u a v y otro de v a u. Sea Ai, 1 ≤ i ≤ r, el conjunto de las aristas con origen
y destino en Vi. Los grafos Gi = (Vi,Ai) se llaman componentes fuertemente conexas de G. Un grafo dirigido con una sola
componente fuertemente conexa se dice grafo fuertemente conexo.
Un árbol libre es un grafo no dirigido, conexo y acíclico. Si en un árbol libre se destaca un vértice, denominado raíz,
el grafo se denomina árbol (ver la lección 11).
Un árbol de recubrimiento de un grafo no dirigido (o árbol abarcador o árbol de expansión, según distintas
traducciones del término inglés spanning tree) es un árbol libre que es subgrafo del grafo original y que incluye todos sus
vértices.
En un grafo no dirigido y con pesos, el cálculo del árbol de recubrimiento de peso mínimo (o árbol de expansión
mínimo, que es el árbol de recubrimiento cuya suma de pesos es mínima) es un problema de especial interés. Si, por ejemplo,

-- 207 of 267 --

194
los vértices representan ciudades; las aristas, las posibles líneas de comunicación entre ellas; y el peso de una arista, el coste
de seleccionar esa línea de comunicación, un árbol de recubrimiento de peso mínimo representa una red de comunicaciones
entre todas las ciudades que minimiza el coste total.