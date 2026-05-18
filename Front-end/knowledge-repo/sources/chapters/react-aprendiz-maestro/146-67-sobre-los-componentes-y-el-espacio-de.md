# 6.7 Sobre los Componentes y el Espacio de

Nombres
Podríamos haber abordado Editable de una forma diferente. En una edición anterior
de este libro lo creé como un único componente. Lo hice mostrando el valor y el
control de edición a través de métodos (esto es, mediante renderValue). A menudo,
el nombrado de métodos como el anterior es una pista de que es posible refactorizar
el código y extraer componentes como hicimos anteriormente.
Puedes ir un paso más adelante y colocar las partes de los componentes en un
espacio de nombres2. De este modo habría sido posible definir los componentes
Editable.Value y Editable.Edit. Mejor todavía, podríamos haber permitido al
usuario intercambiar ambos componentes entre sí mediante props. Dado que la
interfaz es la misma, los componentes deberían funcionar. Esto nos da una dimensión
extra de personalización.
Llevándolo a la implementación, podemos tener algo como lo siguiente haciendo uso
del espacio de nombres:
app/components/Editable.jsx
import React from 'react';
// Podemos conseguir que la edición y la presentación del valor se i\
ntercambien mediante props
const Editable = ({editing, value, onEdit}) => {
if(editing) {
return <Editable.Edit value={value} onEdit={onEdit} />;
}
return <Editable.Value value={value} />;
};
Editable.Value = ({value, ...props}) => <span {...props}>{value}</sp\
an>
2https://facebook.github.io/react/docs/jsx-in-depth.html#namespaced-components

-- 73 of 226 --

Edición de Notas 56
class Edit extends React.Component {
...
}
Editable.Edit = Edit;
// También podemos exportar componentes individuales para permitir l\
a modificación
export default Editable;
Puedes utilizar una aproximación similar para definir otros componentes más gené-
ricos. Considera algo como Form, puedes fácilmente tener Form.Label, Form.Input,
Form.Textarea, etcétera. Cada uno contendrá un formato concreto y la lógica que
necesite. Es una forma de hacer que tus diseños sean más flexibles.