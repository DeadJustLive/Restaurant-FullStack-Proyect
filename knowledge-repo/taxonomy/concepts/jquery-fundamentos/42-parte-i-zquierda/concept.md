# parte i: zquierda.

## Fuente
jquery-fundamentos (Cap. 42)

## Contenido
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
Antes de comenzar con los patrones de organización de códig
