# 3. Aplicación a la ordenación de elementos de un vector: el heapsort

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 88)

## Contenido
# 3. Aplicación a la ordenación de elementos de un vector: el heapsort

Veamos ahora cómo una cola con prioridades puede servir para lograr un algoritmo eficiente de ordenación de los
datos de un vector in situ. Para ello, basta recordar el sencillo método de ordenación por selección directa. El primer paso
consiste en elegir el dato más pequeño de entre todos los que se desea ordenar. A continuación, se elige el más pequeño de
los restantes. Así se continua hasta haber elegido todos los datos por orden.
Para realizarlo de forma eficiente, almacenaremos los datos que deben ser ordenados en una cola con prioridad de
máximos. Lógicamente, la función de ordenación que define la prioridad es la misma con la que queremos ordenar los
elementos. Después se irá extrayendo la raíz del árbol almacenándola por orden en el vector, hasta que el árbol quede vacío.
procedimiento ordena(e/s v:vector[1..maxNum] de elemento; ent n:1..maxNum)
{Precondición: n>0.
Postcondición: Permuta los n primeros datos de v, dejándolos en orden creciente.}
variables c:cp;
i:entero
principio
crearVacía(c); {una cola con prioridad de máximos vacía}
para i:=1 hasta n hacer 	{copia los datos a ordenar de v en c}
añadir(c,v[i])
fpara;
para i:=n descendiendo hasta 1 hacer 	{extrae los datos en orden decreciente de c}
v[i]:= max(c);
eliminarMax(c)
fpara
fin
Puesto que el número de operaciones necesarias para realizar las instrucciones añadir y eliminarMax es, en el peor
caso, de orden log n, la complejidad total de este algoritmo de ordenación es de orden O(n log n) (cada uno de los dos
bucles se ejecuta n veces y su interior tiene una complejidad de orden log n).
Podría parecer que la disminución en el número de operaciones necesarias para ordenar el vector se debe a que se ha
duplicado el espacio de memoria utilizada, empleando una cola con prioridad auxiliar. Sin embargo, no es así. Es posible
modificar el algoritmo de forma que sólo se trabaje con el vector original, manteniendo la misma complejidad del número
de operaciones a realizar. Para ello, la cola con prioridad c del algoritmo anterior se guardará en las componentes
v[1]…v[i] siempre que c tenga i nodos. El elemento mayor estará siempre en v[1]. Los elementos que se vayan
extrayendo de v[1] se irán almacenando en v[n]…v[i+1], con lo que el vector quedará ordenado de menor a mayor. Se
incluye a continuación el algoritmo en detalle. Previamente, un par de procedimientos auxiliares.
procedimiento intercambiar(e/s v:vector[1..maxNum] de elemento; ent i,j:1..maxNum)
{Intercambia los valores de v[i] y v[j]}
variable aux:elemento
principio
aux:=v[i];
v[i]:=v[j];
v[j]:=aux
fin
procedimiento empujar(e/s v:vector[1..maxNum] de elemento; ent pri,ult:1..maxNum)
{Pre: v[pri]...v[ult] satisfacen la propiedad de montículo excepto, quizá,
que los hijos de v[pri] pueden ser mayores que él}
{Post: permuta los elementos v[pri]..v[últ] para que TODOS, v[pri] incluido,
verifiquen la propiedad del montículo}
variables r:entero {r indicará la posición ‘actual’ de v[pri]}
principio
r:=pri;
mientrasQue r≤ult div 2 hacer
si ult=2*r entonces 	{r tiene sólo un hijo, en la posición 2*r=ult}
si v[r]<v[2*r] entonces
intercambiar(v,r,2*r)
fsi;
r:=ult 	{para forzar la terminación del bucle}
sino 	{r tiene dos hijos, en las posiciones 2*r y 2*r+1}
si (v[r]<v[2*r]) and (v[2*r]≥v[2*r+1]) entonces {intercambiar r con su hijo izq}

-- 181 of 267 --

174
intercambiar(v,r,2*r);
r:=2*r
sino
si (v[r]<v[2*r+1]) and (v[2*r+1]>v[2*r]) entonces {intercambiarlo con hijo dch}
intercambiar(v,r,2*r+1);
r:=2*r+1
sino 	{r no viola la propiedad de montículo}
r:=ult 	{para forzar la terminación del bucle}
fsi
fsi
fsi
fmq
fin
procedimiento heapsort(e/s v:vector[1..maxNum] de elemento; ent n:1..maxNum)
{Precondición: n>0.
Postcondición: Permuta los n primeros datos de v, dejándolos en orden creciente.}
variables i:entero
principio
para i:=n div 2 descendiendoHasta 1 hacer
empujar(v,i,n)
fpara; {ahora v es un montículo de máximos}
para i:=n descendiendoHasta 2 hacer
{eliminar el máximo de la raíz del montículo}
intercambiar(v,1,i);
empujar(v,1,i-1) {restablecer el montículo hasta la posición i-1}
fpara
fin
Para analizar el coste del algoritmo anterior, debe analizarse primero el coste del subalgoritmo empujar. El interior
del bucle mientrasQue r≤último div 2 hacer... fmq lleva un tiempo en O(1). Para calcular cuántas veces se
ejecuta ese bucle, basta ver que, después de cada iteración, r tiene por lo menos el doble del valor que tenía. Por tanto,
puesto que r empieza con valor igual a pri, después de i iteraciones se tiene:
r ≥ pri*2i
El bucle termina si:
r>ult/2
y esto ocurre después de i iteraciones si:
pri*2i>últ/2 (r≥pri*2i>últ/2 fi r>últ/2)
es decir, si:
i>log(últ/pri)-1
En consecuencia, el número de iteraciones del bucle mientrasQue r≤último div 2 hacer... fmq está, a lo
sumo, en O(log ult/pri).
Como en cada llamada al subalgoritmo empujar que se hace en heapsort se verifica que pri≥1 y ult≤n, entonces
cada llamada a empujar está en O
