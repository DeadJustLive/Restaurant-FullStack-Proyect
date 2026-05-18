# parte d: e la solución a un problema mayor. Pero, a su vez, dicho algoritmo debe

descomponerse en otros, siempre y cuando, esto favorezca a la claridad del mismo.
La persona que diseña un algoritmo debe ser consciente de que todas las propiedades de un
algoritmo se transmitirán al programa resultante.
1.4. Codificación
Una vez que los algoritmos de una aplicación han sido diseñados, ya se puede iniciar la fase de
codificación. En esta etapa se tienen que traducir dichos algoritmos a un lenguaje de
programación específico, en nuestro caso C; es decir, las acciones definidas en los algoritmos
las vamos a convertir en instrucciones, también llamadas sentencias, del lenguaje C.
EJEMPLO Al codificar en C el algoritmo del programa Sumar, se escribirá algo parecido a:
#include <stdio.h>
int main()
{
int a, b, c;
printf( "\n Introduzca el primer n%cmero (entero): ", 163 );
scanf( "%d", &a );
printf( "\n Introduzca el segundo n%cmero (entero): ", 163 );
scanf( "%d", &b );
c = a + b;
printf( "\n La suma es: %d", c );
return 0;
}
Para codificar un algoritmo hay que conocer la sintaxis del lenguaje al que se va a traducir. Sin
embargo, independientemente del lenguaje de programación en que esté escrito un
programa, será su algoritmo el que determine su lógica. La lógica de un programa establece
cuáles son sus acciones y en qué orden se deben ejecutar. Por tanto, es conveniente que todo
programador aprenda a diseñar algoritmos antes de pasar a la fase de codificación.

-- 16 of 180 --

Libro de Algoritmos de “Abrirllave.com” 17 / 180
Capítulo 2
Tipos de datos
Los datos que utilizan los programas se pueden clasificar en base a diferentes criterios. Uno de
los más significativos es aquel que dice que todos los datos que utilizan los programas son
simples o compuestos.
Un dato simple es indivisible (atómico), es decir, no se puede descomponer.
EJEMPLO Un año es un dato simple.
Año...: 2006
Un año se expresa con un número entero, el cual no se puede descomponer. Sin embargo, un
dato compuesto está formado por otros datos.
EJEMPLO Una fecha es un dato compuesto por tres datos simples (día, mes, año).
Fecha:
Día...: 30
Mes...: 11
Año...: 2006
EJEMPLO Las coordenadas de un punto en un plano es también un dato compuesto, en
este caso, por dos datos simples (x, y).
Coordenadas:
X...: 34
y...: 21
EJEMPLO Otro ejemplo de dato simple es una letra.
Letra...: t

-- 17 of 180 --

Libro de Algoritmos de “Abrirllave.com” 18 / 180
Una letra se representa con un carácter del alfabeto. Pero, cuando varias letras se agrupan,
entonces se obtiene un dato compuesto por varios caracteres.
EJEMPLO Para formar un nombre de persona se utilizan varios caracteres.
Nombre...: Ana
Ana es un dato compuesto por tres caracteres.
EJEMPLO Otro ejemplo de dato compuesto es una ficha que contenga el nombre de una
persona, su ciudad de residencia y su fecha de nacimiento.
Ficha:
Nombre...: Maite
Ciudad...: Pamplona
Fecha:
Día...: 22
Mes...: 4
Año...: 1984
En este caso, la ficha es un dato compuesto por tres datos y, a su vez, todos ellos también
son compuestos.
A los datos compuestos también se les conoce como datos estructurados, ya que, son datos
que se forman al agruparse otros. Por consiguiente, de los datos simples se dice que no tienen
estructura.
Seguidamente, se van a estudiar cinco tipos de datos:
 Entero
 Real
 Lógico
 Carácter
 Cadena
De ellos, tan solo el tipo cadena es compuesto. Los demás son los tipos de datos simples
considerados estándares. Esto quiere decir que la mayoría de los lenguajes de programación
permiten trabajar con ellos. Por ejemplo, en C es posible utilizar datos de tipo entero, real y
carácter, sin embargo, los datos de tipo lógico no se pueden utilizar, ya que, no existen en este
lenguaje.
Existen otros tipos de datos, simples y compuestos, que se estudiarán más adelante.
A los tipos de datos simples estándares también se les conoce como tipos de datos primitivos,
básicos o fundamentales.

-- 18 of 180 --

Libro de Algoritmos de “Abrirllave.com” 19 / 180
2.1. Datos de tipo numérico
Como su propio nombre indica, un dato de tipo numérico es aquel que puede tomar por valor
un número. Existen dos tipos de datos numéricos básicos:
 Entero
 Real
EJEMPLO El número de asignaturas aprobadas por un estudiante en la universidad
es un dato de tipo entero, mientras que, su nota en el examen de una asignatura en concreto
puede ser de tipo real.
Asignaturas aprobadas.......: 4
Nota del examen de física...: 7,5
2.2. Datos de tipo entero
Un dato de tipo entero es aquel que puede tomar por valor un número perteneciente al
conjunto de los números enteros (Z), el cual está formado por los números naturales, sus
opuestos (números negativos) y el cero.
Z = { ..., -3, -2, -1, 0, 1, 2, 3, ... }
EJEMPLO La edad de una persona y el año en que nació, son dos datos de tipo entero.
Edad...: 29
Año....: 1976
Z es un conjunto infinito de números enteros, y como el ordenador no puede representarlos
todos, un dato de tipo entero solamente puede tomar por valor un número perteneciente a un
subconjunto de Z. Los valores máximo y mínimo de dicho subconjunto varían según las
características de cada ordenador y del compilador que se utilice.
En pseudocódigo, para indicar que un dato es de tipo entero se utiliza la palabra reservada:
entero
En todos los lenguajes de programación existe un conjunto de palabras que tienen un
significado especial, a estas palabras se las llama reservadas.
2.3. Datos de tipo real
Un dato de tipo real es aquel que puede tomar por valor un número perteneciente al conjunto
de los números reales (R), el cual está formado por los números racionales e irracionales.

-- 19 of 180 --

Libro de Algoritmos de “Abrirllave.com” 20 / 180
EJEMPLO El peso de una persona (en kilogramos) y su altura (en centímetros), son datos
que pueden considerarse de tipo real.
Peso.....: 75,3
Altura...: 172,7
R es un conjunto infinito de números reales, y como el ordenador no puede representarlos
todos, un dato de tipo real solamente puede tomar por valor un número perteneciente a un
subconjunto de R. Los valores de dicho subconjunto varían según las características de cada
ordenador y del compilador que se utilice.
En pseudocódigo, para indicar que un dato es de tipo real se utiliza la palabra reservada:
real
2.4. Datos de tipo lógico
Un dato de tipo lógico es aquel que puede tomar por valor únicamente uno de los dos
siguientes:
{ verdadero, falso }
Los valores verdadero y falso son contrapuestos, de manera que, un dato de tipo lógico
siempre está asociado a que algo se cumpla o no se cumpla.
EJEMPLO El estado de una barrera de paso de trenes es un dato que puede considerarse
de tipo lógico, por ejemplo, asociando verdadero a que esté subida y falso a que esté
bajada.
Estado...: falso
falso indica que la barrera está bajada.
En pseudocódigo, para indicar que un dato es de tipo lógico se utiliza la palabra reservada:
logico
A los datos de tipo lógico también se les conoce como datos de tipo booleano en nombre del
matemático George Boole (1815-1864), que fue quien desarrolló el llamado álgebra de Boole,
aplicado en informática en distintos ámbitos, tales como el diseño de ordenadores o la
programación.
En C no existen los datos de tipo lógico. No obstante, se pueden simular con datos de tipo
entero, considerándose el valor cero (0) como falso, y cualquier otro valor entero como
verdadero.

-- 20 of 180 --

Libro de Algoritmos de “Abrirllave.com” 21 / 180
2.5. Datos de tipo carácter
Un dato de tipo carácter es aquel que puede tomar por valor un carácter perteneciente al
conjunto de los caracteres que puede representar el ordenador.
En pseudocódigo, el valor de un dato de tipo carácter se puede representar entre comillas
simples (') o dobles ("). Pero, en este tutorial, se van a utilizar solamente las comillas simples,
al igual que se hace en C.
EJEMPLO En un examen con preguntas en las que hay que seleccionar la respuesta correcta
entre varias opciones dadas (a, b, c, d, e), la respuesta correcta de cada una de las
preguntas es un dato de tipo carácter.
Respuesta correcta a la pregunta 3...: 'c'
En pseudocódigo, para indicar que un dato es de tipo carácter se utiliza la palabra reservada:
caracter
2.6. Datos de tipo cadena
Un dato de tipo cadena es aquel que puede tomar por valor una secuencia de caracteres.
En pseudocódigo, el valor de un dato de tipo cadena se puede representar entre comillas
simples (') o dobles ("). Sin embargo, en este tutorial, se van a utilizar solamente las comillas
dobles, al igual que se hace en C.
EJEMPLO El título de un libro y el nombre de su autor, son datos de tipo cadena.
Título...: "La Odisea"
Autor....: "Homero"
 "La Odisea" es una cadena de 9 caracteres.
 "Homero" es una cadena de 6 caracteres.
Fíjese que, en la cadena "La Odisea", el carácter espacio en blanco también se cuenta.
En pseudocódigo, para indicar que un dato es de tipo cadena se utiliza la palabra reservada:
cadena

-- 21 of 180 --

Libro de Algoritmos de “Abrirllave.com” 22 / 180
2.7. Clasificación de los tipos de datos simples
Los tipos de datos simples se clasifican en predefinidos y definidos por el programador. La
clasificación completa es:
Los tipos de datos simples predefinidos (estándares) son aquellos proporcionados por los
lenguajes de programación. Pero, el programador también puede definir sus propios tipos de
datos simples (subrangos y enumerados), los cuales se estudiarán más adelante.
Todos los datos simples son ordinales, excepto el dato de tipo real. Un dato ordinal es aquel
que puede tomar por valor un elemento perteneciente a un conjunto en el que todo elemento
tiene un predecesor y un sucesor, excepto el primero y el último. Por ejemplo, el valor 5,
perteneciente al conjunto de los números enteros, tiene como predecesor al 4, y como sucesor
al 6. Sin embargo, entre dos números reales siempre hay un número infinito de números.
Ejercicios resueltos
 Clasificar datos
 Crucigrama de tipos de datos

-- 22 of 180 --

Libro de Algoritmos de “Abrirllave.com” 23 / 180
Capítulo 3
Identificadores, variables y constantes
Para diseñar algoritmos en pseudocódigo, se pueden utilizar los siguientes elementos:
 Tipos de datos
 Variables
 Constantes
 Operadores
 Expresiones
 Instrucciones
Todos ellos están relacionados entre sí. En este capítulo se va a ver la relación que existe entre
los tipos de datos, las variables y las constantes.
3.1. Identificadores
La mayoría de los elementos de un algoritmo escrito en pseudocódigo se diferencian entre sí
por su nombre. Por ejemplo, los tipos de datos básicos se nombran como: entero, real,
logico y caracter.
Cada uno de ellos es un identificador. Un identificador es el nombre que se le da a un
elemento de un algoritmo (o programa). Por ejemplo, el tipo de dato entero hace referencia
a un tipo de dato que es distinto a todos los demás tipos de datos, es decir, los valores que
puede tomar un dato de tipo entero, no son los mismos que los que puede tomar un dato de
otro tipo.
Los identificadores entero, real, logico y caracter están predefinidos, forman parte
del lenguaje algorítmico. No obstante, en un algoritmo también pueden existir identificadores
definidos por el programador. Por ejemplo, un algoritmo puede utilizar variables y constantes
definidas por el programador. Además, los algoritmos también se deben nombrar mediante un
identificador.
En pseudocódigo, a la hora de asignar un nombre a un elemento de un algoritmo, se debe de
tener en cuenta que todo identificador debe cumplir unas reglas de sintaxis. Para ello, en

-- 23 of 180 --

Libro de Algoritmos de “Abrirllave.com” 24 / 180
nuestro pseudocódigo CEE (“C en Español”), vamos a seguir las mismas reglas de sintaxis que
existen en lenguaje C: