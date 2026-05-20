# 8.6 Entendiendo conectar

La idea de conectar es la de permitirnos incrustar datos y acciones concretas a
componentes. Es así como podemos conectar los datos de los carriles y las acciones
con App:
@connect(({lanes}) => ({lanes}), {
laneActions: LaneActions
})
export default class App extends React.Component {
render() {
return (
<div>
<button className="add-lane" onClick={this.addLane}>+</butto\
n>
<Lanes lanes={this.props.lanes} />
</div>
);
}
addLane = () => {
this.props.laneActions.create({name: 'New lane'});
}
}
Se puede escribir lo mismo sin decoradores. Esta es la sintáxis que utilizaremos en
nuestra aplicación:

-- 94 of 226 --

React y Flux 77
class App extends React.Component {
...
}
export default connect(({lanes}) => ({lanes}), {
LaneActions
})(App)
En caso de que necesites aplicar varias funciones de alto nivel contra un componente,
puedes utilizar una utilidad como compose y usarla con compose(a, b)(App). Esto
será igual a a(b(App)) y se puede leer mejor.
En los ejemplos mostrados compose es una función que devuelve una función. Por
ello lo llamamos Función de Alto Nivel. Al final obtendremos un componente de
ella. Este envoltorio nos permite manejar todo lo relacionado con la conexión con
los datos.
Podemos utilizar una función de alto nivel para anotar nuestros componentes y darles
además otras propiedades especiales. Veremos esta idea cuando implementemos la
funcionalidad de arrastrar y soltar. Los decoradores brindan una forma sencilla
de incluir estos tipos de anotaciones. El apéndice Entendiendo los Decoradores
profundiza más en este asunto.
Ahora que entendemos básicamente cómo debería funcionar conectar podemos
implementarlo.
Configurando conectar
Voy a utilizar un conectar personalizado para remarcar un par de ideas clave. La
implementación no es óptima en terminos de rendimiento pero será suficiente para
esta aplicación.
Es posible optimizar el rendimiento con un trabajo posterior. Puedes utilizar uno de
los conectores comunes en lugar de desarrollar el tuyo propio. He aquí una razón por
la cual tener el control de Proveedor y conectar es útil, permite personalizar más
adelante y entender cómo funciona el proceso.
app/libs/connect.jsx

-- 95 of 226 --

React y Flux 78
import React from 'react';
export default (state, actions) => {
if(typeof state === 'function' ||
(typeof state === 'object' && Object.keys(state).length)) {
return target => connect(state, actions, target);
}
return target => props => (
<target {...Object.assign({}, props, actions)} />
);
}
// Conectar con Alt a través del contexto. Esto no ha sido optimizado
// para nada. Si Alt almacena los cambios se forzará el renderizado.
//
// Ver *AltContainer* y *connect-alt* para encontrar soluciones ópti\
mas
function connect(state = () => {}, actions = {}, target) {
class Connect extends React.Component {
componentDidMount() {
const {flux} = this.context;
flux.FinalStore.listen(this.handleChange);
}
componentWillUnmount() {
const {flux} = this.context;
flux.FinalStore.unlisten(this.handleChange);
}
render() {
const {flux} = this.context;
const stores = flux.stores;
const composedStores = composeStores(stores);

-- 96 of 226 --

React y Flux 79
return React.createElement(target,
{...Object.assign(
{}, this.props, state(composedStores), actions
)}
);
}
handleChange = () => {
this.forceUpdate();
}
}
Connect.contextTypes = {
flux: React.PropTypes.object.isRequired
}
return Connect;
}
// Convierte {store: <AltStore>} en {<store>: store.getState()}
function composeStores(stores) {
let ret = {};
Object.keys(stores).forEach(k => {
const store = stores[k];
// Combina el estado del almacén
ret = Object.assign({}, ret, store.getState());
});
return ret;
}
Dado que flux.FinalStore no está disponible por defecto, necesitamos cambiar
nuestra instacia de Alt para que la contenga. Tras ello podremos acceder a ella donde
la necesitemos:
app/libs/alt.js

-- 97 of 226 --

React y Flux 80
import Alt from 'alt';
import makeFinalStore from 'alt-utils/lib/makeFinalStore';
const alt = new Alt();
export default alt;
class Flux extends Alt {
constructor(config) {
super(config);
this.FinalStore = makeFinalStore(this);
}
}
const flux = new Flux();
export default flux;
Podemos incrustar algunos datos de prueba en App y renderizarlos para ver conectar
en acción. Haz los cambios siguientes para enviar datos a App y, después, mira cómo
se muestran en la interfaz de usuario:
app/components/App.jsx
import React from 'react';
import uuid from 'uuid';
import Notes from './Notes';
import connect from '../libs/connect';
export default class App extends React.Component {
class App extends React.Component {
constructor(props) {
...
}
render() {
const {notes} = this.state;

-- 98 of 226 --

React y Flux 81
return (
<div>
{this.props.test}
<button className="add-note" onClick={this.addNote}>+</butto\
n>
<Notes
notes={notes}
onNoteClick={this.activateNoteEdit}
onEdit={this.editNote}
onDelete={this.deleteNote}
/>
</div>
);
}
...
}
export default connect(() => ({
test: 'test'
}))(App)
Refresca el navegador para mostrar el texto. Deberías poder ver ahora el texto que
hemos conectado con App.