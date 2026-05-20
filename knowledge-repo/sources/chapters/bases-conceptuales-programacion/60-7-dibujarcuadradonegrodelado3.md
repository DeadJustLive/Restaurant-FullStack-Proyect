# 7. DibujarCuadradoNegroDeLado3

Los ejemplos 1, 2 y 4 comienzan con min ´uscula. Los ejemplos 3, 5, 6 y 7 comien-
zan con may ´usculas. Por otra parte, los ejemplos 5, 6 y 7 est ´an escritos en una
forma mixta conocida como camelCase, que es la que vamos a utilizar en este
De Wikipedia: “CamelCase es
un estilo de escritura que se apli-
ca a frases o palabras compues-
tas. El nombre se debe a que
las may ´usculas a lo largo de una
palabra en CamelCase se ase-
mejan a las jorobas de un ca-
mello. El nombre CamelCase se
podr´ıa traducir como May ´uscu-
las/Min ´usculas en Camello.”
es.wikipedia.org/wiki/
CamelCase
libro. Existen otras formas de escribir identificadores, y cada programador tiene
su propio estilo. Vamos a hablar de cuestiones de estilo en la secci ´on 2.3.
Actividad 8
Escribir al menos otros diez identificadores, que sirvan para describir
valores complejos y acciones cotidianas. Por ejemplo, sumarDosYTres,
FreirUnHuevo, etc ´etera.
Teniendo la capacidad de denotar elementos a trav ´es de los identificadores, es-
tamos en condiciones de definir procedimientos.
Definici ´on de procedimientos simples
La forma general de una declaraci ´on de procedimiento simple est ´a dada por la
siguiente definici ´on.
Definici ´on 2.2.21. Un procedimiento simple es un nuevo comando definido por
el programador mediante el mecanismo de darle un nombre a un bloque median-
te un identificador. La definici ´on de un procedimiento simple tiene la forma
procedure < procName >()
< bloque >
siendo < procName > un identificador que comienza en may ´uscula, y < bloque >
¡Recordar que la notaci ´on quiere
decir que esto debe reemplazar-
se por un identificador que nom-
bre al procedimiento, y no por la
palabra procName!
un bloque cualquiera.
Los par ´entesis son necesarios; su utilidad se comprender ´a en el cap´ıtulo 3, don-
de se definir ´an formas m ´as complejas de procedimientos. Por el momento solo
se ver ´an las formas m ´as simples de los mismos.
Leer con Atenci ´on
Un procedimiento simple es un bloque al que se le pone nombre.
Ese nombre podr ´a ser utilizado como un comando.
Un ejemplo de procedimiento definido (o declarado) por el programador ser´ıa
procedure PonerDosVerdes()
{ Poner(Verde); Poner(Verde) }
Es importante observar que un procedimiento definido por el programador por
s´ı solo NO constituye un programa. La diferencia entre un procedimiento definido
por el programador y un programa es que el el programa determina completa-
mente la tarea que el cabezal debe llevar a cabo, mientras que el procedimiento
define solo una parte. El programa se usa indicando externamente al cabezal
que lo ejecute, pero un procedimiento definido por el programador debe ser invo-
cado de manera expl´ıcita como comando por el c ´odigo del programa para que el
mismo sea tenido en cuenta por la m ´aquina. Entonces
program
{
PonerDosVerdes()
PonerDosVerdes()
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 61 of 312 --

62
}
procedure PonerDosVerdes()
{ Poner(Verde); Poner(Verde) }
es un programa GOBSTONES que coloca cuatro bolitas verdes en la celda actual.
Observemos que la definici ´on del procedimiento PonerDosVerdes debe darse a
continuaci ´on del programa para que el comando PonerDosVerdes() tenga senti-
do durante la ejecuci ´on.
Definici ´on 2.2.22. Un procedimiento declarado por usuario puede ser utilizado
como comando. Se escribe el nombre seguido por par ´entesis:
< procName >()
El efecto de dicho comando es el mismo que el del bloque definido en la decla-
raci ´on del procedimiento del mismo nombre.
Si se utiliza un comando que no es primitivo ni fue definido por el programador,
el programa fallar ´a.
Observar c ´omo la tarea de poner dos bolitas verdes ya no queda expre-
sada ´unicamente por una secuenciaci ´on, sino que a trav ´es del uso de proce-
dimientos hemos podido darle un nombre significativo a esa tarea. Cada vez
que precisemos poner dos bolitas verdes podemos recurrir al nuevo comando
Para que sea realmente un nue-
vo comando, su definici ´on debe
encontrarse entre las definicio-
nes de procedimientos del pro-
grama.
PonerDosVerdes().
Un defecto muy com ´un en la ense ˜nanza de la programaci ´on (imperativa) es
ignorar completamente a los procedimientos hasta que el estudiante conoce mu-
chas otras formas b ´asicas de comandos. Y esto lleva a escribir programas que
son extremadamente dif´ıciles de leer, por estar pensados en demasiado bajo ni-
vel. En el pasado, cuando las computadoras eran lentas y ten´ıan poca memoria,
se hac´ıa imprescindible ahorrar los recursos (tiempo y memoria) al m ´aximo, por
lo que no resultaba conveniente utilizar muchos procedimientos. Pero hoy en d´ıa,
cuando los recursos se han ido multiplicando exponencialmente hasta no ser un
problema, y donde adem ´as la tecnolog´ıa de procesamiento de programas (cons-
trucci ´on de compiladores, an ´alisis est ´atico de c ´odigo, etc ´etera) ha evolucionado
much´ısimo, resulta mucho mejor utilizarlos desde el comienzo para favorecer el
pensamiento denotacional, de m ´as alto nivel. Por ello es extremadamente impor-
tante aprender a utilizar los procedimientos de maneras que resulten adecuadas
a este prop ´osito.
2.2.9. Uso adecuado de procedimientos
Si privilegiamos la secuenciaci ´on como forma de combinar comandos, sin utili-
zar adecuadamente los procedimientos y otras herramientas de abstracci ´on (que
sirven para simplificar c ´odigo, para escribir menos o para que su significado sea
mejor entendido por humanos), los programas tendr´ıan que ser pensados de a un
comando por vez y focalizados en los efectos que los mismos producen sobre el
estado, y as´ı se complicar´ıa el trabajo en equipo que caracteriza a la programa-
ci ´on moderna. Esta forma de pensar programas se conoce como pensamiento
operacional, pues ubica como la herramienta principal de programaci ´on a las se-
cuencias de operaciones, y obliga al programador a pensar en sus programas
solo en los efectos de la ejecuci ´on individual de cada operaci ´on, relegando, y
muchas veces mal interpretando, el uso de muchas otras formas de abstracci ´on
de programas. El enfoque tradicional de ense ˜nanza de la programaci ´on (aquel
que propone el pensamiento algor´ıtmico por sobre otras abstracciones) privilegia
Un algoritmo es una secuen-
cia bien definida de pasos pa-
ra alcanzar una tarea. Muchos
programadores piensan sus pro-
gramas siguiendo fielmente es-
ta l´ınea. Si bien la ejecuci ´on
de los programas se aproxima
exactamente hacia esta defini-
ci ´on, sugerimos entender a los
programas como descripciones
precisas construidas por huma-
nos, pese a que sean ejecutadas
por m ´aquinas. De esto surgen
muchas construcciones abstrac-
tas que enriquecen el trabajo de
los programadores, aunque ca-
rezcan de significado para las
m ´aquinas.
el pensamiento operacional, postergando el aprendizaje de procedimientos pa-
ra m ´as adelante. El problema con aprender a pensar operacionalmente es que
tiene como consecuencia que los problemas complejos sean dif´ıciles de tratar
y la programaci ´on en equipos sea pr ´acticamente imposible. Es por ello que se
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 62 of 312 --

63
recomienda aprender a pensar los programas como diferentes tareas que deben
realizarse, agrup ´andolas de manera conveniente. Para poder pensar con tareas,
el lenguaje debe proveernos alg ´un mecanismo; en GOBSTONES el mecanismo
utilizado para definir tareas es el de procedimiento. Por eso, aprender a utilizar
adecuadamente procedimientos es algo que debe hacerse, en nuestra opini ´on,
desde el mism´ısimo comienzo del aprendizaje de la programaci ´on. Fomentar el
pensamiento por tareas, en detrimento del pensamiento operacional, es crucial
para que el aprendizaje conseguido sea valioso no solo en el corto plazo, sino
durante toda la vida del programador, independientemente de la envergadura de
la tarea que se le encomiende.
Leer con Atenci ´on
Podr´ıamos decir que las tareas son situaciones complejas a resolver, y
los procedimientos, la forma de describir tareas (de la misma forma que
las acciones son la manera de producir efectos, y los comandos, la forma
de describir acciones).
Para Reflexionar
Esta habilidad es fundamental para poder encarar tareas complejas. Uno
de los errores m ´as tradicionales en los cursos b ´asicos de programaci ´on
consiste en mantener el pensamiento operacional demasiado tiempo,
pues resulta m ´as sencillo pensar los primeros ejemplos de manera ope-
racional. Sin embargo, esto complica y dificulta luego el aprendizaje pos-
terior. A partir del ejemplo visto, reflexione sobre el alt´ısimo impacto que
tiene la capacidad de agrupar detalles e ideas en componentes que se
puedan combinar para aumentar la productividad y reducir la compleji-
dad de las descripciones.
Es conveniente, entonces, que se utilicen procedimientos para nombrar adecua-
damente las tareas, pues al escribir programas para solucionar tareas m ´as com-
plejas, se vuelve imposible determinar adecuadamente la correcci ´on del progra-
ma si se razona de manera operacional y se vuelve casi imposible dividir dife-
rentes tareas entre varios programadores de un mismo equipo. Por eso la forma
operacional de pensar un programa solo sirve con los programas m ´as simples.
Pensar por tareas permite generalizar adecuadamente el programa.
Volvamos al ejemplo del cuadrado. Vimos que era mejor escribirlo utilizando
un procedimiento llamado DibujarCuadradoNegroDeLado3 en lugar de utilizar 38
comandos (resultado del pensamiento operacional). El resultado final fue (vale la
pena reiterar el c ´odigo) el siguiente programa
program
{
VaciarTablero()
IrAlBorde(Sur); IrAlBorde(Oeste)
DibujarCuadradoNegroDeLado3()
IrAlBorde(Este); Mover(Oeste); Mover(Oeste)
DibujarCuadradoNegroDeLado3()
}
procedure DibujarCuadradoNegroDeLado3()
{
Mover(Norte); Poner(Negro); Mover(Norte); Poner(Negro)
Mover(Este); Poner(Negro); Mover(Este); Poner(Negro)
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 63 of 312 --

64
Mover(Sur); Poner(Negro); Mover(Sur); Poner(Negro)
Mover(Oeste); Poner(Negro); Mover(Oeste); Poner(Negro)
}
Como podemos ver, el procedimiento DibujarCuadradoNegroDeLado3() sigue
siendo el resultado del pensamiento operacional. Si tuvi ´eramos que modificarlo
para cambiar alguna caracter´ıstica, ser´ıa complicado, ya que habr´ıa que pensar
en cada operaci ´on de manera individual. Por ejemplo, si quisi ´eramos transformar-
lo en un procedimiento que dibujase un cuadrado de lado 4, ¿qu ´e operaciones
habr´ıa que agregarle?
Actividad de Programaci ´on 9
Realice el ejercicio 2.2.7 y pru ´ebelo dibujando 2 cuadrados como antes.
Para ello deber ´a modificar el programa principal anterior para que el 2do
cuadrado se comience a dibujar un lugar m ´as al oeste (pues si no no
habr ´a lugar, y el programa fallar ´a siempre).
Ejercicio 2.2.7. Modificar el programa anterior cambiando el c ´odigo del procedi-
miento DibujarCuadradoNegroDeLado3 escrito usando pensamiento operacional
para que dibuje 2 cuadrados de tama ˜no 4. Cambiar el nombre del procedimiento
a DibujarCuadradoNegroDeLado4.
¿Cu ´antas modificaciones fueron necesarias para realizar el cambio de procedi-
miento? ¿Cu ´anto trabajo fue darse cuenta d ´onde modificar?
Para Reflexionar
A partir de la experiencia de modificar este c ´odigo, reflexione nuevamen-
te sobre c ´omo se complicar´ıa el trabajo de programar si solo utiliz ´ase-
mos pensamiento operacional y todos nuestros programas se armasen
solamente en base a una larga secuencia de instrucciones, sin distinci ´on
de diferentes tareas.
Claramente, podr´ıamos tratar de aplicar la t ´ecnica de divisi ´on en subtareas al
dibujo del cuadrado, y expresar su c ´odigo mediante algunas tareas bien elegidas,
para las que se deben definir procedimientos adecuadamente.
Puesto que se trata de dibujar un cuadrado, una forma natural de pensar
este problema es mediante dibujar 4 l´ıneas del mismo tama ˜no. Esto dar ´a lugar a
cuatro procedimientos que podr´ıan denominarse
Prestar atenci ´on a los identi-
ficadores elegidos para nom-
brar los procedimientos. Discuti-
remos acerca de esto en la sec-
ci ´on 2.3.
DibujarLineaNegra2HaciaElNorte,
DibujarLineaNegra2HaciaElEste,
DibujarLineaNegra2HaciaElSur y
DibujarLineaNegra2HaciaElOeste.
Entonces, el procedimiento de dibujar un cuadrado de lado 3 podr´ıa expresarse
como
procedure DibujarCuadradoNegroDeLado3()
{
DibujarLineaNegra2HaciaElNorte()
DibujarLineaNegra2HaciaElEste()
DibujarLineaNegra2HaciaElSur()
DibujarLineaNegra2HaciaElOeste()
}
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 64 of 312 --

65
Cada uno de los procedimientos de dibujar l´ınea se compondr ´a de comandos
Mover y Poner que dibujen la l´ınea en la direcci ´on indicada. Por ejemplo, el pro-
cedimiento DibujarLineaNegra2HaciaElNorte quedar´ıa
procedure DibujarLineaNegra2HaciaElNorte()
{
Mover(Norte); Poner(Negro)
Mover(Norte); Poner(Negro)
}
Actividad de Programaci ´on 10
Realizar el ejercicio 2.2.8 y ejecutar el programa resultante. Observar
adem ´as que este programa es equivalente al del ejercicio 2.2.6, pero es
m ´as f ´acil de entender.
Ejercicio 2.2.8. Completar las definiciones de los procedimientos para dibujar
l´ıneas y componer todo el c ´odigo en un ´unico programa que describa la misma
tarea que el programa ejemplo que usamos para producir el tablero del gr ´afi-
co G.2.10, pero de manera tal que el c ´odigo resultante est ´e adecuadamente di-
vidido en subtareas (inclu´ıdo el procedimiento que dibuja el cuadrado).
Actividad de Programaci ´on 11
Realizar el ejercicio 2.2.9 y ejecutar el programa resultante. Observe de-
tenidamente este programa respecto del definido en el ejercicio anterior
y piense cu ´antas modificaciones precis ´o.
Ejercicio 2.2.9. Modificar el ejercicio 2.2.8, realizado utilizando divisi ´on en sub-
tareas, para que realice dos cuadrados de lado 4.
Para Reflexionar
Reflexione sobre la utilidad de los procedimientos, y c ´omo ´estos son ab-
solutamente necesarios una vez que se encaran tareas m´ınimamente no
triviales. Reflexione sobre los cambios necesarios en los procedimientos
para realizar una tarea diferente y en c ´omo es sencillo determinar en
qu ´e lugares realizar los cambios si los procedimientos fueron definidos
y nombrados adecuadamente.
Observar que el programa con procedimientos es m ´as extenso en este caso que
el que sigue el pensamiento operacional. Sin embargo, ahora estamos en con-
diciones de generalizarlo de varias maneras. Por ejemplo, cambiando solamente
los procedimientos que dibujan l´ıneas y copiando los restantes procedimientos
sin alteraciones, podr´ıamos hacer diferentes procedimientos para dibujar otros
cuadrados de tama ˜no m ´as grande.
Observar que se trata de dibu-
jar solo los lados del cuadrado.
O sea, no se trata de un cuadra-
do s ´olido.
Esta forma de dividir un programa en tareas y definir un procedimiento para
cada una de ellas hace que el foco de atenci ´on en programaci ´on sea puesto en
los procedimientos individuales. De esta forma, en lugar de pedir un programa
que haga cierta tarea, se pedir ´a la definici ´on de un procedimiento particular que
realice la tarea. Por ejemplo, el ejercicio de dibujar un cuadrado se va a enunciar
de la siguiente manera:
Ejercicio 2.2.10. Escribir un procedimiento DibujarCuadradoNegroDeLado3 que
dibuje un cuadrado negro de tres celdas de lado, utilizando una adecuada divisi ´on
en subtareas.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 65 of 312 --

66
Leer con Atenci ´on
Al enunciar un problema se asume que el requerimiento de escribir el
programa es impl´ıcito, o sea, debe crearse un programa que invoque al
procedimiento solicitado en el enunciado, aunque tal cosa no est ´e pedida
de manera expl´ıcita en ese enunciado. Lo mismo sucede con los proce-
dimientos auxiliares, necesarios para realizar una adecuada divisi ´on en
subtareas de la tarea encomendada: no se enuncian, pero deben rea-
lizarse. Es tarea del programador determinar cu ´ales subtareas resolver
con qu ´e procedimientos auxiliares.
Adem ´as, en ocasiones ser ´an necesarios varios procedimientos diferentes combi-
nados adecuadamente para llevar a cabo alguna tarea. En ese caso, se presen-
tar ´a y discutir ´a cada uno de ellos por separado (en diferentes ejercicios), dejando
su combinaci ´on impl´ıcita o como parte de alg ´un ejercicio final. O sea, siempre
se asumir ´a que los ejercicios previos han sido realizados, y pueden por lo tanto
reutilizarse.
Como ejemplo de c ´omo los enunciados mencionar ´an solamente el procedi-
miento que se pide, pero no otros que pueden resultar necesarios, consideremos
el siguiente enunciado.
Ejercicio 2.2.11. Escribir un procedimiento llamado CuadradoNegroARojo3 que
suponiendo que hay un cuadrado Negro de lado tres a partir de la celda actual,
lo transforme en un cuadrado Rojo.
La soluci ´on para este problema ser´ıa dada de la siguiente manera
procedure TransformarCelda()
{ Sacar(Negro); Poner(Rojo) }
procedure TrasformarLinea2HaciaElNorte()
{
Mover(Norte); TransformarCelda()
Mover(Norte); TransformarCelda()
}
procedure TrasformarLinea2HaciaElEste()
{
Mover(Este); TransformarCelda()
Mover(Este); TransformarCelda()
}
procedure TrasformarLinea2HaciaElSur()
{
Mover(Sur); TransformarCelda()
Mover(Sur); TransformarCelda()
}
procedure TrasformarLinea2HaciaElOeste()
{
Mover(Oeste); TransformarCelda()
Mover(Oeste); TransformarCelda()
}
procedure CuadradoNegroARojo3()
{
TrasformarLinea2HaciaElNorte()
TrasformarLinea2HaciaElEste()
TrasformarLinea2HaciaElSur()
TrasformarLinea2HaciaElOeste()
}
El primer detalle a observar es que si bien el procedimiento solicitado es so-
lamente CuadradoNegroARojo3, la soluci ´on involucra la definici ´on de cinco pro-
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 66 of 312 --

67
cedimientos diferentes. Esto no es parte del requerimiento original expl´ıcito, pero
una buena pr ´actica de programaci ´on se consigue eligiendo convenientemente las
tareas a describir, y nombr ´andolas adecuadamente (volveremos sobre el punto
de elecci ´on de nombres en la secci ´on 2.3).
Otro detalle a observar tiene que ver con c ´omo probar este procedimiento.
Puesto que la precondici ´on de CuadradoNegroARojo3 es que exista un cuadrado
negro de lado tres ya dibujado en el tablero, no tendr´ıa sentido utilizar como
programa
program
{
VaciarTablero()
IrAlBorde(Sur);IrAlBorde(Oeste)
CuadradoNegroARojo3()
}
pues este programa siempre fallar´ıa. Se requiere, en cambio, asegurar primero
la precondici ´on de CuadradoNegroARojo3, utilizando alguna otra forma. Una de
ellas, por ejemplo, es utilizar alg ´un otro procedimiento para preparar el tablero
antes de llamar al procedimiento a probar, como en
program
{
VaciarTablero()
IrAlBorde(Sur);IrAlBorde(Oeste)
DibujarCuadradoNegroDeLado3()
CuadradoNegroARojo3()
}
Otra de las formas, si la herramienta lo permite, es tener un tablero predefinido
donde el cuadrado negro ya ha sido dibujado a partir del origen, y entonces usar
Prestar atenci ´on a que supone-
mos que al ejecutar este progra-
ma NO estamos usando cual-
quier tablero, sino uno que ya
contiene un cuadrado negro del
tama ˜no correcto dibujado en el
lugar correcto.
como programa simplemente:
program
{
IrAlBorde(Sur);IrAlBorde(Oeste)
CuadradoNegroARojo3()
}
Pero como esto es dependiente de cada herramienta, no nos extenderemos en
estas alternativas. Ser ´a tarea del estudiante buscar la forma de probar los pro-
cedimientos que se solicitan en las actividades de programaci ´on. En el caso que
buscamos ejemplificar, la soluci ´on elegida ser ´a la de utilizar el procedimiento
DibujarCuadradoNegroDeLado3 como en el programa del medio dado antes.
Actividad de Programaci ´on 12
Realice el ejercicio 2.2.12. Observe que para que el mismo funcione en
cualquier herramienta su programa debe contener al menos 10 definicio-
nes de procedimientos adem ´as del programa principal (y no solo los 5
correspondientes al ejercicio 2.2.11).
Ejercicio 2.2.12. Escribir un programa que utilice CuadradoNegroARojo3, y que,
si el tablero es lo suficientemente grande, no falle, y culmine con un cuadrado
rojo en el tablero.
Observar que en el ejercicio 2.2.12 no se indica c ´omo debe conseguirse que al
invocar el procedimiento CuadradoNegroARojo3 se cumpla su precondici ´on. La
precondici ´on de un procedimiento solicitado debe satisfacerse de alguna manera
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 67 of 312 --

68
para poder probarlo. O sea, en general el ejercicio 2.2.11 implicar ´a que debe ha-
cerse tambi ´en el ejercicio 2.2.12, aunque esto no se indicar ´a de ninguna manera
a partir de ahora. Observar que tambi ´en est ´a impl´ıcita la necesidad de comprobar
que el programa funciona, ejecut ´andolo.
Procedimientos de uso com ´un
Un detalle para observar es que en todos los programas del ´ultimo ejemplo (el de
pasar un cuadrado negro a rojo) utilizamos reiteradas veces la combinaci ´on de
comandos
IrAlBorde(Sur);IrAlBorde(Oeste)
Esta combinaci ´on nos permite ir a la esquina inferior izquierda del tablero, lo que
en un diagrama de ejes cartesianos llamar´ıamos el origen de coordenadas. Para
no tener que repetir esta combinaci ´on podemos utilizar un procedimiento, seg ´un
el mecanismo de divisi ´on en subtareas que aprendimos en esta secci ´on.
Actividad de Programaci ´on 13
Realice el ejercicio 2.2.13 y modifique los ejemplos anteriores para que
utilicen este procedimiento en lugar de la combinaci ´on de dos comandos
para ir al borde.
Ejercicio 2.2.13. Definir un procedimiento IrAlOrigen que lleve el cabezal a la
celda m ´as al sur y el oeste del tablero (el origen del tablero).
Este procedimiento es extremadamente probable que sea utilizado en la mayor´ıa
de los programas que escribamos. Eso significar ´a que, en ausencia de alguna
herramienta que nos permita no tener que volver a definir procedimientos cada
vez, en cada programa que hagamos vamos a tener que volver a definirlo co-
piando el c ´odigo de manera id ´entica. ¡Pero toda la idea de definir procedimientos
era no tener que repetir una y otra vez las mismas combinaciones! Para eso
GOBSTONES provee otra herramienta simple: una biblioteca. Una biblioteca de
El t ´ermino en ingl ´es es li-
brary, que usualmente se tra-
duce (incorrectamente) como li-
brer´ıa; sin embargo, la traduc-
ci ´on correcta es biblioteca, y por
eso es la que usaremos.
operaciones es un conjunto de definiciones que se utilizan una y otra vez en di-
ferentes programas. La mayor´ıa de los lenguajes provee mecanismos complejos
para la definici ´on e inclusi ´on de diferentes bibliotecas de operaciones en nues-
tros programas. Como no es la intenci ´on de GOBSTONES presentar herramientas
complejas, el concepto de biblioteca que presenta es extremadamente sencillo:
si existe un archivo de nombre Biblioteca en el mismo lugar que el archivo que
contiene el programa (usualmente la misma carpeta o directorio en el sistema de
archivos), GOBSTONES indica que ese archivo tambi ´en debe ser tenido en cuen-
ta a la hora de buscar definiciones, sin tener que indicarlo de ninguna manera
expl´ıcita.
Definici ´on 2.2.23. Una biblioteca de operaciones es un conjunto de definiciones
que se pueden utilizar en diferentes programas. En GOBSTONES se consigue a
trav ´es de un archivo de nombre Biblioteca que se coloca en el mismo lugar que
el archivo que contiene el programa (la misma carpeta o directorio).
En esta biblioteca conviene poner principalmente definiciones que sean tan ge-
nerales que puedan utilizarse en casi cualquier programa. El primer procedimien-
to que cumple con esta caracter´ıstica es, justamente, IrAlOrigen. A medida que
vayamos avanzando con los ejercicios, surgir ´an otros procedimientos que podr ´an
ser incorporados en la biblioteca; en cada caso esto ser ´a indicado de manera
expl´ıcita. Adem ´as, si al realizar procedimientos surgiera alguno de uso com ´un
que no haya sido indicado aqu´ı para ir a la biblioteca, ¡no hay que dudar en colo-
carlo tambi ´en! La experimentaci ´on es la base del aprendizaje.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 68 of 312 --

69
Leer con Atenci ´on
La Biblioteca es una herramienta conceptual de GOBSTONES para fa-
cilitar la reutilizaci ´on de ciertas definiciones. Sin embargo, cada herra-
mienta que implementa el lenguaje puede proveer diferentes facilidades
para utilizarla, que van m ´as all ´a de la cuesti ´on conceptual.
Actividad de Programaci ´on 14
Rehaga el ejercicio 2.2.12 pero colocando el procedimiento IrAlOrigen
en la Biblioteca. Pru ´ebelo en la herramienta que utilice.
Antes de proseguir con los conceptos estructurales, vamos a hablar de algunas
cuestiones de estilo que afectan la manera en que las personas leemos los pro-
gramas.
2.3. Acerca de las cuestiones de estilo
Hasta ahora vimos que al aprender un lenguaje de programaci ´on, existen nu-
merosas reglas r´ıgidas que debemos aprender para poder escribir programas.
Sin embargo, tambi ´en aparecieron ciertas cuestiones de estilo, que si bien no
remarcamos demasiado, son parte importante de la forma en que escribimos
programas.
Puesto que un programa GOBSTONES es una descripci ´on de la soluci ´on a un
problema, cabe hacer la pregunta: ¿qui ´en leer ´a esta descripci ´on? La respuesta
tiene dos partes. La m ´as fundamental es que el programa debe ser “le´ıdo” por el
cabezal para realizar las acciones. Pero son los programadores qui ´enes tambi ´en
deben leerlo, para realizar cambios, mejoras, descubrir posibles errores, etc ´etera.
Las reglas r´ıgidas, como ya vimos, tienen que ver con los programas en cuan-
to a piezas ejecutables, o sea, con las m ´aquinas que deben leer y analizar los
programas, que son limitadas y esperan las cosas de cierta manera fija. Las cues-
tiones de estilo, en cambio, tienen que ver con los programas en cuanto descrip-
ciones, con las personas que deben leer y comprender el c ´odigo. Un buen estilo
resulta en c ´odigo con mayor legibilidad, esto es, hace al programa m ´as sencillo
La legibilidad es una propiedad
del c ´odigo que muestra el gra-
do de simplicidad con el que una
persona que lee el c ´odigo puede
entenderlo.
de leer y comprender por las personas que lo lean.
Como con toda cuesti ´on de estilo, no hay reglas fijas, universales, que esta-
blezcan qu ´e es correcto y qu ´e es incorrecto, o qu ´e es c ´omodo o inc ´omodo hacer.
Cada programador posee un gusto diferente con respecto a las cuestiones de
estilo. Sin embargo, hay algunos extremos que son claramente entendibles o cla-
ramente inentendibles, y por lo tanto sencillos de identificar. Entonces, la tarea
del programador a medida que adquiere experiencia, es identificar estas cuestio-
nes de estilo, evitar pr ´acticas que conduzcan a c ´odigos ilegibles, y en el camino,
incorporar su propio estilo.
Por supuesto, adquirir un estilo propio no es tarea sencilla, y el consejo al
comenzar es copiar el estilo de otros. Copiando de la suficiente cantidad de pro-
Esto es similar a lo que ocurre
cuando uno aprende a bailar un
baile espec´ıfico, como tango o
salsa, o cuando aprende a dibu-
jar o pintar
gramadores, pueden identificarse muchas de las pr ´acticas consideradas correc-
tas o incorrectas en estilo. En este libro hemos utilizado un estilo espec´ıfico, y
esperamos que los estudiantes lo imiten, al menos mientras adquieren el propio.
Para que esto no sea algo totalmente impensado y autom ´atico, en este apartado
vamos a presentar algunas de las cuestiones de estilo m ´as importantes, y los
principios por los que nos guiamos en este libro.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 69 of 312 --

70
2.3.1. Indentaci ´on de c ´odigo
La primera cuesti ´on de estilo est ´a relacionada con la forma en la que el c ´odigo
es visualizado. Como hemos visto, el c ´odigo no se muestra como algo completa-
mente lineal, sino m ´as bien bidimensional: usamos ciertos elementos debajo de
otros para indicar que los primeros est ´an subordinados a los segundos. Por ejem-
plo, al bloque nombrado por la definici ´on de un procedimiento simple lo hemos
puesto hasta ahora siempre debajo de la l´ınea que indica que se est ´a definiendo
el mismo.
Desde el punto de vista de la herramienta que ejecuta los programas, es lo
mismo un car ´acter de espaciado que quinientos, ya que lo que importa es po-
der distinguir que hay m ´as de un elemento uno a continuaci ´on del otro, y no a
qu ´e distancia est ´an. Los caracteres de espaciado est ´an dados por los espacios
en blanco, los fines de l´ınea y los tabuladores. Entonces, son equivalentes el
c ´odigo
procedure PintarCelda()
{
Poner(Rojo)
Poner(Rojo)
}
y el c ´odigo
procedure PintarCelda() { Poner(Rojo); Poner(Rojo) }
y tambi ´en el c ´odigo
procedure PintarCelda()
{ Poner(Rojo); Poner(Rojo) }
e incluso tambi ´en el c ´odigo
procedure
PintarCelda()
{
Poner(Rojo)
Poner(Rojo)
}
Lo repetimos: estas cuatro variaciones del c ´odigo son equivalentes. Recordemos
que esto quiere decir que tendr ´an exactamente el mismo efecto. Entonces, ¿por
qu ´e molestarse con cu ´al de las 4 elegir? Claramente, la ´ultima de las formas
es casi inentendible para un lector humano, a pesar de que la computadora las
considerar ´a exactamente igual. La diferencia entre las 3 primeras, en cambio, es
m ´as sutil.
Actividad de Programaci ´on 15
Pruebe las variaciones anteriores en la herramienta, y verifique que las
formas son equivalentes. Encuentre otras variaciones posibles que re-
sulten en c ´odigo equivalente (aunque sea ilegible o innecesariamente
complicado).
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 70 of 312 --

71
A la forma exacta en que el c ´odigo es mostrado en dos dimensiones, en funci ´on
de variar el n ´umero de caracteres de espacio que se utilizan, se lo denomina
indentar el c ´odigo. El t ´ermino indentar es un neologismo basado en el t ´ermino
ingl ´es indent, que significa sangrar, como en el castellano sangr´ıa. Entonces, in-
Indent tambi ´en significa de-
jar marcas en una superficie,
adem ´as de sangrar.
dentar un c ´odigo es sangrarlo, o sea, comenzar ciertas l´ıneas m ´as adentro que
otras, como se hace en el primer p ´arrafo de los textos en castellano; en otros
t ´erminos, es agregarle sangr´ıas al texto del c ´odigo. Dado que el t ´ermino caste-
llano sangrar es sin ´onimo tambi ´en de, y m ´as com ´unmente reconocido como, per-
der sangre, muchos programadores de habla castellana (pero no los espa ˜noles)
Los espa ˜noles son extremada-
mente recelosos de los neolo-
gismos o anglicismos, y tradu-
cen todo de manera literal. Es-
to resulta confuso, pues hablan
de sangrado de c ´odigo, lo cual
a m´ı al menos me hace pensar
en c ´odigo al que se le saca san-
gre. . .
preferimos usar el t ´ermino indentar.
Para Ampliar
Buscar en la web discusiones sobre indentaci ´on (o sangrado)
de c ´odigo. El primer sitio que sale en Google es la Wikipedia:
http://es.wikipedia.org/wiki/Indentacion
que dice
Indentaci ´on es un anglicismo (de la palabra inglesa indentation)
de uso com ´un en inform ´atica que significa mover un bloque de
texto hacia la derecha insertando espacios o tabuladores para
separarlo del texto adyacente, lo que en el ´ambito de la impren-
ta se ha denominado siempre como sangrado o sangr´ıa. En los
lenguajes de programaci ´on de computadoras la indentaci ´on es
un tipo de notaci ´on secundaria utilizado para mejorar la legi-
bilidad del c ´odigo fuente por parte de los programadores, te-
niendo en cuenta que los compiladores o int ´erpretes raramente
consideran los espacios en blanco entre las sentencias de un
programa. Sin embargo, en ciertos lenguajes de programaci ´on
como Haskell, Occaml y Python, la indentaci ´on se utiliza pa-
ra delimitar la estructura del programa permitiendo establecer
bloques de c ´odigo. Son frecuentes discusiones entre progra-
madores sobre c ´omo o d ´onde usar la indentaci ´on, si es mejor
usar espacios en blanco o tabuladores, ya que cada programa-
dor tiene su propio estilo.
Definici ´on 2.3.1. Indentar c ´odigo es seleccionar la forma en que el mismo se
muestra en dos dimensiones, en funci ´on de variar el n ´umero de caracteres de
espacio que se utilizan.
Leer con Atenci ´on
Entonces, realizamos nuevamente la pregunta: ¿por qu ´e puede resultar
mejor indentar el c ´odigo de cierta manera? La indentaci ´on de c ´odigo
realza la comprensi ´on de la estructura del texto, o sea, qu ´e elementos
est ´an subordinados a qu ´e elementos, y qu ´e informaci ´on es v ´alida en
qu ´e contexto. B ´asicamente, permite una comprensi ´on mucho m ´as r ´apida
de esa estructura, y por lo tanto del programa. Por ello, una adecuada
indentaci ´on es fundamental.
Como con todas las cuestiones de estilo, la percepci ´on sobre lo que es adecuado
y lo que no var´ıa con las personas, e incluso con el contexto. Algunas formas son
claramente incorrectas (como la tercer variante que vimos antes), pero otras son
solo cuesti ´on de costumbre. Por ejemplo, en este libro hemos elegido colocar el
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 71 of 312 --

72
bloque nombrado por un procedimiento en una l´ınea independiente al encabeza-
do de su declaraci ´on, y en el caso que el bloque ocupe m ´as de una l´ınea, con las
llaves en sus propias l´ıneas, y uno o dos caracteres m ´as adentro que la palabra
procedure; los comandos del bloque van entre medio de ambas llaves, otros dos
caracteres m ´as adentro. El resultado, que ya hemos visto numerosas veces, es
el siguiente
procedure DibujarLinea()
{
Poner(Negro); Mover(Norte)
Poner(Negro); Mover(Norte)
}
Sin embargo, otros estilos son posibles. El mismo c ´odigo, indentado por un pro-
gramador de la comunidad JAVA, habr´ıa sido
JAVA es uno de los principales
lenguajes de programaci ´on de
hoy d´ıa. Para conocer m ´as so-
bre el lenguaje JAVA, ver el sitio
www.java.com/es
procedure DibujarLinea() {
Poner(Negro); Mover(Norte)
Poner(Negro); Mover(Norte)
}
Observe c ´omo la llave de apertura se coloca en la misma l´ınea que el encabeza-
do, y la correspondiente de cierre a la misma altura que la palabra procedure.
Otra variaci ´on de estilo, que usaremos en ocasiones, consiste en que, cuando
el c ´odigo del procedimiento es breve, se muestra en una ´unica l´ınea, como en
procedure DibujarLineaCorta() { Poner(Negro); Mover(Norte) }
o a veces
procedure DibujarLineaCorta()
{ Poner(Negro); Mover(Norte) }
Al principio intente imitar el estilo de indentaci ´on utilizado en este libro, pero a
medida que avance en la escritura de sus propios programas, experimente con
otras variaciones para ver cu ´al le resulta m ´as c ´omoda. Recuerde que la forma
en que otros programadores leen el c ´odigo tambi ´en se ver ´a afectada por sus
cambios. ¡Y tambi ´en que una de las cuestiones que se eval ´uan al corregir c ´odigo
de los estudiantes es la comprensi ´on sobre la estructura del mismo! Eso es lo
que debe reflejar en la indentaci ´on.
Leer con Atenci ´on
Si bien en la mayor´ıa de los lenguajes la indentaci ´on es una cuesti ´on de
estilo, tal cual mencionamos aqu´ı, en algunos lenguajes modernos como
HASKELL, PYTHON, etc. la indentaci ´on puede utilizarse para indicarle a
la m ´aquina que ejecuta cu ´al es la estructura del programa. Consecuen-
temente, en esos lenguajes la indentaci ´on sigue reglas fijas, r´ıgidas, no
sujetas a las consideraciones estil´ısticas.
2.3.2. Elecci ´on de nombres adecuados de identificadores
La segunda cuesti ´on fundamental de estilo tiene que ver con la elecci ´on de nom-
bres para los identificadores. A este respecto, hay dos aspectos b ´asicos:
1. qu ´e nombres elegir para describir adecuadamente la soluci ´on;
2. qu ´e forma de escribir nombres complejos se utiliza.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 72 of 312 --

73
El aspecto de c ´omo escribir nombres complejos tiene varias opciones m ´as o
menos estandarizadas en la comunidad de programadores. Por ejemplo, en este
libro hemos elegido usar CamelCase, que como vimos, es un estilo de escritura
para identificadores compuestos de varias palabras, y donde cada palabra se
escribe con may ´usculas.
Otro estilo muy difundido es utilizar guiones bajos (underscores en ingl ´es)
para separar las palabras, en lugar de poner en may ´usculas cada una de las
letras. Comparemos, por ejemplo,
UnIdentificadorEnCamelCase con
un identificador NO en camel case.
Cada comunidad de programaci ´on tiene su propia preferencia por uno u otro
estilo, o por algunas variaciones, e incluso en algunos casos por estilos comple-
tamente distintos. Lo que es claro es que se trata de una cuesti ´on puramen-
te estil´ıstica, y que, por lo tanto, genera discusiones fundamentalistas, cuasi-
En algunas comunidades de
programaci ´on estas cuestiones
de estilo se utilizan para alimen-
tar herramientas adicionales de
tratamiento de c ´odigo, y en ese
caso se constituyen en un “su-
blenguaje” que se expresa en re-
glas r´ıgidas de estilo necesarias
para que la ejecuci ´on de las he-
rramientas adicionales sea co-
rrecta.
religiosas (o para decirlo de otra manera m ´as elegante, semi-cient´ıficas).
Para Ampliar
Para ampliar sobre el tema de las discusiones semi-cient´ıficas al respec-
to de cu ´al estilo es mejor, ver, por ejemplo
Recurso Web
http://whathecode.wordpress.com/2011/02/10/
camelcase-vs-underscores-scientific-showdown/
¡Pero no olvide que en este libro favorecemos el CamelCase!
Ahora bien, el otro aspecto, referente a los nombres de identificadores, es crucial,
y es por ello la que m ´as debates fundamentalistas genera en los programadores.
En este aspecto, se trata de qu ´e nombres elegir para describir una tarea y as´ı te-
ner procedimientos bien nombrados.
Debemos tener en cuenta que el nombre exacto de un procedimiento no es
importante para la herramienta, pues al ejecutar, se limita a buscar la definici ´on
de un procedimiento con ese nombre para saber qu ´e debe hacer. Entonces, para
la herramienta, y puesto que los tres generan el mismo efecto, son equivalentes
el programa
program { PonerGotaAcuarelaRoja() }
procedure PonerGotaAcuarelaRoja() { Poner(Rojo) }
con el programa
program { ColocarAlienigena() }
procedure ColocarAlienigena() { Poner(Rojo) }
y con el programa
program { A() }
procedure A() { Poner(Rojo) }
Sin embargo, para un lector humano, el primero da cuenta de que el programador
est ´a intentando representar elementos en un dominio de pintura, el segundo, que
el programador est ´a pensando en alg ´un juego de ciencia-ficci ´on, por ejemplo,
y el tercero puede tratarse de cualquier cosa, ya que la intenci ´on original del
programador se ha perdido.
A partir de este ejemplo, podemos ver que el nombre A para un procedimiento
rara vez es adecuado. De la misma forma, un nombre excesivamente largo, co-
mo PonerAlienigenaInvasorCuandoSeProduceLaInvasionALaTierra, resulta
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 73 of 312 --

74
inadecuado pues poco contribuye a la legibilidad del c ´odigo, e incluso lo compli-
ca un poco.
Elegir nombres adecuadamente es, entonces, una cuesti ´on de estilo de fun-
damental importancia. Y como todo estilo, es complejo poder dominarlo. Requie-
re pr ´actica, mucha pr ´actica. Pero se consigue. En GOBSTONES elegimos la con-
venci ´on de usar, para los comandos, identificadores que comienzan con verbos
en infinitivo, seguidos de alguna descripci ´on adicional, como Poner, DibujarLinea,
etc ´etera. Otros lenguajes siguen otras convenciones.
Como dijimos antes, ning ´un nombre que se elija est ´a realmente mal, pues
no es importante para la ejecuci ´on del programa, sino que es m ´as adecuado o
m ´as inadecuado para la lectura; y el grado de adecuaci ´on depende mucho del
gusto del que lo lee. Sin embargo, al evaluar un programa, existen elecciones
claramente incorrectas pues no solo no contribuyen a la legibilidad, sino que
confunden. Por ejemplo, observe el siguiente c ´odigo
program { Poner(Verde); PonerBolitaRoja() }
procedure PonerBolitaRoja() { Sacar(Verde) }
¿Qu ´e hace este programa? ¿Es correcto? ¿Se da cuenta que la elecci ´on del
nombre PonerBolitaRoja es terriblemente inadecuada, porque lleva a pensar
en otra idea? ¡Pero sin embargo el c ´odigo funciona! Entonces diremos que este
c ´odigo est ´a “mal”, porque su elecci ´on de nombres es enga ˜nosa, aunque el c ´odigo
funcione.
Leer con Atenci ´on
Lo que sucede es que no es suficiente que el c ´odigo funcione para ser
considerado un buen c ´odigo. Debe ser posible que las personas –otros
programadores– lo lean y entiendan el prop ´osito del mismo. La correc-
ta elecci ´on de nombres contribuye enormemente a esto. Por correcta,
queremos decir que refleje una adecuaci ´on entre el problema que se
est ´a resolviendo y la forma de resolverlo, que d ´e cuenta de las intencio-
nes del autor.
¿Y qu ´e hacemos cuando el nombre no es suficiente para mostrar nuestros prop ´osi-
tos? ¿C ´omo damos cuenta, por ejemplo, de los requerimientos de un procedi-
miento para funcionar? En las pr ´oximas secciones se aborda precisamente este
tema.
2.3.3. Comentarios en el c ´odigo
Puesto que la intenci ´on del programador no siempre es evidente a partir de la lec-
tura exclusiva de los comandos, incluso a pesar de la adecuada indentaci ´on del
c ´odigo y de la buena elecci ´on de identificadores, GOBSTONES (al igual que pr ´acti-
camente todos los lenguajes) ofrece una posibilidad interesante: la de comentar
el c ´odigo. Comentar el c ´odigo significa agregarle descripciones, llamadas comen-
tarios que no son relevantes para el cabezal, pero que s´ı lo son para un lector
humano. Normalmente estos comentarios se escriben en castellano (o ingl ´es, o
alg ´un otro lenguaje natural), o bien en alg ´un lenguaje formal, como puede ser la
l ´ogica. Los comentarios no tienen ning ´un efecto sobre las acciones del cabezal y
son considerados igual que los caracteres de espacio desde el punto de vista de
la herramienta.
Definici ´on 2.3.2. Un comentario es una descripci ´on en castellano o alg ´un len-
guaje formal que se agrega al c ´odigo para mejorar su comprensi ´on por parte de
un lector humano. Los comentarios no tienen efecto alguno sobre el accionar del
cabezal.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 74 of 312 --

75
Leer con Atenci ´on
Al igual que en el caso de los nombres de identificadores y de la in-
dentaci ´on, en los comentarios tambi ´en existen comunidades donde se
utilizan los comentarios para alimentar ciertas herramientas externas de
tratamiento de c ´odigo, por lo que ciertos comentarios deben ser escritos
utilizando una sintaxis r´ıgida, adecuada para el tratamiento autom ´atico.
En este caso, los comentarios incluyen un sublenguaje espec´ıfico que si
bien no es parte del programa original, es importante para la aplicaci ´on
de las herramientas asociadas. Es importante, entonces, al aprender un
lenguaje nuevo, establecer cu ´ales son las reglas r´ıgidas y cu ´ales las no-
ciones de estilo. En el caso de GOBSTONES, todos los comentarios son
meramente estil´ısticos.
En GOBSTONES, los comentarios se dividen en dos grupos:
los comentarios de l´ınea, y
los comentarios de p ´arrafo.
Un comentario de l´ınea comienza con un s´ımbolo o grupo de s´ımbolos, y con-
tin ´ua hasta el final de la l´ınea actual; todo lo que se escriba desde el s´ımbolo de
comentario de l´ınea hasta el final de l´ınea es ignorado durante la ejecuci ´on. Un
comentario de p ´arrafo comienza con un s´ımbolo o grupo de s´ımbolos y contin ´ua
hasta la primera aparici ´on de otro s´ımbolo o grupo de s´ımbolos coincidente con
el primero; todo el texto que aparece enmarcado entre estos pares de s´ımbolos
es ignorado durante la ejecuci ´on. En GOBSTONES coexisten 3 estilos de comen-
tarios. En el estilo C-like, el s´ımbolo // se utiliza para indicar comentarios de
l´ınea, y los s´ımbolos /* y */ para encerrar comentarios de p ´arrafo. En el es-
tilo HASKELL-like, el s´ımbolo -- indica comentarios de l´ınea, y los s´ımbolos {-
y -} encierran comentarios de p ´arrafo. Finalmente, en el estilo PYTHON-like, el
s´ımbolo # indica comentarios de l´ınea y el s´ımbolo ’’’ indica el inicio y fin de los
comentarios de p ´arrafo.
Los comentarios son ´utiles para una serie de prop ´ositos diferentes. Por ejem-
plo:
describir la intenci ´on de un procedimiento (o cualquier parte del c ´odigo), es
decir su comportamiento esperado;
describir la intenci ´on de un par ´ametro, el conjunto de sus valores posibles,
Todav´ıa no hemos hablado de
par ´ametros. Es un tema que se
tratar ´a en la Unidad siguiente.
o lo que se intenta representar con ´el;
eliminar temporalmente un comando para probar el programa sin ´el, pero
sin borrarlo del mismo;
brindar informaci ´on diversa acerca del c ´odigo, como ser el autor del mismo,
la fecha de creaci ´on, etc ´etera.
Como ejemplo de uso de comentarios, se ofrece una versi ´on comentada del
Esta forma de comentar preten-
de mostrar la mayor´ıa de las for-
mas usuales de comentarios en
un solo programa, lo que resulta
en un estilo recargado que no es
el usualmente utilizado. En ge-
neral, los comentarios se limitan
al prop ´osito y precondici ´on, y al-
guna que otra aclaraci ´on ocasio-
nal en el c ´odigo (¡y no como en
este ejemplo, que cada l´ınea tie-
ne comentarios!)
procedimiento DibujarLineaNegra2HaciaElNorte.
{-
Autor: Fidel
Fecha: 08-08-08
-}
procedure DibujarLineaNegra2HaciaElNorte()
{-