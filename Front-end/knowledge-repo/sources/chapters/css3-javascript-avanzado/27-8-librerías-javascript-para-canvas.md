# 8. Librerías Javascript para canvas

8.1. Introducción
8.1.1. ¿Qué es el objeto canvas?
Como su nombre indica, es el equivalente a una tela de pintor donde dibujar
(canvas). Así, empleando Javascript podremos pintar y dibujar, crear objetos
vectoriales, añadir imágenes y textos y capturar eventos.
De hecho, podemos decir que con el objeto canvas tenemos un potente
punto de partida para generar animaciones e interactividad.
De entrada, ya vemos aplicaciones que nos permiten pintar gráficos de datos,
otras que hacen dibujos vectoriales e incluso juegos interactivos en 2 y 3 di-
mensiones.
Pero no todo es bueno, puesto que el soporte de este en la familia de Internet
Explorer no aparece hasta la revisión 9 (a pesar de que se puede emplear con
librerías que simulen la API), y que en cuanto a herramientas de programación
para la interacción es bastante primario. No disponemos de una API avanzada
que nos permita trabajar con capas/objetos/eventos/sprites, como permiten
otras tecnologías similares, como Silverlight o Adobe￿Flash.
Así, lo más adecuado para trabajar con aplicaciones es construir o emplear una
librería que nos simplifique el proceso de generación de código. Seguramente
la mejor manera de pensar en el objeto canvas es como un elemento que nos
puede permitir sustituir al Flash en su versión primaria, cuando todavía no era
un potente￿framework￿de￿desarrollo￿de￿aplicaciones￿web.
8.1.2. Canvas sin nada
Para poder explorar cómodamente los diferentes beneficios de emplear dife-
rentes librerías para canvas, en primer lugar, veremos cómo se utiliza sin nin-
guna librería, usando directamente la API que nos ofrece el navegador. Así,
empezaremos generando un nuevo objeto canvas con la etiqueta:
<canvas id="tutorial" width="150" height="150"></canvas>

-- 58 of 86 --

CC-BY-SA • PID_00176160 59 CSS3 y Javascript avanzado
Con esta etiqueta html, generaremos un objeto de dibujo cuadrado de 150 pí-
xeles de ancho. Como todos los elementos (objetos) html, lo podemos decorar
con estilos. Así, le definiremos un filete de 1 píxel de color gris con:
<canvas id="tutorial" width="150" height="150" style="border:1px solid grey"></canvas>
Para empezar a dibujar, primero deberemos obtener una referencia al objeto
canvas, document.getElementById('tutorial'),￿para￿después￿obtener￿una￿re-
ferencia￿ al contexto de dibujo en 2D, getContext('2d'). También existe un
método experimental que nos ofrece un acceso a dibujo en 3D (WebGL), me-
diante getContext('3d').
<script>
window.onload = function() {
var canvas = document.getElementById('tutorial');
var ctx = canvas.getContext('2d');
ctx.fillStyle = "rgb(200,0,0)";
ctx.fillRect (10, 10, 50, 50);
}
</script>
A partir de aquí, ya podemos empezar a emplear métodos del objeto canvas.
Con la solicitud fillStyle, definiremos el tipo de estilo de contenido, y con
fillRect, generaremos un cuadrado en las coordenadas 10,10, y con 50 píxeles
de anchura y altura, resultando:
8.1.3. Dibujar cosas
1)￿Sistema￿de￿coordenadas
La definición de coordenadas en canvas funciona de arriba abajo y de izquierda
a derecha. Así, la coordenada 10,50 indica un punto en la columna 10 y en
la fila 50.

-- 59 of 86 --

CC-BY-SA • PID_00176160 60 CSS3 y Javascript avanzado
2)￿Cuadrados
A diferencia de otras tecnologías, canvas sólo admite un tipo primitivo de for-
ma: los cuadrados. Pero también dispone de un potente sistema para generar
líneas y recorridos que pueden ser abiertos o cerrados.
Las instrucciones para generar cuadrados son:
ctx.fillRect(x,y,width,height): Dibuja un rectángulo lleno de color.
ctx.strokeRect(x,y,width,height): Dibuja un rectángulo a línea.
ctx.clearRect(x,y,width,height): Limpia y vuelve transparente el área especificada.
Las tres funciones reciben los mismos parámetros: (x,y) para el origen, y
(width,￿height) para la anchura y altura de la caja.
3)￿Líneas￿y￿caminos
El modo de dibujar líneas es diferente al de dibujar cuadrados. De hecho, fun-
ciona como si del lápiz se tratara. Primero la posicionamos y la acercamos al
papel, y vamos moviéndola mientras queramos que dibuje.
ctx.beginPath(); // Inicia la operación de dibujo.
ctx.moveTo(40, 40); // Coloca el puntero a 40, 40.
ctx.lineTo(340, 40); // Dibuja una línea hasta 340, 40.
ctx.closePath(); // Cierra el path.
ctx.stroke(); // Lo transforma en dibujo a línea.
4)￿Círculos
No existe un método específico para dibujar círculos con canvas, pero sí que
tenemos las herramientas para dibujarlos. De este modo, podemos utilizar el
método arco:
ctx.beginPath(); // Iniciamos el dibujo de un camino.

-- 60 of 86 --

CC-BY-SA • PID_00176160 61 CSS3 y Javascript avanzado
ctx.arc(100, 90, 50, 0, Math.PI*2, false); // Dibujamos un círculo.
ctx.closePath(); // Cerramos el camino.
ctx.fill(); // Llenamos de contenido.
El método arco admite seis parámetros. Los dos primeros son el punto central
de la circunferencia; el segundo, el radio; el tercero, el ángulo inicial; el cuarto,
el ángulo final (los￿ ángulos￿ en￿ radianes) y, finalmente, un booleano para
marcar si se debe dibujar en la dirección de las agujas del reloj o no.
Para poder convertir los grados en radianes, podemos emplear la siguiente
fórmula:
var degrees = 1; // 1 grado
var radians = degrees * (Math.PI / 180); // 0,0175 radianes
360 grados
360 grados, son 2*Math.PI.
5)￿Estilos￿de￿línea￿(stroke)￿y￿de￿relleno￿(fill)
Otra de las herramientas fáciles es la posibilidad de personalizar los estilos de
las líneas y rellenos que dibujamos, así:
ctx.fillStyle = "rgb(255, 0, 0)"; // Definiremos un color de relleno rojo.
ctx.strokeStyle = "rgb(255, 0, 0)"; // Definiremos un color de línea.
ctx.lineWidth = 20; // Define el grueso de la línea.
6)￿Texto
Disponemos de un método que nos permite escribir con el canvas:
var text = "Hello, World!";
ctx.font = "italic 20px serif";
ctx.fillText(text, 30, 80);
7)￿Añadiendo￿imágenes
Podemos añadir imágenes directamente a un objeto canvas. Para hacerlo:
var img = new Image();
img.src = "pathalaimatge.gif"
ctx.drawImage(img,0,0);
Al ser la imagen un objeto remoto, convendría esperar su descarga; así podría-
mos, utilizando jQuery, programar un pequeño preload:
var image = new Image();

-- 61 of 86 --

CC-BY-SA • PID_00176160 62 CSS3 y Javascript avanzado
image.src = "prueba.jpg";
$(image).load(function() {
ctx.drawImage(image, 0, 0);
});
Primero creamos un objeto tradicional imagen con Javascript para utilizarlo
como receptor de la descarga. Mediante el image.src, inicializamos la descarga.
Finalmente, con la función $(image).load programamos el evento onLoad en
la imagen, que nos la dibujará (colocará) en el objeto canvas. Podemos escalar
las￿imágenes directamente cuando las dibujemos sobre el canvas, utilizando
la función drawImage() de la siguiente manera:
ctx.drawImage(image, x, y, width, height);
Donde, width y height serán el ancho y alto respectivos que queremos utilizar.
También podemos recortar￿imágenes directamente al insertarlas en el canvas
con:
ctx.drawImage(image, sx, sy, sw, sh, dx, dy, dw, dh);
Donde sx,￿sy,￿sw,￿sh marcan el reencuadre de la imagen original; dx, dy, la
posición de este en el canvas, y dw, dh, el tamaño.
Sobre las imágenes podemos aplicar transformaciones como la rotación, la
escala y el origen. Así, en el siguiente ejemplo:
ctx.translate(20, 20);
ctx.rotate(0.7854); // Rotate 45 degrees
var image = new Image();
image.src = "example.jpg";
$(image).load(function() {
ctx.drawImage(image, 0, 0, 50, 50, -10, -10, 30, 30);
});
Trasladaremos el eje de rotación a 250,250 y después aplicaremos una rotación
en radianes de 0,7854. A partir de aquí, a los objetos que dibujemos se les
aplicarán estos cambios antes de dibujarlos.

-- 62 of 86 --

CC-BY-SA • PID_00176160 63 CSS3 y Javascript avanzado
Otra característica muy interesante del objeto canvas y las imágenes es la po-
sibilidad de acceder directamente a los píxeles que configuran una imagen.
Así, tenemos acceso a una matriz de los colores que conforman cada píxel y
los podemos modificar. Con esto, se abre la puerta a la posibilidad de confec-
cionar con Javascript multitud de efectos sobre imágenes directamente desde
el código. Para tener acceso a los píxeles, utilizaremos la función:
a = ctx.getImageData(x, y, width, height);
Esta nos devolverá un objeto con tres propiedades, el width, el height y una
data lista de píxeles del tipo CanvasPixelArray. Una lista con cada cuatro
posiciones representan un color en la forma RGBA.
a.data[0]; // componente red
a.data[1]; // componente green
a.data[2]; // componente blue
a.data[3]; // componente alpha
El componente a[5]￿ a￿ a[8] será el siguiente píxel. Cabe decir también que
en este array no hay filas ni columnas, y por tanto, las deberemos deducir
nosotros a partir del width de imagen.
De una manera sencilla, podemos confeccionar el típico efecto de ruido gene-
rando una imagen desde 0 que escribiremos en el objeto canvas con:
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
window.onload = function()
{
var canvas = document.getElementById('ejercicio');
var pt = canvas.getContext('2de');
setInterval(function() {
// generamos un array de píxeles aleatorios
var image_data = dibuja_ruido( pt );
// la pintamos al objeto canvas
pt.putImageData( image_data, 0, 0);
}, 200);
}
dibuja_ruido = function(pt)
{
var imageData = pt.createImageData(150, 150);

-- 63 of 86 --

CC-BY-SA • PID_00176160 64 CSS3 y Javascript avanzado
var pixels = imageData.data;
var numPixels = imageData.width*imageData.height;
// Para cada píxel le generamos un color aleatorio
for (var i = 0; i numPixels; < i++) {
pixels[i*4] = Math.floor(Math.random()*255); // Red
pixels[i*4+1] = Math.floor(Math.random()*255); // Green
pixels[i*4+2] = Math.floor(Math.random()*255); // Blue
pixels[i*4+3] = 255; // Alpha
};
return imageData
}
</script>
</head>
<body>
<canvas width="150" height="150" style="border:1px solid grey" id="ejercicio"> </canvas>
</body>
</html>
El resultado será una animación como de televisión desintonizada:
8.1.4. Transformaciones
1)￿Transformaciones￿y￿escalas
Podemos transformar el modo como dibujamos un objeto, o ciertos objetos,
empleando los métodos translate y rotate. Con el primero, transportamos las
coordenadas 0,0 a otro punto. Así, si efectuamos:
ctx.translate(100,100);
La coordenada 0,0 pasará a ser la 100,100, y si nosotros dibujásemos un cua-
drado en la 0,0,10,10, nos aparecería en la 100,100,110,110.

-- 64 of 86 --

CC-BY-SA • PID_00176160 65 CSS3 y Javascript avanzado
Lo mismo sucede con la rotación. Si nosotros realizamos:
ctx.rotate(Math.PI/4)
Rotaremos el canvas 45°, y todo lo que dibujemos nos aparecerá rotado.
2)￿Compositing
Componer elementos se refiere a la manera como se combinarán los nuevos
elementos que añadamos al canvas con los que ya existen. Así, cuando dibu-
jemos un objeto en el canvas, podremos decidir cómo queremos que este se
superponga con el resto de los objetos existentes.
De este modo, cuando añadamos un nuevo objeto podremos decidir si quere-
mos que se superponga o lo contrario. Y también si queremos que al superpo-
nerse se aplique un canal alpha o queremos que se haga un xor de píxeles. Así
podemos definir el modelo de composición con:
ctx.globalCompositeOperation = "";
Donde el valor puede ser:
source-over La imagen origen se situará sobre el canvas.
destination-over La imagen se situará debajo de los objetos
existentes en el canvas.
source-in El origen se dibujará en la zona donde existe
superposición.
destination-in El destino se dibujará en la zona donde existe
superposición.
lighter,￿copy,￿xor Lighter genera la superposición como color
255, blanco.
Copy dibuja el origen en vez del destino.
Cualquier parte que se superponga quedará
transparente.
3)￿Sombras
También podemos definir y pintar sombras en un objeto mientras lo defini-
mos. Para hacerlo, es necesario que definamos las propiedades adecuadas para
que después, al generar el objeto, nos aparezcan correctamente:
ctx.shadowBlur = 20;
ctx.shadowColor = "rgb(0, 0, 0)";
ctx.shadowOffsetX = 10;
ctx.shadowOffsetY = 10;
ctx.fillRect(50, 50, 100, 100);

-- 65 of 86 --

CC-BY-SA • PID_00176160 66 CSS3 y Javascript avanzado
En este caso, estamos generando una sombra de color negro con un desenfo-
cado de 20px y desplazada 10px.
4)￿Guardar￿el￿estado￿actual￿como￿imagen
El canvas, a efectos prácticos, es como si tuviéramos una gran imagen y, como
tal, la podemos guardar como imagen con el siguiente comando:
var dataURL = canvas.get(0).toDataURL();
que nos generará una imagen en formato png y codificada en base64. Al mis-
mo tiempo, este string, que podemos enviar a un servidor y descodificar como
imagen, también puede ser asignado a un objeto imagen para entonces abrirlo
directamente con el navegador:
var img = $("<img></img>"); img.attr("src", dataURL);
canvas.replaceWith(img);
De este modo, si el usuario quiere guardar la imagen, simplemente haciendo
clic con el botón derecho del ratón lo puede hacer, puesto que hemos conver-
tido el objeto canvas (vectorial) en imágenes.
También podríamos generar un archivo descargable enviándola primero al ser-
vidor, realizando la conversión a binario allí, y lanzando las cabeceras adecua-
das junto con los bytes de la imagen.
8.1.5. Animación
El objeto canvas no nos proporciona un mecanismo para generar animacio-
nes de manera directa, pero sí que lo podemos hacer gracias al Javascript. El
principio con pseudo-código es:
1. dibujaremos.
2. esperaremos un intervalo de tiempo.
3. borraremos la pantalla.
4. actualizaremos los valores.
Volveremos al paso 1.
De este modo, podemos mostrar un pequeño ejemplo que demuestre el modo
como podemos animar cosas:
<html>
<head>

-- 66 of 86 --

CC-BY-SA • PID_00176160 67 CSS3 y Javascript avanzado
<title>Ejercicio Movimiento canvas</title>
<script type="text/javascript">
window.onload = function()
{
var canvas = document.getElementById('ejercicio');
var pt = canvas.getContext('2d');
pt.fillStyle = "rgb(200,0,0)"; // formato del dibujo
var inc = 1; // velocidad del movimiento
// objeto que movemos...
var o = { x: 10, y:10, width:10, height:10 };
// ejecución periódica
setInterval(function() {
// si el objeto sobrepasara los límites del canvas,
// cambiamos la orientación de este
if(o.x >= 140 || o.x <=0)
inc = -inc
o.x += inc
limpia(pt)
dibuja( o, pt );
}, 1);
}
dibuja = function(obj, pt)
{
// dibuja el objeto
pt.fillRect (obj.x, obj.y, obj.width, obj.height);
}
limpia = function(pt)
{
// limpia la pantalla y la prepara para el siguiente paso
pt.clearRect(0,0,150,150)
}
</script>
</head>
<body>
<canvas width="150" height="150" style="border:1px solid grey" id="ejercicio"> </canvas>
</body>
</html>
El resultado será:

-- 67 of 86 --

CC-BY-SA • PID_00176160 68 CSS3 y Javascript avanzado
Si nos fijamos, con el código lo que hacemos es generar una ejecución perió-
dica con setInterval, que nos servirá para ir llamando a nuestro programa.
Primero moveremos el objeto; después, limpiaremos la pantalla y, finalmente,
lo dibujaremos de nuevo.
8.2. Raphaël.js
Es una de las primeras librerías gráficas de vectores para la web, independiente
del canvas. También funciona en Internet Explorer 6. Es una buena solución
para crear pequeños componentes interactivos. Viene a ser una mezcla de las
funcionalidades del canvas con el svg, pero en esencia el documento es muy
interesante.
8.2.1. Inicialización
Para poder utilizar la librería, conviene descargarla de su web y después in-
cluirla en el html. También la podemos emplear para hacer pruebas mediante
el jsfiddle.com.
Una vez incluida en el html, es necesario que inicialicemos un nuevo objeto
de tipo Raphael. El código nos puede quedar del siguiente modo:
<html>
<head>
<title>Raphael Play</title>
<script type="text/javascript" src="raphael.js"></script>
<script>
window.onload = function() {
element = document.getElementById('container')
var paper = new Raphael(element, 500, 500);
}
</script>
</head>
<body>
Web recomendada
Podemos consultar su web:
http://raphaeljs.com.

-- 68 of 86 --

CC-BY-SA • PID_00176160 69 CSS3 y Javascript avanzado
<div id="container" style="border:1px solid grey"> </div>
</body>
</html>
Si nos fijamos, el objeto Raphael recibe un elemento del DOM en el que in-
sertaremos el elemento canvas. En este caso, lo efectuamos con Javascript es-
tándar empleando la función, document.getElementById(id), pero también
se podría hacer con cualquier librería, tipo jQuery,￿prototype, u otras.
Si quisiéramos, también podríamos insertar directamente el elemento en el
DOM, empleando en vez de una referencia a un elemento del DOM, las coor-
denadas en las que lo queremos, así:
var paper = new Raphael(0,0, 500, 500);
8.2.2. Dibujo y formas
Disponemos de una sencilla y completa API para generar formas y dibujar
caminos (paths). Así, con:
paper.circle(x,y,radi);
Dibujaremos un círculo en las coordenadas x,y y del correspondiente radi.
paper.rect(x,y,width, height, angle)
Dibujaremos un rectángulo en el que x,y son las coordenadas iniciales, width
es el ancho, height es la altura, y el último parámetro, que es opcional, es el
ángulo de las esquinas.
var c = paper.ellipse(x,y, rh, rv)
Nos permitirá generar elipsis en las que x,y es el punto inicial, rv el radio
vertical y rh el radio horizontal.
Un aspecto importante es que los diferentes pedidos que generemos devuelven
punteros al objeto creado. Así, en la última, podemos acceder al objeto elipse
y, por ejemplo, generarle un color de cuerpo con:
c.attr({'fill':'red'});
Mediante los atributos, podemos asignar y cambiar multitud de parámetros a
una lista de objetos.

-- 69 of 86 --

CC-BY-SA • PID_00176160 70 CSS3 y Javascript avanzado
fill Un color o un gradiente para realizar el relleno.
linear gradiente:
"‹angle›-‹colour›[-‹colour›[:‹offset›]]*-‹colour›", ejemplo: "90-
#fff-#000" – 90° degradado de blanco a negro o "0-#fff-
#f00:20-#000" – 0° degradado de blanco a rojo (y 20%) a
negro.
degradado radial: "r[(‹fx›,
‹fy›)]‹colour›[-‹colour›[:‹offset›]]*-‹colour›", ejemplo: "r#fff-
#000" – degradado de blanco a negro "r(0,25, 0,75)#fff-
#000" – degradado de blanco a negro con un punto de foco
a 0,25, 0,75.
Las coordenadas de punto de foco son con rango de 0..1.
Los degradados radiales sólo pueden ser aplicados a círculos
y elipsis.
fill-opacity De 0 a 1. Porcentaje de opacidad del objeto.
font
font-family
font-size
font-weight
Nombre del tipo de letra asignado.
Familia del tipo de letra.
Tamaño del tipo de letra.
Tipo de letra gruesa bold.
height
width
Tamaño horizontal y vertical.
href Si se especifica, enlace del objeto.
opacity De 0 a 1. Porcentaje de opacidad del objeto.
path pathString SVG path string format
r Radio del objeto.
rotation Rotación del objeto.
scale Escala del objeto.
src En el caso de imágenes, fuente de la imagen.
stroke
stroke-opacity￿stroke-width
Color del filete.
Opacidad del filete.
Ancho del filete.
x,￿y Coordenadas x,y del objeto.
Dada una referencia a un objeto, también lo podemos manipular directamente
con determinados métodos disponibles. Así, lo podemos esconder con c.hide()
o mostrar con c.show(). Lo podemos rotar o escalar con c.rotate(angle) o
c.scale(sx,sy), donde sx y sy son porcentajes de 0 a 2 de escalado de la vertical
y la horizontal.
También podemos mover el objeto a otra posición del canvas con el método
c.translate(x,y).
Otra instrucción importante es el set, que nos permite generar conjuntos de
objetos o agrupaciones que podremos manipular de manera independiente.
Así:
var st = paper.set();
st.push(
paper.circle(10, 10, 5),
Web recomendada
Podemos visualizar toda la
referencia de propiedades y
métodos de la librería Rap-
hael en su web:
http://raphaeljs.com/
reference.html

-- 70 of 86 --

CC-BY-SA • PID_00176160 71 CSS3 y Javascript avanzado
paper.circle(30, 10, 5)
);
st.attr({fill: "red"});
Crearemos dos círculos que podrán ser manipulados desde la misma referencia
st.
También podemos eliminar elementos creados con la instrucción st.remove().
Los elementos tienen profundidad y tenemos dos órdenes para manipular su
posición. De este modo, si llamamos al método .toFront(), el elemento se nos
posicionará en la parte superior de la pila de elementos, mientras que si lo
llamamos con el método .toBack() el elemento se posicionará al fondo. Tam-
bién podemos generar los nuevos elementos en una posición, empleando los
métodos insertBefore() e insertAfter().
Asimismo, podemos insertar textos con la instrucción .text(x,y,'cadena￿ de
texto'). Para emplear fuentes, deberemos utilizar la tecnología cufon (https://
github.com/sorccu/cufon/wiki/abou), que nos generará la fuente en formato
de conjunto de caminos (paths) en json.
Hemos de hablar, también, de la potencia de la instrucción .path() para ge-
nerar recorridos. El formato de esta es el del svg (http://www.w3.org/tr/svg/
paths.html#PathData).
paper.path('M10 10L90 90');
Generará una línea diagonal desde la coordenada 10,10 hasta la coordenada
90,90.
Y para finalizar la parte de dibujo de formas con Raphaeljs, cabe decir que
podemos incluir imágenes dentro de un objeto canvas con la instrucción:
paper.image("apple.png", 10, 10, 80, 80);
Donde las dos primeras indican las coordenadas del punto de inserción, mien-
tras que las segundas son el ancho y el alto.
8.2.3. Animación
Otro de los factores interesantes para usar Raphaël es la capacidad de gene-
rar animaciones complejas con una sola instrucción. Disponemos del método
animate, que nos permite generar animaciones de modo fácil y cómodo. Así:
var d = paper.circle(400, 40, 20);
d.animate({cy: 480, r: 20}, 2000, "bounce");

-- 71 of 86 --

CC-BY-SA • PID_00176160 72 CSS3 y Javascript avanzado
Generaremos un círculo de 10 píxeles de ancho en la posición 10,10. La ani-
mación que generaremos a continuación animará las propiedades a un radio
de 20px, y la posición del centro x a 20 también, durante 2.000 milisegundos
con una ecuación de movimiento "bounce" rebote. Así, la forma general, será:
c.animate({objecte_propietats}, duración, ecuación de movimiento, onEnd);
Donde la ecuación puede ser:
[">", "<", "<>", "backIn", "backOut", "bounce", "elastic", "cubic-bezier(p1, p2, p3, p4)"]
Las propiedades que podemos animar serán: clip-rect,￿cx,￿cy,￿fill,￿fill-opacity,
font-size,￿height,￿opacity,￿path,￿r,￿rotation,￿rx,￿ry,￿scale,￿stroke,￿stroke-opa-
city,￿stroke-width,￿translation,￿width,￿x,￿y.
También podemos definir un último parámetro que puede ser una función
que queramos que se ejecute al finalizar la animación.
Finalmente, podemos realizar animaciones con fotogramas clave (keyframes).
Animaciones en las que marcamos pasos para momentos de tiempo, por ejem-
plo:
c.animate({
"20%": {cx: 20, r: 20, easing: ">"},
"50%": {cx: 70, r: 120, callback: function () {...}},
"100%": {cx: 10, r: 10}}, 2000);
Así, la anterior animación moverá el objeto hasta un radio de 20 durante el
20% del tiempo, o sea 400 milisegundos, mientras que durante 600 lo hará
crecer a 120, mediante la ejecución del callback al llegar. Finalmente, los últi-
mos 1.000 milisegundos evolucionará hacia el punto de inicio.
8.3. EaselJS
Esta es una librería para canvas relativamente nueva pero con muy buena pers-
pectiva y una sólida base técnica detrás. Fue creada por gskinner.com, como
ayuda al desarrollo del juego en Html5, Pirates Love Daisies.
La idea fundamental de la librería es añadir al componente canvas métodos
para interactuar con objetos sobre este, al estilo del Flash y el Actionscript.
Así, lo que han empezado a hacer es reescribir la estructura fundamental del
Document￿Object￿Model￿del￿Flash￿y￿Actionscript, empleando como sistema
de render el Canvas￿HTML5.

-- 72 of 86 --

CC-BY-SA • PID_00176160 73 CSS3 y Javascript avanzado
No es objeto de este módulo exponer cómo funciona la estructura de objetos
de Actionscript 3, ni lo potente que es para generar estructuras visuales com-
plejas, así como juegos y otros. Por lo tanto, lo que haremos en este manual es
enumerar las principales funcionalidades que han ido aparecido con el easelJS.
8.3.1. Classes clave
• DisplayObject
Clase abstracta para todos los elementos visuales o insertables en el can-
vas. Proporciona acceso a todas las propiedades (x,y, rotation, scaleX, scaleY,
skewX, skewY, alpha, shadow, etc.) comunes a todos los objetos visuales.
• Stage
Es el nivel inicial que contiene todos los elementos display. Cada vez que se
llama a la función update en el stage, él se encarga de renderizar todos los
elementos pegados en el canvas.
• Container
Es una clase contenedora que permite trabajar con diferentes objetos dentro
de uno solo y manipularlos como un solo texto.
• Text
Dibuja texto en el contexto de un objeto display.
• Bitmap
Dibuja una imagen o vídeo en el canvas y dispone de las propiedades hereda-
das de DisplayObject.
• BitmapSequence
Dibuja una secuencia de imágenes (sprites) diferentes o fotogramas en una
rejilla, y dispone de una pequeña API para manipular la reproducción de la
secuencia.
• Graphics
Una potente API para renderizar objetos gráficos en el canvas.
• Shape

-- 73 of 86 --

CC-BY-SA • PID_00176160 74 CSS3 y Javascript avanzado
Renderiza gráficos vectoriales, como el objeto display list, con las propiedades
del anterior.
8.4. CanvaScript
Al estilo de jQuery, CanvaScript nos ofrece un método que nos sirve de he-
rramienta para inicializar la librería y también como método para dibujar las
operaciones en el canvas. Para empezar a utilizarlo, podemos emplear el si-
guiente ejemplo:
<html>
<head>
<title>Ejercicio jcanvascript</title>
<script type="text/javascript" src="jCanvaScript.js" > </script>
<script type="text/javascript">
window.onload = function()
{
jc.start('ejercicio');
jc.circle(50,50,50,'rgba(255,255,0,1)',1);
jc.start('ejercicio');
}
</script>
</head>
<body>
<canvas width="150" height="150" style="border:1px solid grey" id="ejercicio"> </canvas>
</body>
</html>
Incluimos la librería y la inicializamos con la función jc.start('id_delcanvas').
A partir de aquí, dibujamos un círculo con el método jc.circle. Finalmente,
volvemos a llamar al método start para pintar las manipulaciones hechas.
Una de las características importantes de la librería es que nos permite trabajar
de manera encadenada. Así, una vez generemos una primitiva (elemento) le
podemos asignar eventos, cambiar propiedades o dar un ID de manera fluida
sin necesidad de volver a seleccionar el objeto y de manera encadenada. Así,
podemos encontrar construcciones de código como esta:
jc.start('ejercicio', 25);
jc.circle(50,50,20,'rgba(255,255,0,1)',1)
.draggable()
.click(function(){
alert('hola')
});
Web recomendada
http://jcscript.com/

-- 74 of 86 --

CC-BY-SA • PID_00176160 75 CSS3 y Javascript avanzado
Seleccionamos un objeto canvas, le dibujamos un círculo que convertimos en
arrastrable y le programamos un evento clic que generará una notificación.
La librería CanvaScript nos ofrece una serie de primitivas que nos permiten
dibujar multitud de formas. Básicamente aumenta y mejora la API por defecto
del objeto canvas. Así, podemos:
jc.circle(x, y, radius, [color], [relleno])
Dibuja un círculo
jc.rect(x, y, width, height, [color], [relleno])
Dibuja un cuadrado.
jc.arc(x, y, radius, iAngle, fAngle, [agujasreloj], [color], [relleno])
Dibuja un arco desde iAngle hasta fAngle. En la dirección de las agujas del reloj
si agujasreloj es true o al revés si false. El color del filete y el color del relleno
son parámetros opcionales.
jc.line(points, [color], [relleno])
Dibuja una línea. El primer parámetro es una lista de pares de puntos en la
forma [[0,0], [0,10]].
jc.qCurve(points, [color], [relleno])
Dibuja una curva con ecuación cuadrática.
jc.bCurve(points, [color], [hijo])
Dibuja una curva de Bézier.
jc.imageData(float width, float height)
Crea una nueva imagen de ancho y de alto.
jc.image(img, sX, sY, sWidth, sHeight, dX, dY, dWidth, dHeight)
Es un clon de la función image nativa de canvas.
jc.text(text, x, y, [maxWidth], [color], [hijo])
Clon de la función texto de canvas con el color y el relleno extras.

-- 75 of 86 --

CC-BY-SA • PID_00176160 76 CSS3 y Javascript avanzado
lGradient(x1, y1, x2, y2, colors)
Dibuja un degradado lineal desde x1,y1, hasta x2,y2, en el que colores es una
lista de porcentajes de cada color.
[ [0,'rgb(0,0,0)'],
[0.5,'rgb(255,0,0)'],
[0.75,'rgb(255,255,0)'] ];
En él, cada elemento de la lista es una pequeña lista con el porcentaje y el color.
rGradient(x1,￿y1,￿radius1,￿x2,￿y2,￿radius2,￿colors)
Dibuja un degradado de forma radial.
jc.start(idCanvas);
var colors=[[0,'rgb(0,0,0)'],
[0.5,'rgb(255,0,0)'],
[0.75,'rgb(255,255,0)']];
var gradient=jc.rGradient(10,30,20,10,30,250,colors);
jc.rect(1,1,248,263,gradient,1)
jc.start(idCanvas);
jc.layer(idLayer)
El comando layer genera un conjunto de objetos que pueden ser tratados como
unidad. Por ejemplo, el siguiente código:
jc.layer('grupo1')
.animate({translate:{x:100}},2000)
.draggable()
.clone('2')
.animate({translate:{x:100,y:140}},1500);
Utilizamos el conjunto grupo1 y le realizamos una animación, lo convertimos
en arrastrable y finalmente lo clonamos.
jc.addObject(name, parameters, fn)
Permite generar nuevas primitivas a partir de un nombre, una lista de pará-
metros y una función de dibujo.

-- 76 of 86 --

CC-BY-SA • PID_00176160 77 CSS3 y Javascript avanzado
Vistos estos objetos (en el lenguaje de su documentación, primitivas), pode-
mos observar toda una serie de métodos que encontramos disponibles en cada
objeto una vez creado o si lo seleccionamos. Una vez dibujamos un objeto, le
podemos asignar un ID con la función id(), que después podremos usar para
seleccionar el objeto en cuestión.
.animate(parameters, [duration], [easing], [onstep], [fn])
Seleccionado un objeto, podemos asociar y generar una animación con:
jc.circle(50,50,20,'rgba(255,255,0,1)',1)
.animate({x:175,radius:5,color:'#000000'},1000);
Generaremos una animación del círculo cambiando su coordenada x, el radio
y el color. La duración será en milisegundos, y podemos asignar una función
de movimiento y eventos al finalizar y en cada paso.
.opacity([float])
Cambiamos la opacidad de un objeto. También nos permite consultar la exis-
tente.
.shadow({ x:5, i:5, blur:15, color:'#ff0000' })
Permite asignar una sombra.
.visible()
Cambia la visibilidad de un objeto.
.id()
Asigna o consulta el ID de un elemento.
.name()
Asigna un nombre que después podremos utilizar en el estilo de los selectores
de clase de CSS.
.down() / .up() / .level()
Maneja la profundidad de los objetos; down() lo hace bajar; up() lo sube, y
level() nos devuelve la profundidad. Esta siempre se calcula relativa al total
de objetos generados en un espacio.
.rotate() / .scale() / .transform()/ .translate() / .translateTo()

-- 77 of 86 --

CC-BY-SA • PID_00176160 78 CSS3 y Javascript avanzado
Nos permite alterar y cambiar propiedades del objeto seleccionado.
.attr()
Permite cambiar atributos de un objeto generado, como por ejemplo:
.attr('fill',0);)
.buffer()
Devuelve una referencia al objeto en cuestión. Con esta, lo podemos utilizar
para escribirlo como imagen.
.clip(objecte)
Nos permite generar un objeto que enmascarará a otro.
.clone()
Clona el objeto seleccionado, es decir, genera una copia.
.del()
Elimina el objeto seleccionado.
isPointIn(x,y)
¿Está el objeto sobre el punto x,y?
color()
Nos permite cambiar el color del relleno de un objeto.
lineStyle()
Nos permite cambiar el estilo de línea de un objeto.
Eventos
También podemos asignar eventos, en el estilo jquery, a cualquier objeto, me-
diante la llamada al nombre del evento.
click()
dblclick()
mousedown()
mousemove()
mouseout()

-- 78 of 86 --

CC-BY-SA • PID_00176160 79 CSS3 y Javascript avanzado
mouseover()
mouseup()
blur()
focus()
keydown()
keypress()
keyup()
En la forma:
objecte.click(function(){ })
// Dentro de la función, el this se refiere al objeto que ha generado el evento.
draggable() / droppable()
Nos permite transformar un objeto en arrastable y destino de ser arrastrado,
así:
Mientras que la primera actúa como activador del arrastable, la segunda actúa
como asignador de evento. Así, por ejemplo:
jc.id('#ele').droppable( function() {
// Desencadena el evento pertinente.
})
8.5. Processing
Processing nace como un puerto del lenguaje de creación artística para
Java en Javascript, por parte del mismo creador que jQuery,￿ John￿ Resig
(www.ejohn.com).
En este manual sólo lo mencionaremos, puesto que la base del sistema es el
objeto canvas; pero no lo trataremos porque el processing es un lenguaje en sí
mismo. Así, el puerto en Javascript es un intérprete del lenguaje processing que
establece un sistema para procesar los scripts.
8.6. Ejercicio
Reloj con canvas
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Reloj Javascript</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"> </script>
<script src="raphael-min.js"> </script>
<script type="text/javascript">
<!--
Webs recomendadas
Podemos encontrar ejemplos
y ver cómo funciona en las
webs del propio lenguaje:
http://www.processingjs.com
http://www.processing.com

-- 79 of 86 --

CC-BY-SA • PID_00176160 80 CSS3 y Javascript avanzado
$(document).ready(function(){
function Rellotge()
{
$(document).trigger('tiempo', [new Date()]);
setInterval(function(){
$(document).trigger('tiempo', [new Date()]);
}, 1000);
}
var TextVisor = function() {
var t = this.t = this;
var tick = function(event, extra) {
t.pinta( event, extra );
}
this.pinta = function(event, extra) {
$( '#rellotge' ).html( t.format_string(extra) );
}
this.format_string = function(dat) {
d = dat;
hora = d.getHours();
minuto =d.getMinutes();
if(minuto<=9)
minuto = "0"+minuto;
segundo = d.getSeconds();
if(segundo<=9)
segundo = "0"+segundo;
return hora + ":" + minuto + ":" + segundo;
}
$(document).bind('tiempo', tick);
}
var RaphaelVisor = function(object_id)
{
var t = this.t = this
var pt = this.pt = new Raphael(document.getElementById(object_id), 200, 200);
// dibujamos el reloj inicial
var PX = 100;
var PY = 100;
var tick = function(event, d)
{
h = d.getHours();
if(h>12)
h = h/2
m =d.getMinutes();
// añadimos a la hora la parte proporcional de minutos
h += (m*100/60)/100
// transportamos hora a ángulos
s = d.getSeconds();

-- 80 of 86 --

CC-BY-SA • PID_00176160 81 CSS3 y Javascript avanzado
ah = (h*360)/12
am = (m*360)/60
as = (s*360)/60
neteja()
//console.info(h,m,s,">>> ", ah, am, as)
t.hora = pinta_agulla( 50, ah)
t.minut = pinta_agulla( 60, am)
t.segon = pinta_agulla( 70, as)
t.hora.attr( {'stroke-width': 7, 'stroke': '#ac360b' })
t.minut.attr( {'stroke-width': 5, 'stroke': '#a0573c' })
t.segon.attr( {'stroke-width': 3, 'stroke': '#666666' })
}
var neteja = function()
{
if(t.hora)
t.hora.remove();
if(t.minut)
t.minut.remove();
if(t.segon)
t.segon.remove();
}
var pinta_agulla = function ( radio, an )
{
// convertimos ángulo a radianes
angle = (an-90)*(2*Math.PI/360);
// calculamos coordenadas x, y
x = PX + Math.cos(angle)*radi
y = PY + Math.sin(angle)*radi
svg = "M"+ PX + " " + PY + " L" + x + " " + y
return pt.path(svg)
}
this.init=function() {
fons = pt.circle(100,100, 90)
fons.attr({'fill': '#fbf8e1'})
$(document).bind('tiempo', tick);
}
}
// inicializamos reloj
Rellotge();
// Este tercer visor conecta el reloj con la ventana del navegador.
var vis3 = new TextVisor();
vis3.pinta = function(ev, extra){
$(document).attr('title',
this.format_string(extra) );
}

-- 81 of 86 --

CC-BY-SA • PID_00176160 82 CSS3 y Javascript avanzado
// inicializamos reloj creado con librería Raphael
vi = new RaphaelVisor('rellotge')
vi.init()
});
//-->
</script>
</head>
<body>
<div id="rellotge" style="width:200px; border:1px solid grey"> </div>
</body>
</html>

-- 82 of 86 --

CC-BY-SA • PID_00176160 83 CSS3 y Javascript avanzado