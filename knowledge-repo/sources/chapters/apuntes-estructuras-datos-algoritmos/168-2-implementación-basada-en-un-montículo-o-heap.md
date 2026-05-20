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
en caso de que sea menor que dicho hijo), hasta que el elemento esté en una hoja o tenga un valor mayor o igual
que sus hijos.
Paso 2: la raíz va bajando hasta alcanzar la posición adecuada
Nótese que el número máximo de operaciones que hay que realizar para suprimir el máximo elemento de un árbol con
n nodos es del orden del logaritmo de n, que es el número de niveles del árbol y por tanto el máximo número de veces que
la hoja que antes hemos colocado como raíz tiene que intercambiarse por alguno de sus hijos hasta llegar a su posición
correcta. Evidentemente, para ello, debe ser posible acceder a la hoja más a la derecha con coste constante, y acceder desde
cualquier elemento a sus hijos también con coste constante.
Por tratarse de un árbol casi-completo, una representación estática del montículo (o cola con prioridad), basada en
un vector es eficiente tanto en espacio como en tiempo, con la típica limitación de toda representación estática: el tamaño
máximo de la cola con prioridad estará acotado por el tamaño del vector (y por tanto la operación de añadir deberá ser
implementada como parcial). Además, no es trivial dar con una buena representación dinámica debido a dos exigencias que
hemos detectado en la inserción y el borrado: acceso con coste constante al lugar en el que debería estar la siguiente hoja
más a la derecha, para insertar un nuevo nodo, y acceso con coste constante para borrar la hoja más a la derecha y volver a
tener acceso con coste constante a la nueva hoja más a la derecha.
constante maxNum = ... {Máximo nº de elementos almacenables en la cola con prioridad}
tipo cp = registro
dato: vector[1..maxNum] de elemento;
num: 0..maxNum 	{nº actual de elementos en la cola con prioridad}
freg
Un montículo vacío se representa almacenando el valor 0 en el campo num. Para un montículo no vacío, el campo
num guarda el número de elementos del árbol; los elementos se guardan en las componentes 1..num del campo dato de
la siguiente forma:
• 	la raíz se almacena en la primera componente, dato[1];
• 	el hijo izquierdo de dato[i], si existe, se guarda en dato[2*i] y el hijo derecho, si existe, en dato[2*i+1].
Por tanto, el padre de un nodo (distinto de la raíz) almacenado en dato[i] está siempre en dato[i div 2]. Dicho
de otra forma, los nodos del árbol se almacenan por niveles, de arriba a abajo y de izquierda a derecha en cada nivel
(ver la figura).
11
15
11
15
14
11

-- 178 of 267 --

171
Nótese que si el montículo tiene num elementos (11 en la figura de arriba), entonces los primeros num div 2 (en el
caso de la figura son 5) elementos almacenados en el vector representan nodos internos del montículo y el resto son hojas.
Al igual que en todas las representaciones estáticas de TAD con número de valores no finito, únicamente se puede
representar un subconjunto de los valores posibles (en este caso, el de los montículos con número de elementos menor
o igual que maxNum). Este hecho se traduce en que la operación añadir se implementa como operación parcial.
La implementación detallada es la siguiente.