# ÍNDICE GENERAL

EPEERINVALID . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 205
Warning: setState(…): Cannot update during an existing state transition . 206
Warning: React attempted to reuse markup in a container but the check-
sum was invalid . . . . . . . . . . . . . . . . . . . . . . . . . . . 207
Module parse failed . . . . . . . . . . . . . . . . . . . . . . . . . . . . 207
El Proyecto Falla al Compilar . . . . . . . . . . . . . . . . . . . . . . . . 207

-- 8 of 226 --

Introducción
El desarrollo del frontend se mueve muy deprisa. Una buena señal de ello es el ritmo
en el que están surgiendo nuevas tecnologías. React1 es uno de los recién llegados.
Incluso cuando la tecnología en sí es sencilla, hay mucho movimiento en torno a ella.
El objetivo de este libro es ayudarte a comenzar con React y darte una perspectiva
del ecosistema que hay en torno a él para que sepas por dónde mirar.
Nuestro desarrollo va a utilizar Webpack. Hay un libro aparte2 que bucea en él, pero
no espero que conozcas Webpack para poder utiliza este libro.
¿Qué es React?
React es una librería JavaScript, creada por Facebook, que basa su funcionamiento en
la abstración de las vistas mediante el uso de componentes. Un componente puede
ser un formulario de entrada, un botón, o cualquier otra cosa del interfaz de usuario.
Esto nos proporciona un interesante contraste con respecto a enfoques anteriores ya
que, por diseño, React no está vinculado al árbol DOM. Puedes utilizarlo por ejemplo
para desarrollar aplicaciones móviles.
React es sólo una Parte del Todo
Para usarlo tendrás que complementarlo con otras librerías que te den aquello que
te falte, ya que React se centra únicamente en la vista. Esto brinda un contraste con
respecto a utilizar frameworks que traen mucho más de serie. Ambos enfoques tienen
sus méritos. En este libro nos centraremos en el uso de librerías.
Las ideas presentadas por React han tenido su influencia el desarrollo de frameworks,
aunque más importante es que nos ha ayudado a entender cómo de bien encaja el
pensar en componentes en el desarrollo de aplicaciones web.
1https://facebook.github.io/react/
2http://survivejs.com/webpack/introduction/

-- 9 of 226 --

Introducción ii
¿Qué Vas a Aprender?
Aplicación Kanban
Este libro te enseña a crear una aplicación de tipo Kanban3. Más allá de esto, deba-
tiremos acerca de aspectos de desarrollo web más teóricos. Completar el proyecto te
dará una buena idea de cómo implementar algo por tí mismo. Durante el proceso
aprenderás por qué ciertas librerías son útiles y serás capaz de justificar mejor la
elección de tus tecnologías.
¿Cómo está Organizado este Libro?
Para comenzar, desarrollaremos un pequeño clon de una famosa aplicación de
TODO4. Esto nos llevará a tener problemas de escalado. A menudo es necesario hacer
cosas de la forma sencilla para entender por qué al final es necesario usar mejores
soluciones.
Empezaremos a generalizar en este punto y comenzaremos a utilizar la arquitectura
Flux5. Usaremos la magia del Drag and Drop (DnD)6 (arrastrar y soltar) para
comenzar a arrastrar cosas por ahí. Al terminar tendremos hecho algo que podremos
poner en producción.
3https://en.wikipedia.org/wiki/Kanban
4http://todomvc.com/
5https://facebook.github.io/flux/docs/overview.html
6https://gaearon.github.io/react-dnd/

-- 10 of 226 --

Introducción iii
La parte final y teórica del libro cubre aspectos más avanzados. Si estás leyendo
la versión comercial del libro encontrarás algo extra para tí. Te mostraré cómo
mejorar al programar con React para que generes código de mayor calidad. También
aprenderás a probar tus componentes y tu lógica mediante tests. Aprenderás a dar
estilo a tu aplicación hecha con React de varias formas y tendrás una mejor idea de
cómo estructurar tu proyecto.
Los apéndices del final sirven para darte cosas en las que pensar y explicar conceptos,
tales como características del lenguaje, en un mayor detalle. Si hay algo de sintaxis
en el libro que te resulte extraño seguramente encuentres más información allí.
¿Qué es Kanban?
Kanban por Dennis Hamilton (CC BY)
Kanban, desarrollado originalmente por Toyota, te permite seguir el estado de las
tareas. Puede ser modelado en conceptos como Carriles y Notas. Las Notas se
mueven entre Carriles que representan etapas que van de izquierda a derecha hasta
que se completan. Las Notas pueden contener información sobre ellas mismas, su
prioridad y toda aquello que sea necesario.
Este sistema puede ser extendido de varias formas. Una manera sencilla consiste en
aplicar un límite de Trabajo En Proceso (WIP) por carril. El objetivo es obligarte a
centrarte en tener tareas terminadas, lo cual es una de las consecuencias positivas de
utilizar Kanban. Mover estas notas entre carriles es satisfactorio, ya que puedes ver
cómo van las tareas y qué tareas hay que hacer todavía.

-- 11 of 226 --

Introducción iv
¿Dónde Podemos Usar Kanban?
Este sistema puede utilizarse en varios escenarios, incluyendo el desarrollo del
software y la gestión eficaz del tiempo. Puedes utilizarlo para hacer un seguimiento
sobre tus proyectos personales o tus metas en la vida, por ejemplo. Aunque sea una
herramienta muy sencilla es muy poderosa y puedes encontrarle un uso práctico en
muchos escenarios.
¿Cómo Construir un Kanban?
La forma más sencilla de construir un Kanban es conseguir un paquete de Post-its
y encontrar una pared. Tras esto, la divides en columnas. Estos Carriles pueden
ser las siguientes etapas: Por Hacer, Haciendo, Hecho. Todas las Notas, inicialmente,
irán en Por Hacer. A medida que trabajes en ellas las irás moviendo a Haciendo y,
finalmente, a Hecho una vez se hayan terminado. Esta es la forma más sencilla de
comenzar.
Pero este es símplemente un ejemplo de cómo configurar los carriles, ya que éstos
pueden definirse para encajar con el proceso que quieras seguir. Por ejemplo, puedes
incluir pasos que requieran aprobación. Si estás modelando un proceso de desarrollo
de software puedes tener, por ejemplo, carriles separados para la realizacion de
pruebas y el despliegue.
Implementaciones de Kanban Disponibles
Quizá Trello7 sea la implementación online más conocida de Kanban. Sprintly ha
liberado su implementación de React de Kanban8. Otro buen ejemplo es wekan9,
basado en Meteor. El nuestro no será tan sotisficado como aquellos, pero será lo
suficientemente bueno para comenzar.
7https://trello.com/
8https://github.com/sprintly/sprintly-kanban
9https://github.com/wekan/wekan

-- 12 of 226 --

Introducción v
¿Para Quién es Este Libro?
Espero que tengas ciertos conocimientos básicos sobre JavaScript y Node.js. Deberías
ser capaz de utilizar npm en un nivel básico. Sería genial que supieras algo sobre React
o ES6, leyendo este libro obtendrás un mayor entendimiento de estas tecnologías.
Una de las cosas más difíciles a la hora de escribir un libro es hacerlo al nivel
adecuado. Dado que el libro en sí cubre mucho terreno hay apéndices que cubren
aspectos básicos, tales como detalles del lenguaje, con un mayor detalle que el
incluido en el contenido principal, así que si te sientes inseguro échale un vistazo.
Además, hay un chat para la comunidad10 disponible. Estamos allí para ayudar si
quieres preguntar algo directamente. Los comentarios que puedas tener ayudarán
a mejorar el contenido del libro. Lo último que quiero tener es a alguien que se
encuentra en apuros mientras está siguiendo el libro.
¿Cómo Abordar el Libro?
Aunque la manera natural de leer un libro es comenzar por el primer capítulo y leer
el resto de capítulos de forma secuencial, esta no es la única manera de abordar este
libro. El orden de los capítulos es únicamente una sugerencia sobre cómo leerlos.
Dependiendo de tus conocimientos previos, puede que ojees la primera parte y
profundices en los conceptos avanzados.
Este libro no cubre todo lo que necesitas saber para desarrollar aplicaciones frontend,
ya que es demasiado para un único libro. Creo, sin embargo, que puede ser capaz de
empujarte en la dirección correcta. El ecosistema en torno a React es enorme y lo he
hecho lo mejor que he podido para cubrir una parte de él.
Dado que el libro se basa en varias características nuevas del lenguaje, he reunido
las más importantes en un apéndice aparte llamado Características del Lenguaje que
te ofrece un rápido resumen a todas ellas. Es un buen lugar que revisar si quieres
entender algunas de estas características por separado o no estás seguro de algo.
10https://gitter.im/survivejs/react

-- 13 of 226 --

Introducción vi
Versionado del Libro
Se ha definido un esquema de versionado severo dado que este libro recibe mucho
mantenimiento y mejoras debido al ritmo de innovación. Mantengo las notas de cada
liberación en el blog del libro11 para indicar qué ha cambiado entre cada versión.
Otra cosa beneficiosa es examinar el repositorio de GitHub, recomiendo utilizar la
comparación de GitHub con este fin, por ejemplo:
https://github.com/survivejs-translations/react-book-es/compare/v2.1\
.0...v2.5.7
Esta página te mostrará los commits individuales que hay en el rango de versiones
indicado. También puedes ver qué lineas han cambiado en el libro. Esto excluye los
capítulos privados, pero será suficiente para que te hagas una idea de qué cambios
se han hecho en el libro.
La versión actual del libro es la 2.5.7.
Material Extra
El contenido del libro y el código fuente están disponibles en el repositorio del libro
de GitHub12. Por favor, sé consciente de que la rama por defecto es dev y que esto
facilita que sea posible contribuir. Puedes utilizar el selector de etiquetas de GitHub
para encontrar el fuente que encaje con la versión del libro que estás leyendo, tal y
como se muestra a continuación:
11http://survivejs.com/blog/
12https://github.com/survivejs/react

-- 14 of 226 --

Introducción vii
selector de etiquetas de GitHub
El repositorio del libro contiene el código de cada capítulo. Esto significa que puedes
comenzar desde cualquier punto sin tener que escribirlo todo por tí mismo. Si no
estás seguro de algo, siempre puedes usarlo como referencia.
Puedes encontrar mucho más material complementario en el repositorio de survi-
vejs13. Hay implementaciones alternativas disponibles de la aplicación escritas en
MobX14, Redux15, y Cerebral/Baobab16. Estudiarlas puede darte una buena idea sobre
cómo funcionan las distintas arquitecturas utilizando el mismo ejemplo.
Cómo Obtener Soporte
Dado de ningún libro es perfecto, puede que quieras presentarme cuestiones y
problemas que te hayan surgido relacionadas con el contenido. Hay un par de formas
de conseguirlo:
• Contacta conmigo a través de el sistema de incidencias de GitHub17
13https://github.com/survivejs/
14https://github.com/survivejs/mobx-demo
15https://github.com/survivejs/redux-demo
16https://github.com/survivejs/cerebral-demo
17https://github.com/survivejs/react/issues

-- 15 of 226 --

Introducción viii
• Súmate al chat de Gitter18
• Sigue @survivejs19 en Twitter para recibir novedades oficiales o dame un
codazo directamente a través de @bebraw20
• Mándame un correo a info@survivejs.com21
• Pregúntame cualquier cosa sobre Webpack o React en SurviveJS AmA22
Si haces preguntas en Stack Overflow23, etiquétalas utilizando survivejs24 para que
pueda recibir notificaciones. También puedes utiliza el hashtag #survivejs en Twitter.
He tratado de cubrir algunos problemas comunes en el apéndice Solución de Proble-
mas, el cual crecerá a medida que se vayan encontrando más problemas comunes.
Notificaciones
Notifico noticias relacionadas con SurviveJS en un par de canales:
• Lista de Correo25
• Twitter26
• RSS del Blog27
Siéntete libre de subscribirte.
18https://gitter.im/survivejs/react
19https://twitter.com/survivejs
20https://twitter.com/bebraw
21mailto:info@survivejs.com
22https://github.com/survivejs/ama/issues
23http://stackoverflow.com/search?q=survivejs
24https://stackoverflow.com/questions/tagged/survivejs
25http://eepurl.com/bth1v5
26https://twitter.com/survivejs
27http://survivejs.com/atom.xml

-- 16 of 226 --

Introducción ix
Agradecimientos
No habría sido posible realizar un esfuerzo como este sin el apoyo de la comunidad.
Como resultado ¡hay mucha gente a la que dar las gracias!
Un enorme agradecimiento a Christian Alfoni28 por comenzar el libro react-webpack-
cookbook29 conmigo. Aquel trabajo finalmente lideró este libro y finalmente se
convirtió en un libro por sí mismo30.
Este libro no podría ser la mitad de bueno sin la paciencia y el feedback de mi editor
Jesús Rodríguez Rodríguez31. Gracias.
Un agradecimiento especial para Steve Piercy por sus numerosas contribuciones.
Gracias a Prospect One32 y Dixon & Moe33 por ayudarme con el logo y el aspecto
gráfico. Gracias por las revisiones a Ava Mallory y EditorNancy de fiverr.com.
Muchas personas a título individual han dado soporte y feedback a lo largo del
camino. Gracias en un order sin nada en particular a Vitaliy Kotov, @af7, Dan
Abramov, @dnmd, James Cavanaugh, Josh Perez, Nicholas C. Zakas, Ilya Volodin,
Jan Nicklas, Daniel de la Cruz, Robert Smith, Andreas Eldh, Brandon Tilley, Braden
Evans, Daniele Zannotti, Partick Forringer, Rafael Xavier de Souza, Dennis Buns-
koek, Ross Mackay, Jimmy Jia, Michael Bodnarchuk, Ronald Borman, Guy Ellis,
Mark Penner, Cory House, Sander Wapstra, Nick Ostrovsky, Oleg Chiruhin, Matt
Brookes, Devin Pastoor, Yoni Weisbrod, Guyon Moree, Wilson Mock, Herryanto
Siatono, Héctor Cascos, Erick Bazán, Fabio Bedini, Gunnari Auvinen, Aaron McLeod,
John Nguyen, Hasitha Liyanage, Mark Holmes, Brandon Dail, Ahmed Kamal, Jordan
Harband, Michel Weststrate, Ives van Hoorne, Luca DeCaprio, @dev4Fun, Fernando
Montoya, Hu Ming, @mpr0xy, David “@davegomez” Gómez, Aleksey Guryanov,
Elio D’antoni, Yosi Taguri, Ed McPadden, Wayne Maurer, Adam Beck, Omid Heza-
veh, Connor Lay, Nathan Grey, Avishay Orpaz, Jax Cavalera, Juan Diego Hernández,
Peter Poulsen, Harro van der Klauw, Tyler Anton, Michael Kelley, @xuyuanme,
@RogerSep, Jonathan Davis, @snowyplover, Tobias Koppers, Diego Toro, George
28http://www.christianalfoni.com/
29https://github.com/christianalfoni/react-webpack-cookbook
30http://survivejs.com/webpack/introduction
31https://github.com/Foxandxss
32http://prospectone.pl/
33http://dixonandmoe.com/

-- 17 of 226 --

Introducción x
Hilios, Jim Alateras, @atleb, Andy Klimczak, James Anaipakos, Christian Hettlage,
Sergey Lukin, Matthew Toledo, Talha Mansoor, Pawel Chojnacki, @eMerzh, Gary
Robinson, Omar van Galen, Jan Van Bruggen, Savio van Hoi, Alex Shepard, Derek
Smith, Tetsushi Omi, Maria Fisher, Rory Hunter, Dario Carella, Toni Laukka, Blake
Dietz, Felipe Almeida, Greg Kedge, Deepak Kannan, Jake Peyser, Alfred Lau, Tom
Byrer, Stefanos Grammenos, Lionel Ringenbach, Hamilton Greene, Daniel Robinson,
@karloxyz, Nicolò Ribaudo, Andrew Wooldridge, Francois Constant, Wes Price,
Dawid Karabin, @alavkx, Aitor Gómez-Goiri, P.E. Butler III, @TomV, John Korzhuk,
@markfox1, Jaime Liz, Richard C. Davis, y muchos otros. Si no he puesto tu nombre
puede que haya olvidado incluirlo.

-- 18 of 226 --

I Comenzando
React ha tenido un impacto significativo en la comunidad de desarrolladores de
frontend a pesar de ser una librería reciente. Introduce conceptos, como el DOM
virtual, y ha hecho que la comunidad entienda el poder de los componentes. Su dieño
orientado a componentes funciona bien con la web, aunque React no está limitado
a la web, puedes utilizarlo para desarrollar aplicaciones móviles e incluso interfaces
de usuario que funcionen por una terminal.
En este apartado comenzaremos a bucear dentro de React e implementaremos una
pequeña aplicación de notas. Esto es algo que en algún momento se convertirá en un
Kanban. Aprenderás lo más basico de React y te acostumbrarás a trabajar con él.

-- 19 of 226 --