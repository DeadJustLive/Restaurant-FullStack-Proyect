# Capítulo 82:: Node.js (express.js) con código

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 126)

## Contenido
# Capítulo 82:: Node.js (express.js) con código

de ejemplo angular.js
Introducción
Este ejemplo muestra cómo crear una aplicación Express básica y luego servir a AngularJS.
Examples
Creando nuestro proyecto.
Estamos bien para ir así, corremos, de nuevo desde la consola:
mkdir our_project
cd our_project
Ahora estamos en el lugar donde vivirá nuestro código. Para crear el archivo principal de nuestro
proyecto puede ejecutar
Ok, pero ¿cómo creamos el proyecto del esqueleto expreso?
Es sencillo:
npm install -g express express-generator
Las distribuciones de Linux y Mac deben usar sudo para instalar esto porque están instaladas en
el directorio nodejs, al que solo accede el usuario root . Si todo salió bien, podemos, finalmente,
crear el esqueleto de la aplicación Express, simplemente ejecutar
express
Este comando creará dentro de nuestra carpeta una aplicación de ejemplo express. La estructura
es la siguiente:
bin/
public/
routes/
views/
app.js
package.json
Ahora, si ejecutamos npm, inicie y vaya a http: // localhost: 3000 veremos la aplicación Express
en funcionamiento, lo suficiente, hemos generado una aplicación Express sin demasiados
problemas, pero ¿cómo podemos mezclar esto con AngularJS? .
https://riptutorial.com/es/home 264

-- 292 of 423 --

¿Cómo expreso funciona, brevemente?
Express es un marco construido sobre Nodejs , puede ver la documentación oficial en el sitio
Express . Pero para nuestro propósito, necesitamos saber que Express es el responsable cuando
escribimos, por ejemplo, http: // localhost: 3000 / home al renderizar la página de inicio de nuestra
aplicación. Desde la aplicación creada recientemente podemos verificar:
FILE: routes/index.js
var express = require('express');
var router = express.Router();
/* GET home page. */
router.get('/', function(req, res, next) {
res.render('index', { title: 'Express' });
});
module.exports = router;
Lo que nos dice este código es que cuando el usuario accede a http: // localhost: 3000 , debe
mostrar la vista de índice y pasar un JSON con una propiedad de título y un valor Express. Pero
cuando revisamos el directorio de vistas y abrimos index.jade, podemos ver esto:
extends layout
block content
h1= title
p Welcome to #{title}
Esta es otra característica poderosa de Express, los motores de plantillas , que le permiten
representar contenido en la página pasándole variables o heredar otra plantilla para que sus
páginas sean más compactas y más comprensibles para los demás. La extensión del archivo es
.jade , que yo sepa, Jade cambió el nombre de Pug , básicamente es el mismo motor de
plantillas pero con algunas actualizaciones y modificaciones principales.
Instalando Pug y actualizando el motor de plantillas
Express.
Ok, para comenzar a usar Pug como motor de plantillas de nuestro proyecto, necesitamos
ejecutar:
npm install --save pug
Esto instalará Pug como una dependencia de nuestro proyecto y lo guardará en package.json .
Para usarlo necesitamos modificar el archivo app.js :
var app = express();
// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');
https://riptutorial.com/es/home 265

-- 293 of 423 --

Y reemplazar el motor de línea de vista con pug y eso es todo. Podemos volver a ejecutar nuestro
proyecto con npm start y veremos que todo está funcionando bien.
¿Cómo encaja AngularJS en todo esto?
AngularJS es un marco de Javascript MVW (Model-View-Whatever) utilizado principalmente para
crear SPA (aplicación de página simple). La instalación es bastante simple, puede ir al sitio web
de AngularJS y descargar la última versión v1.6.4 .
Después de descargar AngularJS cuando deberíamos copiar el archivo a nuestra carpeta pública
/ javascripts dentro de nuestro proyecto, una pequeña explicación, esta es la carpeta que sirve a
los recursos estáticos de nuestro sitio, imágenes, css, archivos javacript, etc. Por supuesto, esto
es configurable a través del archivo app.js , pero lo mantendremos simple. Ahora creamos un
archivo llamado ng-app.js , el archivo donde vivirá nuestra aplicación, dentro de nuestra carpeta
pública javascripts, justo donde vive AngularJS. Para abrir AngularJS necesitamos modificar el
contenido de views / layout.pug de la siguiente manera:
doctype html
html(ng-app='first-app')
head
title= title
link(rel='stylesheet', href='/stylesheets/style.css')
body(ng-controller='indexController')
block content
script(type='text-javascript', src='javascripts/angular.min.js')
script(type='text-javascript', src='javascripts/ng-app.js')
¿Qué estamos haciendo aquí? Bueno, estamos incluyendo el núcleo de AngularJS y nuestro
archivo creado recientemente ng-app.js, de modo que cuando se muestre la plantilla, aparecerá
AngularJS. Observe el uso de la directiva ng-app. AngularJS dice que este es nuestro nombre de
aplicación y que debe atenerse a él.
Entonces, el contenido de nuestro ng-app.js será:
angular.module('first-app', [])
.controller('indexController', ['$scope', indexController]);
function indexControlle
