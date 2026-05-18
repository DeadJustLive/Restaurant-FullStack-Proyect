# OBSERVACIONES:

* este c´odigo fue copiado del art´ıculo "Functional
Programming with Overloading and Higher-Order
Polymorphism" de Mark Jones, publicado en "Advanced
Functional Programming", J.Jeuring y E.Meijer, editores,
LNCS 925, Springer Verlag, 1995.
* para usarlo correctamente, la nuevaSemilla debe ser
usada como siguiente semilla en posteriores llamados,
como en
semilla := 42
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 223 of 312 --

224
repeat(17)
{
(n,semilla) := randomEntre0YConSemilla(10,semilla)
PonerN(Verde,n)
Mover(Norte)
}
*/
{
nuevaSemilla := min_stand(semilla)
return(nuevaSemilla mod maximo, nuevaSemilla)
}
//----------------------------------------------------
function min_stand(semilla)
/*
PROP´OSITO: calcula un n´umero seudoaleatorio seg´un una
semilla dada