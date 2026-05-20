# parte d: e un segundo). Cuando la pestaña del navegador o la ventana con

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 47)

## Contenido
# parte d: e un segundo). Cuando la pestaña del navegador o la ventana con

nuestra página está oculta, las llamadas a requestAnimationFrame se suspenden
hasta que la pestaña o la ventana se vuelva a mostrar. En este caso, la diferencia
entre lastTime y time será todo el tiempo en el que la página estuvo oculta.
Avanzar el juego tanto en un solo paso se vería ridículo y podría causar efectos
secundarios extraños, como que el jugador caiga a través del suelo.
La función también convierte los pasos de tiempo a segundos, que son una
280

-- 292 of 445 --

cantidad más fácil de entender que los milisegundos.
La función runLevel toma un objeto Level y un constructor de display y de-
vuelve una promesa. Muestra el nivel (en document.body) y permite al usuario
jugar a través de él. Cuando el nivel termina (perdido o ganado), runLevel
espera un segundo más (para que el usuario vea qué sucede), luego borra la
pantalla, detiene la animación y resuelve la promesa con el estado final del
juego.
function runLevel(level, Display) {
let display = new Display(document.body, level);
let state = State.start(level);
let ending = 1;
return new Promise(resolve => {
runAnimation(time => {
state = state.update(time, arrowKeys);
display.syncState(state);
if (state.status == "playing") {
return true;
} else if (ending > 0) {
ending -= time;
return true;
} else {
display.clear();
resolve(state.status);
return false;
}
});
});
}
Un juego es una secuencia de niveles. Cada vez que el jugador muere, el nivel
actual se reinicia. Cuando se completa un nivel, pasamos al siguiente nivel.
Esto se puede expresar mediante la siguiente función, que toma un array de
planes de nivel (cadenas) y un constructor de display:
async function runGame(plans, Display) {
for (let level = 0; level < plans.length;) {
let status = await runLevel(new Level(plans[level]),
Display);
if (status == "ganado") level++;
}
console.log("¡Has ganado!");
}
Debido a que hicimos que runLevel devuelva una promesa, runGame puede
281

-- 293 of 445 --

escribirse utilizando una función async, como se muestra en el Capítulo 11.
Devuelve otra promesa, que se resuelve cuando el jugador termina el juego.
Hay un conjunto de planes de niveles disponibles en el enlace GAME_LEVELS
en el sandbox de este capítulo (https://eloquentjavascript.net/code#16). Esta
página los alimenta a runGame, comenzando un juego real.
<link rel="stylesheet" href="css/game.css">
<body>
<script>
runGame(GAME_LEVELS, DOMDisplay);
</script>
</body>
Ejercicios
Juego terminado
Es tradicional que los juegos de plataformas hagan que el jugador comience con
un número limitado de vidas y resten una vida cada vez que mueren. Cuando
el jugador se queda sin vidas, el juego se reinicia desde el principio.
Ajusta runGame para implementar vidas. Haz que el jugador comience con
tres vidas. Muestra el número actual de vidas (usando console.log) cada vez
que comienza un nivel.
Pausar el juego
Haz posible pausar y despausar el juego presionando la tecla Esc.
Esto se puede hacer cambiando la función runLevel para configurar un mane-
jador de eventos de teclado que interrumpa o reanude la animación cada vez
que se presiona la tecla Esc.
La interfaz de runAnimation puede no parecer adecuada para esto a primera
vista, pero lo es si reorganizas la forma en que runLevel la llama.
Cuando tengas eso funcionando, hay algo más que podrías intentar. La forma
en que hemos estado registrando los controladores de eventos de teclado es algo
problemática. El objeto arrowKeys es actualmente una asignación global, y sus
controladores de eventos se mantienen incluso cuando no hay ningún juego en
ejecución. Podrías decir que escapan de nuestro sistema. Amplía trackKeys
para proporcionar una forma de anular el registro de sus controladores y luego
cambia runLevel para registrar sus controladores cuando comienza y desregis-
trarlos nuevamente cuando termine.
282

-- 294 of 445 --

Un monstruo
Es tradicional que los juegos de plataformas tengan enemigos a los que puedes
saltar encima para derrotar. Este ejercicio te pide que agregues un tipo de
actor así al juego.
Lo llamaremos monstruo. Los monstruos se mueven solo horizontalmente.
Puedes hacer que se muevan en la dirección del jugador, que reboten de un
lado a otro como lava horizontal, o tengan cualquier patrón de movimiento que
desees. La clase no tiene que manejar caídas, pero debe asegurarse de que el
monstruo no atraviese paredes.
Cuando un monstruo toca al jugador, el efecto depende de si el jugador está
saltando encima de ellos o no. Puedes aproximarlo comprobando si el final
del jugador está cerca de la parte superior del monstruo. Si este es el caso, el
monstruo desaparece. Si no, el juego se pierde.
283

-- 295 of 445 --

“Dibujar es engañar.”
—M.C. Escher, citado por Bruno Ernst en El Espejo Mágico de
M.C. Escher
