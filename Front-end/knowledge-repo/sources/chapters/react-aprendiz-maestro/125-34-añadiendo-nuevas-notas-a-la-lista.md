# 3.4 Añadiendo Nuevas Notas a la Lista

Aunque de momento podemos mostrar notas de forma individual, todavía nos falta
mucha lógica que hará que nuestra aplicación sea útil. Una forma lógica de comenzar
puede ser implementando la inclusión de nuevas notas a la lista. Para conseguirlo
necesitamos hacer que la aplicación crezca un poco.
Definiendo un Borrador para App
Para poder añadir nuevas notas necesitaremos tener un botón que nos lo permita
en algún sitio. Actualmente nuestro componente Notas sólo hace una cosa: mostrar
notas. Esto es totalmente correcto. Para hacer espacio a más funcionalidad podemos
incluir un concepto conocido como App en lo más alto. Este componente orquestará
la ejecución de nuestra aplicación. Podemos añadir el botón que queramos allí,
podremos gestionar el estado y también podremos añadir notas. Inicialmente App
puede tener el siguiente aspecto:
app/components/App.jsx
4https://developer.mozilla.org/es/docs/Web/API/Console
5https://developers.google.com/web/tools/chrome-devtools/debug/console/console-reference
6https://en.wikipedia.org/wiki/Universally_unique_identifier#Random_UUID_probability_of_duplicates

-- 40 of 226 --

Implementando una Aplicación de Notas 23
import React from 'react';
import Notes from './Notes';
export default () => <Notes />;
Todo lo que hace es renderizar Notas, así que debe hacer más cosas para conseguir
que sea útil. Tenemos que alterar el punto de entrada tal y como sigue para incrustar
App en nuestra aplicación:
app/index.jsx
import React from 'react';
import ReactDOM from 'react-dom';
import Notes from './components/Notes';
import App from './components/App';
if(process.env.NODE_ENV !== 'production') {
React.Perf = require('react-addons-perf');
}
ReactDOM.render(
<Notes />,
<App />,
document.getElementById('app')
);
Si ejecutas la aplicación ahora verás que tiene exactamente el mismo aspecto que
antes, pero ahora tenemos espacio para crecer.
Añadiendo un Borrador para el Botón Añadir
Un buen paso para llegar a algo más funcionar es añadir un borrador para el botón
añadir. Para conseguirlo, App necesita evolucionar:
app/components/App.jsx

-- 41 of 226 --

Implementando una Aplicación de Notas 24
import React from 'react';
import Notes from './Notes';
export default () => <Notes />;
export default () => (
<div>
<button onClick={() => console.log('añadir nota')}>+</button>
<Notes />
</div>
);
Si pulsas sobre el botón que hemos añadido verás un mensaje con el texto “añadir
nota” en la consola del navegador. Todavía necesitamos conectar de alguna forma
el botón con nuestros datos. De momento los datos están atrapados dentro del
componente Notas así que, antes de seguir, necesitamos sacarlos y dejarlos a nivel
de App.
Tenemos que envolver nuestra aplicación dentro de un div porque todos
los componentes de React deben devolver un único elemento.
Llevando los Datos a App
Para llevar los datos a App necesitamos hacer un par de cambios. Lo primero que
necesitamos es moverlos literalmente allí y mandar los datos mediante una propiedad
(prop en adelante) a Notas. Tras esto necesitamos realizar cambios en Notas para
realizar operaciones en base a la nueva lógica. Una vez hayamos conseguido esto
podremos empezar a pensar en añadir notas nuevas.
En la parte de App el cambio es sencillo:
app/components/App.jsx

-- 42 of 226 --

Implementando una Aplicación de Notas 25
import React from 'react';
import uuid from 'uuid';
import Notes from './Notes';
const notes = [
{
id: uuid.v4(),
task: 'Learn React'
},
{
id: uuid.v4(),
task: 'Do laundry'
}
];
export default () => (
<div>
<button onClick={() => console.log('añadir nota')}>+</button>
<Notes />
<Notes notes={notes} />
</div>
);
Esto no hará mucho hasta que también cambiemos Notas:
app/components/Notes.jsx
import React from 'react';
import uuid from 'uuid';
const notes = [
{
id: uuid.v4(),
task: 'Learn React'
},
{

-- 43 of 226 --

Implementando una Aplicación de Notas 26
id: uuid.v4(),
task: 'Do laundry'
}
];
export default () => {
export default ({notes}) => (
<ul>{notes.map(note =>
<li key={note.id}>{note.task}</li>
)}</ul>
);
Nuestra aplicación tendrá el mismo aspecto que antes de que hiciéramos los cambios,
pero ahora estamos listos para añadir algo de lógica.
La forma de extraer notes de props (el primer parámetro) es un truco
estándar que verás con React. Si quieres acceder al resto de props puedes
usar una sintaxis como {notes, ...props}. Más adelante lo utilizaremos
de nuevo para que te hagas una idea más clara de cómo funciona y para
qué puedes utilizarlo.
Llevando el Estado a App
Ahora que tenemos todo colocado y en el lugar correcto podemos comenzar a preo-
cuparnos sobre cómo modificar los datos. Si has utilizado JavaScript con anterioridad
verás que la forma más intuitiva de hacer esto es configurar un evento de este estilo:
() => notes.push({id: uuid.v4(), task: 'New task'}). Si lo intentas verás que
no ocurre nada.
El motivo es sencillo. React no se ha enterado de que la estructura ha cambiado y, por
tanto, no reacciona (esto es, no invoca a render()). Para solucionar este problema
podemos implementar nuestra modificación haciendo que utilice el propio API de
React, lo que hará que sí se entere de que la estructura ha cambiado y, como resultado,
ejecutará render() tal y como esperamos.

-- 44 of 226 --

Implementando una Aplicación de Notas 27
En el momento de escribir esto la definición de componentes basada en funciones
no soporta el concepto de estado. El problema aparece porque estos componentes no
tienen una instancia por detrás que les respalde. Podríamos ver cómo arreglar esto
utilizando únicamente funciones, pero por ahora tendremos que utilizar la alternativa
de hacer el trabajo duro por nosotros mismos.
Además de funciones, también puedes crear componentes de React utilizando
React.createClass o una definición de componentes basada en clases. En este libro
utilizaremos componentes basados en funciones tanto como sea posible, y sólo si
hay una buena razón por la cual estos componentes no pueden funcionar, entonces
utilizaremos definiciones basadas en clases.
Con el objetivo de transformar nuestra App en un componente basado en clases,
cámbialo como sigue para meter el estado dentro.
app/components/App.jsx
import React from 'react';
import uuid from 'uuid';
import Notes from './Notes';
const notes = [
{
id: uuid.v4(),
task: 'Learn React'
},
{
id: uuid.v4(),
task: 'Do laundry'
}
];
export default () => (
<div>
<button onClick={() => console.log('añadir nota')}>+</button>
<Notes notes={notes} />
</div>

-- 45 of 226 --

Implementando una Aplicación de Notas 28
);
export default class App extends React.Component {
constructor(props) {
super(props);
this.state = {
notes: [
{
id: uuid.v4(),
task: 'Learn React'
},
{
id: uuid.v4(),
task: 'Do laundry'
}
]
};
}
render() {
const {notes} = this.state;
return (
<div>
<button onClick={() => console.log('add note')}>+</button>
<Notes notes={notes} />
</div>
);
}
}
Tras este cambio App contiene el estado aunque la aplicación siga pareciendo la
misma de antes. Es ahora cuando podemos comenzar a usar el API de React para
modificar el estado.

-- 46 of 226 --

Implementando una Aplicación de Notas 29
Las soluciones de gestión de datos, tales como MobX7, arreglan el pro-
blema a su manera. Utilizándolos sólo necesitas poner anotaciones en tus
estructuras de datos, en los componentes de React, y ellos se encargan de
resolver del problema de actualizarse. Volveremos más adelante a tratar
este tema de la gestión de datos en detalle.
Estamos pasando props a super por convención. Si no lo haces,
¡this.props no cambiará!. Llamar a super provoca que se invoque al
mismo método de la clase padre del mismo modo a como se hace en la
programación orientada a objetos.
Implementando la Lógica de Añadir Nota
Todos nuestros esfuerzos pronto se verán recompensados. Sólo nos queda un paso, tan
sólo necesitamos utilizar el API de React para manipular el estado. React facilita un
método conocido como setState con este objetivo. En este caso lo invocaremos como
sigue: this.setState({... el nuevo estado viene aquí ...}, () => ...).
El callback es opcional. React lo invocará una vez haya establecido el estado y, por lo
general, no tienes que preocuparte de ello para nada. React invocará a render una vez
que setState haya terminado. El API asíncrono te puede parecer un poco extraño
al principio pero le permite a React ser capaz de optimizar su rendimiento utilizando
técnicas como las actualizaciones en bloque. Todo esto recae en el concepto de DOM
Virtual.
Una forma de invocar a setState puede ser dejar toda la lógica relacionada en un
método para llamarlo una vez se crea una nueva nota. La definición de componentes
basada en clases no permite enlazar métodos personalizados como éste por defecto
así que necesitaremos gestionar esta asociación en algún sitio. Podría ser posible
hacer esto en el constructor, render(), o utilizando una sintaxis específica. Voy a
optar por la solución de la sintaxis en este libro. Lee el apéndice Características del
Lenguaje para aprender más.
Para atar la lógica al botón, App debe cambiar como sigue:
7https://mobxjs.github.io/mobx/

-- 47 of 226 --

Implementando una Aplicación de Notas 30
app/components/App.jsx
import React from 'react';
import uuid from 'uuid';
import Notes from './Notes';
export default class App extends React.Component {
constructor(props) {
...
}
render() {
const {notes} = this.state;
return (
<div>
<button onClick={() => console.log('add note')}>+</button>
<button onClick={this.addNote}>+</button>
<Notes notes={notes} />
</div>
);
}
addNote = () => {
// Es posible escribir esto de forma imperativa, es decir,
// a través de `this.state.notes.push` y, después,
// `this.setState({notes: this.state.notes})`.
//
// Suelo favorecer el estilo funcional cuando tiene sentido.
// Incluso cuando es necesario escribir más código, ya que
// prefiero los beneficios (facilidad para razonar, no
// efectos colaterales) que trae consigo.
//
// Algunas librerias, como Immutable.js, van un paso más allá.
this.setState({
notes: this.state.notes.concat([{
id: uuid.v4(),
task: 'New task'

-- 48 of 226 --

Implementando una Aplicación de Notas 31
}])
});
}
}
Dado que, en este punto, estamos enlazando una instancia, la recarga en caliente no
se dará cuenta del cambio. Para probar la nueva funcionalidad tienes que refrescar
el navegador y pulsar sobre el botón +. Deberías ver algo:
Notas con un más
Si estuviésemos utilizando un backend podríamos lanzar una consulta y
capturar el id de la respuesta. De momento es suficiente con generar una
entrada y un id aleatorio.
Podríamos utilizar this.setState({notes: [...this.state.notes,
{id: uuid.v4(), task: 'New task'}]}) para conseguir el mismo
resultado. Este operador de propagación8 puede ser utilizado también con
funciones recibidas como parámetros. Mira el apéndice Características
del Lenguaje para más información.
8https://developer.mozilla.org/es/docs/Web/JavaScript/Referencia/Operadores/Spread_operator

-- 49 of 226 --

Implementando una Aplicación de Notas 32
El autobind-decorator9 puede ser una alternativa válida a la hora de inicia-
lizar propiedades. En ese caso podríamos utilizar la anotación @autobind
a nivel de clase o de método. Para aprender más sobre decoradores echa
un vistazo al apéndice Entendiendo los Decoradores.