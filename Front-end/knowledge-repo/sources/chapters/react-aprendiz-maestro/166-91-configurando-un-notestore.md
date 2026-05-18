# 9.1 Configurando un NoteStore

De momento mantenemos el estado de la aplicación en App. El primer paso para
llevarlo a Alt es definir un almacén y utilizar el estado desde allí. Esto romperá con
la lógica de nuestra aplicación de forma temporal ya que necesitamos llevar el estado
también a Alt. Sin embargo, crear este almacén inicial es un buen paso para cumplir
con nuestro objetivo.
Para configurar un almacén necesitamos llevar a cabo tres pasos. Necesitaremos
configurarlo, conectarlo con Alt en el Proveedor y, finalmente, conectarlo con App.
Los almacenes se modelan en Alt usando clases ES6. Aqui tienes una implementación
mínima modelada con nuestro estado actual.

-- 101 of 226 --

Implementando NoteStore y NoteActions 84
app/stores/NoteStore.js
import uuid from 'uuid';
export default class NoteStore {
constructor() {
this.notes = [
{
id: uuid.v4(),
task: 'Apender React'
},
{
id: uuid.v4(),
task: 'Hacer la Colada'
}
];
}
}
El siguiente paso es conectar el almacén con el Proveedor. Es aquí donde el módulo
setup se vuelve útil:
app/components/Provider/setup.js
export default alt => {}
import NoteStore from '../../stores/NoteStore';
export default alt => {
alt.addStore('NoteStore', NoteStore);
}
Podemos ajustar App para consumir los datos desde el almacén y así comprobar que lo
que hemos hecho funciona. Esto romperá la lógica que tenemos, pero lo arreglaremos
en la próxima sección. Cambia App como sigue para hacer que notas esté disponible:
app/components/App.jsx

-- 102 of 226 --

Implementando NoteStore y NoteActions 85
...
class App extends React.Component {
constructor(props) {
super(props);
this.state = {
notes: [
{
id: uuid.v4(),
task: 'Aprender React'
},
{
id: uuid.v4(),
task: 'Hacer la Colada'
}
]
}
}
render() {
const {notes} = this.state;
const {notes} = this.props;
return (
<div>
{this.props.test}
<button className="add-note" onClick={this.addNote}>+</butto\
n>
<Notes
notes={notes}
onNoteClick={this.activateNoteEdit}
onEdit={this.editNote}
onDelete={this.deleteNote}
/>
</div>

-- 103 of 226 --

Implementando NoteStore y NoteActions 86
);
}
...
}
export default connect(() => ({
test: 'test'
}))(App)
export default connect(({notes}) => ({
notes
}))(App)
Si refrescas la aplicación verás exactamente lo mismo que antes. Esta vez, sin
embargo, estaremos consumiendo los datos desde nuestro almacén. Como resultado
nuestra lógica está rota. Esto es algo que tendremos que arreglar más adelante
mientras definimos NoteActions y llevamos la manipulación del estado a NoteStore.
Dado que App no dependerá más del estado, es posible convertirlo a un
componente basado en funciones. A menudo la mayoría de tus compo-
nentes estarán basados en funciones precisamente por esta razón. Si no
estás utilizando estado o referencias es seguro convertirlos a funciones.