# Capítulo 37:: ECMAScript 2015 (ES6) con

Node.js
Examples
const / let declaraciones
A diferencia de var , const / let están vinculados al ámbito léxico en lugar del ámbito de la función.
{
var x = 1 // will escape the scope
let y = 2 // bound to lexical scope
const z = 3 // bound to lexical scope, constant
}
console.log(x) // 1
console.log(y) // ReferenceError: y is not defined
console.log(z) // ReferenceError: z is not defined
Ejecutar en RunKit
Funciones de flecha
Las funciones de flecha se enlazan automáticamente al 'este' ámbito léxico del código
circundante.
performSomething(result => {
this.someVariable = result
})
vs
performSomething(function(result) {
this.someVariable = result
}.bind(this))
Ejemplo de función de flecha
Consideremos este ejemplo, que muestra los cuadrados de los números 3, 5 y 7:
let nums = [3, 5, 7]
let squares = nums.map(function (n) {
return n * n
})
console.log(squares)
Ejecutar en RunKit
https://riptutorial.com/es/home 135

-- 163 of 423 --

La función pasada a .map también se puede escribir como función de flecha eliminando la palabra
clave de la function y, en su lugar, agregando la flecha => :
let nums = [3, 5, 7]
let squares = nums.map((n) => {
return n * n
})
console.log(squares)
Ejecutar en RunKit
Sin embargo, esto puede ser escrito aún más conciso. Si el cuerpo de la función consta de una
sola instrucción y esa declaración calcula el valor de retorno, se pueden eliminar las llaves de la
envoltura del cuerpo de la función, así como la palabra clave return .
let nums = [3, 5, 7]
let squares = nums.map(n => n * n)
console.log(squares)
Ejecutar en RunKit
desestructuración
let [x,y, ...nums] = [0, 1, 2, 3, 4, 5, 6];
console.log(x, y, nums);
let {a, b, ...props} = {a:1, b:2, c:3, d:{e:4}}
console.log(a, b, props);
let dog = {name: 'fido', age: 3};
let {name:n, age} = dog;
console.log(n, age);
fluir
/* @flow */
function product(a: number, b: number){
return a * b;
}
const b = 3;
let c = [1,2,3,,{}];
let d = 3;
import request from 'request';
request('http://dev.markitondemand.com/MODApis/Api/v2/Quote/json?symbol=AAPL', (err, res,
payload)=>{
payload = JSON.parse(payload);
let {LastPrice} = payload;
console.log(LastPrice);
});
https://riptutorial.com/es/home 136

-- 164 of 423 --

Clase ES6
class Mammel {
constructor(legs){
this.legs = legs;
}
eat(){
console.log('eating...');
}
static count(){
console.log('static count...');
}
}
class Dog extends Mammel{
constructor(name, legs){
super(legs);
this.name = name;
}
sleep(){
super.eat();
console.log('sleeping');
}
}
let d = new Dog('fido', 4);
d.sleep();
d.eat();
console.log('d', d);
Lea ECMAScript 2015 (ES6) con Node.js en línea: https://riptutorial.com/es/node-
js/topic/6732/ecmascript-2015--es6--con-node-js
https://riptutorial.com/es/home 137

-- 165 of 423 --