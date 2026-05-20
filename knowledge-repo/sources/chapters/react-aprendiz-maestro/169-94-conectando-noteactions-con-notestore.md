# 9.4 Conectando NoteActions con NoteStore

Alt facilita un par de formas útiles con las que conectar acciones con almacenes:

-- 106 of 226 --

Implementando NoteStore y NoteActions 89
• this.bindAction(NoteActions.CREATE, this.create) - Enlaza una acción
específica con un método específico.
• this.bindActions(NoteActions)- Enlaza todas las acciones con métodos por
convención. Es decir, la acción create se enlazará con un método llamado
create.
• reduce(state, { action, data }) - Es posible implementar un método co-
nocido como reductor, el cual imita la forma de trabajar de los reductores de
Redux. La idea es devolver un nuevo estado basado en el estado actual y unos
datos.
Utilizaremos this.bindActions en caso de que confiar en la convención sea sufi-
ciente. Modifica el almacén como sigue para conectar las acciones y añadir datos
iniciales a la lógica:
app/stores/NoteStore.js
import uuid from 'uuid';
import NoteActions from '../actions/NoteActions';
export default class NoteStore {
constructor() {
this.bindActions(NoteActions);
this.notes = [
{
id: uuid.v4(),
task: 'Learn React'
},
{
id: uuid.v4(),
task: 'Do laundry'
}
];
}
create(note) {
console.log('create note', note);

-- 107 of 226 --

Implementando NoteStore y NoteActions 90
}
update(updatedNote) {
console.log('update note', updatedNote);
}
delete(id) {
console.log('delete note', id);
}
}
Para poder verlo en funcionamiento necesitamos conectar nuestras acciones con App
y adaptar la lógica.