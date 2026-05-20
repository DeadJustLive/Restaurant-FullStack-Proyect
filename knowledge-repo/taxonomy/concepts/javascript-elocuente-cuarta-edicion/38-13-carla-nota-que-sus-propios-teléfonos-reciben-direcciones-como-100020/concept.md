# 13. Carla nota que sus propios teléfonos reciben direcciones como 10.0.0.20

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 38)

## Contenido
# 13. Carla nota que sus propios teléfonos reciben direcciones como 10.0.0.20

o 10.0.0.33. Podría valer la pena intentar enviar mensajes a todas esas di-
recciones y ver si alguna responde a la interfaz descrita en el manual de las
señales.
El Capítulo 18 muestra cómo hacer solicitudes reales en redes reales. En
este capítulo, usaremos una función ficticia simplificada llamada request para
la comunicación en red. Esta función toma dos argumentos: una dirección de
red y un mensaje, que puede ser cualquier cosa que se pueda enviar como JSON,
y devuelve una promesa que se resuelve con una respuesta de la máquina en la
dirección dada, o se rechaza si hubo un problema.
Según el manual, puedes cambiar lo que se muestra en una señal SIG-5030
enviándole un mensaje con contenido como {"command": "display", "data":
[0, 0, 3, …]}, donde data contiene un número por cada punto de LED, indi-
cando su brillo; 0 significa apagado, 3 significa brillo máximo. Cada señal tiene
50 luces de ancho y 30 luces de alto, por lo que un comando de actualización
debe enviar 1500 números.
Este código envía un mensaje de actualización de pantalla a todas las direc-
ciones en la red local para ver cuál se queda. Cada uno de los números en una
dirección IP puede ir de 0 a 255. En los datos que envía, activa un número de
luces correspondiente al último número de la dirección de red.
for (let addr = 1; addr < 256; addr++) {
let data = [];
for (let n = 0; n < 1500; n++) {
data.push(n < addr ? 3 : 0);
}
let ip = `10.0.0.${addr}`;
192

-- 204 of 445 --

request(ip, {command: "display", data})
.then(() => console.log(`Solicitud a ${ip} aceptada`))
.catch(() => {});
}
Dado que la mayoría de estas direcciones no existirán o no aceptarán tales
mensajes, la llamada a catch se asegura de que los errores de red no hagan que
el programa falle. Las solicitudes se envían todas inmediatamente, sin esperar
a que otras solicitudes terminen, para no perder tiempo cuando algunas de las
máquinas no respondan.
Después de haber iniciado su exploración de red, Carla regresa afuera para
ver el resultado. Para su deleite, todas las pantallas ahora muestran una franja
de luz en sus esquinas superiores izquierdas. Están en la red local y sí aceptan
comandos. Rápidamente toma nota de los números mostrados en cada pantalla.
Hay 9 pantallas, dispuestas tres en alto y tres en ancho. Tienen las siguientes
direcciones de red:
const screenAddresses = [
"10.0.0.44", "10.0.0.45", "10.0.0.41",
"10.0.0.31", "10.0.0.40", "10.0.0.42",
"10.0.0.48", "10.0.0.47", "10.0.0.46"
];
Ahora esto abre posibilidades para todo tipo de travesuras. Podría mostrar “los
cuervos mandan, los humanos babean” en la pared en letras gigantes. Pero eso
se siente un poco grosero. En su lugar, planea mostrar un video de un cuervo
volando que cubre todas las pantallas por la noche.
Carla encuentra un clip de video adecuado, en el cual un segundo y medio de
metraje se puede repetir para crear un video en bucle mostrando el aleteo de
un cuervo. Para ajustarse a las nueve pantallas (cada una de las cuales puede
mostrar 50 por 30 píxeles), Carla corta y redimensiona los videos para obtener
una serie de imágenes de 150 por 90, diez por segundo. Estas luego se cortan
en nueve rectángulos cada una, y se procesan para que los puntos oscuros en
el video (donde está el cuervo) muestren una luz brillante, y los puntos claros
(sin cuervo) permanezcan oscuros, lo que debería crear el efecto de un cuervo
ámbar volando contra un fondo negro.
Ella ha configurado la variable clipImages para contener un array de fotogra-
mas, donde cada fotograma se representa con un array de nueve conjuntos de
píxeles, uno para cada pantalla, en el formato que los letreros esperan.
Para mostrar un único fotograma del video, Carla necesita enviar una solic-
itud a todas las pantallas a la vez. Pero también necesita esperar el resultado
de estas solicitudes, tanto para no comenzar a enviar el siguiente fotograma
193

-- 205 of 445 --

antes de que el actual se haya enviado correctamente, como para notar cuando
las solicitudes están fallando.
Promise tiene un método estático all que se puede usar para convertir un ar-
ray de promesas en una sola promesa que se resuelve en un array de resultados.
Esto proporciona una forma conveniente de que algunas acciones asíncronas
sucedan al lado unas de otras, esperar a que todas terminen y luego hacer algo
con sus resultados (o al menos esperar a que terminen para asegurarse de que
no fallen).
function displayFrame(frame) {
return Promise.all(frame.map((data, i) => {
return request(screenAddresses[i], {
command: "display",
data
});
}));
}
Esto recorre las imágenes en frame (que es un array de arrays de datos de
visualización) para crear un array de promesas de solicitud. Luego devuelve
una promesa que combina todas esas promesas.
Para poder detener un video en reproducción, el proceso está envuelto en una
clase. Esta clase tiene un método asíncrono play que devuelve una promesa
que solo se resuelve cua
