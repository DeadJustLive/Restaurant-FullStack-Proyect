# 11.4 Haciendo que Carriles sea el Responsable

de Notas
Ahora mismo nuestro Carril sólo contiene un array de objetos. Cada uno de estos
objetos conoce su id y su nombre. Vamos a necesitar algo más sotisficado.
Cada Carril necesita saber qué Notas le pertenecen. Si un Carril contiene un array
de identificadores de Nota podrá filtrar y mostrar sólo las Notas que le pertenecen.
En breve implementaremos un esquema que permita esto.
Entendiendo attachToLane (añadir al carril)
Cuando añadimos una nueva Nota al sistema usando addNote, debemos asegurarnos
que está asociada a un Carril. Esta asociación puede ser modelada mediante un
método, como por ejemplo LaneActions.attachToLane({laneId: <id>, noteId:
<id>}). He aquí un ejemplo de cómo podría funcionar.
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
}
Esta es sólo una forma de gestionar noteId. Podemos llevar la lógica de generación
a NoteActions.create y devolver el identificador generado desde allí. Podemos

-- 132 of 226 --

Gestionado Dependencias de Datos 115
hacerlo mediante una Promesa1, lo cual puede ser muy útil si añadimos un backend
a nuestra implementación. Así es como quedaría:
const addNote = e => {
e.stopPropagation();
NoteActions.create({
task: 'New task'
}).then(noteId => {
LaneActions.attachToLane({
laneId: lane.id,
noteId: noteId
});
})
}
Hemos declarado una dependencia clara entre NoteActions.create y LaneAc-
tions.attachToLane. Esto podría ser una alternativa válida si, especialmente, quie-
res llevar la implementación más lejos.
Puedes modelar el API usando parámetros de forma posicional y termi-
nar teniendo LaneActions.attachToLane(laneId, note.id). Yo prefiero
pasar el objeto porque se lee bien y no hay que tener cuidado con el orden.
Otra forma de gestionar el problema de la dependencia puede ser utilizar
una característica del dispacher de Flux conocida como waitFor2. Es mejor
evitarlo si puedes. Además, gestores de estado como Redux hacen que sea
redundante. Usar Promesas como antes nos puede ayudar.
1https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise
2http://alt.js.org/guide/wait-for/

-- 133 of 226 --

Gestionado Dependencias de Datos 116
Configurando attachToLane
Para comenzar debemos añadir attachToLane a las acciones como hicimos antes:
app/actions/LaneActions.js
import alt from '../libs/alt';
export default alt.generateActions(
'create', 'attachToLane'
);
Para poder implementar attachToLane tenemos que buscar un carril que coincida
con el identificador del carril que hemos recibido y asociarle el identificador de la
nota. Es más, cada nota sólo debe pertenecer a un carril cada vez. Podemos hacer una
pequeña comprobación:
app/stores/LaneStore.js
import LaneActions from '../actions/LaneActions';
export default class LaneStore {
...
attachToLane({laneId, noteId}) {
this.setState({
lanes: this.lanes.map(lane => {
if(lane.notes.includes(noteId)) {
lane.notes = lane.notes.filter(note => note !== noteId);
}
if(lane.id === laneId) {
lane.notes = lane.notes.concat([noteId]);
}
return lane;
})

-- 134 of 226 --

Gestionado Dependencias de Datos 117
});
}
}
Ser únicamente capaz de incluir notas en un carril no es suficiente. También vamos
a necesitar poder sacarlas, lo cual ocurre cuando borramos notas.
En este punto podemos mostrar un mensaje de advertencia cuando
tratemos de incluir una nota en un carril que no exista. console.warn
será tu amigo en este caso.
Configurando detachFromLane
Podemos modelar de forma parecida la operación contraria detachFromLane usando
un API como el siguiente:
LaneActions.detachFromLane({noteId, laneId});
NoteActions.delete(noteId);
Al igual que con attachToLane, podemos modelar el API usan-
do parámetros de forma posicional para dejarlo de este modo:
LaneActions.detachFromLane(laneId, noteId).
De nuevo debemos configurar la acción:
app/actions/LaneActions.js

-- 135 of 226 --

Gestionado Dependencias de Datos 118
import alt from '../libs/alt';
export default alt.generateActions(
'create', 'attachToLane', 'detachFromLane'
);
La implementación se parece a attachToLane. En este caso, borraremos las notas que
se puedan encontrar dentro.
app/stores/LaneStore.js
import LaneActions from '../actions/LaneActions';
export default class LaneStore {
...
detachFromLane({laneId, noteId}) {
this.setState({
lanes: this.lanes.map(lane => {
if(lane.id === laneId) {
lane.notes = lane.notes.filter(note => note !== noteId);
}
return lane;
})
});
}
}
Dado que tenemos la lógica en su lugar, podemos comenzar la conexión con la
interfaz de usuario.
Es posible que detachFromLane no desvincule nada. Si se detecta este caso
puede ser una buena idea usar console.warn para hacer consciente al
desarrollador de lo que ocurre.

-- 136 of 226 --

Gestionado Dependencias de Datos 119
Conectando Carril con la Lógica
Para hacer que esto funcione necesitamos hacer cambios en un par de sitios:
• Cuando añadimos una nota, necesitamos vincularla con el carril actual.
• Cuando borramos una nota, necesitamos desvincularla del carril actual.
• Cuando renderizamos un carril necesitamos seleccionar las notas que le per-
tenecen. Es importante renderizar las notas en el orden en el cual pertenezcan
al carril. Esto requiere de algo de lógica extra.
Estos cambios implican modificar Carril como sigue:
app/components/Lane.jsx
import React from 'react';
import uuid from 'uuid';
import connect from '../libs/connect';
import NoteActions from '../actions/NoteActions';
import LaneActions from '../actions/LaneActions';
import Notes from './Notes';
const Lane = ({
lane, notes, NoteActions, ...props
lane, notes, LaneActions, NoteActions, ...props
}) => {
const editNote = (id, task) => {
...
};
const addNote = e => {
e.stopPropagation();
const noteId = uuid.v4();
NoteActions.create({
id: noteId,

-- 137 of 226 --

Gestionado Dependencias de Datos 120
task: 'New task'
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
<Notes
notes={notes}
notes={selectNotesByIds(notes, lane.notes)}
onNoteClick={activateNoteEdit}
onEdit={editNote}
onDelete={deleteNote} />
</div>

-- 138 of 226 --

Gestionado Dependencias de Datos 121
);
};
function selectNotesByIds(allNotes, noteIds = []) {
// `reduce` es un método poderoso que nos permite
// agrupar datos. Puedes implementar filter` y `map`
// dentro de él. Nosotros lo estamos usando para
// concatenar notas cuyos id coincidan
return noteIds.reduce((notes, id) =>
// Concatena ids que encajen al resultado
notes.concat(
allNotes.filter(note => note.id === id)
)
, []);
}
export default connect(
({notes}) => ({
notes
}), {
NoteActions
NoteActions,
LaneActions
}
)(Lane)
Si intentas utilizar la aplicación ahora verás que cada carril es capaz de mantener sus
propias notas:

-- 139 of 226 --

Gestionado Dependencias de Datos 122
Separate notes
La estructura actual nos permite mantener el singleton y una estructura de datos
plana. Lidiar con las referencias es un tanto tedioso, pero es consistente con la
arquitectura Flux. Puedes ver el mismo problema en la implementación con Redux3.
La implementación con MobX4 evita el problema completamente.
selectNotesByIds pudo haber sido escrita utilizando map y find.
En ese caso podrías haber acabado utilizando noteIds.map(id =>
allNotes.find(note => note.id === id));. Sin embargo, tendrías que
haber utilizado el polyfill find para que funcione en navegadores viejos.
Normalizar los datos puede hacer que selectNotesByIds sea trivial. Si
estás usando una solución como Redux, la normalización puede hacer
fáciles operaciones como ésta.
3https://github.com/survivejs-demos/redux-demo
4https://github.com/survivejs-demos/mobx-demo

-- 140 of 226 --

Gestionado Dependencias de Datos 123