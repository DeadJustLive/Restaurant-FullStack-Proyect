# 13.7 Arrastrando Notas sobre Carriles Vacíos

Para arrastrar notas sobre carriles vaciós necesitamos permitirles el poder recibir
notas. Al igual que antes, podemos configurar una lógica basada en DropTarget para

-- 169 of 226 --

Implementado Arrastrar y Soltar 152
ello. Antes de nada, necesitamos capturar el hecho de arrastrar en Carril:
app/components/Lane.jsx
import React from 'react';
import {compose} from 'redux';
import {DropTarget} from 'react-dnd';
import ItemTypes from '../constants/itemTypes';
import connect from '../libs/connect';
import NoteActions from '../actions/NoteActions';
import LaneActions from '../actions/LaneActions';
import Notes from './Notes';
import LaneHeader from './LaneHeader';
const Lane = ({
lane, notes, LaneActions, NoteActions, ...props
connectDropTarget, lane, notes, LaneActions, NoteActions, ...props
}) => {
...
return (
return connectDropTarget(
...
);
};
function selectNotesByIds(allNotes, noteIds = []) {
...
}
const noteTarget = {
hover(targetProps, monitor) {
const sourceProps = monitor.getItem();
const sourceId = sourceProps.id;
// Si el carril destino no tiene notas

-- 170 of 226 --

Implementado Arrastrar y Soltar 153
// le damos la nota.
//
// `attachToLane` hace la limpieza necesaria
// por defecto y garantiza que una nota sólo
// pueda pertenecar a un carril
if(!targetProps.lane.notes.length) {
LaneActions.attachToLane({
laneId: targetProps.lane.id,
noteId: sourceId
});
}
}
};
export default connect(
({notes}) => ({
notes
}), {
NoteActions,
LaneActions
}
)(Lane)
export default compose(
DropTarget(ItemTypes.NOTE, noteTarget, connect => ({
connectDropTarget: connect.dropTarget()
})),
connect(({notes}) => ({
notes
}), {
NoteActions,
LaneActions
})
)(Lane)
Debería ser capaz de poder arrastrar notas a carriles vacios una vez hayas añadido
esta lógica.

-- 171 of 226 --

Implementado Arrastrar y Soltar 154
Nuesta implementación de attachToLane hace gran parte del trabajo duro por
nosotros. Si no garantizase que una nota sólo puede pertenecer a un carril nuestra
lógica debería ser modificada. Es bueno tener este tipo de certezas dentro del sistema
de gestión de estados.
Solucionando el Modo de Edición durante el Arrastre
La implementación actual tiene un pequeño problema. Puedes arrastrar una nota
mientras esta está siendo editada. Esto no es conveniente ya que no es lo que la
mayoría de la gente espera poder hacer. No puedes, por ejemplo, hacer doble click en
la caja de texto para seleccionar todo su contenido.
Por suerte es fácil de arreglar. Necesitamos usar el estado editing de cada Nota para
ajustar su comportamiento. Lo primero que necesitamos es pasar el estado editing
a una Nota individual:
app/components/Notes.jsx
import React from 'react';
import Note from './Note';
import Editable from './Editable';
import LaneActions from '../actions/LaneActions';
export default ({
notes,
onNoteClick=() => {}, onEdit=() => {}, onDelete=() => {}
}) => (
<ul className="notes">{notes.map(({id, editing, task}) =>
<li key={id}>
<Note className="note" id={id}
editing={editing}
onClick={onNoteClick.bind(null, id)}
onMove={LaneActions.move}>
<Editable
className="editable"
editing={editing}

-- 172 of 226 --

Implementado Arrastrar y Soltar 155
value={task}
onEdit={onEdit.bind(null, id)} />
<button
className="delete"
onClick={onDelete.bind(null, id)}>x</button>
</Note>
</li>
)}</ul>
)
Lo siguiente será tenerlo en cuenta a la hora de renderizar:
app/components/Note.jsx
import React from 'react';
import {compose} from 'redux';
import {DragSource, DropTarget} from 'react-dnd';
import ItemTypes from '../constants/itemTypes';
const Note = ({
connectDragSource, connectDropTarget, isDragging,
isOver, onMove, id, children, ...props
isOver, onMove, id, editing, children, ...props
}) => {
// Pass through if we are editing
const dragSource = editing ? a => a : connectDragSource;
return compose(connectDragSource, connectDropTarget)(
return compose(dragSource, connectDropTarget)(
<div style={{
opacity: isDragging || isOver ? 0 : 1
}} {...props}>{children}</div>
);
};
...

-- 173 of 226 --

Implementado Arrastrar y Soltar 156
Este pequeño cambio nos dá el comportamiento que queremos. Si tratas de editar
una nota ahora, la caja de texto se comportará como esperas.
Mirando hacia atrás podemos ver que mantener el estado editing fuera de Editable
fue una buena idea. Si no lo hubiésemos hecho así, implementar este cambio habría
sido bastante más difícil ya que tendríamos que poder sacar el estado fuera del
componente.
¡Por fin tenemos un tablero Kanban que es útil!. Podemos crear carriles y notas
nuevas, y también podemos editarlas y borrarlas. Además podemos movar las notas.
¡Objetivo cumplido!