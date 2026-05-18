# módulo i: ntegrado del sistema de archivos de Node. E importar "robot" podría

intentar cargar la biblioteca encontrada en node_modules/robot/. Una forma
común de instalar estas bibliotecas es usando NPM, a lo cual volveremos en un
momento.
Configuremos un proyecto pequeño que consta de dos archivos. El primero,
llamado main.mjs, define un script que puede ser llamado desde la línea de
comandos para revertir una cadena.
import {reverse} from "./reverse.mjs";
354

-- 366 of 445 --

// El índice 2 contiene el primer argumento real de la línea de
comandos
let argument = process.argv[2];
console.log(reverse(argument));
El archivo reverse.mjs define una biblioteca para revertir cadenas, que puede
ser utilizada tanto por esta herramienta de línea de comandos como por otros
scripts que necesiten acceso directo a una función para revertir cadenas.
export function reverse(string) {
return Array.from(string).reverse().join("");
}
Recuerda que export se utiliza para declarar que un enlace es parte de la
interfaz del módulo. Eso permite que main.mjs importe y utilice la función.
Ahora podemos llamar a nuestra herramienta de esta manera:
$ node main.mjs JavaScript
tpircSavaJ
Instalando con NPM
NPM, que fue introducido en el Capítulo 10, es un repositorio en línea de
módulos de JavaScript, muchos de los cuales están escritos específicamente
para Node. Cuando instalas Node en tu computadora, también obtienes el
comando npm, que puedes usar para interactuar con este repositorio.
El uso principal de NPM es descargar paquetes. Vimos el paquete ini en el