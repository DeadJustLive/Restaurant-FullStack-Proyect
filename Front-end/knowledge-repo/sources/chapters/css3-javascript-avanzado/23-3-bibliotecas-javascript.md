# 3. Bibliotecas Javascript

3.1. ¿Por qué una biblioteca?
Javascript es el lenguaje de programación utilizado en el desarrollo de aplica-
ciones web por parte del cliente. Recordando un poco la historia, Javascript
como lenguaje nace en 1995 gracias a Netscape Corporation, que lo incorpora
como lenguaje de script en su primera versión del cliente de WWW. Paralela-
mente, Microsoft inicia el desarrollo de su cliente de WWW, Internet￿Explo-
rer, y copia el lenguaje de Netscape pero cambiándole el nombre por el de
jScript. Realmente los dos lenguajes son muy parecidos, pero diferentes.
Desde el principio se generan diferencias en el uso, con el modo en el que
se interactúa con el DOM (document object model), el sistema de eventos, y en
otras muchas pequeñas peculiaridades que los hacen diferentes. Así, nos en-
contramos con un lenguaje que debe interactuar con modelos de clases dife-
rentes y utiliza sistemas de eventos distintos.
Al principio la programación de cliente era terriblemente difícil, puesto que
había que trabajar con cada una de las especificaciones para los diferentes na-
vegadores, lo que provocaba que el código que se generaba fuera poco sólido y
mantenible. Fácilmente podías encontrarte desarrollada una pequeña función
con dos condicionales para cada especificación de navegador.
Para solucionar estos problemas de interacción del lenguaje con los navega-
dores, nacieron bibliotecas cuyo objetivo es conseguir una API (application
programming￿interface) común a los diferentes navegadores.
De este modo, en este capítulo expondremos lo que, a nuestro entender, son
las principales bibliotecas que existen en el trabajo de Javascript en el desarro-
llo de aplicaciones web. Pero antes haremos una primera especificación de las
tareas que necesitamos para desarrollar aplicaciones web en el cliente, para así
poder evaluar y ver cómo tratan esto las diferentes bibliotecas.
3.2. ¿Qué nos ha de ofrecer una biblioteca Javascript?
Fundamentalmente una solución a los dos retos básicos que afrontamos cuan-
do desarrollamos aplicaciones web:

-- 26 of 86 --

CC-BY-SA • PID_00176160 27 CSS3 y Javascript avanzado
• Interactuar con el DOM. Seleccionar, añadir, modificar y borrar no-
dos. Seleccionar conjuntos de nodos y aplicarles estilos CSS. Gene-
rar nuevo contenido.
• Interactuar con el usuario mediante el sistema de eventos: capturar
acciones de ratón, de teclado y procesarlas correspondientemente.
Además, también nos debería ofrecer un sistema unificado de comunicación
con el servidor de manera asincrónica (AJAX), un sistema para poder trabajar
con formularios de datos (un modo de interacción con el DOM) y una especi-
ficación de componentes de software de tipo widget que nos permitan expan-
dir las funcionalidades propias del navegador.
Pero una biblioteca usualmente también ofrece un conjunto de convenciones
a la hora de desarrollar software, esto es, una manera de hacer, una filosofía
de trabajo.
Así, podemos afirmar que una biblioteca para Javascript nos debe permitir
desarrollar nuestras aplicaciones web, de tal manera que no nos debamos preo-
cupar por las diferencias e incompatibilidades entre navegadores.
3.3. ¿Qué bibliotecas estudiaremos?
Actualmente existen multitud de bibliotecas para Javascript, pero aquí nos in-
teresa estudiar sólo las más importantes. Así, buena parte del trabajo lo reali-
zaremos con uno de las más extendidas, el jQuery, creado por John Resig. Se
estima que tres de cada cuatro websites que utilizan una biblioteca javascript la
usan, y la utilizan también empresas como Amazon, Microsoft, BBC o Twitter.
Seguramente también es la más fácil de utilizar. Con ella aprenderemos cómo
manipular el DOM, cómo trabajar con eventos, cómo generar peticiones al
servidor no-sincrónicas y cómo utilizar su capa de componentes (jquery-ui).
Estudiaremos el prototype, que fue una de las primeras bibliotecas utilizadas
y de la que se sirven gente como la propia Apple. También veremos, de paso,
la biblioteca YUI (escrita para Yahoo) y la Motools.
De todas ellas veremos los dos pilares básicos: la interacción con el DOM y el
sistema de eventos.

-- 27 of 86 --

CC-BY-SA • PID_00176160 28 CSS3 y Javascript avanzado
4. jQuery
4.1. Obtener jQuery
Podemos descargar jQuery de su web: www.jquery.com, pero también la pode-
mos utilizar directamente desde los CDN￿(content￿delivery￿network) de Goo-
gle. Si accedemos a su web, vemos que disponemos de dos versiones diferentes
(production,￿minified￿and￿gziped), versión preparada para entornos de pro-
ducción con el código comprimido y optimizado para ocupar muy pocos Kb
de descarga, o la versión de desarrollo. Sólo descargaremos esta última si lo
que queremos es revisar y leer el código de la propia librería. Podéis ver cómo
está hecha, puesto que la versión de producción es completamente utilizable.
Por otro lado, si queremos podemos utilizarla desde un CDN. Esta manera es
recomendada por la comunidad. Un CDN es una red de distribución de con-
tenidos a nivel global, con servidores geolocalizados de manera óptima para
mejorar los tiempos de descarga. De este modo, si enlazamos la librería desde
aquí, cuando el cliente de web intente descargarla muchas veces se encontrará
con que ya la tiene en la memoria￿caché.
Sea como fuere, habrá que enlazar la librería en nuestro documento html. Para
ello, utilizaremos la etiqueta estándar de html, <script>, del siguiente modo:
<script type="text/javascript" src="jquery.js"></script>
O bien utilizaremos la etiqueta con una dirección CDN.
<script type="text/javascript"
src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
Una vez hecho esto, ya podremos empezar a utilizar la librería completa para
realizar nuestras aplicaciones.
4.2. Cómo funciona jQuery: el objeto $
Como veremos más adelante, algunos de los frameworks de Javascript se orga-
nizan a partir de un objeto global. De este modo, el espacio de memoria que-
da limpio y se puede implementar la librería en espacios complejos con otras
muchas funciones.

-- 28 of 86 --

CC-BY-SA • PID_00176160 29 CSS3 y Javascript avanzado
jQuery utiliza el símbolo $() como función que nos permitirá interactuar con la
librería. De hecho, el símbolo $ es un simple sinónimo de la verdadera función
window.jQuery, así:
var jQuery = window.jQuery = window.$
A partir de esta función, se organizan todas las funcionalidades de la librería y
ella nos sirve para realizar cualquier operación. Para compatibilizar con otras
bibliotecas (Prototype utiliza el mismo símbolo), jQuery nos ofrece la función
jQuery.noConflict(); que desactiva el símbolo $() dejándolo con jQuery().
4.3. Interactuando con el DOM
El núcleo de jQuery es interactuar con el DOM. De hecho, la función $() nos
permite "seleccionar", recuperar referencias a elementos del DOM y, a partir
de aquí, empezar a interactuar con el lenguaje de programación. No es con-
vencional, puesto que no sigue la estructura usual de programación de aplica-
ciones, pero sí que es muy práctico, puesto que el 80% de lo que programamos
en el navegador se hace empleando algún elemento del DOM. Para aclarar un
poco el asunto, lo mejor es ver un ejemplo.
<html>
<head>
<title>Ejercicio jQuery 2</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"> </script>
<script type="texto/javascript">
<!--
$(document).ready(function(){ // 1
var resultat = $('#p1').text(); // 2
alert(resultat)
})
//-->
</script>
</head>
<body>
<p id="p1">¡Hola Mundo!</p>
< /body>
</html>
El código que aparece en 1 todavía no es relevante, pero sirve para programar
el evento DOM￿disponible. Si nos fijamos en la parte de 2 con $('#p1'), selec-
cionamos el elemento con ID igual a p1. De hecho, lo que nos devuelve la
función￿$ es una instancia de la librería jQuery inicializada con el elemento
p del DOM. A partir de aquí, el método text(), nos devuelve el contenido del
nodo como cadena de texto. Después, lo guardamos en la variable resultado
y la mostramos efectuando una alerta.

-- 29 of 86 --

CC-BY-SA • PID_00176160 30 CSS3 y Javascript avanzado
4.3.1. Selectores, filtros y CSS
Como muy bien se puede ver en el ejemplo anterior, la función $() recibe un
selector CSS y devuelve la instancia del objeto. La cuestión es ver qué selectores
podemos utilizar.
Como hemos visto en el ejemplo anterior, el primer selector es el #, igual que
con CSS. Esto nos permite seleccionar elementos ID. Del mismo modo, pode-
mos utilizar selectores con clases CSS. Así, la llamada $('.estilo1') seleccionará
todos los elementos que tengan asociada la clase estilo1. Como vemos, utili-
zamos el mismo lenguaje que ya conocemos con CSS a la hora de interactuar
con el DOM.
Cabe destacar que ambas llamadas devuelven una instancia de la biblioteca
lista para ser utilizada, con la diferencia de que en la primera nos devuelve
la instancia inicializada con un único elemento, y en la segunda, con un con-
junto de elementos. El modo en el que hemos seleccionado los elementos del
DOM era una técnica habitual para manipular en tiempo de ejecución el con-
tenido del html.
Casi siempre podemos aplicar la misma regla de CSS a los selectores de jQuery,
y encontramos:
$('*') Todos los elementos
$('#propiedad) Elemento con ID=propiedad
$('.clase') Elementos que tienen la clase CSS
$('img') Elementos
$('img,p,selectorN') Combina los elementos img, p, selec-
torN
Igual que con CSS3, podemos seleccionar por atributo así:
$('a[rel="nofollow"]') Todos los a con el atributo rel="nofollow".
$('[atributo|="valor"]') Atributo que sea o empiece por valor.
$('[attribute="value"]') Atributo que contenga el valor delimitado por
espacios.
$('[atributo￿="valor"]') Que el atributo no tenga el valor.
$('[atributo^="valor"]') Que el valor del atributo empiece por valor.
$('[atributo$="valor"]') Que el valor del atributo acabe con...
$('[atributo]') Que el elemento contenga el atributo.
$('[atributo1="1"][atributo2="2]') Que contengan todos los atributos con valo-
res.

-- 30 of 86 --

CC-BY-SA • PID_00176160 31 CSS3 y Javascript avanzado
Del mismo modo que en CSS3, también disponemos de filtros, pero no es
necesario preocuparse de la compatibilidad de las diferentes versiones de los
navegadores admitiendo ciertas propiedades, puesto que esto es trabajo de la
biblioteca. Así, podemos utilizar filtros como:
$('tr:first-child') La primera fila de una tabla. También pode-
mos emplear :last-child, y :nth-child(4n).
$("tr:even") Fila impar, también par con odd.
$('tr:eq(3)') El tercer elemento del conjunto seleccionado.
En este caso, la tercera fila del conjunto de to-
das las tablas de la página. También, podemos
emplear:
• gt(n) conjunto de elementos a partir de n
(el enésimo elemento no incluido)
• lt(n) conjunto menor que n
• not(n) todos, excepto n
$('tr:first') El primer elemento. También podemos con el
último empleando :last.
También podemos filtrar elementos en función del contenido que tienen, así:
$("div:contains('Libro')") Seleccionará los elementos div en cuyo conte-
nido aparezca la palabra libro.
$("div:has(p)") Elementos div que contengan otro elemento
p.
$("td:parent") Elementos que son padres de otro nodo, in-
cluidos nodos de texto.
Finalmente, para completar el apartado de selectores, hay que ver una nueva
funcionalidad y detallar una diferencia en los objetos que nos devuelve.
Cuando seleccionamos múltiples objetos, como por ejemplo $('img')￿para￿se-
leccionar￿todas￿las￿imágenes, el objeto que nos devuelve jQuery es una ins-
tancia normal aumentada con las funciones de lista (iterable). jQuery ofrece
una función, .each, que nos permite iterar por los diferentes elementos que
hemos seleccionado. Así, podríamos escribir el siguiente código:
$('img').each(function(index, element) {
console.log( element.src )
});
Que iterará por todas las imágenes del documento. Para saber si un selector nos
ha devuelto un conjunto o sólo un elemento, podemos consultar la propiedad
length, así:
$('img').length; // devolverá el total de imágenes que contiene el documento.

-- 31 of 86 --

CC-BY-SA • PID_00176160 32 CSS3 y Javascript avanzado
Como nueva funcionalidad, cabe decir que la función $() admite un segun-
do parámetro que nos permite definir el contexto en el que queremos que se
realice la búsqueda del selector. Por defecto, si el parámetro no existe, la fun-
ción realiza la búsqueda en todo el documento. Si aplicamos un contexto, sólo
la realizará en el contexto, así:
<div><p>Content</p></div>
<div id="p1">
<p>Content 2</p>
< /div>
$('p', $('#p1') );
Devolverá sólo el segundo p, puesto que es lo único que encontramos dentro
del contexto de #p1.
4.4. Manipulando el DOM
Ahora que ya sabemos seleccionar elementos de un documento, podemos ir un
paso más allá y empezar a manipularlos. Podemos cambiarles las propiedades
CSS, leer y modificar sus atributos, copiarlos, eliminarlos y añadir más.
4.4.1. Propiedades CSS
Seleccionados un conjunto de elementos, podemos manipular sus propiedades
CSS con el método .css, así:
$('p').css('color', 'red);
Cambiará el color del texto de todos los párrafos a rojo. Pero también podemos
cambiar muchas propiedades a la vez. Para ello, la función recibirá un objeto
Javascript y quedará en el siguiente formato:
$('p').css({ 'color': 'grey',
'padding': '5px',
'background-color': 'yellow' });
La mayoría de los métodos del objeto jQuery que pueden admitir un par de
parámetros también pueden admitir un objeto, y así realizar mucho más tra-
bajo de una sola vez.
De la misma manera que los podemos cambiar, también los podemos consul-
tar pidiendo la propiedad:
$('p').css('color')
Nos devolverá el color del elemento p.

-- 32 of 86 --

CC-BY-SA • PID_00176160 33 CSS3 y Javascript avanzado
Hay que decir que existen algunos métodos en modo de acceso directo, como
por ejemplo:
.show() Nos mostrará el elemento si estaba escondido.
.hide() Lo esconderá.
.toggle() Actúa a modo de interruptor. Si el elemento
está escondido, lo muestra, y si el elemento
está visible, lo esconde.
También, y desde Javascript, con jQuery podemos añadir una nueva clase CSS
a un elemento seleccionado con la siguiente orden:
$('#id').addClass('nombredelaclase')
O podemos consultar si tiene asignada la clase con:
$('#id').hasClass('nombredelaclase')
O la podemos eliminar:
$('#id').removeClass('nombredelaclase')
También podemos manipular y consultar la altura y anchura de un elemento
mediante los métodos .height() y .width(), que nos sirven tanto para asignar
una altura y anchura, como para consultar la altura y anchura reales. Se debe
tener en cuenta que la medida de un elemento que nos dará las funciones no
computa los paddings. La medida con padding, pero sin el border, la podemos
saber si consultamos los métodos innerHeight() e innerWidth().
4.4.2. Atributos de los nodos
Del mismo modo que podemos consultar o modificar propiedades CSS, jQuery
nos facilita una fórmula para interactuar con los atributos de cada nodo utili-
zando la función:
<img width="34" />
$('img').attr('width', '44')
Igual que el CSS, el método también admite un objeto como parámetro y,
en su defecto, si sólo le enviamos un parámetro que es una propiedad, nos
devolverá el valor pertinente.

-- 33 of 86 --

CC-BY-SA • PID_00176160 34 CSS3 y Javascript avanzado
4.4.3. Añadir contenido en el DOM
Para insertar contenido dentro del DOM, disponemos de tres fórmulas básicas
en relación con la selección correspondiente:
1)￿Añadir￿envolviendo
La acción de añadir un nodo envolviendo .wrap el selector en curso generará
lo siguiente:
<p id="un">Una prueba</p>
$('.inner').wrap('<div class="new" />');
<div class="new">
<p id="un">Una prueba</p>
< /div>
De este modo, cuando hagamos un .wrap de un selector, lo que haremos será
envolverlo con la etiqueta indicada. De la misma manera, podemos hacer un
.unwrap().
Existe también el método .wrapAll, que envolverá todo el conjunto de selec-
tores en un único div.
2)￿Añadir￿dentro
Nos añadirá el contenido, pasado como parámetro, en diferentes posiciones
del selector en función del método que usemos:
.append('content') Añade el contenido al final del selector.
.prepend() Añade el contenido al principio del selector.
.html() Recupera el contenido de un selector o se lo
asigna. Siempre contenido html.
.text() Recupera el texto de un selector sin etiquetas.
También lo asigna.
3)￿Añadir￿fuera
$().after(),￿$().before() inserta los elementos seleccionados justo el nodo an-
tes o después del seleccionado. Si la selección nos devuelve diferentes nodos,
efectuará la operación para cada uno de ellos.

-- 34 of 86 --

CC-BY-SA • PID_00176160 35 CSS3 y Javascript avanzado
4.4.4. Borrar nodos
Dado cualquier selector, lo podemos borrar simplemente ejecutando el méto-
do .remove(). También podemos utilizar el método .empty(), que vaciará el
contenido de un nodo, incluido texto plano.
4.5. Funciones generales
Como biblioteca o marco de trabajo, jQuery nos ofrece una serie de extensio-
nes, métodos o funciones que nos permiten añadir pequeñas utilidades y fun-
cionalidades al Javascript:
$.each(￿collection,￿callback(indexInArray,￿valueOfElement)￿)
Es una función que nos permite programar iteraciones. Supongamos lo si-
guiente:
a = [1,2,3,4,5]
resultado = 0
$.each(a, function(index, valor) { resultado += a }
alert('el resultado es' + a)
Como collection, le podemos pasar cualquier elemento que sea iterable en
Javascript, como por ejemplo, un array o el resultado de un selector. De hecho,
un patrón común cuando queremos realizar cosas con un conjunto sería:
$('.item').each(function(ind) {
$(ind).text()
})
En el ejemplo anterior, iteraríamos por la colección de nodos que tienen asig-
nado el estilo item. En este patrón, es muy interesante saber que $(ind) es el
nodo actual.
También podríamos iterar sobre las propiedades de un objeto o hash:
$.each( { name: "Pere", lang: "JS" }, function(k, v){
alert( "Clave: " + k + ", Valor: " + v );
});
$.extend({},￿objeto1,￿objeto2)
El método extend nos permite añadir propiedades a un objeto definido previa-
mente:
a = {un: 'hola', dos:'dos' }
b = {un:'sí', tres:'quepasa'}

-- 35 of 86 --

CC-BY-SA • PID_00176160 36 CSS3 y Javascript avanzado
$.extend(a, b)
a == {un:'sí', tres:'quepasa', dos:'dos'}
Es de gran utilidad para escribir código modular, puesto que nos permite de
una manera muy fácil ampliar objetos con propiedades y métodos de otros.
Una aplicación práctica es la creación de mixins, objetos que amplían la fun-
cionalidad de otros, como por ejemplo:
var a = {
'hola': function() { return 1; },
'adiós': function() { return 2; } }
var mixin = { 'hola': function() { return 2; } }
$.extend(a, mixin)
console.info( a.hola() == 2 )
console.info( a.adiós() == 2 )
Si nos fijamos en el ejemplo, disponemos de un objeto A que tiene una función
hola que devuelve 1. Pero después le aplicamos, con el método $.extend, el
objeto mixin sobrescribiendo la función hola.
Al final del ejemplo, podemos ver cómo a.hola() ya no devuelve 1, sino que
devuelve 2, puesto que ha sido sobrescrita (extendida).
Si revisamos el código fuente de jQuery, apreciaréis que la mayoría de los mé-
todos nuevos los instalan de este modo. También lo podemos hacer exten-
diendo la cadena de prototipaje:
$.extend(a.prototype, mixin)
Que nos generaría métodos públicos del objeto A, mientras que el A del ejem-
plo simplemente es un paquete de funciones (namespace).
$.inArray(valor,￿array)
Busca valor en lista. Si no lo encuentra, devuelve -1. Si lo encuentra, devuelve
la posición >0.
$.isArray(p)
Devuelve true, si p es un array.
$.merge(a,￿b)

-- 36 of 86 --

CC-BY-SA • PID_00176160 37 CSS3 y Javascript avanzado
Mezcla el contenido de a y b, devolviendo un nuevo array.
4.6. Sistema de eventos
Tan importante como poder manipular fácilmente el DOM desde nuestros
programas, el otro gran pilar de las bibliotecas de Javascript es la gestión de los
eventos (events). Sabido es para todos los que se han querido enfrentar a esta
tarea sin utilizar ningún framework que la cosa no es trivial, puesto que cada
navegador nos ofrece un sistema de eventos diferente.
Generalmente, un evento, en jQuery, se escucha mediante el pedido .bind.
Así, para poder capturar los clics en todos los enlaces, podemos escribir:
$('a').bind('click', function() {
contador += 1
})
Siempre sigue el mismo patrón: seleccionamos el nodo al que queremos asig-
nar el evento, y con la orden bind, le podemos asignar el evento que deseemos.
Por ejemplo, para asignar un evento change a un campo desplegable (select),
escribiremos:
$('#idselect').bind('change', manipulador)
Donde manipulador puede ser, como en el caso anterior, una función anóni-
ma o puede ser el nombre de una función (la variable que contiene el objeto
función).
Cabe decir que a partir de la versión de jQuery 1.4, a la función bind le po-
demos asignar un objeto que contenga una lista de eventos mapeados, como
por ejemplo:
$('a').bind({
'mousenter': function(evt) {
$(this).css('color', 'black')
},
'click': function(evt) {
$(this).toggle();
}
});
Es importante destacar que en la función manipuladora del event, la variable
this apunta al nodo del DOM que la desencadena, y que por lo tanto la orden
$(this) selecciona el propio nodo.
Web recomendada
Podéis encontrar muchas
más utilidades en la direc-
ción:
http://api.jquery.com/cate-
gory/utilities/

-- 37 of 86 --

CC-BY-SA • PID_00176160 38 CSS3 y Javascript avanzado
Asimismo, la función recibe un parámetro que contiene un objeto de tipo
event. Este parámetro a menudo es omitido, pero con él podemos acceder a
información adicional en el momento de generación del evento y durante su
propagación. Con jquery el sistema de eventos sigue una regla de propagación
en burbuja (bubbling), que cuando un evento es generado en un nodo se pro-
paga hacia sus padres. Imaginemos el siguiente ejemplo:
$(document).ready(function(){
$('tr').click(function(){
alert('clic a tr');})
.height(30)
.css( 'background-color', '#eaeaea');
$('a').click(function(e){
alert('clic a a');
e.stopPropagation()
});
});
</script>
</head>
<body>
<table style="border:1px solid black;">
<tr>
<td><a>Hola</a></td>
</tr>
</table>
Si hiciéramos clic en el enlace a, lo capturaríamos desde la función del evento,
pero como el evento seguiría su proceso de propagación, también ejecutaría
el manipulador asignado al nodo padre tr, y nos generaría un doble alert(),
el del elemento a y el del elemento tr. Es decir, se ejecutarían ambos eventos.
Para impedir esto y romper la cadena de propagación, utilizaremos el objeto
evento que recibe el manipulador y llamaremos al método .stopPropagation()
tal y como hemos hecho en el ejemplo.
En el objeto evento también podemos encontrar otros datos, como las propie-
dades pageX y pageY, que son las coordenadas de ratón en las que se ha des-
encadenado el event. También, dentro de este objeto encontramos propieda-
des como target, que es el objeto que genera el evento, o currentTarget, que
es el objeto desde el que se ha iniciado la propagación.
Del mismo modo que asignamos un evento con el método bind, lo podemos
desasignar con el método .unbind. Así:
$('tr').unbind('click');

-- 38 of 86 --

CC-BY-SA • PID_00176160 39 CSS3 y Javascript avanzado
Los eventos pueden ser ejecutados de manera manual usando el comando
.trigger('nombrevento'); así, si hacemos:
$('tr').trigger('click');
Se ejecutará el handler asignado al tal evento (siempre y cuando lo hayamos
asignado a priori). Del mismo modo, podemos generar nuestros propios even-
tos.
Imaginemos que tenemos un reloj y queremos que nos notifique el tiempo
cada segundo. Podemos, desde la función que controla el tiempo que pasa,
generar un evento de tipo 'segundo' (el nombre es a voluntad nuestra), como
hemos realizado en el ejemplo siguiente:
var segundos = 0
setInterval(function(){
$('#p1').text( ++segundos )
.trigger('segundo', [segundos])
}, 1000)
$('#p1').bind('segundo', function(evento, fecha){
if(fecha==10) segundos = 0
})
Utilizamos el elemento #p1 para que nos genere un evento de segundo, des-
pués lo capturamos y hacemos que la variable que cuenta los segundos que
pasan se inicialice cuando llega a 10. Para que esto funcione, necesitamos te-
ner un nodo con id #p1 en nuestro html.
4.6.1. Tabla de eventos
blur Cuando en un campo de formulario perdemos
el foco del teclado.
focus Cuando un elemento de un formulario recibe
un clic del ratón.
load Un elemento externo acaba el proceso de car-
ga, como por ejemplo una imagen.
resize La ventana cambia de tamaño, pertenece al
window.
scroll Hacemos scroll en la ventana o en un elemen-
to div.
click Hacemos clic sobre un nodo.
dblclick Hacemos doble clic sobre un nodo.
mouseover Pasamos el ratón por encima del elemento.
mouseout El ratón sale del elemento.

-- 39 of 86 --

CC-BY-SA • PID_00176160 40 CSS3 y Javascript avanzado
change El valor de un campo de formulario cambia.
submit Un formulario es enviado hacia el servidor.
keydown,￿keyup Pulsamos una tecla del teclado. La tecla que
se ha pulsado la podemos encontrar en la pro-
piedad wich del objeto evento pasado al mani-
pulador.
error Se desencadena, por ejemplo, cuando desde
el servidor una imagen no se carga.
Existen accesos directos en la mayoría de las propiedades que podemos utilizar
con un bind, con su nombre de función directamente. Así, podemos llamar los
métodos de un selector .click,￿.change,￿.error, etc.
4.7. Formularios
Otra de las tareas clave en la programación de aplicaciones web para el Javas-
cript es la manipulación, construcción y, sobre todo, validación de formula-
rios. jQuery nos ofrece toda una serie de métodos especialmente diseñados pa-
ra consultar y validar formularios. Así, podemos acceder al valor de cualquier
campo de formulario a partir de su selector efectuando:
$('#id').val()
El mismo método nos sirve para asignar un valor. Para ello, le enviaremos
como parámetro el valor que se quiere asignar.
También podemos capturar el momento de enviar el formulario y programar
una función que decida si se puede enviar o no, según el contenido de los
campos, utilizando el evento submit. Así, podemos hacer:
$('formulario#un').bind('submit', function(){
// si validación correcta
return true;
// si hay errores en la validación
// los podemos mostrar y se ha de devolver false
return false;
}
Existen también métodos para trabajar con AJAX que nos permiten serializar
de una vez todo el contenido del formulario haciendo: $('form').serialize(),
que nos generará el formulario preparado para ser enviado por GET. Por otro
lado, y según nos interese, podemos utilizar .serializeArray(), que nos permi-
tirá obtener el formulario dentro una lista.

-- 40 of 86 --

CC-BY-SA • PID_00176160 41 CSS3 y Javascript avanzado
4.8. AJAX
Asyncronimous￿Javascript￿and￿xml consiste en una técnica mediante la cual
podemos efectuar llamadas al servidor sin recargar el contenido de nuestra
página. Así, podemos enviar y recibir datos desde el servidor de manera inter-
activa desde Javascript. Como siempre, para utilizar la técnica, cada navegador
lo implementa de un modo diferente y, por suerte, jQuery nos facilita una
interfaz unificada.
Para solicitar una petición contra el servidor, disponemos de la función .ajax,
de tipo genérico y que admite muchos parámetros diferentes, o dos alternati-
vas mucho más directas que nos permiten solicitar documentos con GET￿o
POST.
$.get( url, [ data ], success(data))
url: Será la dirección que se va a solicitar al servidor.
data: Es un objeto Javascript con los parámetros que le queremos enviar al
servidor.
success: Es un handler que se ejecutará con la respuesta que el servidor nos
envía.
De este modo, un ejemplo sencillo con el que cargaremos un documento extra
desde el servidor puede quedar así:
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Ejercicio de carga de ajax</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"> </script>
<script>
$(document).ready(function(){
$('#bt').click(function(){ // 1
$.get('arxiu.txt', {hola:3, mon:4}, function(data){ // 2
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
<p>Al pulsar el botón, cargaremos dentro del párrafo azul el contenido del archivo txt del

-- 41 of 86 --

CC-BY-SA • PID_00176160 42 CSS3 y Javascript avanzado
servidor.</p>
< input type="button" id="bt" value="Carrega" />
<p id="desti">Aquí cargaremos un contenido con ajax desde el servidor</p>
< /body>
</html>
En el ejemplo, programamos (1) en el evento click del botón #bt que lance
una petición ajax, por método GET (2) $.get, descargamos el archivo.txt y
enviamos dos parámetros (hola y mundo). Como la petición es asincrónica
(no sabemos cuándo el servidor nos responderá), le enviamos una función
para que la ejecute en este momento (2). La función tiene un parámetro data,
que es el contenido de la petición y que finalmente, en (3), colocamos en el
nodo #destino.
También podemos hacer peticiones al servidor a través de POST con la función
$.post y los mismos parámetros.
Podemos consultar en línea la documentación porque las tres funciones nos
ofrecen multitud de opciones para simplificar el trabajo.
4.9. Componentes (widgets)
jQuery internamente no nos ofrece ningún sistema de componentes, pero sí
que existe un proyecto paralelo que ofrece determinados widgets. El proyecto se
denomina jqueryUI, y lo podemos revisar en www.jqueryui.com. Aunque muy
ligado a jQuery, funciona de manera independiente con calendario propio de
versiones.
Fundamentalmente, nos ofrece componentes visuales, componentes interac-
tivos, efectos y una utilidad. En cuanto a componentes visuales, tiene un pe-
queño widget de calendario, un campo de autocompletado (mientras escribes,
filtra resultados de una lista) y pestañas, entre otros.
Aparte de los componentes visuales, las jqueryUI también nos ofrecen una
serie de componentes funcionales, como, por ejemplo, los draggables y sor-
tables. Unos nos permiten programar objetos arrastables por la pantalla y, los
otros, objetos ordenables gracias a ordenación.
Web recomendada
Podemos ver el ejemplo fun-
cionando en:
http://multimedia.uoc.edu/
~jcollell/ejercicio_ajax.html

-- 42 of 86 --

CC-BY-SA • PID_00176160 43 CSS3 y Javascript avanzado
Todos los componentes siguen la misma nomenclatura y el mismo funciona-
miento que la propia librería madre. Hay una web con ejemplos, referencia
y también un selector de capas que nos permitirá configurar el componente
adaptado a las necesidades de diseño de nuestro proyecto.
4.10. Patrones de uso
Como ya hemos dicho anteriormente, un framework o biblioteca, además de
una serie de instrucciones, objetos y métodos para facilitarnos la vida a la hora
de trabajar, también implica ciertos patrones de trabajo a modo de convencio-
nes, que harán que la ejecución de aplicaciones sea más sólida y más conven-
cional para la mayoría de los programadores del marco.
$(document).ready(function() {
// código de programación
})
Este primer patrón emplea el evento ready, un evento especial que nos notifica
que el DOM del documento html ya está listo para ser utilizado o, lo que es lo
mismo, que podemos utilizar de manera segura cualquiera de los elementos
del documento desde nuestro programa. El evento estándar para hacer esto en
Javascript es el window.onload. Como principal diferencia, cabe decir que con
la técnica de jQuery el evento se ejecuta sin haber descargado las imágenes
asociadas con el DOM, mientras que con la convencional se debe esperar al
resto y es algo menos eficiente. Hay que decir también que del document.ready
podemos crear tantos otros como queramos durante el documento, mientras
que del window.onload sólo podemos tener uno.
Otro patrón de uso muy interesante es la capacidad de jQuery de encadenar
métodos. Desde el punto de vista funcional no supone mucho, pero sí a la hora
de escribir código muy legible, puesto que sobre un mismo selector podemos ir
aplicando diferentes métodos. Así, es habitual encontrar construcciones como
esta:
$('#lelemtn')
.css('color', 'black')
.bind('click', alferclic)
.bind('mouseover', rollover)
Otro patrón de uso muy común cuando se programa en Javascript moderno
consiste en generar funciones anónimas que se ejecutan para "esconder" este
código del resto de código de la página o del navegador. Así, podemos:
// Creamos una función anónima para utilizar como envoltorio
(function(){
// Esta variable normalmente sería global
var msg = "Thanks for visiting!";

-- 43 of 86 --

CC-BY-SA • PID_00176160 44 CSS3 y Javascript avanzado
// Y la asignamos a un método global
window.onunload = function(){
// Podemos utilizar la variable definida globalmente
alert( msg );
}; // Cerramos la función y la ejecutamos. A partir de aquí, el
// resto de las variables son invisibles
})();

-- 44 of 86 --

CC-BY-SA • PID_00176160 45 CSS3 y Javascript avanzado