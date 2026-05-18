# Capítulo 50:: Exportando e importando el

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 88)

## Contenido
# Capítulo 50:: Exportando e importando el

módulo en node.js
Examples
Usando un módulo simple en node.js
Qué es un módulo node.js ( enlace al artículo ):
Un módulo encapsula código relacionado en una sola unidad de código. Al crear un
módulo, esto puede interpretarse como mover todas las funciones relacionadas a un
archivo.
Ahora veamos un ejemplo. Imagina que todos los archivos están en el mismo directorio:
Archivo: printer.js
"use strict";
exports.printHelloWorld = function (){
console.log("Hello World!!!");
}
Otra forma de utilizar módulos:
Archivo animals.js
"use strict";
module.exports = {
lion: function() {
console.log("ROAARR!!!");
}
};
Archivo: app.js
Ejecute este archivo yendo a su directorio y escribiendo: node app.js
"use strict";
//require('./path/to/module.js') node which module to load
var printer = require('./printer');
var animals = require('./animals');
printer.printHelloWorld(); //prints "Hello World!!!"
animals.lion(); //prints "ROAARR!!!"
https://riptutorial.com/es/home 171

-- 199 of 423 --

Usando Importaciones En ES6
Node.js está construido contra versiones modernas de V8. Al mantenernos actualizados con las
últimas versiones de este motor, nos aseguramos de que las nuevas características de la
especificación ECMA-262 de JavaScript se presenten a los desarrolladores de Node.js de manera
oportuna, así como mejoras continuas de rendimiento y estabilidad.
Todas las características de ECMAScript 2015 (ES6) se dividen en tres grupos para las
características de envío, por etapas y en curso:
Todas las funciones de envío, que V8 considera estables, están activadas de forma
predeterminada en Node.js y no requieren ningún tipo de indicador de tiempo de ejecución. Las
funciones en etapas, que son funciones casi completas que no son consideradas estables por el
equipo V8, requieren una marca de tiempo de ejecución: --harmony. Las funciones en curso se
pueden activar individualmente por su respectivo indicador de armonía, aunque esto no es
recomendable a menos que sea para propósitos de prueba. Nota: estas banderas están
expuestas por V8 y potencialmente cambiarán sin ningún aviso de desaprobación.
Actualmente ES6 admite declaraciones de importación de forma nativa. Consulte aquí
Así que si tenemos un archivo llamado fun.js ...
export default function say(what){
console.log(what);
}
export function sayLoud(whoot) {
say(whoot.toUpperCase());
}
... y si hubiera otro archivo llamado app.js en el que deseamos poner en uso nuestras funciones
previamente definidas, hay tres formas de importarlas.
Importar por defecto
import say from './fun';
say('Hello Stack Overflow!!'); // Output: Hello Stack Overflow!!
Importa la función say() porque está marcada como la exportación predeterminada en el archivo
de origen ( export default … )
Importaciones con nombre
import { sayLoud } from './fun';
sayLoud('JS modules are awesome.'); // Output: JS MODULES ARE AWESOME.
Las importaciones con nombre nos permiten importar exactamente las partes de un módulo que
realmente necesitamos. Hacemos esto nombrándolos explícitamente. En nuestro caso,
nombrando a sayLoud en paréntesis dentro de la declaración de importación.
https://riptutorial.com/es/home 172

-- 200 of 423 --

Importación agrupada
import * as i from './fun';
i.say('What?'); // Output: What?
i.sayLoud('Whoot!'); // Output: WHOOT!
Si queremos tenerlo todo, este es el camino a seguir. Al utilizar la sintaxis * as i , tenemos la
declaración de import que nos proporciona un objeto i que contiene todas las exportaciones de
nuestro módulo de fun como propiedades con el nombre correspondiente.
Caminos
Tenga en cuenta que debe marcar explícitamente sus rutas de importación como rutas relativas,
incluso si el archivo que desea importar se encuentra en el mismo directorio que el archivo que
está importando utilizando ./ . Importaciones desde rutas no prefijadas como
import express from 'express';
se buscará en las carpetas de node_modules locales y globales y arrojará un error si no se
encuentran módulos coincidentes.
Exportando con sintaxis ES6
Este es el equivalente del otro ejemplo, pero en su lugar utiliza ES6.
export function printHelloWorld() {
console.log("Hello World!!!");
}
Lea Exportando e importando el módulo en node.js en línea: https://riptutorial.com/es/node-
js/topic/1173/exportando-e-importando-el-modulo-en-node-js
https://riptutorial.com/es/home 173

-- 201 of 423 --
