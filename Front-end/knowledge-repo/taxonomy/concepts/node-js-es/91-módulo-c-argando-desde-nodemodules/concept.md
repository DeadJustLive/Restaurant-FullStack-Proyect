# Módulo c: argando desde node_modules

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 91)

## Contenido
# Módulo c: argando desde node_modules

Los módulos pueden require d sin usar rutas relativas colocándolos en un directorio especial
llamado node_modules .
Por ejemplo, para require un módulo llamado foo desde un archivo index.js , puede usar la
siguiente estructura de directorios:
index.js
\- node_modules
\- foo
|- foo.js
\- package.json
Los módulos se deben colocar dentro de un directorio, junto con un archivo package.json . El
campo main del archivo package.json debe apuntar al punto de entrada de su módulo: este es el
archivo que se importa cuando los usuarios lo require('your-module') . main valores
predeterminados main index.js si no se proporcionan. Como alternativa, puede hacer referencia a
los archivos relativos a su módulo, simplemente añadiendo el recorrido relativo al require llamada:
require('your-module/path/to/file') .
Los módulos también pueden require desde los directorios de node_modules hasta la jerarquía del
sistema de archivos. Si tenemos la siguiente estructura de directorios:
my-project
\- node_modules
https://riptutorial.com/es/home 178

-- 206 of 423 --

|- foo // the foo module
\- ...
\- baz // the baz module
\- node_modules
\- bar // the bar module
podremos require el módulo foo desde cualquier archivo dentro de la bar usando require('foo') .
Tenga en cuenta que el nodo solo coincidirá con el módulo más cercano al archivo en la jerarquía
del sistema de archivos, comenzando desde (el directorio actual del archivo / node_modules). El
nodo coincide con los directorios de esta manera hasta la raíz del sistema de archivos.
Puede instalar nuevos módulos desde el registro npm u otros registros npm, o puede crear los
suyos propios.
Carpeta como modulo
Los módulos se pueden dividir en muchos archivos .js en la misma carpeta. Un ejemplo en una
carpeta my_module :
function_one.js
module.exports = function() {
return 1;
}
function_two.js
module.exports = function() {
return 2;
}
index.js
exports.f_one = require('./function_one.js');
exports.f_two = require('./function_two.js');
Un módulo como este se usa refiriéndose a él por el nombre de la carpeta:
var split_module = require('./my_module');
Tenga en cuenta que si lo requirió omitiendo ./ o cualquier indicación de una ruta a una carpeta
desde el argumento de la función requerida, Node intentará cargar un módulo desde la carpeta
node_modules .
Alternativamente, puede crear en la misma carpeta un archivo package.json con estos contenidos:
{
"name": "my_module",
"main": "./your_main_entry_point.js"
https://riptutorial.com/es/home 179

-- 207 of 423 --

}
De esta manera, no es necesario que nombre el archivo de módulo principal "índice".
Lea Exportando y consumiendo módulos en línea: https://riptutorial.com/es/node-
js/topic/547/exportando-y-consumiendo-modulos
https://riptutorial.com/es/home 180

-- 208 of 423 --
