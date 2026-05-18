# Chapter 17

Dibujando en Canvas
Los navegadores nos ofrecen varias formas de mostrar gráficos. La forma más
simple es usar estilos para posicionar y colorear elementos DOM regulares. Esto
puede llevarnos bastante lejos, como mostró el juego en el capítulo anterior. Al
agregar imágenes de fondo parcialmente transparentes a los nodos, podemos
hacer que se vean exactamente como queremos. Incluso es posible rotar o sesgar
nodos con el estilo transform.
Pero estaríamos utilizando el DOM para algo para lo que no fue diseñado
originalmente. Algunas tareas, como dibujar una línea entre puntos arbitrarios,
son extremadamente incómodas de hacer con elementos HTML regulares.
Hay dos alternativas. La primera es basada en el DOM pero utiliza Gráficos
Vectoriales Escalables (SVG), en lugar de HTML. Piensa en SVG como un
dialecto de marcado de documento que se centra en las formas en lugar de en
el texto. Puedes incrustar un documento SVG directamente en un documento
HTML o incluirlo con una etiqueta <img>.
La segunda alternativa se llama lienzo. Un lienzo es un solo elemento DOM
que encapsula una imagen. Proporciona una interfaz de programación para
dibujar formas en el espacio ocupado por el nodo. La principal diferencia
entre un lienzo y una imagen SVG es que en SVG se conserva la descripción
original de las formas para que puedan moverse o redimensionarse en cualquier
momento. Un lienzo, por otro lado, convierte las formas en píxels (puntos de
color en una cuadrícula) en cuanto se dibujan y no recuerda qué representan
estos píxeles. La única forma de mover una forma en un lienzo es borrar el
lienzo (o la parte del lienzo alrededor de la forma) y volver a dibujarlo con la
forma en una nueva posición.
SVG
Este libro no se adentrará en detalles sobre SVG, pero explicaré brevemente
cómo funciona. Al final del capítulo, volveré a los compromisos que debes
considerar al decidir qué mecanismo de dibujo es adecuado para una aplicación
284

-- 296 of 445 --

determinada.
Este es un documento HTML con una sencilla imagen SVG en él:
<p>Aquí va HTML normal.</p>
<svg xmlns="http://www.w3.org/2000/svg">
<circle r="50" cx="50" cy="50" fill="red"/>
<rect x="120" y="5" width="90" height="90"
stroke="blue" fill="none"/>
</svg>
El documento se muestra de la siguiente manera:
Estas etiquetas crean elementos del DOM, al igual que las etiquetas HTML,
con las que los scripts pueden interactuar. Por ejemplo, esto cambia el elemento
<circle> para que se coloree de cian:
let circle = document.querySelector("circle");
circle.setAttribute("fill", "cyan");
El elemento canvas
Los gráficos en lienzo pueden ser dibujados en un elemento <canvas>. Puedes
darle a dicho elemento atributos width y height para determinar su tamaño en
píxels.
Un lienzo nuevo está vacío, lo que significa que es completamente transpar-
ente y por lo tanto se muestra como espacio vacío en el documento.
La etiqueta <canvas> está destinada a permitir diferentes estilos de dibujo.
Para acceder a una interfaz de dibujo real, primero necesitamos crear un con-
texto, un objeto cuyos métodos proporcionan la interfaz de dibujo. Actualmente
existen tres estilos de dibujo ampliamente compatibles: "2d" para gráficos
bidimensionales, "webgl" para gráficos tridimensionales a través de la inter-
faz OpenGL, y "webgpu", una alternativa más moderna y flexible a WebGL.
Este libro no discutirá WebGL ni WebGPU—nos mantendremos en dos di-
mensiones. Pero si estás interesado en gráficos tridimensionales, te animo a
investigar sobre WebGPU. Proporciona una interfaz directa al hardware grá-
285

-- 297 of 445 --

fico y te permite renderizar escenas incluso complicadas de manera eficiente,
utilizando JavaScript.
Creas un contexto con el método getContext en el elemento DOM <canvas>.
<p>Antes del lienzo.</p>
<canvas width="120" height="60"></canvas>
<p>Después del lienzo.</p>
<script>
let canvas = document.querySelector("canvas");
let context = canvas.getContext("2d");
context.fillStyle = "red";
context.fillRect(10, 10, 100, 50);
</script>
Después de crear el objeto de contexto, el ejemplo dibuja un rectángulo rojo
de 100 píxeles de ancho y 50 píxeles de alto, con su esquina superior izquierda
en las coordenadas (10,10).
Al igual que en HTML (y SVG), el sistema de coordenadas que utiliza el
lienzo sitúa el (0,0) en la esquina superior izquierda, y el eje y-positivo va hacia
abajo desde allí. Por lo tanto, (10,10) está 10 píxeles abajo y a la derecha de
la esquina superior izquierda.
Líneas y superficies
En la interfaz de lienzo, una forma puede ser rellenada, lo que significa que su
área recibe un color o patrón determinado, o puede ser trazada, lo que significa
que se dibuja una línea a lo largo de su borde. La misma terminología se utiliza
en SVG.
El método fillRect rellena un rectángulo. Primero toma las coordenadas x
e y de la esquina superior izquierda del rectángulo, luego su ancho y finalmente
su altura. Un método similar llamado strokeRect dibuja el contorno de un
rectángulo.
Ninguno de los métodos toma más parámetros. El color del relleno, el grosor
del trazo, y demás, no son determinados por un argumento del método, como
podrías esperar razonablemente, sino por propiedades del objeto contexto.
286

-- 298 of 445 --

La propiedad fillStyle controla la forma en que se rellenan las formas.
Puede establecerse como una cadena que especifica un color, utilizando la no-
tación de color utilizada por CSS.
La propiedad strokeStyle funciona de manera similar, pero determina el
color utilizado para una línea contorneada. El ancho de esa línea se deter-
mina mediante la propiedad lineWidth, que puede contener cualquier número
positivo.
<canvas></canvas>
<script>
let cx = document.querySelector("canvas").getContext("2d");
cx.strokeStyle = "blue";
cx.strokeRect(5, 5, 50, 50);
cx.lineWidth = 5;
cx.strokeRect(135, 5, 50, 50);
</script>
Este código dibuja dos cuadrados azules, usando una línea más gruesa para el
segundo.
Cuando no se especifica ningún atributo width o height, como en el ejemplo,
un elemento canvas obtiene un ancho predeterminado de 300 píxeles y una
altura de 150 píxeles.
Caminos
Un camino es una secuencia de líneas. La interfaz del canvas 2D toma un
enfoque peculiar para describir un camino. Se realiza completamente a través
de efecto secundarios. Los caminos no son valores que se puedan almacenar y
pasar. En su lugar, si deseas hacer algo con un camino, haces una secuencia de
llamadas a métodos para describir su forma.
<canvas></canvas>
<script>
let cx = document.querySelector("canvas").getContext("2d");
cx.beginPath();
for (let y = 10; y < 100; y += 10) {
cx.moveTo(10, y);
cx.lineTo(90, y);
287

-- 299 of 445 --

}
cx.stroke();
</script>
Este ejemplo crea un camino con varios segmentos horizontales de línea y luego
lo traza usando el método stroke. Cada segmento creado con lineTo comienza
en la posición actual del camino. Esa posición suele ser el final del último
segmento, a menos que se haya llamado a moveTo. En ese caso, el siguiente
segmento comenzaría en la posición pasada a moveTo.
El camino descrito por el programa anterior se ve así:
Cuando se rellena un camino (usando el método fill), cada forma se llena
por separado. Un camino puede contener múltiples formas—cada movimiento
de moveTo inicia una nueva forma. Pero el camino necesita estar cerrado (sig-
nificando que su inicio y final están en la misma posición) antes de poder ser
rellenado. Si el camino aún no está cerrado, se agrega una línea desde su final
hasta su inicio, y se rellena la forma encerrada por el camino completado.
<canvas></canvas>
<script>
let cx = document.querySelector("canvas").getContext("2d");
cx.beginPath();
cx.moveTo(50, 10);
cx.lineTo(10, 70);
cx.lineTo(90, 70);
cx.fill();
</script>
Este ejemplo dibuja un triángulo relleno. Ten en cuenta que solo se dibujan
explícitamente dos de los lados del triángulo. El tercero, desde la esquina
inferior derecha de regreso a la parte superior, se da por implícito y no estaría
allí cuando se traze el recorrido.
También puedes usar el método closePath para cerrar explícitamente un
recorrido agregando un segmento real line de vuelta al inicio del recorrido.
288

-- 300 of 445 --

Este segmento se dibuja cuando se traza el recorrido.
Curvas
Un recorrido también puede contener líneas curvadas. Lamentablemente, estas
son un poco más complicadas de dibujar.
El método quadraticCurveTo dibuja una curva hacia un punto dado. Para
determinar la curvatura de la línea, el método recibe un punto de control así
como un punto de destino. Imagina este punto de control como atrayendo
la línea, dándole su curva. La línea no pasará por el punto de control, pero
su dirección en los puntos de inicio y fin será tal que una línea recta en esa
dirección apuntaría hacia el punto de control. El siguiente ejemplo ilustra esto:
<canvas></canvas>
<script>
let cx = document.querySelector("canvas").getContext("2d");
cx.beginPath();
cx.moveTo(10, 90);
// control=(60,10) meta=(90,90)
cx.quadraticCurveTo(60, 10, 90, 90);
cx.lineTo(60, 10);
cx.closePath();
cx.stroke();
</script>
Produce un recorrido que se ve así:
Dibujamos una curva cuadrática de izquierda a derecha, con (60,10) como
punto de control, y luego dibujamos dos segmentos line que pasan por ese punto
de control y vuelven al inicio de la línea. El resultado se asemeja a un emblema
de Star Trek. Puedes ver el efecto del punto de control: las líneas que salen de
las esquinas inferiores comienzan en la dirección del punto de control y luego
se curvan hacia su objetivo.
El método bezierCurveTo dibuja un tipo de curva similar. En lugar de un
único punto de control, este tiene dos—uno para cada uno de los extremos de
la línea. Aquí hay un boceto similar para ilustrar el comportamiento de dicha
curva:
289

-- 301 of 445 --

<canvas></canvas>
<script>
let cx = document.querySelector("canvas").getContext("2d");
cx.beginPath();
cx.moveTo(10, 90);
// control1=(10,10) control2=(90,10) meta=(50,90)
cx.bezierCurveTo(10, 10, 90, 10, 50, 90);
cx.lineTo(90, 10);
cx.lineTo(10, 10);
cx.closePath();
cx.stroke();
</script>
Los dos puntos de control especifican la dirección en ambos extremos de la
curva. Cuanto más separados estén de su punto correspondiente, más la curva
“abultará" en esa dirección.
curves como estas pueden ser difíciles de trabajar, no siempre es claro cómo
encontrar los control points que proporcionan la forma que estás buscando. A
veces puedes calcularlos y a veces simplemente tendrás que encontrar un valor
adecuado mediante prueba y error.
El método arc es una forma de dibujar una línea que se curva a lo largo del
borde de un círculo. Toma un par de coordenadas para el centro del arco, un
radio, y luego un ángulo de inicio y un ángulo final.
Estos últimos dos parámetros permiten dibujar solo parte del círculo. Los
ángulos se miden en radianes, no en grados. Esto significa que un círculo
completo tiene un ángulo de 2π, o 2 * Math.PI, que es aproximadamente 6.28.
El ángulo comienza a contar en el punto a la derecha del centro del círculo y
va en sentido horario desde allí. Puedes usar un inicio de 0 y un final mayor
que 2π (por ejemplo, 7) para dibujar un círculo completo.
<canvas></canvas>
<script>
let cx = document.querySelector("canvas").getContext("2d");
cx.beginPath();
// centro=(50,50) radio=40 ángulo=0 a 7
cx.arc(50, 50, 40, 0, 7);
// centro=(150,50) radio=40 ángulo=0 a π½
cx.arc(150, 50, 40, 0, 0.5 * Math.PI);
290

-- 302 of 445 --

cx.stroke();
</script>
La imagen resultante contiene una línea desde la derecha del círculo completo
(primer llamado a arc) hasta la derecha del cuarto del círculo (segundo lla-
mado). Al igual que otros métodos de dibujo de trayectos, una línea dibujada
con arc está conectada al segmento de trayecto anterior. Puedes llamar a
moveTo o comenzar un nuevo trayecto para evitar esto.
Dibujo de un diagrama de sectores
Imagina que acabas de aceptar un trabajo en EconomiCorp, Inc., y tu primera
tarea es dibujar un diagrama de sectores de los resultados de la encuesta de
satisfacción de los clientes.
El enlace results contiene una matriz de objetos que representan las re-
spuestas de la encuesta.
const results = [
{name: "Satisfecho", count: 1043, color: "lightblue"},
{name: "Neutral", count: 563, color: "lightgreen"},
{name: "Insatisfecho", count: 510, color: "pink"},
{name: "Sin comentario", count: 175, color: "silver"}
];
Para dibujar un diagrama de sectores, dibujamos una serie de sectores circu-
lares, cada uno compuesto por un arco y un par de líneas hacia el centro de
ese arco. Podemos calcular el ángulo ocupado por cada arco dividiendo un
círculo completo (2π) por el número total de respuestas y luego multiplicando
ese número (el ángulo por respuesta) por el número de personas que eligieron
una opción determinada.
<canvas width="200" height="200"></canvas>
<script>
let cx = document.querySelector("canvas").getContext("2d");
let total = results
.reduce((sum, {count}) => sum + count, 0);
// Comenzar en la parte superior
291

-- 303 of 445 --

let currentAngle = -0.5 * Math.PI;
for (let result of results) {
let sliceAngle = (result.count / total) * 2 * Math.PI;
cx.beginPath();
// centro=100,100, radio=100
// desde el ángulo actual, en sentido horario por el ángulo del
sector
cx.arc(100, 100, 100,
currentAngle, currentAngle + sliceAngle);
currentAngle += sliceAngle;
cx.lineTo(100, 100);
cx.fillStyle = result.color;
cx.fill();
}
</script>
Esto dibuja el siguiente gráfico:
Pero un gráfico que no nos dice qué significan las porciones no es muy útil.
Necesitamos una forma de dibujar texto en el canvas.
Texto
Un contexto de dibujo en lienzo 2D proporciona los métodos fillText y strokeText
. Este último puede ser útil para contornear letras, pero generalmente fillText
es lo que necesitas. Este llenará el contorno del texto dado con el fillStyle
actual.
<canvas></canvas>
<script>
let cx = document.querySelector("canvas").getContext("2d");
cx.font = "28px Georgia";
cx.fillStyle = "fuchsia";
cx.fillText("¡También puedo dibujar texto!", 10, 50);
292

-- 304 of 445 --

</script>
Puedes especificar el tamaño, estilo y fuente del texto con la propiedad font.
Este ejemplo solo da un tamaño de fuente y un nombre de familia. También
es posible agregar italic o bold al comienzo de la cadena para seleccionar un
estilo.
Los dos últimos argumentos de fillText y strokeText proporcionan la posi-
ción en la que se dibuja la fuente. Por defecto, indican la posición del inicio
de la línea alfabética del texto, que es la línea en la que las letras “se paran”,
sin contar las partes colgantes en letras como la j o la p. Puedes cambiar la
posición horizontal configurando la propiedad textAlign en "end" o "center" y
la posición vertical configurando textBaseline en "top", "middle" o "bottom".
Volveremos a nuestro gráfico circular y al problema de etiquetar las porciones,
en los ejercicios al final del capítulo.
Imágenes
En gráficos por computadora, a menudo se hace una distinción entre gráfi-
cos vectoriales y gráficos de mapa de bits. El primero es lo que hemos estado
haciendo hasta ahora en este capítulo: especificar una imagen dando una de-
scripción lógica de las formas. Los gráficos de mapa de bits, por otro lado,
no especifican formas reales, sino que trabajan con datos de píxel (rasteros de
puntos de colores).
El método drawImage nos permite dibujar datos de píxel en un canvas. Estos
datos de píxel pueden originarse desde un elemento <img> o desde otro lienzo.
El siguiente ejemplo crea un elemento <img> independiente y carga un archivo
de imagen en él. Pero no podemos comenzar a dibujar inmediatamente desde
esta imagen porque es posible que el navegador aún no la haya cargado. Para
manejar esto, registramos un controlador de eventos "load" y hacemos el dibujo
después de que la imagen se haya cargado.
<canvas></canvas>
<script>
let cx = document.querySelector("canvas").getContext("2d");
let img = document.createElement("img");
img.src = "img/hat.png";
img.addEventListener("load", () => {
for (let x = 10; x < 200; x += 30) {
cx.drawImage(img, x, 10);
}
});
</script>
293

-- 305 of 445 --

Por defecto, drawImage dibujará la imagen a su tamaño original. También se
le pueden proporcionar dos argumentos adicionales para establecer un ancho y
alto diferente.
Cuando se utilizan nueve argumentos en drawImage, se puede usar para dibu-
jar solo un fragmento de una imagen. Los argumentos segundo a quinto indican
el rectángulo (x, y, ancho y alto) en la imagen de origen que se debería copiar,
y los argumentos sexto a noveno indican el rectángulo (en el lienzo) en el cual
se debería copiar.
Esto se puede utilizar para empaquetar varios sprites (elementos de imagen)
en un único archivo de imagen y luego dibujar solo la parte que se necesita. Por
ejemplo, tenemos esta imagen que contiene un personaje de juego en múltiples
poses:
Alternando qué pose dibujamos, podemos mostrar una animación que parece
un personaje caminando.
Para animar una imagen en un lienzo, el método clearRect es útil. Se ase-
meja a fillRect, pero en lugar de colorear el rectángulo, lo vuelve transparente,
eliminando los píxeles dibujados anteriormente.
Sabemos que cada sprite, cada subimagen, tiene un ancho de 24 píxeles y
una altura de 30 píxeles. El siguiente código carga la imagen y luego establece
un intervalo (temporizador repetido) para dibujar el siguiente frame:
<canvas></canvas>
<script>
let cx = document.querySelector("canvas").getContext("2d");
let img = document.createElement("img");
img.src = "img/player.png";
let spriteW = 24, spriteH = 30;
img.addEventListener("load", () => {
let ciclo = 0;
setInterval(() => {
cx.clearRect(0, 0, spriteW, spriteH);
cx.drawImage(img,
// rectángulo de origen
ciclo * spriteW, 0, spriteW, spriteH,
// rectángulo de destino
0, 0, spriteW, spriteH);
ciclo = (ciclo + 1) % 8;
}, 120);
});
</script>
294

-- 306 of 445 --

El enlace ciclo sigue nuestra posición en la animación. En cada frame, se
incrementa y luego se recorta de nuevo al rango de 0 a 7 usando el operador
de resto. Este enlace se utiliza luego para calcular la coordenada x que tiene el
sprite para la pose actual en la imagen.
Transformación
Pero, ¿qué pasa si queremos que nuestro personaje camine hacia la izquierda
en lugar de hacia la derecha? Podríamos dibujar otro conjunto de sprites, por
supuesto. Pero también podemos instruir al lienzo para que dibuje la imagen
en sentido contrario.
Llamar al método scale hará que todo lo que se dibuje después de él se escale.
Este método toma dos parámetros, uno para establecer una escala horizontal
y otro para establecer una escala vertical.
<canvas></canvas>
<script>
let cx = document.querySelector("canvas").getContext("2d");
cx.scale(3, .5);
cx.beginPath();
cx.arc(50, 50, 40, 0, 7);
cx.lineWidth = 3;
cx.stroke();
</script>
Debido a la llamada a scale, el círculo se dibuja tres veces más ancho y la
mitad de alto.
Escalar hará que todo en la imagen dibujada, incluyendo el grosor de línea,
se estire o se comprima como se especifique. Escalar por una cantidad negativa
volteará la imagen. La volteadura ocurre alrededor del punto (0,0), lo que
significa que también volteará la dirección del sistema de coordenadas. Cuando
se aplica una escala horizontal de -1, una forma dibujada en la posición x 100
terminará en lo que solía ser la posición -100.
Así que para voltear una imagen, no podemos simplemente agregar cx.scale
(-1, 1) antes de la llamada a drawImage porque eso movería nuestra imagen
fuera del lienzo, donde no sería visible. Podrías ajustar las coordenadas dadas
a drawImage para compensar esto dibujando la imagen en la posición x -50 en
lugar de 0. Otra solución, que no requiere que el código que hace el dibujo sepa
295

-- 307 of 445 --

sobre el cambio de escala, es ajustar el eje alrededor del cual ocurre el escalado.
Hay varios otros métodos además de scale que influyen en el sistema de
coordenadas de un lienzo. Puedes rotar formas dibujadas posteriormente con
el método rotate y moverlas con el método translate. Lo interesante—y
confuso—es que estas transformaciones se apilan, lo que significa que cada una
ocurre relativa a las transformaciones anteriores.
Entonces, si traducimos por 10 píxeles horizontales dos veces, todo se dibu-
jará 20 píxeles a la derecha. Si primero movemos el centro del sistema de
coordenadas a (50,50) y luego rotamos por 20 grados (aproximadamente 0.1π
radianes), esa rotación ocurrirá alrededor del punto (50,50).
translate(50, 50)
rotate(0.1*Math.PI)
rotate(0.1*Math.PI)
translate(50, 50)
Pero si primero rotamos 20 grados y luego traducimos por (50,50), la traduc-
ción ocurrirá en el sistema de coordenadas rotado y producirá una orientación
diferente. El orden en el que se aplican las transformaciones es importante.
Para voltear una imagen alrededor de la línea vertical en una posición x
dada, podemos hacer lo siguiente:
function flipHorizontally(context, around) {
context.translate(around, 0);
context.scale(-1, 1);
context.translate(-around, 0);
}
Movemos el eje y a donde queremos que esté nuestro espejo, aplicamos el efecto
de espejo y finalmente devolvemos el eje y a su lugar adecuado en el universo
espejado. La siguiente imagen explica por qué esto funciona:
mirror
1 	2	3 	4
Esto muestra los sistemas de coordenadas antes y después del espejo a través
296

-- 308 of 445 --

de la línea central. Los triángulos están numerados para ilustrar cada paso.
Si dibujamos un triángulo en una posición x positiva, por defecto estaría en
el lugar donde se encuentra el triángulo 1. Una llamada a flipHorizontally
primero realiza una traslación a la derecha, lo que nos lleva al triángulo 2.
Luego escala, volteando el triángulo a la posición 3. Esto no es donde debería
estar, si estuviera reflejado en la línea dada. La segunda llamada a translate
corrige esto, “cancela” la traslación inicial y hace que el triángulo 4 aparezca
exactamente donde debería.
Ahora podemos dibujar un personaje espejado en la posición (100,0) volte-
ando el mundo alrededor del centro vertical del personaje.
<canvas></canvas>
<script>
let cx = document.querySelector("canvas").getContext("2d");
let img = document.createElement("img");
img.src = "img/jugador.png";
let spriteW = 24, spriteH = 30;
img.addEventListener("load", () => {
flipHorizontally(cx, 100 + spriteW / 2);
cx.drawImage(img, 0, 0, spriteW, spriteH,
100, 0, spriteW, spriteH);
});
</script>
Almacenando y eliminando transformaciones
Las transformaciones permanecen. Todo lo que dibujemos después de ese per-
sonaje espejado también estará reflejado. Eso podría ser inconveniente.
Es posible guardar la transformación actual, hacer algunos dibujos y trans-
formaciones, y luego restaurar la antigua transformación. Esto suele ser lo
apropiado para una función que necesita transformar temporalmente el sistema
de coordenadas. Primero, guardamos cualquier transformación que estuviera
utilizando el código que llamó a la función. Luego, la función realiza su tarea,
agregando más transformaciones sobre la transformación actual. Finalmente,
volvemos a la transformación con la que comenzamos.
Los métodos save y restore en el contexto 2D del lienzo hacen este manejo
de transformaciones. Conceptualmente mantienen una pila de estados de trans-
formación. Cuando llamas a save, el estado actual se apila, y cuando llamas
a restore, se elimina el estado de la cima de la pila y se usa como la trans-
formación actual del contexto. También puedes llamar a resetTransform para
restablecer completamente la transformación.
297

-- 309 of 445 --

La función branch en el siguiente ejemplo ilustra lo que puedes hacer con una
función que cambia la transformación y luego llama a una función (en este caso
a sí misma), que continúa dibujando con la transformación dada.Esta función
dibuja una forma parecida a un árbol dibujando una línea, moviendo el centro
del sistema de coordenadas al final de la línea, y llamándose a sí misma dos
veces, primero rotada a la izquierda y luego rotada a la derecha. Cada llamada
reduce la longitud de la rama dibujada, y la recursividad se detiene cuando la
longitud desciende por debajo de 8.
<canvas width="600" height="300"></canvas>
<script>
let cx = document.querySelector("canvas").getContext("2d");
function branch(length, angle, scale) {
cx.fillRect(0, 0, 1, length);
if (length < 8) return;
cx.save();
cx.translate(0, length);
cx.rotate(-angle);
branch(length * scale, angle, scale);
cx.rotate(2 * angle);
branch(length * scale, angle, scale);
cx.restore();
}
cx.translate(300, 0);
branch(60, 0.5, 0.8);
</script>
El resultado es un fractal simple.
Si las llamadas a save y restore no estuvieran allí, la segunda llamada
recursiva a branch terminaría con la posición y rotación creadas por la primera
llamada. No estaría conectada a la rama actual sino más bien a la rama más
interna y a la derecha dibujada por la primera llamada. La forma resultante
podría ser interesante, pero definitivamente no sería un árbol.
298

-- 310 of 445 --

De vuelta al juego
Ahora sabemos lo suficiente sobre el dibujo en canvas para empezar a trabajar
en un sistema de display basado en canvas para el juego del capítulo anterior.
El nuevo display ya no mostrará solo cajas de colores. En su lugar, usaremos
drawImage para dibujar imágenes que representen los elementos del juego.
Definimos otro tipo de objeto de display llamado CanvasDisplay, que so-
porta la misma interfaz que DOMDisplay del Capítulo 16, es decir, los métodos
syncState y clear.
Este objeto mantiene un poco más de información que DOMDisplay. En lu-
gar de utilizar la posición de desplazamiento de su elemento DOM, realiza un
seguimiento de su propio viewport, que nos indica qué parte del nivel estamos
viendo actualmente. Por último, mantiene una propiedad flipPlayer para que
incluso cuando el jugador esté quieto, siga mirando en la dirección en la que se
movió por última vez.
class CanvasDisplay {
constructor(parent, level) {
this.canvas = document.createElement("canvas");
this.canvas.width = Math.min(600, level.width * scale);
this.canvas.height = Math.min(450, level.height * scale);
parent.appendChild(this.canvas);
this.cx = this.canvas.getContext("2d");
this.flipPlayer = false;
this.viewport = {
left: 0,
top: 0,
width: this.canvas.width / scale,
height: this.canvas.height / scale
};
}
clear() {
this.canvas.remove();
}
}
El método syncState primero calcula un nuevo viewport y luego dibuja la
escena del juego en la posición adecuada.
CanvasDisplay.prototype.syncState = function(state) {
this.updateViewport(state);
299

-- 311 of 445 --

this.clearDisplay(state.status);
this.drawBackground(state.level);
this.drawActors(state.actors);
};
A diferencia de DOMDisplay, este estilo de visualización sí tiene que redibujar
el fondo en cada actualización. Debido a que las formas en un lienzo son solo
píxeles, una vez que las dibujamos no hay una buena manera de moverlas (o
eliminarlas). La única forma de actualizar la visualización en lienzo es borrarla
y volver a dibujar la escena. También puede ser que hayamos hecho scroll, lo
que requeriría que el fondo esté en una posición diferente.
El método updateViewport es similar al método scrollPlayerIntoView de
DOMDisplay. Verifica si el jugador está demasiado cerca del borde de la pantalla
y mueve el viewport en ese caso.
CanvasDisplay.prototype.updateViewport = function(state) {
let view = this.viewport, margin = view.width / 3;
let player = state.player;
let center = player.pos.plus(player.size.times(0.5));
if (center.x < view.left + margin) {
view.left = Math.max(center.x - margin, 0);
} else if (center.x > view.left + view.width - margin) {
view.left = Math.min(center.x + margin - view.width,
state.level.width - view.width);
}
if (center.y < view.top + margin) {
view.top = Math.max(center.y - margin, 0);
} else if (center.y > view.top + view.height - margin) {
view.top = Math.min(center.y + margin - view.height,
state.level.height - view.height);
}
};
Las llamadas a Math.max y Math.min aseguran que el viewport no termine
mostrando espacio fuera del nivel. Math.max(x, 0) se asegura de que el número
resultante no sea menor que cero. Math.min garantiza de manera similar que
un valor se mantenga por debajo de un límite dado.
Al limpiar la visualización, usaremos un color ligeramente diferente según si
el juego se ha ganado (más brillante) o perdido (más oscuro).
CanvasDisplay.prototype.clearDisplay = function(status) {
if (status == "won") {
this.cx.fillStyle = "rgb(68, 191, 255)";
} else if (status == "lost") {
300

-- 312 of 445 --

this.cx.fillStyle = "rgb(44, 136, 214)";
} else {
this.cx.fillStyle = "rgb(52, 166, 251)";
}
this.cx.fillRect(0, 0,
this.canvas.width, this.canvas.height);
};
Para dibujar el fondo, recorremos los mosaicos que son visibles en el viewport
actual, utilizando el mismo truco usado en el método touches del capítulo
anterior.
let otherSprites = document.createElement("img");
otherSprites.src = "img/sprites.png";
CanvasDisplay.prototype.drawBackground = function(level) {
let {left, top, width, height} = this.viewport;
let xStart = Math.floor(left);
let xEnd = Math.ceil(left + width);
let yStart = Math.floor(top);
let yEnd = Math.ceil(top + height);
for (let y = yStart; y < yEnd; y++) {
for (let x = xStart; x < xEnd; x++) {
let tile = level.rows[y][x];
if (tile == "empty") continue;
let screenX = (x - left) * scale;
let screenY = (y - top) * scale;
let tileX = tile == "lava" ? scale : 0;
this.cx.drawImage(otherSprites,
tileX, 0, scale, scale,
screenX, screenY, scale, scale);
}
}
};
Las casillas que no están vacías se dibujan con drawImage. La imagen otherSprites
contiene las imágenes utilizadas para elementos que no son el jugador. Con-
tiene, de izquierda a derecha, la casilla de pared, la casilla de lava y el sprite
de una moneda.
Las casillas de fondo son de 20 por 20 píxeles ya que usaremos la misma
escala que en DOMDisplay. Por lo tanto, el desplazamiento para las casillas de
lava es 20 (el valor del enlace scale), y el desplazamiento para las paredes es
301

-- 313 of 445 --

0.
No nos molesta esperar a que se cargue la imagen del sprite. Llamar a
drawImage con una imagen que aún no se ha cargado simplemente no hará
nada. Por lo tanto, podríamos no dibujar correctamente el juego durante los
primeros cuadros, mientras la imagen aún se está cargando, pero eso no es un
problema grave. Dado que seguimos actualizando la pantalla, la escena correcta
aparecerá tan pronto como termine la carga.
El personaje de movimiento que se mostró anteriormente se utilizará para
representar al jugador. El código que lo dibuja necesita seleccionar el sprite
adecuado y la dirección basándose en el movimiento actual del jugador. Los
primeros ocho sprites contienen una animación de caminar. Cuando el jugador
se está moviendo a lo largo de una superficie, los recorremos según el tiempo
actual. Queremos cambiar de fotogramas cada 60 milisegundos, por lo que
primero dividimos el tiempo por 60. Cuando el jugador está quieto, dibujamos
el noveno sprite. Durante los saltos, que se reconocen por el hecho de que la
velocidad vertical no es cero, usamos el décimo sprite de la derecha.
Dado que los sprites son ligeramente más anchos que el objeto del jugador—
24 en lugar de 16 píxeles para permitir algo de espacio para los pies y los
brazos—el método debe ajustar la coordenada x y el ancho por una cantidad
dada (playerXOverlap).
let playerSprites = document.createElement("img");
playerSprites.src = "img/player.png";
const playerXOverlap = 4;
CanvasDisplay.prototype.drawPlayer = function(player, x, y,
width, height){
width += playerXOverlap * 2;
x -= playerXOverlap;
if (player.speed.x != 0) {
this.flipPlayer = player.speed.x < 0;
}
let tile = 8;
if (player.speed.y != 0) {
tile = 9;
} else if (player.speed.x != 0) {
tile = Math.floor(Date.now() / 60) % 8;
}
this.cx.save();
if (this.flipPlayer) {
flipHorizontally(this.cx, x + width / 2);
302

-- 314 of 445 --

}
let tileX = tile * width;
this.cx.drawImage(playerSprites, tileX, 0, width, height,
x, y, width, height);
this.cx.restore();
};
El método drawPlayer es llamado por drawActors, el cual es responsable de
dibujar todos los actores en el juego.
CanvasDisplay.prototype.drawActors = function(actors) {
for (let actor of actors) {
let width = actor.size.x * scale;
let height = actor.size.y * scale;
let x = (actor.pos.x - this.viewport.left) * scale;
let y = (actor.pos.y - this.viewport.top) * scale;
if (actor.type == "player") {
this.drawPlayer(actor, x, y, width, height);
} else {
let tileX = (actor.type == "coin" ? 2 : 1) * scale;
this.cx.drawImage(otherSprites,
tileX, 0, width, height,
x, y, width, height);
}
}
};
Cuando se está dibujando algo que no es el jugador, miramos su tipo para
encontrar el desplazamiento del sprite correcto. El tile de lava se encuentra en
el desplazamiento 20, y el sprite de la moneda se encuentra en 40 (dos veces
scale).
Tenemos que restar la posición del viewport al calcular la posición del actor,
ya que (0,0) en nuestro canvas corresponde a la esquina superior izquierda del
viewport, no a la esquina superior izquierda del nivel. También podríamos
haber usado translate para esto. De ambas maneras funciona.
Eso concluye el nuevo sistema de display. El juego resultante se ve algo así:
303

-- 315 of 445 --

Elección de una interfaz gráfica
Por lo tanto, cuando necesitas generar gráficos en el navegador, puedes elegir
entre HTML simple, SVG y canvas. No hay un enfoque único mejor que fun-
cione en todas las situaciones. Cada opción tiene sus fortalezas y debilidades.
HTML simple tiene la ventaja de ser simple. También se integra bien con
texto. Tanto SVG como canvas te permiten dibujar texto, pero no te ayudarán
a posicionar ese texto o envolverlo cuando ocupa más de una línea. En una
imagen basada en HTML, es mucho más fácil incluir bloques de texto.
SVG se puede utilizar para producir gráficos nítidos que se ven bien en
cualquier nivel de zoom. A diferencia de HTML, está diseñado para dibujar y,
por lo tanto, es más adecuado para ese propósito.
Tanto SVG como HTML construyen una estructura de datos (el DOM) que
representa tu imagen. Esto hace posible modificar elementos después de ser
dibujados. Si necesitas cambiar repetidamente una pequeña parte de una ima-
gen grande en respuesta a lo que está haciendo el usuario o como parte de una
animación, hacerlo en un canvas puede ser innecesariamente costoso. El DOM
también nos permite registrar manipuladores de eventos de ratón en cada ele-
mento de la imagen (incluso en formas dibujadas con SVG). No puedes hacer
eso con canvas.
Pero el enfoque orientado a píxeles de canvas puede ser una ventaja al dibu-
jar una gran cantidad de elementos pequeños. El hecho de que no construye
una estructura de datos, sino que solo dibuja repetidamente sobre la misma
superficie de píxeles, hace que canvas tenga un menor costo por forma.
También hay efectos, como renderizar una escena píxel por píxel (por ejem-
plo, usando un ray tracer) o procesar una imagen con JavaScript (desenfocarla
o distorsionarla), que solo son prácticos con un elemento canvas.
En algunos casos, puede que desees combinar varias de estas técnicas. Por
304

-- 316 of 445 --

ejemplo, podrías dibujar un gráfico con SVG o canvas pero mostrar información
textual posicionando un elemento HTML encima de la imagen.
Para aplicaciones poco exigentes, realmente no importa mucho qué interfaz
elijas. La visualización que construimos para nuestro juego en este capítulo
podría haber sido implementada utilizando cualquiera de estas tres tecnologías
gráficas ya que no necesita dibujar texto, manejar interacción del mouse o
trabajar con una cantidad extraordinariamente grande de elementos.
Resumen
En este capítulo discutimos técnicas para dibujar gráficos en el navegador,
centrándonos en el elemento <canvas>.
Un nodo canvas representa un área en un documento en la que nuestro pro-
grama puede dibujar. Este dibujo se realiza a través de un objeto de contexto
de dibujo, creado con el método getContext.
La interfaz de dibujo 2D nos permite rellenar y trazar varias formas. La
propiedad fillStyle del contexto determina cómo se rellenan las formas. Las
propiedades strokeStyle y lineWidth controlan la forma en que se dibujan las
líneas.
Los rectángulos y trozos de texto se pueden dibujar con una sola llamada a
método. Los métodos fillRect y strokeRect dibujan rectángulos, y los méto-
dos fillText y strokeText dibujan texto. Para crear formas personalizadas,
primero debemos construir un camino.
Llamar a beginPath inicia un nuevo camino. Varios otros métodos agregan
líneas y curvas al camino actual. Por ejemplo, lineTo puede agregar una línea
recta. Cuando un camino está terminado, se puede rellenar con el método fill
o trazarse con el método stroke.
Mover píxeles desde una imagen u otro canvas a nuestro canvas se hace con
el método drawImage. Por defecto, este método dibuja toda la imagen fuente,
pero al darle más parámetros, puedes copiar un área específica de la imagen.
Utilizamos esto para nuestro juego copiando poses individuales del personaje
del juego de una imagen que contenía muchas poses.
Las transformaciones te permiten dibujar una forma en múltiples orienta-
ciones. Un contexto de dibujo 2D tiene una transformación actual que se
puede cambiar con los métodos translate, scale y rotate. Estos afectarán
todas las operaciones de dibujo subsiguientes. Un estado de transformación se
puede guardar con el método save y restaurar con el método restore.
Al mostrar una animación en un canvas, se puede usar el método clearRect
para borrar parte del canvas antes de volver a dibujarlo.
305

-- 317 of 445 --

Ejercicios
Formas
Escribe un programa que dibuje las siguientes formas en un lienzo canvas: