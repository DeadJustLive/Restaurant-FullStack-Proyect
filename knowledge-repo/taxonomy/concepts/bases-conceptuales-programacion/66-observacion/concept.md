# OBSERVACI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 66)

## Contenido
# OBSERVACI´ON:

* pretende mostrar lo que NO DEBE hacerse
-}
{
PonerN(cantRojas,Rojo)
-- cantRojas ES UNA VARIABLE SIN ASIGNAR!
-- (La asignaci´on de cantRojas en el otro
-- procedimiento no tiene validez en este)
}
La variable cantRojas asiganada con el n ´umero de bolitas rojas en el procedimiento
DuplicarRojasAlNorteMal, solo tiene alcance dentro del cuerpo de ese procedimiento (o
sea, solo tiene sentido utilizar dicha variable en ese procedimiento, y en ning ´un lugar m ´as).
Por ello, el uso de cantRojas en el procedimiento CompletarDuplicarRojasAlNorteMal
es incorrecto, puesto que no fue asignada ninguna variable con ese nombre. La forma
correcta de comunicar ambos procedimientos es utilizar un par ´ametro, de la siguiente
manera:
procedimiento DuplicarRojasAlNorteBien()
