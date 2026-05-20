# Chapter 15

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 43)

## Contenido
# Chapter 15

Manejo de Eventos
Algunos programas trabajan con la entrada directa del usuario, como acciones
del ratón y del teclado. Ese tipo de entrada no está disponible de antemano,
como una estructura de datos bien organizada, llega pieza por pieza, en tiempo
real, y el programa debe responder a medida que sucede.
Controladores de Eventos
Imagina una interfaz donde la única forma de saber si una tecla en el teclado
está siendo presionada es leyendo el estado actual de esa tecla. Para poder
reaccionar a las pulsaciones de teclas, tendrías que leer constantemente el estado
de la tecla para capturarla antes de que se libere nuevamente. Sería peligroso
realizar otras computaciones intensivas en tiempo, ya que podrías perder una
pulsación de tecla.
Algunas máquinas primitivas manejan la entrada de esa manera. Un paso
adelante sería que el hardware o el sistema operativo noten la pulsación de tecla
y la pongan en una cola. Un programa puede luego verificar periódicamente la
cola en busca de nuevos eventos y reaccionar a lo que encuentre allí.
Por supuesto, tiene que recordar mirar la cola y hacerlo a menudo, porque
cualquier tiempo transcurrido entre la presión de la tecla y la notificación del
evento por parte del programa hará que el software se sienta sin respuesta. Este
enfoque se llama sondeo. La mayoría de los programadores prefieren evitarlo.
Un mecanismo mejor es que el sistema notifique activamente a nuestro código
cuando ocurre un evento. Los navegadores hacen esto al permitirnos registrar
funciones como manejadores para eventos específicos.
<p>Haz clic en este documento para activar el manejador.</p>
<script>
window.addEventListener("click", () => {
console.log("¿Llamaste?");
});
</script>
242

-- 254 of 445 --

La asignación window se refiere a un objeto integrado proporcionado por el
navegador. Representa la ventana del navegador que contiene el documento.
Llamar a su método addEventListener registra el segundo argumento para que
se llame cada vez que ocurra el evento descrito por su primer argumento.
Eventos y nodos DOM
Cada controlador de eventos del navegador se registra en un contexto. En
el ejemplo anterior llamamos a addEventListener en el objeto window para
registrar un controlador para toda la ventana. Un método similar también se
encuentra en elementos del DOM y algunos otros tipos de objetos. Los escuchas
de eventos solo se llaman cuando el evento ocurre en el contexto del objeto en
el que están registrados.
<button>Haz clic</button>
<p>No hay manejador aquí.</p>
<script>
let button = document.querySelector("button");
button.addEventListener("click", () => {
console.log("Botón clickeado.");
});
</script>
Ese ejemplo adjunta un manejador al nodo del botón. Los clics en el botón
hacen que se ejecute ese manejador, pero los clics en el resto del documento no
lo hacen.
Darle a un nodo un atributo onclick tiene un efecto similar. Esto funciona
para la mayoría de tipos de eventos: puedes adjuntar un manejador a través
del atributo cuyo nombre es el nombre del evento con on al inicio.
Pero un nodo solo puede tener un atributo onclick, por lo que solo puedes
registrar un manejador por nodo de esa manera. El método addEventListener
te permite agregar cualquier cantidad de manejadores, por lo que es seguro
agregar manejadores incluso si ya hay otro manejador en el elemento.
El método removeEventListener, llamado con argumentos similares a addEventListener
, remueve un manejador.
<button>Botón de acción única</button>
<script>
let button = document.querySelector("button");
function unaVez() {
console.log("¡Hecho!");
button.removeEventListener("click", unaVez);
243

-- 255 of 445 --

}
button.addEventListener("click", unaVez);
</script>
La función proporcionada a removeEventListener debe ser el mismo valor de
función que se proporcionó a addEventListener. Por lo tanto, para anular el
registro de un manejador, querrás darle un nombre a la función (unaVez, en el
ejemplo) para poder pasar el mismo valor de función a ambos métodos.
Objetos de eventos
Aunque lo hemos ignorado hasta ahora, las funciones de manejadores de eventos
reciben un argumento: el objeto de evento. Este objeto contiene información
adicional sobre el evento. Por ejemplo, si queremos saber cuál botón del mouse
se presionó, podemos mirar la propiedad button del objeto de evento.
<button>Haz clic como quieras</button>
<script>
let button = document.querySelector("button");
button.addEventListener("mousedown", event => {
if (event.button == 0) {
console.log("Botón izquierdo");
} else if (event.button == 1) {
console.log("Botón del medio");
} else if (event.button == 2) {
console.log("Botón derecho");
}
});
</script>
La información almacenada en un objeto de evento difiere según el tipo de
evento. Discutiremos diferentes tipos más adelante en el capítulo. La propiedad
type del objeto siempre contiene una cadena que identifica el evento (como "
click" o "mousedown").
Propagación
Para la mayoría de tipos de evento, los manejadores registr
