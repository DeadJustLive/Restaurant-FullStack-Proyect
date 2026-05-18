# 3. Lanzar la llmada a hover cuando se ejecute onMove par que podamos incluir

la lógica en algún sitio. LaneStore puede ser el mejor lugar para ello.
Siguiendo la idea anterior podemos pasar el identificador de la Nota mediante una
propiedad. También necesitaremos crear un esqueleto para la llamada a onMove y
definir LaneActions.move y LaneStore.move.
Aceptando id y onMove en Nota
Podemos aceptar las propiedades id y onMove en Nota como sigue:
app/components/Note.jsx
...
const Note = ({
connectDragSource, connectDropTarget,
children, ...props
onMove, id, children, ...props
}) => {
return compose(connectDragSource, connectDropTarget)(
<div {...props}>
{children}
</div>
);
};
const noteSource = {
beginDrag(props) {
console.log('begin dragging note', props);
return {};
}

-- 161 of 226 --

Implementado Arrastrar y Soltar 144
};
const noteSource = {
beginDrag(props) {
return {
id: props.id
};
}
};
const noteTarget = {
hover(targetProps, monitor) {
const sourceProps = monitor.getItem();
console.log('dragging note', sourceProps, targetProps);
}
};
const noteTarget = {
hover(targetProps, monitor) {
const targetId = targetProps.id;
const sourceProps = monitor.getItem();
const sourceId = sourceProps.id;
if(sourceId !== targetId) {
targetProps.onMove({sourceId, targetId});
}
}
};
...
Tener esas propiedades no es útil si no pasamos nada a Notas. Ese será nuestro
siguiente paso.
Pasando id y onMove desde Notes
Pasar el id de una nota y onMove es sencillo:

-- 162 of 226 --

Implementado Arrastrar y Soltar 145
app/components/Notes.jsx
import React from 'react';
import Note from './Note';
import Editable from './Editable';
export default ({
notes,
onNoteClick=() => {}, onEdit=() => {}, onDelete=() => {}
}) => (
<ul className="notes">{notes.map(({id, editing, task}) =>
<li key={id}>
<Note className="note" onClick={onNoteClick.bind(null, id)}>
<Note className="note" id={id}
onClick={onNoteClick.bind(null, id)}
onMove={({sourceId, targetId}) =>
console.log('moving from', sourceId, 'to', targetId)}>
<Editable
className="editable"
editing={editing}
value={task}
onEdit={onEdit.bind(null, id)} />
<button
className="delete"
onClick={onDelete.bind(null, id)}>x</button>
</Note>
</li>
)}</ul>
)
Si mueves una nota encima de otra verás mensajes por consola como el siguiente:
moving from 3310916b-5b59-40e6-8a98-370f9c194e16 to 939fb627-1d56-4b\
57-89ea-04207dbfb405

-- 163 of 226 --

Implementado Arrastrar y Soltar 146