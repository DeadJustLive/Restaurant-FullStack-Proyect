# 4 ´INDICE GENERAL

1.7. Algoritmo . . . . . . . . . . . . . . . . . . . . . . . . . . . 45
1.7.1. Clasificaci´on de los algoritmos . . . . . . . . . . . . 46
1.7.2. Representaci´on de un algoritmo . . . . . . . . . . . 47
1.8. C´omo solucionar un problema por computador . . . . . . . 66
1.9. Ejercicios propuestos . . . . . . . . . . . . . . . . . . . . . 73
2 Cap´ıtulo 2
Estructura secuencial
2.1. Estructura b´asica de un algoritmo secuencial . . . . . . . . 81
2.2. Pruebas de escritorio . . . . . . . . . . . . . . . . . . . . . 113
2.2.1. Ejemplos . . . . . . . . . . . . . . . . . . . . . . . . 114
2.3. Ejercicios propuestos . . . . . . . . . . . . . . . . . . . . . 115
3 Cap´ıtulo 3
Estructuras de decisi´on
3.1. Decisiones compuestas . . . . . . . . . . . . . . . . . . . . 121
3.2. Decisiones anidadas . . . . . . . . . . . . . . . . . . . . . . 142
3.3. Decisiones m´ultiples . . . . . . . . . . . . . . . . . . . . . 160
3.4. Ejercicios propuestos . . . . . . . . . . . . . . . . . . . . . 174
4 Cap´ıtulo 4
Estructuras de repetici´on
4.1. Conceptos b´asicos . . . . . . . . . . . . . . . . . . . . . . . 179
4.1.1. Contador . . . . . . . . . . . . . . . . . . . . . . . 179
4.1.2. Acumulador . . . . . . . . . . . . . . . . . . . . . . 180
4.1.3. Bandera . . . . . . . . . . . . . . . . . . . . . . . . 181
4.2. Estructura Mientras - FinMientras . . . . . . . . . 182

-- 6 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 5
4.2.1. Prueba de escritorio . . . . . . . . . . . . . . . . . 222
4.3. Estructura Haga - MientrasQue . . . . . . . . . . . . 228
4.3.1. Prueba de escritorio . . . . . . . . . . . . . . . . . 266
4.4. Estructura de repetici´on Para-FinPara . . . . . . . . . 270
4.4.1. Prueba de escritorio . . . . . . . . . . . . . . . . . 312
4.5. Ejercicios propuestos . . . . . . . . . . . . . . . . . . . . . 316
5 Cap´ıtulo 5
Procedimientos y funciones
5.1. Procedimiento . . . . . . . . . . . . . . . . . . . . . . . . . 325
5.2. Funciones . . . . . . . . . . . . . . . . . . . . . . . . . . . 338
5.3. Ejercicios propuestos . . . . . . . . . . . . . . . . . . . . . 347
6 Cap´ıtulo 6
Vectores y matrices
6.1. Vectores . . . . . . . . . . . . . . . . . . . . . . . . . . . . 351
6.1.1. Declaraci´on de un vector . . . . . . . . . . . . . . . 352
6.1.2. Almacenamiento de datos en un vector . . . . . . . 356
6.1.3. Recuperaci´on de datos almacenados en un vector . 358
6.2. Matrices . . . . . . . . . . . . . . . . . . . . . . . . . . . . 408
6.2.1. Declaraci´on de una matriz . . . . . . . . . . . . . . 409
6.2.2. Almacenamiento de datos en una matriz . . . . . . 410
6.2.3. Recorrido de una matriz . . . . . . . . . . . . . . . 411
6.3. Ejercicios propuestos . . . . . . . . . . . . . . . . . . . . . 440

-- 7 of 450 --



-- 8 of 450 --

Presentaci´	on
La importancia que ha tomado el mundo de la inform´atica y la
computaci´on durante los ´ultimos a˜nos ha sido tal que ha llegado a permear
todas las ´areas del saber humano. Siendo la programaci´on de computadores
uno de los aspectos relevantes dentro del mundo de la computaci´on
y el manejo de procesos algor´ıtmicos una tarea cotidiana dentro del
mundo organizacional, se hace necesario para quienes trabajan y quienes
aspiran a trabajar en los sistemas empresariales tener conocimientos y
desarrollar habilidades l´ogicas y algor´ıtmicas que les permitan tener un
mejor desempe˜no.
Esta obra pretende explorar la l´ogica de programaci´on, los algoritmos
y los diagramas de flujo con el prop´osito de ofrecer una alternativa
actualizada para el aprendizaje de estos temas a quienes se inician en
el estudio de esta interesante ´area. En ella, los autores han expuesto sus
conocimientos y han plasmado sus diversas experiencias obtenidas como
profesores durante varios a˜nos en instituciones de educaci´on superior en
las carreras donde se hace imprescindible el aprendizaje de la algoritmia y
la l´ogica de programaci´on.
Este texto se ha escrito buscando dar una mirada sencilla y pr´actica a
la l´ogica de programaci´on, exponiendo claramente los conceptos pero sin
tratar de entrar en formalismos innecesarios que dificulten el aprendizaje.
A su vez, se utilizan ejemplos de diferentes tipos para ilustrar cada uno de
los t´opicos estudiados en cada cap´ıtulo, desde los m´as sencillos hasta otros
m´as complejos que gu´ıan paulatinamente al lector en la forma como deben
resolverse los problemas de corte algor´ıtmico, promoviendo el desarrollo de
las habilidades necesarias en la escritura de algoritmos.
Para el desarrollo de los temas, la obra ha sido escrita en los siguientes
seis cap´ıtulos:
Cap´ıtulo 1, Fundamentos: este cap´ıtulo introduce al lector en los
conceptos generales sobre la l´ogica de programaci´on y la algoritmia.

-- 9 of 450 --

Se inicia con los aspectos m´as relevantes de la historia y origen de la
computaci´on; seguidamente se abordan los conceptos de datos y sus tipos,
las variables y las constantes, los operadores y las expresiones, los tipos de
algoritmos y c´omo solucionar problemas a trav´es de los algoritmos.
Cap´ıtulo 2, Estructura secuencial: a trav´es de este cap´ıtulo se hacen
las explicaciones generales sobre c´omo escribir los primeros algoritmos,
tanto en pseudoc´odigo como con diagramas de flujo y la forma adecuada
de probarlos. El cap´ıtulo expone una buena cantidad de ejemplos de
algoritmos suficientemente documentados.
Cap´ıtulo 3, Estructuras de decisi´on: en este apartado se exponen de
forma clara las instrucciones necesarias para indicar a un algoritmo la
forma de realizar un conjunto de tareas dependiendo de una condici´on.
Se utilizan ejemplos documentados sobre las principales estructuras de
decisi´on: simple, compuesta, anidada y m´ultiple.
Cap´ıtulo 4, Estructuras de repetici´on: se inicia definiendo los t´erminos
de contador, acumulador y bandera, utilizados durante todo el cap´ıtulo.
Posteriormente se tratan cada una de las instrucciones repetitivas como
son: el ciclo Mientras-FinMientras, el ciclo Haga-MientrasQue y
el ciclo Para-FinPara. Todas estas estructuras son explicadas desde el
punto de vista conceptual y pr´actico, con el fin de que el lector comprenda
no solamente los conceptos sino que aprenda a utilizarlos en la soluci´on de
problemas algor´ıtmicos.
Cap´ıtulo 5, Procedimientos y Funciones: se llevan a cabo las definiciones
de lo que son procedimientos y funciones, su uso dentro de la algoritmia y
se expone una serie de ejemplos pr´acticos que ilustran la utilidad de este
tipo de instrucciones.
Cap´ıtulo 6, Vectores y Matrices: en este ´ultimo cap´ıtulo se introduce
al lector en el tema de los arreglos unidimensionales y bidimensionales
con el prop´osito de que se comprendan los conceptos generales sobre estas
estructuras de datos y se aprendan a utilizar cuando se deban resolver
problemas algor´ıtmicos que as´ı lo requieran.
Organizaci´on de la obra.
Para abordar cada tema el libro fue organizado en cap´ıtulos, cada
uno desarrolla los conceptos te´oricos, llevados a la pr´actica con los
suficientes ejemplos que ilustran su uso en la soluci´on de problemas de
tipo computacional.

-- 10 of 450 --

Uno de los aspectos a destacar, es la forma como fueron abordadas las
soluciones de los ejemplos propuestos. Para cada uno se hizo un an´alisis
previo, tratando de tener un mayor dominio sobre la problem´atica, ya que
es fundamental un total entendimiento para poder emprender la b´usqueda
de una adecuada soluci´on. Cada ejemplo desarrollado fue cuidadosamente
detallado desde su an´alisis hasta la concepci´on del algoritmo, representados
a trav´es de pseudoc´odigo y en la mayor´ıa de los casos acompa˜nados
de su correspondiente diagrama de flujo; adicionalmente, se hace una
descripci´on minuciosa de cada una de las instrucciones que fueron usadas.
Esta metodolog´ıa busca crear la buena pr´actica de realizar un an´alisis
detallado del problema y entender cada uno de los pasos de la soluci´on.
Adicionalmente, dentro de las diferentes p´aginas el lector encontrar´a el
recuadro de Buenas pr´acticas y el recuadro de Aclaraciones:
Buena pr´actica:
En este recuadro se mostrar´an recomendaciones que
se espera sean seguidas por los lectores de esta
obra, con el fin de que aprendan, desde sus inicios
como desarrolladores, buenas pr´acticas para un mejor
desempe˜no profesional.
Aclaraci´on:
Esta anotaci´on, es usada para resaltar algunos
conceptos o dar mayor claridad sobre aspectos que
son fundamentales en el desarrollo de algoritmos.
Otra caracter´ıstica importante, es que se aprovech´o el formato digital
de la obra, de tal forma que cada una de las referencias escritas tienen
presente un link, permitiendo que con solo pulsar la referencia se puede
dirigir al sitio correspondiente.
Por ´ultimo, al finalizar cada cap´ıtulo, los autores han dejado una serie
de ejercicios propuestos que van desde preguntas te´oricas que pretenden
afianzar en el lector los conceptos estudiados, hasta los enunciados de
ejercicios pr´acticos para que el estudioso escriba los algoritmos que
solucionen el problema propuesto utilizando la l´ogica y la algor´ıtmia.

-- 11 of 450 --

Con todo el trabajo realizado desde la concepci´on de esta obra, pasando
por su escritura y elaboraci´on de la gran cantidad de algoritmos que en
ella se exponen, los autores esperan hacer una contribuci´on en la difusi´on
de la l´ogica de programaci´on y la algoritmia, as´ı como orientar y facilitar
el aprendizaje de estos temas a todos aquellos lectores apasionados de la
inform´atica y la computaci´on. Es por eso, que para lograr este prop´osito
el libro fue concebido bajo la Licencia Creative Commons permitiendo el
uso y la distribuci´on gratuita, siempre y cuando la obra se conserve igual
y se haga el respecivo reconocimiento a sus creadores.
Por ´ultimo, los autores desean expresar su agradecimiento a todos
aquellos que directa o indirectamente han inspirado este libro, entre los
cuales se encuentran, estudiantes quienes manifiestan la necesidad de un
texto que facilite el aprendizaje, docentes que resaltan la importancia de
contar con un libro de referencia y gu´ıa en el sal´on de clases y profesionales
de diferentes ´areas quienes desean contar con una referencia de consulta
para resolver alguna duda o inquietud.

-- 12 of 450 --

Cap´ıtulo 1
Fundamentos
Hazlo todo tan simple como sea
posible, pero no m´as simple
Albert Einstein
Objetivos del cap´ıtulo:
Conocer los aspectos m´as relevantes de la
historia de la programaci´on.
Comprender los conceptos b´asicos de la L´ogica
de Programaci´on.
Expresar un algoritmo en una de las formas de
representaci´on.
Identificar, evaluar y construir operaciones
aritm´eticas, relacionales y l´ogicas.
Aplicar los pasos para la soluci´on de un
problema por computador .

-- 13 of 450 --



-- 14 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 13
1.1. Algo de historia
Al estudiar el origen de la programaci´on, se puede descubrir que los
algoritmos y los programas para computador surgieron antes que los
mismos computadores u otros dispositivos de procesamiento de datos.
Euclides en el a˜no 300 a.C, escribi´o el algoritmo que lleva su nombre
y que es usado en el mundo de las matem´aticas y la computaci´on para
hallar el M´aximo Com´un Divisor (MCD). Al-Khw¯arizm¯ı o Al-Juarismi
(750 - 850 d.C.), matem´atico y astr´onomo persa, considerado como el padre
del ´algebra, escribi´o las reglas para realizar las operaciones b´asicas de la
aritm´etica [Mancilla et al., 2016], denominadas la Reglas de al-Kharizmi;
del nombre de este personaje se deriv´o el t´ermino algoritmo. Leonardo
de Pisa, tambi´en conocido como Leonardo Fibonacci, hacia el a˜no 1202,
dise˜n´o el algoritmo para generar la sucesi´on de los n´umeros de Fibonacci.
As´ı mismo, los or´ıgenes e historia del computador y el procesamiento
de datos se remontan a miles de a˜nos atr´as, cuando el hombre empez´o a
registrar informaci´on. Sus manifestaciones iniciales se dieron en los muros
de las cavernas cuando los primitivos hicieron sus primeros registros. Con
el paso del tiempo surge la necesidad de realizar c´alculos, de esta forma se
introdujeron dispositivos que permit´ıan realizarlos de manera m´as r´apida.
A continuaci´on, se har´a un recorrido hist´orico por los acontecimientos y
personajes m´as representativos que han dejado su legado en la evoluci´on
de esta tem´atica. Aunque se visualizan como una serie de eventos aislados,
muchos de ellos han convergido en la creaci´on de nuevos desarrollos.
El ´abaco, que es el instrumento m´as antiguo que se conoce con
el cual se hacen operaciones matem´aticas sencillas, fue inventado
por las antiguas civilizaciones hace miles de a˜nos [Oviedo, 2013]. En
la actualidad es usado como un instrumento did´actico en muchas
escuelas del mundo. El imperio Inca, hacia los a˜nos 1300 a 1500 d.C.
usaba un sistema de cuentas, conocido con el nombre de Quipu, que
a trav´es de nudos en cuerdas de colores registraba la contabilidad de
sus inventarios.
Luego de muchos a˜nos, se empezaron a registrar dise˜nos de aparatos
mec´anicos que cumpl´ıan tareas de calculadora. En el a˜no 1500
de nuestra era, aproximadamente, Leonardo Da Vinci, dise˜n´o una
sumadora mec´anica, que fue construida muchos a˜nos despu´es, en
1968.

-- 15 of 450 --

14 Fundamentos
En 1617, el matem´atico escoc´es John Napier inventa las varillas
que llevan su apellido. Las varillas de Napier permit´ıan realizar
multiplicaciones, divisiones y la extracci´on de ra´ıces.
Para el a˜no 1623, Wilhelm Schickard, alem´an, esboz´o una m´aquina
que realizaba las 4 operaciones b´asicas, su invento fue derivado de
las varillas de Napier. Este instrumento fue bautizado por su creador
como el Reloj calculante. No existe evidencia de que este dise˜no se
hubiese materializado en aquella ´epoca, pero en tiempos recientes se
construyeron modelos basados en su dise˜no.
El franc´es Blaise Pascal en 1642, construye la primera sumadora
mec´anica, llamada Pascalina, fue inspirada en el dise˜no de Da Vinci.
Entre 1671 y 1674 el fil´osofo y matem´atico alem´an Gott-
fried Wilheim Von Leibnitz mejora el dise˜no de Pascal y
construye la Calculadora Universal; adicionalmente pod´ıa calcular
multiplicaciones y divisiones a partir de sumas y restas sucesivas.
Adem´as, gracias a este gran genio se cuenta con el sistema binario
o de base 2 (b2) que utiliza el 0 y el 1, tal como se conoce en la
actualidad. El sistema binario es el sistema num´erico por naturaleza
de los computadores. A este matem´atico tambi´en se le debe el
concepto de arreglo o matriz [Mancilla et al., 2016].
Hasta este momento de la historia solamente se hab´ıan dise˜nado o creado
instrumentos que permit´ıan hacer c´alculos, ya fuera de forma manual o
mec´anica. Pero a partir del a˜no 1800, se inventan nuevos dispositivos un
poco m´as complejos y con otros prop´ositos.
Entre 1801 y 1804, en Francia, Joseph Jacquard construy´o un telar
para producir telas de manera autom´atica, controlado mediante un
conjunto de delgadas placas de madera perforada.
En 1822, el matem´atico ingl´es Charles Babbage, de la Universidad
de Cambridge, concibi´o la idea de computadores mec´anicos. Dise˜n´o
y construy´o un prototipo de la M´aquina de Diferencias o M´aquina
diferencial, por diferentes inconvenientes este proyecto no se termin´o.
En 1834 inici´o un nuevo proyecto, la creaci´on de la M´aquina
Anal´ıtica; fue dise˜nada como una m´aquina de prop´osito general,
es decir, programable. Ten´ıa memoria, procesador y dispositivos de
entrada y de salida. Su funcionamiento estaba controlado a trav´es
de tarjetas perforadas. Esta m´aquina es considerada la antecesora
de los computadores actuales y Babbage es reconocido como el

-- 16 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 15
padre de la inform´atica. Igual que su primer proyecto, esta m´aquina
tampoco se construy´o, estaba muy adelantada para aquella ´epoca y
las limitaciones t´ecnicas impidieron su desarrollo. No obstante, luego
de m´as de 100 a˜nos de este trabajo, la m´aquina se construy´o siguiendo
los dise˜nos originales, comprobando as´ı que era totalmente funcional.
Augusta Ada Byron, mejor conocida como Ada Lovelace, destacada
en el ´area de las matem´aticas, fue la primera persona que escribi´o un
programa de computador. Trabaj´o al lado de Babbage y escribi´o el
primer conjunto de instrucciones para que fueran ejecutadas por la
m´aquina Anal´ıtica de Babbage [Boullosa, 2016]; aunque su desarrollo
fue te´orico le permiti´o ganarse el reconocimiento como la primera
persona programadora de la historia. Por encargo del gobierno de
Estados Unidos y como un homenaje por este m´erito, se desarroll´o
un lenguaje de programaci´on que lleva su nombre.
Despu´es de m´as de 100 a˜nos de los aportes de Babbage y Lovelace,
se pudieron crear los primeros computadores. Pero esta creaci´on
es un conjunto de diferentes desarrollos en tecnolog´ıa y nuevos
conocimientos que se fueron consolidando hasta obtener los equipos,
los m´etodos algor´ıtmicos y los lenguajes de programaci´on de la
actualidad.
En 1848, George Boole matem´atico y l´ogico ingl´es, hace una gran
contribuci´on a las ciencias de la computaci´on y a la electr´onica,
creando el ´algebra de Boole o ´algebra booleana; con ella se construyen
las expresiones l´ogicas que son constantemente usadas dentro de los
algoritmos computacionales.
En 1887, Herman Hollerith, dise˜n´o la M´aquina de censos, que
funcionaba basada en la l´ogica de Boole y con tarjetas perforadas
que fueron inspiradas en las placas de madera del telar de Jacquard.
En 1896 fund´o la compa˜n´ıa de M´aquinas de tabulaci´on y en 1924 se
fusion´o con otras empresas para fundar la reconocida y a´un vigente
multinacional IBM (International Business Machines Corporation).
Alan Mathison Turing, nacido en Londres, fue matem´atico, l´ogico
y cript´ografo. Se considera uno de los pioneros de la inform´atica
moderna. En 1936 elabor´o la teor´ıa de computador digital,
imaginando una m´aquina llamada M´aquina de Turing, capaz de
resolver problemas matem´aticos siguiendo algunas reglas l´ogicas
[L´opez, 2015].
La M´aquina de Turing, era un dispositivo con una cinta infinita,
que representaba la memoria, en la cual se pod´ıan escribir y

-- 17 of 450 --

16 Fundamentos
leer instrucciones a trav´es de un cabezal. Con esta m´aquina se
estableci´o el marco te´orico que gener´o los actuales computadores
[Areitio and Areitio, 2009].
Luego entre 1939 y 1940 un equipo de ingenieros, dirigido por Alan
Turing, construy´o uno de sus dise˜nos, una m´aquina considerada
un computador electromec´anico de uso especial a la cual llamaron
Bomba; con ella se descifraban los c´odigos de la m´aquina Enigma1
de los alemanes.
En 1941, Konrad Zuse, ingeniero alem´an, construy´o la Z3, un
computador electromec´anico que funcionaba con sistema binario.
Sus programas eran almacenados en una cinta externa. Existe
divergencia de conceptos en considerarla como el primer computador
programable, algunos historiadores difieren de este calificativo,
porque no cumpl´ıa la condici´on de ser un computador de prop´osito
general2.
En 1943, tras el ingreso a escena de nuevas formas para cifrar
mensajes por parte de los alemanes, la m´aquina Bomba de Turing ya
no era eficaz; surge la necesidad de un nuevo dispositivo. El ingl´es
Tommy Flowers, especialista en electr´onica, junto con su equipo de
trabajo crea a Colossus, una m´aquina de prop´osito espec´ıfico que
es considerado como uno de los primeros computadores electr´onicos;
contaba con 1500 v´alvulas o tubos de vac´ıo y utilizaba cintas de papel
perforado para leer los datos.
Para 1944, Howard Aiken, en asocio con IBM construyen el Mark I,
un computador electromec´anico. En ella se materializaron los dise˜nos
de Babbage. Utilizaba cinta de papel perforado para leer sus datos y
sus instrucciones.
Entre 1943 y 1945 se construye el ENIAC (Electronic Numerical
Integrator And Computer - Computador e Integrador Num´erico
Electr´onico) en los Estados Unidos, fue el primer computador
electr´onico de prop´osito general. Conten´ıa 18000 tubos al vac´ıo.
Inicialmente fue pensado para c´alculos bal´ısticos, luego se us´o para
solucionar problemas de tipo cient´ıfico. Junto con esta m´aquina surge
el sistema de codificaci´on de ENIAC, utilizado para programar este
1M´aquina para cifrar y descifrar mensajes. Fue ampliamente usada por los alemanes
en la segunda guerra mundial.
2Un computador de prop´osito general es aquel que puede ser programado para
ejecutar diversas tareas o aplicaciones, a diferencia de los de prop´osito espec´ıfico que
son programados para ejecutar una sola tarea o aplicaci´on.

-- 18 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 17
computador realizando ajustes en sus conexiones. Esta programaci´on
estaba a cargo de 6 mujeres que pasaron a la historia como las
programadoras originales del primer computador electr´onico, ellas
fueron: Jean Jennings Bartik, Betty Snyder Holberton, Frances
Bilas Spence, Kathleen McNulty Mauchly Antonelli, Marlyn Wescoff
Meltzer y Ruth Linchterman Teitelbaum.
En 1945 el matem´atico h´ungaro John Von Neumann, considerado
el padre de los computadores electr´onicos, dise˜n´o el Computador de
Programa Almacenado. Este concepto revolucion´o el mundo de la
computaci´on, a partir de ´el se tienen los computadores que existen
en la actualidad. Las instrucciones se almacenan y procesan dentro
de la m´aquina y solamente se deben ingresar nuevas instrucciones
para ejecutar diferentes instrucciones; con este nuevo sistema no se
requiere cambiar las conexiones de los cables de la m´aquina para
asignarle nuevas tareas.
Konrad Zuse, el mismo creador del Z3, en 1946 invent´o el
Plankalk¨ul (plan de c´alculo); primer lenguaje de programaci´on
registrado en la historia y predecesor de los actuales lenguajes de
programaci´on algor´ıtmicos. Era un lenguaje te´orico pensado para
ser usado en los Z3. Fue dado a conocer solo hasta 1972 y en
el a˜no 2000 lo implementaron en la Universidad Libre de Berl´ın
[Szymanczyk, 2013].
Hacia 1947 crean el transistor en los laboratorios BELL de Estados
Unidos. Con este invento se inicia la miniaturizaci´on de componentes.
En 1949 en la Universidad de Cambridge, Inglaterra, se construy´o el
primer computador con el concepto de Von Neumann, denominado
EDSAC (Electronic Delay Storage Automatic Calculator). Este
computador pas´o a los libros de historia como el primer computador
electr´onico con programa almacenado. Lo sucedi´o un a˜no despu´es el
EDVAC (Electronic Discrete Variable Automatic Computer). Estos
equipos usaban tecnolog´ıa de tubos de vac´ıo y la entrada de datos se
hac´ıa usando cintas de papel perforado.
Se crea el Lenguaje Ensamblador en 1950, que mejora la expresividad,
haciendo que la programaci´on fuera m´as comprensibles en este
momento de la historia.
Grace Murray Hooper, fue una destacada cient´ıfica computacional
y militar nacida en Nueva York. En 1951 implement´o el primer
compilador3 para un lenguaje de programaci´on. Ella introdujo el
3Un compilador es un programa que traduce instrucciones de un lenguaje a otro.

-- 19 of 450 --

18 Fundamentos
concepto que los lenguajes deb´ıan ser independientes de la m´aquina
en que se ejecutan.
En 1951 inicia operaciones el UNIVAC I (Universal Automatic
Computer), primer computador electr´onico de programa almacenado
y prop´osito general que fue comercializada; se utiliz´o inicialmente con
fines cient´ıficos y militares, luego se us´o en aplicaciones comerciales.
Estaba construido con v´alvulas de vac´ıo y utilizaba unidades de cinta
magn´etica para almacenar datos.
Los laboratorios BELL de Estados Unidos en 1955 fabrican
a Tradic, la primera calculadora que hace uso del transistor
[Szymanczyk, 2013]. Esto marc´o el inicio del desarrollo de una nueva
generaci´on de computadores, logrando una producci´on m´as variada
que permiti´o la comercializaci´on de diversos modelos.
Entre 1957 y 1960 hacen su aparici´on los lenguajes FORTRAN,
Algol 58, LISP, COBOL, BASIC y PL/1. FORTRAN (Formula
Translating) utilizado para realizar c´alculos de tipo cient´ıfico. Algol
58 (Algorithmic Language) catalogado como el primer lenguaje
algor´ıtmico, muy usado como herramienta de ense˜nanza. LISP (LISt
Processor), se introdujo inicialmente en el campo de la inteligencia
artificial. COBOL (COmmon Business Oriented Language) es un
lenguaje orientado a los negocios. BASIC (Beginner’s All purpose
Symbolic Instruction Code - C´odigo simb´olico de instrucciones
de prop´osito general para principiantes), creado inicialmente para
facilitar la ense˜nanza y el aprendizaje de la programaci´on a aquellas
personas que no eran expertas en el campo de la computaci´on. PL/1
(Programming Language 1 ) creado para aplicaciones cient´ıficas y
comerciales, que sirvi´o de base para la generaci´on del Lenguaje C
y C++.
Hacia 1965 se construyen los primeros computadores haciendo uso del
circuito integrado o chip, reduciendo significativamente su tama˜no y
aumentando su eficiencia. El chip fue inventado por Jack Kilby en
1958.
En 1969 se establece una comunicaci´on entre dos computadores
ubicados en dos Universidades de Estados Unidos y se da origen
a ARPANET, que evolucion´o a lo que hoy se conoce como Internet.
En los laboratorios BELL, en el a˜no 1969 se crea el sistema operativo
UNIX y en 1970 el Lenguaje B, orientado a la construcci´on de
sistemas operativos y predecesor del lenguaje C.

-- 20 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 19
En 1970 se publica el Lenguaje Pascal, nombrado as´ı en honor a
Blaise Pascal, el inventor de Pascalina mencionada anteriormente.
Inicialmente este lenguaje se desarroll´o con fines acad´emicos, pero
su facilidad de aprendizaje permiti´o que se popularizara y fuera
empleado para construir programas con diferentes prop´ositos.
Entre 1970 y 1971, Intel crea el microprocesador, permitiendo as´ı el
desarrollo de los computadores personales.
Hacia 1971, nace el correo electr´onico, su creador fue Ray Tomlinson.
Este medio de comunicaci´on ha tomado tanta relevancia que es uno
de los m´as utilizados tanto a nivel empresarial como personal.
En el a˜no 1972 se crean los lenguajes Smalltalk, uno de los primeros
lenguajes orientados a objetos. Lenguaje C, creado para desarrollar
sistemas operativos y aplicaciones de prop´osito general. PROLOG
(PROgrammation in LOGique), es un lenguaje l´ogico, ampliamente
utilizado en el campo de la inteligencia artificial.
Nace, sin acogida, en 1973 el primer computador personal (PC),
denominado Alto, creado por Xerox. Su fracaso obedeci´o a sus
elevados costos.
En 1975 se crea un nuevo computador personal, el Altair 8800;
comercializado con gran ´exito y reconocido como el primer
computador personal, quit´andole la gloria al Alto de Xerox. En este
mismo a˜no, Bill Gates y Paul Allen, crearon el Altair Basic para el
Altair 8800, un int´erprete del Lenguaje Basic, d´andole as´ı inicio a
una de las grandes compa˜n´ıas del software, Microsoft Corporation.
En 1977 sale al mercado uno de los computadores m´as populares de
la ´epoca, el Apple II, sus ventas fueron masivas tanto para hogares
como para empresas.
La comercializaci´on de software para los usuarios se inicia en 1978.
ADA fue dado a conocer en 1980, creado por encargo del
Departamento de Defensa de los Estados Unidos, es un lenguaje
multiprop´osito y con aplicaci´on en el desarrollo de sistemas de
seguridad y aeron´autica.
Hacia 1981 IBM hace historia con la creaci´on de un nuevo PC basado
en el procesador Intel 8088, su memoria RAM era de 64 KB con
posibilidad de expansi´on a 256 KB. Ven´ıa equipado con una unidad
de diskette de 5 pulgadas y sin disco duro. Su sistema operativo era
el MS-DOS, MicroSoft Disk Operating System, Sistema operativo de
disco de Microsoft que pod´ıa ser inicializado desde un disco flexible.

-- 21 of 450 --

20 Fundamentos
Un a˜no despu´es se popularizan los computadores clones de IBM.
Se publica el Lenguaje C++ en 1983, una evoluci´on del Lenguaje C
con orientaci´on a objetos.
En 1984, Apple lanza el Macintosh. Su software, basado en ´ıconos y
gr´aficos tuvo bastante ´exito por la usabilidad que ofrec´ıa.
El sistema operativo Windows empieza a comercializarse en 1985.
En 1989, sale al mercado el procesador 486 de Intel.
Internet comienza su expansi´on hacia el a˜no 1989. Iniciando as´ı un
desarrollo vertiginoso que a´un no para de crecer.
Para 1990 Windows evoluciona a la versi´on 3.0.
Finlandia, en 1991, le entreg´o al mundo de la computaci´on el sistema
operativo Linux, su creador fue Linus Torvalds.
En ese mismo a˜no surgen los lenguajes Python y Visual Basic. Python
tiene una curva de aprendizaje r´apida y permite el desarrollo de
diferentes tipos de aplicaciones. Visual Basic es una evoluci´on del
Basic, es de prop´osito general.
Surge WWW (World Wide Web) en 1993. A trav´es de m´ultiples
hipertextos (link) se pueden enlazar, por medio de Internet, diferentes
tipos de informaci´on tales como textos, im´agenes, v´ıdeos, entre otros.
Mosaic es lanzado al mercado en 1994, como uno de los navegadores
m´as populares en Internet. En ese mismo a˜no, dos estudiantes de
la Universidad de Stanford crean a Yahoo, uno de los motores de
b´usqueda m´as populares de ese tiempo; de igual forma Lycos, otro
motor de b´usqueda hace su aparici´on para competir con Yahoo. Estos
nuevos desarrollos hacen que el uso de Internet se popularice.
En 1995 se suceden varios acontecimientos de gran importancia.
Netscape, logra convertirse en el navegador de m´as uso del momento.
Surge Altavista, otro popular motor de b´usqueda que entra a la
competencia, logrando en poco tiempo convertirse en uno de los
favoritos de los navegantes. Nace Windows 95, un sistema operativo
con interfaz gr´afica, poco a poco fue desplazando al sistema operativo
MS-DOS y a Windows 3.x que era un entorno gr´afico que se
ejecutaba bajo el MS-DOS. Amazon, una de las tiendas virtuales
m´as conocidas, inicia sus operaciones comerciales. En ese mismo a˜no
se crea Java, un lenguaje de prop´osito general que se ha convertido
en uno de los m´as usados en el momento.

-- 22 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 21
Microsoft en 1996, crea Internet Explorer, un navegador para ser
ejecutado en el sistema operativo Windows. Luego fue incorporado
en los equipos de Apple.
PHP (Hypertext Preprocessor - Procesador de Hipertexto), se crea en
1997 como un lenguaje para desarrollo web.
Google es lanzado en 1998 como un motor de b´usqueda muy
prometedor. Actualmente es uno de los m´as usados para realizar
consultas en Internet.
En 1999 se lanza el MSN Messenger Service, un servicio de mensajer´ıa
instant´anea que hoy en d´ıa est´a fusionado con la aplicaci´on Skype.
En ese mismo a˜no crece el temor por el Y2K, tambi´en conocido
como el Problema del a˜no 2000. El Y2K fue un problema que
se present´o en el mundo de la computaci´on a causa de que los
programadores anteriores al a˜no 2000 ten´ıan la costumbre de omitir
los dos primeros d´ıgitos del a˜no, es decir, en lugar de escribir 1999
por ejemplo, lo expresaban como 99. Al llegar el a˜no 2000, muchos
de los computadores iban a tomar el a˜no como 00, lo cual pod´ıa
ocasionar bastantes problemas. El mundo se prepar´o para este evento
y se hicieron los ajustes pertinentes, con lo cual se logr´o reducir los
inconvenientes previstos.
C# (C Sharp) se publica en el a˜no 2001. Es un lenguaje de
programaci´on visual creado por Microsoft.
En el 2003 Apple lanza su navegador Safari.
El t´ermino de WEB 2.0 y sus nuevos servicios es conocido por el
mundo en el a˜no 2004. La Web 2.0 es la transformaci´on que sufre
Internet de pasar de p´aginas web est´aticas a p´agina interactivas,
donde los navegantes no son simples consumidores de informaci´on,
ya pueden interactuar con otros usuarios de la red y producir sus
propios contenidos. Es as´ı como toman relevancia o nacen sitios
como Wikipedia, Youtube, Flickr, My Space, Blogger, Wordpress,
Facebook, LinkedIn, Twitter, Tuenti, servicios de Google, entre
muchos m´as.
Otro aspecto fundamental en la evoluci´on de la computaci´on y en
especial en el ´area de la programaci´on y algoritmia, es el desarrollo
de los actuales smartphone y tablets, dispositivos que permiten
almacenar aplicaciones, mejor conocidas como apps. Son millones las
implementaciones que se han hecho para estos dispositivos, las cuales
involucran la creaci´on de diferentes algoritmos para desarrollar variadas

-- 23 of 450 --

22 Fundamentos
actividades, por ejemplo, encontrar una direcci´on como en el caso de Waze,
buscar alg´un dato en Google, chatear en tiempo real mediante Whatsapp,
gestionar correos electr´onicos con Gmail, compartir informaci´on en una red
social y muchas m´as.
La lista de esta evoluci´on puede continuar y son muchos los dispositivos
y lenguajes que no se han nombrado en este libro, pero que tambi´en han
contribuido al desarrollo de la computaci´on y la algoritmia.
El continuo y vertiginoso desarrollo tecnol´ogico ha hecho que la
programaci´on no sea una competencia solo de los estudiosos de la
computaci´on o la inform´atica, sino tambi´en de muchos profesionales en
diferentes ´areas del conocimiento y del resto de las personas que a diario
interact´uan con tecnolog´ıa.
1.2. Dato
Un dato es una representaci´on simb´olica (un n´umero, letra, gr´afico, entre
otros) de una caracter´ıstica de un elemento u objeto. En este sentido,
se afirma que un dato puede estar representado por una cifra, letra,
palabra o conjunto de palabras que describen una caracter´ıstica (atributo
o propiedad) del elemento. Por ejemplo, “Gabriela Herrera” y “20” pueden
representar el nombre y la edad de una persona respectivamente, donde el
nombre y la edad son las caracter´ısticas de esa persona.
Es necesario aclarar: un solo dato no representa informaci´on, sino
que la informaci´on est´a conformada por un conjunto de datos que, al
ser procesados mediante alg´un mecanismo, constituyen un mensaje para
incrementar el conocimiento de quien lo recibe. Esto significa que solo los
seres humanos o sistemas de c´omputo muy avanzados como los sistemas
expertos procesan informaci´on.
1.2.1 Tipos de datos
Un tipo de dato corresponde a una clasificaci´on que se hace para poder
tratar cada dato de la forma m´as adecuada, seg´un lo que se requiera. El
tipo de dato le indica al dispositivo de procesamiento cuanto espacio de
memoria debe reservar para almacenar el dato, es decir, para determinar
el tama˜no del espacio de memoria. Los tipos de datos m´as comunes y que
se trabajar´an en este libro son: alfanum´ericos, num´ericos y l´ogicos.

-- 24 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 23
Datos alfanum´ericos
Estos datos se componen de la combinaci´on de todos los caracteres
conocidos: letras del alfabeto, d´ıgitos y caracteres especiales, incluyendo
el espacio en blanco. Los datos alfanum´ericos se dividen en car´acter y
cadena.
Caracter(sin tilde): se refiere a los datos que solo tienen un
car´acter, que puede ser una letra del alfabeto, un d´ıgito del 0 al 9
o un car´acter especial. Los valores de tipo car´acter deben encerrarse
entre comillas simples.
Por ejemplo: ’a’, ’R’, ’2’, ’#’, ’@’
Los d´ıgitos que son tratados como caracteres son diferentes a los
valores num´ericos, por lo tanto, no se deben realizar operaciones
aritm´eticas con ellos.
Cadena: son los datos que est´an compuestos por un conjunto de
letras del alfabeto, d´ıgitos y caracteres especiales, incluyendo el
espacio en blanco. Los datos de tipo cadena deben encerrarse entre
comillas dobles.
Son ejemplos de datos de tipo cadena los siguientes: “Carrera 17 #
12 – 65”, “Gato”, “Jacobo Herrera”, “75478923”, “01800043433”.
Los dos ´ultimos ejemplos podr´ıan corresponder a un n´umero de una
c´edula y al n´umero de una l´ınea de servicio 018000, aunque estos
datos est´an conformados por d´ıgitos, no pueden ser utilizados para
hacer c´alculos num´ericos.
Datos num´ericos
Corresponden a los datos que est´an compuestos por solo n´umeros y
signos (positivo y negativo), es decir, d´ıgitos del 0 al 9, con los cuales se
pueden realizar operaciones aritm´eticas. Estos tipos de datos se subdividen
en: Enteros y Reales.
Entero: son aquellos datos compuestos por n´umeros que no tienen
punto decimal. Pueden ser n´umeros positivos, negativos o el cero.
Ejemplos de este tipo de datos pueden ser: 20, -5, 200, 1500000.

-- 25 of 450 --

24 Fundamentos
Real: son datos con componente decimal, pueden ser positivos,
negativos o cero.
Ejemplos: 1.75, 4.5, 1800000.00, -234.00.
Tenga presente que las unidades de mil no se deben separar con
puntos o comas. Solamente se usa el punto para indicar la parte
decimal.
Datos l´ogicos o booleanos
Son aquellos datos que toman solo uno de los dos posibles valores
booleanos4: Verdadero o Falso. Estos valores son equivalentes a los
d´ıgitos del sistema binario: 1 corresponde a Verdadero y 0 a Falso
[Mancilla et al., 2016]. Por ejemplo, sup´ongase que se necesita almacenar
la respuesta suministrada por un paciente en una cl´ınica sobre si fuma o
no, o sobre si es al´ergico o no a un tipo de medicamento. En ambos casos,
se deber´ıa utilizar este tipo de datos para clasificar el dato suministrado
por el paciente.
1.3. Identificadores
Un identificador es el nombre que se le asigna a las variables, constantes,
funciones, procedimientos y al algoritmo5; esto se hace para que el
algoritmo pueda identificar claramente cada uno de estos elementos.
Para asignar nombres v´alidos en un algoritmo a los elementos
mencionados en el p´arrafo anterior, existen una serie de reglas que facilitan
su escritura. Es importante mencionar tambi´en que, existen reglas y
recomendaciones propias, dependiendo del lenguaje de programaci´on en
el que se vaya a codificar el algoritmo; de esta manera, la forma de asignar
identificadores puede ser ligeramente diferente de un lenguaje a otro.
Para el caso de este texto, se utilizar´an las siguientes reglas o
recomendaciones para escribir identificadores:
Definir identificadores nemot´ecnicos, es decir, alusivos o relacionados
con la funci´on del elemento que se est´a nombrando.
4Un valor booleano solo admite una de dos posibles respuestas que son mutuamente
excluyentes: Verdadero o Falso.
5Estos conceptos se trabajar´an de manera amplia m´as adelante en este cap´ıtulo.

-- 26 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 25
El primer car´acter del identificador debe ser una letra.
No utilizar caracteres especiales dentro de los identificadores como
vocales tildadas, la letra ˜n, o s´ımbolos como: $, #, !, ?, entre otros.
No se deben dejar espacios en blanco dentro del nombre de un
identificador.
No utilizar palabras propias del lenguaje algoritmico / programaci´on
que se est´a utilizando “Palabras reservadas”6.
En un identificador se pueden utilizar varias palabras, preferible-
mente unidas. Tambi´en se puede usar un guion bajo entre cada una
de ellas
Evite el uso de art´ıculos y proposiciones, tales como: el, los, la, un,
unos, a, para, de, entre otros.
Los identificadores suelen tener reglas dependiendo del lenguaje,
en general, se escriben en min´uscula, cuando el identificador se
componga de dos o m´as palabras, la primera letra a partir de la
segunda deber´a escribirse en may´usculas.
El identificador para el nombre del algoritmo, comienza en
may´uscula.
Si el identificador corresponde al nombre de una constante, este debe
escribirse en may´usculas.
1.4. Variables
Para almacenar los datos en un dispositivo de procesamiento de datos o
computador, se utiliza la memoria de este, la cual se puede comparar con
un conjunto de cuadritos que guardan valores (Ver Figura 1.1).
Aclaraci´on:
Una variable es una posici´on o espacio de memoria en
el cual se almacena un dato. Su valor puede cambiar
en cualquier momento de la ejecuci´on del algoritmo,
precisamente por eso recibe el nombre de variable.
6La lista completa de las palabras reservadas se encuentra en el apartado
correspondiente a pseudoc´odigo - p´agina 61.

-- 27 of 450 --

26 Fundamentos
Cada “cuadrito” o celda representa una direcci´on f´ısica dentro de la
memoria de la m´aquina a la cual se le puede asignar un nombre mediante
un identificador.
Celda de memoria
Figura 1.1: Representaci´on gr´afica de la memoria
Para trabajar con variables, se deben tener presentes los siguientes
elementos:
Tipo
Nombre o identificador
Contenido
El tipo se refiere al tipo de dato que va a almacenar. Puede ser uno de
estos cinco: Caracter, Cadena, Entero, Real o Logico. Cando vaya
a declarar el tipo l´ogico o car´acter dentro de un algoritmo, no se deben
usar las tildes.
El nombre o identificador de la variable, corresponde al mecanismo con el
que se referencia el espacio o posici´on de memoria en el cual se almacenar´a
el dato.
Contenido, hace referencia al valor que almacena, el cual depende del
tipo de dato que se haya definido.
Declaraci´on de variables
Cuando en un algoritmo se requiera utilizar una variable, esta debe ser
declarada. Declarar una variable quiere decir que se va a reservar un espacio
de memoria, el cual tendr´a un nombre y un tipo de dato.

-- 28 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 27
La forma general para declarar variables es la siguiente:
Tipo variable
Ejemplos:
Cadena cedula
Cadena telefono
Real salario
Entero edad
Caracter estratoSocioeconomico
Logico esFumador
Analizando las anteriores declaraciones, se puede observar y concluir lo
siguiente:
Se declararon 6 posiciones de memoria identificadas como cedula,
telefono, salario, edad, estratoSocioeconomico y
esFumador.
Con estas declaraciones se le indica al equipo de procesamiento de
datos o computador que debe reservar 6 espacios en su memoria y a
cada uno asignarle el respectivo nombre que se defini´o.
Cada uno de estos identificadores representa una variable.
En el nombre de las variables se tuvieron en cuenta las reglas
estudiadas anteriormente para la escritura de los identificadores. Por
ejemplo, no se usaron tildes en las variables cedula, telefono
y estratoSocioeconomico; en el identificador de esta ´ultima
variable que est´a compuesta por dos palabras, la segunda inicia con
letra may´uscula, al igual que no se dej´o ning´un espacio en blanco.
En cada una de las declaraciones de variables se est´a determinando
el tipo de dato que almacenar´an.
Para este libro y para lenguajes como C, el valor inicial de todas las
variables no se conoce previamente y se denomina como “Informaci´on
basura”, es decir, toda variable declarada tiene un valor desconocido
(arbitrario) y el dise˜nador del algoritmo debe asegurarse de asignarle
un valor antes de intentar usar el contenido de la variable. Existen
otros lenguajes de programaci´on como por ejemplo Java que s´ı le
asignan un valor por defecto a toda variable reci´en declarada.

-- 29 of 450 --

28 Fundamentos
Cuando en una declaraci´on de variables se tengan varias del mismo tipo,
estas pueden ser agrupadas en una sola declaraci´on, separ´andolas mediante
comas. Ejemplo:
Cadena cedula, telefono
Almacenamiento de un dato en una variable
Almacenar un dato en una variable, se puede hacer de dos maneras:
La primera forma es leyendo el dato, proveniente desde el exterior del
algoritmo, el cual lo proporciona el usuario; por ejemplo, cuando un cajero
autom´atico le solicita la clave de su tarjeta d´ebito, el usuario le est´a
asignando un valor a la variable donde se almacenar´a dicha clave, el valor
ser´a la clave que se digit´o. Cuando se trate el tema de algoritmos, m´as
adelante en este cap´ıtulo, se indicar´a la forma de leer los datos.
La segunda forma se hace a trav´es de una expresi´on de asignaci´on. Una
expresi´on de asignaci´on, es el mecanismo por medio del cual una variable
o una constante toma un valor. Para realizar una asignaci´on se utiliza el
signo igual (=).
Su sintaxis o forma general es la siguiente:
variable = valor
Esta forma indica que valor ser´a almacenado en variable. En
este caso, valor puede ser una constante, otra variable o una expresi´on
aritm´etica (c´alculo).
Teniendo en cuenta los ejemplos dados anteriormente en la declaraci´on
de variables, se proceder´a a asignar valores a cada uno de los espacios de
memoria declarados:
cedula = "41459822"
telefono = "7454548"
salario = 3000000.00
edad = 24
esFumador = Verdadero
estratoSocioeconomico = ’3’
Los valores que hay al lado derecho del signo igual (=), son asignados
a cada una de las variables que est´an al lado izquierdo, de esta forma en
cada uno de los espacios de memoria reservados se guardar´an estos valores,
los cuales pueden ser referenciados usando el nombre de la variable.

-- 30 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 29
Observe que los valores asignados a las variables cedula y
tel´	efono est´an encerrados entre comillas dobles, esto obedece a
que las variables fueron definidas de tipo Cadena. En el caso de
estratoSocioeconomico el valor que se le asigna est´a entre comillas
simples, debido a que es una variable de tipo Caracter. No olvide que,
aunque estos datos est´an compuestos exclusivamente por d´ıgitos no se
pueden tratar como valores num´ericos, es decir, con ellos no se podr´an
realizar operaciones matem´aticas.
Como se dijo anteriormente, en la expresi´on de asignaci´on se pueden
usar valores provenientes de otras variables o de expresiones aritm´eticas;
adicionalmente recuerde que una variable puede cambiar su valor en
cualquier momento. Ejemplo:
1 a = 5
2 b = a
3 c = 3 * b
4 a = c - b
L´ınea 1: la variable a toma el valor de 5, proveniente de un valor
constante.
L´ınea 2: la variable b toma el valor de a, es decir, en este momento
tanto a como b tienen almacenado el valor de 5. En este ejemplo, la
asignaci´on se hace tomando el valor de otra variable. Cuando se hace
referencia al nombre de la variable, realmente se est´a referenciando
su contenido.
L´ınea 3: la variable c toma el valor de 15, al multiplicar el valor
de b por 3. En este caso la asignaci´on proviene de una expresi´on
aritm´etica.
L´ınea 4: la asignaci´on almacena en la variable a el valor de 10, puesto
que c tiene almacenado el valor de 15 y le es restado el valor de b, que
en este caso es 5. Esta l´ınea muestra una asignaci´on realizada como
resultado de una expresi´on aritm´etica. As´ı mismo se comprueba que
una variable puede cambiar de valor; en la l´ınea 1 la variable a ten´ıa
el valor de 5 y al finalizar, en la l´ınea 4, esa misma variable termina
con un valor de 10. Cada que una variable cambia su valor, el dato
anterior se pierde.

-- 31 of 450 --

30 Fundamentos
1.5. Constantes
Una constante es un espacio en la memoria donde se almacena un dato
que, a diferencia de los datos que se almacenan en las variables, permanece
constante durante la ejecuci´on de todo el algoritmo. Al igual que las
variables, las constantes tambi´en se deben declarar.
Para declarar una constante se utiliza la siguiente forma general o
sintaxis:
Constante Tipo IDENTIFICADOR = Valor
La palabra Constante es una palabra reservada que indica que se
va a declarar una constante y que su valor no podr´a ser cambiado
durante la ejecuci´on del algoritmo.
Tipo, refiere a uno de los cinco tipos de datos: Caracter, Cadena,
Entero, Real y Logico.
IDENTIFICADOR, es el nombre que se le asigna a la constante. Se
recomienda que se escriba en letras may´usculas.
Valor, es el valor que tendr´a la constante y debe estar acorde con
el tipo de dato que se le haya asignado a la constante.
Ejemplos:
Constante Real VALOR_PI = 3.1415926
Constante Real DESCUENTO = 0.10
Constante Entero MAXIMO = 10
Constante Real SALARIOMINIMO = 781000.0
Constante Caracter CATEGORIAPORDEFECTO = ’B’
1.6. Operadores y expresiones
Un operador es un s´ımbolo que permite realizar una operaci´on con
n´umeros o con datos que se encuentran almacenados en las variables y
constantes. En l´ogica de programaci´on, existen 3 tipos de operadores:
aritm´eticos, relacionales y l´ogicos.
Por su parte, una expresi´on es una instrucci´on que puede estar
compuesta por operadores, variables, constantes y n´umeros, que
generalmente produce un resultado, ya sea num´erico o l´ogico.
Las expresiones para ser usadas dentro de un algoritmo, deben escribirse
en notaci´on algor´ıtmica (en una sola l´ınea), para ello se seguir´a usando la
siguiente forma general:

-- 32 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 31
Operando1 Operador Operando2
Operando1 y Operando2 representan los datos que intervienen en la
expresi´on y, operador es un s´ımbolo que indica el tipo de operaci´on que
se va a realiza entre los operandos.
1.6.1 Operadores aritm´eticos
Se utilizan para realizar operaciones aritm´eticas entre datos de tipo
entero o real, su resultado es de tipo num´erico. Los operadores aritm´eticos
son los siguientes:
+ Suma
- Resta
* Multiplicaci´on o producto
/ Divisi´on real o entera
% M´odulo o Resto de la divisi´on entera
ˆ Potenciaci´on, este s´ımbolo tiene el nombre de circunflejo.
La suma, resta, multiplicaci´on, divisi´on y potenciaci´on son operaciones
que son conocidas desde los estudios de primaria y bachillerato. Aunque
en el anterior listado la divisi´on se est´a mostrando como divisi´on real y
divisi´on entera.
Una divisi´on real es la que el resultado arroja valores con decimales,
generalmente, la que siempre se realiza. Por ejemplo, al dividir 15.0 entre
2.0, se obtendr´a como resultado 7.5.
Diferente a lo anterior, la divisi´on entera no es tan usual y consiste en
obtener el cociente entero, es decir, sin decimales. Por ejemplo, al dividir
15 entre 2, se obtendr´a como resultado 7.
La especificaci´on del tipo de divisi´on que se necesita realizar (real o
entera), radica en el tipo de dato de los operandos. Si uno o ambos
operandos son de tipo real, el resultado que se obtiene es del mismo tipo;
si ambos operandos son enteros, la divisi´on arroja un resultado entero:
15.0/2.0 = 7.5, ambos operandos reales, resultado real.
15/2 = 7, ambos operandos enteros, resultado entero (sin decimales).

-- 33 of 450 --

32 Fundamentos
Otro operador que puede ser nuevo para el lector, es el % (residuo, resto
o m´odulo de la divisi´on entera), no se debe confundir con el s´ımbolo de
porcentaje, en este caso se trata de un operador de divisi´on entre datos
de tipo entero, pero no obtiene el cociente, sino el residuo o resto de la
divisi´on entera: 1 5
1
2
7
Para usarlo en un algoritmo, se representa as´ı: 15 % 2, obteniendo 1
como resultado.
Aclaraci´on:
Cuando se use el operador / o %, el operando de
la derecha, no deber´ıa tener el valor de 0, ya que
generar´ıa un error, debido a que la divisi´on entre
cero, matem´aticamente, no est´a definida.
El operador % (M´odulo o Resto de la divisi´on) solo se puede emplear
con datos de tipo Entero.
El operador / puede usarse con datos enteros o reales. Si los datos
son enteros, el resultado es entero, si alguno de los datos es real, el
resultado ser´a del mismo tipo (real).
1.6.2 Operadores relacionales
Estos operadores se utilizan para escribir expresiones relacionales o
de comparaci´on, las cuales producen un resultado l´ogico o booleano:
Verdadero o Falso.
Los operadores relacionales son los siguientes:
< Menor que.
> Mayor que.
<= Menor o igual a.
>= Mayor o igual a.
! = Diferente de.
== Igual a.

-- 34 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 33
Aclaraci´on:
Se usa un solo igual (=) para realizar asignaci´on de
valores en variables o constantes. Se utiliza doble
igual (==) para realizar comparaciones entre dos
operandos.
1.6.3 Operadores l´ogicos
Estos operadores se utilizan para crear expresiones l´ogicas o booleanas
cuyo resultado es de tipo l´ogico: Verdadero o Falso.
Los operadores l´ogicos son los siguientes:
Y Conjunci´on.
O Disyunci´on.
NO Negaci´on.
Estos operadores funcionan con datos de tipo l´ogico; para obtener el
resultado de la aplicaci´on de estos operadores, es indispensable conocer
c´omo funcionan las tablas de verdad de cada uno de ellos.
Operador Y, denominado Conjunci´on. Es un operador binario, es
decir, requiere de dos operandos para producir un resultado. El resultado
es verdadero solo cuando ambos operandos son verdaderos (Ver Tabla 1.1).
Operando1 Operando2 Operando1 Y Operando2
Verdadero Verdadero Verdadero
Verdadero Falso Falso
Falso Verdadero Falso
Falso Falso Falso
Tabla 1.1: Tabla de verdad del operador Y

-- 35 of 450 --

34 Fundamentos
Operador O, denominado Disyunci´on. Igual que el anterior, es un
operador binario. Su resultado ser´a verdadero cuando al menos uno de los
dos operandos tenga ese valor (Ver Tabla 1.2).
Operando1 Operando2 Operando1 O Operando2
Verdadero Verdadero Verdadero
Verdadero Falso Verdadero
Falso Verdadero Verdadero
Falso Falso Falso
Tabla 1.2: Tabla de verdad del operador O
Operador NO, denominado Negaci´on. A diferencia de los dos
anteriores, este es un operador unario, es decir, requiere de un solo
operando para producir su resultado. Si el operando es Verdadero,
cambia su estado a Falso, y viceversa. En conclusi´on, su funci´on es
cambiar el valor o estado l´ogico de su ´unico operando (Ver Tabla 1.3).
Operando1 NO Operando1
Verdadero Falso
Falso Verdadero
Tabla 1.3: Tabla de verdad del operador NO
Aclaraci´on:
Con el operador Y, el resultado es Verdadero
cuando ambos operandos sean verdaderos.
Con el operador O, el resultado es Verdadero
cuando uno de los operandos sea verdadero.
El operador NO, cambia el estado del operando, es decir, si el
operando es Verdadero, el resultado ser´a Falso y viceversa.
1.6.4 Expresiones aritm´eticas
En estas expresiones intervienen variables, constantes, n´umeros y
operadores aritm´eticos, as´ı como los par´entesis. La expresi´on entrega un
resultado de tipo num´erico luego de ser calculada.

-- 36 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 35
Recuerde que estas expresiones deben ser usadas en notaci´on
algor´ıtmica, teniendo en cuenta la siguiente forma general:
Operando1 Operador Operando2
En este caso Operador, es uno de los operadores aritm´eticos estudiados
en el numeral 1.6.1. Son ejemplos de expresiones aritm´eticas los de la Tabla
1.4.
Ejemplo Explicaci´on Resultado
3 + 5 Suma 3 con 5 8
2 - 8 Resta 8 de 2 -6
7 * 6 Multiplica 7 por 6 42
20.0 / 3.0 Divide 20.0 entre 3.0 (Real) 6.33
20 / 3 Divide 20 entre 3 (Entero) 6
2ˆ3 Eleva 2 a la potencia 3 8
20%3 Resto de 20 entre 3 2
Tabla 1.4: Ejemplos de expresiones aritm´eticas
Las expresiones aritm´eticas tambi´en pueden ser construidas con
variables o en combinaci´on con constantes. Ejemplos Tabla 1.5.
Expresi´on Explicaci´on
lado1 + lado2 Se suman los valores almacenados en las variables lado1 y
lado2.
a - b Al valor de la variable a se le resta el valor de la variable b.
base ∗ altura Los valores almacenados en las variables base y altura son
multiplicados entre s´ı.
a / b El valor almacenado en la variable a es dividido entre el valor
de la variable b. El resultado ser´a entero, si ambas variables
fueron declaradas de tipo Entero, en otro caso, ser´a Real
(con decimales).
xˆ2 El valor almacenado en la variable x es elevado a la 2.
25 % divisor 25 es dividido entre el valor de la variable divisor, el
resultado ser´a el resto de la divisi´on. La variable divisor
deber´a ser declarada de tipo Entero.
Tabla 1.5: Ejemplos de expresiones aritm´eticas con variables

-- 37 of 450 --

36 Fundamentos
Cuando una expresi´on aritm´etica involucra varios operadores, es
necesario realizar los c´alculos respetando la precedencia de los mismos,
es decir, se debe tener en cuenta lo que se denomina prioridad en las
operaciones. La Tabla 1.6 muestra el orden de ejecuci´on, la cual puede ser
modificada con el uso de par´entesis, los cuales ser´ıan la m´axima prioridad.
Orden Operador
1 ( )
2 ˆ
3 *, /, %
4 +, -
Tabla 1.6: Prioridad de los operadores
Ejemplos:
10 + 3 * 5
Esta expresi´on presenta dos operaciones: una suma y una multiplicaci´on.
La prioridad la tiene el operador ∗, por lo tanto, debe ser la primera
operaci´on que se realiza:
10 + 15
Seguidamente se efect´ua la suma, dando como resultado 25.
Si en el anterior ejemplo, no se hubiese tenido en cuenta el orden de
ejecuci´on, de acuerdo a la prioridad de operaci´on, sino que se hubiese
ejecutado en el orden como est´a escrita la expresi´on, se obtendr´ıa el
siguiente resultado, que obviamente es un error:
10 + 3 * 5
13 * 5
65
Si en una expresi´on se encuentran 2 o m´as operadores consecutivos de
igual jerarqu´ıa o precedencia, las operaciones se van realizando de izquierda
a derecha. Por ejemplo:
10 - 6 + 2
4 + 2
6
En la anterior expresi´on se encuentra una resta y una suma, ambas
son de igual precedencia, por lo tanto, se ejecutan de izquierda a derecha,
primero la resta y luego la suma.

-- 38 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 37
Cuando se requiera cambiar el orden de ejecuci´on de alg´un operador, se
deben usar los par´entesis. Por ejemplo, si en la anterior expresi´on lo que se
buscaba era que primero se ejecutara la suma y luego que el resultado de
esa suma le fuera restado al 10, la expresi´on tendr´ıa que haber sido escrita
as´ı:
10 - (6 + 2)
Al calcular dicha expresi´on se tiene entonces:
10 - (6 + 2)
10 - 8
2
Ahora observe el siguiente ejemplo, asumiendo que a = 17 y b = 20.
a % 3 + b
El valor de la variable a es dividido entre 3, el residuo de esta divisi´on se
suma con el dato contenido en la variable b. Por lo tanto, 17 al ser dividido
entre 3 dar´a como residuo 2, valor que es sumado con el dato que hay en
b, es decir 20, obteniendo 22 como resultado final.
Ahora bien, si esta expresi´on se escribe de la siguiente forma:
a % (3 + b)
El resultado ser´ıa diferente. Observe:
17 % (3 + 20)
17 % 23
17
El residuo es 17:
1 7
1 7
2 3
0
Cuando se tengan varias agrupaciones de par´entesis, se deben solucionar
de izquierda a derecha, teniendo en cuenta que, si hay par´entesis internos,
estos son de mayor prioridad. Analice la expresi´on que aparece enseguida:
((4 + 8) * 3) / (7ˆ2 % (2 + 1))
En esta expresi´on, la m´axima prioridad ser´a resolver los par´entesis antes
de llevar a cabo la divisi´on que los separa; pero como hay dos juegos de
par´entesis, se deben resolver de izquierda a derecha.

-- 39 of 450 --

38 Fundamentos
((4 + 8) * 3) / (7ˆ2 % (2 + 1))
Dentro del primer par´entesis hay una suma y un producto; la prioridad
la tendr´ıa el producto, pero los par´entesis que encierran la suma deben
resolverse primero, lo cual cambia el orden de operaci´on, debi´endose
desarrollar en primer lugar la suma:
((4 + 8) * 3) / (7ˆ2 % (2 + 1))
(12 * 3) / (7ˆ2 % (2 + 1))
Ahora si es posible llevar a cabo el producto dentro del par´entesis del
lado izquierdo de la divisi´on, obteniendo el siguiente resultado:
36 / (7 ˆ 2 % (2 + 1))
A continuaci´on, se debe resolver la expresi´on que est´a entre el par´entesis
del lado derecho de la divisi´on. Dentro de ´el se encuentra una operaci´on
de potencia, una divisi´on modular y una suma. Seg´un la jerarqu´ıa de los
operadores aritm´eticos (Tabla 1.6) primero debe resolverse la potencia,
luego la divisi´on y por ´ultimo la suma, pero los par´entesis internos cambian
el orden de ejecuci´on, por lo tanto, lo primero que se va a ejecutar es la
suma:
36 / (7 ˆ 2 % (2 + 1))
La expresi´on se reduce de la siguiente manera, donde la prioridad la
tiene la potencia:
36 / (7 ˆ 2 % 3)
Al resolverla, la expresi´on se presenta as´ı:
36 / (49 % 3)
A´un hace falta resolver la divisi´on modular para eliminar los par´entesis:
36 / 1
Por ´ultimo, se realiza la divisi´on, lo que da como resultado 36.
1.6.5 Conversi´on de f´ormulas aritm´eticas en notaci´on
algor´ıtmica
Cuando se va a trabajar con una f´ormula dentro de un algoritmo, se
debe convertir a una expresi´on aritm´etica que sea interpretada por los

-- 40 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 39
dispositivos de procesamiento de datos, esta conversi´on se le conoce como
Notaci´on algor´ıtmica. Generalmente las f´ormulas son encontradas en forma
de notaci´on matem´atica:
a = 2x + y
x − y
Pero para poder ser trabajada dentro de un algoritmo debe reescribirse
en una sola l´ınea, as´ı:
a = (2 * x + y) / (x - y)
Para llegar a esta notaci´on algor´ıtmica, es necesario tener en cuenta las
siguientes reglas:
Primera regla. Cuando la f´ormula exprese una divisi´on y en alguno
de sus t´erminos (dividendo o divisor) se tenga una operaci´on, esta
debe encerrarse entre par´entesis. Ejemplo:
x = a+1
b ,debe expresarse as´ı: x = (a + 1)/b
Segunda regla. Cuando se tenga una potencia y su exponente
involucre una operaci´on, debe encerrarse entre par´entesis. Ejemplo:
x3b, debe expresarse as´ı: xˆ(3 ∗ b)
Tercera regla. Cuando la f´ormula incluya ra´ıces, estas deben
expresarse en forma de potencias, aplicando el siguiente concepto
matem´atico:
n
√x = x1/n
Ejemplo:
3
√ 5
√x,debe expresarse as´ı: xˆ(1/5)ˆ(1/3)

-- 41 of 450 --

40 Fundamentos
Expresi´on Resultado Explicaci´on
4 < 8 Verdadero Compara si 4 es menor que 8.
3 > 7 Falso Compara si 3 es mayor que 7.
6 <= 6 Verdadero Compara si 6 es menor o igual a 6.
2 >= 9 Falso Compara si 2 es mayor o igual a 9.
5 ! = 1 Verdadero Compara si 5 es diferente de 1.
10 == 10 Verdadero Compara si 10 es igual a 10.
Tabla 1.7: Ejemplo de expresiones relacionales
1.6.6 Expresiones relacionales
En este tipo de expresiones intervienen los operadores relacionales,
adem´as de variables, n´umeros y constantes. Estas expresiones comparan el
valor de sus operandos y arrojan un resultado de tipo l´ogico: Verdadero o
Falso. Los operadores relacionales fueron estudiados en el numeral 1.6.2.
La Tabla 1.7 presenta ejemplos de expresiones relacionales.
Los operandos que hacen parte de una expresi´on relacional, pueden estar
compuestos por constantes, variables o la combinaci´on de ambos. Ejemplos:
definitiva >= 3.0
Aqu´ı se est´a preguntando si el valor contenido en la variable
definitiva es mayor o igual a 3.0. La expresi´on retornar´a un resultado
de Verdadero o Falso, dependiendo de lo que tenga almacenado la
variable definitiva.
(2 * a + b) > (3 * c - d)
Para que esta expresi´on sea verdadera, la parte izquierda de la expresi´on,
es decir, lo que hay del lado izquierdo del operador > debe ser mayor que
lo que hay del lado derecho. N´otese que en ambos lados de la expresi´on
hay expresiones aritm´eticas que involucran variables y n´umeros. En estos
casos, tambi´en se debe aplicar la prioridad en las operaciones.
1.6.7 Expresiones l´ogicas
Tambi´en llamadas booleanas. Son aquellas que se utilizan para crear
condiciones a partir de datos l´ogicos. Est´an compuestas por expresiones
relacionales o l´ogicas, conectadas a trav´es de operadores l´ogicos, los

-- 42 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 41
cuales fueron estudiados en el numeral 1.6.3. Los resultados que arroja
la evaluaci´on de este tipo de expresiones solo pueden ser de dos formas:
Verdadero o Falso.
Para ilustrar el funcionamiento de estos operadores, se analizar´an los
siguientes ejemplos.
Ejemplo con el operador Y: para poder hacer cualquier transacci´on
en un cajero autom´atico se requiere poseer una tarjeta (d´ebito o cr´edito) y
adicionalmente la clave de dicha tarjeta; actualmente existen otros medios,
pero para el ejemplo se tomar´an esas condiciones.
A continuaci´on, se analizar´a en qu´e situaciones se podr´ıa hacer alguna
transacci´on y en cuales no: