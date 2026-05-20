# Capítulo 20: mostrará cómo instalar tales paquetes localmente usando el pro-

grama de línea de comandos npm.
Tener paquetes de calidad disponibles para descargar es extremadamente
valioso. Significa que a menudo podemos evitar reinventar un programa que
100 personas han escrito antes y obtener una implementación sólida y bien
169

-- 181 of 445 --

probada con solo presionar algunas teclas.
El software es barato de copiar, por lo que una vez que alguien lo ha escrito,
distribuirlo a otras personas es un proceso eficiente. Pero escribirlo en primer
lugar es trabajo, y responder a las personas que han encontrado problemas en
el código, o que desean proponer nuevas características, es incluso más trabajo.
Por defecto, eres el propietario de los derechos de autor del código que es-
cribes, y otras personas solo pueden usarlo con tu permiso. Pero porque algu-
nas personas son amables y porque publicar buen software puede ayudarte a
volverte un poco famoso entre los programadores, muchos paquetes se publican
bajo una licencia que permite explícitamente a otras personas usarlo.
La mayoría del código en NPM tiene esta licencia. Algunas licencias re-
quieren que también publiques el código que construyes sobre el paquete bajo la
misma licencia. Otros son menos exigentes, simplemente requiriendo que man-
tengas la licencia con el código al distribuirlo. La comunidad de JavaScript
mayormente utiliza este último tipo de licencia. Al usar paquetes de otras
personas, asegúrate de estar al tanto de su licencia.
Ahora, en lugar de escribir nuestro propio analizador de archivos INI, pode-
mos usar uno de NPM.
import {parse} from "ini";
console.log(parse("x = 10\ny = 20"));
// → {x: "10", y: "20"}
Módulos CommonJS
Antes de 2015, cuando el lenguaje de JavaScript no tenía un sistema de módu-
los integrado real, las personas ya estaban construyendo sistemas grandes en
JavaScript. Para que funcionara, ellos necesitaban módulos.
La comunidad diseñó sus propios sistemas de módulos improvisados sobre el
lenguaje. Estos utilizan funciones para crear un alcance local para los módulos
y objetos regulares para representar interfaces de módulos.
Inicialmente, las personas simplemente envolvían manualmente todo su mó-
dulo en una “expresión de función invocada inmediatamente” para crear el
alcance del módulo, y asignaban sus objetos de interfaz a una única variable
global.
const semana = function() {
const nombres = ["Domingo", "Lunes", "Martes", "Miércoles",
"Jueves", "Viernes", "Sábado"];
return {
170

-- 182 of 445 --

nombre(numero) { return nombres[numero]; },
numero(nombre) { return nombres.indexOf(nombre); }
};
}();
console.log(semana.nombre(semana.numero("Domingo")));
// → Domingo
Este estilo de módulos proporciona aislamiento, hasta cierto punto, pero no
declara dependencias. En cambio, simplemente coloca su interfaz en el ámbito
global y espera que sus dependencias, si las tiene, hagan lo mismo. Esto no es
ideal.
Si implementamos nuestro propio cargador de módulos, podemos hacerlo
mejor. El enfoque más ampliamente utilizado para los módulos de JavaScript
agregados se llama Módulos CommonJS. Node.js lo utilizaba desde el princi-
pio (aunque ahora también sabe cómo cargar módulos ES) y es el sistema de
módulos utilizado por muchos paquetes en NPM.
Un módulo CommonJS se ve como un script regular, pero tiene acceso a
dos enlaces que utiliza para interactuar con otros módulos. El primero es una
función llamada require. Cuando llamas a esto con el nombre del módulo
de tu dependencia, se asegura de que el módulo esté cargado y devuelve su
interfaz. El segundo es un objeto llamado exports, que es el objeto de interfaz
para el módulo. Comienza vacío y agregas propiedades para definir los valores
exportados.
Este módulo de ejemplo CommonJS proporciona una función de formateo
de fechas. Utiliza dos packages de NPM: ordinal para convertir números en
strings como "1st" y "2nd", y date-names para obtener los nombres en inglés
de los días de la semana y los meses. Exporta una única función, formatDate,
que recibe un objeto Date y una cadena template.
La cadena de template puede contener códigos que indican el formato, como
YYYY para el año completo y Do para el día ordinal del mes. Puede pasársele una
cadena como "MMMM Do YYYY" para obtener una salida como “22 de noviembre
de 2017”.
const ordinal = require("ordinal");
const {days, months} = require("date-names");
exports.formatDate = function(date, format) {
return format.replace(/YYYY|M(MMM)?|Do?|dddd/g, tag => {
if (tag == "YYYY") return date.getFullYear();
if (tag == "M") return date.getMonth();
if (tag == "MMMM") return months[date.getMonth()];
171

-- 183 of 445 --

if (tag == "D") return date.getDate();
if (tag == "Do") return ordinal(date.getDate());
if (tag == "dddd") return days[date.getDay()];
});
};
La interfaz de ordinal es una única función, mientras que date-names exporta
un objeto que contiene múltiples cosas: days y months son arrays de nombres.
La técnica de desestructuración es muy conveniente al crear enlaces para las
interfaces importadas.
El módulo añade su función de interfaz a exports para que los módulos que
dependen de él tengan acceso a ella. Podemos usar el módulo de la siguiente
manera:
const {formatDate} = require("./format-date.js");
console.log(formatDate(new Date(2017, 9, 13),
"dddd the Do"));
// → Viernes 13º
CommonJS se implementa con un cargador de módulos que, al cargar un mó-
dulo, envuelve su código en una función (dándole su propio ámbito local) y
pasa los enlaces require y exports a esa función como argumentos.
Si asumimos que tenemos acceso a una función readFile que lee un archivo
por su nombre y nos da su contenido, podemos definir una forma simplificada
de require de la siguiente manera:
function require(name) {
if (!(name in require.cache)) {
let code = readFile(name);
let exports = require.cache[name] = {};
let wrapper = Function("require, exports", code);
wrapper(require, exports);
}
return require.cache[name];
}
require.cache = Object.create(null);
Function es una función interna de JavaScript que recibe una lista de argu-
mentos (como una cadena separada por comas) y una cadena que contiene el
cuerpo de la función, devolviendo un valor de función con esos argumentos y
ese cuerpo. Este es un concepto interesante, ya que permite que un programa
cree nuevas partes del programa a partir de datos de cadena, pero también es
peligroso, ya que si alguien logra engañar a tu programa para que introduzca
172

-- 184 of 445 --

una cadena que ellos proporcionan en Function, pueden hacer que el programa
haga cualquier cosa que quieran.
JavaScript estándar no proporciona una función como readFile, pero difer-
entes entornos de JavaScript, como el navegador y Node.js, proporcionan sus
propias formas de acceder a los archivos. El ejemplo simplemente simula que
readFile existe.
Para evitar cargar el mismo módulo múltiples veces, require mantiene una
tienda (caché) de módulos ya cargados. Cuando se llama, primero comprueba
si el módulo solicitado ha sido cargado y, si no, lo carga. Esto implica leer el
código del módulo, envolverlo en una función y llamarlo.
Al definir require, exports como parámetros para la función de envoltura
generada (y pasar los valores apropiados al llamarla), el cargador se asegura de
que estos enlaces estén disponibles en el ámbito del módulo.
Una diferencia importante entre este sistema y los módulos ES es que las
importaciones de módulos ES suceden antes de que comience a ejecutarse el
script de un módulo, mientras que require es una función normal, invocada
cuando el módulo ya está en ejecución. A diferencia de las declaraciones import
, las llamadas a require pueden aparecer dentro de funciones, y el nombre de la
dependencia puede ser cualquier expresión que se evalúe a una cadena, mientras
que import solo permite cadenas simples entre comillas.
La transición de la comunidad de JavaScript desde el estilo CommonJS a
los módulos ES ha sido lenta y algo complicada. Pero afortunadamente, ahora
estamos en un punto en el que la mayoría de los paquetes populares en NPM
proporcionan su código como módulos ES, y Node.js permite que los módulos
ES importen desde módulos CommonJS. Por lo tanto, si bien el código Com-
monJS es algo con lo que te encontrarás, ya no hay una razón real para escribir
nuevos programas en este estilo.
Compilación y empaquetado
Muchos paquetes de JavaScript no están, técnicamente, escritos en JavaScript.
Hay extensiones, como TypeScript, el dialecto de verificación de tipos men-
cionado en el Capítulo 8, que se utilizan ampliamente. A menudo, las personas
también comienzan a usar extensiones planeadas para el lenguaje mucho antes
de que se agreguen a las plataformas que realmente ejecutan JavaScript.
Para hacer esto posible, compilan su código, traduciéndolo desde su dialecto
de JavaScript elegido a JavaScript antiguo, e incluso a una versión anterior de
JavaScript, para que los navegadores puedan ejecutarlo.
Incluir un programa modular que consta de 200 archivos diferentes en una
173

-- 185 of 445 --

página web produce sus propios problemas. Si recuperar un solo archivo a
través de la red lleva 50 milisegundos, cargar todo el programa lleva 10 segun-
dos, o quizás la mitad de eso si puedes cargar varios archivos simultáneamente.
Eso es mucho tiempo desperdiciado. Como recuperar un solo archivo grande
tiende a ser más rápido que recuperar muchos archivos pequeños, los progra-
madores web han comenzado a usar herramientas que combinan sus programas
(que dividieron minuciosamente en módulos) en un solo archivo grande antes
de publicarlo en la Web. Estas herramientas se llaman bundlers.
Y podemos ir más allá. Aparte del número de archivos, el tamaño de los
archivos también determina qué tan rápido pueden ser transferidos a través de
la red. Por lo tanto, la comunidad de JavaScript ha inventado minificadores.
Estas son herramientas que toman un programa de JavaScript y lo hacen más
pequeño al eliminar automáticamente comentarios y espacios en blanco, renom-
brar enlaces y reemplazar fragmentos de código con código equivalente que
ocupa menos espacio.
Por lo tanto, no es raro que el código que encuentres en un paquete de NPM o
que se ejecute en una página web haya pasado por múltiples etapas de transfor-
mación, convirtiéndose desde JavaScript moderno a JavaScript histórico, luego
combinando los módulos en un solo archivo, y minimizando el código. No en-
traremos en detalles sobre estas herramientas en este libro ya que hay muchas
de ellas, y cuál es popular cambia regularmente. Simplemente ten en cuenta
que tales cosas existen, y búscalas cuando las necesites.
Diseño de módulos
Estructurar programas es uno de los aspectos más sutiles de la programación.
Cualquier funcionalidad no trivial puede ser organizada de diversas formas.
Un buen diseño de programa es subjetivo—hay compensaciones implicadas
y cuestiones de gusto. La mejor manera de aprender el valor de un diseño bien
estructurado es leer o trabajar en muchos programas y notar qué funciona y
qué no. No asumas que un desorden doloroso es “simplemente así”. Puedes
mejorar la estructura de casi todo pensando más detenidamente en ello.
Un aspecto del diseño de módulos es la facilidad de uso. Si estás diseñando
algo que se supone será utilizado por varias personas—o incluso por ti mismo,
dentro de tres meses cuando ya no recuerdes los detalles de lo que hiciste—es
útil que tu interfaz sea simple y predecible.
Eso puede significar seguir convenciones existentes. Un buen ejemplo es el
paquete ini. Este módulo imita el objeto estándar JSON al proporcionar fun-
ciones parse y stringify (para escribir un archivo INI), y, como JSON, convierte
174

-- 186 of 445 --

entre cadenas y objetos simples. Por lo tanto, la interfaz es pequeña y familiar,
y después de haber trabajado con ella una vez, es probable que recuerdes cómo
usarla.
Incluso si no hay una función estándar o paquete ampliamente utilizado
para imitar, puedes mantener tus módulos predecibles utilizando estructuras
de datos simples y haciendo una sola cosa enfocada. Muchos de los módulos de
análisis de archivos INI en NPM proporcionan una función que lee directamente
dicho archivo desde el disco duro y lo analiza, por ejemplo. Esto hace imposi-
ble usar dichos módulos en el navegador, donde no tenemos acceso directo al
sistema de archivos, y añade complejidad que hubiera sido mejor abordada
componiendo el módulo con alguna función de lectura de archivos.
Esto señala otro aspecto útil del diseño de módulos—la facilidad con la que
algo puede ser compuesto con otro código. Los módulos enfocados en calcular
valores son aplicables en una gama más amplia de programas que los módulos
más grandes que realizan acciones complicadas con efectos secundarios. Un
lector de archivos INI que insiste en leer el archivo desde el disco es inútil en
un escenario donde el contenido del archivo proviene de otra fuente.
Relacionado con esto, a veces los objetos con estado son útiles o incluso
necesarios, pero si algo se puede hacer con una función, utiliza una función.
Varios de los lectores de archivos INI en NPM proporcionan un estilo de interfaz
que requiere que primero crees un objeto, luego cargues el archivo en tu objeto,
y finalmente uses métodos especializados para acceder a los resultados. Este
tipo de enfoque es común en la tradición orientada a objetos, y es terrible. En
lugar de hacer una sola llamada a función y continuar, debes realizar el ritual de
mover tu objeto a través de sus diversos estados. Y debido a que los datos están
envueltos en un tipo de objeto especializado, todo el código que interactúa con
él debe conocer ese tipo, creando interdependencias innecesarias.
A menudo, no se puede evitar definir nuevas estructuras de datos, ya que
el estándar del lenguaje proporciona solo algunas básicas, y muchos tipos de
datos deben ser más complejos que un array o un mapa. Pero cuando un array
es suficiente, utiliza un array.
Un ejemplo de una estructura de datos ligeramente más compleja es el grafo
de Capítulo 7. No hay una forma única obvia de representar un grafo en
JavaScript. En ese capítulo, utilizamos un objeto cuyas propiedades contienen
arrays de strings: los otros nodos alcanzables desde ese nodo.
Existen varios paquetes de búsqueda de rutas en NPM, pero ninguno de ellos
utiliza este formato de grafo. Por lo general, permiten que las aristas del grafo
tengan un peso, que es el costo o la distancia asociada a ellas. Eso no es posible
en nuestra representación.
Por ejemplo, está el paquete dijkstrajs. Un enfoque conocido para la
175

-- 187 of 445 --

búsqueda de rutas, bastante similar a nuestra función findRoute, se llama al-
goritmo de Dijkstra, en honor a Edsger Dijkstra, quien lo escribió por primera
vez. A menudo se agrega el sufijo js a los nombres de los paquetes para indicar
que están escritos en JavaScript. Este paquete dijkstrajs utiliza un formato
de grafo similar al nuestro, pero en lugar de arrays, utiliza objetos cuyos valores
de propiedad son números, los pesos de las aristas.
Por lo tanto, si quisiéramos usar ese paquete, deberíamos asegurarnos de
que nuestro grafo esté almacenado en el formato que espera. Todas las aristas
tienen el mismo peso, ya que nuestro modelo simplificado trata cada camino
como teniendo el mismo coste (una vuelta).
const {find_path} = require("dijkstrajs");
let graph = {};
for (let node of Object.keys(roadGraph)) {
let edges = graph[node] = {};
for (let dest of roadGraph[node]) {
edges[dest] = 1;
}
}
console.log(find_path(graph, "Oficina de Correos", "Cabaña"));
// → ["Oficina de Correos", "Casa de Alicia", "Cabaña"]
Esto puede ser una barrera para la composición: cuando varios paquetes es-
tán utilizando diferentes estructuras de datos para describir cosas similares,
combinarlos es difícil. Por lo tanto, si deseas diseñar para la composabilidad,
averigua qué estructuras de datos están utilizando otras personas y, cuando sea
posible, sigue su ejemplo.
Diseñar una estructura de módulo adecuada para un programa puede ser difí-
cil. En la fase en la que aún estás explorando el problema, probando diferentes
cosas para ver qué funciona, es posible que no quieras preocuparte demasiado
por esto, ya que mantener todo organizado puede ser una gran distracción.
Una vez que tengas algo que se sienta sólido, es un buen momento para dar un
paso atrás y organizarlo.
Resumen
Los módulos proporcionan estructura a programas más grandes al separar el
código en piezas con interfaces claras y dependencias. La interfaz es la parte
del módulo que es visible para otros módulos, y las dependencias son los otros
módulos que se utilizan.
176

-- 188 of 445 --

Dado que JavaScript históricamente no proporcionaba un sistema de módu-
los, se construyó el sistema CommonJS sobre él. Luego, en algún momento
obtuvo un sistema incorporado, que ahora coexiste incómodamente con el sis-