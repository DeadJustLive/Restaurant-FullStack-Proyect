# Capítulo 35:: Devolución de llamada a la

promesa
Examples
Prometiendo una devolución de llamada
Basado en devolución de llamada:
db.notification.email.find({subject: 'promisify callback'}, (error, result) => {
if (error) {
console.log(error);
}
// normal code here
});
Esto utiliza el método promisifyAll de bluebird para promisificar lo que es el código convencional
basado en la devolución de llamada como el anterior. bluebird hará una versión prometedora de
todos los métodos en el objeto, esos nombres de métodos basados en promesas tienen Async
añadido a ellos:
let email = bluebird.promisifyAll(db.notification.email);
email.findAsync({subject: 'promisify callback'}).then(result => {
// normal code here
})
.catch(console.error);
Si solo hay que prometer métodos específicos, solo use su promisify:
let find = bluebird.promisify(db.notification.email.find);
find({locationId: 168}).then(result => {
// normal code here
});
.catch(console.error);
Hay algunas bibliotecas (por ejemplo, MassiveJS) que no se pueden prometer si el objeto
inmediato del método no se pasa al segundo parámetro. En ese caso, simplemente pase el objeto
inmediato del método que debe ser promisificado en el segundo parámetro y encerrado en la
propiedad de contexto.
let find = bluebird.promisify(db.notification.email.find, { context: db.notification.email });
find({locationId: 168}).then(result => {
https://riptutorial.com/es/home 131

-- 159 of 423 --

// normal code here
});
.catch(console.error);
Promisificando manualmente una devolución de llamada
A veces puede ser necesario promisificar manualmente una función de devolución de llamada.
Esto podría ser en el caso de que la devolución de llamada no siga el formato estándar de error
primero o si se necesita lógica adicional para prometer:
Ejemplo con fs.exists (ruta, callback) :
var fs = require('fs');
var existsAsync = function(path) {
return new Promise(function(resolve, reject) {
fs.exists(path, function(exists) {
// exists is a boolean
if (exists) {
// Resolve successfully
resolve();
} else {
// Reject with error
reject(new Error('path does not exist'));
}
});
});
// Use as a promise now
existsAsync('/path/to/some/file').then(function() {
console.log('file exists!');
}).catch(function(err) {
// file does not exist
console.error(err);
});
setTimeout promisificado
function wait(ms) {
return new Promise(function (resolve, reject) {
setTimeout(resolve, ms)
})
}
Lea Devolución de llamada a la promesa en línea: https://riptutorial.com/es/node-
js/topic/2346/devolucion-de-llamada-a-la-promesa
https://riptutorial.com/es/home 132

-- 160 of 423 --