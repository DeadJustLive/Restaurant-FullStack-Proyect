# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 15)

## Contenido
# PRECONDICI´ON:

* hay 3 celdas lindantes al Norte
-}
{
SacarTodas(Azul) -- Elimina todas las bolitas azules,
-- para estar seguro que no hay ninguna
foreach i in [1..3]
{ if(hayEnemigosAlEnRango(Norte, i))
{ Poner(Azul) } -- Agrega una azul si hay enemigos
}
return(hayBolitas(Azul)) -- Si hay azules, es porque
-- uno de los rangos dio verdadero
}
Observar que se utilizan bolitas azules para indicar el ´exito de la b ´usqueda. Pues-
to que el procesamiento realizado por la funci ´on es solo simulado y no real, esta
modificaci ´on de las bolitas azules no ser ´a reflejada en el procedimiento que uti-
lice a hayEnemigosCercaAlNorte. En este ejemplo particular, la funci ´on podr´ıa
haberse escrito simplemente como
function hayEnemigosCercaAl()
{-
