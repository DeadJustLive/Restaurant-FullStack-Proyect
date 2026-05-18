# Parte I: se mostró un algoritmo llamado Busqueda Binaria el cual servía

para encontrar valores en secuencias ordenadas de manera no descendente y
parecía ser bastante rápido. Y en la Parte III se demostró que la complejidad
en tiempo de la Búsqueda Binaria es O(log2N ). Es decir, encontrar datos en
una secuencia ordenada de forma no descendente es mucho mas rápido que
encontrar datos en una secuencia cualquiera.
Por este y otros motivos los algoritmos de ordenamiento juegan un papel
escencial en las ciencias de la computación.

-- 133 of 315 --

134

-- 134 of 315 --

Cap´ıtulo 12
Ordenamiento
Antes de comenzar a tratar los algoritmos de ordenamiento es necesario
saber cuál es exactamente el objetivo de los algoritmos de ordenamiento y
qué reglas deben de seguir.
Podríamos pensar en los algoritmos de ordenamiento simplemente como
algoritmos para ordenar números, pero muchos algoritmos(por ejemplo la
búsqueda binaria) resultan útiles para trabajar con datos que pueden no ser
numéricos.
Por tanto lo primero que haremos será buscar una forma de denir lo qué
es un órden, de tal manera que sea consistente con el órden de los números
pero que también se pueda aplicar a otras cosas.
Si quisiéramos ordenar números, el sentido común nos dice que dada una
secuencia A de números, queremos encontrar una secuencia B = (b1, b2, b3, ..., bn)
tal que B es un reordenamiento de los elementos de A y además:
b1 ≤ b2 ≤ b3 ≤ ... ≤ bn
Teniendo esta secuencia ordenada, podemos hacer uso de la propiedad de
que si i < k entonces bi < bk. Esta propiedad a pesar de ser tan simple es
muy poderosa.
Por ejemplo, si se diera el caso que 1 < b1 < bn < 10 entonces ya po-
dríamos saber que todos los números de la secuencia son mayores que 1
y menores que 10 sin necesidad de recorrerla toda; otro ejemplo es que si
b1 ≤ x < bb n
2 c ≤ bn entonces x no se encuentra en la segunda mitad de la
secuencia(la búsqueda binaria usa esta estrategia repetidas veces para encon-
trar x).
Lo que se desea es denir una función llamada < tal que nos permi-
ta ordenar los elementos y conservar estas propiedades; examinaremos esta
135

-- 135 of 315 --

136 CAPÍTULO 12. ORDENAMIENTO
denición a continuación, y en seguida exploraremos los algoritmos de orde-
namiento usando unicamente funciones de comparación, de esta manera los
algoritmos de ordenamiento servirán para ordenar cualquier cosa con función
de comparación, no sólo números.
12.1. Función de comparación
Muy frecuentemente usamos expresiones tales como a < b, a > b ó a ≤ b.
Cuando se trata de números reales sabemos que a < b si y solo sí a − b /	∈ R+
0
o dicho de otra manera, nuestra función de comparación es:
f (a, b) = 1 si a − b /	∈ R+
0
0 en otro caso
Es decir, una función de comparación es una función que indica si un
elemento es menor que otro.
Muchos lenguajes de programación traen implementados previamente al-
goritmos de ordenamiento y permiten que el programador dena sus propias
funciones de comparación.
A continuación se dene de una manera formal lo que es una función de
comparación.
Denición 12.1.1 (Función de Comparación). Una función de comparación
es una función f : A × A → {0, 1} para algun conjunto A, tal que se cumplen
las siguientes propiedades:
f (a, a) = 0 (antisimetría)
Si f (a, b) = 1 y f (b, c) = 1 entonces f (a, c) = 1 (transitividad)
Si f (a, b) = 1 entonces f (b, a) = 0 (totalidad o completitud)
La denición anterior se puede interpretar como que f es una función que
hace comparaciones cumpliendo las siguientes reglas:
Todos los pares ordenadados (a, b) tales que a ∈ A y b ∈ A se pueden
comparar haciendo uso de f .
Ningún elemento es menor que si mismo.
Si a es menor que b y b es menor que c entonces a es menor que c.
Si a es menor que b entonces b no es menor que a.

-- 136 of 315 --

12.2. CONJUNTO CON UN ÓRDEN TOTAL 137
12.2. Conjunto con un Órden Total
Un conjunto con un órden total, como su nombre lo indica, es aquel que
se puede ordenar de manera no descendente con una función de comparación
dada.
Podrímos vernos tentados a decir que un conjunto A tiene un órden total
en base a la existencia de una permutación P de A tal que P = (p1, ..., pn) y
f (pi, pi−1) = 0 para todo 0 < i ≤ n. Pero eso no es necesario
Denición 12.2.1 (conjunto con un órden total). Un conjunto con un órden
total es un par ordenado (A, f ) donde A es un conjunto y f es una función
de comparación con dominio en A × A. Además se aceptan las siguientes
deniciones:
a < b si y sólo si f (a, b) = 1 y se lee a menor que b
a > b si y sólo si f (b, a) = 1 y se lee a mayor que b
a = b si y sólo si f (a, b) = 0 y f (b, a) = 0 y se lee a equivale a b
a ≤ b si y sólo si a < b ó a = b y se lee a menor o igual que b
a ≥ b si y sólo si a > b ó a = b y se lee a mayor o igual que b
Es un buen momento para hacer una aclaración, las matemáticas actuales
en lugar de denir una función de comparación, denen algo muy parecido
llamado relación de órden total. Así que la denición que vamos a manejar
de conjunto con un órden total es ligeramente diferente a la mas usada.
Si algún lector se siente ofendido por esto, puede consultar lo que es
una relación de orden total y convencerse de que todas las propiedades que
analizaremos en los conjuntos con órden total también se cumplirán con la
denición tradicional.
Estamos usando funciones de comparación ya que en este contexto nos
resultará mas familiar abordar los algoritmos de ordenamiento.
Al principio del capítulo se dijo que no se iba a denir un conjunto con un
órden total en base a la existencia de una permutación P de A tal que P =
(p1, ..., pn) y pi−1 ≤ pi para todo 0 < i ≤ n; y el motivo de esto es que dadas
las propiedades de una función de comparación es posible comprobar que
dicha permutación existe; de hecho luego de estudiar el siguiente algoritmo
será fácil de convencerse de que es capáz de ordenar cualquier conjunto con
un órden total.
Es imporante mencionar que las implementaciones que aparecen aquí de
algoritmos de ordenamiento son para aplicarse en el caso mas común: donde

-- 137 of 315 --

138 CAPÍTULO 12. ORDENAMIENTO
se tienen todos los elementos en un arreglo. Pero como se verá mas adelante,
las cosas no siempre son tan simples.
12.3. Algoritmo de Selección
El ordenamiento por selección es quizá el primer algoritmo de ordenamien-
to que a la mayoría de la gente se le puede ocurrir y se basa en un hecho
bastante simple:
Teorema 15. Para todo conjunto con un órden total C = (A, f ) tal que A
es un conjunto nito, existe al menos un elemento n ∈ A tal que n ≤ a para
todo a ∈ A, al cual llamaremos mínimo y se denota por min(C) .
Demostración. Supongamos lo contrario que no exista un elemento n en A
tal que n ≤ a para todo a ∈ A.Esto implicaría que para todo elemento m ∈ A
existe un elemento m1 ∈ A tal que m1 < A.
Como m1 ∈ A entonces existiría otro elemento m2 ∈ A tal que m2 < m1,
y existiría otro elemento m3 ∈ A tal que m3 < m2, por inducción podemos
concluir que para cualquier elemento m ∈ A y cualquier entero k existirían
k elementos m1, ..., mk ∈ A tales que mk < mk−1 < ... < m2 < m1 < m.
Ahora, usando la conclusión del párrafo anterior, sabemos que para cualquier
elemento m ∈ A deberían existir tambien |A| elementos m1, ..., m|A| tales que
m|A| < ... < m1 < m.
Por la propiedad de totalidad, tenemos que, todos los elementos m|A|, ..., m1, m
son distintos, por lo que el conjunto A debería tener mas de |A| elementos,
lo cual es una contradicción.
La idea del algoritmo de selección es, dada una sucesión S, encontrar el
mínimo elemento de (s1, s2, ..., sn) e intercambiarlo con s1, después encontrar
el mínimo elemento de (s2, s3, ..., sn) e intercambiarlo con s2.
No es dicil darse cuenta que luego de hacer k intercambios, los primeros
k elementos de la sucesión estarán ordenados. Por lo tanto, luego de hacer n
intercambios se tendrá toda la sucesión S ordenada.
El siguiente código muestra una implementación del algoritmo de selec-
ción con enteros.
Código 12.1: Seleccion con Enteros
1 void s e l e c c i o n ( int S [ ] , int n ) {
2 int i , k , minimo ;
3 for ( i =0; i <n ; i ++){

-- 138 of 315 --

12.4. ALGORITMO DE INSERCIÓN 139
4 minimo=i ;
5 for ( k=i ; k<n ; k++){
6 i f ( S [ k]<S [ minimo ] )
7 minimo=k ;
8 }
9 i n t e r c a m b i a ( S [ i ] , S [ minimo ] ) ;
10 }
11 }
La implementación en C con enteros resulta bastante clara; C++ tiene
la capacidad de denir funciones de comparación que se llamen al usar los
operadores <y >, pero se muestra una implementación en C para ilustrar el
funcionamiento del algoritmo de manera general:
Código 12.2: Seleccion en General
1 void s e l e c c i o n ( t i p o D a t o s S [ ] , int n ) {
2 int i , k , minimo ;
3 for ( i =0; i <n ; i ++){
4 minimo=i ;
5 for ( k=i ; k<n ; k++){
6 i f ( f ( S [ k ] , S [ minimo ] ) ==1)
7 minimo=k ;
8 }
9 i n t e r c a m b i a ( S [ i ] , S [ minimo ] ) ;
10 }
11 }
Como se puede ver, la implementación general cambió muy poco, y eso
es lo que hace útiles a las funciones de comparación en los algoritmos de
ordenamiento.
En general un algoritmo de ordenamiento sólamente puede manipular los
datos de dos formas: dados dos datos a y b, compararlos ó intercambiarlos.
12.4. Algoritmo de Inserción
Este algoritmo es otro que a la gente se le ocurre de manera natural, se
trata del algoritmo usado para ordenar las cartas de una baraja: A lo largo del
ordenamiento, en la mano izquierda se tiene un conjunto de cartas ordenado,
y luego, para cada carta de la mano derecha, se mueve la carta hacia el lugar
que le corresponda en la mano izquierda.
Por ejemplo, si en la mano izquierda se tienen 4 cartas numeradas como
1, 3, 8 y 10 y en la mano derecha se tiene una carta con el número 5, esta

-- 139 of 315 --

140 CAPÍTULO 12. ORDENAMIENTO
carta se deberá colocar entre las cartas 3 y 8, para asi obtener el conjunto
ordenado de cartas 1, 3, 5, 8 y 10.
Inicialmente en la mano izquierda se coloca una sola carta, y es trivial que
ese conjunto ya está ordenado, posteriormente se van insertando las cartas de
una por una con el procedimiento antes descrito hasta tener todas las cartas
en la mano izquierda.
Una manera mas general de describir este procedimiento es inicialmente
tener una sucesión vacía de elementos ordenados A y un conjunto B con n
elementos no ordenados, después insertar cada elemento de B en A de manera
que la sucesión A se mantenga ordenada luego de cada inserción, y continuar
de esa manera hasta haber insertado todo los elementos.
En seguida se muestra una implementación del algoritmo de inserción:
Código 12.3: Insercion
1 void s e l e c c i o n ( t i p o D a t o s S [ ] , int n ) {
2 int i , k ;
3 for ( i =0; i <n ; i ++){
4 for ( k=i ; k>0 && f ( S [ k ] , S [ k −1])==1;k−−){
5 i n t e r c a m b i a ( S [ k ] , S [ k −1]) ;
6 }
7 }
8 }
12.5. Análisis de los Algoritmos de Selección e
Inserción
Recordando lo que hace cada algoritmo, el algoritmo de selección busca
repetidas veces el mínimo de un conjunto de datos no ordenados y cada que
encuentra un mínimo, lo quita del conjunto no ordenado y lo pone al nal
del conjunto ordenado. Si hay n elementos, este procedimiento se repite n
veces.
Mientras tanto, el algoritmo de selección mantiene una sucesión ordenada
de datos y realiza n inserciones en esa sucesión.
Podríamos mirar ingénuamente las implementaciones y decir que ambos
algoritmos son O(n2), pero hay que recordar que los algoritmos de orde-
namiento son algo mucho mas general que una sóla implementación.
Vamos a llamar consulta a la operación que realiza el algoritmo de selec-
ción que consiste en encontrar el menor elemento que aún no se ha ordenado
y colocarlo al nal de los elementos ya ordenados.

-- 140 of 315 --

12.6. EL ODIADO BURBUJA 141
Teorema 16. Con una sucesión de n datos, el algoritmo de selección realiza
n consultas y el algoritmo de inserción realiza n inserciones.
En las implementaciones que se mostraron, una consulta requiere tiempo
O(n) y una inserción requiere tiempo O(n), por lo que ambos algoritmos
funcionan en tiempo O(n2) en estos casos.
Sin embargo, existen algunas situaciones e implementaciones donde tanto
las consultas como las inserciones son de complejidad O(logn), haciendo que
estos algoritmos tengan una complejidad O(nlogn).
El caso de que una inserción tome O(logn) sucede en la vida real cuando
se quiere ordenar una pila de cartas y el caso de que una consulta de selección
tome O(logn) se estudiará mas adelante con los montículos.
Pero por el momento consideraremos la complejidad de estos algoritmos
como O(n2).
12.6. El Odiado Burbuja
Este algoritmo ya se había mencionado en algunos ejemplos, pero no está
por demás mencionarlo aquí.
Burbuja tiene la peculiaridad de ser conocido como el peor algoritmo de
ordenamiento, sin embargo es posible diseñar a propósito otros peores y al
igual que inserción y selección, hay ocasiones en las cuales Burbuja puede ser
el algoritmo adecuado.
Se trata de recorrer varias veces el arreglo, y en cada iteración intercam-
biar aquellos valores para los cuales Sk > Sk+1; luego de n iteraciones el
algoritmo termina.
Antes de analizar el algoritmo para evitar las posibles ambigüedades del
lengüaje se mostrará una implementación:
Código 12.4: Burbuja
1 void burbuja ( t i p o D a t o s S [ ] , int n ) {
2 int i , k ;
3 for ( i =0; i <n ; i ++){
4 for ( k=0;k<n−1;k++)
5 i f ( f ( S [ k ] , S [ k +1])==1){
6 i n t e r c a m b i a ( S [ k ] , S [ k +1]) ;
7 }
8 }
9 }
10 }

-- 141 of 315 --

142 CAPÍTULO 12. ORDENAMIENTO
Como se puede ver, al igual que en los dos algoritmos anteriores el for
exterior recorre los enteros de 0 a n pero el for interior siempre recorre todo
el arreglo(a diferencia de inserción y selección que en promedio recorren la
mitad del arreglo), es por eso que burbuja tiene tan mala fama.
No parece muy difícil converserse de que Burbuja realmente funciona, pero
tampoco está por de más encontrar un buen argumento para estar seguros.
El argumento que demuestra ésto hace uso de la siguiente denición:
Denición 12.6.1 (Inversión). Sea S = (s1, s2, ..., sn) una secuencia de ele-
mentos de un conjunto con un órden total, una inversión es un par ordenado
(i, j) donde si > sj
Ahora, supongamos que s1 ≤ s2 ≤ ... ≤ sn, tenemos en ese caso por la
propiedad de transitividad que para todo i, k ∈ {1, 2, ..., n} con i < k se tiene
que si < sk, es decir, esa secuencia no tiene inversiones.
También cada interacambio en burbuja reduce en 1 el número de inver-
siones, así que si se corre el for interno el suciente número de veces entonces
la secuencia se quedará sin inversiones y nalmente será ordenada.
Sin embargo, eso no es razón suciente para pensar que n iteraciones del
for exterior son sucientes. Observemos que en cada iteración de burbuja
la última posición p del arreglo donde se hizo un itercambio cumple algo
peculiar, y es que no hay inversión (i, j) para la cual i = p, por tanto después
de n interaciones ya no habrá ningúna posición posible para primer elemento
de una inversión.
Hemos comprobado que burbuja funciona, pero tanto su prueba de que
funciona como su cantidad de operaciones resultan notablemente peores que
las de inserción y selección; así que llegamos a la siguiente pregunta obli-
gatoria ¾por qué la gente no se ha olvidado de este algoritmo que parece
ser tan malo?, la respuesta puede ser un tanto sorprendente: este algoritmo
sólamente intercambia elementos adyacentes en el arreglo.
La propiedad de sólamente intercambiar elementos adyacentes en el ar-
reglo hace que este algoritmo resulte adecuado en situaciones en las cuales
resulta costoso intercambiar que se encuentran en posiciones alejadas e in-
cluso tiene una consecuencia teórica muy interesante: si en una secuencia
se pueden intercambiar elementos adyacentes entonces la secuencia se puede
ordenar.
12.7. Ordenamiento en O(n log n) por Mezcla
Los dos algoritmos que acabamos de ver son de complejidad O(n2) y
generalmente los algoritmos que a la gente se le ocurren de manera natural

-- 142 of 315 --

12.7. ORDENAMIENTO EN O(N LOG N ) POR MEZCLA 143
son de esa complejidad.
Existen tambien muchos algoritmos de ordenamiento de complejidad O(n log n)
(de hecho es posible comprobar que no hay algoritmo basado en una función
de comparación que sea mas rápido), por el momento sólo nos concentraremos
en uno de ellos llamado mezcla.
Para poder conocer el algoritmo de mezcla primero hay que resolver el
siguiente ejemplo:
Problema Resuelto 12.7.1. Encuentra un algoritmo que dadas dos suce-
siones ordenadas de manera no descendente A y B, encuentre una sucesión
ordenada de manera no descendente C tal que conste de los elementos de A
y los elementos de B, el algoritmo deberá funcionar en tiempo O(n) donde
n es el tamaño de la sucesión C.
Solución Siguiendo la idea del algoritmo de selección, es posible que nos
venga a la mente buscar en ambas sucesiones cual es el elemento mas pequeño.
Pero recordando que a1 ≤ a2 ≤ a3 ≤ a4... y b1 ≤ b2 ≤ b3 ≤ b4..., podemos
concluir que min(a1, a2, a3, ..., b1, b2, b3, ...) = min(a1, a2).
Por lo cual, podemos encontrar el mínimo de ambas sucesiones en tiempo
constante. La idea del algoritmo es encontrar el minimo de ambas sucesiones,
quitarlo de la sucesión original e insertarlo al nal de C, y luego repetir los
pasos anteriores hasta que ambas sucesiones esten vacías.
Por cada inserción en C hay que encontrar el menor elemento de ambas
sucesiones, lo cual toma tiempo O(1) y posteriormente insertarlo al nal de
la sucesión, lo cual toma también tiempo O(1).
Asi que en total hay n inserciones y n búsquedas del mínimo, que nos da
como resultado un algoritmo que funciona en O(n).
A continuación se incluye la implementación del algoritmo para claricar
las cosas. Los prámetros na y nb indican el número de elementos de A y el
número de elementos de B respectivamente.
Código 12.5: Función que mezcla dos sucesiones ordenadas en otra sucesion
ordenada
1 void m e z c l a r ( t i p o D a t o s A [ ] , t i p o D a t o s B [ ] , t i p o D a t o s C
[ ] , int na , int nb ) {
2 int a=0, b=0, c =0;
3 while ( a<na | | b<nb ) { // Mientras A t e n g a
e l e m e n t o s ó B t e n g a e l e m e n t o s
4 i f ( a<na && b<nb ) { // S i t a n t o A como B
t i e n e n e l e m e n t o s
5 i f (A[ a]<B [ b ] ) {

-- 143 of 315 --

144 CAPÍTULO 12. ORDENAMIENTO
6 C[ c++]=A[ a ++];
7 } e l s e {
8 C[ c++]=B [ b++];
9 }
10 } e l s e i f ( a<na ) { // S i s o l o A t i e n e
e l e m e n t o s
11 C[ c++]=A[ a ++];
12 } e l s e { // S i s o l o B t i e n e e l e m e n t o s
13 C[ c++]=B [ b++];
14 }
15 }
16 }

La idea del algoritmo de mezcla es ordenar los primeros bn
2 c elementos de
la sucesión y los últimos dn
2 e elementos de la sucesión por separado. Y pos-
teriormente mezclar ambas mitades de la sucesión para obtener la sucesión
ordenada.
Y obviamente, para ordenar cada mitad de la sucesión por separado se
procede recursivamente.
De manera mas especíca, se implementará una función llamada orden-
Mezcla, que recibirá como argumentos dos arreglos, S y Dest y dos enteros
inicio y f in. La función ordenará todos los elementos de S[inicio..f in] y los
colocará en Dest[inicio..f in].
A continuación se muestra una implementación de la función ordenMezcla.
Código 12.6: Ordenamiento por Mezcla
1 void ordenMezcla ( t i p o D a t o s S [ ] , t i p o D a t o s Dest [ ] , int
i n i c i o , int f i n ) {
2 int piv , i ;
3 i f ( i n i c i o >=f i n )
4 return ;
5 p i v =( i n i c i o+f i n ) / 2 ;
6 for ( i=i n i c i o ; i<=f i n ; i ++)
7 Dest [ i ]=S [ i ] ;
8 ordenMezcla ( Dest , S , i n i c i o , p i v ) ;
9 ordenMezcla ( Dest , S , p i v +1, f i n ) ;
10 m e z c l a r (&S [ i n i c i o ] , &S [ p i v +1] , &Dest [ i n i c i o ] ,
piv−i n i c i o +1, f i n −p i v ) ;
11 }

-- 144 of 315 --

12.7. ORDENAMIENTO EN O(N LOG N ) POR MEZCLA 145
Utilizando inducción es muy fácil darse cuenta de que este algoritmo fun-
ciona, pero el análisis de complejidad de este algoritmo no luce tan sencillo.
Vamos a llamarle T a una función tal que T (n) es una conta superior para
el tiempo que puede tardar en ejecutarse ordenM ezcla(S, Dest, a, a+n) para
a, n ∈ N.
Tenemos que T es de complejidad O(O(T (dn
2 e)) + O(T (bn
2 c)) + n). Por
regla de la suma esto se puede simplicar a O(T (dn
2 e) + n), podriamos vernos
tentados a decir que cuando n = 2 la complejidad es O(n) y cuando n > 2 la
complejidad sigue siendo O(n); pero eso no sería el camino correcto ya que
dn
2 e en esta notación representa una función y no solamente un argumento.
Al llegar a este punto parece difícil proceder con las reglas conocidas para
calcular complejidad, así que habrá que volver a denir el valor de T en base
a una constante H:
T (n) = H cuando n=1
H(2T (n
2 ) + n + 1)
El siguiente arreglo muestra algunos valores de T evaluado en potencias
de 2:
T (1) = H(1)
T (2) = H(3 + n)
T (4) = H(7 + 3n)
T (8) = H(15 + 7n)
T (16) = H(31 + 15n)
...
Estos valores sugieren que:
T (2x) = H(2x+1 + 2x − 1)
La ecuación anterior se puede comprobar fácilmente con inducción. Aho-
ra, vamos a denir una variable n tal que n = 2x, la ecuación anterior se
expresaría de la siguiente manera:
T (n) = H(n(x + 1) + n − 1)
H(n(log2(n) + 1) + n − 1)
H(nlog2n + 2n − 1)

-- 145 of 315 --

146 CAPÍTULO 12. ORDENAMIENTO
n
n
2
n
22
...
n
2k
n
2k
...
n
22
... ...
n
2
n
22
... ...
n
22
... ...
n
2x
n
2x = Ox=lg n(n)
...
O2(n)
O1(n)
O0(n)
O(n · lg n)
+
+ +	+
+ +	· · ·
O
( k	∑
i=0
2i · n
2i
)
+
+
+
=
+
=
=
⇓
O
( x	∑
i=0
n
)
= O(x · n)
=
+ +
= ⇔
· · ·
Figura 12.1: Rendimiento del ordenamiento por mezcla
Y ahora, como H es una constante y por regla de la suma es fácil de ver
que T es de complejidad O(n log n).
La gura 12.1 ilustra este análisis que se acaba de realizar.
Cabe mencionar que la complejidad solamente fué comprobada para po-
tencias de 2, sin embargo, es fácil darse cuenta que si 2a ≤ n ≤ 2a+1 entonces
T (2a) ≤ T (n) ≤ T (2a+1), lo que prueba que T es de complejidad O(nlogn)
para cualquier entero n.
Existe también un algoritmo muy popular de ordenamiento llamado Quick-
sort que en la mayoría de los casos suele ser tan rápido como mezcla y
requiere menos memoria. Pero no se hablará de ese algoritmo en este libro
debido a la dicultad de analizar su tiempo de ejecución, si el lector quiere
aprender a usarlo puede consultar otro libro y usarlo bajo su propio riesgo.

-- 146 of 315 --

12.8. PROBLEMAS 147
12.8. Problemas
12.8.1. Mediana
Tiempo Límite: 1 segundo
Un nuevo experimento espacial involucra a N objetos etiquetados desde
1 hasta N
Se sabe de antemano que N es impar.
Cada objeto tiene una fuerza distinta(aunque desconocida) expresada por un
número natural.
El objeto con la fuerza mediana es el objeto X tal que hay exactamente
tantos objetos con una fuerza mas pequeña que X como objetos con una
fuerza mayor que X .
Desafortunadamente, la unica manera de comparar las fuerzas es por un
dispositivo que, dados 3 objetos distintos determina el objeto con fuerza
mediana tomando en cuenta solamente esos 3 objetos.
Problema
Escribe un programa que determine el objeto con la fuerza mediana.
Libreria
Dispones de una biblioteca llamada device con estas tres operaciones:
GetN, deberá ser llamado una vez al principio sin parámetros; regresa
el valor de N
Med3, deberá ser llamado con tres etiquetas de objetos como parámet-
ros; regresa la etiqueta del objeto con la fuerza media.
Answer, deberá ser llamado una sola vez al nal, con una etiqueta de
objeto como argumento; reporta la etiqueta del objeto X
Puedes experimentar con una biblioteca de diseño propio
Ejemplo
Secuencia
2 5 4 3 1
Interacción

-- 147 of 315 --

148 CAPÍTULO 12. ORDENAMIENTO