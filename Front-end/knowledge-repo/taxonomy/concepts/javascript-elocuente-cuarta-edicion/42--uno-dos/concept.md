# // → ["UNO", "DOS"]

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 42)

## Contenido
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
navegador tendrá que calcular un nuevo diseño para dibujar
