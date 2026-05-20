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
de crear funciones que multiplican por una cantidad arbitraria:
function multiplier(factor) {
return number => number * factor;
}
let twice = multiplier(2);
console.log(twice(5));
// → 10
El enlace explícito local del ejemplo wrapValue realmente no es necesario, ya
47

-- 59 of 445 --

que un parámetro es en sí mismo un enlace local.
Pensar en programas de esta manera requiere algo de práctica. Un buen
modelo mental es pensar en los valores de función como que contienen tanto
el código en su cuerpo como el entorno en el que fueron creados. Cuando se
llama, el cuerpo de la función ve el entorno en el que fue creado, no el entorno
en el que se llama.
En el ejemplo anterior, se llama a multiplier y crea un entorno en el que
su parámetro factor está vinculado a 2. El valor de función que devuelve,
que se almacena en twice, recuerda este entorno para que cuando se llame,
multiplique su argumento por 2.
Recursión
Es perfectamente válido que una función se llame a sí misma, siempre y cuando
no lo haga tan a menudo que desborde la pila. Una función que se llama a
sí misma se llama recursiva. La recursión permite que algunas funciones se
escriban de una manera diferente. Toma, por ejemplo, esta función power, que
hace lo mismo que el operador ** (exponenciación):
function power(base, exponent) {
if (exponent == 0) {
return 1;
} else {
return base * power(base, exponent - 1);
}
}
console.log(power(2, 3));
// → 8
Esto se asemeja bastante a la forma en que los matemáticos definen la expo-
nenciación y describe el concepto de manera más clara que el bucle que usamos
en el Capítulo 2. La función se llama a sí misma varias veces con exponentes
cada vez más pequeños para lograr la multiplicación repetida.
Sin embargo, esta implementación tiene un problema: en implementaciones
típicas de JavaScript, es aproximadamente tres veces más lenta que una versión
que utiliza un for loop. Recorrer un simple bucle suele ser más económico que
llamar a una función múltiples veces.
El dilema de velocidad versus elegancia es interesante. Se puede ver como
una especie de continuo entre amigabilidad humana y amigabilidad de máquina.
Casi cualquier programa puede ser acelerado haciendo que sea más extenso y
48

-- 60 of 445 --

complicado. El programador debe encontrar un equilibrio apropiado.
En el caso de la función potencia, una versión poco elegante (con bucles)
sigue siendo bastante simple y fácil de leer. No tiene mucho sentido reem-
plazarla con una función recursiva. Sin embargo, a menudo un programa trata
con conceptos tan complejos que renunciar a algo de eficiencia para hacer que
el programa sea más directo es útil.
Preocuparse por la eficiencia puede ser una distracción. Es otro factor que
complica el diseño del programa y cuando estás haciendo algo que ya es difícil,
ese extra en lo que preocuparse puede llegar a ser paralizante.
Por lo tanto, generalmente deberías comenzar escribiendo algo que sea cor-
recto y fácil de entender. Si te preocupa que sea demasiado lento—lo cual suele
ser raro, ya que la mayoría del código simplemente no se ejecuta lo suficiente
como para tomar una cantidad significativa de tiempo—puedes medir después
y mejorarlo si es necesario.
La recursión no siempre es simplemente una alternativa ineficiente a los bu-
cles. Algunos problemas realmente son más fáciles de resolver con recursión que
con bucles. Con mayor frecuencia, estos son problemas que requieren explorar o
procesar varias “ramas”, cada una de las cuales podría ramificarse nuevamente
en aún más ramas.
Considera este rompecabezas: al comenzar desde el número 1 y repetida-
mente sumar 5 o multiplicar por 3, se puede producir un conjunto infinito de
números. ¿Cómo escribirías una función que, dado un número, intente encon-
trar una secuencia de tales sumas y multiplicaciones que produzcan ese número?
Por ejemplo, el número 13 podría alcanzarse al multiplicar por 3 y luego sumar
5 dos veces, mientras que el número 15 no podría alcanzarse en absoluto.
Aquí tienes una solución recursiva:
function findSolution(objetivo) {
function find(actual, historial) {
if (actual === objetivo) {
return historial;
} else if (actual > objetivo) {
return null;
} else {
return find(actual + 5, `(${historial} + 5)`) ??
find(actual * 3, `(${historial} * 3)`);
}
}
return find(1, "1");
}
console.log(findSolution(24));
49

-- 61 of 445 --

// → (((1 * 3) + 5) * 3)
Ten en cuenta que este programa no necesariamente encuentra la secuencia
de operaciones más corta. Se conforma con encontrar cualquier secuencia en
absoluto.
No te preocupes si no ves cómo funciona este código de inmediato. Vamos a
trabajar juntos, ya que es un gran ejercicio de pensamiento recursivo.La función
interna find es la que realiza la recursión real. Toma dos argumentos: el número
actual y una cadena que registra cómo llegamos a este número. Si encuentra
una solución, devuelve una cadena que muestra cómo llegar al objetivo. Si no
puede encontrar una solución comenzando desde este número, devuelve null.
Para hacer esto, la función realiza una de tres acciones. Si el número actual
es el número objetivo, el historial actual es una forma de alcanzar ese objetivo,
por lo que se devuelve. Si el número actual es mayor que el objetivo, no tiene
sentido explorar más esta rama porque tanto la suma como la multiplicación
solo harán que el número sea más grande, por lo que devuelve null. Finalmente,
si aún estamos por debajo del número objetivo, la función prueba ambas rutas
posibles que parten del número actual llamándose a sí misma dos veces, una
vez para la suma y otra vez para la multiplicación. Si la primera llamada
devuelve algo que no es null, se devuelve. De lo contrario, se devuelve la
segunda llamada, independientemente de si produce una cadena o null.
Para entender mejor cómo esta función produce el efecto que estamos bus-
cando, veamos todas las llamadas a find que se hacen al buscar una solución
para el número 13:
find(1, "1")
find(6, "(1 + 5)")
find(11, "((1 + 5) + 5)")
find(16, "(((1 + 5) + 5) + 5)")
demasiado grande
find(33, "(((1 + 5) + 5) * 3)")
demasiado grande
find(18, "((1 + 5) * 3)")
demasiado grande
find(3, "(1 * 3)")
find(8, "((1 * 3) + 5)")
find(13, "(((1 * 3) + 5) + 5)")
¡encontrado!
La sangría indica la profundidad de la pila de llamadas. La primera vez que
se llama a find, la función comienza llamándose a sí misma para explorar
la solución que comienza con (1 + 5). Esa llamada seguirá recursivamente
para explorar cada solución continua que produzca un número menor o igual
50

-- 62 of 445 --

al número objetivo. Como no encuentra uno que alcance el objetivo, devuelve
null a la primera llamada. Allí, el operador ?? hace que ocurra la llamada
que explora (1 * 3). Esta búsqueda tiene más suerte: su primera llamada
recursiva, a través de otra llamada recursiva, alcanza el número objetivo. Esa
llamada más interna devuelve una cadena, y cada uno de los operadores ?? en
las llamadas intermedias pasa esa cadena, devolviendo en última instancia la
solución.
Crecimiento de funciones
Hay dos formas más o menos naturales de introducir funciones en los programas.
La primera ocurre cuando te encuentras escribiendo código similar varias
veces. Preferirías no hacer eso, ya que tener más código significa más espacio
para que se escondan los errores y más material para que las personas que
intentan entender el programa lo lean. Por lo tanto, tomas la funcionalidad
repetida, encuentras un buen nombre para ella y la colocas en una función.
La segunda forma es que te das cuenta de que necesitas alguna funcionali-
dad que aún no has escrito y que suena como si mereciera su propia función.
Comienzas por nombrar la función, luego escribes su cuerpo. Incluso podrías
comenzar a escribir código que use la función antes de definir la función en sí.
Lo difícil que es encontrar un buen nombre para una función es una buena
indicación de lo claro que es el concepto que estás tratando de envolver. Vamos
a través de un ejemplo.
Queremos escribir un programa que imprima dos números: el número de
vacas y de pollos en una granja, con las palabras Vacas y Pollos después de
ellos y ceros rellenados antes de ambos números para que siempre tengan tres
dígitos:
007 Vacas
011 Pollos
Esto pide una función con dos argumentos: el número de vacas y el número de
pollos. ¡Vamos a programar!
function imprimirInventarioGranja(vacas, pollos) {
let cadenaVaca = String(vacas);
while (cadenaVaca.length < 3) {
cadenaVaca = "0" + cadenaVaca;
}
console.log(`${cadenaVaca} Vacas`);
let cadenaPollo = String(pollos);
while (cadenaPollo.length < 3) {
51

-- 63 of 445 --

cadenaPollo = "0" + cadenaPollo;
}
console.log(`${cadenaPollo} Pollos`);
}
imprimirInventarioGranja(7, 11);
Escribir .length después de una expresión de cadena nos dará la longitud de
esa cadena. Por lo tanto, los bucles while siguen añadiendo ceros delante de
las cadenas de números hasta que tengan al menos tres caracteres de longitud.
¡Misión cumplida! Pero justo cuando estamos a punto de enviarle al granjero
el código (junto con una jugosa factura), ella llama y nos dice que también
ha comenzado a criar cerdos, ¿podríamos extender el software para imprimir
también los cerdos?
¡Claro que podemos! Pero justo cuando estamos en el proceso de copiar y
pegar esas cuatro líneas una vez más, nos detenemos y reconsideramos. Tiene
que haber una mejor manera. Aquí está un primer intento:
function imprimirConRellenoYEtiqueta(numero, etiqueta) {
let cadenaNumero = String(numero);
while (cadenaNumero.length < 3) {
cadenaNumero = "0" + cadenaNumero;
}
console.log(`${cadenaNumero} ${etiqueta}`);
}
function imprimirInventarioGranja(vacas, pollos, cerdos) {
imprimirConRellenoYEtiqueta(vacas, "Vacas");
imprimirConRellenoYEtiqueta(pollos, "Pollos");
imprimirConRellenoYEtiqueta(cerdos, "Cerdos");
}
imprimirInventarioGranja(7, 11, 3);
¡Funciona! Pero ese nombre, imprimirConRellenoYEtiqueta, es un poco incó-
modo. Confluye tres cosas: imprimir, rellenar con ceros y añadir una etiqueta,
en una sola función.
En lugar de sacar la parte repetida de nuestro programa completamente,
intentemos sacar un solo concepto:
function rellenarConCeros(numero, ancho) {
let cadena = String(numero);
while (cadena.length < ancho) {
cadena = "0" + cadena;
}
return cadena;
52

-- 64 of 445 --

}
function imprimirInventarioGranja(vacas, pollos, cerdos) {
console.log(`${rellenarConCeros(vacas, 3)} Vacas`);
console.log(`${rellenarConCeros(pollos, 3)} Pollos`);
console.log(`${rellenarConCeros(cerdos, 3)} Cerdos`);
}
imprimirInventarioGranja(7, 16, 3);
Una función con un nombre claro y obvio como rellenarConCeros hace que
sea más fácil para alguien que lee el código entender qué hace. Además, una
función así es útil en más situaciones que solo este programa específico. Por
ejemplo, podrías usarla para ayudar a imprimir tablas de números alineadas
correctamente.
¿Qué tan inteligente y versátil debería ser nuestra función? Podríamos es-
cribir cualquier cosa, desde una función terriblemente simple que solo puede
rellenar un número para que tenga tres caracteres de ancho hasta un sistema de
formato de números generalizado complicado que maneje números fraccionar-
ios, números negativos, alineación de puntos decimales, relleno con diferentes
caracteres, y más.
Un principio útil es abstenerse de agregar ingenio a menos que estés absolu-
tamente seguro de que lo vas a necesitar. Puede ser tentador escribir “marcos
de trabajo” generales para cada trozo de funcionalidad que te encuentres. Re-
siste esa tentación. No lograrás hacer ningún trabajo real: estarás demasiado
ocupado escribiendo código que nunca usas.
Funciones y efectos secundarios
Las funciones pueden dividirse aproximadamente en aquellas que se llaman por
sus efectos secundarios y aquellas que se llaman por su valor de retorno (aunque
también es posible tener efectos secundarios y devolver un valor).
La primera función auxiliar en el ejemplo de la granja, imprimirRellenadoConEtiqueta
, se llama por su efecto secundario: imprime una línea. La segunda versión,
rellenarConCero, se llama por su valor de retorno. No es casualidad que la
segunda sea útil en más situaciones que la primera. Las funciones que crean
valores son más fáciles de combinar de nuevas formas que las funciones que
realizan efectos secundarios directamente.
Una función pura es un tipo específico de función productora de valor que
no solo no tiene efectos secundarios, sino que tampoco depende de efectos
secundarios de otro código, por ejemplo, no lee enlaces globales cuyo valor
53

-- 65 of 445 --

podría cambiar. Una función pura tiene la agradable propiedad de que, al
llamarla con los mismos argumentos, siempre produce el mismo valor (y no
hace nada más). Una llamada a tal función puede sustituirse por su valor de
retorno sin cambiar el significado del código. Cuando no estás seguro de que
una función pura esté funcionando correctamente, puedes probarla llamándola
y saber que si funciona en ese contexto, funcionará en cualquier otro. Las
funciones no puras tienden a requerir más andamiaje para probarlas.
Aún así, no hay necesidad de sentirse mal al escribir funciones que no son
puras. Los efectos secundarios a menudo son útiles. No hay forma de escribir
una versión pura de console.log, por ejemplo, y es bueno tener console.log.
Algunas operaciones también son más fáciles de expresar de manera eficiente
cuando usamos efectos secundarios.
Resumen
Este capítulo te enseñó cómo escribir tus propias funciones. La palabra clave
function, cuando se usa como expresión, puede crear un valor de función.
Cuando se usa como una declaración, puede usarse para declarar un enlace y
darle una función como su valor. Las funciones de flecha son otra forma de
crear funciones.
// Definir f para contener un valor de función
const f = function(a) {
console.log(a + 2);
};
// Declarar g como una función
function g(a, b) {
return a * b * 3.5;
}
// Un valor de función menos verboso
let h = a => a % 3;
Una parte clave para entender las funciones es comprender los ámbitos (scopes).
Cada bloque crea un nuevo ámbito. Los parámetros y las vinculaciones declaradas
en un ámbito dado son locales y no son visibles desde el exterior. Las vincu-
laciones declaradas con var se comportan de manera diferente: terminan en el
ámbito de la función más cercana o en el ámbito global.
Separar las tareas que realiza tu programa en diferentes funciones es útil.
No tendrás que repetirte tanto, y las funciones pueden ayudar a organizar un
programa agrupando el código en piezas que hacen cosas específicas.
54

-- 66 of 445 --

Ejercicios
Mínimo
El capítulo previo presentó la función estándar Math.min que devuelve su menor
argumento. Ahora podemos escribir una función como esa nosotros mismos.
Define la función min que toma dos argumentos y devuelve su mínimo.
Recursión
Hemos visto que podemos usar % (el operador de resto) para verificar si un
número es par o impar al usar % 2 para ver si es divisible por dos. Aquí hay
otra forma de definir si un número entero positivo es par o impar:
• El cero es par.
• El uno es impar.
• Para cualquier otro número N, su paridad es la misma que N - 2.
Define una función recursiva isEven que corresponda a esta descripción. La
función debe aceptar un solo parámetro (un número entero positivo) y devolver
un booleano.
Pruébalo con 50 y 75. Observa cómo se comporta con -1. ¿Por qué? ¿Puedes
pensar en una forma de solucionarlo?
Contando frijoles
Puedes obtener el *ésimo carácter, o letra, de una cadena escribiendo [N] de-
spués de la cadena (por ejemplo, cadena[2]). El valor resultante será una
cadena que contiene solo un carácter (por ejemplo, "b"). El primer carácter
tiene la posición 0, lo que hace que el último se encuentre en la posición cadena
.length - 1. En otras palabras, una cadena de dos caracteres tiene longitud
2, y sus caracteres tienen posiciones 0 y 1.
Escribe una función contarBs que tome una cadena como único argumento
y devuelva un número que indique cuántos caracteres B en mayúscula hay en
la cadena.
A continuación, escribe una función llamada contarCaracter que se com-
porte como contarBs, excepto que toma un segundo argumento que indica el
carácter que se va a contar (en lugar de contar solo caracteres B en mayúscula).
Reescribe contarBs para hacer uso de esta nueva función.
55

-- 67 of 445 --

“En dos ocasiones me han preguntado: ‘Dígame, Sr. Babbage, si
introduce en la máquina cifras erróneas, ¿saldrán respuestas
correctas?’ [...] No soy capaz de entender correctamente el tipo de
confusión de ideas que podría provocar tal pregunta.”
—Charles Babbage, Passages from the Life of a Philosopher (1864)
Chapter 4
Estructuras de datos: Objetos y Arrays
Números, booleanos y cadenas de texto son los átomos a partir de los cuales
se construyen las estructuras de datos. Sin embargo, muchos tipos de infor-
mación requieren más de un átomo. Los objetos nos permiten agrupar valores,
incluyendo otros objetos, para construir estructuras más complejas.
Hasta ahora, los programas que hemos creado han estado limitados por el
hecho de que operaban solo en tipos de datos simples. Después de aprender los
conceptos básicos de estructuras de datos en este capítulo, sabrás lo suficiente
como para comenzar a escribir programas útiles.
El capítulo trabajará a través de un ejemplo de programación más o menos re-
alista, introduciendo conceptos a medida que se aplican al problema en cuestión.
El código de ejemplo a menudo se basará en funciones y variables introducidas
anteriormente en el libro.
El hombreardilla
De vez en cuando, usualmente entre las 8 p. m. y las 10 p. m., Jacques se
encuentra transformándose en un pequeño roedor peludo con una cola espesa.
Por un lado, Jacques está bastante contento de no tener licantropía clásica.
Convertirse en una ardilla causa menos problemas que convertirse en un lobo.
En lugar de preocuparse por comer accidentalmente al vecino (eso sería incó-
modo), se preocupa por ser comido por el gato del vecino. Después de dos
ocasiones de despertar en una rama precariamente delgada en la copa de un
roble, desnudo y desorientado, ha optado por cerrar con llave las puertas y
ventanas de su habitación por la noche y poner unas cuantas nueces en el suelo
para mantenerse ocupado.
Pero Jacques preferiría deshacerse por completo de su condición. Las ocur-
rencias irregulares de la transformación hacen que sospeche que podrían ser
desencadenadas por algo. Durante un tiempo, creyó que sucedía solo en días
en los que había estado cerca de robles. Sin embargo, evitar los robles no
resolvió el problema.
56

-- 68 of 445 --

Cambió a un enfoque más científico, Jacques ha comenzado a llevar un reg-
istro diario de todo lo que hace en un día dado y si cambió de forma. Con
estos datos, espera estrechar las condiciones que desencadenan las transforma-
ciones.Lo primero que necesita es una estructura de datos para almacenar esta
información.
Conjuntos de datos
Para trabajar con un conjunto de datos digitales, primero tenemos que encon-
trar una forma de representarlo en la memoria de nuestra máquina. Digamos,
por ejemplo, que queremos representar una colección de los números 2, 3, 5, 7
y 11.
Podríamos ser creativos con las cadenas, después de todo, las cadenas pueden
tener cualquier longitud, por lo que podemos poner muchos datos en ellas,
y usar "2 3 5 7 11" como nuestra representación. Pero esto es incómodo.
Tendríamos que extraer de alguna manera los dígitos y convertirlos de vuelta
a números para acceder a ellos.
Afortunadamente, JavaScript proporciona un tipo de dato específicamente
para almacenar secuencias de valores. Se llama un array y se escribe como una
lista de valores entre corchetes, separados por comas:
let listaDeNumeros = [2, 3, 5, 7, 11];
console.log(listaDeNumeros[2]);
// → 5
console.log(listaDeNumeros[0]);
// → 2
console.log(listaDeNumeros[2 - 1]);
// → 3
La notación para acceder a los elementos dentro de un array también utiliza
corchetes. Un par de corchetes inmediatamente después de una expresión,
con otra expresión dentro de ellos, buscará el elemento en la expresión de la
izquierda que corresponde al índice dado por la expresión en los corchetes.
El primer índice de un array es cero, no uno, por lo que el primer elemento
se recupera con listaDeNumeros[0]. El conteo basado en cero tiene una larga
tradición en tecnología y de ciertas maneras tiene mucho sentido, pero requiere
cierta acostumbrarse. Piensa en el índice como el número de elementos a omitir,
contando desde el inicio del array.
57

-- 69 of 445 --

Propiedades
Hemos visto algunas expresiones como miCadena.length (para obtener la lon-
gitud de una cadena) y Math.max (la función máxima) en capítulos anteriores.
Estas expresiones acceden a una propiedad de algún valor. En el primer caso,
accedemos a la propiedad length del valor en miCadena. En el segundo, ac-
cedemos a la propiedad llamada max en el objeto Math (que es una colección de
constantes y funciones relacionadas con matemáticas).
Casi todos los valores de JavaScript tienen propiedades. Las excepciones son
null y undefined. Si intentas acceder a una propiedad en uno de estos valores
no definidos, obtendrás un error:
null.length;
// → TypeError: null no tiene propiedades
Las dos formas principales de acceder a propiedades en JavaScript son con un
punto y con corchetes. Tanto valor.x como valor[x] acceden a una propiedad
en valor, pero no necesariamente a la misma propiedad. La diferencia radica
en cómo se interpreta x. Al usar un punto, la palabra después del punto es
el nombre literal de la propiedad. Al usar corchetes, la expresión entre los
corchetes es evaluada para obtener el nombre de la propiedad. Mientras que
valor.x obtiene la propiedad de valor llamada “x”, valor[x] toma el valor
de la variable llamada x y lo utiliza, convertido a cadena, como nombre de
propiedad.Si sabes que la propiedad en la que estás interesado se llama color,
dices valor.color. Si quieres extraer la propiedad nombrada por el valor alma-
cenado en la vinculación i, dices valor[i]. Los nombres de las propiedades son
cadenas de texto. Pueden ser cualquier cadena, pero la notación de punto solo
funciona con nombres que parecen nombres de vinculaciones válidos, comen-
zando con una letra o guion bajo, y conteniendo solo letras, números y guiones
bajos. Si deseas acceder a una propiedad llamada 2 o John Doe, debes utilizar
corchetes: valor[2] o valor["John Doe"].
Los elementos en un array se almacenan como propiedades del array, uti-
lizando números como nombres de propiedades. Dado que no puedes usar la
notación de punto con números y generalmente quieres usar una vinculación
que contenga el índice de todos modos, debes utilizar la notación de corchetes
para acceder a ellos.
Al igual que las cadenas de texto, los arrays tienen una propiedad length
que nos dice cuántos elementos tiene el array.
58

-- 70 of 445 --

Métodos
Tanto los valores de cadena como los de array contienen, además de la propiedad
length, varias propiedades que contienen valores de función.
let doh = "Doh";
console.log(typeof doh.toUpperCase);
// → function
console.log(doh.toUpperCase());
// → DOH
Cada cadena de texto tiene una propiedad toUpperCase. Cuando se llama,
devolverá una copia de la cadena en la que todas las letras se han convertido a
mayúsculas. También existe toLowerCase, que hace lo contrario.
Curiosamente, aunque la llamada a toUpperCase no pasa argumentos, de
alguna manera la función tiene acceso a la cadena "Doh", el valor cuya propiedad
llamamos. Descubrirás cómo funciona esto en el Capítulo 6.
Las propiedades que contienen funciones generalmente se llaman métodos del
valor al que pertenecen, como en “toUpperCase es un método de una cadena”.
Este ejemplo demuestra dos métodos que puedes utilizar para manipular
arrays:
let secuencia = [1, 2, 3];
secuencia.push(4);
secuencia.push(5);
console.log(secuencia);
// → [1, 2, 3, 4, 5]
console.log(secuencia.pop());
// → 5
console.log(secuencia);
// → [1, 2, 3, 4]
El método push agrega valores al final de un array. El método pop hace lo
opuesto, eliminando el último valor en el array y devolviéndolo.
Estos nombres un tanto tontos son términos tradicionales para operaciones
en una pila. Una pila, en programación, es una estructura de datos que te
permite agregar valores a ella y sacarlos en el orden opuesto para que lo que
se agregó último se elimine primero. Las pilas son comunes en programación;
es posible que recuerdes la función call stack del capítulo anterior, que es una
instancia de la misma idea.
59

-- 71 of 445 --

Objetos
De vuelta al hombre-ardilla. Un conjunto de entradas de registro diario se puede
representar como un array, pero las entradas no consisten solo en un número o
una cadena, cada entrada necesita almacenar una lista de actividades y un valor
booleano que indique si Jacques se convirtió en ardilla o no. Idealmente, nos
gustaría agrupar estos elementos en un único valor y luego poner esos valores
agrupados en un array de entradas de registro.
Los valores del tipo object son colecciones arbitrarias de propiedades. Una
forma de crear un objeto es usando llaves como una expresión:
let dia1 = {
hombreArdilla: false,
eventos: ["trabajo", "tocó árbol", "pizza", "correr"]
};
console.log(dia1.hombreArdilla);
// → false
console.log(dia1.lobo);
// → undefined
dia1.lobo = false;
console.log(dia1.lobo);
// → false
Dentro de las llaves, se escribe una lista de propiedades separadas por comas.
Cada propiedad tiene un nombre seguido por dos puntos y un valor. Cuando un
objeto se escribe en varias líneas, indentarlo como se muestra en este ejemplo
ayuda a la legibilidad. Las propiedades cuyos nombres no son nombres de
enlace válidos o números válidos deben ir entre comillas:
let descripciones = {
trabajo: "Fui a trabajar",
"tocó árbol": "Tocó un árbol"
};
Esto significa que las llaves tienen dos significados en JavaScript. Al princi-
pio de una sentencia, comienzan un bloque de sentencias. En cualquier otra
posición, describen un objeto. Afortunadamente, rara vez es útil comenzar una
sentencia con un objeto entre llaves, por lo que la ambigüedad entre estos dos
casos no es gran problema. El único caso en el que esto surge es cuando quiere
devolver un objeto desde una función flecha abreviada: no puede escribir n =>
{prop: n}, ya que las llaves se interpretarán como el cuerpo de una función.
En cambio, debe poner un conjunto de paréntesis alrededor del objeto para
dejar claro que es una expresión.
60

-- 72 of 445 --

Al leer una propiedad que no existe, obtendrás el valor undefined.
Es posible asignar un valor a una expresión de propiedad con el operador
=. Esto reemplazará el valor de la propiedad si ya existía o creará una nueva
propiedad en el objeto si no existía.
Para volver brevemente a nuestro modelo de tentáculos de enlaces, los enlaces
de propiedad son similares. Agarran valores, pero otros enlaces y propiedades
podrían estar aferrándose a esos mismos valores. Puedes pensar en los objetos
como pulpos con cualquier cantidad de tentáculos, cada uno con un nombre
escrito en él.
El operador delete corta un tentáculo de dicho pulpo. Es un operador unario
que, cuando se aplica a una propiedad de un objeto, eliminará la propiedad
nombrada del objeto. Esto no es algo común de hacer, pero es posible.
let unObjeto = {izquierda: 1, derecha: 2};
console.log(unObjeto.izquierda);
// → 1
delete unObjeto.izquierda;
console.log(unObjeto.izquierda);
// → undefined
console.log("izquierda" in unObjeto);
// → false
console.log("derecha" in unObjeto);
// → true
El operador binario in, cuando se aplica a una cadena y un objeto, te dice si
ese objeto tiene una propiedad con ese nombre. La diferencia entre establecer
una propiedad como undefined y realmente borrarla es que, en el primer caso,
el objeto todavía tiene la propiedad (simplemente no tiene un valor muy in-
teresante), mientras que en el segundo caso la propiedad ya no está presente y
in devolverá false.
Para averiguar qué propiedades tiene un objeto, puedes utilizar la función
Object.keys. Al darle la función un objeto, devolverá un array de cadenas: los
nombres de las propiedades del objeto:
console.log(Object.keys({x: 0, y: 0, z: 2}));
// → ["x", "y", "z"]
Existe una función Object.assign que copia todas las propiedades de un objeto
en otro:
let objetoA = {a: 1, b: 2};
Object.assign(objetoA, {b: 3, c: 4});
console.log(objetoA);
// → {a: 1, b: 3, c: 4}
61

-- 73 of 445 --

Los arrays, entonces, son solo un tipo de objeto especializado para almacenar
secuencias de cosas. Si evalúas typeof [], producirá "object". Puedes visu-
alizar los arrays como pulpos largos y planos con todos sus tentáculos en una
fila ordenada, etiquetados con números.
Jacques representará el diario que lleva como un array de objetos:
let diario = [
{eventos: ["trabajo", "tocó árbol", "pizza",
"corrió", "televisión"],
ardilla: false},
{eventos: ["trabajo", "helado", "coliflor",
"lasaña", "tocó árbol", "se cepilló los dientes"],
ardilla: false},
{eventos: ["fin de semana", "ciclismo", "descanso", "cacahuetes",
"cerveza"],
ardilla: true},
/* y así sucesivamente... */
];
Mutabilidad
Pronto llegaremos a la programación real, pero primero, hay una pieza más de
teoría para entender.
Vimos que los valores de objetos pueden modificarse. Los tipos de valores
discutidos en capítulos anteriores, como números, cadenas y booleanos, son
todos inmutables—es imposible cambiar valores de esos tipos. Puedes combi-
narlos y derivar nuevos valores de ellos, pero al tomar un valor específico de
cadena, ese valor siempre permanecerá igual. El texto dentro de él no puede
ser cambiado. Si tienes una cadena que contiene "gato", no es posible que otro
código cambie un carácter en tu cadena para que diga "rata".
Los objetos funcionan de manera diferente. Puedes cambiar sus propiedades,
lo que hace que un valor de objeto tenga un contenido diferente en momentos
diferentes.
Cuando tenemos dos números, 120 y 120, podemos considerarlos precisa-
mente el mismo número, tanto si se refieren a los mismos bits físicos como si
no. Con los objetos, hay una diferencia entre tener dos referencias al mismo
objeto y tener dos objetos diferentes que contienen las mismas propiedades.
Considera el siguiente código:
let object1 = {value: 10};
let object2 = object1;
62

-- 74 of 445 --

let object3 = {value: 10};
console.log(object1 == object2);
// → true
console.log(object1 == object3);
// → false
object1.value = 15;
console.log(object2.value);
// → 15
console.log(object3.value);
// → 10
Las asignaciones object1 y object2 contienen la misma referencia al objeto, por
lo que al cambiar object1 también se cambia el valor de object2. Se dice que
tienen la misma identidad. La asignación object3 apunta a un objeto diferente,
que inicialmente contiene las mismas propiedades que object1 pero vive una
vida separada.
Las asignaciones pueden ser modificables o constantes, pero esto es indepen-
diente de cómo se comportan sus valores. Aunque los valores numéricos no
cambian, puedes utilizar una asignación let para hacer un seguimiento de un
número que cambia al cambiar el valor al que apunta la asignación. De manera
similar, aunque una asignación const a un objeto en sí no puede cambiarse y
seguirá apuntando al mismo objeto, los contenidos de ese objeto pueden cam-
biar.
const score = {visitors: 0, home: 0};
// Esto está bien
score.visitors = 1;
// Esto no está permitido
score = {visitors: 1, home: 1};
Cuando se comparan objetos con el operador == de JavaScript, se compara
por identidad: producirá true solo si ambos objetos son exactamente el mismo
valor. Comparar objetos diferentes devolverá false, incluso si tienen propiedades
idénticas. No hay una operación de comparación “profunda” incorporada en
JavaScript que compare objetos por contenido, pero es posible escribirla tú
mismo (lo cual es uno de los ejercicios al final de este capítulo).
El diario del licántropo
Jacques inicia su intérprete de JavaScript y configura el entorno que necesita
para mantener su diario:
63

-- 75 of 445 --

let journal = [];
function addEntry(events, squirrel) {
journal.push({events, squirrel});
}
Observa que el objeto agregado al diario luce un poco extraño. En lugar de
declarar propiedades como events: events, simplemente se da un nombre de
propiedad: events. Esta es una forma abreviada que significa lo mismo: si un
nombre de propiedad en notación de llaves no va seguido de un valor, su valor
se toma del enlace con el mismo nombre.
Cada noche a las 10 p.m., o a veces a la mañana siguiente después de bajar
de la repisa superior de su estantería, Jacques registra el día:
addEntry(["work", "touched tree", "pizza", "running",
"television"], false);
addEntry(["work", "ice cream", "cauliflower", "lasagna",
"touched tree", "brushed teeth"], false);
addEntry(["weekend", "cycling", "break", "peanuts",
"beer"], true);
Una vez que tiene suficientes puntos de datos, tiene la intención de utilizar
estadísticas para descubrir qué eventos pueden estar relacionados con las trans-
formaciones en ardilla.
La correlación es una medida de la dependencia entre variables estadísticas.
Una variable estadística no es exactamente igual a una variable de progra-
mación. En estadística, típicamente tienes un conjunto de mediciones, y cada
variable se mide para cada medición. La correlación entre variables suele ex-
presarse como un valor que va de -1 a 1. Una correlación de cero significa que
las variables no están relacionadas. Una correlación de 1 indica que las dos
están perfectamente relacionadas: si conoces una, también conoces la otra. Un
-1 también significa que las variables están perfectamente relacionadas pero son
opuestas: cuando una es verdadera, la otra es falsa.
Para calcular la medida de correlación entre dos variables booleanas, pode-
mos utilizar el coeficiente phi (φ). Esta es una fórmula cuya entrada es una
tabla de frecuencias que contiene la cantidad de veces que se observaron las
diferentes combinaciones de las variables. La salida de la fórmula es un número
entre -1 y 1 que describe la correlación.
Podríamos tomar el evento de comer pizza y ponerlo en una tabla de fre-
cuencias como esta, donde cada número indica la cantidad de veces que ocurrió
esa combinación en nuestras mediciones.
64

-- 76 of 445 --

No squirrel, no pizza 	76
Squirrel, no pizza 	4
No squirrel, pizza 	9
Squirrel, pizza 	1
Si llamamos a esa tabla n, podemos calcular φ utilizando la siguiente fórmula:
φ = n11n00 − n10n01
√n1•n0•n•1n•0
(4.1)
(Si en este punto estás dejando el libro para concentrarte en un terrible
flashback a la clase de matemáticas de décimo grado, ¡espera! No pretendo tor-
turarte con interminables páginas de notación críptica, solo es esta fórmula por
ahora. Y incluso con esta, todo lo que haremos es convertirla en JavaScript).
La notación n01 indica la cantidad de mediciones donde la primera variable
(ardillez) es falsa (0) y la segunda variable (pizza) es verdadera (1). En la tabla
de pizza, n01 es 9.El valor n1• se refiere a la suma de todas las mediciones donde
la primera variable es verdadera, que es 5 en el ejemplo de la tabla. De manera
similar, n•0 se refiere a la suma de las mediciones donde la segunda variable es
falsa.
Entonces para la tabla de pizza, la parte encima de la línea de división
(el dividendo) sería 1×76−4×9 = 40, y la parte debajo de ella (el divisor)
sería la raíz cuadrada de 5×85×10×80, o √340, 000. Esto da un valor de φ
≈ 0.069, que es muy pequeño. Comer pizza no parece tener influencia en las
transformaciones.
Calculando la correlación
Podemos representar una tabla dos por dos en JavaScript con un array de cuatro
elementos ([76, 9, 4, 1]). También podríamos usar otras representaciones,
como un array que contiene dos arrays de dos elementos cada uno ([[76, 9],
[4, 1]]) o un objeto con nombres de propiedades como "11" y "01", pero el
array plano es simple y hace que las expresiones que acceden a la tabla sean
agradabemente cortas. Interpretaremos los índices del array como números
binarios de dos bits, donde el dígito más a la izquierda (más significativo) se
refiere a la variable ardilla y el dígito más a la derecha (menos significativo) se
65

-- 77 of 445 --

refiere a la variable de evento. Por ejemplo, el número binario 10 se refiere al
caso donde Jacques se transformó en ardilla, pero el evento (digamos, “pizza”)
no ocurrió. Esto sucedió cuatro veces. Y como 10 en binario es 2 en notación
decimal, almacenaremos este número en el índice 2 del array.
Esta es la función que calcula el coeficiente φ a partir de dicho array:
function phi(table) {
return (table[3] * table[0] - table[2] * table[1]) /
Math.sqrt((table[2] + table[3]) *
(table[0] + table[1]) *
(table[1] + table[3]) *
(table[0] + table[2]));
}
console.log(phi([76, 9, 4, 1]));
// → 0.068599434
Esta es una traducción directa de la fórmula de φ a JavaScript. Math.sqrt
es la función de raíz cuadrada, como se provee en el objeto Math en un en-
torno estándar de JavaScript. Debemos agregar dos campos de la tabla para
obtener campos como n1• porque las sumas de filas o columnas no se almacenan
directamente en nuestra estructura de datos.
Jacques mantiene su diario por tres meses. El conjunto de datos resultante
está disponible en el sandbox de código para este capítulo (https://eloquentjavascript.net/
code#4), donde se almacena en el vínculo JOURNAL, y en un archivo descargable
aquí.
Para extraer una tabla dos por dos para un evento específico del diario,
debemos recorrer todas las entradas y contar cuántas veces ocurre el evento en
relación con las transformaciones de ardilla:
function tableFor(event, journal) {
let table = [0, 0, 0, 0];
for (let i = 0; i < journal.length; i++) {
let entry = journal[i], index = 0;
if (entry.events.includes(event)) index += 1;
if (entry.squirrel) index += 2;
table[index] += 1;
}
return table;
}
console.log(tableFor("pizza", JOURNAL));
// → [76, 9, 4, 1]
66

-- 78 of 445 --

Los arrays tienen un método includes que comprueba si un valor dado existe
en el array. La función utiliza esto para determinar si el nombre del evento en
el que está interesado forma parte de la lista de eventos de un día dado.
El cuerpo del bucle en tableFor determina en qué caja de la tabla cae cada
entrada del diario, verificando si la entrada contiene el evento específico en
el que está interesado y si el evento ocurre junto con un incidente de ardilla.
Luego, el bucle suma uno a la caja correcta de la tabla.
Ahora tenemos las herramientas necesarias para calcular correlaciones indi-
viduales. El único paso restante es encontrar una correlación para cada tipo
de evento que se registró y ver si algo destaca.
Bucles de Array
En la función tableFor, hay un bucle como este:
for (let i = 0; i < JOURNAL.length; i++) {
let entry = JOURNAL[i];
// Hacer algo con entry
}
Este tipo de bucle es común en el JavaScript clásico; recorrer arrays elemento
por elemento es algo que se hace con frecuencia, y para hacerlo se recorre un
contador sobre la longitud del array y se selecciona cada elemento por turno.
Hay una forma más sencilla de escribir tales bucles en JavaScript moderno:
for (let entry of JOURNAL) {
console.log(`${entry.events.length} eventos.`);
}
Cuando un bucle for usa la palabra of después de la definición de su variable,
recorrerá los elementos del valor dado después de of. Esto no solo funciona
para arrays, sino también para cadenas y algunas otras estructuras de datos.
Discutiremos cómo funciona en el Capítulo 6.
El análisis final
Necesitamos calcular una correlación para cada tipo de evento que ocurre en el
conjunto de datos. Para hacerlo, primero necesitamos encontrar cada tipo de
evento.
function journalEvents(journal) {
let events = [];
67

-- 79 of 445 --

for (let entry of journal) {
for (let event of entry.events) {
if (!events.includes(event)) {
events.push(event);
}
}
}
return events;
}
console.log(journalEvents(JOURNAL));
// → ["zanahoria", "ejercicio", "fin de semana", "pan", …]
Agregando los nombres de cualquier evento que no estén en él al array events,
la función recopila todos los tipos de eventos.
Usando esa función, podemos ver todas las correlaciones:
for (let event of journalEvents(JOURNAL)) {
console.log(event + ":", phi(tableFor(event, JOURNAL)));
}
// → zanahoria: 0.0140970969
// → ejercicio: 0.0685994341
// → fin de semana: 0.1371988681
// → pan: -0.0757554019
// → pudín: -0.0648203724
// y así sucesivamente...
La mayoría de las correlaciones parecen estar cerca de cero. Comer zanahorias,
pan o pudín aparentemente no desencadena la licantropía de las ardillas. Las
transformaciones parecen ocurrir un poco más a menudo los fines de semana.
Filtraremos los resultados para mostrar solo correlaciones mayores que 0.1 o
menores que -0.1:
for (let event of journalEvents(JOURNAL)) {
let correlation = phi(tableFor(event, JOURNAL));
if (correlation > 0.1 || correlation < -0.1) {
console.log(event + ":", correlation);
}
}
// → fin de semana: 0.1371988681
// → cepillarse los dientes: -0.3805211953
// → dulces: 0.1296407447
// → trabajo: -0.1371988681
// → espaguetis: 0.2425356250
// → lectura: 0.1106828054
// → cacahuetes: 0.5902679812
68

-- 80 of 445 --

¡Ajá! Hay dos factores con una correlación claramente más fuerte que los
demás. Comer cacahuetes tiene un fuerte efecto positivo en la posibilidad de
convertirse en una ardilla, mientras que cepillarse los dientes tiene un efecto
negativo significativo.
Interesante. Intentemos algo:
for (let entry of JOURNAL) {
if (entry.events.includes("cacahuetes") &&
!entry.events.includes("cepillarse los dientes")) {
entry.events.push("dientes de cacahuate");
}
}
console.log(phi(tableFor("dientes de cacahuate", JOURNAL)));
// → 1
Ese es un resultado sólido. El fenómeno ocurre precisamente cuando Jacques
come cacahuetes y no se cepilla los dientes. Si tan solo no fuera tan descuidado
con la higiene dental, ni siquiera se habría dado cuenta de su aflicción.
Sabiendo esto, Jacques deja de comer cacahuetes por completo y descubre
que sus transformaciones se detienen.
Pero solo pasan unos pocos meses antes de que se dé cuenta de que algo falta
en esta forma de vivir completamente humana. Sin sus aventuras salvajes,
Jacques apenas se siente vivo. Decide que prefiere ser un animal salvaje a
tiempo completo. Después de construir una hermosa casita en un árbol en
el bosque y equiparla con un dispensador de mantequilla de cacahuate y un
suministro de diez años de mantequilla de cacahuate, cambia de forma por
última vez y vive la corta y enérgica vida de una ardilla.
Más arreología
Antes de terminar el capítulo, quiero presentarte algunos conceptos más rela-
cionados con objetos. Comenzaré presentando algunos métodos de array gen-
eralmente útiles.
Vimos push y pop, que agregan y eliminan elementos al final de un array,
anteriormente en este capítulo. Los métodos correspondientes para agregar y
eliminar cosas al principio de un array se llaman unshift y shift.
let listaDeTareas = [];
function recordar(tarea) {
listaDeTareas.push(tarea);
}
function obtenerTarea() {
69

-- 81 of 445 --

return listaDeTareas.shift();
}
function recordarUrgente(tarea) {
listaDeTareas.unshift(tarea);
}
Este programa gestiona una cola de tareas. Agregas tareas al final de la cola
llamando a recordar("comestibles"), y cuando estás listo para hacer algo,
llamas a obtenerTarea() para obtener (y eliminar) el primer elemento de la
cola. La función recordarUrgente también agrega una tarea pero la agrega al
principio en lugar de al final de la cola.
Para buscar un valor específico, los arrays proporcionan un método indexOf.
Este método busca a través del array desde el principio hasta el final y devuelve
el índice en el que se encontró el valor solicitado, o -1 si no se encontró. Para
buscar desde el final en lugar de desde el principio, existe un método similar
llamado lastIndexOf:
console.log([1, 2, 3, 2, 1].indexOf(2));
// → 1
console.log([1, 2, 3, 2, 1].lastIndexOf(2));
// → 3
Tanto indexOf como lastIndexOf admiten un segundo argumento opcional que
indica dónde comenzar la búsqueda.
Otro método fundamental de los arrays es slice, que toma índices de inicio
y fin y devuelve un array que solo contiene los elementos entre ellos. El índice
de inicio es inclusivo, mientras que el índice de fin es exclusivo.
console.log([0, 1, 2, 3, 4].slice(2, 4));
// → [2, 3]
console.log([0, 1, 2, 3, 4].slice(2));
// → [2, 3, 4]
Cuando no se proporciona el índice de fin, slice tomará todos los elementos
después del índice de inicio. También puedes omitir el índice de inicio para
copiar todo el array.
El método concat se puede usar para concatenar arrays y crear un nuevo
array, similar a lo que el operador + hace para las strings.
El siguiente ejemplo muestra tanto concat como slice en acción. Toma un
array y un índice y devuelve un nuevo array que es una copia del array original
con el elemento en el índice dado eliminado:
function remove(array, index) {
return array.slice(0, index)
70

-- 82 of 445 --

.concat(array.slice(index + 1));
}
console.log(remove(["a", "b", "c", "d", "e"], 2));
// → ["a", "b", "d", "e"]
Si le pasas a concat un argumento que no es un array, ese valor se agregará al
nuevo array como si fuera un array de un solo elemento.
Strings y sus propiedades
Podemos acceder a propiedades como length y toUpperCase en valores de tipo
string. Pero si intentamos añadir una nueva propiedad, esta no se conserva.
let kim = "Kim";
kim.age = 88;
console.log(kim.age);
// → undefined
Los valores de tipo string, number y Boolean no son objetos, y aunque el
lenguaje no se queja si intentas establecer nuevas propiedades en ellos, en real-
idad no almacena esas propiedades. Como se mencionó anteriormente, dichos
valores son inmutables y no pueden ser modificados.
Pero estos tipos tienen propiedades integradas. Cada valor string tiene varios
métodos. Algunos muy útiles son slice e indexOf, que se parecen a los métodos
de arrays del mismo nombre:
console.log("coconuts".slice(4, 7));
// → nut
console.log("coconut".indexOf("u"));
// → 5
Una diferencia es que el indexOf de un string puede buscar un string que
contenga más de un carácter, mientras que el método correspondiente de arrays
busca solo un elemento:
console.log("one two three".indexOf("ee"));
// → 11
El método trim elimina los espacios en blanco (espacios, saltos de línea, tabu-
laciones y caracteres similares) del principio y final de una cadena:
console.log(" okay \n ".trim());
// → okay
La función zeroPad del capítulo anterior también existe como un método. Se
71

-- 83 of 445 --

llama padStart y recibe la longitud deseada y el carácter de relleno como ar-
gumentos:
console.log(String(6).padStart(3, "0"));
// → 006
Puedes dividir una cadena en cada ocurrencia de otra cadena con split y unirla
nuevamente con join:
let sentence = "Secretarybirds specialize in stomping";
let words = sentence.split(" ");
console.log(words);
// → ["Secretarybirds", "specialize", "in", "stomping"]
console.log(words.join(". "));
// → Secretarybirds. specialize. in. stomping
Una cadena puede repetirse con el método repeat, que crea una nueva cadena
que contiene múltiples copias de la cadena original, pegadas juntas:
console.log("LA".repeat(3));