# 15. Se desapila callback()

## Fuente
javascript-asincronismo (Cap. 15)

## Contenido
# 15. Se desapila callback()

console.log("Op. sync #1");
setTimeout(function callback() {
console.log("Op. async #2");
}, 2000); // 2 segundos de demora
console.log("Op. sync #3");
Ver GIF

-- 13 of 40 --

Asincronismo en JavaScript
Paso a paso
function operacionSync(n) {
console.log(`Operación sync #${n}`);
}
function mostrarNoticiasAsync() {
setTimeout(function getNoticias() {
console.log("2) Obtenidas noticias desde API propia...");
}, 7000); // Simulamos 7 segundos de demora
}
function mostrarClimaAsync() {
setTimeout(function getClima() {
console.log("4) Obtenido clima desde weather-api...");
}, 3000); // Simulamos 3 segundos de demora
}
function mostrarPublicidadAsync() {
setTimeout(function getPublicidad() {
console.log("6) Obtenida imagen desde web externa");
}, 5000); // Simulamos 5 segundos de demora
}
operacionSync(1);
mostrarNoticiasAsync();
operacionSync(3);
mostrarClimaAsync();
operacionSync(5);
mostrarPublicidadAsync();
operacionSync(7);
https://www.jsv9000.app/
En esta app web se puede comprobar de forma gráfica e interactiva cómo
funciona paso a paso el Event Loop de JavaScript que gestiona el asincronismo.

-- 14 of 40 --

Asincronismo en JavaScript
Primero lo sync, luego lo async
const procesarSync = (ciclos) => {
for (let i = 0; i < ciclos; i++) {
new Date().toString().toUpperCase();
} // Solo produce carga para la CPU
return `${ciclos} ciclos procesados.`
}
const procesarAsync = () => {
setTimeout(() => {
console.log("Op. async");
}, 0); // No demora nada, pero es async
}
console.log(procesarSync(10));
procesarAsync();
console.log(procesarSync(1000000));
JavaScript no procesará los callbacks de las llamadas asíncronas hasta que no se completen las
llamadas síncronas, aun cuando éstas últimas demoren más tiempo.
Mientras no termine
procesarSync(1000000), el
callback de procesarAsync()
deberá esperar.
Varios segundos
luego… 🕛🕒🕕
Probar ejecución en JSV9000

-- 15 of 40 --

Asincronismo en JavaScript
Esperar por valor async
Es muy común requerir datos de forma externa a nuestra app y tener que esperarlos para procesar algún resultado.
¿Cómo aguardamos que concluya la operación para evitar este escenario?
const getResultadoAsync = () => {
let resultado;
setTimeout(() => {
resultado = "elResultado";
}, 5000);
return resultado;
}
const data = getResultadoAsync();
console.log(data); // undefined
console.log("Otra operación...");
Tarda 5 segundos
Aún no se sabe Captura de la consola

-- 16 of 40 --

Asincronismo en JavaScript
Manejar asincronismo en JavaScript
La sintaxis para manejar asincronismo en JavaScript
ha ido evolucionando a lo largo del tiempo.
https://anexsoft.com/javascript-callbacks-vs-promise-vs-asyncawait
Callbacks
Promesas
Introducidas en ES6 2015
async / await
Introducidos en ES6 2017

-- 17 of 40 --

Asincronismo en JavaScript
Asincronismo con callbacks
La función realizarAccionAsync es quien ejecutará la tarea asíncrona, recibiendo parámetros
como cualquier otra, pero en especial también la referencia a una función que oficie de callback.
Cuando se complete la tarea asíncrona, se invocará al callback con el resultado obtenido.
https://lenguajejs.com/javascript/asincronia/callbacks/#asincron%C3%ADa-con-callbacks
const realizarAccionAsync = (param1, param2, callback) => {
/* Se realizan las acciones asíncronas.
Se invoca a callback() cuando finaliza.
Por convención:
Si hubo errores: callback(elError, undefined);
Si hubo éxito: callback(null, data);
*/
}
const procesarResultado = (err, res) => {
/* Usar 'err' o 'res' según sea el caso */
}
realizarAccionAsync("arg1", "arg2", procesarResultado);
// realizarAccionAsync( "arg1", "arg2", procesarResultado() );
Por convención, el callback espera
recibir dos valores como parámetros:
un error y un resultado, en ese orden.
En general, si existe un
error, la respuesta será
undefined, de lo contrario,
será un valor válido.
No poner paréntesis.
Queremos enviar la
referencia de la función, no
queremos ejecutarla aún.
Nombrar a los parámetros callback, err o res son convenciones/costumbres. Podrían nombrarse de cualquier forma.

-- 18 of 40 --

Asincronismo en JavaScript
Simulacro de asincronismo con callback
La función getPersonaByID simulará una conexión con una BD para buscar un registro por ID y devolverlo.
Si no existe, devolverá un objeto que representa un error.
const getPersonaByID = (id, callback) => {
console.log(`Vamos a buscar ID ${id} en la BD. Paciencia...`);
setTimeout(() => {
if (id > 0) {
const per = { id, nombre: "Pepe" }; // ES6
// const per = {id: id, nombre: "Pepe"}; //ES5
callback(null, per);
} else {
const unError = {
error: true,
msg: `No se encontró persona con ID ${id}`
}
callback(unError); // Equivalente: callback(unError, undefined);
}
}, 3000); // Demora 3 segundos
}
const procesarPersona = (err, res) => {
if (err) { // Equivalente: (err != undefined)
console.error(`ERROR: ${err.msg}`);
} else {
console.log("¡Se encontró 1 registro!", res);
}
}
getPersonaByID(10, procesarPersona);
getPersonaByID(-4, procesarPe
