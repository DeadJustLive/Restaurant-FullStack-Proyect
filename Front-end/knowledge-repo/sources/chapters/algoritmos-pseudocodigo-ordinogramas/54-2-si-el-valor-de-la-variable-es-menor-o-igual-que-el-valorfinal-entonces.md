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
instrucción repetitiva para. Aun así, siempre cabe la posibilidad de que esto suceda.
EJEMPLO En el siguiente algoritmo hay un bucle infinito.
algoritmo Numeros_del_1_al_10
variables
entero contador
inicio
para contador  1 hasta 10 incremento -1 hacer
escribir( contador )
fin_para
fin
En pantalla, se mostrará:

-- 134 of 180 --

Libro de Algoritmos de “Abrirllave.com” 135 / 180
Dentro del bloque de instrucciones de un bucle para, no es recomendable cambiar el valor de
la variable utilizada para controlar el número de iteraciones. Hacer esto, puede llevar a que el
bucle no funcione de la manera esperada, produciendo errores inesperados.
EJEMPLO En el siguiente algoritmo, al cambiar el valor de contador dentro del bloque de
instrucciones, se ha producido un bucle infinito.
algoritmo Numeros_del_1_al_10
variables
entero contador
inicio
para contador  1 hasta 10 hacer
escribir( contador )
contador  contador - 1
fin_para
fin
En pantalla se mostrará:
Han aparecido cinco nuevas palabras reservadas: para, hasta, incremento,
decremento y fin_para.
También ha vuelto a aparecer la palabra reservada hacer.
En un ordinograma, una instrucción repetitiva para se puede representar del siguiente modo:

-- 135 of 180 --

Libro de Algoritmos de “Abrirllave.com” 136 / 180
De forma que, por ejemplo, el algoritmo Numeros_del_1_al_10 se puede representar,
gráficamente, de la siguiente forma:
10.5. Cuándo usar un bucle u otro
A la hora de elegir un bucle u otro, debemos hacernos la siguiente pregunta:
 ¿Se conoce, de antemano, el número de veces (iteraciones) que tiene que ejecutarse
un determinado bloque de instrucciones?
Si la respuesta es afirmativa, habitualmente se usa un bucle para. En caso contrario, nos
plantearemos la siguiente pregunta:
 ¿El bloque de instrucciones debe ejecutarse al menos una vez?
En este caso, si la respuesta es afirmativa, generalmente haremos uso de un bucle
hacer...mientras, y si la respuesta es negativa, usaremos un bucle mientras.
Ejercicios resueltos
 Ejercicios de la instrucción repetitiva para
10.6. Anidamiento de alternativas y repetitivas
Al igual que las instrucciones alternativas, las instrucciones repetitivas también se pueden
anidar, permitiendo las siguientes combinaciones de anidamiento:
 mientras en mientras.
 mientras en hacer...mientras.
 mientras en para.

-- 136 of 180 --

Libro de Algoritmos de “Abrirllave.com” 137 / 180
 hacer...mientras en hacer...mientras.
 hacer...mientras en para.
 hacer...mientras en mientras.
 para en para.
 para en mientras.
 para en hacer...mientras.
De ellas, vamos a estudiar, como ejemplo, las combinaciones:
 para en para.
 para en hacer...mientras.
Para comprender la utilidad del anidamiento de bucles, estúdiese el problema del ejemplo
siguiente.
EJEMPLO Tablas de multiplicar del 1, 2 y 3.
Se quiere diseñar el algoritmo de un programa que muestre por pantalla las tablas de
multiplicar del 1, 2 y 3:
Una solución al problema es:

-- 137 of 180 --

Libro de Algoritmos de “Abrirllave.com” 138 / 180
algoritmo Tablas_de_multiplicar_del_1_2_y_3
variables
entero i
inicio
/* Tabla de multiplicar del 1 */
para i  1 hasta 10 hacer
escribir( "1 * ", i, " = ", i )
fin_para
/* Tabla de multiplicar del 2 */
para i  1 hasta 10 hacer
escribir( "2 * ", i, " = ", i * 2 )
fin_para
/* Tabla de multiplicar del 3 */
para i  1 hasta 10 hacer
escribir( "3 * ", i, " = ", i * 3 )
fin_para
fin
En el algoritmo, para mostrar las tres tablas de multiplicar, se han escrito tres bucles para. Sin
embargo, haciendo uso del anidamiento, se puede reducir el código del algoritmo.
10.6.1. Bucle para en para
En pseudocódigo, para anidar una instrucción repetitiva para en otra, se utiliza la sintaxis:
para <variable_1>  <valor_inicial_1> hasta
<valor_final_1> [ incremento <valor_incremento_1> |
decremento <valor_decremento_1> ] hacer
/* Inicio del anidamiento */
para <variable_2>  <valor_inicial_2> hasta
<valor_final_2> [ incremento <valor_incremento_2> |
decremento <valor_decremento_2> ] hacer
<bloque_de_instrucciones>
fin_para
/* Fin del anidamiento */
fin_para
Cuando un bucle se anida dentro de otro, el número de iteraciones del <bloque_de_
instrucciones> se multiplica. En el algoritmo Tablas_de_multiplicar_del_1_2_
y_3, se han escrito tres bucles para, iterando cada uno de ellos 10 veces, haciendo un total
de 30 iteraciones (3*10). Pues bien, anidando un bucle dentro de otro, se puede realizar el

-- 138 of 180 --

Libro de Algoritmos de “Abrirllave.com” 139 / 180
mismo número de iteraciones, reduciendo el código del algoritmo (solamente se van a
necesitar dos bucles, en vez de tres).
Si se pretendiese mostrar por pantalla, por ejemplo, las tablas de multiplicar del 1 al 10,
todavía sería mayor la reducción del código del algoritmo. En ese caso, en vez de escribir diez
bucles, iterando cada uno de ellos otras 10 veces, haciendo un total de 100 iteraciones
(10*10), sería mejor anidar un bucle dentro de otro, reduciéndose considerablemente el
código del algoritmo (solamente se necesitarían dos bucles, en vez de diez).
EJEMPLO Así pues, anidando un bucle para en otro, se pueden mostrar por pantalla las
tablas de multiplicar del 1, 2 y 3:
algoritmo Tablas_de_multiplicar_del_1_2_y_3
variables
entero i, j, r
inicio
para i  1 hasta 3 hacer /* Bucle 1 */
/* Inicio del anidamiento */
para j  1 hasta 10 hacer /* Bucle 2(anidado) */
r  i * j
escribir( i, " * ", j, " = ", r )
fin_para
/* Fin del anidamiento */
fin_para
fin
10.6.2. Bucle para en hacer...mientras
En pseudocódigo, para anidar un bucle para en un bucle hacer...mientras, se utiliza la
sintaxis:
hacer
/* Inicio del anidamiento */
para <variable>  <valor_inicial> hasta <valor_final>
[ incremento <valor_incremento> |
decremento <valor_decremento> ] hacer
<bloque_de_instrucciones>
fin_para
/* Fin del anidamiento */
mientras ( <expresión_lógica> )

-- 139 of 180 --

Libro de Algoritmos de “Abrirllave.com” 140 / 180
EJEMPLO Tabla de multiplicar de un número.
Se quiere diseñar el algoritmo de un programa que muestre por pantalla la tabla de multiplicar
de un número entero introducido por el usuario. El proceso debe repetirse mientras que el
usuario lo desee:
Algoritmo propuesto:

-- 140 of 180 --

Libro de Algoritmos de “Abrirllave.com” 141 / 180
algoritmo Tabla_de_multiplicar_de_un_numero
variables
caracter seguir
entero i, numero
inicio
hacer
escribir( "Introduzca un número entero: " )
leer( numero )
escribir( "La tabla de multiplicar del ", numero , " es: " )
/* Inicio del anidamiento */
para i  1 hasta 10 hacer
escribir( numero, " * ", i, " = ", i * numero )
fin_para
/* Fin del anidamiento */
escribir( "¿Desea ver otra tabla (s/n)?: " )
leer( seguir )
mientras ( seguir <> 'n' )
fin
Las instrucciones alternativas y repetitivas también se pueden anidar entre sí, permitiendo
realizar 18 combinaciones más de anidamiento:
 mientras en doble.
 mientras en simple.
 mientras en múltiple.
 hacer...mientras en doble.
 hacer...mientras en simple.
 hacer...mientras en múltiple.
 para en doble.
 para en simple.
 para en múltiple.
 Doble en mientras.
 Doble en hacer...mientras.
 Doble en para.
 Simple en mientras.
 Simple en hacer...mientras.
 Simple en para.
 Múltiple en mientras.
 Múltiple en hacer...mientras.
 Múltiple en para.
De ellas, vamos a estudiar, como ejemplo, las combinaciones:
 Simple en para.
 Múltiple en hacer...mientras.

-- 141 of 180 --

Libro de Algoritmos de “Abrirllave.com” 142 / 180
10.6.3. Alternativa simple en bucle para
En pseudocódigo, para anidar una alternativa simple en un bucle para, se utiliza la sintaxis:
para <variable>  <valor_inicial> hasta <valor_final>
[ incremento <valor_incremento> |
decremento <valor_decremento> ] hacer
/* Inicio del anidamiento */
si ( <expresión_lógica> )
<bloque_de_instrucciones>
fin_si
/* Fin del anidamiento */
fin_para
EJEMPLO Números enteros divisibles entre 17 ó 21.
Se quiere diseñar el algoritmo de un programa que muestre por pantalla todos los números
enteros del 1 al 100 (ambos inclusive) que sean divisibles entre 17 ó 21:
Anidando una alternativa simple en un bucle para, el problema se puede resolver con el
algoritmo:
algoritmo Numeros_enteros_divisibles_entre_17_o_21
variables
entero numero
inicio
para numero  1 hasta 100 hacer
/* Inicio del anidamiento */
si ( numero mod 17 = 0 o numero mod 21 = 0 )
escribir( numero )
fin_si
/* Fin del anidamiento */
fin_para
fin

-- 142 of 180 --

Libro de Algoritmos de “Abrirllave.com” 143 / 180
10.6.4. Alternativa múltiple en bucle hacer...mientras
Anidar una alternativa múltiple en un bucle hacer...mientras, es la solución idónea
cuando se quiere realizar un menú. Un menú ofrece al usuario la posibilidad de elegir qué
acción(es) realizar de entre una lista de opciones.
EJEMPLO Menú de opciones.
Se quiere diseñar el algoritmo de un programa que:
1º) Muestre un menú con 4 opciones:
 1. Calcular el doble de un número entero.
 2. Calcular la mitad de un número entero.
 3. Calcular el cuadrado de un número entero.
 4. Salir.
2º) Pida por teclado la opción deseada (dato entero).
3º) Ejecute la opción del menú seleccionada.
4º) Repita los pasos 1º, 2º y 3º, mientras que, el usuario no seleccione la opción 4 (Salir) del
menú.
En pantalla:

-- 143 of 180 --

Libro de Algoritmos de “Abrirllave.com” 144 / 180
El algoritmo propuesto es:
algoritmo Menu_de_opciones
variables
entero numero, opcion
inicio
hacer
escribir( "1. Calcular el doble de un número entero." )
escribir( "2. Calcular la mitad de un número entero." )
escribir( "3. Calcular el cuadrado de un número entero." )
escribir( "4. Salir." )
escribir( "Introduzca opción: " )
leer( opcion )
/* Inicio del anidamiento */
segun_sea ( opcion )
1 : escribir( "Introduzca un número entero:" )
leer( numero )
escribir( "El doble de ", numero, " es ",
numero * 2 )
2 : escribir( "Introduzca un número entero:" )
leer( numero )
escribir( "La mitad de ", numero, " es ",
numero / 2 )
3 : escribir( "Introduzca un número entero:" )
leer( numero )
escribir( "El cuadrado de ", numero, " es ",
numero * numero )
fin_segun_sea
/* Fin del anidamiento */
mientras ( opcion <> 4 )
fin
En la solución propuesta, el bucle iterará, mientras que, opcion sea distinto del valor 4.
Normalmente, en un menú, la opción de salir –opción 4 en este caso– no se debe contemplar
en la alternativa múltiple, es decir, si el usuario introduce un 4, no se debe hacer nada.
Pero, ¿qué ocurre si el usuario teclea un número mayor que 4 ó menor que 1?
En pantalla:

-- 144 of 180 --

Libro de Algoritmos de “Abrirllave.com” 145 / 180
Al introducir un número menor que 1 ó mayor que 4, se muestra de nuevo el menú. Para
evitar que ocurra esto, es conveniente utilizar un filtro al leer la opción que introduce el
usuario.
Dicho filtro puede ser el siguiente:
/* Filtramos la opción elegida por el usuario */
hacer
escribir( "Introduzca opción: " )
leer( opcion )
mientras( opcion < 1 o opcion > 4 )
/* La opción solamente puede ser 1, 2, 3 ó 4 */
De modo que el código del algoritmo sería:

-- 145 of 180 --

Libro de Algoritmos de “Abrirllave.com” 146 / 180
algoritmo Menu_de_opciones
variables
entero numero, opcion
inicio
hacer
escribir( "1. Calcular el doble de un número entero." )
escribir( "2. Calcular la mitad de un número entero." )
escribir( "3. Calcular el cuadrado de un número entero." )
escribir( "4. Salir." )
/* Filtramos la opción elegida por el usuario */
hacer
escribir( "Introduzca opción: " )
leer( opcion )
mientras( opcion < 1 o opcion > 4 )
/* La opción solamente puede ser 1, 2, 3 ó 4 */
/* Inicio del anidamiento */
segun_sea ( opcion )
1 : escribir( "Introduzca un número entero:" )
leer( numero )
escribir( "El doble de ", numero, " es ",
numero * 2 )
2 : escribir( "Introduzca un número entero:" )
leer( numero )
escribir( "La mitad de ", numero, " es ",
numero / 2 )
3 : escribir( "Introduzca un número entero:" )
leer( numero )
escribir( "El cuadrado de ", numero, " es ",
numero * numero )
fin_segun_sea
/* Fin del anidamiento */
mientras ( opcion <> 4 )
fin
La variable opcion, también puede ser un dato de tipo carácter, en vez de tipo entero:

-- 146 of 180 --

Libro de Algoritmos de “Abrirllave.com” 147 / 180
algoritmo Menu_de_opciones
variables
caracter opcion
entero numero
inicio
hacer
escribir( "1. Calcular el doble de un número entero." )
escribir( "2. Calcular la mitad de un número entero." )
escribir( "3. Calcular el cuadrado de un número entero." )
escribir( "4. Salir." )
/* Filtramos la opción elegida por el usuario */
hacer
escribir( "Introduzca opción: " )
leer( opcion )
mientras( opcion < 1 o opcion > 4 )
/* La opción solamente puede ser 1, 2, 3 ó 4 */
/* Inicio del anidamiento */
segun_sea ( opcion )
'1' : escribir( "Introduzca un número entero:" )
leer( numero )
escribir( "El doble de ", numero, " es ",
numero * 2 )
'2' : escribir( "Introduzca un número entero:" )
leer( numero )
escribir( "La mitad de ", numero, " es ",
numero / 2 )
'3' : escribir( "Introduzca un número entero:" )
leer( numero )
escribir( "El cuadrado de ", numero, " es ",
numero * numero )
fin_segun_sea
/* Fin del anidamiento */
mientras ( opcion <> 4 )
fin
Ejercicios resueltos
 Ejercicios de instrucciones repetitivas

-- 147 of 180 --

Libro de Algoritmos de “Abrirllave.com” 148 / 180