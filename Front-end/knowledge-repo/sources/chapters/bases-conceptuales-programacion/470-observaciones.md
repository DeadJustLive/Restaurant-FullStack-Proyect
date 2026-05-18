# OBSERVACIONES:

* se marca con 7 bolitas rojas (verificar que
otras marcas no usen esta misma codificaci´on)
*/
{ if (nroBolitas(Rojo)>7) { SacarN(Rojo,7) } }
B.5.3. Operaciones para extender el piso
/*=SECCI´ON 5.3=====================================*
* Procesamiento del juego (ExtenderElPiso) *
*=================================================*
// procedure ExtenderElPiso()
// procedure MarcarTodasLasCeldasDelPiso()
// procedure ExtenderElPisoEnLaFilaBase()
// procedure MarcarLaPosicionDeBase()
// procedure IrAMarcaDePosicionDeBaseYDesmarcar()
// function esPiso()
// function hayPisoAl(dir)
// procedure PonerPiso()
// function esCeldaDePisoMarcada()
// procedure MarcarElPiso()
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 291 of 312 --

292
// procedure DesmarcarElPiso()
// procedure IrACeldaDePisoMarcada()
//
// procedure TransformarEnPisoSiEsPieza(marca)
// procedure TransformarEnPisoPiezaActual(marca)
// procedure TransfPzClaseA(codPieza,tipoPieza,rotPieza
// ,dirA,dirB,dirC1,dirC2, marca)
// procedure TransfPzClaseB(codPieza,tipoPieza,rotPieza
// ,dirA,dirB,dirC, marca)
// procedure TransformarCeldaEnPiso(marca)
// procedure TransformarCeldaEnPisoAl(dir, marca)
// procedure TransformarCeldaEnPisoAlY(dir1,dir2, marca)
*===================================================*/
//-----------------------------------------------------
procedure ExtenderElPiso()
/*
PROP´OSITO: analiza si hay nuevas posiciones que pueden
estar en el piso, y las convierte en piso