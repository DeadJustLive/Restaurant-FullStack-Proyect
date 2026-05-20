# Estilos

## Fuente
Qwik Framework - Libro en Español (Cap. 5)

## Contenido
# Estilos

> Fuente: [https://qwik-book-spanish.netlify.app/05-styles](https://qwik-book-spanish.netlify.app/05-styles)

Comenzamos un nuevo capítulo en el que vamos a trabajar de manera más profunda con los estilos en Qwik para complementarlo junto con todo lo que hemos aprendido hasta ahora.

Para poder trabajar en este capítulo es fundamental haber leído y entendido los capítulos anteriores, principalmente el correspondiente al detrabajo por componentes.

Recordad, que a medida que se va avanzando, algunos conceptos se darán por sabidos y no se detallarán.

Una vez realizada la introducción os voy a exponer los puntos que trabajaremos en este capítulo.

Probablemente hayas oído hablar (y conoces por experiencias previas) acerca de los estilos CSS. ¿Para qué sirven exactamente?

En resumen, se podría decir que servirán para personalizar el aspecto de una web y que se transforme en algo que nos entre más por los ojos cuando estamos navegando con cualquier dispositivo en una página web.

Vale, entendido, ¿entonces que tiene de especial en Qwik trabajar con estilos respecto a otras tecnologías? No es muy diferente a la hora de trabajar, pero vamos a tener en cuenta algunos aspectos para hacerlo correctamente sin liarnos mucho la cabeza y sin aplicar cambios que salgan “caros” en los tiempos de ejecución.

Os daré las claves necesarias para aplicar estilos de una manera u otra y luego ya estará en vuestras manos hacer magia con la apariencia de vuestros proyectos, que para eso tenéis mucha imaginación y arte.

Por eso, profundizaremos sobre las diferentes formas de aplicar CSS en Qwik.

¡Comencemos!

Para empezar empezar a trabajar con los aspectos teórico-prácticos en los estilos, debemos de crear un proyecto nuevo tal y como se ha explicado anteriormente y se recomienda llamar al directorio05-01-styles-globalque será el primer apartado que trabajaremos.

Muchas aplicaciones usan una hoja de estilos global para restablecer el navegador y/o definir estilos globales.

Esta es una buena práctica, pero no se recomienda usarla para diseñar nuestros componentes.

Qwik está optimizado para permitir que el navegador simplemente descargue los estilos que se necesitan para la vista actual mediante la carga perezosa ó diferida (lazy-loading).

Si usamos una hoja de estilo global, todos los estilos se descargarán en la primera carga, incluso si no son necesarios para la vista actualy eso hará que no estemos aplicando correctamente el potencial que nos proporciona Qwik con la carga diferida.

Usaremos estilos globales para trabajar con elementos comunes del core de nuestro proyecto, ya que serán apartados que si se van a usar desde la primera carga como pueden ser títulos, estructuras de listas, columnas, etc. Estos elementos serán necesarios y será correcto cargarlos desde la primera carga.

Ahora os voy a mostrar una situación, donde nos encontramos cargando estilos en línea, como este ejemplo:

Tenemos el problema que con este enfoque vamos a cargar los estilos dos veces (ó más, dependiendo si estamos aplicando un mismo estilo en diferentes componentes, donde aplicaríamos cargas innecesarias) ocurriendo lo siguiente.

¿Cómo solucionar esto?

Para solucionar este problema trabajando correctamente y sin cargas extras, necesitaremos cargar los estilos independientemente del componente más a nivel global mediante esta dos formas:

Vamos a empezar con el ficheroglobal.css, sin usaruseStyles$()y luego ya iremos desgranando las diferentes opciones poco a poco y con ejemplos, para entenderlo todo mucho mejor. ¡Paso a paso!

En el ejemplo con el que estamos trabajando, que es basado en el proyecto que se crea con el comando del CLI (Empty app) que nos proporciona el equipo de Qwik, tenemos ensrc/root.tsxlo siguiente donde se cargarán los estilos globales con el ficheroglobal.cssque se encuentra ensrc/global.css:

Cualquier cambio que hagamos en ese ficherosrc/global.cssse aplicará a cualquier ruta que usemos en nuestro proyecto ya que estaremos incoporando el contenido de estos en el componente<RouterOutlet />perteneciente a<QwikCityProvider />para la carga de las rutas visto enRouting (Enrutamiento).

Automáticamente, al cargar el ficherosrc/global.css, Qwik intentará alinear este archivo en modo de producción, si la cantidad de CSS es inferior a 10 KB. Si el archivo tiene más de 10 KB, se cargará como un archivo separado.

Para ver como se comporta el proyecto, vamos a iniciar el proyecto connpm starty esto es lo que nos debe de aparecer (UsandoEmpty App):

Ahora mismo se está cargando el contenido del ficherosrc/routes/index.tsxque contiene este código:

Analizándolo, podemos ver que tenemos dos selectores principales:

Cambiamos el contenido HTML de este componente, dejándolo de la siguiente forma:

Probamos a añadir al final del ficherosrc/global.cssuna regla en los estilos para cambiar la apariencia deh1y ver su funcionamiento.

Guardamos y podemos observar que ya ha cambiado el color del elementoh1, por lo que ya estamo
