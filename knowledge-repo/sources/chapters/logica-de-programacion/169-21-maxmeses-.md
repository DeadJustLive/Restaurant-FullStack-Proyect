# 21 MAX_MESES )

22
23 mostrarResultados( nominaMesM, nominaEmpleadoE )
24 FinAlgoritmo
25
26 Funcion Entero[ ][ ] leerDatos( Entero filas, Entero
columnas)
27 Entero i, j,
28 Real matriz[ filas ] [ columnas ]
29
30 Para i = 1 Hasta filas Incremento 1
31 Para j = 1 Hasta columnas Incremento 1
32 imprimir( "Sueldo del empleado " , i, " mes ",j,":" )
33 leer( matriz[ i ][ j ] )
34 FinPara
35 FinPara
36
37 Retornar matriz
38 FinFuncion
39
40 Funcion Real calcularNominaMesM( Real matriz[ ][ ],
41 Entero numeroMes,
42 Entero maximoEmpleados )
43 Entero i
44 Real nominaMesM
45
46 nominaMesM = 0
47 Para i = 1 Hasta maximoEmpleados Incremento 1
48 nominaMesM = nominaMesM + matriz[ i ][ numeroMes ]
49 FinPara
50
51 Retornar nominaMesM
52 FinFuncion
53

-- 430 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 429
54 Funcion Real calcularNominaEmpleadoE( Real matriz[ ][ ],
55 Entero numeroEmp,
56 Entero maximoMeses )
57 Entero i
58 Real nominaEmpleadoE
59
60 nominaEmpleadoE = 0
61 Para i = 1 Hasta maximoMeses Incremento 1
62 nominaEmpleadoE = nominaEmpleadoE + matriz[numeroEmp][i]
63 FinPara
64
65 Retornar nominaEmpleadoE
66 FinFuncion
67
68 Procedimiento mostrarResultados( Real nominaMesM,
69 Real nominaEmpleadoE )
70 imprimir( "El total n´omina del mes: ", nominaMesM )
71 imprimir( "El total a˜no empleado: ", nominaEmpleadoE )
72 FinProcedimiento
Explicaci´on del algoritmo:
En el algoritmo principal se declaran las variables como la matriz de
sueldos, la nomina del mes que se requiere y la n´omina del empleado que
se requiere. Posteriormente se hace el llamado a la funci´on leerDatos(),
a la que se le env´ıan como par´ametros el n´umero m´aximo de empleados y
el m´aximo de meses que tiene la matriz de sueldos.
7 matrizSueldos = leerDatos( MAX_EMPLEADOS, MAX_MESES )
Esta funci´on permite almacenar los 12 sueldos de los 10 empleados
mediante dos ciclos Para anidados y retorna una matriz con los sueldos
ingresados para que sea almacenada en la variable matrizSueldos.
Recuerde que las filas de la matriz representan los empleados, mientras
que las columnas representan los meses del a˜no.
La referencia a la matriz de sueldos se env´ıa como argumento, junto con
el n´umero del mes del que se desea conocer el valor total de la n´omina y el
m´aximo de empleados, a la funci´on calcularNominaMesM() , la cual
utiliza un ciclo Para con el objetivo de recorrer las filas de la matr´ız en la
columna que representa al mes analizado e ir sumando los sueldos solo de
ese mes; una vez hace el recorrido de las celdas que est´an en la columna del
mes analizado, retornando el resultado de esta suma, es decir, lo pagado
durante ese mes a los 10 empleados.

-- 431 of 450 --

430 Vectores y matrices
40 Funcion Real calcularNominaMesM( Real matriz[ ][ ],
41 Entero numeroMes,
42 Entero maximoEmpleados )
43 Entero i
44 Real nominaMesM
45
46 nominaMesM = 0
47 Para i = 1 Hasta maximoEmpleados Incremento 1
48 nominaMesM = nominaMesM + matriz[ i ][ numeroMes ]
49 FinPara
50
51 Retornar nominaMesM
52 FinFuncion
Igual sucede con la funci´on calcularNominaEmpleadoE(), que
recibe la referencia a la matriz de sueldos como argumento, el n´umero de
fila que representa al empleado, as´ı como el m´aximo de meses, y a trav´es de
un ciclo Para se recorre las columnas de la matriz en la fila que representa
al empleado del que se desea conocer su n´omina anual, retornando la suma
de los 12 sueldos del respectivo empleado.
54 Funcion Real calcularNominaEmpleadoE( Real matriz[ ][ ],
55 Entero numeroEmp,
56 Entero maximoMeses )
57 Entero i
58 Real nominaEmpleadoE
59
60 nominaEmpleadoE = 0
61 Para i = 1 Hasta maximoMeses Incremento 1
62 nominaEmpleadoE = nominaEmpleadoE + matriz[numeroEmp][i]
63 FinPara
64
65 Retornar nominaEmpleadoE
66 FinFuncion
Al finalizar, el algoritmo muestra, a trav´es del procedimiento
mostrarResultados() el total de la n´omina pagado durante el mes
especificado del a˜no y lo pagado durante el a˜no al empleado indicado.
.:Ejemplo 6.16. Construya un algoritmo que permita almacenar caracteres
en una matriz cuadrada de n filas y columnas, y que, posteriormente
permita intercambiar los caracteres que se encuentran en las celdas de dos
filas cualquiera. El algoritmo debe mostrar la matriz inicial y la matriz
resultante luego de intercambiar los elementos de las filas. Utilice funciones
y procedimientos para realizar los procesos.

-- 432 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 431
An´alisis del problema:
Resultados esperados: la matriz con los caracteres ingresados
inicialmente, as´ı como la matriz con los caracteres intercambiados
entre dos filas diferentes indicadas por el usuario.
Datos disponibles: los caracteres que se van a almacenar en la
matriz original.
Proceso: luego de tener una matriz cuadrada de n filas y columnas
conteniendo en sus celdas caracteres, el algoritmo debe intercambiar
los caracteres que est´an en las celdas de dos filas cualquiera y
mostrar la matriz original y la resultante despu´es del intercambio
de caracteres.
Variables requeridas:
• En el algoritmo principal
◦ matrizCaracteres: almacena los caracteres ingresados
por el usuario.
◦ matrizIntercambiada: almacena los caracteres luego
de haber intercambiado las filas.
◦ fila1: n´umero de la primera fila a intercambiar
◦ fila2: n´umero de la segunda fila a intercambiar.
◦ tamanio: corresponde al tama˜no de la matriz (igual
n´umero de filas y columnas).
• En la funci´on leerDatos
◦ Par´ametros:
 tamanio: corresponde al tama˜no de la matriz.
◦ Variables locales:
 i: controla el ciclo externo de las filas.
 j: controla el ciclo interno de las columnas.
 matriz: matriz de datos que ser´a retornada.
• En la funci´on intercambiarF
◦ Par´ametros:
 matriz: matriz con los caracteres.
 tamanio: corresponde al tama˜no de la matriz.
 f1: n´umero de la primera fila a intercambiar
 f2: n´umero de la segunda fila a intercambiar.

-- 433 of 450 --

432 Vectores y matrices
◦ Variables locales:
 i: controla el ciclo.
 aux: variable auxiliar para almacenar datos
temporalmente. (m).
 mat: matriz auxiliar en la que se hacen los cambios.
(m).
• En la funci´on mostrarResultados
◦ Par´ametros:
 m1: matriz original con los caracteres ingresados.
 m2: matriz con las dos filas intercambiadas.
 t: tama˜no de las matrices, representa la cantidad de
filas y columnas.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.16.
Algoritmo 6.16: MatrizCaracteres
1 Algoritmo MatrizCaracteres
2 Caracter matrizCaracteres [ ][ ]
3 Caracter matrizintercambiada [ ][ ]
4 Entero fila1, fila2, tamanio
5
6 imprimir( "Ingrese el tama˜no de la matriz cuadrada " )
7 leer( tamanio )
8
9 matrizCaracteres = leerDatos( tamanio )
10
11 imprimir( "Ingrese la fila 1 a intercambiar " )
12 leer( fila1 )
13
14 imprimir( "Ingrese la fila 2 a intercambiar " )
15 leer( fila2 )
16
17 matrizIntercambiada = intercambiarF( matrizCaracteres,
18 tamanio,
19 fila1, fila2 )
20
21 mostrarResultados( matrizCaracteres,
22 matrizIntercambiada, tamanio )
23 FinAlgoritmo
24
25 Funcion Caracter[ ][ ] leerDatos( Entero tamanio )
26 Entero i, j
27 Caracter matriz[ tamanio ][ tamanio ]
28
29 Para i = 1 Hasta tamanio Incremento 1

-- 434 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 433
30 Para j = 1 Hasta tamanio Incremento 1
31 imprimir( "Car´acter posici´on ", i, " " j, ":" )
32 leer( matriz[ i ][ j ] )
33 FinPara
34 FinPara
35
36 Retornar matriz
37 FinFuncion
38
39 Funcion Caracter[][] intercambiarF( Caracter matriz[ ][ ],
40 Entero tamanio,
41 Entero f1, Entero f2)
42 Caracter aux, mat[ tamanio ][ tamanio ]
43 Entero i
44
45 Para i = 1 Hasta tamanio Incremento 1
46 Para j = 1 Hasta tamanio Incremento 1
47 mat [ i ][ j ] = matriz [ i ][ j ]
48 FinPara
49 FinPara
50
51 Para i = 1 Hasta tamanio Incremento 1
52 aux = matriz[ f1 ][ i ]
53 mat [ f1 ][ i ] = mat[ f2 ][ i ]
54 mat [ f2 ][ i ] = aux
55 FinPara
56
57 Retornar mat
58 FinFuncion
59
60 Procedimiento mostrarResultados( Caracter m1[ ][ ],
61 Caracter m2[ ][ ],
62 Entero t )
63 Cadena cadenaA, cadenaB
64
65 cadenaA = ""
66 cadenaB = ""
67 Para i = 1 Hasta tamanio Incremento 1
68 Para j = 1 Hasta tamanio Incremento 1
69 cadenaA = cadenaA + m1[ i ][ j ] + " "
70 cadenaB = cadenaB + m2[ i ][ j ] + " "
71 FinPara
72 cadenaA = cadenaA + SALTO_LINEA
73 cadenaB = cadenaB + SALTO_LINEA
74 FinPara
75
76 imprimir( "Matriz Inicial ", cadenaA )
77 imprimir( "Matriz Con filas intercambiadas ", cadenaB )
78 FinProcedimiento

-- 435 of 450 --

434 Vectores y matrices
Explicaci´on del algoritmo:
El algoritmo empieza declarando las variables y solicit´andole al usuario
el tama˜no de la matriz que ser´a el mismo n´umero de filas y columnas
(l´ıneas 2 a 7); con este tama˜no se inicializa la matriz dentro de la funci´on
leerDatos(), es por eso que el tama˜no se env´ıa a esta funci´on como
argumento (l´ınea 9).
Dentro de esta misma funci´on, se ingresan los caracteres a la matriz de
caracteres (la inicial); esto se lleva a cabo por medio de los dos ciclos Para
anidados, como ya se ha explicado en ejercicios anteriores (l´ıneas de la 25
a la 37).
Luego, se solicitan al usuario las filas que se van a intercambiar y, con
esta informaci´on se llama a la funci´on intercambiarF() (l´ıneas de la
11 a la 19) a la que se env´ıan la matriz original, el tama˜no y las filas que
se van a intercambiar.
Ya dentro de esta funci´on, se utiliza una variable suscrita denominada
mat que recibe los datos de la matriz y, as´ı no modificar la matriz original, y
una variable aux que servir´a para almacenar temporalmente los caracteres
que est´an en la primera fila que se va a intercambiar y estos no se vayan a
perder; a continuaci´on, los caracteres de la segunda fila a intercambiar se
pasan a la primera fila y los que estaban en la variable auxiliar (es decir,
los que se copiaron inicialmente) se ubican en la segunda fila de la matriz
que se est´a intercambiando. Todo este cambio se realiza con un ciclo Para
que recorre las columnas de las filas que se van a intercambiar, por eso,
la variable i, representa la columna en que se va ubicando el control del
algoritmo para leer el car´acter. De esta forma los caracteres que estaban
en las dos filas son intercambiados. Al finalizar esta funci´on, se retorna la
variable mat.
39 Funcion Caracter[][] intercambiarF( Caracter matriz[ ][ ],
40 Entero tamanio,
41 Entero f1, Entero f2)
42 Caracter aux, mat[ tamanio ][ tamanio ]
43 Entero i
44
45 Para i = 1 Hasta tamanio Incremento 1
46 Para j = 1 Hasta tamanio Incremento 1
47 mat [ i ][ j ] = matriz [ i ][ j ]
48 FinPara
49 FinPara
50
51 Para i = 1 Hasta tamanio Incremento 1

-- 436 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 435
52 aux = matriz[ f1 ][ i ]
53 mat [ f1 ][ i ] = mat[ f2 ][ i ]
54 mat [ f2 ][ i ] = aux
55 FinPara
56
57 Retornar mat
58 FinFuncion
Como en los anteriores algoritmos, se utiliza el procedimiento
mostrarResultados() para mostrar al usuario las matrices, la que
contiene los caracteres iniciales ingresados por el usuario y la que tiene
sus filas intercambiadas. En este procedimiento se utilizan variables de
tipo cadena que almacenan todos los caracteres y los muestran con la
instrucci´on imprimir, de tal modo que es posible mostrar los datos de las
matrices como tablas.
.:Ejemplo 6.17. Construya un algoritmo que almacene n´umeros enteros
en una matriz cuadrada de orden n y que a trav´es de funciones y
procedimientos determine si la suma de los elementos de la diagonal
principal es igual, mayor o menor a la suma de los elementos de la diagonal
secundaria.
A trav´es de este algoritmo se exploran los conceptos de diagonales en las
matrices. La diagonal principal es aquella que se forma empezando en la
primera celda de la matriz (fila 1, columna 1) y termina en la ´ultima celda
(fila n, columna n) de la misma.
diagonalP rincipal =





a11
a22
· · ·
ann





Por tanto su suma se define como:
sumaDiagonalP rincipal =
n	∑
i=1
aii
Por su parte, la diagonal secundaria es la que inicia en la ´ultima
celda de la primera fila (fila 1, columna n) y termina en la ´ultima fila
de la primera columna (fila n, columna 1). Si bien es posible encontrar
diagonales en matrices no cuadradas, en este ejercicio se trabaja con una
matriz cuadrada, que es aquella donde el n´umero de filas es igual al n´umero
de columnas.

-- 437 of 450 --

436 Vectores y matrices
diagonalSecundaria =





a1n
a2(n−1)
· · ·
an1





La suma de los elementos de la diagonal secundaria es:
sumaDiagonalSecundaria =
n	∑
i=1
ai(n−i)
An´alisis del problema:
Resultados esperados: informar como resultado si la suma de los
elementos de la diagonal principal de una matriz es igual, mayor o
menor a la suma de los elementos de la diagonal secundaria.
Datos disponibles: estar´an disponibles los n´umeros enteros que
ser´an almacenados en cada una de las celdas de la matriz y el tama˜no
que se le va a dar a esta.
Proceso: luego de ingresarse los n´umeros enteros a la matriz,
este algoritmo deber´a recorrer tanto la diagonal principal de la
misma como su diagonal secundaria y sumar los elementos que
est´an presentes en estas diagonales, para despu´es comparar las sumas
obtenidas y determinar si son iguales o alguna de las dos es mayor.
Variables requeridas:
• En el algoritmo principal
◦ matriz: matriz que almacenar´a los n´umeros.
◦ sumaDiagonalPrincipal: almacena la suma de la
diagonal principal de la matriz.
◦ sumaDiagonalSecundaria: almacena la suma de la
diagonal secundaria de la matriz.
◦ n: corresponde al tama˜no de la matriz.
• En la funci´on leerDatos
◦ Par´ametros:
 tamanio: corresponde al tama˜no de la matriz.
◦ Variables locales:
 i: controla el ciclo externo de las filas.

-- 438 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 437
 j: controla el ciclo interno de las columnas.
 matriz: matriz de datos que ser´a retornada.
• En la funci´on sumarDiagPrincipal
◦ Par´ametros:
 matriz: la matriz de n´umeros.
 tamanio: corresponde al tama˜no de la matriz.
◦ Variables locales:
 i: controla el ciclo.
 suma: suma de los elementos de la diagonal principal.
• En la funci´on sumarDiagSecundaria
◦ Par´ametros:
 matriz: la matriz de n´umeros.
 tamanio: corresponde al tama˜no de la matriz.
◦ Variables locales:
 columna: indica la columna.
 i: controla el ciclo.
 suma: suma de los elementos de la diagonal secundaria.
• En el procedimiento mostrarResultados
◦ Par´ametros:
 sumaDiagonalP: contiene la suma de los elementos
de la diagonal principal.
 sumaDiagonalS: contiene la suma de los elementos
de la diagonal secundaria.
De acuerdo al an´alisis planteado, se propone el Algoritmo 6.17.
Algoritmo 6.17: DiagonalesMatriz
1 Algoritmo DiagonalesMatriz
2 Entero matriz [ ][ ]
3 Entero sumaDiagonalPrincipal, sumaDiagonalSecundaria, n
4
5 imprimir( "Ingrese el tama˜no de la matriz " )
6 leer( n )
7
8 matriz = leerDatos( n )
9
10 sumaDiagonalPrincipal = sumarDiagPrincipal ( matriz, n )
11 sumaDiagonalSecundaria = sumarDiagSecundaria( matriz, n )
12
13 mostrarResultados( sumaDiagonalPrincipal,

-- 439 of 450 --

438 Vectores y matrices
14 sumaDiagonalSecundaria )
15 FinAlgoritmo
16
17 Funcion Entero[ ][ ] leerDatos( Entero tamanio )
18 Entero i, j, matriz [ tamanio ][ tamanio ]
19
20 Para i = 1 Hasta tamanio Incremento 1
21 Para j = 1 Hasta tamanio Incremento 1
22 imprimir( "N´umero en posici´on " , i, " ", j, " :")
23 leer( matriz[ i ][ j ] )
24 FinPara
25 FinPara
26
27 Retornar matriz
28 FinFuncion
29
30 Funcion Entero sumarDiagPrincipal( Entero matriz[ ][ ],
31 Entero tamanio )
32 Entero suma, i
33
34 suma = 0
35 Para i = 1 Hasta tamanio Incremento 1
36 suma = suma + matriz[ i ][ i ]
37 FinPara
38
39 Retornar suma
40 FinFuncion
41
42 Funcion Entero sumarDiagSecundaria( Entero matriz[ ][ ],
43 Entero tamanio )
44 Entero suma, i, columna
45
46 columna = tamanio
47 suma = 0
48 Para i = 1 Hasta tamanio Incremento 1
49 suma = suma + matriz[ i ][ columna ]
50 columna = columna - 1
51 FinPara
52
53 Retornar suma
54 FinFuncion
55
56 Procedimiento mostrarResultados( Entero sumaDiagonalP,
57 Entero sumaDiagonalS )
58
59
60 Si( sumaDiagonalP == sumaDiagonalS ) Entonces
61 imprimir( "Las sumas de las diagonales son iguales " )
62 SiNo

-- 440 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 439
63 Si( sumaDiagonalP > sumaDiagonalS ) Entonces
64 imprimir( "La suma de la diagonal principal es mayor")
65 SiNo
66 imprimir( "La suma de la diagonal principal es menor")
67 FinSi
68 FinSi
69 FinProcedimiento
Explicaci´on del algoritmo:
Luego de declarar las variables en el algoritmo principal, se solicita al
usuario ingresar el tama˜no de la matriz, que permitir´a determinar tanto
la cantidad de filas como de columnas ya que el ejercicio requiere de una
matriz cuadrada (l´ıneas de la 2 a la 6).
Con la funci´on leerDatos(), el algoritmo solicita los datos utilizando
dos ciclos Para anidados que recorrer´an las filas y las columnas (l´ınea 8 y
l´ıneas de la 17 a la 25).
La matriz ya cargada con datos es enviada a la funci´on
sumarDiagPrincipal() que mediante un ciclo Para recorre la
diagonal principal pasando por las celdas donde el n´umero de la fila es
igual al n´umero de la columna, por eso, en el ciclo la variable i especifica
tanto fila como columna. Los valores de estas celdas se van acumulando
en la variable suma que es retornada al algoritmo principal al final de la
funci´on.
30 Funcion Entero sumarDiagPrincipal( Entero matriz[ ][ ],
31 Entero tamanio )
32 Entero suma, i
33
34 suma = 0
35 Para i = 1 Hasta tamanio Incremento 1
36 suma = suma + matriz[ i ][ i ]
37 FinPara
38
39 Retornar suma
40 FinFuncion
Algo similar sucede con la funci´on sumarDiagSecundaria(), pero
en este caso, el recorrido mediante el ciclo Para se hace desde la primera
fila con la variable i y la ´ultima columna con la variable columna,
que previamente ha tomado el valor del par´ametro tamanio. Dentro del
ciclo, la variable i se va incrementando para pasar a las siguientes filas
en cada iteraci´on, mientras que la expresi´on columna=columna - 1
va decrementando esta variable para ubicarse en una columna anterior.

-- 441 of 450 --

440 Vectores y matrices
De esta manera, se van recorriendo las celdas que est´an ubicadas en la
diagonal secundaria; los valores almacenados en estas celdas se acumulan
en la variable suma que ser´a lo que retornar´a la funci´on.
42 Funcion Entero sumarDiagSecundaria( Entero matriz[ ][ ],
43 Entero tamanio )
44 Entero suma, i, columna
45
46 columna = tamanio
47 suma = 0
48 Para i = 1 Hasta tamanio Incremento 1
49 suma = suma + matriz[ i ][ columna ]
50 columna = columna - 1
51 FinPara
52
53 Retornar suma
54 FinFuncion
Los resultados de las dos funciones anteriores se enviar´an al
procedimiento mostrarResultados() con el fin de que este determine
y muestre si las sumas son iguales o alguna es mayor (l´ıneas 13 y 14, as´ı
como las l´ıneas 56 a la 69).
6.3. Ejercicios propuestos
Para los siguientes ejercicios propuestos, utilice funciones y procedi-
mientos en su soluci´on.