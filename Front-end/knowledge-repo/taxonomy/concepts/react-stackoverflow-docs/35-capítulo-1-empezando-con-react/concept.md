# Capítulo 1:: Empezando con React

## Fuente
react-stackoverflow-docs (Cap. 35)

## Contenido
# Capítulo 1:: Empezando con React

Observaciones
React es una biblioteca declarativa de JavaScript basada en componentes que se utiliza para
crear interfaces de usuario.
Para lograr las funcionalidades de MVC framework en React, los desarrolladores lo utilizan junto
con el sabor de Flux de su elección, por ejemplo, Redux .
Versiones
Versión Fecha de lanzamiento
0.3.0 2013-05-29
0.4.0 2013-07-17
0.5.0 2013-10-16
0.8.0 2013-12-19
0.9.0 2014-02-20
0.10.0 2014-03-21
0.11.0 2014-07-17
0.12.0 2014-10-28
0.13.0 2015-03-10
0.14.0 2015-10-07
15.0.0 2016-04-07
15.1.0 2016-05-20
15.2.0 2016-07-01
15.2.1 2016-07-08
15.3.0 2016-07-29
15.3.1 2016-08-19
15.3.2 2016-09-19
https://riptutorial.com/es/home 2

-- 12 of 139 --

Versión Fecha de lanzamiento
15.4.0 2016-11-16
15.4.1 2016-11-23
15.4.2 2017-01-06
15.5.0 2017-04-07
15.6.0 2017-06-13
Examples
Instalación o configuración
ReactJS es una biblioteca de JavaScript contenida en un solo archivo react-<version>.js que se
puede incluir en cualquier página HTML. La gente también suele instalar la biblioteca React DOM
react-dom-<version>.js junto con el archivo principal React:
Inclusión básica
<!DOCTYPE html>
<html>
<head></head>
<body>
<script type="text/javascript" src="/path/to/react.js"></script>
<script type="text/javascript" src="/path/to/react-dom.js"></script>
<script type="text/javascript">
// Use react JavaScript code here or in a separate file
</script>
</body>
</html>
Para obtener los archivos JavaScript, vaya a la página de instalación de la documentación oficial
de React.
React también soporta la sintaxis JSX . JSX es una extensión creada por Facebook que agrega
sintaxis XML a JavaScript. Para utilizar JSX, debe incluir la biblioteca de Babel y cambiar <script
type="text/javascript"> a <script type="text/babel"> para traducir JSX al código Javascript.
<!DOCTYPE html>
<html>
<head></head>
<body>
<script type="text/javascript" src="/path/to/react.js"></script>
<script type="text/javascript" src="/path/to/react-dom.js"></script>
<script src="https://npmcdn.com/babel-core@5.8.38/browser.min.js"></script>
<script type="text/babel">
// Use react JSX code here or in a separate file
</script>
</body>
https://riptutorial.com/es/home 3

-- 13 of 139 --

</html>
Instalación a través de npm
También puede instalar React usando npm haciendo lo siguiente:
npm install --save react react-dom
Para usar React en su proyecto de JavaScript, puede hacer lo siguiente:
var React = require('react');
var ReactDOM = require('react-dom');
ReactDOM.render(<App />, ...);
Instalación a través de hilo
Facebook lanzó su propio administrador de paquetes llamado Yarn , que también se puede usar
para instalar React. Después de instalar Yarn solo necesitas ejecutar este comando:
yarn add react react-dom
Luego puede usar React en su proyecto exactamente de la misma manera que si hubiera
instalado React a través de npm.
Hola componente mundial
Un componente React se puede definir como una clase ES6 que extiende la clase React.Component
base. En su forma mínima, un componente debe definir un método de render que especifique
cómo se procesa el componente en el DOM. El método de render devuelve los nodos React, que
pueden definirse utilizando la sintaxis JSX como etiquetas similares a HTML. El siguiente ejemplo
muestra cómo definir un componente mínimo:
import React from 'react'
class HelloWorld extends React.Component {
render() {
return <h1>Hello, World!</h1>
}
}
export default HelloWorld
Un componente también puede recibir props . Estas son propiedades pasadas por su padre para
especificar algunos valores que el componente no puede conocer por sí mismo; una propiedad
también puede contener una función a la que el componente puede llamar después de que se
produzcan ciertos eventos; por ejemplo, un botón podría recibir una función para su propiedad
onClick y llamarla cada vez que se haga clic en ella. Al escribir un componente, se puede acceder
a sus props a través del objeto props en el propio Componente:
import React from 'react'
https://riptutorial.com/es/home 4

-- 14 of 139 --

class Hello extends React.Component {
render() {
return <h1>Hello, {this.props.name}!</h1>
}
}
export default Hello
El ejemplo anterior muestra cómo el componente puede representar una cadena arbitraria pasada
a la propiedad de name por su padre. Tenga en cuenta que un componente no puede modificar los
accesorios que recibe.
Un componente puede representarse dentro de cualquier otro componente, o directamente en el
DOM si es el componente más alto, usando ReactDOM.render y proporcionándole tanto el
componente como el nodo DOM donde desea que se represente el árbol React:
import React from 'react'
import ReactDOM from 'react-dom'
import Hello from './Hello'
ReactDOM.render(<Hello name="Billy James" />, document.getElementById('main'))
A estas alturas ya sabes cómo hacer un componente básico y aceptar props . Vamos a llevar esto
un paso más allá e introducir el state .
Para la demostración, hagamos nuestra aplicación Hello Wo
