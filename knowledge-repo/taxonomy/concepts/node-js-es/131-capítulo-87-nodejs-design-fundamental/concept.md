# Capítulo 87:: Node.js Design Fundamental

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 131)

## Contenido
# Capítulo 87:: Node.js Design Fundamental

Examples
La filosofía de Node.js.
Núcleo pequeño , módulo pequeño : -
Construya módulos pequeños y de propósito único no solo en términos de tamaño de código, sino
también en términos de alcance que sirvan para un solo propósito
a - "Small is beautiful"
b - "Make each program do one thing well."
El patrón del reactor
El patrón de reactor es el corazón de la naturaleza asíncrona de node.js Permitió que el sistema
se implementara como un proceso de un solo hilo con una serie de generadores de eventos y
controladores de eventos, con la ayuda de un bucle de eventos que se ejecuta continuamente.
El motor de E / S sin bloqueo de Node.js - libuv -
El patrón de observador (EventEmitter) mantiene una lista de dependientes / observadores y los
notifica.
var events = require('events');
var eventEmitter = new events.EventEmitter();
var ringBell = function ringBell()
{
console.log('tring tring tring');
}
eventEmitter.on('doorOpen', ringBell);
eventEmitter.emit('doorOpen');
Lea Node.js Design Fundamental en línea: https://riptutorial.com/es/node-js/topic/6274/node-js-
design-fundamental
https://riptutorial.com/es/home 278

-- 306 of 423 --
