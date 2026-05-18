# Capítulo 28:: csv parser en el nodo js

Introducción
La lectura de datos desde un csv se puede manejar de muchas maneras. Una solución es leer el
archivo csv en una matriz. A partir de ahí puedes trabajar en la matriz.
Examples
Usando FS para leer en un CSV
fs es la API del sistema de archivos en el nodo. Podemos usar el método readFile en nuestra
variable fs, pasarle un archivo data.csv , formato y función que lea y divida el csv para su posterior
procesamiento.
Esto supone que tiene un archivo llamado data.csv en la misma carpeta.
'use strict'
const fs = require('fs');
fs.readFile('data.csv', 'utf8', function (err, data) {
var dataArray = data.split(/\r?\n/);
console.log(dataArray);
});
Ahora puede usar la matriz como cualquier otra para trabajar en ella.
Lea csv parser en el nodo js en línea: https://riptutorial.com/es/node-js/topic/9162/csv-parser-en-
el-nodo-js
https://riptutorial.com/es/home 111

-- 139 of 423 --