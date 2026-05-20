# 6. La regla que le asigna un tiempo de ejecución a cada conjunto de en-

tradas en un programa.
Con estos ejemplos debe de quedar claro que una función puede ser
cualquier regla que le asigne elementos de un conjunto Y a los elementos de
un conjunto X, y cualquier regla se reere a que las reglas pueden no ser de-
scritas por alguna ecuación o expresión algebrárica, pueden no estar denidas
en todos los números, pueden incluso no estar denidas en números(como en
el ejemplo 3), y es posible que en algunos casos(como en el ejemplo 5) no se
conozca a qué números u objetos se puede aplicar.
Si una función le asigna un elemento de un conjunto Y a cada elemento
de un conjunto X entonces se dice que el dominio de la función es de dominio
X y la codominio Y .
Aunque no es un requisito, las funciones se suelen designar por la letra
f , y cuando hay mas de una función se suelen usar también las letras g y h.
Si f es una función, x una variable tal que x ∈ X, entonces el valor que f
asocia con x se expresa como f (x) y se lee como f de x.
La función del primer ejemplo se puede expresar como:
f (x) = x
2 para todo número real n
La del segundo ejemplo se puede denir como
f (n) = (n)(n + 1)
2 para todo entero positivo n
El tercer ejemplo no se puede denir completamente con esta notación,
ya que no hay expresión algebrarica que represente una CURP o un ciu-
dadano, y tampoco conocemos un procedimiento para encontrar la CURP;

-- 92 of 315 --

7.1. LAS FUNCIONES COMO REGLAS 93
solamente sabemos que el dominio es el conjunto de ciudadanos y la imagen
es el conjunto de las CURPs.
Por este motivo es necesario denir mas notación. Si f es una función, D
su dominio y C su codominio, se puede denotar de la siguiente manera:
f : D −→ C
Así ya podemos expresar el tercer ejemplo como una función:
f : D −→ C donde D es un conjunto de ciudadanos y C es un conjunto de CURPs
El cuarto ejemplo tambien puede resultar peculiar, ya que muchas veces
se espera que el dominio de una función sea un solo número y no dos. Para
ser precisos el dominio de la función del cuarto ejemplo es el conjunto de
todos los pares órdenados de números reales (a, b), el cual se representa como
R2.
Asi que el cuarto ejemplo se puede describir así:
f (a, b) = a + b
2 para todo par de números (a, b) ∈ R2
Para el quinto ejemplo no hay mas remedio que enumerar los valores
conocidos:
f (x) = √2, si x = 53
= 1
2, si x = 42
= π, si x = 3
4
El sexto ejemplo habla de una función que corresponde al tiempo que tar-
da en ejecutarse un programa con determinada entrada; esta función cobrará
mucha importancia mas adelante y se le conoce como la función de tiempo.
Después de usar mucho tiempo las funciones, es natural comenzar a pensar
en abreviaturas, como con el primer ejemplo f (x) = x
2 para todo número
real n podría parecernos muy largo, así que muchas veces por practicidad
se omite la descripción del dominio de la función y se deberá asumir que el
dominio es el conjunto de todos los números reales para los cuales la función
tiene sentido.
Por ejemplo para la función f (x) = 1
x se sobreentiende que el dominio es
todos los números reales excepto el 0. Sin embargo existen muchos intentos
por abreviar aún más esta notación pero la mayoría resultan inadecuados.

-- 93 of 315 --

94 CAPÍTULO 7. FUNCIONES
Por ejemplo sustituir f (x) = x
2 por x
2 equivaldría a hablar de un número
real en lugar de una función; la única manera aceptable de abreviar esto
aún más es como x → x
2 , esto no representa una gran mejoría en cuanto a
la abreviación y en ocaciones puede parecer menos claro, la única ventaja
que parece tener esta notación es que no hay que asignarle un nombre a la
función y puede servir cuando se esté trabajando con muchas funciones y no
sea necesario nombrar a todas.
Luego de ver estos ejemplos es clara la ventaja de ver las funciones como
reglas y no solamente como máquinas, ya que es mas claro imaginar una
regla implícita que una máquina implícita, y no queda claro que una máquina
simpre devuelva la misma salida para una entrada dada.
7.2. El Concepto Formal de Función
A pesar de que se pueden inferir muchas cosas imaginando a las funciones
como reglas, el concepto de regla es subjetivo, es preferible denir algo en base
a cosas ya conocidas y con propiedades bien denidas.
La palabra regla puede signicar distintas cosas en distintos contextos.
Algo que sabemos muy bien cómo se comportan son los conjuntos y los pares
ordenados. Deniremos una función a partir de esto para que no quede duda
de qué es ó cómo se comporta una función.
Primero que nada necesitamos denir un concepto bastante importante
en muchas áreas de las matemáticas, y este es el del producto cartesiano, este
concepto se reere al conjunto de todos los pares ordenados formados por
elementos de dos conjuntos dados.
Por ejemplo, el producto cartesiano de Z y Z son todos los puntos del
plano cartesiano cuyas cordenadas son enteras.
El producto cartesiano de {1, 2} y {3, 4} es {(1, 3), (1, 4), (2, 3), (2, 4)},
nótese que (1, 3) si es parte del producto cartesiano pero (3, 1) no lo es, por
ello decimos que el producto cartesiano es no conmutativo.
El hecho de que el producto cartesiano sea no conmutativo hace que
este concepto sea aplicable a gran cantidad de cosas y algunas de ellas no
estan muy relacionadas con las ciencias de la computación, como lo es el
producto cartesiano de los nombres y los apellidos, con el cual se obtiene el
conjunto de todos los nombres completos válidos.
Denición 7.2.1 (Producto Cartesiano). El producto cartesiano de dos con-
juntos A y B es el conjunto de todos los pares ordenados (a, b) tal que a ∈ A
y b ∈ B, y se denota como:
A × B

-- 94 of 315 --

7.2. EL CONCEPTO FORMAL DE FUNCIÓN 95
A cualquier subconjunto de A × B se le denomina relación de A en B, el
concepto de relación es muy importante, ya que casi todo lo que estudian las
matemáticas(independientemente de las otras propiedades que tengan) son
relaciones.
Por ejemplo el conjunto de todos los pares de números (a, b) tal que b
es multiplo de a es una relación de Z en Z y se le llama divisibilidad. El
conjunto de los pares de números (a, b) tales que a < b son la relación menor
que; incluso las funciones son relaciones.
Denición 7.2.2 (Función). Una función f con dominio en A y codominio
en B es un subjunto de A × B tal que:
Si (a, b) ∈ f y (a, c) ∈ f entonces b = c
Si a ∈ A entonces existe b ∈ B tal que (a, b) ∈ f
Admitimos las siguiente notación:
Una función f con dominio en A y codominio en B se denota como
f : A −→ B.
(a, b) ∈ f se denota como f (a) = b.
f (a) es aquel número tal que (a, f (a)) ∈ f .
x → f (x) se reere al conjunto de todos los pares ordenados (x, f (x))
para todo x en el dominio de f .
Muchas veces hay que tener presente la denición anterior, sin embargo,
sigue siendo mas útil para resolver problemas el hecho de ver una función
como una regla.
En general este tipo de deniciones sirven para aclarar aspectos oscuros
respecto a lo que puede ser y lo que no puede ser una función evitando así
llegar a contradicciones.

-- 95 of 315 --

96 CAPÍTULO 7. FUNCIONES

-- 96 of 315 --

Cap´ıtulo 8
Análisis de Complejidad
Comunmente se suele pensar que la computadora efectúa sus operaciones
con una velocidad innitamente rápida y con una capacidad de almace-
namiento innita. Y esto es natural, ya que una computadora puede realizar
millones de operaciones cada segundo así como almacenar información que
no cabría ni en 100 bibliotecas.
Sin embargo, en las matemáticas existen funciones cuyos valores crecen a
una velocidad impresionante; por ejemplo, f (x) = 2x, mientras valores como
f (8) = 256, f (9) = 512, f (10) = 1024 son relativamente pequeños, tenemos
que f (30) = 1099511627776, y si decimos que f (x) representa el número de
sumas que debe realizar un programa, nos encontramos con que si x = 29
el programa tardaría medio segundo en correr(en una computadora con 1.5
Ghz), si x = 30 el programa tardaría un segundo, si x = 31 el programa
tardaría 2 segundos, si x = 42 el programa tardaría mas de una hora, si
x = 59 el programa tardaría 182 años en ejecutarse y si x = 100 el programa
tardaría en ejecutarse casi 31 mil veces la edad del universo.
Por todo esto, ni siquiera las computadoras se salvan de tener que limitar
el número de operaciones que realizan; pero la manera en que las computa-
doras se comportan es muy diferente a la manera en la que nos comportamos
los humanos.
Mientras que un humano puede comenzar a resolver un problema de cierta
manera y luego darse cuenta de que existen formas más rápidas de hacerlo,
una computadora no, la computadora ejecutará el algoritmo para el que fue
programada de principio a n; es por eso que los humanos necesitamos saber
qué tan rápidos son los algoritmos antes de pedirle a una computadora que
los ejecute.
La mayor parte del estudio de diseño de algoritmos está enfocado en
encontrar algoritmos sucientemente rápidos, y para lograr eso se requiere
97

-- 97 of 315 --

98 CAPÍTULO 8. ANÁLISIS DE COMPLEJIDAD
una gran cantidad de análisis, pero sobre todo se requiere saber qué clase de
algoritmo se está buscando, y para saber eso es indispensable poder medir la
velocidad del algoritmo, o dicho de otra manera, su complejidad.
Dado que las computadoras son rápidas, es muy difícil darse cuenta si
un programa es rápido o no con entradas pequeñas, así que el análisis de
complejidad se enfoca a las entradas grandes.
El análisis de complejidad es una técnica para analizar qué tan rápido
crecen las funciones, y nos centraremos en una función que mide el número
máximo de operaciones que puede realizar un algoritmo, a dicha función le
llamaremos función de tiempo.
Pero antes de analizar la complejidad de las funciones daremos varios
ejemplos, el primero de ellos corresponde a una aplicación en la física.
8.1. Un ejemplo no muy computacional
Imagina que sobre una silla de madera tienes un recipiente lleno de agua
con forma cilíndrica.
Las patas de la silla tienen una base cuadrada de 5 centímetros por 5
centímetros, el radio del recipiente es de 20 centímetros y su altura es de
otros 20 centímetros. Lo cual hace que el recipiente con agua tenga un peso
de poco más de 25 kilogramos.
La silla resiste muy bien ese peso, pero ahora imagina que conseguimos
un modelo a gran escala formado con los mismos materiales de la silla y
el recipiente. Digamos que cada centímetro del viejo modelo equivale a un
metro del nuevo modelo, es decir, es una silla 100 veces mas grande y un
recipiente 100 veces mas grande.
La pregunta es ¾el nuevo modelo resistirá?. Y la respuesta es simple: no.
En el modelo original 20cm2 sostenían 25kg, es decir, cada centímetro
del modelo original sostenía 1,25kg, sin embargo en el nuevo modelo, el
area de las patas suma un total de 4(500cm)(500cm) = 1000000cm2 y el
volúmen del recipiente es π(2000cm)2(2000cm) = 8,042496 ∗ 1026cm3 por lo
que el peso del nuevo recipiente es 8,042496 ∗ 1023kg, y de esa manera, ½ca-
da centímetro cuadrado de las nuevas patas tiene que soportar un peso de
804249600000000000kg!.
En general si un cuerpo que se encuentra sobre el suelo aumenta su
tamaño, se dice que el área que esta en contacto con el suelo crece de manera
cuadrática, mientras que su peso aumenta de manera cúbica.
Eso mismo se aplica a los animales, durante muchos años las películas nos
han mostrado insectos gigantes y lo seguirán haciendo, sin embargo, sabiendo
algo de análisis de complejidad podemos darnos cuenta que eso es imposible,

-- 98 of 315 --

8.2. ALGUNOS EJEMPLOS DE COMPLEJIDAD EN PROGRAMAS 99
ya que el área de las patas aumenta de manera cuadrática y su peso de
manera cúbica.
8.2. Algunos Ejemplos de Complejidad en Pro-
gramas
Al igual que las áreas y los volúmenes que se mencionan en la sección
anterior, el tiempo de ejecución de los programas también puede crecer de
maneras cuadráticas, cúbicas, lineales, logarítmicas, etc., en esta sección se
analizará el tiempo de ejecución de varios programas.
Supón que tienes la siguiente función:
Código 8.1: Función fnc
1 int f n c ( int n ) {
2 int i , k , r =0;
3 for ( i =0; i <n ; i ++){
4 for ( k=0;k<n ; k++){
5 r+=i ∗k ;
6 }
7 }
8 return r ;
9 }
Suponiendo que tu computadora tardara un segundo en procesar f nc(12000),
¾Cuánto tiempo crees que tardaría en procesar f nc(24000) ?
Los que están manejando por primera vez el análisis de complejidad posi-
blemente contestarían 2 segundos, pero la realidad es otra: se tardaría 4
segundos.
Si miramos bien el código a la variable r se le está sumando el producto
de cada par ordenado (i, k) donde 0 ≤ i < n y 0 ≤ k < n, por regla del
producto podemos concluir que se estan realizando n2 multiplicaciones.
También nos podemos percatar de que el bucle del centro itera n veces
por cada iteración del bucle exterior, y esa es otra manera en la que podemos
ver que el bucle interior itera un total de n2 veces.
Por simplicidad ignoraremos las sumas y las comparaciones (esas toman
mucho menos tiempo que las multiplicaciones) y nos concentraremos en las
multiplicaciones, si cada multiplicación tarda en ejecutarse un tiempo t, en-
tonces al llamar a f nc(12000) el tiempo total de ejecución sería (12000)2t y
al llamar a f nc(24000) el tiempo total de ejecución sería (24000)2t. Así que
si (12000)2t = 1s, ¾cuánto será (24000)2t ? Una forma de calcularlo sería

-- 99 of 315 --

100 CAPÍTULO 8. ANÁLISIS DE COMPLEJIDAD
obtener el valor de t, pero para este propósito nos dice más resolverlo de la
siguiente manera:
(24000)2t = (2 ∗ 12000)2t = 4(12000)2t
Sustituyendo 120002t por 1s obtenemos:
4(1s) = 4s
Hemos comprobado que el tiempo de ejecución serían 4 segundos, pero
ahora intentemos generalizar un poco.
Problema Resuelto 8.2.1. Si en una computadora f nc(a) tarda m se-
gundos en ejecutarse, ¾cuánto tiempo tardará f nc(2 ∗ a) en ejecutarse en la
misma computadora?
Solución Tenemos que f nc(a) tarda un tiempo de a2t en ejecutarse. Y
f (2 ∗ a) tarda un tiempo de 4a2t en ejecutarse. Sustituyendo a2t por m
tenemos que tardaría 4m segundos.
Si repitiéramos el ejemplo anterior pero con f nc(10 ∗ a) ½veríamos que el
tiempo de ejecución ascendería a 100m segundos !

Ahora considera la siguiente función:
Código 8.2: Función cubo
1 double cubo ( double x ) {
2 return x∗x∗x ;
3 }
Aquí sin importar qué tan grande sea el valor de x, cubo(x) siempre
tomará mas o menos el mismo tiempo en ejecutarse, a diferencia de la función
anterior, cubo(a) tardaría el mismo tiempo en ejecutarse que cubo(10 ∗ a).
Un mismo algoritmo puede ser implementado de muchas maneras en un
mismo lenguaje, y dependiendo de la implementación, del compilador y del
hardware en el que corra el programa, el tiempo de ejecución sería mayor o
menor, sin embargo, sin importar todo eso, siempre aumentará con la misma
velocidad.
Es decir, si vamos a tratar con algoritmos, nos vamos a concentrar en
encontrar algoritmos cuyo tiempo de ejecución aumente lo menos posible a
medida que la entrada se hace más y más grande.
Por ello, cuando se trata de entradas grandes, lo mas importante es iden-
ticar qué tan rápido crecen los tiempos de ejecución y no cuál es el número
exacto de operaciones o el tiempo exacto de ejecución.

-- 100 of 315 --

8.3. FUNCIÓN DE TIEMPO 101
8.3. Función de Tiempo
Si tuviéramos todo el tiempo y las energías del mundo para resolver un
problema sería posible implementar una solución, generar casos de prueba y
luego ver si su tiempo de ejecución no es excede del límite; y en caso de que
se exceda pensar en otra solución y empezar desde el principio.
Sin embargo, no tenemos todo el tiempo del mundo y seguramente nadie
tendría paciencia y energías ilimitadas para implementar muchos algoritmos
sin saber de antemano cual va a funcionar en tiempo.Esto hace necesario
saber qué tan rápido funcionaría un algoritmo desde antes de implementarlo.
El tiempo de ejecución de un algoritmo no es algo fácil de medir, so-
bre todo antes de implementarlo; ya que depende directamente de todas las
operaciones que se vayan a hacer en el código y de la velocidad de la com-
putadora en cada tipo de operación en especíco. El solo hecho de pensar en
el número exacto de sumas que realizará una computadora en determinado
algoritmo puede ser más tardado que implementar el mismo algoritmo.
Y además de todo esto, un mismo algoritmo puede tardarse diferente
cantidad de tiempo con diferentes entradas. Y a veces las variaciones son con
entradas del mismo tamaño.
Está claro que es imposible lidiar con todos estos datos cada que se quiera
resolver un problema, y es necesario ignorar algunos de ellos para poder
analizar de alguna forma la rapidez de un algoritmo.
Como se había mencionado unos capítulos atrás, vamos a considerar una
función E → T1(E) donde E es el conjunto de los datos de entrada y T1(E) es
el número de operaciones que realiza el algoritmo con esos datos de entrada.
Sería algo deseable poder trabajar con una función con dominio en los
enteros y codominio en los enteros, ya que resulta muy difícil trabajar con
conjuntos de datos de entrada. Para solucionar esto utilizaremos una función
de cota superior ó función pesimista.
La idea es denir una nueva función T2 : N −→ N de manera que T1(E) ≤
T2(n) cuando n ≥ |E| para todo conjunto de datos de entrada E.
Otra cosa que hay que denir es que T2(n) ≤ T2(n + 1), eso hará que el
análisis se vuelva signicativamente mas simple, no es difícil comprobar que
siempre existirá una función que cumpla con estas características.
T2 es una cota superior ya que para cualquier entrada E podemos estar
seguros que el número de operaciones que realizará el programa será igual
o menor a T2(|E|) y es pesimista porque lo que menos quisieramos(el peor
caso) para una entrada E es que T1(E) = T2(|E|).
Esta aproximación del pesimismo puede parecer inapropiada en la prác-
tica, pero se hablará de ella por varios motivos:

-- 101 of 315 --

102 CAPÍTULO 8. ANÁLISIS DE COMPLEJIDAD
Cuando se resuelve un problema, la solución debe de funcionar en todos
los casos que describa el problema, si en lugar de analizar el peor caso,
analizaramos un caso promedio; no estaríamos realmente resolviendo el
problema.
Existen varias maneras de analizar la complejidad, y la que se trata
en este libro es la mas simple de todas, y es bueno conocerla como
introducción a las otras.
Hay gran cantidad de algoritmos donde T1(E) es proporcional a T2(|E|)
para casi cualquier E.
Algunas veces los usuarios de las aplicaciones que programemos pueden
llegar a intentar darle entradas diseñadas especícamente para que nue-
stro algoritmo se vuelva lento(por ejemplo en un concurso de progra-
mación, o en una intrusión a un sistema).
De ahora en adelante llamaremos a T2 como la función de tiempo y la
representaremos simplemente como T .
8.4. La Necesidad del Símbolo O
Deniendo la función de tiempo hemos podido reducir una gran cantidad
de datos a unos pocos con un enfoque ligeramente pesimista. Pero aún así
medir el tiempo sigue siendo muy difícil.
Por ejemplo en la siguiente función:
Código 8.3: maximoSecuencial
1 void maximoSecuencial ( int v [ ] , int n ) {
2 int i , r ;
3 r=v [ 0 ] ;
4 for ( i =1; i <n ; i ++){
5 i f ( v [ i ]> r ) {
6 r=v [ i ] ;
7 }
8 }
9 return r ;
10 }
Podemos ver que ese código realiza al menos una asignación y a lo mas n
asignaciones a la variable r, así que siguiendo la línea del pesimismo vamos
a asumir que siempre se realizan n asignaciones a la variable r. Además se

-- 102 of 315 --

8.4. LA NECESIDAD DEL SÍMBOLO O 103
realizan n − 1 comparaciones entre i y n, n − 1 comparaciones entre v[i] y r
y n − 1 incrementos, asi que:
T (n) = n + (n − 1) + (n − 1) + (n − 1)
= 4n − 3
El conteo realizado, aunque nos condujo a una expresión algebrárica bas-
tante simple y en poco tiempo, habría sido muy difícil de realizar si solamente
conocieramos el algoritmo y no la implementación, por lo que nuevamente
caeríamos en la necesidad de tener que implementar el algoritmo antes de
saber si es eciente.
Además, múltiples implementaciones del mismo algoritmo pueden tener
funciones de tiempo diferentes.
Una cosa que podríamos hacer es seguir con la línea del pesimismo y
asumir que la búsqueda secuencial va a iterar n veces, que en cada iteración
va a realizar 100 operaciones(se está eligiendo un número arbitriariamente
grande para el número de operaciones dentro de un ciclo) y que lo que está
fuera del ciclo va a realizar otras 100 operaciones, así que antes de implemen-
tarlo sería posible denir la siguiente función de tiempo:
T (n) = 100n + 100
Bien podríamos elegir repetidas veces el número 100 para buscar cotas
superiores. Pero nos meteríamos en algunas complicaciones con la aritmética.
Por ejemplo con el siguiente código:
Código 8.4: Función cosa
1 void c o s a ( int v [ ] , int n ) {
2 int i , k , r ;
3 for ( i =0; i <n ; i ++){
4 for ( k=0;k<v [ i ] %77; k++){
5 r+=v [ i ] %(k+1) ;
6 }
7 }
8 return r ;
9 }
Aquí podríamos pensar que por cada vez que se ejecuta el bucle exterior,
el bucle interior se ejecuta 77 veces, que el bucle exterior se ejecuta n veces,
y que cada vez que se ejecuta el bucle interior gasta 100 operaciones. Por lo
que la función de tiempo sería:

-- 103 of 315 --

104 CAPÍTULO 8. ANÁLISIS DE COMPLEJIDAD
T (n) = n(77)(100)
= 7700n
Sabemos que solamente exageramos al elegir el 100 como el número de
operaciones que se hace el bucle interior cada que itera, así que el 7700n no
tiene ningún signicado real para nosotros, mas bien sería mas útil dejarlo
como 100(77)n.
El siguiente código, muy parecido al anterior puede causarnos mas mo-
lestias.
Código 8.5: Función cosas
1 void c o s a s ( int v [ ] , int n ) {
2 int i , k , r =0, h ;
3 for ( i =0; i <n ; i ++){
4 for ( k=0;k<v [ i ] %77; k++){
5 r+=v [ i ] %(k+1) ;
6 }
7 for ( h=0;h<n ; h++){
8 for ( k=0;k<v [ i ] %88; k++){
9 r+=v [ i ] %(k+1) ;
10 }
11 }
12 }
13 for ( k=0;k<v [ i ] %55; k++){
14 r+=v [ i ] %(k+1) ;
15 }
16 return r ;
17 }
Después de ser pesimistas llegaríamos a la conclusión de que
T (n) = (100)(n)(77 + 88n) + (100)(55)
= (100)(88n2 + 77n + 55)
Observamos que el 100 ahora multiplica a todos los términos. Y si nos
ponemos a pensar un poco, el 100 siempre multiplicará a todos los términos
si mantenemos la estrategia que hemos seguido hasta ahora.
Así que en lugar de utilizar el 100, puede resultar mas cómodo utilizar
otro símbolo, por ejemplo O, para representar un número mayor a lo que
cualquier código sin un bucle anidado puede tardar en ejecutarse.

-- 104 of 315 --

8.5. DEFINICIÓN DE LA NOTACIÓN O-MAYÚSCULA 105
Por lo que las funciones de tiempo en estos ejemplos se pueden expresar
como:
T (n) = O(n + 1) para maximoSecuencial
T (n) = O(77n) para la función cosa
T (n) = O(88n2 + 77n + 55) para la función cosas
8.5. Denición de la notación O-mayúscula
A pesar de que adoptando el uso de O como una constante de cota superi-
or, aún se puede hacer todavía mas sencillo el análisis. Considera el siguiente
ejemplo:
Código 8.6: Función funcion1
1 void f u n c i o n 1 ( int n ) {
2 int i , k , r , h ;
3 for ( i =0; i <n ; i ++){
4 for ( k=0;k <5;k++){
5 r++;
6 }
7 }
8 return r ;
9 }
Usando el análisis aprendido en la sección anterior podemos concluir que
T (n) = O(5n). Pero a continuación se muestra una función que obviamente
hace el mismo número de operaciones:
Código 8.7: Función funcion2
1 void f u n c i o n 2 ( int n ) {
2 int i , k , r , h ;
3 for ( i =0; i <n ; i ++){
4 k=0;
5 r++;
6 k++; k <5;
7 r++;
8 k++; k <5;
9 r++;
10 k++; k <5;
11 r++;

-- 105 of 315 --

106 CAPÍTULO 8. ANÁLISIS DE COMPLEJIDAD
12 k++; k <5;
13 r++;
14 k++; k <5;
15 }
16 return r ;
17 }
Y aquí, basándonos en la misma manera de analizar obtendríamos la
siguiente cota superior: T (n) = O(n) = O(5n). Esto no quiere decir que
debamos deshacernos de la idea de usar el símbolo O, sino que los bucles que
iteran un número constante de veces pueden contabilizarse como si iteraran
una sola vez.
Parece algo descabellado hacer esto en un inicio, pero el ejemplo anterior
lo prueba, es lo mismo un ciclo corto que itera un número constante de veces
que un código largo que itera solo una vez.
El objetivo de analizar de esta manera los algoritmos se trata de conocer
qué tan rápido crece el número de operaciones a medida que la entrada se
hace mas grande.
Por ejemplo, considerense 3 funciones de tiempo T, T ′ y T ′′ tales que:
T (n) = O(n), T ′(n) = O(100n) y T ′′(n) = O(n2). Tenemos que T (2n) =
2T (n), T ′(2n) = 2T ′(n) y T ′′(2n) = 4T ′′(n).
Aquí podemos ver que T y T ′ crecen al mismo ritmo, mientras que T ′′
crece a un ritmo mucho mayor.
Por lo tanto, decir que T (n) = O(100n) es equivalente a decir T (n) =
O(n), en ambos casos nos estamos reriendo a una cota superior que crece,
al mismo ritmo que n.
Un ejemplo nos servirá para convencernos de que el ritmo de crecimiento
es mas importante que el funcionamiento en casos pequeños: un algoritmo
A que realiza exactamente 100n operaciones será mucho mas rápido que un
algoritmo B que realiza n2 operaciones, donde n es el tamaño de la entrada.
Aunque para valores pequeños, como por ejemplo n = 3 o n = 10, el
algoritmo A es mas rápido, cuando n = 10000, por ejemplo, las cosas cam-
bian, ya que 100(10000) = 106 y (10000)2 = 108, eso signicaría que con una
entrada de tamaño 10 mil, el algoritmo A sería 100 veces mas rápido que el
algoritmo B.
Luego de justicar por qué ignorar las constantes, hemos llegado a un
punto donde debemos redenir nuestra notación, ya que si decimos que
T (n) = O(100n) y T (n) = O(n) concluiríamos que O(100n) = O(n) y que
100 = 1; así que no podemos seguir tratando a O como si fuera un número
real.

-- 106 of 315 --

8.5. DEFINICIÓN DE LA NOTACIÓN O-MAYÚSCULA 107
En lugar de decir que T (n) = O(n) diremos que T (n) es de órden O(n),
y la notación O(f (n)), mas que indicarnos que un número real O multiplica
al valor de la función f evaluado en n, signica que es posible elegir una
constante K de manera que n → Kf (n) sea una cota superior de la función
de tiempo.
Luego de haber reformulado conceptos, es necesario formalizarlo en la
siguiente denición:
Denición 8.5.1. Sea f una función con dominio en N se dice que es de
complejidad o de órden O(g(n)) si y solo sí existe alguna constante K tal
que:
f (n) < Kg(n) para todo n ∈ N
Nótese que al hablar de O(g(n)) no es necesario expresarlo como n →
O(g(n)) para decir que se trata de la función g y no de el valor de g evaluada
en n, esto es porque dentro de esta notación no aparecen constantes, sola-
mente variables; salvo que se trate de una función constante en cuyo caso,
siempre se expresa como O(1).
Problema Resuelto 8.5.1. Encuentra la complejidad de f nc, utiliza la
notación O-mayúscula.
Solución Si supusiéramos que f nc es de orden O(n), entonces debería de
existir alguna k tal que kn siempre sea mayor al número de operaciones que
realiza f nc(n), pero podemos darnos cuenta que para cualquier valor entero
de k que elijamos, el tiempo de ejecución de f nc(k + 1) siempre será mayor
que k(k + 1), así que f nc no puede ser de orden O(n).
Ahora supongamos que fnc es de complejidad O(n2) y sea m el numero de
operaciones que realiza f nc(n), entonces f nc(2 ∗ n) realizará 4m operaciones,
f nc(4 ∗ n) realizará 16m segundos en ejecutarse. Si a k le asignamos un valor
mayor que m, por ejemplo (m+1), entonces podemos ver que (m+1)n2 siem-
pre será mayor que f nc(n), con esto queda demostrado que la complejidad
de fnc es O(n2).
Código 8.8: Función suma_modular
1 int suma_modular ( int n ) {
2 int i , r =0;
3 for ( i =0; i <n %100; i ++){
4 r+=i ;
5 }
6 }

-- 107 of 315 --

108 CAPÍTULO 8. ANÁLISIS DE COMPLEJIDAD
Problema Resuelto 8.5.2. Analiza la complejidad de suma_modular. Uti-
liza la notación O-mayúscula.
Solución Como podemos ver, el ciclo for siempre itera menos de 100 veces,
y en cada iteración se realizan siempre el mismo número de operaciones sin
importar el valor de n.
Sea C el número de operaciones que se realizan en cada iteración, D el
número de operaciones requeridas para llamar a la función y para regresar un
valor, podemos darnos cuenta que CD + 1 siempre será mayor que el numero
de operaciones que realiza suma_modular, y además CD + 1 es constante,
por lo tanto el tiempo de ejecución de suma_modular crece en O(1).
8.6. Múltiples Complejidades en Notación O-
Mayúscula
Podrías estarte preguntando, ¾f nc no será también de orden O(n3) o de
orden O(n2 + n) o de orden O(n4), etc... ?
La respuesta a esta pregunta es que sí, si un algoritmo tiene una com-
plejidad O(g(n)) también se puede decir que ese algoritmo es de cualquier
complejidad mayor a O(g(n)) solo que por practicidad se suele tomar la fun-
ción de crecimiento más pequeña que se conozca del algoritmo.
8.7. Cuándo Un Algoritmo es Factible y Cuán-
do Buscar Otro
Ya vimos lo qué es la notación O-mayúscula pero aún no se habla del tema
de cómo saber si un algoritmo de cierta complejidad resuelve el problema.
Una computadora con 1,5Ghz en un segundo realiza poco mas de 200
millones de sumas. Puede ser un buen punto de referencia saber eso, pero
está claro que una iteración por lo general consiste de mas operaciones que
una sola suma por este motivo es necesario conocer en qué tamaños de las
entradas suelen funcionar los algoritmos con diferentes complejidades.
En la siguiente tabla se muestran varias complejidades y valores máx-
imos de n que suelen ser los indicados en la mayoría de los problemas de
programación si se requiere que el programa funcione en menos de un se-
gundo(esto se puede extrapolar para tiempos mayores con sencillos cálculos
algebráricos).

-- 108 of 315 --

8.7. CUÁNDO UN ALGORITMO ES FACTIBLE Y CUÁNDO BUSCAR OTRO109
También existen algoritmos en los que cada iteración requiere de muchas
operaciones y el valor máximo de n debe de ser más pequeño; pero con esos
casos especiales solamente se aprende a lidiar por medio de la experiencia.
Tabla de Complejidades
Complejidad Valor Máximo de n
O(1) ∞
O(logn) 250000000
O(√n) 1015
O(n) 50000000
O(nlogn) 5000000
O(n2) 5000
O(n3) 500
O(n4) 80
O(2n) 20
O(n!) 11

-- 109 of 315 --

110 CAPÍTULO 8. ANÁLISIS DE COMPLEJIDAD

-- 110 of 315 --

Cap´ıtulo 9
Reglas para Medir la Complejidad
Aunque comience a parecer algo tedioso calcular las complejidades de
los algoritmos, es fácil en la mayoría de los casos, ya que existen ciertas
técnicas usadas para calcular la complejidad de los algoritmos, las cuales
descubriremos en las próximas páginas.
Cuando decimos que un algoritmo A es de complejidad O(f (n)) nos refe-
rimos a que si T (n) es la función del tiempo que tarda en ejecutarse el
algoritmo A con una entrada de tamaño n entonces la complejidad de la
función T (n) es la misma que la de la función f (n), o dicho de otra forma
O(T (n)) = O(f (n)).
9.1. Regla de la Suma
La primera de las reglas para calcular complejidad es la regla de la
suma(no debe confundirse con la regla combinatoria de la suma). Esta regla
implica que al ejecutar dos algoritmos diferentes, uno después del otro, la
complejidad de ejecutar ambos algoritmos será igual a la complejidad de
ejecutar el algoritmo mas lento de ellos.
De una manera mas precisa, si el tiempo para ejecutar un algoritmo es
n → T (n) + T ′(n) entonces su complejidad es O(max(T (n), T ′(n))), o bien
O(T (n) + T ′(n)) = O(max(T (n), T ′(n))).
Esta regla a primera vista puede causar escepticismo y a veces negación
a usarse, pero basta con ver que los valores de f (x) = x3 + 3x3 + 100 y de
g(x) = x3 se vuelven casi iguales conforme crece x. Por ejemplo:
f (1000) = 1003000100
g(1000) = 1000000000
111

-- 111 of 315 --

112 CAPÍTULO 9. REGLAS PARA MEDIR LA COMPLEJIDAD
Por ello, si un algoritmo que realiza g(n) operaciones tarda 10 segundos
en ejecutarse cuando n = 1000, un algoritmo que realize f (n) operaciones
tardaría 10,03 segundos.
Aunque después de haber visto el ejemplo anterior puedas entender un
poco la razón de la regla de la suma, es conveniente conocer su demostración
para estar seguros que realmente se aplica a la notación que denimos como
O− mayúscula.
Teorema 11 (Regla de la suma). Si una función a es de complejidad O(f (n))
y una función b es de complejidad O(g(n)) la complejidad de a+b es O(max(f (n), g(n))).
O dicho de otra forma O(f (n) + g(n)) = O(max(f (n), g(n)))
Demostración. Sin perder la generalidad supongamos que f (m) ≥ g(m) para
alguna m.
Por denición existen dos constantes J y K tal que
Jf (n) > a(n)
Kg(n) > b(n)
y J > K para toda n
En consecuencia tenemos que
Jf (m) + Jf (m) ≥ Jf (m) + Kg(m) > a(m) + b(m)
2Jf (m) > a(m) + b(m)
Análogamente, si g(m) ≥ f (m) entonces existe J tal que 2Jg(m) >
a(m) + b(m).
Como J es constante, entonces podemos concluir que O(f (n) + g(n)) =
O(max(f (n), g(n))).
Dado que trabajamos con funciones de tiempo creciente, lo mas frecuente
sería encontrarnos con que O(f (n) + g(n)) es o bien O(f (n)) o bien O(g(n)).
Es decir, f (n) ≤ g(n) para toda n ó f (n) ≥ g(n) para toda n.
Pero no siempre es así, puede haber valores de n para los cuales f (n) >
g(n) y valores de n para los cuales f (n) < g(n). Por lo tanto, no siempre
nos salvaremos de expresar una complejidad de la forma O(f (n) + g(n)),
un ejemplo de esto son los algoritmos de búsqueda que se analizarán al nal
de la parte IV.

-- 112 of 315 --

9.1. REGLA DE LA SUMA 113
Código 9.1: Función burbuja
Problema Resuelto 9.1.1 (Complejidad del Algoritmo Burbuja).
1 void burbuja ( int a r r e g l o [ ] , int n ) {
2 int i , k ;
3 for ( i =0; i <n ; i ++){
4 for ( k=0;k+1<n ; k++)
5 i f ( a r r e g l o [ k]< a r r e g l o [ k +1])
6 swap ( a r r e g l o [ k ] ,
a r r e g l o [ k +1]) ;
7 }
8 for ( i =0, k=n ; i >k ; i ++,k−−)
9 swap ( a r r e g l o [ i ] , a r r e g l o [ k ] ) ;
10 return ;
11 }
Mide la complejidad de la función burbuja implementada en el código
anterior. Utiliza la notación O-mayúscula.
Solución El for de la línea 3 itera n veces, por cada iteración del for de
la línea 3, el for de la línea 4 itera n − 1 veces, por lo tanto, el número de
veces que se ejecuta la línea 5 es (n)(n − 1) y el número de intercambios que
se realizan en la línea 6 nunca es mayor a (n)(n − 1).
Luego, el número de operaciones cada vez que itera el for de la línea 4 es
menor o igual que:
2(n)(n − 1) = 2n2 − 2n
Nótese que 2n2 > 2n2 − 2n para cualquier valor de n positivo, por lo que
el tiempo de ejecución desde la línea 3 hasta la línea 7 es de orden O(n2), o
dicho de otra manera, cuadrático.
El for de la línea 8 itera n
2 veces, y el número de intercambios que se
realizan también es n
2 , eso signica que cada una de las n
2 iteraciones realiza
el mismo número de operaciones, dicho número de operaciones lo vamos a
denotar como m.
Por ello, el número de operaciones que se ejecutan entre las líneas 8 y 9
es:
mn
2 = m
2 n
Dado que m
2 es una constante(es fácil ver que existe una cantidad de tiem-
po constante que siempre será mayor que el tiempo que tarden en ejecutarse

-- 113 of 315 --

114 CAPÍTULO 9. REGLAS PARA MEDIR LA COMPLEJIDAD
m
2 operaciones), el tiempo de ejecución de las líneas 8 y 9 es de complejidad
O(n).
Como primero se ejecuta un algoritmo de O(n2) (líneas 1 a 7) y posteri-
ormente se ejecuta un algoritmo de O(n) (líneas 8 y 9), por regla de la suma,
el tiempo de ejecución es de complejidad O(max(n, n2)) = O(n2).
9.2. Producto por Constante
La siguiente regla es un tanto obvia, pero no por eso se debe despreciar.
La regla dice que si dos funciones T y t son tales que T (n) = Kt(n)
para alguna constante K, entonces su complejidad es la misma, es decir
O(T (n)) = O(t(n)).
Teorema 12. Si una función f (n) = Kt(n) donde K es una constante, la
complejidad de f es la misma que la de t, dicho de otra manera O(Kf (n)) =
O(f (n)) para cualquier constante K.
Demostración. Sean t y f funciones tales que la complejidad de t es O(f (n)),
por denición existe una constante K′ tal que K′f (n) > t(n) para toda n,
multiplicando ambos lados de la desigualdad por la constante no negativa K,
tenemos que (K)(K′)f (n) > (K)t(n).
Como (K)(K′) es constante, entonces O(Kf (n)) = O(f (n)).
9.3. Regla del Producto
Considera el siguiente código:
Código 9.2: f y g
1 int f ( int n ) {
2 int i , r =0;
3 for ( i =1; i<=n ; i ++){
4 r+=n ;
5 }
6 return r ;
7 }
8 int g ( int n ) {
9 int i , k , r =0;
10 for ( k=1;k<=n ; k++){
11 for ( i =1; i<=n ; i ++){

-- 114 of 315 --

9.4. COMPLEJIDAD EN POLINOMIOS 115
12 r+=f ( k ) ∗ f ( i ) ;
13 }
14 }
15 return r ;
16 }
Intentar calcular el número exacto de iteraciones que se realizan en la
función anterior es algo muy difícil, pero a la vez si analizaramos el número
de veces que la función g manda a llamar a la función f en lugar del tiempo
que tarda en ejecutarse la función g, nos daremos cuenta que ese número se
calcula con la función v(n) = 2n2 la cual es una función de órden O(n2).
Vamos a denotar n como la entrada de f y n′ como la entrada de g,
recordando que el número de llamadas a f desde g es de órden O(n′2) y la
complejidad de f es O(n), por denición es posible elegir 2 constantes K y
K′ tales que:
Kn2 > 2n2 y K′n′ > n′ (9.1)
Por la ecuación anterior podemos concluir que:
Kn2K′n′ > 2n2n′ (9.2)
Recordando que n′ ≤ n, y por la ecuación anterior
Kn2(K′n) ≥ Kn2K′n′ > 2n2n′
(K)(K′)n3 ≥ Kn2K′n′ > 2n2n′
(K)(K′)n3 > 2n2n′
De ésto se puede concluir que g funciona en un tiempo de orden O(n3).
De manera análoga se puede demostrar que si g(n) = f (n)f ′(n) entonces
g es de órden O(f (n)f ′(n)).
Teorema 13 (Regla del Producto). Sea g(x) = f (x)f ′(x), la complejidad de
g es igual al producto de las complejidades de f y f ′.
9.4. Complejidad en Polinomios
Considera el siguiente código:
1 for ( i=N; i >=0; i −−) { }
2 for ( i =0; i <N; i ++){
3 for ( k=2;k<N; k++){
4 for ( h=0;h<N; h+=5) ;

-- 115 of 315 --

116 CAPÍTULO 9. REGLAS PARA MEDIR LA COMPLEJIDAD
5 }
6 for ( k=0;k<N%128;k++) { }
7 }
El número de veces que itera el for de la línea 2 es N , el número de veces
que itera el for de la línea 3 es N (N − 2), el número de veces que itera el for
de la línea 4 es (N )(N − 2)(N/5), el número de veces que itera el for de la
línea 6 es N mod128, y el número de veces que itera el for de la línea 1esN .
Por tanto el número total de iteraciones es:
N +N (N −2)+N (N −2)(N/5)+N mod128+N = (1/5)N 3+(3/5)N 2+N +N mod128
Aplicando la regla de la suma sabemos que:
O((1/5)N 3+(3/5)N 2+N +N mod128) = O(max(O((1/5)N 3), O((3/5)N 2), O(N ), O(N mod128
Aplicando la regla del producto por constante tenemos que:
O((1/5)N 3 + (3/5)N 2 + N + N mod128) = O(max(N 3, N 2, N, 1)) = O(N 3)
Como te habrás dado cuenta, en cualquier algoritmo cuyo tiempo de
ejecución se pueda representar mediante un polinomio, lo único que hay que
hacer es tomar el término con mayor exponente de la variable y olvidarse del
coeciente.
Y si eres un poco más observador, te podrás dar cuenta que ni siquiera
es necesario expandir el polinomio. Es decir:
O(N +N (N −2)+N (N −2)(N/5)+N mod128+N ) = O(N +N (N )+N (N )(N )+1+N )
Las constantes se pueden ignorar, y de esa manera se vuelve trivial dado
un polinomio encontrar su complejidad. Se deja como ejercicio para el lector
comprobar que esto se puede hacer con cualquier polinomio.
9.5. Medir antes de implementar
En el capítulo anterior se planteó el objetivo de cómo saber si un algoritmo
es rápido sin necesidad de implementarlo. Y hasta este momento solamente
nos hemos dedicado a analizar la complejidad de implementaciones.
Sin embargo, ya tenemos las herramientas sucientes para poder analizar
la complejidad de muchos algoritmos sin necesidad de su implementación;

-- 116 of 315 --

9.5. MEDIR ANTES DE IMPLEMENTAR 117
para lograr esto simplemente hay que examinar qué ciclos posee el algoritmo
y cuáles de esos ciclos estan uno dentro de el otro.
Una vez identicados los ciclos, hay que estimar cual es el número máximo
de veces que se puede ejecutar cada uno, ignorando las constantes, obteniendo
así un polinomio.
Luego de eso simplemente hay que tomar el término del polinomio con
exponente mayor.
Los siguientes ejemplos ilustran un poco esta técnica
Problema Resuelto 9.5.1. Analiza la complejidad del algoritmo para en-
contrar el máximo elemento de un arreglo A con n elementos de la siguiente
manera:
Para cada elemento i del arreglo A, verica que i sea mayor que todos los
demas elementos de a, si se cumple i será el máximo.
Solución Para saber si un elemento i es el máximo, el algoritmo verica
que a > k para todo k ∈ A tal que k 6 = i, como hay n valores posibles de
A, entonces esta operación hay que realizarla n − 1 veces, eso es complejidad
O(n).
Y como hay que vericar n elementos distintos y cada elemento toma un
tiempo de O(n) vericarlo, la complejidad es O(n2).

Problema Resuelto 9.5.2. Analiza la complejidad del algoritmo para en-
contrar el máximo elemento de un arreglo A con n elementos de la siguiente
manera:
Primero se inicializa una variable maximo con valor −∞
Para cada elemento i del arreglo A, si el valor de maximo es menor que
el valor de i entonces se sustituye el valor de maximo por el valor de i.
Solución Inicializar el valor de maximo toma tiempo O(1), comparar el
valor de maximo con el valor de alguna i tambien toma tiempo O(1), pero
hay que hacer dicha comparación n veces, por lo tanto el algoritmo es O(n).

A pesar de que ya no se requiere un código fuente para analizar los algorit-
mos, en este libro se seguirán usando, debido a que describir los algoritmos en
español puede resultar confuso, y no vale la pena explicar un pseudocódigo.

-- 117 of 315 --

118 CAPÍTULO 9. REGLAS PARA MEDIR LA COMPLEJIDAD
9.6. Búsqueda de Cotas Mayores
Aunque la mayoría de veces este proceso es sencillo hay veces en las que
no es fácil ver cuantas veces se ejecuta un ciclo aún si se ignoran las con-
stantes, pero para analizar esos casos lo mas conveniente a hacer es elegir una
cota máxima y obtener cierta complejidad aún cuando no sea la complejidad
menor del algoritmo ó encontrar una propiedad en el algoritmo que permita
determinar cuántas veces se ejecuta(para lo cual no hay una regla general).
Código 9.3: Función cuatro_cuadrados
1 int cuatro_cuadrados ( int n ) {
2 int a , b , c , d ;
3 int r =0;
4 for ( a =0; a∗a<=n ; a++){
5 for ( b=a ; a∗a+b∗b<=n ; b++){
6 for ( c=b ; a∗a+b∗b+c ∗c<=n ; c++){
7 for ( d=c ; a∗a+b∗b+c ∗ c+d∗d
<=n ; d++){
8 i f ( a∗a+b∗b+c ∗ c+d
∗d==n ) {
9 r++;
10 }
11 }
12 }
13 }
14 }
15 return r ;
16 }
Por ejemplo en el código 9.3 resulta extremadamente difícil darse cuenta
cuantas veces itera cada ciclo, excepto el exterior que itera √n veces, en
los siguientes ciclos solamente es posible darse cuenta que pueden iterar √n
veces pero la mayoría de ocaciones iteran menos.
En este caso se puede decir que n2 es una cota mayor al total de itera-
ciones en la función cuatro_cuadrados.
Asi que, por regla del producto podemos saber que la función cuatro_cuadrados
itera menos de √n4 = n2 veces, lo que signica que si T (n) es el número total
de iteraciones.
n2 > T (n)

-- 118 of 315 --

9.6. BÚSQUEDA DE COTAS MAYORES 119
Sea K una consante tal que cada iteración realiza menos de K opera-
ciones, entonces:
T (n) < K(n2)
Por lo tanto, podemos decir que la función cuatro_cuadrados corre en
tiempo O(n2) nótese que n2 es una cota superior, por lo cual puede ser
posible que O(n2) no sea la menor complejidad de T que se puede hayar.
Al medir complejidades muchas veces es útil usar cotas mayores, ya que
esto asegura que el algoritmo va a funcionar en un tiempo menor al calculado
usando la cota mayor y eso a veces es suciente para saber que el algoritmo
va a funcionar dentro de las condiciones que se piden en el problema.

-- 119 of 315 --

120 CAPÍTULO 9. REGLAS PARA MEDIR LA COMPLEJIDAD

-- 120 of 315 --

Cap´ıtulo 10
Complejidades Logarítmicas
En el capítulo anterior se estudiaron múltiples complejidades de la forma
O(nk) y se mostró como gran cantidad de algoritmos corren en tiempos que
se pueden expresar como un polinomio y como toda función polinomial tiene
una complejidad de la forma O(nk) donde k es una constante.
Otro tipo de complejidades importantes son las complejidades O(log n),
aunque suene extraño usar logaritmos en el conteo del número de operaciones,
este tipo de complejidades aparecen de una manera muy frecuente.
Cabe mencionar que en los algoritmos, suelen ser mas importantes los
logaritmos base 2 que los logaritmos naturales.
10.1. Análisis de la Búsqueda Binaria
El primer algoritmo que veremos con esta complejidad es uno que ya se
mencionó en la Parte I, sin embargo nunca se analizó su complejidad.
1 int Busqueda_Binaria ( int v [ ] , int a , int b , int x ) {
2 while ( a<b )
3 i f ( v [ ( a+b ) /2]==x ) {
4 return ( a+b ) / 2 ;
5 } e l s e i f ( v [ ( a+b ) /2] <x ) {
6 a=(a+b ) /2+1;
7 } e l s e {
8 b=(a+b ) /2 −1;
9 }
10 i f ( v [ a]==x ) {
11 return a ;
12 } e l s e {
121

-- 121 of 315 --

122 CAPÍTULO 10. COMPLEJIDADES LOGARÍTMICAS
13 return −1;
14 }
15 }
Problema Resuelto 10.1.1. Analiza la complejidad de la búsqueda binaria,
utiliza la notación O mayúscula.
Solución Todas las iteraciones de este algoritmo ejecutan la línea 3, y las
iteraciones se ejecutan mientras no se haya encontrado un v[(a+b)
2 ] = x y
mientras a sea menor que b.
Para conocer el número de iteraciones primero debemos estar seguros de
que este código realmente termina y no se queda en un bucle innito.
Es posible que en v no exista ningún valor igual a x, pero, ¾Será posi-
ble que se mantenga indenidamente la condición a < b? en seguida de-
mostraremos que esto último no es posible:
Si a < b entonces b − a > 0
Vamos a llamar a′ y b′ a los valores que tomarán a y b en la siguiente
iteración. En cada una de las iteraciones ocurre alguna de estas 2 cosas:
a′ = a+b
2 + 1 ó bien b′ = a+b
2 − 1
Por tanto:
b′ − a′ = b − a + b
2 − 1
b′ − a′ = b − a
2 − b
2 − 1 − (a + b)mod2
b′ − a′ = d b
2e − ba
2 c − 1 − (a + b)mod2
d b
2e − ba
2 c − 1 − (a + b)mod2 < bb − a
2 c
b′ − a′ < bb − a
2 c
o bien
b′ − a′ = a + b
2 − 1 − a
b′ − a′ = a
2 + b
2 + amod2 − 1 − a
a
2 + b
2 + amod2 − 1 − a < bb − a
2 c
b′ − a′ < bb − a
2 c

-- 122 of 315 --

10.2. BASES DE LOGARITMOS 123
Con lo anterior podemos darnos cuenta que luego de cada iteración a−b se
reduce a la mitad o menos. Cuando se trata de números reales, ésta situación
puede continuar por un tiempo indenido, pero cuando se trata de números
enteros, después de cierto número de operaciones se llegará a la situación
inevitable de que a = b.
Es fácil de darse cuenta que si inicialmente b − a = 2n, entonces el algo-
ritmo terminará en el peor caso después de n iteraciones, es decir después de
log2(n) iteraciones.
También es fácil probar por inducción que si x no está en v, busqueda_binaria(v, a, b, x)
tarda igual o menos tiempo que busqueda_binaria(v, a, b + 1, x).
Por lo tanto, busqueda_binaria(v, 0, n, x) no tardará mas que busqueda_binaria(v, 0, m, x)
donde m es la menor potencia de 2 tal que n ≤ m.
Con esto concluimos que la complejidad de la búsqueda binaria es O(log n).

10.2. Bases de logaritmos
Resulta curioso nunca ver las bases de los logaritmos en las compleji-
dades, esto se debe a que todos los logartimos tienen exactamente la misma
complejidad.
Teorema 14. O(logk f (n)) = O(logh f (n)) para cualquier función f y cua-
lesquiera dos números reales k y h.
Demostración. Usando las leyes de los logaritmos sabemos que logk x = ln x
ln k
para cualquier x y que logk x = ln x
ln h para cualquier x.
Sea K = max(ln h, ln k) tenemos que:
K(ln f (n)) ≥ logk f (n)
y además
K(ln f (n)) ≥ logh f (n)
Con esto probamos que O(logm f (n)) = O(ln f (n)) sin importar cual
sea el valor de m, esto quiere decir que todos los logaritmos tienen la misma
complejidad.

-- 123 of 315 --

124 CAPÍTULO 10. COMPLEJIDADES LOGARÍTMICAS
10.3. Complejidades O(N logN )
A diferencia de la búsqueda binaria, la siguiente función no tiene una
aplicación practica, sin embargo, pronto veremos que su complejidad aparece
de una manera muy natural el gran cantidad de algoritmos:
1 void funcion_nlogn ( int n ) {
2 int i=n , k ;
3 while ( i >0){
4 i /=2;
5 for ( k=0;k<n ; k++){ }
6 }
7 }
Problema Resuelto 10.3.1. Analiza la complejidad de f uncion_nlogn.
Utiliza la notación O mayúscula.
Solución Tenemos que el while itera no mas de logn + 1 veces, y que el
for itera n veces por cada iteración del while.
Por regla del producto tenemos que la complejidad de f uncion_nlogn es
O((logn + 1)(n)) = O(O(logn)O(n)) = O(nlogn). .
Puede parecer extraña la complejidad O(nlogn) pero mas tarde nos dare-
mos cuenta que es bastante común en el ordenamiento.

-- 124 of 315 --

Cap´ıtulo 11
Complejidades en Funciones Recursivas
Las funciones recursivas presentan mas problemas para analizarse que las
funciones iterativas, ya que, a diferencia de las funciones iterativas, no es
posible saber exactamente cuántos ciclos se anidan.
En la Parte I se muestra la búsqueda binaria recursiva y unas páginas
atrás se demostró que la complejidad de la búsqueda binaria es logarítmica,
ese puede ser un ejemplo de cómo un algoritmo recursivo puede ser notable-
mente rápido, sin embargo, en la Parte I se mostró que la función recursiva
de bonacci crece muy rápido, por lo que los algoritmos recursivos también
pueden ser notablemente lentos.
Pero al usar recursión con memoria, vimos como se puede mejorar de
manera considerable la velocidad del algoritmo recursivo para calcular los
números de bonacci.
Por otro lado, resultaría casi imposible simular mentalmente un algoritmo
recursivo con el n de determinar qué tan rápido es.
11.1. Estados
El concepto de estado es un concepto que cobrará mucha importancia
mas adelante, pero por el momento lo veremos de una manera supercial.
A medida que se ejecuta un algoritmo, los valores de las variables o de
los arreglos pueden variar, vamos a llamar estado a un conjunto de valores
que pueden tener determinadas variables. Puede haber muchos puntos de
referencia para determinar los estados.
Por ejemplo, en el código 9.3, podemos decir que los estados son todos los
conjuntos de valores de las variables a, b, c y d, o bien tambien podriamos
decir que los estados son todos los conjuntos de valores de las variables a, b
125

-- 125 of 315 --

126 CAPÍTULO 11. COMPLEJIDADES EN FUNCIONES RECURSIVAS
y r, etc.
Para medir adecuadamente la complejidad es necesario elegir un conjunto
de estados de manera que el programa tarde un tiempo acotable en cambiar
de un estado a otro.
La idea es medir la complejidad del algoritmo en un estado, y luego mul-
tiplicar esa complejidad por el número de estados; y así no será necesario
simular mentalmente la recursión.
El siguiente ejemplo ayudará a comprender mejor lo que se pretende hacer
con denir estados:
1 int A r r e g l o [ 3 0 ] ;
2 void b i n a r i o ( int n ) {
3 i f ( n==0){
4 p r o c e s a ( A r r e g l o ) ;
5 } e l s e {
6 A r r e g l o [ n ] = 0 ;
7 b i n a r i o ( n−1) ;
8 A r r e g l o [ n ] = 1 ;
9 b i n a r i o ( n−1) ;
10 }
11 }
Problema Resuelto 11.1.1. Analiza la complejidad de binario en el código
anterior.
Solución Vamos a tomar como los estados a todos los posibles valores de
n y los primeros n números del arreglo Arreglo.
De lo cual nos resulta que el número de estados es la cantidad de cadenas
de 1 bit más la cantidad de cadenas de 2 bits, más la cantidad de cadenas de
3 bits, ..., más la cantidad de cadenas de n bits.
Por regla del producto sabemos que esto es:
21 + 22 + ... + 2n (11.1)
Lo cual, por la ecuación 4.1 sabemos que es:
2n+1 − 1 (11.2)
De esta manera hay un total de 2n+1 − 1 estados, y el programa tarda un
tiempo constante en cambiar de un estado a otro, por lo tanto la complejidad
es O(2n). 

-- 126 of 315 --

11.2. CORTES 127
1 void d f s ( int a ) {
2 int i ;
3 i f ( a<0 | | a>=N)
4 return ;
5 V[ a]= t r u e ;
6 for ( i =0; i <n ; i ++){
7 i f (Mat [ a ] [ i ] && !V[ i ] ) {
8 d f s ( Mat [ a ] [ i ] ) ;
9 }
10 }
11 }
Problema Resuelto 11.1.2. Analiza la complejidad de dfs en el código
anterior.
Solución Podemos darnos cuenta que si a < 0 ó a ≥ n entonces el progra-
ma terminaría en un número constante de pasos. Retomando nuestra acti-
tud pesimista vamos a asumir que a solamente puede tener valores entre 0
y n − 1, y además, vamos a utilizar el conjunto de posibles valores de a como
los estados.
Debido a que df s(x) es llamado a lo mas una vez para cada x, podemos
alegremente ignorar la recursión y solo contar el tiempo utilizado por el
programa durante la ejecución de df s(x)(sin contar las llamadas recursivas)
para cada x.
El tiempo que tarda en ejecutarse df s(x) para alguna x y sin contar las
llamadas recursivas es de complejidad O(n); y como x puede tener hasta n
valores diferentes la complejidad es O(n2).
11.2. Cortes
Muchas veces, al hacer llamadas recursivas un problema se divide en prob-
lemas mas pequeños, tal como se vió en el capítulo de Divide y Vencerás,
cuando esto sucede, frecuentemente un estado mas pequeño se procesa más
rápido que un estado mas grande y las cosas se complican bastante.
Considere, por ejemplo, el siguiente código.
1 int suma_dummy( int a , int b ) {
2 int i , r =0;
3 i f ( a<=b )
4 return 0 ;
5 for ( i=a ; i <b ; i ++){

-- 127 of 315 --

128 CAPÍTULO 11. COMPLEJIDADES EN FUNCIONES RECURSIVAS
6 r++;
7 }
8 r+=suma_dummy( a , ( a+b ) /2) ) ;
9 r+=suma_dummy ( ( a+b ) / 2 , b ) ) ;
10 return r ;
11 }
Problema Resuelto 11.2.1. Analiza la complejidad de suma_dummy
Solución Vamos a denotar suma_dummy(a, b) como el tiempo en que
tarda en ejecutarse dicha función.
Es obvio que O(suma_dummy(a, b)) = O(b − a + sumadummy(a, a+b
2 ) +
suma_dummy(a+b
2 , b)) cuando a > b y que O(suma_dummy(a, b)) = O(1)
cuando a <= b, sin embargo, expresar la complejidad de manera recursiva
no parece ser una buena idea.
Para resolver esta problemática hay que tomar en cuenta el hecho de
O(suma_dummy(a, b)) = O(suma_dummy(a + c, b + c)) para cualesquiera
a, b y c.
Esto no es muy fácil de admitir, sin embargo, se justica al ver que el
número de iteraciones del ciclo for solamente depende de la diferencia entre
a y b, lo mismo la condición de retorno.
Sin embargo, hay un par de líneas donde si parece afectar:
1 r+=suma_dummy( a , ( a+b ) /2) ) ;
2 r+=suma_dummy ( ( a+b ) / 2 , b ) ) ;
Pero, esta problematica se resuelve rápidamente:
ba + b + 2c
2 c − (a + c) = ba + b
2 c + c − a − c = ba + b
2 c − a
Analogamente b − ba + bc = b + c − ba + b + 2cc.
Una vez admitido que O(suma_dummy(a, b)) = O(suma_dummy(a +
c, b+c)), vamos a utilizar la expresión T (n) como el tiempo que tarda en ejecu-
tarse suma_dummy(0, n), de esa manera O(T (b−a)) = O(suma_dummy(a, b)).
Lo interesante aquí es que O(T (n)) = O(n + 2T (dn
2 e)).
Para un análisis supericial, tomemos las potencias de 2 y veamos que
sucede con O(T (n)) cuando n es una potencia de 2.
Además utilizaremos la letra k para designar una constante de tiempo
grande.
T (1) ≤ k
T (2) ≤ 2k + 2k = 2(2k) = 4k

-- 128 of 315 --

11.2. CORTES 129
T (4) ≤ 4k + 2(2k + 2k) = 3(4k) = 12k
T (8) ≤ 8k + 2(12k) = 4(8k) = 32k
T (16) ≤ 16k + 2(32k) = 5(16k) = 80k
Utilizando inducción es fácil conrmar que T (2n) ≤ k(2n)(n + 1). Puesto
que T (1) ≤ k y T (2n) ≤ k(2n)(n + 1) implica que T (2n+1) ≤ 2n+1k +
2k(2n)(n + 1) = k(2n+1 + 2n+1(n + 1) = k(2n+1)(n + 2)
Ahora, recordando que T (n) ≤ T (n + 1) para todo n, tenemos que:
T (n) ≤ T (2dlog2ne) (11.3)
≤ K(2dlog2ne)(dlog2ne + 1) (11.4)
≤ K(n + 1)(dlog2ne + 1) (11.5)
Por lo tanto, la complejidad de suma_dummy es O(nlog2n).
Hay que hacer notar que en el análisis de complejidad no importa la
base del logaritmo, ya que logab = lnb
lna . Por lo que decir que un algorit-
mo es de complejidad O(nlog2n) es lo mismo que decir que es de comple-
jidad O( 1
ln2 (nlog2n)). Y como ln2 es una constante entonces O(nlog2n) =
O(n ln n).

Nuevamente nos encontramos con una complejidad O(n log n). Como se
había dicho anteriormente, esta complejidad aparece mucho en los algoritmos
de ordenamiento. Pero no solamente aparece en esos algoritmos, sino que
aparece por lo general en algoritmos que requieren realizar cortes.
Generalizando el ejemplo anterior, si K y M son constantes, un algoritmo
basado en la estrategia divide y vencerás requiere un tiempo O(1) procesar
una entrada de tamaño ≤ K y requiere un tiempo O(n) dividir una entrada
tamaño n > K en M entradas de tamaño n
M , la complejidad del algoritmo
es O(n logM n).
La demostración de esta propiedad es análoga al análisis de complejidad
de la función suma_dummy. Se deja como ejercicio para el lector.

-- 129 of 315 --

130 CAPÍTULO 11. COMPLEJIDADES EN FUNCIONES RECURSIVAS

-- 130 of 315 --