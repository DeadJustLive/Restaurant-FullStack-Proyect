# 9.3 Configurando NoteActions

## Fuente
react-aprendiz-maestro (Cap. 85)

## Contenido
# 9.3 Configurando NoteActions

Alt tiene un pequeño método de utilidades conocido como alt.generateActions
que puede generar creadores de acciones simples por nosotros. Estos generadores
símplemente enviarán los datos que les pasemos, así que conectaremos estas acciones
con los almacenes relevantes. En este caso, estamos hablando del NoteStore que
definimos anteriormente.
Con respecto a la aplicación, es suficiente con que modelemos las operaciones
CRUD básicas (Crear, Leer, Actualizar y Borrar). Podemos saltarnos la lectura ya
que es implícita, pero es útil tener las demás disponibles como acciones. Configura
NoteActions usando alt.generateActions como sigue:
app/actions/NoteActions.js
1http://alt.js.org/docs/createActions/

-- 105 of 226 --

Implementando NoteStore y NoteActions 88
import alt from '../libs/alt';
export default alt.generateActions('create', 'update', 'delete');
Esto no hace mucho por sí mismo, aunque es un buen sitio para conectar las acciones
con App para poder lanzarlas. Nos empezaremos a preocupar sobre las acciones
individuales una vez hagamos que nuestro almacén sea más grande. Modifica App
del siguiente modo para conectar las acciones:
app/components/App.jsx
import React from 'react';
import uuid from 'uuid';
import Notes from './Notes';
import connect from '../libs/connect';
import NoteActions from '../actions/NoteActions';
class App extends React.Component {
...
}
export default connect(({notes}) => ({
notes
}))(App)
export default connect(({notes}) => ({
notes
}), {
NoteActions
})(App)
Esto nos permitirá ejecutar cosas como this.props.NoteActions.create para poder
lanzar acciones.
