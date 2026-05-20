# Deploy: Publicar aplicaciones

## Fuente
Qwik Framework - Libro en Español (Cap. 21)

## Contenido
# Deploy: Publicar aplicaciones

> Fuente: [https://qwik-book-spanish.netlify.app/21-deploy](https://qwik-book-spanish.netlify.app/21-deploy)

Comenzamos con un nuevo capítulo donde vamos a empezar a trabajar con el apartado de desplegar nuestros proyectos en Internet.

El objetivo principal será aprender a desplegar proyectos Qwik en diferentes servicios disponibles y esto lo haremos con recursos GRATUITOS.

Con este proceso finalizaremos el proceso que hemos iniciado desde elcapítulo inicial, donde hemos visto losprimeros pasos de Qwik

A continuación os proporciono los puntos que vamos a ver en este capítulo.

Estos pasos los vamos a completar hasta publicar un proyecto Qwik con Netlify.

El despliegue es un paso crucial y emocionante que marca el momento en que nuestras creaciones cobran vida en la web.

Es el momento en el que nuestros esfuerzos desarrollando un proyecto se convierte en realidad y su alcance será mayor que si lo mantenemos en local, estando límitado a una minoría y este no es el objetivo de desarrollar proyectos, ya que nos gusta que otras personas (cuantas más mejor) de manera global tengan acceso a ese proyecto en el que hemos dedicado mucho esfuerzo y disfruten de ello.

A lo largo de este capítulo, descubriremos cómo llevar a cabo el despliegue de nuestras aplicaciones Qwik de manera efectiva, asegurando que nuestros proyectos funcionen a la perfección para nuestros usuarios finales.

Netlify, una de las opciones más populares en cuanto a plataformas de alojamiento, será nuestra selección en este proceso de aprendizaje, permitiéndonos compartir nuestras creaciones con el mundo en cuestión de minutos y de manera GRATUITA.

Una vez todo claro, vamos a comenzar con el proceso a hasta su publicación.

El proyecto que os propongo publicar se encuentra en el siguiente repositorio:

https://github.com/qwik-book/qwik-quiz-app-game

El resultado lo encontraréis a continuación:

https://qwik-book-quizz-app.netlify.app/

Tendremos que hacer una copia local de dicho repositorio para efectuar los pasos del siguiente apartado, agilizando el proceso, sin tener que crear nada desde 0.

Todo se explica paso a paso en los siguientes detalles:

Fork del repositorio.

Asumo que ya tenemos elproyecto preparadodespués de hacer unforkdel repositorio propuesto como base para usarlo en este apartado del deploy.

Cuando llega el momento de implementar nuestra aplicación para desplegarlo enNetlify, Qwik viene con una integración de opciones en una lista (como hemos visto en el capítulo deIntegraciones) que nos permitirá efectuar el proceso de configuración más fácil para las diferentes opciones que vienen integradas.

Ejecutando el siguiente comando:

Obtenemos la lista de opciones que tenemos disponibles para hacer el proceso de despliegue de nuestras aplicaciones:

En la imagen se puede observar que encontramos la opción deNetlifyentre otras muchas opciones comoVercel,GCP,Deno, etc.

Nos centramos en el despliegue conNetlify.

Iremos completando los pasos uno a uno desde 0. Asumo que ya habéis realizado el paso de obtener la copia local del repositorio base en Github.

Una vez que ya tenemos el proyecto disponible aprenderemos a instalar y configurar el adaptador deNetlifyen el proyecto.

Ahora que ya tenemos el proyecto preparado, lo que debemos de hacer es añadir las instalaciones y configuraciones, que necesitamos para poder hacer la integración del adaptador necesario para poder usar nuestro proyecto enNetlify.

Los pasos que vamos a dar van a estar relacionados con la documentación oficial en el siguiente enlace:https://shorten-up.vercel.app/DmR6KtHTy4

Lo primero que vamos a realizar es la instalación del adaptador mediante el siguiente comando de integración:

Se nos abre en la consola un resumen de los ficheros que se van a modificar, cuales se van a crear y que dependencias se van a instalar(1).

Cuando estemos listos, decimos quesi, que queremos realizar la actualización medianteYes looks good, finish update!2

Aquí estará en proceso…

Y cuando termine, obtenemos este resultado:

En el proceso ejecutado, se han instalado las dependencias necesarias para esta funcionalidad, incluyendo el CLI de Netlify (Más información:https://shorten-up.vercel.app/G2oKXdIGkx).

Los cambios que se realizan son los que se han especificado en el primer paso de la instalación del adaptador, concretamente:

package.json

Las versiones con el tiempo pueden ir variando.

Actualmente usando Qwik1.4.2esas son las versiones. Si por algún casual tenéis problemas, analizad y añadir las versiones compatibles.

Comprobad que se han creado y se han modificado los ficheros que se ven en esa lista.

Asumiendo que todo ha ido OK, seguimos.

Para poder ejecutar el último paso necesitamos una cuenta de Netlify, que se crea de manera gratuita y lo podéis hacer desde el siguiente enlace:

https://shorten-up.vercel.app/ukZEopkEE8

Es un proceso sencillo, lo efectuáis y entráis con vuestros credenciales, y si es la primera vez, os harán
