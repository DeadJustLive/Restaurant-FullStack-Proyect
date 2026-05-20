# 2. Implementaciones estáticas sencillas

Se han propuesto varias representaciones estáticas (basadas en un vector de registros) sencillas para datos de tipo
diccionario. Las más representativas son:
• 	Representación desordenada: consiste en almacenar los pares de datos del diccionario en las primeras componentes
contiguas de un vector: vector[1..max] de par(c,v) , sin ordenar con ningún criterio (ese par(c,v) representa
una tupla o registro con la clave y el valor).
Esta representación no requiere la existencia de una relación de orden total definida sobre el dominio de las claves. Con
esta representación, el coste en tiempo en el caso peor de las operaciones de búsqueda, inserción, y borrado esté en
O(n), siendo n el número de pares almacenados.
El coste en espacio es O(max), independientemente del cardinal del diccionario almacenado.
• 	Representación ordenada: consiste en almacenar el diccionario en las primeras componentes contiguas de un vector:
vector[1..max] de par(c,v) , ordenando los pares (c,v) por valores crecientes de la clave.
Esta representación sí que requiere la existencia de una relación de orden total (“_<_”) definida sobre el dominio de las
claves.
El coste en espacio es, como antes, O(max). El coste en tiempo en el caso peor de las operaciones de inserción y borrado
vuelve a estar en O(n), siendo n el cardinal del diccionario. Sin embargo, el coste en tiempo en el caso peor de la
búsqueda de una clave (y su valor asociado) puede reducirse a O(log n), sin más que implementar una búsqueda
dicotómica de la clave. Esta representación es útil, por tanto, para tablas “poco dinámicas” (en las que hay pocas
inserciones y borrados y muchas consultas) pero es muy ineficiente para tablas muy dinámicas.
En general, la utilización de un vector conlleva que el número de pares del diccionario está acotado en todo momento
por el valor max (tamaño del vector), y ese valor queda fijado en tiempo de compilación.
Se plantea, como ejercicio sencillo de programación de primer curso, el realizar ambas implementaciones del TAD
diccionario.