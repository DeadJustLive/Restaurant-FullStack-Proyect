# OBSERVACIONES:

* en rotaci´on 1, Z es
Norte,Oeste -> ZZ <- Norte
XZ <- Este
donde la X representa al pivote y
las Zs a las dem´as secciones
*/
{
(dA,dB,dC1,dC2) := id(Este,Norte,Norte,Oeste)
(dA,dB,dC1,dC2) := ajustarDires(dA,dB,dC1,dC2,rotPieza)
return (dA,dB,dC1,dC2)
}
Vemos que la primera l´ınea contiene las direcciones que codifican la pieza: Este para
una secci ´on, Norte para la segunda, y Norte y Oeste para la tercera. La funci ´on id re-
torna simplemente los 4 valores, y la usamos para poder usar la asignaci ´on simult ´anea.
La funci ´on ajustarDires se encarga de modificar las direcciones seg ´un la rotaci ´on. Las
restantes funciones espec´ıficas de clase A son similares y las omitiremos. Pero la funci ´on
espec´ıfica para la pieza de clase B, diresDePiezaT merece cierta atenci ´on.
function diresDePiezaT(rotPieza)
/*