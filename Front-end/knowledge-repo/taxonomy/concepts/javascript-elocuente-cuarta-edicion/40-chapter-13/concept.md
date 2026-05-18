# Chapter 13

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 40)

## Contenido
# Chapter 13

JavaScript y el Navegador
Los próximos capítulos de este libro hablarán sobre los navegadores web. Sin
los navegadores web, no habría JavaScript. O incluso si existiera, nadie le
habría prestado atención.
La tecnología web ha sido descentralizada desde el principio, no solo técni-
camente, sino también en la forma en que evolucionó. Varios fabricantes de
navegadores han añadido nueva funcionalidad de manera ad hoc y a veces sin
mucho sentido, que luego, a veces, terminaba siendo adoptada por otros, y
finalmente establecida como en los estándares.
Esto es a la vez una bendición y una maldición. Por un lado, es empoder-
ador no tener a una parte central controlando un sistema, sino mejorando con
la contribución de diferentes partes que trabajan en una colaboración laxa (o
a veces en abierta hostilidad). Por otro lado, la forma caótica en que se desar-
rolló la Web significa que el sistema resultante no es precisamente un ejemplo
brillante de coherencia interna. Algunas partes son directamente confusas y
están mal diseñadas.
Redes y el Internet
Las redes de computadoras existen desde la década de 1950. Si conectas cables
entre dos o más computadoras y les permites enviar datos de ida y vuelta a
través de estos cables, puedes hacer todo tipo de cosas maravillosas.
Y si conectar dos máquinas en el mismo edificio nos permite hacer cosas
maravillosas, conectar máquinas en todo el planeta debería ser aún mejor. La
tecnología para comenzar a implementar esta visión se desarrolló en la década
de 1980, y la red resultante se llama el Internet. Ha cumplido su promesa.
Una computadora puede usar esta red para enviar bits a otra computadora.
Para que surja una comunicación efectiva de este envío de bits, las computado-
ras en ambos extremos deben saber qué se supone que representan los bits. El
significado de cualquier secuencia dada de bits depende enteramente del tipo de
cosa que está tratando de expresar y del mecanismo de codificación utilizado.
214

-- 226 of 445 --

Un protocolo de red describe un estilo de comunicación sobre una red. Hay
protocolos para enviar correos electrónicos, para recibir correos electrónicos,
para compartir archivos e incluso para controlar computadoras que han sido
infectadas por software malicioso.
El Protocolo de Transferencia de Hipertexto (HTTP) es un protocolo para
recuperar recursos nombrados (trozos de información, como páginas web o
imágenes). Especifica que el lado que realiza la solicitud debe comenzar con
una línea como esta, nombrando el recurso y la versión del protocolo que está
intentando usar:
GET /index.html HTTP/1.1
Hay muchas más reglas sobre la forma en que el solicitante puede incluir más
información en la solicitud y la forma en que el otro lado, que devuelve el
recurso, empaqueta su contenido. Veremos HTTP con un poco más de detalle
en el Capítulo 18.
La mayoría de los protocolos se construyen sobre otros protocolos. HTTP
trata la red como un dispositivo similar a un flujo en el que puedes poner bits
y hacer que lleguen al destino correcto en el orden correcto. Proporcionar esas
garantías encima del envío de datos primitivos que proporciona la red es un
problema bastante complicado.
El Protocolo de Control de Transmisión (TCP) es un protocolo que aborda
este problema. Todos los dispositivos conectados a Internet lo “hablan” y la
mayoría de las comunicaciones en Internet se construyen sobre él.
Una conexión TCP funciona de la siguiente manera: una computadora debe
estar esperando, o escuchando, a que otras computadoras comiencen a hablar
con ella. Para poder escuchar diferentes tipos de comunicación al mismo tiempo
en una sola máquina, cada oyente tiene asociado un número (llamado puerto).
La mayoría de los protocolos especifican qué puerto debe usarse de forma prede-
terminada. Por ejemplo, cuando queremos enviar un correo electrónico usando
el protocolo SMTP, se espera que la máquina a través de la cual lo enviamos
esté escuchando en el puerto 25.
Otra computadora puede establecer entonces una conexión conectándose a
la máquina de destino usando el número de puerto correcto. Si la máquina de
destino es alcanzable y está escuchando en ese puerto, la conexión se crea con
éxito. La computadora que escucha se llama el servidor, y la computadora que
se conecta se llama el cliente.
Dicha conexión actúa como un conducto bidireccional a través del cual
pueden fluir los bits: las máquinas en ambos extremos pueden insertar datos
en él. Una vez que los bits se transmiten con éxito, pueden volver a ser leídos
215

-- 227 of 445 --

por la máquina del otro lado. Este es un modelo conveniente. Se podría decir
que TCP proporciona una abstracción de la red.
La Web
El World Wide Web (no se debe confundir con el Internet en su totalidad) es
un conjunto de protocolos y formatos que nos permiten visitar páginas web en
un navegador. La parte “Web” en el nombre se refiere al hecho de que estas
páginas pueden enlazarse fácilmente entre sí, conectándose así en una gran
malla 
