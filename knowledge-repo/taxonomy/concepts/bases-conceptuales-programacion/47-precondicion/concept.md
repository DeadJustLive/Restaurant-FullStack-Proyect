# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 47)

## Contenido
# PRECONDICI´ON:

* la celda actual no es la esquina dada por los par´ametros
dirExterna y dirInterna (o sea, puede moverse en una de
las dos direcciones)
-}
{
if (puedeMover(dirInterna))
-- Todav´ıa quedan celdas en la fila (o columna) actual
{ Mover(dirInterna) }
else
{
-- Pasa a la siguiente fila (o columna)
Mover(dirExterna)
-- Vuelve al extremo opuesto de la fila (o columna)
-- para seguir desde ah´ı
IrAlExtremo(dirOpuesta(dirInterna))
}
}
Suponiendo que la dirExterna sea Norte y la dirInterna sea Este, el recorrido
se realiza primero en cada fila de Oeste a Este y las filas se recorren de Sur a
Norte. La precondici ´on indica que a ´un quedan celdas por recorrer; en caso de en-
contrarse en la esquina final, este procedimiento fallar ´a con un boom, cay ´endose
del tablero.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 150 of 312 --

151
Actividad de Programaci ´on 15
Realice el ejercicio 4.2.7 y coloque las operaciones all´ı solicitadas y
el c ´odigo del procedimiento AvanzarASiguienteDelRecorridoDeCeldas
en la Biblioteca.
Ejercicio 4.2.7. Definir un procedimiento IniciarRecorridoDeCeldas y una fun-
ci ´on esFinDelRecorridoDeCeldas que reciban como par ´ametros dos direcciones
y abstraigan adecuadamente las operaciones gen ´ericas de iniciar recorrido y ve-
rificar el fin de recorrido utilizadas en el c ´odigo de PintarTableroPorCeldasNE.
Actividad de Programaci ´on 16
Realice los ejercicios 4.2.8 y 4.2.9 y pru ´ebelos con varios colores y di-
recciones.
Ejercicio 4.2.8. Completar los procedimientos y funciones necesarios para com-
pletar el procedimiento PintarTableroPorCeldasNE.
Ejercicio 4.2.9. Realizar un procedimiento PintarTableroPorCeldas que gene-
ralice el recorrido por celdas, tomando como par ´ametros las direcciones en las
que deben recorrerse las celdas. ¿Cu ´al ser ´a la precondici ´on de este procedi-
miento?
Si pensamos en variaciones de los recorridos gen ´ericos, vemos que el recorrido no tiene
por qu ´e procesar todos los elementos. Por ejemplo, si consideramos que una columna es
un cantero, y queremos recorrer cada sector del cantero (representado cada uno con una
celda), colocando fertilizante (bolitas negras) solo en aquellos sectores donde haya flores
(bolitas rojas), el c ´odigo podr´ıa ser el siguiente
procedure FertilizarFlores()
