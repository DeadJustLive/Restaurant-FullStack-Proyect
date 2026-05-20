# unidad m: ayor que la del derecho.

La implementación del algoritmo de búsqueda de una clave o elemento en un AVL es exactamente la misma que hemos
visto en la lección anterior para árboles de búsqueda binaria cualesquiera. Dado que el árbol no se modifica en la búsqueda,
los factores de equilibrio de sus nodos permanecerán inalterados.
Sin embargo, en la implementación de los algoritmos de inserción y borrado de claves, será necesario recalcular el
factor de equilibrio de los nodos (debido a la ganancia o pérdida de altura de sus subárboles) y, por tanto, en ocasiones, será
necesario reequilibrar el árbol para mantenerlo dentro de la clase de los AVL, es decir, para que el factor de equilibrio
de sus nodos se mantenga siempre entre –1 y +1.
La representación de los AVL puede hacerse, por tanto, así:
tipos ptNodo = ↑nodo;
factorEquil = (pesadoIzq,equilibrado,pesadoDer); {o lo que es lo mismo:-1,0,1}
nodo = registro
laClave:clave; {o bien dato:elemento si no se trata de un diccionario}
elValor:valor;
equilibrio:factorEquil;
izq,der:ptNodo
freg

-- 137 of 267 --

130
diccionario = registro
raíz:ptNodo;
tamaño:natural;
iter:pila 	{pila de datos de tipo ptNodo, para el iterador}
freg
El algoritmo de búsqueda queda exactamente igual que en el caso de los ABB:
{Este procedimiento es auxiliar para el de buscar}
procedimiento buscarRec(ent p:ptNodo; ent c:clave; sal éxito:booleano; sal v:valor)
{Devuelve éxito=verdad si en el árbol de raíz apuntada por p hay algún par con
clave c, falso en caso contrario.
En caso de éxito, además, devuelve en v el valor asociado a la clave c}
principio
si p=nil entonces
éxito:=falso
sino
selección
c<p↑.laClave: buscarRec(p↑.izq,c,éxito,v);
c=p↑.laClave: éxito:=verdad;
v:=p↑.elValor;
c>p↑.laClave: buscarRec(p↑.der,c,éxito,v)
fselección
fsi
fin
procedimiento buscar(ent d:diccionario; ent c:clave; sal éxito:booleano; sal v:valor)
{Devuelve éxito=verdad si en d hay algún par con clave c, falso en caso contrario.
En caso de éxito, además, devuelve en v el valor asociado a la clave c en d}
principio
buscarRec(d.raíz,c,éxito,v)
fin
Dado que en un AVL la altura está acotada por el logaritmo del número de nodos, el coste en el caso peor del algoritmo
anterior para AVL está en O(log n).