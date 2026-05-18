# 10. Igualmente, mostrar´a un mensaje de acuerdo a la respuesta del

ni˜no (Ver Figura 4.36).
¿resultado correcto?
“Felicitaciones”
s´ı
“Lo siento, ese no es el resultado”
Mostrar el resultado correcto
no
Figura 4.36: ´	Arbol de decisi´on del Ejemplo 4.23 - Respuesta

-- 294 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 293
Esta misma decisi´on, servir´a para contar los aciertos o desaciertos
que el ni˜no tenga al responder.
Por ´ultimo, se espera que se informe la valoraci´on obtenida en cada
tabla de multiplicar, de acuerdo al n´umero de aciertos, para ello
se deben contemplar los rangos establecidos en la Tabla 4.12. Las
decisiones que se deben establecer se observan en la Figura 4.37.
¿aciertos <= 5?
“Insuficiente”
s´ı
¿aciertos <= 7?
“Aceptable”
s´ı
¿aciertos <= 9?
“Sobresaliente”
s´ı
“Excelente”
no
no
no
Figura 4.37: ´	Arbol de decisi´on del Ejemplo 4.23 - Valoraci´on
Todo este proceso debe anidarse dentro de otro ciclo. En este ciclo
externo, adicionalmente se debe solicitar la tabla que el ni˜no repasar´a,
se inicializan los contadores de aciertos y desaciertos; por
´ultimo se preguntar´a si se desea calcular una nueva tabla.
Variables requeridas:
• tabla: almacena el n´umero de la tabla que el ni˜no va a repasar.
• contadorFilas: esta variable contar´a las filas de cada tabla,
tomar´a valores entre 1 y 10.
• producto: en esta variable se calcula el resultado de cada fila
de la tabla.
• respuesta: almacena la respuesta que ingrese el ni˜no, como
resultado de la multiplicaci´on.
• aciertos: almacena la cuenta de las respuestas correctas.
• desaciertos: contador para las respuestas incorrectas.
• seguir: centinela para controlar el ciclo externo, recibir´a la
respuesta si se desea continuar o terminar con la ejecuci´on del
algoritmo.
En las Figuras 4.38, 4.39, 4.40 y 4.41 se muestra la soluci´on del Ejemplo
4.24 mediante un diagrama de flujo.

-- 295 of 450 --

294 Estructuras de repetici ´on
Inicio
seguir = ’S’	3
seguir == ’S’
tabla
tabla < 1 O
tabla > 20
aciertos = 0
desaciertos = 0
1
Final
S´ı
No
S´ı
No
Figura 4.38: Diagrama de flujo del Algoritmo JuegoTablas - Parte 1

-- 296 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 295
1
10
contadorFilas = 1
+1
producto = tabla ∗ contadorFilas
”Cual es el resultado de: ”,
tabla, ”x”, contadorFilas
respuesta
respuesta ==
producto
”Felicitaciones”
aciertos = aciertos + 1
”lo siento, ese no es el resultado”
”la respuesta correcta es:”,producto
desaciertos = desaciertos + 1
2
S´ı
S´ı 	No
No
Figura 4.39: Diagrama de flujo del Algoritmo JuegoTablas - Parte 2

-- 297 of 450 --

296 Estructuras de repetici ´on
2
aciertos
desaciertos
aciertos <= 5
aciertos <= 7
“Insuficiente”
aciertos <= 9
“Aceptable”
“Sobresaliente” “Excelente”
4
S´ı 	No
S´ı 	No
S´ı 	No
Figura 4.40: Diagrama de flujo del Algoritmo JuegoTablas - Parte 3

-- 298 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 297
4
seguir
seguir != ’S’ Y
seguir != ’N’
3
S´ı
No
Figura 4.41: Diagrama de flujo del Algoritmo JuegoTablas - Parte 4
El Algoritmo 4.38 es la propuesta en pseudoc´odigo para la soluci´on del
juego de las tablas de multiplicar.
Algoritmo 4.38: JuegoTablas
1 Algoritmo JuegoTablas
2 // Declaraci´on de variables
3 Entero tabla, contadorFilas, producto,
4 respuesta, aciertos, desaciertos
5 Caracter seguir
6
7 seguir = ’S’
8 Mientras( seguir == ’S’ O seguir == ’s’ )
9
10 imprimir( "Con cu´al tabla desea jugar?: " )
11 Haga
12 leer( tabla )
13 MientrasQue( tabla < 1 O tabla > 20 )
14
15 aciertos = 0
16 desaciertos = 0
17 Para contadorFilas = 1 Hasta 10 Incremento 1
18 producto = tabla * contadorFilas

-- 299 of 450 --

298 Estructuras de repetici ´on
19
20 imprimir( "Escriba el resultado de ", tabla,
21 " x ", contadorFilas )
22 leer( respuesta )
23
24 Si( respuesta == producto ) Entonces
25 imprimir( "Felicitaciones" )
26 aciertos = aciertos + 1
27 SiNo
28 imprimir( "Lo siento, ese no es el resultado" )
29 imprimir( "La respuesta correcta es: ", producto )
30 desaciertos = desaciertos + 1
31 FinSi
32 FinPara
33
34 imprimir( "Aciertos: ", aciertos )
35 imprimir( "Desaciertos: ", desaciertos )
36
37 Si( aciertos <= 5 )
38 imprimir( "Insuficiente" )
39 SiNo
40 Si( aciertos <= 7 )
41 imprimir ("Aceptable")
42 SiNo
43 Si( aciertos <= 9 )
44 imprimir( "Sobresaliente" )
45 SiNo
46 imprimir( "Excelente" )
47 FinSi
48 FinSi
49 FinSi
50
51 imprimir( "¿Desea volver a jugar [S] o [N]?: " )
52 Haga
53 leer( seguir )
54 MientrasQue( seguir != ’S’ Y seguir != ’N’ Y
55 seguir != ’s’ Y seguir != ’n’ )
56
57 FinMientras
58 FinAlgoritmo
Explicaci´on del algoritmo:
En esta soluci´on algor´ıtmica se usaron las 3 estructuras de ciclo
estudiadas en este cap´ıtulo. A cada una se le dio una funci´on acorde para
lo que est´an concebidas.
Se us´o un ciclo Mientras-FinMientras, con el prop´osito de ejecutar
repetidamente todo el proceso. Su ejecuci´on se realizar´a mientras el ni˜no

-- 300 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 299
responda con una letra ’S’ a la pregunta: "¿Desea volver a jugar
[S] o [N]?:". Esta estructura repetitiva, es el ciclo externo en este
algoritmo.
Los ciclos Haga-MientrasQue, fueron ´utiles en la validaci´on de la
entrada de los datos, por ejemplo, en la lectura del n´umero de la tabla con
que el ni˜no va a jugar, se controla que se ingrese una tabla entre 1 y 20,
requisito que fue dado en el enunciado del problema.
10 imprimir( "Con cu´al tabla desea jugar?: " )
11 Haga
12 leer( tabla )
13 MientrasQue( tabla < 1 O tabla > 20 )
De igual forma, el ciclo se utiliz´o en la validaci´on de la lectura de la
respuesta a la pregunta final, con la cual se controla que la variable seguir
acepte ´unicamente la letra ’S’ o ’N’, bien sea en may´uscula o min´uscula.
51 imprimir( "¿Desea volver a jugar [S] o [N]?: " )
52 Haga
53 leer( seguir )
54 MientrasQue( seguir != ’S’ Y seguir != ’N’ Y
55 seguir != ’s’ Y seguir != ’n’ )
Se aprovech´o la forma de operar del ciclo Para, con el fin de calcular
la tabla que el ni˜no seleccione. Este ciclo se encuentra anidado dentro
del Mientras-FinMientras externo. En el cuerpo del ciclo Para se
calcula la tabla, se le hace la pregunta al ni˜no sobre el resultado de la
multiplicaci´on y se toma la decisi´on si la respuesta fue acertada o no; en
caso afirmativo se imprime un mensaje de “Felicitaciones” y se cuenta un
acierto. En caso contrario se informa que esa no es la respuesta acertada,
se da el resultado correcto y se incrementa el contador de desaciertos.
15 aciertos = 0
16 desaciertos = 0
17 Para contadorFilas = 1 Hasta 10 Incremento 1
18 producto = tabla * contadorFilas
19
20 imprimir( "Escriba el resultado de ", tabla,
21 " x ", contadorFilas )
22 leer( respuesta )
23
24 Si( respuesta == producto ) Entonces
25 imprimir( "Felicitaciones" )
26 aciertos = aciertos + 1
27 SiNo
28 imprimir( "Lo siento, ese no es el resultado" )
29 imprimir( "La respuesta correcta es: ", producto )

-- 301 of 450 --

300 Estructuras de repetici ´on
30 desaciertos = desaciertos + 1
31 FinSi
32 FinPara
El proceso descrito en el p´arrafo anterior se ejecuta 10 veces, que
equivalen al n´umero de filas de la tabla. Una vez el ciclo Para termine
de iterar, se continua con la ejecuci´on del algoritmo en el ciclo externo, es
decir, en el ciclo Mientras-FinMientras.
Seguidamente se informan los aciertos y desaciertos.
34 imprimir( "Aciertos: ", aciertos )
35 imprimir( "Desaciertos: ", desaciertos )
Se toma la decisi´on para otorgar la calificaci´on, para ello se emple´o un
conjunto de decisiones anidadas, que son parte del cuerpo del ciclo externo
del algoritmo.
37 Si( aciertos <= 5 )
38 imprimir( "Insuficiente" )
39 SiNo
40 Si( aciertos <= 7 )
41 imprimir ("Aceptable")
42 SiNo
43 Si( aciertos <= 9 )
44 imprimir( "Sobresaliente" )
45 SiNo
46 imprimir( "Excelente" )
47 FinSi
48 FinSi
49 FinSi
Antes de finalizar las instrucciones del ciclo Mientras-FinMientras
se le pregunta al ni˜no si desea volver a jugar o no, la respuesta es
almacenada en la variable seguir; luego se encuentra el FinMientras
y el control regresa al Mientras donde se eval´ua la condici´on:
8 Mientras( seguir == ’S’ O seguir == ’s’ )
Si el resultado es verdadero, se vuelve a ejecutar todo el proceso. El
juego termina en el momento que el ni˜no responda con una letra ’N’, al
cuestionamiento si desea volver a jugar.

-- 302 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 301
.:Ejemplo 4.25. Una Universidad est´a interesada en tener una soluci´on
algor´ıtmica que le permita conocer de sus estudiantes, de primer semestre
que acaban de concluir el periodo acad´emico, la siguiente informaci´on:
El mayor y el menor promedio general.
Cantidad total de estudiantes que aprobaron y reprobaron, de igual
forma, el total de los que quedaron en situaci´on condicional.
Porcentaje de estudiantes que quedaron excluidos por bajo
rendimiento y tambi´en el porcentaje que aprobaron el periodo, con
relaci´on al total de ellos.
Por cada grupo se requiere la cantidad de estudiantes que aprobaron
y reprobaron el periodo. Los grupos son identificados como Grupo A,
Grupo B, Grupo C y as´ı sucesivamente.
Finalmente, por cada estudiante se debe informar su nota definitiva
acompa˜nada de un mensaje que especifique su situaci´on acad´emica.
Dentro del reglamento estudiantil se tienen contemplados los siguientes
aspectos: