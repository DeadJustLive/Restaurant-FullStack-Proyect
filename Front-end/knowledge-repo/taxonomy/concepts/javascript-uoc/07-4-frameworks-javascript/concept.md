# 4. Frameworks JavaScript

## Fuente
javascript-uoc (Cap. 7)

## Contenido
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
ción del SEO de la aplicación, algo que en la versión anterior resultaba má
