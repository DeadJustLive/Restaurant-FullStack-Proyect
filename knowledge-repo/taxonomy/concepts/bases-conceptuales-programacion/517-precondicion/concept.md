# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 517)

## Contenido
# PRECONDICI´ON:

* que haya una celda al Este
-}
{
DibujarSombra(nroBolitas(Azul) + nroBolitas(Negro)
+ nroBolitas(Rojo) + nroBolitas(Verde))
}
Sin embargo, la expresi ´on que utilizamos, que suma los 4 usos de la funci ´on
primitiva nroBolitas, es demasiado larga; podr´ıa decirse que es “operacional”
en el sentido que no abstrae el concepto de contar el total de bolitas, sino que lo
descompone en operaciones m ´as elementales que deben combinarse.
As´ı como un procedimiento es una forma de dar nombre a un grupo de co-
mandos, existe un mecanismo para darle nombre a un grupo de expresiones,
abstrayendo su comportamiento. Tal mecanismo es conocido con el nombre de
funci ´on. Una funci ´on simple es b ´asicamente otra forma de nombrar a una expre-
si ´on compuesta.
Definici ´on 3.2.3. Una funci ´on simple es una forma de asignar un nombre a una
expresi ´on. La forma de definir una funci ´on simple en GOBSTONES es
function < funcName >()
{
return(< expresion >)
}
siendo < funName > un identificador que comienza con min ´uscula y < expresion >,
una expresi ´on de cualquier tipo b ´asico.
La operaci ´on de return de la declaraci ´on de una funci ´on indica la expresi ´on que
la misma representa.
Leer con Atenci ´on
Las funciones se pueden invocar de manera similar a un procedimiento
con la diferencia de que, como representan a un valor, deben utilizar-
se como cualquier expresi ´on (y no como un comando). Por ejemplo, un
llamado de funci ´on puede ser usado como argumento, o combinado en
expresiones complejas, etc., pero nunca secuenciada o como parte ais-
lada en un bloque.
Definici ´on 3.2.4. Una funci ´on simple puede ser usada como una expresi ´on. La
forma de invocarla es escribir su nombre seguida por par ´entesis, de la siguiente
manera
< funcName >()
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 117 of 312 --

118
donde < funcName > es el nombre de alguna funci ´on declarada en el programa.
En el ejemplo visto antes, podr´ıamos definir una funci ´on simple para calcular el
n ´umero total de bolitas de la celda actual de la siguiente manera.
function nroBolitasTotal()
