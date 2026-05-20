# K_A, K_SPACE

## Fuente
bases-conceptuales-programacion (Cap. 234)

## Contenido
# K_A, K_SPACE

-> { OperacionRotarPieza(False) -- Sentido antihorario }
_ -> { OperacionBajarPiezas() }
}
Podemos observar que los d´ıgitos sirven para ir completando el c ´odigo de selecci ´on en
la zona correspondiente, las flechas a izquierda y derecha sirven para mover las piezas
hacia los costados, la flecha hacia abajo hace descender la pieza un lugar y la flecha para
arriba permite colocar una nueva pieza en el tablero. Las teclas de ENTER y espacio se
usan para rotar las piezas en sentido horario y antihorario respectivamente, y las teclas de
ESCAPE, DELETE y BACKSPACE vac´ıan la zona de selecci ´on. Todas las teclas especia-
les (flechas y comandos) tienen su contraparte en forma de letras. Cualquier tecla que se
toque que no figure entre las especificadas provocar ´a el decenso de las piezas.
5.8. Ejercitaci ´on
Habiendo completado la codificaci ´on b ´asica del juego de ZILFOST, resulta interesante
mostrar la capacidad de realizar modificaciones que tiene un programador a mano, y c ´omo
los conocimientos impartidos en este libro sirven para tal prop ´osito. Para ello proponemos
una serie de cambios de diferente complejidad que permitir ´an practicar las habilidades
obtenidas. Al realizar estos cambios seguramente ser ´a necesario ir haciendo ajustes en el
c ´odigo que se va escribiendo, puesto que al realizar modificaciones que requieren alterar
diversas partes del c ´odigo es com ´un olvidar alguna y tener que irlas corrigiendo a medida
que se descubren.
El primero de los cambios propuestos es sencillo: modificar el momento en el que
las piezas bajan. En el c ´odigo que presentamos en el anexo B, las piezas bajan des-
pu ´es de que se completa el ingreso de un c ´odigo de selecci ´on. Sin embargo, esta opci ´on
puede ser f ´acilmente cambiada modificando los lugares donde aparece la invocaci ´on a
BajarPiezasDeZonaDeJuego.
Actividad de Programaci ´on 9
Realice el ejercicio 5.8.1 y codif´ıquelo en una copia del c ´odigo, as´ı puede probar
ambas versiones por separado y comprarlas.
Ejercicio 5.8.1. Modificar el c ´odigo del ZILFOST de manera que en lugar de que las pie-
zas bajen despu ´es de completar el ingreso del c ´odigo de selecci ´on, lo hagan despu ´es
de cada movimiento de pieza (rotar, mover a izquierda o derecha o ingresar una nueva
pieza).
Como dijimos, es un ejercicio sencillo, puesto que no involucra modificar ninguna de las
operaciones de base, sino solamente las operaciones de interacci ´on (de la secci ´on B.6
del anexo B).
El siguiente cambio tiene una complejidad apenas mayor. Consiste en modificar las
primitivas que establecen el formato del tablero, de tal manera de lograr que la zona de
semilla ocupe solo el ancho de la zona de juego, y las zonas de n ´umeros del sector
de datos est ´en m ´as abajo, de manera tal que la zona de pr ´oxima pieza se encuentre a
continuaci ´on de la zona de semilla, hacia la izquierda.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 230 of 312 --

231
Actividad de Programaci ´on 10
Realice el ejercicio 5.8.2 y pru ´ebelo en el c ´odigo del ZILFOST. Recuerde que
para este ejercicio debe modificar los tableros iniciales que tuviera guardados
ya que si no lo hace, no se cumplir´ıan las precondiciones correspondientes y el
programa fallar´ıa. ¡Y recuerde cambiar todos los comentarios correspondientes!
Ejercicio 5.8.2. Realizar los cambios de codificaci ´on necesarios para lograr que la zona
de semilla sea solo tan ancha como la zona de juego, la zona de c ´odigo de pr ´oxima pieza
est ´e a la izquierda de la de semilla y la zona de c ´odigo de selecci ´on de pieza siga estando
justo arriba de la zona de c ´odigo de pr ´oxima pieza.
Ayuda: el procedimiento IrAlOrigenDeZonaDeProximaPieza es el ´unico que requiere
modificaciones.
La complejidad de este cambio reside en que se est ´an modificando las propiedades que
el tablero debe cumplir para representar a un juego v ´alido, y por ello, las operaciones de
base, lo cual requiere modificar la totalidad de los tableros preexistentes para adaptarlos
a este nuevo uso. En particular, hay que preservar las propiedades de las zonas de n ´ume-
ros, acerca de la forma de codificar sus l´ımites. Estos cambios no deber´ıan repercutir de
ninguna manera en las operaciones de m ´as alto nivel del juego (las que tienen que ver
con piezas, movimientos o interacci ´on).
Una cambio de complejidad media consiste en agregar el c ´odigo necesario para que
la pr ´oxima pieza que vaya a ser colocada en la zona de juego se muestre previamente en
la zona de datos. Se plantea en varios ejercicios, para ir guiando la soluci ´on.
Actividad de Programaci ´on 11
Realice los ejercicios desde el ejercicio 5.8.3 hasta el ejercicio 5.8.6 y pru ´ebelos.
Recuerde utilizar una copia del c ´odigo del ZILFOST, para poder comparar ambas
versiones.
Ejercicio 5.8.3. Escribir un procedimiento IrAZonaDeEsperaProximaPieza que se ubique
en la zona de datos en el lugar elegido para visualizar la pr ´oxima pieza.
Para este ejercici
