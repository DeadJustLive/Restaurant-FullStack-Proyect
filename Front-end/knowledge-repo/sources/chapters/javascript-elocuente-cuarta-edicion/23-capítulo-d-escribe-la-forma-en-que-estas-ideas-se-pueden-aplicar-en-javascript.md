# capítulo d: escribe la forma en que estas ideas se pueden aplicar en JavaScript.

Tipos de Datos Abstractos
La idea principal en la programación orientada a objetos es utilizar objetos, o
más bien tipos de objetos, como la unidad de organización del programa. Con-
figurar un programa como una serie de tipos de objetos estrictamente separados
proporciona una forma de pensar en su estructura y, por lo tanto, de imponer
algún tipo de disciplina para evitar que todo se entrelace.
La forma de hacer esto es pensar en objetos de alguna manera similar a como
pensarías en una batidora eléctrica u otro electrodoméstico para el consumidor.
Hay personas que diseñaron y ensamblaron una batidora, y tienen que realizar
un trabajo especializado que requiere ciencia de materiales y comprensión de
la electricidad. Cubren todo eso con una carcasa de plástico suave, de modo
que las personas que solo quieren mezclar masa para panqueques no tengan
que preocuparse por todo eso, solo tienen que entender los pocos botones con
los que se puede operar la batidora.
De manera similar, un tipo de dato abstracto, o clase de objeto, es un subpro-
grama que puede contener un código arbitrariamente complicado, pero expone
un conjunto limitado de métodos y propiedades que se supone que las personas
que trabajan con él deben usar. Esto permite construir programas grandes
a partir de varios tipos de electrodomésticos, limitando el grado en que estas
diferentes partes están entrelazadas al requerir que solo interactúen entre sí de
95

-- 107 of 445 --

formas específicas.
Si se encuentra un problema en una clase de objeto como esta, a menudo
se puede reparar, o incluso reescribir completamente, sin afectar el resto del
programa.
Incluso mejor, puede ser posible utilizar clases de objetos en varios programas
diferentes, evitando la necesidad de recrear su funcionalidad desde cero. Puedes
pensar en las estructuras de datos integradas de JavaScript, como arrays y
strings, como tipos de datos abstractos reutilizables de este tipo.
Cada tipo de dato abstracto tiene una interfaz, que es la colección de opera-
ciones que el código externo puede realizar en él. Incluso cosas básicas como
los números pueden considerarse un tipo de dato abstracto cuya interfaz nos
permite sumarlos, multiplicarlos, compararlos, y así sucesivamente. De hecho,
la fijación en objetos individuales como la unidad principal de organización en
la programación orientada a objetos clásica es un tanto desafortunada, ya que
a menudo las piezas de funcionalidad útiles involucran un grupo de diferentes
clases de objetos que trabajan estrechamente juntos.
Métodos
En JavaScript, los métodos no son más que propiedades que contienen valores
de función. Este es un método simple:
function speak(line) {
console.log(`El conejo ${this.type} dice '${line}'`);
}
let conejoBlanco = {type: "blanco", speak};
let conejoHambriento = {type: "hambriento", speak};
conejoBlanco.speak("Oh, mi pelaje y mis bigotes");
// → El conejo blanco dice 'Oh, mi pelaje y mis bigotes'
conejoHambriento.speak("¿Tienes zanahorias?");
// → El conejo hambriento dice '¿Tienes zanahorias?'
Típicamente, un método necesita hacer algo con el objeto en el que fue invo-
cado. Cuando una función es llamada como método—buscada como propiedad
y llamada inmediatamente, como en objeto.método()—la vinculación llamada
this en su cuerpo apunta automáticamente al objeto en el que fue llamada.
Puedes pensar en this como un parámetro extra que se pasa a la función de
una manera diferente a los parámetros regulares. Si deseas proveerlo explícita-
mente, puedes usar el método call de una función, el cual toma el valor de this
como su primer argumento y trata los siguientes argumentos como parámetros
96

-- 108 of 445 --

normales.
speak.call(conejoBlanco, "Rápido");
// → El conejo blanco dice 'Rápido'
Dado que cada función tiene su propia vinculación this, cuyo valor depende
de la forma en que es llamada, no puedes hacer referencia al this del ámbito
envolvente en una función regular definida con la palabra clave function.
Las funciones flecha son diferentes—no vinculan su propio this pero pueden
ver la vinculación this del ámbito que las rodea. Por lo tanto, puedes hacer
algo como el siguiente código, el cual hace referencia a this desde dentro de
una función local:
let buscador = {
find(array) {
return array.some(v => v == this.value);
},
value: 5
};
console.log(buscador.find([4, 5]));
// → true
Una propiedad como find(array) en una expresión de objeto es una forma
abreviada de definir un método. Crea una propiedad llamada find y le asigna
una función como su valor.
Si hubiera escrito el argumento de some usando la palabra clave function,
este código no funcionaría.
Prototipos
Entonces, una forma de crear un tipo de conejo abstracto con un método speak
sería crear una función de ayuda que tenga un tipo de conejo como parámetro, y
devuelva un objeto que contenga eso como su propiedad type y nuestra función
speak en su propiedad speak.
Todos los conejos comparten ese mismo método. Especialmente para tipos
con muchos métodos, sería conveniente tener una forma de mantener los méto-
dos de un tipo en un solo lugar, en lugar de añadirlos a cada objeto individual-
mente.
En JavaScript, los prototipos son la forma de lograr eso. Los objetos pueden
estar enlazados a otros objetos, para obtener mágicamente todas las propiedades
que ese otro objeto tiene. Los simples objetos creados con la notación {} están
enlazados a un objeto llamado Object.prototype.
97

-- 109 of 445 --

let empty = {};
console.log(empty.toString);
// → function toString()…{}
console.log(empty.toString());
// → [object Object]
Parece que acabamos de extraer una propiedad de un objeto vacío. Pero de he-
cho, toString es un método almacenado en Object.prototype, lo que significa
que está disponible en la mayoría de los objetos.
Cuando a un objeto se le solicita una propiedad que no tiene, se buscará
en su prototipo la propiedad. Si éste no la tiene, se buscará en su prototipo,
y así sucesivamente hasta llegar a un objeto que no tiene prototipo (Object.
prototype es un objeto de este tipo).
console.log(Object.getPrototypeOf({}) == Object.prototype);
// → true
console.log(Object.getPrototypeOf(Object.prototype));
// → null
Como podrás imaginar, Object.getPrototypeOf devuelve el prototipo de un
objeto.
Muchos objetos no tienen directamente Object.prototype como su prototipo,
sino que tienen otro objeto que proporciona un conjunto diferente de propiedades
predeterminadas. Las funciones se derivan de Function.prototype, y los arreg-
los se derivan de Array.prototype.
console.log(Object.getPrototypeOf(Math.max) ==
Function.prototype);
// → true
console.log(Object.getPrototypeOf([]) == Array.prototype);
// → true
Un objeto prototipo de este tipo tendrá a su vez un prototipo, a menudo Object
.prototype, de modo que aún proporciona de forma indirecta métodos como
toString.
Puedes utilizar Object.create para crear un objeto con un prototipo especí-
fico.
let protoRabbit = {
speak(line) {
console.log(`El conejo ${this.type} dice '${line}'`);
}
};
let blackRabbit = Object.create(protoRabbit);
blackRabbit.type = "negro";
98

-- 110 of 445 --

blackRabbit.speak("Soy el miedo y la oscuridad");
// → El conejo negro dice 'Soy el miedo y la oscuridad'
El conejo “proto” actúa como un contenedor para las propiedades que son
compartidas por todos los conejos. Un objeto de conejo individual, como el
conejo negro, contiene propiedades que se aplican solo a él mismo, en este caso
su tipo, y deriva propiedades compartidas de su prototipo.
Clases
El sistema de prototipos de JavaScript puede interpretarse como una versión
algo libre de los tipos de datos abstractos o clases. Una clase define la forma
de un tipo de objeto, los métodos y propiedades que tiene. A dicho objeto se
le llama una instancia de la clase.
Los prototipos son útiles para definir propiedades cuyo valor es compartido
por todas las instancias de una clase. Las propiedades que difieren por in-
stancia, como la propiedad type de nuestros conejos, deben ser almacenadas
directamente en los objetos mismos.
Así que para crear una instancia de una clase, debes hacer un objeto que se
derive del prototipo adecuado, pero también debes asegurarte de que él mismo
tenga las propiedades que se supone que deben tener las instancias de esta
clase. Esto es lo que hace una función constructor.
function makeRabbit(type) {
let rabbit = Object.create(protoRabbit);
rabbit.type = type;
return rabbit;
}
La notación de class de JavaScript facilita la definición de este tipo de función,
junto con un objeto prototype.
class Rabbit {
constructor(type) {
this.type = type;
}
speak(line) {
console.log(`El conejo ${this.type} dice '${line}'`);
}
}
La palabra clave class inicia una declaración de clase, que nos permite definir
un constructor y un conjunto de métodos juntos. Se pueden escribir cualquier
99

-- 111 of 445 --

cantidad de métodos dentro de las llaves de la declaración. Este código tiene
el efecto de definir un enlace llamado Rabbit, que contiene una función que
ejecuta el código en constructor, y tiene una propiedad prototype que contiene
el método speak.
Esta función no puede ser llamada normalmente. Los constructores, en
JavaScript, se llaman colocando la palabra clave new delante de ellos. Al hac-
erlo, se crea un objeto nuevo con el objeto contenido en la propiedad prototype
de la función como prototipo, luego se ejecuta la función con this vinculado al
nuevo objeto, y finalmente se devuelve el objeto.
let killerRabbit = new Rabbit("asesino");
De hecho, la palabra clave class se introdujo solo en la edición de JavaScript de