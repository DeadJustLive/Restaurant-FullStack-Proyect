# Capítulo 89:: Node.js v6 Nuevas

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 133)

## Contenido
# Capítulo 89:: Node.js v6 Nuevas

características y mejoras
Introducción
Con el nodo 6 se convierte en la nueva versión LTS del nodo. Podemos ver una serie de mejoras
en el idioma a través de los nuevos estándares de ES6 introducidos. Vamos a ver algunas de las
nuevas características introducidas y ejemplos de cómo implementarlas.
Examples
Parámetros de función predeterminados
function addTwo(a, b = 2) {
return a + b;
}
addTwo(3) // Returns the result 5
Con la adición de parámetros de función predeterminados, ahora puede hacer que los
argumentos sean opcionales y hacer que se ajusten a un valor de su elección.
Parámetros de descanso
function argumentLength(...args) {
return args.length;
}
argumentLength(5) // returns 1
argumentLength(5, 3) //returns 2
argumentLength(5, 3, 6) //returns 3
Al comenzar el último argumento de su función con ... todos los argumentos pasados a la
función se leen como una matriz. En este ejemplo, obtenemos varios argumentos y obtenemos la
longitud de la matriz creada a partir de esos argumentos.
Operador de propagación
function myFunction(x, y, z) { }
var args = [0, 1, 2];
myFunction(...args);
La sintaxis de propagación permite que una expresión se expanda en lugares donde se esperan
múltiples argumentos (para llamadas a funciones) o múltiples elementos (para literales de matriz)
o múltiples variables. Al igual que los demás parámetros, simplemente precede tu matriz con ...
https://riptutorial.com/es/home 283

-- 311 of 423 --

Funciones de flecha
La función de flecha es la nueva forma de definir una función en ECMAScript 6.
// traditional way of declaring and defining function
var sum = function(a,b)
{
return a+b;
}
// Arrow Function
let sum = (a, b)=> a+b;
//Function defination using multiple lines
let checkIfEven = (a) => {
if( a % 2 == 0 )
return true;
else
return false;
}
"esto" en la función de flecha
esta función se refiere al objeto de instancia utilizado para llamar a esa función, pero esta función
de flecha es igual a esta función en la que se define la función de flecha.
Entendamos usando el diagrama
Comprensión utilizando ejemplos.
var normalFn = function(){
console.log(this) // refers to global/window object.
https://riptutorial.com/es/home 284

-- 312 of 423 --

}
var arrowFn = () => console.log(this); // refers to window or global object as function is
defined in scope of global/window object
var service = {
constructorFn : function(){
console.log(this); // refers to service as service object used to call method.
var nestedFn = function(){
console.log(this); // refers window or global object because no instance object
was used to call this method.
}
nestedFn();
},
arrowFn : function(){
console.log(this); // refers to service as service object was used to call method.
let fn = () => console.log(this); // refers to service object as arrow function
defined in function which is called using instance object.
fn();
}
}
// calling defined functions
constructorFn();
arrowFn();
service.constructorFn();
service.arrowFn();
En la función de flecha, este es el ámbito léxico que es el ámbito de la función donde se define la
función de flecha.
El primer ejemplo es la forma tradicional de la definición de funciones y por lo tanto, esto se
refiere a objeto global / ventana.
En el segundo ejemplo, esto se usa dentro de la función de flecha, por lo tanto, se refiere al
alcance donde se define (que es ventanas u objeto global). En el tercer ejemplo, este es el objeto
de servicio, ya que el objeto de servicio se usa para llamar a la función.
En el cuarto ejemplo, la función de flecha está definida y se llama desde la función cuyo ámbito es
el servicio , por lo tanto, imprime el objeto de servicio .
Nota: - el objeto global se imprime en Node.Js y el objeto de Windows en el navegador.
Lea Node.js v6 Nuevas características y mejoras en línea: https://riptutorial.com/es/node-
js/topic/8593/node-js-v6-nuevas-caracteristicas-y-mejoras
https://riptutorial.com/es/home 285

-- 313 of 423 --
