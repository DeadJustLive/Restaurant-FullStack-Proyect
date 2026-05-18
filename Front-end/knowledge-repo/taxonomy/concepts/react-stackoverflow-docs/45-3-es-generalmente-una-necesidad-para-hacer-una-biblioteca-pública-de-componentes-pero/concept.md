# 3 es generalmente una necesidad para hacer una biblioteca pública de componentes, pero

## Fuente
react-stackoverflow-docs (Cap. 45)

## Contenido
# 3 es generalmente una necesidad para hacer una biblioteca pública de componentes, pero

también es una buena práctica en general para hacer componentes compositivos y definir
claramente las características de la composición. El # 1 es el más fácil y rápido de hacer algo que
funciona, pero el # 2 y el # 3 deberían proporcionar ciertos beneficios en varios casos de uso.
Creando Componentes
Esta es una extensión del Ejemplo Básico:
Estructura basica
import React, { Component } from 'react';
import { render } from 'react-dom';
class FirstComponent extends Component {
render() {
return (
<div>
Hello, {this.props.name}! I am a FirstComponent.
</div>
);
https://riptutorial.com/es/home 34

-- 44 of 139 --

}
}
render(
<FirstComponent name={ 'User' } />,
document.getElementById('content')
);
El ejemplo anterior se llama un componente sin estado ya que no contiene el estado (en el
sentido de Reacción de la palabra).
En tal caso, a algunas personas les resulta preferible utilizar componentes funcionales sin estado,
que se basan en las funciones de flecha de ES6 .
Componentes funcionales sin estado
En muchas aplicaciones, hay componentes inteligentes que mantienen el estado pero generan
componentes simples que simplemente reciben accesorios y devuelven HTML como JSX. Los
componentes funcionales sin estado son mucho más reutilizables y tienen un impacto positivo en
el rendimiento de su aplicación.
Tienen 2 características principales:
Cuando se procesan, reciben un objeto con todos los accesorios que se transmitieron	1.
Deben devolver el JSX para ser renderizados.	2.
// When using JSX inside a module you must import React
import React from 'react';
import PropTypes from 'prop-types';
const FirstComponent = props => (
<div>
Hello, {props.name}! I am a FirstComponent.
</div>
);
//arrow components also may have props validation
FirstComponent.propTypes = {
name: PropTypes.string.isRequired,
}
// To use FirstComponent in another file it must be exposed through an export call:
export default FirstComponent;
Componentes de estado
A diferencia de los componentes 'sin estado' que se muestran arriba, los componentes 'con
estado' tienen un objeto de estado que puede actualizarse con el método setState . El estado
debe inicializarse en el constructor antes de que se pueda configurar:
https://riptutorial.com/es/home 35

-- 45 of 139 --

import React, { Component } from 'react';
class SecondComponent extends Component {
constructor(props) {
super(props);
this.state = {
toggle: true
};
// This is to bind context when passing onClick as a callback
this.onClick = this.onClick.bind(this);
}
onClick() {
this.setState((prevState, props) => ({
toggle: !prevState.toggle
}));
}
render() {
return (
<div onClick={this.onClick}>
Hello, {this.props.name}! I am a SecondComponent.
<br />
Toggle is: {this.state.toggle}
</div>
);
}
}
La extensión de un componente con PureComponent lugar de Component implementará
automáticamente el shouldComponentUpdate() ciclo de vida con una comparación superficial de
propiedades y estado. Esto mantiene su aplicación más eficaz al reducir la cantidad de renders
innecesarios que ocurren. Esto supone que sus componentes son 'Puros' y siempre generan la
misma salida con el mismo estado y entrada de propiedades.
Componentes de orden superior
Los componentes de orden superior (HOC) permiten compartir la funcionalidad de los
componentes.
import React, { Component } from 'react';
const PrintHello = ComposedComponent => class extends Component {
onClick() {
console.log('hello');
}
/* The higher order component takes another component as a parameter
and then renders it with additional props */
render() {
return <ComposedComponent {...this.props } onClick={this.onClick} />
}
}
https://riptutorial.com/es/home 36

-- 46 of 139 --

const FirstComponent = props => (
<div onClick={ props.onClick }>
Hello, {props.name}! I am a FirstComponent.
</div>
);
const ExtendedComponent = PrintHello(FirstComponent);
Los componentes de orden superior se utilizan cuando desea compartir la lógica entre varios
componentes, independientemente de qué tan diferentes se representen.
trampas setState
Debe tener cuidado al usar setState en un contexto asíncrono. Por ejemplo, puede intentar llamar
a setState en la devolución de llamada de una solicitud de obtención:
class MyClass extends React.Component {
constructor() {
super();
this.state = {
user: {}
};
}
componentDidMount() {
this.fetchUser();
}
fetchUser() {
$.get('/api/users/self')
.then((user) => {
this.setState({user: user});
});
}
render() {
return <h1>{this.state.user}</h1>;
}
}
Esto podría provocar problemas: si se llama a la devolución de llamada después de que se
desmonta el Component , entonces este this.setState no será una función. Siempre que este sea el
caso, debe tener cuidado de asegurarse de que su uso de setState sea setState .
En este ejemplo, es posible que desee cancelar la solicitud XHR cuando el componente se
desmonta:
class MyClass extends React.Component {
constructor() {
