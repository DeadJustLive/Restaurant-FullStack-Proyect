# para sistemas windows

## Fuente
jquery-fundamentos (Cap. 44)

## Contenido
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
igual forma si existen luces apagadas, es posible prenderlas con dicho interruptor. Para 
