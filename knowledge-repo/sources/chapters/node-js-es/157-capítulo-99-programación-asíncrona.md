# Capítulo 99:: Programación asíncrona

Introducción
Nodo es un lenguaje de programación donde todo podría ejecutarse de forma asíncrona. A
continuación puede encontrar algunos ejemplos y las cosas típicas del trabajo asíncrono.
Sintaxis
doSomething ([args], function ([argsCB]) {/ * hace algo cuando se hace * /});	•
doSomething ([args], ([argsCB]) => {/ * hace algo cuando se hace * /});	•
Examples
Funciones de devolución de llamada
Funciones de devolución de llamada en
JavaScript
Las funciones de devolución de llamada son comunes en JavaScript. Las funciones de devolución
de llamada son posibles en JavaScript porque las funciones son ciudadanos de primera clase .
Devolución de llamadas sincrónica.
Las funciones de devolución de llamada pueden ser síncronas o asíncronas. Como las funciones
de devolución de llamada asíncrona pueden ser más complejas, aquí hay un ejemplo simple de
una función de devolución de llamada sincrónica.
// a function that uses a callback named `cb` as a parameter
function getSyncMessage(cb) {
cb("Hello World!");
}
console.log("Before getSyncMessage call");
// calling a function and sending in a callback function as an argument.
getSyncMessage(function(message) {
console.log(message);
});
console.log("After getSyncMessage call");
La salida para el código anterior es:
> Before getSyncMessage call
> Hello World!
https://riptutorial.com/es/home 340

-- 368 of 423 --

> After getSyncMessage call
Primero veremos cómo se ejecuta el código anterior. Esto es más para aquellos que no entienden
el concepto de devoluciones de llamada, si ya lo entienden, no dude en omitir este párrafo.
Primero se analiza el código y luego lo primero que sucede es que se ejecuta la línea 6, que
emite Before getSyncMessage call a la consola. Luego se ejecuta la línea 8 que llama a la función
getSyncMessage enviando una función anónima como un argumento para el parámetro llamado cb
en la función getSyncMessage . La ejecución ahora se realiza dentro de la función getSyncMessage en
la línea 3 que ejecuta la función cb que se acaba de pasar, esta llamada envía una cadena de
argumento "Hello World" para el message param llamado en la función anónima pasada. La
ejecución luego pasa a la línea 9 que registra Hello World! a la consola. Luego, la ejecución pasa
por el proceso de salir de la pila de llamadas ( ver también ) golpeando la línea 10, luego la línea
4 y, finalmente, de nuevo a la línea 11.
Alguna información para saber sobre devoluciones de llamada en general:
La función que envía a una función como devolución de llamada se puede llamar cero
veces, una o varias veces. Todo depende de la implementación.
•
La función de devolución de llamada se puede llamar de forma síncrona o asíncrona y
posiblemente tanto de forma síncrona como asíncrona.
•
Al igual que las funciones normales, los nombres que le asignan parámetros a su función no
son importantes, pero el orden es. Entonces, por ejemplo, en la línea 8, el message parámetro
podría haber sido nombrado statement , msg , o si no tiene sentido algo como jellybean . Por
lo tanto, debe saber qué parámetros se envían a su devolución de llamada para que pueda
obtenerlos en el orden correcto con nombres propios.
•
Devolución de llamadas asíncronas.
Una cosa a tener en cuenta sobre JavaScript es que es sincrónica de forma predeterminada, pero
hay API en el entorno (navegador, Node.js, etc.) que podrían hacerlo asíncrono (hay más
información al respecto aquí ).
Algunas cosas comunes que son asíncronas en entornos de JavaScript que aceptan
devoluciones de llamada:
Eventos	•
setTimeout	•
setInterval	•
la API fetch	•
Promesas	•
Además, cualquier función que utilice una de las funciones anteriores se puede ajustar con una
función que recibe una devolución de llamada y la devolución de llamada sería una devolución de
llamada asíncrona (aunque el ajuste de una promesa con una función que recibe una devolución
de llamada probablemente se considere un antipatrón como Hay formas más preferidas para
manejar las promesas).
https://riptutorial.com/es/home 341

-- 369 of 423 --

Entonces, dada esa información, podemos construir una función asíncrona similar a la anterior
sincrónica.
// a function that uses a callback named `cb` as a parameter
function getAsyncMessage(cb) {
setTimeout(function () { cb("Hello World!") }, 1000);
}
console.log("Before getSyncMessage call");
// calling a function and sending in a callback function as an argument.
getAsyncMessage(function(message) {
console.log(message);
});
console.log("After getSyncMessage call");
Lo que imprime lo siguiente en la consola:
> Before getSyncMessage call
> After getSyncMessage call
// pauses for 1000 ms with no output
> Hello World!
La ejecución de la línea va a los registros de la línea 6 "Antes de la llamada getSyncMessage".
Luego, la ejecución pasa a la línea 8 que llama a getAsyncMessage con una devolución de
llamada para el parámetro cb . Luego se ejecuta la línea 3 que llama a setTimeout con una
devolución de llamada como primer argumento y el número 300 como segundo argumento.
setTimeout hace lo que hace y se mantiene en esa devolución de llamada para que pueda llamarla
más tarde en 1000 milisegundos, pero luego de configurar el tiempo de espera y antes de que se
detenga, los 1000 milisegundos le devuelven la ejecución al lugar donde se detuvo, por lo que
pasa a la línea 4 , luego la línea 11, y luego se detiene por 1 segundo y setTimeout luego llama a
su función de devolución de llamada que devuelve la ejecución a la línea 3 donde se
getAsyncMessages devolución de llamada getAsyncMessages con el valor "Hola Mundo" para su
message parámetro que luego se registra en la consola en la línea 9 .
Funciones de devolución de llamada en
Node.js
NodeJS tiene devoluciones de llamada asíncronas y comúnmente proporciona dos parámetros a
sus funciones, algunas veces llamadas convencionalmente err y data . Un ejemplo con la lectura
de un archivo de texto.
const fs = require("fs");
fs.readFile("./test.txt", "utf8", function(err, data) {
if(err) {
// handle the error
} else {
// process the file text given with data
}
https://riptutorial.com/es/home 342

-- 370 of 423 --

});
Este es un ejemplo de una devolución de llamada que se llama una sola vez.
Es una buena práctica manejar el error de alguna manera, incluso si solo lo está registrando o
lanzando. El dato no es necesario si lanza o regresa y puede eliminarse para disminuir la sangría
siempre que detenga la ejecución de la función actual en el 'if' haciendo algo como lanzar o
devolver.
Aunque puede ser común ver err , los data pueden no ser siempre el caso de que sus
devoluciones de llamada utilicen ese patrón, es mejor consultar la documentación.
Otro ejemplo de devolución de llamada proviene de la biblioteca Express (Express 4.x):
// this code snippet was on http://expressjs.com/en/4x/api.html
const express = require('express');
const app = express();
// this app.get method takes a url route to watch for and a callback
// to call whenever that route is requested by a user.
app.get('/', function(req, res){
res.send('hello world');
});
app.listen(3000);
Este ejemplo muestra una devolución de llamada que se llama varias veces. La devolución de
llamada se proporciona con dos objetos como parámetros nombrados aquí como req y res estos
nombres corresponden a solicitud y respuesta, respectivamente, y brindan formas de ver la
solicitud que entra y configurar la respuesta que se enviará al usuario.
Como puede ver, hay varias formas en que se puede utilizar una devolución de llamada para
ejecutar la sincronización y el código asíncrono en JavaScript y las devoluciones de llamada son
muy omnipresentes en todo JavaScript.
Ejemplo de código
Pregunta: ¿Cuál es la salida del código a continuación y por qué?
setTimeout(function() {
console.log("A");
}, 1000);
setTimeout(function() {
console.log("B");
}, 0);
getDataFromDatabase(function(err, data) {
console.log("C");
setTimeout(function() {
console.log("D");
}, 1000);
});
https://riptutorial.com/es/home 343

-- 371 of 423 --

console.log("E");
Salida: Esto es seguro: EBAD . C se desconoce cuando se registrará.
Explicación: El compilador no se detendrá en la setTimeout y los getDataFromDatabase methodes.
Así que la primera línea que registrará es E Las funciones de devolución de llamada (primer
argumento de setTimeout ) se ejecutarán después del tiempo límite establecido de forma
asíncrona.
Más detalles:
E no tiene setTimeout	1.
B tiene un tiempo de espera establecido de 0 milisegundos	2.
A tiene un tiempo de espera establecido de 1000 milisegundos	3.
D debe solicitar una base de datos, luego D debe esperar 1000 milisegundos para que
aparezca después de A
4.
C se desconoce porque se desconoce cuando se solicitan los datos de la base de datos.
Podría ser antes o después de A
5.
Manejo asíncrono de errores
Trata de atraparlo
Los errores siempre deben ser manejados. Si está utilizando programación síncrona, podría usar
un try catch . ¡Pero esto no funciona si trabajas de forma asíncrona! Ejemplo:
try {
setTimeout(function() {
throw new Error("I'm an uncaught error and will stop the server!");
}, 100);
}
catch (ex) {
console.error("This error will not be work in an asynchronous situation: " + ex);
}
¡Los errores asíncronos solo se manejarán dentro de la función de devolución de llamada!
Posibilidades de trabajo
v0.8
Controladores de eventos
Las primeras versiones de Node.JS obtuvieron un controlador de eventos.
https://riptutorial.com/es/home 344

-- 372 of 423 --

process.on("UncaughtException", function(err, data) {
if (err) {
// error handling
}
});
v0.8
Dominios
Dentro de un dominio, los errores se liberan a través de los emisores de eventos. Al utilizar esto,
todos los errores, temporizadores y métodos de devolución de llamada solo se registran dentro
del dominio. Por un error, se envía un evento de error y no se bloquea la aplicación.
var domain = require("domain");
var d1 = domain.create();
var d2 = domain.create();
d1.run(function() {
d2.add(setTimeout(function() {
throw new Error("error on the timer of domain 2");
}, 0));
});
d1.on("error", function(err) {
console.log("error at domain 1: " + err);
});
d2.on("error", function(err) {
console.log("error at domain 2: " + err);
});
Infierno de devolución de llamada
El infierno de devolución de llamada (también una pirámide de efecto doom o boomerang) surge
cuando anida demasiadas funciones de devolución de llamada dentro de una función de
devolución de llamada. Aquí hay un ejemplo para leer un archivo (en ES6).
const fs = require('fs');
let filename = `${__dirname}/myfile.txt`;
fs.exists(filename, exists => {
if (exists) {
fs.stat(filename, (err, stats) => {
if (err) {
throw err;
}
if (stats.isFile()) {
fs.readFile(filename, null, (err, data) => {
if (err) {
throw err;
}
console.log(data);
});
}
https://riptutorial.com/es/home 345

-- 373 of 423 --

else {
throw new Error("This location contains not a file");
}
});
}
else {
throw new Error("404: file not found");
}
});
Cómo evitar el "Callback Hell"
Se recomienda anidar no más de 2 funciones de devolución de llamada. Esto le ayudará a
mantener la legibilidad del código y será mucho más fácil de mantener en el futuro. Si necesita
anidar más de 2 devoluciones de llamada, intente utilizar eventos distribuidos .
También existe una biblioteca llamada async que ayuda a gestionar las devoluciones de llamada
y su ejecución disponible en npm. Aumenta la legibilidad del código de devolución de llamada y le
brinda más control sobre el flujo de su código de devolución de llamada, lo que le permite
ejecutarlos en paralelo o en serie.
Promesas nativas
v6.0.0
Las promesas son una herramienta para la programación asíncrona. En JavaScript las promesas
son conocidas por sus métodos de then . Las promesas tienen dos estados principales
'pendientes' y 'resueltos'. Una vez que la promesa está "establecida", no puede volver a
"pendiente". Esto significa que las promesas son en su mayoría buenas para eventos que solo
ocurren una vez. El estado 'establecido' tiene dos estados también 'resuelto' y 'rechazado'. Puede
crear una nueva promesa utilizando la new palabra clave y pasando una función al constructor new
Promise(function (resolve, reject) {}) .
La función que se pasa al constructor de Promesa siempre recibe un primer y segundo
parámetro, normalmente llamados resolve y reject respectivamente. La denominación de estos
dos parámetros es convencional, pero pondrán la promesa en el estado "resuelto" o en el estado
"rechazado". Cuando se llama a cualquiera de estos, la promesa pasa de estar "pendiente" a
"resuelta". resolve se llama cuando la acción deseada, que a menudo es asíncrona, se ha
realizado y se reject si la acción ha fallado.
En el siguiente tiempo de espera es una función que devuelve una promesa.
function timeout (ms) {
return new Promise(function (resolve, reject) {
setTimeout(function () {
resolve("It was resolved!");
}, ms)
});
}
timeout(1000).then(function (dataFromPromise) {
// logs "It was resolved!"
https://riptutorial.com/es/home 346

-- 374 of 423 --

console.log(dataFromPromise);
})
console.log("waiting...");
salida de consola
waiting...
// << pauses for one second>>
It was resolved!
Cuando se llama a timeout, la función pasada al constructor Promise se ejecuta sin demora.
Luego se ejecuta el método setTimeout y su devolución de llamada se establece para activarse
en los siguientes milisegundos ms , en este caso ms=1000 . Dado que la devolución de llamada al
setTimeout no se activa, la función de tiempo de espera devuelve el control al alcance de la
llamada. La cadena de then se almacenan a continuación, los métodos que se llamará más tarde,
cuando / si la promesa se haya resuelto. Si hubiera métodos de catch aquí, también se
almacenarían, pero se dispararían cuando / si la promesa "rechazara".
El guión luego imprime 'esperando ...'. Un segundo después, el setTimeout llama a su devolución
de llamada que llama a la función de resolución con la cadena "¡Se resolvió!". Esa cadena se
pasa then la devolución de llamada del método de ese momento y luego se registra al usuario.
En el mismo sentido, puede ajustar la función asíncrona setTimeout, que requiere una devolución
de llamada, puede envolver cualquier acción asíncrona singular con una promesa.
Lea más sobre promesas en la documentación de JavaScript Promesas .
Lea Programación asíncrona en línea: https://riptutorial.com/es/node-js/topic/8813/programacion-
asincrona
https://riptutorial.com/es/home 347

-- 375 of 423 --