# 1. Introducción

1.1. La programación
La programación es un proceso por el que se escribe, se prueba, se depura y se
modifica el código. Los programas como elementos que forman el software son
un conjunto de instrucciones que se ejecutan en el hardware con el objetivo
de realizar una tarea determinada.
Para el desarrollo de programas de cierta envergadura o complejos, con ciertas
garantías de calidad, es conveniente seguir alguno de los modelos de desarrollo
de software existentes, en los que la programación es sólo una de las etapas
del proceso de desarrollo del software.
Un programa es un conjunto de instrucciones que se ejecutan con el
objetivo de resolver un cierto problema. Los programas se componen
en varios algoritmos, y cada uno de éstos resuelve una parte del proble-
ma inicial. De esta manera, la complejidad de cada una de las partes es
menor que la del programa completo (esta técnica es conocida como
"divide y vencerás").
Según Niklaus Wirth, un programa está formado por algoritmos y una estruc-
tura de datos.
Niklaus Wirth (Winterthur, 1934)
Doctorado en 1963 en Berkeley, de 1963 a 1967 fue profesor de Informática en Stanford
y en la Universidad de Zúrich. A partir de 1968, pasó a ser profesor de Informática en la
ETH de Suiza y se tomó dos años sabáticos en la Xerox PARC de California.
Fue el jefe de diseño de los lenguajes de programación Euler, Algol W, Pascal, Modula,
Modula-2 y Oyeron, y ocupó gran parte de su tiempo en el equipo de diseño e imple-
mentación de sistemas operativos Lilith y Oberon para el Lola en el diseño del hardware
digital y el sistema de simulación.
Su artículo de desarrollo de un programa por refinamiento sucesivo ("Program Develop-
ment by Stepwise Refinement") es considerado un texto clásico en la ingeniería del soft-
ware, así como su libro Algoritmos + Estructuras de datos = Programas, que recibió un am-
plio reconocimiento, y que aún hoy es útil en la enseñanza de la programación. Recibió
el Premio Turing por el desarrollo de estos lenguajes de programación en 1984.
La programación tiene como uno de sus principales objetivos la creación de
software de calidad, y los principales factores que indican el nivel￿de￿calidad
de￿un￿programa son los siguientes:

-- 5 of 44 --

CC-BY-NC-ND • PID_00220485 6 Introducción a la programación orientada a objetos
1)￿Corrección: un programa es correcto si hace lo que debe hacer tal y como
se estableció. Para determinar si un programa actúa correctamente es muy im-
portante disponer de una especificación de lo que debe resolver el programa
antes de desarrollarlo, de esta manera, una vez implementado se ha de com-
probar que realmente lo implementa.
2)￿Claridad: es fundamental que el código sea lo más claro y legible posible,
para facilitar así su desarrollo y posterior mantenimiento. Se debe intentar que
su estructura sea sencilla y coherente, así como cuidar el estilo en la edición;
de esta manera, se facilita el trabajo del programador, tanto en la fase de crea-
ción como en las fases posteriores de corrección de errores, ampliaciones, mo-
dificaciones, etc. Fases que pueden ser realizadas incluso por otro programa-
dor, con lo que la claridad es aún más necesaria para que otros programadores
puedan continuar el trabajo fácilmente.
3)￿Eficiencia: además de realizar aquello para lo que fue creado, debe realizarlo
minimizando los recursos que utiliza. La eficiencia se basa en el tiempo que
tarda en realizar la tarea para la que ha sido creado y a la cantidad de memoria
que necesita. Hay otros recursos que también deben ser considerados: espacio
en disco que utiliza, tráfico de red que genera, etc.
4)￿Portabilidad: se basa en la capacidad de poder ejecutarse en una platafor-
ma, ya sea hardware o software, diferente a aquélla en la que se elaboró. La
portabilidad es una característica muy deseable para un programa, ya que per-
mite, por ejemplo, a un programa que se ha desarrollado para sistemas GNU/
Linux ejecutarse también en la familia de sistemas operativos Windows, in-
cluso en distintas máquinas virtuales de Java o en los distintos navegadores
que existen en el mercado.
1.2. Modelos de desarrollo
Se entiende como modelos de desarrollo o paradigmas de programación a los
distintos enfoques o filosofías que se han ido creando para la construcción del
software. No existe un modelo mejor que otro, sino que, dependiendo del tipo
de problema, un modelo puede ser más apropiado que otro.
Los modelos de desarrollo más comunes son los siguientes:
• Programación imperativa.
• Programación funcional.
• Programación lógica.
• Programación orientada a objetos.

-- 6 of 44 --

CC-BY-NC-ND • PID_00220485 7 Introducción a la programación orientada a objetos
1.2.1. Programación imperativa
La programación imperativa se basa en un conjunto de instrucciones
que le indican al hardware cómo debe realizar una tarea. Está conside-
rada la más común y la representan, por ejemplo, lenguajes como C o
BASIC.
El hardware está diseñado para ejecutar código de máquina, escrito en una
forma imperativa y secuencial. Desde esta perspectiva de bajo nivel, las sen-
tencias son instrucciones en el lenguaje de máquina nativo del computador
(por ejemplo, el lenguaje ensamblador).
Los primeros lenguajes imperativos fueron los lenguajes ensamblador, que es-
tán condicionados por el hardware que los debía implementar. En estos len-
guajes, las instrucciones fueron muy simples, lo que provocó la implementa-
ción de hardware fácil, pero obstruyó la creación de programas complejos.
Fortran, cuyo desarrollo fue iniciado en 1954 por John Backus en IBM, fue el
primer gran lenguaje de programación que superó los obstáculos presentados
por el código máquina en la creación de programas complejos.
Los siguientes lenguajes implementan la programación imperativa: BASIC, C,
C#, C++, Fortran, Pascal, Java, Perl, PHP.
John Backus (Filadelfia, 1924-Oregón, 2007)
Informático estadounidense. John Backus ganó el Premio Turing en 1977 por sus trabajos
en sistemas de programación de alto nivel, en especial por su trabajo con FORTRAN.
Para evitar las dificultades de programación de las calculadoras de su época, en 1954
Backus se encargó de la dirección de un proyecto de investigación en IBM para el proyecto
y realización de un lenguaje de programación más cercano a la notación matemática
normal. De ese proyecto surgió el lenguaje FORTRAN, el primero de los lenguajes de
programación de alto nivel que tuvo un gran impacto, incluso comercial, en la emergente
comunidad informática.
Tras la realización de FORTRAN, Backus fue un miembro muy activo del comité interna-
cional que se encargó del proyecto de lenguaje ALGOL. En ese contexto propuso una no-
tación para la representación de las gramáticas usadas en la definición de un lenguaje de
programación (las llamadas gramáticas libres de contexto). Tal notación se conoce como
BNF, o Forma de Naur y Backus (Backus-Naur Form), y une el nombre de Backus al de
Peter Naur, un informático europeo del comité ALGOL que contribuyó a su definición.
En la década de los setenta, Backus se interesó sobre todo por la programación funcional,
y proyectó el lenguaje de programación FP, descrito en el texto que le sirvió para ganar
el Premio Turing: "Can Programming be Liberated from the Von Neumann Style?". Se
trata de un lenguaje de uso fundamentalmente académico que, sin embargo, animó un
gran número de investigaciones. El proyecto FP, transformado en FL, se terminó cuando
Backus se jubiló en IBM, en 1991.
Fuente: Wikipedia.

-- 7 of 44 --

CC-BY-NC-ND • PID_00220485 8 Introducción a la programación orientada a objetos
1.2.2. Programación funcional
La programación funcional es un paradigma de programación que se
basa en la utilización de funciones matemáticas. El máximo represen-
tante de este paradigma es el lenguaje LISP.
El objetivo es conseguir lenguajes expresivos y matemáticamente elegantes,
en los que no sea necesario bajar al nivel de la máquina para describir el pro-
ceso llevado a cabo por el programa. Los programas están constituidos úni-
camente por definiciones de funciones, entendiendo éstas no como subpro-
gramas clásicos de un lenguaje imperativo, sino como funciones puramente
matemáticas.
Otras características propias de estos lenguajes son la no existencia de asigna-
ciones de variables y la falta de construcciones estructuradas como la secuen-
cia o la iteración, lo que obliga en la práctica a que todas las repeticiones de
instrucciones se lleven a cabo por medio de funciones recursivas.
Existen dos grandes categorías de lenguajes funcionales: los funcionales￿pu-
ros (Haskell y Miranda) y los híbridos (Scala, Lisp, Scheme, Ocaml, SAP y Stan-
dard ML). La diferencia entre ambos estriba en que los lenguajes funcionales
híbridos son menos rígidos que los puros, ya que admiten conceptos de los
lenguajes imperativos, como las secuencias de instrucciones o la asignación
de variables.
Se podría incluir a Perl como lenguaje funcional híbrido, ya que aunque es
un lenguaje de propósito general, se pueden implementar programas usando
exclusivamente funciones definidas por el usuario.
1.2.3. Programación lógica
Generalmente, en los lenguajes de programación imperativos, cuando nos en-
frentamos a un problema complejo, la implementación de la solución de éste
puede ocultar o dificultar su comprensión. En este sentido, la lógica matemá-
tica es la manera más sencilla de expresar formalmente problemas complejos
y de resolverlos mediante la aplicación de reglas, hipótesis y teoremas.
La programación lógica encuentra su hábitat natural en aplicaciones de inte-
ligencia artificial, por ejemplo:
• Sistemas expertos, en los que el programa imita las recomendaciones de
un experto sobre algún dominio de conocimiento.
• Demostración automática de teoremas. En este caso el programa genera
nuevos teoremas sobre una teoría existente.

-- 8 of 44 --

CC-BY-NC-ND • PID_00220485 9 Introducción a la programación orientada a objetos
• Reconocimiento de lenguaje natural. El programa es capaz de comprender
(con limitaciones) la información contenida en una expresión lingüística
humana.
El principal lenguaje de programación lógica es Prolog.
1.2.4. Programación orientada a objetos
La programación orientada a objetos tiene su origen en el lenguaje Simula
67, creado por Ole-Johan Dahl y Kristen Nygaard en el Centro de Cómputo
Noruego de Oslo.
El objetivo del lenguaje era la implementación de simulaciones de naves de
manera simple y más óptima. Pensaron en agrupar los distintos tipos de naves
en varias clases de objetos, considerando cada clase de objetos como respon-
sable de definir sus propios datos y comportamiento.
Ole-Johan Dahl (Mandal, 1931-2002)
Es uno de los científicos de la computación más famosos en Noruega. Junto con Kristen
Nygaard, Ole-Johan Dahl produjo las primeras ideas sobre programación orientada a ob-
jetos en los años sesenta en el Centro Noruego de Cómputo (NCC), como parte de los len-
guajes de programación para simulación Simula I (1961-1965) y Simula 67 (1965-1968).
Dahl y Nygaard fueron los primeros en desarrollar los conceptos de objeto, clase, heren-
cia, creación dinámica de objetos, etc., todos aspectos importantes del paradigma de la
OO.
Dahl logró plaza de profesor en la Universidad de Oslo en 1968, en la que destacó como
un privilegiado educador e investigador. Allí trabajó en Estructuras Jerárquicas de Progra-
mas, probablemente su publicación más influyente, escrita junto con C. A. R. Hoare y
Edsger Dijkstra en el famoso libro Structured Programming de 1972, quizá el libro sobre
software más conocido de esa década.
Al avanzar su carrera, Dahl se interesó en el uso de métodos formales, por ejemplo pa-
ra razonar rigurosamente sobre orientación a objetos. Como todo buen científico de la
computación, su experiencia alcanzaba desde la aplicación práctica de sus ideas a la de-
mostración matemática de su corrección para asegurar la validez de su enfoque. Recibió
el Premio Turing por su trabajo en el 2001, un año antes de fallecer.
Fuente: Wikipedia.
Kristen Nygaard (1926-2002)
Fue un matemático noruego, pionero de la informática y político. Kristen Nygaard ob-
tuvo el título de máster de matemáticas en la Universidad de Oslo en 1956. Su tesis so-
bre teoría de probabilidad abstracta se tituló "Theoretical Aspects of Monte Carlo Met-
hods" ("Aspectos teóricos de los métodos de Montecarlo"). Entre 1948 y 1960, Nygaard
desarrolló varias tareas en el Departamento de Defensa noruego, incluyendo labores in-
vestigadoras. Fue cofundador y primer presidente de la Sociedad Noruega de Investiga-
ciones Operacionales (1959-1964). En 1960, fue contratado por el Centro Noruego de
Computación (NCC, por sus siglas en inglés), como responsable para establecer al NCC
como un importante instituto de investigación en los años sesenta. Allí, junto con Ole-
Johan Dahl, desarrolló los lenguajes SIMULA I (1961-1965) y SIMULA 67.
Trabajó para los sindicatos noruegos sobre planificación, control y procesamiento de
datos, todo ello evaluado en función de los objetivos de la mano de obra organizada
(1971-1973, junto con Olav Terje Bergo). Finalmente, también dedicó algo de esfuerzo
al estudio del impacto social de las tecnologías de la computación, así como al lenguaje
general de descripción de sistemas DELTA (1973-1975, junto con Erik Holbaek-Hanssen y
Petter Haandlykken). Nygaard fue profesor en Aarhus (Dinamarca) en el curso 1975-1976,
y fue nombrado profesor emérito en Oslo (a tiempo parcial desde 1977, y a tiempo com-
pleto entre 1984 y 1996).

-- 9 of 44 --

CC-BY-NC-ND • PID_00220485 10 Introducción a la programación orientada a objetos
En noviembre del 2002, recibió, junto a Dahl, la Medalla John von Neumann del IEEE,
"por la introducción de los conceptos subyacentes de la programación orientada a obje-
tos, mediante el diseño e implementación de SIMULA 67".
Fuente: Wikipedia.
Estos conceptos se perfeccionaron en el lenguaje Smalltalk, diseñado para ser
un sistema completamente dinámico en el que los objetos se podrían crear y
modificar "sobre la marcha" en lugar de tener un sistema basado en programas
estáticos.
La programación orientada a objetos tomó posición como el estilo de progra-
mación dominante a mediados de los años ochenta, en gran parte debido a
la influencia de C++, una extensión del lenguaje de programación C. Su do-
minación fue consolidada gracias al auge de las interfaces gráficas de usuario,
para las que la programación orientada a objetos está particularmente bien
adaptada.
Las características de orientación a objetos fueron agregadas a muchos lengua-
jes existentes durante ese tiempo, incluyendo Ada, BASIC, Lisp y Pascal, entre
otros. La adición de estas características a los lenguajes que no fueron diseña-
dos inicialmente para ellas condujo a menudo a problemas de compatibilidad
y a la capacidad de mantenimiento del código.
Los lenguajes orientados a objetos "puros", por otra parte, carecían de las carac-
terísticas que muchos programadores solían utilizar. Para evitar este problema,
aparecieron una serie de iniciativas con el objeto de crear nuevos lenguajes
basados en métodos, pero orientados a objetos, manteniendo de esta manera
algunas de las características imperativas.
El lenguaje Eiffel fue el primero que cumplía estos objetivos, pero fue reem-
plazado por Java, en gran parte debido a la aparición de Internet y a la imple-
mentación de la máquina virtual de Java en la mayoría de navegadores.
El lenguaje PHP, a partir de la versión 5, soporta una orientación completa a
objetos y cumple todas las características propias de la orientación a objetos.
En el caso de JavaScript, éste es un lenguaje orientado a objetos, en el que
la herencia se implementa siguiendo el paradigma de programación basada
en prototipos, esto es, las nuevas clases se generan clonando las clases base y
ampliando sus métodos y propiedades.

-- 10 of 44 --

CC-BY-NC-ND • PID_00220485 11 Introducción a la programación orientada a objetos