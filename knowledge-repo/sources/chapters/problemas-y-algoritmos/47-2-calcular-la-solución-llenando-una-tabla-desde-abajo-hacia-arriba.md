# 2. Calcular la solución llenando una tabla desde abajo hacia arriba.

Algunos autores hablan de un tercer paso llamado reconstruir la solu-
ción, que consiste en encontrar la mejor solución una vez que se tiene calcu-
lada la tabla.
El problema con este tercer paso es que funciona bien cuando se trata de
problemas de optimización combinatoria, pero cuando se trata de problemas
de conteo o de probabilidad no tiene mucho sentido hablar de reconstruir la
solución. ½De hecho con los conejos de Fibonacci algo análogo a reconstruir
la solución sería imprimir la ascendencia de todos los conejos que se tienen
al nal!, lo cual es mucho mas tardado que contarlos.
Y por supuesto, el paso de encontrar la subestructura óptima suele ser
tremendamente mas difícil que el de llenar la tabla, así que este método de
dos pasos no nos ayuda mucho y tenemos que encontrar uno mejor.

-- 270 of 315 --

20.2. EL LADRÓN Y LA MOCHILA 271
20.2. El Ladrón y la Mochila
A continuación abordaremos otro problema que comunmente se toma
como ejemplo de programación dinámica, se le conoce como el problema de
la Mochila o knapsack.
El problema habla de un ladrón que lleva una mochila con una capacidad
C y se encuentra en un lugar con N tipos de objetos, donde cada objeto i
tiene un precio Pi y un volúmen Vi, tanto el precio como el volúmen de cada
objeto son enteros.
Problema Resuelto 20.2.1. Escribir un programa que dados C, N , P y V
determine la suma máxima de precios que puede obtener el ladrón robando
cualquier cantidad de objetos de cada tipo de tal manera que la suma de
todos los volúmenes no exceda C.
El programa debe de funcionar en tiempo O(CN ).
Solución Al toparse por primera vez con este problema, muchos(incluido
el autor) caen en la ingenuidad de pensar que lo único que tienen que hacer es
calcular una razón precio
volumen para cada tipo de objeto y posteriormente tomar
aquellos objetos que puedan caber en la mochila y que su razón sea mayor.
Este algoritmo, a pesar de que suena coherente, es completamente erró-
neo, por ejemplo, se puede tener una mochila de capacidad 6, un tipo de
objeto con volúmen 5 y precio 11, y otro tipo de objeto con volúmen 2 y
precio 4.
Los objetos del primer tipo tienen una razón de 11
5 y los de segundo tipo
de 4
2 , por lo tanto el algoritmo descrito tomaría un objeto del primer tipo
y terminaría obteniendo una suma de precios de 11, mientras que se puede
hacer algo mejor: tomar 3 objetos del segundo tipo obteniendo un precio
total de 12.
Luego de ver este contraejemplo es posible que muchos intenten parchar
el algoritmo para que pueda funcionar con ese caso; pero la recomendación
del autor es la siguiente: no se deben de intentar parchar algoritmos que esten
incorrectos, puede que la idea resulte útil para resolver un problema parecido
o para acotar, pero intentar generar un algoritmo correcto a partir de arreglar
casos particulares es algo que generalmente está destinado al fracaso.
Habiéndonos olvidado de el tentador algoritmo incorrecto, abordaremos
este problema de una manera perecida a los otros.
Podemos observar que si elegimos un objeto de tipo i, nos quedará un
problema equivalente a llenar una mochila con capacidad de C − Vi.
No necesitamos considerar la opción de sacar objetos que ya estan dentro
de la mochila, puesto que introducir un objeto y luego quitarlo nos deja con

-- 271 of 315 --

272CAPÍTULO 20. PROGRAMACIÓN DINÁMICA EN LOS ESPACIOS DE BÚSQUEDA
el mismo resultado que si nunca se hubiera introducido.
Si recordamos el tipo de observaciones útiles que se vieron en el capítulo
anterior, veremos que si tenemos una capacidad restante k, entonces sin im-
portar cómo se hayan llenado los primeros C − k espacios de la mochila, la
solución es la misma. ½Las posibles capacidades restantes son un conjunto de
estados!.
También hay un conjunto de cambios de estado, y es fácil ver cuál es, ya
que la capacidad restante cambia sí y solo sí se mete un nuevo objeto a la
mochila. Así que el conjunto de estados son los objetos que se pueden meter
a una mochila de una capacidad dada.
Una consideración que simplica un poco el problema es tomar en cuenta
la opción de desperdiciar espacio. Esto es práctico ya que puede que la mejor
solución no llene toda la mochila. Así que otro cambio de estado es desperdi-
ciar una unidad de espacio, si se quiere desperdiciar mas de una unidad basta
con desperdiciar varias veces una unidad.
Algo que quizá pasamos por alto pero al nal resultará importante es que
una mochila de capacidad 0 otorga siempre una suma de precios de 0.
Resumiendo y precisando, si llamamos G(k) a la mayor suma de precios
que se puede obtener con una mochila de capacidad k tenemos que:
G(k) = 0 si k = 0 (20.1)
= max({G(k − Vi) + Pi con Vi ≥ k}, G(k − 1)) si k>0 (20.2)
Lo cual nos deja con una función recursiva. Si miramos bien la fórmula,
nos daremos cuenta que G(k) está denido solamente en base a los valores
de la entrada, a G(k − 1) y a G(k − Vi), estas dos expresiones tienen en
común que hacen referencia a G en índices menores que k. Y tiene sentido,
puesto que en cada que se mete un elemento a la mochila disminuye el espacio
restante, y también el espacio disminuye cuando se decide desperdiciar.
Por tanto una forma de calcular los valores de la función G es primero
calcular G(0), luego calcular G(1), después G(2) y así sucesivamente. Esto
se puede hacer ya que para calcular G(k) solamente se necesitan calcular los
valores G(h) con h < k.
Finalmente obtenemos esta sencilla implementación:
1 G[ 0 ] = 0 ;
2 for ( k=1;k<=C; i ++){
3 G[ k]=G[ k − 1 ] ;
4 for ( i =1; i<=N; i ++){
5 i f (V[ i ]>k && G[ k]<G[ k−V[ i ] ] +P [ i ] ) {
6 G[ k]=G[ k−V[ i ] ] +P [ i ] ;

-- 272 of 315 --

20.3. PRIMER TEOREMA DEL CÓMPUTO DE ABAJO HACIA ARRIBA273
7 }
8 }
9 }
Viendo que el código solamente contiene dos búcles anidados y tomando
en cuenta que uno de ellos itera C veces y otro V veces podemos concluir
que su complejidad es O(CN ).

De este ejemplo podemos notar que se repitió el hecho de contar con una
función recursiva con dominio en los enteros de tal manera que el valor de
una función en determinado entero k solo dependía de valores de la función
en enteros menores que k.
Una vez teniendo eso se pudo usar la propiedad de que si se llenaba un
arreglo de izquierda a derecha guardando los valores de la función, se podían
reemplazar las llamadas recursivas por accesos al arreglo.
20.3. Primer Teorema del Cómputo de Abajo
hacia Arriba
Después de haber visto que tanto el problema de Fibonacci y como el
de la mochila tienen la propiedad de que una función denida de manera
recursiva se puede calcular con un ciclo for, sería deseable poder saber de
manera precisa cuándo se puede hacer esto.
Podriamos decir ingénuamente: se aplica en las funciones recursivas tales
que el valor de la función sólo depende de los enteros anteriores. Pero aquí
tropezaríamos con un error de conceptos: en el capítulo 2 se dijo lo que es una
denición recursiva, y el capítulo 7 se denió una función como un conjunto
de pares ordenados, así que no tiene sentido decir que los valores de una
función dependen de otros ni que la función sea recursiva.
Claro que una función implementada en un lenguaje de programación
puede o no ser recursiva, pero una función matemática se comporta mas
como un arreglo que como un proceso. Por ejemplo, podríamos terjiversar las
cosas y decir que la función F de Fibonacci, no se puede calcular llenando
un arreglo desde 0 hasta n ya que F (n) = F (n + 1) − F (n − 1) por lo que
los valores de la función en un entero n dependen del valor en n + 1.
Para evitar este caos teórico, vamos a hablar de fórmulas. Una fórmula
es simplemente una expresión matemática, a diferencia de las funciones, las
fórmulas si dependen de la forma en la que son descritas. Por ejemplo, la

-- 273 of 315 --

274CAPÍTULO 20. PROGRAMACIÓN DINÁMICA EN LOS ESPACIOS DE BÚSQUEDA
función f (x) = x + x el la misma función que g(x) = 2x sin embargo, las
fórmulas x + x y 2x no son las mismas.
Es posible también denir parámetros a las fórmulas de una manera pare-
cida a como se hace con las funciones, por ejemplo se puede hablar de la
fórmula w(x) = x2, y cada que se mencione en el texto a w(x) se deberá de
reemplazar w(x) por x2.
Siendo estrictos no pueden existir fórmulas recursivas, ya que tendríamos
una expresión innitamente grande con la cual no tendría sentido trabajar.
Sin embargo, podemos decir que una función está denida de manera recur-
siva si f (n) está bien denido mediante una fórmula que contenga a f .
Por ejemplo H(x) = x para x ∈ 1, ..., 10 no es una denición recursiva,
sin embargo H(0) = 0 y H(x) = H(x − 1) + 1 para x ∈ 1, ..., 10 si es una
denición recursiva. Por tanto hay funciones que pueden ser denidas de
maneras recursivas y no recursivas.
También es conveniente hablar de una subfórmula, decimos que si f es
una fórmula, w es subfórmula de f , si w es una subcadena de f . Por ejemplo,
para la fórmula a + b + c + d, tenemos que +c es una subfórmula.
Volviendo al tema, para el cual introducimos las fórmulas, queremos gen-
eralizar la propiedad encontrada en el problema de Fibonacci y en el problema
de la mochila.
Si nos jamos bien, los órdenes en los cuales se pueden calcular los valores
de la función en el arreglo dependen de la fórmula que se esté usando para
calcular la función; y lo que tienen en común ambos problemas, es que el
valor de la función en un entero n solamente se calcula usando valores de la
función en enteros mas pequeños.
Así que tenemos que una función F evaluada en k se puede calcular
mediante una fórmula f (k) calculando los valores de F (0), F (1), ..., F (k)
en ese órden sí y solo sí f (k) realmente caracteriza a F (k) y para cada
subfórmula de f (k) de la forma F (w) se tiene que w < k.
Esta forma de calcular las funciones se llamará cálculo ó cómputo de
abajo hacia arriba, el cuál se puede denir de la siguiente manera:
Denición 20.3.1 (Computo de abajo hacia arriba unidimensional). El cál-
culo de abajo hacia arriba con una fórmula f en un arreglo A se reere al
siguiente algoritmo:
for(i=0;i<n;i++){
A[i]=f(i);
}
Sobra decir que el código escrito solamente representa una manera de
muchas de implementar un algoritmo, ya que el algoritmo de cálculo de abajo

-- 274 of 315 --

20.4. TRIÁNGULO DE PASCAL 275
hacia arriba ya se implementó de forma distinta en los dos ejemplos anteri-
ores.
Ahora, lo único que queda por decir en esta sección es cuándo se puede
aplicar el cálculo de abajo hacia arriba unidimensional:
Teorema 36 (Primer Teorema del Cómputo de Abajo Hacia Arriba). Con-
sideremos un conjunto C ⊆ Z, una función F : C → R que se quiere calcular
y una fórmula f que calcula F (es decir F (n) = f (n) para cualquier n ∈ C).
Si para toda subfórmula de f (n) de la forma F (w(n)), se tiene que w(n) <
n entonces F se puede calcular de abajo hacia arriba con la fórmula f .
Puede que muchos lectores sientan que esta sección les hizo perder mucho
tiempo deniendo cosas, sin embargo, además de precisar el cálculo de abajo
hacia arriba en arreglos unidimensionales también nos dimos cuenta de una
importante propiedad: una manera diferente de denir una misma función
puede cambiar muchas cosas.
20.4. Triángulo de Pascal
Ya en la sección 3.3 se denió el triángulo de Pascal como una función P
tal que:
P (i, 0) = 1 para i ∈ N
P (i, i) = 1 para i ∈ N
P (i, k) = P (i − 1, k − 1) + P (i − 1, k) para i, k ∈ N con 0 < k < i
Otra manera de describir este triángulo es como un arreglo triangular de
números de manera que cada el número de arriba es 1 y cada número es la
suma de los dos que tiene arriba(o de uno solo en caso de que solo tenga uno
arriba); es decir:
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
1 6 15 20 15 6 1
..........

-- 275 of 315 --

276CAPÍTULO 20. PROGRAMACIÓN DINÁMICA EN LOS ESPACIOS DE BÚSQUEDA
Cualquier persona que entienda cómo está formado este triángulo, lo po-
dría dibujar a mano sin ningún problema y empezaría dibujando primero la
primer la, luego la segunda la, y así sucesivamente.
Esto nos sugiere que el triángulo de Pascal se puede calcular mediante
programación dinámica. Y ciertamente lo único que tenemos que hacer es
calcular las las superiores antes que las las inferiores.
Es decir, para calcular una la i es necesario haber calculado previamente
la la i − 1. Tomando en cuenta que al calcular una la i solamente se está
haciendo referencia a la la i − 1 entonces ni siquiera importa el órden en el
cual se procesan las columnas.
Por cómodidad procesaremos las columnas en órden creciente:
1 P [ 0 ] [ 0 ] = 1 ;
2 for ( i =1; i<=N; i ++){
3 P [ i ] [ 0 ] = 1 ;
4 for ( k=1;k<i ; k++){
5 P [ i ] [ k]=P [ i − 1 ] [ k]+P [ i − 1 ] [ k − 1 ] ;
6 }
7 P [ i ] [ i ] = 1 ;
8 }
Como resultado obtuvimos nuevamente un código bastante corto.
Este código no debe de ser subestimado, puesto que P (a, b) = (a
b
), ½esto
indica que es un excelente algoritmo para calcular coecientes binomiales! ya
que calcula un total de (N )(N +1)
2 coecientes binomiales en O(N 2), el código es
bastante simple y solamente se desborda cuando el resultado nal no cabe en
el tipo de datos(si se intenta calcular con factoriales las cosas se complicarían
por el hecho de que primero se multiplica y luego se divide).
20.5. La Mochila (0, 1)
Este otro problema es muy parecido al anterior, lo único que cambia es
que en lugar de exista una cantidad ilimitada de cada tipo de objeto, cada
objeto está presente una sola vez. En pocas palabras, hay que decidir, para
cada objeto, si dejarlo fuera o dentro de la mochila(de ahí el nombre (0, 1)).
Siendo mas precisos, y sin hacer referencia al problema anterior, este
problema habla de un ladrón que lleva una mochila con una capacidad C y
se encuentra en un lugar con N objetos diferentes, donde cada objeto i tiene
un precio Pi y un volúmen Vi, tanto el precio como el volúmen de cada objeto
son enteros.
Problema Resuelto 20.5.1. Escribir un programa que dados C, N , P y

-- 276 of 315 --

20.5. LA MOCHILA (0, 1) 277
V determine qué objetos debe robar el ladrón de tal manera que la suma de
todos los volúmenes no exceda C y que maximize la suma de los precios.
El programa debe de funcionar en tiempo O(CN ).
Solución Si tomamos en cuenta el capítulo anterior podemos concluir que
nos encontramos frente a otro problema de optimización combinatoria.
Como el nombre del problema lo indica, a cada objeto le podemos asignar
un número, ya sea 0 o 1, para indicar si ese objeto entra o no entra a la
mochila.
Además, no importa el órden en el cual se meten los objetos a la mochila,
así que podemos modelar este problema como una secuencia de decisiones:
primero decidir si tomar o no tomar el primer objeto, luego decidir si tomar
o no tomar el segundo objeto, etc.
Como cada decisión la representamos como un 0 o un 1 entonces nuestro
conjunto de posibles soluciones son todas las cadenas binarias de longitud N
y en nuestro árbol de decisiones cada nodo representa un prejo de la cadena.
El siguiente paso es identicar cuáles subárboles de nuestro árbol de deci-
ciones son idénticos. En estos momentos podríamos pensar en varias posibil-
idades: aquellos subárboles de la misma altura, aquellos que representen un
prejo con la misma cantidad de 1s, aquellos en los cuales se hayan elegido
objetos con el mismo precio, etc.
Hay que hacer notar que todos estos ejemplos mencionados son incorrec-
tos, sin embargo, no es malo examinar cada una de esas posibilidades y darse
cuenta por qué son incorrectas. Después de todo antes de llegar a una idea
correcta es natural pasar por muchas incorrectas.
Sin entrar en detalle de por qué esas reducciones son incorrectas, sim-
plemente nos concentraremos en una reducción que si funciona: Si subsolu-
ciones representadas por prejos de la misma longitud toman objetos tales
que sumen el mismo volúmen entonces sus subárboles correspondientes son
idénticos.
La prueba de esto es bastante directa: El volumen que le queda disponible
a la mochila es el mismo en ambos casos y los objetos que aún se pueden
tomar son los mismos, por tanto cualquier posible conjunto de objetos que
se pueda meter a la mochila en una conguración también es posible meterlo
en la otra.
Por lo tanto los estados quedan determinados por un par ordenado de
enteros (a, b) representando la mayor suma de costos posibles utilizando un
subconjunto de los primeros a objetos y ocupando un volumen b.
Tenemos por tanto que si a > 0 hay a lo más 2 formas posibles de llegar al
estado (a, b): desde el estado (a − 1, b), si se le asigna 0 al a-ésimo elemento;

-- 277 of 315 --

278CAPÍTULO 20. PROGRAMACIÓN DINÁMICA EN LOS ESPACIOS DE BÚSQUEDA
ó desde el estado (a − 1, b − Va), si se le asigna 1 al a-ésimo elemento.
Cuando a = 0 se tiene que o bien b = 0 o el estado es inalcanzable, ¾el
motivo?, si b > 0 equivaldría a decir que la suma de los volúmenes de 0
objetos es mayor que 0.
Por lo tanto llegamos a esta fórmula:
F (a, b) = max(F (a − 1, b − Va) + Pa, F (a − 1, b)) si a > 0 y b ≥ Va
= F (a − 1, b) si a > 0 y b < Va
F (0, 0) = 0
F (0, b) = −∞ si b > 0
Donde F (a, b) representa la mejor solución utilizando un subconjunto de
los primeros a objetos y usando un volumen total de b. El hecho de que
F (0, b) = −∞ cuando b > 0 indica que ese estado no tiene ningún valor
aceptable puesto que es un estado inalcanzable, es decir, indica que cualquier
otra opción es preferible que pasar por este estado.
Claro que para objeto de implementación basta con elegir un número
negativo muy pequeño para que haga las veces de −∞.
Si recordamos cómo se implementó el cálculo del Triángulo de Pascal en
la sección anterior, podemos ver que estamos en una situación análoga.
Una vez calculados los valores de F (a, 0), F (a, 1), ..., F (a, C) se tiene to-
da la información necesaria para calcular los valores de F (a + 1, 0), F (a +
1, 1), ..., F (a + 1, C).
Por tanto si calculamos cada valor de F (a, b) en un arreglo de la forma
F [a][b], basta con ir calculando las las en órden creciente, aquí nos encon-
tramos con una observación interesante: no importa en qué orden se calculen
las columnas, lo único importante es calcular las las en el órden correc-
to(creciente).
El código mas natural para la solución es el siguiente:
1 F [ 0 ] [ 0 ] = 1 ;
2 for ( i =1; i<=C; i ++){
3 F [ 0 ] [ i ]=−INF ;
4 }
5 for ( i =1; i<=N; i ++){
6 for ( k=0;k<=C; k++){
7 i f (V[ i ]<=k ) {
8 F [ i ] [ k]=max(F [ i − 1 ] [ k ] , F [ i − 1 ] [ k−V[ i ] ] ) ;
9 } e l s e {
10 F [ i ] [ k]=F [ i − 1 ] [ k ] ;

-- 278 of 315 --

20.5. LA MOCHILA (0, 1) 279
11 }
12 }
13 }
Claro que bien podríamos hacer algo como esto:
1 F [ 0 ] [ 0 ] = 1 ;
2 for ( i =1; i<=C; i ++){
3 F [ 0 ] [ i ]=−INF ;
4 }
5 for ( i =1; i<=N; i ++){
6 for ( k=C; k>=0;k−−){
7 i f (V[ i ]<=k ) {
8 F [ i ] [ k]=max(F [ i − 1 ] [ k ] , F [ i − 1 ] [ k−V[ i ] ] ) ;
9 } e l s e {
10 F [ i ] [ k]=F [ i − 1 ] [ k ] ;
11 }
12 }
13 }
O peor aún:
1 F [ 0 ] [ 0 ] = 1 ;
2 for ( i =1; i<=C; i ++){
3 F [ 0 ] [ i ]=−INF ;
4 }
5 for ( i =1; i<=N; i ++){
6 k=C/ i ;
7 do{
8 i f (V[ i ]<=k ) {
9 F [ i ] [ k]=max(F [ i − 1 ] [ k ] , F [ i − 1 ] [ k−V[ i ] ] ) ;
10 } e l s e {
11 F [ i ] [ k]=F [ i − 1 ] [ k ] ;
12 }
13 k=(k+1) %C;
14 } while ( k!=C/ i ) ;
15 }
Pero el primero de estos códigos es mas natural y mas claro que los últimos
dos.


-- 279 of 315 --

280CAPÍTULO 20. PROGRAMACIÓN DINÁMICA EN LOS ESPACIOS DE BÚSQUEDA
20.6. Segundo Teorema del Cómputo de Abajo
Hacia Arriba
El Primer Teorema del Cómputo de Abajo Hacia Arriba menciona cómo
calcular iterativamente un arreglo con los valores de una recurrencia de un
sólo parámetro.
En las dos secciones anteriores se analizaron problemas que se resolvían
llenando una tabla bidimensional inspirandonos en una recurrencia de dos
parámetros.
El lector podría intentar adivinar que a continuación formularemos un teo-
rema que nos diga qué hacer cuando se tienen recurrencias de dos parámetros,
sin embargo eso no es una buena idea.
No podemos formular un teorema para cada cantidad distinta de variables
en la recurrencia, necesitamos hacer algo mas general que nos permita atacar
problemas con cualquier cantidad de variables.
Una manera de hacerlo es transformar un problema de n variables en un
problema de n − 1 variables, esto nos permitiría aplicar el teorema varias
veces para nalmente resolver un problema de una sola variable.
Denición 20.6.1 (Computo de abajo hacia arriba multidimensional). Supong-
amos que tenemos una fórmula f que recibe un entero y devuelve un arreglo
de tamaño n − 1.
Además tenemos un arreglo de n dimensiones llamado A.
El cálculo de abajo hacia arriba de la fórmula f con el arreglo A se dene
de la siguiente manera:
for(i=1;i<=n;i++){
A[i]=f(i);
}
Recordamos que si A es un arreglo de n dimensiones A[i] es un arreglo
de n − 1 dimensiones.
Esta denición es algo extraña, puesto que en los problemas de progra-
mación dinámica rara vez se utiliza un código así.
Nuevamente hay que recalcar que ese código es sólo una forma de describir
un algoritmo, no es un código que vaya a aparecer en un programa.
Cuando se calculó el triángulo de Pascal con programación dinámica,
podemos decir que la fórmula f (i) era el siguiente código:
P[i][0]=1;
for(k=1;k<i;k++){

-- 280 of 315 --

20.6. SEGUNDO TEOREMA DEL CÓMPUTO DE ABAJO HACIA ARRIBA281
P[i][k]=P[i-1][k]+P[i-1][k-1];
}
P[i][i]=1;
Y que P [i] representa A[i], de esta manera, en cada iteración se está
calculando una la del arreglo P , y el código quedaría de esta manera:
for(i=1;i<=n;i++){
P[i][0]=1;
for(k=1;k<i;k++){
P[i][k]=P[i-1][k]+P[i-1][k-1];
}
P[i][i]=1;
}
De hecho, siendo realistas, al terminar este capítulo no volveremos a usar
esta notación de fórmulas y de los teoremas del calculo de abajo hacia arriba.
¾Qué es lo que tienen de especial que hace que valga la pena verlos?, la
repuesta es que siempre se usan estos teoremas, pero la gente preere nunca
mencionarlos en la explicación de una solución para no alargar las cosas y
preere utilizarlos para uso propio sin decir explícitamente que los utilizó;
al no tener que contarselos a otras personas no necesita denir una notación
como lo hacemos aquí.
Volviendo al tema, ocupamos saber cuándo podemos calcular una función
F de varios parámetros de abajo hacia arriba.
Si tenemos una fórmula f tal que dado el primer parámetro calcula todos
los valores de la función con los n − 1 parámetros restantes, entonces suena
razonable usar f (i) dentro de un bucle.
Sin embargo, ocupamos que f (i) nunca haga referencia a F (g(i), ...) donde
g(i) > i, es decir, que una vez calculado F (i, ...) pueda calcular F (i + 1, ...).
Todo esto se menciona con precisión en el siguiente teorema:
Teorema 37 (Segundo Teorema del Cómputo de Abajo hacia Arriba). Con-
sideremos un conjunto C ⊂ Z, una función F : Cn → R que se quiere calcular
y una fórmula f (i) que calcula F (i, a1, ..., an−1) en una tabla A de tal manera
que A[i][a1]...[an−1] = F (i, a1, ..., an−1) luego de aplicar f (i).
Si para toda subfórmula de f de la forma F (g(i), ...) se tiene que g(i) ≤ i
entonces F se puede calcular de abajo hacia arriba utilizando f .
Con este teorema terminamos de decir con precisión como funciona el
cálculo de abajo hacia arriba. Pero no tiene mucho sentido aprenderse este
teorema sino que hay que verlo como algo bastante natural.
Para lograr este objetivo las siguientes secciones mencionarán ejemplos
que harán ver que utilizar este teorema es mas fácil que enunciarlo.

-- 281 of 315 --

282CAPÍTULO 20. PROGRAMACIÓN DINÁMICA EN LOS ESPACIOS DE BÚSQUEDA
20.7. Robot Recolector
Supongamos que tenemos un robot en la posición (1, 1, 1) de una rejilla
tridimensional de N por N por N . En cada celda (a, b, c) de la cuadrícula
hay W (a, b, c) monedas.
Si un robot pasa por una celda, automáticamente toma todas las monedas
que hay ahí.
El robot sólo se puede mover hacia arriba, hacia la derecha y hacia atrás,
es decir, si el robot se encuentra en una celda (a, b, c) sólamente se puede
mover hacia las celdas (a + 1, b, c), (a, b + 1, c) y (a, b, c + 1).
Luego de varios pasos, el robot debe de llegar a la posición (N, N, N ).
Problema Resuelto 20.7.1. Escribe un programa que dados N y W , en-
cuentre la mayor cantidad de monedas que el robot puede tomar.
Solución Si seguimos los pasos del capítulo anterior, podemos plantear
primeramente el problema como encontrar una cadena con los caracteres 0,
1, y 2 indicando cada una de las 3 direcciones posibles y luego llegaríamos a
la conclusión de que cada estado es una posición en la rejilla.
Como para llegar a una posición (a, b, c) se debe de ingresar directamente
desde (a − 1, b, c), (a, b − 1, c) ó (a, b, c − 1) entonces si F (a, b, c) es la mayor
cantidad de monedas que se pueden reunir al llegar a la posición (a, b, c)
tenemos que:
F (a, b, c) = max(F (a − 1, b, c), F (a, b − 1, c), F (a, b, c − 1)) (20.3)
+W (a, b, c) si (a, b, c) 6 = (1, 1, 1) y a, b, c ≥ 1 (20.4)
= W (a, b, c) si (a, b, c) = (1, 1, 1) (20.5)
= −∞ si a = 0 o b = 0 o c = 0 (20.6)
Ahora lo que sigue es preguntarnos: ¾se puede calcular de abajo hacia
arriba? y posteriormente ¾cómo se puede lograr eso?
Consideremos un arreglo tridimensional A, nuestra intención es lograr que
luego de ejecutar el algoritmo suceda que A[a][b][c] = F (a, b, c), imaginemos
que en algún momento durante la ejecución ya se tiene calculado A[a][b][c]
para toda a ≤ i, b ≤ k y c < h entonces fácilmente podríamos calcular
A[i][k][h] de la siguiente manera:
1 i f ( i==1 && k==1 && h==1){
2 A[ i ] [ k ] [ h]=W[ i ] [ k ] [ h ] ;
3 } e l s e i f ( i==0 | | k==0 | | h==0){
4 A[ i ] [ k ] [ h]=−INF ;

-- 282 of 315 --

20.7. ROBOT RECOLECTOR 283
5 } e l s e {
6 A[ i ] [ k ] [ h]=max(A[ i ] [ k ] [ h −1] , A[ i ] [ k − 1 ] [ h ] , A[ i − 1 ] [ k
] [ h ] )+W[ i ] [ k ] [ h ] ;
7 }
Ahora, en el único lugar donde se menciona algo de la forma A[i][k][g(h)]
en el código anterior se menciona de la siguiente manera A[i][k][h−1] entonces
A[i][k] se puede calcular de abajo hacia arriba así:
1 for ( h=0;h<=N; h++){
2 i f ( i==1 && k==1 && h==1){
3 A[ i ] [ k ] [ h]=W[ i ] [ k ] [ h ] ;
4 } e l s e i f ( i==0 | | k==0 | | h==0){
5 A[ i ] [ k ] [ h]=−INF ;
6 } e l s e {
7 A[ i ] [ k ] [ h]=max(A[ i ] [ k ] [ h −1] , A[ i ] [ k − 1 ] [ h ] , A[ i
− 1 ] [ k ] [ h ] )+W[ i ] [ k ] [ h ] ;
8 }
9 }
Como este código calcula A[i][k] y la única parte donde menciona algo
de la forma A[i][g(k)] es de la siguiente manera A[i][k][h − 1] ó A[i][k − 1][h]
entonces A[i] se puede calcular de abajo hacia arriba así:
1 for ( k=0;k<=N; k++){
2 for ( h=0;h<=N; h++){
3 i f ( i==1 && k==1 && h==1){
4 A[ i ] [ k ] [ h]=W[ i ] [ k ] [ h ] ;
5 } e l s e i f ( i==0 | | k==0 | | h==0){
6 A[ i ] [ k ] [ h]=−INF ;
7 } e l s e {
8 A[ i ] [ k ] [ h]=max(A[ i ] [ k ] [ h −1] , A[ i ] [ k − 1 ] [ h ] ,
A[ i − 1 ] [ k ] [ h ] )+W[ i ] [ k ] [ h ] ;
9 }
10 }
11 }
Nuevamente expresiones de la forma A[g(i)] sólo se mencionan en el código
como A[i] y A[i − 1] entonces A se puede calcular de abajo hacia arriba de
esta forma:
1 for ( i =0; i<=N; i ++){
2 for ( k=0;k<=N; k++){
3 for ( h=0;h<=N; h++){

-- 283 of 315 --

284CAPÍTULO 20. PROGRAMACIÓN DINÁMICA EN LOS ESPACIOS DE BÚSQUEDA
4 i f ( i==1 && k==1 && h==1){
5 A[ i ] [ k ] [ h]=W[ i ] [ k ] [ h ] ;
6 } e l s e i f ( i==0 | | k==0 | | h==0){
7 A[ i ] [ k ] [ h]=−INF ;
8 } e l s e {
9 A[ i ] [ k ] [ h]=max(A[ i ] [ k ] [ h −1] , A[ i ] [ k − 1 ] [
h ] , A[ i − 1 ] [ k ] [ h ] )+W[ i ] [ k ] [ h ] ;
10 }
11 }
12 }
13 }
Finalmente, luego de ejecutar ese algoritmo la respuesta será simplemente
A[N ][N ][N ].

Algo interesante con este problema es que no importa en qué órden se
acomoden los for, el código sigue funcionando; por ejemplo, si iteramos sobre
k en el bucle exterior y sobre i en el bucle intermedio, el algoritmo sigue
funcionando.
Se deja al lector reexionar sobre este hecho y en qué otros casos esto
sucede.
20.8. Subsecuencia Común Máxima
Se dice que una cadena A es subsecuencia de una cadena B si se puede
obtener A borrando 0 o más caracteres de B.
Por ejemplo omi es subsecuencia de olimpiada.
Hay que hacer notar que una cadena vacía también se considera una
subsecuencia.
Una cadena c es subsecuencia común de a y b si c es subsecuencia de a y
también es subsecuencia de b.
Problema Resuelto 20.8.1. Escribe un programa que dadas dos cadenas
A y B encuentre la longitud de la subsecuencia común mas grande de A y
B.
El programa debe funcionar en O(|A||B|).

-- 284 of 315 --

20.8. SUBSECUENCIA COMÚN MÁXIMA 285
Solución Este ejemplo es mas complicado de modelar de la manera tradi-
cional como secuencia de decisiones, sin embargo también es posible hacerlo.
Supongamos que tenemos una subsecuencia común c, vamos a llamar c1
a lo que resulta de borrarle el último caractér a c. Tenemos que c1 también
es una subsecuencia común de A y de B.
Vamos a llamar P (s, m) al prejo de tamaño m de una cadena s.
Otra propiedad importante es que si n es el menor entero tal que c1 es
subsecuencia común de P (A, n) y m es el menor entero tal que c1 es subse-
cuencia común de P (B, m) entonces c es subsecuencia común de P (A, n1) y
de P (A, m1) con n1 > n y m1 > m.
Por tanto podemos pensar en los estados como pares de enteros indicando
la longitud de cada prejo de los cuales la cadena es subsecuencia común.
Asi que el problema se puede replantear de esta manera:
Creamos una cuadrícula W de tamaño |A| por |B|, y marcamos las casillas
(i, j) cuando A[i] = B[j]. Hay que encontrar la sucesión mas grande de
casillas marcadas que sea creciente en ambas coordenadas.
Este problema es similar al de la sección anterior, es decir, hay un robot
en una cuadrícula que sólo se puede mover hacia abajo o hacia la derecha,
cada casilla tiene un 0 o un 1 y debe de pasar por el mayor número de 1s.
Sin embargo, cada que el robot pasa por un 1, el robot debe de moverse
en diagonal hacia abajo y hacia la derecha al mismo tiempo. Resumiendo:
LCS(i, j) = LCS(i − 1, j − 1) + 1 si M [i][j] = 1 (20.7)
LCS(i, j) = max(LCS(i − 1, j), LCS(i, j − 1)) (20.8)
si M [i][j] = 0 y min(i, j) > 0 (20.9)
LCS(i, 0) = 0 (20.10)
LCS(0, i) = 0 (20.11)
Si recordamos de dónde viene M podemos sustituirlo en la fórmula para
evitar tener que calcularlo:
LCS(i, j) = LCS(i − 1, j − 1) + 1 si A[i] = B[j] (20.12)
= max(LCS(i − 1, j), LCS(i, j − 1)) (20.13)
si A[i] 6 = B[j] y min(i, j) > 0 (20.14)
LCS(i, 0) = 0 (20.15)
LCS(0, i) = 0 (20.16)
Ahora lo que hay que notar es que en la fórmula anterior, sólamente

-- 285 of 315 --

286CAPÍTULO 20. PROGRAMACIÓN DINÁMICA EN LOS ESPACIOS DE BÚSQUEDA
aparece una vez una expresión de la forma LCS(i, g(j)), y aparece como
LCS(i, j − 1), por tanto cada la i se puede calcular de abajo hacia arriba.
Una posible implementación para calcular una la i es la siguiente:
1 for ( j =0; j<=lenB ; j ++){
2 i f ( i==0 | | j ==0){
3 LCS [ i ] [ j ] = 0 ;
4 } e l s e i f (A[ i ]==B [ j ] ) {
5 LCS [ i ] [ j ]=LCS [ i − 1 ] [ j −1]+1;
6 } e l s e {
7 LCS [ i ] [ j ]=max(LCS [ i − 1 ] [ j ] , LCS [ i ] [ j −1]) ;
8 }
9 }
Mirando el código anterior como si fuera una fórmula, las formas en las
que aparece LCS[g(i)]... son las siguientes: LCS[i − 1] y LCS[i], por tanto
se puede calcular de abajo hacia arriba toda la tabla de la siguiente manera:
1 for ( i =0; i<=lenA ; i ++){
2 for ( j =0; j<=lenB ; j ++){
3 i f ( i==0 | | j ==0){
4 LCS [ i ] [ j ] = 0 ;
5 } e l s e i f (A[ i ]==B [ j ] ) {
6 LCS [ i ] [ j ]=LCS [ i − 1 ] [ j −1]+1;
7 } e l s e {
8 LCS [ i ] [ j ]=max(LCS [ i − 1 ] [ j ] , LCS [ i ] [ j −1]) ;
9 }
10 }
11 }
Luego, longitud de la subsecuencia común mas grande será LCS[lenA][lenB].
El lector observador se habrá dado cuenta que las cadenas A y B se están
tomando como si los caractéres empezaran en A[1] y B[1] en lugar de A[0] y
B[0]. Esto no es lo mas común, pero se escribió así con propósitos de claridad.


-- 286 of 315 --

Cap´ıtulo 21
Programación Dinámica en Cortes
En el capítulo anterior vimos cómo utilizar la programación dinámica para
resolver problemas que se podían plantear como un camino mas corto(o mas
largo) en un grafo dirigido y usamos tablas para poder calcular de manera
eciente el mejor camino hacia cada vértice.
Es decir, cada vértice(al cual llamamos estado) estaba representado por
una celda en la tabla, y la operación de moverse de un vértice a otro podía
ser vista como recorrer una arista en el grafo.
Muchos problemas de programación dinámica se pueden plantear de esta
manera, sin embargo no es una receta que funcione siempre que un problema
se pueda resolver con programación dinámica.
Existen otra clase de formas de aplicar la programación dinámica, si el
lector recuerda el principio divide y vencerás en su forma recursiva, se basa
en dividir un problema en copias mas pequeñas de sí mismo, resolver las
copias mas pequeñas y nalmente combinar sus soluciones para obtener la
solución al problema original.
Un ejemplo de un algoritmo que usa de manera directa este principio es el
algoritmo de ordenamiento llamado mezcla(o mergesort para muchos); dicho
algoritmo ya se mencionó en este libro así que se asumirá que el lector ya lo
conoce.
El algoritmo de mezcla parte el problema original en dos subproblemas,
soluciona los dos subproblemas por separado y posteriormente los une para
obtener la solución al problema original. Este algoritmo tiene la característica
de que puede fácilmente dividirse en dos subproblemas sin perder generalidad.
Sin embargo, existen problemas que se pueden dividir de varias maneras en
copias mas pequeñas de sí mismo y cada forma de dividirlo produce una
solución distinta.
En esos casos no queda otra opción mas que dividir el problema de todas
287

-- 287 of 315 --

288 CAPÍTULO 21. PROGRAMACIÓN DINÁMICA EN CORTES
las formas posibles, lo cual nos podría llevar a generar una cantidad expo-
nencial de subproblemas, pero afortunadamente en muchas ocaciones aunque
haya muchas formas de didividr un problema en copias mas pequeñas de sí
mismo, ½muchos subproblemas se repiten!. Aquí la programación dinámica
ayuda para calcular en una tabla las soluciones a los subproblemas ya resuel-
tos.
A este tipo de formas de aplicar la programación dinámica le llamare-
mos informalmente cortes. El primer ejemplo de cortes que veremos será el
problema de cortar cadenas.
21.1. Cortando Cadenas
Supongamos que tenemos una cadena de caractéres S que tiene longitud
n. Vamos a llamar s1, s2, ..., sn a los caractéres correspondientes a cada una
de las posiciones de la cadena, es decir, si es el i-ésimo caractér.
LLamaremos subcadena [a, b] a la cadena compuesta por los caractéres
sa, sa+1, ..., sb en ese órden, obviamente para que tenga sentido hablar de una
subcadena [a, b] es necesario que a, b ∈ {1, 2, ..., n} y que a ≤ b.
Consideremos que hay una librería que contiene una función llamada
cortaCadena que recibe una cadena de caractéres c, un entero m y devuelve
dos cadenas de caractéres, la primera corresponde a los primeros m carac-
téres de c y la segunda corresponde al resto de los caractéres. Dicha función
usa exactamente m operaciones.
Vamos a imaginar que en algún lenguaje de programación no se tiene acce-
so directo a los caractéres de las cadenas pero se posee la función cortaCadena,
siendo este el caso si se quiere partir una cadena en mas de dos partes hay
varias formas de hacerlo.
Por ejemplo, si la cadena Olimpiada se quiere partir en 4 partes Olim,
pi y a y da esto se podría hacer de varias formas, y puede que el costo
computacional(número de operaciones), sea diferente, por ejemplo, estas dos
formas tienen un costo distinto:
Se manda a llamar cortaCadena(Olimpiada, 4) y se obtienen Olim
y piada; luego se manda a llamar a cortaCadena(piada, 2) y se
obtienen pi y ada. Después se manda a llamar cortaCadena(ada,
1) y se obtienen a y da. El costo computacional de hacer esto es de la
logitud de Olimpiada más la longitud de piada, es decir 9+5+3 = 17.
Se manda a llamar cortaCadena(Olimpiada, 7) y se obtenen Olimpia
y da; luego se manda a llamar a cortaCadena(Olimpia, 4) y se
obtienen Olim y pia. Finalmente se manda a llamar cortaCadena(pia,

-- 288 of 315 --

21.1. CORTANDO CADENAS 289
2) obteniendo pi y a. El costo computacional total es de 9 + 6 + 3 =
18.
Llegando a este punto la pregunta obligatoria es: ¾Cuál es el menor costo
para cortar la cadena S en una secuencia de subcadenas dadas?
Problema Resuelto 21.1.1. Escribir un prgrama que dadas S y a1, a2, ..., ak
con 1 ≤ a1 ≤ a2 ≤ ... ≤ ak < n determine ¾cuál es el menor costo com-
putacional (menor número de operaciones) para cortar S en las subcadenas
[1, a1], [a1 + 1, a2], ..., [ak−1 + 1, ak]?.
Solución Si procediéramos como en el capítulo anterior y tratáramos de
reducir el problema a una sucesión de decisiones no llegaríamos muy lejos,
puesto que la única sucesión de decisiones que es posible imaginarse es, dadas
las cadenas que se han cortado hasta ese momento, ¾cuál es el siguiente corte?.
Esta forma de modelar el programa es muy ineciente, puesto que el conjunto
de posibles cortes que pueden ya haberse realizado es de O(2m) donde m es
el número de cadenas que deben de quedar al nal.
Hay otra forma de abordar este problema, y es usando el principio recur-
sivo de Divide y Vencerás abordado en el capítulo 4.
Si de alguna manera sabemos que el primer corte de la cadena se debe
realizar en la posición p entonces lo que hay que hacer es resolver el problema
de manera óptima para [1, p] y para [p + 1, n], y la solución será n más la
suma de las soluciones a cada subproblema.
Sin embargo esto no es suciente para resolver el problema, ya que su-
pusimos que ya sabíamos en que posición se debe de hacer el primer corte y
eso no tiene por qué ser cierto.
Hay algo que se debe hacer cuando se tienen varias opciones posibles y
no se sabe cuál es la correcta: inspeccionar cada una de ellas y luego elegir
la mejor. La pregunta natural es ¾este algoritmo se vuelve exponencial? y la
respuesta es bastante graticante: no.
Vamos a llamar M (i, f, c) al menor costo de cortar la subcadena [a, b] en
la subcadenas [i, c1], ..., [c|c| + 1, f ]. Tenemos que si c = entonces M (i, f, c) =
0(en ese caso no hay nada que cortar). La respuesta que estamos buscando
es M (1, m, a).
El siguiente paso es encontrar una expresión para M (i, f, c), la cual debe
de decir incluir la posibilidad de cortar en todos las posiciones indicadas en
c, encontrar el óptimo de cada una y tomar el mínimo. Es decir, si c 6 =:

-- 289 of 315 --

290 CAPÍTULO 21. PROGRAMACIÓN DINÁMICA EN CORTES
M (i, f, c) = min(M (i, c1, ) + M (c1 + 1, f, {c2, ..., c|c|}),
M (i, c2, {c1}) + M (c2 + 1, f, {c3, ..., c|c|}),
...
M (i, c|c|, {c1, c2, ..., c|c|−1}) + M (c|c| + 1, f, ))
+ f − i + 1
En efecto, la mejor solución que existe cortando primero en ci es M (i, ci, {c1, c2, ..., ci−1})+
M (ci + 1, f, {ci+1, ..., c|c|}) + f − i, así que la expresión anterior incluye todas
las posibilidades.
Si se implementa en una función recursiva tendriamos un tiempo de eje-
cución de órden exponencial, pero tal vez podamos usar el truco llamado
memorización que se describe en el capítulo 3 para mejorar el algoritmo.
Lo primero que hay que observar para darse cuenta que ese truco es real-
mente efectivo es que sólamente nos interesa calcular el valor de la función de
la forma M (ai, af , {ai+1, ..., af −1}), M (1, af , {a1, ..., af −1}), M (ai, n, {ai+1, ..., ak})
o M (1, n, {ai, ..., ak}).
Conviene pensar que a1 = 1 y ak = n de esa manera podemos de-
cir que sólo nos interesan calcular los valores de la función en la forma
M (ai, af , {ai+1, ..., af −1}).
Con esto sabemos que el número de subproblemas que vamos a resolver
está acotado por el número de parejas (ai, af ), es decir, por (n)(n−1)
2 . Así que
podemos pensar en una implementación como una función llamada Mejor,
donde Mejor(i, f) regresa M (ai, af , {ai+1, ..., af −1}).
Para marcar los subproblemas ya calculados podemos usar un arreglo
de dos dimensiones llamado Calculado y para guardar las soluciones a los
subproblemas un arreglo de dos dimensiones llamado M.
Una posible implementación es la siguiente:
1 int Mejor ( int i n i c i o , int f i n ) {
2 int i , aux ;
3 i f ( C a l c u l a d o [ i n i c i o ] [ f i n ] ) {
4 return M[ i n i c i o ] [ f i n ] ;
5 }
6 C a l c u l a d o [ i n i c i o ] [ f i n ]= true ;
7 i f ( f i n −i n i c i o <=1){
8 M[ i n i c i o ] [ f i n ] = 0 ;
9 return M[ i n i c i o ] [ f i n ] ;
10 }
11 M[ i n i c i o ] [ f i n ]=INFINITO ;

-- 290 of 315 --

21.1. CORTANDO CADENAS 291
12 for ( i=i n i c i o +1; i <f i n ; i ++){
13 aux=M[ i n i c i o ] [ i ]+M[ i + 1 ] [ f i n ]+a [ f i n ]−a [ i n i c i o
] + 1 ;
14 i f (M[ i n i c i o ] [ f i n ]>aux )
15 M[ i n i c i o ] [ f i n ]=aux ;
16 }
17 return M[ i n i c i o ] [ f i n ] ;
18 }
En el capítulo anterior vimos que algunas funciones denidas de manera
recursiva se pueden calcular iterativamente en una tabla, si queremos aplicar
eso en este problema debemos de notar que para calcular M [i][f ] se necesita
tener calculado previamente M [i][1], M [i][2], ..., M [i][f − 1].
Cualquier órden que que respete esa restricción es un buen candidato para
calcular la tabla iterativamente.
El órden mas natural es primero calcular aquellas posiciones M [i][f ]
donde f − i sea menor, es decir:
1 for ( l e n =1; le n<=k ; l e n++){
2 for ( i n i c i o =1; i n i c i o+le n −1<=k ; i n i c i o ++){
3 f i n=i n i c i o+len −1;
4 i f ( f i n −i n i c i o <=1){
5 M[ i n i c i o ] [ f i n ] = 0 ;
6 } e l s e {
7 for (m=i n i c i o +1;m<f i n ;m++){
8 aux=M[ i n i c i o ] [m]+M[m+ 1 ] [ f i n ]+a [ f i n ]−a [
i n i c i o ] + 1 ;
9 i f (M[ i n i c i o ] [ f i n ]>aux )
10 M[ i n i c i o ] [ f i n ]=aux ;
11 }
12 }
13 }
14 }
Observemos que el código anterior tiene la ventaja de que no necesita un
arreglo para guardar cuáles posiciones fueron ya calculadas, es mas corto que
usa memorización y a la larga es mas fácil de implementar.

Como nota cultural, este problema es muy parecido a un problema clásico
llamado Multiplicación Óptima de Matrices, se incluyó este problema en
su lugar para evitar introducir una operación llamada Multiplicación de
Matrices, la cual se aleja de los temas centrales de este libro.

-- 291 of 315 --

292 CAPÍTULO 21. PROGRAMACIÓN DINÁMICA EN CORTES
21.2. Cortando en Cuadrados
Supongamos que tenemos una barra de chocolate cuadrículada de F por
C cuadros, y queremos cortarla usando sólamente cortes horizontales y verti-
cales en posiciones enteras de manera que al nal todas las piezas que queden
sean cuadradas y además queden la menor cantidad de piezas.
Problema Resuelto 21.2.1. Escribe un programa que dados F y C en-
cuentre la manera de cortar una barra de chocolate de F por C de manera
que se obtengan sólamente piezas cuadradas y además que se obtengan la
menor cantidad de piezas.
Solución Si F = C entonces la menor cantidad de piezas es 1, en otro caso
hay F − 2 cortes horizontales psoibles y C − 2 cortes verticales posibles.
Suponiendo que sabemos por algún motivo que el primer corte es hori-
zontal y se hace en la posición p, entonces lo único que tendríamos que hacer
es minimizar el número de cuadrados en las dos piezas que quedan, es decir,
resolver el problema para una barra de p por C y resolver el problema para
una barra de F − p por C.
Análogamente si sabemos que el primer corte es vertical en la posición p,
hay que resolver el problema para una barra de F por p y para una barra de
F por C − p.
Por tanto, si llamamos M (a, b) a la solución para una barra de a por b
entonces:
M (a, b) = 1 si a = b (21.1)
= min(M (1, b) + M (a − 1, b), ..., M (a − 1, b) + M (1, b)(21.2)
, M (a, 1) + M (a, b − 1), ..., M (a, b − 1) + M (a, 1)) (21.3)
si a 6 = b (21.4)
Usando los teoremas del cálculo de abajo hacia arriba se deduce que la
fórmula anterior puede ser calculada de abajo hacia arriba de la siguiente
manera:
1 for ( i =1; i<=F ; i ++){
2 for ( k=1;k<=C; k++){
3 i f ( i==k ) {
4 M[ i ] [ k ] = 1 ;
5 } e l s e {
6 M[ i ] [ k]=INFINITO ;
7 for (m=1;m<i ;m++){ // C o r t e s h o r i z o n t a l e s

-- 292 of 315 --

21.3. POLÍGONO 293
8 M[ i ] [ k]=min (M[ i ] [ k ] , M[m] [ k]+M[ i −m] [ k ] )
;
9 }
10 for (m=1;m<i ;m++){ // C o r t e s v e r t i c a l e s
11 M[ i ] [ k]=min (M[ i ] [ k ] , M[ i ] [m]+M[ i ] [ k−m] )
;
12 }
13 }
14 }
15 }
Para propósitos del tema de programación dinámica en cortes ya encon-
tramos la solución al problema, sin embargo esta solución está llena de cosas
que se pueden mejorar, se invita al lector a buscar cómo mejorarla.

21.3. Polígono
Sección pendiente, consúltese http://olympiads.win.tue.nl/ioi/ioi98/contest/day2/polygon/polygo
para acceder a la descripción del problema y http://olympiads.win.tue.nl/ioi/ioi98/contest/day2/polyg
para acceder a una descripción de la solución.

-- 293 of 315 --

294 CAPÍTULO 21. PROGRAMACIÓN DINÁMICA EN CORTES

-- 294 of 315 --