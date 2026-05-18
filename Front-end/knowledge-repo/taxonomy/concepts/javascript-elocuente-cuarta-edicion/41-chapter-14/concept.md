# Chapter 14

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 41)

## Contenido
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
te ahorrará más t
