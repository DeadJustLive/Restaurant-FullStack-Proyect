# Capítulo 93:: Notificaciones push

Introducción
Por lo tanto, si desea hacer una notificación de la aplicación web, le sugiero que utilice el marco
Push.js o SoneSignal para la aplicación web / móvil.
Push es la forma más rápida de ponerse en marcha con las notificaciones de Javascript. Una
adición bastante nueva a la especificación oficial, la API de notificaciones permite a los
navegadores modernos como Chrome, Safari, Firefox e IE 9+ enviar notificaciones al escritorio de
un usuario.
Tendrá que usar Socket.io y algún marco de backend, usaré Express para este ejemplo.
Parámetros
módulo /
marco descripción
node.js /
express
Marco de back-end simple para la aplicación Node.js, muy fácil de usar y
extremadamente potente
Zócalo.io
Socket.IO permite la comunicación bidireccional basada en eventos en tiempo
real. Funciona en todas las plataformas, navegadores o dispositivos,
centrándose igualmente en la confiabilidad y la velocidad.
Push.js El marco de notificaciones de escritorio más versátil del mundo.
OneSignal Solo otra forma de notificaciones push para dispositivos Apple
Base de
fuego
Firebase es la plataforma móvil de Google que lo ayuda a desarrollar
rápidamente aplicaciones de alta calidad y hacer crecer su negocio.
Examples
Notificación web
Primero, necesitarás instalar el módulo Push.js.
$ npm install push.js --save
O bien, impórtelo a su aplicación de front-end a través de CDN
<script src="./push.min.js"></script> <!-- CDN link -->
https://riptutorial.com/es/home 299

-- 327 of 423 --

Después de que hayas terminado con eso, deberías ser bueno para irte. Así debería ser si
quieres hacer una notificación simple:
Push.create('Hello World!')
Asumiré que sabes cómo configurar Socket.io con tu aplicación. Aquí hay un ejemplo de código
de mi aplicación backend con Express:
var app = require('express')();
var server = require('http').Server(app);
var io = require('socket.io')(server);
server.listen(80);
app.get('/', function (req, res) {
res.sendfile(__dirname + '/index.html');
});
io.on('connection', function (socket) {
socket.emit('pushNotification', { success: true, msg: 'hello' });
});
Una vez que su servidor esté todo configurado, debería poder pasar a la parte frontal. Ahora todo
lo que tenemos que hacer es importar Socket.io CDN y agregar este código a mi archivo
index.html :
<script src="../socket.io.js"></script> <!-- CDN link -->
<script>
var socket = io.connect('http://localhost');
socket.on('pushNotification', function (data) {
console.log(data);
Push.create("Hello world!", {
body: data.msg, //this should print "hello"
icon: '/icon.png',
timeout: 4000,
onClick: function () {
window.focus();
this.close();
}
});
});
</script>
Ahí lo tienes, ahora deberías poder mostrar tu notificación, esto también funciona en cualquier
dispositivo Android, y si quieres usar la mensajería en la nube de Firebase , puedes usarlo con
este módulo. Aquí hay un enlace para el ejemplo escrito por Nick (creador de Push.js)
manzana
Tenga en cuenta que esto no funcionará en los dispositivos Apple (no los probé todos), pero si
desea realizar notificaciones push, compruebe el complemento OneSignal .
https://riptutorial.com/es/home 300

-- 328 of 423 --

Lea Notificaciones push en línea: https://riptutorial.com/es/node-js/topic/10892/notificaciones-push
https://riptutorial.com/es/home 301

-- 329 of 423 --