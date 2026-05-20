# 4. Representación con listas de adyacencia

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 117)

## Contenido
# 4. Representación con listas de adyacencia

Esta representación sirve para mejorar la eficiencia de los algoritmos sobre grafos que necesitan acceder a los vértices
adyacentes a uno dado. Consiste en almacenar n listas enlazadas mediante punteros de forma que la lista i-ésima contiene
los vértices adyacentes al vértice i.
constante n = ... {cardinal de V}
tipos ptNodo = ↑nodo
nodo = registro
vértice:1..n;
sig:ptNodo
freg
grafo = vector[1..n] de ptNodo
La representación de un grafo con listas de adyacencia requiere un espacio del orden lineal del máximo entre n (el
número de vértices) y a (el número de aristas, que para un grafo completo es O(n2
) mientras que para un árbol es O(n)).
En el caso de un grafo no dirigido, si (u,v) ∈ A entonces el vértice v estará en la lista correspondiente al vértice u, y el
vértice u lo estará a su vez en la lista de adyacencia del vértice v.
Para representar un grafo etiquetado con pesos basta con añadir otro campo al tipo nodo que almacene el peso
correspondiente.
Acceder a la lista de los vértices adyacentes a uno dado lleva un tiempo constante. Sin embargo, consultar si una
determinada arista (u,v) está en el grafo precisa recorrer la lista asociada al vértice u, lo que en el caso peor se realiza en
O(n).
En el caso de un grafo dirigido, si se necesita saber a qué vértices es adyacente un vértice dado, la representación con
listas de adyacencia no es adecuada. Ese problema puede superarse si se almacena otro vector de n listas de forma que la
lista i-ésima contenga los vértices a los que es adyacente el vértice i. Estas listas se llaman listas de adyacencia inversa.
La siguiente figura ilustra la representación de un grafo dirigido con su matriz de adyacencia y con sus vectores de
listas de adyacencia (directa e inversa):

-- 209 of 267 --

196
3
2
1
A =
falso 	verdad 	falso
verdad 	falso 	verdad
falso 	falso 	falso
nil
2 nil
1 	3 nil
1
2
3
2 nil
1
2
3
1 nil
2 nil
Grafo dirigido 	Matriz de adyacencia
Vector de listas de adyacencia 	Vector de listas de adyacencia inversa
