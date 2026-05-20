# PRECONDICI´ON:

* hay 3 celdas lindantes al Norte
-}
{
return(hayEnemigosAlEnRango(Norte,1) ||
hayEnemigosAlEnRango(Norte,2) ||
hayEnemigosAlEnRango(Norte,3)
}
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 125 of 312 --

126
Sin embargo, esta forma no ser´ıa parametrizable en cuanto a la distancia a me-
dir, quitando poder de generalidad a la soluci ´on propuesta y haci ´endolo menos
modificable a futuro. Por ejemplo, si modific ´asemos la definici ´on de “cerca” pa-
ra contemplar 10 celdas en lugar de 3, el resultado habr´ıa sido m ´as engorroso.
O si hubi ´eramos considerado agregar un par ´ametro num ´erico que estableciese
el rango en el que nuestros exploradores pueden detectar enemigos, no habr´ıa
sido posible expresar la funci ´on como una disyunci ´on compleja, puesto que no
sabr´ıamos de antemano cu ´antos llamados debemos realizar.
Actividad de Programaci ´on 24
Realice los ejercicios 3.3.5 y 3.3.6 y pru ´ebelos en alg ´un programa.
Ejercicio 3.3.5. Escribir una funci ´on hayEnemigosAlEnRango que, dado un par ´a-
metro d de tipo direcci ´on y uno n de tipo n ´umero indique si hay enemigos en la
celda distante exactamente n celdas en direcci ´on d a partir de la celda actual.
Utilizar la idea de la funci ´on hayEnemigosAl del ejercicio 3.3.3 pero utilizando el
procedimiento MoverN en lugar del comando Mover.
Ejercicio 3.3.6. Escribir una funci ´on hayEnemigosCercaNAlNorte que, dado un
par ´ametro n de tipo n ´umero indique si hay enemigos en alguna de las n celdas
contiguas al Norte. Utilizar la idea de procesar con una repetici ´on indexada y
bolitas para indicar el resultado.
El procesamiento que es posible realizar en las funciones con procesamiento se
ver ´a potenciado al incorporar formas de recordar valores. Esto se realizar ´a en el
siguiente cap´ıtulo.
3.4. Ejercitaci ´on
En esta secci ´on se enuncian una serie de ejercicios adicionales a los ya dados.
Al igual que en ejercitaciones previas, para su correcta resoluci ´on son necesarios
todos los elementos aprendidos en las secciones y cap´ıtulos anteriores.
Actividad de Programaci ´on 25
Realice los ejercicios enunciados en esta secci ´on. Nuevamente, le re-
cordamos que debe utilizar todas las buenas pr ´acticas que venimos es-
tudiando.
Ejercicio 3.4.1. Escribir una funci ´on nroBolitasNAl, que dados un color c, un
n ´umero n y una direcci ´on d, determine el n ´umero de bolitas de color c en la celda
distante exactamente n lugares en direcci ´on d a partir de la celda actual. Utilizar
como inspiraci ´on la funci ´on hayEnemigosAlEnRango del ejercicio 3.3.5.
El siguiente ejercicio se basa en una idea de Pablo Tobia. ¡Gracias Pablo!
Ejercicio 3.4.2. En este ejercicio utilizaremos el display de un ecualizador repre-
sentado en el tablero. El ecualizador tiene 2 canales (izquierdo y derecho) con 3
frecuencias cada uno (agudos, medios y graves). Cada frecuencia de cada canal
posee 4 leds verdes y 2 leds rojos. Para representar el display en el tablero se
utiliza una columna por cada frecuencia de cada canal (6 en total), a partir de la
columna m ´as al Oeste. Cada frecuencia se representa desde la celda base (la
m ´as al Sur), dejando dicha celda libre, y ubicando un led por celda hacia arriba.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 126 of 312 --

127
(a). Tablero inicial representando el display de un
ecualizador.
(b). Tablero final representando el ecualizador
con intensidades.
G.3.11. Tablero representando el display de un ecualizador (antes y despu ´es de
calcular las intensidades)
Los leds encendidos se representan mediante una bolita del color correspon-
diente en la celda, y los apagados con una celda vac´ıa. Se muestra un tablero
representando al display de un ecualizador en el gr ´afico G.3.11a.
Escribir un procedimiento CalcularIntensidades, que dado un tablero con-
teniendo la representaci ´on de un display de ecualizador cuente la intensidad de
cada frecuencia, registrando el resultado en la celda de la base de cada colum-
na con bolitas azules si la intensidad es menor o igual que 4, y negras si es
mayor. El resultado para el ecualizador dado como ejemplo se muestra en el
gr ´afico G.3.11b.
Para realizar el ejercicio anterior, se recomienda dividir en subtareas y utilizar
funciones y procedimientos seg ´un lo visto hasta el momento. Puede resultar ´util
contar con algunos de los nombres de los procedimientos y funciones en cues-
ti ´on: TotalizarFrecuenciaActual, ProcesarLedsVerdes, ProcesarLedsRojos,
NormalizarColorIntensidad y nroBolitasNAl. Tenga en cuenta que para to-
talizar todas las frecuencias puede usar una repetici ´on indexada, y para totalizar
la frecuencia actual puede utilizar la idea de hayEnemigosCercaAlNorte.
Los siguientes ejercicios se basan en una idea de Pablo Barenbaum. Utilizan su
idea y su enunciado para un juego inspirado en el ajedrez, que ´el denomin ´o Pro-
cedrez. Primero se describir ´a el juego, y luego se enunciar ´an los ejercicios que
ayudar ´an a ir resolviendo distintos aspectos del juego de manera incremental.
¡Gracias Pablo!
El Procedrez es un juego en el que intervienen dos jugadores, que mueven
piezas en un tablero de tama ˜no variable, dividido en escaques o casillas. Las
piezas pueden ser de tres clases diferentes: visir, torre y rey. Un jugador puede
tener varios visires y varias torres, pero solo un rey. Las piezas se mueven de la
siguiente manera, de manera similar a los movimientos que se pueden encontrar
en el ajedrez:
Los visires y el rey se mueven una casilla en cualquier direcci ´on, ortogonal
o diagonal.
Las torres se mueven en l´ınea recta cualquier n ´umero de casillas, pero solo
en direcci ´on ortogonal. Las torres no pueden “saltar” las propias piezas ni
las piezas enemigas.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 127 of 312 --

128
Adem ´as, si una pieza se mueve sobre una casilla ocupada por una pieza del opo-
nente, captura a dicha pieza, que se retira permanentemente del tablero, exacta-
mente como en ajedrez.
Tambi ´en como en el ajedrez, se dice que el rey de un jugador est ´a en jaque
si puede ser capturado por una pieza del oponente. El objetivo del juego es dar
jaque mate, que consiste en dar jaque al rey del oponente, de tal manera que le
resulte imposible evitar el jaque.
El tablero del juego se representar ´a con el tablero de GOBSTONES. Las piezas
del primer jugador se representar ´an con bolitas de color Rojo y las del segundo
con Negro; el n ´umero de bolitas depender ´a de la clase de pieza en cuesti ´on
(1 = visir, 2 = torre, 3 = rey). Las bolitas de color Verde y Azul se reservar ´an para
marcar posiciones del tablero.
Ejercicio 3.4.3. Implementar las siguientes funciones auxiliares que se usar ´an
en el resto de los ejercicios del Procedrez.
visir() que devuelve 1.
torre() que devuelve 2.
rey() que devuelve 3.
hayPieza() que devuelve True si hay una pieza en la casilla actual.
clasePieza() que devuelve la clase de la pieza en la casilla actual, asu-
miendo que hay una.
colorPieza() que devuelve el color de la pieza en la casilla actual, asu-
miendo que hay una.
marcadaComoDestino() que devuelve True si la casilla actual est ´a marcada
como destino (con una bolita Azul).
marcadaComoMovimiento() que devuelve True si la casilla actual est ´a mar-
cada como movimiento (con alguna bolita Verde).
Este ejercicio simplemente prepara algunas funciones que resultar ´an ´utiles en
el resto de los ejercicios. La idea de proponerlos es guiar en la forma de pen-
sar c ´omo abstraer la representaci ´on de piezas de manera de poder pensar en
t ´erminos del problema y no de la representaci ´on.
Ejercicio 3.4.4. Implementar el procedimiento MarcarMovimientosVisir que re-
cibe un color col y marca con una bolita de ese color cada uno de los potenciales
movimientos del visir o el rey ubicado en la casilla actual. La precondici ´on del pro-
cedimiento es que debe haber un visir o un rey en la casilla actual.
Deben marcarse las casillas ocupadas por piezas del oponente, ya que estos
son movimientos v ´alidos (capturas). No deben marcarse las casillas que est ´en
ocupadas por piezas del mismo color, ya que dos piezas no pueden ocupar la
misma casilla simult ´aneamente.
El cabezal debe quedar ubicado en la casilla en la que estaba originalmente.
Algunos ejemplos de posibilidades de este ejercicio se muestran en los gr ´afi-
cos G.3.12 y G.3.13.
Ejercicio 3.4.5. Suponiendo que ya est ´an definidos MarcarMovimientosVisir y
MarcarMovimientosTorre, procedimientos que marquen los movimientos de las
piezas de manera similar a lo realizado en el ejercicio anterior, implementar el
procedimiento MarcarMovimientosPieza que recibe un color col y marca con
una bolita de ese color cada uno de los potenciales movimientos de la pieza
ubicada en la casilla actual (cualquiera sea esta pieza).
La precondici ´on es que debe haber una pieza en la casilla actual.
Continuaremos con operaciones del Procedrez en el pr ´oximo cap´ıtulo, luego de
aprender algunas herramientas avanzadas nuevas.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 128 of 312 --

129
G.3.12. Los visires y el rey pueden moverse libremente
G.3.13. El rey negro puede capturar a la torre roja pero no puede pasar sobre su
propia torre
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 129 of 312 --

130
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 130 of 312 --

131
Alternativa, repetici ´	on y memoria
En este cap´ıtulo vamos a profundizar las herramientas de alternativa y repetici ´on
que vimos en el cap´ıtulo anterior, mostrando otras formas posibles, y discutiendo
las consecuencias de poseerlas. Adem ´as presentaremos la noci ´on de memoria,
como una forma de recordar valores a lo largo de la ejecuci ´on de un programa.
Si bien la memoria no es imprescindible para solucionar problemas (con pa-
rametrizaci ´on se pueden lograr los mismos efectos), es una herramienta que
permite expresar muchos problemas de forma m ´as concisa, y es ampliamen-
te utilizada en la mayor´ıa de los lenguajes de programaci ´on. Sin embargo, su
correcta utilizaci ´on conlleva un n ´umero importante de dificultades que la hacen
extremadamente compleja de manejar. Puesto que este libro se propone brindar
un panorama sobre la programaci ´on de manera introductoria, no abundaremos
ni en los problemas que puede ocasionar su uso, ni en la multitud de soluciones
propuestas y sus consecuencias. Se discute un poco m ´as sobre esta cuesti ´on en
el cap´ıtulo 6.
Adem ´as de las herramientas b ´asicas (como alternativa, repetici ´on o memo-
ria), presentaremos una herramienta abstracta para organizar programas que uti-
lizan repeticiones: la noci ´on de recorrido de una secuencia. Cerramos el cap´ıtulo
con ejercicios completos que utilizan todas las herramientas vistas.
4.1. M ´as sobre alternativas
Como dijimos, una alternativa es una forma de decidir entre otros dos elemen-
tos para saber cu ´al de ellos debe ejecutarse, o dicho de otra forma, una manera
de describir algo que puede ser diferente dependiendo de ciertas condiciones.
Tambi ´en vimos la forma m ´as com ´un de alternativas, el comando de alternativa
Puede haber alternativa tam-
bi ´en para expresiones, aunque
en GOBSTONES no aparece, por
simplicidad.
condicional, com ´unmente conocida en la jerga de programaci ´on como condicio-
nal o simplemente sentencia if-then-else, que es la manera de decidir entre
dos comandos para describir una acci ´on que puede ser diferente seg ´un la condi-
ci ´on indicada por una condici ´on.
En esta secci ´on vamos a profundizar sobre algunas combinaciones de alter-
nativas condicionales, y veremos una nueva forma de alternativa, la alternativa
indexada, tambi ´en conocida como sentencia case o sentencia switch.
Sentencia es sin ´onimo de co-
mando en este caso. Es una de-
nominaci ´on com ´un, que corres-
ponde con el t ´ermino ingl ´es sen-
tence (oraci ´on).
4.1.1. M ´as sobre alternativa condicional
Existen varias cuestiones acerca de la forma de usar alternativa condicional que
merecen atenci ´on. Es extremadamente com ´un incurrir en abusos operaciona-
les de la alternativa condicional. Debido a que en este libro propiciamos una
visi ´on denotacional, abstracta, de los programas, discutiremos estos casos que
usualmente son ignorados en otros textos (o considerados como perfectamente
adecuados).
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 131 of 312 --

132
Veremos tres formas de abuso de la alternativa condicional: su utilizaci ´on para
evitar la parcialidad de funciones en forma excesiva, su utilizaci ´on anidada y su
utilizaci ´on en presencia de condiciones parciales.
Alternativas y parcialidad
Cuando presentamos la alternativa condicional, vimos que la misma nos per-
mit´ıa elegir alternativamente entre dos cursos de acci ´on en base a una condici ´on
(de ah´ı el nombre de alternativa condicional). Tambi ´en vimos que una variante ´util
de este comando era utilizar solamente la rama del then (la alternativa verdade-
ra), descartando la rama del else (la alternativa falsa), y que esto pod´ıa utilizarse
para evitar la parcialidad de algunas operaciones. Sin embargo, no mencionamos
nada sobre la conveniencia o no de utilizar la alternativa de esta manera.
Leer con Atenci ´on
La forma de evitar la parcialidad de ciertas operaciones mediante el uso
de alternativas condicionales debe usarse con cuidado. Hay ocasiones
donde es mejor utilizar la operaci ´on directamente, y asumir el requisito
de que la precondici ´on debe cumplirse traslad ´andolo al procedimiento
que se est ´a definiendo (por ejemplo, cuando la condici ´on es demasiado
compleja, o no queremos realizar la verificaci ´on).
Por ejemplo, si consideramos la operaci ´on MoverN(n,dir) del ejercicio 3.1.3,