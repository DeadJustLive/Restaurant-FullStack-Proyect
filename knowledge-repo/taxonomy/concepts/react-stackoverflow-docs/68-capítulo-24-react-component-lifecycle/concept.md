# Capítulo 24:: React Component Lifecycle

## Fuente
react-stackoverflow-docs (Cap. 68)

## Contenido
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
De forma predeterminada, si otro componente / su componente cambia una 
