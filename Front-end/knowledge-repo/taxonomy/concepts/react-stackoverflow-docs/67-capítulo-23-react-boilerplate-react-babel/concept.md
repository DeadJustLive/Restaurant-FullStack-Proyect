# Capítulo 23:: React Boilerplate [React + Babel

## Fuente
react-stackoverflow-docs (Cap. 67)

## Contenido
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
node_modules de nuestras dependencias. Ahora en la r
