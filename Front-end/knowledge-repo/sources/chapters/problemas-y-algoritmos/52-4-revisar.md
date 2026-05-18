# 4. Revisar

Como bien se podrá dar cuenta el lector, estos 4 pasos no son un buen
resúmen de cómo resolver problemas, principalmente porque la parte de en-
contrar la solución suele ser mucho mas complicada que las otras 3 juntas.
Sin embargo, eso no debe de provocar que les prestemos menos atención
a los otros 3 pasos en el momento de resolver un problema, cada uno de estos
4 pasos es igualmente importante a pesar de que algunos de ellos son fáciles.

-- 297 of 315 --

298

-- 298 of 315 --

Cap´ıtulo 22
Entendiendo el Problema
Lo primero que hay que hacer para resolver un problema es entenderlo,
suena como algo bastante obvio, y realmente es obvio que antes de resolver un
problema primero hay que entenderlo. Sin embargo es necesario tener claro
cuándo un problema ya se entendió adecuadamente.
La clave es la siguiente: un problema ya se entendió adecuadamente cuan-
do es posible construir un modelo matemático del problema, además de decir
objetivamente y sin rodeos qué es lo que se sabe de antemano(los datos) y qué
es lo que se quiere saber(las incógnitas) en términos del modelo matemáti-
co(no en terminos de la descripción del problema original).
Para dejarlo mas claro: alguien que no haya leido el problema debería
de ser capáz de resolverlo sabiendo los datos, las incógnitas y el modelo
matemático.
A pesar de que este paso es de vital importancia y aparentemente sencillo,
muchas veces es subestimado y es omitido erróneamente. Tal es el caso co-
tidiano del estudiante al cual se le presenta un problema y después de leerlo
sin hacer ningún intento se declara incapáz de resolverlo porque no sabe qué
hacer.
Ahora bien, si al lector alguna vez le sucede algo similar, que luego de
leer un problema no sepa por donde empezar, lo primero que debe de hacer
es empezar por identicar los datos y las incógnitas, eso incluye decir
en términos objetivos(y de preferencia matemáticos) qué es lo que se está
buscando y qué es lo que se sabe de antemano además de eliminar información
supercial.
Vale la pena subrayar que la respuesta a la pregunta ¾Por dónde em-
piezo? siempre es: por identicar los datos y las incógnitas.
Vamos a resolver un ejemplo sencillo, de algo que para el lector le resul-
taría un ejercicio mas que un problema pero para niños de educación primeria
299

-- 299 of 315 --

300 CAPÍTULO 22. ENTENDIENDO EL PROBLEMA
les podría resultar un problema, el objetivo es ilustrar cómo un problema al
enterlo se transforma en un modelo matemático.
Problema Resuelto 22.0.1. Una naranja cuesta 2 pesos, una pera cuesta
5 pesos. Suponga que usted gastó 18 pesos y la cantidad de naranjas que
compró es el doble de la cantidad de peras. ¾Cuántas peras y cuántas naranjas
compró?
Solución Sin prestar mucha atención a los detalles rápidamente llegamos
a este sistema de ecuaciones:
2x + 5y = 18 (22.1)
2y = x (22.2)
Y posteriormente se llegará a la respuesta: 2 paras y 4 naranjas.
Si prestamos algo de atención, en el momento que al número de naranjas
les llamamos x, que al número de peras les llamamos y y que planteamos las 2
ecuaciones, estamos olvidándonos de que hablabamos de peras y de naranjas.
Incluso nos estamos olvidando de la moneda con la cual se realiza la
compra y una vez que planteamos la primera ecuación ya no es necesario ni
siquiera recordar los precios.

De esta manera el proceso de entender un problema es el mismo que el
de convertir el enunciado del problema en variables con un comportamiento
bien denido.
También hay que cuidarse de evitar asumir demasiadas cosas en el mo-
mento de entender un problema, y qué mejor manera de mostrar que esto
puede suceder a través de un ejemplo:
Problema Resuelto 22.0.2. Dos padres y sus respectivos dos hijos se
comieron un pastel, y nadie mas comió de él ¾Es posible que en total hayan
comido de ese pastel 3 personas?
Solución Es posible que el lector se vea tentado a asumir que los 2 padres
son personas distintas de los 2 hijos y que por tanto hay 4 personas.
Revisemos nuevamente el texto, nos dice que hay 3 personas en total, las
cuales las podemos representar por 3 vértices llamados A, B y C.
Podemos representar este problema como un grafo, donde lo que se quiere
encontrar es una manera de encontrar 2 aristas dirigidas de manera que 2

-- 300 of 315 --

301
vértices tengan grado de salida 1, 2 vértices tengan grado de entrada 1 y que
no haya ciclos.
Los vértices con grado de salida 1 son los padres, los que tienen grado de
entrada 1 son los hijos y a es hijo de b si existe una arista desde b hasta a.
Claramente no es necesario tener en cuenta todo este tecnicismo para
resolver el problema, simplemente se está haciendo notar que ya no importa
si lo que estamos imaginando son personas o animales, ya nos olvidamos del
pastel, etc.
El problema nos dice además que entre ellos hay 2 padres, sin pérdida de
generalidad diremos que son A y B. Y además hay 2 hijos, dichos 2 hijos no
pueden ser también A y B puesto que para que sucediera alguno debería de
ser padre de sí mismo o padre de su hijo.
Por principio de las casillas entre A y B hay al menos un hijo de A o de
B, nuevamente sin pérdida de generalidad diremos que B es hijo de A, como
A no puede ser hijo de B y hay en total 2 hijos entonces C es hijo de B.
Por lo tanto si es posible.

El ejemplo anterior, debido a que se presta a malos entendidos, podría
ser considerado una adivinanza en lugar de un problema.
Otra cosa que puede suceder es que no se sepa qué datos tomar en cuenta
y qué datos son supericiales, en el primer ejemplo(el de peras y manzanas)
al plantear las ecuaciones nunca se tomó en cuenta que las variables eran
enteros no negativos, ni tampoco se acotaron considerando cuál podía ser el
máximo de peras o manzanas que pudiera haber en una tienda.
Una estrategia útil para esos casos es tomar los datos que aparentemente
sean importantes, y si resultan insucientes regresar a la descripción del
problema y buscar mas datos.
El siguiente ejemplo es un problema que no se presta a malinterpretar
pero plantear el modelo matemático no es trivial y será necesario hacer uso
de la estrategia de abstraer datos y luego volver por ellos.
Problema Resuelto 22.0.3. Dos amigos(a los cuales llamaremos A y B)
se reencontraron después de mucho tiempo sin verse, luego de saludarse, A
decide platicar sobre su vida:
-Tengo 3 hijas- dijo A.
-Muy bien, ¾Qué edades tienen?- preguntó B.
-Para hacerlo mas interesante -continuó A-, te lo voy a plantear como un
acertijo: Si multiplicas sus edades obtendrás 36 y si las sumas obtendrás el
número de ventanas de este edicio.

-- 301 of 315 --

302 CAPÍTULO 22. ENTENDIENDO EL PROBLEMA
B contó con mucho cuidado el número de ventanas y después de pensar
un rato le dijo a A:
-Estoy seguro que me falta un dato.
-½Es cierto!, lo olvidaba -contestó A-, la mayor de ellas toca el piano.
Luego de eso, B logró saber qué edades tenían las hijas de A. Ahora te
toca averigüarlo a ti.
Nota: Todas las edades estan expresadas como cuántos cumpleaños ha
tenido cada hija y ninguna cumple el 29 de Febrero.
Solución Como se ha hecho incapié a lo largo de este capítulo, para en-
tender el problema es necesario poder decir cuáles son los datos y cuáles las
incógnitas, así que empezaremos por ahí.
Necesitamos encontrar 3 enteros no negativos a, b y c.
Respecto a los datos, sabemos que abc = 36, pero el resto de los datos
son difíciles de abstraer.
Sabemos que a + b + c es el número de ventanas de un edicio pero no
sabemos de qué edicio así que parecería un dato inútil.
Además sabemos que la hija mayor toca el piano, nuevamente parece
un dato inútil ya que no nos importa mucho saber que toca el piano para
averigüar su edad (este problema no trata de usar cuál es la edad mínima
para tocar el piano), pero un dato importante que podríamos pasar por alto
es que existe una hija mayor(en otro caso podría suceder que dos gemelas
fueran mayores que una tercera hermana y además ).
Dada la dicultad para saber qué datos pueden ser útiles y qué datos no
lo son; vericaremos si los datos que hemos identicado son sucientes para
resolver el problema y luego volveremos a la descripción en caso de que no
sean sucientes, ya que para poder avanzar en la solución del problema hay
que trabajar con un modelo matemático y no con una descripción parecida
a un cuento.
Dado que abc 6 = 0 y sabemos que a 6 = 0, b 6 = 0 y c 6 = 0.
Sin pérdida de generalidad diremos que a 6 = b 6 = c.
La factorización en primos de 36 es 36 = 2232.
Usando la factorización en primos podemos encontrar todas las ternas
que cumplen estas condiciones: (1, 1, 36), (1, 2, 18), (1, 3, 12), (1, 4, 9), (1,
6, 6), (2, 2, 9), (2, 3, 6), (3, 3, 4).
El otro dato que tenemos es que hay una hija mayor, es decir a 6 = b <
c(nótese la desigüaldad estricta), eso sólo nos hace descartar la terna (1, 6,
6), y aún hay 7 soluciones posibles.
En este momento ya podemos asegurar que si el problema está bien
planteado entonces no tomamos en cuenta todos los datos.

-- 302 of 315 --

303
Volviendo a revisar la descripción, nos damos cuenta que B sabía cuánto
valía a+b+c y aún así le faltaba un dato. Es decir, sea z = a+b+c, sabemos
que el siguiente problema tiene mas de una solución:
Encontrar enteros no negativos a ≤ b ≤ c tales que abc = 36 y a+b+c = z.
Observando las ternas que encontramos, podemos darnos cuenta que el
único posible valor de z con el cual podrían haber 2 ternas distintas es z = 13,
y las ternas son (1, 6, 6) y (2, 2, 9), para cualquier otro valor de z hay una
única terna o no hay ternas.
Así que z = 13, y como a ≤ b < c entonces a = 2, b = 2 y c = 9.

Por último no sobra hacer notar que hay que tener mayores precausiones
al enteder el problema que al resolverlo; el motivo es que una mala inter-
pretación del problema puede conducir a perder mucho mas tiempo que
cualquier otro error.
Es decir, si se comete un error de implementación es necesario volver a
revisar el código, si se comete un error al encontrar el algoritmo es necesario
volver a implementar, y luego volver a revisar pero si se comete un error
al entender el problema es necesario volver a encontrar la solución, volver a
implementar y volver a revisar.
De todos los errores posibles, el no entender adecuadamente el problema
es el que tiene consecuencias mas graves.

-- 303 of 315 --

304 CAPÍTULO 22. ENTENDIENDO EL PROBLEMA

-- 304 of 315 --

Cap´ıtulo 23
Encontrando la solución
Este sin duda es el paso mas difícil de todos, y al cual están dedicadas
casi todas las herramientas que se mencionan en este libro.
En el capítulo anterior se pusieron ejemplos de problemas que nada tenían
que ver con programación, eso fué adecuado ya que simnplicó la tarea y
el paso de entender un problema mediante la abstracción es el mismo sin
importar si se trata de un problema de programación o no.
Pero en este capítulo vamos a restringirnos a problemas de programación,
principalmente porque ya hay literatura que habla de problemas en general
y hay algunas técnicas que son útiles sólo en problemas de programación.
23.1. Las Dimensiones del Problema
Informalmente hablando, la palabra dimensión corresponde a todo aque-
llo que puede variar en el problema, en general se reere a los datos de entrada
junto con los rangos donde pueden estar, los datos de salida junto con sus re-
spectivos rangos y a veces es conveniente aumentar dimensiones implíscitas,
esto con el objetivo de hacer más manejable el problema.
Problema Resuelto 23.1.1. Identicar las dimensiones de este problema:
Tienes 0 ≤ N ≤ 10000 pares de coordenadas (xi, yi), (ai, bi) con 0 ≤
xi, ai, yi, bi ≤ 100000, dichas coordenadas representan las esquinas opuestas
de N rectángulos paralelos a los ejes. Hay que encontrar el número de rec-
tángulos que tienen la misma área.
Solución Las dimensiones de entrada son 0 ≤ N ≤ 10000, 0 ≤ xi, yi, ai, bi ≤
100000, es decir, hay 5 dimensiones de entrada.
305

-- 305 of 315 --

306 CAPÍTULO 23. ENCONTRANDO LA SOLUCIÓN
Sólo hay una dimensión de salida, y esta consiste en un único número
entero 0 ≤ n ≤ 100000.
Respecto a dimensiones implíscitas, es probable que para resolver el prob-
lema necesitemos calcuolar el área de cada rectángulo y por tanto también
necesitaríamos saber el ancho y el alto; estos datos son fáciles de calcular a
pesar de que no son parte de la entrada.
Tenemos que tanto el ancho como el alto están entre 0 y 100 000, sin
embargo el área está entre 0 y 1010, esto podría causar un desbordamiento si
no lo hubiéramos tomado en cuenta.

Una vez identicadas todas las dimensiones del problema escríbelas y así
podrás darte una idea aproximada de qué tan complicado es el problema.
23.2. Dibuja Una o Varias Figuras
A lo largo de este libro, se ha omitido este paso en todas las soluciones,
principalmente porque plasmar las guras en un libro es mas complicado que
hacerlo a mano y las guras rara vez sirven para justicar algo.
Si bien deberías de ser capáz de explicar la solución nal del problema sin
necesidad de una gura, algo que es cierto es que las guras son una buena
fuente de ideas.
La explicación de por qué las guras resultan útil no es muy sorpren-
dente: se utilizan distintas áreas del cerebro para procesar imágenes que para
razonar verbalmente. Además las guras muestran muchas propiedades del
problema que no es fácil mantener en la memoria de acceso inmediato, así
que mientras se mira una gura se pueden tener mas cosas en mente simul-
taneamente.
También hay que tener en cuenta que una sola gura normalmente no es
suciente, casi siempre es necesario dibujar varias guras; lo que debes hacer
es pensar en muchos posibles casos y dibujar varios de ellos, trata de que no
sean casos muy parecidos para evitar que te den ideas falsas.
Además de todo eso, hay varias formas grácas de representar una mis-
ma idea, por ejemplo, si en un problema te piden encontrar una secuencia
de números enteros, podrías escribir una secuencia, dibujar una gráca de
barras, dibujarlos como una secuencia de puntos sobre la recta numérica,
etc.
No te estanques en una sola representación ya que muchas veces la solu-
ción a un problema es fácil de ver con la representación adecuada, y la única

-- 306 of 315 --

23.3. LIBRO INCOMPLETO Y DÓNDE CONTINUAR LEYENDO 307
manera de que sea probable que veas la representación adecuada en cualquier
problema es que dibujes los datos de muchas maneras posibles.
23.3. Libro Incompleto y Dónde Continuar Leyen-
do
Aquí termina el lo que he escrito del libro, pero no el contenido, espero
continuar con este capítulo y esta parte en el futuro; mientras tanto se puede
leer un texto que habla de algo parecido:
http://www.mii.lt/olympiads_in_informatics/pdf/INFOL018.pdf

-- 307 of 315 --

308 CAPÍTULO 23. ENCONTRANDO LA SOLUCIÓN

-- 308 of 315 --