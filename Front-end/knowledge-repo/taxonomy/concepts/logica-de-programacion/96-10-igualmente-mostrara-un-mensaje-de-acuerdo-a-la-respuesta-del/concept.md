# 10. Igualmente, mostrar´a un mensaje de acuerdo a la respuesta del

## Fuente
logica-de-programacion (Cap. 96)

## Contenido
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
responda con una letra ’S’ a la pregunta: "
