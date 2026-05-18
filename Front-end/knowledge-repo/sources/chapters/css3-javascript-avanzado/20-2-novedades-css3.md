# 2. Novedades CSS3

2.1. Nuevos selectores
Los selectores CSS son la herramienta más potente del lenguaje de estilos, pues-
to que nos permiten seleccionar diferentes elementos del contenido html en
función de la etiqueta o de sus atributos sin tener que hacer uso de su clase,
su ID o Javascript.
2.1.1. Selectores de atributos
• [att^="valor"]
Selecciona elementos con un atributo que empieza por valor.
• [att$="valor"]
Selecciona elementos con un atributo que acaba con valor.
• [att*="valor"]
Selecciona elementos que contienen un atributo que contiene valor.
Estos selectores pueden ser utilizados por todas las hojas de estilos destinadas
a navegadores, Internet Explorer 7 o superior, Opera, Webkit y navegadores
basados en Geko.
Ejemplo:
<style>
a[title$="sample"] {
color:#ea1d1d;
}
</style>
<p>Lorem ipsum <a href="#" title="this is a sample">dolor sit amet</a>, consectetur adipisicing
elit, sed do eiusmod tempor incididunt ut labore et dolore <a href="#">magna aliqua</a>. Ut enim
ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
Duis aute irure dolor in reprehenderit in voluptate velit esse <a href="#" title="this is a sample">
cillum dolore</a> eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
culpa qui officia deserunt mollit anim id est laborum.</p>

-- 11 of 86 --

CC-BY-SA • PID_00176160 12 CSS3 y Javascript avanzado
En el ejemplo, utilizando el selector de atributos acabado en $=, marcamos los
enlaces que contienen el atributo title acabado con "sample" de color rojo.
2.1.2. Combinadores (no soportado por IE6)
• ~￿Sibling￿General￿(Hermano)
Selecciona los elementos que son "hermanos" de uno. Una etiqueta hermana
es la que existe en el mismo nivel, o que tiene un padre en común y que
está a continuación de la referenciada. Así, en el ejemplo siguiente podemos
decir que son etiquetas hermanas los p y los h2, puesto que todos tienen el
mismo padre (div). Pero sólo se seleccionarán los elementos p posteriores a la
definición del h2.
Ejemplo:
<style>
h2~p { color:green; }
</style>
<div id="uno">
<p>Este elemento no será visible porque es hermano, pero es anterior.</p>
< h2>This is a test</h2>
<p>Este p es hermano de h2</p>
< p>Este otro p también es hermano de h2</p>
< /div>
<div id="dos">
<p>Este p no se pintará</p>
< /div>
Pintará de verde los p del div id=uno posteriores a h2, puesto que son her-
manos del h2. Tienen de padre en común el #uno, mientras que el p del div
id=dos no se pintará puesto que no tiene ningún hermano h2.
2.1.3. Pseudo-clases
Las pseudo-clases son uno de los añadidos más extendidos en uso del CSS3.
Las más útiles.
• :nth-child(n)

-- 12 of 86 --

CC-BY-SA • PID_00176160 13 CSS3 y Javascript avanzado
Selecciona elementos basándose en la posición de los hijos. Puede utilizar nú-
meros expresiones y las palabras odd, even (impar, par). Fácilmente podemos
hacer el típico efecto cebra en las tablas.
Por ejemplo, dada una lista <li>:
le:nth-child(2) { color: red; }
Pintará de rojo el segundo elemento de la lista.
le:nth-child(even) { color: red; }
Pintará de rojo los elementos pares.
le:nth-child(n+4) { color: red; }
Pintará de rojo todos los elementos a partir del cuarto.
le:nth-child(3n) { color: red; }
Pintará de rojo cada tres elementos.
le:nth-child(2n+5) { color: red; }
Pintará de rojo cada dos a partir del 5.
• :nth-last-child(n)
Sigue la misma idea que la anterior, pero selecciona a partir del último ele-
mento.
• :last-child
Selecciona el último elemento de una lista.
• :checked
Selecciona elementos que están marcados, tipos, checkboxes.
• :empty
Selecciona elementos que están vacíos.
• :not
Selecciona elementos que no cumplen la declaración especificada.
p:not([class*="lead"]) { color: black; }
Marcará todos los p que no tengan una clase asignada que contenga la cadena lead.
Los navegadores basados en Webkit y Opera admiten todos los pseudo-selecto-
res CSS3, los basados en Firefox 2 y 3 sólo admiten, el not, last-child only-child,
root, empty, target, checked, enabled y disabled, pero el Firefox 4 admite todos los
pseudo-selectores. Los navegadores Microsoft no admiten pseudo-selectores.

-- 13 of 86 --

CC-BY-SA • PID_00176160 14 CSS3 y Javascript avanzado
2.1.4. Pseudo-elementos
Los pseudo-elementos nos permiten seleccionar partes de contenido dentro
de una etiqueta. Por ejemplo, podemos seleccionar la primera línea emplean-
do el pseudo-elemento :first-line, o la primera letra, empleando el pseudo-ele-
mento :first-letter. Así:
P:first-letter { fuente-size: 35px }
Nos cambiará la primera letra. Una de las novedades muy interesantes del CSS3
es el pseudo-elemento :selection, aplicado a los campos de formulario, que
nos permite introducir modificaciones en el momento en EL que un campo
de formulario tiene el foco.
input:selection { background-color:#eaeaea }
Cambiará el color del campo de formulario cuando este tenga el foco y esté
seleccionado.
2.2. Colores RGBA y opacidad
2.2.1. RGBA
La posibilidad de especificar colores en modo RGB ya existía desde la especifi-
cación 2, pero en la versión 3 se ve ampliada con un nuevo modelo de color, el
basado en saturación (HSL), y la posibilidad de especificar canal￿alpha sobre
los colores. De este modo podemos crear expresiones CSS del tipo:
p { color: rgba(0,0,0,0.5) }
Creará un color negro con una transparencia del 50%. Para ver el efecto, habrá
que tener una imagen por debajo, o si nuestro color de fondo es blanco, nos
aparecerá de color gris.
2.2.2. Colores HSL
El modelo de color HSL￿(hue,￿saturation,￿light), tono, saturación y luz, define
el color a partir de los tres parámetros. Así, para una tonalidad de color dada,
podemos alterar la saturación a partir del segundo parámetro, y la cantidad de
luz en el tercer parámetro.

-- 14 of 86 --

CC-BY-SA • PID_00176160 15 CSS3 y Javascript avanzado
Por ejemplo:
Será definida por los colores:
background:hsla(320, 100%, 10%);
background:hsl(320, 80%, 30%);
background:hsl(320, 60%, 50%);
background:hsl(320, 40%, 70%);
background:hsl(320, 20%, 90%);
También podemos añadir el componente de alpha si definimos como: hs-
la(320,￿80%,￿30%,￿0,7).
El modelo de color HSL es implementado en los navegadores basados en Web-
kit y Firefox.
2.2.3. Opacity (opacidad)
Como su nombre indica, la opacidad nos permite definir el nivel de transpa-
rencia para un selector. A diferencia del modelo RGB, la transparencia se aplica
al objeto y todos sus hijos y/o contenidos. Así, por ejemplo:
<img src="img_02.jpg" style="opacity:0.2">
<img src="img_02.jpg" style="opacity:0.4">
<img src="img_02.jpg" style="opacity:0.6">
<img src="img_02.jpg" style="opacity:0.8">
<img src="img_02.jpg" style="opacity:1">
producirá:

-- 15 of 86 --

CC-BY-SA • PID_00176160 16 CSS3 y Javascript avanzado
Todas las propiedades son admitidas por los navegadores basados en tecnolo-
gía Webkit, Geko (Mozilla) y Opera, mientras que Explorer no lo admite. De
todos modos, la familia Microsoft admite otra propiedad complementaria, que
nos permite realizar el mismo efecto, siendo:
filter: alpha(opacity = 50);
Todas estas propiedades podemos utilizarlas siempre que tengamos en cuenta
un mecanismo alternativo para los navegadores que no lo admiten. La mejor
mecánica de trabajo es definir primero un color admitido para después añadir
las propiedades CSS3. De este modo el navegador que no la admite utilizará la
primera, mientras que los que la admitan podrán utilizarla.
2.3. Nuevas propiedades
2.3.1. Esquinas redondeadas (border-radius)
Seguramente es la propiedad CSS3 más esperada y deseada por los diseñado-
res html. Permite redondear las esquinas de una caja (div, span... ) dado un
radio, sin la necesidad de utilizar una imagen de fondo, producida con una
herramienta de edición gráfica.
Podemos manipular las esquinas de una caja de manera uniforme utilizando
la propiedad border-radius:￿15px; como se muestra en el ejemplo siguiente:
#example1 {
-moz-border-radius: 15px;
border-radius: 15px;
}
Hemos de fijarnos en la presencia de la propiedad -moz-border-radius:￿15px;
específica de los navegadores basados en Geko.
Pero también podemos definir las propiedades para cada una de las esquinas
utilizando las propiedades border-bottom-left-radius,￿ border-bottom-right-
radius,￿border-top-left-radius,￿border-top-right-radius. Estas propiedades ad-
miten dos parámetros para definir el radio de curvatura de la esquina. Si defi-

-- 16 of 86 --

CC-BY-SA • PID_00176160 17 CSS3 y Javascript avanzado
nimos sólo uno, conseguimos esquinas simétricas, mientras que si definimos
los dos, estamos tratando independientemente el parámetro x del y, como se
puede apreciar en el gráfico siguiente:
Hay que señalar que para los navegadores basados en Geko, se deben
emplear las propiedades: -moz-border--moz-bottom-left-radius,￿ -moz-bor-
der-bottom-right-radius,￿-moz-border-top-left-radius,￿-moz-border-top-right-
radius.
Por otro lado, la propiedad border-radius también puede ser empleada para
definir de una vez las cuatro esquinas de la caja:
border-radius: 5px 10px 5px 10px / 10px 5px 10px 5px;
border-radius: 5px;
border-radius: 5px / 10px;
En la primera definición, el primer grupo de 4 medidas definen las propieda-
des horizontales de los cuatro radios, mientras que el segundo grupo, utilizado
separado por el carácter /, define los radios verticales. En el segundo ejemplo,
se definen todos con un radio de 5px. En el tercero, se define un radio hori-
zontal de 5px y uno vertical de 10px para las 4 esquinas.
Todas estas propiedades están disponibles en los navegadores basados en Web-
kit, Geko, Opera, y en la última versión del navegador de Microsoft (IE9), que
finalmente intenta cumplir con las especificaciones del W3C.
2.3.2. Sombras (box-shadow, text-shadow)
En la versión 2 de la especificación se introdujo la posibilidad de generar som-
bras directamente desde código CSS, pero se quitó en la 2.1 y se ha vuelto a
introducir en la versión 3.
Las propiedades para generar sombras en una caja son las siguientes:
#example1 {
-moz-box-shadow: 10px 10px 5px #888;
-webkit-box-shadow: 10px 10px 5px #888;
box-shadow: 10px 10px 5px #888;
}

-- 17 of 86 --

CC-BY-SA • PID_00176160 18 CSS3 y Javascript avanzado
generará:
La propiedad box-shadow admite una lista de 5 elementos, que definen, en
orden, desplazamiento horizontal, desplazamiento vertical, desenfocado, ex-
tensión y color de la sombra. Opcionalmente, se puede añadir la palabra clave
inset, que nos permitirá hacer una sombra interna en lugar de una externa:
Algunos ejemplos:
#Example_F {
-moz-box-shadow: 0 0 5px 5px #888;
-webkit-box-shadow: 0 0 5px 5px#888;
box-shadow: 0 0 5px 5px #888;
}
La propiedad text-shadow se comporta de igual modo, y nos permite generar
sombras en los textos.
Por otro lado, cabe decir que podemos tener más de una sombra por elemen-
to, es decir, que las podemos superponer como efecto de papel cebolla. Para
hacerlo:
box-shadow: 0 0 10px 5px black, -20px 0px 50px blue;

-- 18 of 86 --

CC-BY-SA • PID_00176160 19 CSS3 y Javascript avanzado
Generará dos sombras, una negra y una azul. Podemos encadenar varias sim-
plemente separando la lista por comas.
2.3.3. Múltiples imágenes de fondo
Otra característica interesante de CSS3 es la posibilidad de incluir múltiples
imágenes de fondo en un mismo elemento. Así, el código siguiente es com-
pletamente funcional:
#example1 {
width: 500px;
height: 250px;
background-image: url(fons1.png), url(fons2.png);
background-position: center bottom, left top;
background-repeat: no-repeat;
}
Fijaos en que definimos dos imágenes de fondo: fondo1.png y fondo2.png,
y también dos posiciones diferentes para cada una. Una centrada en la parte
inferior y otra en la parte superior izquierda.
2.3.4. Borders (filetes) con imágenes
Podemos definir imágenes para los filetes de nuestros bloques. Así:
border-image: url(border-image.png) 25% repeat;
Definiremos la imagen que queremos emplear como filete. El porcentaje está
relacionado con la parte que queremos emplear y, finalmente, si queremos que
repita modo patrón o queremos que sólo aparezca una vez. A primera vista
parece complicado, pero nos podemos adentrar un poco en el tema con un
ejemplo. Dada la imagen:

-- 19 of 86 --

CC-BY-SA • PID_00176160 20 CSS3 y Javascript avanzado
Y queriéndola emplear como fondo, utilizando el siguiente código:
#un {
padding:30px;
border-width:10px 10px 10px 10px;
-webkit-border-image: url('css3_imatge_fons.png') 10 100 10 10 repeat stretch;
background-color:#fff;
}
Obtenemos el siguiente resultado:
Si nos fijamos, primero definimos un ancho de filete (10 píxeles) con la pro-
piedad border-width, después definimos la imagen que utilizaremos y las pro-
porciones en píxeles (también admite porcentajes) de imagen para cada una
de las esquinas. Finalmente, tenemos la propiedad (stretch/repeat) por si que-
remos que repita o se ajuste.

-- 20 of 86 --

CC-BY-SA • PID_00176160 21 CSS3 y Javascript avanzado
2.3.5. Columnas de texto
Otra de las novedades es la posibilidad de trabajar con columnas de texto. Real-
mente, con el ancho actual de las pantallas ha sido necesario hacerlo, puesto
que un ancho demasiado grande en los párrafos de texto afecta a su legibili-
dad. Así, desde la especificación 3, podemos utilizar diseños con columnas.
Las propiedades que hemos de emplear son:
-moz-column-count: 3;
-webkit-column-count: 3;
-moz-column-width: 200px;
-webkit-column-width:200px;
-moz-column-gap: 20px;
-webkit-column-gap: 20px;
Nos generará una estructura de tres columnas siempre y cuando puedan cum-
plir con el tamaño de ancho de columna preferido, fijado con -column-width,
si se hiciera así, emplearía la parte proporcional del área disponible. Con la
propiedad *-column-gap:￿20px definimos el margen que queremos entre co-
lumnas, y también disponemos de la propiedad column-rule, con la que po-
demos definir un filete que divida las columnas.
Nos generará,
2.3.6. WebFonts
Otra de las posibilidades que resulta muy atractiva a la hora de emplear los
CSS3 es la capacidad de adjuntar tipografías a un documento html. Pero como
sucede con todas las cosas relativas a la industria de los navegadores, existen
diferentes sistemas, formatos, etc. y, evidentemente, licencias de las tipogra-
fías.
A partir de la especificación 3, disponemos de la etiqueta @font-face, que, co-
mo en el ejemplo, nos permite definir una tipografía.
@font-face {
font-family: Gentium;
src: url(gentium.otf);

-- 21 of 86 --

CC-BY-SA • PID_00176160 22 CSS3 y Javascript avanzado
}
Como vemos en el ejemplo anterior, esta etiqueta nos permite adjuntar al
documento una tipografía. Pero los problemas vienen a raíz de los diferentes
formatos que cada navegador y versión entienden del archivo de tipografías.
Así, el resultado para una correcta visualización en todos los navegadores sería:
@font-face {
font-family: 'UbuntuRegular';
src: url('webfont.eot');
src: url('webfont.eot?#iefix') format('embedded-opentype'),
url('webfont.woff') format('woff'),
url('webfont.ttf') format('truetype'),
url('webfont.svg#UbuntuRegular') format('svg');
font-weight: normal;
font-style: normal;}
Y de este modo obtenemos una correcta visualización en todas las versiones
de los navegadores. Para generar todas las versiones de la fuente, es necesario
que empleemos una herramienta como la siguiente:
http://www.fontsquirrel.com/fontface/generator
Dado un archivo ttf u OpenType, esta herramienta nos generará tanto las ver-
siones que se van a subir al servidor como la definición CSS para emplearlas
en nuestro documento.
Debido a la complejidad existente y a la necesidad que tienen los diseñado-
res de trabajar con tipografías personalizadas, han aparecido servicios en línea
que nos permiten adjuntar tipografías a nuestros documentos, sin necesidad
de preocuparnos por las licencias ni por las conversiones de archivos. Actual-
mente los dos servicios más extendidos son:
• El comercial TypeKit (http://typekit.com/), donde se preocupan de licen-
ciarnos y servirnos el uso de una tipografía comercial.
• El servicio de Google webfonts (http://www.google.com/webfonts), me-
diante el cual, empleando tipografías OpenSource, podemos adjuntar las
tipografías a nuestros documentos.
Ambos servicios se encargan de servir las diferentes versiones de la tipografía,
para cada versión del navegador, facilitándonos un pequeño código CSS, ad-
juntable a nuestro CSS, y que nos dará acceso al uso de la tipografía.

-- 22 of 86 --

CC-BY-SA • PID_00176160 23 CSS3 y Javascript avanzado
2.3.7. MediaQueries
Desde la versión 2.1 de los CSS, existe la posibilidad de definir estilos en fun-
ción del uso de la hoja: una para la pantalla (screen), otra para la impresión
(print), otra para los lectores de voz (voice). A partir de la especificación 3 esto
va un paso más allá, y nos permite definir estilos específicos para diferentes
tamaños de pantalla. Fijémonos en esta definición:
@media screen and (max-width: 600px) {
.class { background: #ccc; }
}
Define estilos específicos para navegadores con un ancho de pantalla menor de
600 píxeles. También lo podemos hacer directamente con una hoja de estilos
utilizando la etiqueta:
<link rel="stylesheet" media="screen and (min-width: 600px)" href="small.css" />
En este caso, estaríamos refiriéndonos a tamaños de pantalla mayores de 600
píxeles o, como mínimo, 600px.
Existe una pequeña y sutil diferencia: podemos emplear min-width o min-
device-width. Con la primera hacemos referencia al área visible en estos mo-
mentos en el dispositivo, mientras que con device-width hacemos referencia
a la resolución del dispositivo.
La posibilidad de poder trabajar así, realmente, nos ofrece soluciones óptimas,
puesto que podemos emplear sólo CSS para crear una versión móvil de un site.
2.4. Transiciones CSS
Las transiciones CSS son pequeños cambios en propiedades de la hoja de es-
tilos desencadenados por acontecimientos generados por interacciones del
usuario, como por ejemplo cuando el ratón pasa por encima de algo (:hover)
o un campo de formulario cambia, etc. En una transición, estos cambios en
las propiedades se producen de manera progresiva durante un intervalo de
tiempo.
Supongamos un ejemplo simple para entender cómo funcionan las transicio-
nes CSS:
<a href="#" class="boto">Botón para transición</a>
a.boto {
text-decoration:none;
color:#fff;
padding: 5px 10px;
background: #f76c6c;
Web recomendada
Podemos ver muchos ejem-
plos en la web:
http://www.mediaqueri.es

-- 23 of 86 --

CC-BY-SA • PID_00176160 24 CSS3 y Javascript avanzado
-webkit-transition-property:background;
-webkit-transition-duration: 0.5s;
-webkit-transition-timing-function:ease;
}
a.boto:hover {
background: #d22828;
}
Generará la siguiente imagen y, al pasar el ratón por encima (hover), desenca-
denará la transición correspondiente.
Del código siguiente es necesario que expliquemos y destaquemos lo siguiente:
• La transición no se debe poner en el evento (en este caso, el selector hover),
puesto que simplemente si la tiene ya la puede efectuar cuando toque.
• Lo que definimos en la transición es la propiedad de la transición que
queremos animar, en este caso el background.
• Podemos definir la duración y también la interpolación de tiempo. En
este caso se utiliza una función de aceleración. Las funciones de las que
disponemos son las siguientes: ease,￿linear,￿ease-in,￿ease-out,￿ease-in-out,
y cubic-bezier.
• También podemos definir un retraso en la ejecución de la animación con
la propiedad -webkit-transition-delay:￿0.5s;.
De todos modos, existe un acelerador para las transiciones que es el siguiente:
-webkit-transition: background 0.3s ease 0.5s;
A efectos prácticos, realiza lo mismo que la anterior definición pero de una
manera más compacta. También cabe decir que se pueden definir transiciones
de más de una propiedad separándolas con una (,):
-webkit-transition: background .3s ease, color 0.2s linear;
Las transiciones con CSS sólo están disponibles en los navegadores basados en
Webkit, Opera y en la versión 4 del Geko. Por ello, es necesario que añadamos
el acelerador para compatibilidad:
-webkit-transition: background .3s ease, color 0.2s linear;
-moz-transition: background .3s ease, color 0.2s linear;
-o-transition: background .3s ease, color 0.2s linear;
Web recomendada
Aquí podremos encontrar
una lista de las propiedades
que pueden ser animadas
(transiciones):
http://www.w3.org/TR/css3-
transitions/#properties-from-
css-

-- 24 of 86 --

CC-BY-SA • PID_00176160 25 CSS3 y Javascript avanzado
transition: background 3s ease, color 0.2s linear;
Otra opción disponible es hacer la transición de todas las propiedades que
cambien. Ello lo podemos realizar con la instrucción all:
transition: all 3s ease, color 0.2s linear;
2.5. Ejercicios