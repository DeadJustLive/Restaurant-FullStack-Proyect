# para sistemas windows

..\..\requirejs\build\build.bat app.build.js
Una vez ejecutado, el archivo app.js de la carpeta webapp-build contendrá todo el código de app.js
más el de jquery.alpha.js y jquery.beta.js. Si se abre el archivo app.html (también en la car-
peta webapp-build) podrá notar que ninguna petición se realiza para cargar jquery.alpha.js y
jquery.beta.js.
0.10.4. Ejercicios
Crear un Módulo Portlet
Abra el archivo /ejercicios/portlets.html en el navegador. Realice el ejercicio utilizando el archivo
/ejercicios/js/portlets.js. El ejercicio consiste en crear una función creadora de portlet que
utilice el patrón modular, de tal manera que el siguiente código funcione:
88

-- 89 of 107 --

var myPortlet = Portlet({
title : 'Curry',
source : 'data/html/curry.html',
initialState : 'open' // or 'closed'
});
myPortlet.$element.appendTo('body');
Cada portlet deberá ser un div con un título, un área de contenido, un botón para abrir/cerrar el
portlet, un botón para removerlo y otro para actualizarlo. El portlet devuelto por la función deberá
tener la siguiente API pública:
myPortlet.open(); // fuerza a abrir
myPortlet.close(); // fuerza a cerrar
myPortlet.toggle(); // alterna entre los estados abierto y cerrado
myPortlet.refresh(); // actualiza el contenido
myPortlet.destroy(); // remueve el portlet de la página
myPortlet.setSource('data/html/onions.html'); // cambia el código
0.11. Eventos Personalizados
0.11.1. Introducción a los Eventos Personalizados
Todos estamos familiarizados con los eventos básicos — click, mouseover, focus, blur, submit, etc.
— que surgen a partir de la interacción del usuario con el navegador.
Los eventos personalizados permiten conocer el mundo de la programación orientada a eventos (en
inglés event-driven programming). En este capítulo, se utilizará el sistema de eventos personalizados
de jQuery para crear una simple aplicación de búsqueda en Twitter.
En un primer momento puede ser difícil entender el requisito de utilizar eventos personalizados, ya
que los eventos convencionales permiten satisfacer todas las necesidades. Sin embargo, los eventos
personalizados ofrecen una nueva forma de pensar la programación en JavaScript. En lugar de enfocarse
en el elemento que ejecuta una acción, los eventos personalizados ponen la atención en el elemento en
donde la acción va a ocurrir. Este concepto brinda varios beneficios:
los comportamientos del elemento objetivo pueden ser ejecutados por diferentes elementos uti-
lizando el mismo código;
los comportamientos pueden ser ejecutados en múltiples, similares elementos objetivos a la vez;
los comportamientos son asociados de forma más clara con el elemento objetivo, haciendo que
el código sea más fácil de leer y mantener.
Un ejemplo es la mejor forma de explicar el asunto. Suponga que posee una lámpara incandescente
en una habitación de una casa. La lámpara actualmente esta encendida. La misma es controlada por
dos interruptores de tres posiciones y un clapper (interruptor activado por aplausos):
<div class="room" id="kitchen">
<div class="lightbulb on"></div>
<div class="switch"></div>
89

-- 90 of 107 --

<div class="switch"></div>
<div class="clapper"></div>
</div>
Ejecutando el clapper o alguno de los interruptores, el estado de la lampara cambia. A los interruptores
o al clapper no le interesan si la lámpara esta prendida o apagada, tan solo quieren cambiar su estado
Sin la utilización de eventos personalizados, es posible escribir la rutina de la siguiente manera:
$('.switch, .clapper').click(function() {
var $light = $(this).parent().find('.lightbulb');
if ($light.hasClass('on')) {
$light.removeClass('on').addClass('off');
} else {
$light.removeClass('off').addClass('on');
}
});
Por otro lado, utilizando eventos personalizados, el código queda así:
$('.lightbulb').on('changeState', function(e) {
var $light = $(this);
if ($light.hasClass('on')) {
$light.removeClass('on').addClass('off');
} else {
$light.removeClass('off').addClass('on');
}
});
$('.switch, .clapper').click(function() {
$(this).parent().find('.lightbulb').trigger('changeState');
});
Algo importante ha sucedido: el comportamiento de la lámpara se ha movido, antes estaba en los
interruptores y en el clapper, ahora se encuentra en la misma lámpara.
También es posible hacer el ejemplo un poco más interesante. Suponga que se ha añadido otra habi-
tación a la casa, junto con un interruptor general, como se muestra a continuación:
<div class="room" id="kitchen">
<div class="lightbulb on"></div>
<div class="switch"></div>
<div class="switch"></div>
<div class="clapper"></div>
</div>
<div class="room" id="bedroom">
<div class="lightbulb on"></div>
<div class="switch"></div>
<div class="switch"></div>
<div class="clapper"></div>
</div>
<div id="master_switch"></div>
90

-- 91 of 107 --

Si existe alguna lámpara prendida en la casa, es posible apagarlas a través del interruptor general, de
igual forma si existen luces apagadas, es posible prenderlas con dicho interruptor. Para realizar esta
tarea, se agregan dos eventos personalizados más a la lámpara: turnOn y turnOff. A través de una
lógica en el evento changeState se decide qué evento personalizado utilizar:
$('.lightbulb')
.on('changeState', function(e) {
var $light = $(this);
if ($light.hasClass('on')) {
$light.trigger('turnOff');
} else {
$light.trigger('turnOn');
}
})
.on('turnOn', function(e) {
$(this).removeClass('off').addClass('on');
})
.on('turnOff', function(e) {
$(this).removeClass('off').addClass('on');
});
$('.switch, .clapper').click(function() {
$(this).parent().find('.lightbulb').trigger('changeState');
});
$('#master_switch').click(function() {
if ($('.lightbulb.on').length) {
$('.lightbulb').trigger('turnOff');
} else {
$('.lightbulb').trigger('turnOn');
}
});
Note como el comportamiento del interruptor general se ha vinculado al interruptor general mientras
que el comportamiento de las lámparas pertenece a las lámparas.
Nota
Si esta acostumbrado a la programación orientada a objetos, puede resultar útil pensar de
los eventos personalizados como métodos de objetos. En términos generales, el objeto al que
pertenece el método se crea a partir del selector jQuery. Vincular el evento personalizado
changeState a todos los elementos $(‘.light’) es similar a tener una clase llamada
Light con un método changeState, y luego instanciar nuevos objetos Light por cada
elemento.
Recapitulación: $.fn.on y $.fn.trigger
En el mundo de los eventos personalizados, existen dos métodos importantes de jQuery: $.fn.on y
$.fn.trigger. En el capítulo dedicado a eventos se explicó la utilización de estos dos métodos para
trabajar con eventos del usuario; en este capítulo es importante recordar 2 puntos:
el método $.fn.on toma como argumentos un tipo de evento y una función controladora de
evento. Opcionalmente, puede recibir información asociada al evento como segundo argumento,
91

-- 92 of 107 --

desplazando como tercer argumento a la función controladora de evento. Cualquier información
pasada estará disponible a la función controladora a través de la propiedad data del objeto del
evento. A su vez, la función controladora recibe el objeto del evento como primer argumento;
el método $.fn.trigger toma como argumentos el tipo de evento y opcionalmente, puede tomar
un vector con valores. Estos valores serán pasados a la función controladora de eventos como
argumentos luego del objeto del evento.
A continuación se muestra un ejemplo de utilización de $.fn.on y $.fn.trigger en donde se utiliza
información personalizada en ambos casos:
$(document).on('myCustomEvent', { foo : 'bar' }, function(e, arg1, arg2) {
console.log(e.data.foo); // 'bar'
console.log(arg1); // 'bim'
console.log(arg2); // 'baz'
});
$(document).trigger('myCustomEvent', [ 'bim', 'baz' ]);
Un Ejemplo de Aplicación
Para demostrar el poder de los eventos personalizados, se desarrollará una simple herramienta para
buscar en Twitter. Dicha herramienta ofrecerá varias maneras para que el usuario realice una búsqueda:
ingresando el término a buscar en una caja de texto o consultando los “temas de moda” de Twitter.
Los resultados de cada término se mostrarán en un contenedor de resultados; dichos resultados podrán
expandirse, colapsarse, refrescarse y removerse, ya sea de forma individual o conjunta.
El resultado final de la aplicación será el siguiente:
Figura 11.1. La aplicación finalizada
Iniciación Se empieza con un HTML básico:
<h1>Twitter Search</h1>
<input type="button" id="get_trends"
value="Load Trending Terms" />
<form>
<input type="text" class="input_text"
id="search_term" />
<input type="submit" class="input_submit"
value="Add Search Term" />
</form>
<div id="twitter">
<div class="template results">
<h2>Search Results for
<span class="search_term"></span></h2>
</div>
</div>
92

-- 93 of 107 --

Figura 1: La aplicación finalizada
93

-- 94 of 107 --

El HTML posee un contenedor (#twitter) para el widget, una plantilla para los resultados (oculto
con CSS) y un simple formulario en donde el usuario puede escribir el término a buscar.
Existen dos tipos de elementos en los cuales actuar: los contenedores de resultados y el contenedor
Twitter.
Los contenedores de resultados son el corazón de la aplicación. Se creará una extensión para preparar
cada contenedor una vez que éste se agrega al contenedor Twitter. Además, entre otras cosas, la
extensión vinculará los eventos personalizados por cada contenedor y añadirá en la parte superior
derecha de cada contenedor botones que ejecutarán acciones. Cada contenedor de resultados tendrá
los siguientes eventos personalizados:
refresh Señala que la información del contenedor se esta actualizando y dispara la petición que busca
los datos para el término de búsqueda.
populate Recibe la información JSON y la utiliza para rellenar el contenedor.
remove Remueve el contenedor de la página luego de que el usuario confirme la acción. Dicha con-
firmación puede omitirse si se pasa true como segundo argumento del controlador de evento.
El evento además remueve el término asociado con el contenedor de resultados del objeto global
que contiene los términos de búsqueda.
collapse Añade una clase al contenedor, la cual ocultará el resultado a través de CSS. Además
cambiará el botón de “Colapsar” a “Expandir”.
expand Remueve la clase del contenedor que añade el evento collapse. Además cambiará el botón de
“Expandir” a “Colapsar”.
Además, la extensión es responsable de añadir los botones de acciones al contenedor, vinculando un
evento click a cada botón y utilizando la clase de cada ítem para determinar qué evento personalizado
será ejecutado en cada contenedor de resultados.
$.fn.twitterResult = function(settings) {
return this.each(function() {
var $results = $(this),
$actions = $.fn.twitterResult.actions =
$.fn.twitterResult.actions ||
$.fn.twitterResult.createActions(),
$a = $actions.clone().prependTo($results),
term = settings.term;
$results.find('span.search_term').text(term);
$.each(
['refresh', 'populate', 'remove', 'collapse', 'expand'],
function(i, ev) {
$results.bind(
ev,
{ term : term },
$.fn.twitterResult.events[ev]
);
}
);
// utiliza la clase de cada acción para determinar
// que evento se ejecutará en el panel de resultados
94

-- 95 of 107 --

$a.find('li').click(function() {
// pasa el elemento <li> clickeado en la función
// para que se pueda manipular en caso de ser necesario
$results.trigger($(this).attr('class'), [ $(this) ]);
});
});
};
$.fn.twitterResult.createActions = function() {
return $('<ul class="actions" />').append(
'<li class="refresh">Refresh</li>' +
'<li class="remove">Remove</li>' +
'<li class="collapse">Collapse</li>'
);
};
$.fn.twitterResult.events = {
refresh : function(e) {
// indica que los resultados se estan actualizando
var $this = $(this).addClass('refreshing');
$this.find('p.tweet').remove();
$results.append('<p class="loading">Loading ...</p>');
// obtiene la información de Twitter en formato jsonp
$.getJSON(
'http://search.twitter.com/search.json?q=' +
escape(e.data.term) + '&rpp=5&callback=?',
function(json) {
$this.trigger('populate', [ json ]);
}
);
},
populate : function(e, json) {
var results = json.results;
var $this = $(this);
$this.find('p.loading').remove();
$.each(results, function(i,result) {
var tweet = '<p class="tweet">' +
'<a href="http://twitter.com/' +
result.from_user +
'">' +
result.from_user +
'</a>: ' +
result.text +
' <span class="date">' +
result.created_at +
'</span>' +
'</p>';
95

-- 96 of 107 --

$this.append(tweet);
});
// indica que los resultados
// ya se han actualizado
$this.removeClass('refreshing');
},
remove : function(e, force) {
if (
!force &&
!confirm('Remove panel for term ' + e.data.term + '?')
) {
return;
}
$(this).remove();
// indica que ya no se tendrá
// un panel para el término
search_terms[e.data.term] = 0;
},
collapse : function(e) {
$(this).find('li.collapse').removeClass('collapse')
.addClass('expand').text('Expand');
$(this).addClass('collapsed');
},
expand : function(e) {
$(this).find('li.expand').removeClass('expand')
.addClass('collapse').text('Collapse');
$(this).removeClass('collapsed');
}
};
El contenedor Twitter, posee solo dos eventos personalizados:
getResults Recibe un término de búsqueda y comprueba si ya no existe un contenedor de resulta-
dos para dicho término. En caso de no existir, añade un contenedor utilizando la plantilla de
resultados, lo configura utilizando la extensión $.fn.twitterResult (mostrada anteriormente)
y luego ejecuta el evento refresh con el fin de cargar correctamente los resultados. Finalmente,
guarda el término buscado para no tener volver a pedir los datos sobre la búsqueda.
getTrends Consulta a Twitter el listado de los 10 primeros “términos de moda”, interactúa con
ellos y ejecuta el evento getResults por cada uno, de tal modo que añade un contenedor de
resultados por cada término.
Vinculaciones en el contenedor Twitter:
$('#twitter')
96

-- 97 of 107 --

.on('getResults', function(e, term) {
// se comprueba que ya no exista una caja para el término
if (!search_terms[term]) {
var $this = $(this);
var $template = $this.find('div.template');
// realiza una copia de la plantilla
// y la inserta como la primera caja de resultados
$results = $template.clone().
removeClass('template').
insertBefore($this.find('div:first')).
twitterResult({
'term' : term
});
// carga el contenido utilizando el evento personalizado "refresh"
// vinculado al contenedor de resultados
$results.trigger('refresh');
search_terms[term] = 1;
}
})
.on('getTrends', function(e) {
var $this = $(this);
$.getJSON('http://api.twitter.com/1/trends/1.json?callback=?', function(json) {
var trends = json[0].trends;
$.each(trends, function(i, trend) {
$this.trigger('getResults', [ trend.name ]);
});
});
});
Hasta ahora, se ha escrito una gran cantidad de código que no realiza nada, lo cual no esta mal. Se
han especificado todos los comportamientos que se desean para los elementos núcleos y se ha creado
un sólido marco para la creación rápida de la interfaz.
A continuación, se conecta la caja de búsqueda y el botón para cargar los “Temas de moda”. En la
caja de texto, se captura el término ingresado y se pasa al mismo tiempo que se ejecuta el evento
getResults. Por otro lado, haciendo click en el botón para cargar los “Temas de moda”, se ejecuta
el evento getTrends:
$('form').submit(function(e) {
e.preventDefault();
var term = $('#search_term').val();
$('#twitter').trigger('getResults', [ term ]);
});
$('#get_trends').click(function() {
$('#twitter').trigger('getTrends');
});
Añadiendo botones con un ID apropiado, es posible remover, colapsar, expandir y refrescar todos los
contenedores de resultados al mismo tiempo. Para el botón que remueve el contenedor, notar que se
97

-- 98 of 107 --

esta pasando true al controlador del evento como segundo argumento, indicando que no se desea una
confirmación del usuario para remover el contenedor.
$.each(['refresh', 'expand', 'collapse'], function(i, ev) {
$('#' + ev).click(function(e) { $('#twitter div.results').trigger(ev); });
});
$('#remove').click(function(e) {
if (confirm('Remove all results?')) {
$('#twitter div.results').trigger('remove', [ true ]);
}
});
Conclusión Los eventos personalizados ofrecen una nueva manera de pensar el código: ellos ponen
el énfasis en el objetivo de un comportamiento, no en el elemento que lo activa. Si se toma el tiempo
desde el principio para explicar las piezas de su aplicación, así como los comportamientos que esas
piezas necesitan exhibir, los eventos personalizados proveen una manera poderosa para “hablar” con
esas piezas, ya sea de una en una o en masa.
Una vez que los comportamientos se han descripto, se convierte en algo trivial ejecutarlos desde
cualquier lugar, lo que permite la rápida creación y experimentación de opciones de interfaz. Final-
mente, los eventos personalizados también permiten mejorar la lectura del código y su mantenimiento,
haciendo clara la relación entre un elemento y su comportamiento.
Puede ver la aplicación completa en los archivos demos/custom-events/custom-events.html y
demos/custom-events/js/custom-events.js del material que componen este libro.
0.12. Funciones y ejecuciones diferidas a través del objeto
$.Deferred
0.12.1. Introducción
A partir de la versión 1.5 de jQuery, la biblioteca introdujo una nueva utilidad: El objeto diferido
$.Deferred (en inglés Deferred Object). Este objeto introduce nuevas formas para la invocación y
ejecución de las funciones de devolución (callbacks), permitiendo crear aplicaciones más robustas y
flexibles. Para más detalles sobre $.Deferred, puede consultar http://api.jquery.com/category/
deferred-object/.
0.12.2. El objeto diferido y Ajax
El caso más común en donde se puede apreciar la utilidad del objeto diferido es en el manejo de las
funciones de devolución en peticiones Ajax.
Según se pudo apreciar en el capítulo dedicado, una manera de invocar una petición Ajax es:
Manera tradicional de utilizar el método $.ajax
$.ajax({
// la URL para la petición
url : 'post.php',
98

-- 99 of 107 --

// funciónes de devolución a ejecutar
// en caso que la petición haya sido
// satisfactoria, con error y/o completada
success : function(data) {
alert('Petición realizada satisfactoriamente');
},
error : function(jqXHR, status, error) {
alert('Disculpe, existió un problema');
},
complete : function(jqXHR, status) {
alert('Petición realizada');
}
});
Como se puede observar, las funciones de devolución son configuradas dentro del mismo objeto $.ajax.
Esta manera es incomoda y poco flexible ya que no permite desacoplar las funciones de devo-
lución de la misma petición Ajax. Y en grandes aplicaciones esto puede llegar a ser un problema.
El objeto diferido nos permite reescribir el código anterior de la siguiente manera:
El objeto diferido en una petición Ajax
// dentro de una variable se define
// la configuración de la petición ajax
var ajax = $.ajax({
url : 'post.php'
});
// a través del método done() ejecutamos
// la función de devolución satisfactoria (sucess)
ajax.done(function(){
alert('Petición realizada satisfactoriamente');
});
// a través del método fail() ejecutamos
// la función de devolución de error (error)
ajax.fail(function(){
alert('Disculpe, existió un problema');
});
// a través del método always() ejecutamos
// la función de devolución de petición completada (complete)
ajax.always(function(){
alert('Petición realizada');
});
A través de los métodos deferred.done, deferred.fail y deferred.always es posible desacoplar
las funciones de devolución de la misma petición Ajax, permitiendo un manejo más cómodo de las
mismas.
Notar que en en ningún momento se llama al objeto diferido $.Deferred. Esto es porque jQuery
ya lo incorpora implícitamente dentro del manejo del objeto $.ajax. Más adelante se explicará como
utilizar al objeto $.Deferred de manera explícita.
99

-- 100 of 107 --

De la misma forma es posible crear colas de funciones de devolución o atarlas a diferentes lógi-
cas/acciones:
Colas de funciones de devolución en una petición Ajax
// definición de la petición Ajax
var ajax = $.ajax({
url : 'post.php'
});
// primera función de devolución a ejecutar
ajax.done(function(){
alert('Primera función de devolución en caso satisfactorio');
});
// segunda función de devolución a ejecutar
// inmediatamente después de la primera
ajax.done(function(){
alert('Segunda función de devolución en caso satisfactorio');
});
// si el usuario hace click en #element se
// agrega una tercera función de devolución
$('#element').click(function(){
ajax.done(function(){
alert('Tercera función de devolución si el usuario hace click');
});
});
// en caso que exista un error se define otra
// función de devolución
ajax.fail(function(){
alert('Disculpe, existió un problema');
});
Al ejecutarse la petición Ajax, y en caso de que ésta haya sido satisfactoria, se ejecutan dos funciones
de devolución, una detrás de la otra. Sin embargo si el usuario hace click en #element se agrega
una tercera función de devolución, la cual también se ejecuta inmediatamente, sin volver a realizar la
petición Ajax. Esto es porque el objeto diferido (que se encuentra implícitamente en la variable ajax)
ya tiene información asociada sobre que la petición Ajax se realizó correctamente.
deferred.then
Otra manera de utilizar los métodos deferred.done y deferred.fail es a través de deferred.then,
el cual permite definir en un mismo bloque de código las funciones de devolución a suceder en los
casos satisfactorios y erróneos.
Utilización del método deferred.then
// definición de la petición Ajax
100

-- 101 of 107 --

var ajax = $.ajax({
url : 'post.php'
});
// el método espera dos funciones de devolución
ajax.then(
// la primera es la función de devolución satisfactoria
function(){
alert('Petición realizada satisfactoriamente');
},
// la segunda es la función de devolución errónea
function(){
alert('Disculpe, existió un problema');
}
);
0.12.3. Creación de objetos diferidos con $.Deferred
Así como es posible desacoplar las funciones de devolución en una petición Ajax, también es posible
realizarlo en otras funciones utilizando de manera explícita el objeto $.Deferred.
Por ejemplo, una función que verifica si un número es par, de la manera tradicional puede escribirse
de la siguiente manera:
Función sin utilizar el objeto $.Deferred
// función que calcula si un número entero es par o impar
var isEven = function(number) {
if (number%2 == 0){
return true;
} else {
return false;
}
}
// si es par registra un mensaje,
// en caso contrario registra otro
if (isEven(2)){
console.log('Es par');
} else {
console.log('Es impar');
}
Utilizando el objeto $.Deferred, el mismo ejemplo puede reescribirse de la siguiente forma:
Función utilizando el objeto $.Deferred
101

-- 102 of 107 --

// función que calcula si un número entero es par o impar
var isEven = function(number) {
// guarda en una variable al objeto $.Deferred()
var dfd = $.Deferred();
// si es par, resuelve al objeto utilizando deferred.resolve,
// caso contrario, lo rechaza utilizando deferred.reject
if (number%2 == 0){
dfd.resolve();
} else {
dfd.reject();
}
// devuelve al objeto diferido con su estado definido
return dfd.promise();
}
// con deferred.then se manejan las funciones de devolución
// en los casos que el numero sea par o impar
isEven(2).then(
// la primera es la función de devolución satisfactoria
function(){
console.log('Es par');
},
// la segunda es la función de devolución errónea
function(){
console.log('Es impar');
}
);
Los métodos deferred.resolve y deferred.reject permiten definir el estado interno del objeto
$.Deferred(). Esta definición es permanente, es decir, no es posible modificarla después y
es lo que permite manejar el comportamiento y ejecución de las funciones de devolución posteriores
para cada uno de los casos.
Notar que la función isEven devuelve el método deferred.promise. El mismo es una versión del
objeto diferido, pero que sólo permite leer su estado o añadir nuevas funciones de devolución.
Nota
En los ejemplos que utilizaban Ajax mostrados anteriormente, los métodos deferred.resolve
y deferred.reject son llamados de manera interna por jQuery dentro de la configuración
sucess y error de la petición. Por eso mismos se decía que el objeto diferido estaba
incorporado implícitamente dentro del objeto $.ajax.
Los métodos deferred.resolve y deferred.reject además permiten devolver valores para ser uti-
lizados por las funciones de devolución.
Función con deferred.resolve y deferred.reject devolviendo valores reutilizables
102

-- 103 of 107 --

// función que calcula si un numero entero es par o impar
var isEven = function(number) {
var dfd = $.Deferred();
// resuelve o rechaza al objeto utilizando
// y devuelve un texto con el resultado
if (number%2 == 0){
dfd.resolve('El número ' + number + ' es par');
} else {
dfd.reject('El número ' + number + ' es impar');
}
// devuelve al objeto diferido con su estado definido
return dfd.promise();
}
isEven(2).then(
function(result){
console.log(result); // Registra 'El número 2 es par'
},
function(result){
console.log(result);
}
);
Nota
Es posible determinar el estado de un objeto diferido a través del método deferred.state.
El mismo devuelve un string con alguno de estos tres valores: pending, resolved
o rejected. Para más detalles sobre deferred.state, puede consultar http:
//api.jquery.com/deferred.state/.
deferred.pipe
Existen casos en que se necesita modificar el estado de un objeto diferido o filtrar la información que
viene asociada. Para estos casos existe deferred.pipe. Su funcionamiento es similar a deferred.then,
con la diferencia que deferred.pipe devuelve un nuevo objeto diferido modificado a través de una
función interna.
Función filtrando valores utilizando deferred.pipe
// función que calcula si un número entero es par o impar
var isEven = function(number) {
var dfd = $.Deferred();
if (number%2 == 0){
103

-- 104 of 107 --

dfd.resolve(number);
} else {
dfd.reject(number);
}
return dfd.promise();
}
// vector con una serie de números pares e impares
var numbers = [0, 2, 9, 10, 5, 8, 12];
// a través de deferred.pipe se pregunta si número se encuentra
// dentro del vector numbers
isEven(2).pipe(
function(number){
// crea un nuevo objeto diferido
var dfd = $.Deferred();
if($.inArray(number, numbers) !== -1){
dfd.resolve();
} else {
dfd.reject();
}
// devuelve un nuevo objeto diferido
return dfd.promise();
}
).then(
function(){
// al estar dentro del vector numbers y ser par,
// se registra este mensaje
console.log('El número es par y se encuentra dentro de numbers');
},
function(){
console.log('El número es impar o no se encuentra dentro de numbers');
}
);
Para más detalles sobre deferred.pipe, puede consultar http://api.jquery.com/deferred.pipe/.
$.when
El método $.when permite ejecutar funciones de devolución, cuando uno o más objetos diferidos
posean algún estado definido.
104

-- 105 of 107 --

Un caso común de utilización de $.when es cuando se quiere verificar que dos peticiones Ajax separadas
se han realizado.
Utilización de $.when
// primera petición ajax
var comments = $.ajax({
url : '/echo/json/'
});
// segunda petición ajax
var validation = $.ajax({
url : '/echo/json/'
});
// cuando las dos peticiones sean realizadas
// ejecuta alguna función de devolución definida
// dentro de deferred.then
$.when(comments, validation).then(
function(){
alert('Peticiones realizadas');
},
function(){
alert('Disculpe, existió un problema');
}
);
Para más detalles sobre $.when, puede consultar http://api.jquery.com/jQuery.when/.
105

-- 106 of 107 --

Derechos de autor
Copyright ©2011
Material licenciado por Rebecca Murphey bajo la licencia Creative Commons Attribution-Share Ali-
ke 3.0 United States. Usted es libre de copiarlo, distribuirlo, transmitirlo y modificarlo, siempre y
cuando haga referencia a este repositorio y atribuya la autoría original a Rebecca Murphey. Si altera,
transforma o crea una obra derivada, deberá distribuir el resultado bajo una licencia igual, similar o
compatible. Cualquiera de las condiciones mencionadas pueden no aplicarse si obtiene permisos del
autor. Para cualquier reutilización o distribución, deberá dejar en claro la licencia la mejor manera
para hacerlo es a través de un enlace hacia la licencia Creative Commons Attribution-Share Alike 3.0
United States.

-- 107 of 107 --