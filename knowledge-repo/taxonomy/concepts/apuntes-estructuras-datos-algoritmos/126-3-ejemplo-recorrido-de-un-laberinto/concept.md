# 3. Ejemplo: recorrido de un laberinto

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 126)

## Contenido
# 3. Ejemplo: recorrido de un laberinto

En este apartado va a utilizarse una pila como dato auxiliar para resolver el problema de encontrar la salida de un
laberinto con un algoritmo de vuelta atrás. Existe una entrada al laberinto y, una vez dentro de él, el paseante se encuentra
con paredes que le impiden el paso en muchas direcciones. Debe elegirse un camino, en caso de que no lleve a la salida hay

-- 215 of 267 --

202
que volver atrás y continuar en una dirección diferente, y así hasta encontrar la única salida existente. El siguiente es un
ejemplo de laberinto:
En primer lugar, para representar el laberinto podemos utilizar una estructura de datos consistente en una matriz de
m × p componentes booleanas de forma que un valor falso en una componente indica que en la correspondiente posición
del laberinto hay una pared, mientras que el valor verdad representa la existencia de un espacio libre. Supongamos que la
entrada se realiza siempre por la componente 1,1 (como en la figura) y la salida por la componente m,p. La situación del
paseante en el laberinto estará siempre descrita por la fila i y la columna j de su posición en la matriz.
Como puede verse, desde cada posición alcanzada en el interior del laberinto puede optarse por continuar en ocho
direcciones diferentes (Norte, NorEste, Este, SurEste, Sur, SurOeste, Oeste y NorOeste):
[i-1,j] 	[i-1,j+1]
[i,j-1] 	[i,j+1]
[i+1,j-1] 	[i+1,j] 	[i+1,j+1]
N 	NE
E
SE	S	SO
O
NO
[i-1,j-1]
[i,j]
No todas las posiciones i,j permiten moverse en ocho direcciones diferentes (si i = 1 ó m ó j = 1 ó p, entonces son
menos los movimientos posibles). Para evitar ese problema, “orlaremos” la matriz que representa el laberinto con una pared
(componentes con valor falso) en las filas 0 y m + 1 y en las columnas 0 y p + 1.
La solución al problema es la siguiente: al llegar a una nueva posición se examinan todas las posibles direcciones,
desde la Este a la Noreste (en el sentido de las agujas de un reloj); cada vez que se realiza un movimiento, se guarda éste
en una pila (posición y dirección del movimiento); si se llega a una posición desde la que no se puede seguir, hay que volver
atrás, desapilando el último movimiento y realizando el siguiente posible. Para evitar pasar dos veces por el mismo camino
se necesita almacenar en otra matriz de booleanos auxiliar (inicializada con valores falso) para marcar las posiciones por
las que ya se ha pasado (con valor verdad).
constantes m = ...;
p = ...
tipos laberinto = vector[0..m+1,0..p+1] de booleano;
dirección = (E,SE,S,SO,O,NO,N,NE);
movimiento = registro
fil:1..m;
col:1..p;
dir:dirección
freg
procedimiento inviertePila(ent p:pilaDeMov; e/s pI:pilaDeMov)
principio
crearVacía(pI);
mientrasQue not esVacía(p) hacer
apilar(pI,cima(p));

-- 216 of 267 --

203
desapilar(p)
fmq
fin
procedimiento camino(ent lab:laberinto)
{Escribe en pantalla, si existe, un camino del laberinto que va de la posición 1,1 a la
posición m,p.}
variables hePasado:vector[1..m,1..p] de booleano;
mov:movimiento;
pila,pilaInv:pilaDeMov;
éxito:booleano
principio
{inicialización de la matriz de marcas a falso}
para i:=1 hasta m hacer
para j:=1 hasta p hacer
hePasado[i,j]:=falso
fpara
fpara;
{se parte de la casilla 1,1 hacia el Este}
éxito:=falso;
hePasado[1,1]:=verdad;
mov.fil:=1;
mov.col:=1;
mov.dir:=E;
crearVacía(pila);
apilar(pila,mov);
mientrasQue not esVacía(pila) and not éxito hacer
{ver la posición actual y la dirección del movimiento}
mov:=cima(pila);
selección {cálculo de la nueva posición}
mov.dir=N: 	nuevaFil:=mov.fil-1;
nuevaCol:=mov.col;
mov.dir=NE: nuevaFil:=mov.fil-1;
nuevaCol:=mov.col+1;
mov.dir=E: 	nuevaFil:=mov.fil;
nuevaCol:=mov.col+1;
mov.dir=SE: nuevaFil:=mov.fil+1;
nuevaCol:=mov.col+1;
mov.dir=S: 	nuevaFil:=mov.fil+1;
nuevaCol:=mov.col;
mov.dir=SO: nuevaFil:=mov.fil+1;
nuevaCol:=mov.col-1;
mov.dir=O: 	nuevaFil:=mov.fil;
nuevaCol:=mov.col-1;
mov.dir=NO: nuevaFil:=mov.fil-1;
nuevaCol:=mov.col-1
fselección;
si (nuevaFil=m) and (nuevaCol=p) entonces 	{se llega a la salida}
mov.fil:=m;
mov.col:=p;
mov.dir:=E;
apilar(mov);
éxito:=verdad
sino
si lab[nuevaFil,nuevaCol] and not hePasado[nuevaFil,nuevaCol] entonces
{nueva posición}
hePasado[nuevaFil,nuevaCol]:=verdad;
mov.fil:=nuevaFil;
mov.col:=nuevaCol;
mov.dir:=E;
apilar(pila,mov)
sino 	{vuelta atrás}
desapilar(pila);
mientrasQue (mov.dir=NE) and not esVacía(pila) hacer
mov:=cima(pila);
desapilar(mov)
fmq;
si mov.dir<NE entonces
mov.dir:=sucesor(mov.dir);

-- 217 of 267 --

204
apilar(p.mov)
fsi
fsi
fsi
fmq;
si éxito entonces
inviertePila(pila,pilaInv);
mientrasQue not esVacía(pilaInv) hacer
mov:=cima(pilaInv);
desapilar(pilaInv);
escribirLínea('Ir de ',mov.fil,',',mov.col,' hacia el ',mov.dir)
fmq
sino
escribirLínea('¡No hay salida!')
fsi
fin
