# PRECONDICI´ON:

* hay una celda al Este
-}
{
Mover(Este)
if (not hayEnemigosAca())
{ ArmarTrinchera() }
else
{ Atacar() }
}
procedure HuirOEsconderse()