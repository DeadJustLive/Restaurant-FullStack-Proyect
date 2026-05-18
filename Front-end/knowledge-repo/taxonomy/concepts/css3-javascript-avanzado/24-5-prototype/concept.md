# 5. Prototype

## Fuente
css3-javascript-avanzado (Cap. 24)

## Contenido
# 5. Prototype

Fue una de las primeras bibliotecas en aparecer y encerrar toda la potencia de
Javascript para navegadores modernos. Creada en el 2005, destaca por ser la
primera en muchas cosas y por ser la librería de uso del potente framework web
RubyonRails. También dispone de una librería de componentes gráficos y de
efectos visuales llamada script.aculo.us
5.1. Interactuando con el DOM
De la misma manera que el jQuery, de hecho este ha tomado la idea de ahí,
la biblioteca nos ofrece una función para acceder al DOM de manera fácil:
$('idelement') obtiene una referencia al elemento y además le añade todos
los métodos propios de la clase Element.Methods. Existe también la función
$$('classecss'). Hace lo mismo, pero a partir de clases CSS. En este caso, en
vez de devolver una referencia devuelve una lista de elementos en el mismo
orden que aparecen en el DOM. También nos ofrece una función para acceder
a formularios $F().
Una vez obtenida la referencia en los elementos, podemos navegar por los
diferentes nodos vecinos en el DOM con toda una serie de métodos:
$("clar").adjacent("li.dona");
Nos devolverá un array de nodos vecinos al que tiene id #clar y que cumplen
el selector.
$("clar").ancestors();
Recopila todos los padres en orden.
up/down/next/previos
Selecciona el padre, el hijo, el siguiente y el anterior.
descendants
Devuelve los hijos.
También disponemos de elementos para modificar el contenido
de la página. Podemos insertar elementos utilizando la función:
$("MainDiv").insert({top:"Añadido￿ al￿ inicio￿ del￿ elemento"}), que primero

-- 45 of 86 --

CC-BY-SA • PID_00176160 46 CSS3 y Javascript avanzado
obtiene la referencia al elemento para después insertar el contenido en la po-
sición superior. El objeto que recibe como parámetro puede contener propie-
dades como (top, before, after, bottom).
Podemos borrar elementos con el método .remove(). También podemos utili-
zar .update(), que actualiza el elemento con el contenido dado, y .replace(),
que lo cambia.
Otras funcionalidades que nos ofrece de facto permiten calcular posiciones
relativas y absolutas de un elemento (absolute,￿relativize), clonar posiciones
con (clonePosition). También podemos esconder y mostrar con (show,￿hide),
cambiar opacidades con (getOpacity,￿setOpacity), tamaños (getDimensions,
getHeight,￿getWidth) y hacer clipping con (makeClipping,￿undoClipping).
También nos ofrece métodos para trabajar con CSS, así, addClassName,￿remo-
veClassName,￿toggleClassNames sirven para añadir clases, sacar clases o in-
tercambiar clases CSS; hasClassName,￿classNames, para consultar, y setStyle,
getStyle.
5.2. Sistema de eventos
La manera general de capturar eventos con Prototype es utilizando la función:
Event.observe(element, eventName, handler [,useCapture = false]);
Element puede ser un string con un ID o directamente un elemento seleccio-
nado. El nombre del evento debe ser el estipulado por el W3CDOM nivel 2, el
handler es una función, y el flaguseCapture determina si utilizamos el sistema
de burbujas o no.
Un buen ejemplo de uso podría ser:
<ul id="PeopleList">
<li class="noia" id="judy">Joana</li>
<li class="noi" id="sam">Sam</li>
<li class="noia" id="amelia">Amelia</li>
</ul> </div>
<textarea id="results" cols="50" rows="10"></textarea>
<script type="text/javascript" src="prototype-1.6.0.2.js"></script>
<script type="text/javascript">
$("results").value = "";
Event.observe("PeopleList", "click", function(e) {
$("results").value += "clicked on " + e.target.id + "\n";
});
</script>

-- 46 of 86 --

CC-BY-SA • PID_00176160 47 CSS3 y Javascript avanzado
Al hacer clic sobre los elementos, se ejecutará la función que escribirá el ID del
elemento pulsado en el campo textarea.
La función handler tiene un parámetro de tipo evento del que podemos ver di-
ferentes métodos y propiedades. Así, Event.target es el nodo que ha generado
el evento, this es el nodo en el que se ha capturado el evento, y Event.element
es el nodo que ha generado el evento.
.stopObserving() elimina las referencias a los eventos y unloadCache() elimi-
na todos los eventos capturados. Para no dejar que un evento haga la burbuja,
Event.stop().
5.3. AJAX
var url = "http://myserver/api/get";
var ajaxCall = new Ajax.Request(url, {
method: 'get',
parameters: {a:1, b:2},
onSuccess: function() { alert('respuesta correcta.2xx') },
onFailure: function() { alert('Fallo') },
onComplete: function() { alert('Completada') },
});
Con esta simple signatura ya podemos realizar peticiones contra el servidor y
destacar el uso de diferentes handlers que nos permiten capturar la respuesta
desde el servidor.
5.4. Utilidades generales
Una de las carencias de la biblioteca y que a menudo recibe críticas es su cons-
trucción, puesto que basa parte de su funcionamiento en extensiones que cuel-
gan de la cadena de prototipaje de los objetos normales del lenguaje. Así, nos
ofrece herramientas para extender y personalizar más aún la biblioteca.
Object.clone(objecte): Hace una copia exacta de un objeto.
Obj
