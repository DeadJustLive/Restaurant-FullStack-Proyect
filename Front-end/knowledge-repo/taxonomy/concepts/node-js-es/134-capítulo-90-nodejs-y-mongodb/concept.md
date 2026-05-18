# Capítulo 90:: Node.JS y MongoDB.

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 134)

## Contenido
# Capítulo 90:: Node.JS y MongoDB.

Observaciones
Estas son las operaciones básicas de CRUD para usar mongo db con nodejs.
Pregunta: ¿Hay otras formas de hacer lo que se hace aquí?
Respuesta: Sí, hay muchas maneras de hacer esto.
Pregunta: ¿Es necesario usar la mangosta?
Respuesta: No. Hay otros paquetes disponibles que pueden ayudarlo.
Pregunta: ¿Dónde puedo obtener la documentación completa de la mangosta?
Respuesta: Haga clic aquí
Examples
Conexión a una base de datos
Para conectarnos a una base de datos mongo desde la aplicación de nodo, necesitamos
mongoose.
Instalación de Mongoose Vaya al inicio de su aplicación e instale mongoose en
npm install mongoose
A continuación nos conectamos a la base de datos.
var mongoose = require('mongoose');
//connect to the test database running on default mongod port of localhost
mongoose.connect('mongodb://localhost/test');
//Connecting with custom credentials
mongoose.connect('mongodb://USER:PASSWORD@HOST:PORT/DATABASE');
//Using Pool Size to define the number of connections opening
//Also you can use a call back function for error handling
mongoose.connect('mongodb://localhost:27017/consumers',
{server: { poolSize: 50 }},
function(err) {
if(err) {
console.log('error in this')
console.log(err);
https://riptutorial.com/es/home 286

-- 314 of 423 --

// Do whatever to handle the error
} else {
console.log('Connected to the database');
}
});
Creando nueva colección
Con Mongoose, todo se deriva de un esquema. Permite crear un esquema.
var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var AutoSchema = new Schema({
name : String,
countOf: Number,
});
// defining the document structure
// by default the collection created in the db would be the first parameter we use (or the
plural of it)
module.exports = mongoose.model('Auto', AutoSchema);
// we can over write it and define the collection name by specifying that in the third
parameters.
module.exports = mongoose.model('Auto', AutoSchema, 'collectionName');
// We can also define methods in the models.
AutoSchema.methods.speak = function () {
var greeting = this.name
? "Hello this is " + this.name+ " and I have counts of "+ this.countOf
: "I don't have a name";
console.log(greeting);
}
mongoose.model('Auto', AutoSchema, 'collectionName');
Recuerde que los métodos deben agregarse al esquema antes de compilarlo con
mongoose.model () como se hizo anteriormente.
Insertando Documentos
Para insertar un nuevo documento en la colección, creamos un objeto del esquema.
var Auto = require('models/auto')
var autoObj = new Auto({
name: "NewName",
countOf: 10
});
Lo guardamos como el siguiente
autoObj.save(function(err, insertedAuto) {
if (err) return console.error(err);
https://riptutorial.com/es/home 287

-- 315 of 423 --

insertedAuto.speak();
// output: Hello this is NewName and I have counts of 10
});
Esto insertará un nuevo documento en la colección.
Leyendo
Leer datos de la colección es muy fácil. Obteniendo todos los datos de la colección.
var Auto = require('models/auto')
Auto.find({}, function (err, autos) {
if (err) return console.error(err);
// will return a json array of all the documents in the collection
console.log(autos);
})
Lectura de datos con una condición
Auto.find({countOf: {$gte: 5}}, function (err, autos) {
if (err) return console.error(err);
// will return a json array of all the documents in the collection whose count is
greater than 5
console.log(autos);
})
También puede especificar el segundo parámetro como objeto de todos los campos que necesita
Auto.find({},{name:1}, function (err, autos) {
if (err) return console.error(err);
// will return a json array of name field of all the documents in the collection
console.log(autos);
})
Encontrar un documento en una colección.
Auto.findOne({name:"newName"}, function (err, auto) {
if (err) return console.error(err);
//will return the first object of the document whose name is "newName"
console.log(auto);
})
Encontrar un documento en una colección por id.
Auto.findById(123, function (err, auto) {
if (err) return console.error(err);
//will return the first json object of the document whose id is 123
console.log(auto);
})
Actualizando
https://riptutorial.com/es/home 288

-- 316 of 423 --

Para actualizar colecciones y documentos podemos utilizar cualquiera de estos métodos:
Métodos
actualizar()	•
updateOne ()	•
updateMany ()	•
replaceOne ()	•
Actualizar()
El método update () modifica uno o varios documentos (parámetros de actualización)
db.lights.update(
{ room: "Bedroom" },
{ status: "On" }
)
Esta operación busca en la colección de 'luces' un documento donde la room es Dormitorio (1er
parámetro) . A continuación, actualiza la propiedad de status documentos coincidentes a
Activado (2º parámetro) y devuelve un objeto WriteResult que tiene este aspecto:
{ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 }
UpdateOne
El método UpdateOne () modifica UN documento (parámetros de actualización)
db.countries.update(
{ country: "Sweden" },
{ capital: "Stockholm" }
)
