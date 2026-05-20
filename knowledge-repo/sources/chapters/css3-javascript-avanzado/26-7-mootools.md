# 7. MooTools

Tal y como mencionan en su web, MooTools es un framework Javascript mo-
dular, compacto y orientado a objetos. A diferencia de jQuery, de la que mu-
chos dicen que implementa un DSL (domain￿specific￿language), la MooTools
utiliza sólo Javascript, aumentándolo con herramientas potentes y sólidas.
Muchas veces la comparan con la Prototype, puesto que las dos basan su po-
tencia aumentando los objetos nativos a través de la cadena de prototipaje.
MooTools, sin embargo, queda mucho más compacta y modular.
MooTool significa my￿object￿oriented￿javascript￿tools.
7.1. Trabajando con el DOM
Toma directamente las ideas de la Prototype, y así tenemos dos funciones bá-
sicas: $('id'), que nos sirve para seleccionar nodos para ID, y la $$('css'), que
nos permite usar selectores CSS.
Por ejemplo:
$$('E￿F') Selecciona elementos F que son hijos de E.
$$('E[foo="bar"]') Selecciona elementos E que contengan un
atributo foo=="bar".
$$('E:first-child') Selecciona elementos E que son el primer hijo
de sus padres.
La biblioteca nos ofrece herramientas para desplazarse a través de los diferen-
tes nodos. Así, una vez seleccionado un nodo, disponemos de los métodos
getParent() y getParents(). El primero nos devuelve el padre, y el segundo,
una lista de todos los padres hasta la raíz.
Al mismo tiempo, disponemos de los métodos el.getElement(selector) y
el.getElements(selector), que nos permiten recuperar los hijos del nodo
que cumplan el selector. También disponemos de otros métodos, como
el.getFirst(tag_name) o el.getLast(tag_name), que devuelven el primer hijo
y el último que cumplan el tag definido como parámetro.
Para manipular los estilos CSS de un nodo, disponemos también de métodos,
así: el.hasClass('nombre') consulta si el nodo tiene asignada la clase CSS. Tam-
bién podemos hacer un el.addClass('nombre'), obviamente añadirá la clase
nombre, o .removeClass('borders'), lo que eliminará la clase borders. Así:
Web recomendada
Podemos descargar la librería
de:
http://mootools.net/down-
load
Si queremos hacer una des-
carga personalizada con com-
ponentes señalados, lo pode-
mos hacer de:
http://mootools.net/more/

-- 53 of 86 --

CC-BY-SA • PID_00176160 54 CSS3 y Javascript avanzado
$$('li.foo').addClass('bordered');
$$('li.foo').removeClass('bordered');
También nos ofrece el método toggleClass('class') para, de manera alternativa,
poner o sacar la clase en cuestión.
Podemos también manipular directamente los estilos asociados con un nodo
utilizando la función $$('li.bar').setStyle('font-weight:￿ bold'); o del mismo
modo el setStyles, que admite un objeto de parámetros. También el getStyle
y el￿getStyles.
Disponemos también de un sistema para trabajar con los atributos (o propie-
dades) de los nodos. Así, podemos .getProperty('type') o setProperty('type'),
que nos mirará o seteará el atributo tipo de un campo de formulario. En este
caso, también disponemos de las versiones multiples setProperties, y de remo-
veProperty() para eliminar propiedades.
Como el resto de las bibliotecas, desde Mootools también podemos crear/in-
yectar elementos en el DOM. Así:
var item1 = document.newElement('li',
{ class: 'bordered',
text: 'Second list item'
});
Generará un elemento que tendremos preparado para inyectarlo. Para hacerlo:
item2.inject(item1, 'inside');
También podremos usar estas otras fórmulas equivalentes a la anterior:
.injectBefore(el),.
injectAfter(el),.injectTop(el),.injectBottom(el),.injectInside(el)
Podemos clonar nodos con $('id').clone(). Los podemos sustituir:
var new_title = new Element('span', { text: 'New sublist' });
new_title.replaces(span1);
O les podemos hacer una envoltura (wrap):
var span1 = $$('#div4>ul>li>span')[0];
var strong = new Element('strong');
strong.wraps(span1, 'top');

-- 54 of 86 --

CC-BY-SA • PID_00176160 55 CSS3 y Javascript avanzado
También podemos eliminar nodos con los métodos .destroy(), que elimina el
nodo seleccionado, y el .empty(), que nos limpiará todo el árbol de hijos.
7.2. Sistema de eventos
Las herramientas de MooTools para gestionar los eventos son básicas. Funda-
mentalmente lo que hacen es parchear y solucionar las inconsistencias entre
los diferentes navegadores. Así, podemos capturar un evento de un nodo:
var first_handler = function(ev) {
ev.stopPropagation();
ev.preventDefault();
var el = ev.target;
el.toggleClass('clickcolor');
};
$('link1').addEvent('click', first_handler);
Mediante el stopPropagation rompemos la cadena de propagación y el pre-
ventDefault cancela el comportamiento por defecto del evento. La propiedad
Event.target da acceso al elemento involucrado en el evento.
Podemos añadir múltiples eventos a un elemento o a una lista utilizando el
método addEvents, y usando como parámetro un objeto tipo propiedad/fun-
ción￿manipuladora:
{
'click': function() {},
'rollover': function() {}
}
Para eliminar un evento o una lista de eventos, podemos usar
removeEvent('click',￿handler) o removeEvents('click'), sin necesitar una refe-
rencia en el manipulador.
7.3. AJAX
MooTools tiene una clase Request que sirve para hacer peticiones AJAX. Para
utilizarla:
var req1 = new Request({
method: 'GET',
url: 'data1.txt',
onRequest: function() {
$log("*** Firing request for " + this.options.url);
},
onSuccess: function(result_text, result_xml) {
$log("*** Loaded " + this.options.url);

-- 55 of 86 --

CC-BY-SA • PID_00176160 56 CSS3 y Javascript avanzado
$log("*** Data: " + result_text);
},
onFailure: function() {
$log("*** Request failed: " + this.status);
},
onException: function() {
$log("*** Exception occurred!");
$log(arguments);
})
req1.send();
Las dos primeras opciones del objeto parámetros facilitan el método de realizar
la petición y la url que se va a pedir. El resto son handlers que se desencadenarán
en los eventos que se generarán. Recordemos que el Javascript es asincrónico
(el hilo de ejecución no espera).
Cabe destacar que para todos los manipuladores la referencia this apunta al
objeto Request.
También podemos efectuar una petición con AJAX utilizando el sistema de
eventos:
var req2 = new Request();
req2.addEvent('success', function(txt, xml) {
$log("*** Data loaded: " + txt);
})
req2.addEvent('success', function(txt, xml) {
$log("*** Me too! Data loaded: " + txt);
});
req2.GET('data1.txt', { /* options */ })
Cuando la petición se complete, se ejecutarán las dos funciones.
7.4. Animación
Podemos manipular la posición de un objeto, un nodo con propiedades ab-
soultas CSS, con las funciones $('#exemple').position({￿x:￿150,￿y:￿10￿}), y tam-
bién podemos consultar la posición actual con el.getPosition(), que devuelve
un objeto de {x,y}.
Conseguiremos hacer animaciones con el módulo Fx.Tween:
var myFx = new Fx.Tween('myElement', {
duration: 'long',
transition: 'bounce:out',
property: 'height'
});

-- 56 of 86 --

CC-BY-SA • PID_00176160 57 CSS3 y Javascript avanzado
myFx.start('left', 0, 300)
Generamos una nueva instancia de animación, le damos los parámetros de
duración y el método de interpolación del movimiento, después utilizamos
el método start para dirigir la animación desde la coordenada x:0 hasta la
cordenada x:300.
Pero también existe un acceso directo a la función y que cuelga de la Class
Element. Recordemos que la función $() devuelve instancias.
$('myElement').tween('width', '100').
addEvent('onComplete', function() {
alert('fi');
});
Las animaciones también responden a eventos. En este último ejemplo, cuan-
do acabe la animación, ejecutamos una alerta de sistema.
Otra funcionalidad importante es la posibilidad de encadenar animaciones
con el método chain():
$('myElement').tween('left', '100')
.chain(function() {
$('myElement').tween('top', '200')
})
Primero movemos el objeto hasta la coordenada 100, después lo reposiciona-
mos hasta la 200 vertical.
7.5. Componentes (widgets)
Del mismo modo que en la biblioteca jQuery, en su núcleo no existen compo-
nentes, pero su naturaleza compacta y modular y la posibilidad de exhibirlos
en la propia página de la librería ha provocado que haya muchos desarrolla-
dores programando componentes para la librería.
Personalmente destacaría el árbol de archivos, un sistema de plantillas, un
sistema para recortar imágenes y otro para hacer los zoom.
Web recomendada
Podemos ver ejemplos aquí:
http://mootools.net/forge/

-- 57 of 86 --

CC-BY-SA • PID_00176160 58 CSS3 y Javascript avanzado