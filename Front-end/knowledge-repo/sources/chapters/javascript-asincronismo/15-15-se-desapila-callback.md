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
getPersonaByID(-4, procesarPersona);
3 segundos luego…
🕛🕒🕕

-- 19 of 40 --

Asincronismo en JavaScript
Uso de XMLHttpRequest para peticiones HTTP
Gracias a objetos de tipo XMLHttpRequest de AJAX es posible recibir datos de un
servidor de forma asíncrona, sin recargar la página web.
https://developer.mozilla.org/es/docs/Web/Guide/AJAX/Getting_Started
const xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function () {
// Aquí van las operaciones...
};
xhttp.open("GET", laUrl, true);
xhttp.send();
Inicializa la solicitud enviando qué método HTTP usar
(GET, POST, etc.), la URL y un booleano que indica si la
operación será asíncrona o no (por defecto, true)
Se crea un objeto de tipo XMLHttpRequest
Se envía la referencia a una
función para ser invocada
cuando ocurra el evento
readystatechange.
Se envía la solicitud
xhttp.onreadystatechange = function () {
if (this.readyState == 4) {
// https://www.w3schools.com/tags/ref_httpmessages.asp
if (this.status == 200) {
// Petición exitosa
// this.responseText: Respuesta del servidor como String
// this.responseXML: Respuesta del servidor como XML
// JSON.parse(this.responseText): Parseado a JSON
} else {
// Error en la petición
}
} else {
// Aún no está listo
}
};
Para comprobar que la petición fue correcta

-- 20 of 40 --

Asincronismo en JavaScript
APIs de prueba
nationalize.io es un API que predice la nacionalidad en base a
un nombre de pila.
{
"name": "manolo",
"country": [{
"country_id": "ES",
"probability": 0.3459614259041762
},
{
"country_id": "EC",
"probability": 0.15046485347831998
},
{
"country_id": "PE",
"probability": 0.09927136127621772
}
]
}
https://api.nationalize.io/?name=manolo
REST Countries es un API que devuelve información
sobre países (JSON de ejemplo recortado).
[
{
"name": {
"common": "Spain",
"official": "Kingdom of Spain",
"nativeName": {
"spa": {
"official": "Reino de España",
"common": "España"
}
}
},
"capital": [
"Madrid"
],
"languages": {
"spa": "Spanish"
},
"flags": {
"png": "https://flagcdn.com/w320/es.png",
"svg": "https://flagcdn.com/es.svg"
}
}
]
https://restcountries.com/v3.1/alpha/es
Más APIs públicas y gratuitas:
https://github.com/public-apis/public-apis

-- 21 of 40 --

Asincronismo en JavaScript
Uso de callback para app de nombre
Pedimos el nombre al usuario (se espera sin espacios) y
obtenemos un listado de nacionalidades probables, gracias a la
API de nationalize.io.
Mostramos el ID del país que tenga la máxima probabilidad.
const getRespuestaHttp = (url, callback) => {
const OK = 200; const DONE = 4;
const xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function () { // Se usa function para que el this quede ligado
if (this.readyState == DONE) {
if (this.status == OK) {
const resp = JSON.parse(this.responseText);
callback(null, resp);
} else
callback(this.response ? JSON.parse(this.response) : { error: "Desconocido" });
}
};
xhttp.open("GET", url, true);
xhttp.send();
}
const averiguarPais = nombre => {
let url = `https://api.nationalize.io/?name=${nombre}`;
getRespuestaHttp(url, (err, res) => { // Esta es la función callback
if (err)
alert(`Error: ${err.error}`);
else {
let paisMasProb = res.country.reduce((a, b) => {
return a.probability > b.probability ? a : b;
}, 0);
alert(`País más probable: ${paisMasProb.country_id}`);
}
});
};
let nombre = prompt("¿Cuál es tu nombre?");
averiguarPais(nombre);
🕛🕒🕕
Modificá la url para que sea incorrecta y así poder testear
cómo se comporta el callback ante un error, por ejemplo:
const url = `https://api.nationalize.io/?nazme=${nombre}`;
const url = `https://api.nawtionalize.io/?name=${nombre}`;

-- 22 of 40 --

Asincronismo en JavaScript
Anidamiento de callbacks
Pedimos el nombre al usuario (se espera sin
espacios) y obtenemos un listado de nacionalidades
probables, gracias a la API de nationalize.io.
Tomamos el ID del país que tenga la máxima
probabilidad y obtenemos el nombre del país en
español, gracias a la API de REST Countries.
const getRespuestaHttp = (url, callback) => {
const OK = 200; const DONE = 4;
const xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function () { // Se usa function para que el this quede ligado
if (this.readyState == DONE) {
if (this.status == OK) {
const resp = JSON.parse(this.responseText);
callback(null, resp);
} else
callback(this.response ? JSON.parse(this.response) : { error: "Desconocido" });
}
};
xhttp.open("GET", url, true);
xhttp.send();
}
const averiguarPais = nombre => {
let url = `https://api.nationalize.io/?name=${nombre}`;
getRespuestaHttp(url, (err, res) => {
if (err)
alert(`Error: ${err.error}`);
else {
let paisMasProb = res.country.reduce((a, b) => {
return a.probability > b.probability ? a : b;
}, 0);
url = `https://restcountries.com/v3.1/alpha/${paisMasProb.country_id}`;
getRespuestaHttp(url, (err, res) => {
if (err)
alert(`Error: ${err.error}`);
else {
alert(`Probablemente seas de ${res[0].translations.spa.common}`);
}
});
}
});
};
let nombre = prompt("¿Cuál es tu nombre?");
averiguarPais(nombre);
🕛🕒🕕

-- 23 of 40 --

Asincronismo en JavaScript
“Callback Hell”
https://blog.nearsoftjobs.com/the-callback-hell-6cc184ce8704
Cuando se anidan llamadas asíncronas, donde cada una depende del resultado de la anterior, se obtiene
un código difícil de leer y mantener, conocido como “Callback Hell” (Infierno de las devoluciones de
llamada) o “Pyramid of Doom” (Pirámide del Doom)
Esto motivó la creación de las Promesas en ES6
Muchas librerías aún no han sido actualizadas y funcionan solo con callbacks.
const averiguarPais = (nombre) => {
let url = `https://api.nationalize.io/?name=${nombre}`;
getRespuestaHttp(url, (err, res) => {
if (err)
alert(`Error: ${err.error}`);
else {
let paisMasProb = res.country.reduce((a, b) => {
return a.probability > b.probability ? a : b;
}, 0);
url = `https://restcountries.com/v3.1/alpha/${paisMasProb.country_id}`;
getRespuestaHttp(url, (err, res) => {
if (err)
alert(`Error: ${err.error}`);
else {
alert(`Probablemente seas de ${res[0].translations.spa.common}`);
}
});
}
});
};

-- 24 of 40 --

Asincronismo en JavaScript
Promesas
https://developer.mozilla.org/es/docs/Web/JavaScript/Reference/Global_Objects/Promise
Una promesa es un objeto, que representa el resultado de una operación
asíncrona, la cual puede conocerse al instante, a futuro o nunca.
new Promise( function(resolveCallback, rejectCallback) { ... } );
A la hora de crear una promesa, se le envía una función que
recibe dos callbacks: uno que se llamará en caso de éxito
(resolve) y otro que se llamará en caso de error (reject).
laPromesa.then(callbackExito, callbackError);
A la hora de consumir una promesa, se invoca al método then enviando un
callback para manejar un resultado exitoso y otro para manejar un posible error.
https://media.vlpt.us/images/edie_ko/
post/e32022c2-24fb-49dc-8d93-
3e014daeacef/Creating-Promises.png
https://www.freecodecamp.org/news/content/imag
es/2020/06/Ekran-Resmi-2020-06-06-12.21.27.png
Como then devuelve una nueva promesa, se puede obtener el mismo efecto
encadenando un llamado al método catch, para hacerlo más legible.
laPromesa.then(callbackExito).catch(callbackError);

-- 25 of 40 --

Asincronismo en JavaScript
Asincronismo con Promesas
La función realizarAccionAsync es quien ejecutará la tarea asíncrona, recibiendo parámetros
como cualquier otra, pero devolviendo una promesa de que habrá pronto una respuesta.
https://developer.mozilla.org/es/docs/Web/JavaScript/Guide/Using_promises
const realizarAccionAsync = (param1, param2) => {
return new Promise((resolve, reject) => {
/* Se realizan las acciones asíncronas.
Si hubo errores: reject(elError);
Si hubo éxito: resolve(data);
*/
});
}
realizarAccionAsync("arg1", "arg2")
.then(res => {
// Hacer algo con el resultado
})
.catch(err => {
// Hacer algo con el error
})
Al método then se le envía el callback a
invocar en caso éxito (resolve)
La función que recibe ambos
callbacks y se envía al
constructor de la promesa se
denomina ejecutor (executor)
Al método catch se le envía el callback
a invocar en caso de error (reject)
Usar nombres como resolve o reject son convenciones/costumbres. then y catch deben invocarse así por definición de la clase Promise.

-- 26 of 40 --

Asincronismo en JavaScript
Estado de una promesa
https://javascript.plainenglish.io/exploring-javascript-promises-in-depth-d07541c8ca9f
Toda promesa tiene un estado definido, entre otras cosas, por los atributos state y result
(no accesibles directamente).
new Promise((resolve, reject) => {
/* Se realizan las acciones asíncronas.
Si hubo errores: reject(elError);
Si hubo éxito: resolve(data);
*/
});
La promesa cambiará de estado según a qué callback invoque (o será pendiente para siempre si no lo hace).
Una promesa no cambia de estado una vez que haya pasado a ser cumplida (fulfilled) o rechazada (rejected).

-- 27 of 40 --

Asincronismo en JavaScript
Simulacro de asincronismo con Promesa
La función getPersonaByID simulará una conexión con una BD para buscar un registro por ID y devolverlo.
Si no existe, devolverá un objeto que representa un error.
Aprendé más en mi canal de Youtube
const getPersonaByID = id => {
return new Promise((resolve, reject) => {
console.log(`Vamos a buscar ID ${id} en la BD. Paciencia...`);
setTimeout(() => {
if (id > 0) {
const per = { id, nombre: "Pepe" }; // ES6
// const per = {id: id, nombre: "Pepe"}; //ES5
resolve(per);
} else {
const unError = {
error: true,
msg: `No se encontró persona con ID ${id}`
}
reject(unError);
}
}, 3000); // Demora 3 segundos
});
}
getPersonaByID(4).then(res => {
console.log("Mostrando resultado en 'then'", res);
}).catch(err => {
console.err("Mostrando error en 'catch'", err);
});
getPersonaByID(-1).then(res => {
console.log("Mostrando resultado en 'then'", res);
}).catch(err => {
console.error("Mostrando error en 'catch'", err);
});
3 segundos luego…
🕛🕒🕕

-- 28 of 40 --

Asincronismo en JavaScript
Promesas vs. callbacks
Comparemos el siguiente código usando una u otra metodología
https://developer.mozilla.org/es/docs/Web/JavaScript/Guide/Using_promises
operacionAsync1(res => {
operacionAsync2(res, res2 => {
operacionAsync3(res2, resFinal => {
console.log(`Obtenido el res final: ${resFinal}`);
}, errorCallback);
}, errorCallback);
}, errorCallback);
operacionAsync1()
.then(res => {
return operacionAsync2(res);
})
.then(res2 => {
return operacionAsync3(res2);
})
.then(resFinal => {
console.log(`Obtenido el res final: ${resFinal}`);
})
.catch(errorCallback);
Usando promesas
Usando callbacks
Nótese que, usando promesas, solo hubo que enviar una sola vez la referencia al callback que maneja el error.
Si ocurre algún error en la cadena de then, se saltará al catch, como ocurre tradicionalmente con try-catch.

-- 29 of 40 --

Asincronismo en JavaScript
Las promesas tienen prioridad
// Llamada asíncrona con callback.
setTimeout(() => console.log("UNO"), 0);
// Llamada asíncrona con promesa.
Promise.resolve().then(() => console.log("DOS"));
// Llamada síncrona
console.log("TRES");
Es común usar promesas en la comunicación con APIs externas que no queremos retrasar o mezclar
con otras funciones asíncronas como eventos del usuario o retardos.
ES6 establece una “microstask queue” que gestiona los callbacks de las promesas con mayor prioridad.
Probar ejecución en JSV9000
https://javascript.info/microtask-queue

-- 30 of 40 --

Asincronismo en JavaScript
Uso de fetch() para peticiones HTTP
La función fetch es la evolución de XMLHttpRequest de AJAX.
Se le envía una URL y retorna una promesa.
https://developer.mozilla.org/es/docs/Web/API/Fetch_API/Using_Fetch
fetch(laURL)
.then(res => {
console.log(res);
return res.json();
})
.then(resJSON => {
console.log(resJSON);
})
.catch(err => {
console.error(err);
})
Como el anterior then
retornó una nueva promesa,
se encadena otro..
res es un objeto de tipo Response
json() es un método de Response
que devuelve una nueva promesa.
El catch captura cualquier
error durante la cadena de
promesas..
Para comprobar que la petición fue correcta
fetch(laURL)
.then(res => {
if (res.ok) {
// Continuar con las operaciones
} else {
throw new Error( /*Elegir qué enviar*/ );
}
})
.catch((error) => {
// Manejar el error
});

-- 31 of 40 --

Asincronismo en JavaScript
Uso de promesa para app de nombre
Pedimos el nombre al usuario (se espera sin espacios) y
obtenemos un listado de nacionalidades probables, gracias a la
API de nationalize.io.
Mostramos el ID del país que tenga la máxima probabilidad.
const handleFetch = url => {
return fetch(url)
.then(handleError);
}
const handleError = (res) => {
if (!res.ok) throw new Error(res.statusText);
return res;
}
const averiguarPais = nombre => {
let url = `https://api.nationalize.io/?name=${nombre}`;
handleFetch(url)
.then(res => res.json())
.then(resJSON => {
let paisMasProb = resJSON.country.reduce((a, b) => {
return a.probability > b.probability ? a : b;
}, 0);
alert(`País más probable: ${paisMasProb.country_id}`);
})
.catch(err => {
alert(err);
});
};
let nombre = prompt("¿Cuál es tu nombre?");
averiguarPais(nombre);
🕛🕒🕕
Modificá la url para que sea incorrecta y así poder testear
cómo se comporta la promesa ante un error, por ejemplo:
const url = `https://api.nationalize.io/?nazme=${nombre}`;
const url = `https://api.nawtionalize.io/?name=${nombre}`;

-- 32 of 40 --

Asincronismo en JavaScript
Encadenamiento de
promesas
Pedimos el nombre al usuario (se espera sin espacios) y
obtenemos un listado de nacionalidades probables,
gracias a la API de nationalize.io.
Tomamos el ID del país que tenga la máxima probabilidad
y obtenemos el nombre del país en español, gracias a la
API de REST Countries.
const handleFetch = url => {
return fetch(url)
.then(handleError);
}
const handleError = (response) => {
if (!response.ok) throw new Error(response.statusText);
return response;
}
const averiguarPais = nombre => {
let url = `https://api.nationalize.io/?name=${nombre}`;
handleFetch(url)
.then(res => res.json())
.then(resJSON => {
let paisMasProb = resJSON.country.reduce((a, b) => {
return a.probability > b.probability ? a : b;
}, 0);
return paisMasProb.country_id;
})
.then(codPais => {
url = `https://restcountries.com/v3.1/alpha/${codPais}`;
handleFetch(url)
.then(res => res.json())
.then(resJSON => {
alert(`Probablemente seas de ${resJSON[0].translations.spa.common}`);
})
})
.catch(err => {
alert(err);
});
};
let nombre = prompt("¿Cuál es tu nombre?");
averiguarPais(nombre);
🕛🕒🕕
Error común: Si fetch falla, no se captura
el error y se rompe la cadena. (Ver más)
Solución en la siguiente diapositiva..

-- 33 of 40 --

Asincronismo en JavaScript
Encadenamiento de promesas
(Mejorado)
Pedimos el nombre al usuario (se espera sin espacios) y obtenemos un
listado de nacionalidades probables, gracias a la API de nationalize.io.
Tomamos el ID del país que tenga la máxima probabilidad y obtenemos
el nombre del país en español, gracias a la API de REST Countries.
const handleFetch = url => {
return fetch(url)
.then(handleError);
}
const handleError = (response) => {
if (!response.ok) throw new Error(response.statusText);
return response;
}
const averiguarPais = nombre => {
let url = `https://api.nationalize.io/?name=${nombre}`;
handleFetch(url)
.then(res => res.json())
.then(resJSON => {
let paisMasProb = resJSON.country.reduce((a, b) => {
return a.probability > b.probability ? a : b;
}, 0);
return paisMasProb.country_id;
})
.then(codPais => {
url = `https://restcountries.com/v3.1/alpha/${codPais}`;
return handleFetch(url);
})
.then(res => res.json())
.then(resJSON => {
alert(`Probablemente seas de ${resJSON[0].translations.spa.common}`);
})
.catch(err => {
alert(err);
});
};
let nombre = prompt("¿Cuál es tu nombre?");
averiguarPais(nombre);
🕛🕒🕕
Solución: Retornar la promesa y
mantener la cadena plana. (Ver más)

-- 34 of 40 --

Asincronismo en JavaScript
async / await
https://www.w3schools.com/js/js_async.asp
async y await son dos nuevas palabras clave que agregan azúcar sintáctico
al manejo de asincronismo con promesas.
async function funcionAsync() {
return "Resultado";
}
console.log( funcionAsync() );
funcionAsync()
.then(res => console.log(res));
La palabra async delante de una función
hará que esta devuelva una promesa.
async hace que se
retorne una promesa.
Muestra la promesa
por consola.
Como en cualquier promesa,
el resultado se procesa en el
callback del then..
async function funcionAsync() {
return "Resultado";
}
async function mostrarResultado() {
let res = await funcionAsync();
console.log(res);
}
mostrarResultado();
Solo puede usarse
await dentro de
una función async. Esperamos el resultado
con await sin usar then..
La palabra await aguarda por el
resultado de una promesa.

-- 35 of 40 --

Asincronismo en JavaScript
Simulacro de asincronismo con async / await
La función getPersonaByID simulará una conexión con una BD para buscar un registro por ID y devolverlo.
Si no existe, devolverá un objeto error.
const getPersonaByID = id => {
return new Promise((resolve, reject) => {
console.log(`Vamos a buscar ID ${id} en la BD. Paciencia...`);
setTimeout(() => {
if (id > 0) {
const per = { id, nombre: "Pepe" }; // ES6
// const per = {id: id, nombre: "Pepe"}; //ES5
resolve(per);
} else {
const unError = {
error: true,
msg: `No se encontró persona con ID ${id}`
}
reject(unError);
}
}, 3000); // Demora 3 segundos
});
}
async function testear(id) {
try {
let res = await getPersonaByID(id);
console.log("Mostrando resultado en el 'try'", res);
} catch(e) {
console.error("Mostrando error capturado en 'catch'", e);
}
}
testear(10);
testear(-1);
3 segundos luego…
🕛🕒🕕

-- 36 of 40 --

Asincronismo en JavaScript
Promesas vs. async / await
Comparemos el siguiente pseudocódigo usando una u otra sintaxis.
https://developer.mozilla.org/es/docs/Web/JavaScript/Reference/Statements/async_function#reescritura_de_una_cadena_de_promesas_con_una_funci%C3%B3n_async
async function probar() {
try {
let res = await operacionAsync1();
let res2 = await operacionAsync2(res);
let resFinal = await operacionAsync3(res2);
console.log(`Obtenido el resultado final: ${resultadoFinal}`);
} catch (error) {
console.error(`Ocurrió un error: ${error}`);
}
}
operacionAsync1().then(res => {
return operacionAsync2(res);
})
.then(res2 => {
return operacionAsync3(res2);
})
.then(resFinal => {
console.log(`Obtenido el res final: ${resFinal}`);
})
.catch(errorCallback);
Usando promesas Usando async / await
Con async / await se logra un código más cercano a la forma tradicional síncrona.

-- 37 of 40 --

Asincronismo en JavaScript
Uso de async/await para app de nombre
Pedimos el nombre al usuario (se espera sin espacios) y
obtenemos un listado de nacionalidades probables, gracias a la
API de nationalize.io.
Mostramos el ID del país que tenga la máxima probabilidad.
const handleFetch = async url => {
const res = await fetch(url);
return await handleError(res);
}
const handleError = (res) => {
if (!res.ok) throw new Error(res.statusText);
return res;
}
const averiguarPais = async nombre => {
let url = `https://api.nationalize.io/?name=${nombre}`;
try {
const res = await handleFetch(url);
const resJSON = await res.json();
let paisMasProb = resJSON.country.reduce((a, b) => {
return a.probability > b.probability ? a : b;
}, 0);
alert(`País más probable: ${paisMasProb.country_id}`);
} catch (err) {
alert(err);
}
};
let nombre = prompt("¿Cuál es tu nombre?");
averiguarPais(nombre);
🕛🕒🕕
Modificá la url para que sea incorrecta y así poder testear
cómo se comporta la promesa ante un error, por ejemplo:
const url = `https://api.nationalize.io/?nazme=${nombre}`;
const url = `https://api.nawtionalize.io/?name=${nombre}`;

-- 38 of 40 --

Asincronismo en JavaScript
Encadenamiento de
promesas
con async / await
Pedimos el nombre al usuario (se espera sin espacios) y
obtenemos un listado de nacionalidades probables, gracias a la
API de nationalize.io.
Tomamos el ID del país que tenga la máxima probabilidad y
obtenemos el nombre del país en español, gracias a la API de
REST Countries.
const handleFetch = async url => {
const res = await fetch(url);
return await handleError(res);
}
const handleError = (res) => {
if (!res.ok) throw new Error(res.statusText);
return res;
}
const averiguarPais = async nombre => {
let url = `https://api.nationalize.io/?name=${nombre}`;
try {
let res = await handleFetch(url);
let resJSON = await res.json();
let paisMasProb = resJSON.country.reduce((a, b) => {
return a.probability > b.probability ? a : b;
}, 0);
const codPais = paisMasProb.country_id;
url = `https://restcountries.com/v3.1/alpha/${codPais}`;
res = await handleFetch(url);
resJSON = await res.json();
alert(`Probablemente seas de ${resJSON[0].translations.spa.common}`);
} catch (err) {
alert(err);
}
};
let nombre = prompt("¿Cuál es tu nombre?");
averiguarPais(nombre);
🕛🕒🕕

-- 39 of 40 --

Asincronismo en JavaScript