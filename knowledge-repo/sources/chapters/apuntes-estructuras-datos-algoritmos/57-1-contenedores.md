# 1. Contenedores

La mayor parte de TAD que vamos a definir e implementar son contenedores de datos, es decir, agregaciones de
varios datos (frecuentemente muchos) en una unidad conceptual, el contenedor, incluyendo también en ese contenedor las
operaciones para manipularlos.
Se trata de TAD fundamentales y algoritmos de uso frecuente, que todo ingeniero en informática debe conocer y saber
implementar y utilizar para poder diseñar soluciones en los nuevos contextos o problemas. En su mayor parte serán TAD
genéricos, de forma que lo importante no será tanto el tipo concreto de sus elementos, sino la colección de operaciones
para su manipulación y su semántica.
Veremos algunos contenedores que incluirán agregaciones de elementos de un mismo tipo, sin necesidad de
almacenar relaciones de orden, de secuencia, de jerarquía, o de otro tipo, entre ellos, más allá de la relación de pertenencia
a un mismo contenedor. Ejemplos típicos de estos contenedores son:
• 	Conjuntos de elementos
• 	Multiconjuntos de elementos
• 	Diccionarios (también denominados mapas o tablas)
• 	Etc.
Veremos otros contenedores que incluirán agregaciones de elementos de un mismo tipo que permitirán reflejar las
relaciones o interacciones entre los elementos; relaciones de orden, de secuencia, de jerarquía, de incidencia previa o
posterior, que se dan en la realidad y permiten plantear soluciones sencillas y eficientes. Ejemplos típicos de estos
contenedores son:
• 	Colas (de clientes esperando delante de una ventanilla para recibir un servicio, por ejemplo)
• 	Pilas (de libros colocados encima de una mesa)
• 	Listas (de tareas pendientes)
• 	Árboles que representan jerarquías o clasificaciones (como el árbol de directorios y ficheros en un sistema
operativo)
• 	Grafos (que representan conectividad o dependencias entre elementos)
• 	Etc.
Pasamos a describir muy brevemente algunas características de unos cuantos de estos contenedores importantes.
Un conjunto es un TAD genérico cuyo dominio de valores es una colección de 0, 1 o más elementos. No se admiten
elementos repetidos en un conjunto, es decir, un elemento está o no está en un conjunto dado. Las operaciones típicas de
manipulación de conjuntos incluyen:
• 	crear: crea un conjunto vacío, sin elementos
• 	añadir: dado un elemento, si no pertenece al conjunto, lo añade

-- 55 of 267 --

48
• 	¿pertenece?: dado un elemento comprueba si se encuentra en el conjunto
• 	quitar: dado un elemento, si pertenece al conjunto lo elimina
• 	cardinal: devuelve el número de elementos en el conjunto
• 	¿esVacío?: comprueba si el conjunto está vacío (no contiene ningún elemento)
• 	eliminarTodos: elimina todos los elementos del conjunto, dejándolo vacío
• 	unión de conjuntos
• 	diferencia de conjuntos
• 	intersección de conjuntos
• 	…
En algunas de esas operaciones pueden producirse situaciones de error, que habrá que especificar convenientemente y
tener en cuenta posteriormente al implementar el TAD. Por ejemplo, ¿qué sentido tiene intentar añadir a un conjunto un
elemento que no pertenezca al tipo de elementos del conjunto?
Un multiconjunto, también denominado saco o bolsa, es un TAD genérico cuyo dominio de valores es una colección
de 0, 1 o más elementos; a diferencia de lo que ocurre en un conjunto, en un multiconjunto cada elemento puede estar
repetido un determinado número de veces (recordar el TAD genérico saco especificado e implementado en la lección
anterior). Las operaciones típicas de manipulación de multiconjuntos incluyen:
• 	crear: crea un multiconjunto vacío, sin elementos
• 	añadir: añade un ejemplar de un elemento al multiconjunto
• 	¿pertenece?: dado un elemento, comprueba si se encuentra en el multiconjunto
• 	multiplicidad: dado un elemento, devuelve el número de ejemplares del elemento en el multiconjunto
• 	quitar: dado un elemento, si existe en el multiconjunto, elimina una de sus apariciones
• 	cardinal: devuelve el número total de ejemplares de elementos en el multiconjunto (teniendo en cuenta la
multiplicidad)
• 	¿esVacío?: comprueba si el multiconjunto está vacío (no contiene ningún elemento)
• 	eliminarTodos: elimina todos los elementos del multiconjunto, dejándolo vacío
• 	unión de multiconjuntos
• 	diferencia de multiconjuntos
• 	intersección de multiconjuntos
• 	…
De nuevo, como en el caso de los conjuntos, pueden producirse algunas situaciones de error que conviene prever.
Un diccionario (o mapa o tabla) es un TAD genérico cuyo dominio de valores es una colección de 0, 1 o más elementos
formados por pares <clave, valor>. Tiene, por tanto, dos parámetros formales de tipo: el tipo clave y el tipo valor. Además,
en un diccionario no puede haber dos parejas con la misma clave. Es decir, las claves en un diccionario son únicas. Una
forma alternativa de definirlos es como una función que asocia datos de tipo valor a datos de tipo clave, es decir, cada clave
perteneciente al dominio del diccionario, tiene asociado un valor. Por eso al TAD diccionario se le denomina también TAD
funcional o asociativo. Las operaciones típicas de manipulación de diccionarios son operaciones de acceso por clave:
• 	crear: crea un diccionario vacío, sin elementos
• 	añadir: dada una clave y un valor, asigna el valor a la clave en el diccionario
• 	¿pertenece?: dada una clave, devuelve un booleano que indica si la clave está en el diccionario
• 	obtenerValor: dada una clave, devuelve el valor asociado a ella en el diccionario
• 	quitar: dada una clave, la borra del diccionario junto con su valor asociado
• 	cardinal: devuelve el número de elementos (parejas <clave,valor>) en el diccionario
• 	¿esVacío?: comprueba si el diccionario está vacío (no contiene ningún elemento)
• 	…

-- 56 of 267 --

49
Convendrá detectar y especificar las posibles situaciones de error. Por ejemplo: si se intentan obtener valores de claves
no existentes en el diccionario.
Existe un gran abanico de TAD lineales, o listas, que se caracterizan porque su dominio de valores son las secuencias
de elementos de un cierto tipo: <e1 , e2, … e n>, de longitud arbitraria, e incluyendo la secuencia vacía < >. Nótese que los
elementos de una secuencia tienen un orden dado por su posición en la secuencia: existe un primero, un segundo, …, un
último elemento de la secuencia, salvo que la secuencia sea vacía. Con ese mismo dominio de valores (genérico) se pueden
definir multitud de TAD dependiendo de las restricciones adicionales que puedan imponerse sobre los valores de la
secuencia y también sobre el conjunto de operaciones de manipulación que se consideren:
• 	Secuencias con o sin elementos repetidos.
• 	Datos de la secuencia ordenados con respecto a sus valores (por ejemplo, por orden alfabético) o no.
• 	Datos de la secuencia ordenados con respecto a criterios diferentes a los valores de los datos (por ejemplo, el
orden de llegada o inserción).
• 	Un subconjunto de operaciones muy habituales son las de crear (la secuencia vacía), añadir (un elemento a la
secuencia), averiguar si es vacía la secuencia, quitar un elemento de la secuencia, saber si un elemento
pertenece a la secuencia, tamaño o longitud de la secuencia, etc.
• 	Además, puede haber operaciones de acceso y recorrido, siguiendo el orden de la secuencia de elementos (los
denominados iteradores, de los que hablaremos enseguida).
• 	Evidentemente, la semántica del par de operaciones añadir elemento/quitar elemento puede cambiar, dando
lugar a distintos TAD. Pueden ser operaciones:
o 	limitadas a determinados extremos de la secuencia (TAD pila, cola, bicola…),
o 	relativas a la posición en la secuencia (listas con acceso por posición),
o 	relativas al último elemento accedido o insertado (listas con punto de interés), …
Otra gran familia de TAD es la de tipos arborescentes, cuyo dominio son colecciones de datos que no se representan
de manera directa como una secuencia, sino en una jerarquía de árbol. Las variantes incluyen, entre otras muchas, el grado
del árbol (binarios o n–arios), la ordenación de los elementos en los vértices o nodos del árbol con respecto a algún criterio
relacionado o no con sus valores, las operaciones de manipulación (desde las de un simple diccionario hasta conjuntos de
operaciones con semántica más dependiente del dominio de aplicación, o de la posición de los elementos en el árbol, etc.)
También pueden definirse distintos TAD grafo, para almacenar y manipular diferentes tipos de grafos: dirigidos o no,
con pesos en las aristas o no, bipartitos o no, etc. De nuevo, la panoplia de operaciones es amplia y depende mucho del tipo
de grafo y del dominio de aplicación (algoritmos de cálculo de distancias, de caminos mínimos, de cálculo de árboles de
recubrimiento, etc).