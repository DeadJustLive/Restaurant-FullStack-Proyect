# OBSERVACIONES:

* al bajar, se quita todo el piso de la fila
m´as al Norte
* el cabezal no se debe mover de la fila
actual (por lo que debe devolv´erselo a su
lugar al terminar)
* la variables desplazamiento guarda
cu´antos lugares debe volverse al Sur
* se estructura como un recorrido sobre
las filas arriba de la actual
*/
{
desplazamiento := 0
while (puedeMoverEnZonaDeJuego(Norte))
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 220 of 312 --

221
{
BajarFilaSuperior()
desplazamiento := desplazamiento + 1
Mover(Norte)
}
VaciarDePisoLaFilaActual()
MoverN(Sur, desplazamiento)
}
Para bajar la fila superior sobre esta, simplemente se recorren las celdas de la fila actual
de izquierda a derecha y se baja la celda al norte. Es un recorrido sencillo y se omite su
c ´odigo. El c ´odigo que s´ı se ofrece es el de procesar una celda, bajando la que est ´a sobre
ella, pues resulta interesante.
procedure BajarCeldaAlNorte()
/*