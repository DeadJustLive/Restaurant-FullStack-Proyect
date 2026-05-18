# 8. Documentaci´on.

-- 68 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 67
Para el caso del que se ocupa este libro, se trabajar´an los tres primeros
pasos planteados en la lista anterior.
Definici´on del problema. Se debe establecer claramente cu´al es el
problema a solucionar. Para el caso de este texto, esta etapa la cubren
los enunciados que se plantean para cada uno de los ejemplos que se
desarrollar´an; en la pr´actica profesional, estar´a cubierta por las necesidades
que expresen los clientes.
Para poder pasar a la siguiente etapa, es importante tener claro que lo
que se va a resolver debe estar dentro de los conocimientos del dise˜nador
del algoritmo y as´ı pueda abordar la construcci´on de una soluci´on. En
caso de no poseer los conocimientos suficientes, se debe buscar ayuda de
personas expertas en el tema, generando un trabajo interdisciplinario, que
por cierto es una de las caracter´ısticas que tiene el dise˜no de algoritmos.
An´alisis del problema. Analizar es comprender. Para poder
emprender la b´usqueda de una soluci´on se debe comprender perfectamente
el problema planteado. Se debe identificar la informaci´on relevante y
descartar la que no aporte a la soluci´on. Una vez se entienda con claridad,
qu´e es lo que se debe solucionar, se procede a realizar el an´alisis de
la informaci´on que se posee. Esta etapa se fundamenta en encontrar la
respuesta a cuatro preguntas:
¿Cu´ales resultados se esperan?
¿Cu´ales son los datos disponibles?
¿Qu´e procesos hay que realizar?
¿Qu´e variables se deben utilizar?
Los resultados que se esperan, constituyen las salidas del algoritmo y
son el producto del proceso que realice. Todo algoritmo debe proporcionar
alg´un resultado. A pesar de que, en la ejecuci´on del algoritmo, la salida
es la ´ultima etapa, dentro de este an´alisis ser´a la primera, ya que con esta
informaci´on se podr´a tener la claridad suficiente de qu´e pasos se deben
realizar para llegar al objetivo final.
Los datos disponibles, se refiere al conjunto de datos que se tiene y
que se va a procesar para servir de insumo a la soluci´on del problema.
Estos datos disponibles, generalmente representan los datos de entrada
al algoritmo, aunque hay que hacer claridad que habr´a situaciones en
donde los algoritmos no tienen entrada de datos y los datos disponibles
son suministrados por alguna instrucci´on dentro del proceso a realizar.

-- 69 of 450 --

68 Fundamentos
En cuanto a los procesos, son todas las acciones a los que se someten
los datos disponibles para encontrar la soluci´on del problema. En esta
etapa se deben establecer las f´ormulas matem´aticas necesarias para realizar
los c´alculos correspondientes. Igualmente se establecen las condiciones y
decisiones que hacen parte del proceso. Cada una de las instrucciones que
se ejecutar´an, deben ser tenidas en cuenta en este punto, no solamente en
su funci´on, sino tambi´en en el orden l´ogico en que deben ser ejecutadas.
Con base en los puntos anteriores, se establecen las variables
requeridas para almacenar los valores de los datos disponibles, de los
resultados esperados y de las f´ormulas matem´aticas que se requieran,
adem´as se deben identificar todas las variables necesarias en la soluci´on. En
este punto, se hace necesario establecer el tipo de dato al que pertenecer´a
cada variable, de acuerdo al valor que deba almacenar.
Dise˜	no. Esta etapa se desarrolla luego de terminado el an´alisis; consiste
en la creaci´on del algoritmo que soluciona el problema, para ello se utiliza
alguna de las t´ecnicas de representaci´on (descripci´on narrada, diagramas
de flujo o pseudoc´odigo).
Para convertirlos a algoritmos, los enunciados deben ser minuciosamente
analizados por el dise˜nador. Algunos, enunciados no proporcionan
expl´ıcitamente lo que se requiere, es ah´ı donde est´a la habilidad del
dise˜nador para sacar el m´aximo provecho e informaci´on relevante para
codificar la soluci´on. A manera de ejemplo, se analizar´a el siguiente
enunciado.
El profesor de F´ısica Mec´anica, desea que cada uno de sus estudiantes
puedan calcular, mediante un algoritmo, la velocidad con que se desplazan
de su casa a la Universidad. Todos los estudiantes deben medir la distancia
que recorren y tomar el tiempo que invierten en ´el.
De este enunciado hay que tener en cuenta lo siguiente:
No proporcion´o la f´ormula para el c´alculo de la velocidad. Por lo
cual, es un dato que se tendr´a que investigar de forma adicional.
El enunciado no deja expl´ıcito qu´e informaci´on o dato debe
mostrarse, pero al solicitar ´unicamente el c´alculo de la velocidad,
se puede deducir que se debe informar ese resultado. En algunas
ocasiones, no todos los c´alculos deben ser informados, algunos son
c´alculos intermedios que ser´an utilizados en otras f´ormulas.
Es importante determinar cu´ales son los datos relevantes para hallar
la soluci´on y cu´ales no representan ning´un aporte. Por ejemplo, el

-- 70 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 69
hecho que sea un profesor de F´ısica Mec´anica, no es significativo
para la soluci´on.
Una vez analizadas estas caracter´ısticas, la aplicaci´on de los pasos para
solucionar el problema planteado en el ejemplo, se ejecuta as´ı:
Resultado esperado: la velocidad.
Al poseer la informaci´on de cu´al es el resultado que el algoritmo debe
informar, se procede a revisar con que datos de entrada se cuenta, los cuales
ser´an uno de los insumos primordiales en el proceso.
Datos conocidos: distancia y tiempo invertidos en el recorrido,
considerando las respectivas unidades.
Proceso: calcular la velocidad, teniendo en cuenta los datos disponibles.
Para realizar este c´alculo se requiere de una f´ormula, la cual no fue
proporcionada por el enunciado y que debe ser investigada para poder
plantear la soluci´on. En este ejemplo, si no se recuerda la f´ormula que es
ense˜nada en los cursos de f´ısica que se recibieron en el Colegio, conseguirla
es un proceso simple, basta con consultar un libro de f´ısica mec´anica o en
un motor de b´usqueda en Internet. Se presentar´an situaciones, en donde
el problema a resolver es un poco m´as complejo y se requerir´a el trabajo
conjunto con otros profesionales de diferentes ´areas del conocimiento.
Retomando el ejercicio y teniendo en cuenta que se posee la distancia
(x) y el tiempo (t), la f´ormula a la que se hace referencia para hallar la
velocidad (v) es la siguiente: v = x
t , que al escribirla como una expresi´on
algor´ıtmica se visualiza as´ı: v = x/t
No olvide que las f´ormulas en su notaci´on matem´atica, deben ser
convertidas en su notaci´on algor´ıtmica.
El siguiente paso, es definir las variables que se emplear´an en el
algoritmo.
Variables requeridas: en vista de que esta f´ormula y sus variables son
conocidas universalmente, en este caso se usar´an tal cual est´an expresadas.
v: velocidad.
x: distancia.
t: tiempo.

-- 71 of 450 --

70 Fundamentos
Los valores que se van a almacenar podr´an tener cantidades decimales,
por lo tanto, se trabajar´an de tipo Real.
Antes de pasar a la etapa del dise˜no del algoritmo y con el prop´osito de
dar mayor claridad a algunos conceptos estudiados anteriormente, se usar´a
este ejemplo para ilustrar mediante la Figura 1.17 las 3 etapas que tiene
un algoritmo.
Proceso Salida	Entrada
v = x/t v	x , t
Figura 1.17: Las tres etapas de un algoritmo
Una vez realizado el an´alisis del problema, el siguiente paso es dise˜	nar
el algoritmo, para ello se utilizar´an las 3 formas m´as comunes de
representaci´on.
Primera forma de representaci´on: descripci´on narrada
1 Algoritmo
2 Leer la distancia recorrida.
3 Leer el tiempo empleado en recorrer esa distancia.
4 Calcular la velocidad, empleando la f´ormula.
5 Informar el resultado del c´alculo (la velocidad).
6 FinAlgoritmo
La palabra Algoritmo, marca el comienzo del algoritmo. Entre las
l´ıneas 2 y 5, se encuentra descritas las instrucciones que solucionan el
problema. La palabra FinAlgoritmo de la l´ınea 6, se˜nala el fin de la
ejecuci´on de este algoritmo. Este tipo de soluci´on no es f´acil de traducir
a un lenguaje de programaci´on, como lo es un diagrama de flujo o un
pseudoc´odigo.
Ahora, para dise˜nar este mismo algoritmo usando diagramas de flujo
(Ver Figura 1.18) o pseudoc´odigo, es necesario tener presente que
se requiere del uso de algunas palabras reservadas o s´ımbolos para
representar los pasos. En las Tablas 1.13, 1.14 y 1.15 se mostrar´an los
s´ımbolos correspondientes a los diagramas de flujo y sus equivalencias en
pseudoc´odigo.

-- 72 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 71
Para la entrada o lectura de los datos conocidos:
Diagrama Flujo Pseudoc´odigo Explicaci´on
x leer ( x )
Captura el valor de la
distancia y lo almacena en
la variable x
t leer ( t )
Captura el valor del tiempo
y lo almacena en la variable
t
Tabla 1.13: Entrada de datos conocidos
El c´alculo de la velocidad se expresa as´ı (Proceso):
Diagrama Flujo Pseudoc´odigo Explicaci´on
v = x / t v = x / t
Calcula la velocidad (v),
dividiendo la distancia (x)
sobre el tiempo (t); el
resultado lo almacena en v.
Tabla 1.14: C´alculo (Proceso)
Para la salida o resultados esperados se procede de la siguiente
manera:
Diagrama Flujo Pseudoc´odigo Explicaci´on
v imprimir ( v ) Informa o muestra el valor
que est´e almacenado en
la variable v, el cual
corresponde a la velocidad
calculada.
Tabla 1.15: Entrega de resultados esperados
Con todas estas instrucciones, se puede obtener entonces el algoritmo que
encuentra la velocidad, teniendo como datos de entrada la distancia y el
tiempo. A continuaci´on, se presentan las versiones completas en diagrama
de flujo y pseudoc´odigo.

-- 73 of 450 --

72 Fundamentos
Segunda forma de representaci´on: diagrama de flujo
Inicio
x
t
v = x / t
v
Final
Figura 1.18: Diagrama de flujo Velocidad
A continuaci´on, se presentan las versiones completas en pseudoc´odigo.
Tercera forma de representaci´on: pseudoc´odigo - Versi´on 1
1 Algoritmo Velocidad
2 Real v, x, t
3 leer( x )
4 leer( t )
5
6 v = x / t
7
8 imprimir( v )
9 FinAlgoritmo
A diferencia de la soluci´on que se present´o a trav´es el diagrama de flujo,
en esta versi´on en pseudoc´odigo se hizo la declaraci´on de variables (l´ınea 2),
con esto se le especifica al algoritmo que habr´an 3 posiciones de memoria
de tipo Real, llamadas v,x y t, en las cuales se almacer´an los datos que
requieren para solucionar el problema planteado.
La anterior versi´on en pseudoc´odigo puede ser mejorada, incluyendo
algunos mensajes con la instrucci´on imprimir, que ser´an de ayuda para
el usuario del algoritmo. Con ellos se solicitar´a la distancia y el tiempo, de

-- 74 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 73
igual forma la salida se acompa˜nar´a de un mensaje que proporcione m´as
informaci´on.
Tercera forma de representaci´on: pseudoc´odigo - Versi´on 2
1 Algoritmo Velocidad
2 Real v, x, t
3
4 imprimir( "Ingrese la distancia: " )
5 leer( x )
6 imprimir( "Ingrese el tiempo: " )
7 leer( t )
8
9 v = x / t
10
11 imprimir( "La velocidad es: ", v )
12 FinAlgoritmo
Al ejecutar este algoritmo, suponiendo que la distancia es de 300 metros
y el tiempo empleado es de 15 minutos, se observar´a lo siguiente:
Ingrese la distancia: 300
Ingrese el tiempo: 15
La velocidad es: 20
En los siguientes cap´ıtulos, se profundizar´a en el desarrollo de algoritmos.
Aclaraci´on:
En la versi´on en pseudoc´odigo se hace la declaraci´on
de variables, en los diagramas de flujo no se requiere.
La impresi´on de mensajes tambi´en se puede hacer
dentro de los diagramas de flujo.
1.9. Ejercicios propuestos