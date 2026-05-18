# Capítulo 74:: Manejo de excepciones

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 117)

## Contenido
# Capítulo 74:: Manejo de excepciones

Examples
Manejo de excepciones en Node.Js
Node.js tiene 3 formas básicas de manejar excepciones / errores:
tratar - atrapar bloque	1.
error como el primer argumento de una callback	2.
emit un evento de error utilizando eventEmitter	3.
try-catch se utiliza para capturar las excepciones generadas desde la ejecución del código
síncrono. Si la persona que llama (o la persona que llama, ...) usó try / catch, entonces pueden
detectar el error. Si ninguna de las personas que llamaron tuvo un intento de captura, el programa
se bloquea.
Si se utiliza try-catch en una operación asíncrona y se generó una excepción a partir de la
devolución de llamada del método async, entonces no se detectará mediante try-catch. Para
capturar una excepción de la devolución de llamada de operación asíncrona, se prefiere usar
promesas .
Ejemplo para entenderlo mejor.
// ** Example - 1 **
function doSomeSynchronousOperation(req, res) {
if(req.body.username === ''){
throw new Error('User Name cannot be empty');
}
return true;
}
// calling the method above
try {
// synchronous code
doSomeSynchronousOperation(req, res)
catch(e) {
//exception handled here
console.log(e.message);
}
// ** Example - 2 **
function doSomeAsynchronousOperation(req, res, cb) {
// imitating async operation
return setTimeout(function(){
cb(null, []);
},1000);
}
try {
// asynchronous code
doSomeAsynchronousOperation(req, res, function(err, rs){
throw new Error("async operation exception");
})
https://riptutorial.com/es/home 243

-- 271 of 423 --

} catch(e) {
// Exception will not get handled here
console.log(e.message);
}
// The exception is unhandled and hence will cause application to break
Las devoluciones de llamada se utilizan principalmente en Node.js ya que la devolución de
llamada entrega un evento de forma asíncrona. El usuario le pasa una función (la devolución de
llamada), y la invoca más tarde cuando finaliza la operación asíncrona.
El patrón habitual es que la devolución de llamada se invoca como devolución de llamada (error,
resultado) , donde solo uno de error y resultado no es nulo, dependiendo de si la operación se
realizó correctamente o no.
function doSomeAsynchronousOperation(req, res, callback) {
setTimeout(function(){
return callback(new Error('User Name cannot be empty'));
}, 1000);
return true;
}
doSomeAsynchronousOperation(req, res, function(err, result) {
if (err) {
//exception handled here
console.log(err.message);
}
//do some stuff with valid data
});
emiten Para los casos más complicados, en lugar de utilizar una devolución de llamada, la propia
función puede devolver un objeto EventEmitter, y se esperaría que la persona que llama para
escuchar los eventos de error en el emisor.
const EventEmitter = require('events');
function doSomeAsynchronousOperation(req, res) {
let myEvent = new EventEmitter();
// runs asynchronously
setTimeout(function(){
myEvent.emit('error', new Error('User Name cannot be empty'));
}, 1000);
return myEvent;
}
// Invoke the function
let event = doSomeAsynchronousOperation(req, res);
event.on('error', function(err) {
console.log(err);
});
event.on('done', function(result) {
console.log(result); // true
});
https://riptutorial.com/es/home 244

-- 272 of 423 --

Gestión de excepciones no gestionadas
Debido a que Node.js se ejecuta en un solo proceso, las excepciones no detectadas son un
problema que se debe tener en cuenta al desarrollar aplicaciones.
Manejo silencioso de excepciones
La mayoría de las personas permiten que los servidores node.js traguen silenciosamente los
errores.
Manejo silencioso de la excepción.	•
process.on('uncaughtException', function (err) {
console.log(err);
});
Esto es malo , funcionará pero:
La causa raíz seguirá siendo desconocida, por lo que no contribuirá a la resolución de lo
que causó la excepción (error).
•
En caso de que la conexión de la base de datos (grupo) se cierre por algún motivo, esto
dará lugar a una constante propagación de errores, lo que significa que el servidor se
ejecutará pero no se volverá a conectar a db.
•
Volviendo al estado inicial
En caso de una "excepción no captada", es bueno reiniciar el servidor y devolverlo a su estado
inicial , donde sabemos que funcionará. Se registra una excepción, la aplicación finaliza pero
como se ejecutará en un contenedor que se asegurará de que el servidor se está ejecutando,
lograremos el reinicio del servidor (volviendo al estado de funcionamiento inicial).
Instalación de forever (u otra herramienta CLI para asegurarse de que el servidor de nodos
se ejecuta continuamente)
•
npm install forever -g
Iniciando el servidor en siempre	•
forever start app.js
La razón por la cual se inició y la razón por la que usamos para siempre es después
de que el servidor se termina, el proceso iniciará nuevamente el servidor.
Reiniciando el servidor	•
https://riptutorial.com/es/home 245

-- 273 of 423 --

process.on('uncaughtException', function (err) {
console.log(err);
// some logging mechanisam
// ....
proc
