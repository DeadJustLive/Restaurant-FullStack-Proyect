# 2. Aplicación al problema del recorrido del caballo de ajedrez

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 134)

## Contenido
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
si (1≤u) and (u≤n) and (1≤v) and (
