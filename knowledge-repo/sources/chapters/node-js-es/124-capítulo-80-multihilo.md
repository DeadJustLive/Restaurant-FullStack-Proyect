# Capítulo 80:: Multihilo

Introducción
Node.js ha sido diseñado para ser de un solo hilo. Así que para todos los propósitos prácticos, las
aplicaciones que se inician con Node se ejecutarán en un solo hilo.
Sin embargo, Node.js se ejecuta en varios subprocesos. Las operaciones de E / S y similares se
ejecutarán desde un grupo de subprocesos. Además, cualquier instancia de una aplicación de
nodo se ejecutará en un subproceso diferente, por lo tanto, para ejecutar aplicaciones de
subprocesos múltiples, se inician varias instancias.
Observaciones
Comprender el bucle de eventos es importante para comprender cómo y por qué utilizar varios
subprocesos.
Examples
Racimo
El módulo de cluster permite iniciar la misma aplicación varias veces.
El agrupamiento es deseable cuando las diferentes instancias tienen el mismo flujo de ejecución y
no dependen unas de otras. En este escenario, tiene un maestro que puede iniciar las horquillas y
las horquillas (o hijos). Los niños trabajan de forma independiente y tienen su único espacio de
Ram y Event Loop.
La configuración de clústeres puede ser beneficiosa para sitios web / API. Cualquier hilo puede
servir a cualquier cliente, ya que no depende de otros hilos. Una base de datos (como Redis) se
usaría para compartir cookies, ya que las variables no se pueden compartir. entre los hilos.
// runs in each instance
var cluster = require('cluster');
var numCPUs = require('os').cpus().length;
console.log('I am always called');
if (cluster.isMaster) {
// runs only once (within the master);
console.log('I am the master, launching workers!');
for(var i = 0; i < numCPUs; i++) cluster.fork();
} else {
// runs in each fork
console.log('I am a fork!');
// here one could start, as an example, a web server
https://riptutorial.com/es/home 259

-- 287 of 423 --

}
console.log('I am always called as well');
Proceso infantil
Los procesos secundarios son el camino a seguir cuando uno quiere ejecutar procesos de forma
independiente con diferentes inicializaciones e inquietudes. Al igual que las horquillas en los
grupos, un child_process ejecuta en su hilo, pero a diferencia de las horquillas, tiene una manera
de comunicarse con su padre.
La comunicación va en ambos sentidos, por lo que los padres y el niño pueden escuchar los
mensajes y enviar mensajes.
Padre (../parent.js)
var child_process = require('child_process');
console.log('[Parent]', 'initalize');
var child1 = child_process.fork(__dirname + '/child');
child1.on('message', function(msg) {
console.log('[Parent]', 'Answer from child: ', msg);
});
// one can send as many messages as one want
child1.send('Hello'); // Hello to you too :)
child1.send('Hello'); // Hello to you too :)
// one can also have multiple children
var child2 = child_process.fork(__dirname + '/child');
Niño (../child.js)
// here would one initialize this child
// this will be executed only once
console.log('[Child]', 'initalize');
// here one listens for new tasks from the parent
process.on('message', function(messageFromParent) {
//do some intense work here
console.log('[Child]', 'Child doing some intense work');
if(messageFromParent == 'Hello') process.send('Hello to you too :)');
else process.send('what?');
})
Junto al mensaje, se pueden escuchar muchos eventos como 'error', 'conectado' o 'desconectar'.
Iniciar un proceso hijo tiene un cierto costo asociado. Uno querría engendrar la menor cantidad
posible de ellos.
https://riptutorial.com/es/home 260

-- 288 of 423 --

Lea Multihilo en línea: https://riptutorial.com/es/node-js/topic/10592/multihilo
https://riptutorial.com/es/home 261

-- 289 of 423 --