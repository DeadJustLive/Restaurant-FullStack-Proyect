# EM PATE 	EM PATE

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 128)

## Contenido
# EM PATE 	EM PATE

GANA “él”
GANA “yo”
nivel 9
0
1
1 	-1 	0
0 	-1 	0 	1
0 	0 	1
Se ha anotado al lado derecho de cada nodo el valor correspondiente a la función de utilidad, representando con 1 la
configuración ganadora, con 0 la empatadora y con -1 la perdedora. Para calcular la utilidad, se da valor, en primer lugar, a
las hojas. La utilidad en una hoja vale 1, 0 ó -1 si la configuración del juego corresponde a una victoria, empate o derrota,
respectivamente, del jugador por el que hemos tomado partido (“yo”). Los valores de la función de utilidad se propagan
hacia arriba del árbol de acuerdo a la siguiente regla (estrategia minimax):
• 	si un nodo corresponde a una configuración del juego en la que juega “yo” (nivel 0 ó par), se supone que ese
jugador hará la mejor jugada de entre las posibles y, por tanto, el valor de la función de utilidad en la configuración
actual coincide con el valor de esa función en la configuración de la mejor jugada posible (para “yo”) que se puede
realizar desde la actual;
• 	si un nodo corresponde a una configuración del juego en la que juega “él” (nivel impar del árbol), se supone que
ese jugador hará la mejor jugada de entre las posibles y, por tanto, el valor de la función de utilidad en la
configuración actual coincide con el valor de esa función en la configuración de la peor jugada posible (para “yo”).
Si la raíz tuviera el valor 1, entonces “yo” tendría una estrategia que le permitiría ganar siempre. No es el caso del tic-
tac-toe. En este juego la función de utilidad de la raíz vale 0, lo cual significa que ningún jugador tiene una estrategia
ganadora, por lo que, si no se cometen errores, se puede garantizar al menos un empate. Si la raíz tuviera un valor -1, el
otro jugador (“él”) tendría una estrategia ganadora.
La función de utilidad puede tener un rango más amplio (por ejemplo, los números enteros). Piénsese en el juego del
ajedrez. El árbol del juego es tan grande (se ha estimado en más de 10100 nodos) que no se puede construir (si un computador
pudiera generar 10 11 nodos por segundo, necesitaría más de 1080 años) y dar valor a la función de utilidad de cada nodo de
abajo hacia arriba (como en el caso del tic-tac-toe). Un programa de juego de ajedrez sencillo trabaja de la siguiente forma.
Para cada configuración actual del juego, se toma dicha configuración como raíz del árbol. Se construyen varios niveles del
árbol (el número depende de la velocidad del computador o puede ser seleccionado por el usuario). La mayor parte de las
hojas del árbol construido son ambiguas (no indican triunfos, derrotas ni empates), por tanto, cada programa usa una función
de utilidad de las posiciones del tablero que intenta estimar la probabilidad de que el computador gane desde esa posición
(por ejemplo, la diferencia entre las piezas que quedan, el poder defensivo en el centro del tablero o alrededor de los reyes,

-- 219 of 267 --

206
etc.). Así, el computador puede estimar la probabilidad de un triunfo después de hacer cada uno de sus siguientes
movimientos posibles (en el supuesto de que el contrincante también hará su mejor jugada posible) y escoger el movimiento
de mayor utilidad.
Para poder diseñar un algoritmo para jugar a un determinado juego contra el computador es necesario conocer los
movimientos (o jugadas) válidos en el juego y las reglas de terminación.
Dada una configuración del juego en la que el computador deba jugar, basta con que el computador calcule la utilidad
de las configuraciones accesibles (tras su jugada) y elija la jugada que conduzca a una configuración con mayor utilidad.
Es necesario resolver, fundamentalmente, lo siguiente:
a) 	la representación de una configuración del juego (definición del tipo de dato configuración),
b) 	la enumeración de las configuraciones accesibles desde una dada mediante la ejecución de una jugada, y
c) 	el cálculo de la función de utilidad para una configuración dada, sabiendo quién juega en ese momento.
El algoritmo que tiene mayor interés es el que ejecuta la jugada que realiza el computador:
procedimiento juegaElComputador(e/s c:configuración)
{c es una configuración no final; el algoritmo realiza la mejor jugada posible a partir
de c, la comunica al usuario y actualiza la configuración c}
variables maxUtilidad,laUtilidad:entero;
i:1..maxEntero;
mejorJugada,unaJugada:configuración
principio
i:=1;
jugada(c,i,unaJugada); {calcula la 1ª configuración accesible desde c}
mejorJugada:=unaJugada;
maxUtilidad:=utilidad(mejorJugada,falso); {"falso" indica que cuando la configuración
sea "mejorJugada", no juego yo}
mientrasQue not esLaUltimaJugada(c,i) hacer
i:=i+1;
jugada(c,i,unaJugada);
laUtilidad:=utilidad(unaJugada,falso);
si laUtilidad > maxUtilidad entonces
mejorJugada:=unaJugada;
maxUtilidad:=laUtilidad
fsi
fmq;
comunicaAlUsuario(mejorJugada);
c:=mejorJugada
fin
El algoritmo principal, tras la inicialización de la configuración, contiene un bucle en el que mientras que la
configuración no sea final se alternan una llama
