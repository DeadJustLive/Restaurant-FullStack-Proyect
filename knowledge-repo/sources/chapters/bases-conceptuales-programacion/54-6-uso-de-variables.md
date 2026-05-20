# 6. Uso de variables

Otros conceptos dados en el libro no entran correctamente en esta clasifica-
ci ´on. Por esa raz ´on ofrecemos adem ´as un mapa conceptual de los conceptos
principales (los principales de los que fueron categorizados, y los que no lo fue-
ron), mostrando as´ı la interrelaci ´on que existe entre todas las ideas trabajadas.
El mapa conceptual de este libro se presenta en el gr ´afico G.1.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 21 of 312 --

22
G.1. Mapa conceptual del libro
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 22 of 312 --

23
La disciplina de la programaci ´	on
En este primer cap´ıtulo comenzaremos a conocer el mundo de la programaci ´on.
Analizaremos introductoriamente la idea de lenguaje de programaci ´on y de pro-
grama, y veremos c ´omo surge la necesidad de contar con este tipo de lenguajes,
a partir de analizar brevemente la historia del surgimiento de los mismos.
A partir de estas nociones iniciales acerca de qu ´e trata la programaci ´on y
del concepto de lenguaje de programaci ´on nos prepararemos para aprender las
nociones fundamentales que todo programador maneja.
1.1. ¿Qu ´e es la programaci ´on?
La programaci ´on es una disciplina que requiere simult ´anemente del uso de cier-
to grado de creatividad, un conjunto de conocimientos t ´ecnicos asociados y la
capacidad de operar constantemente con abstracciones (tanto simb ´olicas como
enteramente mentales).
La creatividad necesaria para programar no se diferencia demasiado de aque-
lla utilizada para producir textos. Sin embargo, lo que hace a la programaci ´on algo
especial es que requiere emplear un conjunto de conocimientos t ´ecnicos asocia-
dos a la manipulaci ´on de las computadoras. Esto agrega un grado notable de
rigurosidad a esta actividad, ya que no podemos programar sin tener en cuenta
este aspecto. Por otra parte, al poseer una naturaleza ligada a la resoluci ´on de di-
ferentes problemas del mundo real, se requiere de una capacidad de abstracci ´on
que permita operar sin que los conocimientos t ´ecnicos limiten al programador a
resolver adecuadamente dichos problemas.
Para Reflexionar
Ejemplos de actividades que requieren:
un uso intensivo de la creatividad son las relacionadas con el arte;
conocimientos t ´ecnicos profundos son las relacionadas con la me-
dicina, electr ´onica y qu´ımica;
operar continuamente en abstracto son las relacionadas con filo-
sof´ıa, l ´ogica y matem ´atica.
Todas las actividades mencionadas parecen dis´ımiles. ¿Por qu ´e la pro-
gramaci ´on incluye y utiliza intensamente dichas capacidades?
A lo largo de la vida los seres humanos continuamente enfrentamos todo tipo
de problemas. Para ello nos valemos de diversas herramientas, que combinadas
de maneras innovadoras ampl´ıan el espectro de soluciones y vuelven factible el
desarrollo. Los programadores se dedican principalmente a construir programas.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 23 of 312 --

24
Leer con Atenci ´on
¿Qu ´e es un programa? Un programa es una descripci ´on ejecutable de
soluciones a problemas computacionales, es decir, un texto descriptivo
que al ser procesado por una computadora da soluci ´on a un problema
propuesto por los humanos. De esta manera, la parte descriptiva de los
programas es el texto que el programador le provee a la computadora.
Definici ´on 1.1.1. Un programa es una descripci ´on ejecutable de soluciones a
problemas computacionales.
La descripciones dadas por los programas pueden estar escritas con diferentes
s´ımbolos y para diferentes prop ´ositos. Cuando el c ´odigo consiste mayormente de
palabras y nociones que son m ´as sencillas para que manejen los humanos, con
el objetivo de que puedan entender y construir los programas, hablamos de un
lenguaje de alto nivel, y al c ´odigo resultante lo llamamos c ´odigo fuente del pro-
grama. Cuando el c ´odigo consiste mayormente de n ´umeros y s´ımbolos de dif´ıcil
comprensi ´on para los humanos, pero de r ´apida interpretaci ´on para su ejecuci ´on
por una m ´aquina, hablamos de un lenguaje de bajo nivel, y al c ´odigo resultante
lo llamamos c ´odigo objeto o c ´odigo ejecutable. Hablaremos entonces de un nivel
alto de abstracci ´on cuando nos estemos refiriendo a abstracciones m ´as cercanas
a las ideas del problema a ser solucionado, a la mente de los programadores; y
de nivel bajo de abstracci ´on cuando nos refiramos a abstracciones m ´as cerca-
nas a las ideas relacionadas a las formas de funcionamiento de las m ´aquinas
que ejecutan los programas.
Es importante observar que tanto el c ´odigo fuente como el c ´odigo ejecutable
est ´an conformados por s´ımbolos, y en ese sentido es correcto llamar a ambos
programas. Esto suele crear confusi ´on, pues entonces la palabra programa se
utiliza para dos prop ´ositos diferentes: el c ´odigo que escribe el programador, y que
es el objeto de estudio de este libro, y el c ´odigo que ejecuta la computadora, que
es el resultado de varios procesos de traducci ´on y compilaci ´on sobre el c ´odigo
fuente (y que es de mucha menos relevancia a la hora de aprender a programar).
Actividad 1
Es sabido que a diario interactuamos constantemente con progra-
mas. Razone qu ´e conceptos posee actualmente sobre los programas
y contr ´astelos con la definici ´on que acaba de leer. Adem ´as piense:
1. ¿qu ´e problemas solucionan los programas que utiliza a diario?
2. ¿qu ´e diferencias existen con los problemas que no puede resolver
por medio de una computadora?
3. ¿puede ubicar entre sus programas algo de c ´odigo fuente? (Suge-
rencia: busque en el programa navegador de internet una opci ´on
de “visualizar c ´odigo fuente”.)
Si bien cuando escribimos el c ´odigo fuente de un programa utilizamos s´ımbolos
como los del lenguaje natural, este texto debe poder ejecutarse. Esa caracter´ısti-
ca hace que los programas se diferencien de otros textos, ya que no cualquier
texto es ejecutable por una computadora. Lo que hace a un texto ejecutable es
su sintaxis dura, que no es m ´as que un conjunto de reglas estrictas de un deter-
La llamamos dura porque debe
respetar de manera estricta cier-
tas reglas de formaci ´on. En es-
to se diferencia bastante de la
sintaxis de los lenguajes, donde
si bien hay reglas, existen nu-
merosas excepciones. E incluso
cuando un texto en lenguaje na-
tural no respeta totalmente las
reglas es com ´un que igual pue-
de ser comprendido por un lector
humano.
minado lenguaje de programaci ´on, con las que se escribe el c ´odigo fuente.
En s´ıntesis, la tarea diaria de un programador es codificar, es decir, escribir
programas, y dar soluci ´on a problemas de diversa ´ındole. La tarea consiste en
poder traducir las ideas que los programadores razonan a c ´odigo ejecutable, que
es el que finalmente resolver ´a el problema en cuesti ´on.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 24 of 312 --

25
Programmers have to balance two very different worlds: a world
of structure and a world of imagination. They create abstract con-
cepts using very structured programming languages (like PHP or
JAVA). It’s not an easy task.
http://lifedev.net/2008/07/programmer-creativity-boost/
“Los programadores tienen que
balancear dos mundos bien di-
ferentes: un mundo de estruc-
tura y un mundo de imagina-
ci ´on. Crean conceptos abstrac-
tos usando lenguajes de progra-
maci ´on muy estructurados (co-
mo PHP o JAVA). No es una ta-
rea f ´acil.”
Un elemento fundamental en la codificaci ´on de problemas en forma de progra-
mas es la representaci ´on simb ´olica de la informaci ´on: la informaci ´on concernien-
te a un problema es representada mediante un modelo que luego se expresa a
trav ´es de s´ımbolos, que en el caso de los lenguajes de programaci ´on son repre-
sentados por n ´umeros o letras. Toda la actividad de programaci ´on es un proceso
de codificaci ´on y decodificaci ´on de la informaci ´on representada. Esta codifica-
ci ´on/decodificaci ´on puede darse numerosas veces antes de dar con la soluci ´on
buscada; por ejemplo, el movimiento de los dedos en un teclado es codificado en
se ˜nales el ´ectricas que luego son codificadas como n ´umeros, los cuales son de-
codificados como caracteres que se muestran en una pantalla codificados como
gr ´aficos, que a su vez son codificados con impulsos el ´ectricos que se traducen a
luces que el cerebro humano interpreta como los mencionados caracteres, que
resulta en lo que una persona entiende como escribir en un teclado y ver los
caracteres en la pantalla. Rara vez los usuarios de un sistema de c ´omputo son
concientes de la cantidad de codificaciones y decodificaciones que se producen
cuando utilizan computadoras. Para que los programadores puedan especificar
estas transformaciones existen lenguajes que permiten escribir estos programas.
1.2. ¿Qu ´e son los lenguajes de programaci ´on?
Cuando programamos, no podemos utilizar el lenguaje natural con que nos comu-
nicamos cotidianamente los seres humanos. Por el contrario, los programadores
emplean un lenguaje que la computadora puede interpretar para realizar tareas.
En otras palabras, un lenguaje de programaci ´on.
Una idea fundamental en la programaci ´on, que no es nativa de esta discipli-
na, pero que es donde se aplica con mayor rigor, es la composicionalidad, o sea,
la capacidad de entender algo como una composici ´on de partes, y tratar cada
parte por separado; y si alguna de las partes es demasiado grande, ¡repetimos
el procedimiento! Por ejemplo, una ciudad se compone de barrios, los cuales
est ´an compuestos de manzanas, las cuales est ´an compuestas de casas, que a
su vez est ´an compuestas de ladrillos, y podr´ıamos continuar hasta llegar a las
part´ıculas m ´as elementales (¿los quarks?). En las disciplinas tradicionales, cada
parte es estudiada por una especialidad diferente. En nuestro ejemplo, la l´ınea
de trabajo para dise ˜nar una ciudad posee urbanistas, arquitectos, etc ´etera, hasta
f´ıscos subat ´omicos. . . Cada disciplina, entonces, aborda un nivel y a lo sumo se
relaciona con los dos adyacentes en estas jerarqu´ıas conceptuales. En la progra-
maci ´on, en cambio, es la misma disciplina la que aborda el tratamiento de todos
los niveles de la jerarqu´ıa, desde los bits hasta los sistemas hechos con cientos
de miles de componentes complejos. Esta particularidad de la programaci ´on fue
se ˜nalada por el cient´ıfico de la programaci ´on Edsger Wybe Dijkstra, que es con-
Se pronuncia “ets-
jer w´ıbe d ´aijkstra”.
Fue un cient´ıfico
holand ´es que
vivi ´o entre 1930
y 2002. Pionero
en el desarrollo
de las ciencias de
la computaci ´on y
ganador de numerosos premios
por sus notables contribuciones
a la programaci ´on.
siderado por muchos como uno de los fundadores de la computaci ´on moderna
por sus trabajos fundacionales en programaci ´on estructurada y algoritmos y por
sus opiniones sobre c ´omo debe hacerse y ense ˜narse la programaci ´on. En su
trabajo “Sobre la crueldad de ense ˜nar realmente ciencias de la computaci ´on”, ´el
dice que esta noci ´on es una de las novedades radicales de la computaci ´on, lo
que la hace algo sin precedentes en la historia de la ciencia y la humanidad.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 25 of 312 --

26
Para Ampliar
Realice una b ´usqueda en internet acerca de la figura de Eds-
ger Dijkstra, y considere algunas de sus contribuciones y las
ideas que manejaba. Comience por leer el art´ıculo “On the
cruelty of really teaching computing science” [Dijkstra and ot-
hers, 1989] y profundizar sobre la idea de novedad radical.
http://www.cs.utexas.edu/users/EWD/transcriptions/EWD10xx/
EWD1036.html
.
Para Ampliar
Entre las historias que se cuentan sobre Edsger Dijkstra hay una carac-
ter´ıstica de su personalidad que se reflej ´o en todos sus trabajos. Intente
descubrir cu ´al es.
Lo m ´as notable de esta novedad radical reside en el hecho de que la base de
la jerarqu´ıa de programaci ´on es la ´unica que tiene sustento en el mundo f´ısi-
co. Est ´a constitu´ıda por los circuitos que conforman las computadoras. Todas las
dem ´as son abstractas, imaginarias. Sobre esa capa f´ısica se construyen abstrac-
ciones mentales que permiten imaginarse que el movimiento de energ´ıa en los
circuitos representa n ´umeros y cuentas entre ellos, y que al encender diversas
luces se conforman im ´agenes que pueden, a su vez, representar casi cualquier
cosa: “ventanas” y “botones” en el caso de las interfases gr ´aficas, “dragones” y
“armas” en el caso de los juegos, “palabras” y “dibujos” en el caso de las he-
rramientas de oficina como los procesadores de palabras. Con esta abstracci ´on
de la circulaci ´on de energ´ıa pueden hacerse cuentas de maneras sumamente
veloces lo cual permite resolver problemas de mayor complejidad, simular inteli-
gencia al realizar deducciones mec ´anicamente, controlar mecanismos diversos,
preparar sistemas que reaccionen a cambios en el entorno, y un sinn ´umero de
etc ´eteras; en s´ıntesis, todas las maravillas modernas a las que estamos tan acos-
tumbrados y que hace 100 a ˜nos atr ´as eran apenas una fantas´ıa casi ut ´opica.
Como podemos ver a partir de esto, la programaci ´on trata fundamentalmen-
te de cuestiones abstractas, imaginarias, que no tienen correlato inmediato en el
mundo real. Los programadores, entonces, tenemos que aprender a imaginarnos
cosas inexistentes, dotarlas de estructura y volverlas reales a trav ´es de los pro-
gramas. Y las herramientas que nos permiten llevar esto a cabo son los lenguajes
de programaci ´on, el conjunto de reglas que nos permiten escribir programas de
cierta manera.
Leer con Atenci ´on
Un lenguaje de programaci ´on es una serie de reglas que establecen
qu ´e descripciones ser ´an aceptadas y ejecutadas y cu ´ales no tienen
sentido para el mecanismo de ejecuci ´on provisto por la computadora.
Adem ´as, estas reglas est ´an dise ˜nadas de manera composicional, para
que sea sencillo construir programas de mayor envergadura.
Definici ´on 1.2.1. Un lenguaje de programaci ´on es un conjunto de reglas que
permiten escribir programas para su ejecuci ´on por cierto mecanismo.
Existen muchos y variados lenguajes de programaci ´on, de caracter´ısticas su-
mamente diferentes y que emplean diferentes enfoques con los que podemos
programar. Cada lenguaje comprende un conjunto de ideas que gu´ıan, como su
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 26 of 312 --

27
prop ´osito final, la forma en que codificamos la descripci ´on que otorgaremos a la
Esta forma viene dada por las
reglas que definen c ´omo se
combinan los elementos que el
lenguaje de programaci ´on pro-
vee al programador.
m ´aquina. En todo momento el lenguaje de programaci ´on permite especificar de
manera precisa el trabajo que el programador espera que la computadora realice.
Para Reflexionar
¿Conoce o escuch ´o el nombre de alg ´un lenguaje de programaci ´on?
¿Sabe el lenguaje de programaci ´on con el que se desarroll ´o alg ´un pro-
grama que use a diario?
A su vez, algunos lenguajes de programaci ´on est ´an pensados para volcar mejor
las ideas abstractas que el programador intenta emplear. Estos se conocen co-
mo lenguajes de alto nivel, ya que intentan, con cierto grado de eficacia, soslayar
aquellas tareas que la computadora requiere realizar para que el programa cum-
pla con sus objetos. Pero existen tambi ´en lenguajes de bajo nivel, que nos hacen
definir en mayor o menor medida cada paso que el programa seguir ´a, y por ende,
est ´an ligados a la naturaleza operacional de la m ´aquina. Esta denominaci ´on (de
“alto” y “bajo”) surge de la idea de imaginar que la computadora es la base fun-
dacional sobre la que los programas ejecutan, y que las ideas abstractas se van
construyendo sobre ellas. Justamente, denominamos a un lenguaje de m ´as “alto
nivel” de abstracci ´on cu ´anto m ´as lejos de la base se encuentra, o sea, cuanto
m ´as abstracto, menos relacionados con el proceso real de ejecuci ´on.
Definici ´on 1.2.2. Un lenguaje de programaci ´on de alto nivel es uno que expre-
sa mejor las ideas en las que debe pensar el programador, y en alguna forma
est ´a m ´as alejado (y menos dependiente) de la m ´aquina espec´ıfica que ejecu-
tar ´a cada programa escrito en dicho lenguaje.
Definici ´on 1.2.3. Un lenguaje de programaci ´on de bajo nivel es uno que expresa
mejor las ideas propias de los mecanismos de ejecuci ´on, por lo que es m ´as
dependiente de la m ´aquina espec´ıfica que ejecutar ´a cada programa escrito en
dicho lenguaje.
En algunos cursos de programaci ´on inicial suele utilizarse una forma de lengua-
je denominada com ´unmente pseudoc ´odigo, que se confunde con la de lenguaje
de programaci ´on. En este pseudoc ´odigo se utiliza una combinaci ´on entre re-
glas precisas de lenguajes de programaci ´on y formas m ´as libres propias de los
lenguajes naturales. Sin embargo, a nuestro entender, no es correcto conside-
rar que el pseudoc ´odigo es un lenguaje de programaci ´on, pues no existe un
mecanismo exacto de ejecuci ´on, quedando librados muchos detalles a la inter-
Existen algunos proyectos que
proveen un modelo de ejecu-
ci ´on para cierta forma de “pseu-
doc ´odigo”. Sin embargo, al pro-
veer un modelo de ejecuci ´on
preciso y completo, el pseu-
doc ´odigo pasa a transformarse
en c ´odigo, por lo que no es
correcto seguirlo llamando de
aquella manera.
pretaci ´on del lector. En este libro sostenemos que la mejor manera de aprender
a programar es enfrentarse con las nociones de c ´odigo desde el comienzo, en
todo caso simplificando, como hacemos aqu´ı, las cuestiones m ´as complejas, pe-
ro siempre buscando que los programas que se escriben puedan ser ejecutados
correctamente, por lo que desaconsejamos de manera fuerte el uso de cualquier
tipo de pseudoc ´odigo.
El desarrollo de los lenguajes de programaci ´on es guiado fundamentalmente
por la b ´usqueda del nivel de abstracci ´on adecuado para poder expresar con faci-
lidad cierto tipo de soluciones a los problemas a resolver. Podr´ıa decirse que los
lenguajes de programaci ´on surgieron y se desarrollaron a partir de la necesidad
de reconciliar dos mundos: el mundo operacional o f´ısico, relativo a la ejecuci ´on
de bajo nivel de las computadoras; y el mundo denotacional o abstracto, definido
por las ideas que manejan los programadores. Las primeras computadoras con
programas solo aceptaban programas escritos en lenguajes de bajo nivel. Eso
hac´ıa la tarea de programar extremadamente dif´ıcil, propensa a errores, y dema-
siado costosa. De ah´ı que los lenguajes fueron evolucionando para aumentar su
nivel de abstracci ´on, alej ´andose cada vez m ´as del modelo espec´ıfico de ejecu-
ci ´on. La b ´usqueda de la abstracci ´on impacta de manera fuert´ısima en la forma
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 27 of 312 --

28
en que pensamos programas. Por eso conviene revisar un poco la historia de la
programaci ´on.
1.3. Breve historia de la programaci ´on
En esta secci ´on vamos a contar una breve (y no particularmente precisa) historia
de la programaci ´on, con el objetivo de tener un panorama de c ´omo se clasifi-
can los lenguajes modernos, y c ´omo esto influye en la forma en que se piensan
programas. Nos limitaremos a hablar de la parte “moderna” de la historia, des-
de el surgimiento de las computadoras con v ´alvulas y circuitos hasta nuestros
d´ıas, omitiendo la “prehistoria” de las m ´aquinas de calcular, teor´ıas fundaciona-
les, etc ´etera.
1.3.1. Surgimiento de las computadoras
Las computadoras como las conocemos actualmente surgieron durante la pri-
mera mitad del siglo XX. En 1936, Alan Turing desarroll ´o la idea de m ´aquina de
Alan Mathison
Turing fue un
matem ´atico, l ´ogico,
criptoanalista e
inform ´atico ingl ´es
que vivi ´o entre
1912 y 1954. Famo-
so por desarrollar
las ideas de algoritmo y de
computaci ´on, determin ´o los
l´ımites de la computabilidad, o
sea, de la capacidad de resolver
problemas mediante algoritmos.
Es considerado el padre de las
ciencias de la computaci ´on.
c ´omputo universal a trav ´es de sus m ´aquinas de Turing, que fueron los primeros
dispositivos te ´oricos en contar con la noci ´on de un “programa”, o sea un dato que
se le suministraba a la m ´aquina y que afectaba su comportamiento. Turing inten-
taba resolver el problema de decodificar los mensajes del ej ´ercito alem ´an durante
la guerra, y se enfrentaba con el problema de que su equipo no era lo suficien-
temente veloz para resolver el problema a tiempo, a pesar de que las bases de
c ´alculo eran sencillas. De ah´ı que pens ´o en utilizar m ´aquinas para acelerar el
proceso, y desarroll ´o la teor´ıa necesaria para tales m ´aquinas.
A partir de los trabajos de Turing, John von Neumann desarroll ´o una arquitec-
Se pronuncia “yon
fon n ´oiman”. Ma-
tem ´atico h ´ungaro-
americano, que
vivi ´o entre 1903 y