# 6.5 Haciendo un Seguimiento del Estado

## Fuente
react-aprendiz-maestro (Cap. 59)

## Contenido
# 6.5 Haciendo un Seguimiento del Estado

editing de Nota
Todavía nos falta la lógica necesaria para controlar Editable. Dado que el estado
de nuestra aplicación está siendo mantenido en App, necesitaremos hacer cosas allí.
Debería marcar el valor editable de una nota a true cuando comience con la edición
y a false cuando el proceso de edición termine. También debería ajustar el valor de
task al nuevo valor. De momento sólo estamos interesados en conseguir que el valor
de editable funcione correctamente. Realizamos los siguientes cambios:
app/components/App.jsx
...
export default class App extends React.Component {
constructor(props) {
...
}
render() {
const {notes} = this.state;
return (

-- 68 of 226 --

Edición de Notas 51
<div>
<button onClick={this.addNote}>+</button>
<Notes notes={notes} onDelete={this.deleteNote} />
<Notes
notes={notes}
onNoteClick={this.activateNoteEdit}
onEdit={this.editNote}
onDelete={this.deleteNote}
/>
</div>
);
}
addNote = () => {
...
}
deleteNote = (id, e) => {
...
}
activateNoteEdit = (id) => {
this.setState({
notes: this.state.notes.map(note => {
if(note.id === id) {
note.editing = true;
}
return note;
})
});
}
editNote = (id, task) => {
this.setState({
notes: this.state.notes.map(note => {
if(note.id === id) {
note.editing = false;
note.task = task;

-- 69 of 226 --

Edición de Notas 52
}
return note;
})
});
}
}
Si tratas de editar una Nota ahora verás algo como lo siguiente:
Seguimiento del estado editing
Si pulsas en Nota dos veces para confirmar la edición verás un error llamado Uncaught
Invariant Violation en la consola del navegador. Este ocurre porque todavía no
hemos terminado de gestionar task correctamente. Esto es algo que deberemos
arreglar a continuación.
Si usamos una estructura de datos normalizada (por ejemplo, {<id>:
{id: <id>, task: <str>}}), es posible implementar las operaciones con
Object.assign y evitar la mutación.
Para tener el código más limpio puedes extraer un método que contenga
la lógica compartida por activateNoteEdit y por editNote.

-- 70 of 226 --

Edición de Notas 53
