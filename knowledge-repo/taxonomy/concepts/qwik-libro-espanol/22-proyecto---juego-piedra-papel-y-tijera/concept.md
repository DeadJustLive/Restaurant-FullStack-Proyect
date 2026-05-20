# Proyecto - Juego Piedra, Papel y Tijera

## Fuente
Qwik Framework - Libro en Español (Cap. 22)

## Contenido
# Proyecto - Juego Piedra, Papel y Tijera

> Fuente: [https://qwik-book-spanish.netlify.app/22-project-rock-paper-scissors](https://qwik-book-spanish.netlify.app/22-project-rock-paper-scissors)

Comenzamos con un nuevo capítulo donde vamos a empezar a trabajar de manera práctica con un proyecto sencillo del clásico juegoPiedra, Papel y Tijera.

Está basado en unantiguo artículo que escribí para mostrar como se hacía con Angular, será prácticamente lo mismo, pero adaptado a Qwik 100%.

El objetivo principal será practicar aspectos de Qwik obtenidos a lo largo del libro con el objetivo de hacer algo que nos pueda entretener en momentos puntuales y a la vez nos sirva para afianzar conocimientos.

El juego en si es muy sencillo, pero es super útil para poder repasar algunos conceptos adquiridos durante el libro.

Lo que conseguiremos al final del capítulo será algo similar a lo siguiente:

Juego en Qwik

A continuación os proporciono los puntos que vamos a ver en este capítulo.

Estos pasos los vamos a completar hasta publicar un proyecto Qwik con Netlify.

En este capítulo vamos a crear el mítico juegoPiedra, Papel o tijeraque seguramente lo conocéis muy bien y seguramente muchos/as de nosotros/as hemos jugado cuando estábamos en etapas escolares de primaria.

Si no lo habéis jugado, tranquilidad, que la mecánica del juego es super sencilla:

Tenemos 3 elementos, piedra, papel o tijera y en cada jugada cada participante (normalmente es uno contra uno) saca uno de esos 3 elementos, con el objetivo de vencer a su contrincante.

Estas serán las 3 opciones, representadas cada una de ellas por una imagen:

Las combinaciones ganadoras son las siguientes:

Si queréis más información del juego y otros temas relacionados, os invito a que os animéis a accedera la información de Wikipedia del juego.

Iniciamos un nuevo proyecto llamado22-paper-scissors-rock.

El proceso para realizarlo ya lo conocéis de sobra

Comenzamos con el apartado visual, donde daremos todos los pasos necesarios hasta llegar a la siguiente apariencia, sin implementar la lógica.

Una vez que ya hemos creado el proyecto, descargamos las tres imágenes que necesitamos para las diferentes opciones del juego.

Estas imágenes nos servirán para ejecutar nuestras jugadas con piedra, papel y tijera.

Añadimos las imágenes dentro del directoriopubliccon un nuevo directorio que usaremos para almacenar las imágenes, llamadoimg(quedandopublic/img/), para poder utilizarlas desde cualquier parte de nuestra app accediendo fácilmente.

Descargamos las imágenes desdeaquí

Al descargar y añadirlas, si las abrimos, se mostrarán de la siguiente forma (aquí con la correspondiente a tijeras):

Aplicamos el siguiente código CSS en elindex.css(después de crearlo) dentro desrc/routes:

Ya tenemos preparadas las imágenes y podemos añadirlas accediendo a ellas mediante el directoriopublic, que será añadiendo en el atributosrcel caracter/y luego la ruta relativa que corresponde a los ficheros, que se encontrarán dentro del directorioimg, siendo su ruta originalpublic/img/<imagen>.png.

Por lo tanto, se reflejará el atributosrccon el valor/img/<imagen>.png, quedando así el contenido desrc/routes/index.tsxteniendo en cuenta que añadimos la referencia al CSS:

Una vez que guardamos los cambios, se muestra la siguiente apariencia:

Debemos de solucionar el problema que se da con el tamaño de la imagen tal y como se ha visto en el capítulocapítulo 6donde se asigna un tamaño fijo, ya que Qwik requiere de esta propiedad.

Al realizar las correcciones, este será el código resultante:

Al guardar, desaparecen las advertencias:

Hemos solucionado el problema de la advertencia, aunque si nos fijamos en la consola, nos encontramos un aviso como el siguiente (el aviso se ha empezado observar a partir de la versión1.5.0):

En este caso se nos está recomendando optimizar las imágenes con unas sencillas instrucciones que en este caso, no las seguiremos, ya que vamos a dinamizar las imágenes y con esta operación, conseguiremos eliminar esta advertencia.

Lo que nos vamos a centrar es en construir el juego y en que funcione, luego ya nos centramos en mejoras y optimizaciones.

Aplicando varios cambios en elindex.cssdonde especificamos cómo estará lo que es el contenedor principal delbodycon su estilo, conseguiremos dejarlo sin márgenes, ni relleno para aplicarle un fondo de color personalizado.

Quedará de la siguiente manera, donde queda evidente que tenemos que mejorar mucho el tema de las opciones de juego para considerarlo presentable.

Añadimos varios cambios en el apartado delindex.cssen relación a las opciones del juego.

Borde en las opciones.

Centrar el contenido de manera horizontal medianteFlexbox.

Aplicarle un fondo a las imágenes para conseguir una visualización mejor.

Aplicando estos cambios en elindex.css:

Quedará de la siguiente manera:

Es evidente que ha mejorado bastante la apariencia, quedando muchísimo mejor en lo que respecta a las opciones del juego.

Eso sí, cada uno/
