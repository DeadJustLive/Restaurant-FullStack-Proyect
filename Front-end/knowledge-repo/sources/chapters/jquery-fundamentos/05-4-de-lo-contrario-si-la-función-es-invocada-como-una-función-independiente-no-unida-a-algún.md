# 4. De lo contrario, si la función es invocada como una función independiente, no unida a algún

objeto, this referenciará al objeto global.
Una función invocada utilizando Function.call
var myObject = {
sayHello : function() {
20

-- 21 of 107 --

console.log('Hola, mi nombre es ' + this.myName);
},
myName : 'Rebecca'
};
var secondObject = {
myName : 'Colin'
};
myObject.sayHello(); // registra 'Hola, mi nombre es Rebecca'
myObject.sayHello.call(secondObject); // registra 'Hola, mi nombre es Colin'
Una función creada utilizando Function.bind
var myName = 'el objeto global',
sayHello = function () {
console.log('Hola, mi nombre es ' + this.myName);
},
myObject = {
myName : 'Rebecca'
};
var myObjectHello = sayHello.bind(myObject);
sayHello(); // registra 'Hola, mi nombre es el objeto global'
myObjectHello(); // registra 'Hola, mi nombre es Rebecca'
Una función vinculada a un objeto
var myName = 'el objeto global',
sayHello = function() {
console.log('Hola, mi nombre es ' + this.myName);
},
myObject = {
myName : 'Rebecca'
},
secondObject = {
myName : 'Colin'
};
myObject.sayHello = sayHello;
secondObject.sayHello = sayHello;
sayHello(); // registra 'Hola, mi nombre es el objeto global'
myObject.sayHello(); // registra 'Hola, mi nombre es Rebecca'
secondObject.sayHello(); // registra 'Hola, mi nombre es Colin'
21

-- 22 of 107 --

Nota
En algunas oportunidades, cuando se invoca una función que se encuentra dentro de un
espacio de nombres (en inglés namespace) amplio, puede ser una tentación guardar la
referencia a la función actual en una variable más corta y accesible. Sin embargo, es
importante no realizarlo en instancias de métodos, ya que puede llevar a la ejecución de
código incorrecto. Por ejemplo:
var myNamespace = {
myObject: {
sayHello: function() {
console.log('Hola, mi nombre es ' + this.myName);
},
myName: 'Rebecca'
}
};
var hello = myNamespace.myObject.sayHello;
hello(); // registra 'Hola, mi nombre es undefined'
Para que no ocurran estos errores, es necesario hacer referencia al objeto en donde el método es
invocado:
var myNamespace = {
myObject : {
sayHello : function() {
console.log('Hola, mi nombre es ' + this.myName);
},
myName : 'Rebecca'
}
};
var obj = myNamespace.myObject;
obj.sayHello(); // registra 'Hola, mi nombre es Rebecca'
0.2.12. Alcance
El “alcance” (en inglés scope) se refiere a las variables que están disponibles en un bloque de código
en un tiempo determinado. La falta de comprensión de este concepto puede llevar a una frustrante
experiencia de depuración.
Cuando una variable es declarada dentro de una función utilizando la palabra clave var, ésta única-
mente esta disponible para el código dentro de la función — todo el código fuera de dicha función no
puede acceder a la variable. Por otro lado, las funciones definidas dentro de la función podrán acceder
a la variable declarada.
Las variables que son declaradas dentro de la función sin la palabra clave var no quedan dentro del
ámbito de la misma función — JavaScript buscará el lugar en donde la variable fue previamente
22

-- 23 of 107 --

declarada, y en caso de no haber sido declarada, es definida dentro del alcance global, lo cual puede
ocasionar consecuencias inesperadas;
Funciones tienen acceso a variables definidas dentro del mismo alcance
var foo = 'hola';
var sayHello = function() {
console.log(foo);
};
sayHello(); // muestra en la consola 'hola'
console.log(foo); // también muestra en la consola 'hola'
El código de afuera no tiene acceso a la variable definida dentro de la función
var sayHello = function() {
var foo = 'hola';
console.log(foo);
};
sayHello(); // muestra en la consola 'hola'
console.log(foo); // no muestra nada en la consola
Variables con nombres iguales pero valores diferentes pueden existir en diferentes alcan-
ces
var foo = 'mundo';
var sayHello = function() {
var foo = 'hola';
console.log(foo);
};
sayHello(); // muestra en la consola 'hola'
console.log(foo); // muestra en la consola 'mundo'
Las funciones pueden “ver” los cambios en las variables antes de que la función sea
definida
var myFunction = function() {
var foo = 'hola';
var myFn = function() {
console.log(foo);
};
foo = 'mundo';
return myFn;
};
23

-- 24 of 107 --

var f = myFunction();
f(); // registra 'mundo' -- error
Alcance
// una función anónima autoejecutable
(function() {
var baz = 1;
var bim = function() { alert(baz); };
bar = function() { alert(baz); };
})();
console.log(baz); // La consola no muestra nada, ya que baz
// esta definida dentro del alcance de la función anónima
bar(); // bar esta definido fuera de la función anónima
// ya que fue declarada sin la palabra clave var; además,
// como fue definida dentro del mismo alcance que baz,
// se puede consultar el valor de baz a pesar que
// ésta este definida dentro del alcance de la función anónima
bim(); // bim no esta definida para ser accesible fuera de la función anónima,
// por lo cual se mostrará un error
0.2.13. Clausuras
Las clausuras (en inglés closures) son una extensión del concepto de alcance (scope) — funciones que
tienen acceso a las variables que están disponibles dentro del ámbito en donde se creó la función. Si
este concepto es confuso, no debe preocuparse: se entiende mejor a través de ejemplos.
En el ejemplo 2.47 se muestra la forma en que funciones tienen acceso para cambiar el valor de
las variables. El mismo comportamiento sucede en funciones creadas dentro de bucles — la función
“observa” el cambio en la variable, incluso después de que la función sea definida, resultando que en
todos los clicks aparezca una ventana de alerta mostrando el valor 5.
¿Cómo establecer el valor de i?
/* esto no se comporta como se desea; */
/* cada click mostrará una ventana de alerta con el valor 5 */
for (var i=0; i<5; i++) {
$('<p>hacer click</p>').appendTo('body').click(function() {
alert(i);
});
}
Establecer el valor de i utilizando una clausura
/* solución: “clausurar” el valor de i dentro de createFunction */
var createFunction = function(i) {
return function() {
24

-- 25 of 107 --

alert(i);
};
};
for (var i = 0; i < 5; i++) {
$('<p>hacer click</p>').appendTo('body').click(createFunction(i));
}
Las clausuras también pueden ser utilizadas para resolver problemas con la palabra clave this, la cual
es única en cada alcance.
Utilizar una clausura para acceder simultáneamente a instancias de objetos internos y
externos.
var outerObj = {
myName: 'externo',
outerFunction: function() {
// provee una referencia al mismo objeto outerObj
// para utilizar dentro de innerFunction
var self = this;
var innerObj = {
myName: 'interno',
innerFunction: function() {
console.log(self.myName, this.myName); // registra 'externo interno'
}
};
innerObj.innerFunction();
console.log(this.myName); // registra 'externo'
}
};
outerObj.outerFunction();
Este mecanismo puede ser útil cuando trabaje con funciones de devolución de llamadas (en inglés
callbacks). Sin embargo, en estos casos, es preferible que utilice Function.bind ya que evitará cualquier
sobrecarga asociada con el alcance (scope).
0.3. Conceptos Básicos de jQuery
0.3.1. $(document).ready()
No es posible interactuar de forma segura con el contenido de una página hasta que el documento
no se encuentre preparado para su manipulación. jQuery permite detectar dicho estado a través de la
declaración $(document).ready() de forma tal que el bloque se ejecutará sólo una vez que la página
este disponible.
El bloque $(document).ready()
25

-- 26 of 107 --

$(document).ready(function() {
console.log('el documento está preparado');
});
Existe una forma abreviada para $(document).ready() la cual podrá encontrar algunas veces; sin
embargo, es recomendable no utilizarla en caso que este escribiendo código para gente que no conoce
jQuery.
Forma abreviada para $(document).ready()
$(function() {
console.log('el documento está preparado');
});
Además es posible pasarle a $(document).ready() una función nombrada en lugar de una anónima:
Pasar una función nombrada en lugar de una función anónima
function readyFn() {
// código a ejecutar cuando el documento este listo
}
$(document).ready(readyFn);
0.3.2. Selección de Elementos
El concepto más básico de jQuery es el de “seleccionar algunos elementos y realizar acciones con
ellos”. La biblioteca soporta gran parte de los selectores CSS3 y varios más no estandarizados. En
http://api.jquery.com/category/selectors/ se puede encontrar una completa referencia sobre
los selectores de la biblioteca.
A continuación se muestran algunas técnicas comunes para la selección de elementos:
Selección de elementos en base a su ID
$('#myId'); // notar que los IDs deben ser únicos por página
Selección de elementos en base al nombre de clase
$('div.myClass'); // si se especifica el tipo de elemento,
// se mejora el rendimiento de la selección
Selección de elementos por su atributo
$('input[name=first_name]'); // tenga cuidado, que puede ser muy lento
Selección de elementos en forma de selector CSS
$('#contents ul.people li');
26

-- 27 of 107 --

Pseudo-selectores
$('a.external:first'); // selecciona el primer elemento <a>
// con la clase 'external'
$('tr:odd'); // selecciona todos los elementos <tr>
// impares de una tabla
$('#myForm :input'); // selecciona todos los elementos del tipo input
// dentro del formulario #myForm
$('div:visible'); // selecciona todos los divs visibles
$('div:gt(2)'); // selecciona todos los divs excepto los tres primeros
$('div:animated'); // selecciona todos los divs actualmente animados
Nota
Cuando se utilizan los pseudo-selectores :visible y :hidden, jQuery comprueba la visi-
bilidad actual del elemento pero no si éste posee asignados los estilos CSS visibility o
display — en otras palabras, verifica si el alto y ancho físico del elemento es mayor a
cero. Sin embargo, esta comprobación no funciona con los elementos <tr>; en este caso,
jQuery comprueba si se está aplicando el estilo display y va a considerar al elemento
como oculto si posee asignado el valor none. Además, los elementos que aún no fueron
añadidos al DOM serán tratados como ocultos, incluso si tienen aplicados estilos indicando
que deben ser visibles (En la sección Manipulación de este manual, se explica como crear
y añadir elementos al DOM).
Como referencia, este es el fragmento de código que utiliza jQuery para determinar cuando un elemento
es visible o no. Se incorporaron los comentarios para que quede más claro su entendimiento:
jQuery.expr.filters.hidden = function( elem ) {
var width = elem.offsetWidth, height = elem.offsetHeight,
skip = elem.nodeName.toLowerCase() === "tr";
// ¿el elemento posee alto 0, ancho 0 y no es un <tr>?
return width === 0 && height === 0 && !skip ?
// entonces debe estar oculto (hidden)
true :
// pero si posee ancho y alto
// y no es un <tr>
width > 0 && height > 0 && !skip ?
// entonces debe estar visible
false :
// si nos encontramos aquí, es porque el elemento posee ancho
// y alto, pero además es un <tr>,
// entonces se verifica el valor del estilo display
// aplicado a través de CSS
// para decidir si está oculto o no
jQuery.curCSS(elem, "display") === "none";
};
27

-- 28 of 107 --

jQuery.expr.filters.visible = function( elem ) {
return !jQuery.expr.filters.hidden( elem );
};
Elección de Selectores
La elección de buenos selectores es un punto importante cuando se desea mejorar el rendimiento del
código. Una pequeña especificidad — por ejemplo, incluir el tipo de elemento (como div) cuando se
realiza una selección por el nombre de clase — puede ayudar bastante. Por eso, es recomendable darle
algunas “pistas” a jQuery sobre en que lugar del documento puede encontrar lo que desea seleccionar.
Por otro lado, demasiada especificidad puede ser perjudicial. Un selector como #miTabla thead tr
th.especial es un exceso, lo mejor sería utilizar #miTabla th.especial.
jQuery ofrece muchos selectores basados en atributos, que permiten realizar selecciones basadas en el
contenido de los atributos utilizando simplificaciones de expresiones regulares.
// encontrar todos los <a> cuyo atributo rel terminan en "thinger"
$("a[rel$='thinger']");
Estos tipos de selectores pueden resultar útiles pero también ser muy lentos. Cuando sea posible, es
recomendable realizar la selección utilizando IDs, nombres de clases y nombres de etiquetas.
Si desea conocer más sobre este asunto, Paul Irish realizó una gran presentación sobre mejoras de
rendimiento en JavaScript (en ingles), la cual posee varias diapositivas centradas en selectores.
Comprobar Selecciones
Una vez realizada la selección de los elementos, querrá conocer si dicha selección entregó algún resul-
tado. Para ello, pueda que escriba algo así:
if ($('div.foo')) { ... }
Sin embargo esta forma no funcionará. Cuando se realiza una selección utilizando $(), siempre es
devuelto un objeto, y si se lo evalúa, éste siempre devolverá true. Incluso si la selección no contiene
ningún elemento, el código dentro del bloque if se ejecutará.
En lugar de utilizar el código mostrado, lo que se debe hacer es preguntar por la cantidad de elementos
que posee la selección que se ejecutó. Esto es posible realizarlo utilizando la propiedad JavaScript
length. Si la respuesta es 0, la condición evaluará falso, caso contrario (más de 0 elementos), la
condición será verdadera.
Evaluar si una selección posee elementos
if ($('div.foo').length) { ... }
Guardar Selecciones
Cada vez que se hace una selección, una gran cantidad de código es ejecutado. jQuery no guarda el
resultado por si solo, por lo tanto, si va a realizar una selección que luego se hará de nuevo, deberá
salvar la selección en una variable.
Guardar selecciones en una variable
28

-- 29 of 107 --

var $divs = $('div');
Nota
En el ejemplo “Guardar selecciones en una variable”, la variable comienza con el signo
de dólar. Contrariamente a otros lenguajes de programación, en JavaScript este signo
no posee ningún significado especial — es solamente otro carácter. Sin embargo aquí se
utilizará para indicar que dicha variable posee un objeto jQuery. Esta práctica — una
especie de Notación Húngara — es solo una convención y no es obligatoria.
Una vez que la selección es guardada en la variable, se la puede utilizar en conjunto con los métodos
de jQuery y el resultado será igual que utilizando la selección original.
Nota
La selección obtiene sólo los elementos que están en la página cuando se realizó dicha
acción. Si luego se añaden elementos al documento, será necesario repetir la selección o
añadir los elementos nuevos a la selección guardada en la variable. En otras palabras, las
selecciones guardadas no se actualizan “mágicamente” cuando el DOM se modifica.
Refinamiento y Filtrado de Selecciones
A veces, puede obtener una selección que contiene más de lo que necesita; en este caso, es necesario
refinar dicha selección. jQuery ofrece varios métodos para poder obtener exactamente lo que desea.
Refinamiento de selecciones
$('div.foo').has('p'); // el elemento div.foo contiene elementos <p>
$('h1').not('.bar'); // el elemento h1 no posse la clase 'bar'
$('ul li').filter('.current'); // un item de una lista desordenada
// que posse la clase 'current'
$('ul li').first(); // el primer item de una lista desordenada
$('ul li').eq(5); // el sexto item de una lista desordenada
Selección de Elementos de un Formulario
jQuery ofrece varios pseudo-selectores que ayudan a encontrar elementos dentro de los formularios,
éstos son especialmente útiles ya que dependiendo de los estados de cada elemento o su tipo, puede
ser difícil distinguirlos utilizando selectores CSS estándar.
:button Selecciona elementos <button> y con el atributo type='button'
:checkbox Selecciona elementos <input> con el atributo type='checkbox'
:checked Selecciona elementos <input> del tipo checkbox seleccionados
:disabled Selecciona elementos del formulario que están deshabitados
:enabled Selecciona elementos del formulario que están habilitados
:file Selecciona elementos <input> con el atributo type='file'
:image Selecciona elementos <input> con el atributo type='image'
:input Selecciona elementos <input>, <textarea> y <select>
:password Selecciona elementos <input> con el atributo type='password'
:radio Selecciona elementos <input> con el atributo type='radio'
29

-- 30 of 107 --

:reset Selecciona elementos <input> con el atributo type='reset'
:selected Selecciona elementos <options> que están seleccionados
:submit Selecciona elementos <input> con el atributo type='submit'
:text Selecciona elementos <input> con el atributo type='text'
Utilizando pseudo-selectores en elementos de formularios
$('#myForm :input'); // obtiene todos los elementos inputs
// dentro del formulario #myForm
0.3.3. Trabajar con Selecciones
Una vez realizada la selección de los elementos, es posible utilizarlos en conjunto con diferentes méto-
dos. éstos, generalmente, son de dos tipos: obtenedores (en inglés getters) y establecedores (en inglés
setters). Los métodos obtenedores devuelven una propiedad del elemento seleccionado; mientras que
los métodos establecedores fijan una propiedad a todos los elementos seleccionados.
Encadenamiento
Si en una selección se realiza una llamada a un método, y éste devuelve un objeto jQuery, es posible
seguir un “encadenado” de métodos en el objeto.
Encadenamiento
$('#content').find('h3').eq(2).html('nuevo texto para el tercer elemento h3');
Por otro lado, si se está escribiendo un encadenamiento de métodos que incluyen muchos pasos, es
posible escribirlos línea por línea, haciendo que el código luzca más agradable para leer.
Formateo de código encadenado
$('#content')
.find('h3')
.eq(2)
.html('nuevo texto para el tercer elemento h3');
Si desea volver a la selección original en el medio del encadenado, jQuery ofrece el método $.fn.end
para poder hacerlo.
Restablecer la selección original utilizando el método $.fn.end
$('#content')
.find('h3')
.eq(2)
.html('nuevo texto para el tercer elemento h3')
.end() // reestablece la selección a todos los elementos h3 en #content
.eq(0)
.html('nuevo texto para el primer elemento h3');
30

-- 31 of 107 --

Nota
El encadenamiento es muy poderoso y es una característica que muchas bibliotecas Ja-
vaScript han adoptado desde que jQuery se hizo popular. Sin embargo, debe ser utilizado
con cuidado. Un encadenamiento de métodos extensivo pueden hacer un código extrema-
damente difícil de modificar y depurar. No existe una regla que indique que tan largo o
corto debe ser el encadenado — pero es recomendable que tenga en cuenta este consejo.
Obtenedores (Getters) & Establecedores (Setters)
jQuery “sobrecarga” sus métodos, en otras palabras, el método para establecer un valor posee el mismo
nombre que el método para obtener un valor. Cuando un método es utilizado para establecer un valor,
es llamado método establecedor (en inglés setter). En cambio, cuando un método es utilizado para
obtener (o leer) un valor, es llamado obtenedor (en inglés getter).
El método $.fn.html utilizado como establecedor
$('h1').html('hello world');
El método html utilizado como obtenedor
$('h1').html();
Los métodos establecedores devuelven un objeto jQuery, permitiendo continuar con la llamada de más
métodos en la misma selección, mientras que los métodos obtenedores devuelven el valor por el cual
se consultó, pero no permiten seguir llamando a más métodos en dicho valor.
0.3.4. CSS, Estilos, & Dimensiones
jQuery incluye una manera útil de obtener y establecer propiedades CSS a los elementos.
Nota
Las propiedades CSS que incluyen como separador un guión del medio, en JavaScript deben
ser transformadas a su estilo CamelCase. Por ejemplo, cuando se la utiliza como propiedad
de un método, el estilo CSS font-size deberá ser expresado como fontSize. Sin embargo,
esta regla no es aplicada cuando se pasa el nombre de la propiedad CSS al método $.fn.css
— en este caso, los dos formatos (en CamelCase o con el guión del medio) funcionarán.
Obtener propiedades CSS
$('h1').css('fontSize'); // devuelve una cadena de caracteres como "19px"
$('h1').css('font-size'); // también funciona
Establecer propiedades CSS
$('h1').css('fontSize', '100px'); // establece una propiedad individual CSS
$('h1').css({
'fontSize' : '100px',
'color' : 'red'
}); // establece múltiples propiedades CSS
31

-- 32 of 107 --

Notar que el estilo del argumento utilizado en la segunda línea del ejemplo — es un objeto que contiene
múltiples propiedades. Esta es una forma común de pasar múltiples argumentos a una función, y
muchos métodos establecedores de la biblioteca aceptan objetos para fijar varias propiedades de una
sola vez.
A partir de la versión 1.6 de la biblioteca, utilizando $.fn.css también es posible establecer valores
relativos en las propiedades CSS de un elemento determinado:
Establecer valores CSS relativos
$('h1').css({
'fontSize' : '+=15px', // suma 15px al tamaño original del elemento
'paddingTop' : '+=20px' // suma 20px al padding superior original del elemento
});
Utilizar Clases para Aplicar Estilos CSS
Para obtener valores de los estilos aplicados a un elemento, el método $.fn.css es muy útil, sin
embargo, su utilización como método establecedor se debe evitar (ya que, para aplicar estilos a un
elemento, se puede hacer directamente desde CSS). En su lugar, lo ideal, es escribir reglas CSS que
se apliquen a clases que describan los diferentes estados visuales de los elementos y luego cambiar la
clase del elemento para aplicar el estilo que se desea mostrar.
Trabajar con clases
var $h1 = $('h1');
$h1.addClass('big');
$h1.removeClass('big');
$h1.toggleClass('big');
if ($h1.hasClass('big')) { ... }
Las clases también pueden ser útiles para guardar información del estado de un elemento, por ejemplo,
para indicar que un elemento fue seleccionado.
Dimensiones
jQuery ofrece una variedad de métodos para obtener y modificar valores de dimensiones y posición de
un elemento.
El código mostrado en el ejemplo “Métodos básicos sobre Dimensiones” es solo un breve resumen
de las funcionalidades relaciones a dimensiones en jQuery; para un completo detalle puede consultar
http://api.jquery.com/category/dimensions/.
Métodos básicos sobre Dimensiones
$('h1').width('50px'); // establece el ancho de todos los elementos H1
$('h1').width(); // obtiene el ancho del primer elemento H1
$('h1').height('50px'); // establece el alto de todos los elementos H1
$('h1').height(); // obtiene el alto del primer elemento H1
32

-- 33 of 107 --

$('h1').position(); // devuelve un objeto conteniendo
// información sobre la posición
// del primer elemento relativo al
// "offset" (posición) de su elemento padre
0.3.5. Atributos
Los atributos de los elementos HTML que conforman una aplicación pueden contener información
útil, por eso es importante poder establecer y obtener esa información.
El método $.fn.attr actúa tanto como método establecedor como obtenedor. Además, al igual que
el método $.fn.css, cuando se lo utiliza como método establecedor, puede aceptar un conjunto de
palabra clave-valor o un objeto conteniendo más conjuntos.
Establecer atributos
$('a').attr('href', 'allMyHrefsAreTheSameNow.html');
$('a').attr({
'title' : 'all titles are the same too',
'href' : 'somethingNew.html'
});
En el ejemplo, el objeto pasado como argumento está escrito en varias líneas. Como se explicó anterior-
mente, los espacios en blanco no importan en JavaScript, por lo cual, es libre de utilizarlos para hacer
el código más legible. En entornos de producción, se pueden utilizar herramientas de minificación, los
cuales quitan los espacios en blanco (entre otras cosas) y comprimen el archivo final.
Obtener atributos
$('a').attr('href'); // devuelve el atributo href perteneciente
// al primer elemento <a> del documento
0.3.6. Recorrer el DOM
Una vez obtenida la selección, es posible encontrar otros elementos utilizando a la misma selección.
En http://api.jquery.com/category/traversing/ puede encontrar una completa documentación
sobre los métodos de recorrido de DOM (en inglés traversing) que posee jQuery.
Nota
Debe ser cuidadoso en recorrer largas distancias en un documento — recorridos complejos
obligan que la estructura del documento sea siempre la misma, algo que es difícil de
garantizar. Uno -o dos- pasos para el recorrido esta bien, pero generalmente hay que evitar
atravesar desde un contenedor a otro.
Moverse a través del DOM utilizando métodos de recorrido
$('h1').next('p'); // seleccionar el inmediato y próximo
// elemento <p> con respecto a H1
33

-- 34 of 107 --

$('div:visible').parent(); // seleccionar el elemento contenedor
// a un div visible
$('input[name=first_name]').closest('form'); // seleccionar el elemento
// <form> más cercano a un input
$('#myList').children(); // seleccionar todos los elementos
// hijos de #myList
$('li.selected').siblings(); // seleccionar todos los items
// hermanos del elemento <li>
También es posible interactuar con la selección utilizando el método $.fn.each. Dicho método inter-
actúa con todos los elementos obtenidos en la selección y ejecuta una función por cada uno. La función
recibe como argumento el índice del elemento actual y al mismo elemento. De forma predeterminada,
dentro de la función, se puede hacer referencia al elemento DOM a través de la declaración this.
Interactuar en una selección
$('#myList li').each(function(idx, el) {
console.log(
'El elemento ' + idx +
'contiene el siguiente HTML: ' +
$(el).html()
);
});
0.3.7. Manipulación de Elementos
Una vez realizada la selección de los elementos que desea utilizar, “la diversión comienza”. Es posible
cambiar, mover, remover y duplicar elementos. También crear nuevos a través de una sintaxis simple.
La documentación completa sobre los métodos de manipulación puede encontrarla en la sección
Manipulation: http://api.jquery.com/category/manipulation/.
Obtener y Establecer Información en Elementos
Existen muchas formas por las cuales de puede modificar un elemento. Entre las tareas más comunes
están las de cambiar el HTML interno o algún atributo del mismo. Para este tipo de tareas, jQuery
ofrece métodos simples, funcionales en todos los navegadores modernos. Incluso es posible obtener
información sobre los elementos utilizando los mismos métodos pero en su forma de método obtenedor.
Nota
Realizar cambios en los elementos, es un trabajo trivial, pero hay debe recordar que el
cambio afectará a todos los elementos en la selección, por lo que, si desea modificar un
sólo elemento, tiene que estar seguro de especificarlo en la selección antes de llamar al
método establecedor.
Nota
Cuando los métodos actúan como obtenedores, por lo general, solamente trabajan con el
primer elemento de la selección. Además no devuelven un objeto jQuery, por lo cual no es
posible encadenar más métodos en el mismo. Una excepción es el método $.fn.text, el
cual permite obtener el texto de los elementos de la selección.
34

-- 35 of 107 --

$.fn.html Obtiene o establece el contenido HTML de un elemento.
$.fn.text Obtiene o establece el contenido en texto del elemento; en caso se pasarle como argumento
código HTML, este es despojado.
$.fn.attr Obtiene o establece el valor de un determinado atributo.
$.fn.width Obtiene o establece el ancho en pixeles del primer elemento de la selección como un
entero.
$.fn.height Obtiene o establece el alto en pixeles del primer elemento de la selección como un entero.
$.fn.position Obtiene un objeto con información sobre la posición del primer elemento de la selección,
relativo al primer elemento padre posicionado. Este método es solo obtenedor.
$.fn.val Obtiene o establece el valor (value) en elementos de formularios.
Cambiar el HTML de un elemento
$('#myDiv p:first')
.html('Nuevo <strong>primer</strong> párrafo');
Mover, Copiar y Remover Elementos
Existen varias maneras para mover elementos a través del DOM; las cuales se pueden separar en dos
enfoques:
querer colocar el/los elementos seleccionados de forma relativa a otro elemento;
querer colocar un elemento relativo a el/los elementos seleccionados.
Por ejemplo, jQuery provee los métodos $.fn.insertAfter y $.fn.after. El método $.fn.insertAfter
coloca a el/los elementos seleccionados después del elemento que se haya pasado como argumento;
mientras que el método $.fn.after coloca al elemento pasado como argumento después del elemento
seleccionado. Otros métodos también siguen este patrón: $.fn.insertBefore y $.fn.before;
$.fn.appendTo y $.fn.append; y $.fn.prependTo y $.fn.prepend.
La utilización de uno u otro método dependerá de los elementos que tenga seleccionados y el tipo de
referencia que se quiera guardar con respecto al elemento que se esta moviendo.
Mover elementos utilizando diferentes enfoques
// hacer que el primer item de la lista sea el último
var $li = $('#myList li:first').appendTo('#myList');
// otro enfoque para el mismo problema
$('#myList').append($('#myList li:first'));
// debe tener en cuenta que no hay forma de acceder a la
// lista de items que se ha movido, ya que devuelve
// la lista en sí
Clonar Elementos Cuando se utiliza un método como $.fn.appendTo, lo que se está haciendo es
mover al elemento; pero a veces en lugar de eso, se necesita mover un duplicado del mismo elemento.
En este caso, es posible utilizar el método $.fn.clone.
Obtener una copia del elemento
35

-- 36 of 107 --

// copiar el primer elemento de la lista y moverlo al final de la misma
$('#myList li:first').clone().appendTo('#myList');
Nota
Si se necesita copiar información y eventos relacionados al elemento, se debe pasar true
como argumento de $.fn.clone.
Remover elementos Existen dos formas de remover elementos de una página: Utilizando
$.fn.remove o $.fn.detach. Cuando desee remover de forma permanente al elemento, utilize
el método $.fn.remove. Por otro lado, el método $.fn.detach también remueve el elemento, pero
mantiene la información y eventos asociados al mismo, siendo útil en el caso que necesite reinsertar
el elemento en el documento.
Nota
El método $.fn.detach es muy útil cuando se esta manipulando de forma severa un
elemento, ya que es posible eliminar al elemento, trabajarlo en el código y luego restaurarlo
en la página nuevamente. Esta forma tiene como beneficio no tocar el DOM mientras se
está modificando la información y eventos del elemento.
Por otro lado, si se desea mantener al elemento pero se necesita eliminar su contenido, es posible
utiliza el método $.fn.empty, el cual “vaciará” el contenido HTML del elemento.
Crear Nuevos Elementos
jQuery provee una forma fácil y elegante para crear nuevos elementos a través del mismo método $()
que se utiliza para realizar selecciones.
Crear nuevos elementos
$('<p>Un nuevo párrafo</p>');
$('<li class="new">nuevo item de la lista</li>');
Crear un nuevo elemento con atributos utilizando un objeto
$('<a/>', {
html : 'Un <strong>nuevo</strong> enlace',
'class' : 'new',
href : 'foo.html'
});
Note que en el objeto que se pasa como argumento, la propiedad class está entre comillas, mientras
que la propiedad href y html no lo están. Por lo general, los nombres de propiedades no deben estar
entre comillas, excepto en el caso que se utilice como nombre una palabra reservada (como es el caso
de class).
Cuando se crea un elemento, éste no es añadido inmediatamente a la página, sino que se debe hacerlo
en conjunto con un método.
Crear un nuevo elemento en la página
36

-- 37 of 107 --

var $myNewElement = $('<p>Nuevo elemento</p>');
$myNewElement.appendTo('#content');
$myNewElement.insertAfter('ul:last'); // eliminará al elemento <p>
// existente en #content
$('ul').last().after($myNewElement.clone()); // clonar al elemento <p>
// para tener las dos versiones
Estrictamente hablando, no es necesario guardar al elemento creado en una variable — es posible
llamar al método para añadir el elemento directamente después de $(). Sin embargo, la mayoría de
las veces se deseará hacer referencia al elemento añadido, por lo cual, si se guarda en una variable no
es necesario seleccionarlo después.
Crear y añadir al mismo tiempo un elemento a la página
$('ul').append('<li>item de la lista</li>');
Nota
La sintaxis para añadir nuevos elementos a la página es muy fácil de utilizar, pero es
tentador olvidar que hay un costo enorme de rendimiento al agregar elementos al DOM
de forma repetida. Si esta añadiendo muchos elementos al mismo contenedor, en lugar de
añadir cada elemento uno por vez, lo mejor es concatenar todo el HTML en una única
cadena de caracteres para luego anexarla al contenedor. Una posible solución es utilizar un
vector que posea todos los elementos, luego reunirlos utilizando join y finalmente anexarla.
var myItems = [], $myList = $('#myList');
for (var i=0; i<100; i++) {
myItems.push('<li>item ' + i + '</li>');
}
$myList.append(myItems.join(''));
Manipulación de Atributos
Las capacidades para la manipulación de atributos que ofrece la biblioteca son extensos. La realiza-
ción de cambios básicos son simples, sin embargo el método $.fn.attr permite manipulaciones más
complejas.
Manipular un simple atributo
$('#myDiv a:first').attr('href', 'newDestination.html');
Manipular múltiples atributos
$('#myDiv a:first').attr({
href : 'newDestination.html',
rel : 'super-special'
});
37

-- 38 of 107 --

Utilizar una función para determinar el valor del nuevo atributo
$('#myDiv a:first').attr({
rel : 'super-special',
href : function(idx, href) {
return '/new/' + href;
}
});
$('#myDiv a:first').attr('href', function(idx, href) {
return '/new/' + href;
});
0.3.8. Ejercicios
Selecciones
Abra el archivo /ejercicios/index.html en el navegador. Realice el ejercicio utilizando el archivo
/ejercicios/js/sandbox.js o trabaje directamente con Firebug para cumplir los siguientes puntos: