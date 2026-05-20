# 2. Ecmascript

Actualmente hay muchas plataformas que interpretan JavaScript, como los
navegadores web o NodeJS y son utilizadas para el desarrollo de aplicaciones de
diferentes sistemas operativos. Es el estándar ECMAScript el que marca cómo
tiene que ser interpretado el lenguaje en cada una de estas tecnologías.
ECMA es el nombre de la asociación europea de fabricantes de ordenadores
(European Computer Manufacturer Association), una organización sin ánimo
de lucro que se encarga, entre otras cosas, de regular el funcionamiento de
muchos estándares de la industria mundial. Uno de estos es el estándar EC-
MA-262, que también se conoce como ECMAScript.
JavaScript es una de las implementaciones del estándar ECMA-262, en concre-
to la que se usa en los navegadores. Es decir, ECMAScript es el estándar que
define cómo tiene que funcionar el lenguaje, y JavaScript es una implementa-
ción concreta de lo que indica la especificación estándar.
Hay otras implementaciones con sus propias extensiones, como por ejemplo
ActionScript, el lenguaje que se usaba para programar Flash, o JScript, la im-
plementación de Microsoft de ECMAScript disponible a través de Internet Ex-
plorer.
2.1. Historia de la ECMAScript
La primera versión de ECMAScript apareció en 1997 con la intención de es-
tandarizar el lenguaje, de forma que los fabricantes de navegadores no se de-
dicaran a modificar a su gusto creando versiones incompatibles.
Un año después, en junio de 1998, apareció ECMAScript 2, que realmente no
incluía nada nuevo sino que era un cambio de formato en la especificación
para alinearla con el estándar internacional ISO/IEC 16262.
En diciembre de 1999 se lanzó ECMAScript 3, que añadió soporte para expre-
siones regulares, gestión estructurada de excepciones, definición más estricta
de errores y otras mejoras.
La versión 4 de ECMAScript no llegó nunca a ver la luz a consecuencia de las
luchas internas sobre la complejidad del lenguaje. Se querían añadir demasia-
das cosas que hacían que el lenguaje perdiera parte de su propósito inicial.
Muchas de las propuestas fueron desestimadas y desaparecieron por siempre,
mientras que otras vieron la luz en la siguiente versión o incluso se pospusie-
ron hasta las versiones más recientes.

-- 6 of 48 --

CC-BY-NC-ND • PID_00254185 7 JavaScript
Así que no fue hasta diciembre del 2009, una década después de la versión
anterior, cuando se presentó la siguiente versión del lenguaje: ECMAScript 5.
Esta es en realidad la cuarta versión real del lenguaje, por lo cual, oficialmente
se tendría que llamar ECMAScript 4, pero no es así y en algunos casos genera
confusión.
Esta edición añadió la manera estricta del lenguaje («strict mode»), mejoró la
especificación aclarando varias ambigüedades de la tercera edición y que cau-
saban confusión e implementaciones incoherentes, añadió el soporte nativo
para JSON, o los getters y setters para propiedades, entre otras pequeñas cosas.
A esta versión se la conoce también como Harmony, que es el nombre en clave
que se le daba mientras estaba en desarrollo.
En junio del 2011 salió la revisión 5.1, que simplemente alineaba el estándar
de ECMA con el formato correspondiente de ISO: ISO / IEC 16262: 2011 pero
que no tenía mejoras relevantes.
La sexta edición se lanzó en junio del 2015 con el nombre oficial de ECMAS-
cript 2015. Esta añadía muchas novedades al lenguaje, algunas de las cuales
ya se habían planteado para la fallida versión 4. Lleva el lenguaje a un nivel
superior, con cambios significativos en la sintaxis para escribir aplicaciones
complejas, y también conceptos nuevos, como los símbolos o las lambdas,
funciones de flecha, tipo de datos que no existían, estructuras mejoradas por
iteración, promesas, etc.
La versión ES5 permaneció durante tanto de tiempo que se convirtió en la más
extendida de JavaScript en todo tipo de plataformas. Su alto índice de com-
patibilidad la convierte en candidata ideal para ser empleada en la escritura
de código apto para todo tipo de sistemas o navegadores. De todos modos,
actualmente ya son muchos los sistemas capaces de interpretar la versión del
2015 (ES6).
La 7.ª edición, oficialmente conocida como ECMAScript 2016, finalizó en ju-
nio del 2016. Resultó ser una versión bastante descafeinada comparada con la
anterior, puesto que no incluye grandes mejoras: se introduce el operador de
exponenciación (**) y un método nuevo para las matrices que permite com-
probar si hay ciertos elementos dentro de estas.
A día de hoy la última versión publicada es la octava, ECMAScript 2017, que
finalizó en junio del 2017 con la esperada implementación await/async.

-- 7 of 48 --

CC-BY-NC-ND • PID_00254185 8 JavaScript
2.2. ECMAScript 6
A pesar de que ya se han publicado las versiones 7 y 8 del estándar ECMAS-
cript, la versión 6 supuso un gran cambio en el lenguaje al introducir muchas
mejoras (las posteriores han sido poco significativas en comparación, y toda-
vía no son populares en la comunidad). Por este motivo nos centraremos en
los cambios y novedades implementados en ECMAScript 6.
2.2.1. Variables let y const
Anteriormente, la declaración de una variable se hacía con la palabra clave var
seguida del nombre de la variable, a declarar de este modo:
var variable = "valor";
Esta variable podía ser de ámbito global o local. El ámbito depende del lugar
donde se declara: para hacer una variable global lo teníamos que declarar sim-
plemente fuera del cuerpo de una función, y las variables locales eran decla-
radas dentro de una función y solo eran accesibles dentro del código de esta.
A continuación veremos un ejemplo de un código en ES5, en el que una va-
riable está definida dentro de un bloque if, pero aun así su ámbito será el de
la función:
// ES5
function () {
var variable;
console.log(variable);
if (true) {
variable = "Hola mundo";
}
console.log(variable);
};
Si lo ponemos en ejecución, el resultado que obtendremos en consola es el
siguiente:
undefined
Hola mundo
Este resultado se debe a que en la primera la variable ya existe (se declara
previamente) pero no tiene ningún valor definido, y en la segunda ya tiene
el valor «Hola mundo». En este caso lo que sería de esperar es que la variable
quedara limitada al ámbito donde se ha declarado, que es en el interior de las
llaves del if, pero se extiende al ámbito de toda la función.

-- 8 of 48 --

CC-BY-NC-ND • PID_00254185 9 JavaScript
Ahora, con ES6 podemos declarar variables con let en lugar de var si no que-
remos que sean accesibles más allá de un ámbito, que será cualquier ámbito
expresado por unas llaves. Así, si reescribimos el ejemplo anterior:
// ES6
function () {
console.log(variable);
if (true) {
let variable = "Hola mundo";
}
console.log(variable);
};
Y la salida de la consola sería en este caso:
undefined
undefined
Ahora la segunda llamada devuelve un valor indefinido porque la variable no
existe dentro del ámbito fuera del if.
Como las variables let solo existen dentro del bloque que las contienen, no
contaminarán nunca el código a su alrededor. Esto nos evita estar pendientes
de sobrescribir variables, porque podemos tener un buen número. Este ejem-
plo es de un if, pero es lo mismo con cualquier bucle, sea un while, for, etc.
Otra nueva forma de crear variables es const. Esto nos crea una variable cons-
tante con un valor inalterable a lo largo del código: solo se puede leer, no
modificar. Por ejemplo, en un script para contabilidad sería una buena idea
poner por ejemplo el IVA como constante, puesto que siempre tendría que ser
el mismo.
Por convención se acostumbra a definir en mayúscula los nombres de
las constantes en la mayoría de lenguajes de programación para una
mejor identificación.
Veamos los siguientes ejemplos:
const IVA = 21;
console.log(IVA);
IVA = 25;
console.log(IVA);

-- 9 of 48 --

CC-BY-NC-ND • PID_00254185 10 JavaScript
El primer console.log nos imprimirá 21, que es su valor asignado en la decla-
ración, pero el segundo nos dará un error y nos dirá que su valor continúa
siendo 21. El lenguaje no nos permite modificar el valor de una constante.
const IVA;
IVA = 21;
console.log(IVA);
En este caso hemos declarado IVA y en la siguiente línea le hemos asignado
un valor. Quizás parece correcto, pero en realidad no podemos asignarle nin-
gún valor posteriormente a su definición. En realidad, la constante se ha crea-
do con el valor «undefined» y se quedará con este valor para siempre. Es un
aspecto que se debe tener muy en cuenta y que puede inducir a error muy
fácilmente.
Otra particularidad de const está en su uso con objetos. Como es de esperar,
se crea un objeto cuyo valor será inalterable, pero quizás no de la manera que
pensamos. Por ejemplo:
const PERSONA = {
id: "01",
nombre: "Jana"
}
PERSONA.nombre = "Gina";
console.log(PERSONA.nombre);
Esto nos imprimirá «Gina» puesto que la constante es el propio objeto no sus
propiedades, fijaos en que el objeto en sí está con mayúsculas pero sus pro-
piedades no, porque no son constantes. Las propiedades del objeto se pueden
modificar, añadir o borrar según necesitemos, lo que nunca podremos cambiar
es la referencia a este objeto. Por lo tanto, no podremos hacer algo como: PE-
RSONA = 'Hola mundo'; puesto que sí estamos intentando alterar la referencia
al objeto en sí.
La introducción de let y const no significa que hayamos de dejar de utilizar
var. En la mayoría de los casos se usará let para declarar variables, dado que su
ámbito es más restringido y por lo tanto nos puede dar lugar a menos errores
debidos a la interferencia entre variables del mismo nombre. Sin embargo, la
declaración var sigue existiendo y se podrá usar cuando se trata de asignar un
ámbito de toda una función, o ámbito global.
Una posible regla sería: utilizar let por regla general a no ser que por su ámbito
restringido no nos venga bien, y entonces pasaremos a usar var.

-- 10 of 48 --

CC-BY-NC-ND • PID_00254185 11 JavaScript
2.2.2. Funciones flecha (arrow)
Como su nombre indica, son funciones definidas usando una flecha =>, pero
su comportamiento es un poco diferente a las funciones tradicionales en varios
aspectos.
Las funciones flecha tienen una sintaxis más corta que una expresión de fun-
ción convencional. Además, son anónimas, no están relacionadas con méto-
dos y no pueden ser usadas como constructores.
let nuevaFuncion = () => {
//código de la función
}
Como se ve en el ejemplo, no solo se usa la flecha, sino que los paréntesis
donde se colocarían los parámetros de la función también se mueven de lado,
colocándolos antes de la flecha. La invocación se realizaría del mismo modo
que conocemos:
nuevaFuncion();
El tratamiento de los parámetros se realiza como hasta ahora, simplemente se
colocan entre los paréntesis:
let saludar = (nombre, tratamiento) => {
alert('Hola ' + tratamiento + ' ' + nombre)
}
//invocación
saludar('Jana', 'srta.');
En caso de pasar solo un parámetro, la función se simplifica, puesto que nos
podemos ahorrar los paréntesis como en el ejemplo siguiente:
let cuadrado = numero => {
return numero * numero;
}
También nos podemos ahorrar algún carácter extra si solo tenemos una línea
de código en nuestra función. En este caso no habría que poner las llaves de
apertura y cierre de la función.
let saludar = (nombre, tratamiento) => alert('Hola ' + tratamiento + ' ' + nom-
bre).

-- 11 of 48 --

CC-BY-NC-ND • PID_00254185 12 JavaScript
Adicionalmente, en caso de tener una única línea de código y que la función
devuelva un valor, también nos podemos ahorrar la palabra return (además de
las llaves, como ya hemos visto). La función del cuadrado quedaría así:
let cuadrado = numero => numero * numero;
La nueva forma es mucho más compacta que la que teníamos anteriormente.
Lo veremos más claro comparando el último fragmento de código con la de-
claración de la función de la forma tradicional en ES5:
// ES5
var cuadrado = function(numero) {
return numero * numero;
}
Si una función no tiene que recibir ningún valor por parámetro, entonces se
dejan los paréntesis solo. Por ejemplo:
let getBienvenida = () => "Hola mundo";
Que sería lo mismo que hacer esto con ES5:
var getBienvenida = function () {
return "Hola mundo";
};
2.2.3. Clases
Ahora JavaScript tiene clases, muy parecidas a las funciones constructoras de
objetos con las que se trabajaba en el estándar anterior, pero ahora bajo el
paradigma de clases y con todo lo que esto comporta, como por ejemplo, he-
rencia.
Así pues, a partir de ahora disponemos de la palabra reservada class, que con-
vertirá la declaración de una clase en algo mucho más natural.
El método constructor es un método especial para crear e inicializar un objeto
creado con una clase. Solo puede haber un método especial con el nombre
«constructor» en una clase. Si esta contiene más de un método constructor, se
producirá un Error SyntaxError.
Al igual que en otros lenguajes de programación como Java, un cons-
tructor puede usar la palabra reservada super para llamar al constructor
de una superclase.

-- 12 of 48 --

CC-BY-NC-ND • PID_00254185 13 JavaScript
Si queremos ver un ejemplo de cómo sería la clase Persona, podemos hacer
lo siguiente:
class Persona
{
constructor(nombre)
{
this.nombre = nombre;
}
}
var p1 = new Persona("Carles");
console.log(p1.nombre);
Podemos completar la clase anterior añadiendo getters y setters, también del
mismo modo como se hace con Java, para encapsular nuestro código:
class Persona
{
constructor(nombre,apellidos)
{
this._nombre = nombre;
this._apellidos = apellidos;
}
get nombre(){
return this._nombre;
}
set nombre(nombre){
this._nombre = nombre;
}
get apellidos(){
return this._apellidos;
}
set apellidos(apellidos){
this._apellidos = apellidos;
}
}
var p1 = new Persona("Carles","Santamaria");
console.log(p1.nombre);
console.log(p1.apellidos);

-- 13 of 48 --

CC-BY-NC-ND • PID_00254185 14 JavaScript
También se pueden definir métodos estáticos para una clase con la palabra
clave static. Los métodos estáticos pueden ser llamados sin instanciar la clase.
A menudo se usan para crear funciones de utilidad para una aplicación.
Por ejemplo:
class Punto {
constructor(x, y) {
this.x = x;
this.y = y;
}
static distancia(a, b) {
const dx = a.x - b.x;
const dy = a.y - b.y;
return Math.sqrt(dx*dx + dy*dy);
}
}
const p1 = new Punto(5, 5);
const p2 = new Punto(10, 10);
console.log(Punto.distancia(p1, p2));
2.2.4. Variable this
Algunos de los errores más comunes en JavaScript ocurren por la asignación
que tiene la palabra clave this. El valor de this puede cambiar dentro de una
función dependiendo del ámbito donde es ejecutada y es muy posible afectar
por error a un objeto cuando la intención es afectar a otro.
Anteriormente había que capturar el valor porque this solo hace referencia
al contexto en el que nos encontramos. Así pues, cuando queríamos pasar
una función como callback1en la cual se tenía que usar alguna propiedad del
objeto, había que asignar this a una variable, típicamente llamada «that», «self»
o «this», o utilizar el método bind para que esta nueva función tuviera el mismo
contexto que nuestro objeto.
Las funciones flecha no tienen un valor this propio. Si la función flecha está
dentro de una función contenedora tradicional, el valor de this será igual a la
función contenedora; en caso contrario, el valor de this será undefined.
// ES5
function Persona() {
this.edad = 18;
var that = this;
(1)En programación, un callback
(«devolución de llamada») es una
función A a la que se le envía por
parámetro otra función B (el call-
back) esperando que la función A
se encargue de ejecutar la función
callback.

-- 14 of 48 --

CC-BY-NC-ND • PID_00254185 15 JavaScript
setTimeout(function() {
console.log(that.edad);
}, 5000)
}
var p = new Persona();
Con ES6 no hay que coger el valor de this dentro de la variable that porque la
función flecha del callback lo cogería correctamente, por lo tanto, el código
pasado a ES6 quedaría de la siguiente manera:
// ES6
function Persona() {
this.edad = 18;
setTimeout(() => {
console.log(this.edad);
}, 5000)
}
var p = new Persona();
2.2.5. Template strings
Las template strings, o plantillas de cadenas de texto, ayudan a producir un
código JavaScript más claro a la hora de trabajar con cadenas de caracteres.
Facilita el mantenimiento de los programas gracias a que su lectura es más
sencilla con un simple vistazo.
En JavaScript, y en cualquier lenguaje de programación en general, es normal
crear cadenas en las que tenemos que juntar el contenido de literales de cadena
con los valores tomados desde las variables. A esto lo llamamos interpolar.
var nombre = "Josep Maria";
var saludar = "Estimado/da" + nombre;
Esto es muy fácil de leer, pero a medida que en una cadena tenemos que inter-
polar el contenido de varias variables, el código empieza a ser más enrevesado.
var nombre = "Josep Maria";
var apellidos = "Puig"
var profesion = "profesor";
var localidad = "Barcelona";
var descripcion = "<strong>" + nombre + "" + apellidos + "</strong>es" + profesion + " a " +
localidad;

-- 15 of 48 --

CC-BY-NC-ND • PID_00254185 16 JavaScript
El código está bien y es del todo correcto, pero podría ser mucho más amigable
si usamos las template strings.
Para crear una template string se usa un carácter diferente como apertura y
cierre de la cadena: el del acento grave. Así, el ejemplo que hemos visto antes
quedaría de la siguiente manera:
var nombre = "Josep Maria";
var apellidos = "Puig"
var profesion = "profesor";
var localidad = "Barcelona";
var descripcion = `<strong>${nombre} ${apellidos}</strong> es ${profesion} a ${localidad}`;
Otra novedad es que, hasta ahora, si queremos hacer una cadena con un salto
de línea teníamos que usar el carácter de escape «contrabarra n» (\n), así:
//ES5
console.log("línea 1 de la cadena de texto\n\
línea 2 de la cadena de texto");
Para obtener el mismo efecto con cadenas de texto multilínea, con ES6 es
posible escribir:
//ES6
console.log(`línea 1 de la cadena de texto
línea 2 de la cadena de texto`);
2.2.6. Desestructuración (destructuring)
La desestructuración es un nuevo método ES6 para extraer datos de objetos y
matrices JavaScript utilizando una sintaxis mucho más ajustada y más clara
que la proporcionada por ES5.
La desestructuración es lo contrario a la construcción de datos: en lugar de
construir un nuevo objeto o matriz, toma los datos de un objeto o matriz
existente y los destruye para extraer solo los valores que nos interesa.
Echemos un vistazo al problema que resuelve la desestructuración de JavaS-
cript. A veces, necesitaremos variables de nivel superior como:
const persona = {
nombre: "Eduard",
apellidos: "Punset",
twitter: "epunset",
web: "eduardpunset.es",
};

-- 16 of 48 --

CC-BY-NC-ND • PID_00254185 17 JavaScript
const nombre = persona.nombre;
const apellidos = persona.apellidos;
A menudo se da el caso de que tenemos que hacer una nueva variable de una
cosa que se encuentra dentro de un objeto o dentro de una matriz. En lugar
de crear dos variables «nombre» y «apellidos» y asignar el valor de cada parte
del objeto separadamente, lo que se puede hacer ahora con ES6 es:
const { nombre, apellidos } = persona;
El código anterior va a buscar dentro del objeto «persona» una variable llama-
da «nombre» y una variable llamada «apellidos» y añade los datos a dos nue-
vas variables que estarán sujetas al bloque principal.
Supongamos por ejemplo que tenemos algunos datos profundamente anida-
dos procedentes de una API JSON:
const eduard = {
nombre: "Eduard",
apellidos: "Punset",
links: {
social: {
twitter: 'https://twitter.com/epunset',
facebook: 'https://facebook.com/eduardpunset',
},
web: {
blog: 'http://www.eduardpunset.es'
}
}
};
De este objeto queremos coger el Twitter y el Facebook. Lo podemos hacer de
la manera tradicional y larga:
const twitter = eduard.links.social.twitter;
const facebook = eduard.links.social.facebook;
O lo podemos hacer de una manera más elegante con la desestructuración:
const { twitter, facebook } = eduard.links.social;
console.log(twitter, facebook);
Fijaos en que tomamos «eduard.links.social» y no solo «eduard». Esto es im-
portante porque estamos destruyendo algunos niveles de profundidad.

-- 17 of 48 --

CC-BY-NC-ND • PID_00254185 18 JavaScript
2.2.7. Valores por defecto
Otra novedad es asignar valores por defecto a las variables que se pasan por
parámetro en las funciones. Anteriormente hacía falta comprobar si la variable
ya tenía un valor, pero con ES6 se puede asignar en el momento de crear la
función.
//ES5
function(valor) {
valor = valor || "hola";
}
//ES6
function(valor = "hola") {...};
2.2.8. Módulos
Un módulo en ES6 es un archivo que tiene código e información y que puede
ser aislado, ayudándonos a organizar y agrupar nuestro código. Todo el código
e información contenidos dentro del archivo tiene su propio alcance (scope),
es decir, no es accesible desde fuera del módulo. Para compartir el contenido
se tiene que usar la palabra export.
// archivo lib/persona.js
modulo "persona" {
export function hola(nombre) {
return nombre;
}
}
Y podemos importarlo a otro fichero con:
// archivo: app.js
importe { hello } from "persona";
var app = {
foo: function() {
hola("Jana");
}
}
export app;
Fijaos en que cuando hacemos la importación de persona solo ponemos el
nombre del archivo sin la extensión «.js».

-- 18 of 48 --

CC-BY-NC-ND • PID_00254185 19 JavaScript
2.3. Transpiladores
La palabra transpilador no la encontramos en el diccionario (de momento). Se
ha acuñado recientemente a raíz de las necesidades de traducción de diversas
versiones de ECMAScript y dialectos y lenguajes derivados. Transpilador en
realidad es una adaptación del término transpiler, que a su vez viene de trans-
lator (traductor) y compiler (compilador).
Los transpiladores son por lo tanto una especie de compiladores que transfor-
man nuestro código ES6 a ES5, para así ser totalmente compatible con todos
los navegadores.
Básicamente, los transpiladores se emplean en la fase de desarrollo del proyec-
to, donde el desarrollador escribe el código y estos posteriormente hacen su
trabajo traduciéndolo, compilándolo y adaptándolo. Este nuevo código es el
que se despliega para llevarlo a producción y se forma únicamente de código
JavaScript comprensible por todos los navegadores.
Gracias a los transpiladores, lenguajes como Flow, TypeScript y CoffeeScript
se traducen a JavaScript ES5, siendo de este modo compatibles con cualquier
plataforma.
Uno de los más conocidos y usados es Babel, una herramienta que nos permite
transformar nuestro código JavaScript de última generación (o con funciona-
lidades extras) a un JavaScript que cualquier navegador o versión de Node.js
entienda, ayudando a utilizar la última versión del estándar más reciente, e
incluso algunas funciones experimentales o que no son parte del estándar (ni
siquiera propuestas), pero que nos ayudan a trabajar más fácilmente.
Podéis consultar (y descargar) en los formatos HTML y PDF de manera
gratuita una versión del estándar de ecma-international.org:
• http://www.ecma-international.org/ecma-262/6.0/index.html
• http://www.ecma-international.org/ecma-262/6.0/ecma-262.pdf

-- 19 of 48 --

CC-BY-NC-ND • PID_00254185 20 JavaScript
3. jQuery
jQuery es una de las librerías de JavaScript más populares y usadas por su ra-
pidez, sencillez y la amplia gama de posibilidades que ofrece. Permite la ma-
nipulación de eventos, animaciones, carga dinámica de contenidos, etc., con
unas pocas líneas de código. Además funciona en los navegadores más utili-
zados, como IE, Safari, Mozilla o Chrome.
3.1. Obtener jQuery
Hay varias maneras de obtener jQuery. Podemos descargar jQuery de su web
(http://jquery.com/), donde disponemos de dos versiones diferentes (Produc-
tion, minified and gziped), versión preparada por entornos de producción, con
el código comprimido y optimizado para ocupar muy pocos Kb de descarga o
la versión de desarrollo. Solo descargaremos esta última si lo que queremos es
revisar y leer el código de la propia librería y ver cómo está hecho, puesto que
la versión de producción es completamente utilizable.
También podemos obtener jQuery mediante NPM (node package manager), un
gestor de paquetes JavaScript que instala las librerías dentro de nuestro pro-
yecto tan solo escribiendo un comando de código. jQuery es un paquete re-
gistrado en NPM, así que nos podemos instalar la última versión escribiendo
el comando:
$ npm install jquery
Esto instalará la librería dentro de la carpeta node_modules.
Por otro lado, si queremos podemos utilizarla desde un CDN (content delivery
network) de Google, la manera recomendada por la comunidad. Un CDN es
una red de distribución de contenidos a nivel global con servidores geolocali-
zados de forma óptima para mejorar los tiempos de descarga. De este modo, si
enlazamos la librería desde aquí, cuando el cliente de web intenta descargarla,
muchas veces ya se encuentra que la tiene en la memoria caché.
Sea como fuere, hará falta que enlacemos la librería en nuestro documento
HTML. Para hacerlo, utilizaremos la etiqueta estándar de HTML <script> ha-
ciendo:
<script src="jquery.js"></script>
O bien, utilizaremos la etiqueta con una dirección CDN:

-- 20 of 48 --

CC-BY-NC-ND • PID_00254185 21 JavaScript
<script src="http://ajax.googleapis.com/ajax/libs/jquery/x.x.x/jquery.min.js"></script>
Una vez hecho esto, ya podremos empezar a utilizar la librería completa para
realizar nuestras aplicaciones.
3.2. Cómo funciona jQuery: El Objeto $
Generalmente los frameworks de JavaScript envuelven a partir de un objeto
global. De este modo el espacio de memoria queda limpio y podemos imple-
mentar la librería en espacios complejos con otras muchas funciones.
jQuery, utiliza el símbolo $() como función que nos permitirá interactuar con
la librería. De hecho, el símbolo $ es un simple sinónimo de la verdadera fun-
ción window.jQuery. Así:
var jQuery = window.jQuery = window.$
A partir de esta función se envuelven todas las funcionalidades de la librería, y
esta nos sirve para realizar cualquier operación. Para compatibilizar con otras
librerías (Prototype utiliza el mismo símbolo), jQuery nos ofrece la función
jQuery.noConflict(); que desactiva el símbolo $(), dejándolo con jQuery().
3.3. Interactuando con el DOM
La finalidad de jQuery es interactuar con el DOM. La función $() nos permite
«seleccionar» referencias a elementos del DOM y a partir de aquí, empezar a
interactuar con el lenguaje de programación. No es convencional, puesto que
no sigue la estructura usual de programación de aplicaciones, pero sí que es
muy práctico, puesto que el 80 % de lo que programamos en el navegador se
hace empleando algún elemento del DOM.
Para aclarar un poco el tema, lo mejor es ver un ejemplo.
<html>
<head>
<title>Ejercicio jQuery</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/x.x.x/jquery.min.js"></script>
</head>
<body>
<p id="p1">¡Hola Mundo!</p>
< script>
$(function(){ // 1
var resultado = $('#p1').texto(); // 2
alert(resultado)
});
</script>

-- 21 of 48 --

CC-BY-NC-ND • PID_00254185 22 JavaScript
</body>
</html>
El código que aparece en 1 todavía no es relevante, pero sirve para programar
el evento «DOM disponible». Si nos fijamos en la parte de 2, con $('#p1'), selec-
cionamos el elemento con id igual a «p1». De hecho, lo que nos devuelve la
función￿$ es una instancia de la librería jQuery inicializada con el elemento p
del DOM. El método texto() nos devuelve el contenido del nodo como cadena
de texto, lo guardamos en la variable resultado y la mostramos haciendo un
alert.
3.4. Selectores, filtros y CSS
Como se puede ver en el ejemplo anterior, la función $() recibe un selector
CSS y nos devolverá la instancia del objeto. La cuestión es ver qué selectores
podemos utilizar.
En el ejemplo, el primer selector era el #, igual que con CSS, que nos permite
seleccionar elementos por ID. Del mismo modo podemos utilizar selectores
con clases CSS. Así, la llamada $('.estilo1') seleccionará todos los elementos que
tengan asociada la clase estilo1. Como vemos, utilizamos el mismo lenguaje
que ya conocemos con CSS a la hora de interactuar con el DOM.
Ambas llamadas devuelven una instancia de la librería lista para ser utilizada,
con la diferencia de que en el primer caso nos devuelve la instancia inicializada
con un solo elemento y en la segunda, con un conjunto de elementos.
Casi siempre podemos aplicar las mismas reglas de CSS a los selectores de
jQuery:
$('*') Todos los elementos
$('#nombre’) Elemento con id=nombre
$('.clase') Elementos que tengan la .clase CSS
$('img') Elementos
$('img,￿p,￿selectorN') Combina los elementos img, p, selectorN
Igual que en CSS3 podemos seleccionar por atributo:
$('a[rel="nofollow"]') Todos los a con el atributo rel="nofollow"
$('[atributo|="valor"]') Atributo sea o empiece por valor
$('[attribute~="value"]') Atributo que contenga valor delimitado por espacios.
$('[atributo￿="valor"]') Que el atributo no tenga el siguiente valor
$('[atributo^="valor"]') Que el valor del atributo empiece por valor

-- 22 of 48 --

CC-BY-NC-ND • PID_00254185 23 JavaScript
$('[atributo$="valor"]') Que el valor del atributo acabe con valor
$('[atributo]') Que el elemento contenga el atributo
$('[atributo1="1"][atributo2="2]') Que contengan todos los atributos con valores
Y como CSS3, también disponemos de filtros basados en la posición que ocu-
pan los elementos:
$('tr:first-child') La primera fila de una tabla. También podemos emplear :last-child,
y :nth-child(4n)
$("tr:even") Fila impar. También se puede llamar a las pares con odd
$('tr:eq(3)') El tercer elemento del conjunto seleccionado. En este caso, la terce-
ra fila del conjunto de todas las tablas de la página. También pode-
mos emplear
• gt(n) conjunto mayor que n
• lt(n) conjunto menor que n
• not(n) todos, excepto n
$('tr:first') El primer elemento. También podemos con el último con :last
También podemos filtrar elementos en función del contenido que tienen, así:
$("div:contains('Libro')") Seleccionará los elementos div que en su contenido aparezca
la palabra Libro
$("div:has(p)") Elementos div que contenga otro elemento p
$("td:pariente") Elementos que son padres de otro nodo, incluido nodos de
texto
Finalmente, para completar el apartado de selectores, hay que ver una nueva
funcionalidad y detallar una diferencia en los objetos que nos devuelve.
Cuando seleccionamos múltiples objetos, como por ejemplo $('img') (para se-
leccionar todas las imágenes), el objeto que nos devuelve jQuery es una ins-
tancia normal aumentada con las funciones de lista (iterable). jQuery cuenta
con una función .each que permite iterar por los diferentes elementos que he-
mos seleccionado. Así podríamos escribir el siguiente código:
$('img').each(function(index, elemento) {
console.log( elemento.src )
});
El ejemplo anterior iterará por todas las imágenes del documento. Para saber si
un selector nos ha devuelto un conjunto o solo un elemento, podemos con-
sultar la propiedad length:
$('img').length; // devolverá el total de imágenes que contiene el documento.

-- 23 of 48 --

CC-BY-NC-ND • PID_00254185 24 JavaScript
La función $() admite un segundo parámetro que permite definir el contexto
en el cual queremos que se realice la busca del selector. Por defecto, si el pará-
metro no existe, la función realiza la busca en todo el documento, pero si se
indica un parámetro, la busca se limitará a este contexto:
<div><p>Content</p></div>
<div id="p1">
<p>Content 2</p>
< /div>
$('p', $('#p1'));
La selección anterior devolverá solo el segundo p, puesto que es el único que
encontramos dentro del contexto de #p1.
3.5. Manipulando el DOM
Ahora que ya sabemos seleccionar elementos de un documento, podemos ir
un paso más allá y empezar a manipularlos. Podemos cambiar las propieda-
des CSS, leer y modificar sus atributos, copiarlos, eliminarlos y añadir otros
nuevos.
3.5.1. Propiedades CSS
Seleccionado un conjunto de elementos, podemos manipular sus propiedades
CSS con el método .css de la siguiente manera:
$('p').css('color', 'red');
Cambiará el color del texto de todos los párrafos a rojo. Pero también se pue-
den cambiar muchas propiedades a la vez:
$('p').css({ 'color': 'grey',
'padding': '5px',
'background-color': 'yellow' });
La mayoría de los métodos del objeto jQuery que pueden admitir un par de
parámetros también pueden admitir un objeto y así hacer mucho más trabajo
de una sola vez.
De la misma manera que los podemos cambiar, también los podemos consul-
tar, preguntando la propiedad. El siguiente código nos devolverá el color del
elemento p:
$('p').css('color')

-- 24 of 48 --

CC-BY-NC-ND • PID_00254185 25 JavaScript
Hay que decir que existen algunos métodos en modo de acceso directo, como
por ejemplo:
.show() Nos mostrará el elemento si estaba escondido
.hide() Esconde un elemento
.toggle() Actúa a modo de interruptor. Si el elemento está escondido, lo muestra y
si el elemento es visible, lo esconde
También podemos añadir una nueva clase CSS a un elemento seleccionado,
con el comando:
$('#id').addClass('nombredelaclase')
o podemos consultar si tiene asignada la clase:
$('#id').hasClass('nombredelaclase')
o bien, la podemos eliminar:
$('#id').removeClass('nombredelaclase')
También podemos manipular y consultar la altura y anchura de un elemento
mediante los métodos .height() y .width(), que sirven tanto para asignar una
altura y anchura, como para consultar la altura y anchura reales.
3.5.2. Atributos de los nodos
Del mismo modo que podemos consultar o modificar propiedades CSS, jQuery
nos facilita una fórmula para interactuar con los atributos de cada nodo.
<img width="34" />
$('img').attr('width', '44')
Como con el método anterior, admite un objeto como parámetro. En su de-
fecto, si solo le enviamos un parámetro que es una propiedad, pues nos devol-
verá el valor de esta.
3.5.3. Añadir contenido al DOM
Para insertar contenido dentro del DOM disponemos de tres fórmulas básicas
en relación con la selección correspondiente:
1)￿Añadir￿envolviendo

-- 25 of 48 --

CC-BY-NC-ND • PID_00254185 26 JavaScript
Cuando hacemos un .wrap de un selector lo que se hace es envolverlo con la
etiqueta inserta:
<p id="uno">Una prueba</p>
$('.inner').wrap('<div class="new" />');
<div class="new">
<p id="uno">Una prueba</p>
< /div>
Del mismo modo podemos hacer un .unwrap(), que tiene el efecto contrario. Y
también .wrapAll, que envolverá todo el conjunto de selectores en un solo div.
2)￿Añadir￿dentro
Nos añadirá el contenido pasado como parámetro en diferentes posiciones del
selector, en función del método que usemos:
.append('contento') Añade el contenido al final del selector
.prepend() Añade el contenido al principio del selector
.html() Recupera el contenido de un selector o se lo asigna. Siempre conte-
nido html
.texto() Recupera el texto de un selector, sin etiquetas. También lo asigna
3)￿Añadir￿fuera
$().after(),$().before() inserta los elementos seleccionados justo en el nodo antes
o después del seleccionado. Si la selección nos devuelve diferentes nodos, hará
la operación para cada uno de ellos.
3.5.4. Borrar nodos
Dado cualquier selector lo podemos borrar simplemente ejecutando el méto-
do .remove(). También podemos utilizar el método .empty(), que lo que hace
es vaciar el contenido de un nodo, incluido texto plano.
3.6. Funciones generales
Como librería o marco de trabajo, jQuery nos ofrece una serie de extensiones,
métodos o funciones, que nos permiten añadir pequeñas utilidades y funcio-
nalidades al JavaScript:
$.each(￿collection,￿callback(indexInArray,￿valueOfElement)￿)
Es una función que nos permite programar iteraciones, supongamos:

-- 26 of 48 --

CC-BY-NC-ND • PID_00254185 27 JavaScript
a = [1,2,3,4,5]
resultado = 0
$.each(a, function(index, valor) { resultado += a }
alert('el resultado es' + a)
A collection le podemos pasar cualquier elemento que sea iterable en JavaS-
cript, como por ejemplo un array o el resultado de un selector. De hecho, un
patrón común cuando queremos hacer cosas con un conjunto sería:
$('.item').each(function(ind) {
$(ind).text()
})
En el ejemplo anterior iteraríamos por la colección de nodos que tienen asig-
nado el estilo item. En este patrón es muy interesante saber que $(ind) es el
nodo actual.
También podríamos iterar sobre las propiedades de un objeto o hash:
$('.item').each(function(ind) {
$(ind).text()
})
$.extend({},￿objeto1,￿objeto2)
El método extend nos permite añadir propiedades a un objeto definido pre-
viamente:
a = {uno: 'hola', dos:'dos' }
b = {uno:'si', tres:'quepasa'}
$.extend(a, b)
a == {uno:'si', tres:'quepasa', dos:'dos'}
Es de gran utilidad para escribir código modular, puesto que nos permite am-
pliar objetos, con propiedades y métodos de otros, de una forma muy fácil.
Una aplicación práctica es la creación de mixins, objetos que amplían la fun-
cionalidad de otros. Como por ejemplo:
var a = {
'hola': function() { return 1; },
'adios': function() { return 2; } }
var mixin = { 'hola': function() { return 2; } }
$.extend(a, mixin)
console.info( a.hola() == 2 )
console.info( a.adios() == 2 )

-- 27 of 48 --

CC-BY-NC-ND • PID_00254185 28 JavaScript
Si nos fijamos en el ejemplo, disponemos de un objeto A que tiene una función
hola y que devuelve 1. Pero después le aplicamos el objeto mixin con el método
$.extend, sobrescribiendo la función a.
Al final del ejemplo podemos ver cómo a.hola() ya no devuelve 1, sino que
devuelve 2 porque ha sido sobrescrita (extendida).
Si revisamos el código fuente de jQuery veremos que la mayoría de los métodos
nuevos los instalan de este modo. También lo podemos hacer extendiendo la
cadena de prototipaje:
$.extend(a.prototype, mixin)
La línea anterior nos generaría métodos públicos del objeto A. Mientras que
el A del ejemplo simplemente es un paquete de funciones (namespace).
$.inArray(valor,￿array)
Busca valor en lista. Si no lo encuentra, devuelve -1. Si lo encuentra, devuelve
la posición >0.
$.isArray(p)
Devuelve true si p es un array.
$.merge(a,￿b)
Fusiona el contenido de a y b devolviendo un nuevo array con la combinación
de ambos.
Podéis encontrar muchas más utilidades en la dirección: http://
api.jquery.com/category/utilities/.
3.7. Sistema de eventos (events)
La gestión de los eventos es el otro gran pilar de las librerías de JavaScript y
es tan importante como poder manipular fácilmente el DOM desde nuestros
programas. Aquellos que han querido hacer frente a esta tarea sin utilizar nin-
gún framework ya sabrán que la cosa no es trivial, dado que cada navegador
nos ofrece un sistema de eventos diferente.
La forma genérica como se escucha un event en jQuery es mediante el coman-
do .on. Así, para poder capturar los clics en todos los enlaces, podemos escribir:
$('a').on('click', function() {
contador += 1

-- 28 of 48 --

CC-BY-NC-ND • PID_00254185 29 JavaScript
})
Siempre sigue el mismo patrón: seleccionamos el nodo al cual queremos asig-
nar el event y con el comando on, le podemos asignar el event que deseamos.
Por ejemplo, para asignar un eventchange a un campo desplegable (select) es-
cribiríamos:
$('#idselect').on('change', manipulador)
Donde manipulador puede ser una función anónima como en el caso anterior,
o puede ser el nombre de una función (la variable que contiene el objeto fun-
ción).
A la función on le podemos asignar un objeto que contenga una lista de even-
tos mapeados, como por ejemplo:
$('a').on({
'mousenter': function(evt) {
$(this).css('color', 'black')
},
'click': function(evt) {
$(this).toggle();
}
});
Es importante ver cómo en la función manipuladora del event la variable this
apunta al nodo del DOM que la desencadena y que el comando $(this) selec-
ciona el propio nodo.
La función recibe un parámetro que contiene un objeto de tipo event. Este
parámetro a menudo es omitido, pero con él podemos acceder a información
adicional en el momento de generación del evento y durante su propagación.
Con jQuery el sistema de eventos sigue una regla de propagación en burbuja
(bubbling) por la cual, cuando un evento es generado en un nodo, se propaga
hacia sus padres. Imaginemos el siguiente ejemplo:
<script>
$(function(){
$('tr').click(function(){
alert('clic a tr');})
.height(30)
.css( 'background-color', '#eaeaea');
$('a').click(function(e){
alert('clic a a');
e.stopPropagation()
});
});

-- 29 of 48 --

CC-BY-NC-ND • PID_00254185 30 JavaScript
</script>
</head>
<body>
<table>
<tr>
<td><a>Hola</a></td>
</tr>
</table>
Si hiciéramos clic en el enlace a, lo capturaríamos desde la función del evento,
pero como el event seguiría su proceso de propagación, también ejecutaría
el manipulador asignado al nodo padre tr y generaría un doble alert(): el del
elemento a y el del elemento tr. O sea, que se ejecutarían ambos eventos. Para
impedir esto y romper la cadena de propagación, utilizamos el objeto event
que recibe el manipulador y llamaríamos al método .stopPropagation() tal y
como se ha hecho en el ejemplo.
En el objeto event también podemos encontrar otros datos, como las propie-
dades pageX y pageY, que son las coordenadas de ratón, donde se ha desen-
cadenado el event. También dentro de este objeto encontramos propiedades
como target, que es el objeto que genera el evento, o bien currentTarget, que
es el objeto desde donde se ha iniciado la propagación.
Del mismo modo que asignamos un event con el método on, lo podemos
desasignar con el método .off. Así, haciendo:
$('tr').off('click');
Los eventos pueden ser ejecutados de forma manual empleando el comando
.trigger('nomevent'), así si hacemos:
$('tr').trigger('click');
Se ejecutará el manipulador (handler) asignado al tal event. (Siempre y cuan-
do se haya asignado a priori). Y del mismo modo, podemos generar nuestros
propios events.
Imaginemos que tenemos un reloj y queremos que nos notifique el tiempo
cada segundo. Podemos generar un event de tipo 'segundo' (el nombre lo ele-
gimos nosotros) desde la función que controla el tiempo que pasa, como en
el ejemplo siguiente:
var segundos = 0
setInterval(function(){
$('#p1').text( ++segundos )
.trigger('segundo', [segundos])

-- 30 of 48 --

CC-BY-NC-ND • PID_00254185 31 JavaScript
}, 1000)
$('#p1').on('segundo', function(event, data){
if(data==10) segundos = 0
})
Utilizamos el elemento #p1 para que nos genere un event de segundo, después
lo capturamos y hacemos que la variable que cuenta los segundos que pasan
se inicialice cuando llega a 10. Para que esto funcione, necesitamos tener un
nodo con id #p1 en nuestro html.
3.7.1. Tabla de eventos
blur Cuando en un campo de formulario perdemos el foco del teclado
focus Cuando un elemento de un formulario recibe un clic del ratón
resize La ventana cambia de tamaño, pertenece al window
scroll Estamos haciendo scroll en la ventana o en un elemento div
click Hacemos clic sobre un nodo
dblclick Hacemos doble clic sobre un nodo
mouseover Pasamos el ratón por encima del elemento
mouseout El ratón sale del elemento
change El valor de un campo de formulario cambia
submit Un formulario es enviado hacia el servidor
keydown,￿keyup Pulsamos una tecla del teclado. La tecla que se ha pulsado la podemos
encontrar en la propiedad which, del objeto event pasado al manipula-
dor
error Se desencadena, por ejemplo, cuando desde el servidor una imagen no
se carga
Existen accesos directos a la mayoría de las propiedades que podemos utilizar
con un on, con su nombre de función directamente. Así, podemos llamar a los
métodos de un selector .click, .change, .error,...
Encontraréis la lista completa de eventos en la documentación oficial de
jQuery.

-- 31 of 48 --

CC-BY-NC-ND • PID_00254185 32 JavaScript
3.8. Formularios
Otra de las tareas clave en la programación de aplicaciones web para el JavaS-
cript es la manipulación, construcción y, sobre todo, validación de formula-
rios. jQuery nos ofrece toda una serie de métodos especialmente diseñados
para consultar y validar formularios. Podemos acceder al valor de cualquier
campo de formulario a partir de su selector, haciendo:
$('#id').val()
El mismo método nos sirve para asignar un valor, enviándole como parámetro
el valor a asignar.
También podemos capturar el momento de enviar el formulario y programar
un método que decida si se puede enviar o no en función del contenido de
los campos, utilizando el evento submit. Así, podemos hacer:
$('formulario#un').on('submit', function(){
// si validación correcta
return true;
// si hay errores en la validación
// los podemos mostrar y se tiene que devolver false
return false;
}
Existen también métodos para trabajar con AJAX, que nos permiten serializar
de una vez todo el contenido del formulario, haciendo: $('form').serialize(), que
nos generará el formulario preparado para ser enviado por GET. De lo contrario
y según nos interese, podemos utilizar .serializeArray() y nos permitirá obtener
el formulario dentro una lista.
3.9. AJAX
Asyncronimous JavaScript and xml consiste en una técnica mediante la cual po-
demos hacer llamadas al servidor sin recargar el contenido de nuestra página,
es decir, podemos enviar y recibir datos desde el servidor de forma interactiva
desde JavaScript. Cada navegador implementa AJAX de una forma diferente,
pero por suerte, jQuery nos facilita una interfaz unificada.
Para hacer una petición contra el servidor, disponemos de la función .ajax de
tipo genérico y que admite muchos parámetros diferentes, o dos alternativas
mucho más directas que nos permiten solicitar documentos con GET o POST.
$.get( url, [ data ], success(data))
url: Será la dirección a solicitar al servidor.

-- 32 of 48 --

CC-BY-NC-ND • PID_00254185 33 JavaScript
data: Es un objeto JavaScript con los parámetros que le queramos enviar al
servidor.
success: Es un manipulador que se ejecutará con la respuesta que el servidor
nos envía.
Así, un ejemplo sencillo, donde lo que hacemos será cargar un documento
extra desde el servidor, puede quedar así:
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Ejercicio de carga de ajax</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<script>
$(function(){
$('#bt').click(function(){ // 1
$.get('archivo.txt', {hola:3, mundo:4}, function(data){ // 2
$('#desti').html(data); // 3
});
})
});
</script>
<style>
#desti { color:blue; }
</style>
</head>
<body>
<p>Al apretar el botón, cargaremos dentro del párrafo azul, el contenido del archivo txt,
del servidor.</p>
< input type="button" id="bt" value="Carga" />
<p id="desti">Aquí cargaremos un contenido de con AJAX desde el servidor</p>
< /body>
</html>
En el ejemplo, programamos (1) en el evento clic del botón, #bt que lance
una petición AJAX, por método GET (2) $.get, descargando el archivo.txt
y enviándole dos parámetros (hola y mundo). Como la petición es asincrónica
(no sabemos cuándo nos responderá el servidor), le enviamos una función
para que lo ejecute en este momento (2). La función tiene un parámetro data,
que es el contenido de la petición, y que finalmente en (3) lo colocamos en
el nodo #desti.
Podemos ver el ejemplo funcionando en:
http://multimedia.uoc.edu/~jcollell/ejercicio_ajax.html

-- 33 of 48 --

CC-BY-NC-ND • PID_00254185 34 JavaScript
También podemos hacer peticiones al servidor a través de POST con la función
$.post y los mismos parámetros.
Podemos consultar en línea la documentación porque las tres funciones nos
ofrecen multitud de opciones más para simplificar el trabajo.
3.10. Componentes (widgets)
jQuery internamente no ofrece ningún sistema de componentes, pero sí
que existe un proyecto paralelo que ofrece determinados widgets. El proyec-
to se denomina jQueryUI (User Interface) y lo podemos revisar en http://
jqueryui.com/. A pesar de estar muy ligado a jQuery, funciona de manera in-
dependiente con su propio calendario de versiones.
Fundamentalmente ofrecen componentes visuales, componentes interactivos,
efectos y utilidades. En cuanto a componentes visuales, tienen un pequeño
widget de calendario, un campo de autocompletado (mientras escribes filtra
resultados de una lista), unas pestañas, acordeones, barras de progreso, entre
otros.
Aparte de los componentes visuales, jQueryUI también ofrece una serie de
componentes funcionales, como por ejemplo los draggables y sortables. Los
primeros permiten programar objetos arrastrables por la pantalla y los segun-
dos, crear objetos ordenables con drag&drop.
jQueryUI supuso una revolución para la interactividad de las páginas web hace
unos años, a pesar de que actualmente ha quedado un poco en segundo plano
desplazado por librerías tan completas como Bootstrap, que cuenta con mu-
chos de los widgets existentes en jQueryUI, con una estética y una experiencia
mejorada. Pero los elementos de interacción como draggable y sortable siguen
siendo de gran valor.
3.11. Patrones de uso
Un framework o librería, además de una serie de instrucciones, objetos y mé-
todos para facilitarnos la vida a la hora de trabajar, también implica ciertos
patrones de trabajo a modo de convenciones que harán que la ejecución de
aplicaciones sea más robusta y más convencional para la mayoría de los pro-
gramadores que lo utilicen.
$(documento).ready(function() {
// código de programación
})

-- 34 of 48 --

CC-BY-NC-ND • PID_00254185 35 JavaScript
Este primer patrón emplea el evento ready, un evento especial que nos notifica
que el DOM del documento HTML ya está listo para ser empleado, es decir, que
podemos emplear de forma segura cualquiera de los elementos del documento
desde nuestro programa. Como en las últimas versiones ha quedado obsoleto,
actualmente habría que escribirlo de este modo, con el mismo significado:
$(function() {
// código de programación
})
El evento estándar para hacer esto en JavaScript es el body.onload. Con la técni-
ca de jQuery, el evento se ejecuta sin haber descargado las imágenes asociadas
con el DOM, mientras que con el método convencional se tiene que esperar al
resto, así que es algo menos eficiente. Aparte se pueden crear llamadas ilimi-
tadas documento.ready en todo el documento, mientras que de window.onload
solo podía haber una.
Otro patrón de uso muy interesante es la capacidad de jQuery de encadenar
métodos. A nivel funcional no supone mucho, pero sí en cuanto a legibilidad.
Sobre un mismo selector podemos ir aplicando diferentes métodos, de forma
que resulta habitual encontrar construcciones como esta:
$('#lelemtn')
.css('color', 'black')
.on('click', alferclic)
.on('mouseover', rollover)

-- 35 of 48 --

CC-BY-NC-ND • PID_00254185 36 JavaScript