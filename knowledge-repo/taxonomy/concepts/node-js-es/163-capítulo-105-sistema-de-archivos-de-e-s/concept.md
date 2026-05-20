# Capítulo 105:: Sistema de archivos de E / S

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 163)

## Contenido
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
// A callback is passed to the generator 
