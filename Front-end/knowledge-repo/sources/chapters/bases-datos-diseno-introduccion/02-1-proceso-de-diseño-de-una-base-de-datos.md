# 1. Proceso de diseño de una base de datos

El proceso de diseño de bases de datos consiste en definir la estructura lógica
y física de una o más bases de datos para responder a las necesidades de los
usuarios con respecto a la información y para un conjunto concreto de apli-
caciones.
Mediante un proceso de diseño de bases de datos, se pueden decidir las tablas
y relaciones que debe tener una base de datos determinada, los atributos de
las diferentes tablas, las claves primarias y las claves foráneas que se deben
declarar en cada tabla, etc. Todas estas tareas forman parte del proceso de di-
seño de bases de datos. Para poder tomar estas decisiones de la manera más
correcta posible, hay que tener en cuenta las necesidades de información de
los usuarios en relación con un conjunto concreto de aplicaciones.
Por lo tanto, el diseño de una base de datos es el proceso en el que se
define la estructura de los datos que debe tener la base de datos de un
sistema de información determinado.
Los requisitos que debe cumplir un sistema de información y la complejidad
de la información que se presenta en él provocan que el diseño de una base
de datos sea un proceso complicado. Para simplificar este proceso, es muy
recomendable utilizar la estrategia de “divide y vencerás” (divide and conquer).
Si aplicamos este concepto, obtenemos las diferentes etapas del diseño de bases
de datos. Estas etapas son secuenciales y el resultado de cada una sirve de
punto de partida de la etapa siguiente. El resultado de la última etapa será el
diseño final de nuestra base de datos. De este modo, un proceso de una cierta
complejidad se descompone en diferentes procesos de menor complejidad. La
figura 1 muestra las distintas etapas del diseño de bases de datos.
En primer lugar, tenemos la recogida￿y￿análisis￿de￿requisitos. Esta etapa debe
permitir obtener los requisitos y las restricciones de los datos del problema.
Para obtener esta información será necesario mantener conversaciones con
los diferentes usuarios de la futura base de datos y de las aplicaciones que
estén relacionadas con ésta. Sólo si se cruzan los requisitos de los diferentes
perfiles de usuarios será posible establecer un marco completo de requisitos y
las restricciones de los datos relacionados con la futura base de datos.
Dividir para vencer
La estrategia de “divide y ven-
cerás” propone resolver un
problema complejo median-
te la subdivisión en un conjun-
to de problemas más sencillos
donde la resolución de los di-
ferentes subproblemas implica
solucionar el problema inicial.

-- 7 of 22 --

CC-BY-NC-ND • PID_00213710 8 Introducción al diseño de bases de datos
Figura 1. Etapas del diseño de bases de datos
A continuación, se inicia el diseño￿conceptual. En esta etapa se crea un es-
quema conceptual de alto nivel a partir de las especificaciones y los requisitos
obtenidos en la etapa anterior. En este proceso hay que extraer las necesidades
y los requisitos de la problemática y sintetizarlos en un modelo visual de ma-
nera que permita representar los datos y las restricciones de los conceptos que
se quieren modelizar en el sistema de información. Este modelo se denomina
esquema conceptual.
Sistema gestor de bases
de datos
Un sistema gestor de bases de
datos (SGBD; en inglés databa-
se management system, DBMS)
es un tipo de software especí-
fico que sirve de interfaz entre
la base de datos, el usuario y
las aplicaciones que la utilizan.
Hasta esta etapa del diseño de bases de datos todavía no ha sido necesario
elegir el tipo de bases de datos que se utilizará (relacional, orientada a objetos,
documental, etc.) ni el sistema gestor de bases de datos (SGBD1) que se utilizará
o el lenguaje concreto con el que se implementará la base de datos.
En el momento en el que se inicia la tercera etapa del proceso de diseño, el
diseño￿lógico, hay que determinar el tipo de bases de datos que se utilizará.
Es decir, no es necesario todavía escoger un SGBD concreto, pero sí el tipo
de bases de datos que se quiere utilizar. En esta etapa el esquema conceptual
se convierte en un esquema lógico adecuado al tipo de bases de datos que se
pretende usar.
Por tipos de bases de datos entendemos los diferentes grupos de bases de datos
según el modelo de datos que aplican. Actualmente hay varios tipos de SGBD,
entre los cuales los más utilizados son las bases de datos relacionales, orienta-
das a objetos, documentales, geográficas o multidimensionales. Por ejemplo,
las bases de datos relacionales son el conjunto de todos los SGBD que aplican
modelos de datos relacionales.
En este punto, y antes de iniciar la etapa de diseño￿físico, hay que elegir un
SGBD concreto sobre el que se pretende implementar la base de datos. La eta-
pa de diseño físico adapta el esquema lógico a las necesidades específicas de
un SGBD concreto y, posteriormente, ajusta algunos parámetros para el fun-
(1)SGBD es la sigla de sistema gestor
de bases de datos.

-- 8 of 22 --

CC-BY-NC-ND • PID_00213710 9 Introducción al diseño de bases de datos
cionamiento correcto de la base de datos. Por base de datos concreta o SGDB
concreto entendemos una aplicación concreta de bases de datos. En el caso de
bases de datos relacionales, ejemplos de SGBD concretos son Oracle Database,
Mysql, SQL Server o IBM Informix, entre otros.
Finalmente, la última etapa es la implementación￿y￿optimización de la base
de datos. Esta etapa permite cargar los datos y posteriormente permite ajustar
algunos parámetros del modelo físico y para optimizar el rendimiento de la
base de datos.
Estas etapas del diseño no hay que seguirlas estrictamente de manera secuen-
cial, y en muchos casos es habitual rehacer el diseño de la etapa anterior a
partir de necesidades detectadas en fases posteriores. Estos bucles￿de￿retroali-
mentación son habituales y permiten afinar los diseños de las distintas etapas
de una manera iterativa.
El proceso que muestra la figura 1 se basa en el modelo de diseño￿orientado
a￿datos. Este modelo se centra en el diseño de los contenedores de la infor-
mación y en la estructura de la base de datos. Paralelamente a este modelo
existe el modelo de diseño￿orientado￿a￿procesos, que se centra en las aplica-
ciones de bases de datos para determinar los datos y el uso que de estas hacen
las aplicaciones. Tradicionalmente, el diseño de aplicaciones se ha basado en
este segundo modelo, pero cada vez resulta más claro que ambas actividades
son paralelas y que están estrechamente interrelacionadas. Las herramientas
de diseño de bases de datos y de aplicaciones se combinan cada vez con mayor
frecuencia.

-- 9 of 22 --

CC-BY-NC-ND • PID_00213710 10 Introducción al diseño de bases de datos