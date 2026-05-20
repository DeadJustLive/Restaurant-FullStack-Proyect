# tema c: omo Node. Es uno de los pocos lenguajes de programación que no tiene

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 60)

## Contenido
# tema c: omo Node. Es uno de los pocos lenguajes de programación que no tiene

una forma incorporada de manejar la entrada y salida. Por lo tanto, JavaScript
podría adaptarse al enfoque algo excéntrico de Node para la programación de
red y sistemas de archivos sin terminar con dos interfaces inconsistentes. En
2009, cuando se diseñaba Node, la gente ya estaba realizando programación
352

-- 364 of 445 --

basada en callbacks en el navegador, por lo que la comunidad alrededor del
lenguaje estaba acostumbrada a un estilo de programación asincrónica.
El comando node
Cuando Node.js está instalado en un sistema, proporciona un programa llamado
node, que se utiliza para ejecutar archivos de JavaScript. Supongamos que
tienes un archivo hello.js, que contiene este código:
let message = "Hola mundo";
console.log(message);
Luego puedes ejecutar node desde la línea de comandos de la siguiente manera
para ejecutar el programa:
$ node hello.js
Hola mundo
El método console.log en Node hace algo similar a lo que hace en el navegador.
Imprime un texto. Pero en Node, el texto irá al flujo de salida estándar del
proceso, en lugar de ir a la consola de JavaScript de un navegador. Al ejecutar
node desde la línea de comandos, significa que verás los valores registrados en
tu terminal.
Si ejecutas node sin proporcionarle un archivo, te proporcionará un indicador
en el que puedes escribir código JavaScript y ver inmediatamente el resultado.
$ node
> 1 + 1
2
> [-1, -2, -3].map(Math.abs)
[1, 2, 3]
> process.exit(0)
$
El enlace process, al igual que el enlace console, está disponible globalmente
en Node. Proporciona varias formas de inspeccionar y manipular el programa
actual. El método exit finaliza el proceso y puede recibir un código de estado
de salida, que le indica al programa que inició node (en este caso, la shell de
línea de comandos) si el programa se completó correctamente (código cero) o
si se encontró un error (cualquier otro código).
Para encontrar los argumentos de línea de comandos dados a tu script, puedes
leer process.argv, que es un array de cadenas. Ten en cuenta que también in-
cluye el nombre del comando node y el nombre de tu script, por lo que los argu-
353

-- 365 of 445 --

mentos reales comienzan en el índice 2. Si showargv.js contiene la instrucción
console.log(process.argv), podrías ejecutarlo de la siguiente manera:
$ node showargv.js one --and two
["node", "/tmp/showargv.js", "one", "--and", "two"]
Todos los enlaces globales de JavaScript estándar, como Array, Math y JSON,
también están presentes en el entorno de Node. La funcionalidad relacionada
con el navegador, como document o prompt, no lo está.
Módulos
Además de los enlaces que mencioné, como console y process, Node agrega
pocos enlaces adicionales en el ámbito global. Si deseas acceder a funcionali-
dades integradas, debes solicitarlas al sistema de módulos.
Node comenzó utilizando el sistema de módulos CommonJS, basado en la
función require, que vimos en el Capítulo 10. Aún utilizará este sistema de
forma predeterminada cuando cargues un archivo .js.
Pero también soporta el sistema de módulos ES más moderno. Cuando el
nombre de un script termina en .mjs, se considera que es un módulo de este
tipo, y puedes usar import y export en él (pero no require). Utilizaremos
módulos ES en este capítulo.
Cuando se importa un módulo, ya sea con require o import, Node debe
resolver la cadena proporcionada a un archivo real que pueda cargar. Los
nombres que comienzan con /, ./ o ../ se resuelven como archivos, relativos
a la ruta del módulo actual. Aquí, . representa el directorio actual, ../ para
un directorio arriba, y / para la raíz del sistema de archivos. Por lo tanto, si
solicitas "./graph.mjs" desde el archivo /tmp/robot/robot.mjs, Node intentará
cargar el archivo /tmp/robot/graph.mjs.
Cuando se importa una cadena que no parece una ruta relativa o absoluta,
se asume que se refiere a un módulo integrado o un módulo instalado en un
directorio node_modules. Por ejemplo, importar desde "node:fs" te dará el
