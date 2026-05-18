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
que solo se resuelve cuando la reproducción se detiene de nuevo a través del
método stop.
function wait(time) {
return new Promise(accept => setTimeout(accept, time));
}
class VideoPlayer {
constructor(frames, frameTime) {
this.frames = frames;
this.frameTime = frameTime;
this.stopped = true;
}
async play() {
this.stopped = false;
for (let i = 0; !this.stopped; i++) {
let nextFrame = wait(this.frameTime);
await displayFrame(this.frames[i % this.frames.length]);
await nextFrame;
}
194

-- 206 of 445 --

}
stop() {
this.stopped = true;
}
}
La función wait envuelve setTimeout en una promesa que se resuelve después
del número de milisegundos especificado. Esto es útil para controlar la veloci-
dad de reproducción.
let video = new VideoPlayer(clipImages, 100);
video.play().catch(e => {
console.log("La reproducción falló: " + e);
});
setTimeout(() => video.stop(), 15000);
Durante toda la semana que dura el muro de pantalla, todas las noches, cuando
está oscuro, aparece misteriosamente un enorme pájaro naranja brillante en él.
El bucle de eventos
Un programa asincrónico comienza ejecutando su script principal, que a menudo
configurará devoluciones de llamada para ser llamadas más tarde. Ese script
principal, así como las devoluciones de llamada, se ejecutan por completo de
una vez, sin interrupciones. Pero entre ellos, el programa puede estar inactivo,
esperando a que ocurra algo.
Por lo tanto, las devoluciones de llamada no son llamadas directamente por
el código que las programó. Si llamo a setTimeout desde dentro de una función,
esa función ya habrá retornado en el momento en que se llame a la función de
devolución de llamada. Y cuando la devolución de llamada regresa, el control
no vuelve a la función que lo programó.
El comportamiento asincrónico ocurre en su propia función vacía pila de
llamadas. Esta es una de las razones por las que, sin promesas, gestionar ex-
cepciones en código asincrónico es tan difícil. Dado que cada devolución de
llamada comienza con una pila de llamadas en su mayoría vacía, sus mane-
jadores de catch no estarán en la pila cuando lancen una excepción.
try {
setTimeout(() => {
throw new Error("¡Zoom!");
}, 20);
} catch (e) {
195

-- 207 of 445 --

// Esto no se ejecutará
console.log("Atrapado", e);
}
No importa cuán cerca ocurran eventos, como tiempos de espera o solicitudes
entrantes, un entorno JavaScript ejecutará solo un programa a la vez. Puedes
pensar en esto como ejecutar un gran bucle alrededor de tu programa, llamado
el bucle de eventos. Cuando no hay nada que hacer, ese bucle se pausa. Pero
a medida que llegan eventos, se agregan a una cola y su código se ejecuta uno
tras otro. Debido a que no se ejecutan dos cosas al mismo tiempo, un código
lento puede retrasar el manejo de otros eventos.
Este ejemplo establece un tiempo de espera pero luego se demora hasta
después del momento previsto para el tiempo de espera, provocando que el
tiempo de espera sea tardío.
let start = Date.now();
setTimeout(() => {
console.log("El tiempo de espera se ejecutó en", Date.now() -
start);
}, 20);
while (Date.now() < start + 50) {}
console.log("Tiempo perdido hasta", Date.now() - start);
// → Tiempo perdido hasta 50
// → El tiempo de espera se ejecutó en 55
Las promesas siempre se resuelven o se rechazan como un nuevo evento. Incluso
si una promesa ya está resuelta, esperarla hará que su devolución de llamada
se ejecute después de que termine el script actual, en lugar de inmediatamente.
Promise.resolve("Hecho").then(console.log);
console.log("¡Yo primero!");
// → ¡Yo primero!
// → Hecho
En capítulos posteriores veremos varios tipos de eventos que se ejecutan en el
bucle de eventos.
Errores asincrónicos
Cuando tu programa se ejecuta de forma síncrona, de una sola vez, no hay
cambios de estado ocurriendo excepto aquellos que el programa mismo real-
iza. Para programas asíncronos esto es diferente, pueden tener brechas en su
ejecución durante las cuales otro código puede correr.
196

-- 208 of 445 --

Veamos un ejemplo. Esta es una función que intenta reportar el tamaño de
cada archivo en un arreglo de archivos, asegurándose de leerlos todos al mismo
tiempo en lugar de en secuencia.
async function fileSizes(files) {
let lista = "";
await Promise.all(files.map(async fileName => {
lista += fileName + ": " +
(await textFile(fileName)).length + "\n";
}));
return lista;
}
La parte async fileName => muestra cómo también se pueden hacer arrow
functions async colocando la palabra async delante de ellas.
El código no parece ser sospechoso de inmediato... mapea la función flecha
async sobre el arreglo de nombres, creando un arreglo de promesas, y luego usa
Promise.all para esperar a todas ellas antes de devolver la lista que construyen.
Pero está totalmente roto. Siempre devolverá solo una línea de salida, enu-
merando el archivo que tardó más en leer.
¿Puedes descubrir por qué?
El problema radica en el operador +=, que toma el valor actual de lista en el
momento en que comienza a ejecutarse la instrucción y luego, cuando el await
termina, establece el enlace lista como ese valor más la cadena agregada.
Pero entre el momento en que comienza a ejecutarse la instrucción y el mo-
mento en que termina, hay una brecha asincrónica. La expresión map se ejecuta
antes de que se agregue cualquier cosa a la lista, por lo que cada uno de los
operadores += comienza desde una cadena vacía y termina, cuando termina su
recuperación de almacenamiento, estableciendo lista en el resultado de agregar
su línea a la cadena vacía.
Esto podría haberse evitado fácilmente devolviendo las líneas de las prome-
sas mapeadas y llamando a join en el resultado de Promise.all, en lugar de
construir la lista cambiando un enlace. Como suele ser, calcular nuevos valores
es menos propenso a errores que cambiar valores existentes.
async function fileSizes(files) {
let líneas = files.map(async fileName => {
return fileName + ": " +
(await textFile(fileName)).length;
});
return (await Promise.all(líneas)).join("\n");
}
197

-- 209 of 445 --

Errores como este son fáciles de cometer, especialmente al usar await, y debes
ser consciente de dónde ocurren las brechas en tu código. Una ventaja de la
asincronía explícita de JavaScript (ya sea a través de devoluciones de llamada,
promesas o await) es que identificar estas brechas es relativamente fácil.
Resumen
La programación asincrónica hace posible expresar la espera de acciones de
larga duración sin congelar todo el programa. Los entornos de JavaScript
típicamente implementan este estilo de programación utilizando devoluciones
de llamada, funciones que se llaman cuando las acciones se completan. Un bucle
de eventos programa estas devoluciones de llamada para que se llamen cuando
sea apropiado, una tras otra, de modo que su ejecución no se superponga.La
programación de forma asíncrona se facilita gracias a las promesas, que son
objetos que representan acciones que podrían completarse en el futuro, y las
funciones async, que te permiten escribir un programa asíncrono como si fuera
sincrónico.
Ejercicios
Momentos de tranquilidad
Hay una cámara de seguridad cerca del laboratorio de Carla que se activa con
un sensor de movimiento. Está conectada a la red y comienza a enviar un
flujo de video cuando está activa. Como prefiere no ser descubierta, Carla ha
configurado un sistema que detecta este tipo de tráfico de red inalámbrico y
enciende una luz en su guarida cada vez que hay actividad afuera, para que
ella sepa cuándo mantenerse en silencio.
También ha estado registrando los momentos en que la cámara se activa
desde hace un tiempo, y quiere utilizar esta información para visualizar qué
momentos, en una semana promedio, tienden a ser tranquilos y cuáles tienden
a ser ocupados. El registro se almacena en archivos que contienen un número
de marca de tiempo por línea (como devuelto por Date.now()).
1695709940692
1695701068331
1695701189163
El archivo "camera_logs.txt" contiene una lista de archivos de registro. Es-
cribe una función asíncrona activityTable(día) que, para un día de la semana
198

-- 210 of 445 --

dado, devuelva un array de 24 números, uno para cada hora del día, que con-
tenga la cantidad de observaciones de tráfico de red de la cámara vista en esa
hora del día. Los días se identifican por número utilizando el sistema utilizado
por Date.getDay, donde el domingo es 0 y el sábado es 6.
La función activityGraph, proporcionada por el sandbox, resume dicha tabla
en una cadena.
Utiliza la función textFile definida anteriormente, que al recibir un nombre
de archivo devuelve una promesa que se resuelve en el contenido del archivo.
Recuerda que new Date(marcaDeTiempo) crea un objeto Date para ese momento,
que tiene métodos getDay y getHours que devuelven el día de la semana y la
hora del día.
Ambos tipos de archivos, la lista de archivos de registro y los propios archivos
de registro, tienen cada dato en su propia línea, separados por caracteres de
nueva línea ("\n").
Construyendo Promise.all
Como vimos, dado un array de promesas, Promise.all devuelve una promesa
que espera a que todas las promesas en el array finalicen. Luego tiene éxito,
devolviendo un array de valores de resultado. Si una promesa en el array falla,
la promesa devuelta por all también falla, con la razón de fallo de la promesa
que falló.
Implementa algo similar tú mismo como una función regular llamada Promise_all
.
Recuerda que después de que una promesa tiene éxito o falla, no puede
volver a tener éxito o fallar, y las llamadas posteriores a las funciones que la
resuelven se ignoran. Esto puede simplificar la forma en que manejas el fallo
de tu promesa.
199

-- 211 of 445 --

“El evaluador, que determina el significado de expresiones en un
lenguaje de programación, es solo otro programa.”
—Hal Abelson y Gerald Sussman, Estructura e Interpretación de
Programas de Computadora