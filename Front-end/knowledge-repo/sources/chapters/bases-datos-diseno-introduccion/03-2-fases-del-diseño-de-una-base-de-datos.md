# 2. Fases del diseño de una base de datos

A continuación veremos con algo más de detalle las fases que forman el pro-
ceso de diseño de una base de datos.
2.1. Fase 1. Recogida y análisis de requisitos
La primera fase en el diseño de una base de datos consiste en conocer
y analizar con detalle las expectativas, las necesidades y los objetivos
de los futuros usuarios de la base de datos. Este proceso se denomina
recogida y análisis de requisitos.
La fase de recogida y análisis de requisitos se puede dividir en tres subfases
secuenciales: la recogida de requisitos; la estructuración y el refinamiento de
los requisitos, y la formalización de los requisitos.
2.1.1. Recogida de requisitos
Para determinar los requisitos, en primer lugar hay que establecer los actores
del sistema de información que interaccionarán con la base de datos. Esto in-
cluye a los usuarios y las aplicaciones, tanto si son nuevos como si no lo son.
Normalmente, un grupo de analistas se encarga de hacer el análisis de requi-
sitos y, muy probablemente, este análisis suele ser informal, incompleto e in-
cluso incoherente en algún punto. Por lo tanto, hay que dedicar muchos es-
fuerzos a trabajar esta información y convertirla en una especificación que los
diseñadores de bases de datos puedan utilizar para modelizar e implementar
el sistema de información.
En esta fase, no solo hay que recoger y analizar los requisitos referentes a la
estructura o la forma de la información (tipos de datos y relaciones entre ítems
de datos), sino que hay que capturar y analizar cualquier tipo de requisito,
independientemente de qué tipo sea. Hay que recoger, analizar y documentar
cualquier requisito que los usuarios esperen de la base de datos. Esto incluye
los procesos que se deben ejecutar sobre la base de datos, las restricciones sobre
los datos, las restricciones sobre el rendimiento del sistema de información, las
restricciones relativas a la implementación (tanto en lo que respecta al hard-
ware como en lo que se refiere al software), requisitos de seguridad o requisitos
de rendimiento (por ejemplo, tiempo de respuesta), entre otros. Algunas de
las actividades más habituales de esta fase son las siguientes:
• Identificar los grupos de usuarios y las principales áreas de aplicación que
utilizarán la base de datos y que se verán directa o indirectamente afecta-

-- 10 of 22 --

CC-BY-NC-ND • PID_00213710 11 Introducción al diseño de bases de datos
dos por ésta. Dentro de cada grupo hay que elegir usuarios clave y formar
comités para llevar a cabo la recopilación y la especificación de requisitos.
• Estudiar y analizar la documentación existente relativa a las aplicaciones
en uso.
• Estudiar el entorno actual y el uso que se quiere dar a la información. Esto
incluye el estudio de las entradas, el flujo y las salidas de información,
además de las frecuencias y los usos de las diferentes tareas dentro del
sistema de información.
• Hacer entrevistas y encuestas a los futuros usuarios para que puedan ma-
nifestar su opinión y sus prioridades acerca del nuevo sistema de informa-
ción.
2.1.2. Estructuración y refinamiento de los requisitos
Se debe tener en cuenta que algunos de estos requisitos, muy probablemente,
cambiarán durante el proceso de diseño y que hay que estar atentos y en con-
tacto permanente con los usuarios de la base de datos para detectar posibles
problemas. Es una buena práctica incorporar los usuarios de la base de datos
durante el proceso de desarrollo, puesto que así se incrementa su grado de
implicación y satisfacción. Hay algunas propuestas de metodologías para la
recogida y el análisis de requisitos basadas en el trabajo conjunto de los desa-
rrolladores con los usuarios de la base de datos, como, por ejemplo, el diseño
conjunto de aplicaciones (JAD2).
2.1.3. Formalización de los requisitos
(2)JAD es la sigla de la expresión in-
glesa joint application design.
El paso siguiente es convertir los requisitos a un formato estructurado me-
diante técnicas de especificación de requisitos como, por ejemplo, el análisis
orientado a objetos (OOA3), diagramas de flujo de datos (DFD4) o la notación
Z. Estas técnicas utilizan diferentes tipos de recursos (diagramas, texto, tablas,
gráficos, diagramas de decisión, etc.) para organizar y representar los requisi-
tos de manera clara.
Esta fase puede representar un coste importante dentro del proceso de diseño
de una base de datos, pero es muy importante y puede ser determinante para
el éxito o el fracaso del sistema de información. Detectar y corregir los errores
o problemas en las fases iniciales del proyecto es mucho menos costoso que
arrastrar los errores hasta las fases finales, cuando corregirlos tendrá unos cos-
tes mucho más importantes. La satisfacción del usuario final vendrá determi-
nada por la capacidad de recoger y captar sus necesidades e implementarlas
de manera correcta en la solución final.
(3)OOA es la sigla de la expresión
inglesa object oriented analysis.
(4)DFD es la sigla de la expresión
inglesa data flow diagrams.
La notación Z
La notación Z es un lenguaje
formal utilizado en ingeniería
del software.

-- 11 of 22 --

CC-BY-NC-ND • PID_00213710 12 Introducción al diseño de bases de datos
2.2. Fase 2. Diseño conceptual
La fase de diseño￿conceptual tiene como objetivo crear un esquema
conceptual de alto nivel e independiente de la tecnología a partir de los
requisitos, las especificaciones y las restricciones que se han recogido
en la fase anterior.
En esta fase se parte de la recogida y el análisis de requisitos obtenidos en
la fase anterior y tiene como objetivo diseñar un esquema conceptual de la
base de datos que sea consistente con los requisitos, las especificaciones y las
restricciones impuestas por la problemática que hay que resolver.
Un esquema￿conceptual es una descripción concisa de los requisitos de datos
que se expresa mediante conceptos proporcionados por un modelo de datos
de alto nivel, fácil de entender y sin detalles de implementación. El esquema,
además, debe servir de referencia para verificar que se han agrupado todos los
requisitos y que no hay ningún conflicto entre ellos.
En esta fase del diseño todavía no se considera el tipo de base de datos que
se utilizará. Y, por lo tanto, tampoco el SGBD ni el lenguaje concreto de im-
plementación de la base de datos. En esta etapa nos concentraremos en la es-
tructura de la información, sin resolver de momento cuestiones relacionadas
con la tecnología.
2.2.1. El modelo ER
Hay varios modelos de datos de alto nivel que permiten modelizar los requi-
sitos, las especificaciones y las restricciones que se han obtenido en la primera
fase del diseño de una base de datos. Uno de los más conocidos y utilizados
es el modelo entidad-interrelación, que abreviaremos como modelo￿ER. Este
modelo es uno de los más utilizados en el diseño conceptual de las aplicaciones
de bases de datos, principalmente, debido a su simplicidad y facilidad de uso.
Los principales elementos que incluye el modelo son los tipos de entidad, los
atributos y los tipos de relaciones entre entidades. El objetivo principal del
modelo ER es permitir a los diseñadores reflejar en un modelo conceptual los
requisitos del mundo real que sean de interés para el problema. El modelo ER
facilita el diseño conceptual de una base de datos y, como ya hemos comen-
tado, es aplicable al diseño de cualquier tipo de bases de datos.
Modelo ER
En inglés se denomina en-
tity-relationship model. Dada
la ambigüedad de la traduc-
ción, en español encontramos
autores que lo traducen como
modelo entidad-relación y otros
que lo traducen como mode-
lo entidad-interrelación. Ambos
conceptos se refieren al mismo
modelo.

-- 12 of 22 --

CC-BY-NC-ND • PID_00213710 13 Introducción al diseño de bases de datos
2.2.2. El lenguaje unificado de modelización
El lenguaje unificado de modelización (UML) es un lenguaje gráfico diseñado
para especificar, visualizar, modificar, construir y documentar un sistema. El
lenguaje UML incorpora una gran cantidad de diagramas que permiten repre-
sentar el modelo de un sistema desde perspectivas diferentes. En relación con
el diseño conceptual de bases de datos, nos interesa especialmente el diagrama
de clases, que permite representar información del dominio de discurso. Los
diagramas de clases son diagramas estáticos que describen la estructura de un
sistema a partir de las clases o tipos de entidad del sistema, sus atributos y las
asociaciones o tipos de relaciones que se establecen entre ellos. Estos diagra-
mas han mostrado una capacidad excelente para la modelización de datos. Por
este motivo, son cada vez más importantes en el diseño conceptual de bases
de datos.
2.3. Fase 3. Diseño lógico
Previamente a la fase de diseño lógico, se debe elegir un tipo de base de datos.
Es decir, no hay que escoger todavía un SGBD concreto, sino que simplemente
hay que seleccionar el tipo de base de datos que se quiere implementar. Es im-
portante que quede claro que el tipo de base de datos determina el esquema de
diseño lógico. Una vez elegido el tipo de SGBD donde se quiere implementar
la base de datos, ya se puede iniciar la fase del diseño lógico.
En la fase de diseño￿lógico se transforma el modelo conceptual, inde-
pendiente del tipo de tecnología, en un modelo lógico dependiente del
tipo de SGBD en el que se quiere implementar la base de datos.
En esta etapa se parte del diseño conceptual desarrollado en el paso anterior y
se obtiene un diseño lógico de la futura base de datos. En esta transformación
se ajusta el modelo considerando el tipo de SGBD en el que se quiere imple-
mentar la base de datos. Por ejemplo, si se quiere crear la base de datos en
un sistema relacional, esta etapa obtendrá un conjunto de relaciones con sus
atributos, sus claves primarias y sus claves foráneas correspondientes.
En esta etapa nos concentramos en las cuestiones tecnológicas relacionadas
con el modelo de la base de datos, asumiendo que en la etapa anterior ya
hemos resuelto la problemática de estructuración de la información desde el
punto de vista conceptual.
Lenguaje UML
El lenguaje unificado de mode-
lización (en inglés, unified mo-
deling language) es un lenguaje
de propósito general para mo-
delizar sistemas de software.
Este estándar fue creado, y ac-
tualmente es mantenido, por
el Object Management Group
(OMG).

-- 13 of 22 --

CC-BY-NC-ND • PID_00213710 14 Introducción al diseño de bases de datos
Por lo tanto, el resultado de esta etapa será un modelo lógico de la estructura
de la información. Generalmente, cuando este modelo lógico hace referencia a
un SGBD relacional, se denomina modelo relacional. En este material nos cen-
traremos en la transformación del modelo conceptual a un modelo relacional,
es decir, a un modelo lógico para una base de datos relacional.
En el diseño lógico se pueden ver tres subfases o partes independientes, que
se aplican de manera secuencial para transformar el modelo conceptual obte-
nido en la fase anterior en un modelo lógico que será el resultado de esta fase.
En primer lugar, en la subfase llamada reconsideraciones del modelo conceptual
revisamos el modelo conceptual para asegurarnos de que está libre de algunos
errores tipificados e identificables. A continuación, se produce la transforma-
ción del modelo conceptual en el modelo lógico y, finalmente, aplicamos la
teoría de la normalización al modelo lógico.
2.3.1. Reconsideraciones del modelo conceptual
En esta primera parte se realiza un análisis en profundidad del modelo con-
ceptual obtenido en la fase anterior, con la intención de detectar y corregir al-
gunos errores que se suelen producir en los modelos conceptuales y que con-
viene detectar y reparar lo antes posible para evitar que se propaguen en fases
posteriores. Dichos errores se denominan trampas de diseño. Es conveniente
conocer cada uno de estos errores y asegurarse de que el modelo conceptual
que se quiere transformar está libre de ellos antes de continuar con el diseño
lógico.
2.3.2. Transformación del modelo conceptual en el modelo
lógico
En estos materiales nos centraremos en el diseño lógico de bases de datos re-
lacionales. Por lo tanto, el modelo lógico generado será aplicable a cualquier
base de datos relacional. Partiremos del resultado de la etapa del diseño con-
ceptual expresado mediante un diagrama de clases UML y veremos cómo se
puede transformar utilizando una estructura de datos del modelo relacional.
Este proceso muestra la manera de llevar a cabo la transformación de los dife-
rentes elementos que forman el modelo conceptual en elementos que consti-
tuyen el modelo lógico o, más concretamente, el modelo relacional.
2.3.3. Normalización
La teoría de la normalización aplica la teoría de conjuntos, la lógica y el álgebra
relacional para formalizar un conjunto de ideas simples, que guían un buen
diseño de bases de datos relacionales.
La teoría de la normalización utiliza las formas normales (FN) para reconocer
los casos en los que no se aplican buenos criterios de diseño. Una relación
está en una forma normal determinada si satisface un conjunto de restriccio-
El modelo relacional
El modelo relacional es el mo-
delo lógico específico para ba-
ses de datos relacionales.

-- 14 of 22 --

CC-BY-NC-ND • PID_00213710 15 Introducción al diseño de bases de datos
nes específicas que son propias de esta forma normal. La infracción de estas
restricciones origina que la relación tenga un conjunto de anomalías y redun-
dancias de actualización no deseables. Las formas normales son declarativas,
es decir, cada forma normal indica las restricciones que se deben cumplir, pero
no describe ningún procedimiento para conseguirlo.
2.4. Fase 4. Diseño físico
Previamente a la fase de diseño físico hay que elegir un SGBD concreto. Hay
que estudiar los diferentes sistemas comerciales o libres que hay en el mercado
y seleccionar un SGBD donde se pueda implementar el sistema de información
que se ha ido gestando en las fases anteriores del proceso de diseño.
Los componentes físicos que forman cada SGBD son específicos. Los fabrican-
tes utilizan estrategias y tecnologías diferentes para maximizar el rendimien-
to de sus sistemas gestores de bases de datos. En este nivel no existe ningún
estándar y, por lo tanto, habrá que adaptar el esquema lógico obtenido en el
paso anterior, teniendo presentes las características de cada sistema gestor. El
diseñador debe considerar los aspectos de implementación física y de eficien-
cia que dependen específicamente del SGBD elegido.
El diseño￿físico es una fase del proceso de diseño de bases de datos que
adapta el esquema lógico obtenido en la fase anterior al SGBD concreto,
que utilizará el sistema de información.
2.4.1. El nivel físico y el nivel virtual
El estudio de los niveles físico y virtual de las bases de datos permite ver as-
pectos como las estructuras de almacenamiento y las rutas de acceso por los
ficheros de la base de datos. Cada SGBD ofrece diferentes opciones para orga-
nizar ficheros y rutas de acceso, y es necesario que el diseñador conozca la
implementación concreta, con el fin de implementar de una manera más efi-
ciente el diseño físico del sistema de información.
También es importante conocer las características de los procesos que consul-
tan y actualizan la base de datos, como por ejemplo las frecuencias de ejecu-
ción y los volúmenes que se espera tener de los diferentes datos que se quieren
almacenar con el fin de conseguir un buen rendimiento de la base de datos.
Algunos criterios importantes que pueden ser útiles para elegir las opciones de
diseño físicas de la base de datos son los siguientes:
• Tiempo￿de￿respuesta. Es el tiempo que transcurre desde que se envía una
petición al SGBD hasta que éste devuelve los datos de la respuesta. Una