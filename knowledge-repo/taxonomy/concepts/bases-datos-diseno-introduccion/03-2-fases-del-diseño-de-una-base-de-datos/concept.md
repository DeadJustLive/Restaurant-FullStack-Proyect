# 2. Fases del diseño de una base de datos

## Fuente
Jordi Casas Roma (Cap. 3)

## Contenido
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
(4)DFD es la sigla de la 
