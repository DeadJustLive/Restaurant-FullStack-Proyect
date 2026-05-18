# Capítulo 40:: Emisores de eventos

Observaciones
Cuando un evento se "dispara" (lo que significa lo mismo que "publicar un evento" o "emitir un
evento"), cada oyente se llamará de forma sincrónica ( fuente ), junto con los datos adjuntos que
se pasaron a emit() , no importa cuántos argumentos pases en:
myDog.on('bark', (howLoud, howLong, howIntense) => {
// handle the event
})
myDog.emit('bark', 'loudly', '5 seconds long', 'fiercely')
Los oyentes serán llamados en el orden en que fueron registrados:
myDog.on('urinate', () => console.log('My first thought was "Oh-no"'))
myDog.on('urinate', () => console.log('My second thought was "Not my lawn :)"'))
myDog.emit('urinate')
// The console.logs will happen in the right order because they were registered in that order.
Pero si necesita un oyente para disparar primero, antes de todos los otros oyentes que ya se han
agregado, puede usar prependListener() así:
myDog.prependListener('urinate', () => console.log('This happens before my first and second
thoughts, even though it was registered after them'))
Si necesita escuchar un evento, pero solo desea escucharlo una vez, puede usarlo once vez on
lugar de on , o prependOnceListener lugar de prependListener . Una vez que se activa el evento y se
llama al oyente, éste se eliminará automáticamente y no se volverá a llamar la próxima vez que
se active el evento.
Finalmente, si desea eliminar a todos los oyentes y comenzar de nuevo, siéntase libre de hacer
eso:
myDog.removeAllListeners()
Examples
HTTP Analytics a través de un emisor de eventos
En el código del servidor HTTP (por ejemplo, server.js ):
const EventEmitter = require('events')
const serverEvents = new EventEmitter()
// Set up an HTTP server
const http = require('http')
https://riptutorial.com/es/home 143

-- 171 of 423 --

const httpServer = http.createServer((request, response) => {
// Handler the request...
// Then emit an event about what happened
serverEvents.emit('request', request.method, request.url)
});
// Expose the event emitter
module.exports = serverEvents
En código de supervisor (ej. supervisor.js ):
const server = require('./server.js')
// Since the server exported an event emitter, we can listen to it for changes:
server.on('request', (method, url) => {
console.log(`Got a request: ${method} ${url}`)
})
Cada vez que el servidor recibe una solicitud, emitirá un evento llamado request que el supervisor
está escuchando, y luego el supervisor puede reaccionar al evento.
Lo esencial
Los emisores de eventos están integrados en Node, y son para pub-sub, un patrón donde un
editor emitirá eventos, a los que los suscriptores pueden escuchar y reaccionar. En la jerga de
Nodos, los editores se denominan Emisores de eventos y emiten eventos, mientras que los
suscriptores se llaman escuchas y reaccionan a los eventos.
// Require events to start using them
const EventEmitter = require('events').EventEmitter;
// Dogs have events to publish, or emit
class Dog extends EventEmitter {};
class Food {};
let myDog = new Dog();
// When myDog is chewing, run the following function
myDog.on('chew', (item) => {
if (item instanceof Food) {
console.log('Good dog');
} else {
console.log(`Time to buy another ${item}`);
}
});
myDog.emit('chew', 'shoe'); // Will result in console.log('Time to buy another shoe')
const bacon = new Food();
myDog.emit('chew', bacon); // Will result in console.log('Good dog')
En el ejemplo anterior, el perro es el editor / EventEmitter, mientras que la función que verifica el
elemento fue el suscriptor / oyente. Puedes hacer más oyentes también:
myDog.on('bark', () => {
console.log('WHO\'S AT THE DOOR?');
// Panic
https://riptutorial.com/es/home 144

-- 172 of 423 --

});
También puede haber múltiples escuchas para un solo evento, e incluso eliminar escuchas:
myDog.on('chew', takeADeepBreathe);
myDog.on('chew', calmDown);
// Undo the previous line with the next one:
myDog.removeListener('chew', calmDown);
Si desea escuchar un evento solo una vez, puede utilizar:
myDog.once('chew', pet);
Lo que eliminará al oyente automáticamente sin condiciones de carrera.
Obtenga los nombres de los eventos a los que está suscrito.
La función EventEmitter.eventNames () devolverá una matriz que contiene los nombres de los
eventos a los que está suscrito actualmente.
const EventEmitter = require("events");
class MyEmitter extends EventEmitter{}
var emitter = new MyEmitter();
emitter
.on("message", function(){ //listen for message event
console.log("a message was emitted!");
})
.on("message", function(){ //listen for message event
console.log("this is not the right message");
})
.on("data", function(){ //listen for data event
console.log("a data just occured!!");
});
console.log(emitter.eventNames()); //=> ["message","data"]
emitter.removeAllListeners("data");//=> removeAllListeners to data event
console.log(emitter.eventNames()); //=> ["message"]
Ejecutar en RunKit
Obtenga el número de oyentes registrados para escuchar un evento
específico
La función Emitter.listenerCount (eventName) devolverá el número de escuchas que están
escuchando actualmente el evento proporcionado como argumento
const EventEmitter = require("events");
class MyEmitter extends EventEmitter{}
var emitter = new MyEmitter();
https://riptutorial.com/es/home 145

-- 173 of 423 --

emitter
.on("data", ()=>{ // add listener for data event
console.log("data event emitter");
});
console.log(emitter.listenerCount("data")) // => 1
console.log(emitter.listenerCount("message")) // => 0
emitter.on("message", function mListener(){ //add listener for message event
console.log("message event emitted");
});
console.log(emitter.listenerCount("data")) // => 1
console.log(emitter.listenerCount("message")) // => 1
emitter.once("data", (stuff)=>{ //add another listener for data event
console.log(`Tell me my ${stuff}`);
})
console.log(emitter.listenerCount("data")) // => 2
console.log(emitter.listenerCount("message"))// => 1
Lea Emisores de eventos en línea: https://riptutorial.com/es/node-js/topic/1623/emisores-de-
eventos
https://riptutorial.com/es/home 146

-- 174 of 423 --