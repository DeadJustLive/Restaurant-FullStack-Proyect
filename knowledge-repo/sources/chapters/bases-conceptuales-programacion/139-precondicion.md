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
dos. As´ı, un matem ´atico entender ´a una cosa por variable, mientras que un programador
puede entender otra. Por eso debemos ser cuidadosos en respetar las formas de entender
un t ´ermino de cada disciplina, y de cada enfoque distinto dentro de la misma disciplina.
En el caso de este libro, el t ´ermino variable se utiliza de una forma diferente a la que es
usual en los lenguajes de programaci ´on m ´as tradicionales donde variable es sin ´onimo de
posici ´on de memoria.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 156 of 312 --

157
Leer con Atenci ´on
Las variables en GOBSTONES son meramente nombres con los que se recuer-
dan ciertos valores. Esta idea tiene apenas una relaci ´on vaga con la noci ´on de
posici ´on de memoria con la que tradicionalmente se asocia la idea de variable
en los lenguajes de programaci ´on tradicionales. La noci ´on de variables que ma-
nejamos en GOBSTONES tiene mucha m ´as relaci ´on con la idea que se tiene en
matem ´aticas, donde las variables son meramente valores que se desconocen en
un momento dado.
Leer con Atenci ´on
La idea tradicional de variable como posici ´on de memoria podr´ıa verse como una
forma de implementaci ´on (o sea, concreta, operacional) de la noci ´on de recordar
valores (o sea memorizar, tener “memoria”. La noci ´on de recordar valores ser´ıa
la forma abstracta, denotacional, y por lo tanto m ´as cercana a lo que pensamos
los programadores.
Para establecer la correspondencia entre una variable y el valor que la misma denota se
utiliza un comando particular, conocido como asignaci ´on. La asignaci ´on de un nombre a
un valor determinado se realiza escribiendo el nombre de la variable, luego el signo :=, y
luego la expresi ´on que describe el valor que la variable debe nombrar. Por ejemplo
cantidadRojas := nroBolitas(Rojo)
establece la correspondencia entre la variable llamada cantidadRojas y el n ´umero de
bolitas de la celda en la que se encuentra el cabezal al ejecutar este comando. Tambi ´en
decimos que “asigna el valor actual de nroBolitas(Rojo) a la variable cantidadRojas”.
Leer con Atenci ´on
Dicho de otra forma, cantidadRojas nombra a la cantidad de bolitas de la celda
actual en ese momento de la ejecuci ´on; se transforma, temporalmente (hasta la
pr ´oxima asignaci ´on de dicha variable) en otra forma de describir a ese valor. El
valor descrito es el n ´umero de bolitas rojas en una celda determinada en un
instante determinado, y no en la celda actual en otros momentos, ni siquiera
el n ´umero de bolitas de esa celda en cualquier momento anterior o posterior,
donde la cantidad puede haber variado. Esto es importante recordarlo, pues es
fuente de mucha confusi ´on. Si luego el cabezal se mueve o la cantidad cambia,
cantidadRojas seguir ´a nombrando al valor de aquella celda en aquel momento.
La forma general de la asignaci ´on queda dada por la siguiente definici ´on:
Definici ´on 4.3.2. La asignaci ´on es un comando mediante el cual se establece la corres-
pondencia entre un nombre y un cierto valor. Su forma es
< variable > := < expresion >
siendo < variable > un identificador con min ´usculas, y < expresion > una expresi ´on cual-
quiera que describe (o denota) al valor que se quiere asociar (asignar) al nombre de la
variable.
El efecto de la acci ´on descrita por un comando de asignaci ´on es la de “recordar” que
el nombre de la variable se usar ´a para denotar al valor descrito por la expresi ´on. Debe
destacarse que la expresi ´on puede ser cualquiera de las vistas, de cualquier complejidad.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 157 of 312 --

158
Leer con Atenci ´on
Una cuesti ´on importante sobre la forma de hablar de variables es que usaremos
como sin ´onimos “el valor descrito por la variable” y “el valor de la variable”, y
tambi ´en “la variable describe a un valor” y “la variable toma un valor”. Si bien las
segundas formas en cada caso no son totalmente correctas desde el punto de
vista del castellano, son terminolog´ıas ampliamente difundidas y utilizadas. Es
importante no tomar literalmente estas formas descuidadas de hablar de varia-
bles, pues pueden conducir a confusiones.
Para efectivizar la acci ´on descrita por un comando de asignaci ´on, el cabezal primero cal-
cula el valor de la expresi ´on, y luego establece la correspondencia entre la variable y ese
valor. Es importante volver a remarcar que el valor que la variable nombra ser ´a el mismo
aun si el valor de la expresi ´on cambia a posteriori de la asignaci ´on (a menos que se reali-
ce una nueva asignaci ´on). Para observar este fen ´omeno, puede estudiarse el siguiente
ejemplo:
procedure CopiarVerdesAlNorte()