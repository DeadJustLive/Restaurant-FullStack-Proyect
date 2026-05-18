# Capítulo 11:: Biblioteca de mangosta

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 45)

## Contenido
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
Para esto, inicie MongoD
