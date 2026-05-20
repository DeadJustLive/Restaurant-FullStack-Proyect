# 4. Si quedan 3 vértices o más, regresa al paso 1

## Fuente
problemas-y-algoritmos (Cap. 44)

## Contenido
# 4. Si quedan 3 vértices o más, regresa al paso 1

Por ejemplo, el código de Prüfer asociado al árbol de la siguiente gura
es 9 7 7 7 9 6 6
4 7
2
6
9
5
1
8
3
Problema
Dado un código de Prüfer encuentra el árbol que genera ese código.
Entrada
Línea 1: Un entero n
Línea 2: n − 2 enteros separados por espacios representando el código de
Prüfer.

-- 222 of 315 --

16.9. PROBLEMAS 223
Ejemplo de Entrada
9
9 7 7 7 9 6 6
Salida
La salida deberá constar de N líneas, donde para cada 1 ≤ i ≤ n, la
i−ésima línea deberá indicar los números de los vértices unidos al vértice i
en orden ascendente y separados por espacios.
Si hay múltiples soluciones simplemente imprime una sola línea con la
palabra AMBIGUO.
Si no hay solución imprime una sola línea con la palabra IMPOSIBLE
Ejemplo de Salida
9
7
7
7
9
7 9
2 3 4 6
7 8 9
Límites
2 ≤ n ≤ 100000
Referencias
Este es un problema clásico ingeniado por el mismo Prüfer para demostrar
que el número de árboles con exactamente n nodos es nn−2.
El problema fue redactado por Luis Enrique Vargas Azcona en Junio de
2009 para entrenar a la preselección nacional en la Olimpiada Mexicana de
Informática.

-- 223 of 315 --

224 CAPÍTULO 16. GRAFOS
16.10. Sugerencias
Una Ciudad Unida
Considera hayar las componentes conexas en lugar de hacer una búsqueda
independiente con cada vértice.
Abba
Piensa en un grafo G = (V, A) donde V consta de los 26 caracteres del
alfabeto inglés y {v, w} ∈ A sí y solo sí en algún momento hay que cambiar
alguna letra v ó alguna letra w(nótese que al decir letra v y letra w esta
sugerencia se reere a cualquier letra en V , no a los caracteres v y w).
¾Qué sucede con ese grafo si se reemplazan todas las coincidencias de una
letra por otra?
Códigos de Prüfer
¾Qué sucede con las hojas de un árbol en su código de Prüfer correspon-
diente?. ¾Realmente es posible que la salida sea AMBIGÜO o IMPOSIBLE?

-- 224 of 315 --

Parte V
Algoritmos de Ordenamiento II
225

-- 225 of 315 --



-- 226 of 315 --

227
La parte de ordenamiento fue necesaria dividirla debido a que existen
algoritmos de ordenamiento que hacen uso de estructuras de datos.
En efecto, en general los árboles están diseñados parar organizar elemen-
tos con una función de comparación, así que no suena descabellado que se
puedan usar para ordenar.
Pero los árboles no sólo servirán para organizar los datos que se quier-
an ordenar, también jugarán un papel importante cuando descubramos que
no existe ningún algoritmo de ordenamiento basado en comparaciones cuya
complejidad sea menor que O(N log N).

-- 227 of 315 --

228

-- 228 of 315 --

Cap´ıtulo 17
Árboles y Ordenamiento
Cuando revisamos el algoritmo de selección optamos por elegir la estrate-
gia de encontrar el menor y colocarlo al principio. Sin embargo la forma de
encontrar el menor era O(N ), en este corto capítulo volveremos a aplicar esa
estrategia pero los árboles nos servirán para realizarla mas rápido.
17.1. Ordenamiento por Árboles Binarios de Búsque-
da
Los árboles binarios de búsqueda serán la primera estructura de datos
que usaremos para ordenar.
Nos basaremos en la implementación que se mencionó en la sección 14.1:
1 Tipo c l a v e [ maximo de nodos ] ;
2 int i z q [ maximo de nodos ] ;
3 int der [ maximo de nodos ] ;
4 int nodos =0;
Ya vimos en la sección 14.4 cómo insertar nodos en el árbol, pero aún no
hemos visto cómo usarlo para ordenar.
Recurriremos a uno de los tres recorridos, el llamado recorrido en órden.
El siguiente teorema revelará por qué el libro no deja de pregonar que los
árboles binarios de búsqueda son útiles para el ordenamiento.
Teorema 33. Un recorrido en órden en un árbol binario de búsqueda procesa
los nodos en órden no descendente con respecto a sus claves.
Demostración. Utilizando inducción, en un árbol binario de búsqueda con
un solo nodo, solamente se visita un nodo, por lo cual el órden en que los
nodos se visitan es no descendente.
229

-- 229 of 315 --

230 CAPÍTULO 17. ÁRBOLES Y ORDENAMIENTO
Supongamos que para alguna k todos los árboles binarios de búsqueda
con k′ < k nodos. Imaginemos un árbol binario de búsqueda que tiene exac-
tamente k nodos.
Tanto su rama izquierda como su rama derecha son árboles binarios de
búsqueda, y además, tienen menos de k nodos.
Al recorrer su rama izquierda, todos sus nodos se visitarán en orden no
descendente, al visitar la raíz, por la denición de árbol binario de búsqueda,
su clave será mayor o igual que todas las claves de los nodos ya visitados.
Finalmente, al recorrer la rama derecha, todos los nodos tendrán claves
mayores o iguales que los nodos que ya se habían visitado, además, como la
rama derecha es un árbol binario de búsqueda con menos de k nodos, también
se visitarán dichos nodos en órden.
Asi que la forma de ordenar con un árbol binario de búsqueda es simple-
mente insertar todos los elementos y luego hacer un recorrido en órden.
El recorrido en órden toma tiempo lineal, sin embargo la inserción puede
tomar tiempo cuadrático. Como aquí se supone que sabemos de
