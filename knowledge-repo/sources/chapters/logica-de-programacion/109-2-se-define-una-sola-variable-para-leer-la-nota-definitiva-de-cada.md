# 2. Se define una sola variable para leer la nota definitiva de cada

materia y mediante un ciclo que itere 6 veces se hace la lectura
y esta se va acumulando; una vez finalizado el ciclo se calcula
el promedio.
Para la soluci´on a implementar, se optar´a por la segunda opci´on. El
ciclo al que se hace menci´on en esta soluci´on, deber´a estar dentro de
otro ciclo intermedio, que manejar´a la informaci´on correspondiente
a los estudiantes y este a su vez estar´a anidado dentro de un ciclo
externo que trabajar´a con la informaci´on de los grupos.
En la Figura 4.42 se puede apreciar de forma global la estructura de
la soluci´on, la cual se interpreta de la siguiente manera:
La zona denominada Inicializaci´on general, ser´a utilizada para
inicializar las variables que vayan a intervenir en la condici´on del ciclo
externo, en el caso de ser necesarias para su ejecuci´on. As´ı mismo, se
inicializar´an los contadores de los datos generales que solicitan, por
ejemplo, el total de estudiantes, estudiantes en situaci´on condicional,
los que aprobaron o reprobaron el promedio y los excluidos.

-- 305 of 450 --

304 Estructuras de repetici ´on
Inicializacion general
1A
2A
3
1B
2B
1C
Resultados generales
Figura 4.42: Forma general para el Ejemplo 4.25

-- 306 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 305
Dentro del ciclo externo se identifican las siguientes zonas: 1A y 1B
y 1C.
En la zona 1A, se deben inicializar los contadores que se
incrementar´an dentro del ciclo intermedio, ubicado en la Zona 1B.
En estos contadores se almacenar´a la cantidad de estudiantes que
aprobaron o reprobaron en cada uno de los grupos. Adicionalmente
se especificar´a el grupo al cu´al se le van a procesar los datos de sus
respectivos estudiantes.
La zona 1B, conformada por las zonas 2A, 2B y 3, estar´a ocupada
por el ciclo intermedio que procesar´a los datos de los estudiantes;
dentro de ´el, estar´a el ciclo m´as interno (zona 3) que se encargar´a de
la lectura de las 6 notas definitivas.
Para terminar con el ciclo externo, se identifica la zona 1C, en ella,
se da la informaci´on que corresponde a los grupos, se incrementan
algunos contadores generales y se incrementa la identificaci´on del
grupo (Grupo A, Grupo B. . . ).
Pasando al ciclo intermedio se encuentran las zonas 2A, 2B y 3. En
este ciclo se van a procesar los datos pertenecientes a cada estudiante.
En la zona 2A, se solicitar´an los datos que se tienen del estudiante:
el c´odigo, el nombre y las notas. Recuerde que las notas ser´an le´ıdas
dentro de un ciclo, que estar´a anidado dentro del ciclo intermedio.
En la zona 2A tambi´en se deben inicializar el contador de materias
reprobadas y el acumulador de la sumatoria de las notas definitivas,
que servir´a para calcular el promedio del periodo.
Entre la zona 2A y 2B estar´a el ciclo encargado de procesar las notas
definitivas de cada materia (zona 3).
La zona 2B se destina a los siguientes objetivos:
• Calcular del promedio del periodo.
• Determinar el mayor y menor promedio.
• Informar la situaci´on acad´emica de cada estudiante.
• Contar el n´umero de estudiantes excluidos por bajo rendimiento,
los que quedan en situaci´on condicional y los que aprobaron el
periodo.
El tercer ciclo que compone esta soluci´on algor´ıtmica, se encuentra
en la zona 3. Este ciclo debe iterar 6 veces, en cada ejecuci´on debe
cumplir con 3 funciones: leer la nota definitiva de cada 1 de las 6
materias que curs´o el estudiante, incrementar la sumatoria de notas

-- 307 of 450 --

306 Estructuras de repetici ´on
definitivas y determinar si el estudiante perdi´o alguna materia, es
caso de ser as´ı, debe incrementar un contador que servir´a luego, en
la zona 2B, para decidir si el estudiante es excluido por perder m´as
del 50 % de las materias.
Por ´ultimo, se encuentra la zona denominada Resultados generales,
destinada a los siguientes c´alculos e informes globales:
• C´alculo de los porcentajes generales.
• Se informar´an los datos del mayor y menor promedio,
cantidad de estudiantes que aprobaron y reprobaron el
promedio; porcentaje de estudiantes que aprobaron y el de
los que quedaron excluidos por bajo rendimiento y finalmente
informar´a la cantidad de estudiantes que quedaron en situaci´on
condicional.
De acuerdo a las caracter´ısticas de este problema, se puede
determinar que el ciclo externo y el intermedio pueden ser estructuras
Mientras-FinMientras o Haga-MientrasQue, tenga presente
que ambas operan de manera similar, la diferencia radica en que la
primera se condiciona al inicio y la segunda al final. Para la soluci´on
que se va a plantear, se elegir´a el Mientras-FinMientras para el
ciclo externo y el Haga-MientrasQue para el intermedio; ambos
ciclos se controlar´an con una pregunta de continuar o no con la
ejecuci´on. El ciclo interno, el que est´a en la zona 3, se dise˜nar´a con
una estructura Para-FinPara ya que es la m´as indicada puesto
que se conoce que debe iterar un n´umero definido de veces (6).
Variables requeridas:
• Para los estudiantes:
◦ codigo: identificaci´on de cada estudiante.
◦ nombre: nombre del estudiante.
◦ definitiva: nota definitiva obtenida en cada materia.
◦ sumaDefinitivas: sumatoria de las 6 notas definitivas.
◦ promedioEstudiante: promedio de las 6 notas
definitivas.
◦ reprobadas: cantidad de materias que reprob´o el
estudiante. Se usar´a para determinar si el estudiante es
expulsado por reprobar m´as del 50 % de las materias.

-- 308 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 307
• Para cada grupo:
◦ grupo: identificar´a a cada uno de los grupos. Inicia en la
letra A y se va incrementando por cada uno (Grupo A,
Grupo B, . . . ).
◦ aprobaronGrupo: cantidad de estudiantes que aprobaron
el periodo por grupo.
◦ reprobaronGrupo: cantidad de estudiantes que
reprobaron el periodo por grupo.
• A nivel general:
◦ condicionalGeneral: cantidad de estudiantes que en
situaci´on condicional.
◦ estudiantesGeneral: contar´a el n´umero de estudiantes
que se procesen.
◦ aprobaronGeneral: cantidad total de estudiantes que
aprobaron el periodo acad´emico.
◦ reprobaronGeneral: cantidad total de estudiantes que
reprobaron el periodo acad´emico.
◦ excluidosGeneral: n´umero de estudiantes excluidos
por bajo rendimiento.
◦ mayorPromedioGral: mejor promedio entre todos los
estudiantes.
◦ menorPromedioGral: menor promedio entre todos los
estudiantes.
◦ porcentajeAprobaronGral: porcentaje de estudiantes
que aprobaron, con relaci´on a la poblaci´on total.
◦ porcentajeExcluidosGral: porcentaje de estudiantes
que fueron excluidos por bajo rendimiento, con relaci´on a
la poblaci´on total.
• Para controlar los ciclos:
◦ seguir: variable centinela para controlar los ciclos externo
e intermedio.
◦ materia: controla el ciclo que leer´a las 6 notas definitivas
de cada estudiante.
De acuerdo al an´alisis planteado, se propone el Algoritmo 4.39.

-- 309 of 450 --

308 Estructuras de repetici ´on
Algoritmo 4.39: Universidad
1 Algoritmo Universidad
2 Entero condicionalGeneral, estudiantesGeneral,
3 aprobaronGeneral, reprobaronGeneral,
4 excluidosGeneral, aprobaronGrupo,
5 reprobaronGrupo, reprobadas,
6 materia
7 Real mayorPromedioGral, menorPromedioGral,
8 definitiva, sumaDefinitivas,
9 promedioEstudiante, porcentajeAprobaronGral,
10 porcentajeExcluidosGral
11 Caracter seguir, grupo
12 Cadena codigo, nombre
13
14 // Zona Inicializaci´on general
15 seguir = ’S’
16 grupo = ’A’
17 condicionalGeneral = 0
18 estudiantesGeneral = 0
19 aprobaronGeneral = 0
20 reprobaronGeneral = 0
21 excluidosGeneral = 0
22
23 // Ciclo externo que controla los grupos
24 Mientras( seguir == ’S’ O seguir == ’s’ )
25 // Zona 1A
26 imprimir( "Grupo: ", grupo )
27
28 aprobaronGrupo = 0
29 reprobaronGrupo = 0
30
31 // Ciclo intermedio que procesa los datos del estudiante
32 // Inicio zona 1B
33 Haga
34 // Zona 2A
35 imprimir( "Digite los datos del estudiante" )
36
37 imprimir( "C´odigo: " )
38 Haga
39 leer( codigo )
40 MientrasQue( longitud( codigo ) == 0 )
41
42 imprimir( "Nombre: " )
43 Haga
44 leer( nombre )
45 MientrasQue( longitud( nombre ) == 0 )
46
47 sumaDefinitivas = 0
48 reprobadas = 0

-- 310 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 309
49
50 // Ciclo interno, procesa las notas de cada estudiante
51 Para materia = 1 Hasta 6 Incremento 1
52 // Zona 3
53 imprimir( "Nota definitiva de Materia: ", materia )
54 Haga
55 leer( definitiva )
56 MientrasQue( definitiva < 0.0 O definitiva > 5.0 )
57
58 sumaDefinitivas = sumaDefinitivas + definitiva
59
60 // Para saber si lo excluyen
61 Si( definitiva < 3.0 ) Entonces
62 reprobadas = reprobadas + 1
63 FinSi
64 FinPara
65
66 // Zona 2B
67 promedioEstudiante = sumaDefinitivas / 6
68 imprimir( "Su promedio es: ", promedioEstudiante )
69
70 Si( estudiantesGeneral == 0 ) Entonces
71 mayorPromedioGral = promedioEstudiante
72 menorPromedioGral = promedioEstudiante
73 SiNo
74 Si(promedioEstudiante > mayorPromedioGral) Entonces
75 mayorPromedioGral = promedioEstudiante
76 FinSi
77
78 Si(promedioEstudiante < menorPromedioGral) Entonces
79 menorPromedioGral = promedioEstudiante
80 FinSi
81 FinSi
82
83 // Determina situaci´on acad´emica del estudiante
84 Si(promedioEstudiante < 2.0 O reprobadas > 3) Entonces
85 imprimir( nombre, " excluido por bajo rendimiento" )
86 excluidosGeneral = excluidosGeneral + 1
87
88 // como no hay parcial, se incrementa el general.
89 reprobaronGrupo = reprobaronGrupo + 1
90 SiNo
91 Si( promedioEstudiante < 3.0 ) Entonces
92 imprimir( nombre," en situaci´on condicional" )
93 condicionalGeneral = condicionalGeneral + 1
94
95 // como no hay parcial, se incrementa el general.
96 reprobaronGrupo = reprobaronGrupo + 1;
97 SiNo

-- 311 of 450 --

310 Estructuras de repetici ´on
98 imprimir( nombre, " contin´ua normalmente" )
99 aprobaronGrupo = aprobaronGrupo + 1
100 FinSi
101 FinSi
102
103 estudiantesGeneral = estudiantesGeneral + 1
104
105 imprimir( "Hay m´as estudiantes [S] o [N]?: " )
106 Haga
107 leer( seguir )
108 MientrasQue( seguir != ’S’ Y seguir != ’N’ Y
109 seguir != ’s’ Y seguir != ’n’ )
110
111 MientrasQue( seguir == ’S’ O seguir == ’s’ )
112
113 // Final zona 1B
114 // Zona 1C
115 // Calculos e informaci´on por grupo...
116 imprimir( "Cantidad que aprobaron : ", aprobaronGrupo )
117 imprimir( "Cantidad que reprobaron: ", reprobaronGrupo )
118
119 aprobaronGeneral = aprobaronGeneral + aprobaronGrupo
120 reprobaronGeneral = reprobaronGeneral + reprobaronGrupo
121
122 grupo = grupo + 1
123
124 imprimir( "¿Hay m´as grupos [S] o [N]?: " )
125
126 Haga
127 leer( seguir )
128 MientrasQue ( seguir != ’S’ Y seguir != ’N’ Y
129 seguir != ’s’ Y seguir != ’n’ )
130
131 FinMientras
132
133 // Zona Resultados generales
134 porcentajeAprobaronGral = aprobaronGeneral * 100 /
estudiantesGeneral
135 porcentajeExcluidosGral = excluidosGeneral * 100 /
estudiantesGeneral
136
137 imprimir( "RESUSLTADOS GENERALES" )
138 imprimir( "Mayor promedio: ", mayorPromedioGral )
139 imprimir( "Menor promedio: ", menorPromedioGral )
140
141 imprimir( "Cantidad que aprobaron: ", aprobaronGeneral )
142 imprimir( "Cantidad que reprobaron: ", reprobaronGeneral )
143
144 imprimir( " % aprobaci´on:", porcentajeAprobaronGral, " %" );

-- 312 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 311
145
146 imprimir( "De los ", estudiantesGeneral, " estudiantes" )
147 imprimir( " fueron excluidos ", excluidosGeneral,
148 " equivale al ", porcentajeExcluidosGral, " %" )
149 imprimir( " y en situaci´on condicional: ",
150 condicionalGeneral, " estudiantes" )
151 FinAlgoritmo
Explicaci´on del algoritmo:
Aunque el funcionamiento de este algoritmo qued´o detallado en el
an´alisis, se complementar´an algunos aspectos relevantes.
La caracter´ıstica principal de este algoritmo, es que se trabajaron varias
estructuras de repetici´on de manera anidada. Dentro de estas estructuras,
a su vez, se codificaron estructuras de decisi´on. Algunas simples como las
presentadas en las l´ıneas 61, 74 y 78; otras anidadas como las de las l´ıneas
70 y 84. Una de estas decisiones contempla dentro de su parte falsa dos
nuevas decisiones simples, las cuales se ejecutan de manera independiente
en el caso de que la condici´on de la l´ınea 70 sea falsa.
Hay otros aspectos interesantes para resaltar en esta soluci´on:
Se usa una sola variable centinela (seguir) para controlar la ejecuci´on
de dos ciclos. En la l´ınea 15, la instrucci´on seguir = ’S’ inicializa la
variable de control del ciclo externo Mientras-FinMientras (l´ınea 24),
para que, al evaluar la condici´on al inicio, se d´e un resultado Verdadero
y se ejecute el cuerpo. Desde la l´ınea 124 a la l´ınea 128, se da la lectura
de esta variable para determinar si se contin´ua o no con la repetici´on
del proceso. De forma similar se hace desde las l´ıneas 105 a la 109, pero
en este caso la lectura se hace para verificar la repetici´on o no del ciclo
intermedio Haga-MientrasQue; teniendo en cuenta que este es un ciclo
condicionado al final, no fue necesaria la inicializaci´on de esta variable para
que se realizara su primera iteraci´on.
En la l´ınea 16, se inicializa la variable grupo con el valor de ’A’, ya
que los grupos est´an identificados como Grupo A, Grupo B, Grupo C y as´ı
sucesivamente. Esta variable en la l´ınea 122, se incrementa en 1; al ser de
tipo car´acter toma el siguiente valor, para el caso de la primera iteraci´on
toma el valor de ’B’, en la siguiente iteraci´on toma el valor de ’C’ y
seguir´a avanzando con las letras del alfabeto mientras se est´en ingresando
nuevos grupos. Todas las lecturas de entrada de datos, est´an condicionadas
con ciclos Haga-MientrasQue y funcionan tal cual, se ha explicado en
algoritmos anteriores.

-- 313 of 450 --

312 Estructuras de repetici ´on
Vale la pena resaltar que, aunque fueron utilizadas 3 estructuras
repetitivas diferentes en esta soluci´on, es igualmente v´alido, usar cualquier
tipo de combinaci´on de ellas. El asunto radica, en que dependiendo del tipo
de ciclo que se use, se deben adicionar o eliminar algunas instrucciones.
4.4.1 Prueba de escritorio
A continuaci´on se estudiar´an las pruebas de escritorio utilizando el ciclo
Para-FinPara.
.:Ejemplo 4.26. Realice la prueba de escritorio o tabla de verificaci´on para
el Algoritmo 4.40.
Algoritmo 4.40: Tabla1
1 Algoritmo Tabla1
2 Entero indice
3
4 Para indice = 0 Hasta 30 Incremento 5)
5 Si( indice % 10 == 0 ) Entonces
6 imprimir( indice )
7 FinSi
8 FinPara
9 FinAlgoritmo
La Tabla 4.13 presenta la tabla de verificaci´on para el Algoritmo 4.40.
indice indice<= 30 indice % 10 == 0 imprimir indice
0 0 <= 30 (V) 0 == 0 (V) 0
5 5 <= 30 (V) 5 == 0 (F)
10 10 <= 30 (V) 0 == 0 (V) 10
15 15 <= 30 (V) 5 == 0 (F)
20 20 <= 30 (V) 0 == 0 (V) 20
25 25 <= 30 (V) 5 == 0 (F)
30 30 <= 30 (V) 0 == 0 (V) 30
35 35 <= 30 (F)
Tabla 4.13: Prueba de escritorio - Algoritmo 4.40
Explicaci´on de la prueba de escritorio:
Se presenta un ciclo Para, donde la variable indice se inicializa en 0;
mientras la condici´on del ciclo, que se interpreta como indice <= 30,
sea verdadera, el ciclo itera.

-- 314 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 313
En cada iteraci´on, mediante la condici´on de la estructura Si(indice %
10 == 0), se pregunta que si al dividir el valor de indice entre 10, deja
como resto el valor de 0. En pocas palabras, est´a preguntando que si el
valor de indice es m´ultiplo de 10. Si la condici´on es verdadera, entonces
se procede a realizar la impresi´on del valor de indice.
.:Ejemplo 4.27. En el Algoritmo 4.41, se emplear´an de forma anidada,
los tres ciclos que se estudiaron en este cap´ıtulo. Se tendr´a la versi´on en
pseudoc´odigo y luego en diagrama de flujo.
Se quiere saber cu´al es el resultado que imprime, para ello se realizar´a
una prueba de escritorio o tabla de verificaci´on.
Aclaraci´on:
Con las tres estructuras repetitivas estudiadas en este
cap´ıtulo, se pueden hacer casi las mismas cosas. Cada
uno de estos ciclos es m´as funcional en determinadas
ocasiones: El Mientras-FinMientras es ´util
cuando se requiera que un proceso se ejecute o no,
dependiendo de una condici´on. El Haga-MientrasQue, se puede
usar en aquellos procesos que deben ejecutarse por lo menos una vez.
El Para-FinPara, es funcional cuando se tiene claro el n´umero de
iteraciones que debe hacer el ciclo.
A continuaci´on se muestra el algoritmo en su representaci´on en
pseudoc´odigo y posteriomente su diagrama de flujo (Figura 4.43).
Algoritmo 4.41: Tabla2
1 Algoritmo Tabla2
2 Entero a, b, c
3 a = 1
4 b = 3
5 Mientras( a < 5 )
6 Haga
7 Para c = 1 Hasta b Incremento 1
8 imprimir( a, b, c )
9 FinPara
10 b = b - 2
11 MientrasQue( b >= 1 )
12 b = 2
13 a = a + b
14 FinMientras
15 FinAlgoritmo

-- 315 of 450 --

314 Estructuras de repetici ´on
Inicio
a = 1
b = 3
a < 5
b
c = 1
+1
S´ı
a,b,c
b = b − 2
b >= 1
b = 2
a = a + b
Final
No
No
S´ı
S´ı
No
Figura 4.43: Diagrama de flujo del Algoritmo Tabla2

-- 316 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 315
La prueba de escritorio para el anterior algoritmo es la siguiente:
a b c c<= b a< 5 b>= 1 imprimir a, b, c
1 3 1 < 5 (V)
1 1 <= 3 (V) 1, 3, 1
2 2 <= 3 (V) 1, 3, 2
3 3 <= 3 (V) 1, 3, 3
4 4 <= 3 (F)
1 1 >= 1 (V)
1 1 <= 1 (V) 1, 1, 1
2 2 <= 1 (F)
-1 −1 >= 1 (F)
2
3 3 < 5 (V)
1 1 <= 2 (V) 3, 2, 1
2 2 <= 2 (V) 3, 2, 2
3 3 <= 2 (F)
0 0 >= 1 (F)
2
5 5 < 5 (F)
Tabla 4.14: Prueba de escritorio - Algoritmo 4.41
Para cada una de las variables se reserv´o una columna en la Tabla 4.14.
De igual forma se procedi´o con las condiciones de cada uno de los ciclos.
Al evaluar por primera vez la condici´on del Mientras-FinMientras,
el resultado que se obtiene es verdadero, por lo tanto, se procede a ejecutar
su cuerpo que est´a conformado por un ciclo Haga-MientrasQue; este al
ser un ciclo condicionado al comienzo no requiere evaluaci´on inicial para
poder iterar.
Dentro del cuerpo del Haga-MientrasQue, est´a una estructura Para,
que inicializa su variable de control c en 1; al encontrar su condici´on
verdadera procede a ejecutarse (1 <= 3).
Cuando el control es asumido por el ciclo Para, la ejecuci´on del
algoritmo itera en este sitio, hasta que la variable c tome un valor de 4.
Cuando esto suceda, el control es entregado al ciclo Haga-MientrasQue
donde se le restan dos unidades a la variable b. Al encontrar el
MientrasQue, se eval´ua la condici´on, cumpli´endose que 1 >= 1. El
Haga-MientrasQue itera una vez m´as; por segunda ocasi´on la variable
c del ciclo Para, toma el valor de 1. Este inicia de nuevo su iteraci´on,
cuando la variable c tome el valor de 2, la condici´on ser´a falsa (c <=
b, o sea, 2 <= 1 (F)). De nuevo el control vuelve a ser asumido por
el ciclo Haga-MientrasQue, donde la variable b se decrementa en 2

-- 317 of 450 --

316 Estructuras de repetici ´on
unidades y toma el valor de -1; la condici´on del MientrasQue arroja un
resultado falso (-1 >= 1 (F)), el control vuelve a ser asumido por el
ciclo Mientras-FinMientras. Ahora la variable b toma el valor de 2
y la variable a el valor de 3. Al encontrar el FinMientras se regresa al
Mientras y se testea la condici´on (a <5, es decir, 3 <5 (V)), logrando
un resultado verdadero. Nuevamente se entra al Haga-MientrasQue y
por consiguiente al Para, el ´ındice c inicia en 1 y este ciclo se ejecuta dos
veces. Una vez m´as el Haga-MientrasQue tiene el control, al realizar
la operaci´on b = b - 2, la variable b toma el valor de 0 con lo cual la
condici´on del MientrasQue se vuelve falsa. Por tercera vez el control
lo asume el ciclo Mientras-FinMientras, la variable b toma el valor
de 2 y la variable a incrementa en el valor de b, almacenando un 5; el
FinMientras retorna al Mientras para evaluar la condici´on (a <5),
obteniendo un resultado falso, con lo cual se termina la ejecuci´on de los
ciclos y del algoritmo.
Observe en la tabla, que las tres condiciones de los ciclos terminan con un
valor de falso: 3 <= 2 (F), 0 >= 1 (F) y 5 < 5 (F). Ellos solamente
se ejecutan mientras la condici´on sea verdadera.
En cada iteraci´on del Para se imprimen los valores de a, b y c.
Cuando el ciclo intermedio Haga-MientrasQue no se ejecute,
tampoco se ejecuta el Para.
Cuando el ciclo externo Mientras-FinMientras termine de iterar,
los otros dos ciclos tampoco podr´an volver a hacerlo.
4.5. Ejercicios propuestos