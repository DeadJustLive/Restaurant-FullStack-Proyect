# T∨T = T∨F = F∨T = T∨KK = KK∨T = T; 	F∨KK = KK∨F = KK

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 147)

## Contenido
# T∨T = T∨F = F∨T = T∨KK = KK∨T = T; 	F∨KK = KK∨F = KK

pilaVacíaA2 = ¡y_a_mi_qué!
apilarA2(¡y_a_mi_qué!,i) = ¡y_a_mi_qué!
desapilarA2(¡y_a_mi_qué!) = ¡y_a_mi_qué!
cimaA2(¡y_a_mi_qué!) = 1111
vacía?A2(¡y_a_mi_qué!) = KK
Una interpretación más:
A 3
bool = {true,false}; 	A 3
ent = Z; 	A 3
pila = Zω = Z* ∪ Z∝
Z∝ denota el conjunto de secuencias de longitud infinita (numerable) de enteros. Las operaciones internas sobre
A 3
bool 	y A 3
ent 	son las habituales. El resto son las siguientes (‘i’ denota un entero cualquiera, ‘ε’ denota la secuencia
vacía y ‘s’ denota un elemento cualquiera de Zω):
pilaVacíaA3 = ε; 	apilarA3(s,i) = is
desapilarA3(ε) = ε; 	desapilarA3(is) = s
cimaA3(ε) = 0; 	cimaA3(is) = i
vacía?A3(ε) = true; 	vacía?A3(is) = false
Se define a continuación el álgebra de términos cerrados o sin variables sobre una signatura.
Definición (Álgebra de términos cerrados). Dada una signatura SIG = (G,OP), el álgebra de términos cerrados sobre
SIG, denotada TSIG, es una SIG-álgebra ({TSIGg} g∈G ,OPTSIG), donde:
• 	TSIGg = {σ | σ ∈ OP ∧ σ: → g} ∪ {σ (t1,…,t n) | σ ∈ OP ∧ σ: g1…gn → g ∧ t1 ∈ TSIGg1, …, t n ∈ TSIGgn}.
Es decir, TSIGg es el conjunto de términos de género g de SIG.
• 	Las aplicaciones de OPTSIG se definen trivialmente:
∀ σ: → g, la interpretación σTSIG de σ en TSIG es el propio término σ ∈ TSIGg.
∀ σ: g1…gn → g, ∀ t1 ∈ TSIGg1, …, ∀ tn ∈ TSIGgn, la interpretación σTSIG de σ en TSIG es la siguiente:
σTSIG(t1,…,t n) def
= 	σ(t1 ,…,t n). 	♦
Es decir, cada término bien formado de la signatura es un valor distinto del tipo apropiado en el álgebra de términos
cerrados. La imagen mediante una aplicación (del álgebra de términos cerrados) de un conjunto de términos de tipos
apropiados es el término bien formado que puede construirse prefijando a dichos términos, separados por comas y entre
paréntesis, con el símbolo de operación correspondiente (suponemos que cada símbolo de operación tiene una versión
prefija).
Si una especificación algebraica no posee ecuaciones, el objeto formal que define es la SIG-álgebra de términos
cerrados TSIG. Como hemos visto, hay veces que interesa que distintos términos bien formados tengan un mismo significado.
Para ello es necesario introducir ecuaciones. Definimos antes los conceptos de “conjunto de variables” y de “término
abierto” o con variables.
Definición (Conjunto de variables). Dada una signatura SIG = (G,OP), un conjunto de variables con respecto a SIG
es una familia de conjuntos X = {X g}g∈G tal que Xg ∩ Xg' = ∅ si g ≠ g'. Además, los identificadores de X no figuran ni en G
ni en OP. 	♦
Definición (Términos abiertos). Dada una signatura SIG = (G,OP) y un conjunto de variables con respecto a SIG, X
= {X g}g∈G, el conjunto de términos abiertos (o términos con variables) de género g ∈ G es: TSIG(X)g = Xg ∪ {σ | σ ∈ OP ∧
σ: → g} ∪ {σ(t1,…,t n) | σ ∈ OP ∧ σ: g1…gn → g ∧ t1 ∈ TSIG(X)g1,…, tn ∈ TSIG(X)gn}. 	♦

-- 235 of 267 --

222
Definición (Álgebra de términos abiertos). Dada una signatura SIG = (G,OP) y un conjunto X de variables con
respecto a SIG, el álgebra de términos abiertos sobre SIG, denotada TSIG(X), se define de modo similar a TSIG, con la única
salvedad de que, además de los símbolos de constante, toda x ∈ Xg es un término de TSIG(X). 	♦
Definición (Ecuación). Dada una signatura SIG = (G,OP) y un conjunto X de variables con respecto a SIG, una
ecuación de género g con respecto a SIG es una terna (X,t1,t2)g, con t1,t2 ∈ TSIG(X)g, y se denota t1 = t2. 	♦
Definición (Especificación algebraica). Una especificación algebraica es un par ESPEC = (SIG,E), donde SIG es una
signatura y E un conjunto de ecuaciones con respecto a SIG. 	♦
Ejemplo:
espec bolsasDeNaturales
usa naturales_31
género bolsa 	{Bolsas de naturales}
operaciones
[]: -> bolsa 	{Bolsa vacía}
[_]: natural -> bolsa 	{Bolsa unitaria}
_∪_: bolsa bolsa -> bolsa 	{Unir bolsas}
_⊕_: natural bolsa -> bolsa 	{Añadir natural a bolsa}
ecuaciones x:natural; b,b1,b2,b3:bolsa
b∪[] = b
[]∪b = b
(b1∪b2)∪b3 = b1∪(b2∪b3)
x⊕b = [x]∪b
fespec
De la misma forma que una signatura SIG genera el álgebra TSIG (álgebra de términos cerrados sobre SIG), vamos a ver
que una especificación también genera un álgebra: el álgebra cociente de TSIG al introducir una relación de equivalencia
definida por el conjunto de ecuaciones en el conjunto de los términos. Previamente, definimos la noción de sustitución y la
relación de equivalencia en los términos de TSIG.
Definición (Sustitución y extensión). Dada una signatura SIG = (G,OP) y un conjunto X de variables con respecto a
SIG, una sustitución h = {hg}g∈G es una familia de aplicaciones h g: Xg → TSIGg de variables a términos cerrados. Llamaremos
extensión de una sustitución h a la familia de aplicaciones, también denotada h = {hg} g∈G, h g: TSIG(X)g → TSIGg definida
como sigue:
• 	si t = x ∈ Xg, hg(t) def
= 	h g(x)
• 	si t = σ ∈ OP ∧ σ: → g, hg(t) def
= 	σ
• 	si t = σ(t1,…,t n) ∈ OP ∧ σ: g1,…,gn → g, h g(t) def
= 	σ(h(t1),…,h(t n)). 	♦
Definición (Congruencia). Dada una especificación
