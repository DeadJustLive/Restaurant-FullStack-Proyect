# PROP´OSITO:

combinar las acciones necesarias para la aparici´on
de una nueva pieza en la zona de juego (si entra)
*/
{
semilla := leerSemilla()
(codPz,tipoPz,ubicPz,semilla) := determinarNuevaPieza(semilla)
GrabarSemilla(semilla)
ColocarNuevaPieza(codPz,tipoPz,ubicPz)
// Al exceder el m´aximo, vuelve a 1
IncrementarZonaDeProximaPieza()
BorrarZonaDeSeleccion()
}
Vemos que se utilizan las operaciones de leerSemilla de la zona de semilla para invocar
a la operaci ´on de determinarNuevaPieza, y de GrabarSemilla en dicha zona una vez
que se utiliz ´o la semilla y se tiene la nueva. Vemos tambi ´en que los datos obtenidos por
determinarNuevaPieza, accesibles a trav ´es de la asignaci ´on simult ´anea, se utilizan en la
operaci ´on de ColocarNuevaPieza. Finalmente se incrementa la cuenta de la cantidad de
piezas sobre el tablero y se borra la zona de selecci ´on. De esta manera, podemos ver que
modificando en el tablero inicial el n ´umero representado en la zona de semilla podemos
variar la secuencia de piezas que aparecen en el juego. Adem ´as vemos que luego de que
una nueva pieza es colocada, la zona de selecci ´on queda vac´ıa.
Las operaciones de movimiento y rotaci ´on de piezas utilizan el n ´umero codificado en
la zona de selecci ´on para determinar sobre qu ´e pieza del tablero deben trabajar, y luego
usan la operaci ´on correspondiente para hacerlo, suministrando los par ´ametros correspon-
dientes. El c ´odigo de ambas es muy similar; vemos solo la de mover pieza
procedure OperacionMoverPiezaAl(dir)
/*