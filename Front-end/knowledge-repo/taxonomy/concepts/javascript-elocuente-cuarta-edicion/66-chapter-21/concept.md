# Chapter 21

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 66)

## Contenido
# Chapter 21

Proyecto: Sitio web de intercambio de
habilidades
Una reunión de intercambio de habilidades es un evento en el que personas con
un interés compartido se reúnen y dan pequeñas presentaciones informales sobre
cosas que saben. En una reunión de intercambio de habilidades de jardinería,
alguien podría explicar cómo cultivar apio. O en un grupo de intercambio de
habilidades de programación, podrías pasar y contarles a la gente sobre Node.js.
En este último capítulo del proyecto, nuestro objetivo es configurar un sitio
web para gestionar las charlas impartidas en una reunión de intercambio de
habilidades. Imagina un pequeño grupo de personas que se reúnen regular-
mente en la oficina de uno de los miembros para hablar sobre monociclos. El
organizador anterior de las reuniones se mudó a otra ciudad y nadie se ofre-
ció a asumir esta tarea. Queremos un sistema que permita a los participantes
proponer y discutir charlas entre ellos, sin un organizador activo.
El código completo del proyecto se puede descargar desde https://eloquentjavascript.net/
code/skillsharing.zip.
Diseño
Este proyecto tiene una parte de servidor, escrita para Node.js, y una parte de
cliente, escrita para el navegador. El servidor almacena los datos del sistema
y los proporciona al cliente. También sirve los archivos que implementan el
sistema del lado del cliente.
El servidor mantiene la lista de charlas propuestas para la próxima reunión,
y el cliente muestra esta lista. Cada charla tiene un nombre de presentador, un
título, un resumen y una matriz de comentarios asociados. El cliente permite a
los usuarios proponer nuevas charlas (agregándolas a la lista), eliminar charlas
y comentar en charlas existentes. Cada vez que el usuario realiza un cambio
de este tipo, el cliente realiza una solicitud HTTP para informar al servidor al
respecto.
370

-- 382 of 445 --

La aplicación se configurará para mostrar una vista en vivo de las charlas
propuestas actuales y sus comentarios. Cada vez que alguien, en algún lugar,
envíe una nueva charla o agregue un comentario, todas las personas que ten-
gan la página abierta en sus navegadores deberían ver el cambio de inmediato.
Esto plantea un desafío—no hay forma de que un servidor web abra una conex-
ión a un cliente, ni hay una buena forma de saber qué clientes están viendo
actualmente un sitio web dado.
Una solución común a este problema se llama long polling, que resulta ser
una de las motivaciones del diseño de Node.
Long polling
Para poder notificar inmediatamente a un cliente que algo ha cambiado, necesi-
tamos una conexión con ese cliente. Dado que los navegadores web tradicional-
mente no aceptan conexiones y los clientes a menudo están detrás de routers
que bloquearían tales conexiones de todos modos, no es práctico que sea el
servidor quien inicie esta conexión.
Podemos hacer que el cliente abra la conexión y la mantenga activa para que
el servidor pueda usarla para enviar información cuando sea necesario.
Sin embargo, una solicitud HTTP permite solo un flujo simple de informa-
ción: el cliente envía una solicitud, el servidor responde una sola vez, y eso es
371

-- 383 of 445 --

todo. Existe una tecnología llamada WebSockets que permite abrir conexiones
para el intercambio arbitrario de datos. Pero usarlas adecuadamente es algo
complicado.
En este capítulo, utilizamos una técnica más sencilla—long polling—donde
los clientes preguntan continuamente al servidor por nueva información medi-
ante solicitudes HTTP regulares, y el servidor retiene su respuesta cuando no
tiene nada nuevo que informar.
Mientras el cliente se asegure de tener una solicitud de sondeo abierta con-
stantemente, recibirá información del servidor rápidamente cuando esté disponible.
Por ejemplo, si Fatma tiene nuestra aplicación de intercambio de habilidades
abierta en su navegador, ese navegador habrá solicitado actualizaciones y es-
tará esperando una respuesta a esa solicitud. Cuando Iman envía una charla
sobre “Extreme Downhill Unicycling”, el servidor notará que Fatma está es-
perando actualizaciones y enviará una respuesta que contiene la nueva charla a
su solicitud pendiente. El navegador de Fatma recibirá los datos y actualizará
la pantalla para mostrar la charla.
Para evitar que las conexiones se agoten por tiempo (se aborten debido
a una falta de actividad), las técnicas de long polling suelen establecer un
tiempo máximo para cada solicitud, tras el cual el servidor responderá de todos
modos, aunque no tenga nada que informar. Entonces, el cliente puede iniciar
una nueva solicitud. Reiniciar periódicamente la solicitud también hace que
la técnica sea más robusta, permitiendo a los clientes recuperarse de fallos
temporales de conexión o problemas de servidor.
Un servidor ocupado que utiliza long polling puede tener miles de solicitudes
en espera, y por lo tanto conexiones TCP abiertas. Node, que facilita la gestión
de muchas conexiones sin crear un hilo de control separado para cada una, es
ideal para este 
