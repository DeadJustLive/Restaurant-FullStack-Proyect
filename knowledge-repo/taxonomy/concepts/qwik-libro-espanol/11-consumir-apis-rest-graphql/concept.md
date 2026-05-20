# Consumir APIs REST / GraphQL

## Fuente
Qwik Framework - Libro en Español (Cap. 11)

## Contenido
# Consumir APIs REST / GraphQL

> Fuente: [https://qwik-book-spanish.netlify.app/11-api-rest-graphql](https://qwik-book-spanish.netlify.app/11-api-rest-graphql)

El consumo de información de las APIs (habitualmente REST aunque hay opciones como GraphQL) es una de las partes más importantes de cualquier aplicación Frontend.

Los conceptos sobre esta manera de trabajar son comunes para todas las tecnologías donde trabajamos con aplicaciones Frontend.

Por lo tanto, si entendemos bien los conceptos en una tecnología, no vamos a tener muchos problemas en aplicarlo en otros frameworks, librerías,…, sea en Qwik, Javascript puro o en tecnologías como Angular, React,…

Cuando trabajamos con la acción de consumir información de APIs externas estaremos obteniendo información de los recursos que nos proporciona una web para poder realizar las acciones como leer, crear, modificar y eliminar, lo que solemos conocer como CRUD.

No todas las APIs nos dan opción de modificar la información, muchas de ellas podríamos decir que son básicas, en las que reciben los datos de consulta devolviendo un resultado acorde a esos datos enviados. Esto es lo básico de una API y sin entender esto, no podremos avanzar.

El objetivo principal es que aprendamos a hacer uso de este recurso como es consumir una API en Qwik y por esa razón, os voy a proporcionar todas las claves para entender como podemos consumir información de APIs externas mediante casos prácticos.

Lo que aprenderemos en este capítulo se engloba en estos puntos importantes.

Seguramente haya referencias donde encontremos muchas más APIs (si las tenéis compartirlas por favor), pero estas referencias son super completas y se van actualizando periódicamente.

Las voy a clasificar en dos puntos principales:

En cada una de estas referencias, podremos ver que las APIs se clasifican en categorías como Animales, Anime, Conversores de divisas,… Os invito a que veáis la referencia con calma para ver que opciones encontráis, seguramente haya algo de un tema que os interese verdaderamente y siendo así, os invito a que practiquéis con ello ajeno a lo que vamos a trabajar en este apartado, que puede que el tema usado no os apasione.

En cada una de estas referencias, podremos ver que las APIs se clasifican en categorías como APIs oficiales y APIs de solo demostración, entre otras opciones.

Como os he mencionado anteriormente, visualizar el documento con calma para ver si encontráis algo que os resulte interesante.

Una vez disponibles estos recursos, vamos a comenzar a trabajar consumiendo una API REST desde el navegador.

En este apartado realizamos los preparativos necesarios para poner en marcha la API que usaremos como fuente de datos, para consumirlo mediante REST y GraphQL.

La API que usaremos es la siguiente:

https://shorten-up.vercel.app/aSmT1qtBjC

Dentro de esta API tenemos las instrucciones para arrancar el proyecto de la API que consiste en estos 3 pasos sencillos, hasta tener la API en marcha:

Una vez que arranquemos el proyecto, se nos habilita laURL principalcon las instrucciones para acceder a los dos endpoints de la API REST y el endpoint correspondiente a la API GraphQL:

Llegados a este punto, ya tenemos la API que usaremos lista para consumir.

Pasamos al siguiente apartado donde veremos como consumir la API desde el navegador.

La API que acabamos de arrancarnos va a proporcionar información sobre los datos al detalleque corresponden a cada uno de los personajes. Tenemos las siguientes opciones:

Para acceder a esta API lo hacemos mediante este enlace:

http://localhost:3000

Si tenéis conocimientos de como se consume una API REST os animo a pasar al siguiente punto donde ya se puede vercomo consumir las APIs REST desde Qwik

Esta será el apartado de la documentación:

Donde tenemos dos endpoints correspondientes a este tipo de API:

Para ver la lista de personajes, lo que tenemos que hacer es introducir la siguiente URL:

http://localhost:3000/characters

Reflejándose en el acceso a los datos dentro de nuestro proyecto, que lo aplicaremos en el siguiente paso:

Esto sería correspondiente a lalista de todos los personajes.

Si hacemos uso de las peticiones con un personaje concreto, usaremos la siguiente estructura para obtener esa información:

Y los ids existentes, los tenemos desde el 1 hasta el 21 (incluido). Si seleccionamos 22 o algún valor que no esté en ese rango, nos dará un mensaje de aviso, de que no existe ese personaje seleccionado.

Asumo que ya tenéis el proyecto creado y disponible para trabajar con ello. El nombre asignado el proyecto (recomendado)11-apis-rest.

Comenzamos con este apartado, donde vamos a obtener la lista de personajes de Breaking Bad con la siguiente URL:

Creamos primero la función para consumir los datos de la URL que acabamos de ver y esto lo hacemos dentro de la carpetaapi(la creamos dentro desrc) en el ficherocharacters.tsañadiendo el siguiente código

En el capítulo anterior hemos trabajado con la gestión de estado, que s
