# PRECONDICI´ON:

* debe haber codificado un sendero simple en el tablero
-}
{
BuscarInicioSendero() -- iniciar recorrido
while (not esFinDelSendero())
-- no termin´o el recorrido
{
ColocarRosa() -- procesar elemento
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 153 of 312 --

154
MoverASiguienteSector() -- pasar al siguiente
}
ColocarRosa() -- finalizar recorrido
VolverAlInicio() -- "
}
Actividad de Programaci ´on 18
Pase el c ´odigo del procedimiento PonerFloresEnSenderoSimple, junto con to-
das sus partes (codificando las que faltan seg ´un el ejercicio 4.2.10), y pru ´ebelo
en el tablero de ejemplo mostrado en el gr ´afico G.4.3. El resultado deber´ıa verse
como el gr ´afico G.4.4, donde se puede observar que solo las celdas del sendero
tienen rosas.
Ejercicio 4.2.10. Escribir las operaciones
ColocarRosa,
esFinDelSendero,
BuscarInicioSendero,
VolverAlInicioDelSendero y
DecodificarDireccion (del procedimiento MoverASiguienteSector),
seg ´un las ayudas ofrecidas previamente. Una sutileza interesante es que en el caso del
procedimiento VolverAlInicioDelSendero, se deber´ıa considerar simplemente llamar a
BuscarInicioSendero, para no tener que rehacer aquella en caso de que esta ´ultima
cambie.
Una forma de mejorar la definici ´on de sendero es quitar la restricci ´on de que la celda
inicial se encuentre en la esquina suoreste. Al hacer esto, deberemos modificar el pro-
cedimiento BuscarInicioSendero para que sea un recorrido sobre todas las celdas del
tablero, buscando aquella que tenga exactamente 2 bolitas negras. Es interesante pensar
en un recorrido sobre todas las celdas que se detenga al encontrar la celda buscada. La
estructura ser´ıa la siguiente
procedure BuscarInicioSendero()
{-