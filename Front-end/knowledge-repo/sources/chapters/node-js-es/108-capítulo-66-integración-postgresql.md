# Capítulo 66:: Integración PostgreSQL

Examples
Conectarse a PostgreSQL
Usando el módulo npm de PostgreSQL .
instala dependencia desde npm
npm install pg --save
Ahora tienes que crear una conexión PostgreSQL, que puedes consultar más tarde.
Supongamos que Database_Name = estudiantes, Host = localhost y DB_User = postgres
var pg = require("pg")
var connectionString = "pg://postgres:postgres@localhost:5432/students";
var client = new pg.Client(connectionString);
client.connect();
Consulta con objeto de conexión
Si desea utilizar el objeto de conexión para la base de datos de consultas, puede utilizar este
código de ejemplo.
var queryString = "SELECT name, age FROM students " ;
var query = client.query(queryString);
query.on("row", (row, result)=> {
result.addRow(row);
});
query.on("end", function (result) {