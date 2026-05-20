# 5. Asegurar el contraste de colores: personas con problemas visuales tienen

dificultades para ver determinados contrastes de colores, por lo que los elementos
gráficos deben ser tratados de manera que haya un contraste suficiente que
permita su comprensión.
Uso de Ajax
Ajax20 es una combinación de tecnologías que se basa en el lenguaje Javascript
para ofrecer una experiencia de intercambio dinámico de información en Sitios
Web, enriqueciendo la experiencia de revisar datos y conseguir resultados de
manera rápida y confiable.
Ajax en sí no es una tecnología, sino que una implementación de varias tecnolo-
gías ya existentes tales como XHTML y CSS para mostrar páginas web; Document
Object Model (DOM) para mostrar e interactuar dinámicamente con la información
presentada; el objeto XMLHTTPRequest que permite realizar peticiones HTTP y
HTTPS a servidores WEB de manera asíncrona y XML para intercambio de infor-
mación entre el browser del usuario y el servidor que contiene la información.
Debido a que se basa en un lenguaje de scripting como Javascript, el cual se puede
usar con fines maliciosos como extraer información de parte del usuario, muchas
veces se puede dar el caso que dicha capacidad no está habilitada en el browser uti-
lizado. Si este es el caso, la aplicación que utilice Ajax también quedará desactivada21
.
20.- Más información sobre Ajax en Wikipedia: http://es.wikipedia.org/wiki/AJAX
21.- Más información sobre este tema en: http://olgacarreras.blogspot.com/2007/02/ajax-accesible.html
22.- Ver más información en: http://www.w3c.es/Prensa/2006/nota060926_aria-pressrelease

-- 69 of 122 --

70 < www.guiaweb.gob.cl
En este sentido se sugiere que desde la progra-
mación de la aplicación se haga este tipo de
detección con el objetivo de ofrecer una interfaz
distinta en dicho caso y, gracias a eso, entregar
otra forma de interactuar con la pantalla que
permita utilizar la aplicación que se ofrece. Es
importante señalar que al tiempo de la edición
de este documento, la organización W3C está desarrollando un nuevo estándar
orientadas a las aplicaciones de interacción enriquecida22 con el objetivo de definir
la mejor manera de hacerlas accesibles y que funcionen en los diferentes entornos
desde las cuales son utilizadas.
Desarrollo con estándares XHTML y CSS
Con la publicación del Decreto Supremo 100/2006 del Ministerio Secretaría General
de la Presidencia que contiene la Norma Técnica para el desarrollo de Sitios Web de
organismos de Gobierno23
, se definió que éstos debían desarrollarse empleando los
estándares definidos por el World Wide Web Consortium, más conocido y citado
previamente en esta Guía como W3C.
En lo que se refiere a estándar para el código de despliegue, en el Artículo 5° “se
recomienda que el sitio web cumpla con los estándares HTML 4.01 o XHTML 1.0
validados ante el W3C”.
Debido a que los avances de los estándares web son hacia el estándar XML que además
es el estándar elegido para el intercambio de documentos electrónicos del Gobierno de
Chile, en esta Guía se ha privilegiado destacar el trabajo con XHTML 1.0 con el fin de
destacar las características de su utilización sobre los estándares anteriores.
Entre las diferencias más relevantes de XHTML respecto de HTML y que deben ser
tenidas en cuenta, aparecen las siguientes24
:
El documento debe estar bien formado con todas las etiquetas cerradas en el
mismo orden en que se abren, vale decir, en el caso de etiquetas que se abren
dentro de otras, deben ser cerradas en el mismo orden.
No puede haber elementos vacíos, por lo que las etiquetas que no tienen cierre
deben completarse con un “slash” al final, como en <img … />,<br /> y <hr />.
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile
23.- Ver contenido del DS 100 en: http://www.guiaweb.cl/recursos/documentos.htm#bdragDS100
24.- Extraído de http://www.w3.org/TR/xhtml1/#diffs y http://es.wikipedia.org/wiki/XHTML
Ajax: la sigla significa
Asynchronous
JavaScript And XML
(JavaScript asíncrono
y XML).

-- 70 of 122 --