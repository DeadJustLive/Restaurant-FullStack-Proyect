# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 81)

## Contenido
# PRECONDICI´ON:

* ninguna, es una operaci´on total
-}
{
-- Iniciar el recorrido
IrAlExtremo(Norte)
maxCantidad := nroBolitas(Rojo)
-- Falta procesar alguna celda?
while (puedeMover(Sur))
{
Mover(Sur)
if (nroBolitas(Rojo) > maxCantidad)
{
-- Si ahora hay m´as, se reemplaza
-- el m´aximo recordado
maxCantidad := nroBolitas(Rojo)
}
}
-- Procesamos la ´ultima celda por separado,
-- al finalizar el recorrido
if (nroBolitas(Rojo) > maxCantidad)
{
-- Si ahora hay m´as, se reemplaza
-- el m´aximo recordado
maxCantidad := nroBolitas(Rojo)
}
-- Finalizar el recorrido
return (maxCantidad) -- Se informa al terminar
}
Aqu´ı podemos observar que como los elementos a recorrer son celdas, entonces debe-
mos usar una repetici ´on condicional, y puesto que la pregunta para seguir es si se puede
mover, el ´ultimo elemento debe procesarse por separado. Sin embargo, el procesamiento
del elemento actual sigue el mismo principio que en el recorrido anterior, para calcular el
m ´aximo.
Pero si en lugar de querer saber la cantidad, quisi ´eramos saber de qu ´e celda se trata
(por ejemplo, para marcarla con bolitas de color Azul), deber´ıamos recordar la cantidad
de veces que nos movemos y usar ese n ´umero al terminar el recorrido.
procedure MarcarCeldaConMaxBolitasEnColumna()
{-
