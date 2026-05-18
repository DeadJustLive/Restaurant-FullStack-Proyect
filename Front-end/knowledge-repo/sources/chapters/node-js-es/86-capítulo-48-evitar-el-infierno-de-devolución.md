# Capítulo 48:: Evitar el infierno de devolución

de llamada
Examples
Módulo asíncrono
La fuente está disponible para descargar desde GitHub. Alternativamente, puedes instalar usando
npm:
$ npm instalar --save async
Además de usar Bower:
$ bower instalar async
Ejemplo:
var async = require("async");
async.parallel([
function(callback) { ... },
function(callback) { ... }
], function(err, results) {
// optional callback
});
Módulo asíncrono
Afortunadamente, existen bibliotecas como Async.js para tratar de frenar el problema. Async
agrega una capa delgada de funciones sobre su código, pero puede reducir la complejidad al
evitar el anidamiento de devolución de llamada.
Existen muchos métodos de ayuda en Async que se pueden usar en diferentes situaciones, como
series, paralelo, cascada, etc. Cada función tiene un caso de uso específico, así que tómese un
tiempo para aprender cuál le ayudará en qué situaciones.
Tan bueno como Async es, como todo, no es perfecto. Es muy fácil dejarse llevar por la
combinación de series, paralelos, para siempre, etc., momento en el que regresa a donde
comenzó con el código desordenado. Tenga cuidado de no optimizar prematuramente. El hecho
de que algunas tareas asíncronas se puedan ejecutar en paralelo no siempre significa que deban
hacerlo. En realidad, dado que Node es solo un subproceso, la ejecución de tareas en paralelo en
el uso de Async tiene poco o ningún aumento de rendimiento.
La fuente está disponible para descargar desde https://github.com/caolan/async .
Alternativamente, puedes instalar usando npm:
https://riptutorial.com/es/home 166

-- 194 of 423 --

$ npm instalar --save async
Además de usar Bower:
$ bower instalar async
Ejemplo de cascada de Async:
var fs = require('fs');
var async = require('async');
var myFile = '/tmp/test';
async.waterfall([
function(callback) {
fs.readFile(myFile, 'utf8', callback);
},
function(txt, callback) {
txt = txt + '\nAppended something!';
fs.writeFile(myFile, txt, callback);
}
], function (err, result) {
if(err) return console.log(err);
console.log('Appended text!');
});
Lea Evitar el infierno de devolución de llamada en línea: https://riptutorial.com/es/node-
js/topic/10045/evitar-el-infierno-de-devolucion-de-llamada
https://riptutorial.com/es/home 167

-- 195 of 423 --