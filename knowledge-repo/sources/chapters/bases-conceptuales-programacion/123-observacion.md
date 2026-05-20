# OBSERVACI´ON:

* se estructura como un recorrido por celdas
-}
{
-- empieza arriba de todo para estar seguro
-- que las procesa todas
CabezalAlTopeDeLaColumna()
while (not llegoALaBase())
-- todav´ıa falta procesar celdas
{
PintarCeldaDe(color) -- procesar la celda
Mover(Sur) -- pasar a la siguiente celda
}
-- pinta la ´ultima celda, pues no entr´o al while
-- si la celda estaba en la base (y por lo tanto,
-- no la pint´o)
PintarCeldaDe(color)
}
Aqu´ı podemos observar varios puntos interesantes en referencia al uso de la re-
petici ´on condicional. El primero es que se comienza llevando el cabezal al tope
de la columna para asegurarse que todas las celdas resultar ´an pintadas. Otro
m ´as es que al finalizar el ciclo hace falta pintar la ´ultima celda a mano, pues el
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 146 of 312 --

147
pintar la celda dentro del ciclo no se realiza sobre la ´ultima celda (ya que desde
ella no se puede mover al Sur). Finalmente, vemos que dentro de la repetici ´on
hay una parte que procesa la celda actual, y otra que se ubica en el siguiente
elemento de la secuencia. Aparte, podemos observar el uso de todas las buenas
pr ´acticas de programaci ´on que venimos aprendiendo en los cap´ıtulos anteriores:
uso de procedimientos y funciones auxiliares para describir subtareas, comenta-
rios adecuados en el c ´odigo para remarcar los puntos interesantes, buen uso de
nombres, indentaci ´on para indicar la estructura del programa, etc ´etera.
Actividad de Programaci ´on 11
Realice el ejercicio 4.2.5. Pruebe el procedimiento PintarColumna
en un programa completo. Recuerde copiar el c ´odigo de
CabezalATopeDeLaColumna en su programa.
Ejercicio 4.2.5. Completar las operaciones llegoALaBase y PintarCeldaDe.
La funci ´on llegoALaBase verifica si el cabezal se encuentra en la base de la
columna, i.e. en la celda que se encuentra m ´as al Sur (o sea, no puede moverse
m ´as hacia el sur). El procedimiento PintarCeldaDe simplemente pone una o m ´as
bolitas del color indicado.
Esta forma de repetici ´on condicional aparece una y otra vez, seg ´un cual sea la
secuencia de elementos que consideremos. Por ejemplo, si en lugar de pintar una
columna de un color determinado, quisi ´eramos pintar todo el tablero, podr´ıamos
hacer un recorrido sobre todas las columnas, pintando cada una de ellas. El
procedimiento quedar´ıa muy parecido al de PintarColumna, pues la estructura
del problema es la misma:
procedure PintarTableroPorColumnas(color)