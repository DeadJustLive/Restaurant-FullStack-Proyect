# Capítulo 45:: Enviar notificación web

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 83)

## Contenido
# Capítulo 45:: Enviar notificación web

Examples
Enviar notificación web utilizando GCM (Google Cloud Messaging System)
Dicho ejemplo es la difusión amplia entre aplicaciones PWA (aplicaciones web progresivas) y en
este ejemplo enviaremos una simple notificación tipo Backend utilizando NodeJS y ES6
Instale el módulo Node-GCM: npm install node-gcm	1.
Instale Socket.io: npm install socket.io	2.
Cree una aplicación habilitada para GCM utilizando la consola de Google.	3.
Grabe su ID de aplicación GCM (la necesitaremos más adelante)	4.
Grabe su código secreto de aplicación GCM.	5.
Abra su editor de código favorito y agregue el siguiente código:
'use strict';
const express = require('express');
const app = express();
const gcm = require('node-gcm');
app.io = require('socket.io')();
// [*] Configuring our GCM Channel.
const sender = new gcm.Sender('Project Secret');
const regTokens = [];
let message = new gcm.Message({
data: {
key1: 'msg1'
}
});
// [*] Configuring our static files.
app.use(express.static('public/'));
// [*] Configuring Routes.
app.get('/', (req, res) => {
res.sendFile(__dirname + '/public/index.html');
});
// [*] Configuring our Socket Connection.
app.io.on('connection', socket => {
console.log('we have a new connection ...');
socket.on('new_user', (reg_id) => {
// [*] Adding our user notification registration token to our list typically
hided in a secret place.
if (regTokens.indexOf(reg_id) === -1) {
regTokens.push(reg_id);
6.
https://riptutorial.com/es/home 158

-- 186 of 423 --

// [*] Sending our push messages
sender.send(message, {
registrationTokens: regTokens
}, (err, response) => {
if (err) console.error('err', err);
else console.log(response);
});
}
})
});
module.exports = app
PD: Estoy usando aquí un truco especial para hacer que Socket.io funcione con
Express porque simplemente no funciona fuera de la caja.
Ahora cree un archivo .json y asígnele el nombre: Manifest.json , ábralo y pase lo siguiente:
{
"name": "Application Name",
"gcm_sender_id": "GCM Project ID"
}
Ciérralo y guárdalo en el directorio ROOT de tu aplicación.
PD: el archivo Manifest.json debe estar en el directorio raíz o no funcionará.
En el código anterior estoy haciendo lo siguiente:
Configuré y envié una página index.html normal que también usará socket.io.	1.
Estoy escuchando un evento de conexión activado desde el front-end también conocido
como mi página index.html (se activará una vez que un nuevo cliente se conecte con éxito
a nuestro enlace predefinido)
2.
Estoy enviando un conocimiento de token especial como el token de registro de mi
index.html a través del evento socket.io new_user ; dicho token será nuestro código de
acceso exclusivo del usuario y cada código se genera generalmente desde un navegador
compatible para la API de notificación web (lea más aquí.
3.
Simplemente estoy usando el módulo node-gcm para enviar mi notificación, la cual se
manejará y se mostrará más adelante usando Service Workers '.
4.
Esto es desde el punto de vista de NodeJS . en otros ejemplos, mostraré cómo podemos enviar
datos personalizados, íconos, etc., en nuestro mensaje push.
PD: puedes encontrar la demo completa aquí.
Lea Enviar notificación web en línea: https://riptutorial.com/es/node-js/topic/6333/enviar-
notificacion-web
https://riptutorial.com/es/home 159

-- 187 of 423 --
