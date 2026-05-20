# Chapter 16

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 44)

## Contenido
# Chapter 16

Proyecto: Un juego de plataformas
Gran parte de mi fascinación inicial con las computadoras, al igual que la de
muchos niños nerds, tenía que ver con los juegos de computadora. Me sentía
atraído por los diminutos mundos simulados que podía manipular y en los que
se desarrollaban historias (más o menos), supongo, debido a la forma en que
proyectaba mi imaginación en ellos más que por las posibilidades que realmente
ofrecían.
No le desearía a nadie una carrera en programación de juegos. Al igual que la
industria de la música, la discrepancia entre la cantidad de jóvenes entusiastas
que desean trabajar en ella y la demanda real de tales personas crea un entorno
bastante insalubre. Pero escribir juegos por diversión resulta entretenido.
Este capítulo guiará a través de la implementación de un pequeño juego de
plataformas. Los juegos de plataformas (o juegos de “saltos y carreras”) son
juegos que esperan que el jugador mueva una figura a través de un mundo,
que generalmente es bidimensional y se ve desde el lado, mientras salta sobre
y sobre cosas.
El juego
Nuestro juego estará basado aproximadamente en Dark Blue (www.lessmilk.com/
games/10) de Thomas Palef. Elegí ese juego porque es entretenido, minimalista
y se puede construir sin mucho código. Se ve así:
261

-- 273 of 445 --

La caja oscura representa al jugador, cuya tarea es recolectar las cajas amar-
illas (monedas) evitando las cosas rojas (lava). Un nivel se completa cuando se
han recolectado todas las monedas.
El jugador puede moverse con las teclas de flecha izquierda y derecha y
puede saltar con la tecla de flecha hacia arriba. Saltar es una especialidad de
este personaje del juego. Puede alcanzar varias veces su altura y puede cambiar
de dirección en el aire. Esto puede no ser del todo realista, pero ayuda a darle
al jugador la sensación de tener un control directo sobre el avatar en pantalla.
El juego consiste en un fondo estático, dispuesto como una rejilla, con los
elementos móviles superpuestos en ese fondo. Cada campo en la rejilla está
vacío, sólido o es lava. Los elementos móviles son el jugador, las monedas y
ciertas piezas de lava. Las posiciones de estos elementos no están restringidas a
la rejilla: sus coordenadas pueden ser fraccionarias, permitiendo un movimiento
suave.
La tecnología
Usaremos el DOM del navegador para mostrar el juego y leeremos la entrada
del usuario manejando eventos de teclado.
El código relacionado con la pantalla y el teclado es solo una pequeña parte
del trabajo que necesitamos hacer para construir este juego. Dado que todo se
ve como cajas de colores, dibujar es sencillo: creamos elementos del DOM y
usamos estilos para darles un color de fondo, tamaño y posición.
Podemos representar el fondo como una tabla ya que es una cuadrícula in-
mutable de cuadrados. Los elementos de movimiento libre se pueden super-
poner utilizando elementos posicionados absolutamente.
En juegos y otros programas que deben animar gráficos y responder a la en-
trada del usuario sin retrasos notables, la eficiencia es importante. Aunque el
DOM no fue diseñado originalmente para gráficos de alto rendimiento, en real-
idad es mejor en esto de lo que podrías esperar. Viste algunas animaciones en
el Capítulo 14. En una máquina moderna, un juego simple como este funciona
bien, incluso si no nos preocupamos mucho por la optimización.
En el próximo capítulo, exploraremos otra tecnología del navegador, la eti-
queta <canvas>, que proporciona una forma más tradicional de dibujar gráficos,
trabajando en términos de formas y píxeles en lugar de elementos del DOM.
262

-- 274 of 445 --

Niveles
Queremos una forma legible y editable por humanos para especificar niveles.
Dado que está bien que todo comience en una cuadrícula, podríamos usar
cadenas grandes en las que cada carácter represente un elemento, ya sea una
