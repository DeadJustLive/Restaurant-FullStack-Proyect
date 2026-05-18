# 7.2 Aplicando estilos sobre Notas

## Fuente
react-aprendiz-maestro (Cap. 66)

## Contenido
# 7.2 Aplicando estilos sobre Notas

Actualmente la lista de Notas está en crudo. Podemos mejorarla ocultando los estilos
específicos de las listas. También podemos ajustar el ancho de Notas para que la
interfaz del usuario aguante bien si un usuario introduce una tarea larga. Un buen
primer paso es incluir algunas clases en Notas que la hagan más fácil de estilizar:
app/components/Notes.jsx

-- 76 of 226 --

Dando Estilo a la Aplicación de Notas 59
import React from 'react';
import Note from './Note';
import Editable from './Editable';
export default ({
notes,
onNoteClick=() => {}, onEdit=() => {}, onDelete=() => {}
}) => (
<ul>{notes.map(({id, editing, task}) =>
<ul className="notes">{notes.map(({id, editing, task}) =>
<li key={id}>
<Note onClick={onNoteClick.bind(null, id)}>
<Note className="note" onClick={onNoteClick.bind(null, id)}>
<Editable
className="editable"
editing={editing}
value={task}
onEdit={onEdit.bind(null, id)} />
<button onClick={onDelete.bind(null, id)}>x</button>
<button
className="delete"
onClick={onDelete.bind(null, id)}>x</button>
</Note>
</li>
)}</ul>
)
Para eliminar los estilos específicos de las listas podemos aplicar las reglas siguientes:
app/main.css

-- 77 of 226 --

Dando Estilo a la Aplicación de Notas 60
...
.notes {
margin: 0.5em;
padding-left: 0;
max-width: 10em;
list-style: none;
}
