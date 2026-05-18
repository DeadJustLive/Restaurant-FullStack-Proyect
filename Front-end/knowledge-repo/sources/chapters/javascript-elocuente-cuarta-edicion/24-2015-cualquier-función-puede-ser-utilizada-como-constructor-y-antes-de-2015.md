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
Object.prototype.toString);
// → false
console.log([1, 2].toString());
// → 1,2
Llamar a toString en un array produce un resultado similar a llamar a .join
(",") en él—coloca comas entre los valores en el array. Llamar directamente a
Object.prototype.toString con un array produce una cadena diferente. Esa
función no conoce acerca de los arrays, por lo que simplemente coloca la palabra
object y el nombre del tipo entre corchetes.
console.log(Object.prototype.toString.call([1, 2]));
// → [object Array]
Mapas
Vimos la palabra map utilizada en el capítulo anterior para una operación que
transforma una estructura de datos aplicando una función a sus elementos. Por
confuso que sea, en programación la misma palabra también se utiliza para una
cosa relacionada pero bastante diferente.
Un mapa (sustantivo) es una estructura de datos que asocia valores (las
claves) con otros valores. Por ejemplo, podrías querer mapear nombres a
edades. Es posible usar objetos para esto.
103

-- 115 of 445 --

let edades = {
Boris: 39,
Liang: 22,
Júlia: 62
};
console.log(`Júlia tiene ${edades["Júlia"]}`);
// → Júlia tiene 62
console.log("¿Se conoce la edad de Jack?", "Jack" in edades);
// → ¿Se conoce la edad de Jack? false
console.log("¿Se conoce la edad de toString?", "toString" in edades)
;
// → ¿Se conoce la edad de toString? true
Aquí, los nombres de propiedad del objeto son los nombres de las personas, y
los valores de las propiedades son sus edades. Pero ciertamente no listamos
a nadie con el nombre toString en nuestro mapa. Sin embargo, dado que los
objetos simples derivan de Object.prototype, parece que la propiedad está allí.
Por lo tanto, usar objetos simples como mapas es peligroso. Hay varias
formas posibles de evitar este problema. Primero, es posible crear objetos
sin ningún prototipo. Si pasas null a Object.create, el objeto resultante no
derivará de Object.prototype y se puede usar de forma segura como un mapa.
console.log("toString" in Object.create(null));
// → false
Los nombres de las propiedades de los objetos deben ser cadenas. Si necesi-
tas un mapa cuyas claves no puedan convertirse fácilmente en cadenas—como
objetos—no puedes usar un objeto como tu mapa.
Afortunadamente, JavaScript viene con una clase llamada Map que está es-
crita para este propósito exacto. Almacena un mapeo y permite cualquier tipo
de claves.
let ages = new Map();
ages.set("Boris", 39);
ages.set("Liang", 22);
ages.set("Júlia", 62);
console.log(`Júlia tiene ${ages.get("Júlia")}`);
// → Júlia tiene 62
console.log("¿Se conoce la edad de Jack?", ages.has("Jack"));
// → ¿Se conoce la edad de Jack? false
console.log(ages.has("toString"));
// → false
104

-- 116 of 445 --

Los métodos set, get y has forman parte de la interfaz del objeto Map. Escribir
una estructura de datos que pueda actualizar y buscar rápidamente un gran
conjunto de valores no es fácil, pero no tenemos que preocuparnos por eso.
Alguien más lo hizo por nosotros, y podemos utilizar su trabajo a través de
esta interfaz sencilla.
Si tienes un objeto simple que necesitas tratar como un mapa por alguna
razón, es útil saber que Object.keys devuelve solo las claves propias de un
objeto, no las del prototipo. Como alternativa al operador in, puedes utilizar
la función Object.hasOwn, que ignora el prototipo del objeto.
console.log(Object.hasOwn({x: 1}, "x"));
// → true
console.log(Object.hasOwn({x: 1}, "toString"));
// → false
Polimorfismo
Cuando llamas a la función String (que convierte un valor a una cadena) en
un objeto, llamará al método toString en ese objeto para intentar crear una
cadena significativa a partir de él. Mencioné que algunos de los prototipos
estándar definen su propia versión de toString para poder crear una cadena
que contenga información más útil que "[object Object]". También puedes
hacerlo tú mismo.
Rabbit.prototype.toString = function() {
return `un conejo ${this.type}`;
};
console.log(String(killerRabbit));
// → un conejo asesino
Este es un ejemplo simple de una idea poderosa. Cuando se escribe un código
para trabajar con objetos que tienen una determinada interfaz, en este caso,
un método toString, cualquier tipo de objeto que accidentalmente admita esta
interfaz puede ser enchufado en el código, y este podrá funcionar con él.
Esta técnica se llama polimorfismo. El código polimórfico puede trabajar con
valores de diferentes formas, siempre y cuando admitan la interfaz que espera.
Un ejemplo de una interfaz ampliamente utilizada es la de los objeto sim-
ilar a un array que tiene una propiedad length que contiene un número, y
propiedades numeradas para cada uno de sus elementos. Tanto los arreglos
como las cadenas admiten esta interfaz, al igual que varios otros objetos, al-
105

-- 117 of 445 --

gunos de los cuales veremos más adelante en los capítulos sobre el navegador.
Nuestra implementación de forEach en el Capítulo 5 funciona en cualquier cosa
que proporcione esta interfaz. De hecho, también lo hace Array.prototype.
forEach.
Array.prototype.forEach.call({
length: 2,
0: "A",
1: "B"
}, elt => console.log(elt));
// → A
// → B
Getters, setters y estáticos
Las interfaces a menudo contienen propiedades simples, no solo métodos. Por
ejemplo, los objetos Map tienen una propiedad size que te dice cuántas claves
están almacenadas en ellos.
No es necesario que dicho objeto calcule y almacene directamente esa propiedad
en la instancia. Incluso las propiedades que se acceden directamente pueden
ocultar una llamada a un método. Dichos métodos se llaman getter y se definen
escribiendo get delante del nombre del método en una expresión de objeto o
declaración de clase.
let varyingSize = {
get size() {
return Math.floor(Math.random() * 100);
}
};
console.log(varyingSize.size);
// → 73
console.log(varyingSize.size);
// → 49
Cada vez que alguien lee la propiedad size de este objeto, se llama al método
asociado. Puedes hacer algo similar cuando se escribe en una propiedad, uti-
lizando un setter.
class Temperature {
constructor(celsius) {
this.celsius = celsius;
}
106

-- 118 of 445 --

get fahrenheit() {
return this.celsius * 1.8 + 32;
}
set fahrenheit(value) {
this.celsius = (value - 32) / 1.8;
}
static fromFahrenheit(value) {
return new Temperature((value - 32) / 1.8);
}
}
let temp = new Temperature(22);
console.log(temp.fahrenheit);
// → 71.6
temp.fahrenheit = 86;
console.log(temp.celsius);
// → 30
La clase Temperature te permite leer y escribir la temperatura en grados Cel-
sius o grados Fahrenheit, pero internamente solo almacena Celsius y convierte
automáticamente de y a Celsius en el getter y setter de fahrenheit.
A veces quieres adjuntar algunas propiedades directamente a tu función con-
structora, en lugar de al prototipo. Estos métodos no tendrán acceso a una
instancia de clase, pero pueden, por ejemplo, usarse para proporcionar formas
adicionales de crear instancias.
Dentro de una declaración de clase, los métodos o propiedades que tienen
static escrito antes de su nombre se almacenan en el constructor. Por lo
tanto, la clase Temperature te permite escribir Temperature.fromFahrenheit
(100) para crear una temperatura usando grados Fahrenheit.
Símbolos
Mencioné en el Capítulo 4 que un bucle for/of puede recorrer varios tipos de
estructuras de datos. Este es otro caso de polimorfismo: tales bucles esperan
que la estructura de datos exponga una interfaz específica, la cual hacen los
arrays y las cadenas. ¡Y también podemos agregar esta interfaz a nuestros
propios objetos! Pero antes de hacerlo, debemos echar un vistazo breve al tipo
de símbolo.
Es posible que múltiples interfaces utilicen el mismo nombre de propiedad
para diferentes cosas. Por ejemplo, en objetos similares a arrays, length se
refiere a la cantidad de elementos en la colección. Pero una interfaz de objeto
107

-- 119 of 445 --

que describa una ruta de senderismo podría usar length para proporcionar la
longitud de la ruta en metros. No sería posible que un objeto cumpla con
ambas interfaces.
Un objeto que intente ser una ruta y similar a un array (quizás para enumerar
sus puntos de referencia) es algo un tanto improbable, y este tipo de problema
no es tan común en la práctica. Pero para cosas como el protocolo de iteración,
los diseñadores del lenguaje necesitaban un tipo de propiedad que realmente
no entrara en conflicto con ninguna otra. Por lo tanto, en 2015, se agregaron
los símbolos al lenguaje.
La mayoría de las propiedades, incluidas todas las propiedades que hemos
visto hasta ahora, se nombran con cadenas. Pero también es posible usar
símbolos como nombres de propiedades. Los símbolos son valores creados con
la función Symbol. A diferencia de las cadenas, los símbolos recién creados son
únicos: no puedes crear el mismo símbolo dos veces.
let sym = Symbol("nombre");
console.log(sym == Symbol("nombre"));
// → false
Rabbit.prototype[sym] = 55;
console.log(killerRabbit[sym]);
// → 55
La cadena que pasas a Symbol se incluye cuando la conviertes en una cadena
y puede facilitar reconocer un símbolo cuando, por ejemplo, se muestra en la
consola. Pero no tiene otro significado más allá de eso: varios símbolos pueden
tener el mismo nombre.
Ser tanto únicos como utilizables como nombres de propiedades hace que
los símbolos sean adecuados para definir interfaces que pueden convivir pací-
ficamente junto a otras propiedades, independientemente de cuáles sean sus
nombres.
const longitud = Symbol("longitud");
Array.prototype[longitud] = 0;
console.log([1, 2].length);
// → 2
console.log([1, 2][longitud]);
// → 0
Es posible incluir propiedades de símbolos en expresiones de objetos y clases
mediante el uso de corchetes. Esto hace que la expresión entre los corchetes
se evalúe para producir el nombre de la propiedad, análogo a la notación de
acceso a propiedades mediante corchetes cuadrados.
108

-- 120 of 445 --

let miViaje = {
longitud: 2,
0: "Lankwitz",
1: "Babelsberg",
[longitud]: 21500
};
console.log(miViaje[longitud], miViaje.longitud);
// → 21500 2
La interfaz del iterador
Se espera que el objeto proporcionado a un bucle for/of sea iterable. Esto
significa que tiene un método nombrado con el símbolo Symbol.iterator (un
valor de símbolo definido por el lenguaje, almacenado como una propiedad de
la función Symbol).
Cuando se llama, ese método debería devolver un objeto que proporcione una
segunda interfaz, iterador. Este es lo que realmente itera. Tiende un método
next que devuelve el próximo resultado. Ese resultado debería ser un objeto
con una propiedad value que proporciona el siguiente valor, si lo hay, y una
propiedad done, que debería ser true cuando no hay más resultados y false en
caso contrario.
Ten en cuenta que los nombres de propiedad next, value y done son simples
cadenas, no símbolos. Solo Symbol.iterator, que probablemente se agregará a
muchos objetos diferentes, es un símbolo real.
Podemos usar esta interfaz directamente nosotros mismos.
let okIterador = "OK"[Symbol.iterator]();
console.log(okIterador.next());
// → {value: "O", done: false}
console.log(okIterador.next());
// → {value: "K", done: false}
console.log(okIterador.next());
// → {value: undefined, done: true}
Implementemos una estructura de datos iterable similar a la lista enlazada del
ejercicio en el Capítulo 4. Esta vez escribiremos la lista como una clase.
class List {
constructor(value, rest) {
this.value = value;
this.rest = rest;
}
109

-- 121 of 445 --

get length() {
return 1 + (this.rest ? this.rest.length : 0);
}
static fromArray(array) {
let result = null;
for (let i = array.length - 1; i >= 0; i--) {
result = new this(array[i], result);
}
return result;
}
}
Toma en cuenta que this, en un método estático, apunta al constructor de la
clase, no a una instancia, ya que no hay una instancia disponible cuando se
llama a un método estático.
Iterar sobre una lista debería devolver todos los elementos de la lista desde
el principio hasta el final. Escribiremos una clase separada para el iterador.
class ListIterator {
constructor(list) {
this.list = list;
}
next() {
if (this.list == null) {
return { done: true };
}
let value = this.list.value;
this.list = this.list.rest;
return { value, done: false };
}
}
La clase realiza un seguimiento del progreso de la iteración a través de la lista
actualizando su propiedad list para moverse al siguiente objeto de lista cada
vez que se devuelve un valor, y reporta que ha terminado cuando esa lista está
vacía (null).
Ahora configuraremos la clase List para que sea iterable. A lo largo de este
libro, ocasionalmente utilizaré la manipulación de prototipos posterior al hecho
para agregar métodos a las clases de modo que las piezas individuales de código
se mantengan pequeñas y autónomas. En un programa regular, donde no hay
necesidad de dividir el código en piezas pequeñas, declararías estos métodos
directamente en la clase en su lugar.
110

-- 122 of 445 --

List.prototype[Symbol.iterator] = function() {
return new ListIterator(this);
};
Ahora podemos iterar sobre una lista con for/of.
let lista = List.fromArray([1, 2, 3]);
for (let elemento of lista) {
console.log(elemento);
}
// → 1
// → 2
// → 3
La sintaxis ... en notación de arrays y en llamadas a funciones funciona de
forma similar con cualquier objeto iterable. Por ejemplo, puedes usar [...
valor] para crear un array que contenga los elementos de un objeto iterable
arbitrario.
console.log([... "PCI"]);
// → ["P", "C", "I"]
Herencia
Imaginemos que necesitamos un tipo de lista, bastante parecido a la clase List
que vimos anteriormente, pero como siempre estaremos preguntando por su
longitud, no queremos tener que recorrer su rest cada vez, en su lugar, quere-
mos almacenar la longitud en cada instancia para un acceso eficiente.
El sistema de prototipos de JavaScript permite crear una nueva clase, muy
similar a la clase antigua, pero con nuevas definiciones para algunas de sus
propiedades. El prototipo de la nueva clase se deriva del prototipo antiguo
pero agrega una nueva definición, por ejemplo, para el getter de length.
En términos de programación orientada a objetos, esto se llama herencia. La
nueva clase hereda propiedades y comportamientos de la clase antigua.
class LengthList extends List {
#length;
constructor(valor, rest) {
super(valor, rest);
this.#length = super.length;
}
111

-- 123 of 445 --

get length() {
return this.#length;
}
}
console.log(LengthList.fromArray([1, 2, 3]).length);
// → 3
El uso de la palabra extends indica que esta clase no debería basarse direc-
tamente en el prototipo predeterminado de Object, sino en alguna otra clase.
Esta se llama la superclase. La clase derivada es la subclase.
Para inicializar una instancia de LengthList, el constructor llama al con-
structor de su superclase a través de la palabra clave super. Esto es necesario
porque si este nuevo objeto se va a comportar (aproximadamente) como una
List, va a necesitar las propiedades de instancia que tienen las listas.
Luego, el constructor almacena la longitud de la lista en una propiedad
privada. Si hubiéramos escrito this.longitud ahí, se habría llamado al getter
de la propia clase, lo cual no funciona aún, ya que #longitud aún no ha sido
completado. Podemos usar super.algo para llamar a métodos y getters en el
prototipo de la superclase, lo cual a menudo es útil.
La herencia nos permite construir tipos de datos ligeramente diferentes a
partir de tipos de datos existentes con relativamente poco trabajo. Es una parte
fundamental de la tradición orientada a objetos, junto con la encapsulación y
la polimorfismo. Pero, mientras que los dos últimos se consideran generalmente
ideas maravillosas, la herencia es más controvertida.
Mientras que encapsulación y polimorfismo se pueden utilizar para separar
las piezas de código unas de otras, reduciendo el enredo del programa en gen-
eral, herencia fundamentalmente ata clases juntas, creando más enredo. Al
heredar de una clase, generalmente tienes que saber más sobre cómo funciona
que cuando simplemente la usas. La herencia puede ser una herramienta útil
para hacer que algunos tipos de programas sean más concisos, pero no debería
ser la primera herramienta a la que recurras, y probablemente no deberías
buscar activamente oportunidades para construir jerarquías de clases (árboles
genealógicos de clases).
El operador instanceof
A veces es útil saber si un objeto se derivó de una clase específica. Para esto,
JavaScript proporciona un operador binario llamado instanceof.
console.log(
112

-- 124 of 445 --

new LengthList(1, null) instanceof LengthList);
// → true
console.log(new LengthList(2, null) instanceof List);
// → true
console.log(new List(3, null) instanceof LengthList);
// → false
console.log([1] instanceof Array);
// → true
El operador podrá ver a través de tipos heredados, por lo que un LengthList
es una instancia de List. El operador también se puede aplicar a constructores
estándar como Array. Casi todo objeto es una instancia de Object.
Resumen
Los objetos hacen más que simplemente contener sus propias propiedades.
Tienen prototipos, que son otros objetos. Actuarán como si tuvieran propiedades
que no tienen siempre y cuando su prototipo tenga esa propiedad. Los objetos
simples tienen Object.prototype como su prototipo.
Los constructores, que son funciones cuyos nombres generalmente comienzan
con una letra mayúscula, se pueden usar con el operador new para crear nuevos
objetos. El prototipo del nuevo objeto será el objeto encontrado en la propiedad
prototype del constructor. Puedes sacar buen provecho de esto poniendo las
propiedades que comparten todos los valores de un tipo dado en su prototipo.
Existe una notación de class que proporciona una forma clara de definir un
constructor y su prototipo.
Puedes definir getters y setters para llamar secretamente a métodos cada vez
que se accede a una propiedad de un objeto. Los métodos estáticos son métodos
almacenados en el constructor de una clase, en lugar de en su prototipo.
El operador instanceof puede, dado un objeto y un constructor, decirte si
ese objeto es una instancia de ese constructor.
Una cosa útil que se puede hacer con objetos es especificar una interfaz para
ellos y decirle a todo el mundo que se supone que deben comunicarse con tu
objeto solo a través de esa interfaz. El resto de los detalles que componen tu
objeto están ahora encapsulados, escondidos detrás de la interfaz. Puedes usar
propiedades privadas para ocultar una parte de tu objeto del mundo exterior.
Más de un tipo puede implementar la misma interfaz. El código escrito para
usar una interfaz automáticamente sabe cómo trabajar con cualquier número
de objetos diferentes que proporcionen la interfaz. Esto se llama polimorfismo.
Cuando se implementan múltiples clases que difieren solo en algunos detalles,
puede ser útil escribir las nuevas clases como subclases de una clase existente,
113

-- 125 of 445 --

heredando parte de su comportamiento.
Ejercicios
Un tipo de vector
Escribe una clase Vec que represente un vector en el espacio bidimensional.
Toma los parámetros x e y (números), que debería guardar en propiedades del
mismo nombre.
Dale a la clase Vec dos métodos en su prototipo, plus y minus, que tomen
otro vector como parámetro y devuelvan un nuevo vector que tenga la suma o
la diferencia de los valores x e y de los dos vectores (this y el parámetro).
Agrega una propiedad getter length al prototipo que calcule la longitud del
vector, es decir, la distancia del punto (x, y) desde el origen (0, 0).
Grupos
El entorno estándar de JavaScript proporciona otra estructura de datos llamada
Set. Al igual que una instancia de Map, un conjunto contiene una colección de
valores. A diferencia de Map, no asocia otros valores con esos, solo realiza un
seguimiento de qué valores forman parte del conjunto. Un valor puede formar