# INGENIERIA DE SISTEMAS

3.2.1.4 RECORRIDOS SOBRE GRAFOS:
El principio básico para el manejo algorítmico de la estructura grafos se fundamenta en sus dos recorridos
Recorrido DFS: Es la sigla en inglés que quiere decir primero búsqueda en profundidad. Este algoritmo
funciona ubicándose en un vértice cualquiera del grafo y determina los vértices adyacentes a este y
escoge uno que aún no haya sido visitado y a partir de ahí realizar un llamado recursivo al mismo
algoritmo. El algoritmo DFS requiere controlar cuales vértices han sido visitados y cuáles no.
Para ejercer el control sobre los visitados o no se utiliza un vector v[i] que tiene 0 si el vértice I no ha sido
visitado y que vale 1 si el vértice ya fue visitado. Inicialmente el vector de visitados se inicializa con ceros.
Un algoritmo para el DFS seria:
Void DFS ( int i ) //el método recibe el vértice donde arranca el grafo
V[i]=1 // el vértice ya fue visitado se pone en uno el vector
Para todo vertice w adyacente a i haga //ciclo que recorre los vértices adyacentes
If (V[i]==0) entonces // pregunta si el vértice no ha sido visitado
DFS(w) // hace un llamado recursivo a DFS con w
Fin (if)
Fin (para)
Fin (DFS)
El parámetro i indica el vértice a partir del cual se comienza a hacer el recorrido DFS. La determinación
de los vértices adyacentes depende de la forma en que está representado el grafo.
Un método general de representación para un grafo teniéndolo representado como listas ligadas de
adyacencia seria:
Void DFS (entero i) //el método recibe el vértice donde arranca el grafo
V[i]=1 // el vértice ya fue visitado se pone en uno el vector
p=vec[i] // p apunta al primer nodo del vector de la lista
While (p<>null) do // recorre con p hasta el ultimo nodo
w=p.retornaDato() // asigna a w el dato de p
If(V[w]==0) entonces // pregunta si w fue visitado o no
DFS(w) // si no fue visitado hace llamado recursive a DFS
Fin(if)
P=p.retornaLiga() // Actualiza la liga de p
Fin(mientras)
Fin (DFS)
Recorrido BFS:
Su nombre en inglés lo que hace es justificar primero la búsqueda a lo ancho del grafo. En este algoritmo
se visitan todos los vértices adyacentes a un vértice dado.
La forma en que este recorrido se maneja sobre el grafo, supone que debe manejar una cola que indique
el orden en que se han ido visitando los vértices, a este vector cola lo denominaremos visitado

-- 37 of 64 --

38