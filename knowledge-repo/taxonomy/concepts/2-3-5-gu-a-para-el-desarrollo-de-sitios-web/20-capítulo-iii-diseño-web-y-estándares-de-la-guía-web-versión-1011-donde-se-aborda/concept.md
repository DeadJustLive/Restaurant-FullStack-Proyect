# Capítulo III:: Diseño Web y Estándares de la Guía Web Versión 1.011, donde se aborda

## Fuente
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile (Cap. 20)

## Contenido
# Capítulo III:: Diseño Web y Estándares de la Guía Web Versión 1.011, donde se aborda

este tema en detalle.
Monitoreo de Actividad (DS100/2006 Art. 6°)
Este artículo establece la obligación del encargado
del sitio web para "monitorear regularmente la
actividad del mismo" con el objetivo de obtener
información acerca de los códigos de error y los
elementos más visitados. Es importante conside-
rar que este tema ya había sido abordado a tra-
vés del Capítulo IV "Puesta en Marcha" de la
Guía Web 1.0.
A partir de la información conseguida mediante el monitoreo, se espera que el
administrador pueda generar reportes frecuentes de actividad en los que se
establezcan los aciertos y errores del sitio, con el fín de establecer las buenas
tendencias y realizar las correcciones que sea del caso.
Respecto de los errores, cabe tener en cuenta que el protocolo HTTP12 que utilizan
las páginas web para la transmisión de sus contenidos, genera errores que están
estandarizados mediante códigos para su mejor comprensión. Los que comienzan
con el número 4 representan errores del lado del cliente y los que empiezan con 5
10.- Ver información sobre peso de páginas en http://www.guiaweb.gob.cl/guia/capitulos/tres/accesorapido.htm#t03practicas
11.- Ver información sobre uso de los estándares para el desarrollo de los Sitios Web en
http://www.guiaweb.gob.cl/guia/capitulos/tres/index.htm
12.- Ver el listado de errores en http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html
La inscripción de los
dominios de Gobierno
se realiza en
http://nic.gov.cl/con
sulta.html
Las normas
corporativas del icono
del Gobierno se
encuentran publicadas
en http://www.gobierno
dechile.cl/documenta
cion/normas.asp

-- 35 of 122 --

36 < www.guiaweb.gob.cl
son errores del lado del servidor. De ellos, los más frecuentes y que deben
ser atendidos a través del monitoreo que se sugiere en este artículo, son los
siguientes:
Error 401 	Acceso no autorizado a una página, no se ingresó la password.
Error 403 	Acceso prohibido; normalmente aparece cuando la página
que se busca no tiene permiso para ser mostrada.
Error 404 	La página no existe y no puede ser mostrada.
Error 500 	Error en el servidor debido a un problema de software.
Error 503 	El servicio web no está disponible.
Error 504 	Tiempo de respuesta excede lo normal y por lo tanto
la página no se muestra.
Es importante considerar que una buena práctica
respecto de este tema es adoptar una política de
atención de errores, de tal manera de definir qué
mensaje recibirá el usuario cuando ocurran los
problemas descritos. En particular se de debe
poner atención sobre el Error 404, debido a que
igualmente se puede producir si, por ejemplo, el
usuario escribe mal una dirección.
Para atender este problema se sugiere la inclusión
de una "página de error estándar" en el software
del servidor web, para que la muestre en el caso
de ocurrir un error. Los elementos mínimos que debe incorporar son:
Identificación del sitio web a través de un logotipo y nombre.
Sistema de navegación en el Sitio: menú, botones, etc.
Título que explique el sentido de la página.
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile
XHTML: eXtended
Hyper Text Markup
Language; estándar
de transición para
los contenidos de los
Sitios Web que
introduce elementos
de XML dentro del
lenguaje HTML.

-- 36 of 122 --
