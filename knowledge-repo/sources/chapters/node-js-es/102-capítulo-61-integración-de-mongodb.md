# Capítulo 61:: Integración de mongodb

Sintaxis
db colección .insertOne ( documento , opciones (w, wtimeout, j, serializeFuntions,
forceServerObjectId, bypassDocumentValidation) , devolución de llamada )
•
db colección .insertMany ( [documentos] , opciones (w, wtimeout, j, serializeFuntions,
forceServerObjectId, bypassDocumentValidation) , devolución de llamada )
•
db colección .find ( consulta )	•
db colección .updateOne ( filtro , actualización , opciones (upsert, w, wtimeout, j,
bypassDocumentValidation) , devolución de llamada )
•
db colección .updateMany ( filtro , actualización , opciones (upsert, w, wtimeout, j) ,
devolución de llamada )
•
db colección .deleteOne ( filtro , opciones (upsert, w, wtimeout, j) , devolución de llamada )	•
db colección .deleteMany ( filtro , opciones (upsert, w, wtimeout, j) , devolución de llamada )	•
Parámetros
Parámetro Detalles
documento Un objeto javascript que representa un documento.
documentos Una serie de documentos
consulta Un objeto que define una consulta de búsqueda.
filtrar Un objeto que define una consulta de búsqueda.
llamar de vuelta Función a llamar cuando se realiza la operación.
opciones (Opcional) Configuraciones opcionales (por defecto: nulo)
w (Opcional) La preocupación de escritura
tiempo fuera (Opcional) El tiempo de espera de escritura escribe. (por
defecto: nulo)
j (opcional) Especifique una preocupación de escritura de diario
(predeterminado: falso)
sobresalir (Opcional) Operación de actualización (por defecto: falso)
multi (opcional) Actualizar uno / todos los documentos (por defecto:
falso)
(Opcional) Serializar funciones en cualquier objeto (por defecto:	serializeFunctions
https://riptutorial.com/es/home 207

-- 235 of 423 --

Parámetro Detalles
falso)
forceServerObjectId (opcional) Forzar al servidor a asignar valores _id en lugar de
controlador (predeterminado: falso)
bypassDocumentValidation (opcional) Permitir que el controlador omita la validación del
esquema en MongoDB 3.2 o superior (predeterminado: falso)
Examples
Conectarse a MongoDB
Conéctese a MongoDB, imprima '¡Conectado!' y cierra la conexión.
const MongoClient = require('mongodb').MongoClient;
var url = 'mongodb://localhost:27017/test';
MongoClient.connect(url, function(err, db) { // MongoClient method 'connect'
if (err) throw new Error(err);
console.log("Connected!");
db.close(); // Don't forget to close the connection when you are done
});
Método MongoClient Connect()
MongoClient.connect ( url , opciones , devolución de llamada )
Argumento Tipo Descripción
url cuerda Una cadena que especifica el servidor IP / nombre de host, puerto y
base de datos
options objeto (Opcional) Configuraciones opcionales (por defecto: nulo)
callback Función Función a llamar cuando se realiza el intento de conexión
La función de callback toma dos argumentos
err : Error: si se produce un error, se definirá el argumento err	•
db : object - La instancia de MongoDB	•
Inserte un documento
Inserte un documento llamado 'myFirstDocument' y establezca 2 propiedades, greetings y
farewell
https://riptutorial.com/es/home 208

-- 236 of 423 --

const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017/test';
MongoClient.connect(url, function (err, db) {
if (err) throw new Error(err);
db.collection('myCollection').insertOne({ // Insert method 'insertOne'
"myFirstDocument": {
"greetings": "Hellu",
"farewell": "Bye"
}
}, function (err, result) {
if (err) throw new Error(err);
console.log("Inserted a document into the myCollection collection!");
db.close(); // Don't forget to close the connection when you are done
});
});
Método de recogida insertOne()
db.collection ( colección ) .insertOne ( documento , opciones , devolución de llamada )
Argumento Tipo Descripción
collection cuerda Una cadena que especifica la colección.
document objeto El documento a insertar en la colección.
options objeto (Opcional) Configuraciones opcionales (por defecto: nulo)
callback Función Función a llamar cuando se realiza la operación de inserción
La función de callback toma dos argumentos
err : Error: si se produce un error, se definirá el argumento err	•
result : objeto - Un objeto que contiene detalles sobre la operación de inserción	•
Leer una coleccion
Obtenga todos los documentos de la colección 'myCollection' e imprímalos en la consola.
const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017/test';
MongoClient.connect(url, function (err, db) {
if (err) throw new Error(err);
var cursor = db.collection('myCollection').find(); // Read method 'find'
cursor.each(function (err, doc) {
if (err) throw new Error(err);
if (doc != null) {
console.log(doc); // Print all documents
} else {
https://riptutorial.com/es/home 209

-- 237 of 423 --

db.close(); // Don't forget to close the connection when you are done
}
});
});
Método de recogida find()
db.collection ( colección ) .find ()
Argumento Tipo Descripción
collection cuerda Una cadena que especifica la colección.
Actualizar un documento
Encuentre un documento con la propiedad { greetings: 'Hellu' } y cámbielo a { greetings:
'Whut?' }
const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017/test';
MongoClient.connect(url, function (err, db) {
if (err) throw new Error(err);
db.collection('myCollection').updateOne({ // Update method 'updateOne'
greetings: "Hellu" },
{ $set: { greetings: "Whut?" }},
function (err, result) {
if (err) throw new Error(err);
db.close(); // Don't forget to close the connection when you are done
});
});
Método de updateOne()
db.collection ( collection ) .updateOne ( filter , update , options . callback )
Parámetro Tipo Descripción
filter objeto Especifica la selección crítica.
update objeto Especifica las modificaciones a aplicar.
options objeto (Opcional) Configuraciones opcionales (por defecto: nulo)
callback Función Función a llamar cuando se realiza la operación.
La función de callback toma dos argumentos
https://riptutorial.com/es/home 210

-- 238 of 423 --

err : Error: si se produce un error, se definirá el argumento err	•
db : object - La instancia de MongoDB	•
Borrar un documento
Eliminar un documento con la propiedad { greetings: 'Whut?' }
const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017/test';
MongoClient.connect(url, function (err, db) {
if (err) throw new Error(err);
db.collection('myCollection').deleteOne(// Delete method 'deleteOne'
{ greetings: "Whut?" },
function (err, result) {
if (err) throw new Error(err);
db.close(); // Don't forget to close the connection when you are done
});
});
Método de deleteOne()
db.collection ( colección ) .deleteOne ( filtro , opciones , devolución de llamada )
Parámetro Tipo Descripción
filter objeto Un documento que especifica la selección crítica.
options objeto (Opcional) Configuraciones opcionales (por defecto: nulo)
callback Función Función a llamar cuando se realiza la operación.
La función de callback toma dos argumentos
err : Error: si se produce un error, se definirá el argumento err	•
db : object - La instancia de MongoDB	•
Eliminar múltiples documentos
Elimine TODOS los documentos con una propiedad de "despedida" establecida en "bien".
const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017/test';
MongoClient.connect(url, function (err, db) {
if (err) throw new Error(err);
db.collection('myCollection').deleteMany(// MongoDB delete method 'deleteMany'
{ farewell: "okay" }, // Delete ALL documents with the property 'farewell: okay'
function (err, result) {
https://riptutorial.com/es/home 211

-- 239 of 423 --

if (err) throw new Error(err);
db.close(); // Don't forget to close the connection when you are done
});
});
Método de deleteMany()
db.collection ( colección ) .deleteMany ( filtro , opciones , devolución de llamada )
Parámetro Tipo Descripción
filter documento Un documento que especifica la selección crítica.
options objeto (Opcional) Configuraciones opcionales (por defecto: nulo)
callback función Función a llamar cuando se realiza la operación.
La función de callback toma dos argumentos
err : Error: si se produce un error, se definirá el argumento err	•
db : object - La instancia de MongoDB	•
Conexión simple
MongoDB.connect('mongodb://localhost:27017/databaseName', function(error, database) {
if(error) return console.log(error);
const collection = database.collection('collectionName');
collection.insert({key: 'value'}, function(error, result) {
console.log(error, result);
});
});
Conexión simple, utilizando promesas.
const MongoDB = require('mongodb');
MongoDB.connect('mongodb://localhost:27017/databaseName')
.then(function(database) {
const collection = database.collection('collectionName');
return collection.insert({key: 'value'});
})
.then(function(result) {
console.log(result);
});
```
Lea Integración de mongodb en línea: https://riptutorial.com/es/node-js/topic/5002/integracion-de-
mongodb
https://riptutorial.com/es/home 212

-- 240 of 423 --