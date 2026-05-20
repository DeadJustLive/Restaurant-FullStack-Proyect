# Módulo d: e traducción simple y ligero con almacenamiento dinámico de json. Es compatible con

las aplicaciones plain vanilla node.js y debe funcionar con cualquier marco (como Express, Restify
y probablemente más) que expone un método app.use () que pasa objetos res y req. Utiliza la
sintaxis __ ('...') común en aplicaciones y plantillas. Almacena archivos de idioma en archivos json
compatibles con el formato webtranslateit json. Agrega nuevas cadenas sobre la marcha cuando
se usan por primera vez en su aplicación. No se necesita un análisis adicional.
Expresa + i18n-node + cookieParser y evita problemas de concurrencia
// usual requirements
var express = require('express'),
i18n = require('i18n'),
app = module.exports = express();
i18n.configure({
// setup some locales - other locales default to en silently
locales: ['en', 'ru', 'de'],
// sets a custom cookie name to parse locale settings from
cookie: 'yourcookiename',
// where to store json files - defaults to './locales'
directory: __dirname + '/locales'
});
app.configure(function () {
// you will need to use cookieParser to expose cookies to req.cookies
app.use(express.cookieParser());
// i18n init parses req for language headers, cookies, etc.
app.use(i18n.init);
});
// serving homepage
app.get('/', function (req, res) {
res.send(res.__('Hello World'));
});
// starting server
if (!module.parent) {
https://riptutorial.com/es/home 238

-- 266 of 423 --

app.listen(3000);
}
Lea Localización Nodo JS en línea: https://riptutorial.com/es/node-js/topic/9594/localizacion-nodo-
js
https://riptutorial.com/es/home 239

-- 267 of 423 --