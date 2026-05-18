# parte d: el patrón falle, el coincidente retrocede un carácter y vuelve a intentar

desde ahí. En el ejemplo, el coincidente intenta primero coincidir con el resto
completo de la cadena y luego retrocede desde allí. Encontrará una ocurrencia
de */ después de retroceder cuatro caracteres y coincidirá con eso. Esto no es
lo que queríamos, la intención era coincidir con un único comentario, no llegar
hasta el final del código y encontrar el final del último comentario de bloque.
Debido a este comportamiento, decimos que los operadores de repetición (+,
*, ?, y {}) son avariciosos, lo que significa que coinciden con todo lo que pueden
y retroceden desde allí. Si colocas un signo de interrogación después de ellos
(+?, *?, ??, {}?), se vuelven no avariciosos y comienzan coincidiendo con la
menor cantidad posible, coincidiendo más solo cuando el patrón restante no
encaja con la coincidencia más pequeña.
Y eso es exactamente lo que queremos en este caso. Al hacer que el asterisco
coincida con la menor cantidad de caracteres que nos lleva a */, consumimos
un comentario de bloque y nada más.
function stripComments(code) {
return code.replace(/\/\/.*|\/\*[^]*?\*\//g, "");
}
console.log(stripComments("1 /* a */+/* b */ 1"));
// → 1 + 1
Muchos errors en programas de expresión regular pueden rastrearse hasta el
uso no intencionado de un operador avaricioso donde uno no avaricioso fun-
cionaría mejor. Cuando uses un operador de repetición, prefiere la variante no
avariciosa.
Creación dinámica de objetos RegExp
Hay casos en los que es posible que no sepas el patrón exacto que necesitas
para hacer coincidir cuando estás escribiendo tu código. Digamos que quieres
probar el nombre de usuario en un fragmento de texto. Puedes construir una
cadena y usar el constructor RegExp en ello. Aquí tienes un ejemplo:
let name = "harry";
156

-- 168 of 445 --

let regexp = new RegExp("(^|\\s)" + name + "($|\\s)", "gi");
console.log(regexp.test("Harry es un personaje dudoso."));
// → true
Al crear la parte \s de la cadena, tenemos que usar dos barras invertidas porque
las estamos escribiendo en una cadena normal, no en una expresión regular entre
barras. El segundo argumento del constructor RegExp contiene las opciones para
la expresión regular, en este caso, "gi" para global e insensible a mayúsculas y
minúsculas.
Pero ¿qué pasa si el nombre es "dea+hl[]rd" porque nuestro usuario es un
adolescente nerd? Eso resultaría en una expresión regular absurda que en
realidad no coincidiría con el nombre del usuario.
Para solucionar esto, podemos agregar barras invertidas antes de cualquier
carácter que tenga un significado especial.
let name = "dea+hl[]rd";
let escaped = name.replace(/[\\[.+*?(){|^$]/g, "\\$&");
let regexp = new RegExp("(^|\\s)" + escaped + "($|\\s)",
"gi");
let text = "Este chico dea+hl[]rd es súper molesto.";
console.log(regexp.test(text));
// → true
El método search
El método indexOf en las cadenas no puede ser llamado con una expresión
regular. Pero hay otro método, search, que espera una expresión regular. Al
igual que indexOf, devuelve el primer índice en el que se encontró la expresión,
o -1 cuando no se encontró.
console.log(" palabra".search(/\S/));
// → 2
console.log(" ".search(/\S/));
// → -1
Desafortunadamente, no hay una forma de indicar que la coincidencia debería
comenzar en un offset dado (como se puede hacer con el segundo argumento
de indexOf), lo cual a menudo sería útil.
157

-- 169 of 445 --

La propiedad lastIndex
El método exec de manera similar no proporciona una forma conveniente de
comenzar a buscar desde una posición dada en la cadena. Pero sí proporciona
una forma inconveniente.
Los objetos de expresión regular tienen propiedades. Una de esas propiedades
es source, que contiene la cadena de la que se creó la expresión. Otra propiedad
es lastIndex, que controla, en algunas circunstancias limitadas, desde dónde
comenzará la siguiente coincidencia.
Estas circunstancias implican que la expresión regular debe tener la opción
global (g) o pegajosa (y) activada, y la coincidencia debe ocurrir a través del
método exec. Nuevamente, una solución menos confusa habría sido simple-
mente permitir que se pase un argumento adicional a exec, pero la confusión es
una característica esencial de la interfaz de expresiones regulares de JavaScript.
let pattern = /y/g;
pattern.lastIndex = 3;
let match = pattern.exec("xyzzy");
console.log(match.index);
// → 4
console.log(pattern.lastIndex);
// → 5
Si la coincidencia tuvo éxito, la llamada a exec actualiza automáticamente la
propiedad lastIndex para que apunte después de la coincidencia. Si no se
encontró ninguna coincidencia, lastIndex se restablece a cero, que es también
el valor que tiene en un objeto de expresión regular recién construido.
La diferencia entre las opciones global y sticky es que, cuando se habilita
sticky, la coincidencia solo se producirá si comienza directamente en lastIndex
, mientras que con global se buscará una posición donde pueda comenzar una
coincidencia.
let global = /abc/g;
console.log(global.exec("xyz abc"));
// → ["abc"]
let sticky = /abc/y;
console.log(sticky.exec("xyz abc"));
// → null
Al usar un valor de expresión regular compartido para múltiples llamadas a
exec, estas actualizaciones automáticas a la propiedad lastIndex pueden causar
problemas. Es posible que tu expresión regular comience accidentalmente en
un índice que quedó de una llamada previa.
158

-- 170 of 445 --

let digit = /\d/g;
console.log(digit.exec("aquí está: 1"));
// → ["1"]
console.log(digit.exec("ahora: 1"));
// → null
Otro efecto interesante de la opción global es que cambia la forma en que
funciona el método match en las cadenas. Cuando se llama con una expresión
global, en lugar de devolver una matriz similar a la devuelta por exec, match
encontrará todas las coincidencias del patrón en la cadena y devolverá una
matriz que contiene las cadenas coincidentes.
console.log("Banana".match(/an/g));
// → ["an", "an"]
Así que ten cuidado con las expresiones regulares globales. Los casos en los que
son necesarias, como las llamadas a replace y los lugares donde quieres usar
explícitamente lastIndex, son típicamente los únicos lugares donde las deseas
utilizar.
Obteniendo todas las coincidencias
Algo común que se hace es encontrar todas las coincidencias de una expresión
regular en una cadena. Podemos hacer esto usando el método matchAll.
let input = "Una cadena con 3 números... 42 y 88.";
let matches = input.matchAll(/\d+/g);
for (let match of matches) {
console.log("Encontrado", match[0], "en", match.index);
}
// → Encontrado 3 en 14
// Encontrado 42 en 33
// Encontrado 88 en 40
Este método devuelve una matriz de matrices de coincidencias. La expresión
regular que se le proporciona debe tener g habilitado.
Analizando un archivo INI
Para concluir el capítulo, analizaremos un problema que requiere expresiones
regulares. Imagina que estamos escribiendo un programa para recopilar au-
tomáticamente información sobre nuestros enemigos desde Internet. (En re-
alidad, no escribiremos ese programa aquí, solo la parte que lee el archivo de
configuración. Lo siento.) El archivo de configuración se ve así:
159

-- 171 of 445 --

motorbusqueda=https://duckduckgo.com/?q=$1
rencor=9.7
; comentarios precedidos por un punto y coma...
; cada sección se refiere a un enemigo individual
[larry]
fullname=Larry Doe
type=matón de jardín de infantes
website=http://www.geocities.com/CapeCanaveral/11451
[davaeorn]
fullname=Davaeorn
type=mago malvado
outputdir=/home/marijn/enemies/davaeorn
Las reglas exactas para este formato (que es un formato ampliamente utilizado,
generalmente llamado un archivo INI ) son las siguientes:
• Las líneas en blanco y las líneas que comienzan con punto y coma son
ignoradas.
• Las líneas envueltas en [ y ] inician una nueva sección.
• Las líneas que contienen un identificador alfanumérico seguido de un car-
acter = agregan una configuración a la sección actual.
• Cualquier otra cosa es inválida.
Nuestra tarea es convertir una cadena como esta en un objeto cuyas propiedades
contienen cadenas para las configuraciones escritas antes del primer encabezado
de sección y subobjetos para las secciones, con esos subobjetos conteniendo las
configuraciones de la sección.
Dado que el formato debe procesarse línea por línea, dividir el archivo en
líneas separadas es un buen comienzo. Vimos el método split en el Capítulo