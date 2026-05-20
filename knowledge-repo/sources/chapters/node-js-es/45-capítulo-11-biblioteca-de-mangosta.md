# Capítulo 11:: Biblioteca de mangosta

Examples
Conéctate a MongoDB utilizando Mongoose
Primero, instale Mongoose con:
npm install mongoose
Luego, agréguelo a server.js como dependencias:
var mongoose = require('mongoose');
var Schema = mongoose.Schema;
A continuación, cree el esquema de base de datos y el nombre de la colección:
var schemaName = new Schema({
request: String,
time: Number
}, {
collection: 'collectionName'
});
Crea un modelo y conéctate a la base de datos:
var Model = mongoose.model('Model', schemaName);
mongoose.connect('mongodb://localhost:27017/dbName');
A continuación, inicie MongoDB y ejecute server.js usando node server.js
Para verificar si nos hemos conectado con éxito a la base de datos, podemos usar los eventos
open , error del objeto mongoose.connection .
var db = mongoose.connection;
db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function() {
// we're connected!
});
Guarde datos en MongoDB utilizando las rutas Mongoose y Express.js
Preparar
Primero, instale los paquetes necesarios con:
https://riptutorial.com/es/home 65

-- 93 of 423 --

npm install express cors mongoose
Código
Luego, agregue dependencias a su archivo server.js , cree el esquema de la base de datos y el
nombre de la colección, cree un servidor Express.js y conéctese a MongoDB:
var express = require('express');
var cors = require('cors'); // We will use CORS to enable cross origin domain requests.
var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var app = express();
var schemaName = new Schema({
request: String,
time: Number
}, {
collection: 'collectionName'
});
var Model = mongoose.model('Model', schemaName);
mongoose.connect('mongodb://localhost:27017/dbName');
var port = process.env.PORT || 8080;
app.listen(port, function() {
console.log('Node.js listening on port ' + port);
});
Ahora agregue las rutas Express.js que usaremos para escribir los datos:
app.get('/save/:query', cors(), function(req, res) {
var query = req.params.query;
var savedata = new Model({
'request': query,
'time': Math.floor(Date.now() / 1000) // Time of save the data in unix timestamp
format
}).save(function(err, result) {
if (err) throw err;
if(result) {
res.json(result)
}
})
})
Aquí la variable de query será el parámetro <query> de la solicitud HTTP entrante, que se guardará
en MongoDB:
var savedata = new Model({
'request': query,
//...
https://riptutorial.com/es/home 66

-- 94 of 423 --

Si se produce un error al intentar escribir en MongoDB, recibirá un mensaje de error en la
consola. Si todo tiene éxito, verá los datos guardados en formato JSON en la página.
//...
}).save(function(err, result) {
if (err) throw err;
if(result) {
res.json(result)
}
})
//...
Ahora, necesita iniciar MongoDB y ejecutar su archivo server.js usando node server.js .
Uso
Para usar esto para guardar datos, vaya a la siguiente URL en su navegador:
http://localhost:8080/save/<query>
Donde <query> es la nueva solicitud que desea guardar.
Ejemplo:
http://localhost:8080/save/JavaScript%20is%20Awesome
Salida en formato JSON:
{
__v: 0,
request: "JavaScript is Awesome",
time: 1469411348,
_id: "57957014b93bc8640f2c78c4"
}
Encuentre datos en MongoDB utilizando las rutas de Mongoose y Express.js
Preparar
Primero, instale los paquetes necesarios con:
npm install express cors mongoose
Código
https://riptutorial.com/es/home 67

-- 95 of 423 --

Luego, agregue dependencias a server.js , cree el esquema de la base de datos y el nombre de
la colección, cree un servidor Express.js y conéctese a MongoDB:
var express = require('express');
var cors = require('cors'); // We will use CORS to enable cross origin domain requests.
var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var app = express();
var schemaName = new Schema({
request: String,
time: Number
}, {
collection: 'collectionName'
});
var Model = mongoose.model('Model', schemaName);
mongoose.connect('mongodb://localhost:27017/dbName');
var port = process.env.PORT || 8080;
app.listen(port, function() {
console.log('Node.js listening on port ' + port);
});
Ahora agregue las rutas Express.js que usaremos para consultar los datos:
app.get('/find/:query', cors(), function(req, res) {
var query = req.params.query;
Model.find({
'request': query
}, function(err, result) {
if (err) throw err;
if (result) {
res.json(result)
} else {
res.send(JSON.stringify({
error : 'Error'
}))
}
})
})
Suponga que los siguientes documentos están en la colección en el modelo:
{
"_id" : ObjectId("578abe97522ad414b8eeb55a"),
"request" : "JavaScript is Awesome",
"time" : 1468710551
}
{
"_id" : ObjectId("578abe9b522ad414b8eeb55b"),
"request" : "JavaScript is Awesome",
"time" : 1468710555
}
{
"_id" : ObjectId("578abea0522ad414b8eeb55c"),
https://riptutorial.com/es/home 68

-- 96 of 423 --

"request" : "JavaScript is Awesome",
"time" : 1468710560
}
Y el objetivo es encontrar y mostrar todos los documentos que contienen "JavaScript is Awesome"
bajo la tecla "request" .
Para esto, inicie MongoDB y ejecute server.js con node server.js :
Uso
Para usar esto para encontrar datos, vaya a la siguiente URL en un navegador:
http://localhost:8080/find/<query>
Donde <query> es la consulta de búsqueda.
Ejemplo:
http://localhost:8080/find/JavaScript%20is%20Awesome
Salida:
[{
_id: "578abe97522ad414b8eeb55a",
request: "JavaScript is Awesome",
time: 1468710551,
__v: 0
},
{
_id: "578abe9b522ad414b8eeb55b",
request: "JavaScript is Awesome",
time: 1468710555,
__v: 0
},
{
_id: "578abea0522ad414b8eeb55c",
request: "JavaScript is Awesome",
time: 1468710560,
__v: 0
}]
Encuentre datos en MongoDB usando Mongoose, Express.js Routes y $ text
Operator
Preparar
Primero, instale los paquetes necesarios con:
https://riptutorial.com/es/home 69

-- 97 of 423 --

npm install express cors mongoose
Código
Luego, agregue dependencias a server.js , cree el esquema de la base de datos y el nombre de
la colección, cree un servidor Express.js y conéctese a MongoDB:
var express = require('express');
var cors = require('cors'); // We will use CORS to enable cross origin domain requests.
var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var app = express();
var schemaName = new Schema({
request: String,
time: Number
}, {
collection: 'collectionName'
});
var Model = mongoose.model('Model', schemaName);
mongoose.connect('mongodb://localhost:27017/dbName');
var port = process.env.PORT || 8080;
app.listen(port, function() {
console.log('Node.js listening on port ' + port);
});
Ahora agregue las rutas Express.js que usaremos para consultar los datos:
app.get('/find/:query', cors(), function(req, res) {
var query = req.params.query;
Model.find({
'request': query
}, function(err, result) {
if (err) throw err;
if (result) {
res.json(result)
} else {
res.send(JSON.stringify({
error : 'Error'
}))
}
})
})
Suponga que los siguientes documentos están en la colección en el modelo:
{
"_id" : ObjectId("578abe97522ad414b8eeb55a"),
"request" : "JavaScript is Awesome",
"time" : 1468710551
}
https://riptutorial.com/es/home 70

-- 98 of 423 --

{
"_id" : ObjectId("578abe9b522ad414b8eeb55b"),
"request" : "JavaScript is Awesome",
"time" : 1468710555
}
{
"_id" : ObjectId("578abea0522ad414b8eeb55c"),
"request" : "JavaScript is Awesome",
"time" : 1468710560
}
Y que el objetivo es encontrar y mostrar todos los documentos que contienen solo la palabra
"JavaScript" debajo de la tecla "request" .
Para hacer esto, primero cree un índice de texto para "request" en la colección. Para esto,
agregue el siguiente código a server.js :
schemaName.index({ request: 'text' });
Y reemplazar:
Model.find({
'request': query
}, function(err, result) {
Con:
Model.find({
$text: {
$search: query
}
}, function(err, result) {
Aquí, estamos usando $search operadores $text y $search MongoDB para encontrar todos los
documentos en la colección collectionName que contiene al menos una palabra de la consulta de
búsqueda especificada.
Uso
Para usar esto para encontrar datos, vaya a la siguiente URL en un navegador:
http://localhost:8080/find/<query>
Donde <query> es la consulta de búsqueda.
Ejemplo:
http://localhost:8080/find/JavaScript
https://riptutorial.com/es/home 71

-- 99 of 423 --

Salida:
[{
_id: "578abe97522ad414b8eeb55a",
request: "JavaScript is Awesome",
time: 1468710551,
__v: 0
},
{
_id: "578abe9b522ad414b8eeb55b",
request: "JavaScript is Awesome",
time: 1468710555,
__v: 0
},
{
_id: "578abea0522ad414b8eeb55c",
request: "JavaScript is Awesome",
time: 1468710560,
__v: 0
}]
Índices en modelos.
MongoDB soporta índices secundarios. En Mongoose, definimos estos índices dentro de nuestro
esquema. La definición de índices a nivel de esquema es necesaria cuando necesitamos crear
índices compuestos.
Conexión de la mangosta
var strConnection = 'mongodb://localhost:27017/dbName';
var db = mongoose.createConnection(strConnection)
Creando un esquema básico
var Schema = require('mongoose').Schema;
var usersSchema = new Schema({
username: {
type: String,
required: true,
unique: true
},
email: {
type: String,
required: true
},
password: {
type: String,
required: true
},
created: {
type: Date,
default: Date.now
}
});
var usersModel = db.model('users', usersSchema);
https://riptutorial.com/es/home 72

-- 100 of 423 --

module.exports = usersModel;
De forma predeterminada, la mangosta agrega dos nuevos campos a nuestro modelo, incluso
cuando no están definidos en el modelo. Esos campos son:
_carné de identidad
Mongoose asigna a cada uno de sus esquemas un campo _id por defecto si uno no se pasa al
constructor de Schema. El tipo asignado es un ObjectId que coincide con el comportamiento
predeterminado de MongoDB. Si no desea que se agregue un _id a su esquema, puede
deshabilitarlo con esta opción.
var usersSchema = new Schema({
username: {
type: String,
required: true,
unique: true
}, {
_id: false
});
__v o versionKey
VersionKey es una propiedad establecida en cada documento cuando fue creada por primera vez
por Mongoose. Este valor de claves contiene la revisión interna del documento. El nombre de esta
propiedad de documento es configurable.
Puede deshabilitar fácilmente este campo en la configuración del modelo:
var usersSchema = new Schema({
username: {
type: String,
required: true,
unique: true
}, {
versionKey: false
});
Índices compuestos
Podemos crear otros índices además de los que crea Mongoose.
usersSchema.index({username: 1 });
usersSchema.index({email: 1 });
En este caso, nuestro modelo tiene dos índices más, uno para el campo nombre de usuario y otro
para el campo de correo electrónico. Pero podemos crear índices compuestos.
usersSchema.index({username: 1, email: 1 });
Índice de impacto en el rendimiento
https://riptutorial.com/es/home 73

-- 101 of 423 --

De forma predeterminada, la mangosta siempre llama secuencialmente al asegurador para cada
índice y emite un evento de "índice" en el modelo cuando todas las llamadas al asegurador
tuvieron éxito o cuando hubo un error.
En MongoDB, asegúrese de que el índice esté en desuso desde la versión 3.0.0, ahora es un
alias para createIndex.
Se recomienda desactivar el comportamiento configurando la opción autoIndex de su esquema en
falso, o globalmente en la conexión configurando la opción config.autoIndex en falso.
usersSchema.set('autoIndex', false);
Funciones útiles de la mangosta
Mongoose contiene algunas funciones integradas que se basan en el estándar find() .
doc.find({'some.value':5},function(err,docs){
//returns array docs
});
doc.findOne({'some.value':5},function(err,doc){
//returns document doc
});
doc.findById(obj._id,function(err,doc){
//returns document doc
});
encontrar datos en mongodb usando promesas
Preparar
Primero, instale los paquetes necesarios con:
npm install express cors mongoose
Código
Luego, agregue dependencias a server.js , cree el esquema de la base de datos y el nombre de
la colección, cree un servidor Express.js y conéctese a MongoDB:
var express = require('express');
var cors = require('cors'); // We will use CORS to enable cross origin domain requests.
var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var app = express();
https://riptutorial.com/es/home 74

-- 102 of 423 --

var schemaName = new Schema({
request: String,
time: Number
}, {
collection: 'collectionName'
});
var Model = mongoose.model('Model', schemaName);
mongoose.connect('mongodb://localhost:27017/dbName');
var port = process.env.PORT || 8080;
app.listen(port, function() {
console.log('Node.js listening on port ' + port);
});
app.use(function(err, req, res, next) {
console.error(err.stack);
res.status(500).send('Something broke!');
});
app.use(function(req, res, next) {
res.status(404).send('Sorry cant find that!');
});
Ahora agregue las rutas Express.js que usaremos para consultar los datos:
app.get('/find/:query', cors(), function(req, res, next) {
var query = req.params.query;
Model.find({
'request': query
})
.exec() //remember to add exec, queries have a .then attribute but aren't promises
.then(function(result) {
if (result) {
res.json(result)
} else {
next() //pass to 404 handler
}
})
.catch(next) //pass to error handler
})
Suponga que los siguientes documentos están en la colección en el modelo:
{
"_id" : ObjectId("578abe97522ad414b8eeb55a"),
"request" : "JavaScript is Awesome",
"time" : 1468710551
}
{
"_id" : ObjectId("578abe9b522ad414b8eeb55b"),
"request" : "JavaScript is Awesome",
"time" : 1468710555
}
{
"_id" : ObjectId("578abea0522ad414b8eeb55c"),
"request" : "JavaScript is Awesome",
"time" : 1468710560
https://riptutorial.com/es/home 75

-- 103 of 423 --

}
Y el objetivo es encontrar y mostrar todos los documentos que contienen "JavaScript is Awesome"
bajo la tecla "request" .
Para esto, inicie MongoDB y ejecute server.js con node server.js :
Uso
Para usar esto para encontrar datos, vaya a la siguiente URL en un navegador:
http://localhost:8080/find/<query>
Donde <query> es la consulta de búsqueda.
Ejemplo:
http://localhost:8080/find/JavaScript%20is%20Awesome
Salida:
[{
_id: "578abe97522ad414b8eeb55a",
request: "JavaScript is Awesome",
time: 1468710551,
__v: 0
},
{
_id: "578abe9b522ad414b8eeb55b",
request: "JavaScript is Awesome",
time: 1468710555,
__v: 0
},
{
_id: "578abea0522ad414b8eeb55c",
request: "JavaScript is Awesome",
time: 1468710560,
__v: 0
}]
Lea Biblioteca de mangosta en línea: https://riptutorial.com/es/node-js/topic/3486/biblioteca-de-
mangosta
https://riptutorial.com/es/home 76

-- 104 of 423 --