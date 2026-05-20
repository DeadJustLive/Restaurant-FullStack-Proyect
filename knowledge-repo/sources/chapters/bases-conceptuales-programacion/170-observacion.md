# OBSERVACI´ON:

* se estructura como un recorrido sobre los
n´umeros naturales mayores que 2 necesarios,
los cuales se recuerdan con la variable
cantAColocar
-}
{
-- Iniciar el recorrido
procesadas := 0 -- la cantidad de celdas ya tratadas
cantAColocar := 2 -- el inicio de la progresi´on
-- Mientras no se haya terminado el recorrido
while (procesadas < n)
{
-- Procesar el elemento actual
if (cantAColocar mod 2 == 0 -- m´ultiplo de 2
|| cantAColocar mod 3 == 0) -- o m´ultiplo de 3
{
PonerN(cantAColocar, Verde)
procesadas := procesadas + 1 -- se proces´o una celda
Mover(Este) -- por eso pasa a la sig.
}
-- Pasar al siguiente n´umero a considerar
cantAColocar := cantAColocar + 1 -- probar un nuevo nro.
}
-- Finalizar el recorrido, volviendo al punto de partida
MoverN(Oeste, n)
}
Puede observarse c ´omo la pregunta para terminar de procesar responde a la cantidad de
celdas procesadas (que en este caso debe ser el par ´ametro n), mientras que el pasar a
un nuevo elemento consiste en probar un nuevo n ´umero. El procesamiento de elementos
consiste en verificar si el n ´umero actual corresponde a una cantidad a poner, y en ese ca-
so, ponerlo en la celda correspondiente. Variando el tratamiento de estos dos par ´ametros
se pueden lograr diferentes combinaciones.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 170 of 312 --

171
Actividad de Programaci ´on 30
Realice el ejercicio 4.3.9, y verif´ıquelo en el sendero del gr ´afico G.4.3. En el gr ´afi-
co G.4.7 pueden verse un par de invocaciones del procedimiento, con par ´ame-
tros diferentes.
Ejercicio 4.3.9. Modificar el procedimiento PonerFloresEnSenderoSimple presentado en
la subsecci ´on 4.2.3, para que tome un par ´ametro distancia, y coloque flores en el sen-
dero separadas por la distancia dada.
Sugerencia: agregar una variable proximoSectorEn que cuente cu ´anto falta para el
pr ´oximo sector donde poner flores. Al procesar, si esta variables est ´a en 1, poner la flor y
volver a poner la variable en la distancia m ´axima, y si no, decrementar la variable.
Ayuda: una complicaci ´on que tiene este ejercicio es que el control de cu ´al era el
siguiente sector a mover asum´ıa que en el anterior ya se hab´ıa colocado una flor. Puesto
que en esta variante no se coloca una flor, debe marcarse un sector visitado (por ejemplo,
reemplazando las bolitas negras por bolitas verdes), para indicar que efectivamente ya fue
visitado. Al finalizar el recorrido habr´ıa que hacer una subtarea que vuelva a recorrer el
sendero cambiando bolitas verdes por negras.
Actividad de Programaci ´on 31
Realice el ejercicio 4.3.10, y pru ´ebelo con el sendero del gr ´afico G.4.3. El resul-
tado deber´ıa quedar como el gr ´afico G.4.8.
Ejercicio 4.3.10. Modificar el procedimiento PonerFloresEnSenderoSimple de la subsec-
ci ´on 4.2.3 para que “numere” los sectores, colocando tantas flores en un sector como la
distancia de ese sector al inicio del sendero. O sea, en el inicio debe colocar 1 flor, en el
primer sector, 2 flores, en el tercero, 3 flores, etc ´etera.
Actividad de Programaci ´on 32
Realice el ejercicio 4.3.11, y pru ´ebelo en varias de las frecuencias del ecualiza-
dor del gr ´afico G.3.11a.
Ejercicio 4.3.11. Escribir un procedimiento IncrementarFrecuenciaActual, que, tenien-
do en cuenta la representaci ´on del ejercicio 3.4.2, incremente en uno la frecuencia repre-
sentada en la columna actual. Puede suponerse que la celda actual se encuentra en la
base de la columna. Tener en cuenta que si la frecuencia est ´a al m ´aximo, no se incremen-
ta, y que al incrementar, debe respetarse el color de cada led.
Ayuda: estructurarlo como un recorrido sobre los 6 leds de la frecuencia, incremen-
tando una variable intensidad cada vez que se encuentra un led prendido. El finalizar
recorrido debe posicionarse sobre el led siguiente a la intensidad (si esta es menor que
6), y encenderlo (ya sea verde o rojo, seg ´un la posici ´on).
4.4. Ejercitaci ´on
Este apartado culmina la introducci ´on al lenguaje GOBSTONES, con algunos ejercicios
avanzados que utilizan todas las herramientas vistas hasta el momento.
Actividad de Programaci ´on 33
Realice los ejercicios de este apartado, y pru ´ebelos en cada caso, sobre los
tableros adecuados.
Continuando con el juego de Procedrez que se describi ´o en la secci ´on 3.4, completamos
los ejercicios que requer´ıan herramientas avanzadas.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 171 of 312 --

172
(a). Resultado de invocar PonerFloresEnSenderoSimpleCada(4)
(b). Resultado de invocar PonerFloresEnSenderoSimpleCada(5)
G.4.7. Sendero simple con flores colocadas cada algunos sectores
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 172 of 312 --

173
G.4.8. Sendero simple “numerado”
El procedimiento del ejercicio que se presenta a continuaci ´on sigue la idea del ejerci-
cio 3.4.4, y fue utilizado en el ejercicio 3.4.5.
Ejercicio 4.4.1. Implementar el procedimiento MarcarMovimientosTorre, que recibe un
color col, y marca con una bolita de ese color cada uno de los potenciales movimientos
de la torre ubicada en la casilla actual. La precondici ´on del procedimiento es que debe
haber una torre en la casilla actual.
Igual que en el caso del visir, deben marcarse las casillas ocupadas por piezas del
oponente, pero no las casillas ocupadas por piezas del mismo color. No se deben marcar
casillas “saltando” por sobre piezas propias ni del oponente.
El cabezal debe quedar ubicado en la casilla en la que estaba originalmente.
Se muestra un ejemplo para una torre negra en el gr ´afico G.4.9a.
Ejercicio 4.4.2. Implementar el procedimiento MarcarMovimientosJugador que recibe un
color denominado jugador, y marca con una bolita de color Verde cada uno de los po-
tenciales movimientos de ese jugador. La precondici ´on es que jugador debe ser Rojo o
Negro.
Por ejemplo, si el jugador tiene un rey y una torre, marca con bolitas de color Verde
todos los potenciales movimientos del rey, y todos los potenciales movimientos de la torre.
Una casilla puede quedar marcada con varias bolitas, si hay varias piezas que potencial-
mente puedan moverse all´ı.
En el gr ´afico G.4.9b se muestran todos los movimientos marcados del jugador negro, que
tiene un rey y dos torres. Observar que varias casillas reciben m ´as de una amenaza.
Ejercicio 4.4.3. Implementar la funci ´on esMovimientoPosible, que devuelve un booleano
que indica si la pieza ubicada en la casilla actual podr´ıa moverse a la casilla marcada como
destino, indicada con una bolita de color Azul.
La precondici ´on de la funci ´on es que debe haber una pieza en la casilla actual, que no
debe haber casillas del tablero marcadas con bolitas de color Verde y que exactamente
una casilla del tablero debe estar marcada como destino (en todo el tablero debe haber
exactamente una bolita Azul).
Sugerencia: pensar en c ´omo reutilizar los procedimientos definidos en los ejercicios
anteriores.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 173 of 312 --

174
(a). Movimientos de la torre.
(b). Movimientos del jugador negro.
G.4.9. Movimientos de piezas del Procedrez
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 174 of 312 --

175
Leer con Atenci ´on
De aqu´ı en m ´as asumiremos siempre que el tablero es un juego v ´alido de Pro-
cedrez, o sea, que siempre hay exactamente un rey de cada color en el tablero,
que puede haber a lo sumo una casilla marcada como destino (con una bolita
Azul) y que no puede haber casillas marcadas con bolitas de color Verde.
Ejercicio 4.4.4. Definir la funci ´on reyEnJaque que toma un par ´ametro jugadorDefensor
que indica el color del jugador defensor ( Rojo o Negro), y retorna si el rey del jugador
defensor est ´a en jaque. Es decir, devuelve True si alguna pieza del jugador oponente
podr´ıa moverse a la casilla donde se encuentra el rey del jugador defensor. Devuelve
Falseen caso contrario.
Ayuda: realizar un recorrido sobre las piezas del oponente, marcando al rey defensor
como destino.
Ejercicio 4.4.5. Definir el procedimiento MoverPieza que mueve la pieza ubicada en la
casilla actual a la casilla marcada como destino, sacando la bolita Azul del destino. Si en
dicha casilla hay una pieza del oponente, la captura.
La precondici ´on es que debe haber una pieza en la casilla actual, y exactamente
una casilla del tablero marcada como destino. Adem ´as, la casilla marcada como destino
debe ser un movimiento v ´alido para la pieza que se est ´a moviendo. Finalmente, la casilla
marcada como destino debe estar vac´ıa (sin piezas propias) o con una pieza del oponente.
En el gr ´afico G.4.10 se pueden ver dos momentos del movimiento de un visir negro.
Ejercicio 4.4.6. Definir la funci ´on puedeMoverPiezaAlDestino, que indica si la pieza ubi-
cada en la casilla actual puede moverse a la casilla marcada como destino sin que su
rey quede en jaque. O sea, devuelve True si la condici ´on se cumple, y False en caso
contrario.
La precondici ´on es que debe haber una pieza en la casilla actual. Adem ´as, debe haber
exactamente una casilla del tablero marcada como destino.
Ejercicio 4.4.7. Definir la funci ´on puedeMoverAlgunaPiezaAlDestino que toma un par ´a-
metro jugadorDefensor ( Rojo o Negro) y retorna si el jugador defensor dispone de alguna
pieza que pueda moverse al destino sin que su rey quede en jaque. En caso contrario,
devuelve False.
La precondici ´on es que debe haber exactamente una casilla del tablero marcada como
destino.
El ´ultimo tema para presentar ejercicios se basa en una idea de Pablo Barenbaum. Nue-
vamente agradecemos a Pablo por su generosidad.
La Piedra Rosetta es una losa del Antiguo Egipto que contiene inscripciones del mis-
mo texto en tres sistemas de escritura distintos: griego, egipcio dem ´otico y jerogl´ıficos
egipcios. En el siglo XIX, Jean-Franc¸ois Champollion se vali ´o de esta informaci ´on para
descifrar la escritura jerogl´ıfica. Para auxiliarnos en el an ´alisis de lenguas muertas, hare-
mos una versi ´on simplificada de este modelo.
El tablero de GOBSTONES se dividir ´a en dos mitades, separadas por una columna
marcada con bolitas negras en todas sus celdas. Las columnas de la mitad izquierda
representar ´an un texto de referencia. Las columnas de la mitad derecha representar ´an un
texto a descifrar. Notar que las mitades no necesariamente tienen el mismo ancho.
Dentro de cada mitad, las bolitas azules representar ´an s´ımbolos de un sistema de
escritura desconocido. Las bolitas rojas representar ´an s´ımbolos de un sistema de escritura
conocido. Por ejemplo, nueve bolitas azules podr´ıan representar un jerogl´ıfico con forma
de lechuza, y dos bolitas rojas la letra ”B”.
En cada posici ´on del texto de referencia habr ´a un s´ımbolo desconocido, que repre-
senta el texto original, y uno conocido, que representa su traducci ´on. En cambio, cada
posici ´on del texto a descifrar tendr ´a solamente un s´ımbolo desconocido, que es lo que se
quiere traducir.
Supondremos, de forma poco realista, que las traducciones se realizan s´ımbolo a
s´ımbolo, y que un s´ımbolo se traduce siempre de la misma manera. Asumiremos tambi ´en
que todos los s´ımbolos del texto a traducir ya figuran en el texto de referencia. En ambas
partes del texto puede haber espacios, que no se traducen ni afectan la traducci ´on.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 175 of 312 --

176
(a). El visir negro est ´a a punto de moverse a la casilla marcada como destino.
(b). El visir negro se ha movido, capturando a la torre roja y dando as´ı jaque
al rey rojo.
G.4.10. Visir negro movi ´endose
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 176 of 312 --

177
Ejercicio 4.4.8. Escribir el procedimiento DescifrarJeroglificos que complete la tra-
ducci ´on del texto a descifrar.
Este ejercicio puede realizarse de tres maneras diferentes, cada una con su propia com-
plejidad.