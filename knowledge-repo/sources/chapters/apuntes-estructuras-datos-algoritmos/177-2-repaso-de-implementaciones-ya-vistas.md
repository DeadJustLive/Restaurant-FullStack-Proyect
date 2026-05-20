# 2. Repaso de implementaciones ya vistas

En el tema sobre tipos lineales ya repasamos un par de implementaciones estáticas sencillas (basadas en un vector
desordenado u ordenado) del TAD diccionario, y vimos en detalle una implementación dinámica basada en listas
enlazadas con punteros, ordenadas por claves.
En el tema sobre árboles vimos en detalle una implementación con árboles de búsqueda binarios (no equilibrados),
y también vimos las ideas sobre varias implementaciones con árboles de búsqueda equilibrados (binarios, como los AVL,
o n–arios, como los árboles B y sus variantes).
También vimos en el tema de árboles que si el dominio de las claves es una secuencia de símbolos (por ejemplo,
cadenas de caracteres), se puede implementar el TAD diccionario mediante un árbol lexicográfico.
Además, existe un caso muy especial (por poco frecuente) que es aquél en el que el dominio de las claves coincida
con valores consecutivos de un tipo de dato escalar y enumerable que pueda ser usado como tipo de los índices de un
vector, por ejemplo, los naturales desde 1 hasta un cierto valor max. En ese caso, el diccionario se puede almacenar en un
vector v[1..max] de valores, o, de forma más precisa, de registros con dos campos: uno de tipo valor y otro booleano para

-- 186 of 267 --

179
indicar si esa clave existe o no en el diccionario. En esa representación, las claves ni siquiera se almacenan. Se denomina
representación de acceso directo y el coste de las operaciones de búsqueda, inserción y borrado está en O(1).
A modo de resumen, la siguiente tabla incluye los costes en el caso peor de las operaciones fundamentales para las
representaciones comentadas.
Representación 	insertar 	modificar valor 	obtener el valor 	borrar
Acceso directo (vector) 	O(1) 	O(1) 	O(1) 	O(1)
Vector ordenado 	O(n) 	O(log n) 	O(log n) 	O(n)
Lista enlazada ordenada 	O(n) 	O(n) 	O(n) 	O(n)
árbol de búsqueda equilibrado 	O(log n) 	O(log n) 	O(log n) 	O(log n)
Como puede verse, siempre que sea posible, es preferible la representación de acceso directo. Pero la mayor parte de
las veces, no es posible pues el dominio de las claves no puede usarse directamente como índices de un vector. En esos
casos, la representación de árbol de búsqueda equilibrado resulta la mejor en cuanto a costes temporales en el caso peor.
Si no se necesita garantizar un coste en el caso peor pequeño y basta con un coste en el caso promedio, existe una
alternativa útil que es la de tabla dispersa (en inglés, hash), que vemos a continuación.