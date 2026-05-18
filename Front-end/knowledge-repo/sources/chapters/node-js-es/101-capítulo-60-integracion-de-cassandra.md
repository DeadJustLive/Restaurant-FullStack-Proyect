# Capítulo 60:: Integracion de cassandra

Examples
Hola Mundo
Para acceder cassandra-driver módulo Cassandra Cassandra cassandra-driver desde DataStax se
puede usar. Es compatible con todas las características y se puede configurar fácilmente.
const cassandra = require("cassandra-driver");
const clientOptions = {
contactPoints: ["host1", "host2"],
keyspace: "test"
};
const client = new cassandra.Client(clientOptions);
const query = "SELECT hello FROM world WHERE name = ?";
client.execute(query, ["John"], (err, results) => {
if (err) {
return console.error(err);
}
console.log(results.rows);
});
Lea Integracion de cassandra en línea: https://riptutorial.com/es/node-js/topic/5949/integracion-de-
cassandra
https://riptutorial.com/es/home 206

-- 234 of 423 --