# módulo d: e carga para usar con el paquete web. También instalamos los ajustes preestablecidos

## Fuente
react-stackoverflow-docs (Cap. 58)

## Contenido
# módulo d: e carga para usar con el paquete web. También instalamos los ajustes preestablecidos

de es6 y reactivos para que Babel entienda el código de módulo JSX y es6. (Puede encontrar
más información acerca de los ajustes preestablecidos aquí presets de Babel )
$npm i -D webpack
Este comando instalará webpack como una dependencia de desarrollo. ( i es la abreviatura para
instalar y -D la abreviatura para --save-dev)
Es posible que también desee instalar cualquier paquete webpack adicional (como cargadores
adicionales o la extensión webpack-dev-server)
Por último necesitaremos el código de reacción real.
$npm i -D react react-dom
Configuración de webpack
https://riptutorial.com/es/home 66

-- 76 of 139 --

Con la configuración de dependencias necesitaremos un archivo webpack.config.js para decirle a
webpack qué hacer
simple webpack.config.js:
var path = require('path');
module.exports = {
entry: './src/index.js',
output: {
path: path.resolve(__dirname, 'out'),
filename: 'bundle.js'
},
module: {
loaders: [
{
test: /\.js$/,
exclude: /(node_modules)/,
loader: 'babel-loader',
query: {
presets: ['es2015', 'react']
}
}
]
}
};
Este archivo le dice a webpack que comience con el archivo index.js (se supone que está en src /)
y lo convierte en un solo archivo bundle.js en el directorio out .
El bloque de module le dice a webpack que pruebe todos los archivos encontrados en la expresión
regular y, si coinciden, invocará el cargador especificado. ( babel-loader en este caso) Además,
exclude regex le dice a webpack que ignore este cargador especial para todos los módulos en la
carpeta node_modules , esto ayuda a acelerar el proceso de transpilación. Por último, la opción de
query le dice a webpack qué parámetros pasar a babel y se usa para transmitir los ajustes
preestablecidos que instalamos anteriormente.
Probando la configuración
Todo lo que queda ahora es crear el archivo src/index.js e intentar empaquetar la aplicación
src / index.js:
'use strict'
import React from 'react'
import { render } from 'react-dom'
const App = () => {
return <h1>Hello world!</h1>
}
render(
https://riptutorial.com/es/home 67

-- 77 of 139 --

<App />,
document. getElementById('app')
)
Normalmente, este archivo representará un simple <h1>Hello world!</h1> Encabezado en la
etiqueta html con el id 'app', pero por ahora debería ser suficiente para recopilar el código una
vez.
$./node_modules/.bin/webpack . Ejecutará la versión localmente instalada de webpack (use
$webpack si instaló webpack globalmente con -g)
Esto debería crear el archivo out/bundle.js con el código transpilado dentro y concluir el ejemplo.
Utilizando webpack-dev-server
Preparar
Después de configurar un proyecto simple para usar webpack, babel y reaccionan emitiendo $npm
i -g webpack-dev-server instalará el servidor http de desarrollo para un desarrollo más rápido.
Modificando webpack.config.js
var path = require('path');
module.exports = {
entry: './src/index.js',
output: {
path: path.resolve(__dirname, 'out'),
publicPath: '/public/',
filename: 'bundle.js'
},
module: {
loaders: [
{
test: /\.js$/,
exclude: /(node_modules)/,
loader: 'babel',
query: {
presets: ['es2015', 'react']
}
}
]
},
devServer: {
contentBase: path.resolve(__dirname, 'public'),
hot: true
}
};
Las modificaciones estan en
https://riptutorial.com/es/home 68

-- 78 of 139 --

output.publicPath que configura una ruta desde la cual se sirve nuestro paquete (consulte
los archivos de configuración del paquete web para obtener más información)
•
devServer
contentBase la ruta base para servir archivos estáticos (por ejemplo, index.html )	○
hot conjuntos del webpack-dev-servidor para recargar caliente cuando se hacen los
cambios a los archivos en el disco
○
•
Y, finalmente, solo necesitamos un index.html simple para probar nuestra aplicación.
index.html:
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>React Sandbox</title>
</head>
<body>
<div id="app" />
<script src="public/bundle.js"></script>
</body>
</html>
Con esta configuración ejecutando $webpack-dev-server debe iniciar un servidor http local en el
puerto 8080 y al conectarse debe mostrar una página que contenga un <h1>Hello world!</h1> .
Lea Instalación en línea: https://riptutorial.com/es/reactjs/topic/6441/instalacion
https://riptutorial.com/es/home 69

-- 79 of 139 --
