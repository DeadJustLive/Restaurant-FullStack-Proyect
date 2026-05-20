# 5. Añadir un nuevo div.module a la página después del último; luego añadir una copia de una de

las imágenes existentes dentro del nuevo div.
0.4. El núcleo de jQuery
0.4.1. $ vs $()
Hasta ahora, se ha tratado completamente con métodos que se llaman desde el objeto jQuery. Por
ejemplo:
$('h1').remove();
Dichos métodos son parte del espacio de nombres (en inglés namespace) $.fn, o del prototipo (en
inglés prototype) de jQuery, y son considerados como métodos del objeto jQuery.
Sin embargo, existen métodos que son parte del espacio de nombres de $ y se consideran como métodos
del núcleo de jQuery.
Estas distinciones pueden ser bastantes confusas para usuarios nuevos. Para evitar la confusión, debe
recordar estos dos puntos:
los métodos utilizados en selecciones se encuentran dentro del espacio de nombres $.fn, y au-
tomáticamente reciben y devuelven una selección en sí;
métodos en el espacio de nombres $ son generalmente métodos para diferentes utilidades, no
trabajan con selecciones, no se les pasa ningún argumento y el valor que devuelven puede variar.
Existen algunos casos en donde métodos del objeto y del núcleo poseen los mismos nombres, como
sucede con $.each y $.fn.each. En estos casos, debe ser cuidadoso de leer bien la documentación
para saber que objeto utilizar correctamente.
39

-- 40 of 107 --

0.4.2. Métodos Utilitarios
jQuery ofrece varios métodos utilitarios dentro del espacio de nombres $. Estos métodos son de gran
ayuda para llevar a cabo tareas rutinarias de programación. A continuación se muestran algunos
ejemplos, para una completa documentación sobre ellos, visite http://api.jquery.com/category/
utilities/.
$.trim Remueve los espacios en blanco del principio y final.
$.trim(' varios espacios en blanco ');
// devuelve 'varios espacios en blanco'
$.each Interactúa en vectores y objetos.
$.each([ 'foo', 'bar', 'baz' ], function(idx, val) {
console.log('elemento ' + idx + 'es ' + val);
});
$.each({ foo : 'bar', baz : 'bim' }, function(k, v) {
console.log(k + ' : ' + v);
});
Nota
Como se dijo antes, existe un método llamado $.fn.each, el cual interactúa en una
selección de elementos.
$.inArray Devuelve el índice de un valor en un vector, o -1 si el valor no se encuentra en el vector.
var myArray = [ 1, 2, 3, 5 ];
if ($.inArray(4, myArray) !== -1) {
console.log('valor encontrado');
}
$.extend Cambia la propiedades del primer objeto utilizando las propiedades de los subsecuentes
objetos.
var firstObject = { foo : 'bar', a : 'b' };
var secondObject = { foo : 'baz' };
var newObject = $.extend(firstObject, secondObject);
console.log(firstObject.foo); // 'baz'
console.log(newObject.foo); // 'baz'
Si no se desea cambiar las propiedades de ninguno de los objetos que se utilizan en $.extend, se debe
incluir un objeto vacío como primer argumento.
40

-- 41 of 107 --

var firstObject = { foo : 'bar', a : 'b' };
var secondObject = { foo : 'baz' };
var newObject = $.extend({}, firstObject, secondObject);
console.log(firstObject.foo); // 'bar'
console.log(newObject.foo); // 'baz'
$.proxy Devuelve una función que siempre se ejecutará en el alcance (scope) provisto — en otras
palabras, establece el significado de this (incluido dentro de la función) como el segundo argu-
mento.
var myFunction = function() { console.log(this); };
var myObject = { foo : 'bar' };
myFunction(); // devuelve el objeto window
var myProxyFunction = $.proxy(myFunction, myObject);
myProxyFunction(); // devuelve el objeto myObject
Si se posee un objeto con métodos, es posible pasar dicho objeto y el nombre de un método para
devolver una función que siempre se ejecuta en el alcance de dicho objeto.
var myObject = {
myFn : function() {
console.log(this);
}
};
$('#foo').click(myObject.myFn); // registra el elemento DOM #foo
$('#foo').click($.proxy(myObject, 'myFn')); // registra myObject
0.4.3. Comprobación de Tipos
Como se mencionó en el capítulo “Conceptos Básicos de JavaScript”, jQuery ofrece varios métodos
útiles para determinar el tipo de un valor específico.
Comprobar el tipo de un determinado valor
var myValue = [1, 2, 3];
// Utilizar el operador typeof de JavaScript para comprobar tipos primitivos
typeof myValue == 'string'; // falso (false)
typeof myValue == 'number'; // falso (false)
typeof myValue == 'undefined'; // falso (false)
typeof myValue == 'boolean'; // falso (false)
// Utilizar el operador de igualdad estricta para comprobar valores nulos (null)
myValue === null; // falso (false)
// Utilizar los métodos jQuery para comprobar tipos no primitivos
41

-- 42 of 107 --

jQuery.isFunction(myValue); // falso (false)
jQuery.isPlainObject(myValue); // falso (false)
jQuery.isArray(myValue); // verdadero (true)
jQuery.isNumeric(16); // verdadero (true). No disponible en versiones inferiores a jQuery 1.7
0.4.4. El Método Data
A menudo encontrará que existe información acerca de un elemento que necesita guardar. En Ja-
vaScript es posible hacerlo añadiendo propiedades al DOM del elemento, pero esta práctica conlleva
enfrentarse a pérdidas de memoria (en inglés memory leaks) en algunos navegadores. jQuery ofrece
una manera sencilla para poder guardar información relacionada a un elemento, y la misma biblioteca
se ocupa de manejar los problemas que pueden surgir por falta de memoria.
Guardar y recuperar información relacionada a un elemento
$('#myDiv').data('keyName', { foo : 'bar' });
$('#myDiv').data('keyName'); // { foo : 'bar' }
A través del método $.fn.data es posible guardar cualquier tipo de información sobre un elemento. Es
difícil exagerar la importancia de este concepto cuando se está desarrollando una aplicación compleja.
Por ejemplo, si desea establecer una relación entre el ítem de una lista y el div que hay dentro de este
ítem, es posible hacerlo cada vez que se interactúa con el ítem, pero una mejor solución es hacerlo una
sola vez, guardando un puntero al div utilizando el método $.fn.data:
Establecer una relación entre elementos utilizando el método $.fn.data
$('#myList li').each(function() {
var $li = $(this), $div = $li.find('div.content');
$li.data('contentDiv', $div);
});
// luego, no se debe volver a buscar al div;
// es posible leerlo desde la información asociada al item de la lista
var $firstLi = $('#myList li:first');
$firstLi.data('contentDiv').html('nuevo contenido');
Además es posible pasarle al método un objeto conteniendo uno o más pares de conjuntos palabra
clave-valor.
A partir de la versión 1.5 de la biblioteca, jQuery permite utilizar al método $.fn.data para obtener
la información asociada a un elemento que posea el atributo HTML5 data-*:
Elementos con el atributo data-*
<a id='foo' data-foo='baz' href='#'>Foo</a>
<a id='foobar' data-foo-bar='fol' href='#'>Foo Bar</a>
Obtener los valores asociados a los atributos data-* con $.fn.data
42

-- 43 of 107 --

// obtiene el valor del atributo data-foo
// utilizando el método $.fn.data
console.log($('#foo').data('foo')); // registra 'baz'
// obtiene el valor del segundo elemento
console.log($('#foobar').data('fooBar')); // registra 'fol'
Nota
A partir de la versión 1.6 de la biblioteca, para obtener el valor del atributo data-foo-bar
del segundo elemento, el argumento en $.fn.data se debe pasar en estilo CamelCase.
Nota
Para más información sobre el atributo HTML5 data-* visite http://www.w3.org/TR/
html5/global-attributes.html#embedding-custom-non-visible-data-with-the-data-attributes.
0.4.5. Detección de Navegadores y Características
Más allá que jQuery elimine la mayoría de las peculiaridades de JavaScript entre cada navegador,
existen ocasiones en que se necesita ejecutar código en un navegador específico.
Para este tipo de situaciones, jQuery ofrece el objeto $.support y $.browser (este último en desuso).
Una completa documentación sobre estos objetos puede encontrarla en http://api.jquery.com/
jQuery.support/ y http://api.jquery.com/jQuery.browser/
El objetivo de $.support es determinar qué características soporta el navegador web.
El objeto $.browser permite detectar el tipo de navegador y su versión. Dicho objeto está en desuso
(aunque en el corto plazo no está planificada su eliminación del núcleo de la biblioteca) y se recomienda
utilizar al objeto $.support para estos propósitos.
0.4.6. Evitar Conflictos con Otras Bibliotecas JavaScript
Si esta utilizando jQuery en conjunto con otras bibliotecas JavaScript, las cuales también utilizan la
variable $, pueden llegar a ocurrir una serie de errores. Para poder solucionarlos, es necesario poner a
jQuery en su modo “no-conflicto”. Esto se debe realizar inmediatamente después que jQuery se cargue
en la página y antes del código que se va a ejecutar.
Cuando se pone a jQuery en modo “no-conflicto”, la biblioteca ofrece la opción de asignar un nombre
para reemplazar a la variable $.
Poner a jQuery en modo no-conflicto
<script src="prototype.js"></script> // la biblioteca prototype
// también utiliza $
<script src="jquery.js"></script> // se carga jquery
// en la página
<script>var $j = jQuery.noConflict();</script> // se inicializa
// el modo "no-conflicto"
También es posible seguir utilizando $ conteniendo el código en una función anónima autoejecutable.
Éste es un patrón estándar para la creación de extensiones para la biblioteca, ya que $ queda encerrada
dentro del alcance de la misma función anónima.
Utilizar $ dentro de una función anónima autoejecutable
43

-- 44 of 107 --

<script src="prototype.js"></script>
<script src="jquery.js"></script>
<script>
jQuery.noConflict();
(function($) {
// el código va aquí, pudiendo utilizar $
})(jQuery);
</script>
0.5. Eventos
0.5.1. Introducción
jQuery provee métodos para asociar controladores de eventos (en inglés event handlers) a selectores.
Cuando un evento ocurre, la función provista es ejecutada. Dentro de la función, la palabra clave this
hace referencia al elemento en que el evento ocurre.
Para más detalles sobre los eventos en jQuery, puede consultar http://api.jquery.com/category/
events/.
La función del controlador de eventos puede recibir un objeto. Este objeto puede ser utilizado para
determinar la naturaleza del evento o, por ejemplo, prevenir el comportamiento predeterminado de
éste. Para más detalles sobre el objeto del evento, visite http://api.jquery.com/category/events/
event-object/.
0.5.2. Vincular Eventos a Elementos
jQuery ofrece métodos para la mayoría de los eventos — entre ellos $.fn.click, $.fn.focus,
$.fn.blur, $.fn.change, etc. Estos últimos son formas reducidas del método $.fn.on de jQuery
($.fn.bind en versiones anteriores a jQuery 1.7). El método $.fn.on es útil para vincular (en
inglés binding) la misma función de controlador a múltiples eventos, para cuando se desea proveer
información al controlador de evento, cuando se está trabajando con eventos personalizados o cuando
se desea pasar un objeto a múltiples eventos y controladores.
Vincular un evento utilizando un método reducido
$('p').click(function() {
console.log('click');
});
Vincular un evento utilizando el método $.fn.on
$('p').on('click', function() {
console.log('click');
});
Vincular un evento utilizando el método $.fn.on con información asociada
44

-- 45 of 107 --

$('input').on(
'click blur', // es posible vincular múltiples eventos al elemento
{ foo : 'bar' }, // se debe pasar la información asociada como argumento
function(eventObject) {
console.log(eventObject.type, eventObject.data);
// registra el tipo de evento y la información asociada { foo : 'bar' }
}
);
Vincular Eventos para Ejecutar una vez
A veces puede necesitar que un controlador particular se ejecute solo una vez — y después de eso,
necesite que ninguno más se ejecute, o que se ejecute otro diferente. Para este propósito jQuery provee
el método $.fn.one.
Cambiar controladores utilizando el método $.fn.one
$('p').one('click', function() {
console.log('Se clickeó al elemento por primera vez');
$(this).click(function() { console.log('Se ha clickeado nuevamente'); });
});
El método $.fn.one es útil para situaciones en que necesita ejecutar cierto código la primera vez que
ocurre un evento en un elemento, pero no en los eventos sucesivos.
Desvincular Eventos
Para desvincular (en ingles unbind) un controlador de evento, puede utilizar el método $.fn.off
pasándole el tipo de evento a desconectar. Si se pasó como adjunto al evento una función nombrada,
es posible aislar la desconexión de dicha función pasándola como segundo argumento.
Desvincular todos los controladores del evento click en una selección
$('p').off('click');
Desvincular un controlador particular del evento click
var foo = function() { console.log('foo'); };
var bar = function() { console.log('bar'); };
$('p').on('click', foo).on('click', bar);
$('p').off('click', bar); // foo esta atado aún al evento click
Espacios de Nombres para Eventos
Cuando se esta desarrollando aplicaciones complejas o extensiones de jQuery, puede ser útil utilizar
espacios de nombres para los eventos, y de esta forma evitar que se desvinculen eventos cuando no lo
desea.
Asignar espacios de nombres a eventos
45

-- 46 of 107 --

$('p').on('click.myNamespace', function() { /* ... */ });
$('p').off('click.myNamespace');
$('p').off('.myNamespace'); // desvincula todos los eventos con
// el espacio de nombre 'myNamespace'
Vinculación de Múltiples Eventos
Muy a menudo, elementos en una aplicación estarán vinculados a múltiples eventos, cada uno con
una función diferente. En estos casos, es posible pasar un objeto dentro de $.fn.on con uno o más
pares de nombres claves/valores. Cada clave será el nombre del evento mientras que cada valor será
la función a ejecutar cuando ocurra el evento.
Vincular múltiples eventos a un elemento
$('p').on({
'click': function() {
console.log('clickeado');
},
'mouseover': function() {
console.log('sobrepasado');
}
});
0.5.3. El Objeto del Evento
Como se menciona en la introducción, la función controladora de eventos recibe un objeto del evento,
el cual contiene varios métodos y propiedades. El objeto es comúnmente utilizado para prevenir la
acción predeterminada del evento a través del método preventDefault. Sin embargo, también contiene
varias propiedades y métodos útiles:
pageX, pageY La posición del puntero del ratón en el momento que el evento ocurrió, relativo a las
zonas superiores e izquierda de la página.
type El tipo de evento (por ejemplo “click”).
which El botón o tecla presionada.
data Alguna información pasada cuando el evento es ejecutado.
target El elemento DOM que inicializó el evento.
preventDefault() Cancela la acción predeterminada del evento (por ejemplo: seguir un enlace).
stopPropagation() Detiene la propagación del evento sobre otros elementos.
Por otro lado, la función controladora también tiene acceso al elemento DOM que inicializó el evento
a través de la palabra clave this. Para convertir a dicho elemento DOM en un objeto jQuery (y poder
utilizar los métodos de la biblioteca) es necesario escribir $(this), como se muestra a continuación:
var $this = $(this);
Cancelar que al hacer click en un enlace, éste se siga
$('a').click(function(e) {
var $this = $(this);
46

-- 47 of 107 --

if ($this.attr('href').match('evil')) {
e.preventDefault();
$this.addClass('evil');
}
});
0.5.4. Ejecución automática de Controladores de Eventos
A través del método $.fn.trigger, jQuery provee una manera de disparar controladores de eventos
sobre algún elemento sin requerir la acción del usuario. Si bien este método tiene sus usos, no debería
ser utilizado para simplemente llamar a una función que pueda ser ejecutada con un click del usuario.
En su lugar, debería guardar la función que se necesita llamar en una variable, y luego pasar el nombre
de la variable cuando realiza el vinculo (binding). De esta forma, podrá llamar a la función cuando lo
desee en lugar de ejecutar $.fn.trigger.
Disparar un controlador de eventos de la forma correcta
var foo = function(e) {
if (e) {
console.log(e);
} else {
console.log('esta ejecucción no provino desde un evento');
}
};
$('p').click(foo);
foo(); // en lugar de realizar $('p').trigger('click')
0.5.5. Incrementar el Rendimiento con la Delegación de Eventos
Cuando trabaje con jQuery, frecuentemente añadirá nuevos elementos a la página, y cuando lo haga,
necesitará vincular eventos a dichos elementos. En lugar de repetir la tarea cada vez que se añade un
elemento, es posible utilizar la delegación de eventos para hacerlo. Con ella, podrá enlazar un evento
a un elemento contenedor, y luego, cuando el evento ocurra, podrá ver en que elemento sucede.
La delegación de eventos posee algunos beneficios, incluso si no se tiene pensando añadir más elementos
a la página. El tiempo requerido para enlazar controladores de eventos a cientos de elementos no es
un trabajo trivial; si posee un gran conjunto de elementos, debería considerar utilizar la delegación de
eventos a un elemento contenedor.
Nota
A partir de la versión 1.4.2, se introdujo $.fn.delegate, sin embargo a partir de la versión
1.7 es preferible utilizar el evento $.fn.on para la delegación de eventos.
Delegar un evento utilizando $.fn.on
$('#myUnorderedList').on('click', 'li', function(e) {
var $myListItem = $(this);
// ...
});
47

-- 48 of 107 --

Delegar un evento utilizando $.fn.delegate
$('#myUnorderedList').delegate('li', 'click', function(e) {
var $myListItem = $(this);
// ...
});
Desvincular Eventos Delegados
Si necesita remover eventos delegados, no puede hacerlo simplemente desvinculándolos. Para eso,
utilice el método $.fn.off para eventos conectados con $.fn.on, y $.fn.undelegate para eventos
conectados con $.fn.delegate. Al igual que cuando se realiza un vinculo, opcionalmente, se puede
pasar el nombre de una función vinculada.
Desvincular eventos delegados
$('#myUnorderedList').off('click', 'li');
$('#myUnorderedList').undelegate('li', 'click');
0.5.6. Funciones Auxiliares de Eventos
jQuery ofrece dos funciones auxiliares para el trabajo con eventos:
$.fn.hover
El método $.fn.hover permite pasar una o dos funciones que se ejecutarán cuando los eventos
mouseenter y mouseleave ocurran en el elemento seleccionado. Si se pasa una sola función, está será
ejecutada en ambos eventos; en cambio si se pasan dos, la primera será ejecutada cuando ocurra el
evento mouseenter, mientras que la segunda será ejecutada cuando ocurra mouseleave.
Nota
A partir de la versión 1.4 de jQuery, el método requiere obligatoriamente dos funciones.
La función auxiliar hover
$('#menu li').hover(function() {
$(this).toggleClass('hover');
});
$.fn.toggle
Al igual que el método anterior, $.fn.toggle recibe dos o más funciones; cada vez que un evento
ocurre, la función siguiente en la lista se ejecutará. Generalmente, $.fn.toggle es utilizada con solo
dos funciones. En caso que utiliza más de dos funciones, tenga cuidado, ya que puede ser dificultar la
depuración del código.
La función auxiliar toggle
48

-- 49 of 107 --

$('p.expander').toggle(
function() {
$(this).prev().addClass('open');
},
function() {
$(this).prev().removeClass('open');
}
);
0.5.7. Ejercicios
Crear una “Sugerencia” para una Caja de Ingreso de Texto
Abra el archivo /ejercicios/index.html en el navegador. Realice el ejercicio utilizando el archivo
/ejercicios/js/inputHint.js o trabaje directamente con Firebug. La tarea a realizar es utilizar el
texto del elemento label y aplicar una “sugerencia” en la caja de ingreso de texto. Los pasos ha seguir
son los siguientes: