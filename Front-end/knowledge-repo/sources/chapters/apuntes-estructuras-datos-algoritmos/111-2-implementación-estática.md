# 2. Implementación estática

En lenguajes que incluyen tipos puntero la representación generalmente utilizada para los valores de tipo árbol es
dinámica, encadenando mediante punteros los elementos del árbol. Pero en aquellos lenguajes que carecen de tipos puntero,
es preciso representar árboles en base a vectores. Veremos aquí la representación estática de árboles binarios que consiste
en el almacenamiento, para cada elemento, de los índices de las componentes en que se guardan sus hijos, y la llamaremos
representación basada en cursores a los hijos.
En la representación de árboles binarios basada en cursores a los hijos, cada componente del vector debe almacenar,
además del campo con la información del elemento, dos cursores (campos de tipo entero) que guardarán los índices de
almacenamiento de los hijos izquierdo y derecho, y un campo booleano que guardará si esa componente del vector está
siendo utilizada (es decir, almacena un nodo) o no.
constante max = 1000 {valor arbitrario, máximo número de elementos almacenables}
tipo arbin = 0..max 	{el 0 significa árbol vacío; en otro caso, es la posición de
la raíz del árbol en el vector de nodos}
nodo = registro
dato:elemento;
izq,der:arbin;
ocupado:booleano
freg;
tpVectorDeNodos = vector[1..max] de nodo;
{es un vector en el que se pueden almacenar uno o más árboles binarios}

-- 112 of 267 --

105
variables vectorDeNodos:tpVectorDeNodos; a1,a2:arbin
El árbol vacío se representa dando el valor 0 a la variable de tipo arbin. Un árbol no vacío se representa de la siguiente
forma: la variable de tipo arbin guarda el índice de la componente del vector vectorDeNodos en el que está el valor del
elemento raíz. En esa componente se guardan además (en los campos izq y der) los índices de las componentes donde
están almacenados los valores de los nodos hijos, etc. Si un nodo no tiene hijo izquierdo o derecho el valor del
correspondiente campo izq ó der es 0.
'a
'
'f
'
'b
'
'n
'
'g
'
'e'
'c
'
'd
'
'a
'
2 	4 v
'f
'
0 	3 v
'b
'
0 	0 v
'c
'
5 	8 v
'n
'
6 	7 v
'g
'
0 	0 v
'e
'
0 	0 v
'd
'
0 	0 v
? 	? 	? f
? 	? 	? f
[1]
[2]
[3]
[4]
[5]
[6]
[7]
[8]
[9]
[10]
vectorDeNodos
variable 	1	a	a:arbin
Nótese que con la representación propuesta anteriormente pueden almacenarse varios árboles binarios en un mismo
vector de nodos. El campo ocupado debe consultarse si se implementan operaciones de modificación consistentes en añadir
nodos, para localizar componentes libres del vector, y debe modificarse en operaciones de borrado de nodos.
La implementación de las operaciones de árboles binarios representados en un vector almacenando cursores a los hijos
se plantea como ejercicio (añádanse además las operaciones de duplicar árbol y de comparación de igualdad, y estúdiese el
coste de todas las operaciones).