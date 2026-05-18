# Capítulo 2: - Aplicación de Estándares

www.guiaweb.gob.cl > 39
La diagramación con tablas se usó habitualmente desde el inicio de los Sitios Web
y el problema con esta forma de trabajo se relacionaba con el hecho de que los
contenidos se unían con el código utilizado en la presentación, evitando que el
sitio web pudiera ser usado en plataformas diferentes sin adecuarlo previamente.
Gracias al uso de las hojas de estilo en cascada,
esta situación pudo mejorarse ya que el contenido
se pudo mantener inalterable y sólo hacer los
cambios en la capa de la presentación, lo que per-
mitió llevar dichos contenidos a cualquier platafor-
ma, sólo haciendo cambios en el estilo de diagra-
mación, el cual se define a través del archivo CSS relacionado a la página.
Otro elemento importante en la diagramación usando las hojas de estilo, es la
revisión de lo que ocurre cuando ellas no están presentes. En este sentido, se debe
tender a que el sitio web se degrade “aceptablemente”, vale decir, que sus conte-
nidos no se vean diagramados con la presentación gráfica habitual pero que al
menos puedan entenderse adecuadamente. Para hacer este experimento, existen
una serie de herramientas que facilitan la revisión, destacando entre ellas las
extensiones para el navegador Firefox Versión 2:
Firebug15
: software que ocupa la parte inferior de la pantalla y va mostrando el
código fuente a medida que se desplaza el cursor sobre el sitio web que se
revisa; ofrece mucha información acerca de su código fuente.
CSS Viewer16 : comando que permite ver el estilo utilizado en la página que se
revisa, a medida que se desplaza el mouse sobre la página web.
Web Developer17 : barra de herramientas con gran cantidad de opciones para
revisar el sitio web.
Mozilla Accessibility Extension18
: barra de herramientas con todas las opciones
necesarias para revisar la accesibilidad del sitio web.
Es importante considerar que al final de este capítulo se ofrecen archivos para
trabajar en la incorporación de CSS a una página web de manera práctica.
15.- Se puede obtener en http://www.getfirebug.com/
16.- Se puede obtener en https://addons.mozilla.org/es-ES/firefox/addon/2104
17.- Se puede obtener en http://chrispederick.com/work/web-developer/
18.- Se puede obtener en http://cita.disability.uiuc.edu/software/mozilla/
La fecha para dar
cumplimiento al Nivel II
del DS100/2006 es el
12 de agosto de 2008.

-- 39 of 122 --

Utilización de Marcos (DS100/2006 Art. 11°)
Este artículo indica que los marcos o "frames" que se utilicen para mostrar el
contenido de los Sitios Web, "deben ofrecer información adecuada al usuario" para
que éste no tenga dificultades de navegación o pierda los enlaces que se ofrecen
dentro del propio sitio web.
El tema de los marcos ya había sido abordado
en la Guía Web Versión 1.019 donde se expli-
caba que dicha tecnología "consiste en agru-
par varios archivos para que se desplieguen de
manera simultánea, permitiendo a los usuarios
ver varios contenidos al mismo tiempo". Se
mostraban asimismo las ventajas y desventajas de la misma y se planteaba que " esta
forma de organizar los Sitios Web debe desecharse para pasar a sitios de interfaz
contenida en un solo archivo."
Si bien se entiende que esta actividad se puede hacer en un periodo de tiempo adecuado,
en tanto se siguen usando los marcos, se deben tener las siguientes consideraciones:
La información contenida en la sección <noframes> que se inserta dentro de la
etiqueta <frameset> debe contener datos adecuados acerca del contenido del sitio
web e idealmente, entregar enlaces que permitan acceder a contenidos en el
interior del sitio web.
Los enlaces que salgan de los marcos deben utilizar siempre el modificador
"target" en la etiqueta <a>, con el objetivo de que el enlace siempre llegue hacia
uno de los marcos cuyo nombre se indica; hacia la ventana donde están
contenidos los marcos usando el modificador “target=_top” o bien hacia una
ventana nueva usando el modificador “target=_blank”.
Los buscadores de Internet pueden tener indexado el contenido de los marcos
por separado, lo que podría motivar su apertura sin los demás archivos que le dan
contexto a las páginas. Para ello se aconseja programar a nivel de servidor para
que cada vez que se solicite una página por separado, ésta se muestre con los
marcos relacionados.
Uso de Plug-ins (DS100/2006 Art. 12°)
Este artículo indica que en caso de que se emplee software adicional al sitio web
para mostrar contenidos específicos, se debe proporcionar el visualizador corres-
40 < www.guiaweb.gob.cl
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile
Se puede encontrar
una colección histórica
de browsers en
http://browsers.evolt.org/
19.- Ver información al respecto en http://www.guiaweb.gob.cl/guia/capitulos/tres/accesorapido.htm#t04frames

-- 40 of 122 --

pondiente de manera gratuita, ya sea que puedan ser bajados del propio sitio web
como desde el sitio web de la empresa que lo ofrezca.
El 	objetivo 	de 	esta 	medida 	es 	que 	los
usuarios no deban comprar un software para
acceder a los contenidos de los Sitios Web,
sino que siempre tengan alternativas gratuitas
para revisar la información que se les ofrece.
Cabe recordar en este sentido, que lo anterior también implica que los Sitios Web
no deben ofrecer archivos para los cuales no haya visualizadores gratuitos o que
pertenezcan a formatos propietarios, aunque se suponga que todo el mundo tenga
dichos software.
Los visualizadores más habituales y sus ubicaciones vía web son los siguientes:
Adobe-PDF:
http://www.latinamerica.adobe.com/products/acrobat/readstep2.html
MS-Excel: http://www.microsoft.com/downloads/details.aspx?
familyid=c8378bf4-996c-4569-b547-75edbd03aaf0&displaylang=es
MS-Word: http://www.microsoft.com/downloads/details.aspx?
familyid=95E24C87-8732-48D5-8689-AB826E7B8FDF&displaylang=es
MS-PowerPoint: http://www.microsoft.com/downloads/details.aspx?
familyid=428D5727-43AB-4F24-90B7-A94784AF71A4&displaylang=es
Accesibilidad (DS100/2006 Art. 13°)
Este artículo señala que los Sitios Web deben ser accesibles usando diferentes tipos
de navegadores (browser o programa para ver Sitios Web), de los cuales al menos
uno debe ser gratuito y estar disponible en el propio sitio web para que sea obte-
nido por los usuarios.
El objetivo de esta medida es terminar con la “optimización" que habitualmente se
hace en los Sitios Web para que puedan ser vistos a través de un navegador en
particular.
Asimismo, al no existir optimización del navegador, se debe trabajar para que el
sitio web cumpla los estándares web, ya que de esa manera se puede asegurar que