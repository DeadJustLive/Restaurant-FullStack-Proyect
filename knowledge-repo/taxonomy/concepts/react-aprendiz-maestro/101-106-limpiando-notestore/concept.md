# 10.6 Limpiando NoteStore

## Fuente
react-aprendiz-maestro (Cap. 101)

## Contenido
# 10.6 Limpiando NoteStore

Antes de continuar es una buena idea limpiar NoteStore. Todavía queda algo de
código de experimentos anteriores. Dado que la persistencia ya funciona, puede
que queramos arrancar desde un estado en blanco. Incluso si queremos tener datos
iniciales, puede que sea mejor gestionarlos a alto nivel, por ejemplo al arrancar la
aplicación. Cambia NoteStore de este modo:
app/stores/NoteStore.js
import uuid from 'uuid';
import NoteActions from '../actions/NoteActions';
export default class NoteStore {
constructor() {
this.bindActions(NoteActions);
this.notes = [
{
id: uuid.v4(),
task: 'Learn React'
},
{
id: uuid.v4(),
task: 'Do laundry'
}
];
this.notes = [];
}
...
}
Es suficiente de momento. Nuestra aplicación debería arrancar desde cero.

-- 122 of 226 --

Implementando Persistencia en localStorage 105
