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
abra while va seguida de una expresión entre paréntesis y luego un enunciado,
similar a if. El bucle sigue ejecutando ese enunciado mientras la expresión
produzca un valor que se convierta en true al convertirse a Booleano.
El enlace ‘number’ demuestra la forma en que un enlace puede seguir el
progreso de un programa. Cada vez que se repite el bucle, ‘number’ obtiene un
valor que es 2 más que su valor anterior. Al comienzo de cada repetición, se
compara con el número 12 para decidir si el trabajo del programa ha terminado.
30

-- 42 of 445 --

Como ejemplo de algo realmente útil, ahora podemos escribir un programa
que calcule y muestre el valor de 210 (2 elevado a la 10ª potencia). Usamos dos
enlaces: uno para llevar un seguimiento de nuestro resultado y otro para contar
cuántas veces hemos multiplicado este resultado por 2. El bucle comprueba si
el segundo enlace ha alcanzado 10 aún y, si no, actualiza ambos enlaces.
let result = 1;
let counter = 0;
while (counter < 10) {
result = result * 2;
counter = counter + 1;
}
console.log(result);
// → 1024
El contador también podría haber comenzado en 1 y haber comprobado si era
<= 10, pero por razones que se harán evidentes en el Capítulo 4, es buena idea
acostumbrarse a contar desde 0.
Ten en cuenta que JavaScript también tiene un operador para la exponen-
ciación (2 ** 10), que usarías para calcular esto en un código real, pero eso
habría arruinado el ejemplo.
Un bucle do es una estructura de control similar a un bucle while. La única
diferencia radica en que un bucle do siempre ejecuta su cuerpo al menos una vez,
y comienza a probar si debe detenerse solo después de esa primera ejecución.
Para reflejar esto, la prueba aparece después del cuerpo del bucle:
let tuNombre;
do {
tuNombre = prompt("¿Quién eres?");
} while (!tuNombre);
console.log("Hola " + tuNombre);
Este programa te obligará a ingresar un nombre. Preguntará una y otra vez
hasta que obtenga algo que no sea una cadena vacía. Aplicar el operador !
convertirá un valor al tipo Booleano antes de negarlo, y todas las cadenas
excepto "" se convierten en true. Esto significa que el bucle continúa hasta
que proporciones un nombre no vacío.
Sangrado de Código
En los ejemplos, he estado agregando espacios delante de las sentencias que
son parte de alguna otra sentencia más grande. Estos espacios no son necesar-
ios: la computadora aceptará el programa perfectamente sin ellos. De hecho,
31

-- 43 of 445 --

incluso los saltos de línea en los programas son opcionales. Podrías escribir un
programa como una sola línea larga si así lo deseas.
El papel de este sangrado dentro de los bloques es hacer que la estructura
del código resalte para los lectores humanos. En el código donde se abren
nuevos bloques dentro de otros bloques, puede volverse difícil ver dónde termina
un bloque y comienza otro. Con un sangrado adecuado, la forma visual de
un programa corresponde a la forma de los bloques dentro de él. A mí me
gusta usar dos espacios para cada bloque abierto, pero los gustos difieren:
algunas personas usan cuatro espacios y otras usan caracteres de tabulación.
Lo importante es que cada nuevo bloque agregue la misma cantidad de espacio.
if (false != true) {
console.log("Tiene sentido.");
if (1 < 2) {
console.log("No hay sorpresas ahí.");
}
}
La mayoría de los programas de edición (incluido el de este libro) ayudarán
automáticamente con la sangría adecuada al escribir nuevas líneas.
bucles for
Muchos bucles siguen el patrón mostrado en los ejemplos de while. Primero
se crea una variable de “contador” para rastrear el progreso del bucle. Luego
viene un bucle while, generalmente con una expresión de prueba que verifica
si el contador ha alcanzado su valor final. Al final del cuerpo del bucle, el
contador se actualiza para rastrear el progreso.
Debido a que este patrón es tan común, JavaScript y lenguajes similares
proporcionan una forma ligeramente más corta y completa, el bucle for:
for (let numero = 0; numero <= 12; numero = numero + 2) {
console.log(numero);
}
// → 0
// → 2
// … etcétera
Este programa es exactamente equivalente al anterior ejemplo de impresión de
números pares. La única diferencia es que todas las declaraciones relacionadas
con el “estado” del bucle están agrupadas después de for.
Los paréntesis después de la palabra clave for deben contener dos punto y
coma. La parte antes del primer punto y coma inicializa el bucle, generalmente
32

-- 44 of 445 --

definiendo una variable. La segunda parte es la expresión que verifica si el bucle
debe continuar. La parte final actualiza el estado del bucle después de cada
iteración. En la mayoría de los casos, esto es más corto y claro que un while
tradicional.
Este es el código que calcula 210 usando for en lugar de while:
let resultado = 1;
for (let contador = 0; contador < 10; contador = contador + 1) {
resultado = resultado * 2;
}
console.log(resultado);
// → 1024
Saliendo de un bucle
Hacer que la condición del bucle produzca false no es la única forma en que un
bucle puede terminar. La instrucción break tiene el efecto de salir inmediata-
mente del bucle que la contiene. Su uso se demuestra en el siguiente programa,
que encuentra el primer número que es mayor o igual a 20 y divisible por 7:
for (let actual = 20; ; actual = actual + 1) {
if (actual % 7 == 0) {
console.log(actual);
break;
}
}
// → 21
Usar el operador de resto (%) es una forma sencilla de comprobar si un número
es divisible por otro. Si lo es, el resto de su división es cero.
La construcción for en el ejemplo no tiene una parte que verifique el final
del bucle. Esto significa que el bucle nunca se detendrá a menos que se ejecute
la instrucción break dentro de él.
Si eliminaras esa declaración break o escribieses accidentalmente una condi-
ción final que siempre produzca true, tu programa quedaría atrapado en un
bucle infinito. Un programa atrapado en un bucle infinito nunca terminará de
ejecutarse, lo cual suele ser algo malo.
La palabra clave continue es similar a break en que influye en el progreso de
un bucle. Cuando se encuentra continue en el cuerpo de un bucle, el control
salta fuera del cuerpo y continúa con la siguiente iteración del bucle.
33

-- 45 of 445 --

Actualización concisa de enlaces
Especialmente al hacer bucles, un programa a menudo necesita “actualizar” un
enlace para que contenga un valor basado en el valor anterior de ese enlace.
counter = counter + 1;
JavaScript proporciona un atajo para esto:
counter += 1;
Atajos similares funcionan para muchos otros operadores, como result *= 2
para duplicar result o counter -= 1 para contar hacia abajo.
Esto nos permite acortar aún más nuestro ejemplo de contar:
for (let number = 0; number <= 12; number += 2) {
console.log(number);
}
Para counter += 1 y counter -= 1, existen equivalentes aún más cortos: counter
++ y counter--.
Despachar un valor con switch
No es raro que el código luzca así:
if (x == "valor1") accion1();
else if (x == "valor2") accion2();
else if (x == "valor3") accion3();
else accionPredeterminada();
Existe una construcción llamada switch que está destinada a expresar dicho
“despacho” de una manera más directa. Desafortunadamente, la sintaxis que
JavaScript utiliza para esto (heredada de la línea de lenguajes de programación
C/Java) es algo incómoda; una cadena de declaraciones if puede verse mejor.
Aquí hay un ejemplo:
switch (prompt("¿Cómo está el clima?")) {
case "lluvioso":
console.log("Recuerda llevar un paraguas.");
break;
case "soleado":
console.log("Vístete ligero.");
case "nublado":
console.log("Sal al exterior.");
34

-- 46 of 445 --

break;
default:
console.log("¡Tipo de clima desconocido!");
break;
}
Puedes colocar cualquier cantidad de etiquetas case dentro del bloque abierto
por switch. El programa comenzará a ejecutarse en la etiqueta que corresponda
al valor que se le dio a switch, o en default si no se encuentra ningún valor
coincidente. Continuará ejecutándose, incluso a través de otras etiquetas, hasta
que alcance una declaración break. En algunos casos, como el caso "soleado
" en el ejemplo, esto se puede usar para compartir algo de código entre casos
(recomienda salir al exterior tanto para el clima soleado como para el nublado).
Sin embargo, ten cuidado, es fácil olvidar un break de este tipo, lo que hará
que el programa ejecute código que no deseas ejecutar.
Capitalización
Los nombres de los enlaces no pueden contener espacios, sin embargo, a menudo
es útil usar varias palabras para describir claramente lo que representa el enlace.
Estas son básicamente tus opciones para escribir un nombre de enlace con varias
palabras:
fuzzylittleturtle
fuzzy_little_turtle
FuzzyLittleTurtle
fuzzyLittleTurtle
El primer estilo puede ser difícil de leer. Personalmente me gusta más la apari-
encia de los guiones bajos, aunque ese estilo es un poco difícil de escribir.
Las funciones estándar de JavaScript y la mayoría de los programadores de
JavaScript siguen el último estilo: capitalizan cada palabra excepto la primera.
No es difícil acostumbrarse a pequeñas cosas como esa, y el código con esti-
los de nombrado mixtos puede resultar molesto de leer, así que seguimos esta
convención.
En algunos casos, como en la función Number, la primera letra de un enlace
también está en mayúscula. Esto se hizo para marcar esta función como un
constructor. Quedará claro lo que es un constructor en el Capítulo 6. Por
ahora, lo importante es no molestarse por esta aparente falta de consistencia.
35

-- 47 of 445 --

Comentarios
A menudo, el código sin formato no transmite toda la información que deseas
que un programa transmita a los lectores humanos, o lo hace de una manera
tan críptica que las personas podrían no entenderlo. En otros momentos, es
posible que solo quieras incluir algunos pensamientos relacionados como parte
de tu programa. Para eso sirven los comentarios.
Un comentario es un fragmento de texto que forma parte de un programa
pero que es completamente ignorado por la computadora. JavaScript tiene dos
formas de escribir comentarios. Para escribir un comentario de una sola línea,
puedes usar dos caracteres de barra (//) y luego el texto del comentario después
de eso:
let saldoCuenta = calcularSaldo(cuenta);
// Es un hueco verde donde canta un río
saldoCuenta.ajustar();
// Atrapando locamente pedazos blancos en la hierba.
let informe = new Informe();
// Donde el sol en la orgullosa montaña resuena:
agregarAInforme(saldoCuenta, informe);
// Es un valle pequeño, espumoso como la luz en un vaso.
Un comentario con // solo va hasta el final de la línea. Una sección de texto
entre /* y */ será ignorada por completo, independientemente de si contiene
saltos de línea. Esto es útil para agregar bloques de información sobre un
archivo o un fragmento de programa:
/*
Encontré este número por primera vez garabateado en la parte
posterior de un viejo
cuaderno. Desde entonces, a menudo ha aparecido, mostrándose en
números de teléfono y números de serie de productos que he
comprado. Obviamente le gusto, así que he decidido quedármelo.
*/
const miNumero = 11213;
Resumen
Ahora sabes que un programa está construido a partir de declaraciones, que
a veces contienen más declaraciones. Las declaraciones tienden a contener
expresiones, que a su vez pueden estar construidas a partir de expresiones más
pequeñas.Poner declaraciones una después de la otra te da un programa que
36

-- 48 of 445 --

se ejecuta de arriba hacia abajo. Puedes introducir alteraciones en el flujo de
control usando declaraciones condicionales (if, else y switch) y bucles (while,
do y for).
Las uniones se pueden usar para guardar fragmentos de datos bajo un nom-
bre, y son útiles para hacer un seguimiento del estado en tu programa. El en-
torno es el conjunto de uniones que están definidas. Los sistemas de JavaScript
siempre colocan varias uniones estándar útiles en tu entorno.
Las funciones son valores especiales que encapsulan un fragmento de pro-
grama. Puedes invocarlas escribiendo nombreDeFuncion(argumento1, argumento2
). Dicha llamada a función es una expresión y puede producir un valor.
Ejercicios
Si no estás seguro de cómo probar tus soluciones a los ejercicios, consulta la
Introducción.
Cada ejercicio comienza con una descripción del problema. Lee esta descrip-
ción e intenta resolver el ejercicio. Si encuentras problemas, considera leer las
pistas al final del libro. Puedes encontrar soluciones completas a los ejercicios
en línea en https://eloquentjavascript.net/code. Si deseas aprender algo de los
ejercicios, te recomiendo mirar las soluciones solo después de haber resuelto el
ejercicio, o al menos después de haberlo intentado lo suficiente como para tener
un ligero dolor de cabeza.
Haciendo un triángulo con bucles
Escribe un bucle que realice siete llamadas a console.log para mostrar el
siguiente triángulo:
#
##
###
####
#####
######
#######
Puede ser útil saber que puedes encontrar la longitud de una cadena escribiendo
.length después de ella.
let abc = "abc";
console.log(abc.length);
// → 3
37

-- 49 of 445 --

FizzBuzz
Escribe un programa que use console.log para imprimir todos los números
del 1 al 100, con dos excepciones. Para los números divisibles por 3, imprime
"Fizz" en lugar del número, y para los números divisibles por 5 (y no por 3),
imprime "Buzz" en su lugar.
Cuando tengas eso funcionando, modifica tu programa para imprimir "FizzBuzz
" para los números que son divisibles por 3 y 5 (y sigue imprimiendo "Fizz" o
"Buzz" para los números que son divisibles solo por uno de esos).
(Esto es en realidad una pregunta de entrevista que se ha afirmado que
elimina a un porcentaje significativo de candidatos a programadores. Entonces,
si lo resolviste, tu valor en el mercado laboral acaba de aumentar.)
Tablero de ajedrez
Escribe un programa que cree una cadena que represente un tablero de 8x8,
usando caracteres de salto de línea para separar las líneas. En cada posición
del tablero hay un carácter de espacio o un carácter "#". Los caracteres deben
formar un tablero de ajedrez.
Al pasar esta cadena a console.log debería mostrar algo como esto: