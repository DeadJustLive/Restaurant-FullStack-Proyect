# PRECONDICI´ON:

* ninguna, es una operaci´on total
-}
{
-- va al tope para saber que las hace todas
IrAlExtremo(Norte)
while (puedeMover(Sur))
-- la condici´on dice "no lleg´o a la base"
{
if (hayFlor()) -- solo se agrega en las celdas
{ Fertilizar() } -- que cumplen la condici´on
Mover(Sur) -- pasar a la siguiente celda
}
-- realiza la acci´on en la ´ultima celda, pues no entr´o
-- al while si la celda no ten´ıa una al Sur
if (hayFlor())
{ Fertilizar() }
}
Podemos observar que la operaci ´on de procesar elemento actual, en este caso, es con-
dicional a que se cumpla la existencia de una flor en la celda. De esta manera, solo las
celdas con flores ser ´an fertilizadas. Esto podr´ıa abstraerse y considerar un procedimien-
to ProcesarCeldaDelCantero que implemente la acci ´on condicional de fertilizar, logrando
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 151 of 312 --

152
G.4.3. Sendero simple con forma aproximada de “52”
de esa manera una visi ´on uniforme del recorrido. Sin embargo, muchas veces elegimos
explicitar la condicionalidad de la forma mostrada.
Actividad de Programaci ´on 17
Pase el procedimiento anterior, complete sus subtareas, y pru ´ebelo en un pro-
grama con varios tableros diferentes.
Otra cuesti ´on interesante es que la secuencia de elementos no tiene por qu ´e aparecer
de manera lineal en la visualizaci ´on en el tablero. Por ejemplo, si tomamos un sendero
y lo seguimos, podemos considerar a las posiciones del sendero como los elementos a
procesar. Veamos c ´omo ser´ıa, definiendo bien la idea de sendero y haciendo un programa
que lo procese de alguna manera.
Un sendero simple se indica en el tablero mediante una serie de bolitas negras con-
tiguas una de las otras, de manera que cada bolita no tiene nunca m ´as de dos vecinas
(excepto la primera y la ´ultima). La primera celda del sendero se indica con 2 bolitas ne-
gras y es siempre la celda en la esquina suroeste, y la ´ultima con 3 bolitas negras y puede
ser cualquiera. Es importante remarcar que la celda inicial con 2 bolitas y la celda final
con 3 bolitas son las ´unicas de todo el tablero que tienen esta cantidad de bolitas ne-
gras. Adem ´as tambi ´en es importante remarcar que no todas las celdas del tablero que
tengan 1 bolita negra ser ´an parte del sendero. Podemos ver un ejemplo de sendero en
el gr ´afico G.4.3. Observar que cada celda interna del sendero tiene a lo sumo dos celdas
contiguas (en las cuatro direcciones cardinales) que contienen bolitas. De esta manera, si
comenzamos en la celda inicial del sendero, es sencillo saber cu ´al es la pr ´oxima celda a
visitar: la ´unica de las contiguas que tiene bolitas negras y en la que no estuvimos antes.
Tambi ´en vemos que en este tablero hay 3 celdas con bolitas negras que no pertenecen al
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 152 of 312 --

153
sendero.
Ahora supongamos que la intenci ´on es colocar una rosa (representada mediante una
bolita roja) en cada celda del sendero. As´ı, podemos realizar esta tarea definiendo las
siguientes operaciones, y luego armando un recorrido con ellas:
Operaci ´on gen ´erica Operaci ´on real
IniciarRecorrido() BuscarInicioSendero()
ProcesarElementoActual() ColocarRosa()
PasarAlSiguiente() MoverASiguienteSector()
FinalizarRecorrido() ColocarRosa()
VolverAlInicioDelSendero()
llegoAlUltimoElemento() esFinDelSendero()
La operaci ´on de ColocarRosa es trivial. La condici ´on de esFinDelSendero tambi ´en es sim-
ple, pues alcanza con mirar el n ´umero de bolitas negras de la celda actual. Las operacio-
nes dadas por los procedimientos BuscarInicioSendero y VolverAlInicioDelSendero
son, en esta forma simplificada de senderos, nada m ´as que IrALaEsquina(Sur,Oeste).
Entonces, la operaci ´on interesante esMoverASiguienteSector, que es una b ´usqueda por
las 4 celdas contiguas de aquella que tenga bolitas negras pero no tenga flores y luego
moverse all´ı. Se puede realizar con dos subtareas, de la siguiente manera
procedure MoverASiguienteSector()
{-