# 13.6 Implementando la Lógica de Arrastrar y

## Fuente
react-aprendiz-maestro (Cap. 128)

## Contenido
# 13.6 Implementando la Lógica de Arrastrar y

Soltar Notas
El movimiento dentro de un mismo carril es complicado. Cuando estás basando las
operaciones en ids y haces las operaciones una a una, tienes que tener en cuenta que
puede hacer alteraciones en el índice. Como resultado estoy usando update3 de React
para solucionar el problema de una pasada.
Es posible solucionar el caso de mover notas entre carriles usando splice4. Primero
obtenemos la nota a mover, y después la incorporamos al carril destino. De nuevo,
3https://facebook.github.io/react/docs/update.html
4https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Global_Objects/Array/splice

-- 166 of 226 --

Implementado Arrastrar y Soltar 149
update puede ser útil aquí, aunque en este caso splice está bien. El siguiente código
muestra una posible solución:
app/stores/LaneStore.js
import update from 'react-addons-update';
import LaneActions from '../actions/LaneActions';
export default class LaneStore {
...
move({sourceId, targetId}) {
console.log(`source: ${sourceId}, target: ${targetId}`);
}
move({sourceId, targetId}) {
const lanes = this.lanes;
const sourceLane = lanes.filter(lane => lane.notes.includes(sour\
ceId))[0];
const targetLane = lanes.filter(lane => lane.notes.includes(targ\
etId))[0];
const sourceNoteIndex = sourceLane.notes.indexOf(sourceId);
const targetNoteIndex = targetLane.notes.indexOf(targetId);
if(sourceLane === targetLane) {
// las mueve en bloque para evitar complicaciones
sourceLane.notes = update(sourceLane.notes, {
$splice: [
[sourceNoteIndex, 1],
[targetNoteIndex, 0, sourceId]
]
});
}
else {
// elimina la nota del origen
sourceLane.notes.splice(sourceNoteIndex, 1);
// y la mueve al objetivo

-- 167 of 226 --

Implementado Arrastrar y Soltar 150
targetLane.notes.splice(targetNoteIndex, 0, sourceId);
}
this.setState({lanes});
}
}
Si pruebas la aplicación ahora verás que puedes arrastrar notas y que el compor-
tamiento debería ser el correcto. Arrastrar a carriles vacíos no funcionará y la
presentación puede ser mejorada.
Podría ser mejor si indicásemos la localización de la nota arrastrada de forma más
clara. Podemos conseguirlo ocultándola de la lista. React DnD nos dá los puntos de
enganche que necesitamos para conseguirlo.
Indicando Dónde Mover
React DnD tiene una cualidad conocida como monitores de estado. Con ellos
podemos usar monitor.isDragging() y monitor.isOver() para detectar qué Nota
es la que estamos arrastrando. Podemos configurarlo como sigue:
app/components/Note.jsx
import React from 'react';
import {compose} from 'redux';
import {DragSource, DropTarget} from 'react-dnd';
import ItemTypes from '../constants/itemTypes';
const Note = ({
connectDragSource, connectDropTarget,
onMove, id, children, ...props
connectDragSource, connectDropTarget, isDragging,
isOver, onMove, id, children, ...props
}) => {
return compose(connectDragSource, connectDropTarget)(
<div {...props}>

-- 168 of 226 --

Implementado Arrastrar y Soltar 151
{children}
</div>
<div style={{
opacity: isDragging || isOver ? 0 : 1
}} {...props}>{children}</div>
);
};
...
export default compose(
DragSource(ItemTypes.NOTE, noteSource, connect => ({
connectDragSource: connect.dragSource()
})),
DropTarget(ItemTypes.NOTE, noteTarget, connect => ({
connectDropTarget: connect.dropTarget()
}))
DragSource(ItemTypes.NOTE, noteSource, (connect, monitor) => ({
connectDragSource: connect.dragSource(),
isDragging: monitor.isDragging()
})),
DropTarget(ItemTypes.NOTE, noteTarget, (connect, monitor) => ({
connectDropTarget: connect.dropTarget(),
isOver: monitor.isOver()
}))
)(Note)
Si arrastras una nota por un carril, la nota arrastrada se mostrará en blanco.
Hay un pequeño problema con nuestro sistema. Todavía no podemos arrastrar notas
sobre un carril vacío.
