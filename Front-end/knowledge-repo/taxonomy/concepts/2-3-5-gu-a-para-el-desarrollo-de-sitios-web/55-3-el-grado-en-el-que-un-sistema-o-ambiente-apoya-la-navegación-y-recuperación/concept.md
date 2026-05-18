# 3. El grado en el que un sistema o ambiente apoya la navegación y recuperación

## Fuente
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile (Cap. 55)

## Contenido
# 3. El grado en el que un sistema o ambiente apoya la navegación y recuperación

por sus contenidos.
Por lo mismo, podemos entender que la calidad de "encontrable" de un sitio web
dependerá de dos aspectos: su capacidad para ser encontrado a través de los sistemas
de búsqueda de Internet y, una vez que los usuarios decidan llegar al sitio web, de la
calidad de la navegación que encuentren internamente en el propio sitio.
Esto representa desafíos interesantes para el administrador del sitio web, ya que
siempre deberá estar mirando ambos aspectos para tener la seguridad de que la
experiencia que se ofrece a través de sus páginas, es coherente con las expectativas
de quien llega a visitarlo.
> Sitios visibles e invisibles
Uno de los desafíos más importantes de todo administrador de un sitio web consiste
en permitir que sus contenidos sean indexados por los sistemas de búsqueda de
Internet.
Esta característica debe tener en cuenta el hecho de que el sitio web debe estar tanto
preparado para ser indexado por sistemas automatizados, los cuales están basados en
programas (conocidos como robots de búsqueda o spiders) que navegan a través de
los enlaces ofrecidos por el sitio web y que le permiten descubrir las páginas de
contenidos disponibles. Lo anterior significa que cada página debería ofrecer enlaces
en lenguaje HTML4 hacia el resto del sitio web y, por lo mismo, que ninguna página
del sitio debería estar aislada del resto.
Para apoyar esta tarea, que ya se revisó en detalle en el Capítulo 3 en el subtítulo
referido a “Sistema de Navegación”, es imprescindible que haya enlaces en cada una
de las páginas que hagan referencia al resto del Sitio Web, en particular que lleven a
la Portada y al Mapa del Sitio. Esta última página, a la que siempre se le da poca
importancia, cobra a partir de esta circunstancia una relevancia mayor ya que es una
colección de enlaces que debe ser visitada por el sistema de indexación de los busca-
dores porque constituye el punto de entrada al sitio web.
En este sentido es interesante tener en cuenta el trabajo "Características de la Web
Chilena 2006"5 llevado a cabo por el Centro de Investigación de la Web de la
4.- Enlaces del tipo <a href.=...> que puedan ser seguidos por los robots.

-- 79 of 122 --

80 < www.guiaweb.gob.cl
Universidad de Chile, que dirige el profesor
Ricardo Baeza-Yates, a través del cual se
determinó que el 21,4% de los sitios chilenos
muestra una sola página.
En dicho estudio se indica que dentro de los
motivos 	por 	los 	cuales 	se 	encuentra
solamente una página en el sitio, destacan
los siguientes:
La página basa su navegación en la tecnología Javascript, por lo que es
necesario interpretar dicho código para navegarla; como los robots de búsqueda
no lo hacen, aparece como que no existen más y el contenido que exista no
se incluye.
La página necesita un plug-in de la tecnología Flash para visualizar su conte-
nido; esto ocurre habitualmente en sitios que tienen una introducción animada
que puede ser vista por humanos, pero que no ofrece puntos de entrada para el
robot de búsqueda; por lo tanto, para éste el sitio sólo tiene una página.
Lo anterior también es válido para aquellas páginas que emplean tecnología
basada en Applets Java para la navegación, los cuales también impiden el acceso
a los programas automáticos.
En los tres casos señalados se da el fenómeno que los robots de búsqueda no logran
entender la sintaxis ofrecida en el código, ya que normalmente en los tres casos
señalados de haber enlaces hacia el resto del sitio, estos se ofrecen desde el interior
de programas que deben ser interpretados y no mediante enlaces basados en HTML.
Debido a esto, en dichos casos los robots no logran encontrar la forma de tener acce-
so al interior del sitio web y sólo guardan la información de la portada del sitio web.
Cabe indicar que, tal como se explica más adelante en este capítulo, en los tres casos
señalados existen formas de ofrecer acceso alternativo a los robots de búsqueda, faci-
litando el acceso de estos al sitio pese al uso de dichas tecnologías en la portada.
> Posicionamiento del Sitio Web
Una tarea permanente del administrador del sitio web será la de determinar la
posición relativa del sitio web en los sistemas de búsqueda, respecto de las pala-
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile
5.- Ver el estudio en http://www.ciw.cl/material/web_chilena_2006/index.html
Más información sobre
Ricardo Baeza-Yates se
puede encontrar en el sitio
http://www.dcc.uchile.cl/~r
baeza/spanish.html.

-- 80 of 122 --
