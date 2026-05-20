# 1. Concepto de diccionario y su especificación

Un diccionario o tabla es un conjunto o colección de pares (c,v). El primer miembro de cada par suele llamarse clave
y el segundo, valor asociado a la clave. En la colección se supondrá que no puede haber dos pares que tengan la misma
clave.
Los diccionarios también se llaman tipos de datos asociativos o funcionales porque representan una función cuyo
dominio es el género de las claves y cuyo rango es el género de los valores:
f : Dominio de las claves  Dominio de los valores
La función representada suele ser parcial (es decir, existen claves del dominio sin valor asociado), aunque podrían
representarse como totales asociando a algunas claves un valor especial llamado “indefinido”.
Ejemplos típicos de utilización de diccionarios son:
• 	Las tablas de símbolos de los compiladores (las claves son los identificadores y los valores los atributos de dichos
identificadores).
• 	Los directorios de ficheros en un sistema operativo (las claves son los nombres de los ficheros y los valores sus
atributos).
• 	Los conjuntos de elementos: los elementos son las claves y no existen valores asociados. En este caso la función
representada por el diccionario es la función característica del conjunto (para cada clave, ¿está o no está en el conjunto?):
f : Dominio de las claves  {verdad,falso}
Las técnicas para representar diccionarios y conjuntos tienen mucho en común, aunque el conjunto de operaciones de
interés es diferente (las operaciones de unión, intersección y diferencia de conjuntos no tienen sentido, por lo general,
para diccionarios).
• 	Los tipos vector, vector[tpIndice] de tpDato, son un caso particular de diccionarios en el que las claves son un
tipo de datos escalar numerable (el tipo de los índices) y los valores asociados a las claves son los de las correspondientes
componentes del vector.
f : Dominio del tipo tpIndice  Dominio del tipo tpDato
Las operaciones básicas para los diccionarios son: la inserción de un nuevo par (c,v) y la obtención del valor v
asociado a una clave c. Si se intenta añadir un par (c,v) y ya existe en el diccionario un par (c,v’), se entiende que se está
realizando una modificación (actualización) del valor asociado a esa clave c.
La operación de obtener el valor asociado a una clave es parcial, pues sólo tiene sentido si existe un par en el diccionario
can tal clave.
En muchas ocasiones se precisa una operación de borrado que dada una clave c elimine el par (c,v), supuesto que este
par existiese en la tabla.
Se presenta a continuación una posible especificación del TAD diccionario. Se va a añadir el requisito de que las claves
sean comparables con una operación “<” (es decir, que exista en su dominio una relación de orden total).

-- 95 of 267 --

88
espec diccionarios
usa boleanos, naturales
parámetros formales
géneros clave, valor
operaciones {suponemos que en el género de las claves hay definida una función de orden y otra de igualdad}
_<_ : clave c1, clave c2 -> booleano
_=_ : clave c1, clave c2 -> booleano
fpf
género diccionario {Los valores del TAD representan conjuntos de pares (clave,valor) sin claves repetidas}
operaciones
crear: -> diccionario
{Devuelve un diccionario vacío, sin elementos}
añadir: diccionario d, clave c, valor v -> diccionario
{Si en d no hay ningún par con clave c, devuelve el diccionario resultante de añadir el par (c,v) a d;
si en d hay un par (c,v’), entonces devuelve el resultado de sustituirlo por el par (c,v)}
está?: clave c, diccionario d -> booleano
{Devuelve verdad si y sólo si en d hay algún par (c,v)}
parcial obtenerValor: clave c, diccionario d -> valor
{Devuelve el valor asociado a la clave c en d.
Parcial: la operación no está definida si c no está en d}
quitar: clave c, diccionario d -> diccionario
{Si c está en d, devuelve el diccionario resultante de borrar c y su valor de d;
si c no está en d, devuelve un diccionario igual a d}
cardinal: diccionario d -> natural
{Devuelve el nº de elementos en el diccionario d}
esVacío?: diccionario d -> booleano
{Devuelve verdad si y sólo si d no tiene elementos}
{Las cinco operaciones siguientes son un Iterador definido para los diccionarios}
iniciarIterador: diccionario d -> diccionario
{Inicializa el iterador para recorrer los pares del diccionario d, de forma que el siguiente par a visitar sea el
primero que visitamos (situación de no haber visitado ningún par).}
existeSiguiente?: diccionario d -> booleano
{Devuelve falso si ya se han visitado todos los pares de d, devuelve verdad en caso contrario}
parcial siguienteClave: diccionario d -> clave
{Devuelve la clave del siguiente par a visitar de d.
Parcial: la operación no está definida si no existeSiguiente?(d)}
parcial siguienteValor: diccionario d -> valor
{Devuelve el valor del siguiente par a visitar de d.
Parcial: la operación no está definida si no existeSiguiente?(d)}
parcial avanza: diccionario d -> diccionario
{Prepara el iterador para visitar el siguiente par del diccionario d.
Parcial: la operación no está definida si ya se ha visitado el último par.}
fespec

-- 96 of 267 --

89
Por razones de eficiencia, en las implementaciones del TAD diccionario las operaciones “está?” y “obtenerValor” se
combinan en una sola operación que devuelve tanto un booleano como un valor. El booleano es verdad si y sólo si la clave
está y en ese caso el valor es el asociado a la clave, y en caso contrario el booleano es falso y el valor queda indefinido.