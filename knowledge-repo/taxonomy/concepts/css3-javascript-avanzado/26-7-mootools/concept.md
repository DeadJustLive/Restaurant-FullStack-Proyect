# 7. MooTools

## Fuente
css3-javascript-avanzado (Cap. 26)

## Contenido
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
7.3. AJ
