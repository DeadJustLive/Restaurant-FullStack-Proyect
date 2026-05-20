# Parte VI

Optimización Combinatoria
239

-- 239 of 315 --



-- 240 of 315 --

Cap´ıtulo 19
Estructura de la Solución y Espacio de
Búsqueda
Gran parte de los problemas tratados en la algoritmia son de optimización
combinatoria; es decir, dentro de un conjunto nito, elegir el mejor elemento
o encontrar aquellos elementos que cumplan con una característica especial.
Esto suena como si fuera algo realmente sencillo, pues todo lo que hay
que hacer es evaluar uno por uno y quedarse con el mejor. Lo interesante de
estos problemas radica en encontrar el mejor mas rapidamente o en reducir
el número de posibles soluciones.
Al procedimiento de evaluar candidato que pudiera ser una solución le
llamamos búsqueda(reriéndonos a que se está buscando una solución), y al
conjunto dentro del cual tenemos que encontrar la solución le llamaremos
espacio de búsqueda.
Aquí hay que aclarar que no se está abusando de la palabra búsqueda, la
cual es usada para referirse a los recorridos en grafos, ya que un grafo es en
escencia un espacio de búsqueda.
Por lo general la denición de espacio de búsqueda es simplemente el con-
junto de todos los posibles candidatos a ser una solución de un problema de
optimización. Sin embargo, para nuestros propósitos usaremos una denición
algo diferente, la cual requiere de un poco mas de texto para entender tanto
su signicado como su motivación.
Por el momento nos quedaremos con la siguiente denición provicional:
Denición 19.0.1 (Espacio de Búsqueda(denición temporal)). Un conjun-
to que contiene a todos los candidatos para ser una solución de un problema
de optimización.
Es decir es un conjunto al cual pertenece la solución del problema, pudi-
endo tener otros elementos que no sean la solución.
241

-- 241 of 315 --

242CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA
Lo primero que se necesita para hacer uso ecaz de una búsqueda es denir
un espacio de búsqueda, este paso es obvio, antes de buscar, requerimos saber
en donde buscar. Pero aún cuando parezca obvio, es el paso más difícil de
todos y el que menos programadores son capaces de tomar.
Como buen programador es indispensable que puedas denir un espacio de
búsqueda para cualquier problema que se te presente, de otra forma tendrás
serios problemas para poder encontrar soluciones a problemas que no sean
triviales.
Para poder denir el espacio de búsqueda, es necesario conocer la es-
tructura de la solución, es decir, ¾Qué es la solución que me piden? ¾Qué
estructura tiene? ¾Cómo se puede representar?
19.1. Estructura de la Solución
Normalmente la estructura de la solución de un problema de optimización
combinatoria se puede simplicar a una sucesión de decisiones, cada decición
representada mediante un número.
Por ejemplo en el siguiente problema:
Problema Resuelto 19.1.1. En una tienda venden paquetes de crayones,
el paquete de 11 crayones cuesta $15, el paquete de 20 cuesta $25, el paquete
de 2 cuesta $5.
Se cuenta con exactamente $30, ¾cuál es la mayor cantidad de crayones
que se pueden comprar?
Solución Este problema se puede reducir a tomar estas 3 deciciones:
¾Cuántos paquetes de 11 crayones comprar?
¾Cuántos paquetes de 15 crayones comprar?
¾Cuántos paquetes de 2 crayones comprar?
Se pueden comprar a lo mas 2 paquetes de 11, a lo más un paquete de 15
y a lo más 6 paquetes de 2. Nuestra estructura de la solución puede ser una
terna ordenada de enteros indicando cuántos paquetes se van a comprar de
cada tipo.
Por lo tanto nuestro espacio de búsqueda es el siguiente:

-- 242 of 315 --

19.1. ESTRUCTURA DE LA SOLUCIÓN 243
(0)
(0, 0)
(0, 0, 0) (0, 0, 1) ...
(0, 1)
(1)
(1, 0) (1, 1)
... (1, 1, 0) (1, 1, 1)
Figura 19.1: Árbol de Decisiones
{(0, 0, 0), (0, 0, 1), (0, 0, 2), (0, 0, 3), (0, 0, 4), (0, 0, 5), (0, 0, 6)
(0, 1, 0), (0, 1, 1), (0, 1, 2), (0, 1, 3), (0, 1, 4), (0, 1, 5), (0, 1, 6)
(1, 0, 0), (1, 0, 1), (1, 0, 2), (1, 0, 3), (1, 0, 4), (1, 0, 5), (1, 0, 6)
(1, 1, 0), (1, 1, 1), (1, 1, 2), (1, 1, 3), (1, 1, 4), (1, 1, 5), (1, 1, 6)
(2, 0, 0), (2, 0, 1), (2, 0, 2), (2, 0, 3), (2, 0, 4), (2, 0, 5), (2, 0, 6)
(2, 1, 0), (2, 1, 1), (2, 1, 2), (2, 1, 3), (2, 1, 4), (2, 1, 5), (2, 1, 6)}
Muchas veces resulta conveniente visualizar esta sucesión de decisiones
como árboles enraizados(con raíz), donde cada nodo representa un prejo
de uno o mas candidatos a soluciones, como te podrás imaginar un nodo
padre es prejo de toda su descendencia y las hojas representan los elementos
del espacio de búsqueda. Estos árboles a menudo son llamados árboles de
decisiones.
Denición 19.1.1 (Árbol de Decisiones). Si un espacio de búsqueda S posee
como elementos solamente sucesiones nitas, entonces S posee un árbol de
decisiones.
El árbol de decisiones de S es un árbol enraizado T = (V, A) con raíz r
en el cual se cumplen las siguientes condiciones:
Para todo nodo v ∈ V existe p(v) tal que p(v) es prejo de algun
elemento de S. Llamaremos p(v) la subsolución asociada a v.

-- 243 of 315 --

244CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA
Para todo prejo x de todo elemento s ∈ S existe un nodo v ∈ V tal
que p(v) = x.
Si para dos nodos u, v ∈ V , u es padre de v entonces p(u) es prejo de
p(v).
La gura 19.1 muestra el árbol correspondiente al espacio de búsqueda
que denimos. Obviamente solo muestra algunos nodos, ya que ocuparía
demasiado espacio en la página. Notamos como la raíz está vacía, los hijos
directos de la raíz constan de un solo número, los nodos a distancia 2 de la
raíz son pares ordenados y las hojas, que estan a distancia 3 de la raíz, son
ternas ordenadas.
Aquí debemos de notar que no todas las ternas del espacio de búsqueda
son aceptables, puesto que algunas se exceden del presupuesto, por ejemplo,
la terna (2, 1, 6) no es aceptable, ya que comprar 2 paquetes de 11 crayones,
1 de 15 y 6 de 2 cuesta 30 + 15 + 30 = 75 y en este problema solamente se
dispone de la cantidad de 30.
El objetivo del espacio de búsqueda no es ser una solución al problema,
ni ser un conjunto de soluciones aceptables, de hecho puede haber muchos
espacios de búsqueda válidos para un mismo problema.
El objetivo real de un espacio de búsqueda es ser un conjunto nito donde
seguramente se encuentre la solución, muchas veces es preferible que este con-
junto sea pequeño, sin embargo a veces es mas sencillo trabajar con espacios
mas grandes.
Volviendo al problema, si vericamos todas las ternas, una por una, lle-
garemos a la conclusión de que (2, 0, 0) representa la solución al problema,
es decir, la solución es comprar 2 paquetes de 11.

El ejemplo anterior fue algo burdo y muy probablemente el lector llegó a
la conclusión de los 2 paquetes de 11 sin necesidad de vericar cada terna en
el espacio de búsqueda. No hay que subestimar el ejemplo, se incluyó para
ilustrar como la estructura de la solución de un problema de optimización
combinatoria se puede reducir a tomar una sucesión de decisiones(en este
caso 3 decisiones).
El identicar correctamente la estructura de la solución y visualizar el
espacio de búsqueda como un árbol enraizado ya es un gran paso, y ahora
podemos entender las búsquedas que ya se presentaron anteriormente de la
siguiente manera:
Búsqueda en Profundidad. Procedimiento recursivo que trata de
llegar siempre lo más profundo que pueda, en cada paso, si aún no ha

-- 244 of 315 --

19.2. JUEGO DE NÚMEROS 245
encontrado la solución, trata de bajar un nivel en el árbol, si no es
posible bajar más, entonces regresa un nivel y trata de bajar por la
siguiente rama que todavía no haya recorrido.
Búsqueda en Amplitud. Recorre el árbol nivel por nivel, es decir, en
el primer paso busca la solución entre todos los nodos del primer nivel
del árbol, si no encuentra la solución, entonces baja un nivel y la busca
entre todos los nodos del segundo nivel, y de esa manera recorre cada
uno de los niveles hasta encontrar la solución.
Aquí hay que hacer notar que las búsquedas en amplitud son especial-
mente útiles cuando lo que se desea es la solución que este más cercana a la
raíz del árbol, ya que al ir recorriendo nivel por nivel, la primera solución
que se encuentra es aquella que esta más cercana a la raíz.
También es agradable notar que no hemos dejado de ver las búsquedas
como recorridos de grafos, ya que un árbol enraizado también es un grafo.
Dedicaremos las siguientes secciones completamente a ejemplicar el uso
de búsquedas identicando los árboles de decisiones correspondientes así co-
mo a notar las deciencias que tiene este modelo y motivar otra forma mas
renada de ver los espacios de búsqueda.
Es importante leer estas secciones ya que además de ilustrar como usar las
búsquedas en problemas no triviales, nos llevarán a nuestra nueva concepción
de espacio de búsqueda y en el camino se darán mas deniciones.
19.2. Juego de Números
Esta sección se dedica exclusivamente a un problema, el cual llamaremos
Juego de Números no sobra decir que este fué uno de los primeros problemas
utilizados para entrenar y elegir a la selección mexicana para la Olimpiada
Internacional de Informática del 2005.
El contexto del problema es el siguiente:
Hay un juego, que se juega sobre un tablero de N xN casillas, en cada
casilla hay un número distinto entre 1 y N 2, por lo que todas las casillas del
tablero estan llenas.
El objetivo del juego consiste en llevar la conguración inicial del tablero a
una conguración en la que los números del 1 al N 2 se encuentren ordenados
comenzando de izquierda a derecha y de arriba a abajo.
Es decir, si el tablero inicialmente estuviera como se muestra en la gura
19.2 el objetivo del juego sería llevarlo a la conguración de la gura 19.2.
Para mover números de su lugar te puedes posicionar en cualquier casilla
(i, j) tal que 1 ≤ i < N y 1 ≤ j < N .

-- 245 of 315 --

246CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA
2 5 3
1 8 4
7 9 6
Figura 19.2: Estado inicial del tablero
1 2 3
4 5 6
7 8 9
Figura 19.3: Estado nal del tablero
Una vez en la casilla (i, j) se puede hacer una rotacion, ya sea en sentido
horario o antihorario utilizando las casillas (i + 1, j), (i + 1, j + 1) y (i, j + 1).
Por ejemplo, para el de la gura 19.2 si nos posicionaramos en la casil-
la (2, 2) podemos hacer una rotacion(horario o antihoraria) con las casillas
(3, 2), (2, 3) y (3, 3). Las guras 19.2 y 19.2 muestran ambas rotaciones.
Problema Resuelto 19.2.1. Escribe un programa que dada la congura-
cion inicial de un tablero de 3 x 3 determine cual es el numero minimo de
movimientos que se requieren para ordenarlo. Se considera un movimiento
cualquier giro que se haga, ya sea en sentido horario o antihorario.
El programa deberá de funcionar en menos de un segundo.
Estructura de la Solución
Primero que nada identicaremos la estructura de la solución, y para eso
debemos de responder esta pregunta ¾qué nos está pidiendo el problema?
La respuesta es sencilla: Nos está solicitando el número mínimo de movimien-
tos para llegar de una permutación inicial de las casillas a una permutación
nal.
Es conveniente ver el estado del tablero como una permutación de 9
números enteros, donde los primeros 3 corresponden a la primera la, los
1 2 3
4 8 5
7 9 6
Figura 19.4: Rotación horaria en (2, 2)

-- 246 of 315 --

19.2. JUEGO DE NÚMEROS 247
1 2 3
4 6 9
7 5 8
Figura 19.5: Rotación antihoraria en (2, 2)
siguientes 3 a la segunda la y los últimos 3 a la última la. Siendo así la
permutación nal es (1, 2, 3, 4, 5, 6, 7, 8, 9).
Aunque este problema consiste en encontrar el número mínimo de movimien-
tos para acomodar el tablero, si vemos la respuesta como un número es claro
que no avanzaremos mucho. Vamos a cambiar un poco el problema con el
n de poder denir subsoluciones: en lugar de buscar únicamente el mínimo
número de movimientos para acomodar el tablero por el momento supon-
dremos que también necesitamos saber qué movimientos hacer para acomodar
el tablero.
Ahora podemos ver el espacio de búsqueda como un árbol enraizado,
donde cada nodo representa una sucesión de movimientos, la raíz representa
la ausencia de movimientos, los 8 nodos a distancia 1 de la raiz representan las
8 rotaciones(2 rotaciones diferentes en cada uno de los 4 lugares diferentes)
que se pueden realizar, los 64 nodos a distancia 2 de la raíz representan los
64 pares de rotaciones que se pueden realizar, etc.
Debido a que hay 8 rotaciones válidas en este juego, de cada estado surgen
8 nuevos estados, lo que ocasiona que el árbol de búsqueda crezca demasiado
rápido. Hay un nodo a distancia 0 de la raíz, 8 nodos a distancia 1, 64 nodos
a distancia 2, 512 nodos a distancia 3, etc.
Es decir, a distancia n hay 0+8+64+...+8n nodos, lo cual es equivalente
a 8n+1−1
7 nodos. Si buscaramos una solución de tamaño 10 tendríamos que
revisar un total de ½153391689 nodos!.
Esto pudiera parecer un callejón sin salida, ya que realmente no podemos
revisar todas las subsoluciones (sucesiones de movimientos, en este caso) que
se pueden realizar.
Sin embargo hay algo que nos puede sacar de este apuro: Hay solamente
9! = 362880 acomodos del tablero posibles. También debemos de notar que
para dos subsoluciones A = (a1, a2, ..., an) y B = (b1, b2, ..., bm) con n < m,
si A y B llegan al mismo acomodo del tablero, entonces A puede ser prejo
de una solución pero B no puede ser prejo de una solución.
Recordamos que nuestra denición de solución es aquella sucesión nita
de movimientos que lleva el tablero del estado inicial al nal y que además
dicha sucesión tiene longitud mínima.
Si B fuera prejo de una solución S = (s1, s2, ..., s′
m), signicaría que

-- 247 of 315 --

248CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA
b1 = s1, b2 = s2, ..., bm = sm, es decir, que una solución sería realizar los
m movimientos de B llevando al tablero a un acomodo P y luego realizar
m′ − m movimientos llevando al tablero al acomodo nal.
Pero si eso sucediera entonces sería posible llevar al tablero al al mismo
acomodo P realizando n < m movimientos y luego realizar los movimientos
sm+1, sm+2, ..., s′
m llevando al tablero al estado nal.
Es decir la subsolución T = (a1, a2, ..., an, sm+1, sm+2, ..., s′
m) llevaría al
tablero del acomodo inicial al acomodo nal, y además la longitud de T sería
n + m′ − m lo cual es menor que m + m′ − m = m′ y contradice la suposición
de que S es una solución.
En resumen, lo que probamos en estos párrafos fue que si hay varias
formas de llegar a un mismo acomodo del tablero, solamente hay
que tomar en cuenta la mas corta.
Si varias de esas subsoluciones usan el mismo número de movimientos,
basta con tomar cualquiera de ellas y no perderemos nuestra oportunidad de
encontrar una solución ya que al llegar al mismo acomodo del tablero, lo que
se puede hacer a partir de ahí es exactamente lo mismo y lleva a los mismos
resultados.
Así que lo que podemos hacer para resolver el problema, sin necesidad
de abandonar aún nuestro modelo del árbol de decisiones, es realizar una
búsqueda en amplitud teniendo en cuenta qué acomodo de tablero genera
cada subsolución; y si dicho acomodo de tablero ya fué visitado antes, en-
tonces ignorar dicho nodo.
Podemos hacer eso ya que en la búsqueda en amplitud la primera vez
que encontremos cada acomodo de tablero tendremos la certeza de que lo
habremos encontrado con la menor cantidad de movimientos(todos los nodos
que se recorran después estarán igual o mas lejos de la raíz).
Finalmente, para implementar esta solución lo que necesitamos es una
cola(para la búsqueda en amplitud), una manera de representar cada nodo,
y una manera de marcar los acomodos o permutaciones ya visitadas.
La información relevante de cada nodo viene dada por dos cosas: la sub-
solución(los movimientos realizados) y la permutación de casillas a la cual se
llegó. Aunque la primera cosa implique la segunda, recordemos que el proble-
ma solamente nos pide el número de movimientos realizados, entonces basta
con que guardemos la permutación de casillas y el número de movimientos
realizados.
Es tentador representar cada permutación por un arreglo de 9 enteros,
sin embargo, para marcar la permutación como visitada resultaría mucho
mas práctico el número de permutación, es decir, si se ordenaran todas las
permutaciones lexicográcamente, ¾cuántas permutaciones serían menores
que una permutación en particular?.

-- 248 of 315 --

19.2. JUEGO DE NÚMEROS 249
Número de Permutación
Averigüar el número de permutación es un problema interesante, el cual
sugiere el uso de diversas estructuras de datos para permutaciones de muchos
elementos, sin embargo como tenemos solamente 9 elementos, difícilmente
una estructura de datos mejoraría el tiempo de ejecución de dicho algoritmo.
¾cuál es el número de permutación de P = (7, 3, 2, 6, 9, 5, 8, 1, 4)? o mejor
dicho ¾cuántas permutaciones hay menores que P ?
Los siguientes dos párrafos describen algo verdaderamente sencillo de pen-
sar pero difícil de redactar de manera precisa, la idea trata de dada una
permutación p, tomar el menor prejo de p que no sea prejo de P y luego
notar que p es menor que P sí y solo sí estos dos prejos son distintos. El
lector deberá leer con cuidado lo siguiente pero sin miedo ya que no es nada
profundo.
Vamos a llamar C(p) al mayor prejo común entre p y P . Por ejemplo
C(7, 1, 2, 3, 4, 5, 6) = (7), C(7, 3, 2, 1, 4, 5, 6) = (7, 3, 2). Y sea C1(p) el prejo
de p cuya longitud excede en 1 a la longitud de C(p)(notamos que no tiene
sentido hablar de C1(P )). Por ejemplo C(7, 3, 2, 1, 4, 5, 6) = (7, 3, 2, 1)
Ahora, consideremos que p es una permutación cualquiera de los números
de 1, ..., 9 tal que p 6 = P . Vamos a llamar m a la longitud de C1(p). Tenemos
que p es menor que P sí y solo sí. C1(p) es menor que el prejo de tamaño
m de P .
Notemos que si una permutación p empieza con 1, 2, 3, 4, 5 ó 6 entonces
la permutación p es menor que P , y además hay 8! permutaciones que inician
con cada uno de estos números.
Si una permutación empieza con (7, 1) o con (7, 2) también esa per-
mutación es menor que P y además hay 7! permutaciones que inician con
cada uno de estos prejos.
Continuando con este razonamiento, la permutación también será menor
si inicia con (7, 3, 1) y hay 6! permutaciones que cumplen esto.
El siguiente número en la permutación es 6, parece que encontraremos 5
prejos de tamaño 4 tales que sus primeros 3 elementos sean 7, 3 y 2 y que
sean prejos de puras permutaciones menores que P . Pero la realidad es otra,
ya que solamente existen 3 prejos: (7, 3, 2, 1), (7, 3, 2, 4) y (7, 3, 2, 5).
Lo que sucede ahora es que los prejos no pueden terminar en 2 ni en
3 ya que repetirían números en la permutación, así que debemos cuidarnos
también de no contar los números que se repiten.
Es decir, si una permutación p es menor que P y m es la longitud de C1(p),
entonces, el último número de C1(p) no puede estar en C(p) ni tampoco ser
mayor o igual que el m−ésimo número de P , es decir, los números aceptables
son aquellos que no estan en C(p) y son menores que el m−ésimo número de

-- 249 of 315 --

250CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA
P .
Para contar aquellos números aceptables para una longitud de prejo
determinada, vamos a denir una función M donde par un entero n entre 1
y 9, M (n) representa la cantidad de números que no aparencen en el prejo
de tamaño n de P y que son menores que el n−ésimo número de P .
Por ejemplo, ya vimos que M (1) = 6, M (2) = 2, M (3) = 1 y M (4) = 3.
Por lo tanto el número de permtuaciones menores que P es:
M (9)0! + M (8)1! + M (7)2! + M (6)3! + M (5)4!
+M (4)5! + M (3)6! + M (2)7! + M (1)8!
Es interesante notar que si bien nos motivamos en el valor de la permutación
de P para obtener esta fórmula, la fórmula no depende realmente de los
valores de la permutación, solamente estamos suponiendo que P es una per-
mutación de los números enteros de 1 a 9.
Si aplicaramos un algoritmo análogo para una permutación de los enteros
de 1 a N , el algoritmo sería O(N 2), puesto que evaluar la función M sería
lineal y habría que evaluarla N veces. Sin embargo, como aquí N siempre
vale 9, esta particularización del algoritmo es O(1).
Para representar una permutación usaremos un arreglo de 9 caractéres,
ya que los caracteres gastan menos memoria que los enteros.
A continuación se muestra una implementación del algoritmo que encuen-
tra el número de permutación en una función llamada menores:
1 int menores ( char perm [ ] ) {
2 int i , M, k , r ;
3 int f a c t o r i a l =1;
4 r =0;
5 for ( i =0; i <=8; i ++){
6 i f ( i !=0)
7 f a c t o r i a l ∗= i ;
8 M=perm[9− i − 1 ] ;
9 for ( k=0;k<9− i ; k++){
10 i f ( perm [ k]<=perm[9− i −1]) {
11 M−−;
12 }
13 }
14 r+=M∗ f a c t o r i a l ;
15 }
16 return r ;
17 }

-- 250 of 315 --

19.2. JUEGO DE NÚMEROS 251
Implementación
Volviendo al problema original, nos disponemos a usar una búsqueda
en amplitud, donde cada elemento de la cola constará de una permutación
representando un acomodo del tablero y el tamaño de la subsolución mas
corta que llega a dicho acomodo, también será necesario un arreglo con 9!
elementos para marcar los tableros que ya se lograron formar.
En la búsqueda en amplitud se visitaran solo aquellos nodos del árbol de
deciciones que formen un acomodo del tablero que no se haya podido formar
anteriormente.
Dado que nunca habrá mas de 9! elementos en la cola, podemos imple-
mentar la cola con un tamaño máximo de 9!, cada elemento de la cola consta
de un arreglo de 9 caracteres y un entero. Por lo tanto la cola se pude imple-
mentar de la siguiente manera:
1 char ColaPerm [ 9 ∗ 8 ∗ 7 ∗ 6 ∗ 5 ∗ 4 ∗ 3 ∗ 2 ∗ 1 ] [ 9 ] ;
2 int ColaMov [ 9 ∗ 8 ∗ 7 ∗ 6 ∗ 5 ∗ 4 ∗ 3 ∗ 2 ∗ 1 ] ;
3 int C o l a I n i c i o =0;
4 int ColaFin =0;
El arreglo para marcar los tableros ya formados puede ser usado también
para guardar cuántos movimientos se necesitaron para formarlo, puede ser
declarado asi:
1 int MinMov [ 9 ∗ 8 ∗ 7 ∗ 6 ∗ 5 ∗ 4 ∗ 3 ∗ 2 ∗ 1 ] ;
MinMov valdrá 0 cuando la permutación no se haya visitado, y valdrá
el número de movimientos más uno cuando la permutación se haya visita-
do. Esto de sumarle 1 se debe a que la permutación inicial se forma con 0
movimientos.
Resulta conveniente marcar el arreglo MinMov dentro de la función para
encolar:
1 void e n c o l a r ( char perm [ ] , int movs ) {
2 int m=menores ( a c t u a l ) ;
3 i f (MinMov [m]==0){
4 memcpy( ColaPerm [ ColaFin ] , perm , 9∗
s i z e o f ( int ) ) ; // Copiar a ColaPerm [
ColaFin ] e l c o n t e n i d o de perm
5 ColaMov [ ColaFin ]=movs ;
6 ColaFin++;
7 MinMov [m]=mov ;
8 }
9 }

-- 251 of 315 --

252CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA
Y para desencolar así:
1 int d e s e n c o l a r ( char perm [ ] ) {
2 memcpy( perm , ColaPerm [ C o l a I n i c i o ] , 9∗ s i z e o f ( int
) ) ;
3 return ColaMov [ C o l a I n i c i o ++];
4 }
La función para desencolar regresa el número de movimientos y copia la
permutación a un arreglo dado.
Notamos también que una rotación en sentido antihorario es equivalente
a 3 rotaciones en sentido horario, por lo tanto solamente es necesario imple-
mentar la rotación en sentido horario:
1 void r o t a ( char perm [ ] , int f i l a , int c o l ) {
2 char ∗a , ∗b , ∗c , ∗d ; // E s t a s v a r i a b l e s
apuntaran a l a s p o s i c i o n e s de l a s 4 c a s i l l a s
que s e van a r o t a r
3 char ta , tb , tc , td ; // E s t a s v a r i a b l e s
guardarán l o s v a l o r e s i n i c i a l e s de l a s 4
c a s i l l a s
4 f i l a −−; c o l −−; //Cambia l a f i l a y columna de
i n d i c e s b a s a d o s en 1 a i n d i c e s b a s a d o s en 0
5 a=&perm [ f i l a ∗3+ c o l ] ;
6 b=&perm [ f i l a ∗3+ c o l + 1 ] ;
7 c=&perm [ ( f i l a +1)∗3+ c o l ] ;
8 d=&perm [ ( f i l a +1)∗3+ c o l + 1 ] ;
9 ta=∗a ; tb=∗b ; t c=∗c ; td=∗d ; // Guarda e l e s t a d o
i n i c i a l en v a r i a b l e s t e m p o r a l e s
10 ∗a=t c ; ∗b=ta ; ∗ c=td ; ∗d=tb ; // Rota en s e n t i d o
h o r a r i o
11 }
Una vez implementadas todas estas funciones la búsqueda en amplitud
es algo muy sencillo:
1 e n c o l a r ( a c t u a l , 1) ;
2 while (MinMov[0]==0) {
3 movs=d e s e n c o l a r ( a c t u a l ) ;
4 for ( i =1; i <=2; i ++){
5 for ( k=1;k<=2;k++){
6 r o t a ( a c t u a l , i , k ) ;
7 e n c o l a r ( a c t u a l , movs+1) ; //
Rotacion h o r a r i a

-- 252 of 315 --

19.3. EMPUJANDO CAJAS 253
8 r o t a ( a c t u a l , i , k ) ;
9 r o t a ( a c t u a l , i , k ) ;
10 e n c o l a r ( a c t u a l , movs+1) ; //
Rotación a n t i h o r a r i a
11 r o t a ( a c t u a l , i , k ) ; // Despues
de 4 r o t a c i o n e s l a
permutación i n i c i a l r e g r e s a
a como e s t a b a a l i n i c i o
12 }
13 }
14 }
El código completo de esta solución(incluyendo la cabecera, la lectura y
la escritura) mide menos de 80 líneas.
19.3. Empujando Cajas
El siguiente problema se usó en el 2005 en la Competencia Iberoamericana
de Informática por Correspondencia.
Seguramente ya conoces un videojuego clásico que trata de que hacer que
un obrero empuje cajas para colocarlas sobre una marcas dibujadas en el
suelo.
Considera un juego de similar en el cual el obrero debe empujar solamente
una caja a traves de un cuarto hacia una ubicación determinada.
El cuarto está representado por una cuadricula de 5 x 5 rodeada de una
pared perimetral, dentro de la cuadricula hay dos tipos de casillas: las casillas
libres y las casillas con pared.
Además de esto, dentro del cuarto se encuentra el obrero y la caja, siempre
en casillas diferentes.
El obrero puede moverse una casilla al norte, sur, este u oeste, siempre y
cuando no ocupe la posición de una pared ni la posición de la caja.
En ciertas ocaciones el obrero puede empujar la caja pero no tiene su-
cientes fuerzas para tirar de ella.
El acto de empujar la caja se puede ejercer cuando el obrero está en una
casilla vecina(horizontal o verticalmente pero NO en diagonal) a la casilla de
la caja que empuja con la restricción de que la caja nunca puede ocupar una
casilla con pared.
Luego de empujar la caja, el obrero pasa a ocupar la casilla que antes
ocupaba la caja y la caja se mueve una casilla en la misma dirección que el
obrero.

-- 253 of 315 --

254CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA
0
00
000 001
01
010 011
...
1
10
100 101
11
110 111
Figura 19.6: Los primeros 4 dígitos del árbol de decisiones de Empujando
Cajas
Problema Resuelto 19.3.1. Escribe un programa que dado el mapa del
cuarto, determine el número mínimo de pasos para que el obrero coloque la
caja en la ubicación dada realizando el mínimo número de pasos. Donde un
paso se dene como la acción de moverse de una casilla a una casilla vecina.
El mapa del cuarto se representa por una cuadrícula de 7 por 7 caracteres
donde:
El caracter X indica pared
El caracter O(no cero) indica la ubicación del obrero
El caracter C la ubicación de la caja.
El caracter D el lugar de destino de la caja.
El caracter .(ASCII 46) casilla libre.
El programa deberá funcionar en menos de un segundo.
Estructura de la Solución
Nuevamente nos debemos de preguntar: ¾qué es lo que nos está pidiendo
el problema?. La respuesta es el número mínimo de pasos.
Procederemos como en la sección anterior, pensando en la solución como
una secuencia nita de pasos, cada paso puede ser representado solamente
por un entero del 0 al 3 indicando la dirección.

-- 254 of 315 --

19.3. EMPUJANDO CAJAS 255
Así que diremos que las soluciones de este problema son aquellas secuen-
cias nitas de pasos(representadas por enteros del 0 al 3) tales que hacen que
el obrero empuje la caja hasta su posición de destino y que tienen longitud
mínima.
En este problema cada subsolución será también una secuencia nita de
pasos pero puede no llevar la caja a su lugar de destino.
Por lo tanto el árbol de decisiones lo podemos ver como un árbol enraizado
en el cual la raíz es una cadena vacía y cada nodo representa una sucesión
nita con los enteros del 0 al 3.
La gura 19.3 muestra los primeros 4 niveles(incluyendo la raíz) de este
árbol de decisiones. Nuevamente podemos darnos cuenta de que el árbol de
decisiones crece bastante rápido, con tan solo 10 niveles hay mas de un millón
de nodos y en 15 niveles hay mas de mil millones de nodos.
Mejorando la Solución
En la sección anterior se resolvió el problema del juego de dígitos, en el
cual salimos del apuro de tener un espacio de búsqueda demasiado grande
dándonos cuenta que había varias manera de llegar a un mismo acomodo del
tablero y una vez que se llega a un acomodo del tablero no importan qué
movimientos se hicieron para llegar ahí sino cuántos movimientos se hicieron.
Trataremos de aplicar un razonamiento parecido aquí. Nuestro acomodo
no es simplemente el lugar donde se encuentra el obrero, ya que el obrero
puede mover la caja, pasar por su posición original y volver a mover la caja
después. Dos subsoluciones pueden ser escencialmente distintas aún cuando
el obrero se encuentre en la misma posición.
Sin embargo, si para dos casillas cualesquiera (a, b) hay varias formas de
colocar la caja en a y que el obrero se mueva después a b, sin importar cual
de todas esas formas usó el obrero para hacer eso. Las maneras de llevar la
caja a su destino no cambian.
Es decir, para cualquier par de casillas (a, b) si dos subsoluciones x y y
tales que |x| < |y|, que llevan al obrero a la casilla b y a la caja a la casilla
a, se tiene que y no es prejo de ninguna solución, puesto que si es posible
llevar la caja a su destino, no la llevaría en el mínimo número de pasos.
Vamos a denir entonces un estado como un par de casillas (a, b) y vamos
a decir que una subsolución pertenece a dicho estado si luego de ejecutar los
pasos de la subsolución, la caja termina en la casilla a y el obrero termina
en la casilla b.
Asi que haremos una búsqueda en amplitud en el árbol de decisiones,
cada que se visite una subsolución, revisaremos si el estado al cual pertenece
no había sido generado antes antes, y si había sido generado no visitaremos

-- 255 of 315 --

256CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA
esa subsolución,de esta manera todos los estados se generarán unicamente en
el nodo mas cercano a la raíz, es decir, para cada estado encontraremos una
de sus subsoluciones mas cortas, y solamente una.
La solución podría ser cualquiera de las subsoluciones (a, D) donde D es
la posición de destino de la caja.
Implementación
Como se había mencionado anteriormente, vamos a hacer una búsqueda
en amplitud en el árbol de decisiones.
El problema solo nos pide la longitud de la subsolución y no la solución
completa, entonces no es necesario guardar en la cola todo sino solamente el
tamaño de la subsolución encontrada y el estado que genera dicha subsolu-
ción.
Como habíamos dicho antes, una subsolución es un par de casillas. Pero
necesitamos representar las casillas de alguna manera. Es posible representar-
las por un par de enteros indicando la la y la columna, pero como sabemos
que el mapa es de 7x7 entonces sería mas sencillo numerar las casillas de 0 a
48 y representar cada casilla por un solo entero.
Digamos que las casillas de la primera la tienen números del 0 al 6, de
la segunda la del 7 al 13, etc. Si en cada la a cada casilla le asignamos los
números en forma creciente de izquierda a derecha tendremos que a una casil-
la ubicada en f -ésima la y la c-ésima columa, le correspondería el número
7(f −1)+(c−1). Esto sugiere que es conveniente tanto en las como columnas
asignarles números de 0 a 6.
Por lo tanto, dado el número de casilla, obtener la la y la columna es
particularmente fácil:
1 int o b t e n F i l a ( int c a s i l l a ) {
2 return c a s i l l a / 7 ;
3 }
4 int obtenColumna ( int c a s i l l a ) {
5 return c a s i l l a %7;
6 }
Y dada la la y la columna, obtener el número de casilla también es fácil:
1 int o b t e n C a s i l l a ( int f i l a , int columna ) {
2 return 7∗ f i l a +columna ;
3 }
Usaremos un arreglo llamado Mejor para guardar la longitud de la sub-
solución mas corta para generar cada estado. La cola, como ya se había

-- 256 of 315 --

19.3. EMPUJANDO CAJAS 257
mencionado, debe de guardar un estado y la longitud de la subsolución, es
decir, tres enteros.
Para representar los movimientos al norte, sur, este y oeste, vamos a usar
un par de vectores de dirección, es decir, dos arreglos Df y Dc tales que para
alguna casilla en la f y columna c, f + Df [i] y c + Dc[i] representen una
casilla vecina a la casilla original, indicando i la dirección con un entero de
0 a 4.
Así que estas son las estructuras que se denirán en el problema:
1 int Mejor [ 4 9 ] [ 4 9 ] ;
2
3 int ColaA [ 4 9 ∗ 4 9 ] ;
4 int ColaB [ 4 9 ∗ 4 9 ] ;
5 int ColaTam [ 4 9 ∗ 4 9 ] ;
6 int C o l a I n i c i o ;
7 int ColaFin ;
8
9 int Df [ ] = { 0 , 1 , 0 , −1};
10 int Dc [ ] = { 1 , 0 , −1, 0 } ;
Para encolar un estado, en lugar de usar como parámetros las dos casillas
y la longitud de la subsolución, resulta mas cómodo pasar la la y la columna
de cada una de las casillas.
1 void e n c o l a r ( int f1 , int c1 , int f2 , int c2 , int l e n ) {
2 int a , b ;
3 a=o b t e n C a s i l l a ( f1 , c1 ) ;
4 b=o b t e n C a s i l l a ( f2 , c2 ) ;
5 i f ( Mejor [ a ] [ b]==0){ // S i e l e s t a d o no h a b í a
s i d o e n c o n t r a d o a n t e s
6 Mejor [ a ] [ b]= l e n ;
7 ColaA [ ColaFin ]=a ;
8 ColaB [ ColaFin ]=b ;
9 ColaTam [ ColaFin ]= l e n +1;
10 ColaFin++;
11 }
12 }
Al nal la búsqueda en amplitud queda de esta manera:
1 void amplitud ( int O, int C) {
2 int f1 , c1 , f2 , c2 , l e n ;
3 int f , c ;
4 int a , i ;

-- 257 of 315 --

258CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA
5 e n c o l a r ( o b t e n F i l a (O) , obtenColumna (O) ,
o b t e n F i l a (C) , obtenColumna (C) , 0) ;
6 while ( C o l a I n i c i o != ColaFin ) {
7 f 1=o b t e n F i l a ( ColaA [ C o l a I n i c i o ] ) ;
8 c1=obtenColumna ( ColaA [ C o l a I n i c i o ] ) ;
9 f 2=o b t e n F i l a ( ColaB [ C o l a I n i c i o ] ) ;
10 c2=obtenColumna ( ColaB [ C o l a I n i c i o ] ) ;
11 l e n=ColaTam [ C o l a I n i c i o ] ;
12 C o l a I n i c i o ++;
13 for ( i =0; i <4; i ++){
14 f=f 1+Df [ i ] ;
15 c=c1+Dc [ i ] ;
16 i f (Mapa [ f ] [ c ] ! = 'X ' ) { // S i e l
o b r e r o s e mueve a una
p o s i c i ó n donde no hay pared
17 i f ( f==f 2 && c==c2 ) { //
S i empuja l a c a j a
18 i f (Mapa [ f 2+Df [ i
] ] [ c2+Dc [ i
] ] ! = 'X ' ) { //
S i l a c a j a
s e mueve a
una p o s i c i ó n
donde no
hay pared
19 e n c o l a r
( f ,
c ,
f 2+
Df [ i
] ,
c2+
Dc [ i
] ,
l e n
+1) ;
20 }
21 } e l s e { // S i s e mueve a
s u e l o l i b r e
22 e n c o l a r ( f , c ,
f2 , c2 , l e n

-- 258 of 315 --

19.4. CAMINO ESCONDIDO 259
+1) ;
23 }
24 }
25 }
26 }
27 }
El programa completo que resuelve este problema posee poco menos de
100 líneas.
19.4. Camino Escondido
Este problema apareció en un examen preselectivo para la IOI del año
2007, el contexto del problema es el siguiente:
Imagina que estas a punto de entrar en la pirámide que antecede a la sala
donde se encuentran los legendarios tesoros de los mayas, y en la puerta esta
escrito un extraño jeroglico el cual se traduce de la siguiente manera:
Aqui no pueden entrar seres que no sean descendientes de nuestra gloriosa
civilizacion, para demostrar que por tus venas corre sangre maya deberás
demostrar tus habilidades para rastrear el camino siguiendo un patron que se
repite hasta llegar a la salida
El mapa de la piramide tiene forma de cuadricula y mide N x N , donde
N ≤ 50, los movimientos pueden ser de manera vertical u horizontal, pero
no estan permitidos movimientos en diagonal.
La entrada a la cámara esta representada por un 1 y se encuentra en
la parte superior, la salida tambien esta representada con un 1 pero se
encuentra en la parte inferior, el patron que debes de seguir debe de coincidir
con los numeros que estan dibujados en el suelo
Por ejemplo considera el siguiente mapa:
2 3 1 8 5
8 5 4 3 2
2 8 3 5 9
8 4 8 8 6
8 2 1 3 5
Si el patron a seguir fuera (3, 5, 8) el número mínimo de pasos para llegar
de la entrada a la salida seria 8 (en la gura el camino está resaltado con
negritas).

-- 259 of 315 --

260CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA
Problema Resuelto 19.4.1. Escribe un programa que dado un mapa de la
pirámide encuentre el número mínimo de pasos para desde la entrada hasta
llegar a la salida.
El programa deberá funcionar en menos de un segundo.
Estructura de la Solución
De igual manera que en los problemas anteriores, la pregunta que todo
lector se debe hacer es: ¾qué estoy buscando?.
Para contestar correctamente la pregunta es necesario haber leído con
atención el problema y comprenderlo correctamente. En este caso especíco,
estamos buscando el camino válido más corto entre la celda A y la celda B.
Ya sabemos lo que estamos búscando. ¾Cuál es el siguiente paso? Por
supuesto, algo que parece obvio y sin embargo poca gente hace; preguntarse
¾Cómo es lo que estoy buscando? Para cuestiones de problemas de informáti-
ca esto se traduce: ¾Cómo se representa lo que estoy buscando?
¾Cómo se representa lo que estoy buscando? Para este problema, un
camino se representa como una secuencia de celdas contiguas, ya sea de
manera horizontal o vertical, de la matriz, que inicia en la celda A y termina
en la celda B.
Una vez especicado el objeto que buscamos, surgen varias otras pregun-
tas interesantes sobre las características del mismo. Estas preguntas se apli-
can a casos particulares y no es sencillo generalizarlas como las dos anteriores,
sin embargo, basta decir que una vez especicado el objeto de la búsqueda
deben intentar conocerse la mayor cantidad de características posible del
mismo.
Un punto importante para el problema que estamos investigando es:
¾Cuál es el largo máximo que puede tener un camino? Inicialmente po-
dríamos pensar que el largo máximo posible es el número de celdas en la
matriz, es decir, N x N .
Pero leyendo el problema con atención podremos observar que nunca se
dijo que el camino no podía pasar 2 veces por la misma celda. Eliminada
esta limitante vemos entonces que el largo máximo de un camino puede ser
mayor que el número total de celdas de la matriz. De hecho, el largo máximo
de un camino puede ser MUUUY grande.
Muy bien, ya sabemos que estamos buscando, también sabemos como es.
Sigamos adelante, aqui viene la pregunta más importante hasta el momento:
¾en donde debemos buscarlo?
¾En donde debemos buscar? Esta es la pregunta clave en cualquier prob-
lema de búsqueda y su correcta respuesta es lo que nos denirá el espacio de
búsqueda. Volvamos a nuestro problema, la primera opción que se ocurre es

-- 260 of 315 --

19.4. CAMINO ESCONDIDO 261
construir todos los caminos posibles (válidos e inválidos) y entre ellos buscar
el que queremos.
Dado que no denimos una cota superior para el largo máximo del camino,
la cantidad de caminos que podemos construir es hasta el momento innita,
y aunque las computadoras son muy rápidas, eso es insuciente para buscar
entre un número innito de caminos.
Equivalencia de Subsoluciones
Una vez denido un primer espacio de búsqueda, el siguiente paso es
recortarlo lo más posible hasta llegar a una cardinalidad manejable. Para
nuestro problema hay dos recortes inmediatos:
En vez de construir todos los caminos, construyamos únicamente los
que sean válidos. Este puede parecer un buen recorte, sin embargo, al
no conocer los datos de entrada de antemano, no podemos estar seguros
de que sirva de algo. Un caso de prueba planeado cuidadosamente puede
hacer que el número de caminos válidos sea tan grande que para nes
prácticos buscar entre ellos sea como buscar en un número innito de
opciones.
Dado que queremos el camino más corto, hay que buscar entre todos
los caminos válidos empezando por los de menor longitud. Este recorte,
a menos que el único camino sea el más largo posible, obviamente nos
ahorra algo. Pero de nuevo, al no saber que tan largo es el camino que
buscamos, no podemos estar seguros de que lo encontraremos en un
tiempo corto.
Hemos avanzado algo, sin embargo, aún no llegamos a un punto en donde
podamos asegurar una correcta solución en tiempo para cualquier instancia
posible del problema.
Es muy importante siempre calcular el tamaño del espacio de búsqueda
y pensar que en el peor de los casos nuestro programa va a tener que buscar
en la totalidad del espacio, piensen en el caso en el que no haya solución,
para estar seguros tenemos que buscar entre todas las opciones, de modo
que requerimos que el tamaño del espacio sea tal que aún examinándolo
completamente nuestro programa termine en el tiempo establecido.
Para nuestro problema, dado que un camino puede ser una solución, una
subsolución sería un prejo del camino. En los dos problemas anteriores
hemos logrado exitosamente encontrar cierta redundancia en las subsolu-
ciones (es decir, hay pares de soluciones tales que no todo sujo válido para
alguna de ellas es sujo válido para la otra).

-- 261 of 315 --

262CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA
A esta redundancia de subsoluciones la llamaremos equivalencia. La idea
es que dos subsoluciones son equivalentes si la forma de llegar desde ellas a
la solución búscada es exactamente la misma.
Para denir la equivalencia de subsoluciones de una manera mas precisa,
vamos a cambiar nuestro concepto de solución. Diremos que una solución es
aquella secuencia de decisiones que lleve al resultado deseado, sin importar
el número de decisiones que se tomen, es decir, solamente descartamos que
una solución es necesariamente el camino mas corto; en este problema vamos
a aceptar como solución cualquier camino.
De esa manera lo que buscamos ahora es una solución tal que su longi-
tud sea la mas corta. Una vez aclarado esto estamos listos para denir la
equivalencia de subsoluciones:
Denición 19.4.1 (Equivalencia de Subsoluciones). Sean a y b dos subsolu-
ciones, se dice que a y b son equivalentes si y solo sí:
Para cualquier solución S tal que S resulta de la concatenación de a
con alguna c(es decir, S = (a1, a2, ..., an, c1, c2, ..., cm) ), se tiene que la
concatenación de b con c también es una solución.
Para cualquier solución S tal que S es la concatenación de b con alguna
c, se tiene que la concatenación de a con c también es una solución.
¾De qué nos sirve tener sub-soluciones equivalentes? En realidad eso de-
pende un poco del problema especíco, sin embargo, en la mayoría de los
casos el benecio viene de que dos sub-soluciones se pueden comparar de
manera directa y en base a eso decidir cual de las dos es óptima dados los
criterios que buscamos.
Notamos que si a y b son dos subsoluciones equivalentes, también b y a
también son equivalentes.
Si a es equivalente con b, y b es equivalente con c, entonces a es equivalente
con c(la demostración surge directamente de la denición anterior).
Además, toda subsolución es equivalente consigo misma.
Estas 3 propiedades fueron las que utilizamos en la conectividad de los
grafos para ver cómo un grafo se podía particionar en componentes conexas.
Nos vemos tentados a denir algo totalmente análogo a las componentes
conexas pero sustituyendo las aristas con las equivalencias. Sin embargo esto
puede complicar el problema, deniremos algo parecido, lo cual llamaremos
estados.

-- 262 of 315 --

19.4. CAMINO ESCONDIDO 263
Estados
La idea de los estados es poder particionar adecuadamente el espacio de
búsqueda. Es decir, cada estado es un conjunto de subsoluciones y ninguna
subsolución está en mas de un estado, todo esto de manera que cada decisión
que se tome, o cada paso que se dé, o como se le quiera llamar al hecho de
descender un nivel en el árbol de decisiones sea equivalente a cambiar de un
estado a otro.
También se requiere que todas las subsoluciones que pertenezcan a un
mismo estado sean equivalentes(obsérvese que puede que subsoluciones aso-
ciadas a estados distintos también sean equivalentes).
Hay que aclarar que existen muchas formas válidas de denir los esta-
dos, pero todas deben de cumplir con esas condiciones que se acaban de
mencionar.
Aterrizando un poco, en el problema de camino escondido, ¾Cuáles serían
dos sub-soluciones equivalentes?
Dijimos anteriormente que una subsolución es cualquier prejo de un
camino solución, como un camino es una sucesión de celdas de la matriz,
entonces una sub-solución se deniría como una sucesión de celdas en la
matriz que va de la celda A a la celda Q.
La solución debe de seguir los números especicados por la secuencia S,
de modo que nuestra subsolución que termina en Q además se encuentra en
una cierta posición de la secuencia S a la que llamaremos p.
Supongamos ahora que conocemos la solución desde (Q, p) hasta B, en-
tonces todas las subsoluciones que terminen en (Q, p) son equivalentes ya que
su camino hacia B es el mismo sin importar la manera en la que llegaron a
(Q, p).
Para nuestro problema, lo mas natural es identicar los estados por el par
ordenado (Q, p). Aunque haya estados para los cuales no hay subsoluciones
asociadas(es decir, estados vacíos), eso no representa ninguna dicultad.
Queremos el camino más corto. Si tenemos dos subsoluciones que llevan
al estado (Q, p), su camino más corto hacia la celda B es el mismo, por lo
tanto, podemos decir que la subsolución cuya longitud sea menor entre las
dos es mejor para nuestros propositos, si ambas son de la misma longitud,
entonces podemos simplemente tomar cualquiera de las dos, ya que, a n de
cuentas, son equivalentes.
Esto nos sugiere hacer una búsqueda amplitud en los estados. Si el lector
regresa a las secciones anteriores y mira los códigos de las búsquedas en
amplitud, se dará cuenta que realmente lo que se hizo fue una búsqueda en
amplitud con los estados.
Habiendo visto lo que son los estados y las subsoluciones equivalentes

-- 263 of 315 --

264CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA
estamos listos para llegar a nuestra denición nal de espacio de búsqueda:
Denición 19.4.2 (Espacio de Búsqueda). Es un par ordenado E = (S, T ),
donde a los elementos de S los llamaremos estados y los elementos de T los
llamaremos cambios o transiciones de estado. Además se deben cumplir las
siguientes propiedades:
Todo estado es un conjunto de subsoluciones(prejos de candidatos a
solución).
Para todo par de estados a y b tales que a 6 = b se tiene que a y b son
disjuntos.
Para todo estado e, si tomamos cualesquiera s1, s2 ∈ e, se tiene que s1
y s2 son equivalentes.
Los elementos de T son pares ordenados de los elementos de S, y
(e1, e2) ∈ T sí y solo sí existen t1 ∈ e1 y t2 ∈ e2 tales que t1 es prejo
de t2 y |t1| = |t2| − 1.
De las tres propiedades de esta denición, solo la cuarta propiedad parece
perderse un poco en detalles sin mostrar una motivación adecuada. Esta
propiedad se puede recordar simplemente como que dos estados estan conec-
tados sí y solo sí es posible moverse de uno a otro en solamente un paso.
También es conveniente notar que los espacios de búsqueda son grafos
dirigidos. Así que el proceso de resolver un problema de optimización combi-
natoria se reduce a identicar un espacio de búsqueda de tamaño razonable,
identicar en ese espacio de búsqueda que es lo que se quiere optimizar(en
este problema sería el número de transiciones) y dadas esas dos condiciones,
elegir cómo recorrer el espacio de búsqueda.
Como lo que queremos minimizar es el número de transiciones de estado,
la búsqueda en amplitud nuevamente nos va a servir.
No tenemos que buscar dos veces en un mismo estado, de modo que
nuestra búsqueda se limita a la cantidad de estados que existan.
Para nuestro caso todas los pares (Q, p) posibles identican los estados.
Dado que Q es una celda de la matriz, existen N x N posibles valores para
Q. Asi mismo, p representa una posición en la secuencia S así que la cantidad
de valores posibles para p es igual al largo de la secuencia S.
Sustituyendo por los valores máximos posibles tenemos que en el peor caso
nuestra búsqueda abarcara un total de (300)(300)(50) = 4500000 estados, lo
cual funcionará fácilmente en un segundo.

-- 264 of 315 --

19.4. CAMINO ESCONDIDO 265
Implementación
Aunque vamos a hacer una búsqueda en un grafo dirigido y anteriormente
se habló de la implementación de grafos con matriz de adyacencia y listas
de adyacencia, esta vez nos conviene representar los vértices como ternas
ordenadas de enteros.
Segun este planteamiento, una terna (p, f, c) representará el estado que
contiene los caminos que terminan en la casilla (f, c) y en la posición p del
patrón.
Para marcar los estados ya visitados y al mismo tiempo guardar el tamaño
del camino mas corto para llegar a cada estado usaremos un arreglo de 3 di-
mensiones llamado Marca, de manera que Marca[p][f][c] indique el camino
mas corto para llegar al estado (p, f, c), o -1 si no se ha encontrado dicho
camino.
Por lo tanto hay que declarar el siguiente arreglo:
1 int Marca [ 5 0 ] [ 5 2 ] [ 5 2 ] ;
El motivo para declarar el arreglo de tamaño 50 x 52 x 52 en lugar de
50 x 50 x 50 es para usar la columna 0, la la 0, la columna N + 1 y la la
N + 1 como una frontera.
Si se utilizan esta noción de la frontera en el arreglo para marcar los
estados, también hay que usarla en el arreglo que guarda el mapa:
1 int Mapa [ 5 0 ] [ 5 2 ] [ 5 2 ] ;
También hay que recalcar que en alguna parte del código hay que ini-
cializar todas las posiciones del arreglo con −1.
Para implementar la búsqueda en amplitud es necesaria una cola, le
asignaremos un tamaño máximo de 503.
1 int C o l a I n i c i o , ColaFin ;
2 int ColaP [ 5 0 ∗ 5 0 ∗ 5 0 ] ;
3 int ColaF [ 5 0 ∗ 5 0 ∗ 5 0 ] ;
4 int ColaC [ 5 0 ∗ 5 0 ∗ 5 0 ] ;
También es necesario implementar una función para meter un estado a la
cola; como nunca se deben de encolar estados ya visitados, suena razonable
que la función de meter a la cola verique que el estado no haya sido visitado
y una vez metido a la cola lo marque como visitado:
1 void e n c o l a r ( int p , int f , int c , int w) {
2 i f ( Marca [ p ] [ f ] [ c]==−1){
3 ColaP [ ColaFin ]=p ;
4 ColaF [ ColaFin ]= f ;

-- 265 of 315 --

266CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA
5 ColaC [ ColaFin ]= c ;
6 Marca [ p ] [ f ] [ c ]=w;
7 ColaFin++;
8 }
9 }
El patrón lo guardaremos en un arreglo llamado Patron:
1 int Patron [ 5 0 ] ;
Como se puede apreciar, se pretende guardar datos a partir de la posición
0 y no a partir de la posición 1. Los índices basados en 0 son adecuados para
este momento ya que si el índice de una posición del patrón fuera p entonces
el índice de la siguiente posición sería (p+1) %P.
Al igual que en el ejemplo anterior, este algoritmo habla de movimientos
entre cuadros vecinos de una cuadrícula, por lo que es conveniente usar los
vectores de dirección aquí también:
1 int Df [ ] = { 0 , −1, 0 , 1 } ;
2 int Dc [ ] = { 1 , 0 , −1, 0 } ;
En este problema en particular, el procedimiento de meter en la cola sim-
plifca las cosas si se implementa en una función aislada, pero el procedimiento
de sacar de la cola puede implementarse dentro de la búsqueda sin que esto
haga el código difícil de manejar.
Como queremos que luego de dar el primer paso el estado esté ubicado en
la primera posición del patrón, entonces antes de dar el primer paso vamos
a considerar que el estado está ubicado en la última posición del patrón.
Así que la búsqueda en amplitud se puede implementar de la siguiente
manera:
1 e n c o l a r (P−1, 1 , i n i c i o C , 0) ;
2 while ( C o l a I n i c i o != ColaFin ) {
3 f=ColaF [ C o l a I n i c i o ] ;
4 c=ColaC [ C o l a I n i c i o ] ;
5 p=ColaP [ C o l a I n i c i o ] ;
6 C o l a I n i c i o ++;
7 for ( i =0; i <4; i ++){
8 k=Mapa [ f+Df [ i ] ] [ c+Dc [ i ] ] ;
9 i f ( k==1 | | Patron [ ( p+1) %P]==k ) {
10 e n c o l a r ( ( p+1) %P , f+Df [ i
] , c+Dc [ i ] , Marca [ p
] [ f ] [ c ]+1) ;
11 }

-- 266 of 315 --

19.4. CAMINO ESCONDIDO 267
12 }
13 }
Las variables P e inicioC indican el tamaño del patrón y el número de
columna inicial respectivamente.
Con esto la solución del problema está prácticamente completa, solo falta
imprimir la salida y leer la entrada; esta parte, debido a que es poco intere-
sante se deja como ejercicio al lector para que verique si comprende bien
esta implementación.

-- 267 of 315 --

268CAPÍTULO 19. ESTRUCTURA DE LA SOLUCIÓN Y ESPACIO DE BÚSQUEDA

-- 268 of 315 --

Cap´ıtulo 20
Programación Dinámica en Los
Espacios de Búsqueda
El nombre Programación Dinámica es un término elegante que no tiene
mucho sentido en nuestro contexto, básicamente consiste en guardar en una
tabla lo mejor que se puede hacer en cada estado, o dicho de otra manera es
aplicar la estrategia Divide y Vencerás con una tabla.
Generalmente la programación dinámica se implementa utilizando for o
while en lugar de recursión.
Al igual que en capítulos anteriores, abordaremos el tema explorando
ejemplos para posteriormente generalizarlos en un método efectivo.
20.1. Cálculo de Fibonacci
En la sección 2.3 abordamos el problema de los conejos de Fibonacci y
se mencionó una solución recursiva de complejidad exponencial, luego en la
sección 3.1 vimos como evitar redudandancia para obtener una solución de
complejidad O(n).
A pesar de que la complejidad no está mal, sucede que la implementación
se puede volver mucho mas simple y un poco mas rápida, la siguiente función
calcula el n + 1-ésimo término de la sucesión de Fibonacci:
1 int F( int n ) {
2 int Fib [ n + 1 ] ;
3 Fib [ 0 ] = 0 ;
4 Fib [ 1 ] = 1 ;
5 for ( i =2; i<=n ; i ++){
6 Fib [ i ]= Fib [ i −1]+Fib [ i − 2 ] ;
269

-- 269 of 315 --

270CAPÍTULO 20. PROGRAMACIÓN DINÁMICA EN LOS ESPACIOS DE BÚSQUEDA
7 }
8 return Fib [ n ] ;
9 }
Quizá para algunos resulte obvio que este código funciona, pero tal vez
para otros no, así que no está por demás mencionar una prueba corta por
inducción de que funciona.
Sabemos que el for itera n − 1 veces. Cuando se ejecuta por primera
vez la línea 6, resulta que F ib[0] y F ib[1] son los primeros 2 términos de la
sucesión de Fibonacci y además i = 2.
Supongamos que está por ejecutarse por k-ésima vez la línea 6 y que
F ib[0], F ib[1], ..., F ib[k] son los primeros k + 1 términos de la sucesión de Fi-
bonacci, entonces i tendrá el valor de k+1 y luego de ejecutarse la línea 6 ten-
dremos que F ib[k+1] = F ib[k]+F ib[k−1] = F (k)+F (k−1) = F (k), posteri-
ormente i tomará el valor de k+2 y tendremos que F ib[0], F ib[1], ..., F ib[k+1]
serán los primeros k + 2 términos de la sucesión de Fibonacci. Por inducción,
luego de iterar n veces F ib[n] será el n + 1-ésimo término de la sucesión de
Fibonacci.
Esta implementación elimina aparentemente la recursión. Sin embargo,
resultaría muy difícil saber qué está haciendo sin conocer la recursión, ya
que para llegar a esta implementación usamos la idea de la implementación
recursiva.

Informalmente hablando la programación dinámica consta de 2 pasos: