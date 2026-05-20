# Capítulo 16: para dibujar una caja con una pelota rebotando dentro. La pelota

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 54)

## Contenido
# Capítulo 16: para dibujar una caja con una pelota rebotando dentro. La pelota

se mueve a una velocidad constante y rebota en los lados de la caja cuando los
alcanza.
Reflejo precalculado
Una desventaja de las transformaciones es que ralentizan el dibujo de mapas
de bits. La posición y el tamaño de cada píxel deben ser transformados, y
aunque es posible que los navegadores se vuelvan más inteligentes sobre las
transformaciones en el futuro, actualmente causan un aumento medible en el
tiempo que lleva dibujar un mapa de bits.
En un juego como el nuestro, en el que solo estamos dibujando un sprite
transformado, esto no es un problema. Pero imagina que necesitamos dibujar
cientos de personajes o miles de partículas giratorias de una explosión.
Piensa en una forma de permitirnos dibujar un personaje invertido sin cargar
archivos de imagen adicionales y sin tener que hacer llamadas transformadas
de drawImage en cada cuadro.
307

-- 319 of 445 --

“Lo que a menudo resultaba difícil para las personas entender sobre
el diseño era que no había nada más allá de las URL, HTTP y
HTML. No había una computadora central “controlando” la Web, no
existía una sola red en la que funcionaran estos protocolos, ni
siquiera una organización en algún lugar que “dirigiera” la Web. La
Web no era una “cosa” física que existía en un cierto “lugar”. Era
un “espacio” en el que la información podía existir.”
—Tim Berners-Lee
