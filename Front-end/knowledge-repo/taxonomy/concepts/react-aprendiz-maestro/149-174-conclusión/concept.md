# 17.4 Conclusión

## Fuente
react-aprendiz-maestro (Cap. 149)

## Contenido
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
// Th
