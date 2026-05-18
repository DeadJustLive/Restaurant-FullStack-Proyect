# Capítulo 23:: React Boilerplate [React + Babel

+ Webpack]
Examples
Configurando el proyecto
Necesita Node Package Manager para instalar las dependencias del proyecto. Descargue el nodo
para su sistema operativo desde Nodejs.org . Node Package Manager viene con nodo.
También puede usar Node Version Manager para administrar mejor sus versiones de nodo y npm.
Es ideal para probar su proyecto en diferentes versiones de nodos. Sin embargo, no se
recomienda para el entorno de producción.
Una vez que haya instalado el nodo en su sistema, siga adelante e instale algunos paquetes
esenciales para explotar su primer proyecto React utilizando Babel y Webpack.
Antes de que realmente comencemos a golpear comandos en el terminal. Eche un vistazo a para
qué se utilizan Babel y Webpack .
Puede iniciar su proyecto ejecutando npm init en su terminal. Siga la configuración inicial.
Después de eso, ejecute los siguientes comandos en su terminal-
Dependencias:
npm install react react-dom --save
Dev Dependecies:
npm install babel-core babel-loader babel-preset-es2015 babel-preset-react babel-preset-stage-0
webpack webpack-dev-server react-hot-loader --save-dev
Dependencias de desarrollo opcional:
npm install eslint eslint-plugin-react babel-eslint --save-dev
Puede hacer referencia a esta muestra de package.json
Cree .babelrc en la raíz de su proyecto con los siguientes contenidos:
{
"presets": ["es2015", "stage-0", "react"]
}
Opcionalmente, cree .eslintrc en la raíz de su proyecto con los siguientes contenidos:
{
"ecmaFeatures": {
"jsx": true,
https://riptutorial.com/es/home 90

-- 100 of 139 --

"modules": true
},
"env": {
"browser": true,
"node": true
},
"parser": "babel-eslint",
"rules": {
"quotes": [2, "single"],
"strict": [2, "never"],
},
"plugins": [
"react"
]
}
Cree un archivo .gitignore para evitar cargar archivos generados en su repositorio git.
node_modules
npm-debug.log
.DS_Store
dist
Cree el archivo webpack.config.js con los siguientes contenidos mínimos.
var path = require('path');
var webpack = require('webpack');
module.exports = {
devtool: 'eval',
entry: [
'webpack-dev-server/client?http://localhost:3000',
'webpack/hot/only-dev-server',
'./src/index'
],
output: {
path: path.join(__dirname, 'dist'),
filename: 'bundle.js',
publicPath: '/static/'
},
plugins: [
new webpack.HotModuleReplacementPlugin()
],
module: {
loaders: [{
test: /\.js$/,
loaders: ['react-hot', 'babel'],
include: path.join(__dirname, 'src')
}]
}
};
Y finalmente, cree un archivo sever.js para poder ejecutar npm start , con los siguientes
contenidos:
var webpack = require('webpack');
var WebpackDevServer = require('webpack-dev-server');
https://riptutorial.com/es/home 91

-- 101 of 139 --

var config = require('./webpack.config');
new WebpackDevServer(webpack(config), {
publicPath: config.output.publicPath,
hot: true,
historyApiFallback: true
}).listen(3000, 'localhost', function (err, result) {
if (err) {
return console.log(err);
}
console.log('Serving your awesome project at http://localhost:3000/');
});
Cree el archivo src/app.js para ver cómo su proyecto React hace algo.
import React, { Component } from 'react';
export default class App extends Component {
render() {
return (
<h1>Hello, world.</h1>
);
}
}
Ejecute node server.js o npm start en el terminal, si ha definido lo que significa start en su
package.json
proyecto react-starter
Sobre este proyecto
Este es un proyecto simple. Esta publicación te guiará para configurar el entorno para ReactJs +
Webpack + Bable.
Empecemos
necesitaremos el administrador de paquetes de nodos para encender el servidor Express y
administrar las dependencias a lo largo del proyecto. Si es nuevo en el administrador de paquetes
de nodos, puede consultar aquí . Nota: aquí se requiere la instalación del administrador de
paquetes de nodos.
Cree una carpeta con un nombre adecuado y navegue en ella desde la terminal o por GUI. Luego,
vaya a la terminal y escriba npm init Esto creará un archivo package.json. Nada de miedo, le hará
algunas preguntas como el nombre de su proyecto, versión, descripción, punto de entrada,
repositorio git, autor, licencia, etc. Aquí, el punto de entrada es importante porque el nodo lo
buscará inicialmente cuando ejecute el proyecto. Al final, le pedirá que verifique la información
que proporciona. Puede escribir sí o modificarlo. Bueno, eso es todo, nuestro archivo
package.json está listo.
Configuración del servidor Express ejecutar npm install express @ 4 --save . Esta es todas las
dependencias que necesitamos para este proyecto. Aquí el indicador de guardado es importante,
https://riptutorial.com/es/home 92

-- 102 of 139 --

sin él, el archivo package.js no se actualizará. La tarea principal de package.json es almacenar la
lista de dependencias. Agregará la versión expresa 4. Su package.json se verá como
"dependencies": { "express": "^4.13.4", ............. },
Después de la descarga completa, puede ver que hay una carpeta y subcarpeta de
node_modules de nuestras dependencias. Ahora en la raíz del proyecto crea un nuevo archivo
server.js . Ahora estamos configurando el servidor express. Voy a pasar todo el código y lo
explicaré más tarde.
var express = require('express');
// Create our app
var app = express();
app.use(express.static('public'));
app.listen(3000, function () {
console.log('Express server is using port:3000');
});
var express = require ('express'); Esto te dará el acceso de toda la API expresa.
var app = express (); Llamaré a express library como función. app.use (); Deja que la agregue la
funcionalidad a tu aplicación express. app.use (express.static ('public')); Especificará el nombre de
la carpeta que será expuesta en nuestro servidor web. app.listen (puerto, función () {}) aquí será
nuestro puerto 3000 y la función a la que llamamos verificará que el servidor web esté
funcionando correctamente. Eso es todo lo que el servidor Express está configurado.
Ahora vaya a nuestro proyecto y cree una nueva carpeta pública y cree el archivo index.html .
index.html es el archivo predeterminado para su aplicación y Express Server buscará este
archivo. El index.html es un archivo html simple que parece
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
</head>
<body>
<h1>hello World</h1>
</body>
</html>
Y vaya a la ruta del proyecto a través del terminal y escriba node server.js . Luego verá *
console.log ('El servidor Express está usando el puerto: 3000'); *.
Vaya al navegador y escriba http: // localhost: 3000 en la barra de navegación, verá Hola Mundo .
Ahora ve dentro de la carpeta pública y crea un nuevo archivo app.jsx . JSX es un paso de
preprocesador que agrega sintaxis XML a tu JavaScript. Definitivamente puedes usar React sin
JSX, pero JSX hace que React sea mucho más elegante. Aquí está el código de ejemplo para
app.jsx
https://riptutorial.com/es/home 93

-- 103 of 139 --

ReactDOM.render(
<h1>Hello World!!!</h1>,
document.getElementById('app')
);
Ahora ve a index.html y modifica el código, debería tener este aspecto
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23
/browser.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.7/react.js">
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.7/react-dom.js"> </script>
</head>
<body>
<div id="app"></div>
<script type="text/babel" src="app.jsx"></script>
</body>
</html>
Con esto en su lugar, todo está listo, espero que lo encuentre simple.
Lea React Boilerplate [React + Babel + Webpack] en línea:
https://riptutorial.com/es/reactjs/topic/5969/react-boilerplate--react-plus-babel-plus-webpack-
https://riptutorial.com/es/home 94

-- 104 of 139 --