# OBSERVACIONES:

* realiza una selecci´on alternativa en base al
tipo de pieza
*/
{
switch (tipoPieza) to
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 272 of 312 --

273
1 -> { (dirA,dirB,dirC1,dirC2)
:= diresDePiezaZ(rotPieza) }
2 -> { (dirA,dirB,dirC1,dirC2)
:= diresDePiezaI(rotPieza) }
3 -> { (dirA,dirB,dirC1,dirC2)
:= diresDePiezaL(rotPieza) }
4 -> { (dirA,dirB,dirC1,dirC2)
:= diresDePiezaF(rotPieza) }
5 -> { (dirA,dirB,dirC1,dirC2)
:= diresDePiezaO(rotPieza) }
6 -> { (dirA,dirB,dirC1,dirC2)
:= diresDePiezaS(rotPieza) }
_ -> { }
return (dirA,dirB,dirC1,dirC2)
}
//-----------------------------------------------------
function diresDePiezaClaseB(tipoPieza,rotPieza)
/*
PROP´OSITO: devolver las direcciones de una pieza
de clase B, ajustadas seg´un la rotaci´on