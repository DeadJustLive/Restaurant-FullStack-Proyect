# PRECONDICI´ON:

* hay una celda lindante al Norte
-}
{
if (hayEnemigosAl(Norte))
{ AgregarAliados(nroEnemigosAl(Norte)+1) }
}
Observar que si bien la funci ´on nroEnemigosAl realiza un movimiento para retor-
nar la cantidad de enemigos en la direcci ´on dada, este movimiento no es refleja-
do por el procedimiento EstrategiaDeDefensa, que solo agrega los aliados en la
celda actual.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 124 of 312 --

125
Actividad de Programaci ´on 23
Realice los ejercicios 3.3.3 y 3.3.4, con el fin de completar el procedi-
miento anterior. Pruebe todos estos elementos en un programa sencillo
y verifique que efectivamente las funciones no producen ning ´un efecto.
Ejercicio 3.3.3. Escribir la funci ´on hayEnemigosAl que determina si hay enemi-
gos en la celda lindante en la direcci ´on dada. ¿Cu ´al es la precondici ´on de la
funci ´on?
Ejercicio 3.3.4. Escribir el procedimiento AgregarAliados que agrega tantos alia-
dos como el n ´umero indicado como par ´ametro.
Un procesamiento m ´as complicado puede lograrse mediante el uso de coman-
dos m ´as complejos, combinados con la idea de usar bolitas de alg ´un color para
indicar resultados de ´exito.
Por ejemplo, la siguiente funci ´on verifica si hay enemigos en alguna de las 3
celdas lindantes al Norte (supone el uso de una funci ´on hayEnemigosAlEnRango,
similar a la funci ´on hayEnemigosAl vista, pero agregando un par ´ametro num ´erico
para indicar el rango exacto donde deben buscarse enemigos).
function hayEnemigosCercaAlNorte()
{-