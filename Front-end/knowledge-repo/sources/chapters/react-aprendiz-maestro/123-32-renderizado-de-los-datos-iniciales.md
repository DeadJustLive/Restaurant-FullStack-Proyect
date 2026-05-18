# 3.2 Renderizado de los Datos Iniciales

Ahora que tenemos un modelo de datos inicial, podemos tratar de renderizarlo
utilizando React. Vamos a necesitar un componente que retenga los datos, lo
llamaremos Notas de momento y lo haremos crecer si queremos que tenga más
funcionalidad. Crea un fichero con un componente sencillo como el siguiente:
app/components/Notes.jsx
import React from 'react';
const notes = [
{
id: '4e81fc6e-bfb6-419b-93e5-0242fb6f3f6a',
task: 'Learn React'
},
{
id: '11bbffc8-5891-4b45-b9ea-5c99aadf870f',
task: 'Do laundry'
}

-- 36 of 226 --

Implementando una Aplicación de Notas 19
];
export default () => (
<ul>{notes.map(note =>
<li key={note.id}>{note.task}</li>
)}</ul>
)
Estamos utilizando algunas características importantes de JSX en el trozo de código
anterior. He destacado las partes más difíciles:
• <ul>{notes.map(note => ...)}</ul> - {} nos permite mexclar sintaxis de
JavaScript con JSX. map devuelve una lista de elementos li para que React los
renderice.
• <li key={note.id}>{note.task}</li> - Usamos la propiedad key para poder
decirte a React qué items han sido cambiados, modificados o borrados. Es
importante que sea único ya que, sino, React no será capaz de saber el orden
correcto en el que debe renderizarlos. React mostrará una advertencia si no se
indican. Puedes leer el enlace al artículo Renderizando Varios Componentes1
para obtener más información.
Necesitamos hacer referencia al componente desde el punto de entrada de nuestra
aplicación:
app/index.jsx
1https://facebook.github.io/react/docs/lists-and-keys.html#rendering-multiple-components

-- 37 of 226 --

Implementando una Aplicación de Notas 20
import React from 'react';
import ReactDOM from 'react-dom';
import Notes from './components/Notes';
if(process.env.NODE_ENV !== 'production') {
React.Perf = require('react-addons-perf');
}
ReactDOM.render(
<div>Hello world</div>,
<Notes />,
document.getElementById('app')
);
Si ejecutas la aplicación verás una lista de notas. No es especialmente bonito ni útil
todavía pero es un comienzo:
Una lista de notas
Necesitamos usar el import de React en Notes.jsx ya que hay transforma-
ciones que hacer de JSX a JavaScript. Sin él el código resultante fallará.