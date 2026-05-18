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
Definición (Congruencia). Dada una especificación ESPEC = (SIG,E), la congruencia engendrada en TSIG por las
ecuaciones E es la relación ≡E que satisface:
i) 	∀ g ∈ G, ∀ t ∈ TSIGg, t ≡E t (reflexiva)
ii) ∀ g ∈ G, ∀ t1,t2 ∈ TSIGg, t1 ≡E t2 ⇒ t2 ≡E t1 (simétrica)
iii) ∀ g ∈ G, ∀ t1,t2 ,t3 ∈ TSIGg, t1 ≡E t2 ∧ t2 ≡E t3 ⇒ t1 ≡E t3 (transitiva)
iv) ∀σ: g1…g n → g, ∀ t1,t1' ∈ TSIGg1,…, ∀ t n,t n' ∈ TSIGgn, t1 ≡E t1' ∧ … ∧ t n ≡E t n' ⇒ σ(t1,…,t n) ≡E σ(t1 ',…,t n')
(congruente con OPTSIG)
v) ∀ (X,t1,t2)g ∈ E, ∀ hg: Xg → TSIGg, hg(t1) ≡E hg(t2) (engendrada por E)
vi) si ≡'E es otra relación que verifica (i,ii,iii,iv,v) entonces:
∀ g ∈ G, ∀ t1,t2 ∈ TSIGg, t1 ≡E t2 ⇒ t1 ≡'E t2 (mínima).
1 Especificación del TAD natural introducida previamente.

-- 236 of 267 --

223
Es decir, es la menor relación de equivalencia en TSIG, congruente (o compatible) con las operaciones de TSIG,
engendrada por las ecuaciones E (dos términos son equivalentes si y sólo si dicha equivalencia se deduce de las ecuaciones
E). 	♦
Definición (Álgebra definida por una especificación). Dada una especificación ESPEC = (SIG,E), el álgebra definida
por ESPEC, denotada TESPEC, es la siguiente:
• 	soportes: TESPECg
def
= 	TSIGg / ≡E. Dado t ∈ TSIG, denotaremos por [t] a la clase de equivalencia del término t.
• 	operaciones: ∀ g ∈ G,
∀σ: → g, σTESPEC def
= 	[σ]
∀σ: g1…g n → g, σTESPEC([t1],…,[t n]) def
= 	[σ(t1,…,t n)]. 	♦
De la definición del álgebra TESPEC se deducen las siguientes importantes propiedades:
• 	Sólo pertenecen a {TESPECg}g ∈ G valores que puedan ser generados por algún término t.
• 	TESPEC satisface las ecuaciones E de la especificación: dos términos conducen al mismo valor (es decir, están en la
misma clase o tienen el mismo soporte) si ello se deduce de E.
• 	Las únicas igualdades que pueden darse en TESPEC son las que se deducen de E (es decir, ≡E es la menor relación de
equivalencia que engloba las igualdades deducidas de E).
Al igual que ocurre con una signatura SIG, que el álgebra de términos TSIG no es la única interpretación posible pues
existen otras SIG-álgebras, dada una especificación ESPEC existen muchas SIG-álgebras que satisfacen las ecuaciones de
la especificación además de TESPEC. Las llamaremos ESPEC-álgebras o modelos de ESPEC.
Definición (Valuación). Dada una SIG-álgebra A = ({Ag}g∈G,OP A) y un conjunto de variables X = {Xg}g∈G con respecto
a SIG, una valuación V = {Vg}g∈G es un conjunto de aplicaciones Vg: Xg → Ag. 	♦
Nótese que el concepto de sustitución (h g: Xg → TSIGg), definido previamente, no es más que una valuación para el caso
particular del álgebra de términos cerrados TSIG. Al igual que en el caso particular de una sustitución, una valuación puede
extenderse a los términos abiertos:
Definición (Evaluación). Dada una valuación V de un conjunto de variables X en una SIG-álgebra A, y un término
t ∈ TSIG(X)g, la evaluación de t en A según V, denotada t A,V, se define como:
• 	si t = x ∈ Xg, t A,V def
= 	Vg(x)
• 	si t = σ ∈ OP ∧ σ: → g, t A,V def
= 	σA
• 	si t = σ (t1,…,t n) ∈ OP ∧ σ: g1 ,…,gn → g, t A,V def
= 	σA(t1A,V ,…,t nA,V). 	♦
En particular, si t ∈ TSIGg, es decir t es un término sin variables, la evaluación t A,V es la misma para cualquier valuación
V, y se denota por t A.
Definición (ESPEC-álgebra). Dada una especificación ESPEC = (SIG,E), una SIG-álgebra A = ({Ag}g∈G,OPA)
satisface ESPEC o es un modelo de ESPEC o es una ESPEC-álgebra, y se denota A ⊨ E, si satisface todas las ecuaciones
E, es decir: ∀ (X,t1,t2)g ∈ E, ∀ Vg: Xg → Ag, t1A,V = t2A,V. 	♦
Hay que notar que, dada una especificación ESPEC = (SIG,E), el álgebra TESPEC definida por ESPEC es una ESPEC-
álgebra.
Por ejemplo, la especificación naturales_3 vista antes admite, entre otras, las siguientes ESPEC-álgebras:
1) los números naturales con la operación de suma;
2) los números enteros, interpretando 0 como el cero de los enteros, + como la suma de enteros y suc(x) como x+1;
3) los números naturales módulo 3, es decir, A = {0,1,2}, interpretando 0 como 0 de A, suc como el sucesor módulo
3 (suc(0)=1, suc(1)=2, suc(2)=0) y + como la suma módulo 3 (por ejemplo, 2+2=1);

-- 237 of 267 --

224
4) el cero, es decir, A = {0}, interpretando 0 como 0 de A, suc(0)=0 y 0+0=0.
Como veremos a continuación, los diferentes modelos de una especificación pueden compararse. Veremos que el
modelo (1) de la especificación naturales_3 es especial en cierto sentido puesto que es isomorfo al álgebra Tnaturales_3
definida por la especificación, y se denomina álgebra inicial.
Definición (SIG-homomorfismo y SIG-isomorfismo). Dadas dos SIG-álgebras A y B, un SIG-homomorfismo es una
familia f = {f g}g∈G de aplicaciones f g: Ag → Bg que conmuta con las operaciones, es decir, satisface:
• 	∀ g ∈ G, ∀ σ: → g, f g(σA) = σB
• 	∀σ: g1,…,gn → g, ∀ a1∈ Ag1, …, ∀ an ∈ Agn, f g(σA(a1,…,an)) = σB(f g1(a1),…,f gn(an)).
Un SIG-homomorfismo biyectivo se llama SIG-isomorfismo. Si existe un SIG-isomorfismo de A a B diremos que A y
B son isomorfas, y se denota A ≈ B. 	♦
Si existe un SIG-homomorfismo f de una SIG-álgebra A a otra B, se puede definir sobre los valores de A la siguiente
relación de equivalencia: dos valores son equivalentes si y sólo si su imagen en B coincide. El álgebra cociente de A con
respecto a esa relación de equivalencia es, de nuevo, una SIG-álgebra, y además es isomorfa a la imagen mediante f de A,
f(A) ⊆ B. Es decir, los homomorfismos pueden identificar en la imagen valores que son distintos en el origen. Por tanto, es
de esperar que un álgebra con más valores distintos tenga homomorfismos hacia otras con menos valores, pero no a la
inversa.
Dada una signatura SIG, la clase de todas las SIG-álgebras junto con todos los homomorfismos entre cada par de SIG-
álgebras, denotada por ALG(SIG), es una estructura algebraica denominada categoría porque la composición de dos SIG-
homomorfismos es otro SIG-homomorfismo y las aplicaciones identidad son SIG-homomorfismos.
De forma análoga, dada una especificación ESPEC, la clase de todas las ESPEC-álgebras junto con todos los
homomorfismos entre cada par de ESPEC-álgebras, denotada por ALG(ESPEC), es también una categoría.
En una categoría, los isomorfismos entre objetos definen una relación de equivalencia en la clase de objetos. Por
ejemplo, dos SIG-álgebras A y B de ALG(SIG) están relacionadas si entre ellas existe un SIG-isomorfismo (es decir, A ≈ B).
Las clases de equivalencia así definidas se llaman clases de isomorfía.
Definición (Álgebra inicial). Un álgebra I se dice inicial en una categoría si existe un único homomorfismo de I a cada
una de las restantes álgebras de la categoría. 	♦
Teorema. Si una categoría posee un álgebra inicial, ésta es única salvo isomorfismo. Es decir, en una categoría en la
que existen álgebras iniciales, éstas forman una clase de isomorfía. 	♦
Teorema. Dada una signatura SIG y una especificación ESPEC = (SIG,E):