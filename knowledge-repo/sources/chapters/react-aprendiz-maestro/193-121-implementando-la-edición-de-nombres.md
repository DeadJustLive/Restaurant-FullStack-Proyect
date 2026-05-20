# 12.1 Implementando la Edición de Nombres

de Carril
Para editar el nombre de un Carril necesitaremos algo de lógica y puntos de
enganche con el UI. Editable puede encargarse del UI, la lógica nos dará algo más
de trabajo. Para comenzar, deja LaneHeader como sigue:
app/components/LaneHeader.jsx

-- 145 of 226 --

Editando los Carriles 128
import React from 'react';
import uuid from 'uuid';
import connect from '../libs/connect';
import NoteActions from '../actions/NoteActions';
import LaneActions from '../actions/LaneActions';
import Editable from './Editable';
export default connect(() => ({}), {
NoteActions,
LaneActions
})(({lane, LaneActions, NoteActions, ...props}) => {
const addNote = e => {
...
};
const activateLaneEdit = () => {
LaneActions.update({
id: lane.id,
editing: true
});
};
const editName = name => {
LaneActions.update({
id: lane.id,
name,
editing: false
});
};
return (
<div className="lane-header" {...props}>
<div className="lane-header" onClick={activateLaneEdit} {...prop\
s}>
<div className="lane-add-note">
<button onClick={addNote}>+</button>
</div>

-- 146 of 226 --

Editando los Carriles 129
<div className="lane-name">{lane.name}</div>
<Editable className="lane-name" editing={lane.editing}
value={lane.name} onEdit={editName} />
</div>
);
})
La interfaz de usuario debería tener el mismo aspecto tras este cambio. Todavía
necesitamos implementar LaneActions.update para hacer que esto funcione.
Igual que antes, tenemos que hacer cambios en dos sitios, en la definición de la acción
y en LaneStore. Aquí tenemos la parte de la acción:
app/actions/LaneActions.js
import alt from '../libs/alt';
export default alt.generateActions(
'create', 'update', 'attachToLane', 'detachFromLane'
);
Para añadir la lógica que falta, modifica LaneStore de este modo. La idea es la misma
que la de NoteStore:
app/stores/LaneStore.js
import LaneActions from '../actions/LaneActions';
export default class LaneStore {
constructor() {
this.bindActions(LaneActions);
this.lanes = [];
}
create(lane) {
...

-- 147 of 226 --

Editando los Carriles 130
}
update(updatedLane) {
this.setState({
lanes: this.lanes.map(lane => {
if(lane.id === updatedLane.id) {
return Object.assign({}, lane, updatedLane);
}
return lane;
})
});
}
...
}
Tras estos cambios deberías ser capaz de editar los nombres de los carriles. El borrado
de carriles es una buena característica con la que seguir.