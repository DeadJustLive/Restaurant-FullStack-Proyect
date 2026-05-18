# 3. Bibliotecas Javascript

## Fuente
css3-javascript-avanzado (Cap. 23)

## Contenido
# 3. Bibliotecas Javascript

3.1. ¿Por qué una biblioteca?
Javascript es el lenguaje de programación utilizado en el desarrollo de aplica-
ciones web por parte del cliente. Recordando un poco la historia, Javascript
como lenguaje nace en 1995 gracias a Netscape Corporation, que lo incorpora
como lenguaje de script en su primera versión del cliente de WWW. Paralela-
mente, Microsoft inicia el desarrollo de su cliente de WWW, Internet￿Explo-
rer, y copia el lenguaje de Netscape pero cambiándole el nombre por el de
jScript. Realmente los dos lenguajes son muy parecidos, pero diferentes.
Desde el principio se generan diferencias en el uso, con el modo en el que
se interactúa con el DOM (document object model), el sistema de eventos, y en
otras muchas pequeñas peculiaridades que los hacen diferentes. Así, nos en-
contramos con un lenguaje que debe interactuar con modelos de clases dife-
rentes y utiliza sistemas de eventos distintos.
Al principio la programación de cliente era terriblemente difícil, puesto que
había que trabajar con cada una de las especificaciones para los diferentes na-
vegadores, lo que provocaba que el código que se generaba fuera poco sólido y
mantenible. Fácilmente podías encontrarte desarrollada una pequeña función
con dos condicionales para cada especificación de navegador.
Para solucionar estos problemas de interacción del lenguaje con los navega-
dores, nacieron bibliotecas cuyo objetivo es conseguir una API (application
programming￿interface) común a los diferentes navegadores.
De este modo, en este capítulo expondremos lo que, a nuestro entender, son
las principales bibliotecas que existen en el trabajo de Javascript en el desarro-
llo de aplicaciones web. Pero antes haremos una primera especificación de las
tareas que necesitamos para desarrollar aplicaciones web en el cliente, para así
poder evaluar y ver cómo tratan esto las diferentes bibliotecas.
3.2. ¿Qué nos ha de ofrecer una biblioteca Javascript?
Fundamentalmente una solución a los dos retos básicos que afrontamos cuan-
do desarrollamos aplicaciones web:

-- 26 of 86 --

CC-BY-SA • PID_00176160 27 CSS3 y Javascript avanzado
• Interactuar con el DOM. Seleccionar, añadir, modificar y borrar no-
dos. Seleccionar conjuntos de nodos y aplicarles estilos CSS. Gene-
rar nuevo contenido.
• Interactuar con el usuario mediante el sistema de eventos: capturar
acciones de ratón, de teclado y procesarlas correspondientemente.
Además, también nos debería ofrecer un sistema unificado de comunicación
con el servidor de manera asincrónica (AJAX), un sistema para poder trabajar
con formularios de datos (un modo de interacción con el DOM) y una especi-
ficación de componentes de software de tipo widget que nos permitan expan-
dir las funcionalidades propias del navegador.
Pero una biblioteca usualmente también ofrece un conjunto de convenciones
a la hora de desarrollar software, esto es, una manera de hacer, una filosofía
de trabajo.
Así, podemos afirmar que una biblioteca para Javascript nos debe permitir
desarrollar nuestras aplicaciones web, de tal manera que no nos debamos preo-
cupar por las diferencias e incompatibilidades entre navegadores.
3.3. ¿Qué bibliotecas estudiaremos?
Actualmente existen multitud de bibliotecas para Javascript, pero aquí nos in-
teresa estudiar sólo las más importantes. Así, buena parte del trabajo lo reali-
zaremos con uno de las más extendidas, el jQuery, creado por John Resig. Se
estima que tres de cada cuatro websites que utilizan una biblioteca javascript la
usan, y la utilizan también empresas como Amazon, Microsoft, BBC o Twitter.
Seguramente también es la más fácil de utilizar. Con ella aprenderemos cómo
manipular el DOM, cómo trabajar con eventos, cómo generar peticiones al
servidor no-sincrónicas y cómo utilizar su capa de componentes (jquery-ui).
Estudiaremos el prototype, que fue una de las primeras bibliotecas utilizadas
y de la que se sirven gente como la propia Apple. También veremos, de paso,
la biblioteca YUI (escrita para Yahoo) y la Motools.
De todas ellas veremos los dos pilares básicos: la interacción con el DOM y el
sistema de eventos.

-- 27 of 86 --

CC-BY-SA • PID_00176160 28 CSS3 y Javascript avanzado
4. jQuery
4.1. Obtener jQuery
Podemos descargar jQuery de su web: www.jquery.com, pero también la pode-
mos utilizar directamente desde los CDN￿(content￿delivery￿network) de Goo-
gle. Si accedemos a su web, vemos que disponemos de dos versiones diferentes
(production,￿minified￿and￿gziped), versión preparada para entornos de pro-
ducción con el código comprimido y optimizado para ocupar muy pocos Kb
de descarga, o la versión de desarrollo. Sólo descargaremos esta última si lo
que queremos es revisar y leer el código de la propia librería. Podéis ver cómo
está hecha, puesto que la versión de producción es completamente utilizable.
Por otro lado, si queremos podemos utilizarla desde un CDN. Esta manera es
recomendada por la comunidad. Un CDN es una red de distribución de con-
tenidos a nivel 
