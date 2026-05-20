# 2. Especificación

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 115)

## Contenido
# 2. Especificación

Se ha definido un grafo como un par de conjuntos: de vértices y aristas (el segundo de ellos, de pares de elementos del
primero). Por tanto, la signatura del TAD grafo debe contener como mínimo operaciones para añadir vértices y aristas
a un grafo.
El resto de operaciones de la signatura depende de la aplicación que se vaya a dar al TAD. En la siguiente
especificación del TAD “grafo dirigido” se incluyen operaciones de pertenencia y una operación que calcula los vértices
adyacentes a uno dado.
espec grafosDirigidos
usa booleanos, conjuntosDeVértices {es un TAD conjunto de elementos de tipo vértice}
parámetro formal
género vértice
operación
_ = _: vértice v1, vértice v2 -> booleano {una relación de igualdad entre vértices}
fpf
género grafo {sus valores son grafos genéricos no dirigidos cuyos vértices son de género vértice (parámetro)}
operaciones
crearVacío: -> grafo
{Devuelve un grafo vacío, sin vértices (ni aristas)}
añadirVértice: grafo g, vértice v -> grafo
{Devuelve el grafo resultante de añadir el vértice v a g. Si en g ya estaba el vértice v, devuelve g}
parcial añadirArista: grafo g, vértice v1, vértice v2 -> grafo
{Si v1 y v2 son vértices de g, devuelve el grafo resultante de añadir la arista (v1,v2) al grafo g.
Parcial: no está definida si v1 o v2 no son vértices de g}
perteneceVértice: vértice v, grafo g -> booleano
{Devuelve verdad si y sólo si v es un vértice de g}
perteneceArista: vértice v1, vértice v2, grafo g -> booleano
{Devuelve verdad si y sólo si (v1,v2) es una arista de g}
adyacentes: grafo g, vértice v -> conjuntoDeVértices
{Devuelve el conjunto de vértices adyacentes a v en g (es decir, los u tales que existe (v,u) en g)}
fespec
Para escribir la especificación del TAD grafo no dirigido, basta con modificar la semántica de la operación
añadirArista, diciendo que la operación también añade el par (v2,v1).

-- 208 of 267 --

195
