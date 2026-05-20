# Capítulo 86:: Node.js con Oracle

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 130)

## Contenido
# Capítulo 86:: Node.js con Oracle

Examples
Conectarse a Oracle DB
Una forma muy fácil de conectarse a una base de datos ORACLE es mediante el uso del módulo
oracledb . Este módulo maneja la conexión entre su aplicación Node.js y el servidor Oracle.
Puedes instalarlo como cualquier otro módulo:
npm install oracledb
Ahora tienes que crear una conexión ORACLE, que puedes consultar más tarde.
const oracledb = require('oracledb');
oracledb.getConnection(
{
user : "oli",
password : "password",
connectString : "ORACLE_DEV_DB_TNS_NAME"
},
connExecute
);
El connectString "ORACLE_DEV_DB_TNA_NAME" puede residir en un archivo tnsnames.org en
el mismo directorio o donde está instalado su cliente instantáneo de Oracle.
Si no tiene ningún cliente instantáneo de Oracle instalado en su máquina de desarrollo, puede
seguir la instant client installation guide para su sistema operativo.
Consultar un objeto de conexión sin parámetros
El uso ahora puede usar la función connExecute para ejecutar una consulta. Tiene la opción de
obtener el resultado de la consulta como un objeto o matriz. El resultado está impreso en
console.log.
function connExecute(err, connection)
{
if (err) {
console.error(err.message);
return;
}
sql = "select 'test' as c1, 'oracle' as c2 from dual";
connection.execute(sql, {}, { outFormat: oracledb.OBJECT }, // or oracledb.ARRAY
function(err, result)
{
if (err) {
console.error(err.message);
connRelease(connection);
https://riptutorial.com/es/home 275

-- 303 of 423 --

return;
}
console.log(result.metaData);
console.log(result.rows);
connRelease(connection);
});
}
Dado que usamos una conexión no agrupada, tenemos que liberar nuestra conexión nuevamente.
function connRelease(connection)
{
connection.close(
function(err) {
if (err) {
console.error(err.message);
}
});
}
La salida para un objeto será
[ { name: 'C1' }, { name: 'C2' } ]
[ { C1: 'test', C2: 'oracle' } ]
y la salida para una matriz será
[ { name: 'C1' }, { name: 'C2' } ]
[ [ 'test', 'oracle' ] ]
Usando un módulo local para facilitar la consulta
Para simplificar su consulta desde ORACLE-DB, puede llamar a su consulta de la siguiente
manera:
const oracle = require('./oracle.js');
const sql = "select 'test' as c1, 'oracle' as c2 from dual";
oracle.queryObject(sql, {}, {})
.then(function(result) {
console.log(result.rows[0]['C2']);
})
.catch(function(err) {
next(err);
});
La creación y conexión de la conexión se incluye en este archivo oracle.js con el siguiente
contenido:
'use strict';
const oracledb = require('oracledb');
const oracleDbRelease = function(conn) {
https://riptutorial.com/es/home 276

-- 304 of 423 --

conn.release(function (err) {
if (err)
console.log(err.message);
});
};
function queryArray(sql, bindParams, options) {
options.isAutoCommit = false; // we only do SELECTs
return new Promise(function(resolve, reject) {
oracledb.getConnection(
{
user : "oli",
password : "password",
connectString : "ORACLE_DEV_DB_TNA_NAME"
})
.then(function(connection){
//console.log("sql log: " + sql + " params " + bindParams);
connection.execute(sql, bindParams, options)
.then(function(results) {
resolve(results);
process.nextTick(function() {
oracleDbRelease(connection);
});
})
.catch(function(err) {
reject(err);
process.nextTick(function() {
oracleDbRelease(connection);
});
});
})
.catch(function(err) {
reject(err);
});
});
}
function queryObject(sql, bindParams, options) {
options['outFormat'] = oracledb.OBJECT; // default is oracledb.ARRAY
return queryArray(sql, bindParams, options);
}
module.exports = queryArray;
module.exports.queryArray = queryArray;
module.exports.queryObject = queryObject;
Tenga en cuenta que tiene ambos métodos queryArray y queryObject para llamar a su objeto
oracle.
Lea Node.js con Oracle en línea: https://riptutorial.com/es/node-js/topic/8248/node-js-con-oracle
https://riptutorial.com/es/home 277

-- 305 of 423 --
