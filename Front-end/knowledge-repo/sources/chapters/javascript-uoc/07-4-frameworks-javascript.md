# 4. Frameworks JavaScript

JavaScript es el lenguaje de programación utilizado en el desarrollo de aplica-
ciones web por el lado del cliente. Recordando brevemente su historia, JavaS-
cript nace en 1995 gracias a Netscape Corporation, que lo incorpora como
lenguaje de script en su primera versión de navegador. Paralelamente, Micro-
soft inicia el desarrollo de Internet Explorer y copia el lenguaje de Netscape,
le cambia el nombre y lo denomina JScript. Realmente los dos lenguajes son
muy parecidos pero con matices.
Desde el principio se generan diferencias en el uso, con la forma como se in-
teractúa con el DOM (document object model), el sistema de eventos y otras
muchas pequeñas peculiaridades que los hacen diferentes. Es un lenguaje si-
milar pero que tiene que interactuar con modelos de clases diferentes y utiliza
sistemas de eventos distintos.
Al principio la programación de cliente era terriblemente difícil puesto que
había que trabajar con cada una de las especificaciones para los diferentes na-
vegadores y esto hacía que el código que se generaba fuera poco robusto y
mantenible. Era habitual desarrollar pequeñas funciones con dos condiciona-
les para cada especificación de navegador.
Para solucionar estos problemas de interacción del lenguaje con los navega-
dores nacieron frameworks con el objetivo de conseguir una API (application
programming interface) común en los diferentes navegadores. Técnicamente un
framework es:
Una estructura conceptual y tecnológica de asistencia definida, normal-
mente con artefactos o módulos de software concreto, a partir de la cual
otros proyectos de software pueden ser organizados y desarrollados. Wi-
kipedia
De este modo, en este capítulo expondremos los que, a nuestro entender, son
los principales frameworks existentes en el trabajo de JavaScript en el desarro-
llo de aplicaciones web.
4.1. Angular
AngularJS es un framework JavaScript de desarrollo de aplicaciones web en el
lado cliente, creado por el equipo de Google. En el año 2015 anunciaron, en
la conferencia «ng-conf 2015», que estaban trabajando en una nueva versión
de Angular radicalmente diferente, escrita desde cero, y que no sería compa-

-- 36 of 48 --

CC-BY-NC-ND • PID_00254185 37 JavaScript
tible con versiones anteriores. Naturalmente, esto provocó el desconcierto y
la indignación de muchos desarrolladores, que temían por el mantenimiento
futuro de las aplicaciones que habían desarrollado en la primera versión de
este framework.
A AngularJS se le denomina a menudo Angular 1, a pesar de que a partir de
la versión 2 pasó a denominarse simplemente Angular. Por un lado se dejó
de utilizar «JS» porque pasó a estar escrito mayoritariamente en TypeScript
en lugar de en JavaScript, y por otro lado pasaron a utilizar la nomenclatura
SEMVER (semantic versioning).
¿Qué es el semantic versioning?
El sistema SEMVER es un conjunto de reglas para proporcionar un significado claro y
definido a las versiones de un proyecto de software. Este se compone de tres números
siguiendo la estructura XYZ, donde:
• X (Major): indica cambios rupturistas
• Y (Minor): indica cambios compatibles con la versión anterior
• Z (Patch): indica resoluciones de bugs (compatibles)
Básicamente, cuando se arregla un bug se incrementa el patch, cuando se introduce una
mejora se incrementa el minor y cuando se introducen cambios que no son compatibles
con la versión anterior, se incrementa el major.
Así pues, si sale una actualización donde el mayor se ha incrementado, sabréis que ten-
dréis que ensuciaros las manos con el código para pasar el proyecto a la nueva versión.
4.1.1. Características de Angular
1)￿Multiplataforma
• Aplicaciones￿web￿progresivas: Permiten utilizar las capacidades moder-
nas de las aplicaciones sobre plataforma web para ofrecer experiencias si-
milares en aplicaciones de escritorio. Estas permiten una instalación rápi-
da, en pocos pasos y sin necesitar una conexión a internet.
• Aplicaciones￿nativas: Podemos escribir aplicaciones móviles nativas com-
binando Angular con Ionic Framework, NativeScript y React Native, entre
otras.
• Escritorio: También permite crear aplicaciones instalables para escritorios
de Mac, Windows y Linux utilizando los mismos métodos de Angular em-
pleados para desarrollar sobre plataformas web. Por otro lado, también po-
see la capacidad de acceder a las API nativas del sistema operativo.
2)￿Rendimiento

-- 37 of 48 --

CC-BY-NC-ND • PID_00254185 38 JavaScript
• Generación￿ de￿ código: Angular convierte nuestras plantillas en código
altamente optimizado para las máquinas virtuales de JavaScript de hoy
en día, ofreciéndonos todas las ventajas del código escrito a mano con la
productividad de un framework.
• Universal: Ejecuta la primera vista de tu aplicación en NODE.JS, .NET,
PHP, y otros servidores para su renderizado de forma casi instantánea ob-
teniendo solo HTML y CSS. También abre posibilidades para la optimiza-
ción del SEO de la aplicación, algo que en la versión anterior resultaba más
problemático.
• División￿del￿código: Las aplicaciones de Angular se cargan rápidamente
gracias al nuevo encaminador de componentes. Este ofrece una división
automática de códigos para que los usuarios solo carguen el código nece-
sario para procesar la vista que piden.
• Reactivo: Todas las mejoras en el diseño mejoran el rendimiento general,
pero la más crítica es la detección de cambios en la vista que antes se hacía
con un ciclo de enviado a diario que consumía muchos ciclos de CPU,
y ahora se implementa con un sistema reactivo que supone una muy im-
portante mejora de rendimiento.
3)￿Productividad
• Plantillas: Permite crear rápidamente vistas de interfaz de usuario con una
sintaxis de plantilla simple y potente.
• Angular￿CLI: Las herramientas de línea de comandos nos permitirán em-
pezar a desarrollar rápidamente, añadir componentes y realizar tests, así
como previsualizar de forma instantánea nuestra aplicación.
• IDE: Ofrece sugerencias de código inteligente, detección de errores y otras
informaciones cuando se integra en la mayoría de los editores populares
e IDE.
4)￿Historia￿completa￿del￿desarrollo
• Testing: Utiliza Karma y Jasmine para las pruebas de unidad (unit tests)
para saber si se han roto cosas cada vez que guardamos nuestros cambios.
También es posible implementar tests de aceptación de selenium con Pro-
tractor para hacer que nuestras pruebas de escenarios corran más rápido
y de manera estable.
• Animación: Permite crear animaciones complejas y de alto rendimiento
con muy poco código a través de la intuitiva API de Angular.

-- 38 of 48 --

CC-BY-NC-ND • PID_00254185 39 JavaScript
• Accesibilidad: Posee características para crear aplicaciones accesibles con
los componentes disponibles por ARIA2 (MDN web docs).
• Integración￿con￿otras￿tecnologías: Una de sus fortalezas es que se integra
a la perfección con otras tecnologías que permiten crear web componentes
como: React (Facebook), Polymer (Google) y X-Tag (Microsoft).
4.2. VueJS
Vue es un framework JavaScript creado en 2014 por Evan You (desarrollador
de Google). Lo define como un framework progresivo porque se encuentra
dividido en diferentes librerías acotadas con una responsabilidad específica,
de forma que el desarrollador incluya los diferentes módulos según las nece-
sidades del contexto en el que se encuentre. No hay que incluir toda la fun-
cionalidad desde el principio como en el caso de otros frameworks, como por
ejemplo Angular, y se evita cargar la aplicación de código innecesario.
La librería se enmarca dentro de las arquitecturas de componentes con una
gestión interna de modelos basada en el patrón MVVM (Model-View-ViewMo-
del). Esto quiere decir que los componentes, internamente, tienen mecanis-
mos de doble data-binding para manipular el estado de la aplicación.
Patrón MVVM
En este patrón de diseño se separan los datos de la aplicación, la interfaz de usuario no
controla manualmente los cambios en la vista o en los datos, sino que estos se actualizan
directamente cuando sucede un cambio en ellos, por ejemplo, si la vista se actualiza un
dato que está presentando, se actualiza el modelo automáticamente y viceversa.
Pero ¿qué define a VueJS? ¿Qué lo diferencia o lo asemeja al resto de alterna-
tivas? ¿Por qué se está poniendo tan de moda? Intentamos explicar algunas
de sus características para que vosotros mismos veáis si el framework tiene la
potencia que nos dicen:
• Proporciona￿componentes￿visuales￿de￿forma￿reactiva. Piezas de UI bien
encapsuladas que exponen una API con propiedades de entrada y emisión
de eventos. Los componentes reaccionan ante eventos masivos sin que el
rendimiento se vea perjudicado.
• Cuenta con conceptos de directivas, filtros￿y￿componentes bien diferen-
ciados.
• La￿API￿es￿pequeña￿y￿fácil￿de￿utilizar.
• Utiliza￿Virtual￿DOM. Las operaciones más costosas en JavaScript suelen
ser las que manipulan el DOM. VueJS por su naturaleza reactiva necesita
(2)ARIA, o accesible rich internet ap-
plications, define cómo realizar
contenido web y aplicaciones web
(especialmente las desarrolladas
con AJAX y JavaScript) más acce-
sibles a personas con discapacida-
des. Por ejemplo, ARIA posibilita
puntos de navegación accesibles,
widgets JavaScript, sugerencias en
formularios y mensajes de error,
actualizaciones en directo, etc.

-- 39 of 48 --

CC-BY-NC-ND • PID_00254185 40 JavaScript
hacer cambios constantemente, pero para agilizar esta tarea cuenta con
una copia virtual que se encarga de ir cambiando las partes necesarias.
• Externaliza el encaminamiento y la gestión de estado en otras librerías.
• Renderiza￿templates￿a￿pesar￿de￿soportar￿JSX. JSX es el lenguaje que usa
React para renderizar la estructura de un componente. Es una especie de
HTML + JS + extras que permite escribir plantillas HTML con más poten-
cia. VueJS apoya a JSX, pero entiende que es mejor usar plantillas puras
en HTML por su legibilidad y por la posibilidad de usar herramientas de
terceros que trabajen con estas plantillas más estándar. De este modo, el
desarrollador puede escoger el sistema que más le convenga.
• Permite focalizar CSS para un componente específico. Permite crear con-
textos específicos para los componentes sin perder potencia en cuanto a
las reglas de CSS.
• Cuenta con un sistema de efectos de transición y animación.
• Permite renderizar componentes para entornos nativos (Android e iOS).
• Sigue￿un￿flujo￿one-way￿data-binding para la comunicación entre com-
ponentes.
• Sigue￿un￿flujo￿doble-way￿data-binding para la comunicación de modelos
dentro de un componente aislado.
• Tiene￿soporte￿para￿TypeScript. Cuenta con decoradores y tipos definidos
de manera oficial y son descargados junto con la librería. +
• Tiene￿soporte￿para￿ES6.
• Tiene soporte a partir de Internet Explorer 9.
• Permite￿renderizar￿las￿vistas￿en￿servidor. Los SPA y los sistemas de ren-
derizado de componentes en JavaScript tienen el problema de que muchas
veces son difíciles de utilizar por robots como los de Google, por lo tanto,
el SEO de nuestra web o aplicación se puede ver perjudicado. VueJS per-
mite mecanismos para que los componentes puedan ser renderizados en
tiempos de servidor.
• Es￿extensible. Vue se puede extender mediante plugins.

-- 40 of 48 --

CC-BY-NC-ND • PID_00254185 41 JavaScript
4.3. React
React es una librería de JavaScript creada por Facebook, usada por ellos mismos
en el desarrollo de su red social. Está más enfocada al desarrollo de interfaces de
usuario, aunque con varios complementos puede llegar a alcanzar tanto como
Angular 2. Su característica fundamental es que las aplicaciones desarrolladas
tienen un gran rendimiento.
Dentro del contexto de Facebook, donde necesitaban herramientas para un
desarrollo rápido, y a la vez estar focalizadas a un mayor rendimiento que
otras alternativas existentes en el mercado, detectaron que el típico marco
de binding y doble binding retrasaba su aplicación debido a la cantidad de
conexiones entre las vistas y los datos. Por este motivo crearon una nueva
dinámica de funcionamiento, en la cual optimizaron la forma como las vistas
se renderizaban cuando había un cambio en los datos de la aplicación.
Veamos￿algunas￿de￿sus￿características:
• Composición￿de￿componentes: En programación funcional se pasan fun-
ciones como parámetros para resolver problemas más complejos, creando
lo que se conoce como composición funcional. En React podemos aplicar
este patrón mediante la composición de componentes, unos componen-
tes que encapsulan un comportamiento, una vista y un estado. Crearemos
componentes para resolver pequeños problemas, que para ser pequeños
son más fáciles de resolver y más adelante resultan más fáciles de visuali-
zar y comprender. Después, unos componentes se apoyarán en otros para
resolver problemas mayores y al final la aplicación será un conjunto de
componentes que trabajan entre sí. Este modelo es fácil de mantener, de
depurar, de escalar, etc.
• Desarrollo￿declarativo: Con librerías más sencillas como jQuery se realiza
un estilo de programación imperativo, es decir, se realizan scripts que paso
por paso tienen que informar sobre qué acciones se tienen que realizar en
el DOM, especificando con detalle cada uno de los cambios. La forma im-
perativa de declarar obliga a escribir mucho código, porque cada pequeño
cambio se tiene que definir en un script y cuando el cambio puede ser pro-
vocado desde muchos lugares. El estilo de React es más declarativo, en él
contamos con un estado de la aplicación, y sus componentes reaccionan
ante el cambio de este estado. Los componentes tienen una funcionalidad
dada y cuando cambia una de sus propiedades, ellos producen un cambio.
• Flujo￿de￿datos￿unidireccional: Esta es otra acción que facilita React, aun-
que no es exclusivo. En este modelo de funcionamiento, los componentes
de orden superior propagan datos a los componentes de orden inferior.
Los de orden inferior trabajarán con estos datos y cuando cambia su estado

-- 41 of 48 --

CC-BY-NC-ND • PID_00254185 42 JavaScript
podrán propagar eventos hacia los componentes de orden superior para
actualizar sus estados.
• Mejor￿rendimiento￿gracias￿al￿DOM￿virtual: El rendimiento a la hora del
renderizado de la aplicación se consigue mediante el DOM virtual. No es
que React no opere con el DOM real del navegador, pero sus operaciones
las realiza antes sobre el DOM virtual, que es mucho más rápido. El DOM
virtual está cargado en memoria y gracias a la herramienta que diferencia
entre este y el real se actualiza el DOM del navegador, permitiendo actua-
lizaciones de hasta 60 frames por segundo, y por lo tanto, producen apli-
caciones muy fluidas, con movimientos suavizados.
• Isomorfismo: Es la capacidad de ejecutar el código tanto en el cliente co-
mo en el servidor. También se conoce como «JavaScript Universal». Sirve
principalmente para solucionar problemas de posicionamiento tradicio-
nales de las aplicaciones JavaScript.
• Elementos￿y￿JSX: ReactJS no devuelve HTML. El código embebido dentro
de JavaScript parece HTML pero realmente es JSX. Son como funciones
JavaScript, pero expresadas mediante una sintaxis propia de React llama-
da JSX. Lo que produce son elementos en memoria y no elementos del
DOM tradicional, con lo cual las funciones no ocupan tiempos al producir
pesados objetos del navegador sino simplemente elementos de un DOM
virtual.
• Componentes￿con￿y￿sin￿estado: React permite crear componentes de va-
rias maneras, pero hay una diferencia entre componentes con y sin esta-
do. Los componentes stateless son los componentes que no tienen estado
(no guardan datos en su memoria). Esto no quiere decir que no puedan
recibir valores de propiedades, pero estas propiedades siempre las llevarán
en las vistas sin producir un estado dentro del componente. Estos compo-
nentes sin estado se pueden escribir con una sencilla función que devuel-
ve el JSX que el componente tiene que representar en la página. Por otro
lado, los componentes statefull son algo más complejos porque son capa-
ces de guardar un estado y mantienen lógica de negocio generalmente. Su
principal diferencia es que se escriben en el código de una manera más
compleja, generalmente por medio de una clase ES6, en la que podemos
tener atributos y métodos para realizar todo tipo de operaciones.
• Ciclo￿de￿vida￿de￿los￿componentes: React implementa un ciclo de vida
para los componentes. Son métodos que se ejecutan cuando pasan cosas
comunes con el componente, que nos permiten subscribir acciones cuan-
do se produce una inicialización, se recibe la devolución de una promesa,
etc.
• Comportamiento￿con￿otras￿librerías: A pesar de que React no se encarga
de todas las partes necesarias para hacer una aplicación web compleja, la

-- 42 of 48 --

CC-BY-NC-ND • PID_00254185 43 JavaScript
serie de componentes y herramientas basadas en React nos permiten en-
contrar una alternativa capaz de hacer cualquier cosa que podríamos hacer
con otro framework más complejo. Por otro lado, React solapa completa-
mente las funcionalidades de jQuery, por lo que resulta una evolución na-
tural para todos los sitios que usan esta librería. Podrían convivir pero no
es demasiado necesario y a la vez recargaría un poco la página, de forma
que tampoco sería muy recomendable.
4.4. Vanilla JavaScript
Realmente, Vanilla JS o Vanilla JavaScript no￿es￿ningún￿framework. Precisa-
mente se utilizan estos términos para referirse a código JavaScript sencillo que
no está extendido para ningún framework ni ninguna biblioteca adicional. Lo
hemos querido incluir en este apartado para aclarar el significado del término.
Las funciones nativas de JavaScript son realmente muy potentes, puesto que se
ejecutan a un nivel más bajo que el de cualquier librería y esto les proporciona
mayor velocidad a la hora de analizar los nodos de una web y seleccionar los
elementos de la forma correcta.
Por otro lado, las mejoras que incorporan los estándares y su adopción por