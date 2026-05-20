# PRECONDICIONES:

* el tablero debe tener 3 filas y 3 columnas y la celda actual
debe ser el origen
Claramente sirve tambi ´en para el procedimiento DibujarCuadradoNegroDeLado3,
pues en ese tablero podr ´a dibujar sin problemas; pero en general este tipo de
precondiciones son consideradas demasiado restrictivas, pues no dice que hay
much´ısimos otros tableros donde el procedimiento tambi ´en funcionar ´a. Entonces,
si us ´asemos esta ´ultima precondici ´on en lugar de la que vimos, un programador
al verla pensar´ıa que solo puede limitar el uso del procedimiento a tableros de
ese tama ˜no, y no la usar´ıa para otros casos donde podr´ıa serle ´util.
Leer con Atenci ´on
En general es extremadamente importante escribir bien el prop ´osito y la
precondici ´on de manera que indiquen claramente el objetivo y los reque-
rimientos de la manera m ´as precisa posible, ya que es la forma en que
un programador se entera de las caracter´ısticas importantes del proce-
dimiento. O sea, si el contrato est ´a bien expresado, el programador que
precisa usarlo normalmente no lee el c ´odigo del mismo, ya sea por no
estar disponible o por no ser relevante para su soluci ´on.
Establecer el prop ´osito tiene adem ´as una segunda ventaja: cuando definimos un
procedimiento debemos pensar para qu ´e lo estamos definiendo, o sea, qu ´e tarea
esperamos que el procedimiento resuelva. De esa forma evitamos definir proce-
dimientos que no tienen sentido desde el punto de vista de nuestra soluci ´on, y
podemos determinar si ciertas operaciones deben ser inclu´ıdas (o no) como par-
te del mismo. Volveremos a este punto cuando veamos ejemplos m ´as complejos.
Por todas estas razones, en el resto del curso insistiremos con establecer
siempre el prop ´osito y las precondiciones de un procedimiento. La forma en que
se redactan ambos es tambi ´en una cuesti ´on de estilo. Al igual que las restantes
cuestiones de estilo, se puede dominar perfectamente con suficiente pr ´actica.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 79 of 312 --

80
2.4. Ejercitaci ´on
En este apartado se enuncian una serie de ejercicios de pr ´actica adicionales
a los ya dados durante el cap´ıtulo. Para su correcta resoluci ´on son necesarios
todos los elementos aprendidos en las secciones anteriores. A trav ´es de su re-
Es importante que al resolver-
los se utilicen solamente los
conceptos ya vistos. Las perso-
nas que ya conocen otros len-
guajes tendr ´an la tentaci ´on de
utilizar herramientas m ´as avan-
zadas para pensar la soluci ´on;
sin embargo, los ejercicios fue-
ron pensados para ser resueltos
con las herramientas provistas.
En algunos casos puede resultar
m ´as complejo de la cuenta, ¡pe-
ro esa complejidad es buscada
con fines did ´acticos!
soluci ´on iremos repasando algunos de los conceptos principales, e incorporando
preguntas que preparar ´an el material de cap´ıtulos posteriores.
Actividad de Programaci ´on 16
Realice los ejercicios enunciados en esta secci ´on. Recuerde separar
adecuadamente su c ´odigo en procedimientos, elegir convenientemen-
te los nombres de los mismos, y comentar su c ´odigo de manera que el
mismo sea f ´acilmente entendible.
El primer ejercicio es simplemente una gu´ıa para recordar c ´omo definir un pro-
cedimiento, para experimentar c ´omo probarlo en un programa, y para preparar
ideas que luego se utilizar ´an en ejercicios posteriores.
Ejercicio 2.4.1.
Escribir un procedimiento PonerUnaDeCadaColor, que coloque una bolita de cada
color en la celda actual. ¿Cu ´al es su precondici ´on?
Leer con Atenci ´on
Recuerde que para probar su procedimiento debe escribir un programa
principal que lo utilice.
El siguiente ejercicio permite volver a repasar la idea de reutilizaci ´on de proce-
dimientos ya definidos. Toda vez que una tarea de programaci ´on aparece una
y otra vez, hay un candidato para introducir un procedimiento que resuelva esa
tarea. En muchos casos en este libro, los procedimientos a utilizar en una solu-
ci ´on se presentan antes en otros ejercicios previos, orientando de esta manera
la soluci ´on deseada.
Ejercicio 2.4.2.
Escribir el procedimiento Poner5DeCadaColor que coloque cinco bolitas de cada
color en la celda actual. Reutilizar el procedimiento definido en el ejercicio 2.4.1
( PonerUnaDeCada) para definir esta tarea.
Para Reflexionar
¿Cu ´anto m ´as dif´ıcil habr´ıa sido el ejercicio 2.4.2 si no hubiera conta-
do con el ejercicio 2.4.1? Piense en la necesidad de identificar estas
subtareas, y definir sus propios procedimientos para expresarlas, espe-
cialmente cuando no se hayan definido en ejercicios previos.
Si bien en el ejercicio 2.4.2 se pidi ´o expresamente la reutilizaci ´on del ejerci-
cio 2.4.1, esto no es lo usal. Normalmente la determinaci ´on de qu ´e otros pro-
cedimientos pueden servir para expresar la soluci ´on a un problema (o sea, en
qu ´e subtareas es interesante o relevante dividir ese problema) se deja librado a
la imaginaci ´on y la habilidad del programador.
Y en el caso de este libro, tam-
bi ´en la perspicacia, puesto que
ya hemos anunciado la intenci ´on
de presentar, en ejercicios pre-
vios a uno m ´as dif´ıcil, algunos
procedimientosque pueden ser
´utiles para solucionar el ejercicio
complejo. . .
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 80 of 312 --

81
Leer con Atenci ´on
Recuerde que una vez que defini ´o la forma de realizar una tarea, siempre
puede reutilizar dicha definici ´on en ejercicios posteriores. Al probar su
programa no olvide incluir todas las definiciones necesarias en el mismo.
En los pr ´oximos dos ejercicios se repasa la idea de precondici ´on, y de nombrar
adecuadamente, y se trabaja con las ideas de definici ´on de nomenclatura y de
minimizaci ´on de efectos de un procedimiento. La definici ´on de nomenclatura es
necesaria para poder hablar de un problema en los t ´erminos del dominio del mis-
mo, y no en t ´erminos de bolitas, y es algo usual en los ejercicios m ´as complejos.
La minimizaci ´on de efectos de un procedimiento tiene que ver con el hecho de
que el mismo haga lo pedido y nada m ´as que lo pedido.
Ejercicio 2.4.3.
La celda lindante en direcci ´on < dir > es la primera celda en la direcci ´on dada,
a partir de la celda actual. Por ejemplo la celda lindante al Norte es la primera
celda al Norte de la celda actual.
Escribir el procedimiento PonerAzulAlNorteYMoverse que ponga una bolita
de color azul en la celda lindante al Norte y se quede en esa posici ´on. ¿Este pro-
cedimiento siempre funciona? ¿Qu ´e requerimientos debe cumplir? ¿Cu ´al ser´ıa
su precondici ´on?
Ejercicio 2.4.4.
Escribir el procedimiento PonerAzulAlNorte que ponga una bolita de color azul
en la celda lindante al Norte pero deje el cabezal en la posici ´on original. ¿Cu ´al
es su precondici ´on?
Para Reflexionar
¿Por qu ´e puede ser importante devolver el cabezal a su posici ´on
original? Reflexione sobre este hecho antes de continuar. Reflexio-
ne tambi ´en sobre las diferencias en el nombre de los procedimien-
tos de los ejercicios 2.4.3 y 2.4.4. ¿Por qu ´e no llamamos al segundo
PonerAzulAlNorteYQuedarseEnElLugar? Recuerde la minimizaci ´on de
efectos.
Ejercicio 2.4.5.
Escribir el procedimiento PonerAzulEnLos4Vientos que ponga una bolita de co-
lor azul en la celda lindante al Norte, Sur, Este y Oeste y deje el cabezal en la
posici ´on original. ¿Cu ´al es la precondici ´on del procedimiento?
Para Reflexionar
¿C ´omo habr´ıa sido la soluci ´on del ejercicio 2.4.5 si en lugar de usar
la soluci ´on del ejercicio 2.4.4, hubiera utilizado la del ejercicio 2.4.3?
Reflexione acerca de c ´omo algunas decisiones sobre qu ´e tareas agrupar
en cada procedimiento pueden afectar la complejidad de la soluci ´on final.
En el siguiente ejercicio trabajamos con la idea de dominio de un problema, re-
pasando la idea de definici ´on de nomenclatura. En este caso, si estamos cons-
truyendo un programa de pintura, tiene sentido hablar de t ´emperas de colores y
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 81 of 312 --

82
no de bolitas, y representar y nombrar las ideas de manera adecuada al proble-
ma y no al lenguaje de programaci ´on. Tambi ´en se repasa la idea de que usted
identifique sus propias subtareas, definiendo procedimientos para ellas.
Leer con Atenci ´on
Al realizar el ejercicio, recuerde definir procedimientos auxiliares (como
PonerUnaDeCadaColor en el caso de Poner5DeCadaColor), con los cua-
les definir sus procedimientos le resulte sencillo. Para ello, intente iden-
tificar subtareas y nombrarlas adecuadamente.
Ejercicio 2.4.6. Supongamos que representamos a 1 gota de t ´empera con 3 bo-
litas de un color determinado. Escribir el procedimiento Mezclar2GotasDeAmarillo
que agregue en la celda actual 1 gota de t ´empera azul y 1 gota de t ´empera verde.
Para Reflexionar
¿Qu ´e tan adecuado es el nombre Mezclar2GotasDeAmarillo? ¿C ´omo
denomin ´o a sus procedimientos auxiliares? Nombres adecuados
habr´ıan sido Poner1GotaDeAzul y Poner1GotaDeVerde. ¿No ser´ıa me-
jor nombrar de otra forma al procedimiento Mezclar2GotasDeAmarillo?
Pista: ¿cu ´al es el verbo que utiliza en cada caso?
El siguiente ejercicio insiste sobre la idea de reuso de procedimientos, y trabaja
sobre la adecuaci ´on de nombrar a los procedimientos de determinada manera.
Ejercicio 2.4.7.
Escribir el procedimiento Poner3GotasDeNaranja que agregue en la celda actual
2 gotas de t ´empera amarilla y 1 gota de t ´empera roja. Para resolver este ejercicio,
debe cambiarse el nombre del procedimiento del ejercicio 2.4.6 convenientemen-
te para lograr uniformidad y adecuaci ´on en los nombres.
El uso uniforme de nombres est ´a relacionado con la comprensi ´on del problema
a resolver, y su adecuada expresi ´on en t ´erminos de los elementos del lenguaje
de programaci ´on. Representar bien las ideas b ´asicas del problema en t ´erminos
de procedimientos hace que luego la soluci ´on resulte sencilla de entender y mo-
dificar. Por ejemplo, si uno quisiera cambiar la representaci ´on, solo tendr´ıa que
cambiar los procedimientos m ´as elementales.
Ejercicio 2.4.8.
Modificar el procedimiento Poner3GotasDeNaranja para que la representaci ´on de
1 gota de t ´empera de color sea realizada con 5 bolitas en lugar de 3. ¿Qu ´e proce-
dimientos fue necesario modificar? ¿Debi ´o alterarse el c ´odigo del procedimiento
Poner3GotasDeNaranja, o bast ´o con modificar los procedimientos elementales?
Para Reflexionar
Cuando las subtareas fueron identificadas adecuadamente y expresa-
das correctamente en t ´erminos de procedimientos, modificaciones en la
representaci ´on no deber´ıan afectar la soluci ´on en su nivel m ´as cercano
al problema. Si en lugar de 3 o 5 bolitas para representar una gota, hu-
bi ´eramos elegido 1, ¿habr´ıa seleccionado un procedimiento para repre-
sentar la idea de poner una gota? Si su respuesta es no, reflexione sobre
lo sencillo que es caer en el pensamiento operacional, que se concentra
en las operaciones individuales en lugar de en las tareas a resolver, y en
las terribles consecuencias de esto en la calidad del c ´odigo producido.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 82 of 312 --

83
Los pr ´oximos ejercicios repasan las siguientes ideas:
la correcta identificaci ´on de subtareas reduce significativamente la com-
plejidad del c ´odigo resultante y facilita su modificaci ´on ante cambios en la
representaci ´on;
el adecuado uso de nombres de procedimientos mejora la legibilidad y fa-
cilita la comprensi ´on de dicho c ´odigo; y
la minimizaci ´on de los efectos de un procedimiento permite que su combi-
naci ´on con otros sea m ´as sencilla.
Ejercicio 2.4.9.
Completar los procedimientos necesarios para que el procedimiento LetraERoja
pinte una letra E con acuarela roja, suponiendo que en cada celda se coloca
una gota de acuarela, y que una gota de acuarela se representa con 1 bolita. La
letra E se puede pintar en un grupo de 5 por 3 celdas, como se muestra en el
gr ´afico G.2.12a y un posible c ´odigo para el procedimiento LetraERoja ser´ıa
procedure LetraERoja()
{- PROPOSITO: pinta una letra E roja en el tablero
PRECONDICION: Hay 4 celdas al Norte y
2 al Este de la celda actual
OBSERVACION: No modifica la posicion del cabezal
-}
{
PintarLineaHorizontal3() -- La base de la E
Mover(Norte)
PintarCelda() -- Nivel 2 de la E
Mover(Norte)
PintarLineaHorizontal3() -- La barra de la E
Mover(Norte)
PintarCelda() -- Nivel 4 de la E
Mover(Norte)
PintarLineaHorizontal3() -- El tope de la E
-- Retorna el cabezal
Mover(Sur);Mover(Sur);Mover(Sur);Mover(Sur)
}
Para Reflexionar
Observe con detenimiento los procedimientos que utilizamos en el pro-
cedimiento LetraERoja, y c ´omo los mismos fueron comentados. Al iden-
tificar correctamente las partes se requieren pocos procedimientos, y el
c ´odigo resultante queda estructurado con base en el problema, y no en
las celdas en las que se dibuja. Reflexione sobre c ´omo habr´ıa sido el
c ´odigo si en lugar de definir y usar PintarLineaHorizontal3, hubiera
usado solo PintarCelda y Mover. ¿Y si PintarLineaHorizontal3 hicie-
se m ´as de lo m´ınimo necesario?
Ejercicio 2.4.10.
Escribir un procedimiento LetraE, que pinte una letra E con acuarela marr ´on,
suponiendo que la acuarela marr ´on se consigue mezclando una gota de cada
uno de los 4 colores. La letra E deber´ıa quedar como se muestra en el gr ´afi-
co G.2.12b. Ayuda: Modificar adecuadamente el ejercicio anterior. ¿Puede ha-
cerse con solo 2 cambios y a lo sumo 4 procedimientos nuevos? Uno de los cam-
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 83 of 312 --

84
(a). Letra E roja (b). Letra E “marr ´on”
G.2.12. Representaci ´on de distintas letras E en el tablero de GOBSTONES
G.2.13. Representaci ´on de dos letras E en el tablero de GOBSTONES
bios es modificar el nombre del procedimiento LetraERoja por LetraE. ¿Cu ´al
deber´ıa ser el otro? ¿Qu ´e procedimientos nuevos definir para la representaci ´on?
El siguiente ejercicio motiva la necesidad de alguna herramienta del lenguaje
que permita separar de alguna manera, por un lado el dibujo de una letra, y por
el otro la elecci ´on sobre el color con la que se la dibuja. Esta herramienta se
ver ´a en unidades posteriores.
Ejercicio 2.4.11.
Escribir un procedimento LetrasERojaYNegra que dibuje una letra E roja seguida
de una letra E negra. El dibujo deber´ıa quedar como en el gr ´afico G.2.13.
Sugerencia: utilizar como base para la soluci ´on de este ejercicio, el c ´odigo
dado en el ejercicio 2.12a, duplic ´andolo y cambiando lo necesario en la versi ´on
duplicada para tener una letra E negra adem ´as de la roja.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 84 of 312 --

85
G.2.14. Dibujo de un tri ´angulo de base 7
Para Reflexionar
Con los elementos presentados en esta Unidad, la ´unica alternativa para
resolver el ejercicio 2.4.11 es duplicar el c ´odigo y cambiar el color con el
que se dibuja. Eso obliga a duplicar todos los procedimientos auxiliares,
y buscar nuevos nombres para cada uno. ¿Se da cuenta como es im-
prescindible, para poder hacer un programa razonable, contar con alg ´un
elemento que permita evitar esta duplicaci ´on?
Ejercicio 2.4.12.
Escribir un procedimiento DibujarTrianguloBase7 que dibuje un tri ´angulo verde
que tenga una base de 7 celdas. No utilizar m ´as de 3 comandos en el cuerpo del
procedimiento definido. El dibujo debe quedar como en el gr ´afico G.2.14.
Ayuda: para lograrlo hay que pensar en 3 subtareas que consigan dibujar las 3
partes de un tri ´angulo. . . ¡No olvidar escribir las precondiciones de cada uno de
los procedimientos as´ı obtenidos!
Para Reflexionar
En este caso, no era conveniente que las subtareas dejasen inalterada la
posici ´on del cabezal, puesto que al dibujar, estamos simulando un l ´apiz.
Hemos intentado expresar esta sutileza utilizando el t ´ermino “Dibujar” en
lugar de “Poner”. Esto es conveniento expresarlo en las observaciones
del procedimiento, como comentario.
Leer con Atenci ´on
Si calcul ´o bien las precondiciones de los procedimientos auxiliares y del
que dibuja el tri ´angulo, podr ´a observar que no todos los requisitos de los
auxiliares aparecen en el procedimiento general. Por ejemplo, dibujar la
l´ınea izquierda requiere espacio al Este, pero puesto que los dibujos
anteriores se movieron hacia el Oeste, ese lugar existe seguro. Las pre-
condiciones son una herramienta poderosa, pero en los casos complejos
puede ser dif´ıcil calcularlas con exactitud. Por esa raz ´on en este curso
las usamos solo como gu´ıa y de manera relativamente informal.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 85 of 312 --

86
El siguiente ejercicio motiva la necesidad de alguna herramienta del lenguaje
que permita separar el dibujo de una figura del tama ˜no de la misma. Esta es una
nueva manifestaci ´on de la repetici ´on que vimos en relaci ´on a los colores de la
letra E, salvo que en este caso se trata del tama ˜no en lugar del color.
Ejercicio 2.4.13.
Escribir un procedimiento DibujarArbol, que dibuje un ´arbol de tipo con´ıfera,
como se muestra en el gr ´afico G.2.15.
Ayuda: basarse en el procedimiento del ejercicio 2.4.12. Copiarlo 3 veces y mo-
dificar cada copia para obtener tri ´angulos de distintos tama ˜nos. Luego dibujar
cada pieza, posicion ´andose adecuadamente para comenzar cada una.
Para Reflexionar
Nuevamente, con los elementos presentados en esta Unidad, la ´unica al-
ternativa para resolver el ejercicio 2.4.13 es duplicar el c ´odigo y cambiar
el tama ˜no del dibujo. Todos los procedimientos auxiliares deben duplicar-
se, y buscar nombres adecuados para cada uno de ellos. ¿Se da cuenta
c ´omo es imprescindible, para poder hacer un programa razonable, con-
tar con alg ´un elemento que permita evitar esta duplicaci ´on?
El siguiente ejercicio busca practicar los conceptos adquiridos.
Ejercicio 2.4.14.
Supongamos que cada celda del tablero representa una secci ´on de un 1 metro
de longitud de un cantero. Adem ´as, representaremos flores con combinaciones
de bolitas. Las rosas se representan con 1 bolita de color rojo, las violetas se
representan con 1 bolita de color azul, y los girasoles se representan con 1 bolita
de color negro. Se desea armar un cantero de flores de 3 metros de longitud,
donde cada metro del cantero posee 5 rosas, 8 violetas y 3 girasoles.
Escribir el procedimiento ArmarCantero que cumpla con esta representaci ´on.
Para Reflexionar
¿Us ´o procedimientos auxiliares? ¿Comprende la manera important´ısima
en la que los mismos permiten simplificar la comprensi ´on del programa
y su an ´alisis de correcci ´on? Si no lo hizo, observe la complejidad del
c ´odigo que resulta, y repita el ejercicio usando procedimientos auxiliares.
Ejercicio 2.4.15.
Modificar el programa del ejercicio 2.4.14 para que ahora las flores se represen-
ten utilizando el siguiente esquema. Las rosas se representan con 3 bolitas de
color rojo y 1 de color negro, las violetas se representan con 2 bolitas de color
azul y 1 de color rojo, y los girasoles se representan con 3 bolitas de color negro
y 2 de color verde.
Para Reflexionar
¿Le result ´o f ´acil la modificaci ´on? Si no, revise los conceptos de separa-
ci ´on en procedimientos y de representaci ´on de informaci ´on.
El ´ultimo ejercicio busca combinar todos los elementos vistos hasta ahora. Por un
lado, usted debe decidir acerca de la representaci ´on de los elementos. Por otro,
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 86 of 312 --

87
G.2.15. Dibujo de un ´arbol de tipo con´ıfera
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 87 of 312 --

88
deber´ıa utilizar adecuadamente procedimientos para representar cada parte, no
solo la representaci ´on de los elementos, sino tambi ´en las acciones involucradas.
Finalmente, debe establecer las precondiciones necesarias, y al probarlo, ga-
rantizar que las mismas se cumplen de alguna manera. ¡No olvide comentar el
c ´odigo!
Ejercicio 2.4.16.
La Base Marambio, en la Ant ´artida, est ´a siendo invadida por extraterrestres de
color verde. La base es de color azul y est ´a totalmente rodeada por ellos en las 8
direcciones del radar. La misi ´on es escribir un programa GOBSTONES que mues-
tre c ´omo eliminar la amenaza alien´ıgena. Para ello hay que representar de alguna
manera la informaci ´on del radar en el tablero de GOBSTONES, y luego escribir el
procedimiento AcabarConAmenazaAlienigena que elimine a los invasores. ¿Cu ´al
ser´ıa la precondici ´on de este procedimiento?
Ayuda: ¿De qu ´e manera podr´ıa ser representado un alien´ıgena en el radar?
¿Y la base? Imaginar una representaci ´on para cada uno de estos objetos, inten-
tando ser fiel a la descripci ´on dada sobre ellos, y elegir la representaci ´on m´ınima
necesaria.
La manera de eliminar a los invasores estar ´a relacionada con la forma en la
que son representados – si, por ejemplo, un elemento se representa utilizando 2
bolitas de color negro, la forma de eliminarlos deber ´a ser quitar esa cantidad de
bolitas de ese color.
Para Reflexionar
¿Pudo probar el procedimiento anterior? ¿Qu ´e mecanismo eligi ´o para
garantizar la precondici ´on de AcabarConAmenazaAlienigena al invocarlo
desde el programa principal? Tenga en cuenta que en ocasiones utilizar
las ventajas que nos proveen las herramientas simplifica mucho el tra-
bajo. ¿Utiliz ´o la idea de precondici ´on para armar el tablero de ejemplo?
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 88 of 312 --

89
Procedimientos, funciones y
parametrizaci ´	on
En el cap´ıtulo anterior vimos los bloques b ´asicos de un lenguaje de programaci ´on
(expresiones, comandos y procedimientos simples, y las cuestiones de estilo); en
el presente cap´ıtulo procederemos a ver c ´omo hacer bloques m ´as generales, y
estudiaremos el concepto de parametrizaci ´on. En el proceso agregaremos algu-
nas formas b ´asicas de combinaci ´on de comandos y expresiones.
3.1. Procedimientos
Lo primero que aprendimos es c ´omo escribir procedimientos simples (defini-
ci ´on 2.2.21), y trabajamos con ellos, aprendiendo c ´omo utilizarlos adecuadamen-
te. Vimos que los procedimientos simples son una forma de nombrar comandos
compuestos para identificarlos como tareas de nuestro problema y as´ı definir un
nuevo comando especializado para una tarea. Y tambi ´en vimos que adem ´as de
los comandos, los lenguajes pose´ıan expresiones para describir valores, entida-
des para representar informaci ´on.
En este apartado vamos a agregar la idea de par ´ametro a los procedimientos,
y comenzaremos a estudiar su potencial.
3.1.1. Procedimientos con par ´ametros
Al resolver el ejercicio 2.4.11 donde se ped´ıa dibujar una E roja y una E negra, vi-
mos que se hac´ıa necesario, con los elementos que cont ´abamos en ese momen-
to, duplicar el procedimiento y cambiar solo el dato del color. Volvamos a repasar
el problema de la duplicaci ´on, pero utilizando el ejemplo inicial del cuadrado ne-
gro dado en la p ´agina 59 con el procedimiento DibujarCuadradoNegroDeLado3(),
cuyo resultado se mostr ´o en el gr ´afico G.2.10. Entonces, ahora supongamos que
queremos que en lugar de dibujar dos cuadrados negros, uno de ellos sea rojo y
el otro negro, como se muestra en el gr ´afico G.3.1. El c ´odigo para ello, suponien-
do solo las herramientas del cap´ıtulo anterior, ser´ıa algo como
program
{
VaciarTablero(); IrAlOrigen()
DibujarCuadradoNegroDeLado3()
IrAlBorde(Este); Mover(Oeste); Mover(Oeste)
DibujarCuadradoRojoDeLado3()
}
procedure DibujarCuadradoNegroDeLado3()
/*
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 89 of 312 --

90
G.3.1. Resultado de ejecutar el programa que dibuja dos cuadrados