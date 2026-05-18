# 3. Construcción de especificaciones

Las especificaciones de tipos complejos pueden ser textos voluminosos. Por tanto, son necesarias las siguientes
características en su diseño: modularidad, legibilidad, estructuración, documentación…
Las características de modularidad y estructuración se consiguen comenzando por los tipos básicos (booleanos,
naturales, enteros…) y progresando hacia tipos más complejos (secuencias o listas de enteros, conjuntos, multiconjuntos,
pilas, árboles, etc., etc.). Cada módulo (espec … fespec) incluye la definición de uno o varios (en número reducido)
géneros, es decir tipos, o nuevas operaciones de un género previamente especificado (“enriquecimiento” del tipo).
El método de construcción de especificaciones de un TAD que se presenta consiste en introducir un cierto orden en la
escritura de las ecuaciones relacionadas con el género correspondiente.
Sea g el símbolo o identificador del género correspondiente al tipo que se desea definir. Denotamos por OP(g) el
conjunto de operaciones relacionadas con g (es decir, cuyo perfil incluye a g). Las operaciones de OP(g) se clasifican en:
• 	constructoras: operaciones cuyo resultado es de género g, denotadas por Cons(g);
• 	observadoras: operaciones que tienen uno o más argumentos de género g y cuyo resultado no es de género g,
denotadas por Obs(g).

-- 239 of 267 --

226
Ejemplo:
espec naturales
usa booleanos
género natural
operaciones
0: -> natural
suc: natural -> natural
_+_: natural natural -> natural
_≤_: natural natural -> booleano
fespec
Las operaciones 0, suc y + son constructoras mientras que la operación ≤ es observadora.
Las operaciones constructoras se dividen, a su vez, de la siguiente forma:
• 	generadoras: son aquéllas que son necesarias para generar todos los valores del tipo y tales que excluyendo
cualquiera de ellas ya no es posible generar todos esos valores, denotadas por Gen(g):
∀ t ∈ TSIGg, ∃ t' ∈ TGen(g), t ≡E t'.
• 	modificadoras: son las operaciones constructoras que no son generadoras, se denotan por Mod(g).
En el ejemplo anterior, resulta obvio que la elección es Gen(natural) = {0,suc}, porque con cualquier otra elección
no es posible generar todos los valores del tipo (por ejemplo, Gen(natural) = {0,+}). En otros casos hay más de una
elección posible. Por ejemplo, en la especificación bolsasDeNaturales de la lección anterior, tanto Gen(bolsa) =
{[],[_],_∪_} como Gen(bolsa) = {[],_⊕_} son generadoras.
En resumen, dado un género g, las operaciones relacionadas con g se clasifican en:
OP(g) =


Cons(g) = 

Gen(g) generadoras
Mod(g) modificadoras
Obs(g) observadoras
En cuanto al conjunto Gen(g) de operaciones generadoras, pueden darse dos situaciones:
• 	conjunto libre de generadoras: todo término de T Gen(g) denota un valor diferente en el tipo de datos
correspondiente a g;
• 	conjunto no libre de generadoras: dos o más términos distintos de TGen(g) denotan un mismo valor del tipo.
Por ejemplo, Gen(natural) = {0,suc} es un conjunto libre de generadoras del tipo natural porque cada término de
TGen(natural) (es decir: 0, suc(0), suc(suc(0)), …) denota un natural diferente.
Lo mismo sucede con Gen(bolsa) = {[],_⊕_} con respecto al tipo bolsa (por ejemplo, la sucesión [3,4,5] sólo
puede generarse como 3⊕(4⊕(5⊕[]))).
En cambio, Gen(bolsa) = {[],[_],_∪_} es no libre puesto que, por ejemplo, la sucesión [3,4,5] puede generarse
como ([3]∪[4])∪[5] ó como [3]∪([4]∪[5]).
Cuando el conjunto de operaciones generadoras es libre puede establecerse una biyección entre el conjunto TGen(g)
y el soporte TESPECg. Para cada clase [t] de TESPECg, es decir, para cada valor del tipo de interés, existe un único término t c ∈
[t] ∩ TGen(g), que se denomina término canónico de la clase. Es decir, para cada valor del tipo existe un único término
formado sólo por operaciones generadoras.
Cuando el conjunto de generadoras no es libre el especificador debe elegir un término (el que, a su juicio, sea más
sencillo) como representante canónico de cada clase.
La elección que se haga de la clase Gen(g) así como la elección de los términos canónicos en el caso en que Gen(g)
sea no libre, influyen en la escritura de las ecuaciones de la especificación.

-- 240 of 267 --

227
Una metodología adecuada para escribir ecuaciones es la siguiente: