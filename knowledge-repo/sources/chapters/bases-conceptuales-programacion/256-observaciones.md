# OBSERVACIONES:

* al bajar piezas se puede generar nuevo piso
y por eso se invoca a la operaci´on de extender
el piso
*/
{
UnicamenteBajarPiezas()
ExtenderElPiso()
}
La operaci ´on de bajar ´unicamente las piezas es bastante menos simple de lo que se
espera: debemos recorrer las piezas e irlas bajando, pero puede suceder que unas piezas
bloqueen temporariamente a otras. Entonces si hacemos un recorrido simple sobre las
piezas no obtendremos los resultados esperados: algunas piezas no habr ´an bajado a
pesar de poder hacerlo. En el gr ´afico G.5.4 puede observarse una cadena de piezas de
manera tal que si hacemos un ´unico recorrido noreste de la zona, solo bajar ´a la pieza m ´as
a la derecha, a ´un cuando ser´ıa esperable que bajasen todas juntas. No es soluci ´on utilizar
otros recorridos simples, porque simplemente podemos utilizar otras piezas sim ´etricas
para reproducir el problema. La soluci ´on es entonces bajar las piezas de a una, y marcar
las piezas para que no bajen m ´as de una vez. Se estructura como un recorrido sobre las
piezas no marcadas.
//-----------------------------------------------------
procedure UnicamenteBajarPiezas()
/*
PROP´OSITO: bajar un lugar todas las piezas que
pueden bajar