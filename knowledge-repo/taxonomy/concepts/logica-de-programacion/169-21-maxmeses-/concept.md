# 21 MAX_MESES )

## Fuente
logica-de-programacion (Cap. 169)

## Contenido
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
mostrar la matriz original y la resultante despu´es del interc
