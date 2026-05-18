# Capítulo 51:: Exportando y consumiendo

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 89)

## Contenido
# Capítulo 51:: Exportando y consumiendo

módulos
Observaciones
Mientras que todo en Node.js generalmente se hace de forma asíncrona, require() no es una de
esas cosas. Como los módulos en la práctica solo necesitan cargarse una vez, es una operación
de bloqueo y deben usarse correctamente.
Los módulos se almacenan en caché después de la primera vez que se cargan. Si está editando
un módulo en desarrollo, deberá eliminar su entrada en la memoria caché del módulo para poder
utilizar nuevos cambios. Dicho esto, incluso si un módulo se borra de la memoria caché del
módulo, el módulo en sí no se recolecta como basura, por lo que se debe tener cuidado para su
uso en entornos de producción.
Examples
Cargando y utilizando un módulo
Un módulo puede ser "importado", o de lo contrario "requerido" por la función require() . Por
ejemplo, para cargar el módulo http que se envía con Node.js, se puede usar lo siguiente:
const http = require('http');
Aparte de los módulos que se envían con el tiempo de ejecución, también puede requerir módulos
que haya instalado desde npm, como Express. Si ya había instalado Express en su sistema a
través de npm install express , simplemente podría escribir:
const express = require('express');
También puede incluir módulos que haya escrito usted mismo como parte de su aplicación. En
este caso, para incluir un archivo llamado lib.js en el mismo directorio que el archivo actual:
const mylib = require('./lib');
Tenga en cuenta que puede omitir la extensión, y se asumirá .js . Una vez que carga un módulo,
la variable se llena con un objeto que contiene los métodos y las propiedades publicadas desde el
archivo requerido. Un ejemplo completo:
const http = require('http');
// The `http` module has the property `STATUS_CODES`
console.log(http.STATUS_CODES[404]); // outputs 'Not Found'
https://riptutorial.com/es/home 174

-- 202 of 423 --

// Also contains `createServer()`
http.createServer(function(req, res) {
res.writeHead(200, {'Content-Type': 'text/html'});
res.write('<html><body>Module Test</body></html>');
res.end();
}).listen(80);
Creando un módulo hello-world.js
Node proporciona la interfaz module.exports para exponer funciones y variables a otros archivos.
La forma más sencilla de hacerlo es exportar solo un objeto (función o variable), como se muestra
en el primer ejemplo.
hola-mundo.js
module.exports = function(subject) {
console.log('Hello ' + subject);
};
Si no queremos que la exportación completa sea un solo objeto, podemos exportar funciones y
variables como propiedades del objeto de exports . Los tres ejemplos siguientes demuestran esto
de maneras ligeramente diferentes:
hello-venus.js: la definición de la función se realiza por separado y luego se agrega como
una propiedad de module.exports
•
hello-jupiter.js: las definiciones de funciones se ponen directamente como el valor de las
propiedades de module.exports
•
hello-mars.js: la definición de la función se declara directamente como una propiedad de las
exports que es una versión corta de module.exports
•
hola-venus.js
function hello(subject) {
console.log('Venus says Hello ' + subject);
}
module.exports = {
hello: hello
};
hola-jupiter.js
module.exports = {
hello: function(subject) {
console.log('Jupiter says hello ' + subject);
},
bye: function(subject) {
console.log('Jupiter says goodbye ' + subject);
}
};
https://riptutorial.com/es/home 175

-- 203 of 423 --

hola-mars.js
exports.hello = function(subject) {
console.log('Mars says Hello ' + subject);
};
