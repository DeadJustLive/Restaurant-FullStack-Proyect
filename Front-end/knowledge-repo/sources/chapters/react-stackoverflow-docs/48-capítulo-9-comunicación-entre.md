# Capítulo 9:: Comunicación Entre

Componentes
Observaciones
Hay un total de 3 casos de comunicación entre los componentes de React:
Caso 1: Comunicación padre a hijo.	•
Caso 2: Comunicación niño a padre	•
Caso 3: comunicación de componentes no relacionados (cualquier componente a cualquier
componente)
•
Examples
Componentes de padres a hijos
Ese es el caso más fácil en realidad, muy natural en el mundo React y es probable que ya lo
estés usando.
Puedes pasar los accesorios a los componentes secundarios . En este ejemplo, el message es
el elemento que transmitimos al componente secundario, el mensaje de nombre se elige de forma
arbitraria, puede asignarle el nombre que desee.
import React from 'react';
class Parent extends React.Component {
render() {
const variable = 5;
return (
<div>
<Child message="message for child" />
<Child message={variable} />
</div>
);
}
}
class Child extends React.Component {
render() {
return <h1>{this.props.message}</h1>
}
}
export default Parent;
Aquí, el componente <Parent /> representa dos componentes <Child /> , pasando un message for
child dentro del primer componente y 5 dentro del segundo.
En resumen, usted tiene un componente (padre) que presta otro (hijo) y le pasa algunos
https://riptutorial.com/es/home 50

-- 60 of 139 --

accesorios.
Componentes del niño al padre
Al enviar datos de vuelta al padre, para hacer esto, simplemente pasamos una función como
prop del componente principal al componente secundario , y el componente secundario
llama a esa función .
En este ejemplo, cambiaremos el estado principal pasando una función al componente
secundario e invocando esa función dentro del componente secundario.
import React from 'react';
class Parent extends React.Component {
constructor(props) {
super(props);
this.state = { count: 0 };
this.outputEvent = this.outputEvent.bind(this);
}
outputEvent(event) {
// the event context comes from the Child
this.setState({ count: this.state.count++ });
}
render() {
const variable = 5;
return (
<div>
Count: { this.state.count }
<Child clickHandler={this.outputEvent} />
</div>
);
}
}
class Child extends React.Component {
render() {
return (
<button onClick={this.props.clickHandler}>
Add One More
</button>
);
}
}
export default Parent;
Tenga en cuenta que los padres de la outputEvent método (que cambia el estado de Padres) es
invocado por el botón del Niño onClick evento.
Componentes no relacionados
La única manera si sus componentes no tienen una relación padre-hijo (o están relacionados,
pero están demasiado lejos, como por ejemplo, un bisnieto), es tener algún tipo de señal a la que
https://riptutorial.com/es/home 51

-- 61 of 139 --

uno de los componentes se suscriba y el otro escriba.
Esas son las 2 operaciones básicas de cualquier sistema de eventos: suscribirse / escuchar un
evento para ser notificado, y enviar / desencadenar / publicar / enviar un evento para notificar a
los que quieren.
Hay al menos 3 patrones para hacer eso. Puedes encontrar una comparación aquí .
Aquí hay un breve resumen:
Patrón 1: Emisor de eventos / Destino / Despachador : los oyentes deben hacer
referencia a la fuente para suscribirse.
para suscribirse: otherObject.addEventListener('click', () => { alert('click!'); });	○
para enviar: this.dispatchEvent('click');	○
•
Patrón 2: publicación / suscripción : no necesita una referencia específica a la fuente que
desencadena el evento, hay un objeto global accesible en todas partes que maneja todos
los eventos.
para suscribirse: globalBroadcaster.subscribe('click', () => { alert('click!'); });	○
para enviar: globalBroadcaster.publish('click');	○
•
Patrón 3: Señales : similar a Event Emitter / Target / Dispatcher, pero aquí no usa cadenas
aleatorias. Cada objeto que podría emitir eventos debe tener una propiedad específica con
ese nombre. De esta manera, usted sabe exactamente qué eventos puede emitir un objeto.
para suscribirse: otherObject.clicked.add( () => { alert('click'); });	○
para enviar: this.clicked.dispatch();	○
•
Lea Comunicación Entre Componentes en línea:
https://riptutorial.com/es/reactjs/topic/6567/comunicacion-entre-componentes
https://riptutorial.com/es/home 52

-- 62 of 139 --