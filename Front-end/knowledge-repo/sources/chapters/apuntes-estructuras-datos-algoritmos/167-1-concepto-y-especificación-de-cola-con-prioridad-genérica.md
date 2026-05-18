# 1. Concepto y especificación de cola con prioridad genérica

Una cola con prioridad es un TAD genérico cuyo dominio de valores son las colecciones de elementos dotados de
un valor comparable, denominado prioridad del elemento, y operaciones de insertar un nuevo elemento, observar un
elemento de máxima prioridad y borrar un elemento de máxima prioridad. Es decir, los elementos se extraen o “salen de
la cola” por orden, según su prioridad.
Una metáfora admisible para el TAD es la de una sala de espera a la que llegan clientes, cada uno con su prioridad, y
son servidos por un agente según el orden marcado por su prioridad (de mayor a menor prioridad).
Nótese que varios elementos pueden tener la misma prioridad. En ese caso, el elemento denominado “de máxima
prioridad” es uno cualquiera de los que tengan el valor máximo de prioridad.
Una especificación del TAD genérico cola con prioridad es la siguiente.
espec colasConPrioridadesDeMáximos
usa booleanos
parámetro formal
género elemento
operación _ ≤ _: elemento e1, elemento e2 -> booleano {suponemos que en el género elemento hay definida una
relación de orden “≤” y se interpreta que a ≤ b significa
que b tiene más prioridad que a}
fpf
género cp {cola de elementos con prioridad (de máximos), su dominio son colecciones de elementos dotados de
una relación de orden que define su prioridad relativa}
operaciones
crearVacía: -> cp
{Devuelve una cola vacía, sin elementos}
añadir: cp c, elemento e -> cp
{Devuelve la cola resultante de añadir un ejemplar del elemento e a la cola c}
4
8
8 	5

-- 175 of 267 --

168
esVacía?: cp c -> booleano
{Devuelve verdad si y sólo si c no tiene elementos}
parcial max: cp c -> elemento
{Devuelve un elemento máximo de c. Parcial: la operación no está definida si c es vacía}
eliminarMax: cp c -> cp
{Si c no es vacía, devuelve una cola igual a la resultante de eliminar de c un elemento máximo según la
relación de orden definida por la función “≤”. Si c es vacía, queda igual.}
fespec
El TAD definido por la especificación anterior se denomina cola con prioridad de máximos, puesto que el elemento
destacado (por la operación “max”) y el eliminado (con “eliminarMax”), es un elemento máximo para la relación de orden
definida sobre los elementos. De manera análoga se puede especificar una cola con prioridad de mínimos, en ese caso las
operaciones definidas serían: crearVacía, añadir, esVacía?, min, y eliminarMin.