# 3.4 Añadiendo Nuevas Notas a la Lista

## Fuente
react-aprendiz-maestro (Cap. 38)

## Contenido
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
t
