# INGENIERIA DE SISTEMAS

## Fuente
estructuras-de-datos (Cap. 17)

## Contenido
# INGENIERIA DE SISTEMAS

La representación con listas ligadas de adyacencia para el Grafo1 será:
Multilista de adyacencia: Se define un registro para representar cada lado del grafo. El lado está
conformado por dos vértices. La configuración del nodo es la siguiente:
Vi Vj LVi L Vj Sw
LVi: Apunta hacia otro registro que representa un lado incidente a Vi
LVj: Apunta hacia otro registro que representa un lado incidente a Vj
Sw: bandera usada para métodos sobre el grafo.
Donde se crea un vector V[i] apunta al primer nodo de la lista de nodos con los que se representan los lados
incidentes al vértice i. La lista ligada que corresponde a un vértice v contiene los lados incidentes sobre el vértice
v
Matriz de incidencia: se define como una matriz de m filas y n columnas con: n: número de vértices del
grafo y n: número de lados del grafo.
Para hacer la representación se deben numerar los lados del grafo (aleatoriamente).
Para el grafo 2 del ejemplo inicial:

-- 33 of 64 --

34
