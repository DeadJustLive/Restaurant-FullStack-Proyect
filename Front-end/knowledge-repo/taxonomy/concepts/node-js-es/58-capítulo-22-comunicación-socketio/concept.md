# Capítulo 22:: Comunicación socket.io

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 58)

## Contenido
# Capítulo 22:: Comunicación socket.io

Examples
"¡Hola Mundo!" Con mensajes de socket.
Instalar módulos de nodo
npm install express
npm install socket.io
Servidor Node.js
const express = require('express');
const app = express();
const server = app.listen(3000,console.log("Socket.io Hello World server started!"));
const io = require('socket.io')(server);
io.on('connection', (socket) => {
//console.log("Client connected!");
socket.on('message-from-client-to-server', (msg) => {
console.log(msg);
})
socket.emit('message-from-server-to-client', 'Hello World!');
});
Cliente navegador
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Hello World with Socket.io</title>
</head>
<body>
<script src="https://cdn.socket.io/socket.io-1.4.5.js"></script>
<script>
var socket = io("http://localhost:3000");
socket.on("message-from-server-to-client", function(msg) {
document.getElementById('message').innerHTML = msg;
});
socket.emit('message-from-client-to-server', 'Hello World!');
</script>
<p>Socket.io Hello World client started!</p>
<p id="message"></p>
</body>
</html>
Lea Comunicación socket.io en línea: https://riptutorial.com/es/node-js/topic/4261/comunicacion-
socket-io
https://riptutorial.com/es/home 101

-- 129 of 423 --
