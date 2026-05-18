# 3. Representación de varias pilas en un vector

Cuando un programa necesita utilizar varias pilas, la representación de un vector para cada pila puede resultar muy
costosa en espacio. Puede optarse por almacenar varias pilas en un solo vector.
Si el número de pilas a representar en un vector de componentes 1..max es dos, la solución es fácil. Basta con apilar
los elementos de una pila desde la componente 1 en adelante y los elementos de la otra desde la componente max hacia
atrás.
Si el número de pilas a representar, n, es superior a dos, la solución no es tan fácil. Es necesario dividir las max
componentes en n segmentos y alojar los elementos de cada pila en un segmento.
constantes max = 100; {nº máximo de elementos simultáneamente en todas las pilas}
n = 3; {nº máximo de pilas representadas en el vector}
tipo nPilas = registro
dato: vector[1..max] de elemento;
antBase: vector[1..n] de 0..max;
indCima: vector[1..n] de 0..max
freg
En la figura puede verse el caso de n = 3, para un espacio total de 18 elementos.
La primera pila representada tiene tres elementos, a1, a2 y a3. La
cima de la pila es a3. El índice anterior al que ocupa la base de la pila
es el 0 y está almacenado en la primera componente del vector
antBase. La posición de la cima, 3, está almacenada en la primera
componente del vector indCima.
La segunda pila es la pila vacía. El índice anterior al que ocuparía la
base en caso de no ser la pila vacía es el 6 (almacenado en la segunda
componente del vector antBase).
El hecho de que la pila es vacía se representa almacenando en el
lugar destinado al índice de su cima (la segunda componente del vector
indCima) el mismo valor 6. En forma análoga se ha almacenado la
tercera pila, que consta de los elementos c1, c2, c3 y c4. El anterior al
índice de la base es el 12 y el índice de la cima es el 16. 	1
3
5
7
9
11
13
15
17
2
6
4
8
10
12
14
16
18=max
dato
a1
a2
a3
antBase
0
12
6
1
3
2
?
?
?
c1
c2
c3
c4
indCima
3	1
3
2 	6
16
?
?
?
?
?
?
?
?
La implementación de las operaciones es sencilla siempre que las pilas no sobrepasen la capacidad del segmento
correspondiente. Si alguna pila sobrepasa la longitud de su segmento, se hace necesario reorganizar el vector, adjudicando
mayor espacio a esa pila. Por ejemplo, es posible hacer que el espacio libre sobre cada pila sea proporcional al tamaño
actual de la misma (en el supuesto de que las pilas más grandes tienen mayor probabilidad de crecer antes, se retrasa al
máximo el instante de la siguiente reorganización).

-- 68 of 267 --

61
Lección 7
Datos puntero y estructuras dinámicas de datos
Indice