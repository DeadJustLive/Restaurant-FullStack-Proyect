# Capítulo 85:: Node.JS con ES6

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 129)

## Contenido
# Capítulo 85:: Node.JS con ES6

Introducción
ES6, ECMAScript 6 o ES2015 es la última especificación para JavaScript que introduce algo de
azúcar sintáctico al lenguaje. Es una gran actualización del lenguaje e introduce muchas
características nuevas.
Se pueden encontrar más detalles sobre Node y ES6 en su sitio https://nodejs.org/en/docs/es6/
Examples
Nodo ES6 Soporte y creación de un proyecto con Babel.
La especificación completa de ES6 aún no se ha implementado en su totalidad, por lo que solo
podrá usar algunas de las nuevas funciones. Puede ver una lista de las funciones ES6
compatibles actuales en http://node.green/
Desde NodeJS v6 ha habido bastante buen soporte. Por lo tanto, si usa NodeJS v6 o superior,
puede disfrutar de usar ES6. Sin embargo, es posible que también desee utilizar algunas de las
características inéditas y otras del más allá. Para ello necesitarás utilizar un transpiler.
Es posible ejecutar un transpiler en tiempo de ejecución y compilación, para usar todas las
características de ES6 y más. El transpiler más popular para JavaScript se llama Babel
Babel le permite usar todas las características de la especificación ES6 y algunas características
adicionales no-en-especificación con 'stage-0' como import thing from 'thing lugar de var thing =
require('thing')
Si quisiéramos crear un proyecto en el que usáramos las características de 'stage-0', como la
importación, tendríamos que agregar Babel como un transpiler. Verá que los proyectos que usan
Reac y Vue y otros patrones comunes basados en JS implementan la etapa 0 con bastante
frecuencia.
crear un nuevo proyecto de nodo
mkdir my-es6-app
cd my-es6-app
npm init
Instala babel el preset ES6 y stage-0
npm install --save-dev babel-preset-es2015 babel-preset-stage-2 babel-cli babel-register
Cree un nuevo archivo llamado server.js y agregue un servidor HTTP básico.
import http from 'http'
https://riptutorial.com/es/home 271

-- 299 of 423 --

http.createServer((req, res) => {
res.writeHead(200, {'Content-Type': 'text/plain'})
res.end('Hello World\n')
}).listen(3000, '127.0.0.1')
console.log('Server running at http://127.0.0.1:3000/')
Tenga en cuenta que usamos un import http from 'http' esta es una función de etapa 0 y, si
funciona, significa que el transpiler funciona correctamente.
Si ejecuta node server.js , fallará al no saber cómo manejar la importación.
Creando un archivo .babelrc en la raíz de su directorio y agregue la siguiente configuración
{
"presets": ["es2015", "stage-2"],
"plugins": []
}
ahora puede ejecutar el servidor con el node src/index.js --exec babel-node
Para terminar, no es una buena idea ejecutar un transpiler en tiempo de ejecución en una
aplicación de producción. Sin embargo, podemos implementar algunos scripts en nuestro
package.json para que sea más fácil trabajar con ellos.
"scripts": {
"start": "node dist/index.js",
"dev": "babel-node src/index.js",
"build": "babel src -d dist",
"postinstall": "npm run build"
},
Lo anterior en npm install construirá el código transpilado en el directorio dist, permitiendo que npm
start a utilizar el código transpilado para nuestra aplicación de producción.
npm run dev iniciará el servidor y el tiempo de ejecución de babel, lo cual es correcto y se prefiere
cuando se trabaja en un proyecto localmente.
A continuación, puede instalar nodemon npm install nodemon --save-dev para observar los
cambios y luego reiniciar la aplicación del nodo.
Esto realmente acelera el trabajo con babel y NodeJS. En tu package.json solo actualiza el script
"dev" para usar nodemon
"dev": "nodemon src/index.js --exec babel-node",
Usa JS es6 en tu aplicación NodeJS
JS es6 (también conocido como es2015) es un conjunto de nuevas características para el
lenguaje JS cuyo objetivo es hacerlo más intuitivo al usar OOP o al enfrentar tareas de desarrollo
modernas.
https://riptutorial.com/es/home 272

-- 300 of 423 --

Requisitos previos:
Echa un vistazo a las nuevas características de es6 en http://es6-features.org - puede
aclararte si realmente quieres usarlo en tu próxima aplicación NodeJS
1.
Verifique el nivel de compatibilidad de su versión de nodo en http://node.green	2.
Si todo está bien, vamos a programar!	3.
Aquí hay una muestra muy breve de una aplicación simple de hello world con JS es6
'use strict'
class Program
{
constructor()
{
this.message = 'hello es6 :)';
}
print()
{
setTimeout(() =>
{
console.log(this.message);
this.print();
}, Math.random() * 1000);
}
}
new Program().print();
Puede ejecutar este programa y observar cómo imprime el mismo mensaje una y otra vez.
Ahora ... vamos a dividir línea por línea:
'use strict'
Esta línea es realmente necesaria si pretende usar js es6. strict modo strict , intencionalmente,
tiene una semántica diferente del código normal (lea más sobre él en MDN -
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Strict_mode)
class Program
Increíble - una palabra clave de class ! Solo para una referencia rápida, antes de es6, la única
manera de definir una cl
