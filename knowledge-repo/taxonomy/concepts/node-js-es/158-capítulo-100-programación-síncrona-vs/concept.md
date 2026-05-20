# Capítulo 100:: Programación síncrona vs

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 158)

## Contenido
# Capítulo 100:: Programación síncrona vs

asíncrona en nodejs
Examples
Usando async
El paquete asíncrono proporciona funciones para código asíncrono.
Usando la función automática puede definir relaciones asíncronas entre dos o más funciones:
var async = require('async');
async.auto({
get_data: function(callback) {
console.log('in get_data');
// async code to get some data
callback(null, 'data', 'converted to array');
},
make_folder: function(callback) {
console.log('in make_folder');
// async code to create a directory to store a file in
// this is run at the same time as getting the data
callback(null, 'folder');
},
write_file: ['get_data', 'make_folder', function(results, callback) {
console.log('in write_file', JSON.stringify(results));
// once there is some data and the directory exists,
// write the data to a file in the directory
callback(null, 'filename');
}],
email_link: ['write_file', function(results, callback) {
console.log('in email_link', JSON.stringify(results));
// once the file is written let's email a link to it...
// results.write_file contains the filename returned by write_file.
callback(null, {'file':results.write_file, 'email':'user@example.com'});
}]
}, function(err, results) {
console.log('err = ', err);
console.log('results = ', results);
});
Este código podría haberse realizado de forma sincrónica, simplemente llamando a get_data ,
make_folder , write_file y email_link en el orden correcto. Async realiza un seguimiento de los
resultados para usted, y si se produjo un error (el primer parámetro de callback de callback igual a
null ) detiene la ejecución de las otras funciones.
Lea Programación síncrona vs asíncrona en nodejs en línea: https://riptutorial.com/es/node-
js/topic/8287/programacion-sincrona-vs-asincrona-en-nodejs
https://riptutorial.com/es/home 348

-- 376 of 423 --
