# 14 ÍNDICE GENERAL

## Fuente
problemas-y-algoritmos (Cap. 14)

## Contenido
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
para x=1 sucede que (1)2 + (1) + 41 = 43 (
