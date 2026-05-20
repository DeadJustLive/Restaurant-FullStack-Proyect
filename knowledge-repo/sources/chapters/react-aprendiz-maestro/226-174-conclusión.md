# 17.4 Conclusión

No hay una forma única de estructurar tu proyecto con React. Dicho esto, es uno de
esos aspectos en los que merece la pena pensar. Encontrar una estructura que nos

-- 199 of 226 --

Estructurando Proyectos con React 182
ayude merece la pena. Una estructura clara ayuda al mantenimiento y hace que tu
proyecto sea más entendible por otros.
Puedes hacer que la estructura evolucione a medida que avanzas. Las estructuras muy
pesadas puede que te retrasen. A medida que el proyecto evoluciona, debe hacerlo
también su estructura. Es una de esas cosas en las que merece la pena meditar acerca
de cómo afecta al desarrollo.

-- 200 of 226 --

Apéndices
Como no todo lo que merece la pena discutir encaja en un libro como este, he
recopilado material relacionado y lo he colocado en pequeños apéndices. Estos
apéndices apoyan el contenido principal y explican algunos temas, tales como las
características del lenguaje, en un mayor grado de detalle. Además. hay consejos y
soluciones de problemas al final.

-- 201 of 226 --

Características del Lenguaje
ES6 (o ES2015) ha sido sin lugar a dudas el mayor cambio en JavaScript en mucho
tiempo. Como resultado, muchas funcionalidades nuevas han sido añadidas. El
propósito de este apéndie es mostrar las características utilizadas en este libro de
forma individual para que sea más fácil entender cómo funcionan. En lugar de ir a la
especificación completa3, me centraré únicamente en el subconunto de características
usadas en el libro.
Módulos
ES6 introduce una declaración formal de módulos. Anteriormente había que utilizar
soluciones ad hoc o cosas como AMD o CommonJS. Las declaraciones de módulos
de ES6 son analizables estáticamente, lo cual es útil para no cargar código sin utilizar
símplemente analizando la estructura de imports.
import y export Sencillos
Para mostrarte un ejemplo de cómo exportar directamente un módulo echa un vistazo
al código siguiente:
persist.js
import makeFinalStore from 'alt-utils/lib/makeFinalStore';
export default function(alt, storage, storeName) {
...
}
index.js
3http://www.ecma-international.org/ecma-262/6.0/index.html

-- 202 of 226 --

Características del Lenguaje 185
import persist from './persist';
...
import y export Múltiple
A menudo puede ser útil utilizar módulos como un espacio de nombres con varias
funciones:
math.js
export function add(a, b) {
return a + b;
}
export function multiply(a, b) {
return a * b;
}
export function square(a) {
return a * a;
}
De forma alternativa puedes escribir el módulo de la forma siguiente:
math.js

-- 203 of 226 --

Características del Lenguaje 186
const add = (a, b) => a + b;
const multiple = (a, b) => a * b;
// Puedes omitir los () si quieres ya que tiene sólo un parámetro
const square = a => a * a;
export {
add,
multiple,
// Puedes crear alias
multiple as mul
};
El ejemplo utiliza la sintaxis de la flecha gorda. Esta definición puede ser consumida
desde un import de la manera siguiente:
index.js
import {add} from './math';
// También podríamos usar todos los métodos de math con
// import * as math from './math';
// math.add, math.multiply, ...
...
Ya que la sintaxis de los módulos de ES6 es analizable estáticamente, es
posible usar heramientas como analyze-es6-modules4.
Imports con Alias
A veces puede ser útil hacer alias de imports. Por ejemplo:
4https://www.npmjs.com/package/analyze-es6-modules

-- 204 of 226 --

Características del Lenguaje 187
import {actions as TodoActions} from '../actions/todo'
...
as te permite evitar conflictos de nombrado.
Webpack resolve.alias
Los empaquetadores, como Webpack, pueden dar funcionalidad más allá de esto.
Puedes definir un resolve.alias para alguno de tus directorios de módulos, por
ejemplo. Esto te permite usar un import como import persist from 'libs/per-
sist'; independientemente de dónde estés importando. Un simple resolve.alias
puede ser algo como esto:
...
resolve: {
alias: {
libs: path.join(__dirname, 'libs')
}
}
La documentación oficial describe las posibles alternativas5 con todo lujo de detalles.
Clases
Al contrario de como ocurre con otros lenguajes ahí fuera, JavaScript utiliza una
herencia basada en prototipos en lugar de herencia basada en clases. Ambas aproxi-
maciones tienen sus ventajas. De hecho, puedes imitar un modelo basado en clases
utilizando uno basado en prototipos. Las clases de ES6 simplemente son azúcar
sintáctico de los mecanismos de JavaScript, ya que internamente sigue utilizando
el sistema antiguo, solo que parece algo distinto para el programador.
React permite definición de componentes basados en clases. No todos estamos de
acuerdo en que sea algo bueno. Dicho esto, la definición puede estar bien siempre
que no abuses de ella. Para darte un ejemplo sencillo, observa el código siguiente:
5https://webpack.github.io/docs/configuration.html#resolve-alias

-- 205 of 226 --

Características del Lenguaje 188
import React from 'react';
export default class App extends React.Component {
constructor(props) {
super(props);
// This es una propiedad fuera del funcionamiento de React.
// Si no necesitas lanzar render() cuando cambia puede funcionar.
this.privateProperty = 'private';
// Estado específico de React. Puedes cambiarlo con `this.setSta\
te`, lo
// cual podrá llamar a `render()`.
this.state = {
name: 'Class demo'
};
}
render() {
// Use estas propiedades de alguna manera.
const privateProperty = this.privateProperty;
const name = this.state.name
const notes = this.props.notes;
...
}
}
Quizá la mayor ventaja de la aproximación basada en clases sea el hecho de que
reduce algo de complejidad, especialmente cuando involucra los métodos del ciclo
de vida de React.
Clases y Módulos
Como vimos antes, los módulos de ES6 permiten hacer export e import de uno
o varios objetos, funciones o incluso clases. También puedes usar export default

-- 206 of 226 --

Características del Lenguaje 189
class para exportar una clase anónima o exportar varias clases desde el mismo
módulo usando export class className.
Note.jsx
export default class extends React.Component { ... };
Notes.jsx
import Note from './Note.jsx';
...
También puedes usar export class className para exportar varias clases nombra-
das de un único módulo.
Components.jsx
export class Note extends React.Component { ... };
export class Notes extends React.Component { ... };
App.jsx
import {Note, Notes} from './Components.jsx';
...
Se recomienda que tengas las clases separadas en módulos diferentes.
Propiedades de las Clases e Iniciadores de
Propiedades
Las clases de ES6 no enlazan sus métodos por defecto. Esto puede suponer un
problema a veces, ya que puede que quieras acceder a las propiedades de la instancia.
Hay características experimentales conocidas como las propiedades de las clases y los
iniciadores de propiedades6 que arreglan este problema. Sin ellos podríamos escribir
algo como:
6https://github.com/jeffmo/es-class-static-properties-and-fields

-- 207 of 226 --

Características del Lenguaje 190
import React from 'react';
class App extends React.Component {
constructor(props) {
super(props);
this.renderNote = this.renderNote.bind(this);
}
render() {
...
return this.renderNote();
}
renderNote() {
// Dado que renderNote ha sido enlazado, podemos usar `this` com\
o esperamos
return <div>{this.props.value}</div>;
}
}
App.propTypes = {
value: React.PropTypes.string
};
App.defaultProps = {
value: ''
};
export default App;
Utilizando propiedades de clases e iniciadores de propiedades podemos escribir algo
más limpio en su lugar:

-- 208 of 226 --

Características del Lenguaje 191
import React from 'react';
export default class App extends React.Component {
// la definición de propType mediante propiedades estáticas de la \
clase
static propTypes = {
value: React.PropTypes.string
}
static defaultProps = {
value: ''
}
render() {
...
return this.renderNote();
}
// El iniciador de propiedades se encarga del `bind`
renderNote = () => {
// Dado que renderNote ha sido enlazado, podemos usar `this` com\
o esperamos
return <div>{this.props.note}</div>;
}
}
Ahora que nos hemos llevado la declaración a nivel de método el código se lee mejor.
He decidido usar esta característica en este libro principalmente por este motivo. Hay
menos de lo que preocuparse.
Funciones
JavaScript ha sido tradicionalmente muy flexible con respecto a las funciones. Para
que te hagas una mejor idea, aquí tienes la implementación de map:

-- 209 of 226 --

Características del Lenguaje 192
function map(cb, values) {
var ret = [];
var i, len;
for(i = 0, len = values.length; i < len; i++) {
ret.push(cb(values[i]));
}
return ret;
}
map(function(v) {
return v * 2;
}, [34, 2, 5]); // salen [68, 4, 10]
En ES6 podríamos haberlo escrito de esta manera:
function map(cb, values) {
const ret = [];
const i, len;
for(i = 0, len = values.length; i < len; i++) {
ret.push(cb(values[i]));
}
return ret;
}
map((v) => v * 2, [34, 2, 5]); // salen [68, 4, 10]
La implementación de map es más o menos lo mismo. La parte interesante es la forma
en la que lo llamamos. En concreto, (v) => v * 2 es fascinante. En lugar de tener que
escribir function por todos lados, la sintaxis de la flecha gorda nos da un pequeño
y útil atajo. Para ver más ejemplos de uso echa un vistazo a lo que sigue:

-- 210 of 226 --

Características del Lenguaje 193
// Todas son equivalentes
v => v * 2;
(v) => v * 2; // Prefiero esta opción en funciones cortas
(v) => { // Usa esta si necesitas ejecutar varias sentencias
return v * 2;
}
// Podemos enlazarlo a una variable
const double = (v) => v * 2;
console.log(double(2));
// Si quieres usar un atajo y devolver un objeto
// necesitas encapsular el objeto.
v => ({
foo: 'bar'
});
El contexto de la Función Flecha
Las funciones flecha son un tanto especiales ya que no tienen un this propio. En su
lugar, this apunta al ámbito del objeto invocante. Fíjate en el siguiente ejemplo:
var obj = {
context: function() {
return this;
},
name: 'demo object 1'
};
var obj2 = {
context: () => this,
name: 'demo object 2'
};

-- 211 of 226 --

Características del Lenguaje 194
console.log(obj.context()); // { context: [Function], name: 'demo ob\
ject 1' }
console.log(obj2.context()); // {} en Node.js, Window en el navegador
Como puedes ver en el código anterior, la función anónima tiene un this que apunta
a la función context del objeto obj. En otras palabras, está enlazando el ámbito del
objeto obj a la función context.
Esto es así porque this no apunta al ámbito del objeto que lo contiene, sino al ámbito
del objeto que lo invoca, como puedes ver en el siguiente fragmento de código:
console.log(obj.context.call(obj2)); // { context: [Function], name:\
'demo object 2' }
La función flecha en el objeto obj2 no enlaza ningún objeto a su contexto, siguendo
lo que serían las reglas normales de ámbitos resolviendo la referencia al ámbito
inmediatemente superior.
Incluso cuando este comportamiento parece ser un poco extraño, en realidad es útil.
En el pasado, si querías acceder al contexto de la clase padre necesitabas enlazarlo
o relacionarlo en una variable del estilo var that = this;. La introducción de la
sintaxis de la función flecha ha mitigado este problema.
Parámetros de las Funciones
Históricamente, lidiar con los parámetros de las funciones ha sido algo limitado. hay
varios hacks, como values = values || [];, pero no son particularmente buenos y
son propensos a errores. Por ejemplo, el uso de || puede causar problemas con ceros.
ES6 soluciona este problema introduciendo parámetros por defecto. De este modo,
podemos escribir simplemente function map(cb, values=[]).
Hay más que esto y los valores por defecto pueden depender unos de otros. También
puedes pasar una cantidad arbitraria de parámetros mediante function map(cb,
...values). En este caso, puedes llamar a la función usando map(a => a * 2, 1,
2, 3, 4). Este API puede que no sea perfecto para map, pero puede tener más sentido
en otro escenario.
También hay medios útiles para extraer valores de los objetos enviados. Esto es muy
útil con los componentes de React que se definen como funciones:

-- 212 of 226 --

Características del Lenguaje 195
export default ({name}) => {
// Interpolación de strings en ES6. ¡Observa las tildes!
return <div>{`Hello ${name}!`}</div>;
};
Interpolación de Strings
Antiguamente, lidiar con strings era algo doloroso en JavaScript. Por lo general se
utilizaba una sintaxis del tipo 'Hello' + name + '!'. Sobrecargar + para alcanzar
este propósito quizá no era la mejor manera ya que podia provocar comportamientos
extraños. Por ejemplo, 0 + ' world' puede devolver el string 0 world como resul-
tado.
Aparte de ser más clara, la interpolación de strings de ES6 permite strings multilínea.
Esto es algo que la anterior sintaxis no soportaba. Observa los siguientes ejemplos:
const hello = `Hello ${name}!`;
const multiline = `
multiple
lines of
awesomeness
`;
Puede que tardes un poco hasta que te acostumbres a la tilde, pero es poderosa y
menos propensa a errores.
Destructuring
Eso de ... está relacionado con la idea de destructuring. Por ejemplo, const {lane,
...props} = this.props; sacará lane fuera de this.props mientras que el resto
del objeto se quedará en props. Esta sintaxis es todavía experimental en objetos. ES6
especifica una forma oficial de poder hacer lo mismo en arrays como sigue:

-- 213 of 226 --

Características del Lenguaje 196
const [lane, ...rest] = ['foo', 'bar', 'baz'];
console.log(lane, rest); // 'foo', ['bar', 'baz']
El operador spread (...) es útil para concatenaciones. Verás sintaxis similar con
frecuencia en ejemplos de Redux. Se basa en el experimental Object rest/spread
syntax7:
[...state, action.lane];
// Esto es igual que
state.concat([action.lane])
La misma idea funciona en los componentes de React:
...
render() {
const {value, onEdit, ...props} = this.props;
return <div {...props}>Spread demo</div>;
}
...
Iniciadores de Objetos
ES6 facilita varias funcionalidades para hacer que sea más sencillo trabajar con
objetos. Citando a MDN8, fíjate en los siguientes ejemplos:
7https://github.com/sebmarkbage/ecmascript-rest-spread
8https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Object_initializer

-- 214 of 226 --

Características del Lenguaje 197
const a = 'demo';
const shorthand = {a}; // Lo mismo que {a: a}
// Métodos atajo
const o = {
get property() {},
set property(value) {},
demo() {}
};
// Nombres de propiedades procesadas
const computed = {
[a]: 'testing' // demo -> testing
};
const, let, var
En JavaScript, las variables son globales por defecto. var las enlaza a nivel de función,
lo cual es un contraste con muchos otros lenguajes que implementan enlazamiento
a nivel de bloque. ES6 introduce enlazamiento a nivel de bloque con let.
const también está soportado, lo que garantiza que la referencia a una variable
no pueda ser cambiada. Esto, sin embargo, no significa que no puedas cambiar el
contenido de la variable, así que si estás apuntando a un objeto, ¡todavía tendrás
permitido cambiarlo!
Suelo utilizar const siempre que sea posible. Si necesito que algo sea mutable, let es
estupendo. Es difícil encontrar un uso útil de var teniendo const y let. De hecho,
todo el código de este libro, exceptuando el apéndice, utiliza const, lo que quizá
pueda enseñarte lo lejos que puedes llegar con él.
Decoradores
Dado que los decoradores son todavía una funcionalidad experimental hay mucho
que hablar de ellos. Hay un apéndice entero dedicado a este tema. Lee Entendiendo
los Decoradores para más información.

-- 215 of 226 --

Características del Lenguaje 198
Conclusión
Hay mucho más ES6 y más especificaciones que éstas. Si quieres entender la
especificación mejor, ES6 Katas9 es un buen punto en el que comenzar para aprender
más. Únicamente teniendo una buena idea de lo básico podrás llegar lejos.
9http://es6katas.org/

-- 216 of 226 --

Entendiendo los Decoradores
Si has usado lenguajes de programación antes, como Java o Python, puede que la idea
te resulte familiar. Los decoradores son azúcar sintáctico que te permiten envolver y
anotar clases y funciones. En su actual propuesta10 (fase 1) sólo se permite la envoltura
a nivel de clase y de método. Las funciones puede que sean soportadas en el futuro.
Con Babel 6 puedes habilitar este comportamiento mediante los plugins babel-plu-
gin-syntax-decorators11 y babel-plugin-transform-decorators-legacy12. El primero da
soporte a nivel de sintáxis mientras que el segundo da el tipo de comportamiento que
vamos a discutir ahora.
El mayor beneficio de los decoradores es que nos permiten envolver comportamiento
en partes simples y reutilizables a la vez que reducimos la cantidad de ruido. Es
totalmente posible programar sin ellos, sólo hacen que algunas de las tareas acaben
siendo más agradecidas, como vimos con las anotaciones relacionadas con arrastrar
y soltar.
Implementando un Decorador para Generar
Logs
A veces es útil saber qué métodos han sido invocados. Por supuesto que puedes usar
console.log pero es más divertido implementar @log. Es una forma mejor de tenerlo
controlado. Observa el siguiente ejemplo:
10https://github.com/wycats/javascript-decorators
11https://www.npmjs.com/package/babel-plugin-syntax-decorators
12https://www.npmjs.com/package/babel-plugin-transform-decorators-legacy

-- 217 of 226 --

Entendiendo los Decoradores 200
class Math {
@log
add(a, b) {
return a + b;
}
}
function log(target, name, descriptor) {
var oldValue = descriptor.value;
descriptor.value = function() {
console.log(`Calling "${name}" with`, arguments);
return oldValue.apply(null, arguments);
};
return descriptor;
}
const math = new Math();
// los argumentos pasados deberían aparecer en el log
math.add(2, 4);
La idea es que nuestro decorador log envuelva la función original, lance un conso-
le.log y, finalmente, haga la invocación con los argumentos13 originales. Puede que
te parezca un poco extraño si nunca antes habías visto arguments o apply.
apply puede ser visto como otra forma de invocar una función pasándole su contexto
(this) y sus parámetros como un array. arguments recibe de forma implícita todos
los parámetros con los que se ha invocado a la función así que es ideal para este caso.
El logger puede ser movido a un módulo aparte. Tras ello, podemos usarlo en nuestra
aplicación en aquellos lugares donde queramos mostrar el log de algunos métodos.
Una vez han sido implementados, los decoradores se convierten en una herramienta
poderosa.
13https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Functions/arguments

-- 218 of 226 --

Entendiendo los Decoradores 201
El decorador recibe tres parámetros:
• target se relaciona con la instancia de la clase.
• name contiene el nombre del método que va a ser ejecutado.
• descriptor es la pieza más interesante ya que nos permite anotar un método
y manipular su comportamiento. Puede tener el siguiente aspecto:
const descriptor = {
value: () => {...},
enumerable: false,
configurable: true,
writable: true
};
Como puedes ver, value hace que sea posible envolver el comportamiento. Lo
demás te permite modificar el comportamiento a nivel de método. Por ejemplo, un
decorador @readonly puede limitar el acceso. @memoize es otro ejemplo interesante
ya que permite que los métodos implementen cacheo fácilmente.
Implementado @connect
@connect envolverá nuestro componente en otro componente. Se encargará de lidiar
con la lógica de conexión (listen/unlisten/setState). Mantendrá internamente el
estado del almacén y se lo pasará a los componentes hijos que estén siendo envueltos.
Durante el proceso, enviará el estado mediante props. La siguiente implementación
ilustra la idea:
app/decorators/connect.js

-- 219 of 226 --

Entendiendo los Decoradores 202
import React from 'react';
const connect = (Component, store) => {
return class Connect extends React.Component {
constructor(props) {
super(props);
this.storeChanged = this.storeChanged.bind(this);
this.state = store.getState();
store.listen(this.storeChanged);
}
componentWillUnmount() {
store.unlisten(this.storeChanged);
}
storeChanged() {
this.setState(store.getState());
}
render() {
return <Component {...this.props} {...this.state} />;
}
};
};
export default (store) => {
return (target) => connect(target, store);
};
¿Puedes ver la idea del decorador? Nuestro decorador vigila el estado del almacén.
Tras ello, pasa el estado al componente contenido mediante props.
... es conocido como el operador spread14. Expande el objeto recibido
para separar los pares clave-valor, o propiedades, como en este caso.
14https://github.com/sebmarkbage/ecmascript-rest-spread

-- 220 of 226 --

Entendiendo los Decoradores 203
Puedes conectar el decorador con App de este modo:
app/components/App.jsx
...
import connect from '../decorators/connect';
...
@connect(NoteStore)
export default class App extends React.Component {
render() {
const notes = this.props.notes;
...
}
...
}
Llevar la lógica a un decorador nos permite mantener nuestros componentes sen-
cillos. Ahora debería ser trivial poder añadir más almacenes y conectarlos a los
componentes si quisiéramos. E incluso mejor, podriamos conectar varios almacenes
a un único componente fácilmente.
Ideas para Decoradores
Podemos crear decoradores para varias desarrollar distintas funcionalidades, como
es la de deshacer, de esta manera. Esto nos permite mantener nuestros componentes
limpios y empujar la lógica común a algún lugar fuera de nuestra vista. Los
decoradores bien diseñados pueden ser utilizados en varios proyectos.
El @connectToStores de Alt
Alt facilita un decorador similar conocido como @connectToStores. Se apoya en
métodos estáticos. En lugar de ser métodos normales que están incluidos en una

-- 221 of 226 --

Entendiendo los Decoradores 204
instancia específica, se incluyen a nivel de clase. Esto significa que puedes llamarlos a
través de la propia clase (p.e., App.getStores()). El siguiente ejemplo muestra cómo
podemos integrar @connectToStores en nuestra aplicación:
...
import connectToStores from 'alt-utils/lib/connectToStores';
@connectToStores
export default class App extends React.Component {
static getStores(props) {
return [NoteStore];
};
static getPropsFromStores(props) {
return NoteStore.getState();
};
...
}
Esta aproximación es muy parecida a nuestra implementación. En realidad hace más
ya que te permite conectar con varios almacenes a la misma vez. También te dá más
control sobre la forma en la que puedes encajar el almacén de estados con las props.
Conclusión
Aunque todavía sean un tanto experimentales, los decoradores son una buena
forma de llevar lógica allá donde pertenezca. Mejor todavía, nos dan un grado de
reusabilidad mientras mantienen nuestros componentes ordenados y limpios.

-- 222 of 226 --

Resolución de Problemas
He tratado de recopilar algunos problemas comunes aquí. Este capítulo crecerá a
medida que se vayan encontrando más problemas comunes.