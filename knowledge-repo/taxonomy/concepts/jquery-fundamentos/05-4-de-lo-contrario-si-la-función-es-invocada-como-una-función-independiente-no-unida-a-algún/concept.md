# 4. De lo contrario, si la función es invocada como una función independiente, no unida a algún

## Fuente
jquery-fundamentos (Cap. 5)

## Contenido
# 4. De lo contrario, si la función es invocada como una función independiente, no unida a algún

objeto, this referenciará al objeto global.
Una función invocada utilizando Function.call
var myObject = {
sayHello : function() {
20

-- 21 of 107 --

console.log('Hola, mi nombre es ' + this.myName);
},
myName : 'Rebecca'
};
var secondObject = {
myName : 'Colin'
};
myObject.sayHello(); // registra 'Hola, mi nombre es Rebecca'
myObject.sayHello.call(secondObject); // registra 'Hola, mi nombre es Colin'
Una función creada utilizando Function.bind
var myName = 'el objeto global',
sayHello = function () {
console.log('Hola, mi nombre es ' + this.myName);
},
myObject = {
myName : 'Rebecca'
};
var myObjectHello = sayHello.bind(myObject);
sayHello(); // registra 'Hola, mi nombre es el objeto global'
myObjectHello(); // registra 'Hola, mi nombre es Rebecca'
Una función vinculada a un objeto
var myName = 'el objeto global',
sayHello = function() {
console.log('Hola, mi nombre es ' + this.myName);
},
myObject = {
myName : 'Rebecca'
},
secondObject = {
myName : 'Colin'
};
myObject.sayHello = sayHello;
secondObject.sayHello = sayHello;
sayHello(); // registra 'Hola, mi nombre es el objeto global'
myObject.sayHello(); // registra 'Hola, mi nombre es Rebecca'
secondObject.sayHello(); // registra 'Hola, mi nombre es Colin'
21

-- 22 of 107 --

Nota
En algunas oportunidades, cuando se invoca una función que se encuentra dentro de un
espacio de nombres (en inglés namespace) amplio, puede ser una tentación guardar la
referencia a la función actual en una variable más corta y accesible. Sin embargo, es
importante no realizarlo en instancias de métodos, ya que puede llevar a la ejecución de
código incorrecto. Por ejemplo:
var myNamespace = {
myObject: {
sayHello: function() {
console.log('Hola, mi nombre es ' + this.myName);
},
myName: 'Rebecca'
}
};
var hello = myNamespace.myObject.sayHello;
hello(); // registra 'Hola, mi nombre es undefined'
Para que no ocurran estos errores, es necesario hacer referencia al objeto en donde el método es
invocado:
var myNamespace = {
myObject : {
sayHello : function() {
console.log('Hola, mi nombre es ' + this.myName);
},
myName : 'Rebecca'
}
};
var obj = myNamespace.myObject;
obj.sayHello(); // registra 'Hola, mi nombre es Rebecca'
0.2.12. Alcance
El “alcance” (en inglés scope) se refiere a las variables que están disponibles en un bloque de código
en un tiempo determinado. La falta de comprensión de este concepto puede llevar a una frustrante
experiencia de depuración.
Cuando una variable es declarada dentro de una función utilizando la palabra clave var, ésta única-
mente esta disponible para el código dentro de la función — todo el código fuera de dicha función no
puede acceder a la variable. Por otro lado, las funciones definidas dentro de la función podrán acceder
a la variable declarada.
Las variables que son declaradas dentro de la función sin la palabra clave var no quedan dentro del
ámbito de la misma función — JavaScript buscará el lugar en donde la variable fue previamente
22

-- 23 of 107 --

declarada, y en caso de no haber sido declarada, es definida dentro del alcance global, lo cual puede
ocasionar consecuencias inesperadas;
Funciones tienen acceso a variables definidas dentro del mismo alcance
var foo = 'hola';
var sayHello = function() {
console.log(foo);
};
sayHello(); // muestra en la consola 'hola'
console.log(foo); // también muestra en la consola 'hola'
El código de afuera no tiene acceso a la variable definida dentro de la función
var sayHello = function() {
var foo = 'hola';
console.log(foo);
};
sayHello(); // muestra en la consola 'hola'
console.log(foo); // no muestra nada en la consola
Variables con nombres iguales pero valores diferentes pueden existir en diferentes alcan-
ces
var foo = 'mundo';
var sayHello = function() {
var foo = 'hola';
console.log(foo);
};
sayHello(); // muestra en la consola 'hola'
console.log(foo); // muestra en la consola 'mundo'
Las funciones pueden “ver” los cambios en las variables antes de que la función sea
definida
var myFunction = function() {
var foo = 'hola';
var myFn = function() {
console.log(foo);
};
foo = 'mundo';
return myFn;
};
23

-- 24 of 107 --

var f = myFunction();
f(); // registra 'mundo' -- error
Alcance
// una función anónima autoejecutable
(function() {
var baz = 1;
var bim = function() { alert(baz); };
bar = function() { alert(baz); };
})();
console.log(baz); // La consola no muestra nada, ya que baz
// esta definida dentro del alcance de la función anónima
bar(); // bar esta definido fuera de la función anónima
// ya que fue declarada sin la palabra clave var; además,
// como fue definida dentro del mismo alcance que baz,
// se puede consultar el valor de baz a pesar que
// ésta este definida dentro del alcance de la función anónima
bim(); // bim no esta definida para ser accesible fuera de la función anónima,
// por lo cual se mostrará un error
0.2.13. Clausuras
Las clausuras (en inglés closures) son una extensión
