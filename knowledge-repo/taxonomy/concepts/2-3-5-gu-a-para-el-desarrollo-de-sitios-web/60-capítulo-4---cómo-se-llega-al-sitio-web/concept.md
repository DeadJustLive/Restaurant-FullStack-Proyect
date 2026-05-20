# Capítulo 4: - Cómo se llega al sitio web

## Fuente
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile (Cap. 60)

## Contenido
# Capítulo 4: - Cómo se llega al sitio web

www.guiaweb.gob.cl > 89
robots.txt: en este archivo el contenido
debe indicar lo siguiente:
User-agent: *
Disallow:
Cómo esconder contenidos
Para evitar que el contenido del sitio web
sea indexado, se debe tener el siguiente
contenido en las páginas que no se desee incluir en los sistemas de búsquda:
<meta>: en esta sección la línea debe indicar una de los siguientes contenidos:
<META NAME="robots" content="noindex,follow">
<META NAME="robots" content="noindex,nofollow">
Con el primero se consigue no indexar el contenido, pero que el robot siga los
enlaces ofrecidos; con el segundo se consigue que no haya indexación ni que
se sigan los enlaces existentes.
robots.txt: en este archivo el contenido debe indicar lo siguiente, dependiendo
del caso:
User-agent: *
Disallow: /
Con la primera línea se indica que la instrucción es para todos los robots y con
la segunda, se señala que desde la raíz en adelante, no se debe indexar nada.
User-agent: *
Disallow: /fotos/
Con la primera línea se indica que la instrucción es para todos los robots y con
la segunda, se señala que el directorio llamado fotos no debe ser indexado.
Uso de sitemaps.xml
Como se revisó en las páginas anteriores, una de las dificultades más importantes
referidas a la indexación en buscadores dice relación con la manera de indicar a
Sitemaps.xml: se recomienda
visitar el sitio
http://www.sitemaps.org/es/
protocol.php para obtener
información acerca del uso
de este protocolo.

-- 89 of 122 --

estos sistemas cuáles son las direcciones de las páginas web que se desea incluir
en ellos.
Para enfrentar este tema, desde los sistemas de búsquedas se planteó el uso de un
protocolo denominado Sitemaps que consiste en un archivo XML en el que se enu-
meran todas las URL de un sitio junto, a las que se agregan metadatos adicionales
acerca de cada una de ellas. Por ejemplo, se indica la fecha de la última actualización,
la frecuencia de modificación de sus contenidos y la importancia relativa de la
página en el sitio.
Un archivo estándar de este tipo tiene el siguiente contenido:
<?xml version="1.0" encoding="UTF-8"?>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
<url>
<loc>http://www.example.com/</loc>
<lastmod>2005-01-01</lastmod>
<changefreq>monthly</changefreq>
<priority>0.8</priority>
</url>
</urlset>
Los elementos que se definen por cada línea son los siguientes11 :
<urlset>: su contenido es obligatorio y es el que permite encapsular el archivo,
haciendo referencia al protocolo sitemaps vigente.
<url>: también es obligatorio y es la etiqueta que permite definir cada una de
las páginas web diferentes que se desea incluir en el archivo.
<loc> también es obligatorio y permite indicar la dirección o URL de la página
que se incluye. Debe comenzar con el protocolo correspondiente (http en el caso
del web) y termina con un slash (barra diagonal).
<lastmod>: es un valor opcional que permite indicar la fecha de la última modi-
ficación del archivo que se está incluyendo; para la fecha se usa el formato
AAAA-MM-DD.
<changefreq>: es un valor opcional que hace referencia a la frecuencia con la
90 < www.guiaweb.gob.cl
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile
11.- Se puede ver más información en http://www.sitemaps.org/es/protocol.php

-- 90 of 122 --

que cambia la página a la que se hace referencia; sus valores son en idioma
inglés y corresponden a siempre (always), cada hora (hourly), diariamente
(daily), semanalmente (weekly), mensualmente (monthly), anualmente (yearly)
y nunca (never). Es importante considerar que el valor "always" se utiliza para
describir documentos que cambian cada vez que se accede a ellos, mientras que
"never" se utiliza para describir URL archivadas.
<priority>: es un valor opcional que permite informar a los motores de
búsqueda las páginas que se consideran más importantes dentro del sitio web. Los
valores aceptados abarcan desde 0,0 a 1,0. La prioridad predeterminada de una
página es 0,5. De acuerdo a la información del protocolo, los motores de búsqueda
pueden utilizar esta información para elegir entre varias URL del mismo sitio.
Es importante considerar que el protocolo Sitemaps es un estándar que ya fue
aceptado por Google, Yahoo! y LiveWeb, lo que garantiza que su uso permite
atender a los principales buscadores actuales de la Internet.
Una vez que el archivo ha sido creado y contiene todas las direcciones de páginas
web que se desea indexar, hay que hacer referencia de él al sitio web mediante una
de las siguientes actividades:
Mediante la interfaz de envío del motor de búsqueda: se debe consultar la
documentación ofrecida por los propios motores de búsqueda, los que indican
la forma de hacerlo.
Mediante el archivo robots.txt: se debe añadir una línea al final del archivo que
consigne la ubicación del archivo con el sitemap. Dicha línea deben indicar:
Sitemap: <ubicación_sitemap>
De acuerdo a lo que se indica en el sitio web en que se difunde este pro
