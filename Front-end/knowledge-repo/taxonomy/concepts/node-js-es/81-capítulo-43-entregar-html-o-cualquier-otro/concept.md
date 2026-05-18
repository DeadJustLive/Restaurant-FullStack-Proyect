# Capítulo 43:: Entregar HTML o cualquier otro

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 81)

## Contenido
# Capítulo 43:: Entregar HTML o cualquier otro

tipo de archivo.
Sintaxis
response.sendFile (fileName, options, function (err) {});	•
Examples
Entregar HTML en la ruta especificada
Aquí se explica cómo crear un servidor Express y servir index.html de forma predeterminada (ruta
vacía / ) y page1.html para la ruta /page1 .
Estructura de la carpeta
project root
| server.js
|____views
| index.html
| page1.html
server.js
var express = require('express');
var path = require('path');
var app = express();
// deliver index.html if no file is requested
app.get("/", function (request, response) {
response.sendFile(path.join(__dirname, 'views/index.html'));
});
// deliver page1.html if page1 is requested
app.get('/page1', function(request, response) {
response.sendFile(path.join(__dirname, 'views', 'page1.html', function(error) {
if (error) {
// do something in case of error
console.log(err);
response.end(JSON.stringify({error:"page not found"}));
}
});
});
app.listen(8080);
Tenga en cuenta que sendFile() simplemente transmite un archivo estático como respuesta, sin
https://riptutorial.com/es/home 154

-- 182 of 423 --

ofrecer la oportunidad de modificarlo. Si está sirviendo un archivo HTML y desea incluir datos
dinámicos con él, entonces necesitará usar un motor de plantillas como Pug, Moustache o EJS.
Lea Entregar HTML o cualquier otro tipo de archivo. en línea: https://riptutorial.com/es/node-
js/topic/6538/entregar-html-o-cualquier-otro-tipo-de-archivo-
https://riptutorial.com/es/home 155

-- 183 of 423 --
