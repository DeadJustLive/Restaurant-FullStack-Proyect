# Capítulo 63:: Integración de MySQL

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 104)

## Contenido
# Capítulo 63:: Integración de MySQL

Introducción
En este tema, aprenderá cómo integrarse con Node.js usando la herramienta de administración
de bases de datos MYSQL. Aprenderá varias formas de conectarse e interactuar con los datos
que residen en mysql mediante un programa y script de nodejs.
Examples
Consultar un objeto de conexión con parámetros.
Cuando desee utilizar el contenido generado por el usuario en el SQL, éste se realiza con los
parámetros. Por ejemplo, para buscar usuarios con el nombre aminadav , debe hacer:
var username = 'aminadav';
var querystring = 'SELECT name, email from users where name = ?';
connection.query(querystring, [username], function(err, rows, fields) {
if (err) throw err;
if (rows.length) {
rows.forEach(function(row) {
console.log(row.name, 'email address is', row.email);
});
} else {
console.log('There were no results.');
}
});
Usando un conjunto de conexiones
a. Ejecutando múltiples consultas al mismo tiempo
Todas las consultas en la conexión de MySQL se realizan una tras otra. Esto significa que si
desea hacer 10 consultas y cada consulta tarda 2 segundos, se tardará 20 segundos en
completar toda la ejecución. La solución es crear 10 conexiones y ejecutar cada consulta en una
conexión diferente. Esto se puede hacer automáticamente utilizando el conjunto de conexiones.
var pool = mysql.createPool({
connectionLimit : 10,
host : 'example.org',
user : 'bobby',
password : 'pass',
database : 'schema'
});
for(var i=0;i<10;i++){
pool.query('SELECT ` as example', function(err, rows, fields) {
if (err) throw err;
console.log(rows[0].example); //Show 1
https://riptutorial.com/es/home 216

-- 244 of 423 --

});
}
Se ejecutarán todas las 10 consultas en paralelo.
Cuando usas pool ya no necesitas la conexión. Puede consultar directamente la piscina. El
