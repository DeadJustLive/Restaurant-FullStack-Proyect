# 4. Verificación con especificaciones algebraicas

Un beneficio adicional que se obtiene al trabajar con TAD es la posibilidad de modularizar las tareas de verificación
formal. Debe recordarse que los TAD se utilizan como base para la descomposición modular de programas grandes. Vemos
ahora cómo esta metodología de diseño facilita la verificación de cada módulo por separado.
Consideremos un TAD especificado algebraicamente e implementado por medio de un módulo. La verificación del
programa en lo concerniente a este TAD se realiza en dos fases:
• 	Verificación de los programas (más correctamente, módulos) usuarios del TAD. Esta tarea se realiza utilizando
solamente la especificación algebraica del TAD. No debe tenerse en cuenta la implementación elegida para el tipo.
• 	Verificación de que la implementación del TAD es correcta, es decir, los valores del TAD son todos representados
y la implementación de las operaciones verifica las propiedades expresadas mediante las ecuaciones. En esta fase
no deben tenerse en cuenta el resto de módulos usuarios del TAD.
En resumen, la especificación algebraica de un tipo abstracto de datos actúa como una barrera permite descomponer la
tarea de la verificación en dos niveles independientes.
La verificación de programas usuarios de TAD sigue las mismas reglas conocidas para la verificación de programas
con tipos concretos sencillos, como booleanos, enteros o reales. Ahora bien, hay que tener en cuenta que:
• 	En un predicado pueden aparecer variables del tipo abstracto en cuestión, así como operaciones del tipo
(especificadas algebraicamente).
• 	La regla de la asignación sigue siendo válida. Debe tenerse en cuenta que la asignación de un valor a una variable
de un TAD se hará mediante la evaluación de una operación constructora del tipo correspondiente o bien de una
operación observadora de otro TAD definido sobre el primero.
El principal problema en la verificación de programas con TAD está en la forma de simplificar predicados o, en
general, deducir otros nuevos predicados a partir de los primeros. Cuando los tipos involucrados son sencillos (booleanos,
enteros, reales), las reglas para deducir nuevos predicados son conocidas, por los conocimientos previos que de esos tipos
tenemos (es decir, por nuestra experiencia con la Lógica o las Matemáticas). En el caso de TAD más complejos, las únicas
reglas con que contamos para razonar son las ecuaciones de la especificación correspondiente y otras propiedades que
puedan ser demostradas a partir de ellas.

-- 243 of 267 --

230
Pueden deducirse dos tipos de propiedades atendiendo a la forma de demostrarlas:
• 	Propiedades ecuacionales: se deducen mediante cálculo ecuacional; éste consiste en aplicar las reglas de la
congruencia ≡E, sustituyendo en cada paso una ecuación por otra nueva. Ejemplo:
desapilar(apilar(p,e1)) = q ⇔
p = q ⇔
apilar(p,e2) = apilar(q,e2)
• 	Propiedades inductivas: se deducen mediante inducción estructural; ésta consiste en un principio de inducción
sobre los valores del TAD. La inducción estructural se aplica en dos fases:
o 	Base de la inducción: se demuestra la propiedad para los valores básicos del tipo, es decir, para los
generados mediante operaciones constantes o por generadoras en cuyos argumentos no aparezcan valores
del tipo.
o 	Paso de inducción: para cada valor no básico (es decir, aquél cuya operación más externa es una
generadora con argumentos del tipo en cuestión), se demuestra que satisface la propiedad asumiendo la
hipótesis de inducción; ésta consiste en asumir para cada valor no básico que sus argumentos del tipo
satisfacen la propiedad.
Las propiedades ecuacionales son satisfechas por todos los modelos de la especificación. En cambio, las inductivas
sólo las satisfacen los modelos sin basura.
Como ejemplo, consideremos de nuevo la especificación de las pilas:
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
Supóngase que el tipo pila ha sido enriquecido con la operación inv: pila -> pila, que invierte los elementos
de una pila. Para especificar esta operación mediante ecuaciones vamos a utilizar una operación auxiliar, “apila pila”,
_∇_: pila pila -> pila, operación que apila una pila (su primer argumento) sobre otra (el segundo). Las ecuaciones
que definen estas operaciones son las siguientes:
espec pilas
...
operaciones
...
_∇_: pila pila -> pila
inv: pila -> pila
ecuaciones ... q:pila
...
pilaVacía ∇ p = p
apilar(p,e) ∇ q = apilar(p ∇ q,e)
inv(pilaVacía) = pilaVacía
inv(apilar(p,e)) = inv(p) ∇ apilar(pilaVacía,e)
fespec

-- 244 of 267 --

231
Se trata de verificar formalmente el siguiente algoritmo que implementa la operación de inversión utilizando las
operaciones anteriores (pilaVacía, apilar, desapilar, cima, vacía?):
{Pre: p = p0}
q:=pilaVacía
mientrasQue not(vacía?(p)) hacer
e:=cima(p);
p:=desapilar(p);
q:=apilar(q,e)
fmq
{Post: q = inv(p0)}
Conjeturamos que el invariante del bucle es el siguiente:
I: p0 = inv(q) ∇ p
El invariante se satisface al comienzo del bucle:
(p0 = p) ∧ (q = pilaVacía) ⇒2
(p0 = pilaVacía ∇ p) ∧ (q = pilaVacía) ⇒3
(p0 = inv(pilaVacía) ∇ p) ∧ (q = pilaVacía) ⇒
p0 = inv(q) ∇ p
El invariante conduce a la postcondición:
(p0 = inv(q) ∇ p) ∧ (vacía?(p)) ⇒4
(p0 = inv(q) ∇ p) ∧ (p = pilaVacía) ⇒
p0 = inv(q) ∇ pilaVacía ⇒5
p0 = inv(q) ⇒
inv(p0) = inv(inv(q)) ⇒6
inv(p0) = q
El invariante es tal invariante:
(p0 = inv(q) ∇ p) ∧ (¬vacía?(p)) ⇒7
(p0 = inv(q) ∇ p) ∧ (p = apilar(desapilar(p),cima(p))) ⇒
p0 = inv(q) ∇ apilar(desapilar(p),cima(p)) ⇒
p0 = inv(q) ∇ apilar(desapilar(p),cima(p)) ∇ pilaVacía ⇒
p0 = inv(q) ∇ apilar(desapilar(p) ∇ pilaVacía,cima(p)) ⇒
p0 = inv(q) ∇ apilar(pilaVacía ∇ desapilar(p),cima(p)) ⇒
p0 = inv(q) ∇ (apilar(pilaVacía,cima(p)) ∇ desapilar(p)) ⇒8
p0 = (inv(q) ∇ apilar(pilaVacía,cima(p))) ∇ desapilar(p) ⇒
p0 = inv(apilar(q,cima(p))) ∇ desapilar(p)
2 Por la primera ecuación de definición de ∇.
3 Por la primera ecuación de definición de inv.
4 Es trivial que vacía?(p) ⇒ (p = pilaVacía) por las ecuaciones de definición de vacía?.
5 Por inducción estructural: p ∇ pilaVacía = p. En efecto:
Base de la inducción (caso p = pilaVacía): pilaVacía ∇ pilaVacía = pilaVacía.
Paso de inducción (caso p = apilar(q,e)):
apilar(q,e) ∇ pilaVacía 	=apilar(q ∇ pilaVacía,e) = apilar(q,e).
6 Se demuestra igualmente por inducción estructural (se plantea como ejercicio).
7 Se demuestra fácilmente que: ¬vacía?(p) ⇒ 	p = apilar(desapilar(p),cima(p)).
8 La propiedad asociativa de la operación ∇ se demuestra fácilmente (se plantea como ejercicio).

-- 245 of 267 --

232
Para demostrar que el bucle termina hay que utilizar una nueva operación, alt: pila -> natural que nos da el
número de elementos de una pila, como función limitadora.
espec pilas
usa ...naturales
...
operaciones
...
alt: pila -> natural
ecuaciones
...
alt(pilaVacía) = 0
alt(apilar(p,e)) = suc(alt(p))
fespec
En efecto, basta ver que alt(p) es estrictamente decreciente hacia su cota inferior, 0, que se alcanza si y sólo si se
verifica vacía?(p).
Ejercicio: Demostrar que la operación + de la especificación naturales_3, presentada más arriba, es conmutativa.
Demostrar la corrección de la implementación de un TAD es, en general, bastante más difícil que verificar la corrección
de los programas usuarios del TAD. De hecho, no existe un enfoque formal que admita una solución cómoda en la práctica.
Nos limitamos, por tanto, a una introducción intuitiva de la idea de implementación de un TAD.
Implementar un TAD es simular sus valores por medio de valores de otros tipos “más concretos” (tipos ya
implementados), denominados soporte de la implementación, y simular sus operaciones por medio de las operaciones de
dichos tipos más concretos.
Por ejemplo, el tipo conjcar, definido en la especificación conjuntosDeCaracteres vista antes, puede
implementarse utilizando un vector de caracteres v[1..max] y un contador n, 0 ≤ n ≤ max. Convenimos que la parte
utilizada del vector son las componentes 1..n y que no se almacenan componentes repetidas. En este caso, los valores
abstractos de tipo conjcar se simulan mediante pares (v,n), formados por un vector y un entero. Las operaciones del
tipo conjcar (vacío, poner, quitar, ∪, ∩, ∈, esVacío, cardinal) pueden simularse fácilmente mediante operaciones
que trabajan con pares (v,n). El problema es cómo saber que la implementación del tipo conjcar es correcta.
Para asegurarse de la corrección de la implementación es necesario, en primer lugar, establecer la función de
abstracción. Esta es una correspondencia entre los valores del tipo soporte y los del tipo especificado. Si denotamos por
AESPEC un álgebra isomorfa a TESPEC y por ASOP el álgebra definida por el tipo soporte, la función de abstracción es una
familia de aplicaciones Φ = {Φg}g∈G:
Φg: ASOPg → AESPECg
En el ejemplo anterior, a cada par (v,n) le corresponde un conjunto de caracteres (abstracto). Nótese que varios pares
distintos (v,n) pueden corresponder a un mismo conjunto (por ejemplo, si difieren sólo en el orden de los elementos
almacenados en las componentes 1..n de v). Además, hay pares (v,n) que no representan a ningún conjunto (por ejemplo,
los que tienen elementos repetidos en las componentes 1..n de v o los que tengan un valor negativo de n). En este caso el
tipo soporte tiene basura desde el punto de vista del tipo implementado.
En general, las características de la función de abstracción son:
• 	suprayectiva: todos los valores de AESPECg deben ser representados;
• 	no necesariamente inyectiva: un valor de AESPECg puede tener varios valores soporte;
• 	parcial: no todo valor del tipo soporte representa un valor del tipo implementado;
• 	homomórfica: es decir, debe conmutar con las operaciones:
∀ σ: → g, Φg(σASOP) = σAESPEC
∀ σ: g1…gn → g, Φg(σASOP(t1 ,…,t n)) = σAESPEC(Φg1(t1),…, Φg n(t n)).

-- 246 of 267 --

233
La suprayectividad es obviamente imposible si el cardinal del conjunto de valores del tipo representado es infinito. En
ese caso, nos conformaremos con representaciones de un subconjunto de valores.
En particular, la implementación de un TAD no debe introducir confusión, es decir, no puede ocurrir que a dos
valores distintos del tipo implementado se asocie un mismo valor del tipo soporte.
La implementación es correcta si el álgebra AESPEC es isomorfa a la que resulta del álgebra ASOP tras realizar las
siguientes modificaciones:
1. 	enriquecerla con las operaciones del tipo implementado;
2. 	restringirla a la subálgebra de valores que representan algún valor del tipo implementado, es decir, eliminar la
basura;
3. 	identificar las distintas representaciones que puede tener cada valor del tipo implementado (se consigue mediante
la incorporación de las ecuaciones de AESPEC).

-- 247 of 267 --

234

-- 248 of 267 --

235
Anexo 5: Transformación de algoritmos recursivos en iterativos
Indice