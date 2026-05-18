# // → HOLA SERVIDOR

Un servidor de archivos
Combina nuestro nuevo conocimiento sobre los servidores HTTP y el trabajo
con el sistema de archivos para crear un puente entre ambos: un servidor HTTP
361

-- 373 of 445 --

que permite el acceso remoto a un sistema de archivos. Este tipo de servidor
tiene todo tipo de usos, como permitir que las aplicaciones web almacenen y
compartan datos, o dar acceso compartido a un grupo de personas a un montón
de archivos.
Cuando tratamos los archivos como recursos de HTTP, los métodos HTTP
GET, PUT y DELETE se pueden usar para leer, escribir y eliminar los archivos, re-
spectivamente. Interpretaremos la ruta en la solicitud como la ruta del archivo
al que se refiere la solicitud.
Probablemente no queramos compartir todo nuestro sistema de archivos, por
lo que interpretaremos estas rutas como comenzando en el directorio de trabajo
del servidor, que es el directorio en el que se inició. Si ejecuté el servidor desde
/tmp/public/ (o C:\tmp\public\ en Windows), entonces una solicitud para
/file.txt debería referirse a /tmp/public/file.txt (o C:\tmp\public\file.
txt).
Construiremos el programa paso a paso, utilizando un objeto llamado methods
para almacenar las funciones que manejan los diferentes métodos HTTP. Los
controladores de métodos son funciones async que reciben el objeto de solici-
tud como argumento y devuelven una promesa que se resuelve a un objeto que
describe la respuesta.
import {createServer} from "node:http";
const methods = Object.create(null);
createServer((request, response) => {
let handler = methods[request.method] || notAllowed;
handler(request).catch(error => {
if (error.status != null) return error;
return {body: String(error), status: 500};
}).then(({body, status = 200, type = "text/plain"}) => {
response.writeHead(status, {"Content-Type": type});
if (body && body.pipe) body.pipe(response);
else response.end(body);
});
}).listen(8000);
async function notAllowed(request) {
return {
status: 405,
body: `Método ${request.method} no permitido.`
};
}
362

-- 374 of 445 --

Esto inicia un servidor que simplemente devuelve respuestas de error 405, que
es el código utilizado para indicar que el servidor se niega a manejar un método
determinado.
Cuando la promesa de un controlador de solicitud es rechazada, la llamada
a catch traduce el error en un objeto de respuesta, si aún no lo es, para que
el servidor pueda enviar una respuesta de error para informar al cliente que no
pudo manejar la solicitud.
El campo status de la descripción de la respuesta puede omitirse, en cuyo
caso se establece en 200 (OK) por defecto. El tipo de contenido, en la propiedad
type, también puede omitirse, en cuyo caso se asume que la respuesta es texto
plano.
Cuando el valor de body es un readable stream, este tendrá un método pipe
que se utiliza para reenviar todo el contenido de un flujo de lectura a un writable
stream. Si no es así, se asume que es null (sin cuerpo), una cadena o un búfer,
y se pasa directamente al método end del response.
Para determinar qué ruta de archivo corresponde a una URL de solicitud,
la función urlPath utiliza la clase integrada URL (que también existe en el
navegador) para analizar la URL. Este constructor espera una URL completa,
no solo la parte que comienza con la barra diagonal que obtenemos de request.
url, por lo que le proporcionamos un nombre de dominio falso para completar.
Extrae su ruta, que será algo como "/archivo.txt", la decodifica para eliminar
los códigos de escape estilo %20, y la resuelve en relación con el directorio de
trabajo del programa.
import {parse} from "node:url";
import {resolve, sep} from "node:path";
const baseDirectory = process.cwd();
function urlPath(url) {
let {pathname} = new URL(url, "http://d");
let path = resolve(decodeURIComponent(pathname).slice(1));
if (path != baseDirectory &&
!path.startsWith(baseDirectory + sep)) {
throw {status: 403, body: "Prohibido"};
}
return path;
}
Tan pronto como configuras un programa para aceptar solicitudes de red, debes
empezar a preocuparte por la seguridad. En este caso, si no tenemos cuidado,
es probable que terminemos exponiendo accidentalmente todo nuestro sistema
363

-- 375 of 445 --

de archivos a la red.
Las rutas de archivos son cadenas en Node. Para mapear dicha cadena a un
archivo real, hay una cantidad no trivial de interpretación en juego. Las rutas
pueden, por ejemplo, incluir ../ para hacer referencia a un directorio padre.
Así que una fuente obvia de problemas serían las solicitudes de rutas como
/../archivo_secreto.
Para evitar tales problemas, urlPath utiliza la función resolve del módulo
node:path, que resuelve rutas relativas. Luego verifica que el resultado esté
debajo del directorio de trabajo. La función process.cwd (donde cwd significa
“directorio de trabajo actual”) se puede usar para encontrar este directorio
de trabajo. El vínculo sep del paquete node:path es el separador de ruta del
sistema: una barra invertida en Windows y una barra diagonal en la mayoría
de otros sistemas. Cuando la ruta no comienza con el directorio base, la función
arroja un objeto de respuesta de error, usando el código de estado HTTP que
indica que el acceso al recurso está prohibido.
Configuraremos el método GET para devolver una lista de archivos al leer un
directorio y para devolver el contenido del archivo al leer un archivo regular.
Una pregunta complicada es qué tipo de encabezado Content-Type debemos
establecer al devolver el contenido de un archivo. Dado que estos archivos
podrían ser cualquier cosa, nuestro servidor no puede simplemente devolver el
mismo tipo de contenido para todos ellos. npm puede ayudarnos nuevamente
aquí. El paquete mime-types (los indicadores de tipo de contenido como text
/plain también se llaman tipos MIME) conoce el tipo correcto para una gran
cantidad de extensiones de archivo.
El siguiente comando de npm, en el directorio donde reside el script del servi-
dor, instala una versión específica de mime:
$ npm install mime-types@2.1.0
Cuando un archivo solicitado no existe, el código de estado HTTP correcto a
devolver es 404. Utilizaremos la función stat, que busca información sobre un
archivo, para averiguar tanto si el archivo existe como si es un directorio.
import {createReadStream} from "node:fs";
import {stat, readdir} from "node:fs/promises";
import {lookup} from "mime-types";
methods.GET = async function(request) {
let path = urlPath(request.url);
let stats;
try {
stats = await stat(path);
364

-- 376 of 445 --

} catch (error) {
if (error.code != "ENOENT") throw error;
else return {status: 404, body: "Archivo no encontrado"};
}
if (stats.isDirectory()) {
return {body: (await readdir(path)).join("\n")};
} else {
return {body: createReadStream(path),
type: lookup(path)};
}
};
Debido a que debe acceder al disco y por lo tanto podría llevar algún tiempo,
stat es asíncrono. Dado que estamos utilizando promesas en lugar del estilo de
devolución de llamada, debe ser importado desde node:fs/promises en lugar
de directamente desde node:fs.
Cuando el archivo no existe, stat lanzará un objeto de error con una propiedad
code de "ENOENT". Estos códigos algo oscuros, inspirados en Unix, son la forma
en que se reconocen los tipos de error en Node.
El objeto stats devuelto por stat nos indica varias cosas sobre un archivo,
como su tamaño (propiedad size) y su fecha de modificación (mtime). Aquí
nos interesa saber si es un directorio o un archivo regular, lo cual nos dice el
método isDirectory.
Usamos readdir para leer la matriz de archivos en un directorio y devolverla
al cliente. Para archivos normales, creamos un flujo de lectura con createReadStream
y lo devolvemos como cuerpo, junto con el tipo de contenido que nos propor-
ciona el paquete mime para el nombre del archivo.
El código para manejar las solicitudes DELETE es ligeramente más sencillo.
import {rmdir, unlink} from "node:fs/promises";
methods.DELETE = async function(request) {
let path = urlPath(request.url);
let stats;
try {
stats = await stat(path);
} catch (error) {
if (error.code != "ENOENT") throw error;
else return {status: 204};
}
if (stats.isDirectory()) await rmdir(path);
else await unlink(path);
return {status: 204};
};
365

-- 377 of 445 --

Cuando una respuesta HTTP no contiene datos, se puede usar el código de
estado 204 (“sin contenido”) para indicarlo. Dado que la respuesta a la elimi-
nación no necesita transmitir ninguna información más allá de si la operación
tuvo éxito, es sensato devolver eso aquí.
Es posible que te preguntes por qué intentar eliminar un archivo inexistente
devuelve un código de estado de éxito en lugar de un error. Cuando el archivo
que se está eliminando no está presente, se podría decir que el objetivo de la
solicitud ya se ha cumplido. El estándar HTTP nos anima a hacer solicitudes
idempotentes, lo que significa que hacer la misma solicitud varias veces produce
el mismo resultado que hacerla una vez. De cierta manera, si intentas eliminar
algo que ya no está, el efecto que intentabas lograr se ha alcanzado: la cosa ya
no está allí.
Este es el manejador para las solicitudes PUT:
import {createWriteStream} from "node:fs";
function pipeStream(from, to) {
return new Promise((resolve, reject) => {
from.on("error", reject);
to.on("error", reject);
to.on("finish", resolve);
from.pipe(to);
});
}```methods.PUT = async function(request) {
let path = urlPath(request.url);
await pipeStream(request, createWriteStream(path));
return {status: 204};
};
Esta vez no necesitamos verificar si el archivo existe; si lo hace, simplemente
lo sobrescribiremos. Nuevamente usamos pipe para mover datos de un flujo
legible a uno escribible, en este caso del request al archivo. Pero como pipe
no está diseñado para devolver una promesa, debemos escribir un contenedor,
pipeStream, que cree una promesa alrededor del resultado de llamar a pipe.
Cuando algo sale mal al abrir el archivo, createWriteStream seguirá de-
volviendo un flujo, pero ese flujo lanzará un evento de "error". El flujo del
request también puede fallar, por ejemplo si la red falla. Por lo tanto, conecta-
mos los eventos de "error" de ambos flujos para rechazar la promesa. Cuando
pipe haya terminado, cerrará el flujo de salida, lo que hará que lance un evento
de "finalización". En ese momento podemos resolver la promesa con éxito
(devolviendo nada).
El script completo del servidor está disponible en https://eloquentjavascript.net/
366

-- 378 of 445 --

code/file_server.mjs. Puedes descargarlo y, después de instalar sus dependen-
cias, ejecutarlo con Node para iniciar tu propio servidor de archivos. Y, por
supuesto, puedes modificarlo y ampliarlo para resolver los ejercicios de este
capítulo o para experimentar.
La herramienta de línea de comandos curl, ampliamente disponible en sis-
temas Unix (como macOS y Linux), se puede utilizar para hacer solicitudes
HTTP. La siguiente sesión prueba brevemente nuestro servidor. La opción -X
se usa para establecer el método de la solicitud, y -d se utiliza para incluir un
cuerpo de solicitud.
$ curl http://localhost:8000/file.txt
Archivo no encontrado
$ curl -X PUT -d CONTENIDO http://localhost:8000/file.txt
$ curl http://localhost:8000/file.txt