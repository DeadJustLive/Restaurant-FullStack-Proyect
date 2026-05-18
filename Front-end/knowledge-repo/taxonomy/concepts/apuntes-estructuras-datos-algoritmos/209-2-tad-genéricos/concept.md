# 2. TAD genéricos

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 209)

## Contenido
# 2. TAD genéricos

En el diseño descendente por refinamientos sucesivos basado en la abstracción de acciones se utiliza la parametrización
de procedimientos y funciones (parámetros formales que en cada ejecución se concretan en los parámetros reales).
De forma análoga, en el diseño basado en la abstracción de datos se pueden definir TAD genéricos (o tipos
parametrizados) con algunas características indefinidas. Esas características pueden ser concretadas posteriormente de
diversas formas según las necesidades, obteniendo ejemplares de TAD concretos distintos.
Las características indefinidas son parámetros formales (igual que en los procedimientos y funciones) que pueden
corresponder a otros tipos, operaciones y constantes. Los parámetros formales se concretan mediante argumentos o
parámetros reales (otros tipos, operaciones o constantes).
Ejemplo sencillo que generaliza (haciéndolo más reutilizable) el TAD conjunto de caracteres visto en una lección
anterior:
espec conjuntosGenéricos
usa booleanos,naturales
parámetro formal
género elemento {es un parámetro de tipo, es decir, se trata del nombre de un tipo cualquiera}
fpf
género conjgen
{Los valores del TAD conjgen representan conjuntos de elementos, sin elementos repetidos, y en los que no es
relevante el orden en el que los elementos se añaden al conjunto.}
operaciones
vacío: -> conjgen
{Devuelve un conjunto de elementos vacío, es decir un conjunto que no contiene ningún elemento.}
poner: elemento e, conjgen c -> conjgen
{Si e está en c, devuelve un conjunto igual a c;
si e no está en c, devuelve el conjunto resultante de añadir e a c.}
quitar: elemento e, conjgen c -> conjgen
{Si e está en c, devuelve el conjunto resultante de eliminar e de c;
si e no está en c, devuelve un conjunto igual a c.}
_∪_: conjgen c1, conjgen c2 -> conjgen
{Devuelve un conjunto que contiene todos los caracteres que están en c1 y todos los que están en c2.}
_∩_: conjgen c1, conjgen c2 -> conjgen
{Devuelve un conjunto que contiene únicamente los caracteres que están tanto en c1 como en c2.}
_∈_: elemento e, conjgen c -> booleano
{Devuelve verdad si y sólo si e está en c.}
esVacío: conjgen c -> booleano
{Devuelve verdad si y sólo si c no contiene ningún elemento.}
cardinal: conjgen c -> natural
{Devuelve el número total de elementos que contiene c (0 si es vacío)}
fespec
Supongamos que en el desarrollo del software de una máquina expendedora de fruta fresca llegamos a la conclusión
de que resultará útil especificar e implementar un TAD para gestionar la información de una colección de monedas, o
monedero, y otro para gestionar la información de una colección de frutas, o frutero.
En primer lugar, tendremos que especificar el TAD moneda:
espec monedas
usa naturales
género moneda
{Los valores del TAD moneda representan valores posibles de una moneda}

-- 45 of 267 --

38
operaciones
c1: -> moneda
{devuelve una moneda de 1 céntimo}
c10: -> moneda
{devuelve una moneda de 10 céntimos}
c50: -> moneda
{devuelve una moneda de 50 céntimos}
e1: -> moneda
{devuelve una moneda de 1 euro}
precio: moneda m -> natural
{devuelve el valor de la moneda m en céntimos}
fespec
Para, a continuación, especificar las colecciones de monedas con las operaciones que se ha decidido definir:
espec monederos
usa monedas, naturales
género monedero
{Los valores del TAD monedero representan valores posibles de un multiconjunto (saco) de monedas}
operaciones
vacio: -> monedero
{devuelve un monedero vacío, sin monedas}
meter: monedero s, moneda m -> monedero
{devuelve el monedero resultante de añadir la moneda m a s}
sacar: monedero s, moneda m -> monedero
{devuelve el monedero resultante de extraer la moneda m de s;
si no hay ninguna moneda m en s, devuelve un monedero igual a s}
cuántas: monedero s, moneda m -> natural
{devuelve el nº de monedas de valor m en s}
valor: monedero s -> natural
{devuelve la suma de los valores de todas las monedas de s}
fespec
El pseudocódigo resultante (una posible implementación de los TAD moneda y monedero) sería:
