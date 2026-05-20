# Leanpub: Publish Early, Publish Often

## Fuente
Desarrollo de Apps Web con React.js y Redux.js (Cap. 14)

## Contenido
# Leanpub: Publish Early, Publish Often

> Fuente: [https://leanpub.com/read/react-redux/leanpub-auto-estado-inmutable-con-redux-e-immutablejs](https://leanpub.com/read/react-redux/leanpub-auto-estado-inmutable-con-redux-e-immutablejs)

Este es un glosario de los términos principales en Redux, junto a su tipo de dato. Los tipos están documentados usando la notación Flow.

Estado (también llamado árbol de estado) es un termino general, pero en la API de Redux normalmente se refiere al valor de estado único que es manejado por el Store y devuelto porgetState(). Representa el estado de tu aplicación de Redux, normalmente es un objeto con muchas anidaciones.

Por convención, el estado a nivel superior es un objeto o algún tipo de colección llave-valor como unMap, pero técnicamente puede ser de cualquier tipo. Aun así, debes hacer tu mejor esfuerzo en mantener el estado serializable. No pongas nada dentro que no puedas fácilmente convertirlo a un JSON.

Una acción es un objeto plano (POJO — Plan Old JavaScript Object) que representa una intención de modificar el estado. Las acciones son la única forma en que los datos llegan al store. Cualquier dato, ya sean eventos de UI, callbacks de red, u otros recursos como WebSockets eventualmente van a ser despachados como acciones.

Las acciones deben tener un campo type que indica el tipo de acción a realizar. Los tipos pueden ser definidos como constantes e importados desde otro módulo Es mejor usar strings como tipos en vez deSymbolsya que los strings son serializables.

Aparte del type, la estructura de una acción depende de vos. Si estás interesado, revisaFlux Standard Actionpara recomendaciones de como deberías estar estructurado una acción.

Revisa acción asíncrona debajo.

Unreducer(también llamadofunción reductora) es una función que acepta una acumulación y un valor y devuelve una nueva acumulación. Son usados para reducir una colección de valores a un único valor.

Los reducers no son únicos de Redux — son un concepto principal de la programación funcional. Incluso muchos lenguajes no funcionales, como JavaScript, tienen una API para reducción. En JavaScript, esArray.prototype.reduce().

En Redux, el valor acumulado es el árbol de estado, y los valores que están siendo acumulados son acciones. Los reducers calculan el nuevo estado en base al anterior estado y la acción. Deben serfunciones puras— funciones que devuelven el mismo valor dados los mismos argumentos. Deben estar libres de efectos secundarios. Esto es lo que permite características increíbles como hot reloading y time travel.

Los reducers son el concepto más importante en Redux.

No hagas peticiones a APIs en los reducers.

Lafunción despachadora(o simplementefunción dispatch) es una función que acepta una acción o una acción asíncrona; entonces puede o no despachar una o más acciones al store.

Debemos distinguir entre una función despachadora en general y la función basedispatchprovista por la instancia del store sin ningún middleware.

La función basedispatchsiempre envía síncronamente acciones al reducer del store, junto al estado anterior devuelto por el store, para calcular el nuevo estado. Espera que las acciones sean objetos planos listos para ser consumidos por el reducer.

Los middlewares envuelven la funcióndispatchbase. Le permiten a la funcióndispatchmanejar acciones asíncronas además de las acciones. Un middleware puede transformar, retrasar, ignorar o interpretar de cualquier forma una acción o acción asíncrona antes de pasarla al siguiente middleware. Lea más abajo para más información.

Un creador de acciones es, simplemente, una función que devuelve una acción. No confunda los dos términos — otra vez, una acción es un pedazo de información, y los creadores de acciones son fabricas que crean esas acciones.

Llamar un creador de acciones solo produce una acción, no la despacha. Necesitas llama al métododispatchdel store para causar una modificación. Algunas veces decimoscreador de acciones conectado, esto es una función que ejecuta un creador de acciones e inmediatamente despacha el resultado a una instancia del store específica.

Si un creador de acciones necesita leer el estado actual, hacer una llamada al API, o causar un efecto secundario, como una transición de rutas, debe retornas una acción asíncrona en vez de una acción.

Una acción asíncrona es un valor que es enviado a una función despachadora, pero todavía no esta listo para ser consumido por el reducer. Debe ser transformada por un middleware en una acción (o una serie de acciones) antes de ser enviada a la función dispatch() base. Las acciones asíncronas pueden ser de diferentes tipos, dependiendo del middleware que uses. Normalmente son primitivos asíncronos como una promesa o un thunk, que no son enviados inmediatamente a un reducer, pero despachan una acción cuando una operación se completa.

Un middleware es una función de orden superior que toma una función despachadora y devuelve una nueva función despachadora. A 
