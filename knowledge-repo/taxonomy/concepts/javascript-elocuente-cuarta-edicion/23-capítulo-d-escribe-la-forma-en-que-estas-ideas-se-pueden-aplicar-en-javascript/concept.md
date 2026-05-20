# capítulo d: escribe la forma en que estas ideas se pueden aplicar en JavaScript.

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 23)

## Contenido
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
Todo
