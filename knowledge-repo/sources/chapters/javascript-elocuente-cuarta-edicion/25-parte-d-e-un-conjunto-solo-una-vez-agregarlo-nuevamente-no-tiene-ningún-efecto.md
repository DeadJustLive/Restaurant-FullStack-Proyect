# parte d: e un conjunto solo una vez: agregarlo nuevamente no tiene ningún efecto.

Escribe una clase llamada Group (ya que Set está siendo utilizado). Al igual
que Set, tiene los métodos add, delete y has. Su constructor crea un grupo
vacío, add agrega un valor al grupo (pero solo si aún no es miembro), delete
elimina su argumento del grupo (si era miembro), y has devuelve un valor
booleano que indica si su argumento es miembro del grupo.
Usa el operador ===, o algo equivalente como indexOf, para determinar si
dos valores son iguales.
Dale a la clase un método estático from que tome un objeto iterable como
argumento y cree un grupo que contenga todos los valores producidos al iterar
sobre él.
Grupos iterables
Haz que la clase Group del ejercicio anterior sea iterable. Refiérete a la sección
sobre la interfaz del iterador anteriormente en el capítulo si no tienes claro la
forma exacta de la interfaz.
Si utilizaste un array para representar los miembros del grupo, no devuelvas
simplemente el iterador creado al llamar al método Symbol.iterator en el array.
114

-- 126 of 445 --

Eso funcionaría, pero va en contra del propósito de este ejercicio.
Está bien si tu iterador se comporta de manera extraña cuando el grupo se
modifica durante la iteración.
115

-- 127 of 445 --

“[...] la pregunta de si las Máquinas Pueden Pensar [...] es tan
relevante como la pregunta de si los Submarinos Pueden Nadar.”
—Edsger Dijkstra, Las amenazas a la ciencia informática
Chapter 7
Proyecto: Un Robot
En los capítulos del “proyecto”, dejaré de golpearte con nueva teoría por un
breve momento, y en su lugar trabajaremos en un programa juntos. La teoría
es necesaria para aprender a programar, pero leer y entender programas reales
es igual de importante.
Nuestro proyecto en este capítulo es construir un autómata, un pequeño
programa que realiza una tarea en un mundo virtual. Nuestro autómata será
un robot de entrega de correo que recoge y deja paquetes.
Meadowfield
El pueblo de Meadowfield no es muy grande. Consiste en 11 lugares con 14
carreteras entre ellos. Se puede describir con este array de carreteras:
const roads = [
"Casa de Alice-Casa de Bob","Casa de Alice-Cabaña",
"Casa de Alice-Oficina de Correos","Casa de Bob-Ayuntamiento",
"Casa de Daria-Casa de Ernie","Casa de Daria-Ayuntamiento",
"Casa de Ernie-Casa de Grete","Casa de Grete-Granja",
"Casa de Grete-Tienda","Plaza de Mercado-Granja",
"Plaza de Mercado-Oficina de Correos","Plaza de Mercado-Tienda",
"Plaza de Mercado-Ayuntamiento","Tienda-Ayuntamiento"
];
116

-- 128 of 445 --

La red de carreteras en el pueblo forma un gráfico. Un gráfico es una colección
de puntos (lugares en el pueblo) con líneas entre ellos (carreteras). Este gráfico
será el mundo por el que se moverá nuestro robot.
El array de cadenas no es muy fácil de trabajar. Lo que nos interesa son los
destinos a los que podemos llegar desde un lugar dado. Vamos a convertir la
lista de carreteras en una estructura de datos que, para cada lugar, nos diga
qué se puede alcanzar desde allí.
function buildGraph(edges) {
let graph = Object.create(null);
function addEdge(from, to) {
if (from in graph) {
graph[from].push(to);
} else {
graph[from] = [to];
}
}
for (let [from, to] of edges.map(r => r.split("-"))) {
addEdge(from, to);
addEdge(to, from);
}
return graph;
}
const roadGraph = buildGraph(roads);
Dado un array de aristas, buildGraph crea un objeto de mapa que, para cada
nodo, almacena un array de nodos conectados.
117

-- 129 of 445 --

Utiliza el método split para pasar de las cadenas de carreteras, que tienen
la forma "Inicio-Fin", a arrays de dos elementos que contienen el inicio y el
fin como cadenas separadas.
La tarea
Nuestro robot se moverá por el pueblo. Hay paquetes en varios lugares, cada
uno dirigido a algún otro lugar. El robot recoge los paquetes cuando llega a
ellos y los entrega cuando llega a sus destinos.
El autómata debe decidir, en cada punto, hacia dónde ir a continuación.
Habrá terminado su tarea cuando todos los paquetes hayan sido entregados.
Para poder simular este proceso, debemos definir un mundo virtual que pueda
describirlo. Este modelo nos dice dónde está el robot y dónde están los paque-
tes. Cuando el robot decide moverse a algún lugar, necesitamos actualizar el
modelo para reflejar la nueva situación.
Si estás pensando en términos de programación orientada a objetos, tu primer
impulso podría ser empezar a definir objetos para los diferentes elementos en el
mundo: una clase para el robot, una para un paquete, tal vez una para lugares.
Estos podrían tener propiedades que describen su estado actual, como la pila
de paquetes en un lugar, que podríamos cambiar al actualizar el mundo.
Esto es incorrecto. Al menos, usualmente lo es. El hecho de que algo suene
como un objeto no significa automáticamente que deba ser un objeto en tu
programa. Escribir reflexivamente clases para cada concepto en tu aplicación
tiende a dejarte con una colección de objetos interconectados que tienen su
propio estado interno cambiable. Estos programas a menudo son difíciles de
entender y, por lo tanto, fáciles de romper.
En lugar de eso, vamos a condensar el estado del pueblo en el conjunto
mínimo de valores que lo define. Está la ubicación actual del robot y la colección
de paquetes no entregados, cada uno de los cuales tiene una ubicación actual
y una dirección de destino. Eso es todo.
Y mientras lo hacemos, hagamos que no cambiemos este estado cuando el
robot se mueve, sino que calculemos un nuevo estado para la situación después
del movimiento.
class VillageState {
constructor(place, parcels) {
this.place = place;
this.parcels = parcels;
}
move(destination) {
118

-- 130 of 445 --

if (!roadGraph[this.place].includes(destination)) {
return this;
} else {
let parcels = this.parcels.map(p => {
if (p.place != this.place) return p;
return {place: destination, address: p.address};
}).filter(p => p.place != p.address);
return new VillageState(destination, parcels);
}
}
}
El método move es donde ocurre la acción. Primero verifica si hay un camino
desde el lugar actual hasta el destino, y si no lo hay, devuelve el estado anterior
ya que este no es un movimiento válido.
Luego crea un nuevo estado con el destino como el nuevo lugar del robot.
Pero también necesita crear un nuevo conjunto de paquetes: los paquetes que
lleva el robot (que están en el lugar actual del robot) deben ser trasladados al
nuevo lugar. Y los paquetes dirigidos al nuevo lugar deben ser entregados, es
decir, deben ser eliminados del conjunto de paquetes no entregados. La llamada
a map se encarga del traslado y la llamada a filter de la entrega.
Los objetos de parcela no se modifican cuando se mueven, sino que se vuelven
a crear. El método move nos proporciona un nuevo estado de aldea pero deja
intacto por completo el anterior.
let first = new VillageState(
"Oficina de Correos",
[{place: "Oficina de Correos", address: "Casa de Alice"}]
);
let next = first.move("Casa de Alice");
console.log(next.place);
// → Casa de Alice
console.log(next.parcels);
// → []
console.log(first.place);
// → Oficina de Correos
El movimiento hace que la parcela se entregue, y esto se refleja en el siguiente
estado. Pero el estado inicial sigue describiendo la situación en la que el robot
está en la oficina de correos y la parcela no se ha entregado.
119

-- 131 of 445 --

Datos persistentes
Las estructuras de datos que no cambian se llaman inmutables o persistentes.
Se comportan de manera similar a las cadenas de texto y los números en el
sentido de que son lo que son y se mantienen así, en lugar de contener cosas
diferentes en momentos diferentes.
En JavaScript, casi todo puede cambiarse, por lo que trabajar con valores
que se supone que son persistentes requiere cierta moderación. Existe una
función llamada Object.freeze que cambia un objeto para que la escritura
en sus propiedades sea ignorada. Podrías usar esto para asegurarte de que tus
objetos no se modifiquen, si así lo deseas. Congelar requiere que la computadora
realice un trabajo adicional, y que las actualizaciones se ignoren es casi tan
propenso a confundir a alguien como hacer que hagan lo incorrecto. Por lo
tanto, suelo preferir simplemente decirle a las personas que un objeto dado no
debe ser modificado y esperar que lo recuerden.
let object = Object.freeze({value: 5});
object.value = 10;
console.log(object.value);
// → 5
¿Por qué me estoy esforzando tanto en no cambiar los objetos cuando el lenguaje
obviamente espera que lo haga?
Porque me ayuda a entender mis programas. Una vez más, esto se trata de
gestionar la complejidad. Cuando los objetos en mi sistema son cosas fijas y
estables, puedo considerar operaciones sobre ellos de forma aislada: moverse a
la casa de Alice desde un estado inicial dado siempre produce el mismo nuevo
estado. Cuando los objetos cambian con el tiempo, eso añade toda una nueva
dimensión de complejidad a este tipo de razonamiento.
Para un sistema pequeño como el que estamos construyendo en este capítulo,
podríamos manejar ese poco de complejidad extra. Pero el límite más impor-
tante respecto a qué tipo de sistemas podemos construir es cuánto podemos
entender. Cualquier cosa que haga que tu código sea más fácil de entender te
permite construir un sistema más ambicioso.
Desafortunadamente, aunque entender un sistema construido sobre estruc-
turas de datos persistentes es más fácil, diseñar uno, especialmente cuando tu
lenguaje de programación no ayuda, puede ser un poco más difícil. Buscaremos
oportunidades para usar estructuras de datos persistentes en este libro, pero
también usaremos aquellas que pueden cambiar.
120

-- 132 of 445 --

Simulación
Un robot de entrega observa el mundo y decide en qué dirección quiere moverse.
Como tal, podríamos decir que un robot es una función que toma un objeto
VillageState y devuelve el nombre de un lugar cercano.
Dado que queremos que los robots puedan recordar cosas, para que puedan
hacer y ejecutar planes, también les pasamos su memoria y les permitimos
devolver una nueva memoria. Por lo tanto, lo que un robot devuelve es un
objeto que contiene tanto la dirección en la que quiere moverse como un valor
de memoria que se le dará la próxima vez que se llame.
function runRobot(state, robot, memory) {
for (let turn = 0;; turn++) {
if (state.parcels.length == 0) {
console.log(`Terminado en ${turn} turnos`);
break;
}
let action = robot(state, memory);
state = state.move(action.direction);
memory = action.memory;
console.log(`Movido a ${action.direction}`);
}
}
Consideremos lo que un robot tiene que hacer para “resolver” un estado dado.
Debe recoger todos los paquetes visitando cada ubicación que tenga un paquete
y entregarlos visitando cada ubicación a la que esté dirigido un paquete, pero
solo después de recoger el paquete.
¿Cuál es la estrategia más tonta que podría funcionar? El robot podría
simplemente caminar en una dirección aleatoria en cada turno. Eso significa
que, con gran probabilidad, eventualmente se topará con todos los paquetes y
en algún momento también llegará al lugar donde deben ser entregados.
Esto es cómo podría lucir eso:
function randomPick(array) {
let choice = Math.floor(Math.random() * array.length);
return array[choice];
}
function randomRobot(state) {
return {direction: randomPick(roadGraph[state.place])};
}
Recuerda que Math.random() devuelve un número entre cero y uno, pero siem-
121

-- 133 of 445 --

pre por debajo de uno. Multiplicar dicho número por la longitud de un array
y luego aplicarle Math.floor nos da un índice aleatorio para el array.
Dado que este robot no necesita recordar nada, ignora su segundo argumento
(recuerda que las funciones de JavaScript pueden ser llamadas con argumen-
tos adicionales sin efectos adversos) y omite la propiedad memory en su objeto
devuelto.
Para poner a trabajar a este sofisticado robot, primero necesitaremos una
forma de crear un nuevo estado con algunos paquetes. Un método estático
(escrito aquí añadiendo directamente una propiedad al constructor) es un buen
lugar para poner esa funcionalidad.
VillageState.random = function(parcelCount = 5) {
let parcels = [];
for (let i = 0; i < parcelCount; i++) {
let address = randomPick(Object.keys(roadGraph));
let place;
do {
place = randomPick(Object.keys(roadGraph));
} while (place == address);
parcels.push({place, address});
}
return new VillageState("Oficina de Correos", parcels);
};
No queremos ningún paquete que sea enviado desde el mismo lugar al que está
dirigido. Por esta razón, el bucle do sigue eligiendo nuevos lugares cuando
obtiene uno que es igual a la dirección.
Vamos a iniciar un mundo virtual.
runRobot(VillageState.random(), randomRobot);
// → Movido a Mercado
// → Movido a Ayuntamiento
// →…
// → Terminado en 63 turnos
Al robot le lleva muchas vueltas entregar los paquetes porque no está planifi-
cando muy bien. Abordaremos eso pronto.
Ruta del camión de correo
Deberíamos poder hacerlo mucho mejor que el robot aleatorio. Una mejora
sencilla sería inspirarnos en la forma en que funciona la entrega de correo en el
mundo real. Si encontramos una ruta que pase por todos los lugares del pueblo,
122

-- 134 of 445 --

el robot podría recorrer esa ruta dos veces, momento en que se garantizaría que
ha terminado. Aquí tienes una de esas rutas (comenzando desde la oficina de
correos):
const mailRoute = [
"Casa de Alice", "Cabaña", "Casa de Alice", "Casa de Bob",
"Ayuntamiento", "Casa de Daria", "Casa de Ernie",
"Casa de Grete", "Tienda", "Casa de Grete", "Granja",
"Plaza del Mercado", "Oficina de Correos"
];
Para implementar el robot que sigue la ruta, necesitaremos hacer uso de la
memoria del robot. El robot guarda el resto de su ruta en su memoria y deja
caer el primer elemento en cada turno.
function routeRobot(state, memory) {
if (memory.length == 0) {
memory = mailRoute;
}
return {direction: memory[0], memory: memory.slice(1)};
}
Este robot es mucho más rápido ya. Tomará un máximo de 26 vueltas (el doble
de la ruta de 13 pasos) pero generalmente menos.
Búsqueda de caminos
Aún así, no llamaría a seguir ciegamente una ruta fija un comportamiento
inteligente. Sería más eficiente si el robot ajustara su comportamiento a la
tarea real que debe realizarse.
Para hacer eso, tiene que poder moverse deliberadamente hacia un paquete
dado o hacia la ubicación donde se debe entregar un paquete. Hacer eso, incluso
cuando el objetivo está a más de un movimiento de distancia, requerirá algún
tipo de función de búsqueda de ruta.
El problema de encontrar una ruta a través de un grafo es un problema
de búsqueda típico. Podemos determinar si una solución dada (una ruta) es
una solución válida, pero no podemos calcular directamente la solución como
podríamos hacerlo para 2 + 2. En su lugar, debemos seguir creando soluciones
potenciales hasta encontrar una que funcione.
El número de rutas posibles a través de un grafo es infinito. Pero al buscar
una ruta de A a B, solo estamos interesados en aquellas que comienzan en A.
Además, no nos importan las rutas que visiten el mismo lugar dos veces, esas
definitivamente no son las rutas más eficientes en ningún lugar. Así que eso
123

-- 135 of 445 --

reduce la cantidad de rutas que el buscador de rutas debe considerar.De hecho,
estamos mayormente interesados en la ruta más corta. Por lo tanto, queremos
asegurarnos de buscar rutas cortas antes de mirar las más largas. Un buen
enfoque sería “expandir” rutas desde el punto de inicio, explorando cada lugar
alcanzable que aún no haya sido visitado, hasta que una ruta llegue al objetivo.
De esta manera, solo exploraremos rutas que sean potencialmente interesantes,
y sabremos que la primera ruta que encontremos es la ruta más corta (o una
de las rutas más cortas, si hay más de una).
Aquí hay una función que hace esto:
function findRoute(graph, from, to) {
let work = [{at: from, route: []}];
for (let i = 0; i < work.length; i++) {
let {at, route} = work[i];
for (let place of graph[at]) {
if (place == to) return route.concat(place);
if (!work.some(w => w.at == place)) {
work.push({at: place, route: route.concat(place)});
}
}
}
}
La exploración debe realizarse en el orden correcto: los lugares que se alcan-
zaron primero deben explorarse primero. No podemos explorar de inmediato
un lugar tan pronto como lleguemos a él porque eso significaría que los lugares
alcanzados desde allí también se explorarían de inmediato, y así sucesivamente,
incluso si puede haber otros caminos más cortos que aún no se han explorado.
Por lo tanto, la función mantiene una lista de trabajo. Esta es una matriz
de lugares que deben ser explorados a continuación, junto con la ruta que nos
llevó allí. Comienza con solo la posición de inicio y una ruta vacía.
La búsqueda luego opera tomando el siguiente elemento en la lista y ex-
plorándolo, lo que significa que se ven todas las rutas que salen de ese lugar.
Si una de ellas es el objetivo, se puede devolver una ruta terminada. De lo
contrario, si no hemos mirado este lugar antes, se agrega un nuevo elemento
a la lista. Si lo hemos mirado antes, dado que estamos buscando rutas cor-
tas primero, hemos encontrado o bien una ruta más larga a ese lugar o una
exactamente tan larga como la existente, y no necesitamos explorarla.
Puedes imaginar visualmente esto como una red de rutas conocidas que se
extienden desde la ubicación de inicio, creciendo de manera uniforme en todos
los lados (pero nunca enredándose de nuevo en sí misma). Tan pronto como el
primer hilo alcance la ubicación objetivo, ese hilo se rastrea de vuelta al inicio,
124

-- 136 of 445 --

dándonos nuestra ruta.
Nuestro código no maneja la situación en la que no hay más elementos de
trabajo en la lista de trabajo porque sabemos que nuestro gráfico está conectado,
lo que significa que se puede llegar a cada ubicación desde todas las demás
ubicaciones. Siempre podremos encontrar una ruta entre dos puntos, y la
búsqueda no puede fallar.
function goalOrientedRobot({place, parcels}, route) {
if (route.length == 0) {
let parcel = parcels[0];
if (parcel.place != place) {
route = findRoute(roadGraph, place, parcel.place);
} else {
route = findRoute(roadGraph, place, parcel.address);
}
}
return {direction: route[0], memory: route.slice(1)};
}
Este robot utiliza el valor de su memoria como una lista de direcciones en las
que moverse, al igual que el robot que sigue la ruta. Cuando esa lista está
vacía, debe averiguar qué hacer a continuación. Toma el primer paquete no
entregado del conjunto y, si ese paquete aún no ha sido recogido, traza una
ruta hacia él. Si el paquete ya ha sido recogido, todavía necesita ser entregado,
por lo que el robot crea una ruta hacia la dirección de entrega.
Este robot suele terminar la tarea de entregar 5 paquetes en aproximada-
mente 16 turnos. Eso es ligeramente mejor que routeRobot pero definitivamente
no es óptimo.
Ejercicios
Medición de un robot
Es difícil comparar de manera objetiva los robots solo dejando que resuelvan
algunos escenarios. Tal vez un robot simplemente tuvo tareas más fáciles o el
tipo de tareas en las que es bueno, mientras que el otro no.
Escribe una función compareRobots que tome dos robots (y su memoria ini-
cial). Debería generar 100 tareas y permitir que cada uno de los robots resuelva
cada una de estas tareas. Cuando termine, debería mostrar el número promedio
de pasos que cada robot dio por tarea.
Por el bien de la equidad, asegúrate de darle a cada tarea a ambos robots,
en lugar de generar tareas diferentes por robot.
125

-- 137 of 445 --

Eficiencia del robot
¿Puedes escribir un robot que termine la tarea de entrega más rápido que
goalOrientedRobot? Si observas el comportamiento de ese robot, ¿qué cosas
claramente absurdas hace? ¿Cómo podrían mejorarse?
Si resolviste el ejercicio anterior, es posible que desees utilizar tu función
compareRobots para verificar si mejoraste el robot.
Grupo persistente
La mayoría de las estructuras de datos proporcionadas en un entorno estándar
de JavaScript no son muy adecuadas para un uso persistente. Los Arrays tienen
métodos slice y concat, que nos permiten crear fácilmente nuevos arrays sin
dañar el antiguo. Pero Set, por ejemplo, no tiene métodos para crear un nuevo
conjunto con un elemento añadido o eliminado.
Escribe una nueva clase PGroup, similar a la clase Grupo del Capítulo 6,
que almacena un conjunto de valores. Al igual que Grupo, tiene métodos add,
delete, y has.
Sin embargo, su método add debería devolver una nueva instancia de PGroup
con el miembro dado añadido y dejar la anterior sin cambios. De manera
similar, delete crea una nueva instancia sin un miembro dado.
La clase debería funcionar para valores de cualquier tipo, no solo para strings.
No tiene que ser eficiente cuando se utiliza con grandes cantidades de valores.
El constructor no debería ser parte de la interfaz de la clase (aunque defini-
tivamente querrás usarlo internamente). En su lugar, hay una instancia vacía,
PGroup.empty, que se puede usar como valor inicial.
¿Por qué necesitas solo un valor PGroup.empty, en lugar de tener una función
que cree un nuevo mapa vacío cada vez?
126

-- 138 of 445 --

“Depurar es el doble de difícil que escribir el código en primer lugar.
Por lo tanto, si escribes el código lo más ingeniosamente posible, por
definición, no eres lo suficientemente inteligente como para
depurarlo.”
—Brian Kernighan and P.J. Plauger, The Elements of Programming
Style
Chapter 8
Bugs y Errores
Las fallas en los programas de computadora generalmente se llaman bugs. Hace
que los programadores se sientan bien imaginarlos como pequeñas cosas que
simplemente se meten en nuestro trabajo. En realidad, por supuesto, nosotros
mismos los colocamos allí.
Si un programa es pensamiento cristalizado, puedes clasificar aproximada-
mente los errores en aquellos causados por pensamientos confusos y aquellos
causados por errores introducidos al convertir un pensamiento en código. El
primer tipo generalmente es más difícil de diagnosticar y arreglar que el último.
Lenguaje
Muchos errores podrían ser señalados automáticamente por la computadora,
si supiera lo suficiente sobre lo que estamos intentando hacer. Pero la laxitud
de JavaScript es un obstáculo aquí. Su concepto de enlaces y propiedades es
lo suficientemente vago como para rara vez atrapar typos antes de ejecutar
realmente el programa. E incluso entonces, te permite hacer algunas cosas
claramente absurdas sin quejarse, como calcular true * "monkey".
Hay algunas cosas sobre las que JavaScript sí se queja. Escribir un programa
que no siga la gramática del lenguaje hará que la computadora se queje de
inmediato. Otras cosas, como llamar a algo que no es una función o buscar
una propiedad en un valor undefined harán que se reporte un error cuando el
programa intente realizar la acción.
Pero a menudo, tu cálculo absurdo simplemente producirá NaN (no es un
número) o un valor indefinido, mientras que el programa continúa felizmente,
convencido de que está haciendo algo significativo. El error se manifestará solo
más tarde, después de que el valor falso haya pasado por varias funciones. Es
posible que no desencadene un error en absoluto, pero silenciosamente cause que
la salida del programa sea incorrecta. Encontrar la fuente de tales problemas
puede ser difícil.
127

-- 139 of 445 --

El proceso de encontrar errores—bugs—en los programas se llama depu-
ración.
Modo estricto
JavaScript puede ser un poco más estricto al habilitar el modo estricto. Esto
se hace colocando la cadena "use strict" en la parte superior de un archivo o
en el cuerpo de una función. Aquí tienes un ejemplo:
function canYouSpotTheProblem() {
"use strict";
for (counter = 0; counter < 10; counter++) {
console.log("Happy happy");
}
}
canYouSpotTheProblem();
// → ReferenceError: counter is not defined
Normalmente, cuando olvidas poner let frente a tu enlace, como en el caso
de counter en el ejemplo, JavaScript silenciosamente crea un enlace global y lo
utiliza. En modo estricto, se reporta un error en su lugar. Esto es muy útil. Sin
embargo, cabe mencionar que esto no funciona cuando el enlace en cuestión ya
existe en algún lugar del ámbito. En ese caso, el bucle seguirá sobrescribiendo
silenciosamente el valor del enlace.
Otro cambio en el modo estricto es que el enlace this mantiene el valor
undefined en funciones que no son llamadas como métodos. Al hacer una
llamada de este tipo fuera del modo estricto, this se refiere al objeto de ámbito
global, que es un objeto cuyas propiedades son los enlaces globales. Entonces,
si accidentalmente llamas incorrectamente a un método o constructor en modo
estricto, JavaScript producirá un error tan pronto como intente leer algo de
this, en lugar de escribir felizmente en el ámbito global.
Por ejemplo, considera el siguiente código, que llama a una función construc-
tor sin la palabra clave new para que su this no se refiera a un objeto recién
construido:
function Person(name) { this.name = name; }
let ferdinand = Person("Ferdinand"); // oops
console.log(name);
// → Ferdinand
Entonces, la llamada falsa a Person tuvo éxito pero devolvió un valor no definido
y creó el enlace global name. En modo estricto, el resultado es diferente.
128

-- 140 of 445 --

"use strict";
function Person(name) { this.name = name; }
let ferdinand = Person("Ferdinand"); // olvidó el new
// → TypeError: Cannot set property 'name' of undefined
Inmediatamente se nos informa que algo está mal. Esto es útil.
Afortunadamente, los constructores creados con la notación class siempre
mostrarán una queja si se llaman sin new, lo que hace que esto sea menos
problemático incluso en modo no estricto.
El modo estricto hace algunas cosas más. Prohíbe darle a una función múlti-
ples parámetros con el mismo nombre y elimina ciertas características prob-
lemáticas del lenguaje por completo (como la declaración with, que es tan
incorrecta que no se discute más en este libro).
En resumen, colocar "use strict" al principio de tu programa rara vez duele
y podría ayudarte a identificar un problema.
Tipos
Algunos lenguajes quieren saber los tipos de todos tus enlaces y expresiones
antes de ejecutar un programa. Te indicarán de inmediato cuando un tipo
se utiliza de manera inconsistente. JavaScript considera los tipos solo cuando
realmente se ejecuta el programa, e incluso allí a menudo intenta convertir
valores implícitamente al tipo que espera, por lo que no es de mucha ayuda.
No obstante, los tipos proporcionan un marco útil para hablar sobre progra-
mas. Muchos errores provienen de estar confundido acerca del tipo de valor
que entra o sale de una función. Si tienes esa información escrita, es menos
probable que te confundas.Podrías agregar un comentario como el siguiente
antes de la función findRoute del capítulo anterior para describir su tipo:
// (graph: Object, from: string, to: string) => string[]
function findRoute(graph, from, to) {
// ...
}
Existen varias convenciones diferentes para anotar programas de JavaScript
con tipos.
Una cosa sobre los tipos es que necesitan introducir su propia complejidad
para poder describir suficiente código para ser útiles. ¿Qué tipo crees que
tendría la función randomPick que devuelve un elemento aleatorio de un array?
Necesitarías introducir una variable de tipo, T, que pueda representar cualquier
tipo, para que puedas darle a randomPick un tipo como (T[])→ T (función de
un array de T a un T).
129

-- 141 of 445 --

Cuando los tipos de un programa son conocidos, es posible que la computa-
dora los verifique por ti, señalando errores antes de que se ejecute el programa.
Hay varios dialectos de JavaScript que añaden tipos al lenguaje y los verifican.
El más popular se llama TypeScript. Si estás interesado en agregar más rigor
a tus programas, te recomiendo que lo pruebes.
En este libro, continuaremos utilizando código JavaScript crudo, peligroso y
sin tipos.
Pruebas
Si el lenguaje no nos va a ayudar mucho a encontrar errores, tendremos que
encontrarlos a la antigua: ejecutando el programa y viendo si hace lo correcto.
Hacer esto manualmente, una y otra vez, es una idea muy mala. No solo es
molesto, también tiende a ser ineficaz, ya que lleva demasiado tiempo probar
exhaustivamente todo cada vez que haces un cambio.
Las computadoras son buenas en tareas repetitivas, y las pruebas son la
tarea repetitiva ideal. Las pruebas automatizadas son el proceso de escribir un
programa que prueba otro programa. Es un poco más trabajo escribir prue-
bas que probar manualmente, pero una vez que lo has hecho, adquieres una
especie de superpoder: solo te llevará unos segundos verificar que tu programa
siga comportándose correctamente en todas las situaciones para las que es-
cribiste pruebas. Cuando rompes algo, lo notarás de inmediato en lugar de
encontrártelo al azar en algún momento posterior.
Las pruebas suelen tomar la forma de pequeños programas etiquetados que
verifican algún aspecto de tu código. Por ejemplo, un conjunto de pruebas para
el (probablemente ya probado por alguien más) método toUpperCase estándar
podría lucir así:
function test(label, body) {
if (!body()) console.log(`Fallo: ${label}`);
}
test("convertir texto latino a mayúsculas", () => {
return "hello".toUpperCase() == "HELLO";
});
test("convertir texto griego a mayúsculas", () => {
return "Χαίρετε".toUpperCase() == "ΧΑΊΡΕΤΕ";
});
test("no convertir caracteres sin caso", () => {
return "৹৫ڑغ׍".toUpperCase() == "৹৫ڑغ׍";
});
130

-- 142 of 445 --

Escribir pruebas de esta forma tiende a producir código bastante repetitivo
y torpe. Afortunadamente, existen software que te ayudan a construir y eje-
cutar colecciones de pruebas (suites de pruebas) al proporcionar un lenguaje
(en forma de funciones y métodos) adecuado para expresar pruebas y al pro-
ducir información informativa cuando una prueba falla. Estos suelen llamarse
corredores de pruebas.
Alguno código es más fácil de probar que otro código. Generalmente, cuantos
más objetos externos interactúan con el código, más difícil es configurar el
contexto para probarlo. El estilo de programación mostrado en el capítulo
anterior, que utiliza valores persistentes autocontenidos en lugar de objetos
cambiantes, tiende a ser fácil de probar.
Depuración
Una vez que notas que hay algo mal en tu programa porque se comporta de
manera incorrecta o produce errores, el siguiente paso es descubrir cuál es el
problema.
A veces es obvio. El mensaje de error señalará una línea específica de tu
programa, y si miras la descripción del error y esa línea de código, a menudo
puedes ver el problema.
Pero no siempre. A veces la línea que desencadenó el problema es simple-
mente el primer lugar donde se utiliza de manera incorrecta un valor defectuoso
producido en otro lugar. Si has estado resolviendo los ejercicios en capítulos
anteriores, probablemente ya hayas experimentado estas situaciones.
El siguiente programa de ejemplo intenta convertir un número entero en una
cadena en una base dada (decimal, binaria, y así sucesivamente) al seleccionar
repetidamente el último dígito y luego dividir el número para deshacerse de
este dígito. Pero la extraña salida que produce actualmente sugiere que tiene
un error.
function numberToString(n, base = 10) {
let result = "", sign = "";
if (n < 0) {
sign = "-";
n = -n;
}
do {
result = String(n % base) + result;
n /= base;
} while (n > 0);
return sign + result;
131

-- 143 of 445 --

}
console.log(numberToString(13, 10));
// → 1.5e-3231.3e-3221.3e-3211.3e-3201.3e-3191.3e…-3181.3
Incluso si ya ves el problema, finge por un momento que no lo haces. Sabemos
que nuestro programa no funciona correctamente, y queremos descubrir por
qué.
Aquí es donde debes resistir la tentación de empezar a hacer cambios aleato-
rios en el código para ver si eso lo mejora. En cambio, piensa. Analiza lo que
está sucediendo y elabora una teoría sobre por qué podría estar ocurriendo.
Luego, realiza observaciones adicionales para probar esta teoría, o si aún no
tienes una teoría, realiza observaciones adicionales para ayudarte a crear una.
Colocar algunas llamadas console.log estratégicas en el programa es una
buena manera de obtener información adicional sobre lo que está haciendo el
programa. En este caso, queremos que n tome los valores 13, 1 y luego 0.
Vamos a escribir su valor al inicio del ciclo.
13
1.3
0.13
0.013…
1.5e-323
Correcto. Al dividir 13 por 10 no se produce un número entero. En lugar de
n /= base, lo que realmente queremos es n = Math.floor(n / base) para que
el número se “desplace” correctamente hacia la derecha.
Una alternativa a usar console.log para observar el comportamiento del
programa es utilizar las capacidades del depurador de tu navegador. Los nave-
gadores vienen con la capacidad de establecer un punto de interrupción en una
línea específica de tu código. Cuando la ejecución del programa llega a una
línea con un punto de interrupción, se pausa y puedes inspeccionar los valores
de las asignaciones en ese punto. No entraré en detalles, ya que los depuradores
difieren de un navegador a otro, pero busca en las herramientas de desarrollo
de tu navegador o busca instrucciones en la Web.Otra forma de establecer un
punto de interrupción es incluir una instrucción debugger (consistente única-
mente en esa palabra clave) en tu programa. Si las herramientas de desarrollo
de tu navegador están activas, el programa se pausará cada vez que alcance
dicha instrucción.
132

-- 144 of 445 --

Propagación de errores
Lamentablemente, no todos los problemas pueden ser prevenidos por el progra-
mador. Si tu programa se comunica de alguna manera con el mundo exterior,
es posible recibir entradas malformadas, sobrecargarse de trabajo o que falle la
red.
Si estás programando solo para ti, puedes permitirte simplemente ignorar
esos problemas hasta que ocurran. Pero si estás construyendo algo que será
utilizado por alguien más, generalmente quieres que el programa haga algo más
que simplemente colapsar. A veces lo correcto es aceptar la entrada incorrecta
y continuar ejecutándose. En otros casos, es mejor informar al usuario sobre lo
que salió mal y luego rendirse. Pero en cualquier situación, el programa debe
hacer algo activamente en respuesta al problema.
Imaginemos que tienes una función promptNumber que solicita al usuario un
número y lo retorna. ¿Qué debería retornar si el usuario ingresa “naranja”?
Una opción es hacer que retorne un valor especial. Las opciones comunes
para tales valores son null, undefined o -1.
function promptNumber(pregunta) {
let resultado = Number(prompt(pregunta));
if (Number.isNaN(resultado)) return null;
else return resultado;
}
console.log(promptNumber("¿Cuántos árboles ves?"));
Ahora, cualquier código que llame a promptNumber debe verificar si se leyó
un número real y, de no ser así, debe recuperarse de alguna manera, quizás
volviendo a preguntar o completando con un valor predeterminado. O podría
retornar nuevamente un valor especial a su llamante para indicar que no pudo
hacer lo que se le pidió.
En muchas situaciones, sobre todo cuando los errores son comunes y el lla-
mante debería tomarlos explícitamente en cuenta, retornar un valor especial es
una buena manera de indicar un error. Sin embargo, tiene sus inconvenientes.
Primero, ¿qué pasa si la función ya puede devolver todos los tipos posibles de
valores? En tal función, tendrás que hacer algo como envolver el resultado en
un objeto para poder distinguir el éxito del fracaso, de la misma manera que
lo hace el método next en la interfaz del iterador.
function lastElement(arreglo) {
if (arreglo.length == 0) {
return {falló: true};
133

-- 145 of 445 --

} else {
return {valor: arreglo[arreglo.length - 1]};
}
}
El segundo problema con retornar valores especiales es que puede llevar a un
código incómodo. Si un fragmento de código llama a promptNumber 10 veces,
tendrá que verificar 10 veces si se devolvió null. Y si su respuesta al encontrar
null es simplemente devolver null en sí mismo, los llamantes de la función a
su vez tendrán que comprobarlo, y así sucesivamente.
Excepciones
Cuando una función no puede proceder normalmente, lo que a menudo quer-
emos hacer es simplemente detener lo que estamos haciendo e ir directamente
a un lugar que sepa cómo manejar el problema. Esto es lo que hace el manejo
de excepciones.
Las excepciones son un mecanismo que hace posible que el código que se
encuentra con un problema lanze (o emita) una excepción. Una excepción
puede ser cualquier valor. Lanzar una se asemeja de alguna manera a un
retorno super potenciado de una función: sale no solo de la función actual
sino también de sus llamadores, hasta llegar a la primera llamada que inició la
ejecución actual. Esto se llama desenrollar la pila. Puede recordar la pila de
llamadas a funciones que se mencionó en el Capítulo 3. Una excepción recorre
esta pila, descartando todos los contextos de llamada que encuentra.
Si las excepciones siempre fueran directamente hasta el final de la pila, no
serían de mucha utilidad. Simplemente proporcionarían una forma novedosa
de hacer que su programa falle. Su poder radica en el hecho de que puede
colocar “obstáculos” a lo largo de la pila para capturar la excepción mientras
viaja hacia abajo. Una vez que ha capturado una excepción, puede hacer algo
con ella para resolver el problema y luego continuar ejecutando el programa.
Aquí tienes un ejemplo:
function promptDirection(question) {
let result = prompt(question);
if (result.toLowerCase() == "left") return "L";
if (result.toLowerCase() == "right") return "R";
throw new Error("Dirección inválida: " + result);
}
function look() {
if (promptDirection("¿Hacia dónde?") == "L") {
134

-- 146 of 445 --

return "una casa";
} else {
return "dos osos enojados";
}
}
try {
console.log("Ves", look());
} catch (error) {
console.log("Algo salió mal: " + error);
}
La palabra clave throw se utiliza para lanzar una excepción. La captura de una
excepción se realiza envolviendo un trozo de código en un bloque try, seguido
de la palabra clave catch. Cuando el código en el bloque try provoca que se
lance una excepción, se evalúa el bloque catch, con el nombre entre paréntesis
vinculado al valor de la excepción. Después de que el bloque catch finalice, o
si el bloque try finaliza sin problemas, el programa continúa debajo de toda la
instrucción try/catch.
En este caso, utilizamos el constructor Error para crear nuestro valor de
excepción. Este es un constructor de JavaScript estándar que crea un objeto con
una propiedad message. Las instancias de Error también recopilan información
sobre la pila de llamadas que existía cuando se creó la excepción, una llamada
traza de pila. Esta información se almacena en la propiedad stack y puede ser
útil al intentar depurar un problema: nos indica la función donde ocurrió el
problema y qué funciones realizaron la llamada fallida.
Ten en cuenta que la función look ignora por completo la posibilidad de que
promptDirection pueda fallar. Esta es la gran ventaja de las excepciones: el
código de manejo de errores solo es necesario en el punto donde ocurre el error
y en el punto donde se maneja. Las funciones intermedias pueden olvidarse por
completo de ello.
Bueno, casi...
Limpiando después de excepciones
El efecto de una excepción es otro tipo de flujo de control. Cada acción que
pueda causar una excepción, que es prácticamente cada llamada a función y
acceso a propiedad, puede hacer que el control salga repentinamente de tu
código.
Esto significa que cuando el código tiene varios efectos secundarios, incluso si
su flujo de control “regular” parece que siempre ocurrirán todos, una excepción
135

-- 147 of 445 --

podría evitar que algunos de ellos sucedan.
Aquí tienes un código bancario realmente malo.
const accounts = {
a: 100,
b: 0,
c: 20
};
function getAccount() {
let accountName = prompt("Ingresa el nombre de una cuenta");
if (!Object.hasOwn(accounts, accountName)) {
throw new Error(`No existe esa cuenta: ${accountName}`);
}
return accountName;
}
function transfer(from, amount) {
if (accounts[from] < amount) return;
accounts[from] -= amount;
accounts[getAccount()] += amount;
}
La función transfer transfiere una suma de dinero desde una cuenta dada a
otra, pidiendo el nombre de la otra cuenta en el proceso. Si se proporciona un
nombre de cuenta inválido, getAccount lanza una excepción.
Pero transfer primero retira el dinero de la cuenta y luego llama a getAccount
antes de agregarlo a otra cuenta. Si se interrumpe por una excepción en ese
momento, simplemente hará desaparecer el dinero.
Ese código podría haber sido escrito de manera un poco más inteligente, por
ejemplo, llamando a getAccount antes de comenzar a mover el dinero. Pero
a menudo los problemas como este ocurren de formas más sutiles. Incluso
las funciones que no parecen que lanzarán una excepción podrían hacerlo en
circunstancias excepcionales o cuando contienen un error del programador.
Una manera de abordar esto es utilizar menos efectos secundarios. Nueva-
mente, un estilo de programación que calcule nuevos valores en lugar de cambiar
datos existentes ayuda. Si un fragmento de código deja de ejecutarse en medio
de la creación de un nuevo valor, no se dañaron estructuras de datos existentes,
lo que facilita la recuperación.
Pero eso no siempre es práctico. Por eso existe otra característica que tienen
las instrucciones try. Pueden estar seguidas de un bloque finally en lugar o
además de un bloque catch. Un bloque finally dice “sin importar qué suceda,
ejecuta este código después de intentar ejecutar el código en el bloque try.”
136

-- 148 of 445 --

function transfer(from, amount) {
if (accounts[from] < amount) return;
let progress = 0;
try {
accounts[from] -= amount;
progress = 1;
accounts[getAccount()] += amount;
progress = 2;
} finally {
if (progress == 1) {
accounts[from] += amount;
}
}
}
Esta versión de la función rastrea su progreso y, si al salir nota que fue abortada
en un punto donde había creado un estado del programa inconsistente, repara
el daño causado.
Cabe destacar que aunque el código finally se ejecuta cuando se lanza una
excepción en el bloque try, no interfiere con la excepción. Después de que se
ejecuta el bloque finally, la pila continúa desenrollándose.
Escribir programas que funcionen de manera confiable incluso cuando surgen
excepciones en lugares inesperados es difícil. Muchas personas simplemente no
se preocupan, y debido a que las excepciones suelen reservarse para circunstan-
cias excepcionales, el problema puede ocurrir tan raramente que ni siquiera se
note. Si eso es algo bueno o realmente malo depende de cuánto daño causará
el software cuando falle.
Captura selectiva
Cuando una excepción llega hasta el final de la pila sin ser capturada, es mane-
jada por el entorno. Lo que esto significa difiere según los entornos. En los
navegadores, generalmente se escribe una descripción del error en la consola de
JavaScript (accesible a través del menú Herramientas o Desarrollador del nave-
gador). Node.js, el entorno de JavaScript sin navegador del que hablaremos en
el Capítulo 20, es más cuidadoso con la corrupción de datos. Abortará todo el
proceso cuando ocurra una excepción no manejada.
Para errores de programación, a menudo dejar que el error siga su curso es lo
mejor que se puede hacer. Una excepción no manejada es una forma razonable
de señalar un programa defectuoso, y la consola de JavaScript proporcionará,
en navegadores modernos, información sobre qué llamadas a funciones estaban
en la pila cuando ocurrió el problema.
137

-- 149 of 445 --

Para problemas que se espera que ocurran durante el uso rutinario, fallar con
una excepción no manejada es una estrategia terrible.
Usos incorrectos del lenguaje, como hacer referencia a un enlace inexistente,
buscar una propiedad en null o llamar a algo que no es una función, también
provocarán que se lancen excepciones. Estas excepciones también pueden ser
capturadas.
Cuando se entra en un cuerpo catch, todo lo que sabemos es que algo en
nuestro cuerpo try causó una excepción. Pero no sabemos qué lo hizo ni qué
excepción causó.
JavaScript (en una omisión bastante llamativa) no proporciona un soporte
directo para capturar excepciones selectivamente: o las capturas todas o no
capturas ninguna. Esto hace que sea tentador asumir que la excepción que
obtienes es la que tenías en mente cuando escribiste el bloque catch.
Pero podría no serlo. Alguno otra asunción podría estar violada, o podrías
haber introducido un error que está causando una excepción. Aquí tienes un
ejemplo que intenta seguir llamando a promptDirection hasta obtener una re-
spuesta válida:
for (;;) {
try {
let dir = promptDirection("¿Dónde?"); // ← ¡Error de tipeo!
console.log("Elegiste ", dir);
break;
} catch (e) {
console.log("Dirección no válida. Inténtalo de nuevo.");
}
}
La construcción for (;;) es una forma de crear intencionalmente un bucle que
no se termina por sí mismo. Salimos del bucle solo cuando se proporciona una
dirección válida. Pero escribimos mal promptDirection, lo que resultará en
un error de “variable no definida”. Debido a que el bloque catch ignora por
completo el valor de la excepción (e), asumiendo que sabe cuál es el problema,
trata erróneamente el error de enlace mal escrito como indicativo de una entrada
incorrecta. Esto no solo causa un bucle infinito, sino que también “entorpece”
el útil mensaje de error sobre el enlace mal escrito.
Como regla general, no captures excepciones de manera general a menos que
sea con el propósito de “enviarlas” a algún lugar, por ejemplo, a través de la
red para informar a otro sistema que nuestro programa se bloqueó. E incluso
en ese caso, piensa cuidadosamente cómo podrías estar ocultando información.
Por lo tanto, queremos capturar un tipo específico de excepción. Podemos
hacer esto verificando en el bloque catch si la excepción que recibimos es la
138

-- 150 of 445 --

que nos interesa y relanzándola en caso contrario. Pero, ¿cómo reconocemos
una excepción?
Podríamos comparar su propiedad message con el mensaje que esperamos
error. Pero esta es una forma poco confiable de escribir código, estaríamos
utilizando información diseñada para consumo humano (el mensaje) para tomar
una decisión programática. Tan pronto como alguien cambie (o traduzca) el
mensaje, el código dejará de funcionar.
En lugar de eso, definamos un nuevo tipo de error y usemos instanceof para
identificarlo.
class InputError extends Error {}
function promptDirection(question) {
let result = prompt(question);
if (result.toLowerCase() == "izquierda") return "I";
if (result.toLowerCase() == "derecha") return "D";
throw new InputError("Dirección no válida: " + result);
}
La nueva clase de error extiende Error. No define su propio constructor, lo que
significa que hereda el constructor de Error, que espera un mensaje de cadena
como argumento. De hecho, no define nada en absoluto, la clase está vacía.
Los objetos InputError se comportan como objetos Error, excepto que tienen
una clase diferente mediante la cual podemos reconocerlos.
Ahora el bucle puede capturar esto con más cuidado.
for (;;) {
try {
let dir = promptDirection("¿Dónde?");
console.log("Elegiste ", dir);
break;
} catch (e) {
if (e instanceof InputError) {
console.log("Dirección no válida. Inténtalo de nuevo.");
} else {
throw e;
}
}
}
Esto capturará solo instancias de InputError y permitirá que pasen excepciones
no relacionadas. Si vuelves a introducir el error de tipeo, el error de enlace no
definido se informará correctamente.
139

-- 151 of 445 --

Afirmaciones
Las afirmaciones son verificaciones dentro de un programa que aseguran que
algo es como se supone que debe ser. Se utilizan no para manejar situaciones
que pueden surgir en la operación normal, sino para encontrar errores de pro-
gramación.
Si, por ejemplo, se describe primerElemento como una función que nunca de-
bería ser llamada en arrays vacíos, podríamos escribirla de la siguiente manera:
function primerElemento(array) {
if (array.length == 0) {
throw new Error("primerElemento llamado con []");
}
return array[0];
}
Ahora, en lugar de devolver silenciosamente undefined (que es lo que obtienes
al leer una propiedad de un array que no existe), esto hará que tu programa
falle ruidosamente tan pronto como lo uses incorrectamente. Esto hace que sea
menos probable que tales errores pasen desapercibidos y más fácil encontrar su
causa cuando ocurran.
No recomiendo intentar escribir afirmaciones para cada tipo de entrada in-
correcta posible. Eso sería mucho trabajo y llevaría a un código muy ruidoso.
Querrás reservarlas para errores que son fáciles de cometer (o que te encuentres
cometiendo).
Resumen
Una parte importante de programar es encontrar, diagnosticar y corregir er-
rores. Los problemas pueden ser más fáciles de notar si tienes un conjunto de
pruebas automatizadas o agregas afirmaciones a tus programas.
Los problemas causados por factores fuera del control del programa gen-
eralmente deberían ser planificados activamente. A veces, cuando el problema
puede ser manejado localmente, los valores de retorno especiales son una buena
forma de rastrearlos. De lo contrario, las excepciones pueden ser preferibles.
Lanzar una excepción provoca que la pila de llamadas se desenrolle hasta el
próximo bloque try/catch envolvente o hasta la base de la pila. El valor de la
excepción será entregado al bloque catch que la captura, el cual debe verificar
que sea realmente el tipo de excepción esperado y luego hacer algo con él. Para
ayudar a abordar el flujo de control impredecible causado por las excepciones,
se pueden utilizar bloques finally para asegurar que un trozo de código se
140

-- 152 of 445 --

ejecute siempre cuando un bloque termina.
Ejercicios
Reintentar
Imagina que tienes una función primitiveMultiply que en el 20 por ciento de los
casos multiplica dos números y en el otro 80 por ciento arroja una excepción del
tipo MultiplicatorUnitFailure. Escribe una función que envuelva esta función
problemática y siga intentando hasta que una llamada tenga éxito, momento
en el que devuelva el resultado.
Asegúrate de manejar solo las excepciones que estás intentando manejar.
La caja cerrada con llave
Considera el siguiente objeto (bastante artificial):
const box = new class {
locked = true;
#content = [];
unlock() { this.locked = false; }
lock() { this.locked = true; }
get content() {
if (this.locked) throw new Error("¡Cerrado con llave!");
return this.#content;
}
};
Es una caja con una cerradura. Hay un array en la caja, pero solo puedes
acceder a él cuando la caja está desbloqueada.
Escribe una función llamada withBoxUnlocked que reciba como argumento
un valor de función, desbloquee la caja, ejecute la función y luego asegure que
la caja esté cerrada de nuevo antes de devolverla, independientemente de si la
función de argumento devolvió normalmente o lanzó una excepción.
Para puntos adicionales, asegúrate de que si llamas a withBoxUnlocked cuando
la caja ya está desbloqueada, la caja permanezca desbloqueada.
141

-- 153 of 445 --

“Algunas personas, cuando se enfrentan a un problema, piensan ’¡Ya
sé, usaré expresiones regulares!’ Ahora tienen dos problemas.”
—Jamie Zawinski
Chapter 9
Expresiones regulares
Las herramientas y técnicas de programación sobreviven y se propagan de man-
era caótica y evolutiva. No siempre ganan las mejores o brillantes, sino aquellas
que funcionan lo suficientemente bien dentro del nicho correcto o que se inte-
gran con otra pieza exitosa de tecnología.
En este capítulo, discutiré una de esas herramientas, expresiones regulares.
Las expresiones regulares son una forma de describir patrónes en datos de
cadena. Forman un pequeño lenguaje separado que es parte de JavaScript y
muchos otros lenguajes y sistemas.
Las expresiones regulares son tanto terriblemente incómodas como extremada-
mente útiles. Su sintaxis es críptica y la interfaz de programación que JavaScript
proporciona para ellas es torpe. Pero son una herramienta poderosa para in-
speccionar y procesar cadenas. Comprender adecuadamente las expresiones
regulares te hará un programador más efectivo.
Creando una expresión regular
Una expresión regular es un tipo de objeto. Puede ser construido con el con-
structor RegExp o escrito como un valor literal al encerrar un patrón entre
caracteres de barra diagonal (/).
let re1 = new RegExp("abc");
let re2 = /abc/;
Ambos objetos de expresión regular representan el mismo patrón: un carácter
a seguido de un b seguido de un c.
Cuando se utiliza el constructor RegExp, el patrón se escribe como una cadena
normal, por lo que se aplican las reglas habituales para las barras invertidas.
La segunda notación, donde el patrón aparece entre caracteres de barra di-
agonal, trata las barras invertidas de manera un poco diferente. Primero, dado
que una barra diagonal termina el patrón, debemos poner una barra inver-
tida antes de cualquier barra diagonal que queramos que sea parte del patrón.
142

-- 154 of 445 --

Además, las barras invertidas que no forman parte de códigos de caracteres
especiales (como \n) serán preservadas, en lugar de ser ignoradas como lo son
en las cadenas, y cambian el significado del patrón. Algunos caracteres, como
signos de interrogación y signos de más, tienen significados especiales en las ex-
presiones regulares y deben ser precedidos por una barra invertida si se desea
representar el propio carácter.
let aPlus = /A\+/;
Pruebas de coincidencias
Los objetos de expresiones regulares tienen varios métodos. El más simple es
test. Si le pasas una cadena, devolverá un Booleano indicándote si la cadena
contiene una coincidencia con el patrón de la expresión.
console.log(/abc/.test("abcde"));
// → true
console.log(/abc/.test("abxde"));
// → false
Una expresión regular que consiste solo en caracteres no especiales simplemente
representa esa secuencia de caracteres. Si abc aparece en cualquier parte de la
cadena contra la cual estamos probando (no solo al principio), test devolverá
true.
Conjuntos de caracteres
Descubrir si una cadena contiene abc también se podría hacer con una llamada
a indexOf. Las expresiones regulares son útiles porque nos permiten describir
patrones más complicados.
Digamos que queremos hacer coincidir cualquier número. En una expresión
regular, poner un conjunto de caracteres entre corchetes hace que esa parte de
la expresión coincida con cualquiera de los caracteres entre los corchetes.
Ambas expresiones siguientes hacen coincidir todas las cadenas que contienen
un dígito:
console.log(/[0123456789]/.test("in 1992"));
// → true
console.log(/[0-9]/.test("in 1992"));
// → true
143

-- 155 of 445 --

Dentro de corchetes, un guion (-) entre dos caracteres se puede usar para
indicar un rango de caracteres, donde el orden es determinado por el número
del carácter en el Unicode. Los caracteres del 0 al 9 están uno al lado del otro
en este orden (códigos 48 a 57), por lo que [0-9] abarca todos ellos y coincide
con cualquier dígito.
Varios grupos comunes de caracteres tienen sus propias abreviaturas incor-
poradas. Los dígitos son uno de ellos: \d significa lo mismo que [0-9].
\d Cualquier carácter dígito
\w Un carácter alfanumérico (“carácter de palabra”)
\s Cualquier carácter de espacio en blanco (espacio, tabulación, nueva línea, y similares)
\D Un carácter que no es un dígito
\W Un carácter no alfanumérico
\S Un carácter que no es de espacio en blanco
. Cualquier carácter excepto nueva línea
Así que podrías hacer coincidir un formato de fecha y hora como 01-30-2003
15:20 con la siguiente expresión:
let dateTime = /\d\d-\d\d-\d\d\d\d \d\d:\d\d/;
console.log(dateTime.test("01-30-2003 15:20"));
// → true
console.log(dateTime.test("30-ene-2003 15:20"));
// → false
¡Eso se ve completamente horrible, ¿verdad? La mitad son barras invertidas,
produciendo un ruido de fondo que dificulta identificar el patrón expresado.
Veremos una versión ligeramente mejorada de esta expresión más adelante.
Estos códigos de barra invertida también se pueden usar dentro de corchetes.
Por ejemplo, [\d.] significa cualquier dígito o un carácter de punto. Pero el
punto en sí, entre corchetes, pierde su significado especial. Lo mismo ocurre
con otros caracteres especiales, como +.
Para invertir un conjunto de caracteres, es decir, expresar que deseas hacer
coincidir cualquier carácter excepto los que están en el conjunto, puedes escribir
un carácter circunflejo (^) después del corchete de apertura.
let nonBinary = /[^01]/;
console.log(nonBinary.test("1100100010100110"));
// → false
console.log(nonBinary.test("0111010112101001"));
// → true
144

-- 156 of 445 --

Caracteres internacionales
Debido a la implementación simplista inicial de JavaScript y al hecho de que
este enfoque simplista luego se estableció como comportamiento estándar, las
expresiones regulares de JavaScript son bastante simples en lo que respecta
a los caracteres que no aparecen en el idioma inglés. Por ejemplo, según las
expresiones regulares de JavaScript, un “carácter de palabra” es solo uno de los
26 caracteres del alfabeto latino (mayúsculas o minúsculas), dígitos decimales
y, por alguna razón, el guion bajo. Cosas como é o ß, que definitivamente
son caracteres de palabra, no coincidirán con \w (y sí coincidirán con \W en
mayúsculas, la categoría de no palabras).
Por un extraño accidente histórico, \s (espacio en blanco) no tiene este prob-
lema y coincide con todos los caracteres que el estándar Unicode considera es-
pacios en blanco, incluidos elementos como el espacio sin ruptura y el separador
de vocal mongol.
Es posible usar \p en una expresión regular para hacer coincidir todos los
caracteres a los que el estándar Unicode asigna una propiedad dada. Esto
nos permite hacer coincidir cosas como letras de una manera más cosmopolita.
Sin embargo, nuevamente debido a la compatibilidad con los estándares origi-
nales del lenguaje, estos solo se reconocen cuando se coloca un carácter u (por
Unicode) después de la expresión regular.
\p{L} Cualquier letra
\p{N} Cualquier carácter numérico
\p{P} Cualquier carácter de puntuación
\P{L} Cualquier no letra (la P en mayúsculas invierte)
\p{Script=Hangul} Cualquier carácter del guion dado (ver Capítulo 5)
Usar \w para el procesamiento de texto que puede necesitar manejar texto no
inglés (o incluso texto en inglés con palabras prestadas como “cliché") es una
desventaja, ya que no tratará caracteres como "é" como letras. Aunque tienden
a ser un poco más verbosos, los grupos de propiedades \p son más robustos.
console.log(/\p{L}/u.test("α"));
// → true
console.log(/\p{L}/u.test("!"));
// → false
console.log(/\p{Script=Greek}/u.test("α"));
// → true
console.log(/\p{Script=Arabic}/u.test("α"));
// → false
Por otro lado, si estás haciendo coincidir números para hacer algo con ellos,
a menudo querrás usar \d para dígitos, ya que convertir caracteres numéricos
145

-- 157 of 445 --

arbitrarios en un número de JavaScript no es algo que una función como Number
pueda hacer por ti.
Repetir partes de un patrón
Ahora sabemos cómo hacer coincidir un solo dígito. ¿Qué tal si queremos hacer
coincidir un número entero, una secuencia de uno o más dígitos?
Cuando colocas un signo más (+) después de algo en una expresión regular,
indica que el elemento puede repetirse más de una vez. Así, /\d+/ hace coincidir
uno o más caracteres de dígitos.
console.log(/'\d+'/.test("'123'"));
// → true
console.log(/'\d+'/.test("''"));
// → false
console.log(/'\d*'/.test("'123'"));
// → true
console.log(/'\d*'/.test("''"));
// → true
El asterisco (*) tiene un significado similar pero también permite que el patrón
coincida cero veces. Algo con un asterisco después nunca impide que un patrón
coincida, simplemente coincidirá cero veces si no puede encontrar ningún texto
adecuado para hacer coincidir.
Un signo de interrogación hace que una parte de un patrón sea opcional, lo
que significa que puede ocurrir cero veces o una vez. En el siguiente ejemplo,
se permite que el carácter u ocurra, pero el patrón también coincide cuando
falta.
let neighbor = /neighbou?r/;
console.log(neighbor.test("neighbour"));
// → true
console.log(neighbor.test("neighbor"));
// → true
Para indicar que un patrón debe ocurrir un número preciso de veces, utiliza
llaves. Colocar {4} después de un elemento, por ejemplo, requiere que ocurra
exactamente cuatro veces. También es posible especificar un rango de esta
manera: {2,4} significa que el elemento debe ocurrir al menos dos veces y
como máximo cuatro veces.
Aquí tienes otra versión del patrón de fecha y hora que permite días, meses
y horas de uno o dos dígitos. También es un poco más fácil de entender.
146

-- 158 of 445 --

let dateTime = /\d{1,2}-\d{1,2}-\d{4} \d{1,2}:\d{2}/;
console.log(dateTime.test("1-30-2003 8:45"));
// → true
También puedes especificar rangos abiertos al utilizar llaves omitiendo el número
después de la coma. Así, {5,} significa cinco o más veces.
Agrupación de subexpresiones
Para usar un operador como * o + en más de un elemento a la vez, debes
utilizar paréntesis. Una parte de una expresión regular que está encerrada entre
paréntesis cuenta como un solo elemento en lo que respecta a los operadores
que le siguen.
let cartoonCrying = /boo+(hoo+)+/i;
console.log(cartoonCrying.test("Boohoooohoohooo"));
// → true
Los primeros y segundos caracteres + aplican solo al segundo o en boo y hoo,
respectivamente. El tercer + se aplica a todo el grupo (hoo+), haciendo coincidir
una o más secuencias como esa.
La i al final de la expresión en el ejemplo hace que esta expresión regular
ignore mayúsculas y minúsculas, lo que le permite hacer coincidir la B mayús-
cula en la cadena de entrada, aunque el patrón en sí está completamente en
minúsculas.
Coincidencias y grupos
El método test es la forma más simple de hacer coincidir una expresión regu-
lar. Solo te indica si hubo coincidencia y nada más. Las expresiones regulares
también tienen un método exec (ejecutar) que devolverá null si no se encontró
ninguna coincidencia y devolverá un objeto con información sobre la coinciden-
cia en caso contrario.
let coincidencia = /\d+/.exec("uno dos 100");
console.log(coincidencia);
// → ["100"]
console.log(coincidencia.index);
// → 8
Un objeto devuelto por exec tiene una propiedad de index que nos dice dónde
en la cadena comienza la coincidencia exitosa. Aparte de eso, el objeto parece
147

-- 159 of 445 --

(y de hecho es) un array de strings, cuyo primer elemento es la cadena que
coincidió. En el ejemplo anterior, esta es la secuencia de dígitos que estábamos
buscando.
Los valores de tipo string tienen un método match que se comporta de manera
similar.
console.log("uno dos 100".match(/\d+/));
// → ["100"]
Cuando la expresión regular contiene subexpresiones agrupadas con parénte-
sis, el texto que coincidió con esos grupos también aparecerá en el array. La
coincidencia completa es siempre el primer elemento. El siguiente elemento es
la parte coincidente con el primer grupo (el que tiene el paréntesis de apertura
primero en la expresión), luego el segundo grupo, y así sucesivamente.
let textoEntreComillas = /'([^']*)'/;
console.log(textoEntreComillas.exec("ella dijo 'hola'"));
// → ["'hola'", "hola"]
Cuando un grupo no termina coincidiendo en absoluto (por ejemplo, cuando
está seguido por un signo de pregunta), su posición en el array de salida con-
tendrá undefined. Y cuando un grupo coincide múltiples veces (por ejemplo,
cuando está seguido por un +), solo la última coincidencia termina en el array.
console.log(/mal(mente)?/.exec("mal"));
// → ["mal", undefined]
console.log(/(\d)+/.exec("123"));
// → ["123", "3"]
Si quieres utilizar paréntesis puramente para agrupar, sin que aparezcan en el
array de coincidencias, puedes colocar ?: después del paréntesis de apertura.
console.log(/(?:na)+/.exec("banana"));
// → ["nana"]
Los grupos pueden ser útiles para extraer partes de una cadena. Si no solo
queremos verificar si una cadena contiene una fecha sino también extraerla y
construir un objeto que la represente, podemos envolver paréntesis alrededor
de los patrones de dígitos y seleccionar directamente la fecha del resultado de
exec.
Pero primero haremos un breve desvío, en el que discutiremos la forma in-
corporada de representar fechas y horas en JavaScript.
148

-- 160 of 445 --

La clase Date
JavaScript tiene una clase estándar para representar fechas—o, más bien, pun-
tos en tiempo. Se llama Date. Si simplemente creas un objeto de fecha usando
new, obtendrás la fecha y hora actuales.
console.log(new Date());
// → Fri Feb 02 2024 18:03:06 GMT+0100 (CET)
También puedes crear un objeto para un momento específico.
console.log(new Date(2009, 11, 9));
// → Mié Dec 09 2009 00:00:00 GMT+0100 (CET)
console.log(new Date(2009, 11, 9, 12, 59, 59, 999));
// → Mié Dec 09 2009 12:59:59 GMT+0100 (CET)
JavaScript utiliza una convención donde los números de mes empiezan en cero
(por lo que diciembre es 11), pero los números de día comienzan en uno. Esto
es confuso y tonto. Ten cuidado.
Los últimos cuatro argumentos (horas, minutos, segundos y milisegundos)
son opcionales y se consideran cero cuando no se proporcionan.
Las marcas de tiempo se almacenan como el número de milisegundos desde el
comienzo de 1970, en UTC (zona horaria). Esto sigue una convención estable-
cida por “tiempo de Unix”, que fue inventado alrededor de esa época. Puedes
usar números negativos para tiempos antes de 1970. El método getTime en un
objeto de fecha retorna este número. Es grande, como te puedes imaginar.
console.log(new Date(2013, 11, 19).getTime());
// → 1387407600000
console.log(new Date(1387407600000));
// → Jue Dec 19 2013 00:00:00 GMT+0100 (CET)
Si le proporcionas un único argumento al constructor Date, ese argumento se
tratará como un recuento de milisegundos. Puedes obtener el recuento actual
de milisegundos creando un nuevo objeto Date y llamando a getTime en él o
llamando a la función Date.now.
Los objetos de fecha proporcionan métodos como getFullYear, getMonth,
getDate, getHours, getMinutes y getSeconds para extraer sus componentes.
Además de getFullYear, también existe getYear, que te da el año menos 1900
(98 o 119) y es en su mayoría inútil.
Poniendo paréntesis alrededor de las partes de la expresión que nos interesan,
podemos crear un objeto de fecha a partir de una cadena.
function getDate(string) {
149

-- 161 of 445 --

let [_, month, day, year] =
/(\d{1,2})-(\d{1,2})-(\d{4})/.exec(string);
return new Date(year, month - 1, day);
}
console.log(getDate("1-30-2003"));
// → Jue Ene 30 2003 00:00:00 GMT+0100 (CET)
La vinculación _ (guion bajo) se ignora y se utiliza solo para omitir el elemento
de coincidencia completa en el array devuelto por exec.
Límites y anticipación
Desafortunadamente, getDate también extraerá felizmente una fecha de la ca-
dena "100-1-30000". Una coincidencia puede ocurrir en cualquier parte de la
cadena, por lo que en este caso, simplemente empezará en el segundo carácter
y terminará en el antepenúltimo carácter.
Si queremos asegurar que la coincidencia abarque toda la cadena, podemos
agregar los marcadores ^ y $. El circunflejo coincide con el inicio de la cadena de
entrada, mientras que el signo de dólar coincide con el final. Por lo tanto, /^\d
+$/ coincide con una cadena que consiste completamente de uno o más dígitos,
/^!/ coincide con cualquier cadena que comience con un signo de exclamación
y /x^/ no coincide con ninguna cadena (no puede haber una x antes del inicio
de la cadena).
También existe un marcador \b, que coincide con los “límites de palabra”,
posiciones que tienen un carácter de palabra a un lado y un carácter que no
es de palabra al otro. Desafortunadamente, estos utilizan el mismo concepto
simplista de caracteres de palabra que \w, por lo que no son muy confiables.
Ten en cuenta que estos marcadores no coinciden con ningún carácter real.
Simplemente aseguran que se cumpla una condición determinada en el lugar
donde aparecen en el patrón.
Las pruebas de mirar adelante hacen algo similar. Proporcionan un patrón y
harán que la coincidencia falle si la entrada no coincide con ese patrón, pero en
realidad no mueven la posición de la coincidencia hacia adelante. Se escriben
entre (?= y ).
console.log(/a(?=e)/.exec("braeburn"));
// → ["a"]
console.log(/a(?! )/.exec("a b"));
// → null
Observa cómo la e en el primer ejemplo es necesaria para coincidir, pero no
forma parte de la cadena coincidente. La notación (?! ) expresa un mirar
150

-- 162 of 445 --

adelante negativo. Esto solo coincide si el patrón entre paréntesis no coincide,
lo que hace que el segundo ejemplo solo coincida con caracteres “a” que no
tienen un espacio después de ellos.
Patrones de elección
Digamos que queremos saber si un texto contiene no solo un número, sino un
número seguido de una de las palabras pig, cow o chicken, o cualquiera de sus
formas en plural.
Podríamos escribir tres expresiones regulares y probarlas sucesivamente, pero
hay una forma más sencilla. El carácter de barra vertical (|) denota una
elección entre el patrón a su izquierda y el patrón a su derecha. Así que puedo
decir esto:
let animalCount = /\d+ (pig|cow|chicken)s?/;
console.log(animalCount.test("15 pigs"));
// → true
console.log(animalCount.test("15 pugs"));
// → false
Los paréntesis se pueden utilizar para limitar la parte del patrón a la que se
aplica el operador de barra, y puedes colocar varios de estos operadores uno al
lado del otro para expresar una elección entre más de dos alternativas.
La mecánica de la coincidencia
Conceptualmente, cuando utilizas exec o test, el motor de expresiones reg-
ulares busca una coincidencia en tu cadena tratando de ajustar primero la
expresión desde el comienzo de la cadena, luego desde el segundo carácter, y
así sucesivamente, hasta que encuentra una coincidencia o llega al final de la ca-
dena. Devolverá la primera coincidencia que encuentre o fracasará en encontrar
cualquier coincidencia.
Para hacer la coincidencia real, el motor trata a una expresión regular algo
así como un diagrama de flujo. Este es el diagrama para la expresión de ganado
en el ejemplo anterior:
151

-- 163 of 445 --

digit 	“”
group #1
“pig”
“cow”
“chicken”
“s”
Nuestra expresión coincide si podemos encontrar un camino desde el lado
izquierdo del diagrama hasta el lado derecho. Mantenemos una posición actual
en la cadena, y cada vez que avanzamos a través de un recuadro, verificamos
que la parte de la cadena después de nuestra posición actual coincida con ese
recuadro.
Retroceso
La expresión regular /^([01]+b|[\da-f]+h|\d+)$/ coincide ya sea con un número
binario seguido de una b, un número hexadecimal (es decir, base 16, con las
letras a a f representando los dígitos del 10 al 15) seguido de un h, o un número
decimal regular sin un carácter de sufijo. Este es el diagrama correspondiente:
Start of line
group #1
One of:
“0”
“1”
“b”
One of:
digit
-	“a” 	“f”
“h”
digit
End of line
Al coincidir con esta expresión, a menudo sucede que se ingresa por la rama
superior (binaria) aunque la entrada en realidad no contenga un número bina-
rio. Al coincidir con la cadena "103", por ejemplo, solo se aclara en el 3 que
estamos en la rama incorrecta. La cadena coincide con la expresión, simple-
mente no con la rama en la que nos encontramos actualmente.
152

-- 164 of 445 --

Entonces, el coincidente retrocede. Al ingresar a una rama, recuerda su
posición actual (en este caso, al principio de la cadena, justo después del primer
cuadro de límite en el diagrama) para poder retroceder y probar otra rama si la
actual no funciona. Para la cadena "103", después de encontrar el carácter 3,
intentará la rama para los números hexadecimales, lo cual también falla porque
no hay un h después del número. Entonces intenta la rama para los números
decimales. Esta encaja, y se informa una coincidencia después de todo.
El coincidente se detiene tan pronto como encuentra una coincidencia com-
pleta. Esto significa que si varias ramas podrían coincidir potencialmente con
una cadena, solo se usa la primera (ordenada por dónde aparecen las ramas en
la expresión regular).
El retroceso también ocurre para los operadores de repetición como + y *.
Si coincide con /^.*x/ contra "abcxe", la parte .* intentará primero consumir
toda la cadena. Luego el motor se dará cuenta de que necesita una x para que
coincida con el patrón. Dado que no hay una x más allá del final de la cadena, el
operador estrella intentará coincidir con un carácter menos. Pero el coincidente
no encuentra una x después de abcx tampoco, por lo que retrocede nuevamente,
coincidiendo con el operador estrella solo con abc. Ahora encuentra una x donde
la necesita y reporta una coincidencia exitosa desde las posiciones 0 a 4.
Es posible escribir expresiones regulares que realizarán mucho retroceso. Este
problema ocurre cuando un patrón puede coincidir con una parte de la entrada
de muchas formas diferentes. Por ejemplo, si nos confundimos al escribir una ex-
presión regular para los números binarios, podríamos escribir accidentalmente
algo como /([01]+)+b/.
"b"
Group #1
One of:
"1"
"0"
Si intenta hacer coincidir una serie larga de ceros y unos sin un caracter b
al final, el analizador primero pasa por el bucle interno hasta que se queda sin
dígitos. Luego se da cuenta de que no hay b, por lo que retrocede una posición,
pasa por el bucle externo una vez y vuelve a darse por vencido, intentando
retroceder nuevamente fuera del bucle interno. Continuará intentando todas
153

-- 165 of 445 --

las rutas posibles a través de estos dos bucles. Esto significa que la cantidad de
trabajo se duplica con cada carácter adicional. Incluso con apenas unas pocas
docenas de caracteres, la coincidencia resultante tomará prácticamente para
siempre.
El método replace
Los valores de cadena tienen un método replace que se puede utilizar para
reemplazar parte de la cadena con otra cadena.
console.log("papa".replace("p", "m"));
// → mapa
El primer argumento también puede ser una expresión regular, en cuyo caso se
reemplaza la primera coincidencia de la expresión regular. Cuando se agrega
una opción g (para global) después de la expresión regular, todas las coinciden-
cias en la cadena serán reemplazadas, no solo la primera.
console.log("Borobudur".replace(/[ou]/, "a"));
// → Barobudur
console.log("Borobudur".replace(/[ou]/g, "a"));
// → Barabadar
El verdadero poder de usar expresiones regulares con replace proviene del
hecho de que podemos hacer referencia a grupos coincidentes en la cadena de
reemplazo. Por ejemplo, digamos que tenemos una cadena larga que contiene
los nombres de personas, un nombre por línea, en el formato Apellido, Nombre.
Si queremos intercambiar estos nombres y eliminar la coma para obtener un
formato Nombre Apellido, podemos usar el siguiente código:
console.log(
"Liskov, Barbara\nMcCarthy, John\nMilner, Robin"
.replace(/(\p{L}+), (\p{L}+)/gu, "$2 $1"));
// → Barbara Liskov
// John McCarthy
// Robin Milner
Los $1 y $2 en la cadena de reemplazo se refieren a los grupos entre paréntesis
en el patrón. $1 es reemplazado por el texto que coincidió con el primer grupo,
$2 por el segundo, y así sucesivamente, hasta $9. Toda la coincidencia se puede
referenciar con $&.
Es posible pasar una función, en lugar de una cadena, como segundo argu-
mento a replace. Para cada reemplazo, la función se llamará con los grupos
154

-- 166 of 445 --

coincidentes (así como la coincidencia completa) como argumentos, y su valor
de retorno se insertará en la nueva cadena.
Aquí tienes un ejemplo:
let stock = "1 limón, 2 repollos y 101 huevos";
function menosUno(match, cantidad, unidad) {
cantidad = Number(cantidad) - 1;
if (cantidad == 1) { // solo queda uno, se elimina la 's'
unidad = unidad.slice(0, unidad.length - 1);
} else if (cantidad == 0) {
cantidad = "ningún";
}
return cantidad + " " + unidad;
}
console.log(stock.replace(/(\d+) (\p{L}+)/gu, menosUno));
// → ningún limón, 1 repollo y 100 huevos
Esta función toma una cadena, encuentra todas las ocurrencias de un número
seguido de una palabra alfanumérica, y devuelve una cadena que tiene una
cantidad menos de cada una de esas ocurrencias.
El grupo (\d+) termina siendo el argumento amount de la función, y el grupo
(\p{L}+) se asigna a unit. La función convierte amount a un número, lo cual
siempre funciona ya que coincide con \d+, y realiza algunos ajustes en caso de
que solo quede uno o ninguno.
Avaricia
Es posible usar replace para escribir una función que elimine todos los comen-
tarios de un fragmento de código JavaScript. Aquí tienes un primer intento:
function stripComments(code) {
return code.replace(/\/\/.*|\/\*[^]*\*\//g, "");
}
console.log(stripComments("1 + /* 2 */3"));
// → 1 + 3
console.log(stripComments("x = 10;// ¡diez!"));
// → x = 10;
console.log(stripComments("1 /* a */+/* b */ 1"));
// → 1 1
La parte antes del operador or coincide con dos caracteres de barra seguidos
por cualquier cantidad de caracteres que no sean de nueva línea. La parte
de comentarios de varias líneas es más compleja. Utilizamos [^] (cualquier
carácter que no esté en el conjunto vacío de caracteres) como una forma de
155

-- 167 of 445 --

coincidir con cualquier carácter. No podemos usar simplemente un punto aquí
porque los comentarios de bloque pueden continuar en una nueva línea, y el
carácter de punto no coincide con caracteres de nueva línea.
Pero la salida para la última línea parece haber salido mal. ¿Por qué?
La parte [^]* de la expresión, como describí en la sección sobre retroceso,
primero intentará coincidir con todo lo que pueda. Si esto hace que la siguiente