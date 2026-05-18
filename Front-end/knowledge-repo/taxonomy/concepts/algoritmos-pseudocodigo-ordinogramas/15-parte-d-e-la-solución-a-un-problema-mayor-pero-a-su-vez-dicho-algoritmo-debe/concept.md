# parte d: e la solución a un problema mayor. Pero, a su vez, dicho algoritmo debe

## Fuente
algoritmos-pseudocodigo-ordinogramas (Cap. 15)

## Contenido
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
todos, un dato de tipo entero solamente puede toma
