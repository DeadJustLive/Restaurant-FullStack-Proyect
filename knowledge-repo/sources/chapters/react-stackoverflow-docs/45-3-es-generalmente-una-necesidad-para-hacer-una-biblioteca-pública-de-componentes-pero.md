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
super();
this.state = {
user: {},
xhr: null
https://riptutorial.com/es/home 37

-- 47 of 139 --

};
}
componentWillUnmount() {
let xhr = this.state.xhr;
// Cancel the xhr request, so the callback is never called
if (xhr && xhr.readyState != 4) {
xhr.abort();
}
}
componentDidMount() {
this.fetchUser();
}
fetchUser() {
let xhr = $.get('/api/users/self')
.then((user) => {
this.setState({user: user});
});
this.setState({xhr: xhr});
}
}
El método asíncrono se guarda como un estado. En el componentWillUnmount , realiza toda la
limpieza, incluida la cancelación de la solicitud XHR.
También podrías hacer algo más complejo. En este ejemplo, estoy creando una función
'stateSetter' que acepta el objeto de este como un argumento y evita este this.setState cuando
se ha llamado a la función cancel :
function stateSetter(context) {
var cancelled = false;
return {
cancel: function () {
cancelled = true;
},
setState(newState) {
if (!cancelled) {
context.setState(newState);
}
}
}
}
class Component extends React.Component {
constructor(props) {
super(props);
this.setter = stateSetter(this);
this.state = {
user: 'loading'
};
}
componentWillUnmount() {
this.setter.cancel();
}
componentDidMount() {
https://riptutorial.com/es/home 38

-- 48 of 139 --

this.fetchUser();
}
fetchUser() {
$.get('/api/users/self')
.then((user) => {
this.setter.setState({user: user});
});
}
render() {
return <h1>{this.state.user}</h1>
}
}
Esto funciona porque la variable cancelled es visible en el cierre de setState que creamos.
Accesorios
Los apoyos son una forma de pasar información a un componente React, pueden tener cualquier
tipo, incluidas funciones, a veces denominadas devoluciones de llamada.
En JSX los props se pasan con la sintaxis del atributo.
<MyComponent userID={123} />
Dentro de la definición de MyComponent userID ahora será accesible desde el objeto props
// The render function inside MyComponent
render() {
return (
<span>The user's ID is {this.props.userID}</span>
)
}
Es importante definir todos los props , sus tipos y, cuando corresponda, su valor predeterminado:
// defined at the bottom of MyComponent
MyComponent.propTypes = {
someObject: React.PropTypes.object,
userID: React.PropTypes.number.isRequired,
title: React.PropTypes.string
};
MyComponent.defaultProps = {
someObject: {},
title: 'My Default Title'
}
En este ejemplo, el prop someObject es opcional, pero se requiere el prop userID . Si usted no
proporciona userID a MyComponent , en tiempo de ejecución del motor Reaccionar mostrará una
consola que le advierte que no se proporcionó la hélice requerida. Sin embargo, tenga cuidado,
esta advertencia solo se muestra en la versión de desarrollo de la biblioteca React, la versión de
producción no registrará ninguna advertencia.
https://riptutorial.com/es/home 39

-- 49 of 139 --

Usando defaultProps te permite simplificar
const { title = 'My Default Title' } = this.props;
console.log(title);
a
console.log(this.props.title);
También es una garantía para el uso de la array de object y functions . Si no proporciona un prop
predeterminado para un objeto, lo siguiente arrojará un error si no se pasa el prop:
if (this.props.someObject.someKey)
En el ejemplo anterior, this.props.someObject undefined está undefined y, por lo tanto, la
comprobación de someKey generará un error y el código se interrumpirá. Con el uso de defaultProps
puede usar de forma segura la verificación anterior.
Estados del componente - Interfaz de usuario dinámica
Supongamos que queremos tener el siguiente comportamiento: tenemos un encabezado (por
ejemplo, elemento h3) y al hacer clic en él, queremos que se convierta en un cuadro de entrada
para que podamos modificar el nombre del encabezado. React hace esto altamente simple e
intuitivo utilizando estados de componentes y, si no, declaraciones. (Explicación del código abajo)
// I have used ReactBootstrap elements. But the code works with regular html elements also
var Button = ReactBootstrap.Button;
var Form = ReactBootstrap.Form;
var FormGroup = ReactBootstrap.FormGroup;
var FormControl = ReactBootstrap.FormControl;
var Comment = reactCreateClass({
getInitialState: function() {
return {show: false, newTitle: ''};
},
handleTitleSubmit: function() {
//code to handle input box submit - for example, issue an ajax request to change name in
database
},
handleTitleChange: function(e) {
//code to change the name in form input box. newTitle is initialized as empty string. We
need to update it with the string currently entered by user in the form
this.setState({newTitle: e.target.value});
},
changeComponent: function() {
// this toggles the show variable which is used for dynamic UI
this.setState({show: !this.state.show)};
},
render: function() {
https://riptutorial.com/es/home 40

-- 50 of 139 --

var clickableTitle;
if(this.state.show) {
clickableTitle = <Form inline onSubmit={this.handleTitleSubmit}>
<FormGroup controlId="formInlineTitle">
<FormControl type="text" onChange={this.handleTitleChange}>
</FormGroup>
</Form>;
} else {
clickabletitle = <div>
<Button bsStyle="link" onClick={this.changeComponent}>
<h3> Default Text </h3>
</Button>
</div>;
}
return (
<div className="comment">
{clickableTitle}
</div>
);
}
});
ReactDOM.render(
<Comment />, document.getElementById('content')
);
La parte principal del código es la variable clickableTitle . En función de la demostración de
variable de estado, puede ser un elemento de formulario o un elemento de botón. React permite
el anidamiento de componentes.
Entonces podemos agregar un elemento {clickableTitle} en la función de render. Busca la variable
clickableTitle. Basado en el valor 'this.state.show', muestra el elemento correspondiente.
Variaciones de los componentes funcionales sin estado
const languages = [
'JavaScript',
'Python',
'Java',
'Elm',
'TypeScript',
'C#',
'F#'
]
// one liner
const Language = ({language}) => <li>{language}</li>
Language.propTypes = {
message: React.PropTypes.string.isRequired
}
https://riptutorial.com/es/home 41

-- 51 of 139 --

/**
* If there are more than one line.
* Please notice that round brackets are optional here,
* However it's better to use them for readability
*/
const LanguagesList = ({languages}) => {
<ul>
{languages.map(language => <Language language={language} />)}
</ul>
}
LanguagesList.PropTypes = {
languages: React.PropTypes.array.isRequired
}
/**
* This syntax is used if there are more work beside just JSX presentation
* For instance some data manipulations needs to be done.
* Please notice that round brackets after return are required,
* Otherwise return will return nothing (undefined)
*/
const LanguageSection = ({header, languages}) => {
// do some work
const formattedLanguages = languages.map(language => language.toUpperCase())
return (
<fieldset>
<legend>{header}</legend>
<LanguagesList languages={formattedLanguages} />
</fieldset>
)
}
LanguageSection.PropTypes = {
header: React.PropTypes.string.isRequired,
languages: React.PropTypes.array.isRequired
}
ReactDOM.render(
<LanguageSection
header="Languages"
languages={languages} />,
document.getElementById('app')
)
Aquí puedes encontrar un ejemplo de ello.
Lea Componentes en línea: https://riptutorial.com/es/reactjs/topic/1185/componentes
https://riptutorial.com/es/home 42

-- 52 of 139 --