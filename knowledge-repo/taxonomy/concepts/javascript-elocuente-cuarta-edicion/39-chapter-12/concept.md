# Chapter 12

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 39)

## Contenido
# Chapter 12

Proyecto: Un Lenguaje de Programación
Crear tu propio lenguaje de programación es sorprendentemente fácil (si no
apuntas muy alto) y muy esclarecedor.
Lo principal que quiero mostrar en este capítulo es que no hay magia in-
volucrada en la construcción de un lenguaje de programación. A menudo he
sentido que algunas invenciones humanas eran tan inmensamente inteligentes
y complicadas que nunca las entendería. Pero con un poco de lectura y exper-
imentación, a menudo resultan ser bastante mundanas.
Construiremos un lenguaje de programación llamado Egg. Será un lenguaje
simple y diminuto, pero lo suficientemente poderoso como para expresar cualquier
cálculo que puedas imaginar. Permitirá una simple abstracción basada en fun-
ciones.
Análisis Sintáctico
La parte más inmediatamente visible de un lenguaje de programación es su
sintaxis, o notación. Un analizador sintáctico es un programa que lee un frag-
mento de texto y produce una estructura de datos que refleja la estructura del
programa contenido en ese texto. Si el texto no forma un programa válido, el
analizador sintáctico debería señalar el error.
Nuestro lenguaje tendrá una sintaxis simple y uniforme. Todo en Egg es una
expresión. Una expresión puede ser el nombre de una asignación, un número,
una cadena o una aplicación. Las aplicaciones se utilizan para llamadas de
funciones pero también para estructuras como if o while.
Para mantener el analizador sintáctico simple, las cadenas en Egg no admiten
nada parecido a los escapes con barra invertida. Una cadena es simplemente
una secuencia de caracteres que no son comillas dobles, envueltos entre comillas
dobles. Un número es una secuencia de dígitos. Los nombres de las asignaciones
pueden consistir en cualquier carácter que no sea espacio en blanco y que no
tenga un significado especial en la sintaxis.
Las aplicaciones se escriben de la misma manera que en JavaScript, colocando
200

-- 212 of 445 --

paréntesis después de una expresión y teniendo cualquier número de argumentos
entre esos paréntesis, separados por comas.
do(define(x, 10),
if(>(x, 5),
print("grande"),
print("pequeño")))
La uniformidad del lenguaje Egg significa que las cosas que son operadores en
JavaScript (como >) son asignaciones normales en este lenguaje, aplicadas de
la misma manera que otras funciones. Y dado que la sintaxis no tiene concepto
de bloque, necesitamos un constructo do para representar la realización de
múltiples tareas en secuencia.
La estructura de datos que el analizador sintáctico utilizará para describir
un programa consiste en objetos expresión, cada uno de los cuales tiene una
propiedad type que indica el tipo de expresión que es y otras propiedades para
describir su contenido.
Las expresiones de tipo "value" representan cadenas literales o números. Su
propiedad value contiene el valor de cadena o número que representan. Las
expresiones de tipo "word" se utilizan para identificadores (nombres). Estos ob-
jetos tienen una propiedad name que contiene el nombre del identificador como
cadena. Finalmente, las expresiones "apply" representan aplicaciones. Tienen
una propiedad operator que se refiere a la expresión que se está aplicando, así
como una propiedad args que contiene una serie de expresiones de argumento.
La parte >(x, 5) del programa anterior se representaría de la siguiente man-
era:
{
type: "apply",
operator: {type: "word", name: ">"},
args: [
{type: "word", name: "x"},
{type: "value", value: 5}
]
}
Esta estructura de datos se llama un árbol de sintaxis. Si te imaginas los
objetos como puntos y los enlaces entre ellos como líneas entre esos puntos,
tiene una forma similar a un árbol. El hecho de que las expresiones contienen
otras expresiones, que a su vez pueden contener más expresiones, es similar a
la forma en que las ramas de un árbol se dividen y vuelven a dividir.
201

-- 213 of 445 --

do
define
x
10
if
>
x
5
print
"large"
print
"small"
Contrasta esto con el analizador que escribimos para el formato de archivo
de configuración en el Capítulo 9, que tenía una estructura simple: dividía
la entrada en líneas y manejaba esas líneas una a la vez. Solo había algunas
formas simples que una línea podía tener.
Aquí debemos encontrar un enfoque diferente. Las expresiones no están
separadas en líneas, y tienen una estructura recursiva. Las expresiones de
aplicación contienen otras expresiones.
Afortunadamente, este problema puede resolverse muy bien escribiendo una
función de análisis sintáctico que sea recursiva de una manera que refleje la
naturaleza recursiva del lenguaje.
Definimos una función parseExpression, que recibe una cadena como entrada
y devuelve un objeto que contiene la estructura de datos de la expresión al inicio
de la cadena, junto con la parte de la cadena que queda después de analizar
esta expresión. Al analizar subexpresiones (el argumento de una aplicación, por
ejemplo), esta función puede ser llamada nuevamente, obteniendo la expresión
de argumento así como el texto que queda. E
