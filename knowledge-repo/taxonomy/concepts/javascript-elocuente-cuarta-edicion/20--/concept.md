# # # #

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 20)

## Contenido
# # # #

Cuando tengas un programa que genere este patrón, define una variable size
= 8 y cambia el programa para que funcione para cualquier size, generando
un tablero con el ancho y alto dados.
38

-- 50 of 445 --

“La gente piensa que la informática es el arte de los genios, pero la
realidad actual es la opuesta, simplemente muchas personas
haciendo cosas que se construyen unas sobre otras, como un muro
de mini piedras.”
—Donald Knuth
Chapter 3
Funciones
Las funciones son una de las herramientas más centrales en la programación
en JavaScript. El concepto de envolver un fragmento de programa en un valor
tiene muchos usos. Nos proporciona una manera de estructurar programas más
grandes, de reducir la repetición, de asociar nombres con subprogramas y de
aislar estos subprogramas entre sí.
La aplicación más evidente de las funciones es definir nuevos vocabulario.
Crear nuevas palabras en prosa suele ser de mal estilo, pero en la programación
es indispensable.
Los hablantes de inglés adultos típicos tienen alrededor de 20,000 palabras en
su vocabulario. Pocas lenguajes de programación vienen con 20,000 comandos
incorporados. Y el vocabulario que está disponible tiende a estar más pre-
cisamente definido, y por lo tanto menos flexible, que en el lenguaje humano.
Por lo tanto, tenemos que introducir nuevas palabras para evitar la verbosidad
excesiva.
Definir una función
Una definición de función es una vinculación regular donde el valor de la vin-
culación es una función. Por ejemplo, este código define square para que se
refiera a una función que produce el cuadrado de un número dado:
const square = function(x) {
return x * x;
};
console.log(square(12));
// → 144
Una función se crea con una expresión que comienza con la palabra clave
function. Las funciones tienen un conjunto de parámetros (en este caso, solo x)
y un cuerpo, que contiene las declaraciones que se ejecutarán cuando se llame
a la función. El cuerpo de una función creada de esta manera siempre debe
39

-- 51 of 445 --

estar envuelto entre llaves, incluso cuando consiste en una única declaración.
Una función puede tener varios parámetros o ninguno en absoluto. En el
siguiente ejemplo, makeNoise no enumera nombres de parámetros, mientras
que roundTo (que redondea n al múltiplo más cercano de step) enumera dos:
const makeNoise = function() {
console.log("¡Pling!");
};
makeNoise();
// → ¡Pling!
const roundTo = function(n, step) {
let resto = n % step;
return n - resto + (resto < step / 2 ? 0 : step);
};
console.log(roundTo(23, 10));
// → 20
Algunas funciones, como roundTo y square, producen un valor, y otras no,
como makeNoise, cuyo único resultado es un efecto secundario. Una instrucción
return determina el valor que devuelve la función. Cuando el control llega a
una instrucción de ese tipo, salta inmediatamente fuera de la función actual
y le da el valor devuelto al código que llamó a la función. Una palabra clave
return sin una expresión después de ella hará que la función devuelva undefined
. Las funciones que no tienen ninguna instrucción return en absoluto, como
makeNoise, devuelven igualmente undefined.
Los parámetros de una función se comportan como ligaduras regulares, pero
sus valores iniciales son dados por el llamador de la función, no por el código
en la función en sí misma.
Ligaduras y ámbitos
Cada ligadura tiene un ámbito, que es la parte del programa en la que la
ligadura es visible. Para las ligaduras definidas fuera de cualquier función,
bloque o módulo (ver Capítulo ?), el ámbito es todo el programa—puedes
hacer referencia a esas ligaduras donde quieras. Estas se llaman globales.
Las ligaduras creadas para los parámetros de una función o declaradas dentro
de una función solo pueden ser referenciadas en esa función, por lo que se
conocen como ligaduras locales. Cada vez que se llama a la función, se crean
nuevas instancias de estas ligaduras. Esto proporciona cierto aislamiento entre
40

-- 52 of 445 --

funciones—cada llamada a función actúa en su propio pequeño mundo (su
entorno local) y a menudo se puede entender sin saber mucho sobre lo que está
sucediendo en el entorno global.
Las ligaduras declaradas con let y const en realidad son locales al bloque en
el que se declaran, por lo que si creas una de esas dentro de un bucle, el código
antes y después del bucle no puede “verla”. En JavaScript anterior a 2015,
solo las funciones creaban nuevos ámbitos, por lo que las ligaduras de estilo
antiguo, creadas con la palabra clave var, son visibles en toda la función en la
que aparecen—o en todo el ámbito global, si no están dentro de una función.
let x = 10; // global
if (true) {
let y = 20; // local al bloque
var z = 30; // también global
}
Cada ámbito puede “mirar hacia afuera” al ámbito que lo rodea, por lo que x
es visible dentro del bloque en el ejemplo. La excepción es cuando múltiples
ligaduras tienen el mismo nombre—en ese caso, el código solo puede ver la
más interna. Por ejemplo, cuando el código dentro de la función halve hac
