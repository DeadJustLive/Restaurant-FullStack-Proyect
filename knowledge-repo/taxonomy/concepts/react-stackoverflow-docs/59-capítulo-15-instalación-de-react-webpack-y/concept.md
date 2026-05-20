# Capítulo 15:: Instalación de React, Webpack y

## Fuente
react-stackoverflow-docs (Cap. 59)

## Contenido
# Capítulo 15:: Instalación de React, Webpack y

Typescript.
Observaciones
Para obtener el resaltado de sintaxis en su editor (por ejemplo, VS Code), deberá descargar la
información de escritura para los módulos que utiliza en su proyecto.
Digamos, por ejemplo, que utiliza React y ReactDOM en su proyecto, y desea obtener resaltado e
Intellisense para ellos. Deberá agregar los tipos a su proyecto usando este comando:
npm install --save @types/react @types/react-dom
Su editor ahora debe seleccionar automáticamente esta información de escritura y proporcionarle
autocompletado e Intellisense para estos módulos.
Examples
webpack.config.js
module.exports = {
entry: './src/index',
output: {
path: __dirname + '/build',
filename: 'bundle.js'
},
module: {
rules: [{
test: /\.tsx?$/,
loader: 'ts-loader',
exclude: /node_modules/
}]
},
resolve: {
extensions: ['.ts', '.tsx']
}
};
Los componentes principales son (además de la entry estándar, la output y otras propiedades del
paquete web):
El cargador
Para esto necesita crear una regla que pruebe las extensiones de archivo .ts y .tsx , especifique
ts-loader como el cargador.
https://riptutorial.com/es/home 70

-- 80 of 139 --

Resolver las extensiones TS
También debe agregar las .ts y .tsx en la matriz de resolve , o el paquete web no las verá.
tsconfig.json
Este es un tsconfig mínimo para ponerlo en marcha.
{
"include": [
"src/*"
],
"compilerOptions": {
"target": "es5",
"jsx": "react",
"allowSyntheticDefaultImports": true
}
}
Vamos a ver las propiedades una por una:
include
Esta es una matriz de código fuente. Aquí solo tenemos una entrada, src/* , que especifica que
todo en el directorio src debe incluirse en la compilación.
compilerOptions.target
Especifica que queremos compilar a ES5 target.
compilerOptions.jsx
Establecer esto en true hará que TypeScript compile automáticamente su sintaxis tsx desde <div
/> a React.createElement("div") .
compilerOptions.allowSyntheticDefaultImports
Propiedad práctica que le permitirá importar módulos de nodo como si fueran módulos ES6, así
que en lugar de hacerlo
import * as React from 'react'
const { Component } = React
solo puedes hacer
import React, { Component } from 'react'
sin ningún error que le indique que React no tiene una exportación predeterminada.
https://riptutorial.com/es/home 71

-- 81 of 139 --

Mi primer componente
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
interface AppProps {
name: string;
}
interface AppState {
words: string[];
}
class App extends Component<AppProps, AppState> {
constructor() {
super();
this.state = {
words: ['foo', 'bar']
};
}
render() {
const { name } = this.props;
return (<h1>Hello {name}!</h1>);
}
}
const root = document.getElementById('root');
ReactDOM.render(<App name="Foo Bar" />, root);
Cuando use TypeScript con React, una vez que haya descargado las definiciones de tipo React
DefinitelyTyped ( npm install --save @types/react ), cada componente requerirá que agregue
anotaciones de tipo.
Haces esto así
class App extends Component<AppProps, AppState> { }
donde AppProps y AppState son interfaces (o alias de tipo) para las AppProps y el AppState de sus
componentes, respectivamente.
Lea Instalación de React, Webpack y Typescript. en línea:
https://riptutorial.com/es/reactjs/topic/9590/instalacion-de-react--webpack-y-typescript-
https://riptutorial.com/es/home 72

-- 82 of 139 --
