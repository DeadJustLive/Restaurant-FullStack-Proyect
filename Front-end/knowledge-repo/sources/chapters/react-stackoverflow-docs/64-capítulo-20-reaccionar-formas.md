# Capítulo 20:: Reaccionar formas

Examples
Componentes controlados
Un componente controlado está vinculado a un valor y sus cambios se manejan en el código
mediante devoluciones de llamada basadas en eventos.
class CustomForm extends React.Component {
constructor() {
super();
this.state = {
person: {
firstName: '',
lastName: ''
}
}
}
handleChange(event) {
let person = this.state.person;
person[event.target.name] = event.target.value;
this.setState({person});
}
render() {
return (
<form>
<input
type="text"
name="firstName"
value={this.state.firstName}
onChange={this.handleChange.bind(this)} />
<input
type="text"
name="lastName"
value={this.state.lastName}
onChange={this.handleChange.bind(this)} />
</form>
)
}
}
En este ejemplo, inicializamos el estado con un objeto persona vacío. Luego vinculamos los
valores de las 2 entradas a las claves individuales del objeto persona. Luego, a medida que el
usuario escribe, handleChange cada valor en la función handleChange . Dado que los valores de los
componentes están vinculados al estado, podemos redirigirlos a los tipos de usuario llamando a
setState() .
NOTA: No llamar a setState() cuando se trata con componentes controlados, hará que el usuario
https://riptutorial.com/es/home 84

-- 94 of 139 --

escriba, pero no verá la entrada porque React solo presenta los cambios cuando se le indica que
lo haga.
También es importante tener en cuenta que los nombres de las entradas son los mismos que los
nombres de las teclas en el objeto persona. Esto nos permite capturar el valor en forma de
diccionario como se ve aquí.
handleChange(event) {
let person = this.state.person;
person[event.target.name] = event.target.value;
this.setState({person});
}
person[event.target.name] es el mismo es person.firstName || person.lastName . Por supuesto, esto
dependería de la entrada que se está escribiendo actualmente. Ya que no sabemos dónde
escribirá el usuario, usar un diccionario y hacer coincidir los nombres de entrada con los nombres
de las teclas, nos permite capturar la entrada del usuario no importa desde donde se llama el
onChange.
Lea Reaccionar formas en línea: https://riptutorial.com/es/reactjs/topic/8047/reaccionar-formas
https://riptutorial.com/es/home 85

-- 95 of 139 --