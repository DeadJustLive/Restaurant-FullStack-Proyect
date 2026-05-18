# PRECONDICIONES:

## Fuente
bases-conceptuales-programacion (Cap. 111)

## Contenido
# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* est´a en la zona de n´umeros donde debe grabarse
*/
{
BorrarZonaDeNumeros()
IrAlBordeDeZonaDeNumeros(Este)
aGuardar := numero
while (aGuardar > 0)
{
GrabarDigitoEnCelda(aGuardar mod 10)
aGuardar := aGuardar div 10
Mover(Oeste)
}
}
El procedimiento utiliza una operaci ´on auxiliar para grabar un d´ıgito en una celda, que se
deja como ejercicio.
Actividad de Programaci ´on 4
Relice el ejercicio 5.2.4. Constate con la implementaci ´on presentada en el
anexo B que su soluci ´on sea correcta.
Ejercicio 5.2.4. Escribir el procedimiento GrabarDigitoEnCelda que toma un n ´umero re-
presentando a un d´ıgito y codifica dicho d´ıgito en la celda actual. Puede asumir como
precondiciones que la celda est ´a vac´ıa y que el n ´umero recibido es efectivamente un d´ıgi-
to (un n ´umero entre 0 y 9).
Las operaciones para modificar las zonas de n ´umeros permiten en primer lugar borrar
cualquier n ´umero codificado en la zona, luego agregar un d´ıgito a la zona de izquierda a
derecha (que servir ´a para aceptar los d´ıgitos de a uno al ingresar un c ´odigo), y finalmente,
incrementar el n ´umero representado en la zona.
La operaci ´on de borrado de zona de n ´umeros simplemente debe recorrer cada celda
de la zona de n ´umeros, vaci ´andola. El c ´odigo resultante ser ´a
procedure BorrarZonaDeNumeros()
/*
