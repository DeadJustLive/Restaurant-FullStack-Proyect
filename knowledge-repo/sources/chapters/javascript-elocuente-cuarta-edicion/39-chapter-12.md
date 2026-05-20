# Chapter 12

Proyecto: Un Lenguaje de Programación
Crear tu propio lenguaje de programación es sorprendentemente fácil (si no
apuntas muy alto) y muy esclarecedor.
Lo principal que quiero mostrar en este capítulo es que no hay magia in-
volucrada en la construcción de un lenguaje de programación. A menudo he
sentido que algunas invenciones humanas eran tan inmensamente inteligentes
y complicadas que nunca las entendería. Pero con un poco de lectura y exper-
imentación, a menudo resultan ser bastante mundanas.
Construiremos un lenguaje de programación llamado Egg. Será un lenguaje
simple y diminuto, pero lo suficientemente poderoso como para expresar cualquier
cálculo que puedas imaginar. Permitirá una simple abstracción basada en fun-
ciones.
Análisis Sintáctico
La parte más inmediatamente visible de un lenguaje de programación es su
sintaxis, o notación. Un analizador sintáctico es un programa que lee un frag-
mento de texto y produce una estructura de datos que refleja la estructura del
programa contenido en ese texto. Si el texto no forma un programa válido, el
analizador sintáctico debería señalar el error.
Nuestro lenguaje tendrá una sintaxis simple y uniforme. Todo en Egg es una
expresión. Una expresión puede ser el nombre de una asignación, un número,
una cadena o una aplicación. Las aplicaciones se utilizan para llamadas de
funciones pero también para estructuras como if o while.
Para mantener el analizador sintáctico simple, las cadenas en Egg no admiten
nada parecido a los escapes con barra invertida. Una cadena es simplemente
una secuencia de caracteres que no son comillas dobles, envueltos entre comillas
dobles. Un número es una secuencia de dígitos. Los nombres de las asignaciones
pueden consistir en cualquier carácter que no sea espacio en blanco y que no
tenga un significado especial en la sintaxis.
Las aplicaciones se escriben de la misma manera que en JavaScript, colocando
200

-- 212 of 445 --

paréntesis después de una expresión y teniendo cualquier número de argumentos
entre esos paréntesis, separados por comas.
do(define(x, 10),
if(>(x, 5),
print("grande"),
print("pequeño")))
La uniformidad del lenguaje Egg significa que las cosas que son operadores en
JavaScript (como >) son asignaciones normales en este lenguaje, aplicadas de
la misma manera que otras funciones. Y dado que la sintaxis no tiene concepto
de bloque, necesitamos un constructo do para representar la realización de
múltiples tareas en secuencia.
La estructura de datos que el analizador sintáctico utilizará para describir
un programa consiste en objetos expresión, cada uno de los cuales tiene una
propiedad type que indica el tipo de expresión que es y otras propiedades para
describir su contenido.
Las expresiones de tipo "value" representan cadenas literales o números. Su
propiedad value contiene el valor de cadena o número que representan. Las
expresiones de tipo "word" se utilizan para identificadores (nombres). Estos ob-
jetos tienen una propiedad name que contiene el nombre del identificador como
cadena. Finalmente, las expresiones "apply" representan aplicaciones. Tienen
una propiedad operator que se refiere a la expresión que se está aplicando, así
como una propiedad args que contiene una serie de expresiones de argumento.
La parte >(x, 5) del programa anterior se representaría de la siguiente man-
era:
{
type: "apply",
operator: {type: "word", name: ">"},
args: [
{type: "word", name: "x"},
{type: "value", value: 5}
]
}
Esta estructura de datos se llama un árbol de sintaxis. Si te imaginas los
objetos como puntos y los enlaces entre ellos como líneas entre esos puntos,
tiene una forma similar a un árbol. El hecho de que las expresiones contienen
otras expresiones, que a su vez pueden contener más expresiones, es similar a
la forma en que las ramas de un árbol se dividen y vuelven a dividir.
201

-- 213 of 445 --

do
define
x
10
if
>
x
5
print
"large"
print
"small"
Contrasta esto con el analizador que escribimos para el formato de archivo
de configuración en el Capítulo 9, que tenía una estructura simple: dividía
la entrada en líneas y manejaba esas líneas una a la vez. Solo había algunas
formas simples que una línea podía tener.
Aquí debemos encontrar un enfoque diferente. Las expresiones no están
separadas en líneas, y tienen una estructura recursiva. Las expresiones de
aplicación contienen otras expresiones.
Afortunadamente, este problema puede resolverse muy bien escribiendo una
función de análisis sintáctico que sea recursiva de una manera que refleje la
naturaleza recursiva del lenguaje.
Definimos una función parseExpression, que recibe una cadena como entrada
y devuelve un objeto que contiene la estructura de datos de la expresión al inicio
de la cadena, junto con la parte de la cadena que queda después de analizar
esta expresión. Al analizar subexpresiones (el argumento de una aplicación, por
ejemplo), esta función puede ser llamada nuevamente, obteniendo la expresión
de argumento así como el texto que queda. Este texto a su vez puede contener
más argumentos o puede ser el paréntesis de cierre que finaliza la lista de
argumentos.Esta es la primera parte del analizador sintáctico:
function parseExpression(program) {
program = skipSpace(program);
let match, expr;
if (match = /^"([^"]*)"/.exec(program)) {
expr = {type: "value", value: match[1]};
} else if (match = /^\d+\b/.exec(program)) {
expr = {type: "value", value: Number(match[0])};
} else if (match = /^[^\s(),#"]+/.exec(program)) {
202

-- 214 of 445 --

expr = {type: "word", name: match[0]};
} else {
throw new SyntaxError("Sintaxis inesperada: " + program);
}
return parseApply(expr, program.slice(match[0].length));
}
function skipSpace(string) {
let first = string.search(/\S/);
if (first == -1) return "";
return string.slice(first);
}
Debido a que Egg, al igual que JavaScript, permite cualquier cantidad de espa-
cios en blanco entre sus elementos, debemos cortar repetidamente el espacio en
blanco del inicio de la cadena del programa. Eso es para lo que sirve la función
skipSpace.
Después de omitir cualquier espacio inicial, parseExpression utiliza tres ex-
presiones regulares para detectar los tres elementos atómicos que admite Egg:
cadenas, números y palabras. El analizador construye un tipo diferente de
estructura de datos dependiendo de cuál de ellos coincida. Si la entrada no
coincide con ninguna de estas tres formas, no es una expresión válida y el anal-
izador genera un error. Utilizamos el constructor SyntaxError aquí. Esta es
una clase de excepción definida por el estándar, al igual que Error, pero más
específica.
Luego cortamos la parte que coincidió de la cadena del programa y la pasamos,
junto con el objeto de la expresión, a parseApply, que verifica si la expresión
es una aplicación. Si lo es, analiza una lista de argumentos entre paréntesis.
function parseApply(expr, program) {
program = skipSpace(program);
if (program[0] != "(") {
return {expr: expr, rest: program};
}
program = skipSpace(program.slice(1));
expr = {type: "apply", operator: expr, args: []};
while (program[0] != ")") {
let arg = parseExpression(program);
expr.args.push(arg.expr);
program = skipSpace(arg.rest);
if (program[0] == ",") {
program = skipSpace(program.slice(1));
203

-- 215 of 445 --

} else if (program[0] != ")") {
throw new SyntaxError("Se esperaba ',' o ')'");
}
}
return parseApply(expr, program.slice(1));
}
Si el próximo carácter en el programa no es un paréntesis de apertura, esto no
es una aplicación y parseApply devuelve la expresión que se le dio.
De lo contrario, se salta el paréntesis de apertura y crea el objeto árbol
sintáctico para esta expresión de aplicación. Luego llama recursivamente a
parseExpression para analizar cada argumento hasta encontrar un paréntesis
de cierre. La recursión es indirecta, a través de parseApply y parseExpression
llamándose mutuamente.
Dado que una expresión de aplicación puede a su vez ser aplicada (como en
multiplicador(2)(1)), parseApply debe, después de analizar una aplicación,
llamarse a sí misma nuevamente para verificar si sigue otro par de paréntesis.
Esto es todo lo que necesitamos para analizar Egg. Lo envolvemos en una
conveniente parse función que verifica que ha llegado al final de la cadena
de entrada después de analizar la expresión (un programa Egg es una sola
expresión), y que nos da la estructura de datos del programa.
function parse(program) {
let {expr, rest} = parseExpression(program);
if (skipSpace(rest).length > 0) {
throw new SyntaxError("Texto inesperado después del programa");
}
return expr;
}
console.log(parse("+(a, 10)"));
// → {type: "apply",
// operator: {type: "word", name: "+"},
// args: [{type: "word", name: "a"},
// {type: "value", value: 10}]}
¡Funciona! No nos da información muy útil cuando falla y no almacena la línea
y la columna en las que comienza cada expresión, lo cual podría ser útil al
informar errores más tarde, pero es suficiente para nuestros propósitos.
204

-- 216 of 445 --

El evaluador
¿Qué podemos hacer con el árbol de sintaxis de un programa? ¡Ejecutarlo, por
supuesto! Y eso es lo que hace el evaluador. Le das un árbol de sintaxis y un
objeto de ámbito que asocia nombres con valores, y evaluará la expresión que
representa el árbol y devolverá el valor que esto produce.
const specialForms = Object.create(null);
function evaluate(expr, scope) {
if (expr.type == "value") {
return expr.value;
} else if (expr.type == "word") {
if (expr.name in scope) {
return scope[expr.name];
} else {
throw new ReferenceError(
`Vinculación indefinida: ${expr.name}`);
}
} else if (expr.type == "apply") {
let {operator, args} = expr;
if (operator.type == "word" &&
operator.name in specialForms) {
return specialForms[operator.name](expr.args, scope);
} else {
let op = evaluate(operator, scope);
if (typeof op == "function") {
return op(...args.map(arg => evaluate(arg, scope)));
} else {
throw new TypeError("Aplicando una no-función.");
}
}
}
}
El evaluador tiene código para cada uno de los tipos de expresión. Una ex-
presión de valor literal produce su valor. (Por ejemplo, la expresión 100 sim-
plemente se evalúa como el número 100.) Para un enlace, debemos verificar si
está realmente definido en el ámbito y, si lo está, obtener el valor del enlace.
Las aplicaciones son más complicadas. Si son una forma especial, como if, no
evaluamos nada y pasamos las expresiones de argumento, junto con el ámbito,
a la función que maneja esta forma. Si es una llamada normal, evaluamos el
operador, verificamos que sea una función, y la llamamos con los argumentos
evaluados.
205

-- 217 of 445 --

Usamos valores de función JavaScript simples para representar los valores
de función de Egg. Volveremos a esto más tarde, cuando se defina la forma
especial llamada fun.
La estructura recursiva de evaluate se asemeja a la estructura similar del
analizador sintáctico, y ambos reflejan la estructura del lenguaje en sí. Tam-
bién sería posible combinar el analizador sintáctico y el evaluador en una sola
función, y evaluar durante el análisis sintáctico. Pero dividirlos de esta manera
hace que el programa sea más claro y flexible.
Esto es realmente todo lo que se necesita para interpretar Egg. Es así de
simple. Pero sin definir algunas formas especiales y agregar algunos valores
útiles al entorno, todavía no puedes hacer mucho con este lenguaje.
Formas especiales
El objeto specialForms se utiliza para definir sintaxis especial en Egg. Asocia
palabras con funciones que evalúan dichas formas. Actualmente está vacío.
Añadamos if.
specialForms.if = (args, scope) => {
if (args.length != 3) {
throw new SyntaxError("Número incorrecto de argumentos para if")
;
} else if (evaluate(args[0], scope) !== false) {
return evaluate(args[1], scope);
} else {
return evaluate(args[2], scope);
}
};
La construcción if de Egg espera exactamente tres argumentos. Evaluará el
primero, y si el resultado no es el valor false, evaluará el segundo. De lo
contrario, se evaluará el tercero. Esta forma if se asemeja más al operador
ternario ?: de JavaScript que al if de JavaScript. Es una expresión, no una
declaración, y produce un valor, concretamente, el resultado del segundo o
tercer argumento.
Egg también difiere de JavaScript en cómo maneja el valor de condición para
if. No tratará cosas como cero o la cadena vacía como falso, solo el valor
preciso false.
La razón por la que necesitamos representar if como una forma especial, en
lugar de una función regular, es que todos los argumentos de las funciones se
evalúan antes de llamar a la función, mientras que if debe evaluar solo uno de
206

-- 218 of 445 --

sus segundos o terceros argumentos, dependiendo del valor del primero.
La forma while es similar.
specialForms.while = (args, scope) => {
if (args.length != 2) {
throw new SyntaxError("Número incorrecto de argumentos para
while");
}
while (evaluate(args[0], scope) !== false) {
evaluate(args[1], scope);
}
// Dado que undefined no existe en Egg, devolvemos false,
// por falta de un resultado significativo.
return false;
};
Otro bloque básico es do, que ejecuta todos sus argumentos de arriba abajo.
Su valor es el valor producido por el último argumento.
specialForms.do = (args, scope) => {
let valor = false;
for (let arg of args) {
valor = evaluate(arg, scope);
}
return valor;
};
Para poder crear vinculaciones y darles nuevos valores, también creamos una
forma llamada define. Espera una palabra como su primer argumento y una
expresión que produzca el valor a asignar a esa palabra como su segundo ar-
gumento. Dado que define, al igual que todo, es una expresión, debe devolver
un valor. Haremos que devuelva el valor que se asignó (como el operador = de
JavaScript).
specialForms.define = (args, scope) => {
if (args.length != 2 || args[0].type != "word") {
throw new SyntaxError("Uso incorrecto de define");
}
let value = evaluate(args[1], scope);
scope[args[0].name] = value;
return value;
};
207

-- 219 of 445 --

El entorno
El scope aceptado por evaluate es un objeto con propiedades cuyos nombres
corresponden a los nombres de los bindings y cuyos valores corresponden a
los valores a los que esos bindings están ligados. Definamos un objeto para
representar el scope global.
Para poder usar la construcción if que acabamos de definir, necesitamos
tener acceso a valores Booleanos. Dado que solo hay dos valores Booleanos,
no necesitamos una sintaxis especial para ellos. Simplemente asignamos dos
nombres a los valores true y false y los usamos.
const topScope = Object.create(null);
topScope.true = true;
topScope.false = false;
Ahora podemos evaluar una expresión simple que niega un valor Booleano.
let prog = parse(`if(true, false, true)`);
console.log(evaluate(prog, topScope));
// → false
Para suministrar operadores básicos de aritmética y comparación, también
agregaremos algunas funciones al scope. En aras de mantener el código corto,
usaremos Function para sintetizar un conjunto de funciones de operadores en
un bucle, en lugar de definirlas individualmente.
for (let op of ["+", "-", "*", "/", "==", "<", ">"]) {
topScope[op] = Function("a, b", `return a ${op} b;`);
}
También es útil tener una forma de imprimir valores, por lo que envolveremos
console.log en una función y la llamaremos print.
topScope.print = value => {
console.log(value);
return value;
};
Esto nos proporciona suficientes herramientas elementales para escribir pro-
gramas simples. La siguiente función proporciona una forma conveniente de
analizar un programa y ejecutarlo en un nuevo ámbito:
function run(program) {
return evaluate(parse(program), Object.create(topScope));
}
208

-- 220 of 445 --

Utilizaremos las cadenas de prototipos de objetos para representar ámbitos
anidados para que el programa pueda agregar bindings a su ámbito local sin
modificar el ámbito de nivel superior.
run(`
do(define(total, 0),
define(count, 1),
while(<(count, 11),
do(define(total, +(total, count)),
define(count, +(count, 1)))),
print(total))
`);
// → 55
Este es el programa que hemos visto varias veces antes, que calcula la suma de
los números del 1 al 10, expresado en Egg. Es claramente más feo que el equiva-
lente programa en JavaScript, pero no está mal para un lenguaje implementado
en menos de 150 líneas de código.
Funciones
Un lenguaje de programación sin funciones es un pobre lenguaje de progra-
mación.
Afortunadamente, no es difícil agregar una construcción fun, que trata su
último argumento como el cuerpo de la función y utiliza todos los argumentos
anteriores como los nombres de los parámetros de la función.
specialForms.fun = (args, scope) => {
if (!args.length) {
throw new SyntaxError("Las funciones necesitan un cuerpo");
}
let body = args[args.length - 1];
let params = args.slice(0, args.length - 1).map(expr => {
if (expr.type != "word") {
throw new SyntaxError("Los nombres de los parámetros deben ser
palabras");
}
return expr.name;
});
return function(...args) {
if (args.length != params.length) {
throw new TypeError("Número incorrecto de argumentos");
}
209

-- 221 of 445 --

let localScope = Object.create(scope);
for (let i = 0; i < args.length; i++) {
localScope[params[i]] = args[i];
}
return evaluate(body, localScope);
};
};
Las funciones en Egg tienen su propio ámbito local. La función producida por
la forma fun crea este ámbito local y añade los enlaces de los argumentos a él.
Luego evalúa el cuerpo de la función en este ámbito y devuelve el resultado.
run(`
do(define(plusOne, fun(a, +(a, 1))),
print(plusOne(10)))
`);
// → 11
run(`
do(define(pow, fun(base, exp,
if(==(exp, 0),
1,
*(base, pow(base, -(exp, 1)))))),
print(pow(2, 10)))
`);
// → 1024
Compilación
Lo que hemos construido es un intérprete. Durante la evaluación, actúa di-
rectamente sobre la representación del programa producido por el analizador
sintáctico.
La compilación es el proceso de agregar otro paso entre el análisis sintáctico y
la ejecución de un programa, que transforma el programa en algo que puede ser
evaluado de manera más eficiente al hacer la mayor cantidad de trabajo posible
por adelantado. Por ejemplo, en lenguajes bien diseñados, es obvio, para cada
uso de un enlace, a qué enlace se hace referencia, sin ejecutar realmente el
programa. Esto se puede utilizar para evitar buscar el enlace por nombre cada
vez que se accede, en su lugar, recuperándolo directamente desde una ubicación
de memoria predeterminada.
Tradicionalmente, compilar implica convertir el programa a código máquina,
el formato en bruto que un procesador de computadora puede ejecutar. Pero
210

-- 222 of 445 --

cualquier proceso que convierta un programa a una representación diferente se
puede considerar como compilación.
Sería posible escribir una estrategia de evaluación alternativa para Egg, una
que primero convierte el programa a un programa JavaScript, usa Function
para invocar el compilador de JavaScript en él, y luego ejecuta el resultado.
Cuando se hace correctamente, esto haría que Egg se ejecutara muy rápido y
aún así fuera bastante simple de implementar.
Si te interesa este tema y estás dispuesto a dedicar tiempo a ello, te animo
a intentar implementar ese compilador como ejercicio.
Haciendo trampa
Cuando definimos if y while, probablemente notaste que eran envoltorios más
o menos triviales alrededor del propio if y while de JavaScript. De manera
similar, los valores en Egg son simplemente valores regulares de JavaScript.
Cerrar la brecha hacia un sistema más primitivo, como el código máquina que
entiende el procesador, requiere más esfuerzo, pero la forma en que funciona
se asemeja a lo que estamos haciendo aquí.Aunque el lenguaje de juguete de
este capítulo no hace nada que no se pudiera hacer mejor en JavaScript, sí hay
situaciones donde escribir pequeños lenguajes ayuda a realizar trabajos reales.
Tal lenguaje no tiene por qué parecerse a un lenguaje de programación típico.
Si JavaScript no viniera equipado con expresiones regulares, por ejemplo, po-
drías escribir tu propio analizador sintáctico y evaluador para expresiones reg-
ulares.
O imagina que estás construyendo un programa que permite crear rápi-
damente analizadores sintácticos al proporcionar una descripción lógica del
lenguaje que necesitan analizar. Podrías definir una notación específica para
eso y un compilador que la convierta en un programa analizador.
expr = número | cadena | nombre | aplicación
number = dígito+
name = letra+
string = '"' (! '"')* '"'
application = expr '(' (expr (',' expr)*)? ')'
Esto es lo que comúnmente se denomina un lenguaje específico de dominio,
un lenguaje diseñado para expresar un ámbito estrecho de conocimiento. Tal
211

-- 223 of 445 --

lenguaje puede ser más expresivo que un lenguaje de propósito general porque
está diseñado para describir exactamente las cosas que necesitan ser descritas
en su dominio, y nada más.
Ejercicios
Arrays
Agrega soporte para arrays en Egg añadiendo las siguientes tres funciones al
ámbito superior: array(...valores) para construir un array que contenga los
valores de los argumentos, length(array) para obtener la longitud de un array
y element(array, n) para obtener el n-ésimo elemento de un array.
Clausura
La forma en que hemos definido fun permite que las funciones en Egg hagan
referencia al ámbito circundante, lo que permite que el cuerpo de la función
use valores locales que eran visibles en el momento en que se definió la función,
al igual que lo hacen las funciones de JavaScript.
El siguiente programa ilustra esto: la función f devuelve una función que
suma su argumento al argumento de f, lo que significa que necesita acceder al
ámbito local dentro de f para poder usar la vinculación a.
run(`
do(define(f, fun(a, fun(b, +(a, b)))),
print(f(4)(5)))
`);
// → 9
Vuelve a la definición del formulario fun y explica qué mecanismo hace que esto
funcione.
Comentarios
Sería bueno si pudiéramos escribir comentarios en Egg. Por ejemplo, siempre
que encontremos un signo de almohadilla (#), podríamos tratar el resto de la
línea como un comentario y ignorarlo, similar a // en JavaScript.
No tenemos que hacer grandes cambios en el analizador para admitir esto.
Simplemente podemos cambiar skipSpace para omitir comentarios como si
fueran espacios en blanco de manera que todos los puntos donde se llama a
skipSpace ahora también omitirán comentarios. Realiza este cambio.
212

-- 224 of 445 --

Corrigiendo el ámbito
Actualmente, la única forma de asignar un enlace un valor es define. Esta
construcción actúa como una forma tanto de definir nuevos enlaces como de
dar un nuevo valor a los existentes.
Esta ambigüedad causa un problema. Cuando intentas darle un nuevo valor
a un enlace no local, terminarás definiendo uno local con el mismo nombre en
su lugar. Algunos lenguajes funcionan de esta manera por diseño, pero siempre
he encontrado que es una forma incómoda de manejar el ámbito.
Agrega una forma especial set, similar a define, que da un nuevo valor a un
enlace, actualizando el enlace en un ámbito exterior si aún no existe en el ámbito
interior. Si el enlace no está definido en absoluto, lanza un ReferenceError
(otro tipo de error estándar).
La técnica de representar los ámbitos como objetos simples, que hasta ahora
ha sido conveniente, te causará un pequeño problema en este punto. Es posible
que desees usar la función Object.getPrototypeOf, la cual devuelve el pro-
totipo de un objeto. También recuerda que puedes utilizar Object.hasOwn para
verificar si un objeto dado tiene una propiedad.
213

-- 225 of 445 --

“El sueño detrás de la Web es de un espacio de información común
en el que nos comunicamos compartiendo información. Su
universalidad es esencial: el hecho de que un enlace de hipertexto
pueda apuntar a cualquier cosa, ya sea personal, local o global, ya
sea un borrador o altamente pulido.”
—Tim Berners-Lee, La World Wide Web: Una historia personal
muy breve