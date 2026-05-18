# 12.2 Implementando el Borrado de Carril

El borrado de carriles en un problema parecido. Necesitamos poner más cosas en la
interfaz de usuario, añadir una acción y asociarle lógica.
La interfaz del usuario es un lugar natural en el que comenzar. A menudo es una
buena idea añadir algunos console.log en ciertos lugares para estar seguro de que
los manejadores se ejecutan cuando esperas. Puede ser incluso mejor que escribas
tests para ellos. De este modo acabarás con una especificación ejecutable. Aquí tienes
un esqueleto con el que poder borrar carriles:
app/components/LaneHeader.jsx

-- 148 of 226 --

Editando los Carriles 131
...
export default connect(() => ({}), {
NoteActions,
LaneActions
})(({lane, LaneActions, NoteActions, ...props}) => {
...
const deleteLane = e => {
// Evita que se ejecuten los eventos naturales de javascript del\
componente
e.stopPropagation();
LaneActions.delete(lane.id);
};
return (
<div className="lane-header" onClick={activateLaneEdit} {...prop\
s}>
<div className="lane-add-note">
<button onClick={addNote}>+</button>
</div>
<Editable className="lane-name" editing={lane.editing}
value={lane.name} onEdit={editName} />
<div className="lane-delete">
<button onClick={deleteLane}>x</button>
</div>
</div>
);
});
De nuevo, necesitamos agrandar nuestra definición de acción:
app/actions/LaneActions.js

-- 149 of 226 --

Editando los Carriles 132
import alt from '../libs/alt';
export default alt.generateActions(
'create', 'update', 'delete', 'attachToLane', 'detachFromLane'
);
Y, para finalizar con la implementación, tenemos que añadir algo de lógica:
app/stores/LaneStore.js
import LaneActions from '../actions/LaneActions';
export default class LaneStore {
constructor() {
this.bindActions(LaneActions);
this.lanes = [];
}
create(lane) {
...
}
update(updatedLane) {
...
}
delete(id) {
this.setState({
lanes: this.lanes.filter(lane => lane.id !== id)
});
}
...
}
Si todo ha ido correctamente ahora deberías ser capaz de borrar carriles enteros.
La implementación actual tiene un problema. Aunque estamos borrando las refe-
rencias con los carriles, las notas todavía existen. Esto lo podemos arreglar de dos

-- 150 of 226 --

Editando los Carriles 133
maneras: creando una papelera donde ir dejando esta basura y borrarla cada cierto
tiempo o podemos borrar las notas junto con el carril. Sin embargo, para el ámbito
de esta aplicación vamos a dejarlo como está, es una mejora de lo que tendremos que
ser conscientes.