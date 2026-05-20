# 13.1 Configurando React DnD

## Fuente
react-aprendiz-maestro (Cap. 119)

## Contenido
# 13.1 Configurando React DnD

Para comenzar necesitaremos conectar React DnD con nuestro proyecto. Vamos a
utilizar un backend de arrastrar y soltar basado en el de HTML5. Existen backends
específicos para testing y tacto2.
Para configurarlo, necesitaremos utilizar el decorador DragDropContext y facilitarle
el backend de HTML5. Voy a utilizar compose de redux para evitar revestimientos
innecesarios y mantener el código más limpio:
app/components/App.jsx
1https://gaearon.github.io/react-dnd/
2https://github.com/yahoo/react-dnd-touch-backend

-- 155 of 226 --

Implementado Arrastrar y Soltar 138
import React from 'react';
import uuid from 'uuid';
import {compose} from 'redux';
import {DragDropContext} from 'react-dnd';
import HTML5Backend from 'react-dnd-html5-backend';
import connect from '../libs/connect';
import Lanes from './Lanes';
import LaneActions from '../actions/LaneActions';
const App = ({LaneActions, lanes}) => {
const addLane = () => {
LaneActions.create({
id: uuid.v4(),
name: 'New lane'
});
};
return (
<div>
<button className="add-lane" onClick={addLane}>+</button>
<Lanes lanes={lanes} />
</div>
);
};
export default connect(({lanes}) => ({
lanes
}), {
LaneActions
})(App)
export default compose(
DragDropContext(HTML5Backend),
connect(
({lanes}) => ({lanes}),
{LaneActions}

-- 156 of 226 --

Implementado Arrastrar y Soltar 139
)
)(App)
Tras este cambio la aplicación debería tener el mismo aspecto de antes, pero ahora
estamos preparados para añadir la funcionalidad.
