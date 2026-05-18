# Capítulo 4: - Cómo se llega al sitio web

www.guiaweb.gob.cl > 87
Lo primero que se analiza es el código
HTML puesto que en la medida que el sitio
web se desarrolle mediante el uso de código
estándar habrá mayores posibilidades de
que su posicionamiento sea mayor.
Estándares y Códigos relacionados
Aunque la Encontrabilidad de un sitio web tiene una serie de elementos desde los
cuales se puede explicar su buen resultado en los buscadores, la calidad de su código
es uno de lo más relevantes.
Como se ha explicado antes, el código del sitio web debe ser estándar y por lo
mismo ofrecer un cumplimiento concreto en el uso de las etiquetas HTML a lo
largo de sus páginas, siendo las de la zona del <head> las más relevantes.
Etiquetas de <head>
Las páginas web bien estructuradas dividen su contenido en las zonas de <head> y
<body>. La primera se ubica en la parte superior de las páginas y entrega información
de referencia para el sistema computacional que utiliza y despliega la página, a fin de
que pueda entender de qué manera se ha codificado el contenido y de esa manera
mostrarlo adecuadamente a través del browser o programa navegador que se utilice.
Respecto de la Encontrabilidad, las etiquetas sobre las que hay que poner la mayor
atención son las siguientes:
<title>: permite indicar el título que aparece en el encabezado de la ventana
de cada página del sitio web 7
; se recomienda que lleve el nombre del sitio web
más un título que describa el contenido de la página. Por ejemplo: “Ministerio
del Interior - Chile: Acerca del Ministro”. De esta manera, esta información será
la que aparezca en los buscadores cuando se muestre el enlace al usuario que
busca alguna palabra o frase que tenga dicha página.
<meta>: una de las etiquetas “meta” de esta sección está orientada a dar
una instrucción concreta a los robots de búsqueda, cual es la de indexar el
contenido 8
. Para ello, su texto debe indicar lo siguiente:
Es importante considerar que los modificadores que se agregan al elemento
“content” tienen efecto sobre el buscador, de la siguiente manera:
7.- Más información de este tema en la sección “Encabezado de Página” del Capítulo 2 y sección “Uso de logotipos” del Capítulo 3 de esta
versión de la Guía Web.
8.- Más información en http://www.robotstxt.org/wc/meta-user.html
Robots.txt: se recomienda
visitar el sitio
http://www.robotstxt.org/
para obtener información
acerca del uso de este
protocolo.

-- 87 of 122 --

88 < www.guiaweb.gob.cl
index: indica que el contenido debe ser indexado.
noindex: indica que el contenido no debe ser indexado.
follow: indica que los enlaces existentes en la página deben ser seguidos.
nofollow: indica que los enlaces existentes en la página no deben ser seguidos.
Uso de robots.txt
En forma paralela a lo que se indique en cada página, para el sitio se debe
generar un archivo que cumple una función similar a la señalada para la etiqueta
<meta> anterior, cual es la de indicar a los robots de los buscadores cuál es la
acción global que debe desarrollar en el sitio web.
Para ello, en la raíz del servidor se debe incluir un archivo de texto que lleve el
nombre robots.txt y en el que se indique la información acerca de la acción a
desarrollar9
. El contenido estándar10 está dado por dos líneas, que son las siguientes:
Se debe considerar que la línea “User-agent” puede incluir el nombre de cualquier
robot y que si tiene un asterisco, indica que la directiva se aplica a todos; en tanto
que la línea “Disallow” permite indicar los directorios del sitio web que no se desee
incluir en la indexación. Si está en blanco, indica que permite indexar todo el
contenido del sitio web.
Es importante considerar que este archivo es revisado por todos los robots de
búsqueda que acceden al sitio web por lo que es muy importante su presencia, ya
que constituye una de las buenas prácticas en torno a los buscadores, debido a que
forman parte de una suerte de bienvenida formal a todos los programas enviados
por los sistemas de búsqueda de Internet.
Cómo mostrar contenidos
De acuerdo a lo indicado en los párrafos precedentes, el sitio web deberá cumplir
con tener los siguientes elementos para asegurar que los buscadores de Internet los
indexen:
<meta>: en esta sección la línea debe indicar lo siguiente:
<META NAME="robots" content="index,follow">
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile
9.- Ver Capítulo IV Guía Web, http://www.guiaweb.gob.cl/guia/capitulos/cuatro/queprobar.htm#t03robots
10.- Más información en http://www.robotstxt.org/wc/exclusion.html
User-agent: *
Disallow:

-- 88 of 122 --