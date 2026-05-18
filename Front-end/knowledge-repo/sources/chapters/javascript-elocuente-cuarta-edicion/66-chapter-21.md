# Chapter 21

Proyecto: Sitio web de intercambio de
habilidades
Una reunión de intercambio de habilidades es un evento en el que personas con
un interés compartido se reúnen y dan pequeñas presentaciones informales sobre
cosas que saben. En una reunión de intercambio de habilidades de jardinería,
alguien podría explicar cómo cultivar apio. O en un grupo de intercambio de
habilidades de programación, podrías pasar y contarles a la gente sobre Node.js.
En este último capítulo del proyecto, nuestro objetivo es configurar un sitio
web para gestionar las charlas impartidas en una reunión de intercambio de
habilidades. Imagina un pequeño grupo de personas que se reúnen regular-
mente en la oficina de uno de los miembros para hablar sobre monociclos. El
organizador anterior de las reuniones se mudó a otra ciudad y nadie se ofre-
ció a asumir esta tarea. Queremos un sistema que permita a los participantes
proponer y discutir charlas entre ellos, sin un organizador activo.
El código completo del proyecto se puede descargar desde https://eloquentjavascript.net/
code/skillsharing.zip.
Diseño
Este proyecto tiene una parte de servidor, escrita para Node.js, y una parte de
cliente, escrita para el navegador. El servidor almacena los datos del sistema
y los proporciona al cliente. También sirve los archivos que implementan el
sistema del lado del cliente.
El servidor mantiene la lista de charlas propuestas para la próxima reunión,
y el cliente muestra esta lista. Cada charla tiene un nombre de presentador, un
título, un resumen y una matriz de comentarios asociados. El cliente permite a
los usuarios proponer nuevas charlas (agregándolas a la lista), eliminar charlas
y comentar en charlas existentes. Cada vez que el usuario realiza un cambio
de este tipo, el cliente realiza una solicitud HTTP para informar al servidor al
respecto.
370

-- 382 of 445 --

La aplicación se configurará para mostrar una vista en vivo de las charlas
propuestas actuales y sus comentarios. Cada vez que alguien, en algún lugar,
envíe una nueva charla o agregue un comentario, todas las personas que ten-
gan la página abierta en sus navegadores deberían ver el cambio de inmediato.
Esto plantea un desafío—no hay forma de que un servidor web abra una conex-
ión a un cliente, ni hay una buena forma de saber qué clientes están viendo
actualmente un sitio web dado.
Una solución común a este problema se llama long polling, que resulta ser
una de las motivaciones del diseño de Node.
Long polling
Para poder notificar inmediatamente a un cliente que algo ha cambiado, necesi-
tamos una conexión con ese cliente. Dado que los navegadores web tradicional-
mente no aceptan conexiones y los clientes a menudo están detrás de routers
que bloquearían tales conexiones de todos modos, no es práctico que sea el
servidor quien inicie esta conexión.
Podemos hacer que el cliente abra la conexión y la mantenga activa para que
el servidor pueda usarla para enviar información cuando sea necesario.
Sin embargo, una solicitud HTTP permite solo un flujo simple de informa-
ción: el cliente envía una solicitud, el servidor responde una sola vez, y eso es
371

-- 383 of 445 --

todo. Existe una tecnología llamada WebSockets que permite abrir conexiones
para el intercambio arbitrario de datos. Pero usarlas adecuadamente es algo
complicado.
En este capítulo, utilizamos una técnica más sencilla—long polling—donde
los clientes preguntan continuamente al servidor por nueva información medi-
ante solicitudes HTTP regulares, y el servidor retiene su respuesta cuando no
tiene nada nuevo que informar.
Mientras el cliente se asegure de tener una solicitud de sondeo abierta con-
stantemente, recibirá información del servidor rápidamente cuando esté disponible.
Por ejemplo, si Fatma tiene nuestra aplicación de intercambio de habilidades
abierta en su navegador, ese navegador habrá solicitado actualizaciones y es-
tará esperando una respuesta a esa solicitud. Cuando Iman envía una charla
sobre “Extreme Downhill Unicycling”, el servidor notará que Fatma está es-
perando actualizaciones y enviará una respuesta que contiene la nueva charla a
su solicitud pendiente. El navegador de Fatma recibirá los datos y actualizará
la pantalla para mostrar la charla.
Para evitar que las conexiones se agoten por tiempo (se aborten debido
a una falta de actividad), las técnicas de long polling suelen establecer un
tiempo máximo para cada solicitud, tras el cual el servidor responderá de todos
modos, aunque no tenga nada que informar. Entonces, el cliente puede iniciar
una nueva solicitud. Reiniciar periódicamente la solicitud también hace que
la técnica sea más robusta, permitiendo a los clientes recuperarse de fallos
temporales de conexión o problemas de servidor.
Un servidor ocupado que utiliza long polling puede tener miles de solicitudes
en espera, y por lo tanto conexiones TCP abiertas. Node, que facilita la gestión
de muchas conexiones sin crear un hilo de control separado para cada una, es
ideal para este tipo de sistema.
Interfaz HTTP
Antes de comenzar a diseñar el servidor o el cliente, pensemos en el punto
donde se conectan: la interfaz HTTP a través de la cual se comunican.
Utilizaremos JSON como formato de nuestro cuerpo de solicitud y respuesta.
Al igual que en el servidor de archivos del Capítulo 20, intentaremos hacer un
buen uso de los métodos y cabeceras HTTP. La interfaz se centra en la ruta /
talks. Las rutas que no comienzan con /talks se utilizarán para servir archivos
estáticos—el código HTML y JavaScript para el sistema del lado del cliente.
Una solicitud GET a /talks devuelve un documento JSON como este:
[{"title": "Unituning",
372

-- 384 of 445 --

"presenter": "Jamal",
"summary": "Modificando tu bicicleta para darle más estilo",
"comments": []}]
Crear una nueva charla se hace haciendo una solicitud PUT a una URL como
/talks/Unituning, donde la parte después de la segunda barra es el título de la
charla. El cuerpo de la solicitud PUT debe contener un objeto JSON que tenga
propiedades presenter y summary.
Dado que los títulos de las charlas pueden contener espacios y otros caracteres
que normalmente no aparecen en una URL, las cadenas de título deben ser
codificadas con la función encodeURIComponent al construir una URL de ese
tipo.
console.log("/talks/" + encodeURIComponent("Cómo hacer el caballito
"));
// → /talks/Cómo%20hacer%20el%20caballito
Una solicitud para crear una charla sobre hacer el caballito podría ser algo así:
PUT /talks/Cómo%20hacer%20el%20caballito HTTP/1.1
Content-Type: application/json
Content-Length: 92
{"presenter": "Maureen",
"summary": "Permanecer quieto sobre un monociclo"}
Estas URLs también admiten solicitudes GET para recuperar la representación
JSON de una charla y solicitudes DELETE para eliminar una charla.
Agregar un comentario a una charla se hace con una solicitud POST a una URL
como /talks/Unituning/comments, con un cuerpo JSON que tiene propiedades
author y message.
POST /talks/Unituning/comments HTTP/1.1
Content-Type: application/json
Content-Length: 72
{"author": "Iman",
"message": "¿Vas a hablar sobre cómo levantar una bicicleta?"}
Para soportar encuestas prolongadas, las solicitudes GET a /talks pueden incluir
encabezados adicionales que informen al servidor para retrasar la respuesta
si no hay nueva información disponible. Usaremos un par de encabezados
normalmente destinados a gestionar el almacenamiento en caché: ETag y If-
None-Match.
Los servidores pueden incluir un encabezado ETag (“etiqueta de entidad”)
373

-- 385 of 445 --

en una respuesta. Su valor es una cadena que identifica la versión actual del
recurso. Los clientes, al solicitar posteriormente ese recurso de nuevo, pueden
hacer una solicitud condicional incluyendo un encabezado If-None-Match cuyo
valor contenga esa misma cadena. Si el recurso no ha cambiado, el servidor
responderá con el código de estado 304, que significa “no modificado”, indicando
al cliente que su versión en caché sigue siendo actual. Cuando la etiqueta no
coincide, el servidor responde como de costumbre.
Necesitamos algo como esto, donde el cliente puede decirle al servidor qué
versión de la lista de charlas tiene, y el servidor responde solo cuando esa lista
ha cambiado. Pero en lugar de devolver inmediatamente una respuesta 304, el
servidor debería demorar la respuesta y devolverla solo cuando haya algo nuevo
disponible o haya transcurrido una cantidad de tiempo determinada. Para dis-
tinguir las solicitudes de encuestas prolongadas de las solicitudes condicionales
normales, les damos otro encabezado, Prefer: wait=90, que le indica al servi-
dor que el cliente está dispuesto a esperar hasta 90 segundos por la respuesta.El
servidor mantendrá un número de versión que actualiza cada vez que cambian
las charlas y lo utilizará como valor ETag. Los clientes pueden hacer solicitudes
como esta para ser notificados cuando las charlas cambien:
GET /talks HTTP/1.1
If-None-Match: "4"
Prefer: wait=90
(pasa el tiempo)
HTTP/1.1 200 OK
Content-Type: application/json
ETag: "5"
Content-Length: 295
[....]
El protocolo descrito aquí no realiza ningún control de acceso. Cualquiera
puede comentar, modificar charlas e incluso eliminarlas. (Dado que Internet
está lleno de matones, poner un sistema en línea sin una protección adicional
probablemente no terminaría bien).
El servidor
Comencemos construyendo la parte del programa del lado del servidor. El
código en esta sección se ejecuta en Node.js.
374

-- 386 of 445 --

Enrutamiento
Nuestro servidor utilizará createServer de Node para iniciar un servidor HTTP.
En la función que maneja una nueva solicitud, debemos distinguir entre los
diferentes tipos de solicitudes (como se determina por el método y la ruta) que
soportamos. Esto se puede hacer con una larga cadena de declaraciones if,
pero hay una manera más elegante.
Un enrutador es un componente que ayuda a despachar una solicitud a la
función que puede manejarla. Puedes indicarle al enrutador, por ejemplo, que
las solicitudes PUT con una ruta que coincida con la expresión regular /^\/talks
\/([^\/]+)$/ (/talks/ seguido de un título de charla) pueden ser manejadas
por una función dada. Además, puede ayudar a extraer las partes significativas
de la ruta (en este caso el título de la charla), envueltas en paréntesis en la
expresión regular, y pasarlas a la función manejadora.
Hay varios paquetes de enrutadores buenos en NPM, pero aquí escribiremos
uno nosotros mismos para ilustrar el principio.
Este es router.mjs, que luego importaremos desde nuestro módulo del servi-
dor:
export class Router {
constructor() {
this.routes = [];
}
add(method, url, handler) {
this.routes.push({method, url, handler});
}
async resolve(request, context) {
let {pathname} = new URL(request.url, "http://d");
for (let {method, url, handler} of this.routes) {
let match = url.exec(pathname);
if (!match || request.method != method) continue;
let parts = match.slice(1).map(decodeURIComponent);
return handler(context, ...parts, request);
}
}
}
El módulo exporta la clase Router. Un objeto de enrutador te permite registrar
manejadores para métodos específicos y patrones de URL con su método add.
Cuando una solicitud se resuelve con el método resolve, el enrutador llama
al manejador cuyo método y URL coinciden con la solicitud y devuelve su
resultado.
Las funciones manejadoras se llaman con el valor context dado a resolve.
375

-- 387 of 445 --

Utilizaremos esto para darles acceso al estado de nuestro servidor. Además,
reciben las cadenas coincidentes para cualquier grupo que hayan definido en su
expresión regular, y el objeto de solicitud. Las cadenas deben ser decodificadas
de la URL ya que la URL cruda puede contener códigos estilo %20.
Sirviendo archivos
Cuando una solicitud no coincide con ninguno de los tipos de solicitud definidos
en nuestro enrutador, el servidor debe interpretarlo como una solicitud de
un archivo en el directorio public. Sería posible usar el servidor de archivos
definido en el Capítulo 20 para servir dichos archivos, pero ni necesitamos ni
queremos admitir solicitudes PUT y DELETE en archivos, y nos gustaría tener
funciones avanzadas como el soporte para almacenamiento en caché. Así que
usemos en cambio un servidor de archivos estático sólido y bien probado de
NPM.
Opté por serve-static. Este no es el único servidor de este tipo en NPM,
pero funciona bien y se ajusta a nuestros propósitos. El paquete serve-static
exporta una función que puede ser llamada con un directorio raíz para producir
una función manipuladora de solicitudes. La función manipuladora acepta
los argumentos request y response proporcionados por el servidor de "node:
http", y un tercer argumento, una función que se llamará si ningún archivo
coincide con la solicitud. Queremos que nuestro servidor primero compruebe
las solicitudes que deberíamos manejar de manera especial, según lo definido
en el enrutador, por lo que lo envolvemos en otra función.
import {createServer} from "node:http";
import serveStatic from "serve-static";
function notFound(request, response) {
response.writeHead(404, "Not found");
response.end("<h1>Not found</h1>");
}
class SkillShareServer {
constructor(talks) {
this.talks = talks;
this.version = 0;
this.waiting = [];
let fileServer = serveStatic("./public");
this.server = createServer((request, response) => {
serveFromRouter(this, request, response, () => {
fileServer(request, response,
376

-- 388 of 445 --

() => notFound(request, response));
});
});
}
start(port) {
this.server.listen(port);
}
stop() {
this.server.close();
}
}
La función serveFromRouter tiene la misma interfaz que fileServer, tomando
los argumentos (request, response, next). Esto nos permite “encadenar”
varios manipuladores de solicitudes, permitiendo que cada uno maneje la so-
licitud o pase la responsabilidad de eso al siguiente manejador. El manejador
final, notFound, simplemente responde con un error de “no encontrado”.
Nuestra función serveFromRouter utiliza una convención similar a la del
servidor de archivos del capítulo anterior para las respuestas: los manejadores
en el enrutador devuelven promesas que se resuelven en objetos que describen
la respuesta.
import {Router} from "./router.mjs";
const router = new Router();
const defaultHeaders = {"Content-Type": "text/plain"};
async function serveFromRouter(server, request,
response, next) {
let resolved = await router.resolve(request, server)
.catch(error => {
if (error.status != null) return error;
return {body: String(error), status: 500};
});
if (!resolved) return next();
let {body, status = 200, headers = defaultHeaders} =
await resolved;
response.writeHead(status, headers);
response.end(body);
}
377

-- 389 of 445 --

Charlas como recursos
Las charlas que se han propuesto se almacenan en la propiedad talks del servi-
dor, un objeto cuyas propiedades son los títulos de las charlas. Agregaremos
algunos controladores a nuestro enrutador que expongan estos como recursos
HTTP bajo /charlas/[título].
El controlador para las solicitudes que GET una sola charla debe buscar la
charla y responder ya sea con los datos JSON de la charla o con una respuesta
de error 404.
const talkPath = /^\/charlas\/([^\/]+)$/;
router.add("GET", talkPath, async (server, title) => {
if (Object.hasOwn(server.talks, title)) {
return {body: JSON.stringify(server.talks[title]),
headers: {"Content-Type": "application/json"}};
} else {
return {status: 404, body: `No se encontró la charla '${title
}'`};
}
});
Eliminar una charla se hace eliminándola del objeto talks.
router.add("DELETE", talkPath, async (server, title) => {
if (Object.hasOwn(server.talks, title)) {
delete server.talks[title];
server.updated();
}
return {status: 204};
});
El método updated, que definiremos más adelante, notifica a las solicitudes de
espera larga sobre el cambio.
Un controlador que necesita leer cuerpos de solicitud es el controlador PUT,
que se utiliza para crear nuevas charlas. Debe verificar si los datos que se le
proporcionaron tienen propiedades presentador y resumen, que son cadenas
de texto. Cualquier dato que provenga de fuera del sistema podría ser un
sinsentido y no queremos corromper nuestro modelo de datos interno o fallar
cuando lleguen solicitudes incorrectas.
Si los datos parecen válidos, el controlador almacena un objeto que representa
la nueva charla en el objeto talks, posiblemente sobrescribiendo una charla
existente con este título, y nuevamente llama a updated.
Para leer el cuerpo del flujo de solicitud, utilizaremos la función json de "
378

-- 390 of 445 --

node:stream/consumers", que recopila los datos en el flujo y luego los analiza
como JSON. Hay exportaciones similares llamadas text (para leer el contenido
como una cadena) y buffer (para leerlo como datos binarios) en este paquete.
Dado que json es un nombre genérico, la importación lo renombra a readJSON
para evitar confusiones.
import {json as readJSON} from "node:stream/consumers"
router.add("PUT", talkPath,
async (server, title, request) => {
let talk = await readJSON(request);
if (!talk ||
typeof talk.presenter != "string" ||
typeof talk.summary != "string") {
return {status: 400, body: "Datos de charla incorrectos"};
}
server.talks[title] = {
title,
presenter: talk.presenter,
summary: talk.summary,
comments: []
};
server.updated();
return {status: 204};
});
```Agregar un ((comentario)) a una ((charla)) funciona de manera
similar. Usamos `readJSON` para obtener el contenido de la
solicitud, validamos los datos resultantes y los almacenamos como
un comentario cuando parecen válidos.
```{includeCode: ">code/skillsharing/skillsharing_server.mjs"}
router.add("POST", /^\/talks\/([^\/]+)\/comments$/,
async (server, title, request) => {
let comment = await readJSON(request);
if (!comment ||
typeof comment.author != "string" ||
typeof comment.message != "string") {
return {status: 400, body: "Datos de comentario incorrectos"};
} else if (Object.hasOwn(server.talks, title)) {
server.talks[title].comments.push(comment);
server.updated();
return {status: 204};
} else {
return {status: 404, body: `No se encontró la charla '${title
}'`};
379

-- 391 of 445 --

}
});
Intentar agregar un comentario a una charla inexistente devuelve un error 404.
Soporte para larga espera
El aspecto más interesante del servidor es la parte que maneja la larga espera.
Cuando llega una solicitud GET para /charlas, puede ser una solicitud regular
o una solicitud de larga espera.
Habrá varios lugares en los que debamos enviar una matriz de charlas al
cliente, por lo que primero definimos un método auxiliar que construya dicha
matriz e incluya un encabezado ETag en la respuesta.
SkillShareServer.prototype.talkResponse = function() {
let talks = Object.keys(this.talks)
.map(title => this.talks[title]);
return {
body: JSON.stringify(talks),
headers: {"Content-Type": "application/json",
"ETag": `"${this.version}"`,
"Cache-Control": "no-store"}
};
};
El controlador en sí mismo necesita examinar los encabezados de la solicitud
para ver si están presentes los encabezados If-None-Match y Prefer. Node
almacena los encabezados, cuyos nombres se especifican como insensibles a
mayúsculas y minúsculas, bajo sus nombres en minúsculas.
router.add("GET", /^\/talks$/, async (server, request) => {
let tag = /"(.*)"/.exec(request.headers["if-none-match"]);
let wait = /\bwait=(\d+)/.exec(request.headers["prefer"]);
if (!tag || tag[1] != server.version) {
return server.talkResponse();
} else if (!wait) {
return {status: 304};
} else {
return server.waitForChanges(Number(wait[1]));
}
});
Si no se proporcionó ninguna etiqueta o se proporcionó una etiqueta que no co-
incide con la versión actual del servidor, el controlador responde con la lista de
charlas. Si la solicitud es condicional y las charlas no han cambiado, consulta-
380

-- 392 of 445 --

mos el encabezado Prefer para ver si debemos retrasar la respuesta o responder
de inmediato.
Las funciones de devolución de llamada para solicitudes retardadas se al-
macenan en la matriz waiting del servidor para que puedan ser notificadas
cuando ocurra algo. El método waitForChanges también establece inmediata-
mente un temporizador para responder con un estado 304 cuando la solicitud
haya esperado el tiempo suficiente.
SkillShareServer.prototype.waitForChanges = function(time) {
return new Promise(resolve => {
this.waiting.push(resolve);
setTimeout(() => {
if (!this.waiting.includes(resolve)) return;
this.waiting = this.waiting.filter(r => r != resolve);
resolve({status: 304});
}, time * 1000);
});
};
Registrar un cambio con updated incrementa la propiedad versión y despierta
todas las solicitudes en espera.
SkillShareServer.prototype.updated = function() {
this.version++;
let response = this.talkResponse();
this.waiting.forEach(resolve => resolve(response));
this.waiting = [];
};
Eso concluye el código del servidor. Si creamos una instancia de SkillShareServer
y la iniciamos en el puerto 8000, el servidor HTTP resultante servirá archivos
desde el subdirectorio public junto con una interfaz para manejar charlas bajo
la URL /talks.
new SkillShareServer({}).start(8000);
El cliente
La parte del cliente del sitio web de intercambio de habilidades consiste en
tres archivos: una pequeña página HTML, una hoja de estilos y un archivo
JavaScript.
381

-- 393 of 445 --

HTML
Es una convención ampliamente utilizada para servidores web intentar servir
un archivo llamado index.html cuando se realiza una solicitud directamente a
una ruta que corresponde a un directorio. El módulo de servidor de archivos
que utilizamos, serve-static, soporta esta convención. Cuando se realiza una
solicitud a la ruta /, el servidor busca el archivo ./public/index.html (./public
siendo la raíz que le dimos) y devuelve ese archivo si se encuentra.
Por lo tanto, si queremos que una página aparezca cuando un navegador
apunta a nuestro servidor, deberíamos colocarla en public/index.html. Este
es nuestro archivo de índice:
<!doctype html>
<meta charset="utf-8">
<title>Intercambio de habilidades</title>
<link rel="stylesheet" href="skillsharing.css">
<h1>Intercambio de habilidades</h1>
<script src="skillsharing_client.js"></script>
Define el título del documento e incluye una hoja de estilos, que define algunos
estilos para, entre otras cosas, asegurarse de que haya algo de espacio entre las
charlas. Luego agrega un encabezado en la parte superior de la página y carga
el script que contiene la aplicación del cliente.
Acciones
El estado de la aplicación consiste en la lista de charlas y el nombre del usuario,
y lo almacenaremos en un objeto {charlas, usuario}. No permitimos que la
interfaz de usuario manipule directamente el estado ni envíe solicitudes HTTP.
En cambio, puede emitir acciones que describen lo que el usuario está inten-
tando hacer.
La función handleAction toma una acción de este tipo y la lleva a cabo.
Debido a que nuestras actualizaciones de estado son tan simples, los cambios
de estado se manejan en la misma función.
function handleAction(state, action) {
if (action.type == "setUser") {
localStorage.setItem("userName", action.user);
return {...state, user: action.user};
} else if (action.type == "setTalks") {
return {...state, talks: action.talks};
} else if (action.type == "newTalk") {
382

-- 394 of 445 --

fetchOK(talkURL(action.title), {
method: "PUT",
headers: {"Content-Type": "application/json"},
body: JSON.stringify({
presenter: state.user,
summary: action.summary
})
}).catch(reportError);
} else if (action.type == "deleteTalk") {
fetchOK(talkURL(action.talk), {method: "DELETE"})
.catch(reportError);
} else if (action.type == "newComment") {
fetchOK(talkURL(action.talk) + "/comments", {
method: "POST",
headers: {"Content-Type": "application/json"},
body: JSON.stringify({
author: state.user,
message: action.message
})
}).catch(reportError);
}
return state;
}
Almacenaremos el nombre del usuario en localStorage para que pueda ser
restaurado cuando se cargue la página.
Las acciones que necesitan involucrar al servidor realizan peticiones a la red,
utilizando fetch, a la interfaz HTTP descrita anteriormente. Utilizamos una
función de envoltura, fetchOK, que se asegura de que la promesa devuelta sea
rechazada cuando el servidor devuelve un código de error.
function fetchOK(url, options) {
return fetch(url, options).then(response => {
if (response.status < 400) return response;
else throw new Error(response.statusText);
});
}
Esta función auxiliar se utiliza para construir una URL para una charla con un
título dado.
function talkURL(title) {
return "talks/" + encodeURIComponent(title);
}
Cuando la petición falla, no queremos que nuestra página simplemente se quede
383

-- 395 of 445 --

ahí, sin hacer nada sin explicación. Así que definimos una función llamada
reportError, que al menos muestra al usuario un cuadro de diálogo que le
informa que algo salió mal.
function reportError(error) {
alert(String(error));
}
Renderización de componentes
Utilizaremos un enfoque similar al que vimos en el Capítulo 19, dividiendo la
aplicación en componentes. Pero dado que algunos de los componentes nunca
necesitan actualizarse o siempre se redibujan por completo cuando se actual-
izan, definiremos aquellos no como clases, sino como funciones que devuelven
directamente un nodo DOM. Por ejemplo, aquí hay un componente que muestra
el campo donde el usuario puede ingresar su nombre:
function renderUserField(name, dispatch) {
return elt("label", {}, "Tu nombre: ", elt("input", {
type: "text",
value: name,
onchange(event) {
dispatch({type: "setUser", user: event.target.value});
}
}));
}
La función elt utilizada para construir elementos DOM es la misma que usamos
en el Capítulo 19.
Se utiliza una función similar para renderizar charlas, que incluyen una lista
de comentarios y un formulario para agregar un nuevo comentario.
function renderTalk(talk, dispatch) {
return elt(
"section", {className: "talk"},
elt("h2", null, talk.title, " ", elt("button", {
type: "button",
onclick() {
dispatch({type: "deleteTalk", talk: talk.title});
}
}, "Eliminar")),
elt("div", null, "por ",
elt("strong", null, talk.presenter)),
elt("p", null, talk.summary),
384

-- 396 of 445 --

...talk.comments.map(renderComment),
elt("form", {
onsubmit(event) {
event.preventDefault();
let form = event.target;
dispatch({type: "newComment",
talk: talk.title,
message: form.elements.comment.value});
form.reset();
}
}, elt("input", {type: "text", name: "comment"}), " ",
elt("button", {type: "submit"}, "Añadir comentario")));
}
El controlador de evento "submit" llama a form.reset para limpiar el contenido
del formulario después de crear una acción "newComment".
Cuando se crean piezas moderadamente complejas del DOM, este estilo de
programación comienza a verse bastante desordenado. Para evitar esto, a
menudo la gente utiliza un lenguaje de plantillas, que permite escribir la in-
terfaz como un archivo HTML con algunos marcadores especiales para indicar
dónde van los elementos dinámicos. O utilizan JSX, un dialecto de JavaScript
no estándar que te permite escribir algo muy parecido a etiquetas HTML en
tu programa como si fueran expresiones JavaScript. Ambos enfoques utilizan
herramientas adicionales para preprocesar el código antes de que pueda ser
ejecutado, lo cual evitaremos en este capítulo.
Los comentarios son simples de renderizar.
function renderComment(comment) {
return elt("p", {className: "comment"},
elt("strong", null, comment.author),
": ", comment.message);
}
Finalmente, el formulario que el usuario puede usar para crear una nueva charla
se representa de la siguiente manera:
function renderTalkForm(dispatch) {
let title = elt("input", {type: "text"});
let summary = elt("input", {type: "text"});
return elt("form", {
onsubmit(event) {
event.preventDefault();
dispatch({type: "newTalk",
title: title.value,
summary: summary.value});
385

-- 397 of 445 --

event.target.reset();
}
}, elt("h3", null, "Enviar una charla"),
elt("label", null, "Título: ", title),
elt("label", null, "Resumen: ", summary),
elt("button", {type: "submit"}, "Enviar"));
}
Sondeo
Para iniciar la aplicación necesitamos la lista actual de charlas. Dado que la
carga inicial está estrechamente relacionada con el proceso de sondeo prolon-
gado, el ETag de la carga debe ser utilizado al sondear, escribiremos una función
que siga sondeando al servidor en busca de /charlas y llame a una función de
devolución de llamada cuando un nuevo conjunto de charlas esté disponible.
async function pollTalks(update) {
let tag = undefined;
for (;;) {
let response;
try {
response = await fetchOK("/charlas", {
headers: tag && {"If-None-Match": tag,
"Prefer": "wait=90"}
});
} catch (e) {
console.log("La solicitud falló: " + e);
await new Promise(resolve => setTimeout(resolve, 500));
continue;
}
if (response.status == 304) continue;
tag = response.headers.get("ETag");
update(await response.json());
}
}
Esta es una función async para facilitar el bucle y la espera de la solicitud.
Ejecuta un bucle infinito que, en cada iteración, recupera la lista de charlas, ya
sea normalmente o, si esta no es la primera solicitud, con las cabeceras incluidas
que la convierten en una solicitud de sondeo prolongado.
Cuando una solicitud falla, la función espera un momento y luego intenta
nuevamente. De esta manera, si tu conexión de red se interrumpe por un tiempo
y luego vuelve, la aplicación puede recuperarse y continuar actualizándose. La
promesa resuelta a través de setTimeout es una forma de forzar a la función
386

-- 398 of 445 --

async a esperar.
Cuando el servidor devuelve una respuesta 304, eso significa que una solicitud
de intercambio de larga duración expiró, por lo que la función debería comenzar
inmediatamente la siguiente solicitud. Si la respuesta es un estado 200 normal,
su cuerpo se lee como JSON y se pasa a la devolución de llamada, y el valor
del encabezado ETag se almacena para la próxima iteración.
La aplicación
El siguiente componente une toda la interfaz de usuario:
class SkillShareApp {
constructor(state, dispatch) {
this.dispatch = dispatch;
this.talkDOM = elt("div", {className: "talks"});
this.dom = elt("div", null,
renderUserField(state.user, dispatch),
this.talkDOM,
renderTalkForm(dispatch));
this.syncState(state);
}
syncState(state) {
if (state.talks != this.talks) {
this.talkDOM.textContent = "";
for (let talk of state.talks) {
this.talkDOM.appendChild(
renderTalk(talk, this.dispatch));
}
this.talks = state.talks;
}
}
}
Cuando las charlas cambian, este componente las vuelve a dibujar todas. Esto
es simple pero también derrochador. Hablaremos sobre eso en los ejercicios.
Podemos iniciar la aplicación de esta manera:
function runApp() {
let user = localStorage.getItem("userName") || "Anon";
let state, app;
function dispatch(action) {
state = handleAction(state, action);
app.syncState(state);
}
387

-- 399 of 445 --

pollTalks(talks => {
if (!app) {
state = {user, talks};
app = new SkillShareApp(state, dispatch);
document.body.appendChild(app.dom);
} else {
dispatch({type: "setTalks", talks});
}
}).catch(reportError);
}
runApp();
Si ejecutas el servidor y abres dos ventanas del navegador para http://localhost:8000
una al lado de la otra, puedes ver que las acciones que realizas en una ventana
son inmediatamente visibles en la otra.
Ejercicios
Los siguientes ejercicios implicarán modificar el sistema definido en este capí-
tulo. Para trabajar en ellos, asegúrate de descargar primero el código (https://eloquentjavascrip
code/skillsharing.zip), tener Node instalado (https://nodejs.org), e instalar la
dependencia del proyecto con npm install.
Persistencia en disco
El servidor de intercambio de habilidades mantiene sus datos puramente en
memoria. Esto significa que cuando se produce un fallo o se reinicia por
cualquier motivo, se pierden todas las charlas y comentarios.
Extiende el servidor para que almacene los datos de las charlas en disco y
vuelva a cargar automáticamente los datos cuando se reinicie. No te preocupes
por la eficiencia, haz lo más simple que funcione.
Restablecimiento del campo de comentarios
La remodelación completa de las charlas funciona bastante bien porque general-
mente no se puede distinguir entre un nodo de DOM y su sustitución idéntica.
Pero hay excepciones. Si empiezas a escribir algo en el campo de comentarios
para una charla en una ventana del navegador y luego, en otra, añades un
comentario a esa charla, el campo en la primera ventana se volverá a dibujar,
eliminando tanto su contenido como su enfoque.
388

-- 400 of 445 --

Cuando varias personas están añadiendo comentarios al mismo tiempo, esto
podría resultar molesto. ¿Puedes idear una manera de resolverlo?
389

-- 401 of 445 --

Exercise Hints
The hints below might help when you are stuck with one of the exercises in
this book. They don’t give away the entire solution, but rather try to help you
find it yourself.
Estructura del Programa
Haciendo un triángulo con bucles
Puedes comenzar con un programa que imprime los números del 1 al 7, el cual
puedes obtener haciendo algunas modificaciones al ejemplo de impresión de
números pares dado anteriormente en el capítulo, donde se introdujo el bucle
for.
Ahora considera la equivalencia entre los números y las cadenas de caracteres
"#" . Puedes pasar de 1 a 2 sumando 1 (+= 1). Puedes pasar de "#" a "##"
agregando un carácter (+= "#"). Por lo tanto, tu solución puede seguir de cerca
el programa de impresión de números.
FizzBuzz
Claramente, recorrer los números es un trabajo de bucle, y seleccionar qué
imprimir es una cuestión de ejecución condicional. Recuerda el truco de usar el
operador de resto (%) para verificar si un número es divisible por otro número
(tiene un resto de cero).
En la primera versión, hay tres resultados posibles para cada número, por lo
que tendrás que crear una cadena if/else if/else.
La segunda versión del programa tiene una solución sencilla y una inteligente.
La solución simple es agregar otra “rama” condicional para probar exactamente
la condición dada. Para la solución inteligente, construye una cadena que
contenga la palabra o palabras a imprimir e imprime esta palabra o el número
si no hay palabra, potencialmente haciendo un buen uso del operador ||.
390

-- 402 of 445 --

Tablero de ajedrez
Para trabajar con dos dimensiones, necesitarás un bucle dentro de otro bucle.
Pon llaves alrededor de los cuerpos de ambos bucles para que sea fácil ver
dónde empiezan y terminan. Intenta indentar correctamente estos cuerpos. El
orden de los bucles debe seguir el orden en el que construimos la cadena (línea
por línea, de izquierda a derecha, de arriba abajo). Entonces el bucle exterior
maneja las líneas y el bucle interior maneja los caracteres en una línea.
Necesitarás dos variables para hacer un seguimiento de tu progreso. Para
saber si debes colocar un espacio o un signo de hash en una posición determi-
nada, podrías verificar si la suma de los dos contadores es par (% 2).
Terminar una línea agregando un carácter de salto de línea debe ocurrir
después de que se haya construido la línea, así que hazlo después del bucle
interno pero dentro del bucle externo.
Funciones
Mínimo
Si tienes problemas para colocar llaves y paréntesis en el lugar correcto para
obtener una definición de función válida, comienza copiando uno de los ejemplos
de este capítulo y modifícalo.
Una función puede contener múltiples declaraciones return.
Recursión
Es probable que tu función se parezca en cierta medida a la función interna
find en el ejemplo recursivo findSolution ejemplo de este capítulo, con una
cadena if/else if/else que prueba cuál de los tres casos aplica. El else
final, correspondiente al tercer caso, realiza la llamada recursiva. Cada una
de las ramas debe contener una declaración return o de alguna otra manera
asegurarse de que se devuelva un valor específico.
Cuando se le da un número negativo, la función se llamará recursivamente
una y otra vez, pasándose a sí misma un número cada vez más negativo, ale-
jándose así más y más de devolver un resultado. Eventualmente se quedará sin
espacio en la pila y se abortará.
Contando frijoles
Tu función necesida un bucle que mire cada carácter en la cadena. Puede
ejecutar un índice desde cero hasta uno menos que su longitud (< string.
391

-- 403 of 445 --

length). Si el carácter en la posición actual es el mismo que el que la función
está buscando, agrega 1 a una variable de contador. Una vez que el bucle ha
terminado, el contador puede ser devuelto.
Ten cuidado de que todas las vinculaciones utilizadas en la función sean
locales a la función, declarándolas correctamente con la palabra clave let o
const.
Estructuras de datos: Objetos y Arrays
La suma de un rango
La construcción de un array se hace más fácilmente inicializando primero un
enlace a [] (un array vacío nuevo) y llamando repetidamente a su método push
para agregar un valor. No olvides devolver el array al final de la función.
Dado que el límite final es inclusivo, necesitarás usar el operador <= en lugar
de < para verificar el final de tu bucle.
El parámetro de paso puede ser un parámetro opcional que por defecto (us-
ando el operador =) es 1.
Hacer que range comprenda valores negativos de paso probablemente sea
mejor haciendo escribiendo dos bucles separados: uno para contar hacia arriba
y otro para contar hacia abajo, porque la comparación que verifica si el bucle
ha terminado necesita ser >= en lugar de <= al contar hacia abajo.
También puede valer la pena usar un paso predeterminado diferente, es de-
cir, -1, cuando el final del rango es menor que el principio. De esa manera,
range(5, 2) devuelve algo significativo, en lugar de quedarse atascado en un
bucle infinito. Es posible hacer referencia a parámetros anteriores en el valor
predeterminado de un parámetro.
Reversión de un array
Hay dos formas obvias de implementar reverseArray. La primera es simple-
mente recorrer el array de entrada de principio a fin y usar el método unshift
en el nuevo array para insertar cada elemento en su inicio. La segunda es recor-
rer el array de entrada hacia atrás y utilizar el método push. Iterar sobre un
array hacia atrás requiere una especificación de bucle (algo incómoda), como
(let i = array.length - 1; i >= 0; i--).
Invertir el array en su lugar es más difícil. Debes tener cuidado de no sobre-
scribir elementos que necesitarás más adelante. Utilizar reverseArray o copiar
todo el array de otra manera (usar array.slice() es una buena forma de copiar
un array) funciona pero es hacer trampa.
392

-- 404 of 445 --

El truco consiste en intercambiar el primer y último elementos, luego el
segundo y el penúltimo, y así sucesivamente. Puedes hacer esto recorriendo la
mitad de la longitud del array (utiliza Math.floor para redondear hacia abajo,
no necesitas tocar el elemento central en un array con un número impar de
elementos) e intercambiando el elemento en la posición i con el que está en
la posición array.length - 1 - i. Puedes utilizar una asignación local para
retener brevemente uno de los elementos, sobrescribirlo con su imagen reflejada,
y luego colocar el valor de la asignación local en el lugar donde solía estar la
imagen reflejada.
Lista
Construir una lista es más fácil cuando se hace de atrás hacia adelante. Por lo
tanto, arrayToList podría iterar sobre el array en reversa (ver ejercicio anterior)
y, para cada elemento, agregar un objeto a la lista. Puedes usar un enlace local
para mantener la parte de la lista que se ha construido hasta el momento y
usar una asignación como lista = {value: X, rest: lista} para añadir un
elemento.
Para recorrer una lista (en listToArray y nth), se puede utilizar una especi-
ficación de bucle for de esta forma:
for (let nodo = list; nodo; nodo = nodo.rest) {}
¿Puedes ver cómo funciona esto? En cada iteración del bucle, nodo apunta a
la sublista actual, y el cuerpo puede leer su propiedad value para obtener el
elemento actual. Al final de una iteración, nodo pasa a la siguiente sublista.
Cuando eso es nulo, hemos llegado al final de la lista y el bucle ha terminado.
La versión recursiva de nth mirará de manera similar una parte cada vez
más pequeña de la “cola” de la lista y al mismo tiempo contará hacia abajo
el índice hasta llegar a cero, momento en el que puede devolver la propiedad
value del nodo que está observando. Para obtener el elemento cero de una lista,
simplemente tomas la propiedad value de su nodo principal. Para obtener el
elemento N + 1, tomas el elemento N -ésimo de la lista que se encuentra en la
propiedad rest de esta lista.
Comparación profunda
La prueba para determinar si estás tratando con un objeto real se verá algo así:
typeof x == "object" && x != null. Ten cuidado de comparar propiedades
solo cuando ambos argumentos sean objetos. En todos los demás casos, sim-
plemente puedes devolver inmediatamente el resultado de aplicar ===.
393

-- 405 of 445 --

Utiliza Object.keys para recorrer las propiedades. Necesitas comprobar si
ambos objetos tienen el mismo conjunto de nombres de propiedades y si esas
propiedades tienen valores idénticos. Una forma de hacerlo es asegurarse de
que ambos objetos tengan el mismo número de propiedades (las longitudes de
las listas de propiedades son iguales). Y luego, al recorrer las propiedades de
uno de los objetos para compararlas, asegúrate siempre primero de que el otro
realmente tenga una propiedad con ese nombre. Si tienen el mismo número de
propiedades y todas las propiedades en uno también existen en el otro, tienen
el mismo conjunto de nombres de propiedades.
Devolver el valor correcto de la función se hace mejor devolviendo inmedi-
atamente false cuando se encuentra una diferencia y devolviendo true al final
de la función.
Funciones de Orden Superior
Everything
Como el operador &&, el método every puede dejar de evaluar más elementos tan
pronto como encuentre uno que no coincida. Por lo tanto, la versión basada en
bucle puede salir del bucle—con break o ‘return—tan pronto como encuentre
un elemento para el que la función de predicado devuelva false. Si el bucle
se ejecuta hasta el final sin encontrar dicho elemento, sabemos que todos los
elementos coincidieron y deberíamos devolver true.
Para construir every sobre some, podemos aplicar leyes de De Morgan, que
establecen que a && b es igual a !(!a || !b). Esto se puede generalizar a ar-
rays, donde todos los elementos en el array coinciden si no hay ningún elemento
en el array que no coincida.
Dirección de escritura dominante
Tu solución podría parecerse mucho a la primera mitad del ejemplo de textScripts
. De nuevo, debes contar caracteres según un criterio basado en characterScript
y luego filtrar la parte del resultado que se refiere a caracteres no interesantes
(sin script).
Encontrar la dirección con el recuento de caracteres más alto se puede hacer
con reduce. Si no está claro cómo hacerlo, consulta el ejemplo anterior en el
capítulo, donde se usó reduce para encontrar el script con más caracteres.
394

-- 406 of 445 --

La Vida Secreta de los Objetos
Un tipo de vector
Mira de nuevo el ejemplo de la clase Rabbit si no estás seguro de cómo se ven
las declaraciones de class.
Agregar una propiedad getter al constructor se puede hacer poniendo la
palabra get antes del nombre del método. Para calcular la distancia desde (0,
0) hasta (x, y), puedes usar el teorema de Pitágoras, que dice que el cuadrado
de la distancia que estamos buscando es igual al cuadrado de la coordenada x
más el cuadrado de la coordenada y. Por lo tanto, √x2 + y2 es el número que
buscas. Math.sqrt es la forma de calcular una raíz cuadrada en JavaScript y
x ** 2 se puede usar para elevar al cuadrado un número.
Grupos
La forma más sencilla de hacer esto es almacenar un array de miembros del
grupo en una propiedad de instancia. Los métodos includes o indexOf se
pueden usar para verificar si un valor dado está en el array.
El constructor de tu clase puede establecer la colección de miembros en un
array vacío. Cuando se llama a add, debe verificar si el valor dado está en el
array o agregarlo, por ejemplo con push, de lo contrario.
Eliminar un elemento de un array, en delete, es menos directo, pero puedes
usar filter para crear un nuevo array sin el valor. No olvides sobrescribir la
propiedad que contiene los miembros con la nueva versión filtrada del array.
El método from puede usar un bucle for/of para obtener los valores del
objeto iterable y llamar a add para colocarlos en un grupo recién creado.
Grupos iterables
Probablemente valga la pena definir una nueva clase GroupIterator. Las in-
stancias del iterador deberían tener una propiedad que rastree la posición actual
en el grupo. Cada vez que se llama a next, verifica si ha terminado y, si no,
avanza más allá del valor actual y lo devuelve.
La clase Group en sí misma obtiene un método nombrado Symbol.iterator
que, al ser llamado, devuelve una nueva instancia de la clase iteradora para ese
grupo.
395

-- 407 of 445 --

Proyecto: Un Robot
Medición de un robot
Tendrás que escribir una variante de la función runRobot que, en lugar de
registrar los eventos en la consola, devuelva el número de pasos que el robot
tomó para completar la tarea.
Tu función de medición puede, entonces, en un bucle, generar nuevos estados
y contar los pasos que toma cada uno de los robots. Cuando haya generado
suficientes mediciones, puede usar console.log para mostrar el promedio de
cada robot, que es el número total de pasos tomados dividido por el número
de mediciones.
Eficiencia del robot
La principal limitación de goalOrientedRobot es que solo considera un paquete
a la vez. A menudo caminará de un lado a otro del pueblo porque el paquete
en el que está centrando su atención sucede que está en el otro lado del mapa,
incluso si hay otros mucho más cerca.
Una posible solución sería calcular rutas para todos paquetes y luego tomar
la más corta. Se pueden obtener resultados aún mejores, si hay múltiples
rutas más cortas, al preferir aquellas que van a recoger un paquete en lugar de
entregarlo.
Grupo persistente
La forma más conveniente de representar el conjunto de valores miembro sigue
siendo como un array, ya que los arrays son fáciles de copiar.
Cuando se añade un valor al grupo, puedes crear un nuevo grupo con una
copia del array original que tenga el valor añadido (por ejemplo, usando concat
). Cuando se elimina un valor, puedes filtrarlo del array.
El constructor de la clase puede tomar dicho array como argumento y alma-
cenarlo como propiedad única de la instancia. Este array nunca se actualiza.
Para añadir la propiedad empty al constructor, puedes declararla como una
propiedad estática.
Solo necesitas una instancia empty porque todos los grupos vacíos son iguales
y las instancias de la clase no cambian. Puedes crear muchos grupos diferentes
a partir de ese único grupo vacío sin afectarlo.
396

-- 408 of 445 --

Bugs y Errores
Reintentar
La llamada a primitiveMultiply definitivamente debería ocurrir en un bloque
try. El bloque catch correspondiente debería relanzar la excepción cuando no
sea una instancia de MultiplicatorUnitFailure y asegurarse de que la llamada
se reintente cuando lo sea.
Para hacer el reintentamiento, puedes usar un bucle que se detenga solo
cuando una llamada tiene éxito, como en el ejemplo de look anterior en este
capítulo, o usar la recursión y esperar que no tengas una cadena tan larga de
fallos que colapse la pila (lo cual es bastante improbable).
La caja cerrada con llave
En este ejercicio, es posible que desees usar try y finally juntos. Tu función
debería desbloquear la caja y luego llamar a la función de argumento desde
dentro de un bloque try. El bloque finally después de él debería volver a
bloquear la caja.
Para asegurarte de que no bloquees la caja cuando no estaba bloqueada,
verifica su bloqueo al comienzo de la función y desbloquéala y bloquéala solo
cuando comenzó bloqueada.
Expresiones regulares
Estilo de comillas
La solución más obvia es reemplazar solo las comillas que tienen un carácter
que no sea una letra en al menos un lado, algo como /\P{L}'|'\P{L}/. Pero
también debes tener en cuenta el inicio y el final de la línea.
Además, debes asegurarte de que la sustitución también incluya los caracteres
que coincidieron con el patrón \P{L} para que no se eliminen. Esto se puede
hacer envolviéndolos entre paréntesis e incluyendo sus grupos en la cadena de
reemplazo ($1, $2). Los grupos que no se emparejen se reemplazarán por nada.
Números nuevamente
Primero, no olvides la barra invertida delante del punto.
Para hacer coincidir el signo opcional delante del número, así como delante
del exponente, se puede hacer con [+\-]? o (\+|-|) (más, menos, o nada).
397

-- 409 of 445 --

La parte más complicada del ejercicio es el problema de hacer coincidir tanto
"5." como ".5" sin hacer coincidir también ".". Para esto, una buena solución
es usar el operador | para separar los dos casos: uno o más dígitos seguidos
opcionalmente por un punto y cero o más dígitos o un punto seguido por uno
o más dígitos.
Finalmente, para hacer que el caso de la e sea insensible a mayúsculas y
minúsculas, añade una opción i a la expresión regular o usa [eE].
Módulos
Un robot modular
Esto es lo que habría hecho (pero de nuevo, no hay una única forma correcta
de diseñar un módulo dado):
El código utilizado para construir el gráfico de carreteras se encuentra en el
módulo graph. Como preferiría usar dijkstrajs de NPM en lugar de nuestro
propio código de búsqueda de caminos, haremos que este construya el tipo
de datos de gráfico que espera dijkstrajs. Este módulo exporta una única
función, buildGraph. Haría que buildGraph aceptara un arreglo de arreglos de
dos elementos, en lugar de cuerdas que contienen guiones, para hacer que el