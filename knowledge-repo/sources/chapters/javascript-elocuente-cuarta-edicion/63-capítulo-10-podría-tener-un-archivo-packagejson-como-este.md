# Capítulo 10: , podría tener un archivo package.json como este:

{
"author": "Marijn Haverbeke",
"name": "eloquent-javascript-robot",
"description": "Simulación de un robot de entrega de paquetes",
"version": "1.0.0",
"main": "run.mjs",
"dependencies": {
"dijkstrajs": "^1.0.1",
"random-item": "^1.0.0"
},
"license": "ISC"
}
Cuando ejecutas npm install sin especificar un paquete para instalar, NPM
instalará las dependencias enumeradas en package.json. Cuando instalas un
paquete específico que no está listado como una dependencia, NPM lo añadirá
a package.json.
Versiones
Un archivo package.json lista tanto la versión del propio programa como las
versiones de sus dependencias. Las versiones son una forma de manejar el hecho
de que los paquetes evolucionan por separado, y el código escrito para funcionar
con un paquete tal como existía en un momento dado puede no funcionar con
una versión posterior y modificada del paquete.
356

-- 368 of 445 --

NPM exige que sus paquetes sigan un esquema llamado semantic versioning,
que codifica información sobre qué versiones son compatibles (no rompen la
antigua interfaz) en el número de versión. Una versión semántica consiste en
tres números, separados por puntos, como 2.3.0. Cada vez que se añade nueva
funcionalidad, el número del medio debe incrementarse. Cada vez que se rompe
la compatibilidad, de modo que el código existente que utiliza el paquete puede
que no funcione con la nueva versión, el primer número debe incrementarse.
Un carácter de intercalación (^) delante del número de versión para una
dependencia en package.json indica que se puede instalar cualquier versión
compatible con el número dado. Por ejemplo, "^2.3.0" significaría que se
permite cualquier versión mayor o igual a 2.3.0 y menor que 3.0.0.
El comando npm también se utiliza para publicar nuevos paquetes o nuevas
versiones de paquetes. Si ejecutas npm publish en un directorio que tiene un
archivo package.json, se publicará un paquete con el nombre y versión lista-
dos en el archivo JSON en el registro. Cualquiera puede publicar paquetes
en NPM, aunque solo bajo un nombre de paquete que aún no esté en uso, ya
que no sería bueno que personas aleatorias pudieran actualizar paquetes exis-
tentes.Este libro no profundizará más en los detalles del uso de NPM. Consulta
https://npmjs.org para obtener más documentación y una forma de buscar pa-
quetes.
El módulo del sistema de archivos
Uno de los módulos integrados más utilizados en Node es el módulo node:fs,
que significa sistema de archivos. Exporta funciones para trabajar con archivos
y directorios.
Por ejemplo, la función llamada readFile lee un archivo y luego llama a una
función de devolución de llamada con el contenido del archivo.
import {readFile} from "node:fs";
readFile("archivo.txt", "utf8", (error, texto) => {
if (error) throw error;
console.log("El archivo contiene:", texto);
});
El segundo argumento de readFile indica la codificación de caracteres utilizada
para decodificar el archivo en una cadena. Existen varias formas en las que el
texto puede ser codificado en datos binarios, pero la mayoría de los sistemas
modernos utilizan UTF-8. Entonces, a menos que tengas razones para creer
que se utiliza otra codificación, pasa "utf8" al leer un archivo de texto. Si no
pasas una codificación, Node asumirá que estás interesado en los datos binarios
357

-- 369 of 445 --

y te dará un objeto Buffer en lugar de una cadena. Este es un objeto similar
a un array que contiene números que representan los bytes (trozos de datos de
8 bits) en los archivos.
import {readFile} from "node:fs";
readFile("archivo.txt", (error, buffer) => {
if (error) throw error;
console.log("El archivo contenía", buffer.length, "bytes.",
"El primer byte es:", buffer[0]);
});
Una función similar, writeFile, se utiliza para escribir un archivo en el disco.
import {writeFile} from "node:fs";
writeFile("graffiti.txt", "Node estuvo aquí", err => {
if (err) console.log(`Error al escribir el archivo: ${err}`);
else console.log("Archivo escrito.");
});
Aquí no fue necesario especificar la codificación: writeFile asumirá que cuando
se le da una cadena para escribir, en lugar de un objeto Buffer, debe escribirla
como texto utilizando su codificación de caracteres predeterminada, que es
UTF-8.
El módulo node:fs contiene muchas otras funciones útiles: readdir te dará
los archivos en un directorio como un array de cadenas, stat recuperará infor-
mación sobre un archivo, rename cambiará el nombre de un archivo, unlink lo
eliminará, entre otros. Consulta la documentación en https://nodejs.org para
obtener detalles específicos.
La mayoría de estas funciones toman una función de devolución de llamada
como último parámetro, a la que llaman ya sea con un error (el primer argu-
mento) o con un resultado exitoso (el segundo). Como vimos en el Capítulo 11,
hay desventajas en este estilo de programación, siendo la mayor que el manejo
de errores se vuelve verboso y propenso a errores.
El módulo node:fs/promises exporta la mayoría de las mismas funciones
que el antiguo módulo node:fs, pero utiliza promesas en lugar de funciones de
devolución de llamada.
import {readFile} from "node:fs/promises";
readFile("file.txt", "utf8")
.then(text => console.log("El archivo contiene:", text));
A veces no necesitas asincronía y simplemente te estorba. Muchas de las fun-
ciones en node:fs también tienen una variante síncrona, que tiene el mismo
nombre con Sync agregado al final. Por ejemplo, la versión síncrona de readFile
358

-- 370 of 445 --

se llama readFileSync.
import {readFileSync} from "node:fs";
console.log("El archivo contiene:",
readFileSync("file.txt", "utf8"));
Cabe destacar que mientras se realiza una operación síncrona de este tipo, tu
programa se detiene por completo. Si debería estar respondiendo al usuario o
a otras máquinas en la red, quedarse atrapado en una acción síncrona podría
producir retrasos molestos.
El módulo HTTP
Otro módulo central se llama node:http. Proporciona funcionalidad para eje-
cutar un servidor HTTP.
Esto es todo lo que se necesita para iniciar un servidor HTTP:
import {createServer} from "node:http";
let server = createServer((solicitud, respuesta) => {
respuesta.writeHead(200, {"Content-Type": "text/html"});
respuesta.write(`
<h1>¡Hola!</h1>
<p>Pediste <code>${solicitud.url}</code></p>`);
respuesta.end();
});
server.listen(8000);
console.log("¡Escuchando! (puerto 8000)");
Si ejecutas este script en tu propia máquina, puedes apuntar tu navegador web
a http://localhost:8000/hola para hacer una solicitud a tu servidor. Responderá
con una pequeña página HTML.
La función pasada como argumento a createServer se llama cada vez que un
cliente se conecta al servidor. Los enlaces solicitud y respuesta son objetos
que representan los datos de entrada y salida. El primero contiene información
sobre la solicitud, como su propiedad url, que nos dice a qué URL se hizo la
solicitud.
Así que, cuando abres esa página en tu navegador, envía una solicitud a tu
propia computadora. Esto hace que la función del servidor se ejecute y envíe
una respuesta, que luego puedes ver en el navegador.
Para enviar algo al cliente, llamas a métodos en el objeto respuesta. El
primero, writeHead, escribirá los encabezados de respuesta (ver Capítulo 18).
Le das el código de estado (200 para “OK” en este caso) y un objeto que
contiene valores de encabezado. El ejemplo establece el encabezado Content-
359

-- 371 of 445 --

Type para informar al cliente que estaremos enviando de vuelta un documento
HTML.
A continuación, el cuerpo real de la respuesta (el documento en sí) se envía
con response.write. Se permite llamar a este método varias veces si deseas
enviar la respuesta pieza por pieza, por ejemplo para transmitir datos al cliente
a medida que estén disponibles. Por último, response.end señala el fin de la
respuesta.
La llamada a server.listen hace que el servidor comience a esperar conex-
iones en el puerto 8000. Por eso debes conectarte a localhost:8000 para comu-
nicarte con este servidor, en lugar de simplemente a localhost, que usaría el
puerto predeterminado 80.
Cuando ejecutas este script, el proceso se queda esperando. Cuando un
script está escuchando eventos —en este caso, conexiones de red—, node no se
cerrará automáticamente al llegar al final del script. Para cerrarlo, presiona
control-C.
Un verdadero servidor web server usualmente hace más cosas que el ejemplo;
examina el método de la solicitud (la propiedad method) para ver qué acción
está intentando realizar el cliente y mira el URL de la solicitud para descubrir
sobre qué recurso se está realizando esta acción. Veremos un servidor más
avanzado más adelante en este capítulo.
El módulo node:http también provee una función request, que se puede usar
para hacer solicitudes HTTP. Sin embargo, es mucho más engorroso de usar
que fetch, que vimos en el Capítulo 18. Afortunadamente, fetch también está
disponible en Node, como un enlace global. A menos que desees hacer algo muy
específico, como procesar el documento de respuesta pieza por pieza a medida
que llegan los datos a través de la red, recomiendo usar fetch.
Flujos
El objeto de respuesta al que el servidor HTTP podría escribir es un ejemplo
de un objeto de flujo de escritura, que es un concepto ampliamente usado en
Node. Estos objetos tienen un método write al que se puede pasar una cadena
o un objeto Buffer para escribir algo en el flujo. Su método end cierra el flujo y
opcionalmente toma un valor para escribir en el flujo antes de cerrarlo. Ambos
métodos también pueden recibir una devolución de llamada como argumento
adicional, que se llamará cuando la escritura o el cierre hayan finalizado.
Es posible crear un flujo de escritura que apunte a un archivo con la función
createWriteStream del módulo node:fs. Luego puedes usar el método write en
el objeto resultante para escribir el archivo pieza por pieza, en lugar de hacerlo
360

-- 372 of 445 --

de una sola vez como con writeFile.
Los flujos legibles son un poco más complejos. El argumento request para la
devolución de llamada del servidor HTTP es un flujo legible. Leer de un flujo
se hace utilizando manejadores de eventos, en lugar de métodos.
Los objetos que emiten eventos en Node tienen un método llamado on que
es similar al método addEventListener en el navegador. Le das un nombre de
evento y luego una función, y registrará esa función para que se llame cada vez
que ocurra el evento dado.
Los streams legibles tienen eventos "data" y "end". El primero se dispara
cada vez que llegan datos, y el segundo se llama cuando el flujo llega a su fin.
Este modelo es más adecuado para datos de streaming que pueden procesarse
de inmediato, incluso cuando todo el documento aún no está disponible. Un
archivo se puede leer como un flujo legible utilizando la función createReadStream
de node:fs.
Este código crea un servidor que lee los cuerpos de las solicitudes y los reenvía
al cliente como texto en mayúsculas:
import {createServer} from "node:http";
createServer((solicitud, respuesta) => {
respuesta.writeHead(200, {"Content-Type": "text/plain"});
solicitud.on("data", fragmento =>
respuesta.write(fragmento.toString().toUpperCase()));
solicitud.on("end", () => respuesta.end());
}).listen(8000);
El valor chunk pasado al controlador de datos será un Buffer binario. Podemos
convertir esto a una cadena decodificándolo como caracteres codificados en
UTF-8 con su método toString.
El siguiente fragmento de código, cuando se ejecuta con el servidor de mayús-
culas activo, enviará una solicitud a ese servidor y escribirá la respuesta que
recibe:
fetch("http://localhost:8000/", {
method: "POST",
body: "Hola servidor"
}).then(resp => resp.text()).then(console.log);