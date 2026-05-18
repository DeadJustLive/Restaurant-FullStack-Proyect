# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 20)

## Contenido
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
