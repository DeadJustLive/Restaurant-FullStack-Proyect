# 11.5 Extrayendo LaneHeader (Cabecera de Carril)

de Carril
Carril está empezando a ser un componente demasiado grande. Tenemos la opor-
tunidad de partirlo para hacer que nuestra aplicación sea más fácil de mantener.
En concreto, la cabecera del carril puede ser un componente por sí mismo. Para
comenzar, define LaneHeader basándote en el código actual tal y como sigue:
app/components/LaneHeader.jsx
import React from 'react';
import uuid from 'uuid';
import connect from '../libs/connect';
import NoteActions from '../actions/NoteActions';
import LaneActions from '../actions/LaneActions';
export default connect(() => ({}), {
NoteActions,
LaneActions
})(({lane, LaneActions, NoteActions, ...props}) => {
const addNote = e => {
e.stopPropagation();
const noteId = uuid.v4();
NoteActions.create({
id: noteId,
task: 'New task'
});
LaneActions.attachToLane({
laneId: lane.id,
noteId
});
};

-- 141 of 226 --

Gestionado Dependencias de Datos 124
return (
<div className="lane-header" {...props}>
<div className="lane-add-note">
<button onClick={addNote}>+</button>
</div>
<div className="lane-name">{lane.name}</div>
</div>
);
})
Necesitamos conectar el componente que hemos extraido con Carril:
app/components/Lane.jsx
import React from 'react';
import uuid from 'uuid';
import connect from '../libs/connect';
import NoteActions from '../actions/NoteActions';
import LaneActions from '../actions/LaneActions';
import Notes from './Notes';
import LaneHeader from './LaneHeader';
const Lane = ({
lane, notes, LaneActions, NoteActions, ...props
}) => {
const editNote = (id, task) => {
NoteActions.update({id, task, editing: false});
};
const addNote = e => {
e.stopPropagation();
const noteId = uuid.v4();
NoteActions.create({
id: noteId,
task: 'New task'

-- 142 of 226 --

Gestionado Dependencias de Datos 125
});
LaneActions.attachToLane({
laneId: lane.id,
noteId
});
};
const deleteNote = (noteId, e) => {
e.stopPropagation();
LaneActions.detachFromLane({
laneId: lane.id,
noteId
});
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
<LaneHeader lane={lane} />
<Notes
notes={selectNotesByIds(notes, lane.notes)}
onNoteClick={activateNoteEdit}
onEdit={editNote}
onDelete={deleteNote} />
</div>
);

-- 143 of 226 --

Gestionado Dependencias de Datos 126
};
...
Tras estos cambios tendremos algo con lo que es un poco más fácil trabajar.
Podría haber sido posible mantener todo el código en un único componente. A
menudo reflexionarás y te darás cuenta de que hay mejores maneras de dividir tus
componentes. A menudo la necesidad de reutilizar o de mejorar el rendimiento serán
quienes te fuercen a realizar estas divisiones.