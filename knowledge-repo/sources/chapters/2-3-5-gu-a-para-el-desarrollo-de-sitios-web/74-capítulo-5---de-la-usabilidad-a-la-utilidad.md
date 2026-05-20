# Capítulo 5: - De la Usabilidad a la Utilidad

www.guiaweb.gob.cl > 113
haría en una situación real de uso. Además,
los problemas que se detectan normalmente
identifican las principales dificultades que
tienen los usuarios ante el sistema que se
les ofrece.
Gracias a este trabajo, es posible identificar
de manera rápida y simple los problemas, dejando lecciones para que los encargados
del desarrollo de las aplicaciones, puedan hacer correcciones que lleven a un mejor
uso del sistema. Adicionalmente permite aislar las percepciones de los usuarios
sobre un sistema, respecto del uso real que le dan al mismo, generando
observaciones más objetivas acerca de la calidad del sistema probado.
No obstante, para que un sistema pueda ser probado adecuadamente mediante este
sistema se debe seguir un protocolo estricto que permita ver al usuario en acción,
sin que éste se reste de hacer la prueba como si estuviera usando de verdad el
sistema. Para ello es imprescindible tener en cuenta lo siguiente:
Se debe convencer al usuario de que lo que está a prueba no son sus habilidades,
sino el sistema; si éste no funciona será culpa del sistema y no del usuario. Por
lo mismo, es esperable que diga en voz alta todo lo que le pasa por la mente
cuando está haciendo la prueba, para que el equipo de desarrollo pueda entender
cuáles son sus expectativas y por qué ellas no se cumplen.
Cada acción que se solicite realizar al usuario debe tener un objetivo claro a ser
medido, con el fin de entender cuáles son las dificultades que enfrenta y cómo
podrían atenderse al ver su forma de usar la interfaz.
En ningún momento del test se deberá “ayudar” o retroalimentar al usuario
explicándole cómo hacer una acción, debido a que se espera ver la usabilidad
del sistema por sí mismo, es decir en las mismas condiciones en que funcionará
cuando esté a disposición de todos los usuarios vía web.
A excepción de sistemas que estén dirigidos a una audiencia específica,
cualquier persona que sepa usar un computador podría ser elegido para hacer
el test de usuario. Es importante que quienes sean elegidos sean representativos
de los usuarios que utilizarán finalmente el sistema.
La ventaja principal de un
Test de usuario es que se
puede ver en forma directa
cómo es utilizado un sistema
y no sólo las percepciones
que se tienen de él.

-- 113 of 122 --

Respecto del número de usuarios que se debe empelar en un test de este tipo,
Nielsen señala que cinco personas13 es el número más adecuado.
En el sitio web se entrega una Pauta de Test de Usuario que puede emplearse como
modelo para este tipo de tests.
> Metodología de Alan Cooper
Uno de los problemas más habituales que tienen los desarrolladores de Sitios Web,
es la dificultad para entender las necesidades que tienen los usuarios que llegan a
visitar estos espacios digitales. Habitualmente lo que hacen es conseguir que un
determinado software funcione adecuadamente, aunque no necesariamente ligado
a la actividad de un usuario en particular lo que lleva a que no siempre logre ser
entendido y utilizado completamente por estos.
Para atender esta problemática, el consultor Alan Cooper desarrolló una metodología
de “diseño orientado a metas” a través del cual se trabaja directamente con la
interacción que tendrán los usuarios con los sistemas que se están desarrollando.
Dicha metodología implica el desarrollo de una serie de piezas gráficas en las que
se ilustra la manera en que los usuarios trabajan con el sistema y mediante esta
fórmula, se busca responder de la mejor manera a las necesidades que tienen los
usuarios de los sistemas que se les ofrecen.
> Creación de Personas y Escenarios
Como parte integral de dicha metodología se creó el concepto de “persona”14 que
corresponde a personajes determinados aunque ficticios, que permiten entender de
manera clara quiénes serán los usuarios del mismo y más tarde el de “escenarios”15
,
que corresponden a las situaciones en que dichos personajes emplearán el sistema.
La forma de utilizar dichos conceptos se explica de la siguiente manera: “Creamos
modelos de datos y flujos de trabajo para definir los procesos de negocio.
Modelamos arquetipos de usuarios que son las personas para entender sus metas
y modelos mentales. Para encontrar el diseño de interacción adecuado, ponemos a
las personas en escenarios y desarrollamos bosquejos gráficos que siguen los caminos
más relevantes en las interfaces. Aplicamos posprincipios de diseño y las plantillas
114 < www.guiaweb.gob.cl
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile
13.- Ver más información en http://www.useit.com/alertbox/20000319.html
14.- La palabra “persona” se usa en idioma inglés. Puede revisarse más información acerca de este tema en
http://www.cooper.com/insights/journal_of_design/articles/the_origin_of_personas_1.html
15.-Más información en http://www.cooper.com/insights/journal_of_design/articles/six_sigma_and_goaldirected_des.html

-- 114 of 122 --

para construir una solución. Mientras más avanzamos adquirimos más confianza
en lo que desarrollamos y definimos la conducta de las funciones menos usadas y
diseñamos nuestra solución con mejores niveles de fidelidad. En cada paso, docu-
mentamos los cambios en nuestro diseño de manera que podamos comunicarlos a
todos los miembros de nuestro equipo de desarrollo”.
Esta metodología tiene un uso muy importante al momento de definir las funcio-
nalidades de un sitio web, ya que al definir a los personajes que utilizarán y las
situaciones en que los emplearán, será más fácil que todo el equipo de desarrollo
determine los límites de las funcionalidades y contenidos que debe poner en cada
pantalla16
.
Por ejemplo, para un sitio que ofrezca
trámites de un servicio determinado, será
importante 	determinar 	quiénes 	son 	los
usuarios habituales del mismo. Si se sabe
que son de la tercera edad y con limitados
conocimientos sobre el uso del computador,
se podrá diseñar una “persona” que sea un
hombre que sólo quiere realizar el trámite
en el menor número de pasos posibles, con una interfaz con la menor cantidad de
elementos tecnológicos y la mayor simplicidad posible, con el fin de hacer la
acción que se necesita y terminar consiguiendo un comprobante que le ayude
posteriormente a demostrar que ya hizo la gestión.
Como parte del uso de esta metodología se puede bautizar a la “persona” como “Don
Tito”, indicar que se trata de un jubilado. Luego, se podrá definir que el “escenario”
consistirá en que utilizará el trámite desde un infocentro donde es improbable que
pueda recibir ayuda lo que determinará que la pantalla debe ser lo más simple
posible y que esperará salir de allí con un documento impreso que lleve un timbre, tal
como si hubiera ido a la oficina del servicio. Al conocer estos requerimientos, todo el
equipo de desarrollo entenderá muy bien lo que tiene que hacer y su respuesta será
diferente que si sólo se hablara del “usuario” en términos genéricos.
En el sitio web se entrega una muestra gráfica de una Persona y Escenario que
puede emplearse como modelo para implementar esta metodología en forma
práctica.