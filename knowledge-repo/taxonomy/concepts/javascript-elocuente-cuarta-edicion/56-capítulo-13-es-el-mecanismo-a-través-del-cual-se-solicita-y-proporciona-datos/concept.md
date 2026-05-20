# Capítulo 13: , es el mecanismo a través del cual se solicita y proporciona datos

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 56)

## Contenido
# Capítulo 13: , es el mecanismo a través del cual se solicita y proporciona datos

en la World Wide Web. Este capítulo describe el protocolo con más detalle y
explica la forma en que JavaScript del navegador tiene acceso a él.
El protocolo
Si escribes eloquentjavascript.net/18_http.html en la barra de direcciones de tu
navegador, el navegador primero busca la dirección del servidor asociado con
eloquentjavascript.net e intenta abrir una conexión TCP con él en el puerto 80,
el puerto predeterminado para el tráfico HTTP. Si el servidor existe y acepta
la conexión, el navegador podría enviar algo como esto:
GET /18_http.html HTTP/1.1
Host: eloquentjavascript.net
User-Agent: Nombre de tu navegador
Luego el servidor responde, a través de esa misma conexión.
HTTP/1.1 200 OK
Content-Length: 87320
Content-Type: text/html
Last-Modified: Vie, 13 Oct 2023 10:05:41 GMT
<!doctype html>
... el resto del documento
El navegador toma la parte de la respuesta después de la línea en blanco, su
cuerpo (no confundir con la etiqueta HTML <body>), y lo muestra como un
documento HTML.
La información enviada por el cliente se llama la solicitud. Comienza con
esta línea:
GET /18_http.html HTTP/1.1
308

-- 320 of 445 --

La primera palabra es el método de la solicitud. GET significa que queremos
obtener el recurso especificado. Otros métodos comunes son DELETE para elimi-
nar un recurso, PUT para crearlo o reemplazarlo, y POST para enviar información
a él. Cabe destacar que el servidor no está obligado a llevar a cabo cada solic-
itud que recibe. Si te acercas a un sitio web aleatorio y le dices que DELETE su
página principal, probablemente se negará.
La parte después del nombre del método es la ruta del recurso al que aplica
la solicitud. En el caso más simple, un recurso es simplemente un archivo
en el servidor, pero el protocolo no lo requiere así. Un recurso puede ser
cualquier cosa que pueda transferirse como si fuera un archivo. Muchos servi-
dores generan las respuestas que producen al vuelo. Por ejemplo, si abres
https://github.com/marijnh, el servidor buscará en su base de datos un usuario
llamado “marijnh”, y si lo encuentra, generará una página de perfil para ese
usuario.Después de la ruta del recurso, la primera línea de la solicitud menciona
HTTP/1.1 para indicar la versión del protocolo HTTP que está utilizando.
En la práctica, muchos sitios utilizan la versión 2 de HTTP, que soporta los
mismos conceptos que la versión 1.1 pero es mucho más complicada para que
pueda ser más rápida. Los navegadores cambiarán automáticamente a la ver-
sión de protocolo adecuada al comunicarse con un servidor dado, y el resultado
de una solicitud es el mismo independientemente de la versión utilizada. Dado
que la versión 1.1 es más directa y más fácil de entender, la usaremos para
ilustrar el protocolo.
La respuesta del servidor comenzará también con una versión, seguida del
estado de la respuesta, primero como un código de estado de tres dígitos y
luego como una cadena legible por humanos.
HTTP/1.1 200 OK
Los códigos de estado que comienzan con 2 indican que la solicitud tuvo éxito.
Los códigos que comienzan con 4 significan que hubo un problema con la solici-
tud. El 404 es probablemente el código de estado de HTTP más famoso, lo que
significa que el recurso no se pudo encontrar. Los códigos que comienzan con
5 indican que ocurrió un error en el servidor y la solicitud no es la responsable.
La primera línea de una solicitud o respuesta puede ir seguida de cualquier
número de cabeceras. Estas son líneas en la forma nombre: valor que especifi-
can información adicional sobre la solicitud o respuesta. Estas cabeceras eran
