# OBSERVACI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 39)

## Contenido
# OBSERVACI´ON:

* se estructura como un recorrido por columnas
-}
{
-- va a la primera columna para saber que las hace todas
CabezalALaPrimeraColumna()
while (not llegoALaUltimaFila())
-- todav´ıa falta procesar columnas
{
PintarColumna(color) -- pintar columna de color
Mover(Este) -- pasar a la siguiente columna
}
-- pinta la ´ultima columna, pues no entr´o al while si
-- la columna era la ´ultima
PintarColumna(color)
}
Al igual que en PintarColumna, no es posible utilizar una repetici ´on indexada,
pues no se conoce de antemano el n ´umero de columnas. Adem ´as, se observa
que el esquema de resoluci ´on es el mismo: se comienza ubicando la primera
columna, y a partir de ah´ı se van pintando cada una de ellas (utilizando el pro-
cedimiento PintarColumna), hasta la ´ultima, que debe ser pintada de manera
separada pues la ´ultima columna no satisface la condici ´on del while.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 147 of 312 --

148
Actividad de Programaci ´on 12
Realice el ejercicio 4.2.6. Utilice el procedimiento
PintarTableroPorColumnas en un programa. ¡Recuerde incluir to-
do el c ´odigo en su programa!
Ejercicio 4.2.6. Completar el c ´odigo anterior. Para ello, debe escribir la funci ´on
llegoALaUltimaFila, que establece si el cabezal se encuentra en la fila m ´as al
Este (o sea, no puede moverse m ´as hacia el este) y tambi ´en el procedimiento
CabezalALaPrimeraColumna que lleva el cabezal a la primera columna del tablero
(similar al procedimiento CabezalATopeDeLaColumna).
Este esquema de repetici ´on donde se realiza una tarea para cada uno de una
serie de elementos se denomina recorrido, pues recorre la secuencia de ele-
mentos de a uno, procesando de alguna forma cada uno de ellos. Este concepto
est ´a basado en ideas tales como el uso de invariantes de ciclo [Mannila, 2010], la
idea de folds [Hutton, 1999] (especialmente foldr ) y generalizaciones asociadas
[Meijer et al., 1991], y el enfoque de esquemas b ´asicos de algoritmos [Scholl and
Peyrin, 1988]. Todos estos textos realizan presentaciones avanzadas de la idea
y son extremadamente interesantes, pero no son f ´aciles de comprender cuan-
do uno reci ´en comienza. Por eso, no debe asustarse si intenta mirarlos y no los
comprende; la programaci ´on abarca un mundo fascinante y vasto de ideas, que
no es f ´acil de dominar en poco tiempo.
El esquema que siguen todos los recorridos es el siguiente:
procedure RecorridoGenerico()
