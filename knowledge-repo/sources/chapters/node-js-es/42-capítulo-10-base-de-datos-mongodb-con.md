# Capítulo 10:: Base de datos (MongoDB con

Mangosta)
Examples
Conexión de mangosta
¡Asegúrate de tener mongodb corriendo primero! mongod --dbpath data/
paquete.json
"dependencies": {
"mongoose": "^4.5.5",
}
server.js (ECMA 6)
import mongoose from 'mongoose';
mongoose.connect('mongodb://localhost:27017/stackoverflow-example');
const db = mongoose.connection;
db.on('error', console.error.bind(console, 'DB connection error!'));
server.js (ECMA 5.1)
var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/stackoverflow-example');
var db = mongoose.connection;
db.on('error', console.error.bind(console, 'DB connection error!'));
Modelo
Defina su (s) modelo (s):
app / models / user.js (ECMA 6)
import mongoose from 'mongoose';
const userSchema = new mongoose.Schema({
name: String,
password: String
});
const User = mongoose.model('User', userSchema);
export default User;
https://riptutorial.com/es/home 62

-- 90 of 423 --

aplicación / modelo / usuario.js (ECMA 5.1)
var mongoose = require('mongoose');
var userSchema = new mongoose.Schema({
name: String,
password: String
});
var User = mongoose.model('User', userSchema);
module.exports = User
Insertar datos