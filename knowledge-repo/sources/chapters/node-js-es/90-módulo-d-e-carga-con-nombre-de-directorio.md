# Módulo d: e carga con nombre de directorio

Tenemos un directorio llamado hello que incluye los siguientes archivos:
index.js
// hello/index.js
module.exports = function(){
console.log('Hej');
};
main.js
// hello/main.js
// We can include the other files we've defined by using the `require()` method
var hw = require('./hello-world.js'),
hm = require('./hello-mars.js'),
hv = require('./hello-venus.js'),
hj = require('./hello-jupiter.js'),
hu = require('./index.js');
// Because we assigned our function to the entire `module.exports` object, we
// can use it directly
hw('World!'); // outputs "Hello World!"
// In this case, we assigned our function to the `hello` property of exports, so we must
// use that here too
hm.hello('Solar System!'); // outputs "Mars says Hello Solar System!"
// The result of assigning module.exports at once is the same as in hello-world.js
hv.hello('Milky Way!'); // outputs "Venus says Hello Milky Way!"
hj.hello('Universe!'); // outputs "Jupiter says hello Universe!"
hj.bye('Universe!'); // outputs "Jupiter says goodbye Universe!"
hu(); //output 'hej'
Invalidando el caché del módulo
En el desarrollo, es posible que el uso de require() en el mismo módulo varias veces siempre
devuelva el mismo módulo, incluso si ha realizado cambios en ese archivo. Esto se debe a que
los módulos se almacenan en caché la primera vez que se cargan, y cualquier carga subsiguiente
del módulo se cargará desde el caché.
Para solucionar este problema, tendrá que delete la entrada en el caché. Por ejemplo, si has
cargado un módulo:
https://riptutorial.com/es/home 176

-- 204 of 423 --

var a = require('./a');
A continuación, podría eliminar la entrada de caché:
var rpath = require.resolve('./a.js');
delete require.cache[rpath];
Y luego volver a requerir el módulo:
var a = require('./a');
Tenga en cuenta que esto no se recomienda en producción porque la delete solo eliminará la
referencia al módulo cargado, no los datos cargados en sí. El módulo no se recolecta en la
basura, por lo que el uso incorrecto de esta función podría provocar una pérdida de memoria.
Construyendo tus propios módulos.
También puede hacer referencia a un objeto para exportar públicamente y agregar continuamente
métodos a ese objeto:
const auth = module.exports = {}
const config = require('../config')
const request = require('request')
auth.email = function (data, callback) {
// Authenticate with an email address
}
auth.facebook = function (data, callback) {
// Authenticate with a Facebook account
}
auth.twitter = function (data, callback) {
// Authenticate with a Twitter account
}
auth.slack = function (data, callback) {
// Authenticate with a Slack account
}
auth.stack_overflow = function (data, callback) {
// Authenticate with a Stack Overflow account
}
Para usar cualquiera de estos, solo necesita el módulo como lo haría normalmente:
const auth = require('./auth')
module.exports = function (req, res, next) {
auth.facebook(req.body, function (err, user) {
if (err) return next(err)
req.user = user
next()
https://riptutorial.com/es/home 177

-- 205 of 423 --

})
}
Cada módulo inyectado solo una vez.
NodeJS ejecuta el módulo solo la primera vez que lo requiera. Cualquier otra función requerida
volverá a utilizar el mismo Objeto, por lo que no ejecutará el código en el módulo otra vez.
Además, Node almacena en caché los módulos la primera vez que se cargan utilizando require.
Esto reduce el número de lecturas de archivos y ayuda a acelerar la aplicación.
myModule.js
console.log(123) ;
exports.var1 = 4 ;
index.js
var a=require('./myModule') ; // Output 123
var b=require('./myModule') ; // No output
console.log(a.var1) ; // Output 4
console.log(b.var1) ; // Output 4
a.var2 = 5 ;
console.log(b.var2) ; // Output 5