# 4.1 Separación de Nota

Para mantener una lista de Nota que mantengan el mismo aspecto podemos mode-
larla utilizando un div de este modo:
app/components/Note.jsx
import React from 'react';
export default ({task}) => <div>{task}</div>;
Recuerda que esta declaración es equivalente a:
import React from 'react';
export default (props) => <div>{props.task}</div>;

-- 51 of 226 --

Borrado de Notas 34
Como puedes ver, destructurar reduce la cantidad de ruido del código y permite que
la implementación sea simple.
Para hacer que nuestra aplicación utilice el nuevo componente tenemos que hacer
cambios también en Notas:
app/components/Notes.jsx
import React from 'react';
import Note from './Note';
export default ({notes}) => (
<ul>{notes.map(note =>
<li key={note.id}>{note.task}</li>
<li key={note.id}><Note task={note.task} /></li>
)}</ul>
)
La aplicación debe tener el mismo aspecto que ya tenía antes de hacer los cambios,
pero hemos hecho hueco para poder meter más cosas más adelante.