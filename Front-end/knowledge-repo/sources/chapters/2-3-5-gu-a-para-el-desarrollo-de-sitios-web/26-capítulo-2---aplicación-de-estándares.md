# Capítulo 2: - Aplicación de Estándares

www.guiaweb.gob.cl > 45
Cabe recordar que este tema fue tratado en la Guía Web Versión 1.023 y también
en el documento "Anexo 2 sobre el uso de Meta Tags" de la misma edición24, por
lo que sugerimos revisar dichos contenidos.
Enlaces externos: permite informar al documento acerca de otros archivos que
se deben ejecutar al mismo tiempo; el mejor ejemplo es el llamado a una hoja
de estilo para ejecutar la presentación gráfica de la página:
Scripts: 	permiten 	hacer 	llamados 	a 	lenguajes 	de 	programación, 	como
Javascript, para desarrollar acciones y crear funcionalidades en la página web
que se está visitando. Por ejemplo:
> Cuerpo de la Página
Cuando ya se ha ingresado la información correspondiente al encabezado, se accede
a la zona de contenido propiamente tal la que se despliega entre las etiquetas
<body> y </body>. En el caso de sitios realizados mediante marcos o "frames" esta
etiqueta va situada dentro de esta última.
Dentro de ellas se ubican todos los elementos que pueden identificarse como los
contenidos de la página web, vale decir, textos, imágenes, funcionalidades.
No obstante, para que su despliegue sea adecuado, es importante considerar la
estructura de la página, la cual se explica a través de las siguientes etiquetas:
<meta name="title" content="Nombre del Sitio Web o
Institución">
<meta name="description" content="Descripción del Sitio
Web o Institución o bien del contenido de la página">
<meta name="keywords" content="Palabras claves del Sitio
Web o Institución o bien del contenido de la página">
<link href="styles/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/uifunctions.js">
23.- Más información en http://www.guiaweb.gob.cl/guia/capitulos/tres/accesorapido.htm#t04meta
24.- Ver documento (formato RTF) en http://www.guiaweb.gob.cl/guia/capitulos/tres/anexos/Informacion_sobre_Meta_tags.rtf

-- 45 of 122 --

46 < www.guiaweb.gob.cl
Utilización de la etiqueta <h>: es la etiqueta utilizada para marcar los títulos que
habrá en el contenido, comenzando por el principal que recibe la etiqueta <h1>.
Cabe recordar que gracias al uso de la tecnología CSS de Hojas de Estilo, será a
través de ésta que se dará el formato adecuado a dicho título para que se distinga
en la página. Las etiquetas <h> van desde 1 a 6, por lo que permiten indicar hasta
seis niveles de importancia de los titulares utilizados en el documento. Su uso es
muy relevante en términos de accesibilidad, ya que los programas de software
lectores de pantalla -que leen el contenido para que sea escuchado por usuarios
ciegos- siempre buscarán esta jerarquía de los contenidos para determinar la
sección por la que debe comenzar la lectura de la página.
Utilización de la etiqueta <p>: es la etiqueta utilizada para marcar los párrafos en
los que se divide el contenido; utilizando la tecnología CSS de Hojas de Estilo,
es posible agregarle el formato adecuado como tamaño de letra, espaciado,
interlineado, sangría, justificación, color y tipografía utilizada.
Utilización de la etiqueta <div> y <span>: son elementos neutros que sirven
para marcar y agrupar contenidos con fines estructurales. Con <div> se define
lo que ocurre con bloques de información, mientras que con <span> es posible
hacer esa misma definición pero para líneas de contenidos. Ambas etiquetas
utilizan las definiciones existentes en las Hojas de Estilo y permiten aplicarlas
a los contenidos.
Basándonos en un ejemplo de W3C, se puede ver el siguiente código en que se
aprecia la aplicación de estas etiquetas:
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile
<div class="seccion" id="sitio-web" >
<h1>Sitio Web</h1>
<p>In esta sección se da a conocer la forma de trabajar en un sitio web.
...más contenido...
...más contenido...
...más contenido...
<div class="subseccion" id="pagina-web" >
<h2>Las Páginas Web</H2>
<p>Las páginas web <span class="cursiva-bold">son parte de los
sitios</span> y se denominan así porque...</p>
<p>...más contenido... </p>
<p>...más contenido... </p>
<p>...más contenido... </p>
</div>
</div>

-- 46 of 122 --