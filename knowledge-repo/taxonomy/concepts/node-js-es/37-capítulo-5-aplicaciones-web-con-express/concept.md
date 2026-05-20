# Capítulo 5:: Aplicaciones Web Con Express

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 37)

## Contenido
# Capítulo 5:: Aplicaciones Web Con Express

Introducción
Express es un marco de aplicación web Node.js mínimo y flexible, que proporciona un conjunto
robusto de características para crear aplicaciones web.
El sitio web oficial de Express es expressjs.com . La fuente se puede encontrar en GitHub .
Sintaxis
app.get (ruta [, middleware], devolución de llamada [, devolución de llamada ...])	•
app.put (ruta [, middleware], devolución de llamada [, devolución de llamada ...])	•
app.post (ruta [, middleware], devolución de llamada [, devolución de llamada ...])	•
aplicación ['eliminar'] (ruta [, middleware], devolución de llamada [, devolución de llamada
...])
•
app.use (ruta [, middleware], devolución de llamada [, devolución de llamada ...])	•
app.use (devolución de llamada)	•
Parámetros
Parámetro Detalles
path Especifica la parte de la ruta o la URL que manejará la devolución de
llamada dada.
middleware
Una o más funciones que serán llamadas antes de la devolución de
llamada. Esencialmente un encadenamiento de múltiples funciones de
callback de callback . Útil para un manejo más específico, por ejemplo,
autorización o manejo de errores.
callback
Una función que se utilizará para manejar solicitudes a la path
especificada. Se llamará como callback(request, response, next) , donde
request , response y next se describen a continuación.
request
devolución de
llamada
Un objeto que encapsula detalles sobre la solicitud HTTP a la que se llama
la devolución de llamada para que la maneje.
response Un objeto que se utiliza para especificar cómo debe responder el servidor
a la solicitud.
next Una devolución de llamada que pasa el control a la siguiente ruta
coincidente. Acepta un objeto de error opcional.
https://riptutorial.com/es/home 29

-- 57 of 423 --

Examples
Empezando
Primero deberá crear un directorio, acceder a él en su shell e instalar Express usando npm
ejecutando npm install express --save
Cree un archivo y app.js nombre app.js y agregue el siguiente código que crea un nuevo servidor
Express y le agrega un punto final ( /ping ) con el método app.get :
const express = require('express');
const app = express();
app.get('/ping', (request, response) => {
response.send('pong');
});
app.listen(8080, 'localhost');
Para ejecutar su script use el siguiente comando en su shell:
> node app.js
Su aplicación aceptará conexiones en el puerto localhost 8080. Si se omite el argumento del
nombre de host para app.listen , el servidor aceptará las conexiones en la dirección IP de la
máquina, así como en el host local. Si el valor del puerto es 0, el sistema operativo asignará un
puerto disponible.
Una vez que se ejecuta el script, puede probarlo en un shell para confirmar que obtiene la
respuesta esperada, "pong", desde el servidor:
> curl http://localhost:8080/ping
pong
También puede abrir un navegador web, navegar a la url http: // localhost: 8080 / ping para ver el
resultado
Enrutamiento básico
Primero crea una aplicación expresa:
const express = require('express');
const app = express();
Entonces puedes definir rutas como esta:
app.get('/someUri', function (req, res, next) {})
https://riptutorial.com/es/home 30

-- 58 of 423 --

Esa estructura funciona para todos los métodos HTTP y espera una ruta como primer argumento
y un controlador para esa ruta, que recibe los objetos de solicitud y respuesta. Entonces, para los
métodos HTTP básicos, estas son las rutas
// GET www.domain.com/myPath
app.get('/myPath', function (req, res, next) {})
// POST www.domain.com/myPath
app.post('/myPath', function (req, res, next) {})
// PUT www.domain.com/myPath
app.put('/myPath', function (req, res, next) {})
// DELETE www.domain.com/myPath
app.delete('/myPath', function (req, res, next) {})
Puede consultar la lista completa de verbos compatibles aquí . Si desea definir el mismo
comportamiento para una ruta y todos los métodos HTTP, puede usar:
app.all('/myPath', function (req, res, next) {})
o
app.use('/myPath', function (req, res, next) {})
o
app.use('*', function (req, res, next) {})
// * wildcard will route for all paths
Puedes encadenar tus definiciones de ruta para un solo camino
app.route('/myPath')
.get(function (req, res, next) {})
.post(function (req, res, next) {})
.put(function (req, res, next) {})
También puede agregar funciones a cualquier método HTTP. Se ejecutarán antes de la
devolución de llamada final y tomarán los parámetros (req, res, next) como argumentos.
// GET www.domain.com/myPath
app.get('/myPath', myFunction, function (req, res, next) {})
Sus devoluciones de llamada finales se pueden almacenar en un archivo externo para evitar
poner demasiado código en un archivo:
// other.js
exports.doSomething = function(req, res, next) {/* do some stuff */};
https://riptutorial.com/es/home 31

-- 59 of 423 --

Y luego en el archivo que contiene tus rutas:
const other = require('./other.js');
app.get('/someUri', myFunction, other.doSomething);
Esto hará que su código sea mucho más limpio.
Obteniendo información de la solicitud
Par
