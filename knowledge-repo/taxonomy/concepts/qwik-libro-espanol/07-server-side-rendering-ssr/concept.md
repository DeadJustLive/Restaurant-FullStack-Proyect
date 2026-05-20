# Server Side Rendering (SSR)

## Fuente
Qwik Framework - Libro en Español (Cap. 7)

## Contenido
# Server Side Rendering (SSR)

> Fuente: [https://qwik-book-spanish.netlify.app/07-ssr](https://qwik-book-spanish.netlify.app/07-ssr)

Comenzamos con un nuevo capítulo en el que vamos a hablar sobreSSRaplicado a Qwik.

Antes de empezar con el capítulo y mostraros sus caracterísiticas y como es su funcionamiento, lo ideal es saber que es exactamenteSSR.

Creamos un nuevo proyecto llamado07-ssrpara trabajar en el aspecto práctico de este capítulo.

SSR (Server-Side Rendering)es una técnica en desarrollo web donde las páginas se generan y envían el contenido inicial de carga completamente desde el servidor al navegador del usuario en la primera etapa.

Esto hará que se realice la carga de las páginas de una manera más ligera, ya que no será necesario realizar solicitudes adicionales para obtener datos o contenido.

Entre las ventajas a destacar:

No todos son ventajas, también hay algún que otro inconveniente por utilizar esta técnica:

Ahora que ya sabemos en que se basaSSRy sus características principales, seguimos relacionando este concepto dentro de Qwik.

Este será uno de los conceptos fundamentales de Qwik que se diferencia de otras tecnologías.

Mientras que muchos frameworks tienen herramientas para acceder a un modoSSRmediante configuraciones que en algunos casos son algo tediosas, Qwik ya lo trae por defecto.

El HTML vendrá proporcionado desde el servidor junto con los elementos esenciales que serán necesarios para iniciar nuestra aplicación.

Este comportamiento lo podemos ver a través de la pestaña deResponse(Herramientas de desarrollador). Por eso lo de tener tanta velocidad y performance.

Ahora para poder plasmar estos conocimientos teóricos, vamos a añadir un ejemplo muy sencillo.

En el vamos a ver las diferentes etapas del ciclo de vida (veremos más detallado en el capítulo sobrelos ciclos de vida en Qwik) y ahí es donde vamos a ver el comportamiento mediante SSR dentro de Qwik.

Creamos el proyecto con la plantilla en blanco (Empty App (QwikCity)...) con el siguiente nombre07-ssr.

Una vez que ya tenemos listo el proyecto y todas las dependencias instaladas, añadimos el siguiente código ensrc/routes/index.tsx

Podemos ver algunas novedades a través de este ejemplo, como por ejemplo el tema del eventoonClick$.

Esto lo veremos con más detalle en el capítulo deEventos. Por el momento con entender que este evento se activa cuando hacemos click en el botón, es más que suficiente.

Analizando el código encontramos lo siguiente:

Una vez que ya entendemos las partes que construyen el componente, al iniciarse, lo que sería la primera carga, aplicando mediante SSRse va a descargar lo indispensable para poder iniciar la aplicación, nada más y el resultado inicial sería que se registra el mensajeen la consola del servidor(veremos con más detalle este proceso en losciclos de vida en Qwik):

Aparte de mostrar el registro en el servidor, tendremos el HTML de la estructura y descargaremos información de la API, por si necesitamos su uso.

Abrimos lasherramienta de desarrolladorde nuestro navegador y seleccionamos la pestañaRedpara ver lo que tenemos descargado en esta primera etapa.

En este punto, nos quedamos a la espera de que hagamos cualquier acción o interacción como pulsar el botón (NO LO HAGÁIS POR EL MOMENTO), que es lo que podríamos hacer en este caso, no habría más opciones.

Si realizamos la acción de click, tenemos la opción de descargar más código como el definido dentro del eventoonClick$que consiste en un nuevo registro en la consola:

Dentro de lasherramientas de desarrollosi miramos en losElementos, podemos ver la referencia del código Javascript que se descargará cuando realicemos la acción de click (NO LO EJECUTÉIS todavía):

El path con el código Javascript que se descargará en el caso de hacer click, lo encontramos dentro del atributoon:click:

Habiendo llegado a este punto y teniendo más claros los conceptos básicos, se puede dar por concluida la primera etapa donde se ha ejecutado el renderizado por el lado del Servidor (SSR).

A partir de ahora, cualquier evento que ocurra en nuestra aplicación (si hay un registro en la consola, alguna renderización, etc.), se ejecutará todo en el lado cliente, lo que sería en el navegador junto con las descargas y acciones a realizar.

La segunda etapa comienza cuando hacemos click en el botón (¡ahora si!), disparando el eventoonClick$()que hará que muestre elmensaje en la consola del NAVEGADOR

El código se va a descargar bajo demanda (por la acción del click) en el navegador y lo que hará es mostrar el mensaje en la consola del navegador, con el siguiente mensaje:

Y se visualiza de la siguiente forma:

Al hacer click, descarga el contenido en un fichero aparte, que corresponde a la referencia anterior cuyo path era:/src/routes_component_div_button_onclick_xoh0eog14zi.js#routes...y que podemos ver en la pestañaReddentro de lasHerramientas de Desarrollo:

Si no ejecutamos esta acción, su código no se descargaráNUNCA, con lo que dejará sin mostr
