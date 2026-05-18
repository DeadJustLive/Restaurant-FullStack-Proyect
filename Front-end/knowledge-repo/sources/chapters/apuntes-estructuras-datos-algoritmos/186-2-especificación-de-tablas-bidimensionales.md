# 2. Especificación de tablas bidimensionales

Vamos a presentar una especificación de las tablas bidimensionales (los casos de dimensión mayor se plantearían de
forma análoga). Se utilizará el TAD genérico tabla (unidimensional) de la lección anterior, concretándolo con dos
argumentos en un TAD concreto. Puesto que se usarán dos TAD concretos tabla (unidimensional), los nombres de operación
del TAD genérico tabla quedarán sobrecargados (es decir, un mismo nombre de operación podrá representar operaciones
diferentes). En cualquier caso, la observación del género o tipo de sus operandos eliminará la confusión.
espec tablasBidimensionales
usa booleanos, diccionariosGenéricos {el TAD diccionario, o tabla unidimensional, de la lección anterior}
parámetros formales
géneros claveA,claveB,valor
fpf
géneros
{concretamos los diccionariosGenéricos o tablas unidimensionales para las proyecciones de la tabla
bidimensional:}
tablaA = diccionario(claveA,valor)
tablaB = diccionario(claveB,valor)
{nuevo género de diccionario o tabla bidimensional:}
tablaAB 	{Los valores del género tablaAB representan conjuntos de ternas <claveA,claveB,valor> en los que no
se permiten claves repetidas, estando las claves formadas por dos partes: <claveA,claveB>)}
operaciones
crear: -> tablaAB
{Devuelve una tabla bidimensional vacía}
añadir: tablaAB t, claveA ca, claveB cb, valor v -> tablaAB
{Devuelve una tabla igual a la tabla resultante de añadir la terna <ca,cb,v> a t; si en t ya había una terna <ca,cb,v’>
entonces devuelve una tabla igual a la resultante de sustituir dicha terna por <ca,cb,v> en t}
está?: claveA ca, claveB cb, tablaAB t -> booleano
{Devuelve verdad si y sólo si en t hay alguna terna <ca,cb,v> para algún v}
parcial obtenerValor: claveA ca, claveB cb, tablaAB t -> valor
{Si en t existe alguna terna con el par de claves <ca,cb> devuelve el 	valor asociado a ellas en dicha terna;
Parcial: la operación no está definida si not(está?(ca,cb,t))}
quitar: claveA ca, claveB cb, tablaAB t -> tablaAB
{Si está?(ca,cb,t), devuelve una tablaAB igual a la resultante de borrar de t la terna <ca,cb,v> que tiene dichas
claves; si not(está?(ca,cb,t)), devuelve una tabla igual a t}
proyectarA: tablaAB t, claveA ca -> tablaB
{Devuelve una tablaB unidimensional con todos los pares <cb,v> tales que en la tabla bidimensional t existe
una terna <ca,cb,v>}
proyectarB: tablaAB t, claveB cb -> tablaA
{Devuelve una tablaA unidimensional con todos los pares <ca,v> tales que en la tabla bidimensional t existe
una terna <ca,cb,v>}
fespec
Al igual que se hace con las tablas unidimensionales, la implementación de las operaciones está? y obtenerValor
suele hacerse con un único procedimiento que devuelva un booleano y un valor.

-- 198 of 267 --

185