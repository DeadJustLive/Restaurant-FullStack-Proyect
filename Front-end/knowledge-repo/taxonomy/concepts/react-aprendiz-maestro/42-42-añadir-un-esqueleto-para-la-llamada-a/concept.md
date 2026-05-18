# 4.2 Añadir un Esqueleto para la Llamada a

## Fuente
react-aprendiz-maestro (Cap. 42)

## Contenido
# 4.2 Añadir un Esqueleto para la Llamada a

onDelete
Necesitamos extender las capacidades de Nota para capturar la intención de borrarla
incluyendo una acción que se ejecute al llamar a onDelete. Presta atención al
siguiente código:
app/components/Note.jsx

-- 52 of 226 --

Borrado de Notas 35
import React from 'react';
export default ({task}) => <div>{task}</div>;
export default ({task, onDelete}) => (
<div>
<span>{task}</span>
<button onClick={onDelete}>x</button>
</div>
);
Deberias ver una pequeña “x” después de cada nota:
Notas con controles de borrado
Todavía no harán nada, arreglarlo es el siguiente paso.
