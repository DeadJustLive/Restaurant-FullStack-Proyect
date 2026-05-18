# apuntes-estructuras-datos-algoritmos

- **ID**: apuntes-estructuras-datos-algoritmos
- **Método**: native
- **Páginas**: 267
- **Capítulos**: 259
- **Generado**: 2026-05-17T09:15:22.468Z

## Resumen

# Tema I:: Programación con Tipos Abstractos de Datos ..................................................................................... 1

## Capítulos

### Cap. 1 — Tema I:: Programación con Tipos Abstractos de Datos ..................................................................................... 1

# Tema I:: Programación con Tipos Abstractos de Datos ..................................................................................... 1

### Cap. 2 — Lección 1:: Tipos Abstractos de Datos (TAD) ......................................................................................... 3

# Lección 1:: Tipos Abstractos de Datos (TAD) ......................................................................................... 3

### Cap. 3 — Lección 2:: Especificación de TAD ........................................................................................................ 17

# Lección 2:: Especificación de TAD ........................................................................................................ 17

### Cap. 4 — Lección 3:: Implementación de TAD...................................................................................................... 25

# Lección 3:: Implementación de TAD...................................................................................................... 25

### Cap. 5 — Lección 4:: TAD genéricos ..................................................................................................................... 35

# Lección 4:: TAD genéricos ..................................................................................................................... 35

### Cap. 6 — Lección 5:: TAD fundamentales ............................................................................................................. 47

# Lección 5:: TAD fundamentales ............................................................................................................. 47

### Cap. 7 — Tema II:: Tipos de datos lineales...................................................................................................................... 53

# Tema II:: Tipos de datos lineales...................................................................................................................... 53

### Cap. 8 — Lección 6:: El TAD pila genérica. Definición e implementación estática .............................................. 55

# Lección 6:: El TAD pila genérica. Definición e implementación estática .............................................. 55

### Cap. 9 — Lección 7:: Datos puntero y estructuras dinámicas de datos .................................................................. 61

# Lección 7:: Datos puntero y estructuras dinámicas de datos .................................................................. 61

### Cap. 10 — Lección 8:: Implementación dinámica de pilas....................................................................................... 65

# Lección 8:: Implementación dinámica de pilas....................................................................................... 65

### Cap. 100 — Lección 20

# Lección 11

Introducción a los árboles
Indice

### Cap. 101 — 1. Concepto y ejemplo introductorio

# 1. Conceptos, definiciones y terminología básica

### Cap. 102 — 2. Especificación de tablas bidimensionales

# 2. Los árboles como estructura de datos para representar TAD contenedores

### Cap. 103 — 3. Implementación con estructuras de listas múltiples

Gráficamente, un árbol ordenado con raíz x y subárboles A1 , …, A m puede representarse como indica la figura 1.

Secciones:
  # 1. Conceptos, definiciones y terminología básica

Conclusión: El grado de un árbol es el número máximo de hijos que pueden tener sus nodos (si el árbol es n–ario su grado es n; si
es binario, su grado es dos).

### Cap. 104 — 1. Concepto y ejemplo introductorio

# 2. Los árboles como estructura de datos para representar TAD contenedores En programación, utilizaremos estructuras arborescentes (árboles) para almacenar colecciones de datos de un mismo tipo (par Secciones: # 2. Los árboles como estructura de datos para representar TAD contenedores Conclusión: Por ejemplo, conjuntos o multiconjuntos de elementos, diccionarios o tablas, u otros, que decidamos representar en una estructura de árbol con objeto de mejorar la eficiencia en tiempo de las operaciones de manipulación con respecto a la eficiencia...

### Cap. 105 — 2. Especificación de tablas bidimensionales

# Lección 12

Árboles binarios
Indice

### Cap. 106 — 3. Implementación con estructuras de listas múltiples

# 1. Concepto y especificación

### Cap. 107 — ANEXOS

# 2. Implementación estática

### Cap. 108 — 1. Conceptos básicos

# 3. Implementación dinámica

### Cap. 109 — Lección 16:: Árboles n–arios de búsqueda ........................................................................................... 149

# 4. Recorridos

### Cap. 11 — Lección 11

# Lección 9:: El TAD cola genérica........................................................................................................... 75

### Cap. 110 — 2. Especificación

# 1. Concepto y especificación

Como ya se adelantó en la lección previa, un árbol binario es un conjunto de elementos o nodos del mismo tipo tal que:
• 	o bien es el conjunto vacío, y entonces se lla

Secciones:
  # 1. Concepto y especificación

Conclusión: Parcial: la operación no está definida si no existeSiguiente?

### Cap. 111 — 3. Representación con matriz de adyacencia

El árbol vacío se representa dando el valor 0 a la variable de tipo arbin.

Secciones:
  # 2. Implementación estática

Conclusión: La implementación de las operaciones de árboles binarios representados en un vector almacenando cursores a los hijos
se plantea como ejercicio (añádanse además las operaciones de duplicar árbol y de comparación de igualdad, y estúdiese el
coste de todas las operaciones).

### Cap. 112 — 4. Representación con listas de adyacencia

# 3. Implementación dinámica

Veamos ahora la implementación dinámica de árboles binarios obtenida enlazando mediante punteros los registros que
guardan la información de cada nodo. Será una implement

Secciones:
  # 3. Implementación dinámica

Conclusión: Binarios}
El coste de las operaciones anteriores está en O(1), excepto para las que tienen que recorrer todo el árbol, que son:
altura, duplicar, liberar e iguales, cuyo coste es lineal en el número de elementos del árbol, en el caso peor.

### Cap. 113 — 5. Representación con listas múltiples de adyacencia

# 4. Recorridos

Para poder implementar las operaciones del iterador especificado para árboles binarios, deberemos decidir un orden
en el cual visitar todos los elementos del árbol, pasando una vez y sólo una por cada uno de los elementos. Ese orden
puede fijarse de muchas formas, existiendo al menos cuatro diferentes perfectamente identificables en la literatura:
• 	Recorridos en profundidad:

### Cap. 114 — 1. Conceptos básicos

# 1. 	Recorrido en pre-orden:

1. 	se visita la raíz,
2. 	se recorre en pre-orden el subárbol izquierdo, y
3. 	se recorre en pre-orden el subárbol derecho.

### Cap. 115 — 2. Especificación

# 2. 	Recorrido en post-orden:

1. 	se recorre en post-orden el subárbol izquierdo,
2. 	se recorre en post-orden el subárbol derecho, y
3. 	se visita la raíz.

### Cap. 116 — 3. Representación con matriz de adyacencia

Se presentan a continuación las implementaciones recursivas de recorridos de árboles binarios.

Secciones:
  # 3. 	Recorrido en in-orden u orden central:

Conclusión: Que aux≠nil hacer
apilar(a.

### Cap. 117 — 4. Representación con listas de adyacencia

# Lección 13

Árboles binarios de búsqueda
Indice

### Cap. 118 — 5. Representación con listas múltiples de adyacencia

# 1. Concepto y especificación

### Cap. 119 — 1. Introducción al esquema de vuelta atrás

# 2. Implementación dinámica

### Cap. 12 — 1. Conceptos, definiciones y terminología básica

# Lección 10:: El TAD diccionario. Implementación con listas enlazadas ordenadas .............................. 87

### Cap. 120 — Lección 17:: Árboles lexicográficos (o tries)........................................................................................ 159

# 3. Implementación del TAD diccionario con ABB

### Cap. 121 — 2. Ejemplo: el problema de las ocho reinas

Las operaciones básicas con árboles de búsqueda son la inserción y la búsqueda de elementos.

Secciones:
  # 1. Concepto y especificación

Conclusión: Devuelve verdad si y sólo si hay algún ejemplar de e está en a}
borrar: abb a, elemento e -> abb
{Si e está en a, devuelve un árbol igual al resultante de borrar una de las apariciones de e en a.

### Cap. 122 — 3. Ejemplo: recorrido de un laberinto

O(1).

Secciones:
  # 2. Implementación dinámica

Conclusión: Desde un punto de vista práctico, si no se precisa garantizar un coste en tiempo bajo en el caso peor y es suficiente
con obtener un coste bajo en el caso promedio, los árboles binarios de búsqueda son una buena solución pues puede
demostrarse que la altura promedio de un ABB generado aleatoriamente tiene orden logarítmico.

### Cap. 123 — 4. Árboles de juego: estrategia minimax

Nótese que la interfaz del módulo es idéntica a la vista en la lección 10. Secciones: # 3. Implementación del TAD diccionario con ABB Conclusión: Tal y como se dijo en la sección anterior, si no es necesario garantizar un coste bajo en el caso peor y nos conformamos con el caso promedio, un ABB es una buena solución para almacenar un diccionario porque puede demostrarse que, en media, la altura de un ABB generado aleatoriamente es logarítmica en el...

### Cap. 124 — 1. Introducción al esquema de vuelta atrás

# Lección 14

Árboles AVL
Indice

### Cap. 125 — 2. Ejemplo: el problema de las ocho reinas

# 1. Definición y teorema de AVL

### Cap. 126 — 3. Ejemplo: recorrido de un laberinto

# 2. Representación de los árboles AVL

### Cap. 127 — 4. Árboles de juego: estrategia minimax

# 3. Inserción en AVL

### Cap. 128 — EM PATE 	EM PATE

# 4. Borrado en AVL

### Cap. 129 — 1. Estrategias voraces

Para demostrar esa afirmación, veamos cuál es la máxima altura h que puede tener un AVL de n nodos.

Secciones:
  # 1. Definición y teorema AVL

Conclusión: Si además se consigue una implementación de la inserción y del borrado que mantengan el árbol dentro
de la clase de los AVL, esas dos operaciones también tendrán garantizado un coste en O(log n) en el caso peor.

### Cap. 13 — 2. Los árboles como estructura de datos para representar TAD contenedores

# Tema III:: Tipos de datos arborescentes ........................................................................................................... 97

### Cap. 130 — 2. Aplicación al problema del recorrido del caballo de ajedrez

Decimos que un nodo es perfectamente equilibrado si su F e es 0, es decir, sus subárboles tienen la misma altura.

Secciones:
  # 2. Representación de los árboles AVL

Conclusión: Un
nodo se dice pesado a derechas si su F e es +1, es decir, la altura de su subárbol derecho es una unidad mayor que la del
izquierdo.

### Cap. 131 — Lección 18:: Colas con prioridad, montículos y el heapsort ................................................................ 167

# unidad m: ayor que la del derecho.

La implementación del algoritmo de búsqueda de una clave o elemento en un AVL es exactamente la misma que hemos
visto en la lección anterior para árboles de búsqu

Secciones:
  # unidad m: ayor que la del derecho.

Conclusión: Dado que en un AVL la altura está acotada por el logaritmo del número de nodos, el coste en el caso peor del algoritmo
anterior para AVL está en O(log n).

### Cap. 132 — 3. Aplicación al problema del viajante

# 3. Inserción en AVL

El proceso de inserción en un AVL consta de tres pasos:

### Cap. 133 — 1. Estrategias voraces

# 1. 	Buscar la clave hasta encontrar la posición de inserción o modificación del valor asociado. Es un proceso idéntico

al de la inserción en árbol binario de búsqueda. Si debe insertarse un nuevo nodo, se inserta siempre en una hoja.

### Cap. 134 — 2. Aplicación al problema del recorrido del caballo de ajedrez

# 2. 	Insertar el nuevo nodo hoja, con factor de equilibrio equilibrado.

### Cap. 135 — 3. Aplicación al problema del viajante

Evidentemente, la implementación más fácil de escribir es recursiva.

Secciones:
  # 3. 	Desandar 	el 	camino 	de 	búsqueda, 	verificando 	el 	equilibrio 	de 	los 	nodos 	del 	camino, 	y

Conclusión: Izq;
p↑.

### Cap. 136 — 1. Especificación: sintaxis

# 4. Borrado en AVL

En cuanto al proceso de borrado, tiene una dificultad similar. Se compone de dos partes:

### Cap. 137 — 2. Semántica de una especificación algebraica

# 1. 	Proceso de borrado como en un árbol binario de búsqueda:

a. 	Buscar el nodo a borrar.
b. 	Si el nodo es hoja, se borra.
c. 	Si no es hoja:
• 	se sustituye por el máximo del subárbol izquierdo, y
• 	se borra dicho máximo del subárbol izquierdo.

### Cap. 138 — 3. Construcción de especificaciones

Ejemplo: Borrar el nodo A del siguiente AVL.

Secciones:
  # 2. 	Se regresa por el camino de búsqueda calculando los nuevos factores de equilibrio:

Conclusión: Resumimos en la siguiente tabla los costes en espacio y tiempo, en el caso peor, de las implementaciones de
diccionarios vistas hasta el momento.

### Cap. 139 — 4. Verificación con especificaciones algebraicas

# Lección 15

Árboles n–arios
Indice

### Cap. 14 — 1. Conceptos, definiciones y terminología básica

# Lección 11:: Introducción a los árboles .................................................................................................. 99

### Cap. 140 — 1. Especificación: sintaxis

# 1. Conceptos y especificación

### Cap. 141 — Tema I: con el procedimiento info.

# 2. Recorridos

### Cap. 142 — Tema IV:: Tipos de datos funcionales ............................................................................................................ 175

# 3. Implementación dinámica

### Cap. 143 — 2. Semántica de una especificación algebraica

# 4. Ideas sobre implementación estática

### Cap. 144 — ¬ (T) = F; 	¬ (F) = T; 	¬ (KK) = KK

Para poder facilitar la especificación de árboles n–arios, se define además el concepto de bosque.

Secciones:
  # 1. Conceptos y especificación

Conclusión: Devuelve verdad si y sólo si a no tiene subárboles, es decir, numHijos(a) = 0}
alturaBosque: bosque b -> natural
{Si long(b) > 0, devuelve la altura del árbol más alto de b.

### Cap. 145 — T∧T = T; 	F∧F = F∧T = T∧F = F∧KK = KK∧F = F

# 2. Recorridos

De forma análoga a lo visto para árboles binarios, se pueden especificar varias operaciones de recorrido de árboles
ordenados. Todas ellas consisten en visitar todos los elementos del

Secciones:
  # 2. Recorridos

Conclusión: Por ejemplo, para el árbol 3–ario de la figura siguiente,
3
14 	15
9 	2 	6 	33
el recorrido en pre-orden es la lista 3-14-9-2-6-15-33, el recorrido es post-orden es 9-2-6-14-33-15-3, y el recorrido en
anchura es 3-14-15-9-2-6-33.

### Cap. 146 — T∧KK = KK∧T = KK; 	F∨F = F

Caben implementaciones alternativas a los procedimientos de recorridos de árboles y bosques como las siguientes.

Secciones:
  # 3. Implementación dinámica

Conclusión: Hermano,L)
fsi
fin
En ambos casos el parámetro de tipo “bosque” podría ser igualmente de tipo “árbol”, pues sirven para recorrer ambas
estructuras.

### Cap. 147 — T∨T = T∨F = F∨T = T∨KK = KK∨T = T; 	F∨KK = KK∨F = KK

Un árbol n–ario se dice homogéneo si todos sus subárboles excepto las hojas tienen n hijos.

Secciones:
  # 4. Ideas sobre implementación estática

Conclusión: Si el árbol es casi-completo, se desaprovechan algunas componentes del vector, pero
todas ellas situadas al final; por tanto, basta con almacenar en una variable entera auxiliar el índice de la última componente
que contiene un elemento del árbol.

### Cap. 148 — 1. 	El álgebra de términos cerrados sobre SIG, TSIG, es inicial en la clase ALG(SIG). El único homomorfismo de TSIG a

# parte d: e las componentes del vector. Además, sería preciso añadir en

cada componente un campo booleano que almacene si esa componente
guarda un elemento del vector o no.
La implementación de las

Secciones:
  # parte d: e las componentes del vector. Además, sería preciso añadir en

Conclusión: La implementación de las operaciones con árboles ordenados,
supuesta la representación calculada, se plantea como ejercicio.

### Cap. 149 — 2. 	El álgebra definida por ESPEC, TESPEC, es inicial en la clase ALG(ESPEC). El único homomorfismo f = {f g}g∈G,

# Lección 16

Árboles n–arios de búsqueda
Indice

### Cap. 15 — 2. Los árboles como estructura de datos para representar TAD contenedores

# Lección 12:: Árboles binarios ............................................................................................................... 103

### Cap. 150 — 3. Construcción de especificaciones

# 1. Definición

### Cap. 151 — 1. 	Si Gen(g) es un conjunto libre, sólo hay que escribir ecuaciones con las operaciones modificadoras y observadoras

# 2. Árboles n–arios de búsqueda equilibrados

### Cap. 152 — 2. 	Si Gen(g) es un conjunto no libre, un primer conjunto de ecuaciones se utiliza para hacer congruentes entre sí

# 3. Ejemplo de implementación (árboles 2–3)

### Cap. 153 — Lección 19:: El TAD tabla y las tablas dispersas (hash) ...................................................................... 177

Como ejemplo de árbol 3–ario de búsqueda, puede verse el de la siguiente figura.

Secciones:
  # 1. Definición

Conclusión: Los árboles n-arios de búsqueda son especialmente útiles cuando se utilizan en búsquedas externas (los datos
almacenados en disco, etc.

### Cap. 154 — 3. 	Para cada operación modificadora se escriben tantas ecuaciones como sean necesarias para garantizar que todo

Un tipo particular de árboles n–arios de búsqueda equilibrados son los árboles B.

Secciones:
  # 2. Árboles n–arios de búsqueda equilibrados

Conclusión: Mc Creight en “Organization and maintenance of large ordered indices”, Acta Informatica, vol.

### Cap. 155 — 4. 	Para cada operación observadora se escriben tantas operaciones como sean necesarias para garantizar que todo

Supongamos que en el árbol anterior se quiere insertar la clave 18.

Secciones:
  # 3. Ejemplo de implementación (árboles 2–3)

Conclusión: Hijo,c,exito,x)
sino {buscar en el tercer subárbol}
buscarRec(p↑.

### Cap. 156 — 4. Verificación con especificaciones algebraicas

# Lección 17

Árboles lexicográficos (o tries)
Indice

### Cap. 157 — 1. Transformación de algoritmos recursivos finales

# 1. Definición y características principales

### Cap. 158 — 2. Transformación de algoritmos recursivos lineales (no finales)

# 2. Implementaciones

### Cap. 159 — 3. Transformación de algoritmos recursivos múltiples: un caso particular

# 3. Detalles de la implementación nodo–lista

### Cap. 16 — Lección 12

# Lección 13:: Árboles binarios de búsqueda .......................................................................................... 115

### Cap. 160 — 4. Transformación de algoritmos recursivos múltiples: caso general

Un árbol lexicográfico o, en general, un trie, es un árbol de prefijos.

Secciones:
  # 1. Definición y características principales

Conclusión: Aplicaciones habituales de árboles lexicográficos son la manipulación de diccionarios (búsqueda, inserción, borrado,
etc.

### Cap. 161 — 1. Transformación de algoritmos recursivos finales

En la siguiente sección veremos una implementación completa utilizando esta representación de los datos.

Secciones:
  # 2. Implementaciones

Conclusión: Los PATRICIA se utilizan, por ejemplo, para implementar las tablas de encaminamiento en los router.

### Cap. 162 — 2. Transformación de algoritmos recursivos lineales (no finales)

# 3. Detalles de la implementación nodo–lista Como dijimos, la representación nodo–lista se corresponde con la representación primogénito–siguiente hermano de un árbol n–ario. Esta representación per Secciones: # 3. Detalles de la implementación nodo–lista Conclusión: Hermano) fsi fsi fsi fin El coste en tiempo en el caso peor es de orden lineal en la longitud de la cadena (insertada, buscada, o borrada), si bien incluye una constante multiplicativa alta, del orden del cardinal de valores posibles del tipo carácter elevado...

### Cap. 163 — 3. Transformación de algoritmos recursivos múltiples: un caso particular

# Lección 18

Colas con prioridad, montículos y el heapsort
Indice

### Cap. 164 — Lección 20:: Tablas multidimensionales............................................................................................... 189

# 1. Concepto y especificación de cola con prioridad genérica

### Cap. 165 — 4. Transformación de algoritmos recursivos múltiples: caso general

# 2. Implementación basada en un montículo o heap

### Cap. 166 — 1. 	Sintaxis para una especificación de TAD en lenguaje natural

# 3. Aplicación a la ordenación de elementos de un vector: el heapsort

### Cap. 167 — 2. 	Sintaxis del pseudocódigo

Nótese que varios elementos pueden tener la misma prioridad.

Secciones:
  # 1. Concepto y especificación de cola con prioridad genérica

Conclusión: Min.

### Cap. 168 — 1. Sintaxis para una especificación de TAD en lenguaje natural

Un montículo vacío se representa almacenando el valor 0 en el campo num.

Secciones:
  # 2. Implementación basada en un montículo o heap

Conclusión: La implementación detallada es la siguiente.

### Cap. 169 — 2. Sintaxis del pseudocódigo

# módulo c: olaConPrioridadesDeMáximos

parámetro
tipo elemento
con función “<”(e1,e2:elemento) devuelve booleano
{el tipo elemento tiene definida una función de orden que determina la prioridad}
expo

Secciones:
  # módulo c: olaConPrioridadesDeMáximos

Conclusión: Vacía(c:cp) devuelve booleano
{devuelve verdad si y sólo si c es la cola vacía}
principio
devuelve c.

### Cap. 17 — 1. Concepto y especificación

# Lección 14:: Árboles AVL .................................................................................................................... 127

### Cap. 170 — 1. 	Tipos de datos predefinidos

Para analizar el coste del algoritmo anterior, debe analizarse primero el coste del subalgoritmo empujar.

Secciones:
  # 3. Aplicación a la ordenación de elementos de un vector: el heapsort

Conclusión: Por tanto, el coste total del algoritmo de ordenación in situ de vectores, heapsort, está en O(n log n).

### Cap. 171 — 2. 	Definición de constantes

# TEMA IV

Tipos de datos funcionales

-- 183 of 267 --

176

-- 184 of 267 --

177

### Cap. 172 — 3. 	Definición de nuevos tipos de datos

# Lección 19

El TAD tabla y las tablas dispersas (hash)
Indice

### Cap. 173 — 4. 	Declaración de variables

# 1. Recordatorio del concepto de tabla o diccionario y su especificación

### Cap. 174 — 5. 	Instrucción de asignación

# 2. Repaso de implementaciones ya vistas

### Cap. 175 — 1. Concepto de abstracción

# 3. Tablas dispersas (o hash)

### Cap. 176 — 6. 	Operaciones con datos cadena

Como ya dijimos en una lección anterior, una tabla o diccionario es un conjunto o colección de pares.

Secciones:
  # 1. Recordatorio del concepto de tabla o diccionario y su especificación

Conclusión: Valor”.

### Cap. 177 — 7. 	Instrucciones de entrada/salida

Como puede verse, siempre que sea posible, es preferible la representación de acceso directo.

Secciones:
  # 2. Repaso de implementaciones ya vistas

Conclusión: Si no se necesita garantizar un coste en el caso peor pequeño y basta con un coste en el caso promedio, existe una
alternativa útil que es la de tabla dispersa (en inglés, hash), que vemos a continuación.

### Cap. 178 — 8. 	Instrucciones condicionales

No obstante, encontrar una función que distribuya bien no es fácil.

Secciones:
  # 3. Tablas dispersas (o hash)

Conclusión: Se denomina tabla dispersa (en inglés, hash table o hash map) a una representación del TAD diccionario (o mapa, o
tabla) basada en la utilización de una función de codificación no inyectiva, como se ha expuesto previamente, para acceder
a la posición de un vector en la que almacenar cada par.

### Cap. 179 — 9. 	Instrucciones iterativas

# 1. Elegir la función

h : Dominio de las claves  1..max
no inyectiva, que se denomina función de dispersión (o función de localización, de desmenuzamiento, o de
transformación, según otras traducci

Secciones:
  # 1. Elegir la función

Conclusión: Este hecho se conoce por el nombre de colisión.

### Cap. 18 — 2. Implementación estática

# Lección 15:: Árboles n–arios ................................................................................................................ 139

### Cap. 180 — 10. Procedimientos y funciones

Veamos más en detalle el primero de los pasos.

Secciones:
  # 2. Seleccionar un método para resolver las colisiones.

Conclusión: Si lo más frecuente es necesitar un recorrido ordenado por clave de todos los datos, una tabla dispersa no es
una buena solución.

### Cap. 181 — 11. Módulos

# Lección 20

Tablas multidimensionales
Indice

### Cap. 182 — 12. Módulos genéricos

# 1. Concepto y ejemplo introductorio

### Cap. 183 — 13. Uso de módulos genéricos

# 2. Especificación de tablas bidimensionales

### Cap. 184 — 14. Datos puntero

# 3. Implementación con estructuras de listas múltiples

### Cap. 185 — 15. Instrucciones de creación y uso de ficheros

Veamos un ejemplo sencillo en el que aparece de forma natural una tabla bidimensional.

Secciones:
  # 1. Concepto y ejemplo introductorio

Conclusión: Dato no actualizado.

### Cap. 186 — 2. Definición de TAD

Al igual que se hace con las tablas unidimensionales, la implementación de las operaciones está?

Secciones:
  # 2. Especificación de tablas bidimensionales

Conclusión: Valor
suele hacerse con un único procedimiento que devuelva un booleano y un valor.

### Cap. 187 — 3. Programación con TAD

De esta forma, un registro de matrícula no indica explícitamente el estudiante ni la asignatura que “empareja”. Secciones: # 3. Implementación con estructuras de listas múltiples Conclusión: Para cada nota de un estudiante en la asignatura dada, es preciso recorrer la lista horizontal de notas de ese estudiante (bucle interno del algoritmo; en el caso peor, lineal en el número total de asignaturas; en la práctica, lineal en el número de asignaturas en que está matriculado ese estudiante) hasta llegar...

### Cap. 188 — 4. Ventajas de la programación con TAD

# ANEXOS

Material adicional

-- 205 of 267 --

192

-- 206 of 267 --

193
Anexo 1: El TAD grafo y su representación en memoria
Indice

### Cap. 189 — 1. Concepto de abstracción

# 1. Conceptos básicos

### Cap. 19 — 3. Implementación dinámica

# Lección 16:: Árboles n–arios de búsqueda ........................................................................................... 149

### Cap. 190 — 2. Definición de TAD

# 2. Especificación

### Cap. 191 — 3. Programación con TAD

# 3. Representación con matriz de adyacencia

### Cap. 192 — módulo c: onjuntosDeCaracteres

# 4. Representación con listas de adyacencia

### Cap. 193 — módulo d: e declaración, contiene la definición del tipo de dato (nombre del tipo y encabezamientos de los algoritmos),

# 5. Representación con listas múltiples de adyacencia

### Cap. 194 — 4. Ventajas de la programación con TAD

Un grafo es una relación arbitraria entre objetos de un mismo tipo.

Secciones:
  # 1. Conceptos básicos

Conclusión: Si, por ejemplo,

-- 207 of 267 --

194
los vértices representan ciudades; las aristas, las posibles líneas de comunicación entre ellas; y el peso de una arista, el coste
de seleccionar esa línea de comunicación, un árbol de recubrimiento de peso mínimo representa una red de comunicaciones
entre todas las ciudades que minimiza el coste total.

### Cap. 195 — 1. Características generales de una especificación

El resto de operaciones de la signatura depende de la aplicación que se vaya a dar al TAD. Secciones: # 2. Especificación Conclusión: Parcial: no está definida si v1 o v2 no son vértices de g} perteneceVértice: vértice v, grafo g -> booleano {Devuelve verdad si y sólo si v es un vértice de g} perteneceArista: vértice v1, vértice v2, grafo g -> booleano {Devuelve verdad si y sólo si (v1,v2) es una arista de g} adyacentes: grafo g, vértice...

### Cap. 196 — 2. Especificación algebraica

Sea G = (V,A) un grafo dirigido y supóngase V = {1,2,…,n}.

Secciones:
  # 3. Representación con matriz de adyacencia

Conclusión: Más aún, para saber, por ejemplo, si un grafo no dirigido representado mediante su matriz de
adyacencia es conexo, o simplemente para conocer el número de aristas, los algoritmos requieren un tiempo en O(n2), lo
cual es más de lo que cabría esperar.

### Cap. 197 — 3. Especificación no formal

Acceder a la lista de los vértices adyacentes a uno dado lleva un tiempo constante.

Secciones:
  # 4. Representación con listas de adyacencia

Conclusión: Estas listas se llaman listas de adyacencia inversa.

### Cap. 198 — 1. Características generales de una especificación

En esta representación, hay un nodo por cada una de las aristas del grafo.

Secciones:
  # 5. Representación con listas múltiples de adyacencia

Conclusión: Nodo
Una ventaja de esta representación es que es útil para implementar aquellos algoritmos que necesitan recorrer un grafo
y al mismo tiempo “marcar” las aristas por las que se pasa (bastaría con añadir un campo booleano al tipo nodo).

### Cap. 199 — 2. Especificación algebraica

# 1. Introducción al esquema de vuelta atrás

### Cap. 20 — 4. Recorridos

# Lección 17:: Árboles lexicográficos (o tries)........................................................................................ 159

### Cap. 200 — 2. Especificación no formal

# 2. Ejemplo: el problema de las ocho reinas

### Cap. 201 — 1. Características de la implementación de un TAD

# 3. Ejemplo: recorrido de un laberinto

### Cap. 202 — 2. Implementación modular

# 4. Árboles de juego: estrategia minimax

### Cap. 203 — 1. Características de la implementación de un TAD

Un esquema muy útil de prueba y error es el de vuelta atrás o retroceso (en inglés, backtracking). Secciones: # 1. Introducción al esquema de vuelta atrás Conclusión: Entonces, el esquema de algoritmo de vuelta atrás toma la siguiente forma: -- 213 of 267 -- 200 procedimiento ensaya(ent i:entero) variable k:entero principio k:=0; repetir k:=k+1; seleccionar k-ésimo candidata; si aceptable entonces registrarla; si i<n entonces ensaya(i+1); si no exitoso entonces cancelar registro fsi fsi fsi hastaQue exitoso or (k=m) fin...

### Cap. 204 — 2. Implementación modular

El problema consiste en colocar ocho reinas sobre un tablero de ajedrez de forma que no se amenacen. Secciones: # 2. Ejemplo: el problema de las ocho reinas Conclusión: Que q or (j=8) fin principio para i:=1 hasta 8 hacer a[i]:=verdad fpara; para i:=2 hasta 16 hacer b[i]:=verdad fpara; para i:=-7 hasta 7 hacer c[i]:=verdad fpara; ensaya(1,q); para i:=1 hasta 8 hacer escribir(x[i]) fpara fin La solución obtenida ejecutando este algoritmo es: 1 5 8 6 3 7 2 4...

### Cap. 205 — 1. Concepto de genericidad

# 3. Ejemplo: recorrido de un laberinto

En este apartado va a utilizarse una pila como dato auxiliar para resolver el problema de encontrar la salida de un
laberinto con un algoritmo de vuelta atrás.

Secciones:
  # 3. Ejemplo: recorrido de un laberinto

Conclusión: Línea('¡No hay salida!

### Cap. 206 — 2. TAD genéricos

Muchos juegos de estrategia se pueden representar en forma de árboles.

Secciones:
  # 4. Árboles de juego: estrategia minimax

Conclusión: Supondremos, por ejemplo, que empieza “yo”.

### Cap. 207 — 3. Implementación en C++

Si la raíz tuviera el valor 1, entonces “yo” tendría una estrategia que le permitiría ganar siempre.

Secciones:
  # EM PATE 	EM PATE

Conclusión: El algoritmo puede mejorarse fácilmente si se conocen los valores máximo y mínimo que
puede tomar la función de utilidad: el bucle se termina en cuanto se accede a una configuración cuya utilidad es máxima
(mínima) si el valor del parámetro juegoYo es verdad (falso).

### Cap. 208 — 1. Concepto de genericidad

# 1. Estrategias voraces

### Cap. 209 — 2. TAD genéricos

# 2. Aplicación al problema del recorrido del caballo de ajedrez

### Cap. 21 — Lección 9:: El TAD cola genérica........................................................................................................... 75

# Lección 18:: Colas con prioridad, montículos y el heapsort ................................................................ 167

### Cap. 210 — módulo m: onedas

# 3. Aplicación al problema del viajante

### Cap. 211 — módulo m: onederos

Una estrategia voraz, como la presentada en el ejemplo anterior, no necesariamente lleva a la solución del problema.

Secciones:
  # 1. Estrategias voraces

Conclusión: Sin embargo, la solución óptima consiste en devolver tres monedas de 5 unidades1.

### Cap. 212 — módulo m: onedero concreta sacosGen(moneda,precio);

Consideremos el conocido problema del recorrido del caballo de ajedrez.

Secciones:
  # 2. Aplicación al problema del recorrido del caballo de ajedrez

Conclusión: Que not esVacía(movimientos) and not q hacer
mov:=min(movimientos);
eliminarMin(movimientos);
k:=mov.

### Cap. 213 — 3. Implementación en C++

Obviamente, el coste de tal algoritmo crece exponencialmente con el número de puntos a visitar.

Secciones:
  # 3. Aplicación al problema del viajante

Conclusión: No obstante, es el cuarto mejor recorrido de entre
los sesenta (esencialmente distintos) posibles y es más costoso que el óptimo en sólo un 3,3%.

### Cap. 214 — 1. Contenedores

# 1. Especificación: sintaxis

### Cap. 215 — 2. Iteradores

# 2. Semántica de una especificación algebraica

### Cap. 216 — 3. La biblioteca Standard Template Library (STL)

# 3. Construcción de especificaciones

### Cap. 217 — 1. Contenedores

# 4. Verificación con especificaciones algebraicas

### Cap. 218 — 2. Iteradores

La especificación algebraica es una técnica formal para especificar o definir TAD.

Secciones:
  # 1. Especificación: sintaxis

Conclusión: En la práctica, varias operaciones con la misma
aridad y distinto resultado pueden combinarse en un solo procedimiento con varios parámetros de salida
(correspondientes a los resultados).

### Cap. 219 — 3. La biblioteca Standard Template Library (STL)

Veamos, a continuación, una posible signatura de los tipos “booleano” y “naturales con el cero”.

Secciones:
  # Tema I: con el procedimiento info.

Conclusión: Se entiende que, en cada ecuación con variables, éstas están (implícitamente)
cuantificadas universalmente (∀).

### Cap. 22 — 1. Concepto y especificación

# Tema IV:: Tipos de datos funcionales ............................................................................................................ 175

### Cap. 220 — TEMA II

Definición (Signatura).

Secciones:
  # 2. Semántica de una especificación algebraica

Conclusión: Las operaciones internas sobre A 2
ent son las habituales.

### Cap. 221 — 1. Concepto de pila y especificación

# ¬ (T) = F; 	¬ (F) = T; 	¬ (KK) = KK

### Cap. 222 — 2. Representación estática e implementación de operaciones

# T∧T = T; 	F∧F = F∧T = T∧F = F∧KK = KK∧F = F

-- 234 of 267 --

221

### Cap. 223 — 3. Representación de varias pilas en un vector

# T∧KK = KK∧T = KK; 	F∨F = F

### Cap. 224 — 1. Concepto de pila y especificación

Z∝ denota el conjunto de secuencias de longitud infinita (numerable) de enteros.

Secciones:
  # T∨T = T∨F = F∨T = T∨KK = KK∨T = T; 	F∨KK = KK∨F = KK

Conclusión: Teorema.

### Cap. 225 — 2. Representación estática e implementación de operaciones

# 1. 	El álgebra de términos cerrados sobre SIG, TSIG, es inicial en la clase ALG(SIG). El único homomorfismo de TSIG a

cualquier SIG-álgebra A es la evaluación de términos t A.

### Cap. 226 — 3. Representación de varias pilas en un vector

Dada una especificación ESPEC, un tipo concreto de datos es una ESPEC-álgebra cualquiera.

Secciones:
  # 2. 	El álgebra definida por ESPEC, TESPEC, es inicial en la clase ALG(ESPEC). El único homomorfismo f = {f g}g∈G,

Conclusión: El TAD definido por la especificación
bolsasDeNaturales es la clase de todos los modelos isomorfos a las “secuencias de naturales”.

### Cap. 227 — 1. Datos puntero y datos dinámicos

Las especificaciones de tipos complejos pueden ser textos voluminosos.

Secciones:
  # 3. Construcción de especificaciones

Conclusión: La elección que se haga de la clase Gen(g) así como la elección de los términos canónicos en el caso en que Gen(g)
sea no libre, influyen en la escritura de las ecuaciones de la especificación.

### Cap. 228 — 2. Estructuras de datos recursivas: representación mediante punteros y datos dinámicos

# 1. 	Si Gen(g) es un conjunto libre, sólo hay que escribir ecuaciones con las operaciones modificadoras y observadoras

(ver puntos 3 y 4). Si la signatura contiene sólo las operaciones generadoras, entonces no hay que escribir
ecuaciones y el álgebra TSIG de términos cerrados es el modelo de la especificación (ejemplo: la especificación
naturales_1 vista con anterioridad).

### Cap. 229 — 3. Punteros y datos dinámicos en C++

# 2. Si Gen(g) es un conjunto no libre, un primer conjunto de ecuaciones se utiliza para hacer congruentes entre sí ciertos términos de TGen(g) (en los que aparecen sólo operaciones generadoras). Es Secciones: # 2. Si Gen(g) es un conjunto no libre, un primer conjunto de ecuaciones se utiliza para hacer congruentes entre sí Conclusión: Por ejemplo, si en la especificación bolsasDeNaturales vista antes se considera Gen(bolsa) = {[],[_],_∪_} como conjunto de generadoras (no libres), las tres primeras ecuaciones...

### Cap. 23 — 2. Implementación estática

# Lección 19:: El TAD tabla y las tablas dispersas (hash) ...................................................................... 177

### Cap. 230 — 1. Datos puntero y datos dinámicos

# 3. 	Para cada operación modificadora se escriben tantas ecuaciones como sean necesarias para garantizar que todo

término de TCons(g) sea congruente a algún término de TGen(g). Una estrategia habitu

Secciones:
  # 3. 	Para cada operación modificadora se escriben tantas ecuaciones como sean necesarias para garantizar que todo

Conclusión: También las tres ecuaciones de la especificación naturales_3 vista antes
pertenecen a esta clase.

### Cap. 231 — 2. Estructuras de datos recursivas: representación mediante punteros y datos

El conjunto obvio de generadoras es Gen(conjcar) = {vacío,poner}. Secciones: # 4. Para cada operación observadora se escriben tantas operaciones como sean necesarias para garantizar que todo Conclusión: Finalmente, hay que notar que el significado del símbolo = en las ecuaciones cambia en el siguiente sentido: cuando el símbolo = actúe sobre dos términos en los que aparezca una operación parcial, hay que entender que expresa lo siguiente: “en caso de estar definidas las operaciones parciales, los dos términos son...

### Cap. 232 — 3. Punteros y datos dinámicos en C++

Consideremos un TAD especificado algebraicamente e implementado por medio de un módulo.

Secciones:
  # 4. Verificación con especificaciones algebraicas

Conclusión: AESPEC).

### Cap. 233 — 1. Representación dinámica de una pila e implementación de operaciones

# 1. Transformación de algoritmos recursivos finales

### Cap. 234 — 2. Codificación en C++ (fragmento)

# 2. Transformación de algoritmos recursivos lineales (no finales)

### Cap. 235 — 3. Ejemplo de aplicación del TAD pila: evaluación de expresiones postfijas

# 3. Transformación de algoritmos recursivos múltiples: un caso particular

### Cap. 236 — 4. Otro ejemplo de aplicación: traducción de expresiones infijas a postfijas

# 4. Transformación de algoritmos recursivos múltiples: caso general

### Cap. 237 — 1. Representación dinámica de una pila e implementación de operaciones

Un algoritmo recursivo se dice lineal si cada llamada recursiva sólo genera, como mucho, otra llamada.

Secciones:
  # 1. Transformación de algoritmos recursivos finales

Conclusión: Por tanto, el siguiente algoritmo iterativo ejecuta las mismas instrucciones que el recursivo r:
procedimiento rIter(ent x:tx)
variable v:tx
principio
v:=x;
mientrasQue not C0(v) hacer
selección
C1(v): A1(v);
v:=sig1(v);

-- 249 of 267 --

236
C2(v): A2(v);
v:=sig2(v);
.

### Cap. 238 — 2. Codificación en C++ (fragmento)

# 2. Transformación de algoritmos recursivos lineales (no finales)

El siguiente es un esquema general de algoritmo lineal:
procedimiento r(ent x:tx)
principio
si C(x) entonces
A(x)
sino
B1(x);
r(sig(

Secciones:
  # 2. Transformación de algoritmos recursivos lineales (no finales)

Conclusión: Así, una vez recorrida la
secuencia de principio a fin, basta con ir extrayendo datos de la pila para poder recorrer la secuencia en sentido inverso y
ejecutando B2(xi) para valores decrecientes de i.

### Cap. 239 — 3. Ejemplo de aplicación del TAD pila: evaluación de expresiones postfijas

Como puede verse, se ha denotado por xn1 el valor de sig1(xn) y por xn2 el valor de sig2(xn).

Secciones:
  # 3. Transformación de algoritmos recursivos múltiples: un caso particular

Conclusión: P.

### Cap. 24 — 3. Implementación dinámica

Anexos: Material adicional............................................................................................................................

Secciones:
  # Lección 20:: Tablas multidimensionales............................................................................................... 189

Conclusión: Algunos de los materiales e ideas aquí presentados han sido inspirados por ellos.

### Cap. 240 — 4. Otro ejemplo de aplicación: traducción de expresiones infijas a postfijas

Ahora vamos a considerar el caso general de un algoritmo con dos llamadas recursivas.

Secciones:
  # 4. Transformación de algoritmos recursivos múltiples: caso general

Conclusión: Escribir un algoritmo iterativo que resuelva el problema de las torres de Hanoi.

### Cap. 241 — 1. Concepto de cola y especificación

# 1. 	Sintaxis para una especificación de TAD en lenguaje natural

### Cap. 242 — 2. Representación dinámica e implementación de operaciones

# 2. 	Sintaxis del pseudocódigo

### Cap. 243 — 3. Representación estática circular

Rango es el nombre de un género.

Secciones:
  # 1. Sintaxis para una especificación de TAD en lenguaje natural

Conclusión: Se utiliza para indicar
operaciones con notación prefija sin paréntesis o con notación infija (ejemplo: ¬_ , _≤_.

### Cap. 244 — 4. Ejemplo de aplicación: simulación de una cola de espera

# 2. Sintaxis del pseudocódigo

### Cap. 245 — 1. Concepto de cola y especificación

# 1. 	Tipos de datos predefinidos

booleano {con los valores verdad y falso; escribimos los comentarios entre llaves}
carácter
natural 	{incluímos el 0 en los naturales}
entero
real
cadena 	{son secuencias de caracteres de longitud arbitraria (vacías o no)}

### Cap. 246 — 2. Representación dinámica e implementación de operaciones

# 2. 	Definición de constantes

constantes
letraA = ‘A’; maxNum = 100 	{usamos el punto y coma para separar}
hoy = “martes” 	{es una cadena no vacía}
pi = 3.1416

### Cap. 247 — 3. Representación estática circular

# 3. 	Definición de nuevos tipos de datos

tipos
mes = (ene,feb,mar,abr,may,jun,jul,ago,sep,oct,nov,dic) 	{tipo enumerado}
mesVerano = jul..sep 	{tipo subrango de otro tipo discreto}
día = 1..31
fecha

Secciones:
  # 3. 	Definición de nuevos tipos de datos

Conclusión: Num] de fecha
secFechas = fichero de fecha 	{tipo fichero binario de fechas}
entrada 	= 	fichero 	de 	texto 	{tipo 	fichero 	de 	texto, 	i.

### Cap. 248 — 4. Ejemplo de aplicación: simulación de una cola de espera

# 4. 	Declaración de variables

variables
contador: natural:= 0 	{podemos inicializar la variable al declararla}
éxito,error: booleano
nombre: cadena
cadenaVacía: cadena:= “” 	{la variable se inicializa con la cadena vacía, “”}
cumpleaños,aniversario: fecha
festivos,patronos: fiestas

### Cap. 249 — RESULTADOS

# 5. 	Instrucción de asignación

contador:= contador+1
error:= falso; éxito:= verdad;
éxito:= not error and (contador>3) or éxito
cumpleaños.elDía:= 13
nombre:= “Juan”
festivos[2].elMes:= sucesor(ene) 	{operaciones sucesor y predecesor para enumerados}
cumpleaños:= aniversario {asignación entre registros: todos los campos se asignan}
festivos:= patronos {asignación entre vectores: todas las componentes se asignan}

### Cap. 25 — 4. Recorridos

# 1. Concepto de abstracción

### Cap. 250 — RESULTADOS

# 6. Operaciones con datos cadena variables apellido, resto: cadena i: natural letra: carácter Comparaciones (por orden alfabético, considerando todos los caracteres según su orden en la tabla del c Secciones: # 6. Operaciones con datos cadena Conclusión: Operaciones con datos cadena variables apellido, resto: cadena i: natural letra: carácter Comparaciones (por orden alfabético, considerando todos los caracteres según su orden en la tabla del código ASCII y sus extensiones): “Costa” = apellido apellido ≠ “Po3$” apellido < resto apellido...

### Cap. 251 — RESULTADOS

# 7. 	Instrucciones de entrada/salida

escribir(“Introduzca su edad: ”) 	{escribe el mensaje en el dispositivo estándar
de salida (pantalla, por ejemplo)}
leerLínea(edad) {si edad es una variable ente

Secciones:
  # 7. 	Instrucciones de entrada/salida

### Cap. 252 — Lección 10

# 8. 	Instrucciones condicionales

si <condición> entonces
<secuencia de acciones>
fsi
si <condición> entonces
<secuencia de acciones>
sino
<secuencia de acciones>
fsi
si <condición> entonces
<secuenc

Secciones:
  # 8. 	Instrucciones condicionales

Conclusión: Instrucciones condicionales

si <condición> entonces
<secuencia de acciones>
fsi
si <condición> entonces
<secuencia de acciones>
sino
<secuencia de acciones>
fsi
si <condición> entonces
<secuencia de acciones>
sino_si <condición> entonces
<secuencia de acciones>
sino_si <condición> entonces
<secuencia de acciones>
.

### Cap. 253 — 1. Concepto de diccionario y su especificación

# 9. 	Instrucciones iterativas

para <variable_de_tipo_discreto>:=<valor_inicial> hasta <valor_final> hacer
<secuencia de acciones>
fpara
para <variable_de_tipo_disc>:=<valor_inicial> descendiendo hasta <valor_final> hacer
<secuencia de acciones>
fpara
mientrasQue <condición> hacer
<secuencia de acciones>
fmq
repetir
<secuencia de acciones>
hastaQue <condición>

### Cap. 254 — 2. Implementaciones estáticas sencillas

# 10. Procedimientos y funciones

procedimiento <nombre>(ent <parámetros_1>:<tipo_1>;
sal <parámetros_2>:<tipo_2>;
e/s <parámetros_3>:<tipo_3> ... )
{ent,sal,e/s significa parámetro de entrada, salida

Secciones:
  # 10. Procedimientos y funciones

Conclusión: Procedimientos y funciones

procedimiento <nombre>(ent <parámetros_1>:<tipo_1>;
sal <parámetros_2>:<tipo_2>;
e/s <parámetros_3>:<tipo_3> .

### Cap. 255 — 3. Implementación con listas enlazadas ordenadas

# 11. Módulos

módulo tablas
importa <lista de módulos que necesita usar>
exporta
{parte pública: constantes, nombres de tipos, encabezamientos de proced. y func...}
...
implementación
{parte privada: se incluyen las def. de los tipos cuyos nombres aparecen en la
parte pública, otros tipos privados, el código de procedimientos y funciones...}
...
fin

-- 262 of 267 --

249

### Cap. 256 — 1. Concepto de diccionario y su especificación

# 12. Módulos genéricos

módulo genérico listasGenéricas
parámetros
tipo elemento
con función “<”(e1,e2:elemento) devuelve booleano
exporta
tipo lista
procedimiento crear(sal l: lista)
procedimiento añadirÚltimo(e/s l: lista; ent e:elemento)
...
implementación
...
fin

### Cap. 257 — 2. Implementaciones estáticas sencillas

# 13. Uso de módulos genéricos

a. 	Para definir otro tipo también genérico:
módulo genérico pilasGenéricas
importa listasGenéricas
. . .
parámetro tipo elemento
exporta
tipo pila
. . .
implementación

Secciones:
  # 13. Uso de módulos genéricos

Conclusión: Genéricas;
modulo pila_naturales = pilasGenéricas(natural); {que ofrece el tipo: pila}
{admitimos también esta otra sintaxis aleternativa:}
modulo pila_naturales concreta pilasGenéricas(natural)
.

### Cap. 258 — 3. Implementación con listas enlazadas ordenadas

# 14. Datos puntero

tipo pila = ↑unDato {tipo puntero (o referencia) a unDato}
unDato = registro
dato:natural;
siguente:pila
freg
variables p,q: pila
Valor especial (constante) de cualquier tipo puntero: nil (ninguna dirección)
p:=nil
Instrucciones con punteros:
nuevoDato(p);
p↑.dato:=3;

-- 263 of 267 --

250
q:=p;
disponer(p);
si p=q entonces ...

### Cap. 259 — TEMA III

Weiss, M.A.: Data Structures and Algorithm Analysis in C++, 4th Edition, Pearson/Addison Wesley, 2014.

Secciones:
  # 15. Instrucciones de creación y uso de ficheros

Conclusión: Formalismo y Abstracción, Pearson Educación, 2005.

### Cap. 26 — 1. 	Recorrido en pre-orden:

# 2. Definición de TAD

### Cap. 27 — 2. 	Recorrido en post-orden:

# 3. Programación con TAD

### Cap. 28 — 3. 	Recorrido en in-orden u orden central:

# 4. Ventajas de la programación con TAD

### Cap. 29 — Lección 13

# 1. Concepto de abstracción

El concepto de abstracción en el proceso de comprensión de un problema lleva consigo el destacar los detalles
importantes e ignorar los irrelevantes.
Los siguientes son e

Secciones:
  # 1. Concepto de abstracción

Conclusión: En programación cabe distinguir entre las dos formas siguientes de abstracción:
• 	Abstracción de acciones (procedural o funcional): una acción (o valor) virtual parametrizada (ocultación de
información: datos locales y secuencia de instrucciones); separación del qué (especificación) y el cómo
(implementación).

### Cap. 30 — 1. Concepto y especificación

Ejemplos ya conocidos son los booleanos y naturales.

Secciones:
  # 2. Definición de TAD

Conclusión: Parcial: la operación no está definida si no existeSiguiente?

### Cap. 31 — 2. Implementación dinámica

Un módulo es una unidad del programa que puede ser desarrollada independientemente del resto.

Secciones:
  # 3. Programación con TAD

Conclusión: Véase el Anexo 6 para conocer la sintaxis
de esa notación o pseudocódigo.

### Cap. 32 — Lección 10:: El TAD diccionario. Implementación con listas enlazadas ordenadas .............................. 87

Como puede verse, se han escrito dos módulos diferente (“packages”, en Ada).

Secciones:
  # módulo c: onjuntosDeCaracteres

### Cap. 33 — 3. Implementación del TAD diccionario con ABB

En C++, una implementación posible (sin utilizar clases) es la siguiente (de nuevo, evitamos comentar el código).

Secciones:
  # módulo d: e declaración, contiene la definición del tipo de dato (nombre del tipo y encabezamientos de los algoritmos),

Conclusión: Pos = c.

### Cap. 34 — 1. Concepto y especificación

El diseño por refinamientos sucesivos se basa en la abstracción de acciones (procedural o funcional).

Secciones:
  # 4. Ventajas de la programación con TAD

Conclusión: Impide el mal uso y la generación de valores incorrectos.

### Cap. 35 — 2. Implementación dinámica

# 1. Características generales de una especificación

### Cap. 36 — 3. Implementación del TAD diccionario con ABB

# 2. Especificación algebraica

### Cap. 37 — Lección 14

# 3. Especificación no formal

### Cap. 38 — 1. Definición y teorema de AVL

La definición o especificación del TAD es el primero de los pasos en la programación con TAD.

Secciones:
  # 1. Características generales de una especificación

Conclusión: Esencialmente hay dos formas de especificar un TAD: algebraica (o formal) y no formal.

### Cap. 39 — 2. Representación de los árboles AVL

La especificación algebraica es una técnica formal para especificar TAD.

Secciones:
  # 2. Especificación algebraica

Conclusión: Se entiende que en cada ecuación con variables, éstas están (implícitamente)
cuantificadas universalmente (∀).

### Cap. 40 — 3. Inserción en AVL

TAD genéricos.

Secciones:
  # 2. Especificación no formal

Conclusión: Parcial: la operación no está definida si n=0 OR n>total(t)}
parcial infoFrec: tabla t, natural n -> natural
{Devuelve el natural que corresponde al número de apariciones del n-ésimo entero en la tabla t según el orden
en número de apariciones decreciente.

### Cap. 41 — 4. Borrado en AVL

# 1. Características de la implementación de un TAD

### Cap. 42 — 1. Definición y teorema AVL

# 2. Implementación modular

2.1. Pseudocódigo
2.2. C++

### Cap. 43 — Tema III:: Tipos de datos arborescentes ........................................................................................................... 97

Como ya se dijo, la encapsulación es el concepto fundamental subyacente bajo la programación con TAD. Secciones: # 1. Características de la implementación de un TAD Conclusión: La encapsulación consiste básicamente en garantizar: • la privacidad de la representación: el usuario del TAD no conoce los detalles de representación de los valores del TAD, o no necesita conocerlos, y • la protección del tipo: el usuario del TAD sólo puede utilizar las operaciones previstas y hechas públicas en la interfaz...

### Cap. 44 — 2. Representación de los árboles AVL

Un buen lenguaje de programación con TAD debe facilitar la encapsulación.

Secciones:
  # 2. Implementación modular

Conclusión: Elementos) {
return t.

### Cap. 45 — unidad m: ayor que la del derecho.

# 1. Concepto de genericidad

### Cap. 46 — 3. Inserción en AVL

# 2. TAD genéricos

### Cap. 47 — 1. 	Buscar la clave hasta encontrar la posición de inserción o modificación del valor asociado. Es un proceso idéntico

# 3. Implementación en C++

### Cap. 48 — 2. 	Insertar el nuevo nodo hoja, con factor de equilibrio equilibrado.

Con la particularización del código genérico, se obtiene código concreto, que puede ser ejecutado.

Secciones:
  # 1. Concepto de genericidad

Conclusión: La utilización de un ejemplar concreto del algoritmo genérico anterior se puede realizar de la siguiente forma:
with ordenacion_g;
procedure titi is
type color is (rojo,azul,gris);
type dia is (lu,ma,mi,ju,vi,sa,do);
type vect is array(dia range <>) of color;
x:vect(ma.

### Cap. 49 — 3. 	Desandar 	el 	camino 	de 	búsqueda, 	verificando 	el 	equilibrio 	de 	los 	nodos 	del 	camino, 	y

# 2. TAD genéricos En el diseño descendente por refinamientos sucesivos basado en la abstracción de acciones se utiliza la parametrización de procedimientos y funciones (parámetros formales que en ca Secciones: # 2. TAD genéricos Conclusión: Devuelve el número total de elementos que contiene c (0 si es vacío)} fespec Supongamos que en el desarrollo del software de una máquina expendedora de fruta fresca llegamos a la conclusión de que resultará útil especificar e implementar un TAD para gestionar la...

### Cap. 50 — 4. Borrado en AVL

# módulo m: onedas

exporta
tipo moneda=(c1,c10,c50,e1)
función precio(m:moneda) devuelve natural
implementación
función precio(m:moneda) devuelve natural
principio
selección
m=c1: devuelve 1;
m=c10: devuelve 10;
m=c50: devuelve 50;
m=e1: devuelve 100;
fselec

-- 46 of 267 --

39
fin
fin

### Cap. 51 — 1. 	Proceso de borrado como en un árbol binario de búsqueda:

A continuación, hagamos lo mismo con los TAD fruta y frutero (colección de frutas).

Secciones:
  # módulo m: onederos

Conclusión: Finalmente, para poder usar un TAD genérico, como el TAD saco, es necesario antes concretarlo o particularizarlo,
indicando con qué tipo se corresponde su parámetro formal elemento.

### Cap. 52 — 2. 	Se regresa por el camino de búsqueda calculando los nuevos factores de equilibrio:

# módulo m: onedero concreta sacosGen(moneda,precio);

módulo frutero concreta sacosGen(fruta,precio);
variables m:monedero.saco; f:frutero.saco
principio
...
vacío(m);
meter(m,e1);
vacío(f);
meter(f,pera)
...
fin

### Cap. 53 — Lección 15

C++ no implementa realmente la genericidad, es decir, no permite obtener código objeto (compilado) que sea genérico.

Secciones:
  # 3. Implementación en C++

Conclusión: Bien) {
cout << "ojo, ha habido un error frutal" << endl;
}
cout << "numero de peras: " << cuantos(frutero,pera) << endl;
cout << "valor total: " << valor(frutero) << endl;
todoBien = true;
Saco<Moneda> monedero;
vacio(monedero);
todoBien = meter(monedero,c1);
todoBien = meter(monedero,c10);
todoBien = meter(monedero,c1);
todoBien = meter(monedero,e1);
if (!

### Cap. 54 — Lección 11:: Introducción a los árboles .................................................................................................. 99

# 1. Contenedores

### Cap. 55 — 1. Conceptos y especificación

# 2. Iteradores

### Cap. 56 — 2. Recorridos

# 3. La biblioteca Standard Template Library (STL)

### Cap. 57 — 3. Implementación dinámica

Pasamos a describir muy brevemente algunas características de unos cuantos de estos contenedores importantes.

Secciones:
  # 1. Contenedores

Conclusión: De nuevo, la panoplia de operaciones es amplia y depende mucho del tipo
de grafo y del dominio de aplicación (algoritmos de cálculo de distancias, de caminos mínimos, de cálculo de árboles de
recubrimiento, etc).

### Cap. 58 — 4. Ideas sobre implementación estática

# 2. Iteradores Con las operaciones típicas que hemos mencionado para los contenedores (conjunto, multiconjunto, diccionario, etc.), • ¿cómo podemos (por ejemplo) mostrar todos los elementos del con Secciones: # 2. Iteradores Conclusión: Un uso típico para el que el iterador está diseñado es el siguiente (recorrido de los datos del contenedor): iniciarIterador(c); mientrasQue existeSiguiente(c) hacer siguiente(c,e,error); <utilizar el valor de e para algo> fmq Nunca se debe modificar el contenedor de datos (con las operaciones de añadir, borrar o...

### Cap. 59 — 1. Conceptos y especificación

Es un buen ejemplo de definición e implementación de TAD reutilizables.

Secciones:
  # 3. La biblioteca Standard Template Library (STL)

Conclusión: Por el
contrario, pretendemos guiar en el aprendizaje del diseño o definición de TAD para que sean reutilizables, eficientes y
robustos, y en el aprendizaje de su implementación, garantizando dichas propiedades.

### Cap. 60 — 2. Recorridos

# TEMA II

Tipos de datos lineales

-- 61 of 267 --

54

-- 62 of 267 --

55
Lección 6
El TAD pila genérica. Definición e implementación estática
Indice

### Cap. 61 — 3. Implementación dinámica

# 1. Concepto de pila y especificación

### Cap. 62 — 4. Ideas sobre implementación estática

# 2. Representación estática e implementación de operaciones

### Cap. 63 — parte d: e las componentes del vector. Además, sería preciso añadir en

# 3. Representación de varias pilas en un vector

### Cap. 64 — Lección 16

En el tipo pila hay un valor especial que denominamos pila vacía.

Secciones:
  # 1. Concepto de pila y especificación

Conclusión: Parcial: la operación no está definida si no existeSiguiente?

### Cap. 65 — Lección 12:: Árboles binarios ............................................................................................................... 103

Donde elemento es un tipo previamente definido. Secciones: # 2. Representación estática e implementación de operaciones Conclusión: En ese caso, el inicio del módulo genérico de implementación de pilas sería el siguiente, exigiendo que el parámetro formal de tipo “elemento” disponga de esas dos operaciones: módulo genérico pilas parámetros tipo elemento con procedimiento duplicar(ent eEnt:elemento; sal eSal:elemento) {procedimiento que duplica la representación de eEnt en eSal} con función iguales(e1,e2:elemento) devuelve booleano {función que devuelve verdad si y sólo si e1...

### Cap. 66 — 1. Definición

Si el número de pilas a representar en un vector de componentes 1..max es dos, la solución es fácil.

Secciones:
  # 3. Representación de varias pilas en un vector

Conclusión: Por ejemplo, es posible hacer que el espacio libre sobre cada pila sea proporcional al tamaño
actual de la misma (en el supuesto de que las pilas más grandes tienen mayor probabilidad de crecer antes, se retrasa al
máximo el instante de la siguiente reorganización).

### Cap. 67 — 2. Árboles n–arios de búsqueda equilibrados

# 1. Datos puntero y datos dinámicos

### Cap. 68 — 3. Ejemplo de implementación (árboles 2–3)

# 2. Estructuras de datos recursivas: representación mediante punteros y datos dinámicos

### Cap. 69 — 1. Definición

# 3. Punteros y datos dinámicos en C++

### Cap. 70 — 2. Árboles n–arios de búsqueda equilibrados

Un puntero es un dato cuyo valor es la dirección en memoria de otro determinado dato.

Secciones:
  # 1. Datos puntero y datos dinámicos

Conclusión: Finalmente, dos datos de tipo puntero (a datos del mismo tipo) pueden ser comparados con los operadores relacionales
de igualdad (=) o desigualdad (≠).

### Cap. 71 — 3. Ejemplo de implementación (árboles 2–3)

Ejemplo 1: Una cadena de caracteres no vacía se compone de un carácter seguido del resto, otra cadena de caracteres.

Secciones:
  # 2. Estructuras de datos recursivas: representación mediante punteros y datos

Conclusión: Así, los datos cadena pueden representarse de la siguiente forma:
tipos cadena = ↑cad;
cad = registro
primero:carácter;
resto:cadena
freg
'l' 	'a' 	' ' 	'c' 	'a' 	'd' 	'e' 	'n' 	'a'nil
c
Representación de la cadena: 'la cadena'.

### Cap. 72 — Lección 17

# 3. Punteros y datos dinámicos en C++

A continuación, se presenta, a título de ejemplo, la equivalencia entre nuestra notación algorítmica y el lenguaje C++:
tipo Persona = registro
nombre:cadena;
e

Secciones:
  # 3. Punteros y datos dinámicos en C++

Conclusión: Persona {
string nombre;
int edad;
};
Persona* p;
Persona* q;
p = new Persona;
p->nombre = “Pepe”; (*)
p->edad = 23;
delete p;
q = nullptr;
(*) Es lo mismo que:
(*p).

### Cap. 73 — 1. Definición y características principales

# 1. Representación dinámica de una pila e implementación de operaciones

### Cap. 74 — 2. Implementaciones

# 2. Codificación en C++ (fragmento)

### Cap. 75 — 3. Detalles de la implementación nodo–lista

# 3. Ejemplo de aplicación del TAD pila: evaluación de expresiones postfijas

### Cap. 76 — Lección 13:: Árboles binarios de búsqueda .......................................................................................... 115

# 4. Otro ejemplo de aplicación: traducción de expresiones infijas a postfijas

### Cap. 77 — 1. Definición y características principales

# 1. Representación dinámica de una pila e implementación de operaciones

El tipo pila se representa mediante un puntero que apunta a un dato creado dinámicamente donde está el elemento
correspondient

Secciones:
  # 1. Representación dinámica de una pila e implementación de operaciones

Conclusión: Hay un coste adicional en memoria con
respecto a la representación estática: el espacio ocupado por los punteros que sirven para encadenar los elementos.

### Cap. 78 — 2. Implementaciones

# 2. Codificación en C++ (fragmento)

Incluimos la parte inicial de una posible codificación en C++ del TAD pila genérica con representación dinámica
(enlazada con punteros). No utilizaremos clases (o

Secciones:
  # 2. Codificación en C++ (fragmento)

Conclusión: Cima=aux;
p.

### Cap. 79 — 3. Detalles de la implementación nodo–lista

Una expresión en notación postfija puede ser evaluada haciendo un recorrido de izquierda a derecha.

Secciones:
  # 3. Ejemplo de aplicación del TAD pila: evaluación de expresiones postfijas

Conclusión: Además, existe la función
siguienteSímbolo que devuelve el siguiente símbolo de una expresión.

### Cap. 80 — Lección 18

Veamos ahora un ejemplo con paréntesis: la expresión a*(b+c)/d.

Secciones:
  # 4. Otro ejemplo de aplicación: traducción de expresiones infijas a postfijas

Conclusión: Existen los algoritmos iniciaExpresión y añadeSímbolo que crean la expresión vacía y añaden un nuevo
símbolo a la derecha de una expresión, respectivamente.

### Cap. 81 — 1. Concepto y especificación de cola con prioridad genérica

# 1. Concepto de cola y especificación

### Cap. 82 — 2. Implementación basada en un montículo o heap

# 2. Representación dinámica e implementación de operaciones

### Cap. 83 — 3. Aplicación a la ordenación de elementos de un vector: el heapsort

# 3. Representación estática circular

### Cap. 84 — 1. Concepto y especificación de cola con prioridad genérica

# 4. Ejemplo de aplicación: simulación de una cola de espera

### Cap. 85 — 2. Implementación basada en un montículo o heap

# 1. Concepto de cola y especificación

Una cola es, al igual que una pila, una secuencia de elementos de un cierto tipo, dispuestos en una dimensión (tipo
lineal de datos). En el tipo cola hay un val

Secciones:
  # 1. Concepto de cola y especificación

Conclusión: Parcial: la operación no está definida si no existeSiguiente?

### Cap. 86 — módulo c: olaConPrioridadesDeMáximos

# 2. Representación dinámica e implementación de operaciones

La representación dinámica de un dato de tipo cola puede realizarse, de forma análoga a la del tipo pila, encadenando
o enlazando mediante

Secciones:
  # 2. Representación dinámica e implementación de operaciones

Conclusión: Si no quedan elementos pendientes
de visitar devuelve error=verdad, e queda indefinido y c queda como estaba}
principio
si existeSiguiente(c) entonces
error:=falso;

-- 87 of 267 --

80
e:=c.

### Cap. 87 — Lección 14:: Árboles AVL .................................................................................................................... 127

Nótese que el coste temporal de todas las operaciones es O(1), excepto para las de duplicar y comparación de igualdad.

Secciones:
  # 3. Representación estática circular

Conclusión: EnInicio:=falso
fsi
sino
error:=verdad
fsi
fin
fin
Nótese que el coste temporal de todas las operaciones es O(1), excepto para las de duplicar y comparación de igualdad.

### Cap. 88 — 3. Aplicación a la ordenación de elementos de un vector: el heapsort

Vamos a estudiar el caso más sencillo.

Secciones:
  # 4. Ejemplo de aplicación: simulación de una cola de espera

Conclusión: Media:=sumaDeEsperas/númeroClientes
fsi;
escribir('RESULTADOS');

-- 92 of 267 --

85
escribir('Número de clientes servidos: ',númeroClientes);
escribir('Tiempo medio de espera (en minutos): ', esperaMedia)
fin
A continuación, se muestra el resultado obtenido al ejecutar tres veces el algoritmo anterior para datos idénticos:
DATOS
Probabilidad de que llegue un cliente durante un minuto: 0.

### Cap. 89 — TEMA IV

# RESULTADOS

Número de clientes servidos: 16
Tiempo medio de espera (en minutos): 0.25
DATOS
Probabilidad de que llegue un cliente durante un minuto: 0.10
Tiempo requerido por cada servicio (en minutos): 5
Longitud de la simulación (tiempo total, en minutos): 200

### Cap. 90 — Lección 19

# RESULTADOS

Número de clientes servidos: 29
Tiempo medio de espera (en minutos): 3.93
DATOS
Probabilidad de que llegue un cliente durante un minuto: 0.10
Tiempo requerido por cada servicio (en minutos): 5
Longitud de la simulación (tiempo total, en minutos): 200

### Cap. 91 — 1. Recordatorio del concepto de tabla o diccionario y su especificación

En los tres casos, un cliente llega, en media, cada diez minutos.

Secciones:
  # RESULTADOS

Conclusión: El
estudio de modelos de colas como el propuesto aquí y de otros más realistas y complejos, y su análisis, es el objeto de la
denominada Teoría de Colas.

### Cap. 92 — 2. Repaso de implementaciones ya vistas

# Lección 10

El TAD diccionario. Implementación con listas enlazadas ordenadas
Indice

### Cap. 93 — 3. Tablas dispersas (o hash)

# 1. Concepto de diccionario y su especificación

### Cap. 94 — 1. Recordatorio del concepto de tabla o diccionario y su especificación

# 2. Implementaciones estáticas sencillas

### Cap. 95 — 2. Repaso de implementaciones ya vistas

# 3. Implementación con listas enlazadas ordenadas

### Cap. 96 — 3. Tablas dispersas (o hash)

Un diccionario o tabla es un conjunto o colección de pares (c,v).

Secciones:
  # 1. Concepto de diccionario y su especificación

Conclusión: El booleano es verdad si y sólo si la clave
está y en ese caso el valor es el asociado a la clave, y en caso contrario el booleano es falso y el valor queda indefinido.

### Cap. 97 — 1. Elegir la función

Esta representación no requiere la existencia de una relación de orden total definida sobre el dominio de las claves.

Secciones:
  # 2. Implementaciones estáticas sencillas

Conclusión: Se plantea, como ejercicio sencillo de programación de primer curso, el realizar ambas implementaciones del TAD
diccionario.

### Cap. 98 — Lección 15:: Árboles n–arios ................................................................................................................ 139

# 3. Implementación con listas enlazadas ordenadas Para evitar la limitación en tiempo de compilación del cardinal máximo (max) del diccionario que imponen las implementaciones estáticas, basadas en Secciones: # 3. Implementación con listas enlazadas ordenadas Conclusión: En cuanto al coste asintótico en tiempo para el caso peor, puede deducirse con facilidad que las operaciones “crear”, “cardinal”, “esVacío”, “iniciarIterador”, “existeSiguiente” y “siguiente” tienen un coste en O(1), es decir, constante o independiente del cardinal del diccionario, mientras que todas las...

### Cap. 99 — 2. Seleccionar un método para resolver las colisiones.

# TEMA III

Tipos de datos arborescentes

-- 105 of 267 --

98

-- 106 of 267 --

99

