# 2. 	El álgebra definida por ESPEC, TESPEC, es inicial en la clase ALG(ESPEC). El único homomorfismo f = {f g}g∈G,

con f g: TESPECg → Ag, de T ESPEC a cualquier ESPEC-álgebra A se define, para cada término t de TESPEC, como:
f g([t]) def
= 	t A. 	♦
Dada una especificación ESPEC, un tipo concreto de datos es una ESPEC-álgebra cualquiera. Se denomina así porque
tiene un conjunto de elementos determinado (soporte) y unas operaciones definidas por medio de aplicaciones explícitas
(interpretaciones) entre los conjuntos soporte del álgebra.
Dada una especificación ESPEC, un tipo abstracto de datos (TAD) es la clase de isomorfía de un álgebra inicial en
ALG(ESPEC). Es decir, es la clase de todas las ESPEC-álgebras o modelos de la especificación que son isomorfas al álgebra
T ESPEC definida por ESPEC.
Consideremos de nuevo la especificación bolsasDeNaturales. El tipo bolsa de naturales tiene una operación ∪ que
es asociativa y tiene como elemento neutro a la bolsa vacía []. Aparentemente, las bolsas se comportan como “conjuntos
de naturales”. Sin embargo, es fácil ver que también los “multiconjuntos de naturales” (interpretando ∪ como la unión de

-- 238 of 267 --

225
multiconjuntos), las “secuencias o listas de naturales” (interpretando ∪ como la concatenación de secuencias) y las
“secuencias de enteros” (siendo igualmente ∪ la concatenación de secuencias) satisfacen las ecuaciones.
El modelo más adecuado de la especificación bolsasDeNaturales es el de las “secuencias de naturales”. Los
multiconjuntos y los conjuntos tienen más igualdades que las que se deducen de la especificación, ya que la operación ∪,
además de asociativa, es conmutativa (la igualdad [3] ∪ [4] = [4] ∪ [3] es cierta en los multiconjuntos y en los conjuntos
pero no en las secuencias). Los conjuntos satisfacen además la idempotencia, es decir, la ecuación b ∪ b = b.
Se puede definir un homomorfismo que a cada secuencia de naturales la haga corresponder el multiconjunto resultante
de olvidar el orden de los elementos de la secuencia. Igualmente, existe un homomorfismo de multiconjuntos a conjuntos
consistente en conservar solamente una copia de cada elemento del multiconjunto de partida. También existe un
homomorfismo que a cada secuencia de naturales le hace corresponder una secuencia de enteros: el homomorfismo
identidad (aunque hay secuencias de enteros que no tienen anti-imagen por ese homomorfismo).
Como vemos, el modelo de las “secuencias de naturales” satisface estrictamente las igualdades establecidas en la
especificación y ninguna otra, es decir, sólo satisface las igualdades que son válidas en todos los demás modelos de la
especificación (por ejemplo, los “conjuntos de naturales” o los “multiconjuntos de naturales”). En este sentido, el modelo
de las “secuencias de naturales” se dice que es típico en la categoría ALG(bolsasDeNaturales). También se dice que en
ese modelo no existe confusión de valores (como en el caso de los multiconjuntos o conjuntos, en el que dos secuencias
diferentes de naturales pueden tener por imagen o “confundirse” en un mismo multiconjunto o conjunto).
Por otra parte, todo valor del modelo “secuencias de naturales” puede ser generado mediante la evaluación de algún
término del álgebra de términos cerrados definida por la especificación. No ocurre así con el modelo de las “secuencias de
enteros”. Este último tiene valores que no pueden obtenerse a partir de la evaluación de ningún término del álgebra de
términos cerrados (todas las secuencias que incluyan algún número negativo). Así, el modelo de las “secuencias de enteros”
contiene basura.
El modelo de las “secuencias de naturales” es precisamente un modelo inicial de ALG(bolsasDeNaturales) porque
es típico y generable (en otras palabras, sin confusión y sin basura). El TAD definido por la especificación
bolsasDeNaturales es la clase de todos los modelos isomorfos a las “secuencias de naturales”.