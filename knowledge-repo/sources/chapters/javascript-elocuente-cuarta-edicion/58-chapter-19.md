# Chapter 19

Proyecto: Editor de Arte Pixelado
El material de los capítulos anteriores te brinda todos los elementos que nece-
sitas para construir una aplicación web básica. En este capítulo, haremos
precisamente eso.
Nuestra aplicación será un programa de dibujo de pixeles, donde puedes
modificar una imagen píxel por píxel manipulando una vista ampliada de la
misma, mostrada como una rejilla de cuadros de colores. Puedes utilizar el
programa para abrir archivos de imagen, garabatear en ellos con tu ratón u
otro dispositivo señalador, y guardarlos. Así es cómo se verá:
Pintar en una computadora es genial. No necesitas preocuparte por materi-
ales, habilidad o talento. Simplemente comienzas a manchar y ves hacia dónde
llegas.
Componentes
La interfaz de la aplicación muestra un gran elemento <canvas> en la parte
superior, con varios formularios debajo de él. El usuario dibuja en la imagen
seleccionando una herramienta de un campo <select> y luego haciendo clic,
tocando o arrastrando sobre el lienzo. Hay herramientas para dibujar píxeles
individuales o rectángulos, para rellenar un área y para seleccionar un color de
la imagen.
Estructuraremos la interfaz del editor como un conjunto de componentes,
objetos responsables de una parte del DOM y que pueden contener otros com-
331

-- 343 of 445 --

ponentes dentro de ellos.
El estado de la aplicación consiste en la imagen actual, la herramienta se-
leccionada y el color seleccionado. Organizaremos las cosas de manera que el
estado resida en un único valor, y los componentes de la interfaz siempre se
basen en el estado actual para verse.
Para entender por qué esto es importante, consideremos la alternativa: dis-
tribuir piezas de estado a lo largo de la interfaz. Hasta cierto punto, esto es
más fácil de programar. Podemos simplemente agregar un campo de color y
leer su valor cuando necesitemos saber el color actual.
Pero luego agregamos el selector de colores —una herramienta que te per-
mite hacer clic en la imagen para seleccionar el color de un píxel determinado.
Para mantener el campo de color mostrando el color correcto, esa herramienta
tendría que saber que el campo de color existe y actualizarlo cada vez que elige
un nuevo color. Si alguna vez añades otro lugar que muestre el color (quizás el
cursor del ratón podría mostrarlo), tendrías que actualizar tu código de cambio
de color para mantener eso sincronizado también.
De hecho, esto crea un problema en el que cada parte de la interfaz necesita
saber acerca de todas las demás partes, lo cual no es muy modular. Para
aplicaciones pequeñas como la de este capítulo, eso puede no ser un problema.
Para proyectos más grandes, puede convertirse en una verdadera pesadilla.
Para evitar esta pesadilla en principio, vamos a ser estrictos acerca del flujo
de datos. Hay un estado, y la interfaz se dibuja basada en ese estado. Un
componente de la interfaz puede responder a las acciones del usuario actual-
izando el estado, momento en el cual los componentes tienen la oportunidad
de sincronizarse con este nuevo estado.
En la práctica, cada componente se configura para que, cuando reciba un
nuevo estado, también notifique a sus componentes hijos, en la medida en que
estos necesiten ser actualizados. Configurar esto es un poco tedioso. Hacer que
esto sea más conveniente es el principal punto de venta de muchas bibliotecas
de programación para el navegador. Pero para una aplicación pequeña como
esta, podemos hacerlo sin dicha infraestructura.
Las actualizaciones al estado se representan como objetos, a los que lla-
maremos acciones. Los componentes pueden crear tales acciones y despachar
(enviarlos) a una función central de gestión de estado. Esa función calcula el
próximo estado, tras lo cual los componentes de la interfaz se actualizan a este
nuevo estado.
Estamos tomando la tarea desordenada de ejecutar una interfaz de usuario y
aplicándole estructura. Aunque las piezas relacionadas con el DOM aún están
llenas de efectos secundarios, están respaldadas por un esqueleto conceptual-
mente simple: el ciclo de actualización de estado. El estado determina cómo
332

-- 344 of 445 --

se ve el DOM, y la única forma en que los eventos del DOM pueden cambiar
el estado es despachando acciones al estado.
Hay muchas variantes de este enfoque, cada una con sus propios beneficios
y problemas, pero su idea central es la misma: los cambios de estado deben
pasar por un canal único y bien definido, no suceder por todas partes.
Nuestros componentes serán clases que cumplan con una interfaz. Su con-
structor recibe un estado, que puede ser el estado de toda la aplicación o algún
valor más pequeño si no necesita acceso a todo, y lo utiliza para construir una
propiedad dom. Este es el elemento DOM que representa el componente. La
mayoría de los constructores también tomarán otros valores que no cambiarán
con el tiempo, como la función que pueden utilizar para despachar una acción.
Cada componente tiene un método syncState que se utiliza para sincronizarlo
con un nuevo valor de estado. El método recibe un argumento, que es el estado,
del mismo tipo que el primer argumento de su constructor.
El estado
El estado de la aplicación será un objeto con las propiedades imagen, herramienta
y color. La imagen es en sí misma un objeto que almacena el ancho, alto y
contenido de píxeles de la imagen. Los píxels se almacenan en un solo array,
fila por fila, de arriba abajo.
class Picture {
constructor(width, height, pixels) {
this.width = width;
this.height = height;
this.pixels = pixels;
}
static empty(width, height, color) {
let pixels = new Array(width * height).fill(color);
return new Picture(width, height, pixels);
}
pixel(x, y) {
return this.pixels[x + y * this.width];
}
draw(pixels) {
let copy = this.pixels.slice();
for (let {x, y, color} of pixels) {
copy[x + y * this.width] = color;
}
return new Picture(this.width, this.height, copy);
}
333

-- 345 of 445 --

}
Queremos poder tratar una imagen como un valor inmutable por razones que re-
visaremos más adelante en el capítulo. Pero a veces necesitamos actualizar todo
un conjunto de píxeles a la vez. Para poder hacerlo, la clase tiene un método
draw que espera un array de píxeles actualizados, objetos con propiedades x, y
y color, y crea una nueva imagen con esos píxeles sobrescritos. Este método
utiliza slice sin argumentos para copiar todo el array de píxeles - el inicio de
la rebanada predetermina a 0, y el final predetermina a la longitud del array.
El método empty utiliza dos funcionalidades de array que no hemos visto
antes. El constructor Array se puede llamar con un número para crear un
array vacío de la longitud dada. El método fill se puede usar para llenar este
array con un valor dado. Se utilizan para crear un array en el que todos los
píxeles tienen el mismo color.
Los colores se almacenan como cadenas que contienen códigos de colores
CSS tradicionales compuestos por un signo de almohadilla (#) seguido de seis
dígitos hexadecimales (base-16) - dos para el componente rojo, dos para el
componente verde y dos para el componente azul. Esta es una forma algo
críptica e incómoda de escribir colores, pero es el formato que utiliza el campo
de entrada de color HTML, y se puede usar en la propiedad fillStyle de un
contexto de dibujo de lienzo, por lo que para las formas en que usaremos colores
en este programa, es lo bastante práctico.
El negro, donde todos los componentes son cero, se escribe como "#000000",
y el rosa brillante se ve como "#ff00ff", donde los componentes rojo y azul
tienen el valor máximo de 255, escrito ff en dígitos hexadecimales (que utilizan
a a f para representar los dígitos 10 al 15).
Permitiremos que la interfaz envíe acciones como objetos cuyas propiedades
sobrescriben las propiedades del estado anterior. El campo de color, cuando
el usuario lo cambia, podría enviar un objeto como {color: field.value}, a
partir del cual esta función de actualización puede calcular un nuevo estado.
function updateState(state, action) {
return {...state, ...action};
}
Este patrón, en el que el operador de spread de objetos se utiliza primero para
agregar las propiedades de un objeto existente y luego para anular algunas de
ellas, es común en el código de JavaScript que utiliza objetos inmutables.
334

-- 346 of 445 --

Construcción del DOM
Una de las principales funciones que cumplen los componentes de la interfaz es
crear una estructura DOM. Nuevamente, no queremos utilizar directamente los
métodos verbosos del DOM para eso, así que aquí tienes una versión ligeramente
ampliada de la función elt:
function elt(type, props, ...children) {
let dom = document.createElement(type);
if (props) Object.assign(dom, props);
for (let child of children) {
if (typeof child != "string") dom.appendChild(child);
else dom.appendChild(document.createTextNode(child));
}
return dom;
}
La diferencia principal entre esta versión y la que usamos en el Capítulo 16 es
que asigna propiedades a los nodos del DOM, no atributos. Esto significa que no
podemos usarlo para establecer atributos arbitrarios, pero sí podemos usarlo
para configurar propiedades cuyo valor no es una cadena, como onclick, que
se puede establecer como una función para registrar un controlador de eventos
de clic.
Esto permite este estilo conveniente para registrar manejadores de eventos:
<body>
<script>
document.body.appendChild(elt("button", {
onclick: () => console.log("clic")
}, "El botón"));
</script>
</body>
El lienzo
El primer componente que definiremos es la parte de la interfaz que muestra
la imagen como una cuadrícula de cuadros coloreados. Este componente es
responsable de dos cosas: mostrar una imagen y comunicar evento de punteros
en esa imagen al resto de la aplicación.
Como tal, podemos definirlo como un componente que solo conoce la imagen
actual, no todo el estado de la aplicación. Dado que no sabe cómo funciona
la aplicación en su totalidad, no puede despachar acciónes directamente. Más
335

-- 347 of 445 --

bien, al responder a eventos de puntero, llama a una función de devolución de
llamada proporcionada por el código que lo creó, que se encargará de las partes
específicas de la aplicación.
const scale = 10;
class PictureCanvas {
constructor(picture, pointerDown) {
this.dom = elt("canvas", {
onmousedown: event => this.mouse(event, pointerDown),
ontouchstart: event => this.touch(event, pointerDown)
});
this.syncState(picture);
}
syncState(picture) {
if (this.picture == picture) return;
this.picture = picture;
drawPicture(this.picture, this.dom, scale);
}
}
Dibujamos cada píxel como un cuadrado de 10 por 10, según lo determinado
por la constante scale. Para evitar trabajo innecesario, el componente real-
iza un seguimiento de su imagen actual y solo vuelve a dibujar cuando se le
proporciona una nueva imagen a syncState.
La función de dibujo real establece el tamaño del lienzo en función de la
escala y el tamaño de la imagen y lo llena con una serie de cuadrados, uno para
cada píxel.
function drawPicture(picture, canvas, scale) {
canvas.width = picture.width * scale;
canvas.height = picture.height * scale;
let cx = canvas.getContext("2d");
for (let y = 0; y < picture.height; y++) {
for (let x = 0; x < picture.width; x++) {
cx.fillStyle = picture.pixel(x, y);
cx.fillRect(x * scale, y * scale, scale, scale);
}
}
}
Cuando se presiona el botón izquierdo del mouse mientras está sobre el lienzo de
la imagen, el componente llama al callback pointerDown, dándole la posición
del píxel que se hizo clic, en coordenadas de la imagen. Esto se usará para
336

-- 348 of 445 --

implementar la interacción del mouse con la imagen. El callback puede devolver
otra función de callback para ser notificado cuando se mueve el puntero a un
píxel diferente mientras se mantiene presionado el botón.
PictureCanvas.prototype.mouse = function(downEvent, onDown) {
if (downEvent.button != 0) return;
let pos = pointerPosition(downEvent, this.dom);
let onMove = onDown(pos);
if (!onMove) return;
let move = moveEvent => {
if (moveEvent.buttons == 0) {
this.dom.removeEventListener("mousemove", move);
} else {
let newPos = pointerPosition(moveEvent, this.dom);
if (newPos.x == pos.x && newPos.y == pos.y) return;
pos = newPos;
onMove(newPos);
}
};
this.dom.addEventListener("mousemove", move);
};
function pointerPosition(pos, domNode) {
let rect = domNode.getBoundingClientRect();
return {x: Math.floor((pos.clientX - rect.left) / scale),
y: Math.floor((pos.clientY - rect.top) / scale)};
}
Dado que conocemos el tamaño de los píxeles y podemos usar getBoundingClientRect
para encontrar la posición del lienzo en la pantalla, es posible ir desde las
coordenadas del evento del mouse (clientX y clientY) hasta las coordenadas
de la imagen. Estas siempre se redondean hacia abajo para que se refieran a
un píxel específico.
Con eventos táctiles, tenemos que hacer algo similar, pero utilizando difer-
entes eventos y asegurándonos de llamar a preventDefault en el evento "
touchstart" para evitar el desplazamiento.
PictureCanvas.prototype.touch = function(startEvent,
onDown) {
let pos = pointerPosition(startEvent.touches[0], this.dom);
let onMove = onDown(pos);
startEvent.preventDefault();
if (!onMove) return;
let move = moveEvent => {
let newPos = pointerPosition(moveEvent.touches[0],
337

-- 349 of 445 --

this.dom);
if (newPos.x == pos.x && newPos.y == pos.y) return;
pos = newPos;
onMove(newPos);
};
let end = () => {
this.dom.removeEventListener("touchmove", move);
this.dom.removeEventListener("touchend", end);
};
this.dom.addEventListener("touchmove", move);
this.dom.addEventListener("touchend", end);
};
Para eventos táctiles, clientX y clientY no están disponibles directamente en
el objeto de evento, pero podemos usar las coordenadas del primer objeto táctil
en la propiedad touches.
La aplicación
Para hacer posible construir la aplicación pieza por pieza, implementaremos el
componente principal como una cáscara alrededor de un lienzo de imagen y un
conjunto dinámico de tools y controls que pasamos a su constructor.
Los controles son los elementos de interfaz que aparecen debajo de la imagen.
Se proporcionarán como un array de constructores de component.
Las herramientas hacen cosas como dibujar píxeles o rellenar un área. La
aplicación muestra el conjunto de herramientas disponibles como un campo
<select>. La herramienta actualmente seleccionada determina qué sucede
cuando el usuario interactúa con la imagen con un dispositivo puntero. El con-
junto de herramientas disponibles se proporciona como un objeto que mapea
los nombres que aparecen en el campo desplegable a funciones que implemen-
tan las herramientas. Dichas funciones reciben como argumentos una posición
de imagen, un estado de aplicación actual y una función dispatch. Pueden
devolver una función manejadora de movimiento que se llama con una nueva
posición y un estado actual cuando el puntero se mueve a un píxel diferente.
class PixelEditor {
constructor(state, config) {
let {tools, controls, dispatch} = config;
this.state = state;
this.canvas = new PictureCanvas(state.picture, pos => {
let tool = tools[this.state.tool];
let onMove = tool(pos, this.state, dispatch);
338

-- 350 of 445 --

if (onMove) return pos => onMove(pos, this.state);
});
this.controls = controls.map(
Control => new Control(state, config));
this.dom = elt("div", {}, this.canvas.dom, elt("br"),
...this.controls.reduce(
(a, c) => a.concat(" ", c.dom), []));
}
syncState(state) {
this.state = state;
this.canvas.syncState(state.picture);
for (let ctrl of this.controls) ctrl.syncState(state);
}
}
El manejador de puntero dado a PictureCanvas llama a la herramienta ac-
tualmente seleccionada con los argumentos apropiados y, si eso devuelve un
manejador de movimiento, lo adapta para también recibir el estado.
Todos los controles se construyen y almacenan en this.controls para que
puedan actualizarse cuando cambie el estado de la aplicación. La llamada a
reduce introduce espacios entre los elementos DOM de los controles. De esa
manera, no se ven tan juntos.
El primer control es el menú de selección de tool. Crea un elemento <select
> con una opción para cada herramienta y configura un manejador de evento
"change" que actualiza el estado de la aplicación cuando el usuario selecciona
una herramienta diferente.
class ToolSelect {
constructor(state, {tools, dispatch}) {
this.select = elt("select", {
onchange: () => dispatch({tool: this.select.value})
}, ...Object.keys(tools).map(name => elt("option", {
selected: name == state.tool
}, name)));
this.dom = elt("label", null, "🖌 Herramienta: ", this.select);
}
syncState(state) { this.select.value = state.tool; }
}
Al envolver el texto de la etiqueta y el campo en un elemento <label>, le
decimos al navegador que la etiqueta pertenece a ese campo para que, por
ejemplo, se pueda hacer clic en la etiqueta para enfocar el campo.
También necesitamos poder cambiar el color, así que agreguemos un control
para eso. Un elemento HTML <input> con un atributo type de color nos brinda
339

-- 351 of 445 --

un campo de formulario especializado para seleccionar colores. El valor de dicho
campo siempre es un código de color CSS en formato "#RRGGBB" (componentes
rojo, verde y azul, dos dígitos por color). El navegador mostrará una interfaz
de selector de color cuando el usuario interactúe con él.
Dependiendo del navegador, el selector de color puede lucir así:
Este control crea un campo de ese tipo y lo conecta para que se mantenga
sincronizado con la propiedad color del estado de la aplicación.
class ColorSelect {
constructor(state, {dispatch}) {
this.input = elt("input", {
type: "color",
value: state.color,
onchange: () => dispatch({color: this.input.value})
});
this.dom = elt("label", null, "🎨 Color: ", this.input);
}
syncState(state) { this.input.value = state.color; }
}
Herramientas de dibujo
Antes de poder dibujar algo, necesitamos implementar las herramientas que
controlarán la funcionalidad de eventos de ratón o táctiles en el lienzo.
La herramienta más básica es la herramienta de dibujo, que cambia cualquier
píxel en el que hagas clic o toques al color seleccionado actualmente. Envía
una acción que actualiza la imagen a una versión en la que el píxel señalado
recibe el color seleccionado actualmente.
340

-- 352 of 445 --

function draw(pos, state, dispatch) {
function drawPixel({x, y}, state) {
let drawn = {x, y, color: state.color};
dispatch({picture: state.picture.draw([drawn])});
}
drawPixel(pos, state);
return drawPixel;
}
La función llama inmediatamente a la función drawPixel, pero también la de-
vuelve para que sea llamada nuevamente para los píxeles recién tocados cuando
el usuario arrastra o desliza sobre la imagen.
Para dibujar formas más grandes, puede ser útil crear rápidamente rectán-
gulos. La herramienta rectángulo dibuja un rectángulo entre el punto donde
comienzas a arrastrar y el punto al que arrastras.
function rectangle(start, state, dispatch) {
function drawRectangle(pos) {
let xStart = Math.min(start.x, pos.x);
let yStart = Math.min(start.y, pos.y);
let xEnd = Math.max(start.x, pos.x);
let yEnd = Math.max(start.y, pos.y);
let drawn = [];
for (let y = yStart; y <= yEnd; y++) {
for (let x = xStart; x <= xEnd; x++) {
drawn.push({x, y, color: state.color});
}
}
dispatch({picture: state.picture.draw(drawn)});
}
drawRectangle(start);
return drawRectangle;
}
Un detalle importante en esta implementación es que al arrastrar, el rectángulo
se vuelve a dibujar en la imagen a partir del estado original. De esta manera,
puedes hacer que el rectángulo sea más grande o más pequeño nuevamente
mientras lo creas, sin que los rectángulos intermedios queden pegados en la
imagen final. Esta es una de las razones por las que los objetos de imagen
inmutables son útiles; veremos otra razón más adelante.
Implementar el relleno por inundación es algo más complejo. Se trata de una
herramienta que llena el píxel bajo el puntero y todos los píxeles adyacentes
que tengan el mismo color. “Adyacente” significa adyacente directamente en
horizontal o vertical, no diagonalmente. Esta imagen ilustra el conjunto de
341

-- 353 of 445 --

píxeles coloreados cuando se utiliza la herramienta de relleno por inundación
en el píxel marcado:
Curiosamente, la forma en que lo haremos se parece un poco al código
de búsqueda de caminos del Capítulo 7. Mientras que ese código buscaba
a través de un grafo para encontrar una ruta, este código busca a través de
una cuadrícula para encontrar todos los píxeles “conectados”. El problema de
llevar un conjunto ramificado de rutas posibles es similar.
const alrededor = [{dx: -1, dy: 0}, {dx: 1, dy: 0},
{dx: 0, dy: -1}, {dx: 0, dy: 1}];
function rellenar({x, y}, estado, despachar) {
let colorObjetivo = estado.imagen.pixel(x, y);
let dibujados = [{x, y, color: estado.color}];
let visitados = new Set();
for (let hecho = 0; hecho < dibujados.length; hecho++) {
for (let {dx, dy} of alrededor) {
let x = dibujados[hecho].x + dx, y = dibujados[hecho].y + dy;
if (x >= 0 && x < estado.imagen.ancho &&
y >= 0 && y < estado.imagen.alto &&
!visitados.has(x + "," + y) &&
estado.imagen.pixel(x, y) == colorObjetivo) {
dibujados.push({x, y, color: estado.color});
visitados.add(x + "," + y);
}
}
}
despachar({imagen: estado.imagen.dibujar(dibujados)});
}
El array de píxeles dibujados funciona como la lista de trabajo de la función.
Para cada píxel alcanzado, tenemos que ver si algún píxel adyacente tiene el
mismo color y aún no ha sido pintado. El contador del bucle va rezagado
respecto a la longitud del array dibujados a medida que se añaden nuevos
píxeles. Cualquier píxel por delante de él aún necesita ser explorado. Cuando
alcanza la longitud, no quedan píxeles sin explorar y la función termina.
La última herramienta es un selector de color, que te permite apuntar a un
342

-- 354 of 445 --

color en la imagen para usarlo como color de dibujo actual.
function seleccionar(pos, estado, despachar) {
despachar({color: estado.imagen.pixel(pos.x, pos.y)});
}
```## Guardar y cargar
Cuando hemos dibujado nuestra obra maestra, querríamos guardarla
para más tarde. Deberíamos añadir un botón para descargar la
imagen actual como un archivo de imagen. Este control proporciona
ese botón:
```{includeCode: true}
class SaveButton {
constructor(state) {
this.picture = state.picture;
this.dom = elt("button", {
onclick: () => this.save()
}, "💾 Guardar");
}
save() {
let canvas = elt("canvas");
drawPicture(this.picture, canvas, 1);
let link = elt("a", {
href: canvas.toDataURL(),
download: "pixelart.png"
});
document.body.appendChild(link);
link.click();
link.remove();
}
syncState(state) { this.picture = state.picture; }
}
El componente lleva un registro de la imagen actual para que pueda acceder a
ella al guardar. Para crear el archivo de imagen, utiliza un elemento <canvas>
en el que dibuja la imagen (a una escala de un píxel por píxel).
El método toDataURL en un elemento canvas crea una URL que empieza con
data:. A diferencia de las URL http: y https:, las URL de datos contienen
todo el recurso en la URL. Por lo general, son muy largas, pero nos permiten
crear enlaces funcionales a imágenes arbitrarias aquí mismo en el navegador.
Para realmente hacer que el navegador descargue la imagen, luego creamos
un elemento de enlace que apunta a esta URL y tiene un atributo download.
Tales enlaces, al hacer clic en ellos, muestran un cuadro de diálogo para guardar
343

-- 355 of 445 --

el archivo en el navegador. Añadimos ese enlace al documento, simulamos un
clic en él y luego lo eliminamos. Se pueden hacer muchas cosas con la tecnología
del navegador, pero a veces la forma de hacerlo es bastante extraña.
Y la cosa se pone peor. También querríamos cargar archivos de imagen
existentes en nuestra aplicación. Para hacer eso, nuevamente definimos un
componente de botón.
class LoadButton {
constructor(_, {dispatch}) {
this.dom = elt("button", {
onclick: () => startLoad(dispatch)
}, "📁 Cargar");
}
syncState() {}
}
function startLoad(dispatch) {
let input = elt("input", {
type: "file",
onchange: () => finishLoad(input.files[0], dispatch)
});
document.body.appendChild(input);
input.click();
input.remove();
}
Para acceder a un archivo en la computadora del usuario, necesitamos que el
usuario seleccione el archivo a través de un campo de entrada de archivo. Pero
no quiero que el botón de carga se vea como un campo de entrada de archivo,
así que creamos el campo de entrada de archivo cuando se hace clic en el botón
y luego fingimos que este campo de entrada de archivo fue clicado.
Cuando el usuario ha seleccionado un archivo, podemos usar FileReader
para acceder a su contenido, nuevamente como una URL de datos. Esa URL
se puede utilizar para crear un elemento <img>, pero debido a que no podemos
acceder directamente a los píxeles en una imagen de ese tipo, no podemos crear
un objeto Picture a partir de eso.
function finishLoad(file, dispatch) {
if (file == null) return;
let reader = new FileReader();
reader.addEventListener("load", () => {
let image = elt("img", {
onload: () => dispatch({
picture: pictureFromImage(image)
344

-- 356 of 445 --

}),
src: reader.result
});
});
reader.readAsDataURL(file);
}
Para acceder a los píxeles, primero debemos dibujar la imagen en un elemento
<canvas>. El contexto del canvas tiene un método getImageData que permite a
un script leer sus píxeles. Por lo tanto, una vez que la imagen esté en el canvas,
podemos acceder a ella y construir un objeto Picture.
function pictureFromImage(image) {
let width = Math.min(100, image.width);
let height = Math.min(100, image.height);
let canvas = elt("canvas", {width, height});
let cx = canvas.getContext("2d");
cx.drawImage(image, 0, 0);
let pixels = [];
let {data} = cx.getImageData(0, 0, width, height);
function hex(n) {
return n.toString(16).padStart(2, "0");
}
for (let i = 0; i < data.length; i += 4) {
let [r, g, b] = data.slice(i, i + 3);
pixels.push("#" + hex(r) + hex(g) + hex(b));
}
return new Picture(width, height, pixels);
}
Limitaremos el tamaño de las imágenes a 100 por 100 píxeles, ya que cualquier
cosa más grande se verá enorme en nuestra pantalla y podría ralentizar la
interfaz.
La propiedad data del objeto devuelto por getImageData es un array de
componentes de color. Para cada píxel en el rectángulo especificado por los
argumentos, contiene cuatro valores, que representan los componentes rojo,
verde, azul y alfa del color del píxel, como números entre 0 y 255. La parte alfa
representa la opacidad: cuando es cero, el píxel es totalmente transparente, y
cuando es 255, es totalmente opaco. Para nuestro propósito, podemos ignorarla.
Los dos dígitos hexadecimales por componente, como se usa en nuestra no-
tación de color, corresponden precisamente al rango del 0 al 255: dos dígitos
en base 16 pueden expresar 162 = 256 números diferentes. El método toString
de los números puede recibir como argumento una base, por lo que n.toString
345

-- 357 of 445 --

(16) producirá una representación en cadena en base 16. Debemos asegurarnos
de que cada número tenga dos dígitos, por lo que la función auxiliar hex llama
a padStart para agregar un cero inicial cuando sea necesario.
¡Ya podemos cargar y guardar! Eso deja una característica más antes de que
hayamos terminado.
Historial de deshacer
La mitad del proceso de edición consiste en cometer pequeños errores y corre-
girlos. Por lo tanto, una característica importante en un programa de dibujo
es un historial de deshacer.
Para poder deshacer cambios, necesitamos almacenar versiones anteriores de
la imagen. Dado que es un valor inmutable, eso es fácil. Pero sí requiere un
campo adicional en el estado de la aplicación.
Agregaremos una matriz done para mantener versiones anteriores de la ima-
gen. Mantener esta propiedad requiere una función de actualización de estado
más complicada que añade imágenes a la matriz.
Pero no queremos almacenar cada cambio, solo los cambios que ocurran en
un determinado espacio de tiempo. Para poder hacer eso, necesitaremos una
segunda propiedad, doneAt, que rastree la hora en la que almacenamos por
última vez una imagen en el historial.
function historyUpdateState(state, action) {
if (action.undo == true) {
if (state.done.length == 0) return state;
return {
...state,
picture: state.done[0],
done: state.done.slice(1),
doneAt: 0
};
} else if (action.picture &&
state.doneAt < Date.now() - 1000) {
return {
...state,
...action,
done: [state.picture, ...state.done],
doneAt: Date.now()
};
} else {
return {...state, ...action};
}
346

-- 358 of 445 --

}
Cuando la acción es una acción de deshacer, la función toma la imagen más
reciente del historial y la convierte en la imagen actual. Establece doneAt en
cero para garantizar que el siguiente cambio almacenará la imagen nuevamente
en el historial, permitiéndote revertir a ella en otro momento si lo deseas.
De lo contrario, si la acción contiene una nueva imagen y la última vez
que almacenamos algo fue hace más de un segundo (1000 milisegundos), las
propiedades done y doneAt se actualizan para almacenar la imagen anterior.
El botón de deshacer componente no hace mucho. Despacha acciones de
deshacer al hacer clic y se deshabilita cuando no hay nada que deshacer.
class UndoButton {
constructor(state, {dispatch}) {
this.dom = elt("button", {
onclick: () => dispatch({undo: true}),
disabled: state.done.length == 0
}, "⮪ Deshacer");
}
syncState(state) {
this.dom.disabled = state.done.length == 0;
}
}
Vamos a dibujar
Para configurar la aplicación, necesitamos crear un estado, un conjunto de her-
ramientas, un conjunto de controles y una función despachar. Podemos pasar-
los al constructor PixelEditor para crear el componente principal. Dado que
necesitaremos crear varios editores en los ejercicios, primero definimos algunos
enlaces.
const startState = {
tool: "draw",
color: "#000000",
picture: Picture.empty(60, 30, "#f0f0f0"),
done: [],
doneAt: 0
};
const baseTools = {draw, fill, rectangle, pick};
const baseControls = [
347

-- 359 of 445 --

ToolSelect, ColorSelect, SaveButton, LoadButton, UndoButton
];
function startPixelEditor({state = startState,
tools = baseTools,
controls = baseControls}) {
let app = new PixelEditor(state, {
tools,
controls,
dispatch(action) {
state = historyUpdateState(state, action);
app.syncState(state);
}
});
return app.dom;
}
Cuando desestructuras un objeto o un array, puedes usar = después de un nom-
bre de enlace para darle al enlace un valor predeterminado, que se usa cuando la
propiedad está ausente o tiene undefined. La función startPixelEditor hace
uso de esto para aceptar un objeto con varias propiedades opcionales como
argumento. Si, por ejemplo, no proporcionas una propiedad tools, entonces
tools estará vinculado a baseTools.Así es como obtenemos un editor real en
la pantalla:
<div></div>
<script>
document.querySelector("div")
.appendChild(startPixelEditor({}));
</script>
¿Por qué es tan difícil?
La tecnología del navegador es asombrosa. Proporciona un poderoso conjunto
de bloques de construcción de interfaz, formas de diseñar y manipularlos, y
herramientas para inspeccionar y depurar tus aplicaciones. El software que
escribes para el navegador puede ejecutarse en casi todas las computadoras y
teléfonos del planeta.
Al mismo tiempo, la tecnología del navegador es ridícula. Tienes que apren-
der una gran cantidad de trucos tontos y hechos oscuros para dominarla, y el
modelo de programación predeterminado que ofrece es tan problemático que la
mayoría de los programadores prefieren cubrirlo con varias capas de abstracción
348

-- 360 of 445 --

en lugar de lidiar con él directamente.
Y aunque la situación definitivamente está mejorando, en su mayoría lo hace
en forma de más elementos que se agregan para abordar deficiencias, creando
aún más complejidad. Una característica utilizada por un millón de sitios web
realmente no se puede reemplazar. Incluso si se pudiera, sería difícil decidir
con qué debiera ser reemplazada.
La tecnología nunca existe en un vacío; estamos limitados por nuestras her-
ramientas y los factores sociales, económicos e históricos que las produjeron.
Esto puede ser molesto, pero generalmente es más productivo tratar de con-
struir una buena comprensión de cómo funciona la realidad técnica existente y
por qué es como es, que luchar contra ella o esperar otra realidad.
Nuevas abstracciones pueden ser útiles. El modelo de componente y la con-
vención de flujo de datos que utilicé en este capítulo es una forma rudimentaria
de eso. Como se mencionó, hay bibliotecas que intentan hacer la programación
de interfaces de usuario más agradable. En el momento de escribir esto, React y
Svelte son opciones populares, pero hay toda una industria de tales marcos. Si
estás interesado en programar aplicaciones web, recomiendo investigar algunos
de ellos para comprender cómo funcionan y qué beneficios proporcionan.
Ejercicios
Todavía hay espacio para mejorar nuestro programa. Vamos a agregar algunas
funciones más como ejercicios.
Atajos de teclado
Agrega atajos de teclado a la aplicación. La primera letra del nombre de una
herramienta selecciona la herramienta, y control-Z o command-Z activa el
deshacer.
Haz esto modificando el componente PixelEditor. Agrega una propiedad
tabIndex de 0 al elemento <div> envolvente para que pueda recibir el en-
foque del teclado. Ten en cuenta que la propiedad correspondiente al atributo
tabindex se llama tabIndex, con una I mayúscula, y nuestra función elt espera
nombres de propiedades. Registra los manejadores de eventos de teclas direc-
tamente en ese elemento. Esto significa que debes hacer clic, tocar o moverte
al tabulador en la aplicación antes de poder interactuar con el teclado.
Recuerda que los eventos de teclado tienen las propiedades ctrlKey y metaKey
(para la tecla command en Mac) que puedes utilizar para ver si esas teclas
están presionadas.
349

-- 361 of 445 --

Dibujando eficientemente
Durante el dibujo, la mayoría del trabajo que hace nuestra aplicación ocurre
en drawPicture. Crear un nuevo estado y actualizar el resto del DOM no es
muy costoso, pero repintar todos los píxeles en el lienzo es bastante trabajo.
Encuentra una forma de hacer que el método syncState de PictureCanvas
sea más rápido redibujando solo los píxeles que realmente cambiaron.
Recuerda que drawPicture también es utilizado por el botón de guardar, así
que si lo cambias, asegúrate de que los cambios no rompan el uso anterior o
crea una nueva versión con un nombre diferente.
También ten en cuenta que al cambiar el tamaño de un elemento <canvas>,
establecer sus propiedades width o height, lo borra y lo vuelve completamente
transparente nuevamente.
Círculos
Define una herramienta llamada circle que dibuje un círculo relleno cuando
arrastres. El centro del círculo se encuentra en el punto donde comienza el gesto
de arrastre o toque, y su radio está determinado por la distancia arrastrada.
Líneas adecuadas
Este es un ejercicio más avanzado que los dos anteriores, y requerirá que diseñes
una solución a un problema no trivial. Asegúrate de tener mucho tiempo y
paciencia antes de comenzar a trabajar en este ejercicio, y no te desanimes por
los fallos iniciales.
En la mayoría de los navegadores, al seleccionar la herramienta de dibujo y
arrastrar rápidamente sobre la imagen, no obtienes una línea cerrada. En su
lugar, obtienes puntos con huecos entre ellos porque los eventos "mousemove"
o "touchmove" no se dispararon lo suficientemente rápido como para alcanzar
cada píxel.
Mejora la herramienta de dibujo para que dibuje una línea completa. Esto
significa que debes hacer que la función de controlador de movimiento recuerde
la posición anterior y la conecte con la actual.
Para hacer esto, dado que los píxeles pueden estar a una distancia arbitraria,
tendrás que escribir una función general de dibujo de líneas.
Una línea entre dos píxeles es una cadena conectada de píxeles, lo más recta
posible, que va desde el comienzo hasta el final. Los píxeles diagonalmente
adyacentes cuentan como conectados. Por lo tanto, una línea inclinada debería
verse como la imagen de la izquierda, no como la de la derecha.
350

-- 362 of 445 --

Finalmente, si tenemos código que dibuja una línea entre dos puntos arbi-
trarios, podríamos usarlo también para definir una herramienta de línea, que
dibuja una línea recta entre el inicio y el final de un arrastre.
351

-- 363 of 445 --

“Un estudiante preguntó: “Los programadores de antaño solo usaban
máquinas simples y ningún lenguaje de programación, sin embargo,
creaban programas hermosos. ¿Por qué nosotros usamos máquinas
complicadas y lenguajes de programación?”. Fu-Tzu respondió: “Los
constructores de antaño solo usaban palos y arcilla, sin embargo,
creaban hermosas chozas.””
—Maestro Yuan-Ma, El Libro de la Programación