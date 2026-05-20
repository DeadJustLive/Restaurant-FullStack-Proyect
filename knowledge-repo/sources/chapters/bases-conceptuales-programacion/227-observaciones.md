# OBSERVACIONES:

* puede no haber lugar porque se acaba el tablero
o porque est´a ocupada
*/
{
if (esClaseA(tipoPieza))
{
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 201 of 312 --

202
(dirA,dirB,dirC1,dirC2)
:= diresDePiezaClaseA(tipoPieza,rotPieza)
hayL := hayLgPzClaseAEnDires(dirA,dirB,dirC1,dirC2)
}
else // Si no es clase A, es clase B
{
(dirA,dirB,dirC)
:= diresDePiezaClaseB(tipoPieza,rotPieza)
hayL := hayLgPzClaseBEnDires(dirA,dirB,dirC)
}
return (hayL)
}
Observar que la funci ´on simplemente decide, en base a la clase del tipo de pieza, cu ´al de
las funciones auxiliares debe usarse. Resulta entonces interesante mirar el c ´odigo de las
funciones auxiliares. Para la clase A tendremos el siguiente c ´odigo
function hayLgPzClaseAEnDires(dirA,dirB,dirC1,dirC2)
/*
PROP´OSITO: completar el trabajo de hayLugarParaPiezaTipo
para las piezas de clase A