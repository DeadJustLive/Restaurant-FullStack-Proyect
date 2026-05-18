# Capítulo 18:: Reaccionar con redux

Introducción
Redux se ha convertido en el statu quo para administrar el estado de nivel de aplicación en el
front-end en estos días, y los que trabajan en "aplicaciones a gran escala" a menudo confían en
ello. Este tema cubre por qué y cómo debe usar la biblioteca de administración de estado, Redux,
en sus aplicaciones React.
Observaciones
Si bien la arquitectura basada en componentes de React es fantástica para dividir la aplicación en
pequeñas piezas encapsuladas y modulares, presenta algunos desafíos para administrar el
estado de la aplicación en su totalidad. El momento de usar Redux es cuando necesita mostrar
los mismos datos en más de un componente o página (también conocida como ruta). En ese
momento, ya no puede almacenar los datos en variables locales para un componente u otro, y el
envío de mensajes entre componentes se convierte rápidamente en un desastre. Con Redux,
todos sus componentes se están suscribiendo a los mismos datos compartidos en la tienda y, por
lo tanto, el estado se puede reflejar fácilmente de manera consistente en toda la aplicación.
Examples
Usando Connect
Crear una tienda de Redux con createStore .
import { createStore } from 'redux'
import todoApp from './reducers'
let store = createStore(todoApp, { inistialStateVariable: "derp"})
Use conectar para conectar el componente a la tienda Redux y tire de los accesorios de la tienda
al componente.
import { connect } from 'react-redux'
const VisibleTodoList = connect(
mapStateToProps,
mapDispatchToProps
)(TodoList)
export default VisibleTodoList
Defina acciones que permitan a sus componentes enviar mensajes al almacén de Redux.
/*
* action types
https://riptutorial.com/es/home 80

-- 90 of 139 --

*/
export const ADD_TODO = 'ADD_TODO'
export function addTodo(text) {
return { type: ADD_TODO, text }
}
Maneje estos mensajes y cree un nuevo estado para la tienda en funciones reductoras.
function todoApp(state = initialState, action) {
switch (action.type) {
case SET_VISIBILITY_FILTER:
return Object.assign({}, state, {
visibilityFilter: action.filter
})
default:
return state
}
}
Lea Reaccionar con redux en línea: https://riptutorial.com/es/reactjs/topic/10856/reaccionar-con-
redux
https://riptutorial.com/es/home 81

-- 91 of 139 --