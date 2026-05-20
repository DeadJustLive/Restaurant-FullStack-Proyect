# Capítulo 33:: Despliegue de aplicaciones

Node.js en producción
Examples
Configurando NODE_ENV = "producción"
Las implementaciones de producción variarán de muchas maneras, pero una convención
estándar cuando se implementa en producción es definir una variable de entorno llamada NODE_ENV
y establecer su valor en "producción" .
Banderas de tiempo de ejecución
Cualquier código que se ejecute en su aplicación (incluidos los módulos externos) puede verificar
el valor de NODE_ENV :
if(process.env.NODE_ENV === 'production') {
// We are running in production mode
} else {
// We are running in development mode
}
Dependencias
Cuando la variable de entorno NODE_ENV se establece en 'producción', todas las devDependencies en
su archivo package.json se ignorarán completamente cuando se ejecute npm install . También
puede imponer esto con un indicador de --production :
npm install --production
Para configurar NODE_ENV puedes usar cualquiera de estos métodos
Método 1: configurar NODE_ENV para todas las aplicaciones de nodo
Windows:
set NODE_ENV=production
Linux u otro sistema basado en Unix:
export NODE_ENV=production
Esto establece NODE_ENV para la sesión de bash actual, por lo tanto, cualquier aplicación iniciada
https://riptutorial.com/es/home 123

-- 151 of 423 --

después de esta declaración tendrá NODE_ENV establecido en production .
Método 2: establece NODE_ENV para la aplicación actual
NODE_ENV=production node app.js
Esto establecerá NODE_ENV para la aplicación actual. Esto ayuda cuando queremos probar nuestras
aplicaciones en diferentes entornos.
Método 3: crear .env archivo .env y usarlo
Esto utiliza la idea explicada aquí . Consulte esta publicación para una explicación más detallada.
Básicamente, creas .env archivo .env y ejecutas algunos scripts de bash para establecerlos en el
entorno.
Para evitar escribir un script bash, el paquete env-cmd se puede usar para cargar las variables de
entorno definidas en el archivo .env .
env-cmd .env node app.js
Método 4: usar el paquete de cross-env
Este paquete permite que las variables de entorno se configuren de una manera para cada
plataforma.
Después de instalarlo con npm, puede agregarlo a su script de implementación en package.json
siguiente manera:
"build:deploy": "cross-env NODE_ENV=production webpack"
Administrar la aplicación con el administrador de procesos
Es una buena práctica ejecutar aplicaciones de NodeJS controladas por los administradores de
procesos. El administrador de procesos ayuda a mantener viva la aplicación para siempre, reinicia
en caso de falla, recarga sin tiempo de inactividad y simplifica la administración. Los más
poderosos de ellos (como PM2 ) tienen un equilibrador de carga incorporado. PM2 también le
permite administrar el registro de aplicaciones, la supervisión y la agrupación en clústeres.
Gestor de procesos PM2
Instalación de PM2:
npm install pm2 -g
El proceso se puede iniciar en modo de clúster que incluye un equilibrador de carga integrado
para distribuir la carga entre procesos:
pm2 start app.js -i 0 --name "api" ( -i es para especificar el número de procesos que se
https://riptutorial.com/es/home 124

-- 152 of 423 --

generarán. Si es 0, el número de proceso se basará en el recuento de núcleos de CPU)
Si bien tiene múltiples usuarios en producción, es necesario tener un solo punto para PM2. Por lo
tanto, el comando pm2 debe tener el prefijo de una ubicación (para la configuración de PM2), de
lo contrario, generará un nuevo proceso de pm2 para cada usuario con la configuración en el
directorio de inicio correspondiente. Y será inconsistente.
Uso: PM2_HOME=/etc/.pm2 pm2 start app.js
Despliegue utilizando PM2
PM2 es un administrador de procesos de producción para aplicaciones Node.js , que le permite
mantener las aplicaciones activas para siempre y recargarlas sin tiempo de inactividad. PM2
también le permite administrar el registro de aplicaciones, la supervisión y la agrupación en
clústeres.
Instale pm2 globalmente.
npm install -g pm2
Luego, ejecute la aplicación node.js usando PM2.
pm2 start server.js --name "my-app"
Los siguientes comandos son útiles mientras se trabaja con PM2 .
Listar todos los procesos en ejecución:
pm2 list
Detener una aplicación:
pm2 stop my-app
Reinicie una aplicación:
pm2 restart my-app
https://riptutorial.com/es/home 125

-- 153 of 423 --

Para ver información detallada sobre una aplicación:
pm2 show my-app
Para eliminar una aplicación del registro de PM2:
pm2 delete my-app
Despliegue usando el administrador de procesos
El administrador de procesos se usa generalmente en producción para implementar una
aplicación nodejs. Las funciones principales de un administrador de procesos son reiniciar el
servidor si falla, verificar el consumo de recursos, mejorar el rendimiento en tiempo de ejecución,
monitorear, etc.
Algunos de los gestores de procesos populares creados por la comunidad de nodos son forever,
pm2, etc.
Forvever
forever es una herramienta de interfaz de línea de comandos para garantizar que un script dado
se ejecute continuamente. La sencilla interfaz de forever lo hace ideal para ejecutar
implementaciones más pequeñas de aplicaciones y scripts Node.js
forever supervisa su proceso y lo reinicia si se bloquea.
Instalar forever globalmente.
$ npm install -g forever
Ejecutar aplicación:
$ forever start server.js
Esto inicia el servidor y proporciona una identificación para el proceso (comienza desde 0).
Reiniciar aplicación :
$ forever restart 0
Aquí 0 es el id del servidor.
Detener la aplicación:
$ forever stop 0
Similar a reiniciar, 0 es el id del servidor. También puede dar el ID del proceso o el nombre del
https://riptutorial.com/es/home 126

-- 154 of 423 --

script en lugar del ID dado por el siempre.
Para más comandos: https://www.npmjs.com/package/forever
Uso de diferentes propiedades / configuración para diferentes entornos como
dev, qa, puesta en escena, etc.
Las aplicaciones a gran escala a menudo necesitan propiedades diferentes cuando se ejecutan
en diferentes entornos. podemos lograrlo pasando argumentos a la aplicación NodeJs y usando el
mismo argumento en el proceso del nodo para cargar un archivo de propiedades del entorno
específico.
Supongamos que tenemos dos archivos de propiedades para diferentes entornos.
dev.json
{
"PORT": 3000,
"DB": {
"host": "localhost",
"user": "bob",
"password": "12345"
}
}
•
qa.json
{
"PORT": 3001,
"DB": {
"host": "where_db_is_hosted",
"user": "bob",
"password": "54321"
}
}
•
El siguiente código en la aplicación exportará el archivo de propiedad respectivo que queremos
usar.
process.argv.forEach(function (val) {
var arg = val.split("=");
if (arg.length > 0) {
if (arg[0] === 'env') {
var env = require('./' + arg[1] + '.json');
exports.prop = env;
}
}
});
https://riptutorial.com/es/home 127

-- 155 of 423 --

Damos argumentos a la aplicación como sigue.
node app.js env=dev
Si estamos usando un administrador de procesos como para siempre, es tan simple como
forever start app.js env=dev
Aprovechando los clusters.
Una sola instancia de Node.js se ejecuta en un solo hilo. Para aprovechar los sistemas de
múltiples núcleos, el usuario a veces querrá iniciar un clúster de procesos Node.js para manejar la
carga.
var cluster = require('cluster');
var numCPUs = require('os').cpus().length;
if (cluster.isMaster) {
// In real life, you'd probably use more than just 2 workers,
// and perhaps not put the master and worker in the same file.
//
// You can also of course get a bit fancier about logging, and
// implement whatever custom logic you need to prevent DoS
// attacks and other bad behavior.
//
// See the options in the cluster documentation.
//
// The important thing is that the master does very little,
// increasing our resilience to unexpected errors.
console.log('your server is working on ' + numCPUs + ' cores');
for (var i = 0; i < numCPUs; i++) {
cluster.fork();
}
cluster.on('disconnect', function(worker) {
console.error('disconnect!');
//clearTimeout(timeout);
cluster.fork();
});
} else {
require('./app.js');
}
Lea Despliegue de aplicaciones Node.js en producción en línea: https://riptutorial.com/es/node-
js/topic/2975/despliegue-de-aplicaciones-node-js-en-produccion
https://riptutorial.com/es/home 128

-- 156 of 423 --