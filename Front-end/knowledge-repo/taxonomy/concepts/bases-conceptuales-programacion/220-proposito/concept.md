# PROP´OSITO:

## Fuente
bases-conceptuales-programacion (Cap. 220)

## Contenido
# PROP´OSITO:

combinar las acciones necesarias para mover la
pieza indicada en la zona de selecci´on (si existe)
*/
{
IrAPiezaSiExiste(leerZonaDeSeleccion())
if (hayPiezaActual())
{ MoverPiezaActual(dir); ExtenderElPiso() }
BorrarZonaDeSeleccion()
}
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 226 of 312 --

227
Vemos que simplemente lee la zona de selecci ´on y utiliza el c ´odigo le´ıdo para ir a la
pieza con ese c ´odigo; si consigue llegar a esa pieza, entonces la mueve. Adem ´as, luego
de mover una pieza resulta necesario verificar si debe extenderse el piso. Finalmente, se
borra la zona de selecci ´on, forzando a que para cada movimiento de una pieza deba volver
a ingresarse su c ´odigo.
La operaci ´on de agregar d´ıgito a la selecci ´on utiliza la operaci ´on correspondiente de
la codificaci ´on del juego. La lectura de un c ´odigo en la zona de selecci ´on se realiza de a
un d´ıgito por vez, puesto que la interacci ´on que estamos considerando se realiza de a una
tecla por vez. Cuando los d´ıgitos completan un c ´odigo v ´alido, esta operaci ´on baja todas
las piezas.
procedure OperacionAgregarDigitoASeleccion(dig)
/*
