# PRECONDICI´ON:

* Falsa: el programa jam´as termina, por lo que nunca
produce ning´un resultado
-}
{
QueresQueTeCuenteElCuentoDeLaBuenaPipa()
while (True)
{
YoNoDije_True_Dije_QueresQueTeCuenteElCuentoDeLaBuenaPipa()
}
}
Donde los dos procedimientos internos son cualesquiera que definan operacio-
nes totales. Es claro que como la condici ´on es siempre la misma (es independien-
te de la repuesta obtenida o del estado del tablero), este “cuento” seguir ´a para
siempre.
Esta capacidad de ejecutar infinitamente es equiparable a la autodestrucci ´on
del cabezal, en tanto y en cuanto no produce un tablero determinado. Sin embar-
go, su manifestaci ´on es diferente, pues se limita a mantener una apariencia de
trabajo cuando en realidad no hay ning ´un trabajo que termine dando beneficios. A
pesar de tener esta manifestaci ´on diferente, la precondici ´on de un procedimiento
debe incluir las condiciones para asegurar que todas las repeticiones condicio-
nales terminan. Por ejemplo, considerar el siguiente c ´odigo:
procedure MoverseHastaLaEsquina(d1, d2)