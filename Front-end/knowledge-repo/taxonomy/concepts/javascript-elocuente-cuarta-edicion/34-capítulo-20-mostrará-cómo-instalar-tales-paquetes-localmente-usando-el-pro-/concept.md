# Capítulo 20: mostrará cómo instalar tales paquetes localmente usando el pro-

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 34)

## Contenido
# Capítulo 20: mostrará cómo instalar tales paquetes localmente usando el pro-

grama de línea de comandos npm.
Tener paquetes de calidad disponibles para descargar es extremadamente
valioso. Significa que a menudo podemos evitar reinventar un programa que
100 personas han escrito antes y obtener una implementación sólida y bien
169

-- 181 of 445 --

probada con solo presionar algunas teclas.
El software es barato de copiar, por lo que una vez que alguien lo ha escrito,
distribuirlo a otras personas es un proceso eficiente. Pero escribirlo en primer
lugar es trabajo, y responder a las personas que han encontrado problemas en
el código, o que desean proponer nuevas características, es incluso más trabajo.
Por defecto, eres el propietario de los derechos de autor del código que es-
cribes, y otras personas solo pueden usarlo con tu permiso. Pero porque algu-
nas personas son amables y porque publicar buen software puede ayudarte a
volverte un poco famoso entre los programadores, muchos paquetes se publican
bajo una licencia que permite explícitamente a otras personas usarlo.
La mayoría del código en NPM tiene esta licencia. Algunas licencias re-
quieren que también publiques el código que construyes sobre el paquete bajo la
misma licencia. Otros son menos exigentes, simplemente requiriendo que man-
tengas la licencia con el código al distribuirlo. La comunidad de JavaScript
mayormente utiliza este último tipo de licencia. Al usar paquetes de otras
personas, asegúrate de estar al tanto de su licencia.
Ahora, en lugar de escribir nuestro propio analizador de archivos INI, pode-
mos usar uno de NPM.
import {parse} from "ini";
console.log(parse("x = 10\ny = 20"));
// → {x: "10", y: "20"}
Módulos CommonJS
Antes de 2015, cuando el lenguaje de JavaScript no tenía un sistema de módu-
los integrado real, las personas ya estaban construyendo sistemas grandes en
JavaScript. Para que funcionara, ellos necesitaban módulos.
La comunidad diseñó sus propios sistemas de módulos improvisados sobre el
lenguaje. Estos utilizan funciones para crear un alcance local para los módulos
y objetos regulares para representar interfaces de módulos.
Inicialmente, las personas simplemente envolvían manualmente todo su mó-
dulo en una “expresión de función invocada inmediatamente” para crear el
alcance del módulo, y asignaban sus objetos de interfaz a una única variable
global.
const semana = function() {
const nombres = ["Domingo", "Lunes", "Martes", "Miércoles",
"Jueves", "Viernes", "Sábado"];
return {
170

-- 182 of 445 --

nombre(numero) { return nombres[numero]; },
numero(nombre) { return nombres.indexOf(nombre); }
};
}();
console.log(semana.nombre(semana.numero("Domingo")));
// → Domingo
Este estilo de módulos proporciona aislamiento, hasta cierto punto, pero no
declara dependencias. En cambio, simplemente coloca su interfaz en el ámbito
global y espera que sus dependencias, si las tiene, hagan lo mismo. Esto no es
ideal.
Si implementamos nuestro propio cargador de módulos, podemos hacerlo
mejor. El enfoque más ampliamente utilizado para los módulos de JavaScript
agregados se llama Módulos CommonJS. Node.js lo utilizaba desde el princi-
pio (aunque ahora también sabe cómo cargar módulos ES) y es el sistema de
módulos utilizado por muchos paquetes en NPM.
Un módulo CommonJS se ve como un script regular, pero tiene acceso a
dos enlaces que utiliza para interactuar con otros módulos. El primero es una
función llamada require. Cuando llamas a esto con el nombre del módulo
de tu dependencia, se asegura de que el módulo esté cargado y devuelve su
interfaz. El segundo es un objeto llamado exports, que es el objeto de interfaz
para el módulo. Comienza vacío y agregas propiedades para definir los valores
exportados.
Este módulo de ejemplo CommonJS proporciona una función de formateo
de fechas. Utiliza dos packages de NPM: ordinal para convertir números en
strings como "1st" y "2nd", y date-names para obtener los nombres en inglés
de los días de la semana y los meses. Exporta una única función, formatDate,
que recibe un objeto Date y una cadena template.
La cadena de template puede contener códigos que indican el formato, como
YYYY para el año completo y Do para el día ordinal del mes. Puede pasársele una
cadena como "MMMM Do YYYY" para obtener una salida como “22 de noviembre
de 2017”.
const ordinal = require("ordinal");
const {days, months} = require("date-names");
exports.formatDate = function(date, format) {
return format.replace(/YYYY|M(MMM)?|Do?|dddd/g, tag => {
if (tag == "YYYY") return date.getFullYear();
if (tag == "M") return date.getMonth();
if (tag == "MMMM") return months[date.getMonth()];
171

-- 183 of 445 --

if (tag == "D") return date.getDate();
if (tag == "Do") return ordinal(date.getDate());
if (tag == "dddd") return days[date.getDay()];
});
};
La interfaz de ordinal es una única función, mientras que date-names exporta
un objeto que contiene múltiples cosas: days y months son arrays de nombres.
La técnica de desestructurac
