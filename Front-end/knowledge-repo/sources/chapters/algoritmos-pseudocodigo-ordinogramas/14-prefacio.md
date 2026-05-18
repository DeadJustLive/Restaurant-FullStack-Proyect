# PREFACIO

Objetivo del libro
En programación, los tipos de datos, las variables, las constantes, los operadores, las
expresiones y las instrucciones, son los elementos básicos que se pueden utilizar para diseñar
algoritmos. Así pues, en este libro se estudia de qué manera se interrelacionan dichos
elementos entre sí.
Véase en el tutorial de programación de Abrirllave que los algoritmos son utilizados en la fase
de diseño de un programa.
Contenidos del libro
Este libro está pensado, fundamentalmente, para todos aquellos que quieran aprender a
diseñar algoritmos utilizando pseudocódigo, así como, diagramas de flujo (ordinogramas).
Los contenidos de cada capítulo del libro se apoyan en las explicaciones de los anteriores. Se
pretende de esta forma que el lector pueda adquirir conocimientos, gradualmente,
empezando desde cero, y alcanzar la destreza necesaria para poner en práctica los principios
básicos de la programación estructurada:
 Aplicación del diseño modular.
 Utilización, exclusivamente, de estructuras secuenciales, alternativas y repetitivas.
 Empleo de estructuras de datos adecuadas para manipular información.
Los capítulos del libro son:
 Capítulo 1: Qué es un algoritmo
 Capítulo 2: Introducción a los tipos de datos
 Capítulo 3: Identificadores, variables y constantes
 Capítulo 4: Tipos de datos definidos por el programador
 Capítulo 5: Operadores y expresiones
 Capítulo 6: Instrucciones primitivas
 Capítulo 7: Estructura de un algoritmo en pseudocódigo
 Capítulo 8: Ordinogramas
 Capítulo 9: Instrucciones de control alternativas
 Capítulo 10: Instrucciones de control repetitivas
 Capítulo 11: Instrucciones de control de salto
 Capítulo 12: Llamadas a subalgoritmos
Los contenidos de los primeros diez capítulos están basados en contenidos incluidos en el libro
“Empezar de cero a programar en lenguaje C”, el cual es del mismo autor.

-- 9 of 180 --

Libro de Algoritmos de “Abrirllave.com” 10 / 180
Material extra
En la web del tutorial de algoritmos “www.abrirllave.com/algoritmos/” se proporcionan más
recursos: teoría, ejemplos, ejercicios resueltos, etc.
Erratas
Para comunicar cualquier comentario, sugerencia o error detectado en el texto, puede hacerlo
escribiendo un correo electrónico a:
Todas las sugerencias serán atentidas lo antes posible. Gracias de antemano por colaborar en
la mejora del contenido de este libro.
Agradecimientos
Gracias a todas las personas –familiares, amigos e incluso desconocidos– que tanto me
inspiráis y motiváis –en mayor o menor medida– para escribir libros o contenidos educativos
de informática en la Web; desde 2006 en www.carlospes.com y desde 2014 en
www.abrirllave.com. ¡Gracias a todos!
Carlos Pes
Pamplona, mayo de 2017.
Twitter: @CarlosPes
Blog: http://carlospes.blogspot.com

-- 10 of 180 --

Libro de Algoritmos de “Abrirllave.com” 11 / 180
Capítulo 1
Qué es un algoritmo
En programación, un algoritmo establece, de manera genérica e informal, la secuencia de
pasos o acciones que resuelve un determinado problema informático.
Los algoritmos constituyen la documentación principal que se necesita para poder iniciar la
fase de codificación de un programa y, para representarlos, se utiliza, fundamentalmente, dos
tipos de notación: pseudocódigo y diagramas de flujo (ordinogramas). El diseño de un
algoritmo es independiente del lenguaje que después se vaya a utilizar para codificarlo.
1.1. Pseudocódigo
El pseudocódigo es un lenguaje de programación algorítmico; es un lenguaje intermedio entre
el lenguaje natural y cualquier lenguaje de programación específico, como son: C, FORTRAN,
Pascal, etc. No existe una notación formal o estándar de pseudocódigo, sino que, cada
programador puede utilizar la suya propia. Ahora bien, en los algoritmos de ejemplo de este
tutorial, la mayoría de las palabras que se utilizan son una traducción literal –del inglés al
castellano– de las palabras que se usan en lenguaje C para escribir las instrucciones de los
programas. Por tanto, el pseudocódigo empleado en este tutorial es, mayormente, “C En
Español (CEE)”. Se pretende de esta forma facilitar al estudiante la codificación posterior de los
algoritmos de los ejemplos al lenguaje C. La codificación de un algoritmo consiste en traducirlo
a un lenguaje de programación específico, C en nuestro caso.
EJEMPLO Si se desea crear un programa que calcule la suma de dos números enteros
cualesquiera introducidos por el usuario y, después, muestre por pantalla el resultado
obtenido:

-- 11 of 180 --

Libro de Algoritmos de “Abrirllave.com” 12 / 180
Se puede escribir el algoritmo siguiente:
algoritmo Sumar
variables
entero a, b, c
inicio
escribir( "Introduzca el primer número (entero): " )
leer( a )
escribir( "Introduzca el segundo número (entero): " )
leer( b )
c  a + b
escribir( "La suma es: ", c )
fin
Un algoritmo escrito en pseudocódigo siempre se suele organizar en tres secciones: cabecera,
declaraciones y cuerpo. En la sección de cabecera se escribe el nombre del algoritmo, en este
caso Sumar. En la sección de declaraciones se declaran algunos de los objetos que va a utilizar
el programa. En el tutorial de lenguaje C de Abrirllave se estudian en detalle los distintos tipos
de objetos que pueden ser utilizados en un programa, tales como: variables, constantes,
subprogramas, etc. De momento, obsérvese que, en este ejemplo, las variables a, b y c
indican que el programa necesita tres espacios en la memoria principal de la computadora
para guardar tres números enteros. Cada una de las variables hace referencia a un espacio de
memoria diferente.
En el cuerpo están descritas todas las acciones que se tienen que llevar a cabo en el programa,
y siempre se escriben entre las palabras inicio y fin. La primera acción:

-- 12 of 180 --

Libro de Algoritmos de “Abrirllave.com” 13 / 180
escribir( "Introduzca el primer número (entero): " )
Indica que se debe mostrar por pantalla el mensaje que hay entre comillas dobles. Después,
mediante la acción:
leer( a )
Se está indicando que el programa esperará a que el usuario teclee un número entero, el cual
se almacenará en el espacio de memoria representado por la variable a. El mismo proceso se
tiene que seguir con el segundo número, que se guardará en el espacio de memoria
representado por la variable b.
escribir( "Introduzca el segundo número (entero): " )
leer( b )
Acto seguido, la acción:
c  a + b
Indica que en el espacio de memoria representado por la variable c se debe almacenar la
suma de los dos números introducidos por el usuario del programa. Para terminar, el resultado
de la suma se mostrará por pantalla con la acción:
escribir( "La suma es: ", c )
1.2. Diagramas de flujo (Ordinogramas)
Los algoritmos también se pueden representar, gráficamente, por medio de diagramas de
flujo. Los diagramas de flujo se pueden utilizar con otros fines, sin embargo, en este tutorial
solamente los vamos a emplear para representar algoritmos. A tales diagramas de flujo
también se les conoce como ordinogramas. Dicho de otra forma, un ordinograma representa,
de manera gráfica, el orden de los pasos o acciones de un algoritmo. Por ejemplo, el algoritmo
Sumar escrito en pseudocódigo en el apartado anterior se puede representar mediante el
siguiente ordinograma:

-- 13 of 180 --

Libro de Algoritmos de “Abrirllave.com” 14 / 180
El pseudocódigo y los diagramas de flujo son las dos herramientas más utilizadas para diseñar
algoritmos en programación estructurada. Si bien, entre ambos tipos de representación
existen las siguientes diferencias importantes:
 Los diagramas de flujo empezaron a utilizarse antes que el pseudocódigo.
 En pseudocódigo se suelen definir tres secciones del algoritmo (cabecera,
declaraciones y cuerpo). Sin embargo, en un ordinograma únicamente se representa el
cuerpo.
 En un ordinograma suele ser más fácil ver, a primera vista, cuál es el orden de las
acciones del algoritmo.
 Los símbolos gráficos utilizados en un diagrama de flujo han sido estandarizados por el
American National Standards Institute (ANSI). Sin embargo, no existe un
“pseudocódigo estándar”.
A continuación, se muestran los símbolos gráficos más utilizados para diseñar ordinogramas:

-- 14 of 180 --

Libro de Algoritmos de “Abrirllave.com” 15 / 180
1.3. Cualidades de un algoritmo
Para cualquier problema dado no existe una única solución algorítmica; es tarea de la persona
que diseña un algoritmo encontrar la solución más optima, ésta no es otra que aquella que
cumple más fielmente las cualidades deseables de todo algoritmo bien diseñado:
 Finitud. Un algoritmo siempre tiene que finalizar tras un número finito de acciones.
Cuando el algoritmo Sumar sea ya un programa, la ejecución de éste siempre será la
misma, ya que, siempre se seguirán las acciones descritas en el cuerpo del algoritmo,
una por una, desde la primera hasta la última y en el orden establecido.
 Precisión. Todas las acciones de un algoritmo deben estar bien definidas, esto es,
ninguna acción puede ser ambigua, sino que cada una de ellas solamente se debe
poder interpretar de una única manera. Dicho de otra forma, si el programa que
resulta de un algoritmo se ejecuta varias veces con los mismos datos de entrada, en
todos los casos se obtendrán los mismos datos de salida.
 Claridad. Lo normal es que un problema se pueda resolver de distintas formas. Por
tanto, una de las tareas más importantes del diseñador de un algoritmo es encontrar
la solución más legible, es decir, aquella más comprensible para el ser humano.
 Generalidad. Un algoritmo debe resolver problemas generales. Por ejemplo, el
programa Sumar deberá servir para realizar sumas de dos números enteros
cualesquiera, y no, solamente, para sumar dos números determinados, como pueden
ser el 3 y el 5.

-- 15 of 180 --

Libro de Algoritmos de “Abrirllave.com” 16 / 180
 Eficiencia. La ejecución del programa resultante de codificar un algoritmo deberá
consumir lo menos posible los recursos disponibles del ordenador (memoria, tiempo
de CPU, etc.).
 Sencillez. A veces, encontrar la solución algorítmica más eficiente a un problema
puede llevar a escribir un algoritmo muy complejo, afectando a la claridad del mismo.
Por tanto, hay que intentar que la solución sea sencilla, aun a costa de perder un poco
de eficiencia, es decir, se tiene que buscar un equilibrio entre la claridad y la eficiencia.
Escribir algoritmos sencillos, claros y eficientes se consigue a base de práctica.
 Modularidad. Nunca hay que olvidarse del hecho de que un algoritmo puede formar