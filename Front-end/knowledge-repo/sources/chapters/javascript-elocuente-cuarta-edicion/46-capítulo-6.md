# Capítulo 6.

A medida que el juego avanza, los actores terminarán en lugares diferentes o
264

-- 276 of 445 --

incluso desaparecerán por completo (como hacen las monedas cuando se reco-
gen). Utilizaremos una clase State para seguir el estado de un juego en ejecu-
ción.
class State {
constructor(level, actors, status) {
this.level = level;
this.actors = actors;
this.status = status;
}
static start(level) {
return new State(level, level.startActors, "playing");
}
get player() {
return this.actors.find(a => a.type == "player");
}
}
La propiedad status cambiará a "lost" o "won" cuando el juego haya termi-
nado.
Este es nuevamente una estructura de datos persistente: actualizar el estado
del juego crea un nuevo estado y deja intacto el anterior.
Actores
Los objetos de actores representan la posición actual y el estado de un elemento
móvil dado en nuestro juego. Todos los objetos de actores se ajustan a la
misma interfaz. Tienen las propiedades size y pos que contienen el tamaño y
las coordenadas de la esquina superior izquierda del rectángulo que representa
a este actor.
Luego tienen un método update, que se utiliza para calcular su nuevo estado
y posición después de un paso de tiempo dado. Simula la acción que realiza el
actor: moverse en respuesta a las teclas de flecha para el jugador y rebotar de
un lado a otro para la lava, y devuelve un nuevo objeto de actor actualizado.
Una propiedad type contiene una cadena que identifica el tipo de actor: "
player", "coin" o "lava". Esto es útil al dibujar el juego: la apariencia del
rectángulo dibujado para un actor se basa en su tipo.
Las clases de actores tienen un método estático create que es utilizado por
el constructor Level para crear un actor a partir de un carácter en el plan de
nivel. Recibe las coordenadas del carácter y el carácter en sí, que es necesario
265

-- 277 of 445 --

porque la clase Lava maneja varios caracteres diferentes.
Esta es la clase Vec que usaremos para nuestros valores bidimensionales,
como la posición y tamaño de los actores.
class Vec {
constructor(x, y) {
this.x = x; this.y = y;
}
plus(other) {
return new Vec(this.x + other.x, this.y + other.y);
}
times(factor) {
return new Vec(this.x * factor, this.y * factor);
}
}
El método times escala un vector por un número dado. Será útil cuando
necesitemos multiplicar un vector de velocidad por un intervalo de tiempo para
obtener la distancia recorrida durante ese tiempo.
Los diferentes tipos de actores tienen sus propias clases debido a que su
comportamiento es muy diferente. Definamos estas clases. Llegaremos a sus
métodos update más adelante.
La clase Player tiene una propiedad speed que almacena su velocidad actual
para simular el impulso y la gravedad.
class Player {
constructor(pos, speed) {
this.pos = pos;
this.speed = speed;
}
get type() { return "player"; }
static create(pos) {
return new Player(pos.plus(new Vec(0, -0.5)),
new Vec(0, 0));
}
}
Player.prototype.size = new Vec(0.8, 1.5);
Dado que un jugador tiene una altura de un cuadro y medio, su posición inicial
se establece medio cuadro por encima de la posición donde apareció el carácter
@. De esta manera, su parte inferior se alinea con la parte inferior del cuadro
en el que apareció.
266

-- 278 of 445 --

La propiedad size es la misma para todas las instancias de Player, por
lo que la almacenamos en el prototipo en lugar de en las propias instancias.
Podríamos haber utilizado un getter como type, pero eso crearía y devolvería
un nuevo objeto Vec cada vez que se lee la propiedad, lo cual sería derrochador.
(Las cadenas, al ser inmutables, no tienen que ser recreadas cada vez que se
evalúan).
Al construir un actor Lava, necesitamos inicializar el objeto de manera difer-
ente dependiendo del personaje en el que se base. La lava dinámica se mueve
a lo largo de su velocidad actual hasta que choca con un obstáculo. En ese
momento, si tiene una propiedad de reset, saltará de nuevo a su posición de
inicio (goteando). Si no la tiene, invertirá su velocidad y continuará en la otra
dirección (rebotando).
El método create mira el carácter que pasa el constructor de Level y crea
el actor de lava apropiado.
class Lava {
constructor(pos, speed, reset) {
this.pos = pos;
this.speed = speed;
this.reset = reset;
}
get type() { return "lava"; }
static create(pos, ch) {
if (ch == "=") {
return new Lava(pos, new Vec(2, 0));
} else if (ch == "|") {
return new Lava(pos, new Vec(0, 2));
} else if (ch == "v") {
return new Lava(pos, new Vec(0, 3), pos);
}
}
}
Lava.prototype.size = new Vec(1, 1);
Los actores Coin son relativamente simples. Mayoritariamente solo se quedan
en su lugar. Pero para animar un poco el juego, se les da un “balanceo”, un
ligero movimiento vertical de ida y vuelta. Para hacer un seguimiento de esto,
un objeto moneda almacena una posición base y también una propiedad de
wobble que sigue la fase del movimiento de balanceo. Juntos, estos determinan
la posición real de la moneda (almacenada en la propiedad pos).
267

-- 279 of 445 --

class Coin {
constructor(pos, basePos, wobble) {
this.pos = pos;
this.basePos = basePos;
this.wobble = wobble;
}
get type() { return "coin"; }
static create(pos) {
let basePos = pos.plus(new Vec(0.2, 0.1));
return new Coin(basePos, basePos,
Math.random() * Math.PI * 2);
}
}
Coin.prototype.size = new Vec(0.6, 0.6);
En Capítulo 14, vimos que Math.sin nos da la coordenada y de un punto en
un círculo. Esa coordenada va de ida y vuelta en una forma de onda suave a
medida que nos movemos a lo largo del círculo, lo que hace que la función seno
sea útil para modelar un movimiento ondulado.
Para evitar una situación en la que todas las monedas se mueven hacia arriba
y hacia abajo sincrónicamente, la fase inicial de cada moneda se aleatoriza. El
periodo de la onda de Math.sin, el ancho de una onda que produce, es 2π.
Multiplicamos el valor devuelto por Math.random por ese número para darle a
la moneda una posición inicial aleatoria en la onda.
Ahora podemos definir el objeto levelChars que mapea caracteres del plano
a tipos de cuadrícula de fondo o clases de actor.
const levelChars = {
".": "empty", "#": "wall", "+": "lava",
"@": Player, "o": Coin,
"=": Lava, "|": Lava, "v": Lava
};
Esto nos brinda todas las partes necesarias para crear una instancia de Level.
let simpleLevel = new Level(simpleLevelPlan);
console.log(`${simpleLevel.width} by ${simpleLevel.height}`);
// → 22 by 9
La tarea por delante es mostrar esos niveles en pantalla y modelar el tiempo y
movimiento dentro de ellos.
268

-- 280 of 445 --

Dibujo
En el próximo capítulo, mostraremos el mismo juego de una manera diferente.
Para hacerlo posible, colocamos la lógica de dibujo detrás de una interfaz y la
pasamos al juego como argumento. De esta manera, podemos usar el mismo
programa de juego con diferentes nuevos módulos de visualización.
Un objeto de visualización de juego dibuja un nivel y estado dados. Pasamos
su constructor al juego para permitir que sea reemplazado. La clase de vi-
sualización que definimos en este capítulo se llama DOMDisplay porque utiliza
elementos del DOM para mostrar el nivel.
Utilizaremos una hoja de estilo para establecer los colores reales y otras
propiedades fijas de los elementos que conforman el juego. También sería posi-
ble asignar directamente a la propiedad style de los elementos al crearlos, pero
eso produciría programas más verbosos.
La siguiente función auxiliar proporciona una forma concisa de crear un
elemento y darle algunos atributos y nodos secundarios:
function elt(nombre, attrs, ...children) {
let dom = document.createElement(nombre);
for (let attr of Object.keys(attrs)) {
dom.setAttribute(attr, attrs[attr]);
}
for (let child of children) {
dom.appendChild(child);
}
return dom;
}
Una visualización se crea dándole un elemento padre al que debe adjuntarse y
un objeto de nivel.
class DOMDisplay {
constructor(padre, nivel) {
this.dom = elt("div", {class: "game"}, dibujarGrid(nivel));
this.actorLayer = null;
padre.appendChild(this.dom);
}
clear() { this.dom.remove(); }
}
La cuadrícula de fondo del nivel, que nunca cambia, se dibuja una vez. Los
actores se vuelven a dibujar cada vez que se actualiza la visualización con un
estado dado. La propiedad actorLayer se utilizará para realizar un seguimiento
269

-- 281 of 445 --

del elemento que contiene a los actores para que puedan ser fácilmente elimi-
nados y reemplazados.
Nuestras coordenadas y tamaños se rastrean en unidades de cuadrícula,
donde un tamaño o distancia de 1 significa un bloque de cuadrícula. Al es-
tablecer tamaños de píxeles, tendremos que escalar estas coordenadas: todo en
el juego sería ridículamente pequeño con un solo píxel por cuadrado. La con-
stante scale indica el número de píxeles que una unidad ocupa en la pantalla.
const escala = 20;
function dibujarGrid(nivel) {
return elt("table", {
class: "background",
style: `width: ${nivel.width * escala}px`
}, ...nivel.rows.map(fila =>
elt("tr", {style: `height: ${escala}px`},
...fila.map(tipo => elt("td", {class: tipo})))
));
}
El elemento <table> se corresponde bien con la estructura de la propiedad
rows del nivel: cada fila de la cuadrícula se convierte en una fila de tabla
(<tr>). Las cadenas en la cuadrícula se usan como nombres de clase para los
elementos de celda de tabla (<td>). El código utiliza el operador de propagación
(triple punto) para pasar matrices de nodos secundarios a elt como argumentos
separados.El siguiente CSS hace que la tabla se vea como el fondo que queremos:
.background { background: rgb(52, 166, 251);
table-layout: fixed;
border-spacing: 0; }
.background td { padding: 0; }
.lava { background: rgb(255, 100, 100); }
.wall { background: white; }
Algunos de estos (table-layout, border-spacing y padding) se utilizan para
suprimir comportamientos predeterminados no deseados. No queremos que el
diseño de la tabla dependa del contenido de sus celdas, ni queremos espacio
entre las celdas de la tabla o relleno dentro de ellas.
La regla background establece el color de fondo. CSS permite que los colores
se especifiquen tanto como palabras (white) como con un formato como rgb(R
, G, B), donde los componentes rojo, verde y azul del color se separan en tres
números de 0 a 255. Por lo tanto, en rgb(52, 166, 251), el componente rojo
es 52, el verde es 166 y el azul es 251. Dado que el componente azul es el más
270

-- 282 of 445 --

grande, el color resultante será azulado. En la regla .lava, el primer número
(rojo) es el más grande.
Dibujamos cada actor creando un elemento DOM para él y estableciendo la
posición y el tamaño de ese elemento en función de las propiedades del actor.
Los valores tienen que ser multiplicados por scale para pasar de unidades de
juego a píxeles.
function drawActors(actors) {
return elt("div", {}, ...actors.map(actor => {
let rect = elt("div", {class: `actor ${actor.type}`});
rect.style.width = `${actor.size.x * scale}px`;
rect.style.height = `${actor.size.y * scale}px`;
rect.style.left = `${actor.pos.x * scale}px`;
rect.style.top = `${actor.pos.y * scale}px`;
return rect;
}));
}
Para agregar más de una clase a un elemento, separamos los nombres de las
clases por espacios. En el siguiente código CSS mostrado a continuación, la
clase actor da a los actores su posición absoluta. El nombre de su tipo se
utiliza como una clase adicional para darles un color. No tenemos que definir
la clase lava de nuevo porque estamos reutilizando la clase para las casillas de
lava de la cuadrícula que definimos anteriormente.
.actor { position: absolute; }
.coin { background: rgb(241, 229, 89); }
.player { background: rgb(64, 64, 64); }
El método syncState se utiliza para que la pantalla muestre un estado dado.
Primero elimina los gráficos de actores antiguos, si los hay, y luego vuelve
a dibujar los actores en sus nuevas posiciones. Puede ser tentador intentar
reutilizar los elementos DOM para actores, pero para que eso funcione, nece-
sitaríamos mucho más trabajo adicional para asociar actores con elementos
DOM y asegurarnos de que eliminamos elementos cuando sus actores desa-
parecen. Dado que típicamente habrá solo un puñado de actores en el juego,
volver a dibujar todos ellos no es costoso.
DOMDisplay.prototype.syncState = function(state) {
if (this.actorLayer) this.actorLayer.remove();
this.actorLayer = drawActors(state.actors);
this.dom.appendChild(this.actorLayer);
this.dom.className = `game ${state.status}`;
this.scrollPlayerIntoView(state);
271

-- 283 of 445 --

};
Al agregar el estado actual del nivel como nombre de clase al contenedor,
podemos estilizar ligeramente al actor del jugador cuando el juego se gana o se
pierde, añadiendo una regla CSS que tenga efecto solo cuando el jugador tiene
un elemento ancestro con una clase específica.
.lost .player {
background: rgb(160, 64, 64);
}
.won .player {
box-shadow: -4px -7px 8px white, 4px -7px 8px white;
}
Después de tocar la lava, el color del jugador se vuelve rojo oscuro, sugiriendo
quemaduras. Cuando se ha recolectado la última moneda, agregamos dos som-
bras blancas difuminadas, una en la parte superior izquierda y otra en la parte
superior derecha, para crear un efecto de halo blanco.
No podemos asumir que el nivel siempre encaja en el viewport – el el-
emento en el que dibujamos el juego. Por eso es necesaria la llamada a
scrollPlayerIntoView. Se asegura de que si el nivel sobresale del viewport,
desplacemos ese viewport para asegurar que el jugador esté cerca de su centro.
El siguiente CSS le da al elemento DOM contenedor del juego un tamaño máx-
imo y asegura que cualquier cosa que sobresalga de la caja del elemento no sea
visible. También le damos una posición relativa para que los actores dentro
de él estén posicionados de manera relativa a la esquina superior izquierda del
nivel.
.game {
overflow: hidden;
max-width: 600px;
max-height: 450px;
position: relative;
}
En el método scrollPlayerIntoView, encontramos la posición del jugador y
actualizamos la posición de desplazamiento del elemento contenedor. Cambi-
amos la posición de desplazamiento manipulando las propiedades scrollLeft y
scrollTop de ese elemento cuando el jugador está demasiado cerca del borde.
DOMDisplay.prototype.scrollPlayerIntoView = function(state) {
let width = this.dom.clientWidth;
let height = this.dom.clientHeight;
let margin = width / 3;
272

-- 284 of 445 --

// El viewport
let left = this.dom.scrollLeft, right = left + width;
let top = this.dom.scrollTop, bottom = top + height;
let player = state.player;
let center = player.pos.plus(player.size.times(0.5))
.times(scale);
if (center.x < left + margin) {
this.dom.scrollLeft = center.x - margin;
} else if (center.x > right - margin) {
this.dom.scrollLeft = center.x + margin - width;
}
if (center.y < top + margin) {
this.dom.scrollTop = center.y - margin;
} else if (center.y > bottom - margin) {
this.dom.scrollTop = center.y + margin - height;
}
};
La forma en que se encuentra el centro del jugador muestra cómo los métodos
en nuestro tipo Vec permiten que los cálculos con objetos se escriban de una
manera relativamente legible. Para encontrar el centro del actor, sumamos su
posición (esquina superior izquierda) y la mitad de su tamaño. Ese es el centro
en coordenadas de nivel, pero lo necesitamos en coordenadas de píxeles, así que
luego multiplicamos el vector resultante por nuestra escala de visualización.
A continuación, una serie de comprobaciones verifica que la posición del
jugador no esté fuera del rango permitido. Ten en cuenta que a veces esto
establecerá coordenadas de desplazamiento sin sentido que están por debajo
de cero o más allá del área desplazable del elemento. Esto está bien, el DOM
las limitará a valores aceptables. Establecer scrollLeft en -10 hará que se
convierta en 0.
Hubiera sido un poco más sencillo intentar siempre desplazar al jugador
al centro del viewport. Pero esto crea un efecto bastante brusco. Mientras
saltas, la vista se desplazará constantemente hacia arriba y hacia abajo. Es
más agradable tener un área “neutral” en el centro de la pantalla donde puedas
moverte sin causar ningún desplazamiento.
Ahora podemos mostrar nuestro pequeño nivel.
<link rel="stylesheet" href="css/game.css">
<script>
273

-- 285 of 445 --

let simpleLevel = new Level(simpleLevelPlan);
let display = new DOMDisplay(document.body, simpleLevel);
display.syncState(State.start(simpleLevel));
</script>
La etiqueta <link>, cuando se utiliza con rel="stylesheet", es una forma de
cargar un archivo CSS en una página. El archivo game.css contiene los estilos
necesarios para nuestro juego.
Movimiento y colisión
Ahora estamos en el punto en el que podemos comenzar a agregar movimiento.
El enfoque básico, seguido por la mayoría de juegos como este, es dividir tiempo
en pequeños pasos y, para cada paso, mover a los actores una distancia cor-
respondiente a su velocidad multiplicada por el tamaño del paso de tiempo.
Mediremos el tiempo en segundos, por lo que las velocidades se expresan en
unidades por segundo.
Mover cosas es fácil. La parte difícil es lidiar con las interacciones entre
los elementos. Cuando el jugador golpea una pared o el suelo, no debería
simplemente atravesarlo. El juego debe notar cuando un movimiento dado
hace que un objeto golpee a otro objeto y responder en consecuencia. Para las
paredes, el movimiento debe detenerse. Al golpear una moneda, esa moneda
debe ser recogida. Al tocar lava, el juego debería perderse.
Resolver esto para el caso general es una tarea grande. Puedes encontrar
bibliotecas, generalmente llamadas motores físicos, que simulan la interacción
entre objetos físicos en dos o tres dimensiones. Tomaremos un enfoque más
modesto en este capítulo, manejando solo colisiones entre objetos rectangulares
y manejándolas de una manera bastante simplista.
Antes de mover al jugador o un bloque de lava, probamos si el movimiento los
llevaría dentro de una pared. Si lo hace, simplemente cancelamos el movimiento
por completo. La respuesta a tal colisión depende del tipo de actor. El jugador
se detendrá, mientras que un bloque de lava rebotará.
Este enfoque requiere que nuestros pasos de tiempo sean bastante pequeños,
ya que hará que el movimiento se detenga antes de que los objetos realmente
274

-- 286 of 445 --

se toquen. Si los pasos de tiempo (y por lo tanto los pasos de movimiento) son
demasiado grandes, el jugador terminaría elevándose a una distancia notable
sobre el suelo. Otro enfoque, argumentablemente mejor pero más complicado,
sería encontrar el punto exacto de colisión y moverse allí. Tomaremos el enfoque
simple y ocultaremos sus problemas asegurando que la animación avance en
pasos pequeños.
Este método nos indica si un rectángulo (especificado por una posición y un
tamaño) toca un elemento de rejilla de un tipo dado.
Level.prototype.touches = function(pos, size, type) {
let xStart = Math.floor(pos.x);
let xEnd = Math.ceil(pos.x + size.x);
let yStart = Math.floor(pos.y);
let yEnd = Math.ceil(pos.y + size.y);
for (let y = yStart; y < yEnd; y++) {
for (let x = xStart; x < xEnd; x++) {
let isOutside = x < 0 || x >= this.width ||
y < 0 || y >= this.height;
let here = isOutside ? "wall" : this.rows[y][x];
if (here == type) return true;
}
}
return false;
};
El método calcula el conjunto de cuadrados de rejilla con los que el cuerpo se
superpone utilizando Math.floor y Math.ceil en sus coordenadas. Recuerda
que los cuadrados de la rejilla son de tamaño 1 por 1 unidad. Al redondear los
lados de un cuadro hacia arriba y hacia abajo, obtenemos el rango de cuadrados
de fondo que el cuadro toca.
Recorremos el bloque de cuadrados de rejilla encontrado al redondear las
coordenadas y devolvemos true cuando se encuentra un cuadro coincidente.
Los cuadrados fuera del nivel siempre se tratan como "wall" para asegurar
que el jugador no pueda salir del mundo y que no intentemos leer fuera de los
límites de nuestra matriz rows.
El método update de estado utiliza touches para determinar si el jugador
275

-- 287 of 445 --

está tocando lava.
State.prototype.update = function(time, keys) {
let actors = this.actors
.map(actor => actor.update(time, this, keys));
let newState = new State(this.level, actors, this.status);
if (newState.status != "playing") return newState;
let player = newState.player;
if (this.level.touches(player.pos, player.size, "lava")) {
return new State(this.level, actors, "lost");
}
for (let actor of actors) {
if (actor != player && overlap(actor, player)) {
newState = actor.collide(newState);
}
}
return newState;
};
El método recibe un paso de tiempo y una estructura de datos que le indica
qué teclas se mantienen presionadas. Lo primero que hace es llamar al método
update en todos los actores, produciendo un array de actores actualizados. Los
actores también reciben el paso de tiempo, las teclas y el estado, para que
puedan basar su actualización en esos valores. Solo el jugador realmente lee las
teclas, ya que es el único actor controlado por el teclado.
Si el juego ya ha terminado, no es necesario realizar más procesamiento (no
se puede ganar el juego después de haber perdido, o viceversa). De lo contrario,
el método prueba si el jugador está tocando lava de fondo. Si es así, se pierde
el juego y hemos terminado. Finalmente, si el juego sigue en curso, verifica
si algún otro actor se superpone al jugador.La superposición entre actores se
detecta con la función overlap. Toma dos objetos actor y devuelve true cuando
se tocan, lo cual sucede cuando se superponen tanto a lo largo del eje x como
a lo largo del eje y.
function overlap(actor1, actor2) {
return actor1.pos.x + actor1.size.x > actor2.pos.x &&
actor1.pos.x < actor2.pos.x + actor2.size.x &&
actor1.pos.y + actor1.size.y > actor2.pos.y &&
actor1.pos.y < actor2.pos.y + actor2.size.y;
}
Si algún actor se superpone, su método collide tiene la oportunidad de actu-
276

-- 288 of 445 --

alizar el estado. Tocar un actor de lava establece el estado del juego en "lost".
Las monedas desaparecen cuando las tocas y establecen el estado en "won"
cuando son la última moneda del nivel.
Lava.prototype.collide = function(state) {
return new State(state.level, state.actors, "lost");
};
Coin.prototype.collide = function(state) {
let filtered = state.actors.filter(a => a != this);
let status = state.status;
if (!filtered.some(a => a.type == "coin")) status = "won";
return new State(state.level, filtered, status);
};
Actualizaciones de actores
Los métodos update de los objetos actor toman como argumentos el paso de
tiempo, el objeto de estado y un objeto keys. El de tipo actor Lava ignora el
objeto keys.
Lava.prototype.update = function(time, state) {
let newPos = this.pos.plus(this.speed.times(time));
if (!state.level.touches(newPos, this.size, "wall")) {
return new Lava(newPos, this.speed, this.reset);
} else if (this.reset) {
return new Lava(this.reset, this.speed, this.reset);
} else {
return new Lava(this.pos, this.speed.times(-1));
}
};
Este método update calcula una nueva posición agregando el producto del paso
de tiempo y la velocidad actual a su posición anterior. Si no hay obstáculos
que bloqueen esa nueva posición, se mueve allí. Si hay un obstáculo, el com-
portamiento depende del tipo de bloque de lava—la lava goteante tiene una
posición de reset a la que regresa cuando golpea algo. La lava rebotante in-
vierte su velocidad multiplicándola por -1 para que comience a moverse en la
dirección opuesta.
Las monedas utilizan su método update para balancearse. Ignoran las coli-
siones con la cuadrícula ya que simplemente se balancean dentro de su propio
cuadrado.
277

-- 289 of 445 --

const wobbleSpeed = 8, wobbleDist = 0.07;
Coin.prototype.update = function(time) {
let wobble = this.wobble + time * wobbleSpeed;
let wobblePos = Math.sin(wobble) * wobbleDist;
return new Coin(this.basePos.plus(new Vec(0, wobblePos)),
this.basePos, wobble);
};
La propiedad wobble se incrementa para hacer un seguimiento del tiempo y
luego se utiliza como argumento para Math.sin para encontrar la nueva posición
en la onda. La posición actual de la moneda se calcula a partir de su posición
base y un desplazamiento basado en esta onda.
Eso deja al jugador en sí. El movimiento del jugador se maneja por separado
por eje porque golpear el suelo no debería impedir el movimiento horizontal, y
golpear una pared no debería detener el movimiento de caída o de salto.
const playerXSpeed = 7;
const gravity = 30;
const jumpSpeed = 17;
Player.prototype.update = function(time, state, keys) {
let xSpeed = 0;
if (keys.ArrowLeft) xSpeed -= playerXSpeed;
if (keys.ArrowRight) xSpeed += playerXSpeed;
let pos = this.pos;
let movedX = pos.plus(new Vec(xSpeed * time, 0));
if (!state.level.touches(movedX, this.size, "wall")) {
pos = movedX;
}
let ySpeed = this.speed.y + time * gravity;
let movedY = pos.plus(new Vec(0, ySpeed * time));
if (!state.level.touches(movedY, this.size, "wall")) {
pos = movedY;
} else if (keys.ArrowUp && ySpeed > 0) {
ySpeed = -jumpSpeed;
} else {
ySpeed = 0;
}
return new Player(pos, new Vec(xSpeed, ySpeed));
};
El movimiento horizontal se calcula en función del estado de las teclas de flecha
izquierda y derecha. Cuando no hay una pared bloqueando la nueva posición
278

-- 290 of 445 --

creada por este movimiento, se utiliza. De lo contrario, se mantiene la posición
anterior.
El movimiento vertical funciona de manera similar pero tiene que simular
saltos y gravedad. La velocidad vertical del jugador (ySpeed) se acelera primero
para tener en cuenta la gravedad.
Comprobamos las paredes nuevamente. Si no golpeamos ninguna, se usa
la nueva posición. Si hay una pared, hay dos posibles resultados. Cuando
se presiona la flecha hacia arriba y estamos bajando (lo que significa que lo
que golpeamos está debajo de nosotros), la velocidad se establece en un valor
negativo relativamente grande. Esto hace que el jugador salte. Si ese no es el
caso, el jugador simplemente chocó con algo y la velocidad se establece en cero.
La fuerza de la gravedad, la velocidad de salto y otras constantes en el juego
se determinaron simplemente probando algunos números y viendo cuáles se
sentían correctos. Puedes experimentar con ellos.
Seguimiento de teclas
Para un juego como este, no queremos que las teclas tengan efecto una vez
por pulsación de tecla. Más bien, queremos que su efecto (mover la figura del
jugador) se mantenga activo mientras se mantienen presionadas.
Necesitamos configurar un controlador de teclas que almacene el estado ac-
tual de las teclas de flecha izquierda, derecha y arriba. También queremos
llamar a preventDefault para esas teclas para que no terminen desplazando la
página.
La siguiente función, al darle un array de nombres de teclas, devolverá un
objeto que sigue la posición actual de esas teclas. Registra controladores de
eventos para eventos "keydown" y "keyup" y, cuando el código de tecla en el
evento está presente en el conjunto de códigos que está siguiendo, actualiza el
objeto.
function trackKeys(keys) {
let down = Object.create(null);
function track(event) {
if (keys.includes(event.key)) {
down[event.key] = event.type == "keydown";
event.preventDefault();
}
}
window.addEventListener("keydown", track);
window.addEventListener("keyup", track);
return down;
279

-- 291 of 445 --

}
const arrowKeys = trackKeys(["ArrowLeft", "ArrowRight", "ArrowUp"]);
La misma función manejadora se utiliza para ambos tipos de eventos. Esta
función examina la propiedad type del objeto de evento para determinar si el
estado de la tecla debe actualizarse a verdadero ("keydown") o falso ("keyup").
Ejecutando el juego
La función requestAnimationFrame, que vimos en el Capítulo 14, proporciona
una buena forma de animar un juego. Pero su interfaz es bastante primitiva,
ya que su uso requiere que llevemos un registro del momento en que se llamó a
nuestra función la última vez y llamemos a requestAnimationFrame nuevamente
después de cada fotograma.
Vamos a definir una función auxiliar que envuelva todo eso en una inter-
faz conveniente y nos permita simplemente llamar a runAnimation, dándole
una función que espera una diferencia de tiempo como argumento y dibuja un
solo fotograma. Cuando la función de fotograma devuelve el valor false, la
animación se detiene.
function runAnimation(frameFunc) {
let lastTime = null;
function frame(time) {
if (lastTime != null) {
let timeStep = Math.min(time - lastTime, 100) / 1000;
if (frameFunc(timeStep) === false) return;
}
lastTime = time;
requestAnimationFrame(frame);
}
requestAnimationFrame(frame);
}
He establecido un paso de fotograma máximo de 100 milisegundos (una décima