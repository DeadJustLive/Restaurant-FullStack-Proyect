# Capítulo 24:: React Component Lifecycle

Introducción
Los métodos de ciclo de vida deben usarse para ejecutar código e interactuar con su componente
en diferentes puntos de la vida de los componentes. Estos métodos se basan en un componente
de montaje, actualización y desmontaje.
Examples
Creación de componentes
Cuando se crea un componente React, se llama una serie de funciones:
Si está utilizando React.createClass (ES5), se llaman 5 funciones definidas por el usuario	•
Si está utilizando la class Component extends React.Component (ES6), se llaman 3 funciones
definidas por el usuario
•
getDefaultProps() (solo ES5)
Este es el primer método llamado.
Los valores de prop devueltos por esta función se utilizarán como valores predeterminados si no
se definen cuando se crea una instancia del componente.
En el siguiente ejemplo, this.props.name se predeterminará a Bob si no se especifica lo contrario:
getDefaultProps() {
return {
initialCount: 0,
name: 'Bob'
};
}
getInitialState() (solo ES5)
Este es el segundo método llamado.
El valor de retorno de getInitialState() define el estado inicial del componente React. El marco
React llamará a esta función y asignará el valor de retorno a this.state .
En el siguiente ejemplo, this.state.count se inicializará con el valor de this.props.initialCount :
getInitialState() {
https://riptutorial.com/es/home 95

-- 105 of 139 --

return {
count : this.props.initialCount
};
}
componentWillMount() (ES5 y ES6)
Este es el tercer método llamado.
Esta función se puede utilizar para realizar cambios finales en el componente antes de que se
agregue al DOM.
componentWillMount() {
...
}
render() (ES5 y ES6)
Este es el cuarto método llamado.
La función render() debe ser una función pura del estado y los elementos del componente.
Devuelve un único elemento que representa el componente durante el proceso de representación
y debe ser una representación de un componente DOM nativo (por ejemplo, <p /> ) o un
componente compuesto. Si no se debe representar nada, puede devolver null o undefined .
Esta función se recuperará después de cualquier cambio en las propiedades o el estado del
componente.
render() {
return (
<div>
Hello, {this.props.name}!
</div>
);
}
componentDidMount() (ES5 y ES6)
Este es el quinto método llamado.
El componente se ha montado y ahora puede acceder a los nodos DOM del componente, por
ejemplo, a través de refs .
Este método debe ser utilizado para:
Preparando temporizadores	•
https://riptutorial.com/es/home 96

-- 106 of 139 --

Recuperacion de datos	•
Añadiendo oyentes de eventos	•
Manipulando elementos DOM	•
componentDidMount() {
...
}
Sintaxis de ES6
Si el componente se define utilizando la sintaxis de clase ES6, las funciones getDefaultProps() y
getInitialState() no se pueden usar.
En su lugar, declaramos nuestros defaultProps como una propiedad estática en la clase y
declaramos la forma de estado y el estado inicial en el constructor de nuestra clase. Ambos se
establecen en la instancia de la clase en el momento de la construcción, antes de que se llame a
cualquier otra función de ciclo de vida React.
El siguiente ejemplo demuestra este enfoque alternativo:
class MyReactClass extends React.Component {
constructor(props){
super(props);
this.state = {
count: this.props.initialCount
};
}
upCount() {
this.setState((prevState) => ({
count: prevState.count + 1
}));
}
render() {
return (
<div>
Hello, {this.props.name}!<br />
You clicked the button {this.state.count} times.<br />
<button onClick={this.upCount}>Click here!</button>
</div>
);
}
}
MyReactClass.defaultProps = {
name: 'Bob',
initialCount: 0
};
Reemplazo de getDefaultProps()
https://riptutorial.com/es/home 97

-- 107 of 139 --

Los valores predeterminados para las propiedades del componente se especifican al establecer la
propiedad defaultProps de la clase:
MyReactClass.defaultProps = {
name: 'Bob',
initialCount: 0
};
Sustitución de getInitialState()
La forma idiomática de configurar el estado inicial del componente es establecer this.state en el
constructor:
constructor(props){
super(props);
this.state = {
count: this.props.initialCount
};
}
Actualización de componentes
componentWillReceiveProps(nextProps)
Esta es la primera función llamada sobre cambios de propiedades .
Cuando las propiedades del componente cambian , React llamará a esta función con las
nuevas propiedades . Puede acceder a los accesorios antiguos con this.props y a los nuevos
accesorios con nextProps .
Con estas variables, puede realizar algunas operaciones de comparación entre accesorios
antiguos y nuevos, o llamar a la función debido a un cambio de propiedad, etc.
componentWillReceiveProps(nextProps){
if (nextProps.initialCount && nextProps.initialCount > this.state.count){
this.setState({
count : nextProps.initialCount
});
}
}
shouldComponentUpdate(nextProps, nextState)
Esta es la segunda función llamada sobre cambios de propiedades y la primera sobre
cambios de estado .
De forma predeterminada, si otro componente / su componente cambia una propiedad / un estado
de su componente, React generará una nueva versión de su componente. En este caso, esta
función siempre devuelve true.
https://riptutorial.com/es/home 98

-- 108 of 139 --

Puede anular esta función y elegir con mayor precisión si su componente debe actualizarse
o no .
Esta función se utiliza principalmente para la optimización .
En caso de que la función devuelva falso , la actualización de la tubería se detiene de
inmediato .
componentShouldUpdate(nextProps, nextState){
return this.props.name !== nextProps.name ||
this.state.count !== nextState.count;
}
componentWillUpdate(nextProps, nextState)
Esta función funciona como componentWillMount() . Los cambios no están en DOM , por lo que
puede hacer algunos cambios justo antes de que se realice la actualización.
/! \: no puede usar this.setState () .
componentWillUpdate(nextProps, nextState){}
render()
Hay algunos cambios, así que vuelva a renderizar el componente.
componentDidUpdate(prevProps, prevState)
Lo mismo que componentDidMount() : DOM se actualiza , por lo que puede hacer algún trabajo en
el DOM aquí.
componentDidUpdate(prevProps, prevState){}
Eliminación de componentes
componentWillUnmount()
Se llama a este método antes de que se desmonte un componente del DOM.
Es un buen lugar para realizar operaciones de limpieza como:
Eliminando oyentes de eventos.	•
Temporizadores de compensación.	•
Detener los enchufes.	•
Limpieza de estados redux.	•
componentWillUnmount(){
...
https://riptutorial.com/es/home 99

-- 109 of 139 --

}
Un ejemplo de eliminación de la escucha de eventos adjunta en componentWillUnMount
import React, { Component } from 'react';
export default class SideMenu extends Component {
constructor(props) {
super(props);
this.state = {
...
};
this.openMenu = this.openMenu.bind(this);
this.closeMenu = this.closeMenu.bind(this);
}
componentDidMount() {
document.addEventListener("click", this.closeMenu);
}
componentWillUnmount() {
document.removeEventListener("click", this.closeMenu);
}
openMenu() {
...
}
closeMenu() {
...
}
render() {
return (
<div>
<a
href = "javascript:void(0)"
className = "closebtn"
onClick = {this.closeMenu}
>
×
</a>
<div>
Some other structure
</div>
</div>
);
}
}
React Component Container
Al crear una aplicación React, a menudo es conveniente dividir los componentes en función de su
responsabilidad principal, en los componentes de Presentación y Contenedor.
Los componentes de presentación solo se ocupan de mostrar datos: pueden considerarse como,
y con frecuencia, se implementan como funciones que convierten un modelo en una vista.
https://riptutorial.com/es/home 100

-- 110 of 139 --

Típicamente no mantienen ningún estado interno. Los componentes del contenedor se ocupan de
la gestión de datos. Esto puede hacerse internamente a través de su propio estado o actuando
como intermediarios con una biblioteca de administración del estado como Redux. El componente
contenedor no mostrará directamente los datos, sino que pasará los datos a un componente de
presentación.
// Container component
import React, { Component } from 'react';
import Api from 'path/to/api';
class CommentsListContainer extends Component {
constructor() {
super();
// Set initial state
this.state = { comments: [] }
}
componentDidMount() {
// Make API call and update state with returned comments
Api.getComments().then(comments => this.setState({ comments }));
}
render() {
// Pass our state comments to the presentational component
return (
<CommentsList comments={this.state.comments} />;
);
}
}
// Presentational Component
const CommentsList = ({ comments }) => (
<div>
{comments.map(comment => (
<div>{comment}</div>
)}
</div>
);
CommentsList.propTypes = {
comments: React.PropTypes.arrayOf(React.PropTypes.string)
}
Método de ciclo de vida llamado en diferentes estados.
Este ejemplo sirve como complemento a otros ejemplos que hablan sobre cómo usar los métodos
del ciclo de vida y cuándo se llamará el método.
Este ejemplo resume qué métodos (componentWillMount, componentWillReceiveProps, etc.) se
llamarán y en qué secuencia será diferente para un componente en diferentes estados :
Cuando se inicializa un componente:
getDefaultProps	1.
getInitialState	2.
componentWillMount	3.
https://riptutorial.com/es/home 101

-- 111 of 139 --

hacer	4.
componentDidMount	5.
Cuando un componente ha cambiado de estado:
shouldComponentUpdate	1.
componentWillUpdate	2.
hacer	3.
componentDidUpdate	4.
Cuando un componente tiene accesorios cambiados:
componentWillReceiveProps	1.
shouldComponentUpdate	2.
componentWillUpdate	3.
hacer	4.
componentDidUpdate	5.
Cuando se desmonta un componente:
componentWillUnmount	1.
Lea React Component Lifecycle en línea: https://riptutorial.com/es/reactjs/topic/2750/react-
component-lifecycle
https://riptutorial.com/es/home 102

-- 112 of 139 --