# PRECONDICI´ON:

* depende de las definiciones que se den a las partes
-}
{
IniciarRecorrido()
-- todo lo necesario para recorrer los elementos:
-- ubicarse en el primero de ellos,
-- preparar lo que haga falta, etc.
while (not llegoAlUltimoElemento())
-- todav´ıa falta procesar elementos
{
ProcesarElementoActual() -- procesa de alguna forma
-- el elemento actual
PasarAlSiguiente() -- pasar al siguiente elemento
}
FinalizarRecorrido()
-- termina el recorrido, cerrando lo necesario
-- y completando el trabajo
}
Los procedimientos utilizados en este c ´odigo son operaciones gen ´ericas (al igual
que sus nombres), y deben reemplazarse por las operaciones correspondientes
a la secuencia de elementos que quiere recorrerse. Por ejemplo, en el caso de
PintarColumna, la correspondencia entre las operaciones gen ´ericas y las reales
es la siguiente:
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 148 of 312 --

149
Operaci ´on gen ´erica Operaci ´on real
IniciarRecorrido() CabezalAlTopeDeLaColumna()
ProcesarElementoActual() PintarCeldaDe(color)
PasarAlSiguiente() Mover(Sur)
FinalizarRecorrido() PintarCeldaDe(color)
llegoAlUltimoElemento() llegoALaBase()
Como se puede observar, puede haber variaciones entre el procedimiento gen ´eri-
co y el real, por ejemplo, agregando par ´ametros, o realizando una (o varias) ope-
raciones elementales (como Mover(Sur)), o incluso no realizando ninguna ope-
raci ´on. Sin embargo, lo importante del recorrido es que se encarga de recorrer y
procesar cada uno de los elementos de la secuencia considerada.
Definici ´on 4.2.2. Un recorrido es un esquema de programa que permite estruc-
turar una soluci ´on a un problema de procesamiento de cierta secuencia de ele-
mentos, sugiriendo el tipo de subtareas a considerar. Las subtareas gen ´ericas
de un recorrido se pueden denominar iniciar del recorrido, controlar si es ´ulti-
mo elemento, procesar elemento actual, pasar al siguiente elemento y finalizar
recorrido.
Los recorridos m ´as simples tendr ´an su complejidad en el procesamiento de los
elementos. Sin embargo, veremos en breve un caso de recorrido donde la mayor
complejidad se encuentra en pasar al siguiente elemento.
Actividad 13
Realice la correspondencia entre operaciones gen ´ericas y operaciones
reales en el procedimiento PintarTableroPorColumnas. Luego realice
la correspondencia para el procedimiento CabezalAlTopeDeLaColumna.
Tenga en cuenta que en este ´ultimo caso 3 de las operaciones no reali-
zan nada.
Una cuesti ´on interesante a considerar es que pueden existir varias formas dis-
tintas de considerar un problema con recorridos, seg ´un cu ´al sea la secuencia de
elementos que consideremos, y c ´omo dividamos las subtareas. Por ejemplo, en
el caso del problema de pintar el tablero, podemos elegir la opci ´on que acabamos
de presentar, donde estructuramos la soluci ´on como un recorrido por columnas
(en cada columna pintamos como un recorrido por filas), pero tambi ´en podemos
elegir otras opciones. Una alternativa sencilla ser´ıa considerar un recorrido por
filas en lugar de uno por columnas. Otra variante, algo m ´as compleja, pero que
resulta en menor cantidad de c ´odigo, es utilizar un recorrido por celdas.
Actividad de Programaci ´on 14
Modifique el c ´odigo del programa del ejercicio 4.2.6 para que en lugar de
hacer el recorrido por columnas, lo haga por filas. ¡No olvide modificar
los nombres de los procedimientos y los comentarios adecuadamente!
Para abordar el problema de pintar el tablero mediante un recorrido por celdas,
las preguntas pertinentes son cu ´al ser ´a la primera celda a pintar y c ´omo deter-
minamos cu ´al es la siguiente en cada caso. Las respuestas a estas preguntas
determinar ´an los restantes elementos del recorrido. Supongamos que elegimos
que la primera celda ser ´a la de la esquina suroeste, y que las celdas ser ´an re-
corridas de Oeste a Este y de Sur a Norte, en ese orden. Entonces, el c ´odigo
quedar´ıa as´ı
procedure PintarTableroPorCeldasNE(color)