# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 33)

## Contenido
# PRECONDICI´ON:

* d1 y d2 no pueden ser direcciones opuestas
-}
{
while (puedeMover(d1) && puedeMover(d2))
{ Mover(d1); Mover(d2) }
}
Observar que la condici ´on establece que el valor de los par ´ametros debe ser tal
que no sean direcciones opuestas. Si las direcciones son opuestas (por ejemplo,
una es Norte y la otra es Sur), los efectos de ambos Mover se anular ´an, y la
repetici ´on no terminar ´a nunca, provocando la ejecuci ´on infinita. En cualquier otro
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 145 of 312 --

146
caso los efectos se ir ´an acumulando haciendo que a la larga se alcance una
esquina del tablero, por lo que el procedimiento se dentendr ´a.
Para controlar este poder de la repetici ´on condicional, presentamos a conti-
nuaci ´on la idea de recorrido.
4.2.3. Recorridos simples
La idea de recorrido es una herramienta conceptual que ofrece una forma de
ordenar los elementos en una repetici ´on condicional de manera de evitar los pro-
blemas m ´as comunes que aparecen al intentar utilizar este tipo de repetici ´on.
Creemos que es importante para comenzar a aprender que se respeten los es-
quemas brindados por esta herramienta, como forma de ordenar las ideas; cuan-
do esta forma fue completamente dominada es m ´as sencillo pasar a formas m ´as
libres y complejas de manejar de la repetici ´on condicional.
Es usual que muchas veces al pensar una tarea que involucra repetici ´on,
tengamos en mente alguna secuencia de elementos. Por ejemplo, si buscamos
procesar todas las celdas de una columna pintando cada una de ellas de un color
determinado, la secuencia en cuesti ´on es la secuencia de celdas de la columna
actual.
Actividad de Programaci ´on 10
Intente escribir el c ´odigo de un procedimiento PintarColumna que pinte
de un color dado todas las celdas de la columna. ¡El c ´odigo se ofrece a
continuaci ´on, pero es m ´as interesante si lo intenta solo primero y luego
contrasta su soluci ´on con la nuestra!
El programa pedido podr´ıa escribirse como:
procedure PintarColumna(color)
