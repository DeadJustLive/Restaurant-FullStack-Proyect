# PRECONDICI´ON:

* ninguna, es una operaci´on total
-}
{
-- Inicializar el recorrido, recordando el
-- n´umero de bolitas del color m´ınimo
maxColor := minColor()
maxCant := nroBolitas(minColor())
-- Al recorrerse, puede usarse una repetici´on indexada
-- si se conocen todos los elementos a recorrer!
foreach colorActual in [siguiente(minColor())..maxColor()]
{
-- Procesar viendo si el actual es mayor
if (nroBolitas(colorActual) > maxCant)
{
maxColor := colorActual
maxCant := nroBolitas(colorActual)
}
-- Pasar al siguiente est´a impl´ıcito en el repeat!
}
-- Finalizar el recorrido, informando
return (maxColor)
}
Podemos observar varias cosas. La primera es que si conocemos todos los elementos a
recorrer, puede utilizarse una repetici ´on indexada en lugar de una condicional. La segunda
es que procesamos por separado el primer color, pues es necesario tener un valor inicial
para el m ´aximo posible. La tercera, y m ´as importante para nuestro ejemplo de recorrido
de c ´alculo de m ´aximo, es que son necesarias 2 variables: una para recordar el m ´aximo
n ´umero hasta el momento, y otra para recordar a qu ´e color correspond´ıa dicho n ´umero.
Definici ´on 4.3.5. Un recorrido de c ´alculo del m ´aximo (o m´ınimo) es un esquema de re-
corrido en el que se utiliza una variable para recordar el elemento de la secuencia que
tiene el valor m ´as grande (o m ´as chico) para cierta informaci ´on entre todos los elementos
de la secuencia. En esta variante, la subtarea de iniciar el recorrido incluye la conside-
raci ´on del valor del primer elemento record ´andolo como el m ´as grande (m ´as chico) visto
hasta el momento, la de procesar elemento actual incluye la comparaci ´on entre el valor
del elemento actual y el m ´aximo (m´ınimo) visto hasta el momento, y si corresponde, la
modificaci ´on del elemento recordado como m ´aximo (m´ınimo), y la de finalizar el recorrido
incluye la utilizaci ´on del valor m ´aximo (m´ınimo) obtenido.
Puede suceder que no nos interese el valor m ´aximo o m´ınimo obtenido, sino el elemento
que posee ese valor. En ese caso, deber ´an usarse variables adicionales para recordar
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 167 of 312 --

168
cu ´al fue el elemento que contribuy ´o a maximizar o minimizar la cantidad, y la modificaci ´on
acorde de las subtareas correspondientes.
Por ejemplo, si queremos saber cu ´al es el m ´aximo n ´umero de bolitas rojas de una cel-
da en la columna actual, usar´ıamos un recorrido sobre la columna de la siguiente manera:
function maxBolitasEnColumna()
{-