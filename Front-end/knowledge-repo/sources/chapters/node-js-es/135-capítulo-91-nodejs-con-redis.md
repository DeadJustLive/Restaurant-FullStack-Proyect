# Capítulo 91:: NodeJS con Redis

Observaciones
Hemos cubierto las operaciones básicas y más utilizadas en node_redis. Puede usar este módulo
para aprovechar todo el poder de Redis y crear aplicaciones Node.js realmente sofisticadas.
Puede construir muchas cosas interesantes con esta biblioteca, como una capa de
almacenamiento en caché fuerte, un potente sistema de mensajería Pub / Sub y más. Para saber
más sobre la biblioteca echa un vistazo a su documentación .
Examples
Empezando
node_redis, como puede haber adivinado, es el cliente de Redis para Node.js. Puede instalarlo
vía npm usando el siguiente comando.
npm install redis
Una vez que haya instalado el módulo node_redis, está listo para comenzar. Creemos un archivo
simple, app.js, y veamos cómo conectarnos con Redis desde Node.js.
app.js
var redis = require('redis');
client = redis.createClient(); //creates a new client
Por defecto, redis.createClient () usará 127.0.0.1 y 6379 como nombre de host y puerto
respectivamente. Si tiene un host / puerto diferente, puede proporcionarlos de la siguiente
manera:
var client = redis.createClient(port, host);
Ahora, puede realizar alguna acción una vez que se haya establecido una conexión.
Básicamente, solo necesitas escuchar los eventos de conexión como se muestra a continuación.
client.on('connect', function() {
console.log('connected');
});
Por lo tanto, el siguiente fragmento de código entra en app.js:
var redis = require('redis');
var client = redis.createClient();
client.on('connect', function() {
https://riptutorial.com/es/home 292

-- 320 of 423 --

console.log('connected');
});
Ahora, escriba la aplicación de nodo en el terminal para ejecutar la aplicación. Asegúrese de que
su servidor Redis esté en funcionamiento antes de ejecutar este fragmento de código.
Almacenamiento de pares clave-valor
Ahora que sabe cómo conectarse con Redis desde Node.js, veamos cómo almacenar pares
clave-valor en el almacenamiento de Redis.
Almacenando cadenas
Todos los comandos de Redis están expuestos como funciones diferentes en el objeto cliente.
Para almacenar una cadena simple use la siguiente sintaxis:
client.set('framework', 'AngularJS');
O
client.set(['framework', 'AngularJS']);
Los fragmentos anteriores almacenan una cadena simple AngularJS contra el marco clave. Debes
tener en cuenta que ambos fragmentos hacen lo mismo. La única diferencia es que el primero
pasa un número variable de argumentos, mientras que el último pasa una matriz args a la función
client.set() . También puede pasar una devolución de llamada opcional para recibir una
notificación cuando se complete la operación:
client.set('framework', 'AngularJS', function(err, reply) {
console.log(reply);
});
Si la operación falló por algún motivo, el argumento de err en la devolución de llamada representa
el error. Para recuperar el valor de la clave haga lo siguiente:
client.get('framework', function(err, reply) {
console.log(reply);
});
client.get() permite recuperar una clave almacenada en Redis. Se puede acceder al valor de la
clave a través de la respuesta del argumento de devolución de llamada. Si la clave no existe, el
valor de respuesta estará vacío.
Almacenamiento de hash
Muchas veces almacenar valores simples no resolverá su problema. Necesitará almacenar
hashes (objetos) en Redis. Para eso puedes usar la función hmset() como sigue:
https://riptutorial.com/es/home 293

-- 321 of 423 --

client.hmset('frameworks', 'javascript', 'AngularJS', 'css', 'Bootstrap', 'node', 'Express');
client.hgetall('frameworks', function(err, object) {
console.log(object);
});
El fragmento anterior almacena un hash en Redis que asigna cada tecnología a su marco. El
primer argumento de hmset() es el nombre de la clave. Los argumentos subsiguientes representan
pares clave-valor. De forma similar, hgetall() se utiliza para recuperar el valor de la clave. Si se
encuentra la clave, el segundo argumento de la devolución de llamada contendrá el valor que es
un objeto.
Tenga en cuenta que Redis no admite objetos anidados. Todos los valores de propiedad en el
objeto se convertirán en cadenas antes de ser almacenados. También puede usar la siguiente
sintaxis para almacenar objetos en Redis:
client.hmset('frameworks', {
'javascript': 'AngularJS',
'css': 'Bootstrap',
'node': 'Express'
});
También se puede pasar una devolución de llamada opcional para saber cuándo se completa la
operación.
Todas las funciones (comandos) se pueden llamar con equivalentes en mayúsculas / minúsculas.
Por ejemplo, client.hmset() y client.HMSET() son iguales. Listas de almacenamiento
Si desea almacenar una lista de elementos, puede utilizar las listas de Redis. Para almacenar una
lista usa la siguiente sintaxis:
client.rpush(['frameworks', 'angularjs', 'backbone'], function(err, reply) {
console.log(reply); //prints 2
});
El fragmento de código anterior crea una lista llamada marcos y le inserta dos elementos.
Entonces, la longitud de la lista es ahora dos. Como puedes ver, he pasado una matriz args a
rpush . El primer elemento de la matriz representa el nombre de la clave, mientras que el resto
representa los elementos de la lista. También puedes usar lpush() lugar de rpush() para empujar
los elementos hacia la izquierda.
Para recuperar los elementos de la lista, puede usar la función lrange() siguiente manera:
client.lrange('frameworks', 0, -1, function(err, reply) {
console.log(reply); // ['angularjs', 'backbone']
});
Solo tenga en cuenta que obtiene todos los elementos de la lista al pasar -1 como tercer
argumento a lrange() . Si desea un subconjunto de la lista, debe pasar el índice final aquí.
https://riptutorial.com/es/home 294

-- 322 of 423 --

Conjuntos de almacenamiento
Los conjuntos son similares a las listas, pero la diferencia es que no permiten duplicados. Por lo
tanto, si no desea ningún elemento duplicado en su lista, puede utilizar un conjunto. Aquí es cómo
podemos modificar nuestro fragmento anterior para usar un conjunto en lugar de una lista.
client.sadd(['tags', 'angularjs', 'backbonejs', 'emberjs'], function(err, reply) {
console.log(reply); // 3
});
Como puede ver, la función sadd() crea un nuevo conjunto con los elementos especificados. Aquí,
la longitud del conjunto es tres. Para recuperar los miembros del conjunto, use la función
smembers() siguiente manera:
client.smembers('tags', function(err, reply) {
console.log(reply);
});
Este fragmento recuperará todos los miembros del conjunto. Solo tenga en cuenta que el orden
no se conserva al recuperar los miembros.
Esta fue una lista de las estructuras de datos más importantes que se encuentran en cada
aplicación potenciada por Redis. Además de cadenas, listas, conjuntos y hashes, puede
almacenar conjuntos ordenados, hyperLogLogs y más en Redis. Si desea una lista completa de
comandos y estructuras de datos, visite la documentación oficial de Redis. Recuerde que casi
todos los comandos de Redis están expuestos en el objeto de cliente ofrecido por el módulo
node_redis.
Algunas operaciones más importantes soportadas por node_redis.
Comprobando la existencia de llaves
En ocasiones, es posible que deba comprobar si ya existe una clave y proceder en consecuencia.
Para hacerlo, puede usar la función de exists() como se muestra a continuación:
client.exists('key', function(err, reply) {
if (reply === 1) {
console.log('exists');
} else {
console.log('doesn\'t exist');
}
});
Eliminar y expirar claves
A veces tendrá que borrar algunas teclas y reinicializarlas. Para borrar las teclas, puede usar el
comando como se muestra a continuación:
client.del('frameworks', function(err, reply) {
console.log(reply);
https://riptutorial.com/es/home 295

-- 323 of 423 --

});
También puede dar un tiempo de caducidad a una clave existente de la siguiente manera:
client.set('key1', 'val1');
client.expire('key1', 30);
El fragmento de código anterior asigna un tiempo de caducidad de 30 segundos a la tecla clave1.
Incremento y decremento
Redis también soporta claves de incremento y decremento. Para incrementar una tecla use la
función incr() como se muestra a continuación:
client.set('key1', 10, function() {
client.incr('key1', function(err, reply) {
console.log(reply); // 11
});
});
La función incr() incrementa un valor clave en 1. Si necesita incrementar en una cantidad
diferente, puede usar la función incrby() . De manera similar, para disminuir una clave puede usar
las funciones como decr() y decrby() .
Lea NodeJS con Redis en línea: https://riptutorial.com/es/node-js/topic/7107/nodejs-con-redis
https://riptutorial.com/es/home 296

-- 324 of 423 --