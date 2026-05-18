# Capítulo 5:: Aplicaciones Web Con Express

Introducción
Express es un marco de aplicación web Node.js mínimo y flexible, que proporciona un conjunto
robusto de características para crear aplicaciones web.
El sitio web oficial de Express es expressjs.com . La fuente se puede encontrar en GitHub .
Sintaxis
app.get (ruta [, middleware], devolución de llamada [, devolución de llamada ...])	•
app.put (ruta [, middleware], devolución de llamada [, devolución de llamada ...])	•
app.post (ruta [, middleware], devolución de llamada [, devolución de llamada ...])	•
aplicación ['eliminar'] (ruta [, middleware], devolución de llamada [, devolución de llamada
...])
•
app.use (ruta [, middleware], devolución de llamada [, devolución de llamada ...])	•
app.use (devolución de llamada)	•
Parámetros
Parámetro Detalles
path Especifica la parte de la ruta o la URL que manejará la devolución de
llamada dada.
middleware
Una o más funciones que serán llamadas antes de la devolución de
llamada. Esencialmente un encadenamiento de múltiples funciones de
callback de callback . Útil para un manejo más específico, por ejemplo,
autorización o manejo de errores.
callback
Una función que se utilizará para manejar solicitudes a la path
especificada. Se llamará como callback(request, response, next) , donde
request , response y next se describen a continuación.
request
devolución de
llamada
Un objeto que encapsula detalles sobre la solicitud HTTP a la que se llama
la devolución de llamada para que la maneje.
response Un objeto que se utiliza para especificar cómo debe responder el servidor
a la solicitud.
next Una devolución de llamada que pasa el control a la siguiente ruta
coincidente. Acepta un objeto de error opcional.
https://riptutorial.com/es/home 29

-- 57 of 423 --

Examples
Empezando
Primero deberá crear un directorio, acceder a él en su shell e instalar Express usando npm
ejecutando npm install express --save
Cree un archivo y app.js nombre app.js y agregue el siguiente código que crea un nuevo servidor
Express y le agrega un punto final ( /ping ) con el método app.get :
const express = require('express');
const app = express();
app.get('/ping', (request, response) => {
response.send('pong');
});
app.listen(8080, 'localhost');
Para ejecutar su script use el siguiente comando en su shell:
> node app.js
Su aplicación aceptará conexiones en el puerto localhost 8080. Si se omite el argumento del
nombre de host para app.listen , el servidor aceptará las conexiones en la dirección IP de la
máquina, así como en el host local. Si el valor del puerto es 0, el sistema operativo asignará un
puerto disponible.
Una vez que se ejecuta el script, puede probarlo en un shell para confirmar que obtiene la
respuesta esperada, "pong", desde el servidor:
> curl http://localhost:8080/ping
pong
También puede abrir un navegador web, navegar a la url http: // localhost: 8080 / ping para ver el
resultado
Enrutamiento básico
Primero crea una aplicación expresa:
const express = require('express');
const app = express();
Entonces puedes definir rutas como esta:
app.get('/someUri', function (req, res, next) {})
https://riptutorial.com/es/home 30

-- 58 of 423 --

Esa estructura funciona para todos los métodos HTTP y espera una ruta como primer argumento
y un controlador para esa ruta, que recibe los objetos de solicitud y respuesta. Entonces, para los
métodos HTTP básicos, estas son las rutas
// GET www.domain.com/myPath
app.get('/myPath', function (req, res, next) {})
// POST www.domain.com/myPath
app.post('/myPath', function (req, res, next) {})
// PUT www.domain.com/myPath
app.put('/myPath', function (req, res, next) {})
// DELETE www.domain.com/myPath
app.delete('/myPath', function (req, res, next) {})
Puede consultar la lista completa de verbos compatibles aquí . Si desea definir el mismo
comportamiento para una ruta y todos los métodos HTTP, puede usar:
app.all('/myPath', function (req, res, next) {})
o
app.use('/myPath', function (req, res, next) {})
o
app.use('*', function (req, res, next) {})
// * wildcard will route for all paths
Puedes encadenar tus definiciones de ruta para un solo camino
app.route('/myPath')
.get(function (req, res, next) {})
.post(function (req, res, next) {})
.put(function (req, res, next) {})
También puede agregar funciones a cualquier método HTTP. Se ejecutarán antes de la
devolución de llamada final y tomarán los parámetros (req, res, next) como argumentos.
// GET www.domain.com/myPath
app.get('/myPath', myFunction, function (req, res, next) {})
Sus devoluciones de llamada finales se pueden almacenar en un archivo externo para evitar
poner demasiado código en un archivo:
// other.js
exports.doSomething = function(req, res, next) {/* do some stuff */};
https://riptutorial.com/es/home 31

-- 59 of 423 --

Y luego en el archivo que contiene tus rutas:
const other = require('./other.js');
app.get('/someUri', myFunction, other.doSomething);
Esto hará que su código sea mucho más limpio.
Obteniendo información de la solicitud
Para obtener información de la url de solicitud (observe que req es el objeto de solicitud en la
función de controlador de rutas). Considere la definición de esta ruta /settings/:user_id y este
ejemplo particular /settings/32135?field=name
// get the full path
req.originalUrl // => /settings/32135?field=name
// get the user_id param
req.params.user_id // => 32135
// get the query value of the field
req.query.field // => 'name'
También puede obtener los encabezados de la solicitud, como este
req.get('Content-Type')
// "text/plain"
Para simplificar la obtención de otra información puede usar middlewares. Por ejemplo, para
obtener la información del cuerpo de la solicitud, puede usar el middleware del analizador del
cuerpo , que transformará el cuerpo de la solicitud sin formato en un formato utilizable.
var app = require('express')();
var bodyParser = require('body-parser');
app.use(bodyParser.json()); // for parsing application/json
app.use(bodyParser.urlencoded({ extended: true })); // for parsing application/x-www-form-
urlencoded
Ahora supongamos una petición como esta
PUT /settings/32135
{
"name": "Peter"
}
Puedes acceder al nombre publicado así
req.body.name
// "Peter"
De manera similar, puede acceder a las cookies desde la solicitud, también necesita un
https://riptutorial.com/es/home 32

-- 60 of 423 --

middleware como el analizador de cookies.
req.cookies.name
Aplicación express modular
Para hacer expreso de aplicaciones web modulares utilizan las fábricas de enrutadores:
Módulo:
// greet.js
const express = require('express');
module.exports = function(options = {}) { // Router factory
const router = express.Router();
router.get('/greet', (req, res, next) => {
res.end(options.greeting);
});
return router;
};
Solicitud:
// app.js
const express = require('express');
const greetMiddleware = require('./greet.js');
express()
.use('/api/v1/', greetMiddleware({ greeting:'Hello world' }))
.listen(8080);
Esto hará que su aplicación sea modular, personalizable y su código reutilizable.
Al acceder a http://<hostname>:8080/api/v1/greet la salida será Hello world
Ejemplo mas complicado
Ejemplo con servicios que muestra ventajas de middleware factory.
Módulo:
// greet.js
const express = require('express');
module.exports = function(options = {}) { // Router factory
const router = express.Router();
// Get controller
const {service} = options;
router.get('/greet', (req, res, next) => {
https://riptutorial.com/es/home 33

-- 61 of 423 --

res.end(
service.createGreeting(req.query.name || 'Stranger')
);
});
return router;
};
Solicitud:
// app.js
const express = require('express');
const greetMiddleware = require('./greet.js');
class GreetingService {
constructor(greeting = 'Hello') {
this.greeting = greeting;
}
createGreeting(name) {
return `${this.greeting}, ${name}!`;
}
}
express()
.use('/api/v1/service1', greetMiddleware({
service: new GreetingService('Hello'),
}))
.use('/api/v1/service2', greetMiddleware({
service: new GreetingService('Hi'),
}))
.listen(8080);
Al acceder a http://<hostname>:8080/api/v1/service1/greet?name=World la salida será Hello, World y
acceder a http://<hostname>:8080/api/v1/service2/greet?name=World la salida será Hi, World .
Usando un motor de plantillas
Usando un motor de plantillas
El siguiente código configurará Jade como motor de plantillas. (Nota: Jade ha sido renombrada a
pug partir de diciembre de 2015).
const express = require('express'); //Imports the express module
const app = express(); //Creates an instance of the express module
const PORT = 3000; //Randomly chosen port
app.set('view engine','jade'); //Sets jade as the View Engine / Template Engine
app.set('views','src/views'); //Sets the directory where all the views (.jade files) are
stored.
//Creates a Root Route
app.get('/',function(req, res){
res.render('index'); //renders the index.jade file into html and returns as a response.
https://riptutorial.com/es/home 34

-- 62 of 423 --

The render function optionally takes the data to pass to the view.
});
//Starts the Express server with a callback
app.listen(PORT, function(err) {
if (!err) {
console.log('Server is running at port', PORT);
} else {
console.log(JSON.stringify(err));
}
});
De manera similar, también se pueden usar otros motores de plantilla, como los Handlebars ( hbs )
o ejs . Recuerde a npm install el motor de plantillas también. Para Handlebars usamos el paquete
hbs , para Jade tenemos un paquete de jade y para EJS, tenemos un paquete ejs .
Ejemplo de plantilla EJS
Con EJS (como otras plantillas Express), puede ejecutar el código del servidor y acceder a las
variables de su servidor desde su HTML.
En EJS se hace usando " <% " como etiqueta de inicio y " %> " como etiqueta final, las variables
pasadas como parámetros de render pueden accederse usando <%=var_name%>
Por ejemplo, si tiene una matriz de suministros en su código de servidor
puedes recorrerlo usando
<h1><%= title %></h1>
<ul>
<% for(var i=0; i<supplies.length; i++) { %>
<li>
<a href='supplies/<%= supplies[i] %>'>
<%= supplies[i] %>
</a>
</li>
<% } %>
Como puede ver en el ejemplo, cada vez que cambia entre el código del lado del servidor y el
HTML, debe cerrar la etiqueta EJS actual y abrir una nueva más adelante. Aquí queríamos crear
li dentro del comando for así que necesitamos cerrar nuestra etiqueta EJS. al final del for y crear
una nueva etiqueta solo para los corchetes
otro ejemplo
Si queremos que la versión predeterminada de entrada sea una variable del lado del servidor,
usamos <%=
por ejemplo:
Message:<br>
<input type="text" value="<%= message %>" name="message" required>
Aquí, la variable de mensaje que se pasa desde el lado del servidor será el valor predeterminado
de su entrada, tenga en cuenta que si no pasó la variable de mensaje desde el lado del servidor,
EJS generará una excepción. Puede pasar parámetros usando res.render('index', {message:
message}); (para el archivo ejs llamado index.ejs).
https://riptutorial.com/es/home 35

-- 63 of 423 --

En las etiquetas EJS también puede usar if , while o cualquier otro comando javascript que
desee.
API JSON con ExpressJS
var express = require('express');
var cors = require('cors'); // Use cors module for enable Cross-origin resource sharing
var app = express();
app.use(cors()); // for all routes
var port = process.env.PORT || 8080;
app.get('/', function(req, res) {
var info = {
'string_value': 'StackOverflow',
'number_value': 8476
}
res.json(info);
// or
/* res.send(JSON.stringify({
string_value: 'StackOverflow',
number_value: 8476
})) */
//you can add a status code to the json response
/* res.status(200).json(info) */
})
app.listen(port, function() {
console.log('Node.js listening on port ' + port)
})
En http://localhost:8080/ output object
{
string_value: "StackOverflow",
number_value: 8476
}
Sirviendo archivos estáticos
Cuando se crea un servidor web con Express, a menudo se requiere que sirva una combinación
de contenido dinámico y archivos estáticos.
Por ejemplo, puede tener index.html y script.js que son archivos estáticos guardados en el
sistema de archivos.
Es común usar una carpeta llamada 'pública' para tener archivos estáticos. En este caso, la
estructura de la carpeta puede verse como:
project root
https://riptutorial.com/es/home 36

-- 64 of 423 --

├── server.js
├── package.json
└── public
├── index.html
└── script.js
Esta es la forma de configurar Express para servir archivos estáticos:
const express = require('express');
const app = express();
app.use(express.static('public'));
Nota: una vez que la carpeta esté configurada, index.html, script.js y todos los archivos en la
carpeta "pública" estarán disponibles en la ruta raíz (no debe especificar /public/ en la url). Esto
se debe a que, Express busca los archivos relativos a la carpeta estática configurada. Puede
especificar el prefijo de la ruta virtual como se muestra a continuación:
app.use('/static', express.static('public'));
hará que los recursos estén disponibles bajo el prefijo /static/ .
Carpetas multiples
Es posible definir múltiples carpetas al mismo tiempo:
app.use(express.static('public'));
app.use(express.static('images'));
app.use(express.static('files'));
Al servir los recursos Express examinará la carpeta en orden de definición. En el caso de archivos
con el mismo nombre, se servirá el de la primera carpeta coincidente.
Rutas con nombre en estilo Django
Un gran problema es que las rutas con nombre valiosas no son compatibles con Express out of
the box. La solución es instalar un paquete de terceros compatible, por ejemplo, express-reverse :
npm install express-reverse
Conéctalo a tu proyecto:
var app = require('express')();
require('express-reverse')(app);
Entonces úsalo como:
app.get('test', '/hello', function(req, res) {
res.end('hello');
https://riptutorial.com/es/home 37

-- 65 of 423 --

});
La desventaja de este enfoque es que no puede usar el módulo route Express como se muestra
en Uso de enrutador avanzado . La solución es pasar su app como un parámetro a su fábrica de
enrutadores:
require('./middlewares/routing')(app);
Y utilízalo como:
module.exports = (app) => {
app.get('test', '/hello', function(req, res) {
res.end('hello');
});
};
A partir de ahora, puede resolverlo, cómo definir funciones para combinarlas con espacios de
nombres personalizados especificados y apuntar a los controladores apropiados.
Manejo de errores
Manejo básico de errores
De forma predeterminada, Express buscará una vista de 'error' en el directorio /views para
renderizar. Simplemente cree la vista 'error' y colóquela en el directorio de vistas para manejar los
errores. Los errores se escriben con el mensaje de error, el estado y el seguimiento de la pila, por
ejemplo:
vistas / error.pug
html
body
h1= message
h2= error.status
p= error.stack
Manejo avanzado de errores
Defina sus funciones de middleware para el manejo de errores al final de la pila de funciones de
middleware. Estos tienen cuatro argumentos en lugar de tres (err, req, res, next) por ejemplo:
app.js
// catch 404 and forward to error handler
app.use(function(req, res, next) {
var err = new Error('Not Found');
err.status = 404;
//pass error to the next matching route.
next(err);
});
https://riptutorial.com/es/home 38

-- 66 of 423 --

// handle error, print stacktrace
app.use(function(err, req, res, next) {
res.status(err.status || 500);
res.render('error', {
message: err.message,
error: err
});
});
Puede definir varias funciones de middleware de manejo de errores, tal como lo haría con las
funciones de middleware regulares.
Usando middleware y la próxima devolución de llamada
Express pasa la next devolución de llamada a cada controlador de ruta y función de middleware
que puede usarse para romper la lógica de rutas individuales a través de múltiples controladores.
next() llamar a next() sin argumentos, se indica a Express que continúe con el siguiente
middleware o controlador de ruta que coincida. Llamar a next(err) con un error activará cualquier
middleware de controlador de errores. La llamada next('route') pasará por alto cualquier
middleware posterior en la ruta actual y saltará a la siguiente ruta coincidente. Esto permite
desacoplar la lógica del dominio en componentes reutilizables que son autónomos, más sencillos
de probar y más fáciles de mantener y cambiar.
Múltiples rutas coincidentes
Las solicitudes a /api/foo o a /api/bar ejecutarán el controlador inicial para buscar el miembro y
luego pasar el control al controlador real para cada ruta.
app.get('/api', function(req, res, next) {
// Both /api/foo and /api/bar will run this
lookupMember(function(err, member) {
if (err) return next(err);
req.member = member;
next();
});
});
app.get('/api/foo', function(req, res, next) {
// Only /api/foo will run this
doSomethingWithMember(req.member);
});
app.get('/api/bar', function(req, res, next) {
// Only /api/bar will run this
doSomethingDifferentWithMember(req.member);
});
Manejador de errores
Los manejadores de errores son middleware con la function(err, req, res, next) firma
function(err, req, res, next) . Se pueden configurar por ruta (por ejemplo, app.get('/foo',
https://riptutorial.com/es/home 39

-- 67 of 423 --

function(err, req, res, next) ) pero, por lo general, un solo controlador de errores que presente
una página de error es suficiente.
app.get('/foo', function(req, res, next) {
doSomethingAsync(function(err, data) {
if (err) return next(err);
renderPage(data);
});
});
// In the case that doSomethingAsync return an error, this special
// error handler middleware will be called with the error as the
// first parameter.
app.use(function(err, req, res, next) {
renderErrorPage(err);
});
Middleware
Cada una de las funciones anteriores es en realidad una función de middleware que se ejecuta
siempre que una solicitud coincide con la ruta definida, pero cualquier número de funciones de
middleware se puede definir en una sola ruta. Esto permite que el middleware se defina en
archivos separados y que la lógica común se reutilice a través de múltiples rutas.
app.get('/bananas', function(req, res, next) {
getMember(function(err, member) {
if (err) return next(err);
// If there's no member, don't try to look
// up data. Just go render the page now.
if (!member) return next('route');
// Otherwise, call the next middleware and fetch
// the member's data.
req.member = member;
next();
});
}, function(req, res, next) {
getMemberData(req.member, function(err, data) {
if (err) return next(err);
// If this member has no data, don't bother
// parsing it. Just go render the page now.
if (!data) return next('route');
// Otherwise, call the next middleware and parse
// the member's data. THEN render the page.
req.member.data = data;
next();
});
}, function(req, res, next) {
req.member.parsedData = parseMemberData(req.member.data);
next();
});
app.get('/bananas', function(req, res, next) {
renderBananas(req.member);
});
En este ejemplo, cada función de middleware estaría en su propio archivo o en una variable en
otra parte del archivo para que pueda reutilizarse en otras rutas.
https://riptutorial.com/es/home 40

-- 68 of 423 --

Manejo de errores
Los documentos básicos se pueden encontrar aquí
app.get('/path/:id(\\d+)', function (req, res, next) { // please note: "next" is passed
if (req.params.id == 0) // validate param
return next(new Error('Id is 0')); // go to first Error handler, see below
// Catch error on sync operation
var data;
try {
data = JSON.parse('/file.json');
} catch (err) {
return next(err);
}
// If some critical error then stop application
if (!data)
throw new Error('Smth wrong');
// If you need send extra info to Error handler
// then send custom error (see Appendix B)
if (smth)
next(new MyError('smth wrong', arg1, arg2))
// Finish request by res.render or res.end
res.status(200).end('OK');
});
// Be sure: order of app.use have matter
// Error handler
app.use(function(err, req, res, next)) {
if (smth-check, e.g. req.url != 'POST')
return next(err); // go-to Error handler 2.
console.log(req.url, err.message);
if (req.xhr) // if req via ajax then send json else render error-page
res.json(err);
else
res.render('error.html', {error: err.message});
});
// Error handler 2
app.use(function(err, req, res, next)) {
// do smth here e.g. check that error is MyError
if (err instanceof MyError) {
console.log(err.message, err.arg1, err.arg2);
}
...
res.end();
});
Apéndice A
// "In Express, 404 responses are not the result of an error,
// so the error-handler middleware will not capture them."
// You can change it.
https://riptutorial.com/es/home 41

-- 69 of 423 --

app.use(function(req, res, next) {
next(new Error(404));
});
apéndice B
// How to define custom error
var util = require('util');
...
function MyError(message, arg1, arg2) {
this.message = message;
this.arg1 = arg1;
this.arg2 = arg2;
Error.captureStackTrace(this, MyError);
}
util.inherits(MyError, Error);
MyError.prototype.name = 'MyError';
Hook: Cómo ejecutar código antes de cualquier solicitud y después de
cualquier resolución
app.use() y middleware pueden usarse para "antes" y una combinación de los eventos de cierre y
finalización pueden usarse para "después".
app.use(function (req, res, next) {
function afterResponse() {
res.removeListener('finish', afterResponse);
res.removeListener('close', afterResponse);
// actions after response
}
res.on('finish', afterResponse);
res.on('close', afterResponse);
// action before request
// eventually calling `next()`
next();
});
...
app.use(app.router);
Un ejemplo de esto es el middleware del registrador , que se agregará al registro después de la
respuesta de forma predeterminada.
Solo asegúrese de que este "middleware" se use antes de app.router ya que el orden sí importa.
La publicación original está aquí
Manejo de solicitudes POST
Al igual que usted maneja las solicitudes de obtención en Express con el método app.get, puede
usar el método app.post para manejar las solicitudes posteriores.
https://riptutorial.com/es/home 42

-- 70 of 423 --

Pero antes de que pueda manejar las solicitudes POST, necesitará usar el middleware body-
parser del body-parser . Simplemente analiza el cuerpo de POST , PUT , DELETE y otras solicitudes.
Body-Parser middleware Body-Parser analiza el cuerpo de la solicitud y lo convierte en un objeto
disponible en req.body
var bodyParser = require('body-parser');
const express = require('express');
const app = express();
// Parses the body for POST, PUT, DELETE, etc.
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.post('/post-data-here', function(req, res, next){
console.log(req.body); // req.body contains the parsed body of the request.
});
app.listen(8080, 'localhost');
Configuración de cookies con cookie-parser
El siguiente es un ejemplo para configurar y leer cookies utilizando el módulo de análisis de
cookies :
var express = require('express');
var cookieParser = require('cookie-parser'); // module for parsing cookies
var app = express();
app.use(cookieParser());
app.get('/setcookie', function(req, res){
// setting cookies
res.cookie('username', 'john doe', { maxAge: 900000, httpOnly: true });
return res.send('Cookie has been set');
});
app.get('/getcookie', function(req, res) {
var username = req.cookies['username'];
if (username) {
return res.send(username);
}
return res.send('No cookie found');
});
app.listen(3000);
Middleware personalizado en Express
En Express, puede definir middlewares que se pueden usar para verificar solicitudes o configurar
https://riptutorial.com/es/home 43

-- 71 of 423 --

algunos encabezados en respuesta.
app.use(function(req, res, next){ }); // signature
Ejemplo
El siguiente código agrega user al objeto de solicitud y pasa el control a la siguiente ruta
coincidente.
var express = require('express');
var app = express();
//each request will pass through it
app.use(function(req, res, next){
req.user = 'testuser';
next(); // it will pass the control to next matching route
});
app.get('/', function(req, res){
var user = req.user;
console.log(user); // testuser
return res.send(user);
});
app.listen(3000);
Manejo de errores en Express
En Express, puede definir un controlador de errores unificado para el manejo de errores ocurridos
en la aplicación. Defina entonces el controlador al final de todas las rutas y el código lógico.
Ejemplo
var express = require('express');
var app = express();
//GET /names/john
app.get('/names/:name', function(req, res, next){
if (req.params.name == 'john'){
return res.send('Valid Name');
} else{
next(new Error('Not valid name')); //pass to error handler
}
});
//error handler
app.use(function(err, req, res, next){
console.log(err.stack); // e.g., Not valid name
return res.status(500).send('Internal Server Occured');
});
app.listen(3000);
Añadiendo middleware
https://riptutorial.com/es/home 44

-- 72 of 423 --

Las funciones de middleware son funciones que tienen acceso al objeto de solicitud (req), al
objeto de respuesta (res) y a la siguiente función de middleware en el ciclo de solicitud-respuesta
de la aplicación.
Las funciones de middleware pueden ejecutar cualquier código, realizar cambios en los objetos
de res y req , finalizar el ciclo de respuesta y llamar al middleware siguiente.
Un ejemplo muy común de middleware es el módulo cors . Para agregar soporte CORS,
simplemente instálelo, solicítelo y ponga esta línea:
app.use(cors());
Antes de cualquier enrutador o funciones de enrutamiento.
Hola Mundo
Aquí creamos un servidor básico hello world usando Express. Rutas:
'/'	•
'/ wiki'	•
Y para el descanso le dará "404", es decir, página no encontrada.
'use strict';
const port = process.env.PORT || 3000;
var app = require('express')();
app.listen(port);
app.get('/',(req,res)=>res.send('HelloWorld!'));
app.get('/wiki',(req,res)=>res.send('This is wiki page.'));
app.use((req,res)=>res.send('404-PageNotFound'));
Nota: Hemos colocado la ruta 404 como la última ruta, ya que Express apila las rutas en orden y
las procesa para cada solicitud de forma secuencial.
Lea Aplicaciones Web Con Express en línea: https://riptutorial.com/es/node-
js/topic/483/aplicaciones-web-con-express
https://riptutorial.com/es/home 45

-- 73 of 423 --