# Tasks / Lifecycles - Tareas / Ciclos de vida

## Fuente
Qwik Framework - Libro en Español (Cap. 12)

## Contenido
# Tasks / Lifecycles - Tareas / Ciclos de vida

> Fuente: [https://qwik-book-spanish.netlify.app/12-lifecycles](https://qwik-book-spanish.netlify.app/12-lifecycles)

Comenzamos con un nuevo capítulo en el que vamos a ver un concepto super importante y que bajo mi punto de vista es esencial para subir de nivel en cualquier tecnología como en este caso en Qwik Framework.

Aunque en este caso hablé para Qwik, también sería necesario entender en tecnologías como Angular, React, Vue,… en cada una de ellas con sus características pero como base, al final serían lo mismo.

Me encargaré que en este capítulo podáis entender correctamente el funcionamiento de las tareas y el ciclo de vida en proyectos Qwik para poder realizar aplicaciones eficientes y más rápidas mediante todos los detalles y claves importantes.

Si entendemos el comportamiento del ciclo de vida de los componentes, ya tenemos un gran recorrido completado en lo que se refiere al aprendizaje de esa tecnología que estamos aprendiendo, que en este caso es Qwik.

Por esa razón, os animo a que leáis bien todo el capítulo, al detalle y que practiquéis sobre todo, algo fundamental para mejorar y asimilar los conceptos que se vayan a aprender aquí.

En este capítulo se tratarán los siguientes aspectos.

¿Qué es un ciclo de vida? ¿Qué nos aporta?

Las tareas que se ejecutan dentro de Qwik.

Ciclos de vida en Qwik. Introducción.

useVisibleTask$()

Los ciclos de vida de un componente son un tema fundamental en el diseño y la ingeniería de productos.

Estos ciclos describen las diferentes etapas que atraviesa un componente desde su concepción hasta su retiro y desecho.

Comprender estos ciclos es esencial, ya que nos van a aportar la garantía de calidad y la confiabilidad de los productos, así como nos ayudarán a maximizar su vida útil y reducir su impacto ambiental, liberando recursos que ya no se utilizarán.

En este sentido, en este capítulo vamos a explorar los diferentes aspectos relacionados con los ciclos de vida de los componentes, desde su diseño y desarrollo hasta su mantenimiento, reparación y eliminación.

Para poder abordar el tema de los elementos que usaremos para gestionar el ciclo de vida de una aplicación de Qwik, es importante entender como funciona la parte de tareas en este framework.

En Qwik, las tareas están diseñadas para ejecutar operaciones asíncronas como parte de la inicialización del componente o del cambio de estado del componente.

Para los que vienen de React y tienen conocimientos sobre los hooks, podemos decir que estas tareas son similares a useEffect() en React, pero al haber suficientes diferencias no sería correcto llamarlos de la misma forma. Las principales diferencias son:

useTask$()debería ser siempre nuestra primera opción para ejecutar trabajos asíncronos (o sincrónicos) como parte de la inicialización o del cambio de estado del componente.

Habrá casos en los que no se puede lograr lo que se necesita conuseTask$(), y ahí es donde se debe considerar el uso deuseVisibleTask$()ouseResource$()dependiendo de la necesidad del momento.

A continuación os dejo disponible los enlaces a la documentación oficial de Qwik de estos aspectos:

Recordad que esta información os la proporciono de apoyo para que podáis profundizar por vuestra parte

El caso de uso básico parauseTask$()es realizar un trabajo en la inicialización del componente, nada más.

useTask$()tiene estas principales propiedades que debemos de tener en cuenta:

Puede ejecutarse en el servidor o en el navegador.

Se ejecuta antes de la renderización y bloquea la renderización.

Si se están ejecutando varias tareas, se ejecutan secuencialmente en el orden en el que se registraron. Una tarea asíncrona bloqueará la siguiente tarea hasta que se complete.

Las tareas también se pueden utilizar para realizar el trabajo para las situaciones que se da un cambio en el estado del componente.

En este caso, la tarea se volverá a ejecutar cada vez que cambie el estado rastreado mediante el uso de la funcióntrack(), que la veremos con más detalle dentro de este capítulo, ya que es un elemento muy muy muy (si hago hincapié al muy, no es un error) importante que va a ser protagonista de nuestros proyectos de Qwik desde proyectos básicos a más avanzados.

Un buen ejemplo es cuando una tarea solo necesita ejecutarse en el navegador y después de la renderización, en ese caso, se debe utilizaruseVisibleTask$().

Este punto lo veremos con más detalle a lo largo del capítulo que será como mostrar algo visual como un Mapa con la librería de Leaflet que no actúará de ninguna manera en el servidor, solo en el navegador:

Podéis ver un artículo que escribí acerca de esto último:https://shorten-up.vercel.app/9KgLXRE4T0

Hay que tener en cuenta que debemos de sustituiruseBrowserVisibleTask$por el actualuseVisibleTask$.

El ejemplo que usaremos en el capítulo para explicar este caso, será el de renderizar la hora actual con un reloj. Lo veremos hacia el final, paso a paso.

También hay casos 
