# 2. Implementación dinámica

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 35)

## Contenido
# 2. Implementación dinámica

Veremos ahora una implementación dinámica, es decir, basada en punteros, que para cada elemento del árbol guardará
los punteros a sus hijos.
módulo genérico árbolesBinariosBúsqueda {implementa la especificación abbs}
parámetros
tipo elemento
con función “≤”(e1,e2:elemento) devuelve booleano
{… ídem con el resto funciones de comparación: <=,=,>,>= }
exporta
tipo abb {Su dominio de valores son los árboles binarios de búsqueda de elementos,
con la posibilidad de contener elementos repetidos;
sirven, por tanto, para almacenar multiconjuntos de elementos}
procedimiento vacío(sal a:abb)
{Devuelve en a el árbol binario de búsqueda vacío, sin elementos}
función esVacío(a:abb) devuelve booleano
{Devuelve verdad si y sólo si a es vacío}
procedimiento añadir(e/s a:abb; ent e:elemento)
{Devuelve en a el abb resultante de añadir un ejemplar del elemento e, manteniendo
la propiedad de abb (todo elemento del árbol es mayor o igual que los elementos de
su subárbol izquierdo y menor que los elementos de su subárbol derecho}
función está(a:abb; e:elemento) devuelve booleano
{Devuelve verdad si y sólo si hay algún ejemplar de e está en a}
procedimiento borrar(e/s a:abb; ent e:elemento)
{Si e está en a, devuelve un árbol igual al resultante de borrar de a una de las
apariciones de e en a. Si e no está en a, devuelve un árbol igual que a}
implementación
tipos abb = ↑nodo
nodo = registro
dato:elemento;
izq,der:abb

-- 124 of 267 --

117
freg
procedimiento vacío(sal a:abb)
{Devuelve en a el árbol binario de búsqueda vacío, sin elementos}
principio
a:=nil
fin
función esVacío(a:abb) devuelve booleano
{Devuelve verdad si y sólo si a es vacío}
principio
devuelve a=nil
fin
procedimiento añadir(e/s a:abb; ent e:elemento)
{Devuelve en a el abb resultante de añadir un ejemplar del elemento e, manteniendo
la propiedad de abb (todo elemento del árbol es mayor o igual que los elementos de
su subárbol izquierdo y menor que los elementos de su subárbol derecho}
principio
si a=nil entonces
nuevoDato(a);
a↑.dato:=e;
a↑.izq:=nil;
a↑.der:=nil
sino
si e≤a↑.dato entonces
añadir(a↑.izq,e)
sino
añadir(a↑.der,e)
fsi
fsi
fin
función está(a:abb; e:elemento) devuelve booleano
{Devuelve verdad si y sólo si hay algún ejemplar de e está en a}
principio
si a=nil entonces
devuelve falso
sino
selección
e<a↑.dato: devuelve está(a↑.izq,e);
e=a↑.dato: devuelve verdad;
e>a↑.dato: devuelve está(a↑.der,e)
fselección
fsi
fin
{Este procedimiento es auxiliar para el procedimiento de borrar, ver abajo}
procedimiento borrarMáximo(e/s a:abb; sal e:elemento)
{Precondición: a es no vacío. Devuelve en e un elemento máximo de a y lo borra de a}
variable aux:abb
principio
si a↑.der=nil entonces {el máximo del árbol está en la raíz}
e:=a↑.dato;
aux:=a;
a:=a↑.izq;
disponer(aux)
sino {el máximo del árbol está en el subárbol derecho}
borrarMáximo(a↑.der,e)
fsi
fin
procedimiento borrar(e/s a:abb; ent e:elemento)
variable aux:abb
principio
si a≠nil entonces
selección

-- 125 of 267 --

118
e<a↑.dato: borrar(a↑.izq,e);
e>a↑.dato: borrar(a↑.der,e);
e=a↑.dato: si a↑.izq=nil entonces
aux:=a;
a:=a↑.der;
disponer(aux)
sino
borrarMáximo(a↑.izq,a↑.dato)
fsi
fselección
fsi
fin
fin {del modulo}
Al módulo anterior se le podrían añadir las operaciones de: altura, duplicar, liberar y comparación de igualdad con
idéntica implementación que la vista en la lección anterior para árboles binarios cualesquiera.
De forma análoga, las operaciones del iterador vistas para árboles binarios son válidas también (aumentando la
representación del tipo con el campo necesario para implementar el iterador, como se hizo en la lección anterior). Con el
iterador de la lección anterior, basado en el recorrido en in-orden, el recorrido de visita de los elementos del árbol se
produciría en el orden definido para el tipo elemento por el operador “≤”.
Si en la especificación e implementación del TAD abb vistas anteriormente, modificamos la semántica de la operación
añadir para que no se añadan ejemplares repetidos de un mismo elemento, se consigue tener árboles binarios de
búsqueda sin elementos repetidos. En ese caso, tenemos una nueva forma de implementar el TAD conjunto.
En cuanto al coste en tiempo de las operaciones en el caso peor, las operaciones vacío y esVacío tienen coste en
O(1). En cambio, las operaciones añadir, está y borrar tienen un coste en el caso peor en O(n), es decir, lineal en n,
siendo n el número de elementos almacenados en el árbol. Esto es así porque el árbol podría ser degenerado, como el de
la figura siguiente (obtenido, por ejemplo, si se han añadido los elementos en este orden: 1, 2, 3, 4), y cualquiera de esas
cuatro operaciones, en el caso peor, tendrían que llegar hasta la hoja del árbol.
Desde un punto de vista práctico, si no se precisa garantizar un coste en tiempo bajo en el caso peor y es suficiente
con obtener un coste bajo en el caso promedio, los árboles binarios de búsqueda son una buena solución pues puede
demostrarse que la altura promedio de un A
