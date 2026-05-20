# // → LALALA

Ya hemos visto la propiedad length del tipo string. Acceder a los caracteres
individuales en una cadena se parece a acceder a los elementos de un array (con
una complicación que discutiremos en el Capítulo 5).
let string = "abc";
console.log(string.length);
// → 3
console.log(string[1]);
// → b
Parámetros restantes
Puede ser útil para una función aceptar cualquier cantidad de argumento). Por
ejemplo, Math.max calcula el máximo de todos los argumentos que se le pasan.
Para escribir una función así, colocas tres puntos antes del último parámetro
de la función, de esta manera:
function max(...numbers) {
let result = -Infinity;
for (let number of numbers) {
if (number > result) result = number;
}
return result;
72

-- 84 of 445 --

}
console.log(max(4, 1, 9, -2));
// → 9
Cuando se llama a una función así, el parámetro restante se vincula a un array
que contiene todos los argumentos restantes. Si hay otros parámetros antes de
él, sus valores no forman parte de ese array. Cuando, como en max, es el único
parámetro, contendrá todos los argumentos.
Puedes usar una notación similar de tres puntos para llamar a una función
con un array de argumentos:
let numbers = [5, 1, 7];
console.log(max(...numbers));
// → 7
Esto “expande” el array en la llamada de la función, pasando sus elementos
como argumentos separados. Es posible incluir un array de esa manera junto
con otros argumentos, como en max(9, ...numbers, 2).
La notación de array entre corchetes cuadrados permite al operador de triple
punto expandir otro array en el nuevo array:
let words = ["never", "fully"];
console.log(["will", ...words, "understand"]);
// → ["will", "never", "fully", "understand"]
Esto funciona incluso en objetos con llaves, donde agrega todas las propiedades
de otro objeto. Si una propiedad se agrega varias veces, el último valor añadido
es el que se conserva:
let coordenadas = {x: 10, y: 0};
console.log({...coordenadas, y: 5, z: 1});
// → {x: 10, y: 5, z: 1}
El objeto Math
Como hemos visto, Math es una bolsa de funciones de utilidad relacionadas con
números, tales como Math.max (máximo), Math.min (mínimo) y Math.sqrt (raíz
cuadrada).
El objeto Math se utiliza como un contenedor para agrupar un conjunto de
funcionalidades relacionadas. Solo hay un objeto Math y casi nunca es útil como
un valor. Más bien, proporciona un espacio de nombres para que todas estas
funciones y valores no tengan que ser enlaces globales.
73

-- 85 of 445 --

Tener demasiados enlaces globales “contamina” el espacio de nombres. Cuan-
tos más nombres se hayan tomado, más probable es que sobrescribas accidental-
mente el valor de algún enlace existente. Por ejemplo, es probable que quieras
nombrar algo max en uno de tus programas. Dado que la función max integrada
de JavaScript está protegida de forma segura dentro del objeto Math, no tienes
que preocuparte por sobrescribirla.
Muchos lenguajes te detendrán, o al menos te advertirán, cuando estés
definiendo un enlace con un nombre que ya está tomado. JavaScript hace
esto para enlaces que declaraste con let o const, pero —perversamente— no
para enlaces estándar ni para enlaces declarados con var o function.
Volviendo al objeto Math. Si necesitas hacer trigonometría, Math puede ayu-
darte. Contiene cos (coseno), sin (seno) y tan (tangente), así como sus fun-
ciones inversas, acos, asin y atan, respectivamente. El número π (pi) —o al
menos la aproximación más cercana que cabe en un número de JavaScript—
está disponible como Math.PI. Existe una antigua tradición de programación
que consiste en escribir los nombres de valores constantes en mayúsculas:
function puntoAleatorioEnCirculo(radio) {
let ángulo = Math.random() * 2 * Math.PI;
return {x: radio * Math.cos(ángulo),
y: radio * Math.sin(ángulo)};
}
console.log(puntoAleatorioEnCirculo(2));
// → {x: 0.3667, y: 1.966}
Si no estás familiarizado con senos y cosenos, no te preocupes. Los explicaré
cuando se utilicen en este libro, en el Capítulo 14.
El ejemplo anterior utilizó Math.random. Esta es una función que devuelve
un nuevo número pseudoaleatorio entre cero (inclusive) y uno (exclusivo) cada
vez que la llamas:
console.log(Math.random());
// → 0.36993729369714856
console.log(Math.random());
// → 0.727367032552138
console.log(Math.random());
// → 0.40180766698904335
Aunque las computadoras son máquinas deterministas —siempre reaccionan de
la misma manera si se les da la misma entrada— es posible hacer que produzcan
números que parezcan aleatorios. Para lograrlo, la máquina mantiene algún
valor oculto y, cada vez que solicitas un nuevo número aleatorio, realiza cálculos
complicados en este valor oculto para crear un valor nuevo. Almacena un
74

-- 86 of 445 --

nuevo valor y devuelve algún número derivado de este. De esta manera, puede
producir números nuevos y difíciles de predecir que se aparentan aleatorios.
Si queremos un número entero aleatorio en lugar de uno fraccionario, pode-
mos usar Math.floor (que redondea hacia abajo al número entero más cercano)
en el resultado de Math.random:
console.log(Math.floor(Math.random() * 10));
// → 2
Al multiplicar el número aleatorio por 10, obtenemos un número mayor o igual
a 0 y menor que 10. Dado que Math.floor redondea hacia abajo, esta expresión
producirá, con igual probabilidad, cualquier número del 0 al 9.
También existen las funciones Math.ceil (para “techo”, que redondea hacia
arriba al número entero más cercano), Math.round (al número entero más cer-
cano) y Math.abs, que toma el valor absoluto de un número, es decir, niega los
valores negativos pero deja los positivos tal como están.
Desestructuración
Volviendo por un momento a la función phi.
function phi(table) {
return (table[3] * table[0] - table[2] * table[1]) /
Math.sqrt((table[2] + table[3]) *
(table[0] + table[1]) *
(table[1] + table[3]) *
(table[0] + table[2]));
}
Una razón por la que esta función es difícil de leer es que tenemos una asignación
apuntando a nuestro array, pero preferiríamos tener asignaciones para los el-
ementos del array, es decir, let n00 = table[0] y así sucesivamente. Afortu-
nadamente, hay una forma concisa de hacer esto en JavaScript:
function phi([n00, n01, n10, n11]) {
return (n11 * n00 - n10 * n01) /
Math.sqrt((n10 + n11) * (n00 + n01) *
(n01 + n11) * (n00 + n10));
}
Esto también funciona para asignaciones creadas con let, var o const. Si sabes
que el valor que estás asignando es un array, puedes usar corchetes para “mirar
dentro” del valor y asignar sus contenidos.
Un truco similar funciona para objetos, usando llaves en lugar de corchetes:
75

-- 87 of 445 --

let {name} = {name: "Faraji", age: 23};
console.log(name);
// → Faraji
Ten en cuenta que si intentas desestructurar null o undefined, obtendrás un
error, igual que si intentaras acceder directamente a una propiedad de esos
valores.
Acceso opcional a propiedades
Cuando no estás seguro de si un valor dado produce un objeto pero aún deseas
leer una propiedad de él cuando lo hace, puedes usar una variante de la notación
de punto: objeto?.propiedad.
function city(objeto) {
return objeto.address?.city;
}
console.log(city({address: {city: "Toronto"}}));
// → Toronto
console.log(city({name: "Vera"}));
// → undefined
La expresión a?.b significa lo mismo que a.b cuando a no es nulo o indefinido.
Cuando lo es, se evalúa como indefinido. Esto puede ser conveniente cuando,
como en el ejemplo, no estás seguro de si una propiedad dada existe o cuando
una variable podría contener un valor indefinido.
Una notación similar se puede utilizar con el acceso a corchetes cuadrados,
e incluso con llamadas de funciones, colocando ?. delante de los paréntesis o
corchetes:
console.log("string".notAMethod?.());
// → undefined
console.log({}.arrayProp?.[0]);
// → undefined
JSON
Debido a que las propiedades capturan su valor en lugar de contenerlo, los obje-
tos y arrays se almacenan en la memoria de la computadora como secuencias de
bits que contienen las direcciones—el lugar en la memoria—de sus contenidos.
Un array con otro array dentro de él consiste en (al menos) una región de
76

-- 88 of 445 --

memoria para el array interno y otra para el array externo, que contiene (entre
otras cosas) un número que representa la dirección del array interno.
Si deseas guardar datos en un archivo para más tarde o enviarlos a otra
computadora a través de la red, debes convertir de alguna manera estas marañas
de direcciones de memoria en una descripción que se pueda almacenar o enviar.
Podrías enviar toda la memoria de tu computadora junto con la dirección del
valor que te interesa, supongo, pero eso no parece ser el mejor enfoque.
Lo que podemos hacer es serializar los datos. Eso significa que se convierten
en una descripción plana. Un formato de serialización popular se llama JSON
(pronunciado “Jason”), que significa JavaScript Object Notacion. Se utiliza
ampliamente como formato de almacenamiento y comunicación de datos en la
Web, incluso en lenguajes que no son JavaScript.
JSON se parece al formato de escritura de arrays y objetos de JavaScript, con
algunas restricciones. Todos los nombres de propiedades deben estar rodeados
de comillas dobles y solo se permiten expresiones de datos simples—no lla-
madas a funciones, enlaces, o cualquier cosa que implique cálculos reales. Los
comentarios no están permitidos en JSON.
Una entrada de diario podría verse así cuando se representa como datos
JSON:
{
"squirrel": false,
"events": ["work", "touched tree", "pizza", "running"]
}
JavaScript nos proporciona las funciones JSON.stringify y JSON.parse para
convertir datos a este formato y desde este formato. La primera toma un valor
de JavaScript y devuelve una cadena codificada en JSON. La segunda toma
dicha cadena y la convierte en el valor que codifica:
let string = JSON.stringify({squirrel: false,
events: ["weekend"]});
console.log(string);
// → {"squirrel":false,"events":["weekend"]}
console.log(JSON.parse(string).events);
// → ["weekend"]
Resumen
Los objetos y arrays proporcionan formas de agrupar varios valores en un único
valor. Esto nos permite poner un montón de cosas relacionadas en una bolsa y
77

-- 89 of 445 --

correr con la bolsa en lugar de envolver nuestros brazos alrededor de cada una
de las cosas individuales e intentar sostenerlas por separado.
La mayoría de los valores en JavaScript tienen propiedades, con las excep-
ciones siendo null y undefined. Las propiedades se acceden usando valor.prop
o valor["prop"]. Los objetos tienden a usar nombres para sus propiedades y
almacenan más o menos un conjunto fijo de ellas. Los arrays, por otro lado,
suelen contener cantidades variables de valores conceptualmente idénticos y
usan números (comenzando desde 0) como los nombres de sus propiedades.
Sí hay algunas propiedades nombradas en arrays, como length y varios méto-
dos. Los métodos son funciones que viven en propiedades y (usualmente) ac-
túan sobre el valor del cual son una propiedad.
Puedes iterar sobre arrays usando un tipo especial de bucle for: for (let
elemento of array).
Ejercicios
La suma de un rango
La introducción de este libro insinuó lo siguiente como una forma agradable de
calcular la suma de un rango de números:
console.log(sum(range(1, 10)));
Escribe una función range que tome dos argumentos, inicio y fin, y devuelva
un array que contenga todos los números desde inicio hasta fin, incluyendo
fin.
Luego, escribe una función sum que tome un array de números y devuelva la
suma de estos números. Ejecuta el programa de ejemplo y verifica si realmente
devuelve 55.
Como asignación adicional, modifica tu función range para que tome un
tercer argumento opcional que indique el valor de “paso” utilizado al construir
el array. Si no se proporciona un paso, los elementos deberían aumentar en
incrementos de uno, correspondiendo al comportamiento anterior. La llamada
a la función range(1, 10, 2) debería devolver [1, 3, 5, 7, 9]. Asegúrate de
que esto también funcione con valores de paso negativos, de modo que range
(5, 2, -1) produzca [5, 4, 3, 2].
Reversión de un array
Los arrays tienen un método reverse que cambia el array invirtiendo el or-
den en el que aparecen sus elementos. Para este ejercicio, escribe dos fun-
78

-- 90 of 445 --

ciones, reverseArray y reverseArrayInPlace. La primera, reverseArray, de-
bería tomar un array como argumento y producir un nuevo array que tenga los
mismos elementos en orden inverso. La segunda, reverseArrayInPlace, debería
hacer lo que hace el método reverse: modificar el array dado como argumento
invirtiendo sus elementos. Ninguna de las funciones puede utilizar el método
reverse estándar.
Recordando las notas sobre efectos secundarios y funciones puras en el capí-
tulo anterior, ¿qué variante esperas que sea útil en más situaciones? ¿Cuál se
ejecuta más rápido?
Lista
Como bloques genéricos de valores, los objetos se pueden utilizar para construir
todo tipo de estructuras de datos. Una estructura de datos común es la lista
(no confundir con arrays). Una lista es un conjunto anidado de objetos, donde
el primer objeto contiene una referencia al segundo, el segundo al tercero, y así
sucesivamente:
let list = {
value: 1,
rest: {
value: 2,
rest: {
value: 3,
rest: null
}
}
};
Los objetos resultantes forman una cadena, como se muestra en el siguiente
diagrama:
value: 1
rest: value: 2
rest: value: 3
rest: null
Una ventaja de las listas es que pueden compartir partes de su estructura.
Por ejemplo, si creo dos nuevos valores {value: 0, rest: list} y {value:
-1, rest: list} (siendo list la referencia definida anteriormente), son listas
independientes, pero comparten la estructura que conforma sus últimos tres
elementos. La lista original también sigue siendo válida como una lista de tres
elementos.
Escribe una función arrayToList que construya una estructura de lista como
79

-- 91 of 445 --

la mostrada cuando se le da [1, 2, 3] como argumento. También escribe una
función listToArray que produzca un array a partir de una lista. Agrega las
funciones auxiliares prepend, que toma un elemento y una lista y crea una
nueva lista que añade el elemento al principio de la lista de entrada, y nth, que
toma una lista y un número y devuelve el elemento en la posición dada en la
lista (siendo cero el primer elemento) o undefined cuando no hay tal elemento.
Si aún no lo has hecho, escribe también una versión recursiva de nth.
Comparación profunda
El operador == compara objetos por identidad, pero a veces preferirías comparar
los valores de sus propiedades reales.
Escribe una función deepEqual que tome dos valores y devuelva true solo si
son el mismo valor o son objetos con las mismas propiedades, donde los valores
de las propiedades son iguales cuando se comparan con una llamada recursiva
a deepEqual.
Para saber si los valores deben compararse directamente (usando el operador
=== para eso) o si sus propiedades deben compararse, puedes usar el operador
typeof. Si produce "object" para ambos valores, deberías hacer una compara-
ción profunda. Pero debes tener en cuenta una excepción tonta: debido a un
accidente histórico, typeof null también produce "object".
La función Object.keys será útil cuando necesites recorrer las propiedades
de los objetos para compararlas.
80

-- 92 of 445 --

Chapter 5
Funciones de Orden Superior
“Hay dos formas de construir un diseño de software: Una forma es hacerlo
tan simple que obviamente no haya deficiencias, y la otra forma es hacerlo tan
complicado que no haya deficiencias obvias.”
— C.A.R. Hoare, Discurso de Recepción del Premio Turing de la ACM de
1980
Un programa grande es un programa costoso, y no solo por el tiempo que
lleva construirlo. El tamaño casi siempre implica complejidad, y la compleji-
dad confunde a los programadores. Los programadores confundidos, a su vez,
introducen errores (bugs) en los programas. Un programa grande proporciona
mucho espacio para que estos errores se escondan, lo que los hace difíciles de
encontrar.
Volviendo brevemente a los dos ejemplos finales de programas en la intro-
ducción. El primero es autocontenido y tiene seis líneas:
let total = 0, count = 1;
while (count <= 10) {
total += count;
count += 1;
}
console.log(total);
El segundo depende de dos funciones externas y tiene una línea:
console.log(suma(rango(1, 10)));
¿Cuál es más probable que contenga un error?
Si contamos el tamaño de las definiciones de suma y rango, el segundo pro-
grama también es grande, incluso más que el primero. Pero, aún así, argumen-
taría que es más probable que sea correcto.
Esto se debe a que la solución se expresa en un vocabulary que corresponde
al problema que se está resolviendo. Sumar un rango de números no se trata
de bucles y contadores. Se trata de rangos y sumas.
Las definiciones de este vocabulario (las funciones suma y rango) seguirán
81

-- 93 of 445 --

involucrando bucles, contadores y otros detalles incidentales. Pero debido a
que expresan conceptos más simples que el programa en su totalidad, son más
fáciles de hacer correctamente.
Abstracción
En el contexto de la programación, este tipo de vocabularios se suelen llamar
abstractions. Las abstracciones nos brindan la capacidad de hablar sobre prob-
lemas a un nivel superior (o más abstracto), sin distraernos con detalles no
interesantes.
Como analogía, compara estas dos recetas de sopa de guisantes. La primera
es así:
_”Pon 1 taza de guisantes secos por persona en un recipiente. Agrega agua
hasta que los guisantes estén bien cubiertos. Deja los guisantes en agua durante
al menos 12 horas. Saca los guisantes del agua y ponlos en una olla. Agrega
4 tazas de agua por persona. Cubre la olla y deja que los guisantes hiervan a
fuego lento durante dos horas. Toma media cebolla por persona. Córtala en
trozos con un cuchillo. Agrégala a los guisantes. Toma un tallo de apio por
persona. Córtalo en trozos con un cuchillo. Agrégalo a los guisantes. Toma
una zanahoria por persona. ¡Córtala en trozos! ¡Con un cuchillo! Agrégala a
los guisantes. Cocina durante 10 minutos más.”_Cita:
Y esta es la segunda receta:
Por persona: 1 taza de guisantes partidos secos, 4 tazas de agua, media
cebolla picada, un tallo de apio y una zanahoria.
Remoja los guisantes durante 12 horas. Cocina a fuego lento durante 2 horas.
Pica y agrega las verduras. Cocina durante 10 minutos más.
El segundo es más corto y más fácil de interpretar. Pero necesitas entender
algunas palabras más relacionadas con la cocina, como remojar, cocinar a fuego
lento, picar, y, supongo, verdura.
Cuando se programa, no podemos depender de que todas las palabras que
necesitamos estén esperándonos en el diccionario. Por lo tanto, podríamos
caer en el patrón de la primera receta: trabajar en los pasos precisos que la
computadora tiene que realizar, uno por uno, ciegos a los conceptos de más
alto nivel que expresan.
Abstraer la repetición
Las funciones simples, como las hemos visto hasta ahora, son una buena
manera de construir abstracciones. Pero a veces se quedan cortas.
Es común que un programa haga algo un número determinado de veces.
Puedes escribir un for para eso, así:
82

-- 94 of 445 --

for (let i = 0; i < 10; i++) {
console.log(i);
}
¿Podemos abstraer “hacer algo N veces” como una función? Bueno, es fácil
escribir una función que llame a console.log N veces:
function repeatLog(n) {
for (let i = 0; i < n; i++) {
console.log(i);
}
}
¿Y si queremos hacer algo que no sea solo registrar los números? Dado que
“hacer algo” se puede representar como una función y las funciones son solo
valores, podemos pasar nuestra acción como un valor de función:
function repetir(n, action) {
for (let i = 0; i < n; i++) {
action(i);
}
}
repetir(3, console.log);
// → 0
// → 1
// → 2
No tenemos que pasar una función predefinida a repetir. A menudo, es más
fácil crear un valor de función en el momento:
let etiquetas = [];
repetir(5, i => {
etiquetas.push(`Unidad ${i + 1}`);
});
console.log(etiquetas);
// → ["Unidad 1", "Unidad 2", "Unidad 3", "Unidad 4", "Unidad 5"]
Esto está estructurado un poco como un for loop: primero describe el tipo de
loop y luego proporciona un cuerpo. Sin embargo, el cuerpo ahora está escrito
como un valor de función, que está envuelto entre los paréntesis de la llamada
a repetir. Por eso tiene que cerrarse con el corchete de cierre y el paréntesis
de cierre. En casos como este ejemplo donde el cuerpo es una sola expresión
pequeña, también podrías omitir los corchetes y escribir el bucle en una sola
línea.
Funciones de orden superior
83

-- 95 of 445 --

Las funciones que operan en otras funciones, ya sea tomandolas como ar-
gumentos o devolviéndolas, se llaman funciones de orden superior. Dado que
ya hemos visto que las funciones son valores regulares, no hay nada partic-
ularmente notable sobre el hecho de que existan tales funciones. El término
proviene de las matemáticas, donde se toma más en serio la distinción entre
funciones y otros valores.
Las funciones de orden superior nos permiten abstraer sobre acciones, no solo
sobre valores. Vienen en varias formas. Por ejemplo, podemos tener funciones
que crean nuevas funciones:
function mayorQue(n) {
return m => m > n;
}
let mayorQue10 = mayorQue(10);
console.log(mayorQue10(11));
// → true
También podemos tener funciones que modifican otras funciones:
function ruidosa(f) {
return (...args) => {
console.log("llamando con", args);
let resultado = f(...args);
console.log("llamado con", args, ", devolvió", resultado);
return resultado;
};
}
ruidosa(Math.min)(3, 2, 1);
// → llamando con [3, 2, 1]
// → llamado con [3, 2, 1] , devolvió 1
Incluso podemos escribir funciones que proveen nuevos tipos de flujo de control:
function aMenosQue(prueba, entonces) {
if (!prueba) entonces();
}
repetir(3, n => {
aMenosQue(n % 2 == 1, () => {
console.log(n, "es par");
});
});
// → 0 es par
// → 2 es par
Existe un método incorporado de arrays, forEach, que proporciona algo similar
84

-- 96 of 445 --

a un bucle for/of como una función de orden superior:
["A", "B"].forEach(l => console.log(l));
// → A
// → B
Conjunto de datos de script
Un área donde las funciones de orden superior destacan es en el procesamiento
de datos. Para procesar datos, necesitaremos algunos ejemplos de datos reales.
Este capítulo utilizará un conjunto de datos sobre scripts—sistemas de escritura
tales como el latín, cirílico o árabe.
¿Recuerdas Unicode del Capítulo 1, el sistema que asigna un número a cada
carácter en lenguaje escrito? La mayoría de estos caracteres están asociados
con un script específico. El estándar contiene 140 scripts diferentes, de los
cuales 81 aún se utilizan hoy en día y 59 son históricos.
Aunque solo puedo leer con fluidez caracteres latinos, aprecio el hecho de que
las personas estén escribiendo textos en al menos otros 80 sistemas de escritura,
muchos de los cuales ni siquiera reconocería. Por ejemplo, aquí tienes una
muestra de escritura Tamil:
El ejemplo del conjunto de datos contiene algunas piezas de información so-
bre los 140 scripts definidos en Unicode. Está disponible en el sandbox de
código para este capítulo (https://eloquentjavascript.net/code#5) como el en-
lace SCRIPTS. El enlace contiene un array de objetos, cada uno describe un
script:
{
name: "Copto",
rangos: [[994, 1008], [11392, 11508], [11513, 11520]],
dirección: "ltr",
año: -200,
vivo: false,
enlace: "https://es.wikipedia.org/wiki/Alfabeto_copto"
}
Tal objeto nos informa sobre el nombre del script, los rangos Unicode asignados
a él, la dirección en la que se escribe, el tiempo de origen (aproximado), si
85

-- 97 of 445 --

todavía se utiliza, y un enlace a más información. La dirección puede ser "ltr"
para izquierda a derecha, "rtl" para derecha a izquierda (como se escribe el
texto en árabe y hebreo) o "ttb" para arriba hacia abajo (como en la escritura
mongola).
La propiedad ranges contiene una matriz de rangos de caracteres Unicode,
cada uno de los cuales es una matriz de dos elementos que contiene un límite
inferior y un límite superior. Todos los códigos de caracteres dentro de estos
rangos se asignan al guion. El límite inferior es inclusivo (el código 994 es un
carácter copto) y el límite superior no es inclusivo (el código 1008 no lo es).
Filtrado de arrays
Si queremos encontrar los guiones en el conjunto de datos que todavía se uti-
lizan, la siguiente función puede ser útil. Filtra los elementos de una matriz
que no pasan una prueba.
function filter(array, test) {
let passed = [];
for (let element of array) {
if (test(element)) {
passed.push(element);
}
}
return passed;
}
console.log(filter(SCRIPTS, script => script.living));
// → [{name: "Adlam", …}, …]
La función utiliza el argumento llamado test, un valor de función, para llenar
un “vacío” en la computación, el proceso de decidir qué elementos recopilar.
Observa cómo la función filter, en lugar de eliminar elementos de la matriz
existente, construye una nueva matriz con solo los elementos que pasan la
prueba. Esta función es pura. No modifica la matriz que se le pasa.
Al igual que forEach, filter es un método de matriz estándar. El ejem-
plo definió la función solo para mostrar qué hace internamente. De ahora en
adelante, lo usaremos de esta manera en su lugar:
console.log(SCRIPTS.filter(s => s.direction == "ttb"));
// → [{name: "Mongolian", …}, …]
86

-- 98 of 445 --

Transformación con map
Digamos que tenemos una matriz de objetos que representan guiones, producida
al filtrar la matriz SCRIPTS de alguna manera. Queremos una matriz de nombres
en su lugar, que es más fácil de inspeccionar.
El método map transforma una matriz aplicando una función a todos sus
elementos y construyendo una nueva matriz a partir de los valores devueltos.
La nueva matriz tendrá la misma longitud que la matriz de entrada, pero su
contenido habrá sido mapeado a una nueva forma por la función:
function map(array, transform) {
let mapped = [];
for (let element of array) {
mapped.push(transform(element));
}
return mapped;
}
let rtlScripts = SCRIPTS.filter(s => s.direction == "rtl");
console.log(map(rtlScripts, s => s.name));
// → ["Adlam", "Arabic", "Imperial Aramaic", …]
Al igual que forEach y filter, map es un método de matriz estándar.
Resumen con reduce
Otra cosa común que hacer con matrices es calcular un único valor a partir
de ellas. Nuestro ejemplo recurrente, sumar una colección de números, es una
instancia de esto. Otro ejemplo es encontrar el guion con más caracteres.
La operación de orden superior que representa este patrón se llama reduce
(a veces también llamada fold). Construye un valor tomando repetidamente
un único elemento del array y combinándolo con el valor actual. Al sumar
números, comenzarías con el número cero y, para cada elemento, lo sumarías
al total.
Los parámetros de reduce son, además del array, una función de combinación
y un valor inicial. Esta función es un poco menos directa que filter y map, así
que obsérvala detenidamente:
function reduce(array, combine, start) {
let current = start;
for (let element of array) {
current = combine(current, element);
}
87

-- 99 of 445 --

return current;
}
console.log(reduce([1, 2, 3, 4], (a, b) => a + b, 0));
// → 10
El método estándar de arrays reduce, que por supuesto corresponde a esta
función, tiene una conveniencia adicional. Si tu array contiene al menos un
elemento, puedes omitir el argumento start. El método tomará el primer
elemento del array como su valor inicial y comenzará a reducir en el segundo
elemento.
console.log([1, 2, 3, 4].reduce((a, b) => a + b));
// → 10
Para usar reduce (dos veces) y encontrar el script con más caracteres, podemos
escribir algo así:
function characterCount(script) {
return script.ranges.reduce((count, [from, to]) => {
return count + (to - from);
}, 0);
}
console.log(SCRIPTS.reduce((a, b) => {
return characterCount(a) < characterCount(b) ? b : a;
}));
// → {name: "Han", …}
La función characterCount reduce los rangos asignados a un script sumando
sus tamaños. Observa el uso de la desestructuración en la lista de parámet-
ros de la función reductora. La segunda llamada a reduce luego utiliza esto
para encontrar el script más grande comparando repetidamente dos scripts y
devolviendo el más grande.
El script Han tiene más de 89,000 caracteres asignados en el estándar Uni-
code, convirtiéndolo en el sistema de escritura más grande en el conjunto de
datos. Han es un script a veces utilizado para texto en chino, japonés y core-
ano. Esos idiomas comparten muchos caracteres, aunque tienden a escribirlos
de manera diferente. El Consorcio Unicode (con sede en EE. UU.) decidió
tratarlos como un único sistema de escritura para ahorrar códigos de carac-
teres. Esto se llama unificación Han y todavía molesta a algunas personas.
88

-- 100 of 445 --

Composabilidad
Considera cómo hubiéramos escrito el ejemplo anterior (encontrando el script
más grande) sin funciones de orden superior. El código no es mucho peor:
let biggest = null;
for (let script of SCRIPTS) {
if (biggest == null ||
characterCount(biggest) < characterCount(script)) {
biggest = script;
}
}
console.log(biggest);
// → {name: "Han", …}
Hay algunas variables adicionales y el programa tiene cuatro líneas más, pero
sigue siendo muy legible.
Las abstracciones proporcionadas por estas funciones brillan realmente cuando
necesitas componer operaciones. Como ejemplo, escribamos un código que en-
cuentre el año promedio de origen para scripts vivos y muertos en el conjunto
de datos:
function average(array) {
return array.reduce((a, b) => a + b) / array.length;
}
console.log(Math.round(average(
SCRIPTS.filter(s => s.living).map(s => s.year))));
// → 1165
console.log(Math.round(average(
SCRIPTS.filter(s => !s.living).map(s => s.year))));
// → 204
Como puedes ver, los scripts muertos en Unicode son, en promedio, más an-
tiguos que los vivos. Esta no es una estadística muy significativa o sorprendente.
Pero espero que estés de acuerdo en que el código utilizado para calcularlo no es
difícil de leer. Puedes verlo como un pipeline: empezamos con todos los scripts,
filtramos los vivos (o muertos), tomamos los años de esos scripts, calculamos
el promedio y redondeamos el resultado.
Definitivamente también podrías escribir este cálculo como un único loop
grande:
let total = 0, count = 0;
for (let script of SCRIPTS) {
if (script.living) {
89

-- 101 of 445 --

total += script.year;
count += 1;
}
}
console.log(Math.round(total / count));
// → 1165
Sin embargo, es más difícil ver qué se estaba calculando y cómo. Y debido a
que los resultados intermedios no se representan como valores coherentes, sería
mucho más trabajo extraer algo como average en una función separada.
En términos de lo que realmente está haciendo la computadora, estos dos
enfoques también son bastante diferentes. El primero construirá nuevos arrays
al ejecutar filter y map, mientras que el segundo calcula solo algunos números,
haciendo menos trabajo. Por lo general, puedes permitirte el enfoque legible,
pero si estás procesando matrices enormes y haciéndolo muchas veces, el estilo
menos abstracto podría valer la pena por la velocidad adicional.
Cadenas y códigos de caracteres
Un uso interesante de este conjunto de datos sería averiguar qué script está
utilizando un fragmento de texto. Vamos a través de un programa que hace
esto.
Recuerda que cada script tiene asociado un array de intervalos de códigos
de caracteres. Dado un código de carácter, podríamos usar una función como
esta para encontrar el script correspondiente (si lo hay):
function characterScript(code) {
for (let script of SCRIPTS) {
if (script.ranges.some(([from, to]) => {
return code >= from && code < to;
})) {
return script;
}
}
return null;
}
console.log(characterScript(121));
// → {name: "Latin", …}
El método some es otra función de orden superior. Toma una función de prueba
y te dice si esa función devuelve true para alguno de los elementos en el array.
Pero, ¿cómo obtenemos los códigos de caracteres en una cadena?
90

-- 102 of 445 --

En Chapter 1 mencioné que las cadenas de JavaScript están codificadas como
una secuencia de números de 16 bits. Estos se llaman unidades de código. Un
código de carácter Unicode inicialmente se suponía que cabía dentro de tal
unidad (lo que te da un poco más de 65,000 caracteres). Cuando quedó claro
que eso no iba a ser suficiente, muchas personas se mostraron reacias a la necesi-
dad de usar más memoria por carácter. Para abordar estas preocupaciones, se
inventó UTF-16, el formato también utilizado por las cadenas de JavaScript.
Describe la mayoría de los caracteres comunes usando una única unidad de
código de 16 bits, pero usa un par de dos unidades de dicho tipo para otros.
UTF-16 generalmente se considera una mala idea hoy en día. Parece casi
diseñado intencionalmente para invitar a errores. Es fácil escribir programas
que pretendan que las unidades de código y los caracteres son lo mismo. Y
si tu lenguaje no utiliza caracteres de dos unidades, eso parecerá funcionar
perfectamente. Pero tan pronto como alguien intente usar dicho programa con
algunos caracteres chinos menos comunes, fallará. Afortunadamente, con la
llegada de los emoji, todo el mundo ha comenzado a usar caracteres de dos
unidades, y la carga de tratar con tales problemas está más equitativamente
distribuida.
Lamentablemente, las operaciones obvias en las cadenas de JavaScript, como
obtener su longitud a través de la propiedad length y acceder a su contenido
usando corchetes cuadrados, tratan solo con unidades de código.
// Dos caracteres emoji, caballo y zapato
let horseShoe = "🐴👟";
console.log(horseShoe.length);
// → 4
console.log(horseShoe[0]);
// → (Mitad de carácter inválida)
console.log(horseShoe.charCodeAt(0));
// → 55357 (Código de la mitad de carácter)
console.log(horseShoe.codePointAt(0));
// → 128052 (Código real para el emoji de caballo)
El método charCodeAt de JavaScript te da una unidad de código, no un código
de carácter completo. El método codePointAt, añadido más tarde, sí da un
carácter Unicode completo, por lo que podríamos usarlo para obtener caracteres
de una cadena. Pero el argumento pasado a codePointAt sigue siendo un índice
en la secuencia de unidades de código. Para recorrer todos los caracteres en
una cadena, aún necesitaríamos abordar la cuestión de si un carácter ocupa
una o dos unidades de código.
En el capítulo anterior, mencioné que un bucle for/of también se puede usar
91

-- 103 of 445 --

en cadenas. Al igual que codePointAt, este tipo de bucle se introdujo en un
momento en que la gente era muy consciente de los problemas con UTF-16.
Cuando lo usas para recorrer una cadena, te proporciona caracteres reales, no
unidades de código:
let roseDragon = "🌹🐉";
for (let char of roseDragon) {
console.log(char);
}
// → 🌹
// → 🐉
Si tienes un carácter (que será una cadena de una o dos unidades de código),
puedes usar codePointAt(0) para obtener su código.
Reconociendo texto
Tenemos una función characterScript y una forma de recorrer correctamente
los caracteres. El próximo paso es contar los caracteres que pertenecen a cada
script. La siguiente abstracción de conteo será útil para eso:
function countBy(items, groupName) {
let counts = [];
for (let item of items) {
let name = groupName(item);
let known = counts.find(c => c.name == name);
if (!known) {
counts.push({name, count: 1});
} else {
known.count++;
}
}
return counts;
}
console.log(countBy([1, 2, 3, 4, 5], n => n > 2));
// → [{name: false, count: 2}, {name: true, count: 3}]
La función countBy espera una colección (cualquier cosa por la que podamos
iterar con for/of) y una función que calcule un nombre de grupo para un
elemento dado. Devuelve una matriz de objetos, cada uno de los cuales nombra
un grupo y te dice el número de elementos que se encontraron en ese grupo.
Utiliza otro método de array, find, que recorre los elementos en el array y
92

-- 104 of 445 --

devuelve el primero para el cual una función devuelve true. Devuelve undefined
cuando no se encuentra dicho elemento.
Usando countBy, podemos escribir la función que nos dice qué scripts se
utilizan en un fragmento de texto:
function textScripts(text) {
let scripts = countBy(text, char => {
let script = characterScript(char.codePointAt(0));
return script ? script.name : "ninguno";
}).filter(({name}) => name != "ninguno");
let total = scripts.reduce((n, {count}) => n + count, 0);
if (total == 0) return "No se encontraron scripts";
return scripts.map(({name, count}) => {
return `${Math.round(count * 100 / total)}% ${name}`;
}).join(", ");
}
console.log(textScripts('英国的狗说"woof", 俄罗斯的狗说"тяв"'));
// → 61% Han, 22% Latin, 17% Cyrillic
La función primero cuenta los caracteres por nombre, usando characterScript
para asignarles un nombre y retrocediendo a la cadena "ninguno" para los
caracteres que no forman parte de ningún script. La llamada a filter elimina
la entrada de "ninguno" del array resultante, ya que no nos interesan esos
caracteres.
Para poder calcular porcentajes, primero necesitamos el número total de
caracteres que pertenecen a un script, lo cual podemos calcular con reduce. Si
no se encuentran dichos caracteres, la función devuelve una cadena específica.
De lo contrario, transforma las entradas de conteo en cadenas legibles con map
y luego las combina con join.
Resumen
Poder pasar valores de funciones a otras funciones es un aspecto muy útil de
JavaScript. Nos permite escribir funciones que modelan cálculos con “vacíos”.
El código que llama a estas funciones puede llenar los vacíos proporcionando
valores de funciones.
Los arrays proporcionan diversos métodos de orden superior útiles. Puedes
usar forEach para recorrer los elementos de un array. El método filter de-
vuelve un nuevo array que contiene solo los elementos que pasan la función de
93

-- 105 of 445 --

predicado. Transformar un array poniendo cada elemento en una función se
hace con map. Puedes usar reduce para combinar todos los elementos de un
array en un único valor. El método some comprueba si algún elemento coincide
con una función de predicado dada, mientras que find encuentra el primer
elemento que coincide con un predicado.
Ejercicios
Aplanamiento
Utiliza el método reduce en combinación con el método concat para “aplanar”
un array de arrays en un único array que contenga todos los elementos de los
arrays originales.
Tu propio bucle
Escribe una función de orden superior loop que proporcione algo similar a una
declaración for loop. Debería recibir un valor, una función de prueba, una
función de actualización y una función de cuerpo. En cada iteración, primero
debe ejecutar la función de prueba en el valor actual del bucle y detenerse si
devuelve falso. Luego debe llamar a la función de cuerpo, dándole el valor
actual, y finalmente llamar a la función de actualización para crear un nuevo
valor y empezar de nuevo desde el principio.
Al definir la función, puedes usar un bucle regular para hacer el bucle real.
Everything
Los arrays también tienen un método every análogo al método some. Este
método devuelve true cuando la función dada devuelve true para cada elemento
en el array. En cierto modo, some es una versión del operador || que actúa en
arrays, y every es como el operador &&.
Implementa every como una función que recibe un array y una función de
predicado como parámetros. Escribe dos versiones, una usando un bucle y otra
usando el método some.
Dirección de escritura dominante
Escribe una función que calcule la dirección de escritura dominante en una ca-
dena de texto. Recuerda que cada objeto script tiene una propiedad direction
que puede ser "ltr" (de izquierda a derecha), "rtl" (de derecha a izquierda) o
"ttb" (de arriba a abajo).
94

-- 106 of 445 --

“Un tipo de dato abstracto se realiza escribiendo un tipo especial de
programa [...] que define el tipo en términos de las operaciones que
se pueden realizar en él.”
—Barbara Liskov, Programando con Tipos de Datos Abstractos
Chapter 6
La Vida Secreta de los Objetos
El Capítulo 4 introdujo los objetos de JavaScript, como contenedores que al-
macenan otros datos.
En la cultura de la programación, tenemos algo llamado programación ori-
entada a objetos, un conjunto de técnicas que utilizan objetos como principio
central de la organización de programas. Aunque nadie realmente se pone de
acuerdo en su definición precisa, la programación orientada a objetos ha dado
forma al diseño de muchos lenguajes de programación, incluido JavaScript. Este