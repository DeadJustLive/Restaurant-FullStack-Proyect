# 2. Semántica de una especificación algebraica

Definición (Signatura). Una signatura SIG es un par (G,OP), donde:
• 	G es un conjunto de símbolos que llamaremos géneros.
• 	OP es un conjunto de símbolos que llamaremos nombres de operaciones. Cada símbolo σ ∈ OP tiene asociado un
perfil σ: g1…gn → g que consta de una secuencia (quizás vacía) g1…gn de símbolos de G, llamada aridad de OP y
que especifica el número y género de sus argumentos, y de un símbolo g de G, llamado rango de OP que especifica
el género del resultado. 	♦
Si la aridad de una operación σ es vacía,es decir σ: → g, se dice que σ es un símbolo de constante.

-- 233 of 267 --

220
Nótese que, en una signatura, tanto G como OP sólo son conjuntos de símbolos sin significado. Los símbolos g ∈ G y
σ ∈ OP son sólo nombres. A continuación, definimos un álgebra sobre dicha signatura que constituye una interpretación
posible de sus símbolos.
Definición (SIG-álgebra). Dada una signatura SIG = (G,OP), un álgebra heterogénea A sobre SIG, o simplemente
SIG-álgebra es un par ({Ag}g∈G ,OP A), donde:
• 	{Ag}g∈G , es una familia de conjuntos no vacíos; los elementos de cada Ag se llaman soporte del género g.
• 	OPA es un conjunto de aplicaciones σA tal que:
∀ σ ∈ OP con perfil g1 …gn → g, ∃ σA ∈ OPA de la forma σA: Ag1 × … × Agn → Ag.
Cada aplicación σA se denomina interpretación en A del símbolo de operación σ. 	♦
Ejemplo: Considérese la signatura definida en la siguiente especificación.
espec pilasDeEnteros
géneros bool,ent,pila
operaciones
verdad,falso: -> bool
¬_: bool -> bool
_∧_,_∨_: bool bool -> bool
0: -> ent
suc,pred: ent -> ent
_+_,_-_: ent ent -> ent
pilaVacía: -> pila
apilar: pila ent -> pila
cima: pila -> ent
desapilar: pila -> pila
vacía?: pila -> bool
fespec
Es decir, SIG = (G,OP), con G = {bool,ent,pila} y OP = {verdad, falso, ¬, ∧, ∨, 0, suc, +, -, pilaVacía,
apilar, cima, desapilar, vacía?}.
Presentamos a continuación tres posibles álgebras heterogéneas sobre SIG. Primera interpretación, A1
:
A 1
bool 	= {true,false}; 	A 1
ent 	= Z; 	A 1
pila 	= Z*
Z* denota el conjunto de todas las secuencias de longitud finita de números enteros, incluida la secuencia vacía. Las
operaciones internas sobre A 1
bool y A 1
ent 	son las habituales del álgebra booleana y de los números enteros. El resto son
las siguientes (‘i’ denota un entero cualquiera, ‘ε’ denota la secuencia vacía y ‘s’ denota un elemento cualquiera de Z*):
pilaVacíaA1 = ε; 	apilarA1
(s,i) = si
desapilarA1(ε) = ε; 	desapilarA1
(si) = s
cimaA1(ε) = 0; 	cimaA1
(si) = i
vacía?A1(ε) = true; 	vacía?A1
(si) = false
Una segunda interpretación:
A 2
bool = {T,F,KK}; 	A 2
ent = Z; 	A 2
pila = {¡y_a_mi_qué!}
Las operaciones internas sobre A 2
ent son las habituales. El resto son las siguientes (‘i’ denota un entero cualquiera):
verdadA2 = T; 	falsoA2 = F