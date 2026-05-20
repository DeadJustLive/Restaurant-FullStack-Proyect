# OBSERVACIONES:

* se estructura como un recorrido sobre las celdas
de la zona de juego
*/
{
IrAlOrigenDeZonaDeJuego()
while (not esFinDelRecorridoNEDeZonaDeJuego())
{
if (esPiso()) { MarcarElPiso() }
AvanzarEnRecorridoNEDeZonaDeJuego()
}
if (esPiso()) { MarcarElPiso() }
}
Las operaciones auxiliares de esta operaci ´on, al igual que las dem ´as operaciones sobre
el piso, son extremadamente sencillas y se dejan como ejercicio.
Actividad de Programaci ´on 7
Realice el ejercicio 5.5.1 y constate que las definiciones son correctas cotejando
con el c ´odigo del anexo B.
Ejercicio 5.5.1. Escribir las siguientes operaciones
1. funciones esPiso y hayPisoAl que detectan si hay una celda de piso (sin marcar) en
la celda actual, y en la celda lindante en la direcci ´on dada (suponiendo que existe),
respectivamente;
2. un procedimiento PonerPiso que ponga piso en la celda actual, suponiendo que
est ´a vac´ıa;
3. procedimientos MarcarPiso y DesmarcarPiso que marquen el piso (con 60 bolitas
azules) y lo desmarquen (suponiendo que est ´a marcado), respectivamente;
4. una funci ´on esCeldaDePisoMarcada que informa si la celda actual es una celda de
piso con marca.
El procedimiento IrACeldaDePisoMarcadaSiExiste consiste en un recorrido de b ´usqueda
sobre las celdas del piso, deteni ´endose o bien cuando se acaban las celdas (porque nin-
guna contiene marca) o bien cuando encuentra una celda marcada. El c ´odigo no reviste
ninguna complejidad y por lo tanto lo omitimos.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 216 of 312 --

217
El procedimiento ExtenderElPisoEnLaFilaBase consiste en un recorrido sobre las celdas
de la fila base de la zona de juego (la fila que contiene el origen de dicha zona), procesan-
do cada pieza con TransformarEnPisoSiEsPieza. En este caso no debe transformarse
en piso marcado porque se utiliza en ExtenderElPiso justo antes de marcarlo. Un pro-
blema que se presenta es que el procedimiento TransformarEnPisoSiEsPieza mueve el
cabezal de lugar y altera entonces el recorrido de las celdas de la base; por ello, se hace
necesario marcar el piso antes de transformar la pieza, y luego de haberla transformado
volver a esa marca. Sin embargo, dado que la celda actual del recorrido est ´a ocupada por
una pieza que va a ser reemplazada por piso, la marca no puede ser colocada en dicha
celda; para solucionar esto se marca en la celda inmediatamente inferior, que por tratarse
de la base, es una celda del borde del tablero. El c ´odigo es el siguiente
procedure ExtenderElPisoEnLaFilaBase()
/*
PROP´OSITO: analiza si hay piezas en la fila
base que puedan estar en el piso, y las
convierte en piso