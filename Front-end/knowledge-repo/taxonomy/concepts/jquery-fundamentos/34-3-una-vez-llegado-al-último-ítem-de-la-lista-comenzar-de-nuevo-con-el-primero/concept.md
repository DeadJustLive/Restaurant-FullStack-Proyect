# 3. Una vez llegado al último ítem de la lista, comenzar de nuevo con el primero.

## Fuente
jquery-fundamentos (Cap. 34)

## Contenido
# 3. Una vez llegado al último ítem de la lista, comenzar de nuevo con el primero.

Para un desafío mayor, realice un área de navegación por debajo del slideshow que muestre cuantas
imágenes existen y en cual se encuentra (ayuda: $.fn.prevAll‘ puede resultar útil).
53

-- 54 of 107 --

0.7. Ajax
0.7.1. Introducción
El método XMLHttpRequest (XHR) permite a los navegadores comunicarse con el servidor sin la
necesidad de recargar la página. Este método, también conocido como Ajax (Asynchronous JavaScript
and XML), permite la creación de aplicaciones ricas en interactividad.
Las peticiones Ajax son ejecutadas por el código JavaScript, el cual envía una petición a una URL
y cuando recibe una respuesta, una función de devolución puede ser ejecutada la cual recibe como
argumento la respuesta del servidor y realiza algo con ella. Debido a que la respuesta es asíncrona, el
resto del código de la aplicación continua ejecutándose, por lo cual, es imperativo que una función de
devolución sea ejecutada para manejar la respuesta.
A través de varios métodos, jQuery provee soporte para Ajax, permitiendo abstraer las diferen-
cias que pueden existir entre navegadores. Los métodos en cuestión son $.get(), $.getScript(),
$.getJSON(), $.post() y $().load().
A pesar que la definición de Ajax posee la palabra “XML”, la mayoría de las aplicaciones no utilizan
dicho formato para el transporte de datos, sino que en su lugar se utiliza HTML plano o información
en formato JSON (JavaScript Object Notation).
En general, Ajax no trabaja a través de dominios diferentes. Sin embargo, existen excepciones, como
los servicios que proveen información en formato JSONP (JSON with Padding), los cuales permiten
una funcionalidad limitada a través de diferentes dominios.
0.7.2. Conceptos Clave
La utilización correcta de los métodos Ajax requiere primero la comprensión de algunos conceptos
clave.
GET vs. POST
Los dos métodos HTTP más comunes para enviar una petición a un servidor son GET y POST. Es
importante entender la utilización de cada uno.
El método GET debe ser utilizado para operaciones no-destructivas — es decir, operaciones en donde
se esta “obteniendo” datos del servidor, pero no modificando. Por ejemplo, una consulta a un servicio
de búsqueda podría ser una petición GET. Por otro lado, las solicitudes GET pueden ser almacenadas
en la cache del navegador, pudiendo conducir a un comportamiento impredecible si no se lo espera.
Generalmente, la información enviada al servidor, es enviada en una cadena de datos (en inglés query
string).
El método POST debe ser utilizado para operaciones destructivas — es decir, operaciones en donde
se está incorporando información al servidor. Por ejemplo, cuando un usuario guarda un artículo en
un blog, esta acción debería utilizar POST. Por otro lado, este tipo de método no se guarda en la
cache del navegador. Además, una cadena de datos puede ser parte de la URL, pero la información
tiende a ser enviada de forma separada.
Tipos de Datos
Generalmente, jQuery necesita algunas instrucciones sobre el tipo de información que se espera recibir
cuando se realiza una petición Ajax. En algunos casos, el tipo de dato es especificado por el nombre
54

-- 55 of 107 --

del método, pero en otros casos se lo debe detallar como parte de la configuración del método:
text Para el transporte de cadenas de caracteres simples.
html Para el transporte de bloques de código HTML que serán ubicados en la página.
script Para añadir un nuevo script con código JavaScript a la página.
json Para transportar información en formato JSON, el cual puede incluir cadenas de caracteres,
vectores y objetos.
Nota
A partir de la versión 1.4 de la biblioteca, si la información JSON no está correctamente
formateada, la petición podría fallar. Visite http://json.org para obtener detalles sobre
un correcto formateo de datos en JSON.
Es recomendable utilizar los mecanismos que posea el lenguaje del lado de servidor para la generación
de información en formato JSON.
jsonp Para transportar información JSON de un dominio a otro.
xml Para transportar información en formato XML.
A pesar de los diferentes tipos de datos de que se puede utilizar, es recomendable utilizar el formato
JSON, ya que es muy flexible, permitiendo por ejemplo, enviar al mismo tiempo información plana y
HTML.
Asincronismo
Debido a que, de forma predeterminada, las llamadas Ajax son asíncronas, la respuesta del servidor
no esta disponible de forma inmediata. Por ejemplo, el siguiente código no debería funcionar:
var response;
$.get('foo.php', function(r) { response = r; });
console.log(response); // indefinido (undefined)
En su lugar, es necesario especificar una función de devolución de llamada; dicha función se ejecutará
cuando la petición se haya realizado de forma correcta ya que es en ese momento cuando la respuesta
del servidor esta lista.
$.get('foo.php', function(response) { console.log(response); });
Políticas de Mismo Origen y JSONP
En general, las peticiones Ajax están l
