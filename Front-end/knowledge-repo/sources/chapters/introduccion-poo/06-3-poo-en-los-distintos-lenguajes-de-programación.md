# 3. POO en los distintos lenguajes de programación

El objetivo de este apartado es presentar los principales lenguajes de progra-
mación que han incorporado la POO en su implementación. Para ello, en cada
uno de estos lenguajes se realizará una pequeña revisión histórica y se presen-
tarán sus principales características.
3.1. Smalltalk
Smalltalk fue desarrollado en Xerox Parc (Palo Alto Research Center) bajo el
impulso de Alan Kay durante la década de los setenta. Inicialmente debía ser
un lenguaje para un ordenador personal llamado Dynabook dirigido a todo
tipo de usuarios (incluidos niños). Debía ser, por lo tanto, un sistema con un
entorno intuitivo y fácil de programar. Aunque el proyecto Dynabook nunca
se completó, el lenguaje adquirió vida propia y continuó su camino.
Es poco conocida la gran importancia que tuvo este desarrollo en la evolución
posterior de la informática. De él parten muchas de las ideas que hoy son la
base de las interfaces de usuario, como el uso de gráficos, ratón, ventanas y
menús desplegables.
Smalltalk es un lenguaje orientado a objetos puro (el mismo término, si no el
concepto, fue inventado por Alan Kay) e incluye todos los conceptos clave,
como clases, métodos, mensajes y herencia. Todo el programa es una cadena
de mensajes enviados a objetos.
Las principales características del lenguaje son:
• Orientación a objetos pura.
• Tipos dinámicos.
• Herencia simple.
• Compilación en tiempo de ejecución o interpretado.
Smalltalk es un modelo puro orientado a objetos, lo que significa que, en el
entorno, todo es tratado como un objeto. Entre los lenguajes orientados a
objetos, Smalltalk es el más consistente en cuanto al manejo de las definiciones
y propiedades del paradigma orientado a objetos.
Se puede afirmar que es más que un lenguaje, es un entorno de desarrollo
con más de doscientas clases y varios miles de métodos. Smalltalk contiene
los siguientes componentes:
• Un lenguaje.
Alan Kay (1940)
Informático estadounidense
pionero en la programación
orientada a objetos y el dise-
ño de sistemas de interfaces de
usuario. Es profesor adjunto de
en la Universidad de California
en Los Ángeles. Una de sus fra-
ses mas célebres es: "La mejor
manera de predecir el futuro
es inventarlo".

-- 31 of 44 --

CC-BY-NC-ND • PID_00220485 32 Introducción a la programación orientada a objetos
• Un modelo de objeto, que define cómo actúan los objetos e implementa
la herencia, el comportamiento de clases e instancias, la asociación diná-
mica, el manejo de mensajes y las colecciones.
• Un conjunto de clases reutilizables, que dispone de una gran cantidad de
clases que pueden ser reutilizadas en cualquier programa. Estas clases pro-
veen las funciones básicas en el lenguaje, además del soporte para la por-
tabilidad a diferentes plataformas, incluida la portabilidad de las interfaces
gráficas de usuario.
• Un conjunto de herramientas de desarrollo, que habilitan a los programa-
dores a mirar y modificar las clases existentes, así como a renombrar, agre-
gar y borrar clases. También proveen de detección de errores, incluida la
habilidad de agregar paradas en la ejecución, observar los valores de las
variables, modificar el valor de variables en ejecución y realizar cambios
al código en tiempo de ejecución de un programa.
• Un entorno en tiempo de ejecución, que permite a los usuarios terminar
con el ciclo "compilado-linkeado-ejecución" de un programa. Esto permite
a los usuarios ejecutar un programa en Smalltalk mientras se cambia el
código fuente, de manera que los cambios realizados en el código fuente
son reflejados instantáneamente en la aplicación que se está ejecutando.
Una de las mejores características de Smalltalk es el alto￿grado￿de￿reutiliza-
ción del código, ya que contiene un gran conjunto de objetos que pueden ser
utilizados directamente o modificados de un modo sencillo para satisfacer la
necesidad de una aplicación en general.
Smalltalk no￿posee￿una￿notación￿explícita para describir un programa ente-
ro. Sí que se emplea una sintaxis explícita para definir ciertos elementos de
un programa, tales como métodos, pero la manera en la que esos elementos
están estructurados dentro de un programa entero generalmente es definida
por las múltiples implementaciones.
La sintaxis de Smalltalk tiende a ser minimalista, lo que implica que existe un
grupo reducido de palabras reservadas y declaraciones en comparación con la
mayoría de los lenguajes populares. Smalltalk posee un grupo de 5 palabras
reservadas: self, super, nil, true y false.
Las implementaciones utilizan técnicas de recolección de basura para detec-
tar y reclamar espacio en memoria asociado con objetos que ya no se utilizarán
más en el sistema. La manera de ejecución del recolector de basura es en back-
ground, es decir, como un proceso de baja prioridad no interactivo, aunque
en algunas implementaciones es posible ejecutarlo a demanda. La frecuencia
y las características de la recolección dependen de la técnica utilizada por la
implementación.
Web recomendada
En la web de Smalltalk se
puede encontrar información
ampliada sobre el desarrollo
y las características de este
lenguaje.

-- 32 of 44 --

CC-BY-NC-ND • PID_00220485 33 Introducción a la programación orientada a objetos
3.2. Eiffel
Es un lenguaje de programación escrito por Bertrand Meyer. A diferencia de
Smalltalk, incluye un preprocesador que permite la traducción de código Eiffel
al lenguaje C. Es popular en el campo de la ingeniería de software, ya que per-
mite la encapsulación, el control de acceso y el ámbito de las modificaciones.
Por sus capacidades técnicas, es, presumiblemente, el mejor lenguaje orienta-
do a objetos puro.
Bertrand Meyer (1950)
Estudió en la Escuela Politécnica de París, obtuvo un máster en la Universidad de Stanford
y se doctoró en Filosofía en la Universidad de Nancy. Su principal vía se basa en que los
lenguajes de programación deben ser simples, elegantes y fáciles de usar. Fue el diseñador
inicial del lenguaje y del método Eiffel. Una de sus frases más celebres es "un elemento
de software no es correcto ni incorrecto de por sí: es correcto si se comporta de acuerdo
a su especificación".
En este lenguaje los programas consisten en la declaración de colecciones de
clases que incluyen métodos y en los que se asocian los atributos. De esta
manera, el punto primordial de un programa en Eiffel es la declaración de
clases. Las clases y los atributos son accesibles a partir de la implementación de
un concepto llamado característica, que es, a la vez, una agrupación de datos
y una manera típica de tratarlos.
En Eiffel, una declaración de clase puede incluir:
• Una lista de características exportables.
• Una lista de las clases antecesora: clases de la que ésta hereda.
• Una lista de declaraciones de características.
Las principales características del lenguaje son:
• Se trata de un lenguaje orientado a objetos puro.
• Es un lenguaje de programación orientado hacia el diseño de grandes apli-
caciones. Las propiedades anteriores lo hacen ideal para el diseño de apli-
caciones en grupos de trabajo.
• El paso intermedio a código C se puede considerar una ventaja y no un
inconveniente, ya que aquellas secciones que sean difíciles de tratar con
Eiffel pueden elaborarse a partir de código C. Su compatibilidad con C
asegura también su portabilidad hacia otros sistemas operativos
• El manejo de la memoria, un punto delicado en todos los lenguajes orien-
tados a objetos, no es transparente como en el caso de Smalltalk.
• Las librerías de clases son reducidas.
Web recomendada
En la web de la compañía
Eiffel Software, en la que se
ofrece un entorno de desa-
rrollo bajo la licencia GPL, se
puede encontrar información
ampliada sobre el desarrollo
y las características de dicho
lenguaje.

-- 33 of 44 --

CC-BY-NC-ND • PID_00220485 34 Introducción a la programación orientada a objetos
• Su rendimiento es mayor que el de Smalltalk, pero ante la necesidad de
incluir un módulo Run-time dentro del ejecutable, su tamaño crece y su
rendimiento baja.
3.3. C++
Es un lenguaje de programación diseñado a mediados de los años ochenta
por Bjarne Stroustrup, de manera que amplía el lenguaje de programación C
con mecanismos que permiten la manipulación de objetos. Por este motivo,
el lenguaje C++ es considerado un lenguaje híbrido.
Posteriormente, se añadieron facilidades de programación genérica, que se su-
mó a los otros dos paradigmas que ya estaban admitidos (programación es-
tructurada y programación orientada a objetos). Por ello se suele decir que
el C++ es un lenguaje￿multiparadigma. Actualmente, existe un estándar, de-
nominado ISO C++, al que se han adherido la mayoría de los fabricantes de
compiladores más modernos.
La mayor contribución que realiza C++ al C es la introducción del tipo clase,
ya que las clases permiten definir conjuntos de propiedades y los métodos que
las manipulan.
C++ dispone de tres￿tipos￿de￿métodos￿constructores que son ejecutados cuan-
do una instancia de una clase es creada con el objetivo de inicializar o definir
el estado del objeto:
• Constructor￿predeterminado. Es el constructor que no recibe ningún pa-
rámetro en la función. Si no se define ningún constructor, el sistema pro-
porciona uno predeterminado.
• Constructor￿de￿copia. Es un constructor que recibe un objeto de la misma
clase y realiza una copia de sus atributos. Al igual que el predeterminado,
si no se define, el sistema proporciona uno.
• Constructor￿de￿conversión. Este constructor, recibe como único paráme-
tro, un objeto o variable de otro tipo distinto al suyo propio. Es decir, con-
vierte un objeto de un tipo determinado a otro objeto del tipo que se está
generando.
De la misma manera que son necesarios métodos constructores, son necesa-
rios los destructores, que no son más que funciones miembro especiales cuyo
cometido es liberar los recursos que el objeto de dicha clase haya adquirido
en tiempo de ejecución al expirar éste. Los destructores son invocados auto-
máticamente al alcanzar el flujo del programa el fin del ámbito en el que está
declarado el objeto.
Bjarne Stroustrup (1950)
Es un científico de la compu-
tación y catedrático de Cien-
cias de la Computación en la
Universidad A&M de Texas.
Ha destacado por desarrollar el
lenguaje de programación C++
y escribir el manual de referen-
cia del lenguaje The C++ Pro-
gramming Language.

-- 34 of 44 --

CC-BY-NC-ND • PID_00220485 35 Introducción a la programación orientada a objetos
Existen dos￿tipos￿de￿destructores:
• Públicos: se pueden llamar desde cualquier parte del programa.
• Privados: cuando no se permite la destrucción del objeto por parte del
usuario.
En C++ es posible definir clases abstractas, que están diseñadas sólo como clase
padre de las que se deben derivar clases hija. Una clase abstracta se usa para
representar aquellas entidades o métodos que después se implementarán en
las clases derivadas, pero la clase abstracta en sí no contiene ningún código
específico, sólo representa los métodos que se deben implementar. Por ello,
no es posible instanciar una clase abstracta, pero sí una clase concreta que
implemente los métodos definidos en ella.
Existen en C++ tres￿modos￿de￿herencia￿simple que se diferencian en el modo
de manejar la visibilidad de los componentes de la clase resultante:
• Herencia￿ pública: con este tipo de herencia se respetan los comporta-
mientos originales de las visibilidades de la clase padre en la clase hija.
• Herencia￿privada: con este tipo de herencia todo componente de la clase
padre será privado en la clase hija.
• Herencia￿protegida: con este tipo de herencia, todo componente publico
y protegido de la clase base será protegido en la clase derivada, y los com-
ponentes privados siguen siendo privados.
La sobrecarga de operadores en C++ es una manera de implementar polimor-
fismo, de este modo, se puede definir el comportamiento de un operador del
lenguaje para que trabaje con tipos de datos definidos por el usuario. No to-
dos los operadores de C++ son factibles de sobrecargar, y, entre aquellos que
pueden ser sobrecargados, se deben cumplir ciertas condiciones.
Lectura recomendada
Bruce Eckel es autor de libros y artículos sobre programación. Sus obras más conocidas
son Thinking in Java y Thinking in C++, dirigidas a programadores con poca experiencia
en la programación orientada a objetos.
Existe una página oficial en la que se está realizando la traducción al castellano del libro
de Bruce Eckel Thinking in C++.
3.4. ActionScript 3.0
ActionScript fue desarrollado con la finalidad en sus inicios de agregarle inter-
actividad al formato de animación vectorial Flash. A partir de ese momento,
los diseñadores Flash se vieron en la necesidad de convertirse en programado-
res para añadir todas las posibilidades que el lenguaje podía proporcionar.

-- 35 of 44 --

CC-BY-NC-ND • PID_00220485 36 Introducción a la programación orientada a objetos
ActionScript es un lenguaje de programación orientado a objetos, utilizado en
las aplicaciones web animadas que son creadas en el entorno Flash. El lenguaje
fue introducido a partir de la versión 4 de Flash y desde entonces ha evolucio-
nado en cada una de las nuevas versiones.
Se trata de lenguaje Script basado en especificaciones estándar de industria
ECMA-262, un estándar para JavaScript, de ahí que ActionScript se parezca
tanto a JavaScript. La versión más extendida actualmente es ActionScript 3.0,
que significó una mejora en el manejo de programación orientada a objetos
al ajustarse mejor al estándar ECMA-262.
Las principales características del lenguaje se comentan a continuación:
• Dispone de una máquina virtual que es la encargada de la interpretación
del código, independientemente de la plataforma en la que éste se ejecute.
• La sintaxis del lenguaje se ajusta al estándar ECMAScript (ECMA 262).
• Dispone de una interfaz de programación que permite un control de bajo
nivel de los objetos que componen las películas Flash.
• Una API XML basada en la especificación de ECMAScript para XML (E4X)
(ECMA-357 edición 2). E4X es una extensión del lenguaje ECMAScript que
añade XML como un tipo de datos nativo del lenguaje.
• Un modelo de eventos basado en la especificación de eventos DOM (mo-
delo de objetos de documento) de nivel 3.
Por lo tanto, se trata de un lenguaje de programación empotrado en las pelí-
culas creadas con Flash, pero que cumple los estándares ECMAScript, como
JavaScript, por lo que ambos lenguajes comparten gran parte de la sintaxis.
3.5. Ada
En los años setenta, el departamento de Defensa de Estados Unidos tenía pro-
yectos que se desarrollaban en un conjunto variado de lenguajes de progra-
mación. Esta variedad suponía un cierto problema y su solución se basó en
la búsqueda de un único lenguaje que cumpliese ciertas normas obligatorias.
Se lanzó un concurso y, de las diferentes propuestas planteadas, en mayo de
1979 se seleccionó la propuesta planteada por Honeywell Bull, y se le dio el
nombre de Ada.
El Departamento de Defensa y los ministerios equivalentes de varios países de
la OTAN exigían el uso de este lenguaje en los proyectos que contrataban (esta
obligación se conocía como el "Ada mandate"). La obligatoriedad en el caso
de Estados Unidos finalizó en 1997.
Web recomendada
Podéis encontrar manuales,
tutoriales, artículos, etc. en la
web de la comunidad de pro-
gramadores de ActionScript:
www.actionscript.org.
Origen de Ada
El nombre se eligió en conme-
moración de lady Ada Augusta
Byron (1815-1852), condesa
de Lovelace, hija del poeta lord
George Byron, a quien se con-
sidera la primera programado-
ra de la historia, por su colabo-
ración y relación con Charles
Babbage, creador de la máqui-
na analítica.

-- 36 of 44 --

CC-BY-NC-ND • PID_00220485 37 Introducción a la programación orientada a objetos
La sintaxis del lenguaje esta inspirada en Pascal, por lo que es legible incluso
para programadores que no conozcan el lenguaje. Se trata de un lenguaje que
no escatima en la longitud de las palabras clave, ya que uno de sus principios
es que un programa se escribe una vez, se modifica decenas de veces y se lee
miles de veces (la legibilidad es más importante que la rapidez de escritura).
Fue diseñado con el propósito principal de generar programas con la mayor
calidad posible, con el objetivo de obtener confianza por parte de los usuarios.
Es posible implementar cualquier tipo de software en Ada, pero su principal
uso ha sido en software de control en tiempo real y de misión crítica.
Por otro lado, Ada, como lenguaje que promueve las buenas prácticas en in-
geniería del software, es muy usado en la enseñanza de la programación en
muchas universidades de todo el mundo.
Se trata de un lenguaje de programación imperativo, orientado a objetos, con-
currente y distribuido. Sus principales características son:
• Su sintaxis inspirada en Pascal es fácilmente legible.
• Es un lenguaje case insensitive, es decir, sus identificadores y palabras clave
son equivalentes sea cual sea el uso de mayúsculas y minúsculas.
• Es un lenguaje con tipado fuerte: asigna en cada objeto un conjunto de
valores claramente definido, lo que impide la confusión entre conceptos
lógicamente distintos. Esto hace que el compilador detecte más errores
que en otros lenguajes.
• Está preparado para la construcción de grandes programas. Para crear pro-
gramas sostenibles y transportables, de cualquier tamaño, se necesitan me-
canismos de encapsulado para compilar por separado y para gestionar bi-
bliotecas.
• Dispone de mecanismos que permiten el manejo de excepciones. De esta
manera, los programas son construidos por capas y se limitan las conse-
cuencias de los errores en cualquiera de sus partes.
• Con la abstracción de datos se separan los detalles de la representación de
los datos y las especificaciones de las operaciones lógicas sobre ellos para
obtener mayor transportabilidad y mejor mantenimiento.
• Dispone de la capacidad de procesamiento paralelo, y así evita la necesidad
de añadir estos mecanismos por medio de llamadas al sistema operativo,
con lo que consigue mayor fiabilidad y transportabilidad.
• Dispone de la posibilidad de crear unidades genéricas; éstas son necesarias,
ya que parte de un programa puede ser independiente del tipo de valores
Web recomendada
En GRB ADA95 se dispo-
ne de una guía básica de
aprendizaje del lenguaje
de programación: http://
www.gedlc.ulpgc.es/docen-
cia/NGA/index.html.

-- 37 of 44 --

CC-BY-NC-ND • PID_00220485 38 Introducción a la programación orientada a objetos
que manipular. Para ello, necesitamos que se utilice este mecanismo que
permite crear partes de un programa similares a partir de una plantilla.
3.6. Perl
El creador de Perl, Larry Wall, anunció la versión 1.0 del lenguaje el 18 de
diciembre de 1987. En los siguientes años, éste se expandió de manera muy
rápida, aunque hasta 1991 la única documentación de Perl era una simple (y
cada vez más larga) página de manual Unix.
El 26 de octubre de 1995, se creó el Comprehensive Perl Archive Network
(CPAN). CPAN es una colección de sitios web que almacenan y distribuyen
fuentes en Perl, binarios, documentación, scripts y módulos. Originalmente,
cada sitio CPAN debía ser accedido mediante su propio URL; actualmente,
www.cpan.org redirecciona automáticamente a uno de los cientos de reposi-
torios espejo de CPAN.
Perl es un lenguaje de propósito general originalmente desarrollado para la
manipulación de texto y ahora es utilizado para un amplio rango de tareas
que incluyen administración de sistemas, desarrollo web, programación en red
y desarrollo de GUI. Se previó que fuera práctico (facilidad de uso, eficiente,
completo) en lugar de hermoso (pequeño, elegante, mínimo).
Sus principales características son que es fácil de usar, que soporta tanto la pro-
gramación estructurada como la programación orientada a objetos y la pro-
gramación funcional y que tiene incorporado un poderoso sistema de proce-
samiento de texto y una enorme colección de módulos disponibles.
La estructura completa de Perl deriva ampliamente del lenguaje C, por lo tan-
to, es un lenguaje imperativo, con variables, expresiones, asignaciones, blo-
ques de código delimitados por llaves, estructuras de control y subrutinas.
Perl también toma características de la programación shell, por lo que dispo-
ne de muchas funciones integradas para tareas comunes y para acceder a los
recursos del sistema.
En la versión 5 de Perl se añadieron características para soportar estructuras
de datos complejas, funciones de primer orden (por ejemplo, clausuras como
valores) y un modelo de programación orientada a objetos. Éstos incluyen re-
ferencias, paquetes y una ejecución de métodos basada en clases y la introduc-
ción de variables de ámbito léxico, que hizo más fácil escribir código robusto.
Una característica importante introducida en Perl 5 fue la habilidad de empa-
quetar código reutilizable en estructuras de módulos.
Larry Wall (1954)
Programador, lingüista y au-
tor, Larry Wall es conocido por
ser el creador del lenguaje de
programación Perl. Recibió en
1998 el primer premio de la
Free Software Foundation pa-
ra el avance del software libre.
Es el coautor del libro Program-
ming Perl (comúnmente llama-
do el "libro del camello"), que
es el recurso básico de los pro-
gramadores de Perl.

-- 38 of 44 --

CC-BY-NC-ND • PID_00220485 39 Introducción a la programación orientada a objetos
Todas las versiones de Perl implementan tipificado automático de datos y ges-
tión de memoria. De esta manera, el intérprete conoce el tipo y los requeri-
mientos de almacenamiento de cada objeto en el programa; reserva y libera
espacio para ellos según sea necesario. Las conversiones legales de tipo se rea-
lizan de manera automática en tiempo de ejecución; las conversiones ilegales
son consideradas errores fatales.
Se ha usado desde los primeros días de la Web para escribir guiones (scripts)
CGI. Es una de las "tres Pes" (Perl, Python y PHP), que son los lenguajes más
populares para la creación de aplicaciones web, y es un componente integral
de la popular solución LAMP para el desarrollo web.
Proyectos importantes escritos en Perl son Slash, IMDb y UseModWiki;
además, sitios web con un nivel alto de tráfico, como Amazon.com y
Ticketmaster.com utilizan el lenguaje. Además, es ampliamente usado en fi-
nanzas y bioinformática, donde es apreciado por su desarrollo rápido, tanto
de aplicaciones como de despliegue, así como la habilidad de manejar grandes
volúmenes de datos.
3.7. PHP
PHP fue originalmente diseñado en Perl, basándose en la escritura de un grupo
de CGI binarios escritos en el lenguaje C por el programador danés-canadiense
Rasmus Lerdorf en el año 1994 para mostrar su curriculum vitae y guardar cier-
tos datos, como la cantidad de tráfico que su página web recibía. El 8 de junio
de 1995 fue publicado "Personal Home Page Tools" después de que Lerdorf lo
combinara con su propio Form Interpreter para crear PHP/FI.
Rasmus Lerdorf (1968)
Programador nacido en Groenlandia al que se considera uno de los más importantes
creadores de PHP. En 1995, Lerdorf creo un CGI en Perl que mostraba el número de visitas
que había obtenido su página web personal, este script lo llamó PHP (Personal Home
Page) y fue este pequeño script el detonante del nuevo lenguaje script. Creó una lista
de correo para intercambiar opiniones, sugerencias y correcciones que provocó la base
que acabó formalizando a PHP como una herramienta de software libre donde el aporte
de la comunidad mundial ha provocado que sea una de los lenguajes de programación
web más utilizados.
PHP es un lenguaje de programación diseñado especialmente para desarrollo
web que también puede ser incrustado en las propias páginas de la Red; por
otra parte, es interpretado por el servidor, que normalmente devolverá como
resultado una nueva página web. La sintaxis de PHP es similar a la de los len-
guajes Perl y C, esto provoca que la curva de aprendizaje del lenguaje sea muy
corta.
Cuando el cliente realiza una petición al servidor para que le envíe una página
web, el servidor ejecuta el intérprete de PHP. Éste procesa el script y genera
el contenido de manera dinámica (por ejemplo, obteniendo información de
Lectura recomendada
Tenéis a vuestra disposición
en línea un pdf que intro-
duce al programador en el
modelo de programación
orientada a objetos del len-
guaje Perl: www.gwolf.org/fi-
les/poo_perl.pdf.

-- 39 of 44 --

CC-BY-NC-ND • PID_00220485 40 Introducción a la programación orientada a objetos
una base de datos). El resultado es enviado por el intérprete al servidor, quien,
a su vez, se lo envía al cliente. Mediante extensiones es también posible la
generación de archivos PDF, Flash, así como imágenes en diferentes formatos.
PHP es portable y, por lo tanto, se puede ejecutar en la mayoría de los sistemas
operativos: UNIX, Linux, Mac OS X y Windows.
A continuación, presentamos las principales características del lenguaje:
• Se trata de un lenguaje multiplataforma.
• Está completamente orientado a la web.
• Tiene capacidad de conexión con la mayoría de los motores de base de
datos que se utilizan en la actualidad; en este sentido, destaca su conecti-
vidad con MySQL y PostgreSQL.
• Posee capacidad de expandir su potencial utilizando la enorme cantidad
de módulos de los que dispone.
• Es software libre, por lo que se presenta como una alternativa de fácil ac-
ceso.
• Implementa el paradigma de la programación orientado a objetos.
• Dispone de una biblioteca nativa de funciones sumamente amplia e in-
cluida.
• No requiere definición de tipos de variables, aunque sus variables se pue-
den evaluar también por el tipo que estén manejando en tiempo de eje-
cución.
• Implementa la capacidad de manejo de excepciones.
• La ofuscación de código es el único modo de ocultar las fuentes.
3.8. C#
Los primeros rumores de que Microsoft estaba desarrollando un nuevo len-
guaje de programación surgieron en 1998, en referencia a un lenguaje que
entonces llamaban COOL y que decían que era muy similar a Java. En junio
del 2000, Microsoft despejó todas las dudas liberando la especificación de un
nuevo lenguaje llamado C#. A esto le siguió rápidamente la primera versión
de prueba del entorno de desarrollo estándar .NET, que incluía un compilador
de C#.
Web recomendada
En la página oficial de PHP
encontraréis más informa-
ción sobre dicho lenguaje:
www.php.net.

-- 40 of 44 --

CC-BY-NC-ND • PID_00220485 41 Introducción a la programación orientada a objetos
C# es un lenguaje de programación orientado a objetos desarrollado y estan-
darizado por Microsoft como parte de su plataforma .NET. Su sintaxis básica
deriva de C/C++ y utiliza el modelo de objetos de la plataforma .NET, que es
similar al de Java, aunque incluye mejoras derivadas de otros lenguajes.
C#, como parte de la plataforma .NET, está normalizado por ECMA desde di-
ciembre del 2001 (ECMA-334 "Especificación del lenguaje C#").
El 7 de noviembre del 2005 se publicó la versión 2.0 del lenguaje, que incluía
mejoras tales como tipos genéricos, métodos anónimos, iteradores, tipos par-
ciales y tipos anulables. El 19 de noviembre del 2007 se publicó la versión 3.0
de C#, entre cuyas mejoras destacaban los tipos implícitos, los tipos anónimos
y el LINQ (Language Integrated Query; consulta integrada en el lenguaje).
Aunque C# forma parte de la plataforma .NET (ésta es una interfaz de progra-
mación de aplicaciones), se trata de un lenguaje de programación indepen-
diente diseñado para generar programas sobre dicha plataforma.
Microsoft
.NET es la propuesta de Microsoft a la programación en entornos web y nace con el obje-
tivo de competir con la plataforma Java. Como la mayoría de productos de Microsoft su
gran baza es que proporciona una manera rápida y económica de desarrollar aplicaciones.
Actualmente, existe un compilador GNU de C# (Mono) que genera programas
para distintas plataformas como Win32, UNIX y Linux.
3.9. Java
Los inicios de Java se remontan al año 1991, cuando un grupo de ingenieros
dirigido por Patrick Naughton y James Gosling quería diseñar un pequeño
lenguaje de programación que pudiera ser usado para dispositivos de consumo
como los equipos de televisión por cable (este proyecto se llamó Green Pro-
ject); dado que estos dispositivos no tienen una gran capacidad de memoria,
el lenguaje debía ser simple y generar código muy reducido.
James Gosling (1956)
Doctorado por la Universidad de Carnegie Mellon y conocido como el creador del len-
guaje de programación Java; realizó el diseño original, la implementación del compila-
dor original y la máquina virtual Java, por lo que fue elegido miembro de la Academia
Nacional de Ingeniería de Estados Unidos (NAE).
Por otro lado, los fabricantes de este tipo de dispositivos electrónicos suelen
cambiar los chips con bastante frecuencia. La aparición de un nuevo chip más
barato y, generalmente, más eficiente conduce a dichos fabricantes a incluirlo
en las nuevas series de sus cadenas de producción, ya que esta diferencia de
precio, por pequeña que sea, puede generar un ahorro considerable en dispo-
sitivos de tirada masiva.
Web recomendada
Encontraréis más informa-
ción sobre el lenguaje C# en
la página Centro de desa-
rrolladores en C#, dirigi-
da por Microsoft: http://
msdn.microsoft.com/es-es/
vcsharp/default.aspx.

-- 41 of 44 --

CC-BY-NC-ND • PID_00220485 42 Introducción a la programación orientada a objetos
Si se usaban lenguajes como C o C++, debían compilar todos los programas
con el compilador de ese nuevo chip y esto encarecía los desarrollos. Por lo
tanto, dado que los fabricantes podían elegir diferentes CPU, era importante
no estar atado a una sola arquitectura: era muy importante la portabilidad. Si
se conseguía un lenguaje que produjese un código independiente de la CPU, se
evitaba la necesidad de compilar todos los programas que existían (para dife-
rentes aparatos electrónicos) cuando apareciese una nueva CPU. Simplemente
deberían contar con un intérprete de ese código para la nueva CPU (que podía
darse a los fabricantes si el lenguaje se popularizaba suficientemente).
En abril de 1991, Gosling empezó a trabajar en el nuevo lenguaje de Green
Project, decidió que las ventajas aportadas por la eficiencia de C++ no com-
pensaban los grandes costes de pruebas y depuración del código. Como dijo
Gosling, "el lenguaje era una herramienta, no el fin", así que desarrolló un
lenguaje de programación que, aun partiendo de la sintaxis de C++, intentaba
remediar los aspectos de C++, que eran la causa de la mayoría de los problemas.
Gosling decidió llamar a su lenguaje Oak (se supone que refiriéndose a un ro-
ble que estaba enfrente de la ventana de su lugar de trabajo en Sun). Los pri-
meros programas en Oak se ejecutaron en agosto de 1991. Más tarde, en Sun,
se dieron cuenta de que ya había un lenguaje llamado Oak y lo rebautizaron
como Java (en inglés norteamericano significa café; el equipo que desarrollaba
este lenguaje se reunía en una cafetería cercana a las instalaciones de Sun para
discutir distendidamente el proyecto).
En 1992, el Green Project lanzó su primer producto, llamado "*7" (Star Seven).
Era una especie de mezcla entre PDA y control remoto extremadamente inte-
ligente, diseñado para realizar un control integrado de un hogar con todos
los aparatos electrónicos que lo componen. El sistema presentaba una interfaz
basada en la representación de la casa y el control se llevaba a cabo mediante
una pantalla táctil.
En el sistema aparecía Duke, la actual mascota de Java. Desafortunadamente,
no hubo mucho interés por él y en ese momento el equipo de Green Project
se embarcó en un concurso convocado por la Time Warner para diseñar un
equipo para la televisión por cable que fuera capaz de ocuparse de nuevos
servicios de cable como el vídeo bajo demanda. Es decir, se aplicaba Java a la
interfaz de la televisión interactiva.
Ninguno de estos dos proyectos se convirtió en un sistema comercial, pero
fueron desarrollados enteramente en un Java primitivo y le sirvieron como
bautismo de fuego.
A mediados de 1994, la popularidad de la web atrajo la atención de los directi-
vos de Sun. Bill Joy, cofundador de Sun y uno de los desarrolladores principales
del Unix de Berkeley, juzgó que Internet podría llegar a ser el campo de juego
adecuado para disputar a Microsoft su supremacía casi absoluta en el terreno

-- 42 of 44 --

CC-BY-NC-ND • PID_00220485 43 Introducción a la programación orientada a objetos
del software, y vio en Oak/Java el instrumento idóneo para llevar a cabo estos
planes. Se dio cuenta de que los requisitos para el software de los dispositivos
electrónicos y los equipos de televisión (set top boxes) eran los mismos que los
requisitos para la web (código sencillo, independiente de plataforma, seguro
y fiable).
Decidieron programar un navegador empleando la tecnología Java. Aquel pri-
mer programa, llamado WebRunner, quedó listo en mayo de 1995 (Patrick
Naughton escribió un prototipo de este navegador en un fin de semana de
inspiración) y, al ver sus enormes posibilidades, decidieron mejorar el navega-
dor. El 23 de mayo de 1995, en la Sun World 95 de San Francisco, Sun presenta
su nuevo navegador HotJava y Netscape anuncia su intención de integrar Java
en su navegador.
A partir de aquel verano, los acontecimientos se desarrollan vertiginosamente
para el mundo Java, sobre todo después del lanzamiento y distribución libre
del Java Development Kit (JDK) 1.0. A finales de 1995 (¡sólo seis meses después
del lanzamiento de JDK!), Java había firmado acuerdos con las principales fir-
mas de software para que pudieran utilizar Java en sus productos, entre otras,
Netscape, Borland, Mitsubishi Electronics, Dimension X, Adobe, IBM, Lotus,
Macromedia, Oracle, SpyGlass, etc., pero lo más espectacular fue el anuncio
por parte de Bill Gates, presidente y director ejecutivo de Microsoft, el 7 de
diciembre de 1995, de la voluntad por parte de Microsoft de obtener la licencia
de utilización de Java.
Aquel anuncio mostraba claramente que Microsoft consideraba a Java como
una parte importante en la estrategia global de Internet. Este anuncio es signi-
ficativo si se considera el desprecio que meses antes Bill Gates había mostrado
hacia Java, cuando se refirió a éste como "un lenguaje más". El propio director
general de Microsoft en España había calificado a Java como "un lenguaje para
tostadoras".
Durante 1996, se planteó el debate de crear un "terminal tonto" llamado NC
(Network Computer) que únicamente sirviera para conectarse a la World Wide
Web. En un principio, se proyectó que este terminal estaría gobernado por un
sistema operativo Java. La idea del NC no cuajó como se esperaba y apareció
otra intermedia entre el NC y el PC: el NetPC, que tampoco tuvo demasiado
éxito. Sin embargo, la idea de producir un sistema operativo sí que se ha desa-
rrollado, se llama JavaOS.
El lema de Java es "escribe una vez y ejecútalo en cualquier sitio". La idea prin-
cipal que transmite este lema es la portabilidad de Java: una vez escrito el có-
digo fuente y traducido a bytecode, puede ejecutarse en cualquier máquina
con cualquier sistema operativo (incluso aunque no sea un ordenador), sin
necesidad de recompilarlo.

-- 43 of 44 --

CC-BY-NC-ND • PID_00220485 44 Introducción a la programación orientada a objetos
Para conseguir la portabilidad, el código fuente Java se "compila" para una má-
quina ficticia llamada Máquina Virtual Java (JVM o Java Virtual Machine), lo
que genera un código llamado código de octetos o bytecode. El código fuente
también es portable, pero usar ese código intermedio llamado código de octe-
tos tiene varias ventajas:
• Permite un mayor rendimiento, ya que gran parte del proceso de traduc-
ción del código fuente a unas instrucciones de una CPU específica ya está
realizado.
• Permite mantener en secreto el código fuente original, lo que puede ser
importante en cierto tipo de programas, en los que se desea que sean por-
tables y a la vez difíciles de manipular, curiosear, copiar, etc. También pue-
de extrapolarse otra idea importante: en cualquier sitio (navegadores) se
puede ejecutar código Java (applets) sin importar de dónde provenga, ya
que no hay grandes peligros de seguridad (como pueden ser virus o pro-
gramas que atenten contra la privacidad).
Básicamente, la idea que propone es que el usuario sólo necesita tener a su
lado un mero elemento de interacción (a veces llamado "terminal tonto") sin
demasiada potencia de procesamiento o capacidad de almacenamiento (por
ejemplo, carente de disco duro) y que el verdadero ordenador (elementos de
computación y almacenamiento) puede estar distribuido en una red.
Desde el principio Java fue diseñado como un lenguaje orientado a objetos. Los
objetos agrupan en estructuras encapsuladas tanto sus datos como los métodos
(o funciones) que manipulan esos datos. La tendencia del futuro, a la que Java
se suma, apunta hacia la programación orientada a objetos, especialmente en
entornos cada vez más complejos y basados en una red.
3.10. JavaScript
Web recomendada
En la web oficial de Sun
podéis obtener más infor-
mación sobre el lengua-
je de programación Java:
java.sun.com.
JavaScript es un lenguaje que se introdujo en la versión 2.0 del Netscape Na-
vigator, a principios de 1996, y que Microsoft aceptó más tarde para que su
Internet Explorer ganara cuota de mercado, aunque ambas versiones tienen
características incompatibles.
Ved también
Las características de la orien-
tación a objetos en JavaScript
se estudian en detalle en el
módulo "Orientación a objetos
en JavaScript".

-- 44 of 44 --