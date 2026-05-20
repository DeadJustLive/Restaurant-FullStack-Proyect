# 4. Árboles de juego: estrategia minimax

Muchos juegos de estrategia se pueden representar en forma de árboles. Cada nodo se corresponde con una
configuración posible del juego (por ejemplo, estado de un tablero) y cada arco es una transición legal, o jugada, desde
una configuración posible a una de sus sucesoras.
Supongamos, por simplificar, que consideramos juegos en los que:
• 	los dos jugadores juegan alternadamente,
• 	los dos jugadores están sometidos a las mismas reglas (juegos simétricos),
• 	el azar no interviene (juegos deterministas),
• 	una partida no puede durar indefinidamente, y
• 	ninguna configuración tiene un número infinito de posibles sucesoras.
La configuración inicial del juego es la raíz del árbol correspondiente. Las hojas del árbol corresponden a las
configuraciones terminales del juego, en las que no existe jugada siguiente, bien porque uno de los jugadores ha ganado
o bien porque no ha ganado ninguno (situación de empate).
Los niveles impares del árbol están asociados con las configuraciones en las que debe jugar uno de los dos jugadores,
mientras que los niveles pares se asocian a las configuraciones en las que debe jugar el otro.
A cada nodo del árbol se le asocia una etiqueta llamada función de utilidad. Por ejemplo, una función de utilidad
habitual toma tres valores posibles: “configuración ganadora”, “configuración perdedora” y “configuración empatadora o
nula”. La interpretación de la función de utilidad en cada configuración corresponde a la situación (o posibilidades) que
tiene el jugador (tomamos partido por uno de ellos) en esa configuración, suponiendo que ninguno de los dos jugadores se
equivocará y ambos realizarán en lo sucesivo la mejor jugada posible. La función de utilidad puede asignarse de forma
sistemática.
Veamos, como ejemplo, el juego del tic-tac-toe (una especie de tres en raya con más de tres fichas por jugador).
Llamaremos a los dos jugadores “él” y “yo”. Supondremos, por ejemplo, que empieza “yo”. El árbol tiene la forma
siguiente:

-- 218 of 267 --

205
yo
yo 	yo
él
él 	él
yo
yo 	yo
él
él 	él
yo
yo
yo 	yo
él
él 	él
yo 	yo
yo 	yo
él
él 	él	yo
yo
yo 	yo
él
él 	él
yo
él
yo
yo 	yo
él
él 	él
yo
él
yo
yo
yo 	yo
él
él 	él
yo
él
él yo
yo 	yo
él
él 	él	yo
yo
yo 	yo
él
él 	él	yo
él
yo
yo 	yo
él
él 	él	yo
él
yo 	él yo
yo 	yo
él
él 	él	yo
yo
•••
•
•
•
nivel 0
mueve “yo”
•
•
•
nivel 6
mueve “yo”
nivel 8
mueve “yo”
nivel 7
mueve “él”
•
•
•
GANA “yo”