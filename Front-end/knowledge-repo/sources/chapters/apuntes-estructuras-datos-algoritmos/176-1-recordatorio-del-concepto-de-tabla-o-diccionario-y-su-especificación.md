# 1. Recordatorio del concepto de tabla o diccionario y su especificación

Como ya dijimos en una lección anterior, una tabla o diccionario es un conjunto o colección de pares. El primer
miembro de cada par es la clave y el segundo, el valor asociado a la clave. No puede haber dos pares que tengan la misma
clave.
Las tablas o diccionarios también se llaman tipos de datos asociativos o funcionales porque representan una función
cuyo dominio es el género de las claves y cuyo rango es el género de los valores:
f : Dominio de las claves  Dominio de los valores
La función representada suele ser parcial (es decir, existen claves del dominio sin valor asociado), aunque podrían
representarse como totales asociando a algunas claves un valor especial llamado “indefinido”.
Las operaciones básicas para los diccionarios son: la inserción de un nuevo par (o la modificación del valor asociado,
si la clave ya existe), la búsqueda u obtención del valor asociado a una clave y el borrado de un par dada su clave.
Recordamos la especificación:
espec diccionariosGenéricos
usa boleanos, naturales
parámetros formales
géneros clave, valor
operaciones {suponemos que en el género de las claves hay definida una función de orden y otra de igualdad}
_<_ : clave c1, clave c2 -> booleano
_=_ : clave c1, clave c2 -> booleano
fpf
género diccionario {Los valores del TAD representan conjuntos de pares (clave,valor) sin claves repetidas}
operaciones
crearVacío: -> diccionario
{Devuelve un diccionario vacío, sin elementos}
añadir: diccionario d, clave c, valor v -> diccionario
{Si en d no hay ningún par con clave c, devuelve el diccionario resultante de añadir el par (c,v) a d;
si en d hay un par (c,v’), entonces devuelve el resultado de sustituirlo por el par (c,v)}
está?: clave c, diccionario d -> booleano
{Devuelve verdad si y sólo si en d hay algún par (c,v)}

-- 185 of 267 --

178
parcial obtenerValor: clave c, diccionario d -> valor
{Devuelve el valor asociado a la clave c en d.
Parcial: la operación no está definida si c no está en d}
borrar: clave c, diccionario d -> diccionario
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
En las implementaciones del TAD tabla, se suelen juntar en una única las operaciones “está?” y “obtenerValor”.