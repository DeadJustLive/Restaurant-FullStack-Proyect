# OBSERVACIONES:

* la zona termina con 6 azules al Este y Oeste
*/
{ return(nroBolitasAl(Azul,dir)/=6) }
Observar c ´omo se establece la precondici ´on de manera que el c ´odigo tenga sentido. Esta
precondici ´on deber ´a garantizarse cada vez que se invoque esta funci ´on.
La siguiente operaci ´on de movimiento consiste en el procedimiento para ir al borde de
la zona. Al igual que en el caso de la funci ´on anterior, supondremos como precondici ´on
que la direcci ´on es Este u Oeste y que la celda actual est ´a dentro de una zona de n ´umeros.
El c ´odigo entonces es simplemente un recorrido de b ´usqueda
procedure IrAlBordeDeZonaDeNumeros(dir)
/*