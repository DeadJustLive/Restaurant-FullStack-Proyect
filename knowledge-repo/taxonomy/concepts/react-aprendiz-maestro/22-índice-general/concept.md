# ÍNDICE GENERAL

## Fuente
react-aprendiz-maestro (Cap. 22)

## Contenido
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
Este sistema puede utilizarse en varios escenarios, incluyendo el desarr
