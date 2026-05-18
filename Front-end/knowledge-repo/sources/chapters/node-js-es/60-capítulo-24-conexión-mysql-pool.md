# Capítulo 24:: Conexión Mysql Pool

Examples
Usando un grupo de conexiones sin base de datos
Lograr la multitenidad en el servidor de bases de datos con múltiples bases de datos alojadas en
él.
La multipropiedad es un requisito común de las aplicaciones empresariales en la actualidad y no
se recomienda crear un grupo de conexiones para cada base de datos en el servidor de bases de
datos. Entonces, lo que podemos hacer es crear un grupo de conexiones con el servidor de base
de datos y luego cambiar entre las bases de datos alojadas en el servidor de base de datos a
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
https://riptutorial.com/es/home 103

-- 131 of 423 --

pedimos la conexión para golpear la base de datos mediante:
connection.changeUser({database : "firm1"});
Puede consultar la documentación oficial aquí.
Lea Conexión Mysql Pool en línea: https://riptutorial.com/es/node-js/topic/6353/conexion-mysql-
pool
https://riptutorial.com/es/home 104

-- 132 of 423 --