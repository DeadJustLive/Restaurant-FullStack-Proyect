# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 147)

## Contenido
# OBSERVACIONES:

* en rotaci´on 1, T es
Oeste -> TXT <- Este
T <- Sur
donde la X representa al pivote y
las Ts a las dem´as secciones
* se usa una direcci´on dD como dummy
para reutilizar ajustarDires
*/
{
(dA,dB,dC,dD) := id(Oeste,Este,Sur,Sur)
--^--DUMMY!!
(dA,dB,dC,dD) := ajustarDires(dA,dB,dC,dD,rotPieza)
return (dA,dB,dC)
}
A primera vista parece casi id ´entica a la anterior. Pero si recordamos bien, ¡para las piezas
de clase B bastaba con 3 direcciones! Sin embargo, estamos dando 4. . . Esto es as´ı para
proveer uniformidad en los accesos y poder reutilizar la funci ´on ajustarDires y tambi ´en
otras m ´as adelante. Sin embargo, la cuarta direcci ´on es innecesaria para el trabajo (en
ingl ´es se utiliza el t ´ermino dummy para indicar un valor que no se utilizar ´a). Puede obser-
En ingl ´es la palabra dummy usa-
da como adjetivo significa ficticio
y como sustantivo significa imi-
taci ´on. Sin embargo, el uso en
computaci ´on es m ´as bien t ´ecni-
co, y se utiliza para un valor que
no tiene significado alguno en el
c ´omputo (o sea, una imitaci ´on,
un valor ficticio.
varse que el valor de la variable dD NO se retorna.
Solo falta establecer el c ´odigo de las funciones id y ajustarDires. La primera de ellas
es extremadamente sencilla y solo sirve para retornar varios valores juntos (y deber ´a ser
usada en una asignaci ´on m ´ultiple)
function id(dA,dB,dC1,dC2)
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 198 of 312 --

199
/*
PROP´OSITO: retornar varios valores simult´aneamente
*/
{ return (dA,dB,dC1,dC2) }
La segunda requiere verificar cada una de las 4 rotaciones posibles, y alterar sus par ´ame-
tros de manera acorde con la rotaci ´on indicada.
function ajustarDires(dirA,dirB,dirC1,dirC2,rotPieza)
/*
PROP´OSITO: ajustar las direcciones en base a la rotaci´on
