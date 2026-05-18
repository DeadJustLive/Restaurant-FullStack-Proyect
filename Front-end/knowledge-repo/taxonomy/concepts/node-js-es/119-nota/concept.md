# NOTA

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 119)

## Contenido
# NOTA

Los datos de búfer recibidos en eventos de data son de tipo Búfer	1.
Cree una nueva cadena de búfer para recopilar datos almacenados en búfer de los eventos
de datos para cada solicitud, es decir, cree una cadena de buffer dentro del controlador de
solicitudes.
2.
Examples
Ejemplo de servidor node.js que solo maneja solicitudes POST
'use strict';
const http = require('http');
const PORT = 8080;
const server = http.createServer((request, response) => {
let buffer = '';
request.on('data', chunk => {
buffer += chunk;
});
request.on('end', () => {
https://riptutorial.com/es/home 247

-- 275 of 423 --

const responseString = `Received string ${buffer}`;
console.log(`Responding with: ${responseString}`);
response.writeHead(200, "Content-Type: text/plain");
response.end(responseString);
});
}).listen(PORT, () => {
console.log(`Listening on ${PORT}`);
});
Lea Manejo de solicitud POST en Node.js en línea: https://riptutorial.com/es/node-
js/topic/5676/manejo-de-solicitud-post-en-node-js
https://riptutorial.com/es/home 248

-- 276 of 423 --
