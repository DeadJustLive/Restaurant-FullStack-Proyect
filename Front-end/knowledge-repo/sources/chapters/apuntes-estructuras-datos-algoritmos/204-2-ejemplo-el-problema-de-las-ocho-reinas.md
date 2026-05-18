# 2. Ejemplo: el problema de las ocho reinas

El problema consiste en colocar ocho reinas sobre un tablero de ajedrez de forma que no se amenacen. Dos reinas
se amenazan si comparten fila, columna o diagonal.
Puesto que no puede haber más de una reina por columna, podemos replantear el problema como: “colocar una reina
en cada columna del tablero de forma que no se amenacen”. En este caso, para ver si dos reinas se amenazan basta con ver
si comparten fila o diagonal.
La siguiente decisión que debe tomarse es la representación de los datos. Esta debe permitir:
• 	interpretar la solución con facilidad, y para ello basta con tener un vector que almacene el índice de fila en que se
coloca la reina en cada columna; y
• 	decidir con facilidad si una candidata a solución de una tarea (es decir, un índice de fila en el que colocar la reina
de una columna) es aceptable o no (es decir, si existe otra reina ya colocada en la misma fila o diagonal).
Ambos objetivos se cumplen con la siguiente estructura de datos:
a:vector[1..8] de booleano; 	{a[i]=niguna reina en fila i}
b:vector[2..16] de booleano; {b[i]=ninguna reina en diagonal-/ i}
c:vector[-7..7] de booleano; {c[i]=ninguna reina en diagonal-\ i}
x:vector[1..8] de entero 	{x[i]=posición de la reina en la i-ésima columna}
Para entender los índices elegidos para los vectores b y c,
nótese que todas las casillas (con índice de columna i e
índice de fila j) de una misma diagonal de tipo ‘/’ verifican
que i+j=constante, y esta suma toma valores en el rango
2..16. Por el contrario, todas las casillas (con índice de
columna i e índice de fila j) de una misma diagonal de tipo
‘\’ verifican que i-j=constante, y esta suma toma
valores en el rango -7..7.
El siguiente algoritmo es la aplicación directa del esquema de vuelta atrás al problema de las ocho reinas en el tablero
de ajedrez, considerando la representación de información detallada anteriormente.

-- 214 of 267 --

201
procedimiento reinas
variables
i:entero;
q:booleano;
a:vector[1..8] de booleano; 	{a[i]=niguna reina en fila i}
b:vector[2..16] de booleano; {b[i]=ninguna reina en diagonal-/ i}
c:vector[-7..7] de booleano; {c[i]=ninguna reina en diagonal-\ i}
x:vector[1..8] de entero 	{x[i]=posición de la reina en la i-ésima columna}
procedimiento ensaya(ent i:entero; sal q:booleano)
variable j:entero
principio
j:=0;
repetir
j:=j+1;
q:=falso;
si a[j] and b[i+j] and c[i-j] entonces
x[i]:=j;
a[j]:=falso;
b[i+j]:=falso;
c[i-j]:=falso;
si i<8 entonces
ensaya(i+1,q);
si not q entonces
a[j]:=verdad;
b[i+j]:=verdad;
c[i-j]:=verdad
fsi
sino
q:=verdad
fsi
fsi
hastaQue q or (j=8)
fin
principio
para i:=1 hasta 8 hacer
a[i]:=verdad
fpara;
para i:=2 hasta 16 hacer
b[i]:=verdad
fpara;
para i:=-7 hasta 7 hacer
c[i]:=verdad
fpara;
ensaya(1,q);
para i:=1 hasta 8 hacer
escribir(x[i])
fpara
fin
La solución obtenida ejecutando este algoritmo es:
1 5 8 6 3 7 2 4
Esta solución es la descrita en la figura de la página anterior.