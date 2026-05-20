# Capítulo 2: - Aplicación de Estándares

www.guiaweb.gob.cl > 47
Si al documento anterior se le agrega la siguiente hoja de estilos (que en este caso
se define en el propio documento):
Se puede ver que la sección identificada por el id="sitio-web" va a aparecer
alineada en forma justificada y con su texto en 12 puntos de altura; adicionalmente
su título marcado por <h1> se verá en letras cursivas de color verde.
Mientras que la sección identificada por el id="pagina-web" va a heredar las
características de la anterior -porque es un bloque que está inserto en éste pero
tendrá una columna más angosta por la indentación que se indica, mientras que
su titular -marcado con <h2> será de color verde pero en estilo normal.
Otro uso muy interesante de la etiqueta <div> es la de expresar posiciones de los
bloques de contenido en el sitio web, gracias a lo cual se puede diagramar la infor-
mación de una manera adecuada a la plataforma en que se esté trabajando.
> Utilización de las Hojas de Estilo (CSS)
Como se puede apreciar por el ejemplo anterior, cuando se logra separar el contenido
de la presentación, el resultado suele ser muy poderoso ya que permite al adminis-
trador del sitio web hacer cambios al diseño (colores, ubicaciones, tamaños) del
contenido de sus páginas con muy poco esfuerzo: basta con modificar la Hoja de
Estilos para que éstos tengan efecto.
Para utilizar de mejor forma las Hojas de Estilo en Cascada, se ofrecen tres archivos
que se pueden obtener desde el sitio web de la Guía y que son los siguientes:
<head>
<title>Guía Web: Acerca de los Sitios Web y las Páginas</title>
<style type="text/css">
div.seccion { text-align: justify; font-size: 12pt}
div.subseccion { text-indent: 2em }
h1 { font-style: italic; color: green }
h2 { color: green }
</style>
</head>

-- 47 of 122 --

Archivo de Contenido: se trata del
archivo 3cols.htm que consiste en una
página con tres columnas: una tiene
un logotipo y las otras dos, texto
simulado; en su código se puede ver
que 	sólo 	tiene 	etiquetas 	de 	html
estándar, por lo que esta página hace
un uso válido de los estándares (ver
Figura 2).
Hojas de estilo: se ofrecen dos para
este archivo, las cuales se llaman desde
la sección <head> de su código; una de
ellas es para mostrar el contenido en
pantalla, mientras que la segunda es
para impresión. Los archivos se deno-
minan 3cols.css y 3cols-print.css. Un
elemento interesante, es que al usar la
hoja de estilo de impresión, se modifi-
ca completamente el contenido y la
página se diagrama de manera diferen-
te (ver Figura 3).
La intención de entregar estos archivos es
que el usuario de la Guía pueda trabajar
con ellos y hacerles las modificaciones
que estime adecuadas, para ir aprendiendo
sobre la marcha el efecto que consigue a
través de los cambios que realice.
Para aprender y practicar más sobre este tema, de por sí complejo, se sugieren los
siguientes recursos:
Tutorial CSS en W3C - http://www.w3.org/Style/Examples/011/firstcss.es.html
Tejedores del Web - http://www.tejedoresdelweb.com/307/article-1061.html
Directorio de enlaces de CSS en W3C - http://www.w3.org/Style/CSS/learning
48 < www.guiaweb.gob.cl
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile
Figura 3. - Así se ve el contenido del sitio web cuando se aprecia
en la visualización para impresión.
Figura 2. - Archivo que muestra el contenido del sitio tal como se
ve a través de un browser: logotipo en una columna, más otras
dos columnas de contenidos.

-- 48 of 122 --