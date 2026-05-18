# Capítulo 47:: Eventloop

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 85)

## Contenido
# Capítulo 47:: Eventloop

Introducción
En este post vamos a discutir cómo surgió el concepto de Eventloop y cómo se puede usar para
servidores de alto rendimiento y aplicaciones controladas por eventos como las GUI.
Examples
Cómo evolucionó el concepto de bucle de eventos.
Eventloop en pseudo codigo
Un bucle de eventos es un bucle que espera eventos y luego reacciona a esos eventos
while true:
wait for something to happen
react to whatever happened
Ejemplo de un servidor HTTP de un solo hilo
sin bucle de eventos
while true:
socket = wait for the next TCP connection
read the HTTP request headers from (socket)
file_contents = fetch the requested file from disk
write the HTTP response headers to (socket)
write the (file_contents) to (socket)
close(socket)
Aquí hay una forma simple de un servidor HTTP que es un solo hilo pero no un bucle de eventos.
El problema aquí es que espera hasta que finalice cada solicitud antes de comenzar a procesar la
siguiente. Si toma un tiempo leer los encabezados de solicitud HTTP o recuperar el archivo del
disco, deberíamos poder comenzar a procesar la siguiente solicitud mientras esperamos que
termine.
La solución más común es hacer que el programa sea multihilo.
Ejemplo de un servidor HTTP multihilo sin
bucle de eventos
https://riptutorial.com/es/home 163

-- 191 of 423 --

function handle_connection(socket):
read the HTTP request headers from (socket)
file_contents = fetch the requested file from disk
write the HTTP response headers to (socket)
write the (file_contents) to (socket)
close(socket)
while true:
socket = wait for the next TCP connection
spawn a new thread doing handle_connection(socket)
Ahora hemos hecho nuestro pequeño servidor HTTP multihilo. De esta manera, podemos pasar
inmediatamente a la siguiente solicitud porque la solicitud actual se está ejecutando en un
subproceso en segundo plano. Muchos servidores, incluido Apache, utilizan este enfoque.
Pero no es perfecto. Una limitación es que solo puedes generar tantos hilos. Para las cargas de
trabajo donde tiene una gran cantidad de conexiones, pero cada conexión solo requiere atención
de vez en cuando, el modelo de subprocesos múltiples no funcionará muy bien. La solución para
esos casos es usar un bucle de eventos:
Ejemplo de un servidor HTTP con bucle de
eventos
while true:
event = wait for the next event to happen
if (event.type == NEW_TCP_CONNECTION):
conn = new Connection
conn.socket = event.socket
start reading HTTP request headers from (conn.socket) with userdata = (conn)
else if (event.type == FINISHED_READING_FROM_SOCKET):
conn = event.userdata
start fetching the requested file from disk with userdata = (conn)
else if (event.type == FINISHED_READING_FROM_DISK):
conn = event.userdata
conn.file_contents = the data we fetched from disk
conn.current_state = "writing headers"
start writing the HTTP response headers to (conn.socket) with userdata = (conn)
else if (event.type == FINISHED_WRITING_TO_SOCKET):
conn = event.userdata
if (conn.current_state == "writing headers"):
conn.current_state = "writing file contents"
start writing (conn.file_contents) to (conn.socket) with userdata = (conn)
else if (conn.current_state == "writing file contents"):
close(conn.socket)
Esperemos que este pseudocódigo sea inteligible. Esto es lo que está pasando: esperamos que
las cosas sucedan. Cada vez que se crea una nueva conexión o una conexión existente necesita
nuestra atención, nos ocupamos de ella y luego volvemos a esperar. De esa manera, nos
desempeñamos bien cuando hay muchas conexiones y cada una rara vez requiere atención.
En una aplicación real (no pseudocódigo) que se ejecuta en Linux, la parte de "esperar a que
ocurra el próximo evento" se implementaría llamando a la llamada del sistema poll () o epoll ().
https://riptutorial.com/es/home 164

-- 192 of 423 --

Las partes de "comenzar a leer / escribir algo en un socket" se implementarían llamando a recv ()
o a las llamadas del sistema send () en modo no bloqueante.
Referencia:
[1]. "¿Cómo funciona un bucle de eventos?" [En línea]. Disponible: https://www.quora.com/How-
does-an-event-loop-work
Lea Eventloop en línea: https://riptutorial.com/es/node-js/topic/8652/eventloop
https://riptutorial.com/es/home 165

-- 193 of 423 --
