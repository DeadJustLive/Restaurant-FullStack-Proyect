# 9. Algoritmos.

a) Para los siguientes enunciados realice el an´alisis y el dise˜no
del algoritmo (utilizando la forma de descripci´on narrada) que
permita realizar las acciones que a continuaci´on se listan:
Adquirir un libro a trav´es de una librer´ıa virtual.
Descargar un v´ıdeo de YouTube.
Calcular cu´anto dinero se gastar´a el d´ıa de ma˜nana.
Invitar a un amigo a desayunar en la cafeter´ıa.
Desplazarse desde su casa a un centro comercial.
b) Si el lector es un estudiante universitario, tambi´en realice los
siguientes ejercicios, los cuales le permitir´an familiarizarse con
los procesos de su instituci´on educativa. Tenga en cuenta que,
si no los conoce, deber´a realizar las consultas necesarias:
Solicitar la homologaci´on de un espacio acad´emico.
Realizar un proceso de validaci´on de un espacio acad´emico.
Cancelar materias y semestre.
Realizar un pr´estamo de un libro en la biblioteca.
Realizar una consulta bibliogr´afica en las bases de datos de
la biblioteca.
Solicitar una cita en el Centro M´edico de Bienestar
Institucional.

-- 79 of 450 --



-- 80 of 450 --

Cap´ıtulo 2
Estructura secuencial
La mayor´ıa de los buenos
programadores programan no
porque esperan que les pagen o
que el p´ublico los adore, sino
porque programar es divertido.
Linus Torvalds
Objetivos del cap´ıtulo:
Analizar problemas en los que se puedan
aplicar estructuras algor´ıtmicas secuenciales
para su soluci´on.
Construtir algoritmos en pseudoc´odigo y
diagramas de flujo para resolver problemas con
la estructura algor´ıtmica secuencial.
Realizar pruebas de escritorio para verificar el
funcionamiento de los algoritmos construidos.

-- 81 of 450 --



-- 82 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 81
En este cap´ıtulo se estudiar´an algoritmos sencillos a trav´es de
los cuales se resolver´an problemas, inicialmente de baja complejidad;
Estos algoritmos se escribir´an en pseudoc´odigo y luego tendr´an su
representaci´on a trav´es de diagramas de flujo. Para escribir estos algoritmos
en pseudoc´odigo, es necesario utilizar las palabras reservadas vistas
anteriormente, principalmente las palabras Algoritmo, FinAlgoritmo,
leer e imprimir, as´ı como la utilizaci´on de variables, constantes,
operadores y expresiones ya expuesto en el cap´ıtulo anterior.
De acuerdo con [Joyanes A., 1996], un algoritmo secuencial es aquel en
el que una acci´on sigue a otra acci´on en la secuencia de instrucciones. “La
secuenciaci´on es una estructura que permite controlar la ejecuci´on de un
conjunto de acciones en orden secuencial; esto es, ejecuta la primera acci´on,
luego la que sigue y as´ı sucesivamente hasta la ´ultima” [L´opez, 2009].
Todo algoritmo secuencial consta de tres secciones: La primera de ellas
corresponde a “las entradas” (de los datos disponibles), en la cual se
identifican e ingresan al algoritmo los datos que se conocen y son necesarios
para resolver el problema. La segunda secci´on es la denominada “Procesos”
o c´alculos, donde se implementan las operaciones que encontrar´an los
resultados que se espera obtendr´a el algoritmo. La tercera y ´ultima secci´on
ser´a la de “salidas” (Resultados esperados), en la que se mostrar´an los
resultados que se encontraron en la secci´on anterior y ser´a lo que debe
entregar como respuesta el algoritmo a quien lo utilice.
2.1. Estructura b´asica de un algoritmo secuencial
Con el fin de tener una manera formal para expresar los algoritmos,
tanto en pseudoc´odigo como en diagramas de flujo, se va a utilizar la
notaci´on especificada en el apartado ”Forma general de un algor´ıtmo
en pseudoc´odigo”del cap´ıtulo anterior donde se explicaron los elementos
fundamentales para escribir los algoritmos con pseudoc´odigo.
Recuerde que los algoritmos empiezan con un nombre que los identifica.
Se recomienda que este nombre est´e directamente relacionado con su
funcionalidad del algoritmo, es decir, que el nombre exprese lo que este
hace.
Es recomendable que, el nombre del algoritmo comience por un
sustantivo en singular y con su primera letra en may´uscula. Puede estar
compuesto de varias palabras que ir´an unidas, cada una de ellas iniciando
con letra en may´uscula.

-- 83 of 450 --

82 Estructura secuencial
De la misma forma, se utilizar´a la notaci´on para los diagramas de flujo
estudiada tambi´en en el cap´ıtulo anterior en el apartado ”Diagramas de
flujo.”
A continuaci´on, se exponen algunos ejemplos para ilustrar la estructura
algor´ıtmica secuencial, primero su enunciado, luego un an´alisis del
problema, su soluci´on en pseudoc´odigo y, por ´ultimo, el diagrama de flujo.
Aclaraci´on:
Cuando se ingresan a un algoritmo los
datos necesarios para producir los resultados
esperados, es decir, se ingresan los datos
conocidos en el problema, es probable que se
entren datos err´oneos o de otros tipos de datos
diferentes a los esperados, lo que producir´a un
error en la ejecuci´on del algoritmo. En los algoritmos que se tratan en
este cap´ıtulo, se dar´a por sentado que el usuario siempre ingresa los
datos adecuados y no datos err´oneos. Si bien es cierto que tambi´en
puede evitarse el ingreso de datos err´oneos a un algoritmo, lo que
se conoce como validaci´on, este tema est´a fuera del alcance de los
primeros cap´ıtulos de este libro.
.:Ejemplo 2.1. Suponga que la oficina de tesorer´ıa de una empresa requiere
de un algoritmo que le permita calcular el salario a pagar a un empleado.
Imagine que a este empleado le pagan de acuerdo con el n´umero de horas
que haya laborado durante el periodo a raz´on de un valor espec´ıfico cada
hora.
An´alisis del problema:
Resultados esperados: se espera que el algoritmo pueda
determinar el valor del salario a pagar al empleado fruto de las horas
que labor´o y, que este resultado pueda ser mostrado a quien utiliza
el algoritmo.
Datos disponibles: quien vaya a utilizar el algoritmo, deber´a saber
el n´umero de horas que haya laborado el empleado durante el periodo
y, el valor de la hora para este empleado.
Proceso: para obtener el salario a pagar, es necesario escribir una
expresi´on en la que se multiplique el n´umero de horas laboradas por

-- 84 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 83
el valor de la hora. Este resultado deber´a asignarse a una variable.
Lo anterior corresponde al proceso o c´alculo que debe hacerse en este
algoritmo.
Variables requeridas:
• numeroHoras: almacena la cantidad de horas que labor´o el
empleado.
• valorHora: valor a pagar por cada hora de trabajo.
• salarioPagar: valor a pagar al empleado.
De acuerdo al an´alisis planteado, se propone el Algoritmo 2.1.
Algoritmo 2.1: SalarioEmpleado
1 Algoritmo SalarioEmpleado
2
3 // Este algoritmo permite calcular el salario de un
4 // empleado con base en las horas laboradas y el valor
5 // de la hora.
6
7 Entero numeroHoras
8 Real valorHora, salarioPagar
9
10 imprimir( "Ingrese el n´umero de horas laboradas: " )
11 leer( numeroHoras )
12
13 imprimir( "Ingrese el valor de la hora: " )
14 leer( valorHora )
15
16 salarioPagar = numeroHoras * valorHora
17
18 imprimir( "El salario a pagar es: ", salarioPagar )
19 FinAlgoritmo
Al ejecutar el algoritmo:
Primera ejecuci´on:
Ingrese el n´umero de horas laboradas: 10
Ingrese el valor de la hora: 45000
El salario a pagar es: 450000
Segunda ejecuci´on:
Ingrese el n´umero de horas laboradas: 48
Ingrese el valor de la hora: 22500
El salario a pagar es: 1080000

-- 85 of 450 --

84 Estructura secuencial
Aclaraci´on:
En todos los ejemplos del libro se presenta
la secci´on “Explicaci´on del algoritmo”, que
tiene como fin ayudar a comprender el
pseudoc´odigo propuesto. Como estrategia
para facilitar la explicaci´on, se retoman
algunas partes del algoritmo y se explican
paso a paso. Sin embargo, en los algoritmos que se presentan mas
adelante, se omitir´an aquellas explicaciones que ya se hayan hecho
previamente.
Explicaci´on del algoritmo:
La primera secci´on del algoritmo se utiliza para declarar las variables
que se necesitan en la soluci´on, indicando adem´as del nombre el respectivo
tipo de dato.
7 Entero numeroHoras
8 Real valorHora, salarioPagar
La sentencia imprimir que aparece dos veces: al principio del algoritmo
permite imprimir mensajes que se mostrar´an para que el usuario sepa qu´e
datos debe ingresar.
10 imprimir( "Ingrese el n´umero de horas laboradas: " )
11 leer( numeroHoras )
12
13 imprimir( "Ingrese el valor de la hora: " )
14 leer( valorHora )
Luego se calcula el valor del salario a pagar mediante el producto del
n´umero de horas laboradas por el valor de la hora.
16 salarioPagar = numeroHoras * valorHora
Finalmente, ser´a mostrado por la ´ultima sentencia imprimir el salario
a pagar.
18 imprimir( "El salario a pagar es: ", salarioPagar )
En la Figura 2.1 se muestra la soluci´on del Ejemplo 2.1 mediante un
diagrama de flujo.

-- 86 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 85
Inicio
numeroHoras
valorHora
salarioPagar =
numeroHoras
* valorHora
“El salario a pagar
es: ”, salarioPagar
Final
Figura 2.1: Diagrama de flujo del Algoritmo SalarioEmpleado
.:Ejemplo 2.2. Elabore un algoritmo que, a partir del valor del radio de
un c´ırculo, permita calcular tanto su ´area como su per´ımetro.
Este es un problema t´ıpico en Geometr´ıa b´asica que consiste en calcular
tanto el ´area como el per´ımetro de un c´ırculo aplicando las f´ormulas
matem´aticas que existen para obtener estos resultados. Para poder aplicar
las f´ormulas, es necesario conocer el valor del radio del c´ırculo al que se le
va a calcular ´area y per´ımetro. Tambi´en es necesario el uso de la constante
PI equivalente de manera muy aproximada a 3.1416.
Recuerde que la f´ormula para obtener el ´area de un c´ırculo es P I ∗radio2.
Por su parte, la f´ormula del per´ımetro es 2 ∗ P I ∗ radio.
An´alisis del problema:
Resultados esperados: se pretende que, al terminar de ejecutarse
el algoritmo, este haya encontrado el ´area y el per´ımetro del c´ırculo
y, que estos resultados se muestren al usuario.
Datos disponibles: para resolver este problema y poder obtener el
´area y el per´ımetro de un c´ırculo cualquiera, es necesario conocer el
radio del mismo; por tanto, cuando se va a aplicar este algoritmo, se
requiere saber el radio.

-- 87 of 450 --

86 Estructura secuencial
Proceso: los procesos consistir´an en las instrucciones necesarias
para hallar el ´area y el per´ımetro del c´ırculo. Tenga en cuanta que,
tanto para encontrar el ´area como el per´ımetro, deber´a aplicar las
f´ormulas matem´aticas, que tendr´an que ser escritas como expresiones
algor´ıtmicas.
Variables requeridas:
• radio: distancia del centro del c´ırculo al exterior.
• area: valor del ´area del c´ırculo.
• perimetro: valor de la longitud del c´ırculo.
De acuerdo al an´alisis planteado, se propone el Algoritmo 2.2.
Algoritmo 2.2: Circulo
1 Algoritmo Circulo
2
3 // Mediante este algoritmo se puede calcular el ´area y
4 // el per´ımetro de un c´ırculo cualquiera conociendo su
5 // radio.
6
7 Real radio, area, perimetro
8 Constante Real PI = 3.1416
9
10 imprimir( "Ingrese el radio del c´ırculo: " )
11 leer( radio )
12
13 area = PI * radio ˆ 2
14 perimetro = 2 * PI * radio
15
16 imprimir( "El ´area del c´ırculo es: ", area )
17 imprimir( "El per´ımetro del c´ırculo es:", perimetro )
18 FinAlgoritmo
Al ejecutar el algoritmo:
Ingrese el radio del c´ırculo: 4
El ´area del c´ırculo es: 50.2656
El per´ımetro del c´ırculo es: 25.1328
Explicaci´on del algoritmo:
El algoritmo comienza con la declaraci´on de las variables y la constante
que se requieren, tanto para almacenar el radio de la circunferencia como
para almacenar los c´alculos del area y el perimetro. Estas variables son
de tipo Real, pues almacenar´an n´umeros, incluso con decimales.

-- 88 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 87
7 Real radio, area, perimetro
8 Constante Real PI = 3.1416
Con la instrucci´on imprimir se muestra el mensaje solicitando el
radio, mientras que con leer se captura el dato y se asigna en la
respectiva variable radio.
10 imprimir( "Ingrese el r´adio del c´ırculo: " )
11 leer( radio )
Posteriormente, se calculan ´area y per´ımetro a partir de las f´ormulas
matem´aticas que involucran la constante PI.
13 area = PI * radio ˆ 2
14 perimetro = 2 * PI * radio
Por ´ultimo, se utiliza nuevamente la instrucci´on para mostrar los
resultados.
16 imprimir( "El ´area del c´ırculo es: ", area )
17 imprimir( "El per´ımetro del c´ırculo es:", perimetro )
En la Figura 2.2 se muestra la soluci´on del Ejemplo 2.2 mediante un
diagrama de flujo.
Aclaraci´on:
Note que en el diagrama de flujo que resuelve
este ejercicio y que aparece a continuaci´on,
las instrucciones de salida no muestran los
mensajes exactamente como est´an escritos en
el pseudoc´odigo, sino que aparecen solo los
nombres de las variables; mientras que en
otros diagramas del libro, ambos textos coinciden (pseudoc´odigo y
diagrama de flujo). El tener o no los mensajes no afecta en ´ultimas la
estructura de la soluci´on, as´ı que por simplicidad, en algunos casos
se omiten.

-- 89 of 450 --

88 Estructura secuencial
Inicio
radio
area = PI * radioˆ2
perimetro = 2 * PI * radio
area
perimetro
Final
Figura 2.2: Diagrama de flujo del Algoritmo Circulo
.:Ejemplo 2.3. Elabore un algoritmo que, a partir de un n´umero ingresado,
se calculen y muestren los resultados que arroajn las principales funciones
del lenguaje algor´ıtmico para ese n´umero. Este ejercicio pretende ilustrar
la operatividad de las principales funciones matem´aticas disponibles en
el lenguaje algor´ıtmico y que fueron mencionadas en el apartado de las
palabras reservadas. Estas funciones operan sobre un n´umero Real que
el usuario debe ingresar; las funciones que se utilizan proporcionan las
respuestas que se piden.
An´alisis del problema:
Resultados esperados: una vez ejecutado el algoritmo, se espera
que se muestren el seno, el coseno, la tangente, la ra´ız cuadrada, el
logaritmo natural y el logaritmo en base 10 del n´umero ingresado por
el usuario.
Datos disponibles: se debe tener disponible el n´umero al que se le
van a realizar las operaciones.
Proceso: luego de que se haya ingresado el n´umero, se utilizan las
funciones matem´aticas, una a una, pas´andoles el n´umero como dato
necesario para que puedan hacer el c´alculo; este c´alculo se almacena
en variables que se mostrar´an al final del algoritmo.

-- 90 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 89
Variables requeridas:
• numero: valor a procesar
• seno: valor de la funci´on seno sobre el valor
• coseno: valor de la funci´on coseno sobre el valor
• tangente: valor de la funci´on tangente sobre el valor
• raiz: valor de la funci´on ra´ız cuadrada sobre el valor
• logaritmoNatural: valor de la funci´on logaritmo natural
sobre el valor
• logaritmo10: valor de la funci´on logaritmo en base 10.
De acuerdo al an´alisis planteado, se propone el Algoritmo 2.3.
Algoritmo 2.3: UsoFunciones
1 Algoritmo UsoFunciones
2
3 /* Mediante este algoritmo se ilustra
4 el uso de varias funciones matem´aticas
5 disponibles en el lenguaje algor´ıtmico
6 y en los difentes lenguajes de programaci´on
7 */
8
9 Real numero, seno, coseno, tangente
10 Real raiz, logaritmoNatural, logaritmo10
11
12 imprimir( "Ingrese un n´umero: " )
13 leer( numero )
14
15 seno = sen( numero )
16 coseno = cos( numero )
17 tangente = tan( numero )
18 raiz = raizCuadrada( numero )
19 logaritmoNatural = ln( numero )
20 logaritmo10 = log( numero )
21
22 imprimir( "Del n´umero ", numero )
23 imprimir( "Su seno es ", seno )
24 imprimir( "Su coseno es ", coseno )
25 imprimir( "Su tangente es ", tangente )
26 imprimir( "Su ra´ız cuadrada es ", raiz )
27 imprimir( "Su logaritmo natural es ", logaritmoNatural )
28 imprimir( "Su logaritmo en base 10 es ", logaritmo10 )
29 FinAlgoritmo

-- 91 of 450 --

90 Estructura secuencial
Al ejecutar el algoritmo:
Ingrese un n´umero: 25
Del n´umero 25
Su seno es -0.13235175009777303
Su coseno es 0.9912028118634736
Su tangente es -0.13352640702153587
Su raiz cuadrada es 5.0
Su logaritmo natural es 3.2188758248682006
Su logaritmo en base 10 es 1.3979400086720377
Explicaci´on del algoritmo:
El algoritmo empieza como todos los algoritmos anteriores, declarando
las variables que se necesitan.
6 Real numero, seno, coseno, tangente
7 Real raiz, logaritmoNatural, logaritmo10
Posteriormente, se solicita mediante la instrucci´on imprimir el n´umero
requerido para hacer los c´alculos y se captura en la variable numero con
la instrucci´on leer.
9 imprimir( "Ingrese un n´umero: " )
10 leer( numero )
A continuaci´on, se usan las funciones matem´aticas para obtener los
resultados deseados y almacenarlos en las variables destinadas para este
fin.
12 seno = sen( numero )
13 coseno = cos( numero )
14 tangente = tan( numero )
15 raiz = raizCuadrada( numero )
16 logaritmoNatural = ln( numero )
17 logaritmo10 = log( numero )
Por ´ultimo, se muestran los resultados obtenidos con la instrucci´on
imprimir.
19 imprimir( "Del n´umero ", numero )
20 imprimir( "Su seno es ", seno )
21 imprimir( "Su coseno es ", coseno )
22 imprimir( "Su tangente es ", tangente )
23 imprimir( "Su ra´ız cuadrada es ", raiz )
24 imprimir( "Su logaritmo natural es ", logaritmoNatural )
25 imprimir( "Su logaritmo en base 10 es ", logaritmo10 )
En la Figura 2.3 se muestra la soluci´on del Ejemplo 2.3 mediante un
diagrama de flujo.

-- 92 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 91
Inicio
numero
seno = sen ( numero )
coseno = cos ( numero )
tangente = tan ( numero )
raiz = raizCuadrada ( numero )
logaritmoNatural = ln ( numero )
logaritmo10 = log ( numero )
numero
seno
coseno
tangente
raiz
logaritmoNatural
logaritmo10
Final
Figura 2.3: Diagrama de flujo del Algoritmo UsoFunciones

-- 93 of 450 --

92 Estructura secuencial
.:Ejemplo 2.4. En el acuerdo al que han llegado profesor y estudiantes para
la asignatura de Introducci´on a la l´ogica de programaci´on, se determin´o que
se obtendr´ıan 4 notas parciales durante el semestre y que, la nota definitiva
para la asignatura ser´ıa la media aritm´etica de esas 4 notas. Suponiendo
que un estudiante ya conoce las 4 notas, construya un algoritmo que
determine cu´al ser´ıa la nota definitiva de ese estudiante en la asignatura
de Introducci´	on a la l´	ogica de programaci´	on.
Aclaraci´on:
Este es el problema t´ıpico que tienen los estudiantes
para calcular la nota definitiva de una asignatura.
Cuando la definitiva se calcula a trav´es de la media
aritm´etica, es necesario sumar las notas que se han
obtenido y dividir esa suma en el n´umero de notas.
Para este caso en particular, se deben sumar las 4 notas y luego
dividir entre 4; sin embargo, existe otra forma de calcular y es por el
promedio ponderado en donde las notas tiene porcentajes diferentes.
Tenga en cuenta que, la forma en que se calcula la definitiva de
los estudiantes bien puede ser distinta, no con media aritm´etica,
sino con media ponderada; cuando se habla de media ponderada, se
est´a asignando un grado de importancia distinta a cada nota, por
ejemplo, la primera nota podr´ıa tener mayor grado de importancia
que la segunda nota y, la tercera nota podr´ıa valer menos que la
cuarta.
En el apartado de ejercicios propuestos, se retoma este ejercicio pero,
el lector deber´a resolverlo utilizando una media ponderada.
An´alisis del problema:
Resultados esperados: luego de ejecutar el algoritmo, se deber´a
obtener la nota definitiva de la asignatura, para que, tanto profesor
como estudiante la puedan conocer.
Datos disponibles: para poder calcular la nota definitiva, se debe
conocer el valor de cada una de las 4 notas parciales que se obtuvieron
durante el semestre.

-- 94 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 93
Proceso: el proceso para este ejercicio, consiste en calcular la media
aritm´etica de las 4 notas parciales; esto se logra sumando primero
las notas y, posteriormente, dividiendo entre el n´umero de notas, que
para este caso es 4.
Variables requeridas:
• nota1: valor de la primera nota.
• nota2: valor de la segunda nota.
• nota3: valor de la tercera nota.
• nota4: valor de la cuarta nota.
• definitiva: valor de la nota final (promedio de las cuatro
notas).
De acuerdo al an´alisis planteado, se propone el Algoritmo 2.4.
Algoritmo 2.4: DefinitivaEstudiante
1 Algoritmo DefinitivaEstudiante
2 /* Este algoritmo calcula la nota definitiva de un
3 estudiante a partir de 4 notas parciales a trav´es
4 de la media aritm´etica. */
5
6 Real nota1, nota2, nota3, nota4, definitiva
7
8 imprimir( "Ingrese la nota 1 del estudiante: " )
9 leer( nota1 )
10
11 imprimir( "Ingrese la nota 2 del estudiante: " )
12 leer( nota2 )
13
14 imprimir( "Ingrese la nota 3 del estudiante: " )
15 leer( nota3 )
16
17 imprimir( "Ingrese la nota 4 del estudiante: " )
18 leer( nota4 )
19
20 definitiva = (nota1 + nota2 + nota3 + nota4) / 4
21
22 imprimir( "La definitiva es: ", definitiva )
23 FinAlgoritmo

-- 95 of 450 --

94 Estructura secuencial
Al ejecutar el algoritmo:
Ingrese la nota 1 del estudiante: 3.8
Ingrese la nota 2 del estudiante: 4.4
Ingrese la nota 3 del estudiante: 5.0
Ingrese la nota 4 del estudiante: 2.0
La nota definitiva es: 3.8
Explicaci´on del algoritmo:
Al principio del algoritmo se declararon las cinco variables necesarias,
todas de tipo Real, ya que tendr´an que almacenar n´umeros de esas
caracter´ısticas.
6 Real nota1, nota2, nota3, nota4, definitiva
Luego, con las instrucciones imprimir y leer, se solicitan los datos y
se almacenan en las variables que representan las notas.
8 imprimir( "Ingrese la nota 1 del estudiante: " )
9 leer( nota1 )
10
11 imprimir( "Ingrese la nota 2 del estudiante: " )
12 leer( nota2 )
13
14 imprimir( "Ingrese la nota 3 del estudiante: " )
15 leer( nota3 )
16
17 imprimir( "Ingrese la nota 4 del estudiante: " )
18 leer( nota4 )
Posteriormente, se hace el c´alculo de la media de las 4 notas, realizando
la suma de las mismas y luego dividiendo entre la cantidad de notas (en
este caso 4); se utiliza el par´entesis con el fin de garantizar que primero
se realice la suma y posteriormente la divisi´on, conforme a la prioridad o
jerarqu´ıa de operaciones.
20 definitiva = (nota1 + nota2 + nota3 + nota4) / 4
El resultado de este c´alculo se almacena en la variable definitiva.
Para finalizar, se muestra la nota definitiva calculada con la
instrucci´on imprimir.
22 imprimir( "La definitiva es: " , definitiva )
En la Figura 2.4 se muestra la soluci´on del Ejemplo 2.4 mediante un
diagrama de flujo.

-- 96 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 95
Inicio
nota1
nota2
nota3
nota4
definitiva = (nota1
+ nota2 + nota3
+ nota4) / 4
definitiva
Final
Figura 2.4: Diagrama de flujo del Algoritmo DefinitivaEstudiante
.:Ejemplo 2.5. Construya un algoritmo que permita calcular el valor de los
intereses ganados por una cantidad de dinero invertida en un Certificado
de Dep´osito a T´ermino (CDT) en un banco o entidad financiera durante
un periodo de tiempo (en d´ıas), de acuerdo con la siguiente f´ormula:
valorIntereses = (cantidad ∗ porcentajeInteres ∗ periodo)/360
El algoritmo debe determinar tambi´en el valor total a retirar por el
cliente que invirti´o en el CDT al final del periodo, suponiendo que sobre
los intereses ganados hay un descuento del 7 % por concepto del impuesto
de retenci´on en la fuente.
An´alisis del problema:
Resultados esperados: al finalizar la ejecuci´on del algoritmo, se
debe mostrar el valor de los intereses ganados por el CDT durante
el periodo de tiempo, el descuento por concepto de impuesto de
retenci´on en la fuente y el valor total a retirar por el cliente.
Datos disponibles: se requiere conocer: La cantidad a ingresar en

-- 97 of 450 --

96 Estructura secuencial
el CDT, el periodo de tiempo en d´ıas y el porcentaje de inter´es que
se va a aplicar.
Proceso: luego de que el usuario haya ingresado los datos requeridos,
se debe calcular el valor de los intereses generados aplicando la
f´ormula dada en el enunciado del ejercicio, luego sacarle el 7 % de
impuesto al valor de los intereses reci´en calculados y, por ´ultimo,
sumar la cantidad ingresada con el valor de los intereses y restar el
valor de los impuestos obtenidos.
Variables requeridas:
• cantidad: valor total de dinero en el CDT
• periodo: plazo a que se desea hacer el CDT
• porcentajeInteres: tasa de inter´es del CDT
• valorIntereses: valor real del inter´es calculado a partir de
los datos ingresados.
• valorImpuesto: valor de los impuestos a pagar
• netoPagar: valor total a pagar.
Aclaraci´on:
Note que para poder resolver los ejercicios que se
plantean, es necesario tener una clara comprensi´on
del problema; esto implica hacer un an´alisis que
permita entender aquello de lo que se est´a hablando.
Lo anterior es imprescindible en la resoluci´on de
cualquier tipo de problemas. Por lo anterior, a continuaci´on se lleva
a cabo una breve explicaci´on de lo que es un CDT.
Un Certificado de Dep´osito a T´ermino es un producto que ofrecen
los bancos y que le permite a los clientes ahorrar de una forma
diferente en una cuenta bancaria. El CDT se abre con una cantidad
de dinero, por un periodo de tiempo determinado y recibe unos
intereses durante ese periodo, al t´ermino del cual, el cliente recibe
su dinero m´as el valor de los intereses ganados. Para obtener el valor
de los intereses ganados, es necesario aplicar la f´ormula expuesta
anteriormente.

-- 98 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 97
De acuerdo al an´alisis planteado, se propone el Algoritmo 2.5.
Algoritmo 2.5: CdtBancario
1 Algoritmo CdtBancario
2
3 // Algoritmo que calcula el valor a pagar en un CDT
4 // luego de un periodo de tiempo ingresado en d´ıas.
5
6 Real cantidad, porcentajeInteres, valorIntereses,
7 valorImpuesto, netoPagar
8 Entero periodo
9
10 imprimir( "Ingrese la cantidad de dinero: " )
11 leer( cantidad )
12
13 imprimir( "Ingrese el periodo en d´ıas: " )
14 leer( periodo )
15
16 imprimir( "Ingrese el porcentaje de inter´es: " )
17 leer( porcentajeInteres )
18
19 valorIntereses = (cantidad * porcentajeInteres/100 *
periodo)/360
20 valorImpuesto = valorIntereses * 0.07
21 netoPagar = cantidad + valorIntereses - valorImpuesto
22
23 imprimir( "Intereses ganados ", valorIntereses )
24 imprimir( "Valor del impuesto ", valorImpuesto )
25 imprimir( "Total a pagar al cliente ", netoPagar )
26 FinAlgoritmo
Al ejecutar el algoritmo:
Ingrese la cantidad de dinero: 1000000
Ingrese el periodo en d´ıas: 360
Ingrese el porcentaje(\ %) de inter´es: 6
Intereses ganados: 60000.0
Valor del impuesto: 4200.0
Total a pagar al cliente 1055800.0
Explicaci´on del algoritmo:
Luego de declarar las variables:
6 Real cantidad, porcentajeInteres, valorIntereses,
7 valorImpuesto, netoPagar
8 Entero periodo

-- 99 of 450 --

98 Estructura secuencial
Se solicitan al usuario, con la instrucci´on imprimir los datos que
requiere el algoritmo: cantidad de dinero, porcentaje1 de inter´es y periodo;
10 imprimir( "Ingrese la cantidad de dinero: " )
11 leer( cantidad )
12
13 imprimir( "Ingrese el periodo en d´ıas: " )
14 leer( periodo )
15
16 imprimir( "Ingrese el porcentaje de inter´es: " )
17 leer( porcentajeInteres )
Con estos datos, se calcula el valor de los intereses ganados multiplicando
la cantidad por el porcentaje (dividido entre 100.00) y por el periodo y,
dividiendo todo esto en 360, ya que es la cantidad de d´ıas que tiene el a˜no
comercial. Al valor de los intereses obtenidos en la instrucci´on anterior, se
le aplica el 7 % o 0.07 para determinar el valor a pagar por concepto de
impuesto de retenci´on en la fuente.
19 valorIntereses = (cantidad * porcentajeInteres/100 *
periodo)/360
20 valorImpuesto = valorIntereses * 0.07
21 netoPagar = cantidad + valorIntereses - valorImpuesto
Por ´ultimo, se suman la cantidad, el valor de los intereses y se resta el
valor del impuesto con el fin de obtener el total o neto a pagarle al cliente.
Los resultados obtenidos son mostrados a trav´es de las instrucciones finales
con imprimir.
23 imprimir( "Intereses ganados ", valorIntereses )
24 imprimir( "Valor del impuesto ", valorImpuesto )
25 imprimir( "Total a pagar al cliente ", netoPagar )
.:Ejemplo 2.6. Se requiere construir un algoritmo al que se le ingrese un
n´umero entero de 3 cifras (Por ejemplo, 927 o 483). El algoritmo deber´a
determinar el valor de la suma de las 3 cifras, 18 para el primer ejemplo
y 15 para el segundo ejemplo.
An´alisis del problema:
Resultados esperados: luego de ejecutar el algoritmo, este debe
entregar la suma de los tres d´ıgitos del n´umero ingresado.
1Note que en la ejecuci´on, el porcentaje se ingresa como un n´umero entre 1 y 100 y
que en la f´ormula es convertido a un n´umero entre 0 y 1 dividi´endolo por 100.

-- 100 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 99
Datos disponibles: para este ejercicio, se debe tener un n´umero
cualquiera de 3 d´ıgitos.
Proceso: el algoritmo debe descomponer el n´umero de 3 d´ıgitos
ingresado para obtener cada d´ıgito por separado y luego hacer la
suma de los mismos. La obtenci´on de cada d´ıgito se realiza haciendo
una divisi´on, ya sea entera o modular. Por ejemplo, para obtener el
primer d´ıgito, se divide el n´umero de tres cifras en 100, esto har´a que
se obtenga el primer n´umero ya que ser´a la parte entera de la divisi´on.
El segundo d´ıgito se obtendr´a realizando una divisi´on entera entre 10
del n´umero de tres cifras y luego, este resultado parcial dividi´endolo
en 10 mediante el operador m´odulo. Por su parte, el tercer d´ıgito se
obtendr´a haciendo una divisi´on modular del n´umero de tres cifras en
10.
Variables requeridas:
• numero: valor num´erico de tres cifras que ser´a procesado
• digito1: primera cifra del numero.
• digito2: segunda cifra del numero.
• digito3: tercera cifra del numero.
• suma: valor que corresponde a la suma de los tres t´ermicos.
Aclaraci´on:
Por ahora, es necesario suponer que el dato ingresado
al algoritmo es un n´umero de 3 d´ıgitos y no uno con
un n´umero de d´ıgitos diferente.
De acuerdo al an´alisis planteado, se propone el Algoritmo 2.6.
Algoritmo 2.6: SumaDigitosNumero
1 Algoritmo SumaDigitosNumero
2
3 // Este algoritmo obtiene la suma de los 3 d´ıgitos que
4 // componen un n´umero
5
6 Entero numero, digito1, digito2, digito3, suma
7
8 imprimir ( "Ingrese un n´umero entero de tres d´ıgitos ")
9 leer( numero )
10
11 digito1 = numero / 100

-- 101 of 450 --

100 Estructura secuencial
12 digito2 = (numero / 10) % 10
13 digito3 = numero % 10
14 suma = digito1 + digito2 + digito3
15
16 imprimir( "La suma de los tres d´ıgitos de " , numero,
17 " es ", suma)
18 FinAlgoritmo
Al ejecutar el algoritmo:
Ingrese un n´umero entero de tres d´ıgitos: 927
La suma de los tres d´ıgitos de 927 es 18
Explicaci´on del algoritmo:
Al principio del algoritmo (l´ınea 6), se declaran las variables que se van
a utilizar: una para almacenar el n´umero; tres para los d´ıgitos y una ´ultima
para almacenar la suma.
6 Entero numero, digito1, digito2, digito3, suma
Se solicita el ´unico dato disponible (numero).
8 imprimir ( "Ingrese un n´umero entero de tres d´ıgitos ")
9 leer( numero )
Luego se procede a realizar los c´alculos que determinan los resultados
esperados:
11 digito1 = numero / 100
12 digito2 = (numero / 10) % 10
13 digito3 = numero % 10
14 suma = digito1 + digito2 + digito3
Con la instrucci´on digito1 = numero / 100, el n´umero se divide
en 100 y como resultado se obtiene la parte entera que ser´a el primer d´ıgito,
que es almacenado en digito1. Con la instrucci´on digito2 = (numero /
10) % 10, se obtiene el segundo d´ıgito de la siguiente forma: el numero al
ser dividido entre 10 entrega como resultado los dos primeros d´ıgitos que,
luego al ser divididos en % 10 retornar´a como resultado su residuo, es decir,
el segundo d´ıgito del n´umero. La instrucci´on digito3 = numero % 10,
entrega como resultado el residuo de esta divisi´on, esto es, el tercer d´ıgito.
Posteriormente, se suman los tres d´ıgitos y su resultado se almacena en
la variable suma que ser´a mostrada con la instrucci´on para imprimir el
mensaje.

-- 102 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 101
En la Figura 2.5 se muestra la soluci´on del Ejemplo 2.6 mediante un
diagrama de flujo.
Inicio
numero
digito1 = numero / 100
digito2 = (numero / 10) % 10
digito3 = numero % 10
suma = digito1 + digito2 + digito3
suma
Final
Figura 2.5: Diagrama de flujo del Algoritmo SumaDigitosNumero
.:Ejemplo 2.7. Los empleados asalariados en Colombia deben realizar un
aporte a seguridad social que consiste en un 4 % para la salud y un 4 % para
la pensi´on. Dise˜ne un algoritmo que permita calcular el valor del aporte
que debe realizar un empleado a salud y a pensi´on sobre el salario base,
que determine el total del descuento por estos conceptos y cu´al ser´ıa el
valor del salario neto que recibir´ıa el empleado luego de que le realicen los
descuentos.
An´alisis del problema:
Resultados esperados: cuando se haya ejecutado el algoritmo, este
entregar´a como resultados el valor a aportar por salud, por pensi´on,
la suma de estos y el salario neto que recibir´a el empleado.
Datos disponibles: se debe conocer el salario base del empleado.
Proceso: se debe calcular el valor del aporte a salud y pensi´on, cada
uno de ellos equivalente al 4 % sobre el salario base. Se debe obtener

-- 103 of 450 --

102 Estructura secuencial
el total que le descontar´an al empleado, que ser´a la suma del valor de
los aportes calculados previamente. Por ´ultimo, se debe calcular el
salario neto a pagar que ser´a la resta entre el salario base ingresado
por el usuario y el descuento que le hacen al empleado.
Variables requeridas:
• salarioBase: valor del salario sin descuentos.
• aporteSalud: valor del aporte a salud.
• aportePension: valor del aporte de pensi´on.
• descuento: valor del descuento.
• salarioNeto: valor del salario con los descuentos.
Aclaraci´on:
La seguridad social es un aporte que hacen tanto los
empleadores como los empleados. A estos ´ultimos les
toca aportar un 4 % de su salario para salud y un
4 % para pensi´on. Estos aportes son descontados del
salario base para hacer los respectivos pagos a las
empresas que prestan estos servicios, por lo que el salario neto debe
contemplar el descuento de estos valores. Por ejemplo, suponiendo
que un Empleado recibe como salario base 1000000 (un mill´on de
pesos), el descuento por salud corresponde a 40000, lo mismo que el
descuento por pensi´on; as´ı, el salario neto que recibir´ıa el empleado
ser´ıa de 920000 (novecientos veinte mil pesos).
De acuerdo al an´alisis planteado, se propone el Algoritmo 2.7.
Algoritmo 2.7: SeguridadSocial
1 Algoritmo SeguridadSocial
2 // Este algoritmo calcula el valor del aporte por salud y
3 // pensi´on que se hacen sobre el salario base de un
4 // empleado y determina el valor total de estos descuentos
5 // y el salario neto a pagar al empleado
6
7 Real salarioBase, aporteSalud, aportePension,
8 descuento, salarioNeto
9
10 imprimir( "Ingrese el salario base del empleado " )
11 leer( salarioBase )
12
13 aporteSalud = salarioBase * 0.04
14 aportePension = salarioBase * 0.04

-- 104 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 103
15 descuento = aporteSalud + aportePension
16 salarioNeto = salarioBase - descuento
17
18 imprimir( "El aporte a salud es de " , aporteSalud )
19 imprimir( "El aporte a pensi´on es de " , aportePension )
20 imprimir( "El descuento es de " , descuento )
21 imprimir( "El salario neto a pagar es " , salarioNeto )
22 FinAlgoritmo
Al ejecutar el algoritmo:
Ingrese el salario base del empleado 1000000
El aporte a salud es de 40000
El aporte a pensi´on es de 40000
El descuento es de 80000
El salario neto a pagar es 920000
Explicaci´on del algoritmo:
En principio, se declaran las variables necesarias para almacenar el dato
que se va a ingresar:
7 Real salarioBase, aporteSalud, aportePension,
8 descuento, salarioNeto
Posteriormente, se solicita el ingreso del salario base que gana el
empleado,
10 imprimir( "Ingrese el salario base del empleado " )
11 leer( salarioBase )
Luego se calculan los aportes que corresponden al 4 % cada uno; note
que en la operaci´on se utiliza el valor de 0.04. Cada descuento se calcula
en una l´ınea separada, una para el aporte a salud y otra para el aporte a
pensi´on.
13 aporteSalud = salarioBase * 0.04
14 aportePension = salarioBase * 0.04
Enseguida, se determina el descuento que corresponde a la suma de los
aportes.
15 descuento = aporteSalud + aportePension
Por ´ultimo, se obtiene el salario neto restando del salario base el
descuento.
16 salarioNeto = salarioBase - descuento

-- 105 of 450 --

104 Estructura secuencial
Finalmente, se imprimen los datos calculados.
18 imprimir( "El aporte a salud es de " , aporteSalud )
19 imprimir( "El aporte a pensi´on es de " , aportePension )
20 imprimir( "El descuento es de " , descuento )
21 imprimir( "El salario neto a pagar es " , salarioNeto )
En la Figura 2.6 se muestra la soluci´on del Ejemplo 2.7 mediante un
diagrama de flujo.
Inicio
salarioBase
aporteSalud = salarioBase * 0.04
aportePension = salarioBase * 0.04
descuento = aporteSalud + aportePension
salarioNeto = salarioBase - descuento
aporteSalud
aportePension
descuento
salarioNeto
Final
Figura 2.6: Diagrama de flujo del Algoritmo SeguridadSocial

-- 106 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 105
.:Ejemplo 2.8. Se requiere construir un algoritmo que, al ingresarle un
n´umero de d´ıas cualquiera, este permita saber cu´antos minutos y cu´antos
segundos tiene la cantidad de d´ıas ingresados. Para ello, es imprescindible
saber cu´antos minutos tiene un d´ıa, as´ı como tambi´en el n´umero de
segundos contenidos en cada d´ıa, esto se puede obtener al multiplicar el
n´umero de d´ıas que se ingresaron por la cantidad de horas que tiene cada
d´ıa (24) y a su vez, por la cantidad de minutos que tiene cada hora (60) y
por la cantidad de segundos que tiene un minuto (60).
An´alisis del problema:
Resultados esperados: cuando se haya ejecutado el algoritmo, este
entregar´a como resultados la cantidad de minutos contenidos en el
n´umero de d´ıas ingresados, as´ı como la cantidad de segundos.
Datos disponibles: se debe conocer el n´umero de d´ıas que van a
ser convertidos.
Proceso: para obtener la cantidad de minutos que tienen los d´ıas
ingresados, se crea una expresi´on aritm´etica que multiplique los d´ıas
por 24 horas que tiene cada d´ıa y luego por 60 minutos que tiene
cada hora. Para obtener la cantidad de segundos, solo hace falta
multiplicar los minutos obtenidos por 60.
Variables requeridas:
• numeroDias: cantidad de d´ıas.
• numeroMinutos: cantidad de minutos.
• numeroSegundos: cantidad de segundos.
Aclaraci´on:
Muchos problemas algor´ıtmicos consisten en realizar
alg´un tipo de conversi´on, por ejemplo, podr´ıa
necesitarse convertir una cantidad de dinero de una
moneda de un pa´ıs a otra de otro pa´ıs, convertir una
longitud que se encuentra en una unidad de medida
a otra, convertir una temperatura que est´a en una escala de medida
en otra. Este ejercicio es un ejemplo prototipo de conversi´on. Para
poder realizar un ejercicio de conversi´on, se hace necesario conocer
el equivalente de una medida con respecto a la otra, de esta manera,
ser´a posible construir una expresi´on que facilite hacer la conversi´on.

-- 107 of 450 --

106 Estructura secuencial
De acuerdo al an´alisis planteado, se propone el Algoritmo 2.8.
Algoritmo 2.8: ConversionDias
1 Algoritmo ConversionDias
2
3 // Este algoritmo encuentra la cantidad de minutos
4 // contenidos en un determinado n´umero de d´ıas,
5 // as´ı como la cantidad de segundos.
6
7 Entero numeroDias, cantidadMinutos, cantidadSegundos
8
9 imprimir( "Ingrese el n´umero de d´ıas: " )
10 leer( numeroDias )
11
12 cantidadMinutos = numeroDias * 24 * 60
13 cantidadSegundos = cantidadMinutos * 60
14
15 imprimir( numeroDias, " d´ıas equivalen a: " )
16 imprimir( cantidadMinutos, " Minutos" )
17 imprimir( cantidadsegundos, " Segundos" )
18 FinAlgoritmo
Al ejecutar el algoritmo:
Ingrese el n´umero de d´ıas: 2
2 D´ıas equivalen a:
2880 Minutos
172800 Segundos
Explicaci´on del algoritmo:
Este algoritmo inicia como todos, declarando las variables necesarias.
7 Entero numeroDias, cantidadMinutos, cantidadSegundos
Posteriormente, se solicita el dato con el que se va a realizar la conversi´on,
este dato es el n´umero de d´ıas.
9 imprimir( "Ingrese el n´umero de d´ıas: " )
10 leer( numeroDias )
Una vez se tiene el n´umero de d´ıas, se procede a realizar el primer c´alculo
que consiste en determinar la cantidad de minutos; para ello, se multiplican
los d´ıas por 24 (ya que cada d´ıa tiene 24 horas) y este resultado se multiplica
a su vez por 60 (pues cada hora tiene 60 minutos). Para conocer la cantidad
de minutos que tienen los d´ıas ingresados, basta con multiplicar la cantidad
de minutos ya obtenidos en el c´alculo anterior por 60 (puesto que cada
minuto consta de 60 segundos).

-- 108 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 107
12 cantidadMinutos = numeroDias * 24 * 60
13 cantidadSegundos = cantidadMinutos * 60
Para finalizar el algoritmo, se muestran los resultados solicitados con la
instrucci´on imprimir.
15 imprimir( numeroDias, " d´ıas equivalen a: " )
16 imprimir( cantidadMinutos, " Minutos" )
17 imprimir( cantidadsegundos, " Segundos" )
En la Figura 2.7 se muestra la soluci´on del Ejemplo 2.8 mediante un
diagrama de flujo.
Inicio
numeroDias
cantidadMinutos = numeroDias * 24 * 60
cantidadSegundos = cantidadMinutos * 60
numeroDias, “dias equivale a: ”
cantidadMinutos
cantidadsegundos
Final
Figura 2.7: Diagrama de flujo del Algoritmo ConversionDias
.:Ejemplo 2.9. Construya un algoritmo que permita encontrar las dos
soluciones reales a una ecuaci´on algebraica de segundo grado a partir de
la f´ormula general. Suponga por ahora que el ejercicio planteado no tiene
soluciones imaginarias.
F´ormula general:
x = −b ± √b2 − 4ac
2a

-- 109 of 450 --

108 Estructura secuencial
Aclaraci´on:
En ´	Algebra elemental se estudian diferentes tipos
de ecuaciones; unas de ellas son las ecuaciones de
segundo grado. Las ecuaciones de este tipo pueden
resolverse con la f´ormula general que se acaba de
presentar, conociendo por supuesto, los valores de a,
b y c, produciendo dos respuestas x1 y x2, una cuando se toma el
signo + en la f´ormula, antes del radical y la otra al tomar el signo
menos.
Las ecuaciones de segundo grado, presentan la siguiente forma, de
donde se obtienen los valores con los cuales trabajar:
ax2 + bx + c = 0
An´alisis del problema:
Resultados esperados: se espera que el algoritmo entregue como
resultados las dos respuestas a la ecuaci´on: x1 y x2, suponiendo que
son reales2.
Datos disponibles: se deben conocer los valores de a, b y c en la
ecuaci´on dada.
Proceso: luego de que se hayan ingresado los datos correspondientes
a los coeficientes de a, b y c, debe aplicarse la f´ormula general escrita
en lenguaje algor´ıtmico, una para encontrar X1 (usando el signo
+ antes del radical) y otra para encontrar X2 (usando el signo –
antes del radical). Es necesario tener en cuenta que, como la f´ormula
implica elevar al cuadrado la variable b y tambi´en obtener la ra´ız
cuadrada de una parte de la f´ormula, en ella deben usarse funciones
del lenguaje algor´ıtmico.
Variables requeridas:
• a: valor del primer coeficiente de la ecuaci´on.
• b: valor del segundo coeficiente de la ecuaci´on.
2Las ecuaciones de segundo grado tambi´en pueden dar un resultado con valores
imaginarios, pero estos escapan al ejercicio que se plantea, ya que para poder obtenerlos
ser´ıa necesario utilizar otras estructuras algor´ıtmicas que se ver´an m´as adelante en el
libro.

-- 110 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 109
• c: valor del tercer coeficiente de la ecuaci´on.
• x1: primera soluci´on de la ecuaci´on.
• x2: segunda soluci´on de la ecuaci´on.
De acuerdo al an´alisis planteado, se propone el Algoritmo 2.9.
Algoritmo 2.9: FuncionCuadratica
1 Algoritmo FuncionCuadratica
2 // Este algoritmo calcula las dos soluciones de una
3 // ecuaci´on cuadr´atica. Teniendo en cuenta que estas
4 // deben ser reales por ahora
5
6 Real a, b, c, x1, x2
7
8 imprimir( "Ingrese el primer coeficiente: " )
9 leer( a )
10
11 imprimir( "Ingrese el segundo coeficiente: " )
12 leer( b )
13
14 imprimir( "Ingrese el tercer coeficiente: " )
15 leer( c )
16
17 x1 = (-b + raizCuadrada( bˆ2 - 4 * a * c))/(2 * a )
18 x2 = (-b - raizCuadrada( bˆ2 - 4 * a * c))/(2 * a )
19
20 imprimir( "Primera soluci´on: ", x1)
21 imprimir( "Segunda soluci´on: ", x2)
22 FinAlgoritmo
Al ejecutar el algoritmo:
Ingrese el primer coeficiente: 3
Ingrese el segundo coeficiente: 8
Ingrese el tercer coeficiente: 4
Primera soluci´on -0.6666666666666666
Segunda soluci´on -2.0
Explicaci´on del algoritmo:
Para poder resolver la ecuaci´on de segundo grado, se requieren los valores
de a, b y c; raz´on por la cual se le solicita al usuario el ingreso de estos
valores.
6 Real a, b, c, x1, x2
7
8 imprimir( "Ingrese el primer coeficiente: " )
9 leer( a )

-- 111 of 450 --

110 Estructura secuencial
10
11 imprimir( "Ingrese el segundo coeficiente: " )
12 leer( b )
13
14 imprimir( "Ingrese el tercer coeficiente: " )
15 leer( c )
Luego, se convierte la f´ormula algebraica a expresi´on de computador
utilizando en ella la funci´on raizCuadrada(). Es necesario aplicar esta
f´ormula dos veces, una para encontrar el valor de x1 y otra para hallar x2.
17 x1 = (-b + raizCuadrada( bˆ2 - 4 * a * c))/(2 * a )
18 x2 = (-b - raizCuadrada( bˆ2 - 4 * a * c))/(2 * a )
Cuando ya se han obtenido estos valores, se muestran con la instrucci´on
imprimir.
20 imprimir( "Primera soluci´on: ", x1)
21 imprimir( "Segunda soluci´on: ", x2)
.:Ejemplo 2.10. Un instalador de pisos requiere saber la cantidad de cajas
de cer´amica y el costo total de las mismas, que debe comprar para colocarle
el piso a una casa o apartamento. El instalador toma las medidas con el
fin de conocer la cantidad de metros cuadrados que tiene el inmueble. Sabe
que cada caja del producto cubre un ´area de 2.26 m2 y que, de acuerdo a
las caracter´ısticas de la cer´amica que seleccione, cada caja tiene su costo
particular. Construya un algoritmo que al ingresarle la cantidad de metros
cuadrados de la casa o apartamento en la que se va a instalar el piso y el
costo de la caja de cer´amica, este permita saber cu´antas cajas debe comprar
y el costo total de las mismas.
Aclaraci´on:
Este ejercicio pretende mostrar la aplicaci´on pr´actica
de los algoritmos en el c´alculo de cantidades
de material para la construcci´on. De esta forma
se expone la necesidad de crear algoritmos para
calcular cualquier cantidad de material, incluso en la
elaboraci´on de diferentes tipos de productos. Conociendo el tama˜no
de la obra y las dimensiones de cada unidad de materia prima, se
puede obtener la cantidad de unidades a comprar, luego, conociendo
el precio de la unidad de materia prima, es posible calcular su valor.

-- 112 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 111
An´alisis del problema:
Resultados esperados: el algoritmo debe determinar el n´umero de
cajas de cer´amica a comprar y el costo total de las mismas.
Datos disponibles: se debe conocer la cantidad de metros
cuadrados que posee el inmueble (casa o apartamento) donde se va
a instalar la cer´amica y el costo de la caja de cer´amica seleccionada
para hacer la instalaci´on.
Proceso: con la cantidad de metros cuadrados se debe realizar una
divisi´on entre 2.26, que corresponde al n´umero de metros cuadrados
cubiertos por la cer´amica que trae cada caja; con esto se obtendr´a el
n´umero de cajas necesarias. Ahora, conociendo el n´umero de cajas,
se multiplica por el valor de las cajas y se obtendr´a el costo de este
material.
Variables requeridas:
• tamanioPiso: valor que representa el tama˜no del piso.
• valorCaja: valor de cada caja.
• cantidadCajas: cantidad de cajas necesarias.
• valorTotal: valor total a pagar.
De acuerdo al an´alisis planteado, se propone el Algoritmo 2.10.
Algoritmo 2.10: CeramicaPiso
1 Algoritmo CeramicaPiso
2 /* Este algoritmo determina la cantidad de cajas de
3 cer´amica que se deben comprar para instalar en
4 un inmueble y su costo total. */
5
6 Real tamanioPiso, valorCaja, cantidadCajas, valorTotal
7
8 imprimir( "Ingrese la cantidad de metros cuadrados: " )
9 leer( tamanioPiso )
10
11 imprimir( "Ingrese el valor de la caja de cer´amica: " )
12 leer( valorCaja )
13
14 cantidadCajas = tamanioPiso / 2.26
15 valorTotal = cantidadCajas * valorCaja
16
17 imprimir( "Se deben comprar " )
18 imprimir( cantidadCajas, " de cajas de cer´amica " )
19 imprimir( "Cuyo valor es ", valorTotal)
20 FinAlgoritmo

-- 113 of 450 --

112 Estructura secuencial
Al ejecutar el algoritmo:
Ingrese la cantidad de metros cuadrados: 84
Ingrese el valor de la caja de cer´amica: 20000
Se deben comprar
37.16814159292036 de cajas de cer´amica
Cuyo valor es 743362.8318584071
Explicaci´on del algoritmo:
Lo primero que se lleva a cabo en el algoritmo es la declaraci´on de las
variables a utilizar:
5 Real tamanioPiso, valorCaja, cantidadCajas, valorTotal
Luego, se solicitan los datos necesarios para realizar los c´alculos. Estos
datos son: la cantidad de metros cuadrados a instalar y el valor de la caja
de cer´amica.
7 imprimir( "Ingrese la cantidad de metros cuadrados: " )
8 leer( tamanioPiso )
9
10 imprimir( "Ingrese el valor de la caja de cer´amica: " )
11 leer( valorCaja )
Posteriormente el algoritmo procede a encontrar el n´umero de cajas,
esto se logra dividiendo los metros cuadrados a instalar en 2.26 que es la
cantidad de metros cuadrados que trae cada caja; M´as adelante se procede
a determinar el costo de las cajas que hay que comprar multiplicando la
cantidad de cajas obtenidas previamente por el valor de cada una de ellas.
13 cantidadCajas = tamanioPiso / 2.26
14 valorTotal = cantidadCajas * valorCaja
Al final, se muestran los resultados con la instrucci´on imprimir.
16 imprimir( "Se deben comprar " )
17 imprimir( cantidadCajas, " de cajas de cer´amica " )
18 imprimir( "Cuyo valor es ", valorTotal)
En la Figura 2.8 se muestra la soluci´on del Ejemplo 2.10 mediante un
diagrama de flujo.

-- 114 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 113
Inicio
tamanioPiso
valorCaja
cantidadCajas = tamanioPiso / 2.26
valorTotal = cantidadCajas * valorCaja
“Se deben comprar”
cantiadCajas, “ cajas de cer´amica”
“Cuyo valor es ”, valorTotal
Final
Figura 2.8: Diagrama de flujo del Algoritmo CeramicaPiso
2.2. Pruebas de escritorio
Estas pruebas pretenden verificar el funcionamiento del algoritmo y
encontrar posibles errores en su ejecuci´on que no dejan que el algoritmo
entregue los resultados correctos o esperados. Para [Trejos, 2004], la
prueba de escritorio es la prueba reina que permite saber si un algoritmo
hace lo que debe hacer y si produce los resultados correctos. Posterior
a la realizaci´on de las pruebas de escritorio, en el caso de encontrar
alguna inconsistencia en los resultados esperados, ser´a necesario revisar
las instrucciones con las que se dise˜n´o el algoritmo para determinar cu´al o
cu´ales de ellas son las que est´an generando el error.
Una prueba de escritorio se dise˜na de la siguiente manera:
Se seleccionan unos datos disponibles que servir´an como entrada para
el algoritmo.

-- 115 of 450 --

114 Estructura secuencial
Se hacen los respectivos c´alculos y se encuentran los resultados
esperados.
Posteriormente, se recorre el algoritmo, l´ınea por l´ınea y se va
verificando si el algoritmo hace lo que debe de hacer o no.
Se comparan los resultados que gener´o el algoritmo con los esperados
y se concluye si el algoritmo funciona correctamente o no.
En el caso de que el algoritmo no haya entregado los resultados
correctos, ser´a necesario revisar el c´odigo escrito tratando de
encontrar la instrucci´on o instrucciones que est´an causando el error.
Aclaraci´on:
Una forma de realizar la prueba de escritorio a un
algoritmo consiste en construir una tabla (llamada
tabla de verificaci´on) en la que se relacionan
las variables, primero las que reciben los datos
ingresados, luego las que almacenan los c´alculos y
por ´ultimo, las instrucciones que muestran los resultados esperados.
Si el algoritmo incluye estructuras algor´ıtmicas con condiciones, estas
deben involucrarse en la tabla en el orden en que van apareciendo
en el algoritmo.
Es recomendable ejecutar el algoritmo varias veces con diferentes
datos disponibles para determinar su comportamiento en cada
ejecuci´on.
2.2.1 Ejemplos
En la Tabla 2.1 se llevar´a a cabo la prueba de escritorio para el algoritmo
del Ejemplo 2.1, denominado SalarioEmpleado que tiene que ver con
el salario a apagar a un empleado al que le pagan de acuerdo al n´umero
de horas laboradas y al valor de la hora.
Ejecuci´on numeroHoras valorHora salarioAPagar Respuesta
1 10 30000 300000 300000
2 40 25000 1000000 1000000
3 20 27000 540000 540000
Tabla 2.1: Prueba de escritorio para el algoritmo del Ejemplo 2.1

-- 116 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 115
En la Tabla 2.2, se puede observar la prueba de escritorio para el
algoritmo del Ejemplo 2.4 denominado definitivaEstudiante:
Ejecuci´on nota1 nota2 nota3 nota4 definitiva Resultado
1 3.4 4.2 3.0 5.0 3.9 3.9
2 2.0 3.0 2.0 3.0 2.5 2.5
3 1.0 4.0 3.0 4.0 3.0 3.0
Tabla 2.2: Prueba de escritorio para el algoritmo del Ejemplo 2.4
Y en la Tabla 2.3 la prueba de escritorio para el algoritmo del ejercicio
n´umero 2.5 denominado CDTBancario.
Por limitaciones de espacio, las variables que aparecen en la Tabla 2.3
fueron renombradas de la siguiente forma:
cantidad por cant
porcentajeInteres por pInteres
valorIntereses por vIntereses
valorImpuesto por vImpuesto
netoPagar por nPagar
Ej. cant periodo pInteres vIntereses vImpuesto nPagar
1 3.4 4.2 3.0 5.0 3.9 3.9
2 2.0 3.0 2.0 3.0 2.5 2.5
3 1.0 4.0 3.0 4.0 3.0 3.0
Tabla 2.3: Prueba de escritorio para el algoritmo del Ejemplo 2.5
2.3. Ejercicios propuestos
Dise˜ne algoritmos utilizando tanto pseudoc´odigo como diagramas de
flujo para los problemas que se enuncian a continuaci´on. Una vez se hayan
construido, elabore la prueba de escritorio con la tabla de verificaci´on
para determinar si el algoritmo se ejecuta adecuadamente y entrega los
resultados esperados: