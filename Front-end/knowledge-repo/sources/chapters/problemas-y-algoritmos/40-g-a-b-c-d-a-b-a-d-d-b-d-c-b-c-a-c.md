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
se vaya a ejecutar el programa.
La solución para esto, es guardar los datos de todas las listas en un
solo arreglo, y guardar cual es el primer elemento de cada lista en otro
arreglo.
Además, será necesario tener una variable que indique el número de
aristas de la lista.
En el siguiente código ilustra cómo implementar un grafo con a lo mas
100 000 nodos y a lo mas un millón de aristas:

-- 200 of 315 --

16.4. RECORRIDOS EN GRAFOS 201
1 int dato [ 1 0 0 0 0 0 1 ] ; // El nodo h a c i a e l c u a l apunta
l a a r i s t a
2 int proximo [ 1 0 0 0 0 0 1 ] ; // El s i g u i e n t e e l e m e n t o de
l a l i s t a
3 int primero [ 1 0 0 0 0 1 ] ; // El primer e l e m e n t o de l a
l i s t a de cada nodo
4 int a r i s t a s =1; // El número de a r i s t a s
Aquí se declaró como una arista inicialmente para dejar libre el 0 para
expresar el elemento vacío que indica el nal de toda lista.
El procedimiento de insertar una arista entre 2 nodos también es algo
tedioso con listas de adyacencia comparandolo a lo simple que es con
matriz de adyacencia, la siguiente función inserta una arista entre los
nodos v y w en un grafo dirigido.
1 void i n s e r t a r _ a r i s t a ( int v , int w) {
2 dato [ a r i s t a s ]=w;
3 proximo [ a r i s t a s ]= primero [ v ] ;
4 primero [ v]= a r i s t a s ++;
5 }
Si se quiere que el grafo sea no dirigido simplemente hay que llamar a
la función anterior 2 veces
Como se ve en el código, la arista siempre se inserta al principio de
la lista de adyacencia, para que de esa forma, el conjunto de todas
las aristas se inserte en tiempo lineal; ya que si se recorriera la lista de
adyacencia cada que se quisiera insertar una nueva arista, insertar todo
el conjunto de aristas se realizaría en tiempo cuadratico, queda como
tarea para el lector demostrar por qué.
16.4. Recorridos en Grafos
Ahora que ya conocemos los grafos y cómo representarlos en una com-
putadra comenzaremos con una de sus aplicaciones mas básicas: los recorridos
en grafos o búsquedas.
La idea de recorrer un grafo se desprende de imaginar los nodos como
cuartos y las aristas como pasillos que conectan cuartos, y el recorrido es
visitar caminando todos los cuartos.
A estos recorridos les llamaremos caminos, los cuales se formalizan medi-
ante la siguiente denición:

-- 201 of 315 --

202 CAPÍTULO 16. GRAFOS
Denición 16.4.1 (Camino). Un camino C es una sucesión de vertices C =
(v1, v2, v3, ..., vn), tal que para toda 0 < i ≤ n existe una arista que conecta
vi con vi + 1.
Si es posible iniciar en un cuarto y visitar todos los demás entonces se
dice que grafo es conexo. O dicho de una manera mas precisa:
Denición 16.4.2 (Grafo conexo). Un grafo G = (V, A) es conexo si para
cada par de vertices v, w ∈ V existe un camino que inicia en v y termina en
w.
Básicamente las búsquedas sirven para visitar todos los vertices de un
grafo conexo, o bien de un subgrafo conexo de manera sistemática.
Es decir, iniciamos en el vertice A, y queremos saber desde ahí, a cuáles
vertices se puede llegar, y la manera de hacerlo es... ½Buscando!.
El primer recorrido que veremos será la busqueda en profundidad.
La busqueda en profundidad es un recorrido de grafos de naturaleza re-
cursiva(aunque se puede implementar de manera no recursiva).
¾Recuerdas la antigua leyenda del minotauro? En caso de que no la re-
cuerdes aquí va la parte que interesa:
Había un minotauro(un hombre con cabeza de toro) dentro de un laber-
into, un valiente joven, llamado Teseo se dispuso a matar al minotauro(el
minotauro mataba gente, asi que no tengas lastima del minotauro), pero
para no perderse en el laberinto, tomó una cuerda para ir marcando por
donde ya había pasado, y saber qué recorrido había seguido, para así poder
regresar. Luego cuando mató al minotauro regresó siguiendo su rastro, como
lo había planeado, y el resto ya no tiene que ver con el tema.
¾Qué moraleja nos deja esta historia?
Basicamente que si nos encontramos en un laberinto(o en un grafo), es
necesario ir marcando el camino por el que ya pasamos y saber por dónde
veníamos.
La idea de la búsqueda en profundidad es dejar una marca en el nodo que
se esta visitando; y despues visitar recursivamente los vecinos de dicho nodo
que no hayan sido visitados.
El siguiente codigo es una implementacion de la búsqueda en profundidad
en un grafo con N nodos y con matríz de adyacencia g:
1 void v i s i t a r ( int nodo ) {
2 v i s i t a d o [ nodo ] = 1 ;
3 for ( i =1; i<=N; i ++)
4 i f ( g [ nodo ] [ i ] ! = 0 && v i s i t a d o [ i ]==0){
5 v i s i t a r ( i ) ;

-- 202 of 315 --

16.4. RECORRIDOS EN GRAFOS 203
6 }
7 }
Hay que mencionar que en un grafo G = (V, A), la búsqueda en profun-
didad funciona con matriz de adyacencia en O(|V |2) mientras que con listas
de adyacencia funciona en O(|V | + |A|).
El otro recorrido que se va a tratar aquí es la búsqueda en amplitud(algunos
lo llaman búsqueda a lo ancho).
Lamentablemente la búsqueda en amplitud no fue idea de Teseo, y como
te imaginarás, es un poco mas difícil que a alguien se le ocurra hacerla si no
la conoce de antemano.
Para comenzar a adentrarnos en la búsqueda en amplitud es conveniente
que imagines la siguiente situación:
Eres miembro de una banda de bándalos(valga la redundancia), y la banda
tiene como centro de reunión una esquina de la ciudad. Los miembros de la
banda quieren que toda la ciudad sepa a cuántas cuadras se encuentran en
cada momento de su terrirtorio, asi que deciden dejar pintados mensajes
en la paredes de cada esquina de la ciudad diciendo a cuántas cuadras de
encuentran del territorio prohibido.
Ahora, el jefe de la banda te ha encargado a ti determinar qué número se
debe de pintar en cada esquina de la ciudad.
La tarea no es facil, ya que si haces rodeos, podrías llegar a creer que
estas mas lejos de lo que realmente te encuentras, y la ciudad no es muy
rectangular que digamos.
Conviene al lector detenerse unos momentos a reexionar sobre este prob-
lema y pensar en una posible solución antes de leerla.
Lo que deberías hacer en ese caso, es pintar una advertencia Alejate,
este es nuestro territorio en la esquina donde la banda tiene su centro de
reunión, luego caminar una cuadra en cualquier dirección y pintar algo asi
como estas a una cuadra de territorio prohibido, después regresar al punto
de encuentro y caminar una cuadra en otra dirección y otra vez pintar lo
mismo, repitiendo esa operación hasta que ya se haya caminado una cuadra
en todas las direcciones.
Después, para cada esquina donde hayas escrito estas a una cuadra de
terrirtorio prohibido, caminas una cuadra en todas las direcciones y escribes
estas a dos cuadras de territorio prohibido(claro, si no habías pintado nada
ahí anteriormente).
Y continúas así hasta haber pintado toda la ciudad o hasta ser atrapado
por la policía.
Es claro que el divertido ejemplo anterior solo pretende enseñar la idea
de la búsqueda en amplitud y no se espera que el lector realize tales actos.

-- 203 of 315 --

204 CAPÍTULO 16. GRAFOS
La idea de la búsqueda en amplitud es visitar un nodo inicial v, y luego
visitar los nodos que se encuentren a una arista de v, después los que se
encuentren a 2 aristas de v y asi sucesivamente.
De esa forma, la búsqueda en amplitud visita todos los nodos que pueden
ser alcanzados desde v, y para cada uno de ellos, calcula su distancia(mínimo
número de aristas) con v.
En la situación que imaginamos del bándalo pintando paredes, el bánda-
lo tenía que caminar mucho despues de pintar cada esquina, sin embargo,
como nosotros usaremos una computadora para realizar un proceso similar,
no necesitamos estar caminando, o recorriendo todo el grafo en busca del
siguiente vertice que hay que marcar.
Una forma mas rápida de obtener los mismos resultados es teniendo una
cola, y metiendo a v en la cola, luego. mientras la cola no este vacía, sacar
un vertice de la cola, visitarlo, y meter a los vecinos no visitados a la cola.
Una manera de hacerlo(asumiendo que la cola nunca se llenará) es la
siguiente:
1 c o l a [ f i n ++]=v ; // Meter v a l a c o l a
2 v i s i t a d o [ v ] = 1 ; // I n i c i a l i z a r
3 d i s t a n c i a [ v ] = 0 ;
4 while ( i n i c i o != f i n ) { // Mientras l a c o l a no e s t e
v a c í a
5 a=c o l a [ i n i c i o ++]; // Sacar de l a c o l a
6 for ( i =1; i<=N; i ++) // Meter v e c i n o s a l a
c o l a
7 i f ( g [ a ] [ i ] && v i s i t a d o [ i ]==0){
8 v i s i t a d o [ i ] = 1 ;
9 d i s t a n c i a [ i ]= d i s t a n c i a [
a ] + 1 ;
10 c o l a [ f i n ++]= i ;
11 }
12 }
El código anterior usa una matriz de adyacencia g, con N nodos.
Como nodo se visita una vez y cada arista se visita 1 o 2 veces dependiendo
de si el grafo es dirigido o no dirigido, este algoritmo funciona en tiempo
O(|V |2) con matriz de adyacencia y con listas de adyacencia funciona en
tiempo O(|V | + |A|).

-- 204 of 315 --

16.5. CONECTIVIDAD 205
16.5. Conectividad
Al inicio de la sección anterior se denió que era un grafo conexo y se
vió como recorrer un grafo conexo. Sin embargo no hemos analizado muy a
fondo todo lo que esto implica.
Denición 16.5.1 (Conectividad). Decimos que dos vértices v, w estan
conectados si existe un camino que los una. Y lo denotaremos como v w
Por facilidad vamos a pensar que todo vértice está conectado consigo
mismo, hay algunos problemas donde no es prudente pensar así, pero en
general es mucho mas manejable la conectividad si pensamos de esta manera.
Esta primera propiedad la llamaremos reexiva.
Hay que notar que para todo par de vértices v y w tales que v w
también w v; eso es fácil de ver ya que solamente hay que recorrer el
camino que une a v y w al revés para encontrar el camino que une a w con
v. Esta propiedad la llamaremos simétrica.
Otra propiedad interesante de la conectividad es que para 3 vértices u, v
y w, si u v y v w entonces u w. Esta propiedad la llamaremos
transitiva.
Una vez observadas estas 3 propiedades vamos a denir algo que llamare-
mos compontente conexa.
Denición 16.5.2 (Componente Conexa). Sea G = (V, A) un grafo y v ∈ V ,
la componente conexa de v es el conjunto de todos los vértices u ∈ V tales
que v u y se denota como [v].
Esta denición tiene una íntima relación con las 3 propiedades que acabamos
de enunciar. Como veremos a continuación con este teorema:
Teorema 26. Sea G = (V, A) un grafo y sean u, v ∈ V dos vértices cua-
lesquiera. Tenemos que u v se cumple sí y solo sí [u] = [v].
Demostración. Supongamos que u v, sea x ∈ [u] y sea y ∈ [v].
Sabemos por denición que v y y que u x.
Por la propiedad transitiva u y, por lo tanto y ∈ [u]. Por la propiedad
simétrica v u y por la transitiva v x por lo tanto x ∈ [v].
Es decir todo elemento de [u] también está en [v] y todo elemento de [v]
también está en [u] por lo tanto [u] = [v].
Ahora nos vamos a olvidar de que u y v están conectados y vamos a
suponer solamente que [u] = [v].
Por la propiedad reexiva u ∈ [u] pero como [u] = [v] entonces u ∈ [v] es
decir v u y por la propiedad simétrica u v.

-- 205 of 315 --

206 CAPÍTULO 16. GRAFOS
Teorema 27. Sea G = (V, A) y sean [u], [v] dos componentes conexas, ten-
emos que se cumple una de estas dos cosas:
[u] = [v] o bien
[u] ∩ [v] = ∅
Demostración. Sean u, v ∈ V vértices tales que u ∈ [u] y v ∈ [v], tenemos
que si u v entonces [u] = [v]. En caso contrario, para todo x ∈ [v] tenemos
que u no está conectado con x dado que x v, y análogamente para todo
y ∈ [u] tenemos que v no está conectado con y. Es decir, [u] y [v] no tienen
elementos en común.
Una vez vistos estos dos teoremas podemos apreciar como el problema
de determinar la conectividad entre todos los pares de vértices se reduce a
particionar el grafo en varias componentes conexas.
Una vez que se tiene las componentes conexas, para saber si dos vértices
estan conectados solamente hay que ver si pertenecen a la misma componente
conexa.
Además, para encontrar todas las componentes conexas lo único que hay
que hacer es recorrer cada una de ellas una sola vez. ½Eso es O(|V | + |A|)!.
En general esta forma de particionar un conjunto con respecto a una
relación tiene el nombre de clases de equivalencia y se puede hacer con
cualquier relación que sea reexiva, simétrica y transitiva (por ejemplo, la
relación del paralelismo entre rectas en el plano).
Observa nuevamente las demostraciones de los dos teoremas y te darás
cuenta que solamente se usaron las 3 propiedades enunciadas y no se usó en
absoluto el hecho de que se estuviera hablando de un grafo.
16.6. Árboles
Ya anteriormente se mencionaron los árboles binarios como estructura de
datos, sin embargo, la denición que se dió se aleja mucho de lo que realmente
es un árbol.
Antes de poder entender los árboles necesitamos denir los ciclos, un ciclo
es un camino que inicia y termina en el mismo vértice, es decir:
Denición 16.6.1 (Ciclo). Un ciclo es un camino C = (v1, v2, v3, ..., vn)
donde v1 = vn.
La idea empírica de los árboles se basa en tener un grafo compuesto por
ramicaciones, y en la cual cada ramicación se puede dividirse en otras

-- 206 of 315 --

16.6. ÁRBOLES 207
ramicaciones y así sucesivamente, tal como si se tuviera un tronco del cual
se desprenden ramas, y luego cada rama puede subdividirse a la vez en otras
ramas.
Esta idea de los árboles se formaliza con la siguiente denición:
Denición 16.6.2 (Árbol). Se dice que un grafo G = (V, A) es un árbol si
cumple con las siguientes dos condiciones:
Es conexo
No contiene ciclos
Los árboles además aparecen de manera natural en muchas situaciones,
como se demuestra con el siguiente par de teoremas:
Teorema 28. Sea G = (V, A) un grafo conexo, las siguientes tres proposi-
ciones son equivalentes:
G es un árbol.
Entre cada par de vértices existe un solo camino que no repite vértices
que los une.
|A| = |V | − 1
Demostración. Primero supongamos que G es un árbol, al ser un árbol(y por
tanto conexo) sabemos que entre cada par de vértices v y w existe al menos
un camino que los une, vamos a denotarlo como A = (a1, ..., an) donde a1 = v
y an = w.
Ahora, para probar que este camino es único vamos a suponer que existe
otro, el cual denotaremos como B = (b1, ..., bm) con b1 = v y bm = w.
Como A y B no son el mismo camino entonces existe al menos un entero
k tal que ak 6 = bk, también hay que notar que a1 = b1 y an = bm.
A lo que se intenta llegar con esto es que los dos caminos tienen un prejo
común, el cual sea tal vez de un solo nodo, y luego se vuelven a juntar en
otro nodo.
Dicho de otra manera podemos hablar del mayor entero i tal que a1 =
b1, a2 = b2, ...ai = bi, en este caso decimos que (a1, ..., ai) = (b1, ..., bi) es el
prejo que tienen en común A y B.
Tomando en cuenta que an = bm podemos estar seguros que al menos un
elemento de {ai+1, an} es igual a un elemento de {bi+1, bm}, ahora, de entre
todos esos elementos, vamos a elegir aquel que aparezca antes en A, y vamos
a denominarlo ax, además, como por denición aparece en ambos, vamos a
elegir alguna y tal que ax = by.

-- 207 of 315 --

208 CAPÍTULO 16. GRAFOS
Consideramos ahora el camino (ai, ai+1, ..., ax, by−1, by−2, ..., bi) este camino
es un ciclo, por lo tanto un árbol no puede tener mas de un camino uniendo
al mismo par de vértices. Es decir, si G es un árbol, entre cualquier par de
vértices existe un solo camino.
Para seguir probano que las tres proposiciones son equivalentes, ahora nos
vamosa olvidar de que G = (V, A) es un árbol y solo vamos a suponer que
entre cada par de nodos existe un único camino, e intentaremos demostrar
que |A| = |V | − 1.
Usaremos inducción, es tentador usar como caso base un grafo con un
solo vértice(en el cual es evidente que se cumple); sin embargo, resulta mas
cómodo usar como caso base un grafo con dos vértices.
Si solamente hay dos vértices, entonces solo puede haber una arista(existen
estructuras llamadas multigrafos que soportan varias aristas entre los mismos
dos vértices, pero no estamos hablando de ellas), y entre ese único par de
vértices hay un solo camino.
Ahora, si se tiene un grafo con n vértices(para n ≥ 2 ), n − 1 aristas, y
entre cada par de vértices hay un solo camino, entonces, si se añade una nueva
arista entre dos vértices v y w, entonces habría dos caminos que conectan a
v con w, uno sería el que ya se tenía antes, y el otro sería un camino de una
sola arista (v, w).
Aquí acabamos de demostrar una propiedad interesante, y es que si se
añade una arista a un grafo donde entre cada par de vértices hay un solo
camino, entonces, luego de ello, existirá al menos un par de vértices conecta-
dos por mas de un camino.
Continuado con la inducción, si le añadimos un vértice al grafo, llamé-
mosle v′ y lo conectamos con otro vértice w, tenemos que para cualquier otro
vértice u ∈ V existe un único camino que une a u con w, llamémosle C, y
por tanto existe un único camino entre u y v, el cual consiste de C seguido
de v.
Por lo tanto, por inducción, si entre cada par de vértices existe un solo
camino que los une, entonces |A| = |V | − 1.
El tercer paso de nuestra prueba es demostrar que si un grafo conexo
G = (V, A) tiene exactamente |V | − 1| aristas, entonces el grafo es un árbol.
Para demostrar eso vamos a recurrir a un concepto parecido al de árbol y
es el de bosque, un bosque es un grafo sin ciclos, el cual puede o no ser conexo.
Como se puede ver, un árbol es un bosque pero un bosque no necesariamente
es un árbol.
Un grafo con n vértices y ningún arista es un bosque y tiene n compo-
nentes conexas, además es el único grafo de n vértices que tiene exactamente
n componentes conexas. ½Esto es un buen caso base para inducción!
Supongamos que para un k > 0 todo grafo con n vértices, k aristas y

-- 208 of 315 --

16.6. ÁRBOLES 209
n − k componentes conexas es un bosque. Si a cualquiera de esos grafos le
añadiéramos una arista entre dos vértices de la misma componente conexa,
obtendríamos un grafo con n vértices, k + 1 aristas y n − k componentes
conexas.
Sin embargo, si añadimos una arista entre dos vértices de dos componentes
conexas distintas obtenemos un grafo con n vértices, k + 1 aristas y n − k − 1
componentes conexas. Este grafo será un bosque, puesto que conectar dos
componentes conexas distintas con una sola arista nunca crea un ciclo. Es
decir, todo grafo con n vértices, k +1 aristas y n−k −1 componentes conexas
será un bosque.
Por inducción un grafo con n vértices, n − 1 aristas será un bosque con
n − (n − 1) = 1 componentes conexas, es decir, un árbol.
Observamos que la primera proposición implica la segunda, la segunda
implica la tercera y la tercera implica la primera, de esta manera queda
demostrado que las tres proposiciones son equivalentes.
Un elemento muy interesante que poseen los árboles son las hojas, en los
árboles binarios las hojas son aquellos vértices que no tienen hijos, aquí son
algo parecido, son aquellos vértices que estan unidos solamente con vértice,
podemos pensar en ese vértice como si fuera el padre de la hoja.
Por lo tanto nuestra denición de hoja queda de la siguiente manera:
Denición 16.6.3 (Hoja). Una hoja es un vértice con grado 1.
Las hojas son un elemento interesante ya que son el punto de partida para
las soluciones de algunos problemas y además siempre están presentes en los
árboles, o mas objetivamente:
Teorema 29. Sea G = (V, A) un árbol, si |V | ≥ 2 entonces G tiene al menos
2 hojas.
Demostración. Es evidente que no hay vértices con grado 0, puesto que el
grafo no sería conexo y por tanto no sería un árbol.
Como la suma de los grados de un grafo 2|A| entonces la suma de los
grados de G es 2|V | − 2, si todos los vértices tuvieran grado mayor o igual a
2, entonces la suma de los grados sería al menos 2|V |, pero como esto no es
cierto, entonces existe un nodo de grado 1.
Si un solo nodo tuviera grado 1 y el resto de los nodos tuviera al menos
grado 2, entonces la suma de los grados sería al menos 2|V | − 1, como la
suma es 2|V | − 2 entonces al menos 2 nodos tienen grado 1, es decir, el árbol
tiene al menos 2 hojas.

-- 209 of 315 --

210 CAPÍTULO 16. GRAFOS
Ya vimos que todo grafo G = (V, A) con |V | − 1 aristas es un árbol, si
pensamos en un grafo conexo que tenga tantos vértices como aristas inmedi-
atamente se puede imaginar a un árbol con una arista adicional. Lo cual hace
pensar que es un grafo con un solo ciclo.
En este caso el sentido común no nos traiciona, ya que realmente el grafo
es un árbol con una arista adicional que posee un solo ciclo, sin embargo, aún
debemos de demostrarlo, pues debemos de considerar la posibilidad de que
haya mas de un ciclo o de que el grafo deje de ser conexo si se quita alguna
arista.
Teorema 30. Sea G = (V, A) un grafo conexo tal que |V | = |A| entonces G
contiene un solo ciclo.
Demostración. Si G no contuviera ciclos entonces sería un árbol y eso impli-
caría |A| = |V | − 1, lo cual es falso.
Ya demostramos que hay al menos un ciclo, ahora demostraremos que
hay un solo ciclo, sea C = (v1, ..., vn) un ciclo en G, tenemos que para v1, v2
existen al menos dos caminos que los unen por estar en un mismo ciclo.
Pero ya sabemos que {v1, v2} ∈ A por tanto (v1, v2) es un camino que
une a v1 con v2, ahora veremos que sucede si le quitamos la arista al grafo,
es decir, consideraremos el grafo H = (V, A − {v1, v2}).
Tenemos que H es conexo, ya que aún existe un camino que une a v1 con
v2, ya que para cada par de vértices u, w ∈ V existe un camino que los une en
G, si la arista {v1, v2} no está presente en el camino, entonces dicho camino
también existe en H, y si está presente, entonces es posible reemplazarla por
este camino (v2, ..., vn, v1).
Como el número de aristas en H es |A| − 1 entonces H es un árbol y no
tiene ciclos. Es decir, todos los ciclos en G tienen la arista {v1, v2}.
Ahora, tomemos dos ciclos cualesquiera en H, si quitamos a {v1, v2}, luego
de eso habrá un único camino entre v1 y v2, el cual es (v2, ..., vn, v1), y ambos
ciclos unen a v1 y a v2 con 2 caminos incluyendo el camino de una sola arista,
por lo tanto ambos ciclos pasan por ese camino y por la arista {v1, v2}, es
decir, son el mismo ciclo.
Los árboles estan íntimamente ligados a la conectividad, como se ve
en la demostración del teorema 28. A continuación observaremos algunas
propiedades de los árboles que los convierten en un objeto importante de
estudio dentro de la conectividad.
Como ya habíamos visto, un árbol se dene como un grafo conexo sin
ciclos, el hecho de que no tenga ciclos hace suponer que tiene pocas aristas,
por ello, para encontrar un grafo conexo con pocas aristas, suena razonable
buscar un árbol.

-- 210 of 315 --

16.6. ÁRBOLES 211
La propiedad que estudiaremos ahora nos dice que no solo es razonable
buscar un árbol, sino que es lo mejor. Es decir, no hay un grafo conexo que
tenga menos aristas que un árbol, dicha propiedad se resume en el siguiente
teorema:
Teorema 31. Sea G = (V, A) un grafo tal que |A| < |V | − 1 entonces, el
grafo no es conexo.
Demostración. Tomemos un grafo H0 = (V, ∅), es decir un grafo con los mis-
mos vértices que V pero sin aristas, H0 tiene exactamente |V | componentes
conexas.
Vamos a denir Hn como un subgrafo de G con exactamente n aristas.
Supongamos que para cualquier entero k, Hk tiene al menos |V | − k
componentes conexas. Si se añade una arista entre 2 vértices v, w, si [v] 6 =
[w] el número de componentes conexas disminuye en 1, y si [v] = [w] el
número de componentes conexas se mantiene, por lo cual Hk+1 tendrá al
menos |V | − (k + 1) componentes conexas.
Por inducción Hn tiene al menos |V | − n componentes conexas. Notamos
que G = H|A|, por lo tanto, el grafo tiene al menos |V | − |A| componentes
conexas, pero |V | − |A| > 1, por lo tanto G tiene mas de una componente
conexa, es decir, no es conexo.
A veces lo que se necesita hacer es encontrar un grafo conexo, y ya vimos
que si se quieren tener pocas aristas lo mejor es tener un árbol. Sin embargo,
si se quiere trabajar con un subgrafo conexo de un grafo conexo, hasta el
momento nada nos dice qué subgrafo tomar si queremos simplicar las cosas
usando pocas aristas.
El lector puede estar pensando en tomar un árbol, este árbol es llamado
árbol de expansión, ya vimos en la demostración del teorema 30 que este arbol
siempre existe con un grafo conexo que tiene tantos vértices como aristas,
veamos un caso mas general:
Teorema 32. Sea G = (V, A) un grafo conexo, entonces existe un árbol
T = (V, A′) tal que A′ ⊆ A, el cual es llamado árbol de expansión de G.
Demostración. Como G es conexo |A| ≥ |V | − 1.
Si |A| = |V | − 1 entonces G es un árbol, en este caso existe un árbol de
expansión de G el cual es G.
Ahora, si |A| > |V | − 1 entonces G al ser conexo y no ser un árbol tiene al
menos un ciclo, si quitamos cualquier arista del ciclo, el grafo seguirá siendo
conexo, si se repite esta operación |A|−(|V |−1) veces, el grafo seguirá siendo
conexo y será un árbol.
Dicho árbol está contenido en el grafo original, y es el mencionado árbol
de expansión.

-- 211 of 315 --

212 CAPÍTULO 16. GRAFOS
16.7. Unión y Pertenencia
Ya vimos en la sección anterior como los árboles se relacionan de una
manera natural con la conectividad, ahora vamos a aprovechar todo esto
para resolver el problema de unión-pertenencia.
Este problema es un problema de diseño de estructura de datos, es decir,
ocupamos mantener un conjunto de datos y estarlo continuamente actual-
izando. En este problema hay que diseñar una estructura de datos con la
cual podamos representar estas dos operaciones en un grafo:
Unión. Añadir una arista entre dos vértices.
Pertenencia. Saber si un par de vértices estan conectados.
Pueden sonar extraños los nombres de las operaciones. Se llaman así
porque se puede pensar en cada componente conexa como un conjunto.
Añadir una arista entre dos vértices es equivalente a unir dos conjuntos.
Saber si dos vértices se encuentran en la misma componente conexa se puede
interpretar como saber que dos vértices se encuentran en el mismo conjunto.
A pesar de esta notación sugestiva, aquí seguiremos tratando este prob-
lema como un problema de conectividad.
Hasta el momento, con lo que hemos visto la única manera de atacar este
problema sería realizando múltiples búsquedas.
Podríamos realizar la unión añadiendo una arista en tiempo constante si
representamos el grafo con listas de adyacencia, pero si usamos una búsque-
da para la operación de pertenencia nos tomaría tiempo lineal; y en este
problema hay que estar preparados para poder ejecutar muchas veces ambas
operaciones.
Otra cosa que podríamos hacer es numerar las componentes conexas y
mantener un arreglo diciendo a qué componente pertenece cada uno de los
vértices. Con esto podríamos lograr la pertenencia en tiempo constante, pero
la unión en el peor de los casos seguiría funcionando en tiempo lineal ya que
habría que reasignar la componente conexa a varios vertices.
En estos momentos parece claro que si seguimos pensando en optimiza-
ciones menores para las búsquedas no llegaremos a mucho, necesitamos pro-
fundizar mas al respecto.
Si recordamos la sección anterior, todo grafo conexo tiene un árbol de
expansión, por lo tanto, toda componente conexa también tiene un árbol de
expansión. Hay que observar que si dos árboles son unidos por una arista,
entonces el resultado será otro árbol sin importar qué vertice se elija en cada
árbol.

-- 212 of 315 --

16.7. UNIÓN Y PERTENENCIA 213
Tambien hay que recordar que solo nos interesan las operaciones de unión
y pertenencia. Con todo esto ya podemos estar seguros que no es necesario
guardar todas las aristas, es suciente con guardar un árbol de expansión de
cada componente conexa.
Pero esta propiedad no basta para diseñar una estructura de datos e-
ciente. Recordemos que en un árbol entre todo par de vértices hay un único
camino que los une(claro que descartando los caminos que repiten vértices).
Consideremos un árbol T = (V, A), vamos a elegir arbitrariamente un
vértice r, al cual llamaremos raíz. Está claro que para cualquier vértice v ∈ V
existe un único camino que lo une con r, vamos a llamar P [r] al segundo
vértice de dicho camino(el primer vértice del camino claramente es v), si
v = r entonces el camino consta solamente de un vértice y por conveniencia
diremos que P [r] = r.
Así que para llegar v a la raiz simplemente hay que seguir este algoritmo
recursivo:
1 int e n c u e n t r a _ r a i z ( int v ) {
2 i f (P [ v]==v ) {
3 return v ;
4 } e l s e {
5 return e n c u e n t r a _ r a i z (P [ v ] ) ;
6 }
7 }
Volviendo al problema original, si en lugar de guardar todo el grafo simple-
mente guardamos un árbol de expansión del grafo original entonces podemos
a cada componente conexa asignarle una raíz, si hiciéramos esto ya no necesi-
taríamos usar listas de adyacencia ni búsquedas, simplemente guardaríamos
para cada vértice v el valor de P [v], y de esta manera desde cualquier vértice
podríamos llegar a la raíz de su componente conexa.
Si dos vértices estan conectados, entonces estan en la misma componente
conexa. Si estan en la misma componente conexa entonces estan conecta-
dos con la misma raíz. Análogamente si estan conectados con la misma raíz
entonces están en la misma componente conexa y por tanto estan conectados.
Bajo este esquema debemos de notar también que solamente necesitamos
tener un árbol para cada componente conexa y cada árbol debe de contener
a los vértices de su respectiva componente. Pero no nos importa la estructura
del árbol, solamente qué vertices tiene, por lo tanto no es necesario que sea
un árbol de expansión.
Si queremos unir dos componentes conexas A y B, basta con hacer que la
raíz de A apunte a la raíz de B(o viceversa), de esa manera todos los nodos
A estarán conectados con la misma raíz que todos los nodos de B.

-- 213 of 315 --

214 CAPÍTULO 16. GRAFOS
Nuestro procedimiento de unión queda de la siguiente manera:
1 void union ( int a , int b ) {
2 int ra , rb ;
3 ra=e n c u e n t r a _ r a i z ( a ) ;
4 rb=e n c u e n t r a _ r a i z ( b ) ;
5 P [ ra ]= rb ;
6 }
La gura 16.3 muestra un ejemplo de la ejecución de la funcion union
cuando es llamada varias veces.
Y como dos vértices estan conectados sí y solo sí estan conectados con
la misma raíz entonces nuestro procedimiento de pertenencia queda de la
siguiente manera:
1 bool p e r t e n e n c i a ( int a , int b ) {
2 i f ( e n c u e n t r a _ r a i z ( a )==e n c u e n t r a _ r a i z ( b ) ) {
3 return true ;
4 } e l s e {
5 return f a l s e ;
6 }
7 }
No hay que olvidarse de que también el grafo necesita ser inicializado.
Para este problema normalmente se considera que al inicio el grafo contiene
solo vértices y no tiene aristas, por lo cual debe de haber |V | componentes
conexas y cada vértice es la raíz de su propia componente conexa. El siguiente
código inicializa un grafo con n vértices, como ya lo debes imaginar, este
código debe de ser llamado antes de usar unión o pertenencia.
1 void i n i c i a l i z a ( int n ) {
2 int i ;
3 for ( i =0; i <n ; i ++){
4 P [ i ]= i ;
5 }
6 }
Es claro que este algoritmo es bastante mas rápido que hacer búsquedas,
sin embargo, aún no lo analizamos adecuadamente.
16.8. Mejorando el Rendimiento de Unión-Pertenencia
Cómo recordará el lector, el algoritmo para resolver el problema de unión-
pertenencia se basa en tener varios árboles con raíces asignadas, donde cada

-- 214 of 315 --

16.8. MEJORANDO EL RENDIMIENTO DE UNIÓN-PERTENENCIA215
Conguración
inicial 0 1 2 3 4 5
0 1 2 3 4 5
union(0, 2) 2 1 2 3 4 5
0 1 2 3 4 5
union(4, 3) 2 1 2 3 3 5
0 1 2 3 4 5
union(1, 3) 2 3 2 3 3 5
0 1 2 3 4 5
union(5, 0) 2 3 2 3 3 2
0 1 2 3 4 5
union(0, 4) 2 3 3 3 3 2
0 1 2 3 4 5
Figura 16.3: Ejecución del algoritmo de unión-pertenencia

-- 215 of 315 --

216 CAPÍTULO 16. GRAFOS
vértice apunta a su padre, y para unir dos árboles hacemos que la raíz de uno
apunte a la raíz del otro.
Ya debemos de acordarnos de los árboles binarios de búsqueda y cómo a
veces los árboles que se crean pueden tener alturas terriblemente grandes, de
manera que son similares a listas enlazadas.
En estos árboles tambien puede pasar lo mismo. Vamos a denir la altura
de un árbol de la siguiente manera:
Denición 16.8.1 (Altura). La altura de un árbol T = (V, A) con raíz
r ∈ V , es la distancia entre v y r donde v ∈ V es el vértice mas lejano a r.
Si dos árboles de alturas h1 y h2 se unen con el procedimiento de la sección
anterior, el árbol resultante puede tener altura igual a h1 + 1 o bien altura
igual a h2. Lo primero sucedería en el caso de que h1 ≥ h2 y lo segundo
sucedería en el caso de que h1 < h2.
Esto es una fuerte sugerencia de que al realizar uniones entre árboles es
mejor hacer que la raíz de un árbol con altura mínima apunte al otro árbol,
si hacemos esto para obtener un árbol de altura 1 se necesitarían 2 de altura
0, para obtener uno de altura 2 se necesitarían 2 de altura 1, para obtener
un árbol de altura 3 se necesitarían 2 de altura 2, o de manera mas general:
para obtener un árbol de altura n > 0 serían necesarios al menos dos árboles
de altura n − 1.
Si denimos h(n) como el número mínimo de vértices que se pueden usar
para construir un árbol de altura n, tenemos que h(0) = 1, y que h(n) =
2h(n − 1), por lo tanto si tenemos 2n vértices el árbol mas alto que se puede
construir tendría altura n.
Por lo tanto, de esta manera tanto la unión como la pertenencia tendrían
un tiempo de ejecución de O(log N ), donde N es el número de vértices. Esto
es bastante razonable.
Sin embargo todo esto se puede simplicar aún más si cada vez que se
encuentra una raíz se borran todas las aristas que se recorrieron y se colocan
aristas que apunten directamente a la raíz. Si hacemos esto, cada arista sería
recorrida a lo más una vez, salvo que apunte directamente a la raíz.
Implementar esto es batante sencillo, basta con modicar el procedimiento
para encontrar raíz de la siguiente manera:
1 int e n c u e n t r a _ r a i z ( int v ) {
2 i f (P [ v]==v ) {
3 return v ;
4 } e l s e {
5 P [ v]= e n c u e n t r a _ r a i z (P [ v ] ) ;
6 return P [ v ] ;

-- 216 of 315 --

16.8. MEJORANDO EL RENDIMIENTO DE UNIÓN-PERTENENCIA217
7 }
8 }
Como cada arista que no apunta directamente a la raíz se recorre a lo más
una vez y todas las aristas son creadas mediante una operación de unión,
entonces el algoritmo toma un tiempo de O(u + p) donde u es el número de
llamadas a la operación unión, y p es el número de llamadas a la operación
pertenencia.
Esto no quiere decir que el procedimiento unión y el procedimiento perte-
nencia tomen tiempo constante, ya que el tiempo de ejecución del algoritmo
no se distribuye uniformemente entre todas las llamadas a estos procedimien-
tos.

-- 217 of 315 --

218 CAPÍTULO 16. GRAFOS
16.9. Problemas
16.9.1. Una Ciudad Unida
Tiempo Límite: 1 segundo
Unos ambiciosos ingenieros tienen pensado construir una gran ciudad a
partir de unos planos que elaboraron.
El plano de la ciudad consta de N esquinas y M calles bidireccionales.
Cada calle une a lo mas a dos equinas.
Se dice que existe un camino que une a dos esquinas v y w, si v = w, si hay
una calle conectando directamente a las dos esquinas, o si existe una secuencia
de esquinas a1, a2, a3, ..., ak, tal que a1 = v, ak = w, y toda ai(menos ak) está
unida directamente con ai+1 por una calle.
Los ingenieros se preguntan si habrán planicado mal algo, como por ejemplo,
que si una persona vive en una esquina A y quiere ir a visitar a un amigo
que vive en una esquina B, no exista un camino que le permita llegar a la
esquina B.
Problema
Debes hacer un programa que dado un plano de la ciudad, determine
cuantos pares de esquinas hay tales que no exista un camino que las una.
Entrada
Descripción
Línea 1: 2 números enteros N y M separados por un espacio.
Siguientes M líneas: Cada línea representa una calle y contiene 2 números
enteros representando los números de las esquinas que une la calle.
Ejemplo
5 3
1 2
2 4
3 5

-- 218 of 315 --

16.9. PROBLEMAS 219
Salida
Descripción
Línea 1: Un solo número entero, el número de pares de esquinas para las
cuales no existen
Ejemplo
6
Consideraciones
0<2000<N
0<100000<M
Referencias
El problema fue escrito por Luis Enrique Vargas Azcona y fué utilizado
por primera vez en un examen preselectivo de la Olimpiada de Informática
durante el 2007.

-- 219 of 315 --

220 CAPÍTULO 16. GRAFOS
16.9.2. Abba
Tiempo Límite: 1 segundo
Descripción
Dada una cadena de caracteres S, la operación reemplaza(a, b) cam-
bia cada una de las ocurrencias del caracter a por el caracter b. Por ejemplo, si
S = abracadabra entonces reemplaza(b, c) produce la cadena acracadacra.
Un palíndrome es una cadena de caracteres que se lee de la misma forma
de izquierda a derecha que de derecha a izquierda. Por ejemplo, abba y dad
son palíndromes.
Problema
Escribe un programa que lea una cadena de caracteres S y que encuentre
el número mínimo r de aplicaciones de la operación reemplaza que transfor-
man a S en un palíndrome.
Entrada
Un solo renglón que contiene una cadena S formada exclusivamente por
letras minúsculas del alfabeto inglés.
Ejemplo
croacia
Salida
El valor de r.
Ejemplo
3
Consideraciones
La cadena S tendrá una longitud entre 1 y 1,000,000.

-- 220 of 315 --

16.9. PROBLEMAS 221
Referencias
La idea original del problema fue de Sergio Murguía, el problema fué
redactado por Francisco Javier Zaragoza Marinez y fue utilizado por primera
vez en un examen selectivo de la Olimpiada Mexicana de Informática durante
Julio del 2007.

-- 221 of 315 --

222 CAPÍTULO 16. GRAFOS
16.9.3. Códigos de Prüfer
Tiempo Límite:1 Segundo
El matemático Heinz Prüfer inventó una forma ingeniosa de nombrar
árboles cuyos vertices esten etiquetados de manera única con los números
enteros de 1 a n
La forma de nombrar el árbol consiste de un código con n − 2 números
llamado código de Prüfer. Dicho código se obtiene mediante el siguiente al-
goritmo: