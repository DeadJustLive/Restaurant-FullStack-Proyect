# 41. De esta forma, al calcular el promedio general del grupo se evita un

posible error de ejecuci´on:
// Se asume 0 en el promedio cuando la cantidad de
// estudiantes es 0.
Si( cantidadEstudiantes >= 1 ) Entonces
promedioGrupo = sumaDefinitivas / cantidadEstudiantes
SiNo
promedioGrupo = 0
FinSi
Esta nueva decisi´on, verificar´ıa que la cantidad de estudiantes sea
m´ınimo de 1 y as´ı poder determinar el promedioGrupo; en caso contrario,
es decir que el valor sea 0 o un valor negativo, el algoritmo asignar´ıa el valor
de 0 a la variable promedioGrupo y este ser´a el resultado que informar´ıa.
En las Figuras 4.5 y 4.6 se muestra la soluci´on del Ejemplo 4.2 mediante
un diagrama de flujo.
Buena pr´actica:
Mediante las instrucciones necesarias se debe controlar
que los algoritmos no generen errores en su ejecuci´on;
como por ejemplo, cuando se trata de realizar la
divisi´on entre 0.
Algunos lenguaje de programaci´on poseen instrucciones adecuadas
para el manejo de errores y excepciones que facilitan este tipo de
control.
Tambi´en es posible definir condiciones que se deben garantizar para
que el algoritmo funcione correctamente. A estas condiciones se les
denomina precondiciones.

-- 199 of 450 --

198 Estructuras de repetici ´on
Inicio
cantidadEstudiantes
contadorEstudiantes= 0
aprobaron = 0
reprobaron = 0
sumaDefinitivas = 0
contadorEstudiantes
< cantidadEstudiantes
2
codigoEstudiante
1
promedioGrupo = sumaDefinitivas
/ cantidadEstudiantes
aprobaron
reprobaron
promedioGrupo
Final
No
S´ı
Figura 4.5: Algoritmo Estudiantes - Parte 1

-- 200 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 199
1
notaDefinitiva
notaDefintiva
>= 3.0
aprobaron = aprobaron + 1 reprobaron = reprobaron + 1
sumaDefinitivas =
sumaDefinitivas + notaDefintiva
contadorEstudiantes =
contadorEstudiantes + 1
2
S´ı 	No
Figura 4.6: Algoritmo Estudiantes - Parte 2
.:Ejemplo 4.3. Dise˜ne un algoritmo que reciba como dato de entrada un
n´umero entero perteneciente al sistema decimal1. Si cumple la condici´on de
ser positivo, informe el n´umero de cifras que posee, adicionalmente calcule
la sumatoria de ellas; en caso contrario, imprima un mensaje que diga que
el n´umero no es positivo.
An´alisis del problema:
Resultados esperados: la cantidad de cifras que tiene el n´umero
le´ıdo y la sumatoria de ellas. Adicionalmente un mensaje en el caso
que el n´umero no sea positivo.
Datos disponibles: un n´umero entero.
Proceso: leer un n´umero entero. Tomar una decisi´on para
determinar si es positivo, en caso de serlo se deben separar cada una
de sus cifras y simult´aneamente se van sumando; en caso contrario
informar que no es positivo.
1Sistema decimal: que tiene como base el n´umero 10.

-- 201 of 450 --

200 Estructuras de repetici ´on
Se puede determinar que un n´umero es positivo con la siguiente
decisi´on (Ver Figura 4.7).
¿numero > 0?
Separar las cifras
Calcular la sumatoria
S´ı
Informar que no es positivo
No
Figura 4.7: ´	Arbol de decisi´on del Ejemplo 4.3
La descomposici´on de un n´umero entero del sistema decimal en sus
respectivas cifras, se puede realizar con divisiones enteras sucesivas
entre 10. Suponga que desea separar las cifras que tiene el n´umero
8345, para ello se hacen las siguientes operaciones:
Iteraci´on Dividendo Divisor Cociente Resto
1 8345 10 834 5
2 834 10 83 4
3 83 10 8 3
4 8 10 0 8
Tabla 4.2: Descomposici´on del n´umero 8345 en cifras
Para mayor claridad en la siguiente explicaci´on, tenga presente el
nombre de los t´erminos que intervienen en una divisi´on: dividendo,
divisor, residuo (resto) y cociente. En una divisi´on entera, al residuo
se le denomina resto.
dividendo divisor
resto cociente
Como se anot´o anteriormente, la descomposici´on de un n´umero
entero en sus cifras, se logra haciendo divisiones sucesivas. El n´umero
de veces que se repite esta operaci´on, es igual al n´umero de cifras del
n´umero a descomponer (para este ejemplo es 4). El proceso termina
cuando el cociente tome un valor de 0.

-- 202 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 201
En la primera iteraci´on que se debe realizar se hace la siguiente
operaci´on:
8 3 4 5
3 4
4 5
5
1 0
8 3 4
Observe que el resto (residuo) es 5, que corresponde a la ´ultima cifra
del n´umero, y el cociente es 834, que equivale al n´umero original sin la
´ultima cifra. Para obtener estos valores se deben hacer dos divisiones
enteras2 entre 10.
La primera divisi´on que se efecutar´a ser´a el m´odulo o resto de la
divisi´on, para ello se usa el operador %: con el cual se consigue el
resto (residuo):
8345 % 10 = 5
Con la segunda divisi´on se obtiene el cociente, el cual va tomando
el valor del n´umero original pero reducido en una cifra; ese cociente
pasa a ser el dividendo en la siguiente iteraci´on, para obtenerlo se
hace una divisi´on entera entre 10 usando el operador /:
8345 / 10 = 834
En la segunda iteraci´on se hacen las mismas operaciones, teniendo
en cuenta que el cociente obtenido en la divisi´on anterior, pasa a ser
el nuevo dividendo:
8 3 4
3 4
4
1 0
8 3
Para obtener el resto de la divisi´on se hace la siguiente operaci´on:
834 % 10 = 4
Para calcular el cociente, se realiza la divisi´on entera:
834 / 10 = 83
2Se obtienen resultados sin decimales (fracciones).

-- 203 of 450 --

202 Estructuras de repetici ´on
Una vez m´as se deben realizar las divisiones, teniendo en cuenta que
el nuevo dividendo es el cociente anterior:
8 3
3
1 0
8
Para obtener el resto de la divisi´on y el cociente se hacen las siguientes
divisiones:
83 % 10 = 3
83 / 10 = 8
Como el cociente a´un no es 0, se debe realizar una ´ultima iteraci´on:
8
8
1 0
0
Para obtener el resto de la divisi´on y el cociente se hacen las siguientes
divisiones:
8 % 10 = 8
8 / 10 = 0
De lo anterior se deduce que, para separar las cifras se deben realizar
una o varias divisiones enteras sucesivas, en donde se obtenga el
cociente de tipo entero y el residuo o resto de la divisi´on; para el
caso de este texto, esos resultados se logran usando los operadores /
y %, respectivamente.
Variables requeridas:
• numero: se usar´a para almacenar el n´umero a leer.
• copiaNumero: almacenar´a una copia del valor original del
n´umero, con el prop´osito de ir eliminando la ´ultima cifra. Esta
variable representa el cociente dentro de los t´erminos de una
divisi´on, pero tenga presente que ese cociente pasa a ser el
dividendo en la siguiente iteraci´on.
• contadorCifras: cuenta las cifras del n´umero.
• sumaCifras: acumula la sumatoria del valor de cada una de
las cifras del n´umero.

-- 204 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 203
• cifra: variable que almacena una a una las cifras en las que se
va descomponiendo el n´umero. Dentro de los t´erminos de una
divisi´on representa al residuo o al resto de la divisi´on entera.
De acuerdo al an´alisis planteado, se propone el Algoritmo 4.6.
Algoritmo 4.6: CifrasNumero
1 Algoritmo CifrasNumero
2 /* Lee un n´umero decimal (base 10). Si es positivo calcula
3 la sumatoria de sus cifras, en caso contrario informa
4 que no es un n´umero positivo.
5 */
6
7 // Declaraci´on de variables
8 Entero numero, cifra, contadorCifras, sumaCifras,
9 copiaNumero
10
11 // Se lee el dato conocido
12 imprimir( "Escriba un n´umero entero: " )
13 leer( numero )
14
15 // Determina si el n´umero es positivo
16 Si( numero > 0 ) Entonces
17 copiaNumero = numero
18 contadorCifras = 0
19 sumaCifras = 0
20
21 // Se inicia el proceso de separaci´on de las cifras
22 Mientras( copiaNumero > 0 )
23 cifra = copiaNumero % 10
24 copiaNumero = copiaNumero / 10
25 sumaCifras = sumaCifras + cifra
26 contadorCifras = contadorCifras + 1
27 FinMientras
28
29 // Resultados esperados en caso de ser positivo
30 imprimir( "La cantidad de cifras de: ", numero )
31 imprimir( "son: ", contadorCifras )
32 imprimir( "La sumatoria es: ", sumaCifras )
33 SiNo
34 // Resultado esperado si no es positivo
35 imprimir( "No es un n´umero positivo" )
36 FinSi
37 FinAlgoritmo

-- 205 of 450 --

204 Estructuras de repetici ´on
Al ejecutar el algoritmo:
Primera ejecuci´on:
Escriba un n´umero entero: 459
La cantidad de cifras de: 459 son: 3
La sumatoria es: 18
Segunda ejecuci´on:
Escriba un n´umero entero: -459
No es un n´umero positivo
Explicaci´on del algoritmo:
Al contenido de la variable numero se le hace una copia en la variable
copiaNumero, esto con el prop´osito de conservar el valor original para
poderlo imprimir con los resultados. De esta manera la descomposici´on de
cifras se hace sobre la copia y no sobre la variable numero.
Al igual que en el Ejemplo 4.2 la soluci´on del problema requiere
el uso en conjunto de la estructura condicional Si-FinSi y de la
estructura repetitiva Mientras-FinMientras, pero en esta ocasi´on el
ciclo Mientras-FinMientras hace parte del grupo de instrucciones
que se ejecutan cuando la condici´on del Si-FinSi es verdadera.
El ciclo Mientras-FinMientras en cada iteraci´on hace lo siguiente:
Eval´ua la condici´on (l´ınea 22)
Separa una cifra del n´umero (l´ınea 23)
Elimina la ´ultima cifra al n´umero (l´ınea 24)
Acumula la sumatoria de las cifras (l´ınea 25)
Cuenta las cifras (l´ınea 26)
Retorna el control al Mientras (l´ınea 27)
Todo este proceso lo realiza mientras el valor de la variable
copiaNumero sea mayor a 0.
Si al evaluar la condici´on Si(numero > 0) arroja un resultado falso, el
ciclo Mientras-FinMientras no se ejecuta, en su lugar se imprime el
mensaje: “No es un n´umero positivo”.

-- 206 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 205
Dos aspectos a resaltar en este ejemplo:
Las iteraciones del ciclo no est´an condicionadas mediante un
contador, en este caso se hacen mediante un acumulador:
22 Mientras( copiaNumero > 0 )
La instrucci´on modificadora de condici´on est´a a cargo de una divisi´on,
la cual se ejecuta de manera sucesiva mientras la condici´on sea
verdadera, reduciendo en cada iteraci´on el valor de la variable
copiaNumero:
24 copiaNumero = copiaNumero / 10
En la Figura 4.8 se muestra la soluci´on del Ejemplo 4.3 mediante un
diagrama de flujo.
Aclaraci´on:
Una estructura de decisi´on puede hacer parte del
cuerpo o conjunto de instrucciones de una estructura
de repetici´on, o viceversa.
Buena pr´actica:
Cuando los datos de entrada van a ser modificados
dentro del proceso que ejecuta el algoritmo, se debe
utilizar otra variable para copiarlos y as´ı conservar su
valor original.

-- 207 of 450 --

206 Estructuras de repetici ´on
Inicio
numero
numero > 0
copiaNumero = numero
contadorCifras = 0
sumaCifras = 0
“No es un n´umero positivo”
copiaNumero > 0
cifra = copiaNumero % 10
copiaNumero = copiaNumero / 10
sumaCifras = sumaCifras + cifra
contadorCifras = contadorCifras +1
“La cantidad de cifras de: ”, numero
“son: ”, contadorCifras
“La sumatoria es: ”, sumaCifras
Final
S´ı 	No
S´ı
No
Figura 4.8: Diagrama de flujo del Algoritmo CifrasNumero

-- 208 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 207
.:Ejemplo 4.4. Dentro del contexto de las matem´aticas recreativas3 se
encuentra el concepto de n´umero de Armstrong, tambi´en conocido como
n´umero narcisista; definido como aquel en que la suma de cada una de sus
cifras elevadas a la potencia n es igual a ´el mismo, donde n est´a dada por
la cantidad de cifras o d´ıgitos del n´umero.
Por ejemplo, el n´umero 407, que posee 3 cifras, es un Armstrong dado
que:
43 + 03 + 73 = 64 + 0 + 343 = 407
Son tambi´en n´umeros de Armstrong los siguientes: 1, 2, 3, 4, 5, 6, 7,
8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834,
1741725, entre otros
De acuerdo al anterior contexto, construya un algoritmo que reciba un
n´umero entero positivo en base 10 y determine si es o no un n´umero de
Armstrong.
An´alisis del problema:
Resultados esperados: mensaje que informe si el n´umero ingresado
es o no un Armstrong.
Datos disponibles: un n´umero entero positivo en base 10.
Proceso: la soluci´on de este problema se puede realizar con los
siguientes pasos:
• Leer un n´umero entero positivo.
• Determinar el n´umero de cifras o d´ıgitos de ese n´umero. Para
ello se usa el procedimiento explicado en el Ejemplo 4.34.
• Calcular la sumatoria de sus d´ıgitos elevados a la potencia n,
donde n estar´a determinada por el n´umero de cifras resultantes
del proceso anterior.
• Tomar una decisi´on que determine si el n´umero le´ıdo es igual a
la sumatoria mencionada en el paso anterior (Ver Figura 4.9).
3Estudio y soluci´on por puro pasatiempo de problemas y acertijos relacionados con
las matem´aticas [Bishop et al., 2004].
4Se recomienda leer el an´alisis de dicho ejemplo.

-- 209 of 450 --

208 Estructuras de repetici ´on
¿numero = sumatoria?
Es un n´umero de Armstrong
s´ı
No es un n´umero de Armstrong
no
Figura 4.9: ´	Arbol de decisi´on del Ejemplo 4.4
Variables requeridas:
• numero: almacenar´a el valor proporcionado por el usuario del
algoritmo.
• copiaNumero: en esta variable se har´a copia del valor original
del n´umero y con ella se efectuar´an los c´alculos necesarios para
la separaci´on de las cifras; as´ı se podr´a conservar el contenido
original en la variable numero.
• contadorCifras: contar´a el n´umero de d´ıgitos que tiene el
n´umero, a la vez ser´a utilizada como el valor de la potencia (n)
a la que se eleva cada uno de los d´ıgitos.
• cifra: se utilizar´a para ir almacenando las cifras o d´ıgitos que
se separen del n´umero.
• sumaCifras: en ella se calcular´a la sumatoria de las cifras
elevadas a la potencia n (contadorCifras).
En las Figuras 4.10 y 4.11 se muestra la soluci´on del Ejemplo 4.4
mediante un diagrama de flujo.
Debido a que la soluci´on es un poco extensa, fue necesario dividir el
diagrama en dos p´aginas, observe que para poder seguir el flujo se utiliz´o
un conector a otra p´agina.
Buena pr´actica:
Cuando los diagramas son muy extensos, se deben
dividir en varias partes, las cuales se enlazan con
conectores a la misma p´agina o con conectores a otra
p´agina.

-- 210 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 209
Inicio
numero
copiaNumero = numero
contadorCifras = 0
copiaNumero > 0
cifra = copiaNumero % 10
copiaNumero = copiaNumero / 10
contadorCifras = contadorCifras + 1
1
S´ı
No
Figura 4.10: Diagrama del flujo del Algoritmo Armstrong - Parte 1

-- 211 of 450 --

210 Estructuras de repetici ´on
1
sumaCifras = 0
copiaNumero = numero
copiaNumero > 0
cifra = copiaNumero % 10
copiaNumero = copiaNumero / 10
sumaCifras = sumaCifras
+ cifraˆ contadorCifras
numero ==
sumaCifras
numero,“es un n´umero
de Armstrong” numero, “no es un
n´umero de Armstrong”
Final
S´ı
No
S´ı 	No
Figura 4.11: Diagrama del flujo del Algoritmo Armstrong - Parte 2

-- 212 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 211
A continuaci´on se muestra la soluci´on a trav´es de pseudoc´odigo
(Algoritmo 4.7).
Algoritmo 4.7: Armstrong
1 Algoritmo Armstrong
2 /* Recibe un n´umero entero positivo y determina si es
3 o no un n´umero de Armstrong.
4 */
5 // Declaraci´on de variables
6 Entero numero, copiaNumero, contadorCifras, cifra,
7 sumaCifras
8
9 // Lectura del dato disponible
10 imprimir( "Escriba el n´umero a analizar: " )
11 leer( numero )
12
13 // Inicializaci´on de variables
14 // Se cuenta el n´umero de cifras del n´umero
15 contadorCifras = 0
16 copiaNumero = numero
17 Mientras( copiaNumero > 0 )
18 cifra = copiaNumero % 10
19 copiaNumero = copiaNumero / 10
20 contadorCifras = contadorCifras + 1
21 FinMientras
22
23 // Se calcula la sumatoria de sus d´ıgitos
24 // elevados a la potencia n (contadorCifras)
25 sumaCifras = 0
26 copiaNumero = numero
27 Mientras( copiaNumero > 0 )
28 cifra = copiaNumero % 10
29 copiaNumero = copiaNumero / 10
30 sumaCifras = sumaCifras + cifra ˆ contadorCifras
31 FinMientras
32
33 // Resultado esperado
34 Si( numero == sumaCifras ) Entonces
35 imprimir( numero, "es un n´umero de Armstrong." )
36 SiNo
37 imprimir( numero, " no es un n´umero de Armstrong." )
38 FinSi
39 FinAlgoritmo

-- 213 of 450 --

212 Estructuras de repetici ´on
Al ejecutar el algoritmo:
Primera ejecuci´on:
Escriba el n´umero a analizar: 1634
1634 es un n´umero de Armstrong.
Segunda ejecuci´on:
Escriba el n´umero a analizar: 14321
14321 no es un n´umero de Armstrong.
Explicaci´on del algoritmo:
En esta soluci´on se utilizan dos estructuras repetitivas Mientras-
FinMientras independientes. Cuando se habla de estructuras
independientes, se quiere decir que primero se ejecuta una completamente
y luego se procede de igual manera con la siguiente.
La primera estructura repetitiva en esta soluci´on, tiene la funci´on
de contar el n´umero de cifras o d´ıgitos que conforman al n´umero que
proporcione el usuario, de esta manera se determina el valor de la potencia
(contadorCifras) a la cual se deben elevar cada uno de los d´ıgitos.
Para ello se us´o el mismo procedimiento explicado en el Ejemplo 4.3.
La segunda instrucci´on Mientras-FinMientras del algoritmo,
calcula la sumatoria de los d´ıgitos elevados a la potencia n
(contadorCifras).
Luego de que se ejecuten los dos ciclos, se encuentra una estructura de
decisi´on Si-FinSi independiente a ellos, cuya funci´on es determinar si el
n´umero suministrado es o no un Armstrong.
Una caracter´ıstica a destacar en esta soluci´on, es que las dos estructuras
repetitivas Mientras-FinMientras tienen instrucciones similares, en
ambas se hace la separaci´on de las cifras.

-- 214 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 213
.:Ejemplo 4.5. Dise˜ne un algoritmo que calcule el M´aximo Com´un Divisor
(MCD5) y el M´ınimo Com´un M´ultiplo (mcm6) de dos n´umeros enteros
positivos, mediante el algoritmo de Euclides. El algoritmo debe permitir
hacer varios c´alculos hasta que el usuario decida que no desea continuar.
Euclides, matem´atico griego del a˜no 350 a.C, formul´o el algoritmo que
lleva su nombre y que permite encontrar el MCD y el mcm de dos n´umeros
enteros, a y b (a > b), mediante los siguientes pasos: