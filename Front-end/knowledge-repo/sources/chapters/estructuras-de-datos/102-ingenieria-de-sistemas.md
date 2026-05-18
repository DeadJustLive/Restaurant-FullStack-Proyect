# INGENIERIA DE SISTEMAS

Longitud de una trayectoria: Se define con la cantidad de lados que contiene. En el ejemplo anterior
para la trayectoria 1234 su longitud es: 3. En el caso de 134 y 124 la longitud en cada caso es: 2
Trayectoria Simple: Se da cuando todos los vértices excepto posiblemente el primero y el ultimo son
distintos. Por ejemplo: 1234 es trayectoria simple en el Grafo 1. Pero si se diera la trayectoria 12324 en
este grafo no sería una trayectoria simple. Otro caso analizable seria la trayectoria 12341 que
efectivamente seria simple (el primero y el último de los vértices son iguales).
Ciclo: Se define como una trayectoria simple en el cual el primero y el último vértice son iguales. En el
Grafo 2 la trayectoria ABCA forma un ciclo.
Grafo conectado: se denomina así si desde cualquier vértice i del grafo se puede ir a cualquier vértice j
del grafo (para grafos no dirigidos). Para grafos dirigidos se usa el concepto grafo fuertemente conectado
con la misma definición que el anterior.
El máximo número de lados en un grafo no dirigido se calcula como: n*(n-1)/2 con n igual al número
de vértices del grafo.
Un grafo dirigido completo tiene un número de lados igual a: n*(n-1) con n igual al número de vértices
3.2.1.3 REPRESENTACIÓN DE GRAFOS:
Hay 4 formas de representar los grafos entre las representaciones estáticas y dinámicas que se describen a
continuación:
Matriz de adyacencia: Es una matriz cuadrada de orden n*n, siendo n el número de vértices del grafo.
La relación que se da entre los vértices del grafo se representa en la matriz teniendo en cuenta lo
siguiente:
Si existe lado (Vi, Vj) el cruce entre i y j se llena con 1 (hay adyacencia)
En otro caso es 0 (se deja el cruce en blanco).
A continuación se representa el Grafo 1 y el Grafo 2 como matriz de adyacencia:

-- 31 of 64 --

32