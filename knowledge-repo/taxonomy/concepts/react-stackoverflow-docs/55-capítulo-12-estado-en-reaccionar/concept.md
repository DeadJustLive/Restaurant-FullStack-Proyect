# Capítulo 12:: Estado en reaccionar

## Fuente
react-stackoverflow-docs (Cap. 55)

## Contenido
# Capítulo 12:: Estado en reaccionar

Examples
Estado basico
El estado en los componentes de React es esencial para administrar y comunicar datos en su
aplicación. Se representa como un objeto de JavaScript y tiene un alcance de nivel de
componente , se puede considerar como los datos privados de su componente.
En el siguiente ejemplo, definimos un estado inicial en la función de constructor de nuestro
componente y lo utilizamos en la función de render .
class ExampleComponent extends React.Component {
constructor(props){
super(props);
// Set-up our initial state
this.state = {
greeting: 'Hiya Buddy!'
};
}
render() {
// We can access the greeting property through this.state
return(
<div>{this.state.greeting}</div>
);
}
}
setState ()
La principal forma de realizar actualizaciones de IU en sus aplicaciones React es a través de una
llamada a la función setState() . Esta función realizará una fusión superficial entre el nuevo
estado que proporcionó y el estado anterior, y activará una nueva representación de su
componente y todos los difuntos.
Parámetros
updater : puede ser un objeto con una serie de pares clave-valor que deben fusionarse en el
estado o una función que devuelve dicho objeto.
1.
callback (optional) : una función que se ejecutará después de que setState() se haya
ejecutado correctamente. Debido a que React no garantiza que las llamadas a setState()
sean atómicas, esto a veces puede ser útil si desea realizar alguna acción después de estar
seguro de que setState() se ha ejecutado correctamente.
2.
Uso:
https://riptutorial.com/es/home 58

-- 68 of 139 --

El método setState acepta un argumento updater que puede ser un objeto con una cantidad de
pares clave-valor que deben fusionarse en el estado, o una función que devuelve dicho objeto
computado desde prevState y props .
Usando setState() con un Objeto como updater
//
// An example ES6 style component, updating the state on a simple button click.
// Also demonstrates where the state can be set directly and where setState should be used.
//
class Greeting extends React.Component {
constructor(props) {
super(props);
this.click = this.click.bind(this);
// Set initial state (ONLY ALLOWED IN CONSTRUCTOR)
this.state = {
greeting: 'Hello!'
};
}
click(e) {
this.setState({
greeting: 'Hello World!'
});
}
render() {
return(
<div>
<p>{this.state.greeting}</p>
<button onClick={this.click}>Click me</button>
</div>
);
}
}
Usando setState() con una función como updater
//
// This is most often used when you want to check or make use
// of previous state before updating any values.
//
this.setState(function(previousState, currentProps) {
return {
counter: previousState.counter + 1
};
});
Esto puede ser más seguro que usar un argumento de objeto donde se usan múltiples llamadas a
setState() , ya que React puede agrupar varias llamadas y se ejecutan a la vez, y es el enfoque
preferido cuando se usan accesorios actuales para establecer el estado.
https://riptutorial.com/es/home 59

-- 69 of 139 --

this.setState({ counter: this.state.counter + 1 });
this.setState({ counter: this.state.counter + 1 });
this.setState({ counter: this.state.counter + 1 });
Estas llamadas pueden agruparse mediante React utilizando Object.assign() , lo que hace que el
contador se incremente en 1 en lugar de 3.
El enfoque funcional también se puede utilizar para mover la lógica de configuración de estado
fuera de los componentes. Esto permite el aislamiento y la reutilización de la lógica de estado.
// Outside of component class, potentially in another file/module
function incrementCounter(previousState, currentProps) {
return {
counter: previousState.counter + 1
};
}
// Within component
this.setState(incrementCounter);
Llamar a setState() con un objeto y una función de
devolución de llamada
//
// 'Hi There' will be logged to the console after setState completes
//
this.setState({ name: 'John Doe' }, console.log('Hi there'));
Antipattern común
No debes guardar props en state . Se considera un anti-patrón . Por ejemplo:
export default class MyComponent extends React.Component {
constructor() {
super();
this.state = {
url: ''
}
this.onChange = this.onChange.bind(this);
}
onChange(e) {
this.setState({
url: this.props.url + '/days=?' + e.target.value
});
}
https://riptutorial.com/es/home 60

-- 70 of 139 --

componentWillMount() {
this.setState({url: this.props.url});
}
render() {
return (
<div>
<input defaultValue={2} onChange={this.onChange} />
URL: {this.state.url}
</div>
)
}
}
La url apoyo se guarda en el state y luego se modifica. En su lugar, elija guardar los cambios en
un estado y luego genere la ruta completa utilizando tanto el state como los props :
export default class MyComponent extends React.Component {
constructor() {
super();
this.state = {
days: ''
}
this.onChange = this.onChange.bind(this);
}
onChange(e) {
this.setState({
days: e.target.value
});
}
render() {
return (
<div>
<input defaultValue={2} onChange={this.onChange} />
URL: {this.props.url + '/days?=' + this.state.days}
<
