# 11.3 Modelando Carril

Carril mostrará un nombre y Notas asociadas. El ejemplo que sigue tiene muchos
cambios desde nuestra implementación inicial de App. Cambia el contenido del
fichero y déjalo como sigue:
app/components/Lane.jsx
import React from 'react';
import uuid from 'uuid';
import connect from '../libs/connect';
import NoteActions from '../actions/NoteActions';
import Notes from './Notes';
const Lane = ({
lane, notes, NoteActions, ...props
}) => {
const editNote = (id, task) => {
NoteActions.update({id, task, editing: false});
};
const addNote = e => {
e.stopPropagation();

-- 129 of 226 --

Gestionado Dependencias de Datos 112
const noteId = uuid.v4();
NoteActions.create({
id: noteId,
task: 'New task'
});
};
const deleteNote = (noteId, e) => {
e.stopPropagation();
NoteActions.delete(noteId);
};
const activateNoteEdit = id => {
NoteActions.update({id, editing: true});
};
return (
<div {...props}>
<div className="lane-header">
<div className="lane-add-note">
<button onClick={addNote}>+</button>
</div>
<div className="lane-name">{lane.name}</div>
</div>
<Notes
notes={notes}
onNoteClick={activateNoteEdit}
onEdit={editNote}
onDelete={deleteNote} />
</div>
);
};
export default connect(

-- 130 of 226 --

Gestionado Dependencias de Datos 113
({notes}) => ({
notes
}), {
NoteActions
}
)(Lane)
Si ejecutas la aplicación e intentas añadir notas nuevas verás que algo va mal. Cada
nota que añades es compartida por todos los carriles. Si se modifica una nota, los
otros carriles se modifican también.
Duplicar notas
El motivo de por qué ocurre esto es sencillo. Nuestro NoteStore es un singleton, lo
que significa que todos los componentes que estén escuchando NoteStore recibirán
los mismos datos. Necesitamos resolver este problema de alguna manera.

-- 131 of 226 --

Gestionado Dependencias de Datos 114