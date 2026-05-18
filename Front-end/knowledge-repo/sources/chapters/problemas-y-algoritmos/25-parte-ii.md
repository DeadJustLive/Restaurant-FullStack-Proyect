# Parte II

Análisis de Complejidad
75

-- 75 of 315 --



-- 76 of 315 --

77
Durante la parte I se vieron muchas formas de aplicar la recursión en
la resolución de problemas y algunas consecuencias matemáticas útiles de la
recursión.
Sin embargo, los problemas mas interesantes en el diseño de algoritmos
surgen al tomar en cuenta el análisis de complejidad, a estas alturas resulta
muy difícil seguir avanzando sin contar con esta herramienta, y a diferencia
de la recursión, el análisis de complejidad si requiere conocimientos previos
para entenderse adecuadamente.
Durante un par de capítulos se hablará muy poco de programación, luego
la programación volverá, pero tendremos que esperar para regresar al diseño
de algoritmos ya que nos concentraremos en el análisis de algoritmos.
Quizá está curva de aprendizaje pudiera parecer desmotivante puesto que
el objetivo es dominar el diseño de algoritmos, pero no hay que olvidar que los
fundamentos no sólo sirven para entender el análisis de complejidad, también
pueden servir en el momento de resolver problemas.
Otra cosa que hay que tomar en cuenta, es que después de esta prolongada
ausencia del diseño de algoritmos, el diseño de algoritmos regresará con una
innidad de nuevos problemas planteados y será posible avanzar mucho mas
rápido.

-- 77 of 315 --

78

-- 78 of 315 --

Cap´ıtulo 6
Técnicas Básicas de Conteo
Como el nombre del capítulo lo indica, el tema a tratar son técnicas de
conteo, las cuales son estudiadas por la combinatoria enumerativa; dichas
técnicas, además de servir para resolver problemas que involucran el conteo,
sirven ampliamente para determinar cuantas veces se ejecutan algunos pasos
en los algoritmos.
A continuación veremos algunos ejemplos donde se aplican las reglas bási-
cas de conteo para posteriormente identicarlas de manera objetiva.
Problema Resuelto 6.0.2. Hay 2 caminos que conducen de la ciudad A
a la ciudad B, 3 caminos que conducen de la ciudad A a la ciudad C. Un
camino que conduce de la ciudad B a la ciudad D y un camino que conduce
de la ciudad C a la ciudad D ¾De cuántas formas se puede ir de la ciudad A
a la ciudad D? (vease la gura para tenerlo mas claro).
Solución Para llegar a la ciudad D solamente se puede llegar a través de
la ciudad C o de la ciudad B, por cada forma de llegar a la ciudad C hay
A
B
C
D
Figura 6.1: Problema resuelto 6.0.2
79

-- 79 of 315 --

80 CAPÍTULO 6. TÉCNICAS BÁSICAS DE CONTEO
A B C
Figura 6.2: Problema resuelto 6.0.3
una forma de llegar a la ciudad D y por cada forma de llegar a la ciudad B
hay una forma de llegar a la ciudad D. Por lo tanto, el número de formas
para llegar a la ciudad D iniciando en la ciudad A es la suma de las formas
para llegar a la ciudad B y a la ciudad D, es decir 2 + 3 = 5.

Problema Resuelto 6.0.3. Hay cuatro caminos que conducen de la ciudad
A a la ciudad B, y tres caminos que conducen de la ciudad B a la ciudad C.
¾Cuántos caminos que pasan por B conducen hasta C?
Solución Vamos a llamar v1, v2, v3 y v4 a los caminos que van desde A hasta
B y w1, w2, w3 a los caminos que van desde la ciudad B hasta la ciudad C.
Para ir desde A hasta C pasando por B es necesario llegar hasta B usando
alguno de los 6 caminos, y posteriormente elegir alguno de los tres caminos
para ir desde B hasta C.
Es decir, existen los siguientes 12 caminos:
v1, w1
v1, w2
v1, w3
v2, w1
v2, w2
v2, w3
v3, w1
v3, w2
v3, w3
v4, w1
v4, w2

-- 80 of 315 --

81
v4, w3
Aquí puede observarse que por cada camino que empieza con v1 hay algun
camino terminado en w1, alguno terminado en w2 y alguno terminado en w3,
por cada camino que empieza con v2 también hay 3 caminos terminados
en w1, w2 y w3 respectivamente; lo mismo para v3 y v4. Por lo tanto hay
(4)(3) = 12 caminos.

Problema Resuelto 6.0.4. Hay x caminos que conducen de la ciudad A
a la ciudad B, y y caminos que conducen de la ciudad B a la ciudad C.
¾Cuántos caminos que pasan por B conducen hasta C?
Solución Por cada una de las x formas para ir de la ciudad A hasta la
ciudad B existen y formas para ir de la ciudad B hasta la ciudad C. Por lo
tanto existen xy formas para ir desde A hasta C pasando por B.

Código 6.1: Función f
1 int f ( int A, int B) {
2 int i , k , r =0;
3 for ( i =0; i <A; i ++){
4 for ( k=0;k<B ; k++){
5 r++;
6 }
7 }
8 return r ;
9 }
Problema Resuelto 6.0.5. ¾Cuál es el valor de retorno de la función f en
el código anterior?
Solución Este problema se puede reducir en saber cuántas veces se ejecuta
la línea 5.
Hay que hacer notar que la línea 3 se ejecuta A veces y por cada vez que
se ejecuta la línea 3, la línea 5 se ejecuta B veces. Por lo tanto el número de
veces que se ejecuta la línea 5(y por ende el valor de retorno de la función)
es AB.

-- 81 of 315 --

82 CAPÍTULO 6. TÉCNICAS BÁSICAS DE CONTEO
6.1. Reglas Básicas de Conteo
A pesar de que los problemas de combinatoria enumerativa son bastante
variados, la mayoría pueden resolverse utilizando las llamadas regla de la
suma, regla del producto, biyeccion y recursión.
Ya dedicamos batante tiempo a ver lo que es recursión, y además a estas
alturas ya deberías ser capás de utilizar la regla de la suma y el produc-
to cuando te encuentres con un problema de combinatoria enumerativa, sin
embargo, hay que identicarlas para poder justicar claramente nuestros ra-
zonamientos:
Teorema 5 (Regla de la Suma). Si cierto objeto x puede ser elegido de n
maneras diferentes y otro objeto y puede ser elegido de n1 maneras diferentes,
entonces el número de formas de elegir x o y es n + n1.
Una manera mas precisa de decirlo, es que para dos conjuntos disjuntos
A y B, el número de elementos que pertenecen a A o a B es |A| + |B|.
Aunque la regla anterior es bastante evidente tanto en su denición como
en su aplicación, la siguiente regla es menos obvia de ver y aplicar que la
anterior.
Teorema 6 (Regla del Producto). Si cierto objeto x puede ser elegido de n
maneras diferentes y otro objeto y puede ser elegido de m maneras diferentes,
entonces el número de formas de elegir x y posteriormente elegir y es nm.
Una manera mas precisa de decirlo, es que para dos conjuntos A y B, el
número de pares ordenados (a, b) tales que a ∈ A y b ∈ B es |A||B|.
Por ejemplo, si queremos formar palabras de longitud 2 únicamente con
las letras a, b y c el número de formas de hacerlo es 9: aa, ab, ac, ba, bb, bc,
ca, cb y cc. Si se quisieran formar palabras de longitud 3 únicamente con las
letras a, b y c el número de formas de hacerlo sería 33 = 27.
Una aplicación computacional es la siguiente: ¾ Alguna vez te has pre-
guntado por qué en C y C++ los enteros con signo soportan valores desde
−2147483648 hasta 2147483647 y qué tiene que ver eso con que sean tipos
de datos de 32 bits?.
Cada bit es un dígito que puede ser solamente 0 o 1 y el conjunto
de dígitos binarios que sean iguales a 1 determina el número almacenado.
Por ello hay 32 dígitos y cada uno puede ser elegido de dos maneras, por
regla del producto la cantidad de números que pueden ser almacenados en
32 bits es: 232 = 4294967296, y ahora, un int puede tener cualquiera de
2147483647 − (−2147483648) + 1 = 4294967296 valores diferentes y por ese
mismo motivo los enteros sin signo(también de 32 bits) soportan valores des-
de 0 hasta 4294967295.

-- 82 of 315 --

6.2. CONJUNTOS, SUBCONJUNTOS, MULTICONJUNTOS 83
La unica regla que falta es la de las biyecciones; su uso también es bastante
natural, sin embargo la forma de utilizarlo involucra bastante creatividad y
es mas complicado de denir.
La idea básica de la biyección es la de contar algo distinto a lo que inicial-
mente se quiere contar y luego demostrar que lo que se contó es del mismo
tamaño que lo que inicialmente se quería contar.
Por ejemplo, para contar cuantos subconjuntos tiene un conjunto de n
elementos, contamos cuantas cadenas hay de longitud n tales que contengan
solamente 0s y 1s.
La manera de demostrar que contar el número de subconjuntos equivale
a contar el número de cadenas con 0s y 1s se basa en decir que a cada cadena
le corresponde un único subconjunto y viceversa.
Es decir, dos conjuntos A y B tienen la misma cantidad de elementos, si
es posible asignarle a cada elemento de A una única pareja en B, y a cada
elemento en B asignarle una única pareja en A. Al conjunto de todas las
parejas se le conoce como biyección.
Siendo mas precisos:
Teorema 7 (Regla de la Biyección). Si para dos conjuntos A y B existe un
conjunto de pares ordenados P tal que para cada a ∈ A existe un único b ∈ B
tal que (a, b) ∈ P y para cada b ∈ B existe un único a ∈ A tal que (a, b) ∈ P
entonces se dice que P es una biyección entre A y B y además |A| = |B|.
6.2. Conjuntos, Subconjuntos, Multiconjuntos
Ya en la sección 5.2 habíamos denido conjuntos y subconjuntos, aquí
exploraremos algunas de sus propiedades y deniremos multiconjunto.
La siguiente propiedad es fundamental en las tecnicas de conteo:
Teorema 8 (Número de Subconjuntos). Si un conjunto C tiene n elementos,
el número de subconjuntos de C es exactamente 2n.
Demostración. Cada uno de los n elementos puede estar dentro o fuera del
subconjunto, nótese que para todo subconjunto S ⊂ C existe un subconjunto
T ⊂ C tal que S y T no tienen elementos en común y cada elemento de C
está o bien en S o en T .
De esta manera, todo elemento de C puede ser elegido de dos formas: para
formar parte de S o para formar parte de T y como C tiene n elementos, por
regla del producto se concluye que C tiene exactamente 2n subconjuntos.

-- 83 of 315 --

84 CAPÍTULO 6. TÉCNICAS BÁSICAS DE CONTEO
Ahora vamos a introducir un nuevo concepto, se trata del concepto de los
multiconjuntos.
La idea de un multiconjunto es poder representar un conjunto con elemen-
tos repetidos, ya que para modelar ciertos sistemas se pueden tener elementos
que compartan las mismas propiedades; por ejemplo en el ajedrez, todos sabe-
mos que cada jugador cuenta inicialmente con 16 piezas, sin embargo algunas
de esas piezas son idénticas y con ellas se podría hacer exactamente lo mis-
mo; otro ejemplo interesante puede ser el dinero que se traiga en la cartera,
puede haber varias monedas que en la práctica son exactamente iguales.
Asi que de manera general, un multiconjunto es un conjunto con ele-
mentos que se pueden repetir. Pero esta claro que esta denición aunque es
bastante comprensible y dice mucho sobre la aplicación de los multiconjun-
tos es inadmisible de manera formal, por lo que se ha construido esta otra
denición:
Denición 6.2.1 (Multiconjunto). Un multiconjunto se dene como el par
(C, f ) donde C es un conjunto y f es una función tal que a cada elemento
de C le asigna un número entero positivo.
El proposito de f en ésta denición es decir cuántas veces aparece cada
elemento en el multiconjunto. Lo que ahora necesitamos tener es un análogo
a los subconjuntos pero en los multiconjuntos, el cual llamaremos submulti-
conjunto.
Nuestro sentido común nos dice que si queremos denir un submulticon-
junto S de un multiconjunto A entonces todos los elementos de S deben de
aparecer en A, y además, es inadmisible que un elemento de S aparezca mas
veces en S que en A.
Mas formalmente:
Denición 6.2.2 (Submulticonjunto). Sea A = (C, f ) un multiconjunto,
S = (D, g) es un submulticonjunto de A si D ⊆ C y además para todo
d ∈ D se cumple que g(d) ≤ f (d). Y se denota como:
S ⊆ A
Lo siguiente que nos debemos preguntar es ¾Cuántos submulticonjuntos
tiene un multiconjunto nito A = (C, f )?. Para contarlos procederemos de
la misma manera que para contar los subconjuntos.
Es decir, cada elemento c ∈ C puede estar desde 0 hasta f (c) veces en el
submulticonjunto. De esta manera cada elemento de C puede ser elegido de
f (c) + 1 formas.

-- 84 of 315 --

6.3. PERMUTACIONES 85
Usando regla del producto concluimos que el número de submulticon-
juntos de A es (f (a1) + 1)(f (a2) + 1)(f (a3) + 1)...(f (an) + 1) donde C =
{a1, ..., an}.
Una observación interesante es que según esa fórmula si cada elemento de
A aparece una sola vez, es decir si f (ai) = 1 para toda i entonces el número
de submulticonjuntos es 2n, lo cual coincide con nuestras observaciones en
los conjuntos.
6.3. Permutaciones
Ya se habían mencionado las permutaciones, sin embargo, solamente se
denieron de manera que no pudiera haber elementos repetidos. Aquí se verán
las permutaciones de una forma más general.
Denición 6.3.1 (Permutación). Una permutación es un reacomodo de ob-
jetos o símbolos en secuencias diferentes.
Las permutaciones, al igual que los conjuntos, suelen representarse como
una lista de los elementos separada por comas pero delimitada por paréntesis.
Sin embargo, a diferencia de los conjuntos, en las permutaciones el orden en
el que se listan los elementos si importa.
Por ejemplo, hay 6 permutaciones del conjunto C = {X, Y, Z}:
(X, Y, Z)
(X, Z, Y )
(Y, X, Z)
(Y, Z, X)
(Z, X, Y )
(Z, Y, X)
Pero solamente hay 3 permutaciones del multiconjunto C = {A, A, B}:
(A, A, B)
(A, B, A)
(B, A, A)
Las permutaciones de multiconjuntos se conocen como permutaciones
con repetición.

-- 85 of 315 --

86 CAPÍTULO 6. TÉCNICAS BÁSICAS DE CONTEO
Ya habíamos visto que un conjunto con n elementos tiene exactamente
n! permutaciones, a continuación descubriremos cómo explotar y extrapolar
esta propiedad.
Problema Resuelto 6.3.1. Para una empresa se requiere que se ocupen los
siguientes cargos: presiente, vicepresidente, secretario, vicesecretario, barren-
dero. Solamente puede(y debe) haber un presidente, un vicepresidente, un
secretario, un vicesecretario pero no hay límite de barrenderos. Si 6 personas
van a ocupar cargos ¾de cuántas formas pueden ocuparlos?.
Solución Dado que hay 5 cargos diferentes y 4 de ellos son únicos, el
número de barrenderos es 6 − 4 = 2.
Primero veremos de cuantas formas se pueden elegir a los barrenderos.
Si etiquetamos a un cargo de barrendero como A y a otro cargo como B,
entonces podemos elegir de entre 6 personas al barrendero A y luego podemos
elegir de entre las 5 restantes al barrdendero B, eso da un total de (6)(5) = 30
formas de elegirlos, pero dado que si nos olvidamos de las etiquetas A y B,
el órden en el que se eligen en realidad no importa, veremos que cada forma
de elegirlos se está contando dos veces, por lo que el número de formas de
elgir a los barrenderos es (6)(5)/2 = 15.
Una vez elegidos a los barrenderos quedan 4 cargos diferentes y 4 per-
sonas diferentes, nótese que por cada permutación de las personas existe una
manera de asignarle los cargos(a la primer persona presidente, a la segunda
vicepresidente, a la tercera secretario y a la cuarta vicesecretario). Por ello
el número de formas de asignar 4 cargos diferentes a 4 personas diferentes es
4!=16.
Por regla del producto el número total de formas de asignar los puestos
de trabajo es (15)(16) o dicho de otra forma:
( 6!
4!2!)((6 − 2)!) = 6!
2!

Problema Resuelto 6.3.2. Para una empresa se requiere que se ocupen los
siguientes cargos: presiente, vicepresidente, secretario, vicesecretario, barren-
dero. Solamente puede(y debe) haber un presidente, un vicepresidente, un
secretario, un vicesecretario pero no hay límite de barrenderos. Si 8 personas
van a ocupar cargos ¾de cuántas formas pueden ocuparlos?.

-- 86 of 315 --

6.3. PERMUTACIONES 87
Solución El problema es exactamente el mismo que el del ejemplo anterior,
solamente que ahora el número de barrenderos es 8 − 4 = 4.
Si los 4 puestos de barrenderos fueran todos diferentes entre sí entonces
está claro que el número de formas de asignar los cargos sería 8!.
Pero por cada manera de asignar 8 personas a 8 cargos diferentes existen
(8 − 4)! = 4! maneras de asignar 8 personas a 4 cargos diferentes y un cargo
repetido 4 veces. Esto es porque las personas que estuvieran ocupando los
cargos de barrenderos serían 4 y podrían reordenar de 4! formas.
De esta manera la solución es:
8!
4!

Problema Resuelto 6.3.3. Un restaurant requiere 3 meseros, 4 cocineros y
4 barrenderos, si 20 personas quieren trabajar y estan igualmente capacitadas
para ocupar cualquiera de los cargos, ¾de cuantas formas pueden ocuparlos?
Solución Primero que nada intentaremos transformar este problema a al-
go parecido al problema anterior, debido a que es mas fácil tratar con un
problema previamente resuelto.
El número de personas que ocuparán al menos uno de los cargos es un
total de 3 + 4 + 4 = 11, por lo que 9 personas se quedarán con las ganas
de trabajar(pero sin poder hacerlo). Así que para resolver este problema
imaginaremos un nuevo cargo en el cual se quedarán las 9 personas que no
consigan ninguno de los otros.
Si las 20 personas se acomodaran en una la sería posible asignarles a los
primeros 3 el cargo de meseros, a los siguientes 4 el cargo de cocineros, a los
siguientes 4 el cargo de barrenderos y a los ultimos 9 nuestro cargo imaginario;
en efecto, si se quieren asignar cargos de alguna manera, sin importar la que
sea, siempre es posible ordenar a las 20 personas en una la de tal forma
que se asignen los cargos de manera deseada utilizando el criterio que ya se
mencionó.
Pero aún existen varias formas de ordenar a la la que producen la misma
asignanción de empleos. Por ahora solo sabemos que el número de formas de
ordenar la la es 20!.
Ahora, para cualquier manera de ordenar la la, es posible reordenar a
los meseros de 3! formas distintas, es posible reordenar a los cocieneros de 4!
formas distintas, es posible reordenar a los barrenderos de 4! formas distintas
y además es posible reordenar a los que ocupan el cargo imaginario de 9! for-
mas diferentes y todo esto produciendo la misma asignación de empleos; por

-- 87 of 315 --

88 CAPÍTULO 6. TÉCNICAS BÁSICAS DE CONTEO
ejemplo, si se cambian de órden las primeras 3 personas de la la sin mover
a las demás las 3 personas seguirán siendo meseros y las demás personas
seguirán ocupando los mismos cargos.
Por regla del producto, para cualquier manera de ordenar la la, es posible
reordenarla sin cambiar la asignación de empleos de (3!)(4!)(4!)(9!) formas
distintas.
Por lo que el número total de maneras de asignar los empleos es:
20!
3!4!4!9!

Viendo la solución del ejemplo anterior, se puede encontrar fácilmente una
demostración análoga del siguiente teorema, el cual resulta obvio después de
ver la solución del ejemplo anterior:
Teorema 9 (Permutaciones con Repetición). Sea M = (C, f ) un multi-
conjunto donde C = c1, c2, ..., cn son los elementos que posee y f (ci) es el
número de veces que se encuentra cualquier elemento ci en M . El número de
permutaciones del multiconjunto M es:
P n
f (c1)f (c2)...f (n) = n!
f (c1)!f (c2)!...f (n)!
6.4. Combinaciones
Como ya habíamos visto en la Parte I, las combinaciones, o coecientes
binomiales son el número de subconjuntos con exactamente k elementos es-
cogidos de un conjunto con exactamente n elementos para una k y una n
dadas. Y se denota de la siguiente manera:
(n
k
)
Ya habíamos se había visto en la Parte I cómo calcular las combinaciones
utilizando el triángulo de Pascal. Pero es conveniente conocer una fórmula
cerrada para calcularlas y no solamente una función recursiva.
Recordando los ejemplos de la sección de permutaciones con repetición,
podemos transformar este problema a tener una empresa con 2 puestos de
trabajo uno con k plazas y otro con n − k plazas y encontrar el número de
formas en las que n trabajadores pueden ocupar todos los puestos. O dicho
de otra manera, encontrar el número de formas de ordenar k elementos de
un tipo con n − k elementos de otro tipo.

-- 88 of 315 --

6.5. SEPARADORES 89
Teorema 10 (Combinaciones de n en k).
(n
k
)
= n!
(n − k)!k!
6.5. Separadores
Muchos problemas de combinatoria se resuelven agregando al planteamien-
to unos objetos llamados separadores, para los cuales existe una biyección
entre lo que se quiere contar y ellos. Es difícil ilustrar de manera general lo
que son los separadores. Así que se mostrará en ejemplos cómo usarlos.
Problema Resuelto 6.5.1. Se tienen 20 canicas idénticas y se quieren
guardar en 3 frascos diferentes sin importar si uno o dos de los frascos quedan
vacíos. ¾De cuántas formas se puede hacer esto?
Solución En lugar de imaginar 20 canicas, imagina 20 guiones alineados
en una recta de la siguiente manera:
- - - - - - - - - - - - - - - - - - - -
Ahora, vamos a insertar 2 bárras verticales entre los guiones. A dichas
barras verticales les llamaremos separadores.
Una posible manera de insertarlas sería así:
- - - - - - - - - - | - - - | - - - - - - -
Lo anterior puede ser interpretado como poner 10 canicas en el primer
frasco, 3 canicas en el segundo frasco y 7 canicas en el tercer frasco, dicho
de otra manera, los guiones anteriores al primer separador se ponen en el
primer frasco, los guiones entre el primero y segundo separador se ponen en
el segundo frasco y los guiones posteriores al segundo separador se ponen en
el tercer frasco.
Asi que por cada manera de insertar dos separadores entre un total de 20
guiones existe una manera de guardar 20 canicas identicas en un total de 3
frascos diferentes y viceversa, es decir ½Hay una biyección entre el número de
separadores y el número de formas de repartir las caincas!.
Además, el número de formas de poner los dos separadores, es el número
de permutaciones con repetición de 20 objetos de un tipo y 2 objetos de otro
tipo, lo cual es equivalente a:
P 20+2
20,2 = 22!
20!2! =
(22
2
)

-- 89 of 315 --

90 CAPÍTULO 6. TÉCNICAS BÁSICAS DE CONTEO

Problema Resuelto 6.5.2. ¾De cuántas formas se pueden formar en una
la 20 marcianos diferentes y 7 jupiterianos diferentes de manera que no haya
ningún par de jupiterianos adyacentes?
Consideremos primero el caso donde hay 20 marcianos idénticos y 7 jupi-
terianos idénticos.
Queremos saber el número de formas de dividir a 20 marcianos en 8
grupos de manera que en cada uno de los grupos haya al menos un marciano.
Y luego el primer grupo se puede colocar frente al primer jupiteriano, el
segundo grupo frente al segundo jupiteriano, y asi sucesivamente, quedando
el último grupo detras del último jupiteriano.
Para hacer eso primero hay que asignarle un marciano a cada grupo,
quedando 12 marcianos disponibles para repartirse en 8 grupos; el número
de formas de hacerlo se puede calcular añadiendo 7 separadores a los 12
marcianos, con lo cual resultan (12+7
7
) formas de hacerlo.
Ya calculamos el número de maneras de ordenarlos si fueran identicos,
pero dado que son diferentes, por cada manera de ordenarlos sin consider-
ar las diferencias marciano-marciano y jupiteriano-jupiteriano existen 20!7!
maneras diferentes de reordenarlos sin cambiar el tamaño de ninguno de los
8 grupos. Por lo tanto, el número de formas en las que se pueden acomodar
20 marcianos diferentes y 7 jupiterianos diferentes en una la sin que haya
dos jupiterianos juntos es:
(19
7
)
(20!)(7!)


-- 90 of 315 --

Cap´ıtulo 7
Funciones
Las funciones son un tema fundamental dentro de las ciencias de la com-
putación al igual que en el resto de las matemáticas; son necesarias para
entender correctamente la mayoría de los algoritmos y en ellas se centra el
análisis de complejidad.
El concepto de función muy comúnmente es malentendido o usado de una
manera incorrecta. A veces se tiene la creencia de que una función necesari-
amente se puede expresar como una ecuación o que todos los valores de las
funciones son conocidos; y para los programadores es mas común pensar en
las funciones como máquinas que reciben parámetros y devuelven valores.
Para ciertas aplicaciones son útiles esas análogías, pero para lo que viene
después se requiere entender perfectamente lo qué es una función y cómo
aparecen de manera natural mientras se resuelven problemas.
No es de sorprender entonces que se les dedique un capítulo a las fun-
ciones, ya que en los próximos capítulos estaremos trabajando con ellas y
resulta razonable dedicar un tiempo a denir realmente con qué estamos
trabajando.
7.1. Las Funciones como Reglas
Como se decía unos párrafos atrás, las funciones muchas veces son vistas
como máquinas que reciben parámetros y devuelven valores; aunque esta
forma de verlas es útil en la programación, es muy limitada en la resolución
de problemas. Una forma parecida de ver las funciones es como reglas, es
decir, una función puede ser vista como una regla que a cada elemento de un
conjunto X le asigna un elemento(y solo uno) de un conjunto Y.
Los siguientes ejemplos sirven para ilustrar mejor esta manera de ver las
91

-- 91 of 315 --

92 CAPÍTULO 7. FUNCIONES
funciones: