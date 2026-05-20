# Slots: Content Projection / Proyección de contenido

## Fuente
Qwik Framework - Libro en Español (Cap. 15)

## Contenido
# Slots: Content Projection / Proyección de contenido

> Fuente: [https://qwik-book-spanish.netlify.app/15-content-projection](https://qwik-book-spanish.netlify.app/15-content-projection)

Comenzamos un nuevo capítulo en el que vamos a trabajar con un concepto avanzado que es el de proyectar información de un componente a otro, y esto lo hacemos mediante el uso de los Slots que nos permiten realizar la proyección de contenido.

Aprende cómo proyectar contenido entre componentes utilizando Slots en este capítulo avanzado de Qwik. ¡Domina esta potente funcionalidad!

Para trabajar con este capítulo os recomiendo que estudiéis los contenidos de los capítulos anteriores, sobre todo de los correspondientes aComponentesyEstilos.

Una vez realizada la introducción os voy a exponer los puntos que trabajaremos en este capítulo.

Introducción a los Slots.

¿Por qué<Slot>? ¿Por qué Qwik opta por utilizar<Slot>en lugar de la propiedad children?

Primer ejemplo básico de proyección con<Slot>

Analizando el comportamiento de renderización

Named Slots

Fallback content (contenido de respaldo)

Los Slots nos van a permitir que un componente trate a los hijos JSX del componente como una forma de entrada y proyecte estos hijos en el árbol DOM del componente.

Este concepto se llama de distintas formas en estas opciones de ejemplo:

La API principal para lograr esto es el componente<Slot>, exportado en@builder.io/qwik.

Esta proyección dada con el<Slot>es una colaboración entre el componente padre y el componente hijo.

Elcomponentepadreva a decidir qué contenido va a ser renderizado, mientras que el componentehijotomará la decisión de dóndey si el contenido debe ser renderizado.

Con esta funcionalidad podemos olvidarnos de realizar el proceso de pasar información usando props, por poner un ejemplo.

El uso de<Slot>es una elección estratégica para permitir el renderizado de componentes sin un orden específico.

¿A qué se refiere con esto? Quiere decir que un componente debe de ser capaz de volver a renderizarse incluso si el componente padre aún no se ha reanudado.

UsamosSlotpor tener dos problemas con el uso dechildrenen Qwik.

Para que Qwik utilice la propiedadchildrenpara la proyección, esta debería ser serializable, al igual que los demás valores que se pasan entre componentes en Qwik.

Un componente hijo podría modificar el contenido dechildrenantes de insertarlo en el árbol de renderizado. Esto impediría que el componente padre se renderizarse de forma independiente al hijo. Si un hijo modificasechildren, tendría que hacerlo cada vez que el componente padre actualice el valor dechildren.

Para Qwik, el enfoque de<Slot>es preferible porque controla de manera declarativa el contenido y la ubicación de la proyección. Esto permitirá al componente padre que cambie el contenido de la proyección sin obligar al componente hijo a volver a renderizarse con lo que conlleva a una mejora de rendimiento considerable.

Que mejor que empezar a plasmar estos conceptos teóricos en aspectos prácticos, para que podamos ver como trabajar con<Slot>para proyectar la información deseada de padre a hijo

A continuación os añado un ejemplo, el típico ejemplo sencillo que usaremos para empezar a entender los conceptos de la proyección.

En este caso vamos a especificar desde el padre para que muestre un contenido proyectado en el hijo, que sería inicialmente el siguiente contenido:

Y para hacer posible esa proyección, debemos de añadir el elemento<Slot>dentro del componente (hijo) al que queremos proyectar esa información.

Aplicándolo en el ejemplo quedará así:

En nuestro ejemplo, el contenido del elemento<Button>(dentro del componente principal default) es el contenido que debe ser proyectado. El componente<Button>envuelve el contenido deseado y lo proyectará utilizando el elemento<Slot>.

El resultado debería de ser el siguiente:

Como se puede apreciar, lo que está a la derecha es lo que pasamos al componente<Button>desde el padre para añadirse en el elemento<Slot>y proyectarse dinámicamente.

Si aplicamos estas variantes:

Contenido 2

Contenido 3 con{'Button'}probando variantes

Otra variante

De la siguiente forma:

Este sería el resultado:

Aquí pasará lo mismo que en el primer ejemplo, pero se muestran cuatro botones con el contenido fijoLo que se proyecta:y posteriormente lo que pasamos al componente<Button>desde el padre para añadirse en el elemento<Slot>y así conseguimos que se proyecte ese contenido dinámicamente.

Después de proyectar contenido aunque sea de una forma muy básica, nos vamos a centrar más en el aspecto de su comportamiento de renderización y su eficiencia.

Veremos como se comporta la aplicación en lo que respecta a la renderización y mediante el uso de cambios que se realiza desde el componente Padre.

Cogemos el código anterior y hacemos algunas modificaciones, añadiendo con un elemento que almacenará el estado de una generación de un número aleatorio que obtenemos por cada click.

Aparte de lo anterior, cambia
