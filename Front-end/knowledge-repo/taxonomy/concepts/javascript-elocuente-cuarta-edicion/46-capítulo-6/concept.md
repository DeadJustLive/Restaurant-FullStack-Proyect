# Capítulo 6.

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 46)

## Contenido
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

-- 279 of 445 -
