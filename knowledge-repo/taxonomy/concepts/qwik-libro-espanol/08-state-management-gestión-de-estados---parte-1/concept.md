# State Management: Gestión de estados - Parte 1

## Fuente
Qwik Framework - Libro en Español (Cap. 8)

## Contenido
# State Management: Gestión de estados - Parte 1

> Fuente: [https://qwik-book-spanish.netlify.app/08-state-management](https://qwik-book-spanish.netlify.app/08-state-management)

La gestión del Estado (State) es una de las partes más importantes de cualquier aplicación Frontend, sea en Qwik o en tecnologías como Angular, React, etc.

Con esto estaremos controlando el flujo de información en tiempo real dentro de nuestra aplicación de manera global, de manera aislada en un componente o mediante la comunicación de ese flujo de información entre diferentes componentes mediante el uso depropsconcepto visto anteriormente en elcapítulo 3 sobre componentesu otras formas que iremos viendo en este capítulo.

En este capítulo comenzaremos dando los primeros pasos con las claves para entender como funciona el control de estados y realizaremos casos prácticos para afianzar los conocimientos teóricos.

Esto es lo que vamos a ver en este capítulo:

En Qwik, nos vamos a encontrar con dos tipos de estado:

Es importante mencionar que el estado en Qwik no tiene que ser necesariamente el estado a nivel de componente local, sino que podría ser el estado de la aplicación instanciado por cualquier componente.

Una vez realizada la introducción, empezamos a trabajar con las diferentes formas de controlar el estado y empezaremos desde el hookuseSignal().

Antes de empezar a trabajar nuestro proyecto, dejamos de lado el proyecto anterior llamado07-ssry creamos uno nuevo, siguiendo los pasos expuestos anteriormente. Como sugerencia os animo a que lo llaméis08-state-management-i.

Es un hook que creaunaseñal reactiva medianteconst signal = useSignal(initialState), que obtiene un valor inicial (coninitialState) y nos devuelve como resultado una señal reactiva dándonos como resultado un valor que usaremos en la aplicación.

Esto lo usaremos generalmente con valores simples sin mucha complejidad como valores primitivos como strings, enteros,…

Para trabajar con elementos como objetos, es recomendable usar el hookuseStore(), que lo veremos más a fondo en breves.

La señal reactiva devuelta poruseSignal()consiste en un objeto con una sola propiedad (llamadasignal.value). Si cambia la propiedad value del objeto, se actualizará cualquier componente que dependa de él.

Aquí tenéis la referencia oficial deuseSignaly accedemos desde el siguiente enlace:https://shorten-up.vercel.app/L9s2630IVP.

Para implementarlo dentro de un componente, debemos de realizar lo siguiente:

Por ejemplo, si iniciosignalValuede la siguiente forma:

En este momento el valor designalValue.valueserá19191. Si cambia la propiedad value del objeto, se actualizará cualquier componente que dependa de él, pudiendo visualizarlo haciendo simplemente referencia asignalValue.value

Este ejemplo se muestra cómo se puede usaruseSignal()en un componente que mostrará el valor aleatorio siempre que pulsemos el botón con valores comprendidos entre 0 y 1.

Esto es lo que se consigue con el código que acabamos de implementar:

El simple hecho de acceder a la propiedadrandomValue.valuehará que el componente se actualice si cambia el valor de la señal por la reactividad que compone este hook.

En este caso particular se efectúa el cambia en el momento que ejecutamos la acción declicken el botón con la etiquetaObtener aleatorio.

Una vez visto esto, pasamos al siguiente elemento para poder trabajar con la gestión del estado y lo que vamos a usar es el hookuseStore().

Funciona de forma muy similar auseSignal(), pero toma un objeto como su valor inicial.

En la práctica,useSignalyuseStoreson muy similares. Este sería el equivalente de los dos:

Es preferible el uso deuseSignalpara la mayoría de las veces.

Algunos casos de uso parauseStoreson:

Para crearlo, lo iniciamos conconst store = useStore(initialState)que es un hook que crea un objeto reactivo, tomando ese objeto inicial y devolviendo un objeto reactivo.

El objeto reactivo devuelto poruseStore()es como cualquier otro objeto, pero es reactivo. Si cambia alguna propiedad del objeto, se actualizará cualquier componente que dependa de esa propiedad.

Aquí tenéis la referencia oficial deuseStorey accedemos desde el siguiente enlace:https://shorten-up.vercel.app/USxY7lllpo.

Este ejemplo muestra cómo se puede usar el hookuseStore()en un componente de contador para realizar un seguimiento del recuento que irá incrementando con la acción declickdel botón asignado a la acción del recuento.

Creamos un componente y añadimos el siguiente código:

Esto es lo que tenemos al principio:

El simple hecho de acceder a la propiedadcounterState.counthará que el componente se vaya actualizando a medida que hagamosclick en +1. Se verá de la siguiente forma, donde ya se han hecho varios clicks en el botón+1(exactamente 5).

Seguramente os lo habéis preguntado, ¿Y si no usamos el hookuseStorey añadimos el valor del contador de la siguiente maneraconst counterState = {count: 0}?¿Qué pasaría? ¿Actualizaría?

La respuesta esNO, ya que al no usar el hook
