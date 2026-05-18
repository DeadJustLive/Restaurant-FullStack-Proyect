# 14 ÍNDICE GENERAL

-- 14 of 315 --

Parte I
Recursión
15

-- 15 of 315 --



-- 16 of 315 --

17
La recursión es uno de los temas mas básicos en el estudio de los algo-
ritmos. De hecho, muchas veces(no siempre) es el primer tema tratado en lo
que se reere a resolver problemas de programación.
Esto de primer tema puede parecer un poco confuso, ya que para llegar
a recursión es necesario de antemano ya saber programar.
Es primer tema en lo que se reere a resolver problemas, lo cual no trata
de saber cómo escribir una solución en una computadora, trata de saber cómo
encontrar soluciones.
El conocimiento de un lenguaje de programación se limita a expresiones
lógicas para expresar las ideas en una computadora y eso no es encontrar una
solución sino simplemente saber describir la solución.
Podría parecer para algunos una pérdida de tiempo leer acerca de cómo
encontrar soluciones a problemas, y pueden también estarse preguntando ¾No
basta con ser inteligente para poder encontrar la solución a un problema?.
En teoría es cierto que cualquiera podría llegar a la solución de un proble-
ma simplemente entendiendo el problema y poniéndose a pensar. Sin embar-
go, en la práctica, pretender resolver un problema de cierto nivel sin haber
resuelto nunca antes problemas mas fáciles resulta imposible.
En el entendimiento claro y la buena aplicación de la recursión descansan
las bases teóricas y prácticas de buena parte(casi me atrevería a decir que de
la mayoría) de los algoritmos que se aprenden mas adelante.
Esto no quiere decir que las implementaciones recursivas sean la respues-
ta para todo ni para la mayoría; pero un razonamiento partiendo de una
recursión es con mucha frecuencia utilizado para implementar algoritmos no
recursivos.

-- 17 of 315 --

18

-- 18 of 315 --

Cap´ıtulo 1
Inducción Matemática
La inducción matemática no es mas que el uso de razonamientos recur-
sivos para comprobar cosas. Aún no hemos denido que quiere decir recur-
sivo, sin embargo el buen entendimiento de la inducción puede ser un buen
escalón para la recursión en general.
También hay que tomar en cuenta que la inducción es un tema muy im-
portante(y desgraciadamente muy subestimado) para el entendimiento cor-
recto de los algoritmos y en algún momento es conveniente tratarlo, por ello
comenzaremos con el uso y la denición de la inducción matemática, que es
algo bastante simple, para luego generalizarlo en la recursión.
En el momento de resolver problemas, es muy importante observar propiedades,
y si no se está seguro si una propiedad es cierta, la inducción puede servir
más de lo que se pueda imaginar.
Es importante mencionar que la inducción sirve para probar proposi-
ciones, es decir, enunciados que declaran que algo es verdadero o falso(nunca
ambas cosas a la vez ni tampoco un término medio).
En todo el libro trabajaremos con proposiciones, ya que es la forma mas
simple de pensar y de hacer buenos razonamientos sin tener duda alguna al
respecto.
Empezaremos probando un ejemplo sencillo, luego pasaremos a ejem-
plos mas complejos para posteriormente denir formalmente la inducción
matemática.
También, aprovecharemos esta sección para poner como ejemplos algunas
propiedades que luego serán muy útiles en el momento de resolver algunos
problemas.
Antes de continuar es importante mencionar que en este libro se utilizarán
puntos suspensivos(...) en algunas fórmulas.
Estos puntos suspensivos deben de completar la fórmula con el patrón
19

-- 19 of 315 --

20 CAPÍTULO 1. INDUCCIÓN MATEMÁTICA
que se muestra. Por ejemplo:
1 + 2 + 3 + ... + 9 + 10 signica 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
1.1. Ejemplos de Inducción
Problema Resuelto 1.1.1. Prueba que para todo entero n ≥ 1
1 + 2 + 3 + 4 + 5 + ... + n − 1 + n = (n)(n + 1)
2
Solución Si analizamos un poco ,la proposición para todo entero n ≥
1, 1 + 2 + 3 + 4 + 5 + ... + n − 1 + n = (n)(n+1)
2 , quiere decir que dicha
propiedad debe ser cierta para n = 1, para n = 2, para n = 3, para n = 4,
para n = 5, etc...
Podemos comenzar vericando que es cierto para los primeros enteros
positivos:
(1)(1 + 1)
2 = 1
(2)(2 + 1)
2 = 3 = 1 + 2
(3)(3 + 1)
2 = 6 = 1 + 2 + 3
...
Esta claro que si tratamos de aplicar este procedimiento para todos los
números enteros positivos nunca acabaríamos a menos que encontráramos
un número en el que no se cumpliera la proposición(lo cual no podemos
asegurar).
Aquí muchos se sentirían tentados a pensar esto es cierto porque funciona
en todos los casos que veriqué. Esa no es la salida correcta, y no sólo es un
capricho teórico, ya que en la práctica se pueden cometer errores bastante
serios si ingenuamente se cree que vericar varios casos pequeños es suciente
para estar seguro de algo.
Por ejempo, la proposición x2 + x + 41 es primo cuando x es entero
positivo puede resultar engañosa, ya que si vericamos con varios valores de
x, el resultado parecerá que siempre es primo

-- 20 of 315 --

1.1. EJEMPLOS DE INDUCCIÓN 21
para x=1 sucede que (1)2 + (1) + 41 = 43 (1.1)
para x=2 sucede que (2)2 + (2) + 41 = 47 (1.2)
para x=3 sucede que (3)2 + (3) + 41 = 53 (1.3)
para x=4 sucede que (4)2 + (4) + 41 = 61 (1.4)
Notamos que 43, 47, 53 y 61 son primos, por tanto esto nos puede tentar
a creer que esa expresión produce un primo para cualquier entero positivo x.
Pero ahora, examinemos que sucede cuando x = 40:
(40)2+40+41 = (40)(40)+40+41 = 40(1+40)+41 = 40(41)+41 = 412 (1.5)
Es obvio que 412 no es primo; por lo tanto la proposición es falsa. En
realidad pudimos haber vericado con 39 casos(x = 1, x = 2, ..., x = 39) y en
todos habría funcionado.
Este fue un claro ejemplo de como muchas veces, lo que parece funcionar
siempre, no siempre funciona, en casos pequeños puede parecer que siempre
funciona, pero al llegar a casos mas grandes(algunos tan grandes que no se
pueden vericar manualmente), es inevitable que el error se haga presente.
Incluso hay ocasiones en las que se pueden vericar miles de casos(sin
exagerar) sin encontrar un ejemplo donde la proposición no se cumpla y que
a pesar de todo eso, la proposición sea falsa.
Otra razón para demostrar las cosas es que la solución completa de un
problema(la solución de un problema incluye las demostraciones de todas sus
proposiciones) puede servir para descubrir propiedades útiles para resolver
muchos otros problemas. Y es ahí donde resolver un problema realmente sirve
de algo.
Volviendo al tema, podemos transformar este problema de comprobar que
1 + 2 + 3 + 4 + 5 + ... + n − 1 + n = (n)(n+1)
2 en comprobar este conjunto
innito de proposiciones:
(1)(1 + 1)
2 = 1, (2)(2 + 1)
2 = 1+2, (3)(3 + 1)
2 = 1+2+3, (4)(4 + 1)
2 = 1+2+3+4, ...
Para hacerlo basta con probar las siguientes dos cosas:
Que la primera proposición es verdadera.
Que si una proposición es verdadera, la siguiente también lo es.

-- 21 of 315 --

22 CAPÍTULO 1. INDUCCIÓN MATEMÁTICA
Probar que la primera proposición es verdadera es realmente fácil:
(1)(1 + 1)
2 = (1)(2)
2 = 2
2 = 1
Ahora, suponiendo que para alguna n
(n)(n + 1)
2 = 1 + 2 + 3 + 4 + .... + n − 1 + n
vamos a probar que:
(n + 1)(n + 2)
2 = 1 + 2 + 3 + 4 + .... + n − 1 + n + n + 1
Es decir, vamos a probar que si se cumple con alguna n, se debe de cumplir
con n + 1.
Partimos de la ecuación inicial
(n)(n + 1)
2 = 1 + 2 + 3 + 4 + ... + n − 1 + n
Sumamos n + 1 en ambos lados de la ecuación
(n)(n + 1)
2 + n + 1 = 1 + 2 + 3 + 4 + ... + n + n + 1
(n)(n + 1)
2 + (2)(n + 1)
2 = 1 + 2 + 3 + 4 + ... + n + n + 1
Y sumando por factor común se concluye que:
(n + 2)(n + 1)
2 = 1 + 2 + 3 + 4 + ... + n + n + 1
La proposición es correcta con 1, y si es correcta con 1 entonces será
correcta con 2, si es correcta con 2 lo será con 3, si es correcta con 3 entonces
lo será con 4, y así sucesivamente.
Ahora, intentando ir en contra de nuestro sentido común, ¾es posible que
haya números para los cuales no se cumpla la proposición?, si existieran tales
números, también existiría el menor de esos números, llamémosle m, y al
ser m el menor entero positivo para el cual no se cumple la proposición, ten-
dríamos que para m−1 se cumple la proposición; pero ya comprobamos que si
se cumple para m − 1 entonces se debe de cumplir para m, lo cual es absurdo
puesto que denimos m como un número que no cumple la proposición.
No nos queda otra salida mas que aceptar que la proposición si se cumple
para todos los enteros positivos.


-- 22 of 315 --

1.1. EJEMPLOS DE INDUCCIÓN 23
Problema Resuelto 1.1.2. En una esta hay n invitados, se asume que
si un invitado conoce a otro, éste último conoce al primero. Prueba que el
número de invitados que conocen a un número impar de invitados es par.
Solución Nos encontramos ahora con un problema un poco mas abstracto
que el anterior. ¾Cómo tratar este problema?, primeramente sería conveniente
imaginar a las personas como puntos y si dos personas se conocen entre sí,
imaginar sus respectivos puntos unidos por una línea. Si no es suciente
imaginarlo es conveniente dibujar una gura.
Nuevamente imaginaremos el caso más simple que puede haber: una esta
en la que nadie se conozca, para la cual imáginamos una nube de puntos donde
no hay ningún par de puntos unidos por alguna línea.
En este caso, ¾cuántos invitados conocen a un número impar de invita-
dos?, la respuesta es obvia: ninguno, es decir, 0. Recordemos que el 0 es par,
y que si p es un número par p + 1 es impar, y p + 2 es par.
Ahora, si imaginamos en la esta que dos personas se presentan mutua-
mente(unimos dos puntos por una línea), habrá pues, 2 personas que conocen
a un solo invitado y las demás no conocen a nadie.
El número de invitados que conocen a un número impar de invitados será
2.
Nuevamente, si otras 2 personas que no se conocen entre sí se presentan
mutuamente, entonces el número de invitados que conocen a un número
impar de personas aumentará a 4.
Pero después de ello, ¾qué sucedería si una persona que conoce a un solo
invitado se presenta con una persona que no conoce a nadie? La persona que
no conoce a nadie conocería a un solo invitado, mientras que la persona que
ya conocía a un solo invitado, pasará a conocer a dos invitados.
Nótese que una persona que conocía a un número impar de invitados(conocía
a 1) pasó a conocer a un número par de invitados(acabó conociendo a 2), y
la que conocía a un número par de invitados(no conocía a ninguno) pasó a
conocer a un número impar de invitados(acabó conociendo a 1) ½el número
de personas que conocen a un número impar de invitados no cambió!.
Si nos olvidamos de las personas que se acaban de conocer, y solo sabemos
que el número de personas que conocen a un número impar de invitados es
par, si dos invitados que no se conocían, de pronto se conocieran, hay 3
posibilidades:
Una persona conoce a un número impar de invitados y la otra conoce
a un número par de invitados.
En este caso ambos aumentarán su número de conocidos en 1, el que
conocía a un número impar de invitados pasará a conocer a un número

-- 23 of 315 --

24 CAPÍTULO 1. INDUCCIÓN MATEMÁTICA
par de invitados, el que conocía un número par de invitados, pasará a
conocer un número impar de invitados. Por ello el número de personas
que conocen a un número impar de invitados no cambia y sigue siendo
par.
Ambas personas conocen a un número par de invitados.
En este caso, ambas personas pasarán a conocer a un número impar de
invitados. El número de personas que conocen a un número impar de
invitados aumenta en 2, por ello sigue siendo par.
Ambas personas conocen a un número impar de invitados.
En este caso, ambas personas pasarán a conocer un número par de
invitados. El número de personas que conocen a un número impar de
invitados disminuye en 2, por ello sigue siendo par.
Entonces, si al principio de sus vidas nadie se conoce, el número de per-
sonas que conocen a un número impar de invitados es par, y conforme se van
conociendo, el número seguirá siendo par. Por ello se concluye que siempre
será par.

Problema Resuelto 1.1.3. Prueba que para todo entero n ≥ 4, n! > 2n.
Solución Tal vez después de haber leído las soluciones de los dos primeros
problemas te haya sido más fácil llegar a la solución de este.
4! = (1)(2)(3)(4) = 24
24 = (2)(2)(2)(2) = 16
Ya comprobamos que 4! > 24, ahora, suponiendo que para alguna n
n! > 2n
proseguimos a comprobar que
(n + 1)! > 2n+1
Partiendo de la desigualdad inicial:
n! > 2n

-- 24 of 315 --

1.1. EJEMPLOS DE INDUCCIÓN 25
multiplicamos por n + 1 el miembro izquierdo de la desigualdad y multipli-
camos por 2 el lado derecho de la desigualdad. Como n + 1 > 2, podemos
estar seguros que el lado izquierdo de la desigualdad seguirá siendo mayor.
(n!)(n + 1) > (2n)2
Sintetizando:
(n + 1)! > 2n+1
Ello implica que si se cumple para un número n, también se cumple para
n + 1, como se cumple para 4, entonces se cumplirá para 5, y si se cumple
para 5, entonces se cumplirá para 6, etc. Se puede inferir que se cumplirá
para todos los números enteros mayores o iguales a 4.

Problema Resuelto 1.1.4. Prueba que para todo entero positivo n
12 + 22 + 32 + 42 + ... + n2 = n(n + 1)(2n + 1)
6
Solución Nuevamente comenzaremos por el caso mas simple, cuando n = 1
1(1 + 1)(2 + 1)
6 = 6
6 = 1
Ahora, suponiendo que para alguna n
12 + 22 + 32 + 42 + ... + n2 = n(n + 1)(2n + 1)
6
veremos que sucede si se le suma (n + 1)2 a ambos miembros de la ecuación
12 + 22 + ... + n2 + (n + 1)2 = n(n + 1)(2n + 1)
6 + 6(n + 1)(n + 1)
6
12 + 22 + ... + n2 + (n + 1)2 = (n + 1)(n(2n + 1) + 6n + 6)
6
12 + 22 + ... + n2 + (n + 1)2 = (n + 1)(2n2 + 7n + 6)
6
12 + 22 + ... + n2 + (n + 1)2 = (n + 1)(n + 2)(2(n + 1) + 1)
6
Nuevamente observamos que se cumple con 1, y si se cumple con n tam-
bién se cumplirá con n + 1 y por ello con todo número mayor n, por lo tanto
se cumple con todos los enteros positivos.

Problema Resuelto 1.1.5. Muestra que para cualquier cantidad de dinero
mayor a 7 centavos puede ser formada usando solo monedas de 3 centavos y
de 5 centavos.

-- 25 of 315 --

26 CAPÍTULO 1. INDUCCIÓN MATEMÁTICA
Solución La cantidad de 8 centavos puede ser formada con una moneda
de 3 y una de 5; la cantidad de 9 centavos puede ser formada con 3 monedas
de 9 centavos; la cantidad de 10 centavos puede ser formada con 2 monedas
de 5 centavos.
Suponiendo que para algún entero positivo a, tal que a > 7 fuera posible
formar las cantidades a, a + 1 y a + 2, si a cada una de esas cantidades se les
añade una moneda de 3 centavos, resuelta que también será posible formar
las cantidades a + 3, a + 4 y a + 5, es decir, para cualquier tercia de números
consecutivos que se pueda formar, tal que el menor de ellos sea mayor que 7,
la siguiente tercia también se podrá formar.
Con ello podemos asumir que cualquier tercia de números consecutivos
mayores a 7 se podrá formar y por ende, cualquier número entero positivo
mayor a 7.

Problema Resuelto 1.1.6. Prueba que si se tienen n personas, es posible
elegir de entre 2n − 1 grupos de personas distintos para hacer una marcha.
Por ejemplo, con 3 personas A, B y C se pueden elegir 7 grupos:
A
B
C
A, B
A, C
B, C
A, B, C

Solución Consideremos el caso de que solo hay una persona, con esta per-
sona, solamente se puede elegir un grupo(de un solo integrante) para la mar-
cha.
21 − 1 = 1
Ahora, suponiendo que con n personas se pueden elegir 2n − 1 grupos, para
algún entero n, un desconocido va pasando cerca de las n personas y se une
a ellas, puede formar parte de la marcha, o bien no formar parte.
Por cada grupo que se podía formar con a lo más n personas habrá otros 2
grupos con a lo más n + 1 personas(uno en el caso de que el nuevo integrante

-- 26 of 315 --

1.2. ERRORES COMUNES 27
participe y otro en el caso de que no participe).
Como la marcha se puede crear solamente con la persona que acaba de llegar.
Entonces con n + 1 personas habrá 2n+1 − 1 grupos que se pueden elegir.
Con ello queda demostrada la proposición.

1.2. Errores Comunes
A veces al estar intentando probar algo por inducción se llega a caer en
ciertos errores, algunos de los cuales se ejemplican a continuación proban-
do cosas que son obviamente falsas:
Proposición Todos los perros son del mismo color
Pseudo-prueba Si tenemos un solo perro, es trivial que es de su propio
color; ahora, si para algun entero positivo n todos los conjuntos con exacta-
mente n perros constaran de perros del mismo color entonces para cualquier
conjunto P con n perros, los cuales llamaremos:
p1, p2, ..., pn
Existirían 2 perros:
p1, pn+1
Tal que se cumpla que p1 forma parte del conjunto P y pn+1 pueda ser
cualquier perro que no esté en el conjunto P (a menos que P tuviera todos
los perros que existen en cuyo caso se cumpliría la proposición).
Por construccion tendríamos que p1 es del mismo color que pn+1(ya que
todos los conjuntos con n o menos perros tienen solamente perros del mismo
color), y que p1 es del mismo color que todos los perros de P , por lo que
p1, p2, ..., pn+1 serían perros del mismo color, y con esto se comprueba que si
cualesquiera n perros son todos del mismo color entonces cualesquiera n + 1
perros serían del mismo color.
Con inducción queda probado que todos los perros son del mismo color.


-- 27 of 315 --

28 CAPÍTULO 1. INDUCCIÓN MATEMÁTICA
Error Aquí se está suponiendo que se tienen n perros del mismo color, pero
implícitamente se está asumiendo que n ≥ 2 cuando se supone que cualquier
pareja de perros va a constar de perros del mismo color.
Está bastante claro que esta prueba es incorrecta, sin embargo errores
similares pero menos obvios pueden suceder en la práctica.
Siempre hay que vericar que si un caso se cumple el siguiente también
lo hará, así como vericar que se este usando el caso base adecuado(en el
ejemplo anterior se usó un caso base demasiado pequeño).

Existe otro error(menos común) en la inducción:
Proposición Todos los números enteros son iguales.
Pseudo-prueba Si para algún número entero k, k = k+1 entonces, suman-
do 1 en ambos lados de la ecuación, k + 1 = k + 2, por lo que por inducción
queda demostrado.

Error Aunque se está tomando en cuenta la segunda condición de la in-
ducción (que si un caso se cumple el siguiente también) no se está tomando
en cuenta la primera (que debe de existir un caso en el que se cumpla).

1.3. Denición de Inducción
Después de estos ejemplos le será posible al lector abstraer lo que tienen
en común y así hacerse de una idea clara de lo que es la inducción.
La inducción es un método para demostrar una proposición matemática
basándose en la vericación de la forma mas simple de la proposición y luego
comprobando que una forma compleja de la proposición se cumple siempre
y cuando una forma mas simple se cumpla.
O dicho de una manera mas formal, es un método para demostrar una
sucesión innita de proposiciones P0, P1, P2, ... demostrando que P0 es cierta
y posteriormente demostrando que si Pk es cierta entonces Pk+1 también lo
es.

-- 28 of 315 --

1.4. PROBLEMAS 29
1.4. Problemas
1.4.1. Sumas
Demuestra por inducción que:
1.
1 + 22 + 32 + 42 + ... + n2 = n(n + 1)(2n + 1)
6
2.
1 + 3 + 5 + ... + (2n − 1) = n2
3.
1 − 2 + 3 − 4 + 5 − 6 + ...n = (−1)n+1dn
2 e
4.
1 + 2 + 4 + ... + 2n = 2n+1 − 1