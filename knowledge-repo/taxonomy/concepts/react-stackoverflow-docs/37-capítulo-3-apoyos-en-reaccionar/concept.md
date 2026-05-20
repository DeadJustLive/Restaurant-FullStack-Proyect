# Capítulo 3:: Apoyos en reaccionar

## Fuente
react-stackoverflow-docs (Cap. 37)

## Contenido
# Capítulo 3:: Apoyos en reaccionar

Observaciones
NOTA: A partir de React 15.5 y superior, el componente PropTypes vive en su propio paquete
npm, es decir, 'prop-types' y necesita su propia declaración de importación cuando se usa
PropTypes. Consulte la documentación oficial de reacción para el cambio de última hora:
https://facebook.github.io/react/blog/2017/04/07/react-v15.5.0.html
Examples
Introducción
props se utilizan para pasar datos y métodos de un componente principal a un componente
secundario.
Cosas interesantes sobre props
Son inmutables.	1.
Nos permiten crear componentes reutilizables.	2.
Ejemplo basico
class Parent extends React.Component{
doSomething(){
console.log("Parent component");
}
render() {
return <div>
<Child
text="This is the child number 1"
title="Title 1"
onClick={this.doSomething} />
<Child
text="This is the child number 2"
title="Title 2"
onClick={this.doSomething} />
</div>
}
}
class Child extends React.Component{
render() {
return <div>
<h1>{this.props.title}</h1>
<h2>{this.props.text}</h2>
</div>
}
}
https://riptutorial.com/es/home 16

-- 26 of 139 --

Como puede ver en el ejemplo, gracias a los props podemos crear componentes reutilizables.
Accesorios por defecto
defaultProps permite establecer valores predeterminados, o de respaldo, para los props sus
componentes. defaultProps son útiles cuando llama a componentes desde diferentes vistas con
apoyos fijos, pero en algunas vistas debe pasar un valor diferente.
Sintaxis
ES5
var MyClass = React.createClass({
getDefaultProps: function() {
return {
randomObject: {},
...
};
}
}
ES6
class MyClass extends React.Component {...}
MyClass.defaultProps = {
randomObject: {},
...
}
ES7
class MyClass extends React.Component {
static defaultProps = {
randomObject: {},
...
};
}
El resultado de getDefaultProps() o defaultProps se almacenará en caché y se usará para
garantizar que this.props.randomObject tendrá un valor si no fue especificado por el componente
principal.
PropTypes
propTypes permite especificar qué props necesita su componente y el tipo que deben ser. Su
componente funcionará sin establecer propTypes , pero es una buena práctica definirlos, ya que
hará que su componente sea más legible, actuar como documentación para otros desarrolladores
que están leyendo su componente, y durante el desarrollo, React le avisará si intenta establezca
https://riptutorial.com/es/home 17

-- 27 of 139 --

un prop, que es un tipo diferente a la definición que ha establecido para él.
Algunos primitivos propTypes y comúnmente utilizables propTypes son -
optionalArray: React.PropTypes.array,
optionalBool: React.PropTypes.bool,
optionalFunc: React.PropTypes.func,
optionalNumber: React.PropTypes.number,
optionalObject: React.PropTypes.object,
optionalString: React.PropTypes.string,
optionalSymbol: React.PropTypes.symbol
Si adjunta isRequired a cualquier propType entonces ese prop debe suministrarse al crear la
instancia de ese componente. Si no proporciona los propTypes necesarios, no se puede crear la
instancia del componente.
Sintaxis
ES5
var MyClass = React.createClass({
propTypes: {
randomObject: React.PropTypes.object,
callback: React.PropTypes.func.isRequired,
...
}
}
ES6
class MyClass extends React.Component {...}
MyClass.propTypes = {
randomObject: React.PropTypes.object,
callback: React.PropTypes.func.isRequired,
...
};
ES7
class MyClass extends React.Component {
static propTypes = {
randomObject: React.PropTypes.object,
callback: React.PropTypes.func.isRequired,
...
};
}
Validación de utilería más compleja.
https://riptutorial.com/es/home 18

-- 28 of 139 --

De la misma manera, PropTypes permite especificar una validación más compleja
Validando un objeto
...
randomObject: React.PropTypes.shape({
id: React.PropTypes.number.isRequired,
text: React.PropTypes.string,
}).isRequired,
...
Validando en matriz de objetos
...
arrayOfObjects: React.PropTypes.arrayOf(React.PropTypes.shape({
id: React.PropTypes.number.isRequired,
text: React.PropTypes.string,
})).isRequired,
...
Pasando los puntales utilizando el operador extendido
En lugar de
var component = <Component foo={this.props.x} bar={this.props.y} />;
Cuando sea necesario pasar cada propiedad como un único valor prop, podría usar el operador
de propagación ... compatible con las matrices en ES6 para transmitir todos sus valores. El
componente ahora se verá así.
var component = <Component {...props} />;
Recuerde que las propiedades del objeto que usted pasa se copian en los accesorios del
componente.
El orden es importante. Los atributos posteriores anulan los anteriores.
var props = { foo: 'default' };
var component = <Component {...props} foo={'override'} />;
console.log(component.props.foo); // 'override'
Otro caso es que también puede usar el operador de propagación para pasar solo partes de
accesorios a componentes secundarios, luego puede usar la sintaxis de desestructuración de los
accesorios de nuevo.
Es muy útil cuando los componentes de los niños necesitan muchos accesorios pero no quier
