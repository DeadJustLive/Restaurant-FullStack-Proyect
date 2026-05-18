# Capítulo 12:: Bluebird Promises

Examples
Convertir la biblioteca de nodeback a Promesas
const Promise = require('bluebird'),
fs = require('fs')
Promise.promisifyAll(fs)
// now you can use promise based methods on 'fs' with the Async suffix
fs.readFileAsync('file.txt').then(contents => {
console.log(contents)
}).catch(err => {
console.error('error reading', err)
})
Promesas funcionales
Ejemplo de mapa:
Promise.resolve([ 1, 2, 3 ]).map(el => {
return Promise.resolve(el * el) // return some async operation in real world
})
Ejemplo de filtro:
Promise.resolve([ 1, 2, 3 ]).filter(el => {
return Promise.resolve(el % 2 === 0) // return some async operation in real world
}).then(console.log)
Ejemplo de reducir:
Promise.resolve([ 1, 2, 3 ]).reduce((prev, curr) => {
return Promise.resolve(prev + curr) // return some async operation in real world
}).then(console.log)
Coroutines (Generadores)
const promiseReturningFunction = Promise.coroutine(function* (file) {
const data = yield fs.readFileAsync(file) // this returns a Promise and resolves to the file
contents
return data.toString().toUpperCase()
})
promiseReturningFunction('file.txt').then(console.log)
https://riptutorial.com/es/home 77

-- 105 of 423 --

Eliminación automática de recursos (Promise.using)
function somethingThatReturnsADisposableResource() {
return getSomeResourceAsync(...).disposer(resource => {
resource.dispose()
})
}
Promise.using(somethingThatReturnsADisposableResource(), resource => {
// use the resource here, the disposer will automatically close it when Promise.using exits
})
Ejecutando en serie
Promise.resolve([1, 2, 3])
.mapSeries(el => Promise.resolve(el * el)) // in real world, use Promise returning async
function
.then(console.log)
Lea Bluebird Promises en línea: https://riptutorial.com/es/node-js/topic/6728/bluebird-promises
https://riptutorial.com/es/home 78

-- 106 of 423 --