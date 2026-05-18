# Parte d: e las estructuras Haga-MientrasQue se destinaron a la

validaci´on de la entrada de los datos. Los de tipo num´erico est´an validados
para que acepten valores entre -200000 y 200000, este tope se eligi´o m´as
por mostrar el ejemplo de c´omo validar un dato num´erico que, por alg´un
requerimiento en el enunciado del problema; el dise˜nador del algoritmo
puede tomar los valores que estime conveniente. El ciclo dedicado a la
validaci´on de la lectura del operador matem´atico condiciona a que solo
pueda ingresar uno de los siguientes caracteres: ’+’,’-’ ,’*’ y ’/’ o el signo
’=’.
La variable calculo que almacena el resultado de todas las operaciones
que se realicen, se inicializ´o con el valor de la variable numero, el cual
corresponde al primer n´umero que se obtendr´a para iniciar el proceso de la
calculadora. De igual forma se hace la inicializaci´on de la variable bandera
con un valor Verdadero, el cual cambiar´a en el caso que se trate de hacer
una divisi´on entre 0.
Seguidamente se encuentra el ciclo Haga, donde las primeras
instrucciones que ejecuta son solicitar y leer un operador con el fin de
determinar qu´e proceso se hace con el valor almacenado en la variable
calculo. Si ingresan un signo ’=’ se termina el proceso y se informa el
resultado. Si por el contrario ingresan uno de los operadores b´asicos, se
procede a solicitar el segundo n´umero; si el operador corresponde a uno de
los siguientes ’+’, ’-’ o ’*’ se realiza la respectiva operaci´on, en el caso que
el operador sea ’/’ se toma una decisi´on.

-- 263 of 450 --

262 Estructuras de repetici ´on
42 Caso ’/’: Si( numero == 0 ) Entonces
43 imprimir( "Error. Divisi´on entre cero" )
44 bandera = Falso // Cambio de estado
45 SiNo
46 calculo = calculo / numero
47 FinSi
48 FinCaso
Esta decisi´on es parte de una estructura Segun-FinSegun y
corresponde al caso ’/’. Cuando se ingresa el operador de divisi´on se verifica
el valor del n´umero con el prop´osito de informar la situaci´on de divisi´on
entre 0.
Observe que cuando el n´umero es 0, se imprime un mensaje informando
la situaci´on (l´ınea 43). A bandera se le cambia el estado de Verdadero
a Falso, con el fin de omitir la instrucci´on que imprime el resultado (l´ınea
53). Finalmente a la variable operador se le asigna el signo ’=’; de esta
manera cuando se eval´ue la condici´on MientrasQue (operador !=
’=’) el resultado ser´a Falso y se dar´a por terminada la ejecuci´on del
ciclo y en consecuencia la del algoritmo.
Contrario a todo lo expuesto en el p´arrafo anterior, si el n´umero es
diferente de 0, se realiza la divisi´on, se informa el contenido de la variable
calculo (l´ınea 53) y se testea la condici´on del MientrasQue; al obtener
un resultado Verdadero se repite el ciclo Haga-MientrasQue.
La variable operador, tiene la particularidad, que adem´as de
determinar qu´e tipo de operaci´on se realiza con los n´umeros
ingresados, est´a haciendo el papel del centinela que controla el ciclo
Haga-MientrasQue.
.:Ejemplo 4.15. En matem´aticas un n´umero es perfecto si es igual a la
suma de sus divisores propios positivos. Un ejemplo de n´umero perfecto es
el 28 dado que: 1 + 2 + 4 + 7 + 14 = 28.
Construya un algoritmo que acepte como dato de entrada un n´umero
entero positivo e informe se es o no un n´umero perfecto. El algoritmo debe
ejecutarse hasta que el usuario determine lo contrario.
An´alisis del problema:
Resultados esperados: un mensaje que informe si el n´umero
ingresado al algoritmo es o no perfecto.
Datos disponibles: un n´umero entero positivo.

-- 264 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 263
Proceso: teniendo en cuenta que el enunciado condiciona a que el
n´umero sea positivo, la lectura del dato debe hacerse de tal forma
que solo acepte valores mayores o iguales a 1.
Una vez se posea el n´umero, debe hacerse un proceso repetitivo que
determine si cada uno de los n´umeros menores a ´el es su divisor.
Recuerde que se puede determinar si un n´umero es divisor de otro, si
al dividir el mayor entre el menor se obtiene una divisi´on exacta, es
decir cuando el residuo es 0. En el caso de los algoritmos, un residuo
o resto de la divisi´on se logra usando el operador m´odulo: ’ %’. En
tal sentido, la siguiente decisi´on determina si un n´umero es divisor
de otro:
¿numero1 % numero2 == 0?
numero2 es divisor de numero1
s´ı
numero2 no es divisor de numero1
no
Figura 4.29: ´	Arbol de decisi´on del Ejemplo 4.15
Para el problema, objeto de este an´alisis, si la decisi´on es verdadera se
proceder´a a incrementar un acumulador donde se sumar´an todos los
n´umeros menores que sean divisores del n´umero ingresado. Una vez
terminada la ejecuci´on del proceso c´ıclico, se decidir´a si la sumatoria
es igual al n´umero, en cuyo caso se informar´a que si es un n´umero
perfecto, o que no lo es en caso contrario. De acuerdo a la definici´on
de n´umero perfecto, el 1 no lo es, ya que no tiene divisores propios
(menores a ´el).
Todo este proceso debe estar anidado dentro de otro ciclo, que
permita ejecutarse hasta que el usuario no desee ingresar m´as
n´umeros.
Variables requeridas:
• numero: almacena el dato que ingresar´a al algoritmo.
• numeroMenor: en esta variable se generar´an todos los n´umeros
menores al n´umero ingresado, con el fin de comprobar si son sus
divisores.
• sumaDivisores: acumulador de la suma de los divisores del
n´umero ingresado.
• seguir: almacenar´a la respuesta si desea o no continuar con
la ejecuci´on del algoritmo.

-- 265 of 450 --

264 Estructuras de repetici ´on
De acuerdo al an´alisis planteado, se propone el Algoritmo 4.27.
Algoritmo 4.27: Perfecto
1 Algoritmo Perfecto
2 // Declaraci´on de variables
3 Entero numero, numeroMenor, sumaDivisores
4 Caracter seguir
5
6 // Inicializaci´on centinela ciclo externo
7 seguir = ’S’
8
9 // Inicia ciclo externo
10 Mientras( seguir == ’S’ O seguir == ’s’ )
11 // Dato disponible
12 imprimir ("Ingrese un n´umero entero positivo: ")
13 Haga
14 leer( numero )
15 MientrasQue( numero < 1 ) // Valida - solo positivos
16
17 // Inicializaci´on variables ciclo interno
18 sumaDivisores = 0
19 numeroMenor = 1 // divisor de una operaci´on
20
21 // Inicia ciclo interno
22 Haga
23 Si( numero % numeroMenor == 0 ) Entonces
24 sumaDivisores = sumaDivisores + numeroMenor
25 FinSi
26 numeroMenor = numeroMenor + 1
27 MientrasQue( numeroMenor < numero )
28
29 // Resultados esperados
30 Si( sumaDivisores == numero Y numero != 1 ) Entonces
31 imprimir( numero, "es un n´umero perfecto." )
32 SiNo
33 imprimir( numero, " no es un n´umero perfecto." )
34 FinSi
35
36 imprimir( "Desea continuar [S] [N]?: " )
37 Haga
38 leer( seguir )
39 MientrasQue( seguir != ’S’ Y seguir != ’N’ Y
40 seguir != ’s’ Y seguir != ’n’ )
41 FinMientras
42 FinAlgoritmo

-- 266 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 265
Al ejecutar el algoritmo:
Primera ejecuci´on:
Ingrese un n´umero entero positivo: 496
496 es un n´umero perfecto.
Desea continuar [S] [N]?: S
Segunda ejecuci´on:
Ingrese un n´umero entero positivo: 57
57 no es un n´umero perfecto.
Desea continuar [S] [N]?: N
Explicaci´on del algoritmo:
El algoritmo tiene ciclos anidados. Para el ciclo externo se us´o
un Mientras-FinMientras, dentro de ´el se anidaron 3 ciclos
Haga-MientrasQue, adicionalmente se plantearon dos estructuras de
decisi´on. El primer Haga-MientrasQue (l´ıneas 13 a 15) controla que el
n´umero ingresado sea positivo. El segundo (l´ıneas 22 a 27) tiene la funci´on
de generar todos los n´umeros menores al n´umero dado y de acumular la
suma de sus divisores propios.
Observe que la decisi´on planteada dentro de este segundo ciclo, no posee
parte falsa:
23 Si( numero % numeroMenor == 0 ) Entonces
24 sumaDivisores = sumaDivisores + numeroMenor
25 FinSi
Adem´as, su expresi´on relacional est´a indicada mediante una
operaci´on matem´atica y una comparaci´on de igualdad. La operaci´on
matem´atica(numero % numeroMenor) calcula el resto de la divisi´on
entre el n´umero y cada uno de los n´umeros menores a ´el; este resultado se
compara con el valor 0. Si el resultado de dicha comparaci´on es verdadero,
indica que es una divisi´on exacta, lo cual concluye que el n´umero menor
es un divisor del n´umero analizado, por lo tanto, se procede a acumular su
valor en la variable sumaDivisores.
Los siguientes pasos son: ejecutar el incremento de la
variable numeroMenor (l´ınea 26); evaluar la condici´on MientrasQue
(numeroMenor < numero), para determinar si se ejecuta otra vez o se
termina este ciclo Haga-MientrasQue.
Una vez este ciclo termine de iterar, se eval´ua la siguiente decisi´on para
determinar si el n´umero es perfecto o no:

-- 267 of 450 --

266 Estructuras de repetici ´on
30 Si( sumaDivisores == numero Y numero != 1 ) Entonces
La expresi´on relacional del tercer ciclo Haga-MientrasQue (l´ıneas 37
a 39), valida que la variable seguir, reciba como dato de entrada uno de
los siguientes caracteres: ’S’, ’N’, ’s’ o ’n’.
Despu´es de esta condici´on, se encuentra el FinMientras que regresa
el control del algoritmo al Mientras (l´ınea 10), donde se eval´ua su
condici´on. Si es verdadera, se vuelve a repetir todo su cuerpo, de lo
contrario se termina el ciclo; a continuaci´on, se pone fin al algoritmo para
que termine su ejecuci´on.
4.3.1 Prueba de escritorio
Para terminar con el tema de la instrucci´on repetitiva Haga-
MientrasQue, se har´a la prueba de escritorio o tabla de verificaci´on para
los siguientes dos algoritmos:
.:Ejemplo 4.16. Para el Algoritmo 4.28 que halla la divisi´on entera
(cociente y resto), de 38 entre 6, mediante restas sucesivas, realice la
respectiva prueba de escritorio.
Algoritmo 4.28: Division
1 Algoritmo Division
2 // Declaraci´on de variables
3 Entero dividendo, divisor, cociente, resto
4
5 // Inicializaci´on de variables
6 dividendo = 38
7 divisor = 6
8 cociente = 0
9
10 // Proceso de la divisi´on mediante restas sucesivas
11 Haga
12 dividendo = dividendo - divisor
13 cociente = cociente + 1
14 MientrasQue( dividendo >= divisor )
15
16 resto = dividendo
17
18 // Informe de resultados
19 imprimir( "El cociente es: ", cociente )
20 imprimir( "El resto es: ", resto )
21 FinAlgoritmo

-- 268 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 267
La tabla de verificaci´on o prueba de escritorio para el Ejemplo 4.16 se
puede observar en la Tabla 4.8.
divisor = 6
dividendo cociente dividendo>= divisor
38 0
32 1 32 >= 6 (Verdadero)
26 2 26 >= 6 (Verdadero)
20 3 20 >= 6 (Verdadero)
14 4 14 >= 6 (Verdadero)
8 5 8 >= 6 (Verdadero)
2 6 2 >= 6 (Falso)
cociente = 6
resto = 2
Tabla 4.8: Prueba de escritorio - Algoritmo 4.16
Las dos primeras columnas de la tabla se destinaron para almacenar
los valores de las variables dividendo y cociente, los cuales se van
actualizando en cada iteraci´on hasta llegar al valor esperado; en la tercera
columna se eval´ua la condici´on del Haga-MientrasQue.
Se inicializan las variables dividendo, divisor y cociente, en 38,
6 y 0 respectivamente. Estos valores se registran en la tabla de verificaci´on.
Al continuar con la ejecuci´on del algoritmo se encuentra la instrucci´on
Haga, que indica el inicio de una estructura repetitiva. La primera
instrucci´on de este ciclo reduce la variable dividendo en 6, que es
el valor del divisor en este ejemplo (dividendo = dividendo -
divisor); la segunda instrucci´on aumenta en 1 el valor del cociente,
su prop´osito es contar el n´umero de restas que se hagan, las cuales equivalen
al cociente de la divisi´on de estos dos n´umeros. Los resultados de ambas
operaciones son anotados en la tabla de verificaci´on.
Seguidamente, se encuentra la condici´on del ciclo, al testearla el
resultado es verdadero, tal como se evidencia en la tabla (32 >= 6
(Verdadero)). El control del algoritmo lo vuelve a asumir la instrucci´on
Haga y una vez m´as se repite el procedimiento anotado en el p´arrafo
anterior.
Los pasos descritos en los dos p´arrafos anteriores, se repiten mientras el
valor almacenado en el dividendo sea mayor o igual al del divisor.
Cuando el dividendo toma el valor de 2 y se vuelve a evaluar la condici´on
del Haga-MientrasQue, se tiene que 2 >= 6 arroja un resultado falso.

-- 269 of 450 --

268 Estructuras de repetici ´on
Como consecuencia de esta evaluaci´on el ciclo deja de ejecutarse y se realiza
la siguiente operaci´on: resto = dividendo, asign´andose el valor de 2
a resto. Observe la tabla en detalle y analice los valores registrados.
Por ´ultimo, se hace la impresi´on de los valores almacenados en
cociente y en resto, para luego finalizar con el algoritmo.
.:Ejemplo 4.17. La Tabla 4.9 corresponde a la prueba de escritorio del
diagrama de flujo de la Figura 4.30. Imprime la tabla de multiplicar del 7
y del 9, cada una desde la fila 1 hasta la fila 5. Analice la explicaci´on que
se da sobre su funcionamiento.
primera = 7
ultima = 9
primera fila producto fila <= 5 primera imprimir
<= ultima primera fila producto
7 1 7 7 1 7
2 2 <= 5 (V)
14 7 2 14
3 3 <= 5 (V)
21 7 3 21
4 4 <= 5 (V)
28 7 4 28
5 5 <= 5 (V)
35 7 5 35
6 6 <= 5 (F)
9 9 <= 9 (V)
1 9 9 1 9
2 2 <= 5 (V)
18 9 2 18
3 3 <= 5 (V)
27 9 3 27
4 4 <= 5 (V)
36 9 4 36
5 5 <= 5 (V)
45 9 5 45
6 6 <= 5 (F)
11 11 <= 9(F)
Tabla 4.9: Prueba de escritorio - Algoritmo 4.17

-- 270 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 269
Inicio
primera = 7
ultima = 9
fila = 1
producto = primera ∗ fila
primera, fila, producto
fila = fila +1
fila <= 5
primera = primera + 2
primera <= ultima
Final
No
No
S´ı
S´ı
Figura 4.30: Tabla de multiplicar del 7 y del 9

-- 271 of 450 --

270 Estructuras de repetici ´on
Explicaci´on de la prueba de escritorio:
En esta prueba de escritorio (Ver Tabla 4.9) se trabaja con dos ciclos
Haga-MientrasQue anidados. El ciclo que tiene la condici´on (fila
<= 5) es el ciclo interno y es el que m´as veces se ejecuta, en la
tabla se registraron 10 evaluaciones a la condici´on, mientras que a la
del ciclo externo (primera <= ultima) solamente se le hicieron dos
evaluaciones. Esto significa, que el ciclo externo itera 2 veces, mientras que
el ciclo interno itera 5 veces por cada iteraci´on del externo.
En la primera iteraci´on del ciclo externo, la variable primera inicia con
un valor de 7; al entrar al cuerpo del ciclo interno, se calcula la tabla de este
n´umero, desde la fila 1 hasta la fila 5 y se van mostrando los resultados,
observe las 3 ´ultimas columnas de la tabla anterior. Una vez la variable
fila llega al valor de 6, la condici´on del ciclo interno se hace falsa y se
procede a incrementar, en dos unidades, el valor de la variable primera,
tomando el valor de 9. El proceso se repite y esta vez se hace el c´alculo
para la tabla del 9, tambi´en desde la fila 1 hasta la fila 5.
Todo este proceso finaliza en el momento que la variable fila toma el
valor de 6 y la variable primera alcanza el valor de 11, con lo cual, al
evaluar las dos condiciones de los ciclos, se obtiene un resultado falso. En
las dos ´ultimas filas de la tabla de verificaci´on se evidencia esa situaci´on.
4.4. Estructura de repetici´on Para-FinPara
Igual que las dos estructuras anteriores, Mientras-FinMientras y
Haga-MientrasQue, esta estructura tambi´en se usa para lograr que una
instrucci´on o un conjunto de ellas se ejecuten repetidas veces.
De manera similar al Mientras-FinMientras, el Para-FinPara
es un ciclo condicionado al inicio, lo cual implica que su ejecuci´on est´a
determinada por la evaluaci´on de su condici´on. Puede suceder que el
cuerpo del ciclo no llegue a ejecutarse cuando al evaluar por primera vez
su condici´on resulte falsa.
Este ciclo es muy ´util cuando se conoce de antemano, el n´umero de
iteraciones que se deben hacer. La cantidad de ejecuciones que realice, no
depender´a de ninguna de las instrucciones del cuerpo del ciclo, es decir, no
habr´a una instrucci´on modificadora de condici´on dentro de ellas.
La forma general de esta estructura de repetici´on es presentada en los
siguientes segmentos de los Algoritmos 4.29 y 4.30.

-- 272 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 271
Algoritmo 4.29: Forma general (incremento) - Para-FinPara
1 Instrucci´on de inicializaci´on
2 Para var = valor1 Hasta valor2 Incremento valor3
3 Instrucci´on-1
4 Instrucci´on-2
5 ... /* Cuerpo del ciclo */
6 Instrucci´on-n
7 FinPara
8 Instrucci´on externa
Algoritmo 4.30: Forma general (decremento)- Para-FinPara
1 Instrucci´on de inicializaci´on
2 Para var = valor1 Hasta valor2 Decremento valor3
3 Instrucci´on-1
4 Instrucci´on-2
5 ... /* Cuerpo del ciclo */
6 Instrucci´on-n
7 FinPara
8 Instrucci´on externa
Las anteriores formas generales se interpretan as´ı:
La Instrucci´on de inicializaci´on se usa para dar un valor inicial a los
contadores o acumuladores que se modificaran dentro del ciclo. En el caso
de no tener este tipo de variables, no es necesario su uso.
Las instrucciones:
Para var = valor1 Hasta valor2 Incremento valor3
Para var = valor1 Hasta valor2 Decremento valor3
se interpretan de la siguiente manera:
var: es una variable declarada de tipo Entero o Caracter. Esta
es la variable de control del ciclo.
valor1: puede ser una constante o una variable, cuyo valor se le
asigna a var.
Hasta: es un c´odigo que indica que var debe ir hasta un valor
determinado. Se interpreta como si se hubiese establecido una de las
siguientes condiciones:
(var <= valor2), cuando se hacen incrementos.
(var >= valor2), cuando se hacen decrementos.

-- 273 of 450 --

272 Estructuras de repetici ´on
valor2: puede ser una constante o una variable, indica el valor hasta
el cual llegar´a var.
Incremento o Decremento: estos c´odigos se˜nalan que var
debe sufrir una modificaci´on, aumentando o disminuyendo su valor,
respectivamente.
valor3: es una variable o constante en cuyo valor se modifica var.
Es importante resaltar que valor1, valor2 y valor3, pueden ser
variables o constantes. Cuando uno o m´as son variables, estas se deben
inicializar antes del c´odigo Para, bien sea, con una expresi´on de asignaci´on
o mediante una instrucci´on leer. Si se trabajan como constantes, no
requieren de inicializaci´on.
La forma de operar del ciclo Para, es la siguiente: var se inicializa
en valor1, seguidamente se hace la evaluaci´on de una de las posibles
condiciones (var <= valor2 o var >= valor2), que est´an impl´ıcitas
con el c´odigo Hasta y valor2. Si el resultado de esta evaluaci´on es
verdadero, se ejecutan las instrucciones del cuerpo del ciclo hasta encontrar
la instrucci´on FinPara que devuelve el control al inicio del ciclo. Al
regresar a la instrucci´on Para, se produce el incremento o decremento
de var, de acuerdo al valor almacenado en valor3; una vez m´as se
eval´ua la condici´on, repiti´endose el proceso si el resultado es verdadero o
ejecut´andose la Instrucci´on externa, en caso contrario. Instrucci´on externa
no hace parte del ciclo.
En estas formas generales no est´an presentes, de forma expl´ıcita, la
Instrucci´on modificadora de condici´on como en los dos ciclos anteriores, su
papel lo desempe˜na el c´odigo Incremento o Decremento acompa˜nado
de valor3.
Aclaraci´on:
Al encontrarse por primera vez un c´odigo Para, se
ejecutan la inicializaci´on de la variable de control
y la evaluaci´on de la condici´on. El incremento o
decremento no se realizan.

-- 274 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 273
Para representar la estructura Para-FinPara con un diagrama de
flujo, se usa la notaci´on presentada en la Figura 4.31.
Inicio
Instrucci´on de Inicializaci´on
valor2
valor1
±valor3
Instrucci´on 1
Instrucci´on 2
...
Instrucci´on n
Intrucci´on externa
Final
S´ı
No
Se emplea:
+valor3 para indicar un Incremento y −valor3 un Decremento
Figura 4.31: Forma general del ciclo Para-FinPara
Aclaraci´on:
Algunos de los problemas que se solucionan
con una estructura Mientras-FinMientras o
Haga-MientrasQue, no pueden ser solucionados
con una estructura Para-FinPara.

-- 275 of 450 --

274 Estructuras de repetici ´on
Para explicar el funcionamiento del ciclo Para-FinPara se har´a uso
del mismo ejemplo empleado con las dos estructuras anteriores (Algoritmo
4.2 y 4.11), de esta forma usted podr´a observar su diferencia. Ver segmento
del Algoritmo 4.31.
Algoritmo 4.31: Imprimir los n´umeros del 1 al 10
1 Para numero = 1 Hasta 10 Incremento 1
2 imprimir( numero )
3 FinPara
Para una explicaci´on m´as clara, se identificar´an sus partes de acuerdo a
la forma general expresada en p´arrafos anteriores.
L´ınea 1: Inicio del ciclo
L´ınea 2: Cuerpo del ciclo
L´ınea 3: Fin del ciclo. Retorna el control a la l´ınea 1.
En la primera l´ınea se encuentra el inicio del ciclo, en el cual se ejecutan
las siguientes acciones: