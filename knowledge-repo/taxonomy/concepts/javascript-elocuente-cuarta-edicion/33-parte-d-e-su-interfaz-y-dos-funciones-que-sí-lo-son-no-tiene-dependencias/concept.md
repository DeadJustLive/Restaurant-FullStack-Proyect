# parte d: e su interfaz y dos funciones que sí lo son. No tiene dependencias.

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 33)

## Contenido
# parte d: e su interfaz y dos funciones que sí lo son. No tiene dependencias.

const names = ["Domingo", "Lunes", "Martes", "Miércoles",
"Jueves", "Viernes", "Sábado"];
export function dayName(number) {
return names[number];
}
export function dayNumber(name) {
return names.indexOf(name);
}
La palabra clave export se puede colocar delante de una función, clase o defini-
167

-- 179 of 445 --

ción de vinculación para indicar que esa vinculación es parte de la interfaz del
módulo. Esto permite que otros módulos utilicen esa vinculación importándola.
import {dayName} from "./dayname.js";
let ahora = new Date();
console.log(`Hoy es ${dayName(ahora.getDay())}`);
// → Hoy es Lunes
La palabra clave import, seguida de una lista de nombres de vinculación entre
llaves, hace que las vinculaciones de otro módulo estén disponibles en el módulo
actual. Los módulos se identifican por cadenas entre comillas.
Cómo se resuelve un nombre de módulo a un programa real difiere según
la plataforma. El navegador los trata como direcciones web, mientras que
Node.js los resuelve a archivos. Para ejecutar un módulo, se cargan todos los
demás módulos en los que depende, y las vinculaciones exportadas se ponen a
disposición de los módulos que las importan.
Las declaraciones de importación y exportación no pueden aparecer dentro
de funciones, bucles u otros bloques. Se resuelven de inmediato cuando se carga
el módulo, independientemente de cómo se ejecute el código en el módulo, y
para reflejar esto, deben aparecer solo en el cuerpo del módulo externo.
Así que la interfaz de un módulo consiste en una colección de vinculaciones
con nombres, a las cuales tienen acceso otros módulos que dependen de el-
las. Las vinculaciones importadas se pueden renombrar para darles un nuevo
nombre local utilizando as después de su nombre.
import {dayName as nomDeJour} from "./dayname.js";
console.log(nomDeJour(3));
// → Miércoles
También es posible que un módulo tenga una exportación especial llamada
default, que a menudo se usa para módulos que solo exportan un único enlace.
Para definir una exportación predeterminada, se escribe export default antes
de una expresión, una declaración de función o una declaración de clase.
export default ["Invierno", "Primavera", "Verano", "Otoño"];
Este enlace se importa omitiendo las llaves alrededor del nombre de la im-
portación.
import nombresEstaciones from "./nombrsestaciones.js";
168

-- 180 of 445 --

Paquetes
Una de las ventajas de construir un programa a partir de piezas separadas y
poder ejecutar algunas de esas piezas por separado, es que puedes aplicar la
misma pieza en diferentes programas.
Pero, ¿cómo se configura esto? Digamos que quiero usar la función parseINI
de Capítulo 9 en otro programa. Si está claro de qué depende la función (en
este caso, nada), puedo simplemente copiar ese módulo en mi nuevo proyecto y
usarlo. Pero luego, si encuentro un error en el código, probablemente lo corrija
en el programa con el que estoy trabajando en ese momento y olvide corregirlo
también en el otro programa.
Una vez que empieces a duplicar código, rápidamente te darás cuenta de que
estás perdiendo tiempo y energía moviendo copias y manteniéndolas actual-
izadas.
Ahí es donde entran los paquetes. Un paquete es un fragmento de código que
se puede distribuir (copiar e instalar). Puede contener uno o más módulos y
tiene información sobre en qué otros paquetes depende. Un paquete también
suele venir con documentación que explica qué hace para que las personas que
no lo escribieron aún puedan usarlo.
Cuando se encuentra un problema en un paquete o se añade una nueva
característica, se actualiza el paquete. Ahora los programas que dependen
de él (que también pueden ser paquetes) pueden copiar la nueva versión para
obtener las mejoras que se hicieron en el código.
Trabajar de esta manera requiere infraestructura. Necesitamos un lugar
para almacenar y encontrar paquetes y una forma conveniente de instalar y
actualizarlos. En el mundo de JavaScript, esta infraestructura es provista por
NPM (https://npmjs.org).
NPM es dos cosas: un servicio en línea donde puedes descargar (y subir)
paquetes y un programa (incluido con Node.js) que te ayuda a instalar y ges-
tionarlos.
En el momento de la escritura, hay más de tres millones de paquetes difer-
entes disponibles en NPM. Una gran parte de ellos son basura, para ser honesto.
Pero casi cada paquete de JavaScript útil y disponible públicamente se puede
encontrar en NPM. Por ejemplo, un analizador de archivos INI, similar al que
construimos en el Capítulo 9, está disponible bajo el nombre del paquete ini.
