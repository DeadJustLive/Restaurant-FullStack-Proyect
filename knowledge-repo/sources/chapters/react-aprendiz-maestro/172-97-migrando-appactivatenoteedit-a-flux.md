# 9.7 Migrando App.activateNoteEdit a Flux

App.activateNoteEdit es básicamente una operación de actualización. Necesitamos
cambiar el flag editing de la nota a true, lo cual iniciará el proceso de edición. Como
siempre, deberemos migrar App primero:
app/components/App.jsx
...
class App extends React.Component {
...
activateNoteEdit = (id) => {
this.setState({
notes: this.state.notes.map(note => {
if(note.id === id) {
note.editing = true;
}

-- 112 of 226 --

Implementando NoteStore y NoteActions 95
return note;
})
});
this.props.NoteActions.update({id, editing: true});
}
...
}
...
Si refrescas y tratas de editar una nota verás un mensaje como el siguiente en la
consola del navegador:
update note Object {id: "2c91ba0f-12f5-4203-8d60-ea673ee00e03", edit\
ing: true}
Todavía necesitamos aplicar el cambio para hacer que esto funcione. La lógica es la
misma que la que teniamos anteriormente en App con la excepción de que lo hemos
generalizado usando Object.assign:
app/stores/NoteStore.js
import uuid from 'uuid';
import NoteActions from '../actions/NoteActions';
export default class NoteStore {
...
update(updatedNote) {
console.log('update note', updatedNote);
this.setState({
notes: this.notes.map(note => {
if(note.id === updatedNote.id) {
return Object.assign({}, note, updatedNote);
}

-- 113 of 226 --

Implementando NoteStore y NoteActions 96
return note;
})
});
}
...
}
Ahora debería ser posible comenzar a editar notas, aunque si terminas de edi-
tarlas verás un error como Uncaught TypeError: Cannot read property 'notes'
of null. Esto se debe a que nos falta la parte final de la migración: cambiar
App.editNote.