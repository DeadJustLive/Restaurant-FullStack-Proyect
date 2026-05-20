# OBSERVACIONES:

* el piso se indica con 8 bolitas azules
*/
{
QuitarSeccionDePiezaActual()
PonerPiso()
if (marca) { MarcarElPiso() }
}
La ´ultima acci ´on luego de extender el piso es eliminar las filas que hayan quedado llenas.
Esta operaci ´on se describe a continuaci ´on.
5.5.4. Eliminar filas llenas
Una vez que todas las piezas que deb´ıan transformarse en piso lo hicieron, puede resultar
que alguna de las filas de piso quede llena. Una de las reglas del ZILFOST es que las filas
llenas desaparecen, haciendo que las restantes celdas de piso desciendan un lugar (pero
no as´ı las piezas). El prop ´osito del procedimiento EliminarFilasLlenas es exactamente
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 218 of 312 --

219
el de hacer desaparecer todas las filas de piso llenas que haya en la zona de juego. Para
su tarea utiliza varias operaciones auxiliares.
// procedure EliminarFilasLlenas()
// procedure EliminarMientrasSigaLlena()
// function esFilaLlena()
// procedure BajarFilasSobreEsta()
// procedure BajarFilaSuperior()
// procedure VaciarDePisoLaFilaActual()
// procedure QuitarPiso()
El c ´odigo de EliminarFilasLlenas se estructura como un recorrido de las filas de la zona
de juego, desde el sur hacia el norte. Cuando encuentra una fila llena, baja todas las
superiores sobre ella y contin ´ua bajando hasta que la fila actual no est ´a m ´as llena. El
c ´odigo es entonces bastante directo
//----------------------------------------------------
procedure EliminarFilasLlenas()
/*