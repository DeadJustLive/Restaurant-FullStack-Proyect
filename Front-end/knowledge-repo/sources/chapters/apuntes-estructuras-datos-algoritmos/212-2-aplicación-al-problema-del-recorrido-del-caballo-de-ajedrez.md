# 2. Aplicación al problema del recorrido del caballo de ajedrez

Consideremos el conocido problema del recorrido del caballo de ajedrez. Consiste en encontrar una sucesión de
movimientos de forma que un caballo de ajedrez pueda visitar cada escaque (cuadro) del tablero una sola vez.
La solución más conocida se obtiene aplicando el esquema de vuelta atrás, introducido en el anexo anterior. Se utiliza
una tablero de n × n enteros (con n ≤ 8 leído interactivamente), inicialmente con todas las casillas iguales a cero (no
visitadas). El caballo parte de una posición (i,j) solicitada interactivamente. Se almacena el entero 1 en la casilla (i,j),
indicando el escaque inicial. El procedimiento ensaya realiza el siguiente movimiento posible (a una casilla no visitada).
Para ello, ensaya sucesivamente con los ocho movimientos posibles:
Cada vez que se llega a un escaque no visitado, se almacena en la casilla correspondiente del tablero el número de
escaques recorridos hasta el momento.
1 ¿Qué propiedad deben tener los valores de las diferentes monedas para que la solución voraz sea siempre óptima?
1
2	3
4
5
6 	7
8

-- 223 of 267 --

210
procedimiento caballo
variables i,j,n,Nsqr:entero;
q:booleano;
dx:vector[1..8] de entero;
dy:vector[1..8] de entero;
h:vector[1..8,1..8] de entero
procedimiento ensaya(ent i,x,y:entero; sal q:booleano)
{Ensaya el movimiento al i-ésimo escaque desde el x,y. Si el movimiento es posible y
tras él se puede seguir moviendo hasta encontrar la solución entonces q toma el valor
verdad y falso en caso contrario.}
variables k,u,v:entero
principio
k:=0;
repetir {se ensaya con los 8 movimientos posibles}
k:=k+1;
q:=falso;
u:=x+dx[k];
v:=y+dy[k];
si (1≤u) and (u≤n) and (1≤v) and (v≤n) entonces
si h[u,v]=0 entonces
h[u,v]:=i;
si i<Nsqr entonces
ensaya(i+1,u,v,q);
si not q entonces
h[u,v]:=0
fsi
sino
q:=verdad
fsi
fsi
fsi
hastaQue q or (k=8)
fin
principio
dx[1]:=2; dx[2]:=1; dx[3]:=-1; dx[4]:=-2;
dx[5]:=-2; dx[6]:=-1; dx[7]:=1; dx[8]:=2;
dy[1]:=1; dy[2]:=2; dy[3]:=2; dy[4]:=1;
dy[5]:=-1; dy[6]:=-2; dy[7]:=-2; dy[8]:=-1;
para i:=1 hasta 8 hacer
para j:=1 hasta 8 hacer
h[i,j]:=0
fpara
fpara;
escribir('Introduce n (1≤n≤8): '); leerLínea(n);
escribir('Introduce i de la casilla inicial: '); leerLínea(i);
escribir('Introduce j de la casilla inicial: '); leerLínea(j);
Nsqr:=n*n; {número de escaques que hay que visitar}
h[i,j]:=1;
ensaya(2,i,j,q);
si q entonces
para i:=1 hasta n hacer
para j:=1 hasta n hacer
escribir(h[i,j])
fpara;
escribirLínea
fpara
sino
escribir('No hay solución')
fsi
fin
A continuación, se muestra un ejemplo de ejecución del algoritmo anterior:
Introduce n (1≤n≤8): 8
Introduce i de la casilla inicial: 1
Introduce j de la casilla inicial: 1

-- 224 of 267 --

211
1 	60 	39 	34 	31 	18 	9 	64
38 	35 	32 	61 	10 	63 	30 	17
59 	2 	37 	40 	33 	28 	19 	8
36 	49 	42 	27 	62 	11 	16 	29
43 	58 	3 	50 	41 	24 	7 	20
48 	51 	46 	55 	26 	21 	12 	15
57 	44 	53 	4 	23 	14 	25 	6
52 	47 	56 	45 	54 	5 	22 	13
El problema de la solución de vuelta atrás para el problema del recorrido del caballo es su gran ineficiencia (la
ejecución anterior tardó 7'24" en un computador con procesador 68LC040 50/25 MHz2). La razón del elevado tiempo de
ejecución es el gran número de “vueltas atrás” que realiza el algoritmo (es decir, se recorren demasiados nodos del árbol de
movimientos).
Una heurística voraz para el problema del recorrido del caballo consiste en seleccionar el siguiente escaque a visitar
con la siguiente regla: se elige aquel escaque no visitado desde el cual se puede acceder a un menor número de escaques
no visitados. La heurística se basa en la idea de que si ahora tenemos oportunidad de desplazarnos a un escaque “muy
aislado” debemos hacerlo pues más adelante será más difícil llegar a él de nuevo. El siguiente algoritmo implementa la
heurística anterior:
procedimiento caballo
variables x,y,i,j,n,Nsqr,k,kk,u,v,num,menor:entero;
parar: booleano;
dx:vector[1..8] de entero;
dy:vector[1..8] de entero;
h:vector[1..8,1..8] de entero
función accesibles(x,y:entero) devuelve entero
{Devuelve el número de escaques no visitados accesibles desde x,y}
variables k,u,v,num:entero
principio
num:=0;
para k:=1 hasta 8 hacer
u:=x+dx[k];
v:=y+dy[k];
si (1≤u) and (u≤n) and (1≤v) and (v≤n) entonces
si h[u,v]=0 entonces
num:=num+1
fsi
fsi
fpara;
devuelve num
fin
principio
dx[1]:=2; dx[2]:=1; dx[3]:=-1; dx[4]:=-2;
dx[5]:=-2; dx[6]:=-1; dx[7]:=1; dx[8]:=2;
dy[1]:=1; dy[2]:=2; dy[3]:=2; dy[4]:=1;
dy[5]:=-1; dy[6]:=-2; dy[7]:=-2; dy[8]:=-1;
para i:=1 hasta 8 hacer
para j:=1 hasta 8 hacer
h[i,j]:=0
fpara
fpara;
escribir('Introduce n (1≤n≤8): '); leerLínea(n);
escribir('Introduce x de la casilla inicial: '); leerLínea(x);
escribir('Introduce y de la casilla inicial: '); leerLínea(y);
Nsqr:=n*n;
h[x,y]:=1;
i:=1;
parar:=falso;
mientrasQue (i<Nsqr) and not parar hacer
i:=i+1;
menor:=9;
2 Esto debió ser en el año 1993 o 1994…

-- 225 of 267 --

212
para k:=1 hasta 8 hacer
u:=x+dx[k];
v:=y+dy[k];
si (1≤u) and (u≤n) and (1≤v) and (v≤n) entonces
si h[u,v]=0 entonces
num:=accesibles(u,v);
si num<menor entonces
menor:=num;
kk:=k
fsi
fsi
fsi
fpara;
si menor=9 entonces
parar:=verdad
sino
x:=x+dx[kk];
y:=y+dy[kk];
h[x,y]:=i
fsi
fmq;
si not parar entonces
para i:=1 hasta n hacer
para j:=1 hasta n hacer
escribir(h[i,j])
fpara;
escribirLínea
fpara
sino
escribir('No encuentro solución');
fsi
fin
La ejecución del algoritmo anterior para los mismos datos utilizados antes es la siguiente:
Introduce n (1≤n≤8): 8
Introduce x de la casilla inicial: 1
Introduce y de la casilla inicial: 1
1 	34 	3 	18 	49 	32 	13 	16
4 	19 	56 	33 	14 	17 	50 	31
57 	2 	35 	48 	55 	52 	15 	12
20 	5 	60 	53 	36 	47 	30 	51
41 	58 	37 	46 	61 	54 	11 	26
6 	21 	42 	59 	38 	27 	64 	29
43 	40 	23 	8 	45 	62 	25 	10
22 	7 	44 	39 	24 	9 	28 	63
Como puede verse, la solución encontrada es diferente de la anterior. Sin embargo, la gran diferencia se encuentra en
el tiempo de ejecución. En este caso, el mismo computador necesita menos de 1 segundo (frente a los 7'24" de la solución
de vuelta atrás). La razón es que este algoritmo sólo recorre 64 nodos del árbol de movimientos (los imprescindibles
para llegar desde la raíz a una hoja, sin realizar ninguna vuelta atrás).
Si ensayamos otra ejecución del mismo algoritmo para los siguientes datos:
Introduce n (1≤n≤8): 5
Introduce x de la casilla inicial: 1
Introduce y de la casilla inicial: 3
No encuentro solucion
El algoritmo no encuentra solución. Sin embargo, existe solución. La siguiente es una ejecución del algoritmo de vuelta
atrás para los mismos datos (18" de ejecución con el mismo computador):
Introduce n (1≤n≤8): 5
Introduce i de la casilla inicial: 1
Introduce j de la casilla inicial: 3

-- 226 of 267 --

213
25 	14 	1 	8 	19
4 	9 	18 	13 	2
15 	24 	3 	20 	7
10 	5 	22 	17 	12
23 	16 	11 	6 	21
Es decir, la estrategia voraz no sirve en todos los casos. Una solución razonable consiste en modificar el algoritmo
de vuelta atrás, cambiando el orden de ensayo de las casillas accesibles desde una dada. En lugar de probar de forma
consecutiva en el sentido de las agujas del reloj, se intentará en primer lugar a la casilla desde la que se pueda acceder al
menor número de casillas no visitadas; si desde esa casilla no se llega a una solución, se intentará con la casilla con siguiente
menor número de casillas accesibles, etcétera.
Para poder llevar a cabo la vuelta atrás, cada vez que se llegue a una casilla se almacenarán los movimientos posibles,
es decir, sus casillas accesibles junto con el número de casillas no visitadas accesibles desde cada una de ellas en una cola
de movimientos con prioridades (véase la lección 19). Supóngase que en el módulo colasDeMov están definidos los
siguientes elementos:
tipo movimiento = registro
valor:1..8; {movimiento según figura al inicio de esta sección}
peso:0..8 	{nº de casillas no visitadas accesibles si se realiza
freg 	el movimiento}
función menor(m1,m2:movimiento) devuelve booleano
principio
devuelve m1.peso<m2.peso;
fin
tipo colaDeMov {cola de movimientos con prioridades; un movimiento m1 tiene prioridad
sobre otro m2 si menor(m1,m2)=verdad}
Entonces, el algoritmo de vuelta atrás modificado con una estrategia voraz para la elección del siguiente candidato a
movimiento es el siguiente:
procedimiento caballo
importa colasDeMov
variables i,j,n,Nsqr:entero;
q:booleano;
dx:vector[1..8] de entero;
dy:vector[1..8] de entero;
h:vector[1..8,1..8] de entero
procedimiento ensaya(ent i,x,y:entero; sal q:booleano)
{Ensaya el movimiento al i-ésimo escaque desde el x,y. Si el movimiento es posible y
tras él se puede seguir moviendo hasta encontrar la solución entonces q toma el valor
verdad y falso en caso contrario.}
variables k,u,v:entero;
mov:movimiento;
movimientos:colaDeMov
función accesibles(x,y:entero) devuelve entero
{Devuelve el número de escaques no visitados accesibles desde x,y}
variables num,u,v,k:entero
principio
num:=0;
para k:=1 hasta 8 hacer
u:=x+dx[k];
v:=y+dy[k];
si (1≤u) and (u≤n) and (1≤v) and (v≤n) entonces
si h[u,v]=0 entonces
num:=num+1
fsi
fsi
fpara;
devuelve num
fin

-- 227 of 267 --

214
principio {de ensaya}
{se almacenan los movimientos posibles}
crearVacía(movimientos);
para k:=1 hasta 8 hacer
u:=x+dx[k];
v:=y+dy[k];
si (1≤u) and (u≤n) and (1≤v) and (v≤n) entonces
si h[u,v]=0 entonces
mov.valor:=k;
mov.peso:=accesibles(u,v);
añadir(movimientos,mov)
fsi
fsi
fpara;
{se ensaya por orden de menor a mayor número de casillas dominadas no visitadas}
q:=falso;
mientrasQue not esVacía(movimientos) and not q hacer
mov:=min(movimientos);
eliminarMin(movimientos);
k:=mov.valor;
u:=x+dx[k];
v:=y+dy[k];
h[u,v]:=i;
si i<Nsqr entonces
ensaya(i+1,u,v,q);
si not q entonces
h[u,v]:=0
fsi
sino
q:=verdad
fsi
fmq
fin {de ensaya}
principio
dx[1]:=2; dx[2]:=1; dx[3]:=-1; dx[4]:=-2;
dx[5]:=-2; dx[6]:=-1; dx[7]:=1; dx[8]:=2;
dy[1]:=1; dy[2]:=2; dy[3]:=2; dy[4]:=1;
dy[5]:=-1; dy[6]:=-2; dy[7]:=-2; dy[8]:=-1;
para i:=1 hasta 8 hacer
para j:=1 hasta 8 hacer
h[i,j]:=0
fpara
fpara;
escribir('Introduce n (1≤n≤8): '); leerLínea(n);
escribir('Introduce i de la casilla inicial: '); leerLínea(i);
escribir('Introduce j de la casilla inicial: '); leerLínea(j);
Nsqr:=n*n;
h[i,j]:=1;
ensaya(2,i,j,q);
si q entonces
para i:=1 hasta n hacer
para j:=1 hasta n hacer
escribir(h[i,j])
fpara;
escribirLínea
fpara
sino
escribir('No hay solución');
fsi
fin
El siguiente es el resultado de la ejecución de este algoritmo (en menos de un segundo en el mismo computador que
las ejecuciones anteriores) para los datos para los que la heurística voraz sin vuelta atrás no encontró solución:
Introduce n (1≤n≤8): 5
Introduce i de la casilla inicial: 1

-- 228 of 267 --

215
Introduce j de la casilla inicial: 3
23 	6 	1 	16 	21
12 	17 	22 	7 	2
5 	24 	11 	20 	15
10 	13 	18 	3 	8
25 	4 	9 	14 	19