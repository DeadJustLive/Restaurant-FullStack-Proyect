# Eventos

## Fuente
Qwik Framework - Libro en Español (Cap. 14)

## Contenido
# Eventos

> Fuente: [https://qwik-book-spanish.netlify.app/14-events](https://qwik-book-spanish.netlify.app/14-events)

Comenzamos con este nuevo episodio en el que vamos a trabajar con los eventos, que son sucesos o acciones que ocurrirán en cualquier página web.

Vamos a dar los pasos necesarios desde la base en Javascript hasta conseguir aplicar estos conceptos en Qwik, para poder usarlos en cualquier situación que requieran la participación de ellos.

En el desarrollo web, JavaScript es un lenguaje de programación que nos va a permitir crear páginas web interactivas y dinámicas.

Una parte fundamental de la programación en JavaScript van a ser los eventos, que son acciones o sucesos que ocurren en una página web y que pueden ser detectados y manejados mediante el uso de esta tecnología.

Estos eventos pueden ser provocados por el usuario, el navegador o el propio documento, y nos permitirán que la página web responda de manera activa a la interacción del usuario.

Características de los eventos en JavaScript:

Interactividad:Los eventos permiten que los usuarios interactúen con los elementos de una página web. Al hacer click en botones, enlaces, imágenes, o realizar otras acciones, se activan eventos que pueden desencadenar respuestas específicas.

Detección y Captura:JavaScript es capaz de detectar cuándo ocurre un evento en la página web. A través de métodos comoaddEventListener, podemos capturar esos eventos y definir funciones que se ejecutarán cuando ocurra el evento específico.

Respuestas Personalizadas:Cada evento puede tener una respuesta personalizada asociada. Esto significa que los desarrolladores pueden programar qué acción se llevará a cabo cuando ocurra un evento determinado. Por ejemplo, mostrar un mensaje, cambiar el contenido de la página o realizar una operación específica.

Amplia Variedad de Eventos:JavaScript ofrece una amplia colección de eventos que se pueden utilizar, desde eventos de clics y teclado hasta eventos de carga de página, cambios en formularios y mucho más.

Mejora de la Experiencia del Usuario:El uso adecuado de eventos en JavaScript permite crear una experiencia más fluida e interactiva para los usuarios, lo que mejora la usabilidad y la sensación de interacción con la página.

Asincronía:Muchos eventos ocurren de forma asíncrona, lo que significa que pueden suceder en cualquier momento mientras el usuario interactúa con la página. Esto permite que la página sea más receptiva y no se bloquee mientras espera una acción del usuario.

Lista de algunos de los eventos más usados que estarán disponibles en JavaScript donde se añadirá un ejemplo sencillo para mostrar su comportamiento:

Haciendo click en el botón se ejecuta la acción definida:

Copiando el contenidoTexto que puedes copiar, seleccionándolo y haciendo la acción de copiar (CTRL+C o click derechoCopiar) mostrará una alerta:

Al iniciar:

Si ponemos el cursor sobre el elemento rojo:

Si quitamos el foco del elemento azul pasará de nuevo al rojo:

Al añadir el cursor en el campo de texto junto con tres pulsaciones de teclas (e,eyr):

Aparte de estos ejemplos ejecutando eventos en Javascript existen muchos otros eventos que se pueden utilizar para crear experiencias web interactivas y dinámicas.

¿Cómo podemos saber más sobre los eventos existentes? Toda la información sobre los eventos que podemos encontrar la tenéis en el siguiente enlace:

https://shorten-up.vercel.app/NeOCRedUad

Y accediendo a ese contenido, nos encontramos con una tabla con todos los eventos especificados con una explicación:

Hay que tener en cuenta que estos eventos los ejecutaremos, dependiendo del caso y nuestras necesidades mediante el elementowindowy en otros casos condocument. ¿En que se diferencian? Seguid leyendo y lo descubriréis.

La diferencia principal entre registrar eventos enwindowy endocumentradica en el ámbito de captura del evento.

Sabiendo como se diferencian, tenemos que tener claro lo siguiente de manera resumida sobre lacaptura de eventosaplicándolo al uso del ratón como ejemplo:

Es más eficiente y preciso registrar eventos en elementos específicos del documento utilizandodocumento seleccionando elementos por su ID, clase o selector.

Ventajas de empleardocument:

Por lo tanto, es una buena práctica utilizardocumento seleccionar elementos específicos para registrar eventos, ya que te proporciona mayor control y seguridad en cuanto a dónde se ejecutará la lógica relacionada con los eventos.

El objetowindowes útil para registrar eventos que deben ser capturados a nivel global en toda la ventana del navegador. A continuación, os proporciono algunos casos en los que podríamos utilizarwindowpara registrar eventos:

Eventos de redimensionamiento de ventana(resize): Puedes utilizarwindowpara capturar eventos comoresize, que se disparan cuando el usuario cambia el tamaño de la ventana del navegador. Esto puede ser útil si necesitas ajustar dinámicamente el diseño de tu página en función del tamaño de la ventana.

Eventos
