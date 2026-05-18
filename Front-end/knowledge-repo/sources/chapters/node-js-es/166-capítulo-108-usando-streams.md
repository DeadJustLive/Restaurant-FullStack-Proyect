# Capítulo 108:: Usando Streams

Parámetros
Parámetro Definición
Corriente legible tipo de flujo desde donde se pueden leer los datos
Secuencia de escritura tipo de flujo donde los datos pueden ser escritos
Corriente Dúplex Tipo de flujo que se puede leer y escribir
Corriente de
transformación
tipo de flujo dúplex que puede transformar datos a medida que se
lee y se escribe
Examples
Leer datos de TextFile con secuencias
La E / S en el nodo es asíncrona, por lo que interactuar con el disco y la red implica transferir
devoluciones de llamada a las funciones. Podría sentirse tentado a escribir código que sirva un
archivo del disco como este:
var http = require('http');
var fs = require('fs');
var server = http.createServer(function (req, res) {
fs.readFile(__dirname + '/data.txt', function (err, data) {
res.end(data);
});
});
server.listen(8000);
Este código funciona, pero es abultado y almacena en la memoria todo el archivo data.txt para
cada solicitud antes de volver a enviar el resultado a los clientes. Si data.txt es muy grande, su
programa podría comenzar a consumir mucha memoria ya que sirve a muchos usuarios al mismo
tiempo, especialmente para usuarios con conexiones lentas.
La experiencia del usuario también es mala porque los usuarios deberán esperar a que todo el
archivo se almacene en la memoria intermedia de su servidor antes de poder comenzar a recibir
cualquier contenido.
Afortunadamente, ambos argumentos (req, res) son secuencias, lo que significa que podemos
escribir esto de una manera mucho mejor utilizando fs.createReadStream () en lugar de
fs.readFile ():
https://riptutorial.com/es/home 373

-- 401 of 423 --

var http = require('http');
var fs = require('fs');
var server = http.createServer(function (req, res) {
var stream = fs.createReadStream(__dirname + '/data.txt');
stream.pipe(res);
});
server.listen(8000);
Aquí .pipe () se encarga de escuchar los eventos de "datos" y "finales" de fs.createReadStream ().
Este código no solo es más limpio, sino que ahora el archivo data.txt se escribirá a los clientes
una porción a la vez inmediatamente a medida que se reciben del disco.
Corrientes de tubería
Los flujos legibles se pueden "canalizar" o conectarse a flujos grabables. Esto hace que los datos
fluyan desde la secuencia de origen a la secuencia de destino sin mucho esfuerzo.
var fs = require('fs')
var readable = fs.createReadStream('file1.txt')
var writable = fs.createWriteStream('file2.txt')
readable.pipe(writable) // returns writable
Cuando las secuencias grabables también son secuencias legibles, es decir, cuando son
secuencias dúplex , puede continuar canalizándolas a otras secuencias grabables.
var zlib = require('zlib')
fs.createReadStream('style.css')
.pipe(zlib.createGzip()) // The returned object, zlib.Gzip, is a duplex stream.
.pipe(fs.createWriteStream('style.css.gz')
Los flujos legibles también se pueden canalizar en múltiples flujos.
var readable = fs.createReadStream('source.css')
readable.pipe(zlib.createGzip()).pipe(fs.createWriteStream('output.css.gz'))
readable.pipe(fs.createWriteStream('output.css')
Tenga en cuenta que debe canalizar a los flujos de salida de forma síncrona (al mismo tiempo)
antes de que 'fluya' cualquier dato. De lo contrario, se podrían transmitir datos incompletos.
También tenga en cuenta que los objetos de flujo pueden emitir eventos de error ; asegúrese de
manejar responsablemente estos eventos en cada flujo, según sea necesario:
var readable = fs.createReadStream('file3.txt')
var writable = fs.createWriteStream('file4.txt')
readable.pipe(writable)
readable.on('error', console.error)
writable.on('error', console.error)
https://riptutorial.com/es/home 374

-- 402 of 423 --

Creando tu propio flujo legible / escribible
Veremos que los objetos de flujo son devueltos por módulos como fs, etc., pero si queremos crear
nuestro propio objeto de flujo.
Para crear un objeto de transmisión, necesitamos usar el módulo de transmisión proporcionado
por NodeJs
var fs = require("fs");
var stream = require("stream").Writable;
/*
* Implementing the write function in writable stream class.
* This is the function which will be used when other stream is piped into this
* writable stream.
*/
stream.prototype._write = function(chunk, data){
console.log(data);
}
var customStream = new stream();
fs.createReadStream("am1.js").pipe(customStream);
Esto nos dará nuestra propia secuencia de escritura personalizada. Podemos implementar
cualquier cosa dentro de la función _write . El método anterior funciona en NodeJs 4.xx versión
pero en NodeJs 6.x ES6 las clases introducidas, por lo tanto, la sintaxis ha cambiado. A
continuación se muestra el código para la versión 6.x de NodeJs
const Writable = require('stream').Writable;
class MyWritable extends Writable {
constructor(options) {
super(options);
}
_write(chunk, encoding, callback) {
console.log(chunk);
}
}
¿Por qué Streams?
Permite examinar los siguientes dos ejemplos para leer el contenido de un archivo:
El primero, que utiliza un método asíncrono para leer un archivo, y proporciona una función de
devolución de llamada que se llama una vez que el archivo se lee completamente en la memoria:
fs.readFile(`${__dirname}/utils.js`, (err, data) => {
if (err) {
handleError(err);
} else {
console.log(data.toString());
}
https://riptutorial.com/es/home 375

-- 403 of 423 --

})
Y el segundo, que utiliza streams para leer el contenido del archivo, pieza por pieza:
var fileStream = fs.createReadStream(`${__dirname}/file`);
var fileContent = '';
fileStream.on('data', data => {
fileContent += data.toString();
})
fileStream.on('end', () => {
console.log(fileContent);
})
fileStream.on('error', err => {
handleError(err)
})
Vale la pena mencionar que ambos ejemplos hacen exactamente lo mismo . ¿Cuál es la
diferencia entonces?
El primero es más corto y se ve más elegante.	•
El segundo le permite hacer un procesamiento en el archivo mientras se está leyendo (!)	•
Cuando los archivos con los que trata son pequeños, entonces no hay un efecto real cuando se
usan streams , pero ¿qué sucede cuando el archivo es grande? (tan grande que toma 10
segundos leerlo en la memoria)
Sin streams estarás esperando, sin hacer absolutamente nada (a menos que tu proceso haga
otras cosas), hasta que pasen los 10 segundos y el archivo se lea por completo , y solo así
podrás comenzar a procesar el archivo.
Con las streams , obtiene el contenido del archivo pieza por pieza, justo cuando están
disponibles , y eso le permite procesar el archivo mientras se lee.
El ejemplo anterior no ilustra cómo se pueden utilizar los streams para el trabajo que no se puede
hacer cuando se realiza la devolución de llamada, así que veamos otro ejemplo:
Me gustaría descargar un archivo gzip , descomprimirlo y guardar su contenido en el disco. Dada
la url del archivo, esto es lo que hay que hacer:
Descargar el archivo	•
Descomprime el archivo	•
Guárdalo en el disco	•
Aquí hay un [archivo pequeño] [1], que se almacena en mi almacenamiento S3 . El siguiente
código hace lo anterior en la forma de devolución de llamada.
var startTime = Date.now()
s3.getObject({Bucket: 'some-bucket', Key: 'tweets.gz'}, (err, data) => {
// here, the whole file was downloaded
https://riptutorial.com/es/home 376

-- 404 of 423 --

zlib.gunzip(data.Body, (err, data) => {
// here, the whole file was unzipped
fs.writeFile(`${__dirname}/tweets.json`, data, err => {
if (err) console.error(err)
// here, the whole file was written to disk
var endTime = Date.now()
console.log(`${endTime - startTime} milliseconds`) // 1339 milliseconds
})
})
})
// 1339 milliseconds
Así es como se ve usando streams :
s3.getObject({Bucket: 'some-bucket', Key: 'tweets.gz'}).createReadStream()
.pipe(zlib.createGunzip())
.pipe(fs.createWriteStream(`${__dirname}/tweets.json`));
// 1204 milliseconds
Sí, no es más rápido cuando se trata de archivos pequeños: el archivo probado tiene un peso de
80KB . Probando esto en un archivo más grande, 71MB gzipped ( 382MB descomprimido), muestra
que la versión de streams es mucho más rápida
Tardó 20925 milisegundos en descargar 71MB , descomprimirlo y luego escribir 382MB en el
disco, usando la forma de devolución de llamada .
•
En comparación, tomó 13434 milisegundos para hacer lo mismo cuando se usa la versión
de streams (35% más rápido, para un archivo no tan grande)
•
Lea Usando Streams en línea: https://riptutorial.com/es/node-js/topic/2974/usando-streams
https://riptutorial.com/es/home 377

-- 405 of 423 --