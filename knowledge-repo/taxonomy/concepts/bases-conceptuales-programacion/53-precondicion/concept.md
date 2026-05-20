# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 53)

## Contenido
# PRECONDICI´ON:

* hay una ´unica celda que es el inicio del sendero
(indicada con 2 bolitas negras)
-}
{
IrALaEsquina(Sur,Oeste)
while(not esInicioDelSendero())
{
AvanzarASiguienteDelRecorridoDeCeldas(Norte,Este)
}
}
Este es un recorrido de b ´usqueda, y podemos observar varias cosas en ´el. La primera,
m ´as obvia, es que no hay que procesar la celda (m ´as que para visitarla) pues estamos
buscando una, y las que no son, no precisan procesamiento, ni tampoco hay que finalizar
el recorrido (porque al llegar, ya est ´a lo que hab´ıa que hacer). La segunda, m ´as sutil, es
que el recorrido corta al encontrar la celda buscada; o sea, en rigor, es un recorrido sobre
las celdas previas a la que buscamos. La ´ultima cosa a observar es que el procedimiento
AvanzarASiguienteDelRecorridoDeCeldas no es trivial, porque las celdas est ´an dispues-
tas en un cuadriculado; este procedimiento fue presentado cuando hablamos de pintar el
tablero recorriendo por celdas.
Definici ´on 4.2.3. Un recorrido de b ´usqueda es un esquema de recorrido que no recorre
la secuencia de elementos en su totalidad, sino que se detiene al encontrar el primer
elemento que cumple cierta condici ´on. En este caso, las tareas de procesar elemento
actual y finalizar recorrido no son necesarias, y la tarea de controlar si es ´ultimo elemento
se modifica para determinar si el elemento cumple la propiedad buscada.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 154 of 312 --

155
G.4.4. Sendero simple del gr ´afico G.4.3 con rosas en toda su extensi ´on
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 155 of 312 --

156
Si queremos ser precisos, en realidad un recorrido de b ´usqueda procesa la secuencia de
elementos m ´as larga (de una secuencia base) que no cumple la propiedad buscada, dete-
ni ´endose en el primer elemento que s´ı cumple. Sin embargo, es m ´as com ´un considerarlo
un recorrido sobre toda la secuencia base, con el control de finalizaci ´on modificado.
Actividad de Programaci ´on 19
Modifique el c ´odigo del procedimiento BuscarInicioDelSendero en el
ejemplo anterior para que sea como el que acabamos de mostrar
(un recorrido de b ´usqueda), y luego vuelva a probar el procedimiento
PonerFloresEnSenderoSimple en un tablero que contenga un sendero simple
diferente al del ejemplo anterior (y con el inicio en un lugar diferente a la esquina
suroeste).
Volveremos a revisar la idea de recorrido una vez que hayamos presentado una de las
herramientas m ´as poderosas (y m ´as complejas de utilizar) que tienen los lenguajes de
programaci ´on: la memoria. Mediante la combinaci ´on de recorridos y memoria podremos
resolver varios problemas que de otra forma ser´ıan extremadamente engorrosos (o direc-
tamente imposibles) de realizar. ¡Nuevamente se observar ´a la necesidad de herramientas
poderosas en los lenguajes de programaci ´on, para lograr descripciones adecuadas a los
prop ´ositos buscados!
4.3. Memorizaci ´on de datos
Es notable, hasta el momento, que cuando el cabezal se mueve por el tablero, no tenemos
una forma de “recordar” informaci ´on, tal como el n ´umero de bolitas de las celdas que ya
vimos. Esta dificultad hace que ciertas tareas se vuelvan complicadas de resolver, o direc-
tamente imposibles. Por ejemplo, para contar la cantidad de enemigos que est ´an cerca,
en el ejercicio 3.3.5 utiliz ´abamos como “memoria” la cantidad de bolitas de cierto color en
la celda actual; o tambi ´en, para determinar en qu ´e direcci ´on est ´a el pr ´oximo segmento
del sendero, deb´ıamos “codificar” la direcci ´on con bolitas verdes en la celda actual. Estas
tareas ser´ıan mucho m ´as sencillas si el cabezal tuviese memoria para recordar valores
espec´ıficos.
4.3.1. Variables
Para conseguir que el cabezal recuerde cosas mediante una memoria, se puede utilizar
la misma idea de dar nombres a expresiones que ya fueron utilizadas en los par ´ametros
de un procedimiento y en el ´ındice de una repetici ´on indexada. En ambos casos usamos
una forma limitada de memoria, donde el cabezal recuerda por cierto tiempo un valor
dado (por ejemplo un argumento, mediante el nombre del par ´ametro, mientras dura la
ejecuci ´on de un procedimiento). Esta misma idea de nombrar valores puede utilizarse de
manera independiente y controlada por el progamador. Para ello, se define la noci ´on de
variable, que no es m ´as que un identificador que se utiliza para denotar alg ´un valor en
cierto momento de la ejecuci ´on de un programa. O sea, la forma de proveer memoria es
mediante la capacidad de nombrar valores y sabiendo qu ´e nombre le dimos, “recordar” el
valor; o sea, establecemos una correspondencia entre un nombre y un valor dado.
Definici ´on 4.3.1. Una variable es un identificador que comienza con min ´usculas y que se
utiliza para denotar un valor en cierto momento de la ejecuci ´on de un programa.
La palabra variable sufre de un problema: en distintos contextos tiene distintos significa-
dos. As´ı, un matem ´atico entender
