# 2. Sintaxis

Tipos básicos
Los tipos básicos que maneja Typescript son booleans, number, string, Any y Void.

-- 2 of 9 --

var isDone: boolean = false;
var height: number = 6;
var name: string = "bob";
var list:number[] = [1, 2, 3];
var notSure: any = 4;
function warnUser(): void {
alert("This is my warning message");
}
Los cuatro primeros tipos no hace falta explicarlos ya que cualquier desarrollador estará bastante familiarizado
con ellos, el 5º tipo Any es un tipo dinámico, se utiliza principalmente cuando no queremos declarar el tipo o
cuando estamos declarando el tipo de una librería de terceros, también se usa en arrays que contienen distintos
tipos.
Por último, void se utiliza principalmente para declarar el tipo de funciones que no devuelven nada, cómo en el
ejemplo de arriba.
Clases e interfaces
interface Animal {
name : string;
makeSound();
}
class Dog implements Animal {
constructor(name:string) {
this.name = name;
}
name:string;
makeSound() {
return "guau!";
}
}
function sayHi(animal:Animal) {
console.log("hi " + animal.name);
}
sayHi(new Dog("Timmy"))

-- 3 of 9 --

Esto, como es de esperar devolverá hi Timmy por consola.
Modulos
Este quizás sea uno de los puntos más necesarios a la hora de conseguir una mejor arquitectura en las
aplicaciones Javascript.
Typescript lo resuelve usando una sintaxis parecida a la que veremos en Javascript cuando el estándar ES6 se
implemente en los navegadores. Typescript tiene dos tipos de módulos internos y externos, a continuación
vamos a explicar los externos, ya que queremos que se puedan usar en todos los navegadores ( para ello los
compila en módulos de Require )
Vamos a repartir una clase / interfaz por fchero, de manera que podamos tener el código bien organizado,
basándonos en el ejemplo anterior:
models/Animal.ts models/Dog.ts Main.ts
//models/Animal.ts
interface Animal {
name : string;
makeSound();
}
export = Animal
Podemos ver la keyword export que permite que otros módulos/clases utilicen la interfaz Animal.
// models/Dog.ts
import Animal = require('Animal')
class Dog implements Animal {
constructor(name:string) {
this.name = name;
}
name:string;
makeSound() {
return "guau!";
}
}
export = Dog

-- 4 of 9 --

En este ejemplo se ven dos keywords nuevas, import y require, tras el import nombramos a la variable que
vamos a tener disponible en el resto del fchero y con require nombramos el modulo que queremos importar.
Por último, para usar estos módulos en nuestro fchero Main.ts:
import Dog = require('models/Dog')
import Animal = require('models/Animal')
function sayHi(animal:Animal) {
console.log("hi " + animal.name);
}
sayHi(new Dog("Timmy"))
y el resultado: hi Timmy.
Puedes ver todos los fcheros en Github
Genéricos
Los genéricos son muy útiles para hacer código mas reusable, uno de los claros ejemplos son las listas/Arrays,
en el siguiente extracto podemos observar como podemos defnir el tipo del Array.
var animals:Array<Animal> = [new Dog('Timmy'), new Dog('Michael'), new Dog('Dwight')];
animals.forEach(sayHi);
Esto puede ayudar sobre todo a hacer librerías y piezas de código más reutilizables.