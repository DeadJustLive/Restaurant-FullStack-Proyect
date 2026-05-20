# módulo c: olaConPrioridadesDeMáximos

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 86)

## Contenido
# módulo c: olaConPrioridadesDeMáximos

parámetro
tipo elemento
con función “<”(e1,e2:elemento) devuelve booleano
{el tipo elemento tiene definida una función de orden que determina la prioridad}
exporta
constante maxNum {número máximo de elementos de la cola}
tipo cp 	{Representación del TAD cola con prioridad de máximos}
procedimiento crearVacía(sal c:cp)
{devuelve una cola vacía, sin elementos}
procedimiento añadir(e/s c:cp; ent e:elemento; sal error:booleano)
{si nºelementos(c)<maxNum entonces error=falso y añade e a c; si no error=verdad}
función esVacía(c:cp) devuelve booleano
{devuelve verdad si y sólo si c es la cola vacía}
función max(c:cp) devuelve elemento
{Pre: esVacía(c)=falso} {Post: devuelve un elemento máximo de c con respecto a “<”}
procedimiento eliminarMax(e/s c:cp)
{Si c es vacía sigue igual. Si no elimina de c un elemento máximo con respecto a “<”.}
implementación
constante maxNum = ... {número máximo de elementos de la cola}
tipo cp = registro
dato: vector[1..maxNum] de elemento;
num:0..maxNum
freg
procedimiento crearVacía(sal c:cp)
{devuelve una cola vacía, sin elementos}
principio
c.num:=0
fin
procedimiento añadir(e/s c:cp; ent e:elem; sal error:booleano)
{si nºelementos(c)<maxNum entonces error=falso y añade e a c; si no error=verdad}
variables i:natural;
debeSubir:booleano;
aux:elemento
principio
si c.num=maxNum entonces
error:=verdad
16 	17 16 11 14 15 10 11 10 2 11 12 ? ? 	? ?
15
12
11
dato
num
1 	2 	3 	4 	5 	6 	7 	8 	9 10 11 12 13 14 15
num	num div 2 	maxNum

-- 179 of 267 --

172
sino
error:=falso;
c.num:=c.num+1;
c.dato[c.num]:=e;
i:=c.num; {índice de la posición actual de e}
si i>1 entonces
debeSubir:=c.dato[i]>c.dato[i div 2] 	{¿tiene más prioridad que su padre?}
sino {i=1}
debeSubir:=falso
fsi;
mientrasQue debeSubir hacer
{subir e en el árbol, intercambiándolo con su padre}
aux:=c.dato[i];
c.dato[i]:=c.dato[i div 2];
c.dato[i div 2]:=aux;
i:=i div 2; 	{índice de la posición actual de e}
si i>1 entonces
debeSubir:=c.dato[i]>c.dato[i div 2] 	{¿tiene más prioridad que su padre?}
sino {i=1}
debeSubir:=falso
fsi
fmq
fsi
fin
procedimiento eliminarMax(e/s c:cp)
{Si c es vacía sigue igual. Si no elimina de c un elemento máximo con respecto a “<”.}
variables i,j:natural;
aux:elemento
principio
si c.num>0 entonces
c.dato[1]:=c.dato[c.num];
c.num:=c.num-1;
i:=1;
{i es el índice de la posición actual del que antes era el último elemento}
mientrasQue i≤c.num div 2 hacer {el elemento de la posición i tiene hijo(s)}
{bajar el anterior último elemento del árbol}
si (2*i=c.num) orelse (c.dato[2*i]>c.dato[2*i+1]) entonces
j:=2*i
sino
j:=2*i+1
fsi; {j=hijo de i con mayor prioridad, o único hijo}
si c.dato[i]<c.dato[j] entonces
{intercambia el anterior último elemento y su hijo}
aux:=c.dato[i];
c.dato[i]:=c.dato[j];
c.dato[j]:=aux;
i:=j
sino
i:=c.num {para salir del bucle}
fsi
fmq
fsi
fin
función max(c:cp) devuelve elemento
{Pre: esVacía(c)=falso} {Post: devuelve un elemento máximo de c con respecto a “<”}
principio
devuelve c.dato[1]
fin
función esVacía(c:cp) devuelve booleano
{devuelve verdad si y sólo si c es la cola vacía}
principio
devuelve c.num=0
fin
fin 	{de colaConPrioridadesDeMáximos}

-- 180 of 267 --

173
