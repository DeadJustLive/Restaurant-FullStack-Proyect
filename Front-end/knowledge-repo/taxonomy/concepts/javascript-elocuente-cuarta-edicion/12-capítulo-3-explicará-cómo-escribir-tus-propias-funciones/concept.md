# Capítulo 3: explicará cómo escribir tus propias funciones.

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 12)

## Contenido
# Capítulo 3: explicará cómo escribir tus propias funciones.

Control de flujo
Cuando tu programa contiene más de una sentencia, las sentencias se ejecutan
como si fueran una historia, de arriba hacia abajo. Por ejemplo, el siguiente
programa tiene dos sentencias. La primera le pide al usuario un número, y
la segunda, que se ejecuta después de la primera, muestra el cuadrado de ese
número:
let elNumero = Number(prompt("Elige un número"));
console.log("Tu número es la raíz cuadrada de " +
elNumero * elNumero);
La función Number convierte un valor a un número. Necesitamos esa conversión
porque el resultado de prompt es un valor de tipo string, y queremos un número.
27

-- 39 of 445 --

Hay funciones similares llamadas String y Boolean que convierten valores a esos
tipos.
Aquí está la representación esquemática bastante trivial del flujo de control
en línea recta:
Ejecución condicional
No todos los programas son caminos rectos. Podríamos, por ejemplo, querer
crear una carretera ramificada donde el programa tome la rama adecuada
basada en la situación en cuestión. Esto se llama ejecución condicional.
La ejecución condicional se crea con la palabra clave if en JavaScript. En
el caso simple, queremos que cierto código se ejecute si, y solo si, una cierta
condición es verdadera. Por ejemplo, podríamos querer mostrar el cuadrado de
la entrada solo si la entrada es realmente un número:
let elNumero = Number(prompt("Elige un número"));
if (!Number.isNaN(elNumero)) {
console.log("Tu número es la raíz cuadrada de " +
elNumero * elNumero);
}
Con esta modificación, si introduces “loro”, no se mostrará ninguna salida.
La palabra clave if ejecuta o salta una sentencia dependiendo del valor de
una expresión booleana. La expresión de decisión se escribe después de la
palabra clave, entre paréntesis, seguida de la sentencia a ejecutar.
La función Number.isNaN es una función estándar de JavaScript que devuelve
true solo si el argumento que se le pasa es NaN. La función Number devuelve NaN
cuando le das una cadena que no representa un número válido. Por lo tanto,
la condición se traduce a “a menos que elNumero no sea un número, haz esto”.
La sentencia después del if está envuelta entre llaves ({ y }) en este ejemplo.
Las llaves se pueden usar para agrupar cualquier cantidad de sentencias en una
sola sentencia, llamada un bloque. También podrías haber omitido en este caso,
ya que contienen solo una sentencia, pero para evitar tener que pensar si son
necesarias, la mayoría de los programadores de JavaScript las usan en cada
sentencia envuelta de esta manera. Seguiremos principalmente esa convención
28

-- 40 of 445 --

en este libro, excepto por los casos ocasionales de una sola línea.
if (1 + 1 == 2) console.log("Es verdad");
// → Es verdad
A menudo no solo tendrás código que se ejecuta cuando una condición es ver-
dadera, sino también código que maneja el otro caso. Esta ruta alternativa
está representada por la segunda flecha en el diagrama. Puedes usar la palabra
clave else, junto con if, para crear dos caminos de ejecución alternativos y
separados:
let elNumero = Number(prompt("Elige un número"));
if (!Number.isNaN(elNumero)) {
console.log("Tu número es la raíz cuadrada de " +
elNumero * elNumero);
} else {
console.log("Oye. ¿Por qué no me diste un número?");
}
Si tienes más de dos caminos para elegir, puedes “encadenar” múltiples pares
if/else. Aquí tienes un ejemplo:
let num = Number(prompt("Escoge un número"));
if (num < 10) {
console.log("Pequeño");
} else if (num < 100) {
console.log("Mediano");
} else {
console.log("Grande");
}
El programa primero comprueba si num es menor que 10. Si lo es, elige esa rama,
muestra "Pequeño", y termina. Si no lo es, toma la rama else, la cual contiene
a su vez otro if. Si la segunda condición (< 100) se cumple, eso significa que
el número es al menos 10 pero menor que 100, y se muestra "Mediano". Si no,
se elige la segunda y última rama else.
El esquema de este programa se ve más o menos así:
29

-- 41 of 445 --

Bucles while y do
Considera un programa que imprime todos los números pares de 0 a 12. Una
forma de escribirlo es la siguiente:
console.log(0);
console.log(2);
console.log(4);
console.log(6);
console.log(8);
console.log(10);
console.log(12);
Eso funciona, pero la idea de escribir un programa es hacer menos trabajo, no
más. Si necesitáramos todos los números pares menores que 1,000, este enfoque
sería inviable. Lo que necesitamos es una manera de ejecutar un fragmento de
código múltiples veces. Esta forma de control de flujo se llama bucle.
El control de flujo mediante bucles nos permite regresar a algún punto en el
programa donde estábamos antes y repetirlo con nuestro estado de programa
actual. Si combinamos esto con una variable que cuente, podemos hacer algo
como esto:
let numero = 0;
while (numero <= 12) {
console.log(numero);
numero = numero + 2;
}
// → 0
// → 2
// … etcétera
Un statement que comienza con la palabra clave while crea un bucle. La pal-
abra while va seguida 
