# Chapter 17

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 48)

## Contenido
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
Ninguno de lo
