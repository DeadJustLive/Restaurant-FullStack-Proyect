# Capítulo 10: , podría tener un archivo package.json como este:

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 63)

## Contenido
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
El módulo node:fs/promi
