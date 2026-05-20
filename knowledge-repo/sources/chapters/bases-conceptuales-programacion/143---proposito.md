# {- PROP´OSITO:

* colocar en la celda de la esquina suroeste, una bolita
del color de las que haya m´as en la celda actual
-}
{
colorAPoner := colorConMasCantidad()
IrALaEsquinaS()
Poner(colorAPoner)
}
donde la funci ´on colorConMasCantidad retorna el color del que hay m ´as bolitas en la celda
actual (y si hay m ´as de uno, retorna el menor de todos); esta funci ´on ser ´a definida m ´as
adelante. Se observa que el valor descrito por la variable colorAPoner es un color (pues
se usa como argumento del comando Poner). Tambi ´en pueden guardarse direcciones y
booleanos en variables, adem ´as de n ´umeros y colores.
Leer con Atenci ´on
En GOBSTONES las variables deben asignarse siempre con valores de un tipo
espec´ıfico (determinado por la primera asignaci ´on que se realice de la variable).
Hay lenguajes que permiten que las variables recuerden cualquier cosa, pero
otros que solo permiten que una variable guarde elementos de un ´unico tipo.
Estas diferencias exceden el alcance de este libro, pero es importante que al
aprender nuevos lenguajes se preste atenci ´on a esta clase de restricciones.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 159 of 312 --

160
Ahora bien, ¿qu ´e suceder ´a si se intenta usar una variable a la que no se le asign ´o ning ´un
valor? Sencillamente, eso provoca la autodestrucci ´on del cabezal. La forma m ´as com ´un
de cometer este error es equivocar el nombre de una variable (por ejemplo, si asignamos
colorAPoner y luego intentamos usar coloraPoner en el ejemplo anterior; observar que
en el primer caso la letra A es may ´uscula, y en el segundo, min ´uscula). Otra forma com ´un
es utilizar una variable fuera de la zona donde la misma tiene sentido (el alcance de la
variable, noci ´on que se definir ´a en breve). Finalmente, una forma m ´as compleja y sutil es
realizar una asignaci ´on en alguna de las ramas de un condicional, y olvidarlo en la otra.
Por ejemplo, supongamos que queremos enviar al cabezal a que encienda una luz roja
en la celda de la esquina suroeste (representando la luz con una bolita de ese color) si
el cultivo en la celda actual (representado tambi ´en con distintas bolitas) ha comenzado a
ponerse negro, y que encienda una luz verde en aquella esquina, si el cultivo se conserva
verde. El c ´odigo propuesto para esta tarea es
procedure AvisarEstadoDelCultivo()
{-