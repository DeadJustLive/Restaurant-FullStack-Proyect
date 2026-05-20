# 7.3 Aplicando Estilos sobre Notas Individuales

Todavía quedan cosas relacionadas con Notas pendientes de estilizar. Antes de in-
sertar reglas debemos asegurarnos de que tenemos unos buenos puntos de enganche
para ello en Editable:
app/components/Editable.jsx
import React from 'react';
import classnames from 'classnames';
export default ({editing, value, onEdit, ...props}) => {
export default ({editing, value, onEdit, className, ...props}) => {
if(editing) {
return <Edit value={value} onEdit={onEdit} {...props} />;
return <Edit
className={className}
value={value}
onEdit={onEdit}
{...props} />;
}
return <span {...props}>{value}</span>;
return <span className={classnames('value', className)} {...props}>
{value}

-- 78 of 226 --

Dando Estilo a la Aplicación de Notas 61
</span>;
}
class Edit extends React.Component {
render() {
const {value, onEdit, ...props} = this.props;
const {className, value, onEdit, ...props} = this.props;
return <input
type="text"
className={classnames('edit', className)}
autoFocus={true}
defaultValue={value}
onBlur={this.finishEdit}
onKeyPress={this.checkEnter}
{...props} />;
}
...
}
Puede que className sea difícil de manejar ya que sólo acepta un string y quizá
queramos insertarle más de una clase. En este punto puede ser útil un paquete
conocido como classnames1. Este paquete acepta muchos tipos de entradas y los
convierte a un único string para resolver el problema.
Hay suficientes clases para diseñar el resto ahora. Podemos mostrar una sombra
debajo de la nota si ponemos el ratón por encima. También es un buen momento
para mostrar el control de borrado al mover el cursor por encima. Por desgracia estos
estilos no se mostrarán en interfaces táctiles, pero son lo suficientemente buenos para
esta demo:
app/main.css
1https://www.npmjs.org/package/classnames

-- 79 of 226 --

Dando Estilo a la Aplicación de Notas 62
...
.note {
overflow: auto;
margin-bottom: 0.5em;
padding: 0.5em;
background-color: #fdfdfd;
box-shadow: 0 0 0.3em .03em rgba(0,0,0,.3);
}
.note:hover {
box-shadow: 0 0 0.3em .03em rgba(0,0,0,.7);
transition: .6s;
}
.note .value {
/* force to use inline-block so that it gets minimum height */
display: inline-block;
}
.note .editable {
float: left;
}
.note .delete {
float: right;
padding: 0;
background-color: #fdfdfd;
border: none;
cursor: pointer;

-- 80 of 226 --

Dando Estilo a la Aplicación de Notas 63
visibility: hidden;
}
.note:hover .delete {
visibility: visible;
}
Si todo ha ido bien tu aplicación debería tener el siguiente aspecto:
La aplicación de Notas con estilo