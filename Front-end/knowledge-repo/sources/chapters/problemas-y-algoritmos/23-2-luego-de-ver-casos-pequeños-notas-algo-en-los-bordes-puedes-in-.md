# 2. Luego de ver casos pequeños, ¾Notas algo en los bordes?, ¾Puedes in-

tercambiar algunos colores para lograr juntar los tableros como en el
inciso anterior?.
Chocolate
¾Qué sucede si en lugar de buscar cómo cortar el chocolate supones que
el chocolate ya está cortado y quieres unir las piezas con un procedimiento
similar?, ¾en qué cambia el problema?

-- 33 of 315 --

34 CAPÍTULO 1. INDUCCIÓN MATEMÁTICA

-- 34 of 315 --

Cap´ıtulo 2
Denición y Características de la
Recursión
Ya vimos con la inducción que a veces una proposición se puede vericar
en su forma más simple y luego probar que si se cumple para una de cierta
complejidad también se cumplirá para otra con más complejidad.
Ahora, la recursividad o recursión se trata de algo parecido, se trata de
denir explícitamente la forma más simple de un proceso y denir las formas
mas complejas de dicho proceso en base a formas un poco más simples. Es
decir:
Denición 2.0.1 (Recursión). Forma de denir un objeto o un proceso
deniendo explícitamente su forma mas simple, y deniendo sus formas mas
complejas con respecto a formas mas simples.
Veremos cual es la utilidad de este tipo de deniciones con los siguientes
ejemplos:
2.1. Factorial
n! se lee como ene factorial y
n! = (1)(1)(2)(3)(4)(5)...(n − 1)(n)
Por ejemplo 5! = (1)(1)(2)(3)(4)(5) = 120 y se lee como cinco factorial
Pero puede parecer incómodo para una denición seria tener que usar los
puntos suspensivos(...) y depender de cómo la interprete el lector.
Por ello, vamos a convertir esa denición en una denición recursiva.
La forma mas simple de la función factorial es:
0! = 1
35

-- 35 of 315 --

36CAPÍTULO 2. DEFINICIÓN Y CARACTERÍSTICAS DE LA RECURSIÓN
Y ahora, teniendo n!, ¾Cómo obtenemos (n+1)! ?, simplemente multiplicando
n! por n + 1.
(n + 1)! = (n!)(n + 1)
De esta forma especicamos cada que se tenga un número, cómo obtener el
siguiente y la denición queda completa, ésta ya es una denición recursiva,
sin embargo, se ve un tanto sucia, puesto que dene a (n + 1)! en términos
de n!. Y para ir más de acuerdo con la idea de la recursividad hay que denir
n! en términos de (n − 1)!.
Así que, teniendo (n − 1)!, para obtener n! hay que multiplicar por n. De
esa forma nuestra denición recursiva queda así:
Denición 2.1.1 (Factorial).
0! = 1
n! = (n − 1)!n
Al igual que las matemáticas, una computadora también soporta fun-
ciones recursivas, por ejemplo, la función factorial que acaba de ser denida
puede ser implementada en lenguaje C de la siguiente manera:
Código 2.1: Función recursiva factorial
1 int f a c t o r i a l ( int n ) {
2 i f ( n == 0) return 1 ;
3 e l s e return f a c t o r i a l ( n−1)∗n ;
4 }
Para los estudiantes de programación que comienzan a ver recursión suele
causar confusión ver una función denida en términos de sí misma. Suele
causar la impresión de ser una denición cíclica. Pero ya que construimos la
función paso a paso es posible que ello no le ocurra al lector.
De todas formas es buena idea ver cómo trabaja esta función en un depu-
rador o ir simulándola a mano.
Podemos notar algunas cosas interesantes:
Si llamamos a factorial(5), la primera vez que se llame a la función
factorial, n será igual a 5, la segunda vez n será igual a 4, la tercera
vez n será igual a 3, etc.
Después de que la función regresa el valor 1, n vuelve a tomar todos
los valores anteriores pero esta vez en el orden inverso al cual fueron
llamados, es decir, en lugar de que fuera 5, 4, 3, 2, 1, ahora n va
tomando los valores 1, 2, 3, 4, 5; conforme el programa va regresando
de la recursividad va multiplicando el valor de retorno por los distintos
valores de n.

-- 36 of 315 --

2.1. FACTORIAL 37
Cuando la función factorial regresa por primera vez 1, la computadora
recuerda los valores de n, entonces guarda dichos valores en algún lado.
La primera observación parece no tener importancia, pero combinada con la
segunda se vuelve una propiedad interesante que examinaremos después. La
tercera observación hace obvia la necesidad de una estructura para recordar
los valores de las variables cada que se hace una llamada a función.
Dicha estructura recibe el nombre de pila o stack. Y por el solo hecho
de contener información, la pila requiere memoria de la computadora y tiene
un límite de memoria a ocupar(varía mucho dependiendo del compilador
y/o sistema operativo), si dicho límite es superado, el programa terminará
abruptamente por acceso a un área restringida de la memoria, este error
recibe el nombre de desbordamiento de pila o stack overow.
A veces, al abordar un problema, es mejor no pensar en la pila dado que
el tamaño de la pila nunca crecerá mucho en ese problema; otras veces hay
que tener cuidado con eso; y en ocasiones, tener presente que la pila recuerda
todo puede ayudar a encontrar la solución a un problema.
Para observar mas claramente las propiedades mencionadas, conviene
echar un vistazo a esta versión modicada de la función factorial:
Código 2.2: Función recursiva factorial modicada
1 int f a c t o r i a l ( int n ) {
2 int fminus1 ;
3 p r i n t f ( " %d\n" , n ) ;
4 i f ( n == 0) return 1 ;
5 fminus1=f a c t o r i a l ( n−1) ;
6 p r i n t f ( " %d %d\n" , n , fminus1 ) ;
7 return fminus1 ∗n ;
8 }
Si llamas factorial(5) con el código de arriba obtendrás la siguiente
salida en pantalla:
5
4
3
2
1
0
1 1
2 1
3 2

-- 37 of 315 --

38CAPÍTULO 2. DEFINICIÓN Y CARACTERÍSTICAS DE LA RECURSIÓN
4 6
5 24
Allí se ve claramente cómo n toma los valores en el orden inverso cuando
va regresando de la recursividad, cómo la línea 3 se ejecuta 6 veces mientras
se van haciendo las llamadas recursivas y cómo la linea 6 se ejecuta ya se
hicieron todas las llamadas recursivas, no antes.
2.2. Imprimir Números en Binario
Con la función factorial ya vimos varias propiedades de las funciones
recursivas cuando se ejecutan dentro de una computadora.
Aunque siendo sinceros, es mucho mas práctico calcular el factorial uti-
lizando for que con una función recursiva.
Ahora, para comenzar a aprovechar algunas ventajas de la recursividad
se tratará el problema de imprimir números en binario, el cual es fácilmente
extendible a otras bases.
Cada vez que observemos un número con subíndice, vamos a interpretar
el subíndice como la base de numeración en la cual el número está escrito.
Por ejemplo 1012 signica el número binario 101, es decir, 5 en sistema
decimal.
Estos son los primeros números enteros positivos en sistema binario:
12, 102, 112, 1002, 1012, 1102, 1112, 10002, 10012, 10102, 10112, ...
Esto no debe causar confusión en el momento en el que veamos los sub-
índices para denotar sucesiones, por ejemplo x1, x2, x3, ..., xn, y esto es porque
en expresiones tales como x1, se tiene que x no está escrito en ninguna base.
Problema Resuelto 2.2.1. Escribe una función recursiva que imprima un
número entero positivo en su formato binario(no dejes ceros a la izquierda).
Solución La instancia mas simple de este proceso es un número binario
de un solo dígito(1 ó 0). Cuando haya mas de un dígito, hay que imprimir
primero los dígitos de la izquierda y luego los dígitos de la derecha.
También hay que hacer notar algunas propiedades de la numeración bi-
naria:
Si un número es par, termina en 0, si es impar termina en 1.
Por ejemplo 1012 = 5 y 1002 = 4
Si un número se divide entre 2(ignorando el residuo), el cociente se
escribe igual que el dividendo, simplemente sin el último dígito de la
derecha.

-- 38 of 315 --

2.3. LOS CONEJOS DE FIBONACCI 39
Por ejemplo 100110012
2 = 10011002
Tomando en cuenta todo lo anterior concluimos que si n < 2 entonces hay
que imprimir n, si no, hay que imprimir n/2 y luego imprimir 1 si n es impar
y 0 si n es par. Por lo tanto, la función recursiva quedaría de esta manera:
Código 2.3: Función recursiva que Imprime un Número Binario
1 void imprime_binario ( int n ) {
2 i f ( n>=2){
3 imprime_binario ( n /2) ;
4 p r i n t f ( " %d" , n %2) ;
5 } e l s e {
6 p r i n t f ( " %d" , n ) ;
7 }
8 }

Aquí vemos que esta función recursiva si supone una mejoría en la sencillez
con respecto a las posibles soluciones iterativas(no recursivas), ya que para
hacerlo iterativamente se necesitaría llenar un arreglo y en cada posición un
dígito, y luego recorrerlo en el orden inverso al que se llenó.
Pero hay que hacer notar que un proceso recursivo funciona ligeramente
mas lento que si se hiciera de manera iterativa. Esto es porque las operaciones
de añadir elementos a la pila y quitar elementos de la pila toman tiempo.
Por eso se concluye que la recursión hay que usarla cuando simplique
sustancialmente las cosas y valga la pena pagar el precio con un poco menos
de rendimiento.
2.3. Los Conejos de Fibonacci
Había una vez cierto matemático llamado Leonardo de Pisa, apodado
Fibonacci, que propuso el siguiente problema:
Problema Resuelto 2.3.1. Alguien compra una pareja de conejos(un ma-
cho y una hembra), luego de un mes de haber hecho la compra esos conejos
son adultos, después de dos meses de haber hecho la compra esa pareja de
conejos da a luz a otra pareja de conejos(un macho y una hembra), al tercer
mes, la primera pareja de conejos da a luz a otra pareja de conejos y al mismo
tiempo, sus primeros hijos se vuelven adultos.

-- 39 of 315 --

40CAPÍTULO 2. DEFINICIÓN Y CARACTERÍSTICAS DE LA RECURSIÓN
Figura 2.1: Reproducción de los Conejos de Fibonacci
Cada mes que pasa, cada pareja de conejos adultos da a luz a una nueva
pareja de conejos, y una pareja de conejos tarda un mes en crecer. Escribe
una función que regrese cuántos conejos adultos se tienen pasados n meses
de la compra.
Solución Sea F (x) el número de parejas de conejos adultos pasados x
meses. Podemos ver claramente que pasados 0 meses hay 0 parejas adultas y
pasado un mes hay una sola pareja adulta. Es decir F (0) = 0 y F (1) = 1.
Ahora, suponiendo que para alguna x ya sabemos F (0), F (1), F (2), F (3),
..., F (x − 1), en base a eso ¾cómo podemos saber el valor de F (x)?
Si en un mes se tienen a parejas jóvenes y b parejas adultas, al siguiente
mes se tendrán a + b parejas adultas y b parejas jóvenes.
Por lo tanto, el número de conejos adultos en un mes n, es el número de
conejos adultos en el mes n-1 más el número de conejos jóvenes en el mes
n-1.
Como el número de conejos jóvenes en el mes n-1 es el número de conejos

-- 40 of 315 --

2.3. LOS CONEJOS DE FIBONACCI 41
adultos en el mes n-2, entonces podemos concluir que:
F (0) = 0
F (1) = 1
F (n) = F (n − 1) + F (n − 2)
El siguiente código en C muestra una implementación de una función
recursiva para resolver el problema planteado por Fibonacci:
Código 2.4: Función recursiva de la serie de Fibonacci
1 int F( int n ) {
2 i f ( n==0){
3 return 0 ;
4 } e l s e i f ( n==1){
5 return 1 ;
6 } e l s e {
7 return F( n−1)+F( n−2) ;
8 }
9
10 }

Si corres el código anterior en una computadora, te darás cuenta que el
tamaño de los números crece muy rápido y con números como 39 o 40 se
tarda mucho tiempo en responder, mientras que con el número 50 parece
nunca terminar.
Hemos resuelto de manera teórica el problema de los conejos de Fibonacci,
sin embargo ½esta solución es irrazonablemente lenta!.
Como curiosidad matemática, posiblemente alguna vez leas u oigas hablar
sobre la sucesión de Fibonacci, cuando suceda, ten presente que la sucesión
de Fibonacci es
F (0), F (1), F (2), F (3), F (4), F (5), ...
O escrita de otra manera:
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
Además de servir como solución a este problema, la serie de Fibonacci cumple
también con muchas propiedades interesantes que pueden servir para resolver
o plantear otros problemas.
Por el momento no se mostrarán aquí, ya que ese no es el objetivo del libro,
pero si te interesa puedes investigarlo, en internet hay bastante referente a
eso.

-- 41 of 315 --

42CAPÍTULO 2. DEFINICIÓN Y CARACTERÍSTICAS DE LA RECURSIÓN

-- 42 of 315 --

Cap´ıtulo 3
Recursión con Memoria o
Memorización
La recursión con Memoria o Memorización es un método para evitar que
una misma función recursiva se calcule varias veces ejecutándose bajo las mis-
mas condiciones; consiste en tener en una estructura(por lo general un arreglo
de una o varias dimensiones) para guardar los resultados ya calculados.
3.1. Mejorando el Rendimiento de Fibonacci
Problema Resuelto 3.1.1. Recordando, la sucesión de Fibonacci se dene
como
F (0) = 0
F (1) = 1
F (n) = F (n − 1) + F (n − 2)
Escribe un programa que calcule e imprima los primeros 50 números de
la serie de Fibonacci en menos de un segundo.
Solución Ya habíamos visto en la sección anterior que la función recur-
siva de Fibonacci(véase código 2.4) es extremadamente lenta, vale la pena
preguntarnos ¾Qué la hace lenta?.
Si nos ponemos a ver su ejecución en un depurador o la realizamos men-
talmente, nos daremos cuenta que para calcular F (n), se está calculando
F (n − 1) y F (n − 2), y para calcular F (n − 1) también se está calculando
F (n − 2).
43

-- 43 of 315 --

44 CAPÍTULO 3. RECURSIÓN CON MEMORIA O MEMORIZACIÓN
Figura 3.1: Llamadas a función que se realizan para calcular F (6)
Una vez que se terminó de calcular F (n−1) ya se había calculado F (n−2),
y sin embargo, se vuelve a calcular. Con ello, ya hemos visto que F (n − 2)
se esta calculando 2 veces.
Extrapolando este razonamiento F (n − 4) se está calculando al menos 4
veces, F (n − 6) se esta calculando al menos 8 veces, etc. Es decir, para algún
m < n tal que m es par F (n − m) se calcula al menos 2m−1
2 veces(es un
ejercicio corto demostrarlo por inducción).
¾Exactamente de cuántas veces estamos hablando que se calcula cada
número de Fibonacci?. Por el momento no vale la pena ver eso, es suciente
con saber que es un número exponencial de veces.
Para solucionar esta problemática, vamos a declarar un arreglo v de
tamaño 50 y con el tipo de datos long long, ya que a nadie le extrañaría
que F (49) > 232.
Luego, cada que se quiera saber el valor de F (n), se vericará si v[n] ya
fue usado(los valores de v se inicializan en 0, ya que es un arreglo global), si ya
fue usado simplemente regresará v[n] si no ha sido usado entonces calculará
el valor de F (n) y lo guardará en v[n].
Así concluimos nuestros razonamientos para llegar a este código:
Código 3.1: Fibonacci utilizando recursión con memoria
1 #include <s t d i o . h>
2 int v [ 5 0 ] ;
3 int F( int n ) {
4 i f ( v [ n ] ! = 0 ) {
5 return v [ n ] ;
6 } i f ( n==0){
7 return 0 ;
8 } i f ( n==1){
9 return 1 ;
10 }v [ n]=F( n−1)+F( n−2) ;
11 return v [ n ] ;
12 }

-- 44 of 315 --

3.2. ERROR COMÚN EN LA MEMORIZACIÓN 45
13 int main ( ) {
14 int i ;
15 for ( i =0; i <50; i ++){
16 p r i n t f ( " %l l d \n" , F( i ) ) ;
17 } return 0 ;
18 }

Aunque el código anterior es notablemente mas largo que el código 2.4,
solamente las líneas de la 2 a la 12 son interesantes, lo demás es solamente
para imprimir en pantalla el resultado.
Si ejecutas esta nueva función F en una computadora te darás cuenta que
es mucho mas rápida que la función F que se muestra en el código 2.4.
3.2. Error Común en la Memorización
La recursión con memoria solamente sirve cuando la función recursiva que
se quiere optimizar no utiliza los valores de variables estáticas ni globales para
calcular su resultado; de lo contrario si la función es llamada con los mismos
parámetros no se garantiza que se esté calculando exactamente lo mismo mas
de una vez y la recursión con memoria no sirve en ese caso.
En ciertas ocaciones es conveniente memorizar aún cuando la función
recursiva original utilice variables globales, pero en esos casos debemos estar
seguros que mientras usemos la función, las variables globales deberán de
mantenerse constantes para que de esa forma el valor que regrese la función
original solamente dependa de los parámetros.
Es común para alguien que va empezando en la recursión con memoria
cometer este tipo de errores por ello hay que tomar precauciones adicionales.
3.3. Triangulo de Pascal
Probablemente alguna vez viste este triángulo:
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1

-- 45 of 315 --

46 CAPÍTULO 3. RECURSIÓN CON MEMORIA O MEMORIZACIÓN
1 6 15 20 15 6 1
..........
Este triángulo se conoce como Triángulo de Pascal, la manera de constru-
irlo es bastante simple, se coloca un 1 en el primer renglón, en cada renglón
a partir del segundo, se forman números sumando cada par de números ady-
acentes del renglón anterior(es decir, cada número es la suma de los dos
números que tiene arriba) y se coloca un 1 en cada extremo del renglón.
Vamos a llamar al j-ésimo número del i-ésimo renglón P (i, j).
Problema Resuelto 3.3.1. Escribe una función recursiva que regrese P (i, j),
para i < 50 y j < 50 y P (i, j) < 231.
Primero hay que notar que P (1, 1) = 1, luego que el primer numero de
cada renglón también es 1; es decir P (i, 1) = 1, y el último número de cada
renglón también es 1, osea P (i, i) = 1; en otro caso es la suma de los dos
números que tiene arriba, es decir P (i, j) = P (i − 1, j − 1) + P (i − 1, j). De
esta manera completamos la función recursiva así:
P (i, 1) = 1
P (i, i) = 1
P (i, j) = P (i − 1, j − 1) + P (i − 1, j) para 1 < j < i
Aquí se ignoró P (1, 1) = 1 ya que P (i, 1) = 1 implica P (1, 1) = 1 Nuevamente
utilizaremos un arreglo llamado v para guardar los resultados ya calculados,
y ya que ningún resultado puede ser 0, cuando v[i][j] sea 0 sabremos que no
se ha calculado aún. Ahora el código de la función en C resulta así:
Código 3.2: Triangulo de Pascal utilizando Recursión con Memoria
1 int v [ 5 1 ] [ 5 1 ] ;
2 int P( int i , int j ) {
3 i f ( j==1 | | i==j ) {
4 return 1 ;
5 } i f ( v [ i ] [ j ] ! = 0 ) {
6 return v [ i ] [ j ] ;
7 }
8 v [ i ] [ j ]=P( i −1, j −1)+P( i −1, j ) ;
9 return v [ i ] [ j ] ;
10 }


-- 46 of 315 --

3.3. TRIANGULO DE PASCAL 47
El triángulo de Pascal tiene varias propiedades útiles, una muy útil sirve
para calcular combinaciones.
Denición 3.3.1 (Combinaciones). Las combinaciones de n en m son la
cantidad de formas de escoger m objetos entre un total de n objetos distintos.
Se denota como:
(m
n
)
Por convención diremos que (n
0
) = 1 para cualquier entero no negativo n.
La última parte de la denición puede parecer que va contra el sentido
común, ya que (n
0
) indica el número de maneras de elegir 0 objetos de un
total de n objetos distintos, se suele pensar que si no se elige ningún objeto
realmente no se está eligiendo nada por lo que (n
0
) debería ser igual a 0 pero
en realidad es igual a 1.
El motivo de esta confusión proviene de la palabra elegir, no está claro si
es válido decir que se eligen 0 objetos. Mas adelante, cuando se introduzca
la noción de conjuntos, no sonará extraño el hecho de que se pueden elegir
0 objetos de una sola manera; pero por el momento el lector tendrá que
adaptarse a la idea antinatural de que es válido elegir 0 objetos.
Problema Resuelto 3.3.2. Prueba que (i−1
j−1
) = P (i, j).
Solución Recordemos cómo se calcula P :
P (i, 1) = 1
P (i, i) = 1
P (i, j) = P (i − 1, j − 1) + P (i − 1, j) para 1 < j < i
De esa manera obtenemos 3 proposiciones:
P (i, 1) = 1 implica (i−1
0
) = 1, es decir, el número de formas de elegir 0
objetos entre un total de i − 1 objetos distintos es 1.
P (i, i) = 1 implica (i−1
i−1
) = 1, es decir, el número de formas de elegir
i − 1 objetos entre un total de i − 1 objetos distintos es 1.
P (i, j) = P (i − 1, j − 1) + P (i − 1, j) implica (i−1
j−1
) = (i−2
j−2
) + (i−2
j−1
) para
1 < j < i esta proposición es equivalente a:
(i
j
)
=
(i − 1
j − 1
)
+
(i − 1
j
)

-- 47 of 315 --

48 CAPÍTULO 3. RECURSIÓN CON MEMORIA O MEMORIZACIÓN
La primera proposición es obvia, solo hay una manera de elegir 0 objetos
entre un total de i − 1 objetos distintos, y ésta es no eligiendo ningún objeto.
La segunda proposición también es obvia, la única manera de elegir i − 1
objetos de entre un total de i − 1 objetos es eligiendo todos.
La tercera proposición es más difícil de aceptar, digamos que se tienen
n objetos numerados de 1 a n; y se quieren elegir m objetos entre ellos, en
particular, se puede optar entre elegir el objeto n o no elegir el objeto n.
El número de formas de elegir m objetos de entre un total de n objetos
distintos, es el número de formas de hacer eso eligiendo al objeto n más el
número de formas de hacer eso sin elegir al objeto n.
Si se elige el objeto n, entonces habrá que elegir m − 1 objetos de entre
un total de n − 1 objetos distintos; hay (n−1
m−1
) formas distintas de hacerlo.
Si no se elige el objeto n, entonces habrá que elegir m objetos de entre
un total de n − 1 objetos distintos(si ya se decidió no elegir a n, entonces
quedan n − 1 objetos que pueden ser elegidos); hay (n−1
m
) formas de hacerlo.
Por ello concluimos que (n
m
) = (n−1
m−1
)+(n−1
m
) lo que prueba tercera proposi-
ción.

La solución de este problema prueba un resultado muy importante lla-
mado la Fórmula de Pascal, vale la pena resaltarlo.
Teorema 1 (Fórmula de Pascal). Sean i, j enteros positivos, se tiene que:
(i
j
)
=
(i − 1
j − 1
)
+
(i − 1
j
)
3.4. Teorema del Binomio
El triángulo de Pascal otras propiedades interesantes, una de ellas está
estrechamente relacionada con el teorema del binomio; el cual se le atribuye
a Newton.
Para dar una idea de a qué se reere el teorema del binomio; basta ver
los coecientes de las siguientes ecuaciones:
(a + b)0 = 1
(a + b)1 = a + b
(a + b)2 = a2 + 2ab + b2
(a + b)3 = a3 + 3a2b + 3ab2 + b3

-- 48 of 315 --

3.4. TEOREMA DEL BINOMIO 49
(a + b)4 = a4 + 4a3b + 6a2b2 + 4ab3 + b4
(a + b)5 = a5 + 5a4b + 10a3b2 + 10a2b3 + 5ab4 + b5
Después de ver los coecientes es natural que a uno le llegue a la mente
el triángulo de Pascal y eso es exactamente a lo que se reere el teorema del
binomio.
Teorema 2 (Teorema del Binomio). Para cualquier entero no negativo n:
(a + b)n =
(n
0
)
anb0 +
(n
1
)
an−1b1 +
(n
2
)
an−2b2 +
(n
3
)
an−3b3 + ... +
(n
n
)
a0bn
Demostración. Ya vimos que para n=0 si se cumple el teorema. Ahora,
suponiendo que para algún número n se cumple el teorema ¾se aplicará
cumplirá n + 1? Por construcción vamos suponiendo que para alguna n:
(a + b)n =
(n
0
)
anb0 +
(n
1
)
an−1b1 +
(n
2
)
an−2b2 +
(n
3
)
an−3b3 + ... +
(n
n
)
a0bn
Multiplicamos ambos miembros de la ecuación por (a + b)
((a+b)n)(a+b) = (
(n
0
)
anb0 +
(n
1
)
an−1b1 +
(n
2
)
an−2b2 +...+
(n
n
)
a0bn)(a+b)
(a+b)n+1 =
(n
0
)
an+1b0+(
(n
1
)
+
(n
0
)
)anb1+(
(n
2
)
+
(n
1
)
)an−1b2+...+
(n
n
)
a0bn+1
Recordamos que (n
m
) = (n−1
m−1
) + (n−1
m
).
(a + b)n+1 =
(n
0
)
an+1b0 +
(n + 1
1
)
anb1 + ... +
(n + 1
n
)
a1bn +
(n
n
)
a0bn+1
Como (n
n
) = (n+1
n+1
) = 1 y (0
n
) = ( 0
n+1
) = 1 entonces:
(a + b)n+1 =
(n + 1
0
)
an+1b0 +
(n + 1
1
)
anb1 + ... +
(n + 1
n + 1
)
a0bn+1
Por inducción el teorema queda demostrado.
Debido al teorema del binomio, a las combinaciones tambien se les llama
coecientes binomiales.
El Triangulo de Pascal aún tiene muchas más propiedades interesantes,
pero por el momento esto es todo lo que hay en el libro, si algún lector
se quedó intrigado por este famoso triángulo puede buscar en internet y
encontrará muchas cosas.

-- 49 of 315 --

50 CAPÍTULO 3. RECURSIÓN CON MEMORIA O MEMORIZACIÓN

-- 50 of 315 --

Cap´ıtulo 4
Divide y Vencerás
Ésta célebre frase para estrategias de guerra ha llegado a ser bastante
popular en el campo de las matemáticas y sobre todo, en el de las matemáticas
aplicadas a la computación.
La estrategia Divide y Vencerás se dene de una manera bastante simple:
Divide un problema en partes mas pequeñas, resuelve el problema por las
partes, y combina las soluciones de las partes en una solución para todo el
problema.
Es difícil encontrar un problema donde no se utilice ésta estrategia de
una u otra forma.
Sin embargo, aquí se tratará exclusivamente de la estrategia Divide y
Vencerás en su forma recursiva:
Divide. Un problema es dividido en copias mas pequeñas del mismo
problema.
Vence. Se resuelven por separado las copias mas pequeñas del problema.
Si el problema es sucientemente pequeño, se resuelven de la manera
mas obvia.
Combina. Combina los resultados de los subproblemas para obtener la
solución al problema original.
La dicultad principal en resolver este tipo de problemas radica un poco en
cómo dividirlos en copias mas pequeñas del mismo problema y sobre todo
cómo combinarlos.
A veces la estrategia recursiva Divide y Vencerás mejora sustancialmente
la eciencia de una solución, y otras veces sirve solamente para simplicar
las cosas.
51

-- 51 of 315 --

52 CAPÍTULO 4. DIVIDE Y VENCERÁS
Como primer ejemplo de Divide y Vencerás veremos un problema que
puede resultar mas sencillo resolverse sin recursión, pero esto es solo para
dar una idea de cómo aplicar la estrategia.
4.1. Máximo en un Arreglo
Problema Resuelto 4.1.1. Escribe una función que dado un arreglo de
enteros v y dados dos enteros a y b, regrese el número mas grande en v[a..b](el
número mas grande en el arreglo que esté entre los índices a y b, incluido este
último).
Solución Lo mas sencillo sería iterar desde a hasta b con un for, guardar
el máximo en una variable e intentar actualizarla en cada iteración.
Pero una forma de hacerlo con Divide y Vencerás puede ser:
Si a < b, dividir el problema en encontrar el máximo en v[a..(a +
b)/2] y el máximo en v[(a + b)/2 + 1..b] y resolver ambos problemas
recursivamente.
Si a = b el máximo sería v[a]
Una vez teniendo las respuestas de ambos subproblemas, ver cual de
ellas es mayor y regresar esa.
Los 3 puntos de éste algoritmo son los 3 puntos de la estrategia Divide y
Vencerás aplicados.
Esta claro que este algoritmo realmente encuentra el máximo, puesto que
en v[a..b] está compuesto por v[a..(a + b)/2] y v[(a + b)/2 + 1..b], sin quedar
un solo número del intervalo excluido.
También sabemos que si un número x > y y y > z, entonces x > z, por ello
podemos estar seguros que alguno de los dos resultados de los subproblemas
debe de ser el resultado al problema original.
Para terminar de resolver este problema, hay que escribir el código:
Código 4.1: Máximo en un intervalo cerrado a, b
1 int maximo ( int v [ ] , int a , int b ) {
2 int maximo1 , maximo2 ;
3 i f ( a<b ) {
4 maximo1=maximo ( v , a , ( a+b ) /2) ;
5 maximo2=maximo ( v , ( a+b ) /2+1 , b ) ;
6 i f ( maximo1>maximo2 ) {

-- 52 of 315 --

4.2. BÚSQUEDA BINARIA 53
7 return maximo1 ;
8 } e l s e {
9 return maximo2 ;
10 }
11 } e l s e {
12 return v [ a ] ;
13 }
14 }

4.2. Búsqueda Binaria
Ahora, después de haber visto un ejemplo impráctico sobre el uso de
Divide y Vencerás, veremos un ejemplo práctico.
Supongamos que tenemos un arreglo v con los números ordenados de
manera ascendente. Es decir, v[a] > v[a − 1] y queremos saber si un número
x se encuentra en el arreglo, y de ser así, ¾dónde se encuentra?
Una posible forma sería iterar desde el principio del arreglo con un for
hasta llegar al nal y si ninguno de los valores es igual a x, entonces no está,
si alguno de los valores es igual a x, guardar dónde está.
¾Pero qué sucedería si quisiéramos saber un millón de veces dónde está
algún número(el número puede variar)? Como ya te lo podrás imaginar, el
algoritmo anterior repetido un millón de veces se volverá lento.
Es como si intentáramos encontrar el nombre de un conocido en el direc-
torio telefónico leyendo todos los nombres de principio a n a pesar de que
están ordenados alfabéticamente.
Problema Resuelto 4.2.1. Escribe una función que dado un arreglo orde-
nado de manera ascendente, y tres enteros a, b y x, regrese -1 si x no está
en v[a..b] y un entero diciendo en qué índice se encuentra x si lo está. Tu
programa no deberá hacer mas de 100 comparaciones y puedes asumir que
b − a<1000000.
Solución La solución a este problema se conoce como el algoritmo de la
búsqueda binaria.
La idea consiste en ver qué número se encuentra a la mitad del intervalo
v[a..b]. Si v[(a+b)/2] es menor que x, entonces x deberá estar en v[(a+b)/2+
1..b], si v[(a + b)/2] es mayor que x, entonces x deberá estar en v[a..(a + b)/2].
En caso de que a = b, si v[a] = x, entonces x se encuentra en a.

-- 53 of 315 --

54 CAPÍTULO 4. DIVIDE Y VENCERÁS
Así que, los 3 pasos de la estrategia Divide y Vencerás con la búsqueda
binaria son los siguientes:
Si b > a, comparar v[(a + b)/2] con x, si x es mayor entonces resolver
el problema con v[(a + b)/2 + 1..b], si x es menor resolver el problema
con v[a..(a + b)/2 − 1], y si x es igual, entonces ya se encontró x.
Si b ≥ a, comparar v[a] con x, si x es igual entonces se encuentra en a,
si x es diferente entonces x no se encuentra.
Ya sabiendo en qué mitad del intervalo puede estar, simplemente hay
que regresar el resultado de ese intervalo.
Código 4.2: Búsqueda Binaria Recursiva
1 int Busqueda_Binaria ( int v [ ] , int a , int b , int
x ) {
2 i f ( a>=b ) {
3 i f ( v [ a]==x )
4 return a ;
5 e l s e
6 return −1;
7 }
8 i f ( v [ ( a+b ) /2]==x ) {
9 return ( a+b ) / 2 ;
10 } e l s e i f ( v [ ( a+b ) /2] <x ) {
11 return Busqueda_Binaria ( v , ( a+b ) /2+1 , b ,
x ) ;
12 } e l s e {
13 return Busqueda_Binaria ( v , a , ( a+b ) /2 −1 ,
x ) ;
14 }
15 }
A pesar de que la idea de la búsqueda binaria es puramente recursiva,
también se puede eliminar por completo la recursión de ella:
Código 4.3: Búsqueda Binaria Iterativa
1 int Busqueda_Binaria ( int v [ ] , int a , int b , int x ) {
2 while ( a<b )
3 i f ( v [ ( a+b ) /2]==x ) {
4 return ( a+b ) / 2 ;
5 } e l s e i f ( v [ ( a+b ) /2] <x ) {

-- 54 of 315 --

4.2. BÚSQUEDA BINARIA 55
Figura 4.1: Rendimiento de la Búsqueda Binaria. El espacio de búsque-
da(intervalo donde puede estar la solución) esta marcado con gris, y el valor
que se esta comparando está marcado con negro.

-- 55 of 315 --

56 CAPÍTULO 4. DIVIDE Y VENCERÁS
Figura 4.2: Tórres de Hanoi
6 a=(a+b ) /2+1;
7 } e l s e {
8 b=(a+b ) /2 −1;
9 }
10 i f ( v [ a]==x ) {
11 return a ;
12 } e l s e {
13 return −1;
14 }
15 }
Aunque de que los códigos están del mismo tamaño, muchas veces resulta
mas práctica la iterativa, ya que no es necesario declarar una nueva función
para realizarla.

4.3. Torres de Hanoi
El problema de las Torres de Hanoi es un problema utilizado frecuente-
mente como ejemplo de recursión.
Imagina que tienes 3 postes llamados A, B y C.
En el poste A tienes n discos de diferente diámetro, acomodados en orden
creciente de diámetro desde lo más alto hasta lo más bajo.

-- 56 of 315 --

4.3. TORRES DE HANOI 57
Solamente puedes mover un disco a la vez desde un poste hasta otro y no
esta permitido poner un disco mas grande sobre otro mas pequeño. Tu tarea
es mover todos los discos desde el poste A hasta el poste C.
Problema Resuelto 4.3.1. Escribe una función que reciba como parámetro
n y que imprima en pantalla todos los pasos a seguir para mover los discos
del poste A al poste C.
Solución Pensando primero en el caso mas pequeño, si n = 1, tendríamos
un solo disco y solo habría que moverlo de la torre A a la C.
Ahora, suponiendo que para algún n ya sabemos cómo mover n − 1 discos
de una torre a cualquier otra ¾qué deberíamos hacer?
Luego de hacerse esta pregunta directamente llegamos a la conclusión de
que primero hay que mover los primeros n − 1 discos a la torre B, luego el
disco n a la torre C, y posteriormente mover los n − 1 discos de la torre B a
la torre C.
Podemos estar seguros que lo anterior funciona ya que los primeros n − 1
discos de la torre siempre serán mas pequeños que el disco n, por lo cual
podrían colocarse libremente sobre el disco n si así lo requirieran.
Se puede probar por inducción el procedimiento anterior funciona si se
hace recursivamente.
Así que nuestro algoritmo de Divide y Vencerás queda de la siguiente
manera:
Sea x la torre original, y la torre a la cual se quieren mover los discos, y
z la otra torre.
Para n > 1, hay que mover n − 1 discos de la torre x a la z, luego mover
un disco de la torre x a la y y nalmente mover n − 1 discos de la torre
z a la y.
Para n = 1, hay que mover el disco de la torre x a la y ignorando la
torre z.
Nótese que aquí los pasos de Divide y Combina se resumieron en uno sólo,
pero si están presentes ambos.
El siguiente código muestra una implementación del algoritmo anterior,
consta de dos funciones, una que recibe solamente el número de discos y otra
que recibe el número de discos y los nombres de los postes.
Código 4.4: Torres de Hanoi
1 void mueve ( int n , char x , char y , char z ) {
2 i f ( n==1){

-- 57 of 315 --

58 CAPÍTULO 4. DIVIDE Y VENCERÁS
3 p r i n t f ( "Mueve de %c a %c . \ n" , x , y ) ;
4 } e l s e {
5 mueve ( n−1, x , z , y ) ;
6 p r i n t f ( "Mueve de %c a %c . \ n" , x , y ) ;
7 mueve ( n−1, z , y , x ) ;
8 }
9 }
10 void hanoi ( int n ) {
11 hanoi ( n , 'A ' , 'C ' , 'B ' ) ;
12 }

Una leyenda cuenta que en un monasterio en la ciudad de Hanoi hay 3
postes colocados de esa manera y unos monjes han estado trabajando para
mover 48 discos del poste A al poste C, una vez que terminen de mover los
48 discos el mundo se acabará.
¾Te parecen pocos 48 discos?, corre la solución a este problema con n=48
y verás que parece nunca terminar(ahora imagina si se tardaran 2 minutos
en mover cada disco).
Problema Resuelto 4.3.2. ¾Cuántas líneas imprime hanoi(n) (asumiendo
que esta función está implementada como se muestra en el código 4.4)?
Solución Sea H(n) el número de líneas que imprime hanoi(n). Está claro
que hanoi(n) imprime el mismo número de líneas que mueve(n, 'A', B',
'C').
Es obvio que H(1) = 1 puesto que hanoi(1) solamente imprime una
línea.
Nótese que cada que se llama a mueve(n, ...) se está llamando dos
veces a hanoi(n-1, ...) una vez en la línea 5 y otra en la línea 7. Además,
en la línea 6 imprime un movimiento.
Por lo tanto obtenemos la siguiente función recursiva:
H(1) = 1
H(n) = H(n − 1) ∗ 2 + 1
Ahora haremos unas cuantas observaciones para simplicar aún mas esta
función recursiva:

-- 58 of 315 --

4.3. TORRES DE HANOI 59
H(1) = 1 = 1
H(2) = 2 + 1 = 3
H(3) = 4 + 2 + 1 = 7
H(4) = 8 + 4 + 2 + 1 = 15
H(5) = 16 + 8 + 4 + 2 + 1 = 31
H(6) = 32 + 16 + 8 + 4 + 2 + 1 = 63
...
Probablemente ya estés sospechando que
H(n) = 2n−1 + 2n−2 + 2n−3 + ... + 20
Por inducción podemos darnos cuenta que como con H(1) si se cumple y
(2n−1 + 2n−2 + 2n−3 + ... + 20)2 + 1 = 2n + 2n−1 + 2n−2 + ... + 20
Entonces para cualquier número n la proposición se debe de cumplir.
O también puedes estar sospechando que:
H(n) = 2n − 1
De nuevo por inducción
H(0) = 20 − 1
Y suponiendo que para alguna n, H(n) = 2n − 1
(2n − 1)(n) + 1 = 2n+1 − 2 + 1 = 2n+1 − 1
Por lo tanto, podemos concluir que la respuesta de este problema es sin
lugar a dudas 2n − 1.

Además de haber resuelto este problema pudimos darnos cuenta que
2n − 1 = 2n−1 + 2n−2 + 2n−3 + ... + 20 (4.1)
Esta propiedad de la suma de potencias de 2 hay que recordarla.

-- 59 of 315 --

60 CAPÍTULO 4. DIVIDE Y VENCERÁS

-- 60 of 315 --

Cap´ıtulo 5
Búsqueda Exhaustiva
A veces parece que no hay mejor manera de resolver un problema que
tratando todas las posibles soluciones. Esta aproximación es llamada Búsque-
da Exhaustiva, casi siempre es lenta, pero a veces es lo único que se puede
hacer.
También a veces es útil plantear un problema como Búsqueda Exhaustiva
y a partir de ahí encontrar una mejor solución.
Otro uso práctico de la Búsqueda Exhaustiva es resolver un problema con
con un tamaño de datos de entrada lo sucientemente pequeño.
La mayoría de los problemas de Búsqueda Exhaustiva pueden ser re-
ducidos a generar objetos de combinatoria, como por ejemplo cadenas de
caracteres, permutaciones(reordenaciones de objetos) y subconjuntos.
5.1. Cadenas
Problema Resuelto 5.1.1. Escribe una función que dados dos números en-
teros n y c, imprima todas las cadenas de caracteres de longitud n que utilicen
solamente las primeras c letras del alfabeto(todas minúsculas), puedes asumir
que n < 20.
Solución Llamemos cadenas(n, c) al conjunto de cadenas de longitud n
usando las primeras c letras del alfabeto.
Como de costumbre, para encontrar la solución a un problema recursivo
pensaremos en el caso mas simple.
El caso en el que n = 1 y c = 1. En ese caso solamente hay que imprimir
”a”, o dicho de otra manera, cadenas(1, 1) = {”a”}
61

-- 61 of 315 --

62 CAPÍTULO 5. BÚSQUEDA EXHAUSTIVA
En este momento podríamos pensar en dos opciones para continuar el
razonamiento cómo de costumbre:
n = 1 y c > 1 o
n > 1 y c = 1
Si pensáramos en la segunda opción, veríamos que simplemente habría
que imprimir las primeras n letras del abecedario.
Si pensáramos en la segunda opción, veríamos que simplemente habría
que imprimir n veces a y posteriormente un salto de línea.
Ahora vamos a suponer que n > 1 y c > 1, para alguna n y alguna c, ¾sería
posible obtener cadenas(n, c) si ya se tiene cadenas(n−1, c) ó cadenas(n, c−
1)?
Si nos ponemos a pensar un rato, veremos que no hay una relación muy
obvia entre cadenas(n, c) y cadenas(n, c − 1), así que buscaremos la relación
por cadenas(n − 1, c).
Hay que hacer notar aquí que si se busca una solución en base a una
pregunta y ésta parece complicarse, es mejor entonces buscar la solución de
otra forma y sólo irse por el camino complicado si no hay otra opción.
Volviendo al tema, buscaremos la relación de cadenas(n, c) con cadenas(n−
1, c).
A veces algunos ejemplos sencillos pueden dar ideas. Observamos que
cadenas(1, 3) = {a,
b,
c,
}
cadenas(2, 3) = {aa, ab, ac,
ba, bb, bc,
ca, cb, cc
}
cadenas(3, 3) = {aaa, aab, aac, aba, abb, abc, aca, acb, acc,
baa, bab, bac, bba, bbb, bbc, bca, bcb, bcc,
caa, cab, cac, cba, cbb, cbc, cca, ccb, ccc,
}

-- 62 of 315 --

5.1. CADENAS 63
Luego de observar esto, es posible prestar mas atención a la siguiente
propiedad:
Toda cadena de n caracteres puede ser formada por una cadena de n − 1
caracteres seguida de otro caracter.
Esto quiere decir que para cada caracter que pueda tener la cadena hay
que generar todas las cadenas de n − 1 caracteres y a cada cadena colocarle
dicho caracter al nal.
Partiendo de esta idea, que puede parecer un tanto complicada de imple-
mentar, se puede sustituir por la idea de primero colocar el ultimo caracter
de la cadena, y luego generar todas las cadenas de n − 1 caracteres posibles.
Para evitar meter muchos datos en la pila, es mejor tener la cadena
guardada en un arreglo global de tipo char.
Código 5.1: Generador de Cadenas de Caracteres
1 char C [ 2 1 ] ;
2 void cadenas ( int n , int c ) {
3 int i ;
4 i f ( n==0){
5 p r i n t f ( " %s \n" , C) ;
6 } e l s e {
7 for ( i= ' a ' ; i < ' a '+c ; i ++){
8 C[ n]= i ;
9 cadenas ( n−1, c ) ;
10 }
11 }
Problema Resuelto 5.1.2. ¾Cuántas cadenas de longitud n que utilizan
solamente las primeras c letras del abecedario(todas minúsculas) existen? O
dicho de otra forma ¾Cuántas líneas imprime el código 5.1?
Solución Llamémosle cad(n, c) al número de líneas que imprime el código