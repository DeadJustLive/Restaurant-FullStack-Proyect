# parte d: e la cuadrícula de fondo o un elemento móvil.

El plan para un nivel pequeño podría verse así:
let simpleLevelPlan = `
......................
..#................#..
..#..............=.#..
..#.........o.o....#..
..#.@......#####...#..
..#####............#..
......#++++++++++++#..
......##############..
......................`;
Los puntos representan un espacio vacío, los caracteres de almohadilla (#) son
paredes y los signos más son lava. La posición inicial del jugador es el signo
de arroba (@). Cada carácter O es una moneda, y el signo igual (=) en la parte
superior es un bloque de lava que se mueve de un lado a otro horizontalmente.
Además de las dos formas adicionales de lava en movimiento, el carácter de
tubería (|) crea blobs que se mueven verticalmente, y v indica lava goteante:
lava que se mueve verticalmente y no rebota de un lado a otro, solo se mueve
hacia abajo, volviendo a su posición de inicio cuando golpea el suelo.
Un juego completo consta de varios niveles que el jugador debe completar.
Un nivel se completa cuando se han recolectado todas las monedas. Si el jugador
toca la lava, el nivel actual se restablece a su posición inicial y el jugador puede
intentarlo de nuevo.
Leyendo un nivel
La siguiente clase almacena un objeto nivel. Su argumento debe ser la cadena
que define el nivel.
class Level {
constructor(plan) {
let rows = plan.trim().split("\n").map(l => [...l]);
this.height = rows.length;
this.width = rows[0].length;
this.startActors = [];
263

-- 275 of 445 --

this.rows = rows.map((row, y) => {
return row.map((ch, x) => {
let type = levelChars[ch];
if (typeof type != "string") {
let pos = new Vec(x, y);
this.startActors.push(type.create(pos, ch));
type = "empty";
}
return type;
});
});
}
}
El método trim se utiliza para eliminar los espacios en blanco al principio y al
final de la cadena de plan. Esto permite que nuestro plan de ejemplo comience
con una nueva línea para que todas las líneas estén directamente debajo unas
de otras. La cadena restante se divide en líneas en caracteres de nueva línea, y
cada línea se convierte en un array, produciendo arrays de caracteres.
Entonces, rows contiene un array de arrays de caracteres, las filas del plan.
Podemos derivar el ancho y alto del nivel a partir de estos. Pero aún debemos
separar los elementos móviles de la cuadrícula de fondo. Llamaremos a los
elementos móviles actores. Se almacenarán en un array de objetos. El fondo
será un array de arrays de cadenas, que contienen tipos de campo como "empty",
"wall", o "lava".
Para crear estos arrays, mapeamos sobre las filas y luego sobre su contenido.
Recuerda que map pasa el índice del array como segundo argumento a la función
de mapeo, lo que nos indica las coordenadas x e y de un carácter dado. Las
posiciones en el juego se almacenarán como pares de coordenadas, siendo la
esquina superior izquierda 0,0 y cada cuadro de fondo siendo de 1 unidad de
alto y ancho.
Para interpretar los caracteres en el plan, el constructor de Level utiliza el
objeto levelChars, que, para cada carácter utilizado en las descripciones de
niveles, contiene una cadena si es un tipo de fondo, y una clase si produce un
actor. Cuando type es una clase de actor, se utiliza su método estático create
para crear un objeto, que se agrega a startActors, y la función de mapeo
devuelve "empty" para este cuadro de fondo.
La posición del actor se almacena como un objeto Vec. Este es un vector
bidimensional, un objeto con propiedades x e y, como se ve en los ejercicios del