# Chapter 13

JavaScript y el Navegador
Los próximos capítulos de este libro hablarán sobre los navegadores web. Sin
los navegadores web, no habría JavaScript. O incluso si existiera, nadie le
habría prestado atención.
La tecnología web ha sido descentralizada desde el principio, no solo técni-
camente, sino también en la forma en que evolucionó. Varios fabricantes de
navegadores han añadido nueva funcionalidad de manera ad hoc y a veces sin
mucho sentido, que luego, a veces, terminaba siendo adoptada por otros, y
finalmente establecida como en los estándares.
Esto es a la vez una bendición y una maldición. Por un lado, es empoder-
ador no tener a una parte central controlando un sistema, sino mejorando con
la contribución de diferentes partes que trabajan en una colaboración laxa (o
a veces en abierta hostilidad). Por otro lado, la forma caótica en que se desar-
rolló la Web significa que el sistema resultante no es precisamente un ejemplo
brillante de coherencia interna. Algunas partes son directamente confusas y
están mal diseñadas.
Redes y el Internet
Las redes de computadoras existen desde la década de 1950. Si conectas cables
entre dos o más computadoras y les permites enviar datos de ida y vuelta a
través de estos cables, puedes hacer todo tipo de cosas maravillosas.
Y si conectar dos máquinas en el mismo edificio nos permite hacer cosas
maravillosas, conectar máquinas en todo el planeta debería ser aún mejor. La
tecnología para comenzar a implementar esta visión se desarrolló en la década
de 1980, y la red resultante se llama el Internet. Ha cumplido su promesa.
Una computadora puede usar esta red para enviar bits a otra computadora.
Para que surja una comunicación efectiva de este envío de bits, las computado-
ras en ambos extremos deben saber qué se supone que representan los bits. El
significado de cualquier secuencia dada de bits depende enteramente del tipo de
cosa que está tratando de expresar y del mecanismo de codificación utilizado.
214

-- 226 of 445 --

Un protocolo de red describe un estilo de comunicación sobre una red. Hay
protocolos para enviar correos electrónicos, para recibir correos electrónicos,
para compartir archivos e incluso para controlar computadoras que han sido
infectadas por software malicioso.
El Protocolo de Transferencia de Hipertexto (HTTP) es un protocolo para
recuperar recursos nombrados (trozos de información, como páginas web o
imágenes). Especifica que el lado que realiza la solicitud debe comenzar con
una línea como esta, nombrando el recurso y la versión del protocolo que está
intentando usar:
GET /index.html HTTP/1.1
Hay muchas más reglas sobre la forma en que el solicitante puede incluir más
información en la solicitud y la forma en que el otro lado, que devuelve el
recurso, empaqueta su contenido. Veremos HTTP con un poco más de detalle
en el Capítulo 18.
La mayoría de los protocolos se construyen sobre otros protocolos. HTTP
trata la red como un dispositivo similar a un flujo en el que puedes poner bits
y hacer que lleguen al destino correcto en el orden correcto. Proporcionar esas
garantías encima del envío de datos primitivos que proporciona la red es un
problema bastante complicado.
El Protocolo de Control de Transmisión (TCP) es un protocolo que aborda
este problema. Todos los dispositivos conectados a Internet lo “hablan” y la
mayoría de las comunicaciones en Internet se construyen sobre él.
Una conexión TCP funciona de la siguiente manera: una computadora debe
estar esperando, o escuchando, a que otras computadoras comiencen a hablar
con ella. Para poder escuchar diferentes tipos de comunicación al mismo tiempo
en una sola máquina, cada oyente tiene asociado un número (llamado puerto).
La mayoría de los protocolos especifican qué puerto debe usarse de forma prede-
terminada. Por ejemplo, cuando queremos enviar un correo electrónico usando
el protocolo SMTP, se espera que la máquina a través de la cual lo enviamos
esté escuchando en el puerto 25.
Otra computadora puede establecer entonces una conexión conectándose a
la máquina de destino usando el número de puerto correcto. Si la máquina de
destino es alcanzable y está escuchando en ese puerto, la conexión se crea con
éxito. La computadora que escucha se llama el servidor, y la computadora que
se conecta se llama el cliente.
Dicha conexión actúa como un conducto bidireccional a través del cual
pueden fluir los bits: las máquinas en ambos extremos pueden insertar datos
en él. Una vez que los bits se transmiten con éxito, pueden volver a ser leídos
215

-- 227 of 445 --

por la máquina del otro lado. Este es un modelo conveniente. Se podría decir
que TCP proporciona una abstracción de la red.
La Web
El World Wide Web (no se debe confundir con el Internet en su totalidad) es
un conjunto de protocolos y formatos que nos permiten visitar páginas web en
un navegador. La parte “Web” en el nombre se refiere al hecho de que estas
páginas pueden enlazarse fácilmente entre sí, conectándose así en una gran
malla por la que los usuarios pueden moverse.
Para formar parte de la Web, todo lo que necesitas hacer es conectar una
máquina al Internet y hacer que escuche en el puerto 80 con el protocolo HTTP
para que otras computadoras puedan solicitarle documentos.
Cada documento en la Web está nombrado por un Localizador de Recursos
Uniforme (URL), que se ve algo así:
http://eloquentjavascript.net/13_browser.html
| | | |
protocol servidor ruta
La primera parte nos dice que esta URL utiliza el protocolo HTTP (en con-
traposición, por ejemplo, a HTTP cifrado, que sería https:// ). Luego viene
la parte que identifica desde qué servidor estamos solicitando el documento.
Por último está una cadena de ruta que identifica el documento específico (o
recurso) en el que estamos interesados.
Las máquinas conectadas a Internet tienen una dirección IP, que es un
número que se puede utilizar para enviar mensajes a esa máquina, y se ve algo
así como 149.210.142.219 o 2001:4860:4860::8888. Pero las listas de números
más o menos aleatorios son difíciles de recordar y complicados de escribir, así
que en su lugar puedes registrar un nombre de dominio para una dirección
específica o un conjunto de direcciones. Registré eloquentjavascript.net para
apuntar a la dirección IP de una máquina que controlo y, por lo tanto, puedo
usar ese nombre de dominio para servir páginas web.
Si escribes esta URL en la barra de direcciones de tu navegador, el nave-
gador intentará recuperar y mostrar el documento en esa URL. Primero, tu
navegador tiene que averiguar a qué dirección se refiere eloquentjavascript.net.
Luego, utilizando el protocolo HTTP, hará una conexión con el servidor en esa
dirección y solicitará el recurso /13_browser.html. Si todo va bien, el servidor
enviará un documento, que tu navegador mostrará en tu pantalla.
216

-- 228 of 445 --

HTML
HTML, que significa Lenguaje de Marcado de Hipertexto, es el formato de
documento utilizado para páginas web. Un documento HTML contiene texto,
así como etiquetas que estructuran el texto, describiendo cosas como enlaces,
párrafos y encabezados.
Un documento HTML corto podría lucir así:
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Mi página de inicio</title>
</head>
<body>
<h1>Mi página de inicio</h1>
<p>Hola, soy Marijn y esta es mi página de inicio.</p>
<p>¡También escribí un libro! Léelo
<a href="http://eloquentjavascript.net">aquí</a>.</p>
</body>
</html>
Así es como se vería dicho documento en el navegador:
Las etiquetas, encerradas en corchetes angulares (< y >, los símbolos de menor
que y mayor que), proporcionan información sobre la estructura del documento.
El otro texto es simplemente texto plano.
El documento comienza con <!doctype html>, lo que indica al navegador in-
terpretar la página como HTML moderno, en contraposición a estilos obsoletos
que se utilizaban en el pasado.
Los documentos HTML tienen una cabecera y un cuerpo. La cabecera con-
tiene información sobre el documento, y el cuerpo contiene el documento en
sí. En este caso, la cabecera declara que el título de este documento es “Mi
página de inicio” y que utiliza la codificación UTF-8, que es una forma de cod-
ificar texto Unicode como datos binarios. El cuerpo del documento contiene
un encabezado (<h1>, que significa “encabezado 1” —<h2> a <h6> producen
subencabezados) y dos párrafos (<p>).
Las etiquetas vienen en varias formas. Un elemento, como el cuerpo, un pár-
217

-- 229 of 445 --

rafo o un enlace, comienza con una etiqueta de apertura como <p> y finaliza con
una etiqueta de cierre como </p>. Algunas etiquetas de apertura, como la de
enlace (<a>), contienen información adicional en forma de pares nombre="valor
". Estos se llaman atributos. En este caso, el destino del enlace se indica con
href="http://eloquentjavascript.net", donde href significa “hipervínculo de
referencia”.
Algunos tipos de etiquetas no contienen nada y por lo tanto no necesitan ser
cerradas. La etiqueta de metadatos <meta charset="utf-8"> es un ejemplo de
esto.
Para poder incluir corchetes angulares en el texto de un documento, a pesar
de que tienen un significado especial en HTML, se debe introducir otra forma
especial de notación. Un simple signo menor que se escribe como &lt; (“menor
que”), y un signo mayor que se escribe como &gt; (“mayor que”). En HTML,
un carácter y comercial (&) seguido de un nombre o código de carácter y un
punto y coma (;) se llama una entidad y será reemplazado por el carácter que
codifica.
Esto es análogo a la manera en que se utilizan las barras invertidas en las
cadenas de texto de JavaScript. Dado que este mecanismo también otorga
un significado especial a los caracteres de y comercial, necesitan ser escapados
como &amp;. Dentro de los valores de los atributos, que están entre comillas
dobles, se puede usar &quot; para insertar un carácter de comillas real.
HTML se analiza de una manera notablemente tolerante a errores. Cuando
faltan etiquetas que deberían estar ahí, el navegador las agrega automática-
mente. La forma en que se hace esto se ha estandarizado, y puedes confiar en
que todos los navegadores modernos lo harán de la misma manera.
El siguiente documento será tratado igual que el que se mostró anteriormente:
<!doctype html>
<meta charset=utf-8>
<title>Mi página de inicio</title>
<h1>Mi página de inicio</h1>
<p>Hola, soy Marijn y esta es mi página de inicio.
<p>También escribí un libro! Léelo
<a href=http://eloquentjavascript.net>aquí</a>.
Las etiquetas <html>, <head> y <body> han desaparecido por completo. El
navegador sabe que <meta> y <title> pertenecen a la cabecera y que <h1>
significa que el cuerpo ha comenzado. Además, ya no cierro explícitamente los
párrafos, ya que abrir un nuevo párrafo o finalizar el documento los cerrará
implícitamente. Las comillas alrededor de los valores de los atributos también
218

-- 230 of 445 --

han desaparecido.
Este libro generalmente omitirá las etiquetas <html>, <head> y <body> en
ejemplos para mantenerlos cortos y libres de desorden. Pero sí cerraré las
etiquetas e incluiré comillas alrededor de los atributos.
También generalmente omitiré el doctype y la declaración charset. Esto
no debe interpretarse como una recomendación para omitirlos de documentos
HTML. Los navegadores a menudo hacen cosas ridículas cuando los olvidas.
Deberías considerar que el doctype y los metadatos del charset están implíci-
tamente presentes en los ejemplos, incluso cuando no se muestran realmente en
el texto.
HTML y JavaScript
En el contexto de este libro, la etiqueta HTML más importante es <script>.
Esta etiqueta nos permite incluir un fragmento de JavaScript en un documento.
<h1>Probando alerta</h1>
<script>alert("¡hola!");</script>
Dicho script se ejecutará tan pronto como su etiqueta <script> sea encontrada
mientras el navegador lee el HTML. Esta página mostrará un cuadro de diálogo
al abrirla—la función alert se asemeja a prompt, en que muestra una ventana
pequeña, pero solo muestra un mensaje sin solicitar entrada.
Incluir programas extensos directamente en documentos HTML a menudo es
poco práctico. La etiqueta <script> puede recibir un atributo src para obtener
un archivo de script (un archivo de texto que contiene un programa JavaScript)
desde una URL.
<h1>Probando alerta</h1>
<script src="code/hello.js"></script>
El archivo code/hello.js incluido aquí contiene el mismo programa—alert("
¡hola!"). Cuando una página HTML referencia otras URL como parte de sí
misma—por ejemplo, un archivo de imagen o un script—los navegadores web
los recuperarán inmediatamente e incluirán en la página.
Una etiqueta de script siempre debe cerrarse con </script>, incluso si hace
referencia a un archivo de script y no contiene ningún código. Si olvidas esto,
el resto de la página se interpretará como parte del script.
Puedes cargar módulos ES (ver Capítulo 10) en el navegador al darle a tu
etiqueta de script un atributo type="module". Dichos módulos pueden depender
de otros módulos usando URLs relativas a sí mismos como nombres de módulo
219

-- 231 of 445 --

en declaraciones de import.
Algunos atributos también pueden contener un programa JavaScript. La
etiqueta <button> (que se muestra como un botón) soporta un atributo onclick.
El valor del atributo se ejecutará cada vez que se haga clic en el botón.
<button onclick="alert('¡Boom!');">¡NO PRESIONES!</button>
Nota que tuve que utilizar comillas simples para el string en el atributo onclick
porque las comillas dobles ya se usan para citar todo el atributo. También
podría haber utilizado &quot;.
En el entorno controlado
Ejecutar programas descargados de Internet es potencialmente peligroso. No
sabes mucho sobre las personas detrás de la mayoría de los sitios que visitas, y
no necesariamente tienen buenas intenciones. Ejecutar programas de personas
que no tienen buenas intenciones es cómo se infecta tu computadora con virus,
te roban tus datos y hackean tus cuentas.
Sin embargo, la atracción de la Web es que puedes navegar por ella sin
necesariamente confiar en todas las páginas que visitas. Por eso, los naveg-
adores limitan severamente las cosas que un programa JavaScript puede hacer:
no puede ver los archivos en tu computadora ni modificar nada que no esté
relacionado con la página web en la que estaba incrustado.
Aislar un entorno de programación de esta manera se llama sandboxing, la
idea es que el programa está jugando inofensivamente en un arenero. Pero debes
imaginar este tipo particular de arenero como teniendo una jaula de barras de
acero gruesas sobre él para que los programas que juegan en él no puedan salir
realmente.
La parte difícil del sandboxing es permitir que los programas tengan su-
ficiente espacio para ser útiles y al mismo tiempo restringirlos para que no
hagan nada peligroso. Muchas funcionalidades útiles, como comunicarse con
otros servidores o leer el contenido del portapapeles, también pueden usarse
para hacer cosas problemáticas que invaden la privacidad.
De vez en cuando, alguien encuentra una nueva forma de evitar las limita-
ciones de un navegador y hacer algo dañino, que va desde filtrar información
privada menor hasta tomar el control de toda la máquina en la que se ejecuta
el navegador. Los desarrolladores de navegadores responden reparando el agu-
jero, y todo vuelve a estar bien, hasta que se descubre el próximo problema, y
con suerte se publicita, en lugar de ser explotado en secreto por alguna agencia
gubernamental u organización criminal.
220

-- 232 of 445 --

Compatibilidad y las guerras de navegadores
En las etapas iniciales de la Web, un navegador llamado Mosaic dominaba el
mercado. Después de unos años, el equilibrio se desplazó a Netscape, que a su
vez fue en gran medida reemplazado por Internet Explorer de Microsoft. En
cualquier punto en el que un único navegador era dominante, el fabricante de
ese navegador se creía con derecho a inventar nuevas funciones para la Web
unilateralmente. Dado que la mayoría de usuarios usaban el navegador más
popular, los sitio webs simplemente comenzaban a usar esas características, sin
importar los otros navegadores.
Esta fue la era oscura de la compatibilidad, a menudo llamada las guerras
de navegadores. Los desarrolladores web se quedaron con no una Web unifi-
cada, sino dos o tres plataformas incompatibles. Para empeorar las cosas, los
navegadores en uso alrededor de 2003 estaban llenos de errores, y por supuesto
los errores eran diferentes para cada navegador. La vida era difícil para las
personas que escribían páginas web.
Mozilla Firefox, un derivado sin ánimo de lucro de Netscape, desafió la posi-
ción de Internet Explorer a finales de la década de 2000. Debido a que Mi-
crosoft no estaba particularmente interesado en mantenerse competitivo en ese
momento, Firefox le quitó mucho cuota de mercado. Alrededor del mismo
tiempo, Google introdujo su navegador Chrome y el navegador de Apple Safari
ganó popularidad, lo que llevó a una situación en la que había cuatro actores
principales, en lugar de uno solo.
Los nuevos actores tenían una actitud más seria hacia los estándares y
mejores prácticas de ingeniería, lo que nos dio menos incompatibilidad y menos
errores. Microsoft, viendo cómo su cuota de mercado se desmoronaba, adoptó
estas actitudes en su navegador Edge, que reemplaza a Internet Explorer. Si
estás empezando a aprender desarrollo web hoy, considérate afortunado. Las
últimas versiones de los principales navegadores se comportan de manera bas-
tante uniforme y tienen relativamente pocos errores.Desafortunadamente, con
la disminución constante de la cuota de mercado de Firefox y Edge convirtién-
dose en simplemente un contenedor alrededor del núcleo de Chrome en 2018,
esta uniformidad podría una vez más tomar la forma de un único proveedor
—Google en este caso— teniendo el suficiente control sobre el mercado de
navegadores para imponer su idea de cómo debería lucir la Web al resto del
mundo.
221

-- 233 of 445 --

“¡Qué mal! ¡La misma vieja historia! Una vez que has terminado de
construir tu casa, te das cuenta de que has aprendido
accidentalmente algo que realmente deberías haber sabido antes de
comenzar.”
—Friedrich Nietzsche, Más allá del bien y del mal