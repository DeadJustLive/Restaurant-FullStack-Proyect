# Capítulo 22:: Reaccionar llamada AJAX

Examples
Solicitud HTTP GET
A veces, un componente necesita generar algunos datos desde un punto final remoto (por
ejemplo, una API REST). Una práctica estándar es hacer tales llamadas en el método
componentDidMount .
Aquí hay un ejemplo, usando superagente como ayudante de AJAX:
import React from 'react'
import request from 'superagent'
class App extends React.Component {
constructor () {
super()
this.state = {}
}
componentDidMount () {
request
.get('/search')
.query({ query: 'Manny' })
.query({ range: '1..5' })
.query({ order: 'desc' })
.set('API-Key', 'foobar')
.set('Accept', 'application/json')
.end((err, resp) => {
if (!err) {
this.setState({someData: resp.text})
}
})
},
render() {
return (
<div>{this.state.someData || 'waiting for response...'}</div>
)
}
}
React.render(<App />, document.getElementById('root'))
Se puede iniciar una solicitud invocando el método apropiado en el objeto de request , luego
llamando a .end() para enviar la solicitud. Establecer campos de encabezado es simple, invoque
.set() con un nombre y valor de campo.
El método .query() acepta objetos, que cuando se usan con el método GET formarán una cadena
de consulta. Lo siguiente producirá la ruta /search?query=Manny&range=1..5&order=desc .
Solicitudes POST
https://riptutorial.com/es/home 87

-- 97 of 139 --

request.post('/user')
.set('Content-Type', 'application/json')
.send('{"name":"tj","pet":"tobi"}')
.end(callback)
Ver documentos Superagent para más detalles.
Ajax en Reaccionar sin una biblioteca de terceros, también conocido como
VanillaJS
Lo siguiente funcionaría en IE9 +
import React from 'react'
class App extends React.Component {
constructor () {
super()
this.state = {someData: null}
}
componentDidMount () {
var request = new XMLHttpRequest();
request.open('GET', '/my/url', true);
request.onload = () => {
if (request.status >= 200 && request.status < 400) {
// Success!
this.setState({someData: request.responseText})
} else {
// We reached our target server, but it returned an error
// Possibly handle the error by changing your state.
}
};
request.onerror = () => {
// There was a connection error of some sort.
// Possibly handle the error by changing your state.
};
request.send();
},
render() {
return (
<div>{this.state.someData || 'waiting for response...'}</div>
)
}
}
React.render(<App />, document.getElementById('root'))
Solicitud HTTP GET y bucle a través de los datos
El siguiente ejemplo muestra cómo un conjunto de datos obtenidos de una fuente remota se
puede representar en un componente.
Hacemos una solicitud AJAX usando fetch , que está integrada en la mayoría de los
navegadores. Utilice un polyfill de fetch en producción para admitir navegadores más antiguos.
https://riptutorial.com/es/home 88

-- 98 of 139 --

También se puede utilizar cualquier otra biblioteca para hacer peticiones (por ejemplo axios ,
SuperAgent , o incluso llanura Javascript).
Establecemos los datos que recibimos como estado de componente, por lo que podemos acceder
a ellos dentro del método de procesamiento. Allí, recorremos los datos utilizando el map . No se
olvide de agregar siempre un atributo key único (o prop) al elemento en bucle, que es importante
para el rendimiento de representación de React.
import React from 'react';
class Users extends React.Component {
constructor() {
super();
this.state = { users: [] };
}
componentDidMount() {
fetch('/api/users')
.then(response => response.json())
.then(json => this.setState({ users: json.data }));
}
render() {
return (
<div>
<h1>Users</h1>
{
this.state.users.length == 0
? 'Loading users...'
: this.state.users.map(user => (
<figure key={user.id}>
<img src={user.avatar} />
<figcaption>
{user.name}
</figcaption>
</figure>
))
}
</div>
);
}
}
ReactDOM.render(<Users />, document.getElementById('root'));
Ejemplo de trabajo en JSBin .
Lea Reaccionar llamada AJAX en línea: https://riptutorial.com/es/reactjs/topic/6432/reaccionar-
llamada-ajax
https://riptutorial.com/es/home 89

-- 99 of 139 --