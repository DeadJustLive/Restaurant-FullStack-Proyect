# Capítulo 7:: Componentes de orden superior

Introducción
Los componentes de orden superior ("HOC" en breve) es un patrón de diseño de aplicación de
reacción que se utiliza para mejorar los componentes con código reutilizable. Permiten agregar
funcionalidad y comportamientos a las clases de componentes existentes.
Un HOC es una función javascript pura que acepta un componente como argumento y devuelve
un componente nuevo con la funcionalidad extendida.
Observaciones
Los HOC se usan con frecuencia en bibliotecas de terceros. Como la función de conexión de
Redux.
Examples
Componente de orden superior simple
Digamos que queremos console.log cada vez que el componente se monta:
hocLogger.js
export default function hocLogger(Component) {
return class extends React.Component {
componentDidMount() {
console.log('Hey, we are mounted!');
}
render() {
return <Component {...this.props} />;
}
}
}
Utilice este HOC en su código:
MyLoggedComponent.js
import React from "react";
import {hocLogger} from "./hocLogger";
export class MyLoggedComponent extends React.Component {
render() {
return (
<div>
This component get's logged to console on each mount.
</div>
);
https://riptutorial.com/es/home 43

-- 53 of 139 --

}
}
// Now wrap MyLoggedComponent with the hocLogger function
export default hocLogger(MyLoggedComponent);
Componente de orden superior que comprueba la autenticación
Digamos que tenemos un componente que solo debería mostrarse si el usuario ha iniciado
sesión.
Así que creamos un HOC que verifica la autenticación en cada render ():
AuthenticatedComponent.js
import React from "react";
export function requireAuthentication(Component) {
return class AuthenticatedComponent extends React.Component {
/**
* Check if the user is authenticated, this.props.isAuthenticated
* has to be set from your application logic (or use react-redux to retrieve it from
global state).
*/
isAuthenticated() {
return this.props.isAuthenticated;
}
/**
* Render
*/
render() {
const loginErrorMessage = (
<div>
Please <a href="/login">login</a> in order to view this part of the
application.
</div>
);
return (
<div>
{ this.isAuthenticated === true ? <Component {...this.props} /> :
loginErrorMessage }
</div>
);
}
};
}
export default requireAuthentication;
Luego, solo usamos este componente de orden superior en nuestros componentes que debe
estar oculto a usuarios anónimos:
MyPrivateComponent.js
https://riptutorial.com/es/home 44

-- 54 of 139 --

import React from "react";
import {requireAuthentication} from "./AuthenticatedComponent";
export class MyPrivateComponent extends React.Component {
/**
* Render
*/
render() {
return (
<div>
My secret search, that is only viewable by authenticated users.
</div>
);
}
}
// Now wrap MyPrivateComponent with the requireAuthentication function
export default requireAuthentication(MyPrivateComponent);
Este ejemplo se describe con más detalle aquí .
Lea Componentes de orden superior en línea:
https://riptutorial.com/es/reactjs/topic/9819/componentes-de-orden-superior
https://riptutorial.com/es/home 45

-- 55 of 139 --