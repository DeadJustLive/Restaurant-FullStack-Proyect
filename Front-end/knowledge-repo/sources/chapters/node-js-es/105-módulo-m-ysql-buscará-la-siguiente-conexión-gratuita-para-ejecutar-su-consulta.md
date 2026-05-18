# módulo M: ySQL buscará la siguiente conexión gratuita para ejecutar su consulta.

segundo. Lograr multi-tenancy en el servidor de bases de
datos con diferentes bases de datos alojadas en él.
La multipropiedad es un requisito común de las aplicaciones empresariales en la actualidad y no
se recomienda crear un grupo de conexiones para cada base de datos en el servidor de bases de
datos. Entonces, lo que podemos hacer es crear un grupo de conexión con el servidor de base de
datos y luego cambiarlos entre las bases de datos alojadas en el servidor de base de datos a
pedido.
Supongamos que nuestra aplicación tiene diferentes bases de datos para cada empresa alojada
en el servidor de bases de datos. Nos conectaremos a la base de datos de la empresa respectiva
cuando el usuario acceda a la aplicación. Aquí está el ejemplo de cómo hacer eso:
var pool = mysql.createPool({
connectionLimit : 10,
host : 'example.org',
user : 'bobby',
password : 'pass'
});
pool.getConnection(function(err, connection){
if(err){
return cb(err);
}
connection.changeUser({database : "firm1"});
connection.query("SELECT * from history", function(err, data){
connection.release();
cb(err, data);
});
});
Déjame desglosar el ejemplo:
Al definir la configuración del grupo, no le di el nombre de la base de datos, sino que solo le di un
servidor de base de datos, es decir
{
connectionLimit : 10,
host : 'example.org',
user : 'bobby',
password : 'pass'
}
por eso, cuando queremos usar la base de datos específica en el servidor de la base de datos,
https://riptutorial.com/es/home 217

-- 245 of 423 --

pedimos la conexión para golpear la base de datos mediante:
connection.changeUser({database : "firm1"});
Puede consultar la documentación oficial aquí.
Conectarse a MySQL
Una de las maneras más fáciles de conectarse a MySQL es mediante el uso del módulo mysql .
Este módulo maneja la conexión entre la aplicación Node.js y el servidor MySQL. Puedes
instalarlo como cualquier otro módulo:
npm install --save mysql
Ahora tienes que crear una conexión mysql, que puedes consultar más tarde.
const mysql = require('mysql');
const connection = mysql.createConnection({
host : 'localhost',
user : 'me',
password : 'secret',
database : 'database_schema'
});
connection.connect();
// Execute some query statements
// I.e. SELECT * FROM FOO
connection.end();
En el siguiente ejemplo, aprenderá a consultar el objeto de connection .
Consultar un objeto de conexión sin parámetros
Se envía la consulta como una cadena y en respuesta se recibe una llamada con la respuesta. La
devolución de llamada le da error , matriz de rows y campos. Cada fila contiene toda la columna
de la tabla devuelta. Aquí hay un fragmento de la siguiente explicación.
connection.query('SELECT name,email from users', function(err, rows, fields) {
if (err) throw err;
console.log('There are:', rows.length,' users');
console.log('First user name is:',rows[0].name)
});
Ejecutar una serie de consultas con una sola conexión de un grupo
Puede haber situaciones en las que haya configurado un grupo de conexiones MySQL, pero tiene
una serie de consultas que le gustaría ejecutar en secuencia:
https://riptutorial.com/es/home 218

-- 246 of 423 --

SELECT 1;
SELECT 2;
Se podía correr a continuación, utilizando pool.query como se ve en otros lugares , sin embargo,
si sólo tiene una conexión libre en la piscina debe esperar hasta que la conexión esté disponible
antes de poder ejecutar la segunda consulta.
Sin embargo, puede conservar una conexión activa del grupo y ejecutar tantas consultas como
quiera usar con una sola conexión usando pool.getConnection :
pool.getConnection(function (err, conn) {
if (err) return callback(err);
conn.query('SELECT 1 AS seq', function (err, rows) {
if (err) throw err;
conn.query('SELECT 2 AS seq', function (err, rows) {
if (err) throw err;
conn.release();
callback();
});
});
});
Nota: debe recordar release la conexión, de lo contrario, ¡hay una conexión MySQL menos
disponible para el resto del grupo!
Para obtener más información sobre la agrupación de conexiones MySQL, consulte la
documentación de MySQL .
Devuelve la consulta cuando se produce un error.
Puede adjuntar la consulta ejecutada a su objeto err cuando se produce un error:
var q = mysql.query('SELECT `name` FROM `pokedex` WHERE `id` = ?', [ 25 ], function (err,
result) {
if (err) {
// Table 'test.pokedex' doesn't exist
err.query = q.sql; // SELECT `name` FROM `pokedex` WHERE `id` = 25
callback(err);
}
else {
callback(null, result);
}
});
Grupo de conexiones de exportación
// db.js
const mysql = require('mysql');
https://riptutorial.com/es/home 219

-- 247 of 423 --

const pool = mysql.createPool({
connectionLimit : 10,
host : 'example.org',
user : 'bob',
password : 'secret',
database : 'my_db'
});
module.export = {
getConnection: (callback) => {
return pool.getConnection(callback);
}
}
// app.js
const db = require('./db');
db.getConnection((err, conn) => {
conn.query('SELECT something from sometable', (error, results, fields) => {
// get the results
conn.release();
});
});
Lea Integración de MySQL en línea: https://riptutorial.com/es/node-js/topic/1406/integracion-de-
mysql
https://riptutorial.com/es/home 220

-- 248 of 423 --