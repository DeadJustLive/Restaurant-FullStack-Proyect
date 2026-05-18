# OBSERVACIONES:

* se marca con 7 bolitas rojas (verificar que
otras marcas no usen esta misma codificaci´on)
*/
{ if (nroBolitas(Rojo)>7) { SacarN(Rojo,7) } }
5.5.3. Extender el piso
Cuando las piezas no pueden bajar m ´as, se vuelven parte del piso. El piso se representa
con 8 bolitas azules. La operaci ´on de extender el piso controla todas las celdas de la zona
de juego, para verificar si contienen una pieza que debe transformarse en piso. Se utilizan
varias operaciones auxiliares para esta operaci ´on.
// procedure ExtenderElPiso()
// procedure MarcarTodasLasCeldasDelPiso()
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 214 of 312 --

215
// procedure ExtenderElPisoEnLaFilaBase()
// procedure MarcarLaPosicionDeBase()
// procedure IrAMarcaDePosicionDeBaseYDesmarcar()
// function esPiso()
// function hayPisoAl(dir)
// procedure PonerPiso()
// function esCeldaDePisoMarcada()
// procedure MarcarElPiso()
// procedure DesmarcarElPiso()
// procedure IrACeldaDePisoMarcadaSiExiste()
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
La operaci ´on de extender el piso es una de las m ´as complicadas del juego, ya que debe
detectar todas las piezas que est ´an en contacto con el piso y transformarlas a su vez en
piso (y si, luego de transformar una pieza, el nuevo piso est ´a a su vez en contacto con
otra pieza, esta ´ultima debe transformarse tambi ´en, y continuando si hay m ´as piezas en
contacto con esta, etc ´etera). Para esto se utiliza un mecanismo de marcas de la siguiente
manera: se marcan todas las piezas y luego se van procesando de a una; al transformar
en piso una pieza se la transforma en piso marcado, as´ı se garantiza que sus celdas a ´un
no han sido procesadas. El c ´odigo es el siguiente
procedure ExtenderElPiso()
/*
PROP´OSITO: analiza si hay nuevas posiciones que pueden
estar en el piso, y las convierte en piso