# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 23)

## Contenido
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
el t ´ermino en ingl ´es tien
