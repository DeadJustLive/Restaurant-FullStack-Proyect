# 1. Datos puntero y datos dinámicos

Un puntero es un dato cuyo valor es la dirección en memoria de otro determinado dato.
1467 	dato	1467	p
El valor de p puede verse como un apuntador (puntero) del dato, gráficamente se representa así:
dato	p
La dirección almacenada en un puntero va a ser transparente al programador. A éste sólo le interesa conocer el valor
de un puntero como referencia a un determinado dato.
Los punteros con los que vamos a trabajar están especializados para servir como referencia de datos de un
determinado tipo.
Nuestro lenguaje algorítmico estará dotado del siguiente mecanismo constructor de datos puntero:
tipos tx = ...
...
tpPuntTx = ↑tx
...
variables p,q:tpPuntTx
Un puntero se puede utilizar para servir de referencia de datos creados dinámicamente (es decir, durante la ejecución
del algoritmo3) mediante la instrucción:
nuevoDato(p)
que tiene como efecto la reserva de espacio para almacenar una nueva variable del tipo apuntado por el puntero p, es
decir, del tipo tx; esta variable queda apuntada por el puntero p:
3 Se denominan datos estáticos los almacenados en las variables declaradas al principio de los algoritmos (variables estáticas) y datos dinámicos
los referenciados por un puntero (durante la ejecución del algoritmo). Los datos estáticos existen durante todo el tiempo de ejecución de su tiempo de
vida; se les asigna una zona de la memoria principal al comenzar la ejecución y se libera esa memoria al terminar la ejecución.

-- 69 of 267 --

62
?	p 	p 	dato
creado
antes 	después
Un dato creado dinámicamente no tiene ningún identificador asociado como nombre. Se puede hacer referencia a él
a través de algún puntero, p, que apunte al dato, de acuerdo con la siguiente sintaxis:
p↑
que significa “dato apuntado por el puntero p”.
p
p↑
A una variable de tipo puntero se le puede asignar el valor de otra variable de tipo puntero (ambos deben ser punteros
de datos del mismo tipo):
q:=p
Produciendo como efecto:
p
p↑
q q↑
En este caso, el dato creado dinámicamente puede ser accedido de dos formas:
p↑
q↑
Existe un valor constante, nil, que debe ser asignado a todo puntero que se desee que no apunte a ningún dato. A
cualquier variable de tipo puntero (independientemente del tipo del dato al que apunte) puede ser asignado dicho valor:
p:=nil
La acción opuesta a nuevoDato es disponer:
disponer(p)
Se llama “recolección de basura” a la gestión manual o automática de la memoria dinámica. La instrucción disponer
es la que permite al programador responsabilizarse de la recolección (manual) de basura. Esta instrucción libera la zona de
memoria que ocupaba el dato apuntado por el puntero p. Hay lenguajes que permiten la gestión manual (como el C++) y
otros que no (como el Java).
Finalmente, dos datos de tipo puntero (a datos del mismo tipo) pueden ser comparados con los operadores relacionales
de igualdad (=) o desigualdad (≠).

-- 70 of 267 --

63