# 6.6 Implementación de Edit

## Fuente
react-aprendiz-maestro (Cap. 60)

## Contenido
# 6.6 Implementación de Edit

Nos falta algo que haga que esto funcione. Incluso aunque ahora podemos gestionar el
estado de editing de cada Nota, todavía no podemos editarlas. Para ello necesitamos
expandir Edit y hacer que muestre una caja de texto.
En este caso estaremos utilizando un diseño no controlado y obtendremos el valor
de la caja de texto del árbol DOM sólo si lo necesitamos.
Fíjate en el código siguiente para ver la implementación completa. Observa cómo
estamos gestionando el fin de la edición, capturamos onKeyPress y comprobamos si
han pulsado Enter para confirmar la edición. También tenemos en cuenta al evento
onBlur para saber cuándo la entrada de texto pierde el foco.
app/components/Editable.jsx
...
export default ({editing, value, onEdit, ...props}) => {
if(editing) {
return <Edit value={value} onEdit={onEdit} {...props} />;
}
return <span {...props}>value: {value}</span>;
return <span {...props}>{value}</span>;
}
const Edit = ({onEdit = () => {}, value, ...props}) => (
<div onClick={onEdit} {...props}>
<span>edit: {value}</span>
</div>
);
class Edit extends React.Component {
render() {
const {value, onEdit, ...props} = this.props;

-- 71 of 226 --

Edición de Notas 54
return <input
type="text"
autoFocus={true}
defaultValue={value}
onBlur={this.finishEdit}
onKeyPress={this.checkEnter}
{...props} />;
}
checkEnter = (e) => {
if(e.key === 'Enter') {
this.finishEdit(e);
}
}
finishEdit = (e) => {
const value = e.target.value;
if(this.props.onEdit) {
this.props.onEdit(value);
}
}
}
Si refrescas y editas una nota deberías ver lo siguiente:
Editando una Nota

-- 72 of 226 --

Edición de Notas 55
