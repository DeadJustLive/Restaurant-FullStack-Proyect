# Capítulo 11:: Configuración de React

## Fuente
react-stackoverflow-docs (Cap. 50)

## Contenido
# Capítulo 11:: Configuración de React

Ambiente
Examples
Componente Reactivo Simple
Queremos poder compilar el componente a continuación y mostrarlo en nuestra página web
Nombre de archivo : src / index.jsx
import React from 'react';
import ReactDOM from 'react-dom';
class ToDo extends React.Component {
render() {
return (<div>I am working</div>);
}
}
ReactDOM.render(<ToDo />, document.getElementById('App'));
Instalar todas las dependencias
