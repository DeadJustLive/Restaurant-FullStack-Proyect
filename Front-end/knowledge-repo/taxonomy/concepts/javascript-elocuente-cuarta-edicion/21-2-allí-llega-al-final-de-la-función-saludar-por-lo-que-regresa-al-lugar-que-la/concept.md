# 2. Allí, llega al final de la función saludar, por lo que regresa al lugar que la

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 21)

## Contenido
# 2. Allí, llega al final de la función saludar, por lo que regresa al lugar que la

llamó, línea 4. La línea siguiente llama a console.log nuevamente. Después
de ese retorno, el programa llega a su fin.
Podríamos mostrar el flujo de control esquemáticamente de esta manera:
no en función
en saludar
44

-- 56 of 445 --

en console.log
en saludar
no en función
en console.log
no en función
Dado que una función tiene que regresar al lugar que la llamó cuando termina,
la computadora debe recordar el contexto desde el cual se realizó la llamada.
En un caso, console.log tiene que regresar a la función saludar cuando haya
terminado. En el otro caso, regresa al final del programa.
El lugar donde la computadora almacena este contexto es la pila de llamadas.
Cada vez que se llama a una función, el contexto actual se almacena en la
parte superior de esta pila. Cuando una función devuelve, elimina el contexto
superior de la pila y usa ese contexto para continuar la ejecución.
Almacenar esta pila requiere espacio en la memoria de la computadora.
Cuando la pila crece demasiado, la computadora fallará con un mensaje como
“sin espacio en la pila” o “demasiada recursividad”. El siguiente código ilustra
esto al hacerle a la computadora una pregunta realmente difícil que causa un
vaivén infinito entre dos funciones. O más bien, sería infinito, si la computa-
dora tuviera una pila infinita. Como no la tiene, nos quedaremos sin espacio o
“reventaremos la pila”.
function chicken() {
return egg();
}
function egg() {
return chicken();
}
console.log(chicken() + " salió primero.");
// → ??
Argumentos Opcionales
El siguiente código está permitido y se ejecuta sin ningún problema:
function square(x) { return x * x; }
console.log(square(4, true, "erizo"));
// → 16
Hemos definido square con solo un parámetro. Sin embargo, cuando lo lla-
mamos con tres, el lenguaje no se queja. Ignora los argumentos adicionales y
calcula el cuadrado del primero.
45

-- 57 of 445 --

JavaScript es extremadamente flexible en cuanto al número de argumentos
que puedes pasar a una función. Si pasas demasiados, los extras son ignorados.
Si pasas muy pocos, los parámetros faltantes se les asigna el valor undefined.
El inconveniente de esto es que es posible —incluso probable— que pases
accidentalmente el número incorrecto de argumentos a las funciones. Y nadie
te dirá nada al respecto. La ventaja es que puedes utilizar este comportamiento
para permitir que una función sea llamada con diferentes números de argumen-
tos. Por ejemplo, esta función minus intenta imitar al operador - actuando
sobre uno o dos argumentos:
function minus(a, b) {
if (b === undefined) return -a;
else return a - b;
}
console.log(minus(10));
// → -10
console.log(minus(10, 5));
// → 5
Si escribes un operador = después de un parámetro, seguido de una expresión,
el valor de esa expresión reemplazará al argumento cuando no se le dé. Por
ejemplo, esta versión de roundTo hace que su segundo argumento sea opcional.
Si no lo proporcionas o pasas el valor undefined, por defecto será uno:
function roundTo(n, step = 1) {
let remainder = n % step;
return n - remainder + (remainder < step / 2 ? 0 : step);
};
console.log(roundTo(4.5));
// → 5
console.log(roundTo(4.5, 2));
// → 4
El próximo capítulo introducirá una forma en que un cuerpo de función puede
acceder a la lista completa de argumentos que se le pasaron. Esto es útil porque
le permite a una función aceptar cualquier número de argumentos. Por ejemplo,
console.log lo hace, mostrando todos los valores que se le dan:
console.log("C", "O", 2);
// → C O 2
46

-- 58 of 445 --

Clausura
La capacidad de tratar las funciones como valores, combinada con el hecho de
que las vinculaciones locales se recrean cada vez que se llama a una función,
plantea una pregunta interesante: ¿qué sucede con las vinculaciones locales
cuando la llamada a la función que las creó ya no está activa?El siguiente
código muestra un ejemplo de esto. Define una función, wrapValue, que crea
un enlace local. Luego devuelve una función que accede y devuelve este enlace
local:
function wrapValue(n) {
let local = n;
return () => local;
}
let wrap1 = wrapValue(1);
let wrap2 = wrapValue(2);
console.log(wrap1());
// → 1
console.log(wrap2());
// → 2
Esto está permitido y funciona como esperarías: ambas instancias del enlace
aún pueden accederse. Esta situación es una buena demostración de que los
enlaces locales se crean nuevamente para cada llamada, y las diferentes llamadas
no afectan los enlaces locales de los demás.
Esta característica, poder hacer referencia a una instancia específica de un
enlace local en un ámbito superior, se llama clausura. Una función que hace
referencia a enlaces de ámbitos locales a su alrededor se llama una clausura.
Este comportamiento no solo te libera de tener que preocuparte por la vida útil
de los enlaces, sino que también hace posible usar valores de función de formas
creativas.
Con un ligero cambio, podemos convertir el ejemplo anterior en una forma
de cr
