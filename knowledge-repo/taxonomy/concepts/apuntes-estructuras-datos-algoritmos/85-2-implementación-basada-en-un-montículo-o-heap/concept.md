# 2. Implementación basada en un montículo o heap

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 85)

## Contenido
# 2. Implementación basada en un montículo o heap

Aunque son posibles otras opciones, la representación más habitual y eficiente para el dominio de valores de una
cola con prioridad es la estructura de datos denominada montículo o, en inglés, heap (nótese que este heap no tiene
ninguna relación con la memoria libre o “memoria montón”, o zona de memoria dinámica, en la que se almacenan los datos
creados dinámicamente, es decir, durante la ejecución de los programas, y apuntados por punteros, aunque en inglés también
se llama heap a esa zona de memoria libre).
Para definir la estructura montículo, definimos antes los árboles binarios parcialmente ordenados y, luego, recordamos
la definición de árboles casi-completos.
Un árbol binario se dice parcialmente ordenado (de máximos) si verifica las siguientes propiedades:
• 	el elemento raíz es mayor o igual que el resto de los elementos del árbol, y
• 	los subárboles izquierdo y derecho son árboles binarios parcialmente ordenados.
Debe observarse que, aunque el valor de un nodo
nunca es menor que los valores de sus hijos, pueden
encontrarse valores más grandes en niveles inferiores a
los de valores más pequeños (en la figura, el 14 y el 12
se encuentran en el nivel 2 mientras que un 11 se
encuentra en el nivel 1).
Sin embargo, en la raíz siempre debe encontrarse un
nodo de valor máximo.
3
5
6 	8
10 	18 	9
9
9 	10
Representación de un árbol parcialmente ordenado de
máximos, sólo se muestran las prioridades
Debe hacerse notar que un árbol de este tipo no es útil para buscar elementos, puesto que no está ordenado al estilo
de un árbol binario de búsqueda.
Representando una cola con prioridades mediante un árbol binario parcialmente ordenado, se consigue que las
operaciones crearVacía, max y esVacía? pueden ser implementadas fácilmente con coste en tiempo constante
(independiente del número de elementos de la cola). La operación max consiste simplemente en acceder al elemento que
está en la raíz, si el árbol es no vacío.
En el caso de las operaciones añadir y eliminarMax la implementación exige, como veremos a continuación,
recorrer un camino en el árbol desde la raíz hasta una hoja (o al revés). En el peor caso, la longitud de tal camino es
del orden del número de elementos del árbol (árbol degenerando, con forma de lista).
17
15 	11
14 	11
11
12 	10
10 	2

-- 176 of 267 --

169
El coste puede reducirse en el peor caso al orden del logaritmo del número de elementos del árbol si se garantiza
que el árbol sea completo o casi-completo. Como ya se definió en una lección anterior, un árbol se dice casi-completo
cuando se puede obtener a partir de un árbol completo eliminando hojas consecutivas del último nivel, comenzando por la
que está más a la derecha. Y un árbol se dice completo cuando su nivel más profundo está lleno (y por tanto, todos los
anteriores también lo están).
Recibe el nombre de montículo (heap, en inglés) un árbol binario parcialmente ordenado casi-completo o
completo.
La operación de añadir un nuevo elemento en un montículo (manteniéndolo casi-completo) puede realizarse de la
siguiente forma:
• 	en primer lugar, se coloca el nuevo elemento como siguiente hoja en el nivel más profundo; se inicia un nuevo
nivel, con una única hoja lo más a la izquierda posible, si el nivel más profundo se encuentra ya completamente
lleno (ver la figura);
Inserción de un nuevo elemento (de prioridad 16) 	Paso 1: se coloca como siguiente hoja
• 	si el nuevo elemento es mayor que su padre, se intercambian; así se repite el proceso (de comparación del nuevo
elemento con su padre e intercambio) hasta que el nuevo elemento llegue hasta la raíz o alcance una posición en la
que sea menor o igual que su padre (ver la figura).
Paso 2: el elemento va subiendo hasta ser menor o igual (en prioridad) que su padre
De esta forma, si es posible acceder desde cualquier elemento a su padre en tiempo constante, el tiempo de ejecución
de la operación de inserción es proporcional a la distancia que el nuevo elemento asciende en el árbol. Esta distancia, por
ser el árbol completo o casi-completo, nunca es mayor que el logaritmo del número de elementos del árbol (es decir, la
altura del árbol).
En cuanto a la operación de eliminación del elemento máximo (que se encuentra en la raíz del árbol), no basta con
borrar la raíz (porque lo que se obtiene es un bosque con dos árboles y no un árbol), sino que deben darse los pasos
siguientes:
• 	se toma la hoja de más a la derecha del nivel más bajo y se coloca de forma provisional en la raíz, sustituyendo al
elemento máximo (ver la figura);
16
16
12
16
12
15
16

-- 177 of 267 --

170
Borrado del elemento máximo 	Paso 1: la hoja última pasa a ser raíz
• 	después, el elemento que se ha colocado en la raíz se compara con su hijo de mayor valor y, si es menor que dicho,
hijo se intercambian; así se repite el proceso de comparación del elemento con su hijo de mayor valor (e intercambio
en caso de que sea menor que dicho hijo), hasta que el elemento esté en una
