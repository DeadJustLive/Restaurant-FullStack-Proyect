# OBSERVACIONES:

* no hace falta procesar el ´ultimo elemento pues
seguro est´a en la fila m´as al Norte y no puede
tener nada encima
* se estructura como un recorrido NE sobre celdas
* para cada celda de piso, se transforma la pieza
al Norte en piso (este nuevo piso puede producir
la transformaci´on de m´as celdas)
*/
{
ExtenderElPisoEnLaFilaBase()
MarcarTodasLasCeldasDelPiso()
IrACeldaDePisoMarcadaSiExiste()
while (esCeldaDePisoMarcada())
{
DesmarcarElPiso()
if (puedeMoverEnZonaDeJuego(Norte))
{
Mover(Norte)
TransformarEnPisoSiEsPieza(True)
//-^- Piso marcado
// La pieza se transforma en piso marcado!
// Esta operaci´on mueve el cabezal de lugar
}
IrACeldaDePisoMarcadaSiExiste()
}
EliminarFilasLlenas()
}
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 215 of 312 --

216
Antes de realizar el marcado de las celdas del piso, se procede a transformar las piezas
que est ´en en contacto con el borde Sur de la zona, ya que deben transformarse en piso
pero no necesariamente est ´an en contacto con alguna celda del piso. Para detectar si a ´un
hay celdas marcadas para recorrer se utiliza un esquema similar al que se us ´o para dete-
car si hay piezas marcadas bajables: se mueve a la pr ´oxima si existe antes de preguntar;
si pudo moverse a tal pieza, se ingresa en el cuerpo de la repetici ´on, y si no, quiere decir
que no hay m ´as celdas marcadas, por lo que debe terminar.
El procesamiento de una celda de piso marcada consiste en considerar la celda inme-
diatamente al norte de la misma, y transformar la pieza que pueda encontrarse all´ı en piso
(si existe). Esta pieza se debe transformar en piso marcado, para que dichas celdas sean
consideradas en posteriores iteraciones. El hecho de que el procedimiento de transformar
en piso una pieza desplace el cabezal no afecta el recorrido, pues el procedimiento de
pasar al siguiente busca cualquier celda con marca de piso que falte procesar.
El procedimiento MarcarTodasLasCeldasDelPiso consiste en un recorrido sobre las
celdas de la zona de juego, marcando cada una de las celdas que son del piso. Para
detectar esto utiliza la funci ´on esPiso y el procedimiento MarcarPiso. El c ´odigo es el
siguiente
procedure MarcarTodasLasCeldasDelPiso()
/*
PROP´OSITO: marca todas las celdas del piso en
la zona de juego