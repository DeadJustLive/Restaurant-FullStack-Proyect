# Custom Hooks

## Fuente
Qwik Framework - Libro en Español (Cap. 16)

## Contenido
# Custom Hooks

> Fuente: [https://qwik-book-spanish.netlify.app/16-custom-hooks](https://qwik-book-spanish.netlify.app/16-custom-hooks)

Comenzamos con un nuevo capítulo en el que nos vamos a sumergir en un concepto que bajo mi punto de vista es muy importante conocer y dominar.

Vamos a explorar al detalle los custom hooks en Qwik, comprendiendo su estructura, su uso y los beneficios que aportan a nuestros proyectos.

Analizaremos los aspectos a tener en cuenta para crear de manera correcta nuestros custom hooks y posteriormente entraremos a la acción creando varios ejemplos prácticos y paso a paso de diferentes custom hooks, desde los más simples hasta los más avanzados, para que podamos comprender y aplicar esta poderosa técnica en nuestras propias aplicaciones.

En resumen, los custom hooks son una herramienta valiosa que nos permite construir aplicaciones más eficientes, reutilizables y fáciles de mantener en Qwik (En React también).

Con su capacidad para encapsular y compartir la lógica común, nos brindan un enfoque elegante para mejorar la modularidad y la legibilidad de nuestro código.

Estos serán los puntos que trataremos en este capítulo, como veís hay bastantes puntos e intentaremos tocar todos los aspectos fundamentales para poder entender bien todo lo relacionado a lo que estamos viendo en el capítulo.

¿Qué son los custom hooks en Qwik?

Aspectos a tener en cuenta para crear nuestros custom hooks

Como usar un hook correctamente

Primer custom hook en Qwik: useCounter

Custom Hook: useTheme

Custom Hook: useMousePosition

Custom Hook: useGeolocation

Más ideas para crear más custom hooks.

Conclusión.

Los custom hooks en Qwik (como en React) sonun tipo de función JavaScript que simula el funcionamiento de loshooksen Qwik.

Los custom hooksen Qwik son muy útiles siempre que tengamos una lógica que se repite entre varios componentes.

En estos casos,podemos sacar esta lógica y aplicarla a un custom hook, es decir, una función que ejecute los pasos que necesitamos de manera automática. ¿Qué beneficios obtenemos de realizar esta acción?

Al no ser funciones cualquiera, los custom hooksen Qwikdeben seguir una serie de reglas para ser consideradoshooksy no funciones. A continuación, os explicaré cuáles son.

Son pocos los aspectos que hay que tener en cuenta pero son MUY IMPORTANTES. Os los dejo a continuación:

El nombredebe de empezar con la palabrause. Esto sería unaconvención, más que una regla (aunque “hay que cumplirla”)

Se inician dentro de los componentes de Qwik, que estén implementados con la llamada a la funcióncomponent$. Está es una reglaobligatoria.

Un hook puede llamar a otros hooks, sean los que vienen por defecto y los custom hooks. Detalle a tener en cuenta.

La primera regla de los custom hooksen Qwik es quesu nombre debe empezar con la palabrause.

Esta convención se crea siguiendo los hooksoriginales de Qwik.

Hasta ahora hemos trabajado con algunos de ellos en capítulos anteriores (aunque hay más que podéis encontrar en la documentación oficial) que añadiré sus referencias por los apartados que vienen a continuación:

Estado - Capítulo 8 - Parte 1:useSignalyuseStore.

Estado computado - Capítulo 9 - Parte 2:useComputed$

Estado computado - Capítulo 11 - Consumo APIs:useResource$

Tareas y Ciclos de Vida - Capítulo 12:useTask$yuseVisibleTask$

Esta regla, la del nombre que debe de empezar conusees utilizada en React, por lo que si venís a Qwik teniendo unos conocimientos sólidos de React, prácticamente este paso ya lo tenéis más que asimilado.

Se considera que esto es una regla porque la comunidad ha decidido que es más sencillo reconocer cualquier hook (por defecto o custom)cuando sigue esta convención.

Esto se estableció en React y se ha implementado también en Qwik, para que sea más fácil trabajar siguiendo las convenciones de la comunidad.

Eso si, en teoría podríamos crear un custom hook con otro nombre (sin eluse) sin que nos diese errores ni problemas,pero no es lo recomendable, por lo que vamos a procurar seguir las recomendaciones y reglas establecidas con el objetivo de aplicar las mejores prácticas.

Esta SI es una regla obligatoria, ya que si no implementamos la ejecución de un hook dentro de un componente de Qwik que realiza la llamada a la funcióncomponent$nos va a dar un error en el que básicamente nos dirá:

Esto es debido a que los métodosuse*()proporcionan hooks al estado y ciclo de vida decomponent$, es decir, los hookssolo se pueden llamar de forma síncrona dentro de la funcióncomponent$o en otro métodouse.

No es una regla, pero es algo que tenemos que tener en cuentade manera particular en los custom hooks deQwik(como en React) en el que podríamos llamar a otros hooks.

En este caso, Qwik se considera como custom hooka aquella función en la que dentro de ella llama a un hookoriginal o a otro custom hook que hemos creado.

Teniendo en cuenta estos aspectos, os muestro a continuación lo que hay que tener en cuenta para aplicar bien el uso de los hooks
