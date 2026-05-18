# 2. Calcular la solución llenando una tabla desde abajo hacia arriba.

## Fuente
problemas-y-algoritmos (Cap. 47)

## Contenido
# 2. Calcular la solución llenando una tabla desde abajo hacia arriba.

Algunos autores hablan de un tercer paso llamado reconstruir la solu-
ción, que consiste en encontrar la mejor solución una vez que se tiene calcu-
lada la tabla.
El problema con este tercer paso es que funciona bien cuando se trata de
problemas de optimización combinatoria, pero cuando se trata de problemas
de conteo o de probabilidad no tiene mucho sentido hablar de reconstruir la
solución. ½De hecho con los conejos de Fibonacci algo análogo a reconstruir
la solución sería imprimir la ascendencia de todos los conejos que se tienen
al nal!, lo cual es mucho mas tardado que contarlos.
Y por supuesto, el paso de encontrar la subestructura óptima suele ser
tremendamente mas difícil que el de llenar la tabla, así que este método de
dos pasos no nos ayuda mucho y tenemos que encontrar uno mejor.

-- 270 of 315 --

20.2. EL LADRÓN Y LA MOCHILA 271
20.2. El Ladrón y la Mochila
A continuación abordaremos otro problema que comunmente se toma
como ejemplo de programación dinámica, se le conoce como el problema de
la Mochila o knapsack.
El problema habla de un ladrón que lleva una mochila con una capacidad
C y se encuentra en un lugar con N tipos de objetos, donde cada objeto i
tiene un precio Pi y un volúmen Vi, tanto el precio como el volúmen de cada
objeto son enteros.
Problema Resuelto 20.2.1. Escribir un programa que dados C, N , P y V
determine la suma máxima de precios que puede obtener el ladrón robando
cualquier cantidad de objetos de cada tipo de tal manera que la suma de
todos los volúmenes no exceda C.
El programa debe de funcionar en tiempo O(CN ).
Solución Al toparse por primera vez con este problema, muchos(incluido
el autor) caen en la ingenuidad de pensar que lo único que tienen que hacer es
calcular una razón precio
volumen para cada tipo de objeto y posteriormente tomar
aquellos objetos que puedan caber en la mochila y que su razón sea mayor.
Este algoritmo, a pesar de que suena coherente, es completamente erró-
neo, por ejemplo, se puede tener una mochila de capacidad 6, un tipo de
objeto con volúmen 5 y precio 11, y otro tipo de objeto con volúmen 2 y
precio 4.
Los objetos del primer tipo tienen una razón de 11
5 y los de segundo tipo
de 4
2 , por lo tanto el algoritmo descrito tomaría un objeto del primer tipo
y terminaría obteniendo una suma de precios de 11, mientras que se puede
hacer algo mejor: tomar 3 objetos del segundo tipo obteniendo un precio
total de 12.
Luego de ver este contraejemplo es posible que muchos intenten parchar
el algoritmo para que pueda funcionar con ese caso; pero la recomendación
del autor es la siguiente: no se deben de intentar parchar algoritmos que esten
incorrectos, puede que la idea resulte útil para resolver un problema parecido
o para acotar, pero intentar generar un algoritmo correcto a partir de arreglar
casos particulares es algo que generalmente está destinado al fracaso.
Habiéndonos olvidado de el tentador algoritmo incorrecto, abordaremos
este problema de una manera perecida a los otros.
Podemos observar que si elegimos un objeto de tipo i, nos quedará un
problema equivalente a llenar una mochila con capacidad de C − Vi.
No necesitamos considerar la opción de sacar objetos que ya estan dentro
de la mochila, puesto que introducir un objeto y luego quitarlo nos deja con

-- 271 of 315 --

272CAPÍTULO 20. PROGRAMACIÓN DINÁMICA EN LOS ESPACIOS DE BÚSQUEDA
el mismo resultado que si nunca se hubiera introducido.
Si recordamos el tipo de observaciones útiles que se vieron en el capítulo
anterior, veremos que si tenemos una capacidad restante k, entonces sin im-
portar cómo se hayan llenado los primeros C − k espacios de la mochila, la
solución es la misma. ½Las posibles capacidades restantes son un conjunto de
estados!.
También hay un conjunto de cambios de estado, y es fácil ver cuál es, ya
que la capacidad restante cambia sí y solo sí se mete un nuevo objeto a la
mochila. Así que el conjunto de estados son los objetos que se pueden meter
a una mochila de una capacidad dada.
Una consideración que simplica un poco el problema es tomar en cuenta
la opción de desperdiciar espacio. Esto es práctico ya que puede que la mejor
solución no llene toda la mochila. Así que otro cambio de estado es desperdi-
ciar una unidad de espacio, si se quiere desperdiciar mas de una unidad basta
con desperdiciar varias veces una unidad.
Algo que quizá pasamos por alto pero al nal resultará importante es que
una mochila de capacidad 0 otorga siempre una suma de precios de 0.
Resumiendo y precisando, si llamamos G(k) a la mayor suma de precios
que se puede obtener con una mochila de capacidad k tenemos que:
G(k) = 0 si k = 0 (20.1)
= max({G(k − Vi) + Pi con Vi ≥ k}, G(k − 1)) si k>0 (20.2)
Lo cual nos deja con una función recursiva. Si miramos bien la fórmula,
nos daremos cuenta que G(k) está denido solamente en base a los valores
de la entrada, a G(k − 1) y a G(k − Vi), estas dos expresiones tienen en
