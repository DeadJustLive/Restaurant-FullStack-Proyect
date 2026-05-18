# parte i: zquierda.

$('.data table.attendees td.gonzalez');
// mucho mejor: eliminar la parte media de ser posible
$('.data td.gonzalez');
La segunda selección tiene mejor rendimiento debido a que atraviesa menos capas para buscar el
elemento.
Evitar el Selector Universal
Selecciones en donde se especifica de forma implícita o explícita una selección universal puede resultar
muy lento.
76

-- 77 of 107 --

$('.buttons > *'); // muy lento
$('.buttons').children(); // mucho mejor
$('.gender :radio'); // selección universal implícita
$('.gender *:radio'); // misma forma, pero de forma explícita
$('.gender input:radio'); // mucho mejor
0.9.6. Utilizar la Delegación de Eventos
La delegación de eventos permite vincular un controlador de evento a un elemento contenedor (por
ejemplo, una lista desordenada) en lugar de múltiples elementos contenidos (por ejemplo, los ítems
de una lista). jQuery hace fácil este trabajo a través de $.fn.live y$.fn.delegate. En lo posible,
es recomendable utilizar $.fn.delegate en lugar de $.fn.live, ya que elimina la necesidad de una
selección y su contexto explícito reduce la carga en aproximadamente un 80 %.
Además, la delegación de eventos permite añadir nuevos elementos contenedores a la página sin tener
que volver a vincular sus controladores de eventos.
// mal (si existen muchos items en la lista)
$('li.trigger').click(handlerFn);
// mejor: delegación de eventos con $.fn.live
$('li.trigger').live('click', handlerFn);
// mucho mejor: delegación de eventos con $.fn.delegate
// permite especificar un contexto de forma fácil
$('#myList').delegate('li.trigger', 'click', handlerFn);
0.9.7. Separar Elementos para Trabajar con Ellos
En lo posible, hay que evitar la manipulación del DOM. Para ayudar con este propósito, a partir de
la versión 1.4, jQuery introduce $.fn.detach el cual permite trabajar elementos de forma separada
del DOM para luego insertarlos.
var $table = $('#myTable');
var $parent = $table.parent();
$table.detach();
// ... se añaden muchas celdas a la tabla
$parent.append(table);
0.9.8. Utilizar Estilos en Cascada para Cambios de CSS en Varios Elemen-
tos
Si va a cambiar el CSS en más de 20 elementos utilizando $.fn.css, considere realizar los cambios
de estilos añadiéndolos en una etiqueta style. De esta forma se incrementa un 60 % el rendimiento.
// correcto hasta 20 elementos, lento en más elementos
$('a.swedberg').css('color', '#asd123');
$('<style type="text/css">a.swedberg { color : #asd123 }</style>')
.appendTo('head');
77

-- 78 of 107 --

0.9.9. Utilizar $.data en Lugar de $.fn.data
Utilizar $.data en un elemento del DOM en lugar de $.fn.data en una selección puede ser hasta
10 veces más rápido. Antes de realizarlo, este seguro de comprender la diferencia entre un elemento
DOM y una selección jQuery.
// regular
$(elem).data(key,value);
// 10 veces más rápido
$.data(elem,key,value);
0.9.10. No Actuar en Elementos no Existentes
jQuery no le dirá si esta tratando de ejecutar código en una selección vacía — esta se ejecutará como
si nada estuviera mal. Dependerá de usted comprobar si la selección contiene elementos.
// MAL: el código a continuación ejecuta tres funciones
// sin comprobar si existen elementos
// en la selección
$('#nosuchthing').slideUp();
// Mejor
var $mySelection = $('#nosuchthing');
if ($mySelection.length) { $mySelection.slideUp(); }
// MUCHO MEJOR: añadir una extensión doOnce
jQuery.fn.doOnce = function(func){
this.length && func.apply(this);
return this;
}
$('li.cartitems').doOnce(function(){
// realizar algo
});
Este consejo es especialmente aplicable para widgets de jQuery UI, los cuales poseen mucha carga
incluso cuando la selección no contiene elementos.
0.9.11. Definición de Variables
Las variables pueden ser definidas en una sola declaración en lugar de varias.
// antiguo
var test = 1;
78

-- 79 of 107 --

var test2 = function() { ... };
var test3 = test2(test);
// mejor forma
var test = 1,
test2 = function() { ... },
test3 = test2(test);
En funciones autoejecutables, las definiciones de variables pueden pasarse todas juntas.
(function(foo, bar) { ... })(1, 2);
0.9.12. Condicionales
// antiguo
if (type == 'foo' || type == 'bar') { ... }
// mejor
if (/^(foo|bar)$/.test(type)) { ... }
// búsqueda en objeto literal
if (({ foo : 1, bar : 1 })[type]) { ... }
0.9.13. No Tratar a jQuery como si fuera una Caja Negra
Utilice el código fuente de la biblioteca como si fuera su documentación — guarde el enlace http:
//bit.ly/jqsource como marcador para tener de referencia.
0.10. Organización del Código
0.10.1. Introducción
Cuando se emprende la tarea de realizar aplicaciones complejas del lado del cliente, es necesario
considerar la forma en que se organizará el código. Este capitulo está dedicado a analizar algunos
patrones de organización de código para utilizar en una aplicación realizada con jQuery. Además se
explorará el sistema de gestión de dependencias de RequireJS.
Conceptos Clave
Antes de comenzar con los patrones de organización de código, es importante entender algunos con-
ceptos clave:
el código debe estar divido en unidades funcionales — módulos, servicios, etc. Y se debe evitar
la tentación de tener todo en un único bloque $(document).ready(). Este concepto se conoce
como encapsulación;
no repetir código. Identificar piezas similares y utilizar técnicas de herencia;
79

-- 80 of 107 --

a pesar de la naturaleza de jQuery, no todas las aplicaciones JavaScript trabajan (o tienen la
necesidad de poseer una representación) en el DOM;
las unidades de funcionalidad deben tener una articulación flexible (en inglés loosely coupled) —
es decir, una unidad de funcionalidad debe ser capaz de existir por si misma y la comunicación
con otras unidades debe ser a través de un sistema de mensajes como los eventos personalizados
o pub/sub. Por otro lado, siempre que sea posible, de debe mantener alejada la comunicación
directa entre unidades funcionales.
El concepto de articulación flexible puede ser especialmente problemático para desarrolladores que
hacen su primera incursión en aplicaciones complejas. Por lo tanto, si usted esta empezando a crear
aplicaciones, solamente sea consciente de este concepto.
0.10.2. Encapsulación
El primer paso para la organización del código es separar la aplicación en distintas piezas.
Muchas veces, este esfuerzo suele ser suficiente para mantener al código en orden.
El Objeto Literal
Un objeto literal es tal vez la manera más simple de encapsular código relacionado. Este no ofre-
ce ninguna privacidad para propiedades o métodos, pero es útil para eliminar funciones anónimas,
centralizar opciones de configuración, y facilitar el camino para la reutilización y refactorización.
Un objeto literal
var myFeature = {
myProperty : 'hello',
myMethod : function() {
console.log(myFeature.myProperty);
},
init : function(settings) {
myFeature.settings = settings;
},
readSettings : function() {
console.log(myFeature.settings);
}
};
myFeature.myProperty; // 'hello'
myFeature.myMethod(); // registra 'hello'
myFeature.init({ foo : 'bar' });
myFeature.readSettings(); // registra { foo : 'bar' }
El objeto posee una propiedad y varios métodos, los cuales son públicos (es decir, cualquier parte de la
aplicación puede verlos). ¿Cómo se puede aplicar este patrón con jQuery? Por ejemplo, en el siguiente
código escrito en el estilo tradicional:
80

-- 81 of 107 --

// haciendo click en un item de la lista se carga cierto contenido,
// luego utilizando el ID de dicho item se ocultan
// los items aledaños
$(document).ready(function() {
$('#myFeature li')
.append('<div/>')
.click(function() {
var $this = $(this);
var $div = $this.find('div');
$div.load('foo.php?item=' +
$this.attr('id'),
function() {
$div.show();
$this.siblings()
.find('div').hide();
}
);
});
});
Si el ejemplo mostrado representa el 100 % de la aplicación, es conveniente dejarlo como esta, ya que
no amerita hacer una reestructuración. En cambio, si la pieza es parte de una aplicación más grande,
estaría bien separar dicha funcionalidad de otras no relacionadas. Por ejemplo, es conveniente mover
la URL a la cual se hace la petición fuera del código y pasarla al área de configuración. También
romper la cadena de métodos para hacer luego más fácil la modificación.
Utilizar un objeto literal para una funcionalidad jQuery
var myFeature = {
init : function(settings) {
myFeature.config = {
$items : $('#myFeature li'),
$container : $('<div class="container"></div>'),
urlBase : '/foo.php?item='
};
// permite sobrescribir la configuración predeterminada
$.extend(myFeature.config, settings);
myFeature.setup();
},
setup : function() {
myFeature.config.$items
.each(myFeature.createContainer)
.click(myFeature.showItem);
},
createContainer : function() {
var $i = $(this),
$c = myFeature.config.$container.clone()
.appendTo($i);
81

-- 82 of 107 --

$i.data('container', $c);
},
buildUrl : function() {
return myFeature.config.urlBase +
myFeature.$currentItem.attr('id');
},
showItem : function() {
var myFeature.$currentItem = $(this);
myFeature.getContent(myFeature.showContent);
},
getContent : function(callback) {
var url = myFeature.buildUrl();
myFeature.$currentItem
.data('container').load(url, callback);
},
showContent : function() {
myFeature.$currentItem
.data('container').show();
myFeature.hideContent();
},
hideContent : function() {
myFeature.$currentItem.siblings()
.each(function() {
$(this).data('container').hide();
});
}
};
$(document).ready(myFeature.init);
La primera característica a notar es que el código es más largo que el original — como se dijo ante-
riormente, si este fuera el alcance de la aplicación, utilizar un objeto literal seria probablemente una
exageración.
Con la nueva organización, las ventajas obtenidas son:
separación de cada funcionalidad en pequeños métodos. En un futuro, si se quiere cambiar la
forma en que el contenido se muestra, será claro en donde habrá que hacerlo. En el código
original, este paso es mucho más difícil de localizar;
se eliminaron los usos de funciones anónimas;
las opciones de configuración se movieron a una ubicación central;
se eliminaron las limitaciones que poseen las cadenas de métodos, haciendo que el código sea
más fácil para refactorizar, mezclar y reorganizar.
82

-- 83 of 107 --

Por sus características, la utilización de objetos literales permiten una clara mejora para tramos largos
de código insertados en un bloque $(document).ready(). Sin embargo, no son más avanzados que
tener varias declaraciones de funciones dentro de un bloque $(document).ready().
El Patrón Modular
El patrón modular supera algunas limitaciones del objeto literal, ofreciendo privacidad para variables
y funciones, exponiendo a su vez (si se lo desea) una API pública.
El patrón modular
var feature =(function() {
// variables y funciones privadas
var privateThing = 'secret',
publicThing = 'not secret',
changePrivateThing = function() {
privateThing = 'super secret';
},
sayPrivateThing = function() {
console.log(privateThing);
changePrivateThing();
};
// API publica
return {
publicThing : publicThing,
sayPrivateThing : sayPrivateThing
}
})();
feature.publicThing; // registra 'not secret'
feature.sayPrivateThing();
// registra 'secret' y cambia el valor
// de privateThing
En el ejemplo, se autoejecuta una función anónima la cual devuelve un objeto. Dentro de la función,
se definen algunas variables. Debido a que ellas son definidas dentro de la función, desde afuera no
se tiene acceso a menos que se pongan dentro del objeto que se devuelve. Esto implica que ningún
código fuera de la función tiene acceso a la variable privateThing o a la función sayPrivateThing.
Sin embargo, sayPrivateThing posee acceso a privateThing y changePrivateThing debido a estar
definidos en el mismo alcance.
El patrón es poderoso debido a que permite tener variables y funciones privadas, exponiendo una API
limitada consistente en devolver propiedades y métodos de un objeto.
A continuación se muestra una revisión del ejemplo visto anteriormente, con las mismas características,
pero exponiendo un único método público del modulo, showItemByIndex().
Utilizar el patrón modular para una funcionalidad jQuery
83

-- 84 of 107 --

$(document).ready(function() {
var feature = (function() {
var $items = $('#myFeature li'),
$container = $('<div class="container"></div>'),
$currentItem,
urlBase = '/foo.php?item=',
createContainer = function() {
var $i = $(this),
$c = $container.clone().appendTo($i);
$i.data('container', $c);
},
buildUrl = function() {
return urlBase + $currentItem.attr('id');
},
showItem = function() {
var $currentItem = $(this);
getContent(showContent);
},
showItemByIndex = function(idx) {
$.proxy(showItem, $items.get(idx));
},
getContent = function(callback) {
$currentItem.data('container').load(buildUrl(), callback);
},
showContent = function() {
$currentItem.data('container').show();
hideContent();
},
hideContent = function() {
$currentItem.siblings()
.each(function() {
$(this).data('container').hide();
});
};
$items
.each(createContainer)
.click(showItem);
return { showItemByIndex : showItemByIndex };
})();
84

-- 85 of 107 --

feature.showItemByIndex(0);
});
0.10.3. Gestión de Dependencias
Nota
Esta sección esta basada en la excelente documentación de RequireJS y es utilizada con el
permiso de James Burke, autor de RequireJS.
Cuando un proyecto alcanza cierto tamaño, comienza a ser difícil el manejo de los módulos de una
aplicación, ya que es necesario saber ordenarlos de forma correcta, y comenzar a combinarlos en un
único archivo para lograr la menor cantidad de peticiones. También es posible que se quiera cargar
código “al vuelo” luego de la carga de la página.
RequireJS es una herramienta de gestión de dependencias creada por James Burke, la cual ayuda
a manejar los módulos, cargarlos en un orden correcto y combinarlos de forma fácil sin tener que
realizar ningún cambio. A su vez, otorga una manera fácil de cargar código una vez cargada la página,
permitiendo minimizar el tiempo de descarga.
RequireJS posee un sistema modular, que sin embargo, no es necesario seguirlo para obtener sus
beneficios. El formato modular de RequireJS permite la escritura de código encapsulado, incorporación
de internacionalización (i18n) a los paquetes (para permitir utilizarlos en diferentes lenguajes) e incluso
la utilización de servicios JSONP como dependencias.
Obtener RequireJS
La manera más fácil de utilizar RequireJS con jQuery es descargando el paquete de jQuery con
RequireJS ya incorporado en él. Este paquete excluye porciones de código que duplican funciones de
jQuery. También es útil descargar un ejemplo de proyecto jQuery que utiliza RequireJS.
Utilizar RequireJS con jQuery
Utilizar RequireJS es simple, tan solo es necesario incorporar en la página la versión de jQuery que
posee RequireJS incorporado y a continuación solicitar los archivos de la aplicación. El siguiente
ejemplo asume que tanto jQuery como los otros archivos están dentro de la carpeta scripts/.
Utilizar RequireJS: Un ejemplo simple
<!DOCTYPE html>
<html>
<head>
<title>jQuery+RequireJS Sample Page</title>
<script src="scripts/require-jquery.js"></script>
<script>require(["app"]);</script>
</head>
<body>
<h1>jQuery+RequireJS Sample Page</h1>
</body>
</html>
85

-- 86 of 107 --

La llamada a require([.app"]) le dice a RequireJS que cargue el archivo scripts/app.js. RequireJS
cargará cualquier dependencia pasada a require() sin la extensión .js desde el mismo directorio que
en que se encuentra el archivo require-jquery.js, aunque también es posible especificar la ruta de
la siguiente forma:
<script>require(["scripts/app.js"]);</script>
El archivo app.js es otra llamada a require.js para cargar todos los archivos necesarios pa-
ra la aplicación. En el siguiente ejemplo, app.js solicita dos extensiones jquery.alpha.js y
jquery.beta.js (no son extensiones reales, solo ejemplos). Estas extensiones están en la misma
carpeta que require-jquery.js:
Un simple archivo JavaScript con dependencias
require(["jquery.alpha", "jquery.beta"], function() {
//las extensiones jquery.alpha.js y jquery.beta.js han sido cargadas.
$(function() {
$('body').alpha().beta();
});
});
Crear Módulos Reusables con RequireJS
RequireJS hace que sea fácil definir módulos reusables a través de require.def(). Un modulo Re-
quireJS puede tener dependencias que pueden ser utilizadas para definir un módulo, además de poder
devolver un valor — un objeto, una función, u otra cosa — que puede ser incluso utilizado otros
módulos.
Si el módulo no posee ninguna dependencia, tan solo se debe especificar el nombre como primer
argumento de require.def(). El segundo argumento es un objeto literal que define las propiedades
del módulo. Por ejemplo:
Definición de un módulo RequireJS que no posee dependencias
require.def("my/simpleshirt",
{
color: "black",
size: "unisize"
}
);
El ejemplo debe ser guardado en el archivo my/simpleshirt.js.
Si el modulo posee dependencias, es posible especificarlas en el segundo argumento de require.def()
a través de un vector) y luego pasar una función como tercer argumento. Esta función será llamada
para definir el módulo una vez cargadas todos las dependencias. Dicha función recibe los valores
devueltos por las dependencias como un argumento (en el mismo orden en que son requeridas en el
vector) y luego la misma debe devolver un objeto que defina el módulo.
Definición de un módulo RequireJS con dependencias
86

-- 87 of 107 --

require.def("my/shirt",
["my/cart", "my/inventory"],
function(cart, inventory) {
//devuelve un objeto que define a "my/shirt"
return {
color: "blue",
size: "large"
addToCart: function() {
inventory.decrement(this);
cart.add(this);
}
}
}
);
En este ejemplo, el modulo my/shirt es creado. Este depende de my/cart y my/inventory. En el
disco, los archivos están estructurados de la siguiente forma:
my/cart.js
my/inventory.js
my/shirt.js
La función que define my/shirt no es llamada hasta que my/cart y my/inventory hayan sido cargadas,
y dicha función recibe como argumentos a los módulos como cart y inventory. El orden de los
argumentos de la función debe coincidir con el orden en que las dependencias se requieren en el vector.
El objeto devuelto define el módulo my/shirt. Definiendo los módulos de esta forma, my/shirt no
existe como un objeto global, ya que múltiples módulos pueden existir en la página al mismo tiempo.
Los módulos no tienen que devolver un objeto; cualquier tipo de valor es permitido.
Definición de un módulo RequireJS que devuelve una función
require.def("my/title",
["my/dependency1", "my/dependency2"],
function(dep1, dep2) {
// devuelve una función para definir "my/title".
// Este devuelve o establece
// el titulo de la ventana
return function(title) {
return title ? (window.title = title) : window.title;
}
}
);
Solo un módulo debe ser requerido por archivo JavaScript.
Optimizar el Código con las Herramientas de RequireJS
Una vez incorporado RequireJS para el manejo de dependencias, la optimización del código es muy
fácil. Descargue el paquete de RequireJS y colóquelo en cualquier lugar, preferentemente fuera del
área de desarrollo web. Para los propósitos de este ejemplo, el paquete de RequireJS esta ubicado
en una carpeta paralela al directorio webapp (la cual contiene la página HTML y todos los archivos
JavaScript de la aplicación). La estructura de directorios es:
87

-- 88 of 107 --

requirejs/ (utilizado para ejecutar las herramientas)
webapp/app.html
webapp/scripts/app.js
webapp/scripts/require-jquery.js
webapp/scripts/jquery.alpha.js
webapp/scripts/jquery.beta.js
Luego, en la carpeta en donde se encuentran require-jquery.js y app.js, crear un archivo llamado
app.build.js con el siguiente contenido:
Archivo de configuración para las herramientas de optimización de RequireJS
{
appDir: "../",
baseUrl: "scripts/",
dir: "../../webapp-build",
//Comentar la siguiente línea si se desea
//minificar el código por el compilador
//en su modo "simple"
optimize: "none",
modules: [
{
name: "app"
}
]
}
Para utilizar la herramienta, es necesario tener instalado Java 6. Closure Compiler es utilizado para
la minificación del código (en caso que optimize: "none" esté comentado).
Para comenzar a procesar los archivos, abrir una ventana de comandos, dirigirse al directorio
webapp/scripts y ejecutar: