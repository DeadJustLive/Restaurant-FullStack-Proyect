# parte 2: , vemos que la misma tiene como precondici ´on que haya tantas celdas en

direcci ´on dir como la cantidad dada por n. Esto garantiza que la operaci ´on se
mueve exactamente n lugares o falla. Si en cambio hubier ´amos hecho la variante
donde el Mover interno se utiliza de manera segura, la operaci ´on habr´ıa sido total
pero no habr´ıa garant´ıas de que se movi ´o n lugares (ver el ejercicio 4.1.1).
Actividad 1
Realice el ejercicio 4.1.1 y compare su comportamiento con el procedi-
miento MoverN del ejercicio 3.1.3, parte 2.
Ejercicio 4.1.1. Realizar un procedimiento MoverNTotal que dados n de tipo
n ´umero y dir de tipo direcci ´on, se mueva n celdas en la direcci ´on dir, si puede,
o quede detenido en el borde, si hay menos de n celdas en dicha direcci ´on.
Ayuda: reemplace el comando Mover en el procedimiento MoverN por uno
llamado MoverSiSePuede que utilice una alternativa condicional para moverse
solamente en el caso de que sea posible.
Para Reflexionar
¿Es adecuado que el procedimiento para moverse n lugares nunca falle?
Reflexione sobre la importancia de que una operaci ´on cumpla con su
contrato, y la necesidad que tiene que ciertos requerimientos se cumplan
para poder hacerlo. Si en cambio no le ponemos condiciones, ¿c ´omo
podemos esperar que el procedimiento efectivamente cumpla?
Es muy com ´un que al comenzar a programar se intente construir todas ope-
raciones totales. El problema con esto es que en ese caso el prop ´osito de los
procedimientos constru´ıdos no es el mismo que el que se esperaba. Por ejem-
plo, el prop ´osito de MoverN es moverse una cierta cantidad dada de lugares; pero
si esto no es posible, ¡no queremos que se comporte de alguna otra manera! Es
mucho mejor que en ese caso el procedimiento falle, y la precondici ´on nos avise
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 132 of 312 --

133
de manera adecuada ese hecho, as´ı al utilizarlo en nuestro propio procedimien-
to podemos decidir si verificamos que haya lugar, si eso no hace falta porque
sabemos que lo habr ´a, o simplemente lo asumimos como v ´alido y lo ponemos
como parte de la precondici ´on de nuestro propio procedimiento. El procedimiento
MoverNTotal nunca falla, pero tampoco se mueve siempre la cantidad de luga-
res especificada, haciendo que sea compleja la verificaci ´on de cada uno de los
casos, dificultando de esa manera su reutilizaci ´on.
En conclusi ´on, cuando se trabaja con efectos no necesariamente uno quiere
cubrir todas las precondiciones de los comandos, sino que depende del problema
condicionar o no la ejecuci ´on un comando. Si nos queremos mover 8 celdas, el
prop ´osito es moverse las 8, y no “moverse tantas celdas como pueda con m ´aximo
8”, que es otro procedimiento con un prop ´osito distinto. Por eso la alternativa
depende del objetivo de los procedimientos y no se usa siempre para cubrir las
precondiciones de los comandos, aunque pueda hacerse as´ı.
Alternativas anidadas
Los comandos de alternativa condicional pueden anidarse (o sea, usar un con-
dicional en las ramas de otro), para tener diversas alternativas. Por ejemplo, su-
poner que el cabezal representa la posici ´on de nuestro ej ´ercito y se desea re-
presentar la siguiente acci ´on: si hay enemigos visibles, entonces nuestro ej ´ercito
debe intentar huir al Norte y en caso de no poder, debe esconderse; pero si no
hay enemigos, debe avanzar hacia el Este, y si no encuentra enemigos al llegar,
debe armar una trinchera, pero si los encuentra, debe atacarlos. El c ´odigo para
resolver este problema podr´ıa ser:
if (not hayEnemigosAca()) -- ’Aca’ es la celda inicial
{
Mover(Este) -- No hay enemigos, y puede avanzar
if (not hayEnemigosAca())
-- El nuevo ’Aca’ es la celda al Este de la inicial!!
{ ArmarTrinchera() }
else { Atacar() }
}
else
{ -- Hay enemigos, y debe huir o esconderse
if (elCaminoEstaDespejado(Norte)))
{ Mover(Norte) }
else { Esconderse() }
}
Leer con Atenci ´on
Observar que la precondici ´on de este programa es que la celda actual
no puede encontrarse en la fila m ´as al Este ni en la fila m ´as al Norte.
Tambi ´en que no hace falta conocer la implementaci ´on exacta de las fun-
ciones hayEnemigosAca, elCaminoEstaDespejado o de los procedimien-
tos ArmarTrinchera, Atacar, etc. para entender este c ´odigo (alcanza
con entender sus precondiciones y sus efectos).
Leer con Atenci ´on
Es importante observar que si bien el ejemplo ilustra la posibilidad de
anidar comandos condicionales, quedar´ıa de manera m ´as claro utilizan-
do procedimientos.
Con procedimientos, quedar´ıa de la siguiente manera
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 133 of 312 --

134
if (not hayEnemigosAca())
{ InvadirPosicionAlEste() }
else
{ HuirOEsconderse() }
donde los procedimientos utilizados expresan acciones condicionales
procedure InvadirPosicionAlEste()