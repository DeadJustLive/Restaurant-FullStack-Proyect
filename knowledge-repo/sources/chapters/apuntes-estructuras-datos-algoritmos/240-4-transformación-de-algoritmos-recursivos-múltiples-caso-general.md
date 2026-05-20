# 4. Transformación de algoritmos recursivos múltiples: caso general

En el caso particular anterior, se han considerado algoritmos que se corresponden con un recorrido en pre-orden del
árbol binario de valores del parámetro, es decir, con una operación del tipo:

-- 253 of 267 --

240
operación
preOrden: arbin -> lista
ecuaciones e:elemento; ai,ad:arbin
preOrden(vacío) = []
preOrden(plantar(e,ai,ad)) = [e] & preOrden(ai) & preOrden(ad)
Ahora vamos a considerar el caso general de un algoritmo con dos llamadas recursivas. De igual forma, se puede
asociar un árbol binario de valores del parámetro del algoritmo e identificar el problema dado con el de una operación
sobre el árbol de tipo general como la siguiente:
operación
r: arbin -> lista
ecuaciones e:elemento; ai,ad:arbin
[e0
1 ] 	r(vacío) = L0
[e0
2 ] 	r(plantar(e,ai,ad)) = f(plantar(e,ai,ad),r(ai),r(ad))
Donde L0 representa una constante cualquiera de género lista y f es una operación cualquiera con el siguiente perfil:
operación
f: arbin lista lista -> lista
En notación algorítmica, la operación anterior se puede implementar de forma recursiva de la siguiente forma:
función r(a:arbin) devuelve lista
variables ai,ad:arbin
función L0 devuelve lista
...
función f(a:arbin; L1,L2:lista) devuelve lista
...
principio
si esVacío(a) entonces
devuelve(L0)
sino
subIzq(a,ai);
subDer(a,ad);
devuelve(f(a,r(ai),r(ad)))
fsi
fin
Un ejemplo de algoritmo recursivo que responde al esquema general anterior es el siguiente:
procedimiento r(ent x:tx)
principio
si C(x) entonces
A(x)
sino
B1(x);
r(sig1(x));
B2(x);
r(sig2(x));
B3(x)
fsi
fin
El algoritmo anterior tiene asociado un recorrido del árbol de valores del parámetro x en el que cada nodo se visita tres
veces: antes de recorrer su subárbol izquierdo, después de tratar su subárbol izquierdo, y después de tratar su subárbol
derecho.

-- 254 of 267 --

241
Antes de deducir la versión iterativa del algoritmo r, supongamos que existe un valor especial del tipo lista, que
denotaremos por ⊥ y llamaremos lista indefinida (si resulta extraño, puede interpretarse/implementarse mediante un par o
registro con dos campos: uno de tipo lista y otro booleano que dice si la lista es indefinida o no).
Vamos a emplear una pila de pares (es decir, de registros con dos campos) formados por: un árbol binario no vacío
y una lista. Los valores del tipo par (árbol, lista) los generaremos con la siguiente operación:
operación
par: arbin lista -> parArbLis
La interpretación intuitiva de la pila de pares es la siguiente:
• 	un par par(a,⊥) en la pila indica que estamos calculando r(a) y aún no sabemos nada sobre sus hijos;
• 	un par par(a,LL), con LL ≠ ⊥, en la pila indica que estamos calculando r(a) y la solución de su hijo izquierdo
ya ha sido calculada, y vale LL, por lo que ahora estamos calculando la solución de su hijo derecho.
Definimos, en primer lugar, la siguiente operación auxiliar:
operación
r1: lista pila -> lista
ecuaciones L,LL:lista; a:arbin; p:pila
[e1
1 ] 	r1(L,pilaVacía) = L
[e1
2 ] 	r1(L,apilar(p,par(a,⊥))) = r1(r(subDer(a)),apilar(p,par(a,L))
[e1
3 ] 	si LL≠⊥ ⇒ r1(L,apilar(p,par(a,LL))) = r1(f(a,LL,L),p)
La interpretación intuitiva de la operación anterior es la siguiente:
• 	r1(L,p) representa lo siguiente: L es la solución para uno de los hijos del árbol a que está en la cima de p;
o 	si la pareja de este árbol a es ⊥, entonces L es la solución para el hijo izquierdo de a, y lo que vamos a
hacer es sustituir la cima par(a,⊥) por la cima par(a,L) y pasaremos a resolver el hijo derecho de a;
o 	si, en cambio, la cima es par(a,LL), con LL≠⊥, entonces LL es la solución del hijo izquierdo de a, L es
la solución del hijo derecho y ya se puede calcular la solución de a como f(a,LL,L).
A continuación, vamos a definir una nueva operación auxiliar (parcial):
operación
parcial r2: arbin lista pila -> lista
dominio de definición a:arbin; L:lista; p:pila
r2(a,L,p) está definido sólo si (vacío?(a)=verdad) ∨ (L=⊥)
ecuaciones a:arbin; L:lista; p:pila
[e2
1 ] 	r2(a,⊥,p) = r1(r(a),p)
[e2
2 ] 	L≠⊥ ⇒ r2(vacío,L,p) = r1(L,p)
La interpretación intuitiva de la operación anterior es la siguiente:
• 	la operación r2 distingue entre cuándo aplicamos r1 para resolver un árbol sin tener todavía nada calculado
(ecuación [e2
1 ]) y cuándo la aplicamos a partir de una lista ya calculada (ecuación [e2
2 ]).
Lema 1. Si encontramos una solución iterativa de r2, tenemos una solución iterativa de r, en la forma siguiente:
r(a) 	=
[e1
1]
r1(r(a),pilaVacía) 	=
[e2
1]
r2(a,⊥,pilaVacía) 	♦
Lema 2. La operación r2(a,L,p) admite una definición recursiva final en el caso (a≠vacío)∧(L=⊥). En efecto:
a≠vacío ⇒ r2(a,⊥,p) 	=
[e2
1]
r1(r(a),p) 	=
[e0
2]

-- 255 of 267 --

242
= r1(f(a,r(subIzq(a)),r(subDer(a))),p) 	=
[e1
3]
= r1(r(subDer(a)),apilar(p,par(a,r(subIzq(a))))) 	=
[e1
2]
= r1(r(subIzq(a)),apilar(p,par(a,⊥))) 	=
[e2
1]
= r2(subIzq(a),⊥,apilar(p,par(a,⊥))) 	♦
Lema 3. La operación r2(a,L,p) admite una definición recursiva final en el caso (a=vacío)∧(L=⊥). En efecto:
r2(vacío,⊥,p) 	=
[e2
1]
r1(r(vacío),p) 	=
[e0
1]
r1(L0,p) 	=
[e2
2]
r2(vacío,L0,p) 	♦
Lema 	4. 	La 	operación 	r2(a,L,p) 	admite 	una 	definición 	recursiva 	final 	en 	el 	caso
(a=vacío)∧(L≠⊥)∧(cima(p)=par(aa,⊥)). En efecto:
L≠⊥ ⇒ r2(vacío,L,apilar(p,par(a,⊥))) 	=
[e2
2]
= r1(L,apilar(p,par(a,⊥))) 	=
[e1
2]
= r1(r(subDer(a)),apilar(p,par(a,L))) 	=
[e2
1]
= r2(subDer(a),⊥,apilar(p,par(a,L))) 	♦
Lema 	5. 	La 	operación 	r2(a,L,p) 	admite 	una 	definición 	recursiva 	final 	en 	el 	caso
(a=vacío)∧(L≠⊥)∧(cima(p)=par(aa,LL))∧(LL≠⊥). En efecto:
(L≠⊥)3(LL≠⊥) ⇒ r2(vacío,L,apilar(p,par(a,LL))) 	=
[e2
2]
= r1(L,apilar(p,par(a,LL))) 	=
[e1
3]
= r1(f(a,LL,L),p) 	=
[e2
2]
r2(vacío,f(a,LL,L),p) 	♦
Lema 6. La operación r2(a,L,p) admite la siguiente solución trivial o directa (es decir, no recursiva) en el caso
(a=vacío)∧(L≠⊥)∧(p=pilaVacía):
L≠⊥ ⇒ r2(vacío,L,pilaVacía) 	=
[e2
2]
r1(L,pilaVacía) 	=
[e1
1]
L 	♦
Ahora, utilizando los lemas 2, 3, 4, 5 y 6, se obtiene la siguiente solución recursiva final para r2:
función r2Final(a:arbin; L:lista; p:pila) devuelve lista
{Pre: esVacío(a)
∨(L=
⊥)}
variable LL:lista;
unPar:registro
ar:arbin;
li:lista
freg
principio
selección
(L≠⊥) and esVacía(p) {
⇒ esVacío(a)}: devuelve(L); {lema 6}
not esVacío(a) {
⇒ L=
⊥}: devuelve (r2(subIzq(a),L,apilar(p,par(a,⊥)))); {lema 2}
(L=⊥) and esVacío(a): devuelve (r2(a,L0,p)); {lema 3}
(L≠⊥) and not esVacía(p) {
⇒ esVacío(a)}:

-- 256 of 267 --

243
unPar:=cima(p);
a:=unPar.ar;
LL:=unPar.li;
desapilar(p);
si LL=⊥ entonces {lema 4}
devuelve (r2(subDer(a),⊥,apilar(p,par(a,L))))
sino {lema 5}
devuelve (r2(árbolVacío,f(a,LL,L),p))
fsi
fselección
fin
El método de transformación de algoritmos recursivos finales en iterativos, visto al principio de esta lección, se puede
aplicar al algoritmo r2Final, obteniéndose:
función r2Iter(a:arbin; L:lista; p:pila) devuelve lista
{Pre: esVacío(a)
∨(L=
⊥)}
variables ll:lista;
unPar:registro
ar:arbin;
li:lista
freg;
aa:arbin
principio
mientrasQue (L=⊥) or not esVacía(p) hacer
selección
not esVacío(a): 	apilar(p,par(a,⊥));
subIzq(a,aa);
a:=aa;
(L=⊥) and esVacío(a): 	L:=L0;
(L≠⊥) and not esVacía(p): unPar:=cima(p);
a:=unPar.ar;
LL:=unPar.li;
desapilar(p);
si LL=⊥ entonces
apilar(p,par(a,L));
subDer(a,aa);
a:=aa;
L:=⊥
sino
L:=f(a,LL,L);
creaVacío(a)
fsi
fselección
fmq;
devuelve L
fin
Finalmente, podemos escribir la versión iterativa del algoritmo r utilizando r2Iter (de acuerdo con el lema 1):
función rIter(a:arbin) devuelve lista
principio
devuelve r2Iter(a,⊥,pilaVacía)
fin
Se proponen los siguientes ejercicios:
• 	Escribir un algoritmo iterativo que implemente el “recorrido de tres visitas” de un árbol binario:
operación
vis3: arbin -> lista
ecuaciones e:elemento; ai,ad:arbin

-- 257 of 267 --

244
vis3(vacío) = []
vis3(plantar(e,ai,ad)) = [e] & vis3(ai) & [e] & vis3(ad) & [e]
• 	Escribir un algoritmo iterativo que genere una lista conteniendo todas las hojas del árbol:
operación
hojas: arbin -> lista
ecuaciones e:elemento; ai,ad:arbin
hojas(vacío) = []
vacío?(ai) ∧ vacío?(ad) ⇒ hojas(plantar(e,ai,ad)) = [e]
¬vacío?(ai) ∨ ¬vacío?(ad) ⇒ hojas(plantar(e,ai,ad)) = hojas(ai) & hojas(ad)
• 	Escribir un algoritmo iterativo que resuelva el problema de las torres de Hanoi.

-- 258 of 267 --

245
Anexo 6: Chuletas de sintaxis de especificación y pseudocódigo
Indice