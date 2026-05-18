# 4.3 Comunicar el Borrado a App

Ahora que tenemos los controles que necesitamos podemos comenzar a pensar en
cómo conectarlos con los datos de App. Para poder borrar una Nota necesitamos
conocer su id. Tras ello podremos implementar la lógica que se encarga de borrarlas
en App. Para que te hagas una idea, queremos encontrarnos en una situación como
la siguiente:

-- 53 of 226 --

Borrado de Notas 36
flujo de onDelete
La e representa un evento DOM al que deberias acostumbrarte. Podemos
hacer cosas como parar la propagación de eventos con él. Esto se volverá
más útil a medida que queramos tener más control sobre el comporta-
miento de la aplicación.
bind1 nos permite definir el contexto de la función (el primer parámetro)
y los argumentos (el resto de parámetros). Esta técnica se conoce con el
nombre de aplicación parcial.
Para conseguir todo esto vamos a necesitar una nueva propiedad en Notas. También
necesitaremos enlazar con bind el identificador de cada nota con la llamada a
onDelete para hacer obrar la magia. Aquí tienes la implementación completa de
Notas:
app/components/Notes.jsx
import React from 'react';
import Note from './Note';
export default ({notes}) => (
<ul>{notes.map(note =>
<li key={note.id}><Note task={note.task} /></li>
)}</ul>
)
export default ({notes, onDelete=() => {}}) => (
<ul>{notes.map(({id, task}) =>
1https://developer.mozilla.org/es/docs/Web/JavaScript/Referencia/Objetos_globales/Function/bind

-- 54 of 226 --

Borrado de Notas 37
<li key={id}>
<Note
onDelete={onDelete.bind(null, id)}
task={task} />
</li>
)}</ul>
)
He definido un valor de retorno ficticio para evitar que nuestro código falle si no se
proporciona un onDelete. Otra buena manera de conseguirlo es mediante el uso de
propTypes, tal y como se muestra en el capítulo Tipado con React.
Ahora que tenemos las cosas en su lugar podemos usarlas con App:
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
<button onClick={this.addNote}>+</button>
<Notes notes={notes} />
<Notes notes={notes} onDelete={this.deleteNote} />
</div>
);
}
addNote = () => {

-- 55 of 226 --

Borrado de Notas 38
...
}
deleteNote = (id, e) => {
// Dejar de procesar eventos para poder editar
e.stopPropagation();
this.setState({
notes: this.state.notes.filter(note => note.id !== id)
});
}
}
Deberías poder borrar notas una vez hayas refrescado el navegador. Anticipándome
al futuro he añadido la linea extra e.stopPropagation(). La idea subyacente es la
de indicar al DOM que tiene que dejar de procesar eventos. En resumidas cuentas,
vamos a evitar que se lancen otros eventos desde cualquier sitio que puedan afectar
a la estructura si estamos borrando notas.