# 2007. Gan ´o diver-

sos premios por sus
contribuciones, en-
tre las que se en-
cuentran la creaci ´on del primer
lenguaje de programaci ´on de al-
to nivel, y de un mecanismo
de descripci ´on de lenguajes de
programaci ´on conocido hoy co-
mo forma Backus-Naur (Backus-
Naur Form, o BNF).
de esta compa ˜n´ıa en California en Estados Unidos, el lenguaje FORTRAN, por
FORmula TRANslator (o m ´as detalladamente, the IBM Mathematical FORmula
TRANslating System), que es t´ıpicamente considerado por toda la comunidad in-
form ´atica como el primer lenguaje de programaci ´on independiente de la m ´aqui-
T ´ecnicamente el primer lengua-
je de programaci ´on de este es-
tilo fue PLANKALK ¨UL (pronuncia-
do “pl ´ankalkil”), desarrollado por
Konrad Zuse en 1943 en Ale-
mania. Sin embargo, debido a la
Guerra, este lenguaje no fue he-
cho p ´ublico hasta 1972.
na. FORTRAN introdujo muchas ventajas sobre los lenguajes ensambladores, e
hizo m ´as claras las operaciones b ´asicas.
La idea rectora en esos d´ıas era hacer la programaci ´on m ´as cercana al len-
guaje natural humano; o dicho de otro modo, aumentar el nivel de abstracci ´on.
Por esa raz ´on, estos lenguajes que empezaron a surgir fueron denominados “len-
guajes de alto nivel”. Hoy en d´ıa se los suele entender como lenguajes de m ´as
bajo nivel, puesto que existen otros lenguajes (como los lenguajes funcionales o
los orientados a objetos) que son de mayor nivel de abstracci ´on que los aqu´ı men-
cionados. En esta ´epoca el motor que llevaba adelante las investigaciones y el
desarrollo de software eran las aplicaciones de defensa y las de administraci ´on a
gran escala.
Al poco tiempo de la aparici ´on de FORTRAN surgieron otros dos lengua-
jes: LISP (por LISt Processor, procesador de listas), antecesor de los modernos
lenguajes funcionales y COBOL (por COmmon Business Oriented Language,
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 29 of 312 --

30
lenguaje orientado a los negocios comunes) que fuera adoptado en bancos, com-
pa ˜n´ıas y dependencias oficiales.
Leer con Atenci ´on
El lenguaje LISP se bas ´o en una teor´ıa matem ´atica que podr´ıa con-
siderarse hoy el primer lenguaje de programaci ´on de alto nivel, y que
fue desarrollada en la d ´ecada de 1930 por el l ´ogico-matem ´atico Alonzo
Church; esa teor´ıa se conoce con el nombre de lambda c ´alculo (utili-
za letras griegas como λ, α, β para identificar diferentes conceptos de
programaci ´on). En paralelo, el l ´ogico-matem ´atico Haskell B. Curry desa-
rroll ´o una teor´ıa denominada c ´alculo combinatorio, de poder similar al
lambda c ´alculo.
Uno de los primeros usos en computaci ´on del lambda c ´alculo fue el de
permitir explicar en t ´erminos abstractos el funcionamiento de lenguajes
imperativos (en particular, de ALGOL).
Es importante mencionar este lenguaje por dos razones: primero, por-
que hoy en d´ıa, lenguajes basados en las ideas del lambda c ´alculo (los
lenguajes funcionales) se consideran una de las variantes de m ´as alto
nivel de los lenguajes de programaci ´on, y est ´an haciendo gran diferencia
en el campo de la programaci ´on paralela y concurrente; y en segundo
lugar, porque ¡fueron desarrollados casi una d ´ecada entera antes que
existiese la idea de computadora como m ´aquina f´ısica!
Luego de FORTRAN, LISP y COBOL, en menos de una d ´ecada florecieron otra
docena o m ´as de lenguajes diferentes. Cada uno de estos lenguajes se enfocaba
Entre los m ´as notorios que die-
ron origen a ideas modernas
est ´an CPL (antecesor de C), SI-
MULA (precursor de la programa-
ci ´on orientada a objetos), y BA-
SIC (originalmente dise ˜nado pa-
ra la ense ˜nanza).
en cierta forma de resolver problemas, siendo la mayor´ıa orientados a establecer
una secuencia de instrucciones con foco en diferentes aspectos de c ´omo esta-
blecer la comunicaci ´on entre las diferentes partes que compon´ıan el programa.
Un lenguaje que result ´o un hito por la consolidaci ´on de muchas ideas al res-
pecto de c ´omo deb´ıan definirse los lenguajes de programaci ´on fue ALGOL (por
ALGOrithmic Language, lenguaje de algoritmos). Este lenguaje fue de gran in-
fluencia en much´ısimos lenguajes modernos, puesto que sus ideas siguen us ´an-
dose en el dise ˜no actual de lenguajes de programaci ´on (por ejemplo, la forma
de describir sus reglas de sintaxis, la Backus-Naur Form o BNF, se sigue usan-
do en la especificaci ´on de la sintaxis de todos los lenguajes de programaci ´on
modernos). Tambi ´en fue el primer lenguaje para el que se estudi ´o c ´omo asignar
significado (sem ´antica) de manera independiente a la ejecuci ´on.
1.3.3. Los paradigmas de programaci ´on
Durante la d ´ecada de 1960, la proliferaci ´on de lenguajes de programaci ´on si-
gui ´o creciendo, y de a poco fueron diferenci ´andose grupos o “familias” de len-
guajes, en torno a la predominancia de ciertas caracter´ısticas. El foco del desa-
rrollo de software se fue desplazando hacia la educaci ´on, para poder formar a
los futuros programadores. La administraci ´on a gran escala sigui ´o teniendo fuer-
te presencia, pero las aplicaciones orientadas a la defensa fueron disminuyendo.
Estos grupos o familias de lenguajes dieron origen a lo que se denomina pa-
radigmas de programaci ´on, que no es otra cosa que un conjunto de ideas y con-
ceptos al respecto del estilo con el que se expresan las soluciones a problemas a
trav ´es de un lenguaje de programaci ´on. Cada paradigma privilegia ciertas ideas
por sobre otras, y ciertas formas de combinaci ´on por sobre otras, dando lugar a
estilos muy diferentes (aunque muchas veces complementarios) en la forma de
programar.
Definici ´on 1.3.1. Un paradigma de programaci ´on es un conjunto de ideas y con-
ceptos vinculados a la forma en que se relacionan las nociones necesarias para
solucionar problemas con el uso de un lenguaje de programaci ´on.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 30 of 312 --

31
Para 1970 ya se pueden identificar cuatro grandes paradigmas, que est ´an vi-
gentes hoy d´ıa y que son claramente reconocidos por todos los miembros de la
comunidad inform ´atica. Mucho despu ´es se intent ´o identificar paradigmas adicio-
nales a estos cuatro originales, pero no hay consenso sobre si alguno de ellos
llega o no a poder ser considerado un paradigma y merece ese nombre; por esa
raz ´on nos limitaremos a hablar de los cuatro paradigmas principales.
Los cuatro paradigmas de programaci ´on que surgieron a fines de los sesenta
y principios de los 1970, y que resultaron de fundamental influencia en la forma
de hacer programaci ´on, son:
el paradigma imperativo,
el paradigma orientado a objetos,
el paradigma funcional, y
el paradigma l ´ogico.
Los dos primeros est ´an m ´as orientados a la forma de manejar estado y podr´ıan
ser denominados procedurales, mientras que los dos ´ultimos est ´an m ´as orienta-
No es usual asociar el t ´ermino
procedural con los lenguajes
orientados a objetos, pero es
una forma de indicar que los
mismos se concentran m ´as en el
estado que en la descripci ´on de
informaci ´on.
dos a expresar conceptos o nociones independientes del estado, y podr´ıan ser
denominados declarativos. El paradigma que se desarroll ´o con mayor ´ımpetu al
principio fue el imperativo, debido a su cercan´ıa con los lenguajes de bajo nivel.
Los otros tardaron m ´as tiempo en adoptar un estado de madurez, y no fue hasta
mediados de la d ´ecada de 1980 que tanto el paradigma funcional como el l ´ogico
y el orientado a objetos empezaron a ser foco de atenci ´on masiva.
Dentro del paradigma imperativo se clasifican lenguajes m ´as vinculados con
la secuencia de instrucciones y cercanos al assembler. Algunos nombres nota-
bles que surgieron en esa ´epoca dentro del paradigma imperativo, y a ´un cono-
cidos hoy en d´ıa, son: BASIC, desarrollado en 1965 por John Kemey y Tho-
mas Kurtz con la intenci ´on de que se conviertiese en un lenguaje de ense ˜nan-
za; PASCAL, creado, tambi ´en con fines did ´acticos, por Niklaus Wirth en 1970
a partir del ALGOL; y C, dise ˜nado por Dennis Ritchie y Ken Thompson en los
laboratorios Bell (Bell Labs) entre 1969 y 1973, con el prop ´osito proveer una tra-
ducci ´on eficiente a assembler y permitir la administraci ´on eficaz de los recursos
de c ´omputo de las m ´aquinas con arquitectura von Neumann a trav ´es de abs-
tracciones cercanas al bajo nivel, que brinda una forma c ´omoda e independiente
de la computadora de administrar sus recursos. La fama del C se debe a que,
por esta caracter´ıstica de su dise ˜no, fue utilizado en la programaci ´on del sistema
operativo UNIX y fue ampliamente portado a numerosos sistemas. Es uno de los
Actualmente el nombre “UNIX”
es una marca registrada que se
licencia para usar cuando un
sistema operativo cualquiera sa-
tisface sus definiciones. La de-
nominaci ´on “UNIX-like” (“de ti-
po UNIX”) se utiliza para refe-
rirse a una gran familia de sis-
temas operativos que se aseme-
jan al UNIX original. La familia
UNIX-like tiene diversas subca-
tegor´ıas, entre las que se en-
cuentra el actualmente popular
GNU/LINUX.
lenguajes m ´as difundidos y conocidos de todos los tiempos, y su estudio implica
un conocimiento profundo de la forma en que se ejecutan las computadoras.
Para Ampliar
Para saber m ´as sobre sistemas operativos, su funci ´on, su historia y su
clasificaci ´on, consultar la Wikipedia:
http://en.wikipedia.org/wiki/Operating_system
Dentro del paradigma funcional se clasifican lenguajes orientados a la descrip-
ci ´on de datos, de su forma, las relaciones entre ellos, y sus transformaciones.
Si bien inicialmente no fueron tan populares, la investigaci ´on llev ´o a este para-
digma a la madurez y desde el mismo se realizaron grandes aportes a todos los
lenguajes modernos. Algunos lenguajes que surgieron en esa ´epoca dentro de
este paradigma son: ML, desarrollado por Robin Milner y otros a principios de
los setenta en la Universidad de Edimburgo en el Reino Unido con el prop ´osito
de servir para desarrollar t ´acticas de prueba en herramientas de demostraci ´on
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 31 of 312 --

32
autom ´atica de teoremas, utilizando un sistema de tipos est ´atico que es una de
sus grandes innovaciones; MIRANDA, desarrollado por David Turner en 1985
como sucesor de sus primeros lenguajes de programaci ´on, SASL y KRC, in-
corporando conceptos aprendidos del lenguaje ML; y SCHEME, derivado como
dialecto de LISP por Guy L. Steele and Gerald J. Sussman en el laboratorio de
inteligencia artifical del MIT, siguiendo principios de minimalidad en la cantidad
de conceptos distintos a proveer, pero conservando un gran poder expresivo. A
mediados de la d ´ecada de 1980 se conform ´o un comit ´e mundial de cient´ıficos
de la programaci ´on funcional que defini ´o un lenguaje est ´andar que expresase
la suma de conocimientos sobre lenguajes funcionales, bas ´andose fundamental-
mente en MIRANDA. Este nuevo lenguaje, HASKELL (en honor a Haskell B. Curry),
HASKELL es un lenguaje fun-
cional puro avanzado est ´andar,
con sem ´antica no-estricta y
tipado est ´atico fuerte. Permi-
te el desarrollo de software
correcto, conciso y robusto.
Cuenta con funciones como
valores, mecanismos para la
integraci ´on con otros lenguajes,
concurrencia y paralelismo
intr´ınsecos, diversas herramien-
tas de producci ´on de software,
sofisticadas bibliotecas de fun-
ciones y una comunidad activa a
lo ancho de todo el mundo. M ´as
informaci ´on en su p ´agina web:
http://www.haskell.org
se public ´o por primera vez en 1990, y es actualmente el lenguaje de alto nivel con
mayor pureza conceptual, expresando el estado del arte en el desarrollo de len-
guajes de programaci ´on funcional. Su impacto en la comprensi ´on de conceptos
de alto nivel no puede ser ignorada por un programador actual. El enfoque de
este libro incorpora muchas ideas aprendidas a partir de HASKELL.
Dentro del paradigma orientado a objetos se encuentran lenguajes que agru-
pan el c ´odigo alrededor de la met ´afora de “objeto”, y que intentan representar
mediante datos encapsulados las entidades del mundo real. Al ya mencionado
lenguaje SIMULA, pionero de los lenguajes orientados a objetos, se le agreg ´o el
lenguaje SMALLTALK, creado en el Learning Research Group (LRG) de Xerox
por Alan Kay y otros, tambi ´en en los setenta, pensado con fines educacionales
bas ´andose en la teor´ıa constructivista del aprendizaje. Fue la base del desarrollo
posterior en tecnolog´ıa de objetos, que hoy es uno de los pilares de la construc-
ci ´on moderna de software.
Finalmente, dentro del paradigma l ´ogico se encuentran distintos lenguajes
orientados a la descripci ´on de las relaciones l ´ogicas entre aserciones, que ha-
bilitaban la posibilidad de realizar inferencias y ciertas formas de razonamien-
to autom ´atico, lo cual fue la inspiraci ´on para desarrollar el ´area conocida como
inteligencia artificial. El lenguaje m ´as conocido de este paradigma, que tambi ´en
Usualmente es definida como “el
estudio y dise ˜no de agentes inte-
ligentes”, donde un agente inte-
ligente es un sistema que deci-
de sus acciones con base en su
entorno de manera de maximi-
zar sus chances de ´exito. Exis-
ten numerosos subcampos den-
tro del campo de la inteligencia
artificial y los mismos no siem-
pre est ´an vinculados, siendo los
m ´as exitosos los vinculados a la
optimizaci ´on y b ´usqueda de in-
formaci ´on compleja.
surgi ´o a finales de la d ´ecada de 1970 en Marseille, Francia, en el grupo de Alain
Colmerauer, es PROLOG, un lenguaje basado en la afirmaci ´on de hechos y reglas
de inferencia, que se utiliza mediante “consultas” en la forma de afirmaciones que
deben ser validadas a partir de los hechos.
Cada uno de los lenguajes mencionados dej ´o un sinn ´umero de descendientes
y pr ´acticamente todos los lenguajes modernos se vinculan, de una forma u otra,
con alguno de ´estos.
Otro gran avance de esta ´epoca fue el desarrollo de lo que dio en llamarse
programaci ´on estructurada, que sucedi ´o dentro del paradigma imperativo, y con-
sisti ´o fundamentalmente en aumentar la abstracci ´on de los lenguajes, eliminando
primitivas de control “desestructurado”, o sea, que permit´ıan moverse libremente
por el c ´odigo, sin tener en cuenta su estructura l ´ogica. En este avance es cuando
se establecen las formas fundamentales de combinaci ´on de componentes que
veremos en este libro.
1.3.4. Consolidaci ´on y expansi ´on del software
Durante la d ´ecada de 1980 todos estos lenguajes y paradigmas comienzan un
proceso de consolidaci ´on y de combinaci ´on, que dan origen a nuevos lengua-
jes h´ıbridos entre paradigmas, refinan y estandarizan los lenguajes existentes, y
sintetizan todo lo aprendido en nuevos lenguajes. Adem ´as, diversos grupos de
investigaci ´on y desarrollo se comprometen con la implementaci ´on de compilado-
res y herramientas para ayudar en el proceso de construcci ´on de software, dando
lugar a numerosos avances en el campo de la implementaci ´on de lenguajes.
En este per´ıodo surgen adem ´as las computadoras personales, actualmente
conocidas como PC, que invaden los hogares y empujan el desarrollo de t ´ecnicas
de programaci ´on a mucha mayor escala. Por ejemplo, la provisi ´on de interfaces
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 32 of 312 --

33
gr ´aficas ´utiles y eficientes, de sistemas de oficina personales, el desarrollo de
juegos, la administraci ´on de peque ˜nas empresas (que antes no pod´ıan permitir-
se la administraci ´on computarizada por sus costos alt´ısimos), etc ´etera. Esto dio
origen a lo que actualmente se conoce como la industria del software, a trav ´es del
desarrollo de empresas dedicadas exclusivamente a la producci ´on de software.
En esta ´epoca surgen lenguajes como C++, que es un derivado del len-
guaje C al que se le agregan nociones de programaci ´on con objetos; PERL, un
lenguaje de scripting pensado para hacer reportes en sistemas UNIX; TCL (pro-
Son lenguajes basados en
scripts, que a su vez son
peque ˜nos programas escritos
con la intenci ´on de automatizar
tareas de mantenimiento en
ambientes de software, y que
originalmente estaban ideados
para ser corridos a mano por el
administrador del sistema.
nunciado “t ´ece-ele”, o tambi ´en “t´ıkl”), otro lenguaje de scripting para tareas de
prototipaci ´on de interfaces gr ´aficas, el cual se suele combinar con el toolkit de
interfaces TK, combinaci ´on conocida como TCL/TK; y ERLANG, un lenguaje fun-
cional y sistema de ejecuci ´on desarrollado por la empresa Ericsson para construir
aplicaciones de tiempo real tolerantes a fallos.
Hacia el final de este per´ıodo la comunidad de programaci ´on funcional desa-
rrolla el lenguaje HASKELL, que sintetiza los conocimientos de todos los lenguajes
del ´area, y establece un est ´andar para el paradigma funcional, sentando las ba-
ses para la investigaci ´on de nuevas caracter´ısticas. Este lenguaje, que es (junto
con SMALLTALK en el paradigma de objetos) uno de los pocos lenguajes com-
pletamente puros con capacidad de desarrollo a nivel industrial, tiene la par-
ticularidad de haber sido desarrollado por un comit ´e representativo de toda la
comunidad funcional, encabezado por John Hughes y Simon Peyton-Jones. Es,
en la opini ´on de muchos investigadores de lenguajes, uno de los lenguajes m ´as
s ´olidos conceptualmente, y nos atrever´ıamos a decir, uno de los lenguajes de
m ´as alto nivel entre los existentes actualmente y de los m ´as adecuados para
ense ˜nar conceptos avanzados de programaci ´on. Adem ´as ha sido el soporte de
numerosas investigaciones que desarollaron la teor´ıa necesaria para enriquecer
a muchos otros lenguajes.
1.3.5. La era de internet
La d ´ecada de 1990 marc ´o la difusi ´on de Internet, que constituy ´o una platafor-
ma completamente nueva para el desarrollo de los sistemas de computadoras.
Esta nueva forma de comunicar computadoras dio lugar a numerosas evolucio-
nes, de las cuales los lenguajes de programaci ´on y el desarrollo de software no
estuvieron ausentes.
Una evoluci ´on importante que se dio en este per´ıodo fue la gran difusi ´on de
la idea de software libre, que aunque no tiene que ver con la parte t ´ecnica de
En ingl ´es free software, pero
usando free en el sentido de li-
bertad (como en free will, libre
albedr´ıo), y no en el sentido de
gratuidad (como en free beer,
cerveza gratis). Si bien el soft-
ware libre puede ser gratuito, la
libertad tiene que ver m ´as bien
con la posibilidad de conocer y
modificar el c ´odigo fuente de los
programas.
los lenguajes en s´ı, impact ´o en la forma de hacer software y sistemas. Durante
la expansi ´on de las PC de la d ´ecada de 1980 las empresas de software vend´ıan
el derecho de usar los ejecutables de los programas (pr ´actica que muchas em-
El ejecutable es un programa en
una forma que puede ser ejecu-
tado por una computadora es-
pec´ıfica, pero que no es normal-
mente entendible por las perso-
nas
presas a ´un mantienen), pero no de conocer el c ´odigo fuente de los mismos. De
esta manera, cualquier modificaci ´on que debiera ser hecha en el c ´odigo deb´ıa
esperar a que la empresa fabricante dispusiese recursos para ello. Esta es una
forma de disponer del derecho de autor para limitar el uso del c ´odigo produci-
do. En esa ´epoca surgi ´o tambi ´en la idea de utilizar el derecho de autor de otra
manera, para permitir la inspecci ´on y modificaci ´on del c ´odigo fuente, siempre y
cuando se respetase la autor´ıa original. Esta idea evolucion ´o en los noventa en
muchas formas de licenciamiento diferentes.
Para Ampliar
Investigue sobre el concepto de software libre, sobre c ´omo el mismo fue
producto de las formas de licenciamiento, sobre las variantes existentes
de licencias y sus caracter´ısticas, y sobre las profundas consecuencias
sociales de esta idea.
La posibilidad de inspeccionar y modificar el c ´odigo, sumado a la ampl´ısima red
de comunicaci ´on que provey ´o Internet, permiti ´o desarrollar comunidades alrede-
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 33 of 312 --

34
dor de ciertos sistemas de software, dando lugar a desarrollos como el siste-
ma operativo GNU/LINUX, el navegador Mozilla, la suite de oficina OpenOffice y
much´ısimas otras.
Esta ampliaci ´on de la cantidad de gente en condiciones de programar, junto
con nuevas formas de utilizar las computadoras a trav ´es de internet, favoreci ´o la
aparici ´on de nuevos lenguajes. En este per´ıodo el mayor motor de avance fue
la abstracci ´on de las operaciones en la web y el desarrollo de aplicaciones que
aprovechasen Internet. En esta ´epoca surgen lenguajes como PYTHON, un len-
guaje que combina los paradigmas orientado a objetos, imperativo y en menor
medida, funcional; RUBY, un lenguaje din ´amico y con capacidad de modificar su
propio c ´odigo basado en PERL y SMALLTALK; y PHP, un lenguaje de scripting
originalmente pensado para producir p ´aginas web din ´amicas. Sin embargo, los
lenguajes que alcanzan realmente mayor difusi ´on son JAVA, un lenguaje desarro-
llado por la empresa Sun Microsystems que deriva su sintaxis de los lenguajes
C y C++ incorporando nociones de objetos al estilo SMALLTALK, y con la prin-
cipal caracter´ıstica de correr sobre una m ´aquina virtual; y JAVASCRIPT (que no
Una m ´aquina virtual es un
programa que simula ser una
computadora que ejecuta pro-
gramas. Su principal objetivo es
despreocupar al programador de
muchas de las caracter´ısticas
espec´ıficas que posee la compu-
tadora real en donde finalmente
correr ´an sus programas.
debe ser confundido con JAVA), un lenguaje de scripting basado en prototipos
combinando caracter´ısticas de los paradigmas imperativo, orientado a objetos y
funcional, y cuya utilizaci ´on es b ´asicamente en la construcci ´on de p ´aginas web,
al ser combinado con el lenguaje HTML de especificaci ´on de formato en dichas
p ´aginas.
1.3.6. Tendencias actuales
El siglo XXI continu ´o viendo el desarrollo de la programaci ´on, e incorpor ´o a
la comunicaci ´on en Internet (que contin ´ua en expansi ´on) el motor producido
por el desarrollo de juegos, la telefon´ıa m ´ovil, el surgimiento de la idea de la
nube digital, la animaci ´on cinematogr ´afica, y actualmente la Televisi ´on Digital.
Este concepto tiene que ver con
empresas que alojan en sus ser-
vidores desde los datos de los
usuarios hasta las aplicaciones
con los que los mismos son mo-
dificados, y permiten que cual-
quier persona mantenga en un
´unico lugar su informaci ´on.
Siguieron apareciendo lenguajes de la mano de grandes empresas. Se pueden
mencionar C# y F# de la plataforma .NET de Microsoft, y los lenguajes DART y
GO de la empresa Google. Tambi ´en surge SCALA, que se dise ˜n ´o para misma la
m ´aquina virtual de JAVA, e incorpora nociones del paradigma funcional a dicho
lenguaje.
Tambi ´en se desarrollaron numeros´ısimas l´ıneas de trabajo, como ser la es-
tandarizaci ´on (dando lugar a desarrollos como Unicode, que es un est ´andar para
la codificaci ´on de textos o el lenguaje extendido de descripci ´on de documentos,
XML), la integraci ´on de sistemas (diferentes lenguajes incorporan la capacidad
de ser combinados en el mismo programa, diferentes herramientas como bases
de datos pueden ser accedidas desde casi cualquier lenguaje, etc.), las aplica-
ciones en programaci ´on concurrente, paralela y masivamente paralela (que per-
miten el mejor aprovechamiento de los recursos computacionales), desarrollos
en seguridad de la informaci ´on herramientas como firewalls, antispams, antivi-
rus y muchas otras, pero tambi ´en la incorporaci ´on de nociones de seguridad en
los lenguajes), investigaciones en c ´odigo m ´ovil, computaci ´on de alto desempe ˜no,
programaci ´on orientada a aspectos y much´ısimos etc ´eteras.
Para hacerse una idea de la cantidad de lenguajes que existen, sus influen-
cias relativas entre ellos y su clasificaci ´on seg ´un paradigmas puede observarse
el gr ´afico G.1.1, donde se muestran los lenguajes en un grafo de tipo “galaxia”,
donde se agrupan por paradigma y grupos dentro de los paradigmas (indica-
dos por color), con las conexiones a los lenguajes que influenciaron y su ta-
ma ˜no relativo a su influencia. El original de este gr ´afico puede encontrarse en:
Recurso Web
http://griffsgraphs.com/2012/07/01/programming-languages-influences/
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 34 of 312 --

35
G.1.1. “Galaxia” de los lenguajes de programaci ´on, seg ´un paradigma e influencia
Cerramos esta secci ´on con la certeza de que la pr ´oxima d ´ecada nos depa-
rar ´a nuevas sorpresas en el desarrollo de sistemas de computaci ´on.
1.4. Lenguajes para dominios espec´ıficos
Todos los lenguajes descritos en las secciones anteriores ten´ıan la particularidad
de ser lenguajes de prop ´ositos generales (GPLs, por su sigla en ingl ´es, General
Purpose Languages) y como vimos, la intenci ´on fue siempre abstraer de una
forma u otra el modelo de computaci ´on subyacente.
Ahora bien, para poder cumplir con este prop ´osito (abstracci ´on con gene-
ralidad), estos lenguajes ofrecen una amplia gama de herramientas y formas
de combinaci ´on. Esta amplitud resulta ser demasiada en ocasiones, cuando los
prop ´ositos son m ´as particulares (como por ejemplo acceso a una base de datos,
composici ´on de textos, descripci ´on de p ´aginas web, etc.), sobre todo teniendo
en cuenta que los usuarios que busquen utilizarlos ser ´an especialistas de dichos
dominios pero no necesariamente en conceptos generales de programaci ´on. Por
esta raz ´on surgieron otro tipo de lenguajes, orientados a abstraer las nociones
e ideas de un dominio particular de trabajo. Estos lenguajes se conocen como
lenguajes espec´ıficos de dominio (DSLs, por sus siglas en ingl ´es, Domain Speci-
fic Languages). Son normalmente lenguajes altamente declarativos, y en muchos
Un lenguaje declarativo es un
lenguaje orientado a la descrip-
ci ´on de soluciones minimizan-
do los componentes de ejecu-
ci ´on que se explicitan. Se aso-
cian t´ıpicamente a los paradig-
mas funcional y l ´ogico y, debi-
do a su capacidad de expresar
c ´omputos paralelos de manera
impl´ıcita, han cobrado mucha re-
levancia recientemente.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 35 of 312 --

36
casos extremadamente peque ˜nos, adecuados solamente para una tarea muy es-
pec´ıfica, que tanto pueden ser considerados lenguajes de programaci ´on como
lenguajes de especificaci ´on.
Cada dominio particular tiene asociado uno o m ´as lenguajes dise ˜nados te-
niendo en cuenta las ideas de dicho dominio, y sus particularidades, abstrayendo
lo necesario y no m ´as que eso. Existe un estilo de programaci ´on que sostiene
que para cada problema debe crearse un DSL particular para resolverlo, siendo
esto parte del proceso propuesto para la soluci ´on de problemas; este estilo se
suele denominar programaci ´on orientada a lenguajes. Existen numerosas inves-
tigaciones sobre la manera m ´as eficiente y efectiva de definir nuevos lenguajes
r ´apidamente y se han desarrollado numerosas herramientas para ello.
En esta secci ´on mencionaremos dos o tres de los dominios m ´as populariza-
dos, y relevantes para el p ´ublico general, pues una cobertura exhaustiva resulta
Puede resultar interesante in-
vestigar m ´as en el tema, eligien-
do un dominio de su inter ´es y
comprobando si existen DSLs
para dicho dominio.
pr ´acticamente imposible e innecesaria para los objetivos aqu´ı propuestos.
El primero de los dominios que consideraremos es el de consulta y administra-
ci ´on de bases de datos. El modelo tradicional utiliza bases de datos relacionales,
que son agrupaciones de datos en v´ınculos (o relaciones) dadas por el proble-
ma a modelar. Para describir las consultas a este tipo de bases de datos, IBM
en 1970 desarroll ´o un DSL denominado SQL (por su denominaci ´on en ingl ´es,
Structured Query Language). Es uno de los DSLs m ´as conocidos hoy d´ıa. Este
lenguaje evolucion ´o con el tiempo, y dio lugar a diversos lenguajes de prop ´osito
general como FOX, CLIPPER, RBASE y los lenguajes asociados a los motores
de bases de datos Oracle e INFORMIX. Todos los lenguajes de esta familia se
denominan grupalemente como 4GL (Lenguajes de Cuarta Generaci ´on).
Otro dominio muy conocido es el de dise ˜no y especificaci ´on de contenidos
para la Web. En este dominio el lenguaje m ´as conocido es HTML, un lengua-
je de marcado (markup language) que permite especificar los elementos de una
Son lenguajes textuales que per-
miten anotar un documento con
etiquetas o tags que sirven pa-
ra especificar estructura, agre-
gar significados asociados a di-
ferentes elementos, asociar in-
formaci ´on de autor´ıa, revisiones,
etc ´etera.
p ´agina web de manera tal que diferentes herramientas puedan elegir c ´omo mos-
trarlos. Como otros lenguajes de marcado, HTML especifica informaci ´on a trav ´es
de etiquetas, m ´as conocidas por su denominaci ´on en ingl ´es, tags. Los tags son
Esta palabra tambi ´en se utiliza
en castellano como anglicismo
a ´un no aceptado por la Real
Academia Espa ˜nola.
utilizados para describir estructura, informaci ´on visual, comportamiento u otras
nociones, y son interpretados por las diferentes herramientas que analizan un
programa en uno de estos lenguajes para decidir diferentes cursos de acci ´on. Por
ejemplo, en el caso de HTML, los diferentes navegadores pueden elegir mostrar
los elementos de diferentes maneras dependiendo de factores tales como el tipo
de dispositivo (pantalla de PC, tel ´efono, etc.), las opciones elegidas (ver el c ´odigo
fuente o mostrar el resultado) y otros. Por eso se dice que HTML es un lenguaje
de marcado presentacional. Otro DSL asociado al dominio de presentaci ´on web
es el CSS, por el ingl ´es Cascading Style Sheets (hojas de estilo en cascada),
utilizado para especificar el estilo de presentaci ´on de una familia de documentos
de manera gen ´erica.
Otro DSL que se clasifica dentro de los lenguajes de marcado es el XML,
por eXtensible Markup Language (lenguaje de marcado extensible), que se uti-
liza para definir un conjunto de reglas de codificaci ´on de documentos en un for-
mato que es simult ´aneamente legible por las personas y por las computadoras.
Aqu´ı los tags se utilizan para expresar la estructura del documento, sus partes
y dependencias, y en ese sentido se puede considerar como un lenguaje de
marcado descriptivo. Los documentos descritos con XML est ´an correctamente
formados por definici ´on, siendo imposible la especificaci ´on de documentos con
partes faltantes o incompletos. El lenguaje es extremadamente flexible, pudiendo
utilizarse para describir metadatos, o sea, documentos que describen, de mane-
ra completamente formal y susceptible de ser analizada por las computadoras,
la forma de los datos o documentos a definir con el mismo lenguaje XML. Una
de las formas m ´as conocidas de este tipo de descripciones es llamada DTD,
por Document Type Definition (definici ´on de tipo de documento), un conjunto de
tags XML espec´ıficamente dise ˜nado para describir formatos de documentos. Del
XML evolucionaron otros lenguajes tales como RSS, ATOM, SOAP, and XHTML
(una versi ´on de HTML basada en las definiciones de XML).
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 36 of 312 --

37
Un tercer dominio, aunque por el momento solo difundido en la comunidad
cient´ıfica (m ´as espec´ıficamente entre matem ´aticos, f´ısicos e inform ´aticos), es el
de composici ´on tipogr ´afica (en ingl ´es, typesetting). En este dominio existe un len-
guaje de marcado extremadamente poderoso y flexible llamado LATEX, utilizado
Pronunciado “l ´atex” en caste-
llano, pero tambi ´en “l ´eitek” o
“l ´eitej” en el idioma ingl ´es.
para la preparaci ´on de documentos de alt´ısima calidad de presentaci ´on con m´ıni-
mo esfuerzo. LATEX es la parte frontal del languaje TEX, un lenguaje de marcado
para typesetting pero de m ´as bajo nivel. La forma de trabajo propuesta por este
lenguaje difiere de manera radical de la filosof´ıa WYSIWYG (What You See Is
What You Get, “lo que ves es lo que obten ´es”) promovida por las herramientas
como MS-Office y OpenOffice, permitiendo concentrarse m ´as en la estructura
del documento que en su presentaci ´on o composici ´on tipogr ´afica, aportando efi-
ciencia y flexibilidad con m´ınimo esfuerzo. Si bien la curva de aprendizaje de este
Es una forma de definir el es-
fuerzo requerido para aprender
cierta noci ´on en funci ´on del
tiempo requerido y los resulta-
dos obtenidos. Una curva ele-
vada indica que hace falta mu-
cho esfuerzo en poco tiempo pa-
ra obtener buenos resultados.
lenguaje es elevada al inicio, una vez que se alcanza un cierto grado de familia-
ridad la productividad se multiplica exponencialmente, permitiendo escribir libros
con la misma facilidad con la que se escriben documentos cortos. En particular
este libro fue dise ˜nado de manera completa utilizando LATEX. Existen extensiones
de LATEX para escribir presentaciones (similares a las de MS-Powerpoint, pero con
la filosof´ıa LATEX), p ´aginas web (permitiendo traducir a HTML u otros DSLs para
ese prop ´osito) y documentos con contenido espec´ıfico de numerosos dominios
(como matem ´aticas, qu´ımica, inform ´atica y muchos m ´as).
Otro dominio de inter ´es especialmente para programadores es el desarrollo
de lenguajes de programaci ´on, donde se definen herramientas conocidas anali-
zadores sint ´acticos, ´utiles a los dise ˜nadores de lenguajes de programaci ´on. Para
este prop ´osito existen lenguajes basados en las gram ´aticas BNF y utilizados en
herramientas como YACC, BISON, y una multitud de derivados.
Para terminar enumeramos algunas de los lenguajes y herramientas m ´as co-
nocidas en diversos dominios: POSTSCRIPT (para descripci ´on de p ´aginas para
impresi ´on y publicaci ´on electr ´onica), MATHEMATICA (para manipulaci ´on simb ´oli-
ca en ´areas cient´ıficas y de ingenier´ıa), VHDL (para especificaci ´on de hardware),
LOGO (para ense ˜nanza de programaci ´on en niveles iniciales), CSOUND (para es-
pecificaci ´on de sonidos), lenguajes para procesamiento de im ´agenes, lenguajes
de reescritura de grafos, de trazado de grafos, lenguajes para descripci ´on de
diagramas, y muchos, muchos otros.
Actividad 2
¿Puede determinar si existe alg ´un DSL para su ´area de dominio? Si
existe, investigue sobre las caracter´ısticas de dicho lenguaje.
Para Ampliar
Puede complementar lo visto sobre la historia de la programa-
ci ´on con un resumen visual en el video que se puede encontrar en:
http://programandoenc.over-blog.es/article-28741792.html
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 37 of 312 --

38
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 38 of 312 --

39
Primeros elementos de
programaci ´	on
Para empezar a entender la programaci ´on primero debemos abordar la forma
de expresar ideas en forma de c ´odigo: los lenguajes de programaci ´on. Y para
entender esos lenguajes debemos entender primero los distintos elementos que
podemos encontrarnos cuando construimos o leemos o miramos un programa.
En este cap´ıtulo vamos a empezar a conocer los bloques elementales que con-
forman cualquier lenguaje de programaci ´on. Y tambi ´en vamos a escribir nuestros
primeros programas en un lenguaje de programaci ´on.
2.1. Introducci ´on a elementos b ´asicos
La programaci ´on de computadoras involucra cierta forma de “expresar c ´odigo”,
actividad a la que denominamos programar. La forma de llevar adelante esta ta-
rea es utilizar lenguajes de programaci ´on, que permiten escribir c ´odigo en forma
de texto.
Los lenguajes de programaci ´on est ´an compuestos por distintos elementos,
que se relacionan en el c ´odigo de distintas maneras. Estos elementos y sus re-
laciones son similares a las que podemos encontrar en textos escritos en c ´odi-
gos lingu´ısticos ya conocidos, como los lenguajes naturales, con la ´unica dife-
rencia que poseen cierta precisi ´on adicional en su definici ´on. Por ejemplo, en
una oraci ´on en castellano podemos encontrar sustantivos, adjetivos, verbos, etc.,
combinados con ciertas reglas. En los lenguajes de programaci ´on vamos a en-
contrar expresiones, comandos, etc., tambi ´en combinados con ciertas reglas.
Una forma de empezar a entender un lenguaje de programaci ´on, es primero
entender cu ´ales son las formas b ´asicas de estos elementos. Es importante vol-
Estas formas b ´asicas quiz ´as
aparezcan combinadas o distor-
sionadas en diferentes lengua-
jes de programaci ´on, pero en-
tendi ´endolas se pueden tambi ´en
entender las formas complejas.
Esto es igual que en los lengua-
jes naturales.
ver a remarcar que cada elemento en programaci ´on est ´a definido de una manera
rigurosa en la que no se admite ning ´un tipo de ambig ¨uedad, como s´ı puede su-
ceder en el idioma castellano.
Al programar, el programador puede escribir directamente el texto, como es el
caso del lenguaje que utilizaremos en este libro o los lenguajes de prop ´osito ge-
neral m ´as conocidos y de nivel profesional, o puede utilizar alg ´un tipo de interfaz
visual, como es el caso de las herramientas SCRATCH o ALICE, ambas basadas
en la idea de trasladar y enganchar bloques gr ´aficos entre s´ı. Al usar ´unicamente
la forma en texto podemos escribir combinaciones de palabras que no signifiquen
nada en el lenguaje o podemos escribirlas en lugares donde no tenga sentido que
aparezcan (somos libres de escribir lo que queramos, como queramos, donde
queramos, y no todo lo que escribamos ser ´a un programa que pueda ejecutarse,
dado que podr´ıa no seguir la estructura que define la sintaxis). En cambio, en los
programas confeccionados con herramientas visuales como SCRATCH o ALICE,
no podemos formar c ´odigo incorrecto dado que los bloques est ´an en una paleta
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 39 of 312 --

40
y son arrastrados al editor; adem ´as la forma en que son enganchados impide
que el resultado no sea una secuencia o expresi ´on bien formada). Por esta raz ´on
estas herramientas se suelen utilizar en los niveles iniciales (como primaria o pri-
meros a ˜nos del secundario), ya que facilitan la confecci ´on de c ´odigo. Pero para
poder formar programadores de nivel profesional es necesario enfrentar la tarea
de escribir el texto a mano y ser capaces de distinguir las combinaciones v ´alidas
de las inv ´alidas; es incluso deseable que al programar los programas se escriban
y razonen en primer lugar en papel, y reci ´en luego de tenerlos listos pasarlos en
la computadora.
Empecemos entonces hablando de los elementos de los lenguajes de progra-
maci ´on.
2.1.1. Valores y expresiones
El primero de los elementos comunes a la mayor´ıa de los lenguajes de progra-
maci ´on son los valores. Los valores pueden representar, por ejemplo, n ´umeros,
colores, nombres de personas, n ´umeros de tel ´efono. Como puede observarse,
estos elementos representan datos, que los programas manipulan y transforman.
Definici ´on 2.1.1. Un valor es una entidad o dato con sus caracter´ısticas propias.
Ejemplos de valores son el n ´umero dos, el color rojo, el nombre de mi t´ıo Arturo,
etc ´etera.
Sin embargo, para hablar o escribir valores sin ambig ¨uedad, se utilizan otros
elementos llamados expresiones, que son la forma en que se describen valores.
Las expresiones est ´an formadas por s´ımbolos y cadenas de s´ımbolos, y requie-
Puede entablarse una analog´ıa
entre las expresiones y los valo-
res, y las palabras del espa ˜nol y
las ideas o conceptos a los que
hacen referencia. Adem ´as, las
palabras tambi ´en se forman a
trav ´es de s´ımbolos, que especifi-
camente son letras del abecede-
rio m ´as otros signos ling ¨u´ısticos.
Y as´ı como las ideas son nece-
sariamente expresadas a trav ´es
de palabras, los valores en los
programas deben ser descritos a
trav ´es de expresiones.
ren una interpretaci ´on para entender qu ´e valor describen.
Leer con Atenci ´on
En s´ıntesis, las expresiones son la forma en que los valores se mani-
fiestan en el c ´odigo fuente de los programas, y los valores son aquellos
conceptos o ideas que dichas expresiones referencian.
Definici ´on 2.1.2. Una expresi ´on es un s´ımbolo o cadena de s´ımbolos que se
utiliza para describir, denotar o nombrar un valor espec´ıfico.
La idea de denotar puede ser nueva o poco conocida. Por eso creemos conve-
niente definirla.
Definici ´on 2.1.3. Denotar algo es referirse de manera espec´ıfica a eso, distin-
guirlo de otros de manera ´unica. Seg ´un el diccionario es “significar”.
Por eso usamos denotar como sin ´onimo de describir, aunque estrictamente no
lo sea: cuando describimos algo, estamos refiri ´endonos a ello, signific ´andolo. En
este sentido es que se dice que las expresiones denotan valores.
Para Reflexionar
Por ejemplo, existen infinidad de formas posibles de describir al n ´ume-
ro cinco: n ´umeros ar ´abigos (5), n ´umeros romanos (V ), la cara de un
dado ( ), con f ´osforos en el truco ( ), operaciones compuestas con
n ´umeros (3 + 2), y muchas otras. ¿Observa la diferencia entre las distin-
tas expresiones, y el valor cinco? ¿Se da cuenta que con cualquiera de
ellas, una persona que conoce el m ´etodo de intepretaci ´on de un s´ımbolo,
puede identificar al valor referido?
Ejemplos de expresiones tal como aparecer´ıan en un programa (forma textual),
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 40 of 312 --

41
G.2.1. Ejemplos de valores en el programa Open Office
junto con una descripci ´on en castellano del respectivo valor que denotan (puesto
que no podemos presentar los valores sin hablar de ellos en alg ´un lenguaje. . . ),
son las que se presentan en la siguiente tabla:
Expresi ´on Valor
2 n ´umero dos
5 n ´umero cinco
4+1 n ´umero cinco
Rojo color rojo
"Arturo" nombre de persona
Observar que las expresiones pueden tener formas b ´asicas, at ´omicas (como 5),
o pueden estar formadas por partes (como 4+1), y sin embargo se refieren al
mismo valor. En ese caso, se suele decir que las expresiones son equivalentes,
y por ende pueden ser intercambiadas a elecci ´on.
Para Reflexionar
¿Cu ´antas formas equivalentes de describir al valor 5 usando n ´umeros
y sumas puede imaginarse? Reflexione sobre la diferencia entre una
expresi ´on cualquiera y el valor que describe.
Esta idea de valor de los lenguajes de programaci ´on se puede ver tambi ´en en las
interfases de los programas que implementan herramientas gr ´aficas, como edi-
tores de texto, etc ´etera. En dichas herramientas inform ´aticas aparecen valores,
aunque las expresiones que se usan para describir estos valores adoptan dife-
rentes formas (´ıconos, texto, etc ´etera). En el gr ´afico G.2.1 podemos visualizar
distintos valores, y la forma en que aparecen graficados en un programa (el edi-
tor de textos de Open Office). En el ejemplo, los valores son el tipo de la fuente, el
Es un programa libre, de fun-
cionalidad similar a otras herra-
mientas no libres, como Word.
Para conocer esta herramien-
ta en mayor profundidad, ver
http://www.openoffice.org/
es/
tama ˜no de la fuente, el color de la fuente, y un texto con la palabra “Texto”. Todos
estos valores aparecen de una forma u otra en el c ´odigo que los programadores
de dichas herramientas escriben.
Actividad 1
Trate de identificar otros valores que aparecen mostrados en el Open
Office. Elija otro programa de uso tradicional (por ejemplo, una planilla
de c ´alculo, un editor de gr ´aficos, etc.), y trate de identificar valores que
aparezcan graficados en los mismos.
Las expresiones que podemos utilizar cuando codificamos programas, su forma
exacta y la forma en que podemos manipularlas depender ´an del lenguaje de pro-
gramaci ´on que estemos utilizando. Las reglas que rigen estas formas (y otras) se
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 41 of 312 --

42
conocen como sintaxis del lenguaje de programaci ´on. La sintaxis normalmente
consiste en reglas r´ıgidas que hay que aprender para cada lenguaje. Al aprender
un lenguaje de programaci ´on deben aprenderse todas las reglas de sintaxis de
cada uno de los elementos, en combinaci ´on con qu ´e cosas describe cada uno de
ellos (su significado o sem ´antica). Volveremos sobre este punto m ´as adelante.
Definici ´on 2.1.4. La sintaxis de un lenguaje de programaci ´on es el conjunto de
reglas r´ıgidas que establecen con qu ´e s´ımbolos se denotan las diferentes formas
de combinaci ´on v ´alidas en dicho lenguaje.
Definici ´on 2.1.5. La sem ´antica de un lenguaje de programaci ´on es el significa-
do de cada una de las construcciones sint ´acticas del lenguaje. Puede definirse
matem ´aticamente, o bien darse a trav ´es de un mecanismo de ejecuci ´on (en cuyo
caso la sem ´antica precisa ser ´a impl´ıcita).
Por otra parte, dependiendo del tipo de programa con el que trabajamos, los valo-
res ser ´an en mayor o menor medida el centro de atenci ´on. Por ejemplo, de tratar-
se de un sistema de facturaci ´on, los datos registrados por el programa ser ´an de
suma importancia, y su correcta conservaci ´on representa el objetivo del mismo.
Por el contrario, un programa de edici ´on de videos se centrar ´a principalmente
en transformar informaci ´on para producir un producto final, siendo los valores
individuales menos relevantes.
2.1.2. Acciones y comandos
Sin embargo, no toda idea es un valor. En muchas situaciones simplemente des-
cribir datos no alcanza para que los programas resuelvan problemas. Por esta
raz ´on, los programas tambi ´en describen acciones, que son la manera de producir
efectos o consecuencias operacionales sobre diversos elementos, generalmente
externos a los programas. Por ejemplo, existen programas que manipulan m ´aqui-
nas en f ´abricas, impresoras, fotocopiadoras, etc. o que reproducen im ´agenes y
sonidos sobre dispositivos audiovisuales, y tambi ´en los programas tradicionales
como editores de texto o planillas de c ´alculo, que modifican archivos, imprimen
documentos, etc ´etera. Todos estos programas est ´an produciendo efectos sobre
el mundo, a trav ´es de modificar los elementos sobre los que operan.
Definici ´on 2.1.6. Una acci ´on es la manera de producir un efecto sobre un ele-
mento u objeto del mundo, ya sea interno o externo al programa en s´ı.
As´ı como los valores se manifiestan en los lenguajes de programaci ´on a trav ´es
de las expresiones, las acciones son descritas mediante comandos. Lo que dis-
tingue a los comandos de las expresiones es la idea a la que hacen referencia.
Mientras las expresiones referencian cosas (abstractas o concretas), los coman-
dos referencian acciones (formas de producir efectos). Pero tanto expresiones
como comandos est ´an formados por cadenas de s´ımbolos. Ejemplos de coman-
Existen lenguajes en donde
se puede distinguir visualmente
cu ´ando una cadena de s´ımbolos
se trata de una expresion o un
comando, haciendo que uno em-
piece con min ´usculas y otro con
may ´usculas por ejemplo; pero
esto no es un requisito esen-
cial y en muchos lenguajes estas
construcciones pueden manifes-
tarse bajo la misma forma, e in-
cluso combinadas.
dos, con su respectiva acci ´on, tal como podr´ıan aparecer en algunos programas,
son:
Comando Acci ´on
MostrarEnPantalla muestra un dato por pantalla
EliminarCarpeta elimina la carpeta seleccionada de nuestro disco duro
ApagarComputadora apaga la computadora que estemos utilizando
ImprimirArchivo ordena a la impresora que imprima un archivo
EnviarMail env´ıa por correo electr ´onico el texto que redactamos
Definici ´on 2.1.7. Un comando es una cadena de s´ımbolos que describe una
acci ´on espec´ıfica.
De la misma forma que los valores, las acciones tambi ´en se encuentran gra-
ficadas en los programas tradicionales. En el gr ´afico G.2.2 podemos visualizar
distintas acciones encontradas en el programa Open Office.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 42 of 312 --

43
G.2.2. Ejemplos de acciones en el programa Open Office
La mayor´ıa de los lenguajes de programaci ´on trabajan con comandos. Al igual
que con las expresiones, la forma exacta en que se construyen comandos co-
rresponde a la sintaxis del lenguaje, y se rige por las mismas reglas r´ıgidas, que
como se mencion ´o, son una de las cosas a aprender al estudiar un lenguaje
de programaci ´on. En el caso de los comandos, su significado (su sem ´antica) es
normalmente entendida a trav ´es de la forma en que la m ´aquina que ejecuta el
programa lleva a cabo las acciones correspondientes. Esto se conoce como com-
portamiento operacional del comando, y es com ´un no distinguir entre el comando
como descripci ´on de la acci ´on y la acci ´on en s´ı. Sin embargo, en algunos casos
es fundamental hacer esta distinci ´on, y por ello es importante conocerla.
Leer con Atenci ´on
Un comando no es m ´as que un texto que describe una acci ´on, y como
tal, no “hace” nada; solo describe lo que se pretende que una m ´aquina
haga. Sin embargo en el lenguaje cotidiano solemos decir que, por ejem-
plo, el comando GrabarArchivo graba el archivo, y no que describe la
acci ´on de grabar el archivo.
Para Reflexionar
Reflexione sobre la naturaleza de los comandos como cadenas de
s´ımbolos, y sobre el hecho de que la misma acci ´on puede llegar a des-
cribirse de diferentes maneras. ¿Por qu ´e cree que abusamos del len-
guaje diciendo que un comando hace la acci ´on, cuando en realidad solo
la describe? Medite cu ´antas veces en el lenguaje cotidiano no somos
exactos con lo que decimos, y sin embargo nos entendemos, y tambi ´en
cu ´antas veces ese abuso del lenguaje nos conduce a equ´ıvocos.
2.1.3. Operaciones sobre expresiones y comandos
De asignaturas de matem ´atica es sabido que podemos realizar operaciones so-
bre distintas expresiones. Por ejemplo, los n ´umeros pueden ser sumados, resta-
dos y multiplicados; las palabras pueden ser concatenadas (puestas una a con-
tinuaci ´on de las otras); y los colores pueden ser combinados para formar otros
colores. A todas estas operaciones que utilizan expresiones para resultar en otras
expresiones las denominaremos operaciones sobre expresiones. El resultado de
una operaci ´on sobre expresiones es siempre una nueva expresi ´on, y por lo tanto
puede volver a combinarse. Entonces, podemos escribir (2 + 3) ∗ 4 combinando
la expresi ´on 2 + 3 con la expresi ´on 4 a trav ´es de la operaci ´on de multiplicaci ´on.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 43 of 312 --

44
Expresi ´on Tipo
Rojo Color
"Casa" Palabra
2+4 N ´umero
Norte Direcci ´on
G.2.3. Ejemplos de expresiones con sus tipos
Nuevamente, las reglas de sintaxis de un lenguaje establecen qu ´e operaciones
son posibles sobre cada expresi ´on, permitiendo de esa forma conocer el total de
las expresiones del lenguaje.
Los comandos tambi ´en pueden ser combinados mediante operaciones. En
el caso de los comandos, las operaciones se suelen conocer con el nombre de
estructuras de control. Por ejemplo, dos comandos pueden ponerse uno a con-
tinuaci ´on del otro para indicar que luego de terminar la acci ´on descrita por el
primero de ellos, debe llevarse a cabo la segunda acci ´on; esta estructura de con-
trol se conoce como secuenciaci ´on. La sintaxis de un lenguaje tambi ´en establece
las posibles estructuras de control y su significado.
Cada lenguaje tiene sus propias
estructuras de control. En el len-
guaje que aprenderemos en bre-
ve veremos las formas m ´as b ´asi-
cas de las mismas, que combi-
nadas son extremadamente po-
derosas. Sin embargo el reper-
torio de estructuras de control
es ampl´ısimo y debe prestarse
atenci ´on en cada lenguaje.
2.1.4. Tipos de expresiones
Los valores son parte de distintos conjuntos. Por ejemplo, el n ´umero dos for-
ma parte de los n ´umeros naturales, las palabras forman parte del conjunto de
todas las palabras y los colores forman parte del conjunto total de colores. De-
nominaremos tipo de una expresi ´on a un conjunto de expresiones determinado,
y lo denotaremos mediante alg ´un nombre especial. Diremos, por ejemplo, que la
expresi ´on 2 posee tipo N ´umero, y el color Rojo posee tipo Color.
Actividad 2
D ´e seis ejemplos m ´as de expresiones utilizando como gu´ıa los tipos
dados como ejemplo en el gr ´afico G.2.3
Para Reflexionar
¿Cu ´al puede ser la utilidad de los tipos en un lenguaje de programaci ´on?
Piense sobre qu ´e podr´ıa significar Rojo+Norte, o "Casa"*"Auto".
Cuando veamos el conjunto de operaciones sobre expresiones, en el cap´ıtulo 3,
subsecci ´on 3.2.1, veremos la utilidad que le daremos a los tipos en este libro.
Sin embargo, los tipos son ´utiles en varias formas, que exceden completamente
el alcance de este curso. Por otra parte, existen lenguajes con tipos y sin tipos,
y dentro de los que utilizan tipos, las construcciones e ideas var´ıan de lenguaje
en lenguaje. Pero incluso en su forma b ´asica, los tipos representan una ayuda
importante a la hora de pensar un programa.
2.2. Elementos b ´asicos de Gobstones
Para ejemplificar todas las nociones explicadas hasta el momento, y comen-
zar a aprender un lenguaje de programaci ´on, utilizaremos un lenguaje llamado
GOBSTONES, que nos permitir ´a entender estos conceptos b ´asicos de programa-
GOBSTONES fue dise ˜nado e im-
plementado por docentes de la
UNQ con el ´unico prop ´osito de
servir como lenguaje inicial para
aprender a programar. El nom-
bre fue tomado de un juego de
bolitas m ´agicas que aparece en
los libros de la saga de Harry
Potter, por J.K.Rowling.
ci ´on en profundidad, antes de pasar a conceptos de mayor complejidad.
GOBSTONES es un lenguaje conciso de sintaxis razonablemente simple, orien-
tado a personas que no tienen conocimientos previos en programaci ´on. El len-
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 44 of 312 --

45
guaje maneja distintos componentes propios, ideados con el fin de aprender a
resolver problemas en programaci ´on, pero al mismo tiempo intentando volver
atractivo el aprendizaje, para lograr captar la atenci ´on y capacidad de asombro
del estudiante.
Cada concepto relacionado a GOBSTONES ser ´a definido de una manera m ´as
estricta que la que habitualmente encontrar´ıamos en otras disciplinas.
Para Reflexionar
¿A qu ´e cree usted que se debe la necesidad de ser estrictos, particulari-
dad de la programaci ´on? Intente relacionarla con el cap´ıtulo 1, en el que
explicamos la naturaleza de la programaci ´on. Piense espec´ıficamente
en la necesidad de que los programas ejecuten de manera autom ´atica
muchas de las tareas que realizan, sin intervenci ´on del usuario en estos
casos.
El lenguaje GOBSTONES queda definido por el conjunto de reglas de sintaxis y su
significado asociado; sin embargo, para poder efectivamente ejecutar programas
GOBSTONES, hace falta contar con alguna herramienta inform ´atica que lo imple-
mente. Actualmente existen dos herramientas, una b ´asica constru´ıda utilizando
el lenguaje de programaci ´on Haskell, denominada sencillamente GOBSTONES,
por haber sido la primera, y otra m ´as elaborada constru´ıda utilizando el lenguaje
de programaci ´on Python, denominada PYGOBSTONES. En este libro utilizaremos
PYGOBSTONES; en el anexo A se explica c ´omo obtenerla y c ´omo utilizarla.
Para Ampliar
Para conocer m ´as de Haskell, ver
www.haskell.org
Para conocer m ´as de Python, ver
www.python.org
Es importante explicar la diferencia entre un lenguaje y una herramienta o am-
biente que implementa y permite el uso de ese lenguaje. El lenguaje es el conjun-
to de reglas de combinaci ´on que permiten la construcci ´on de programas v ´alidos
(en dicho lenguaje). En cambio, una herramienta o ambiente es un programa es-
pec´ıfico, casi siempre ´unicamente ofrecido en formato ejecutable, que asiste al
programador en la construcci ´on de programas en uno o m ´as lenguajes dados
mediante herramientas como editores de texto con funcionalidades adicionales
(resaltado de sintaxis, indicaci ´on de posibles errores, etc.) o mecanismos au-
tom ´aticos para ejecutar los programas escritos con la herramienta. Entonces,
dado un lenguaje puede haber diversas herramientas que lo implementen, y de
manera an ´aloga, una herramienta podr´ıa permitir la construcci ´on de programas
en diversos lenguajes. GOBSTONES es un lenguaje con el que vamos a cons-
truir programas elementales, y por lo tanto tiene sintaxis y sem ´antica. En cambio
Recordemos que la sintaxis
est ´a conformada por las reglas
que permiten combinar elemen-
tos del lenguaje para construir
programas v ´alidos, y la sem ´anti-
ca est ´a conformada por las re-
glas que dan significado a ca-
da construcci ´on sint ´acticamente
v ´alida.
PYGOBSTONES es una herramienta que nos ayudar ´a a construir y ejecutar pro-
gramas escritos en GOBSTONES, para lo cual posee diversas ventanas y botones
que brindan diferentes funcionalidades. Lo que puede confundir es que las herra-
mientas, al ser programas, est ´an programadas usando alg ´un lenguaje de progra-
maci ´on. En este caso, PYGOBSTONES fue programada en el lenguaje PYTHON.
En la mayor´ıa de los casos no es importante con qu ´e lenguaje fue programa-
da una herramienta (e incluso el mismo podr´ıa cambiar entre dos versiones de
la misma herramienta), pero a veces, como en este caso, influye en las cosas
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 45 of 312 --

46
G.2.4. Un tablero de 3 filas y 4 columnas, en 3 dimensiones
G.2.5. El mismo tablero en 2 dimensiones
que deberemos instalar en nuestra computadora para poder ejecutar PYGOBS-
TONES, y por eso es importante mencionarlo. Sin embargo, volvemos a remarcar
que GOBSTONES y PYTHON son lenguajes de programaci ´on que no tienen nada
que ver entre s´ı, y que PYGOBSTONES es una herramienta implementada usando
PYTHON y que implementa el lenguaje GOBSTONES.
Antes de comanezar con el estudio de la sintaxis de GOBSTONES es necesa-
rio comenzar a comprender este lenguaje presentando algunos de los elementos
que existen en su universo de discurso, que es el conjunto de ideas que los pro-
gramas GOBSTONES describen a trav ´es de la sintaxis del lenguaje.
2.2.1. Tablero y bolitas
El componente m ´as notable de GOBSTONES es el tablero. El tablero es una
cuadr´ıcula de celdas dispuestas en filas y columnas. Cada celda es un conte-
nedor en el que puede haber bolitas de colores. En la versi ´on actual de GOBSTO-
NES existen bolitas de cuatro colores: Azul, Negro, Rojo y Verde. Las bolitas son
Azul, Negro, Rojo y Verde son
expresiones que denotan a los
colores de las bolitas
simples canicas como las que se usan para el juego de ni ˜nos del mismo nombre,
siendo su color la ´unica caracter´ıstica importante que nos interesa observar (o
sea, ignoraremos el tama ˜no, si se trata de una plumita o una lechera, y lo mismo
con otras posibles caracter´ısticas).
En los gr ´aficos G.2.4 y G.2.5 se observan dos representaciones de un tablero
t´ıpico, con 3 filas y 4 columnas, y algunas bolitas.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 46 of 312 --

47
G.2.6. El tablero del gr ´afico G.2.4 con la representaci ´on del cabezal
G.2.7. El mismo tablero en dos dimensiones
Definici ´on 2.2.1. El tablero es una cuadr´ıcula de celdas. Las celdas pueden
contener bolitas de colores.
El tablero es finito, y en un principio no hay una forma directa de saber su dimen-
si ´on exacta. Por otra parte, las celdas tienen una capacidad ilimitada, pudiendo
contenter cualquier n ´umero de bolitas.
2.2.2. El cabezal
Tanto el tablero como las bolitas son componentes inanimados. El factor de mo-
vimiento en GOBSTONES viene dado por una m ´aquina que puede operar sobre
el tablero y las bolitas. Esta m ´aquina puede realizar diversas acciones (siempre
sobre una ´unica celda por vez). Las acciones incluyen desplazarse a una celda
vecina, poner y sacar bolitas en la celda sobre la que se encuentra, y consultar
si hay bolitas en una celda, y cu ´antas hay.
La m ´aquina, que ser ´a denominada cabezal para remarcar el hecho de que opera
sobre una celda por vez, puede recibir instrucciones relativas a la celda sobre la
que se encuentra el mismo, y a la que se denomina celda actual.
En los gr ´aficos G.2.6 y G.2.7 se observa el tablero presentado antes con una
representaci ´on del cabezal y la celda actual.
Definici ´on 2.2.2. El cabezal es una m ´aquina que opera sobre una celda por vez,
la celda actual.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 47 of 312 --

48
Para Reflexionar
¿Cu ´al de los conceptos que hemos visto hasta ahora representar ´a en el
c ´odigo de programas GOBSTONES a las acciones que realiza el cabezal?
¿Y cu ´al permitir ´a describir los colores de las bolitas?
Otra caracter´ıstica importante del cabezal, adem ´as de que puede operar sobre
una celda por vez, es que dispone de una cantidad ilimitada de bolitas de cada
color. Esto, al igual que las caracter´ısticas del tablero y las celdas, determinar ´a al-
gunas de las formas de hacer cosas en GOBSTONES.
Ahora bien, el cabezal puede realizar acciones, pero al no tener voluntad pro-
pia, ni ning ´un tipo de inteligencia, debe indic ´arsele qu ´e es lo que esperamos que
haga. Sin embargo, el cabezal no es una m ´aquina que podamos manejar (como
un auto o un montacargas), sino que lo ´unico que podemos hacer es darle una
descripci ´on de las acciones que queremos que haga, y decirle “dale, ejecutalas”.
La forma de comunicarle al cabezal la descripci ´on de las acciones que queremos
que realice es un programa. As´ı, todo el objetivo de un programa GOBSTONES
es servir para indicar al cabezal que lleve a cabo determinada serie de modifi-
caciones al tablero, con alg ´un prop ´osito determinado. Para ello, precisamos los
elementos del lenguaje.
2.2.3. Programas y comandos simples
La manera de darle instrucciones al cabezal es a trav ´es de un programa. Un
programa GOBSTONES se puede entender como la descripci ´on de las acciones
que el cabezal debe intentar realizar cuando recibe la indicaci ´on de ejecutar el
programa, o sea, interpretar las acciones descritas all´ı y llevarlas a cabo sobre el
tablero.
Un programa est ´a formado por comandos, que, como ya mencionamos, son
descripciones de acciones individuales; m ´as adelante veremos que tambi ´en pue-
de llevar un conjunto de definiciones. O sea, los comandos por s´ı mismos no son
programas completos, sino que integran unidades m ´as grandes, denominadas
programas y procedimientos. Todo programa contendr ´a, al menos, una serie de
Los procedimientos ser ´an pre-
sentados en la secci ´on 2.2.8, y
explicados en profundidad en el
cap´ıtulo 3.
comandos que ser ´an los que el cabezal intentar ´a llevar a cabo al ejecutar dicho
programa.
Definici ´on 2.2.3. Un programa GOBSTONES es una descripci ´on de las acciones
que el cabezal intentar ´a realizar al ejecutar el mismo. Esta descripci ´on se brinda
a trav ´es de comandos.
Entonces, para poder construir programas, primero debemos conocer algunos
comandos. El primer comando de GOBSTONES que vamos a presentar es el co-
¡Estamos empezando a apren-
der la sintaxis espec´ıfica de un
lenguaje de programaci ´on!
mando Poner. Un caso particular de este comando es el comando Poner(Verde),
que describe la acci ´on de agregar una bolita verde en la celda actual. Esta acci ´on
siempre podr ´a ser llevada a cabo, pues, como ya se mencion ´o, se asume que el
cabezal tiene a su disposici ´on una cantidad ilimitada de bolitas de cada color y,
que las celdas tienen capacidad infinita, con lo cual la acci ´on de poner siempre
puede realizarse.
Para definir un programa debemos colocar el comando reci ´en visto de forma
tal que el cabezal, al recibir la orden de ejecutar el programa est ´e en condiciones
de decodificarlo y ejecutarlo. Para ello, se utiliza una “palabra especial”, program,
que indica al cabezal que a continuaci ´on, encerrados entre llaves ({ y }), estar ´an
los comandos que describen las acciones que deber ´a intentar llevar a cabo al
recibir la orden de ejecutar el programa. Esta “palabra especial” recibe un nombre
espec´ıfico en el tratamiento de lenguajes de programaci ´on: palabra reservada.
As´ı, el programa GOBSTONES m ´as sencillo que podemos escribir ser ´a
program
{ Poner(Verde) }
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 48 of 312 --

49
Leer con Atenci ´on
El primer programa en la mayor´ıa de los cursos tradicionales de pro-
gramaci ´on es algo del tipo “¡Hola, mundo!”, donde se imprime algo por
pantalla. Sin embargo, en GOBSTONES no existe ning ´un mecanismo de
entrada/salida expl´ıcito; la ´unica interacci ´on que se tiene con la m ´aquina
es la provisi ´on de un tablero inicial. Esto es absolutamente premeditado,
puesto que las nociones de entrada/salida son extremadamente com-
plejas, al estar asociadas de manera indisoluble al estado del “mundo
concreto” (o sea, lo que constituye nuestro ambiente cotidiano, pero que
no es necesariamente el ambiente de computaci ´on de la m ´aquina). Es
mucho mejor diferir toda noci ´on de entrada/salida hasta el momento en
que se maneje con fluidez la noci ´on de estado y de efectos sobre el es-
tado. En particular, en la secuencia did ´actica que proponemos en este
libro hemos preferido no incluir ese tema. Creemos que intentar ense ˜nar
conceptos b ´asicos mezclados con conceptos avanzados es uno de las
mayores dificultades asociadas a la ense ˜nanza de la programaci ´on.
Al indicarle al cabezal que ejecute el programa, se ejecutar ´an todos los coman-
dos encerrados entre las llaves que aparecen despu ´es de la palabra reservada
program.
Las palabras reservadas o palabras clave son nombres especiales de los len-
En ingl ´es, reserved words o key-
words.
guajes de programaci ´on que sirven para identificar diversas ideas en el programa.
Cada lenguaje define su propio conjunto de palabras reservadas, que no pueden
usarse, dentro de ese lenguaje, para ning ´un otro prop ´osito que aquel para el que
fueron pensadas.
Definici ´on 2.2.4. Las palabras reservadas son nombres especiales de los len-
guajes de programaci ´on que sirven para identificar diversas ideas en el programa.
Definici ´on 2.2.5. Un programa GOBSTONES consiste de la palabra reservada
program seguida de un bloque de comandos (encerrados entre llaves { y }). Este
bloque de comandos determina completamente el comportamiento del cabezal
al ejecutar el programa.
En el caso del programa del ejemplo, describe la sencilla acci ´on de que el cabezal
debe intentar poner una bolita de color verde al recibir la instrucci ´on de ejecutar
el programa. En la secci ´on 2.2.6 hablaremos m ´as de c ´omo hacer esto, de lo que
significa y de c ´omo se puede visualizar el resultado del programa. Pero antes de
estar en condiciones de comenzar a realizar actividades de programaci ´on, vamos
a profundizar un poco m ´as sobre comandos b ´asicos.
2.2.4. El comando Poner
Ya vimos una forma particular del comando Poner: Poner(Verde). Sin embargo,
no es la ´unica. La forma general del comando Poner est ´a dada por la siguiente
definici ´on.
Definici ´on 2.2.6. El comando Poner(< color >) indica al cabezal que coloque
una bolita del color < color > en la celda actual.
Los valores posibles para < color > son los ya indicados: Verde, Rojo, Azul y
Observar que el nombre
< color > se encuentra en
diferente formato (y color) para
indicar que no debe ir la palabra
color, sino un color particular.
De aqu´ı en m ´as, cuando apa-
rezca el nombre < color > de
esta manera, querr ´a decir que
debe elegirse la descripci ´on de
un color para colocar en ese
lugar.
Negro. O sea, son comandos v ´alidos
Poner(Verde),
Poner(Rojo),
Poner(Azul) y
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 49 of 312 --

50
Poner(Negro).
Cuando se agreguen otras formas de describir colores, tales formas tambi ´en
podr ´an ser usadas en donde se espera un < color >.
Definici ´on 2.2.7. Los valores posibles para un < color > son Verde, Rojo, Azul
o Negro.
2.2.5. Secuencias y bloques de comandos
¿Qu ´e debe hacerse para describir la indicaci ´on al cabezal que debe poner m ´as
de una bolita en la celda actual? Dicha descripci ´on debe contener dos comandos
seguidos. La manera de colocar seguidos comandos en GOBSTONES es ponerlos
uno a continuaci ´on del otro; por ejemplo
Poner(Verde)
Poner(Verde)
es un fragmento de programa que describe que al ejectuarlo, el cabezal debe
colocar dos bolitas verdes en la celda actual.
Opcionalmente, pueden colocarse un punto y coma despu ´es de un comando,
y en ese caso no es necesario colocar los comandos en l´ıneas separadas. As´ı,
los programas
Poner(Verde); Poner(Verde)
y
Poner(Verde); Poner(Verde);
tambi ´en son v ´alidos, y equivalentes al primero.
Esta idea de poner comandos uno a continuaci ´on del otro es una estructu-
ra de control elemental, y se conoce con el nombre de secuenciaci ´on. La se-
cuenciaci ´on de dos comandos es un comando compuesto que describe la acci ´on
consistente en realizar las acciones m ´as simples descritas por los comandos se-
cuenciados, en el orden dado.
Definici ´on 2.2.8. La secuenciaci ´on de comandos se obtiene colocando los mis-
mos uno a continuaci ´on del otro, normalmente en l´ıneas separadas, y opcional-
mente terminados con el caracter de punto y coma ( ;).
Entonces, si queremos hacer un programa que ponga dos bolitas verdes, debe-
mos escribir
program
{
Poner(Verde)
Poner(Verde)
}
Otra noci ´on importante relacionada con los comandos es la delimitaci ´on de un
grupo de comandos en un comando compuesto. Esto se lleva a cabo mediante
lo que se denomina un bloque, que se compone de una secuencia de comandos
delimitados por llaves. Entonces, un bloque de c ´odigo v ´alido ser´ıa
{
Poner(Verde); Poner(Verde)
Poner(Rojo); Poner(Rojo)
Poner(Azul); Poner(Azul)
Poner(Negro); Poner(Negro)
}
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 50 of 312 --

51
que describe una acci ´on, cuyo efecto al ejecutarse ser´ıa colocar dos bolitas de
cada color en la celda actual.
Definici ´on 2.2.9. Un bloque es comando formado por un grupo de comandos
delimitados por llaves (caracteres { y }).
Los bloques tendr ´an importancia en la definici ´on de comandos compuestos a
trav ´es de ciertas estructuras de control y, como vimos, en la definici ´on de un
programa.
En este punto somos capaces de construir comandos cuyo ´unico efecto es
poner muchas bolitas de muchos colores y con ellos programas sencillos. Luego
de ver a continuaci ´on c ´omo ejecutar programas, iremos enriqueciendo el repe-
torio de formas de construir descripciones de las acciones que queremos que el
cabezal realice en nuestros programas.
2.2.6. Ejecuci ´on de progamas
Sabiendo c ´omo definir programas completos, estamos en condiciones de comen-
zar a realizar actividades de programaci ´on.
Leer con Atenci ´on
Las actividades de programaci ´on incluyen dos partes: por un lado, debe
escribirse el programa en papel, para lo cual primero debe ordenar sus
ideas, nombrar los diferentes elementos y estructurar la soluci ´on; por
otro lado, debe cargarse el programa en alguna herramienta y ejecutarlo,
para ver los resultados de manera fehaciente.
Al escribir el programa en papel, lo m ´as importante es validar que las ideas son
las correctas, y que est ´an seleccionadas y ordenadas adecuadamente para resol-
ver la tarea encomendada. Sin embargo, el c ´odigo en papel puede considerarse
como un borrador, y puede por lo tanto contener peque ˜nos errores, detalles que
pueden dejarse para un mejoramiento posterior porque no hacen a la estructura
de la soluci ´on. Para poder afirmar que tenemos un programa, debemos poder
ejecutarlo en alguna m ´aquina, y verificar que realmente hace aquello para lo que
lo construimos. Esta tarea de verificaci ´on puede ser muy compleja en el caso de
programas complicados, pero en principio nos resultar ´a sencillo.
Leer con Atenci ´on
Una herramienta muy importante para asistir al programador en la verifi-
caci ´on de los progamas son los sistemas de tipos modernos. Un sistema
de tipos es un conjunto de reglas sobre las partes de un programa, que
pueden ser verificadas autom ´aticamente sin ejecutar el programa, ayu-
dando a verificar de esta formen la validez de ciertas construcciones.
Si el sistema de tipos est ´a bien definido (lo cual es sorprendentemente
complejo), much´ısimos de los errores comunes de los programas son
detectados antes de realizar ninguna ejecuci ´on. Este hecho no siempre
es bien comprendido, y se tiende a considerar a los sistemas de tipos
como una restricci ´on innecesaria, en lugar de como la gran herramienta
que constituyen.
En GOBSTONES puede existir una herramienta de chequeo basada en un siste-
ma de tipos. De hecho, las implementaciones actuales de las herramientas que
implementan GOBSTONES (como PYGOBSTONES), poseen esta opci ´on. Volvere-
mos sobre este tema en el cap´ıtulo 3.
Repasemos la idea de un programa, antes de ver c ´omo ejecutarlo. Un progra-
ma es un bloque especial, identificado con la palabra reservada program. Pode-
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 51 of 312 --

52
mos entonces refinar la definici ´on general que vimos en definici ´on 2.2.5, usando
la forma que vimos para el comando Poner.
Definici ´on 2.2.10. Un programa tiene la forma
program
< bloque >
siendo < bloque > un bloque cualquiera.
Para poder ejecutar un programa debemos utilizar alguna herramienta que nos
permita interpretarlo y realice las acciones correspondientes.
Leer con Atenci ´on
Para poder ejecutar un programa GOBSTONES debe tipearlo en un ar-
chivo de texto (sin formato), e indicarle adecuadamente a la herramienta
que ejecute el programa de ese archivo. Dado que pueden existir dife-
rentes herramientas, y diferentes formas dentro de la misma herramienta
para relizar esta tarea, no daremos detalles de operaci ´on de ninguna de
ellas como parte integral del texto. En el anexo A se pueden encontrar
detalles de c ´omo obtener y utilizar una de tales herramientas.
Al volcar el programa escrito en papel en la computadora, sin embargo, la pre-
cisi ´on es fundamental, porque si no escribimos la forma exacta, la m ´aquina fa-
llar ´a en reconocer el programa. Estos errores cometidos al escribir un programa
en la computadora se conocen como errores de sintaxis, y tienen que ver con la
Este tipo de errores es similar
a las faltas de ortograf´ıa y de
gram ´atica cometidas al escribir
en castellano, con la diferencia
de que la m ´aquina no analiza
nuestra intenciones como har´ıa
un lector humano.
rigidez que mencionamos en secciones anteriores. Por ejemplo, no es lo mismo
escribir program que porgram o programa. El primero ser ´a reconocido adecuada-
mente por la m ´aquina, pero, por tratarse de procesos autom ´aticos, es mucho m ´as
complejo que la m ´aquina reconozca que nuestra intenci ´on al escribir porgram fue
realmente la de escribir program (aunque en los casos m ´as simples esto sea fac-
tible, en casos m ´as complicados es pr ´acticamente infinita la cantidad de posibles
interpretaciones).
Leer con Atenci ´on
Cada herramienta dar ´a un mensaje de error diferente cuando encuentre
c ´odigo que no sigue las reglas precisas de sintaxis. La interpretaci ´on de
este mensaje de error puede resultar m ´as o menos compleja. La com-
prensi ´on de los errores que aparecen requiere experiencia con una he-
rramienta en particular, pues los mensajes var´ıan dr ´asticamente de una
a otra, e incluso de una versi ´on a otra de la misma herramienta. Uno de
los puntos m ´as frustrantes al aprender a programar es justamente
la interpretaci ´on de mensajes de error. Esto sucede porque los que
programan los mensajes de error presuponen que el programador sabe
de antemano lo que el mensaje indica, aunque en realidad el estudiante
puede a ´un no haber aprendido los conceptos para comprenderlo.
La sugerencia general al enfrentar errores de sintaxis en una herramienta es ob-
servar en qu ´e punto del programa se informa el error, y revisar por la precisi ´on de
lo que se escribi ´o, recordando todas las reglas vistas. Es una tarea extremada-
mente tediosa al principio, pero debe serse paciente y persistente, pues con un
poco de pr ´actica, es relativamente simple descubrir los errores m ´as obvios de un
vistazo. La raz ´on por la que pusimos tanto ´enfasis al comienzo en la precisi ´on, y
la raz ´on por la cual volvemos a remarcarlo ac ´a, es justamente que la mayor cau-
sa de fracasos en los intentos de aprender a programar vienen de la diferencia en
dificultad entre pensar y escribir un programa para nosotros mismos pensando el
problema que deseamos resolver (en papel, por ejemplo) y construirlo correcta-
mente para que deba ser ejecutado por computadora.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 52 of 312 --

53
G.2.8. Texto correcto del programa GOBSTONES del ejercicio 2.2.1
Actividad de Programaci ´on 3
Realizar el ejercicio 2.2.1. Por ser el primer ejercicio, la parte de escribir-
lo en papel ya fue realizada por nosotros. Por lo tanto, debe pasarlo en
la computadora y ejecutarlo, para lo cual deber ´a instalar antes la herra-
mienta, como se describen en el anexo A.
Ejercicio 2.2.1. Cargar en la herramienta, y ejecutar, el programa GOBSTONES
dado antes, que deposita dos bolitas verdes en la celda actual. ¿Qu ´e puede
concluirse acerca del estado del tablero al iniciar la ejecuci ´on del programa? ¿Y
al finalizar la misma?
Recuerde escribir exactamente el c ´odigo como fuera mostrado. Su editor de tex-
tos deber´ıa verse como en el gr ´afico G.2.8. Si todo sali ´o de la manera esperada,
habr ´a obtenido un tablero final que en la celda actual tiene dos bolitas verdes
m ´as que el tablero inicial. Seg ´un la herramienta que est ´e utilizando, la forma de
visualizar este hecho puede variar. Pero en todos los casos sabemos que hay un
tablero inicial con dos bolitas verdes menos que el tablero final.
El estado del tablero es el conjunto de caracter´ısticas que lo conforman: su
tama ˜no, la ubicaci ´on del cabezal y si hay o no bolitas, y en qu ´e celdas. Es impor-
tante observar que todo lo que interesa de un programa GOBSTONES es el efecto
que produce sobre el estado del tablero, o sea, los cambios que se realizar ´an
sobre el mismo. Es por ello importante tener idea del estado inicial del tablero.
Sin embargo, al escribir un programa GOBSTONES, no deber´ıa hacerse ninguna
suposici ´on acerca de este estado inicial. Cada herramienta es libre de usar como
estado inicial uno cualquiera, e incluso podr´ıa ser que el estado inicial variase de
una ejecuci ´on a otra.
Definici ´on 2.2.11. El efecto de un programa GOBSTONES es el conjunto de cam-
bios que produce sobre el tablero inicial. No debe suponerse ning ´un estado inicial
particular si se desea que el programa sea independiente de la herramienta.
Antes de pasar a realizar ejercicios donde usted escriba sus propios programas
para solucionar tareas sencillas, veremos un ejercicio m ´as, con el fin de trabajar
sobre la noci ´on de error.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 53 of 312 --

54
G.2.9. Texto “correcto” del programa GOBSTONES del ejercicio 2.2.2, al comenzar
el ejercicio
Actividad de Programaci ´on 4
Realice el ejercicio 2.2.2. Recuerde ser paciente y persistente con los
mensajes de error, incluso aunque al principio la tarea pueda resultar
algo frustrante.
Ejercicio 2.2.2. Escribir el siguiente programa GOBSTONES y ejecutarlo.
programa
{ poner(Roja) }
Observar el mensaje de error que se produce, y corregir los errores hasta que el
programa resulte ejecutable.
Recuerde que al escribirlo en la herramienta, el programa debe aparecer exac-
tamente como lo escribimos. El editor de texto deber´ıa verse como en el gr ´afi-
co G.2.9.
El informe de los errores en la herramienta PYGOBSTONES es razonablemen-
te adecuado para un novato. Sin embargo, no hay que confiar en que la herra-
mienta detecte siempre nuestras intenciones. Los errores aparecen siempre en
los programas, ya sea por descuidos, suposiciones incorrectas o conocimientos
insuficientes, y la ´unica manera de encontrarlos y eliminarlos es aprender a inter-
pretar mensajes de error. En todos los ejercicios posteriores no nos ser ´a posible
mostrar la forma exacta en la que debe verse el editor, pues habr ´a cientos de
opciones correctas – ¡y cientos de miles de opciones incorrectas! Por eso es tan
importante que aprenda a manejar sus errores.
Ahora s´ı, podemos realizar el primer ejercicio completo de programaci ´on.
Actividad de Programaci ´on 5
Realizar el ejercicio 2.2.3. Recuerde que para poder realizarlo, debe pri-
mero escribirlo en papel, y luego pasarlo en la computadora y ejecutarlo.
Ejercicio 2.2.3. Escribir un programa GOBSTONES que deposite una bolita ver-
de, dos rojas, tres azules y cuatro negras en la celda actual, y ejecutarlo.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 54 of 312 --

55
Cuando ya se adquiere cierta pr ´actica, la etapa de escribir en papel suele omitirse
para los programas m ´as simples. Sin embargo, incluso los programadores m ´as
experimentados tomamos una hoja de papel para empezar a organizar nuestras
ideas antes de usar la computadora.
Para Reflexionar
Revise todo lo le´ıdo hasta el momento, e intente identificar cu ´ales son las
actividades importantes al pensar sobre el papel, y cu ´ales al escribir el
c ´odigo en la computadora para ejecutarlo. Relacione esto con la defini-
ci ´on de programa dada, y observe qu ´e cosas tienen que ver con la parte
de los programas en cuanto descripciones y qu ´e cosas con la parte en
cuanto descripciones ejecutables. La tarea del programador comienza
por pensar lo que quiere describir, y luego darle forma ejecutable. . .
2.2.7. M ´as comandos simples
¿Qu ´e otras ´ordenes elementales se le pueden dar al cabezal? As´ı como existe
una forma de describir la acci ´on del cabezal de poner una bolita en la celda
actual, existe la acci ´on opuesta, de sacarla. El comando Sacar(Verde) saca una
bolita verde de la celda actual, si hay alguna.
La forma general del comando Sacar es similar a la de Poner, y est ´a dada por
la siguiente definici ´on.
Definici ´on 2.2.12. El comando Sacar(< color > ) indica al cabezal que quite una
No olvidar que esto siginifica un
color en particular, y no la pala-
bra color. . .
bolita del color < color > de la celda actual, si hay alguna.
Debe observarse que el cabezal solo puede realizar una acci ´on de Sacar si se
cumplen ciertos requisitos. Dado que el cabezal no es m ´as que una m ´aquina, y
bastante limitada, no tiene ninguna manera de saber qu ´e hacer cuando la des-
cripci ´on para la acci ´on a realizar no incluya alguna situaci ´on. Si bien las perso-
nas ante tal situaci ´on podemos tomar decisiones, las computadoras no pueden.
Cuando el cabezal recibe una orden que no puede ejecutar, toma una acci ´on
dr ´astica: se autodestruye, y con ´el al tablero y todas las bolitas. Esto puede pa-
recer exagerado para una persona, que siempre tiene otros cursos de acci ´on para
considerar, pero no lo es para una m ´aquina, al menos no para una tan simple.
Cuando un comando describe una acci ´on que puede provocar la autodestrucci ´on
del cabezal en caso de que ciertos requisitos no se cumplan, se dice que tal co-
mando describe una operaci ´on parcial, pues solo describe parcialmente la acci ´on
a realizar. Si en cambio la descripci ´on conlleva una acci ´on que siempre puede
realizarse, se dice que es una operaci ´on total. Al requisito que debe cumplirse
antes de intentar ejecutar una operaci ´on parcial para estar seguro que la misma
no falla se la denomina precondici ´on de la operaci ´on. De esta manera, Poner es
una operaci ´on total, y Sacar es una operaci ´on parcial y su precondici ´on es que
haya una bolita del color indicado en la celda actual.
Definici ´on 2.2.13. Una operaci ´on total es la descripci ´on de una acci ´on que, al
no tener requisitos para que el cabezal pueda llevarla a cabo, siempre puede ser
realizada.
Definici ´on 2.2.14. Una operaci ´on parcial es la descripci ´on de una acci ´on que
precisa que ciertos requisitos se cumplan para que el cabezal pueda llevarla a
cabo, y que en caso de que los mismos no se cumplan, provoca la autodestruc-
ci ´on del cabezal y todos los elementos.
Definici ´on 2.2.15. La precondici ´on de una operaci ´on parcial expresa los requi-
sitos que deben cumplirse para que la ejecuci ´on de la acci ´on indicada por la
operaci ´on pueda ser llevada a cabo sin provocar la autodestrucci ´on del cabezal.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 55 of 312 --

56
De aqu´ı en m ´as, al presentar nuevos comandos, se establecer ´a si los mismos
describen operaciones totales o parciales, y en caso de que sean parciales,
cu ´ales son sus precondiciones. En el caso de operaciones parciales, normalmen-
te se indicar ´a solamente la acci ´on descrita por el comando en el caso en que la
precondici ´on sea verdadera. Por ejemplo, diremos que Sacar saca una bolita de
Recordar que los comandos
describen acciones y no que
hacen acciones. Tener en cuen-
ta este abuso del lenguaje al leer
el resto del libro.
la celda actual; si la bolita no existiese, la precondici ´on ser´ıa falsa y por lo tanto tal
situaci ´on no se indica. En algunos casos, podremos hacer la salvedad aclarando
la precondici ´on en la acci ´on: Sacar saca una bolita de la celda actual, si existe.
Actividad de Programaci ´on 6
Realizar los ejercicios 2.2.4 y 2.2.5. Observe que si en el estado inicial
del tablero ya hab´ıa bolitas, el programa del ejercicio 2.2.4 no fallar ´a.
Pruebe con un tablero que no tenga bolitas en la celda actual.
Ejercicio 2.2.4. Escribir un programa Gobstones que saque una bolita de la cel-
da actual sin que haya ninguna, y comprobar la forma en que se manifiesta la
autodestrucci ´on del cabezal, el tablero y los otros elementos.
Ejercicio 2.2.5. Escribir un programa Gobstones que saque una bolita de la cel-
da actual, pero que no produzca la autodestrucci ´on del cabezal. ¿C ´omo se puede
asegurar que la precondici ´on del comando Sacar se cumpla? Piense solo en los
elementos presentados hasta el momento. . .
Toda vez que se utiliza una operaci ´on parcial, hay que tomar una de dos medidas:
o bien se busca garantizar la precondici ´on de la misma de alguna manera (como
en el ejercicio 2.2.5) o bien se trasladan los requerimientos de dicha operaci ´on a
la operaci ´on que se est ´a definiendo. Veremos esto con cuidado m ´as adelante.
Para Reflexionar
Los errores en los programas de computadora son algo que sufrimos
cotidianamente. Basta pensar en las veces que escuchamos “se cay ´o el
sistema”. Es responsabilidad de los programadores programar de mane-
ra que la cantidad de errores sea m´ınima. Las precondiciones son uno de
los mecanismos m ´as ´utiles para lograr esto. Reflexionar sobre la impor-
tancia de aprender a programar de manera adecuada, y sobre lo simple
que resulta programar sin tener estas cosas en cuenta. Relacionarlo con
el estado de situaci ´on de los programas que conoce.
Otro comando que describe una operaci ´on parcial es el que permite al cabezal
moverse por el tablero. Esta operaci ´on es b ´asica para poder operar en m ´as de
una celda. El comando Mover(Norte) describe la acci ´on de que el cabezal se
debe desplazar una celda hacia el norte, si hay alguna celda en esa direcci ´on. El
formato general est ´a dado por esta definici ´on
Definici ´on 2.2.16. El comando Mover(< dir >) indica al cabezal que debe mo-
verse una celda en la direcci ´on < dir >, si es posible.
Las direcciones posibles (los valores que puede tomar < dir >) son Norte, Sur,
Este y Oeste.
Definici ´on 2.2.17. Los valores posibles para una direcci ´on son Norte, Sur, Este
y Oeste.
Como se mencion ´o, Mover es una operaci ´on parcial. Su parcialidad est ´a dada
por el hecho de que el tablero es finito, y por lo tanto hay celdas que no tienen
celda vecina en algunas direcciones. Por ejemplo, la celda de la esquina inferior
izquierda del tablero no tiene celdas ni al Sur ni al Oeste, y es la ´unica celda
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 56 of 312 --

57
Comando Precondici ´on Acci ´on descrita
Poner(< color >) Ninguna
(operaci ´on total)
Pone una bolita del color indica-
do en la celda actual
Sacar(< color >)
Que exista una boli-
ta del color indicado
en la celda actual
Saca una bolita del color indica-
do de la celda actual
Mover(< dir >)
Que exista una cel-
da en la direcci ´on
indicada
Mueve el cabezal una celda en
la direcci ´on indicada respecto
de la celda actual
IrAlBorde(< dir >) Ninguna
(operaci ´on total)
Mueve el cabezal al borde indi-
cado del tablero, en la misma fila
o columna
VaciarTablero() Ninguna
(operaci ´on total)
Elimina todas las bolitas del
tablero
T.2.1. Sumario de los comandos b ´asicos conocidos hasta el momento
con esta caracter´ıstica. Observar que dado que el tama ˜no del tablero no se co-
noce a priori, puede ser que un programa que no controle adecuadamente sus
movimientos provoque la autodestrucci ´on del cabezal. Por ejemplo, el programa
program
{ Mover(Sur); Mover(Oeste) }
tiene como precondici ´on comenzar su ejecuci ´on en cualquier celda que no se
encuentre en la fila de m ´as al sur, ni en la columna de m ´as al oeste. En caso
que la ejecuci ´on del programa arranque en una de dichas celdas, provocar ´a la
autodestrucci ´on del cabezal.
Puesto que la posici ´on inicial del cabezal es desconocida, es ´util contar con el
comando IrAlBorde. Este comando, cuya forma es IrAlBorde(< dir >), describe
una operaci ´on total cuyo efecto es posicionar en el borde del tablero indicado, en
la misma fila o columna en que se encuentra originalmente. Posteriormente, en
el cap´ıtulo 4 se ver ´an las herramientas necesarias para que este comando pueda
ser reemplazado por un procedimento equivalente definido por el programador.
Definici ´on 2.2.18. El comando IrAlBorde(< dir >) indica al cabezal que se po-
sicione en el borde del tablero indicado por la direcci ´on < dir >, en la misma fila o
No olvidar que esto siginifica una
direcci ´on en particular, y no la
palabra dir. . .
columna en que se encontraba.
Asimismo, y puesto que el contenido de las celdas es arbitrario al iniciar, es ´util
contar con el comando VaciarTablero. Este comando, cuya forma es simple-
mente VaciarTablero(), describe una operaci ´on total cuyo efecto es eliminar
la totalidad de las bolitas del tablero, sin alterar la posici ´on del cabezal. Al igual
que el comando IrAlBorde, el comando VaciarTablero puede ser reemplazado
por un procedimiento definido por el programador, aunque para ello se requiere
conocer casi la totalidad de elementos que posee el lenguaje.
Definici ´on 2.2.19. El comando VaciarTablero() indica al cabezal que quite to-
das las bolitas del tablero, dejando un tablero final vac´ıo.
En este punto, es bueno hacer un peque ˜no repaso de los comandos vistos hasta
el momento, y sus caracter´ısticas. Esto se puede encontrar en la tabla T.2.1.
Estos comandos pueden ser combinados mediante secuenciaci ´on, agrupados
en bloques, utilizados en un programa y, como veremos en breve, usados en
definiciones de procedimientos que determinar ´an nuevos comandos, definidos
por el programador.
Es el momento de comenzar a escribir algunos programas m ´as interesantes.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 57 of 312 --

58
2.2.8. Procedimientos simples
Combinando las operaciones de Mover y Poner se pueden simular “dibujos” utili-
zando las bolitas como colores. Por ejemplo, ¿c ´omo podemos decir la tarea que
lleva a cabo el siguiente programa?
program
{
Mover(Norte); Poner(Negro); Mover(Norte); Poner(Negro)
Mover(Este); Poner(Negro); Mover(Este); Poner(Negro)
Mover(Sur); Poner(Negro); Mover(Sur); Poner(Negro)
Mover(Oeste); Poner(Negro); Mover(Oeste); Poner(Negro)
}
En lugar de decir que pone 8 bolitas negras en diferentes lugares, es m ´as f ´acil
decir que dibuja un peque ˜no cuadrado negro de tres celdas de lado.
Recordar que en realidad ser´ıa
correcto decir que el programa
describe la tarea de dibujar un
cuadrado negro.
Actividad de Programaci ´on 7
Realizar el ejercicio 2.2.6. Probarlo varias veces, con el cabezal en distin-
tas posiciones, y comprobar que este programa describe una operaci ´on
parcial.
Ejercicio 2.2.6. Ejecutar el programa Gobstones dado antes, y comprobar que
dibuja el cuadrado. ¿Cu ´al es la precondici ´on de este programa?
Leer con Atenci ´on
Si bien GOBSTONES no es un lenguaje para expresar dibujos, y el tablero
no es un papel o una pantalla, podemos interpretar el problema de “dibu-
jar un cuadrado” en t ´erminos del tablero y bolitas. Esta interpretaci ´on es
una de las maneras fundamentales de representar cosas en los lengua-
jes de programaci ´on: se utilizan ciertos elementos, pero se entienden
como si se tratase de otros elementos.
Entonces, a trav ´es de algunos dibujos bien coordinados podemos ver ventanas,
botones y otros elementos abstractos en una pantalla de computadora, aunque
Para los que conocen la pel´ıcu-
la “Matrix”, en programaci ´on so-
lemos decir que debemos “tratar
de entender la verdad. . . la cu-
chara no existe. . . ” y ese es el
primer paso para poder doblarla.
solo se trate de puntitos de luz que los programadores podemos controlar. Al
enunciar ejercicios haremos uso intuitivo de esta forma de interpretaci ´on. En la
secci ´on 2.3 profundizaremos un poco la idea de representar informaci ´on en t ´ermi-
nos de los elementos presentes en el universo de discurso de un lenguaje.
Ahora supongamos que queremos dibujar 2 cuadrados, uno a la izquierda (al
Oeste) del tablero y otro a la derecha (al Este), ambos lo m ´as abajo posible (al
Sur). Con los elementos que tenemos hasta ahora es posible hacerlo, resultando
en el siguiente c ´odigo:
program
{
VaciarTablero()
IrAlBorde(Sur); IrAlBorde(Oeste)
Mover(Norte); Poner(Negro); Mover(Norte); Poner(Negro)
Mover(Este); Poner(Negro); Mover(Este); Poner(Negro)
Mover(Sur); Poner(Negro); Mover(Sur); Poner(Negro)
Mover(Oeste); Poner(Negro); Mover(Oeste); Poner(Negro)
IrAlBorde(Este); Mover(Oeste); Mover(Oeste)
Mover(Norte); Poner(Negro); Mover(Norte); Poner(Negro)
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 58 of 312 --

59
G.2.10. Resultado de ejecutar el programa dado como ejemplo
Mover(Este); Poner(Negro); Mover(Este); Poner(Negro)
Mover(Sur); Poner(Negro); Mover(Sur); Poner(Negro)
Mover(Oeste); Poner(Negro); Mover(Oeste); Poner(Negro)
}
El resultado de ejecutar este programa dar ´a un tablero final como el de la gr ´afi-
co G.2.10 (el tama ˜no del tablero puede variar en funci ´on de la herramienta, y
en caso de ser un tablero demasiado chico, puede que la ejecuci ´on falle, pro-
duciendo la autodestrucci ´on del cabezal). Ahora, analicemos el c ´odigo. Primero
podemos observar que se indica vaciar el tablero; luego que se indica posicionar
el cabezal en la celda m ´as al sur y el oeste (el origen del tablero), y luego que
est ´a el c ´odigo que hab´ıamos usado antes para dibujar el cuadrado negro de lado
3; finalmente se vuelve a posicionar el cabezal cerca de la esquina sureste, y
se vuelve a repetir el c ´odigo de dibujar el cuadrado. Sin embargo, ese an ´alisis
requiere de una cuidadosa lectura, puesto que el programa tiene ¡38 comandos
primitivos! Y solo estamos dibujando un par de cuadrados. . .
Ser´ıa mucho m ´as f ´acil si el lenguaje GOBSTONES ya tuviese un comando
primitivo DibujarCuadradoNegroDeLado3(). Solo tendr´ıamos que escribir:
program
{
VaciarTablero()
IrAlBorde(Sur); IrAlBorde(Oeste)
DibujarCuadradoNegroDeLado3()
IrAlBorde(Este); Mover(Oeste); Mover(Oeste)
DibujarCuadradoNegroDeLado3()
}
¡Sin embargo, no es posible pedir que el lenguaje traiga predefinidos todos los
comandos que se nos puedan ocurrir! Lo que s´ı podemos pedirle al lenguaje es
un mecanismo por el cual podamos definir nuestros propios comandos. La idea
es escribir algo como
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 59 of 312 --

60
‘‘definir comando’’ DibujarCuadradoNegroDeLado3() ‘‘como’’
{
Mover(Norte); Poner(Negro); Mover(Norte); Poner(Negro)
Mover(Este); Poner(Negro); Mover(Este); Poner(Negro)
Mover(Sur); Poner(Negro); Mover(Sur); Poner(Negro)
Mover(Oeste); Poner(Negro); Mover(Oeste); Poner(Negro)
}
para que el lenguaje use esas 16 instrucciones de Mover y Poner cada vez que
alguien use el comando DibujarCuadradoNegroDeLado3(), y entonces el proble-
ma estar´ıa resuelto.
La herramienta que se utiliza para este tipo de definici ´on es un procedimiento.
B ´asicamente, un procedimiento simple es un comando definido por el programa-
dor, o sea, un comando nuevo, resultante de la combinaci ´on de otros coman-
dos m ´as elementales. La manera de definir un comando es, entonces, decla-
rar la existencia de un nuevo procedimiento, para lo cual hay que indicar cu ´al
es el nombre que se usar ´a para este nuevo procedimiento, y cu ´al es el efec-
to que describir ´a (el significado del nuevo comando). Este significado se define
a trav ´es de alguna combinaci ´on de comandos m ´as elementales, ya existentes
(primitivos, o declarados previamente). La declaraci ´on de un procedimiento se
indica con la palabra reservada procedure, y entonces para declarar el comando
DibujarCuadradoNegroDeLado3() debe escribirse:
procedure DibujarCuadradoNegroDeLado3()
{
Mover(Norte); Poner(Negro); Mover(Norte); Poner(Negro)
Mover(Este); Poner(Negro); Mover(Este); Poner(Negro)
Mover(Sur); Poner(Negro); Mover(Sur); Poner(Negro)
Mover(Oeste); Poner(Negro); Mover(Oeste); Poner(Negro)
}
Las llaves que delimitan el bloque que se coloca luego del nombre del nuevo
procedimiento determinan cu ´ales son los comandos elementales que ser ´an eje-
cutados cuando el cabezal trate de ejecutar DibujarCuadradoNegroDeLado3().
Dicho de otra manera, el comando DibujarCuadradoNegroDeLado3() es simple-
mente otra forma de nombrar a la combinaci ´on dada por esos 16 Mover y Poner.
Identificadores
Para nombrar elementos del lenguaje se utiliza una forma especial de nombres,
llamados identificadores. Un identificador es un grupo de letras sin interrupciones
(o sea, no contiene espacios ni signos de puntuaci ´on).
Definici ´on 2.2.20. Un identificador es un nombre conformado exclusivamente
por letras (may ´usculas o min ´usculas) o n ´umeros, que se utiliza para denotar (o
identificar o referise a) alg ´un elemento.
La idea de identificador es mayor que la idea de palabra a la que estamos acos-
tumbrados en castellano. En la siguiente lista de ejemplos de identificadores,
pueden observarse letras, palabras y combinaciones diversas, todas las cuales
constituyen identificadores, pues son cadenas de letras sin separaci ´on.
1. x
2. sumar