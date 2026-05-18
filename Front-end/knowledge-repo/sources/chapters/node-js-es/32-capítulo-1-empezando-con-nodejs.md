# Capítulo 1:: Empezando con Node.js

Observaciones
Node.js es un marco de E / S asíncrono basado en eventos, sin bloqueo, que utiliza el motor de
JavaScript V8 de Google. Se utiliza para desarrollar aplicaciones que hacen un uso intensivo de
la capacidad de ejecutar JavaScript tanto en el cliente como en el lado del servidor y, por lo tanto,
se benefician de la reutilización del código y la falta de cambio de contexto. Es de código abierto y
multiplataforma. Las aplicaciones Node.js están escritas en JavaScript puro y se pueden ejecutar
dentro del entorno Node.js en Windows, Linux, etc.
Versiones
Versión Fecha de lanzamiento
v8.2.1 2017-07-20
v8.2.0 2017-07-19
v8.1.4 2017-07-11
v8.1.3 2017-06-29
v8.1.2 2017-06-15
v8.1.1 2017-06-13
v8.1.0 2017-06-08
v8.0.0 2017-05-30
v7.10.0 2017-05-02
v7.9.0 2017-04-11
v7.8.0 2017-03-29
v7.7.4 2017-03-21
v7.7.3 2017-03-14
v7.7.2 2017-03-08
v7.7.1 2017-03-02
v7.7.0 2017-02-28
https://riptutorial.com/es/home 2

-- 30 of 423 --

Versión Fecha de lanzamiento
v7.6.0 2017-02-21
v7.5.0 2017-01-31
v7.4.0 2017-01-04
v7.3.0 2016-12-20
v7.2.1 2016-12-06
v7.2.0 2016-11-22
v7.1.0 2016-11-08
v7.0.0 2016-10-25
v6.11.0 2017-06-06
v6.10.3 2017-05-02
v6.10.2 2017-04-04
v6.10.1 2017-03-21
v6.10.0 2017-02-21
v6.9.5 2017-01-31
v6.9.4 2017-01-05
v6.9.3 2017-01-05
v6.9.2 2016-12-06
v6.9.1 2016-10-19
v6.9.0 2016-10-18
v6.8.1 2016-10-14
v6.8.0 2016-10-12
v6.7.0 2016-09-27
v6.6.0 2016-09-14
v6.5.0 2016-08-26
v6.4.0 2016-08-12
https://riptutorial.com/es/home 3

-- 31 of 423 --

Versión Fecha de lanzamiento
v6.3.1 2016-07-21
v6.3.0 2016-07-06
v6.2.2 2016-06-16
v6.2.1 2016-06-02
v6.2.0 2016-05-17
v6.1.0 2016-05-05
v6.0.0 2016-04-26
v5.12.0 2016-06-23
v5.11.1 2016-05-05
v5.11.0 2016-04-21
v5.10.1 2016-04-05
v5.10 2016-04-01
v5.9 2016-03-16
v5.8 2016-03-09
v5.7 2016-02-23
v5.6 2016-02-09
v5.5 2016-01-21
v5.4 2016-01-06
v5.3 2015-12-15
v5.2 2015-12-09
v5.1 2015-11-17
v5.0 2015-10-29
v4.4 2016-03-08
v4.3 2016-02-09
v4.2 2015-10-12
https://riptutorial.com/es/home 4

-- 32 of 423 --

Versión Fecha de lanzamiento
v4.1 2015-09-17
v4.0 2015-09-08
io.js v3.3 2015-09-02
io.js v3.2 2015-08-25
io.js v3.1 2015-08-19
io.js v3.0 2015-08-04
io.js v2.5 2015-07-28
io.js v2.4 2015-07-17
io.js v2.3 2015-06-13
io.js v2.2 2015-06-01
io.js v2.1 2015-05-24
io.js v2.0 2015-05-04
io.js v1.8 2015-04-21
io.js v1.7 2015-04-17
io.js v1.6 2015-03-20
io.js v1.5 2015-03-06
io.js v1.4 2015-02-27
io.js v1.3 2015-02-20
io.js v1.2 2015-02-11
io.js v1.1 2015-02-03
io.js v1.0 2015-01-14
v0.12 2016-02-09
v0.11 2013-03-28
v0.10 2013-03-11
v0.9 2012-07-20
https://riptutorial.com/es/home 5

-- 33 of 423 --

Versión Fecha de lanzamiento
v0.8 2012-06-22
v0.7 2012-01-17
v0.6 2011-11-04
v0.5 2011-08-26
v0.4 2011-08-26
v0.3 2011-08-26
v0.2 2011-08-26
v0.1 2011-08-26
Examples
Hola servidor HTTP mundial
Primero, instale Node.js para su plataforma.
En este ejemplo, crearemos un servidor HTTP que escucha en el puerto 1337, que envía Hello,
World! al navegador. Tenga en cuenta que, en lugar de usar el puerto 1337, puede usar cualquier
número de puerto de su elección que no esté actualmente en uso por ningún otro servicio.
El módulo http es un módulo principal de Node.js (un módulo incluido en la fuente de Node.js,
que no requiere la instalación de recursos adicionales). El módulo http proporciona la
funcionalidad para crear un servidor HTTP utilizando el método http.createServer() . Para crear la
aplicación, cree un archivo que contenga el siguiente código JavaScript.
const http = require('http'); // Loads the http module
http.createServer((request, response) => {
// 1. Tell the browser everything is OK (Status code 200), and the data is in plain text
response.writeHead(200, {
'Content-Type': 'text/plain'
});
// 2. Write the announced text to the body of the page
response.write('Hello, World!\n');
// 3. Tell the server that all of the response headers and body have been sent
response.end();
}).listen(1337); // 4. Tells the server what port to be on
Guarde el archivo con cualquier nombre de archivo. En este caso, si lo llamamos hello.js
podemos ejecutar la aplicación yendo al directorio donde se encuentra el archivo y usando el
https://riptutorial.com/es/home 6

-- 34 of 423 --

siguiente comando:
node hello.js
Se puede acceder al servidor creado con la URL http: // localhost: 1337 o http://127.0.0.1:1337 en
el navegador.
Aparecerá una página web simple con el texto "¡Hola, mundo!" En la parte superior, como se
muestra en la captura de pantalla a continuación.
Ejemplo editable en línea.
Hola línea de comando mundial
Node.js también se puede utilizar para crear utilidades de línea de comandos. El siguiente
ejemplo lee el primer argumento de la línea de comando e imprime un mensaje de saludo.
Para ejecutar este código en un sistema Unix:
Crea un nuevo archivo y pega el siguiente código. El nombre del archivo es irrelevante.	1.
Haga que este archivo sea ejecutable con chmod 700 FILE_NAME	2.
Ejecuta la aplicación con ./APP_NAME David	3.
En Windows, realice el paso 1 y ejecútelo con el node APP_NAME David
#!/usr/bin/env node
'use strict';
/*
The command line arguments are stored in the `process.argv` array,
which has the following structure:
https://riptutorial.com/es/home 7

-- 35 of 423 --

[0] The path of the executable that started the Node.js process
[1] The path to this application
[2-n] the command line arguments
Example: [ '/bin/node', '/path/to/yourscript', 'arg1', 'arg2', ... ]
src: https://nodejs.org/api/process.html#process_process_argv
*/
// Store the first argument as username.
var username = process.argv[2];
// Check if the username hasn't been provided.
if (!username) {
// Extract the filename
var appName = process.argv[1].split(require('path').sep).pop();
// Give the user an example on how to use the app.
console.error('Missing argument! Example: %s YOUR_NAME', appName);
// Exit the app (success: 0, error: 1).
// An error will stop the execution chain. For example:
// ./app.js && ls -> won't execute ls
// ./app.js David && ls -> will execute ls
process.exit(1);
}
// Print the message to the console.
console.log('Hello %s!', username);
Instalación y ejecución de Node.js
Para comenzar, instale Node.js en su computadora de desarrollo.
Windows: navegue a la página de descarga y descargue / ejecute el instalador.
Mac: vaya a la página de descarga y descargue / ejecute el instalador. Alternativamente, puede
instalar Node a través de Homebrew usando brew install node . Homebrew es un gestor de
paquetes de línea de comandos para Macintosh, y se puede encontrar más información al
respecto en el sitio web de Homebrew .
Linux: siga las instrucciones para su distribución en la página de instalación de la línea de
comandos .
Ejecutando un programa de nodo
Para ejecutar un programa Node.js, simplemente ejecute node app.js o nodejs app.js , donde
app.js es el nombre de archivo del código fuente de su aplicación de nodo. No es necesario que
incluya el sufijo .js para que Node encuentre la secuencia de comandos que desea ejecutar.
Alternativamente, bajo los sistemas operativos basados en UNIX, un programa Node puede
ejecutarse como un script de terminal. Para hacerlo, debe comenzar con un shebang que apunte
al intérprete del nodo, como el nodo #!/usr/bin/env node . El archivo también debe configurarse
https://riptutorial.com/es/home 8

-- 36 of 423 --

como ejecutable, lo que se puede hacer usando chmod . Ahora el script se puede ejecutar
directamente desde la línea de comandos.
Implementando su aplicación en línea
Cuando implementa su aplicación en un entorno alojado (específico de Node.js), este entorno
generalmente ofrece una variable de entorno PORT que puede utilizar para ejecutar su servidor.
Cambiar el número de puerto a process.env.PORT permite acceder a la aplicación.
Por ejemplo,
http.createServer(function(request, response) {
// your server code
}).listen(process.env.PORT);
Además, si desea acceder a este sin conexión durante la depuración, puede utilizar esto:
http.createServer(function(request, response) {
// your server code
}).listen(process.env.PORT || 3000);
donde 3000 es el número de puerto fuera de línea.
Depuración de su aplicación NodeJS
Puedes usar el inspector de nodos. Ejecute este comando para instalarlo a través de npm:
npm install -g node-inspector
Entonces puedes depurar tu aplicación usando
node-debug app.js
El repositorio de Github se puede encontrar aquí: https://github.com/node-inspector/node-
inspector
Depuración nativa
También puede depurar node.js de forma nativa al iniciarlo así:
node debug your-script.js
Para interrumpir su depurador exactamente en la línea de código que desea, use esto:
debugger;
https://riptutorial.com/es/home 9

-- 37 of 423 --

Para más información ver aquí .
En node.js 8 usa el siguiente comando:
node --inspect-brk your-script.js
Luego, abra about://inspect en una versión reciente de Google Chrome y seleccione su
secuencia de comandos Node para obtener la experiencia de depuración de las herramientas de
desarrollo de Chrome.
Hola mundo con expreso
El siguiente ejemplo utiliza Express para crear un servidor HTTP que escucha en el puerto 3000,
que responde con "¡Hola, mundo!". Express es un marco web de uso común que es útil para crear
API de HTTP.
Primero, crea una nueva carpeta, por ejemplo, myApp . Vaya a myApp y myApp un nuevo archivo
JavaScript que contenga el siguiente código (llamémoslo hello.js por ejemplo). Luego instale el
módulo express utilizando npm install --save express desde la línea de comandos. Consulte esta
documentación para obtener más información sobre cómo instalar paquetes .
// Import the top-level function of express
const express = require('express');
// Creates an Express application using the top-level function
const app = express();
// Define port number as 3000
const port = 3000;
// Routes HTTP GET requests to the specified path "/" with the specified callback function
app.get('/', function(request, response) {
response.send('Hello, World!');
});
// Make the app listen on port 3000
app.listen(port, function() {
console.log('Server listening on http://localhost:' + port);
});
Desde la línea de comandos, ejecute el siguiente comando:
node hello.js
Abra su navegador y navegue a http://localhost:3000 o http://127.0.0.1:3000 para ver la
respuesta.
Para obtener más información sobre el marco Express, puede consultar la sección Aplicaciones
web con Express
https://riptutorial.com/es/home 10

-- 38 of 423 --

Hola enrutamiento básico mundial
Una vez que entienda cómo crear un servidor HTTP con nodo, es importante entender cómo
hacer que "haga" las cosas en función de la ruta a la que un usuario ha navegado. Este fenómeno
se llama, "enrutamiento".
El ejemplo más básico de esto sería verificar if (request.url === 'some/path/here') , y luego
llamar a una función que responde con un nuevo archivo.
Un ejemplo de esto se puede ver aquí:
const http = require('http');
function index (request, response) {
response.writeHead(200);
response.end('Hello, World!');
}
http.createServer(function (request, response) {
if (request.url === '/') {
return index(request, response);
}
response.writeHead(404);
response.end(http.STATUS_CODES[404]);
}).listen(1337);
Sin embargo, si continúa definiendo sus "rutas" de esta manera, terminará con una función de
devolución de llamada masiva, y no queremos un lío gigante como ese, así que veamos si
podemos limpiar esto.
Primero, almacenemos todas nuestras rutas en un objeto:
var routes = {
'/': function index (request, response) {
response.writeHead(200);
response.end('Hello, World!');
},
'/foo': function foo (request, response) {
response.writeHead(200);
response.end('You are now viewing "foo"');
}
}
Ahora que hemos almacenado 2 rutas en un objeto, ahora podemos verificarlas en nuestra
devolución de llamada principal:
http.createServer(function (request, response) {
if (request.url in routes) {
return routes[request.url](request, response);
}
https://riptutorial.com/es/home 11

-- 39 of 423 --

response.writeHead(404);
response.end(http.STATUS_CODES[404]);
}).listen(1337);
Ahora, cada vez que intente navegar por su sitio web, comprobará la existencia de esa ruta en
sus rutas y llamará a la función correspondiente. Si no se encuentra una ruta, el servidor
responderá con un 404 (No encontrado).
Y ahí lo tienen, el enrutamiento con la API del servidor HTTP es muy simple.
TLS Socket: servidor y cliente
Las únicas diferencias importantes entre esto y una conexión TCP regular son la clave privada y
el certificado público que deberá establecer en un objeto de opción.
Cómo crear una clave y un certificado
El primer paso en este proceso de seguridad es la creación de una clave privada. ¿Y cuál es esta
clave privada? Básicamente, es un conjunto de ruido aleatorio que se utiliza para cifrar la
información. En teoría, podría crear una clave y usarla para cifrar lo que quiera. Pero es una
buena práctica tener diferentes claves para cosas específicas. Porque si alguien roba su clave
privada, es similar a que alguien robe las llaves de su casa. Imagínese si usara la misma llave
para bloquear su auto, garaje, oficina, etc.
openssl genrsa -out private-key.pem 1024
Una vez que tengamos nuestra clave privada, podemos crear una CSR (solicitud de firma de
certificado), que es nuestra solicitud para que la clave privada esté firmada por una autoridad
competente. Es por eso que debes ingresar información relacionada con tu empresa. Esta
información será vista por la autoridad firmante y se usará para verificarlo. En nuestro caso, no
importa lo que escriba, ya que en el siguiente paso firmaremos nuestro certificado nosotros
mismos.
openssl req -new -key private-key.pem -out csr.pem
Ahora que hemos completado nuestro trabajo de papel, es hora de fingir que somos una
autoridad de firma genial.
openssl x509 -req -in csr.pem -signkey private-key.pem -out public-cert.pem
Ahora que tiene la clave privada y el certificado público, puede establecer una conexión segura
entre dos aplicaciones NodeJS. Y, como puede ver en el código de ejemplo, es un proceso muy
simple.
¡Importante!
https://riptutorial.com/es/home 12

-- 40 of 423 --

Desde que creamos el certificado público nosotros mismos, con toda honestidad, nuestro
certificado es inútil, porque no somos nadie. El servidor NodeJS no confiará en dicho certificado
de forma predeterminada, y es por eso que debemos decirle que realmente confíe en nuestro
certificado con la siguiente opción rejectUnauthorized: false. Muy importante : nunca establezca
esta variable en verdadero en un entorno de producción.
Servidor de socket TLS
'use strict';
var tls = require('tls');
var fs = require('fs');
const PORT = 1337;
const HOST = '127.0.0.1'
var options = {
key: fs.readFileSync('private-key.pem'),
cert: fs.readFileSync('public-cert.pem')
};
var server = tls.createServer(options, function(socket) {
// Send a friendly message
socket.write("I am the server sending you a message.");
// Print the data that we received
socket.on('data', function(data) {
console.log('Received: %s [it is %d bytes long]',
data.toString().replace(/(\n)/gm,""),
data.length);
});
// Let us know when the transmission is over
socket.on('end', function() {
console.log('EOT (End Of Transmission)');
});
});
// Start listening on a specific port and address
server.listen(PORT, HOST, function() {
console.log("I'm listening at %s, on port %s", HOST, PORT);
});
// When an error occurs, show it.
server.on('error', function(error) {
console.error(error);
// Close the connection after the error occurred.
https://riptutorial.com/es/home 13

-- 41 of 423 --

server.destroy();
});
TLS Socket Client
'use strict';
var tls = require('tls');
var fs = require('fs');
const PORT = 1337;
const HOST = '127.0.0.1'
// Pass the certs to the server and let it know to process even unauthorized certs.
var options = {
key: fs.readFileSync('private-key.pem'),
cert: fs.readFileSync('public-cert.pem'),
rejectUnauthorized: false
};
var client = tls.connect(PORT, HOST, options, function() {
// Check if the authorization worked
if (client.authorized) {
console.log("Connection authorized by a Certificate Authority.");
} else {
console.log("Connection not authorized: " + client.authorizationError)
}
// Send a friendly message
client.write("I am the client sending you a message.");
});
client.on("data", function(data) {
console.log('Received: %s [it is %d bytes long]',
data.toString().replace(/(\n)/gm,""),
data.length);
// Close the connection after receiving the message
client.end();
});
client.on('close', function() {
console.log("Connection closed");
});
// When an error ocoures, show it.
client.on('error', function(error) {
console.error(error);
// Close the connection after the error occurred.
https://riptutorial.com/es/home 14

-- 42 of 423 --

client.destroy();
});
Hola mundo en el REPL
Cuando se llama sin argumentos, Node.js inicia un REPL (Read-Eval-Print-Loop) también
conocido como el " shell de nodo ".
En un indicador de comando escriba el node .
$ node
>
En el indicador de shell Node > escriba "Hello World!"
$ node
> "Hello World!"
'Hello World!'
Módulos centrales
Node.js es un motor Javascript (el motor V8 de Google para Chrome, escrito en C ++) que
permite ejecutar Javascript fuera del navegador. Si bien hay numerosas bibliotecas disponibles
para ampliar las funcionalidades de Node, el motor viene con un conjunto de módulos centrales
que implementan funcionalidades básicas.
Actualmente hay 34 módulos centrales incluidos en Nodo:
[ 'assert',
'buffer',
'c/c++_addons',
'child_process',
'cluster',
'console',
'crypto',
'deprecated_apis',
'dns',
'domain',
'Events',
'fs',
'http',
'https',
'module',
'net',
'os',
'path',
'punycode',
'querystring',
'readline',
'repl',
'stream',
'string_decoder',
https://riptutorial.com/es/home 15

-- 43 of 423 --

'timers',
'tls_(ssl)',
'tracing',
'tty',
'dgram',
'url',
'util',
'v8',
'vm',
'zlib' ]
Esta lista se obtuvo de la API de documentación del nodo https://nodejs.org/api/all.html (archivo
JSON: https://nodejs.org/api/all.json ).
Todos los módulos básicos de un vistazo
afirmar
La assert módulo proporciona un conjunto simple de pruebas afirmación de que se pueden utilizar
para probar invariantes.
buffer
Antes de la introducción de TypedArray en ECMAScript 2015 (ES6), el lenguaje JavaScript no tenía
ningún mecanismo para leer o manipular flujos de datos binarios. La clase Buffer se introdujo
como parte de la API Node.js para hacer posible interactuar con flujos de octetos en el contexto
de cosas como flujos de TCP y operaciones del sistema de archivos.
Ahora que TypedArray se ha agregado en ES6, la clase Buffer implementa la API Uin t8Array de
una manera más optimizada y adecuada para los casos de uso de Node.js.
c / c ++ _ addons
Los complementos de Node.js son objetos compartidos enlazados dinámicamente, escritos en C
o C ++, que se pueden cargar en Node.js usando la función require() , y se usan como si fueran
un módulo ordinario de Node.js. Se usan principalmente para proporcionar una interfaz entre
JavaScript que se ejecuta en las bibliotecas Node.js y C / C ++.
child_process
El módulo child_process proporciona la capacidad de generar procesos secundarios de manera
similar, pero no idéntica, a popen (3).
racimo
Una sola instancia de Node.js se ejecuta en un solo hilo. Para aprovechar los sistemas de
múltiples núcleos, el usuario a veces querrá iniciar un clúster de procesos Node.js para manejar la
carga. El módulo de clúster le permite crear fácilmente procesos secundarios que comparten
todos los puertos del servidor.
https://riptutorial.com/es/home 16

-- 44 of 423 --

consola
El módulo de la console proporciona una consola de depuración simple que es similar al
mecanismo de la consola de JavaScript proporcionado por los navegadores web.
crypto
La crypto módulo proporciona la funcionalidad criptográfica que incluye un conjunto de
contenedores para el hash de OpenSSL, HMAC, cifra, descifrar, firmar y verificar las funciones.
deprecated_apis
Node.js puede desaprobar las API cuando: (a) se considera que el uso de la API no es seguro, (b)
se ha puesto a disposición una API alternativa mejorada, o (c) se esperan cambios en la API en
un futuro lanzamiento importante .
dns
El módulo dns contiene funciones que pertenecen a dos categorías diferentes:
Funciones que utilizan las instalaciones del sistema operativo subyacente para realizar la
resolución de nombres y que no necesariamente realizan ninguna comunicación de red.
Esta categoría contiene solo una función: dns.lookup() .
1.
Funciones que se conectan a un servidor DNS real para realizar la resolución de nombres y
que siempre usan la red para realizar consultas de DNS. Esta categoría contiene todas las
funciones en el módulo dns excepto dns.lookup() .
2.
dominio
Este módulo está en desuso . Una vez que se haya finalizado una API de reemplazo, este
módulo quedará completamente en desuso. La mayoría de los usuarios finales no deberían tener
motivos para utilizar este módulo. Los usuarios que absolutamente deben tener la funcionalidad
que proporcionan los dominios pueden confiar en ella por el momento, pero deben esperar tener
que migrar a una solución diferente en el futuro.
Eventos
Gran parte de la API central de Node.js se basa en una arquitectura asincrónica idiomática
basada en eventos, en la que ciertos tipos de objetos (llamados "emisores") emiten
periódicamente eventos con nombre que hacen que los objetos de función ("escuchas") sean
llamados.
fs
El archivo I / O es proporcionado por envoltorios simples alrededor de las funciones POSIX
estándar. Para usar este módulo se require('fs') . Todos los métodos tienen formas asíncronas y
síncronas.
http
https://riptutorial.com/es/home 17

-- 45 of 423 --

Las interfaces HTTP en Node.js están diseñadas para admitir muchas características del
protocolo que tradicionalmente han sido difíciles de usar. En particular, mensajes grandes,
posiblemente codificados, trozos. La interfaz tiene cuidado de no amortiguar nunca solicitudes o
respuestas completas, ya que el usuario puede transmitir datos.
https
HTTPS es el protocolo HTTP sobre TLS / SSL. En Node.js esto se implementa como un módulo
separado.
módulo
Node.js tiene un sencillo sistema de carga de módulos. En Node.js, los archivos y los módulos
están en correspondencia uno a uno (cada archivo se trata como un módulo separado).
red
El módulo de net proporciona una envoltura de red asíncrona. Contiene funciones para crear
servidores y clientes (llamados flujos). Puede incluir este módulo con require('net'); .
os
El módulo os proporciona una serie de métodos de utilidad relacionados con el sistema operativo.
camino
El módulo de path proporciona utilidades para trabajar con rutas de archivos y directorios.
punycode
La versión del módulo punycode incluida en Node.js está en desuso .
cadena de consulta
El módulo de querystring proporciona utilidades para analizar y formatear cadenas de consulta de
URL.
readline
El módulo readline proporciona una interfaz para leer datos de una secuencia legible (como
process.stdin ) una línea a la vez.
réplica
El módulo repl proporciona una implementación de Read-Eval-Print-Loop (REPL) que está
disponible como un programa independiente o se puede incluir en otras aplicaciones.
corriente
Un flujo es una interfaz abstracta para trabajar con datos de transmisión en Node.js. El módulo de
stream proporciona una API base que facilita la creación de objetos que implementan la interfaz de
https://riptutorial.com/es/home 18

-- 46 of 423 --

flujo.
Hay muchos objetos de flujo proporcionados por Node.js. Por ejemplo, una solicitud a un servidor
HTTP y process.stdout son instancias de flujo.
string_decoder
El módulo string_decoder proporciona una API para decodificar objetos Buffer en cadenas de una
manera que conserva los caracteres codificados de varios bytes UTF-8 y UTF-16.
temporizadores
El módulo timer expone una API global para que las funciones de programación se llamen en
algún período de tiempo futuro. Debido a que las funciones del temporizador son globales, no es
necesario llamar a require('timers') para usar la API.
Las funciones de temporizador dentro de Node.js implementan una API similar a la API de
temporizadores provista por los navegadores web, pero usan una implementación interna
diferente que se construye alrededor del Node.js Event Loop .
tls_ (ssl)
El módulo tls proporciona una implementación de los protocolos de Seguridad de la capa de
transporte (TLS) y de la Capa de conexión segura (SSL) que se construye sobre OpenSSL.
rastreo
Trace Event proporciona un mecanismo para centralizar la información de seguimiento generada
por V8, Node Core y el código de espacio de usuario.
El rastreo se puede habilitar al pasar la --trace-events-enabled cuando se inicia una aplicación
Node.js.
tty
El módulo tty proporciona las clases tty.ReadStream y tty.WriteStream . En la mayoría de los
casos, no será necesario o posible utilizar este módulo directamente.
dgram
El módulo dgram proporciona una implementación de sockets de datagramas UDP.
url
El módulo url proporciona utilidades para la resolución y el análisis de URL.
util
El módulo util está diseñado principalmente para satisfacer las necesidades de las propias API
internas de Node.js. Sin embargo, muchas de las utilidades también son útiles para los
desarrolladores de aplicaciones y módulos.
https://riptutorial.com/es/home 19

-- 47 of 423 --

v8
El módulo v8 expone las API que son específicas de la versión de V8 integrada en el binario
Node.js.
Nota : Las API y la implementación están sujetas a cambios en cualquier momento.
vm
El módulo vm proporciona API para compilar y ejecutar código en contextos de máquinas virtuales
V8. El código JavaScript puede compilarse y ejecutarse inmediatamente o compilarse, guardarse
y ejecutarse más tarde.
Nota : el módulo vm no es un mecanismo de seguridad. No lo use para ejecutar código no
confiable .
zlib
El módulo zlib proporciona funcionalidad de compresión implementada usando Gzip y Deflate /
Inflate.
¡Cómo poner en marcha un servidor web HTTPS básico!
Una vez que tenga node.js instalado en su sistema, simplemente puede seguir el procedimiento a
continuación para que un servidor web básico funcione con soporte tanto para HTTP como para
HTTPS.
Paso 1: Construir una Autoridad de Certificación
cree la carpeta donde desea almacenar su clave y certificado:
mkdir conf
1.
ir a ese directorio:
cd conf
2.
tome este archivo ca.cnf para usarlo como acceso directo de configuración:
wget https://raw.githubusercontent.com/anders94/https-authorized-clients/master/keys/ca.cnf
3.
crear una nueva autoridad de certificación utilizando esta configuración:
openssl req -new -x509 -days 9999 -config ca.cnf -keyout ca-key.pem -out ca-cert.pem
4.
Ahora que tenemos nuestra autoridad de certificación en ca-key.pem y ca-cert.pem ,	5.
https://riptutorial.com/es/home 20

-- 48 of 423 --

generemos una clave privada para el servidor:
openssl genrsa -out key.pem 4096
tome este archivo server.cnf para usarlo como acceso directo de configuración:
wget https://raw.githubusercontent.com/anders94/https-authorized-
clients/master/keys/server.cnf
6.
generar la solicitud de firma de certificado utilizando esta configuración:
openssl req -new -config server.cnf -key key.pem -out csr.pem
7.
firmar la solicitud:
openssl x509 -req -extfile server.cnf -days 999 -passin "pass:password" -in csr.pem -CA ca-
cert.pem -CAkey ca-key.pem -CAcreateserial -out cert.pem
8.
Paso 2: instale su certificado como certificado raíz
Copie su certificado a la carpeta de sus certificados raíz:
sudo cp ca-crt.pem /usr/local/share/ca-certificates/ca-crt.pem
1.
actualizar la tienda de CA:
sudo update-ca-certificates
2.
Paso 3: Iniciar su servidor de nodo
Primero, desea crear un archivo server.js que contenga su código de servidor real.
La configuración mínima para un servidor HTTPS en Node.js sería algo como esto:
var https = require('https');
var fs = require('fs');
var httpsOptions = {
key: fs.readFileSync('path/to/server-key.pem'),
cert: fs.readFileSync('path/to/server-crt.pem')
};
var app = function (req, res) {
res.writeHead(200);
res.end("hello world\n");
}
https.createServer(httpsOptions, app).listen(4433);
https://riptutorial.com/es/home 21

-- 49 of 423 --

Si también desea admitir solicitudes http, solo necesita hacer una pequeña modificación:
var http = require('http');
var https = require('https');
var fs = require('fs');
var httpsOptions = {
key: fs.readFileSync('path/to/server-key.pem'),
cert: fs.readFileSync('path/to/server-crt.pem')
};
var app = function (req, res) {
res.writeHead(200);
res.end("hello world\n");
}
http.createServer(app).listen(8888);
https.createServer(httpsOptions, app).listen(4433);
vaya al directorio donde se encuentra su server.js :
cd /path/to
1.
ejecuta server.js :
node server.js
2.
Lea Empezando con Node.js en línea: https://riptutorial.com/es/node-js/topic/340/empezando-con-
node-js
https://riptutorial.com/es/home 22

-- 50 of 423 --