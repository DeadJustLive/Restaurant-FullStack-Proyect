# 4. Si quedan 3 vértices o más, regresa al paso 1

Por ejemplo, el código de Prüfer asociado al árbol de la siguiente gura
es 9 7 7 7 9 6 6
4 7
2
6
9
5
1
8
3
Problema
Dado un código de Prüfer encuentra el árbol que genera ese código.
Entrada
Línea 1: Un entero n
Línea 2: n − 2 enteros separados por espacios representando el código de
Prüfer.

-- 222 of 315 --

16.9. PROBLEMAS 223
Ejemplo de Entrada
9
9 7 7 7 9 6 6
Salida
La salida deberá constar de N líneas, donde para cada 1 ≤ i ≤ n, la
i−ésima línea deberá indicar los números de los vértices unidos al vértice i
en orden ascendente y separados por espacios.
Si hay múltiples soluciones simplemente imprime una sola línea con la
palabra AMBIGUO.
Si no hay solución imprime una sola línea con la palabra IMPOSIBLE
Ejemplo de Salida
9
7
7
7
9
7 9
2 3 4 6
7 8 9
Límites
2 ≤ n ≤ 100000
Referencias
Este es un problema clásico ingeniado por el mismo Prüfer para demostrar
que el número de árboles con exactamente n nodos es nn−2.
El problema fue redactado por Luis Enrique Vargas Azcona en Junio de
2009 para entrenar a la preselección nacional en la Olimpiada Mexicana de
Informática.

-- 223 of 315 --

224 CAPÍTULO 16. GRAFOS
16.10. Sugerencias
Una Ciudad Unida
Considera hayar las componentes conexas en lugar de hacer una búsqueda
independiente con cada vértice.
Abba
Piensa en un grafo G = (V, A) donde V consta de los 26 caracteres del
alfabeto inglés y {v, w} ∈ A sí y solo sí en algún momento hay que cambiar
alguna letra v ó alguna letra w(nótese que al decir letra v y letra w esta
sugerencia se reere a cualquier letra en V , no a los caracteres v y w).
¾Qué sucede con ese grafo si se reemplazan todas las coincidencias de una
letra por otra?
Códigos de Prüfer
¾Qué sucede con las hojas de un árbol en su código de Prüfer correspon-
diente?. ¾Realmente es posible que la salida sea AMBIGÜO o IMPOSIBLE?

-- 224 of 315 --

Parte V
Algoritmos de Ordenamiento II
225

-- 225 of 315 --



-- 226 of 315 --

227
La parte de ordenamiento fue necesaria dividirla debido a que existen
algoritmos de ordenamiento que hacen uso de estructuras de datos.
En efecto, en general los árboles están diseñados parar organizar elemen-
tos con una función de comparación, así que no suena descabellado que se
puedan usar para ordenar.
Pero los árboles no sólo servirán para organizar los datos que se quier-
an ordenar, también jugarán un papel importante cuando descubramos que
no existe ningún algoritmo de ordenamiento basado en comparaciones cuya
complejidad sea menor que O(N log N).

-- 227 of 315 --

228

-- 228 of 315 --

Cap´ıtulo 17
Árboles y Ordenamiento
Cuando revisamos el algoritmo de selección optamos por elegir la estrate-
gia de encontrar el menor y colocarlo al principio. Sin embargo la forma de
encontrar el menor era O(N ), en este corto capítulo volveremos a aplicar esa
estrategia pero los árboles nos servirán para realizarla mas rápido.
17.1. Ordenamiento por Árboles Binarios de Búsque-
da
Los árboles binarios de búsqueda serán la primera estructura de datos
que usaremos para ordenar.
Nos basaremos en la implementación que se mencionó en la sección 14.1:
1 Tipo c l a v e [ maximo de nodos ] ;
2 int i z q [ maximo de nodos ] ;
3 int der [ maximo de nodos ] ;
4 int nodos =0;
Ya vimos en la sección 14.4 cómo insertar nodos en el árbol, pero aún no
hemos visto cómo usarlo para ordenar.
Recurriremos a uno de los tres recorridos, el llamado recorrido en órden.
El siguiente teorema revelará por qué el libro no deja de pregonar que los
árboles binarios de búsqueda son útiles para el ordenamiento.
Teorema 33. Un recorrido en órden en un árbol binario de búsqueda procesa
los nodos en órden no descendente con respecto a sus claves.
Demostración. Utilizando inducción, en un árbol binario de búsqueda con
un solo nodo, solamente se visita un nodo, por lo cual el órden en que los
nodos se visitan es no descendente.
229

-- 229 of 315 --

230 CAPÍTULO 17. ÁRBOLES Y ORDENAMIENTO
Supongamos que para alguna k todos los árboles binarios de búsqueda
con k′ < k nodos. Imaginemos un árbol binario de búsqueda que tiene exac-
tamente k nodos.
Tanto su rama izquierda como su rama derecha son árboles binarios de
búsqueda, y además, tienen menos de k nodos.
Al recorrer su rama izquierda, todos sus nodos se visitarán en orden no
descendente, al visitar la raíz, por la denición de árbol binario de búsqueda,
su clave será mayor o igual que todas las claves de los nodos ya visitados.
Finalmente, al recorrer la rama derecha, todos los nodos tendrán claves
mayores o iguales que los nodos que ya se habían visitado, además, como la
rama derecha es un árbol binario de búsqueda con menos de k nodos, también
se visitarán dichos nodos en órden.
Asi que la forma de ordenar con un árbol binario de búsqueda es simple-
mente insertar todos los elementos y luego hacer un recorrido en órden.
El recorrido en órden toma tiempo lineal, sin embargo la inserción puede
tomar tiempo cuadrático. Como aquí se supone que sabemos de antemano
cual es la secuencia de nodos que se va a ordenar, lo que se puede hacer
es insertarlos en un órden aleatorio y por el teorema 20 sabemos que en
promedio este algoritmo funcionará como si fuera O(N log N), al menos con
N ≤ 50000000.
A pesar de que mezcla es teóricamente mas rápido(y probablemente en la
práctica también lo sea), los árboles binarios de búsqueda tienen la ventaja de
que es posible obtener ordenamientos de los primeros k elementos insertados
en tiempo lineal, y con mezcla sería necesario reordenar cada vez que se
quiera saber el órden de los elementos que ya se insertaron.
Dicho de otra manera, los árboles binarios de búsqueda sirven para apli-
caciones interactivas.
A pesar de que se mencionó que en este libro no iba a enseñar el algorit-
mo QuickSort, este ordenamiento con árboles binarios de búsqueda es casi
QuickSort(pero este último pierde la ventaja de la interactividad ).
17.2. Ordenamiento por Montículo
Hasta el momento el único algoritmo que se ha mostrado que realmente
funciona en O(N log N ) es el de mezcla, ya que el uso de árboles binarios de
búsqueda es casi O(N log N ) pero estrictamente hablando es O(N 2); además,
ambos algoritmos requieren guardar en memoria una copia del arreglo inicial.
El algoritmo de ordenamiento por montículo(muchas veces llamado heap-
sort) funciona en O(N log N ) y además no necesita guardar otra copia del
arreglo para ordenarlo.

-- 230 of 315 --

17.2. ORDENAMIENTO POR MONTÍCULO 231
La idea del ordenamiento por montículo es similar a la de ordenamiento
por selección. En cada iteración del ordenamiento por selección se encuentra
el menor elemento y se coloca al principio; en el ordenamiento por montículo
se encuentra el mayor elemento y se coloca al nal.
Un montículo se puede usar para insertar datos en O(log N ), y quitar el
mayor también en O(log N ), así que lo único que hay que hacer es insertar
todos los elementos en un montículo y posteriormente quitar el mayor hasta
que el montículo quede vacío.
Aunque la idea base sea sencilla, aplicarla de manera que no se desperdicie
memoria complica las cosas. La estrategia para lograr esto será una idea
extrañamente parecida a inserción:
Inicialmente el primer elemento del arreglo puede representar un mon-
tículo, así que inicialmente el arreglo representa un montículo de tamaño 1 y
n − 1 datos independientes del montículo. Luego tomamos el valor de la se-
gunda posición y lo insertamos en el montículo, de esa manera los primeros 2
elementos del arreglo representarán un montículo, después tomamos el tercer
elemento y lo insertamos y así sucesivamente.
Los montículos y su representación en memoria están diseñados de tal
manera que si hay n nodos nunca se requieran mas de n posiciones de memo-
ria consecutivas; así que será posible convertir el arreglo en un montículo sin
necesidad de crear otro arreglo y sin perder información.
Posteriormente se inicia la etapa de selección, en la i − sima iteración
se quita el elemento mayor del montículo y se coloca en la n − i + 1−ésima
posición del arreglo(la cual corresponde a la posición n − i en C y C++),
nótese que para el momento en que se termina de quitar el mayor, el montículo
sólo ocupa las primeras n − i posiciones del arreglo.
A continuación se muestra una implementación del ordenamiento por
montículo:
1 void heapSort ( int A r r e g l o [ ] , int n ) {
2 int i , k , h ;
3 N=0;
4 for ( i =0; i <n ; i ++){
5 i n s e r t a r ( A r r e g l o , A r r e g l o [ i ] ) ;
6 }
7 for ( i =0; i <n ; i ++){
8 k=q u i t a r ( A r r e g l o ) ;
9 A r r e g l o [ n−1−i ]=k ;
10 }
11 }

-- 231 of 315 --

232 CAPÍTULO 17. ÁRBOLES Y ORDENAMIENTO
Como se puede ver el código es bastante corto pero usa un par de fun-
ciones no mas cortas, las cuales son insertar y quitar, las implementa-
ciobnes de dichas funciones se pueden encontrar en las secciones 15.3 y 15.4
respectivamente.
Nuevamente se hace incapié en que estas implementaciones son un mero
ejemplo y puede haber muchas maneras de implementar los mismos algorit-
mos, de hecho se está usando el tipo de datos int y la función de comparación
<, pero cualquier órden total es válido.

-- 232 of 315 --

Cap´ıtulo 18
¾Mas rápido que O(N log N)?
Ya se dijo varias veces en este libro que los algoritmos de ordenamiento
mas rápidos son de O(N log N ); pero no hemos dado la prueba de ello
y además es posible romper esta restriccion si nos restringimos a ordenar
números enteros en lugar de ordenar cualquier conjunto con un órden total.
El siguiente algoritmo es importante conocerlo, las últimas dos secciones
de este capítulo resultan interesantes para aquellos que gustan de conocer
algoritmos pero no presentan utilidad alguna en los concursos de progra-
mación y tampoco tienen muchas aplicaciones así que esas dos secciones son
opcionales.
18.1. Count-Sort
Consideremos que tenemos una sucesión nita de N enteros entre 0 y M ,
la cual denotaremos por S = (s1, s2, ..., sN ).
Existe una manera relativamente sencilla de ordenar estos enteros que
hemos pasado por alto hasta ahora: se trata de crear un arreglo Cont de
tamaño M , tal que Cont[k] indique cuántas veces aparece k en la secuencia
S.
La forma de crear este arreglo es mucho mas sencilla que los algoritmos
de mezcla y los de ordenamiento usando árboles. Lo único que hay que hacer
es inicializar el arreglo Cont en 0, recorrer S e incrementar el contador.
Una vez creado el arreglo Cont con las características deseadas, obtener
el arreglo S ordenado se vuelve trivial:
1 void c o u n t S o r t ( int S [ ] , int N, int M) {
2 int i , k ;
3 for ( i =0; i<=M; i ++){
233

-- 233 of 315 --

234 CAPÍTULO 18. ¾MAS RÁPIDO QUE O(N LOG N)?
4 Cont [ i ] = 0 ;
5 }
6 for ( i =0; i <N; i ++){
7 Cont [ S [ i ]]++;
8 }
9 for ( i =0,k=0; i<=M; i ++){
10 while ( Cont [ i ] >0) {
11 S [ k]=Cont [ i ] ;
12 Cont [ i ]−−;
13 k++;
14 }
15 }
16 }
Este algoritmo puede aparentar ser el sueño mas maravilloso imaginado
entre los algoritmos de ordenamiento: muy sencillo de implementar y funciona
en tiempo lineal.
Pero las cosas no son tan maravillosas como parecen: en primer lugar su
complejidad no es de órden O(N ) sino de órden O(N + M ), lo cual signica
que si M es grande(por ejemplo M = 231 − 1) este algoritmo puede resultar
ser mucho mas lento que todos los demás que hemos visto(½incluso mas lento
que burbuja! ) y en segundo lugar sólamente sirve para ordenar números
enteros no negativos, lo cual es muy diferente a poder órdenar cualquier
conjunto con un órden total.
Este algoritmo puede ser adaptado para ordenar también números nega-
tivos sumando una constante a todo el arreglo y al nal restándolo, también
se pueden ordenar números racionales, pero para eso es necesario multiplicar
todos los datos por una constante ½e incluso multiplicar M por esa constante!.
Como conclusión, este algoritmo sólo es útil en casos muy especícos.
18.2. *Bucket-Sort
Ya vimos que el Count-Sort tiene la terrible desventaja de que el tamaño
de M importa demasiado en el rendimiento, esto se puede corregir de una
manera muy sencilla:
Hacemos count-sort con cada dígito, es decir, si c es el número de dígitos
del mayor número de la secuencia entonces creamos 10 secuencias, agregamos
a la primera todos aquellos números cuyo c-ésimo dígito(de derecha a izquier-
da) sea 0, a la segunda todos aquellos números cuyo c-ésimo dígito sea 1, y
así sucesivamente.

-- 234 of 315 --

18.2. *BUCKET-SORT 235
Una vez separada la secuencia en 10 secuencias, es posible proceder re-
cursivamente y al nal simplemente concatenar las secuencias ordenadas.
Como se puede apreciar, este algoritmo también está pensado para or-
denar únicamente números enteros no negativos, pero puede ser extendido
para ordenar otras cosas.
Por ejemplo, se pueden ordenar números con expansión decimal nita
siguiendo el mismo principio, también se pueden representar enteros simu-
lando el digno con un dígito extra; otra cosa que se puede hacer es representar
vectores ordenando primero los dígitos de una componente y luego los de la
otra.
En resúmen: este algoritmo puede ordenar todo aquello cuyo órden total
sea representado a través de números enteros no negativos. Cualquier con-
junto nito con un órden total puede ser representado así, pero no siempre
resulta práctico(es posible que para saber cómo representar los elementos sea
necesario primero ordenarlos).
Otra cosa que hay que hacer notar, es que el algoritmo se ilustró con base
10 pero funciona con cualquier base, debido a que los procesadores trabajan
mejor con potencias bits, es preferible usar una base que sea una potencia de
2.
La complejidad de este algoritmo es O(N log M ), asi que como se puede
apreciar, de manera parecida a count-sort, este algoritmo sólo resulta mas
rápido que los tradicionales cuando M es lo sucientemente pequeño.
Un detalle interesante es que si la base de numeración usada es igual a
M entonces obtendremos el count-sort.
Debido a que este algoritmo puede presentar tantas implementaciones
distintas según sea el caso, aquí sólo se mostrará una que ordena enteros
y funciona usando base 2, por lo que sólo divide la secuencia original en 2
secuencias. Se asume que se tiene una función llamada BIT(a, b) la cual
devuelve el b−ésimo bit de a.
1 void ordena ( int S [ ] , int i n i c i o , int f i n , int b i t s ) {
2 int i , k , m;
3 i f ( i n i c i o >f i n )
4 return ;
5 for ( i=i n i c i o ; BIT ( S [ i ] , b i t s )==0 && i<=f i n ; i ++){
}
6 for ( k=i +1;k<=f i n ; i ++){
7 for ( ; BIT ( S [ k ] , b i t s ) !=0 && k<=f i n ; k++)
{ }
8 i f ( k<=f i n )
9 i n t e r c a m b i a ( S [ k ] , S [ i ] ) ;

-- 235 of 315 --

236 CAPÍTULO 18. ¾MAS RÁPIDO QUE O(N LOG N)?
10 }
11 i=min ( i , f i n ) ;
12 while ( BIT ( S [ i ] , b i t s ) !=0 && i>=i n i c i o )
13 i −−;
14 i f ( b i t s >0){
15 ordena ( S , i n i c i o , i , b i t s −1) ;
16 ordena ( S , i +1, f i n , b i t s −1) ;
17 }
18 }
18.3. *La Inexistencia de Mejores Algoritmos
A pesar de que esta sección está marcada con (*) se advierte nuevamente
que el lector puede optar por saltarse esta sección y se asegura que no se
volverá a utilizar en el libro.
De hecho a lo largo del libro las únicas matemáticas que se dan por cono-
cidas han sido matemáticas muy elementales, pero este capítulo es diferente,
pues usaremos una ideantidad llamada la fórmula de Stirling.
La demostración de esta identidad requiere de conocimientos de cálculo
y lo cual se aleja de los propósitos de este libro. Si lector quiere conocer
la demostración de la fórmula puede consultarla el apéndice de bibliografía
recomendada.
Teorema 34 (Fórmula de Stirling). Se cumple la siguiente igüaldad.
log(n!) = n log(n) − n + f (n) (18.1)
Donde n es un entero positivo y f es de órden O(log(n))
Para obtener una cota inferior respecto a la complejidad de un algoritmo
de ordenamiento, recordemos qué es lo que tenemos permitido hacer.
Cuando decimos algoritmo de ordenamiento normalmente nos resferi-
mos a un ordenamiento sobre un elementos que tienen un órden total; es decir
lo único que podemos hacer es comparar pares de elementos, ya que en un
órden total sólo estamos seguros que los elementos saben cómo compararse.
También tenemos n elementos, por simplicidad asumiremos que dichos
elementos son todos distintos.
Ordenar dichos elementos consiste en encontrar una permutación de ellos
que cumpla con ciertas características, dicha permutación es única; y con
cada comparación que se realiza, nos vamos haciendo la idea de cuál puede
ser la permutación correcta.

-- 236 of 315 --

18.3. *LA INEXISTENCIA DE MEJORES ALGORITMOS 237
De una manera mas precisa, inicialmente hay n! permutaciones que po-
drían ser la correcta y podemos hacer (n)(n−1)
2 posibles comparaciones; cada
vez que realicemos una comparación obtendremos un 0 o un 1, y la intención
es que la cantidad de permutaciones que podrían ser la correcta disminuya.
Vamos a imaginar un árbol binario, en el cual a cada hoja corresponde
a una permutación única y a cada nodo v corresponde a un conjunto de
permutaciones posibles C(v) de tal manera que si los hijos de v son a y b
entonces C(v) = C(a) ∪ C(b) y además a ∩ b = ∅.
Este árbol representa un algoritmo, cada nodo representa un estado posi-
ble del algoritmo, de tal manera que la raiz r representa el estado inicial y
C(r) es el conjunto de todas las permutaciones de los n elementos.
Como el algoritmo está bien denido entonces no hay duda que la primera
comparación es siempre la misma, esa comparación puede regresar 0 o 1, el
hijo izquierdo representa el estado del algoritmo si la primera comparación
regresa 0 y el hijo derecho representa el estado del algoritmo si la primera
comparación regresa 1.
De tal manera que si a y b son los hijos izquierdo y derecho de la raiz
entonces C(a) y C(b) representan los conjuntos de posibles permutaciones
válidas si la primera comparación regresa 0 y si regresa 1 respectivamente.
De manera análoga todas las comparaciones realizadas(y los valores de-
vueltos) por el algoritmo en un estado quedan determinadas por el camino
a la raíz del nodo que representa dicho estado; los hijos izquierdo y derecho
representarán lo que sucede si la siguiente comparación regresa 0 y si regresa
1 respectivamente.
Una vez convencidos de que cada árbol puede representar de manera única
todas las posibles comparaciones que realiza un algoritmo de ordenamiento
con una entrada de tamaño n, procederemos a medir la complejidad en cuanto
a número de comparaciones.
Descender un nivel en el árbol equivale a realizar una comparación, de
esta manera al alcanzar una hoja, el número de comparaciones realizadas
será su distancia a la raíz. Como se explico antes, somos pesimistas, así que
vamos a medir la complejidad del algoritmo con respecto a la hoja mas lejana
a la raíz, es decir, respecto a la altura del árbol.
El número de hojas del árbol binario es n!(una hoja por cada permutación),
y bien sabemos que un árbol binario con n! hojas tiene altura de al menos
log2(n!), por lo tanto por la fórmula de Stirling la altura del árbol es de órden
O(nlogn).
De este resultado obtenemos el siguiente teorema:
Teorema 35. Cualquier algoritmo de ordenamiento(sobre un órden total)
tiene complejidad de al menos O(n log n).

-- 237 of 315 --

238 CAPÍTULO 18. ¾MAS RÁPIDO QUE O(N LOG N)?

-- 238 of 315 --