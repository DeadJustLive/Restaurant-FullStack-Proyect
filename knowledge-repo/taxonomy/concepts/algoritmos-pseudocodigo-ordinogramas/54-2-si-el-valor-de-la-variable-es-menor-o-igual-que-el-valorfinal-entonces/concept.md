# 2. Si el valor de la <variable> es menor o igual que el <valor_final>, entonces,

## Fuente
algoritmos-pseudocodigo-ordinogramas (Cap. 54)

## Contenido
# 2. Si el valor de la <variable> es menor o igual que el <valor_final>, entonces,

se ejecuta el bloque de instrucciones y, después, se le suma el <valor_
incremento> a la <variable>, volviéndose, de nuevo, a comparar el valor de la
<variable> con el <valor_final>. Y así sucesivamente, hasta que, el valor de la
<variable> sea mayor que el <valor_final>.
En resumen, una instrucción repetitiva para permite ejecutar, repetidamente, un bloque de
instrucciones, en base a un valor inicial y a un valor final.
El bucle para es ideal usarlo cuando, de antemano, ya se sabe el número de veces
(iteraciones) que tiene que ejecutarse un determinado bloque de instrucciones.
El bucle para es una variante del bucle mientras y, al igual que éste, puede iterar cero o
más veces. Sin embargo, el bucle para solamente se suele usar cuando se conoce el número
exacto de veces que tiene que iterar el bucle. Este es el caso cuando se quiere mostrar por
pantalla los primeros diez números naturales (del 1 al 10), donde se sabe de antemano que el
bucle tiene que iterar, exactamente, diez veces.
EJEMPLO Por tanto, el algoritmo Numeros_del_1_al_10 se puede resolver con una
instrucción repetitiva para de la siguiente forma:
algoritmo Numeros_del_1_al_10
variables
entero contador
inicio
para contador  1 hasta 10 incremento 1 hacer
escribir( contador )
fin_para
fin

-- 130 of 180 --

Libro de Algoritmos de “Abrirllave.com” 131 / 180
EJEMPLO Cuando el incremento es 1, se puede omitir la palabra reservada incremento, y
su valor:
algoritmo Numeros_del_1_al_10
variables
entero contador
inicio
/* Al no aparecer el valor del incremento,
se entiende que es 1. */
para contador  1 hasta 10 hacer
escribir( contador )
fin_para
fin
La traza de ambos algoritmos es la misma:

-- 131 of 180 --

Libro de Algoritmos de “Abrirllave.com” 132 / 180
Explicación de la traza:
 Primeramente, se le asigna el valor 1 a contador (acción 1).
 A continuación, se comprueba si contador es menor o igual que 10 (acción 2) y,
puesto que esto es verdadero, se ejecuta el bloque de instrucciones del bucle para
(una sola instrucción en este caso).
 Así pues, se muestra por pantalla el valor de contador (acción 3).
 Después, se incrementa en 1 el valor de la variable contador (acción 4).
 Posteriormente, se vuelve a comprobar si contador es menor o igual que 10 (acción
5).
 Y así sucesivamente, mientras que, el valor de contador sea menor o igual que 10, o
dicho de otro modo, hasta que, el valor de contador sea mayor que 10.
 En este algoritmo, el bloque de instrucciones del bucle para se ejecuta diez veces
(iteraciones).
EJEMPLO Primeros diez números naturales (del 10 al 1).
Utilizando un bucle para, se quiere diseñar el algoritmo de un programa que muestre por
pantalla los primeros diez números naturales, pero a la inversa, es decir, del 10 al 1:
Para ello, debe utilizarse un incremento negativo:

-- 132 of 180 --

Libro de Algoritmos de “Abrirllave.com” 133 / 180
algoritmo Numeros_del_10_al_1
variables
entero contador
inicio
para contador  10 hasta 1 incremento -1 hacer
escribir( contador )
fin_para
fin
En este algoritmo, el <valor_inicial> y el <valor_final> son el 10 y el 1,
respectivamente, al revés que en el algoritmo anterior. De manera que, el bucle iterará, hasta
que, el valor de contador sea menor que 1, o dicho de otro modo, mientras que, el valor de
contador sea mayor o igual que 1.
EJEMPLO Por otra parte, también es posible omitir la palabra reservada incremento y su
valor, entendiéndose, en ese caso, que es -1, ya que, el <valor_inicial> es mayor que el
<valor_final> y, por tanto, solamente es razonable un incremento negativo.
algoritmo Numeros_del_10_al_1
variables
entero contador
inicio
/* Al no aparecer el valor del incremento,
se entiende que es -1. */
para contador  10 hasta 1 hacer
escribir( contador )
fin_para
fin
Para los casos en que el incremento es negativo, también se puede utilizar la sintaxis:
para <variable>  <valor_inicial> hasta <valor_final>
[ decremento <valor_decremento> ] hacer
<bloque_de_instrucciones>
fin_para
/* En vez de "incremento", se utiliza "decremento". */

-- 133 of 180 --

Libro de Algoritmos de “Abrirllave.com” 134 / 180
EJEMPLO Primeros diez números naturales (del 10 al 1) utilizando un bucle para y la
palabra reservada decremento.
algoritmo Numeros_del_10_al_1
variables
entero contador
inicio
para contador  10 hasta 1 decremento 1 hacer
escribir( contador )
fin_para
fin
Por consiguiente, la sintaxis completa de una instrucción repetitiva para es:
para <variable>  <valor_inicial> hasta <valor_final>
[ incremento <valor_incremento> |
decremento <valor_decremento> ] hacer
<bloque_de_instrucciones>
fin_para
El carácter tubería (|) se utiliza para indicar que, o bien se escribe:
incremento <valor_incremento>
O bien se escribe:
decremento <valor_incremento>
Pero, no ambos.
Es muy poco probable que, por equivocación, un programador diseñe un bucle infinito con una
instrucción repetitiva para. Aun así, siempre cabe la posi
