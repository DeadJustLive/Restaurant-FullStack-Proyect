# 0. Éstos son una forma práctica de almacenar un conjunto de datos relacionados (como cadenas de

caracteres), aunque en realidad, un vector puede incluir múltiples tipos de datos, incluso otros vectores.
Un vector simple
var myArray = [ 'hola', 'mundo' ];
Acceder a los ítems del vector a través de su índice
var myArray = [ 'hola', 'mundo', 'foo', 'bar' ];
console.log(myArray[3]); // muestra en la consola 'bar'
Obtener la cantidad de ítems del vector
var myArray = [ 'hola', 'mundo' ];
console.log(myArray.length); // muestra en la consola 2
Cambiar el valor de un ítem de un vector
var myArray = [ 'hola', 'mundo' ];
myArray[1] = 'changed';
Como se muestra en el ejemplo “Cambiar el valor de un ítem de un vector” es posible cambiar el valor
de un ítem de un vector, sin embargo, por lo general, no es aconsejable.
Añadir elementos a un vector
var myArray = [ 'hola', 'mundo' ];
myArray.push('new');
Trabajar con vectores
var myArray = [ 'h', 'o', 'l', 'a' ];
var myString = myArray.join(''); // 'hola'
var mySplit = myString.split(''); // [ 'h', 'o', 'l', 'a' ]
16

-- 17 of 107 --

0.2.8. Objetos
Los objetos son elementos que pueden contener cero o más conjuntos de pares de nombres claves y
valores asociados a dicho objeto. Los nombres claves pueden ser cualquier palabra o número válido. El
valor puede ser cualquier tipo de valor: un número, una cadena, un vector, una función, incluso otro
objeto.
[Definición: Cuando uno de los valores de un objeto es una función, ésta es nombrada como un método
del objeto.] De lo contrario, se los llama propiedades.
Curiosamente, en JavaScript, casi todo es un objeto — vectores, funciones, números, incluso cadenas
— y todos poseen propiedades y métodos.
Creación de un “objeto literal”
var myObject = {
sayHello: function() {
console.log('hola');
},
myName: 'Rebecca'
};
myObject.sayHello(); // se llama al método sayHello,
// el cual muestra en la consola 'hola'
console.log(myObject.myName); // se llama a la propiedad myName,
// la cual muestra en la consola 'Rebecca'
Nota
Notar que cuando se crean objetos literales, el nombre de la propiedad puede ser cualquier
identificador JavaScript, una cadena de caracteres (encerrada entre comillas) o un número:
var myObject = {
validIdentifier: 123,
'some string': 456,
99999: 789
};
Los objetos literales pueden ser muy útiles para la organización del código, para más información
puede leer el artículo (en inglés) Using Objects to Organize Your Code por Rebecca Murphey.
0.2.9. Funciones
Las funciones contienen bloques de código que se ejecutaran repetidamente. A las mismas se le pueden
pasar argumentos, y opcionalmente la función puede devolver un valor.
Las funciones pueden ser creadas de varias formas:
Declaración de una función
function foo() { /* hacer algo */ }
17

-- 18 of 107 --

Declaración de una función nombrada
var foo = function() { /* hacer algo */ }
Es preferible el método de función nombrada debido a algunas profundas razones técnicas. Igualmente,
es probable encontrar a los dos métodos cuando se revise código JavaScript.
Utilización de Funciones
Una función simple
var greet = function(person, greeting) {
var text = greeting + ', ' + person;
console.log(text);
};
greet('Rebecca', 'Hola'); // muestra en la consola 'Hola, Rebecca'
Una función que devuelve un valor
var greet = function(person, greeting) {
var text = greeting + ', ' + person;
return text;
};
console.log(greet('Rebecca','Hola')); // la función devuelve 'Hola, Rebecca',
// la cual se muestra en la consola
Una función que devuelve otra función
var greet = function(person, greeting) {
var text = greeting + ', ' + person;
return function() { console.log(text); };
};
var greeting = greet('Rebecca', 'Hola');
greeting(); // se muestra en la consola 'Hola, Rebecca'
Funciones Anónimas Autoejecutables
Un patrón común en JavaScript son las funciones anónimas autoejecutables. Este patrón consiste en
crear una expresión de función e inmediatamente ejecutarla. El mismo es muy útil para casos en que
no se desea intervenir espacios de nombres globales, debido a que ninguna variable declarada dentro
de la función es visible desde afuera.
Función anónima autoejecutable
18

-- 19 of 107 --

(function(){
var foo = 'Hola mundo';
})();
console.log(foo); // indefinido (undefined)
Funciones como Argumentos
En JavaScript, las funciones son “ciudadanos de primera clase” — pueden ser asignadas a variables
o pasadas a otras funciones como argumentos. En jQuery, pasar funciones como argumentos es una
práctica muy común.
Pasar una función anónima como un argumento
var myFn = function(fn) {
var result = fn();
console.log(result);
};
myFn(function() { return 'hola mundo'; }); // muestra en la consola 'hola mundo'
Pasar una función nombrada como un argumento
var myFn = function(fn) {
var result = fn();
console.log(result);
};
var myOtherFn = function() {
return 'hola mundo';
};
myFn(myOtherFn); // muestra en la consola 'hola mundo'
0.2.10. Determinación del Tipo de Variable
JavaScript ofrece una manera de poder comprobar el “tipo” (en inglés type) de una variable. Sin
embargo, el resultado puede ser confuso — por ejemplo, el tipo de un vector es “object”.
Por eso, es una práctica común utilizar el operador typeof cuando se trata de determinar el tipo de
un valor específico.
Determinar el tipo en diferentes variables
var myFunction = function() {
console.log('hola');
};
var myObject = {
foo : 'bar'
19

-- 20 of 107 --

};
var myArray = [ 'a', 'b', 'c' ];
var myString = 'hola';
var myNumber = 3;
typeof myFunction; // devuelve 'function'
typeof myObject; // devuelve 'object'
typeof myArray; // devuelve 'object' -- tenga cuidado
typeof myString; // devuelve 'string'
typeof myNumber; // devuelve 'number'
typeof null; // devuelve 'object' -- tenga cuidado
if (myArray.push && myArray.slice && myArray.join) {
// probablemente sea un vector
// (este estilo es llamado, en inglés, "duck typing")
}
if (Object.prototype.toString.call(myArray) === '[object Array]') {
// definitivamente es un vector;
// esta es considerada la forma más robusta
// de determinar si un valor es un vector.
}
jQuery ofrece métodos para ayudar a determinar el tipo de un determinado valor. Estos métodos serán
vistos más adelante.
0.2.11. La palabra clave this
En JavaScript, así como en la mayoría de los lenguajes de programación orientados a objetos, this es
una palabra clave especial que hace referencia al objeto en donde el método está siendo invocado. El
valor de this es determinado utilizando una serie de simples pasos: