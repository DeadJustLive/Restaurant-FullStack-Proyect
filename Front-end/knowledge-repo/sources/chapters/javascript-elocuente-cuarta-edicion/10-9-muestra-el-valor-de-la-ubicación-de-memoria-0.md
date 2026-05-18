# 9. Muestra el valor de la ubicación de memoria 0.

Aunque eso ya es más legible que la sopa de bits, sigue siendo bastante con-
fusa. Usar nombres en lugar de números para las instrucciones y las ubicaciones
de memoria ayuda:
Establecer “total” en 0.
Establecer “count” en 1.
[bucle]
Establecer “compare” en “count”.
Restar 11 de “compare”.
Si “compare” es cero, continuar en [fin].
Sumar “count” a “total”.
Añadir 1 a “count”.
Continuar en [bucle].
[fin]
Mostrar “total”.
¿Puedes ver cómo funciona el programa en este punto? Las dos primeras líneas
asignan los valores iniciales a dos ubicaciones de memoria: total se utilizará
para construir el resultado de la computación, y count llevará la cuenta del
4

-- 16 of 445 --

número que estamos observando en ese momento. Las líneas que utilizan
compare probablemente sean las más confusas. El programa quiere ver si count
es igual a 11 para decidir si puede dejar de ejecutarse. Debido a que nuestra
máquina hipotética es bastante primitiva, solo puede comprobar si un número
es cero y tomar una decisión en función de ese valor. Por lo tanto, utiliza
la ubicación de memoria etiquetada como compare para calcular el valor de
count - 11 y tomar una decisión basada en ese valor. Las siguientes dos líneas
suman el valor de count al resultado e incrementan count en 1 cada vez que
el programa decide que count aún no es 11. Aquí está el mismo programa en
JavaScript:
let total = 0, count = 1;
while (count <= 10) {
total += count;
count += 1;
}
console.log(total);
// → 55
Esta versión nos proporciona algunas mejoras. Lo más importante es que ya
no es necesario especificar la forma en que queremos que el programa salte
hacia adelante y hacia atrás; la construcción while se encarga de eso. Continúa
ejecutando el bloque (entre llaves) debajo de él siempre y cuando se cumpla la
condición que se le ha dado. Esa condición es count <= 10, lo que significa “el
recuento es menor o igual a 10”. Ya no tenemos que crear un valor temporal y
compararlo con cero, lo cual era simplemente un detalle no interesante. Parte
del poder de los lenguajes de programación es que pueden encargarse de los
detalles no interesantes por nosotros.
Al final del programa, después de que la construcción while haya terminado,
se utiliza la operación console.log para escribir el resultado.
Finalmente, así es como podría verse el programa si tuviéramos a nuestra
disposición las operaciones convenientes rango y suma, que respectivamente
crean una colección de números dentro de un rango y calculan la suma de una
colección de números:
console.log(suma(rango(1, 10)));
// → 55
La moraleja de esta historia es que el mismo programa puede expresarse de
formas largas y cortas, ilegibles y legibles. La primera versión del programa
era extremadamente críptica, mientras que esta última es casi en inglés: registra
(log) la suma del rango de números del 1 al 10. (Veremos en capítulos posteriores
5

-- 17 of 445 --

cómo definir operaciones como suma y rango.)
Un buen lenguaje de programación ayuda al programador al permitirle hablar
sobre las acciones que la computadora debe realizar a un nivel más alto. Ayuda
a omitir detalles, proporciona bloques de construcción convenientes (como
while y console.log), te permite definir tus propios bloques de construcción
(como suma y rango), y hace que esos bloques sean fáciles de componer.
¿Qué es JavaScript?
JavaScript fue introducido en 1995 como una forma de agregar programas a
páginas web en el navegador Netscape Navigator. Desde entonces, el lenguaje
ha sido adoptado por todos los demás navegadores web gráficos principales.
Ha hecho posibles aplicaciones web modernas, es decir, aplicaciones con las
que puedes interactuar directamente sin tener que recargar la página para cada
acción. JavaScript también se utiliza en sitios web más tradicionales para
proporcionar distintas formas de interactividad e ingenio.
Es importante tener en cuenta que JavaScript casi no tiene nada que ver con
el lenguaje de programación llamado Java. El nombre similar fue inspirado por
consideraciones de marketing en lugar de un buen juicio. Cuando se estaba
introduciendo JavaScript, el lenguaje Java se estaba comercializando mucho y
ganaba popularidad. Alguien pensó que era una buena idea intentar aprovechar
este éxito. Ahora estamos atrapados con el nombre.
Después de su adopción fuera de Netscape, se escribió un documento estándar
para describir la forma en que debería funcionar el lenguaje JavaScript para
que las diversas piezas de software que afirmaban soportar JavaScript pudieran
asegurarse de que realmente proporcionaban el mismo lenguaje. Esto se llama
el estándar ECMAScript, según la organización Ecma International que llevó a
cabo la estandarización. En la práctica, los términos ECMAScript y JavaScript
se pueden usar indistintamente, son dos nombres para el mismo lenguaje.
Hay quienes dirán cosas terribles sobre JavaScript. Muchas de esas cosas
son ciertas. Cuando me pidieron que escribiera algo en JavaScript por primera
vez, rápidamente llegué a detestarlo. Aceptaba casi cualquier cosa que escribía
pero lo interpretaba de una manera completamente diferente a lo que yo quería
decir. Esto tenía mucho que ver con el hecho de que no tenía ni idea de lo que
estaba haciendo, por supuesto, pero hay un problema real aquí: JavaScript es
ridículamente liberal en lo que permite. La idea detrás de este diseño era que
haría la programación en JavaScript más fácil para principiantes. En realidad,
esto hace que encontrar problemas en tus programas sea más difícil porque el
sistema no te los señalará.
6

-- 18 of 445 --

Esta flexibilidad también tiene sus ventajas. Deja espacio para técnicas im-
posibles en lenguajes más rígidos y permite un estilo de programación agradable
e informal. Después de aprender el lenguaje adecuadamente y trabajar con él
durante un tiempo, ha llegado a realmente gustarme JavaScript.
Ha habido varias versiones de JavaScript. La versión ECMAScript 3 fue la
versión ampliamente soportada durante el ascenso al dominio de JavaScript,
aproximadamente entre 2000 y 2010. Durante este tiempo, se estaba trabajando
en una versión ambiciosa 4, la cual planeaba una serie de mejoras y extensiones
radicales al lenguaje. Cambiar un lenguaje vivo y ampliamente utilizado de
esa manera resultó ser políticamente difícil, y el trabajo en la versión 4 fue
abandonado en 2008. Una versión 5, mucho menos ambiciosa, que solo realizaba
algunas mejoras no controversiales, salió en 2009. En 2015, salió la versión 6,
una actualización importante que incluía algunas de las ideas previstas para la
versión 4. Desde entonces, hemos tenido nuevas actualizaciones pequeñas cada
año.
El hecho de que JavaScript esté evolucionando significa que los navegadores
tienen que mantenerse constantemente al día. Si estás usando un navegador
más antiguo, es posible que no admita todas las funciones. Los diseñadores
del lenguaje se aseguran de no realizar cambios que puedan romper programas
existentes, por lo que los nuevos navegadores aún pueden ejecutar programas
antiguos. En este libro, estoy utilizando la versión 2023 de JavaScript.
Los navegadores web no son las únicas plataformas en las que se utiliza
JavaScript. Algunas bases de datos, como MongoDB y CouchDB, utilizan
JavaScript como su lenguaje de secuencias de comandos y consulta. Varias
plataformas para programación de escritorio y servidores, especialmente el
proyecto Node.js (el tema del Capítulo 20), proporcionan un entorno para pro-
gramar en JavaScript fuera del navegador.
Código y qué hacer con él
El código es el texto que constituye los programas. La mayoría de los capítulos
en este libro contienen bastante código. Creo que leer código y escribir código
son partes indispensables de aprender a programar. Intenta no solo echar un
vistazo a los ejemplos, léelos atentamente y entiéndelos. Esto puede ser lento
y confuso al principio, pero te prometo que pronto le tomarás la mano. Lo
mismo ocurre con los ejercicios. No des por sentado que los entiendes hasta
que hayas escrito realmente una solución que funcione.
Te recomiendo que pruebes tus soluciones a los ejercicios en un intérprete de
JavaScript real. De esta manera, obtendrás comentarios inmediatos sobre si lo
7

-- 19 of 445 --

que estás haciendo funciona, y, espero, te tentarán a experimentar y a ir más
allá de los ejercicios.
La forma más sencilla de ejecutar el código de ejemplo en el libro —y de ex-
perimentar con él— es buscarlo en la versión en línea del libro en https://eloquentjavascript.net.
Allí, puedes hacer clic en cualquier ejemplo de código para editarlo y eje-
cutarlo, y ver la salida que produce. Para trabajar en los ejercicios, ve a
https://eloquentjavascript.net/code, que proporciona el código inicial para cada
ejercicio de programación y te permite ver las soluciones.
Ejecutar los programas definidos en este libro fuera del sitio web del libro
requiere cierto cuidado. Muchos ejemplos son independientes y deberían fun-
cionar en cualquier entorno de JavaScript. Pero el código en los capítulos pos-
teriores a menudo está escrito para un entorno específico (navegador o Node.js)
y solo puede ejecutarse allí. Además, muchos capítulos definen programas más
grandes, y las piezas de código que aparecen en ellos dependen unas de otras o
de archivos externos. El sandbox en el sitio web proporciona enlaces a archivos
ZIP que contienen todos los scripts y archivos de datos necesarios para ejecutar
el código de un capítulo dado.
Visión general de este libro
Este libro consta aproximadamente de tres partes. Los primeros 12 capítulos
tratan sobre el lenguaje JavaScript. Los siguientes siete capítulos son acerca de
los navegadores web y la forma en que se utiliza JavaScript para programarlos.
Por último, dos capítulos están dedicados a Node.js, otro entorno para progra-
mar en JavaScript. Hay cinco capítulos de proyectos en el libro que describen
programas de ejemplo más grandes para darte una idea de la programación
real.
La parte del lenguaje del libro comienza con cuatro capítulos que introducen
la estructura básica del lenguaje JavaScript. Discuten las estructuras de control
(como la palabra while que viste en esta introducción), las funciones (escribir
tus propios bloques de construcción) y las estructuras de datos. Después de es-
tos, serás capaz de escribir programas básicos. Luego, los Capítulos 5 y 6 intro-
ducen técnicas para usar funciones y objetos para escribir código más abstracto
y mantener la complejidad bajo control. Después de un primer capítulo del
proyecto que construye un robot de entrega rudimentario, la parte del lenguaje
del libro continúa con capítulos sobre manejo de errores y corrección de errores,
expresiones regulares (una herramienta importante para trabajar con texto),
modularidad (otra defensa contra la complejidad) y programación asíncrona
(tratando con eventos que toman tiempo). El segundo capítulo del proyecto,
8

-- 20 of 445 --

donde implementamos un lenguaje de programación, concluye la primera parte
del libro.
La segunda parte del libro, de los capítulos 13 a 19, describe las herramientas
a las que tiene acceso JavaScript en un navegador. Aprenderás a mostrar
cosas en la pantalla (Capítulos 14 y 17), responder a la entrada del usuario
(Capítulo 15) y comunicarte a través de la red (Capítulo 18). Nuevamente hay
dos capítulos de proyecto en esta parte, construyendo un juego de plataformas
y un programa de pintura de píxeles.
El Capítulo 20 describe Node.js, y el Capítulo 21 construye un pequeño sitio
web utilizando esa herramienta.
Convenciones tipográficas
En este libro, el texto escrito en una fuente monoespaciada representará ele-
mentos de programas. A veces estos son fragmentos autosuficientes, y a veces
simplemente se refieren a partes de un programa cercano. Los programas (de
los cuales ya has visto algunos) se escriben de la siguiente manera:
function factorial(n) {
if (n == 0) {
return 1;
} else {
return factorial(n - 1) * n;
}
}
A veces, para mostrar la salida que produce un programa, la salida esperada
se escribe después, con dos barras inclinadas y una flecha al frente.
console.log(factorial(8));
// → 40320
¡Buena suerte!
9

-- 21 of 445 --

Chapter 1
Valores, Tipos y Operadores
“Debajo de la superficie de la máquina, el programa se mueve. Sin esfuerzo, se
expande y contrae. En gran armonía, los electrones se dispersan y se reagrupan.
Las formas en el monitor no son más que ondas en el agua. La esencia per-
manece invisible debajo.”
—Master Yuan-Ma, El Libro de la Programación
En el mundo de la computadora, solo existe data. Puedes leer data, modificar
data, crear nueva data, pero aquello que no es data no puede ser mencionado.
Toda esta data se almacena como largas secuencias de bits y, por lo tanto, es
fundamentalmente similar.
Los bits son cualquier tipo de cosas de dos valores, generalmente descritos
como ceros y unos. Dentro de la computadora, toman formas como una carga
eléctrica alta o baja, una señal fuerte o débil, o un punto brillante u opaco en la
superficie de un CD. Cualquier pieza de información discreta puede reducirse
a una secuencia de ceros y unos y por lo tanto representarse en bits.
Por ejemplo, podemos expresar el número 13 en bits. Esto funciona de la
misma manera que un número decimal, pero en lugar de diez dígitos diferentes,
tenemos solo 2, y el peso de cada uno aumenta por un factor de 2 de derecha
a izquierda. Aquí están los bits que componen el número 13, con los pesos de
los dígitos mostrados debajo de ellos:
0 0 0 0 1 1 0 1
128 64 32 16 8 4 2 1
Ese es el número binario 00001101. Sus dígitos no nulos representan 8, 4 y 1,
y suman 13.
Valores
Imagina una mar de bits—un océano de ellos. Una computadora moderna
típica tiene más de 100 mil millones de bits en su almacenamiento de datos
volátil (memoria de trabajo). El almacenamiento no volátil (el disco duro o
10

-- 22 of 445 --

equivalente) tiende a tener aún unos cuantos órdenes de magnitud más.
Para poder trabajar con tales cantidades de bits sin perderse, los separamos
en trozos que representan piezas de información. En un entorno de JavaScript,
esos trozos se llaman valores. Aunque todos los valores están hechos de bits,
desempeñan roles diferentes. Cada valor tiene un tipo que determina su fun-
ción. Algunos valores son números, otros son fragmentos de texto, otros son
funciones, y así sucesivamente.
Para crear un valor, simplemente debes invocar su nombre. Esto es conve-
niente. No tienes que recolectar material de construcción para tus valores ni
pagar por ellos. Solo solicitas uno, y ¡zas!, lo tienes. Por supuesto, los valores
no se crean realmente de la nada. Cada uno tiene que almacenarse en algún
lugar, y si deseas usar gigantescas cantidades de ellos al mismo tiempo, podrías
quedarte sin memoria de computadora. Afortunadamente, este es un problema
solo si los necesitas todos simultáneamente. Tan pronto como dejes de usar
un valor, se disipará, dejando atrás sus bits para ser reciclados como material
de construcción para la próxima generación de valores. El resto de este capí-
tulo presenta los elementos atómicos de los programas de JavaScript, es decir,
los tipos de valores simples y los operadores que pueden actuar sobre dichos
valores.
Números
Los valores del tipo number son, como era de esperar, valores numéricos. En
un programa de JavaScript, se escriben de la siguiente manera:
13
Usar esto en un programa hará que el patrón de bits para el número 13 exista
en la memoria del ordenador.
JavaScript utiliza un número fijo de bits, 64 de ellos, para almacenar un
único valor numérico. Hay un número limitado de patrones que puedes hacer
con 64 bits, lo que limita la cantidad de números diferentes que se pueden
representar. Con N dígitos decimales, puedes representar 10N números. De
manera similar, dada una cifra de 64 dígitos binarios, puedes representar 264
números diferentes, que son alrededor de 18 mil trillones (un 18 seguido de 18
ceros). Eso es mucho.
La memoria de la computadora solía ser mucho más pequeña, y la gente
solía utilizar grupos de 8 o 16 bits para representar sus números. Era fácil
tener un desbordamiento accidental con números tan pequeños, terminando
con un número que no encajaba en la cantidad dada de bits. Hoy en día,
11

-- 23 of 445 --

incluso las computadoras que caben en tu bolsillo tienen mucha memoria, por
lo que puedes utilizar trozos de 64 bits y solo necesitas preocuparte por el
desbordamiento cuando lidias con números realmente astronómicos.
Sin embargo, no todos los números enteros menores que 18 mil trillones
encajan en un número de JavaScript. Esos bits también almacenan números
negativos, por lo que un bit indica el signo del número. Un problema más
grande es representar números no enteros. Para hacer esto, algunos de los bits
se utilizan para almacenar la posición del punto decimal. El número entero
máximo real que se puede almacenar está más en el rango de 9 cuatrillones (15
ceros), que sigue siendo increíblemente grande.
Los números fraccionarios se escriben usando un punto:
9.81
Para números muy grandes o muy pequeños, también puedes usar notación
científica agregando una e (de exponente), seguida del exponente del número:
2.998e8
Eso es 2.998 × 108 = 299,800,000.
Los cálculos con números enteros (también llamados enteros) que son más
pequeños que los mencionados 9 cuatrillones siempre serán precisos. Desafor-
tunadamente, los cálculos con números fraccionarios generalmente no lo son.
Así como π (pi) no puede expresarse con precisión mediante un número finito
de dígitos decimales, muchos números pierden algo de precisión cuando solo
están disponibles 64 bits para almacenarlos. Es una lástima, pero solo causa
problemas prácticos en situaciones específicas. Lo importante es ser consciente
de esto y tratar los números digitales fraccionarios como aproximaciones, no
como valores precisos.
Aritmética
Lo principal que se puede hacer con los números es la aritmética. Operaciones
aritméticas como la suma o la multiplicación toman dos valores numéricos y
producen un nuevo número a partir de ellos. Así es como se ven en JavaScript:
100 + 4 * 11
Los símbolos + y * se llaman operadores. El primero representa la suma y el
segundo representa la multiplicación. Colocar un operador entre dos valores
aplicará ese operador a esos valores y producirá un nuevo valor.
¿Significa este ejemplo “Sumar 4 y 100, y luego multiplicar el resultado por
11”, o se realiza primero la multiplicación antes de la suma? Como habrás
12

-- 24 of 445 --

adivinado, la multiplicación se realiza primero. Como en matemáticas, puedes
cambiar esto envolviendo la suma entre paréntesis:
(100 + 4) * 11
Para la resta, está el operador -. La división se puede hacer con el operador /.
Cuando los operadores aparecen juntos sin paréntesis, el orden en que se
aplican se determina por la precedencia de los operadores. El ejemplo muestra
que la multiplicación se realiza antes que la suma. El operador / tiene la
misma precedencia que *. Igualmente, + y - tienen la misma precedencia.
Cuando varios operadores con la misma precedencia aparecen uno al lado del
otro, como en 1 - 2 + 1, se aplican de izquierda a derecha: (1 - 2)+ 1.
No te preocupes demasiado por estas reglas de precedencia. Cuando tengas
dudas, simplemente agrega paréntesis.
Hay un operador aritmético más, que quizás no reconozcas de inmediato.
El símbolo % se utiliza para representar la operación de residuo. X % Y es el
residuo de dividir X por Y. Por ejemplo, 314 % 100 produce 14, y 144 % 12 da