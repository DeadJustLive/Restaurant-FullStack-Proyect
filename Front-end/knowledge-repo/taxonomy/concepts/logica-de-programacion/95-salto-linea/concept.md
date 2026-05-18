# SALTO LINEA

## Fuente
logica-de-programacion (Cap. 95)

## Contenido
# SALTO LINEA

Final
No
S´ı
S´ı
No
Figura 4.34: Diagrama de flujo del Algoritmo Alfabeto

-- 290 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 289
.:Ejemplo 4.23. Construya una soluci´on algor´ıtmica que simule el
comportamiento de un reloj digital para un d´ıa; con horas, minutos y
segundos. Debe trabajarse con un formato de 24 horas.
An´alisis del problema:
Resultados esperados: mostrar la simulaci´on de un reloj digital
en un formato de 24 horas: HH:MM:SS.
Datos disponibles: para este ejemplo no se requiere que sea
ingresado ning´un valor. Sin embargo, es de conocimiento general que
un minuto tiene 60 segundos y que una hora tiene 60 minutos.
Proceso: se deben dise˜nar 3 ciclos anidados. El externo controlar´a
las horas, el del medio los minutos y el m´as interno los segundos. La
hora debe iniciar desde 0 e ir hasta 23; los minutos y segundos ir´an
desde 0 hasta 59, cada que uno de ellos llegue a 59 se cambiar´a a la
hora o minuto siguiente, respectivamente.
Variables requeridas:
• hora: ser´a el ´ındice para el ciclo externo, tomar´a valores entre
0 y 23.
• minuto: almacena valores entre 0 y 59, esta variable controlar´a
el ciclo del medio.
• segundo: con valores entre 0 y 59, se usar´a para controlar el
ciclo interno.
De acuerdo al an´alisis planteado, se propone el Algoritmo 4.37.
Algoritmo 4.37: Reloj
1 Algoritmo Reloj
2 // Declaraci´on de variables
3 Entero hora, minuto, segundo
4
5 // Simulaci´on del reloj
6 Para hora = 0 Hasta 23 Incremento 1
7 Para minuto = 0 Hasta 59 Incremento 1
8 Para segundo = 0 Hasta 59 Incremento 1
9 imprimir( hora, ":", minuto, ":", segundo )
10 FinPara
11 FinPara
12 FinPara
13 FinAlgoritmo

-- 291 of 450 --

290 Estructuras de repetici ´on
Explicaci´on del algoritmo:
Con base al an´alisis realizado, se codificaron 3 ciclos anidados.
La forma de operar de estos 3 ciclos es muy sencilla. El ciclo externo
inicializa la variable hora en 0, luego el control lo asume el ciclo
intermedio que inicializa la variable minuto en 0 y le entrega el control
al ciclo interno que inicializa la variable segundo en 0; este ´ultimo
ciclo ejecuta la instrucci´on imprimir( hora, ":", minuto, ":",
segundo ). Se hacen 60 iteraciones de esta instrucci´on, de acuerdo a lo
especificado en el algoritmo:
8 Para segundos = 0 Hasta 59 Incremento 1
9 imprimir( hora, ":", minuto, ":", segundo )
10 FinPara
Cuando la variable segundo tome el valor de 60, la condici´on
(segundo <= 59) termina la ejecuci´on de este ciclo interno. De
acuerdo a lo descrito, en este momento se observa la siguiente salida del
algoritmo:
00:00:00
00:00:01
00:00:02
...
00:00:59
En el momento que el ciclo interno deja de ejecutarse, el control vuelve
a asumirlo el ciclo intermedio, incrementando el valor de minuto en 1
unidad. La condici´on (minuto <= 59) vuelve a ser verdadera y el
ciclo interno vuelve a tomar protagonismo, repiti´endose todo el proceso
explicado en los p´arrafos anteriores.
Teniendo en cuenta que la variable minuto tiene almacenado el valor
de 1, en este momento, los resultados de la instrucci´on imprimir son los
siguientes:
00:01:00
00:01:01
00:01:02
...
00:01:59
Cuando la variable minuto se incremente 60 veces, se pasar´a el control
al ciclo externo, donde se incrementa la variable hora en 1. Seguidamente
se pasa, una vez m´as, el control al ciclo intermedio, inicializando la variable
minuto en 0 y ejecut´andose su cuerpo de ciclo. El control lo toma el ciclo

-- 292 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 291
interno, se inicializa la variable segundo en 0 y se inicia el proceso de
mostrar los segundos y minutos para una nueva hora.
Todo este proceso termina cuando las condiciones de los tres ciclos den
un resultado falso, en forma simult´anea. La ´ultima salida que imprime el
algoritmo es:
23:59:59
En la Figura 4.35 se muestra la soluci´on del Ejemplo 4.23 mediante un
diagrama de flujo.
Inicio
23
hora=0
+1
59
minuto=0
+1
59
segundo=0
+1
hora, minuto, segundo
Final
S´ı
No
S´ı
No
S´ı
No
Figura 4.35: Diagrama de flujo del Algoritmo Reloj

-- 293 of 450 --

292 Estructuras de repetici ´on
.:Ejemplo 4.24. Se requiere de un algoritmo que le permita a un ni˜no
repasar las tablas de multiplicar, del 1 al 20. El ni˜no podr´a indicar que tabla
desea repasar y el algoritmo empezar´a a preguntar los resultados, desde la
fila uno hasta la fila 10; si la respuesta es correcta se mostrar´a un mensaje
de felicitaciones, en caso contrario mostrar´a el resultado, acompa˜nado de
un mensaje que informe la situaci´on.
Por cada tabla que el ni˜no repase se debe dar una calificaci´on, de acuerdo
al n´umero de respuestas correctas (por cada respuesta correcta se asigna
un punto), basada en la escala de la Tabla 4.12.
Aciertos Valoraci´on
De 0 a 5 Insuficiente
6 o 7 Aceptable
8 o 9 Sobresaliente
10 Excelente
Tabla 4.12: Tabla de valoraci´on - Ejercicio 4.24
El ni˜no podr´a repasar la cantidad de veces que as´ı lo quiera.
An´alisis del problema:
Resultados esperados: un mensaje de acuerdo a la respuesta d
