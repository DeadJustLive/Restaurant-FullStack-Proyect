# PRECONDICI´ON:

* hay 3 celdas lindantes al Norte
-}
{
hayEnemigos := False -- Al comienzo no sabemos si hay enemigos
foreach i in [1..3]
{ if(hayEnemigosAlEnRango(Norte, i))
{ hayEnemigos := True } -- Si ve un enemigo, lo recuerda!
}
return(hayEnemigos) -- Se retorna el booleano recordado
}
Podemos observar c ´omo se hace innecesaria la codificaci ´on con bolitas, gracias a que el
mecanismo de memoria provisto por las variables nos permite recordar si en alg ´un punto
de las celdas controladas encontramos enemigos. Tambi ´en podemos observar en este
ejemplo que la asignaci ´on recuerda un valor fijo (por ejemplo, en este caso, el False)
hasta la siguiente asignaci ´on, donde recuerda al nuevo valor (en este caso, el True).
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 163 of 312 --

164
Actividad de Programaci ´on 24
Realice los siguientes ejercicios, modificando adecuadamente los programas
que realiz ´o antes. Pruebe si las nuevas versiones funcionan de igual manera.
Ejercicio 4.3.2. Definir una funci ´on direccionDelEnemigo que cumpla el mismo prop ´osi-
to que el procedimiento CodificarDireccionDelEnemigo de la subsecci ´on 4.2.1 (o sea,
indicar la direcci ´on en la que se encuentra el enemigo), pero que en lugar de codificarlo
con bolitas, lo retorne como resultado.
Ayuda: considerar la utilizaci ´on de una variable para recordar en qu ´e direcci ´on se
encontr ´o al enemigo, y luego retornar el valor de dicha variable.
Ejercicio 4.3.3. Reescribir el procedimiento MoverASiguienteSector, del ejemplo del sen-
dero completado en el ejercicio 4.2.10, para utilizar variables en lugar de codificar las
direcciones con bolitas verdes. Para asegurarse que el cambio fue correcto, probar nue-
vamente el procedimiento PonerFloresEnSenderoSimple.
Ayuda: reemplazar CodificarDireccion(dir) por una asignaci ´on de dir a la varia-
ble dirSectorSig, y luego reemplazar DecodificarDireccion() por un comando simple
que utilice dicha variable.
El lenguaje GOBSTONES provee adem ´as de la asignaci ´on simple una forma de asignaci ´on
simult ´anea. Esta forma de asignaci ´on se utiliza exclusivamente con funciones que retor-
nan m ´ultiples resultados. El significado es el mismo que el de la asignaci ´on simple, con
(para lo cual simplemente indi-
can en el comando returnvarias
expresiones)
la ´unica salvedad que todas las variables involucradas toman valor al mismo tiempo. Por
ejemplo, se puede hacer una funci ´on que retorne simult ´aneamente la divisi ´on entera y el
resto de dividir dos n ´umeros
function divMod(n,m)
/*
PROP´OSITO: devolver simult´aneamente el resultado de la divisi´on
entera y el resto, al calcular n sobre m.
*/
{ return (n div m, n mod m) }
Observamos que en el return aparecen dos expresiones en lugar de una. Para poder
utilizar esta funci ´on se requiere de la asignaci ´on simult ´anea, como se observa en este
comando
(q,r) := divMod (23, 10)
Luego de esta asignaci ´on, el valor de la variable q ser ´a 2, y el de la variable r ser ´a 3.
Un punto de importancia con respecto a la asignaci ´on (sea esta simple o simult ´anea) es
que la misma variable puede asignarse varias veces a valores diferentes, dentro del mismo
procedimiento (pero NO dentro de la misma asignaci ´on simult ´anea). La correspondencia
entre la variable y un valor producida por cada asignaci ´on dura hasta que la siguiente
asignaci ´on es ejecutada. Esto hace que la utilizaci ´on de variables sea muy dependiente
del orden de ejecuci ´on. En la pr ´oxima subsecci ´on profundizaremos sobre este aspecto, al
complementar la herramienta de recorridos con la de variables.
4.3.2. Recorridos m ´as complejos
La idea de recorrido, presentada en la subsecci ´on 4.2.3 se ve potenciada al contar con la
posibilidad de recordar informaci ´on mediante el uso de variantes.
Actividad 25
Piense c ´omo escribir´ıa una funci ´on que cuente todas las bolitas de la fila actual.
La soluci ´on al problema planteado es utilizar un recorrido de totalizaci ´on o recorrido de
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 164 of 312 --

165
acumulaci ´on, una idea que podemos definir combinando recorridos y variables. Esta for-
ma de recorrido procesa una secuencia de elementos, acumulando el total de cierta infor-
maci ´on que cada elemento posee. Por ejemplo, si las celdas de la fila actual representan
a los productos de un changuito de supermercado, siendo la cantidad de bolitas azules el
precio a pagar por cada producto, y quisi ´eramos averiguar el precio total que deberemos
pagar por la compra, podr´ıamos utilizar el siguiente c ´odigo, que hace uso de una variable
libreta, donde llevamos la cuenta:
function valorTotalDeLaCompra()
{-