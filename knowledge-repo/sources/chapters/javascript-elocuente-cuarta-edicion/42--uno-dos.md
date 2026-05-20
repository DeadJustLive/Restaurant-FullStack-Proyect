# // → ["UNO", "DOS"]

Para crear nodos elemento, puedes utilizar el método document.createElement.
Este método toma un nombre de etiqueta y devuelve un nuevo nodo vacío del
tipo dado.
El siguiente ejemplo define una utilidad elt, que crea un nodo de elemento
y trata el resto de sus argumentos como hijos de ese nodo. Luego, esta función
se utiliza para agregar una atribución a una cita.
<blockquote id="quote">
Ningún libro puede considerarse terminado. Mientras trabajamos en
él aprendemos
lo suficiente como para encontrarlo inmaduro en el momento en que
lo dejamos.
</blockquote>
<script>
function elt(type, ...children) {
let node = document.createElement(type);
for (let child of children) {
if (typeof child != "string") node.appendChild(child);
else node.appendChild(document.createTextNode(child));
}
return node;
}
document.getElementById("quote").appendChild(
elt("footer", "—",
elt("strong", "Karl Popper"),
229

-- 241 of 445 --

", prefacio de la segunda edición de ",
elt("em", "La sociedad abierta y sus enemigos"),
", 1950"));
</script>
Así es como se vería el documento resultante:
Atributos
Algunos atributos de elementos, como href para enlaces, pueden ser accedidos
a través de una propiedad con el mismo nombre en el objeto DOM del elemento.
Este es el caso para la mayoría de atributos estándar comúnmente usados.
HTML te permite establecer cualquier atributo que desees en los nodos. Esto
puede ser útil porque te permite almacenar información adicional en un docu-
mento. Para leer o cambiar atributos personalizados, que no están disponibles
como propiedades regulares del objeto, debes usar los métodos getAttribute y
setAttribute.
<p data-classified="secreto">El código de lanzamiento es 00000000.</
p>
<p data-classified="no clasificado">Tengo dos pies.</p>
<script>
let paras = document.body.getElementsByTagName("p");
for (let para of Array.from(paras)) {
if (para.getAttribute("data-classified") == "secreto") {
para.remove();
}
}
</script>
Se recomienda prefijar los nombres de estos atributos inventados con data-
para asegurarse de que no entren en conflicto con otros atributos.
Existe un atributo comúnmente usado, class, que es una palabra clave en
el lenguaje JavaScript. Por razones históricas—algunas implementaciones an-
tiguas de JavaScript no podían manejar nombres de propiedades que coinci-
dieran con palabras clave—la propiedad utilizada para acceder a este atributo
se llama className. También puedes acceder a él con su nombre real, "class",
230

-- 242 of 445 --

utilizando los métodos getAttribute y setAttribute.
Diseño
Puede que hayas notado que diferentes tipos de elementos se disponen de man-
era diferente. Algunos, como párrafos (<p>) o encabezados (<h1>), ocupan
todo el ancho del documento y se muestran en líneas separadas. Estos se lla-
man elementos de bloque. Otros, como enlaces (<a>) o el elemento <strong>,
se muestran en la misma línea que el texto que los rodea. A estos elementos se
les llama elementos en línea.
Para cualquier documento dado, los navegadores son capaces de calcular un
diseño, que le da a cada elemento un tamaño y posición basados en su tipo y
contenido. Luego, este diseño se usa para dibujar el documento realmente.
El tamaño y posición de un elemento pueden ser accedidos desde JavaScript.
Las propiedades offsetWidth y offsetHeight te dan el espacio que el elemento
ocupa en píxeles. Un píxel es la unidad básica de medida en el navegador.
Tradicionalmente corresponde al punto más pequeño que la pantalla puede
dibujar, pero en pantallas modernas, que pueden dibujar puntos muy pequeños,
eso puede que ya no sea cierto, y un píxel del navegador puede abarcar múltiples
puntos de la pantalla.
De manera similar, clientWidth y clientHeight te dan el tamaño del espacio
dentro del elemento, ignorando el ancho del borde.
<p style="border: 3px solid red">
Estoy enmarcado
</p>
<script>
let para = document.body.getElementsByTagName("p")[0];
console.log("clientHeight:", para.clientHeight);
// → 19
console.log("offsetHeight:", para.offsetHeight);
// → 25
</script>
Darle a un párrafo un borde hace que se dibuje un rectángulo a su alrededor.
La manera más efectiva de encontrar la posición precisa de un elemento en
la pantalla es el método getBoundingClientRect. Devuelve un objeto con las
propiedades top, bottom, left y right, indicando las posiciones en píxeles de los
231

-- 243 of 445 --

lados del elemento en relación con la esquina superior izquierda de la pantalla.
Si los quieres en relación al documento completo, debes sumar la posición
actual de desplazamiento, que puedes encontrar en las variables pageXOffset y
pageYOffset.
Diseñar un documento puede ser bastante trabajo. En aras de la rapidez, los
motores de los navegadores no vuelven a diseñar inmediatamente un documento
cada vez que se modifica, sino que esperan tanto como pueden. Cuando un pro-
grama de JavaScript que ha modificado el documento finaliza su ejecución, el
navegador tendrá que calcular un nuevo diseño para dibujar el documento mod-
ificado en la pantalla. Cuando un programa pide la posición o tamaño de algo
leyendo propiedades como offsetHeight o llamando a getBoundingClientRect,
proporcionar esa información también requiere calcular un diseño.
Un programa que alterna repetidamente entre la lectura de información de
diseño del DOM y el cambio del DOM provoca que se realicen muchas computa-
ciones de diseño y, en consecuencia, se ejecute muy lentamente. El siguiente
código es un ejemplo de esto. Contiene dos programas diferentes que con-
struyen una línea de caracteres X de 2,000 píxeles de ancho y mide el tiempo
que lleva cada uno.
<p><span id="one"></span></p>
<p><span id="two"></span></p>
<script>
function time(name, action) {
let start = Date.now(); // Tiempo actual en milisegundos
action();
console.log(name, "tomó", Date.now() - start, "ms");
}
time("ingenuo", () => {
let target = document.getElementById("one");
while (target.offsetWidth < 2000) {
target.appendChild(document.createTextNode("X"));
}
});
// → ingenuo tomó 32 ms
time("astuto", function() {
let target = document.getElementById("two");
target.appendChild(document.createTextNode("XXXXX"));
let total = Math.ceil(2000 / (target.offsetWidth / 5));
target.firstChild.nodeValue = "X".repeat(total);
});
232

-- 244 of 445 --

// → astuto tomó 1 ms
</script>
Estilos
Hemos visto que diferentes elementos HTML se dibujan de manera diferente.
Algunos se muestran como bloques, otros en línea. Algunos agregan estilos:
<strong> hace que su contenido sea negrita, y <a> lo hace azul y lo subraya.
La forma en que una etiqueta <img> muestra una imagen o una etiqueta <a>
hace que se siga un enlace al hacer clic está fuertemente vinculada al tipo de
elemento. Pero podemos cambiar el estilo asociado con un elemento, como el
color del texto o el subrayado. Aquí hay un ejemplo que utiliza la propiedad
style:
<p><a href=".">Enlace normal</a></p>
<p><a href="." style="color: green">Enlace verde</a></p>
El segundo enlace será verde en lugar del color de enlace predeterminado.
Un atributo de estilo puede contener uno o más declaraciónes, que son
una propiedad (como color) seguida de dos puntos y un valor (como verde
). Cuando hay más de una declaración, deben separarse por punto y comas,
como en "color: rojo; border: ninguno".
Muchos aspectos del documento pueden ser influenciados por el estilo. Por
ejemplo, la propiedad display controla si un elemento se muestra como un
bloque o como un elemento en línea.
Este texto se muestra de forma <strong>en línea</strong>,
<strong style="display: block">como un bloque</strong>, y
<strong style="display: none">no del todo</strong>.
La etiqueta block terminará en su propia línea ya que los elementos de bloque
no se muestran en línea con el texto que los rodea. La última etiqueta no
se muestra en absoluto: display: none evita que un elemento aparezca en la
pantalla. Esta es una forma de ocultar elementos. A menudo es preferible
a eliminarlos completamente del documento porque facilita revelarlos nueva-
mente más tarde.
233

-- 245 of 445 --

El código JavaScript puede manipular directamente el estilo de un elemento
a través de la propiedad style del elemento. Esta propiedad contiene un objeto
que tiene propiedades para todas las posibles propiedades de estilo. Los valores
de estas propiedades son cadenas de texto, a las cuales podemos escribir para
cambiar un aspecto particular del estilo del elemento.
<p id="para" style="color: purple">
Texto bonito
</p>
<script>
let para = document.getElementById("para");
console.log(para.style.color);
para.style.color = "magenta";
</script>
Algunos nombres de propiedades de estilo contienen guiones, como font-family
. Debido a que trabajar con estos nombres de propiedades en JavaScript
es incómodo (tendrías que decir style["font-family"]), los nombres de las
propiedades en el objeto style para tales propiedades tienen los guiones elimi-
nados y las letras posterior a ellos en mayúscula (style.fontFamily).
Estilos en cascada
El sistema de estilos para HTML se llama CSS, por sus siglas en inglés, Cas-
cading Style Sheets. Una hoja de estilo es un conjunto de reglas sobre cómo
dar estilo a los elementos en un documento. Puede ser proporcionada dentro
de una etiqueta <style>.
<style>
strong {
font-style: italic;
color: gray;
}
</style>
<p>Ahora el <strong>texto fuerte</strong> es cursiva y gris.</p>
El cascada en el nombre se refiere al hecho de que múltiples reglas de este tipo
se combinan para producir el estilo final de un elemento. En el ejemplo, el
estilo predeterminado de las etiquetas <strong>, que les da font-weight: bold
234

-- 246 of 445 --

, se superpone por la regla en la etiqueta <style>, que agrega font-style y
color.
Cuando múltiples reglas definen un valor para la misma propiedad, la regla
más recientemente leída obtiene una precedencia más alta y gana. Por lo
tanto, si la regla en la etiqueta <style> incluyera font-weight: normal, con-
tradiciendo la regla predeterminada de font-weight, el texto sería normal, no
negrita. Los estilos en un atributo style aplicado directamente al nodo tienen
la mayor precedencia y siempre prevalecen.
Es posible apuntar a cosas distintas de los nombres de etiqueta en reglas
de CSS. Una regla para .abc se aplica a todos los elementos con "abc" en su
atributo class. Una regla para #xyz se aplica al elemento con un atributo id
de "xyz" (que debería ser único dentro del documento).
.subtle {
color: gray;
font-size: 80%;
}
#header {
background: blue;
color: white;
}
/* elementos p con id main y con clases a y b */
p#main.a.b {
margin-bottom: 20px;
}
La regla de precedencia que favorece a la regla más recientemente definida se
aplica solo cuando las reglas tienen la misma especificidad. La especificidad de
una regla es una medida de qué tan precisamente describe los elementos que
coinciden, determinada por el número y tipo (etiqueta, clase o ID) de aspectos
de elementos que requiere. Por ejemplo, una regla que apunta a p.a es más
específica que las reglas que apuntan a p o simplemente .a y, por lo tanto,
tendría precedencia sobre ellas.
La notación p > a …{} aplica los estilos dados a todas las etiquetas <a> que
son hijos directos de etiquetas <p>. De manera similar, p a …{} se aplica a
todas las etiquetas <a> dentro de las etiquetas <p>, ya sean hijos directos o
indirectos.
Selectores de consulta
No vamos a usar hojas de estilo demasiado en este libro. Entenderlas es útil
cuando se programa en el navegador, pero son lo suficientemente complicadas
235

-- 247 of 445 --

como para justificar un libro aparte.
La razón principal por la que introduje la sintaxis selector—la notación uti-
lizada en las hojas de estilo para determinar a qué elementos se aplican un
conjunto de estilos— es que podemos utilizar este mismo mini-lenguaje como
una forma efectiva de encontrar elementos del DOM.
El método querySelectorAll, que está definido tanto en el objeto document
como en los nodos de elementos, toma una cadena de selector y devuelve un
NodeList que contiene todos los elementos que encuentra.
<p>And if you go chasing
<span class="animal">rabbits</span></p>
<p>And you know you're going to fall</p>
<p>Tell 'em a <span class="character">hookah smoking
<span class="animal">caterpillar</span></span></p>
<p>Has given you the call</p>
<script>
function count(selector) {
return document.querySelectorAll(selector).length;
}
console.log(count("p")); // Todos los elementos <p>
// → 4
console.log(count(".animal")); // Clase animal
// → 2
console.log(count("p .animal")); // Animal dentro de <p>
// → 2
console.log(count("p > .animal")); // Hijo directo de <p>
// → 1
</script>
A diferencia de métodos como getElementsByTagName, el objeto devuelto por
querySelectorAll no es dinámico. No cambiará cuando cambies el documento.
Aun así, no es un array real, por lo que necesitas llamar a Array.from si deseas
tratarlo como tal.
El método querySelector (sin la parte All) funciona de manera similar.
Este es útil si deseas un elemento específico y único. Solo devolverá el primer
elemento coincidente o null cuando no haya ningún elemento coincidente.
Posicionamiento y animación
La propiedad de estilo position influye en el diseño de una manera poderosa.
De forma predeterminada, tiene un valor de static, lo que significa que el
elemento se sitúa en su lugar normal en el documento. Cuando se establece en
236

-- 248 of 445 --

relative, el elemento sigue ocupando espacio en el documento, pero ahora las
propiedades de estilo top y left se pueden usar para moverlo con respecto a
ese lugar normal. Cuando position se establece en absolute, el elemento se
elimina del flujo normal del documento, es decir, ya no ocupa espacio y puede
superponerse con otros elementos. Además, sus propiedades de top y left se
pueden usar para posicionarlo absolutamente con respecto a la esquina superior
izquierda del elemento contenedor más cercano cuya propiedad de position no
sea static, o con respecto al documento si no existe tal elemento contenedor.
Podemos usar esto para crear una animación. El siguiente documento mues-
tra una imagen de un gato que se mueve en una elipse:
<p style="text-align: center">
<img src="img/cat.png" style="position: relative">
</p>
<script>
let cat = document.querySelector("img");
let angle = Math.PI / 2;
function animate(time, lastTime) {
if (lastTime != null) {
angle += (time - lastTime) * 0.001;
}
cat.style.top = (Math.sin(angle) * 20) + "px";
cat.style.left = (Math.cos(angle) * 200) + "px";
requestAnimationFrame(newTime => animate(newTime, time));
}
requestAnimationFrame(animate);
</script>
La flecha gris muestra la trayectoria a lo largo de la cual se mueve la imagen.
Nuestra imagen está centrada en la página y tiene una posición de relative
. Actualizaremos repetidamente los estilos top e left de esa imagen para
moverla.
El script utiliza requestAnimationFrame para programar la ejecución de la
función animar siempre que el navegador esté listo para repintar la pantalla. La
función animar a su vez vuelve a llamar a requestAnimationFrame para progra-
mar la siguiente actualización. Cuando la ventana del navegador (o pestaña)
está activa, esto provocará que las actualizaciones ocurran a una velocidad de
237

-- 249 of 445 --

aproximadamente 60 por segundo, lo que suele producir una animación atrac-
tiva.
Si simplemente actualizáramos el DOM en un bucle, la página se congelaría
y nada aparecería en la pantalla. Los navegadores no actualizan su pantalla
mientras se ejecuta un programa JavaScript, ni permiten ninguna interacción
con la página. Por eso necesitamos requestAnimationFrame — le indica al
navegador que hemos terminado por ahora, y puede continuar haciendo las
cosas que hacen los navegadores, como actualizar la pantalla y responder a las
acciones del usuario.
La función de animación recibe el tiempo actual como argumento. Para ase-
gurar que el movimiento del gato por milisegundo sea estable, basa la velocidad
a la que cambia el ángulo en la diferencia entre el tiempo actual y el último
tiempo en que se ejecutó la función. Si simplemente moviera el ángulo por una
cantidad fija por paso, el movimiento se interrumpiría si, por ejemplo, otra
tarea pesada que se está ejecutando en la misma computadora impidiera que
la función se ejecutara durante una fracción de segundo.
Moverse en círculos se hace utilizando las funciones trigonométricas Math.cos
y Math.sin. Para aquellos que no estén familiarizados con ellas, las presentaré
brevemente ya que ocasionalmente las utilizaremos en este libro.
Math.cos y Math.sin son útiles para encontrar puntos que se encuentran en
un círculo alrededor del punto (0,0) con un radio de uno. Ambas funciones
interpretan su argumento como la posición en este círculo, con cero denotando
el punto en el extremo derecho del círculo, avanzando en el sentido de las agujas
del reloj hasta que 2π (aproximadamente 6,28) nos ha llevado alrededor de todo
el círculo. Math.cos te indica la coordenada x del punto que corresponde a la
posición dada, y Math.sin devuelve la coordenada y. Las posiciones (o ángulos)
mayores que 2π o menores que 0 son válidos, la rotación se repite de manera
que a+2π se refiere al mismo ángulo que a.
Esta unidad para medir ángulos se llama radianes — un círculo completo son
2π radianes, similar a cómo son 360 grados al medir en grados. La constante π
está disponible como Math.PI en JavaScript.
cos(¼π)
sin(¼π)
cos(-⅔π)
sin(-⅔π)	sin(-⅔π)
238

-- 250 of 445 --

El código de animación del gato mantiene un contador, angle, para el ángulo
actual de la animación e incrementa el mismo cada vez que se llama la función
animate. Luego puede usar este ángulo para calcular la posición actual del
elemento de imagen. El estilo top es calculado con Math.sin y multiplicado
por 20, que es el radio vertical de nuestra elipse. El estilo left se basa en
Math.cos y multiplicado por 200 para que la elipse sea mucho más ancha que
alta.
Ten en cuenta que los estilos usualmente necesitan unidades. En este caso,
tenemos que añadir "px" al número para indicarle al navegador que estamos
contando en píxeles (en lugar de centímetros, “ems” u otras unidades). Esto
es fácil de olvidar. Usar números sin unidades resultará en que tu estilo sea
ignorado — a menos que el número sea 0, lo cual siempre significa lo mismo,
independientemente de su unidad.
Resumen
Los programas de JavaScript pueden inspeccionar e interferir con el documento
que el navegador está mostrando a través de una estructura de datos llamada
el DOM. Esta estructura de datos representa el modelo del documento del
navegador, y un programa de JavaScript puede modificarlo para cambiar el
documento visible.
El DOM está organizado como un árbol, en el cual los elementos están dis-
puestos jerárquicamente de acuerdo a la estructura del documento. Los objetos
que representan elementos tienen propiedades como parentNode y childNodes,
las cuales pueden ser usadas para navegar a través de este árbol.
La forma en que un documento es mostrado puede ser influenciada por el
estilo, tanto adjuntando estilos directamente a nodos como definiendo reglas
que coincidan con ciertos nodos. Hay muchas propiedades de estilo diferentes,
como color o display. El código de JavaScript puede manipular el estilo de
un elemento directamente a través de su propiedad style.
Ejercicios
Construir una tabla
Una tabla HTML se construye con la siguiente estructura de etiquetas:
<table>
<tr>
<th>nombre</th>
239

-- 251 of 445 --

<th>altura</th>
<th>lugar</th>
</tr>
<tr>
<td>Kilimanjaro</td>
<td>5895</td>
<td>Tanzania</td>
</tr>
</table>
Dado un conjunto de datos de montañas, un array de objetos con propiedades
name, height, y place, genera la estructura DOM para una tabla que enumera
los objetos. Debería haber una columna por clave y una fila por objeto, además
de una fila de encabezado con elementos <th> en la parte superior, enumerando
los nombres de las columnas.
Escribe esto de manera que las columnas se deriven automáticamente de los
objetos, tomando los nombres de las propiedades del primer objeto en los datos.
Muestra la tabla resultante en el documento agregándola al elemento que
tenga un atributo id de "mountains".
Una vez que tengas esto funcionando, alinea a la derecha las celdas que
contienen valores numéricos estableciendo su propiedad style.textAlign en
"right".
Elementos por nombre de etiqueta
El método document.getElementsByTagName devuelve todos los elementos hijos
con un nombre de etiqueta dado. Implementa tu propia versión de esto como
una función que tome un nodo y un string (el nombre de la etiqueta) como
argumentos y devuelva un array que contenga todos los nodos de elementos
descendientes con el nombre de etiqueta dado. Tu función debe recorrer el
documento en sí. No puede usar un método como querySelectorAll para
hacer el trabajo.
Para encontrar el nombre de etiqueta de un elemento, usa su propiedad
nodeName. Pero ten en cuenta que esto devolverá el nombre de la etiqueta
en mayúsculas. Usa los métodos de string toLowerCase o toUpperCase para
compensar esto.
El sombrero del gato
Extiende la animación del gato definida anteriormente para que tanto el gato
como su sombrero (<img src="img/hat.png">) orbiten en lados opuestos de la
elipse.
240

-- 252 of 445 --

O haz que el sombrero circule alrededor del gato. O altera la animación de
alguna otra manera interesante.
Para facilitar el posicionamiento de varios objetos, es probablemente una
buena idea cambiar a posicionamiento absoluto. Esto significa que top y left se
cuentan en relación al extremo superior izquierdo del documento. Para evitar
usar coordenadas negativas, que harían que la imagen se salga de la página
visible, puedes agregar un número fijo de píxeles a los valores de posición.
241

-- 253 of 445 --

“Tienes poder sobre tu mente, no sobre los eventos externos. Date
cuenta de esto y encontrarás fuerza.”
—Marco Aurelio, Meditaciones