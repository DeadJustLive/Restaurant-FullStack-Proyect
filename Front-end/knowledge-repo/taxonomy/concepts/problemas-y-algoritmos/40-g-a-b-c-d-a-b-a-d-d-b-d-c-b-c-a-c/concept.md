# G = ({A, B, C, D}, {{A, B}, {A, D}, {D, B}, {D, C}, {B, C}, {A, C}})

## Fuente
problemas-y-algoritmos (Cap. 40)

## Contenido
# G = ({A, B, C, D}, {{A, B}, {A, D}, {D, B}, {D, C}, {B, C}, {A, C}})

Esto no quiere decir que para manejar grafos hay que olvidarse comple-
tamente de dibujarlos como puntos unidos por líneas, ya que en un dibujo

-- 197 of 315 --

198 CAPÍTULO 16. GRAFOS
a simple vista se pueden distinguir detalles del grafo que no serían tan facil
distinguirlos sin el dibujo.
Antes de proseguir es conveniente ver algunas deniciones relacionadas
con los grafos.
La primera que veremos será la de grado, o valencia, al hablar del grado
de un vértice, nos referimos al número de extremos de arista conectados
con él, es decir:
Denición 16.1.2 (Grado). Para un grafo G = (V, A) el grado de un vertice
v ∈ V es el número de aristas de la forma {v, w} ∈ A tales que v 6 = w más
dos veces el número de aristas de la forma {v, v} ∈ A.
El grado de v se denota como δ(v).
Por ejemplo, en la gura 16 el nodo etiquetado como 1 tiene grado 2, y el
nodo etiquetado como 4 tiene grado 3, mientras que en la gura 16.1 todos
los nodos tienen grado 3.
Un grafo dirigido(o digrafo) informalmente hablando es un grafo en el
cual las aristas tienen dirección, es decir una arista entre vi y vj no implica
una arista entre vj y vi.
La única diferencia es que en lugar de que las aristas sean conjuntos de
uno o dos elementos, las aristas serán pares ordenados.
Denición 16.1.3 (Digrafo). Par ordenado G = (V, A) donde A ⊆ V × V .
Nuevamente cabe aclarar que en este libro asumiremos también que los
digrafos son nitos.
16.2. Propiedades Elementales de los Grafos
Los grafos también tienen muchas propiedades interesantes, la primera
de ellas se demostró en el ejemplo 16.0.1, por lo cual solamente la vamos a
enunciar con propósitos de referencia:
Teorema 23. Sea G = (V, A) un grafo tal que {a, a} /	∈ A para toda a ∈
V (no hay aristas que unan a un vértice consigo mismo), entonces existen
dos vértices con el mismo grado.
La siguiente propiedad también tiene que ver con los grados de los vértices
un grafo:
Teorema 24. Sea G = (V, A) un grafo se tiene que la suma de los grados
de todos los vértices en V es exactamente 2|A|.

-- 198 of 315 --

16.3. IMPLEMENTACIÓN 199
Demostración. El grado de un vértice es el número de aristas incidentes a
él, donde las aristas cuyo origen y destino son el mismo vértice se cuentan
doble.
Como cada arista está conectada a lo más con dos vértices entonces, si
está conectada con dos vértices aporta la cantidad de 1 al grado de cada
vértice, aportando en total 2 a la suma de todos los grados; si está conectada
con un solo vértice, entonces aporta 2 al grado de ese vértice y por tanto 2 a
la suma de todos los grados.
Por lo tanto la suma de todos los grados es el doble del número de
aristas(2|A|).
Teorema 25. Sea G = (V, A) un grafo, el número de vértices de grado impar
es par.
Demostración. Usando el teorema anterior, sea z la suma de los grados de G
entonces z = 2|A|, además notamos que z = δ(v1) + δ(v2) + ... + δ(vn) donde
V = {v1, ..., vn}.
Como z es par entonces solamente puede ser obtenida como suma de una
cantidad par de impares y 0 o más pares, por lo tanto, el número de vértices
de grado impar es par.
16.3. Implementación
Luego de haber visto la naturaleza de los grafos, seguramente estas pen-
sando en cómo implementar una estructura de datos similar a un grafo.
Hay muchas maneras de implementar grafos, pero solo se tratarán las 2
mas usadas: matriz de adyacencia y listas de adyacencia.
Matriz de Adyacencia
Esta es quizá la forma mas común de representar un grafo en un lengua-
je de programación debido a su sencillez, sin embargo, requiere |V |2 de
memoria, y en la mayoría de los casos es un poco lenta.
Un grafo G = (V, A) puede ser representado como una matriz M de
|V | × |V |, donde Mi,j 6 = 0 si existe una arista en A que une a los nodos
vi y vj .
Por ejemplo, el grafo de la Figura G1 puede ser representado como:

-- 199 of 315 --

200 CAPÍTULO 16. GRAFOS
M = {
010010
101000
010100
001010
110100
000100
}
La implementacion de un grafo por matriz de adyacencia es bastante
simple:
1 int m[ número_de_vertices ] [ número_de_vertices ] ;
Listas De Adyacencia
Consisten en |V | listas enlazadas, es decir, una lista enlazada para cada
vertice v ∈ V , dicha lista consta de los nodos que estan unidos a v
por medio de alguna arista. La ventaja fundamental de las listas de
adyacencia sobre la matriz de adyacencia es que las listas de adyacencia
solo requieren |A| + |V | de memoria.
Sin embargo, la representación de un grafo por listas de adyacencia es
un poco mas compleja y muchos se ven tentados a usar memoria dinam-
ica para estos casos. Nuevamente se presentará una implementación con
memoria estática por los motivos que se mencionan en el prefacio.
Si tenemos un grafo de 100 000 nodos, y a lo mas un millón de aristas,
es obvio que no podemos crear 100 mil listas reservando espacio para
100 mil nodos en cada una, ya que requeriría una gran cantidad de
memoria y es muy probable que carezca de ella la computadora donde
se vaya a eje
