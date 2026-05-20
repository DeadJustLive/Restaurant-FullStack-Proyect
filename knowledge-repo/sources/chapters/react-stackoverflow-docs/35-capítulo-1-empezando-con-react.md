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
Para la demostración, hagamos nuestra aplicación Hello World, muestre solo el primer nombre si
se le da un nombre completo.
import React from 'react'
class Hello extends React.Component {
constructor(props){
//Since we are extending the default constructor,
//handle default activities first.
super(props);
//Extract the first-name from the prop
let firstName = this.props.name.split(" ")[0];
//In the constructor, feel free to modify the
//state property on the current context.
this.state = {
name: firstName
}
} //Look maa, no comma required in JSX based class defs!
render() {
return <h1>Hello, {this.state.name}!</h1>
}
}
https://riptutorial.com/es/home 5

-- 15 of 139 --

export default Hello
Nota: Cada componente puede tener su propio estado o aceptar su estado principal como prop.
Codepen Enlace a Ejemplo.
Hola Mundo
Sin JSX
Este es un ejemplo básico que utiliza la API principal de React para crear un elemento React y la
API React DOM para representar el elemento React en el navegador.
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Hello React!</title>
<!-- Include the React and ReactDOM libraries -->
<script src="https://fb.me/react-15.2.1.js"></script>
<script src="https://fb.me/react-dom-15.2.1.js"></script>
</head>
<body>
<div id="example"></div>
<script type="text/javascript">
// create a React element rElement
var rElement = React.createElement('h1', null, 'Hello, world!');
// dElement is a DOM container
var dElement = document.getElementById('example');
// render the React element in the DOM container
ReactDOM.render(rElement, dElement);
</script>
</body>
</html>
Con jsx
En lugar de crear un elemento React a partir de cadenas, se puede usar JSX (una extensión de
Javascript creada por Facebook para agregar sintaxis XML a JavaScript), que permite escribir
var rElement = React.createElement('h1', null, 'Hello, world!');
como el equivalente (y más fácil de leer para alguien familiarizado con HTML)
var rElement = <h1>Hello, world!</h1>;
https://riptutorial.com/es/home 6

-- 16 of 139 --

El código que contiene JSX debe incluirse en una etiqueta <script type="text/babel"> . Todo lo
que se encuentre dentro de esta etiqueta se transformará a Javascript simple mediante la
biblioteca de Babel (que debe incluirse además de las bibliotecas React).
Así que finalmente el ejemplo anterior se convierte en:
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Hello React!</title>
<!-- Include the React and ReactDOM libraries -->
<script src="https://fb.me/react-15.2.1.js"></script>
<script src="https://fb.me/react-dom-15.2.1.js"></script>
<!-- Include the Babel library -->
<script src="https://npmcdn.com/babel-core@5.8.38/browser.min.js"></script>
</head>
<body>
<div id="example"></div>
<script type="text/babel">
// create a React element rElement using JSX
var rElement = <h1>Hello, world!</h1>;
// dElement is a DOM container
var dElement = document.getElementById('example');
// render the React element in the DOM container
ReactDOM.render(rElement, dElement);
</script>
</body>
</html>
¿Qué es ReactJS?
ReactJS es una biblioteca de front-end de código abierto, basada en componentes, responsable
solo de la capa de visualización de la aplicación. Es mantenido por Facebook.
ReactJS utiliza un mecanismo virtual basado en DOM para completar los datos (vistas) en HTML
DOM. El DOM virtual funciona rápidamente, ya que solo cambia los elementos individuales del
DOM en lugar de volver a cargar el DOM completo cada vez
Una aplicación React se compone de varios componentes , cada uno responsable de
generar una pieza pequeña y reutilizable de HTML. Los componentes se pueden
anidar dentro de otros componentes para permitir que las aplicaciones complejas se
construyan a partir de bloques de construcción simples. Un componente también
puede mantener un estado interno; por ejemplo, un componente TabList puede
almacenar una variable correspondiente a la pestaña actualmente abierta.
React nos permite escribir componentes utilizando un lenguaje específico de dominio llamado
https://riptutorial.com/es/home 7

-- 17 of 139 --

JSX. JSX nos permite escribir nuestros componentes utilizando HTML, mientras mezclamos
eventos de JavaScript. React lo convertirá internamente en un DOM virtual, y finalmente generará
nuestro HTML para nosotros.
Reaccionar " reacciona " a los cambios de estado en sus componentes de forma rápida y
automática para volver a enviar los componentes en el DOM de HTML utilizando el DOM virtual.
El DOM virtual es una representación en memoria de un DOM real. Al realizar la mayor parte del
procesamiento dentro del DOM virtual en lugar de hacerlo directamente en el DOM del
navegador, React puede actuar rápidamente y solo agregar, actualizar y eliminar componentes
que han cambiado desde que se produjo el último ciclo de procesamiento.
Hola mundo con funciones sin estado
Los componentes sin estado están obteniendo su filosofía de la programación funcional. Lo que
implica que: Una función devuelve todo el tiempo exactamente lo mismo que se le da.
Por ejemplo:
const statelessSum = (a, b) => a + b;
let a = 0;
const statefulSum = () => a++;
Como puede ver en el ejemplo anterior, statelessSum siempre devolverá los mismos valores
dados a y b. Sin embargo, la función statefulSum no devolverá los mismos valores incluso sin
parámetros. Este tipo de comportamiento de la función también se llama como efecto secundario .
Desde entonces, el componente afecta a algunas cosas más allá.
Por lo tanto, se recomienda utilizar componentes sin estado con más frecuencia, ya que no tienen
efectos secundarios y siempre crearán el mismo comportamiento. Eso es lo que quieres buscar
en tus aplicaciones porque el estado fluctuante es el peor escenario para un programa
mantenible.
El tipo más básico de componente de reacción es uno sin estado. Los componentes de React que
son funciones puras de sus propiedades y no requieren ninguna administración de estado interna
pueden escribirse como simples funciones de JavaScript. Se dice que estos son Stateless
Functional Components porque son una función solo de props , sin tener ningún state que seguir.
Aquí hay un ejemplo simple para ilustrar el concepto de un Stateless Functional Component :
// In HTML
<div id="element"></div>
// In React
const MyComponent = props => {
return <h1>Hello, {props.name}!</h1>;
};
ReactDOM.render(<MyComponent name="Arun" />, element);
https://riptutorial.com/es/home 8

-- 18 of 139 --

// Will render <h1>Hello, Arun!</h1>
Tenga en cuenta que todo lo que hace este componente es generar un elemento h1 que contenga
el name prop. Este componente no hace un seguimiento de ningún estado. Aquí hay un ejemplo de
ES6 también:
import React from 'react'
const HelloWorld = props => (
<h1>Hello, {props.name}!</h1>
)
HelloWorld.propTypes = {
name: React.PropTypes.string.isRequired
}
export default HelloWorld
Dado que estos componentes no requieren una instancia de respaldo para administrar el estado,
React tiene más espacio para las optimizaciones. La implementación está limpia, pero hasta
ahora no se han implementado tales optimizaciones para componentes sin estado .
Crear React App
create-react-app es un generador repetitivo de la aplicación React creado por Facebook.
Proporciona un entorno de desarrollo configurado para facilitar su uso con una configuración
mínima, que incluye:
Transpilación ES6 y JSX.	•
Servidor de desarrollo con recarga de modulo caliente	•
Código de línea	•
Auto-prefijo CSS	•
Crear script con JS, CSS y agrupación de imágenes, y sourcemaps	•
Marco de pruebas de broma	•
Instalación
Primero, instale la aplicación create-react-global con el administrador de paquetes de nodo (npm).
npm install -g create-react-app
Luego ejecuta el generador en tu directorio elegido.
create-react-app my-app
Navegue hasta el directorio recién creado y ejecute el script de inicio.
cd my-app/
npm start
https://riptutorial.com/es/home 9

-- 19 of 139 --

Configuración
create-react-app es intencionalmente no configurable por defecto. Si se requiere un uso no
predeterminado, por ejemplo, para usar un lenguaje CSS compilado como Sass, entonces se
puede usar el comando eject.
npm run eject
Esto permite la edición de todos los archivos de configuración. NB este es un proceso irreversible.
Alternativas
Las placas de calderas React alternativas incluyen:
enclave	•
nwb	•
movimiento	•
rackt-cli	•
budō	•
rwb	•
quik	•
Sagui	•
roc	•
Construir React App
Para construir su aplicación para producción lista, ejecute el siguiente comando
npm run build
Fundamentos absolutos de la creación de componentes reutilizables
Componentes y accesorios
Como React se ocupa solo de la vista de una aplicación, la mayor parte del desarrollo en React
será la creación de componentes. Un componente representa una parte de la vista de su
aplicación. Los "apoyos" son simplemente los atributos utilizados en un nodo JSX (por ejemplo,
<SomeComponent someProp="some prop's value" /> ), y son la principal forma en que nuestra
aplicación interactúa con nuestros componentes. En el fragmento anterior, dentro de
SomeComponent, tendríamos acceso a this.props , cuyo valor sería el objeto {someProp: "some
prop's value"} .
Puede ser útil pensar en los componentes de React como funciones simples: toman información
en forma de "accesorios" y producen resultados como marcado. Muchos componentes simples
llevan esto un paso más allá, convirtiéndose en "Funciones puras", lo que significa que no emiten
https://riptutorial.com/es/home 10

-- 20 of 139 --

efectos secundarios y son idempotentes (dado un conjunto de entradas, el componente siempre
producirá la misma salida). Este objetivo se puede cumplir formalmente creando componentes
como funciones, en lugar de "clases". Hay tres formas de crear un componente React:
Componentes funcionales ("sin estado")	•
const FirstComponent = props => (
<div>{props.content}</div>
);
React.createClass ()	•
const SecondComponent = React.createClass({
render: function () {
return (
<div>{this.props.content}</div>
);
}
});
Clases de ES2015	•
class ThirdComponent extends React.Component {
render() {
return (
<div>{this.props.content}</div>
);
}
}
Estos componentes se utilizan exactamente de la misma manera:
const ParentComponent = function (props) {
const someText = "FooBar";
return (
<FirstComponent content={someText} />
<SecondComponent content={someText} />
<ThirdComponent content={someText} />
);
}
Los ejemplos anteriores producirán un marcado idéntico.
Los componentes funcionales no pueden tener "estado" dentro de ellos. Entonces, si su
componente necesita tener un estado, entonces elija componentes basados en clases. Consulte
Crear componentes para obtener más información.
Como nota final, los accesorios de reacción son inmutables una vez que se han pasado, lo que
significa que no pueden modificarse desde un componente. Si el padre de un componente cambia
el valor de un prop, React se encarga de reemplazar los antiguos props por el nuevo, el
componente se redirigirá utilizando los nuevos valores.
https://riptutorial.com/es/home 11

-- 21 of 139 --

Vea Thinking In React y Reutilizable Components para profundizar en la relación de los
accesorios con los componentes.
Lea Empezando con React en línea: https://riptutorial.com/es/reactjs/topic/797/empezando-con-
react
https://riptutorial.com/es/home 12

-- 22 of 139 --