# módulo d: el cargador que nos gustaría usar para cargar el archivo en el paquete web y dejar que

el cargador se encargue de la agrupación de ese tipo de archivo. También hay una propiedad de
query en el javascript, esto solo proporciona una cadena de consulta al cargador, por lo que
probablemente podríamos haber usado una propiedad de consulta en el cargador html también si
quisiéramos. Es solo una forma diferente de hacer las cosas.
Examples
Cómo construir una tubería para un "Hola mundo" personalizado con
imágenes.
Paso 1: Instala Node.js
La canalización de compilación que construirá se basa en Node.js, por lo que debe asegurarse en
primer lugar de que tenga esto instalado. Para obtener instrucciones sobre cómo instalar Node.js,
puede consultar los documentos SO para eso aquí
Paso 2: Inicializa tu proyecto como un módulo de nodo
Abra su carpeta de proyectos en la línea de comandos y use el siguiente comando:
npm init
Para los propósitos de este ejemplo, puede sentirse libre de tomar los valores predeterminados o
si desea obtener más información sobre lo que significa todo esto, puede consultar este
documento SO sobre la configuración de paquetes.
Paso 3: Instalar los paquetes npm necesarios
Ejecute el siguiente comando en la línea de comandos para instalar los paquetes necesarios para
este ejemplo:
npm install --save react react-dom
Luego, para las dependencias de desarrollo, ejecute este comando:
https://riptutorial.com/es/home 23

-- 33 of 139 --

npm install --save-dev babel-core babel-preset-react babel-preset-es2015 webpack babel-loader
css-loader style-loader file-loader image-webpack-loader
Finalmente, webpack y webpack-dev-server son cosas que vale la pena instalar globalmente en
lugar de como una dependencia de su proyecto. Si prefiere agregarlo como una dependencia, eso
funcionará, no lo hago. Aquí está el comando para ejecutar:
npm install --global webpack webpack-dev-server
Paso 3: Agregue un archivo .babelrc a la raíz de su proyecto
Esto configurará babel para usar los ajustes preestablecidos que acabas de instalar. Su archivo
.babelrc debería verse así:
{
"presets": ["react", "es2015"]
}
Paso 4: Configurar la estructura de directorios del proyecto
Establézcase una estructura de directorio que se vea como la siguiente en la raíz de su directorio:
|- node_modules
|- src/
|- components/
|- images/
|- styles/
|- index.html
|- index.jsx
|- .babelrc
|- package.json
NOTA: Los node_modules , .babelrc y package.json deberían haber estado allí desde los pasos
anteriores, simplemente los .babelrc para que pueda ver dónde encajan.
Paso 5: rellenar el proyecto con los archivos del proyecto Hello World
Esto no es realmente importante para el proceso de construcción de una tubería, así que solo le
daré el código para que pueda copiarlos y pegarlos en:
src / components / HelloWorldComponent.jsx
import React, { Component } from 'react';
class HelloWorldComponent extends Component {
constructor(props) {
super(props);
this.state = {name: 'Student'};
this.handleChange = this.handleChange.bind(this);
}
handleChange(e) {
this.setState({name: e.target.value});
https://riptutorial.com/es/home 24

-- 34 of 139 --

}
render() {
return (
<div>
<div className="image-container">
<img src="./images/myImage.gif" />
</div>
<div className="form">
<input type="text" onChange={this.handleChange} />
<div>
My name is {this.state.name} and I'm a clever cloggs because I built a React build
pipeline
</div>
</div>
</div>
);
}
}
export default HelloWorldComponent;
src / images / myImage.gif
Siéntase libre de sustituir esto con cualquier imagen que le gustaría, simplemente está ahí para
demostrar el punto en el que podemos agrupar las imágenes también. Si proporciona su propia
imagen y le da un nombre diferente, tendrá que actualizar HelloWorldComponent.jsx para reflejar
sus cambios. Del mismo modo, si elige una imagen con una extensión de archivo diferente,
deberá modificar la propiedad de test del cargador de imágenes en webpack.config.js con la
expresión regular correspondiente para que coincida con su nueva extensión de archivo.
src / styles / styles.css
.form {
margin: 25px;
padding: 25px;
border: 1px solid #ddd;
background-color: #eaeaea;
border-radius: 10px;
}
.form div {
padding-top: 25px;
}
.image-container {
display: flex;
justify-content: center;
}
index.html
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
https://riptutorial.com/es/home 25

-- 35 of 139 --

<title>Learning to build a react pipeline</title>
</head>
<body>
<div id="content"></div>
<script src="app.js"></script>
</body>
</html>
index.jsx
import React from 'react';
import { render } from 'react-dom';
import HelloWorldComponent from './components/HelloWorldComponent.jsx';
require('./images/myImage.gif');
require('./styles/styles.css');
require('./index.html');
render(<HelloWorldComponent />, document.getElementById('content'));
Paso 6: Crear la configuración del webpack
Cree un archivo llamado webpack.config.js en la raíz de su proyecto y copie este código en él:
webpack.config.js
var path = require('path');
var config = {
context: path.resolve(__dirname + '/src'),
entry: './index.jsx',
output: {
filename: 'app.js',
path: path.resolve(__dirname + '/dist'),
},
devServer: {
contentBase: path.join(__dirname + '/dist'),
port: 3000,
open: true,
},
module: {
loaders: [
{
test: /\.(js|jsx)$/,
exclude: /node_modules/,
loader: 'babel-loader'
},
{
test: /\.css$/,
loader: "style!css"
},
{
test: /\.gif$/,
loaders: [
'file?name=[path][name].[ext]',
'image-webpack',
]
},
https://riptutorial.com/es/home 26

-- 36 of 139 --

{ test: /\.(html)$/,
loader: "file?name=[path][name].[ext]"
}
],
},
};
module.exports = config;
Paso 7: Crea tareas npm para tu pipeline
Para hacer esto, deberá agregar dos propiedades a la clave de scripts de JSON definida en el
archivo package.json en la raíz de su proyecto. Haz que la clave de tus scripts se vea así:
"scripts": {
"start": "webpack-dev-server",
"build": "webpack",
"test": "echo \"Error: no test specified\" && exit 1"
},
El guión de test ya habrá estado allí y puede elegir si desea mantenerlo o no, no es importante
para este ejemplo.
Paso 8: utilizar la tubería
Desde la línea de comandos, si se encuentra en el directorio raíz del proyecto, ahora debería
poder ejecutar el comando:
npm run build
Esto agrupará la pequeña aplicación que ha creado y la colocará en el directorio dist/ que creará
en la raíz de la carpeta de su proyecto.
Si ejecuta el comando:
npm start
Luego, la aplicación que haya creado se servirá en su navegador web predeterminado dentro de
una instancia de servidor webpack dev.
Lea Cómo configurar un webpack básico, reaccionar y babel. en línea:
https://riptutorial.com/es/reactjs/topic/6294/como-configurar-un-webpack-basico--reaccionar-y-
babel-
https://riptutorial.com/es/home 27

-- 37 of 139 --