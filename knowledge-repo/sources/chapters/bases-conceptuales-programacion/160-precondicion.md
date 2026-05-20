# PRECONDICI´ON:

* el fin del changuito est´a indicado con una celda sin
productos
-}
{
-- Iniciar el recorrido
libreta := 0 -- Preparar algo para llevar la cuenta
IrAlPrimerProducto() -- Ubicarse en el primer elemento
while (not finChango()) -- No se acabaron los productos
{
libreta := libreta + precioProducto()
-- Incorporar el precio actual a la
-- cuenta
PasarAlSiguienteProducto()
-- Pasar al siguiente
}
-- No hace falta procesar la ´ultima celda,
-- por la precondici´on
-- Finalizar el recorrido, informando el precio total
return (libreta)
}
La l´ınea m ´as interesante en este c ´odigo es la de la asignaci ´on dentro de la repetici ´on
condicional. Puede considerarse como la idea de leer lo que tenemos anotado en nuestra
libreta, sumarle a eso el precio del producto que estamos poniendo en el chango, y luego
anotar el resultado nuevamente en la libreta. Esta asignaci ´on funciona incrementando
el valor de la libreta con el precio del producto actual, y entonces se la suele llamar un
incremento de la variable. El inicio de recorrido debe asegurarse que la variable exista, y
como hasta el momento no se han visto productos, debe anotarse un 0 en la misma. Al
terminar el recorrido debe retornarse el valor anotado en la libreta, que ser ´a el del total de
la suma de todos los productos en el chango. La operaci ´on IrAlPrimerProducto debe ir al
borde Oeste de la fila, la operaci ´on finChango debe verificar que el cabezal se encuentra
en la fila de m ´as al Este, y la operaci ´on PasarAlSiguienteProducto debe moverse al
Este.
Definici ´on 4.3.4. Un recorrido de totalizaci ´on es un esquema de recorrido que utiliza va-
riables para acumular el total de cierta informaci ´on que posee cada elemento de la secuen-
cia. En esta variante de recorrido, la subtarea de iniciar el recorrido incluye la inicializaci ´on
de la variable de totalizaci ´on en 0, la subtarea de procesar elemento incluye la acumula-
ci ´on de la informaci ´on del elemento en dicha variable, y la subtarea de finalizar el recorrido
incluye la utilizaci ´on de la variable que contiene el total acumulado.
Es usual que los recorridos de totalizaci ´on se utilicen en funciones, puesto que de esta
forma la cantidad total se retorna como resultado de la funci ´on.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 165 of 312 --

166
(a). Tablero inicial
(b). Tablero final
G.4.6. Prueba de la funci ´on valorTotalDeLaCompra
Actividad de Programaci ´on 26
Pase el c ´odigo de la funci ´on valorTotalDeLaCompra, complete las operaciones
faltantes, y pruebe el c ´odigo, colocando tantas bolitas negras como el total de la
compra en la celda de la esquina suroeste. Podr´ıa quedarle un tablero como el
del gr ´afico G.4.6, donde se ven 7 productos (uno de los cuales es gratuito).
La idea de recorrido de totalizaci ´on se puede utilizar para cualquier tipo de elementos, y
para cualquier recorrido. Lo ´unico que precisa es inicializar una variable con 0, y luego, al
procesar cada elemento, agregar el valor de cada uno al total, incrementando la variable
en cuesti ´on.
Actividad de Programaci ´on 27
Realice los ejercicios 4.3.5 y 4.3.4, teniendo en cuenta en ambos casos la idea
de recorrido de totalizaci ´on. Pruebe los programas resultantes.
Ejercicio 4.3.4. Definir una funci ´on distanciaALaBase que cuente y retorne el n ´umero de
celdas que hay entre la celda actual y la base de la columna actual. Pensar en estructurarlo
como un recorrido de totalizaci ´on, donde cada celda tiene valor 1. Verificar que la cantidad
retornada sea exactamente la pedida, pues es com ´un retornar uno m ´as o uno menos que
Este error se denomina off-by-
one (en castellano se podr´ıa tra-
ducir como “errado-en-uno”), y
proviene del hecho de que el ca-
bezal se mueve menos veces de
las que debe contar.
el valor solicitado.
Ejercicio 4.3.5. Revisar la definici ´on de TotalizarFrecuenciaActual del ejercicio 3.4.2,
para rehacerla como un recorrido de totalizaci ´on sobre el valor de cada led.
Actividad de Programaci ´on 28
Realice el ejercicio 4.3.6 y coloque el c ´odigo resultante en la Biblioteca para
poder probarlo desde varios programas.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 166 of 312 --

167
Ejercicio 4.3.6. Definir una funci ´on medirDistanciaAlBorde que tome una direcci ´on y
cuente y retorne el n ´umero de celdas que hay entre la celda actual y el borde del tablero
en la direcci ´on dada. Para guiarse, considerar modificar la funci ´on del ejercicio 4.3.4 de
manera adecuada.
Una variante del recorrido de totalizaci ´on es la del recorrido que permite calcular el m ´axi-
mo o el m´ınimo de cierta cantidad. Para ello, se recuerda el m ´aximo visto hasta el mo-
mento en una variable, y al procesar cada elemento, se verifica si es mayor que el m ´aximo
guardado, y en caso de serlo, se lo reemplaza.
Por ejemplo, para verificar de cu ´al color hay m ´as bolitas en la celda actual, se puede
hacer un recorrido de c ´alculo de m ´aximo sobre colores.
function colorConMasCantidad()
{-