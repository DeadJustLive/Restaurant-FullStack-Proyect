# 2. Representación de los árboles AVL

Para implementar las operaciones de AVL se precisa almacenar en cada nodo del árbol la información sobre el factor
de equilibrio del nodo. Llamamos factor de equilibrio, F e, de un nodo a la diferencia de las alturas de su subárbol
derecho e izquierdo (interpretando que, si uno de esos subárboles es vacío, ese subárbol tiene altura “– 1”).
Decimos que un nodo es perfectamente equilibrado si su F e es 0, es decir, sus subárboles tienen la misma altura. Un
nodo se dice pesado a derechas si su F e es +1, es decir, la altura de su subárbol derecho es una unidad mayor que la del
izquierdo. Por último, un nodo es pesado a izquierdas si su F e es –1, es decir, la altura de su subárbol izquierdo es una