# OBSERVACIONES:

* si no hay pieza, entonces no hace nada
*/
{
if (esSeccionDeAlgunaPieza())
{
IrAPiezaSiExiste(leerCodigoDePiezaActual())
TransformarEnPisoPiezaActual(marca)
}
}
El procedimiento TransformarEnPisoPiezaActual trabaja de manera similar a los proce-
dimientos de ColocarPieza y QuitarPieza: determina la clase de la pieza, obtiene sus
direcciones y utiliza funciones auxiliares que completan el trabajo transformando cada
secci ´on de la pieza indicada por las direcciones obtenidas. El c ´odigo se omite pues es
pr ´acticamente id ´entico al de los otros procedimientos similares (con la excepci ´on de que
debe avisar si el piso debe transformarse marcado o no). El ´unico procedimiento que tiene
alguna variaci ´on es el de TransformarCeldaEnPiso, cuyo c ´odigo es el siguiente
procedure TransformarCeldaEnPiso(marca)
/*
PROP´OSITO: transforma en piso la celda actual
y agrega la marca si corresponde