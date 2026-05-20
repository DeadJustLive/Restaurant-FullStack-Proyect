# Capítulo 3: - Diseño de Interfaces e Interacción

www.guiaweb.gob.cl > 71
Las etiquetas deben escribirse en minúsculas debido a que XML es sensible a
mayúsculas y minúsculas.
Los valores de los atributos deben encerrarse entre comillas "dobles".
La información de scripts como los de Javascript debe ser incluida dentro de
marcadores especiales llamados [CDATA]. Por ejemplo:
Los elementos ya no pueden usar el identificador “name” el cual debe ser
cambiados por el identificador ID.
Debido a estas diferencias, los desarrolladores que migren sus Sitios Web hacia el
nuevo estándar deberán hacer varias modificaciones ya que como se aprecia, el
uso de XHTML obliga a ser estricto en el cumplimiento de la especificación, en
especial en el uso de minúsculas y en el cierre de todos los elementos, tema que
en las versiones anteriores de HTML no era tan crucial.
Separación de contenidos y presentación
Otro de los mandatos del Decreto Supremo 100/2006 del Ministerio Secretaría
General de la Presidencia ya señalado, aparece en el Artículo 10° donde se indica
que en las páginas que forman parte del sitio web, se debe separar los contenidos de
la presentación, aprovechando las características señaladas del estándar XHTML.
Tal como se indicó en el Capítulo 2 de esta Guía, este es un cambio de importan-
cia en lo referido al diseño web, ya que incluso hasta la aparición de la Guía Web
Versión 1.0 habitualmente se empleaba tablas para disponer los elementos en las
páginas, facilitando de esa manera su ubicación en la pantalla.
Para conseguir esta separación es necesario incorporar la tecnología de las Hojas
de Estilo en Cascada (CSS por su sigla en inglés) que permiten manejar la presen-
<script type="text/javascript">
<![CDATA[
... unescaped script content
...
]]>
</script>

-- 71 of 122 --

72 < www.guiaweb.gob.cl
tación de manera externa al contenido. De esta manera, será posible ofrecer
páginas con diagramación diferente de la plataforma desde la que se acceda o,
incluso, contar con la posibilidad de ofrecer una mejor diagramación para efectos
de su impresión.
Como se ve en el ejemplo anterior, tomado de las páginas del sitio web de la Guía
Web Versión 1.0, usando CSS se puede ofrecer diferentes visiones del mismo con-
tenido sin hacerle cambios a sus páginas. Lo único que corresponde en dicho caso
es modificar el archivo de presentación de los contenidos, lo cual se hace a través
de los archivos de CSS. Entonces al revisar el código de sus páginas se puede
encontrar en la parte del <head> las siguientes líneas:
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile
Figura 15. Dos imágenes del mismo contenido: a la izquierda, visión desde web y a la derecha, visión desde el impreso.
<link href="../../../styles/main.css" rel="stylesheet" type="text/css"
/>
<link href="../../../styles/print.css" rel="stylesheet"
type="text/css" media="print" />

-- 72 of 122 --