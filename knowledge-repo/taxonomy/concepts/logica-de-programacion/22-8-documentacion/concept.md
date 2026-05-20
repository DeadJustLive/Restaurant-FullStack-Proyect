# 8. Documentaci´on.

## Fuente
logica-de-programacion (Cap. 22)

## Contenido
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
hec
