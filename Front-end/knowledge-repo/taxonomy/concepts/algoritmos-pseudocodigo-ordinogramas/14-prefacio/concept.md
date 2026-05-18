# PREFACIO

## Fuente
algoritmos-pseudocodigo-ordinogramas (Cap. 14)

## Contenido
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
cas
