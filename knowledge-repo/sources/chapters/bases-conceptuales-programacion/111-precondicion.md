# PRECONDICI´ON:

* hay una celda al Norte
-}
{
if (elCaminoEstaDespejado(Norte)))
{ Mover(Norte) }
else
{ Esconderse() }
}
Actividad de Programaci ´on 2
Realice el ejercicio 4.1.2 y observe c ´omo se manifiesta el uso de condi-
cionales anidados. (La restricci ´on de utilizar ´unicamente como condici ´on
hayBolitas fuerza a la utilizaci ´on de condicionales anidados.)
Ejercicio 4.1.2. Escribir un programa que decida entre un conjunto de acciones,
bas ´andose en un c ´odigo representado en la celda actual con base en bolitas de
colores. Las acciones se representan con los procedimientos DibujarVentana,
RedimensionarVentana, MaximizarVentana y MinimizarVentana. Los c ´odigos
se indican seg ´un la presencia de bolitas en la celda actual. El c ´odigo que indica
que debe dibujarse una ventana es la presencia de bolitas verdes. El c ´odigo que
indica que la ventana debe redimensionarse es la presencia de bolitas azules
(siempre y cuando no haya verdes). El c ´odigo que indica que la ventana debe
maximizarse es la presencia de bolitas negras (pero no verdes ni azules). Y el
c ´odigo que indica que la ventana debe minimizarse es la presencia de bolitas
rojas (pero no de ninguno de los otros 3 colores). Si no hay bolitas, entonces no
debe hacerse nada.
Cada condici ´on utilizada debe escribirse exclusivamente utilizando la funci ´on
hayBolitas, sin ning ´un otro conectivo. Adem ´as, las acciones son disjuntas; o sea
solo debe realizarse una de ellas.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 134 of 312 --

135
Veremos en la pr ´oxima secci ´on una manera de expresar este ejercicio de for-
ma mucho m ´as adecuada usando alternativa indexada. O sea, los condicionales
anidados no siempre son necesarios. En muchas ocasiones pueden ser reem-
plazados por condiciones m ´as complejas, a trav ´es del uso de conectivos l ´ogicos
y de abstracci ´on a trav ´es de funciones, como se vio en el cap´ıtulo anterior.
Leer con Atenci ´on
El uso de condicionales anidados, entonces, es considerado por noso-
tros como una forma extrema que solo debe utilizarse cuando no es
sencillo abstraer los comportamientos con procedimientos o mejorar las
condiciones con el uso de expresiones complejas mediante conectivos y
funciones, o cuando las condiciones de eficiencia lo requieran. Su abuso
indica una forma altamente operacional de pensar, en contraste con las
formas de alto nivel que proponemos en este libro.
Alternativas con condiciones parciales
La ´ultima de las formas de abuso de la alternativa condicional est ´a vincula-
da con una forma operacional de pensar, y tiene que ver tambi ´en con el uso de
condiciones parciales. Se utiliza en el caso en que deben verificarse dos (o m ´as)
condiciones, pero donde la segunda de ellas es parcial, y depende de que la
primera sea verdadera para poder funcionar adecuadamente. Por ejemplo, con-
sideremos la funci ´on esCeldaVaciaAl del ejercicio 3.2.15; vemos que se trata
de una operaci ´on parcial, que requiere que haya una celda en la direcci ´on da-
da. Supongamos que la queremos utilizar para verificar que no hay enemigos
en una direcci ´on dada (suponiendo que los enemigos se codifican con bolitas
de alg ´un color) y colocar una bolita verde o roja en la celda actual en base a
dicha condici ´on. Claramente, existen dos situaciones donde no hay enemigos en
la direcci ´on dada: cuando no existe la celda en esa direcci ´on, o cuando la celda
existe y est ´a vac´ıa. Esto podr´ıa codificarse utilizando alternativas condicionales
de manera excesivamente operacional de la siguiente forma
procedure CodificarSiHayEnemigoAlFeo(dir}
/*
PROP´OSITO: coloca una bolita roja o verde en la celda actual,
si hay una celda ocupada por enemigos en la
direcci´on dada
*/
{
if (puedeMover(dir))
{ if (not esCeldaVaciaAl(dir)) -- Es seguro preguntar,
-- porque puede moverse
{ Poner(Rojo) } -- Hay celda y hay enemigos
else
{ Poner(Verde) } -- Hay celda pero no enemigos
}
else
{ Poner(Verde) } -- No hay celda, entonces no hay enemigos
}
Esta soluci ´on es innecesariamente complicada, puesto que debemos replicar en
dos ramas la indicaci ´on de que no hay enemigos (una por cada una de las po-
sibilidades de que no haya). En principo parecer´ıa que no puede hacerse de
otra manera, pues para poder invocar la funci ´on esCeldaVaciaAl debemos estar
seguros que se puede mover en dicha direcci ´on.
Sin embargo es posible mejorar esta forma de codificar mediante el uso de
una caracter´ıstica particular de las operaciones booleanas, conocida con el nom-
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 135 of 312 --

136
bre ingl ´es de short circuit (en castellano, circuito corto). Una operaci ´on booleana
En algunas traducciones se uti-
liza como equivalente el t ´ermino
cortocircuito. Sin embargo, con-
sideramos que dicha traducci ´on
no es adecuada. Un cortocircui-
to es una falla en un sistema
el ´ectrico por error en la cone-
xi ´on de ciertos cables; si bien
el t ´ermino en ingl ´es tiene esta
acepci ´on, tambi ´en significa evi-
tar hacer algo, y es esta la acep-
ci ´on que m ´as se ajusta al uso
de short-circuit cuando se ha-
bla de condiciones booleanas.
Dado que el t ´ermino castellano
cortocircuito no tiene esta ´ultima
acepci ´on, preferimos la traduc-
ci ´on de circuito corto como un
neologismo que indica este com-
portamiento de las condiciones
booleanas.
se conoce como de circuito corto si detiene su an ´alisis de condiciones ni bien
puede otorgar una respuesta, independientemente de que haya verificado todas
las condiciones. Esto sucede cuando la conjunci ´on determina que su primera
condici ´on es falsa (porque sin importar el valor de la otra condici ´on, la conjun-
ci ´on ser ´a falsa), y cuando la disyunci ´on determina que su primera condici ´on es
verdadera (porque sin importar el otro valor, la disyunci ´on ser ´a verdadera).
Mediante la caracter´ıstica de circuito corto de la conjunci ´on, el ejemplo ante-
rior podr´ıa haber escrito como
procedure CodificarSiHayEnemigoAlMejor(dir}
/*
PROP´OSITO: coloca una bolita roja o verde en la celda actual,
si hay una celda ocupada por enemigos en la
direcci´on dada
*/
{
if (puedeMover(dir)
&& not esCeldaVaciaAl(dir))
-- Es seguro preguntar, porque puede moverse ya
-- que el circuito corto de la conjunci´on garantiza
-- que no llega aqu´ı a menos que pueda hacerlo
{ Poner(Rojo) } -- Hay celda y hay enemigos
else
{ Poner(Verde) } -- No hay celda, o hay celda pero no enemigos
}
Observar como la condici ´on es una sola hecha de una conjunci ´on, y funciona
a pesar de que la segunda parte de la misma es una operaci ´on parcial, puesto
que si la primera parte es falsa, la segunda no se ejecutar ´a (la conjunci ´on de-
volver ´a falso sin mirar la segunda parte). Esta forma es mucho m ´as adecuada
para programar denotacionalmente, lo cual puede comprobarse en el siguiente
ejercicio, que busca abstraer la condici ´on anterior.
Actividad de Programaci ´on 3
Realice el ejercicio 4.1.3 y util´ıcelo para escribir una versi ´on a ´un m ´as
adecuada del procedimiento CodificarSiHayEnemigoAl (adecuada en
el sentido que es m ´as clara y m ´as legible, nombrando mejor sus partes).
Ejercicio 4.1.3. Escribir una funci ´on hayCeldaVaciaAl que retorne verdadero si
hay una celda en la direcci ´on dada y la misma est ´a vac´ıa, y falso en caso contra-
rio. ¿La operaci ´on ser ´a parcial o total?
Ayuda: utilice la capacidad de circuito corto de la conjunci ´on.
El uso de la caracter´ıstica de circuito corto de las operaciones booleanas es
siempre preferible a la anidaci ´on de condiciones, en aquellos casos donde resulta
equivalente su utilizaci ´on.
4.1.2. Alternativa indexada
En el ´ultimo ejemplo de la subsecci ´on anterior vimos la posibilidad de decidir
entre varias acciones con base en el valor de un c ´odigo. Esta forma de decisi ´on
se puede representar, tal cual se vio en dicho ejemplo, mediante condicionales
anidados. Sin embargo, en muchos lenguajes existe otra forma de representar
este tipo de decisiones: la alternativa indexada.
En esta forma de alternativa, se elige entre varios comandos con base en un
´ındice, que indica de alguna forma cu ´al de los comandos es el elegido. La sintaxis
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 136 of 312 --

137
en GOBSTONES para alternativas indexadas utiliza la palabra clave switch, y se
escribe de la siguiente manera:
switch (decodificarCelda()) to
1 -> { DibujarVentana() }
2 -> { RedimensionarVentana() }
3 -> { MaximizarVentana() }
4 -> { MinimizarVentana() }
_ -> { NoHacerNada() }
En este caso, la funci ´on decodificarCelda devolver ´a 1 si en la celda actual
hay bolitas verdes, 2 si hay bolitas azules pero no verdes, 3 si hay bolitas ne-
gras pero no azules ni verdes, 4 si hay solo bolitas rojas, y cualquier otro n ´ume-
ro (por ejemplo, 0) si no hay bolitas en la celda actual (para definir la funci ´on
decodificarCelda hace falta alguna forma de decidir mediante expresiones o
alguna forma de recordar valores, por lo que volveremos a ella despu ´es de pre-
sentar la idea de memoria.) Finalmente, el procedimiento NoHacerNada no tiene
ning ´un efecto.
En GOBSTONES existe un co-
mando predefinido que no hace
nada. Por razones hist ´oricas, el
mismo se denomina Skip. Tam-
bi ´en puede implementarse con
otros comandos, por ejemplo,
poniendo y sacando una bolita
de cierto color de la celda actual,
o con un bloque vac´ıo.
Definici ´on 4.1.1. El comando de alternativa indexada (tambi ´en conocido como
sentencia switch) tiene la siguiente forma:
switch (< indexExp >) to
< val1 > -> < bloque1 >
...
< valn > -> < bloquen >
-> < bloqueDefault >
siendo < indexExp > una expresi ´on que describe un valor de alguno de los ti-
pos b ´asicos, < val1 > a < valn >, una serie de valores de ese tipo, y < bloque1 >,
< bloquen > y < bloquedefult >, una serie de bloques de c ´odigo cualesquiera (que
normalmente son diferentes, aunque podr´ıan ser iguales). Al bloque < vari > se
lo denomina rama i- ´esima (o rama del valor < vali >), para cada i entre 1 y n, y
al bloque < bloqueDefault > se lo denomina rama por defecto (o rama default).
El efecto de un comando switch es el de elegir uno de los bloques, en base al
valor de la expresi ´on < indexExp >: si la expresi ´on vale alguno de los < vali >, en-
tonces se elige el bloque < bloquei >, y si su valor no es ninguno de los listados,
entonces se elige el bloque < bloqueDefault >.
Hay dos cuestiones que observar en un switch. La primera es que el orden
en el que se elige es secuencial, al igual que en un if; o sea, si el mismo valor
aparece m ´as de una vez, solo se utilizar ´a su primera aparici ´on. La segunda es
que la rama default siempre debe aparecer y captura todos los valores posibles
que no se encuentren entre los listados. Esto puede llevar al caso an ´omalo donde
esta rama nunca se elija, por no quedar valores disponibles.
Para ejemplificar esta situaci ´on, consideremos la necesidad de codificar una
direcci ´on en la celda actual, utilizando bolitas verdes. Un c ´odigo posible ser´ıa
procedure CodificarDireccion(dir)
{-