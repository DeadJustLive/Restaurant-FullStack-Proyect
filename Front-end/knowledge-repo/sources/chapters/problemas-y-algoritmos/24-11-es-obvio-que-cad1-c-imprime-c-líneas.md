# 11. Es obvio que cad(1, c) imprime c líneas.

Nótese que si n > 1, cadenas(n, c) llama c veces a cadenas(n − 1, c). Por
lo tanto
cad(1, c) = c
cad(n, c) = cad(n − 1, c)c para n > 1
Ahora por inducción es fácil darnos cuenta que
cad(n, c) = cn


-- 63 of 315 --

64 CAPÍTULO 5. BÚSQUEDA EXHAUSTIVA
Un algoritmo de cambio mínimo para generar cadenas binarias(de 0s y
1s) es aquel que genera todas las cadenas binarias de determinada longitud
en un orden tal que cada cadena diera de su predecesor en solamente un
caracter.
El siguiente código es una implementación de un algoritmo de cambio
mínimo que genera las 2n cadenas binarias.
Código 5.2: Generador de cadenas binarias con cambio mínimo
1 void g e n e r a ( int n ) {
2 i f ( n==0){
3 imprime_cadena ( ) ;
4 } e l s e {
5 g e n e r a ( n−1) ;
6 C[ i ] = !C[ i ] ;
7 g e n e r a ( n−1) ;
8 }
9 }
El código anterior genera las cadenas en un arreglo llamado C, y asume
que siempre será lo sucientemente grande para generar todas las cadenas, la
línea 3 llama a una función para imprimir la cadena generada, dicha función
no se muestra porque ocuparía demasiado espacio y no tiene relevancia en el
algoritmo.
Puede parecer un tanto confusa la línea 6, pero hay que recordar que !0
devuelve 1 y !1 devuelve 0.
Problema Resuelto 5.1.3. Demuestra que el código 5.2 genera todas las
cadenas binarias y que cada cadena que genera diere de la anterior en sola-
mente un dígito.
Solución Este problema requiere que se comprueben 2 cosas: una es que
el algoritmo genera todas las cadenas binarias de longitud n, y otra es que
las genera con cambio mínimo.
Si n = 1 basta con echar un vistazo al código para darse cuenta que
funciona en ambas cosas.
Podemos observar también, que luego de ejecutarse la línea 6 se llama
a genera(n − 1) y se sigue llamando recursivamente a la función genera sin
pasar por la línea 6 hasta que n toma el valor de 0 y se imprime la cadena
en la línea 3; de esta forma podemos asegurar que genera las cadenas con
cambio mínimo.
Para probar el hecho de que se imprimen todas las cadenas binarias de
longitud n, hay que hacer la siguiente observación que no es muy obvia:

-- 64 of 315 --

5.2. CONJUNTOS Y SUBCONJUNTOS 65
No importa si el arreglo C no está inicializado en 0s, siempre y cuando
contenga únicamente 0s y 1s. La prueba de esto es que dada una cadena
binaria de longitud n, se puede generar a partir de ella cualquier otra cadena
binaria de longitud n, simplemente cambiando algunos de sus 1s por 0s y/o
algunos de sus 0s por 1s. Si el algoritmo produce todas los conjuntos de
cambios que existen entonces generará todas las cadenas sin importar la
cadena inicial ya que a partir de una cadena se puede formar cualquier otra
luego de aplicar una serie de cambios.
La capacidad de poder hacer este tipo de razonamientos tanto es muy
importante, tan importante es poder reducir un problema como dividirlo.
De esa forma, suponiendo que para algún n − 1 la función produce todas
las cadenas de n − 1 caracteres, ¾las producirá para n?.
Dado que la función no hace asignaciones sino solamente cambios(línea
6), podemos estar seguros que si se producen todas las cadenas llamando a
la función con n − 1 signica que el algoritmo hace todos los cambios para
n − 1.
También se puede observar que la línea 5 llama a genera(n − 1) con
C[n] = a para alguna 0 ≤ a ≤ 1, y la línea 7 llama a genera(n − 1) con
C[n] =!a (si a = 0 entonces C[n] = 1 y si a = 1 entonces C[n] = 0).
Como C[n] está tomando todos los valores posibles y para cada uno de sus
valores esta generando todas las cadenas de tamaño n − 1 podemos concluir
que el algoritmo genera todas las cadenas binarias.

Hay que destacar una propiedad que se hayó en la solución:
Teorema 3. Sea cad(n, c) el número de cadenas que se pueden formar de
longitud n con un alfabeto de c letras.
cad(n, c) = cn
5.2. Conjuntos y Subconjuntos
Los conjuntos son estructuras que estan presentes en todas las áreas de
las matemáticas, y juegan un papel central en las matemáticas discretas y
por ende en las ciencias de la computación.
La idea básica de un conjunto es una colección de elementos, para los
cuales todo objeto debe pertenecer o no pertenecer a la colección.
Hay muchos ejemplos de la vida cotidiana de conjuntos, por ejemplo, el
conjunto de los libros de una biblioteca, el conjunto de muebles de la casa,
el conjunto de personas entre 25 y 30 años, etc.

-- 65 of 315 --

66 CAPÍTULO 5. BÚSQUEDA EXHAUSTIVA
Así como existen conjuntos tan concretos, las matemáticas tratan por lo
general con conjuntos más abstractos.
Por ejemplo el conjunto de los números entre 0 y 10, el conjunto de los
números pares, el conjunto de los polígonos regulares, entre otros. De hecho
casi todos los objetos matemáticos son conjuntos.
Los conjuntos nitos pueden describirse con una lista de sus elementos
separados por comas, por ejemplo, el conjunto de las vocales:
{a, e, i, o, u}
El conjunto de los números pares positivos de un solo dígito:
{2, 4, 6, 8}
Dado que un conjunto es una agrupación de elementos, no importa el
orden en el que se escriban los elementos en la lista. Por ejemplo:
{1, 5, 4, 3} = {4, 5, 1, 3}
Los conjuntos suelen representarse con letras mayúsculas y elementos de
los conjuntos con letras minúsculas.
Si un objeto a es un elemento de un conjunto P , entonces se dice que a
pertenece a P y se denota de la siguiente manera:
a ∈ P
y si un objeto a no pertenece a P se denota de la siguiente manera
a /	∈ P
Por ejemplo
1 ∈ 3, 1, 5 pero 1 /	∈ 3, 4, 2
En resumen:
Denición 5.2.1 (Conjunto). Un conjunto es una colección o agrupación
de objetos, a los que se les llama elementos. Los conjuntos nitos se pueden
describir con una lista de sus elementos separados por comas.
Si un objeto a es un elemento de un conjunto P , entonces se dice que a
pertenece a P y se denota de la siguiente manera:
a ∈ P
y si un objeto a no pertenece a P se denota de la siguiente manera
a /	∈ P

-- 66 of 315 --

5.2. CONJUNTOS Y SUBCONJUNTOS 67
Algunos conjuntos muy renombrados son:
El conjunto de los números reales R
El conjunto de los números enteros Z = {..., −3, −2, −1, 0, 1, 2, 3, ...}
El conjunto de los números naturales N = {0, 1, 2, 3, 4, 5, ...}
Respecto a este último conjunto, hay algunos matemáticos que aceptan el
0 como parte de los números naturales y hay matemáticos que no lo aceptan.
Por lo general los que no aceptan el 0 como parte de los números naturales
es porque en teoría de números no se comporta como el resto de ellos, y
además, el 0 fue un número desconocido para muchas civilizaciones.
Pero en las ciencias de la computación se suele aceptar al 0 como número
natural, y no es por mero capricho, esto tiene una razón importante: tanto en
el manejo de conjuntos como en la inducción, el 0 se comporta como número
natural.
Se dice que un conjunto A es subconjunto de B, si todos los elementos
de A también son elementos de B. O dicho de otra manera:
Denición 5.2.2 (Subconjunto). Se dice que A es subconjunto de B si para
todo elemento c tal que c ∈ A se cumple que también c ∈ B y se denota
como A ⊆ B.
Por ejemplo:
El conjunto de las vocales es un subconjunto del conjunto del alfabeto.
El conjunto de los números pares es un subconjunto del conjunto de los
números enteros.
{a, b} ⊆ {b, c, d, a, x}
N ⊆ Z
Z ⊆ R
Los subconjuntos son muy utilizados en la búsqueda exhaustiva, ya que
muchos problemas pueden ser reducidos a encontrar un subconjunto que
cumpla con ciertas características.
Ya sea para poder resolver un problema con búsqueda exhaustiva o para
poder encontrar una mejor solución partiendo de una búsqueda exhaustiva
es preciso saber cómo generar todos los subconjuntos.
Problema Resuelto 5.2.1. Supongamos que hay un arreglo global C que
es de tipo entero. Escribe una función que reciba un entero n como parámetro
e imprima todos los subconjuntos del conjunto de primeros n elementos del
arreglo C.

-- 67 of 315 --

68 CAPÍTULO 5. BÚSQUEDA EXHAUSTIVA
Solución Este problema de generar todos los subconjuntos se puede trans-
formar en el problema de generar cadenas de caracteres de una manera bas-
tante sencilla:
Cada elemento de C puede estar presente o ausente en un subconjunto
determinado.
Vamos a crear entonces un arreglo de presencias al que llamaremos P , es
decir P [i] será 0 si C[i] está ausente, y será 1 si C[i] está presente.
El problema entonces se reduce a generar todas las posibles cadenas bi-
narias de longitud n en P . La técnica de expresar un problema en términos
de otro es indispensable para resolver este tipo de problemas.
Código 5.3: Generación de subconjuntos
1 int imprime \ _subconjuntos ( int n , int m=−1){
2 int i ;
3 i f (m<n ) {
4 m=n ;
5 } i f ( n==0){
6 for ( i =0; i <m; i ++)
7 i f (P [ i ]==1)
8 p r i n t f ( " %d " , C[ i ] ) ;
9 p r i n t f ( "\n" ) ;
10 } e l s e {
11 P [ n−1]=0;
12 imprime \ _subconjuntos ( n−1, m) ;
13 P [ n−1]=1;
14 imprime \ _subconjuntos ( n−1, m) ;
15 }
16 }
El código anterior imprime todos los subconjuntos de C, se omite la
declaración de P para no gastar espacio y se utiliza el parámetro m co-
mo el número de elementos de los que hay que imprimir subconjuntos para
que no se confunda con el parámetro n que es el número de elementos de los
que hay que generar los subconjuntos.
Nótese que si se llama a la función dejando el parámetro predeterminado
para m, posteriormente m tomará el valor de n.

Problema Resuelto 5.2.2. Considera la misma situación que en el ejemplo
5.2.1, escribe una función que reciba como parámetros n y m, e imprima
todos los subconjuntos de los primeros n elementos del arreglo C tal que
cada subconjunto contenga exactamente m elementos.

-- 68 of 315 --

5.2. CONJUNTOS Y SUBCONJUNTOS 69
Solución Como ya vimos en el ejemplo anterior, este problema se puede
reducir a un problema de generación de cadenas binarias. Así que vamos a
denir P [i] como 1 si C[i] esta presente y como 0 si C[i] esta ausente del
subconjunto.
Sea además S(n, m) los subconjuntos de los primeros n elementos del
arreglo tal que cada subconjunto tenga exactamente m elementos.
Por ello el problema se reduce a encontrar todas las cadenas binarias de
longitud n que contengan exactamente m 1s.
Antes de encontrar el algoritmo para resolver esto es necesario hacer notar
las siguientes propiedades:
Si m > n no hay cadena binaria que cumpla con los requisitos, ya
que requiere tener exactamente m 1s, pero su longitud es demasiado
corta(menor que m).
Si m = 0 solo hay un subconjunto: el conjunto vacío.
Si n > 0 y n > m entonces S(n, m) esta compuesto únicamente por
S(n − 1, m) y por todos elementos de S(n − 1, m − 1) añadiéndoles C[n]
a cada uno(véase Ejemplo 11).
Con estas propiedades ya se puede deducir el algoritmo.
Al igual que en el ejemplo anterior, utilizaremos un parámetro auxiliar
al que llamaremos l que indicará de qué longitud era la cadena inicial. La
intención es que a medida que se vayan haciendo las llamadas recursivas, el
programa vaya formando una cadena que describa el subconjunto en P .
Dicho de otra manera deniremos una función llamada imprime_subconjuntos(n,
m, l), que generará todos los subconjuntos de tamaño m de los primeros
n elementos del arreglo C e imprimirá cada subconjunto representado en
P [0..n − 1] junto con los elementos denidos en P [n..l − 1](los que ya se
denieron en llamadas recursivas anteriores), es decir, imprimirá P [0..l − 1]
para cada subconjunto.
Si m > n entonces simplemente hay que terminar la ejecución de esa
función pues no hay nada que imprimir.
Si m = 0 solamente queda el conjunto vacío, entonces solo hay que im-
primir el subconjunto representado en P [0..l − 1].
En otro caso hay que asegurarse de que C[n−1] este ausente en el subcon-
junto y llamar a imprime_subconjuntos(n-1, m, l), esto generará todos
los subconjuntos de los primeros n elementos del arreglo C, con exactamente
m elementos, donde C[n − 1] no esta incluido.
Posteriormente, hay que poner a C[n] como presente y llamar a imprime_subconjuntos(n-1,
m-1, l) para generar los subconjuntos donde C[n] esta incluido.

-- 69 of 315 --

70 CAPÍTULO 5. BÚSQUEDA EXHAUSTIVA
Código 5.4: Generación de todos los subconjuntos de C con m elementos
1 void imprime_subconjuntos ( int n , int m, int l ) {
2 int i ;
3 i f (m>n ) {
4 return ;
5 } i f (m==0){
6 for ( i =0; i <l ; i ++)
7 i f (P [ i ]==1)
8 p r i n t f ( " %d " , C[ i ] ) ;
9 p r i n t f ( "\n" ) ;
10 } e l s e {
11 P [ n−1]=0;
12 imprime_subconjuntos ( n−1, m, l ) ;
13 P [ n−1]=1;
14 imprime_subconjuntos ( n−1, m−1, l ) ;
15 }
16 }

5.3. Permutaciones
Así como a veces un problema requiere encontrar un subconjunto que
cumpla con ciertas características, otras veces un problema requiere encontrar
una secuencia de objetos que cumplan con ciertas características sin que
ningún objeto se repita; es decir, una permutación.
Una permutación se puede denir como una cadena que no utiliza 2 veces
un mismo elemento.
Las permutaciones, al igual que los conjuntos, suelen representarse como
una lista de los elementos separada por comas pero delimitada por paréntesis.
Sin embargo, a diferencia de los conjuntos, en las permutaciones el orden en
el que se listan los elementos si importa.
Por ejemplo, la permutación (3, 2, 5) es diferente a la permutación (5, 3, 2)
y diferente a la permutación (2, 3, 5).
Si se tiene un conjunto A, una permutación de A es una cadena que utiliza
cada elemento de A una sola vez y no utiliza elementos que no pertenezcan
a A.
Por ejemplo, sea A el conjunto (a, b, c, d), una permutación de A es (a, c, d, b)
otra permutación es (d, a, c, b).

-- 70 of 315 --

5.3. PERMUTACIONES 71
Teorema 4. Sea A un conjunto con n elementos, existen n! permutaciones
de A.
Demostración. Un conjunto con un solo elemento o ningún elemento tiene
solamente una permutación.
Si para algún n se sabe el número de permutaciones que tiene un conjunto
de n elementos, ¾es posible averiguar el número de permutaciones con un
conjunto de n+1 elementos?
Consideremos una permutación de un conjunto con n elementos(aqui ai
representa el i-ésimo número de la permutación):
(a1, a2, a3, a4, ..., an)
Suponiendo que quisiéramos insertar un nuevo elemento en esa permutación,
lo podríamos poner al principio, lo podríamos poner entre a1 y a2, entre a2 y
a3, entre a3 y a4, ... , entre an−1 y an, o bien, al nal. Es decir, lo podríamos
insertar en n + 1 posiciones diferentes.
Nótese entonces que por cada permutación de un conjunto de n elementos,
existen n + 1 permutaciones de un conjunto de n + 1 elementos conservando
el orden de los elementos que pertenecen al conjunto de n elementos.
Y también, si a una permutación de un conjunto con n + 1 elementos se
le quita un elemento, entonces queda una permutación de un conjunto con n
elementos.
Sea p(n) el numero de permutaciones de un conjunto con n elementos,
podemos concluir entonces que p(0) = 1 y p(n) = p(n − 1)n, esta recurrencia
es exactamente igual a la función factorial.
Por ello el número de permutaciones de un conjunto con n elementos
diferentes es n!.
Problema Resuelto 5.3.1. Escribe un programa que dado n, imprima to-
das las permutaciones del conjunto de los primeros n números enteros posi-
tivos.
Solución Antes que nada tendremos un arreglo p[] = {1, 2, 3, ..., n}
Si n = 0 entonces solamente hay una permutación.
Si n > 0, hay que generar todas las permutaciones que empiecen con p[0],
las que empiecen con p[1], las que empiecen con p[2], las que empiecen con
p[3], ... , las que empiecen con p[n − 1](sobra decir a estas alturas que una
permutación de un conjunto con n números es un solo número seguido de
una permutación de un conjunto con n − 1 números).

-- 71 of 315 --

72 CAPÍTULO 5. BÚSQUEDA EXHAUSTIVA
Esto se puede hacer recursivamente, ya que la función generará todas las
permutaciones con n elementos, sin importar qué elementos sean. Es decir,
si el programa intercambia el valor de p[i] con el valor de p[n − 1] y manda a
llamar a la función con n − 1, la función generará todas las permutaciones de
los primeros n − 1 elementos con el antiguo valor de p[i] al nal. Así que hay
que repetir este procedimiento de intercambiar y mandar llamar a la función
para toda i entre 0 y n − 1.
Así que el programa queda de esta manera:
Código 5.5: Generación de permutaciones
1 #include <s t d i o . h>
2 int ∗p ;
3 int N;
4 void p e r m u t a c i o n e s ( int n ) {
5 int i , aux ;
6 i f ( n==0){ // S i n=0 imprime l a permutacion
7 for ( i =0; i <N; i ++)
8 p r i n t f ( " %d " , p [ i ] ) ;
9 p r i n t f ( "\n" ) ;
10 } e l s e { // Sino , r e a l i z a l o s i n t e r c a m b i o s
c o r r e s p o n d i e n t e s y e n t r a en r e c u r s i o n
11 for ( i =0; i <n ; i ++){
12 aux=p [ i ] ; // I n t e r c a m b i a l o s
v a l o r e s de p [ n−1] y p [ i ]
13 p [ i ]=p [ n − 1 ] ;
14 p [ n−1]=aux ;
15 p e r m u t a c i o n e s ( n−1) ; // Hace l a
l la ma da r e c u r s i v a
16 aux=p [ i ] ; //Pone l o s v a l o r e s de
p [ n−1] y p [ i ] en su l u g a r
17 p [ i ]=p [ n − 1 ] ;
18 p [ n−1]=aux ;
19 }
20 }
21 }
22 int main ( ) {
23 int i ;
24 s c a n f ( " %d" , \&N) ; // Lee e l tamaño d e l c o n j u n t o
de l a e n t r a d a
25 p=new int [N ] ;
26 for ( i =0; i <N; i ++) // I n i c i a l i z a e l c o n j u n t o

-- 72 of 315 --

5.3. PERMUTACIONES 73
27 p [ i ]= i +1;
28 p e r m u t a c i o n e s (N) ; // E j e c u t a l a r e c u r s i o n
29 return 0 ;
30 }
Nuevamente el código de la función es bastante corto aunque el resto del
programa hace el código mas largo.

-- 73 of 315 --

74 CAPÍTULO 5. BÚSQUEDA EXHAUSTIVA

-- 74 of 315 --