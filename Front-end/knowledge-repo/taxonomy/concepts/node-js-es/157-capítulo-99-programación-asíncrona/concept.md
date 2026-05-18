# Capítulo 99:: Programación asíncrona

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 157)

## Contenido
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
devolución de llamada como 
