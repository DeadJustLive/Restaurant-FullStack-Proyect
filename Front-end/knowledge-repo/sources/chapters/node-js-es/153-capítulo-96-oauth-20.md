# Capítulo 96:: OAuth 2.0

Examples
OAuth 2 con implementación de Redis - grant_type: contraseña
En este ejemplo usaré oauth2 en la api de descanso con la base de datos redis
Importante: Necesitará instalar la base de datos de redis en su máquina, descárguela
desde aquí para los usuarios de Linux y desde aquí para instalar la versión de
Windows, y usaremos la aplicación de escritorio de redis manager, instálela desde
aquí .
Ahora tenemos que configurar nuestro servidor node.js para usar la base de datos redis.
Creando el archivo del servidor: app.js	•
var express = require('express'),
bodyParser = require('body-parser'),
oauthserver = require('oauth2-server'); // Would be: 'oauth2-server'
var app = express();
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
app.oauth = oauthserver({
model: require('./routes/Oauth2/model'),
grants: ['password', 'refresh_token'],
debug: true
});
// Handle token grant requests
app.all('/oauth/token', app.oauth.grant());
app.get('/secret', app.oauth.authorise(), function (req, res) {
// Will require a valid access_token
res.send('Secret area');
});
app.get('/public', function (req, res) {
// Does not require an access_token
res.send('Public area');
});
// Error handling
app.use(app.oauth.errorHandler());
app.listen(3000);
Cree el modelo Oauth2 en las rutas / Oauth2 / model.js	•
https://riptutorial.com/es/home 321

-- 349 of 423 --

var model = module.exports,
util = require('util'),
redis = require('redis');
var db = redis.createClient();
var keys = {
token: 'tokens:%s',
client: 'clients:%s',
refreshToken: 'refresh_tokens:%s',
grantTypes: 'clients:%s:grant_types',
user: 'users:%s'
};
model.getAccessToken = function (bearerToken, callback) {
db.hgetall(util.format(keys.token, bearerToken), function (err, token) {
if (err) return callback(err);
if (!token) return callback();
callback(null, {
accessToken: token.accessToken,
clientId: token.clientId,
expires: token.expires ? new Date(token.expires) : null,
userId: token.userId
});
});
};
model.getClient = function (clientId, clientSecret, callback) {
db.hgetall(util.format(keys.client, clientId), function (err, client) {
if (err) return callback(err);
if (!client || client.clientSecret !== clientSecret) return callback();
callback(null, {
clientId: client.clientId,
clientSecret: client.clientSecret
});
});
};
model.getRefreshToken = function (bearerToken, callback) {
db.hgetall(util.format(keys.refreshToken, bearerToken), function (err, token) {
if (err) return callback(err);
if (!token) return callback();
callback(null, {
refreshToken: token.accessToken,
clientId: token.clientId,
expires: token.expires ? new Date(token.expires) : null,
userId: token.userId
});
});
};
model.grantTypeAllowed = function (clientId, grantType, callback) {
db.sismember(util.format(keys.grantTypes, clientId), grantType, callback);
};
https://riptutorial.com/es/home 322

-- 350 of 423 --

model.saveAccessToken = function (accessToken, clientId, expires, user, callback) {
db.hmset(util.format(keys.token, accessToken), {
accessToken: accessToken,
clientId: clientId,
expires: expires ? expires.toISOString() : null,
userId: user.id
}, callback);
};
model.saveRefreshToken = function (refreshToken, clientId, expires, user, callback) {
db.hmset(util.format(keys.refreshToken, refreshToken), {
refreshToken: refreshToken,
clientId: clientId,
expires: expires ? expires.toISOString() : null,
userId: user.id
}, callback);
};
model.getUser = function (username, password, callback) {
db.hgetall(util.format(keys.user, username), function (err, user) {
if (err) return callback(err);
if (!user || password !== user.password) return callback();
callback(null, {
id: username
});
});
};
Solo necesita instalar redis en su máquina y ejecutar el siguiente archivo de nodo
#! /usr/bin/env node
var db = require('redis').createClient();
db.multi()
.hmset('users:username', {
id: 'username',
username: 'username',
password: 'password'
})
.hmset('clients:client', {
clientId: 'client',
clientSecret: 'secret'
})//clientId + clientSecret to base 64 will generate Y2xpZW50OnNlY3JldA==
.sadd('clients:client:grant_types', [
'password',
'refresh_token'
])
.exec(function (errs) {
if (errs) {
console.error(errs[0].message);
return process.exit(1);
}
console.log('Client and user added successfully');
process.exit();
});
https://riptutorial.com/es/home 323

-- 351 of 423 --

Nota : este archivo establecerá las credenciales para que su interfaz de usuario solicite el token.
Ejemplo de base de datos redis después de llamar al archivo anterior:
La solicitud será de la siguiente manera:
Ejemplo de llamada a api
https://riptutorial.com/es/home 324

-- 352 of 423 --

Encabezamiento:
autorización: Básico seguido de la contraseña establecida al configurar por primera vez
redis:
a. clientId + secretId a base64
1.
Formulario de datos:
nombre de usuario: usuario que solicita token
contraseña: contraseña de usuario
2.
https://riptutorial.com/es/home 325

-- 353 of 423 --

grant_type: depende de las opciones que desee, elijo passwod, que solo
requiere la creación de un nombre de usuario y una contraseña en redis, los
datos en redis serán los siguientes:
{
"access_token":"1d3fe602da12a086ecb2b996fd7b7ae874120c4f",
"token_type":"bearer", // Will be used to access api + access+token e.g. bearer
1d3fe602da12a086ecb2b996fd7b7ae874120c4f
"expires_in":3600,
"refresh_token":"b6ad56e5c9aba63c85d7e21b1514680bbf711450"
}
Por lo tanto, debemos llamar a nuestra API y obtener algunos datos seguros con nuestro token de
acceso que acabamos de crear, vea a continuación:
https://riptutorial.com/es/home 326

-- 354 of 423 --

cuando el token caduque, la API arrojará el error de que el token caduca y no puede tener acceso
a ninguna de las llamadas a la API, vea la imagen a continuación:
https://riptutorial.com/es/home 327

-- 355 of 423 --

Veamos qué hacer si el token caduca. Permítame explicárselo primero. Si el token de
acceso caduca, existe un refresh_token en redis que hace referencia al access_token
caducado. Entonces, lo que necesitamos es llamar a oauth / token nuevamente con el
refresh_token grant_type y establecer el Autorización a la ID de cliente básica:
clientsecret (para basar 64!) y, finalmente, enviar el refresh_token, esto generará un
nuevo access_token con una nueva fecha de caducidad.
La siguiente imagen muestra cómo obtener un nuevo token de acceso:
https://riptutorial.com/es/home 328

-- 356 of 423 --

Espero ayudar!
Lea OAuth 2.0 en línea: https://riptutorial.com/es/node-js/topic/9566/oauth-2-0
https://riptutorial.com/es/home 329

-- 357 of 423 --