# PRECONDICIONES Y OBSERVACIONES:

* las mismas que para ColocarPieza
* las direcciones coinciden con el tipoPieza
*/
{
ColocarPivote(codPieza,tipoPieza,rotPieza)
ColocarSeccionDePiezaEn(codPieza,dirA)
ColocarSeccionDePiezaEn(codPieza,dirB)
ColocarSeccionDePiezaEn(codPieza,dirC)
}
Las operaciones de colocar secciones son similares a las de verificar si hay lugar, con la
excepci ´on que pueden asumir como precondici ´on que las celdas donde deben ubicarse
las secciones existen, lo cual simplifica un poco el c ´odigo.
procedure ColocarSeccionDePieza(codPieza)
/*
PROP´OSITO: coloca una secci´on de la pieza codPieza