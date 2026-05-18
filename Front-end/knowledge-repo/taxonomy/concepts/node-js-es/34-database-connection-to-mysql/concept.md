# Database connection to mysql

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 34)

## Contenido
# Database connection to mysql

mysql.host=localhost
mysql.port=2500
...
Ejemplo de uso de las propiedades cargadas:	•
var enviorment = require('./environments');
var PropertiesReader = require('properties-reader');
var properties = new PropertiesReader(enviorment);
var someVal = properties.get('main.app.port');
Iniciando el servidor express	•
npm start env=development
o
npm start env=production
Lea Ambiente en línea: https://riptutorial.com/es/node-js/topic/2340/ambiente
https://riptutorial.com/es/home 26

-- 54 of 423 --
