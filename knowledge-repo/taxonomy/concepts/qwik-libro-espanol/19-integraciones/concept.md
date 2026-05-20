# Integraciones

## Fuente
Qwik Framework - Libro en Español (Cap. 19)

## Contenido
# Integraciones

> Fuente: [https://qwik-book-spanish.netlify.app/19-integrations](https://qwik-book-spanish.netlify.app/19-integrations)

Claves para aprender a trabajar con las integraciones de librerías proporcionadas por Qwik con varias funcionalidades y servicios útiles, como la integración que nos permite trabajar con componentes React en Qwik que veremos en el capítuloIntegraciones: Trabajando con Componentes React.

En este capítulo vamos a ver una funcionalidad super interesante que nos ofrece Qwik con opciones para facilitar la conexión con sus herramientas y servicios.

A continuación os proporciono los puntos que vamos a ver en este capítulo.

Estos pasos los vamos a completar hasta conseguir integrar nuestra propuesta de integración y lo haremos paso a paso, al detalle.

¿Qué es una integración?

Modo de usar las integraciones.

Agregar una nueva integración: Leaflet Map.

Agregar mapas con Leaflet como integración.

Crear Pull Request (PR) para integrarlo al framework.

Conclusión.

A partir de un proyecto creado con Qwik City ejecutando un comando que nos proporcionan desde el equipo de Qwik, vamos a disponer una lista extensa de opciones que nos va a permitir integrar aplicaciones de una manera sencilla dándonos la opción de poder usarlas en unos pocos pasos.

Si no usásemos una de las opciones que nos proporciona esta funcionalidad, podríamos implementar esas opciones aunque tendríamos que ir dando los pasos de manera manual y seguramente con más probabilidades de fallar en algún paso, haciendo que su funcionamiento no fuese el adecuado.

El comando a ejecutar para poner en marcha la integración de estas funcionalidades y servicios es:

Nos pedirán que seleccionemos la integración que deseamos agregar.

Una vez que seleccionamos una integración, se va a agregar a nuestra aplicación y podremos empezar a usarla.

Prestad atención a la información que nos vayan proporcionando, que muchas veces nos ceñimos a dar aSiguiente,Si, etc. sin fijarnos en lo que hacemos y luego nos llevamos sorpresas poco agradables.

Actualmente (febrero del 2024), esta es la lista de posibles integraciones que nos proporcionan:

Podéis encontrar la lista de todas las integraciones oficiales de Qwik en el siguiente enlace:https://shorten-up.vercel.app/-IllWy0Lac

En esta lista vemos la opción deVitest, que podríamos haber podido usar en el capítulo anterior si hubieramos conocido esta opción y como se ha podido ver, se ha hecho todo a mano.

Os animo a que probéis a configurar el apartado de test mediante la integración deVitestcon el comando principal y seleccionandoVitest.

Existe la posibilidad de contribuir aportando nuevas integraciones tanto en el lado servidor como librerías.

Para poder realizar el proceso para los dos casos, tenéis disponibles la siguiente información:

En este caso, vamos a aportar lo siguiente ya que es una funcionalidad de mapas que no se ha aplicado en Qwik (actualmente ya está implementada:https://shorten-up.vercel.app/zxKLPGChPs).

Os voy a enseñar los pasos para integrar una nueva funcionalidad en este listado paso a paso.

Podríais integrar algunos de estos ejemplos:

Solo tendríais que seguir el mismo proceso que voy a hacer a continuación en este apartado. Si tenéis sugerencias de mejoras, podéis realizarlas.

Empezamos con el proceso y lo primero que necesitamos es hacer unforkdel repositorio oficial de Qwik.

Necesitaréis tener una cuenta de Githuby debéis de hacer unforkdel contenido de este repositorio, para haceros una copia local en vuestra cuenta.

¿No tenéis cuenta de Github? Debéis de crearla mediante estas instrucciones ya queeste requisito es indispensable:https://shorten-up.vercel.app/aXvVUUcUCO

Teniendo la cuenta, debemos de hacer una copia (mediantefork) del repositorio base para tener una copia como de nuestra propiedad, basándose en la base de la propuesta.

Accedemos al repositorio oficial de Qwik mediante el siguiente enlace:

https://shorten-up.vercel.app/Ig3CktZmP_

Para hacer un fork del repositorio, pulsamos enForken la parte superior derecha:

Y tenemos en cuenta los siguiente puntos:

Nombre de usuario / organizaciónque vamos a usar para alojar el proyecto, en mi caso con el usuarioqwik-book.

Nombre del repositorio. Yo no lo cambiaría, aunque si queréis poner otro nombre, adelante. Procurad que sea descriptivo.

Descripcióndel repositorio.

Para copiar solo la ramamain, no hace falta más.

Crear el fork para copiar el código del repositorio original.

Mientras se crea la copia se mostrará un estado similar al siguiente dando el feedback de que está en ello:

Y así estará el repositorio en nuestra cuenta (en mi caso enqwik-book) una vez realizada la copia mediante elfork:

Ya tenemos el proyecto, ahora ya iniciamos el proyecto en nuestro equipo clonándolo para trabajar en local.

Una vez clonado, abrimos el proyecto y ya empezamos con las instalaciones y configuraciones a realizar.

Creamos una nueva rama por ejemplo paraleaflet-mapcon el nombre de la ramafe
