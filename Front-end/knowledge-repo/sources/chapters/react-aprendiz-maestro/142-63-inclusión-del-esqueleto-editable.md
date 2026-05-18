# 6.3 Inclusión del Esqueleto Editable

Podemos definir un punto por el que comenzar basándonos en la especificación que
sigue. La idea es que hagamos una cosa u otra basándonos en la propiedad editing
y que hagamos lo necesario para implementar nuestra lógica:
app/components/Editable.jsx
import React from 'react';
export default ({editing, value, onEdit, ...props}) => {
if(editing) {
return <Edit value={value} onEdit={onEdit} {...props} />;
}
return <span {...props}>value: {value}</span>;
}
const Edit = ({onEdit = () => {}, value, ...props}) => (
<div onClick={onEdit} {...props}>
<span>edit: {value}</span>
</div>
);
Para ver el esqueleto en acción todavía necesitamos conectarlo con nuestra aplica-
ción.

-- 66 of 226 --

Edición de Notas 49