# Capítulo 62:: Integración de MongoDB para

Node.js / Express.js
Introducción
MongoDB es una de las bases de datos NoSQL más populares, gracias a la ayuda de la pila
MEAN. La interfaz con una base de datos Mongo desde una aplicación Express es rápida y fácil,
una vez que entienda la sintaxis de consulta un tanto torpe. Usaremos Mangosta para ayudarnos.
Observaciones
Puede encontrar más información aquí: http://mongoosejs.com/docs/guide.html
Examples
Instalación de MongoDB
npm install --save mongodb
npm install --save mongoose //A simple wrapper for ease of development
En su archivo de servidor (normalmente denominado index.js o server.js)
const express = require('express');
const mongodb = require('mongodb');
const mongoose = require('mongoose');
const mongoConnectString = 'http://localhost/database name';
mongoose.connect(mongoConnectString, (err) => {
if (err) {
console.log('Could not connect to the database');
}
});
Creando un Modelo de Mangosta
const Schema = mongoose.Schema;
const ObjectId = Schema.Types.ObjectId;
const Article = new Schema({
title: {
type: String,
unique: true,
required: [true, 'Article must have title']
},
author: {
type: ObjectId,
ref: 'User'
https://riptutorial.com/es/home 213

-- 241 of 423 --

}
});
module.exports = mongoose.model('Article, Article);
Vamos a analizar esto. MongoDB y Mongoose usan JSON (en realidad BSON, pero eso es
irrelevante aquí) como formato de datos. En la parte superior, he establecido algunas variables
para reducir la escritura.
Creo un new Schema y lo asigno a una constante. Es simple JSON, y cada atributo es otro Objeto
con propiedades que ayudan a imponer un esquema más consistente. Unique obliga a que se
inserten nuevas instancias en la base de datos para, obviamente, ser únicas. Esto es excelente
para evitar que un usuario cree varias cuentas en un servicio.
Requerido es otro, declarado como una matriz. El primer elemento es el valor booleano y el
segundo es el mensaje de error si el valor que se inserta o actualiza no existe.
Los ObjectIds se utilizan para relaciones entre modelos. Los ejemplos pueden ser 'Los usuarios
tienen muchos comentarios'. Se pueden usar otros atributos en lugar de ObjectId. Cadenas como
un nombre de usuario es un ejemplo.
Por último, la exportación del modelo para usar con las rutas de su API le brinda acceso a su
esquema.
Consultar tu base de datos Mongo
Una simple solicitud GET. Supongamos que el modelo del ejemplo anterior está en el archivo
./db/models/Article.js .
const express = require('express');
const Articles = require('./db/models/Article');
module.exports = function (app) {
const routes = express.Router();
routes.get('/articles', (req, res) => {
Articles.find().limit(5).lean().exec((err, doc) => {
if (doc.length > 0) {
res.send({ data: doc });
} else {
res.send({ success: false, message: 'No documents retrieved' });
}
});
});
app.use('/api', routes);
};
Ahora podemos obtener los datos de nuestra base de datos enviando una solicitud HTTP a este
punto final. Algunas cosas clave, sin embargo:
El límite hace exactamente lo que parece. Solo estoy recibiendo 5 documentos de vuelta.	1.
https://riptutorial.com/es/home 214

-- 242 of 423 --

Lean elimina algunas cosas del BSON en bruto, reduciendo la complejidad y los gastos
generales. No requerido. Pero útil.
2.
Cuando use find lugar de findOne , confirme que doc.length es mayor que 0. Esto se debe a
que find siempre devuelve una matriz, por lo que una matriz vacía no manejará su error a
menos que se verifique la longitud
3.
Personalmente me gusta enviar el mensaje de error en ese formato. Cámbiala según tus
necesidades. Lo mismo para el documento devuelto.
4.
El código en este ejemplo se escribe bajo el supuesto de que lo ha colocado en otro archivo
y no directamente en el servidor Express. Para llamar a esto en el servidor, incluya estas
líneas en su código de servidor:
5.
const app = express();
require('./path/to/this/file')(app) //
Lea Integración de MongoDB para Node.js / Express.js en línea: https://riptutorial.com/es/node-
js/topic/9020/integracion-de-mongodb-para-node-js---express-js
https://riptutorial.com/es/home 215

-- 243 of 423 --