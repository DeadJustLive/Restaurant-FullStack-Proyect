# 4. 	Para cada operación observadora se escriben tantas operaciones como sean necesarias para garantizar que todo

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 155)

## Contenido
# 4. 	Para cada operación observadora se escriben tantas operaciones como sean necesarias para garantizar que todo

término de TOP(g) de género g' (g' ≠ g) sea congruente a algún término de TCons(g'). La estrategia citada en el punto
anterior, para operaciones modificadoras, es útil también aquí.
Para la siguiente especificación de “conjuntos de caracteres”:
espec conjuntosDeCaracteres
usa booleanos,caracteres,naturales
género conjcar
operaciones
vacío: -> conjcar
poner: carácter conjcar -> conjcar
quitar: carácter conjcar -> conjcar
_∪_: conjcar conjcar -> conjcar
_∩_: conjcar conjcar -> conjcar
_∈_: carácter conjcar -> booleano
esVacío: conjcar -> booleano
cardinal: conjcar -> natural
ecuaciones A,B:conjcar; c,c1,c2:carácter
c1=c2 ⇒ poner(c1,poner(c2,A)) = poner(c2,A)
c1≠c2 ⇒ poner(c1,poner(c2,A)) = poner(c2,poner(c1,A))
quitar(c,vacío) = vacío
c1=c2 ⇒ quitar(c1,poner(c2,A)) = quitar(c1,A)
c1≠c2 ⇒ quitar(c1,poner(c2,A)) = poner(c2,quitar(c1,A))
A∪vacío = A
A∪poner(c,B) = poner(c,A∪B)
A∩vacío = vacío
c∈A ⇒ A∩poner(c,B) = poner(c,A∩B)
c∉A ⇒ A∩poner(c,B) = A∩B
c∈vacío = falso
c1∈poner(c2,A) = (c1=c2)∨(c1∈A)
esVacío(vacío) = verdad
esVacío(poner(c,A)) = falso
cardinal(vacío) = 0
cardinal(poner(c,A)) = suc(cardinal(quitar(c,A)))
fespec

-- 241 of 267 --

228
El conjunto obvio de generadoras es Gen(conjcar) = {vacío,poner}. Es un conjunto no libre. El hecho de añadir
un carácter que ya está no modifica el conjunto (primera ecuación, caso c1=c2, propiedad idempotente). Términos obtenidos
añadiendo en distinto orden los mismos caracteres son iguales (caso c1≠c2, propiedad conmutativa).
El conjunto de modificadoras es Mod(conjcar) = {quitar,∪,∩}. Para cada una de ellas se sigue la estrategia indicada
en el paso 3. En el caso c1=c2, la operación modificadora quitar se expresa exclusivamente en términos de una operación
modificadora (en este caso la misma), sin que aparezcan operaciones generadoras (se denomina ecuación derivada).
El conjunto de observadoras es Obs(conjcar) = {∈,esVacío,cardinal}. Las ecuaciones correspondientes siguen
las pautas dictadas en el paso 4.
Consideremos la siguiente especificación del tipo “pila de elementos”:
espec pilas
usa booleanos
parámetro formal
género elemento
fpf
género pila
operaciones
pilaVacía: -> pila
apilar: pila elemento -> pila
desapilar: pila -> pila
cima: pila -> elemento
vacía?: pila -> bool
fespec
Como puede verse, se trata de un tipo genérico (el género elemento es un parámetro formal).
Las operaciones generadoras son Gen(pila) = {pilaVacía,apilar} y son un conjunto libre (toda aplicación de
apilar produce una pila distinta y todas ellas distintas de la pila vacía), por tanto las únicas ecuaciones a escribir
corresponden a la operación modificadora Mod(pila) = {desapilar} y a las observadoras Obs(pila) = {cima,vacía?}.
Los términos canónicos del género pila son (e1, e2, …, son términos de tipo elemento):
pilaVacía
apilar(pilaVacía,e1)
apilar(apilar(pilaVacía,e1),e2)
...
Al tratar de escribir las ecuaciones relativas a la modificadora desapilar, probaríamos a encontrar términos canónicos
congruentes a (p es una pila y e es un elemento):
desapilar(pilaVacía) = ...
desapilar(apilar(p,e)) = ...
En el segundo caso no hay ningún problema:
desapilar(apilar(p,e)) = p
Sin embargo, no hay ningún término canónico congruente a desapilar(pilaVacía). Este término representa una
situación indeseada o situación de error. Para salvar este problema, consideraremos la posible existencia de operaciones
parciales, cuyo dominio pueda ser restringido. En el caso de la operación observadora cima, no tiene sentido el término
cima(pilaVacía). Su dominio de definición debe limitarse a los casos cima(apilar(p,e)), con p y e variables de
géneros pila y elemento, respectivamente. Denotaremos las operaciones parciales de la siguiente forma:
espec pilas
usa booleanos
parámetro formal
género elemento

-- 242 of 267 --

229
fpf
género pila
operaciones
pilaVacía: -> pila
apilar: pila elemento -> pila
desapilar: pila -> pila
parcial cima: pila -> elemento
vacía?: pila -> bool
dominio de definición p:pila; e:elemento
cima(apilar(p,e))
ecuaciones p:pila; e:elemento
desapilar(pilaVacía) = pilaVacía
desapilar(apilar(p,e)) = p
cima(apilar(p,e)) = e
vacía?(pilaVacía) = verdad
vacía?(apilar(p,e)) = falso
fespec
Nótese que a las operaciones parciales se antepone la palabra clave parcial. Tras la cláusula dominios 	de
definición se incluyen los términos para los que se extiende el dominio de las operaciones parciales. Finalmente, hay
que notar que el significado del símbolo = en las ecuaciones cambia en el siguiente sentido: cuando el símbolo = actúe
sobre dos términos en los que aparezca una operación parcial, hay que entender que expresa lo siguiente: “en caso de estar
definidas las operaciones parciales, los dos términos son congruentes”.
