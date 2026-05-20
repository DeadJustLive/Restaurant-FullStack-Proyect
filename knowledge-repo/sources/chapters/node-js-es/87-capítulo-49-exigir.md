# Capítulo 49:: Exigir()

Introducción
Esta documentación se centra en explicar los usos y la declaración require() que NodeJS incluye
en su idioma.
Require es una importación de ciertos archivos o paquetes utilizados con los módulos de NodeJS.
Se utiliza para mejorar la estructura del código y los usos. require() se usa en archivos que se
instalan localmente, con una ruta directa desde el archivo que se require .
Sintaxis
module.exports = {testFunction: testFunction};	•
var test_file = require ('./ testFile.js'); // Tengamos un archivo llamado testFile	•
test_file.testFunction (our_data); // Deje que testFile tenga la función testFunction	•
Observaciones
El uso de require() permite que el código se estructure de manera similar al uso de las clases y
los métodos públicos de Java. Si una función es .export 'ed, puede ser require en otro archivo
para ser utilizada. Si un archivo no es .export 'ed, no se puede utilizar en otro archivo.
Examples
A partir del uso require () con una función y archivo.
Requerir es una declaración que Node interpreta como, en cierto sentido, una función getter . Por
ejemplo, supongamos que tiene un archivo llamado analysis.js , y el interior de su archivo se ve
así:
function analyzeWeather(weather_data) {
console.log('Weather information for ' + weather_data.time + ': ');
console.log('Rainfall: ' + weather_data.precip);
console.log('Temperature: ' + weather_data.temp);
//More weather_data analysis/printing...
}
Este archivo contiene solo el método, analyzeWeather(weather_data) . Si queremos usar esta
función, se debe usar dentro de este archivo, o se debe copiar en el archivo en el que quiere ser
utilizada. Sin embargo, Node ha incluido una herramienta muy útil para ayudar con la
organización de códigos y archivos, que son los módulos .
Para utilizar nuestra función, primero debemos export la función a través de una declaración al
principio. Nuestro nuevo archivo se ve así,
https://riptutorial.com/es/home 168

-- 196 of 423 --

module.exports = {
analyzeWeather: analyzeWeather
}
function analyzeWeather(weather_data) {
console.log('Weather information for ' + weather_data.time + ': ');
console.log('Rainfall: ' + weather_data.precip);
console.log('Temperature: ' + weather_data.temp);
//More weather_data analysis/printing...
}
Con esta pequeña declaración module.exports , nuestra función ahora está lista para usar fuera del
archivo. Todo lo que queda por hacer es usar require() .
Cuando se require una función o un archivo, la sintaxis es muy similar. Por lo general, se realiza
al principio del archivo y se establece en var 's o const ' s para su uso en todo el archivo. Por
ejemplo, tenemos otro archivo (en el mismo nivel que analyze.js llamado handleWeather.js que
tiene este aspecto,
const analysis = require('./analysis.js');
weather_data = {
time: '01/01/2001',
precip: 0.75,
temp: 78,
//More weather data...
};
analysis.analyzeWeather(weather_data);
En este archivo, estamos utilizando require() para capturar nuestro archivo analysis.js . Cuando
se usa, solo llamamos a la variable o constante asignada a este require y usamos la función que
se exporta dentro.
A partir del uso require () con un paquete NPM
El require del nodo también es muy útil cuando se usa en conjunto con un paquete NPM .
Digamos, por ejemplo, que le gustaría usar el paquete NPM require en un archivo llamado
getWeather.js . Después de que NPM haya instalado su paquete a través de su línea de comando
( git install request ), estará listo para usarlo. Su archivo getWeather.js podría gustarle mirar
esto,
var https = require('request');
//Construct your url variable...
https.get(url, function(error, response, body) {
if (error) {
console.log(error);
} else {
console.log('Response => ' + response);
console.log('Body => ' + body);
}
});
Cuando se ejecuta este archivo, primero se require (importa) el paquete que acaba de instalar
https://riptutorial.com/es/home 169

-- 197 of 423 --

llamado request . Dentro del archivo de request , hay muchas funciones a las que ahora tiene
acceso, una de las cuales se llama get . En las siguientes dos líneas, la función se utiliza para
realizar una solicitud GET de HTTP .
Lea Exigir() en línea: https://riptutorial.com/es/node-js/topic/10742/exigir--
https://riptutorial.com/es/home 170

-- 198 of 423 --