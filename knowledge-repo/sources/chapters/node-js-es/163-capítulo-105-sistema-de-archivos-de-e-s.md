# Capítulo 105:: Sistema de archivos de E / S

Observaciones
En Node.js, las operaciones de uso intensivo de recursos como I / O se realizan de forma
asíncrona , pero tienen una contraparte síncrona (por ejemplo, existe un fs.readFile y su
contraparte es fs.readFileSync ). Dado que el nodo es de un solo hilo, debe tener cuidado al usar
operaciones síncronas , ya que bloquearán todo el proceso.
Si un proceso está bloqueado por una operación sincrónica, se detiene el ciclo de ejecución
completo (incluido el bucle de eventos). Eso significa que no se ejecutará otro código asíncrono,
incluidos los eventos y los controladores de eventos, y su programa continuará esperando hasta
que se complete la única operación de bloqueo.
Existen usos apropiados para las operaciones síncronas y asíncronas, pero se debe tener
cuidado de que se utilicen correctamente.
Examples
Escribir en un archivo usando writeFile o writeFileSync
var fs = require('fs');
// Save the string "Hello world!" in a file called "hello.txt" in
// the directory "/tmp" using the default encoding (utf8).
// This operation will be completed in background and the callback
// will be called when it is either done or failed.
fs.writeFile('/tmp/hello.txt', 'Hello world!', function(err) {
// If an error occurred, show it and return
if(err) return console.error(err);
// Successfully wrote to the file!
});
// Save binary data to a file called "binary.txt" in the current
// directory. Again, the operation will be completed in background.
var buffer = new Buffer([ 0x48, 0x65, 0x6c, 0x6c, 0x6f ]);
fs.writeFile('binary.txt', buffer, function(err) {
// If an error occurred, show it and return
if(err) return console.error(err);
// Successfully wrote binary contents to the file!
});
fs.writeFileSync comporta de manera similar a fs.writeFile , pero no recibe una devolución de
llamada ya que se completa de forma síncrona y, por lo tanto, bloquea el subproceso principal. La
mayoría de los desarrolladores de node.js prefieren las variantes asíncronas que prácticamente
no causarán demoras en la ejecución del programa.
Nota: bloquear el hilo principal es una mala práctica en node.js. La función síncrona solo se debe
utilizar al depurar o cuando no hay otras opciones disponibles.
https://riptutorial.com/es/home 358

-- 386 of 423 --

// Write a string to another file and set the file mode to 0755
try {
fs.writeFileSync('sync.txt', 'anni', { mode: 0o755 });
} catch(err) {
// An error occurred
console.error(err);
}
Lectura asincrónica de archivos
Utilice el módulo del sistema de archivos para todas las operaciones de archivos:
const fs = require('fs');
Con codificacion
En este ejemplo, lea hello.txt del directorio /tmp . Esta operación se completará en segundo
plano y la devolución de llamada se produce al finalizar o fallar:
fs.readFile('/tmp/hello.txt', { encoding: 'utf8' }, (err, content) => {
// If an error occurred, output it and return
if(err) return console.error(err);
// No error occurred, content is a string
console.log(content);
});
Sin codificar
Lea el archivo binario binary.txt del directorio actual, de forma asíncrona en segundo plano.
Tenga en cuenta que no configuramos la opción de 'codificación', esto evita que Node.js
decodifique el contenido en una cadena:
fs.readFile('binary', (err, binaryContent) => {
// If an error occurred, output it and return
if(err) return console.error(err);
// No error occurred, content is a Buffer, output it in
// hexadecimal representation.
console.log(content.toString('hex'));
});
Caminos relativos
Tenga en cuenta que, en general, su secuencia de comandos podría ejecutarse con un directorio
de trabajo actual arbitrario. Para tratar un archivo relacionado con el script actual, use __dirname o
__filename :
https://riptutorial.com/es/home 359

-- 387 of 423 --

fs.readFile(path.resolve(__dirname, 'someFile'), (err, binaryContent) => {
//Rest of Function
}
Listado de contenidos del directorio con readdir o readdirSync
const fs = require('fs');
// Read the contents of the directory /usr/local/bin asynchronously.
// The callback will be invoked once the operation has either completed
// or failed.
fs.readdir('/usr/local/bin', (err, files) => {
// On error, show it and return
if(err) return console.error(err);
// files is an array containing the names of all entries
// in the directory, excluding '.' (the directory itself)
// and '..' (the parent directory).
// Display directory entries
console.log(files.join(' '));
});
Una variante síncrona está disponible como readdirSync que bloquea el subproceso principal y,
por lo tanto, evita la ejecución de código asíncrono al mismo tiempo. La mayoría de los
desarrolladores evitan las funciones de E / S síncronas para mejorar el rendimiento.
let files;
try {
files = fs.readdirSync('/var/tmp');
} catch(err) {
// An error occurred
console.error(err);
}
Usando un generador
const fs = require('fs');
// Iterate through all items obtained via
// 'yield' statements
// A callback is passed to the generator function because it is required by
// the 'readdir' method
function run(gen) {
var iter = gen((err, data) => {
if (err) { iter.throw(err); }
return iter.next(data);
});
iter.next();
}
const dirPath = '/usr/local/bin';
https://riptutorial.com/es/home 360

-- 388 of 423 --

// Execute the generator function
run(function* (resume) {
// Emit the list of files in the directory from the generator
var contents = yield fs.readdir(dirPath, resume);
console.log(contents);
});
Leyendo de un archivo de forma síncrona
Para cualquier operación de archivo, necesitará el módulo del sistema de archivos:
const fs = require('fs');
Leyendo una cadena
fs.readFileSync comporta de manera similar a fs.readFile , pero no recibe una devolución de
llamada ya que se completa de forma síncrona y, por lo tanto, bloquea el subproceso principal. La
mayoría de los desarrolladores de node.js prefieren las variantes asíncronas que prácticamente
no causarán demoras en la ejecución del programa.
Si se especifica una opción de encoding , se devolverá una cadena, de lo contrario se devolverá
un Buffer .
// Read a string from another file synchronously
let content;
try {
content = fs.readFileSync('sync.txt', { encoding: 'utf8' });
} catch(err) {
// An error occurred
console.error(err);
}
Eliminando un archivo usando unlink o unlinkSync
Eliminar un archivo de forma asíncrona:
var fs = require('fs');
fs.unlink('/path/to/file.txt', function(err) {
if (err) throw err;
console.log('file deleted');
});
También puedes borrarlo sincrónicamente *:
var fs = require('fs');
fs.unlinkSync('/path/to/file.txt');
https://riptutorial.com/es/home 361

-- 389 of 423 --

console.log('file deleted');
* Evita los métodos sincrónicos porque bloquean todo el proceso hasta que finaliza la ejecución.
Leyendo un archivo en un Buffer usando streams
Si bien la lectura de contenido de un archivo ya es asíncrona con el método fs.readFile() , a
veces queremos obtener los datos en una secuencia en lugar de en una simple devolución de
llamada. Esto nos permite canalizar estos datos a otras ubicaciones o procesarlos a medida que
ingresan en lugar de todos a la vez al final.
const fs = require('fs');
// Store file data chunks in this array
let chunks = [];
// We can use this variable to store the final data
let fileBuffer;
// Read file into stream.Readable
let fileStream = fs.createReadStream('text.txt');
// An error occurred with the stream
fileStream.once('error', (err) => {
// Be sure to handle this properly!
console.error(err);
});
// File is done being read
fileStream.once('end', () => {
// create the final data Buffer from data chunks;
fileBuffer = Buffer.concat(chunks);
// Of course, you can do anything else you need to here, like emit an event!
});
// Data is flushed from fileStream in chunks,
// this callback will be executed for each chunk
fileStream.on('data', (chunk) => {
chunks.push(chunk); // push data chunk to array
// We can perform actions on the partial data we have so far!
});
Compruebe los permisos de un archivo o directorio
fs.access() determina si existe una ruta y qué permisos tiene un usuario para el archivo o
directorio en esa ruta. fs.access no devuelve un resultado sino que, si no devuelve un error, la ruta
existe y el usuario tiene los permisos deseados.
Los modos de permiso están disponibles como una propiedad en el objeto fs , fs.constants
fs.constants.F_OK - Tiene permisos de lectura / escritura / ejecución (si no se proporciona
ningún modo, este es el valor predeterminado)
•
fs.constants.R_OK - Tiene permisos de lectura	•
https://riptutorial.com/es/home 362

-- 390 of 423 --

fs.constants.W_OK - Tiene permisos de escritura	•
fs.constants.X_OK - Tiene permisos de ejecución (Funciona igual que fs.constants.F_OK en
Windows)
•
Asíncrono
var fs = require('fs');
var path = '/path/to/check';
// checks execute permission
fs.access(path, fs.constants.X_OK, (err) => {
if (err) {
console.log("%s doesn't exist", path);
} else {
console.log('can execute %s', path);
}
});
// Check if we have read/write permissions
// When specifying multiple permission modes
// each mode is separated by a pipe : `|`
fs.access(path, fs.constants.R_OK | fs.constants.W_OK, (err) => {
if (err) {
console.log("%s doesn't exist", path);
} else {
console.log('can read/write %s', path);
}
});
Síncrono
fs.access también tiene una versión síncrona fs.accessSync . Cuando use fs.accessSync , debe
encerrarlo dentro de un bloque try / catch.
// Check write permission
try {
fs.accessSync(path, fs.constants.W_OK);
console.log('can write %s', path);
}
catch (err) {
console.log("%s doesn't exist", path);
}
Evitar las condiciones de carrera al crear o utilizar un directorio existente
Debido a la naturaleza asíncrona de Node, primero se crea o utiliza un directorio:
comprobando su existencia con fs.stat() , luego	1.
Creando o usándolo dependiendo de los resultados de la verificación de existencia,	2.
puede llevar a una condición de carrera si la carpeta se crea entre el momento del cheque y el
tiempo de la creación. El siguiente método envuelve fs.mkdir() y fs.mkdirSync() en envoltorios de
https://riptutorial.com/es/home 363

-- 391 of 423 --

captura de errores que dejan pasar la excepción si su código es EEXIST (ya existe). Si el error es
otra cosa, como EPERM (permiso denegado), lance o pase un error como lo hacen las funciones
nativas.
Versión asíncrona con fs.mkdir()
var fs = require('fs');
function mkdir (dirPath, callback) {
fs.mkdir(dirPath, (err) => {
callback(err && err.code !== 'EEXIST' ? err : null);
});
}
mkdir('./existingDir', (err) => {
if (err)
return console.error(err.code);
// Do something with `./existingDir` here
});
Versión síncrona con fs.mkdirSync()
function mkdirSync (dirPath) {
try {
fs.mkdirSync(dirPath);
} catch(e) {
if ( e.code !== 'EEXIST' ) throw e;
}
}
mkdirSync('./existing-dir');
// Do something with `./existing-dir` now
Comprobando si existe un archivo o un directorio
Asíncrono
var fs = require('fs');
fs.stat('path/to/file', function(err) {
if (!err) {
console.log('file or directory exists');
}
else if (err.code === 'ENOENT') {
console.log('file or directory does not exist');
}
});
Síncrono
https://riptutorial.com/es/home 364

-- 392 of 423 --

Aquí, debemos ajustar la llamada a la función en un bloque try/catch para manejar el error.
var fs = require('fs');
try {
fs.statSync('path/to/file');
console.log('file or directory exists');
}
catch (err) {
if (err.code === 'ENOENT') {
console.log('file or directory does not exist');
}
}
Clonando un archivo usando streams
Este programa ilustra cómo se puede copiar un archivo utilizando flujos legibles y grabables
utilizando las createReadStream() y createWriteStream() proporcionadas por el módulo del sistema
de archivos.
//Require the file System module
var fs = require('fs');
/*
Create readable stream to file in current directory (__dirname) named 'node.txt'
Use utf8 encoding
Read the data in 16-kilobyte chunks
*/
var readable = fs.createReadStream(__dirname + '/node.txt', { encoding: 'utf8', highWaterMark:
16 * 1024 });
// create writable stream
var writable = fs.createWriteStream(__dirname + '/nodeCopy.txt');
// Write each chunk of data to the writable stream
readable.on('data', function(chunk) {
writable.write(chunk);
});
Copiando archivos por flujos de flujo
Este programa copia un archivo utilizando un flujo legible y escribible con la función pipe()
proporcionada por la clase de flujo.
// require the file system module
var fs = require('fs');
/*
Create readable stream to file in current directory named 'node.txt'
Use utf8 encoding
Read the data in 16-kilobyte chunks
*/
var readable = fs.createReadStream(__dirname + '/node.txt', { encoding: 'utf8', highWaterMark:
16 * 1024 });
https://riptutorial.com/es/home 365

-- 393 of 423 --

// create writable stream
var writable = fs.createWriteStream(__dirname + '/nodePipe.txt');
// use pipe to copy readable to writable
readable.pipe(writable);
Cambiando los contenidos de un archivo de texto.
Ejemplo. Reemplazará la palabra email por un name en un archivo de texto index.txt con un simple
RegExp replace(/email/gim, 'name')
var fs = require('fs');
fs.readFile('index.txt', 'utf-8', function(err, data) {
if (err) throw err;
var newValue = data.replace(/email/gim, 'name');
fs.writeFile('index.txt', newValue, 'utf-8', function(err, data) {
if (err) throw err;
console.log('Done!');
})
})
Determinación del conteo de líneas de un archivo de texto
app.js
const readline = require('readline');
const fs = require('fs');
var file = 'path.to.file';
var linesCount = 0;
var rl = readline.createInterface({
input: fs.createReadStream(file),
output: process.stdout,
terminal: false
});
rl.on('line', function (line) {
linesCount++; // on each linebreak, add +1 to 'linesCount'
});
rl.on('close', function () {
console.log(linesCount); // print the result when the 'close' event is called
});
Uso:
aplicación de nodo
Leyendo un archivo línea por línea
https://riptutorial.com/es/home 366

-- 394 of 423 --

app.js
const readline = require('readline');
const fs = require('fs');
var file = 'path.to.file';
var rl = readline.createInterface({
input: fs.createReadStream(file),
output: process.stdout,
terminal: false
});
rl.on('line', function (line) {
console.log(line) // print the content of the line on each linebreak
});
Uso:
aplicación de nodo
Lea Sistema de archivos de E / S en línea: https://riptutorial.com/es/node-js/topic/489/sistema-de-
archivos-de-e---s
https://riptutorial.com/es/home 367

-- 395 of 423 --