# SUPOSICI´ON:

* las celdas de la columna actual no contienen
bolitas azules
-}
{
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 168 of 312 --

169
-- Iniciar el recorrido
IrAlBorde(Norte)
maxCantidad := nroBolitas(Rojo)
movimientosAlMax := 0
cantMovimientos := 0
-- Falta procesar alguna celda?
while (puedeMover(Sur))
{
-- Se mueve y cuenta el movimiento
Mover(Sur)
cantMovimientos := cantMovimientos + 1
if (nroBolitas(Rojo) > maxCantidad)
{
-- Si ahora hay m´as, se reemplaza
-- el m´aximo recordado
maxCantidad := nroBolitas(Rojo)
movimientosAlMax := cantMovimientos
}
}
-- Procesamos la ´ultima celda por separado,
-- al finalizar el recorrido
if (nroBolitas(Rojo) > maxCantidad)
{
-- Si ahora hay m´as, se reemplaza
-- el m´aximo recordado
maxCantidad := nroBolitas(Rojo)
movimientosAlMax := cantMovimientos
}
-- Para finalizar el recorrido, marcamos la
-- celda que corresponde
IrAlExtremo(Norte)
MoverN(Sur, movimientosAlMax)
Poner(Azul)
}
En este c ´odigo podemos observar c ´omo se utilizan 3 variables para recordar, por un lado,
la m ´axima cantidad de bolitas vistas hasta el momento (variable maxCantidad), por otra
parte, la cantidad de movimientos necesarios hasta donde fue vista dicha cantidad (varia-
ble movimientosAlMax, que es similar a recordar qu ´e color es el que ten´ıa m ´as bolitas en
el primer ejemplo, pues se trata de un dato asociado al m ´aximo buscado), y finalmente, la
cantidad de movimientos hechos hasta el momento (variable cantMovimientos, necesaria
para saber cu ´anto nos movimos y poder recordarlo si es el m ´aximo). Al finalizar el reco-
rrido, en lugar de informar la cantidad de movimientos, se realiza el marcado de la celda
correspondiente, con base en la cantidad calculada. Se debe observar que a diferencia de
un recorrido de b ´usqueda, que finaliza apenas encuentra lo buscado, en este caso deben
procesarse todos los elementos, pues no se sabe de antemano cu ´al es el m ´aximo.
Un recorrido para calcular el m´ınimo elemento de una secuencia es exactamente igual
en estructura a uno de calcular el m ´aximo, solo que en lugar de recordar el mayor, se
recuerda el menor. Tener esto en cuenta al realizar los siguientes ejercicios.
Actividad de Programaci ´on 29
Realice los ejercicios 4.3.7 y 4.3.8, y pru ´ebelos adecuadamente.
Ejercicio 4.3.7. Definir un procedimiento IndicarPuntoDebil que marque con una ben-
gala (representada con una bolita azul) la celda en la que el enemigo es m ´as d ´ebil (haya
menor cantidad de enemigos, representados con bolitas rojas).
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 169 of 312 --

170
Sugerencia: realizar un recorrido por celdas (similar al visto en la forma mejorada de
BuscarInicioSendero), y durante este recorrido, recordar por separado los movimientos
al este y los movimientos al norte a hacer desde la esquina suroeste para llegar a dicha
celda (de manera similar a como se mostr ´o en MarcarCeldaConMaxBolitasEnColumna).
Ejercicio 4.3.8. Utilizando la representaci ´on del display de ecualizador del ejercicio 3.4.2,
realizar un procedimiento PosicionarseEnFrecuenciaMaxima que ubique al cabezal en la
base de la columna que tenga la frecuencia con mayor intensidad.
Otra forma de recorrido donde la capacidad de recordar valores es fundamental es cuando
se debe recorrer una secuencia pero no se deben procesar todos los elementos. Por
ejemplo, imaginemos que queremos colocar una progresi ´on de bolitas verde en n celdas,
tal que la cantidad de bolitas en cada celda sean solo los m ´ultiplos de 2 o de 3 (o sea, 2, 3,
4, 6, 8, 9, 10, 12, etc.). Entonces, podr´ıa usarse un recorrido con memoria de la siguiente
manera
procedure ProgresionVerdeDosOTres(n)