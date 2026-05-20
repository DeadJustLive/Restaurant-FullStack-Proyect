# Z Y X W V U T S R Q P O N M L K J I H G F E D C B A

## Fuente
logica-de-programacion (Cap. 94)

## Contenido
# Z Y X W V U T S R Q P O N M L K J I H G F E D C B A

An´alisis del problema:
Resultados esperados: imprimir las letras del alfabeto, conforme
a lo solicitado en el enunciado.
Datos disponibles: no se requiere de ninguna entrada de datos.
Proceso: se requiere imprimir el alfabeto en orden descendente, de la
Z a la A. La primera fila est´a conformada ´unicamente por la letra Z,
la segunda por las letras Z y Y, en la tercera se encuentran las letras
Z Y y X; de acuerdo al patr´on que se observa, en cada nueva fila se
imprime una letra m´as. La impresi´on termina cuando se complete
todo el alfabeto.
Este proceso requiere de dos ciclos anidados. El interno imprimir´a
las letras de cada fila, mientras el externo permitir´a el avance de las
filas.

-- 287 of 450 --

286 Estructuras de repetici ´on
De acuerdo al proceso explicado, ambos ciclos deber´an estar
dise˜nados para trabajar con decrementos, iniciando en la letra ’Z’
y descendiendo hasta la letra ’A’.
Variables requeridas:
• letraFila: controla el ciclo externo. Con esta variable se
podr´a tener control para el avance de las filas.
• letra: variable de control del ciclo interno. Almacenar´a las
letras que se van imprimiendo en cada fila.
De acuerdo al an´alisis planteado, se propone el Algoritmo 4.36.
Algoritmo 4.36: Alfabeto
1 Algoritmo Alfabeto
2 // Declaraci´on de variables
3 Caracter letraFila, letra
4
5 // Generaci´on del alfabeto
6 Para letraFila = ’Z’ Hasta ’A’ Decremento 1
7 Para letra = ’Z’ Hasta letraFila Decremento 1
8 imprimir( " ", letra )
9 FinPara
10 // Salto de l´ınea
11 FinPara
12 FinAlgoritmo
Explicaci´on del algoritmo:
Al igual que el algoritmo anterior, en este, tampoco hay datos de entrada.
Con base al an´alisis realizado para la soluci´on del problema, se
escribieron dos ciclos Para anidados.
El primer ciclo presenta la siguiente instrucci´on:
6 Para letraFila = ’Z’ Hasta ’A’ Decremento 1
Antes de entrar en detalle de su modo de operar, es importante dar
claridad y aprender a distinguir entre las siguientes expresiones, que son
comunes dentro de los algoritmos:
1. letraFila = Z
2. letraFila = ’Z’
En la expresi´on n´umero 1, se est´a trabajando con dos variables que
deben estar declaradas. En la variable letraFila se almacena el valor
de la variable Z.

-- 288 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 287
En la expresi´on n´umero 2, se trata de una variable y un dato, en este
caso solamente la variable letraFila debe estar declarada. El car´acter
o letra ’Z’ se almacena en la variable letraFila.
En el caso de este ejemplo, la expresi´on 2 es la que se codific´o en los dos
ciclos Para.
6 Para letraFila = ’Z’ Hasta ’A’ Decremento 1
7 Para letra = ’Z’ Hasta letraFila Decremento 1
8 imprimir( " ", letra )
9 FinPara
10 // Salto de l´ınea
11 FinPara
El ciclo externo inicializa la variable letraFila con la letra ’Z’ y en
cada iteraci´on va decrementando en una letra hasta llegar a la ’A’. Cada que
entra al cuerpo del ciclo ejecuta el Para interno, este inicializa su variable
de control en ’Z’ (letra = ’Z’) y en cada iteraci´on la decrementa hasta
alcanzar el valor de letraFila. Cada que se ejecuta el ciclo interno, se
imprime el valor de la variable letra; en la primera iteraci´on imprime la
letra ’Z’, luego de que este ciclo termina su ejecuci´on debe producirse un
salto de l´ınea, es decir, se pasa al siguiente rengl´on para volver a iniciar la
impresi´on.
En este ejemplo el salto de l´ınea se hizo a manera de comentario:
10 // Salto de l´ınea
Aclaraci´on:
Cada uno de los lenguajes que Usted aprender´a
tendr´an su propia instrucci´on para ejecutar el salto
de l´ınea, como por ejemplo, el car´acter especiala ’\n’
suele emplearse para este fin.
aSe denomina especial por ser una secuencia de escape y se identifica debido
al uso de la barra invertida (\) antes de una letra. Diversas letras tienen usos
diferentes.
Cuando se regresa a la instrucci´on Para del ciclo externo, letraFila
se decrementa y su valor ya no es ’Z’, sino ’Y’, su condici´on sigue siendo
verdadera, a´un no se ha alcanzado el valor de ’A’. Se vuelve a ejecutar el
ciclo interno y esta vez se imprime la ’Z’ y luego la letra ’Y’ en el mismo
rengl´on, esta vez el ciclo se ejecuta dos veces. Luego se produce el salto de
l´ınea.

-- 289 of 450 --

288 Estructuras de repetici ´on
Para la tercera evaluaci´on de la condici´on del ciclo externo, la variable
letraFila ha decrementado su valor a ’X’, dando a´un un resultado
verdadero. Nuevamente se ejecuta el ciclo interno, esta vez debe hacer
3 iteraciones, en la primera imprime la letra ’Z’, en la segunda la letra ’Y’
y en la tercera la letra ’X’, todas sobre un mismo rengl´on. Seguidamente,
una vez m´as se produce el cambio de l´ınea.
En este momento se debe estar visualizando la siguiente impresi´on:
Z
Z Y
Z Y X
Este proceso contin´ua mientras la variable letraFila, del ciclo
externo, no alcance el valor de la letra A y no se haya impreso todo el
alfabeto por parte del ciclo interno.
En la Figura 4.34 se muestra la so
