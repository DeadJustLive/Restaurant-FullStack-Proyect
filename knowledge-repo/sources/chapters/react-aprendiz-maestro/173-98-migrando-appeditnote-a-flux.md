# 9.8 Migrando App.editNote a Flux

Esta parte final es sencilla. Ya tenemos la lógica que necesitamos, es sólo cuestión
de conectar App.editNote correctamente con ella. Necesitaremos invocar a nuestro
método update de una forma adecuada:
app/components/App.jsx
...
class App extends React.Component {
...
editNote = (id, task) => {
this.setState({
notes: this.state.notes.map(note => {
if(note.id === id) {
note.editing = false;
note.task = task;
}
return note;
})
});

-- 114 of 226 --

Implementando NoteStore y NoteActions 97
this.props.NoteActions.update({id, task, editing: false});
}
}
...
Tras refrescar el navegador deberías ser capaz de modificar tareas de nuevo y la
aplicación debería funcionar exactamente igual que antes. Modificar NoteStore
incluyendo acciones ha provocado una cascada de actualizaciones sobre App que
han hecho que todo se actualice mediante setState, lo que hará que el componente
invoque a render. Este es el flujo unidireccional de Flux en acción.
Realmente ahora tenemos más código que antes, pero eso no importa. App está un
poco más limpio y su desarollo es más fácil de continuar como veremos pronto. Lo
más importante es que nos hemos apañado para implementar la arquitectura Flux en
nuestra aplicación.
Nuestra implementación actual es ingenua en el sentido de que no valida
parámetros de ninguna forma. Puede ser una buena idea validar la forma
de los objetos para evitar problemas durante el desarrollo. Flow2 facilita
una forma gradual de hacerlo. Aparte, puedes hacer tests que prueben el
sistema.
¿Para qué sirve?
Integrar un gestor de estados supone mucho esfuerzo, pero no es en vano. Ten en
cuenta las siguiente preguntas: