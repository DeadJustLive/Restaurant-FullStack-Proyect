# Capítulo 26:: Soluciones de interfaz de

## Fuente
react-stackoverflow-docs (Cap. 70)

## Contenido
# Capítulo 26:: Soluciones de interfaz de

usuario
Introducción
Digamos que nos inspiramos en algunas ideas de las interfaces de usuario modernas utilizadas
en los programas y las convertimos en componentes React. En eso consiste el tema "
Soluciones de interfaz de usuario ". Se atribuye la atribución.
Examples
Panel básico
import React from 'react';
class Pane extends React.Component {
constructor(props) {
super(props);
}
render() {
return React.createElement(
'section', this.props
);
}
}
Panel
import React from 'react';
class Panel extends React.Component {
constructor(props) {
super(props);
}
render(...elements) {
var props = Object.assign({
className: this.props.active ? 'active' : '',
tabIndex: -1
}, this.props);
var css = this.css();
if (css != '') {
elements.unshift(React.createElement(
'style', null,
css
));
}
return React.createElement(
https://riptutorial.com/es/home 111

-- 121 of 139 --

'div', props,
...elements
);
}
static title() {
return '';
}
static css() {
return '';
}
}
Las principales diferencias con respecto al panel simple son:
el panel tiene el foco, por ejemplo, cuando se llama mediante un script o se hace clic con el
mouse;
•
el panel tiene un método de title estático por componente, por lo que puede ser extendido
por otro componente del panel con un title anulado (la razón aquí es que la función puede
ser llamada nuevamente en la representación para fines de localización, pero en los límites
de este title ejemplo no tiene sentido) ;
•
puede contener una hoja de estilo individual declarada en el método estático css (puede
cargar previamente el contenido del archivo desde PANEL.css ).
•
Lengüeta
import React from 'react';
class Tab extends React.Component {
constructor(props) {
super(props);
}
render() {
var props = Object.assign({
className: this.props.active ? 'active' : ''
}, this.props);
return React.createElement(
'li', props,
React.createElement(
'span', props,
props.panelClass.title()
)
);
}
}
panelClass propiedad panelClass de la instancia de Tab debe contener la clase de panel utilizada
para la descripción.
Grupo de paneles
import React from 'react';
import Tab from './Tab.js';
https://riptutorial.com/es/home 112

-- 122 of 139 --

class PanelGroup extends React.Component {
constructor(props) {
super(props);
this.setState({
panels: props.panels
});
}
render() {
this.tabSet = [];
this.panelSet = [];
for (let panelData of this.state.panels) {
var tabIsActive = this.state.activeTab == panelData.name;
this.tabSet.push(React.createElement(
Tab, {
name: panelData.name,
active: tabIsActive,
panelClass: panelData.class,
onMouseDown: () => this.openTab(panelData.name)
}
));
this.panelSet.push(React.createElement(
panelData.class, {
id: panelData.name,
active: tabIsActive,
ref: tabIsActive ? 'activePanel' : null
}
));
}
return React.createElement(
'div', { className: 'PanelGroup' },
React.createElement(
'nav', null,
React.createElement(
'ul', null,
...this.tabSet
)
),
...this.panelSet
);
}
openTab(name) {
this.setState({ activeTab: name });
this.findDOMNode(this.refs.activePanel).focus();
}
}
panels propiedad de panels de la instancia de PanelGroup debe contener una matriz con objetos.
Cada objeto allí declara datos importantes sobre los paneles:
name : identificador del panel utilizado por el script del controlador;	•
class - class panel.	•
No olvide configurar la propiedad activeTab al nombre de la pestaña necesaria.
Aclaración
https://riptutorial.com/es/home 113

-- 123 of 139 --

Cuando se pestaña hacia abajo, el panel se necesita es cada nombre de la clase active el
elemento DOM (que significa que va a ser visible) y se centra ahora.
Vista de ejemplo con `PanelGroup`s
import React from 'react';
import Pane from './components/Pane.js';
import Panel from './components/Panel.js';
import PanelGroup from './components/PanelGroup.js';
class MainView extends React.Component {
constructor(props) {
super(props);
}
render() {
return React.createElement(
'main', null,
React.createElement(
Pane, { id: 'common' },
React.createElement(
PanelGroup, {
panels: [
{
name: 'console',
panelClass: ConsolePanel
},
{
name: 'figures',
panelClass: FiguresPanel
}
],
activeTab: 'console'
}
)
),
React.createElement(
Pane, { id: 'side' },
React.createElement(
PanelGroup, {
panels: [
{
name: 'properties',
panelClass: PropertiesPanel
}
],
activeTab: 'properties'
}
)
)
);
}
}
class ConsolePanel extends Panel {
constructor(props) {
super(props);
}
https://riptutorial.com/es/home 114

-- 124 of 139 --

static title() {
return 'Console';
}
}
class FiguresPanel extends Panel {
constructor(props) {
super(props);
}
static title() {
return 'Figures';
}
}
class PropertiesPanel extends Panel {
constructor(props) {
super(props);
}
static title() {
return 'Properties';
}
}
Lea Soluciones de interfaz de usuario en línea:
https://riptutorial.com/es/reactjs/topic/8112/soluciones-de-interfaz-de-usuario
https://riptutorial.com/es/home 115

-- 125 of 139 --
