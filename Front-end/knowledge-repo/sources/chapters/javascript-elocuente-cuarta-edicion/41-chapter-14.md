# Chapter 14

El Modelo de Objetos del Documento
Cuando abres una página web, tu navegador recupera el texto HTML de la
página y lo analiza, de manera similar a como nuestro analizador de Capítulo
12 analizaba programas. El navegador construye un modelo de la estructura
del documento y utiliza este modelo para dibujar la página en la pantalla.
Esta representación del documento es uno de los juguetes que un programa
JavaScript tiene disponible en su caja de arena. Es una estructura de datos que
puedes leer o modificar. Actúa como una estructura de datos en vivo: cuando
se modifica, la página en la pantalla se actualiza para reflejar los cambios.
Estructura del documento
Puedes imaginar un documento HTML como un conjunto anidado de cajas.
Etiquetas como <body> y </body> encierran otras etiquetas, que a su vez con-
tienen otras etiquetas o texto. Aquí está el documento de ejemplo del capítulo
anterior:
<!doctype html>
<html>
<head>
<title>Mi página de inicio</title>
</head>
<body>
<h1>Mi página de inicio</h1>
<p>Hola, soy Marijn y esta es mi página de inicio.</p>
<p>¡También escribí un libro! Léelo
<a href="http://eloquentjavascript.net">aquí</a>.</p>
</body>
</html>
Esta página tiene la siguiente estructura:
222

-- 234 of 445 --

here
a
.	I also wrote a book! Read it
p
Hello, I am Marijn and this is...
p
My home page
h1
body
My home page
title
head
html
La estructura de datos que el navegador utiliza para representar el documento
sigue esta forma. Para cada caja, hay un objeto con el que podemos interactuar
para saber cosas como qué etiqueta HTML representa y qué cajas y texto
contiene. Esta representación se llama Modelo de Objetos del Documento, o
DOM en resumen.
El enlace global document nos da acceso a estos objetos. Su propiedad
documentElement se refiere al objeto que representa la etiqueta <html>. Dado
que cada documento HTML tiene una cabeza y un cuerpo, también tiene
propiedades head y body, que apuntan a esos elementos.
Árboles
Piensa en los árbol sintácticos del Capítulo 12 por un momento. Sus estruc-
turas son sorprendentemente similares a la estructura de un documento de un
navegador. Cada nodo puede referirse a otros nodos, hijos, que a su vez pueden
tener sus propios hijos. Esta forma es típica de estructuras anidadas donde los
elementos pueden contener subelementos que son similares a ellos mismos.
Llamamos a una estructura de datos un árbol cuando tiene una estructura de
ramificación, no tiene ciclos (un nodo no puede contenerse a sí mismo, directa
o indirectamente), y tiene un raíz única y bien definida. En el caso del DOM,
document.documentElement sirve como la raíz.
Los árboles son comunes en la informática. Además de representar estruc-
turas recursivas como documentos HTML o programas, a menudo se utilizan
para mantener conjuntos de datos ordenados porque los elementos general-
223

-- 235 of 445 --

mente se pueden encontrar o insertar de manera más eficiente en un árbol que
en un arreglo plano.
Un árbol típico tiene diferentes tipos de nodos. El árbol de sintaxis para el
lenguaje Egg tenía identificadores, valores y nodos de aplicación. Los nodos
de aplicación pueden tener hijos, mientras que los identificadores y valores son
hojas, o nodos sin hijos.
Lo mismo ocurre para el DOM. Los nodos de los elementos, que representan
etiquetas HTML, determinan la estructura del documento. Estos pueden tener
nodo hijos. Un ejemplo de dicho nodo es document.body. Algunos de estos
hijos pueden ser nodo hoja, como fragmentos de texto o nodos comentario.
Cada objeto de nodo del DOM tiene una propiedad nodeType, que contiene
un código (número) que identifica el tipo de nodo. Los elementos tienen el
código 1, que también se define como la propiedad constante Node.ELEMENT_NODE
. Los nodos de texto, que representan una sección de texto en el documento,
obtienen el código 3 (Node.TEXT_NODE). Los comentarios tienen el código 8
(Node.COMMENT_NODE).
Otra forma de visualizar nuestro árbol de documento es la siguiente:
html 	head 	title 	My home page
body 	h1 	My home page
p 	Hello! I am...
p 	I also wrote...
here	a
.
Las hojas son nodos de texto, y las flechas indican las relaciones padre-hijo
entre nodos.
El estándar
Usar códigos numéricos crípticos para representar tipos de nodos no es algo
muy propio de JavaScript. Más adelante en este capítulo, veremos que otras
partes de la interfaz del DOM también se sienten incómodas y extrañas. La
razón de esto es que la interfaz del DOM no fue diseñada exclusivamente para
JavaScript. Más bien, intenta ser una interfaz neutral en cuanto a lenguaje que
también pueda utilizarse en otros sistemas, no solo para HTML, sino también
para XML, que es un formato de datos genérico con una sintaxis similar a
224

-- 236 of 445 --

HTML.
Esto es lamentable. Los estándares a menudo son útiles. Pero en este caso,
la ventaja (consistencia entre lenguajes) no es tan convincente. Tener una
interfaz que esté correctamente integrada con el lenguaje que estás utilizando
te ahorrará más tiempo que tener una interfaz familiar en varios lenguajes.
Como ejemplo de esta mala integración, considera la propiedad childNodes
que tienen los nodos de elementos en el DOM. Esta propiedad contiene un
objeto similar a un array, con una propiedad length y propiedades etiquetadas
por números para acceder a los nodos hijos. Pero es una instancia del tipo
NodeList, no un array real, por lo que no tiene métodos como slice y map.
Luego, hay problemas que son simplemente de mala diseño. Por ejemplo, no
hay forma de crear un nuevo nodo y agregar inmediatamente hijos o atributos a
él. En su lugar, primero tienes que crearlo y luego agregar los hijos y atributos
uno por uno, usando efectos secundarios. El código que interactúa mucho con
el DOM tiende a ser largo, repetitivo y feo.
Pero estos defectos no son fatales. Dado que JavaScript nos permite crear
nuestras propias abstracciones, es posible diseñar formas mejoradas de expre-
sar las operaciones que estás realizando. Muchas bibliotecas destinadas a la
programación del navegador vienen con herramientas de este tipo.
Movimiento a través del árbol
Los nodos DOM contienen una gran cantidad de enlaces a otros nodos cercanos.
El siguiente diagrama ilustra esto:
I also wrote a book! ...
p
Hello, I am Marijn...
p
My home page
h1
body
0
1
2
childNodes 	firstChild
lastChild
previousSibling
nextSibling
parentNode
Aunque el diagrama muestra solo un enlace de cada tipo, cada nodo tiene una
propiedad parentNode que apunta al nodo del que forma parte, si lo hay. De
igual manera, cada nodo de elemento (tipo 1) tiene una propiedad childNodes
que apunta a un objeto similar a un array que contiene sus hijos.
225

-- 237 of 445 --

En teoría, podrías moverte por todo el árbol utilizando solo estos enlaces
padre e hijo. Pero JavaScript también te da acceso a varios enlaces de con-
veniencia adicionales. Las propiedades firstChild y lastChild apuntan a los
primeros y últimos elementos hijos o tienen el valor null para nodos sin hijos.
De manera similar, previousSibling y nextSibling apuntan a nodos adya-
centes, que son nodos con el mismo padre que aparecen inmediatamente antes
o después del nodo en sí. Para un primer hijo, previousSibling será nulo, y
para un último hijo, nextSibling será nulo.
También está la propiedad children, que es como childNodes pero contiene
solo hijos de elementos (tipo 1), no otros tipos de nodos hijos. Esto puede ser
útil cuando no estás interesado en nodos de texto.
Cuando se trabaja con una estructura de datos anidada como esta, las fun-
ciones recursivas son frecuentemente útiles. La siguiente función examina un
documento en busca de nodos de texto que contengan una cadena específica y
devuelve true cuando ha encontrado uno:
function talksAbout(node, cadena) {
if (node.nodeType == Node.ELEMENT_NODE) {
for (let child of node.childNodes) {
if (talksAbout(child, cadena)) {
return true;
}
}
return false;
} else if (node.nodeType == Node.TEXT_NODE) {
return node.nodeValue.indexOf(cadena) > -1;
}
}
console.log(talksAbout(document.body, "libro"));
// → true
La propiedad nodeValue de un nodo de texto contiene la cadena de texto que
representa.
Encontrando elementos
Navegar por estos enlaces entre padres, hijos y hermanos a menudo es útil.
Pero si queremos encontrar un nodo específico en el documento, llegar a él
empezando por document.body y siguiendo un camino fijo de propiedades no es
una buena idea. Hacerlo implica hacer suposiciones en nuestro programa sobre
la estructura precisa del documento, una estructura que podrías querer cambiar
226

-- 238 of 445 --

más adelante. Otro factor complicador es que se crean nodos de texto incluso
para los espacios en blanco entre nodos. La etiqueta <body> del documento de
ejemplo no tiene solo tres hijos (<h1> y dos elementos <p>) sino que en realidad
tiene siete: esos tres, más los espacios en blanco antes, después y entre ellos.
Por lo tanto, si queremos obtener el atributo href del enlace en ese docu-
mento, no queremos decir algo como “Obtener el segundo hijo del sexto hijo
del cuerpo del documento”. Sería mejor si pudiéramos decir “Obtener el primer
enlace en el documento”. Y podemos hacerlo.
let enlace = document.body.getElementsByTagName("a")[0];
console.log(enlace.href);
Todos los nodos de elemento tienen un método getElementsByTagName, que
recoge todos los elementos con el nombre de etiqueta dado que son descendi-
entes (hijos directos o indirectos) de ese nodo y los devuelve como un objeto
similar a un array.
Para encontrar un nodo específico único, puedes darle un atributo id y usar
document.getElementById en su lugar.
<p>Mi avestruz Gertrudis:</p>
<p><img id="gertrudis" src="img/ostrich.png"></p>
<script>
let ostrich = document.getElementById("gertrudis");
console.log(ostrich.src);
</script>
Un tercer método similar es getElementsByClassName, que, al igual que getElementsByTagName
, busca a través del contenido de un nodo de elemento y recupera todos los
elementos que tienen la cadena dada en su atributo class.
Cambiando el documento
Casi todo se puede cambiar en la estructura de datos del DOM. La forma del
árbol del documento se puede modificar cambiando las relaciones padre-hijo.
Los nodos tienen un método remove para removerlos de su nodo padre actual.
Para añadir un nodo hijo a un nodo de elemento, podemos usar appendChild,
que lo coloca al final de la lista de hijos, o insertBefore, que inserta el nodo
dado como primer argumento antes del nodo dado como segundo argumento.
<p>Uno</p>
<p>Dos</p>
<p>Tres</p>
227

-- 239 of 445 --

<script>
let párrafos = document.body.getElementsByTagName("p");
document.body.insertBefore(párrafos[2], párrafos[0]);
</script>
Un nodo puede existir en el documento en un solo lugar. Por lo tanto, insertar
el párrafo Tres delante del párrafo Uno primero lo removerá del final del doc-
umento y luego lo insertará al principio, resultando en Tres/Uno/Dos. Todas
las operaciones que insertan un nodo en algún lugar causarán, como un efecto
secundario, que se elimine de su posición actual (si tiene una).
El método replaceChild se usa para reemplazar un nodo hijo con otro. Toma
como argumentos dos nodos: un nodo nuevo y el nodo que se reemplazará. El
nodo reemplazado debe ser un hijo del elemento en el que se llama el método.
Ten en cuenta que tanto replaceChild como insertBefore esperan que el nodo
nuevo sea su primer argumento.
Creación de nodos
Digamos que queremos escribir un script que reemplace todas las imágenes
(etiquetas <img>) en el documento con el texto contenido en sus atributos alt,
que especifica una representación textual alternativa de la imagen.
Esto implica no solo eliminar las imágenes sino agregar un nuevo nodo de
texto para reemplazarlas.
<p>The <img src="img/cat.png" alt="Cat"> in the
<img src="img/hat.png" alt="Hat">.</p>
<p><button onclick="replaceImages()">Replace</button></p>
<script>
function replaceImages() {
let images = document.body.getElementsByTagName("img");
for (let i = images.length - 1; i >= 0; i--) {
let image = images[i];
if (image.alt) {
let text = document.createTextNode(image.alt);
image.parentNode.replaceChild(text, image);
}
}
}
</script>
228

-- 240 of 445 --

Dada una cadena, createTextNode nos da un nodo de texto que podemos in-
sertar en el documento para que aparezca en la pantalla.
El bucle que recorre las imágenes comienza al final de la lista. Esto es nece-
sario porque la lista de nodos devuelta por un método como getElementsByTagName
(o una propiedad como childNodes) es dinámica. Es decir, se actualiza a me-
dida que el documento cambia. Si comenzáramos desde el principio, al quitar
la primera imagen haría que la lista perdiera su primer elemento, por lo que
la segunda vez que se repita el bucle, cuando i es 1, se detendría porque la
longitud de la colección ahora también es 1.
Si quieres tener una colección sólida de nodos, en lugar de una en vivo, puedes
convertir la colección en un array real llamando a Array.from.
let arrayish = {0: "uno", 1: "dos", length: 2};
let array = Array.from(arrayish);
console.log(array.map(s => s.toUpperCase()));