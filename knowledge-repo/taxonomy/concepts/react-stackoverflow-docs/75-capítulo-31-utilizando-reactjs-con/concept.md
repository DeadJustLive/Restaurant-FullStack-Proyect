# Capítulo 31:: Utilizando ReactJS con

## Fuente
react-stackoverflow-docs (Cap. 75)

## Contenido
# Capítulo 31:: Utilizando ReactJS con

Typescript
Examples
Componente ReactJS escrito en Typescript
En realidad, puedes usar los componentes de ReactJS en Typescript como en el ejemplo de
facebook. Simplemente reemplaza la extensión del archivo 'jsx' a 'tsx':
//helloMessage.tsx:
var HelloMessage = React.createClass({
render: function() {
return <div>Hello {this.props.name}</div>;
}
});
ReactDOM.render(<HelloMessage name="John" />, mountNode);
Pero para hacer un uso completo de la característica principal de Typescript (verificación de tipos
estática) se debe hacer un par de cosas:
1) convertir el ejemplo de React.createClass a ES6 Class:
//helloMessage.tsx:
class HelloMessage extends React.Component {
render() {
return <div>Hello {this.props.name}</div>;
}
}
ReactDOM.render(<HelloMessage name="John" />, mountNode);
2) a continuación agregue Props y interfaces de estado:
interface IHelloMessageProps {
name:string;
}
interface IHelloMessageState {
//empty in our case
}
class HelloMessage extends React.Component<IHelloMessageProps, IHelloMessageState> {
constructor(){
super();
}
render() {
return <div>Hello {this.props.name}</div>;
}
}
ReactDOM.render(<HelloMessage name="Sebastian" />, mountNode);
https://riptutorial.com/es/home 123

-- 133 of 139 --

Ahora Typescript mostrará un error si el programador se olvida de aprobar las propuestas. O si
añadieron accesorios que no están definidos en la interfaz.
Componentes de Stateless React en Typescript
Los componentes de React que son funciones puras de sus propiedades y no requieren ningún
estado interno se pueden escribir como funciones de JavaScript en lugar de usar la sintaxis de
clase estándar, como:
import React from 'react'
const HelloWorld = (props) => (
<h1>Hello, {props.name}!</h1>
);
Lo mismo se puede lograr en Typescript usando la clase React.SFC :
import * as React from 'react';
class GreeterProps {
name: string
}
const Greeter : React.SFC<GreeterProps> = props =>
<h1>Hello, {props.name}!</h1>;
Tenga en cuenta que, el nombre React.SFC es un alias para React.StatelessComponent Por
React.StatelessComponent tanto, cualquiera de los dos puede usarse.
Instalación y configuración
Para usar mecanografiado con reacción en un proyecto de nodo, primero debe tener un directorio
de proyecto inicializado con npm. Inicializar el directorio con npm init
Instalación vía npm o hilo
Puedes instalar React usando npm haciendo lo siguiente:
npm install --save react react-dom
Facebook lanzó su propio administrador de paquetes llamado Yarn , que también se puede usar
para instalar React. Después de instalar Yarn solo necesitas ejecutar este comando:
yarn add react react-dom
Luego puede usar React en su proyecto exactamente de la misma manera que si hubiera
instalado React a través de npm.
Instalando definiciones de tipo de reacción en Typescript 2.0+
https://riptutorial.com/es/home 124

-- 134 of 139 --

Para compilar su código usando mecanografia, agregue / instale archivos de definición de tipo
usando npm o hilados.
npm install --save-dev @types/react @types/react-dom
o, usando hilo
yarn add --dev @types/react @types/react-dom
Instalar definiciones de tipo de reacción en versiones anteriores de Typescript
Tienes que usar un paquete separado llamado tsd
tsd install react react-dom --save
Agregando o cambiando la configuración de Typescript
Para usar JSX , un lenguaje que mezcla javascript con html / xml, debe cambiar la configuración
del compilador de caracteres. En el archivo de configuración de tsconfig.json del proyecto
(normalmente denominado tsconfig.json ), deberá agregar la opción JSX como:
"compilerOptions": {
"jsx": "react"
},
Esa opción del compilador básicamente le dice al compilador mecanografiado que traduzca las
etiquetas JSX en código a las llamadas de función javascript.
Para evitar que el compilador mecanografiado convierta JSX a llamadas de funciones de
JavaScript simples, use
"compilerOptions": {
"jsx": "preserve"
},
Componentes sin estado y sin propiedad
El componente de reacción más simple sin un estado y sin propiedades se puede escribir como:
import * as React from 'react';
const Greeter = () => <span>Hello, World!</span>
Ese componente, sin embargo, no puede acceder a this.props ya que mecanografiado no puede
saber si es un componente de reacción. Para acceder a sus accesorios, utiliza:
import * as React from 'react';
const Greeter: React.SFC<{}> = props => () => <span>Hello, World!</span>
https://riptutorial.com/es/home 125

-- 135 of 139 --

Incluso si el componente no tiene propiedades explícitamente definidas, ahora puede acceder a
props.children ya que todos los componentes tienen hijos de forma inherente.
Otro buen uso similar de los componentes sin estado y sin propiedades se encuentra en la
plantilla de página simple. El siguiente es un componente simple de la Page ejemplos, asumiendo
que hay componentes hipotéticos de Container , NavTop y NavBottom ya en el proyecto:
import * as React from 'react';
const Page: React.SFC<{}> = props => () =>
