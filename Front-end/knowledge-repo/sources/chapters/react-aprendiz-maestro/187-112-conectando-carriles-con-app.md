# 11.2 Conectando Carriles con App

El paso siguiente es hacer hueco para Carriles en App. Simplemente reemplazaremos
las referencias a Notas por Carriles y configuraremos las acciones de carriles y su
almacén, lo que significa que mucho código antiguo desaparecerá. Cambia App por
el código siguiente:
app/components/App.jsx
import React from 'react';
import uuid from 'uuid';
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

-- 128 of 226 --

Gestionado Dependencias de Datos 111
};
export default connect(({lanes}) => ({
lanes
}), {
LaneActions
})(App)
Si pruebas esta implementación en el navegador verás que no hace mucho. Deberías
poder añadir nuevos carriles en el Kanban y poder ver el texto “New lane” (nuevo
carril) pero eso es todo. Para recuperar la funcionalidad que teníamos con las notas
tendremos que centrarnos en modelar Carril más adelante.