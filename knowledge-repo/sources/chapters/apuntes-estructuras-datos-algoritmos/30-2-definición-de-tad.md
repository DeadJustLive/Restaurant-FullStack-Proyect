# 2. Definición de TAD

La siguiente puede considerarse una definición informal de un tipo abstracto de datos (TAD, en lo que sigue): un
TAD es una colección de valores y de operaciones definidos mediante una especificación independiente de cualquier
representación.
Ejemplos ya conocidos son los booleanos y naturales. A continuación, se presentan algunas de las operaciones
importantes sobre estos tipos, que ya estamos acostumbrados a manejar de forma independiente de la representación de los
valores de los tipos correspondientes (se utiliza una notación que se presentará más adelante, si bien resulta fácil de
interpretar sin más comentarios previos).

-- 11 of 267 --

4
espec boolnat
géneros bool,nat
operaciones
verdad: -> bool
falso: -> bool
¬_: bool -> bool
_∧_,_∨_: bool bool -> bool
0: -> nat
suc: nat -> nat
_+_,_*_: nat nat -> nat
_≤_,_>_: nat nat -> bool
fespec
Algunos lenguajes no permiten decidir las operaciones que se desea utilizar para cada tipo definido por el programador.
Es decir, hay lenguajes que no permiten definir tipos, sólo representar unos tipos con otros. En esos lenguajes, si por ejemplo
quisiéramos utilizar secuencias de datos con una cierta colección de operaciones, tendríamos que representarlas con otro
tipo (vector, fichero…). Además, la representación sería visible en todo el ámbito del programa.
En cambio, la mayor parte de lenguajes en la actualidad sí permiten decidir con precisión qué operaciones se podrán
utilizar para los valores de un tipo definido por el programador. Es en esos casos en los que la programación con TAD tiene
sentido y adquiere importancia.
La programación con TAD requiere dos pasos:
Paso 1. Definición del tipo. Establecer la interfaz con el (programador) usuario del tipo: decidir las operaciones
necesarias/adecuadas para manipular los valores y especificarlas (tiene una parte sintáctica y otra semántica).
Paso 2. Implementación del tipo. Elegir la representación de los valores e implementar las operaciones.
El concepto fundamental subyacente bajo la programación con TAD es la encapsulación. La encapsulación consiste
básicamente en:
• 	la privacidad de la representación (el usuario no conoce sus detalles), y
• 	la protección del tipo (el usuario sólo puede utilizar las operaciones previstas).
Ejercicio: pensar en otros TAD ya manipulados, como, por ejemplo, las cadenas de caracteres, los pares ordenados de
naturales, las fechas, etc. ¿Cuáles son las operaciones básicas que pueden necesitarse para manipular estos tipos?
Un TAD es una abstracción porque distingue entre:
• 	los detalles importantes: la interfaz que debe conocer el usuario (comportamiento observable), es decir, la definición
o especificación del tipo (nombre del tipo y los encabezamientos y especificación de las operaciones básicas), y
• 	los detalles ocultables (irrelevantes en ese nivel): la implementación del tipo, es decir, la elección de la
representación de los valores y la implementación de las operaciones básicas.
Los diferentes valores del tipo (dominio) definen un cierto conjunto sobre el que se definen una serie de operaciones.
Se denomina especificación de un tipo abstracto de datos a la definición precisa de dicho tipo, es decir, la definición
del dominio de valores y de las operaciones de manipulación de los mismos. Esta definición puede hacerse utilizando un
lenguaje formal (normalmente algebraico) o bien usando el lenguaje natural para expresar la semántica de las operaciones
del tipo.
Como veremos en la siguiente lección, los TAD están definidos fundamentalmente por la semántica de sus operaciones
y no por los identificadores con que nos refiramos a ellas. Por ejemplo, para el tipo booleano, no es tan importante que
sus valores posibles se llamen verdad y falso como que existan dos valores, v1 y v2, tres operaciones internas definidas
sobre ellos, una monoaria (not) y dos binarias (and y or), verificando una serie de propiedades (not( v1)= v2;
not( v2)= v1; etc.).
A título de ejemplo, se presenta a continuación la especificación de un tipo abstracto de datos denominado conjcar
(una definición del tipo conjunto de caracteres con algunas operaciones básicas de manipulación), de dos formas distintas:
mediante un lenguaje algebraico (especificación formal) y mediante el lenguaje natural (especificación no formal).
Especificación formal (nótese que la semántica de las operaciones se expresa mediante ecuaciones):

-- 12 of 267 --

5
espec conjuntos_de_caracteres
usa booleanos,caracteres,naturales
género conjcar
operaciones
∅: -> conjcar
poner: carácter conjcar -> conjcar
quitar: carácter conjcar -> conjcar
_∈_: carácter conjcar -> booleano
_∪_: conjcar conjcar -> conjcar
_∩_: conjcar conjcar -> conjcar
vacío?: conjcar -> booleano
cardinal: conjcar -> natural
ecuaciones A,B: conjcar; c,c1,c2: carácter
(c1=c2) => poner(c1,poner(c2,A)) = poner(c2,A)
(c1≠c2) => poner(c1,poner(c2,A)) = poner(c2,poner(c1,A))
quitar(c,∅) = ∅
(c1=c2) => quitar(c1,poner(c2,A)) = quitar(c1,A)
(c1≠c2) => quitar(c1,poner(c2,A)) = poner(c2,quitar(c1,A))
c∈∅ = falso
c1∈poner(c2,A) = (c1=c2) ∨ (c1∈A)
A∪∅ = A
A∪poner(c,B) = poner(c,A∪B)
A∩∅ = ∅
(c∈A) => A∩poner(c,B) = poner(c,A∩B)
¬(c∈A) => A∩poner(c,B) = A∩B
vacío?(∅) = verdad
vacío?(poner(c,A)) = falso
cardinal(∅) = 0
cardinal(poner(c,A)) = suc(cardinal(quitar(c,A)))
fespec
Especificación no formal (nótese que en color verde aparece la semántica, escrita en lenguaje natural):
espec conjuntos_de_caracteres
usa caracteres {suponer ASCII extendido, i.e. 256 caracteres}, booleanos, naturales
género conjcar
{Los valores del TAD conjcar representan conjuntos de caracteres,
sin elementos repetidos, y en los que no es relevante el orden en el que
los caracteres se añaden al conjunto.}
operaciones
creaVacío: -> conjcar
{Devuelve un conjunto de caracteres vacío, es decir un conjunto
que no contiene ningún carácter}
poner: carácter e, conjcar c -> conjcar
{Si e está en c, devuelve un conjunto igual a c;
si e no está en c, devuelve el conjunto resultante de añadir e a c}
quitar: carácter e, conjcar c -> conjcar
{Si e está en c, devuelve el conjunto resultante de eliminar e de c;
si e no está en c, devuelve un conjunto igual a c}
pertenece: carácter e, conjcar c -> booleano
{Devuelve verdad si y sólo si e está en c}
unión: conjcar c1, conjcar c2 -> conjcar
{Devuelve un conjunto que contiene todos los caracteres que están en c1 y todos
los que están en c2}
intersección: conjcar c1, conjcar c2 -> conjcar

-- 13 of 267 --

6
{Devuelve un conjunto que contiene únicamente los caracteres que están tanto
en c1 como en c2}
vacío?: conjcar c -> booleano
{Devuelve verdad si y sólo si c no contiene ningún carácter}
cardinal: conjcar c -> natural
{Devuelve el número total de caracteres que contiene c (0 si es vacío)}
{Las cuatro siguientes operaciones son un Iterador. Hablaremos de ello más adelante}
iniciarIterador: conjcar c -> conjcar
{Prepara el iterador para recorrer los caracteres del conjunto c, de forma que el
siguiente carácter a visitar sea el primero que visitamos (situación de no haber
visitado ningún carácter)}
existeSiguiente?: conjcar c -> booleano
{Devuelve falso si ya se han visitado todos los caracteres de c, devuelve verdad en
caso contrario}
parcial siguiente: conjcar c -> carácter
{Devuelve el siguiente carácter de c.
Parcial: la operación no está definida si no existeSiguiente?(c)}
parcial avanza: conjcar c -> conjcar
{Prepara el iterador para visitar el siguiente carácter de c.
Parcial: la operación no está definida si no existeSiguiente?(c)}
fespec