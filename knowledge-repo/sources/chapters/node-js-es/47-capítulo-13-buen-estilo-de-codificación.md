# Capítulo 13:: Buen estilo de codificación

Observaciones
Recomendaría a un principiante comenzar con este estilo de codificación. Y si alguien puede
sugerir una mejor manera (ps, opté por esta técnica y está funcionando de manera eficiente para
mí en una aplicación utilizada por más de 100k usuarios), no dude en realizar cualquier
sugerencia. TIA.
Examples
Programa básico de registro.
A través de este ejemplo, se explicará cómo dividir el código node.js en diferentes módulos /
carpetas para una mejor comprensión. Seguir esta técnica hace que sea más fácil para otros
desarrolladores entender el código, ya que puede referirse directamente al archivo en cuestión en
lugar de revisar todo el código. El uso principal es cuando trabajas en un equipo y un nuevo
desarrollador se une en una etapa posterior, le será más fácil combinar con el código en sí.
index.js : - Este archivo gestionará la conexión del servidor.
//Import Libraries
var express = require('express'),
session = require('express-session'),
mongoose = require('mongoose'),
request = require('request');
//Import custom modules
var userRoutes = require('./app/routes/userRoutes');
var config = require('./app/config/config');
//Connect to Mongo DB
mongoose.connect(config.getDBString());
//Create a new Express application and Configure it
var app = express();
//Configure Routes
app.use(config.API_PATH, userRoutes());
//Start the server
app.listen(config.PORT);
console.log('Server started at - '+ config.URL+ ":" +config.PORT);
config.js : -Este archivo administrará todos los parámetros relacionados con la configuración que
permanecerán igual durante todo el proceso.
var config = {
VERSION: 1,
BUILD: 1,
https://riptutorial.com/es/home 79

-- 107 of 423 --

URL: 'http://127.0.0.1',
API_PATH : '/api',
PORT : process.env.PORT || 8080,
DB : {
//MongoDB configuration
HOST : 'localhost',
PORT : '27017',
DATABASE : 'db'
},
/*
* Get DB Connection String for connecting to MongoDB database
*/
getDBString : function(){
return 'mongodb://'+ this.DB.HOST +':'+ this.DB.PORT +'/'+ this.DB.DATABASE;
},
/*
* Get the http URL
*/
getHTTPUrl : function(){
return 'http://' + this.URL + ":" + this.PORT;
}
module.exports = config;
user.js : - Archivo de modelo donde se define el esquema
var mongoose = require('mongoose');
var Schema = mongoose.Schema;
//Schema for User
var UserSchema = new Schema({
name: {
type: String,
// required: true
},
email: {
type: String
},
password: {
type: String,
//required: true
},
dob: {
type: Date,
//required: true
},
gender: {
type: String, // Male/Female
// required: true
}
});
//Define the model for User
var User;
if(mongoose.models.User)
User = mongoose.model('User');
else
User = mongoose.model('User', UserSchema);
https://riptutorial.com/es/home 80

-- 108 of 423 --

//Export the User Model
module.exports = User;
userController : este archivo contiene la función para el registro de usuario
var User = require('../models/user');
var crypto = require('crypto');
//Controller for User
var UserController = {
//Create a User
create: function(req, res){
var repassword = req.body.repassword;
var password = req.body.password;
var userEmail = req.body.email;
//Check if the email address already exists
User.find({"email": userEmail}, function(err, usr){
if(usr.length > 0){
//Email Exists
res.json('Email already exists');
return;
}
else
{
//New Email
//Check for same passwords
if(password != repassword){
res.json('Passwords does not match');
return;
}
//Generate Password hash based on sha1
var shasum = crypto.createHash('sha1');
shasum.update(req.body.password);
var passwordHash = shasum.digest('hex');
//Create User
var user = new User();
user.name = req.body.name;
user.email = req.body.email;
user.password = passwordHash;
user.dob = Date.parse(req.body.dob) || "";
user.gender = req.body.gender;
//Validate the User
user.validate(function(err){
if(err){
res.json(err);
return;
}else{
//Finally save the User
user.save(function(err){
if(err)
{
res.json(err);
https://riptutorial.com/es/home 81

-- 109 of 423 --

return;
}
//Remove Password before sending User details
user.password = undefined;
res.json(user);
return;
});
}
});
}
});
}
}
module.exports = UserController;
userRoutes.js : - Esta es la ruta para userController
var express = require('express');
var UserController = require('../controllers/userController');
//Routes for User
var UserRoutes = function(app)
{
var router = express.Router();
router.route('/users')
.post(UserController.create);
return router;
}
module.exports = UserRoutes;
El ejemplo anterior puede parecer demasiado grande, pero si un principiante en node.js con una
pequeña combinación de conocimiento expreso intenta pasar por esto, lo encontrará fácil y
realmente útil.
Lea Buen estilo de codificación en línea: https://riptutorial.com/es/node-js/topic/6489/buen-estilo-
de-codificacion
https://riptutorial.com/es/home 82

-- 110 of 423 --