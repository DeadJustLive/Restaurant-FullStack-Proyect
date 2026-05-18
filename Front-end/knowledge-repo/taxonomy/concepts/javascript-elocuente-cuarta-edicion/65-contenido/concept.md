# CONTENIDO

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 65)

## Contenido
# CONTENIDO

$ curl -X DELETE http://localhost:8000/file.txt
$ curl http://localhost:8000/file.txt
Archivo no encontrado
La primera solicitud para file.txt falla ya que el archivo aún no existe. La
solicitud PUT crea el archivo y, voilà, la siguiente solicitud lo recupera con
éxito. Después de eliminarlo con una solicitud DELETE, el archivo vuelve a estar
ausente.
Resumen
Node es un sistema pequeño interesante que nos permite ejecutar JavaScript en
un contexto no de navegador. Originalmente fue diseñado para tareas de red
para desempeñar el papel de un nodo en una red. Sin embargo, se presta para
todo tipo de tareas de script, y si disfrutas escribir JavaScript, automatizar
tareas con Node funciona bien.
NPM proporciona paquetes para todo lo que puedas imaginar (y varias cosas
que probablemente nunca se te ocurrirían), y te permite descargar e instalar
esos paquetes con el programa npm. Node viene con varios módulos integrados,
incluido el módulo node:fs para trabajar con el sistema de archivos y el módulo
node:http para ejecutar servidores HTTP.Todo el input y output en Node se
hace de forma asíncrona, a menos que uses explícitamente una variante síncrona
de una función, como readFileSync. Originalmente, Node usaba devoluciones
de llamada para funcionalidades asíncronas, pero el paquete node:fs/promises
proporciona una interfaz basada en promesas para el sistema de archivos.
367

-- 379 of 445 --

Ejercicios
Herramienta de búsqueda
En los sistemas Unix, existe una herramienta de línea de comandos llamada
grep que se puede utilizar para buscar rápidamente archivos según una expre-
sión regular.
Escribe un script de Node que se pueda ejecutar desde la línea de comandos
y funcione de manera similar a grep. Trata el primer argumento de la línea de
comandos como una expresión regular y trata cualquier argumento adicional
como archivos a buscar. Debería mostrar los nombres de los archivos cuyo
contenido coincide con la expresión regular.
Una vez que eso funcione, extiéndelo para que cuando uno de los argumentos
sea un directorio, busque en todos los archivos de ese directorio y sus subdirec-
torios.
Utiliza funciones asíncronas o síncronas del sistema de archivos según con-
sideres adecuado. Configurar las cosas para que se soliciten múltiples acciones
asíncronas al mismo tiempo podría acelerar un poco las cosas, pero no demasi-
ado, ya que la mayoría de los sistemas de archivos solo pueden leer una cosa a
la vez.
Creación de directorios
Aunque el método DELETE en nuestro servidor de archivos es capaz de eliminar
directorios (usando rmdir), actualmente el servidor no proporciona ninguna
forma de crear un directorio.
Añade soporte para el método MKCOL (“make collection”), que debería crear
un directorio llamando a mkdir desde el módulo node:fs. MKCOL no es un
método HTTP ampliamente utilizado, pero sí existe con este mismo propósito
en el estándar WebDAV, el cual especifica un conjunto de convenciones sobre
HTTP que lo hacen adecuado para crear documentos.
Un espacio público en la web
Dado que el servidor de archivos sirve cualquier tipo de archivo e incluso incluye
la cabecera Content-Type correcta, puedes usarlo para servir un sitio web. Dado
que permite a todos eliminar y reemplazar archivos, sería un tipo interesante
de sitio web: uno que puede ser modificado, mejorado y vandalizado por todos
aquellos que se tomen el tiempo de hacer la solicitud HTTP adecuada.
Escribe una página HTML básica que incluya un archivo JavaScript sencillo.
Coloca los archivos en un directorio servido por el servidor de archivos y ábrelos
368

-- 380 of 445 --

en tu navegador.
Luego, como ejercicio avanzado o incluso como un proyecto de fin de semana,
combina todo el conocimiento que has adquirido de este libro para construir
una interfaz más amigable para modificar el sitio web—desde dentro del sitio
web.
Utiliza un formulario HTML para editar el contenido de los archivos que con-
forman el sitio web, permitiendo al usuario actualizarlos en el servidor mediante
solicitudes HTTP, como se describe en el Capítulo 18.
Comienza permitiendo que solo un archivo sea editable. Luego haz que el
usuario pueda seleccionar qué archivo editar. Aprovecha el hecho de que nuestro
servidor de archivos devuelve listas de archivos al leer un directorio.
No trabajes directamente en el código expuesto por el servidor de archivos
ya que si cometes un error, es probable que dañes los archivos allí. En su lugar,
mantén tu trabajo fuera del directorio accesible al público y cópialo allí al hacer
pruebas.
369

-- 381 of 445 --

“Si tienes conocimiento, permite que otros enciendan sus velas en él.”
—Margaret Fuller
