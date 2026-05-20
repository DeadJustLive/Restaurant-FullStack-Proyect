# 2015. Cualquier función puede ser utilizada como constructor, y antes de 2015

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 24)

## Contenido
# 2015. Cualquier función puede ser utilizada como constructor, y antes de 2015

la forma de definir una clase era escribir una función regular y luego manipular
su propiedad prototype.
function ConejoArcaico(type) {
this.type = type;
}
ConejoArcaico.prototype.speak = function(line) {
console.log(`El conejo ${this.type} dice '${line}'`);
};
let conejoEstiloAntiguo = new ConejoArcaico("estilo antiguo");
Por esta razón, todas las funciones que no sean de flecha comienzan con una
propiedad prototype que contiene un objeto vacío.
Por convención, los nombres de constructores se escriben con mayúscula
inicial para que puedan distinguirse fácilmente de otras funciones.
Es importante entender la distinción entre la forma en que un prototipo está
asociado con un constructor (a través de su propiedad prototype) y la forma
en que los objetos tienen un prototipo (que se puede encontrar con Object.
getPrototypeOf). El prototipo real de un constructor es Function.prototype
ya que los constructores son funciones. Su propiedad prototype contiene el
prototipo utilizado para las instancias creadas a través de él.
console.log(Object.getPrototypeOf(Rabbit) ==
Function.prototype);
// → true
console.log(Object.getPrototypeOf(killerRabbit) ==
Rabbit.prototype);
// → true
100

-- 112 of 445 --

Por lo general, los constructores agregarán algunas propiedades específicas de
instancia a this. También es posible declarar propiedades directamente en
la declaración de clase. A diferencia de los métodos, dichas propiedades se
agregan a los objetos instancia, no al prototipo.
class Particle {
speed = 0;
constructor(position) {
this.position = position;
}
}
Al igual que function, class se puede utilizar tanto en declaraciones como en
expresiones. Cuando se usa como una expresión, no define un enlace sino que
simplemente produce el constructor como un valor. Se te permite omitir el
nombre de la clase en una expresión de clase.
let object = new class { getWord() { return "hello"; } };
console.log(object.getWord());
// → hello
Propiedades privadas
Es común que las clases definan algunas propiedades y métodos para uso in-
terno, que no forman parte de su interfaz. Estas se llaman propiedades privadas,
en contraposición a las públicas, que son parte de la interfaz externa del objeto.
Para declarar un método privado, coloca un signo # delante de su nombre.
Estos métodos solo pueden ser llamados desde dentro de la declaración de la
class que los define.
class SecretiveObject {
#getSecret() {
return "Me comí todas las ciruelas";
}
interrogate() {
let deboDecirlo = this.#getSecret();
return "nunca";
}
}
Si intentas llamar a #getSecret desde fuera de la clase, obtendrás un error. Su
existencia está completamente oculta dentro de la declaración de la clase.
Para usar propiedades de instancia privadas, debes declararlas. Las propiedades
101

-- 113 of 445 --

regulares se pueden crear simplemente asignándoles un valor, pero las propiedades
privadas deben declararse en la declaración de la clase para estar disponibles
en absoluto.
Esta clase implementa un dispositivo para obtener un número entero aleato-
rio por debajo de un número máximo dado. Solo tiene una propiedad pública:
getNumber.
class RandomSource {
#max;
constructor(max) {
this.#max = max;
}
getNumber() {
return Math.floor(Math.random() * this.#max);
}
}
Sobrescribiendo propiedades derivadas
Cuando agregas una propiedad a un objeto, ya sea que esté presente en el
prototipo o no, la propiedad se agrega al objeto mismo. Si ya existía una
propiedad con el mismo nombre en el prototipo, esta propiedad ya no afectará
al objeto, ya que ahora está oculta detrás de la propiedad propia del objeto.
Rabbit.prototype.teeth = "pequeñas";
console.log(killerRabbit.teeth);
// → pequeñas
killerRabbit.teeth = "largos, afilados y sangrientos";
console.log(killerRabbit.teeth);
// → largos, afilados y sangrientos
console.log((new Rabbit("básico")).teeth);
// → pequeñas
console.log(Rabbit.prototype.teeth);
// → pequeñas
El siguiente diagrama esquematiza la situación después de que se ha ejecutado
este código. Los prototipos Rabbit y Object están detrás de killerRabbit como
un telón de fondo, donde se pueden buscar propiedades que no se encuentran
en el objeto mismo.
102

-- 114 of 445 --

toString: <function>
...
teeth: "small"
speak: <function>
killerRabbit
teeth: "long, sharp, ..."
type: "killer"
Rabbit
prototype
Object
create: <function>
prototype
...
Sobrescribir propiedades que existen en un prototipo puede ser algo útil de
hacer. Como muestra el ejemplo de los dientes del conejo, sobrescribir se puede
utilizar para expresar propiedades excepcionales en instancias de una clase más
genérica de objetos, mientras se permite que los objetos no excepcionales tomen
un valor estándar de su prototipo.
También se utiliza la sobrescritura para dar a los prototipos estándar de
funciones y arrays un método toString diferente al del prototipo básico de
objeto.
console.log(Array.prototype.toString ==
Object.prototype.toStr
