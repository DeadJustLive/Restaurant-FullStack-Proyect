# 0. La precedencia del operador de residuo es la misma que la de multiplicación

y división. También verás a menudo a este operador referido como módulo.
Números especiales
Hay tres valores especiales en JavaScript que se consideran números pero no
se comportan como números normales. Los dos primeros son Infinity y -
Infinity, que representan el infinito positivo y negativo. Infinity - 1 sigue
siendo Infinity, y así sucesivamente. Sin embargo, no confíes demasiado en
los cálculos basados en infinito. No es matemáticamente sólido y rápidamente
te llevará al siguiente número especial: NaN.
NaN significa “no es un número”, aunque es un valor del tipo numérico. Ob-
tendrás este resultado cuando, por ejemplo, intentes calcular 0 / 0 (cero divi-
dido por cero), Infinity - Infinity, u cualquier otra operación numérica que
no produzca un resultado significativo.
Cadenas
El siguiente tipo de dato básico es la cadena. Las cadenas se utilizan para
representar texto. Se escriben encerrando su contenido entre comillas.
`En el mar`
"Acostado en el océano"
'Flotando en el océano'
13

-- 25 of 445 --

Puedes usar comillas simples, comillas dobles o acentos graves para marcar
las cadenas, siempre y cuando las comillas al principio y al final de la cadena
coincidan.
Puedes poner casi cualquier cosa entre comillas para que JavaScript genere
un valor de cadena a partir de ello. Pero algunos caracteres son más difíciles.
Puedes imaginar lo complicado que sería poner comillas entre comillas, ya que
parecerían el final de la cadena. Saltos de línea (los caracteres que obtienes al
presionar enter) solo se pueden incluir cuando la cadena está entre acentos
graves (\‘).
Para poder incluir dichos caracteres en una cadena, se utiliza la siguiente
notación: una barra invertida (\) dentro de un texto entre comillas indica que
el carácter posterior tiene un significado especial. Esto se llama escapar el
carácter. Una comilla que va precedida por una barra invertida no finalizará la
cadena, sino que formará parte de ella. Cuando un carácter n aparece después
de una barra invertida, se interpreta como un salto de línea. De manera similar,
un t después de una barra invertida significa un carácter de tabulación. Toma
la siguiente cadena:
"Esta es la primera línea\nY esta es la segunda"
Este es el texto real de esa cadena:
Esta es la primera línea
Y esta es la segunda
Por supuesto, hay situaciones en las que deseas que una barra invertida en
una cadena sea simplemente una barra invertida, no un código especial. Si
dos barras invertidas van seguidas, se colapsarán juntas y solo quedará una en
el valor de cadena resultante. Así es como se puede expresar la cadena “Un
carácter de nueva línea se escribe como "\n".”:
"Un carácter de nueva línea se escribe como \"\\n\"."
Las cadenas también deben ser modeladas como una serie de bits para poder
existir dentro de la computadora. La forma en que JavaScript lo hace se basa
en el estándar Unicode. Este estándar asigna un número a prácticamente cada
carácter que puedas necesitar, incluidos los caracteres griegos, árabes, japone-
ses, armenios, y así sucesivamente. Si tenemos un número para cada carácter,
una cadena puede ser descrita por una secuencia de números. Y eso es lo que
hace JavaScript.
Sin embargo, hay una complicación: la representación de JavaScript utiliza
16 bits por elemento de cadena, lo que puede describir hasta 216 caracteres difer-
14

-- 26 of 445 --

entes. Sin embargo, Unicode define más caracteres que eso —aproximadamente
el doble, en este momento. Por lo tanto, algunos caracteres, como muchos
emoji, ocupan dos “posiciones de caracteres” en las cadenas de JavaScript.
Volveremos a esto en el Capítulo 5.
Las cadenas no se pueden dividir, multiplicar o restar. El operador + se
puede usar en ellas, no para sumar, sino para concatenar —unir dos cadenas.
La siguiente línea producirá la cadena "concatenar":
"con" + "cat" + "e" + "nar"
Los valores de cadena tienen una serie de funciones asociadas (métodos) que
se pueden utilizar para realizar otras operaciones con ellos. Hablaré más sobre
esto en el Capítulo 4.
Las cadenas escritas con comillas simples o dobles se comportan de manera
muy similar, la única diferencia radica en qué tipo de comilla necesitas escapar
dentro de ellas. Las cadenas entre acentos graves, generalmente llamadas tem-
plate literals, pueden hacer algunas cosas más. Aparte de poder abarcar varias
líneas, también pueden incrustar otros valores.
`la mitad de 100 es ${100 / 2}`
Cuando escribes algo dentro de ${} en una plantilla literal, su resultado se
calculará, se convertirá en una cadena y se incluirá en esa posición. Este
ejemplo produce “la mitad de 100 es 50”.
Operadores unarios
No todos los operadores son símbolos. Algunos se escriben como palabras. Un
ejemplo es el operador typeof, que produce un valor de cadena que indica el
tipo del valor que le proporcionas.
console.log(typeof 4.5)
// → number
console.log(typeof "x")
// → string
Utilizaremos console.log en ejemplos de código para indicar que queremos ver
el resultado de evaluar algo. Más sobre eso en el próximo capítulo.
Los otros operadores mostrados hasta ahora en este capítulo operaron sobre
dos valores, pero typeof toma solo uno. Los operadores que utilizan dos valores
se llaman operadores binarios, mientras que aquellos que toman uno se llaman
operadores unarios. El operador menos se puede usar tanto como un operador
binario como un operador unario.
15

-- 27 of 445 --

console.log(- (10 - 2))
// → -8
Valores booleanos
A menudo es útil tener un valor que distinga solo entre dos posibilidades, como
“sí" y “no” o “encendido” y “apagado”. Para este propósito, JavaScript tiene
un tipo Booleano, que tiene solo dos valores, true y false, escritos como esas
palabras.
Comparación
Aquí hay una forma de producir valores booleanos:
console.log(3 > 2)
// → true
console.log(3 < 2)
// → false
Los signos > y < son símbolos tradicionales para “es mayor que” y “es menor
que”, respectivamente. Son operadores binarios. Aplicarlos da como resultado
un valor booleano que indica si son verdaderos en este caso.
Las cadenas se pueden comparar de la misma manera:
console.log("Aardvark" < "Zoroaster")
// → true
La forma en que se ordenan las cadenas es aproximadamente alfabética pero no
es realmente lo que esperarías ver en un diccionario: las letras mayúsculas son
siempre “menores” que las minúsculas, por lo que "Z" < "a", y los caracteres
no alfabéticos (!, -, y así sucesivamente) también se incluyen en la ordenación.
Al comparar cadenas, JavaScript recorre los caracteres de izquierda a derecha,
comparando los códigos Unicode uno por uno.
Otros operadores similares son >= (mayor o igual que), <= (menor o igual
que), == (igual a), y != (no igual a).
console.log("Granate" != "Rubí")
// → true
console.log("Perla" == "Amatista")
// → false
Solo hay un valor en JavaScript que no es igual a sí mismo, y ese es NaN (“no
es un número”).
16

-- 28 of 445 --

console.log(NaN == NaN)
// → false
NaN se supone que denota el resultado de un cálculo sin sentido y, como tal, no
es igual al resultado de ningún otro cálculo sin sentido.
Operadores lógicos
También hay algunas operaciones que se pueden aplicar a los propios valores
Booleanos. JavaScript soporta tres operadores lógicos: and (y), or (o), y not
(no). Estos se pueden usar para “razonar” sobre valores Booleanos.
El operador && representa el and lógico. Es un operador binario, y su resul-
tado es verdadero solo si ambos valores dados son verdaderos.
console.log(true && false)
// → false
console.log(true && true)
// → true
El operador || representa el or lógico. Produce verdadero si cualquiera de los
valores dados es verdadero.
console.log(false || true)
// → true
console.log(false || false)
// → false
Not se escribe con un signo de exclamación (!). Es un operador unario que
invierte el valor dado; !true produce false y !false produce true.
Al combinar estos operadores Booleanos con operadores aritméticos y otros
operadores, no siempre es obvio cuándo se necesitan paréntesis. En la práctica,
generalmente puedes avanzar sabiendo que de los operadores que hemos visto
hasta ahora, || tiene la menor precedencia, luego viene &&, luego los operadores
de comparación (>, ==, etc.), y luego el resto. Este orden ha sido elegido de
tal manera que, en expresiones típicas como la siguiente, se necesiten la menor
cantidad de paréntesis posible:
1 + 1 == 2 && 10 * 10 > 50
El último operador lógico que veremos no es unario ni binario, sino ternario,
operando en tres valores. Se escribe con un signo de interrogación y dos puntos,
así:
console.log(true ? 1 : 2);
// → 1
17

-- 29 of 445 --

console.log(false ? 1 : 2);
// → 2
Este se llama el operador condicional (o a veces simplemente el operador
ternario ya que es el único operador de este tipo en el lenguaje). El oper-
ador usa el valor a la izquierda del signo de interrogación para decidir cuál de
los otros dos valores “elegir”. Si escribes a ? b : c, el resultado será b cuando
a es verdadero y c de lo contrario.
Valores vacíos
Hay dos valores especiales, escritos null y undefined, que se utilizan para
denotar la ausencia de un valor significativo. Son valores en sí mismos, pero
no llevan ninguna información. Muchas operaciones en el lenguaje que no
producen un valor significativo devuelven undefined simplemente porque tienen
que devolver algún valor.
La diferencia en el significado entre undefined y null es un accidente del
diseño de JavaScript, y la mayoría de las veces no importa. En casos en los que
realmente tienes que preocuparte por estos valores, recomiendo tratarlos como
en su mayoría intercambiables.
Conversión automática de tipos
En la Introducción, mencioné que JavaScript se esfuerza por aceptar casi cualquier
programa que le des, incluso programas que hacen cosas extrañas. Esto se de-
muestra claramente con las siguientes expresiones:
console.log(8 * null)
// → 0
console.log("5" - 1)
// → 4
console.log("5" + 1)
// → 51
console.log("five" * 2)
// → NaN
console.log(false == 0)
// → true
Cuando se aplica un operador al tipo de valor “incorrecto”, JavaScript conver-
tirá silenciosamente ese valor al tipo que necesita, utilizando un conjunto de
reglas que a menudo no son las que deseas o esperas. Esto se llama coerción de
tipos. El null en la primera expresión se convierte en 0 y el "5" en la segunda
18

-- 30 of 445 --

expresión se convierte en 5 (de cadena a número). Sin embargo, en la tercera
expresión, + intenta la concatenación de cadenas antes que la suma numérica,
por lo que el 1 se convierte en "1" (de número a cadena).
Cuando algo que no se corresponde con un número de manera obvia (como
"five" o undefined) se convierte en un número, obtienes el valor NaN. Más
operaciones aritméticas en NaN siguen produciendo NaN, así que si te encuentras
con uno de estos en un lugar inesperado, busca conversiones de tipo acciden-
tales.
Cuando se comparan valores del mismo tipo usando el operador ==, el resul-
tado es fácil de predecir: deberías obtener verdadero cuando ambos valores son
iguales, excepto en el caso de NaN. Pero cuando los tipos difieren, JavaScript uti-
liza un conjunto de reglas complicado y confuso para determinar qué hacer. En
la mayoría de los casos, simplemente intenta convertir uno de los valores al tipo
del otro valor. Sin embargo, cuando null o undefined aparece en cualquiera
de los lados del operador, produce verdadero solo si ambos lados son uno de
null o undefined.
console.log(null == undefined);
// → true
console.log(null == 0);
// → false
Ese comportamiento a menudo es útil. Cuando quieres probar si un valor tiene
un valor real en lugar de null o undefined, puedes compararlo con null usando
el operador == o !=.
¿Qué sucede si quieres probar si algo se refiere al valor preciso false? Ex-
presiones como 0 == false y "" == false también son verdaderas debido a la
conversión automática de tipos. Cuando no deseas que ocurran conversiones
de tipo, hay dos operadores adicionales: === y !==. El primero prueba si un
valor es precisamente igual al otro, y el segundo prueba si no es precisamente
igual. Por lo tanto, "" === false es falso como se espera. Recomiendo usar los
operadores de comparación de tres caracteres defensivamente para evitar con-
versiones de tipo inesperadas que puedan complicarte las cosas. Pero cuando
estés seguro de que los tipos en ambos lados serán los mismos, no hay problema
en usar los operadores más cortos.
Cortocircuito de operadores lógicos
Los operadores lógicos && y || manejan valores de diferentes tipos de una man-
era peculiar. Convertirán el valor del lado izquierdo a tipo Booleano para
decidir qué hacer, pero dependiendo del operador y el resultado de esa conver-
19

-- 31 of 445 --

sión, devolverán ya sea el valor original del lado izquierdo o el valor del lado
derecho.
El operador ||, por ejemplo, devolverá el valor de su izquierda cuando ese
valor pueda convertirse en true y devolverá el valor de su derecha de lo contrario.
Esto tiene el efecto esperado cuando los valores son Booleanos y hace algo
análogo para valores de otros tipos.
console.log(null || "usuario")
// → usuario
console.log("Agnes" || "usuario")
// → Agnes
Podemos utilizar esta funcionalidad como una forma de utilizar un valor prede-
terminado. Si tienes un valor que podría estar vacío, puedes colocar || después
de él con un valor de reemplazo. Si el valor inicial se puede convertir en false,
obtendrás el valor de reemplazo en su lugar. Las reglas para convertir cadenas
y números en valores Booleanos establecen que 0, NaN y la cadena vacía ("")
cuentan como false, mientras que todos los demás valores cuentan como true.
Esto significa que 0 || -1 produce -1, y "" || "!?" da como resultado "!?".
El operador ?? se asemeja a ||, pero devuelve el valor de la derecha solo si
el de la izquierda es null o undefined, no si es algún otro valor que se pueda
convertir en false. A menudo, este comportamiento es preferible al de ||.
console.log(0 || 100);
// → 100
console.log(0 ?? 100);
// → 0
console.log(null ?? 100);
// → 100
El operador && funciona de manera similar pero en sentido contrario. Cuando
el valor a su izquierda es algo que se convierte en false, devuelve ese valor, y
de lo contrario devuelve el valor de su derecha.
Otra propiedad importante de estos dos operadores es que la parte de su
derecha se evalúa solo cuando es necesario. En el caso de true || X, no im-
porta qué sea X, incluso si es una parte del programa que hace algo terrible, el
resultado será true, y X nunca se evaluará. Lo mismo ocurre con false && X,
que es false e ignorará X. Esto se llama evaluación de cortocircuito.
El operador condicional funciona de manera similar. De los valores segundo
y tercero, solo se evalúa el que sea seleccionado.
20

-- 32 of 445 --

Resumen
En este capítulo examinamos cuatro tipos de valores en JavaScript: números,
cadenas, Booleanos y valores indefinidos. Tales valores son creados escribiendo
su nombre (true, null) o valor (13, "abc"). Puedes combinar y transformar
valores con operadores. Vimos operadores binarios para aritmética (+, -, *, /
y %), concatenación de cadenas (+), comparación (==, !=, ===, !==, <, >, <=,
>=) y lógica (&&, ||, ??), así como varios operadores unarios (- para negar un
número, ! para negar lógicamente, y typeof para encontrar el tipo de un valor)
y un operador ternario (?:) para elegir uno de dos valores basado en un tercer
valor.
Esto te proporciona suficiente información para usar JavaScript como una
calculadora de bolsillo, pero no mucho más. El próximo capítulo comenzará a
unir estas expresiones en programas básicos.
21

-- 33 of 445 --

“Y mi corazón brilla intensamente bajo mi piel diáfana y
translúcida, y tienen que administrarme 10cc de JavaScript para
hacerme volver. (Respondo bien a las toxinas en la sangre.)
¡Hombre, esa cosa sacará los melocotones de tus agallas!”
—_why, Guía (conmovedora) de Ruby de Why
Chapter 2
Estructura del Programa
En este capítulo, comenzaremos a hacer cosas que realmente pueden ser lla-
madas programación. Ampliaremos nuestro dominio del lenguaje JavaScript
más allá de los sustantivos y fragmentos de oraciones que hemos visto hasta
ahora, hasta el punto en que podamos expresar prosa significativa.
Expresiones y declaraciones
En Capítulo 1, creamos valores y aplicamos operadores a ellos para obtener
nuevos valores. Crear valores de esta manera es la sustancia principal de
cualquier programa JavaScript. Pero esa sustancia debe enmarcarse en una
estructura más grande para ser útil. Eso es lo que cubriremos en este capítulo.
Un fragmento de código que produce un valor se llama una expresión. Cada
valor que está escrito literalmente (como 22 o "psicoanálisis") es una expre-
sión. Una expresión entre paréntesis también es una expresión, al igual que un
operador binario aplicado a dos expresiones o un operador unario aplicado a
uno.
Esto muestra parte de la belleza de una interfaz basada en lenguaje. Las
expresiones pueden contener otras expresiones de manera similar a cómo las
subsentencias en los idiomas humanos están anidadas: una subsentencia puede
contener sus propias subsentencias, y así sucesivamente. Esto nos permite
construir expresiones que describen cálculos arbitrariamente complejos.
Si una expresión corresponde a un fragmento de oración, una declaración de
JavaScript corresponde a una oración completa. Un programa es una lista de
declaraciones.
El tipo más simple de declaración es una expresión con un punto y coma al
final. Este es un programa:
1;
!false;
Sin embargo, es un programa inútil. Una expresión puede conformarse con
22

-- 34 of 445 --

simplemente producir un valor, que luego puede ser utilizado por el código que
la contiene. Sin embargo, una declaración se mantiene por sí misma, por lo que
si no afecta al mundo, es inútil. Puede mostrar algo en la pantalla, como con
console.log, o cambiar el estado de la máquina de una manera que afectará a
las declaraciones que vienen después de ella. Estos cambios se llaman efectos
secundarios. Las declaraciones en el ejemplo anterior simplemente producen
los valores 1 y verdadero, y luego los desechan inmediatamente. Esto no deja
ninguna impresión en el mundo en absoluto. Cuando ejecutas este programa,
no sucede nada observable.
En algunos casos, JavaScript te permite omitir el punto y coma al final de
una declaración. En otros casos, debe estar ahí, o la próxima línea se tratará
como parte de la misma declaración. Las reglas sobre cuándo se puede omitir
de manera segura son algo complejas y propensas a errores. Por lo tanto, en
este libro, cada declaración que necesite un punto y coma siempre recibirá uno.
Te recomiendo que hagas lo mismo, al menos hasta que hayas aprendido más
sobre las sutilezas de las omisiones de puntos y comas.
Bindings
¿Cómo mantiene un programa un estado interno? ¿Cómo recuerda las cosas?
Hemos visto cómo producir nuevos valores a partir de valores antiguos, pero
esto no cambia los valores antiguos, y el nuevo valor debe utilizarse inmedi-
atamente o se disipará nuevamente. Para atrapar y retener valores, JavaScript
proporciona una cosa llamada un enlace, o variable:
let caught = 5 * 5;
Eso nos da un segundo tipo de statement. La palabra especial (keyword) let
indica que esta frase va a definir un enlace. Está seguida por el nombre del
enlace y, si queremos darle inmediatamente un valor, por un operador = y una
expresión.
El ejemplo crea un enlace llamado caught y lo utiliza para agarrar el número
que se produce multiplicando 5 por 5.
Después de que se haya definido un enlace, su nombre se puede usar como
una expression. El valor de esa expresión es el valor que el enlace mantiene
actualmente. Aquí tienes un ejemplo:
let ten = 10;
console.log(ten * ten);
// → 100
23

-- 35 of 445 --

Cuando un enlace apunta a un valor, eso no significa que esté atado a ese valor
para siempre. El operador = se puede usar en cualquier momento en enlaces
existentes para desconectarlos de su valor actual y hacer que apunten a uno
nuevo:
let mood = "light";
console.log(mood);
// → light
mood = "dark";
console.log(mood);
// → dark
Debes imaginarte los enlaces como tentáculos en lugar de cajas. No contienen
valores; los agarran—dos enlaces pueden hacer referencia al mismo valor. Un
programa solo puede acceder a los valores a los que todavía tiene una referencia.
Cuando necesitas recordar algo, o bien haces crecer un tentáculo para aferrarte
a él o vuelves a conectar uno de tus tentáculos existentes a él.
Veamos otro ejemplo. Para recordar la cantidad de dólares que Luigi todavía
te debe, creas un enlace. Cuando te paga $35, le das a este enlace un nuevo
valor:
let luigisDebt = 140;
luigisDebt = luigisDebt - 35;
console.log(luigisDebt);
// → 105
Cuando defines un enlace sin darle un valor, el tentáculo no tiene nada que
agarrar, por lo que termina en el aire. Si solicitas el valor de un enlace vacío,
obtendrás el valor undefined.
Una sola instrucción let puede definir múltiples enlaces. Las definiciones
deben estar separadas por comas:
let one = 1, two = 2;
console.log(one + two);
// → 3
Las palabras var y const también se pueden usar para crear enlaces, de manera
similar a let:
var name = "Ayda";
const greeting = "¡Hola ";
console.log(greeting + name);
// → ¡Hola Ayda
La primera de estas, var (abreviatura de “variable”), es la forma en que se
24

-- 36 of 445 --

declaraban los enlaces en JavaScript anterior a 2015, cuando aún no existía let
. Volveré a la forma precisa en que difiere de let en el próximo capítulo. Por
ahora, recuerda que en su mayoría hace lo mismo, pero rara vez lo usaremos
en este libro porque se comporta de manera extraña en algunas situaciones.
La palabra const significa constante. Define un enlace constante, que apunta
al mismo valor mientras exista. Esto es útil para enlaces que solo dan un nombre
a un valor para poder referirse fácilmente a él más tarde.
Nombres de enlaces
Los nombres de enlaces pueden ser cualquier secuencia de una o más letras.
Los dígitos pueden formar parte de los nombres de enlaces, catch22 es un
nombre válido, por ejemplo, pero el nombre no puede empezar con un dígito.
Un nombre de enlace puede incluir signos de dólar ($) o subrayados (_), pero
no otros signos de puntuación o caracteres especiales.
Palabras con un significado especial, como let, son palabra clave, y no pueden
ser usadas como nombres de enlaces. También hay una serie de palabras que
están “reservadas para su uso” en futuras versiones de JavaScript, las cuales
tampoco se pueden usar como nombres de enlaces. La lista completa de pal-
abras clave y palabras reservadas es bastante larga:
break case catch class const continue debugger default
delete do else enum export extends false finally for
function if implements import interface in instanceof let
new package private protected public return static super
switch this throw true try typeof var void while with yield
No te preocupes por memorizar esta lista. Cuando al crear un enlace se produce
un error de sintaxis inesperado, verifica si estás intentando definir una palabra
reservada.
El entorno
La colección de enlaces y sus valores que existen en un momento dado se llama
entorno. Cuando un programa se inicia, este entorno no está vacío. Siempre
contiene enlaces que forman parte del lenguaje estándar, y la mayoría de las
veces también tiene enlaces que proporcionan formas de interactuar con el
sistema circundante. Por ejemplo, en un navegador, existen funciones para
interactuar con el sitio web cargado actualmente y para leer la entrada del
ratón y el teclado.
25

-- 37 of 445 --

Funciones
Muchos de los valores proporcionados en el entorno predeterminado tienen el
tipo de función. Una función es un fragmento de programa envuelto en un
valor. Estos valores pueden ser aplicados para ejecutar el programa envuelto.
Por ejemplo, en un entorno de navegador, el enlace prompt contiene una función
que muestra un pequeño cuadro de diálogo pidiendo la entrada del usuario. Se
utiliza de la siguiente manera:
prompt("Ingrese el código de acceso");
Ejecutar una función se llama invocar, llamar, o aplicar la función. Puedes
llamar una función poniendo paréntesis después de una expresión que produce
un valor de función. Usualmente usarás directamente el nombre del enlace
que contiene la función. Los valores entre paréntesis se le pasan al programa
dentro de la función. En el ejemplo, la función prompt utiliza la cadena que le
pasamos como el texto a mostrar en el cuadro de diálogo. Los valores dados a
las funciones se llaman argumentos. Diferentes funciones pueden necesitar un
número diferente o diferentes tipos de argumentos.
La función prompt no se usa mucho en la programación web moderna, prin-
cipalmente porque no tienes control sobre cómo se ve el cuadro de diálogo
resultante, pero puede ser útil en programas simples y experimentos.
La función console.log
En los ejemplos, utilicé console.log para mostrar valores. La mayoría de
los sistemas de JavaScript (incluidos todos los navegadores web modernos y
Node.js) proveen una función console.log que escribe sus argumentos en al-
gún dispositivo de salida de texto. En los navegadores, la salida va a la consola
de JavaScript. Esta parte de la interfaz del navegador está oculta por de-
fecto, pero la mayoría de los navegadores la abren cuando presionas F12 o, en
Mac, comando-opción-I. Si eso no funciona, busca a través de los menús un
elemento llamado Herramientas para Desarrolladores o similar.
26

-- 38 of 445 --

Aunque los nombres de enlaces no pueden contener puntos, console.log
tiene uno. Esto se debe a que console.log no es un simple enlace, sino
una expresión que recupera la propiedad log del valor contenido por el enlace
console. Descubriremos exactamente lo que esto significa en el Capítulo 4.
Valores de retorno
Mostrar un cuadro de diálogo o escribir texto en la pantalla es un efecto se-
cundario. Muchas funciones son útiles debido a los efectos secundarios que
producen. Las funciones también pueden producir valores, en cuyo caso no
necesitan tener un efecto secundario para ser útiles. Por ejemplo, la fun-
ción Math.max toma cualquier cantidad de argumentos numéricos y devuelve
el mayor:
console.log(Math.max(2, 4));
// → 4
Cuando una función produce un valor, se dice que retorna ese valor. Cualquier
cosa que produzca un valor es una expresión en JavaScript, lo que significa que
las llamadas a funciones se pueden utilizar dentro de expresiones más grandes.
En el siguiente código, una llamada a Math.min, que es lo opuesto a Math.max,
se usa como parte de una expresión de suma:
console.log(Math.min(2, 4) + 100);
// → 102