# State Management: Gestión de estados - Práctica

## Fuente
Qwik Framework - Libro en Español (Cap. 10)

## Contenido
# State Management: Gestión de estados - Práctica

> Fuente: [https://qwik-book-spanish.netlify.app/10-state-management-practice](https://qwik-book-spanish.netlify.app/10-state-management-practice)

Práctica orientada al proyecto real que estamos trabajando desde el capítulo deestilos, donde implementaremos mediante el uso de la gestión de estados el apartado de capítulos que estaba pendiente de implementarlo.

Anteriormente hemos obtenido conocimientos acerca de estos conceptos:

Estos nos van a proporcionar las herramientas necesarias para poder hacer un componente tipo accordion donde vamos a visualizar la lista de capítulos que vamos a proporcionar.

No vamos a utilizarlos todos, pero podéis experimentar con las diferentes opciones ya que se puede implementar haciendo uso de todas ellas.

Lo que aprenderemos en este capítulo se engloba en estos puntos importantes.

Esto será lo que necesitamos para poder abordar con éxito este capítulo práctico:

Una vez completado este capítulo, conseguiremos mostrar la lista de todos los capítulos con el componente<Accordion />, que mostrará todos los títulos de cada uno de los capítulos y dentro del contenido oculto, información de lo que trata cada uno de ellos.

El resultado para verlo con más detalle, lo podéis encontrar en la siguiente URL:

https://shorten-up.vercel.app/MMjKgcH_e-

En las capturas se ve la información que existe actualmente, y puede que estos capítulos o se amplie o cambien de orden.

LO MÁS IMPORTANTEaquí no será el propio contenido, si no el modo de mostrarlo y proceso que hay que llevar para dejar algo tan presentable como el accordion que se crea en este capítulo

Comenzamos con este apartado en el que vamos a introducir los datos que os he proporcionado en un fichero, como fuente de datos para poder usarlo en nuestro proyecto.

Cogemos la información de los capítulos y lo añadimos tal cual en un fichero que lo llamaremoschapters.tsintroduciéndolo ensrc/data:

Una vez que ya hemos añadido la información en el fichero mencionado, vamos al ficherosrc/routes/chapters/index.tsxy añadimos esa información dentro de unuseSignal, con el objetivo de poder controlar el estado de los desplegables, si están abiertos o no, dependiendo de lo que se especifique en la propiedadopende cada elemento.

Antes de empezar a renderizar con la estructura deseada, comprobamos que los datos se visualizan correctamente.

Implementamos estos cambios partiendo de esta base:

Dejando de la siguiente forma el código:

Guardamos los cambios y se visualizarán de esta manera:

Como se puede observar, no queda muy bonito, pero ahora lo importante es ver que funciona y como se puede ver, obtiene y renderiza esos datos, por lo que pasamos al siguiente paso donde vamos a crear el componenteAccordion.

Para poder crear nuestro componente,vamos a usar como ejemplo la estructura de la plantilla HTML (recurso mostrado al principio del capítulo)para ver como se construye con todo cerrado y abierto.

Accedemos a la página deCapítulosy esto es lo que visualizamos:

Lo que nos encontramos es una estructura principalAccordionque está compuesta por un número determinado de elementos accordion en dos estados:

Una vez que tenemos más contexto, vamos a ver como está formado en lo que se refiere a la estructura HTML.

Vamos aHerramientas del desarrolladorde nuestro navegador haciendo click (1) sobre la estructura principal donde se encuentra el elementoAccordiony seleccionamosInspeccionar:

Y dentro de estas opciones seleccionamosElements(Elementos) (1), ponemos el cursor sobre<section class="accordion-container mb-5"...(2) y en el momento que hacemos, se estará seleccionando toda la estructura del contenedor (3) donde tenemos los capítulos.

Hacemos click derecho sobre<section class="accordion-container mb-5"...y seleccionamos la opciónEdit as HTML(lo que seríaEditar como HTML):

Seleccionamos todo el contenido que se ha habilitado para editarlo y lo copiamos:

Y el contenido copiado sera lo siguiente (se añaden los dos primeros capítulos, que son las dos variantes, la primera desplegado y la segunda cerrado):

Lo implementamos en Qwik ensrc/routes/chapters/index.tsx:

Y esta será la apariencia:

Todavía nos quedan unos pequeños ajustes para que se vaya pareciendo más a la plantilla original, mostrando los estados desplegado (Capítulo 1) y cerrado (Capítulo 2) asociado al código HTML que hemos copiado.

Para realizar esto debemos añadir los estilos asociados a esa ruta, que podemos encontrar en el ficherochapters.css:

Creamossrc/routes/chapters/chapters.css, pegamos todo el contenido ahí (sin realizar ningún cambio).

Y ahora, para usarlo en la ruta, en el ficherosrc/routes/chapters/index.tsxdebemos de añadir lo siguiente:

Y una vez que guardemos los cambios, como se puede apreciar ya se aplican correctamente los estilos, mostrando el capítulo 1 desplegado por usar la claseitem-activey el capítulo 2 cerrado POR no disponer de esa clase que si está en el capítulo 1.

Llegados a este punto,
