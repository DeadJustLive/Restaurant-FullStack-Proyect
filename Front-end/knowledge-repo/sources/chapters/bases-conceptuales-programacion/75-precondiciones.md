# PRECONDICIONES:

* hay 2 celdas en la direcci´on indicada por dirDeLinea
*/
{
Mover(colorDeLinea); Poner(dirDeLinea)
Mover(colorDeLinea); Poner(dirDeLinea)
}
Podemos observar que este procedimiento tiene 2 par ´ametros: el primero es un
color para el comando Poner, y el segundo es una direcci ´on para el coman-
do Mover. Al invocarlo deben pas ´arsele, consecuentemente, 2 argumentos. Por
ejemplo, para dibujar el cuadrado rojo har´ıamos
procedure DibujarCuadradoRojoDeLado3()
/*