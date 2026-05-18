# 7.1 Aplicando Estilo sobre el Botón “Añadir

Nota”
Para dar estilo al botón “Añadir Nota” primero tenemos que asignarle una clase:
app/components/App.jsx
...
export default class App extends React.Component {
constructor(props) {
...
}
render() {
const {notes} = this.state;
return (
<div>
<button onClick={this.addNote}>+</button>

-- 75 of 226 --

Dando Estilo a la Aplicación de Notas 58
<button className="add-note" onClick={this.addNote}>+</butto\
n>
<Notes
notes={notes}
onNoteClick={this.activateNoteEdit}
onEdit={this.editNote}
onDelete={this.deleteNote}
/>
</div>
);
}
...
}
También necesitamos añadir el estilo correspondiente:
app/main.css
...
.add-note {
background-color: #fdfdfd;
border: 1px solid #ccc;
}
Una forma más general de gestionar esto podría ser crear un nuevo componente
Botón y darle estilo. Esto nos permitirá tener botones con estilo en toda la aplicación.