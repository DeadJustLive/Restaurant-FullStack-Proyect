# Capítulo 25:: React.createClass vs extiende

## Fuente
react-stackoverflow-docs (Cap. 69)

## Contenido
# Capítulo 25:: React.createClass vs extiende

React.Component
Sintaxis
Caso 1: React.createClass ({})	•
Caso 2: la clase MyComponent extiende React.Component {}	•
Observaciones
React.createClass quedó en desuso en v15.5 y se espera que se elimine en v16 . Hay un paquete
de reemplazo para aquellos que todavía lo requieren. Los ejemplos que lo usan deben ser
actualizados.
Examples
Crear Componente React
Exploremos las diferencias de sintaxis comparando dos ejemplos de código.
React.createClass (en desuso)
Aquí tenemos una const con una clase React asignada, con la función de render continuación para
completar una definición de componente base típica.
import React from 'react';
const MyComponent = React.createClass({
render() {
return (
<div></div>
);
}
});
export default MyComponent;
React.Component
Tomemos la definición anterior de React.createClass y la convertimos para usar una clase ES6.
import React from 'react';
https://riptutorial.com/es/home 103

-- 113 of 139 --

class MyComponent extends React.Component {
render() {
return (
<div></div>
);
}
}
export default MyComponent;
En este ejemplo ahora estamos usando clases de ES6. Para los cambios de React, ahora
creamos una clase llamada MyComponent y la extendemos desde React.Component en lugar de
acceder a React.createClass directamente. De esta manera, usamos menos repetitivo y más
JavaScript.
PS: Normalmente, esto se usaría con algo como Babel para compilar el ES6 a ES5 para que
funcione en otros navegadores.
Declare Props y PropTypes por defecto
Hay cambios importantes en la forma en que usamos y declaramos los accesorios
predeterminados y sus tipos.
React.createClass
En esta versión, la propiedad propTypes es un Objeto en el que podemos declarar el tipo para cada
prop. La propiedad getDefaultProps es una función que devuelve un objeto para crear los
accesorios iniciales.
import React from 'react';
const MyComponent = React.createClass({
propTypes: {
name: React.PropTypes.string,
position: React.PropTypes.number
},
getDefaultProps() {
return {
name: 'Home',
position: 1
};
},
render() {
return (
<div></div>
);
}
});
export default MyComponent;
https://riptutorial.com/es/home 104

-- 114 of 139 --

React.Component
Esta versión utiliza propTypes como una propiedad en la clase MyComponent real en lugar de una
propiedad como parte del objeto de definición createClass .
getDefaultProps ahora ha cambiado a solo una propiedad Object en la clase llamada defaultProps,
ya que ya no es una función "obtener", es solo un objeto. Evita más repeticiones de React, esto
es simplemente JavaScript.
import React from 'react';
class MyComponent extends React.Component {
constructor(props) {
super(props);
}
render() {
return (
<div></div>
);
}
}
MyComponent.propTypes = {
name: React.PropTypes.string,
position: React.PropTypes.number
};
MyComponent.defaultProps = {
name: 'Home',
position: 1
};
export default MyComponent;
Además, hay otra sintaxis para propTypes y defaultProps . Este es un acceso directo si su
compilación tiene activados los inicializadores de propiedades de ES7:
import React from 'react';
class MyComponent extends React.Component {
static propTypes = {
name: React.PropTypes.string,
position: React.PropTypes.number
};
static defaultProps = {
name: 'Home',
position: 1
};
constructor(props) {
super(props);
}
render() {
return (
<div></div>
);
}
}
https://riptutorial.com/es/home 105

-- 115 of 139 --

export default MyComponent;
Establecer estado inicial
Hay cambios en cómo estamos estableciendo los estados iniciales.
React.createClass
Tenemos una función getInitialState , que simplemente devuelve un objeto de estados iniciales.
import React from 'react';
const MyComponent = React.createClass({
getInitialState () {
return {
activePage: 1
};
},
render() {
return (
<div></div>
);
}
});
export default MyComponent;
React.Component
En esta versión, declaramos todo el estado como una propiedad de inicialización simple en el
constructor , en lugar de usar la función getInitialState . Se siente menos impulsado por "React
API" ya que esto es simplemente JavaScript.
import React from 'react';
class MyComponent extends React.Component {
constructor(props) {
super(props);
this.state = {
activePage: 1
};
}
render() {
return (
<div></div>
);
}
}
export default MyComponent;
https://riptutorial.com/es/home 106

-- 116 of 139 --

Mixins
Podemos usar mixins solo con la forma React.createClass.
React.createClass
En esta versión, podemos agregar mixins a los componentes utilizando la propiedad mixins que
toma una matriz de mixins disponibles. Estos luego extienden la clase de componente.
import React from 'react';
var MyMixin = {
doSomething() {
}
};
const MyComponent = React.createClass({
mixins: [MyMixin],
handleClick() {
this.doSomething(); // invoke mixin's method
},
render() {
return (
<button onClick={this.handleClick}>Do Something</button>
);
}
});
export default MyComponent;
React.Component
Los mixins de React no son compatibles cuando se usan componentes React escritos en 
