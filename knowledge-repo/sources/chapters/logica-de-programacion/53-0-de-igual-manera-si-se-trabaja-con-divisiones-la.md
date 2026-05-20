# 0. De igual manera si se trabaja con divisiones, la

variable valorDecremento por ning´un motivo podr´ıa tomar el
valor de 0, la divisi´on entre 0 no est´a definida.
4.1.3 Bandera
Es una variable que se usa para controlar diferentes acciones dentro de
un algoritmo. Algunos textos se refieren a esta variable como interruptor,
conmutador o centinela [Joyanes A., 1996].
Una variable bandera puede ser definida virtualmente de cualquier tipo
de dato. Generalmente estas variables toman uno de dos valores posibles,
ese valor depende del tipo de dato con que fue declarada.
Si la variable es de tipo Logico, los ´unicos valores posibles son
Verdadero o Falso. Si la variable es de tipo Entero los valores posibles

-- 183 of 450 --

182 Estructuras de repetici ´on
podr´ıan ser 1 o 0, que se pueden interpretar como verdadero o encendido
para el 1 y falso o apagado para el 0. Si la declaraci´on se hizo de tipo
Caracter, puede tomar cualquier valor; los valores m´as comunes son ’S’o
’N’, interpretados como ’S’ = S´ı o ’N’= No. Sin embargo, para estos dos
´ultimos tipos de datos, el dise˜nador del algoritmo le puede asignar los
valores que estime convenientes.
Es fundamental darle un valor inicial a la variable bandera, el cual
cambiar´a dependiendo de ciertas condiciones que estar´an dadas por la
soluci´on del problema. De acuerdo a lo explicado en los p´arrafos anteriores,
el valor inicial debe ser uno de los posibles que puede tomar; una vez se
presente la situaci´on esperada estos valores deber´an cambiar su estado al
valor contrario, es decir, si se inicializ´o en Verdadero cambiar´a a Falso,
si fue en 1 cambiar´a a 0 y si fue en ’S’cambiar´a a ’N’. Luego de ejecutar
las instrucciones correspondientes podr´ıan retomar su valor inicial.
En los siguientes p´arrafos a lo largo de este cap´ıtulo, a medida que se
estudian las diferentes estructuras de repetici´on, se ilustrar´a el uso de este
tipo de variables.
4.2. Estructura Mientras - FinMientras
Es una estructura de repetici´on que permite que una instrucci´on o un
conjunto de ellas se ejecuten una o m´as veces, o por el contrario que no
lleguen a ejecutarse ya que todo depende del resultado de una condici´on
que debe evaluarse al inicio del ciclo.
La forma general de esta estructura de repetici´on es presentada en el
segmento del Algoritmo 4.1.
Algoritmo 4.1: Forma general - Mientras-FinMientras
1 Instrucci´on de inicializaci´on
2 Mientras( condici´on )
3 Instrucci´on-1
4 Instrucci´on-2
5 ... /* Cuerpo del ciclo */
6 Instrucci´on-n
7 Instrucci´on modificadora de condici´on
8 FinMientras
9 Instrucci´on externa
Teniendo en cuenta que el Mientras-FinMientras es una
instrucci´on repetitiva condicionada al inicio, se debe prestar especial
cuidado en inicializar la variable o las variables que ser´an evaluadas en

-- 184 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 183
la condici´on, ya que de esto depende que se ejecute o no el cuerpo del
ciclo; es por ello que dentro de la anterior forma general se contempla una
Instrucci´on de inicializaci´on (l´ınea 1). De igual manera la inicializaci´on
tambi´en se aplica a los contadores y acumuladores que ser´an modificados
dentro del ciclo. La inicializaci´on puede estar impl´ıcita en el mismo
algoritmo o puede ser suministrada por el usuario.
Al encontrar la instrucci´on Mientras se debe evaluar la condici´on
(l´ınea 2), la cual estar´a representada por una expresi´on relacional o l´ogica.
Si el resultado de la evaluaci´on es verdadero, entonces se procede a ejecutar
el cuerpo del ciclo (l´ıneas de la 3 a la 7) hasta encontrar la instrucci´on
FinMientras; luego el control del algoritmo regresa al inicio del ciclo,
es decir a la instrucci´on Mientras y una vez m´as se eval´ua la condici´on.
Este proceso terminar´a en el momento que la evaluaci´on de la condici´on
arroje un resultado falso, en cuyo caso el control del algoritmo lo asume la
Instrucci´on externa (l´ınea 9), la cual no hace parte del ciclo.
Cuando se eval´ue por primera vez la condici´on y el resultado sea falso,
las instrucciones que componen el cuerpo del ciclo no se ejecutan; el control
lo asume la Instrucci´on externa.
En conclusi´on, este ciclo itera mientras el valor de la condici´on sea
verdadero.
Es importante tener presente que todo ciclo debe terminar de ejecutarse
cuando cumpla con la tarea para la cual fue dise˜nado, para ello dentro de
su cuerpo se encuentra la Instrucci´on modificadora de condici´on (l´ınea 7)
cuyo prop´osito es cambiar el estado de la condici´on. De omitir la instrucci´on
modificadora, se obtendr´a lo que se conoce como un “Ciclo infinito”, debido
a que su ejecuci´on “nunca termina”. Aunque en la forma general est´a
representada de ´ultima en la secuencia de instrucciones que componen
el cuerpo del ciclo, no necesariamente debe ocupar ese lugar.
Para representar la estructura de repetici´on Mientras -
FinMientras mediante un diagrama de flujo, se usa la notaci´on que
se presenta en la Figura 4.1.

-- 185 of 450 --

184 Estructuras de repetici ´on
Instrucci´on de inicializaci´on
Condici´on
Instrucci´on 1
Instrucci´on 2
...
Instrucci´on n
Instrucci´on modificadora
de condici´on
Instrucci´on externa
S´ı
No
Figura 4.1: Forma general del ciclo Mientras - FinMientras
A continuaci´on, se ilustrar´a el funcionamiento del ciclo Mientras
- FinMientras mediante el siguiente segmento de un algoritmo que
imprime los n´umeros del 1 al 10, se explicar´a en dos versiones (segmentos
de Algoritmo 4.2 y 4.3).
Algoritmo 4.2: Imprirmir los n´umeros del 1 al 10 - Primera Versi´on
1 numero = 1
2 Mientras( numero <= 10 )
3 imprimir( numero )
4 numero = numero + 1
5 FinMientras

-- 186 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 185
Para una explicaci´on m´as clara, se identificar´an sus partes de acuerdo a
la forma general expresada en p´arrafos anteriores (Ver Tabla 4.1).
L´ınea Explicaci´on
1 Instrucci´on de inicializaci´on
2 Condici´on e inicio del ciclo
3 Cuerpo del ciclo
4 Cuerpo del ciclo e instrucci´on modificadora de condici´on
5 Fin del ciclo. Regresa el control a la l´ınea 2.
Tabla 4.1: Explicaci´on del Algoritmo 4.2
En la primera l´ınea la variable numero se inicializa en 1. Pasando a la
l´ınea 2 se encuentra la instrucci´on Mientras con su respectiva condici´on.
El cuerpo del ciclo est´a conformado por dos instrucciones (l´ıneas 3 y 4),
que se ejecutan mientras que la condici´on de la l´ınea 2 sea verdadera, es
decir, mientras el contenido de la variable numero sea menor o igual a 10.
La instrucci´on imprimir se ejecuta 10 veces, imprimiendo uno a uno
los n´umeros del 1 al 10.
La operaci´on que incluye el contador numero: numero = numero +
1, adem´as de incrementar en cada iteraci´on en 1 el valor de la variable
numero, hace el papel de la instrucci´on modificadora de condici´on, con el
prop´osito de llegar a cambiar de verdadero a falso el estado de la condici´on.
Esto lo logra en el momento que la variable tome el valor de 11, as´ı al
evaluar la condici´on (numero <= 10) se obtiene un resultado falso, con
lo cual se da por terminada la ejecuci´on del Mientras.
Debe tener en cuenta que cada problema puede tener m´ultiples
soluciones, por ejemplo, el siguiente segmento de algoritmo tambi´en
imprime los n´umeros del 1 al 10:
Algoritmo 4.3: Imprimir los n´umeros del 1 al 10 - Segunda Versi´on
1 numero = 0
2 Mientras( numero < 10 )
3 numero = numero + 1
4 imprimir( numero )
5 FinMientras
Comparando el Algoritmo 4.3 (la versi´on 2) con el Algoritmo 4.2 (la
versi´on 1) se puede observar lo siguiente:
L´ınea 1: la inicializaci´on es diferente, se hizo en 0.

-- 187 of 450 --

186 Estructuras de repetici ´on
L´ınea 2: el ciclo se ejecuta mientras el valor de numero sea menor a 10, en
lugar de menor o igual a 10, como se plante´o en la versi´on 1 del algoritmo.
Esto obedece a que la inicializaci´on fue en 0 en lugar de 1. Recuerde que
en la versi´on 1 del algoritmo la variable numero alcanza a tomar el valor
de 11, en esta nueva versi´on el valor llega hasta 10.
L´ıneas 3 y 4: se codificaron las expresiones numero = numero + 1 e
imprimir ( numero ), que son iguales a la planteadas en las l´ıneas 4 y
3 del algoritmo versi´on 1, respectivamente. En esta soluci´on fue necesario
cambiar el orden de ejecuci´on de las instrucciones del cuerpo del ciclo, ya
que si se dejaban en el orden como hab´ıan sido escritas en la versi´on 1 del
algoritmo, el resultado ser´ıa la impresi´on de los n´umeros del 0 al 9 y no
del 1 al 10 como se esperar´ıa.
L´ınea 5: la instrucci´on FinMientras retorna el control a la l´ınea 2
para que sea evaluada la condici´on y se determine si contin´uan o paran las
iteraciones.
Del anterior an´alisis se puede establecer que, de acuerdo a la
inicializaci´on de la variable que controlar´a la ejecuci´on del ciclo, se debe
prestar especial cuidado en elegir correctamente el operador relacional que
har´a parte de la condici´on del Mientras. En los segmentos de algoritmos
analizados se pudo observar lo siguiente:
numero = 0 se utiliza el operador <
numero = 1 se utiliza el operador <=
Tambi´en es fundamental tener en cuenta el orden de las instrucciones
dentro del cuerpo del ciclo, el no ubicarlas en la secuencia l´ogica
correspondiente podr´ıa dar resultados inesperados.
Aclaraci´on:
Para un mismo problema se pueden plantear
diferentes soluciones algor´ıtmicas. Por lo
tanto, su soluci´on no tiene porque ser
exactamente igual a las que se muestran en
este libro.

-- 188 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 187
Los dos anteriores segmentos de algoritmo se pueden representar
gr´aficamente con los diagramas de flujo presentados en la Figura 4.2.
Inicio
numero = 1
numero <= 10
numero
numero = numero + 1
Final
S´ı
No
Inicio
numero = 0
numero < 10
numero = numero + 1
numero
Final
S´ı
No
Figura 4.2: Diagrama de flujo Numeros
Aclaraci´on:
Las variables que intervienen en la condici´on
del ciclo deben tener un valor inicial antes de
su primera evaluaci´on.
El bloque de instrucciones o cuerpo del
ciclo, se ejecutar´a mientras el resultado de
la evaluaci´on de la condici´on sea Verdadero. Si en la primera
evaluaci´on de la condici´on del Mientras, el resultado es Falso,
las instrucciones del cuerpo del ciclo no se ejecutan.
La evaluaci´on de una expresi´on relacional o l´ogica, siempre dar´a
como resultado un valor Verdadero o Falso.

-- 189 of 450 --

188 Estructuras de repetici ´on
A continuaci´on, se dar´an algunos enunciados como ejemplo para ser
resueltos mediante la estructura repetitiva Mientras-FinMientras.
.:Ejemplo 4.1. Dise˜ne un algoritmo que permita generar e imprimir la
siguiente serie de n´umeros: 1, 3, 5, 7, 9, 11, . . . , n
El algoritmo deber´a recibir un n´umero entero (n) que indicar´a la
cantidad de t´erminos de la serie.
An´alisis del problema:
Resultados esperados: este algoritmo debe generar e imprimir la
siguiente serie: 1, 3, 5, 7, 9, 11, . . . , n
Datos disponibles: Para la soluci´on de este ejemplo se
proporcionar´a la cantidad de t´erminos que tendr´a la serie (n).
Proceso: la serie est´a conformada por n´umeros impares. El primer
t´ermino es el n´umero 1, los siguientes tienen un incremento de 2 en 2.
Para lograr la serie, debe hacerse un proceso repetitivo que terminar´a
en el momento que se complete la cantidad de t´erminos especificada.
Dentro de las instrucciones que conforman el cuerpo del ciclo se debe
imprimir cada t´ermino de la serie. As´ı mismo, se deben ir contando
los t´erminos impresos para poder determinar el fin de las iteraciones.
Variables requeridas:
• cantidadTerminos: almacena el n´umero de t´erminos que
tendr´a la serie (n).
• contadorNumeros: llevar´a el control de la cantidad de
t´erminos que se vayan imprimiendo, a la vez que se utilizar´a
en la condici´on del ciclo.
• termino: representar´a cada uno de los t´erminos de la serie que
se van generando.
De acuerdo al anterior an´alisis, se platear´a la soluci´on a trav´es de un
diagrama de flujo y luego mediante pseudoc´odigo.

-- 190 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 189
En la Figura 4.3 se muestra la soluci´on del Ejemplo 4.1 mediante un
diagrama de flujo.
Inicio
cantidadTerminos
contadorNumeros = 0
termino = 1
contadorNumeros <
cantidadTerminos - 1
termino, ", "
termino = termino + 2
contadorNumeros =
contadorNumeros + 1
termino
Final
S´ı
No
Figura 4.3: Algoritmo Serie

-- 191 of 450 --

190 Estructuras de repetici ´on
La soluci´on expresada en pseudoc´odigo es la siguiente:
Algoritmo 4.4: Serie
1 Algoritmo Serie
2 /* Este algoritmo imprime la siguiente serie, de acuerdo
3 al n´umero de t´erminos que se le especifique:
4 1, 3, 5, 7, 9, 11, ..., n
5 */
6
7 // Declaraci´on de variables
8 Entero cantidadTerminos, contadorNumeros, termino
9
10 // Dato disponible
11 imprimir( "Ingrese la cantidad de t´erminos a generar: " )
12 leer( cantidadTerminos )
13
14 // Inicializaci´on de variables
15 contadorNumeros = 0
16 termino = 1
17
18 // Generaci´on de la serie
19 // Resultados esperados
20 Mientras( contadorNumeros < cantidadTerminos - 1 )
21 imprimir( termino, ", " )
22 termino = termino + 2
23 contadorNumeros = contadorNumeros + 1
24 FinMientras
25
26 imprimir( termino )
27 FinAlgoritmo
Al ejecutar el algoritmo:
Ingrese la cantidad de t´erminos a generar: 15
1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29
Explicaci´on del algoritmo:
En este algoritmo la Instrucci´on de inicializaci´on est´a dada por tres
instrucciones. La primera se encuentra en la l´ınea 12, en donde se lee
la cantidad de t´erminos; la segunda corresponde a la inicializaci´on de
la variable contadorNumeros en 0, ubicada en la l´ınea 15. Ambas
variables hacen parte de la condici´on planteada en el Mientras. En
este caso se tiene una inicializaci´on suministrada por el usuario con la
instrucci´on leer y otra impl´ıcita en el mismo algoritmo con la asignaci´on
contadorNumeros = 0.

-- 192 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 191
La tercera inicializaci´on, se encuentra en la l´ınea 16, donde la variable
termino recibe el valor de 1, el cual corresponde al primer n´umero de la
serie a generar.
Seguidamente para lograr el proceso repetitivo se implement´o la
estructura Mientras, cuya condici´on se estableci´o as´ı:
Mientras( contadorNumeros < cantidadTerminos - 1 )
Donde contadorNumeros contar´a la cantidad de n´umeros que se van
imprimiendo, esta variable controlar´a que el ciclo se ejecute mientras su
valor sea menor al de cantidadTerminos - 1. Es necesario restar 1 a
la cantidad de t´erminos para que la impresi´on del ´ultimo n´umero no vaya
acompa˜nada de una coma. La impresi´on de este ´ultimo t´ermino se realiza
en la l´ınea 26.
Suponga que para este ejemplo se desean imprimir los primeros 15
t´erminos de la serie. En este caso la variable cantidadTerminos
almacenar´ıa dicho valor, al hacer la evaluaci´on de la condici´on
contadorNumeros < cantidadTerminos - 1, dar´ıa un resultado
verdadero ya que contadorNumeros se inicializ´o en 0.
Mientras la condici´on sea verdadera se procede a ejecutar las
instrucciones del cuerpo del ciclo (l´ıneas 20 al 22). La primera instrucci´on,
que est´a ubicada en la l´ınea 20, imprime el contenido de la variable
termino, acompa˜nado de una coma (,) y un espacio en blanco con el
fin de separarlo del siguiente n´umero, de esta manera se ir´a mostrando al
usuario la conformaci´on de la serie. El primer n´umero a imprimir es el 1.
Luego de la impresi´on se encuentra la instrucci´on termino =
termino + 2, con la cual se incrementa la variable termino en 2
unidades, ya que los t´erminos de la serie tienen este comportamiento
(inician en 1 y se van incrementando de 2 en 2: 1, 3, 5, 7, 11, . . . ).
Como ´ultima instrucci´on del cuerpo del ciclo se tiene la
instrucci´on contadorNumeros = contadorNumeros + 1, que tiene
como prop´osito ir contando la cantidad de n´umeros que se imprimen y a
la vez es la variable que sirve para controlar el n´umero de iteraciones del
ciclo. De acuerdo a la forma general presentada anteriormente para el ciclo
Mientras, esta es la instrucci´on modificadora de condici´on.
Despu´es de incrementar el contador de los n´umeros se encuentra la
instrucci´on FinMientras, la cual devuelve el control al inicio del ciclo,
es decir, a la instrucci´on Mientras, donde una vez m´as se eval´ua la

-- 193 of 450 --

192 Estructuras de repetici ´on
condici´on (l´ınea 19). Mientras el valor de la condici´on sea Verdadero
continuar´a la repetici´on del cuerpo del ciclo. En el momento que la variable
contadorNumeros alcance el valor de la variable cantidadTerminos
- 1 el valor de la condici´on ser´a Falso y el control lo asume la instrucci´on
que est´a por debajo del FinMientras, la cual imprime el ´ultimo termino,
para luego pasar al final de la ejecuci´on del algoritmo (FinAlgoritmo).
Buena pr´actica:
Es aconsejable que los contadores inicien en el valor
de 0, salvo en aquellas soluciones que exigen un valor
diferente.
.:Ejemplo 4.2. Un profesor de Fundamentos de Programaci´on, desea que
le dise˜nen un algoritmo con el cu´al se pueda determinar cu´antos de sus
estudiantes, de uno de sus grupos, aprobaron o reprobaron la materia, as´ı
mismo desea conocer el promedio general del grupo. Se considera que la
materia es aprobada con una nota m´ınima de 3.0.
Para esta tarea el profesor posee el c´odigo de cada estudiante y la nota
definitiva que obtuvo en la materia.
An´alisis del problema:
Resultados esperados: de acuerdo al enunciado, se espera que el
algoritmo informe los siguientes datos:
• Cantidad de estudiantes que aprobaron la materia.
• Cantidad de estudiantes que reprobaron la materia.
• Promedio general del grupo.
Datos disponibles: en este problema se conocen tres datos que
deben ser proporcionados por el usuario del algoritmo para su
correcta ejecuci´on. El primero es el c´odigo de cada estudiante, el
segundo es la nota definitiva de la materia cada uno de ellos; aunque
en el enunciado no est´a expl´ıcito, se infiere que se tiene claridad
sobre la cantidad de estudiantes del grupo, este ser´ıa el tercer dato
de entrada que se le debe proporcionar al algoritmo para solucionar
el problema.

-- 194 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 193
Proceso: para poder determinar la cantidad de estudiantes que
aprobaron y reprobaron la materia se requiere el uso de dos
contadores, uno para cada caso. Recuerde que la f´ormula general
de un contador es la siguiente:
contador = contador + valorIncrementar
Para el caso espec´ıfico de este ejemplo, el valor a incrementar tendr´a
un valor de 1, el cual corresponde a cada uno de los estudiantes que
aprobaron o reprobaron la materia.
Adicionalmente se debe calcular el promedio general del grupo. Todo
promedio involucra tres valores:
promedio = sumatoria / cantidad
En este ejemplo la sumatoria es la suma de todas las notas
definitivas de los estudiantes, y la cantidad est´a representada por
el n´umero de estudiantes del curso.
De lo anterior se deduce que es necesario una f´ormula adicional, con
la cual se pueda calcular la sumatoria. Para este caso, se usar´a la
forma general del c´alculo de un acumulador, concepto analizado en
el numeral 4.1.2:
acumulador = acumulador + valorIncrementar
El acumulador est´a representado por la sumatoria y el valor a
incrementar por la nota definitiva de cada estudiante:
sumatoria = sumatoria + notaDefinitiva
En esta parte del an´alisis de la soluci´on del problema, se puede
determinar que ya se tienen establecidos los c´alculos necesarios para
su soluci´on. Pero falta determinar cu´ales de todas estas instrucciones
van antes, dentro y despu´es del ciclo.
Una posible soluci´on es la siguiente: despu´es de la declaraci´on de las
variables, se debe solicitar el n´umero de estudiantes a los cuales se
les va a procesar la nota, este dato determinar´a el n´umero de veces
que se debe ejecutar el ciclo. Luego se inicializan los contadores y los
acumuladores necesarios. Seguidamente se debe establecer el ciclo y
su respectiva condici´on.
Dentro de las instrucciones del cuerpo del ciclo se debe solicitar el
c´odigo del estudiante y la nota definitiva en la materia.

-- 195 of 450 --

194 Estructuras de repetici ´on
Una vez se tenga el valor de la nota definitiva se puede determinar
si aprob´o o reprob´o la materia; para ello se har´a uso del ´arbol de
decisi´on de la Figura 4.4.
¿notaDefinitiva >= 3.0?
Incrementar contador aprobaron
s´ı
Incrementar contador reprobaron
no
Figura 4.4: ´	Arbol de decisi´on del Ejemplo 4.2
Otra instrucci´on que debe estar dentro del ciclo, es la que acumula
la sumatoria de las notas definitivas de cada estudiante.
Cuando se termine con la ejecuci´on del ciclo, se calcular´a el promedio
general del grupo; finalmente se mostrar´an los resultados que solicita
el enunciado.
Variables requeridas:
• cantidadEstudiantes: determinar´a cu´antas veces debe
ejecutarse el ciclo.
• codigoEstudiante: identifica el estudiante a procesar.
• notaDefinitiva: nota obtenida por el estudiante que se est´a
procesando en el momento.
• contadorEstudiantes: llevar´a el control del n´umero de
estudiantes que se van procesando, a la vez se utilizar´a en la
condici´on del ciclo.
• aprobaron: es un contador que se incrementar´a cuando la nota
definitiva obtenida en la materia sea mayor o igual a 3.0.
• reprobaron: es un contador que se incrementar´a cuando la
nota definitiva obtenida en la materia sea menor a 3.0.
• sumaDefinitivas: acumulador que llevar´a la sumatoria de
las notas definitivas.
• promedioGrupo: una vez finalizado el ciclo se usar´a para
calcular el promedio general del grupo.
Con el anterior an´alisis, se establece la soluci´on (Ver Algoritmo 4.5).

-- 196 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 195
Algoritmo 4.5: Estudiantes
1 Algoritmo Estudiantes
2 /* De una cantidad de estudiantes se determina cu´antos
3 aprobaron y reprobaron la materia.
4 Adicionalmente se calcula el promedio general.
5 */
6
7 // Declaraci´on de variables
8 Real notaDefinitiva, sumaDefinitivas, promedioGrupo
9 Entero cantidadEstudiantes, contadorEstudiantes
10 Entero aprobaron, reprobaron
11 Cadena codigoEstudiante
12
13 // Entrada de datos
14 imprimir( "Ingrese la cantidad de estudiantes: " )
15 leer( cantidadEstudiantes )
16
17 // Inicializaci´on de variables
18 contadorEstudiantes = 0
19 aprobaron = 0
20 reprobaron = 0
21 sumaDefinitivas = 0
22
23 // Inicia el proceso repetitivo
24 Mientras( contadorEstudiantes < cantidadEstudiantes )
25 imprimir( "Ingrese el c´odigo del estudiante: " )
26 leer( codigoEstudiante )
27 imprimir( "Ingrese la nota definitiva: " )
28 leer( notaDefinitiva )
29
30 Si( notaDefinitiva >= 3.0 ) Entonces
31 aprobaron = aprobaron + 1
32 SiNo
33 reprobaron = reprobaron + 1
34 FinSi
35
36 sumaDefinitivas = sumaDefinitivas + notaDefinitiva
37 contadorEstudiantes = contadorEstudiantes + 1
38 FinMientras
39
40 // Calculo necesario para el promedio
41 promedioGrupo = sumaDefinitivas / cantidadEstudiantes
42
43 // Resultados esperados
44 imprimir( "La cantidad que aprobaron es: ", aprobaron )
45 imprimir( "La cantidad que reprobaron es: ", reprobaron )
46 imprimir( "El promedio es: ", promedioGrupo )
47 FinAlgoritmo

-- 197 of 450 --

196 Estructuras de repetici ´on
Explicaci´on del algoritmo:
En este algoritmo fue necesario trabajar conjuntamente con una
estructura condicional Si-FinSi (l´ıneas 30 a la 34) y una
estructura repetitiva Mientras-FinMientras (l´ıneas 24 a la 38).
Como se observa la instrucci´on Si-FinSi est´a dentro del ciclo
Mientras-FinMientras, es decir forma parte de su cuerpo.
La instrucci´on Mientras se utiliza para lograr que el conjunto de
instrucciones que conforman su cuerpo se ejecuten un determinado n´umero
de veces. La instrucci´on Si-FinSi ser´a la responsable de determinar, en
cada iteraci´on, si la materia fue o no aprobada.
La cantidad de veces que se repetir´a el ciclo, estar´a determinada por el
valor que digite el usuario (l´ıneas 14 y 15):
14 imprimir( "Ingrese la cantidad de estudiantes: " )
15 leer( cantidadEstudiantes )
De lo anterior, se deduce que se est´a hablando de un ciclo cuyas
iteraciones est´an controladas por un contador, como se evidencia en la
condici´on planteada en el Mientras (l´ınea 24):
24 Mientras( contadorEstudiantes < cantidadEstudiantes )
Donde, contadorEstudiantes es una variable de control que llevar´a
la cuenta del n´umero de estudiantes a los que se les vaya procesando la
nota (l´ınea 37). Para ello se utiliza la siguiente expresi´on:
37 contadorEstudiantes = contadorEstudiantes + 1
Dentro de la forma general que se explic´o para el ciclo Mientras,
esta operaci´on representa la instrucci´on modificadora de condici´on; en
cada iteraci´on que se haga, su contenido se incrementar´a en 1. Cuando
el contenido de la variable contadorEstudiantes sea igual al de la
variable cantidadEstudiantes, el ciclo terminar´a.
Despu´es de la instrucci´on FinMientras (l´ınea 38) se efect´ua una
divisi´on para calcular el promedio general del grupo (l´ınea 41). Esta
operaci´on se debe realizar por fuera del ciclo, una vez se terminen sus
iteraciones:
41 promedioGrupo = sumaDefinitivas / cantidadEstudiantes
Como observaci´on adicional a la soluci´on algor´ıtmica presentada
para este ejemplo, se debe tener en cuenta que la variable

-- 198 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 197
cantidadEstudiantes, que act´ua como divisor en la anterior
expresi´on, recibir´a su valor por parte del usuario del algoritmo; en el caso de
que le asignen como valor el 0, esta operaci´on generar´a un error, puesto que
la divisi´on entre 0 no est´a definida. Es responsabilidad de los dise˜nadores
de algoritmos o de programas de computador evitar que se generen errores
en la ejecuci´on de los mismos.
Dado lo anterior, se puede mejorar el funcionamiento de este algoritmo
incluyendo las siguientes l´ıneas, en reemplazo de la instrucci´on de la l´ınea